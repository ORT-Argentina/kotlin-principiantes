package com.herpro.livedata.ui.addeditcategory;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class AlertDialogFragment extends DialogFragment {
    public static final String DISCARD_TAG = "Discard Dialog";
    private static final String KEY_MESSAGE = "msg";
    private static final String KEY_POSITIVE_TEXT = "positive_text";
    private static final String KEY_NEGATIVE_TEXT = "negative_text";
    public static final String DELETE_TAG = "Delete Dialog";

    public interface DialogButtonsListener {
        void onPositiveClick(DialogFragment dialog);

        void onNegativeClick(DialogFragment dialog);
    }

    DialogButtonsListener mListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setMessage(requireArguments().getInt(KEY_MESSAGE));
        builder.setPositiveButton(requireArguments().getInt(KEY_POSITIVE_TEXT),
                (dialog, id) -> mListener.onPositiveClick(this));
        builder.setNegativeButton(requireArguments().getInt(KEY_NEGATIVE_TEXT),
                (dialog, id) -> mListener.onNegativeClick(this));

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mListener = (DialogButtonsListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " debe implementar DialogButtonsListener");
        }
    }

    public static AlertDialogFragment create(@StringRes int msg, @StringRes int positive,
                                             @StringRes int negative) {
        AlertDialogFragment fragment = new AlertDialogFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_MESSAGE, msg);
        args.putInt(KEY_POSITIVE_TEXT, positive);
        args.putInt(KEY_NEGATIVE_TEXT, negative);
        fragment.setArguments(args);
        return fragment;
    }
}