package com.brhmkskn.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brhmkskn.dto.DtoHome;
import com.brhmkskn.dto.DtoRoom;
import com.brhmkskn.entities.Home;
import com.brhmkskn.entities.Room;
import com.brhmkskn.repository.IHomeRepository;
import com.brhmkskn.services.IHomeService;


@Service
public class HomeServiceImpl implements IHomeService {

	@Autowired
	private IHomeRepository homeRepository;
	
	@Override
	public DtoHome getHomeById(Long id) {
		DtoHome dtoHome=new DtoHome();
		List<DtoRoom> dtoRooms=new ArrayList<>();
		Optional<Home> optional=homeRepository.findById(id);
		if(optional.isEmpty())
			return null;
		
		Home home=optional.get();
		List<Room> rooms=optional.get().getRoom();
		
		BeanUtils.copyProperties(home, dtoHome);
		if(rooms!=null && !rooms.isEmpty())
		for (Room room : rooms) {
			DtoRoom dtoRoom=new DtoRoom();
			BeanUtils.copyProperties(room, dtoRoom);
			dtoRooms.add(dtoRoom);
		}

		dtoHome.setRoom(dtoRooms);
		
		return dtoHome;
	}
	
}