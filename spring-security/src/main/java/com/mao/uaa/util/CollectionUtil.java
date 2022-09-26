package com.mao.uaa.util;

import org.springframework.security.core.GrantedAuthority;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author myseital
 * @date 2022/9/26
 */
public class CollectionUtil {
    public static TreeSet<? extends GrantedAuthority> toTreeSet(Collection<? extends GrantedAuthority> authorities) {
        return authorities.stream().collect(
            Collectors.toCollection(
                () -> new TreeSet<>(
                    Comparator.comparing(GrantedAuthority::getAuthority)
                )
            )
        );
    }

    public static List<?> convertObjectToList(Object obj) {
        List<?> list = new ArrayList<>();
        if (obj.getClass().isArray()) {
            list = Arrays.asList((Object[]) obj);
        } else if (obj instanceof Collection) {
            list = new ArrayList<>((Collection<?>) obj);
        }
        return list;
    }
}
