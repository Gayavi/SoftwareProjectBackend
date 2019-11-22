package com.audelia.backend.loginregistration.loginregistration.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class ImagePath {


    @Autowired
    Environment environment;

    public ImagePath() {
    }

    public String getBaseFolderPath() {
        String image_saving_path = environment.getProperty("image_saving_path");
        return image_saving_path;
    }

    public String getNewsImagePath() {
        String image_saving_path = environment.getProperty("image_saving_path");
        String news_images = environment.getProperty("news_images");
        return image_saving_path + news_images;
    }

    public String getTeacherProfileImagePath() {
        String image_saving_path = environment.getProperty("image_saving_path");
        String profile_images_teacher = environment.getProperty("profile_images_teacher");
        return image_saving_path + profile_images_teacher;
    }

    public String getStudentProfileImagePath() {
        String image_saving_path = environment.getProperty("image_saving_path");
        String profile_images_student = environment.getProperty("profile_images_student");
        return image_saving_path + profile_images_student;
    }

    public String getAdminProfileImagePath() {
        String image_saving_path = environment.getProperty("image_saving_path");
        String profile_images_admin = environment.getProperty("profile_images_admin");
        return image_saving_path + profile_images_admin;
    }

    public String getParentProfileImagePath() {
        String image_saving_path = environment.getProperty("image_saving_path");
        String profile_images_parent = environment.getProperty("profile_images_parent");
        return image_saving_path + profile_images_parent;
    }

    public String getArticlesImagePath() {
        String image_saving_path = environment.getProperty("image_saving_path");
        String articles_images = environment.getProperty("articles_images");
        return image_saving_path + articles_images;
    }

    public String getLearningMaterialImagePath() {
        String image_saving_path = environment.getProperty("image_saving_path");
        String learning_material_saving_path = environment.getProperty("learning_material");
        return image_saving_path + learning_material_saving_path;
    }

    public Environment getEnvironment() {
        return environment;
    }
}
