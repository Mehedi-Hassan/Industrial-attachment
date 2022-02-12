package com.example.ia.network

import com.example.ia.model.Color

interface NetworkCallbackColor {
    fun getColor(colorList:List<Color>)
}