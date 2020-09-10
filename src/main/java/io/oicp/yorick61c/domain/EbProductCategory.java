package io.oicp.yorick61c.domain;

/**
 * @Description: 用一句话描述
 * @Auther: 新梦想*陈超
 * @Date: 2019-10-27 15:41
 */
public class EbProductCategory {
    private int epcId;
    private String epcName;
    private int epcParentId;

    public int getEpcId() {
        return epcId;
    }

    public void setEpcId(int epcId) {
        this.epcId = epcId;
    }

    public String getEpcName() {
        return epcName;
    }

    public void setEpcName(String epcName) {
        this.epcName = epcName;
    }

    public int getEpcParentId() {
        return epcParentId;
    }

    public void setEpcParentId(int epcParentId) {
        this.epcParentId = epcParentId;
    }

    @Override
    public String toString() {
        return "EbProductCategory{" +
                "epcId=" + epcId +
                ", epcName='" + epcName + '\'' +
                ", epcParentId=" + epcParentId +
                '}';
    }
}
