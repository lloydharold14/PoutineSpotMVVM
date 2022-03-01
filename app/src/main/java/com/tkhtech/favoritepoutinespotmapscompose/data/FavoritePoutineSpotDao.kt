package com.tkhtech.favoritepoutinespotmapscompose.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritePoutineSpotDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoritePoutineSpot(spot: FavoritePoutineSpotEntity)

    @Delete
    suspend fun deleteFavoritePoutineSpot(spot: FavoritePoutineSpotEntity)

    @Query("SELECT * FROM FavoritePoutineSpotEntity")
    fun getFavoritePoutineSpots(): Flow<List<FavoritePoutineSpotEntity>>
}