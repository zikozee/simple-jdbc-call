/**
 * COPYRIGHT (C) 2021, EQUITY GROUP HOLDINGS PLC AND/OR ITS AFFILIATES. ALL RIGHTS RESERVED.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * THE SOFTWARE IS EXPECTED TO WORK AS PROGRAMMED WITH ALL THE EXPECTED FEATURES.
 *
 * UNDER NO CONDITION SHOULD THIS PROGRAM BE COPIED, REPRODUCED, DISTRIBUTED,
 * PUBLISHED, DISPLAYED, PERFORMED, MODIFIED WITHOUT THE PERMISSION OF
 * EQUITY GROUP HOLDINGS PLC.
 */

package com.zikozee.simplejdbccalls.servz;

import lombok.Getter;
import lombok.Setter;



/**
 * @author : Ezekiel Eromosei
 * @created : 22 Sep, 2021
 */

@Getter
@Setter
public class PageQueryCriteria {

    private String query;


    String orderBy = "id";


    String sortOrder = "ASC";


    int currentPage = 1;

    Integer pageSize = 10;
}
