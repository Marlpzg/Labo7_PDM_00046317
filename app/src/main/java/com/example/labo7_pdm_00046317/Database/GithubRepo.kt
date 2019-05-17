package com.example.labo7_pdm_00046317.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repos")
data class GithubRepo(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String
) {}