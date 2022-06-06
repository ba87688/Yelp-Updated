package com.example.yelptwo.shared

import androidx.appcompat.widget.SearchView

class Utils {
}
inline fun SearchView.onQueryTextSubmit(crossinline listner:(String)->Unit){
    this.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
        override fun onQueryTextSubmit(query: String?): Boolean {
            if(!query.isNullOrBlank()){
                listner(query)
            }
            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            return true
        }

    })
}