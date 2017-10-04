package com.tt.projectshowcase.ui.common;

/**
 * Created by TT on 4.10.2017..
 * ProjectShowcase
 *
 * Generic item click interface for RecyclerView Adapters.
 *
 */

public interface ItemClickListener<T> {

    void onItemClicked(T item);
}
