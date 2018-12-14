package com.cg.pa.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.cg.pa.util.*;
import com.cg.donor.bean.DonorBean;
import com.cg.donor.util.DBConnection;
import com.cg.pa.bean.PetBean;
import com.cg.pa.exception.PetException;

public class PetDaoImpl implements IPetDAO
{

	@Override
	public String addPetOwnerDetails(PetBean db) throws PetException, SQLException, ClassNotFoundException, IOException 
	{
		Connection con= DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		Statement st=con.createStatement();
		
		String ownerId=null;
		int queryResult=0;
		
		try
		{
			preparedStatement=con.prepareStatement("insert into pet_owner_details values(pet_seq.nextval,?,?,?,?)");
			
			preparedStatement.setString(1, db.getOwnerName());
			preparedStatement.setString(2, db.getOwnerPhNo());
			preparedStatement.setString(3, db.getOwnerAge());
			preparedStatement.setString(4, db.getVaccineDate());
			
			
			preparedStatement.executeUpdate();
			
			
			resultSet=st.executeQuery("select * from pet_owner_details" );
			while(resultSet.next())
			{
				ownerId = resultSet.getString(1);
				System.out.println(" Owner ID: "+resultSet.getString(1)+" Owner Name: "+resultSet.getString(2)+" Ph-no: "+resultSet.getString(3)+" Owner Age: "+resultSet.getString(4)+" Vaccine Date is: "+resultSet.getString(5));
			}
			return ownerId;
		}
		
		
		catch(SQLException sql)
		{
			System.out.println("error:"+sql.getMessage());
		}
		
		
		return null;
		
	}
	@Override
	public PetBean viewPetOwnerDetails(String petOwnerId) throws PetException, ClassNotFoundException, IOException, SQLException 
	{
		Connection con= DBConnection.getConnection();
		Statement st=con.createStatement();
		PetBean Bean=new PetBean();
		ResultSet resultSet=null;
		
		resultSet=st.executeQuery("select * from pet_owner_details where owner_Id='"+petOwnerId+"'" );
		while(resultSet.next())
		{
		Bean.setOwnerId(resultSet.getString(1));
		Bean.setOwnerName(resultSet.getString(2));
		Bean.setOwnerPhNo(resultSet.getString(3));
		Bean.setOwnerAge(resultSet.getString(4));
		Bean.setVaccineDate(resultSet.getString(5));
		}
		return Bean;
		
	}
	
	@Override
	public List<PetBean> retriveAll() throws PetException 
	{
		Connection con= DBConnection.getConnection();
		Statement st=con.createStatement();
		//DonorBean Bean=new DonorBean();
		List<PetBean> list=null;
		ResultSet rs=null;
		
		rs=st.executeQuery("select * from pet_owner_details order by owner_id");
		list=new ArrayList<>();
		while(rs.next())
		{
			PetBean Bean=new PetBean();
			
			Bean.setOwnerId(rs.getString(1));

			Bean.setOwnerName(rs.getString(2));
			Bean.setOwnerPhNo(rs.getString(3));
			Bean.setOwnerAge(rs.getString(4));
			Bean.setOwnerAge(rs.getString(5));
			));
			//donorId=rs.getString(1);
			list.add(Bean);
			
		}
		return list;
	}
}
