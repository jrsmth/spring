package com.jrsmiffy.springguru.recipes.controller;

import com.jrsmiffy.springguru.recipes.service.ImageService;
import com.jrsmiffy.springguru.recipes.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller @RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;
    private final RecipeService recipeService;

    @GetMapping("recipe/{id}/image")
    public String showUploadForm(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));

        return "recipe/image-form";
    }

    @PostMapping("recipe/{id}/image")
    public String handleImagePost(@PathVariable String id, @RequestParam("image-file") MultipartFile file) {
        imageService.saveImageFile(Long.valueOf(id), file);

        return String.format("redirect:/recipe/%s/show", id);
    }
}