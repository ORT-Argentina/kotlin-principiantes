package com.herpro.livedata.ui.categories;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.Snackbar;
import com.herpro.livedata.R;
import com.herpro.livedata.databinding.ActivityCategoriesBinding;
import com.herpro.livedata.ui.addeditcategory.AddEditCategoryActivity;
import com.herpro.livedata.viewmodel.CategoriesViewModel;

public class CategoriesActivity extends AppCompatActivity {

    public static final String EXTRA_CATEGORY_ID = "com.herpro.livedata.category_id";

    private ActivityCategoriesBinding mBinding;
    private CategoriesAdapter mCategoriesListAdapter;
    private CategoriesViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_categories);
        mViewModel = new ViewModelProvider(this).get(CategoriesViewModel.class);
        mBinding.setViewModel(mViewModel);
        mBinding.setLifecycleOwner(this);

        setupToolbar();

        setupListAdapter();

        setupSnackbar();

        setupNavigation();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mViewModel.handleActivityResult(requestCode, resultCode);
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Observamos cantidad de items y actualizamos título
        mViewModel.getCategoriesNumber().observe(this, integer -> {
            String title;
            if (integer > 0) {
                title = getString(R.string.categories_number, integer);
            } else {
                title = getString(R.string.zero_categories);
            }
            getSupportActionBar().setTitle(title);
        });
    }

    private void setupListAdapter() {
        mCategoriesListAdapter = new CategoriesAdapter(mViewModel);
        mBinding.mainContent.categoriesList.setAdapter(mCategoriesListAdapter);
    }

    private void setupSnackbar() {
        // Mostrar snackbar en resultados positivos de operaciones (crear, editar y eliminar)
        mViewModel.getSnackbarText().observe(this, integerEvent -> {
            Integer stringId = integerEvent.getContentIfNotHandled();
            if (stringId != null) {
                Snackbar.make(findViewById(R.id.coordinator),
                        stringId, Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private void setupNavigation() {
        // Abrir actividad para crear o editar categoría
        mViewModel.getOpenCategoryEvent().observe(this, integerEvent -> {
            Integer id = integerEvent.getContentIfNotHandled();
            if (id != null) {
                goToAddEdit(id);
            }
        });
    }

    private void goToAddEdit(int categoryId) {
        Intent intent = new Intent(this, AddEditCategoryActivity.class);

        if (categoryId > 0) {
            // Abrir en modo edición
            intent.putExtra(EXTRA_CATEGORY_ID, categoryId);
        }
        startActivityForResult(intent, AddEditCategoryActivity.REQUEST_CODE);
    }
}