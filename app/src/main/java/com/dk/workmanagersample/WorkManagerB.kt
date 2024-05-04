package com.dk.workmanagersample

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

/**
 * W데이터를 넘겨주는 역할
 */

class WorkManagerB(context: Context, workerParameters: WorkerParameters)
    : Worker(context, workerParameters) {

    override fun doWork(): Result {
        val a = inputData.getInt("a", 1000)
        val b = inputData.getInt("b", 2500)
        val c = inputData.getInt("C", 2700)
        Log.d("WM A", a.toString())
        Log.d("WM B", b.toString())
        Log.d("WM C", c.toString())

        val output : Data = workDataOf("result" to 10)

        return Result.success(output)
    }
}