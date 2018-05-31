package top.toptool.constant;

import org.springframework.util.StringUtils;

/**
 * 博客状态
 *
 * @author yuyufeng
 * @date 2017/8/7
 */
public enum StatusEnum {
    NORMAL("0", "正常"), FORBIDDEN("1", "禁止");
    private String key;
    private String value;

    StatusEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String getValue(String key) {
        if (StringUtils.isEmpty(key)) {
            return "";
        }
        for (StatusEnum statusEnum : StatusEnum.values()) {
            if (statusEnum.getKey().equals(key)) {
                return statusEnum.value;
            }
        }
        return "unknow";
    }

    public static StatusEnum[] getBlogStatusEnumValues(){
        return StatusEnum.values();
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
