package com.manga.punpun.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.manga.punpun.model.entity.MangaCharacter;

public interface CharacterRepository extends JpaRepository<MangaCharacter, Integer> {
}
