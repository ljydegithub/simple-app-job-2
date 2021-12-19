package org.xyafu.app.pojo;

public class Music_mes {
    private String music_name;
    private String music_person;
    private int music_img;

    public Music_mes() {
    }

    public Music_mes(String music_name, String music_person, int music_img) {
        this.music_name = music_name;
        this.music_person = music_person;
        this.music_img = music_img;
    }

    public int getMusic_img() {
        return music_img;
    }

    public void setMusic_img(int music_img) {
        this.music_img = music_img;
    }

    public String getMusic_name() {
        return music_name;
    }

    public void setMusic_name(String music_name) {
        this.music_name = music_name;
    }

    public String getMusic_person() {
        return music_person;
    }

    public void setMusic_person(String music_person) {
        this.music_person = music_person;
    }
}
