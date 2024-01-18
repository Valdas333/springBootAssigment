package com.techin.lt.exam.karaoke.service;

import com.techin.lt.exam.karaoke.model.KaraokeUserFavoriteSong;

import java.util.List;

public interface KaraokeService {
    List <KaraokeUserFavoriteSong> findAll();
    KaraokeUserFavoriteSong findByUuid(String uuid);

    KaraokeUserFavoriteSong save(KaraokeUserFavoriteSong karaokeUserFavoriteSong);

    void deleteByUuid(String uuid);
}
