package bahi.moein.omdb.ui.main

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import bahi.moein.omdb.data.local.DataBaseRepository
import bahi.moein.omdb.data.model.search.SearchWords
import bahi.moein.omdb.def.SearchType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Baharm MoeinPour <bahi2034@gmail.com>
 */

/**
 * ViewModel for MainActivity
 *
 * @property movieRepository
 */
@ExperimentalCoroutinesApi
@HiltViewModel
class MainViewModel @Inject constructor(private val movieRepository: DataBaseRepository) :
    ViewModel() {

    private val _search = MutableLiveData<Pair<String, @SearchType Int>>()
    val search: LiveData<Pair<String, Int>> = _search

    fun setCurrentSearch(search: Pair<String, @SearchType Int>) {
        _search.postValue(search)
        insertSearch(search.first, search.second)

    }

    private fun insertSearch(search: String, searchType: Int) {
        val searchedWords = SearchWords()
        searchedWords.searchedWords = search
        searchedWords.searchType = if (searchType == SearchType.MOVIE) "movie" else "series"
        viewModelScope.launch {
            movieRepository.saveSearchWords(searchedWords)
        }
    }

    val allWords: LiveData<List<SearchWords>>
        get() = movieRepository.allWords.flowOn(Dispatchers.Main)
            .asLiveData(context = viewModelScope.coroutineContext)


}
