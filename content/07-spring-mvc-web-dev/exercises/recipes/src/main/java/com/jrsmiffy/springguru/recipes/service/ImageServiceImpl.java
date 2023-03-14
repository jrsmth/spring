package com.jrsmiffy.springguru.recipes.service;

import com.jrsmiffy.springguru.recipes.model.Recipe;
import com.jrsmiffy.springguru.recipes.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service @RequiredArgsConstructor @Slf4j
public class ImageServiceImpl implements ImageService {

    private final RecipeRepository recipeRepository;

    @Override @Transactional
    public void saveImageFile(Long recipeId, MultipartFile file) {
        try {
            Recipe recipe = recipeRepository.findById(recipeId).get();

            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;
            for (byte b : file.getBytes()) byteObjects[i++] = b;

            recipe.setImage(byteObjects);
            recipeRepository.save(recipe);

        } catch (IOException e) {
            // TODO: improve err handle
            log.error("Error occurred!", e);

            e.printStackTrace();
        }
    }
}
