package com.herpro.livedata.ui.addeditcategory;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.herpro.livedata.R;
import com.herpro.livedata.databinding.ActivityAddEditCategoryBinding;
import com.herpro.livedata.ui.categories.CategoriesActivity;
import com.herpro.livedata.viewmodel.AddEditCategoryViewModel;

public class AddEditCategoryActivity extends AppCompatActivity
        implements AlertDialogFragment.DialogButtonsListener {

    public static final int REQUEST_CODE = 1;

    public static final int EDIT_RESULT_OK = 100;

    public static final int ADD_RESULT_OK = 101;

    public static final int DELETE_RESULT_OK = 102;

    private ActivityAddEditCategoryBinding mBinding;

    private AddEditCategoryViewModel mViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_edit_category);
        mViewModel = new ViewModelProvider(this).get(AddEditCategoryViewModel.class);
        mBinding.setViewModel(mViewModel);
        mBinding.setLifecycleOwner(this);

        setupToolbar();

        setupInputErrors();

        setupNavigation();

        loadData();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_edit_category_menu, menu);

        // Mostrar icono de eliminar si hay edición
        if (isEdition()) {
            menu.findItem(R.id.action_delete).setVisible(true);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (R.id.action_delete == itemId) {
            // Mostrar diálogo de confirmación
            AlertDialogFragment.create(R.string.dialog_delete_msg,
                    R.string.dialog_delete_positive, R.string.dialog_save_negative)
                    .show(getSupportFragmentManager(), AlertDialogFragment.DELETE_TAG);
            return true;

        } else if (R.id.action_save == itemId) {
            mViewModel.saveCategory();
            return true;

        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onPositiveClick(DialogFragment dialog) {
        switch (dialog.getTag()) {
            case AlertDialogFragment.DELETE_TAG:
                mViewModel.deleteCategory();
                break;
            case AlertDialogFragment.DISCARD_TAG:
                // manejar descarte
                break;
        }
    }

    @Override
    public void onNegativeClick(DialogFragment dialog) {

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void setupNavigation() {
        mViewModel.getCategoryDeletedEvent().observe(this, objectEvent -> {
            if(objectEvent.getContentIfNotHandled()!=null){
                // Ir hacia la lista de categorías
                setResult(DELETE_RESULT_OK);
                finish();
            }
        });

        mViewModel.getCategorySavedEvent().observe(this, categoryEvent -> {
            Integer categoryId = categoryEvent.getContentIfNotHandled();
            if (categoryId != null) {
                // Finalizar actividad con resultado exitoso
                setResult(categoryId > 0 ? EDIT_RESULT_OK : ADD_RESULT_OK);
                finish();
            }
        });
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        // Establecer título en la toolbar según la operación
        if (isEdition()) {
            ab.setTitle(R.string.edit_category_title);
        } else {
            ab.setTitle(R.string.add_category_title);
        }
    }

    private void setupInputErrors() {
        mViewModel.getName().observe(this, s -> {
            // Limpiar error al editar
            if (mBinding.categoryInputLayout.getError() != null) {
                mBinding.categoryInputLayout.setError(null);
            }
        });

        // Limpiar código para poner lambdas
        mViewModel.getError().observe(this, event -> {
            // Mostrar error en el nombre de la categoría
            Integer msg = event.getContentIfNotHandled();
            if (msg != null) {
                mBinding.categoryInputLayout.setError(getText(msg));
            }
        });
    }

    private void loadData() {
        if (getIntent().getExtras() != null) {
            int categoryId = getIntent().getExtras().getInt(CategoriesActivity.EXTRA_CATEGORY_ID);
            mViewModel.start(categoryId);
        } else {
            mViewModel.start(0);
        }
    }

    private boolean isEdition() {
        return getIntent() != null
                && getIntent().getIntExtra(CategoriesActivity.EXTRA_CATEGORY_ID, -1) > 0;
    }
}