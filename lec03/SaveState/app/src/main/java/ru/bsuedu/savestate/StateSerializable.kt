package ru.bsuedu.savestate

import java.io.Serializable

class StateSerializable(
    var value:String = "",
    var size:Float = 0F,
    var color:Int = 0 ,
): Serializable