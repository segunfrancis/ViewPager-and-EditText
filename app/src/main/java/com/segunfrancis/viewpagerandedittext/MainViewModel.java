package com.segunfrancis.viewpagerandedittext;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private final MutableLiveData<String> _email = new MutableLiveData<>();
    public LiveData<String> email = _email;

    private final MutableLiveData<String> _phone = new MutableLiveData<>();
    public LiveData<String> phone = _phone;

    public void setEmail(String email) {
        _email.setValue(email);
    }

    public void setPhone(String phone) {
        _phone.setValue(phone);
    }
}
