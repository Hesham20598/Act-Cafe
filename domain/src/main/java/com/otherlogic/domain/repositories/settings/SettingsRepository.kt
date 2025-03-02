package com.otherlogic.domain.repositories.settings

interface SettingsRepository {
    suspend fun saveFirstRun(state: Boolean)
    suspend fun saveCartItemsCount(count: Int)
    suspend fun getCartItemsCount(): Int
    suspend fun getFirstRun(): Boolean
    suspend fun saveCurrentLanguage(language: String)
    suspend fun getCurrentLanguage(): String

}