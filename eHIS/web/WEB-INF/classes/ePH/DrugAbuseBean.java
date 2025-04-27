/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
  //saved on 08/11/2005
package ePH ;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
/*import javax.rmi.* ;
import javax.naming.* ;*/
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;

public class DrugAbuseBean extends PhAdapter implements Serializable 
{
	protected String patient_id				= "";
	protected String restriction_type		= "";
	protected String drug_class				= "";
	protected String drug_code				= "";
	protected String action_type			= "";
	protected String restrict_transaction_yn= "";
	protected String remarks				= "";

	protected String restriction_type_desc= "";
	protected String drug_class_or_drug_code_desc= "";	
 

	public DrugAbuseBean() 
	{
		try 
		{
			doCommon();
		}
		
		catch(Exception e) { e.printStackTrace();}
	}

	/* Over-ridden Adapter methods start here */
	public void clear() 
	{
		patient_id					= "";
		restriction_type			= "";
		drug_class					= "";
		drug_code					= "";
		action_type					= "";
		restrict_transaction_yn		= "";
		remarks						= "";		
		restriction_type_desc		= "";	
		drug_class_or_drug_code_desc= "";	

		super.clear() ;
	}

	private void doCommon() throws Exception 
	{
	}

	/* Over-ridden Adapter methods end here */

	
	public void setPatientId(String patient_id)
	{
		this.patient_id = patient_id;
	}

	public void setRestrictionType(String restriction_type)
	{
		this.restriction_type = restriction_type;
	}

	public void setDrugClass(String drug_class)
	{
		this.drug_class = drug_class;
	}

	public void setDrugCode(String drug_code)
	{
		this.drug_code = drug_code;
	}


	public void setActionType(String action_type)
	{
		this.action_type = action_type;
	}

	public void setRestrictionYn(String restrict_transaction_yn)
	{
		this.restrict_transaction_yn = restrict_transaction_yn;
	}
	
	public void setRemarks(String remarks)
	{
		this.remarks = remarks;
	}

	public void setRestrictionTypeDesc(String restriction_type_desc)
	{
		this.restriction_type_desc = restriction_type_desc;
	}

 	public void setDrugClassDesc(String drug_class_desc)
	{
		this.drug_class_or_drug_code_desc = drug_class_desc;
	}


	public String getPatientId()
	{
		return patient_id;
	}

	public String getRestrictionType()
	{
		return restriction_type;
	}

	public String getDrugClass()
	{
		return drug_class;
	}

	public String getDrugCode()
	{
		return drug_code;
	}

	public String getActionType()
	{
		return action_type;
	}

	public String getRestrictTransactionYn()
	{
		return restrict_transaction_yn;
	}

	public String getRemarks()
	{
		return remarks;
	}
	public String getRestrictionTypeDesc()
	{
		return remarks;
	}
	public String getDrugClassDesc()
	{
		return drug_class_or_drug_code_desc;
	}
		
	public HashMap validate() throws Exception 
	{
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}

	// setAll method to set all the values
	public void setAll(Hashtable recordSet)
	{	


		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;
		if(recordSet.containsKey("p_patient_id"))
			setPatientId((String)recordSet.get("p_patient_id")) ;
		if(recordSet.containsKey("p_restriction_type"))
			setRestrictionType((String)recordSet.get("p_restriction_type")) ;
		if(recordSet.containsKey("p_drug_class"))
			setDrugClass((String)recordSet.get("p_drug_class")) ;
		if(recordSet.containsKey("p_drug_code"))
			setDrugCode((String)recordSet.get("p_drug_code")) ;
		if(recordSet.containsKey("p_action_type"))
			setActionType((String)recordSet.get("p_action_type")) ;
		if(recordSet.containsKey("p_restrict_transaction_yn"))
			setRestrictionYn(checkForNull((String)recordSet.get("p_restrict_transaction_yn"),"N")) ;
		if(recordSet.containsKey("p_remarks"))
			setRemarks((String)recordSet.get("p_remarks")) ;

		//Set both as same 
		if(recordSet.containsKey("p_drug_class_drug_code")) { //only in Modify/delete mode
			setDrugClass((String)recordSet.get("p_drug_class_drug_code")) ;
		}
	}

	public void loadData(String patient_id, String restriction_type, String drug_class_or_drug_code) throws Exception
	{
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		
		try 
		{
			connection = getConnection() ;
			String SQL_PH_DRUG_ABUSE_SELECT="SELECT RESTRICTION_TYPE, DECODE(RESTRICTION_TYPE,'DC','DRUG CLASS','DN','DRUG NAME',RESTRICTION_TYPE) RESTRICTION_TYPE_DESC, DRUG_CLASS_OR_DRUG_CODE, DECODE(DRUG_CLASS_OR_DRUG_CODE,'G','GENERAL','C','CONTROLLED','N','NARCOTICS',(select drug_desc from ph_drug where drug_code=drug_class_or_drug_code)) DRUG_CLASS_OR_DRUG_CODE_DESC, NVL(RESTRICT_TRAN_TYPE,'N') RESTRICT_TRAN_TYPE, ACTION_TYPE_FLAG, nvl(REMARKS,'') REMARKS from PH_DRUG_ABUSE_PAT_MST WHERE PATIENT_ID= ? AND RESTRICTION_TYPE= ? AND DRUG_CLASS_OR_DRUG_CODE= ?";
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ADRTYPE_SELECT1") );
			pstmt = connection.prepareStatement(SQL_PH_DRUG_ABUSE_SELECT);
			pstmt.setString(1, patient_id ) ;
			pstmt.setString(2, restriction_type);
			pstmt.setString(3, drug_class_or_drug_code);

			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) 
			{
				setRestrictionTypeDesc(resultSet.getString("RESTRICTION_TYPE_DESC" ));
				setDrugClassDesc(resultSet.getString("DRUG_CLASS_OR_DRUG_CODE_DESC" ));

				setActionType(resultSet.getString("ACTION_TYPE_FLAG" ));
				setRestrictionYn(resultSet.getString("RESTRICT_TRAN_TYPE" ));
				setRemarks(checkForNull(resultSet.getString("REMARKS" )));
			}			  
		}
		catch ( Exception e )
		{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally 
		{
			try
			{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es)
			{
				System.err.println("Error while closing the statement,resultset and connection"+es.toString());
				es.printStackTrace();
			}
		}
	}

	public HashMap insert() {
		//System.out.println("Inside insert in bean");

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;

		ArrayList insertData = new ArrayList() ;
		ArrayList whereData = new ArrayList() ;

		try{
		
 
			insertData.add( getPatientId().trim() ) ;
			insertData.add( getRestrictionType().trim() ) ;
			if(getRestrictionType()!=null && getRestrictionType().equalsIgnoreCase("DC"))
				insertData.add( getDrugClass().trim()) ;  //Drug Class
			else
				insertData.add( getDrugCode().trim()) ; // Drug Name
			insertData.add( getActionType().trim() ) ;
			insertData.add( getRestrictTransactionYn().trim()) ;
			insertData.add( getRemarks().trim()) ;

			insertData.add( login_by_id.trim() ) ;
			insertData.add( login_at_ws_no.trim() ) ;
			insertData.add( login_facility_id.trim() ) ;

			insertData.add( login_by_id.trim() ) ;
			insertData.add( login_at_ws_no.trim() ) ;
			insertData.add( login_facility_id.trim() ) ;

			whereData.add( getPatientId().trim() ) ;
			whereData.add( getRestrictionType().trim() ); 
			
			if(getRestrictionType()!=null && getRestrictionType().equalsIgnoreCase("DC"))
				whereData.add( getDrugClass().trim()) ;  //Drug Class
			else
				whereData.add( getDrugCode().trim()) ; // Drug Name


			HashMap tabData = new HashMap() ;

			tabData.put( "properties", getProperties() );
			tabData.put( "InsertData",insertData);
			tabData.put( "WhereData",whereData);

			HashMap sqlMap = new HashMap() ;
			String SQL_PH_DRUGABUSE_COUNT_SELECT="SELECT COUNT(ROWID) FROM PH_DRUG_ABUSE_PAT_MST WHERE PATIENT_ID=? AND RESTRICTION_TYPE = ? AND DRUG_CLASS_OR_DRUG_CODE =?";

			String SQL_PH_DRUGABUSE_INSERT="INSERT INTO PH_DRUG_ABUSE_PAT_MST (PATIENT_ID, RESTRICTION_TYPE, DRUG_CLASS_OR_DRUG_CODE,ACTION_TYPE_FLAG,  RESTRICT_TRAN_TYPE, REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
			sqlMap.put("SelectSQL",SQL_PH_DRUGABUSE_COUNT_SELECT);
			sqlMap.put( "InsertSQL", SQL_PH_DRUGABUSE_INSERT);

		/*	SingleTableHandlerHome home = null;
			SingleTableHandlerRemote remote = null;*/

			try {
     			Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]=new Object[2];
				argArray[0]=tabData;
				argArray[1]=sqlMap;

				Class[] paramArray=new Class[2];
				paramArray[0]=tabData.getClass();
				paramArray[1]=sqlMap.getClass();

				map=(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


				if( ((Boolean) map.get( "result" )).booleanValue() )
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;

				else{
					if( ((String)map.get( "msgid" )).equals("CODE_ALREADY_EXISTS" ) )
						map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common") ) ;
					else
						map.put( "message", (map.get("msgid"))) ;
				}
			}
			catch(Exception e) {
				System.err.println( "Error Calling EJB : "+e ) ;
				map.put( "message", e.getMessage()) ;
				e.printStackTrace() ;
			}
		}
		catch(Exception e)
		{
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", "exp :"+e.getMessage()) ;
			e.printStackTrace() ;
		}
/*		finally 
		{
			try {} 
			catch( Exception ee )
			{
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}
		}//finally*/
		
		return map ;
	}

	public HashMap modify() 
	{
		StringBuffer debug =new StringBuffer();
	
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		ArrayList modifyData = new ArrayList() ;

			modifyData.add( getRestrictTransactionYn().trim()) ;
			modifyData.add( getActionType().trim() ) ;
			modifyData.add( getRemarks().trim()) ;
	 		modifyData.add( login_by_id.trim() ) ;
			modifyData.add( login_at_ws_no.trim() ) ;
			modifyData.add( login_facility_id.trim() ) ;
						
			modifyData.add( getPatientId().trim() ) ;
			modifyData.add( getRestrictionType().trim() ) ;
			
			if(getRestrictionType()!=null && getRestrictionType().equalsIgnoreCase("DC"))
				modifyData.add( getDrugClass().trim()) ;  //Drug Class
			else
				modifyData.add( getDrugCode().trim()) ; // Drug Name



		HashMap tabData = new HashMap() ;
		tabData.put( "properties", getProperties() );
		tabData.put( "ModifyData",modifyData);

		HashMap sqlMap = new HashMap() ;
		try
		{
			String SQL_PH_DRUGABUSE_UPDATE="UPDATE PH_DRUG_ABUSE_PAT_MST SET  RESTRICT_TRAN_TYPE=?, ACTION_TYPE_FLAG = ?,REMARKS = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE PATIENT_ID=? AND RESTRICTION_TYPE=? AND DRUG_CLASS_OR_DRUG_CODE = ?";

			//sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue("SQL_PH_ADRTYPE_UPDATE") );
			sqlMap.put( "ModifySQL",  SQL_PH_DRUGABUSE_UPDATE);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

/*		SingleTableHandlerHome home = null;
		SingleTableHandlerRemote remote = null;*/

		try 
		{
 			Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]=new Object[2];
			argArray[0]=tabData;
			argArray[1]=sqlMap;

			Class[] paramArray=new Class[2];
			paramArray[0]=tabData.getClass();
			paramArray[1]=sqlMap.getClass();

			map=(HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			debug.append("After MODIFY:::"+(Boolean) map.get( "result" ));
			if( ((Boolean) map.get( "result" )).booleanValue() )
			{
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
				map.put( "flag",debug.toString());
			}
			else{
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", (map.get("msgid"))) ;
				map.put( "flag",debug.toString());
			}
		}
		catch(Exception e) 
		{
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", e.getMessage()) ;
			map.put( "flag",debug.toString());
			e.printStackTrace() ;
		}
 
		return map ;	
	}


	public HashMap delete() {
System.err.println("==DELETE MODE=====");
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "success.." ) ;
		map.put( "flag", "test") ;
		ArrayList deleteData = new ArrayList() ;
        try{
				deleteData.add( getPatientId().trim() ) ;
				deleteData.add( getRestrictionType().trim() ) ;
				if(getRestrictionType()!=null && getRestrictionType().equalsIgnoreCase("DC"))
					deleteData.add( getDrugClass().trim()) ;  //Drug Class
				else
					deleteData.add( getDrugCode().trim()) ; // Drug Name



				HashMap tabData = new HashMap() ;
				tabData.put( "properties", getProperties() );
				tabData.put( "DeleteData",deleteData);

System.err.println("==DELETE MODE=====deleteData"+deleteData);
				HashMap sqlMap = new HashMap() ;
				String SQL_PH_DRUGABUSE_DELETE="DELETE FROM PH_DRUG_ABUSE_PAT_MST WHERE PATIENT_ID=? AND RESTRICTION_TYPE=? AND DRUG_CLASS_OR_DRUG_CODE = ?";

				//sqlMap.put( "DeleteSQL", PhRepository.getPhKeyValue("SQL_PH_DISP_RULE_DELETE") );
				sqlMap.put( "DeleteSQL", SQL_PH_DRUGABUSE_DELETE );
System.err.println("==DELETE MODE=====sqlMap"+sqlMap);
/*          SingleTableHandlerHome home = null;
            SingleTableHandlerRemote remote = null;*/
            try {
/*              InitialContext context = new InitialContext() ;
                Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;

                home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
                remote = home.create() ;
                map = remote.delete( tabData, sqlMap ) ;*/

				Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]=new Object[2];
				argArray[0]=tabData;
				argArray[1]=sqlMap;

				Class[] paramArray=new Class[2];
				paramArray[0]=tabData.getClass();
				paramArray[1]=sqlMap.getClass();

				map=(HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


                if( ((Boolean) map.get( "result" )).booleanValue() )
                    map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
                else{
                    map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;

				}
            } 
            catch(Exception e) {
                System.err.println( "Error Calling EJB : "+e ) ;
                map.put( "message", e.getMessage()) ;
                e.printStackTrace() ;
            }
        }
        catch(Exception e){
            System.err.println( "Error Calling EJB : "+e ) ;
            map.put( "message", "exp :"+e.getMessage()) ;
            e.printStackTrace() ;
        }
/*        finally {
            try {}
            catch( Exception ee ){
                System.err.println( ee.getMessage() ) ;
                map.put( "message", ee.getMessage() ) ;  ee.printStackTrace();
            }
        }//finally */
         
        return map ;
}
	
	public ArrayList getPatientDetails(String patient_id){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList	records		=	new ArrayList();

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( "SELECT DECODE(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) PATIENT_NAME,GET_AGE(DATE_OF_BIRTH) AGE, DECODE(SEX,'M','male','F','female','unknown') GENDER, to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH FROM MP_PATIENT WHERE PATIENT_ID=?" ) ;
			pstmt.setString(1,getLanguageId());
			pstmt.setString(2,patient_id);
			resultSet	= pstmt.executeQuery();
			if(resultSet != null && resultSet.next() ) {
				records.add(resultSet.getString("PATIENT_NAME"));
				records.add(resultSet.getString("AGE"));
				records.add(resultSet.getString("GENDER"));
				records.add(resultSet.getString("DATE_OF_BIRTH"));
			}
		}
		catch(Exception e){
			records.add(e.toString());
			e.printStackTrace();
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){es.printStackTrace();}
		}
		return records;	
	}

public String getPatientIDLength(){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	pat_txt_length	=	null ;

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_COMMON_SELECT1") ) ;
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				pat_txt_length	=	checkForNull(resultSet.getString("PATIENT_ID_LENGTH"));
			}						
		}
		catch(Exception e){
				pat_txt_length	=e.toString();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return pat_txt_length;	
	}

	public String getChecked(String string){
		return (string.equalsIgnoreCase("Y"))? "checked" : "";
	}

} 
