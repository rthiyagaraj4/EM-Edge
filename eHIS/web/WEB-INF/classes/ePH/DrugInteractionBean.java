/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name				Rev.Date	Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
05/11/2019	IN070606		Ramesh Goli											MMS-KH-CRF-0029	
23/08/2020		IN073641		Manickavasagam			MMS-KH-CRF-0034 
---------------------------------------------------------------------------------------------------------------
*/
package ePH ;
import java.io.Serializable ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
import eCommon.SingleTableHandler.*;

public class DrugInteractionBean extends PhAdapter implements Serializable {
	protected HashMap hmDrugIntrList=new HashMap();
	protected Hashtable htAllRecords=new Hashtable();
	protected Hashtable htModifyRecord=new Hashtable();
	protected boolean status=true;
	
	public DrugInteractionBean() {
		try {
			doCommon();
		}
		catch(Exception e) {        
			System.err.println( "Error loading @ start  :"+e ) ;
		}
	}

	private void doCommon() throws Exception {
	}
	 
	 public void setAll( Hashtable allRecords ) {
		try{
			this.mode =(String)allRecords.get("mode");
			if( this.mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ))  ){
				this.htAllRecords = allRecords ;
				int recCount =Integer.parseInt((String) htAllRecords.get("recCount"));
				String key="", eff_status="";
				for(int i=0; i<recCount; i++){
					eff_status = (String)htAllRecords.get("eff_status_"+i);
					if(!eff_status.equals("E")){
						key = (String)htAllRecords.get("InteractionBy_"+i)+"_"+(String)htAllRecords.get("intr_code1_"+i)+(String)htAllRecords.get("form_code1_"+i)+"_"+(String)htAllRecords.get("intr_code2_"+i)+(String)htAllRecords.get("form_code2_"+i);
						hmDrugIntrList.remove(key);
					}
				}
			}
			else if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ){
				htModifyRecord = allRecords;
			}
		}
		catch(Exception es){
			System.err.println("=====setAll=====allRecords==============>"+allRecords);
			es.printStackTrace();
		}
	 }
	/******************************   insert()  *********************************/
	 
	public void setDrugInrtList(HashMap hmDrugIntrList){
		this.hmDrugIntrList=hmDrugIntrList;
	}
	
	public HashMap getDrugIntrList(){
		return this.hmDrugIntrList;
	}
	
	public void clear(){
		super.clear() ;
		this.hmDrugIntrList.clear();
	}
	
	public boolean checkForDuplicate(String intr_option, String intr_code1, String intr_code2, String form_code1, String form_code2, String intr_Type){ // intr_Type added for IN070606
		Connection connection		= null ;
		PreparedStatement pstmt		= null ;
		ResultSet resultSet			= null ;
		String sql				=	"";
		boolean dupFound = false;
		int dupCount=0;
		try{
			connection			= getConnection() ;
			sql=PhRepository.getPhKeyValue( "SQL_PH_DRUG_INT_DUPLICATE_CHECK" );

			pstmt				= connection.prepareStatement(sql) ;
			pstmt.setString(1,intr_option);
			if("D".equals(intr_Type)) //IN070606
				pstmt.setString(2,intr_option);
			else //IN070606
				pstmt.setString(2,intr_Type); //IN070606
			pstmt.setString(3,intr_code1);
			pstmt.setString(4,intr_code2);
			pstmt.setString(5,form_code1);
			pstmt.setString(6,form_code2);
			pstmt.setString(7,intr_code2);
			pstmt.setString(8,intr_code1);
			pstmt.setString(9,form_code2);
			pstmt.setString(10,form_code1);

			resultSet	= pstmt.executeQuery();
			if (resultSet!=null && resultSet.next()) {
				dupCount = resultSet.getInt("DUP_COUNT");
			}
			if(dupCount>0)
				dupFound = true;
		}
		catch(Exception e){
				 e.printStackTrace();
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
		return dupFound;		
	}

	public HashMap getInteractionDtl(String intr_option, String intr_code1, String intr_code2, String form_code1, String form_code2,String intr_type){  //intr_type added for IN070606
		Connection connection		= null ;
		PreparedStatement pstmt		= null ;
		ResultSet resultSet			= null ;
		String sql				=	"";
		HashMap hmDrugIntrDtls	=   new HashMap();
		try{
			connection			= getConnection() ;
			//IN070606 Start.
			if(intr_option.equals("D")&& "D".equals(intr_type))
				sql=PhRepository.getPhKeyValue( "SQL_PH_DRUG_INT_MODIFY_DRUG" );
			else if(intr_option.equals("G")&& "D".equals(intr_type))
				sql=PhRepository.getPhKeyValue( "SQL_PH_DRUG_INT_MODIFY_GENERIC" );
			else if(intr_option.equals("D")&& "F".equals(intr_type))
				sql=PhRepository.getPhKeyValue( "SQL_PH_DRUG_INT_MODIFY_DRUGTOFOOD" );
			else if(intr_option.equals("G")&& "F".equals(intr_type))
				sql=PhRepository.getPhKeyValue( "SQL_PH_DRUG_INT_MODIFY_GENERICTOFOOD" );
			else if(intr_option.equals("D")&& "L".equals(intr_type))
				sql=PhRepository.getPhKeyValue( "SQL_PH_DRUG_INT_MODIFY_DRUGTOLAB" );
			else if(intr_option.equals("G")&& "L".equals(intr_type))
				sql=PhRepository.getPhKeyValue( "SQL_PH_DRUG_INT_MODIFY_GENERICTOLAB" );
			else if(intr_option.equals("D")&& "I".equals(intr_type))//Adding start for MMS-DM-CRF-0229
				sql=PhRepository.getPhKeyValue( "SQL_PH_DRUG_INT_MODIFY_DRUGTOICD" );
			else if(intr_option.equals("G")&& "I".equals(intr_type))
				sql=PhRepository.getPhKeyValue( "SQL_PH_DRUG_INT_MODIFY_GENERICTOICD" );//Adding end for MMS-DM-CRF-0229
			//IN070606 End.
			pstmt				= connection.prepareStatement(sql) ;
			pstmt.setString(1,intr_option);
			if("D".equals(intr_type)) //IN070606
			pstmt.setString(2,intr_option);
			else //IN070606
			pstmt.setString(2,intr_type); //IN070606
			pstmt.setString(3,intr_code1);
			pstmt.setString(4,intr_code2);
			pstmt.setString(5,form_code1);
			pstmt.setString(6,form_code2);
			pstmt.setString(7,getLanguageId());
			if("D".equals(intr_type))
			pstmt.setString(8,getLanguageId());

			resultSet	= pstmt.executeQuery();
			if (resultSet!=null && resultSet.next()) {
				hmDrugIntrDtls.put("INTR_TYPE1",resultSet.getString("INTR_TYPE1"));
				hmDrugIntrDtls.put("INTR_TYPE2",resultSet.getString("INTR_TYPE2"));
				hmDrugIntrDtls.put("intr_code1",resultSet.getString("intr_code1"));
				hmDrugIntrDtls.put("intr_code2",resultSet.getString("intr_code2"));
				hmDrugIntrDtls.put("intr_name1",resultSet.getString("intr_name1"));
				hmDrugIntrDtls.put("intr_name2",resultSet.getString("intr_name2")); 
				hmDrugIntrDtls.put("severity_level",resultSet.getString("intr_severity_level"));
				hmDrugIntrDtls.put("significant_level",resultSet.getString("intr_signif_level"));
				hmDrugIntrDtls.put("probability",resultSet.getString("intr_prob_level"));
				hmDrugIntrDtls.put("restrict_transaction",resultSet.getString("INTR_RESTRT_YN"));
				hmDrugIntrDtls.put("interaction_desc",resultSet.getString("INTR_REMARKS"));
				hmDrugIntrDtls.put("eff_status",resultSet.getString("eff_status"));
				hmDrugIntrDtls.put("form_code1",resultSet.getString("form_code1"));
				hmDrugIntrDtls.put("form_code2",resultSet.getString("form_code2"));
				hmDrugIntrDtls.put("form_desc1",checkForNull(resultSet.getString("form_desc1")));
				hmDrugIntrDtls.put("form_desc2",checkForNull(resultSet.getString("form_desc2"))); 
				hmDrugIntrDtls.put("intr_type",intr_type);  //IN070606
				hmDrugIntrDtls.put("LAB_ORD_CHK_UPTO_NO_OF_DAYS",checkForNull(resultSet.getString("LAB_ORD_CHK_UPTO_NO_OF_DAYS")));  //MMS-KH-CRF-0034
				if("I".equals(intr_type)){//Adding start for MMS-DM-CRF-0229
					hmDrugIntrDtls.put("TERM_SET_ID",checkForNull(resultSet.getString("TERM_CODE")));
					hmDrugIntrDtls.put("TERM_SET_DESC",checkForNull(resultSet.getString("TERM_SET_DESC")));
				}else{
					hmDrugIntrDtls.put("TERM_SET_ID","");
					hmDrugIntrDtls.put("TERM_SET_DESC","");
				}//Adding end for MMS-DM-CRF-0229
			}
		}
		catch(Exception e){
				 e.printStackTrace();
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
		return hmDrugIntrDtls;	
	}
	public HashMap insert(){
		ArrayList insertData = new ArrayList() ;
	    ArrayList whereData = new ArrayList() ;
	//    ArrayList insertvalues=new ArrayList();   Removed for IN063877
	    HashMap tabData = new HashMap() ;
	    HashMap sqlMap = new HashMap() ;
		HashMap hmDrugIntrsList = getDrugIntrList();
		ArrayList DrugInteractionDtl = null;
	    HashMap insertResult	=	null;
		try{
		    if(hmDrugIntrsList!=null && hmDrugIntrsList.size()>0){
				List intrKeyList = new ArrayList(hmDrugIntrsList.keySet());
				for(int count=0 ; count<intrKeyList.size() ; count++){
					DrugInteractionDtl =(ArrayList) hmDrugIntrsList.get((String)intrKeyList.get(count));
		    	//	int j=0;  Removed for IN063877
		    		ArrayList whereRow = new ArrayList() ;
		    		ArrayList insertRow = new ArrayList() ;

					insertRow.add((String)DrugInteractionDtl.get(0));
					if("D".equals((String)DrugInteractionDtl.get(15))) //IN070606
						insertRow.add((String)DrugInteractionDtl.get(0));
					else  //IN070606
						insertRow.add((String)DrugInteractionDtl.get(15)); //IN070606
					insertRow.add((String)DrugInteractionDtl.get(1));
					insertRow.add((String)DrugInteractionDtl.get(2));
					insertRow.add((String)DrugInteractionDtl.get(5));
					insertRow.add((String)DrugInteractionDtl.get(6));
					insertRow.add((String)DrugInteractionDtl.get(7));
					insertRow.add((String)DrugInteractionDtl.get(8));
					insertRow.add((String)DrugInteractionDtl.get(9));
					insertRow.add((String)DrugInteractionDtl.get(10));
					insertRow.add(login_at_ws_no.trim());
					insertRow.add(login_facility_id.trim());
					insertRow.add(login_at_ws_no.trim());
					insertRow.add(login_facility_id.trim());
					insertRow.add((String)DrugInteractionDtl.get(11));
					insertRow.add((String)DrugInteractionDtl.get(12));
					insertRow.add((String)DrugInteractionDtl.get(16)); //MMS-KH-CRF-0034
					insertRow.add((String)DrugInteractionDtl.get(17)); //MMS-DM-CRF-0229
					insertData.add(insertRow);

					whereRow.add( (String)DrugInteractionDtl.get(0)) ;
					if("D".equals((String)DrugInteractionDtl.get(15))) //IN070606
						whereRow.add( (String)DrugInteractionDtl.get(0)) ;
					else //IN070606
						whereRow.add((String)DrugInteractionDtl.get(15)); //IN070606
					whereRow.add( (String)DrugInteractionDtl.get(1)) ;
					whereRow.add((String)DrugInteractionDtl.get(2)) ;
					whereRow.add( (String)DrugInteractionDtl.get(11)) ;
					whereRow.add((String)DrugInteractionDtl.get(12)) ;
					whereData.add( whereRow ) ;
		    	}
		        tabData.put( "properties", getProperties() );
		        tabData.put( "InsertData",insertData);
		        tabData.put( "WhereData",whereData);
		        try{
					sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue( "SQL_PH_DRUG_INT_SELECT_QUERY" ) );
					sqlMap.put( "InsertSQL",PhRepository.getPhKeyValue( "SQL_PH_INSERT_DRUG_INT_DTL"));
		        }
				catch(Exception e){
		            e.printStackTrace();
		        }
		    }
			 insertResult = CallSingleTableHandler(tabData,sqlMap);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return insertResult;
	}
	 
	
	public HashMap modify(){
	//	ArrayList modifyData = new ArrayList() ;  Removed for IN063877
		//ArrayList insertvalues = new ArrayList();  Removed for IN063877
	    HashMap tabData = new HashMap() ;
	    HashMap sqlMap = new HashMap() ;
	  //  String eff_status	=	"";  Removed for IN063877
		ArrayList modifyRow = new ArrayList() ;
	    HashMap modifyResult	=	null;
		try{
		    if(htModifyRecord!=null && htModifyRecord.size()>0){
				modifyRow.add((String)htModifyRecord.get("Severity_Level"));
				modifyRow.add((String)htModifyRecord.get("Significant_level"));
				modifyRow.add((String)htModifyRecord.get("Probability"));
				modifyRow.add(checkForNull((String)htModifyRecord.get("restrict_transaction"), "N"));
				modifyRow.add(java.net.URLDecoder.decode((String)htModifyRecord.get("interact_desc"),"UTF-8"));
				modifyRow.add(checkForNull((String)htModifyRecord.get("eff_status"),"D"));
				modifyRow.add(login_facility_id.trim());
				modifyRow.add(login_at_ws_no.trim());
				modifyRow.add((String)htModifyRecord.get("lab_ord_chk_upto")); //MMS-KH-CRF-0034
				modifyRow.add((String)htModifyRecord.get("InteractionBy")); 
				modifyRow.add((String)htModifyRecord.get("intr_code1"));
				if("D".equals((String)htModifyRecord.get("InteractionType"))) //IN070606
					modifyRow.add((String)htModifyRecord.get("InteractionBy"));
				else //IN070606
					modifyRow.add((String)htModifyRecord.get("InteractionType")); //IN070606
				modifyRow.add((String)htModifyRecord.get("intr_code2"));
				modifyRow.add((String)htModifyRecord.get("form_code1"));
				if("D".equals((String)htModifyRecord.get("InteractionType"))) //IN070606
					modifyRow.add((String)htModifyRecord.get("form_code2"));
				else //IN070606
					modifyRow.add("*A"); //IN070606
				//modifyData.add(modifyRow);
				tabData.put( "properties", getProperties() );
				tabData.put( "ModifyData",modifyRow);
				sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue("SQL_PH_DRUG_INT_UPDATE_QUERY") );
				modifyResult = CallSingleTableHandler(tabData,sqlMap) ;
			}
		}
		catch(Exception e){
			System.err.println("===========modifyRow==============>"+modifyRow);
			e.printStackTrace();
		}
		return modifyResult;	
	}
	
	private  HashMap CallSingleTableHandler(HashMap tabData , HashMap sqlMap){
	    HashMap map = new HashMap() ;
	    map.put( "result", new Boolean( false ) ) ;

	    try {
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class, getLocalEJB());
			Object busObj = (home.getClass().getMethod("create", null)).invoke(home, null);
			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;
			Class[] paramArray = new Class[2];
			paramArray[0] = tabData.getClass();
			paramArray[1] = sqlMap.getClass();
		
			if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ))  ){
				map = (HashMap) (busObj.getClass().getMethod("singleBatchHandler", paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove", null)).invoke(busObj,null);
			/*	map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);*/
			}
			else if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) ){
				map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			}

			if( ((Boolean) map.get( "result" )).booleanValue() )
                   map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			else {
				if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS") ) {
                   map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common") ) ;
					map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
				}
				else
					map.put( "message", map.get("msgid") ) ;
			}
		}
		catch(Exception e) {
			System.err.println( "Error Calling EJB classcast tabData: "+tabData ) ;
			map.put( "message", e.getMessage()) ;
			e.printStackTrace() ;
		}
		return map;
	}

	public  ArrayList getDosageForms(String intr_option , String intrCode){
		Connection connection		= null ;
		PreparedStatement pstmt		= null ;
		ResultSet resultSet			= null ;
		String sql				=	"";
		ArrayList dosageForms = new ArrayList();
		try{
			connection			= getConnection() ;
			if(intr_option.equals("D")){
				sql=PhRepository.getPhKeyValue( "SQL_PH_DRUG_INT_DRUG_DOSAGE_FORM" ); 
				pstmt				= connection.prepareStatement(sql) ;
				pstmt.setString(1,intrCode);
				pstmt.setString(2,getLanguageId());
			}
			else{
				sql=PhRepository.getPhKeyValue( "SQL_PH_DRUG_INT_GENERIC_DOSAGE_FORM" );
				pstmt				= connection.prepareStatement(sql) ;
				pstmt.setString(1,intrCode);
				pstmt.setString(2,intrCode);
				pstmt.setString(3,getLanguageId());
			}

			resultSet	= pstmt.executeQuery();
			if (resultSet!=null){
				while(resultSet.next()) {
					dosageForms.add(new String[]{resultSet.getString("FORM_CODE"),resultSet.getString("FORM_DESC")});
					//dosageForms.add(resultSet.getString("FORM_CODE"));
					//dosageForms.add(resultSet.getString("FORM_DESC"));
				}
			}
		}
		catch(Exception e){
				 e.printStackTrace();
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
		return dosageForms;		
	}

	public ArrayList getTermList(){//Adding start for MMS-DM-CRF-0229
	  Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		ArrayList TermArraylist =		new ArrayList();
		
		try {
			connection	 = getConnection() ;
			pstmt			 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TERM_SET_SELECT1" )) ;
			resultSet      = pstmt.executeQuery() ;

			while (resultSet.next()) {
				HashMap rec		=	new HashMap();
				String code,desc;
				code					=	resultSet.getString("TERM_SET_ID");
				desc					=	resultSet.getString("TERM_SET_DESC");
				rec.put("code",code);
				rec.put("desc",desc);
				TermArraylist.add(rec);
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
				es.printStackTrace() ;
			}
		}
		return TermArraylist;
	  }

}