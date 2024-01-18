package com.techin.lt.exam.karaoke.controller;

import com.techin.lt.exam.karaoke.model.KaraokeUserFavoriteSong;
import com.techin.lt.exam.karaoke.service.KaraokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class KaraokeController {
    private KaraokeService karaokeService;

    @Autowired
    public KaraokeController(KaraokeService karaokeService) {
        this.karaokeService = karaokeService;
    }

    @GetMapping("/favorites")
    public List<KaraokeUserFavoriteSong> findAll(){
        return karaokeService.findAll();
    }

    @GetMapping("/favorites/{uuid}")
    public KaraokeUserFavoriteSong getUserSongByUuid(@PathVariable String uuid){
        KaraokeUserFavoriteSong karaokeUserFavoriteSong = karaokeService.findByUuid(uuid);
        if (karaokeUserFavoriteSong == null){
            throw new RuntimeException("Song with user id" + uuid  + "entry not found!");
        }
        return karaokeUserFavoriteSong;
    }

    @PostMapping("/favorites")
    public KaraokeUserFavoriteSong addFavoriteSong(@RequestBody KaraokeUserFavoriteSong karaokeUserFavoriteSong){
        return karaokeService.save(karaokeUserFavoriteSong);
    }

    @DeleteMapping("favorites/{uuid}")
    public String deleteFavoriteSong(@PathVariable String uuid){
        KaraokeUserFavoriteSong karaokeUserFavoriteSong = karaokeService.findByUuid(uuid);

        if (karaokeUserFavoriteSong == null){
            throw new RuntimeException("Song with user id" + uuid  + "entry not found!");
        }
        karaokeService.deleteByUuid(uuid);
        return "Favorite song removed from list";
    }
}
