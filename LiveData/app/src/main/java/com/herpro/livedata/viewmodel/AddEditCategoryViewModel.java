package com.herpro.livedata.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.herpro.livedata.CategoriesRepository;
import com.herpro.livedata.Event;
import com.herpro.livedata.R;
import com.herpro.livedata.model.Category;

public class AddEditCategoryViewModel extends ViewModel {

    private final MutableLiveData<String> name = new MutableLiveData<>();

    private final MutableLiveData<Event<Integer>> mErrorText = new MutableLiveData<>();

    private final MutableLiveData<Event<Integer>> mCategorySavedEvent = new MutableLiveData<>();

    private final MutableLiveData<Event<Object>> mCategoryDeletedEvent = new MutableLiveData<>();


    private final CategoriesRepository mCategoriesRepository;

    private int mCategoryId;

    private boolean mIsNewCategory;


    public AddEditCategoryViewModel() {
        mCategoriesRepository = CategoriesRepository.getsInstance();
    }

    public void start(int categoryId) {
        mCategoryId = categoryId;

        // ¿Es una nueva categoría?
        if (categoryId <= 0) {
            mIsNewCategory = true;
            return;
        }

        mIsNewCategory = false;

        LiveData<Category> category = mCategoriesRepository.getCategory(categoryId);
        name.setValue(category.getValue().getName());

    }

    public void saveCategory() {

        // Realizar validaciones del estado
        if (name.getValue() == null) {
            mErrorText.setValue(new Event<>(R.string.category_name_error));
            return;
        }

        if (name.getValue().isEmpty()) {
            mErrorText.setValue(new Event<>(R.string.category_name_error));
            return;
        }

        Category category;

        if (mIsNewCategory) {
            // "creación"
            category = new Category(name.getValue());
        } else {
            // "edición"
            category = new Category(mCategoryId, name.getValue());
        }

        // Guardar categoría
        mCategoriesRepository.addCategory(category);

        // Enviar evento de navegación
        mCategorySavedEvent.setValue(new Event<>(mCategoryId));
    }

    public void deleteCategory() {
        mCategoriesRepository.delete(mCategoryId);
        mCategoryDeletedEvent.setValue(new Event<>(new Object()));
    }

    public MutableLiveData<String> getName() {
        return name;
    }

    public LiveData<Event<Integer>> getError() {
        return mErrorText;
    }

    public LiveData<Event<Integer>> getCategorySavedEvent() {
        return mCategorySavedEvent;
    }

    public MutableLiveData<Event<Object>> getCategoryDeletedEvent() {
        return mCategoryDeletedEvent;
    }
}
