package com.example.jiandao.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 懒加载Fragment
 */
public abstract class BaseLayFragment extends Fragment {


    private boolean IS_VIEW_CREATED = false;

    public boolean IS_DATA_LOAD = false;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        lazyLoad();

    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
//        true/false   可见或者不可见
        lazyLoad();
    }

    private void lazyLoad(){
//        true可见    1、当前页面是否可见   2、当前页面是否已经加载   3、当前页面数据是否已经加载
       if( getUserVisibleHint()  && IS_VIEW_CREATED  && !IS_DATA_LOAD){
//           加载数据
           initData();
           IS_DATA_LOAD = true;
       }else{
//           不需要加载数据
       }
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  LayoutInflater.from(container.getContext()).inflate(getLayoutID(),container,false);
        IS_VIEW_CREATED = true;

        initView();
//        initData();
        initLinstener();
        return view;
    }

    protected abstract void initLinstener();

    protected abstract void initData();

    protected abstract void initView();

    public abstract  int getLayoutID();
}
