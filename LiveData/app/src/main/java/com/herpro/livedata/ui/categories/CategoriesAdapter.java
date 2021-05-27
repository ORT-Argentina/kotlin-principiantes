package com.herpro.livedata.ui.categories;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.herpro.livedata.R;
import com.herpro.livedata.databinding.CategoryItemBinding;
import com.herpro.livedata.model.Category;
import com.herpro.livedata.viewmodel.CategoriesViewModel;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder> {

    private List<Category> mCategoriesList;

    private final CategoriesViewModel mViewModel;

    public CategoriesAdapter(CategoriesViewModel viewModel) {
        mViewModel = viewModel;
    }

    public void setCategoriesList(List<Category> categoriesList) {
        mCategoriesList = categoriesList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoryItemBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.category_item, parent, false);
        return new CategoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.binding.setViewModel(mViewModel);
        holder.binding.setCategory(mCategoriesList.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mCategoriesList == null ? 0 : mCategoriesList.size();
    }

    static class CategoryViewHolder extends RecyclerView.ViewHolder {
        final CategoryItemBinding binding;

        public CategoryViewHolder(CategoryItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
