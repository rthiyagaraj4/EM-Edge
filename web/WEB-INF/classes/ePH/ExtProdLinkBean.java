/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// created on 07/12/2009
 package ePH ;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import javax.rmi.* ;
import javax.naming.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;


public class ExtProdLinkBean extends PhAdapter implements Serializable {

    java.util.ArrayList arrListForInsert=null;
    protected String drug_code="";
   	protected String product_id="";
	protected String ext_drug_code="";
    protected String eff_status="";
    protected String fieldCheck="";
	protected String cims_type = "";

    public void ExtProdLinkBean() {
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
	public String getDrug_Code()
	{
		return this.drug_code;
	}

	public String getProduct_Id()
	{
		return this.product_id;
	}

	public String getExt_Drug_Code()
	{
		return this.ext_drug_code;
	}

	public String getEff_Status()
	{
		return this.eff_status;
	}

	public String getCims_type()
	{
		return this.cims_type;
	}

	public void setDrug_Code(String drug_code)
	{
		this.drug_code = drug_code;
	}

	public void setProduct_Id(String product_id)
	{
		this.product_id = product_id;
	}

	public void setExt_Drug_Code(String ext_drug_code)
	{
		this.ext_drug_code = ext_drug_code;
	}

	public void setEff_Status(String eff_status)
	{
		if(eff_status.equals("") || eff_status == null)
			eff_status = "D";
		this.eff_status = eff_status;
	}

	public void setCims_type(String cims_type)
	{
		this.cims_type =cims_type;
	}


	/* Getter and Setter methods ends here */
	
	public void setAll( Hashtable recordSet )
	{
//System.out.println("@@@setall function*********"+recordSet);
		 if(recordSet.containsKey("mode"))
            setMode((String)recordSet.get("mode")) ;
         String action = getMode();
		 int totalRecords = 0;
		 arrListForInsert=new ArrayList();

		  if (action.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
            if(recordSet.containsKey("drug_code"))
                setDrug_Code((String)recordSet.get("drug_code")) ;
            if(recordSet.containsKey("product_id"))
				setProduct_Id((String)recordSet.get("product_id")) ;
			if(recordSet.containsKey("ext_prod_drug_code"))
                setExt_Drug_Code((String)recordSet.get("ext_prod_drug_code")) ;
            if(recordSet.containsKey("eff_status"))
                setEff_Status((String)recordSet.get("eff_status")) ;
			if(recordSet.containsKey("typeDesc"))
				setCims_type((String)recordSet.get("typeDesc")) ;
        }

		 if (action.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {

			  if (recordSet.containsKey("totalRecords")) {
                totalRecords = Integer.parseInt((String)recordSet.get("totalRecords")) ;
            }
			String drugCodeForCheck="";
			 String effStatusCheck = "";
			 for (int i=1;i<=totalRecords;i++ )
				{
					 
                if(recordSet.containsKey("drug_code"+i))
					{
						drugCodeForCheck=(String)recordSet.get("drug_code"+i) ;
					}
				 if (!(drugCodeForCheck.equals("") || drugCodeForCheck==null))
                    {
						arrListForInsert.add(drugCodeForCheck);
                        if(recordSet.containsKey("product_id"+i))
                            arrListForInsert.add((String)recordSet.get("product_id"+i)) ;
                        if(recordSet.containsKey("ext_drug_code"+i))
                            arrListForInsert.add((String)recordSet.get("ext_drug_code"+i)) ;
                        if (recordSet.containsKey("eff_status"+i)){
                            effStatusCheck=(String)recordSet.get("eff_status"+i);
                            if (effStatusCheck.equals("") || effStatusCheck==null){
                                effStatusCheck="D";
                            }
                            arrListForInsert.add(effStatusCheck) ;
						}
						if (recordSet.containsKey("type"+i))
                            arrListForInsert.add((String)recordSet.get("type"+i));
					}
				
				 } // end for
//System.out.println("@@@setall function****arrListForInsert*****"+arrListForInsert);

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
System.out.println("Insert Failed::Under Construction......."+arrListForInsert);
		int j=0;
		

		for (int i=0;i<arrListForInsert.size() ;i+=5 ) {
				
				insertObjects=new ArrayList();
				whereObjects=new ArrayList();

				insertObjects.add(((String)arrListForInsert.get(i)).trim());
                insertObjects.add(((String)arrListForInsert.get(i+1)).trim());
                insertObjects.add(((String)arrListForInsert.get(i+2)).trim());
                insertObjects.add(((String)arrListForInsert.get(i+3)).trim());
                insertObjects.add(((String)arrListForInsert.get(i+4)).trim());
                insertObjects.add(login_by_id);
				insertObjects.add(login_at_ws_no);
				insertObjects.add(login_facility_id);
				insertObjects.add(login_by_id);
				insertObjects.add(login_at_ws_no);
				insertObjects.add(login_facility_id);

				whereObjects.add(arrListForInsert.get(j));
				whereObjects.add(arrListForInsert.get(j+1));
				j += 5;

				insertData.add(insertObjects);
				whereData.add(whereObjects);

		}

		 HashMap tabData = new HashMap() ;
        tabData.put( "properties", getProperties() );
        tabData.put( "InsertData",insertData);
        tabData.put( "WhereData",whereData);

        HashMap sqlMap = new HashMap() ;
		try{
			sqlMap.put( "SelectSQL", "SELECT COUNT(ROWID) FROM PH_DRUG_EXT_PROD_DRUG WHERE UPPER(DRUG_CODE) = UPPER(?) AND UPPER(PRODUCT_ID) = UPPER(?)" );
		    sqlMap.put( "InsertSQL", "INSERT INTO PH_DRUG_EXT_PROD_DRUG (DRUG_CODE,PRODUCT_ID, EXT_PROD_DRUG_CODE, EFF_STATUS, TYPE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID ) VALUES (?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)" );
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

       
        modifyData.add( ext_drug_code.trim() ) ;
        modifyData.add( eff_status.trim() ) ;
        modifyData.add( login_by_id.trim() ) ;
        modifyData.add( login_at_ws_no.trim() ) ;
        modifyData.add( login_facility_id.trim() ) ;
		modifyData.add( cims_type.trim() );
        modifyData.add( drug_code.trim() ) ;
		modifyData.add( product_id.trim() ) ;
        HashMap tabData = new HashMap() ;
        tabData.put( "properties", getProperties() );
        tabData.put( "ModifyData",modifyData);

        HashMap sqlMap = new HashMap() ;
		//String sql_update = "";   Removed for IN063877
		try{
			sqlMap.put( "ModifySQL", "UPDATE PH_DRUG_EXT_PROD_DRUG SET EXT_PROD_DRUG_CODE = ?, EFF_STATUS = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?, TYPE = ? WHERE DRUG_CODE= ? and PRODUCT_ID = ?" );
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

	public String getEnabledStatus(String drug_code, String product_id, String ext_prod_drug_code) throws Exception
	{
		 Connection connection = null ;
		 PreparedStatement pstmt = null ;
         ResultSet resultSet = null ;
		 String eff_status = "";
        try {
			    connection = getConnection() ;
				pstmt = connection.prepareStatement( "Select eff_status from ph_drug_ext_prod_drug where drug_code = ? and product_id = ? and ext_prod_drug_code =?" ) ;
				pstmt.setString(1,drug_code.trim());
			    pstmt.setString(2,product_id.trim());
			    pstmt.setString(3,ext_prod_drug_code.trim());
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
	
public String getExtDrugCode(String drug_code, String product_id) throws Exception
	{
		Connection connection = null ;
		 PreparedStatement pstmt = null ;
         ResultSet resultSet = null ;
		 String ExtDrugCode = "";
        try {
			    connection = getConnection() ;
				pstmt = connection.prepareStatement( "Select ext_prod_drug_code from ph_drug_ext_prod_drug where drug_code = ? and product_id = ? " ) ;
				pstmt.setString(1,drug_code.trim());
			    pstmt.setString(2,product_id.trim());
			   	resultSet = pstmt.executeQuery() ;
				if(resultSet.next() ) 
					{
						ExtDrugCode = resultSet.getString("EXT_PROD_DRUG_CODE");
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
        return ExtDrugCode;
	}
    
  
}
