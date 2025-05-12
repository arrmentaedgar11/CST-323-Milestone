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
	
	public ClaimsModel getClaimById(Long id) {
		return claimsRepository.findById(id).orElse(null);
	}
	
	public void updateClaim(ClaimsModel claim) {
		claimsRepository.save(claim);
	}
	
	public void deleteClaim(Long id) {
		claimsRepository.deleteById(id);
	}

}
