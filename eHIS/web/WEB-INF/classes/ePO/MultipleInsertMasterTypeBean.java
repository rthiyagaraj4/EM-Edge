/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePO;
 
import java.util.Hashtable;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import eCommon.Common.CommonRepository;
import ePO.Common.PoRepository;
import eCommon.SingleTableHandler.*;
import com.ehis.util.DateUtils;
import ePO.POMasterType.*;
import eCommon.Common.*;
import java.util.Properties; 
 
public class MultipleInsertMasterTypeBean extends ePO.Common.PoAdapter implements java.io.Serializable{

	private int RECORD_SIZE = Integer.parseInt((String)CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));

	private String master_type ;
	private String []master_code = new String[RECORD_SIZE];
	private String []long_desc  = new String[RECORD_SIZE];
	private String []short_desc = new String[RECORD_SIZE];
	private String []eff_status = new String[RECORD_SIZE];

	private String []dept_no = new String[RECORD_SIZE];
	private String []acc_no = new String[RECORD_SIZE];
	private String []acc_no_desc = new String[RECORD_SIZE];
	private String []all_budget = new String[RECORD_SIZE];
	private String []addnl_budget = new String[RECORD_SIZE];
	private String []blocked_budget = new String[RECORD_SIZE];
	private String []total_budget = new String[RECORD_SIZE];
	private String []from_date = new String[RECORD_SIZE];
	private String []to_date = new String[RECORD_SIZE];
	private String []override_budget = new String[RECORD_SIZE];
	private HashMap		hmExpRecords=new HashMap();
	private ArrayList	alDtlRecords=new ArrayList();
	
	//private String dept_no = "";
	//private String acc_no = "";
	//private String from_date = "";
	//private String to_date = "";

	protected String InsertSQL;
	protected String ModifySQL;
	protected String SelectSQL;
	protected String UpdateSQL;
	protected String codeFieldName;

	protected String InsertSQL1;
	protected String CommModifySQL;
	protected String SelectSQL1;
	protected String CommUpdateSQL;
	protected String commFieldName;
	
	
	public MultipleInsertMasterTypeBean() {

	}

	/* Set Methods Start */
	public void setMaster_code(int index, String master_code) {
			this.master_code[index]		=	(master_code != null)?master_code.toUpperCase():null; 
	}

	public void setLong_desc(int index, String long_desc) {
			this.long_desc[index]		=	long_desc; 
	}

	public void setShort_desc(int index, String short_desc) {
			this.short_desc[index]		=	short_desc; 
	}
	public void setEff_status(int index, String eff_status) {
			this.eff_status[index]		=	eff_status;//checkForNull(eff_status,"D");
	}
	
	public void setMasterType( String master_type) {
			this.master_type		=	master_type;
	}
	public void setDept_no(int index, String dept_no) {
			this.dept_no[index]		=	dept_no;
	}
	public void setAcc_no(int index, String acc_no) {
			this.acc_no[index]		=	acc_no;
	}

	public void setAcc_no_desc(int index, String acc_no_desc) {
			this.acc_no_desc[index]		=	acc_no_desc;
	}
	public void setAll_budget(int index, String all_budget) {
			this.all_budget[index]		=	all_budget;
	}
	public void setAddnl_budget(int index, String addnl_budget) {
			this.addnl_budget[index]		=	addnl_budget;
	}
	public void setBlocked_budget(int index, String blocked_budget) {
			this.blocked_budget[index]		=	blocked_budget;
	} 
	public void setTotal_budget(int index, String total_budget) {
			this.total_budget[index]		=	total_budget;
	}
	public void setFrom_date(int index, String from_date) {
			this.from_date[index]		=	from_date;
	}
	public void setTo_date(int index, String to_date) {
			this.to_date[index]		=	to_date;
	}
	public void setOverride_budget(int index, String override_budget) {
			this.override_budget[index]		=	override_budget;
	} 
	
	
	/* Set Methods End */

	/* Get Methods Start */	
	public String getMasterType() {
		return this.master_type;
	}

	public String getMaster_code(int index) {
		return this.master_code[index];
	}

	public String getLong_desc(int index) {
		return this.long_desc[index];
	}

	public String getShort_desc(int index) {
		return this.short_desc[index];
	}

	public String getEff_status(int index) {
		return this.eff_status[index];
	}
	
	public String getDept_no(int index) {
		 return	this.dept_no[index];	
	}
	public String getAcc_no(int index) {
		 return	this.acc_no[index];	
	}
	public String getAcc_no_desc(int index) {
		 return	this.acc_no_desc[index];	
	}
	public String getAll_budget(int index) {
		 return	this.all_budget[index];	
	}
	public String getAddnl_budget(int index) {
		 return	this.addnl_budget[index];	
	}
	public String getBlocked_budget(int index) {
		 return	this.blocked_budget[index];	
	} 
	public String getTotal_budget(int index) {
		 return	this.total_budget[index];	
	}
	public String getFrom_date(int index)  {
		 return	this.from_date[index];
	}
	public String getTo_date(int index) {
		 return	this.to_date[index];
	}
	public String getOverride_budget(int index) {
		 return	this.override_budget[index];	
	}
	
	/* Get Methods End */



public void clear() {

		super.clear();
		//hmExpRecords;
			//master_type = "";
		for (int index=0;index<RECORD_SIZE;index++)
		{
			master_code[index]	 = "";
			long_desc[index] = "";
			short_desc[index] = "";
			eff_status[index] = "D";
			dept_no[index] = "";
			acc_no[index] = "";
			acc_no_desc[index] = "";
			all_budget[index] = "";
			addnl_budget[index] = "";
			blocked_budget[index] = "";
			total_budget[index] = "";
			from_date[index] = "";
			to_date[index] = "";
			override_budget[index] = "";

			//dept_no = "";
			//acc_no = "";
			//from_date = "";
			//to_date = "";
		}


	
	}

	public void initialize() {
		hmExpRecords=new HashMap();
		alDtlRecords=new ArrayList();
	}
		public void updateDtlRecord(int index, HashMap hmDtlRecord){
			
			alDtlRecords.set(index, hmDtlRecord);
	} 

	public HashMap getDtlRecord(int index){
		return (HashMap)alDtlRecords.get(index);
	}

	public ArrayList getDtlRecords(){
		return alDtlRecords;
	}
	
	public void updateAllRecords(int index, Hashtable htExpRecords){ 

		HashMap hmRecord = null;
		ArrayList alExpRecords = new ArrayList();

		for (int i=0;i<Integer.parseInt((String)htExpRecords.get("totalRecords")); i++) {

			hmRecord = new HashMap();

			if(((String)htExpRecords.get("dept_no_"+i)).equals(""))
				continue;

			hmRecord.put("DEPT_CODE",	(String)htExpRecords.get("dept_no_"+i));
			hmRecord.put("ACCOUNT_NO",	(String)htExpRecords.get("acc_no_"+i));
			hmRecord.put("ACCOUNT_NAME",	(String)htExpRecords.get("acc_no_desc_"+i));
			hmRecord.put("INITIAL_BDGT_AMT",	(String)htExpRecords.get("all_budget_"+i));
			hmRecord.put("ADDL_BDGT_AMT",	(String)htExpRecords.get("addnl_budget_"+i));
			hmRecord.put("BLOCKED_BDGT_AMT",	(String)htExpRecords.get("blocked_budget_"+i));
			hmRecord.put("BALANCE_BDGT_AMT",	(String)htExpRecords.get("total_budget_"+i));
			hmRecord.put("EFF_DATE_FROM",	(String)htExpRecords.get("from_date_"+i));
			hmRecord.put("EFF_DATE_TO",	(String)htExpRecords.get("to_date_"+i));
			hmRecord.put("OVERRIDE_BUDGET",	(String)htExpRecords.get("override_budget_"+i));	
			alExpRecords.add(hmRecord);
			
		}
		setExpRecords(index, alExpRecords);
	}

	public void setExpRecords(int index, ArrayList alExpRecords){
		hmExpRecords.put(""+index,alExpRecords);
	}

	public ArrayList getExpRecords(int index){
		return (ArrayList)hmExpRecords.get(""+index);
	}

	public HashMap getExpRecords(){
		return hmExpRecords;
	}


	public void setAll(Hashtable recordSet) {

		master_type=	(String)recordSet.get("master_type"); 

		setMasterType(master_type);

		for (int index=0;index<RECORD_SIZE;index++) {
			
			String tempCode			=	(String)recordSet.get("master_code_"+index);
			String tempLong_desc	=	(String)recordSet.get("long_desc_"+index);
			String tempShort_desc	=	(String)recordSet.get("short_desc_"+index);
			String tempEff_status	=	(String)recordSet.get("eff_status_"+index);

			if((tempCode== null) || (tempCode.equals(""))) {
				setMaster_code	(index, null);
				setLong_desc	(index, null);
				setShort_desc	(index, null);
				setEff_status(index, null);
				continue; 
			}

		
			setMaster_code	(index, tempCode);
			setLong_desc	(index, tempLong_desc	);
			setShort_desc	(index, tempShort_desc	);

			if(tempEff_status==null || tempEff_status.trim().equals(""))
				setEff_status	(index, "D");
			else
				setEff_status	(index, tempEff_status);

		}
	}

	public HashMap insert() {

		HashMap		hmResult	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alInsertData=	new ArrayList()	;
	//	ArrayList	alWhereData	=	new ArrayList()	;
		ArrayList	alInsertData1=	new ArrayList()	;


		hmResult.put("result", new Boolean(false));

	try{

				for (int index=0;index<RECORD_SIZE;index++) {
					if((getMaster_code(index) == null) || (getMaster_code(index).equals(""))) 
							continue;

					ArrayList alInsertRecord        =       new ArrayList();
					alInsertRecord.add(master_type);
					alInsertRecord.add(getMaster_code(index));
					alInsertRecord.add(getLong_desc(index));
					alInsertRecord.add(getShort_desc(index));
					alInsertRecord.add(getEff_status(index));
					alInsertRecord.add(login_by_id);
					alInsertRecord.add(login_at_ws_no);
					alInsertRecord.add(login_facility_id);
					alInsertRecord.add(login_by_id);
					alInsertRecord.add(login_at_ws_no);
					alInsertRecord.add(login_facility_id);
					
					alInsertData.add(alInsertRecord);
					/*For duplicate check
					ArrayList duplicateValue = new ArrayList();
					duplicateValue.add(getMaster_code(index));
					duplicateValue.add(master_type);
					alWhereData.add(duplicateValue);*/
				}

	
		ArrayList sourceArrayList;
			
		for (int i=0;i<hmExpRecords.size();i++) {

			sourceArrayList	=	(ArrayList)hmExpRecords.get(""+i);

						for (int j=0;j<sourceArrayList.size(); j++ ) {							

							HashMap hmRecord	=	(HashMap)sourceArrayList.get(j);

							if(hmRecord.get("DEPT_CODE") == null || hmRecord.get("DEPT_CODE").equals(""))
								continue;

							ArrayList alInsertRecord1        =       new ArrayList();
							alInsertRecord1.add(master_type);
							alInsertRecord1.add(getMaster_code(i));
							alInsertRecord1.add(hmRecord.get("DEPT_CODE"));
							alInsertRecord1.add(hmRecord.get("ACCOUNT_NO"));
							alInsertRecord1.add(hmRecord.get("ACCOUNT_NAME"));
							alInsertRecord1.add(hmRecord.get("INITIAL_BDGT_AMT"));
							alInsertRecord1.add(hmRecord.get("ADDL_BDGT_AMT"));
							alInsertRecord1.add(hmRecord.get("BALANCE_BDGT_AMT"));
							alInsertRecord1.add(hmRecord.get("EFF_DATE_FROM"));
							alInsertRecord1.add(hmRecord.get("EFF_DATE_TO"));
							alInsertRecord1.add(login_by_id);
							alInsertRecord1.add(login_at_ws_no);
							alInsertRecord1.add(login_facility_id);
							alInsertRecord1.add(login_by_id);
							alInsertRecord1.add(login_at_ws_no);
							alInsertRecord1.add(login_facility_id);
							alInsertRecord1.add(hmRecord.get("OVERRIDE_BUDGET"));
							alInsertRecord1.add("0"); // BLOCKED_BUDGET_AMT
							alInsertData1.add(alInsertRecord1);

						
						/*For duplicate check
						ArrayList duplicateValue1 = new ArrayList();
						duplicateValue1.add(getMaster_code(i));
						duplicateValue1.add(master_type);
						alWhereData1.add(duplicateValue1);*/
										
					}
			}
			
		}catch(Exception e){
			e.printStackTrace();			
		}
			  

		hmSQLMap.put("InsertDTLSQL",ePO.Common.PoRepository.getPoKeyValue("SQL_PO_MASTER_TYPE_INSERT"));
		hmSQLMap.put("InsertCOMMNTSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_COMMTTMENT_ACCOUNT_INSERT"));
	
		hmTableData.put("properties",getProperties());
		hmTableData.put("InsertDTLData",alInsertData);
		hmTableData.put("InsertCOMMNTData",alInsertData1);

		
		POMasterTypeRemote pomastertypeRemote = null;
		try {
		
			
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/POMasterType", POMasterTypeHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();
			 hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
		
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			String ms_id=(String) hmResult.get( "msgid" );
			if(ms_id.equals("CODE_ALREADY_EXISTS") || ms_id.equals("RECORD_INSERTED") || ms_id.equals("RECORD_MODIFIED") )
			hmResult.put("message",getPOMessage(getLanguageId(),ms_id,"PO") ) ;
			else {		
			hmResult.put("message","Transaction failed") ;
			}
			//hmResult.put("message",getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
		}
		catch(Exception e) {
				hmResult.put("message", e.toString());
				e.printStackTrace();
		} 
		finally {
			try {
				if(pomastertypeRemote != null){}
				//	requestRemote.remove();
			}
			catch(Exception ee) {
				hmResult.put("message", ee.toString());
			}
		}
	return hmResult;




	}


	public HashMap modify() {

		HashMap		hmResult	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alModifyRecord=	new ArrayList()	;
		ArrayList	alModifyRecord1=	new ArrayList()	;
		ArrayList	alInsertData1=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		
		hmResult.put("result", new Boolean(false));

		try{

		for (int index=0;index<RECORD_SIZE;index++) {
					if((getMaster_code(index) == null) || (getMaster_code(index).equals(""))) 
							continue;
					ArrayList alModifyData        =       new ArrayList();
					
					alModifyData.add(getLong_desc(index));
					alModifyData.add(getShort_desc(index));
					alModifyData.add(getEff_status(index));
					alModifyData.add(login_by_id);
					alModifyData.add(login_at_ws_no);
					alModifyData.add(login_facility_id);
					alModifyData.add(getMaster_code(index));
					alModifyData.add(master_type);
					
					alModifyRecord.add(alModifyData);
					/*For duplicate check
					ArrayList duplicateValue = new ArrayList();
					duplicateValue.add(getMaster_code(index));
					duplicateValue.add(master_type);
					alWhereData.add(duplicateValue);*/
			}



			ArrayList sourceArrayList;

			for (int i=0;i<hmExpRecords.size();i++) {

			sourceArrayList	=	(ArrayList)hmExpRecords.get(""+i);

						for (int j=0;j<sourceArrayList.size(); j++ ) {
							HashMap hmRecord	=	(HashMap)sourceArrayList.get(j);

							if(hmRecord.get("DEPT_CODE") == null || hmRecord.get("DEPT_CODE").equals("")){
								continue;
							}

							ArrayList alParameters = new ArrayList();
							
							alParameters.add(master_type);
							alParameters.add(getMaster_code(i));
							alParameters.add((String)hmRecord.get("DEPT_CODE"));	
							alParameters.add((String)hmRecord.get("EFF_DATE_FROM"));

							int count	=	Integer.parseInt((String)fetchRecord(ePO.Common.PoRepository.getPoKeyValue("SQL_PO_COMMTTMENT_ACCOUNT_EXISTS"),alParameters).get("COUNT"));
						
							if(count>0){

							ArrayList alModifyData1        =       new ArrayList();
							
							
							alModifyData1.add(hmRecord.get("ACCOUNT_NO"));
							alModifyData1.add(hmRecord.get("ACCOUNT_NAME"));
							alModifyData1.add(hmRecord.get("INITIAL_BDGT_AMT"));
							alModifyData1.add(hmRecord.get("ADDL_BDGT_AMT"));
							//alModifyData1.add(hmRecord.get("BLOCKED_BDGT_AMT"));
							alModifyData1.add(hmRecord.get("BALANCE_BDGT_AMT"));
							alModifyData1.add(hmRecord.get("EFF_DATE_TO"));									
							alModifyData1.add(login_by_id);
							alModifyData1.add(login_at_ws_no);
							alModifyData1.add(login_facility_id);
							alModifyData1.add(hmRecord.get("OVERRIDE_BUDGET"));
							alModifyData1.add(getMaster_code(i));
							alModifyData1.add(master_type);
							alModifyData1.add(hmRecord.get("DEPT_CODE"));
							alModifyData1.add(hmRecord.get("EFF_DATE_FROM"));	
							
							alModifyRecord1.add(alModifyData1);

							}else{
							
							ArrayList alInsertRecord1        =       new ArrayList();

							alInsertRecord1.add(master_type);
							alInsertRecord1.add(getMaster_code(i));
							alInsertRecord1.add(hmRecord.get("DEPT_CODE"));
							alInsertRecord1.add(hmRecord.get("ACCOUNT_NO"));
							alInsertRecord1.add(hmRecord.get("ACCOUNT_NAME"));
							alInsertRecord1.add(hmRecord.get("INITIAL_BDGT_AMT"));
							alInsertRecord1.add(hmRecord.get("ADDL_BDGT_AMT"));
							//alInsertRecord1.add(hmRecord.get("BLOCKED_BDGT_AMT"));
							alInsertRecord1.add(hmRecord.get("BALANCE_BDGT_AMT"));
							alInsertRecord1.add(hmRecord.get("EFF_DATE_FROM"));
							alInsertRecord1.add(hmRecord.get("EFF_DATE_TO"));
							alInsertRecord1.add(login_by_id);
							alInsertRecord1.add(login_at_ws_no);
							alInsertRecord1.add(login_facility_id);
							alInsertRecord1.add(login_by_id);
							alInsertRecord1.add(login_at_ws_no);
							alInsertRecord1.add(login_facility_id);
							alInsertRecord1.add(hmRecord.get("OVERRIDE_BUDGET"));
							alInsertRecord1.add("0"); // BLOCKED_BUDGET_AMT
							alInsertData1.add(alInsertRecord1);
							
							}

							
							/*For duplicate check
							ArrayList duplicateValue1 = new ArrayList();
							duplicateValue1.add(getMaster_code(i));
							duplicateValue1.add(master_type);
							alWhereData1.add(duplicateValue1);*/
											
						}
			}
		
		}catch(Exception e){
			e.printStackTrace();			
		}

		hmSQLMap.put("UpdateDTLSQL",ePO.Common.PoRepository.getPoKeyValue("SQL_PO_MASTER_TYPE_UPDATE"));
		hmSQLMap.put("UpdateCOMMNTSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_COMMTTMENT_ACCOUNT_UPDATE"));
		hmSQLMap.put("InsertCOMMNTSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_COMMTTMENT_ACCOUNT_INSERT"));

		//hmSQLMap.put("SelectSQL",ePO.Common.PoRepository.getPoKeyValue("SQL_PO_MASTER_TYPE_EXISTS"));
		hmTableData.put("properties",getProperties());
		//hmTableData.put("WhereData",alWhereData);
		hmTableData.put("UpdateDTLData",alModifyRecord);
		hmTableData.put("UpdateCOMMNTData",alModifyRecord1);
		hmTableData.put("InsertCOMMNTData",alInsertData1);
		//hmSQLMap.put("SelectSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_COMMTTMENT_ACCOUNT_EXISTS")); 
		
		POMasterTypeRemote pomastertypeRemote = null;
			
		
		/*LanguageData.add(getLanguageId());
		hmSQLMap.put("ModifySQL", UpdateSQL); 
		System.err.println("alModifyData"+alModifyData);
		hmTableData.put("properties",			getProperties());
		hmTableData.put("ModifyData",			alModifyData	);
		hmTableData.put( "LanguageData",LanguageData);

		SingleTableHandlerHome		singleTableHandlerHome		= null;
		SingleTableHandlerRemote	singleTableHandlerRemote	= null;*/

		try {
		
			
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/POMasterType", POMasterTypeHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();
			 hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
		
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			String ms_id=(String) hmResult.get( "msgid" );
			if(ms_id.equals("CODE_ALREADY_EXISTS") || ms_id.equals("RECORD_INSERTED") || ms_id.equals("RECORD_MODIFIED") )
			hmResult.put("message",getPOMessage(getLanguageId(),ms_id,"PO") ) ;
			else {
		
			hmResult.put("message","Transaction failed") ;
			}
			//hmResult.put("message",getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
		}
		catch(Exception e) {
				hmResult.put("message", e.toString());
				e.printStackTrace();
		} 
		finally {
			try {
				if(pomastertypeRemote != null){}
				//	requestRemote.remove();
			}
			catch(Exception ee) {
				hmResult.put("message", ee.toString());
			}
		}
	return hmResult;
	}


 public void loadData() throws Exception {

		HashMap hmRecord = new HashMap();
		ArrayList alParameters = new ArrayList();
		
		int index = 0;
		alParameters.add(getMasterType());
		alParameters.add(getMaster_code(index));
	    alParameters.add(getLanguageId()); 

		ArrayList alRecords	=	fetchRecords("SELECT master_code, long_desc,short_desc, master_type, eff_status FROM PO_MASTER_CODE_LANG_VW WHERE master_type = ? AND master_code = ? AND LANGUAGE_ID =?  ",alParameters);

		for (int i=0; i<alRecords.size(); i++) {
			hmRecord	=	(HashMap)alRecords.get(i);
			HashMap hmTemp	=	new HashMap();
			hmTemp.put("master_code",hmRecord.get("MASTER_CODE"));
			hmTemp.put("long_desc",hmRecord.get("LONG_DESC"));
			hmTemp.put("short_desc",hmRecord.get("SHORT_DESC"));
			hmTemp.put("master_type",hmRecord.get("MASTER_TYPE"));
			hmTemp.put("eff_status",hmRecord.get("EFF_STATUS"));
			alDtlRecords.add(hmTemp);		
		}		
}

	public HashMap validate() throws Exception {
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "" ) ;
        return map ;
    }

	public ArrayList getMasterTypeList() throws Exception
	{
		java.sql.Connection connection = null;
		java.sql.PreparedStatement pstmt = null;
		java.sql.ResultSet resultSet = null;

		ArrayList	arrStore		=	new  ArrayList();
		HashMap		hmStore			=	null;	

		try {
				connection = getConnection();
				pstmt = connection.prepareStatement(PoRepository.getPoKeyValue("SQL_PO_MASTER_TYPE_SELECT")); 
				resultSet = pstmt.executeQuery();
				
				
				while ((resultSet != null) && (resultSet.next()))
				{
					hmStore			=	new HashMap();
					hmStore.put("type",checkForNull(resultSet.getString(1)));
					hmStore.put("desc",checkForNull(resultSet.getString(2)));
					arrStore.add(hmStore);
				}
			} 
			catch (Exception e )
			{
				System.err.println("Error loading values from database");
				e.printStackTrace();
				throw e;
			} 
			finally
			{
				 try{
					closeResultSet(resultSet);
					closeStatement(pstmt);
					closeConnection(connection);
					}
					catch(Exception es) 
					{
					es.printStackTrace();
					}
			}
			return arrStore;
		}
		
		
	public String getDept(String dept_code) {
		//return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_ST_PO_DEPT_SELECT")),dept_code); //27/06/12
       	return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_DEPT_SELECT"),getLanguageId()),dept_code); 		
 		
	}		
		
}
