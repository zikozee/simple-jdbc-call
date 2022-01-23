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

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


/**
 * @author : Ezekiel Eromosei
 * @created : 22 Sep, 2021
 */
public class CommonUtils {


    private CommonUtils(){}


    public static Pageable getPageable(PageQueryCriteria criteria) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.ASC, "Id"));
        if (criteria.getSortOrder().equalsIgnoreCase("ASC")) {
            sort = Sort.by(new Sort.Order(Sort.Direction.ASC, criteria.getOrderBy()));
        }
        if (criteria.getSortOrder().equalsIgnoreCase("DESC")) {
            sort = Sort.by(new Sort.Order(Sort.Direction.DESC, criteria.getOrderBy()));
        }

        return PageRequest.of(criteria.getCurrentPage(), criteria.getPageSize(), sort);
    }

}
