/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST ;

import java.io.* ;
import java.sql.* ;
import java.util.* ;
import javax.servlet.*;
import eST.Common.*;
import eCommon.SingleTableHandler.*;
import eCommon.*;
import eCommon.Common.*;

public class AssemblyInstructionBean extends StAdapter implements Serializable
{	protected String assm_instrn_code		= "";
	protected String description			= "";
	protected String eff_status				= "";
	protected Hashtable hashMultiple       ;
	
	public AssemblyInstructionBean()throws Exception
	{ 
		try
		{
			doCommon();
		}
		catch(Exception e){
			e.printStackTrace();
			}
	}
//********* * Set Methods Start **************************
	public void setInstrnCode (String assm_instrn_code){
		this.assm_instrn_code = assm_instrn_code;
	}
	public void setInstrnDesc (String description)
	{
		this.description = description;
	}
	public void setEffStatus ( String eff_status ){
        if(eff_status.equals("N") || eff_status==null || eff_status=="")
            this.eff_status = "D" ;
        else
            this.eff_status = eff_status ;		
    }

//*********** Get Methods Start *****************************	
	public String getInstrnCode(){
		return this.assm_instrn_code;
	}
	public String getInstrnDesc(){
		return this.description;
	}
	public String getEffStatus(){
		return this.eff_status	;
	}

	public void clear(){
		super.clear();
	}
//********************* setAll  *******************************************************/
    public void setAll( Hashtable recordSetMultiple ) {
        hashMultiple = recordSetMultiple ;
        this.mode =(String)recordSetMultiple.get("mode");
 }

//*************************************************************************

	private void doCommon() throws Exception {
	}
	public HashMap insert(){	
		HashMap map = new HashMap();
		ArrayList insertData = new ArrayList() ;
		ArrayList whereData = new ArrayList() ;
		ArrayList LanguageData = new ArrayList() ;

		for(int i=0; i<10;i++)
		{
			String AssmInsrtnCode = "assm_instrn_code"  + i ;
			String AssmDesc = "description"  + i ;
			ArrayList insertRow = new ArrayList() ;
			ArrayList whereRow = new ArrayList() ;

			if(!
				  (  (((String)hashMultiple.get(AssmInsrtnCode))).trim().equals("")
										||
					(((String)hashMultiple.get(AssmDesc))).trim().equals("")
				  )
			  )
			{
				/***** 4 values per row from the AddModify form  */

				insertRow.add( (String)hashMultiple.get(  ("assm_instrn_code" + i)    )  ) ;
				insertRow.add( (String)hashMultiple.get(  ("description" + i)         ) ) ;
				if( ((String)hashMultiple.get(("eff_status" + i))).equals("") )
					insertRow.add(  "D"  ) ;
				else
					insertRow.add( (String)hashMultiple.get(  ("eff_status" + i)        ) ) ;

				insertRow.add( login_by_id ) ;
				insertRow.add( login_at_ws_no ) ;
				insertRow.add( login_facility_id ) ;

				insertRow.add( login_by_id ) ;
				insertRow.add( login_at_ws_no ) ;
				insertRow.add( login_facility_id ) ;

				whereRow.add( (String)hashMultiple.get(  ("assm_instrn_code" + i) )  ) ;

				/* note:-
				The insertData and whereData should be arraylist of arraylist
				in case of insertMultiple() of SingleTableHandler
				*/
				insertData.add( insertRow ) ;
				whereData.add( whereRow ) ;
			}
		}//for
		LanguageData.add(getLanguageId());
		HashMap tabData = new HashMap() ;
		tabData.put( "properties", getProperties() );
		tabData.put( "InsertData",insertData);
		tabData.put( "WhereData",whereData);
		tabData.put( "LanguageData",LanguageData);

		HashMap sqlMap = new HashMap() ;
		try	{
			//sqlMap.put( "SelectSQL","SELECT COUNT(*) FROM ST_ASSEMBLY_INSTRN WHERE INSTRN_CODE=?");//MmRepository.getMmKeyValue( "SQL_MM_ITEM_ANAL_CODE_EXISTS") );
			//sqlMap.put( "InsertSQL","INSERT INTO ST_ASSEMBLY_INSTRN (INSTRN_CODE,INSTRN_TEXT,EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)VALUES(?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)"); //MmRepository.getMmKeyValue( "SQL_MM_ITEM_ANAL_INSERT") );
			sqlMap.put( "SelectSQL",StRepository.getStKeyValue( "SQL_ST_ASSEMBLY_INSTRN_SELECT") );
			sqlMap.put( "InsertSQL",StRepository.getStKeyValue( "SQL_ST_ASSEMBLY_INSTRN_INSERT") );
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),eCommon.SingleTableHandler.SingleTableHandlerLocalHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); ;
			paramArray[1] = sqlMap.getClass();

			map = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

            if(((Boolean)map.get("result")).booleanValue())
                map.put("message", getSTMessage(getLanguageId(),(String) map.get("msgid" ),"ST") ) ;
            else
            if(((String)map.get("msgid")).equals("CODE_ALREADY_EXISTS"))
                map.put("message", getSTMessage(getLanguageId(),(String) map.get("msgid" ),"Common") ) ;
            else
                map.put("message", map.get("msgid"));
		} 
		catch(Exception e){
			e.printStackTrace();
		}

		return map;
	}

	public HashMap modify(){
		HashMap map = new HashMap();
		map.put( "result", new Boolean( false ) ) ;
		try{
//			boolean continue_execution = false;
//			int count			= 0;
			HashMap tabData = new HashMap() ;
			ArrayList ModifyData = new ArrayList();
//			ArrayList LanguageData = new ArrayList() ;

			ModifyData.add((String)hashMultiple.get("description"));
			ModifyData.add(checkForNull((String)hashMultiple.get( "eff_status" ),"D"));
			ModifyData.add(login_by_id);
			ModifyData.add(login_at_ws_no);
			ModifyData.add(login_facility_id);
			ModifyData.add(assm_instrn_code);
			//LanguageData.add(getLanguageId());
			tabData.put("ModifyData",ModifyData ) ;
			tabData.put("properties",getProperties() ) ;
			//tabData.put("LanguageData",LanguageData);
			
			HashMap sqlMap = new HashMap() ;
		
			sqlMap.put( "ModifySQL",StRepository.getStKeyValue( "SQL_ST_ASSEMBLY_INSTRN_UPDATE") );
			try{	
				Object home1 = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER") ,SingleTableHandlerHome.class,getLocalEJB());
				Object busObj = (home1.getClass().getMethod("create",null)).invoke(home1,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); 
				paramArray[1] = sqlMap.getClass();
				map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			   (busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			}
			catch(Exception ee){
				ee.printStackTrace();
			}
			if(((Boolean)map.get("result")).booleanValue())
				map.put("message", getSTMessage(getLanguageId(),(String) map.get("msgid" ),"ST") ) ;
			else
				map.put("message", map.get("msgid"));	

		}
		catch(Exception e){
			map.put( "message", e.getMessage() ) ;
			e.printStackTrace() ;
		}
		finally{
			try {
				//if( remote != null )
				//	remote.remove() ;
			} 
			catch( Exception ee ){
				map.put( "message", ee.getMessage() ) ;
				ee.printStackTrace();
			}
		}
		return map ;
	}
public void loadData(){

HashMap hmRecord	=	new HashMap();
try{
ArrayList hmResult=fetchRecords("select INSTRN_TEXT,EFF_STATUS from  ST_ASSEMBLY_INSTRN  where INSTRN_CODE=?",getInstrnCode());
for (int i=0; i<hmResult.size(); i++) {
	hmRecord	=	(HashMap)hmResult.get(i);
setInstrnDesc((String)hmRecord.get("INSTRN_TEXT"));
setEffStatus ((String)hmRecord.get("EFF_STATUS"));
}
}catch(Exception e)
	{
	e.printStackTrace() ;
	}

}

}
