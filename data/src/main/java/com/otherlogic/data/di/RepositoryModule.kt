package com.otherlogic.data.di

import com.otherlogic.data.repositories.itemDetails.ItemDetailsRepoImpl
import com.otherlogic.data.repositories.menu.MenuRepoImpl
import com.otherlogic.data.repositories.settings.SettingsRepositoryImpl
import com.otherlogic.domain.repositories.itemDetails.ItemDetailsRepository
import com.otherlogic.domain.repositories.menu.MenuRepository
import com.otherlogic.domain.repositories.settings.SettingsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideSettingsRepository(impl: SettingsRepositoryImpl): SettingsRepository {
        return impl
    }

    @Provides
    @Singleton
    fun provideMenuRepository(impl: MenuRepoImpl): MenuRepository {
        return impl
    }

    @Provides
    @Singleton
    fun provideItemDetailsRepository(impl: ItemDetailsRepoImpl): ItemDetailsRepository {
        return impl
    }


}