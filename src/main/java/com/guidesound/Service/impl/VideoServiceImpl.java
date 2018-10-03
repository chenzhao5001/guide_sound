package com.guidesound.Service.impl;

import com.guidesound.Service.IVideoService;
import com.guidesound.dao.IVideo;
import com.guidesound.models.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements IVideoService{

    @Autowired
    private IVideo iVideo;

    @Override
    public void addVideo(Video video) {
        iVideo.addVideo(video);
    }
}
