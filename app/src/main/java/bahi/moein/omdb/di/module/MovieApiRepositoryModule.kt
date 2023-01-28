package bahi.moein.omdb.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import bahi.moein.omdb.data.repository.DefaultOmdbiRepository
import bahi.moein.omdb.data.repository.OmdbiRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Baharm MoeinPour <bahi2034@gmail.com>
 */

@ExperimentalCoroutinesApi
@InstallIn(ActivityRetainedComponent::class)
@Module
abstract class MovieApiRepositoryModule {

    /**
     * Init Api Repository
     *
     * @param repository
     * @return
     */
    @ActivityRetainedScoped
    @Binds
    abstract fun bindMovieRepository(repository: DefaultOmdbiRepository): OmdbiRepository
}
