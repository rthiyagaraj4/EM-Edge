/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// created on 23/12/2009 Shyampriya
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
28/04/2020  				IN:071537       	 B Haribabu                                        			 GHL-CRF-0614
--------------------------------------------------------------------------------------------------------------------------------------------
*/ 
 package ePH ;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import javax.rmi.* ;
import javax.naming.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;


public class ExtGenericLinkBean extends PhAdapter implements Serializable {

    java.util.ArrayList arrListForInsert=null;
    protected String generic_id="";
   	protected String product_id="";
	protected String ext_generic_id="";
    protected String eff_status="";
    protected String fieldCheck="";
    protected String type="";//Added for IN:071537

    public void ExtGenericLinkBean() {
        try {
            doCommon();
        }
        catch(Exception e) {
		e.printStackTrace();
		}
    }

    /* Over-ridden Adapter methods start here */
    public void clear() {
        super.clear() ;
    }

    private void doCommon() throws Exception {
    }

    /* Over-ridden Adapter methods end here */

	/* Getter and Setter methods starts here */
	public String getGeneric_ID()
	{
		return this.generic_id;
	}

	public String getProduct_Id()
	{
		return this.product_id;
	}

	public String getExt_Generic_Id()
	{
		return this.ext_generic_id;
	}

	public String getEff_Status()
	{
		return this.eff_status;
	}

	public void setGeneric_Id(String generic_id)
	{
		this.generic_id = generic_id;
	}

	public void setProduct_Id(String product_id)
	{
		this.product_id = product_id;
	}

	public void setExt_Generic_Id(String ext_generic_id)
	{
		this.ext_generic_id = ext_generic_id;
	}

	public void setEff_Status(String eff_status)
	{
		if(eff_status.equals("") || eff_status == null)
			eff_status = "D";
		this.eff_status = eff_status;
	}
	//Added for IN:071537 start
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
//Added for IN:071537 end
	/* Getter and Setter methods ends here */
	
	public void setAll( Hashtable recordSet )
	{
		 if(recordSet.containsKey("mode"))
            setMode((String)recordSet.get("mode")) ;
         String action = getMode();
		 int totalRecords = 0;
		 arrListForInsert=new ArrayList();

		  if (action.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
            if(recordSet.containsKey("generic_id"))
                setGeneric_Id((String)recordSet.get("generic_id")) ;
            if(recordSet.containsKey("product_id"))
				setProduct_Id((String)recordSet.get("product_id")) ;
			if(recordSet.containsKey("ext_generic_id"))
                setExt_Generic_Id((String)recordSet.get("ext_generic_id")) ;
            if(recordSet.containsKey("eff_status"))
                setEff_Status((String)recordSet.get("eff_status")) ;
			//Added for IN:071537 start	
            if(recordSet.containsKey("typeDesc"))
            	setType((String)recordSet.get("typeDesc")) ;
            else
            	setType("Molecule");
			//Added for IN:071537	end
        }

		 if (action.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {

			  if (recordSet.containsKey("totalRecords")) {
                totalRecords = Integer.parseInt((String)recordSet.get("totalRecords")) ;
            }
			String genericIdForCheck="";
			 String effStatusCheck = "";
			 for (int i=1;i<=totalRecords;i++ )
				{
					 
                if(recordSet.containsKey("generic_id"+i))
					{
						genericIdForCheck=(String)recordSet.get("generic_id"+i) ;
					}
				 if (!(genericIdForCheck.equals("") || genericIdForCheck==null))
                    {
						arrListForInsert.add(genericIdForCheck);
                        if(recordSet.containsKey("product_id"+i))
                            arrListForInsert.add((String)recordSet.get("product_id"+i)) ;
                        if(recordSet.containsKey("ext_generic_id"+i))
                            arrListForInsert.add((String)recordSet.get("ext_generic_id"+i)) ;
                        if (recordSet.containsKey("eff_status"+i)){
                            effStatusCheck=(String)recordSet.get("eff_status"+i);
                            if (effStatusCheck.equals("") || effStatusCheck==null){
                                effStatusCheck="D";
                            }
                            arrListForInsert.add(effStatusCheck) ;
						}
						//Added for IN:071537 start
                        if(recordSet.containsKey("type"+i))
                            arrListForInsert.add((String)recordSet.get("type"+i)) ;
                        else
                        	arrListForInsert.add("Molecule");
						//Added for IN:071537 end	
					}
				
				 } // end for

		 } // end if action = insert
	}

	 public HashMap validate() throws Exception {
        HashMap map=new HashMap();
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "success.." ) ;
        return map;
    }

	  public HashMap insert() {
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( false ) ) ;
        map.put( "message", "Insert Failed::Under Construction......."+arrListForInsert.size() ) ;

        ArrayList insertData = new ArrayList() ;
        ArrayList whereData = new ArrayList() ;
        ArrayList insertObjects = null;
        ArrayList whereObjects = null;

		int j=0;
		

		for (int i=0;i<arrListForInsert.size() ;i+=5 ) {//Modified for IN:071537
				
				insertObjects=new ArrayList();
				whereObjects=new ArrayList();

				insertObjects.add(arrListForInsert.get(i));
                insertObjects.add(arrListForInsert.get(i+1));
                insertObjects.add(arrListForInsert.get(i+2));
                insertObjects.add(arrListForInsert.get(i+3));
                insertObjects.add(arrListForInsert.get(i+4));//Added for IN:071537
                insertObjects.add(login_by_id);
				insertObjects.add(login_at_ws_no);
				insertObjects.add(login_facility_id);
				insertObjects.add(login_by_id);
				insertObjects.add(login_at_ws_no);
				insertObjects.add(login_facility_id);

				whereObjects.add(arrListForInsert.get(j));
				whereObjects.add(arrListForInsert.get(j+1));
				j += 5;//Modified for IN:071537

				insertData.add(insertObjects);
				whereData.add(whereObjects);

		}

		 HashMap tabData = new HashMap() ;
        tabData.put( "properties", getProperties() );
        tabData.put( "InsertData",insertData);
        tabData.put( "WhereData",whereData);

        HashMap sqlMap = new HashMap() ;
		try{
			sqlMap.put( "SelectSQL", "SELECT COUNT(ROWID) FROM PH_GENERIC_EXT_PROD_REF WHERE UPPER(GENERIC_ID) = UPPER(?) AND UPPER(PRODUCT_ID) = UPPER(?)" );
		    sqlMap.put( "InsertSQL", "INSERT INTO PH_GENERIC_EXT_PROD_REF (GENERIC_ID,PRODUCT_ID, EXT_PROD_GENERIC_ID, EFF_STATUS,THIRDPARTY_TYPE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID ) VALUES (?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)" );//Modified for IN:071537
		}catch(Exception e){
			e.printStackTrace();
		}

		try
		  {
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); ;
				paramArray[1] = sqlMap.getClass();

				map = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

            if( ((Boolean) map.get( "result" )).booleanValue() )
                //map.put( "message", getMessage((String) map.get( "msgid" )) ) ;
			    map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
            else{
					 if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) ){
					String msgID = getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common") ;
					//msgID = msgID.substring(0,(msgID.indexOf("<br>"))) ;
					map.put( "message", msgID  ) ;
					map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
					}
					else
						 map.put( "message", (map.get("msgid"))) ;
				}

		   } catch(Exception e)
			   {
					map.put( "message", e.getMessage()) ;
					e.printStackTrace() ;
				} 
			 map.put( "flag" , insertData.toString());
			 return map ;
	  }

	 public HashMap modify() {

        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( false ) ) ;

        ArrayList modifyData = new ArrayList() ;

       
        modifyData.add( ext_generic_id.trim() ) ;
        modifyData.add( eff_status.trim() ) ;
        modifyData.add( type.trim() ) ;//Added for IN:071537
        modifyData.add( login_by_id.trim() ) ;
        modifyData.add( login_at_ws_no.trim() ) ;
        modifyData.add( login_facility_id.trim() ) ;
        modifyData.add( generic_id.trim() ) ;
		modifyData.add( product_id.trim() ) ;
        HashMap tabData = new HashMap() ;
        tabData.put( "properties", getProperties() );
        tabData.put( "ModifyData",modifyData);

        HashMap sqlMap = new HashMap() ;
		//String sql_update = "";  Removed for IN063877
		try{
			sqlMap.put( "ModifySQL", "UPDATE PH_GENERIC_EXT_PROD_REF SET EXT_PROD_GENERIC_ID = ?, EFF_STATUS = ?,THIRDPARTY_TYPE=?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE GENERIC_ID= ? and PRODUCT_ID = ?" );//Modified for IN:071537
		}catch(Exception e){
			e.printStackTrace();
		}
     

        try {
           
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); ;
				paramArray[1] = sqlMap.getClass();

				map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

            if( ((Boolean) map.get( "result" )).booleanValue() )
            {
                map.put( "result", new Boolean( true ) ) ;
                //map.put( "message", getMessage((String) map.get( "msgid" )) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
                map.put( "flag","0");
            }
            else{
                map.put( "result", new Boolean( false ) ) ;
                map.put( "message", (map.get("msgid"))) ;
                map.put( "flag","0");
            }
        } catch(Exception e) {
            map.put( "message", e.getMessage()) ;
            map.put( "flag","0");
            e.printStackTrace() ;
        } 
        return map ;
    } 

	public String getEnabledStatus(String generic_id, String product_id, String ext_prod_generic_id) throws Exception
	{
		 Connection connection = null ;
		 PreparedStatement pstmt = null ;
         ResultSet resultSet = null ;
		 String eff_status = "";
        try {
			    connection = getConnection() ;
				pstmt = connection.prepareStatement( "Select eff_status from ph_generic_ext_prod_ref where generic_id = ? and product_id = ? and ext_prod_generic_id =?" ) ;
				pstmt.setString(1,generic_id.trim());
			    pstmt.setString(2,product_id.trim());
			    pstmt.setString(3,ext_prod_generic_id.trim());
				resultSet = pstmt.executeQuery() ;
				if(resultSet.next() ) 
					{
						eff_status = resultSet.getString("eff_status");
					}
			}catch ( Exception e )
				{
		            e.printStackTrace() ;
				    throw e ;
				}
			 finally 
				 {
					try {
							closeResultSet( resultSet ) ;
			                closeStatement( pstmt ) ;
						    closeConnection( connection );
						 } catch(Exception es) 
							 { 
								es.printStackTrace();
							 }
				}
        return eff_status;
    }
	
public String getExtGenericID(String generic_id, String product_id) throws Exception
	{
		Connection connection = null ;
		 PreparedStatement pstmt = null ;
         ResultSet resultSet = null ;
		 String ExtGeneridId = "";
        try {
			    connection = getConnection() ;
				pstmt = connection.prepareStatement( "Select ext_prod_generic_id from ph_generic_ext_prod_ref where generic_id = ? and product_id = ? " ) ;
				pstmt.setString(1,generic_id.trim());
			    pstmt.setString(2,product_id.trim());
			   	resultSet = pstmt.executeQuery() ;
				if(resultSet.next() ) 
					{
						ExtGeneridId = resultSet.getString("EXT_PROD_GENERIC_ID");
					}
			}catch ( Exception e )
				{
		            e.printStackTrace() ;
				    throw e ;
				}
			 finally 
				 {
					try {
							closeResultSet( resultSet ) ;
			                closeStatement( pstmt ) ;
						    closeConnection( connection );
						 } catch(Exception es) 
							 { 
								es.printStackTrace();
							 }
				}
        return ExtGeneridId;
	}
    
  
}
