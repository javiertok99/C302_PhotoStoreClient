package sg.edu.rp.webservices.c302_photostoreclient;

public class Details {
    private int photo_id;
    private String title;
    private String description;
    private String image;
    private int category_id;
    private String created_by;

    public Details(int photo_id, String title, String description, String image, int category_id, String created_by) {
        this.photo_id = photo_id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.category_id = category_id;
        this.created_by = created_by;
    }

    public int getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(int photo_id) {
        this.photo_id = photo_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
}
