package com.guidesound.dao;

import com.guidesound.models.Video;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IVideo {
    void addVideo(Video video);
    List<Video> getVideoList(int userId);
    Video getVideo(int id);

    @Update("update video set examine_status = #{arg1} where id=#{arg0}")
    void setVideoStatus(int id,int status);
    @Update("update video set deleted=1 where id=#{arg0} and user_id=#{arg1}")
    void deleteVideo(int id,int userId);
}
