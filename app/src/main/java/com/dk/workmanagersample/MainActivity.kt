package com.dk.workmanagersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//예제를 위함
//        SimpleThread().start()
//        val workManagerA = OneTimeWorkRequestBuilder<WorkManagerA>().build()
//        WorkManager.getInstance(this).enqueue(workManagerA)

        val myData : Data = workDataOf(
            "a" to 10,
            "b" to 20
        )

        val workManagerB = OneTimeWorkRequestBuilder<WorkManagerB>().setInputData(myData).build()
        WorkManager.getInstance(this).enqueue(workManagerB)

        WorkManager.getInstance(this)
            .getWorkInfoByIdLiveData(workManagerB.id)
            .observe(this, Observer { info ->
                if(info != null && info.state.isFinished){
                    //WorkManager result 값이 10이기 때문에 결과도 10
                    val result = info.outputData.getInt("result", 10000)
                    //WorkManager reusult2 값이 없기 때문에 결과가 10000
                    val result2 = info.outputData.getInt("result2", 10000)
                    Log.d("MainActivity", result.toString())
                    Log.d("MainActivity", result2.toString())
                }
            })
    }
}

//예제를 위함
//class SimpleThread : Thread(){
//
//    override fun run() {
//        super.run()
//
//        for (i in 1..10) {
//            Log.d("MainActivity", "$i")
//            sleep(1000)
//
//        }
//    }
//}