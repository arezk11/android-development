package com.seneca.onlinestore

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProductDao {
    @Query("SELECT * FROM `product-details` ORDER BY id DESC LIMIT 1")
    suspend fun getLastProduct(): Product?

    @Update
    suspend fun updateProduct(product: Product)

    @Insert
    suspend fun insertProduct(product: Product)

    @Query("SELECT * FROM `product-details`")
    fun getAllProducts(): LiveData<List<Product>>

    @Query("DELETE FROM `product-details` WHERE id = (SELECT id FROM `product-details` LIMIT 1)")
    suspend fun deleteFirstProduct()
}
