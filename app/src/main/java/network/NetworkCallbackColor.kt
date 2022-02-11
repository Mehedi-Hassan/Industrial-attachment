package network

import model.Color

interface NetworkCallbackColor {
    fun getColor(colorList:List<Color>)
}