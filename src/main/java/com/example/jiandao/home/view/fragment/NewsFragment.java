package com.example.jiandao.home.view.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.jiandao.R;
import com.example.jiandao.base.BaseFragment;
import com.example.jiandao.home.Banner_Indicator;
import com.example.jiandao.home.adapter.NewsBannerAdapter;
import com.example.jiandao.home.bean.NewsBean;
import com.example.jiandao.home.contract.NewsFragmentContract;
import com.example.jiandao.home.presenter.NewsPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends BaseFragment<NewsPresenter> implements NewsFragmentContract.INewsView {

    private String tabID;
    private List<View> views=new ArrayList<>();
    private ViewPager mVpBanner;
    private Banner_Indicator mIndicatorBanner;
    private int currentPosi;


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

        mVpBanner = (ViewPager) view.findViewById(R.id.banner_vp);
        mIndicatorBanner = (Banner_Indicator) view.findViewById(R.id.banner_indicator);
    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_news;
    }

    @Override
    public void setRecommendList(NewsBean data) {

        initBanner(data);

    }

    private void initBanner(final NewsBean data) {
        for (int i = 0; i < data.getData().getBanner_list().size(); i++) {
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.news_banner_item,null);
            TextView text = inflate.findViewById(R.id.banner_content);
            ImageView image = inflate.findViewById(R.id.banner_image);
            text.setText(data.getData().getBanner_list().get(i).getDescription());
            Glide.with(getContext()).load(data.getData().getBanner_list().get(i).getImage_url()).into(image);
            views.add(inflate);
            final int finalI = i;
            inflate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "点击了"+ finalI, Toast.LENGTH_SHORT).show();
                }
            });
        }
        NewsBannerAdapter newsBannerAdapter = new NewsBannerAdapter(views);
        mVpBanner.setAdapter(newsBannerAdapter);
        mIndicatorBanner.setBannerImageSize(data.getData().getBanner_list().size());
        mIndicatorBanner.setCurrentBannerItem(0);
        mVpBanner.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mIndicatorBanner.setCurrentBannerItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                currentPosi++;
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //取余显示
                        mVpBanner.setCurrentItem(currentPosi%(data.getData().getBanner_list().size()));
                    }
                });

            }
        };
        timer.schedule(timerTask,2000,2000);
    }
}
