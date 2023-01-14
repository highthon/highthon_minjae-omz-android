package com.minjae.highthon.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OmzEntity(
    @PrimaryKey
    val data: Int
)
