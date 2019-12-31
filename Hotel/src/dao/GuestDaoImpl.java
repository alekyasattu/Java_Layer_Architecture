package dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import entities.Guest;
import exceptions.GuestNotFoundException;
import util.GuestComparator;
import util.GuestComparatordesc;

public class GuestDaoImpl implements IGuestDao {
	
	private Map<Integer,Guest> store = new HashMap<>();

	@Override
	public void addGuest(Guest g) {
		store.put(g.getId(),g);
		}

	@Override
	public Guest findGuestById(int id) {
		Guest g = store.get(id);
		
		if(g == null) {
			throw new GuestNotFoundException("incorrect id");
		}
		
		return g;
	}

	@Override
	public Set<Guest> allGuests() {
		Collection<Guest> guests = store.values();
		
		Set<Guest> guestset = new HashSet<Guest>(guests);
		
		return guestset;
	}
	
	@Override
	public Set<Guest> allGuestsInorder(boolean order){
		GuestComparator asc = new GuestComparator();
		GuestComparatordesc desc = new GuestComparatordesc();
		Collection<Guest> guests = store.values();
		if(order) {
			Set<Guest> set = new TreeSet<Guest>(asc);
			set.addAll(guests);
			return set;
		}
		
			
			Set<Guest> set = new TreeSet<Guest>(desc);
			set.addAll(guests);
			return set;
		
	}

}
