package com.example.jetpacktest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    MyViewmodel myViewmodel;
    TextView textView;
    Button plusonebtn;
    Button clearbtn;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //不能直接创建ViewModel的实例，不然每次活动oncreate()都会创建一个实例，无法保留其中数据

        //若需要传参数使用这个同时实现ViewModelProvider.Factory
        //myViewmodel = new ViewModelProvider(this, new VmFactory(0)).get(MyViewmodel.class);

        //不需传参，使用无参构造函数
        //myViewmodel = new ViewModelProvider(this).get(MyViewmodel.class);


        preferences= PreferenceManager.getDefaultSharedPreferences(this);
        int savedCounter=preferences.getInt("count_reserved",0);
        myViewmodel = new ViewModelProvider(this, new VmFactory(savedCounter)).get(MyViewmodel.class);


        plusonebtn = findViewById(R.id.plusOneBtn);
        clearbtn=findViewById(R.id.clearbtn);
        textView = findViewById(R.id.infoText);
        plusonebtn.setOnClickListener(this);
        clearbtn.setOnClickListener(this);
        textView.setText(String.valueOf(myViewmodel.a));


        //实现注册观察者
        getLifecycle().addObserver(new MyObsever());
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor=preferences.edit();
        editor.putInt("count_reserved",myViewmodel.a);
        editor.apply();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.plusOneBtn:
                myViewmodel.a++;
                textView.setText(myViewmodel.a + "");//+空字符串是为了转为字符串
                break;
            case R.id.clearbtn:
                myViewmodel.a=0;
                textView.setText(myViewmodel.a+"");
                break;
            default:
                break;
        }
    }
}