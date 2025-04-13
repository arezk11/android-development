package com.seneca.onlinestore

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application) {
    fun updateLastProduct(newTitle: String, newDesc: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val last = dao.getLastProduct()
            if (last != null) {
                val updated = last.copy(title = newTitle, description = newDesc)
                dao.updateProduct(updated)
            }
        }
    }

    private val dao = ProductDatabase.getDatabase(application).productDao()
    val allProducts: LiveData<List<Product>> = dao.getAllProducts()

    fun insertProduct(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.insertProduct(product)
        }
    }

    fun deleteFirstProduct() {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteFirstProduct()
        }
    }
}
