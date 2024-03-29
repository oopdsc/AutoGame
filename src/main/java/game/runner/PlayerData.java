package game.runner;

import game.config.Flags;

public class PlayerData {
    public String username = "";
    public String openid = "";
    public String openkey = "";
    public int silu = 70;
    public int taofa = 70;

    public int zid = Flags.zid;
    public int zidbuy = Flags.zidbuy;
    public int zidCount = Flags.zidCount;
    public int cookid = Flags.cookid;
    public int cooknum = Flags.cooknum;

    public int shopnum = 0;
    public int vipLv = 0;

    //马云率
    public int wifeId = 33;

    public int[] hunt = {33, 38, 41};

    public int[] heroid = {0};
    public int[] mengguid = {0};
    public int[] geerdan = {0};
    public int hitBoss = 0;

    public boolean sonFood = true;

    public boolean yamen = Flags.yamen;

    public boolean yamenShop = Flags.yamenShop;

    public int[] mzid = {2, 1, 55, 33,34, 35, 37, 38, 39, 40, 41, 44, 23, 6, 16, 28};

    public static Integer[] commonSchool = {55, 33,34, 35, 36, 37, 38, 39, 40, 41,
            1, 44, 23, 6, 28, 2, 16,
              11, 12, 20, 24,
             26,
            8,  13, 10
            };
    public int deskNum = 20;
    public Integer[] schoolHero = {};
    public Integer[] noschoolHero = {};

    public String uid;
    public String token;

    public int buyItem3 = 0;
    public int buyItem2 = 0;
    public int buyItem1 = 0;

    public int buyXiongnu1 = 10;
    public boolean buyXiongnu2 = false;

    //军机
    public boolean buyItem0 = false;

    public int cpid = 0;

    public boolean openboss = false;

    public boolean isYanwu = false;
    public int yanwuRid = 1;
    public String yanwuFuId = "";

    public boolean huodong = false;

    public boolean housemake = false;

    public int cabinetIndex = 0;
    public int[] cabinetHeros = {};

    public int[] fubenId1 = {34, 36, 44, 41, 9};
    public int[] fubenId2 = {33, 55, 38, 23, 1};
    public int[] fubenId3 = {};

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getOpenkey() {
        return openkey;
    }

    public void setOpenkey(String openkey) {
        this.openkey = openkey;
    }

    public int getSilu() {
        return silu;
    }

    public void setSilu(int silu) {
        this.silu = silu;
    }

    public int getTaofa() {
        return taofa;
    }

    public void setTaofa(int taofa) {
        this.taofa = taofa;
    }

    public int getZid() {
        return zid;
    }

    public void setZid(int zid) {
        this.zid = zid;
    }

    public int getShopnum() {
        return shopnum;
    }

    public void setShopnum(int shopnum) {
        this.shopnum = shopnum;
    }

    public int[] getHunt() {
        return hunt;
    }

    public void setHunt(int[] hunt) {
        this.hunt = hunt;
    }

    public int getCpid() {
        return cpid;
    }

    public void setCpid(int cpid) {
        this.cpid = cpid;
    }

    public int[] getHeroid() {
        return heroid;
    }

    public void setHeroid(int[] heroid) {
        this.heroid = heroid;
    }

    public boolean isOpenboss() {
        return openboss;
    }

    public void setOpenboss(boolean openboss) {
        this.openboss = openboss;
    }

    public int getHitBoss() {
        return hitBoss;
    }

    public void setHitBoss(int hitBoss) {
        this.hitBoss = hitBoss;
    }

    public boolean isYamen() {
        return yamen;
    }

    public void setYamen(boolean yamen) {
        this.yamen = yamen;
    }

    public int[] getMengguid() {
        return mengguid;
    }

    public void setMengguid(int[] mengguid) {
        this.mengguid = mengguid;
    }

    public int getCookid() {
        return cookid;
    }

    public void setCookid(int cookid) {
        this.cookid = cookid;
    }

    public int[] getMzid() {
        return mzid;
    }

    public void setMzid(int[] mzid) {
        this.mzid = mzid;
    }

    public int getCooknum() {
        return cooknum;
    }

    public void setCooknum(int cooknum) {
        this.cooknum = cooknum;
    }

    public boolean isYanwu() {
        return isYanwu;
    }

    public void setYanwu(boolean yanwu) {
        isYanwu = yanwu;
    }

    public int getYanwuRid() {
        return yanwuRid;
    }

    public void setYanwuRid(int yanwuRid) {
        this.yanwuRid = yanwuRid;
    }

    public String getYanwuFuId() {
        return yanwuFuId;
    }

    public void setYanwuFuId(String yanwuFuId) {
        this.yanwuFuId = yanwuFuId;
    }

    public boolean isHuodong() {
        return huodong;
    }

    public void setHuodong(boolean huodong) {
        this.huodong = huodong;
    }

    public boolean isHousemake() {
        return housemake;
    }

    public void setHousemake(boolean housemake) {
        this.housemake = housemake;
    }
}
