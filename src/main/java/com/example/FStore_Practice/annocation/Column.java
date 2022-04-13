package com.example.FStore_Practice.annocation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) //quyết định đối tượng sử dụng
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    String name();
    String type();


}
