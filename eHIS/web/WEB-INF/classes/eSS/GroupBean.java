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
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
1/7/2021  	TFS:19249        	Shazana                      			ML-MMOH-CRF-1661-US001

-------------------------------------------------------------------------------------------------------------------------------------------------------------
 */
package eSS;

import eSS.MasterCodeBean;
import eSS.Group.*;
import eSS.Common.*;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.io.*;
public class GroupBean extends MasterCodeBean implements Serializable { 

	private String usage_type;
	private String stat_group_code;
	private String non_returnable_yn;
	private String remarks;
	private String group_code;
	private String pack_item_code;
	private String pack_item_desc;
	private String alpha_code;
	private String group_type;
	private String def_washing_type;
	private String surgery_type;
	private String item_class_code;
	private String def_sterile_type;
	private String item_anal_code;
	private String pack_addl_cost;
	private String sub_classification_code;
	private String pack_item_qty;
	private String sterilize_reqd_yn;
	private String wash_reqd_yn     ;
	private String pack_reqd_yn     ;
	private String checklist_code     ;
	private String linenApplicableYN; //added for ML-MM0H-CRF-1661 

	public String getLinenApplicableYN() {
		return linenApplicableYN;
	}

	public void setLinenApplicableYN(String linenApplicableYN) {
		this.linenApplicableYN = linenApplicableYN;
	}//END 

	private String records_to_delete;
	private HttpSession session;

	public void setChecklist_Code(String checklist_code) {
		 this.checklist_code =  checkForNull(checklist_code,"");
	}

	public String getChecklist_Code() {
		 return checklist_code;
	}
	public void setPack_reqd_yn(String pack_reqd_yn) {
		 this.pack_reqd_yn =  checkForNull(pack_reqd_yn,"N");
	}

	public String getPack_reqd_yn() {
		 return pack_reqd_yn;
	}

	public void setWash_reqd_yn(String wash_reqd_yn) {
		 this.wash_reqd_yn =  checkForNull(wash_reqd_yn,"N");
	}

	public String getWash_reqd_yn() {
		 return wash_reqd_yn;
	}

	public void setSterilize_reqd_yn(String sterilize_reqd_yn) {
		 this.sterilize_reqd_yn =  checkForNull(sterilize_reqd_yn,"N");
	}

	public String getSterilize_reqd_yn() {
		 return sterilize_reqd_yn;
	}

	public void setSession(HttpSession session) {
		 this.session =  session;
	}

	public HttpSession getSession() {
		 return session;
	}

	public void setUsage_type(String usage_type) {
		 this.usage_type =  checkForNull(usage_type);
	}

	public String getUsage_type() {
		 return usage_type;
	}

	public void setRecords_to_delete(String records_to_delete) {
		 this.records_to_delete =  records_to_delete;
	}

	public String getRecords_to_delete() {
		 return records_to_delete;
	}

	public void setStat_group_code(String stat_group_code) {
		 this.stat_group_code =  checkForNull(stat_group_code);
	}

	public String getStat_group_code() {
		 return stat_group_code;
	}

	public void setNon_returnable_yn(String non_returnable_yn) {
		 this.non_returnable_yn =  checkForNull(non_returnable_yn,"N");
	}

	public String getNon_returnable_yn() {
		 return non_returnable_yn;
	}

	public void setRemarks(String remarks) {
		 this.remarks =  checkForNull(remarks);
	}

	public String getRemarks() {
		 return remarks;
	}

	public void setGroup_code(String group_code) {
		 this.group_code = group_code.toUpperCase();;
	}

	public String getGroup_code() {
		 return group_code;
	}

	public void setPack_item_code(String pack_item_code) {
		 this.pack_item_code =  checkForNull(pack_item_code);
	}

	public String getPack_item_code() {
		 return pack_item_code;
	}

	public void setPack_item_desc(String pack_item_desc) {
		 this.pack_item_desc =  checkForNull(pack_item_desc);
	}

	public String getPack_item_desc() {
		 return pack_item_desc;
	}

	public void setAlpha_code(String alpha_code) {
		 this.alpha_code = alpha_code;
	}

	public String getAlpha_code() {
		 return alpha_code;
	}

	public void setGroup_type(String group_type) {
		 this.group_type = group_type;
	}

	public String getGroup_type() {
		 return group_type;
	}

	public void setDef_washing_type(String def_washing_type) {
		 this.def_washing_type =  checkForNull(def_washing_type);
	}

	public String getDef_washing_type() {
		 return def_washing_type;
	}

	public void setSurgery_type(String surgery_type) {
		 this.surgery_type =  checkForNull(surgery_type);
	}

	public String getSurgery_type() {
		 return surgery_type;
	}

	public void setItem_class_code(String item_class_code) {
		 this.item_class_code = checkForNull(item_class_code);
	}

	public String getItem_class_code() {
		 return item_class_code;
	}

	public void setDef_sterile_type(String def_sterile_type) {
		 this.def_sterile_type =  checkForNull(def_sterile_type);
	}

	public String getDef_sterile_type() {
		 return def_sterile_type;
	}

	public void setItem_anal_code(String item_anal_code) {
		 this.item_anal_code =  checkForNull(item_anal_code);
	}

	public String getItem_anal_code() {
		 return item_anal_code;
	}

	public void setPack_addl_cost(String pack_addl_cost) {
		 this.pack_addl_cost =  checkForNull(pack_addl_cost);
	}

	public String getPack_addl_cost() {
		 return pack_addl_cost;
	}

	public void setSub_classification_code(String sub_classification_code) {
		 this.sub_classification_code =  checkForNull(sub_classification_code);
	}

	public String getSub_classification_code() {
		 return sub_classification_code;
	}

	public void setPack_item_qty(String pack_item_qty) {
		 this.pack_item_qty =  checkForNull(pack_item_qty);
	}

	public String getPack_item_qty() {
		 return pack_item_qty;
	}

	public void setAll(Hashtable htRecordSet){
		super.setAll(htRecordSet);
		setRecords_to_delete((String) htRecordSet.get("records_to_delete"));
		setUsage_type((String) htRecordSet.get("usage_type"));
		setStat_group_code((String) htRecordSet.get("stat_group_code"));
		setNon_returnable_yn((String) htRecordSet.get("non_returnable_yn"));
		setSterilize_reqd_yn((String) htRecordSet.get("sterilize_reqd_yn"));
		setWash_reqd_yn((String) htRecordSet.get("wash_reqd_yn"));
		setPack_reqd_yn((String) htRecordSet.get("pack_reqd_yn"));
		setRemarks((String) htRecordSet.get("remarks"));
		setGroup_code((String) htRecordSet.get("group_code"));
		setPack_item_code((String) htRecordSet.get("pack_item_code"));
		setAlpha_code((String) htRecordSet.get("alpha_code"));
		setGroup_type((String) htRecordSet.get("group_type"));
		setDef_washing_type((String) htRecordSet.get("def_washing_type"));
		setSurgery_type((String) htRecordSet.get("surgery_type"));
		setItem_class_code((String) htRecordSet.get("item_class_code"));
		setDef_sterile_type((String) htRecordSet.get("def_sterile_type"));
		setItem_anal_code((String) htRecordSet.get("item_anal_code"));
		setPack_addl_cost((String) htRecordSet.get("pack_addl_cost"));
		setSub_classification_code((String) htRecordSet.get("sub_classification_code"));
		setPack_item_qty((String) htRecordSet.get("pack_item_qty"));
		setChecklist_Code((String) htRecordSet.get("checklist_code"));
	}
	public void clear(){
		super.clear();
		usage_type				="";             
		stat_group_code			="";        
		non_returnable_yn		="N";      
		sterilize_reqd_yn		="Y";
		wash_reqd_yn			="Y";
		pack_reqd_yn			="Y";
		remarks					="";                
		group_code				="";             
		pack_item_code			="";         
		pack_item_desc			="";         
		alpha_code				="";             
		group_type				="";             
		def_washing_type		="";       
		surgery_type			="";           
		item_class_code			="";        
		def_sterile_type		="";       
		item_anal_code			="";         
		pack_addl_cost			="";         
		sub_classification_code	="";
		pack_item_qty			="";          
		session					=null;
		records_to_delete		="";
	    checklist_code = "";
	    linenApplicableYN =""; //ML-MMOH-CRF-1661 
	}




	public boolean isDisabledGroupCode(String group_code) throws Exception{
		return fetchRecord(getSsRepositoryValue("SQL_SS_GROUP_SELECT_STATUS"),group_code).get("EFF_STATUS").toString().equals("D");
	}

	public String getItem_class_code_List(){
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_MM_ITEM_CLASS_SELECT_LIST"),getLanguageId()), getItem_class_code());
	}

	public String getSub_classification_code_List(){
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_SUB_CLASSIFICATION_SELECT_LIST"),getLanguageId()), getSub_classification_code());
	}
	public String getUsage_type_List(){
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_USAGE_TYPE_SELECT_LIST"),getLanguageId()), getUsage_type());
	}
	public String getItem_anal_code_List(){
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_MM_ITEM_ANALYSIS_SELECT_LIST"),getLanguageId()), getItem_anal_code());
	}

	public String getStat_group_code_List(){
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STAT_GROUP_SELECT_LIST"),getLanguageId()), getStat_group_code());
	}

	public String getDef_sterile_type_List(){
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STERILIZATION_TYPE_SELECT_LIST"),getLanguageId()), getDef_sterile_type());
	}

	public String getDef_washing_type_List(){
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_WASHING_TYPE_SELECT_LIST"),getLanguageId()), getDef_washing_type());
	}

	public String getSurgery_type_List(){
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_SURGERY_TYPE_SELECT_LIST"),getLanguageId()), getSurgery_type());
	}

	public String getGroup_type_List(){
		 String locale = getLanguageId();
	     java.util.Locale loc = new java.util.Locale(locale);
	     java.util.ResourceBundle ss_labels = java.util.ResourceBundle.getBundle( "eSS.resources.Labels",loc);
		 java.util.ResourceBundle com_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
		 if( getLinenApplicableYN()!=null && getLinenApplicableYN().equals("Y") ){//MMOH-CRF-1661  
				return getStaticListOptionTag( "E,"+ss_labels.getString("eSS.Set.label")+";T,"+ss_labels.getString("eSS.Tray.label")+";P,"+ss_labels.getString("eSS.SoftPack.label")+";S,"+com_labels.getString("Common.single.label")+";L,"+ss_labels.getString("eSS.Linen.label"), getGroup_type()); 

		 }else{
				return getStaticListOptionTag( "E,"+ss_labels.getString("eSS.Set.label")+";T,"+ss_labels.getString("eSS.Tray.label")+";P,"+ss_labels.getString("eSS.SoftPack.label")+";S,"+com_labels.getString("Common.single.label"), getGroup_type()); 
		 }
	}

	public void loadData() throws Exception {
		HashMap hmRecord	=	null;
		hmRecord	=	fetchRecord("SELECT mm.short_desc pack_item_desc, ss.alpha_code, ss.long_desc, ss.short_desc, ss.item_class_code, group_type, sub_classification_code,usage_type, item_anal_code, stat_group_code, def_sterile_type, def_washing_type, surgery_type, pack_item_code, pack_item_qty, pack_addl_cost, remarks, non_returnable_yn, sterilize_reqd_yn, wash_reqd_yn, pack_reqd_yn, ss.eff_status,ss.checklist_code FROM ss_group ss,mm_item mm WHERE mm.item_code(+)=ss.pack_item_code AND group_code = ?", getGroup_code());

		setLong_desc				( (String)hmRecord.get("LONG_DESC")					);
		setShort_desc				( (String)hmRecord.get("SHORT_DESC")				);
		setEff_status				( (String)hmRecord.get("EFF_STATUS")				);
		setUsage_type				( (String)hmRecord.get("USAGE_TYPE" )				);    
		setStat_group_code			( (String)hmRecord.get("STAT_GROUP_CODE" )			);
		setNon_returnable_yn		( (String)hmRecord.get("NON_RETURNABLE_YN" )		);
		setSterilize_reqd_yn		( (String)hmRecord.get("STERILIZE_REQD_YN" )		);
		setWash_reqd_yn     		( (String)hmRecord.get("WASH_REQD_YN" )		);
		setPack_reqd_yn     		( (String)hmRecord.get("PACK_REQD_YN" )		);
		setSterilize_reqd_yn		( (String)hmRecord.get("STERILIZE_REQD_YN" )		);
		setWash_reqd_yn     		( (String)hmRecord.get("WASH_REQD_YN" )		);
		setPack_reqd_yn     		( (String)hmRecord.get("PACK_REQD_YN" )		);
		setRemarks					( (String)hmRecord.get("REMARKS" )					);
		setPack_item_code			( (String)hmRecord.get("PACK_ITEM_CODE" )			);
		setPack_item_desc			( (String)hmRecord.get("PACK_ITEM_DESC" )			);
		setAlpha_code				( (String)hmRecord.get("ALPHA_CODE" )				);
		setGroup_type				( (String)hmRecord.get("GROUP_TYPE" )				);
		setDef_washing_type			( (String)hmRecord.get("DEF_WASHING_TYPE" )			);
		setSurgery_type				( (String)hmRecord.get("SURGERY_TYPE" )				);
		setItem_class_code			( (String)hmRecord.get("ITEM_CLASS_CODE" )			);
		setDef_sterile_type			( (String)hmRecord.get("DEF_STERILE_TYPE" )			);
		setItem_anal_code			( (String)hmRecord.get("ITEM_ANAL_CODE" )			);
		setPack_addl_cost			( (String)hmRecord.get("PACK_ADDL_COST" )			);
		setSub_classification_code	( (String)hmRecord.get("SUB_CLASSIFICATION_CODE" )	);
		setPack_item_qty			( (String)hmRecord.get("PACK_ITEM_QTY" )			);
		setChecklist_Code           ( (String) hmRecord.get("CHECKLIST_CODE")           );
	}

	public String paramsInBean(){
		return 
			" |Long_desc				"+	long_desc				+
			"||Group Code				"+	group_code				+
			"||Short_desc				"+	short_desc				+
			"||Eff_status				"+	eff_status				+
			"||Usage_type				"+	usage_type				+
			"||Stat_group_code			"+	stat_group_code			+
			"||Non_returnable_yn		"+	non_returnable_yn		+
			"||Remarks					"+	remarks					+
			"||Pack_item_code			"+	pack_item_code			+
			"||Alpha_code				"+	alpha_code				+
			"||Group_type				"+	group_type				+
			"||Def_washing_type			"+	def_washing_type		+
			"||Surgery_type				"+	surgery_type			+
			"||Item_class_code			"+	item_class_code			+
			"||Def_sterile_type			"+	def_sterile_type		+
			"||Item_anal_code			"+	item_anal_code			+
			"||Pack_addl_cost			"+	pack_addl_cost			+
			"||Sub_classification_code	"+	sub_classification_code	+
			"||Records_to_delete		"+	records_to_delete		+
			"||Checklist_code			"+	checklist_code		+	
			"||Pack_item_qty			"+	pack_item_qty		;	

	}

	public String[] getArray(String string, String delimeter){
		String[] stArReturn=null;
		StringTokenizer stTokens=new StringTokenizer(string,delimeter);
		stArReturn=new String[stTokens.countTokens()];
		for (int i=0 ;i<stArReturn.length ;i++ ) {
			stArReturn[i]=stTokens.nextToken();
		}
		return stArReturn;
	}

	public HashMap validate() {
		HashMap hmReturn		=	new HashMap();
		ArrayList alGroupList	=	new ArrayList();
		

		hmReturn.put(RESULT,TRUE);

		try { 
			alGroupList	=	(ArrayList)session.getAttribute("alGroupList");
			if((alGroupList.size()==0)||(getRecords_to_delete().indexOf("N")==-1)){
				hmReturn.put(MSGID,"MIN_ONE_ITEM_REQUIRED");
				throw new Exception();
			}
		}
		catch (Exception exception) {
			hmReturn.put(RESULT,FALSE);
			hmReturn.put(MESSAGE,"Exception while validating GROUP: Message:"+exception.toString());
			exception.printStackTrace();
		}
		return hmReturn;
	}

	public HashMap insert() {

		HashMap		hmTableData			=	new HashMap()	;
		ArrayList	alHdrInsertData		=	new ArrayList()	;
		ArrayList	alDtlInsertData		=	new ArrayList()	;
		ArrayList	alGroupList			=	null			;
		HashMap		hmSQLMap			=	new HashMap()	;
		HashMap		hmResult			=	new HashMap()	;
		StringTokenizer stRecordsToDel	=	new StringTokenizer(getRecords_to_delete(),",");

		alHdrInsertData.add(getGroup_code()             );
		alHdrInsertData.add(getAlpha_code()             );
		alHdrInsertData.add(getLong_desc()              );
		alHdrInsertData.add(getShort_desc()             );
		alHdrInsertData.add(getItem_class_code()        );
		alHdrInsertData.add(getGroup_type()             );
		alHdrInsertData.add(getSub_classification_code());
		alHdrInsertData.add(getUsage_type()             );
		alHdrInsertData.add(getItem_anal_code()         );
		alHdrInsertData.add(getStat_group_code()        );
		alHdrInsertData.add(getDef_sterile_type()       );
		alHdrInsertData.add(getDef_washing_type()       );
		alHdrInsertData.add(getSurgery_type()           );
		alHdrInsertData.add(getPack_item_code()         );
		alHdrInsertData.add(getPack_item_qty()          );
		alHdrInsertData.add(getPack_addl_cost()         );
		alHdrInsertData.add(getRemarks()                );
		alHdrInsertData.add(getNon_returnable_yn()      );
		alHdrInsertData.add(getSterilize_reqd_yn()      );
		alHdrInsertData.add(getWash_reqd_yn()      );
		alHdrInsertData.add(getPack_reqd_yn()      );
		alHdrInsertData.add(getEff_status()		        );
						  
		alHdrInsertData.add(getLoginById());      
		alHdrInsertData.add(getLoginAtWsNo());    
		alHdrInsertData.add(getLoginFacilityId());
		alHdrInsertData.add(getLoginById());      
		alHdrInsertData.add(getLoginAtWsNo());    
		alHdrInsertData.add(getLoginFacilityId());
		alHdrInsertData.add(getChecklist_Code());

		alGroupList	=	(ArrayList)session.getAttribute("alGroupList");
		/*alGroupList	=	(ArrayList)session.getAttribute("alCheckList");*/
        System.out.println("Bean Value alGroupList"+alGroupList);
		for (int i=0;i<alGroupList.size() ;i++ ) {
			if(stRecordsToDel.nextToken().equals("N")){
			HashMap	hmRecord	=(HashMap)	alGroupList.get(i);
				hmRecord.remove("MADATORY_ITEM_YN");
				alDtlInsertData.add(hmRecord);		
			}
		}

		hmSQLMap.put( "HdrInsertSQL", "INSERT INTO ss_group(group_code, alpha_code, long_desc, short_desc, item_class_code, group_type, sub_classification_code, usage_type, item_anal_code, stat_group_code, def_sterile_type, def_washing_type, surgery_type, pack_item_code, pack_item_qty, pack_addl_cost, remarks, non_returnable_yn, sterilize_reqd_yn, wash_reqd_yn, pack_reqd_yn, eff_status, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,checklist_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?,?)");
		hmSQLMap.put( "DtlInsertSQL", getSsRepositoryValue("SQL_SS_ITEM_FOR_GROUP_INSERT")		);
         System.out.println("Bean Value alDtlInsertData"+alDtlInsertData); 
         System.out.println("Bean Value alHdrInsertData"+alHdrInsertData); 
		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "HdrInsertData",		alHdrInsertData	);
		hmTableData.put( "DtlInsertData",		alDtlInsertData	);


/*EJB Call starts*/
		GroupRemote	groupRemote		= null ;
		hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;

		try {
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(SsRepository.getSsKeyValue("JNDI_SS_GROUP"),GroupHome.class,getLocalEJB());
			
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();
           

			hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


			if( ((Boolean) hmResult.get(RESULT)).booleanValue() )	
				hmResult.put( MESSAGE, replaceNewLineChar(getMessage(getLanguageId(),(String) hmResult.get( MESSAGE ),"SS") )) ;
			else if( hmResult.get(MSGID)!=null  )
				hmResult.put( MESSAGE, replaceNewLineChar(getMessage(getLanguageId(),(String) hmResult.get( MSGID ),"Common") )) ;
			else
				hmResult.put( MESSAGE, replaceNewLineChar((String)hmResult.get(MESSAGE)) ) ;
		} 
		catch(Exception exception) {
			hmResult.put( MESSAGE, exception.getMessage()) ;
			exception.printStackTrace() ;
		} 
		finally {
			try {
				if( groupRemote != null )
					groupRemote.remove() ;
			}
			catch( Exception exception) {
				hmResult.put( MESSAGE, exception.toString()) ;
			}
		}
/*EJB Call ends*/
		return hmResult;
	}

	public HashMap modify() {

		HashMap		hmTableData			=	new HashMap()	;
		ArrayList	alHdrModifyData		=	new ArrayList()	;
		ArrayList	alDtlModifyData		=	new ArrayList()	;
		ArrayList	alGroupList			=	null			;
		HashMap		hmSQLMap			=	new HashMap()	;
		HashMap		hmResult			=	new HashMap()	;

		StringTokenizer stRecordsToDel	=	new StringTokenizer(getRecords_to_delete(),",");

		alHdrModifyData.add(getAlpha_code()             );
		alHdrModifyData.add(getLong_desc()              );
		alHdrModifyData.add(getShort_desc()             );
		alHdrModifyData.add(getItem_class_code()        );
		alHdrModifyData.add(getGroup_type()             );
		alHdrModifyData.add(getSub_classification_code());
		alHdrModifyData.add(getUsage_type()             );
		alHdrModifyData.add(getItem_anal_code()         );
		alHdrModifyData.add(getStat_group_code()        );
		alHdrModifyData.add(getDef_sterile_type()       );
		alHdrModifyData.add(getDef_washing_type()       );
		alHdrModifyData.add(getSurgery_type()           );
		alHdrModifyData.add(getPack_item_code()         );
		alHdrModifyData.add(getPack_item_qty()          );
		alHdrModifyData.add(getPack_addl_cost()         );
		alHdrModifyData.add(getRemarks()                );
		alHdrModifyData.add(getNon_returnable_yn()      );
		alHdrModifyData.add(getSterilize_reqd_yn()      );
		alHdrModifyData.add(getWash_reqd_yn     ()      );
		alHdrModifyData.add(getPack_reqd_yn     ()      );
		alHdrModifyData.add(getEff_status()		        );
						  
		alHdrModifyData.add(getLoginById());      
		alHdrModifyData.add(getLoginAtWsNo());    
		alHdrModifyData.add(getLoginFacilityId());

		alHdrModifyData.add(getGroup_code()             );

		

		alGroupList	=	(ArrayList)session.getAttribute("alGroupList");
        System.out.println("alGroupList Modify Mode"+alGroupList);
		for (int i=0;i<alGroupList.size() ;i++ ) {
			HashMap hmRecord	=	(HashMap)alGroupList.get(i);
			if(stRecordsToDel.nextToken().equals("Y")){
				if( hmRecord.get("MODE").toString().equals(getCommonRepositoryValue("MODE_INSERT"))) 
					continue;
				else
					hmRecord.put("MODE",getCommonRepositoryValue("MODE_DELETE"));
			}
			alDtlModifyData.add(hmRecord);		
		}

		
		hmSQLMap.put( "HdrModifySQL", getSsRepositoryValue("SQL_SS_GROUP_UPDATE")	);
		hmSQLMap.put( "DtlModifySQL", getSsRepositoryValue("SQL_SS_ITEM_FOR_GROUP_UPDATE")		);
		hmSQLMap.put( "DtlInsertSQL", getSsRepositoryValue("SQL_SS_ITEM_FOR_GROUP_INSERT")		);
		hmSQLMap.put( "DtlDeleteSQL", getSsRepositoryValue("SQL_SS_ITEM_FOR_GROUP_DELETE")		);

		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "HdrModifyData",		alHdrModifyData	);
		hmTableData.put( "DtlModifyData",		alDtlModifyData	);
		GroupRemote	groupRemote		= null ;
		hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;

		try {
			

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(SsRepository.getSsKeyValue("JNDI_SS_GROUP"),GroupHome.class,getLocalEJB());
			
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();
           

			hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);







			if( ((Boolean) hmResult.get(RESULT)).booleanValue() )	
				hmResult.put( MESSAGE, replaceNewLineChar(getMessage(getLanguageId(),(String) hmResult.get( MSGID ),"SS") )) ;
			else if( hmResult.get(MSGID)!=null  )
				hmResult.put( MESSAGE, replaceNewLineChar(getMessage(getLanguageId(),(String) hmResult.get( MSGID ),"Common") )) ;
			else
				hmResult.put( MESSAGE, replaceNewLineChar((String)hmResult.get(MSGID)) ) ;
		} 
		catch(Exception exception) {
			hmResult.put( MESSAGE, exception.getMessage()) ;
			exception.printStackTrace() ;
		} 
		finally {
			try {
				if( groupRemote != null )
					groupRemote.remove() ;
			}
			catch( Exception exception) {
				hmResult.put( MESSAGE, exception.toString()) ;
			}
		}

		return hmResult;
	}
}
