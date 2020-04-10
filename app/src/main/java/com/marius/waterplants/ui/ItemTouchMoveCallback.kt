package com.marius.waterplants.ui

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class ItemTouchMoveCallback(private val adapter: ItemTouchHelperAdapter) :
    ItemTouchHelper.Callback() {

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ) = makeMovementFlags(
        ItemTouchHelper.UP or ItemTouchHelper.DOWN,
        ItemTouchHelper.ACTION_STATE_IDLE
    )

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ) = adapter.onItemMove(viewHolder.adapterPosition, target.adapterPosition)

    override fun isLongPressDragEnabled() = true

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {}
}