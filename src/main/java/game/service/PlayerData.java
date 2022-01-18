package game.service;

import game.config.Flags;

public class PlayerData {

    public String username = "";

    public String openid = "";
    public String openkey = "";
    public int silu = 40;
    public int taofa = 40;
    public int zid = 28;
    public int zidbuy = Flags.zidbuy;
    public int zidCount = Flags.zidCount;

    public int shopnum = 0;

    public int vipLv = 0;

    public int wifeId = 1;

    public int[] hunt = {0, 0, 0};

    public int[] heroid = {0};
    public int[] mengguid = {0};
    public int hitBoss = 0;

    public int[] mzid = {0};

    public int cookid = 207;
    public int cooknum = 1;


    public int[] schoolHero = {1, 2, 6, 8, 10};

    public String uid;
    public String token;


    public boolean buyItem3 = false;
    public boolean buyItem2 = false;
    public boolean buyItem1 = false;
    public boolean buyItem0 = false;

    public boolean yamen = false;

    public int cpid = 0;

    public boolean openboss = false;

    public boolean isYanwu = false;
    public int yanwuRid = 1;
    public String yanwuFuId = "";

    public boolean huodong = false;

    public boolean housemake = false;

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

    public boolean isBuyItem3() {
        return buyItem3;
    }

    public void setBuyItem3(boolean buyItem3) {
        this.buyItem3 = buyItem3;
    }

    public boolean isBuyItem2() {
        return buyItem2;
    }

    public void setBuyItem2(boolean buyItem2) {
        this.buyItem2 = buyItem2;
    }

    public boolean isBuyItem1() {
        return buyItem1;
    }

    public void setBuyItem1(boolean buyItem1) {
        this.buyItem1 = buyItem1;
    }

    public boolean isBuyItem0() {
        return buyItem0;
    }

    public void setBuyItem0(boolean buyItem0) {
        this.buyItem0 = buyItem0;
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
