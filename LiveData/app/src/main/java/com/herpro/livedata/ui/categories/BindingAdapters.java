package com.herpro.livedata.ui.categories;

import android.view.View;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.herpro.livedata.model.Category;
import com.herpro.livedata.ui.categories.CategoriesAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BindingAdapters {

    @BindingAdapter("items")
    public static void setItems(RecyclerView list, HashMap<Integer, Category> items) {
        CategoriesAdapter adapter = (CategoriesAdapter) list.getAdapter();

        if (items != null) {
            adapter.setCategoriesList(new ArrayList<>(items.values()));

        }
    }

    @BindingAdapter("emptyState")
    public static void show(View v, boolean show) {
        v.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}
