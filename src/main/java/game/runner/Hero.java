package game.runner;

import java.text.DecimalFormat;

public class Hero {
    public int lv;
    public int zz;
    public int totalZz;
    public String name;
    public int id;
    public int zzexp;
    public int aepE1;   //武力属性
    public int allzz1;

    @Override
    public String toString() {
        return id + "-" + name + "-" + lv + ":" + zz;
    }

    public String toCsv(){
        DecimalFormat df = new DecimalFormat("#.00");
        double zhanli = (double)(zz * lv) / 20000 + + (double)(aepE1) / 100000000;;

        return name + "," + id + "," + lv + "," + zz +"," + df.format(zhanli) + "," + allzz1+ "," + zzexp
                + "," + totalZz ;
    }
}
