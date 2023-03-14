package com.jrsmiffy.springguru.recipes.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    void saveImageFile(Long recipeId, MultipartFile file);

}
