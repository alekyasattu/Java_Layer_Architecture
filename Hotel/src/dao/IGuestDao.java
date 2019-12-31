package dao;

import java.util.Set;

import entities.Guest;

public interface IGuestDao {
	
	 void addGuest(Guest g);
	
	Guest findGuestById(int id);
	
	Set<Guest> allGuests();
	
	Set<Guest> allGuestsInorder(boolean order);

}
