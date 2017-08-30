package com.bigjelly.shaddockvideoplayer.view.video.fragment;

import android.support.v7.widget.DividerItemDecoration;
import android.view.View;
import android.widget.TextView;

import com.andfast.pullrecyclerview.PullRecyclerView;
import com.andfast.pullrecyclerview.layoutmanager.XLinearLayoutManager;
import com.bigjelly.shaddockvideoplayer.R;
import com.bigjelly.shaddockvideoplayer.model.VideoInfo;
import com.bigjelly.shaddockvideoplayer.net.ResultResponse;
import com.bigjelly.shaddockvideoplayer.presenter.video.VideoListPresenter;
import com.bigjelly.shaddockvideoplayer.view.base.BasePresenterFragment;
import com.bigjelly.shaddockvideoplayer.view.video.Impl.IVideoListView;
import com.bigjelly.shaddockvideoplayer.view.video.adapter.VideoListAdpater;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc-123 on 2017/8/29.
 */

public class VideoListFragment extends BasePresenterFragment<VideoListPresenter> implements PullRecyclerView.OnRecyclerRefreshListener, IVideoListView {
    private PullRecyclerView mRecyclerView;
    private XLinearLayoutManager mLayoutManager;
    private VideoListAdpater mAdpater;

    @Override
    protected int getLayoutId() {
        return R.layout.frg_video_file_list;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
        TextView textView =findView(R.id.toolbar_title);
        textView.setText(R.string.tab_name_video);
        mRecyclerView = findView(R.id.pull_recycler_view);

        // 初始化PullRecyclerView
        mLayoutManager = new XLinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(getResources().getDrawable(R.drawable.shape_simple_item_decoration));
        mRecyclerView.addItemDecoration(itemDecoration);
        mAdpater = new VideoListAdpater(getContext(), R.layout.lay_item_video_file, new ArrayList<VideoInfo>(),getFragmentManager());
        mRecyclerView.setAdapter(mAdpater);
        mRecyclerView.enablePullRefresh(true); // 开启下拉刷新，默认即为true，可不用设置
        mRecyclerView.enableLoadMore(false);
        mRecyclerView.setOnRecyclerRefreshListener(this);
    }

    @Override
    protected void initData() {
        super.initData();
        mRecyclerView.postRefreshing();
    }

    @Override
    protected VideoListPresenter createPresenter() {
        return new VideoListPresenter(this);
    }

    @Override
    public void onPullRefresh() {
        mvpPresenter.getVideoList();
    }

    @Override
    public void onLoadMore() {

    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

    @Override
    public void onVideoListSuccess(List<VideoInfo> response) {
        mRecyclerView.stopRefresh();
        mAdpater.replaceAll(response);
    }

    @Override
    public void onError(int type, ResultResponse<VideoInfo> response) {

    }
}
