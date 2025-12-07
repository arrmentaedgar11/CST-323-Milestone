package com.cst323.cloud.Data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.cst323.cloud.Data.Entity.PetsEntity;
import com.cst323.cloud.Data.Mapper.PetRowMapper;
import com.cst323.cloud.Data.Repository.PetsRepository;
import com.cst323.cloud.Models.PetModel;

@Service
public class PetsDataService implements DataAccessInterface {

    @Autowired
    private PetsRepository petsRepository;
    private DataSource datasource;
    private JdbcTemplate JdbcTemplateObject;
    private PetRowMapper rows;

    public PetsDataService(PetsRepository petsRepository, DataSource dataSource) {
        this.datasource = dataSource;
        System.out.println("~~Datasource: " + dataSource);
        this.petsRepository = petsRepository;
        this.JdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public PetsDataService(PetsRepository petsRepository) {
        System.out.println("In petRepository only creator");
        this.petsRepository = petsRepository;
    }

    public PetsDataService() {
        super();
    }

    @Override
    public List<PetsEntity> findAll() {
        System.out.println(" ~~ In FindAll(), before the JDBC query. Datasource: " + datasource);
        String sql = "SELECT * FROM catfish";
        List<PetsEntity> pets = new ArrayList<PetsEntity>();
        try {

            // Get all of the Entity Orders
            Iterable<PetsEntity> petsIterable = petsRepository.findAll();

            // Convert to a List and return the List
            pets = new ArrayList<PetsEntity>();
            petsIterable.forEach(pets::add);
        }
        /*
         * SqlRowSet srs = JdbcTemplateObject.queryForRowSet(sql);
         * while(srs.next()){
         * pets.add(new PetsEntity(srs.getLong("id"), srs.getString("pet_name"),
         * srs.getString("pet_desc"), srs.getString("pet_gender"),
         * srs.getString("pet_age"), srs.getString("pet_species"),
         * srs.getString("pet_status"), srs.getString("pet_pic")));
         * System.out.println(("In while statement for retrieving pets"));
         * }
         * }
         */
        catch (Exception e) {
            e.printStackTrace();
        }
        return pets;
    }

    @Override
    public PetModel findById(Long id) {
        // TODO Auto-generated method stub
        /* 
        String sql = "SELECT * FROM catfish WHERE id=" + id;
        PetsEntity pet = new PetsEntity();
        try {
            pet = JdbcTemplateObject.queryForObject(sql, new PetRowMapper());
        } catch (Exception e) {
            System.out.println(e);
        }
        PetModel petModel = new PetModel(pet.getId(), pet.getPetName(),
                pet.getPetDesc(),
                pet.getPetGender(),
                pet.getPetAge(),
                pet.getPetSpecies(),
                pet.getPetStatus(),
                pet.getPetPic());
        return petModel;
        */
       PetsEntity pet = petsRepository.findById(id).get();
       PetModel petModel = convertFromEntity(pet);
       return petModel;
       
    }

    @Override
    public boolean create(PetsEntity pet) {
        String sql = "INSERT INTO catfish (pet_name, pet_desc, pet_gender, pet_age, pet_species, pet_status, pet_pic) VALUES(?, ?, ?, ?, ?, ?, ?)";
        System.out.println("~~~ In create method in DataService");
        try {
            // this.petsRepository.save(pet);
            /*int rows = JdbcTemplateObject.update(sql,
                    pet.getPetName(),
                    pet.getPetDesc(),
                    pet.getPetGender(),
                    pet.getPetAge(),
                    pet.getPetSpecies(),
                    pet.getPetStatus(),
                    pet.getPetPic());

            System.out.println("Number of rows: " + rows);
            return rows == 1 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; */
        PetsEntity petCheck = petsRepository.save(pet);
        System.out.println("~~~~~ New pet name: " + petCheck.getPetName());
        if(petCheck == null) return false;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return true;
    }

    @Override
    public PetModel findByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByName'");
    }

    @Override
    public boolean update(PetsEntity pet) {
        try{
        PetsEntity petCheck = petsRepository.save(pet);
        if(petCheck == null) return false;}
        catch(Exception e){
            System.out.println(e);
        }
        return true;
    }

    @Override
    public void delete(Long id) {
        petsRepository.deleteById(id);
    }

    public PetModel convertFromEntity(PetsEntity entity){
        PetModel pet = new PetModel(entity.getId(), entity.getPetName(), entity.getPetDesc(), entity.getPetGender(), entity.getPetAge(), entity.getPetSpecies(), entity.getPetStatus(), entity.getPetPic());
        return pet;
    }

    public PetsEntity convertFromModel(PetModel petModel){
        PetsEntity pet = new PetsEntity(petModel.getId(), petModel.getPetName(), petModel.petDesc, petModel.petGender, petModel.petAge,
                petModel.petSpecies, petModel.petStatus, petModel.petPic);
        return pet;
    }

}
