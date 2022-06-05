package com.example.yelptwo.viewmodel

import androidx.lifecycle.ViewModel
import com.example.yelptwo.repository.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor( private val repository: RestaurantRepository): ViewModel() {

    val word = "list"


}