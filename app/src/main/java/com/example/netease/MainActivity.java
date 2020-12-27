package com.example.netease;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.netease.view.fragment.ClassifyFragment;
import com.example.netease.view.fragment.HomeFragment;
import com.example.netease.view.fragment.MyFragment;
import com.example.netease.view.fragment.ShoppingFragment;
import com.example.netease.view.fragment.SpecialFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rb_home)
    RadioButton rbHome;
    @BindView(R.id.rb_special)
    RadioButton rbSpecial;
    @BindView(R.id.rb_classify)
    RadioButton rbClassify;
    @BindView(R.id.rb_shopping)
    RadioButton rbShopping;
    @BindView(R.id.rb_me)
    RadioButton rbMe;
    @BindView(R.id.rg_navigation)
    RadioGroup rgNavigation;
    private ArrayList<Fragment> fragments;
    private MyFragment myFragment;
    private ShoppingFragment shoppingFragment;
    private ClassifyFragment classifyFragment;
    private SpecialFragment specialFragment;
    private HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        homeFragment = new HomeFragment();
        specialFragment = new SpecialFragment();
        classifyFragment = new ClassifyFragment();
        shoppingFragment = new ShoppingFragment();
        myFragment = new MyFragment();

        FragmentManager supportFragmentManager = getSupportFragmentManager();

        supportFragmentManager.beginTransaction()
                .add(R.id.fl_fragment,homeFragment)
                .add(R.id.fl_fragment,specialFragment)
                .add(R.id.fl_fragment,classifyFragment)
                .add(R.id.fl_fragment,shoppingFragment)
                .add(R.id.fl_fragment,myFragment)
                .show(homeFragment)
                .hide(specialFragment)
                .hide(classifyFragment)
                .hide(shoppingFragment)
                .hide(myFragment)
                .commit();

        rgNavigation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_home:
                        supportFragmentManager.beginTransaction()
                                .show(homeFragment)
                                .hide(specialFragment)
                                .hide(classifyFragment)
                                .hide(shoppingFragment)
                                .hide(myFragment)
                                .commit();
                        break;
                    case R.id.rb_special:
                        supportFragmentManager.beginTransaction()
                                .show(specialFragment)
                                .hide(homeFragment)
                                .hide(classifyFragment)
                                .hide(shoppingFragment)
                                .hide(myFragment)
                                .commit();
                        break;
                    case R.id.rb_classify:
                        supportFragmentManager.beginTransaction()
                                .show(classifyFragment)
                                .hide(homeFragment)
                                .hide(specialFragment)
                                .hide(shoppingFragment)
                                .hide(myFragment)
                                .commit();
                        break;
                    case R.id.rb_shopping:
                        supportFragmentManager.beginTransaction()
                                .show(shoppingFragment)
                                .hide(homeFragment)
                                .hide(specialFragment)
                                .hide(classifyFragment)
                                .hide(myFragment)
                                .commit();
                        break;
                    case 4:
                        supportFragmentManager.beginTransaction()
                                .show(myFragment)
                                .hide(homeFragment)
                                .hide(specialFragment)
                                .hide(classifyFragment)
                                .hide(shoppingFragment)
                                .commit();
                        break;
                }
            }
        });
    }


}