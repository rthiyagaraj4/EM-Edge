/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH;

import java.io.* ;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.* ;

import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;

public class PrescribingUomDecimalBean extends PhAdapter implements Serializable {
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;  Removed for IN063877
	ArrayList alForInsert = new ArrayList();
	protected String uom_code="";
	protected float decimal_value;
	protected String fract_value="";
	protected String fract_desc="";
	protected String fract_desc_local="";
	protected String eff_status="";
	
	public String getUom_code() {
		return uom_code;
	}

	public void setUom_code(String uom_code) {
		this.uom_code = uom_code;
	}

	public float getDecimal_value() {
		return decimal_value;
	}

	public void setDecimal_value(float decimal_value) {
		this.decimal_value = decimal_value;
	}

	public String getFract_value() {
		return fract_value;
	}

	public void setFract_value(String fract_value) {
		this.fract_value = fract_value;
	}

	public String getFract_desc() {
		return fract_desc;
	}

	public void setFract_desc(String fract_desc) {
		this.fract_desc = fract_desc;
	}

	public String getFract_desc_local() {
		return fract_desc_local;
	}

	public void setFract_desc_local(String fract_desc_local) {
		this.fract_desc_local = fract_desc_local;
	}

	public String getEff_status() {
		return eff_status;
	}

	public void setEff_status(String eff_status) {
		if(eff_status.equals(""))
			this.eff_status = "D" ;
		else
			this.eff_status = eff_status ;
	}

	public PrescribingUomDecimalBean() {
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
	
	 public void setAll( Hashtable hshtable ){

	        setMode((String)hshtable.get("mode")) ;
	        String action = getMode();
			String  effStatus="",PrescribeUomCode,DecimalValue;
			int totRecords = 0;
			
	        alForInsert=new ArrayList();
	        try{
	        if (action.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
	            	
	        	totRecords = Integer.parseInt((String)hshtable.get("totalRecords"));
	            for (int i=0;i<totRecords;i++ ) {
	            	PrescribeUomCode = "PrescribeUomCode_"+i ;
	            	DecimalValue = "DecimalValue_"+i;
					effStatus =(String)hshtable.get("EffStatus"+i);
						
					if(!(  ((String)hshtable.get(PrescribeUomCode)).equals("") || ((String)hshtable.get(DecimalValue)).equals(""))	){
							alForInsert.add((String)hshtable.get("PrescribeUomCode_"+i)) ;
                            alForInsert.add((String)hshtable.get("DecimalValue_"+i)) ;
                            alForInsert.add((String)hshtable.get("FractionalValue_"+i)) ;
                            alForInsert.add((String)hshtable.get("FractionalDesc_"+i)) ;
                            alForInsert.add((String)hshtable.get("FractionalDescLocal_"+i)) ;
                            if (effStatus==null || effStatus.equals("")){
    							effStatus="D";
    						}
							alForInsert.add(effStatus) ;
	                    }
	                }
	            }
			else if (action.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
					alForInsert.add((String)hshtable.get("PrescribeUomCode"));
					alForInsert.add((String)hshtable.get("DecimalValue"));
					alForInsert.add((String)hshtable.get("FractionalValue"));
					alForInsert.add((String)hshtable.get("FractionalDesc"));
					alForInsert.add((String)hshtable.get("FractionalDescLocal"));
					effStatus = (String)hshtable.get("EffStatus");
					if(effStatus==null || effStatus.equals(""))
						effStatus="D";
					alForInsert.add(effStatus) ;
			}
	 	}
	    catch(Exception e){
	    	e.printStackTrace(); 
	    }
	 }
	 
	    public HashMap insert() {
	        HashMap map = new HashMap() ;
	        map.put( "result", new Boolean( false ) ) ;
	        map.put( "message", "Insert Failed::Under Construction......."+alForInsert) ;

	        ArrayList insertData = new ArrayList() ;
	        ArrayList insertObjects = new ArrayList();
	        ArrayList whereData = new ArrayList() ;
	        ArrayList whereObjects = new ArrayList();
			HashMap tabData = new HashMap() ;
			
	        try{
				for (int i=0;i<alForInsert.size() ;i+=6 ) {
					insertObjects=new ArrayList();
					whereObjects=new ArrayList();
					insertObjects.add(alForInsert.get(i));	//UOM code
					insertObjects.add(alForInsert.get(i+1)); //Decimal Value
					insertObjects.add(alForInsert.get(i+2)); //Fractional Value
					insertObjects.add(alForInsert.get(i+3)); //Fractional Desc
					insertObjects.add(alForInsert.get(i+4)); //Fractional DescLocal
					insertObjects.add(alForInsert.get(i+5)); //Eff_Status
					insertObjects.add(login_by_id);
					insertObjects.add(login_at_ws_no);
					insertObjects.add(login_facility_id);
					insertObjects.add(login_by_id);
					insertObjects.add(login_at_ws_no);
					insertObjects.add(login_facility_id);
					whereObjects.add(alForInsert.get(i));
					whereObjects.add(alForInsert.get(i+1));

					insertData.add(insertObjects);
					whereData.add(whereObjects);
				}
				tabData.put( "properties", getProperties() );
				tabData.put( "InsertData",insertData);
				tabData.put( "WhereData",whereData);

				HashMap sqlMap = new HashMap() ;
				sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue("SQL_PH_PRES_UOM_DECIMAL_INSERT_CHECK"));
				sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue("SQL_PH_PRES_UOM_DECIMAL_INSERT"));
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
				    map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
	            else{
	                if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) ){
						String msgID = getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common") ;
						map.put( "message", msgID  ) ;
						map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
					}
	                else
	                    map.put( "message", (map.get("msgid"))) ;
	            }
	        } catch(Exception e) {
	            map.put( "message", e.getMessage()) ;
	            e.printStackTrace() ;
	        } 
	        map.put( "flag" , insertData.toString());
	        return map ;
	    }
	    public HashMap modify() {
	        HashMap map = new HashMap() ;
	        map.put( "result", new Boolean( false ) ) ;
	        map.put( "message", "Modify Failed::Under Construction......."+alForInsert) ;

	        ArrayList modifyData = new ArrayList() ;
			try {
				if(alForInsert.size()>0 ) {

					modifyData.add(alForInsert.get(2)); //Fractional Value
					modifyData.add(alForInsert.get(3)); //Fractional Desc
					modifyData.add(alForInsert.get(4)); //Fractional DescLocal
					modifyData.add(alForInsert.get(5)); //Eff_Status
					modifyData.add(login_by_id);
					modifyData.add(login_at_ws_no);
					modifyData.add(login_facility_id);
					modifyData.add(alForInsert.get(0));	//UOM code
					modifyData.add(alForInsert.get(1)); //Decimal Value

					HashMap tabData = new HashMap() ;
					tabData.put( "properties", getProperties());
					tabData.put( "ModifyData",modifyData);

					HashMap sqlMap = new HashMap() ;
					sqlMap.put( "ModifySQL",PhRepository.getPhKeyValue("SQL_PH_PRES_UOM_DECIMAL_UPDATE"));

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

					if( ((Boolean) map.get( "result" )).booleanValue()){
						map.put( "result", new Boolean( true ) ) ;
						map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
						map.put( "flag","0");
					}
					else{
						map.put( "result", new Boolean( false ) ) ;
						map.put( "message", (map.get("msgid"))) ;
						map.put( "flag","0");
					}
				}
			} catch(Exception e) {
				map.put( "message", e.getMessage()) ;
				map.put( "flag","0");
				e.printStackTrace() ;
			} 
	        return map ;
	    }
	    
	    public String getLongDesc_UOMCode(String strUomcode, String strlangid) throws Exception
	    {
	    	String strLongDesc="";
	    	Connection connection	= null;
	        PreparedStatement pstmt	= null;
	        ResultSet resultSet		= null;	
	        try {
	            connection	= getConnection() ;
	            pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_AM_UOM_LANG_VW_SELECT_LONGDESC")) ;
				pstmt.setString(1,strUomcode);
				pstmt.setString(2,strlangid);
	            resultSet	= pstmt.executeQuery() ;
				if (resultSet.next()){
					strLongDesc		=	resultSet.getString("LONG_DESC");		
				}
			}
			catch ( Exception e ) {
				e.printStackTrace() ;			
			}
			finally {
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection( connection ); 
				}catch(Exception es){
					es.printStackTrace();
				}
			}
	    	return strLongDesc;
	    }
	    
		public ArrayList getDetailsForUpdate(String strUomcode, String strDecimal, String locale) throws Exception
	    {
	    	ArrayList arrList = new ArrayList();
	    	Connection connection = null ;
			PreparedStatement pstmt = null ;
			ResultSet resultSet = null ;
			try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_PRES_UOM_DECIMAL_SELECT" ) ) ;
				pstmt.setString(1,strUomcode);
				pstmt.setString(2,strDecimal);
				pstmt.setString(3,locale);
				resultSet = pstmt.executeQuery() ;
				if ( resultSet != null && resultSet.next() )  
				{
					arrList.add( resultSet.getString( "UOM_CODE" ) ) ;
					arrList.add( resultSet.getString( "UOM_DESC" ) ) ;
					arrList.add( resultSet.getString( "DECIMAL_VALUE" ) ) ;
					arrList.add( resultSet.getString( "FRACT_VALUE" ) ) ;
					arrList.add( resultSet.getString( "FRACT_DESC" ) ) ;
					arrList.add( checkForNull(resultSet.getString( "FRACT_DESC_LOCAL" )) ) ;
					arrList.add( resultSet.getString( "EFF_STATUS" ) ) ;
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
				}catch(Exception es) {
					es.printStackTrace();
				}
			}
	    	return arrList;
	    }
}
