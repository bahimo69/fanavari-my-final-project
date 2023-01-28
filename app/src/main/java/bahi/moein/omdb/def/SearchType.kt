package bahi.moein.omdb.def

import androidx.annotation.IntDef

/**
 * Baharm MoeinPour <bahi2034@gmail.com>
 */

/**
 * Type Of search
 *
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@IntDef(SearchType.MOVIE, SearchType.SERIES)
annotation class SearchType {
    companion object {
        const val MOVIE = 0
        const val SERIES = 1
    }

}