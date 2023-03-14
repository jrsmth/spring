package com.jrsmiffy.springguru.recipes.controller;

import com.jrsmiffy.springguru.recipes.command.RecipeCommand;
import com.jrsmiffy.springguru.recipes.service.ImageService;
import com.jrsmiffy.springguru.recipes.service.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller @RequiredArgsConstructor @Slf4j
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

    @GetMapping("recipe/{id}/recipe-image") // FixMe :: naming could be better...
    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException {
        RecipeCommand recipeCommand = recipeService.findCommandById(Long.valueOf(id));
        Byte[] image = recipeCommand.getImage();

        if (image != null) {
            byte[] byteArray = new byte[image.length];

            int i = 0;
            for (Byte wrappedByte : image)
                byteArray[i++] = wrappedByte; // auto unboxing

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        } else {
            log.debug("[renderImageFromDB] Image is empty for recipe with id [{}]", id);
        }
    }

}