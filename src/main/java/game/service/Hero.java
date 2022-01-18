package game.service;

public class Hero {
    public int lv;
    public int zz;
    public String name;
    public int id;

    @Override
    public String toString() {
        return id + "-" + name + "-" + lv + ":" + zz;
    }
}
