package com.otherlogic.domain.repositories

interface SettingsRepository {
    suspend fun saveFirstRun(state: Boolean)
    suspend fun getFirstRun(): Boolean
    suspend fun saveCurrentLanguage(language: String)
    suspend fun getCurrentLanguage(): String

}