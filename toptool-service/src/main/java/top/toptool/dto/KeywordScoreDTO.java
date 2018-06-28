package top.toptool.dto;

/**
 * @author yuyufeng
 * @date 2017/11/7
 */
public class KeywordScoreDTO {
    private String key;
    private float significance;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public float getSignificance() {
        return significance;
    }

    public void setSignificance(float significance) {
        this.significance = significance;
    }
}
