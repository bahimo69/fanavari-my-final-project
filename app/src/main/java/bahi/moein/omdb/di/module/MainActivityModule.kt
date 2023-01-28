package bahi.moein.omdb.di.module

import android.content.Context
import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped
import bahi.moein.omdb.R
import bahi.moein.omdb.def.SearchType
import bahi.moein.omdb.ui.main.PagerAdapter
import bahi.moein.omdb.ui.main.fragment.MovieFragment
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

/**
 * Baharm MoeinPour <bahi2034@gmail.com>
 */

@Module
@InstallIn(ActivityComponent::class)
class MainActivityModule {


    /**
     * Init adapter for view pager
     *
     * @param context
     * @return
     */
    @ExperimentalCoroutinesApi
    @Provides
    @ActivityScoped
    fun provideAdapterFragmentState(@ActivityContext context: Context): PagerAdapter {
        return PagerAdapter(context,provideFragments(context))
    }



    /**
     * Init fragments for viewpager adapter
     *
     * @param context
     * @return
     */
    @ExperimentalCoroutinesApi
    @Singleton
    @Provides
    fun provideFragments(context: Context): ArrayList<Pair<Fragment, String>> {
        val fragments = ArrayList<Pair<Fragment, String>>()
        fragments.add(
            Pair(
                MovieFragment.newInstance(SearchType.MOVIE),
                context.getString(R.string.movie)
            )
        )
        fragments.add(
            Pair(
                MovieFragment.newInstance(SearchType.SERIES),
                context.getString(R.string.series)
            )
        )

        return fragments
    }
}