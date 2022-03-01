package com.tkhtech.favoritepoutinespotmapscompose.di

import android.app.Application
import androidx.room.Room
import com.tkhtech.favoritepoutinespotmapscompose.data.FavoritePoutineSpotDatabase
import com.tkhtech.favoritepoutinespotmapscompose.data.FavoritePoutineSpotRepositoryImpl
import com.tkhtech.favoritepoutinespotmapscompose.domain.repository.FavoritePoutineSpotRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideFavoritePoutineSpotDatabase(app: Application): FavoritePoutineSpotDatabase {
        return Room.databaseBuilder(
            app,
            FavoritePoutineSpotDatabase::class.java,
            "poutine_spot.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideFavoritePoutineSpotRepository(db: FavoritePoutineSpotDatabase): FavoritePoutineSpotRepository {
        return FavoritePoutineSpotRepositoryImpl(db.dao)

    }
}