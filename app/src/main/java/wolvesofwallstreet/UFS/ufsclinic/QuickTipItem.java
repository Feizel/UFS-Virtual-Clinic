package wolvesofwallstreet.UFS.ufsclinic;

public class QuickTipItem {
    private int imageResource;
    private String title;
    private String content;

    public QuickTipItem(int imageResource, String title, String content) {
        this.imageResource = imageResource;
        this.title = title;
        this.content = content;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}

