package com.test.premier.domain

import com.test.premier.PremierApp

data class Movie(val title: String, val text: String, val _image: String){
    val image: String
        get() = "${PremierApp.BASE_IMAGE_URL}$_image"
}