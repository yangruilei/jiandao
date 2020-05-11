package com.example.jiandao.home.view.fragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiandao.R;
import com.example.jiandao.base.BaseLayFragment;
import com.example.jiandao.home.adapter.NewsAdapter;
import com.example.jiandao.home.bean.NewsBean;
import com.example.jiandao.home.contract.NewsFragmentContract;
import com.example.jiandao.home.presenter.NewsPresenter;

import cn.jzvd.Jzvd;

/**
 *新闻列表页面
 * 多布局得页面
 * 4种布局
 */
public class NewsFragment extends BaseLayFragment<NewsPresenter> implements NewsFragmentContract.INewsView {

    private  String tabID;

    private RecyclerView recyclerView;

    private NewsAdapter newsAdapter;


    public NewsFragment(String tabID) {
        this.tabID = tabID;
    }

    @Override
    protected NewsPresenter initPresenter() {
        return new NewsPresenter();
    }

    @Override
    protected void initLinstener() {
    }

    @Override
    protected void initData() {
        mPresenter.getRecommendList(tabID);
    }

    @Override
    protected void initView(View view) {
        recyclerView = view.findViewById(R.id.news_recycleview);
    }
    @Override
    public int getLayoutID() {
        return R.layout.fragment_news;
    }

    /**
     * Fragment是否处于可见状态
     * @param isVisible
     */
    @Override
    public void isCurrentVisibleToUser(boolean isVisible) {
//        当前Framgnet是显示还是隐藏

        if(newsAdapter !=null) newsAdapter.isCurrentVisibleToUser(isVisible);
    }

    @Override
    public void setRecommendList(NewsBean newsBean) {
        //LinearLayoutManager是用来做列表布局，也就是单列的列表
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        newsAdapter = new NewsAdapter(getActivity(),newsBean);
        recyclerView.setAdapter(newsAdapter);
    }



//    后期做完善--视频播放得bug
    /*@Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }*/
    @Override
    public void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }

}
