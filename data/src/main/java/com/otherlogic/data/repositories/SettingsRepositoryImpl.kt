package com.otherlogic.data.repositories

import android.content.SharedPreferences
import com.otherlogic.domain.repositories.SettingsRepository
import java.util.Locale
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : SettingsRepository {
    override suspend fun saveCurrentLanguage(language: String) {
        return sharedPreferences.edit().putString(CURRENT_LANGUAGE, language).apply()
    }

    override suspend fun getCurrentLanguage(): String {
        return sharedPreferences.getString(CURRENT_LANGUAGE, Locale.getDefault().language)
            ?: Locale.getDefault().language
    }

    companion object {
        const val FIRST_RUN = "first_run"
        const val CURRENT_LANGUAGE = "current_language"
    }

    override suspend fun saveFirstRun(state: Boolean) {
        return sharedPreferences.edit().putBoolean(FIRST_RUN, state).apply()
    }

    override suspend fun getFirstRun(): Boolean {
        return sharedPreferences.getBoolean(FIRST_RUN, true)
    }
}