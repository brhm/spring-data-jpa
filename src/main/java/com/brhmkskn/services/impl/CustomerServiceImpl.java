package com.brhmkskn.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brhmkskn.dto.DtoAddress;
import com.brhmkskn.dto.DtoCustomer;
import com.brhmkskn.dto.DtoCustomerUI;
import com.brhmkskn.entities.Address;
import com.brhmkskn.entities.Customer;
import com.brhmkskn.repository.ICustomerRepository;
import com.brhmkskn.services.ICustomerService;


@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;
	
	@Override
	public DtoCustomer saveCustomer(DtoCustomerUI dtoCustomer) {
		DtoCustomer response=new DtoCustomer();
		Customer customer=new Customer();
		
		BeanUtils.copyProperties(dtoCustomer, customer);
		Customer dbCustomer=customerRepository.save(customer);
		
		BeanUtils.copyProperties(dbCustomer, response);
		return response;
	}

	@Override
	public List<DtoCustomer> getAllCustomers() {
		List<DtoCustomer> dtoList=new ArrayList<>();
		List<Customer> list=customerRepository.findAll();
		
		for (Customer customer:list) {
			DtoCustomer dtoCustomer = new DtoCustomer();
			BeanUtils.copyProperties(customer, dtoCustomer);
			dtoList.add(dtoCustomer);
		}
		
		return dtoList;
	}

	@Override
	public DtoCustomer getCustomerById(Long id) {
		DtoCustomer dtoCustomer=new DtoCustomer();
		DtoAddress dtoAddres=new DtoAddress();
		Optional<Customer> optional=customerRepository.findById(id);
		if(optional.isEmpty())
			return null;
		
		Customer customer=optional.get();
		Address address=optional.get().getAddress();
		
		BeanUtils.copyProperties(customer, dtoCustomer);
		BeanUtils.copyProperties(address, dtoAddres);

		dtoCustomer.setAddress(dtoAddres);
		
		return dtoCustomer;
	}
	

	@Override
	public void deleteCustomer(Long id) {
		Optional<Customer> optional=customerRepository.findById(id);		
		if(optional.isPresent())
			customerRepository.delete(optional.get());		
	}

	
	@Override
	public DtoCustomer updateCustomer(Long id, DtoCustomerUI updateCustomer) {
		Optional<Customer> optional=customerRepository.findById(id);
		DtoCustomer dto=new DtoCustomer();
		if(optional.isPresent())
		{
			Customer dbCustomer=optional.get();
			//dbCustomer.setBirthOfDate(updateCustomer.getBirthOfDate());
			//dbCustomer.setFirstName(updateCustomer.getFirstName());
			//dbCustomer.setLastName(updateCustomer.getLastName());
			
		 Customer updatedCustomer=	customerRepository.save(dbCustomer);
		 BeanUtils.copyProperties(updatedCustomer, dto);
		 return dto;
		}
		return dto;
	}
	

}
