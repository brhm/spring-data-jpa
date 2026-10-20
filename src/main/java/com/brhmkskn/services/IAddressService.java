package com.brhmkskn.services;

import java.util.List;

import com.brhmkskn.dto.DtoAddress;

public interface IAddressService {

	public DtoAddress saveAddress(DtoAddress Address);
	
	public List<DtoAddress> getAllAddresss();
	
	public DtoAddress getAddressById(Long id);
	
	public void deleteAddress(Long id);
	
	public DtoAddress updateAddress(Long id,DtoAddress updateAddress);
}
