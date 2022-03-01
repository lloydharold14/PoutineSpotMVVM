package com.tkhtech.favoritepoutinespotmapscompose.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoritePoutineSpotEntity(
    val lat: Double,
    val lng: Double,
    @PrimaryKey val id: Int? = null
) {
}