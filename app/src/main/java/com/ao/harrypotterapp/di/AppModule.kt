package com.ao.harrypotterapp.di

import com.ao.harrypotterapp.data.dataSource.HarryPotterDataSource
import com.ao.harrypotterapp.data.repository.HarryPotterRepository
import com.ao.harrypotterapp.retrofit.ApiUtils
import com.ao.harrypotterapp.retrofit.HarryPotterDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideHarryPotterDataSource(dao: HarryPotterDao) = HarryPotterDataSource(dao)

    @Provides
    @Singleton
    fun provideHarryPotterRepository(dataSource: HarryPotterDataSource) = HarryPotterRepository(dataSource)

    @Provides
    @Singleton
    fun provideHarryPotterDao(): HarryPotterDao = ApiUtils.getHarryPotterDao()
}