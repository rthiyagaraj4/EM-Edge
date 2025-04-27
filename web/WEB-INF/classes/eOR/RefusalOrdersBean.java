/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	created
12/12/2011    IN029211       Chowminya G    Incident No: IN029211 - <‘Record Refusal’ of order set then view
											‘Existing Refusal’ system show only 1 order with multiple line>
15/02/2012    IN031116		 Menaka V		Functionality equivalent to 5.x, placing consultation order.		
24/09/2012    IN034904       Chowminya G     CRF-CA- Bru-HIMS-CRF-121/03-The Order is not Cancelled after we Record Refusal	
19/11/2012	  IN031304		 Karthi L	 	new method introduced to get order category code(IN035976)
19/02/2013	  IN037939		 Vijayakumar k	Issue 2: System is not allowing the user to perform the Record Refusal operation for the Pharmacy Order Catalog with Consent Form.
16/03/2013	  IN037783		 Chowminya G	Special character in the Consent Form in OR
22/07/2013    IN041421       Chowminya G    Special characters - While record consent "Internal Server Error" is displayed
01/08/2013    IN042027	     Chowminya G    Catalog Name Does Not Display In Refusal Form For Catalogs Which Does Not Have A Consent Attached	
24/08/2013    IN030284	 	 Chowminya G 	CRF:To capture Pre-consultation orders in Appointment Scheduling
12/09/2013    IN043091	 	 Karthi L	 	hough the order is refused (by recording refusal) but still the Order is displayed in Pending consents list
13/09/2013    IN030284.1 	 Chowminya G 	CRF:To capture Pre-consultation orders in Appointment Scheduling - to handle $ issue (replace $$ with ~~)
16/09/2013	  IN043389		 Chowminya G	CRF-PAS- Bru-HIMS-CRF-165.1/05	
--------------------------------------------------------------------------------------------------------------------------
Date			Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------------------
14/04/2017		IN063655		Vijayakumar K										GHL-SCF-1162
30/12/2020	    8882			Nijitha S		30/12/2020		Ramesh G			ML-MMOH-CRF-1571-US001
--------------------------------------------------------------------------------------------------------------------------
*/
package eOR; 

import java.io.* ;
import java.net.URLDecoder;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;
//import oracle.sql.CLOB;
import javax.servlet.*;
import javax.servlet.http.*;
import eOR.Common.* ;
import eCommon.Common.*;
import eOR.ORRefusalOrders.*;

public class RefusalOrdersBean extends OrAdapter implements java.io.Serializable 
{

	protected String patient_id="";
	protected String srlno="";
	protected String facility_id="";
	protected String encounter_id="";
	protected String patient_class="";
	protected String refeusal_type="";
	protected String neworderid="";
	protected String order_Line_num="";
	protected String order_catalog_code="";
	protected String order_catalog_desc="";
	protected String refused_reason="";
	protected String refused_date_time="";
	protected String refused_pract_id="";
	protected String curr_sys_date="";
	protected String consent_content = "";
	protected String refusal_form_id = "";
	protected String order_type_code = "";
	protected String location_code = "";
	protected String location_type = "";
	protected String priority = "";
	protected String refusal_pract_id="";
	protected String win_status="";
	protected String from_val = "";//--[IN034904]
	//protected Hashtable allValues = new Hashtable();

	protected ArrayList selectedCatalog = new ArrayList();
	protected ArrayList selectedCatalogValue = new ArrayList();
	protected ArrayList selectedOrderId = new ArrayList();//--[IN029211]

	protected ArrayList refusal_orderid;
	protected LinkedHashMap order_catalog_lookup			= new LinkedHashMap();
	protected ArrayList ar			= new ArrayList();
	ArrayList recordSet = new ArrayList();
	ArrayList dataRecordSet = new ArrayList();
	int orderSetCount = 0;
	protected String facilityid;//IN030284
	protected String apptrefno;//IN030284
	protected String from;//IN030284
	protected String to;//IN030284
	protected String flag;//IN030284

	public void setPriority(String priority)
	{
		this.priority = priority;
	}

	//--[IN034904] - Start
	public void setFromVal(String from_val)
	{
		this.from_val = from_val;
	}
	
	public String getFromVal()
	{
		return this.from_val;
	}
	//--[IN034904] - End
	
	public String getPriority()
	{
		return this.priority;
	}

	public void setOrderTypeCode(String code)
	{
		this.order_type_code = code;
	}

	public String getOrderTypeCode()
	{
		return this.order_type_code;
	}

	public void setLocationCode(String code)
	{
		this.location_code = code;
	}
	public String getLocationCode()
	{
		return this.location_code;
	}

	public void setLocationType(String type)
	{
		this.location_type = type;
	}
	public String getLocationType()
	{
		return this.location_type;
	}

	public void setRefusalFormID(String id)
	{
		this.refusal_form_id = id;
	}
	public String getRefusalFormID()
	{
		return this.refusal_form_id;
	}
	public void setConsentContent(String content)
	{
		this.consent_content = content;
	}
	public String getConsentContent()
	{
		return this.consent_content;

	}

/*public Hashtable getAllValues() {
	return allValues;
}*/
	public void setPatientId(String patient_id)
	{	
		this.patient_id = patient_id;	
	}

	public void setSrlno(String srlno)
	{				
		this.srlno = srlno;	
	}

	public void setFacilityId(String facility_id)
	{	
		this.facility_id = facility_id;	
	}

	public void setEncounterId(String encounter_id)
	{
		this.encounter_id = encounter_id;	
	}

	public void setPatientClass(String patient_class)
	{  
		this.patient_class = patient_class;	
	}

	public void setRefusalType(String refeusal_type)
	{   
		this.refeusal_type = refeusal_type;
	}

	public void setnewOrderId(String neworderid)
	{   	
		this.neworderid = neworderid;  
	}

	public void setOrderLineNum(String order_Line_num)
	{ 
		this.order_Line_num=order_Line_num;  
	}

	public void setOrderCatalogCode(String order_catalog_code)
	{  
		this.order_catalog_code=order_catalog_code;   
	}

	public void setOrderCatalogDesc(String order_catalog_desc)
	{  
		this.order_catalog_desc=order_catalog_desc; 
	}

	public void setRefusedReason(String refused_reason)
	{      
		this.refused_reason=refused_reason;  
	}

	public void setRefusedDateTime(String refused_date_time)
	{ 
	/* Thai date validations start 14/02/2007

     if(refused_date_time == null || refused_date_time.equals("null") || refused_date_time.equals("&nbsp;") || refused_date_time.equals(" ")) refused_date_time = "";
		if (!language_id.equals("en")){

	refused_date_time=com.ehis.util.DateUtils.convertDate(refused_date_time,"DMYHM",language_id,"en");
		}
	/* Thai date validations end 14/02/2007*/
		this.refused_date_time=refused_date_time; 
	}

	public void setRefusedPractId(String refused_pract_id)
	{    
		this.refused_pract_id=refused_pract_id;
	}

	public void setSelectedCatalog(String str)
	{
		if(!selectedCatalog.contains(str))
			this.selectedCatalog.add(str);
	}
	//IN030284 - Starts
	public String getfacilityid()
	{
		return this.facilityid;
	}

	public String getapptrefno()
	{
		return this.apptrefno;
	}
	public String getfrom()
	{
		return this.from;
	}
	public String getto()
	{
		return this.to;
	}
	public String getflag()
	{
		return this.flag;
	}
	public void setfacilityid(String facilityid)
	{   	
		this.facilityid = facilityid;  
	}

	public void setapptrefno(String apptrefno)
	{   	
		this.apptrefno = apptrefno;  
	}
	public void setfrom(String from)
	{   	
		this.from = from;  
	}
	public void setto(String to)
	{   	
		this.to = to;  
	}
	public void setflag(String flag)
	{   	
		this.flag = flag;  
	}
	//IN030284 - Ends
	public ArrayList getSelectedCatalog()
	{
		return this.selectedCatalog;
	}

	
	//--[IN029211] - Start
	public void setSelectedOrderId(String str)
	{
		if(!selectedOrderId.contains(str))
			this.selectedOrderId.add(str);
	}
	
	public ArrayList getSelectedOrderId()
	{
		return this.selectedOrderId;
	}
	
	public void remSelectedOrderId(String str)
	{
		if(selectedOrderId.contains(str))
		{
			int x = selectedOrderId.indexOf(str);
			selectedOrderId.remove(x);
		}
	}
	//--[IN029211] - End

	
	public void setSelectedCatalogValue(String str)
	{
		if(!selectedCatalogValue.contains(str))
			this.selectedCatalogValue.add(str);
	}

	public ArrayList getSelectedCatalogValue()
	{
		return this.selectedCatalogValue;
	}

	public void remSelectedCatalogValue(String str)
	{
		if(selectedCatalogValue.contains(str))
		{
			int x = selectedCatalogValue.indexOf(str);
			selectedCatalogValue.remove(x);
		}
	}

	public void remSelectedCatalog(String str)
	{
		if(selectedCatalog.contains(str))
		{
			int x = selectedCatalog.indexOf(str);
			selectedCatalog.remove(x);
		}
	}

	public void setRefusalOrderID(String refusal_order_id[])
	{
		refusal_orderid=new ArrayList();
		for(int i=0;i<refusal_order_id.length;i++)
		{
			refusal_orderid.add(refusal_order_id[i]);
		}
	}

//setRefusalOrderID written by subhash
//start
/*public void setRefusalOrderID()
{
	refusal_orderid=new ArrayList();
	refusal_orderid.add(this.neworderid);
	refusal_orderid.add(this.order_Line_num);
}*/
//end
	public void setCurrentDate(String curr_sys_date)
	{
		this.curr_sys_date= curr_sys_date;
	}

	public ArrayList getRefusalOrderID()
	{		
		refusal_orderid=new ArrayList();
		refusal_orderid.add(this.neworderid);		
		refusal_orderid.add(this.order_Line_num);		
		return refusal_orderid;
	}

	public String getPatientId()
	{
		return this.patient_id;
	}

	public String getSrlno()
	{	 
		return this.srlno;
	}

	public String getFacilityId()
	{	
		return this.facility_id;	
	}

	public String getEncounterId()
	{	
		return  this.encounter_id;	
	}

	public String getPatientClass()
	{
		return this.patient_class;
	}

	public String getRefusalType()
	{ 
		return this.refeusal_type;    
	}

	public String getnewOrderId()
	{ 
		return this.neworderid;  
	}

	public String getOrderLineNum()
	{ 
		return this.order_Line_num; 
	}

	public String getOrderCatalogCode()
	{  
		return this.order_catalog_code; 
	}

	public String getOrderCatalogDesc()
	{  
		return this.order_catalog_desc;  
	}

	public String getRefusedReason()
	{   
		return this.refused_reason; 
	}

	public String getRefusedDateTime()
	{ 
		return this.refused_date_time;
	}

	public String getRefusedPractId()
	{  
		return this.refused_pract_id;
	}

	public String getCurrentDate()
	{ 
		return this.curr_sys_date;
	}



	public void clear() 
	{
		super.clear();
		consent_content=null;
	}
	public void clearBean() 
	{
				
		refusal_orderid=null;
		selectedCatalog.clear();
		selectedCatalogValue.clear();
	}


	public ArrayList getOrderCategory() throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		ArrayList OrderCategory = new ArrayList() ;
		try
		{
		
			connection	= getConnection();				
			//pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST") ) ;//IN031116
			pstmt		= connection.prepareStatement("SELECT  short_desc,order_category FROM or_order_category_lang_vw  WHERE language_id=? ORDER BY short_desc") ;//IN031116
			pstmt.setString( 1, language_id);
			resultSet	= pstmt.executeQuery() ;

			if ( resultSet != null )
			{
				
				String[] record	= null;
				while(resultSet.next())
				{
					record 	  = new String[2];
					record[0] = resultSet.getString( "order_category" )  ;
					record[1] = resultSet.getString( "short_desc" )  ;

					OrderCategory.add(record) ;
				}
			}
		 }
		 catch ( Exception e )	
		 {
						
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return OrderCategory;
	}	 // End of the getOrderCategory
	
	public ArrayList getOrderCategoryOPOA() throws Exception 
	{

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderCategory = new ArrayList() ;

		try
		{
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_ORDER_CATEGORY_WITHOUT_PH") ) ;
			pstmt.setString(1,language_id);
			resultSet	= pstmt.executeQuery() ;

			if ( resultSet != null )
			{								
				String[] record	= null;
				while(resultSet.next())
				{
					record 	  = new String[2];
					record[0] = resultSet.getString( "order_category" )  ;
					record[1] = resultSet.getString( "short_desc" )  ;

					OrderCategory.add(record) ;
				}
			}
		 }
		 catch ( Exception e )	
		 {
						
			e.printStackTrace() ;
			throw e ;
		 }
		 finally
		 {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		 }
		return OrderCategory;
	}	 // End of the getOrderCategory

	public ArrayList getLocation(String location_type) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList Location = new ArrayList() ;

		try
		{
							
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_ORDER_TYPE") ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, location_type.trim() ) ;

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) 
			{
				String[] record = new String[2];
				record[0] = resultSet.getString( "order_type_code" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;
				Location.add(record) ;
			}
		}
		catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return Location;
	}
		
		
	public ArrayList getLocationOPOA(String location_type) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList Location = new ArrayList() ;

		try 
		{
				
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_TYPE_SELECT_WITHOUT_PH") ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, location_type.trim() ) ;

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) 
			{
				String[] record = new String[2];
				record[0] = resultSet.getString( "order_type_code" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;
				Location.add(record) ;
			}
		} 
		catch ( Exception e )	
		{			
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return Location;
	}

	public ArrayList getActivityType(String order_category, String order_type) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList ActivityType		= new ArrayList() ;

		try			
		{
					
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ACTIVITY_TYPE_SELECT") ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, order_category) ;
			pstmt.setString( 3, order_type) ;
			//pstmt.setString( 4, language_id);
			//pstmt.setString( 5, order_category) ;

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) 
			{
				String[] record = new String[2];
				record[0] = resultSet.getString( "activity_type" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;
				ActivityType.add(record) ;
			}
		} 
		catch ( Exception e )
		{
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return ActivityType;
	}

	public ArrayList getDisplayResult(String order_category,String order_type_code,String search_by,String description_code,String long_desc) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList RefusalOrderCat = new ArrayList() ;

		order_category=order_category.equals("")?null :order_category;
		order_type_code=order_type_code.equals("")?null :order_type_code;
		long_desc=long_desc.equals("")?null :long_desc;
		String msg="";

		try 
		{
			connection = getConnection() ;
				
			if(search_by.equals("D"))
			{
				msg="SQL_OR_1";
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue(msg) ) ;
				
				pstmt.setString( 1, order_category) ;
				pstmt.setString( 2, order_type_code ) ;
				pstmt.setString( 3, description_code) ;
				pstmt.setString( 4, long_desc) ;
				pstmt.setString( 5, long_desc) ;
				pstmt.setString( 6, long_desc) ;
				resultSet = pstmt.executeQuery() ;
			}
			//else if(search_by.equals("C"))
			//{
			//		msg="SQL_OR_2";
			//		pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue(msg) ) ;
					
			//}
					
			while ( resultSet != null && resultSet.next() ) 
			{
				String[] record = new String[2];
				record[0] = resultSet.getString( "order_catalog_code" )  ;
				record[1] = resultSet.getString( "long_desc" )  ;
				
				RefusalOrderCat.add(record) ;
			}
		} 
		catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		}
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return RefusalOrderCat;
	}

//for populating patient id and sex
	public ArrayList getLocation1(String patientId) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList Location = new ArrayList() ;

		try 
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER1") ) ;

			pstmt.setString(1,language_id);
			pstmt.setString(2, patientId.trim() ) ;

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) 
			{
				String[] record = new String[2];
				record[0] = resultSet.getString( "patient_name" )  ;
				record[1] = resultSet.getString( "regn_date" )  ;
				
				Location.add(record) ;

			}
		} 
		catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		} 
		finally
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return Location;
	}

//Display the System Date
	public String getSysDate1() throws Exception
	{
		 Connection connection 		= null;
		 PreparedStatement pstmt 	= null;
		 ResultSet resultSet 		= null;
		 String sys_date			= "";

		 try 
		{
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SCHEDULE_TODAY_DAY_TIME"));
		    resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    // Only one record for the date
			{
				while(resultSet.next())
				{
					sys_date = checkForNull(resultSet.getString( "sys_date_time" ),"")  ;

				}
			}
	 	} 
		catch ( Exception e )	
		{		
			e.printStackTrace() ;
			throw e ;
	 	} 
		finally 
		{
			closeResultSet( resultSet);
			closeStatement( pstmt);
			closeConnection(connection);
 		}
 		return sys_date;
 }

  public ArrayList getVisitAdminDetails(String patientId) throws Exception 
  {
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset = null;
        ArrayList arraylist = new ArrayList();

        try
        {
            connection = getConnection();
            preparedstatement = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_VISIT_TIME"));
            preparedstatement.setString(1,language_id);
			preparedstatement.setString(2,language_id);
			preparedstatement.setString(3,language_id);
			preparedstatement.setString(4,patientId.trim());
            String record[];
            while ( resultset != null && resultset.next() )
			{
                record = new String[5];
                record[0] = resultset.getString("encounter_id");
                record[1] = resultset.getString("facility_id");
                record[2] = resultset.getString("Assign_care_locn_type");
                record[3] = resultset.getString("Assign_care_locn_code");
                record[4] = resultset.getString("visit_adm_date_time");
				arraylist.add(record) ;
            }

        }
        catch(Exception exception)
        {
           
            exception.printStackTrace();
            throw exception;
        }
        finally
        {
            closeResultSet(resultset);
            closeStatement(preparedstatement);
            closeConnection(connection);
        }
        return arraylist;
    }

    public void setAll(Hashtable hashtable) 
	{
        if(hashtable.containsKey("patientId"))
            setPatientId((String)hashtable.get("patientId"));

        if(hashtable.containsKey("srlno"))
            setSrlno((String)hashtable.get("srlno"));

        if(hashtable.containsKey("facility_id"))
            setFacilityId((String)hashtable.get("facility_id"));

        if(hashtable.containsKey("encounterid"))
            setEncounterId((String)hashtable.get("encounterid"));

        if(hashtable.containsKey("patient_class"))
            setPatientClass((String)hashtable.get("patient_class"));

        if(hashtable.containsKey("refeusal_type"))
            setRefusalType((String)hashtable.get("refeusal_type"));

		if(hashtable.containsKey("refeusal_type1"))
            setRefusalType((String)hashtable.get("refeusal_type1"));

        if(hashtable.containsKey("neworderid"))
        {
			setnewOrderId((String)hashtable.get("neworderid"));
        }

        if(hashtable.containsKey("order_Line_num"))
           setOrderLineNum((String)hashtable.get("order_Line_num"));

        if(hashtable.containsKey("ordercode"))
		{
           setOrderCatalogCode((String)hashtable.get("ordercode"));
		}

		if(hashtable.containsKey("orderable"))
		{
           setOrderCatalogDesc((String)hashtable.get("orderable"));
        }
		else
           setOrderCatalogDesc((String)hashtable.get("NonOrderable"));

        if(hashtable.containsKey("reason"))
            setRefusedReason((String)hashtable.get("reason"));
        
		/* Thai date validations start 14/02/2007*/

		if(hashtable.containsKey("datetime"))
		{    
			String datetime=(String)hashtable.get("datetime");
			if(datetime == null || datetime.equals("null") || datetime.equals("&nbsp;") || datetime.equals(" ")) datetime = "";

			datetime=com.ehis.util.DateUtils.convertDate(datetime,"DMYHM",language_id,"en");
            setRefusedDateTime(datetime);
			
		}
		refusal_pract_id=(String)hashtable.get("practitionerId");

		/* Thai date validations start 14/02/2007*/
        if(hashtable.containsKey("practitionerId"))
		{

            setRefusedPractId((String)hashtable.get("practitionerId"));
		}
        if(hashtable.containsKey("curr_sys_date"))
            setCurrentDate((String)hashtable.get("curr_sys_date"));
        super.mode = (String)hashtable.get("mode");

		if(hashtable.containsKey("refusal_form"))
		{
			
			setRefusalFormID((String)hashtable.get("refusal_form"));
		}
		/*if(hashtable.containsKey("consent_content"))
		{
			setConsentContent((String)hashtable.get("consent_content"));
		}*/
		if(hashtable.containsKey("func_role_id"))
			setRefusedPractId((String)hashtable.get("func_role_id"));

		if(hashtable.containsKey("encounter_id"))
			setEncounterId((String)hashtable.get("encounter_id"));

		//if(hashtable.containsKey("patient_class"))
		//	setPatientClass((String)hashtable.get("patient_class"));
		if(hashtable.containsKey("order_type_code"))
			setOrderTypeCode((String)hashtable.get("order_type_code"));

		if(hashtable.containsKey("location_code"))
			setLocationCode((String)hashtable.get("location_code"));

		if(hashtable.containsKey("location_type"))
			setLocationType((String)hashtable.get("location_type"));

		if(hashtable.containsKey("order_catalog_code"))
			setOrderCatalogCode((String)hashtable.get("order_catalog_code"));

		if(hashtable.containsKey("order_catalog_desc"))
			setOrderCatalogDesc((String)hashtable.get("order_catalog_desc"));
		
		if(hashtable.containsKey("priority"))
			setPriority((String)hashtable.get("priority"));
		//--[IN034904] - Start	
		if(hashtable.containsKey("from_val"))
			setFromVal((String)hashtable.get("from_val"));	
		//--[IN034904] - End	
		//IN030284 - Start
		 if(hashtable.containsKey("facilityid"))
	  		setfacilityid((String)hashtable.get("facilityid"));
		  if(hashtable.containsKey("appt_ref_no"))
			setapptrefno((String)hashtable.get("appt_ref_no"));
		//IN030284 - End	
    }

    public HashMap insert()
    {
       // boolean flag = false;
        HashMap hashmap = new HashMap();
        //StringBuffer stringbuffer = new StringBuffer();
        hashmap.put("result", new Boolean(false));
       // String s = "";
        ArrayList arraylist = new ArrayList();
        ArrayList catalogs = new ArrayList(); //IN030284
        String catalog = "";//IN030284

		if(curr_sys_date == null || curr_sys_date.equals("null") || curr_sys_date.equals("&nbsp;") || curr_sys_date.equals(" ")) curr_sys_date = "";
		{
			curr_sys_date = com.ehis.util.DateUtils.convertDate(curr_sys_date,"DMYHM",language_id,"en");
		}
		//IN043091  - Start
        if(apptrefno == null || apptrefno.equals("null") )
		{
			apptrefno = "";
		}  // End
		if("".equals(apptrefno)) //IN030284 included to hand the catalog selection page from OA 
		{
	        arraylist.add(patient_id);
	        arraylist.add(srlno);
	        arraylist.add(facility_id);
	        arraylist.add(encounter_id);
	        arraylist.add(patient_class);
	        arraylist.add(refeusal_type);
	        arraylist.add(neworderid);
	        arraylist.add(order_Line_num);
	        arraylist.add(order_catalog_code);
	        arraylist.add(order_catalog_desc);
	        arraylist.add(refused_reason);           
	        arraylist.add(refused_date_time);
	       //arraylist.add(refused_pract_id);
	        arraylist.add(refusal_pract_id);
	        arraylist.add(login_by_id);
	        arraylist.add(login_at_ws_no);
	        arraylist.add(login_facility_id);
	        arraylist.add(login_by_id);
	        arraylist.add(login_at_ws_no);
	        arraylist.add(login_facility_id);
	        arraylist.add(curr_sys_date);
			arraylist.add(refusal_form_id);
			if(consent_content==null) consent_content= "";
			arraylist.add(consent_content);
			arraylist.add(location_code);
			arraylist.add(location_type);
			arraylist.add(order_type_code);
			arraylist.add(priority);
			arraylist.add(from_val);//--[IN034904]
		}
		else//IN030284 - Start
		{
	       
	    	Connection connection 		= null;
	    	PreparedStatement pstmt 	= null;
	    	ResultSet resultSet 		= null;
	    	String OrderCatalog = "";
	    	ArrayList OrderCatalogSelected = new ArrayList() ;
	    	String patient_id = "";
	    	String appt_status = "";
	    	//int result[] = {}; //Checkstyle
	    	String short_desc = "";
	    	String order_type_code = "";
	    	String order_category = "";
			
			try
			{
				connection	= getConnection();
				pstmt		= connection.prepareStatement("Select PATIENT_ID, APPT_STATUS from oa_appt where APPT_REF_NO=? ");
				pstmt.setString(1,apptrefno);
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{								
					while(resultSet.next())
					{
						patient_id 	  = resultSet.getString( "PATIENT_ID" );
						appt_status   = resultSet.getString( "APPT_STATUS" );
					}
				}
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			finally
			{
				try
				{
					closeResultSet(resultSet);
					closeStatement(pstmt);
					closeConnection(connection);
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			OrderCatalogSelected = getTempArrayList();
			
			for(int i=0;i<OrderCatalogSelected.size();i++)
			{
				OrderCatalog = (String)OrderCatalogSelected.get(i);
				//StringTokenizer strtData = new StringTokenizer(OrderCatalog,"$$");
				StringTokenizer strtData = new StringTokenizer(OrderCatalog,"~~");//IN030284.1 
				   
				while(strtData.hasMoreTokens())
				{   
					catalog			= (String) strtData.nextToken();
					short_desc		= (String) strtData.nextToken();
					order_type_code	= (String) strtData.nextToken();
					order_category	= (String) strtData.nextToken();
					strtData.nextToken();
					catalogs.add(catalog);
				}
				
			}
	        arraylist.add(apptrefno);
	        arraylist.add(facilityid);
	        arraylist.add(patient_id);
	        arraylist.add(appt_status);
	        arraylist.add(login_by_id);
	        arraylist.add(login_at_ws_no);
	        arraylist.add(login_facility_id);
	        arraylist.add(login_by_id);
	        arraylist.add(login_at_ws_no);
	        arraylist.add(login_facility_id);
		}//IN030284 - End
        HashMap hashmap1 = new HashMap();

        hashmap1.put("InsertData", arraylist);
        //IN030284 - Start
        if(!"".equals(apptrefno))
        {
            hashmap1.put("catalogs", catalogs);
            hashmap1.put("source", "Appt_orders");
        }
		else //IN043389
		{
			hashmap1.put("source", ""); //IN043091
		}
		
        //IN030284 - End
        hashmap1.put("properties", getProperties());
       
        HashMap hashmap2 = new HashMap();
        try
        {
        	//IN030284 - If condition included Start
        	if("".equals(apptrefno))
            {
	            hashmap2.put("SelectSQL", OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_SRL_NO"));
	            hashmap2.put("SelectSQL1", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_LINE_SELECT"));
	            hashmap2.put("InsertSQL", OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_INSERT"));
	            hashmap2.put("UpdateSQL", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_REFUSAL_CANCEL"));
	            hashmap2.put("SelectSQL2", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_LINE2"));
	            hashmap2.put("SelectSQL3", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_LINE3"));
	            hashmap2.put("SQL_OR_REFUSAL_ORDER_CLOB", OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_CLOB"));
	            hashmap2.put("SQL_OR_PLACE_ORDER_BILL_YN", OrRepositoryExt.getOrKeyValue("SQL_OR_PLACE_ORDER_BILL_YN"));//8882
	            
            }
        	else
        	{
        		hashmap2.put("InsertSQL", "INSERT INTO OR_APPT_REF_CATALOG(APPT_REF_NO, FACILITY_ID, ORDER_CATALOG_CODE, PATIENT_ID, APPT_STATUS,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID,  MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES(?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
        		hashmap2.put("CountSQL", "Select count(*) from OR_APPT_REF_CATALOG where APPT_REF_NO= ? ");
        		hashmap2.put("DeleteSQL", "Delete OR_APPT_REF_CATALOG where APPT_REF_NO = ? ");
        	}
        	//IN030284 - Ends
        }
        catch(Exception exception) 
		{ 
			exception.printStackTrace();
		}
        //Object obj = null;
       // ORRefusalOrdersRemote orrefusalordersremote = null;
        try
        {
           
			/*InitialContext initialcontext = new InitialContext();
            Object obj1 = initialcontext.lookup(OrRepositoryExt.getOrKeyValue("OR_REFUSAL_ORDERS_JNDI"));
            ORRefusalOrdersHome orrefusalordershome = (ORRefusalOrdersHome)PortableRemoteObject.narrow(obj1, eOR.ORRefusalOrders.ORRefusalOrdersHome.class);
            orrefusalordersremote = orrefusalordershome.create();
            hashmap = orrefusalordersremote.insert(hashmap1, hashmap2);*/
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepositoryExt.getOrKeyValue("OR_REFUSAL_ORDERS_JNDI"), ORRefusalOrdersHome.class, getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]	= new Object[2];
				argArray[0]		= hashmap1;
				argArray[1]		= hashmap2;
			Class [] paramArray = new Class[2];
				paramArray[0]	= hashmap1.getClass();
				paramArray[1]	= hashmap2.getClass();
			hashmap = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
			argArray	= null;
			paramArray	= null;
			
			//IN030284 if condition added
			if("".equals(apptrefno))
			{
	            if(((Boolean)hashmap.get("result")).booleanValue())
	                hashmap.put("message", getMessage(language_id, (String)hashmap.get( "message" ), "SM"));
	            else
	                hashmap.put("message", getMessage(language_id, (String)hashmap.get( "message" ), "COMMON"));
			}
			
			String msgAftInsert = ((String)hashmap.get("message")).trim();
			if(msgAftInsert.equalsIgnoreCase("RECORD_INSERTED"))
			{
				clear();
				clearBean();
				hashmap1.clear();//IN030284
			}
	
			//HashMap retHashMap = (HashMap )hashmap.get("NoOfRecords");
			
			
			//String temp[] = new String[2];

			
			/*if (hashmap.containsKey("printValues")) {
				allValues = (Hashtable)hashmap.get("printValues");
			} else {
				allValues = new Hashtable();
			}*/
			//IN030284 - Start
			if(!"".equals(apptrefno))
			{
	            if(((Boolean)hashmap.get("result")).booleanValue())
	                hashmap.put("message", getMessage(language_id, (String)hashmap.get( "message" ), "SM"));
	            else
	                hashmap.put("message", getMessage(language_id, (String)hashmap.get( "message" ), "COMMON"));
			}
			//IN030284 - End

            
        }
        catch(Exception exception1)
        {
            
            hashmap.put("message", exception1.getMessage());
            exception1.printStackTrace();
        }

        return hashmap;
    }

    public ArrayList mainResultOrders(String patientId) throws Exception 
	{

        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset = null;
        ArrayList arraylist = new ArrayList();

        try
        {
            connection = getConnection();
            preparedstatement = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_RESULT"));
            preparedstatement.setString(1,language_id);
			preparedstatement.setString(2,language_id);
			preparedstatement.setString(3, patientId.trim());
			resultset = preparedstatement.executeQuery();
            String record[];

            while ( resultset != null && resultset.next() )
			{
                record = new String[15];
                record[0] = resultset.getString("order_catalog_dec");
                record[1] = resultset.getString("refused_date_time");
                record[2] = resultset.getString("practitioner_name");
                record[3] = resultset.getString("refused_reason");
                record[4] = resultset.getString("encounter_id");
                record[5] = resultset.getString("patient_class");
                record[6] = resultset.getString("refusal_type");
                record[7] = resultset.getString("refused_pract_id");
                record[8] = resultset.getString("order_id");
                record[9] = resultset.getString("order_line_num");
                record[10] = resultset.getString("patient_id");
                record[11] = resultset.getString("patient_name");
				record[12] = resultset.getString("refusal_form_id");
				record[13] = resultset.getString("srl_no");
				record[14] = resultset.getString("refusal_desc");
				arraylist.add(record) ;
            }

        }
        catch(Exception exception)
        {
           
            exception.printStackTrace();
            throw exception;
        }
        finally
        {
            closeResultSet(resultset);
            closeStatement(preparedstatement);
            closeConnection(connection);
        }
        return arraylist;
    }

	public ArrayList mainSearchResultOrders(String from_dt,String to_dt,String patientId,String order_catalog_code,String refusal_type,String practitioner_type) throws Exception
    {
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset = null;
        ArrayList arraylist = new ArrayList();

        try
        {   
			/* Thai date validations start 14/02/2007*/
		
            if(from_dt == null || from_dt.equals("null") || from_dt.equals("&nbsp;") || from_dt.equals(" ")) from_dt = "";
            if(to_dt == null || to_dt.equals("null") || to_dt.equals("&nbsp;") || to_dt.equals(" ")) to_dt = "";
		
		 	from_dt = com.ehis.util.DateUtils.convertDate(from_dt,"DMY",language_id,"en");
            to_dt = com.ehis.util.DateUtils.convertDate(to_dt,"DMY",language_id,"en");
		 
			/* Thai date validations end 14/02/2007*/

            connection = getConnection();
           // preparedstatement = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_EXISTING_RESULT"));//Commented --[IN029211]
		   preparedstatement = connection.prepareStatement("select '<b>' ||  decode(?,'en',c.PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,c.PATIENT_NAME)) || '</b> Sex/Age :  <b>'  || c.sex || '/' || get_age(c.date_of_birth) || '<b>'  patient_name,c.sex sex, get_age(c.date_of_birth) age, a.patient_id patient_id, a.srl_no srl_no,a.facility_id facility_id, a.encounter_id encounter_id,a.patient_class patient_class,a.order_line_num order_line_num, a.order_catalog_code order_catalog_code, to_char(a.refused_date_time,'dd/mm/yyyy hh24:mi') refused_date_time,a.refusal_type refusal_type,decode(a.refusal_type,'O','Orderable','N','Non-Orderable') refusal_desc,decode(substr(a.order_id,1,2),'PH',or_get_order_catalog(a.order_id,d.order_type_code,?,?),a.order_catalog_desc) order_catalog_dec,a.refused_reason refused_reason,a.refused_pract_id refused_pract_id,a.order_id order_id, AM_GET_DESC.AM_PRACTITIONER(b.practitioner_id,?,'1')  practitioner_name,a.refusal_form_id refusal_form_id,a.srl_no srl_no from or_refusal_orderable a, am_practitioner b , mp_patient c,or_order d where a.refused_pract_id = b.PRACTITIONER_ID and a.order_id=d.order_id(+) and a.patient_id = c.patient_id and a.patient_id=? and  trunc(a.refused_date_time) BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') and nvl(a.ORDER_CATALOG_CODE,'X') like nvl(upper(?),nvl(a.ORDER_CATALOG_CODE,'X')) and a.refusal_type like nvl(?,a.refusal_type) order by a.REFUSED_DATE_TIME desc");
		   
            preparedstatement.setString(1,language_id);
			preparedstatement.setString(2,language_id);
			preparedstatement.setString(3,practitioner_type);
			preparedstatement.setString(4,language_id);
			preparedstatement.setString(5, patientId.trim());
            preparedstatement.setString(6, from_dt.trim());
            preparedstatement.setString(7, to_dt.trim());
            preparedstatement.setString(8, order_catalog_code.trim());
            preparedstatement.setString(9, refusal_type.trim());
			resultset = preparedstatement.executeQuery();
            String record[];

            while ( resultset != null && resultset.next() )
			{
                record = new String[15];
                record[0] = resultset.getString("order_catalog_dec");
                record[1] = resultset.getString("refused_date_time");
                record[2] = resultset.getString("practitioner_name");
                record[3] = resultset.getString("refused_reason");
                record[4] = resultset.getString("encounter_id");
                record[5] = resultset.getString("patient_class");
                record[6] = resultset.getString("refusal_type");
                record[7] = resultset.getString("refused_pract_id");
                record[8] = resultset.getString("order_id");
                record[9] = resultset.getString("order_line_num");
                record[10] = resultset.getString("patient_id");
                record[11] = resultset.getString("patient_name");
				record[12] = resultset.getString("refusal_form_id");
				record[13] = resultset.getString("srl_no");
				record[14] = resultset.getString("refusal_desc");
				arraylist.add(record) ;
            }

        }
        catch(Exception exception)
        {
           
            exception.printStackTrace();
            throw exception;
        }
        finally
        {
            closeResultSet(resultset);
            closeStatement(preparedstatement);
            closeConnection(connection);
        }
        return arraylist;
    }

	public ArrayList getRefusalForm()
	{
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		ArrayList refusalList = new ArrayList();

        try
        {
            connection = getConnection();
            preparedstatement = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_REFUSED_FORM_SELECT"));
			preparedstatement.setString(1,language_id);
			resultset = preparedstatement.executeQuery();
			String record[];
            while ( resultset != null && resultset.next() )
			{
                record = new String[2];
                record[0] = resultset.getString("consent_form_id");
				record[1] = resultset.getString("consent_form_label");
				refusalList.add(record) ;
			}
		}
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
			try
			{			
				closeResultSet(resultset);
				closeStatement(preparedstatement);
				closeConnection(connection);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
        }
        return refusalList;
	}
	//IN042027 - Added cat_code
	//public String getConsentContent(String consent_id , String patient_id, String facility_id, String encounter_id, String order_id)
	public String getConsentContent(String consent_id , String patient_id, String facility_id, String encounter_id, String order_id, String cat_code )
	{
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		String text ="";
		if(patient_id==null)  patient_id		= ""; else patient_id = patient_id.trim();
		if(encounter_id==null)  encounter_id	= ""; else encounter_id = encounter_id.trim();
		if(order_id==null)  order_id	= ""; else order_id = order_id.trim();
				
		//StringBuffer Refusal_dd = new StringBuffer();//IN037783

        try
        {
            connection = getConnection();
            preparedstatement = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CONSENT_ORDER_SELECT_CONSENT_FORM_CONTENT"));
			//preparedstatement.setString(1,language_id);
			preparedstatement.setString(1,consent_id.trim());
			resultset = preparedstatement.executeQuery();
			while ( resultset != null && resultset.next() )
			{
				java.sql.Clob consent_form_content = resultset.getClob("consent_form_content");
				if(consent_form_content!=null && consent_form_content.length() > 0)
						text = consent_form_content.getSubString(1,( (int)consent_form_content.length() ));
				if(text!=null && !text.equals("") ) 
				{ //&& consent_format.equals("E")
						// Call a method which will replace the particular records
						// IN030473Start.
						//text		= getMnemonicDetails(patient_id, facility_id, encounter_id, order_id, "E",  text);  //consent_format --> 'E' Editor, catalog_description=orderable
						//text		= getMnemonicDetails(patient_id, facility_id, encounter_id, order_id, "E",  text, "" );  //consent_format --> 'E' Editor, catalog_description=orderable 
						text		= getMnemonicDetails(patient_id, facility_id, encounter_id, order_id, "E",  text, "",cat_code ); //IN042027 - included cat_code
						// IN030473 End.
						text 		= URLDecoder.decode(text,"UTF-8");//IN041421
						text		= text.replace("^", "%");//IN041421
						//IN037783 - Start //IN041421 commented
						/*if(text.indexOf("||")!=-1)
						{
							StringTokenizer stoken = new StringTokenizer(text,"||");
							String update_value = "";
							while(stoken.hasMoreTokens()) 
							{
								if(!update_value.equals(""))
								{
									Refusal_dd.append("$");
								}
								update_value		=	 stoken.nextToken();
								Refusal_dd.append(update_value);
								text = Refusal_dd.toString();
							}
						}*/
						//IN037783 - End
						
				}

			}
		}
        catch(Exception exception)
        {
           
            exception.printStackTrace();
           
        }
        finally
        {
			try
			{
				closeResultSet(resultset);
				closeStatement(preparedstatement);
				closeConnection(connection);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
        }
		return text;
	}

	//public String getConsentFormContent(String refusal_id,String patient_id,String order_id)
	//public String getConsentFormContent(String refusal_id,String patient_id,String srl_no,String facility_id, String encounter_id, String order_id) //IN042027 included cat_code
	public String getConsentFormContent(String refusal_id,String patient_id,String srl_no,String facility_id, String encounter_id, String order_id, String cat_code)
	{
 
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		String text ="";
		if(patient_id==null)  patient_id		= ""; else patient_id = patient_id.trim();
		if(encounter_id==null)  encounter_id	= ""; else encounter_id = encounter_id.trim();
		if(order_id==null)  order_id	= ""; else order_id = order_id.trim();
		//StringBuffer Refusal_dd = new StringBuffer();//IN037783

        try
        {
			
            connection = getConnection();
           
 			preparedstatement = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDERS_REFUSAL_CONTENT_SELECT"));
 
			preparedstatement.setString(1,refusal_id.trim());
			preparedstatement.setString(2,patient_id.trim());
			preparedstatement.setString(3,srl_no.trim());
			
			resultset = preparedstatement.executeQuery();
            while ( resultset != null && resultset.next() )
			{
			
				java.sql.Clob consent_form_content = resultset.getClob("refusal_form_content");
				
				if(consent_form_content!=null && consent_form_content.length() > 0)
						text = consent_form_content.getSubString(1,( (int)consent_form_content.length() ));

				if(text!=null && !text.equals("") ) 
				{ //&& consent_format.equals("E")
						// Call a method which will replace the particular records
					// Bru-HIMS-CRF-032 Start.
					//text		= getMnemonicDetails(patient_id, facility_id, encounter_id, order_id, "E",  text);  //consent_format --> 'E' Editor, catalog_description=orderable
					//text		= getMnemonicDetails(patient_id, facility_id, encounter_id, order_id, "E",  text, "" ); //consent_format --> 'E' Editor, catalog_description=orderable
					text		= getMnemonicDetails(patient_id, facility_id, encounter_id, order_id, "E",  text, "", cat_code ); //IN042027
					// Bru-HIMS-CRF-032 Start.
					text 		= URLDecoder.decode(text,"UTF-8");//IN041421
					text		= text.replace("^", "%");//IN041421
					//IN037783 - Start //IN041421 commented
					/*if(text.indexOf("||")!=-1)
					{
						StringTokenizer stoken = new StringTokenizer(text,"||");
						String update_value = "";
						while(stoken.hasMoreTokens()) 
						{
							if(!update_value.equals(""))
							{
								Refusal_dd.append("$");
							}
							update_value		=	 stoken.nextToken();
							Refusal_dd.append(update_value);
							text = Refusal_dd.toString();
						}
					}*/
					//IN037783 - End
				}
			}
		}
        catch(Exception exception)
        {
		
            exception.printStackTrace();
        
        }
        finally
        {
			try
			{
				closeResultSet(resultset);
				closeStatement(preparedstatement);
				closeConnection(connection);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
        }
        return text;
	}

	public String[] getDefPractitioner(String login_user)
	{
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		String[] text = new String[2];

		try
        {
            connection = getConnection();
            preparedstatement = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_RESULT_ENTRY_DFLT_PRACTITIONER"));
			preparedstatement.setString(1,language_id);
			preparedstatement.setString(2,login_user.trim());
			resultset = preparedstatement.executeQuery();
            while ( resultset != null && resultset.next() )
			{
				text[0] = resultset.getString("practitioner_name");
				text[1] = resultset.getString("func_role_id");
			}
		}
        catch(Exception exception)
        {
          
            exception.printStackTrace();
          
        }
        finally
        {
			try
			{
				closeResultSet(resultset);
				closeStatement(preparedstatement);
				closeConnection(connection);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
        }
        return text;
	}
/*
public ArrayList getOrderTypeCodes(String order_category)
{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;

			ArrayList OrderTypes = new ArrayList() ;
			try{
					connection	= getConnection();

					pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_ORDER_TYPE") ) ;
					pstmt.setString(1,order_category);
					resultSet	= pstmt.executeQuery() ;

					if ( resultSet != null )
					{
							String[] record	= null;

						while(resultSet.next())
						{
							record 	  = new String[2];
							record[0] = resultSet.getString( "order_type_code" )  ;
							record[1] = resultSet.getString( "short_desc" )  ;

							OrderTypes.add(record) ;
						}
					}
				}catch ( Exception e )	{
					
					e.printStackTrace() ;
					
				} finally {
					try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection(connection);
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				}
		return OrderTypes;
}
*/

	public String[] getOrderCatalog(String order_id,String ord_line_num)
	{
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		String[] text = new String[3];
		text[0] = "";
		text[1] = "";
		text[2] = "";

        try
        {
            connection = getConnection();
           // preparedstatement = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_ORDER_DTLS_SELECT"));
			preparedstatement = connection.prepareStatement("SELECT order_line_num,  order_catalog_code,catalog_synonym_dc,order_type_code order_type_code,(select consent_form_id from or_order_catalog where order_catalog_code = a.order_catalog_code) consent_form_id  from or_order_line a where order_id = ? and order_line_num= ? order by order_line_num");//--[IN029211]
			preparedstatement.setString(1,order_id.trim());
			preparedstatement.setString(2,ord_line_num.trim());
			resultset = preparedstatement.executeQuery();
			int i=0;
            while ( resultset != null && resultset.next() )
			{
				i = i+1;
				if(resultset.getString("order_line_num") != null && resultset.getString("order_line_num") != "")
				{
					if(i == 1)
					{
						text[0] = resultset.getString("order_line_num");
					}
					else
					{
						text[0] = text[0] + ":" + resultset.getString("order_line_num");
					}
				}
				if(resultset.getString("order_catalog_code") != null && resultset.getString("order_catalog_code") != "")
				{
					if(i == 1)
					{
						text[1] = resultset.getString("order_catalog_code");
					}
					else
					{
						text[1] = text[1] + "," + resultset.getString("order_catalog_code");
					}
				}
				if(resultset.getString("catalog_synonym_dc") != null && resultset.getString("catalog_synonym_dc") != "")
				{
					if(i == 1)
					{
						text[2] = resultset.getString("catalog_synonym_dc");
					}
					else
					{
						text[2] = text[2] + "," + resultset.getString("catalog_synonym_dc");
					}
				}
			}
			
		}
        catch(Exception exception)
        {
            
            exception.printStackTrace();
            
        }
        finally
        {
			try{
            closeResultSet(resultset);
            closeStatement(preparedstatement);
            closeConnection(connection);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
        }
        return text;
	}


	public String getVisitAdmDate(String patient_id,String encounter_id)
	{
	
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		String text = "";

        try
        {
            connection = getConnection();
			
            preparedstatement = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_VISIT_ADM_DATE_TIME"));
			preparedstatement.setString(1,patient_id.trim());
			preparedstatement.setString(2,encounter_id.trim());
			resultset = preparedstatement.executeQuery();
            while ( resultset != null && resultset.next() )
			{
				text = resultset.getString("VISIT_ADM_DATE_TIME");
			}
		}
        catch(Exception exception)
        {
            
            exception.printStackTrace();
            //throw exception;
        }
        finally
        {
			try
			{
				closeResultSet(resultset);
				closeStatement(preparedstatement);
				closeConnection(connection);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
        }
	return text;
	}

	public void  setOrderCatalogs(String key,String value)
	{
		if(!(ar.contains(key)))
		{
			ar.add(key);
		}
	}

	public ArrayList  getOrderCatalogs()
	{
		return ar;
	}

	public void removeOrderCatalog(String key)
	{
		order_catalog_lookup.remove(key);
	}

	public void clearOrderCatalog(String key)
	{
		order_catalog_lookup.clear();
	}

	public boolean containsObject(Object obj) throws Exception
	{
			boolean flag = false;
			if(recordSet != null)
				flag = recordSet.contains(obj);
			return flag;
	 }

	public boolean containsTempObject(Object obj)  throws Exception
	{
        boolean flag = false;
        if(dataRecordSet != null)
            flag = dataRecordSet.contains(obj);
        return flag;
	}

	public int indexOfObject(Object obj) throws Exception
	{
		int i = -1;
		if(recordSet != null)
			i = recordSet.indexOf(obj);
		return i;
	}

	public boolean removeObject(int i)	throws Exception
	{
		if(i < getSize())
		{
			recordSet.remove(i);
			return true;
		}
		else
		{
			return false;
		}
	}

	public int getSize()
	{
		int i = 0;
		if(recordSet != null)
			i = recordSet.size();
		return i;
	}

	public boolean putObject(Object obj) throws Exception
	{
		try
		{
			if(!recordSet.contains(obj))
			{
				recordSet.add(obj);
			}
		}
		catch(Exception exception)
		{
			throw new Exception("Exception@putObject: " + exception);
		}
		return true;
	}

	public boolean putTempObject(Object obj) throws Exception
	{
		try
		{
			String keyValue = obj.toString();
			//String key      = keyValue.substring(0,((keyValue.indexOf("$$"))));	
			String key      = keyValue.substring(0,((keyValue.indexOf("~~"))));		//IN030284.1 
			String nature = (String)getCatalogNature(key);		
			
			if(!dataRecordSet.contains(obj))
			{
				if(nature.equalsIgnoreCase("S"))
				{
					orderSetCount ++;
				}
				dataRecordSet.add(obj);
			}
		}
		catch(Exception exception)
		{
			throw new Exception("Exception@putObjects: " + exception);
		}
		return true;
	}

	public boolean finalOrderable() throws Exception
	{
		try
		{
			clearObject();
			int i = 0;

			if(dataRecordSet != null)
				i = dataRecordSet.size();

			for(int j=0;j<i;j++)
			{
				
				putObject(dataRecordSet.get(j));
			}
			dataRecordSet.clear();
			orderSetCount=0;
		}
		catch(Exception exception)
		{
			throw new Exception("Exception@putObjects: " + exception);
		}
		return true;
	}

	public ArrayList getArrayList()
	{
		return recordSet;
	}
	public ArrayList getTempArrayList()
	{
		return dataRecordSet;
	}

	public void removeOrderCatalogs(String keyValue)
	{
		//String key      = keyValue.substring(0,((keyValue.indexOf("$$"))));
		String key      = keyValue.substring(0,((keyValue.indexOf("~~"))));//IN030284.1 
		String nature = (String)getCatalogNature(key);
		String recorded_nature = "";

		if(nature.equalsIgnoreCase("S"))
		{
			int i = 0;
			if(recordSet != null)
			i = recordSet.size();
			for(int j=0;j<i;j++)
			{
				//recorded_nature = (String) getCatalogNature(recordSet.get(j).toString().substring(0,((keyValue.indexOf("$$"))))); 
				recorded_nature = (String) getCatalogNature(recordSet.get(j).toString().substring(0,((keyValue.indexOf("~~"))))); //IN030284.1 
				if(recorded_nature.equalsIgnoreCase("S"))
				{
					orderSetCount++;
				}
			}
			orderSetCount = orderSetCount -1;
		}
	//if(recordSet.contains(key))
	//{
			recordSet.remove(keyValue);
	//}
	}

	public void removeTempOrderCatalogs(String keyValue)
	{
		//String key      = keyValue.substring(0,((keyValue.indexOf("$$")))); 
		String key      = keyValue.substring(0,((keyValue.indexOf("~~")))); //IN030284.1 
		String nature = (String)getCatalogNature(key);
		if(nature.equalsIgnoreCase("S"))
		{
			orderSetCount --;
		}
		//if(recordSet.contains(key))
		//{
				dataRecordSet.remove(keyValue);
		//}
	}

	public void clearObject()
	{
		if(recordSet.size()>0)
		{
			recordSet.clear();
		}
	}

	public void clearTempObject()
	{
		if(dataRecordSet.size()>0)
		{
			dataRecordSet.clear();
			orderSetCount = 0;
		}
	}

	public void setWindowStatus(String win_status)
	{	
		this.win_status = win_status;	
	}

	public String getWindowStatus()
	{	
		return this.win_status;
	}

	public String getOrderCatalogDesc(String order_id,String ord_line_num)
	{
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		String text = "";

		try
		{
			connection = getConnection();
			//preparedstatement = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_CATALOG_LINE"));
			preparedstatement = connection.prepareStatement("SELECT order_catalog_code,or_get_order_catalog (order_id, order_type_code,?) catalog_synonym,num_of_consent_req_bo,num_of_consent_req_br FROM or_order_line WHERE order_id=? and order_line_num=?"); //--[IN034904]
			preparedstatement.setString(1,language_id);
			preparedstatement.setString(2,order_id.trim());
			preparedstatement.setString(3,ord_line_num.trim());
			resultset = preparedstatement.executeQuery();
			//int i=0;
			while ( resultset != null && resultset.next() )
			{
				text = resultset.getString("catalog_synonym");		
			}			
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		finally
		{
			try
			{
				closeResultSet(resultset);
				closeStatement(preparedstatement);
				closeConnection(connection);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return text;
	}

	public int getorderSetCount()
	{
		return orderSetCount;
	}

	public String getCatalogNature(String order_catalog_code)
	{
	
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		String order_catalog_nature = "";
    
		try
		{
			con   = getConnection();
			pstmt = con.prepareStatement("select order_catalog_nature from or_order_catalog where order_catalog_code=?");
			pstmt.setString(1,order_catalog_code);
			rs = pstmt.executeQuery();
			while(rs!=null && rs.next())
			{
				order_catalog_nature = rs.getString("order_catalog_nature")==null?"":rs.getString("order_catalog_nature");
			}
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				closeResultSet(rs);
				closeStatement(pstmt);
				closeConnection(con);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	
		return order_catalog_nature;
	}
	
	//--[IN034904] - Start
	public String getConsentFormId(String order_id,String form_id)
	{
	
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		String form_id1 = "";
    
		try
		{
			con   = getConnection();
			pstmt = con.prepareStatement("SELECT b.order_catalog_code order_catalog_code FROM or_order_line a, or_order_catalog b WHERE a.order_id = ? AND b.order_catalog_code = a.order_catalog_code AND b.consent_form_id != ?");
			pstmt.setString(1,order_id);
			pstmt.setString(2,form_id);
			rs = pstmt.executeQuery();
			while(rs!=null && rs.next())
			{
				form_id1 = rs.getString("order_catalog_code")==null?"":rs.getString("order_catalog_code");
			}
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				closeResultSet(rs);
				closeStatement(pstmt);
				closeConnection(con);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	
		return form_id1;
	}
	//--[IN034904] - End

	// CRF - 885 IN031304
	public ArrayList getOrderCategoryOARADYN() throws Exception 
	{

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderCategory = new ArrayList() ;
		String sqlQry  = "SELECT order_category, OR_GET_DESC.OR_ORDER_CATEGORY (order_category,?,'2') short_desc FROM or_order_category where order_category in ('RD')";
		try
		{
			connection	= getConnection();
			System.out.println(" 1865 " + sqlQry);
			pstmt		= connection.prepareStatement(sqlQry);
			pstmt.setString(1,language_id);
			resultSet	= pstmt.executeQuery() ;
			System.out.println(" 1868 " +language_id);
			if ( resultSet != null )
			{								
				String[] record	= null;
				while(resultSet.next())
				{
					record 	  = new String[2];
					record[0] = resultSet.getString( "order_category" )  ;
					record[1] = resultSet.getString( "short_desc" )  ;
					OrderCategory.add(record) ;
				}
			}
		 }
		 catch ( Exception e )	
		 {
						
			e.printStackTrace() ;
			throw e ;
		 }
		 finally
		 {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		 }
		return OrderCategory;
	}	 // End of the getOrderCategory
	//IN037939 starts start of the getOrderableCatalogDesc
	public String getOrderableCatalogDesc(String order_id)
	{
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		String text = "";
		
		
		

		try
		{
			connection = getConnection();
			
			preparedstatement = connection.prepareStatement("SELECT catalog_desc FROM or_order_line WHERE order_id = ?"); 
						
			preparedstatement.setString(1,order_id.trim());
			
			resultset = preparedstatement.executeQuery();
			 
			
			while ( resultset != null && resultset.next() )
			{
				if(text.length() != 0)
				text =text.concat(",");
				text = text.concat(resultset.getString("catalog_desc"));	
								
			}	
					
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		finally
		{
			try
			{
				closeResultSet(resultset);
				closeStatement(preparedstatement);
				closeConnection(connection);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return text;
	}
	//IN037939 ends end of the getOrderableCatalogDesc
	
	//IN030284 - Starts 
	public ArrayList getSelectedCatalogs(String appt_ref_no , String facilityid)
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderCatalog = new ArrayList() ;
		String record = "";
		String sqlQry  = "Select a.ORDER_CATALOG_CODE ORDER_CATALOG_CODE,or_get_desc.or_order_catalog(a.order_catalog_code,?,'2') long_desc, order_category,order_type_code  from OR_APPT_REF_CATALOG a, or_order_catalog b where APPT_REF_NO = ? and FACILITY_ID = ? and  a.order_catalog_code = b.order_catalog_code";
		try
		{
			connection	= getConnection();
			pstmt		= connection.prepareStatement(sqlQry);
			pstmt.setString(1,language_id);
			pstmt.setString(2,appt_ref_no);
			pstmt.setString(3,facilityid);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )
			{								
				while(resultSet.next())
				{
					//IN030284.1 - $$ replaced with ~~
					record = resultSet.getString( "ORDER_CATALOG_CODE" ) +"~~"+ resultSet.getString( "long_desc" ) +"~~"+ resultSet.getString( "order_type_code" )+"~~"+resultSet.getString( "order_category" )+"~~"+appt_ref_no;
					OrderCatalog.add(record) ;
				}
			}
		 }
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		finally
		{
			try
			{
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return OrderCatalog;
	}
	//IN030284 - Ends
	//IN063655 starts
	public int getTempObjectSize()
	{
		if(dataRecordSet != null)
				return dataRecordSet.size();
		else
				return 0;
	}
	//IN063655 ends
	
}	
