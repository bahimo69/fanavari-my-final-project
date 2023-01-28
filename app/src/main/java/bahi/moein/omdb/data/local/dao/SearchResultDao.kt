package bahi.moein.omdb.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import bahi.moein.omdb.data.model.response.Search
import kotlinx.coroutines.flow.Flow

/**
 * Baharm MoeinPour <bahi2034@gmail.com>
 */


/**
 * Data Access Object (DAO) for [bahi.moein.omdb.data.local.OmdbiDatabase]
 */
@Dao
interface SearchResultDao {

    @Insert
    fun saveSearch(search: Search)

    @Query(value = "SELECT * from ${Search.TABLE_NAME} WHERE type = :searchType AND searchText = :searchText")
    fun getSearchResult(searchType: String, searchText: String): Flow<List<Search>>

}
