package com.linksSaver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkDto {
    private long id;
    private String linkName;
    private ThemeDto themeDto;
}
