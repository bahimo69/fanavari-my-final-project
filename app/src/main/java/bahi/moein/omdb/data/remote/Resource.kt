package bahi.moein.omdb.data.remote

/**
 * Baharm MoeinPour <bahi2034@gmail.com>
 */

sealed class Resource<T> {
    class Success<T>(val data: T?) : Resource<T>()
    class Failed<T>(val message: String) : Resource<T>()
}
