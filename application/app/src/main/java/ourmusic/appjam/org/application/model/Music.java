package ourmusic.appjam.org.application.model;

/**
 * Created by dsm2016 on 2017-08-12.
 */

public class Music {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    private String singer;
    private String url;


    public Music(String title, String singer, String url, String imgURL) {
        this.title = title;
        this.singer = singer;
        this.url = url;
        this.imgURL = imgURL;
    }

    private String imgURL;


}
