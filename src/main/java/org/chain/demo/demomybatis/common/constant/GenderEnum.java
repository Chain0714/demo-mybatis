package org.chain.demo.demomybatis.common.constant;

import lombok.Getter;

import java.util.stream.Stream;

/**
 * The enum Gender enum.
 *
 * @author Chain
 * @program demo -mybatis
 * @description 性别枚举类型
 * @date 2019 -11-16 14:26
 */
@Getter
public enum GenderEnum {

    /**
     * Unknown gender enum.
     */
    UNKNOWN(0, "未知"),
    /**
     * Male gender enum.
     */
    MALE(1, "男性"),
    /**
     * Female gender enum.
     */
    FEMALE(2, "女性");

    private Integer code;
    private String desc;

    GenderEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static GenderEnum valueOfCode(Integer code) {
        return Stream.of(GenderEnum.values()).filter(o -> o.getCode().equals(code)).findFirst().orElse(UNKNOWN);
    }

    public static GenderEnum valueOfDesc(String desc) {
        return Stream.of(GenderEnum.values()).filter(o -> o.getDesc().equals(desc)).findFirst().orElse(UNKNOWN);
    }
}
