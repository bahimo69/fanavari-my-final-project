package bahi.moein.omdb.di.module

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import bahi.moein.omdb.data.remote.api.OmdbiService
import bahi.moein.omdb.def.Const
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Baharm MoeinPour <bahi2034@gmail.com>
 */


@InstallIn(SingletonComponent::class)
@Module
class ApiModule {

    /**
     * Retrofit init
     */
    @Singleton
    @Provides
    fun provideRetrofitService(): OmdbiService = Retrofit.Builder()
        .baseUrl(Const.OMDB_API_URL)
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            )
        )
        .build()
        .create(OmdbiService::class.java)
}

