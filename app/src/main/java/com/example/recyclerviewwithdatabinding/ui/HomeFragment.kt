package com.example.recyclerviewwithdatabinding.ui


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewwithdatabinding.R
import com.example.recyclerviewwithdatabinding.adapter.ItemListener
import com.example.recyclerviewwithdatabinding.adapter.UserAdapter
import com.example.recyclerviewwithdatabinding.data.User
import com.example.recyclerviewwithdatabinding.data.UserData
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(),ItemListener {
    private lateinit var usersList:ArrayList<User>
    private lateinit var userAdapter: UserAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        usersList = ArrayList<User>()
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        for( i:Int in 0 until UserData.userNames.size-1){
            usersList.add(User(name=UserData.userNames[i],
                email = UserData.userEmails[i],
                age = UserData.userAges[i],
                gender = UserData.userGenders[i]))
        }

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        rv_userList.layoutManager = LinearLayoutManager(this.context)
        rv_userList.setHasFixedSize(true)
        userAdapter = UserAdapter(usersList, this)
        rv_userList.adapter = userAdapter
    }

    override fun onItemClick(view: View, user: User) {
        Log.d("TAG","item ${user.name}")
        Snackbar.make(root_frame,"name: ${user.name} age: ${user.age}",Snackbar.LENGTH_INDEFINITE).also {snackbar ->
            snackbar.setAction("OK"){
                snackbar.dismiss()
            }
        }.show()
    }

}
