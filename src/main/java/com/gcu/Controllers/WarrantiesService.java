package com.gcu.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.Repository.WarrantiesRepository;
import com.gcu.models.WarrantyModel;

@Service
public class WarrantiesService {
	
	@Autowired
	private WarrantiesRepository warrantiesRepository;
	
	public List<WarrantyModel> getAllWarranties() {
		return warrantiesRepository.findAll();
	}

}
