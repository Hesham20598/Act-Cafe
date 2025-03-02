package com.otherlogic.data.repositories.settings

import android.content.SharedPreferences
import com.otherlogic.domain.repositories.settings.SettingsRepository
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
        const val CART_ITEMS_COUNT = "cart_items_count"
    }

    override suspend fun saveFirstRun(state: Boolean) {
        return sharedPreferences.edit().putBoolean(FIRST_RUN, state).apply()
    }

    override suspend fun saveCartItemsCount(count: Int) {
        sharedPreferences.edit().putInt(CART_ITEMS_COUNT, count).apply()

    }

    override suspend fun getCartItemsCount(): Int {
        return sharedPreferences.getInt(CART_ITEMS_COUNT, 0)
    }

    override suspend fun getFirstRun(): Boolean {
        return sharedPreferences.getBoolean(FIRST_RUN, true)
    }
}