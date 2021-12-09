package com.example.medinahotel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.medinahotel.databinding.ActivityImageListBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ImageListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImageListBinding
    private var cateogryId = ""
    private var category = ""

    private lateinit var  clothesArrayList: ArrayList<ModelHotel>

    private lateinit var adapterClothes: AdapterHotel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        cateogryId = intent.getStringExtra("categoryId")!!
        category = intent.getStringExtra("category")!!

        binding.subTitleTv.text = category

        loadClothesList()

        binding.backBtn.setOnClickListener {
            onBackPressed()
        }
    }

    private fun loadClothesList() {
        //init arraylist
        clothesArrayList = ArrayList()

        // get all categories from firebase... Firebase DB > Categories
        val ref = FirebaseDatabase.getInstance().getReference("Images")
        ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                //clear list before starting adding data into it
                clothesArrayList.clear()
                for (ds in snapshot.children){
                    var model = ds.getValue(ModelHotel::class.java)
                    clothesArrayList.add(model!!)
                    if(model!=null) {
                        clothesArrayList.add(model)
                        Log.d("OKAY???", "onDataChange ${model.article} ${model.categoryId}")
                    }
                }
                //setup adapter
                adapterClothes = AdapterHotel(this@ImageListActivity, clothesArrayList)
                binding.clothesRv.adapter = adapterClothes
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}