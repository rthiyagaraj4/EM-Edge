/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package ePH ;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import javax.rmi.* ;
import javax.naming.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import ePH.DrugCategory.*;
import eCommon.SingleTableHandler.*;



public class PregnancyCategoryBean extends PhAdapter implements Serializable {

    java.util.ArrayList arrListForInsert=null;
	java.util.ArrayList arrListForUpdate=null;
	java.util.ArrayList arrListForCategoryInsert=null;
	java.util.ArrayList arrListForCategoryUpdate=null;



	protected String cgCode ="";
	protected String cgStatus ="";
	protected String cgDesc ="";
	protected String cStatus = "";
	protected String dbMode = "";
	protected String cCode = "";
	protected String cDesc = "";
	


    public PregnancyCategoryBean() {
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


    // set methods start

   public void setCGCode(String cgCode){
	   this.cgCode = cgCode;
   }
   public void setCGDesc(String cgDesc){
	     this.cgDesc = cgDesc;
   }
   public void setCGStatus(String cgStatus){
	   if(cgStatus.equals("") || cgStatus==null )
            this.cgStatus = "D" ;
        else
            this.cgStatus = "E" ;
   }
   public void setCStatus(String cStatus){
	    if(cStatus.equals("") || cStatus==null )
            this.cStatus = "N" ;
        else
            this.cStatus = "Y" ;
   }
    public void setCCode(String cCode){
	   this.cCode = cCode;
   }
   public void setCDesc(String cDesc){
	   this.cDesc = cDesc;
   }
   public void setDBMode(String dbMode){
	   this.dbMode = dbMode;
   }
	
  
    // set methods end

    // get methods start here

    public String getCGCode() {
        return this.cgCode  ;
    }
    public String getCGDesc() {
        return this.cgDesc  ;
    }
    public String getCGStatus() {
        return this.cgStatus ;
    }
    public String getCStatus() {
        return this.cStatus ;
    }
	public String getCCode() {
        return this.cCode  ;
    }
    public String getCDesc() {
        return this.cDesc  ;
    }
	 public String getDBMode() {
        return this.dbMode  ;
    }
    
    // get methods end here

    public void setAll( Hashtable recordSet ){
        //System.out.println("recordSet-->"+recordSet);
        if(recordSet.containsKey("mode"))
            setMode((String)recordSet.get("mode")) ;
        String action = getMode();

        arrListForInsert = new ArrayList();
		arrListForUpdate = new ArrayList();
		arrListForCategoryInsert = new ArrayList();
		arrListForCategoryUpdate = new ArrayList();

       
            if (recordSet.containsKey("cgCode")) {
                cgCode = (String)recordSet.get("cgCode") ;
            }
			 if (recordSet.containsKey("cgDesc")) {
                cgDesc = (String)recordSet.get("cgDesc") ;
               //try{
                //cgDesc = java.net.URLEncoder.encode(((String)recordSet.get("cgDesc")).trim(),"UTF-8");
			   //}catch(Exception e){e.printStackTrace();}
			  
				//System.out.println("@@@@@cgDesc---->"+cgDesc);
            }
			 if (recordSet.containsKey("cgStatus")) {
                cgStatus = (String)recordSet.get("cgStatus") ;
				setCGStatus(cgStatus);
            }

			if (action.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			  arrListForCategoryUpdate.add(cgCode);
			  arrListForCategoryUpdate.add(cgDesc);
			  arrListForCategoryUpdate.add(getCGStatus());
			}
			else{
				arrListForCategoryInsert.add(cgCode);
				arrListForCategoryInsert.add(cgDesc);
				arrListForCategoryInsert.add(getCGStatus());
			}

			for (int i=1;i<=12 ;i++ )
			{
				
				if(recordSet.containsKey("cCode"+i)){
				cCode	= (String)recordSet.get("cCode"+i) ;
				setCCode(cCode);
				}
				
				if(recordSet.containsKey("cDesc"+i)){
				cDesc	= (String)recordSet.get("cDesc"+i) ;
				//try{
				////cDesc = java.net.URLEncoder.encode(((String)recordSet.get("cDesc"+i)).trim(),"UTF-8");
				//}catch(Exception e){e.printStackTrace();}
				
				setCDesc(cDesc);
				//System.out.println("@@@@@cDesc---->"+cDesc);
				}

				if (recordSet.containsKey("cStatus"+i)) {
                cStatus = (String)recordSet.get("cStatus"+i) ;
				setCStatus(cStatus);				
				}
				
				
				if(recordSet.containsKey("dbMode"+i)){
				dbMode	= (String)recordSet.get("dbMode"+i) ;
				setDBMode(dbMode);
				}
				
				if (getDBMode().equalsIgnoreCase("I")&&(!(getCCode().equals(""))))
				{
					arrListForInsert.add(cgCode);
					arrListForInsert.add(getCCode());
					arrListForInsert.add(getCDesc());
					arrListForInsert.add(getCStatus());
				}
				else if (getDBMode().equalsIgnoreCase("U"))
				{
					arrListForUpdate.add(cgCode);
					arrListForUpdate.add(getCCode());
					arrListForUpdate.add(getCDesc());
					arrListForUpdate.add(getCStatus());
					
				}

			}
			//System.out.println("arrListForUpdate"+arrListForUpdate);
			//System.out.println("arrListForInsert"+arrListForInsert);
			//System.out.println("arrListForCategoryInsert"+arrListForCategoryInsert);
			//System.out.println("arrListForCategoryUpdate"+arrListForCategoryUpdate);

        }
   // }


    // validate method starts here...
    public HashMap validate() throws Exception {
        HashMap map=new HashMap();
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "success.." ) ;
        return map;
    }
    // validate method ends here...

    // insert method  starts here...
public HashMap insert() {
        HashMap map = new HashMap() ;
		HashMap tabData = new HashMap();
		HashMap sqlMap = new HashMap();
        //map.put( "result", new Boolean( false ) ) ;
		map.put("result", new Boolean(false));
		map.put("flag", "0");
      

        ArrayList insertData = new ArrayList() ;
        ArrayList insertData1 = new ArrayList() ;

		//ArrayList whereData = new ArrayList() ;  Removed for IN063877

        ArrayList insertRow = null;
        ArrayList insertRow1 = null;

	//	ArrayList whereObjects = null;  Removed for IN063877

		String msgId = "";

		try{
		//System.out.println("arrListForCategoryInsert-->"+arrListForCategoryInsert);
		//System.out.println("arrListForInsert-->"+arrListForInsert);
        
		for(int i=0;i<arrListForCategoryInsert.size();i+=3){
		  insertRow = new ArrayList();
		  insertRow.add(arrListForCategoryInsert.get(i));
		  insertRow.add(arrListForCategoryInsert.get(i+1));
		  insertRow.add(arrListForCategoryInsert.get(i+2));
		  insertRow.add(login_by_id);
		  insertRow.add(login_at_ws_no);
		  insertRow.add(login_facility_id);
		  insertRow.add(login_by_id);
		  insertRow.add(login_at_ws_no);
		  insertRow.add(login_facility_id);
          insertData.add(insertRow);
		}
		
		map.put("result", new Boolean(true));
		//System.out.println("insertData---"+insertData);

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(
					CommonRepository
							.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),
					SingleTableHandlerHome.class, getLocalEJB());
		Object busObj = (home.getClass().getMethod("create", null)).invoke(
					home, null);
		Object argArray[] = new Object[2];
		argArray[0] = tabData;
		argArray[1] = sqlMap;
		Class[] paramArray = new Class[2];
		paramArray[0] = tabData.getClass();
		paramArray[1] = sqlMap.getClass();

		if (insertData.size() > 0) {
				tabData.put("properties", getProperties());
				tabData.put("InsertData", insertData);
				//sqlMap.put("InsertSQL", sql_insert);
				//sqlMap.put("InsertSQL",PhRepository.getPhKeyValue("SQL_PH_PRES_REMARK_FOR_DRUG_INSERT"));
				String insrtSQL = "INSERT INTO PH_PREGN_CAT_GROUP_HDR(CATEGORY_GROUP_CODE,CATEGORY_GROUP_DESC, EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)VALUES (?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
				
				sqlMap.put("InsertSQL", insrtSQL);
				//System.err.println("tabData---insert----->" + tabData);

				map = (HashMap) (busObj.getClass().getMethod("singleBatchHandler", paramArray)).invoke(busObj,			argArray);
				(busObj.getClass().getMethod("remove", null)).invoke(busObj,
						null);

                  //System.err.println("map---276----->" + map);
      
			}
         
		if (((Boolean) map.get("result")).booleanValue()) {

			int arrListSize = arrListForInsert == null ? 0:arrListForInsert.size();
			if (arrListSize > 0)
			{
				tabData.clear();
				sqlMap.clear();

				for (int i=0;i<arrListSize;i+=4 )
				{
					insertRow1 = new ArrayList(); 
					insertRow1.add(arrListForInsert.get(i));
					insertRow1.add(arrListForInsert.get(i+1));
					insertRow1.add(arrListForInsert.get(i+2));
					insertRow1.add(arrListForInsert.get(i+3));
					insertRow1.add(login_by_id);
					insertRow1.add(login_at_ws_no);
					insertRow1.add(login_facility_id);
					insertRow1.add(login_by_id);
					insertRow1.add(login_at_ws_no);
					insertRow1.add(login_facility_id);
					insertData1.add(insertRow1);

				}
				//System.out.println("insertData1---->"+insertData1);
				tabData.put("properties", getProperties());
				tabData.put("InsertData", insertData1);
				String insertSQL1 = "INSERT INTO PH_PREGN_CAT_GROUP_DTL(CATEGORY_GROUP_CODE,CATEGORY_CODE,CATEGORY_DESC, APPLICABLE_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)VALUES (?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";

				//sqlMap.put("InsertSQL",PhRepository											.getPhKeyValue("SQL_PH_PRES_REMARK_FOR_DRUG_UPDATE1"));
				sqlMap.put("InsertSQL",insertSQL1);
				map = (HashMap) (busObj.getClass().getMethod("singleBatchHandler", paramArray)).invoke(busObj,			argArray);
					(busObj.getClass().getMethod("remove", null)).invoke(
							busObj, null);
			}
				
			}
			if (((Boolean) map.get("result")).booleanValue())
				map.put("message", getMessage(getLanguageId(), (String) map
						.get("msgid"), "PH"));
			//map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			else {
				msgId = (String) map.get("msgid") == null ? "" : (String) map
						.get("msgid");
				if ((msgId).equals("CODE_ALREADY_EXISTS")) {
					map.put("message", getMessage(getLanguageId(), (String) map
							.get("msgid"), "Common"));
					String msgID = getMessage((String) map.get("msgid"), false);
					//msgID = msgID.substring(0,(msgID.indexOf("<br>"))) ;
					map.put("message", msgID);
					map.put("invalidCode", delimitedString((ArrayList) map
							.get("invalidCode")));
				} else if (msgId.equals("")) {
					map.put("message", getMessage(getLanguageId(),
							"PH_NO_CHANGE", "PH"));
				}else
					map.put("message", (map.get("msgid")));
			}




		}catch (Exception e) {
			e.printStackTrace();
		}
        //System.err.println("map---343->"+map);
        return map ;
 

    }
    // insert method ends here...


 // modify method  starts here...
public HashMap modify() {
        HashMap map = new HashMap() ;
		HashMap tabData = new HashMap();
		HashMap sqlMap = new HashMap();
        //map.put( "result", new Boolean( false ) ) ;
		map.put("result", new Boolean(false));
		map.put("flag", "0");
      
        ArrayList insertData = new ArrayList() ;
        ArrayList modifyData = new ArrayList() ;
        ArrayList modifyData1 = new ArrayList() ;
     // 	ArrayList whereData = new ArrayList() ;  Removed for IN063877
        ArrayList insertRow = null;
        ArrayList modifyRow = null;
        ArrayList modifyRow1 = null;
    
		// ArrayList whereObjects = null;  Removed for IN063877

		String msgId = "";

		try{ 
		//inserting newly added category lines starts here
		//System.out.println("arrListForInsert in modify()@@@@>"+arrListForInsert);
		int arrListSize = arrListForInsert == null ? 0:arrListForInsert.size();
			for (int i=0;i<arrListSize;i+=4 )
				{
					insertRow = new ArrayList(); 
					insertRow.add(arrListForInsert.get(i));
					insertRow.add(arrListForInsert.get(i+1));
					insertRow.add(arrListForInsert.get(i+2));
					insertRow.add(arrListForInsert.get(i+3));
					insertRow.add(login_by_id);
					insertRow.add(login_at_ws_no);
					insertRow.add(login_facility_id);
					insertRow.add(login_by_id);
					insertRow.add(login_at_ws_no);
					insertRow.add(login_facility_id);
					insertData.add(insertRow);

				}

		map.put("result", new Boolean(true));
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(
					CommonRepository
							.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),
					SingleTableHandlerHome.class, getLocalEJB());
		Object busObj = (home.getClass().getMethod("create", null)).invoke(
					home, null);
		Object argArray[] = new Object[2];
		argArray[0] = tabData;
		argArray[1] = sqlMap;
		Class[] paramArray = new Class[2];
		paramArray[0] = tabData.getClass();
		paramArray[1] = sqlMap.getClass();

		if (insertData.size() > 0) {
				tabData.put("properties", getProperties());
				tabData.put("InsertData", insertData);
				//sqlMap.put("InsertSQL", sql_insert);
				//sqlMap.put("InsertSQL",PhRepository.getPhKeyValue("SQL_PH_PRES_REMARK_FOR_DRUG_INSERT"));
				String insrtSQL = "INSERT INTO PH_PREGN_CAT_GROUP_DTL(CATEGORY_GROUP_CODE,CATEGORY_CODE,CATEGORY_DESC, APPLICABLE_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)VALUES (?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
				
				sqlMap.put("InsertSQL", insrtSQL);
				//System.err.println("tabData---insert@modify()----->" + tabData);

				map = (HashMap) (busObj.getClass().getMethod(
						"singleBatchHandler", paramArray)).invoke(busObj,
						argArray);
				(busObj.getClass().getMethod("remove", null)).invoke(busObj,
						null);
			}
        //inserting newly added category lines ends here..
		if (((Boolean) map.get("result")).booleanValue()) {
				//System.out.println("arrayListForCategoryUpdate in modify()@@@@>"+arrListForCategoryUpdate);
			int categoryGroupUpdateSize = arrListForCategoryUpdate == null ? 0:arrListForCategoryUpdate.size();
			if (categoryGroupUpdateSize > 0)
			{
				tabData.clear();
				sqlMap.clear();

				for (int i=0;i<categoryGroupUpdateSize;i+=3 )
				{
					modifyRow = new ArrayList(); 
					modifyRow.add(arrListForCategoryUpdate.get(i+1));
					modifyRow.add(arrListForCategoryUpdate.get(i+2));
					modifyRow.add(login_by_id);
					modifyRow.add(login_at_ws_no);
					modifyRow.add(login_facility_id);
					modifyRow.add(arrListForCategoryUpdate.get(i));
					modifyData.add(modifyRow);

				}
				//System.out.println("modifyData---->"+modifyData);
				tabData.put("properties", getProperties());
				tabData.put("ModifyData", modifyData);
				String modifySQL1 = "UPDATE PH_PREGN_CAT_GROUP_HDR SET CATEGORY_GROUP_DESC= ?, EFF_STATUS= ?, MODIFIED_BY_ID= ?, MODIFIED_DATE= SYSDATE, MODIFIED_AT_WS_NO= ?,MODIFIED_FACILITY_ID= ? WHERE CATEGORY_GROUP_CODE = ? ";

				//sqlMap.put("InsertSQL",PhRepository											.getPhKeyValue("SQL_PH_PRES_REMARK_FOR_DRUG_UPDATE1"));
				sqlMap.put("ModifySQL",modifySQL1);
				map = (HashMap) (busObj.getClass().getMethod(
							"singleBatchHandler", paramArray)).invoke(busObj,
							argArray);
					(busObj.getClass().getMethod("remove", null)).invoke(
							busObj, null);
			
				

			}
		}
		if (((Boolean) map.get("result")).booleanValue()) {
				//System.out.println("arrayListForUpdatelines in modify()@@@@>"+arrListForUpdate);
			int categoryUpdateSize = arrListForUpdate == null ? 0:arrListForUpdate.size();
			if (categoryUpdateSize > 0)
			{
				tabData.clear();
				sqlMap.clear();

				for (int i=0;i<categoryUpdateSize;i+=4 )
				{
					modifyRow1 = new ArrayList(); 
					modifyRow1.add(arrListForUpdate.get(i+2));
					modifyRow1.add(arrListForUpdate.get(i+3));
					modifyRow1.add(login_by_id);
					modifyRow1.add(login_at_ws_no);
					modifyRow1.add(login_facility_id);
					modifyRow1.add(arrListForUpdate.get(i));
					modifyRow1.add(arrListForUpdate.get(i+1));
					modifyData1.add(modifyRow1);

				}
				//System.out.println("modifyData1--->"+modifyData1);
				tabData.put("properties", getProperties());
				tabData.put("ModifyData", modifyData1);
				String modifySQL2 = "UPDATE PH_PREGN_CAT_GROUP_DTL SET CATEGORY_DESC= ?, APPLICABLE_YN= ?, MODIFIED_BY_ID= ?, MODIFIED_DATE= SYSDATE, MODIFIED_AT_WS_NO= ?,MODIFIED_FACILITY_ID= ? WHERE CATEGORY_GROUP_CODE = ? AND CATEGORY_CODE = ?";

				//sqlMap.put("InsertSQL",PhRepository											.getPhKeyValue("SQL_PH_PRES_REMARK_FOR_DRUG_UPDATE1"));
				sqlMap.put("ModifySQL",modifySQL2);
				map = (HashMap) (busObj.getClass().getMethod(
							"singleBatchHandler", paramArray)).invoke(busObj,
							argArray);
					(busObj.getClass().getMethod("remove", null)).invoke(
							busObj, null);
			
				

			}
		}
			if (((Boolean) map.get("result")).booleanValue())
				map.put("message", getMessage(getLanguageId(), (String) map
						.get("msgid"), "PH"));
			//map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			else {
				msgId = (String) map.get("msgid") == null ? "" : (String) map
						.get("msgid");
				if ((msgId).equals("CODE_ALREADY_EXISTS")) {
					map.put("message", getMessage(getLanguageId(), (String) map
							.get("msgid"), "Common"));
					String msgID = getMessage((String) map.get("msgid"), false);
					//msgID = msgID.substring(0,(msgID.indexOf("<br>"))) ;
					map.put("message", msgID);
					map.put("invalidCode", delimitedString((ArrayList) map
							.get("invalidCode")));
				} else if (msgId.equals("")) {
					map.put("message", getMessage(getLanguageId(),
							"PH_NO_CHANGE", "PH"));
				}else
					map.put("message", (map.get("msgid")));
			}




		}catch (Exception e) {
			e.printStackTrace();
		}
        return map ;

    }
    // modify method ends here...

	public int  serachForCGCode(String cGrpCode){
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null ;
		int count = 0;
        try {
            connection = getConnection() ;
            String qryString = "SELECT COUNT(*) count FROM PH_PREGN_CAT_GROUP_HDR WHERE CATEGORY_GROUP_CODE = ?";
            pstmt = connection.prepareStatement( qryString ) ;
            pstmt.setString(1,cGrpCode.trim());
            resultSet = pstmt.executeQuery() ;
            if ( resultSet != null && resultSet.next() ) {
              count = Integer.parseInt(resultSet.getString("count"));
            }
        }
        catch ( Exception e ) {
            e.printStackTrace() ;            
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) { 
			es.printStackTrace();
			}
        }
		return count;
	}
public ArrayList  getPregnancyCategoryInfo(String cGrpCode,String locale){
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null ;
		ArrayList categoryGroupList = new ArrayList();
	//	int count = 0;  Removed for IN063877
        try {
            connection = getConnection() ;
            String qryString = "SELECT CATEGORY_GROUP_DESC,EFF_STATUS FROM PH_PREGN_CAT_GROUP_HDR_LANG_VW WHERE CATEGORY_GROUP_CODE = ? AND LANGUAGE_ID = ?";
            pstmt = connection.prepareStatement( qryString ) ;
            pstmt.setString(1,cGrpCode.trim());
            pstmt.setString(2,locale);
            resultSet = pstmt.executeQuery() ;
            if ( resultSet != null && resultSet.next() ) {
            categoryGroupList.add(resultSet.getString("CATEGORY_GROUP_DESC"));
            categoryGroupList.add(resultSet.getString("EFF_STATUS"));			
            }
        }
        catch ( Exception e ) {
            e.printStackTrace() ;            
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) { 
			es.printStackTrace();
			}
        }
		return categoryGroupList;
		
	}

	public ArrayList   getCategoryList(String cGrpCode,String locale){
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null ;
		ArrayList categoryList = new ArrayList();
		//int count = 0;  Removed for IN063877
        try {
            connection = getConnection() ;
            String qryString = "SELECT B.CATEGORY_CODE,B.CATEGORY_DESC,B.APPLICABLE_YN FROM PH_PREGN_CAT_GROUP_HDR A, PH_PREGN_CAT_GROUP_DTL_LANG_VW B WHERE  A.CATEGORY_GROUP_CODE = B.CATEGORY_GROUP_CODE AND  A.CATEGORY_GROUP_CODE = ? AND B.LANGUAGE_ID = ? ";
            pstmt = connection.prepareStatement( qryString ) ;
            pstmt.setString(1,cGrpCode.trim());
            pstmt.setString(2,locale);
            resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
             categoryList.add(resultSet.getString("CATEGORY_CODE"));
             categoryList.add(resultSet.getString("CATEGORY_DESC"));
             categoryList.add(resultSet.getString("APPLICABLE_YN"));
            }
        }
        catch ( Exception e ) {
            e.printStackTrace() ;            
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) { 
			es.printStackTrace();
			}
        }
		return categoryList;
		
	}
//to retrieve the pregnancy remarks
	public HashMap   getPregnancyRemarks(String patient_id){
		Connection connection = null ;
		PreparedStatement pstmt = null ;
        ResultSet resultSet = null ;
		HashMap maternityDetailsMap = new HashMap();
		String eddValue ="";
		String gestationValue ="";
		String lmpValue ="";
		String asOnDateValue ="";
	//	int count = 0;  Removed for IN063877
        try {
            connection = getConnection() ;
			//System.out.println("@@@@patient_id>>>>>"+patient_id);
            String qryString = "SELECT DISCR_MSR_VALUE EDD FROM CA_PAT_SPLTY_KEY_MSR A WHERE PATIENT_ID =? AND MODULE_ID='MC' AND DISCR_MSR_ID='MC01EDD'AND ADDED_DATE=(SELECT MAX(ADDED_DATE) FROM CA_PAT_SPLTY_KEY_MSR WHERE PATIENT_ID =A.PATIENT_ID AND MODULE_ID=A.MODULE_ID AND  DISCR_MSR_ID=A.DISCR_MSR_ID) AND ROWNUM=1 ";
            pstmt = connection.prepareStatement( qryString ) ; 
			pstmt.setString(1,patient_id);
            resultSet = pstmt.executeQuery() ;
            if ( resultSet != null && resultSet.next() ) {
			 eddValue = resultSet.getString("EDD")==null?"":resultSet.getString("EDD");
            }
			//System.out.println("EDD----"+eddValue);
			if (resultSet != null)
			{
			closeResultSet( resultSet ) ;
			}
			if (pstmt != null)
			{
			closeStatement( pstmt ) ;
			}
			String qryString1 = "SELECT DISCR_MSR_VALUE GESTATION FROM CA_PAT_SPLTY_KEY_MSR A WHERE PATIENT_ID =? AND MODULE_ID='MC' AND DISCR_MSR_ID='MC01GESTNAGE' AND ADDED_DATE=(SELECT MAX(ADDED_DATE) FROM CA_PAT_SPLTY_KEY_MSR WHERE PATIENT_ID =A.PATIENT_ID AND MODULE_ID=A.MODULE_ID AND DISCR_MSR_ID=A.DISCR_MSR_ID) AND ROWNUM=1";
			pstmt = connection.prepareStatement( qryString1 ) ; 
			pstmt.setString(1,patient_id);
            resultSet = pstmt.executeQuery() ;
            if ( resultSet != null && resultSet.next() ) {
			gestationValue = resultSet.getString("GESTATION")==null?"":resultSet.getString("GESTATION");
            }
			//System.out.println("gestation value----"+gestationValue);
			if (resultSet != null)
			{
			closeResultSet( resultSet ) ;
			}
			if (pstmt != null)
			{
			closeStatement( pstmt ) ;
			}
			String qryString2 = "SELECT DISCR_MSR_VALUE LMP FROM CA_PAT_SPLTY_KEY_MSR A WHERE PATIENT_ID =? AND MODULE_ID='MC' AND DISCR_MSR_ID='MC01LMP' AND ADDED_DATE=(SELECT MAX(ADDED_DATE) FROM CA_PAT_SPLTY_KEY_MSR WHERE PATIENT_ID =A.PATIENT_ID AND MODULE_ID=A.MODULE_ID AND DISCR_MSR_ID=A.DISCR_MSR_ID) AND ROWNUM=1";
			pstmt = connection.prepareStatement( qryString2 ) ; 
			pstmt.setString(1,patient_id);
            resultSet = pstmt.executeQuery() ;
            if ( resultSet != null && resultSet.next() ) {
			 lmpValue = resultSet.getString("LMP")==null?"":resultSet.getString("LMP");
			 
            }
			//lmpValue = "LMP";
			//System.out.println("lmp value----"+lmpValue);
			if (resultSet != null)
			{
			closeResultSet( resultSet ) ;
			}
			if (pstmt != null)
			{
			closeStatement( pstmt ) ;
			}

			String qryString3 = "SELECT to_char(MAX(ADDED_DATE),'dd/mm/yyyy') ASONDATE FROM CA_PAT_SPLTY_KEY_MSR WHERE PATIENT_ID =? AND MODULE_ID='MC' AND DISCR_MSR_ID In ('MC01GESTNAGE','MC01LMP','MC01EDD')";
			pstmt = connection.prepareStatement( qryString3 ) ; 
			pstmt.setString(1,patient_id);
			resultSet = pstmt.executeQuery() ;
            if ( resultSet != null && resultSet.next() ) {
			 asOnDateValue = resultSet.getString("ASONDATE")==null?"":resultSet.getString("ASONDATE");			 
            }
			maternityDetailsMap.put("EDD",eddValue);
			maternityDetailsMap.put("GESTATION",gestationValue);
			maternityDetailsMap.put("LMP",lmpValue);
			maternityDetailsMap.put("ASONDATE",asOnDateValue);
        }
        catch ( Exception e ) {
            e.printStackTrace() ;            
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) { 
			es.printStackTrace();
			}
        }
		//System.out.println("@@@@maternityDetailsMap-->"+maternityDetailsMap);
		return maternityDetailsMap;
		
	}

	 
}
