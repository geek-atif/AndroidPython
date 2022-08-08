package com.atifqamar.androidpython

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform


class MainActivity : AppCompatActivity() {
    lateinit var btHello : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initPython()
        initUI()
    }

    private fun initUI() {
        btHello = findViewById(R.id.btHello)
        btHello.setOnClickListener {
            callPythonFun()
        }
    }

    private fun initPython() {
        try {
            if (!Python.isStarted())
                Python.start(AndroidPlatform(this))
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    private fun callPythonFun() {
        val py = Python.getInstance()
        val pyObj = py.getModule("myScript")
        val message = pyObj.callAttr("getMessage", "Hello Python!")
    }
}