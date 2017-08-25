package com.bigjelly.shaddockvideoplayer.view.video.adapter;

import android.content.Context;

import com.andfast.pullrecyclerview.BaseRecyclerAdapter;
import com.andfast.pullrecyclerview.BaseViewHolder;
import com.bigjelly.shaddockvideoplayer.R;
import com.bigjelly.shaddockvideoplayer.model.VideoFile;

import java.util.List;

/**
 * Created by mby on 17-8-25.
 */

public class VideoListAdpater extends BaseRecyclerAdapter<VideoFile> {
    public VideoListAdpater(Context context, int layoutResId, List<VideoFile> data) {
        super(context, layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, VideoFile item) {
        holder.setText(R.id.tv_file_name,item.name);
        holder.setText(R.id.tv_file_number,String.format("共有 %d 个视频",item.number));
    }
}