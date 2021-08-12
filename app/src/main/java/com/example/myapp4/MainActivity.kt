package com.example.myapp4

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var progressDialog:ProgressDialog
    var dataList = ArrayList<DataModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressDialog=ProgressDialog(this)
        progressDialog.setTitle("Loading")
        progressDialog.setCancelable(false)
        progressDialog.show()

        getData()

    }
    private fun getData(){
        val call: Call<List<DataModel>> = ApiClient.getClient.getPhotos()



        call.enqueue(object : Callback<List<DataModel>> {
            override fun onResponse(call : Call<List<DataModel>>?, response: Response<List<DataModel>>?){
            progressDialog.dismiss()

            dataList.addAll(response!!.body()!!)


                recyclerView.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
                recyclerView.adapter = DataAdapter(dataList, applicationContext)
        }

            override fun onFailure(call: Call<List<DataModel>>?, t: Throwable?) {
                progressDialog.dismiss()
            }
        })
    }
}

