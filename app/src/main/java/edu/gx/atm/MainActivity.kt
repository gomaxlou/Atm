package edu.gx.atm

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var login = false
    companion object {
        const val RC_LOGIN = 30
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!login) {
            Intent(this, LoginActivity::class.java).apply {
//                startActivity(this)
                startActivityForResult(this, RC_LOGIN)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_LOGIN && resultCode == RESULT_OK) {
            val userId = data?.getStringExtra("userId")
            val password = data?.getStringExtra("password")
            Log.d(getString(R.string.app_name), "$userId/ $password") // Atm: jack/ 1234
            edMessage.text = "Hello $userId"
        }
    }
}