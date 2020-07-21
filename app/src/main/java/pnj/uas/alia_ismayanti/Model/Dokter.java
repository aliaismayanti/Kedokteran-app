package pnj.uas.alia_ismayanti.Model;

import com.google.firebase.database.Exclude;

public class Dokter {
    private String name;
    private String gambarURL;
    private String key;
    private String description;
    private int position;

    public Dokter() {
        //empty constructor needed
    }
    public Dokter(int position){
        this.position = position;
    }
    public Dokter(String name, String imageUrl , String Des) {
        if (name.trim().equals("")) {
            name = "No Name";
        }
        this.name = name;
        this.gambarURL = imageUrl;
        this.description = Des;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGambarUrl() {
        return gambarURL;
    }
    public void setGambarUrl(String gambarUrl) {
        this.gambarURL = gambarUrl;
    }
    @Exclude
    public String getKey() {
        return key;
    }
    @Exclude
    public void setKey(String key) {
        this.key = key;
    }
}
