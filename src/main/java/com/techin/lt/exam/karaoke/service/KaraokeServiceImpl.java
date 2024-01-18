package com.techin.lt.exam.karaoke.service;

import com.techin.lt.exam.karaoke.model.KaraokeUserFavoriteSong;
import com.techin.lt.exam.karaoke.model.dao.FavoriteSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KaraokeServiceImpl implements KaraokeService{

    private final FavoriteSongRepository favoriteSongRepository;

    @Autowired
    public KaraokeServiceImpl(FavoriteSongRepository favoriteSongRepository) {
        this.favoriteSongRepository = favoriteSongRepository;
    }

    @Override
    public List<KaraokeUserFavoriteSong> findAll() {
       return this.favoriteSongRepository.findAll();
    }

    @Override
    public KaraokeUserFavoriteSong findByUuid(String uuid) {
        Optional<KaraokeUserFavoriteSong> result= favoriteSongRepository.findById(uuid);
        KaraokeUserFavoriteSong karaokeUserFavoriteSong= null;
        if (result.isPresent()){
            karaokeUserFavoriteSong = result.get();
        }
        else {
            throw new RuntimeException("Did not find song with uuid- " + uuid);
        }
        return karaokeUserFavoriteSong;
    }

    @Override
    public KaraokeUserFavoriteSong save(KaraokeUserFavoriteSong karaokeUserFavoriteSong) {
        return favoriteSongRepository.save(karaokeUserFavoriteSong);
    }

    @Override
    public void deleteByUuid(String uuid) {
        favoriteSongRepository.deleteById(uuid);
    }
}
