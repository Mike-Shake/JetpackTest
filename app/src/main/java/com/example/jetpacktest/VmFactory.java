package com.example.jetpacktest;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class VmFactory implements ViewModelProvider.Factory {
    private int a;

    public VmFactory(int a) {
        this.a = a;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T)new MyViewmodel(a);
    }
}
