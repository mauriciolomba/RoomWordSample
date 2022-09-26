package com.mauriciolomba.roomwordsample

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): Flow<List<Word>> //Use um valor de retorno do tipo Flow na descrição do método e o Room gerará todo o código necessário para atualizar o Flow quando o banco de dados for atualizado.

    //onConflict ignora uma nova palavra se ela for exatamente igual à que já está na lista
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}