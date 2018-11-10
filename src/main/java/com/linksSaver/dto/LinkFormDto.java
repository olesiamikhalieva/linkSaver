package com.linksSaver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkFormDto {
    private String tag1;
    private String tag2;
    private String tag3;
    private String linkName;
    private String description;
}
