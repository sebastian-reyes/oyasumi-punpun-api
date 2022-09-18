package com.manga.punpun.interfaceService;

import com.manga.punpun.model.MangaCharacter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICharacterService {
    public Page<MangaCharacter> listCharacter(Pageable pageable);
    public MangaCharacter findCharacter(int id);
}
