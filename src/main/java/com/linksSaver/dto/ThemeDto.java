package com.linksSaver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThemeDto {
    private String nameTheme;
    private Set<LinkDto> linkDtoSet;
}
