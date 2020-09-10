package io.oicp.yorick61c.domain;

/**
 * @Description: 用一句话描述
 * @Auther: 新梦想*陈超
 * @Date: 2019-10-27 15:41
 */
public class EbNews {
    //属性--字段
    //字段：en_id(int)---属性：enId(int)
    private int enId;//新闻的编号
    //字段：en_title(varchar)---属性：enTitle(String)
    private String enTitle;//新闻标题
    private String enContent;//新闻的内容
    //数据库：datetime---java：String或者Date
    private String enCreateTime;//录入的日期

    //get/set方法

    public int getEnId() {
        return enId;
    }

    public void setEnId(int enId) {
        this.enId = enId;
    }

    public String getEnTitle() {
        return enTitle;
    }

    public void setEnTitle(String enTitle) {
        this.enTitle = enTitle;
    }

    public String getEnContent() {
        return enContent;
    }

    public void setEnContent(String enContent) {
        this.enContent = enContent;
    }

    public String getEnCreateTime() {
        return enCreateTime;
    }

    public void setEnCreateTime(String enCreateTime) {
        this.enCreateTime = enCreateTime;
    }

    @Override
    public String toString() {
        return "EbNews{" +
                "enId=" + enId +
                ", enTitle='" + enTitle + '\'' +
                ", enContent='" + enContent + '\'' +
                ", enCreateTime='" + enCreateTime + '\'' +
                '}'+"\n";
    }
}
