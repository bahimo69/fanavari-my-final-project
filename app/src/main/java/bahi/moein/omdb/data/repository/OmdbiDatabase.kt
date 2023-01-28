

package bahi.moein.omdb.data.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import bahi.moein.omdb.def.Const
import bahi.moein.omdb.data.local.dao.SearchWordsDao
import bahi.moein.omdb.data.local.dao.SearchResultDao
import bahi.moein.omdb.data.model.search.SearchWords
import bahi.moein.omdb.data.model.response.Search

/**
 * Baharm MoeinPour <bahi2034@gmail.com>
 */

/**
 * TODO
 * entities
 * SearchWords => It provides DAO for the search words
 * *Search => It provides DAO for the movie result
 */
@Database(
    entities = [SearchWords::class, Search::class],
    version = Const.DATABASE_VERSION
)

abstract class OmdbiDatabase : RoomDatabase() {
    /**
     * DAO for the search words
     * @return
     */
    abstract fun searchWordsDao() : SearchWordsDao


    /**
     * It provides DAO for the movie result
     * @return
     */
    abstract fun searchDao() : SearchResultDao

}
