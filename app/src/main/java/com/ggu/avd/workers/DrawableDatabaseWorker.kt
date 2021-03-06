package com.ggu.avd.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.ggu.avd.data.AppDatabase
import com.ggu.avd.data.AvdDrawable
import com.ggu.avd.utilities.DRAWABLE_DATA_FILENAME
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.coroutineScope

class DrawableDatabaseWorker(
    context: Context,
    workerParameters: WorkerParameters
) : CoroutineWorker(context, workerParameters){

    override suspend fun doWork(): Result = coroutineScope {
        try{
            applicationContext.assets.open(DRAWABLE_DATA_FILENAME).use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val drawableType = object : TypeToken<List<AvdDrawable>>(){}.type
                    val drawables : List<AvdDrawable> = Gson().fromJson(jsonReader, drawableType)

                    insertAll(drawables)

                    Result.success()
                }
            }
        } catch (ex:Exception){
            Result.failure()
        }
    }

    private suspend fun insertAll(drawables:List<AvdDrawable>){
        val database = AppDatabase.getInstance(applicationContext)
        database.drawableDao().insertAll(drawables)
    }

    companion object {
        private const val TAG = "DrawableDatabaseWorker"
    }
}