package com.github.trendrepo.utils

import android.content.Context
import android.content.SharedPreferences

class SPUtils(val context: Context) {

    private val PREFS_NAME = "githubtrend"
    val sharedPref: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun save(KEY_NAME: String, text: Long) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putLong(KEY_NAME, text)
        editor!!.commit()
    }

    fun getValueLong(KEY_NAME: String): Long? {
        return sharedPref.getLong(KEY_NAME, 0)
    }

}