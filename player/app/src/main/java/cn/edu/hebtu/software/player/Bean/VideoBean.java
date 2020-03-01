package cn.edu.hebtu.software.player.Bean;

import java.io.Serializable;

public class VideoBean implements Serializable{

    private int videoId;
    private String videoUrl;
    private int videoUpId;
    private String videoTitle;
    private int videoZanNum;
    private int videoCommentNum;
    private String videoPic;
    private int order;

    public VideoBean(){}

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public int getVideoUpId() {
        return videoUpId;
    }

    public void setVideoUpId(int videoUpId) {
        this.videoUpId = videoUpId;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public int getVideoZanNum() {
        return videoZanNum;
    }

    public void setVideoZanNum(int videoZanNum) {
        this.videoZanNum = videoZanNum;
    }

    public int getVideoCommentNum() {
        return videoCommentNum;
    }

    public void setVideoCommentNum(int videoCommentNum) {
        this.videoCommentNum = videoCommentNum;
    }

    public String getVideoPic() {
        return videoPic;
    }

    public void setVideoPic(String videoPic) {
        this.videoPic = videoPic;
    }

    public int getOrder() { return order; }

    public void setOrder(int order) { this.order = order; }
}
