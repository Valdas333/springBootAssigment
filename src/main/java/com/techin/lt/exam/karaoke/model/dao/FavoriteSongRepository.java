package com.techin.lt.exam.karaoke.model.dao;

import com.techin.lt.exam.karaoke.model.KaraokeUserFavoriteSong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteSongRepository extends JpaRepository
        <KaraokeUserFavoriteSong, String>{
}
