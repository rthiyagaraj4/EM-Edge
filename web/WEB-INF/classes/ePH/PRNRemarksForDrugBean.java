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



public class PRNRemarksForDrugBean extends PhAdapter implements Serializable {

	private String drug_code = "";
	//private String mode = ""; //Commented for common-icn-0048
	ArrayList remarks_list = new ArrayList();
	ArrayList list = new ArrayList();
	int list_size = 0;
	int listRows = 0;


    public PRNRemarksForDrugBean() {
        try {
            doCommon();
        }
        catch(Exception e) {
		e.printStackTrace();
		}
    }


 public void setDrugCode(String drug_code){
	 this.drug_code = drug_code;
	}

	public String getDrugCode(){
	  return drug_code;
	}
	
	 public void setListRows(int listRows){
	 this.listRows = listRows;
	}

	public int getListRows(){
	  return listRows;
	}
	
	public void setRemarksList(ArrayList remarks_list) {
		this.remarks_list = remarks_list;
	}

	public ArrayList getRemarksList() {
		return this.remarks_list;
	}

	public void setList(ArrayList list) {
		this.list = list;
	}

	public ArrayList getList() {
		return this.list;
	}
    /* Over-ridden Adapter methods start here */
   

    private void doCommon() throws Exception {
    }

    /* Over-ridden Adapter methods end here */
    

     public void setAll( Hashtable recordSet ){
       
      
		if(recordSet.containsKey("mode"))
           setMode(recordSet.get("mode").toString());

		if(recordSet.containsKey("h_list_rows"))
            list_size  = Integer.parseInt(recordSet.get("h_list_rows").toString());
	

     }

	  public void clear() {
        super.clear() ;
		//ArrayList remarks_list = null; //Commented for common-icn-0048
    }
   


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
		//ArrayList whereData = new ArrayList() ; //Commented for common-icn-0048
        ArrayList insertRow = null;       
		//ArrayList whereObjects = null; //Commented for common-icn-0048
		String msgId = "";

		try{
		ArrayList list = getList();
	    for (int i=0;i<list.size() ;i+=4 )
		{
			if (list.get(i+2).toString().equals("Y"))
			{
				        updateRemarksList();
						break;
			}
		}
		deleteRemarksList();
		ArrayList remarks_insert_list = getRemarksList();        
		for(int i=0;i<remarks_insert_list.size();i+=3){
		  insertRow = new ArrayList();
		  if (remarks_insert_list.get(i+2).toString().equals("Y"))
		  {
		  insertRow.add(getDrugCode());//drug_code
		  insertRow.add(remarks_insert_list.get(i));//remarks_code
		  insertRow.add(remarks_insert_list.get(i+1));//default_select
		  insertRow.add(login_by_id);
		  insertRow.add(login_at_ws_no);
		  insertRow.add(login_facility_id);
		  insertRow.add(login_by_id);
		  insertRow.add(login_at_ws_no);
		  insertRow.add(login_facility_id);
          insertData.add(insertRow);
		  }
		  
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
				String insrtSQL = "INSERT INTO PH_PRN_REMARK_FOR_DRUG(DRUG_CODE,REASON_CODE,DEFAULT_REASON_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)VALUES (?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
				
				sqlMap.put("InsertSQL", insrtSQL);
				//System.err.println("tabData---insert----->" + tabData);

				map = (HashMap) (busObj.getClass().getMethod("singleBatchHandler", paramArray)).invoke(busObj,			argArray);
				(busObj.getClass().getMethod("remove", null)).invoke(busObj,
						null);

                   
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
			System.err.println("Exception raised while inserting the values ==="+e);
			e.printStackTrace();
		}
        
        return map ;
 

    }
    // insert method ends here...


 // modify method  starts here...
public HashMap modify() {
		// updateRemarksList();
		// deleteRemarksList();
		 HashMap map = new HashMap() ;
		 HashMap tabData = new HashMap();
		HashMap sqlMap = new HashMap();
        //map.put( "result", new Boolean( false ) ) ;
		map.put("result", new Boolean(false));
		map.put("flag", "0");
      
        ArrayList insertData = new ArrayList() ;
        //ArrayList modifyData = new ArrayList() ; //Commented for common-icn-0048
       // ArrayList modifyData1 = new ArrayList() ; //Commented for common-icn-0048
      	//ArrayList whereData = new ArrayList() ; //Commented for common-icn-0048
        ArrayList insertRow = null;
           
		//ArrayList whereObjects = null; //Commented for common-icn-0048

		String msgId = "";

		try{ 
				ArrayList list = getList();
				for (int i=0;i<list.size() ;i+=4 )
				{
					if (list.get(i+2).toString().equals("Y"))
					{
								updateRemarksList();
								break;
					}
				}
				deleteRemarksList();
			 ArrayList remarks_insert_list = getRemarksList();        
			 for(int i=0;i<remarks_insert_list.size();i+=3){
			  insertRow = new ArrayList();
			  if (remarks_insert_list.get(i+2).toString().equals("Y"))
			  {
			  insertRow.add(getDrugCode());//drug_code
			  insertRow.add(remarks_insert_list.get(i));//remarks_code
			  insertRow.add(remarks_insert_list.get(i+1));//default_select
			  insertRow.add(login_by_id);
			  insertRow.add(login_at_ws_no);
			  insertRow.add(login_facility_id);
			  insertRow.add(login_by_id);
			  insertRow.add(login_at_ws_no);
			  insertRow.add(login_facility_id);
			  insertData.add(insertRow);
			  }
			  
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
				String insrtSQL = "INSERT INTO PH_PRN_REMARK_FOR_DRUG(DRUG_CODE,REASON_CODE,DEFAULT_REASON_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)VALUES (?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
				
				sqlMap.put("InsertSQL", insrtSQL);
				

				map = (HashMap) (busObj.getClass().getMethod(
						"singleBatchHandler", paramArray)).invoke(busObj,
						argArray);
				(busObj.getClass().getMethod("remove", null)).invoke(busObj,
						null);
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
			System.err.println("Exception raised while inserting the values ==="+e);
			e.printStackTrace();
		}
        return map ;

    }
    // modify method ends here...

	public ArrayList  loadPRNRemarksResult(String PRNSearchText,String drug_code,String locale){
		Connection connection	= null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet		= null ;
		

		String qryString1 		= "SELECT A.REASON_CODE, REASON_DESC, DEFAULT_REASON_YN, 'Y' REMARKS   FROM PH_PRN_REMARK_FOR_DRUG A, PH_MEDN_TRN_REASON_LANG_VW B   WHERE A.DRUG_CODE = ?  AND A.REASON_CODE = B.REASON_CODE    AND B.APPL_TRN_TYPE = 'PR' AND B.LANGUAGE_ID = ? AND UPPER(B.REASON_DESC) LIKE UPPER(?) and B.EFF_STATUS = 'E'  UNION SELECT REASON_CODE, REASON_DESC, 'N' DEFAULT_REASON_YN,'N' REMARKS   FROM PH_MEDN_TRN_REASON_LANG_VW  WHERE APPL_TRN_TYPE = 'PR' AND UPPER(REASON_DESC) LIKE UPPER(?) AND LANGUAGE_ID = ? AND REASON_CODE NOT IN(SELECT A.REASON_CODE   FROM PH_PRN_REMARK_FOR_DRUG A, PH_MEDN_TRN_REASON_LANG_VW B  WHERE A.DRUG_CODE = ? AND A.REASON_CODE = B.REASON_CODE    AND B.APPL_TRN_TYPE = 'PR' AND B.LANGUAGE_ID = ? ) AND EFF_STATUS = 'E'";


		String qryString2		= "SELECT REASON_CODE, REASON_DESC,'N' DEFAULT_REASON_YN, 'N' REMARKS  FROM PH_MEDN_TRN_REASON_LANG_VW WHERE APPL_TRN_TYPE ='PR' AND UPPER(REASON_DESC) LIKE UPPER(?) AND LANGUAGE_ID = ? AND EFF_STATUS = 'E'";

		int count				=	0;
		
		
		ArrayList remarks_list	= null;
        try {
			remarks_list = new ArrayList();
            connection = getConnection() ;
            pstmt = connection.prepareStatement( qryString1 ) ;
            pstmt.setString(1,drug_code.trim());
            pstmt.setString(2,locale);
            pstmt.setString(3,PRNSearchText.trim());
            pstmt.setString(4,PRNSearchText.trim());
            pstmt.setString(5,locale);
			pstmt.setString(6,drug_code.trim());
			pstmt.setString(7,locale);
            resultSet = pstmt.executeQuery() ;
			//System.out.println("qryString1=="+qryString1);
			//System.out.println("drug_code=="+drug_code+"==locale=="+locale+"PRNSearchText="+PRNSearchText.trim()+"==locale=="+locale+"==drug_code=="+drug_code+"==locale=="+locale);
			
            while ( resultSet != null && resultSet.next() ) {
              count =1;
			  remarks_list.add(resultSet.getString("REASON_CODE"));
			  remarks_list.add(resultSet.getString("REASON_DESC"));
			  remarks_list.add(resultSet.getString("DEFAULT_REASON_YN"));	
			  remarks_list.add(resultSet.getString("REMARKS"));	
            }
			if (count == 0)
			{
				closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
				pstmt = connection.prepareStatement( qryString2 ) ;
				pstmt.setString(1,PRNSearchText.trim());
				pstmt.setString(2,locale);
			    resultSet = pstmt.executeQuery() ;

			  while ( resultSet != null && resultSet.next() ) {             
				  remarks_list.add(resultSet.getString("REASON_CODE"));
				  remarks_list.add(resultSet.getString("REASON_DESC"));
				  remarks_list.add(resultSet.getString("DEFAULT_REASON_YN"));	
				  remarks_list.add(resultSet.getString("REMARKS"));	
				}			
				
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
		return remarks_list;
	}

	public void deleteRemarksList(){
		ArrayList list						= getList();
		ArrayList remarks_list				= new ArrayList();
		for (int i=0;i<list.size();i+=4 )
		{
			remarks_list.add(list.get(i).toString());
			remarks_list.add(list.get(i+2).toString());
			remarks_list.add(list.get(i+3).toString());
		}
		setRemarksList(remarks_list);
		
		Connection connection		= null ;
        PreparedStatement pstmt		= null ;
		PreparedStatement pstmt1	= null ;
        ResultSet resultSet			= null ;
		String drug_code			= getDrugCode();
		String qryString1 			= "select count(drug_code) from ph_prn_remark_for_drug where drug_code = ? and reason_code =?";
		String qryString2			= "delete from  ph_prn_remark_for_drug where drug_code =? and reason_code =?";
		int count					= 0;
		
        try {

            connection = getConnection() ;
            pstmt = connection.prepareStatement( qryString1 ) ;
			for (int i=0;i<remarks_list.size();i+=3 )
			{
				pstmt.setString(1,drug_code.trim());
				pstmt.setString(2,remarks_list.get(i).toString());
				resultSet = pstmt.executeQuery() ;
				if ( resultSet != null && resultSet.next() ) {
				   pstmt1 = connection.prepareStatement( qryString2) ;
				   pstmt1.setString(1,drug_code.trim());
				   pstmt1.setString(2,remarks_list.get(i).toString());
				   count = pstmt1.executeUpdate();				
				   closeStatement( pstmt1 ) ;

				}
				closeResultSet( resultSet ) ;//3/21/2021
			}       
          	
        }
        catch ( Exception e ) {
			System.err.println("Exception occured while deleting records ......");
            e.printStackTrace() ;            
        }
        finally {
            try {
				connection.commit();
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) { 
			es.printStackTrace();
			}
        }

	}

	public void updateRemarksList(){
		

		Connection connection		= null ;
        PreparedStatement pstmt		= null ;
		
		
		String qryString1 			= "update ph_prn_remark_for_drug set DEFAULT_REASON_YN='N' where drug_code =?";
		int count					= 0;
		
        try {

            connection = getConnection() ;
            pstmt = connection.prepareStatement( qryString1 ) ;
			pstmt.setString(1,getDrugCode().trim());
			count = pstmt.executeUpdate() ;			       
          	
        }
        catch ( Exception e ) {
			System.err.println("Exception occured while updating the records in PH_PRN_REMARK_FOR_DRUG table ......");
            e.printStackTrace() ;            
        }
        finally {
            try {
				connection.commit();
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) { 
			es.printStackTrace();
			}
        }	

			

	}


	 
}
