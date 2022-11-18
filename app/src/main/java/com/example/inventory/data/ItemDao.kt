package com.example.inventory.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow


//class ini akan menjadi antarmuka kustom yang menyediakan
// metode praktis untuk melakukan kueri/mengambil, memasukkan,
// menghapus, serta memperbarui database.
@Dao
interface ItemDao {
//funtion untuk menambahkan item
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

//funtion untuk update 1 item
    @Update
    suspend fun update(item: Item)

//funtion untuk menghapus item
    @Delete
    suspend fun delete(item: Item)

//menambahkan query untuk mengambil data dari database
    @Query("SELECT * from item WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    @Query("SELECT * from item ORDER BY name ASC")
    fun getItems(): Flow<List<Item>>
}