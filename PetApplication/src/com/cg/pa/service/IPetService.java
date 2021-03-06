package com.cg.pa.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cg.pa.bean.PetBean;
import com.cg.pa.exception.PetException;

public interface IPetService 
{
	public String addPetOwnerDetails(PetBean pet) throws PetException, ClassNotFoundException, SQLException, IOException;
	public PetBean viewPetOwnerDetails(String petOwnerId) throws PetException, ClassNotFoundException, IOException, SQLException;
	public List<PetBean> retriveAll()throws PetException;
	

}
