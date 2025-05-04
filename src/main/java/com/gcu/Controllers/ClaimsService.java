package com.gcu.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.Repository.ClaimsRepository;
import com.gcu.models.ClaimsModel;

@Service
public class ClaimsService {
	
	@Autowired
	private ClaimsRepository claimsRepository;
	
	public List<ClaimsModel> getAllClaims() {
		return claimsRepository.findAll();
	}

}
