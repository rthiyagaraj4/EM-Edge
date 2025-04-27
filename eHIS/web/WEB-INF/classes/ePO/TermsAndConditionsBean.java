/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePO;

import ePO.Common.* ;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
import javax.servlet.* ;
import eCommon.Common.*;
import eCommon.SingleTableHandler.*;

public class TermsAndConditionsBean extends PoAdapter implements Serializable {

	private String termsAndCond_code;
	private String short_desc;
	private String long_desc;
	private String status;
	
	public void setTermsAndCond_Code(String termsAndCond_code)
	{
		this.termsAndCond_code=termsAndCond_code;
	}

	public String getTermsAndCond_Code()
	{
		return termsAndCond_code;
	}

	public void setShortDesc(String short_desc)
	{
		this.short_desc=short_desc;
	}

	public String getShortDesc()
	{
		return short_desc;
	}
	
	public void setLongDesc(String long_desc)
	{
		this.long_desc=long_desc;
	}

	public String getLongDesc()
	{
		return long_desc;
	}

	
	public void setStatus(String status)
	{
		this.status=status;
	}

	public String getStatus()
	{
		if(status.equals("E"))
			status="E";
		else
			status="D";
		return status;
		
	}
	
		public void loadData() throws Exception {
		HashMap	hmRecord=null;
		ArrayList arr_lang=new ArrayList();
		arr_lang.add(termsAndCond_code);
		hmRecord=fetchRecord(getPoRepositoryValue("SQL_PO_TERMS_AND_COND_CODE_SELECT_SINGLE"),arr_lang);
		
		setTermsAndCond_Code( (String)hmRecord.get("TERM_CONS_CODE" ) ) ;
		setShortDesc( (String)hmRecord.get("SHORT_DESC" ) ) ;
		setLongDesc( (String)hmRecord.get("LONG_DESC" ) ) ;
		status=( checkForNull((String)(hmRecord.get("EFF_STATUS"))).equals("E")?"E":"D" );
		setStatus(status);
	
		
	}

	public void setAll( Hashtable htRecordSet ) {

		super.setAll(htRecordSet);
		setMode((String) htRecordSet.get("mode")) ;
		setTermsAndCond_Code((String) htRecordSet.get("termsAndCond_code")) ;
		setShortDesc( (String)htRecordSet.get("short_desc" ) ) ;
		setLongDesc( (String)htRecordSet.get("long_desc" ) ) ;
		status=( checkForNull((String)(htRecordSet.get("status"))).equals("E")?"E":"D" );
		setStatus(status);
		
	}

	public HashMap validate() {
		HashMap hmReturn = new HashMap() ;
		hmReturn.put("result", new Boolean( true ) ) ;
		hmReturn.put("message", "success mode="+getMode() ) ;
		return hmReturn ;
	}


	public HashMap insert() {
		HashMap map = new HashMap();
		HashMap		hmResult	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alInsertData=	new ArrayList()	;
		ArrayList WhereData = new ArrayList();
		ArrayList LanguageData = new ArrayList() ;


		hmResult.put("result", new Boolean( false ) ) ;
		hmResult.put("message", "Initial Message" ) ;

		alInsertData.add(getTermsAndCond_Code()	);
		alInsertData.add(getShortDesc());
		alInsertData.add(getLongDesc());
	    alInsertData.add(getStatus());
		alInsertData.add(getLoginById()		);
		alInsertData.add(getLoginAtWsNo()	);
		alInsertData.add(getLoginFacilityId());
		alInsertData.add(getLoginById()		);
		alInsertData.add(getLoginAtWsNo()	);
		alInsertData.add(getLoginFacilityId());
		
		WhereData.add(getTermsAndCond_Code());
		
		LanguageData.add(getLanguageId());
		hmTableData.put( "InsertData",	alInsertData ) ;
		hmTableData.put( "WhereData",	WhereData ) ;
		hmTableData.put( "properties",	getProperties() ) ;
		hmTableData.put( "LanguageData",LanguageData);
		
		HashMap sqlMap = new HashMap() ;
		
	//	SingleTableHandlerRemote remote = null ;

		try {

				sqlMap.put( "InsertSQL", PoRepository.getPoKeyValue( "SQL_PO_TERMS_AND_COND_CODE_INSERT" ));
				sqlMap.put( "SelectSQL", PoRepository.getPoKeyValue( "SQL_PO_TERMS_AND_COND_CODE_EXISTS"));
				
				System.out.println("*** hmTableData ***  =  "+hmTableData);
				System.out.println("*** sqlMap ***  =  "+sqlMap);
				
				return callSingleTableHandler(hmTableData, sqlMap,PoRepository.SINGLE_INSERT);
				
			} 
			catch(Exception e)
			{
				map.put( "message", e.getMessage()) ;
				e.printStackTrace() ;
			}
			finally
			{
				try {
					//	if( remote != null )
					//		remote.remove() ;
					} catch( Exception ee )
					{
						map.put( "message", ee.getMessage() ) ;
						ee.printStackTrace() ;
					}
			}
		return map ;
		


	}






	public HashMap modify() 
	{
		HashMap		hmResult	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alModifyData=	new ArrayList()	;
		ArrayList LanguageData = new ArrayList() ;
		
		alModifyData.add(getShortDesc());
		alModifyData.add(getLongDesc());
		alModifyData.add(getStatus());
		alModifyData.add(getLoginById()		);
		alModifyData.add(getLoginAtWsNo()	);
		alModifyData.add(getLoginFacilityId());
		alModifyData.add(getTermsAndCond_Code()	);
		hmResult.put("result", new Boolean( false ) ) ;
		hmResult.put("message", "Initial Message" ) ;
		
		LanguageData.add(getLanguageId());
		hmTableData.put	( "properties",getProperties());
		hmTableData.put	( "ModifyData",alModifyData);
		hmTableData.put( "LanguageData",LanguageData);
		
		hmSQLMap.put	( "ModifySQL", getPoRepositoryValue("SQL_PO_TERMS_AND_COND_CODE_UPDATE"));
	
		System.out.println("*** hmTableData ***  =  "+hmTableData);
				System.out.println("*** hmSQLMap ***  =  "+hmSQLMap);
			return callSingleTableHandler(hmTableData, hmSQLMap,PoRepository.SINGLE_UPDATE);
		
	

	}




	public void clear()
	{
		termsAndCond_code="";
		short_desc="";
		long_desc="";
		status="";

	}
}
