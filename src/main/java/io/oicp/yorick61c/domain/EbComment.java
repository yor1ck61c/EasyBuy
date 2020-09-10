package io.oicp.yorick61c.domain;

/**
 * @Description: 用一句话描述
 * @Auther: 新梦想*陈超
 * @Date: 2019-10-27 15:41
 */
public class EbComment {
    //编号
    private int ecId;
    //留言回复
    private String ecReply;
    //留言内容
    private String ecContent;
    //留言时间
    private String ecCreateTime;
    //回复时间
    private String ecReplyTime;
    //昵称
    private String ecNickName;

    public int getEcId() {
        return ecId;
    }

    public void setEcId(int ecId) {
        this.ecId = ecId;
    }

    public String getEcReply() {
        return ecReply;
    }

    public void setEcReply(String ecReply) {
        this.ecReply = ecReply;
    }

    public String getEcContent() {
        return ecContent;
    }

    public void setEcContent(String ecContent) {
        this.ecContent = ecContent;
    }

    public String getEcCreateTime() {
        return ecCreateTime;
    }

    public void setEcCreateTime(String ecCreateTime) {
        this.ecCreateTime = ecCreateTime;
    }

    public String getEcReplyTime() {
        return ecReplyTime;
    }

    public void setEcReplyTime(String ecReplyTime) {
        this.ecReplyTime = ecReplyTime;
    }

    public String getEcNickName() {
        return ecNickName;
    }

    public void setEcNickName(String ecNickName) {
        this.ecNickName = ecNickName;
    }

    @Override
    public String toString() {
        return "EbComment{" +
                "ecId=" + ecId +
                ", ecReply='" + ecReply + '\'' +
                ", ecContent='" + ecContent + '\'' +
                ", ecCreateTime='" + ecCreateTime + '\'' +
                ", ecReplyTime='" + ecReplyTime + '\'' +
                ", ecNickName='" + ecNickName + '\'' +
                '}'+"\n";
    }
}
