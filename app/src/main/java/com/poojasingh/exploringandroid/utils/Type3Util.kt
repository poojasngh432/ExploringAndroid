@file:JvmName("SaberUtils")
@file:JvmMultifileClass

/**
 * Now you can call SaberUtils.makeLightSaber() from Java code. But from Kotlin code it only allows to use makeLightSaber() method directly (without SaberUtils prefix), because it does not tie to any class.
 *
 */

fun makeLightSaberNow(powers: Int): String {
    return "here's your power"
}