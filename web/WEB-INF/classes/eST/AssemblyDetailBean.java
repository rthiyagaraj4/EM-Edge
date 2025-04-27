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
import java.sql.*;
import javax.servlet.http.*;
import javax.rmi.* ;
import javax.naming.* ;
import eST.Common.* ;
import eCommon.Common.*;
//import eCommon.Common.CommonEJBSessionInterface;
import eST.AssemblyDetail.*;



public class AssemblyDetailBean extends StAdapter implements Serializable { 
	private String child_item_code;
	private String item_code;
	private String short_desc;
	private String component_qty;
	private String mfg_uom;
	private String base_qty;
	private String prep_type;
	private String prep_mode;
	private String label_type;
	private String process_cost;
	private String component;
	private String mandatory;
	private String Conv_factor;
	private String stock_uom;
	private String Item_desc;
	private String checkBoxVals;
	private String manufactur_instructions;
	private String printonlabel1;
	private String printonlabel;
	//private String language_id;
	private String mfgInstruction;
	private String manufactur_instructions1;
	private HttpSession session;
	private ArrayList DataList;
	private ArrayList DataModifyList;
	private String td_sale_stk_uom_conv_rule;
	private String shelf_life_value;  //Added for ML-MMOH-CRF-1909
    private String shelf_life_flag;   //Added for ML-MMOH-CRF-1909
            
    //Added for ML-MMOH-CRF-1909 starts
       public String getShelfLifeFlag() {
                    return shelf_life_flag;
            }
            public String setShelfLifeFlag(String shelf_life_flag) {
                    return(this.shelf_life_flag = checkForNull(shelf_life_flag));
            }
            
            public String getShelfLifeValue() {
                    return shelf_life_value;
            }
            public String setShelfLifeValue(String  shelf_life_value) {
                    return(this.shelf_life_value = checkForNull(shelf_life_value));
                    
            }
            //Added for ML-MMOH-CRF-1909 ends      
	
	public void setDataList(ArrayList DataList) {
		 this.DataList = DataList;
	}

	public ArrayList getDataList( ) {
		 return DataList;
	}

	public void setDataModifyList(ArrayList DataModifyList) {
		 this.DataModifyList = DataModifyList;
	}

	public ArrayList getDataModifyList( ) {
		 return DataModifyList;
	}

	public void setItem_code(String item_code) {
			 this.item_code = checkForNull(item_code);
	}

	public String getItem_code( ) {
		 return item_code;
	}
	
/*	public void setLanguageId (String language_id)
	{
		this.language_id = language_id;
	}
		public String getLanguageId() 
	{
		return this.language_id;
	}*/
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

	

	public void setComponent(String component) {
		 this.component = checkForNull(component,"N");
	}

	public String getComponent( ) {
		 return component;
	}

	public void setComponent_qty(String component_qty) {
		 this.component_qty = checkForNull(component_qty);
	}

	public String getComponent_qty( ) {
		 return component_qty;
	}

	public void setMandatory(String mandatory) {
		 this.mandatory = checkForNull(mandatory,"N");
	}

	public String getMandatory( ) {
		 return mandatory;
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

	public void setConv_factor(String Conv_factor) {
		 this.Conv_factor = checkForNull(Conv_factor);
	}

	public String getConv_factor( ) {
		 return Conv_factor;
	}


	public void setTd_sale_stk_uom_conv_rule(String td_sale_stk_uom_conv_rule) {
		 this.td_sale_stk_uom_conv_rule = checkForNull(td_sale_stk_uom_conv_rule);
	}

	public String getTd_sale_stk_uom_conv_rule( ) {
		 return td_sale_stk_uom_conv_rule;
	}
	
	public void setBase_qty(String base_qty) {
		 this.base_qty = checkForNull(base_qty);
	}

	public String getBase_qty( ) {
		 return base_qty;
	}

	public void setPrep_type(String prep_type) {
		 this.prep_type = checkForNull(prep_type);
	}

	public String getPrep_type( ) {
		 return prep_type;
	}

	public void setPrep_mode(String prep_mode) {
		 this.prep_mode = checkForNull(prep_mode);
	}

	public String getPrep_mode( ) {
		 return prep_mode;
	}
	public void setLabel_Type(String label_type) {
		 this.label_type = checkForNull(label_type);
	}

	public String getLabel_Type( ) {
		 return checkForNull(label_type);
	}
	
	public void setProcess_cost(String process_cost) {
		 this.process_cost = checkForNull(process_cost);
	}

	public String getProcess_cost( ) {
		 return process_cost;
	}

	public void setCheckBoxVals(String checkBoxVals) {
		 this.checkBoxVals = checkForNull(checkBoxVals);
	}

	public String getCheckBoxVals( ) {
		 return checkBoxVals;
	}

	public void setSession(HttpSession session) {
		 this.session = session;
	}


	public void setInstruction(String instruction){
	     this.mfgInstruction =checkForNull( instruction);

    }

	public String getInstruction(){
		return checkForNull(mfgInstruction);
	}

	/*public Session getSession( ) {
		 return session;
	}*/
	
	
	public void setAll( Hashtable recordSet){
		setItem_code((String)recordSet.get("item_code"));
		setBase_qty((String)recordSet.get("base_qty"));
		setPrep_type((String)recordSet.get("prep_type"));
		setPrep_mode((String)recordSet.get("prep_mode"));
		setLabel_Type((String)recordSet.get("label_type"));
		setProcess_cost((String)recordSet.get("process_loss"));
		setCheckBoxVals((String)recordSet.get("checkBoxVals"));
		setShelfLifeValue((String)recordSet.get("shelfLifeValue1"));//ML-MMOH-CRF-1909
        setShelfLifeFlag((String)recordSet.get("shelfLifeFlag1"));//ML-MMOH-CRF-1909
	}

	 public HashMap validate(){
        HashMap hashmap = new HashMap();
       // ArrayList arraylist = new ArrayList();
        hashmap.put("result", super.TRUE);
        return hashmap;
    }

	public void clear(){
         child_item_code="";
		 item_code="";
		 short_desc="";
		 Item_desc="";
		 component_qty="";
		 mfg_uom="";
		 base_qty="";
		 prep_type="";
		 prep_mode="";
		 label_type="";
		 process_cost="";
		 component="";
		 mandatory="";
		 checkBoxVals="";
		// session=null;
		 Conv_factor="";
		 stock_uom="";
		td_sale_stk_uom_conv_rule="";
		shelf_life_value=""; //Added for ML-MMOH-CRF-1909
        shelf_life_flag=""; //Added for Ml-MMOH-CRF-1909
    }	

	 public HashMap insert()
    {
        HashMap hashmap = new HashMap();
        ArrayList arraylist = new ArrayList();
        ArrayList arraylistHdrData = new ArrayList();
        ArrayList arraylistDtlData = new ArrayList();
		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());
        ArrayList arraylist1= null;
        ArrayList arraylist2 = new ArrayList();
        HashMap hashmap1 = new HashMap();
        //HashMap hashmap2 = new HashMap();;
       StringTokenizer stringtokenizer = new StringTokenizer(getCheckBoxVals(), ",");

		arraylist.add(getItem_code());
		arraylist.add(getBase_qty());
		arraylist.add(getPrep_type());
		arraylist.add(getPrep_mode());
		arraylist.add(getProcess_cost());
        arraylist.add(getLoginById());
        arraylist.add(getLoginAtWsNo());
        arraylist.add(getLoginFacilityId());
		arraylist.add(getLoginById());
        arraylist.add(getLoginAtWsNo());
        arraylist.add(getLoginFacilityId());
		arraylist.add(getLabel_Type());
		arraylist.add(getInstruction());
		arraylist.add( getShelfLifeValue()); //ML-MMOH-CRF-1909
        arraylist.add(getShelfLifeFlag()); //ML-MMOH-CRF-1909
		arraylistHdrData.add(arraylist);
    
        arraylist2 = (ArrayList)session.getAttribute("AssemblyDtlList");
		
	
        for(int i = 0; i < arraylist2.size(); i++)
        {
            HashMap hashmap2 = (HashMap)arraylist2.get(i);
             if(stringtokenizer.nextToken().equals("N")){
				 arraylist1 = new ArrayList();
				arraylist1.add(getItem_code());
                arraylist1.add((String)hashmap2.get("CHILD_ITEM_CODE"));
                arraylist1.add((String)hashmap2.get("COMPONENT_QTY"));
                arraylist1.add((String)hashmap2.get("MFG_UOM_CODE"));
                arraylist1.add((String)hashmap2.get("COMPONENT"));
                arraylist1.add((String)hashmap2.get("MANDATORY"));
                
				

				arraylist1.add(getLoginById());
				arraylist1.add(getLoginAtWsNo());
				arraylist1.add(getLoginFacilityId());
				arraylist1.add(getLoginById());
				arraylist1.add(getLoginAtWsNo());
				arraylist1.add(getLoginFacilityId());

				arraylist1.add((String)hashmap2.get("PRINTONLABEL"));
                arraylist1.add((String)hashmap2.get("Manufactur"));
                arraylist1.add((String)hashmap2.get("SEQ_NO"));
                arraylist1.add( getShelfLifeValue()); //ML-MMOH-CRF-1909
                arraylist1.add(getShelfLifeFlag()); //ML-MMOH-CRF-1909

				arraylistDtlData.add(arraylist1);
				
			 }
			 
        }
		

        hashmap1.put("hdrInsertSQL", getStRepositoryValue("SQL_ST_ASSEMBLY_HDR_INSERT"));
        hashmap1.put("dtlInsertSQL", getStRepositoryValue("SQL_ST_ASSEMBLY_DTL_INSERT"));
        hashmap.put("properties", getProperties());
        hashmap.put("HdrInsertData", arraylistHdrData);
        hashmap.put("DtlInsertData", arraylistDtlData);
		hashmap.put("LanguageData",LanguageData);
        return assemblyDetailMethodCall(hashmap, hashmap1, 1);
    }
	

//------------------------22-01-2007----------------------------------------------------------
  public ArrayList ManufacturingInstructions(){
	  Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		ArrayList ManufacturingInstructionsList =		new ArrayList();
		
		try {
			connection	 = getConnection() ;
			//pstmt			 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_VACC_SCHEDULE_SELECT2" )) ;
			pstmt			 = connection.prepareStatement("SELECT INSTRN_CODE,INSTRN_TEXT FROM ST_ASSEMBLY_INSTRN WHERE  EFF_STATUS='E'") ;
			resultSet      = pstmt.executeQuery() ;

			while (resultSet.next()) {
				HashMap rec		=	new HashMap();
				String instrn_code,instrn_text;
				instrn_code				=	resultSet.getString("INSTRN_CODE");
				instrn_text				=	resultSet.getString("INSTRN_TEXT");
				rec.put("instrn_code",instrn_code);
				rec.put("instrn_text",instrn_text);
				ManufacturingInstructionsList.add(rec);
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
		return ManufacturingInstructionsList;
	  }






	 public HashMap modify()
    {

        HashMap hashmap = new HashMap();
        ArrayList arraylistHd = new ArrayList();
        ArrayList arraylistHdrData = new ArrayList();
        ArrayList arraylistDtlData = new ArrayList();
		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());
        ArrayList arraylistDt= null;
        ArrayList arraylistDtMod = new ArrayList();
        ArrayList arraylistDtlDataMod = new ArrayList();
        ArrayList arrayListDelete = null;
        ArrayList arrayListDeleteMod = new ArrayList();
        HashMap hashmapQuery = new HashMap();
  
        StringTokenizer stringtokenizer = new StringTokenizer(getCheckBoxVals(), ",");
		
		arraylistHd.add(getBase_qty());
		arraylistHd.add(getPrep_type());
		arraylistHd.add(getPrep_mode());
		arraylistHd.add(getProcess_cost());
      	arraylistHd.add(getLoginById());
        arraylistHd.add(getLoginAtWsNo());
        arraylistHd.add(getLoginFacilityId());
        arraylistHd.add(getLabel_Type());
        arraylistHd.add(getInstruction());
    	arraylistHd.add( getShelfLifeValue()); //ML-MMOH-CRF-1909
        arraylistHd.add(getShelfLifeFlag()); //ML-MMOH-CRF-1909
		arraylistHd.add(getItem_code());
		
		arraylistHdrData.add(arraylistHd);

        for(int i = 0; i < DataModifyList.size(); i++)
        {
            HashMap hashmapData = (HashMap)DataModifyList.get(i);
		

             if(stringtokenizer.nextToken().equals("N")){
				  if(((String)hashmapData.get("FUNC_MODE")).equals("insert")){
					arraylistDt = new ArrayList();
					arraylistDt.add(getItem_code());
					arraylistDt.add((String)hashmapData.get("CHILD_ITEM_CODE"));
					arraylistDt.add((String)hashmapData.get("COMPONENT_QTY"));
					arraylistDt.add(checkForNull((String)hashmapData.get("MFG_UOM_CODE")));
					arraylistDt.add((String)hashmapData.get("COMPONENT"));
					arraylistDt.add((String)hashmapData.get("MANDATORY"));
					arraylistDt.add(getLoginById());
					arraylistDt.add(getLoginAtWsNo());
					arraylistDt.add(getLoginFacilityId());
					arraylistDt.add(getLoginById());
					arraylistDt.add(getLoginAtWsNo());
					arraylistDt.add(getLoginFacilityId());
                    
					arraylistDt.add((String)hashmapData.get("PRINTONLABEL"));
					arraylistDt.add((String)hashmapData.get("Manufactur"));
					arraylistDt.add((String)hashmapData.get("SEQ_NO"));
					

					arraylistDtlData.add(arraylistDt);
			
				  }
				  else{
					

					arraylistDtMod = new ArrayList();
					arraylistDtMod.add((String)hashmapData.get("COMPONENT_QTY"));
					arraylistDtMod.add(checkForNull((String)hashmapData.get("MFG_UOM_CODE")));
					arraylistDtMod.add((String)hashmapData.get("COMPONENT"));
					arraylistDtMod.add((String)hashmapData.get("MANDATORY"));
					arraylistDtMod.add(getLoginById());
					arraylistDtMod.add(getLoginAtWsNo());
					arraylistDtMod.add(getLoginFacilityId());
					
					//printonlabel=(String)hashmapData.get("PRINT_ON_LABEL_YN"); //Commented by Rabbani on 16/11/12
					printonlabel=(String)hashmapData.get("PRINTONLABEL"); //16/11/12
                   if(printonlabel==null)
					  {
                	   //printonlabel1 = "N";
                        printonlabel1 = (String)hashmapData.get("PRINT_ON_LABEL_YN");//Modified for ML-MMOH-SCF-0462
					  }
					  else
					  { 
						  printonlabel1=printonlabel;

					  }
					manufactur_instructions=(String)hashmapData.get("Manufactur");
					/*if(manufactur_instructions==null)
					  {
						manufactur_instructions1 ="";
					  }*/
					//Modified for ML-MMOH-SCF-0462 starts
					if(manufactur_instructions==null && (String)hashmapData.get("INSTRN_CODE")==null)
					  {
                        manufactur_instructions1="";
					  }
					else if(manufactur_instructions==null && (String)hashmapData.get("INSTRN_CODE")!=null){
						manufactur_instructions1 = (String)hashmapData.get("INSTRN_CODE");
					}//Modified for ML-MMOH-SCF-0462 ends
					  else
					  {
                       manufactur_instructions1=manufactur_instructions;
					  }
					arraylistDtMod.add(printonlabel1);
					arraylistDtMod.add((String)hashmapData.get("SEQ_NO"));
					arraylistDtMod.add(manufactur_instructions1);
					
					arraylistDtMod.add(getItem_code());
					arraylistDtMod.add((String)hashmapData.get("CHILD_ITEM_CODE"));


                  

					arraylistDtlDataMod.add(arraylistDtMod);

				  }
			 }
			 else{
				 if(((String)hashmapData.get("FUNC_MODE")).equals("update")){
					 arrayListDelete=new ArrayList();
					arrayListDelete.add(getItem_code());
					arrayListDelete.add((String)hashmapData.get("CHILD_ITEM_CODE"));
					arrayListDeleteMod.add(arrayListDelete);
				 }
			 }
        }

        hashmapQuery.put("hdrUpdateSQL", getStRepositoryValue("SQL_ST_ASSEMBLY_HDR_UPDATE"));
        hashmapQuery.put("dtlUpdateSQL", getStRepositoryValue("SQL_ST_ASSEMBLY_DTL_UPDATE"));
        hashmapQuery.put("dtlInsertSQL", getStRepositoryValue("SQL_ST_ASSEMBLY_DTL_INSERT"));
        hashmapQuery.put("dtlDeleteSQL", getStRepositoryValue("SQL_ST_ASSEMBLY_DTL_DELETE"));
        hashmap.put("properties", getProperties());
        hashmap.put("HdrUpdateData", arraylistHdrData);
        hashmap.put("DtlUpdateData", arraylistDtlDataMod);
        hashmap.put("DtlInsertData", arraylistDtlData);
        hashmap.put("DtlDeleteData", arrayListDeleteMod);
		hashmap.put("LanguageData",LanguageData);

		return assemblyDetailMethodCall(hashmap, hashmapQuery,2);

    }

    public HashMap assemblyDetailMethodCall(HashMap hashmap, HashMap hashmapQuery,int mode )
    {
        HashMap hashmapResult = new HashMap();
			
        try
        {


			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_ASSEMBLY_DTL"),AssemblyDetailLocalHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hashmap;
			argArray[1] = hashmapQuery;

			Class [] paramArray = new Class[2];
			paramArray[0] = hashmap.getClass(); ;
			paramArray[1] = hashmapQuery.getClass();

			
			if(mode==2)
				 hashmapResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			else
				 hashmapResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
        }
        catch(Exception exception) {
			exception.printStackTrace() ;
			}
			
			
        if(((Boolean)hashmapResult.get("result")).booleanValue())
            hashmapResult.put("message", getSTMessage(getLanguageId(),(String) hashmapResult.get("msgid" ),"ST") ) ;
        else
        if(hashmapResult.get("msgid") != null)
            hashmapResult.put("message", getSTMessage(getLanguageId(),(String) hashmapResult.get("msgid" ),"ST") ) ;
        else
            hashmapResult.put("message", replaceNewLineChar((String)hashmapResult.get("message")));
        return hashmapResult;
    }


	public String getPrepType(){
			return getStaticListOptionTag("P,Pre Packing;S,Standard Formulary ;O,Others ;",getPrep_type());
	}
	public String getPrepMode(){
			return getStaticListOptionTag("S,Sterile;N,Non Sterile ;O,Others ;",getPrep_mode());
	}
	public String getLabelType(){
			return getStaticListOptionTag("1,With Formulary ;2,Without Formulary ;",getLabel_Type());

			//return getStaticListOptionTag("1,Label#1 - Components incl ;2,Label#2 - Without Components ;3,Label#3 - With Comp Dtls  ;4,Label#4 - Without Comp Dtls  ;",getLabel_Type());
	}
/*	public String getMfgUom(){
		ArrayList arr_lang=new ArrayList();
		arr_lang.add(getStock_uom());
		arr_lang.add(getLanguageId());
		arr_lang.add(getStock_uom());
		arr_lang.add(getLanguageId());
		arr_lang.add(getStock_uom());
		arr_lang.add(getLanguageId());
		arr_lang.add(getItem_code());

		
		//getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_ASM_DTL_MFG_UOM_LIST"),arr_lang),getMfg_uom());
		getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_EQVL_UOM_SELECT1"),arr_lang),getMfg_uom());
//getListOptionTag(getWithoutLangIdListOptionArrayList(StRepository.getStKeyValue("SQL_ST_ASM_DTL_MFG_UOM_LIST")),getMfg_uom());
	}
*/
	public java.util.ArrayList getMfgUom(String stk_uom) throws Exception{
		ArrayList result		=	new ArrayList();
		String chkParameters[]	=	{stk_uom,getLanguageId(),stk_uom,getLanguageId(),stk_uom,getLanguageId(),getItem_code()};
		
		result					=	 fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_ST_EQVL_UOM_SELECT1"),chkParameters);
		
		return result;
}
	public String getPur_uom_code_Modify_List(String uom_code) throws Exception{
			String chkParameters[] = {checkForNull(uom_code),getLanguageId(),checkForNull(uom_code),getLanguageId(),checkForNull(uom_code),getLanguageId(),getChild_item_code()};

			return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_EQVL_UOM_SELECT1"),chkParameters),getMfg_uom());
		
	}
	public void getDtlData () throws Exception{ 
		ArrayList listRecord=new ArrayList();
		String [] alParameters={getItem_code(),getLanguageId(),getLanguageId()};
		try {
			
			String stSQL=getStRepositoryValue("SQL_ST_ASSEMBLY_DTL_QUERY_RESULT1");
		//	[{MANDATORY=N, CONV_FACTOR=null, PRINT_ON_LABEL_YN=Y, MFG_UOM_CODE=BAG, MFG_DESC=BAG, INSTRN_CODE=null, COMPONENT=Y, UOM_CODE=TAB, FUNC_MODE=update, SHORT_DESC=CONVER, SEQ_NO=1, CHILD_ITEM_CODE=CONVER, COMPONENT_QTY=1, STOCK_UOM=TABLET}]
			listRecord = fetchRecords(stSQL,alParameters);


			for(int i=0;i<listRecord.size();i++){
				HashMap hh=(HashMap)listRecord.get(i);
				int am_count=Integer.parseInt((String)fetchRecord("SELECT  count(*) count  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{(String)hh.get("UOM_CODE"), (String)hh.get("MFG_UOM_CODE")}).get("COUNT"));
				int item_uom_count=Integer.parseInt((String)fetchRecord("SELECT count(*) count   FROM mm_item_uom_defn WHERE uom_code = ? AND eqvl_uom_code = ? AND item_code = ?",new String[]{(String)hh.get("UOM_CODE"), (String)hh.get("MFG_UOM_CODE"),(String)hh.get("CHILD_ITEM_CODE")}).get("COUNT"));
				if(item_uom_count >0){
				HashMap  stEqvl_value1=fetchRecord("SELECT eqvl_value,eqvl_uom_qty ,(eqvl_value / eqvl_uom_qty) conv_factor FROM mm_item_uom_defn a, st_item b WHERE uom_code = ? AND eqvl_uom_code = ? AND a.item_code = ? AND a.item_code = b.item_code ",new String[]{(String)hh.get("UOM_CODE"), (String)hh.get("MFG_UOM_CODE"),(String)hh.get("CHILD_ITEM_CODE")});
				String stEqvl_value=(String)stEqvl_value1.get("CONV_FACTOR");
				String conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+(String)hh.get("STOCK_UOM")+" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+(String)hh.get("MFG_DESC");
				hh.put("CONV_FACTOR",stEqvl_value);
				hh.put("TD_SALE_STK_UOM_CONV_RULE",conver);
							
				}else if(am_count >0){
				String stEqvl_value=(String)fetchRecord("SELECT EQVL_VALUE  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{(String)hh.get("UOM_CODE"), (String)hh.get("MFG_UOM_CODE")}).get("EQVL_VALUE");
				String conver=stEqvl_value+" "+(String)hh.get("MFG_DESC")+" = 1 "+(String)hh.get("STOCK_UOM");
				hh.put("CONV_FACTOR",stEqvl_value);
				hh.put("TD_SALE_STK_UOM_CONV_RULE",conver);
				}else{
				String stEqvl_value="1";
				String conver="1 "+(String)hh.get("MFG_DESC")+" = 1 "+(String)hh.get("STOCK_UOM");
				hh.put("CONV_FACTOR",stEqvl_value);
				hh.put("TD_SALE_STK_UOM_CONV_RULE",conver);
			
				}
				listRecord.set(i,hh);

			}
				DataModifyList=listRecord;

		} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} 
	}
	
}
