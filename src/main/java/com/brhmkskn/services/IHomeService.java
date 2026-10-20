package com.brhmkskn.services;

import java.util.List;

import com.brhmkskn.dto.DtoCustomer;
import com.brhmkskn.dto.DtoCustomerUI;
import com.brhmkskn.dto.DtoHome;

public interface IHomeService {
	
	public DtoHome getHomeById(Long id);
	
}
