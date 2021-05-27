package com.herpro.livedata.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.herpro.livedata.CategoriesRepository;
import com.herpro.livedata.Event;
import com.herpro.livedata.R;
import com.herpro.livedata.model.Category;
import com.herpro.livedata.ui.addeditcategory.AddEditCategoryActivity;

import java.util.HashMap;

public class CategoriesViewModel extends ViewModel {

    private final CategoriesRepository repository;

    private final MutableLiveData<String> filter = new MutableLiveData<>("*");

    private final LiveData<HashMap<Integer, Category>> categories;

    private final LiveData<Integer> size;

    private final LiveData<Boolean> empty;

    private final MutableLiveData<Event<Integer>> mSnackbarText = new MutableLiveData<>();

    private final MutableLiveData<Event<Integer>> mOpenCategoryEvent = new MutableLiveData<>();


    public CategoriesViewModel() {
        repository = CategoriesRepository.getsInstance();
        categories = Transformations.switchMap(filter, y -> repository.getCategories());
        size = Transformations.map(categories, HashMap::size);
        empty = Transformations.map(categories, HashMap::isEmpty);
    }

    // Abrir la categoría a editar
    public void addEditCategory(int categoryId) {
        mOpenCategoryEvent.setValue(new Event<>(categoryId));
    }

    public void handleActivityResult(int requestCode, int resultCode) {
        if (AddEditCategoryActivity.REQUEST_CODE == requestCode) {
            switch (resultCode) {
                case AddEditCategoryActivity.EDIT_RESULT_OK:
                    mSnackbarText.setValue(new Event<>(R.string.updated_category_message));
                    break;
                case AddEditCategoryActivity.ADD_RESULT_OK:
                    mSnackbarText.setValue(new Event<>(R.string.added_category_message));
                    break;
                case AddEditCategoryActivity.DELETE_RESULT_OK:
                    mSnackbarText.setValue(new Event<>(R.string.deleted_category_message));
                    break;
            }
        }
    }

    public MutableLiveData<Event<Integer>> getOpenCategoryEvent() {
        return mOpenCategoryEvent;
    }

    public MutableLiveData<Event<Integer>> getSnackbarText() {
        return mSnackbarText;
    }

    public LiveData<HashMap<Integer, Category>> getCategories() {
        return categories;
    }

    public LiveData<Integer> getCategoriesNumber() {
        return size;
    }

    public LiveData<Boolean> getEmpty() {
        return empty;
    }

}
