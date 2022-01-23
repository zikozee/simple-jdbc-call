package com.zikozee.simplejdbccalls.servz;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Ezekiel Eromosei
 * @created : 22 Jan, 2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RouteCountDTO {

    private String routes;
    private long count;
}
