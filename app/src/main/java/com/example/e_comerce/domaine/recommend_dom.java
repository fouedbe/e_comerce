package com.example.e_comerce.domaine;

public class recommend_dom {
    private String title;
    private String pic;
    private String description;
    private String prix;

    public recommend_dom(){

    }

    public recommend_dom(String title, String pic, String description, String prix) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.prix = prix;

    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFee() {
        return prix;
    }

    public void setFee(String fee) {
        this.prix = prix;
    }


}
