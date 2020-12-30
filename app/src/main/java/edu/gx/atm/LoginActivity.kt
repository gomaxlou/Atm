package edu.gx.atm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun login(view: View) {
        Log.d(getString(R.string.app_name), "Login")
        val userId = edUserId.text.toString()
        val password = edPasswd.text.toString()
        if (userId == "jack" && password == "1234") {
            Toast.makeText(this, "登入成功", Toast.LENGTH_LONG).show()
            intent.putExtra("userId", userId)
            intent.putExtra("password", password)
            setResult(RESULT_OK, intent)
            finish()
        } else {
            AlertDialog.Builder(this)
                .setTitle("ATM")
                .setMessage("登入失敗")
                .setPositiveButton("OK", null)
                .show()
        }
    }

    fun cancel(view: View) {
        Log.d(getString(R.string.app_name), "Cancel")
    }
}