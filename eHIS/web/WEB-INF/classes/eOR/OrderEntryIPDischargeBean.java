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
Date			Edit History	Name        Description
-----------------------------------------------------------------------
?				100         	?     		created	 
09/11/2012		IN030473	Ramesh G	  Bru-HIMS-CRF-032 	
18/01/2013	    IN037372	Ramesh G	  Oracle 11g Weblogic compilation.		
01/08/2013      IN042027	Chowminya G   Catalog Name Does Not Display In Refusal Form For Catalogs Which Does Not Have A Consent Attached					 
-----------------------------------------------------------------------
*/

package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;
//import oracle.sql.CLOB;  //[IN037372]
import javax.servlet.*;
import javax.servlet.http.*;

import eOR.Common.* ;
import eCommon.Common.*;

import eOR.ORRefusalOrders.*;

public class OrderEntryIPDischargeBean extends OrAdapter implements java.io.Serializable {

protected String patient_id="";
protected String sysdate="";
protected String facility_id="";
protected String encounter_id="";
protected String patient_class="";
protected String episode_id="";
protected String episode_visit_num="";
protected String source_type="";
protected String source_code="";
protected String order_catalog_code="";
protected String practitioner_id="";
protected String new_dis_adv_srl_no="";
protected String dischargeaction="";


protected ArrayList selectedCatalog = new ArrayList();
protected ArrayList selectedCatalogValue = new ArrayList();

protected ArrayList refusal_orderid;
protected LinkedHashMap order_catalog_lookup			= new LinkedHashMap();
protected ArrayList ar			= new ArrayList();
ArrayList recordSet = new ArrayList();
ArrayList dataRecordSet = new ArrayList();

public void setPatientId(String patient_id){	this.patient_id = patient_id;	}
public void setSysDate(String sysdate){				this.sysdate = sysdate;	}
public void setFacilityId(String facility_id){	this.facility_id = facility_id;	}
public void setEncounterId(String encounter_id){this.encounter_id = encounter_id;	}
public void setPatientClass(String patient_class){  this.patient_class = patient_class;	}
public void setEpisodeId(String episode_id){   this.episode_id = episode_id; }
public void setEpisodeVisitNum(String episode_visit_num){   	this.episode_visit_num = episode_visit_num;    }
public void setSourceType(String source_type){ this.source_type=source_type;   }
public void setSourceCode(String source_code){ this.source_code=source_code;   }
public void setOrderCatalogCode(String order_catalog_code){  this.order_catalog_code=order_catalog_code;   }
public void setPractitionerId(String practitioner_id){  this.practitioner_id=practitioner_id;  }
public void setNewDisAdvSrlNo(String new_dis_adv_srl_no){  this.new_dis_adv_srl_no=new_dis_adv_srl_no;  }
public void setDischargeAction(String dischargeaction){  this.dischargeaction=dischargeaction;  }



public String getPatientId(){ return this.patient_id;}
public String getFacilityId(){	return this.facility_id;	}
public String getEncounterId(){	return  this.encounter_id;	}
public String getPatientClass(){return this.patient_class;	}
public String getOrderCatalogCode(){  return this.order_catalog_code;   }




public void clear() 
{
			super.clear();
}

public void clearBean() 
{
			selectedCatalog.clear();
			selectedCatalogValue.clear();
}


public ArrayList getOrderCategory() throws Exception {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;

			ArrayList OrderCategory = new ArrayList() ;
			try{
					connection	= getConnection();

					
					pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST") ) ;
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
				}catch ( Exception e )	{
					
					e.printStackTrace() ;
					throw e ;
				} finally {
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection(connection);
				}
		return OrderCategory;
	}	 // End of the getOrderCategory
	
	public ArrayList getOrderCategoryOPOA() throws Exception {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;

			ArrayList OrderCategory = new ArrayList() ;
			try{
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
				}catch ( Exception e )	{
					
					e.printStackTrace() ;
					throw e ;
				} finally {
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection(connection);
				}
		return OrderCategory;
	}	 // End of the getOrderCategory



	public ArrayList getLocation(String location_type) throws Exception {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 			= null;
			ArrayList Location = new ArrayList() ;
			try {
					
					connection = getConnection() ;
					pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_ORDER_TYPE") ) ;
					pstmt.setString( 1, language_id);
					pstmt.setString( 2, location_type.trim() ) ;

					resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) {
							String[] record = new String[2];
							record[0] = resultSet.getString( "order_type_code" )  ;
							record[1] = resultSet.getString( "short_desc" )  ;
							Location.add(record) ;
					}
			} catch ( Exception e )	{
			
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			}

			return Location;
		}
		
		
		public ArrayList getLocationOPOA(String location_type) throws Exception {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 			= null;
			ArrayList Location = new ArrayList() ;
			try {
					
					connection = getConnection() ;
					pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_TYPE_SELECT_WITHOUT_PH") ) ;
					pstmt.setString( 1, language_id);
					pstmt.setString( 2, location_type.trim() ) ;

					resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) {
							String[] record = new String[2];
							record[0] = resultSet.getString( "order_type_code" )  ;
							record[1] = resultSet.getString( "short_desc" )  ;
							Location.add(record) ;
					}
			} catch ( Exception e )	{
			
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			}

			return Location;
		}


		public ArrayList getActivityType(String order_category, String order_type) throws Exception {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			ArrayList ActivityType		= new ArrayList() ;
			try {
					
					connection = getConnection() ;
					pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ACTIVITY_TYPE_SELECT") ) ;
					pstmt.setString( 1, language_id);
					pstmt.setString( 2, order_category) ;
					pstmt.setString( 3, order_type) ;
					//pstmt.setString( 4, language_id);
					//pstmt.setString( 5, order_category) ;

					resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) {
							String[] record = new String[2];
							record[0] = resultSet.getString( "activity_type" )  ;
							record[1] = resultSet.getString( "short_desc" )  ;
							ActivityType.add(record) ;
					}
			} catch ( Exception e )	{
			
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			}

			return ActivityType;
		}

		public ArrayList getDisplayResult(String order_category,String order_type_code,String search_by,String description_code,String long_desc) throws Exception {


			
				Connection connection 		= null;
				PreparedStatement pstmt 	= null;
				ResultSet resultSet 			= null;
				ArrayList RefusalOrderCat = new ArrayList() ;


				order_category=order_category.equals("")?null :order_category;
				order_type_code=order_type_code.equals("")?null :order_type_code;
				long_desc=long_desc.equals("")?null :long_desc;
		String msg="";
	try {
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
					
			while ( resultSet != null && resultSet.next() ) {
					String[] record = new String[2];
					record[0] = resultSet.getString( "order_catalog_code" )  ;
					record[1] = resultSet.getString( "long_desc" )  ;
					
					RefusalOrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}


		return RefusalOrderCat;
	}



//for populating patient id and sex
public ArrayList getLocation1(String patientId) throws Exception {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 			= null;
			ArrayList Location = new ArrayList() ;
			try {
				
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER1") ) ;

				pstmt.setString(1,language_id);
				pstmt.setString(2, patientId.trim() ) ;

				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) {
					String[] record = new String[2];
					record[0] = resultSet.getString( "patient_name" )  ;
					record[1] = resultSet.getString( "regn_date" )  ;
					
					Location.add(record) ;

				}
			} catch ( Exception e )	{
				
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			}

			return Location;
		}

//Display the System Date
public String getSysDate1() throws Exception {
	 Connection connection 		= null;
	 PreparedStatement pstmt 	= null;
	 ResultSet resultSet 		= null;
	 String sys_date			= "";
	 try {
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
	 	} catch ( Exception e )	{
		
			e.printStackTrace() ;
			throw e ;
	 	} finally {
			closeResultSet( resultSet);
			closeStatement( pstmt);
			closeConnection(connection);
 		}
 		return sys_date;
 }

  



  public ArrayList getVisitAdminDetails(String patientId) throws Exception {
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
            while ( resultset != null && resultset.next() ){
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

    public void setAll(Hashtable hashtable) {
        if(hashtable.containsKey("patient_id"))
            setPatientId((String)hashtable.get("patient_id"));
        if(hashtable.containsKey("sysdate"))
            setSysDate((String)hashtable.get("sysdate"));
        if(hashtable.containsKey("facility_id"))
            setFacilityId((String)hashtable.get("facility_id"));
        if(hashtable.containsKey("encounter_id"))
            setEncounterId((String)hashtable.get("encounter_id"));
        if(hashtable.containsKey("patient_class"))
            setPatientClass((String)hashtable.get("patient_class"));
        if(hashtable.containsKey("episode_id"))
            setEpisodeId((String)hashtable.get("episode_id"));
		if(hashtable.containsKey("episode_visit_num"))
            setEpisodeVisitNum((String)hashtable.get("episode_visit_num"));
        if(hashtable.containsKey("source_type"))
      		setSourceType((String)hashtable.get("source_type"));
		if(hashtable.containsKey("source_code"))
            setSourceCode((String)hashtable.get("source_code"));
         if(hashtable.containsKey("order_catalog_code"))
            setOrderCatalogCode((String)hashtable.get("order_catalog_code"));
		if(hashtable.containsKey("practitioner_id"))
            setPractitionerId((String)hashtable.get("practitioner_id"));
        super.mode = (String)hashtable.get("mode");
		if(hashtable.containsKey("new_dis_adv_srl_no"))
			setNewDisAdvSrlNo((String)hashtable.get("new_dis_adv_srl_no"));
		if(hashtable.containsKey("dischargeaction"))
			setDischargeAction((String)hashtable.get("dischargeaction"));
    }

    public HashMap insert()
    {
       // boolean flag = false;
        HashMap hashmap = new HashMap();
        //StringBuffer stringbuffer = new StringBuffer();
        hashmap.put("result", new Boolean(false));
		try
		{
		
			hashmap=InsertIPDischargeDetails();
			if( ((Boolean) hashmap.get( "result" )).booleanValue() ){
						hashmap.put( "message", getMessage(language_id, (String) hashmap.get( "message" ), "SM")) ;
					}
					else
					{
						String ErrorMessage= (String)hashmap.get("message");
						if(ErrorMessage.equals("ERROR_INSERTING"))
						{
							hashmap.put("message",getMessage(language_id,(String)hashmap.get("message"),"SM"));
						}
						else
						{
							hashmap.put( "message", getMessage(language_id, (String) hashmap.get( "message" ), "Common")) ;
						}
					}
     	   }
			catch(Exception e) 
			{
			System.err.println( "Error Calling EJB : "+e ) ;
			hashmap.put( "message", e.getMessage()) ;
			e.printStackTrace() ;
			}
			finally
			{
				clear();
		
			}
		return hashmap;
    }

public HashMap InsertIPDischargeDetails() throws Exception 
{
	HashMap map = new HashMap() ;
	map.put( "result", new Boolean( false ) ) ;
	StringBuffer messages = new StringBuffer() ;
	Connection con= null;
	CallableStatement cstmt = null;
	String p_out_order_id="";
	String p_out_order_line_num="";
	String p_err_message="";
	String p_facility_id="";
	   try
	   {
		   
		   con = getConnection();
		   cstmt=con.prepareCall("{call OR_INSERT_ORDER_OTH_MODULE ( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,NULL)}");

			cstmt.setString( 1, sysdate);
			cstmt.setString( 2, order_catalog_code);
			cstmt.setString( 3, "OR");
			cstmt.setString( 4, facility_id);
			cstmt.setString( 5, patient_id);
			cstmt.setString( 6, patient_class);
			cstmt.setString( 7, encounter_id);
			cstmt.setString( 8, episode_id);
			cstmt.setString( 9, (episode_visit_num==null)?"":episode_visit_num);
			cstmt.setString( 10, source_type);
			cstmt.setString( 11, source_code);
			cstmt.setString( 12, practitioner_id);
			cstmt.setString( 13, login_by_id);
			cstmt.setString( 14, login_at_ws_no);

			cstmt.registerOutParameter(15,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(16,java.sql.Types.NUMERIC);
			cstmt.registerOutParameter(17,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(18,java.sql.Types.VARCHAR);
			cstmt.execute() ;
		

			p_out_order_id=cstmt.getString( 15 ); 
			if(p_out_order_id ==null) p_out_order_id="";
			p_out_order_line_num=cstmt.getString( 16 ); 
			if(p_out_order_line_num ==null) p_out_order_line_num="";
					
			p_err_message=cstmt.getString( 18 ); 
			p_facility_id=cstmt.getString( 17 ); 
			if(p_err_message==null) p_err_message="";
			if(p_err_message!="")
			{
				con.commit();
				map.put( "result", new Boolean( true ) ) ;
				messages.append( "RECORD_INSERTED" ) ;
			}
			else
			{
				con.rollback();
				map.put( "result", new Boolean( false ) ) ;
				messages.append("ERROR_INSERTING");
			}
        }
        catch(Exception exception) { 
			System.err.println("Sql"+exception);
		}
		finally
		{
           closeStatement(cstmt) ;
			closeConnection(con);
		}
		map.put( "message", messages.toString() ) ;
         return map;
    }

    public ArrayList mainResultOrders(String patientId) throws Exception {

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
            while ( resultset != null && resultset.next() ){
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

	public ArrayList mainSearchResultOrders(String from_dt,String to_dt,String patientId,String order_catalog_code,String refusal_type)
        throws Exception
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
            preparedstatement = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_EXISTING_RESULT"));
            preparedstatement.setString(1,language_id);
			preparedstatement.setString(2,language_id);
			preparedstatement.setString(3, patientId.trim());
            preparedstatement.setString(4, from_dt.trim());
            preparedstatement.setString(5, to_dt.trim());
            preparedstatement.setString(6, order_catalog_code.trim());
            preparedstatement.setString(7, refusal_type.trim());
			resultset = preparedstatement.executeQuery();
            String record[];
            while ( resultset != null && resultset.next() ){
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
			try{
            closeResultSet(resultset);
            closeStatement(preparedstatement);
            closeConnection(connection);
			}catch(Exception e)
			{
				System.err.println("finally"+e);
			}
        }
        return refusalList;
}

public String getConsentContent(String consent_id , String patient_id, String facility_id, String encounter_id, String order_id)
{
	Connection connection = null;
    PreparedStatement preparedstatement = null;
    ResultSet resultset = null;
	String text ="";
	if(patient_id==null)  patient_id		= ""; else patient_id = patient_id.trim();
	if(encounter_id==null)  encounter_id	= ""; else encounter_id = encounter_id.trim();
	if(order_id==null)  order_id	= ""; else order_id = order_id.trim();

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
			if(text!=null && !text.equals("") ) { //&& consent_format.equals("E")
					// Call a method which will replace the particular records
					// IN030473 Start.
					//text		= getMnemonicDetails(patient_id, facility_id, encounter_id, order_id, "E",  text);  //consent_format --> 'E' Editor, catalog_description=orderable
					//text		= getMnemonicDetails(patient_id, facility_id, encounter_id, order_id, "E",  text, ""); //consent_format --> 'E' Editor, catalog_description=orderable
					text		= getMnemonicDetails(patient_id, facility_id, encounter_id, order_id, "E",  text, "","");  //IN042027 
					// IN030473 End.
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
				System.err.println("finally"+e);
			}
        }
		return text;
}

//public String getConsentFormContent(String refusal_id,String patient_id,String order_id)
public String getConsentFormContent(String refusal_id,String patient_id,String srl_no,String facility_id, String encounter_id, String order_id)
{
 
	Connection connection = null;
    PreparedStatement preparedstatement = null;
    ResultSet resultset = null;
	String text ="";
	if(patient_id==null)  patient_id		= ""; else patient_id = patient_id.trim();
	if(encounter_id==null)  encounter_id	= ""; else encounter_id = encounter_id.trim();
	if(order_id==null)  order_id	= ""; else order_id = order_id.trim();
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

				if(text!=null && !text.equals("") ) { //&& consent_format.equals("E")
					// Call a method which will replace the particular records
					// IN030473 Start.
					//text		= getMnemonicDetails(patient_id, facility_id, encounter_id, order_id, "E",  text);  //consent_format --> 'E' Editor, catalog_description=orderable
					//text		= getMnemonicDetails(patient_id, facility_id, encounter_id, order_id, "E",  text, ""); //consent_format --> 'E' Editor, catalog_description=orderable
					text		= getMnemonicDetails(patient_id, facility_id, encounter_id, order_id, "E",  text, "", "");  //IN042027
					// IN030473 End.
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
				System.err.println("finally"+e);
			}
        }
		//System.err.println(text);
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
			try{
            closeResultSet(resultset);
            closeStatement(preparedstatement);
            closeConnection(connection);
			}catch(Exception e)
			{
				System.err.println("finally"+e);
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
            preparedstatement = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_ORDER_DTLS_SELECT"));
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
				System.err.println("finally"+e);
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
			try{
            closeResultSet(resultset);
            closeStatement(preparedstatement);
            closeConnection(connection);
			}catch(Exception e)
			{
				System.err.println("finally"+e);
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

public boolean containsObject(Object obj)
        throws Exception
{
        boolean flag = false;
        if(recordSet != null)
            flag = recordSet.contains(obj);
        return flag;
 }
 public boolean containsTempObject(Object obj)
        throws Exception
{
        boolean flag = false;
        if(dataRecordSet != null)
            flag = dataRecordSet.contains(obj);
        return flag;
 }

public int indexOfObject(Object obj)
	throws Exception
{
	int i = -1;
	if(recordSet != null)
		i = recordSet.indexOf(obj);
	return i;
}

public boolean removeObject(int i)
	throws Exception
{
	if(i < getSize())
	{
		recordSet.remove(i);
		return true;
	} else
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

public boolean putObject(Object obj)
	throws Exception
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

public boolean putTempObject(Object obj)
	throws Exception
{
	try
	{
		if(!dataRecordSet.contains(obj))
		{
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

public void removeOrderCatalogs(String key)
{
	if(recordSet.contains(key))
	{
			recordSet.remove(key);
	}
}
public void removeTempOrderCatalogs(String key)
{
	if(recordSet.contains(key))
	{
			dataRecordSet.remove(key);
	}
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
	}
}
public String getCatalogDesc(String order_catalog_code) throws Exception 
{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		String CatalogDesc="";
		if(order_catalog_code==null || order_catalog_code.equals(" ")) order_catalog_code = "";
		try
		  {
			connection  = getConnection();
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_EMAIL_CATALOG_DESC"));
			pstmt.setString(1,checkForNull(language_id,""));
			pstmt.setString(2,(String)order_catalog_code);
								
			rs	  =pstmt.executeQuery();
			while(rs != null && rs.next())
			{
				CatalogDesc = rs.getString("order_catalog_desc")==null?"":rs.getString("order_catalog_desc");
			}
		}
		catch(Exception e){
				e.printStackTrace() ;
				throw e ;
				}finally { 
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		
		return CatalogDesc;
		
}
public String getCatalogNature (String order_catalog_code) throws Exception {
 		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
 		ResultSet resultSet 		= null;
		String CatalogNature="";
 		try
 		{
			//connection	= getConnection();
 			connection = getConnection();
 			pstmt			= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_EXTERNAL_ORDER_ORDER_CATALOG_NATURE") ) ;
			pstmt.setString(1,order_catalog_code);
  			resultSet		= pstmt.executeQuery() ;
  			if(resultSet!=null) // Only One Record
			{
 				while (resultSet.next() ) {
  					CatalogNature= resultSet.getString("order_catalog_nature");
				}
			}
 		 }catch ( Exception e ){
 			System.err.println( "Error loading values from database getCatalogNature" +e) ;
 			e.printStackTrace() ;
 			return null;
 		 } finally {
  			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
 		}
		return CatalogNature;
	} // end of the getCatalogNature

public ArrayList getCareSetCatalogDesc(String order_catalog_code) throws Exception 
{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		String CatalogDesc="";
		ArrayList CatalogDescs=new ArrayList();
		if(order_catalog_code==null || order_catalog_code.equals(" ")) order_catalog_code = "";
		try
		  {
			connection  = getConnection();
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_CARE_SET"));
			pstmt.setString(1,checkForNull(language_id,""));
			pstmt.setString(2,(String)order_catalog_code);
								
			rs	  =pstmt.executeQuery();
			while(rs != null && rs.next())
			{
				CatalogDesc = rs.getString("order_catalog_desc")==null?"":rs.getString("order_catalog_desc");
				CatalogDescs.add(CatalogDesc);
			}
		}
		catch(Exception e){
				e.printStackTrace() ;
				throw e ;
				}finally { 
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		
		return CatalogDescs;
		
}


}
