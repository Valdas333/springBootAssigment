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
}
