package com.example.e_comerce.domaine;

public class categorie_dom {
    private String title;
    private String pic;

    public categorie_dom(){

    }
    public categorie_dom(String title, String pic) {
        this.title = title;
        this.pic = pic;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
