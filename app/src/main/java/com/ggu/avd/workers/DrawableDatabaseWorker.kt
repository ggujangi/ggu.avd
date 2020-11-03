package com.ggu.avd.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.ggu.avd.data.AppDatabase
import com.ggu.avd.data.AvdDrawable
import com.ggu.avd.utilities.DRAWABLE_DATA_FILENAME
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.coroutineScope

const val KEY_RESULT = "result"

class DrawableDatabaseWorker(
    context: Context,
    workerParameters: WorkerParameters
) : CoroutineWorker(context, workerParameters){

    override suspend fun doWork(): Result = coroutineScope {
        try{
            applicationContext.assets.open(DRAWABLE_DATA_FILENAME).use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val drawableType = object : TypeToken<List<AvdDrawable>>(){}.type
                    val drawableList : List<AvdDrawable> = Gson().fromJson(jsonReader, drawableType)

                    val insert = insertAll(drawableList)

                    val output:Data = workDataOf(KEY_RESULT to insert)

                    Result.success(output)
                }
            }
        } catch (ex:Exception){
            Log.e(TAG, "Error drawable database", ex)
            Result.failure()
        }
    }

    private suspend fun insertAll(drawableList:List<AvdDrawable>){
        val database = AppDatabase.getInstance(applicationContext)
        database.drawableDao().insertAll(drawableList)

    }

    companion object {
        private const val TAG = "DrawableDatabaseWorker"
    }
}