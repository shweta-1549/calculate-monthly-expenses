package com.calculate.CalculateProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.calculate.CalculateProject.model.Registration;
import com.calculate.CalculateProject.repository.RegistractionRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    @Qualifier("regRepo")
    private RegistractionRepository regRepo;
	@Override
	public Registration insertrecord(Registration r) {
		// TODO Auto-generated method stub
		return regRepo.save(r);
	}

	@Override
	public List<Registration> getAll() {
		// TODO Auto-generated method stub
		return regRepo.findAll();
	}

	@Override
	public void del(int ri) {
		// TODO Auto-generated method stub
		regRepo.deleteById(ri);
	}

	@Override
	public Registration updaterecord(Registration r) {
		Optional<Registration> opt=regRepo.findById(r.getRegid());
		if(opt.isPresent())
		{
			Registration rold=opt.get();
			rold.setName(r.getName());
			rold.setAddress(r.getAddress());
			rold.setCity(r.getCity());
			rold.setGender(r.getGender());
			rold.setContact(r.getContact());
			rold.setEmailid(r.getEmailid());
			rold.setPassword(r.getPassword());
			 return regRepo.save(rold);
		}
		return null;
	}

}
