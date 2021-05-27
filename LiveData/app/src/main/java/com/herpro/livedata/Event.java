package com.herpro.livedata;

/**
 * Clase genérica que permite hacer seguimientos a eventos con LiveData
 */
public class Event<T> {

    private final T mContent;

    private boolean hasBeenHandled = false;

    public Event(T content) {
        if (content == null) {
            throw new IllegalArgumentException("los valores null en Event no son permitidos.");
        }
        mContent = content;
    }

    public T getContentIfNotHandled() {
        if (hasBeenHandled) {
            return null;
        } else {
            hasBeenHandled = true;
            return mContent;
        }
    }

    public boolean hasBeenHandled() {
        return hasBeenHandled;
    }

    public T peekContent() {
        return mContent;
    }
}