package com.otherlogic.actcafe

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.util.Log
import java.util.Locale

object HelperClass {
    const val CURRENT_LANGUAGE = "current_language"
    const val IMAGE_URL = "https://myres.me/qr_menu/"
    fun getSavedLocale(context: Context): String {
        val sharedPreferences = context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        Log.e(
            "TAG",
            "getSavedLocale: ${
                sharedPreferences.getString(
                    CURRENT_LANGUAGE,
                    Locale.getDefault().language
                )
            }"
        )
        return sharedPreferences.getString(CURRENT_LANGUAGE, Locale.getDefault().language)
            ?: Locale.getDefault().language
    }

    fun Context.setLocale(language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = Configuration(resources.configuration)
        config.setLocale(locale)
        config.setLayoutDirection(locale) // Adjust layout direction
        resources.updateConfiguration(config, resources.displayMetrics)
//        val intent = (this as Activity).intent
//        this.finish()
//        this.startActivity(intent)
    }

    fun Context.getCurrentLocale(): Locale {
        val config = this.resources.configuration
        return config.locales[0] ?: Locale.getDefault()
    }
}