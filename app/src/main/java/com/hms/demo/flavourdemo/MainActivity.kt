package com.hms.demo.flavourdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity(),TokenTask.TokenTaskListener {
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView=findViewById(R.id.textView)
        getToken()
    }

    private fun getToken() {
        Thread(TokenTask(applicationContext)).start()
    }

    override fun onToken(flavor: String, token: String) {
        runOnUiThread{
            textView.text="$flavor : $token"
        }
    }
}