package com.tkhtech.favoritepoutinespotmapscompose.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [FavoritePoutineSpotEntity::class],
    version = 1
)
abstract class FavoritePoutineSpotDatabase: RoomDatabase() {

    abstract val dao: FavoritePoutineSpotDao
}