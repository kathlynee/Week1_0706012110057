package com.example.week1_0706012110057

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week1_0706012110057.view.UserAdapter
import com.example.week1_0706012110057.model.UserData
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var addsBtn: FloatingActionButton
    private lateinit var recv: RecyclerView
    private lateinit var userList: ArrayList<UserData>
    private lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**set List*/
        userList = ArrayList()
        /**set find Id*/
        addsBtn = findViewById(R.id.addingBtn)
        recv = findViewById(R.id.mRecycler)
        /**set Adapter*/
        userAdapter = UserAdapter(this, userList)
        /**setRecycler view Adapter*/
        recv.layoutManager = LinearLayoutManager(this)
        recv.adapter = userAdapter
        /**set Dialog*/
        addsBtn.setOnClickListener { addInfo() }
    }


    private fun addInfo() {
        val inflter = LayoutInflater.from(this)
        val v = inflter.inflate(R.layout.add_item,null)
        /**set view*/
        val userName = v.findViewById<EditText>(R.id.userName)
        val userNo = v.findViewById<EditText>(R.id.userNo)
        val userType = v.findViewById<EditText>(R.id.userType)

        val addDialog = AlertDialog.Builder(this)

        addDialog.setView(v)
        addDialog.setPositiveButton("Ok"){
                dialog,_->
            val names = userName.text.toString()
            val type = userType.text.toString()
            val number = userNo.text.toString()
            userList.add(UserData("Name: $names","Type of Animal : $type","Old : $number"))
            userAdapter.notifyDataSetChanged()
            Toast.makeText(this,"Adding User Information Success",Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        addDialog.setNegativeButton("Cancel"){
                dialog,_->
            dialog.dismiss()
            Toast.makeText(this,"Cancel",Toast.LENGTH_SHORT).show()

        }
        addDialog.create()
        addDialog.show()
    }
        /**ok now run this */

    }