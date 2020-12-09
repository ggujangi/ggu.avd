package com.ggu.avd.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.ggu.avd.data.AppDatabase
import com.ggu.avd.data.AvdType
import com.ggu.avd.utilities.TYPE_DATA_FILENAME
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.coroutineScope

class TypeDatabaseWorker(
    context: Context,
    workerParameters: WorkerParameters
) : CoroutineWorker(context, workerParameters){

    override suspend fun doWork(): Result = coroutineScope {
        try{
            applicationContext.assets.open(TYPE_DATA_FILENAME).use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val type = object : TypeToken<List<AvdType>>(){}.type
                    val types:List<AvdType> = Gson().fromJson(jsonReader, type)

                    insertAll(types)

                    Result.success()
                }
            }
        } catch (ex:Exception){
            Result.failure()
        }
    }

    private suspend fun insertAll(types:List<AvdType>){
        val database = AppDatabase.getInstance(applicationContext)
        database.drawableDao().insertTypes(types)
    }

    companion object {
        private const val TAG = "KeywordDatabaseWorker"
    }
}