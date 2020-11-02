package com.ggu.avd.data

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.ggu.avd.utilities.DATABASE_NAME
import com.ggu.avd.workers.DrawableDatabaseWorker

@Database(entities = [MyDrawable::class, AvdDrawable::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun drawableDao() : AvdDao
    abstract fun myDrawableDao() : MyDao

    companion object{
        @Volatile private var instance : AppDatabase? = null

        fun getInstance(context : Context) : AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .addCallback(
                    object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            val request = OneTimeWorkRequestBuilder<DrawableDatabaseWorker>().build()
                            WorkManager.getInstance(context).enqueue(request)
                        }
                    }
                )
                .build()
        }
    }
}