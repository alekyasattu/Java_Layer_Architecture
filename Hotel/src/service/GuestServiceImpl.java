package service;

import java.util.Set;

import dao.IGuestDao;
import entities.Guest;
import exceptions.IncorrectIdException;

public class GuestServiceImpl implements IGuestService {
	
	private IGuestDao dao;
	
	

	public GuestServiceImpl(IGuestDao dao) {
		this.dao = dao;
	}

	@Override
	public void addGuest(Guest g) {
		dao.addGuest(g);

	}

	@Override
	public Guest findGuestById(int id) {
		 if (id < 0) {
	            throw new IncorrectIdException("id is incorrect");
	        }
		 Guest g = dao.findGuestById(id);
		return g;
	}

	@Override
	public Set<Guest> allGuests() {
		
		Set<Guest> guests = dao.allGuests();
		return guests;
	}
	
	@Override
	public Set<Guest> allGuestsInorder(boolean order){
		Set<Guest> guests = dao.allGuestsInorder(order);
		return guests;
	}

}
