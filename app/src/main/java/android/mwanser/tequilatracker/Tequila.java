package android.mwanser.tequilatracker;

/**
 * Created by Wanser on 12/9/16.
 */

public class Tequila {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    private String type;
    private int stars;

    public Tequila(String name,String type, int stars){
        this.name=name;
        this.type=type;
        this.stars=stars;
    }
}
