package com.zikozee.simplejdbccalls.servz;

import com.zikozee.simplejdbccalls.mapper.TranDetailsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import java.sql.Types;
import java.util.List;
import java.util.Map;

/**
 * @author : Ezekiel Eromosei
 * @created : 22 Jan, 2022
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class SimpleCallsService {
    private final JdbcTemplate jdbcTemplate; // if multiple jdbc template wire it in here with @Qualifier

    public RouteCountDTO routeCountDTO(double charge){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("usingOutput"); //optional .withReturnValue();
        SqlParameterSource in = new MapSqlParameterSource().addValue("charge", charge);
        Map<String, Object> out = jdbcCall.execute(in);

        return RouteCountDTO.builder()
                .count((Integer) out.get("tranCount"))
                .routes((String)out.get("paymentRoutes"))
                .build();
    }

    public Page<TranDetailsDto> fetchRoutesPaged(String route1, String route2, PageQueryCriteria criteria){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("fetchCriteriaPageable")
                .declareParameters(
                        new SqlParameter("pageNumber", Types.INTEGER),
                        new SqlParameter("pageSize", Types.INTEGER),
                        new SqlParameter("charge", Types.FLOAT),
                        new SqlParameter("amount", Types.FLOAT),
                        new SqlParameter("route1", Types.VARCHAR),
                        new SqlParameter("route2", Types.VARCHAR)
                ).returningResultSet("list", new TranDetailsMapper());
//                ).returningResultSet("list", BeanPropertyRowMapper.newInstance(TranDetailsDto.class));

        Pageable pageable = CommonUtils.getPageable(criteria);

        Map<String, Object> out = jdbcCall.execute(  pageable.getPageNumber() ==0 ? 1 : pageable.getPageNumber(), pageable.getPageSize(), null, null, route1, route2);

        List<TranDetailsDto> details = (List<TranDetailsDto>) out.get("list");
        return new PageImpl<>(details, pageable, details.size());
    }

    public List<TranDetailsDto> fetchTop15(){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("fetchTop15")
//                .returningResultSet("list", new TranDetailsMapper());
                .returningResultSet("list", BeanPropertyRowMapper.newInstance(TranDetailsDto.class));

        Map<String, Object> out = jdbcCall.execute();

        List<TranDetailsDto> details = (List<TranDetailsDto>) out.get("list");
        return details;
    }
}
