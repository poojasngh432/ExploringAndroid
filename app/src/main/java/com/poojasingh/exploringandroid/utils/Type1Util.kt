package com.poojasingh.exploringandroid.utils

/**
 * Companion object is an object that tied to a class with companion keyword.
 * Companion object can be used to declare method to be tied to a class rather than to instances of it.
 * val util = Type1Util.makeLightSaber(150)
 */

class Type1Util {

    companion object Factory {

        fun makeLightSaber(powers: Int): String {
            return "powers"
        }
    }

}