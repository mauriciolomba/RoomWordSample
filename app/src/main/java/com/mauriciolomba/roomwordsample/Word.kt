package com.mauriciolomba.roomwordsample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Notação tableName -> Nome da tabela pode ser diferente do nome da Classe
@Entity(tableName = "word_table")
//@ColumnInfo(name = "word") Especifica o nome da coluna na tabela se você quiser que seja diferente do nome da variável de membro
class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String)