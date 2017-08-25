package com.bigjelly.shaddockvideoplayer.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mby on 17-8-25.
 */

public class VideoFile extends Entity{
    public String name;
    public String path;
    public List<VideoInfo> videoInfos = new ArrayList<>();
    public int number = videoInfos.size();
}