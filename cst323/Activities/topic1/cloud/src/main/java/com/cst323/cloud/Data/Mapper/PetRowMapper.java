package com.cst323.cloud.Data.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cst323.cloud.Data.Entity.PetsEntity;

public class PetRowMapper implements RowMapper<PetsEntity> {

    @Override
    public PetsEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new PetsEntity(rs.getLong("id"), rs.getString("pet_name"), rs.getString("pet_desc"),
                                rs.getString("pet_gender"), rs.getString("pet_age"), rs.getString("pet_species"), 
                                rs.getString("pet_status"), rs.getString("pet_pic"));
    }
    
}
