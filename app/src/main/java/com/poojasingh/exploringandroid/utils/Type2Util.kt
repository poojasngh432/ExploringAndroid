package com.poojasingh.exploringandroid.utils

/**
 * Singleton Pattern
 * - only once isntance of an object
 * - created the first time it's accessed, in a thread safe manner
 * - used as Type2Util.makeLightSaber(150)
 * Note
 * It’s fine when call this method from Kotlin, but when call from Java you need to add INSTANCE, because it’s just a normal method of singleton instance, not a static method.
 * // Call from Kotlin
Type2Util.makeLightSaber(150)
// Call from Java
Type2Util.INSTANCE.makeLightSaber(150)
 */

object Type2Util {

    fun makeLightSaber(powers: Int): String {
        return "shows power"
    }
}