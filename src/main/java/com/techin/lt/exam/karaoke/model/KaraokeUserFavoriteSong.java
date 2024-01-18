package com.techin.lt.exam.karaoke.model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.UUID;

@Entity
@Table(name = "favorite_songs")
public class KaraokeUserFavoriteSong {

    @Id
    @UUID
    @Column(name="user_uuid")
    private String uuid;

    @Column(name = "artist")
    private String artist;

    @Column(name = "song_title")
    private String title;

    public KaraokeUserFavoriteSong() {
    }

    public KaraokeUserFavoriteSong(String uuid, String artist, String title) {
        this.uuid = uuid;
        this.artist = artist;
        this.title = title;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "KaraokeUserFavoriteSong{" +
                "uuid='" + uuid + '\'' +
                ", artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
