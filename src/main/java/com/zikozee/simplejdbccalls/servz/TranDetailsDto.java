package com.zikozee.simplejdbccalls.servz;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author : Ezekiel Eromosei
 * @created : 22 Jan, 2022
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TranDetailsDto {

    private String tranId;
    private LocalDateTime createdDate;
    private double charge;
    private double amount;
}
