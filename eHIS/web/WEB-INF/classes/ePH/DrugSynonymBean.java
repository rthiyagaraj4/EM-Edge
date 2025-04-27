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
import eCommon.SingleTableHandler.*;

//saved on 27/10/2005

public class DrugSynonymBean extends PhAdapter implements Serializable {
	java.util.ArrayList alForInsert=null;
	protected String drug_code="";
	protected String drug_synonym_type="";
	protected int srl_no=1;
	protected String synonym_type_code="";
	protected String drug_synonym_desc="";
	protected String eff_status="";
	protected String fieldCheck="";
	protected ArrayList alDrugListForSynonym;
	protected ArrayList alSynonymsForDrug;

	public DrugSynonymBean() {
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
	public void setDrugCode( String drug_code ) {
		this.drug_code = drug_code  ;
	}
	public void setDrugSynonymType( String drug_synonym_type ) {
		this.drug_synonym_type = drug_synonym_type  ;
	}
	public void setSrlNo(int srl_no) {
		this.srl_no=srl_no;
	}
	public void setSynonymTypeCode(String synonym_type_code) {
		this.synonym_type_code=synonym_type_code;
	}
	public void setDrugSynonymDesc(String drug_synonym_desc) {
		this.drug_synonym_desc=drug_synonym_desc;
	}
	public void setDrugListForSynonym(ArrayList alDrugListForSynonym) {
		this.alDrugListForSynonym=alDrugListForSynonym;
	}
	public void setSynonymsForDrug(ArrayList alSynonymsForDrug) {
		this.alSynonymsForDrug=alSynonymsForDrug;
	}
	public void setEffStatus(String eff_status){
		if(eff_status.equals("") || eff_status==null )
			this.eff_status = "D" ;
		else
			this.eff_status = eff_status ;
	}
	// set methods end

	// get methods start here

	public String getDrugCode() {
		return this.drug_code  ;
	}
	public String getDrugSynonymType() {
		return this.drug_synonym_type  ;
	}
	public int getSrlNo() {
		return this.srl_no;
	}
	public String getSynonymTypeCode() {
		return this.synonym_type_code;
	}
	public String getDrugSynonymDesc() {
		return this.drug_synonym_desc;
	}
	public ArrayList getDrugListForSynonym( ) {
		return this.alDrugListForSynonym;
	}
	public ArrayList getSynonymsForDrug( ) {
		return this.alSynonymsForDrug;
	}
	public String getEffStatus(){
		return this.eff_status;
	}
    // get methods end here

    public void setAll( Hashtable recordSet ){

        if(recordSet.containsKey("mode"))
            setMode((String)recordSet.get("mode")) ;
        String action = getMode();
		String  effStatusCheck,stotalRecords="";
		int totRec = 10;

        alForInsert=new ArrayList();

        if (action.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
			System.err.println("INSIDE IFF");
            if (recordSet.containsKey("totalRecords")) {
                stotalRecords = (String)recordSet.get("totalRecords");
            }
			if(stotalRecords!=null && !stotalRecords.equals("")&& !stotalRecords.equals("0"))
				totRec = Integer.parseInt(stotalRecords);

            for (int i=0;i<totRec;i++ ) {
                effStatusCheck="";
				if (recordSet.containsKey("EffStatus"+i)){
					effStatusCheck=(String)recordSet.get("EffStatus"+i);
					if (effStatusCheck.equals("") || effStatusCheck==null){
						effStatusCheck="D";
					}
                    if (effStatusCheck.equals("E")){
                       if(recordSet.containsKey("DrugCode_"+i))
                            alForInsert.add((String)recordSet.get("DrugCode_"+i)) ;
                        if (recordSet.containsKey("DrugSynonymType_"+i))
                            alForInsert.add((String)recordSet.get("DrugSynonymType_"+i)) ;
						if(recordSet.containsKey("SynonymTypeCode_"+i))
                            alForInsert.add((String)recordSet.get("SynonymTypeCode_"+i)) ;
                        if (recordSet.containsKey("DrugSynonymDesc_"+i))
                            alForInsert.add((String)recordSet.get("DrugSynonymDesc_"+i)) ;
						alForInsert.add(effStatusCheck) ;
                    }
                }
            }
        }
		else{
			effStatusCheck="";
		   if(recordSet.containsKey("DrugCode"))
				alForInsert.add((String)recordSet.get("DrugCode")) ;
			if (recordSet.containsKey("DrugSynonymType"))
				alForInsert.add((String)recordSet.get("DrugSynonymType")) ;
			if(recordSet.containsKey("SrlNo"))
				alForInsert.add((String)recordSet.get("SrlNo")) ;
			if (recordSet.containsKey("DrugSynonymDesc"))
				alForInsert.add((String)recordSet.get("DrugSynonymDesc")) ;
			if (recordSet.containsKey("EffStatus")){
				effStatusCheck = (String)recordSet.get("EffStatus");
			}
			if(effStatusCheck==null || effStatusCheck.equals(""))
				effStatusCheck="D";
			alForInsert.add(effStatusCheck) ;
		}
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
        map.put( "result", new Boolean( false ) ) ;
        map.put( "message", "Insert Failed::Under Construction......."+alForInsert) ;

        ArrayList insertData = new ArrayList() ;
        ArrayList whereData = new ArrayList() ;
        ArrayList insertObjects = null;
        ArrayList whereObjects = null;
		String  drug_code; // sSrl_no,  Removed for IN063877
		int iSrl_no=0;
		HashMap tabData = new HashMap() ;
		String SelectSQL = "SELECT COUNT(ROWID) FROM PH_DRUG_SYNONYM WHERE DRUG_CODE = UPPER(?) AND DRUG_SYNONYM_TYPE=UPPER(?) AND(SYNONYM_TYPE_CODE=UPPER(?) AND DRUG_SYNONYM_DESC = ?)";
		String InsertSQL = "INSERT INTO PH_DRUG_SYNONYM (DRUG_CODE, DRUG_SYNONYM_TYPE, SRL_NO, SYNONYM_TYPE_CODE,DRUG_SYNONYM_DESC,EFF_STATUS, ADDED_DATE, ADDED_BY_ID, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_DATE, MODIFIED_BY_ID, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID ) VALUES (?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)";
        try{

			insertObjects=new ArrayList();
			whereObjects=new ArrayList();
			HashMap hmDrugCodeMaxSrlNo = getDrugCodeMaxSrlNo(alForInsert);
			for (int i=0;i<alForInsert.size() ;i+=5 ) {
				insertObjects=new ArrayList();
				whereObjects=new ArrayList();
				drug_code = (String)alForInsert.get(i);
				iSrl_no = Integer.parseInt(((String)hmDrugCodeMaxSrlNo.get(drug_code)));
				insertObjects.add(alForInsert.get(i));	//Drug_code
				insertObjects.add(alForInsert.get(i+1)); //drug_synonym_type
				insertObjects.add(iSrl_no++); //srl_no
				insertObjects.add(alForInsert.get(i+2)); //synonym_type_code
				insertObjects.add(alForInsert.get(i+3)); //drug_synonym_desc
				insertObjects.add("E"); //eff_status
				//insertObjects.add(alForInsert.get(i+4)); //eff_status
				insertObjects.add(login_by_id);
				insertObjects.add(login_at_ws_no);
				insertObjects.add(login_facility_id);
				insertObjects.add(login_by_id);
				insertObjects.add(login_at_ws_no);
				insertObjects.add(login_facility_id);
				whereObjects.add(alForInsert.get(i));
				whereObjects.add(alForInsert.get(i+1));
				whereObjects.add(alForInsert.get(i+2));
				whereObjects.add(alForInsert.get(i+3));
				hmDrugCodeMaxSrlNo.put(drug_code,iSrl_no+"");

				insertData.add(insertObjects);
				whereData.add(whereObjects);
			}
			tabData.put( "properties", getProperties() );
			tabData.put( "InsertData",insertData);
			tabData.put( "WhereData",whereData);

			HashMap sqlMap = new HashMap() ;
			sqlMap.put( "SelectSQL", SelectSQL);// PhRepository.getPhKeyValue("SQL_PH_FORM_SELECT3") );
			sqlMap.put( "InsertSQL", InsertSQL);//PhRepository.getPhKeyValue("SQL_PH_FORM_INSERT") );
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
			System.err.println("Error While Inserting tabData"+tabData);
			System.err.println("Error While Inserting map"+map);
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
			System.err.println("Error While Inserting tabData"+tabData);
        } 
        map.put( "flag" , insertData.toString());
        return map ;
    }
    // insert method ends here...
    public HashMap modify() {
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( false ) ) ;
        map.put( "message", "Insert Failed::Under Construction......."+alForInsert) ;

        ArrayList modifyData = new ArrayList() ;
		//String sSrl_no, drug_code;  Removed for IN063877
		String ModifySQL = "update PH_DRUG_SYNONYM set drug_synonym_desc=?, eff_status = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?  where drug_code=? and drug_synonym_type=? and srl_no=?";
		try {
			if(alForInsert.size()>0 ) {
				modifyData.add(alForInsert.get(3)); //drug_synonym_desc
				modifyData.add(alForInsert.get(4)); //eff_status
				modifyData.add(login_by_id);
				modifyData.add(login_at_ws_no);
				modifyData.add(login_facility_id);
				modifyData.add(alForInsert.get(0));	//Drug_code
				modifyData.add(alForInsert.get(1)); //drug_synonym_type
				modifyData.add(alForInsert.get(2)); //srlNo

				HashMap tabData = new HashMap() ;
				tabData.put( "properties", getProperties() );
				tabData.put( "ModifyData",modifyData);

				HashMap sqlMap = new HashMap() ;
				sqlMap.put( "ModifySQL",ModifySQL);
				//sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue("SQL_PH_FORM_UPDATE") );

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
					//map.put( "message", getMessage((String) map.get( "msgid" )) ) ;
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

	private HashMap getDrugCodeMaxSrlNo(ArrayList alInsertRecs){
        Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null ;
		String drug_code;// drug_codes;  Removed for IN063877
		HashMap hmDrugMaxSrlNo = new HashMap();
		StringBuffer sbDrugCodes = new StringBuffer();
		String selectDrugMaxSrlNo = "SELECT DRUG_CODE, MAX(NVL(SRL_NO,0))+1 SRL_NO FROM PH_DRUG_SYNONYM WHERE DRUG_CODE in(?) GROUP BY DRUG_CODE";
		for(int i=0; i<alInsertRecs.size(); i+=5){
			drug_code = (String)alInsertRecs.get(i);
			if(i == (alInsertRecs.size()-5))
				sbDrugCodes.append("'"+drug_code+"'");
			else
				sbDrugCodes.append("'"+drug_code+"',");
			hmDrugMaxSrlNo.put(drug_code, "1");
		}
		int index	 =	selectDrugMaxSrlNo.lastIndexOf('?');
		selectDrugMaxSrlNo = selectDrugMaxSrlNo.substring(0,index)+ sbDrugCodes.toString() +selectDrugMaxSrlNo.substring(index+1);

        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(selectDrugMaxSrlNo) ;
			//pstmt.setString(1,sbDrugCodes.toString());
            resultSet = pstmt.executeQuery() ;
            if ( resultSet != null ) {
				while(resultSet.next()){
					drug_code =resultSet.getString( "DRUG_CODE" );
					hmDrugMaxSrlNo.put(drug_code,resultSet.getInt( "SRL_NO" )+"");
				}
            }
        }
        catch ( Exception e ) {
			System.err.println("Error @getDrugCodeMaxSrlNo alInsertRecs"+alInsertRecs);
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
        return hmDrugMaxSrlNo;
	}
	public ArrayList getSynonymsForDrug(String drug_synonym_type,String drug_code){


		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		ArrayList alSynonymsForDrugT=new ArrayList();
		//String prevnextlink			= "";  Removed for IN063877
		String sSynonymsForDrugSQL="SELECT SYNM.DRUG_CODE, SYNM.SRL_NO,SYNM.DRUG_SYNONYM_TYPE, nvl(SYNMLANG.DRUG_SYNONYM_DESC ,SYNM.DRUG_SYNONYM_DESC) DRUG_SYNONYM_DESC  ,SYNM. EFF_STATUS FROM  PH_DRUG_SYNONYM SYNM,PH_DRUG_SYNONYM_LANG SYNMLANG WHERE SYNMLANG.DRUG_CODE = SYNM.DRUG_CODE AND  SYNMLANG.DRUG_SYNONYM_TYPE=SYNM.DRUG_SYNONYM_TYPE AND SYNMLANG.SRL_NO=SYNM.SRL_NO AND SYNM.DRUG_SYNONYM_TYPE=? AND  SYNM.DRUG_CODE=? AND SYNMLANG.LANGUAGE_ID= ? order by SYNM.DRUG_SYNONYM_TYPE, SYNM.DRUG_SYNONYM_DESC";
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TRN_TYPE_SELECT1") );
			pstmt = connection.prepareStatement( sSynonymsForDrugSQL );
			pstmt.setString(1,drug_synonym_type);
			pstmt.setString(2,drug_code);
			pstmt.setString(3,getLanguageId());
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next() ){
				alSynonymsForDrugT.add(resultSet.getString("DRUG_CODE"));
				alSynonymsForDrugT.add(resultSet.getString("SRL_NO"));
				alSynonymsForDrugT.add(resultSet.getString("DRUG_SYNONYM_TYPE"));//DRUG_SYNONYM_TYPE
				alSynonymsForDrugT.add(resultSet.getString("DRUG_SYNONYM_DESC"));
				alSynonymsForDrugT.add(resultSet.getString("EFF_STATUS"));
			}
		}
		catch ( Exception e ){
			System.err.println( "Error loading values from database drug_synonym_type="+drug_synonym_type+" drug_code="+drug_code ) ;
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es)
			{
				es.printStackTrace();
			}
		}
		setSynonymsForDrug(alSynonymsForDrugT);
		return alSynonymsForDrugT;
	}		
	public ArrayList getDrugListForSynonym(String drug_synonym_type,String synonym_type_code){

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		ArrayList alDrugListForSynonym=new ArrayList();
		//String prevnextlink			= "";  Removed for IN063877
		String sDrugsForSynonymSQL="SELECT SYNM.DRUG_CODE, DRG.DRUG_DESC, SYNM.DRUG_SYNONYM_TYPE, nvl(SYNMLANG.DRUG_SYNONYM_DESC ,SYNM.DRUG_SYNONYM_DESC) DRUG_SYNONYM_DESC,SYNM. EFF_STATUS FROM  PH_DRUG_SYNONYM SYNM,PH_DRUG_SYNONYM_LANG SYNMLANG, PH_DRUG_VW_LANG_VW DRG WHERE SYNMLANG.DRUG_CODE = SYNM.DRUG_CODE AND  SYNMLANG.DRUG_SYNONYM_TYPE=SYNM.DRUG_SYNONYM_TYPE AND SYNMLANG.SRL_NO=SYNM.SRL_NO AND SYNM.DRUG_SYNONYM_TYPE=? AND SYNM.DRUG_CODE=DRG.DRUG_CODE AND  UPPER(SYNM.DRUG_SYNONYM_DESC) like UPPER(?) AND SYNMLANG.LANGUAGE_ID= ?  AND LANG1 =  ? AND DECODE(LANG2,NULL, ?,LANG2)=  ? AND  DECODE(LANG3,NULL, ?,LANG3)= ? order by SYNM.DRUG_SYNONYM_TYPE, SYNM.DRUG_SYNONYM_DESC, DRG.DRUG_DESC";
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TRN_TYPE_SELECT1") );
			pstmt = connection.prepareStatement( sDrugsForSynonymSQL );
			pstmt.setString(1,drug_synonym_type);
			pstmt.setString(2,"%"+synonym_type_code+"%");
			pstmt.setString(3,getLanguageId());
			pstmt.setString(4,getLanguageId());
			pstmt.setString(5,getLanguageId());
			pstmt.setString(6,getLanguageId());
			pstmt.setString(7,getLanguageId());
			pstmt.setString(8,getLanguageId());
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next() ){
				alDrugListForSynonym.add(resultSet.getString("DRUG_CODE"));
				alDrugListForSynonym.add(resultSet.getString("DRUG_DESC"));
				alDrugListForSynonym.add(resultSet.getString("DRUG_SYNONYM_TYPE"));//DRUG_SYNONYM_TYPE
				alDrugListForSynonym.add(resultSet.getString("DRUG_SYNONYM_DESC"));
				alDrugListForSynonym.add(resultSet.getString("EFF_STATUS"));
			}
		}
		catch ( Exception e ){
			System.err.println( "Error loading values from database drug_synonym_type="+drug_synonym_type+" synonym_type_code="+synonym_type_code ) ;
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es)
			{
				es.printStackTrace();
			}
		}
		setDrugListForSynonym(alDrugListForSynonym);
		return alDrugListForSynonym;
	}
}
