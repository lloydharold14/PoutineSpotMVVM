package com.tkhtech.favoritepoutinespotmapscompose.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.MapStyleOptions
import com.tkhtech.favoritepoutinespotmapscompose.domain.model.FavoritePoutineSpot
import com.tkhtech.favoritepoutinespotmapscompose.domain.repository.FavoritePoutineSpotRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(

    private val repository: FavoritePoutineSpotRepository
) : ViewModel() {

    var state by mutableStateOf(MapState())

    init {
        viewModelScope.launch {
            repository.getFavoritePoutineSpots().collectLatest { spots ->
                state = state.copy(
                    favoritePoutineSpots = spots
                )

            }
        }
    }

    fun onEvent(event: MapEvent) {
        when (event) {
            is MapEvent.Togglefalloutmap -> {
                state = state.copy(
                    properties = state.properties.copy(
                        mapStyleOptions = if (state.isFalloutMap) {
                            null
                        } else MapStyleOptions(MapStyle.json),

                        ),
                    isFalloutMap = !state.isFalloutMap

                )
            }
            is MapEvent.onMapLongClick -> {
                viewModelScope.launch {
                    repository.insertFavoritePoutineSpot(
                        FavoritePoutineSpot(

                            event.latlng.latitude,
                            event.latlng.longitude

                        )
                    )
                }
            }

            is MapEvent.onIinfoWindowLongClick -> {
                viewModelScope.launch {
                    repository.deleteFavoritePoutineSpot(event.spot)
                }
            }
        }
    }
}