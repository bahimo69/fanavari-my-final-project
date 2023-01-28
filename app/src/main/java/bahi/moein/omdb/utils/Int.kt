package bahi.moein.omdb.utils

import bahi.moein.omdb.def.Const

/**
 * Baharm MoeinPour <bahi2034@gmail.com>
 */

fun Int.getSearchType(): String {
    return if (this == 0) Const.MOVIE else Const.SERIES
}


