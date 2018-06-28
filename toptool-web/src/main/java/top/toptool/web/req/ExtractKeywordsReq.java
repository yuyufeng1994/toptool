package top.toptool.web.req;

import java.util.List;

/**
 * @author yuyufeng
 * @date 2018/6/27.
 */
public class ExtractKeywordsReq {
    private Integer k;
    private String text;
    private List<String> stopWords;

    public Integer getK() {
        return k;
    }

    public void setK(Integer k) {
        this.k = k;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getStopWords() {
        return stopWords;
    }

    public void setStopWords(List<String> stopWords) {
        this.stopWords = stopWords;
    }
}
