package com.audelia.backend.loginregistration.loginregistration.dto;

public class AdminNewsDTO extends SuperDTO{
    private int id;
    private String date;
    private String title;
    private String description;
    private String profile_uri;
    private AdminDTO adminDTO;

    public AdminNewsDTO() {
    }

    public AdminNewsDTO(int id, String date, String title, String description, String profile_uri, AdminDTO adminDTO) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.description = description;
        this.profile_uri = profile_uri;
        this.adminDTO = adminDTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfile_uri() {
        return profile_uri;
    }

    public void setProfile_uri(String profile_uri) {
        this.profile_uri = profile_uri;
    }

    public AdminDTO getAdminDTO() {
        return adminDTO;
    }

    public void setAdminDTO(AdminDTO adminDTO) {
        this.adminDTO = adminDTO;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
