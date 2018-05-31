package top.toptool.constant;

import org.springframework.util.StringUtils;

/**
 * 博客状态
 *
 * @author yuyufeng
 * @date 2017/8/7
 */
public enum CategoryEnum {
    ESSAYS("essays", "随笔"), FORKS("forks", "收藏"),NOTICE("notice","公告");
    private String key;
    private String value;

    CategoryEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String getValue(String key) {
        if (StringUtils.isEmpty(key)) {
            return "";
        }
        for (CategoryEnum blogStatusEnum : CategoryEnum.values()) {
            if (blogStatusEnum.getKey().equals(key)) {
                return blogStatusEnum.value;
            }
        }
        return "unknow";
    }

    public static CategoryEnum[] getBlogStatusEnumValues(){
        return CategoryEnum.values();
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
