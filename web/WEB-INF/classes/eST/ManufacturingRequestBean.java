/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;
import java.util.*;
import java.io.*;
import javax.servlet.http.*;
import javax.rmi.* ;
import javax.naming.* ;
import eST.Common.* ;
import eCommon.Common.*;
import java.sql.* ;
//import eCommon.Common.CommonEJBSessionInterface;
import eST.ManufacturingRequest.*;


public class ManufacturingRequestBean extends StTransaction implements Serializable { 
	private String child_item_code;
	private String item_code;
	private String short_desc;
	private String component_qty;
	private String mfg_uom;
	private String req_type;
	//private String prep_type;
	private String prep_mode;
	private String prep_loc;
	private String req_store;
	private String req_qty;
	private String patient_name;
	private String remarks;
	private String patient_id;
	private String encounter_id;
	private String stock_uom;
	private String stock_label;
	private String Item_desc;
	private String extemp_item_seq;
	private String checkBoxVals;
//	private HttpSession session;
	private ArrayList DataList=new ArrayList() ;
	private ArrayList DataRecordList=new ArrayList() ;
//	private String language;
	public int seq_no;

	public int getSeqNo(){
		 String seqNo=getExtempItem();
		 seq_no=Integer.parseInt(seqNo);
		 return seq_no;
	}

/*	public void setLanguageId(String language)
	{
		this.language=language;
	}

	public String getLanguageId()
	{
		return language;
	}
	*/
	public void setDataList(ArrayList DataList) {
		 this.DataList = DataList;
	}

	public ArrayList getDataList( ) {
		 return DataList;
	}

	public void setDataRecordList(ArrayList DataRecordList) {
		 this.DataRecordList = DataRecordList;
	}

	public ArrayList getDataRecordList( ) {
		 return DataRecordList;
	}

	public void setItem_code(String item_code) {
		 this.item_code = checkForNull(item_code);
	}

	public String getItem_code( ) {
		 return item_code;
	}

	public void setItem_desc(String Item_desc) {
		 this.Item_desc = checkForNull(Item_desc);
	}

	public String getItem_desc( ) {
		 return Item_desc;
	}
	
	public void setChild_item_code(String child_item_code) {
		 this.child_item_code = checkForNull(child_item_code);
	}

	public String getChild_item_code( ) {
		 return child_item_code;
	}

	public void setShort_desc(String short_desc) {
		 this.short_desc = checkForNull(short_desc);
	}

	public String getShort_desc( ) {
		 return short_desc;
	}

	public void setComponent_qty(String component_qty) {
		 this.component_qty = checkForNull(component_qty);
	}

	public String getComponent_qty( ) {
		 return component_qty;
	}
	
	public void setExtemp_item_seq(String extemp_item_seq) {
		 this.extemp_item_seq = extemp_item_seq;
	}

	public String getExtemp_item_seq( ) {
		 return extemp_item_seq;
	}

	

	public void setReq_store(String req_store) {
		 this.req_store = req_store;
	}

	public String getReq_store( ) {
		 return req_store;
	}

	public void setReq_qty(String req_qty) {
		 this.req_qty = checkForNull(req_qty);
	}

	public String getReq_qty( ) {
		 return req_qty;
	}

	public void setReq_type(String req_type) {
		 this.req_type = checkForNull(req_type);
	}

	public String getReq_type( ) {
		 return req_type;
	}

	public void setPrep_loc(String prep_loc) {
		 this.prep_loc = prep_loc;
	}

	public String getPrep_loc( ) {
		 return prep_loc;
	}

	public void setMfg_uom(String mfg_uom) {
		 this.mfg_uom = checkForNull(mfg_uom);
	}

	public String getMfg_uom( ) {
		 return mfg_uom;
	}

	public void setStock_uom(String stock_uom) {
		 this.stock_uom = checkForNull(stock_uom);
	}

	public String getStock_uom( ) {
		 return stock_uom;
	}

	public void setPrep_mode(String prep_mode) {
		 this.prep_mode = checkForNull(prep_mode);
	}

	public String getPrep_mode( ) {
		 return prep_mode;
	}

	
	public void setPatient_id(String patient_id) {
		 this.patient_id = checkForNull(patient_id);
	}

	public String getPatient_id( ) {
		 return patient_id;
	}

	public void setPatient_name(String patient_name) {
		 this.patient_name = checkForNull(patient_name);
	}

	public String getPatient_name( ) {
		 return patient_name;
	}

	public void setEncounter_id(String encounter_id) {
		 this.encounter_id = checkForNull(encounter_id);
	}

	public String getEncounter_id( ) {
		 return encounter_id;
	}
	public void setStock_label(String stock_label) {
		 this.stock_label = checkForNull(stock_label);
	}

	public String getStock_label( ) {
		 return stock_label;
	}

	public void setRemarks(String remarks) {
		 this.remarks = checkForNull(remarks);
	}

	public String getRemarks( ) {
		 return remarks;
	}


	public void setCheckBoxVals(String checkBoxVals) {
		 this.checkBoxVals = checkForNull(checkBoxVals);
	}

	public String getCheckBoxVals( ) {
		 return checkBoxVals;
	}

	public void setAll( Hashtable recordSet){
		setItem_code((String)recordSet.get("item_code"));
		setReq_store((String)recordSet.get("req_store"));
		setReq_qty((String)recordSet.get("req_qty"));
		setPrep_loc((String)recordSet.get("prep_loc"));
		setReq_type((String)recordSet.get("req_type"));
		setPrep_mode((String)recordSet.get("prep_mode"));
		setPatient_id((String)recordSet.get("patient_id"));
		setPatient_name((String)recordSet.get("patient_name"));
		setEncounter_id((String)recordSet.get("encounter_id"));
		setRemarks((String)recordSet.get("remarks"));
		setCheckBoxVals((String)recordSet.get("checkBoxVals"));
	}

	 public HashMap validate(){
        HashMap hashmap = new HashMap();
        //ArrayList arraylist = new ArrayList();
        hashmap.put("result", super.TRUE);
        return hashmap;
    }
public void initialize(){
        super.initialize();
         child_item_code="";
		 item_code="";
		 short_desc="";
		 Item_desc="";
		 component_qty="";
		 mfg_uom="";
		// prep_type="";
		 prep_mode="";
		 checkBoxVals="";
		 req_type="";
		 seq_no=0;
		 DataList.clear();
		 DataRecordList.clear();
		 prep_loc = "";
	}
	public void clear(){
		 super.clear();
         child_item_code=null;
		 item_code=null;
		 short_desc=null;
		 Item_desc=null;
		 component_qty=null;
		 mfg_uom=null;
		// prep_type=null;
		 prep_mode=null;
		 checkBoxVals=null;
		 req_type=null;
		 seq_no=0;
		 DataList.clear();
		 DataRecordList.clear();
    }	

	 public HashMap insert()
    {
        HashMap hashmap = new HashMap();
        HashMap hashmapQry = new HashMap();
       // ArrayList arraylist = null;
//        ArrayList arraylistUpdate = null;
        ArrayList arraylistUpdateData = new ArrayList();
        ArrayList arraylistHdrData = new ArrayList();
       // ArrayList arraylistHdrUpdate = new ArrayList();
        ArrayList arraylistDtlData = new ArrayList();
        ArrayList arraylistDtlUpdateData = new ArrayList();
//        ArrayList arraylistDtl= null;
//        ArrayList arraylistDtlUpdate= null;
//        ArrayList arraylistDelete= null;
        ArrayList arraylistDtlDelete= new ArrayList();
//		ArrayList arraylistHdrDelete= null;
        ArrayList arraylistHdrDeleteRows= new ArrayList();

//		 HashMap hmSQLMap		=	new HashMap();
//		HashMap hmTableData		=	new HashMap();
//		ArrayList alHdrData		=	new ArrayList();
//		ArrayList alDtlData		=	new ArrayList();
//		ArrayList alExpData		=	new ArrayList();
//		ArrayList alCommonData	=	new ArrayList();
		HashMap hmCommonData	=	new HashMap();
		ArrayList languageData	=	new ArrayList();//Added By Sakti Sankar against Inc#34852 on 19/09/2012

      try{
		
		StringTokenizer stringtokenizer = new StringTokenizer(getCheckBoxVals(), ",");
	
		 for(int i = 0; i < DataRecordList.size(); i++)
        {
			 HashMap hashmapHdr = (HashMap)DataRecordList.get(i);
			 
			 if(((String)hashmapHdr.get("DATATYPE")).equals("ND")){
				  if(stringtokenizer.nextToken().equals("N")){
					hashmapHdr.put("mode","1");
					hashmapHdr.put("requesting_store_code",(String)hashmapHdr.get("REQUESTING_STORE_CODE"));
					hashmapHdr.put("prepare_location_code",(String)hashmapHdr.get("PREPARE_LOCATION_CODE"));
					hashmapHdr.put("preparation_type",(String)hashmapHdr.get("PREPARATION_TYPE"));
					hashmapHdr.put("preparation_mode",(String)hashmapHdr.get("PREPARATION_MODE"));
					hashmapHdr.put("item_code",(String)hashmapHdr.get("ITEM_CODE"));
					hashmapHdr.put("request_qty",(String)hashmapHdr.get("REQUEST_QTY"));
					hashmapHdr.put("patient_id",checkForNull((String)hashmapHdr.get("PATIENT_ID")));
					hashmapHdr.put("encounter_id",checkForNull((String)hashmapHdr.get("ENCOUNTER_ID")));
					hashmapHdr.put("index",(String)hashmapHdr.get("MFG_REQUEST_NO"));
					hashmapHdr.put("item_desc",checkForNull((String)hashmapHdr.get("REMARKS")));
					arraylistHdrData.add(hashmapHdr);
				  }
			 }
			 else{
				  if(stringtokenizer.nextToken().equals("N")){
						hashmapHdr.put("mode","2");
						hashmapHdr.put("requesting_store_code",(String)hashmapHdr.get("REQUESTING_STORE_CODE"));
						hashmapHdr.put("prepare_location_code",(String)hashmapHdr.get("PREPARE_LOCATION_CODE"));
						hashmapHdr.put("preparation_type",(String)hashmapHdr.get("PREPARATION_TYPE"));
						hashmapHdr.put("preparation_mode",(String)hashmapHdr.get("PREPARATION_MODE"));
						hashmapHdr.put("request_qty",(String)hashmapHdr.get("REQUEST_QTY"));
						hashmapHdr.put("patient_id",checkForNull((String)hashmapHdr.get("PATIENT_ID")));
						hashmapHdr.put("encounter_id",checkForNull((String)hashmapHdr.get("ENCOUNTER_ID")));
						hashmapHdr.put("item_desc",checkForNull((String)hashmapHdr.get("REMARKS")));
						hashmapHdr.put("mfg_request_no",(String)hashmapHdr.get("MFG_REQUEST_NO"));
						arraylistUpdateData.add(hashmapHdr);
				  }
				  else{
						hashmapHdr.put("mode","0");
						HashMap hashmapdel=new HashMap();
						hashmapdel.put("mfg_request_no",(String)hashmapHdr.get("MFG_REQUEST_NO"));
						arraylistHdrDeleteRows.add(hashmapdel);
				  }
			 }
		}

		
        for(int i = 0; i < DataList.size(); i++)
        {				 
            HashMap hashmapDtl = (HashMap)DataList.get(i);
             if(((String)hashmapDtl.get("SELECTED")).equals("N")){
				 if(((String)hashmapDtl.get("DATATYPE")).equals("ND")){
					hashmapDtl.put("mode","1");
					hashmapDtl.put("index",(String)hashmapDtl.get("MFG_REQUEST_NO"));
					hashmapDtl.put("child_item_code",(String)hashmapDtl.get("CHILD_ITEM_CODE"));
					hashmapDtl.put("component_qty",(String)hashmapDtl.get("COMPONENT_QTY"));
					hashmapDtl.put("mfg_uom_code",(String)hashmapDtl.get("MFG_UOM_CODE"));
					arraylistDtlData.add(hashmapDtl);
				 }
				 else{
					 hashmapDtl.put("mode","2");
					 hashmapDtl.put("component_qty",(String)hashmapDtl.get("COMPONENT_QTY"));
					 hashmapDtl.put("mfg_uom_code",(String)hashmapDtl.get("MFG_UOM_CODE"));
					 hashmapDtl.put("mfg_request_no",(String)hashmapDtl.get("MFG_REQUEST_NO"));
				 	 hashmapDtl.put("child_item_code",(String)hashmapDtl.get("CHILD_ITEM_CODE"));
					 arraylistDtlUpdateData.add(hashmapDtl);
				 }
			 }
			 else{	
				 if(!((String)hashmapDtl.get("DATATYPE")).equals("ND")){
					  hashmapDtl.put("mode","0");
					  hashmapDtl.put("mfg_request_no",(String)hashmapDtl.get("MFG_REQUEST_NO"));
					  hashmapDtl.put("child_item_code",(String)hashmapDtl.get("CHILD_ITEM_CODE"));
					  arraylistDtlDelete.add(hashmapDtl);
				 }
			 }
	     }
		languageData.add(getLanguageId()); //Added By Sakti Sankar against Inc#34852 on 19/09/2012
		hmCommonData.put("login_by_id",getLoginById()			);
		hmCommonData.put("login_at_ws_no",getLoginAtWsNo()		);
		hmCommonData.put("login_facility_id",getLoginFacilityId()	);

        hashmap.put("properties", getProperties());
        hashmap.put("HdrInsertData", arraylistHdrData);
        hashmap.put("DtlInsertData", arraylistDtlData);
		hashmap.put("HdrUpdateData", arraylistUpdateData);
        hashmap.put("DtlUpdateData", arraylistDtlUpdateData);
        hashmap.put("DtlDeleteData", arraylistDtlDelete);
        hashmap.put("HdrDtlDeleteData", arraylistHdrDeleteRows);
        hashmap.put("CommonData", hmCommonData);
		hashmap.put("LANGUAGE_DATA", languageData);//Added By Sakti Sankar against Inc#34852 on 19/09/2012

	}
	catch (Exception e){
		e.printStackTrace();
	}
        return methodCall(hashmap, hashmapQry, 1);
    }
	
	 public HashMap methodCall(HashMap hashmap, HashMap hashmapQuery,int mode )
    {
        HashMap hashmapResult = new HashMap();
		//hashmapResult = new eST.ManufacturingRequest2.ManufacturingRequestManager().insert(hashmap, hashmapQuery);
       try
        {
           // ManufacturingRequestRemote manufacturingRequestremote = null;
           // ManufacturingRequestHome manufacturingRequestHome = null;

          /*  InitialContext initialcontext = new InitialContext();
            Object obj = initialcontext.lookup(getStRepositoryValue("JNDI_ST_MANUFACTURING_REQUEST"));
            manufacturingRequestHome = (ManufacturingRequestHome)PortableRemoteObject.narrow(obj, ManufacturingRequestHome.class);
            manufacturingRequestremote = manufacturingRequestHome.create();
		    hashmapResult = manufacturingRequestremote.insert(hashmap, hashmapQuery);*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_MANUFACTURING_REQUEST"),ManufacturingRequestHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hashmap;
			argArray[1] = hashmapQuery;

			Class [] paramArray = new Class[2];
			paramArray[0] = hashmap.getClass(); ;
			paramArray[1] = hashmapQuery.getClass();

			 hashmapResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


        }

        catch(Exception exception) { exception.printStackTrace();}
        if(((Boolean)hashmapResult.get("result")).booleanValue())
            hashmapResult.put("message", getSTMessage(getLanguageId(),(String) hashmapResult.get( "msgid" ),"ST") ) ;
        else
        if(hashmapResult.get("msgid") != null)
            hashmapResult.put("message", getSTMessage(getLanguageId(),(String) hashmapResult.get( "msgid" ),"ST") ) ;
        else
            hashmapResult.put("message", replaceNewLineChar((String)hashmapResult.get("message")));
		hashmapResult.put("flag",hashmapResult.get("flag"));//Added By Sakti Sankar against Inc#34852 on 19/09/2012 

        return hashmapResult;
    }


	public String getRequestType(){
			return getStaticListOptionTag("A,All;P,Pre packing;S,Standard Formulary ;E,Extemporaneous ;O,Others",getReq_type());
	}
	public String getReqType(){
			return getStaticListOptionTag("A, -------- Select -------- ;P,Pre packing;S,Standard Formulary ;E,Extemporaneous ;O,Others",getReq_type());
	}

	public String getPrepLoc()
	{
       String [] params={getLoginFacilityId(),getLanguageId()};
	   ArrayList s1=new ArrayList();
	   s1=getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_MAN_REQ_PRELOC_SELECT"),params);
       String retVal=getListOptionTag(s1,getPrep_loc());
	   return retVal;
	}
	public String getPrepMode(){
			return getStaticListOptionTag("A,All;S,Sterile;N,Non Sterile ;O,Others ;",getPrep_mode());
	}
	public String getPreperationMode(){
			return getStaticListOptionTag("A, -------- Select --------;S,Sterile;N,Non Sterile ;O,Others ;",getPrep_mode());
	}
	public String getRequestStore(){
		String [] params={getLoginFacilityId(),getLoginById(),getLanguageId()};
		
		String retVal=getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_MAN_REQ_STORE_SELECT"),params),getReq_store());
		return retVal;
		//getListOptionTag(getListOptionArrayList(StRepository.getStKeyValue("SQL_ST_MAN_REQ_STORE_SELECT"),params),getReq_store());
	}
	public String getMfgUom(){
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_ASM_DTL_MFG_UOM_LIST"),getLanguageId()),getMfg_uom());
	}

	//added here on 22.07.2005
	/*	public  String getpatlength{
			HashMap hmResult =new HashMap();
		try {
			hmResult = fetchRecord(getStRepositoryValue("SQL_ST_PATIENT_ID_LENGTH"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return (String)hmResult.get("PATIENT_ID_LENGTH").toString();
	} */
	

	public String getpatlength () //throws Exception
		{ 
		String patient_id_length ;
		try {
				String stSQL=getStRepositoryValue("SQL_ST_PATIENT_ID_LENGTH");
				patient_id_length = fetchRecord(stSQL.toString()).get("PATIENT_ID_LENGTH").toString();
				return patient_id_length;
			} catch ( Exception e )	{
				e.printStackTrace() ;
				//throw e ;
			} 
			return null;
	}


	public void setValForArrayList(Hashtable hash,String stock_uom,String mfg_desc ){
		HashMap hmRecord=new HashMap();
		hmRecord.put("CHILD_ITEM_CODE",(String)hash.get("child_item_code") );
		hmRecord.put("COMPONENT_QTY",(String)hash.get("component_qty") );
		hmRecord.put("SHORT_DESC",(String)hash.get("child_item_code_desc") );
		hmRecord.put("MFG_UOM_CODE",(String)hash.get("mfg_uom") );
		hmRecord.put("STOCK_UOM", stock_uom);
		hmRecord.put("MFG_DESC",mfg_desc);
		hmRecord.put("UOM_CODE",(String)hash.get("uom_code") );
		hmRecord.put("MFG_REQUEST_NO",(String)hash.get("extemp_item_seq") );
		hmRecord.put("DATATYPE","ND" );
		hmRecord.put("SELECTED","N" );
		DataList.add(hmRecord);
	}

	public void setValForArrayListModify(Hashtable hash,String stock_uom,String mfg_desc,int index ){
		HashMap hmRecord	=	(HashMap)DataList.get(index);
		hmRecord.put("CHILD_ITEM_CODE",(String)hash.get("child_item_code") );
		hmRecord.put("COMPONENT_QTY",(String)hash.get("component_qty") );
		hmRecord.put("SHORT_DESC",(String)hash.get("child_item_code_desc") );
		hmRecord.put("MFG_UOM_CODE",(String)hash.get("mfg_uom") );
		hmRecord.put("MFG_DESC",mfg_desc);
		hmRecord.put("STOCK_UOM", stock_uom);
		hmRecord.put("UOM_CODE",(String)hash.get("uom_code") );
		DataList.set(index,hmRecord);
	}

	public String getExtempItem () //throws Exception
		{ 
		String req_extemp_item_seq ;
		try {
				String stSQL=getStRepositoryValue("SQL_ST_MAN_REQ_MFG_REQUEST_NO");
				req_extemp_item_seq = fetchRecord(stSQL.toString()).get("ITEM_SEQ").toString();
				return req_extemp_item_seq;
			} catch ( Exception e )	{
				e.printStackTrace() ;
				//throw e ;
			} 
			return null;
	}

	public ArrayList getEncounterData () throws Exception{ 
		ArrayList encounter=new ArrayList() ;
		String alParams[]={getLoginFacilityId(),getPatient_id()};
		try {
				String stSQL=getStRepositoryValue("SQL_ST_MAN_REQ_ENCOUNTER_SELECT_LIST_1");
				encounter = fetchRecords(stSQL.toString(),alParams);
				return encounter;
			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} 
	}
	
	 public String getPatientName()
    {
        try
        {
            HashMap hashmap = fetchRecord(getStRepositoryValue("SQL_ST_MAN_REQ_PATIENT_SELECT_SINGLE"), getPatient_id());
            return (String)hashmap.get("PATIENT_NAME");
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }

	public void getAssemblyDtlData () throws Exception{ 
		ArrayList listRecord=new ArrayList();
		String [] alParameters={"E",getReq_store(),getPrep_loc(),getReq_type(),getPrep_mode(),"0","99999","01/01/1901","31/12/3012",getLanguageId(),getLanguageId(),getLanguageId(),getLanguageId(),getLoginFacilityId()};
		for(int i=0; i<alParameters.length; i++){
		}
		try {
				String stSQL=getStRepositoryValue("SQL_ST_MAN_REQ_HDR_RESULT");
				listRecord = fetchRecords(stSQL.toString(),alParameters);
				DataRecordList=listRecord;
		} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
		} 
	}

	public void getDtlData () throws Exception{ 
		ArrayList listRecord=new ArrayList();
		String [] alParameters={getLanguageId(),getLanguageId(),getLanguageId()};
		try {
				String stSQL=getStRepositoryValue("SQL_ST_MAN_REQ_DTL_RESULT");
				listRecord = fetchRecords(stSQL.toString(),alParameters);
				DataList=listRecord;
				//return listRecord;
		} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
		} 
	}

	public void loadHdrData(Hashtable hash,String stock_uom,String patient_name ){
		HashMap hmRecord=new HashMap();
		hmRecord.put("ENCOUNTER_ID",checkForNull((String)hash.get("encounter_id")) );
		hmRecord.put("PATIENT_ID",checkForNull((String)hash.get("patient_id")) );
		hmRecord.put("SHORT_DESC",(String)hash.get("item_code_desc") );
		hmRecord.put("ITEM_CODE",(String)hash.get("item_code") );
		hmRecord.put("STOCK_UOM", stock_uom);
		hmRecord.put("PREPARE_LOCATION_CODE",(String)hash.get("prep_loc") );
		hmRecord.put("REQUESTING_STORE_CODE",(String)hash.get("req_store") );
		hmRecord.put("PREPARATION_MODE",(String)hash.get("prep_mode") );
		hmRecord.put("MFG_REQUEST_NO",""+seq_no );
		hmRecord.put("PREPARATION_TYPE",(String)hash.get("req_type") );
		hmRecord.put("REQUEST_QTY",(String)hash.get("req_qty") );
		hmRecord.put("DATATYPE","ND" );
		hmRecord.put("SELECTED","N" );
		hmRecord.put("PATIENT_NAME",patient_name );
		hmRecord.put("REMARKS",checkForNull((String)hash.get("remarks") ));
		DataRecordList.add(hmRecord);
		seq_no++;
		setExtemp_item_seq(""+seq_no);
	}

	public void setLoadHdrData(Hashtable hash,String stock_uom ,int index,String patient_name){
		HashMap hmRecord	=	(HashMap)DataRecordList.get(index);
		hmRecord.put("ENCOUNTER_ID",checkForNull((String)hash.get("encounter_id")) );
		hmRecord.put("PATIENT_ID",checkForNull((String)hash.get("patient_id")) );
		hmRecord.put("SHORT_DESC",(String)hash.get("item_code_desc") );
		hmRecord.put("ITEM_CODE",(String)hash.get("item_code") );
		hmRecord.put("STOCK_UOM", stock_uom);
		hmRecord.put("PREPARE_LOCATION_CODE",(String)hash.get("prep_loc") );
		hmRecord.put("REQUESTING_STORE_CODE",(String)hash.get("req_store") );
		hmRecord.put("PREPARATION_MODE",(String)hash.get("prep_mode") );
		hmRecord.put("PREPARATION_TYPE",(String)hash.get("req_type") );
		hmRecord.put("REQUEST_QTY",(String)hash.get("req_qty") );
		hmRecord.put("PATIENT_NAME",patient_name );
		hmRecord.put("REMARKS",checkForNull((String)hash.get("remarks") ));
		DataRecordList.set(index,hmRecord);
	}

	public void  setCheckBox(String itemCode,String seq_no,String checkVals){
			for	(int i	=0;	i<DataList.size();i++){
			HashMap hmRecord	=(HashMap)	DataList.get(i);
			if(((String)hmRecord.get("MFG_REQUEST_NO")).equals(seq_no)){
				StringTokenizer stringtokenizerIc = new StringTokenizer(itemCode, ",");
				for (; stringtokenizerIc.hasMoreElements();) {
					if((stringtokenizerIc.nextToken()).equals((String)hmRecord.get("CHILD_ITEM_CODE"))){
						hmRecord.put("SELECTED", "Y");
						DataList.set(i,hmRecord);
						break;
					}
				}
				StringTokenizer stringtokenizerCv = new StringTokenizer(checkVals, ",");
				for (; stringtokenizerCv.hasMoreElements();) {
					if((stringtokenizerCv.nextToken()).equals((String)hmRecord.get("CHILD_ITEM_CODE"))){
						hmRecord.put("SELECTED", "N");
						DataList.set(i,hmRecord);
						break;
					}
				}
			}
		}
	}

	public String getEncounter_id_List(){
		String stParameters[]={getLoginFacilityId(),getPatient_id()};
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_MAN_REQ_ENCOUNTER_SELECT_LIST_1"), stParameters),getEncounter_id());
	}

	public  HashMap checkAssemblydtl(String item_code){
		try
        {
		    HashMap hashmap = fetchRecord(getStRepositoryValue("SQL_ST_MAN_REQ_CHECK_ASSEMB_DTL"), item_code);
            return hashmap;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
	}
	
}
