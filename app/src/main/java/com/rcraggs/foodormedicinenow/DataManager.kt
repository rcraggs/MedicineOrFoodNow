package com.rcraggs.foodormedicinenow

object DataManager {

    private var _hoursBefore = 0

    var hoursBefore: Int
        get(){
            return this._hoursBefore
        }
        set(value){
            this._hoursBefore = value
        }
}