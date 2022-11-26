package com.example.jetpacktest;

import androidx.lifecycle.ViewModel;

public class MyViewmodel extends ViewModel {
    protected int a=0;

//    public MyViewmodel(int a) {
//        this.a = a;
//    }

    public MyViewmodel(int countReserved){
        a=countReserved;
    }
}
