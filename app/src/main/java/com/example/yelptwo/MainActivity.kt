package com.example.yelptwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.yelptwo.api.RetrofitFactory
import com.example.yelptwo.api.RetrofitService
import com.example.yelptwo.api.RetrofitService.Companion.API_KEY

import com.example.yelptwo.databinding.ActivityMainBinding
import com.example.yelptwo.viewmodel.RestaurantViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    //viewmodel reference
    lateinit var viewModel:RestaurantViewModel

//    private val viewModel: RestaurantViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //set up viewbinding
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //set up viewModel
        viewModel = ViewModelProvider(this).get(RestaurantViewModel::class.java)

        binding.textviewTest.text = viewModel.word

        //reference to retrofit
        val service = RetrofitFactory.retrofitService

        //extra corotine
        lifecycleScope.launch(Dispatchers.IO){

        }

        //IO coroutine to call retrofit from
        CoroutineScope(Dispatchers.IO).launch {
            val ser=  service.searchRestuarants("Bearer $API_KEY", "avocado", "New York")


            val v = ser.body()


            Log.i(TAG, "onCreate 2: ${ser}")
            Log.i(TAG, "onCreate 2: ${ser.body()}")
            withContext(Dispatchers.Main){

            }
        }

//start of old method of calling retrofit.
//        val response = YelpApi.retrofitService.searchRestuarants("Bearer $API_KEY", "avocado", "New York").enqueue(object: Callback<Any>{
//                override fun onResponse(call: Call<Any>, response: Response<Any>) {
//
//                    Log.i(TAG, "onResponse: ${response}")
//                    Log.i(TAG, "onResponse: ${response.body()}")
//
//                }
//
//                override fun onFailure(call: Call<Any>, t: Throwable) {
//                }
//
//            })
//end


    }









}