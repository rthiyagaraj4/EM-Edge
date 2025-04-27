/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMM;

import eMM.Common.* ;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
//import eMM.Common.MmAdapter;
//import java.sql.Connection ;
//import java.sql.ResultSet;
//import java.sql.PreparedStatement;
//import javax.naming.InitialContext ;
//import javax.rmi.PortableRemoteObject;
//import javax.servlet.http.HttpServletRequest;
import javax.servlet.* ;
import eCommon.Common.*;
import eCommon.SingleTableHandler.*;

public class SupplierBean extends MmAdapter implements Serializable {

	private String supplier_code;
	private String alpha_code;
	private String long_desc;
	private String short_desc;
	private String status;
	private String bank_no;
	private String acc_no;
	private String bank_acc_name;
	private String branch_no;
	private String currency;
	private String supp_address_1;
	private String supp_address_2;
	private String supp_address_3;
	private String zip_code;
	private String tel_no;
	private String fax_no;
	private String email_id;
	private String cntct_person;
	private String title_of_cntct_person;
	//private String deliver_to_address;
	//private String bill_to_address;


	//private String language_id;


	public void setSupplier_Code(String supplier_code)
	{
		this.supplier_code=supplier_code;
	}

	public String getSupplier_Code()
	{
		return supplier_code;
	}
/*public void setLanguageId (String language_id)
	{
		this.language_id = language_id;
	}
	public String getLanguageId() 
	{
		return this.language_id;
	}*/
	public void setAlpha_Code(String alpha_code)
	{
		this.alpha_code=alpha_code;
	}

	public String getAlpha_Code()
	{
		return alpha_code;
	}

	public void setLong_Desc(String long_desc)
	{
		this.long_desc=long_desc;
	}

	public String getLong_Desc()
	{
		return long_desc;
	}

	public void setShort_Desc(String short_desc)
	{
		this.short_desc=short_desc;
	}

	public String getShort_Desc()
	{
		return short_desc;
	}

	public void setStatus(String status)
	{
		this.status=status;
			//checkForNull(status,"");
	}

	public String getStatus()
	{
		if(status.equals("S"))
			status="S";
		else
			status="";
		return status;
		
	}

	public void setSupp_Address_1(String supp_address_1)
	{
		this.supp_address_1=checkForNull(supp_address_1);
	}

	public String getSupp_Address_1()
	{
		return supp_address_1;
	}

	public void setSupp_Address_2(String supp_address_2)
	{
		this.supp_address_2=checkForNull(supp_address_2);
	}

	public String getSupp_Address_2()
	{
		return supp_address_2;
	}

	public void setSupp_Address_3(String supp_address_3)
	{
		this.supp_address_3=checkForNull(supp_address_3);
	}

	public String getSupp_Address_3()
	{
		return supp_address_3;
	}

	public void setZip_Code(String zip_code)
	{
		this.zip_code=checkForNull(zip_code);
	}

	public String getZip_Code()
	{
		return zip_code;
	}

	public void setTel_No(String tel_no)
	{
		this.tel_no=checkForNull(tel_no);
	}

	public String getTel_No()
	{
		return tel_no;
	}

	public void setFax_No(String fax_no)
	{
		this.fax_no=checkForNull(fax_no);
	}

	public String getFax_No()
	{
		return fax_no;
	}

	public void setEmail_Id(String email_id)
	{
		this.email_id=checkForNull(email_id);
	}

	public String getEmail_Id()
	{
		return email_id;
	}

	public void setBank_No(String bank_no)
	{
		this.bank_no=checkForNull(bank_no);
	}

	public String getBank_No()
	{
		return bank_no;
	}

	public void setAcc_No(String acc_no)
	{
		this.acc_no=checkForNull(acc_no);
	}

	public String getAcc_No()
	{
		return acc_no;
	}

	public void setBank_Acc_Name(String bank_acc_name)
	{
		this.bank_acc_name=checkForNull(bank_acc_name);
	}

	public String getBank_Acc_Name()
	{
		return bank_acc_name;
	}

	public void setBranch_No(String branch_no)
	{
		this.branch_no=checkForNull(branch_no);
	}

	public String getBranch_No()
	{
		return branch_no;
	}

	public void setCurrency(String currency)
	{
		this.currency=checkForNull(currency);
	}

	public String getCurrency()
	{
		return currency;
	}

	public void setContactperson(String cntct_person)
	{
		this.cntct_person=checkForNull(cntct_person);
	}

	public String getContactperson()
	{
		return cntct_person;
	}

	public void setTitleofcontactperson(String title_of_cntct_person)
	{
		this.title_of_cntct_person=checkForNull(title_of_cntct_person);
	}

	public String getTitleofcontactperson()
	{
		return title_of_cntct_person;
	}	


	/*public String getStockStatus()
	{
		return getStaticListOptionTag("A,All;S,Stock on Hand ;Z,Zero Stock;B,Below Reorder Level;");
	}
	*/


		public void loadData() throws Exception {
		HashMap	hmRecord=null;
		ArrayList arr_lang=new ArrayList();
		arr_lang.add(supplier_code);
		arr_lang.add(getLanguageId());
		hmRecord=fetchRecord(getMmRepositoryValue("SQL_MM_SUPPLIER_CODE_SELECT_SINGLE"),arr_lang);

		setSupplier_Code( (String)hmRecord.get("SUPP_CODE" ) ) ;
		setBank_No((String) hmRecord.get("BANK_NO"));
		setAlpha_Code ( (String)hmRecord.get("SUPP_ALPHA_CODE") );
		setAcc_No((String) hmRecord.get("ACC_NO"));
		setShort_Desc	( (String)hmRecord.get("SHORT_NAME" )	) ;
		setBank_Acc_Name((String) hmRecord.get("BANK_ACC_NAME"));
		setLong_Desc( (String)hmRecord.get("LONG_NAME" ) ) ;
		setBranch_No((String)hmRecord.get("BRANCH_NO"));
		setSupp_Address_1((String)hmRecord.get("ADD1_DESC"));
		setCurrency((String)hmRecord.get("CURRENCY_CODE"));
		setSupp_Address_2((String)hmRecord.get("ADD2_DESC"));
		status=( checkForNull((String)(hmRecord.get("STATUS"))).equals("")?"S":"" );
		setSupp_Address_3((String)hmRecord.get("ADD3_DESC"));
		setZip_Code((String)hmRecord.get("ZIP_DESC"));
		setTel_No((String)hmRecord.get("TEL_NUM"));
		setFax_No((String)hmRecord.get("FAX_NUM"));
		setEmail_Id((String)hmRecord.get("EMAIL_ID"));
		setContactperson((String)hmRecord.get("CONTACT_NAME_PUR"));
		setTitleofcontactperson((String)hmRecord.get("CONTACT_NAME_TITLE_PUR"));
	}

	public void setAll( Hashtable htRecordSet ) {

		super.setAll(htRecordSet);
		setMode((String) htRecordSet.get("mode")) ;
		setSupplier_Code((String) htRecordSet.get("supplier_code")) ;
		setBank_No((String) htRecordSet.get("bank_no"));
		setAlpha_Code((String)htRecordSet.get("alpha_code"));
		setAcc_No((String) htRecordSet.get("acc_no"));
		setShort_Desc((String)htRecordSet.get("short_desc"));
		setBank_Acc_Name((String) htRecordSet.get("bank_acc_name"));
		setLong_Desc((String)htRecordSet.get("long_desc"));
		setBranch_No((String)htRecordSet.get("branch_no"));
		setSupp_Address_1((String)htRecordSet.get("supp_address_1"));
		setCurrency((String)htRecordSet.get("currency"));
		setSupp_Address_2((String)htRecordSet.get("supp_address_2"));
		status=( checkForNull((String)(htRecordSet.get("status"))).equals("")?"S":"" );
		setStatus(status);
		setSupp_Address_3((String)htRecordSet.get("supp_address_3"));
		setZip_Code((String)htRecordSet.get("zip_code"));
		setTel_No((String)htRecordSet.get("tel_no"));
		setFax_No((String)htRecordSet.get("fax_no"));
		setEmail_Id((String)htRecordSet.get("email_id"));
		setContactperson((String)htRecordSet.get("cntct_person"));
		setTitleofcontactperson((String)htRecordSet.get("title_of_cntct_person"));

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
		//HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alInsertData=	new ArrayList()	;
		ArrayList WhereData = new ArrayList();
		ArrayList LanguageData = new ArrayList() ;


		hmResult.put("result", new Boolean( false ) ) ;
		hmResult.put("message", "Initial Message" ) ;

		alInsertData.add(getSupplier_Code()	);
		alInsertData.add(getBank_No()       );
		alInsertData.add(getAlpha_Code()		);
		alInsertData.add(getAcc_No());
		alInsertData.add(getShort_Desc()	);
		alInsertData.add(getBank_Acc_Name());
		alInsertData.add(getLong_Desc()	);
		alInsertData.add(getBranch_No());
		alInsertData.add(getSupp_Address_1());
		alInsertData.add(getCurrency());
		alInsertData.add(getSupp_Address_2());
		alInsertData.add(getStatus());
		alInsertData.add(getSupp_Address_3());
		alInsertData.add(getZip_Code());
		alInsertData.add(getTel_No());
		alInsertData.add(getFax_No());
		alInsertData.add(getEmail_Id());
		alInsertData.add(getContactperson());
		alInsertData.add(getTitleofcontactperson());
		//alInsertData.add(getDelivertoaddress());
		//alInsertData.add(getBilltoaddress());
		alInsertData.add(getLoginById()		);
		alInsertData.add(getLoginById()		);
		alInsertData.add(getLoginAtWsNo()	);
		alInsertData.add(getLoginFacilityId());
		alInsertData.add(getLoginAtWsNo()	);
		alInsertData.add(getLoginFacilityId());
		
		
		
	//	alInsertData.add(getSupplier_Code()	);
	//	alInsertData.add(getAlpha_Code()		);
	//	alInsertData.add(getLong_Desc()	);
	//	alInsertData.add(getShort_Desc()	);
	//	alInsertData.add(getSupp_Address_1());
	//	alInsertData.add(getSupp_Address_2());
	//	alInsertData.add(getSupp_Address_3());
	//	alInsertData.add(getZip_Code());
	//	alInsertData.add(getTel_No());
	//	alInsertData.add(getFax_No());
	//	alInsertData.add(getEmail_Id());
	//	alInsertData.add(getBank_No());
	//	alInsertData.add(getAcc_No());
	//	alInsertData.add(getBank_Acc_Name());
	//	alInsertData.add(getBranch_No());
	//	alInsertData.add(getCurrency());
	//	alInsertData.add(getLoginById()		);
	//	alInsertData.add(getLoginById()		);
	//	alInsertData.add(getLoginAtWsNo()	);
	//	alInsertData.add(getLoginFacilityId());
	//	alInsertData.add(getLoginAtWsNo()	);
	//	alInsertData.add(getLoginFacilityId());
	//	alInsertData.add(getStatus());
		//alWhereData.add(getSupplier_Code() );
		//hmTableData.put	( "properties",getProperties());
		//hmTableData.put	( "InsertData",alInsertData);
		//hmTableData.put( "WhereData" , alWhereData);
		//hmSQLMap.put	( "InsertSQL", eMM.Common.MmRepository.getMmKeyValue("SQL_MM_SUPPLIER_CODE_INSERT"));
	
		/*
		return callSingleTableHandler(hmTableData, hmSQLMap, MmRepository.SINGLE_INSERT);

		*/

		WhereData.add(getSupplier_Code());

	
		LanguageData.add(getLanguageId());
		hmTableData.put( "InsertData",	alInsertData ) ;
		hmTableData.put( "WhereData",	WhereData ) ;
		hmTableData.put( "properties",	getProperties() ) ;
		hmTableData.put( "LanguageData",LanguageData);
		
		System.out.println("hmTableData" +hmTableData);

		HashMap sqlMap = new HashMap() ;
		//sqlMap.put( "InsertSQL", MmInterface.SQL_MM_ITEMMASTER_INSERT );
		//sqlMap.put( "SelectSQL", MmInterface.SQL_MM_ITEMMASTER_EXISTS );

//		SingleTableHandlerHome home = null ;
		SingleTableHandlerRemote remote = null ;

		try {

				sqlMap.put( "InsertSQL", MmRepository.getMmKeyValue( "SQL_MM_SUPPLIER_CODE_INSERT" ));
				sqlMap.put( "SelectSQL", MmRepository.getMmKeyValue( "SQL_MM_SUPPLIER_GROUP_CODE_EXISTS"));

				/*InitialContext context = new InitialContext() ;
				//Object object = context.lookup( MmInterface.JNDI_SINGLE_TABLE_HANDLER ) ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER") ) ;

		
				home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				remote = home.create() ;
				map = remote.insert( hmTableData, sqlMap ) ;*/
				Object home1 = com.ehis.eslp.ServiceLocator.getInstance().getHome( CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj = (home1.getClass().getMethod("create",null)).invoke(home1,null);

				Object argArray[] = new Object[2];
				argArray[0] = hmTableData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = hmTableData.getClass(); 
				paramArray[1] = sqlMap.getClass();

				 map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				
				if( ((Boolean) map.get( "result" )).booleanValue() )		
					map.put( "message", getMMMessage(getLanguageId(),(String) map.get( "msgid" ),"ST") ) ;
				else
					map.put( "message", getMMMessage(getLanguageId(),(String) map.get("msgid"),"ST") ) ;
			} 
			catch(Exception e)
			{
				map.put( "message", e.getMessage()) ;
				e.printStackTrace() ;
			}
			finally
			{
				try {
						if( remote != null )
							remote.remove() ;
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
			int SINGLE_UPDATE = 2;
		//HashMap Data = new HashMap() ;
		//ArrayList	alWhereData=	new ArrayList()	;
		//HashMap map = new HashMap();
		
		//alModifyData.add(getSupplier_Code()	);
		alModifyData.add(getBank_No()       );
		alModifyData.add(getAlpha_Code()		);
		alModifyData.add(getAcc_No());
		alModifyData.add(getShort_Desc()	);
		alModifyData.add(getBank_Acc_Name());
		alModifyData.add(getLong_Desc()	);
		alModifyData.add(getBranch_No());
		alModifyData.add(getSupp_Address_1());
		alModifyData.add(getCurrency());
		alModifyData.add(getSupp_Address_2());
		alModifyData.add(getStatus());
		alModifyData.add(getSupp_Address_3());
		alModifyData.add(getZip_Code());
		alModifyData.add(getTel_No());
		alModifyData.add(getFax_No());
		alModifyData.add(getEmail_Id());
		alModifyData.add(getContactperson());
		alModifyData.add(getTitleofcontactperson());
		//alModifyData.add(getDelivertoaddress());
		//alModifyData.add(getBilltoaddress());

		alModifyData.add(getLoginById()		);
		alModifyData.add(getLoginAtWsNo()	);
		alModifyData.add(getLoginFacilityId());
		//alModifyData.add(getStatus());
		alModifyData.add(getSupplier_Code()	);
		hmResult.put("result", new Boolean( false ) ) ;
		hmResult.put("message", "Initial Message" ) ;
		
		LanguageData.add(getLanguageId());
		hmTableData.put	( "properties",getProperties());
		hmTableData.put	( "ModifyData",alModifyData);
		hmTableData.put( "LanguageData",LanguageData);
		
		hmSQLMap.put	( "ModifySQL", getMmRepositoryValue("SQL_MM_SUPPLIER_CODE_UPDATE"));
	
		
			return callSingleTableHandler(hmTableData, hmSQLMap,SINGLE_UPDATE);
		
	

	}

	public String getCurrencyList() {

				ArrayList alparameter = new ArrayList();

				alparameter.add(getLanguageId());
		
		return  getListOptionTag(getListOptionArrayList(getMmRepositoryValue("SQL_AP_CURRENCY_CODE_SELECT_SINGLE"),alparameter), getCurrency());
	}




	public void clear()
	{
		supplier_code="";
		alpha_code="";
		long_desc="";
		short_desc="";
		status="";
		bank_no="";
		acc_no ="";
		bank_acc_name="";
		branch_no="";
		currency="";
		supp_address_1="";
		supp_address_2="";
		supp_address_3="";
		zip_code="";
		tel_no="";
		fax_no="";
		email_id="";

	}
}
