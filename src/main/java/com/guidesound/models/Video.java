package com.guidesound.models;

public class Video {
    int id;
    int user_id;
    String title;
    int subject;
    int watch_type;
    String content;
    String pic_up_path;
    String video_up_path;
    int create_time;
    int update_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public int getWatch_type() {
        return watch_type;
    }

    public void setWatch_type(int watch_type) {
        this.watch_type = watch_type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPic_up_path() {
        return pic_up_path;
    }

    public void setPic_up_path(String pic_up_path) {
        this.pic_up_path = pic_up_path;
    }

    public String getVideo_up_path() {
        return video_up_path;
    }

    public void setVideo_up_path(String video_up_path) {
        this.video_up_path = video_up_path;
    }

    public int getCreate_time() {
        return create_time;
    }

    public void setCreate_time(int create_time) {
        this.create_time = create_time;
    }

    public int getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(int update_time) {
        this.update_time = update_time;
    }


    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", title='" + title + '\'' +
                ", subject=" + subject +
                ", watch_type=" + watch_type +
                ", pic_up_path='" + pic_up_path + '\'' +
                ", video_up_path='" + video_up_path + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
