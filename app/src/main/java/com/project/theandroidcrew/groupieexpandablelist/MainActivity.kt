package com.project.theandroidcrew.groupieexpandablelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.groupiex.plusAssign
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val groupAdapter = GroupAdapter<GroupieViewHolder>()
    private lateinit var groupLayoutManager: LinearLayoutManager

    private val childList = listOf(
        ChildItem("First Album"),
        ChildItem("Second Album"),
        ChildItem("Third Album"),
        ChildItem("Fourth Album")

    )

    private val parentList = listOf(
     ExpandableHeaderItem("Travis Scott"),
    ExpandableHeaderItem("Migos"),
    ExpandableHeaderItem("Post Malone"),
    ExpandableHeaderItem("Drake")

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        groupLayoutManager = LinearLayoutManager(this)

        xRecyclerView.apply {
            layoutManager = groupLayoutManager
            adapter = groupAdapter
        }


        groupAdapter.apply {
            for (i in parentList){
                this += ExpandableGroup(i).apply {
                    for (j  in childList) {
                        add(j)
                    }
                }

            }
        }
    }
}
