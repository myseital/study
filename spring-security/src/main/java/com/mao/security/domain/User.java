package com.mao.security.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author myseital
 * @date 2022/8/30
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private String username;
    private String name;
    private List<String> roles;
}
