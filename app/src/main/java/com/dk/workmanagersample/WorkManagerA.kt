package com.dk.workmanagersample

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * 앱이 완전히 종료된 이후에도 background 실행을 시키기 위한 WorkManager
 */
class WorkManagerA(context: Context, workerParameters: WorkerParameters)
    : Worker(context, workerParameters) {

    override fun doWork(): Result {
        for (i in 1..10) {
            Log.d("WorkManagerA", i.toString())
            Thread.sleep(1000)

        }
        return Result.success()
    }

}