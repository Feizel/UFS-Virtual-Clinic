package wolvesofwallstreet.UFS.ufsclinic;

public class Course {

    int id;
    String img, title, date, level, colour, text;



    public Course(int id, String img, String title, String date, String level, String colour, String text) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.date = date;
        this.level = level;
        this.colour = colour;
        this.text= text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}