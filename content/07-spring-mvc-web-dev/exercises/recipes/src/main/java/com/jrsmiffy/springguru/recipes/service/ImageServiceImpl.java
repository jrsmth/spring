package com.jrsmiffy.springguru.recipes.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service @Slf4j
public class ImageServiceImpl implements ImageService {

    @Override
    public void saveImageFile(Long recipeId, MultipartFile file) {
        log.debug("[saveImageFile] Received a file for recipe with id [{}]", recipeId);
    }
}
