package com.project.theandroidcrew.groupieexpandablelist
import com.google.android.material.snackbar.Snackbar
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_list_child.view.*

open class ChildItem( val title : String) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.root.child_textTitle.text = title

    }
    override fun getLayout(): Int {
        return R.layout.item_list_child
    }

}
