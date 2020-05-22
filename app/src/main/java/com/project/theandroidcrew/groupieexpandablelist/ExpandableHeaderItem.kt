package com.project.theandroidcrew.groupieexpandablelist

import android.graphics.drawable.Animatable
import android.view.View
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_list_child.view.*
import kotlinx.android.synthetic.main.item_list_parent.view.*

/**
 * @author kemosabe_x
 * Created on 5/22/20
 */
class ExpandableHeaderItem(val title: String) : Item() , ExpandableItem {
    private lateinit var expandableGroup: ExpandableGroup

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.root.parent_text_title.text = title
        viewHolder.itemView.setOnClickListener {
            expandableGroup.onToggleExpanded()
            changeStuff(viewHolder)
        }

    }
    override fun getLayout(): Int {
        return  R.layout.item_list_parent
    }

    private fun changeStuff(viewHolder: GroupieViewHolder) {

        viewHolder.root.indicator.apply {
            setImageResource(
                if (expandableGroup.isExpanded) R.drawable.ic_expanded_indicator
                else R.drawable.ic_collapsed_indicator)
        }

    }

    override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
        this.expandableGroup = onToggleListener
    }


}