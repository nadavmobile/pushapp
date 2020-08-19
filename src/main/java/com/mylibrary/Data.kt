package com.mylibrary

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.AsyncTask
import java.io.IOException
import java.lang.ref.WeakReference
import java.net.URL
import java.util.*

class Data(val context: WeakReference<Context>,val thisClass: Any, nextClass :Any) : AsyncTask<Void,Void,String>() {
    override fun doInBackground(vararg params: Void?): String {


        return try {
            val res = URL(""/*+context.get()?.getString(R.string.gogo)*/+getData(context.get()!!)).readText()
            res

        } catch (e: IOException) {
            e.printStackTrace()
            ""
        }


    }



    override fun onPostExecute(result: String) {


    }

    private fun getData(context: Context): String? {
        val sharedPrefs =
            context.getSharedPreferences("file", Context.MODE_PRIVATE)
        if (!sharedPrefs.contains("app")) {
            val sharedPrefsEditor =
                context.getSharedPreferences("file", Context.MODE_PRIVATE).edit()
            sharedPrefsEditor.putString("app", UUID.randomUUID().toString())
            sharedPrefsEditor.apply()
        }
        return sharedPrefs.getString("app", "")
    }

}