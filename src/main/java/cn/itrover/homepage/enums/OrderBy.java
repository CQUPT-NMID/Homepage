package cn.itrover.homepage.enums;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/3/10 17:05
 */
public enum OrderBy {

    /**
     * 升序
     */
    ASC("asc"),
    /**
     *
     * 降序
     */
    DESC("desc");

    String value;

    public String getValue() {
        return value;
    }

    OrderBy(String value) {
        this.value = value;
    }

}
