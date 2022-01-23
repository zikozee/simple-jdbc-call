package com.zikozee.simplejdbccalls.mapper;

import com.zikozee.simplejdbccalls.servz.TranDetailsDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * @author : Ezekiel Eromosei
 * @created : 22 Jan, 2022
 */

public class TranDetailsMapper implements RowMapper<TranDetailsDto> {

    @Override
    public TranDetailsDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return TranDetailsDto.builder()
                .tranId(rs.getString(1))
                .createdDate(rs.getObject(2, LocalDateTime.class))
                .amount(rs.getDouble(3))
                .charge(rs.getDouble(4)).build();
    }
}
