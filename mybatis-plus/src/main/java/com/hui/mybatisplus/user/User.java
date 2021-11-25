package com.hui.mybatisplus.user;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;

}
