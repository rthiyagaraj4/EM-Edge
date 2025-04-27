/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;
import java.io.*;
import java.util.*;
import java.sql.*;
import eBL.Common.*;
import webbeans.eCommon.*;
import eCommon.Common.CommonAdapter;

public class BLSurgeryAddlChargeBean extends BlAdapter implements Serializable
{
	protected String patient_id					= "";
	protected String encounter_id				= "";
	protected String patient_class				= "";
	protected String visit_id					= "";
	protected String episode_id					= "";
	protected String episode_type				= "";
	protected String pract_id					= "";
	HashMap hashServiceString = new HashMap();
	HashMap hashSelectedServPanlCodes			= new HashMap();

	public BLSurgeryAddlChargeBean()
	{	
		System.out.println("Bean Initialized");
	}

	public HashMap validate() throws Exception
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." );
		return map;
	}
   
	public void  setPatientId(String  patient_id) { this.patient_id = checkForNull(patient_id,""); }
	public void  setEncounterId(String  encounter_id) { this.encounter_id = checkForNull(encounter_id,""); }
	public void  setPatientClass(String patient_class) { this.patient_class = checkForNull(patient_class,""); }
	public void  setVisitId(String visit_id) { this.visit_id = checkForNull(visit_id,""); }
	public void  setEpisodeId(String episode_id) { this.episode_id = checkForNull(episode_id,""); }
	public void  setEpisodeType(String episode_type) { this.episode_type = checkForNull(episode_type,""); }
	public void  setPractId(String pract_id) { this.pract_id = checkForNull(pract_id,""); }

	public String getPatientId() { return this.patient_id ; }
	public String getEncounterId() { return this.encounter_id ; }
	public String getPatientClass() { return this.patient_class; }
	public String getVisitId() { return this.visit_id; }
	public String getEpisodeId() { return this.episode_id; }
	public String getEpisodeType() { return this.episode_type; }
	public String getPractId() { return this.pract_id; }
   
		

	public boolean setServiceString (HashMap property_value ) throws Exception
	{
//		System.out.println("inside set method");
		boolean status = false;
		try
		{
			if(property_value != null)
			{
				hashServiceString.put("service_string"	,(HashMap)property_value);
			}
			
			status	= true;
//		System.out.println("hashServiceString"+hashServiceString);
		}		
		catch(Exception e)
		{
			status	= false;
			System.err.println("Exception in setSelectedServPanlDtls method"+e.toString());
			throw new Exception("Exception when setting the Serv/Panl Dtls");
			
		} 
		return status;
	}

	public HashMap getServiceString(String catlog_code) throws Exception
	{
		HashMap serv_string  =	null;

		try
		{
			serv_string = (HashMap) hashServiceString.get(catlog_code);
		}
		catch(Exception e)
		{
			System.err.println("Exception in getSelectedServPanlDtls method "+e.toString());
			throw new Exception("When Retrieving from the Bean");
		}
		return serv_string;
	}

	

	public ArrayList getDiscountLine (String order_catalog_code) throws Exception
	{
		Connection connection 		= null;
		//CallableStatement cstmt 	= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList disc_line	= new ArrayList() ;
	//	String[]  disc_str	= new String[12];	
		String disc_perc1="",disc_perc2="",disc_perc3="",disc_perc4="",disc_perc5="";
		try
		{
			connection	= getConnection();
			pstmt = connection.prepareStatement( " SELECT DISC_PERC1, DISC_PERC2, DISC_PERC3,DISC_PERC4,DISC_PERC5 FROM  BL_OT_ADDL_SERV_HDR WHERE ORDER_CATALOG_CODE='"+order_catalog_code+"'");
			resultSet = pstmt.executeQuery();	
			while(resultSet.next())
			{
				disc_perc1  =  resultSet.getString(1);		
				disc_perc2  =  resultSet.getString(2);		
				disc_perc3  =  resultSet.getString(3);		
				disc_perc4  =  resultSet.getString(4);		
				disc_perc5  =  resultSet.getString(5);		

			}
//			System.out.println("disc_perc1 :"+disc_perc1);
//			System.out.println("disc_perc1 :"+disc_perc2);
//			System.out.println("disc_perc1 :"+disc_perc3);
//			System.out.println("disc_perc1 :"+disc_perc4);
//			System.out.println("disc_perc1 :"+disc_perc5);
			disc_line.add(disc_perc1);
			disc_line.add(disc_perc2);
			disc_line.add(disc_perc3);
			disc_line.add(disc_perc4);
			disc_line.add(disc_perc5);
		}
		
		catch ( Exception e )
		{
			System.err.println( "When getting disc info"+e ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally
		{
			closeResultSet( resultSet ) ;			
			closeStatement( pstmt);
			closeConnection(connection);
		}
		return disc_line;
	}

	public void clearBean()
	{
		if( hashSelectedServPanlCodes != null )
	 	{
	 		hashSelectedServPanlCodes.clear();
	 	}
		else
		{
			hashSelectedServPanlCodes	= new java.util.HashMap();
		}

		if(hashServiceString != null)
		{
			hashServiceString.clear();
		}
		else
		{
			hashServiceString = new java.util.HashMap();
		}
	}
}
