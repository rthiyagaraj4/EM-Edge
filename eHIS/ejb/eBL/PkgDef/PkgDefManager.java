/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/

/*
Sr No        Version           Incident			SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V210413			17021        Common-ICN-0009-TF         MuthukumarN
-----------------------------------------------------------------------------------
*/

package eBL.PkgDef;
import java.sql.*;
import javax.ejb.*;
import java.util.*;
import webbeans.eCommon.*;
import java.text.SimpleDateFormat;

/**
*
* @ejb.bean
*	name="PkgDef"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="PkgDef"
*	local-jndi-name="PkgDef"
*	impl-class-name="eBL.PkgDef.PkgDefManager"
*
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject"
*	local-class="eBL.PkgDef.PkgDefLocal"
*	remote-class="eBL.PkgDef.PkgDefRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome"
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eBL.PkgDef.PkgDefLocalHome"
*	remote-class="eBL.PkgDef.PkgDefHome"
*	generate= "local,remote"
*
*
*/


public class PkgDefManager implements SessionBean
{
	Connection con;

	CallableStatement cstmt = null;
	CallableStatement cstmt1 = null;
	SessionContext ctx;

	boolean insertable = false;

	String locale = "";

	String encounterid = "";

	String errCode = "", sysMessgaeId="", errText="", gen_doc_type="",gen_doc_num="";
	StringBuffer sys_err = new StringBuffer("") ;


	String currdate="",client_ip_address="",user_id="",str_error_level="",str_error_text="",str_sysmesage_id="";

	public void ejbCreate() {
	}

	public void ejbRemove() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public void setSessionContext(SessionContext context) {
		this.ctx = context;
	}

	/**
	 *Method to insert single record
	 *@param properties Connection Properties
	 *@param hashaMap Record data
	 *@param as data for duplication check
	 *@param s Table Name
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	@SuppressWarnings({"rawtypes","unused", "unchecked"})
	public java.util.HashMap insert(java.util.Properties p,java.util.HashMap tabdata) //throws Exception
	{
		System.out.println("106,insert in PkgDefManager.java");
		con = ConnectionManager.getConnection(p);
		HashMap return_mess = new HashMap();
		boolean insertable = false;
		String locale = "";
		if(locale==null) locale="en";
		String facility_id = (String) tabdata.get("FACILITY_ID");
		if(facility_id==null) facility_id="";
		String packageCode=(String)tabdata.get("packageCode");
		if(packageCode==null) packageCode="";
		String longDesc=(String)tabdata.get("longDesc");
		if(longDesc==null) longDesc="";
		String shortDesc=(String)tabdata.get("shortDesc");
		if(shortDesc==null) shortDesc="";
		locale=(String)tabdata.get("locale");
		if(locale==null) locale="en";
		String applSexInd=(String)tabdata.get("applSexInd");
		if(applSexInd==null) applSexInd="";
		String effFromDate=(String)tabdata.get("effFromDate");
		if(effFromDate==null)
			effFromDate="";
		else
			effFromDate = com.ehis.util.DateUtils.convertDate(effFromDate,"DMY",locale,"en");
		String effToDate=(String)tabdata.get("effToDate");
		if(effToDate==null)
			effToDate="";
		else
			effToDate = com.ehis.util.DateUtils.convertDate(effToDate,"DMY",locale,"en");
		String minAgeInYrs=(String)tabdata.get("minAgeInYrs");
		if(minAgeInYrs==null) minAgeInYrs="";

		String minAgeInMths=(String)tabdata.get("minAgeInMths");
		if(minAgeInMths==null) minAgeInMths="";

		String minAgeInDays=(String)tabdata.get("minAgeInDays");
		if(minAgeInDays==null) minAgeInDays="";

		String maxAgeInYrs=(String)tabdata.get("maxAgeInYrs");
		if(maxAgeInYrs==null) maxAgeInYrs="";

		String maxAgeInMths=(String)tabdata.get("maxAgeInMths");
		if(maxAgeInMths==null) maxAgeInMths="";
		String maxAgeInDays=(String)tabdata.get("maxAgeInDays");
		if(maxAgeInDays==null) maxAgeInDays="";

		String AllYn=(String)tabdata.get("AllYn");
		if(AllYn==null) AllYn="";

		String IpYn=(String)tabdata.get("IpYn");
		if(IpYn==null) IpYn="";

		String DcYn=(String)tabdata.get("DcYn");
		if(DcYn==null) DcYn="";

		String OpYn=(String)tabdata.get("OpYn");
		if(OpYn==null) OpYn="";

		String EmYn=(String)tabdata.get("EmYn");
		if(EmYn==null) EmYn="";

		String orderAssociated=(String)tabdata.get("orderAssociated");
		if(orderAssociated==null) orderAssociated="N";
		//Added V190325 Gayathri/KDAH-CRF-0503
		String isMasterPkgYn=(String)tabdata.get("isMasterPkgYn");
		if(isMasterPkgYn==null) isMasterPkgYn="N";
		
		String acrossEncounters=(String)tabdata.get("acrossEncounters");
		if(acrossEncounters==null) acrossEncounters="";

		String validDays=(String)tabdata.get("validDays");
		if(validDays==null) validDays="";
		String applicalbleTo=(String)tabdata.get("applicalbleTo");
		if(applicalbleTo==null) applicalbleTo="";
		String approvedYN=(String)tabdata.get("approvedYN");
		if(approvedYN==null) approvedYN="N";
		String approvedBy=(String)tabdata.get("approvedBy");
		if(approvedBy==null) approvedBy="";
		String approvedDate=(String)tabdata.get("approvedDate");
		if(approvedDate==null)
			approvedDate="";
		else
			approvedDate = com.ehis.util.DateUtils.convertDate(approvedDate,"DMY",locale,"en");
		String roundTo = "";
		String roundInd= "";
		String auto_refund= "";
		String closePakgStat= "";
		String deposit		   ="";
		String partialDeposit 	   ="";
		String minDepAmtind   	   ="";
		String minDepAmt	 	   ="";
		String factorforServiceRate = ""; //Added by muthu on 26-6-12
		client_ip_address=(String)tabdata.get("client_ip_address");
		if(client_ip_address==null) client_ip_address="";

		user_id=(String)tabdata.get("login_user");
		if(user_id==null) user_id="";

		locale=(String)tabdata.get("locale");
		if(locale==null) locale="en";
		int totRec = 0;
		ArrayList roundToGroup	        =	new ArrayList();
		ArrayList roundIndGroup		    =	new ArrayList();
		HashMap baseDates     = (HashMap)tabdata.get("baseDates");
		HashMap basePrice 	  = (HashMap)tabdata.get("basePrice");
		HashMap childPackages = (HashMap)tabdata.get("childPackages");//Added V190325 Gayathri/KDAH-CRF-0503
		ArrayList priceFromDate  =	new ArrayList();
		HashMap includedItems_CB = (HashMap)tabdata.get("includedItems_CB");
		HashMap excludedItems_CB = (HashMap)tabdata.get("excludedItems_CB");
		HashMap includedItems_RB = (HashMap)tabdata.get("includedItems_RB");
		HashMap excludedItems_RB = (HashMap)tabdata.get("excludedItems_RB");
		HashMap includedItemsFD_CB = new HashMap();
		HashMap includedItemsFD_RB = new HashMap();
		HashMap excludedItemsFD_CB = new HashMap();
		HashMap excludedItemsFD_RB = new HashMap();
		//HashMap includedItems_cust= (HashMap)tabdata.get("includedItems_cust"); unused
		HashMap cust_dtls = (HashMap)tabdata.get("cust_dtls");
		HashMap cust_period = (HashMap)tabdata.get("cust_period");
		HashMap cust_base_price = (HashMap)tabdata.get("cust_base_price");
		HashMap cust_rate_srv = (HashMap)tabdata.get("cust_rate_srv");
		System.out.println("225 cust_rate_srv in manager "+cust_rate_srv);
		HashMap cust_rate_srv_excl = (HashMap)tabdata.get("cust_rate_srv_excl");
		HashMap cust_charge_srv = (HashMap)tabdata.get("cust_charge_srv");
		HashMap cust_charge_srv_excl = (HashMap)tabdata.get("cust_charge_srv_excl");

		//Added By Shikha For GHL-CRF-0520.1
		HashMap blng_grp_dtls = (HashMap)tabdata.get("blng_grp_dtls");
		HashMap blng_grp_period = (HashMap)tabdata.get("blng_grp_period");
		HashMap blng_grp_base_price = (HashMap)tabdata.get("blng_grp_base_price");
		HashMap blng_grp_rate_srv = (HashMap)tabdata.get("blng_grp_rate_srv");
		HashMap blng_grp_rate_srv_excl = (HashMap)tabdata.get("blng_grp_rate_srv_excl");
		HashMap blng_grp_charge_srv = (HashMap)tabdata.get("blng_grp_charge_srv");
		HashMap blng_grp_charge_srv_excl = (HashMap)tabdata.get("blng_grp_charge_srv_excl");
		//Ended By Shikha For GHL-CRF-0520.1
		System.out.println("239 cust_charge_srv manager =>"+cust_charge_srv);
		System.out.println("240 blng_grp_charge_srv_excl manager =>"+blng_grp_charge_srv_excl);
		System.out.println("241 blng_grp_charge_srv manager =>"+blng_grp_charge_srv);
		
		/*String modify_cust=(String)tabdata.get("modify_cust");
		String modify_cust_period=(String)tabdata.get("modify_cust_period");
		String modify_cust_base_price=(String)tabdata.get("modify_cust_base_price");
		String modify_cust_rate_srv=(String)tabdata.get("modify_cust_rate_srv");
		String modify_cust_rate_srv_excl=(String)tabdata.get("modify_cust_rate_srv_excl");
		String modify_cust_charge_srv=(String)tabdata.get("modify_cust_charge_srv");
		String modify_cust_charge_srv_excl=(String)tabdata.get("modify_cust_charge_srv_excl"); unused */

		HashMap cust_discount_dtls = (HashMap)tabdata.get("cust_discount_dtls");
		HashMap blng_grp_discount_dtls = (HashMap)tabdata.get("blng_grp_discount_dtls");
		String newDate=(String)tabdata.get("newDate");
		//String modify_discount=(String)tabdata.get("modify_discount");

		ArrayList chargeTypeGroup	=	new ArrayList();//Muthu against 28192 on 09-08-12
		ArrayList services			=	new ArrayList();
		ArrayList serviceGroup	    =	new ArrayList();
		ArrayList amtLmtIndGroup	=	new ArrayList();
		ArrayList amtLmtGroup		=	new ArrayList();
		ArrayList itemsForService	=	null;
		ArrayList itemGroup	        =	new ArrayList();
		ArrayList itemDescGroup     =	new ArrayList();
		ArrayList inExcnGroup		=	new ArrayList();
		ArrayList amountLtGroup		=	new ArrayList();
		ArrayList srvLmtFactorApplGroup		=	new ArrayList();
		ArrayList qtyLtGroup		=	new ArrayList();
		ArrayList	typeGroup	    =	new ArrayList();
		ArrayList	srvLtTypeGroup	=	new ArrayList();
		ArrayList	exludeSrvGroup	    =	new ArrayList();
		ArrayList	catalogGroup		    =	new ArrayList();
		ArrayList	indGroup		    =	new ArrayList();
		ArrayList	factorOrRateGroup    =	new ArrayList();
		ArrayList	replaceGroup    =	new ArrayList();
		ArrayList	replaceSrvGroup   =	new ArrayList();
		ArrayList	replaceSrv_catGroup    =	new ArrayList();
		ArrayList	refundGroup    =	new ArrayList();
		ArrayList	refundAmtGroup    =	new ArrayList();
		ArrayList	factor_applGroup    =	new ArrayList();
		ArrayList	srvLtSrvGroup	    =	new ArrayList();
		ArrayList	auto_refund_list	 =	new ArrayList();
		ArrayList	roundTo_list	     =	new ArrayList();
		ArrayList	roundInd_list		 =	new ArrayList();
		ArrayList	closePkg_list		 =	new ArrayList();
		ArrayList	split_reqd_list		 =	new ArrayList();//Split Reqd - Rajesh V
		ArrayList	includeHomeMedication_list		 =	new ArrayList();//added by suganya
		ArrayList dailyLmtChkBxList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
		ArrayList dailyLmtAmtList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
		ArrayList dailyLmtGrossNetList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
		ArrayList dailyLmtIndicatorList = new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		ArrayList dailyLmtQtyList = new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		ArrayList serv_grp_limit_ind_list = new ArrayList(); //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
	/*	ArrayList   amt_limit_ind_list			=	new ArrayList();
		ArrayList	srvLimit_replace_list				=	new ArrayList();
		ArrayList	srvLimit_replaceSrv_code_list		=	new ArrayList();
		ArrayList   srvLimit_refund_list					=	new ArrayList();
		ArrayList   srvLimit_refundAmt_list				=	new ArrayList();
		ArrayList   srvLimit_auto_refund_list			=	new ArrayList();
		ArrayList	srvLimit_roundTo_list  =	new ArrayList();
		ArrayList	srvLimit_roundInd_list  =	new ArrayList(); unused */
		String statusHdr="";
		//String daysValid=""; unused
		String blgClsCode = "";
		String fromDate="";
		String toDate="";
		String indicator="";
		String price1="";
		String factorAppl="";
		String cbType ="";//Muthu against 28192 on 09-08-12
		String cbServiceCode =	"";
		String cbAmtLmtInd	 =	"";
		String cbAmtLmt		 =	"";
		String srvLmtFactorAppl		 =	"";
	//	String cbUnlimited	 =	"";
		String factorRate	 =	"";
		String qtyLimit		 =	"";
		String refundAmt	 =	"";
		String factor_appl	 =	"";
		String itemCode      =  "";
		String itemDesc      =  "";
		String inExcl        =  "";
		String servIndLmt    =  "";
		String srvLtSrvCode	 =  "";
		String exludeSrv	 =  "";
		String servInd	     =  "";
		String rateChargInd  =  "";

		String ordCatlogCode =  "";
		String factorRateInd =  "";
		String replaceableYN =  "";
		String replServCode  =  "";
		String replOrder     =  "";
		String refundYN		 =  "";
		String sqlcb ="";
		String amt_limit_ind = "";
		StringBuffer sb = new StringBuffer( "" ) ;
		Hashtable messageHashtable=new Hashtable();
		Set<String>	keySet;
		Iterator<String> custIt;
		 //Added By Shikha For GHL-CRF-0520.1
		Iterator<String> blngGrpIt;
		String blng_grp_code="";
		String blng_grp_desc="";
		 //Ended By Shikha For GHL-CRF-0520.1
		
		String key="";
		String cust_grp_code="";
		String cust_grp_desc="";
		String cust_code="";
		String cust_desc="";
		String pkg_valid_days="";

		String pkgPriceClsCode="";
		String pkgPriceClsDesc="";
		String oPkgPriceClsCode="";
		String oPkgPriceClsDesc="";
		String glSmry="";
		String glSmryDesc="";
		String glSmryDisc="";
		String glSmryDiscDesc="";
		String VATapp		 = "";
		String VATpercent	 = "";
		String VATruleCoverage	 = "";
		String flagVal_cust="";
		String flagVal_blngGrp =""; //Added By Shikha For GHL-CRF-0520.1

		String blgClsDesc        = "";
		String type="";
		String service_code			="";
		String service_desc		="";
		String catalog_code			="";
		String catalog_desc		="";
		String ind			="";
		String factorOrRate		="";
		String 		qty_limit			="";
		String 		amt_limit		="";
		String 		replace		="N";
		String 		replaceSrv_code		="";
		String 		replaceSrv_desc		="";
		String 		replaceSrv_cat_code		="";
		String 		replaceSrv_cat_desc			="";
		String 		refund			="N";
		String		autoRefund		= "N";
		String      closePkg = "N";
		String cbService = "";
		String cbServiceDesc = "";;
		String srvLmt ="";
		String amountLimitInd = "";
		String amountLimit = "";
		String srvLimit_type		="";
		String 		srvLimit_service_code			="";
		String 	    srvLimit_service_desc		="";
		String 		exludeService			="N";
		String 		srvLimit_qty_limit		="";
		String 		srvLimit_amt_limit			="";
		String 		srvLimit_factor_appl			="";
		String 		srvLimit_amt_limit_ind	="";
		String 	    srvLimit_replace		="N";
		String 		srvLimit_replaceSrv_code="";
		String		srvLimit_replaceSrv_desc = "";
		String 		srvLimit_refund		="N";
		String 		srvLimit_refundAmt		="";
		String 		srvLimit_auto_refund			="N";
		String      srvLimit_roundTo = "";
		String      srvLimit_roundInd = "";
		String parent_service_code="";

		String splitReqd = "Y";//Split reqd
		String includeHomeMedication = "Y";		
		String blng_class_code="";
		String blng_class_desc="";
		String eff_from_date="";
		String eff_to_date="";
		String discount_type="";
		String discount  ="";
		String amtLmtInd = "";
		//GHL-CRF-0502 Starts
		String age_group_code ="";
		String specialty_code ="";
		String hdn_age_group ="";
		String specialty_desc ="";
		//GHL-CRF-0502 Ends
		String dailyLmtChkBx = "";//Added V190320-Aravindh/MMS-DM-CRF-0129
		String dailyLmtAmt = "";//Added V190320-Aravindh/MMS-DM-CRF-0129
		String dailyLmtGrossNet = "";//Added V190320-Aravindh/MMS-DM-CRF-0129
		String dailyLmtIndicator = "";//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		String dailyLmtQty = "";//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		//MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 15/6/2020 
		String poly_code="";
		String poly_desc="";
		//MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 15/6/2020
		String serv_grp_limit_ind = ""; //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
		StringTokenizer stKey;
		StringTokenizer	msgIds;
		String[] record;
		ArrayList cust_period_list=new ArrayList();
		ArrayList cust_price_list=new ArrayList();
		ArrayList cust_rate_srv_list=new ArrayList();
		ArrayList cust_rate_srv_excl_list=new ArrayList();
		ArrayList cust_charge_srv_list=new ArrayList();
		ArrayList cust_charge_srv_excl_list=new ArrayList();

		ArrayList inserted_cust_period_list=new ArrayList();
		ArrayList inserted_cust_rate_srv_list=new ArrayList();
		ArrayList inserted_cust_charge_srv_list=new ArrayList();
		CallableStatement cust_cstmt=null;
		CallableStatement cust_period_cstmt = null;
		CallableStatement cust_discount_cstmt = null;
		CallableStatement blng_grp_discount_cstmt = null;
		
		//Added By Shikha For GHL-CRF-0520.1
		ArrayList blng_grp_period_list=new ArrayList();
		ArrayList blng_grp_price_list=new ArrayList();
		ArrayList blng_grp_rate_srv_list=new ArrayList();
		ArrayList blng_grp_rate_srv_excl_list=new ArrayList();
		ArrayList blng_grp_charge_srv_list=new ArrayList();
		ArrayList blng_grp_charge_srv_excl_list=new ArrayList();
		ArrayList inserted_blng_grp_period_list=new ArrayList();
		ArrayList inserted_blng_grp_rate_srv_list=new ArrayList();
		ArrayList inserted_blng_grp_charge_srv_list=new ArrayList();
		CallableStatement blng_grp_cstmt=null;
		CallableStatement blng_grp_period_cstmt = null;
		//Ended By Shikha For GHL-CRF-0520.1
		
	try
	{
		con.setAutoCommit( false ) ;
		insertable = true;
		String cust_sql   ="{ call   blpackage.insertpackagecustdtls (?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?)}";
		cust_cstmt = con.prepareCall(cust_sql);
		String cust_period_sql   ="{ call   blpackage.insertpackagecustperiod (?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?)}";
		String cust_period_sql1   ="{ call   blpackage.insertpackagecustperiod (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?)}";

		String cust_price_sql="{ call   blpackage.insertpackagecustprice (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?)}";//Added by muthu
		CallableStatement cust_price_cstmt = con.prepareCall(cust_price_sql);
		//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - insertpackageserviceforcust
		//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - insertpackageserviceforcust
		String cust_rate_srv_sql="{ call   blpackage.insertpackageserviceforcust  (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";	 //Modified By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
		CallableStatement cust_rate_srv_cstmt = con.prepareCall(cust_rate_srv_sql);
		//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - insertpackageexclforcust
		//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - insertpackageexclforcust
		String cust_rate_srv_excl_sql="{ call   blpackage.insertpackageexclforcust  (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		CallableStatement cust_rate_srv_excl_cstmt = con.prepareCall(cust_rate_srv_excl_sql);
		//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - insertpackageserviceforcust
		//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - insertpackageserviceforcust
		String cust_charge_srv_sql="{ call   blpackage.insertpackageserviceforcust  (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";	 //Modified By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
		CallableStatement cust_charge_srv_cstmt = con.prepareCall(cust_charge_srv_sql);
		//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - insertpackageexclforcust
		//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - insertpackageexclforcust
		String cust_charge_srv_excl_sql="{ call   blpackage.insertpackageexclforcust  (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";	
		CallableStatement cust_charge_srv_excl_cstmt = con.prepareCall(cust_charge_srv_excl_sql);
		//MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 15/6/2020  ONE NEW  PARAMETRES -insertpackagecustdiscount
		String cust_discount_sql="{ call   blpackage.insertpackagecustdiscount  (?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?)}";
		String cust_discount_sql1="{ call   blpackage.insertpackagecustdiscount  (?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?)}";
		//MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 15/6/2020  ONE NEW  PARAMETRES -insertpackagecustdiscount
		
		String blng_grp_discount_sql="{ call   blpackage.insertpackagediscount  (?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?)}";
		String blng_grp_discount_sql1="{ call   blpackage.insertpackagediscount  (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?)}";
		
		//Added By Shikha For GHL-CRF-0520.1
		String blng_grp_sql   ="{ call   blpackage.insertpackagebgdtls (?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?)}";
		blng_grp_cstmt = con.prepareCall(blng_grp_sql);		
		String blng_grp_period_sql   ="{ call   blpackage.insertpackagebgperiod (?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?)}";
		String blng_grp_period_sql1   ="{ call   blpackage.insertpackagebgperiod (?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?)}";		
		String blng_grp_price_sql="{ call   blpackage.insertpackagebgprice (?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?)}";
		CallableStatement blng_grp_price_cstmt = con.prepareCall(blng_grp_price_sql);
		String blng_grp_rate_srv_sql="{ call   blpackage.insertpackageserviceforbg  (?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";	 
		CallableStatement blng_grp_rate_srv_cstmt = con.prepareCall(blng_grp_rate_srv_sql);
		String blng_grp_rate_srv_excl_sql="{ call   blpackage.insertpackageexclforbg  (?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		CallableStatement blng_grp_rate_srv_excl_cstmt = con.prepareCall(blng_grp_rate_srv_excl_sql);
		String blng_grp_charge_srv_sql="{ call   blpackage.insertpackageserviceforbg  (?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";	 
		CallableStatement blng_grp_charge_srv_cstmt = con.prepareCall(blng_grp_charge_srv_sql);
		String blng_grp_charge_srv_excl_sql="{ call   blpackage.insertpackageexclforbg  (?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";	
		CallableStatement blng_grp_charge_srv_excl_cstmt = con.prepareCall(blng_grp_charge_srv_excl_sql);
		//Ended By Shikha For GHL-CRF-0520.1
		
		try
		{
			if(insertable)
			{
			
				//String sqlblpackage="{ call   blpackage.InsertPackage('"+facility_id+"','"+packageCode+"','"+shortDesc+"','"+longDesc+"',to_date('"+effFromDate+"','dd/mm/yyyy'),to_date('"+effToDate+"','dd/mm/yyyy'),'"+applSexInd+"','"+minAgeInYrs+"','"+minAgeInMths+"','"+minAgeInDays+"','"+maxAgeInYrs+"','"+minAgeInMths+"','"+maxAgeInDays+"','"+OpYn+"','"+EmYn+"','"+IpYn+"','"+DcYn+"','"+orderAssociated+"','"+validDays+"','"+acrossEncounters+"','"+applicalbleTo+"','"+statusHdr+"','"+user_id+"',sysdate,'"+user_id+"',sysdate,'"+client_ip_address+"','"+facility_id+"','"+client_ip_address+"','"+facility_id+"',?,?,?)}";
				String sqlblpackage="{ call   blpackage.InsertPackage(?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?)}"; //added one param by kdah-crf-0503

				cstmt = con.prepareCall(sqlblpackage);
				cstmt.setString(1,facility_id);
				cstmt.setString(2,packageCode);
				cstmt.setString(3,shortDesc);
				cstmt.setString(4,longDesc);
				cstmt.setString(5,effFromDate);
				cstmt.setString(6,effToDate);
				cstmt.setString(7,applSexInd);
				cstmt.setString(8,minAgeInYrs);
				cstmt.setString(9,minAgeInMths);
				cstmt.setString(10,minAgeInDays);
				cstmt.setString(11,maxAgeInYrs);
				cstmt.setString(12,maxAgeInMths);
				cstmt.setString(13,maxAgeInDays);
				cstmt.setString(14,OpYn);
				cstmt.setString(15,EmYn);
				cstmt.setString(16,IpYn);
				cstmt.setString(17,DcYn);
			/*Newly added by muthu against 31103
			if(orderAssociated == null || orderAssociated !="Y")
					orderAssociated ="N";
			//Newly added by muthu against 31103*/
				cstmt.setString(18,orderAssociated);
				cstmt.setString(19,validDays);
				cstmt.setString(20,acrossEncounters);
				cstmt.setString(21,applicalbleTo);
				cstmt.setString(22,approvedYN);
				cstmt.setString(23,approvedBy);
				cstmt.setString(24,approvedDate);
				cstmt.setString(25,statusHdr);
				cstmt.setString(26,user_id);
				cstmt.setString(27,user_id);
				cstmt.setString(28,client_ip_address);
				cstmt.setString(29,facility_id);
				cstmt.setString(30,client_ip_address);
				cstmt.setString(31,facility_id);
				cstmt.registerOutParameter(32,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(33,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(34,java.sql.Types.VARCHAR);
				cstmt.setString(35,isMasterPkgYn); //Added V190325 Gayathri/KDAH-CRF-0503
				cstmt.execute();

				str_error_level=cstmt.getString(32);
				str_sysmesage_id=cstmt.getString(33);
				str_error_text=cstmt.getString(34);
				if(str_error_level==null) str_error_level="";
				if(str_sysmesage_id==null) str_sysmesage_id="";
				if(str_error_text==null) str_error_text="";
				cstmt.close();

				if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
				{
					insertable=false;
				}
				else
				{
					insertable = true;
				}
			}//insertable
		}
		catch(Exception e)
		{
			insertable=false;
			sys_err.append(" Exception while calling blpackage.InsertPackage:"+e);
			System.err.println("Exception in blpackage.InsertPackage Call:"+e);
			e.printStackTrace();
		}
		/*Package base period(date) insertion - start*/
		try
		{
			if(insertable)
			{
				System.out.println("597 Package base period(date) manager ");
				if(baseDates.containsKey(packageCode))
				{
					ArrayList dtlsArray	     =	(ArrayList)baseDates.get(packageCode);
					if(dtlsArray.size()>0)
					{
						priceFromDate  =	(ArrayList)dtlsArray.get(0);
						ArrayList priceToDate	 = (ArrayList)dtlsArray.get(1);
						ArrayList pkgPClsCode	 = (ArrayList)dtlsArray.get(2);
						ArrayList oPkgPClsCode	 = (ArrayList)dtlsArray.get(4);
						ArrayList glSmryList	 = (ArrayList)dtlsArray.get(7);
						ArrayList glSmryDiscList = (ArrayList)dtlsArray.get(9);
						//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts
						ArrayList VATappList = (ArrayList)dtlsArray.get(11);
						ArrayList VATpercentList = (ArrayList)dtlsArray.get(12);
						//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends
						String 	priceFromDte     = "";
						String 	priceToDte       = "";
						//Added two new parameters V180122-Gayathri/MMS-DM-CRF-0118
						String sqlblpackage="{ call   blpackage.insertpackageperiod(?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?)}";
						for(int i=0;i<priceFromDate.size(); i++)
						{
 							priceFromDte = com.ehis.util.DateUtils.convertDate((String)(priceFromDate.get(i)),"DMY",locale,"en");
 							priceToDte	 = com.ehis.util.DateUtils.convertDate((String)(priceToDate.get(i)),"DMY",locale,"en");
							cstmt = con.prepareCall(sqlblpackage);

							cstmt.setString(1,facility_id);
							cstmt.setString(2,packageCode);
							cstmt.setString(3,priceFromDte);
							cstmt.setString(4,priceToDte);
							cstmt.setString(5,(String)(pkgPClsCode.get(i)));
							cstmt.setString(6,(String)(oPkgPClsCode.get(i)));
							cstmt.setString(7,(String)(glSmryList.get(i)));
							cstmt.setString(8,(String)(glSmryDiscList.get(i)));
						//	cstmt.setString(8,(String)(VATappList.get(i)));
						//	cstmt.setString(8,(String)(VATpercentList.get(i)));
							cstmt.setString(9,user_id);
							cstmt.setString(10,user_id);
							cstmt.setString(11,client_ip_address);
							cstmt.setString(12,facility_id);
							cstmt.setString(13,client_ip_address);
							cstmt.setString(14,facility_id);
							cstmt.registerOutParameter(15,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(16,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(17,java.sql.Types.VARCHAR);
							//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts
							cstmt.setString(18,(String)(VATappList.get(i)));
							cstmt.setString(19,(String)(VATpercentList.get(i)));
							//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends
							cstmt.execute();
							str_error_level=cstmt.getString(15);
							str_sysmesage_id=cstmt.getString(16);
							str_error_text=cstmt.getString(17);
							if(str_error_level==null) str_error_level="";
							if(str_sysmesage_id==null) str_sysmesage_id="";
							if(str_error_text==null) str_error_text="";
							cstmt.close();
							if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
							{
								insertable=false;
								break;
							}
							else
							{
								insertable = true;
							}
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			insertable=false;
			System.err.println("Exception from insertpackageperiod :"+e);
			e.printStackTrace();
		}
		finally
		{
		}
		/*Package base period(date) insertion - end*/
		/*Package base price insertion*/
		try
		{
			if(insertable)
			{
				System.out.println("597 Package base price manager ");
				if(basePrice.containsKey(packageCode))
				{
					//String sqlblpackage="{ call   blpackage.insertpackagebaseprice(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?)}";
					String sqlblpackage="{ call   blpackage.insertpackagebaseprice(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?)}";//Added by Muthu against Factor CRF on 26-6-12
					HashMap basePriceDtls   = (HashMap)basePrice.get(packageCode);
					String fromDateBP = "";
					ArrayList blgClsCodeGrp		= new ArrayList();
					ArrayList indicatorGrp		= new ArrayList();
					ArrayList price				= new ArrayList();
					ArrayList roundToGrp		= new ArrayList();
					ArrayList roundIndGrp		= new ArrayList();
					ArrayList factorApplGrp		= new ArrayList();
					ArrayList depositGrp	 =	new ArrayList();
					ArrayList partialDepGrp	 =	new ArrayList();
					ArrayList minDepAmtindGrp=	new ArrayList();
					ArrayList minDepAmtGrp	 =	new ArrayList();
					ArrayList factorforServiceRateGrp = new ArrayList();//Added by Muthu against Factor CRF on 26-6-12

					ArrayList flag				= new ArrayList();
					ArrayList dtlsArray			= new ArrayList();
					for(int i=0;i<priceFromDate.size();i++)
					{
						fromDateBP = (String)priceFromDate.get(i);
						if(basePriceDtls.containsKey(fromDateBP))
						{
							dtlsArray =(ArrayList)basePriceDtls.get(fromDateBP);
							//System.out.println("sqlblpackage insertpackagebaseprice size "+dtlsArray.size());
							//System.out.println("sqlblpackage insertpackagebaseprice if "+dtlsArray);
							if(dtlsArray.size()>0)
							{

								blgClsCodeGrp		= (ArrayList)dtlsArray.get(0);
								indicatorGrp		= (ArrayList)dtlsArray.get(2);
								price				= (ArrayList)dtlsArray.get(3);
								roundToGrp			= (ArrayList)dtlsArray.get(4);
								roundIndGrp			= (ArrayList)dtlsArray.get(5);
								factorApplGrp		= (ArrayList)dtlsArray.get(6);
								flag				= (ArrayList)dtlsArray.get(7);
								depositGrp			= (ArrayList)dtlsArray.get(8);
								partialDepGrp		= (ArrayList)dtlsArray.get(9);
								minDepAmtindGrp		= (ArrayList)dtlsArray.get(10);
								minDepAmtGrp		= (ArrayList)dtlsArray.get(11);
								factorforServiceRateGrp = (ArrayList)dtlsArray.get(12);//Added by Muthu against Factor CRF on 26-6-12
								for(int j=0; j<blgClsCodeGrp.size(); j++)
								{
									//System.out.println("sqlblpackage blgClsCodeGrp for");
									cstmt = con.prepareCall(sqlblpackage);
									cstmt.setString(1,facility_id);
									cstmt.setString(2,packageCode);
									cstmt.setString(3,com.ehis.util.DateUtils.convertDate(fromDateBP,"DMY",locale,"en"));
									cstmt.setString(4,(String)(blgClsCodeGrp.get(j)));
									cstmt.setString(5,(String)(indicatorGrp.get(j)));
									cstmt.setString(6,(String)(price.get(j)));
									cstmt.setString(7,(String)(roundToGrp.get(j)));
									cstmt.setString(8,(String)(roundIndGrp.get(j)));
									cstmt.setString(9,(String)(depositGrp.get(j)));
									cstmt.setString(10,(String)(partialDepGrp.get(j)));
									cstmt.setString(11,(String)(minDepAmtindGrp.get(j)));
									cstmt.setString(12,(String)(minDepAmtGrp.get(j)));
									cstmt.setString(13,(String)(factorApplGrp.get(j)));
									cstmt.setString(14,(String)(factorforServiceRateGrp.get(j)));
									//cstmt.setDouble(14,factorforServiceRate);//Added by Muthu against Factor CRF on 26-6-12
									cstmt.setString(15,user_id);
									cstmt.setString(16,user_id);
									cstmt.setString(17,client_ip_address);
									cstmt.setString(18,facility_id);
									cstmt.setString(19,client_ip_address);
									cstmt.setString(20,facility_id);
									cstmt.registerOutParameter(21,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(22,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(23,java.sql.Types.VARCHAR);
									cstmt.execute();

									str_error_level=cstmt.getString(21);
									str_sysmesage_id=cstmt.getString(22);
									str_error_text=cstmt.getString(23);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									cstmt.close();
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insertable=false;
										break;
									}
									else
									{
										insertable = true;
									}
								}
							}
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			insertable=false;
			sys_err.append(" Exception while calling blpackage.InsertPackageBasePrice:"+e);
			System.err.println("Exception in blpackage.InsertPackageBasePrice Call:"+e);
			e.printStackTrace();
		}

		/*For Base Price insertion - end  */
		
			/*Child Package  insertion - start*/
		
		try
		{
			System.out.println("inside base period");
			if(insertable)
			{
				if(childPackages.containsKey(packageCode))
				{
					HashMap childPackdtl	     =	(HashMap)childPackages.get(packageCode);
					ArrayList child_pkgcode	 =new ArrayList();
					ArrayList child_pkgdesc	 = new ArrayList();
					ArrayList child_effFromDate	 =new ArrayList(); 
					ArrayList child_effToDate	 =new ArrayList(); 
				//	System.out.println("dtlsArray"+dtlsArray);
					String fromDateBP="";
					for(int i=0;i<priceFromDate.size();i++)
					{
						fromDateBP = (String)priceFromDate.get(i);
						if(childPackdtl.containsKey(fromDateBP))
						{
					ArrayList dtlsArray =(ArrayList)childPackdtl.get(fromDateBP);
					if(dtlsArray.size()>0)
					{					
						
						child_pkgcode=(ArrayList)dtlsArray.get(0);
						child_pkgdesc=(ArrayList)dtlsArray.get(1);
						child_effFromDate=(ArrayList)dtlsArray.get(2);
						child_effToDate=(ArrayList)dtlsArray.get(3);
						
						  /*java.util.Date utilDate = format.parse((String)inputParameters.get("child_effFromDate"));
						    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

						    partial_deposit_cstmt.setDate(3, sqlDate);*/
							String 	child_effFrmDate     = "";
						String 	childEffToDate       = "";
						
						String sqlblpackage="{ call  blpackage.insertchildpackage (?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,sysdate,?,?,?,sysdate,?,?,?,?,?)}";
						//System.out.println("sqlblpackage dfs - 503 - insertchildpackage==>  "+sqlblpackage);
						for(int j=0;j<child_effFromDate.size(); j++)
						{
 							
							child_effFrmDate = com.ehis.util.DateUtils.convertDate((String)(child_effFromDate.get(j)),"DMY",locale,"en");
							childEffToDate = com.ehis.util.DateUtils.convertDate((String)(child_effToDate.get(j)),"DMY",locale,"en");
							cstmt = con.prepareCall(sqlblpackage);
							cstmt.setString(1,facility_id);
							cstmt.setString(2,packageCode);
							cstmt.setString(3,(String)(child_pkgcode.get(j)));
							cstmt.setString(4,fromDateBP);
							cstmt.setString(5,child_effFrmDate);
							cstmt.setString(6,childEffToDate);
							cstmt.setString(7,user_id);
							cstmt.setString(8,client_ip_address);
							cstmt.setString(9,facility_id);
							cstmt.setString(10,user_id);
							cstmt.setString(11,client_ip_address);
							cstmt.setString(12,facility_id);
							cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(14,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(15,java.sql.Types.VARCHAR);
							cstmt.execute();
							str_error_level=cstmt.getString(13);
							str_sysmesage_id=cstmt.getString(14);
							str_error_text=cstmt.getString(15);
							if(str_error_level==null) str_error_level="";
							if(str_sysmesage_id==null) str_sysmesage_id="";
							if(str_error_text==null) str_error_text="";
							cstmt.close();
							if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
							{
								insertable=false;
								break;
							}
							else
							{
								insertable = true;
							}
						}
					}
				}
			}
				}
			}
		}
		catch(Exception e)
		{
			insertable=false;
			System.err.println("Exception from Child Package:"+e);
			e.printStackTrace();
		}
		finally
		{
		}
		/*Child Package insertion - end*/
		/*For charge based insertion  */
		System.out.println("For Charge Based Insertion 885="+insertable);
		try
		{
			if(insertable)
			{
				totRec = 0;
				if(includedItems_CB.size()>0 && includedItems_CB.containsKey(packageCode) )
				{
					String fromDateSer = "";
					for(int j=0;j<priceFromDate.size();j++)
					{
						fromDateSer = (String)priceFromDate.get(j);
						includedItemsFD_CB = (HashMap)includedItems_CB.get(packageCode);
						if(includedItemsFD_CB.containsKey(fromDateSer) && includedItemsFD_CB.size()>0 )
						{
							services =(ArrayList)includedItemsFD_CB.get(fromDateSer);
							if(services.size()>0)
							{
								chargeTypeGroup     = (ArrayList)services.get(0);//Muthu against 28192 on 09-08-12
								serviceGroup		= (ArrayList)services.get(1);
								amtLmtIndGroup		= (ArrayList)services.get(3);
								amtLmtGroup			= (ArrayList)services.get(4);
								factor_applGroup    = (ArrayList)services.get(6);
								roundToGroup		= (ArrayList)services.get(7);
								roundIndGroup		= (ArrayList)services.get(8);
								refundGroup			= (ArrayList)services.get(9);
								refundAmtGroup		= (ArrayList)services.get(10);
								auto_refund_list	= (ArrayList)services.get(11);
								split_reqd_list		= (ArrayList)services.get(12);//Split reqd
								includeHomeMedication_list		= (ArrayList)services.get(13);
								/*serviceGroup		= (ArrayList)services.get(0);
								amtLmtIndGroup		= (ArrayList)services.get(2);
								amtLmtGroup			= (ArrayList)services.get(3);
								factor_applGroup    = (ArrayList)services.get(5);
								roundToGroup		= (ArrayList)services.get(6);
								roundIndGroup		= (ArrayList)services.get(7);
								refundGroup			= (ArrayList)services.get(8);
								refundAmtGroup		= (ArrayList)services.get(9);
								auto_refund_list	= (ArrayList)services.get(10);*/
								totRec = serviceGroup.size(); // Commented by MuthuN
								//totRec = chargeTypeGroup.size(); //Added by MuthuN
								for(int i=0; i<totRec; i++)
								{
									cbType		=(String)chargeTypeGroup.get(i);//Muthu against 28192 on 09-08-12
									//servInd	      =(String)typeGroup.get(i);//MuthuN against 28192
									cbServiceCode	=(String)serviceGroup.get(i);
									cbAmtLmtInd		=(String)amtLmtIndGroup.get(i);
									cbAmtLmt		=(String)amtLmtGroup.get(i);
									factor_appl		=(String)factor_applGroup.get(i);
									roundTo			= (String)roundToGroup.get(i);
									roundInd		= (String)roundIndGroup.get(i);
									refundYN		=(String)refundGroup.get(i);
									refundAmt		=(String)refundAmtGroup.get(i);
									auto_refund		=(String)auto_refund_list.get(i);
									splitReqd		=(String)split_reqd_list.get(i);
									
									includeHomeMedication		=(String)includeHomeMedication_list.get(i); //sarathkumar InclHmeMedi
									
									//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - insertpackageservice
									//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - insertpackageservice
									sqlcb  ="{ call   blpackage.insertpackageservice(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";//sarathkumar InclHmeMedi //Modified By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
													  
									cstmt = con.prepareCall(sqlcb);
									cstmt.setString(1,facility_id);
									cstmt.setString(2,packageCode);
									cstmt.setString(3,fromDateSer);
									cstmt.setString(4,cbServiceCode);
									cstmt.setString(5,cbType);//Muthu against 28192 on 09-08-12
									//System.out.println("cbtype testing ==> "+cbType);
									//cstmt.setString(5,"S");
									cstmt.setString(6,"C");
									cstmt.setString(7,"");
									cstmt.setString(8,"");
									cstmt.setString(9,factorRate );
									cstmt.setString(10,qtyLimit );
									cstmt.setString(11,cbAmtLmt);
									cstmt.setString(12,cbAmtLmtInd );
									cstmt.setString(13,"N");
									cstmt.setString(14,"");
									cstmt.setString(15,"" );
									cstmt.setString(16,refundYN );
									cstmt.setString(17,refundAmt );
									cstmt.setString(18,auto_refund);
									cstmt.setString(19,closePakgStat);
									cstmt.setString(20,roundTo);
									cstmt.setString(21,roundInd);
									cstmt.setString(22,factor_appl);
									cstmt.setString(23,user_id);
									cstmt.setString(24,user_id);
									cstmt.setString(25,client_ip_address);
									cstmt.setString(26,facility_id);
									cstmt.setString(27,client_ip_address);
									cstmt.setString(28,facility_id);
									cstmt.setString(29,splitReqd);//RRRR
									cstmt.setString(30,includeHomeMedication);
									cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(32,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(33,java.sql.Types.VARCHAR);
									cstmt.setString(34,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
									cstmt.setString(35,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
									cstmt.setString(36,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
									cstmt.setString(37,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
									cstmt.setString(38,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
									cstmt.setString(39,null);////Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020/Package Service Charge Based no need to pass any values
									cstmt.execute();

									str_error_level=cstmt.getString(31);
									str_sysmesage_id=cstmt.getString(32);					
									str_error_text=cstmt.getString(33);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									cstmt.close();
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insertable=false;
										break;
									}
									else
									{
										insertable = true;
									}
								}
							}
						}
					}
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("Exception from Charge based billing service :"+e);
			e.printStackTrace();
			insertable=false;
		}
		/*  Charge based exclusion iunsert --------start --------*/
		System.out.println("For Charge Based exclusion");
		try
		{
			if(insertable)
			{
				String fromDateSer	= "";
				int totalServices = 0;
				for(int k=0;k<priceFromDate.size();k++)
				{
					fromDateSer = (String)priceFromDate.get(k);
					itemsForService =  new ArrayList();
					if(includedItemsFD_CB.containsKey(fromDateSer) && includedItemsFD_CB.size()>0 )
					{
						services =(ArrayList)includedItemsFD_CB.get(fromDateSer);
						if(services.size()>0)
						{
							//chargeTypeGroup		= (ArrayList)services.get(0); //Added by MuthuN
							serviceGroup		= (ArrayList)services.get(1); // Commented by MuthuN
							totalServices		= serviceGroup.size(); // Commented by MuthuN
							//totalServices		= chargeTypeGroup.size(); //Added by MuthuN

						}
						else	totalServices = 0;
					}
					if(excludedItems_CB.containsKey(fromDateSer) )
					{

						excludedItemsFD_CB = (HashMap)excludedItems_CB.get(fromDateSer);
						for(int j=0; j<totalServices; j++)
						{
							cbServiceCode = (String)serviceGroup.get(j); // Commented by MuthuN
							//cbServiceCode = (String)chargeTypeGroup.get(j); //Added by MuthuN
							//System.out.println("855  cbServiceCode "+cbServiceCode);
							totRec = 0;
							if(itemsForService!=null) itemsForService.clear();
							if(excludedItemsFD_CB.containsKey(cbServiceCode) )
							{

								itemsForService =(ArrayList)excludedItemsFD_CB.get(cbServiceCode);
								if(itemsForService!=null && itemsForService.size()>0)
								{
									itemGroup				= (ArrayList)itemsForService.get(0);
									itemDescGroup			= (ArrayList)itemsForService.get(1);
									qtyLtGroup				= (ArrayList)itemsForService.get(2);
									amountLtGroup			= (ArrayList)itemsForService.get(3);
									inExcnGroup				= (ArrayList)itemsForService.get(4);
									split_reqd_list			= (ArrayList)itemsForService.get(5);//Split reqd
									includeHomeMedication_list			= (ArrayList)itemsForService.get(6); //sarathkumar InclHmeMedi
									totRec			= itemGroup.size();
									for(int i=0; i<totRec; i++)
									{
										if(itemGroup.size()>0)
										{
											itemCode	= (String)itemGroup.get(i);
											itemDesc	= (String)itemDescGroup.get(i);
											qtyLimit 	= (String)qtyLtGroup.get(i);
											cbAmtLmt    = (String)amountLtGroup.get(i);
											inExcl		= (String)inExcnGroup.get(i);
											splitReqd	= (String)split_reqd_list.get(i);
											includeHomeMedication	= (String)includeHomeMedication_list.get(i);
											if(inExcl.equals("Y"))
												amtLmtInd = "";
											else
												amtLmtInd = "A";
											//srvLmtFactorAppl		= (String)srvLmtFactorApplGroup.get(i);
											//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - insertpackageexclusion
											//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - insertpackageexclusion
											sqlcb  ="{ call   blpackage.insertpackageexclusion(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; //sarathkumar InclHmeMedi
															  
											cstmt = con.prepareCall(sqlcb);
											cstmt.setString(1,facility_id);
											cstmt.setString(2,packageCode);
											cstmt.setString(3,fromDateSer);
											cstmt.setString(4,cbServiceCode);
											cstmt.setString(5,"S");
											cstmt.setString(6,"C");
											cstmt.setString(7,itemCode);
											cstmt.setString(8,"M");
											cstmt.setString(9,inExcl );
											cstmt.setString(10,amtLmtInd );
											cstmt.setString(11,qtyLimit );
											cstmt.setString(12,cbAmtLmt );
											cstmt.setString(13,"" );
											cstmt.setString(14,"" );
											cstmt.setString(15,"" );
											cstmt.setString(16,"" );
											cstmt.setString(17,"" );
											cstmt.setString(18,"" );
											cstmt.setString(19,"" );
											cstmt.setString(20,"" );
											cstmt.setString(21,user_id);
											cstmt.setString(22,user_id);
											cstmt.setString(23,client_ip_address);
											cstmt.setString(24,facility_id);
											cstmt.setString(25,client_ip_address);
											cstmt.setString(26,facility_id);
											cstmt.setString(27,splitReqd);//RRRR
											cstmt.setString(28,includeHomeMedication);
											cstmt.registerOutParameter(29,java.sql.Types.VARCHAR);
											cstmt.registerOutParameter(30,java.sql.Types.VARCHAR);
											cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
											cstmt.setString(32,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
											cstmt.setString(33,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
											cstmt.setString(34,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
											cstmt.setString(35,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
											cstmt.setString(36,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
											cstmt.execute();

											str_error_level=cstmt.getString(29);
											str_sysmesage_id=cstmt.getString(30);					
											str_error_text=cstmt.getString(31);
											if(str_error_level==null) str_error_level="";
											if(str_sysmesage_id==null) str_sysmesage_id="";
											if(str_error_text==null) str_error_text="";
											cstmt.close();
											if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
											{
												insertable=false;
												break;
											}
											else
											{
												insertable = true;
											}
										}
									}
								}
							}
						}
					}
					if(itemsForService!=null)
					itemsForService.clear();
					if((!insertable))
						break;
				}
			//}
		}

		}
		catch (Exception e)
		{
			System.err.println("Exception from Charge based billing service exclusions insert :"+e);
			e.printStackTrace();
			insertable=false;
		}

		/* For Rate Based insertions  */
		System.out.println("For Rate Based insertions:"+insertable);
		try
		{
			if(insertable)
			{
				totRec = 0;
				//System.out.println("In Rate Based Insertion includedItems_RB:"+includedItems_RB+"/"+packageCode);
				includedItemsFD_RB = (HashMap)includedItems_RB.get(packageCode);
				//System.out.println("In Rate Based Insertion includedItemsFD_RB:"+includedItemsFD_RB);
				if(includedItems_RB.size()>0 && includedItems_RB.containsKey(packageCode) )
				{
					String fromDateSer = "";
					for(int j=0;j<priceFromDate.size();j++)
					{
						fromDateSer = (String)priceFromDate.get(j);
						//System.out.println("fromDateSer:"+fromDateSer);
						if(includedItemsFD_RB !=null && includedItemsFD_RB.size()>0 && includedItemsFD_RB.containsKey(fromDateSer) )
						{
							services =(ArrayList)includedItemsFD_RB.get(fromDateSer);
							if(services.size()>0)
							{
								//System.out.println("services > 0");
		   						typeGroup    =  (ArrayList)services.get(0);
								serviceGroup = (ArrayList)services.get(1);
								catalogGroup = (ArrayList)services.get(3);
								indGroup= (ArrayList)services.get(5);
								factorOrRateGroup= (ArrayList)services.get(6);
								qtyLtGroup= (ArrayList)services.get(7);
								amtLmtIndGroup= (ArrayList)services.get(8);
								amtLmtGroup= (ArrayList)services.get(9);
								replaceGroup= (ArrayList)services.get(10);
								replaceSrvGroup= (ArrayList)services.get(11);
								replaceSrv_catGroup= (ArrayList)services.get(13);
								refundGroup= (ArrayList)services.get(15);
								refundAmtGroup= (ArrayList)services.get(16);
								factor_applGroup= (ArrayList)services.get(17);
								auto_refund_list		= (ArrayList)services.get(19);
								roundTo_list			= (ArrayList)services.get(20);
								roundInd_list			= (ArrayList)services.get(21);
								closePkg_list			= (ArrayList)services.get(22);
								split_reqd_list			= (ArrayList)services.get(23);//Split reqd
								includeHomeMedication_list			= (ArrayList)services.get(24);
								dailyLmtChkBxList		 = (ArrayList)services.get(26);//Added V190320-Aravindh/MMS-DM-CRF-0129
								dailyLmtAmtList			 = (ArrayList)services.get(27);//Added V190320-Aravindh/MMS-DM-CRF-0129
								dailyLmtGrossNetList	 = (ArrayList)services.get(28);//Added V190320-Aravindh/MMS-DM-CRF-0129
								dailyLmtIndicatorList 	 = (ArrayList)services.get(29);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
								dailyLmtQtyList 		 = (ArrayList)services.get(30);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
								serv_grp_limit_ind_list = (ArrayList)services.get(31);//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
								totRec = serviceGroup.size();
								for(int i=0; i<totRec; i++)
								{
									cbServiceCode =(String)serviceGroup.get(i);
									servInd	      =(String)typeGroup.get(i);
									rateChargInd  = "R";
									ordCatlogCode =(String)catalogGroup.get(i);
									factorRateInd =(String)indGroup.get(i);
									factorRate	  =(String)factorOrRateGroup.get(i);
									qtyLimit      =(String)qtyLtGroup.get(i);
									cbAmtLmtInd   =(String)amtLmtIndGroup.get(i);
									cbAmtLmt	  =(String)amtLmtGroup.get(i);
									//cbUnlimited   =(String)unlimitedGroup.get(i);
									replaceableYN =(String)replaceGroup.get(i);
									replServCode  =(String)replaceSrvGroup.get(i);
									replOrder	  =(String)replaceSrv_catGroup.get(i);
									refundYN	  =(String)refundGroup.get(i);
									refundAmt	  =(String)refundAmtGroup.get(i);
									factor_appl	  =(String)factor_applGroup.get(i);
									auto_refund	  =(String)auto_refund_list.get(i);
									roundTo		  =(String)roundTo_list.get(i);
									roundInd	  =(String)roundInd_list.get(i);
									closePakgStat =(String)closePkg_list.get(i);
									splitReqd	  =(String)split_reqd_list.get(i);//Split reqd
									includeHomeMedication	  =(String)includeHomeMedication_list.get(i); //sarathkumar InclHmeMedi
									//Added V190320-Aravindh/MMS-DM-CRF-0129/Starts
									dailyLmtChkBx = (String) dailyLmtChkBxList.get(i);
									dailyLmtAmt = (String) dailyLmtAmtList.get(i);
									dailyLmtGrossNet = (String) dailyLmtGrossNetList.get(i);
									if(null == dailyLmtChkBx || "".equals(dailyLmtChkBx)) {
										dailyLmtChkBx = "N";
									}
									if(null == dailyLmtGrossNet || "".equals(dailyLmtGrossNet)) {
										dailyLmtGrossNet = "G";
									}
									//Added V190320-Aravindh/MMS-DM-CRF-0129/Ends
									dailyLmtIndicator = (String) dailyLmtIndicatorList.get(i);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
									if("*".equals(dailyLmtIndicator)){
										dailyLmtIndicator = "";
									}//Added V190626-Aravindh/MMS-DM-CRF-0129.1
									dailyLmtQty = (String) dailyLmtQtyList.get(i);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
									serv_grp_limit_ind = (String) serv_grp_limit_ind_list.get(i);   //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
									//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - insertpackageservice
									//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - insertpackageservice
									sqlcb  ="{ call   blpackage.insertpackageservice(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";//sarathkumar InclHmeMedi //Modified By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
									cstmt = con.prepareCall(sqlcb);
									cstmt.setString(1,facility_id);
									cstmt.setString(2,packageCode);
									cstmt.setString(3,fromDateSer);

									cstmt.setString(4,cbServiceCode);

									cstmt.setString(5,servInd);

									cstmt.setString(6,rateChargInd);

									cstmt.setString(7,ordCatlogCode);

									cstmt.setString(8,factorRateInd);

									cstmt.setString(9,factorRate );

									cstmt.setString(10,qtyLimit );

									cstmt.setString(11,cbAmtLmt);

									cstmt.setString(12,cbAmtLmtInd );

									cstmt.setString(13,replaceableYN);

									cstmt.setString(14,replServCode );

									cstmt.setString(15,replOrder );

									cstmt.setString(16,refundYN );

									cstmt.setString(17,refundAmt);

									cstmt.setString(18,auto_refund);

									cstmt.setString(19,closePakgStat);

									cstmt.setString(20,roundTo);

									cstmt.setString(21,roundInd);

									cstmt.setString(22,factor_appl);

									cstmt.setString(23,user_id);

									cstmt.setString(24,user_id);

									cstmt.setString(25,client_ip_address);

									cstmt.setString(26,facility_id);

									cstmt.setString(27,client_ip_address);

									cstmt.setString(28,facility_id);
									cstmt.setString(29,splitReqd);//RRRR
									cstmt.setString(30,includeHomeMedication);
									cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(32,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(33,java.sql.Types.VARCHAR);
									cstmt.setString(34,dailyLmtChkBx);//Added V190320-Aravindh/MMS-DM-CRF-0129
									cstmt.setString(35,dailyLmtAmt);//Added V190320-Aravindh/MMS-DM-CRF-0129
									cstmt.setString(36,dailyLmtGrossNet);//Added V190320-Aravindh/MMS-DM-CRF-0129
									cstmt.setString(37,dailyLmtIndicator);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
									cstmt.setString(38,dailyLmtQty);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
									cstmt.setString(39,serv_grp_limit_ind);//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
									cstmt.execute();
									str_error_level=cstmt.getString(31);
									str_sysmesage_id=cstmt.getString(32);					
									str_error_text=cstmt.getString(33);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									cstmt.close();
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insertable=false;
										break;
									}
									else
									{
										insertable = true;
									}
								}
								//System.out.println("All Records Inserted:"+insertable);
							}
						}
					}
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("Exception from rate based billing service :"+e);
			e.printStackTrace();
			insertable=false;
		}
/*Rate Based Service Limits*/
		try
		{
			System.out.println("For Rate Based Service Limits manager");
			if(insertable)
			{
				String fromDateSer = ""	;
				int totalServices = 0;
				ArrayList tempServices = new ArrayList();
					for(int k=0;k<priceFromDate.size();k++)
					{
						fromDateSer = (String)priceFromDate.get(k);
						if(includedItemsFD_RB !=null && includedItemsFD_RB.size()>0 && includedItemsFD_RB.containsKey(fromDateSer) )
						{
							tempServices =(ArrayList)includedItemsFD_RB.get(fromDateSer);
							if(tempServices.size()>0)
							{
		   						typeGroup    =  (ArrayList)tempServices.get(0);
								serviceGroup = (ArrayList)tempServices.get(1);
								totalServices = serviceGroup.size();
							}
						}
						if(excludedItems_RB.containsKey(fromDateSer) )
						{
						   excludedItemsFD_RB = (HashMap)excludedItems_RB.get(fromDateSer);

						   for(int j=0; j<totalServices; j++)
						   {
								cbServiceCode = (String)serviceGroup.get(j);
								servInd		 = (String)typeGroup.get(j);
								 totRec = 0;
								if(excludedItemsFD_RB.containsKey(cbServiceCode) )
								{
									itemsForService =(ArrayList)excludedItemsFD_RB.get(cbServiceCode);
									if(itemsForService!=null && itemsForService.size()>0)
									{
										srvLtTypeGroup= (ArrayList)itemsForService.get(0);
										srvLtSrvGroup= (ArrayList)itemsForService.get(1);
										exludeSrvGroup= (ArrayList)itemsForService.get(3);
										qtyLtGroup= (ArrayList)itemsForService.get(4);
										amountLtGroup= (ArrayList)itemsForService.get(5);
										srvLmtFactorApplGroup= (ArrayList)itemsForService.get(6);
										amtLmtIndGroup= (ArrayList)itemsForService.get(7);
										replaceGroup= (ArrayList)itemsForService.get(8);
										replaceSrvGroup= (ArrayList)itemsForService.get(9);
										refundGroup= (ArrayList)itemsForService.get(10);
										refundAmtGroup= (ArrayList)itemsForService.get(11);
										auto_refund_list		= (ArrayList)itemsForService.get(12);
										roundTo_list			= (ArrayList)itemsForService.get(13);
										roundInd_list			= (ArrayList)itemsForService.get(14);
										split_reqd_list			= (ArrayList)itemsForService.get(16);//Split reqd
										includeHomeMedication_list			= (ArrayList)itemsForService.get(17); //sarathkumar InclHmeMedi
										dailyLmtChkBxList		 = (ArrayList)itemsForService.get(19);//Added V190320-Aravindh/MMS-DM-CRF-0129
										dailyLmtAmtList			 = (ArrayList)itemsForService.get(20);//Added V190320-Aravindh/MMS-DM-CRF-0129
										dailyLmtGrossNetList	 = (ArrayList)itemsForService.get(21);//Added V190320-Aravindh/MMS-DM-CRF-0129
										dailyLmtIndicatorList	 = (ArrayList)itemsForService.get(22);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
										dailyLmtQtyList			 = (ArrayList)itemsForService.get(23);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
										totRec			= srvLtSrvGroup.size();
										for(int i=0; i<totRec; i++)
										{
											if(srvLtSrvGroup.size()>0)
											{
												servIndLmt 	= (String)srvLtTypeGroup.get(i);

												exludeSrv	= (String)exludeSrvGroup.get(i);

												srvLtSrvCode= (String)srvLtSrvGroup.get(i);

												qtyLimit 	= (String)qtyLtGroup.get(i);

												cbAmtLmt    = (String)amountLtGroup.get(i);

												srvLmtFactorAppl    = (String)srvLmtFactorApplGroup.get(i);

												amt_limit_ind	= (String)amtLmtIndGroup.get(i);

												replaceableYN = (String)replaceGroup.get(i);

												replServCode  = (String)replaceSrvGroup.get(i);

												refundYN	= (String)refundGroup.get(i);

												refundAmt	= (String)refundAmtGroup.get(i);

												auto_refund= (String)auto_refund_list.get(i);

												roundTo		= (String)roundTo_list.get(i);

												roundInd		= (String)roundInd_list.get(i);
												splitReqd	  =(String)split_reqd_list.get(i);//Split reqd
												includeHomeMedication	  =(String)includeHomeMedication_list.get(i);
												//Added V190320-Aravindh/MMS-DM-CRF-0129/Starts
												dailyLmtChkBx = (String) dailyLmtChkBxList.get(i);
												dailyLmtAmt = (String) dailyLmtAmtList.get(i);
												dailyLmtGrossNet = (String) dailyLmtGrossNetList.get(i);
												if(null == dailyLmtChkBx || "".equals(dailyLmtChkBx)) {
													dailyLmtChkBx = "N";
												}
												if(null == dailyLmtGrossNet || "".equals(dailyLmtGrossNet)) {
													dailyLmtGrossNet = "G";
												}
												//Added V190320-Aravindh/MMS-DM-CRF-0129/Ends
												dailyLmtIndicator = (String) dailyLmtIndicatorList.get(i);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
												if("*".equals(dailyLmtIndicator)){
													dailyLmtIndicator = "";
												}//Added V190626-Aravindh/MMS-DM-CRF-0129.1
												dailyLmtQty = (String) dailyLmtQtyList.get(i);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
										//inExcl		= (String)inExcnGroup.get(i);

											//exception ratebased exclusion sarath
												//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - insertpackageexclusion
												//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - insertpackageexclusion
												sqlcb  ="{ call   blpackage.insertpackageexclusion(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; //sarathkumar InclHmeMedi
												cstmt = con.prepareCall(sqlcb);
												cstmt.setString(1,facility_id);
												cstmt.setString(2,packageCode);
												cstmt.setString(3,fromDateSer);
												cstmt.setString(4,cbServiceCode);
												cstmt.setString(5,servInd);
												cstmt.setString(6,"R");
												cstmt.setString(7,srvLtSrvCode);
												cstmt.setString(8,servIndLmt);
												cstmt.setString(9,exludeSrv );
												cstmt.setString(10,amt_limit_ind );
												cstmt.setString(11,qtyLimit );
												cstmt.setString(12,cbAmtLmt );
												cstmt.setString(13,replaceableYN );
												cstmt.setString(14,replServCode);
												cstmt.setString(15,refundYN );

												cstmt.setString(16,refundAmt);

												cstmt.setString(17,auto_refund );
												cstmt.setString(18,roundTo );

												cstmt.setString(19,roundInd);

												cstmt.setString(20,srvLmtFactorAppl );

												cstmt.setString(21,user_id);

												cstmt.setString(22,user_id);

												cstmt.setString(23,client_ip_address);

												cstmt.setString(24,facility_id);

												cstmt.setString(25,client_ip_address);

												cstmt.setString(26,facility_id);

												cstmt.setString(27,splitReqd);//RRRR
												cstmt.setString(28,includeHomeMedication);
												cstmt.registerOutParameter(29,java.sql.Types.VARCHAR);
												cstmt.registerOutParameter(30,java.sql.Types.VARCHAR);
												cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
												cstmt.setString(32,dailyLmtChkBx);//Added V190320-Aravindh/MMS-DM-CRF-0129
												cstmt.setString(33,dailyLmtAmt);//Added V190320-Aravindh/MMS-DM-CRF-0129
												cstmt.setString(34,dailyLmtGrossNet);//Added V190320-Aravindh/MMS-DM-CRF-0129
												cstmt.setString(35,dailyLmtIndicator);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
												cstmt.setString(36,dailyLmtQty);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
												cstmt.execute();

												str_error_level=cstmt.getString(29);
												str_sysmesage_id=cstmt.getString(30);					
												str_error_text=cstmt.getString(31);
												if(str_error_level==null) str_error_level="";
												if(str_sysmesage_id==null) str_sysmesage_id="";
												if(str_error_text==null) str_error_text="";
												cstmt.close();
												if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
												{
													insertable=false;
													break;
												}
												else
												{
													insertable = true;
												}
											}
										}
									}
								}
							}
						}
						if (itemsForService!=null)
						{
							itemsForService.clear();
						}
						if((!insertable))
						break;
					}
			}
		}
		catch (Exception e)
		{
			System.err.println("Exception from rate based billing service exclusions :"+e);
			e.printStackTrace();
			insertable=false;
		}
		System.out.println("Customer Dtls*********start* applicalbleTo "+applicalbleTo);
		System.out.println("Customer Dtls*********start* insertable "+insertable);
		if(insertable && applicalbleTo!=null && !applicalbleTo.equals("A")){
		/***********Customer Dtls*********start************/
		System.out.println("Customer Dtls starts manager "+cust_dtls);
		try
		{
			if(insertable && cust_dtls!=null && cust_dtls.size()>0 )
			{

				/****************************************/
				keySet=(Set<String>)cust_dtls.keySet();
				custIt=keySet.iterator();
				while(insertable && custIt.hasNext()){
					record=new String[5];
					key=(String)custIt.next();
					record=(String[])cust_dtls.get(key);
					cust_grp_code		= record[0];
					cust_grp_desc		= record[1];
					cust_code	=	record[2];
					cust_desc		=record[3];
					pkg_valid_days		=record[4];
					cust_cstmt.setString(1,facility_id);
					cust_cstmt.setString(2,packageCode);
					cust_cstmt.setString(3,cust_grp_code);
					cust_cstmt.setString(4,cust_code);
					cust_cstmt.setString(5,pkg_valid_days);
					cust_cstmt.setString(6,user_id);
					cust_cstmt.setString(7,user_id);
					cust_cstmt.setString(8,client_ip_address);
					cust_cstmt.setString(9,facility_id);
					cust_cstmt.setString(10,client_ip_address);
					cust_cstmt.setString(11,facility_id);
					cust_cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
					cust_cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
					cust_cstmt.registerOutParameter(14,java.sql.Types.VARCHAR);
					cust_cstmt.execute();

					str_error_level=cust_cstmt.getString(12);
					str_sysmesage_id=cust_cstmt.getString(13);
					str_error_text=cust_cstmt.getString(14);
					if(str_error_level==null) str_error_level="";
					if(str_sysmesage_id==null) str_sysmesage_id="";
					if(str_error_text==null) str_error_text="";
					System.out.println("1601 str_error_level manager "+str_error_level);
					System.out.println("1601 str_error_level manager "+str_sysmesage_id);
					System.out.println("1601 str_error_level manager "+str_error_text);
					if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
					{
						insertable=false;
						sb.append("<br>"+str_error_text+"<br> ") ;
					}
					if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
					{
						insertable=false;
						if((str_error_level.equals("10") && !str_error_text.equals("") ))
						{
							sb.append("<br>"+str_error_text+"<br> ") ;
						}
						else
						{
							if(str_sysmesage_id.indexOf("|") != (-1)){
								msgIds=new StringTokenizer(str_sysmesage_id,"|");
								while(msgIds.hasMoreTokens())
								{
									messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
									sb.append((String)messageHashtable.get("message")+"<br>");
								}
							}else{
								messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
								sb.append((String)messageHashtable.get("message"));
							}
						}
					}
				}
				if(cust_cstmt!=null)
					cust_cstmt.close();
			}
		}
		catch (Exception e)
		{
			System.err.println("Exception from Customer dtls :"+e);
			e.printStackTrace();
			insertable=false;
		}
		/***********Customer Dtls*********end***********/
		/***********Customer Period Dtls*********Start***********/
		System.out.println("Customer Period Dtls starts manager "+cust_period);
		try
		{
			if(insertable && cust_period!=null && cust_period.size()>0 )
			{
				/****************************************/
				keySet=(Set<String>)cust_period.keySet();
				custIt=keySet.iterator();
				record=new String[6];
				while(insertable && custIt.hasNext()){
					key=(String)custIt.next();
					cust_period_list=(ArrayList)cust_period.get(key);
					if(cust_period_list!=null && cust_period_list.size()>0 ){
						stKey=new StringTokenizer(key,"~~");
						if(stKey.hasMoreTokens()){
							cust_grp_code=stKey.nextToken();
						}else{
							cust_grp_code="";
						}
						if(stKey.hasMoreTokens())
							cust_code=stKey.nextToken();
						else
							cust_code="";
						if(!cust_grp_code.equals("") && !cust_code.equals("") && cust_dtls!=null && cust_dtls.size()>0 && cust_dtls.containsKey(cust_grp_code+"~~"+cust_code)){
							for(int i=0;i<cust_period_list.size();i++){
								record=(String[])cust_period_list.get(i);
								fromDate		= record[0];
								toDate		= record[1];
								pkgPriceClsCode	=	record[2];
								pkgPriceClsDesc		=record[3];
								oPkgPriceClsCode		=record[4];
								oPkgPriceClsDesc		=record[5];
								glSmry		=record[6];
								glSmryDesc		=record[7];
								glSmryDisc		=record[8];
								glSmryDiscDesc		=record[9];
								//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts
								VATapp     =record[10];
								VATpercent  =record[11];
								VATruleCoverage  =record[12];
								flagVal_cust  =record[13];
								//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends
								
								if(insertable){

									if(toDate.equals("")){
										cust_period_cstmt = con.prepareCall(cust_period_sql1);
										toDate=null;
									}else{
										cust_period_cstmt = con.prepareCall(cust_period_sql);
									}
									cust_period_cstmt.setString(1,facility_id);
									cust_period_cstmt.setString(2,packageCode);
									cust_period_cstmt.setString(3,cust_grp_code);
									cust_period_cstmt.setString(4,cust_code);
									cust_period_cstmt.setString(5,fromDate);
									cust_period_cstmt.setString(6,toDate);
									cust_period_cstmt.setString(7,pkgPriceClsCode);
									cust_period_cstmt.setString(8,oPkgPriceClsCode);
									cust_period_cstmt.setString(9,glSmry);
									cust_period_cstmt.setString(10,glSmryDisc);
								
									cust_period_cstmt.setString(11,user_id);
									cust_period_cstmt.setString(12,user_id);
									cust_period_cstmt.setString(13,client_ip_address);
									cust_period_cstmt.setString(14,facility_id);
									cust_period_cstmt.setString(15,client_ip_address);
									cust_period_cstmt.setString(16,facility_id);
									cust_period_cstmt.registerOutParameter(17,java.sql.Types.VARCHAR);
									cust_period_cstmt.registerOutParameter(18,java.sql.Types.VARCHAR);
									cust_period_cstmt.registerOutParameter(19,java.sql.Types.VARCHAR);
									cust_period_cstmt.setString(20,VATapp);
									cust_period_cstmt.setString(21,VATpercent);
									cust_period_cstmt.setString(22,VATruleCoverage);
									cust_period_cstmt.execute();

									str_error_level=cust_period_cstmt.getString(17);
									str_sysmesage_id=cust_period_cstmt.getString(18);
									str_error_text=cust_period_cstmt.getString(19);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";

									if(str_sysmesage_id.equals("") && str_error_text.equals(""))
										inserted_cust_period_list.add(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim());
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insertable=false;
										sb.append("<br>"+str_error_text+"<br> ") ;
									}
									if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
									{
										insertable=false;
										if((str_error_level.equals("10") && !str_error_text.equals("") ))
										{
											sb.append("<br>"+str_error_text+"<br> ") ;
										}
										else
										{
											if(str_sysmesage_id.indexOf("|") != (-1)){
												msgIds=new StringTokenizer(str_sysmesage_id,"|");
												while(msgIds.hasMoreTokens())
												{
													messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
													sb.append((String)messageHashtable.get("message")+"<br>");
												}
											}else{
												messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
												sb.append((String)messageHashtable.get("message"));
											}
										}
									}
								}
							}//for loop
								if(cust_period_cstmt!=null) cust_period_cstmt.close(); //added by ram for chk style

						}//	if
					}
				}
				if(cust_period_cstmt!=null) cust_period_cstmt.close();
			}
		}
		catch (Exception e)
		{
			System.err.println("Exception from customer period insertion "+e);
			e.printStackTrace();
			insertable=false;
		}finally{
			try{
			if(cust_period_cstmt!=null) cust_period_cstmt.close();
			}catch(Exception s)
			{
				s.printStackTrace();
			}
		}


		/***********Customer Period Dtls*********end***********/
	/***********Customer Base Price Dtls*********Start***********/
		System.out.println("Customer Base price Dtls starts manager "+cust_base_price);
		System.out.println("Customer Base price Dtls insertable manager "+insertable);
		try
		{
			if(insertable && cust_base_price!=null && cust_base_price.size()>0 )
			{

				/****************************************/
				keySet=(Set<String>)cust_base_price.keySet();
				custIt=keySet.iterator();
				record=new String[12];	//muthu on 8/27/2012
				//record=new String[11];
				while(insertable && custIt.hasNext()){
					key=(String)custIt.next();
					cust_price_list=(ArrayList)cust_base_price.get(key);
					if(cust_price_list!=null && cust_price_list.size()>0){
						stKey=new StringTokenizer(key,"~~");
						if(stKey.hasMoreTokens()){
							cust_grp_code=stKey.nextToken();
						}else{
							cust_grp_code="";
						}
						if(stKey.hasMoreTokens())
							cust_code=stKey.nextToken();
						else
							cust_code="";
						if(stKey.hasMoreTokens())
							fromDate=stKey.nextToken();
						else
							fromDate="";

						if(!cust_grp_code.equals("") && !cust_code.equals("") &&  !fromDate.equals("") && cust_dtls!=null && cust_dtls.size()>0 && cust_dtls.containsKey(cust_grp_code.trim()+"~~"+cust_code.trim()) && inserted_cust_period_list!=null && inserted_cust_period_list.size()>0 && inserted_cust_period_list.contains(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim()) ){
							for(int i=0;i<cust_price_list.size();i++){
								record=(String[])cust_price_list.get(i);
								blgClsCode		= record[0];
								blgClsDesc		= record[1];
								indicator	=	record[2];
								price1		=record[3];
								roundTo		=record[4];
								roundInd		=record[5];
								factorAppl		=record[6];
								deposit		   =record[7];
								partialDeposit =record[8];
								minDepAmtind   =record[9];
								minDepAmt	  =record[10];
								factorforServiceRate = record[11];//Added by muthu for Factor for service rate issue for KDAH on 26-6-12

								if(insertable){
									cust_price_cstmt.setString(1,facility_id);
									cust_price_cstmt.setString(2,packageCode);
									cust_price_cstmt.setString(3,cust_grp_code);
									cust_price_cstmt.setString(4,cust_code);
									cust_price_cstmt.setString(5,fromDate);
									cust_price_cstmt.setString(6,blgClsCode);
									cust_price_cstmt.setString(7,indicator);
									cust_price_cstmt.setString(8,price1);
									cust_price_cstmt.setString(9,roundTo);
									cust_price_cstmt.setString(10,roundInd);
									cust_price_cstmt.setString(11,deposit );
									cust_price_cstmt.setString(12,partialDeposit );
									cust_price_cstmt.setString(13,minDepAmtind );
									cust_price_cstmt.setString(14,minDepAmt );
									cust_price_cstmt.setString(15,factorAppl );
									cust_price_cstmt.setString(16,factorforServiceRate ); //Added by muthu
									cust_price_cstmt.setString(17,user_id);
									cust_price_cstmt.setString(18,user_id);
									cust_price_cstmt.setString(19,client_ip_address);
									cust_price_cstmt.setString(20,facility_id);
									cust_price_cstmt.setString(21,client_ip_address);
									cust_price_cstmt.setString(22,facility_id);
									cust_price_cstmt.registerOutParameter(23,java.sql.Types.VARCHAR);
									cust_price_cstmt.registerOutParameter(24,java.sql.Types.VARCHAR);
									cust_price_cstmt.registerOutParameter(25,java.sql.Types.VARCHAR);
									cust_price_cstmt.execute();

									str_error_level=cust_price_cstmt.getString(23);
									str_sysmesage_id=cust_price_cstmt.getString(24);
									str_error_text=cust_price_cstmt.getString(25);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";


									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insertable=false;
										sb.append("<br>"+str_error_text+"<br> ") ;
									}
									if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
									{
										insertable=false;
										if((str_error_level.equals("10") && !str_error_text.equals("") ))
										{
											sb.append("<br>"+str_error_text+"<br> ") ;
											//System.out.println("sb mesage in Error is:"+sb);
										}
										else
										{
											if(str_sysmesage_id.indexOf("|") != (-1)){
												msgIds=new StringTokenizer(str_sysmesage_id,"|");
												while(msgIds.hasMoreTokens())
												{
													messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
													sb.append((String)messageHashtable.get("message")+"<br>");
												}
												//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
											}else{
												messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
												sb.append((String)messageHashtable.get("message"));
												//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
											}
										}
									}
								}
							}
						}
					}
				}
			if(cust_price_cstmt!=null) cust_price_cstmt.close();
			}
		}
		catch (Exception e)
		{
			System.err.println("Exception from customer base price insertion "+e);
			e.printStackTrace();
			insertable=false;
		}
		/***********Customer Base Price Dtls*********end***********/
		/***********Customer Rate Based Dtls*********Start***********/
		System.out.println("Customer rate base Dtls starts manager "+cust_rate_srv);
		try
		{
			System.out.println("insertable in manager 1916 "+insertable);
			if(insertable && cust_rate_srv!=null && cust_rate_srv.size()>0 )
			{
				System.out.println("Customer rate base Dtl manager 1917");
				/****************************************/
				keySet=(Set<String>)cust_rate_srv.keySet();
				custIt=keySet.iterator();
				record=new String[22];
				while(insertable && custIt.hasNext()){
					key=(String)custIt.next();
					cust_rate_srv_list=(ArrayList)cust_rate_srv.get(key);
					if(cust_rate_srv_list!=null && cust_rate_srv_list.size()>0){
						stKey=new StringTokenizer(key,"~~");
						if(stKey.hasMoreTokens()){
							cust_grp_code=stKey.nextToken();
						}else{
							cust_grp_code="";
						}
						if(stKey.hasMoreTokens())
							cust_code=stKey.nextToken();
						else
							cust_code="";
						if(stKey.hasMoreTokens())
							fromDate=stKey.nextToken();
						else
							fromDate="";
						System.out.println("Customer rate base Dtl manager inserted_cust_period_list "+inserted_cust_period_list);
						System.out.println("Customer rate base Dtl manager cust_dtls "+cust_dtls);
						System.out.println("Customer rate base Dtl manager cust_grp_code "+cust_grp_code);
						System.out.println("Customer rate base Dtl manager fromDate "+fromDate);
						System.out.println("Customer rate base Dtl manager cust_code "+cust_code);
						if(!cust_grp_code.equals("") && !cust_code.equals("") &&  !fromDate.equals("") && cust_dtls!=null && cust_dtls.size()>0 && cust_dtls.containsKey(cust_grp_code.trim()+"~~"+cust_code.trim()) && inserted_cust_period_list!=null && inserted_cust_period_list.size()>0 && inserted_cust_period_list.contains(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim()) ){
							System.out.println("Customer rate base Dtl manager 1945");
							for(int i=0;i<cust_rate_srv_list.size();i++){
								record=(String[])cust_rate_srv_list.get(i);
								type		= record[0];
								service_code		= record[1];
								service_desc	=record[2];
								System.out.println("cust service_desc in manager 1953 "+service_desc);
								catalog_code		=record[3];
								catalog_desc			= record[4];
								System.out.println("catalog_desc cust in manager 1956 "+catalog_desc);
								ind		= record[5];
								factorOrRate		= record[6];
								qty_limit		=record[7];
								amt_limit_ind	=record[8];
								amt_limit		= record[9];
								replace		= record[10];
								if(replace==null || replace.equals("") || replace.equals("null"))
									replace="N";
								replaceSrv_code= record[11];
								replaceSrv_desc		= record[12];
								System.out.println("replaceSrv_desc cust in manager 1967 "+replaceSrv_desc);
								replaceSrv_cat_code		=record[13];
								replaceSrv_cat_desc	= record[14];
								System.out.println("replaceSrv_cat_desc cust in manager 1970 "+replaceSrv_cat_desc);
								refund		=record[15];
								if(refund==null || refund.equals("") || refund.equals("null"))
									refund="N";
								refundAmt		= record[16];
								autoRefund		= record[17];
								factor_appl		= record[18];
								roundTo			= record[19];
								roundInd		= record[20];
								closePkg		=record[21];
								splitReqd	  =record[22];//Split reqd
								includeHomeMedication	  =record[23];
								dailyLmtChkBx = record[25];//Added V190320-Aravindh/MMS-DM-CRF-0129
								dailyLmtAmt = record[26];//Added V190320-Aravindh/MMS-DM-CRF-0129
								dailyLmtGrossNet = record[27];//Added V190320-Aravindh/MMS-DM-CRF-0129
								dailyLmtIndicator = record[28];//Added V190626-Aravindh/MMS-DM-CRF-0129.1
								if("*".equals(dailyLmtIndicator)){
									dailyLmtIndicator = "";
								}//Added V190626-Aravindh/MMS-DM-CRF-0129.1
								dailyLmtQty = record[29];//Added V190626-Aravindh/MMS-DM-CRF-0129.1
								serv_grp_limit_ind = record[30];  //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
								System.out.println("insertable cust in manager 1991 "+insertable);
								if(insertable){
									cust_rate_srv_cstmt.setString(1,facility_id);
									cust_rate_srv_cstmt.setString(2,packageCode);
									cust_rate_srv_cstmt.setString(3,cust_grp_code);
									cust_rate_srv_cstmt.setString(4,cust_code);
									cust_rate_srv_cstmt.setString(5,fromDate);
									cust_rate_srv_cstmt.setString(6,service_code);
									cust_rate_srv_cstmt.setString(7,type);
									cust_rate_srv_cstmt.setString(8,"R");
									cust_rate_srv_cstmt.setString(9,catalog_code);
									cust_rate_srv_cstmt.setString(10,ind);
									cust_rate_srv_cstmt.setString(11,factorOrRate);
									cust_rate_srv_cstmt.setString(12,qty_limit);
									cust_rate_srv_cstmt.setString(13,amt_limit);
									cust_rate_srv_cstmt.setString(14,amt_limit_ind);
									cust_rate_srv_cstmt.setString(15,replace);
									cust_rate_srv_cstmt.setString(16,replaceSrv_code);
									cust_rate_srv_cstmt.setString(17,replaceSrv_cat_code);
									cust_rate_srv_cstmt.setString(18,refund);
									cust_rate_srv_cstmt.setString(19,refundAmt);
									cust_rate_srv_cstmt.setString(20,autoRefund);
									cust_rate_srv_cstmt.setString(21,closePkg);
									cust_rate_srv_cstmt.setString(22,roundTo);
									cust_rate_srv_cstmt.setString(23,roundInd);
									cust_rate_srv_cstmt.setString(24,factor_appl);
									cust_rate_srv_cstmt.setString(25,user_id);
									cust_rate_srv_cstmt.setString(26,user_id);
									cust_rate_srv_cstmt.setString(27,client_ip_address);
									cust_rate_srv_cstmt.setString(28,facility_id);
									cust_rate_srv_cstmt.setString(29,client_ip_address);
									cust_rate_srv_cstmt.setString(30,facility_id);
									cust_rate_srv_cstmt.setString(31,splitReqd);//RRRR	
									cust_rate_srv_cstmt.setString(32,includeHomeMedication);
									cust_rate_srv_cstmt.registerOutParameter(33,java.sql.Types.VARCHAR);
									cust_rate_srv_cstmt.registerOutParameter(34,java.sql.Types.VARCHAR);
									cust_rate_srv_cstmt.registerOutParameter(35,java.sql.Types.VARCHAR);
									cust_rate_srv_cstmt.setString(36,dailyLmtChkBx);//Added V190320-Aravindh/MMS-DM-CRF-0129
									cust_rate_srv_cstmt.setString(37,dailyLmtAmt);//Added V190320-Aravindh/MMS-DM-CRF-0129
									cust_rate_srv_cstmt.setString(38,dailyLmtGrossNet);//Added V190320-Aravindh/MMS-DM-CRF-0129
									cust_rate_srv_cstmt.setString(39,dailyLmtIndicator);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
									cust_rate_srv_cstmt.setString(40,dailyLmtQty);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
									cust_rate_srv_cstmt.setString(41,serv_grp_limit_ind); //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
									cust_rate_srv_cstmt.execute();
									System.out.println("after execution cust in manager 2035");

									str_error_level=cust_rate_srv_cstmt.getString(33);
									str_sysmesage_id=cust_rate_srv_cstmt.getString(34);					
									str_error_text=cust_rate_srv_cstmt.getString(35);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									System.out.println("Customer rate base Dtl manager 2044 str_sysmesage_id "+str_sysmesage_id);
									System.out.println("Customer rate base Dtl manager str_error_text "+str_error_text);
									System.out.println("Customer rate base Dtl manager str_error_level "+str_error_level);
										
									if(str_sysmesage_id.equals("") && str_error_text.equals(""))
										inserted_cust_rate_srv_list.add(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim()+"~~"+service_code.trim());
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insertable=false;
										sb.append("<br>"+str_error_text+"<br> ") ;
									}
									if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
									{
										insertable=false;
										if((str_error_level.equals("10") && !str_error_text.equals("") ))
										{
											sb.append("<br>"+str_error_text+"<br> ") ;
											//System.out.println("sb mesage in Error is:"+sb);
										}
										else
										{
											if(str_sysmesage_id.indexOf("|") != (-1)){
												msgIds=new StringTokenizer(str_sysmesage_id,"|");
												while(msgIds.hasMoreTokens())
												{
													messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
													sb.append((String)messageHashtable.get("message")+"<br>");
												}
											}else{
												messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
												sb.append((String)messageHashtable.get("message"));
											}
										}
									}
								}
							}
						}
					}
				}
				if(cust_rate_srv_cstmt!=null) cust_rate_srv_cstmt.close();
			}
		}
		catch (Exception e)
		{
			System.err.println("Exception from customer rate based  insertion "+e);
			e.printStackTrace();
			insertable=false;
		}
		/***********Customer Rate Based Dtls*********end***********/
		/***********Customer Rate Based Excl Dtls*********Start***********/
		try
		{
			System.out.println("------Customer Rate Based Excl insertions,manager---------");
			System.out.println("------Customer Rate Based Excl insertions,manager-----cust_rate_srv_excl----"+cust_rate_srv_excl);
			System.out.println("------Customer Rate Based Excl insertions,manager-----insertable----"+insertable);
			if(insertable && cust_rate_srv_excl!=null && cust_rate_srv_excl.size()>0 )
			{

				/****************************************/
				keySet=(Set<String>)cust_rate_srv_excl.keySet();
				System.out.println("keySet="+keySet.toString());
				custIt=keySet.iterator();
				record=new String[16];
				while(insertable && custIt.hasNext()){
					key=(String)custIt.next();
					cust_rate_srv_excl_list=(ArrayList)cust_rate_srv_excl.get(key);
					if(cust_rate_srv_excl_list!=null && cust_rate_srv_excl_list.size()>0){
						stKey=new StringTokenizer(key,"~~");
						if(stKey.hasMoreTokens()){
							cust_grp_code=stKey.nextToken();
						}else{
							cust_grp_code="";
						}
						if(stKey.hasMoreTokens())
							cust_code=stKey.nextToken();
						else
							cust_code="";
						if(stKey.hasMoreTokens())
							fromDate=stKey.nextToken();
						else
							fromDate="";
						if(stKey.hasMoreTokens())
							parent_service_code=stKey.nextToken();
						else
							parent_service_code="";
						if(!cust_grp_code.equals("") && !cust_code.equals("") &&  !fromDate.equals("") &&  !parent_service_code.equals("") && cust_dtls!=null && cust_dtls.size()>0 && cust_dtls.containsKey(cust_grp_code+"~~"+cust_code) && inserted_cust_period_list!=null && inserted_cust_period_list.size()>0 && inserted_cust_period_list.contains(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim()) && inserted_cust_rate_srv_list!=null && inserted_cust_rate_srv_list.size()>0 && inserted_cust_rate_srv_list.contains(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim()+"~~"+parent_service_code.trim()) ){
							System.out.println("2130");
							for(int i=0;i<cust_rate_srv_excl_list.size();i++){
								record=(String[])cust_rate_srv_excl_list.get(i);
								srvLimit_type		= record[0];
								srvLimit_service_code		= record[1];
								srvLimit_service_desc	=record[2];
								exludeService		=record[3];
								if(exludeService==null || exludeService.equals("") || exludeService.equals("null"))
									exludeService="N";
								srvLimit_qty_limit			= record[4];
								srvLimit_amt_limit_ind	= record[5];
								srvLimit_amt_limit		= record[6];
								srvLimit_roundTo		= record[7];
								srvLimit_roundInd= record[8];
								srvLimit_replace		= record[9];
								srvLimit_replaceSrv_code		=record[10];
								srvLimit_replaceSrv_desc		=record[11];
								srvLimit_refund	= record[12];
								srvLimit_refundAmt		=record[13];
								srvLimit_auto_refund		=record[14];
								srvLimit_factor_appl		=record[15];
								splitReqd	=	record[16];//Split reqd
								includeHomeMedication	=	record[17];
								//Added V190320-Aravindh/MMS-DM-CRF-0129/Starts
								dailyLmtChkBx = record[19];
								dailyLmtAmt = record[20];
								dailyLmtGrossNet = record[21];
								if(null == dailyLmtChkBx || "".equals(dailyLmtChkBx)) {
									dailyLmtChkBx = "N";
								}
								if(null == dailyLmtGrossNet || "".equals(dailyLmtGrossNet)) {
									dailyLmtGrossNet = "G";
								}
								//Added V190320-Aravindh/MMS-DM-CRF-0129/Ends
								dailyLmtIndicator = record[22];//Added V190626-Aravindh/MMS-DM-CRF-0129.1
								if("*".equals(dailyLmtIndicator)){
									dailyLmtIndicator = "";
								}//Added V190626-Aravindh/MMS-DM-CRF-0129.1
								dailyLmtQty = record[23];//Added V190626-Aravindh/MMS-DM-CRF-0129.1
								System.out.println("2167 insertable "+insertable);
								if(insertable){
									cust_rate_srv_excl_cstmt.setString(1,facility_id);
									cust_rate_srv_excl_cstmt.setString(2,packageCode);
									cust_rate_srv_excl_cstmt.setString(3,cust_grp_code);
									cust_rate_srv_excl_cstmt.setString(4,cust_code);
									cust_rate_srv_excl_cstmt.setString(5,fromDate);
									cust_rate_srv_excl_cstmt.setString(6,parent_service_code);
									cust_rate_srv_excl_cstmt.setString(7,"");
									cust_rate_srv_excl_cstmt.setString(8,"R");
									cust_rate_srv_excl_cstmt.setString(9,srvLimit_service_code);
									cust_rate_srv_excl_cstmt.setString(10,srvLimit_type);
									cust_rate_srv_excl_cstmt.setString(11,exludeService);
									cust_rate_srv_excl_cstmt.setString(12,srvLimit_amt_limit_ind);
									cust_rate_srv_excl_cstmt.setString(13,srvLimit_qty_limit);
									cust_rate_srv_excl_cstmt.setString(14,srvLimit_amt_limit);
									cust_rate_srv_excl_cstmt.setString(15,srvLimit_replace);
									cust_rate_srv_excl_cstmt.setString(16,srvLimit_replaceSrv_code);
									cust_rate_srv_excl_cstmt.setString(17,srvLimit_refund);
									cust_rate_srv_excl_cstmt.setString(18,srvLimit_refundAmt);
									cust_rate_srv_excl_cstmt.setString(19,srvLimit_auto_refund);
									cust_rate_srv_excl_cstmt.setString(20,srvLimit_roundTo);
									cust_rate_srv_excl_cstmt.setString(21,srvLimit_roundInd);
									cust_rate_srv_excl_cstmt.setString(22,srvLimit_factor_appl);
									cust_rate_srv_excl_cstmt.setString(23,user_id);
									cust_rate_srv_excl_cstmt.setString(24,user_id);
									cust_rate_srv_excl_cstmt.setString(25,client_ip_address);
									cust_rate_srv_excl_cstmt.setString(26,facility_id);
									cust_rate_srv_excl_cstmt.setString(27,client_ip_address);
									cust_rate_srv_excl_cstmt.setString(28,facility_id);
									cust_rate_srv_excl_cstmt.setString(29,splitReqd);//RRRR	
									cust_rate_srv_excl_cstmt.setString(30,includeHomeMedication);
									cust_rate_srv_excl_cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
									cust_rate_srv_excl_cstmt.registerOutParameter(32,java.sql.Types.VARCHAR);
									cust_rate_srv_excl_cstmt.registerOutParameter(33,java.sql.Types.VARCHAR);
									cust_rate_srv_excl_cstmt.setString(34,dailyLmtChkBx);//Added V190320-Aravindh/MMS-DM-CRF-0129
									cust_rate_srv_excl_cstmt.setString(35,dailyLmtAmt);//Added V190320-Aravindh/MMS-DM-CRF-0129
									cust_rate_srv_excl_cstmt.setString(36,dailyLmtGrossNet);//Added V190320-Aravindh/MMS-DM-CRF-0129
									cust_rate_srv_excl_cstmt.setString(37,dailyLmtIndicator);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
									cust_rate_srv_excl_cstmt.setString(38,dailyLmtQty);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
									cust_rate_srv_excl_cstmt.execute();

									str_error_level=cust_rate_srv_excl_cstmt.getString(31);
									str_sysmesage_id=cust_rate_srv_excl_cstmt.getString(32);					
									str_error_text=cust_rate_srv_excl_cstmt.getString(33);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";


									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insertable=false;
										sb.append("<br>"+str_error_text+"<br> ") ;
									}
									if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
									{
										insertable=false;
										if((str_error_level.equals("10") && !str_error_text.equals("") ))
										{
											sb.append("<br>"+str_error_text+"<br> ") ;
											//System.out.println("sb mesage in Error is:"+sb);
										}
										else
										{
											if(str_sysmesage_id.indexOf("|") != (-1)){
												msgIds=new StringTokenizer(str_sysmesage_id,"|");
												while(msgIds.hasMoreTokens())
												{
													messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
													sb.append((String)messageHashtable.get("message")+"<br>");
												}
												//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
											}else{
												messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
												sb.append((String)messageHashtable.get("message"));
												//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
											}
										}
									}
								}
							}
						}
					}
				}
	if(cust_rate_srv_excl_cstmt!=null) cust_rate_srv_excl_cstmt.close();
			}
		}
		catch (Exception e)
		{
			System.err.println("Exception from customer rate based Excl insertion :"+e);
			e.printStackTrace();
			insertable=false;
		}
		/***********Customer Rate Based Excl Dtls*********end***********/
			/***********Customer Charge Based Dtls*********Start***********/
		try
		{
			if(insertable && cust_charge_srv!=null && cust_charge_srv.size()>0 )
			{

				/****************************************/
				keySet=(Set<String>)cust_charge_srv.keySet();
				custIt=keySet.iterator();
				//record=new String[10];
				record=new String[12];//Muthu
				//record=new String[11];//Muthu
				while(insertable && custIt.hasNext()){
					key=(String)custIt.next();
					cust_charge_srv_list=(ArrayList)cust_charge_srv.get(key);
					if(cust_charge_srv_list!=null && cust_charge_srv_list.size()>0){
						stKey=new StringTokenizer(key,"~~");
						if(stKey.hasMoreTokens()){
							cust_grp_code=stKey.nextToken();
						}else{
							cust_grp_code="";
						}
						if(stKey.hasMoreTokens())
							cust_code=stKey.nextToken();
						else
							cust_code="";
						if(stKey.hasMoreTokens())
							fromDate=stKey.nextToken();
						else
							fromDate="";
						if(!cust_grp_code.equals("") && !cust_code.equals("") &&  !fromDate.equals("") && cust_dtls!=null && cust_dtls.size()>0 && cust_dtls.containsKey(cust_grp_code.trim()+"~~"+cust_code.trim()) && inserted_cust_period_list!=null && inserted_cust_period_list.size()>0 && inserted_cust_period_list.contains(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim()) ){
							for(int i=0;i<cust_charge_srv_list.size();i++){
								record=(String[])cust_charge_srv_list.get(i);
								type			= record[0];//MuthuN against 28192
								//System.out.println("type ==> "+type);
								cbService		= record[1];
								cbServiceDesc	= record[2];
								amountLimitInd	=record[3];
								amountLimit		=record[4];
								roundTo		= record[5];
								roundInd		= record[6];
								refund		=record[7];
								if(refund==null || refund.equals("") || refund.equals("null"))
									refund="N";
								refundAmt	=record[8];
								autoRefund		= record[9];
								factorAppl			= record[10];
								srvLmt = record[11];//muthu on 8/27/2012
								splitReqd = record[12];//Split reqd
								includeHomeMedication = record[13];
								/*cbService		= record[0];
								cbServiceDesc		= record[1];
								amountLimitInd	=record[2];
								amountLimit		=record[3];
								roundTo		= record[4];
								roundInd		= record[5];
								refund		=record[6];
								if(refund==null || refund.equals("") || refund.equals("null"))
									refund="N";
								refundAmt	=record[7];
								autoRefund		= record[8];
								factorAppl			= record[9];*/

								if(insertable){
									cust_charge_srv_cstmt.setString(1,facility_id);
									cust_charge_srv_cstmt.setString(2,packageCode);
									cust_charge_srv_cstmt.setString(3,cust_grp_code);
									cust_charge_srv_cstmt.setString(4,cust_code);
									cust_charge_srv_cstmt.setString(5,fromDate);
									cust_charge_srv_cstmt.setString(6,cbService);
									cust_charge_srv_cstmt.setString(7,type);//Muthu against 28192
									//cust_charge_srv_cstmt.setString(7,"S");
									cust_charge_srv_cstmt.setString(8,"C");
									cust_charge_srv_cstmt.setString(9,"");
									cust_charge_srv_cstmt.setString(10,"");
									cust_charge_srv_cstmt.setString(11,"");
									cust_charge_srv_cstmt.setString(12,"");
									cust_charge_srv_cstmt.setString(13,amountLimit);
									cust_charge_srv_cstmt.setString(14,amountLimitInd);
									cust_charge_srv_cstmt.setString(15,"");
									cust_charge_srv_cstmt.setString(16,"");
									cust_charge_srv_cstmt.setString(17,"");
									cust_charge_srv_cstmt.setString(18,refund);
									cust_charge_srv_cstmt.setString(19,refundAmt);
									cust_charge_srv_cstmt.setString(20,autoRefund);
									cust_charge_srv_cstmt.setString(21,"");
									cust_charge_srv_cstmt.setString(22,roundTo);
									cust_charge_srv_cstmt.setString(23,roundInd);
									cust_charge_srv_cstmt.setString(24,factorAppl);
									cust_charge_srv_cstmt.setString(25,user_id);
									cust_charge_srv_cstmt.setString(26,user_id);
									cust_charge_srv_cstmt.setString(27,client_ip_address);
									cust_charge_srv_cstmt.setString(28,facility_id);
									cust_charge_srv_cstmt.setString(29,client_ip_address);
									cust_charge_srv_cstmt.setString(30,facility_id);
									cust_charge_srv_cstmt.setString(31,splitReqd);//RRRR
									cust_charge_srv_cstmt.setString(32,includeHomeMedication);
									cust_charge_srv_cstmt.registerOutParameter(33,java.sql.Types.VARCHAR);
									cust_charge_srv_cstmt.registerOutParameter(34,java.sql.Types.VARCHAR);
									cust_charge_srv_cstmt.registerOutParameter(35,java.sql.Types.VARCHAR);
									cust_charge_srv_cstmt.setString(36,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
									cust_charge_srv_cstmt.setString(37,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
									cust_charge_srv_cstmt.setString(38,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
									cust_charge_srv_cstmt.setString(39,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
									cust_charge_srv_cstmt.setString(40,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
									cust_charge_srv_cstmt.setString(41,null);//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020/Package Service Charge Based no need to pass any values
									cust_charge_srv_cstmt.execute();

									str_error_level=cust_charge_srv_cstmt.getString(33);
									str_sysmesage_id=cust_charge_srv_cstmt.getString(34);					
									str_error_text=cust_charge_srv_cstmt.getString(35);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";


									if(str_sysmesage_id.equals("") && str_error_text.equals(""))
										inserted_cust_charge_srv_list.add(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim()+"~~"+cbService.trim());
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insertable=false;
										sb.append("<br>"+str_error_text+"<br> ") ;
									}
									if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
									{
										insertable=false;
										if((str_error_level.equals("10") && !str_error_text.equals("") ))
										{
											sb.append("<br>"+str_error_text+"<br> ") ;
											//System.out.println("sb mesage in Error is:"+sb);
										}
										else
										{
											if(str_sysmesage_id.indexOf("|") != (-1)){
												msgIds=new StringTokenizer(str_sysmesage_id,"|");
												while(msgIds.hasMoreTokens())
												{
													messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
													sb.append((String)messageHashtable.get("message")+"<br>");
												}
											}else{
												messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
												sb.append((String)messageHashtable.get("message"));
											}
										}
									}
								}
							}

						}
					}
				}
				if(cust_charge_srv_cstmt!=null) cust_charge_srv_cstmt.close();
			}
		}
		catch (Exception e)
		{
			System.err.println("Exception from Customer Charge based Insertions :"+e);
			e.printStackTrace();
			insertable=false;
		}
		/***********Customer Charge Based Dtls*********end***********/
		/***********Customer Charge Based Excl Dtls*********Start***********/
		try
		{
			//System.out.println("------Customer Charge Based Excl insertions---------");
			if(insertable && cust_charge_srv_excl!=null && cust_charge_srv_excl.size()>0 )
			{

				/****************************************/
				keySet=(Set<String>)cust_charge_srv_excl.keySet();
				custIt=keySet.iterator();
				record=new String[5];
				while(insertable && custIt.hasNext()){
					key=(String)custIt.next();
					cust_charge_srv_excl_list=(ArrayList)cust_charge_srv_excl.get(key);
					if(cust_charge_srv_excl_list!=null && cust_charge_srv_excl_list.size()>0){
						stKey=new StringTokenizer(key,"~~");
						if(stKey.hasMoreTokens()){
							cust_grp_code=stKey.nextToken();
						}else{
							cust_grp_code="";
						}
						if(stKey.hasMoreTokens())
							cust_code=stKey.nextToken();
						else
							cust_code="";
						if(stKey.hasMoreTokens())
							fromDate=stKey.nextToken();
						else
							fromDate="";
						if(stKey.hasMoreTokens())
							parent_service_code=stKey.nextToken();
						else
							parent_service_code="";
						if(!cust_grp_code.equals("") && !cust_code.equals("") &&  !fromDate.equals("") &&  !parent_service_code.equals("") && cust_dtls!=null && cust_dtls.size()>0 && cust_dtls.containsKey(cust_grp_code+"~~"+cust_code) && inserted_cust_period_list!=null && inserted_cust_period_list.size()>0 && inserted_cust_period_list.contains(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim()) && inserted_cust_charge_srv_list!=null && inserted_cust_charge_srv_list.size()>0 && inserted_cust_charge_srv_list.contains(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim()+"~~"+parent_service_code.trim()) ){
							for(int i=0;i<cust_charge_srv_excl_list.size();i++){
								record=(String[])cust_charge_srv_excl_list.get(i);
								itemCode		= record[0];
								itemDesc		= record[1];
								inExcl	=record[2];
								if(inExcl==null || inExcl.equals("") || inExcl.equals("null"))
									inExcl="N";
								qtyLimit		=record[3];
								amountLimit			= record[4];
								splitReqd = record[5];//Split Reqd
								includeHomeMedication = record[6];
								if(insertable){
									cust_charge_srv_excl_cstmt.setString(1,facility_id);
									cust_charge_srv_excl_cstmt.setString(2,packageCode);
									cust_charge_srv_excl_cstmt.setString(3,cust_grp_code);
									cust_charge_srv_excl_cstmt.setString(4,cust_code);
									cust_charge_srv_excl_cstmt.setString(5,fromDate);
									cust_charge_srv_excl_cstmt.setString(6,parent_service_code);
									cust_charge_srv_excl_cstmt.setString(7,"S");
									cust_charge_srv_excl_cstmt.setString(8,"C");
									cust_charge_srv_excl_cstmt.setString(9,itemCode);
									cust_charge_srv_excl_cstmt.setString(10,"M");
									cust_charge_srv_excl_cstmt.setString(11,inExcl);
									cust_charge_srv_excl_cstmt.setString(12,"");
									cust_charge_srv_excl_cstmt.setString(13,qtyLimit);
									cust_charge_srv_excl_cstmt.setString(14,amountLimit);
									cust_charge_srv_excl_cstmt.setString(15,"");
									cust_charge_srv_excl_cstmt.setString(16,"");
									cust_charge_srv_excl_cstmt.setString(17,"");
									cust_charge_srv_excl_cstmt.setString(18,"");
									cust_charge_srv_excl_cstmt.setString(19,"");
									cust_charge_srv_excl_cstmt.setString(20,"");
									cust_charge_srv_excl_cstmt.setString(21,"");
									cust_charge_srv_excl_cstmt.setString(22,"");
									cust_charge_srv_excl_cstmt.setString(23,user_id);
									cust_charge_srv_excl_cstmt.setString(24,user_id);
									cust_charge_srv_excl_cstmt.setString(25,client_ip_address);
									cust_charge_srv_excl_cstmt.setString(26,facility_id);
									cust_charge_srv_excl_cstmt.setString(27,client_ip_address);
									cust_charge_srv_excl_cstmt.setString(28,facility_id);
									cust_charge_srv_excl_cstmt.setString(29,splitReqd);//RRRR	
									cust_charge_srv_excl_cstmt.setString(30,includeHomeMedication);//RRRR	
									cust_charge_srv_excl_cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
									cust_charge_srv_excl_cstmt.registerOutParameter(32,java.sql.Types.VARCHAR);
									cust_charge_srv_excl_cstmt.registerOutParameter(33,java.sql.Types.VARCHAR);
									cust_charge_srv_excl_cstmt.setString(34,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
									cust_charge_srv_excl_cstmt.setString(35,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
									cust_charge_srv_excl_cstmt.setString(36,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
									cust_charge_srv_excl_cstmt.setString(37,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
									cust_charge_srv_excl_cstmt.setString(38,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
									cust_charge_srv_excl_cstmt.execute();

									str_error_level=cust_charge_srv_excl_cstmt.getString(31);
									str_sysmesage_id=cust_charge_srv_excl_cstmt.getString(32);					
									str_error_text=cust_charge_srv_excl_cstmt.getString(33);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";


									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insertable=false;
										sb.append("<br>"+str_error_text+"<br> ") ;
									}
									if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
									{
										insertable=false;
										if((str_error_level.equals("10") && !str_error_text.equals("") ))
										{
											sb.append("<br>"+str_error_text+"<br> ") ;
											//System.out.println("sb mesage in Error is:"+sb);
										}
										else
										{
											if(str_sysmesage_id.indexOf("|") != (-1)){
												msgIds=new StringTokenizer(str_sysmesage_id,"|");
												while(msgIds.hasMoreTokens())
												{
													messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
													sb.append((String)messageHashtable.get("message")+"<br>");
												}
												//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
											}else{
												messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
												sb.append((String)messageHashtable.get("message"));
												//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
											}
										}
									}
								}
							}
						}
					}
				}
				if(cust_charge_srv_excl_cstmt!=null) cust_charge_srv_excl_cstmt.close();
			}
		}
		catch (Exception e)
		{
			System.err.println("Exception from customer Charge based Excl insertion :"+e);
			e.printStackTrace();
			insertable=false;
		}
		/***********Customer Charge Based Excl Dtls*********end***********/
		}
		//Added By Shikha For GHL-CRF-0520.1
		/***********Billing Group Dtls*********start***********/
		try
		{
//			System.out.println("2850 PkgDefManager billing group insert");
			if(insertable && blng_grp_dtls!=null && blng_grp_dtls.size()>0 )
			{
//				System.out.println("2853 PkgDefManager billing group insert 1");
				keySet=(Set<String>)blng_grp_dtls.keySet();
				blngGrpIt=keySet.iterator();
				while(insertable && blngGrpIt.hasNext()){
					record=new String[3];//IN73451 GHL-CRF-0520.1
					key=(String)blngGrpIt.next();
					record=(String[])blng_grp_dtls.get(key);
					blng_grp_code		= record[0];
					blng_grp_desc		= record[1];			
					pkg_valid_days		=record[2];//IN73451 GHL-CRF-0520.1
					blng_grp_cstmt.setString(1,facility_id);
					blng_grp_cstmt.setString(2,packageCode);
					blng_grp_cstmt.setString(3,blng_grp_code);
					blng_grp_cstmt.setString(4,pkg_valid_days);
					blng_grp_cstmt.setString(5,user_id);
					blng_grp_cstmt.setString(6,user_id);
					blng_grp_cstmt.setString(7,client_ip_address);
					blng_grp_cstmt.setString(8,facility_id);
					blng_grp_cstmt.setString(9,client_ip_address);
					blng_grp_cstmt.setString(10,facility_id);
					blng_grp_cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
					blng_grp_cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
					blng_grp_cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
					blng_grp_cstmt.execute();

					str_error_level=blng_grp_cstmt.getString(11);
					str_sysmesage_id=blng_grp_cstmt.getString(12);
					str_error_text=blng_grp_cstmt.getString(13);
					if(str_error_level==null) str_error_level="";
					if(str_sysmesage_id==null) str_sysmesage_id="";
					if(str_error_text==null) str_error_text="";

					if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
					{
						insertable=false;
						sb.append("<br>"+str_error_text+"<br> ") ;
					}
					if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
					{
						insertable=false;
						if((str_error_level.equals("10") && !str_error_text.equals("") ))
						{
							sb.append("<br>"+str_error_text+"<br> ") ;
						}
						else
						{
							if(str_sysmesage_id.indexOf("|") != (-1)){
								msgIds=new StringTokenizer(str_sysmesage_id,"|");
								while(msgIds.hasMoreTokens())
								{
									messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
									sb.append((String)messageHashtable.get("message")+"<br>");
								}
							}else{
								messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
								sb.append((String)messageHashtable.get("message"));
							}
						}
					}
				}
				if(blng_grp_cstmt!=null)
					blng_grp_cstmt.close();
			}
		}
		catch (Exception e)
		{
			System.err.println("Exception from Billing Group dtls :"+e);
			e.printStackTrace();
			insertable=false;
		}
		/***********Billing Group Dtls*********end***********/
		

		/***********Billing Group Period Dtls*********Start***********/
				try
				{
//					System.out.println("2918 PkgDefManager billing group insert 3");
					if(insertable && blng_grp_period!=null && blng_grp_period.size()>0 )
					{
//						System.out.println("2931 PkgDefManager billing group insert 4");
						/****************************************/
						keySet=(Set<String>)blng_grp_period.keySet();
						//System.out.println("keySet="+keySet.toString());
						blngGrpIt=keySet.iterator();
						record=new String[6];
						while(insertable && blngGrpIt.hasNext()){
							key=(String)blngGrpIt.next();
							blng_grp_period_list=(ArrayList)blng_grp_period.get(key);
							if(blng_grp_period_list!=null && blng_grp_period_list.size()>0 ){
								stKey=new StringTokenizer(key,"~~");
								if(stKey.hasMoreTokens()){
									blng_grp_code=stKey.nextToken();
								}else{
									blng_grp_code="";
								}
							
								if(!blng_grp_code.equals("")  && blng_grp_dtls!=null && blng_grp_dtls.size()>0 && blng_grp_dtls.containsKey(blng_grp_code)){
									for(int i=0;i<blng_grp_period_list.size();i++){
										record=(String[])blng_grp_period_list.get(i);
										fromDate		= record[0];
										toDate		= record[1];
										pkgPriceClsCode	=	record[2];
										pkgPriceClsDesc		=record[3];
										oPkgPriceClsCode		=record[4];
										oPkgPriceClsDesc		=record[5];
										glSmry		=record[6];
										glSmryDesc		=record[7];
										glSmryDisc		=record[8];
										glSmryDiscDesc		=record[9];
										VATapp     =record[10];
										VATpercent  =record[11];
										VATruleCoverage  =record[12];
										flagVal_blngGrp  =record[13];
									
										if(insertable){
											if(toDate.equals("")){
												blng_grp_period_cstmt = con.prepareCall(blng_grp_period_sql1);
												toDate=null;
											}else{
												blng_grp_period_cstmt = con.prepareCall(blng_grp_period_sql);
											}
											blng_grp_period_cstmt.setString(1,facility_id);
											blng_grp_period_cstmt.setString(2,packageCode);
											blng_grp_period_cstmt.setString(3,blng_grp_code);
											blng_grp_period_cstmt.setString(4,fromDate);
											blng_grp_period_cstmt.setString(5,toDate);
											blng_grp_period_cstmt.setString(6,pkgPriceClsCode);
											blng_grp_period_cstmt.setString(7,oPkgPriceClsCode);
											//System.out.println("glSmry="+glSmry);
											blng_grp_period_cstmt.setString(8,glSmry);
											blng_grp_period_cstmt.setString(9,glSmryDisc);								
											blng_grp_period_cstmt.setString(10,user_id);
											blng_grp_period_cstmt.setString(11,user_id);
											blng_grp_period_cstmt.setString(12,client_ip_address);
											blng_grp_period_cstmt.setString(13,facility_id);
											blng_grp_period_cstmt.setString(14,client_ip_address);
											blng_grp_period_cstmt.setString(15,facility_id);
											blng_grp_period_cstmt.registerOutParameter(16,java.sql.Types.VARCHAR);
											blng_grp_period_cstmt.registerOutParameter(17,java.sql.Types.VARCHAR);
											blng_grp_period_cstmt.registerOutParameter(18,java.sql.Types.VARCHAR);
											blng_grp_period_cstmt.setString(19,VATapp);
											blng_grp_period_cstmt.setString(20,VATpercent);
											blng_grp_period_cstmt.setString(21,VATruleCoverage);
											blng_grp_period_cstmt.execute();

											str_error_level=blng_grp_period_cstmt.getString(16);
											str_sysmesage_id=blng_grp_period_cstmt.getString(17);
											str_error_text=blng_grp_period_cstmt.getString(18);
											if(str_error_level==null) str_error_level="";
											if(str_sysmesage_id==null) str_sysmesage_id="";
											if(str_error_text==null) str_error_text="";
											if(str_sysmesage_id.equals("") && str_error_text.equals(""))
												inserted_blng_grp_period_list.add(blng_grp_code.trim()+"~~"+fromDate.trim());
											if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
											{
												insertable=false;
												sb.append("<br>"+str_error_text+"<br> ") ;
											}
											if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
											{
												insertable=false;
												if((str_error_level.equals("10") && !str_error_text.equals("") ))
												{
													sb.append("<br>"+str_error_text+"<br> ") ;
													//System.out.println("sb mesage in Error is:"+sb);
												}
												else
												{
													if(str_sysmesage_id.indexOf("|") != (-1)){
														msgIds=new StringTokenizer(str_sysmesage_id,"|");
														while(msgIds.hasMoreTokens())
														{
															messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
															sb.append((String)messageHashtable.get("message")+"<br>");
														}
														//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
													}else{
														messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
														sb.append((String)messageHashtable.get("message"));
														//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
													}
												}
											}
										}
									}//for loop
										if(blng_grp_period_cstmt!=null) blng_grp_period_cstmt.close(); //added by ram for chk style

								}//	if
							}
						}
						if(blng_grp_period_cstmt!=null) blng_grp_period_cstmt.close();
					}
				}
				catch (Exception e)
				{
					System.err.println("Exception from Billing Group period insertion "+e);
					e.printStackTrace();
					insertable=false;
				}finally{
					try{
					if(blng_grp_period_cstmt!=null) blng_grp_period_cstmt.close();
					}catch(Exception s)
					{
						s.printStackTrace();
					}
				}
				/***********Billing Group Period Dtls*********end***********/
			/***********Billing Group Base Price Dtls*********Start***********/
				
				try
				{
					//System.out.println("------Billing Group Base Price insertions---------");
					if(insertable && blng_grp_base_price!=null && blng_grp_base_price.size()>0 )
					{
						keySet=(Set<String>)blng_grp_base_price.keySet();
						//System.out.println("keySet="+keySet.toString());
						blngGrpIt=keySet.iterator();
						record=new String[12];	//muthu on 8/27/2012
						//record=new String[11];
						while(insertable && blngGrpIt.hasNext()){
							key=(String)blngGrpIt.next();
							blng_grp_price_list=(ArrayList)blng_grp_base_price.get(key);
							if(blng_grp_price_list!=null && blng_grp_price_list.size()>0){
								stKey=new StringTokenizer(key,"~~");
								if(stKey.hasMoreTokens()){
									blng_grp_code=stKey.nextToken();
								}else{
									blng_grp_code="";
								}						
								if(stKey.hasMoreTokens())
									fromDate=stKey.nextToken();
								else
									fromDate="";

								if(!blng_grp_code.equals("") &&  !fromDate.equals("") && blng_grp_dtls!=null && blng_grp_dtls.size()>0 && blng_grp_dtls.containsKey(blng_grp_code.trim()) && inserted_blng_grp_period_list!=null && inserted_blng_grp_period_list.size()>0 && inserted_blng_grp_period_list.contains(blng_grp_code.trim()+"~~"+fromDate.trim()) ){
									for(int i=0;i<blng_grp_price_list.size();i++){
										record=(String[])blng_grp_price_list.get(i);
										blgClsCode		= record[0];
										blgClsDesc		= record[1];
										indicator	=	record[2];
										price1		=record[3];
										roundTo		=record[4];
										roundInd		=record[5];
										factorAppl		=record[6];
										deposit		   =record[7];
										partialDeposit =record[8];
										minDepAmtind   =record[9];
										minDepAmt	  =record[10];
										factorforServiceRate = record[11];//Added by muthu for Factor for service rate issue for KDAH on 26-6-12

										if(insertable){
											blng_grp_price_cstmt.setString(1,facility_id);
											blng_grp_price_cstmt.setString(2,packageCode);
											blng_grp_price_cstmt.setString(3,blng_grp_code);
											blng_grp_price_cstmt.setString(4,fromDate);
											blng_grp_price_cstmt.setString(5,blgClsCode);
						//System.out.println("blgClsCode in DefManager.java ==> "+blgClsCode); //muthu
											blng_grp_price_cstmt.setString(6,indicator);
						//System.out.println("indicator in DefManager.java ==> "+indicator); //muthu
											blng_grp_price_cstmt.setString(7,price1);
						//System.out.println("price1 in DefManager.java ==> "+price1); //muthu
											blng_grp_price_cstmt.setString(8,roundTo);
						//System.out.println("roundTo in DefManager.java ==> "+roundTo); //muthu
											blng_grp_price_cstmt.setString(9,roundInd);
						//System.out.println("roundInd in DefManager.java ==> "+roundInd); //muthu
											blng_grp_price_cstmt.setString(10,deposit );
						//System.out.println("deposit in DefManager.java ==> "+deposit); //muthu
											blng_grp_price_cstmt.setString(11,partialDeposit );
						//System.out.println("partialDeposit in DefManager.java ==> "+partialDeposit); //muthu
											blng_grp_price_cstmt.setString(12,minDepAmtind );
						//System.out.println("minDepAmtind in DefManager.java ==> "+minDepAmtind); //muthu
											blng_grp_price_cstmt.setString(13,minDepAmt );
						//System.out.println("minDepAmt in DefManager.java ==> "+minDepAmt); //muthu
											blng_grp_price_cstmt.setString(14,factorAppl );
						//System.out.println("factorAppl in DefManager.java ==> "+factorAppl); //muthu
											blng_grp_price_cstmt.setString(15,factorforServiceRate ); //Added by muthu
								//System.out.println("factorAppl in DefManager.java ==> "+factorforServiceRate); //muthu
											blng_grp_price_cstmt.setString(16,user_id);
											blng_grp_price_cstmt.setString(17,user_id);
											blng_grp_price_cstmt.setString(18,client_ip_address);
											blng_grp_price_cstmt.setString(19,facility_id);
											blng_grp_price_cstmt.setString(20,client_ip_address);
											blng_grp_price_cstmt.setString(21,facility_id);
											blng_grp_price_cstmt.registerOutParameter(22,java.sql.Types.VARCHAR);
											blng_grp_price_cstmt.registerOutParameter(23,java.sql.Types.VARCHAR);
											blng_grp_price_cstmt.registerOutParameter(24,java.sql.Types.VARCHAR);
											blng_grp_price_cstmt.execute();

											str_error_level=blng_grp_price_cstmt.getString(22);
											str_sysmesage_id=blng_grp_price_cstmt.getString(23);
											str_error_text=blng_grp_price_cstmt.getString(24);
											if(str_error_level==null) str_error_level="";
											if(str_sysmesage_id==null) str_sysmesage_id="";
											if(str_error_text==null) str_error_text="";
											
											if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
											{
												insertable=false;
												sb.append("<br>"+str_error_text+"<br> ") ;
											}
											if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
											{
												insertable=false;
												if((str_error_level.equals("10") && !str_error_text.equals("") ))
												{
													sb.append("<br>"+str_error_text+"<br> ") ;
													//System.out.println("sb mesage in Error is:"+sb);
												}
												else
												{
													if(str_sysmesage_id.indexOf("|") != (-1)){
														msgIds=new StringTokenizer(str_sysmesage_id,"|");
														while(msgIds.hasMoreTokens())
														{
															messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
															sb.append((String)messageHashtable.get("message")+"<br>");
														}
														//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
													}else{
														messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
														sb.append((String)messageHashtable.get("message"));
														//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
													}
												}
											}
										}
									}
								}
							}
						}
					if(blng_grp_price_cstmt!=null) blng_grp_price_cstmt.close();
					}
				}
				catch (Exception e)
				{
					System.err.println("Exception from Billing Group base price insertion "+e);
					e.printStackTrace();
					insertable=false;
				}
				/***********Billing Group Base Price Dtls*********end***********/
				/***********Billing Group Rate Based Dtls*********Start***********/
				try
				{
					//System.out.println("------Billing Group Rate Based insertions---------");
					if(insertable && blng_grp_rate_srv!=null && blng_grp_rate_srv.size()>0 )
					{
						/****************************************/
						keySet=(Set<String>)blng_grp_rate_srv.keySet();
						//System.out.println("keySet Rate Billing Group="+keySet.toString());
						blngGrpIt=keySet.iterator();
						record=new String[22];
						while(insertable && blngGrpIt.hasNext()){
							key=(String)blngGrpIt.next();
							blng_grp_rate_srv_list=(ArrayList)blng_grp_rate_srv.get(key);
							if(blng_grp_rate_srv_list!=null && blng_grp_rate_srv_list.size()>0){
								stKey=new StringTokenizer(key,"~~");
								if(stKey.hasMoreTokens()){
									blng_grp_code=stKey.nextToken();
								}else{
									blng_grp_code="";
								}					
								if(stKey.hasMoreTokens())
									fromDate=stKey.nextToken();
								else
									fromDate="";
								if(!blng_grp_code.equals("") &&  !fromDate.equals("") && blng_grp_dtls!=null && blng_grp_dtls.size()>0 && blng_grp_dtls.containsKey(blng_grp_code.trim()) && inserted_blng_grp_period_list!=null && inserted_blng_grp_period_list.size()>0 && inserted_blng_grp_period_list.contains(blng_grp_code.trim()+"~~"+fromDate.trim()) ){
									for(int i=0;i<blng_grp_rate_srv_list.size();i++){
										record=(String[])blng_grp_rate_srv_list.get(i);
										type		= record[0];
										service_code		= record[1];
										service_desc	=record[2];
										catalog_code		=record[3];
										catalog_desc			= record[4];
										ind		= record[5];
										factorOrRate		= record[6];
										qty_limit		=record[7];
										amt_limit_ind	=record[8];
										amt_limit		= record[9];
										replace		= record[10];
										if(replace==null || replace.equals("") || replace.equals("null"))
											replace="N";
										replaceSrv_code= record[11];
										replaceSrv_desc		= record[12];
										replaceSrv_cat_code		=record[13];
										replaceSrv_cat_desc	= record[14];
										refund		=record[15];
										if(refund==null || refund.equals("") || refund.equals("null"))
											refund="N";
										refundAmt		= record[16];
										autoRefund		= record[17];
										factor_appl		= record[18];
										roundTo			= record[19];
										roundInd		= record[20];
										closePkg		=record[21];
										splitReqd	  =record[22];//Split reqd
										includeHomeMedication	  =record[23];
										dailyLmtChkBx = record[25];//Added V190320-Aravindh/MMS-DM-CRF-0129
										dailyLmtAmt = record[26];//Added V190320-Aravindh/MMS-DM-CRF-0129
										dailyLmtGrossNet = record[27];//Added V190320-Aravindh/MMS-DM-CRF-0129
										dailyLmtIndicator = record[28];//Added V190626-Aravindh/MMS-DM-CRF-0129.1
										if("*".equals(dailyLmtIndicator)){
											dailyLmtIndicator = "";
										}//Added V190626-Aravindh/MMS-DM-CRF-0129.1
										dailyLmtQty = record[29];//Added V190626-Aravindh/MMS-DM-CRF-0129.1
										
										if(insertable){
											blng_grp_rate_srv_cstmt.setString(1,facility_id);
											blng_grp_rate_srv_cstmt.setString(2,packageCode);
											blng_grp_rate_srv_cstmt.setString(3,blng_grp_code);
											blng_grp_rate_srv_cstmt.setString(4,fromDate);
											blng_grp_rate_srv_cstmt.setString(5,service_code);
											blng_grp_rate_srv_cstmt.setString(6,type);
											blng_grp_rate_srv_cstmt.setString(7,"R");
											blng_grp_rate_srv_cstmt.setString(8,catalog_code);
											blng_grp_rate_srv_cstmt.setString(9,ind);
											blng_grp_rate_srv_cstmt.setString(10,factorOrRate);
											blng_grp_rate_srv_cstmt.setString(11,qty_limit);
											blng_grp_rate_srv_cstmt.setString(12,amt_limit);
											blng_grp_rate_srv_cstmt.setString(13,amt_limit_ind);
											blng_grp_rate_srv_cstmt.setString(14,replace);
											blng_grp_rate_srv_cstmt.setString(15,replaceSrv_code);
											blng_grp_rate_srv_cstmt.setString(16,replaceSrv_cat_code);
											blng_grp_rate_srv_cstmt.setString(17,refund);
											blng_grp_rate_srv_cstmt.setString(18,refundAmt);
											blng_grp_rate_srv_cstmt.setString(19,autoRefund);
											blng_grp_rate_srv_cstmt.setString(20,closePkg);
											blng_grp_rate_srv_cstmt.setString(21,roundTo);
											blng_grp_rate_srv_cstmt.setString(22,roundInd);
											blng_grp_rate_srv_cstmt.setString(23,factor_appl);
											blng_grp_rate_srv_cstmt.setString(24,user_id);
											blng_grp_rate_srv_cstmt.setString(25,user_id);
											blng_grp_rate_srv_cstmt.setString(26,client_ip_address);
											blng_grp_rate_srv_cstmt.setString(27,facility_id);
											blng_grp_rate_srv_cstmt.setString(28,client_ip_address);
											blng_grp_rate_srv_cstmt.setString(29,facility_id);
											blng_grp_rate_srv_cstmt.setString(30,splitReqd);//RRRR	
											blng_grp_rate_srv_cstmt.setString(31,includeHomeMedication);
											blng_grp_rate_srv_cstmt.registerOutParameter(32,java.sql.Types.VARCHAR);
											blng_grp_rate_srv_cstmt.registerOutParameter(33,java.sql.Types.VARCHAR);
											blng_grp_rate_srv_cstmt.registerOutParameter(34,java.sql.Types.VARCHAR);
											blng_grp_rate_srv_cstmt.setString(35,dailyLmtChkBx);//Added V190320-Aravindh/MMS-DM-CRF-0129
											blng_grp_rate_srv_cstmt.setString(36,dailyLmtAmt);//Added V190320-Aravindh/MMS-DM-CRF-0129
											blng_grp_rate_srv_cstmt.setString(37,dailyLmtGrossNet);//Added V190320-Aravindh/MMS-DM-CRF-0129
											blng_grp_rate_srv_cstmt.setString(38,dailyLmtIndicator);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
											blng_grp_rate_srv_cstmt.setString(39,dailyLmtQty);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
											blng_grp_rate_srv_cstmt.execute();

											str_error_level=blng_grp_rate_srv_cstmt.getString(32);
											str_sysmesage_id=blng_grp_rate_srv_cstmt.getString(33);					
											str_error_text=blng_grp_rate_srv_cstmt.getString(34);
											if(str_error_level==null) str_error_level="";
											if(str_sysmesage_id==null) str_sysmesage_id="";
											if(str_error_text==null) str_error_text="";

											//System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
											//System.out.println("str_error_text in process:"+str_error_text);
											//System.out.println("str_error_text in process:"+str_error_text);

											if(str_sysmesage_id.equals("") && str_error_text.equals(""))
												inserted_blng_grp_rate_srv_list.add(blng_grp_code.trim()+"~~"+fromDate.trim()+"~~"+service_code.trim());
											if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
											{
												insertable=false;
												sb.append("<br>"+str_error_text+"<br> ") ;
											}
											if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
											{
												insertable=false;
												if((str_error_level.equals("10") && !str_error_text.equals("") ))
												{
													sb.append("<br>"+str_error_text+"<br> ") ;
													//System.out.println("sb mesage in Error is:"+sb);
												}
												else
												{
													if(str_sysmesage_id.indexOf("|") != (-1)){
														msgIds=new StringTokenizer(str_sysmesage_id,"|");
														while(msgIds.hasMoreTokens())
														{
															messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
															sb.append((String)messageHashtable.get("message")+"<br>");
														}
														//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
													}else{
														messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
														sb.append((String)messageHashtable.get("message"));
														//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
													}
												}
											}
										}
									}
								}
							}
						}
						if(blng_grp_rate_srv_cstmt!=null) blng_grp_rate_srv_cstmt.close();
		//System.out.println("inserted_blng_grp_rate_srv_list="+inserted_blng_grp_rate_srv_list.toString());
					}
				}
				catch (Exception e)
				{
					System.err.println("Exception from Billing Group rate based  insertion "+e);
					e.printStackTrace();
					insertable=false;
				}
				/***********Billing Group Rate Based Dtls*********end***********/
				/***********Billing Group Rate Based Excl Dtls*********Start***********/
				try
				{
					//System.out.println("------Billing Group Rate Based Excl insertions---------");
					if(insertable && blng_grp_rate_srv_excl!=null && blng_grp_rate_srv_excl.size()>0 )
					{

						/****************************************/
						keySet=(Set<String>)blng_grp_rate_srv_excl.keySet();
						//System.out.println("keySet="+keySet.toString());
						blngGrpIt=keySet.iterator();
						record=new String[16];
						while(insertable && blngGrpIt.hasNext()){
							key=(String)blngGrpIt.next();
							blng_grp_rate_srv_excl_list=(ArrayList)blng_grp_rate_srv_excl.get(key);
							if(blng_grp_rate_srv_excl_list!=null && blng_grp_rate_srv_excl_list.size()>0){
								stKey=new StringTokenizer(key,"~~");
								if(stKey.hasMoreTokens()){
									blng_grp_code=stKey.nextToken();
								}else{
									blng_grp_code="";
								}						
								if(stKey.hasMoreTokens())
									fromDate=stKey.nextToken();
								else
									fromDate="";
								if(stKey.hasMoreTokens())
									parent_service_code=stKey.nextToken();
								else
									parent_service_code="";
								if(!blng_grp_code.equals("") &&  !fromDate.equals("") &&  !parent_service_code.equals("") && blng_grp_dtls!=null && blng_grp_dtls.size()>0 && blng_grp_dtls.containsKey(blng_grp_code) && inserted_blng_grp_period_list!=null && inserted_blng_grp_period_list.size()>0 && inserted_blng_grp_period_list.contains(blng_grp_code.trim()+"~~"+fromDate.trim()) && inserted_blng_grp_rate_srv_list!=null && inserted_blng_grp_rate_srv_list.size()>0 && inserted_blng_grp_rate_srv_list.contains(blng_grp_code.trim()+"~~"+fromDate.trim()+"~~"+parent_service_code.trim()) ){
									for(int i=0;i<blng_grp_rate_srv_excl_list.size();i++){
										record=(String[])blng_grp_rate_srv_excl_list.get(i);
										srvLimit_type		= record[0];
										srvLimit_service_code		= record[1];
										srvLimit_service_desc	=record[2];
										exludeService		=record[3];
										if(exludeService==null || exludeService.equals("") || exludeService.equals("null"))
											exludeService="N";
										srvLimit_qty_limit			= record[4];
										srvLimit_amt_limit_ind	= record[5];
										srvLimit_amt_limit		= record[6];
										srvLimit_roundTo		= record[7];
										srvLimit_roundInd= record[8];
										srvLimit_replace		= record[9];
										srvLimit_replaceSrv_code		=record[10];
										srvLimit_replaceSrv_desc		=record[11];
										srvLimit_refund	= record[12];
										srvLimit_refundAmt		=record[13];
										srvLimit_auto_refund		=record[14];
										srvLimit_factor_appl		=record[15];
										splitReqd	=	record[16];//Split reqd
										includeHomeMedication	=	record[17];
										//Added V190320-Aravindh/MMS-DM-CRF-0129/Starts
										dailyLmtChkBx = record[19];
										dailyLmtAmt = record[20];
										dailyLmtGrossNet = record[21];
										if(null == dailyLmtChkBx || "".equals(dailyLmtChkBx)) {
											dailyLmtChkBx = "N";
										}
										if(null == dailyLmtGrossNet || "".equals(dailyLmtGrossNet)) {
											dailyLmtGrossNet = "G";
										}
										//Added V190320-Aravindh/MMS-DM-CRF-0129/Ends
										dailyLmtIndicator = record[22];//Added V190626-Aravindh/MMS-DM-CRF-0129.1
										if("*".equals(dailyLmtIndicator)){
											dailyLmtIndicator = "";
										}//Added V190626-Aravindh/MMS-DM-CRF-0129.1
										dailyLmtQty = record[23];//Added V190626-Aravindh/MMS-DM-CRF-0129.1
										if(insertable){
											blng_grp_rate_srv_excl_cstmt.setString(1,facility_id);
											blng_grp_rate_srv_excl_cstmt.setString(2,packageCode);
											blng_grp_rate_srv_excl_cstmt.setString(3,blng_grp_code);
											blng_grp_rate_srv_excl_cstmt.setString(4,fromDate);
											blng_grp_rate_srv_excl_cstmt.setString(5,parent_service_code);
											blng_grp_rate_srv_excl_cstmt.setString(6,"");
											blng_grp_rate_srv_excl_cstmt.setString(7,"R");
											blng_grp_rate_srv_excl_cstmt.setString(8,srvLimit_service_code);
											blng_grp_rate_srv_excl_cstmt.setString(9,srvLimit_type);
											blng_grp_rate_srv_excl_cstmt.setString(10,exludeService);
											blng_grp_rate_srv_excl_cstmt.setString(11,srvLimit_amt_limit_ind);
											blng_grp_rate_srv_excl_cstmt.setString(12,srvLimit_qty_limit);
											blng_grp_rate_srv_excl_cstmt.setString(13,srvLimit_amt_limit);
											blng_grp_rate_srv_excl_cstmt.setString(14,srvLimit_replace);
											blng_grp_rate_srv_excl_cstmt.setString(15,srvLimit_replaceSrv_code);
											blng_grp_rate_srv_excl_cstmt.setString(16,srvLimit_refund);
											blng_grp_rate_srv_excl_cstmt.setString(17,srvLimit_refundAmt);
											blng_grp_rate_srv_excl_cstmt.setString(18,srvLimit_auto_refund);
											blng_grp_rate_srv_excl_cstmt.setString(19,srvLimit_roundTo);
											blng_grp_rate_srv_excl_cstmt.setString(20,srvLimit_roundInd);
											blng_grp_rate_srv_excl_cstmt.setString(21,srvLimit_factor_appl);
											blng_grp_rate_srv_excl_cstmt.setString(22,user_id);
											blng_grp_rate_srv_excl_cstmt.setString(23,user_id);
											blng_grp_rate_srv_excl_cstmt.setString(24,client_ip_address);
											blng_grp_rate_srv_excl_cstmt.setString(25,facility_id);
											blng_grp_rate_srv_excl_cstmt.setString(26,client_ip_address);
											blng_grp_rate_srv_excl_cstmt.setString(27,facility_id);
											blng_grp_rate_srv_excl_cstmt.setString(28,splitReqd);//RRRR	
											blng_grp_rate_srv_excl_cstmt.setString(29,includeHomeMedication);
											blng_grp_rate_srv_excl_cstmt.registerOutParameter(30,java.sql.Types.VARCHAR);
											blng_grp_rate_srv_excl_cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
											blng_grp_rate_srv_excl_cstmt.registerOutParameter(32,java.sql.Types.VARCHAR);
											blng_grp_rate_srv_excl_cstmt.setString(33,dailyLmtChkBx);//Added V190320-Aravindh/MMS-DM-CRF-0129
											blng_grp_rate_srv_excl_cstmt.setString(34,dailyLmtAmt);//Added V190320-Aravindh/MMS-DM-CRF-0129
											blng_grp_rate_srv_excl_cstmt.setString(35,dailyLmtGrossNet);//Added V190320-Aravindh/MMS-DM-CRF-0129
											blng_grp_rate_srv_excl_cstmt.setString(36,dailyLmtIndicator);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
											blng_grp_rate_srv_excl_cstmt.setString(37,dailyLmtQty);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
											blng_grp_rate_srv_excl_cstmt.execute();

											str_error_level=blng_grp_rate_srv_excl_cstmt.getString(30);
											str_sysmesage_id=blng_grp_rate_srv_excl_cstmt.getString(31);					
											str_error_text=blng_grp_rate_srv_excl_cstmt.getString(32);
											if(str_error_level==null) str_error_level="";
											if(str_sysmesage_id==null) str_sysmesage_id="";
											if(str_error_text==null) str_error_text="";

											if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
											{
												insertable=false;
												sb.append("<br>"+str_error_text+"<br> ") ;
											}
											if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
											{
												insertable=false;
												if((str_error_level.equals("10") && !str_error_text.equals("") ))
												{
													sb.append("<br>"+str_error_text+"<br> ") ;
													//System.out.println("sb mesage in Error is:"+sb);
												}
												else
												{
													if(str_sysmesage_id.indexOf("|") != (-1)){
														msgIds=new StringTokenizer(str_sysmesage_id,"|");
														while(msgIds.hasMoreTokens())
														{
															messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
															sb.append((String)messageHashtable.get("message")+"<br>");
														}
													}else{
														messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
														sb.append((String)messageHashtable.get("message"));
													}
												}
											}
										}
									}
								}
							}
						}
						if(blng_grp_rate_srv_excl_cstmt!=null) blng_grp_rate_srv_excl_cstmt.close();
					}
				}
				catch (Exception e)
				{
					System.err.println("Exception from Billing Group rate based Excl insertion :"+e);
					e.printStackTrace();
					insertable=false;
				}
				/***********Billing Group Rate Based Excl Dtls*********end***********/
					/***********Billing Group Charge Based Dtls*********Start***********/
				try
				{
					//System.out.println("------Billing Group Charge Based insertions---------");
					if(insertable && blng_grp_charge_srv!=null && blng_grp_charge_srv.size()>0 )
					{
						keySet=(Set<String>)blng_grp_charge_srv.keySet();
						//System.out.println("keySet 2203="+keySet.toString());
						blngGrpIt=keySet.iterator();
						record=new String[12];
						while(insertable && blngGrpIt.hasNext()){
							key=(String)blngGrpIt.next();
							blng_grp_charge_srv_list=(ArrayList)blng_grp_charge_srv.get(key);
							if(blng_grp_charge_srv_list!=null && blng_grp_charge_srv_list.size()>0){
								stKey=new StringTokenizer(key,"~~");
								if(stKey.hasMoreTokens()){
									blng_grp_code=stKey.nextToken();
								}else{
									blng_grp_code="";
								}						
								if(stKey.hasMoreTokens())
									fromDate=stKey.nextToken();
								else
									fromDate="";
								if(!blng_grp_code.equals("") &&  !fromDate.equals("") && blng_grp_dtls!=null && blng_grp_dtls.size()>0 && blng_grp_dtls.containsKey(blng_grp_code.trim()) && inserted_blng_grp_period_list!=null && inserted_blng_grp_period_list.size()>0 && inserted_blng_grp_period_list.contains(blng_grp_code.trim()+"~~"+fromDate.trim()) ){
									for(int i=0;i<blng_grp_charge_srv_list.size();i++){
										record=(String[])blng_grp_charge_srv_list.get(i);
										type			= record[0];//MuthuN against 28192
										//System.out.println("type ==> "+type);
										cbService		= record[1];
										cbServiceDesc	= record[2];
										amountLimitInd	=record[3];
										amountLimit		=record[4];
										roundTo		= record[5];
										roundInd		= record[6];
										refund		=record[7];
										if(refund==null || refund.equals("") || refund.equals("null"))
											refund="N";
										refundAmt	=record[8];
										autoRefund		= record[9];
										factorAppl			= record[10];
										srvLmt = record[11];//muthu on 8/27/2012
										splitReqd = record[12];//Split reqd
										includeHomeMedication = record[13];
										if(insertable){
											blng_grp_charge_srv_cstmt.setString(1,facility_id);
											blng_grp_charge_srv_cstmt.setString(2,packageCode);
											blng_grp_charge_srv_cstmt.setString(3,blng_grp_code);
											blng_grp_charge_srv_cstmt.setString(4,fromDate);
											blng_grp_charge_srv_cstmt.setString(5,cbService);
											blng_grp_charge_srv_cstmt.setString(6,type);//Muthu against 28192
											blng_grp_charge_srv_cstmt.setString(7,"C");
											blng_grp_charge_srv_cstmt.setString(8,"");
											blng_grp_charge_srv_cstmt.setString(9,"");
											blng_grp_charge_srv_cstmt.setString(10,"");
											blng_grp_charge_srv_cstmt.setString(11,"");
											blng_grp_charge_srv_cstmt.setString(12,amountLimit);
						//System.out.println("amountLimit @ ChargePrice in DefManager.java ==> "+amountLimit); //muthu
											blng_grp_charge_srv_cstmt.setString(13,amountLimitInd);
						//System.out.println("amountLimitInd @ ChargePrice in DefManager.java ==> "+amountLimitInd); //muthu
											blng_grp_charge_srv_cstmt.setString(14,"");
											blng_grp_charge_srv_cstmt.setString(15,"");
											blng_grp_charge_srv_cstmt.setString(16,"");
											blng_grp_charge_srv_cstmt.setString(17,refund);
						//System.out.println("refund @ ChargePrice in DefManager.java ==> "+refund); //muthu
											blng_grp_charge_srv_cstmt.setString(18,refundAmt);
						//System.out.println("refundAmt @ ChargePrice in DefManager.java ==> "+refundAmt); //muthu
											blng_grp_charge_srv_cstmt.setString(19,autoRefund);
						//System.out.println("autoRefund @ ChargePrice in DefManager.java ==> "+autoRefund); //muthu
											blng_grp_charge_srv_cstmt.setString(20,"");
											blng_grp_charge_srv_cstmt.setString(21,roundTo);
											blng_grp_charge_srv_cstmt.setString(22,roundInd);
											blng_grp_charge_srv_cstmt.setString(23,factorAppl);
						//System.out.println("amountLimitInd @ ChargePrice in DefManager.java ==> "+amountLimitInd); //muthu
											blng_grp_charge_srv_cstmt.setString(24,user_id);
											blng_grp_charge_srv_cstmt.setString(25,user_id);
											blng_grp_charge_srv_cstmt.setString(26,client_ip_address);
											blng_grp_charge_srv_cstmt.setString(27,facility_id);
											blng_grp_charge_srv_cstmt.setString(28,client_ip_address);
											blng_grp_charge_srv_cstmt.setString(29,facility_id);
											blng_grp_charge_srv_cstmt.setString(30,splitReqd);//RRRR
											blng_grp_charge_srv_cstmt.setString(31,includeHomeMedication);
											blng_grp_charge_srv_cstmt.registerOutParameter(32,java.sql.Types.VARCHAR);
											blng_grp_charge_srv_cstmt.registerOutParameter(33,java.sql.Types.VARCHAR);
											blng_grp_charge_srv_cstmt.registerOutParameter(34,java.sql.Types.VARCHAR);
											blng_grp_charge_srv_cstmt.setString(35,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
											blng_grp_charge_srv_cstmt.setString(36,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
											blng_grp_charge_srv_cstmt.setString(37,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
											blng_grp_charge_srv_cstmt.setString(38,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
											blng_grp_charge_srv_cstmt.setString(39,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
											blng_grp_charge_srv_cstmt.execute();

											str_error_level=blng_grp_charge_srv_cstmt.getString(32);
											str_sysmesage_id=blng_grp_charge_srv_cstmt.getString(33);					
											str_error_text=blng_grp_charge_srv_cstmt.getString(34);
											if(str_error_level==null) str_error_level="";
											if(str_sysmesage_id==null) str_sysmesage_id="";
											if(str_error_text==null) str_error_text="";

											//System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
											//System.out.println("str_error_text in process:"+str_error_text);
											//System.out.println("str_error_text in process:"+str_error_text);

											if(str_sysmesage_id.equals("") && str_error_text.equals(""))
												inserted_blng_grp_charge_srv_list.add(blng_grp_code.trim()+"~~"+fromDate.trim()+"~~"+cbService.trim());
											if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
											{
												insertable=false;
												sb.append("<br>"+str_error_text+"<br> ") ;
											}
											if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
											{
												insertable=false;
												if((str_error_level.equals("10") && !str_error_text.equals("") ))
												{
													sb.append("<br>"+str_error_text+"<br> ") ;
													//System.out.println("sb mesage in Error is:"+sb);
												}
												else
												{
													if(str_sysmesage_id.indexOf("|") != (-1)){
														msgIds=new StringTokenizer(str_sysmesage_id,"|");
														while(msgIds.hasMoreTokens())
														{
															messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
															sb.append((String)messageHashtable.get("message")+"<br>");
														}
														//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
													}else{
														messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
														sb.append((String)messageHashtable.get("message"));
														//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
													}
												}
											}
										}
									}

								}
							}
						}
						if(blng_grp_charge_srv_cstmt!=null) blng_grp_charge_srv_cstmt.close();
						//System.out.println("inserted_blng_grp_charge_srv_list="+inserted_blng_grp_charge_srv_list.toString());
					}
				}
				catch (Exception e)
				{
					System.err.println("Exception from Billing Group Charge based Insertions :"+e);
					e.printStackTrace();
					insertable=false;
				}
				/***********Billing Group Charge Based Dtls*********end***********/
				/***********Billing Group Charge Based Excl Dtls*********Start***********/
				try
				{
					//System.out.println("------Billing Group Charge Based Excl insertions---------");
					if(insertable && blng_grp_charge_srv_excl!=null && blng_grp_charge_srv_excl.size()>0 )
					{

						/****************************************/
						keySet=(Set<String>)blng_grp_charge_srv_excl.keySet();
						//System.out.println("keySet www="+keySet.toString());
						blngGrpIt=keySet.iterator();
						record=new String[5];
						while(insertable && blngGrpIt.hasNext()){
							key=(String)blngGrpIt.next();
							blng_grp_charge_srv_excl_list=(ArrayList)blng_grp_charge_srv_excl.get(key);
							if(blng_grp_charge_srv_excl_list!=null && blng_grp_charge_srv_excl_list.size()>0){
								stKey=new StringTokenizer(key,"~~");
								if(stKey.hasMoreTokens()){
									blng_grp_code=stKey.nextToken();
								}else{
									blng_grp_code="";
								}
								if(stKey.hasMoreTokens())
									fromDate=stKey.nextToken();
								else
									fromDate="";
								if(stKey.hasMoreTokens())
									parent_service_code=stKey.nextToken();
								else
									parent_service_code="";
								if(!blng_grp_code.equals("")  &&  !fromDate.equals("") &&  !parent_service_code.equals("") && blng_grp_dtls!=null && blng_grp_dtls.size()>0 && blng_grp_dtls.containsKey(blng_grp_code) && inserted_blng_grp_period_list!=null && inserted_blng_grp_period_list.size()>0 && inserted_blng_grp_period_list.contains(blng_grp_code.trim()+"~~"+fromDate.trim()) && inserted_blng_grp_charge_srv_list!=null && inserted_blng_grp_charge_srv_list.size()>0 && inserted_blng_grp_charge_srv_list.contains(blng_grp_code.trim()+"~~"+fromDate.trim()+"~~"+parent_service_code.trim()) ){
									for(int i=0;i<blng_grp_charge_srv_excl_list.size();i++){
										record=(String[])blng_grp_charge_srv_excl_list.get(i);
										itemCode		= record[0];
										itemDesc		= record[1];
										inExcl	=record[2];
										if(inExcl==null || inExcl.equals("") || inExcl.equals("null"))
											inExcl="N";
										qtyLimit		=record[3];
										amountLimit			= record[4];
										splitReqd = record[5];//Split Reqd
										includeHomeMedication = record[6];
										if(insertable){
											blng_grp_charge_srv_excl_cstmt.setString(1,facility_id);
											blng_grp_charge_srv_excl_cstmt.setString(2,packageCode);
											blng_grp_charge_srv_excl_cstmt.setString(3,blng_grp_code);
											blng_grp_charge_srv_excl_cstmt.setString(4,fromDate);
											blng_grp_charge_srv_excl_cstmt.setString(5,parent_service_code);
											blng_grp_charge_srv_excl_cstmt.setString(6,"S");
											blng_grp_charge_srv_excl_cstmt.setString(7,"C");
											blng_grp_charge_srv_excl_cstmt.setString(8,itemCode);
											blng_grp_charge_srv_excl_cstmt.setString(9,"M");
											blng_grp_charge_srv_excl_cstmt.setString(10,inExcl);
											blng_grp_charge_srv_excl_cstmt.setString(11,"");
											blng_grp_charge_srv_excl_cstmt.setString(12,qtyLimit);
											blng_grp_charge_srv_excl_cstmt.setString(13,amountLimit);
											blng_grp_charge_srv_excl_cstmt.setString(14,"");
											blng_grp_charge_srv_excl_cstmt.setString(15,"");
											blng_grp_charge_srv_excl_cstmt.setString(16,"");
											blng_grp_charge_srv_excl_cstmt.setString(17,"");
											blng_grp_charge_srv_excl_cstmt.setString(18,"");
											blng_grp_charge_srv_excl_cstmt.setString(19,"");
											blng_grp_charge_srv_excl_cstmt.setString(20,"");
											blng_grp_charge_srv_excl_cstmt.setString(21,"");
											blng_grp_charge_srv_excl_cstmt.setString(22,user_id);
											blng_grp_charge_srv_excl_cstmt.setString(23,user_id);
											blng_grp_charge_srv_excl_cstmt.setString(24,client_ip_address);
											blng_grp_charge_srv_excl_cstmt.setString(25,facility_id);
											blng_grp_charge_srv_excl_cstmt.setString(26,client_ip_address);
											blng_grp_charge_srv_excl_cstmt.setString(27,facility_id);
											blng_grp_charge_srv_excl_cstmt.setString(28,splitReqd);//RRRR	
											blng_grp_charge_srv_excl_cstmt.setString(29,includeHomeMedication);//RRRR	
											blng_grp_charge_srv_excl_cstmt.registerOutParameter(30,java.sql.Types.VARCHAR);
											blng_grp_charge_srv_excl_cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
											blng_grp_charge_srv_excl_cstmt.registerOutParameter(32,java.sql.Types.VARCHAR);
											blng_grp_charge_srv_excl_cstmt.setString(33,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
											blng_grp_charge_srv_excl_cstmt.setString(34,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
											blng_grp_charge_srv_excl_cstmt.setString(35,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
											blng_grp_charge_srv_excl_cstmt.setString(36,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
											blng_grp_charge_srv_excl_cstmt.setString(37,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
											blng_grp_charge_srv_excl_cstmt.execute();

											str_error_level=blng_grp_charge_srv_excl_cstmt.getString(30);
											str_sysmesage_id=blng_grp_charge_srv_excl_cstmt.getString(31);					
											str_error_text=blng_grp_charge_srv_excl_cstmt.getString(32);
											if(str_error_level==null) str_error_level="";
											if(str_sysmesage_id==null) str_sysmesage_id="";
											if(str_error_text==null) str_error_text="";

											//System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
											//System.out.println("str_error_text in process:"+str_error_text);
											//System.out.println("str_error_text in process:"+str_error_text);


											if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
											{
												insertable=false;
												sb.append("<br>"+str_error_text+"<br> ") ;
											}
											if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
											{
												insertable=false;
												if((str_error_level.equals("10") && !str_error_text.equals("") ))
												{
													sb.append("<br>"+str_error_text+"<br> ") ;
													//System.out.println("sb mesage in Error is:"+sb);
												}
												else
												{
													if(str_sysmesage_id.indexOf("|") != (-1)){
														msgIds=new StringTokenizer(str_sysmesage_id,"|");
														while(msgIds.hasMoreTokens())
														{
															messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
															sb.append((String)messageHashtable.get("message")+"<br>");
														}
														//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
													}else{
														messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
														sb.append((String)messageHashtable.get("message"));
														//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
													}
												}
											}
										}
									}
								}
							}
						}
						if(blng_grp_charge_srv_excl_cstmt!=null) blng_grp_charge_srv_excl_cstmt.close();
					}
				}
				catch (Exception e)
				{
					System.err.println("Exception from Billing Group Charge based Excl insertion :"+e);
					e.printStackTrace();
					insertable=false;
				}
				/***********Billing Group Charge Based Excl Dtls*********end***********/
		//Emded By Shikha For GHL-CRF-0520.1
			
//		System.out.println("in PkgDefManager in insert 3808");
	/***********Customer Discount Dtls*********start************/
	try
	{
		if(insertable && cust_discount_dtls!=null && cust_discount_dtls.size()>0 )
		{

				/****************************************/
				keySet=(Set<String>)cust_discount_dtls.keySet();
				custIt=keySet.iterator();
				while(insertable && custIt.hasNext()){
					record=new String[14];
					key=(String)custIt.next();
					record=(String[])cust_discount_dtls.get(key);
					cust_grp_code	= record[0];
					cust_grp_desc	= record[1];
					cust_code		= record[2];
					cust_desc		= record[3];
					blng_class_code	= record[4];
					blng_class_desc	= record[5];
					eff_from_date	= record[6];
					eff_to_date		= record[7];
					discount_type	= record[8];
					discount		= record[9];
					//GHL-CRF-0502 Starts
					age_group_code	= record[10];
					if(age_group_code.equals("") || age_group_code.equals(null)){
						age_group_code="**";
					}
					hdn_age_group	= record[11];
					specialty_code	= record[12];
					if(specialty_code.equals("") || specialty_code.equals(null)){
						specialty_code="**";
					}
					specialty_desc	= record[13];
					//GHL-CRF-0502 Ends
					//MMS-QH-CRF- STARTS
					poly_code	= record[14];
					//poly_desc	= record[15];
					//MMS-QH-CRF- ENDS
					
					if(eff_to_date.equals("")){
						cust_discount_cstmt = con.prepareCall(cust_discount_sql1);
						eff_to_date=null;
					}else{
						cust_discount_cstmt = con.prepareCall(cust_discount_sql);
					}
					cust_discount_cstmt.setString(1,facility_id);
					cust_discount_cstmt.setString(2,packageCode);
					cust_discount_cstmt.setString(3,cust_grp_code);
					cust_discount_cstmt.setString(4,cust_code);
					cust_discount_cstmt.setString(5,blng_class_code);
					cust_discount_cstmt.setString(6,eff_from_date);
					cust_discount_cstmt.setString(7,eff_to_date);
					cust_discount_cstmt.setString(8,discount);
					cust_discount_cstmt.setString(9,discount_type);
					cust_discount_cstmt.setString(10,user_id);
					cust_discount_cstmt.setString(11,user_id);
					cust_discount_cstmt.setString(12,client_ip_address);
					cust_discount_cstmt.setString(13,facility_id);
					cust_discount_cstmt.setString(14,client_ip_address);
					cust_discount_cstmt.setString(15,facility_id);
					cust_discount_cstmt.registerOutParameter(16,java.sql.Types.VARCHAR);
					cust_discount_cstmt.registerOutParameter(17,java.sql.Types.VARCHAR);
					cust_discount_cstmt.registerOutParameter(18,java.sql.Types.VARCHAR);
					//GHL-CRF-0502 Starts
					cust_discount_cstmt.setString(19,age_group_code);
					cust_discount_cstmt.setString(20,specialty_code);
					cust_discount_cstmt.setString(21,poly_code);////MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 15/6/2020
					
					//GHL-CRF-0502 Ends
					if(null != discount && !discount.equals("")) {
						cust_discount_cstmt.execute();
					}

					str_error_level=cust_discount_cstmt.getString(16);
					str_sysmesage_id=cust_discount_cstmt.getString(17);
					str_error_text=cust_discount_cstmt.getString(18);
					if(str_error_level==null) str_error_level="";
					if(str_sysmesage_id==null) str_sysmesage_id="";
					if(str_error_text==null) str_error_text="";



					if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
					{
						insertable=false;
						sb.append("<br>"+str_error_text+"<br> ") ;
					}
					if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
					{
						insertable=false;
						if((str_error_level.equals("10") && !str_error_text.equals("") ))
						{
							sb.append("<br>"+str_error_text+"<br> ") ;
						}
						else
						{
							if(str_sysmesage_id.indexOf("|") != (-1)){
								msgIds=new StringTokenizer(str_sysmesage_id,"|");
								while(msgIds.hasMoreTokens())
								{
									messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
									sb.append((String)messageHashtable.get("message")+"<br>");
								}
							}else{
								messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
								sb.append((String)messageHashtable.get("message"));
							}
						}
					}
				}
				if(cust_discount_cstmt!=null)
					cust_discount_cstmt.close();
			}
		}
		catch (Exception e)
		{
			System.err.println("Exception from Customer dtls :"+e);
			e.printStackTrace();
			insertable=false;
		}finally{
			if(cust_discount_cstmt!=null)
					cust_discount_cstmt.close();
		}
		/***********Customer Discount Dtls*********end***********/
		/***********Blng Grp Discount Dtls*********start************/
	try
	{
		if(insertable && blng_grp_discount_dtls!=null && blng_grp_discount_dtls.size()>0 )
		{

				/****************************************/
				keySet=(Set<String>)blng_grp_discount_dtls.keySet();
				custIt=keySet.iterator();
				while(insertable && custIt.hasNext()){
					record=new String[12];
					key=(String)custIt.next();
					record=(String[])blng_grp_discount_dtls.get(key);
					blng_grp_code	= record[0];
					blng_grp_desc	= record[1];
					blng_class_code	= record[2];
					blng_class_desc	= record[3];
					eff_from_date	= record[4];
					eff_to_date		= record[5];
					discount_type	= record[6];
					discount		= record[7];
					//GHL-CRF-0502 Starts
					age_group_code	= record[8];
					if(age_group_code.equals("") || age_group_code.equals(null)){
						age_group_code="**";
					}
					hdn_age_group	= record[9];
					specialty_code	= record[10];
					if(specialty_code.equals("") || specialty_code.equals(null)){
						specialty_code="**";
					}
					specialty_desc	= record[11];
					//GHL-CRF-0502 Ends					
					
					if(eff_to_date.equals("")){
						blng_grp_discount_cstmt = con.prepareCall(blng_grp_discount_sql1);
						eff_to_date=null;
					}else{
						blng_grp_discount_cstmt = con.prepareCall(blng_grp_discount_sql);
					}
					blng_grp_discount_cstmt.setString(1,facility_id);
					blng_grp_discount_cstmt.setString(2,packageCode);
					blng_grp_discount_cstmt.setString(3,blng_grp_code);
					blng_grp_discount_cstmt.setString(4,blng_class_code);
					blng_grp_discount_cstmt.setString(5,eff_from_date);
					blng_grp_discount_cstmt.setString(6,eff_to_date);
					blng_grp_discount_cstmt.setString(7,discount);
					blng_grp_discount_cstmt.setString(8,discount_type);
					blng_grp_discount_cstmt.setString(9,user_id);
					blng_grp_discount_cstmt.setString(10,user_id);
					blng_grp_discount_cstmt.setString(11,client_ip_address);
					blng_grp_discount_cstmt.setString(12,facility_id);
					blng_grp_discount_cstmt.setString(13,client_ip_address);
					blng_grp_discount_cstmt.setString(14,facility_id);
					blng_grp_discount_cstmt.registerOutParameter(15,java.sql.Types.VARCHAR);
					blng_grp_discount_cstmt.registerOutParameter(16,java.sql.Types.VARCHAR);
					blng_grp_discount_cstmt.registerOutParameter(17,java.sql.Types.VARCHAR);
					//GHL-CRF-0502 Starts
					blng_grp_discount_cstmt.setString(18,age_group_code);
					blng_grp_discount_cstmt.setString(19,specialty_code);
					//GHL-CRF-0502 Ends
					if(null != discount && !discount.equals("")) {
						blng_grp_discount_cstmt.execute();
					}

					str_error_level=blng_grp_discount_cstmt.getString(15);
					str_sysmesage_id=blng_grp_discount_cstmt.getString(16);
					str_error_text=blng_grp_discount_cstmt.getString(17);
					if(str_error_level==null) str_error_level="";
					if(str_sysmesage_id==null) str_sysmesage_id="";
					if(str_error_text==null) str_error_text="";

					if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
					{
						insertable=false;
						sb.append("<br>"+str_error_text+"<br> ") ;
					}
					if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
					{
						insertable=false;
						if((str_error_level.equals("10") && !str_error_text.equals("") ))
						{
							sb.append("<br>"+str_error_text+"<br> ") ;
						}
						else
						{
							if(str_sysmesage_id.indexOf("|") != (-1)){
								msgIds=new StringTokenizer(str_sysmesage_id,"|");
								while(msgIds.hasMoreTokens())
								{
									messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
									sb.append((String)messageHashtable.get("message")+"<br>");
								}
							}else{
								messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
								sb.append((String)messageHashtable.get("message"));
							}
						}
					}
				}
				if(blng_grp_discount_cstmt!=null)
					blng_grp_discount_cstmt.close();
			}
		}
		catch (Exception e)
		{
			System.err.println("Exception from Customer dtls :"+e);
			e.printStackTrace();
			insertable=false;
		}finally{
			if(blng_grp_discount_cstmt!=null)
					blng_grp_discount_cstmt.close();
		}
		/***********Blng grp Discount Dtls*********end***********/
	/***********Karthik added this code for adding Partial deposit Records MMS-CRF-0023 - Starts***********/
    if (insertable) {
        try
        {
          //System.out.println("EJB Karthik added this code for adding Partial deposit Records MMS-CRF-0023 - Starts");

          HashMap returnMessage = new HashMap();
          boolean deletePartialDepositRecord = false;
          boolean insertPartialDepositRecord = false;
          HashMap inputParameters = new HashMap();

          HashMap insertMap = new HashMap();
          insertMap = (HashMap)tabdata.get("partial_deposit_list");
          Set kSet = insertMap.keySet();
          Iterator it = kSet.iterator();

          while (it.hasNext())
          {
            String partialDepkey = (String)it.next();
            ArrayList partialDepositList = (ArrayList)insertMap.get(partialDepkey);

            inputParameters.put("poperatingfacilityid", facility_id);
            inputParameters.put("ppackagecode", packageCode);
            inputParameters.put("pefffromdate", effFromDate);
            inputParameters.put("pblngclasscode", partialDepkey);
            inputParameters.put("planguageid", locale);
            inputParameters.put("paddedbyid", this.user_id);
            inputParameters.put("paddedfacilityid", facility_id);
            inputParameters.put("paddedatwsno", this.client_ip_address);

            returnMessage = deleteAllPartialDepositDetails(this.con, inputParameters);
            boolean allRecsDeleted = Boolean.parseBoolean((String)returnMessage.get("status"));
            if (!allRecsDeleted) {
              insertable = false;
              this.str_error_text = ((String)returnMessage.get("error"));
              this.sys_err = this.sys_err.append((String)returnMessage.get("sys_error"));
              this.str_sysmesage_id = ((String)returnMessage.get("message"));
              break;
            }

            for (int i = 0; i < partialDepositList.size(); i++)
            {
              StringTokenizer st = new StringTokenizer((String)partialDepositList.get(i), "~");
              while (st.hasMoreTokens()) {
                inputParameters.put("pencounterseqno", st.nextToken());
                inputParameters.put("pminpartialdeposittype", st.nextToken());
                inputParameters.put("pminpartialdeposit", st.nextToken());
                inputParameters.put("pdepositmandatoryyn", st.nextToken());
              }

              returnMessage = insertPartialDepositDetails(this.con, inputParameters);
              insertPartialDepositRecord = Boolean.parseBoolean((String)returnMessage.get("status"));
              if (!insertPartialDepositRecord) {
                insertable = false;
                this.str_error_text = ((String)returnMessage.get("error"));
                this.sys_err = this.sys_err.append((String)returnMessage.get("sys_error"));
                this.str_sysmesage_id = ((String)returnMessage.get("message"));
                break;
              }
            }
          }
        }
        catch (Exception e)
        {
          System.err.println("Exception in adding Partial deposit Records :" + e);
          e.printStackTrace();
          insertable = false;
        }

      }
    /***********Karthik added this code for adding Partial deposit Records MMS-CRF-0023 - Ends***********/
  //Copied from Modify Block - Rajesh V -MMS-DM-CRF-0091

	try {
		Boolean siteSpec = false;
		try {

		
			siteSpec = eCommon.Common.CommonBean.isSiteSpecific(con,
					"BL", "INCL/EXCL_HOME_MEDICATION");
			/* System.out.println("Pkg Def Manager SiteSpec"
					+ siteSpec); */
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception in site specific " + e);
		}

		if (siteSpec) {
			if (insertable) {

				String sqlInclHomeMedValidate = "{ call  blpackage.bl_proc_reset_home_medication(?,?,?)}";

				if (!("Y".equalsIgnoreCase(IpYn) || "Y"
						.equalsIgnoreCase(DcYn))) {
					//System.out.println("in if");
					try {
						cstmt = con.prepareCall(sqlInclHomeMedValidate);
						cstmt.setString(1, facility_id);
						cstmt.setString(2, packageCode);
						cstmt.registerOutParameter(3,
								java.sql.Types.VARCHAR);
						cstmt.execute();
						str_sysmesage_id = cstmt.getString(3);

						if (str_sysmesage_id == null)
							str_sysmesage_id = "";

						if (!str_sysmesage_id.equals("")) {
							insertable = false;
						} else {
							insertable = true;
						}

					} catch (Exception e) {
						e.printStackTrace();
						System.err.println("Exception in sqlInclHomeMedValidate"
										+ e);
					}
				}

			}

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	//Copied from Modify Block - Rajesh V -MMS-DM-CRF-0091
	
	if(insertable)
		{
			con.commit();
		}
		else
		{
			con.rollback();
		}
	}
	catch (Exception e)
	{
		insertable=false;
		sys_err.append("Main Exception:"+e);
		System.err.println("Main Exception:"+e);
		e.printStackTrace();
	}
	finally
	{
		try{
		if(cust_period_cstmt!=null) cust_period_cstmt.close();
		if(cust_discount_cstmt!=null) cust_discount_cstmt.close();
		if(blng_grp_discount_cstmt!=null) blng_grp_discount_cstmt.close();
		if(cust_period_cstmt!=null) cust_period_cstmt.close();
		if(blng_grp_period_cstmt!=null) blng_grp_period_cstmt.close();//Added By Shikha For GHL-CRF-0520.1

		if (con != null)
			ConnectionManager.returnConnection(con, p);
		}catch(Exception r)	{
			r.printStackTrace();
		}
	}
	return_mess.put("status",new Boolean(insertable));
	return_mess.put("error",str_error_text);
	return_mess.put("sys_error",sys_err.toString());
	return_mess.put("message",str_sysmesage_id);
	return return_mess;
}//insert()

/**
	 *Method to insert single record
	 *@param properties Connection Properties
	 *@param hashaMap Record data
	 *@param as data for duplication check
	 *@param s Table Name
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	@SuppressWarnings({"rawtypes","unused", "unchecked"})
	public java.util.HashMap modify(java.util.Properties p,java.util.HashMap tabdata) //throws Exception
	{
		System.out.println("modify in PkgDefManager.java");
		con = ConnectionManager.getConnection(p);
		PreparedStatement pstmt 	= null;
		PreparedStatement pstmt1 	= null;
		HashMap return_mess = new HashMap();
		HashMap return_mess_cust		= new HashMap();
		HashMap return_mess_blng_grp		= new HashMap(); //Added By Shikha For GHL-CRF-0520.1
		HashMap return_mess_discount		= new HashMap();
		boolean insertable = false;
		String locale = "";
		locale=(String)tabdata.get("locale");
		if(locale==null) locale="en";

	    //java.util.Locale loc = new java.util.Locale(locale);
		//java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
		//String hosp_chrg_leg = bl_labels.getString("eBL.PLS_NOTE_TRX_REF_NO.label");


		String facility_id = (String) tabdata.get("FACILITY_ID");
		if(facility_id==null) facility_id="";

		String packageCode=(String)tabdata.get("packageCode");
		if(packageCode==null) packageCode="";

		String longDesc=(String)tabdata.get("longDesc");
		if(longDesc==null) longDesc="";

		String shortDesc=(String)tabdata.get("shortDesc");
		if(shortDesc==null) shortDesc="";


		String applSexInd=(String)tabdata.get("applSexInd");
		if(applSexInd==null) applSexInd="";

		String effFromDate=(String)tabdata.get("effFromDate");
		if(effFromDate==null)
			effFromDate="";
		else
 		  effFromDate = com.ehis.util.DateUtils.convertDate(effFromDate,"DMY",locale,"en");
		String effToDate=(String)tabdata.get("effToDate");
		if(effToDate==null)
			effToDate="";
		else
		  effToDate = com.ehis.util.DateUtils.convertDate(effToDate,"DMY",locale,"en");

		String minAgeInYrs=(String)tabdata.get("minAgeInYrs");
		if(minAgeInYrs==null) minAgeInYrs="";

		String minAgeInMths=(String)tabdata.get("minAgeInMths");
		if(minAgeInMths==null) minAgeInMths="";

		String minAgeInDays=(String)tabdata.get("minAgeInDays");
		if(minAgeInDays==null) minAgeInDays="";

		String maxAgeInYrs=(String)tabdata.get("maxAgeInYrs");
		if(maxAgeInYrs==null) maxAgeInYrs="";

		String maxAgeInMths=(String)tabdata.get("maxAgeInMths");
		if(maxAgeInMths==null) maxAgeInMths="";

		String maxAgeInDays=(String)tabdata.get("maxAgeInDays");
		if(maxAgeInDays==null) maxAgeInDays="";

		String AllYn=(String)tabdata.get("AllYn");
		if(AllYn==null) AllYn="";

		String IpYn=(String)tabdata.get("IpYn");
		if(IpYn==null) IpYn="";

		String DcYn=(String)tabdata.get("DcYn");
		if(DcYn==null) DcYn="";

		String OpYn=(String)tabdata.get("OpYn");
		if(OpYn==null) OpYn="";

		String EmYn=(String)tabdata.get("EmYn");
		if(EmYn==null) EmYn="";

		String orderAssociated=(String)tabdata.get("orderAssociated");
		if(orderAssociated==null) orderAssociated="N";

		String acrossEncounters=(String)tabdata.get("acrossEncounters");
		if(acrossEncounters==null) acrossEncounters="";

		String applicalbleTo=(String)tabdata.get("applicalbleTo");
		if(applicalbleTo==null) applicalbleTo="";

		String validDays=(String)tabdata.get("validDays");
		if(validDays==null) validDays="";
		//String ExYn=(String)tabdata.get("ExYn");
		//if(ExYn==null) ExYn="";

		String approvedYN=(String)tabdata.get("approvedYN");
		if(approvedYN==null) approvedYN="N";
		String approvedBy=(String)tabdata.get("approvedBy");
		if(approvedBy==null) approvedBy="";
		String approvedDate=(String)tabdata.get("approvedDate"); //Sarath SKR-SCF-0744 added if else to save as english date in db
		if(approvedDate==null)
			approvedDate="";
		else
			approvedDate = com.ehis.util.DateUtils.convertDate(approvedDate,"DMY",locale,"en");

		String newDate=(String)tabdata.get("newDate");
		//System.out.println("in ejb newDate "+newDate);

		client_ip_address=(String)tabdata.get("client_ip_address");
		if(client_ip_address==null) client_ip_address="";

		user_id=(String)tabdata.get("login_user");
		if(user_id==null) user_id="";

		/*String statusHdr=(String)tabdata.get("statusHdr");
		if(statusHdr==null) statusHdr="";
		String daysValid=(String)tabdata.get("daysValid");
		if(daysValid==null) daysValid="";*/
		int totRec = 0;
		String amt_limit_ind = "";
		String roundTo = "";
		String roundInd= "";
		String auto_refund= "";
		String closePakgStat= "";
		/*String deposit		   ="";
		String partialDeposit 	   ="";
		String minDepAmtind   	   ="";
		String minDepAmt	 	   ="";		unused */
		HashMap baseDates = (HashMap)tabdata.get("baseDates");
		HashMap basePrice = (HashMap)tabdata.get("basePrice");
		HashMap childPackages = (HashMap)tabdata.get("childPackages");//503
		//HashMap childPackdtl = (HashMap)tabdata.get("childPackdtl");//503
		HashMap includedItems_CB	= (HashMap)tabdata.get("includedItems_CB");
//		HashMap includSrvicesDB_CB  = (HashMap)tabdata.get("includSrvicesDB_CB"); unused
		HashMap excludedItems_CB	= (HashMap)tabdata.get("excludedItems_CB");
		//HashMap excludSrvicesDB_CB  = (HashMap)tabdata.get("excludSrvicesDB_CB");
		HashMap includedItems_RB	= (HashMap)tabdata.get("includedItems_RB");
		HashMap excludedItems_RB	= (HashMap)tabdata.get("excludedItems_RB");
		//HashMap includedItems_cust= (HashMap)tabdata.get("includedItems_cust");
		HashMap dbIncludedItems_CB= (HashMap)tabdata.get("dbIncludedItems_CB");
		HashMap dbExcludedItems_CB= (HashMap)tabdata.get("dbExcludedItems_CB");
		HashMap dbIncludedItems_RB= (HashMap)tabdata.get("dbIncludedItems_RB");
		HashMap dbExcludedItems_RB= (HashMap)tabdata.get("dbExcludedItems_RB");
	//	HashMap dbIncludedItems_cust= (HashMap)tabdata.get("dbIncludedItems_cust");
		HashMap includedItemsFD_CB = new HashMap();
		HashMap excludedItemsFD_CB = new HashMap();
		HashMap excludedItemsFD_RB = new HashMap();
		HashMap includedItemsFD_RB = new HashMap();
		//HashMap excludedItemsSR_RB = new HashMap();
		HashMap dbIncludedItemsFD_RB= new HashMap();
		HashMap dbIncludedItemsFD_CB= new HashMap();
		HashMap	dbExcludedItemsFD_RB= new HashMap();
		//HashMap	dbExcludedItemsSR_RB= new HashMap();
		HashMap	dbExcludedItemsFD_CB = new HashMap();
		//HashMap	dbExcludedItemsSR_CB = new HashMap();
		//HashMap	excludedItemsSR_CB = new HashMap();
		String modifyRateBased=(String)tabdata.get("modifyRateBased");
		String modifyRateSrvLimits=(String)tabdata.get("modifyRateSrvLimits");
	//	String modifyChargeBased=(String)tabdata.get("modifyChargeBased");
	//	String modifyChargeItems=(String)tabdata.get("modifyChargeItems");
	//	String modifyCustomer=(String)tabdata.get("modifyCustomer");
	/*	System.out.println("baseDates:"+baseDates);
		System.out.println("basePrice:"+basePrice);
		System.out.println("includedItems_CB:"+includedItems_CB);
		System.out.println("excludedItems_CB:"+excludedItems_CB);
		System.out.println(" in ejb,includedItems_RB:"+includedItems_RB);
		System.out.println("in ejb,excludedItems_RB:"+excludedItems_RB);
		System.out.println("in ejb,includedItems_cust:"+includedItems_cust);
		System.out.println("in ejb,dbIncludedItems_CB:"+dbIncludedItems_CB);
		System.out.println("in ejb,dbExcludedItems_CB:"+dbExcludedItems_CB);
		System.out.println("in ejb,dbIncludedItems_RB:"+dbIncludedItems_RB);
		System.out.println("in ejb,dbExcludedItems_RB:"+dbExcludedItems_RB);
		System.out.println("in ejb,dbIncludedItems_cust:"+dbIncludedItems_cust);
		System.out.println("in ejb,modifyRateBased:"+modifyRateBased);
		System.out.println("in ejb,modifyRateSrvLimits:"+modifyRateSrvLimits);
		System.out.println("in ejb,modifyChargeBased:"+modifyChargeBased);
		System.out.println("in ejb,modifyCustomer:"+modifyCustomer);*/

	/*	HashMap cust_dtls = (HashMap)tabdata.get("cust_dtls");
		HashMap cust_period = (HashMap)tabdata.get("cust_period");
		HashMap cust_base_price = (HashMap)tabdata.get("cust_base_price");
		HashMap cust_rate_srv = (HashMap)tabdata.get("cust_rate_srv");
		HashMap cust_rate_srv_excl = (HashMap)tabdata.get("cust_rate_srv_excl");
		HashMap cust_charge_srv = (HashMap)tabdata.get("cust_charge_srv");
		HashMap cust_charge_srv_excl = (HashMap)tabdata.get("cust_charge_srv_excl");

		HashMap db_cust_dtls = (HashMap)tabdata.get("db_cust_dtls");
		HashMap db_cust_period = (HashMap)tabdata.get("db_cust_period");
		HashMap db_cust_base_price = (HashMap)tabdata.get("db_cust_base_price");
		HashMap db_cust_rate_srv = (HashMap)tabdata.get("db_cust_rate_srv");
		HashMap db_cust_rate_srv_excl = (HashMap)tabdata.get("db_cust_rate_srv_excl");
		HashMap db_cust_charge_srv = (HashMap)tabdata.get("db_cust_charge_srv");
		HashMap db_cust_charge_srv_excl = (HashMap)tabdata.get("db_cust_charge_srv_excl");

		String modify_cust=(String)tabdata.get("modify_cust");
		String modify_cust_period=(String)tabdata.get("modify_cust_period");
		String modify_cust_base_price=(String)tabdata.get("modify_cust_base_price");
		String modify_cust_rate_srv=(String)tabdata.get("modify_cust_rate_srv");
		String modify_cust_rate_srv_excl=(String)tabdata.get("modify_cust_rate_srv_excl");
		String modify_cust_charge_srv=(String)tabdata.get("modify_cust_charge_srv");
		String modify_cust_charge_srv_excl=(String)tabdata.get("modify_cust_charge_srv_excl");
		*/


		ArrayList	services		=	new ArrayList();
		ArrayList serviceGroup	    =	new ArrayList();
		ArrayList amtLmtIndGroup	=	new ArrayList();
		ArrayList amtLmtGroup		=	new ArrayList();
		ArrayList roundToGroup	        =	new ArrayList();
		ArrayList roundIndGroup		    =	new ArrayList();
		ArrayList priceFromDate  =	new ArrayList();
		ArrayList itemsForService = new ArrayList();
		ArrayList itemGroup	        =	new ArrayList();
		ArrayList itemDescGroup     =	new ArrayList();
		ArrayList inExcnGroup		=	new ArrayList();
		ArrayList amountLtGroup		=	new ArrayList();
		ArrayList srvLmtFactorApplGroup		=	new ArrayList();
		ArrayList qtyLtGroup		=	new ArrayList();


		ArrayList	typeGroup	    =	new ArrayList();
		ArrayList	srvLtTypeGroup	=	new ArrayList();
		ArrayList	exludeSrvGroup	    =	new ArrayList();
		ArrayList	catalogGroup		    =	new ArrayList();
		ArrayList	indGroup		    =	new ArrayList();
		ArrayList	factorOrRateGroup    =	new ArrayList();
		ArrayList	replaceGroup    =	new ArrayList();
		ArrayList	replaceSrvGroup   =	new ArrayList();
		ArrayList	replaceSrv_catGroup    =	new ArrayList();
		ArrayList	refundGroup    =	new ArrayList();
		ArrayList	refundAmtGroup    =	new ArrayList();
		ArrayList	factor_applGroup    =	new ArrayList();
		ArrayList	amt_limit_ind_list  =	new ArrayList();
		ArrayList	srvLtSrvGroup	    =	new ArrayList();
		ArrayList	auto_refund_list	 =	new ArrayList();
		ArrayList	roundTo_list	     =	new ArrayList();
		ArrayList	roundInd_list		 =	new ArrayList();

		ArrayList	closePkg_list		 =	new ArrayList();
		ArrayList	split_reqd_list		=	new ArrayList();//Split reqd
		ArrayList	includeHomeMedication_list		=	new ArrayList();
		ArrayList dailyLmtChkBxList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
		ArrayList dailyLmtAmtList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
		ArrayList dailyLmtGrossNetList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
		ArrayList dailyLmtIndicatorList = new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		ArrayList dailyLmtQtyList = new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		ArrayList serv_grp_limit_ind_list = new ArrayList(); //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
		String statusHdr="";
	/*	String daysValid="";
		String blgClsCode = "";
		String fromDate="";
		String toDate="";
		String indicator="";
		String price1="";
		String factorAppl=""; unused */

		String cbServiceCode =	"";
		String cbAmtLmtInd	 =	"";
		String cbAmtLmt		 =	"";
		String srvLmtFactorAppl		 =	"";
		//String cbUnlimited	 =	""; unused
		String factorRate	 =	"";
		String qtyLimit		 =	"";
		String refundAmt	 =	"";
		String factor_appl	 =	"";
		String itemCode      =  "";
		String itemDesc      =  "";
		String inExcl        =  "";
		String servIndLmt    =  "";
		String srvLtSrvCode	 =  "";
		String exludeSrv	 =  "";
		String servInd	     =  "";
		String rateChargInd  =  "";
		String splitReqd	= "";//Split Reqd - Rajesh V
		String includeHomeMedication	= "";
		String ordCatlogCode =  "";
		String factorRateInd =  "";
		String replaceableYN =  "";
		String replServCode  =  "";
		String replOrder     =  "";
		String refundYN		 =  "";
		String sqlDelete="";
		String sqlcb ="";

		String 		dbServiceCode="";
		String 		recModified="";
		//Added V190325 Gayathri/KDAH-CRF-0503
		String isMasterPkgYn=(String)tabdata.get("isMasterPkgYn");
		if(isMasterPkgYn==null) isMasterPkgYn="N";
		
		String dailyLmtChkBx = "";//Added V190320-Aravindh/MMS-DM-CRF-0129
		String dailyLmtAmt = "";//Added V190320-Aravindh/MMS-DM-CRF-0129
		String dailyLmtGrossNet = "";//Added V190320-Aravindh/MMS-DM-CRF-0129
		String dailyLmtIndicator = "";//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		String dailyLmtQty = "";//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		String serv_grp_limit_ind = "";//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
		String amtLmtInd = "";
		ArrayList dbServices=new ArrayList();

		ArrayList dbServiceGroup=new ArrayList();

		ArrayList rb_excl_serviceGroup=new ArrayList();
		ArrayList db_rb_excl_serviceGroup=new ArrayList();
		ArrayList rb_excl_services=new ArrayList();

		ArrayList db_rb_excl_services=new ArrayList();
		ArrayList	dbSrvLtSrvGroup	    =	new ArrayList();
		String db_rb_excl_serviceCode="";
			int count_del=0;
			int count_del_excl=0;

	try{

			con.setAutoCommit( false ) ;
			insertable = true;
			try
			{
				if(insertable)
				{
					//String sqlblpackage="{ call   blpackage.UpdatePackage('"+facility_id+"','"+packageCode+"','"+shortDesc+"','"+longDesc+"',to_date('"+effFromDate+"','dd/mm/yyyy'),"+to_date_temp+",'"+applSexInd+"','"+minAgeInYrs+"','"+minAgeInMths+"','"+minAgeInDays+"','"+maxAgeInYrs+"','"+minAgeInMths+"','"+maxAgeInDays+"','"+OpYn+"','"+EmYn+"','"+IpYn+"','"+DcYn+"','"+orderAssociated+"','"+validDays+"','"+acrossEncounters+"','"+applicalbleTo+"','"+statusHdr+"','"+user_id+"',sysdate,'"+user_id+"',sysdate,'"+client_ip_address+"','"+facility_id+"','"+client_ip_address+"','"+facility_id+"',?,?,?)}";
					String sqlblpackage="{ call   blpackage.UpdatePackage(?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,sysdate,?,?,?,?,?,?)}";
					if(cstmt!=null)	 cstmt.close();
					cstmt = con.prepareCall(sqlblpackage);
					cstmt.setString(1,facility_id);
					cstmt.setString(2,packageCode);
					cstmt.setString(3,shortDesc);
					cstmt.setString(4,longDesc);
					cstmt.setString(5,effFromDate);
					cstmt.setString(6,effToDate);
					cstmt.setString(7,applSexInd);
					cstmt.setString(8,minAgeInYrs);
					cstmt.setString(9,minAgeInMths);
					cstmt.setString(10,minAgeInDays);
					cstmt.setString(11,maxAgeInYrs);
					cstmt.setString(12,maxAgeInMths);
					cstmt.setString(13,maxAgeInDays);
					cstmt.setString(14,OpYn);
					cstmt.setString(15,EmYn);
					cstmt.setString(16,IpYn);
					cstmt.setString(17,DcYn);
					/*Newly added by muthu against 31103
					if(orderAssociated == null || orderAssociated !="Y")
					orderAssociated ="N";
					//Newly added by muthu against 31103*/
					cstmt.setString(18,orderAssociated);
					cstmt.setString(19,validDays);
					cstmt.setString(20,acrossEncounters);
					cstmt.setString(21,applicalbleTo);
					cstmt.setString(22,approvedYN);
					cstmt.setString(23,approvedBy);
					cstmt.setString(24,approvedDate);
					cstmt.setString(25,statusHdr);
					cstmt.setString(26,user_id);
					cstmt.setString(27,client_ip_address);
					cstmt.setString(28,facility_id);
					cstmt.registerOutParameter(29,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(30,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
					cstmt.setString(32,isMasterPkgYn);
					cstmt.execute();

					str_error_level=cstmt.getString(29);
					str_sysmesage_id=cstmt.getString(30);
					str_error_text=cstmt.getString(31);

					if(str_error_level==null) str_error_level="";
					if(str_sysmesage_id==null) str_sysmesage_id="";
					if(str_error_text==null) str_error_text="";

					/*System.out.println("str_error_level in process:"+str_error_level);
					System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
					System.out.println("str_error_text in process:"+str_error_text);*/

					cstmt.close();

					if( !(str_sysmesage_id.equals(""))  ||  !(str_error_text.equals(""))  )
					{
						insertable=false;
					}
					else
					{
						insertable = true;
					}
				}//if insertable
			}catch(Exception e)
			 {
				insertable=false;
				sys_err.append(" Exception while calling blpackage.UpdatePackage:"+e);
				System.err.println("Exception in blpackage.UpdatePackage Call:"+e);
				e.printStackTrace();
			 }

		/*Package base period(date) updation - start*/
		try
		{
			
			if(insertable)
			{
				/*System.out.println("----Package base period(date) updation----"				); */
				System.out.println("baseDates :"+baseDates);
				if(baseDates.containsKey(packageCode))
				{
					ArrayList dtlsArray	     =	(ArrayList)baseDates.get(packageCode);
					if(dtlsArray.size()>0)
					{
						priceFromDate  =	(ArrayList)dtlsArray.get(0);
						ArrayList priceToDate	 = (ArrayList)dtlsArray.get(1);
						ArrayList pkgPClsCode	 = (ArrayList)dtlsArray.get(2);
						ArrayList oPkgPClsCode	 = (ArrayList)dtlsArray.get(4);
						ArrayList flag		= (ArrayList)dtlsArray.get(6);
						ArrayList glSmryList	 = (ArrayList)dtlsArray.get(7);
						ArrayList glSmryDiscList = (ArrayList)dtlsArray.get(9);
						//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts
						ArrayList VATappList = (ArrayList)dtlsArray.get(11);
						ArrayList VATpercentList = (ArrayList)dtlsArray.get(12);
						//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends

						String 	priceFromDte     = "";
						String 	priceToDte       = "";
						String sqlblpackage="";
						String flagVal = "";
						for(int i=0;i<priceFromDate.size(); i++)
						{
 							priceFromDte = com.ehis.util.DateUtils.convertDate((String)(priceFromDate.get(i)),"DMY",locale,"en");
 							priceToDte	 = com.ehis.util.DateUtils.convertDate((String)(priceToDate.get(i)),"DMY",locale,"en");
							flagVal = (String)(flag.get(i))	;

							//System.out.println("flagVal :"+flagVal);
							if(flagVal.equals("insert"))
							{
							//System.out.println("Entering into Insert insertpackageperiod");
							sqlblpackage="{ call   blpackage.insertpackageperiod(?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?)}";
							//System.out.println("sqlblpackage - 3108 - insertpackageperiod ==>  "+sqlblpackage);

							cstmt = con.prepareCall(sqlblpackage );
							cstmt.setString(1,facility_id);
							cstmt.setString(2,packageCode);
							cstmt.setString(3,priceFromDte);
							cstmt.setString(4,priceToDte);
							cstmt.setString(5,(String)(pkgPClsCode.get(i)));
							cstmt.setString(6,(String)(oPkgPClsCode.get(i)));
							cstmt.setString(7,(String)(glSmryList.get(i)));
							cstmt.setString(8,(String)(glSmryDiscList.get(i)));
							cstmt.setString(9,user_id);
							cstmt.setString(10,user_id);
							cstmt.setString(11,client_ip_address);
							cstmt.setString(12,facility_id);
							cstmt.setString(13,client_ip_address);
							cstmt.setString(14,facility_id);

							cstmt.registerOutParameter(15,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(16,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(17,java.sql.Types.VARCHAR);
							//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts
							cstmt.setString(18,(String)(VATappList.get(i)));
							cstmt.setString(19,(String)(VATpercentList.get(i)));
							//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends
							cstmt.execute();
							str_error_level=cstmt.getString(15);
							str_sysmesage_id=cstmt.getString(16);
							str_error_text=cstmt.getString(17);
							/*System.out.println("str_error_level:"+str_error_level);
							System.out.println("str_sysmesage_id:"+str_sysmesage_id);
							System.out.println("str_error_text:"+str_error_text);*/

							}
							else if(flagVal.equals("modify"))
							{
							//System.out.println("Entering into Modify ispkgPeriodrecordchanged");
							sqlcb  ="{ call   blpackage.ispkgPeriodrecordchanged(?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?)}";
							//System.out.println("sqlcb - 3142 - ispkgPeriodrecordchanged ==> "+sqlcb);

							cstmt = con.prepareCall(sqlcb);
							cstmt.setString(1,facility_id);

							cstmt.setString(2,packageCode);

							cstmt.setString(3,priceFromDte);

							cstmt.setString(4,priceToDte);
							cstmt.setString(5,(String)(pkgPClsCode.get(i)));
							cstmt.setString(6,(String)(oPkgPClsCode.get(i)) );
							cstmt.setString(7,(String)(glSmryList.get(i)) );
							cstmt.setString(8,(String)(glSmryDiscList.get(i)) );
							cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
							//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts
							cstmt.setString(13,(String)(VATappList.get(i)));
							cstmt.setString(14,(String)(VATpercentList.get(i)));
							//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends
							cstmt.execute();
							//System.out.println("after execute");
							recModified=cstmt.getString(9);
							str_error_level=cstmt.getString(10);
							str_sysmesage_id=cstmt.getString(11);
							str_error_text=cstmt.getString(12);

							if(str_error_level==null) str_error_level="";
							if(str_sysmesage_id==null) str_sysmesage_id="";
							if(str_error_text==null) str_error_text="";
							/*System.out.println("recModified:"+recModified);
							System.out.println("str_error_level in process ispkgPeriodrecordchanged:"+str_error_level);
							System.out.println("str_sysmesage_id in process ispkgPeriodrecordchanged:"+str_sysmesage_id);
							System.out.println("str_error_text in ispkgPeriodrecordchanged:"+str_error_text);*/
							cstmt.close();
							if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
							{
								//System.out.println("3234");
								insertable=false;
								break;
							}
							else
							{
								//System.out.println("3240");
								insertable = true;
							}
							}
							//Condition Changed by Rajesh V against IN43859
							if(insertable && recModified!=null && "Y".equals(recModified))
							{
						//System.out.println("3246");
							sqlblpackage="{ call   blpackage.updatepackageperiod(?,?,to_date(?,'dd/MM/yyyy'),to_date(?,'dd/MM/yyyy'),?,?,?,?,?,sysdate,?,?,?,?,?,?,?)}";
							cstmt = con.prepareCall(sqlblpackage);

							cstmt.setString(1,facility_id);
							cstmt.setString(2,packageCode);
							cstmt.setString(3,priceFromDte);
							cstmt.setString(4,priceToDte);
							cstmt.setString(5,(String)(pkgPClsCode.get(i)));
							cstmt.setString(6,(String)(oPkgPClsCode.get(i)));
							cstmt.setString(7,(String)(glSmryList.get(i)));
							cstmt.setString(8,(String)(glSmryDiscList.get(i)));
							cstmt.setString(9,user_id);
							cstmt.setString(10,client_ip_address);
							cstmt.setString(11,facility_id);
							cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(14,java.sql.Types.VARCHAR);
							//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts
							cstmt.setString(15,(String)(VATappList.get(i)));
							cstmt.setString(16,(String)(VATpercentList.get(i)));
							//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends
							//System.out.println("3271");
							cstmt.execute();
							//System.out.println("3273");
							str_error_level=cstmt.getString(12);
							str_sysmesage_id=cstmt.getString(13);
							str_error_text=cstmt.getString(14);
							}
							if(str_error_level==null) str_error_level="";
							if(str_sysmesage_id==null) str_sysmesage_id="";
							if(str_error_text==null) str_error_text="";
							/*System.out.println("str_error_level in process:"+str_error_level);
							System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
							System.out.println("str_error_text in process:"+str_error_text);*/
							cstmt.close();
							if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
							{
								//System.out.println("3287");
								insertable=false;
								break;
							}
							else
							{
								//System.out.println("3293");
								insertable = true;
							}
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			insertable=false;
			System.err.println("Exception from updatepackageperiod :"+e);
			e.printStackTrace();
		}
		finally
		{
		}
	   	/*Package base period(date) modify - end*/
		try
		{
			if(insertable)
			{
				if(childPackages.containsKey(packageCode))
				{
					
					
							
					HashMap childPackdtl	     =	(HashMap)childPackages.get(packageCode);
					ArrayList child_pkgcode	 =new ArrayList();
					ArrayList child_pkgdesc	 = new ArrayList();
					ArrayList child_effFromDate	 =new ArrayList(); 
					ArrayList child_effToDate	 =new ArrayList(); 
					ArrayList flag					= new ArrayList();
					
					String flagVal = "";
					String fromDateBP="";
					for(int i=0;i<priceFromDate.size();i++)
					{
						fromDateBP = (String)priceFromDate.get(i);
					//	flagVal = (String)(flag.get(i))	;
						
						if(childPackdtl.containsKey(fromDateBP))
						{
						ArrayList dtlsArray =(ArrayList)childPackdtl.get(fromDateBP);	
						if(dtlsArray.size()>0)
						{
							
					child_pkgcode=(ArrayList)dtlsArray.get(0);
					child_pkgdesc=(ArrayList)dtlsArray.get(1);
					child_effFromDate=(ArrayList)dtlsArray.get(2);
					child_effToDate=(ArrayList)dtlsArray.get(3);
					flag=(ArrayList)dtlsArray.get(4);
					String 	child_effFrmDate     = "";
					String 	childEffToDate       = "";
						
					for(int j=0;j<child_effFromDate.size(); j++)
					{
						flagVal =  (String)flag.get(j) ;
						System.out.println("flagVal :"+flagVal);
					if(flagVal.equals("insert"))
						{
							
						String sqlblpackage="{ call   blpackage.insertchildpackage (?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,sysdate,?,?,?,sysdate,?,?,?,?,?)}";
						//System.out.println("sqlblpackage dfs - 503 - insertchildpackage==>  "+sqlblpackage);
						
							
							child_effFrmDate = com.ehis.util.DateUtils.convertDate((String)(child_effFromDate.get(j)),"DMY",locale,"en");
							childEffToDate = com.ehis.util.DateUtils.convertDate((String)(child_effToDate.get(j)),"DMY",locale,"en");
							cstmt = con.prepareCall(sqlblpackage);
							cstmt.setString(1,facility_id);
							cstmt.setString(2,packageCode);
							cstmt.setString(3,(String)(child_pkgcode.get(j)));
							cstmt.setString(4,fromDateBP);
							cstmt.setString(5,child_effFrmDate);
							cstmt.setString(6,childEffToDate);
							cstmt.setString(7,user_id);
							cstmt.setString(8,client_ip_address);
							cstmt.setString(9,facility_id);
							cstmt.setString(10,user_id);
							cstmt.setString(11,client_ip_address);
							cstmt.setString(12,facility_id);
							cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(14,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(15,java.sql.Types.VARCHAR);
							cstmt.execute();
							str_error_level=cstmt.getString(13);
							str_sysmesage_id=cstmt.getString(14);
							str_error_text=cstmt.getString(15);
							if(str_error_level==null) str_error_level="";
							if(str_sysmesage_id==null) str_sysmesage_id="";
							if(str_error_text==null) str_error_text="";
							//System.out.println("str_error_level in insertpackageperiod:"+str_error_level);
							//System.out.println("str_sysmesage_id in insertpackageperiod:"+str_sysmesage_id);
							//System.out.println("str_error_text in insertpackageperiod:"+str_error_text);
							cstmt.close();
							if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
							{
								insertable=false;
								break;
							}
							else
							{
								insertable = true;
							}
						}
						
				//	}// end flagval
					
					else if(flagVal.equals("modify"))
					{
								
						String sqlblpackage="{ call   blpackage.ischildpackagerecordchanged (?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?)}";
						//System.out.println("sqlblpackage dfs - 503 - insertchildpackage==>  "+sqlblpackage);
					//	for(int j=0;j<child_effFromDate.size(); j++)
					//	{
 							
							child_effFrmDate = com.ehis.util.DateUtils.convertDate((String)(child_effFromDate.get(j)),"DMY",locale,"en");
							childEffToDate = com.ehis.util.DateUtils.convertDate((String)(child_effToDate.get(j)),"DMY",locale,"en");
							cstmt = con.prepareCall(sqlblpackage);
							cstmt.setString(1,facility_id);
							cstmt.setString(2,packageCode);
							cstmt.setString(3,(String)(child_pkgcode.get(j)));
							cstmt.setString(4,fromDateBP);
							cstmt.setString(5,child_effFrmDate);
							cstmt.setString(6,childEffToDate);
							cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
							cstmt.execute();
							recModified=cstmt.getString(7);
							str_error_level=cstmt.getString(8);
							str_sysmesage_id=cstmt.getString(9);
							str_error_text=cstmt.getString(10);
							if(str_error_level==null) str_error_level="";
							if(str_sysmesage_id==null) str_sysmesage_id="";
							if(str_error_text==null) str_error_text="";
							//System.out.println("str_error_level in insertpackageperiod:"+str_error_level);
							//System.out.println("str_sysmesage_id in insertpackageperiod:"+str_sysmesage_id);
							//System.out.println("str_error_text in insertpackageperiod:"+str_error_text);
							cstmt.close();
							if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
							{
								insertable=false;
								break;
							}
							else
							{
								insertable = true;
							}
						//  }
						  
						}// end else flagVal
						System.out.println("insertable 4663 :"+insertable);
						System.out.println("recModified 4663 :"+recModified);
						if(insertable && recModified!=null && "Y".equals(recModified))
						{
						String sqlblpackage="{ call   blpackage.updatechildpackage (?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,sysdate,?,?,?,?,?)}";
						//System.out.println("sqlblpackage dfs - 503 - insertchildpackage==>  "+sqlblpackage);
					//	for(int j=0;j<child_effFromDate.size(); j++)
					//	{
 							
							child_effFrmDate = com.ehis.util.DateUtils.convertDate((String)(child_effFromDate.get(j)),"DMY",locale,"en");
							childEffToDate = com.ehis.util.DateUtils.convertDate((String)(child_effToDate.get(j)),"DMY",locale,"en");
							cstmt = con.prepareCall(sqlblpackage);
							cstmt.setString(1,facility_id);
							cstmt.setString(2,packageCode);
							cstmt.setString(3,(String)(child_pkgcode.get(j)));
							cstmt.setString(4,fromDateBP);
							cstmt.setString(5,child_effFrmDate);
							cstmt.setString(6,childEffToDate);
							cstmt.setString(7,user_id);
							cstmt.setString(8,client_ip_address);
							cstmt.setString(9,facility_id);
							cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
							cstmt.execute();
							str_error_level=cstmt.getString(10);
							str_sysmesage_id=cstmt.getString(11);
							str_error_text=cstmt.getString(12);
							if(str_error_level==null) str_error_level="";
							if(str_sysmesage_id==null) str_sysmesage_id="";
							if(str_error_text==null) str_error_text="";
							//System.out.println("str_error_level in insertpackageperiod:"+str_error_level);
							//System.out.println("str_sysmesage_id in insertpackageperiod:"+str_sysmesage_id);
							//System.out.println("str_error_text in insertpackageperiod:"+str_error_text);
							cstmt.close();
							if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
							{
								insertable=false;
								break;
							}
							else
							{
								insertable = true;
							}
						//  }
						}// end recModified
					}
					}// end for
					 
				}//end dtlsarray
				
			}// end childPackdtl
				}
			}
		}
		catch(Exception e)
		{
			insertable=false;
			System.err.println("Exception from Child Package:"+e);
			e.printStackTrace();
		}
		finally
		{
		}
		/*Child Package insertion - end*/

		/*Package base price modifocation - start*/
		try
		{
			System.out.println("insertable 4732 :"+insertable);
			if(insertable)
			{
				/*System.out.println(" insertible For package price priceFromDate:"+priceFromDate); */
				  System.out.println("  basePrice:"	+basePrice);
				if(basePrice.containsKey(packageCode))
				{
					String sqlblpackage="";
					HashMap basePriceDtls   = (HashMap)basePrice.get(packageCode);
					String fromDateBP = "";
					String flagVal= "";
					for(int i=0;i<priceFromDate.size();i++)
					{
						fromDateBP = (String)priceFromDate.get(i);
						if(basePriceDtls.containsKey(fromDateBP))
						{
							ArrayList dtlsArray =(ArrayList)basePriceDtls.get(fromDateBP);

							if(dtlsArray.size()>0)
							{
								ArrayList blgClsCodeGrp		= (ArrayList)dtlsArray.get(0);
								ArrayList indicatorGrp		= (ArrayList)dtlsArray.get(2);
								ArrayList price				= (ArrayList)dtlsArray.get(3);
								ArrayList roundToGrp		= (ArrayList)dtlsArray.get(4);
								ArrayList roundIndGrp		= (ArrayList)dtlsArray.get(5);
								ArrayList factorApplGrp		= (ArrayList)dtlsArray.get(6);
								ArrayList flag				= (ArrayList)dtlsArray.get(7);
								ArrayList depositGrp		= (ArrayList)dtlsArray.get(8);
								ArrayList partialDepGrp		= (ArrayList)dtlsArray.get(9);
								ArrayList minDepAmtindGrp	= (ArrayList)dtlsArray.get(10);
								ArrayList minDepAmtGrp		= (ArrayList)dtlsArray.get(11);
								ArrayList factorforServiceRateGrp = (ArrayList)dtlsArray.get(12);//Added by Muthu against Factor CRF on 26-6-12

								for(int j=0; j<blgClsCodeGrp.size(); j++)
								{
									flagVal =  (String)flag.get(j) ;
									if(flagVal.equals("insert"))
									{
									sqlblpackage="{ call   blpackage.insertpackagebaseprice(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?)}";//Added by Muthu against Factor CRF on 26-6-12
									//sqlblpackage="{ call   blpackage.insertpackagebaseprice(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?)}";
									cstmt = con.prepareCall(sqlblpackage);
									cstmt.setString(1,facility_id);
									cstmt.setString(2,packageCode);
									cstmt.setString(3,com.ehis.util.DateUtils.convertDate(fromDateBP,"DMY",locale,"en"));
									cstmt.setString(4,(String)(blgClsCodeGrp.get(j)));
									cstmt.setString(5,(String)(indicatorGrp.get(j)));
									cstmt.setString(6,(String)(price.get(j)));
									cstmt.setString(7,(String)(roundToGrp.get(j)));
									cstmt.setString(8,(String)(roundIndGrp.get(j)));
									cstmt.setString(9,(String)(depositGrp.get(j)));
									cstmt.setString(10,(String)(partialDepGrp.get(j)));
									cstmt.setString(11,(String)(minDepAmtindGrp.get(j)));
									cstmt.setString(12,(String)(minDepAmtGrp.get(j)));
									cstmt.setString(13,(String)(factorApplGrp.get(j)));
									cstmt.setString(14,(String)(factorforServiceRateGrp.get(j)));//Added by Muthu against Factor CRF on 26-6-12
									cstmt.setString(15,user_id);
									cstmt.setString(16,user_id);
									cstmt.setString(17,client_ip_address);
									cstmt.setString(18,facility_id);
									cstmt.setString(19,client_ip_address);
									cstmt.setString(20,facility_id);

									cstmt.registerOutParameter(21,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(22,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(23,java.sql.Types.VARCHAR);
									cstmt.execute();

									str_error_level=cstmt.getString(21);
									str_sysmesage_id=cstmt.getString(22);
									str_error_text=cstmt.getString(23);
									}
									else if(flagVal.equals("modify"))
									{
									//System.out.println("Entering into Modify ispkgbasepricerecordchanged");
									//sqlblpackage  ="{ call   blpackage.ispkgbasepricerecordchanged(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
									sqlblpackage  ="{ call   blpackage.ispkgbasepricerecordchanged(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";//Added by muthu
									//System.out.println("sqlblpackage - 3345 ==> "+sqlblpackage);
									cstmt = con.prepareCall(sqlblpackage);
									cstmt.setString(1,facility_id);

									cstmt.setString(2,packageCode);

									cstmt.setString(3,fromDateBP);

									cstmt.setString(4,(String)(blgClsCodeGrp.get(j)));

									cstmt.setString(5,(String)(indicatorGrp.get(j)));
									cstmt.setString(6,(String)(price.get(j)));
									cstmt.setString(7,(String)(roundToGrp.get(j)));
									cstmt.setString(8,(String)(roundIndGrp.get(j)));
									cstmt.setString(9,(String)(depositGrp.get(j)));
									cstmt.setString(10,(String)(partialDepGrp.get(j)));
									cstmt.setString(11,(String)(minDepAmtindGrp.get(j)));
									cstmt.setString(12,(String)(minDepAmtGrp.get(j)));
									cstmt.setString(13,(String)(factorApplGrp.get(j)));
									cstmt.setString(14,(String)(factorforServiceRateGrp.get(j)));//Added by muthu
									cstmt.registerOutParameter(15,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(16,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(17,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(18,java.sql.Types.VARCHAR);
									//System.out.println("3441");
									cstmt.execute();
									//System.out.println("3443");
									recModified=cstmt.getString(15);
									str_error_level=cstmt.getString(16);
									str_sysmesage_id=cstmt.getString(17);
									str_error_text=cstmt.getString(18);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									/*System.out.println("recModified:"+recModified);
									System.out.println("str_error_level in process ispkgbasepricerecordchanged:"+str_error_level);
									System.out.println("str_sysmesage_id in ispkgbasepricerecordchanged:"+str_sysmesage_id);
									System.out.println("str_error_text in process ispkgbasepricerecordchanged:"+str_error_text);*/

									cstmt.close();
									//System.out.println("3455");
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										//System.out.println("3460");
										insertable=false;
										break;
									}
									else
									{
										//System.out.println("3466");
										insertable = true;
									}
									//Condition Changed by Rajesh V against IN43859
									if(insertable && "Y".equals(recModified))
									{
									//sqlblpackage="{ call   blpackage.updatepackagebaseprice(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?,?)}";
									sqlblpackage="{ call   blpackage.updatepackagebaseprice(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?,?)}";//Added by Muthu against Factor CRF on 26-6-12
									cstmt = con.prepareCall(sqlblpackage);
									cstmt.setString(1,facility_id);
									cstmt.setString(2,packageCode);
									cstmt.setString(3,com.ehis.util.DateUtils.convertDate(fromDateBP,"DMY",locale,"en"));
									cstmt.setString(4,(String)(blgClsCodeGrp.get(j)));
								//	System.out.println("4:"+(String)(blgClsCodeGrp.get(j)));
									cstmt.setString(5,(String)(indicatorGrp.get(j)));
								//	System.out.println("5:"+(String)(indicatorGrp.get(j)));
									cstmt.setString(6,(String)(price.get(j)));
								//	System.out.println("6:"+(String)(price.get(j)));;
									cstmt.setString(7,(String)(roundToGrp.get(j)));
									cstmt.setString(8,(String)(roundIndGrp.get(j)));

									cstmt.setString(9,(String)(depositGrp.get(j)));
									cstmt.setString(10,(String)(partialDepGrp.get(j)));
									cstmt.setString(11,(String)(minDepAmtindGrp.get(j)));
									cstmt.setString(12,(String)(minDepAmtGrp.get(j)));
									cstmt.setString(13,(String)(factorApplGrp.get(j)));
									//System.out.println("13:"+(String)(factorApplGrp.get(j)));
									cstmt.setString(14,(String)(factorforServiceRateGrp.get(j)));//Added by Muthu against Factor CRF on 26-6-12
									cstmt.setString(15,user_id);
									cstmt.setString(16,client_ip_address);
									cstmt.setString(17,facility_id);

									cstmt.registerOutParameter(18,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(19,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(20,java.sql.Types.VARCHAR);
									cstmt.execute();

									str_error_level=cstmt.getString(18);
									str_sysmesage_id=cstmt.getString(19);
									str_error_text=cstmt.getString(20);
									}

									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									/*System.out.println("str_error_level in process:"+str_error_level);
									System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
									System.out.println("str_error_text in process:"+str_error_text);*/
									cstmt.close();
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insertable=false;
										break;
									}
									else
									{
										insertable = true;
									}
									}
								}
							}
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			insertable=false;
			sys_err.append(" Exception while calling blpackage.update/isBasePrice:"+e);
			System.err.println("Exception in blpackage.update/isBasePrice Call:"+e);
			e.printStackTrace();
		}
	   		/*Package base price(date) modify - end*/

		   /* For Base price
			try
			{
				if(insertable)
				{
					String flagVal      = "";
					String sqlblpackage = "";
					String sqlComp ="{ call   blpackage.ispkgbasepricerecordchangedYN(?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?)}";
					String compFlag = "N";
					 System.out.println("sqlComp:"+sqlComp);
					 System.out.println("blgClsCodeGrp.size():"+blgClsCodeGrp.size());
					for(int i=0; i<blgClsCodeGrp.size(); i++)
					{
						compFlag = "N";
						blgClsCode  = (String)blgClsCodeGrp.get(i);
						fromDate	= (String)priceFromDate.get(i);
						toDate		= (String)priceToDate.get(i);
						indicator	= (String)indicatorGrp.get(i);
						price1		= (String)price.get(i);
						factorAppl	= (String)factorApplGrp.get(i);
						flagVal		= (String)flag.get(i);
						System.out.println("blgClsCode:"+blgClsCode);
						System.out.println("fromDate:"+fromDate);
						System.out.println("toDate:"+toDate);
						System.out.println("indicator:"+indicator);
						System.out.println("price1:"+price1);
						System.out.println("factorAppl:"+factorAppl);
						System.out.println("flagVal:"+flagVal);
						if (!(toDate.equals("")))
								toDate = com.ehis.util.DateUtils.convertDate(toDate,"DMY",locale,"en");
						else
							toDate="";

						if(!(fromDate.equals("")))
						{
								fromDate = com.ehis.util.DateUtils.convertDate(fromDate,"DMY",locale,"en");
						}
						else
						{
							fromDate="";
						}

						if(flagVal.equals("modify"))
							continue;
						else if(flagVal.equals("modifyLast"))
						{
							try
							{
								System.out.println("--------for comparison---:");
								if(cstmt1!=null)	 cstmt1.close();
								System.out.println("cstmt1 initial:"+cstmt1);
								cstmt1 = con.prepareCall(sqlComp);
								System.out.println("sqlComp:"+sqlComp);
								cstmt1.setString(1,facility_id);
								System.out.println("facility_id:"+facility_id);


								cstmt1.setString(2,packageCode);
								System.out.println("packageCode:"+packageCode);

								cstmt1.setString(3,blgClsCode);
								System.out.println("blgClsCode:"+blgClsCode);

								cstmt1.setString(4,fromDate);
								System.out.println("fromDate:"+fromDate);

								cstmt1.setString(5,toDate);
								System.out.println("toDate:"+toDate);

								cstmt1.setString(6,indicator);
								System.out.println("indicator:"+indicator);

								cstmt1.setString(7,price1);
								System.out.println("price1:"+price1);

								cstmt1.setString(8,factorAppl);
								System.out.println("factorAppl:"+factorAppl);
								 System.out.println(" cstmt1:"+cstmt1);
								cstmt1.registerOutParameter(9,java.sql.Types.VARCHAR);
								System.out.println("9:");

								cstmt1.registerOutParameter(10,java.sql.Types.VARCHAR);
								System.out.println("10");

								cstmt1.registerOutParameter(11,java.sql.Types.VARCHAR);
								System.out.println("11");

								cstmt1.registerOutParameter(12,java.sql.Types.VARCHAR);
								System.out.println("12");
								 System.out.println(" cstmt1 2:"+cstmt1);
								str_error_level=(String)cstmt1.getObject(10);
								System.out.println(" str_error_level :"+str_error_level);
								str_sysmesage_id=cstmt1.getString(11);
								System.out.println(" str_sysmesage_id :"+str_sysmesage_id);
								str_error_text=cstmt1.getString(12);
								System.out.println(" str_error_text :"+str_error_text);

								compFlag=cstmt1.getString(9);
								System.out.println(" compFlag :"+compFlag);

							}
							catch(Exception e)
							{
								 System.out.println(" cstmt1 3:"+cstmt1);
								System.out.println("Exception while comparing :"+e);
								System.out.println(" str_error_level :"+str_error_level);
								System.out.println(" str_sysmesage_id :"+str_sysmesage_id);
								System.out.println(" str_error_text :"+str_error_text);
											e.printStackTrace();

							}
							if(cstmt1!=null)	 cstmt1.close();
							if(compFlag.equals("Y"))
							{
								sqlblpackage="{ call   blpackage.UpdatePackageBasePrice(?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,sysdate,?,?,?,?,?)}";

							if(cstmt!=null)	 cstmt.close();
							cstmt = con.prepareCall(sqlblpackage);
							cstmt.setString(1,facility_id);
							System.out.println("1"+facility_id);
							cstmt.setString(2,packageCode);
							cstmt.setString(3,blgClsCode);
							cstmt.setString(4,fromDate);
							cstmt.setString(5,toDate);
							cstmt.setString(6,indicator);
							cstmt.setString(7,price1);
							cstmt.setString(8,factorAppl);
							cstmt.setString(9,user_id);
							System.out.println("9:"+user_id);
							cstmt.setString(10,client_ip_address);
							System.out.println("10:"+client_ip_address);
							cstmt.setString(11,facility_id);
							System.out.println("11:");
							cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(14,java.sql.Types.VARCHAR);
							cstmt.execute();
							str_error_level=cstmt.getString(12);
							str_sysmesage_id=cstmt.getString(13);
							str_error_text=cstmt.getString(14);
							if(str_error_level==null) str_error_level="";
							if(str_sysmesage_id==null) str_sysmesage_id="";
							if(str_error_text==null) str_error_text="";

							System.out.println("str_error_level in process:"+str_error_level);
							System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
							System.out.println("str_error_text in process:"+str_error_text);
							cstmt.close();

							if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
							{
								insertable=false;
								break;
							}
							else
							{
								insertable = true;
							}
						}

						}
						else  if(flagVal.equals("insert"))
						{
							sqlblpackage="{ call   blpackage.InsertPackageBasePrice(?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?)}";
							cstmt = con.prepareCall(sqlblpackage);
							cstmt.setString(1,facility_id);
							System.out.println("1"+facility_id);
							cstmt.setString(2,packageCode);
							cstmt.setString(3,blgClsCode);
							cstmt.setString(4,fromDate);
							cstmt.setString(5,toDate);
							cstmt.setString(6,indicator);
							cstmt.setString(7,price1);
							cstmt.setString(8,factorAppl);
							cstmt.setString(9,user_id);
							System.out.println("9:"+user_id);
							cstmt.setString(10,user_id);
							System.out.println("10:"+user_id);
							cstmt.setString(11,client_ip_address);
							System.out.println("11:"+client_ip_address);
							cstmt.setString(12,facility_id);
							System.out.println("12:");
							cstmt.setString(13,client_ip_address);
							System.out.println("13:");
							cstmt.setString(14,facility_id);
							System.out.println("14:");
							cstmt.registerOutParameter(15,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(16,java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(17,java.sql.Types.VARCHAR);
							cstmt.execute();
							str_error_level=cstmt.getString(15);
							str_sysmesage_id=cstmt.getString(16);
							str_error_text=cstmt.getString(17);
							if(str_error_level==null) str_error_level="";
							if(str_sysmesage_id==null) str_sysmesage_id="";
							if(str_error_text==null) str_error_text="";

							System.out.println("str_error_level in process:"+str_error_level);
							System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
							System.out.println("str_error_text in process:"+str_error_text);
							cstmt.close();

							if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
							{
								insertable=false;
								break;
							}
							else
							{
								insertable = true;
							}
						}

						System.out.println("sqlblpackage :"+sqlblpackage);


					}
				}//if insertable



			}catch(Exception e)
			 {
				insertable=false;
				sys_err.append(" Exception while calling blpackage.UpdatePackageBasePrice:"+e);
				System.out.println("Exception in blpackage.UpdatePackageBasePrice Call:"+e);
							e.printStackTrace();
			 }

			End Base price */
	/*	  ChargeBased modification  */
	System.out.println("Before calling Charge Based Insertions:"+insertable);
	try
	{
		System.out.println("insertable 5166 :"+insertable);
		if(insertable)
		{	String fromDateSer= "";
			String sqlDelCB="";
			ArrayList dbServicesVals = new ArrayList();
			//if(dbIncludedItems_CB!=null && dbIncludedItems_CB.containsKey(packageCode))
			//	dbServices =  (ArrayList)dbIncludedItems_CB.get(packageCode);
			//if(dbServices.size()>0)
				//dbServicesVals = (ArrayList)dbServices.get(0);


			if(dbIncludedItems_CB.size()>0 && dbIncludedItems_CB.containsKey(packageCode) && (includedItems_CB == null || includedItems_CB.size()<=0) )
		    {

				if(!(includedItems_CB.containsKey(packageCode)))
				{
					/*Delecte all the records from Exclusions */
					try
					{
						if(pstmt!=null) pstmt.close();
						sqlDelCB="Delete from bl_package_exclusions where PACKAGE_CODE = ? and RATE_CHARGE_IND = 'C' and OPERATING_FACILITY_ID=?";
						//if(pstmt!=null) pstmt=null;
						if(pstmt!=null) pstmt.close();
						pstmt=con.prepareStatement(sqlDelCB);
						pstmt.setString(1,packageCode);
						pstmt.setString(2,facility_id);
						pstmt.executeUpdate();
					}
					catch(Exception e)
					{
						insertable=false;
						System.err.println("Exception on deletion Change based exclusions 1 :"+e);
						e.printStackTrace();
					}
					/*Delecte all  inclusions  */
					try
					{
						if(pstmt!=null) pstmt.close();
						sqlDelCB="Delete from BL_PACKAGE_DTLS where PACKAGE_CODE = ? and RATE_CHARGE_IND = 'C' and OPERATING_FACILITY_ID=?";
						//if(pstmt!=null) pstmt=null;
						if(pstmt!=null) pstmt.close();
						pstmt=con.prepareStatement(sqlDelCB);
						pstmt.setString(1,packageCode);
						pstmt.setString(2,facility_id);
						pstmt.executeUpdate();
					}
					catch(Exception e)
					{
						insertable=false;
						System.err.println("Exception on deletion Change based 1 :"+e);
						e.printStackTrace();
					}
				}
			}
			else if((dbIncludedItems_CB == null || dbIncludedItems_CB.size()<=0) && includedItems_CB != null && includedItems_CB.size()>0 && includedItems_CB.containsKey(packageCode))
			{
				//System.out.println("Charge based Insert all inclusions and exclusions");
				/* Insert all inclusions and exclusions */
				includedItemsFD_CB = (HashMap)includedItems_CB.get(packageCode);
				if(insertable){
				for(int k=0;k<priceFromDate.size(); k++)
				{
			   		fromDateSer = (String)priceFromDate.get(k);
					if(includedItemsFD_CB.containsKey(fromDateSer) && includedItemsFD_CB.size()>0 )
					{
							services =(ArrayList)includedItemsFD_CB.get(fromDateSer);
							if(services.size()>0)
							{
								typeGroup			= (ArrayList)services.get(0);//MuthuN against 28192
								serviceGroup		= (ArrayList)services.get(1);
								amtLmtIndGroup		= (ArrayList)services.get(3);
								amtLmtGroup			= (ArrayList)services.get(4);
								factor_applGroup    = (ArrayList)services.get(6);
								roundToGroup		= (ArrayList)services.get(7);
								roundIndGroup		= (ArrayList)services.get(8);
								refundGroup			= (ArrayList)services.get(9);
								refundAmtGroup		= (ArrayList)services.get(10);
								auto_refund_list	= (ArrayList)services.get(11);
								split_reqd_list			= (ArrayList)services.get(12);//Split reqd
								includeHomeMedication_list			= (ArrayList)services.get(13);
								/*serviceGroup		= (ArrayList)services.get(0);
								amtLmtIndGroup		= (ArrayList)services.get(2);
								amtLmtGroup			= (ArrayList)services.get(3);
								factor_applGroup    = (ArrayList)services.get(5);
								roundToGroup		= (ArrayList)services.get(6);
								roundIndGroup		= (ArrayList)services.get(7);
								refundGroup			= (ArrayList)services.get(8);
								refundAmtGroup		= (ArrayList)services.get(9);
								auto_refund_list	= (ArrayList)services.get(10);*/
								System.out.println("serviceGroup manager:"+serviceGroup);
								totRec = serviceGroup.size(); // Commented by MuthuN
								//totRec = typeGroup.size(); //Added by MuthuN
								if(insertable){
									System.out.println("totRec manager:"+totRec);
								for(int i=0; i<totRec; i++)
								{
									servInd	      =(String)typeGroup.get(i);//MuthuN against 28192
									//System.out.println("servInd ==> "+servInd);
									cbServiceCode =(String)serviceGroup.get(i);
									System.out.println("cbServiceCode manager:"+cbServiceCode);
									cbAmtLmtInd   =(String)amtLmtIndGroup.get(i);
									cbAmtLmt	  =(String)amtLmtGroup.get(i);
									//cbUnlimited   =(String)unlimitedGroup.get(i);
									factor_appl  =(String)factor_applGroup.get(i);
									roundTo			= (String)roundToGroup.get(i);
									roundInd		= (String)roundIndGroup.get(i);
									refundYN		=(String)refundGroup.get(i);
									refundAmt		=(String)refundAmtGroup.get(i);
									auto_refund		=(String)auto_refund_list.get(i);		
									splitReqd		=(String)split_reqd_list.get(i);//Split reqd
									includeHomeMedication		=(String)includeHomeMedication_list.get(i);
									
									//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - insertpackageservice
									//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - insertpackageservice
									sqlcb  ="{ call   blpackage.insertpackageservice(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";//sarathkumar InclHmeMedi
									cstmt = con.prepareCall(sqlcb);
									cstmt.setString(1,facility_id);
									cstmt.setString(2,packageCode);
									cstmt.setString(3,fromDateSer);
									cstmt.setString(4,cbServiceCode);
									cstmt.setString(5,servInd);//Muthu 09-8-12
									//cstmt.setString(5,"S");
									cstmt.setString(6,"C");
									cstmt.setString(7,"");
									cstmt.setString(8,"");
									cstmt.setString(9,factorRate );
									cstmt.setString(10,qtyLimit );
									cstmt.setString(11,cbAmtLmt);
									cstmt.setString(12,cbAmtLmtInd );
									cstmt.setString(13,"N");
									cstmt.setString(14,"");
									cstmt.setString(15,"" );
									cstmt.setString(16,refundYN );
									cstmt.setString(17,refundAmt );
									cstmt.setString(18,auto_refund);
									cstmt.setString(19,closePakgStat);
									cstmt.setString(20,roundTo);
									cstmt.setString(21,roundInd);
									cstmt.setString(22,factor_appl);
									cstmt.setString(23,user_id);
									cstmt.setString(24,user_id);
									cstmt.setString(25,client_ip_address);
									cstmt.setString(26,facility_id);
									cstmt.setString(27,client_ip_address);
									cstmt.setString(28,facility_id);
									cstmt.setString(29,splitReqd);//RRRR
									cstmt.setString(30,includeHomeMedication);
									cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(32,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(33,java.sql.Types.VARCHAR);
									cstmt.setString(34,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
									cstmt.setString(35,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
									cstmt.setString(36,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
									cstmt.setString(37,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
									cstmt.setString(38,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
									cstmt.setString(39,null);//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020/Package Service Charge Based no need to pass any values
									cstmt.execute();

									str_error_level=cstmt.getString(31);
									str_sysmesage_id=cstmt.getString(32);					
									str_error_text=cstmt.getString(33);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									/*System.out.println("str_error_level in process charge based modification:"+str_error_level);
									System.out.println("str_sysmesage_id in process charge based insertion:"+str_sysmesage_id);
									System.out.println("str_error_text in process charge based insertion:"+str_error_text);*/
									cstmt.close();
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
											insertable=false;
											break;
									}
									else
									{
										insertable = true;
									}
								}
								}
								if(insertable)
								{  /* Insert all exclusions  */
									if(insertable && excludedItems_CB.size()>0 && excludedItems_CB.containsKey(fromDateSer))
									{
										excludedItemsFD_CB = (HashMap)excludedItems_CB.get(fromDateSer);

										if(insertable && excludedItemsFD_CB.size()>0 && excludedItemsFD_CB.containsKey(cbServiceCode))
										{
											for(int j=0; j<serviceGroup.size(); j++)
											//for(int j=0; j<typeGroup.size(); j++) //Added
											{
												cbServiceCode = (String)serviceGroup.get(j);
												//cbServiceCode = (String)typeGroup.get(j);//Added
												totRec = 0;
												if(itemsForService!=null) itemsForService.clear();
												itemsForService =(ArrayList)excludedItemsFD_CB.get(cbServiceCode);
												if(itemsForService !=null && itemsForService.size()>0)
												{
													itemGroup				= (ArrayList)itemsForService.get(0);
													itemDescGroup			= (ArrayList)itemsForService.get(1);
													qtyLtGroup				= (ArrayList)itemsForService.get(2);
													amountLtGroup			= (ArrayList)itemsForService.get(3);
													inExcnGroup				= (ArrayList)itemsForService.get(4);
													split_reqd_list			= (ArrayList)itemsForService.get(5);//Split reqd
													includeHomeMedication_list			= (ArrayList)itemsForService.get(6);
													totRec			= itemGroup.size();
													for(int i=0; i<totRec; i++)
													{
														if(itemGroup.size()>0 && insertable)
														{
															itemCode	= (String)itemGroup.get(i);
															itemDesc	= (String)itemDescGroup.get(i);
															qtyLimit 	= (String)qtyLtGroup.get(i);
															cbAmtLmt    = (String)amountLtGroup.get(i);
															inExcl		= (String)inExcnGroup.get(i);
															splitReqd	  =(String)split_reqd_list.get(i);//Split reqd
															includeHomeMedication	  =(String)includeHomeMedication_list.get(i);
															/*System.out.println("cbServiceCode:"+cbServiceCode);
															System.out.println("cbAmtLmtInd:"+cbAmtLmtInd);
															System.out.println("cbAmtLmt:"+cbAmtLmt);
															System.out.println("cbUnlimited:"+cbUnlimited);*/
															if(inExcl.equals("Y"))
																amtLmtInd = "";
															else
																amtLmtInd = "A";
															//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - insertpackageexclusion
															//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - insertpackageexclusion
															sqlcb  ="{ call   blpackage.insertpackageexclusion(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; //sarathkumar InclHmeMedi
															cstmt = con.prepareCall(sqlcb);
															cstmt.setString(1,facility_id);
															cstmt.setString(2,packageCode);
															cstmt.setString(3,fromDateSer);

															cstmt.setString(4,cbServiceCode);
															cstmt.setString(5,"S");
															cstmt.setString(6,"C");
															cstmt.setString(7,itemCode);
															cstmt.setString(8,"M");
															cstmt.setString(9,inExcl );
															cstmt.setString(10,amtLmtInd);
															cstmt.setString(11,qtyLimit );
															cstmt.setString(12,cbAmtLmt );
															cstmt.setString(13,"" );
															cstmt.setString(14,"" );
															cstmt.setString(15,"" );
															cstmt.setString(16,"" );
															cstmt.setString(17,"" );
															cstmt.setString(18,"" );
															cstmt.setString(19,"" );
															cstmt.setString(20,"" );
															cstmt.setString(21,user_id);
															cstmt.setString(22,user_id);
															cstmt.setString(23,client_ip_address);
															cstmt.setString(24,facility_id);
															cstmt.setString(25,client_ip_address);
															cstmt.setString(26,facility_id);
															cstmt.setString(27,splitReqd);//RRRR
															cstmt.setString(28,includeHomeMedication);
															cstmt.registerOutParameter(29,java.sql.Types.VARCHAR);
															cstmt.registerOutParameter(30,java.sql.Types.VARCHAR);
															cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
															cstmt.setString(32,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
															cstmt.setString(33,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
															cstmt.setString(34,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
															cstmt.setString(35,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
															cstmt.setString(36,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
															cstmt.execute();
															str_error_level=cstmt.getString(29);
															str_sysmesage_id=cstmt.getString(30);					
															str_error_text=cstmt.getString(31);
															if(str_error_level==null) str_error_level="";
															if(str_sysmesage_id==null) str_sysmesage_id="";
															if(str_error_text==null) str_error_text="";
															cstmt.close();
															if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
															{
																insertable=false;
																break;
															}
															else
															{
																insertable = true;
															}
														}
													}
												}
												if(itemsForService!=null)
													itemsForService.clear();
												if((!insertable))
													break;
											}
										}
									 }
								}
							}
						}
				}
				}
			} 	/* End all insertions */
			else if(dbIncludedItems_CB != null && dbIncludedItems_CB.size()>0 && dbIncludedItems_CB.containsKey(packageCode) && includedItems_CB != null && includedItems_CB.size()>0 && includedItems_CB.containsKey(packageCode))
			{
				ArrayList itemsToInsert = null;
				ArrayList itemsToModify = null;
				includedItemsFD_CB =   (HashMap)includedItems_CB.get(packageCode);
				dbIncludedItemsFD_CB  = (HashMap)dbIncludedItems_CB.get(packageCode);
				if(insertable){
				for(int k=0;k<priceFromDate.size();k++)
				{
					itemsToInsert = new ArrayList();
					itemsToModify = new ArrayList();
					fromDateSer = (String)priceFromDate.get(k);

					if(insertable && dbIncludedItemsFD_CB.containsKey(fromDateSer) && !(includedItemsFD_CB.containsKey(fromDateSer)) )
					{

							/*Delecte all the records from Exclusions */
							try
							{
								if(pstmt!=null) pstmt.close();
								sqlDelCB="Delete from bl_package_exclusions where PACKAGE_CODE = ? and RATE_CHARGE_IND = 'C' and OPERATING_FACILITY_ID=? and EFF_FROM_DATE = to_date(?,'dd/mm/yyyy')";
								//if(pstmt!=null) pstmt=null;
								if(pstmt!=null) pstmt.close();
								pstmt=con.prepareStatement(sqlDelCB);
								pstmt.setString(1,packageCode);
								pstmt.setString(2,facility_id);
								pstmt.setString(3,fromDateSer);
								pstmt.executeUpdate();
							}
							catch(Exception e)
							{
									insertable=false;
								System.err.println("Exception on deletion Change based exclusions for the date 2 :"+fromDateSer+"  "+e);
								e.printStackTrace();
							}
							/*Delecte all  inclusions  */
							try
							{
								if(pstmt!=null) pstmt.close();
								sqlDelCB="Delete from BL_PACKAGE_DTLS where PACKAGE_CODE = ? and RATE_CHARGE_IND = 'C' and OPERATING_FACILITY_ID=? and EFF_FROM_DATE = to_date(?,'dd/mm/yyyy')";
								//if(pstmt!=null) pstmt=null;
								if(pstmt!=null) pstmt.close();
								pstmt=con.prepareStatement(sqlDelCB);
								pstmt.setString(1,packageCode);
								pstmt.setString(2,facility_id);
								pstmt.setString(3,fromDateSer);
								pstmt.executeUpdate();
							}
							catch(Exception e)
							{
								insertable=false;
								System.err.println("Exception on deletion Change based 2 :"+fromDateSer+"  "+e);
								e.printStackTrace();
							}

					}
					else if(includedItemsFD_CB.containsKey(fromDateSer) && !(dbIncludedItemsFD_CB.containsKey(fromDateSer)))
					{
						//System.out.println("Charge based Insert all inclusions and exclusions 2222");
				/* Insert all inclusions and exclusions */
						services =(ArrayList)includedItemsFD_CB.get(fromDateSer);
						if(insertable && services.size()>0)
						{

							//System.out.println("4180");
							typeGroup			=  (ArrayList)services.get(0);//MuthuN against 28192
							serviceGroup		= (ArrayList)services.get(1);
							amtLmtIndGroup		= (ArrayList)services.get(3);
							amtLmtGroup			= (ArrayList)services.get(4);
							factor_applGroup    = (ArrayList)services.get(6);
							roundToGroup		= (ArrayList)services.get(7);
							roundIndGroup		= (ArrayList)services.get(8);
							refundGroup			= (ArrayList)services.get(9);
							refundAmtGroup		= (ArrayList)services.get(10);
							auto_refund_list	= (ArrayList)services.get(11);
							split_reqd_list			= (ArrayList)services.get(12);//Split reqd
							includeHomeMedication_list			= (ArrayList)services.get(13);
							/*serviceGroup		= (ArrayList)services.get(0);
							System.out.println("serviceGroup:"+serviceGroup);
							amtLmtIndGroup		= (ArrayList)services.get(2);
							System.out.println("amtLmtIndGroup:"+amtLmtIndGroup);
							amtLmtGroup			= (ArrayList)services.get(3);
							System.out.println("amtLmtGroup:"+amtLmtGroup);
							//unlimitedGroup		= (ArrayList)services.get(4);
							System.out.println("unlimitedGroup:"+unlimitedGroup);
							factor_applGroup    = (ArrayList)services.get(5);
							roundToGroup		= (ArrayList)services.get(6);
							roundIndGroup		= (ArrayList)services.get(7);
							refundGroup			= (ArrayList)services.get(8);
							refundAmtGroup		= (ArrayList)services.get(9);
							auto_refund_list	= (ArrayList)services.get(10);*/								//System.out.println("factor_applGrup:"+factor_applGroup);

							totRec = serviceGroup.size();
							//totRec = typeGroup.size();//Added
							if(insertable){
							for(int i=0; i<totRec; i++)
							{
								servInd	      =(String)typeGroup.get(i);//MuthuN against 28192
								//System.out.println("servInd 4119 ==> "+servInd);
								cbServiceCode =(String)serviceGroup.get(i);
								cbAmtLmtInd   =(String)amtLmtIndGroup.get(i);
								cbAmtLmt	  =(String)amtLmtGroup.get(i);
								//cbUnlimited   =(String)unlimitedGroup.get(i);
								factor_appl  =(String)factor_applGroup.get(i);
								roundTo			= (String)roundToGroup.get(i);
								roundInd		= (String)roundIndGroup.get(i);
								refundYN		=(String)refundGroup.get(i);
								refundAmt		=(String)refundAmtGroup.get(i);
								auto_refund		=(String)auto_refund_list.get(i);									//System.out.println("cbServiceCode:"+cbServiceCode);
								splitReqd	  =(String)split_reqd_list.get(i);//Split reqd
								includeHomeMedication	  =(String)includeHomeMedication_list.get(i);
								
								//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - insertpackageservice
								//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - insertpackageservice
								sqlcb  ="{ call   blpackage.insertpackageservice(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";//sarathkumar InclHmeMedi //Modified By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
								cstmt = con.prepareCall(sqlcb);
								cstmt.setString(1,facility_id);
								cstmt.setString(2,packageCode);
								cstmt.setString(3,fromDateSer);
								cstmt.setString(4,cbServiceCode);
								cstmt.setString(5,servInd);//MuthuN against 28192
								//cstmt.setString(5,"S");
								cstmt.setString(6,"C");
								cstmt.setString(7,"");
								cstmt.setString(8,"");
								cstmt.setString(9,factorRate );
								cstmt.setString(10,qtyLimit );
								cstmt.setString(11,cbAmtLmt);
								cstmt.setString(12,cbAmtLmtInd );
								cstmt.setString(13,"N");
								cstmt.setString(14,"");
								cstmt.setString(15,"" );
								cstmt.setString(16,refundYN );
								cstmt.setString(17,refundAmt );
								cstmt.setString(18,auto_refund);
								cstmt.setString(19,closePakgStat);
								cstmt.setString(20,roundTo);
								cstmt.setString(21,roundInd);
								cstmt.setString(22,factor_appl);
								cstmt.setString(23,user_id);
								cstmt.setString(24,user_id);
								cstmt.setString(25,client_ip_address);
								cstmt.setString(26,facility_id);
								cstmt.setString(27,client_ip_address);
								cstmt.setString(28,facility_id);
								cstmt.setString(29,splitReqd);//RRRR
								cstmt.setString(30,includeHomeMedication);
								cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
								cstmt.registerOutParameter(32,java.sql.Types.VARCHAR);
								cstmt.registerOutParameter(33,java.sql.Types.VARCHAR);
								cstmt.setString(34,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
								cstmt.setString(35,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
								cstmt.setString(36,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
								cstmt.setString(37,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
								cstmt.setString(38,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
								cstmt.setString(39,null);//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020/Package Service Charge Based no need to pass any values
								cstmt.execute();

								str_error_level=cstmt.getString(31);
								str_sysmesage_id=cstmt.getString(32);					
								str_error_text=cstmt.getString(33);
								if(str_error_level==null) str_error_level="";
								if(str_sysmesage_id==null) str_sysmesage_id="";
								if(str_error_text==null) str_error_text="";
								cstmt.close();
								if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
								{
											insertable=false;
											break;
									}
									else
									{
										insertable = true;
									}
								}
								}
								if(insertable)
								{  /* Insert all exclusions  */
									if(excludedItems_CB.size()>0 && excludedItems_CB.containsKey(fromDateSer))
									{
										excludedItemsFD_CB = (HashMap)excludedItems_CB.get(fromDateSer);

										if(insertable && excludedItemsFD_CB.size()>0 && excludedItemsFD_CB.containsKey(cbServiceCode))
										{
											for(int j=0; j<serviceGroup.size(); j++)
											//for(int j=0; j<typeGroup.size(); j++)//Added
											{
												cbServiceCode = (String)serviceGroup.get(j);
												//cbServiceCode = (String)typeGroup.get(j);//Added
												totRec = 0;
												if(itemsForService!=null) itemsForService.clear();
												itemsForService =(ArrayList)excludedItemsFD_CB.get(cbServiceCode);
												if(itemsForService!=null && itemsForService.size()>0)
												{
													itemGroup				= (ArrayList)itemsForService.get(0);
													itemDescGroup			= (ArrayList)itemsForService.get(1);
													qtyLtGroup				= (ArrayList)itemsForService.get(2);
													amountLtGroup			= (ArrayList)itemsForService.get(3);
													inExcnGroup				= (ArrayList)itemsForService.get(4);
													split_reqd_list			= (ArrayList)itemsForService.get(5);//Split reqd
													includeHomeMedication_list			= (ArrayList)itemsForService.get(6);
													totRec			= itemGroup.size();
													for(int i=0; i<totRec; i++)
													{
														if(itemGroup.size()>0 && insertable)
														{
															itemCode	= (String)itemGroup.get(i);
															itemDesc	= (String)itemDescGroup.get(i);
															qtyLimit 	= (String)qtyLtGroup.get(i);
															cbAmtLmt    = (String)amountLtGroup.get(i);
															inExcl		= (String)inExcnGroup.get(i);
															splitReqd	  =(String)split_reqd_list.get(i);//Split reqd
															includeHomeMedication	  =(String)includeHomeMedication_list.get(i);
															/*System.out.println("cbServiceCode:"+cbServiceCode);
															System.out.println("cbAmtLmtInd:"+cbAmtLmtInd);
															System.out.println("cbAmtLmt:"+cbAmtLmt);
															System.out.println("cbUnlimited:"+cbUnlimited);*/
															if(inExcl.equals("Y"))
																amtLmtInd = "";
															else
																amtLmtInd = "A";
															//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - insertpackageexclusion
															//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - insertpackageexclusion
															sqlcb  ="{ call   blpackage.insertpackageexclusion(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; //sarathkumar InclHmeMedi
															cstmt = con.prepareCall(sqlcb);
															cstmt.setString(1,facility_id);
															cstmt.setString(2,packageCode);
															cstmt.setString(3,fromDateSer);
															cstmt.setString(4,cbServiceCode);
															cstmt.setString(5,"S");
															cstmt.setString(6,"C");
															cstmt.setString(7,itemCode);
															cstmt.setString(8,"M");
															cstmt.setString(9,inExcl );
															cstmt.setString(10,amtLmtInd );
															cstmt.setString(11,qtyLimit );
															cstmt.setString(12,cbAmtLmt );
															cstmt.setString(13,"" );
															cstmt.setString(14,"" );
															cstmt.setString(15,"" );
															cstmt.setString(16,"" );
															cstmt.setString(17,"" );
															cstmt.setString(18,"" );
															cstmt.setString(19,"" );
															cstmt.setString(20,"" );
															cstmt.setString(21,user_id);
															cstmt.setString(22,user_id);
															cstmt.setString(23,client_ip_address);
															cstmt.setString(24,facility_id);
															cstmt.setString(25,client_ip_address);
															cstmt.setString(26,facility_id);
															cstmt.setString(27,splitReqd);//RRRR
															cstmt.setString(28,includeHomeMedication);
															cstmt.registerOutParameter(29,java.sql.Types.VARCHAR);
															cstmt.registerOutParameter(30,java.sql.Types.VARCHAR);
															cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
															cstmt.setString(32,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
															cstmt.setString(33,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
															cstmt.setString(34,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
															cstmt.setString(35,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
															cstmt.setString(36,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
															cstmt.execute();
															str_error_level=cstmt.getString(29);
															str_sysmesage_id=cstmt.getString(30);					
															str_error_text=cstmt.getString(31);
															if(str_error_level==null) str_error_level="";
															if(str_sysmesage_id==null) str_sysmesage_id="";
															if(str_error_text==null) str_error_text="";
															cstmt.close();
															if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
															{
																insertable=false;
																break;
															}
															else
															{
																insertable = true;
															}
														}
													}
												}
												if(itemsForService!=null)
													itemsForService.clear();
												if((!insertable))
													break;
											}
										}
									 }
								}
							}


			}
			else	if(dbIncludedItemsFD_CB != null && dbIncludedItemsFD_CB.size()>0 && dbIncludedItemsFD_CB.containsKey(fromDateSer) && includedItemsFD_CB != null && includedItemsFD_CB.size()>0 && includedItemsFD_CB.containsKey(fromDateSer))
			{

				if(dbIncludedItemsFD_CB!=null && dbIncludedItemsFD_CB.containsKey(fromDateSer))
				dbServices =  (ArrayList)dbIncludedItemsFD_CB.get(fromDateSer);
					if(dbServices.size()>0)
					dbServicesVals = (ArrayList)dbServices.get(0);

				if(excludedItems_CB!=null && excludedItems_CB.size()>0 && excludedItems_CB.containsKey(fromDateSer))
				{
					excludedItemsFD_CB = (HashMap)excludedItems_CB.get(fromDateSer);
				}
					ArrayList inServices =   (ArrayList)includedItemsFD_CB.get(fromDateSer);
					//System.out.println(" inServices 4406 : "+inServices);
					/* For new insertions */
					if(insertable && inServices.size()>0)
					{
						//typeGroup    =  (ArrayList)inServices.get(0);//MuthuN against 28192
						serviceGroup		= (ArrayList)inServices.get(1);// Commented by MuthuN
						if(insertable && serviceGroup.size()>0) //Commented by MuthuN
						//if(insertable && typeGroup.size()>0) //Added by muthuN
						{
							totRec = serviceGroup.size(); // Commented by MuthuN

							typeGroup    =  (ArrayList)inServices.get(0);//MuthuN against 28192
							amtLmtIndGroup		= (ArrayList)inServices.get(3);
							amtLmtGroup			= (ArrayList)inServices.get(4);
							factor_applGroup    = (ArrayList)inServices.get(6);
							roundToGroup		= (ArrayList)inServices.get(7);
							roundIndGroup		= (ArrayList)inServices.get(8);
							refundGroup			= (ArrayList)inServices.get(9);
							refundAmtGroup		= (ArrayList)inServices.get(10);
							auto_refund_list	= (ArrayList)inServices.get(11);
							split_reqd_list			= (ArrayList)inServices.get(12);//Split reqd
							includeHomeMedication_list			= (ArrayList)inServices.get(13);
							//System.out.println(" inside serviceGroup 4429 : "+serviceGroup);
							//System.out.println(" totRec 4430 : "+totRec);

							/*amtLmtIndGroup		= (ArrayList)inServices.get(2);
							amtLmtGroup			= (ArrayList)inServices.get(3);
							//unlimitedGroup		= (ArrayList)inServices.get(4);
							factor_applGroup    = (ArrayList)inServices.get(5);
							roundToGroup		= (ArrayList)inServices.get(6);
							roundIndGroup		= (ArrayList)inServices.get(7);
							refundGroup			= (ArrayList)inServices.get(8);
							refundAmtGroup		= (ArrayList)inServices.get(9);
							auto_refund_list	= (ArrayList)inServices.get(10);*/

							if(insertable ){
							for(int j=0;j<totRec; j++)
							{
									servInd	      =(String)typeGroup.get(j);//MuthuN against 28192
									//System.out.println("servInd 4450 ==> "+servInd);
									cbServiceCode =(String)serviceGroup.get(j);
									cbAmtLmtInd   =(String)amtLmtIndGroup.get(j);
									cbAmtLmt	  =(String)amtLmtGroup.get(j);
									//cbUnlimited   =(String)unlimitedGroup.get(j);
									factor_appl  =(String)factor_applGroup.get(j);
									roundTo			= (String)roundToGroup.get(j);
									roundInd		= (String)roundIndGroup.get(j);
									refundYN		=(String)refundGroup.get(j);
									refundAmt		=(String)refundAmtGroup.get(j);
									auto_refund		=(String)auto_refund_list.get(j);
									splitReqd	  =(String)split_reqd_list.get(j);//Split reqd
									includeHomeMedication	  =(String)includeHomeMedication_list.get(j);
									/*System.out.println("refundYN:"+refundYN);
									System.out.println("refundAmt:"+refundAmt);
									System.out.println("auto_refund:"+auto_refund);
									System.out.println("cbServiceCode:"+cbServiceCode);
									System.out.println("cbAmtLmtInd:"+cbAmtLmtInd);
									System.out.println("cbAmtLmt:"+cbAmtLmt);
									System.out.println("cbUnlimited:"+cbUnlimited); */
									System.out.println("dbServicesVals:"+dbServicesVals);
									System.out.println("cbServiceCode:"+cbServiceCode);

									if(!dbServicesVals.contains(cbServiceCode))
									{
									  /* insert into BL_PACKAGE_DTLS */
										itemsToInsert.add(cbServiceCode);
										//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - insertpackageservice
										//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - insertpackageservice
										sqlcb  ="{ call   blpackage.insertpackageservice(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";//sarathkumar InclHmeMedi //Modified By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
										cstmt = con.prepareCall(sqlcb);
										cstmt.setString(1,facility_id);
										cstmt.setString(2,packageCode);
										cstmt.setString(3,fromDateSer);
										cstmt.setString(4,cbServiceCode);
										cstmt.setString(5,servInd);//muthu 28192
										//System.out.println("servInd in Manager.java 4485 ==> "+servInd);
										//cstmt.setString(5,"S");
										cstmt.setString(6,"C");
										cstmt.setString(7,"");
										cstmt.setString(8,"");
										cstmt.setString(9,factorRate );
										cstmt.setString(10,qtyLimit );
										cstmt.setString(11,cbAmtLmt);
										cstmt.setString(12,cbAmtLmtInd );
										cstmt.setString(13,"N");
										cstmt.setString(14,"");
										cstmt.setString(15,"" );
										cstmt.setString(16,refundYN );
										cstmt.setString(17,refundAmt );
										cstmt.setString(18,auto_refund);
										cstmt.setString(19,closePakgStat);
										cstmt.setString(20,roundTo);
										cstmt.setString(21,roundInd);
										cstmt.setString(22,factor_appl);
										cstmt.setString(23,user_id);
										cstmt.setString(24,user_id);
										cstmt.setString(25,client_ip_address);
										cstmt.setString(26,facility_id);
										cstmt.setString(27,client_ip_address);
										cstmt.setString(28,facility_id);
										cstmt.setString(29,splitReqd);//RRRR
										cstmt.setString(30,includeHomeMedication);
										cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
										cstmt.registerOutParameter(32,java.sql.Types.VARCHAR);
										cstmt.registerOutParameter(33,java.sql.Types.VARCHAR);
										cstmt.setString(34,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
										cstmt.setString(35,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
										cstmt.setString(36,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
										cstmt.setString(37,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
										cstmt.setString(38,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
										cstmt.setString(39,null);//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020/Package Service Charge Based no need to pass any values
										cstmt.execute();

										//Changed Below by Rajesh V for Internal Issue
										str_error_level=cstmt.getString(31);
										str_sysmesage_id=cstmt.getString(32);					
										str_error_text=cstmt.getString(33);
										if(str_error_level==null) str_error_level="";
										if(str_sysmesage_id==null) str_sysmesage_id="";
										if(str_error_text==null) str_error_text="";
										/*System.out.println("str_error_level in process charge based modification:"+str_error_level);
										System.out.println("str_sysmesage_id in process charge based insertion:"+str_sysmesage_id);
										System.out.println("str_error_text in process charge based insertion:"+str_error_text);*/
										cstmt.close();
										if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
										{
											insertable=false;
											break;
										}
										else
										{
											insertable = true;
										}
									}
									else
									{
										//System.out.println(" Compare valuse if modified call update");
										 /*Compare the values if modified call update  */
										recModified = "";
										itemsToModify.add(cbServiceCode);
										//System.out.println(" itemsToModifyitemsToModify :"+itemsToModify);
										totRec = serviceGroup.size(); // Commented by MuthuN
										//totRec = typeGroup.size(); //Added by muthuN
										//System.out.println(" totRec 4544 : "+totRec);

										if(cstmt!=null) cstmt.close();
										System.out.println("before calling ispkgservicerecordchanged,cbServiceCode="+cbServiceCode);
										//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - ispkgservicerecordchanged
										//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - ispkgservicerecordchanged
										sqlcb  ="{ call   blpackage.ispkgservicerecordchanged(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";//sarathkumar InclHmeMedi
										//System.out.println("sqlcb :"+sqlcb);
										cstmt = con.prepareCall(sqlcb);
										cstmt.setString(1,facility_id);
										cstmt.setString(2,packageCode);
										cstmt.setString(3,fromDateSer);
										cstmt.setString(4,cbServiceCode);
										cstmt.setString(5,servInd);//muthu 28192
										//System.out.println("servInd in Manager.java 4555 ==> "+servInd);
										//cstmt.setString(5,"S");
										cstmt.setString(6,"C");
										cstmt.setString(7,"" );
										cstmt.setString(8,"" );
										cstmt.setString(9,"");
										cstmt.setString(10,qtyLimit );
										cstmt.setString(11,cbAmtLmt );
										cstmt.setString(12,cbAmtLmtInd);
										cstmt.setString(13,"N");
										cstmt.setString(14,"" );
										cstmt.setString(15,"" );
										cstmt.setString(16,refundYN );
										cstmt.setString(17,refundAmt );
										cstmt.setString(18,auto_refund);
										cstmt.setString(19,"" );
										cstmt.setString(20,roundTo );
										cstmt.setString(21,roundInd);
										cstmt.setString(22,factor_appl);
										cstmt.setString(23, splitReqd);//Split reqd - For Validation
										cstmt.setString(24, includeHomeMedication);
										cstmt.registerOutParameter(25,java.sql.Types.VARCHAR);
										cstmt.registerOutParameter(26,java.sql.Types.VARCHAR);
										cstmt.registerOutParameter(27,java.sql.Types.VARCHAR);
										cstmt.registerOutParameter(28,java.sql.Types.VARCHAR);
										cstmt.setString(29,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
										cstmt.setString(30,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
										cstmt.setString(31,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
										cstmt.setString(32,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
										cstmt.setString(33,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
										cstmt.execute();

										recModified=cstmt.getString(25);
										str_error_level=cstmt.getString(26);
										str_sysmesage_id=cstmt.getString(27);					
										str_error_text=cstmt.getString(28);
										if(str_error_level==null) str_error_level="";
										if(str_sysmesage_id==null) str_sysmesage_id="";
										if(str_error_text==null) str_error_text="";
										if(recModified == null)		recModified="";
										/*System.out.println("recModified:"+recModified);
										System.out.println("str_error_level in process ispkgservicerecordchanged:"+str_error_level);
										System.out.println("str_sysmesage_id in process ispkgservicerecordchanged:"+str_sysmesage_id);
										System.out.println("str_error_text in process ispkgservicerecordchanged:"+str_error_text);*/
										cstmt.close();
										if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
										{
											insertable=false;
											break;
										}
										else
										{
											insertable = true;
										}
										if(insertable && "Y".equals(recModified))
										{
											//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - updatepackageservice
											//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - updatepackageservice
											sqlcb  ="{ call   blpackage.updatepackageservice(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?)}";//sarathkumar InclHmeMedi
											//System.out.println("sqlcb :"+sqlcb);
											cstmt = con.prepareCall(sqlcb);
											cstmt.setString(1,facility_id);
											cstmt.setString(2,packageCode);
											cstmt.setString(3,fromDateSer);
											cstmt.setString(4,cbServiceCode);
											//System.out.println("cbServiceCode:"+cbServiceCode);

											//cstmt.setString(5,"S");
											//System.out.println("5: S");
											cstmt.setString(5,servInd); //muthu 28192
											//System.out.println("servInd in Manager.java 4617 ==> "+servInd);

											cstmt.setString(6,"C");
											//System.out.println("6: C");

											cstmt.setString(7,"");
											//System.out.println("7:");

											cstmt.setString(8,"");
											//System.out.println("8:");

											cstmt.setString(9,factorRate );
											//System.out.println("9:"+factorRate );

											cstmt.setString(10,qtyLimit );
											//System.out.println("10:"+qtyLimit);

											cstmt.setString(11,cbAmtLmt);
											//System.out.println("11:"+cbAmtLmt);

											cstmt.setString(12,cbAmtLmtInd );
											//System.out.println("12:"+cbAmtLmtInd);

											cstmt.setString(13,"N");
											//System.out.println("13 ");

											cstmt.setString(14,"");
											//System.out.println("14 :");

											cstmt.setString(15,"" );
											//System.out.println("15 :");

											cstmt.setString(16,refundYN );
											//System.out.println("16 refundYN :"+refundYN);

											cstmt.setString(17,refundAmt );
											//System.out.println("17 refundAmt :"+refundAmt);

											cstmt.setString(18,auto_refund);
											//System.out.println("18: auto_refund:"+auto_refund );

											cstmt.setString(19,"");
											//System.out.println("19:"+"" );

											cstmt.setString(20,roundTo);
											//System.out.println("20:"+roundTo );

											cstmt.setString(21,roundInd);
											//System.out.println("21:"+roundInd );

											cstmt.setString(22,factor_appl);
											//System.out.println("22:"+factor_appl );


											cstmt.setString(23,user_id);
											//System.out.println("23:"+user_id);


											cstmt.setString(24,client_ip_address);
											//System.out.println("24:"+client_ip_address);


											cstmt.setString(25,facility_id);
											//System.out.println("25:"+facility_id);
											cstmt.setString(26,splitReqd);//RRRR
											cstmt.setString(27,includeHomeMedication);
											cstmt.registerOutParameter(28,java.sql.Types.VARCHAR);
											cstmt.registerOutParameter(29,java.sql.Types.VARCHAR);
											cstmt.registerOutParameter(30,java.sql.Types.VARCHAR);
											cstmt.setString(31,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
											cstmt.setString(32,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
											cstmt.setString(33,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
											cstmt.setString(34,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
											cstmt.setString(35,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
											cstmt.execute();

											str_error_level=cstmt.getString(28);
											str_sysmesage_id=cstmt.getString(29);					
											str_error_text=cstmt.getString(30);
											if(str_error_level==null) str_error_level="";
											if(str_sysmesage_id==null) str_sysmesage_id="";
											if(str_error_text==null) str_error_text="";
											/*System.out.println("str_error_level in process charge based modification:"+str_error_level);
											System.out.println("str_sysmesage_id in process charge based insertion:"+str_sysmesage_id);
											System.out.println("str_error_text in process charge based insertion:"+str_error_text);*/
											cstmt.close();
											//System.out.println("1");
											if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
											{
												//System.out.println("2");
													insertable=false;
												break;
											}
											else
											{
												//System.out.println("3");
												insertable = true;
											}
										}
									}
								}
								}
								if(insertable && (dbServicesVals.size()>0))
								{	String sCodeToChk ="";
									for(int i=0;i<dbServicesVals.size(); i++)
									{
										sCodeToChk = (String)dbServicesVals.get(i);
									if(!(serviceGroup.contains(sCodeToChk)) && insertable)//Commented by MuthuN
									//if(!(typeGroup.contains(sCodeToChk)) && insertable) //Added by MuthuN
										{
											/* Delecte all inclusions for the service */
											try
											{
												sqlDelCB="Delete from bl_package_exclusions where EFF_FROM_DATE = to_date(?,'dd/mm/yyyy') and PKG_SERV_CODE=? and PACKAGE_CODE = ? and RATE_CHARGE_IND = 'C' and OPERATING_FACILITY_ID=?";
												//if(pstmt!=null) pstmt=null;
												if(pstmt!=null) pstmt.close();
												pstmt=con.prepareStatement(sqlDelCB);
												pstmt.setString(1,fromDateSer);
												pstmt.setString(2,sCodeToChk);
												pstmt.setString(3,packageCode);
												pstmt.setString(4,facility_id);
												//System.out.println("fromDateSer"+fromDateSer+","+"sCodeToChk:"+sCodeToChk+","+"packageCode"+packageCode+","+"facility_id:"+facility_id);
												pstmt.executeUpdate();
												//System.out.println("All from exclusions deleted 3");
											}
											catch(Exception e)
											{
												insertable=false;
												System.err.println("Exception on deletion Change based exclusions 1 :"+e);
												e.printStackTrace();
											}
											/* Delete service from service */
											try
											{
												sqlDelCB="Delete from BL_PACKAGE_DTLS where  EFF_FROM_DATE = to_date(?,'dd/mm/yyyy') and PKG_SERV_CODE=? and PACKAGE_CODE = ? and RATE_CHARGE_IND = 'C' and OPERATING_FACILITY_ID=?";
											//if(pstmt!=null) pstmt=null;
											if(pstmt!=null) pstmt.close();
											pstmt=con.prepareStatement(sqlDelCB);
											pstmt.setString(1,fromDateSer);
											pstmt.setString(2,sCodeToChk);
											pstmt.setString(3,packageCode);
											pstmt.setString(4,facility_id);
											pstmt.executeUpdate();
											//System.out.println("All from services deleted 1");
											}
											catch(Exception e)
											{
												insertable=false;
												System.err.println("Exception on deletion Change based exclusions 1 :"+e);
												e.printStackTrace();
											}
											finally
											{
												if(pstmt!=null) pstmt.close();
											}
										}
									}
								}
							   /* Insertions and modifications in exclusions  */
								//System.out.println("itemsToInsert:"+itemsToInsert);
								if(insertable){
							   for(int j=0; j<itemsToInsert.size(); j++)
							   {
									cbServiceCode = (String)itemsToInsert.get(j);
									totRec = 0;
									if(itemsForService!=null) itemsForService.clear();
									/*System.out.println("cbServiceCode:"+cbServiceCode);
									System.out.println("excludedItems_CB:"+excludedItems_CB);
									System.out.println("fromDateSer:"+fromDateSer);*/
								    //System.out.println("excludedItems_CB.containsKey(fromDateSer):"+excludedItems_CB.containsKey(fromDateSer));
								    //System.out.println("excludedItemsFD_CB:"+excludedItemsFD_CB);
								    //System.out.println("excludedItemsFD_CB.containsKey(cbServiceCode):"+excludedItemsFD_CB.containsKey(cbServiceCode));

									if(excludedItems_CB.containsKey(fromDateSer) && excludedItemsFD_CB!=null &&  excludedItemsFD_CB.containsKey(cbServiceCode) )
									{
										itemsForService =(ArrayList)excludedItemsFD_CB.get(cbServiceCode);
		   	   							//System.out.println("itemsForService:"+itemsForService);
		   	   							//System.out.println("itemsForService.size():"+itemsForService.size());
										if(itemsForService!=null && itemsForService.size()>0)
										{
											itemGroup				= (ArrayList)itemsForService.get(0);
											//System.out.println("itemGroup:"+itemGroup);
											itemDescGroup			= (ArrayList)itemsForService.get(1);
											//System.out.println("itemDescGroup:"+itemDescGroup);
											qtyLtGroup				= (ArrayList)itemsForService.get(2);
											//System.out.println("qtyLtGroup:"+qtyLtGroup);
											amountLtGroup			= (ArrayList)itemsForService.get(3);
											//System.out.println("amountLtGroup:"+amountLtGroup);
											inExcnGroup				= (ArrayList)itemsForService.get(4);
											//System.out.println("inExcnGroup:"+inExcnGroup);
											split_reqd_list			= (ArrayList)itemsForService.get(5);//Split reqd
											includeHomeMedication_list			= (ArrayList)itemsForService.get(6);
											totRec			= itemGroup.size();
											//System.out.println("totRec:"+totRec);
											for(int i=0; i<totRec; i++)
											{
												if(itemGroup.size()>0 && insertable)
												{
													itemCode	= (String)itemGroup.get(i);
													itemDesc	= (String)itemDescGroup.get(i);
													qtyLimit 	= (String)qtyLtGroup.get(i);
													cbAmtLmt    = (String)amountLtGroup.get(i);
													inExcl		= (String)inExcnGroup.get(i);
													splitReqd	  =(String)split_reqd_list.get(i);//Split reqd
													includeHomeMedication	  =(String)includeHomeMedication_list.get(i);
													if(inExcl.equals("Y"))
														amtLmtInd = "";
													else
														amtLmtInd = "A";
													/*System.out.println("cbServiceCode:"+cbServiceCode);
													System.out.println("cbAmtLmtInd:"+cbAmtLmtInd);
													System.out.println("cbAmtLmt:"+cbAmtLmt);
													System.out.println("cbUnlimited:"+cbUnlimited);*/
													//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - insertpackageexclusion
													//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - insertpackageexclusion
													sqlcb  ="{ call   blpackage.insertpackageexclusion(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; //sarathkumar InclHmeMedi
													//System.out.println("sqlcb :"+sqlcb);
													cstmt = con.prepareCall(sqlcb);
													cstmt.setString(1,facility_id);
													cstmt.setString(2,packageCode);
													cstmt.setString(3,fromDateSer);
													cstmt.setString(4,cbServiceCode);
													//System.out.println("cbServiceCode:"+cbServiceCode);

													cstmt.setString(5,"S");
													//System.out.println("5:S");

													cstmt.setString(6,"C");
													//System.out.println("6: C");

													cstmt.setString(7,itemCode);
													//System.out.println("7:");

													cstmt.setString(8,"M");
												//	System.out.println("8:M");

													cstmt.setString(9,inExcl );
												//	System.out.println("9:"+factorRate );

													cstmt.setString(10,amtLmtInd );
												//	System.out.println("10:"+amtLmtInd);


													cstmt.setString(11,qtyLimit );
													//System.out.println("11:"+qtyLimit);

													cstmt.setString(12,cbAmtLmt );
													//System.out.println("12:"+cbAmtLmt);

													cstmt.setString(13,"" );
													//System.out.println("13:"+"");

													cstmt.setString(14,"" );
													//System.out.println("14:"+"");

													cstmt.setString(15,"" );
													//System.out.println("15:"+"");

													cstmt.setString(16,"" );
													//System.out.println("16:"+"");

													cstmt.setString(17,"" );
													//System.out.println("17:"+"");

													cstmt.setString(18,"" );
													//System.out.println("18:"+"");

													cstmt.setString(19,"" );
													//System.out.println("19:"+"");

													cstmt.setString(20,"" );
													//System.out.println("20:"+"");


													cstmt.setString(21,user_id);
													//System.out.println("21:");

													cstmt.setString(22,user_id);
													//System.out.println("22:");


													cstmt.setString(23,client_ip_address);
													//System.out.println("23:");

													cstmt.setString(24,facility_id);
													//System.out.println("24:");

													cstmt.setString(25,client_ip_address);
													//System.out.println("25:");

													cstmt.setString(26,facility_id);
													//System.out.println("26:");
													cstmt.setString(27,splitReqd);//RRRR
													cstmt.setString(28,includeHomeMedication);
													cstmt.registerOutParameter(29,java.sql.Types.VARCHAR);
													cstmt.registerOutParameter(30,java.sql.Types.VARCHAR);
													cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
													cstmt.setString(32,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
													cstmt.setString(33,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
													cstmt.setString(34,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
													cstmt.setString(35,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
													cstmt.setString(36,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
													cstmt.execute();

													str_error_level=cstmt.getString(29);
													str_sysmesage_id=cstmt.getString(30);					
													str_error_text=cstmt.getString(31);
													if(str_error_level==null) str_error_level="";
													if(str_sysmesage_id==null) str_sysmesage_id="";
													if(str_error_text==null) str_error_text="";
													/*System.out.println("str_error_level in process charge based insertion:"+str_error_level);
													System.out.println("str_sysmesage_id in process charge based insertion:"+str_sysmesage_id);
													System.out.println("str_error_text in process charge based insertion:"+str_error_text);*/
													cstmt.close();
													if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
													{
														insertable=false;
														break;
													}
													else
													{
														insertable = true;
													}
												}
											}
										}
									}
									if(itemsForService!=null)
										itemsForService.clear();
									if((!insertable))
										break;
								}
								}
								if(insertable && dbExcludedItems_CB != null && dbExcludedItems_CB.containsKey(fromDateSer))
									dbExcludedItemsFD_CB =(HashMap)dbExcludedItems_CB.get(fromDateSer);
								/*System.out.println("dbExcludedItems_CB:"+dbExcludedItems_CB);
								System.out.println("dbExcludedItemsFD_CB:"+dbExcludedItemsFD_CB);
								System.out.println("itemsToModify:"+itemsToModify);*/
								if(insertable){
							   for(int j=0; j<itemsToModify.size(); j++)
							   {
									//System.out.println("inside items to modify");
									cbServiceCode = (String)itemsToModify.get(j);
									dbServices = new ArrayList();
									totRec = 0;
									ArrayList dbServicesExVals = new ArrayList();
									if(itemsForService!=null) itemsForService.clear();
									//System.out.println("cbServiceCode:"+cbServiceCode);
									//System.out.println("excludedItems_CB.containsKey(packageCode):"+excludedItems_CB.containsKey(packageCode));
									//System.out.println("excludedItemsFD_CB.containsKey(cbServiceCode):"+excludedItemsFD_CB.containsKey(cbServiceCode));
									if(dbExcludedItemsFD_CB != null && dbExcludedItemsFD_CB.containsKey(cbServiceCode) )
									{
										dbServices=(ArrayList)dbExcludedItemsFD_CB.get(cbServiceCode);
										if(dbServices.size()>0)
											dbServicesExVals = (ArrayList)dbServices.get(0);
									}
									//System.out.println("Excluded dbServices:"+dbServices);
									//System.out.println("Excluded  dbServicesExVals:"+ dbServicesExVals);


									//if((dbExcludedItems_CB == null || dbExcludedItems_CB.size()<=0 ) && excludedItems_CB!=null && excludedItems_CB.size()>0 && excludedItems_CB.containsKey(packageCode))
									//{
		   	   							//System.out.println("dbExcludedItemsFD_CB:"+dbExcludedItemsFD_CB);
   	   									//System.out.println("excludedItemsFD_CB.size():"+excludedItemsFD_CB.size());

										if((dbExcludedItemsFD_CB == null || dbExcludedItemsFD_CB.size()<=0 ) && excludedItemsFD_CB!=null && excludedItemsFD_CB.size()>0 && excludedItemsFD_CB.containsKey(cbServiceCode))
										{		/* Insert all items */
											itemsForService =(ArrayList)excludedItemsFD_CB.get(cbServiceCode);
		   	   								//System.out.println("itemsForService:"+itemsForService);
   	   										//System.out.println("itemsForService.size():"+itemsForService.size());
											if(itemsForService!=null && itemsForService.size()>0)
											{
												itemGroup				= (ArrayList)itemsForService.get(0);
												//System.out.println("itemGroup:"+itemGroup);
												itemDescGroup			= (ArrayList)itemsForService.get(1);
												//System.out.println("itemDescGroup:"+itemDescGroup);
												qtyLtGroup				= (ArrayList)itemsForService.get(2);
												//System.out.println("qtyLtGroup:"+qtyLtGroup);
												amountLtGroup			= (ArrayList)itemsForService.get(3);
												//System.out.println("amountLtGroup:"+amountLtGroup);
												inExcnGroup				= (ArrayList)itemsForService.get(4);
												//System.out.println("inExcnGroup:"+inExcnGroup);
												split_reqd_list			= (ArrayList)itemsForService.get(5);//Split reqd
												includeHomeMedication_list			= (ArrayList)itemsForService.get(6);
												totRec			= itemGroup.size();
												//System.out.println("totRec:"+totRec);
												for(int i=0; i<totRec; i++)
												{
													if(itemGroup.size()>0 && insertable)
													{
														itemCode	= (String)itemGroup.get(i);
														itemDesc	= (String)itemDescGroup.get(i);
														qtyLimit 	= (String)qtyLtGroup.get(i);
														cbAmtLmt    = (String)amountLtGroup.get(i);
														inExcl		= (String)inExcnGroup.get(i);
														splitReqd	  =(String)split_reqd_list.get(i);//Split reqd
														includeHomeMedication	  =(String)includeHomeMedication_list.get(i);
														if(inExcl.equals("Y"))
															amtLmtInd = "";
														else
															amtLmtInd = "A";
														/*System.out.println("cbServiceCode:"+cbServiceCode);
														System.out.println("cbAmtLmtInd:"+cbAmtLmtInd);
														System.out.println("cbAmtLmt:"+cbAmtLmt);
														System.out.println("cbUnlimited:"+cbUnlimited);*/
														//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - insertpackageexclusion
														//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - insertpackageexclusion
														sqlcb  ="{ call   blpackage.insertpackageexclusion(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; //sarathkumar InclHmeMedi
														//System.out.println("sqlcb :"+sqlcb);
														cstmt = con.prepareCall(sqlcb);
														cstmt.setString(1,facility_id);
														cstmt.setString(2,packageCode);
														cstmt.setString(3,fromDateSer);

														cstmt.setString(4,cbServiceCode);
														//System.out.println("cbServiceCode:"+cbServiceCode);

														cstmt.setString(5,"S");
														//System.out.println("5S:");

														cstmt.setString(6,"C");
														//System.out.println("6: C");

														cstmt.setString(7,itemCode);
														//System.out.println("7:");

														cstmt.setString(8,"M");
														//System.out.println("8:M");

														cstmt.setString(9,inExcl );
														//System.out.println("9:"+factorRate );

														cstmt.setString(10,amtLmtInd );
													//	System.out.println("10:"+amtLmtInd);


														cstmt.setString(11,qtyLimit );
													//	System.out.println("11:"+qtyLimit);

														cstmt.setString(12,cbAmtLmt );
													//	System.out.println("12:"+cbAmtLmt);

														cstmt.setString(13,"" );
													//	System.out.println("13:"+"");

														cstmt.setString(14,"" );
														//System.out.println("14:"+"");

														cstmt.setString(15,"" );
														//System.out.println("15:"+"");

														cstmt.setString(16,"" );
														//System.out.println("16:"+"");

														cstmt.setString(17,"" );
														//System.out.println("17:"+"");

														cstmt.setString(18,"" );
														//System.out.println("18:"+"");

														cstmt.setString(19,"" );
														//System.out.println("19:"+"");

														cstmt.setString(20,"" );
														//System.out.println("20:"+"");


														cstmt.setString(21,user_id);
														//System.out.println("21:");

														cstmt.setString(22,user_id);
														//System.out.println("22:");


														cstmt.setString(23,client_ip_address);
														//System.out.println("23:");

														cstmt.setString(24,facility_id);
														//System.out.println("24:");

														cstmt.setString(25,client_ip_address);
														//System.out.println("25:");

														cstmt.setString(26,facility_id);
													//	System.out.println("26:");
														cstmt.setString(27,splitReqd);//RRRR
														cstmt.setString(28,includeHomeMedication);
														cstmt.registerOutParameter(29,java.sql.Types.VARCHAR);
														cstmt.registerOutParameter(30,java.sql.Types.VARCHAR);
														cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
														cstmt.setString(32,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
														cstmt.setString(33,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
														cstmt.setString(34,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
														cstmt.setString(35,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
														cstmt.setString(36,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
														cstmt.execute();

														str_error_level=cstmt.getString(29);
														str_sysmesage_id=cstmt.getString(30);					
														str_error_text=cstmt.getString(31);
														if(str_error_level==null) str_error_level="";
														if(str_sysmesage_id==null) str_sysmesage_id="";
														if(str_error_text==null) str_error_text="";
														/*System.out.println("str_error_level in process charge based insertion:"+str_error_level);
														System.out.println("str_sysmesage_id in process charge based insertion:"+str_sysmesage_id);
														System.out.println("str_error_text in process charge based insertion:"+str_error_text);*/
														cstmt.close();
														if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
														{
															//System.out.println("*** insertable: false");
															insertable=false;
															break;
														}
														else
														{
															insertable = true;
														}
													} // System.out.println("*** insertable: 1 ");
												}
											}
										}
									//}
									//else if((excludedItems_CB == null || excludedItems_CB.size()<=0 ) && dbExcludedItems_CB!=null && dbExcludedItems_CB.size()>0 && dbServices.size()>0)
									//{
										else if((excludedItemsFD_CB == null || excludedItemsFD_CB.size()<=0 ) && dbExcludedItemsFD_CB!=null && dbExcludedItemsFD_CB.size()>0 && dbServices.size()>0)
										{
											/*System.out.println(" Delecte all the records from Exclusions");
											System.out.println(" Delecte all the records dbServices :"+dbServices);
											System.out.println(" Delecte all the records dbServices.size() :"+dbServices.size());*/

											String itemDel = "";
											/*Delecte all the records from Exclusions */
											for(int i=0;i<dbServicesExVals.size(); i++)
											{
												//System.out.println("i:"+i);
											itemDel = dbServicesExVals.get(i) == null ? "" : (String) dbServicesExVals.get(i);
											//System.out.println(" itemDel :"+itemDel);
											if(!(itemDel.equals("")))
											{
												try
												{
													sqlDelCB="Delete from bl_package_exclusions where EFF_FROM_DATE = to_date(?,'dd/mm/yyyy') and EXCL_SERV_CODE=? and PKG_SERV_CODE=? and PACKAGE_CODE = ? and RATE_CHARGE_IND = 'C' and OPERATING_FACILITY_ID=?";
													//if(pstmt!=null) pstmt=null;
													if(pstmt!=null) pstmt.close();
													pstmt=con.prepareStatement(sqlDelCB);
													pstmt.setString(1,fromDateSer);
													pstmt.setString(2,itemDel);
													pstmt.setString(3,cbServiceCode);
													pstmt.setString(4,packageCode);
													pstmt.setString(5,facility_id);
													//System.out.println("fromDateSer"+fromDateSer+","+"itemDel:"+itemDel+","+"packageCode"+packageCode+","+"facility_id:"+facility_id);
													pstmt.executeUpdate();
													//System.out.println("All from exclusions deleted 6");
												}
												catch(Exception e)
												{
												insertable=false;
												System.err.println("Exception on deletion Change based exclusions 6 :"+e);
												e.printStackTrace();
												}
												finally
												{
												if(pstmt!=null) pstmt.close();
												}
											}
										}
									}
								//}
								else
								{
									//System.out.println("else  itemsForService");
									itemsForService =(ArrayList)excludedItemsFD_CB.get(cbServiceCode);
									//System.out.println("else  itemsForService :"+itemsForService);
									if(itemsForService!=null && itemsForService.size()>0)
									{
										itemGroup				= (ArrayList)itemsForService.get(0);
										//System.out.println("itemGroup:"+itemGroup);
										if(itemGroup.size()>0)
										{
											totRec			= itemGroup.size();
											itemDescGroup			= (ArrayList)itemsForService.get(1);
											//System.out.println("itemDescGroup:"+itemDescGroup);
											qtyLtGroup				= (ArrayList)itemsForService.get(2);
											//System.out.println("qtyLtGroup:"+qtyLtGroup);
											amountLtGroup			= (ArrayList)itemsForService.get(3);
											//System.out.println("amountLtGroup:"+amountLtGroup);
											inExcnGroup				= (ArrayList)itemsForService.get(4);
											//System.out.println("inExcnGroup:"+inExcnGroup);
											split_reqd_list			= (ArrayList)itemsForService.get(5);//Split reqd
											includeHomeMedication_list			= (ArrayList)itemsForService.get(6);
											for(int i=0; i<totRec; i++)
											{
												itemCode	= (String)itemGroup.get(i);
												itemDesc	= (String)itemDescGroup.get(i);
												qtyLimit 	= (String)qtyLtGroup.get(i);
												cbAmtLmt    = (String)amountLtGroup.get(i);
												inExcl		= (String)inExcnGroup.get(i);
												splitReqd	  =(String)split_reqd_list.get(i);//Split reqd
												includeHomeMedication	  =(String)includeHomeMedication_list.get(i);
												//System.out.println("i:"+i);
												if(inExcl.equals("Y"))
													amtLmtInd = "";
												else
													amtLmtInd = "A";

												/*System.out.println("cbServiceCode:"+cbServiceCode);
												System.out.println("itemCode:"+itemCode);
												System.out.println("qtyLimit:"+qtyLimit);
												System.out.println("cbAmtLmt:"+cbAmtLmt);
												System.out.println("inExcl:"+inExcl);*/

												if(dbServicesExVals!=null && dbServicesExVals.contains(itemCode))
												{
													/* compare and modify */

												System.out.println("before calling ispkgexclusionrecordchanged,srvLtSrvCode="+srvLtSrvCode);
												//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - ispkgexclusionrecordchanged
												//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - ispkgexclusionrecordchanged
												sqlcb  ="{ call   blpackage.ispkgexclusionrecordchanged(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?)}";//sarathkumar InclHmeMedi
												//System.out.println("sqlcb :"+sqlcb);
												cstmt = con.prepareCall(sqlcb);
												cstmt.setString(1,facility_id);
												//System.out.println("facility_id :"+facility_id);
												cstmt.setString(2,packageCode);
												//System.out.println("packageCode :"+packageCode);
												cstmt.setString(3,fromDateSer);
												//System.out.println("fromDateSer :"+fromDateSer);
												cstmt.setString(4,cbServiceCode);
												//System.out.println("cbServiceCode :"+cbServiceCode);
												cstmt.setString(5,"S");
												//System.out.println("S :"+"S");
												cstmt.setString(6,"C" );
												//System.out.println("C :"+"C");
												cstmt.setString(7,itemCode);
												//System.out.println("itemCode :"+itemCode);
												cstmt.setString(8,"M");
												//System.out.println("M :"+"M");
												cstmt.setString(9,inExcl );
												//System.out.println("inExcl :"+inExcl);
												cstmt.setString(10,amtLmtInd );
												//System.out.println(" :"+amtLmtInd);
												cstmt.setString(11,qtyLimit);
												//System.out.println("qtyLimit :"+qtyLimit);
												cstmt.setString(12,cbAmtLmt);
												//System.out.println("cbAmtLmt :"+cbAmtLmt);
												cstmt.setString(13,"");
												//System.out.println(" :");
												cstmt.setString(14,"");
												//System.out.println("");
												cstmt.setString(15,"" );
												//System.out.println(" :");
												cstmt.setString(16,"" );
												//System.out.println(" :");
												cstmt.setString(17,"");
												//System.out.println("");
												cstmt.setString(18,"");
												//System.out.println("");
												cstmt.setString(19,"");
												//System.out.println("");
												cstmt.setString(20,"");
												//System.out.println("");
												cstmt.setString(21,splitReqd);//Split reqd - For Validation
												cstmt.setString(22,includeHomeMedication);
													//saraa
												cstmt.registerOutParameter(23,java.sql.Types.VARCHAR);
												//System.out.println("after22 : :");
												cstmt.registerOutParameter(24,java.sql.Types.VARCHAR);
												//System.out.println("after23 : :");
												cstmt.registerOutParameter(25,java.sql.Types.VARCHAR);
												cstmt.registerOutParameter(26,java.sql.Types.VARCHAR);
												//System.out.println("after24 : :");
												cstmt.setString(27,newDate);
												cstmt.setString(28,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
												cstmt.setString(29,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
												cstmt.setString(30,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
												cstmt.setString(31,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
												cstmt.setString(32,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
												cstmt.execute();
												//System.out.println("after execute :");
												recModified=cstmt.getString(23);
												//System.out.println("recModified :: "+recModified);
												str_error_level=cstmt.getString(24);
												str_sysmesage_id=cstmt.getString(25);					
												str_error_text=cstmt.getString(26);
												if(str_error_level==null) str_error_level="";
												if(str_sysmesage_id==null) str_sysmesage_id="";
												if(str_error_text==null) str_error_text="";
												if(recModified == null)		recModified="";
												//System.out.println("recModified:"+recModified);
												//System.out.println("str_error_level in process ispkgexclusionrecordchanged:"+str_error_level);
												//System.out.println("str_sysmesage_id in process ispkgexclusionrecordchanged:"+str_sysmesage_id);
												//System.out.println("str_error_text in process ispkgexclusionrecordchanged:"+str_error_text);
												cstmt.close();
												if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
												{
													insertable=false;
													break;
												}
												else
												{
													insertable = true;
												}
												if(insertable && "Y".equals(recModified))
												{
													//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - updatepackageexclusion
													//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - updatepackageexclusion
													sqlcb  ="{ call   blpackage.updatepackageexclusion(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?)}"; //sarathkumar InclHmeMedi
													//System.out.println("sqlcb :"+sqlcb);
													cstmt = con.prepareCall(sqlcb);
													cstmt.setString(1,facility_id);
													cstmt.setString(2,packageCode);
													cstmt.setString(3,fromDateSer);

													cstmt.setString(4,cbServiceCode);
													//System.out.println("cbServiceCode:"+cbServiceCode);

													cstmt.setString(5,"S");
													//System.out.println("5:S");

													cstmt.setString(6,"C");
													//System.out.println("6: C");

													cstmt.setString(7,itemCode);
													//System.out.println("7:");

													cstmt.setString(8,"M");
													//System.out.println("8:M");

													cstmt.setString(9,inExcl );
													//System.out.println("9:"+factorRate );

													cstmt.setString(10,amtLmtInd );
													//System.out.println("10:"+amtLmtInd);


													cstmt.setString(11,qtyLimit );
													//System.out.println("11:"+qtyLimit);

													cstmt.setString(12,cbAmtLmt );
													//System.out.println("12:"+cbAmtLmt);

													cstmt.setString(13,"" );
													//System.out.println("13:"+"");

													cstmt.setString(14,"" );
													//System.out.println("14:"+"");

													cstmt.setString(15,"" );
													//System.out.println("15:"+"");

													cstmt.setString(16,"" );
													//System.out.println("16:"+"");

													cstmt.setString(17,"" );
													//System.out.println("17:"+"");

													cstmt.setString(18,"" );
													//System.out.println("18:"+"");

													cstmt.setString(19,"" );
													//System.out.println("19:"+"");

													cstmt.setString(20,"" );
													//System.out.println("20:"+"");

													cstmt.setString(21,user_id);
													//System.out.println("21:");

													cstmt.setString(22,client_ip_address);
													//System.out.println("22:"+client_ip_address);

													cstmt.setString(23,facility_id);
													//System.out.println("23:"+facility_id);
													cstmt.setString(24,splitReqd);//RRRR
													cstmt.setString(25,includeHomeMedication);
						
													cstmt.registerOutParameter(26,java.sql.Types.VARCHAR);
													cstmt.registerOutParameter(27,java.sql.Types.VARCHAR);
													cstmt.registerOutParameter(28,java.sql.Types.VARCHAR);
													cstmt.setString(29,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
													cstmt.setString(30,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
													cstmt.setString(31,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
													cstmt.setString(32,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
													cstmt.setString(33,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
													cstmt.execute();

													str_error_level=cstmt.getString(26);
													str_sysmesage_id=cstmt.getString(27);					
													str_error_text=cstmt.getString(28);
													if(str_error_level==null) str_error_level="";
													if(str_sysmesage_id==null) str_sysmesage_id="";
													if(str_error_text==null) str_error_text="";
													//System.out.println("str_error_level in process charge based insertion:"+str_error_level);
													//System.out.println("str_sysmesage_id in process charge based insertion:"+str_sysmesage_id);
													//System.out.println("str_error_text in process charge based insertion:"+str_error_text);
													cstmt.close();
													if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
													{
														insertable=false;
														break;
													}
													else
													{
														insertable = true;
													}
													}
												}
												else  if(insertable)
												{
													/* insert */
													//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - insertpackageexclusion
													//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - insertpackageexclusion
													sqlcb  ="{ call   blpackage.insertpackageexclusion(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; //sarathkumar InclHmeMedi
													//System.out.println("sqlcb :"+sqlcb);
													cstmt = con.prepareCall(sqlcb);
													cstmt.setString(1,facility_id);
													cstmt.setString(2,packageCode);
													cstmt.setString(3,fromDateSer);

													cstmt.setString(4,cbServiceCode);
													//System.out.println("cbServiceCode:"+cbServiceCode);

													cstmt.setString(5,"S");
													//System.out.println("5:S");

													cstmt.setString(6,"C");
													//System.out.println("6: C");

													cstmt.setString(7,itemCode);
													//System.out.println("7:");

													cstmt.setString(8,"M");
													//System.out.println("8:M");

													cstmt.setString(9,inExcl );
													//System.out.println("9:"+factorRate );

													cstmt.setString(10,amtLmtInd);
													//System.out.println("10:"+amtLmtInd);


													cstmt.setString(11,qtyLimit );
													//System.out.println("11:"+qtyLimit);

													cstmt.setString(12,cbAmtLmt );
													//System.out.println("12:"+cbAmtLmt);

													cstmt.setString(13,"" );
													//System.out.println("13:"+"");

													cstmt.setString(14,"" );
													//System.out.println("14:"+"");

													cstmt.setString(15,"" );
													//System.out.println("15:"+"");

													cstmt.setString(16,"" );
													//System.out.println("16:"+"");

													cstmt.setString(17,"" );
													//System.out.println("17:"+"");

													cstmt.setString(18,"" );
													//System.out.println("18:"+"");

													cstmt.setString(19,"" );
													//System.out.println("19:"+"");

													cstmt.setString(20,"" );
													//System.out.println("20:"+"");


													cstmt.setString(21,user_id);
													//System.out.println("21:");

													cstmt.setString(22,user_id);
													//System.out.println("22:");


													cstmt.setString(23,client_ip_address);
													//System.out.println("23:");

													cstmt.setString(24,facility_id);
													//System.out.println("24:");

													cstmt.setString(25,client_ip_address);
													//System.out.println("25:");

													cstmt.setString(26,facility_id);
													//System.out.println("26:");
													cstmt.setString(27,splitReqd);//RRRR
													cstmt.setString(28,includeHomeMedication);
													cstmt.registerOutParameter(29,java.sql.Types.VARCHAR);
													cstmt.registerOutParameter(30,java.sql.Types.VARCHAR);
													cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
													cstmt.setString(32,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
													cstmt.setString(33,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
													cstmt.setString(34,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
													cstmt.setString(35,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
													cstmt.setString(36,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
													cstmt.execute();

													str_error_level=cstmt.getString(29);
													str_sysmesage_id=cstmt.getString(30);					
													str_error_text=cstmt.getString(31);

													if(str_error_level==null) str_error_level="";
													if(str_sysmesage_id==null) str_sysmesage_id="";
													if(str_error_text==null) str_error_text="";
													//System.out.println("str_error_level in process charge based insertion:"+str_error_level);
													//System.out.println("str_sysmesage_id in process charge based insertion:"+str_sysmesage_id);
													//System.out.println("str_error_text in process charge based insertion:"+str_error_text);
													cstmt.close();
													if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
													{
														insertable=false;
														break;
													}
													else
													{
													insertable = true;
													}
												}

											}
										}
										if(dbServicesExVals!=null)
										totRec = dbServicesExVals.size();
										else
										totRec = 0;
										//System.out.println("dbServices.size() :"+dbServices.size())	;
										for(int i=0; i<totRec; i++)
										{
											itemCode	= (String)dbServicesExVals.get(i);
											if(!(itemGroup.contains(itemCode)))
											{
												/* Delete from exclusions */
												try
												{
												sqlDelCB="Delete from bl_package_exclusions where EFF_FROM_DATE = to_date(?,'dd/mm/yyyy') and EXCL_SERV_CODE=? and PKG_SERV_CODE=? and PACKAGE_CODE = ? and RATE_CHARGE_IND = 'C' and OPERATING_FACILITY_ID=?";
												//if(pstmt!=null) pstmt=null;
												if(pstmt!=null) pstmt.close();
												pstmt=con.prepareStatement(sqlDelCB);
												pstmt.setString(1,fromDateSer);
												pstmt.setString(2,itemCode);
												pstmt.setString(3,cbServiceCode);
												pstmt.setString(4,packageCode);
												pstmt.setString(5,facility_id);
												pstmt.executeUpdate();
												//System.out.println("All from exclusions deleted");
												}
												catch(Exception e)
												{
												insertable=false;
												System.err.println("Exception on deletion Change based exclusions 1 :"+e);
												e.printStackTrace();
												}
												}
											}
										}
									}
								}
								}
							}
						}
					}
				}
			}
			}
		}
	}
	catch (Exception e)
	{	insertable=false;
			System.err.println("Exception from Charge based billing service 5541 :"+e);
			e.printStackTrace();
			insertable=false;
	}
/* end Charge Based Modification */


	System.out.println("Before calling Rate Based Insertions:"+insertable+"/"+modifyRateBased);
/* For Rate Based insertions  */
		try
		{  
			System.out.println("------Rate based modify---------");
			if(insertable && modifyRateBased.equals("Y"))
			{  System.out.println("------insertable && modifyRateBased.equals(Y)---------");
				count_del=0;
				count_del_excl=0;
				String insertFlag = "Y";
				String deleteFlag = "Y";
			 /********* Delete Rate  Based records*********start******/
				String fromDateSer = "";
				for(int k=0;k<priceFromDate.size();k++)
				{
					//System.out.println("priceFromDate="+priceFromDate);
					fromDateSer = (String)priceFromDate.get(k);
					//System.out.println("fromDateSer="+fromDateSer);
					insertFlag = "N";
					deleteFlag = "N      ";
					if(includedItems_RB != null && includedItems_RB.containsKey(packageCode) )
					{
						includedItemsFD_RB=(HashMap)includedItems_RB.get(packageCode);
					   if(includedItemsFD_RB != null && includedItemsFD_RB.containsKey(fromDateSer) )
						{
							services=(ArrayList)includedItemsFD_RB.get(fromDateSer);
							insertFlag = "Y";
						}
						else
							insertFlag = "N";
					}

					//System.out.println("services="+services.toString());
					System.out.println("insertFlag 7010="+insertFlag);

					if(dbIncludedItems_RB != null && dbIncludedItems_RB.containsKey(packageCode) ){
						dbIncludedItemsFD_RB =(HashMap)dbIncludedItems_RB.get(packageCode);
						if(dbIncludedItemsFD_RB != null && dbIncludedItemsFD_RB.containsKey(fromDateSer) )
						{
							dbServices=(ArrayList)dbIncludedItemsFD_RB.get(fromDateSer);
							deleteFlag = "Y";
						}
						else
						{
							dbServices = new ArrayList();
							deleteFlag = "N";
						}
					}
					//System.out.println("dbServices="+dbServices.toString());
					System.out.println("deleteFlag 7026="+deleteFlag);

					if(dbServices!=null && dbServices.size()>0 && (services==null || services.size()==0 || insertFlag.equals("N") )){//delete all records.
					//System.out.println("user deleted all records . so delete all records from database");
						try
						{
							/********delete Service Exclusions First*****start******/
							if(deleteFlag.equals("Y")) {
							//if(pstmt!=null) pstmt=null;
							if(pstmt!=null) pstmt.close();
							sqlDelete = "Delete from bl_package_exclusions where EFF_FROM_DATE = to_date(?,'dd/mm/yyyy') and PACKAGE_CODE = ? and RATE_CHARGE_IND = 'R' and OPERATING_FACILITY_ID=?";
							pstmt=con.prepareStatement(sqlDelete);
							pstmt.setString(1,fromDateSer);
							pstmt.setString(2,packageCode);
							pstmt.setString(3,facility_id);
							pstmt.executeUpdate();
							/********delete Service Exclusions First*****end******/
//							if(pstmt!=null) pstmt=null;
if(pstmt!=null) pstmt.close();
							sqlDelete = "Delete from bl_package_dtls where EFF_FROM_DATE = to_date(?,'dd/mm/yyyy') and PACKAGE_CODE = ? and RATE_CHARGE_IND = 'R' and OPERATING_FACILITY_ID=?";
							pstmt=con.prepareStatement(sqlDelete);
							pstmt.setString(1,fromDateSer);
							pstmt.setString(2,packageCode);
							pstmt.setString(3,facility_id);
							pstmt.executeUpdate();
						}  }
						catch(Exception e)
						{
							insertable=false;
							System.err.println("Exception on deletion Change based :"+e);
							e.printStackTrace();
						}
						finally
						{
							if(pstmt!=null) pstmt.close();
						}
					}else{
					//System.out.println("other operations");
					if(dbServices!=null && dbServices.size()>0 &&  services!=null  && services.size()>0){
						if(insertFlag.equals("Y") && deleteFlag.equals("Y") ){

							serviceGroup = (ArrayList)services.get(1);
							//System.out.println("serviceGroup="+serviceGroup.toString());
							sqlDelete = "Delete from bl_package_dtls where EFF_FROM_DATE = to_date(?,'dd/mm/yyyy') and PACKAGE_CODE = ? and PKG_SERV_CODE=? and RATE_CHARGE_IND = 'R' and OPERATING_FACILITY_ID=?";
							try
							{
								//if(pstmt1!=null) pstmt1=null;
								if(pstmt1!=null) pstmt1.close();
								pstmt1=con.prepareStatement("Delete from bl_package_exclusions where EFF_FROM_DATE = to_date(?,'dd/mm/yyyy') and PACKAGE_CODE = ? and PKG_SERV_CODE=? and RATE_CHARGE_IND = 'R' and OPERATING_FACILITY_ID=?");
								//if(pstmt!=null) pstmt=null;
								if(pstmt!=null) pstmt.close();
								pstmt=con.prepareStatement(sqlDelete);
								dbServiceGroup=	(ArrayList)dbServices.get(0);
								for(int i=0; i<dbServiceGroup.size(); i++){//delete only the once deleted by the user
									dbServiceCode =(String)dbServiceGroup.get(i);
									//System.out.println("dbServiceCode="+dbServiceCode);
									if(!serviceGroup.contains(dbServiceCode)){
									//	System.out.println("delete dbServiceCode="+dbServiceCode);
										/********delete Service Exclusions First*****start******/
										count_del_excl++;
										pstmt1.setString(1,fromDateSer);
										pstmt1.setString(2,packageCode);
										pstmt1.setString(3,dbServiceCode);
										pstmt1.setString(4,facility_id);
										pstmt1.addBatch();
										/********delete Service Exclusions First*****end******/
										//System.out.println("delete service code="+dbServiceCode+" from database");
										/** delete db record *** start***/
										count_del++;
										pstmt.setString(1,fromDateSer);
										pstmt.setString(2,packageCode);
										pstmt.setString(3,dbServiceCode);
										pstmt.setString(4,facility_id);
										pstmt.addBatch();
										/** delete db record *** end***/
									}
								}
								//System.out.println("count_del_excl="+count_del_excl+", count_del="+count_del);
								if(count_del_excl>0)
									pstmt1.executeBatch();
								if(count_del>0)
									pstmt.executeBatch();
							}
							catch(Exception e)
							{
								insertable=false;
								System.err.println("Exception on deletion Change based :"+e);
								e.printStackTrace();
							}
							finally
							{
								if(pstmt!=null) pstmt.close();
								if(pstmt1!=null) pstmt1.close();
							}
						}
					}
						if(services!=null && services.size()>0 && insertFlag.equals("Y"))
						{//update and insert
							if(dbServices!=null && dbServices.size()>0)
								dbServiceGroup = (ArrayList)dbServices.get(0);
							else
								dbServiceGroup = new ArrayList();
							typeGroup    =  (ArrayList)services.get(0);
							serviceGroup = (ArrayList)services.get(1);
							catalogGroup = (ArrayList)services.get(3);
							indGroup= (ArrayList)services.get(5);
							factorOrRateGroup= (ArrayList)services.get(6);
							qtyLtGroup= (ArrayList)services.get(7);
							amtLmtIndGroup= (ArrayList)services.get(8);
							amtLmtGroup= (ArrayList)services.get(9);
							//unlimitedGroup= (ArrayList)services.get(10);
							replaceGroup= (ArrayList)services.get(10);
							//refundGroup= (ArrayList)services.get(11);
							replaceSrvGroup= (ArrayList)services.get(11);
							replaceSrv_catGroup= (ArrayList)services.get(13);
							refundGroup= (ArrayList)services.get(15);
							refundAmtGroup= (ArrayList)services.get(16);
							factor_applGroup= (ArrayList)services.get(17);
							auto_refund_list		= (ArrayList)services.get(19);
							roundTo_list			= (ArrayList)services.get(20);
							roundInd_list			= (ArrayList)services.get(21);
							closePkg_list			= (ArrayList)services.get(22);
							split_reqd_list			= (ArrayList)services.get(23);//Split reqd
							includeHomeMedication_list			= (ArrayList)services.get(24);
							dailyLmtChkBxList		 = (ArrayList)services.get(26);//Added V190320-Aravindh/MMS-DM-CRF-0129
							dailyLmtAmtList			 = (ArrayList)services.get(27);//Added V190320-Aravindh/MMS-DM-CRF-0129
							dailyLmtGrossNetList	 = (ArrayList)services.get(28);//Added V190320-Aravindh/MMS-DM-CRF-0129
							dailyLmtIndicatorList	 = (ArrayList)services.get(29);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
							dailyLmtQtyList			 = (ArrayList)services.get(30);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
							serv_grp_limit_ind_list			 = (ArrayList)services.get(31);//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
							/*System.out.println("roundTo_list:"+roundTo_list	);
							System.out.println("amtLmtIndGroup:"+amtLmtIndGroup	);
							System.out.println("auto_refund_list:"+auto_refund_list	);
							System.out.println("roundInd_list:"+roundInd_list	);		*/

							totRec = serviceGroup.size();
							for(int i=0; i<totRec; i++)
							{
								cbServiceCode =(String)serviceGroup.get(i);
								servInd	      =(String)typeGroup.get(i);
								rateChargInd  = "R";
								ordCatlogCode =(String)catalogGroup.get(i);
								factorRateInd =(String)indGroup.get(i);
								factorRate	  =(String)factorOrRateGroup.get(i);
								qtyLimit      =(String)qtyLtGroup.get(i);
								cbAmtLmtInd   =(String)amtLmtIndGroup.get(i);
								cbAmtLmt	  =(String)amtLmtGroup.get(i);
								//cbUnlimited   =(String)unlimitedGroup.get(i);
								replaceableYN =(String)replaceGroup.get(i);
								replServCode  =(String)replaceSrvGroup.get(i);
								replOrder	  =(String)replaceSrv_catGroup.get(i);
								refundYN	  =(String)refundGroup.get(i);
								refundAmt	  =(String)refundAmtGroup.get(i);
								factor_appl	  =(String)factor_applGroup.get(i);
								auto_refund	  =(String)auto_refund_list.get(i);
								roundTo		  =(String)roundTo_list.get(i);
								roundInd	  =(String)roundInd_list.get(i);
								closePakgStat =(String)closePkg_list.get(i);
								splitReqd	  =(String)split_reqd_list.get(i);//Split reqd
								includeHomeMedication	  =(String)includeHomeMedication_list.get(i);
								//Added V190320-Aravindh/MMS-DM-CRF-0129/Starts
								dailyLmtChkBx = (String) dailyLmtChkBxList.get(i);
								dailyLmtAmt = (String) dailyLmtAmtList.get(i);
								dailyLmtGrossNet = (String) dailyLmtGrossNetList.get(i);
								if(null == dailyLmtChkBx || "".equals(dailyLmtChkBx)) {
									dailyLmtChkBx = "N";
								}
								if(null == dailyLmtGrossNet || "".equals(dailyLmtGrossNet)) {
									dailyLmtGrossNet = "G";
								}
								//Added V190320-Aravindh/MMS-DM-CRF-0129/Ends
								dailyLmtIndicator = (String) dailyLmtIndicatorList.get(i);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
								if("*".equals(dailyLmtIndicator)){
									dailyLmtIndicator = "";
								}//Added V190626-Aravindh/MMS-DM-CRF-0129.1
								dailyLmtQty = (String) dailyLmtQtyList.get(i);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
								serv_grp_limit_ind = (String) serv_grp_limit_ind_list.get(i); //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
								//System.out.println("serv_grp_limit_ind 7614="+serv_grp_limit_ind);
								if(dbServiceGroup!=null && dbServiceGroup.size()>0 && dbServiceGroup.contains(cbServiceCode)){
									//chk if update is needed
									//System.out.println("before calling ispkgservicerecordchanged,cbServiceCode="+cbServiceCode);
									//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - ispkgservicerecordchanged
									//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - ispkgservicerecordchanged
									sqlcb  ="{ call   blpackage.ispkgservicerecordchanged(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";//sarathkumar InclHmeMedi
										//System.out.println("sqlcb :"+sqlcb);
									cstmt = con.prepareCall(sqlcb);
									cstmt.setString(1,facility_id);
									cstmt.setString(2,packageCode);
									cstmt.setString(3,fromDateSer);
									//System.out.println("fromDateSer:"+fromDateSer);
									cstmt.setString(4,cbServiceCode);
									//System.out.println("cbServiceCode:"+cbServiceCode);

									cstmt.setString(5,servInd);
									//System.out.println("5 servInd: "+servInd);

									cstmt.setString(6,rateChargInd);
									//System.out.println("6 rateChargInd:"+rateChargInd);

									cstmt.setString(7,ordCatlogCode);
									//System.out.println("7 ordCatlogCode:"+ordCatlogCode);

									cstmt.setString(8,factorRateInd);
									//System.out.println("8 factorRateInd:"+factorRateInd);

									cstmt.setString(9,factorRate );
									//System.out.println("9:"+factorRate );

									cstmt.setString(10,qtyLimit );
									//System.out.println("10 qtyLimit:"+qtyLimit);

									cstmt.setString(11,cbAmtLmt);
									//System.out.println("11 cbAmtLmt:"+cbAmtLmt);

									cstmt.setString(12,cbAmtLmtInd );
									//System.out.println("12 cbAmtLmtInd:"+cbAmtLmtInd);

									cstmt.setString(13,replaceableYN);
									//System.out.println("13 replaceableYN:"+replaceableYN);

									cstmt.setString(14,replServCode );
									//System.out.println("14 replServCode:"+replServCode);

									cstmt.setString(15,replOrder );
									//System.out.println("15 replOrder:"+replOrder);

									cstmt.setString(16,refundYN );
									//System.out.println("16 refundYN:"+refundYN);

									cstmt.setString(17,refundAmt);
									//System.out.println("17:"+refundAmt );

									cstmt.setString(18,auto_refund);
									//System.out.println("18:"+auto_refund );

									cstmt.setString(19,closePakgStat);
									//System.out.println("19:"+closePakgStat );

									cstmt.setString(20,roundTo);
									//System.out.println("20:"+roundTo );

									cstmt.setString(21,roundInd);
									//System.out.println("21:"+roundInd );

									cstmt.setString(22,factor_appl);
									//System.out.println("22:"+factor_appl );
									cstmt.setString(23, splitReqd);//Split reqd - For Validation
									cstmt.setString(24, includeHomeMedication);
									cstmt.registerOutParameter(25,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(26,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(27,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(28,java.sql.Types.VARCHAR);
									cstmt.setString(29, dailyLmtChkBx);//Added V190320-Aravindh/MMS-DM-CRF-0129
									cstmt.setString(30, dailyLmtAmt);//Added V190320-Aravindh/MMS-DM-CRF-0129
									cstmt.setString(31, dailyLmtGrossNet);//Added V190320-Aravindh/MMS-DM-CRF-0129
									cstmt.setString(32, dailyLmtIndicator);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
									cstmt.setString(33, dailyLmtQty);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
									cstmt.execute();

									recModified=cstmt.getString(25);
									str_error_level=cstmt.getString(26);
									str_sysmesage_id=cstmt.getString(27);					
									str_error_text=cstmt.getString(28);
									if(recModified == null) recModified = "N";
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									cstmt.close();
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insertable=false;
										break;
									}
									else
									{
										insertable = true;
									}
									if(insertable && "Y".equals(recModified)){		
										//System.out.println("calling :updatepackageservice ,cbServiceCode ="+cbServiceCode);
										//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - ispkgservicerecordchanged
										//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - ispkgservicerecordchanged
										sqlcb  ="{ call   blpackage.updatepackageservice(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?)}";//sarathkumar InclHmeMedi
										//System.out.println("sqlcb :"+sqlcb);
										cstmt = con.prepareCall(sqlcb);
										cstmt.setString(1,facility_id);
										cstmt.setString(2,packageCode);
										cstmt.setString(3,fromDateSer);
										//System.out.println("fromDateSer:"+fromDateSer);

										cstmt.setString(4,cbServiceCode);
										//System.out.println("cbServiceCode:"+cbServiceCode);

										cstmt.setString(5,servInd);
										//System.out.println("5 servInd: "+servInd);

										cstmt.setString(6,rateChargInd);
										//System.out.println("6 rateChargInd:"+rateChargInd);

										cstmt.setString(7,ordCatlogCode);
										//System.out.println("7 ordCatlogCode:"+ordCatlogCode);

										cstmt.setString(8,factorRateInd);
										//System.out.println("8 factorRateInd:"+factorRateInd);

										cstmt.setString(9,factorRate );
										//System.out.println("9:"+factorRate );

										cstmt.setString(10,qtyLimit );
										//System.out.println("10 qtyLimit:"+qtyLimit);

										cstmt.setString(11,cbAmtLmt);
										//System.out.println("11 cbAmtLmt:"+cbAmtLmt);

										cstmt.setString(12,cbAmtLmtInd );
										//System.out.println("12 cbAmtLmtInd:"+cbAmtLmtInd);

										cstmt.setString(13,replaceableYN);
										//System.out.println("13 replaceableYN:"+replaceableYN);

										cstmt.setString(14,replServCode );
										//System.out.println("14 replServCode:"+replServCode);

										cstmt.setString(15,replOrder );
										//System.out.println("15 replOrder:"+replOrder);

										cstmt.setString(16,refundYN );
										//System.out.println("16 refundYN:"+refundYN);

										cstmt.setString(17,refundAmt);
										//System.out.println("17:"+refundAmt );

										cstmt.setString(18,auto_refund);
										//System.out.println("18:"+auto_refund );

										cstmt.setString(19,closePakgStat);
										//System.out.println("19:"+closePakgStat );

										cstmt.setString(20,roundTo);
										//System.out.println("20:"+roundTo );

										cstmt.setString(21,roundInd);
									//	System.out.println("21:"+roundInd );

										cstmt.setString(22,factor_appl);
										//System.out.println("22:"+factor_appl );
										cstmt.setString(23,user_id);//sysdate
										cstmt.setString(24,client_ip_address);
										cstmt.setString(25,facility_id);
										cstmt.setString(26,splitReqd);//RRRR
										cstmt.setString(27,includeHomeMedication);
										cstmt.registerOutParameter(28,java.sql.Types.VARCHAR);
										cstmt.registerOutParameter(29,java.sql.Types.VARCHAR);
										cstmt.registerOutParameter(30,java.sql.Types.VARCHAR);
										cstmt.setString(31, dailyLmtChkBx);//Added V190320-Aravindh/MMS-DM-CRF-0129
										cstmt.setString(32, dailyLmtAmt);//Added V190320-Aravindh/MMS-DM-CRF-0129
										cstmt.setString(33, dailyLmtGrossNet);//Added V190320-Aravindh/MMS-DM-CRF-0129
										cstmt.setString(34, dailyLmtIndicator);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
										cstmt.setString(35, dailyLmtQty);///Added V190626-Aravindh/MMS-DM-CRF-0129.1
										cstmt.execute();

										str_error_level=cstmt.getString(28);
										str_sysmesage_id=cstmt.getString(29);					
										str_error_text=cstmt.getString(30);

										if(str_error_level==null) str_error_level="";
										if(str_sysmesage_id==null) str_sysmesage_id="";
										if(str_error_text==null) str_error_text="";
										/*System.out.println("str_error_level in process rate based insertion:"+str_error_level);
										System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
										System.out.println("str_error_text in process rate based insertion:"+str_error_text);*/
										cstmt.close();
										if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
										{
											insertable=false;
											break;
										}
										else
										{
											insertable = true;
										}
									}
								}
								else if(!cbServiceCode.equals("")){//insert
										//System.out.println("calling :insertpackageservice,cbServiceCode="+cbServiceCode);
									//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - insertpackageservice
									//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - insertpackageservice
									sqlcb  ="{ call   blpackage.insertpackageservice(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";//sarathkumar InclHmeMedi
									//System.out.println("sqlcb :"+sqlcb);
									cstmt = con.prepareCall(sqlcb);
									cstmt.setString(1,facility_id);
									cstmt.setString(2,packageCode);
									cstmt.setString(3,fromDateSer);
									//System.out.println("fromDateSer:"+fromDateSer);

									cstmt.setString(4,cbServiceCode);
									//System.out.println("cbServiceCode:"+cbServiceCode);

									cstmt.setString(5,servInd);
									//System.out.println("5 servInd: "+servInd);

									cstmt.setString(6,rateChargInd);
									//System.out.println("6 rateChargInd:"+rateChargInd);

									cstmt.setString(7,ordCatlogCode);
									//System.out.println("7 ordCatlogCode:"+ordCatlogCode);

									cstmt.setString(8,factorRateInd);
									//System.out.println("8 factorRateInd:"+factorRateInd);

									cstmt.setString(9,factorRate );
									//System.out.println("9:"+factorRate );

									cstmt.setString(10,qtyLimit );
									//System.out.println("10 qtyLimit:"+qtyLimit);

									cstmt.setString(11,cbAmtLmt);
									//System.out.println("11 cbAmtLmt:"+cbAmtLmt);

									cstmt.setString(12,cbAmtLmtInd );
									//System.out.println("12 cbAmtLmtInd:"+cbAmtLmtInd);

									cstmt.setString(13,replaceableYN);
									//System.out.println("13 replaceableYN:"+replaceableYN);

									cstmt.setString(14,replServCode );
									//System.out.println("14 replServCode:"+replServCode);

									cstmt.setString(15,replOrder );
									//System.out.println("15 replOrder:"+replOrder);

									cstmt.setString(16,refundYN );
									//System.out.println("16 refundYN:"+refundYN);

									cstmt.setString(17,refundAmt);
									//System.out.println("17:"+refundAmt );

									cstmt.setString(18,auto_refund);
									//System.out.println("18:"+auto_refund );

									cstmt.setString(19,closePakgStat);
									//System.out.println("19:"+closePakgStat );

									cstmt.setString(20,roundTo);
									//System.out.println("20:"+roundTo );

									cstmt.setString(21,roundInd);
									//System.out.println("21:"+roundInd );

									cstmt.setString(22,factor_appl);
									//System.out.println("22:"+factor_appl );

									cstmt.setString(23,user_id);
									//System.out.println("23:");

									cstmt.setString(24,user_id);
									//System.out.println("24:");

									cstmt.setString(25,client_ip_address);
									//System.out.println("25:");

									cstmt.setString(26,facility_id);
									//System.out.println("26:");

									cstmt.setString(27,client_ip_address);
									//System.out.println("27:");

									cstmt.setString(28,facility_id);
									//System.out.println("28:");

									cstmt.setString(29,splitReqd);//RRRR
									cstmt.setString(30,includeHomeMedication);
									cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(32,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(33,java.sql.Types.VARCHAR);
									cstmt.setString(34,dailyLmtChkBx);//Added V190320-Aravindh/MMS-DM-CRF-0129
									cstmt.setString(35,dailyLmtAmt);//Added V190320-Aravindh/MMS-DM-CRF-0129
									cstmt.setString(36,dailyLmtGrossNet);//Added V190320-Aravindh/MMS-DM-CRF-0129
									cstmt.setString(37,dailyLmtIndicator);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
									cstmt.setString(38,dailyLmtQty);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
									cstmt.setString(39,serv_grp_limit_ind);//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
									cstmt.execute();

									str_error_level=cstmt.getString(31);
									str_sysmesage_id=cstmt.getString(32);					
									str_error_text=cstmt.getString(33);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									/*System.out.println("str_error_level in process rate based insertion:"+str_error_level);
									System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
									System.out.println("str_error_text in process rate based insertion:"+str_error_text);*/
									cstmt.close();
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insertable=false;
										break;
									}
									else
									{
										insertable = true;
									}
								}//insert
							}
								}

								else if(!cbServiceCode.equals("")	&&  insertFlag.equals("Y")){//insert
									//	System.out.println("calling :insertpackageservice,cbServiceCode="+cbServiceCode);
									//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - insertpackageservice
									//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - insertpackageservice
									sqlcb  ="{ call   blpackage.insertpackageservice(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";//sarathkumar InclHmeMedi
									cstmt = con.prepareCall(sqlcb);
									cstmt.setString(1,facility_id);
									cstmt.setString(2,packageCode);
									cstmt.setString(3,fromDateSer);
									//System.out.println("fromDateSer:"+fromDateSer);

									cstmt.setString(4,cbServiceCode);
									//System.out.println("cbServiceCode:"+cbServiceCode);

									cstmt.setString(5,servInd);
									//System.out.println("5 servInd: "+servInd);

									cstmt.setString(6,rateChargInd);
									//System.out.println("6 rateChargInd:"+rateChargInd);

									cstmt.setString(7,ordCatlogCode);
									//System.out.println("7 ordCatlogCode:"+ordCatlogCode);

									cstmt.setString(8,factorRateInd);
									//System.out.println("8 factorRateInd:"+factorRateInd);

									cstmt.setString(9,factorRate );
									//System.out.println("9:"+factorRate );

									cstmt.setString(10,qtyLimit );
									//System.out.println("10 qtyLimit:"+qtyLimit);

									cstmt.setString(11,cbAmtLmt);
									//System.out.println("11 cbAmtLmt:"+cbAmtLmt);

									cstmt.setString(12,cbAmtLmtInd );
									//System.out.println("12 cbAmtLmtInd:"+cbAmtLmtInd);

									cstmt.setString(13,replaceableYN);
									//System.out.println("13 replaceableYN:"+replaceableYN);

									cstmt.setString(14,replServCode );
									//System.out.println("14 replServCode:"+replServCode);

									cstmt.setString(15,replOrder );
									//System.out.println("15 replOrder:"+replOrder);

									cstmt.setString(16,refundYN );
									//System.out.println("16 refundYN:"+refundYN);

									cstmt.setString(17,refundAmt);
									//System.out.println("17:"+refundAmt );

									cstmt.setString(18,auto_refund);
									//System.out.println("18:"+auto_refund );

									cstmt.setString(19,closePakgStat);
									//System.out.println("19:"+closePakgStat );

									cstmt.setString(20,roundTo);
									//System.out.println("20:"+roundTo );

									cstmt.setString(21,roundInd);
									//System.out.println("21:"+roundInd );

									cstmt.setString(22,factor_appl);
									//System.out.println("22:"+factor_appl );

									cstmt.setString(23,user_id);
									//System.out.println("23:");

									cstmt.setString(24,user_id);
									//System.out.println("24:");

									cstmt.setString(25,client_ip_address);
									//System.out.println("25:");

									cstmt.setString(26,facility_id);
									//System.out.println("26:");

									cstmt.setString(27,client_ip_address);
									//System.out.println("27:");

									cstmt.setString(28,facility_id);
									//System.out.println("28:");
									cstmt.setString(29,splitReqd);//RRRR
									cstmt.setString(30,includeHomeMedication);
									cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(32,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(33,java.sql.Types.VARCHAR);
									cstmt.setString(34,dailyLmtChkBx);//Added V190320-Aravindh/MMS-DM-CRF-0129
									cstmt.setString(35,dailyLmtAmt);//Added V190320-Aravindh/MMS-DM-CRF-0129
									cstmt.setString(36,dailyLmtGrossNet);//Added V190320-Aravindh/MMS-DM-CRF-0129
									cstmt.setString(37,dailyLmtIndicator);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
									cstmt.setString(38,dailyLmtQty);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
									cstmt.setString(39,serv_grp_limit_ind);//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
									cstmt.execute();

									str_error_level=cstmt.getString(31);
									str_sysmesage_id=cstmt.getString(32);					
									str_error_text=cstmt.getString(33);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									/*System.out.println("str_error_level in process rate based insertion:"+str_error_level);
									System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
									System.out.println("str_error_text in process rate based insertion:"+str_error_text);*/
									cstmt.close();
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insertable=false;
										break;
									}
									else
									{
										insertable = true;
									}
								}//insert
							}
						}
					}

		}
		catch (Exception e)
		{
			System.err.println("Exception from rate based billing service2 :"+e);
			e.printStackTrace();
			insertable=false;
		}
/*Rate Based Service Limits*/
System.out.println("Before calling Rate Based Service Limits/modifyRateSrvLimits:"+insertable+"/"+modifyRateSrvLimits);
	try
		{
			if(insertable && modifyRateSrvLimits.equals("Y"))
			{
				String fromDateSer ="";
				String insertFlag = "Y";
				count_del=0;
				/*System.out.println("4982  packageCode : "+packageCode);
				System.out.println("4982  priceFromDate : "+priceFromDate);
				System.out.println("4983  includedItemsFD_RB : "+includedItemsFD_RB);
				System.out.println("4984  includedItems_RB : "+includedItems_RB);
				System.out.println("4984  includedItems_RB.get(packageCode) : "+includedItems_RB.get(packageCode));
				System.out.println("4984  dbIncludedItems_RB : "+dbIncludedItems_RB);
				System.out.println("4984  dbIncludedItems_RB.get(packageCode) : "+dbIncludedItems_RB.get(packageCode));*/

				if(includedItems_RB != null && includedItems_RB.containsKey(packageCode) )
					includedItemsFD_RB=(HashMap)includedItems_RB.get(packageCode);
				//System.out.println("4987  includedItemsFD_RB : "+includedItemsFD_RB);

				for(int k=0;k<priceFromDate.size();k++)
				{
					insertFlag = "Y";
					fromDateSer = (String)priceFromDate.get(k);
					//System.out.println("fromDateSer:"+fromDateSer);
					//System.out.println("excludedItems_RB:"+excludedItems_RB);
					//System.out.println("includedItemsFD_RB:"+includedItemsFD_RB);
					//if(services!=null) services.clear();
					//if(serviceGroup!=null) serviceGroup.clear();
					if(includedItemsFD_RB != null && includedItemsFD_RB.containsKey(fromDateSer) )
					{
						services=(ArrayList)includedItemsFD_RB.get(fromDateSer);
						serviceGroup = (ArrayList)services.get(1);
						//Added By Rajesh V
						typeGroup    = (ArrayList)services.get(0);
						//Added By Rajesh V						
						insertFlag = "Y";
						//System.out.println("services inside :"+services);
						//System.out.println("serviceGroup inside:"+serviceGroup);
					}
					else
						insertFlag = "N";
//System.out.println("services:"+services);
//System.out.println("serviceGroup:"+serviceGroup);

					/*Added by Rajesh V GHL 1153*/
					/*Reason
					 * It was not not clearing for the subsequent periods.
					 */
					excludedItemsFD_RB = new HashMap();
					if(excludedItems_RB!=null && excludedItems_RB.size()>0 && excludedItems_RB.containsKey(fromDateSer) )
					{
						//System.out.println("inside");
						excludedItemsFD_RB = (HashMap)excludedItems_RB.get(fromDateSer);
						//System.out.println("excludedItemsFD_RB:"+excludedItemsFD_RB);
					}
					//System.out.println("serviceGroup:"+serviceGroup);

			 		for(int j=0; j<serviceGroup.size(); j++)
					{
						//System.out.println("Inside for loop");
						cbServiceCode = (String)serviceGroup.get(j);
						servInd		 = (String)typeGroup.get(j);
						//System.out.println("Rate Based exclusions cbServiceCode:"+cbServiceCode);
						//System.out.println("Rate Based exclusions servInd:"+servInd);
						totRec = 0;
						rb_excl_services=new ArrayList();
						db_rb_excl_services=new ArrayList();
						if(excludedItemsFD_RB!=null && excludedItemsFD_RB.size()>0 && excludedItemsFD_RB.containsKey(cbServiceCode) )
						{
								rb_excl_services=(ArrayList)excludedItemsFD_RB.get(cbServiceCode);
						}
						//System.out.println("rb_excl_services="+rb_excl_services.toString());
						if(dbExcludedItems_RB != null && dbExcludedItems_RB.containsKey(fromDateSer) ){
								dbExcludedItemsFD_RB=(HashMap)dbExcludedItems_RB.get(fromDateSer);
						if(dbExcludedItemsFD_RB != null && dbExcludedItemsFD_RB.containsKey(cbServiceCode) ){
								db_rb_excl_services=(ArrayList)dbExcludedItemsFD_RB.get(cbServiceCode);
								}
							}

								//System.out.println("db_rb_excl_services="+db_rb_excl_services.toString());

							 if(db_rb_excl_services!=null && db_rb_excl_services.size()>0 && (rb_excl_services==null || rb_excl_services.size()==0)){//delete all records.
								//System.out.println("Service Limits,user deleted all records . so delete all records from database of parent_Serv_code="+cbServiceCode);
							try
							{
								//if(pstmt!=null) pstmt=null;
								if(pstmt!=null) pstmt.close();
								sqlDelete = "Delete from bl_package_exclusions where EFF_FROM_DATE = to_date(?,'dd/mm/yyyy') and PACKAGE_CODE = ? and PKG_SERV_CODE=? and RATE_CHARGE_IND = 'R' and OPERATING_FACILITY_ID=?";
								pstmt=con.prepareStatement(sqlDelete);
								pstmt.setString(1,fromDateSer);
								pstmt.setString(2,packageCode);
								pstmt.setString(3,cbServiceCode);
								pstmt.setString(4,facility_id);
								pstmt.executeUpdate();
							}
							catch(Exception e)
							{	insertable=false;
								System.err.println("Exception on deletion Change based :"+e);
								e.printStackTrace();
							}
							finally
							{
								if(pstmt!=null) pstmt.close();
							}
						}else{
							//System.out.println("other operations");
							if(db_rb_excl_services!=null && db_rb_excl_services.size()>0 &&  rb_excl_services!=null && rb_excl_services.size()>0){
									rb_excl_serviceGroup = (ArrayList)rb_excl_services.get(1);
									db_rb_excl_serviceGroup = (ArrayList)db_rb_excl_services.get(0);
									//System.out.println("rb_excl_serviceGroup="+rb_excl_serviceGroup.toString());
									//System.out.println("db_rb_excl_serviceGroup="+db_rb_excl_serviceGroup.toString());
									try
									{
										//if(pstmt!=null) pstmt=null;
										if(pstmt!=null) pstmt.close();
										sqlDelete = "Delete from bl_package_exclusions where  EFF_FROM_DATE = to_date(?,'dd/mm/yyyy') and PACKAGE_CODE = ? and PKG_SERV_CODE=? and EXCL_SERV_CODE= ? and RATE_CHARGE_IND = 'R' and OPERATING_FACILITY_ID=?";
										pstmt=con.prepareStatement(sqlDelete);
										for(int i=0; i<db_rb_excl_serviceGroup.size(); i++){//delete only the once deleted by the user
											db_rb_excl_serviceCode =(String)db_rb_excl_serviceGroup.get(i);
											//System.out.println("db_rb_excl_serviceCode="+db_rb_excl_serviceCode);
											if(!rb_excl_serviceGroup.contains(db_rb_excl_serviceCode)){
												//System.out.println(" parent_serv_code="+cbServiceCode);
												//System.out.println("delete excl_serv_code="+db_rb_excl_serviceCode+" from database");
												/** delete db record *** start***/
												count_del++;
												pstmt.setString(1,fromDateSer);
												pstmt.setString(2,packageCode);
												pstmt.setString(3,cbServiceCode);
												pstmt.setString(4,db_rb_excl_serviceCode);
												pstmt.setString(5,facility_id);
												pstmt.addBatch();
												/** delete db record *** end***/
											}
										}
										//System.out.println("count_del="+count_del);
										if(count_del>0)
											pstmt.executeBatch();
									}
									catch(Exception e)
									{	insertable=false;
										System.err.println("Exception on deletion Rate based  Exclusions:"+e);
										e.printStackTrace();
									}
									finally
									{
										if(pstmt!=null) pstmt.close();
									}
								}
								if(rb_excl_services!=null && rb_excl_services.size()>0)
								{//update and insert
									if(db_rb_excl_services!=null && db_rb_excl_services.size()>0)
										dbSrvLtSrvGroup    =  (ArrayList)db_rb_excl_services.get(0);
										srvLtTypeGroup    =  (ArrayList)rb_excl_services.get(0);
										srvLtSrvGroup = (ArrayList)rb_excl_services.get(1);
										exludeSrvGroup = (ArrayList)rb_excl_services.get(3);
										qtyLtGroup= (ArrayList)rb_excl_services.get(4);
										amountLtGroup= (ArrayList)rb_excl_services.get(5);
										srvLmtFactorApplGroup= (ArrayList)rb_excl_services.get(6);
										amt_limit_ind_list		= (ArrayList)rb_excl_services.get(7);
										replaceGroup		= (ArrayList)rb_excl_services.get(8);
										replaceSrvGroup	= (ArrayList)rb_excl_services.get(9);
										refundGroup		= (ArrayList)rb_excl_services.get(10);
										refundAmtGroup		= (ArrayList)rb_excl_services.get(11);
										auto_refund_list		= (ArrayList)rb_excl_services.get(12);
										roundTo_list		= (ArrayList)rb_excl_services.get(13);
										roundInd_list		= (ArrayList)rb_excl_services.get(14);
										split_reqd_list			= (ArrayList)rb_excl_services.get(16);//Split reqd
										includeHomeMedication_list			= (ArrayList)rb_excl_services.get(17); //sarathkumar InclHmeMedi
										dailyLmtChkBxList		 = (ArrayList)rb_excl_services.get(19);//Added V190320-Aravindh/MMS-DM-CRF-0129
										dailyLmtAmtList			 = (ArrayList)rb_excl_services.get(20);//Added V190320-Aravindh/MMS-DM-CRF-0129
										dailyLmtGrossNetList	 = (ArrayList)rb_excl_services.get(21);//Added V190320-Aravindh/MMS-DM-CRF-0129
										dailyLmtIndicatorList	 = (ArrayList)rb_excl_services.get(22);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
										dailyLmtQtyList			 = (ArrayList)rb_excl_services.get(23);//Added V190626-Aravindh/MMS-DM-CRF-0129.1

										totRec = srvLtTypeGroup.size();
										//System.out.println("totRec="+totRec);
										for(int i=0; i<totRec; i++)
										{
										servIndLmt 	= (String)srvLtTypeGroup.get(i);
										exludeSrv	= (String)exludeSrvGroup.get(i);
										srvLtSrvCode= (String)srvLtSrvGroup.get(i);
										qtyLimit 	= (String)qtyLtGroup.get(i);
										cbAmtLmt    = (String)amountLtGroup.get(i);
										srvLmtFactorAppl    = (String)srvLmtFactorApplGroup.get(i);
										amt_limit_ind	= (String)amt_limit_ind_list.get(i);
										replaceableYN= (String)replaceGroup.get(i);
										replServCode= (String)replaceSrvGroup.get(i);
										refundYN	= (String)refundGroup.get(i);
										refundAmt	= (String)refundAmtGroup.get(i);
										auto_refund= (String)auto_refund_list.get(i);
										roundTo		= (String)roundTo_list.get(i);
										roundInd		= (String)roundInd_list.get(i);
										splitReqd	  =(String)split_reqd_list.get(i);//Split reqd
										includeHomeMedication	  =(String)includeHomeMedication_list.get(i);
										//Added V190320-Aravindh/MMS-DM-CRF-0129/Starts
										dailyLmtChkBx = (String) dailyLmtChkBxList.get(i);
										dailyLmtAmt = (String) dailyLmtAmtList.get(i);
										dailyLmtGrossNet = (String) dailyLmtGrossNetList.get(i);
										if(null == dailyLmtChkBx || "".equals(dailyLmtChkBx)) {
											dailyLmtChkBx = "N";
										}
										if(null == dailyLmtGrossNet || "".equals(dailyLmtGrossNet)) {
											dailyLmtGrossNet = "G";
										}
										//Added V190320-Aravindh/MMS-DM-CRF-0129/Ends
										dailyLmtIndicator = (String) dailyLmtIndicatorList.get(i);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
										if("*".equals(dailyLmtIndicator)){
											dailyLmtIndicator = "";
										}//Added V190626-Aravindh/MMS-DM-CRF-0129.1
										dailyLmtQty = (String) dailyLmtQtyList.get(i);//Added V190626-Aravindh/MMS-DM-CRF-0129.1

										if(dbSrvLtSrvGroup!=null && dbSrvLtSrvGroup.size()>0 &&  dbSrvLtSrvGroup.contains(srvLtSrvCode) && !("").equals(recModified)){
											//chk if update is needed
											//System.out.println("before calling ispkgexclusionrecordchanged,srvLtSrvCode="+srvLtSrvCode);
											//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - ispkgexclusionrecordchanged
											//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - ispkgexclusionrecordchanged
											sqlcb  ="{ call   blpackage.ispkgexclusionrecordchanged(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?)}";//sarathkumar InclHmeMedi
											//System.out.println("sqlcb :"+sqlcb);
											cstmt = con.prepareCall(sqlcb);
											cstmt.setString(1,facility_id);
											cstmt.setString(2,packageCode);
											cstmt.setString(3,fromDateSer);
											cstmt.setString(4,cbServiceCode);
											cstmt.setString(5,servInd);
											cstmt.setString(6,"R" );
											cstmt.setString(7,srvLtSrvCode);
											cstmt.setString(8,servIndLmt);
											cstmt.setString(9,exludeSrv);
											cstmt.setString(10,amt_limit_ind );
											cstmt.setString(11,qtyLimit );
											cstmt.setString(12,cbAmtLmt );

											cstmt.setString(13,replaceableYN);
											cstmt.setString(14,replServCode );
											cstmt.setString(15,refundYN );
											cstmt.setString(16,refundAmt );
											cstmt.setString(17,auto_refund );
											cstmt.setString(18,roundTo );
											cstmt.setString(19,roundInd);
											cstmt.setString(20,srvLmtFactorAppl);
											cstmt.setString(21, splitReqd);//Split reqd For Validation
											cstmt.setString(22, includeHomeMedication);
											//sarath
											cstmt.registerOutParameter(23,java.sql.Types.VARCHAR);
											cstmt.registerOutParameter(24,java.sql.Types.VARCHAR);
											cstmt.registerOutParameter(25,java.sql.Types.VARCHAR);
											cstmt.registerOutParameter(26,java.sql.Types.VARCHAR);
											cstmt.setString(27, newDate);
											cstmt.setString(28,dailyLmtChkBx);//Added V190320-Aravindh/MMS-DM-CRF-0129
											cstmt.setString(29,dailyLmtAmt);//Added V190320-Aravindh/MMS-DM-CRF-0129
											cstmt.setString(30,dailyLmtGrossNet);//Added V190320-Aravindh/MMS-DM-CRF-0129
											cstmt.setString(31,dailyLmtIndicator);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
											cstmt.setString(32,dailyLmtQty);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
											cstmt.execute();					
											
											recModified=cstmt.getString(23);
											str_error_level=cstmt.getString(24);
											str_sysmesage_id=cstmt.getString(25);					
											str_error_text=cstmt.getString(26);
											if(str_error_level==null) str_error_level="";
											if(str_sysmesage_id==null) str_sysmesage_id="";
											if(str_error_text==null) str_error_text="";
											if(recModified == null)		recModified="";
											//System.out.println("recModified:"+recModified);
											//System.out.println("str_error_level in process rate based ispkgexclusionrecordchanged:"+str_error_level);
											//System.out.println("str_sysmesage_id in process rate based ispkgexclusionrecordchanged:"+str_sysmesage_id);
											//System.out.println("str_error_text in process rate based ispkgexclusionrecordchanged:"+str_error_text);
											cstmt.close();
											if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
											{
												insertable=false;
												break;
											}
											else
											{
												insertable = true;
											}
											if(insertable && "Y".equals(recModified)){		
												//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - updatepackageexclusion
												//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - updatepackageexclusion
												sqlcb  ="{ call   blpackage.updatepackageexclusion(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?)}"; //sarathkumar InclHmeMedi
												//System.out.println("sqlcb :"+sqlcb);
												cstmt = con.prepareCall(sqlcb);
												cstmt.setString(1,facility_id);
												cstmt.setString(2,packageCode);
												cstmt.setString(3,fromDateSer);
												cstmt.setString(4,cbServiceCode);
												//System.out.println("cbServiceCode:"+cbServiceCode);
												//System.out.println("srvLtSrvCode:"+srvLtSrvCode);
												cstmt.setString(5,servInd);
												//System.out.println("5 servInd:"+servInd);
												cstmt.setString(6,"R");
												//System.out.println("6:R");
												cstmt.setString(7,srvLtSrvCode);
												//System.out.println("7: srvLtSrvCode:"+srvLtSrvCode);
												cstmt.setString(8,servIndLmt);
												//System.out.println("8 servIndLmt: "+servIndLmt);
												cstmt.setString(9,exludeSrv );
												//System.out.println("9:"+exludeSrv );
												cstmt.setString(10,amt_limit_ind );
												//System.out.println("10:"+amt_limit_ind);
												cstmt.setString(11,qtyLimit );
												//System.out.println("11:"+qtyLimit);
												cstmt.setString(12,cbAmtLmt );
												//System.out.println("12:"+cbAmtLmt);
												cstmt.setString(13,replaceableYN );
												//System.out.println("13:"+replaceableYN);
												cstmt.setString(14,replServCode);
												//System.out.println("14:"+replServCode);
												cstmt.setString(15,refundYN );
												//System.out.println("15:"+refundYN);

												cstmt.setString(16,refundAmt);
												//System.out.println("16:"+refundAmt);

												cstmt.setString(17,auto_refund );
												//System.out.println("17:"+auto_refund);
												cstmt.setString(18,roundTo );
												//System.out.println("18:"+roundTo);

												cstmt.setString(19,roundInd);
												//System.out.println("19:"+roundInd);

												cstmt.setString(20,srvLmtFactorAppl );
												//System.out.println("20:"+srvLmtFactorAppl);
												cstmt.setString(21,user_id);
												//System.out.println("21:");

												cstmt.setString(22,client_ip_address);
												//System.out.println("22:"+client_ip_address);

												cstmt.setString(23,facility_id);
												//System.out.println("23:"+facility_id);
												cstmt.setString(24,splitReqd);//RRRR
												cstmt.setString(25,includeHomeMedication);
												cstmt.registerOutParameter(26,java.sql.Types.VARCHAR);
												cstmt.registerOutParameter(27,java.sql.Types.VARCHAR);
												cstmt.registerOutParameter(28,java.sql.Types.VARCHAR);
												cstmt.setString(29,dailyLmtChkBx);//Added V190320-Aravindh/MMS-DM-CRF-0129
												cstmt.setString(30,dailyLmtAmt);//Added V190320-Aravindh/MMS-DM-CRF-0129
												cstmt.setString(31,dailyLmtGrossNet);//Added V190320-Aravindh/MMS-DM-CRF-0129
												cstmt.setString(32,dailyLmtIndicator);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
												cstmt.setString(33,dailyLmtQty);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
												cstmt.execute();

												str_error_level=cstmt.getString(26);
												str_sysmesage_id=cstmt.getString(27);					
												str_error_text=cstmt.getString(28);
												if(str_error_level==null) str_error_level="";
												if(str_sysmesage_id==null) str_sysmesage_id="";
												if(str_error_text==null) str_error_text="";
												//System.out.println("str_error_level in process rate based insertion:"+str_error_level);
												//System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
												//System.out.println("str_error_text in process rate based insertion:"+str_error_text);
												cstmt.close();
												if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
												{
													insertable=false;
													break;
												}
												else
												{
													insertable = true;
												}
											}
											/* Added By Vijay A.P. for GHL-SCF-1086 */
											
											else if(("").equals(recModified))
											{
												//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - insertpackageexclusion
												//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - insertpackageexclusion
												sqlcb  ="{ call   blpackage.insertpackageexclusion(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; //sarathkumar InclHmeMedi
												//System.out.println("sqlcb :"+sqlcb);
												cstmt = con.prepareCall(sqlcb);
												cstmt.setString(1,facility_id);
												cstmt.setString(2,packageCode);
												cstmt.setString(3,fromDateSer);
												cstmt.setString(4,cbServiceCode);
												//System.out.println("cbServiceCode:"+cbServiceCode);
												//System.out.println("srvLtSrvCode:"+srvLtSrvCode);
												cstmt.setString(5,servInd);
												//System.out.println("5 servInd:"+servInd);
												cstmt.setString(6,"R");
												//System.out.println("6:R");
												cstmt.setString(7,srvLtSrvCode);
												//System.out.println("7: srvLtSrvCode:"+srvLtSrvCode);
												cstmt.setString(8,servIndLmt);
												//System.out.println("8 servIndLmt: "+servIndLmt);
												cstmt.setString(9,exludeSrv );
												//System.out.println("9:"+exludeSrv );
												cstmt.setString(10,amt_limit_ind );
												//System.out.println("10:"+amt_limit_ind);
												cstmt.setString(11,qtyLimit );
												//System.out.println("11:"+qtyLimit);
												cstmt.setString(12,cbAmtLmt );
												//System.out.println("12:"+cbAmtLmt);
												cstmt.setString(13,replaceableYN );
												//System.out.println("13:"+replaceableYN);
												cstmt.setString(14,replServCode);
												//System.out.println("14:"+replServCode);
												cstmt.setString(15,refundYN );
												//System.out.println("15:"+refundYN);
												cstmt.setString(16,refundAmt);
												//System.out.println("16:"+refundAmt);

												cstmt.setString(17,auto_refund );
												//System.out.println("17:"+auto_refund);
												cstmt.setString(18,roundTo );
												//System.out.println("18:"+roundTo);

												cstmt.setString(19,roundInd);
												//System.out.println("19:"+roundInd);

												cstmt.setString(20,srvLmtFactorAppl );
												//System.out.println("20:"+srvLmtFactorAppl);
												cstmt.setString(21,user_id);
												//System.out.println("21:");
												cstmt.setString(22,user_id);
												//System.out.println("22:");
												cstmt.setString(23,client_ip_address);
												//System.out.println("23:"+client_ip_address);

												cstmt.setString(24,facility_id);
												//System.out.println("24:"+facility_id);

												cstmt.setString(25,client_ip_address);
												//System.out.println("25:"+client_ip_address);

												cstmt.setString(26,facility_id);
												//System.out.println("26:"+facility_id);
												cstmt.setString(27,splitReqd);//RRRR
												cstmt.setString(28,includeHomeMedication);//RRRR
												cstmt.registerOutParameter(29,java.sql.Types.VARCHAR);
												cstmt.registerOutParameter(30,java.sql.Types.VARCHAR);
												cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
												cstmt.setString(32,dailyLmtChkBx);//Added V190320-Aravindh/MMS-DM-CRF-0129
												cstmt.setString(33,dailyLmtAmt);//Added V190320-Aravindh/MMS-DM-CRF-0129
												cstmt.setString(34,dailyLmtGrossNet);//Added V190320-Aravindh/MMS-DM-CRF-0129
												cstmt.setString(35,dailyLmtIndicator);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
												cstmt.setString(36,dailyLmtQty);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
												cstmt.execute();
												str_error_level=cstmt.getString(29);
												str_sysmesage_id=cstmt.getString(30);					
												str_error_text=cstmt.getString(31);
												if(str_error_level==null) str_error_level="";
												if(str_sysmesage_id==null) str_sysmesage_id="";
												if(str_error_text==null) str_error_text="";
												//System.out.println("str_error_level in process rate based insertion:"+str_error_level);
												//System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
												//System.out.println("str_error_text in process rate based insertion:"+str_error_text);
												cstmt.close();
												if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
												{  	//System.out.println("1");
													insertable=false;
													break;
												}
												else
												{  //System.out.println("2");
													insertable = true;
												}
											}
										
										/*  ***  ends  *** */
										
										}
										else if(srvLtSrvGroup.contains(srvLtSrvCode) && !(dbSrvLtSrvGroup.contains(srvLtSrvCode))  || ("").equals(recModified)){//insert
											//System.out.println("calling :insertpackageservice,cbServiceCode="+cbServiceCode);
											//System.out.println("calling :insertpackageservice,srvLtSrvCode="+srvLtSrvCode);
											//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - insertpackageexclusion
											//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - insertpackageexclusion
											sqlcb  ="{ call   blpackage.insertpackageexclusion(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; //sarathkumar InclHmeMedi
											//System.out.println("sqlcb :"+sqlcb);
											cstmt = con.prepareCall(sqlcb);
											cstmt.setString(1,facility_id);
											cstmt.setString(2,packageCode);
											cstmt.setString(3,fromDateSer);
											cstmt.setString(4,cbServiceCode);
											//System.out.println("cbServiceCode:"+cbServiceCode);
											//System.out.println("srvLtSrvCode:"+srvLtSrvCode);
											cstmt.setString(5,servInd);
											//System.out.println("5 servInd:"+servInd);
											cstmt.setString(6,"R");
											//System.out.println("6:R");
											cstmt.setString(7,srvLtSrvCode);
											//System.out.println("7: srvLtSrvCode:"+srvLtSrvCode);
											cstmt.setString(8,servIndLmt);
											//System.out.println("8 servIndLmt: "+servIndLmt);
											cstmt.setString(9,exludeSrv );
											//System.out.println("9:"+exludeSrv );
											cstmt.setString(10,amt_limit_ind );
											//System.out.println("10:"+amt_limit_ind);
											cstmt.setString(11,qtyLimit );
											//System.out.println("11:"+qtyLimit);
											cstmt.setString(12,cbAmtLmt );
											//System.out.println("12:"+cbAmtLmt);
											cstmt.setString(13,replaceableYN );
											//System.out.println("13:"+replaceableYN);
											cstmt.setString(14,replServCode);
											//System.out.println("14:"+replServCode);
											cstmt.setString(15,refundYN );
											//System.out.println("15:"+refundYN);
											cstmt.setString(16,refundAmt);
											//System.out.println("16:"+refundAmt);

											cstmt.setString(17,auto_refund );
											//System.out.println("17:"+auto_refund);
											cstmt.setString(18,roundTo );
											//System.out.println("18:"+roundTo);

											cstmt.setString(19,roundInd);
											//System.out.println("19:"+roundInd);

											cstmt.setString(20,srvLmtFactorAppl );
											//System.out.println("20:"+srvLmtFactorAppl);
											cstmt.setString(21,user_id);
											//System.out.println("21:");
											cstmt.setString(22,user_id);
											//System.out.println("22:");
											cstmt.setString(23,client_ip_address);
											//System.out.println("23:"+client_ip_address);

											cstmt.setString(24,facility_id);
											//System.out.println("24:"+facility_id);

											cstmt.setString(25,client_ip_address);
											//System.out.println("25:"+client_ip_address);

											cstmt.setString(26,facility_id);
											//System.out.println("26:"+facility_id);
											cstmt.setString(27,splitReqd);//RRRR
											cstmt.setString(28,includeHomeMedication);//RRRR
											cstmt.registerOutParameter(29,java.sql.Types.VARCHAR);
											cstmt.registerOutParameter(30,java.sql.Types.VARCHAR);
											cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
											cstmt.setString(32,dailyLmtChkBx);//Added V190320-Aravindh/MMS-DM-CRF-0129
											cstmt.setString(33,dailyLmtAmt);//Added V190320-Aravindh/MMS-DM-CRF-0129
											cstmt.setString(34,dailyLmtGrossNet);//Added V190320-Aravindh/MMS-DM-CRF-0129
											cstmt.setString(35,dailyLmtIndicator);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
											cstmt.setString(36,dailyLmtQty);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
											cstmt.execute();
											str_error_level=cstmt.getString(29);
											str_sysmesage_id=cstmt.getString(30);					
											str_error_text=cstmt.getString(31);
											if(str_error_level==null) str_error_level="";
											if(str_sysmesage_id==null) str_sysmesage_id="";
											if(str_error_text==null) str_error_text="";
											//System.out.println("str_error_level in process rate based insertion:"+str_error_level);
											//System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
											//System.out.println("str_error_text in process rate based insertion:"+str_error_text);
											cstmt.close();
											if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
											{  	//System.out.println("1");
												insertable=false;
												break;
											}
											else
											{  //System.out.println("2");
												insertable = true;
											}
										}//insert
									}
								}
							}
						//}
					}
					//}
					}
				}
		}
		catch (Exception e)
		{	insertable=false;
			System.err.println("Exception from rate based billing service exclusions :"+e);
			e.printStackTrace();
			insertable=false;
		}
/********For Customer Tab**Modify*******Start**********/

			/*try
		{
			ArrayList	cust_grp_code_list	    =	new ArrayList();
			ArrayList	cust_grp_desc_list    =	new ArrayList();
			ArrayList	cust_code_list	    =	new ArrayList();
			ArrayList	cust_desc_list		    =	new ArrayList();
			ArrayList 	blng_class_code_list		=new ArrayList();
			ArrayList 	blng_class_desc_list		=new ArrayList();
			ArrayList	discount_percent_list		    =	new ArrayList();
			ArrayList	discount_amt_list		    =	new ArrayList();
			ArrayList	customerDtls   =	new ArrayList();

			String 		cust_grp_code			="";
			String 	    cust_grp_desc		="";
			String 	    cust_code		="";
			String 	    cust_desc		="";
			String 	    blng_class_code		="";
			String 	    blng_class_desc		="";
			String 	    discount_percent		="";
			String 	    discount_amt		="";
			ArrayList db_cust_grp_code_list=new ArrayList();
			ArrayList db_cust_code_list=new ArrayList();

			ArrayList db_blng_class_code_list=new ArrayList();
			ArrayList serviceCodeKeyList=new ArrayList();
			ArrayList dbServiceCodeKeyList=new ArrayList();
			String dbServiceCodeKey="";
			String serviceCodeKey="";


			if(insertable && modifyCustomer.equals("Y"))
			{
			count_del=0;

				if(includedItems_cust != null && includedItems_cust.containsKey(packageCode) ){
					customerDtls=(ArrayList)includedItems_cust.get(packageCode);
					if(customerDtls!=null && customerDtls.size()>0){
						cust_grp_code_list = (ArrayList)customerDtls.get(0);
						cust_code_list = (ArrayList)customerDtls.get(2);
						blng_class_code_list = (ArrayList)customerDtls.get(4);
					}
				}
				System.out.println("cust_grp_code_list="+cust_grp_code_list.toString());
				for(int i=0; i<cust_grp_code_list.size(); i++){
					 serviceCodeKeyList.add((String)cust_grp_code_list.get(i)+"~~"+(String)cust_code_list.get(i)+"~~"+(String)blng_class_code_list.get(i));
				}
				System.out.println("serviceCodeKeyList="+serviceCodeKeyList.toString());
				if(dbIncludedItems_cust != null && dbIncludedItems_cust.size()>0 && dbIncludedItems_cust.containsKey(packageCode) ){
					dbServices=(ArrayList)dbIncludedItems_cust.get(packageCode);
					System.out.println("dbServices="+dbServices.toString());

					if(dbServices!=null && dbServices.size()>0){
						db_cust_grp_code_list = (ArrayList)dbServices.get(0);
						db_cust_code_list = (ArrayList)dbServices.get(1);
						db_blng_class_code_list= (ArrayList)dbServices.get(2);
					}
				}
				System.out.println("db_cust_grp_code_list="+db_cust_grp_code_list.toString());
				System.out.println("db_cust_code_list="+db_cust_code_list.toString());
				System.out.println("db_blng_class_code_list="+db_blng_class_code_list.toString());
				if(dbServices!=null && dbServices.size()>0){
					for(int i=0; i<db_cust_grp_code_list.size(); i++){
						 dbServiceCodeKeyList.add((String)db_cust_grp_code_list.get(i)+"~~"+(String)db_cust_code_list.get(i)+"~~"+(String)db_blng_class_code_list.get(i));
					}
					System.out.println("dbServiceCodeKeyList="+dbServiceCodeKeyList.toString());
				}

				if(db_cust_grp_code_list!=null && db_cust_grp_code_list.size()>0 && (customerDtls==null || customerDtls.size()==0)){//delete all records.
				System.out.println("user deleted all records . so delete all records from database");
				try
					{
						if(pstmt!=null) pstmt=null;
						sqlDelete = "Delete from BL_PACKAGE_CUST_DTLS where PACKAGE_CODE = ? and OPERATING_FACILITY_ID=?";
						pstmt=con.prepareStatement(sqlDelete);
						pstmt.setString(1,packageCode);
						pstmt.setString(2,facility_id);
						pstmt.executeUpdate();
					}
					catch(Exception e)
					{  insertable=false;
						System.out.println("Exception on deletion Change based :"+e);
						e.printStackTrace();
					}
					finally
					{
						if(pstmt!=null) pstmt.close();
					}
				}
				else{
					System.out.println("other operations");
					if(dbServiceCodeKeyList!=null && dbServiceCodeKeyList.size()>0 && customerDtls!=null && customerDtls.size()>0){
						cust_grp_code_list = (ArrayList)customerDtls.get(0);
						cust_code_list = (ArrayList)customerDtls.get(2);
						blng_class_code_list= (ArrayList)customerDtls.get(4);
						System.out.println("cust_grp_code_list="+cust_grp_code_list.toString());
						System.out.println("cust_code_list="+cust_code_list.toString());
						System.out.println("blng_class_code_list="+blng_class_code_list.toString());
						try
						{
							if(pstmt!=null) pstmt=null;
							sqlDelete = "Delete from BL_PACKAGE_CUST_DTLS where PACKAGE_CODE = ? and CUST_GROUP_CODE=? and CUST_CODE=? and BLNG_CLASS_CODE=? and OPERATING_FACILITY_ID=?";
							pstmt=con.prepareStatement(sqlDelete);
							for(int i=0; i<dbServiceCodeKeyList.size(); i++){//delete only the once deleted by the user
								dbServiceCodeKey =(String)dbServiceCodeKeyList.get(i);
								System.out.println("dbServiceCodeKey="+dbServiceCodeKey);
								if(!serviceCodeKeyList.contains(dbServiceCodeKey)){
									System.out.println("delete service code="+dbServiceCode+" from database");
									StringTokenizer st=new StringTokenizer(dbServiceCodeKey,"~~");
									while(st.hasMoreTokens()){
											cust_grp_code =(String)st.nextToken();
											cust_code =(String)st.nextToken();
											blng_class_code =(String)st.nextToken();
									}
										System.out.println("cust_grp_code="+cust_grp_code);
										System.out.println("cust_code="+cust_code);
										System.out.println("blng_class_code="+blng_class_code);
										count_del++;
										pstmt.setString(1,packageCode);
										pstmt.setString(2,cust_grp_code);
										pstmt.setString(3,cust_code);
										pstmt.setString(4,blng_class_code);
										pstmt.setString(5,facility_id);
										pstmt.addBatch();

									}
								}
								System.out.println("count_del="+count_del);
								if(count_del>0)
									pstmt.executeBatch();
							}
							catch(Exception e)
							{  insertable=false;
								System.out.println("Exception on deletion Change based :"+e);
								e.printStackTrace();
							}
							finally
							{
								if(pstmt!=null) pstmt.close();
							}
						}
						if(customerDtls!=null && customerDtls.size()>0)
						{//update and insert
							cust_grp_code_list    =  (ArrayList)customerDtls.get(0);
							cust_grp_desc_list = (ArrayList)customerDtls.get(1);
							cust_code_list = (ArrayList)customerDtls.get(2);
							cust_desc_list= (ArrayList)customerDtls.get(3);
							blng_class_code_list= (ArrayList)customerDtls.get(4);
							blng_class_desc_list= (ArrayList)customerDtls.get(5);
							discount_percent_list= (ArrayList)customerDtls.get(6);
							discount_amt_list= (ArrayList)customerDtls.get(7);

							totRec = cust_grp_code_list.size();

							System.out.println("totRec="+totRec);
							for(int i=0; i<totRec; i++)
							{
								cust_grp_code =(String)cust_grp_code_list.get(i);
								cust_grp_desc	      =(String)cust_grp_desc_list.get(i);
								cust_code =(String)cust_code_list.get(i);
								cust_desc =(String)cust_desc_list.get(i);
								blng_class_code	  =(String)blng_class_code_list.get(i);
								blng_class_desc      =(String)blng_class_desc_list.get(i);
								discount_percent   =(String)discount_percent_list.get(i);
								discount_amt	  =(String)discount_amt_list.get(i);
								System.out.println("cust_grp_code="+cust_grp_code);
								System.out.println("cust_grp_desc="+cust_grp_desc);
								System.out.println("cust_code="+cust_code);
								System.out.println("cust_desc="+cust_desc);
								System.out.println("blng_class_code="+blng_class_code);
								System.out.println("blng_class_desc="+blng_class_desc);
								System.out.println("discount_percent="+discount_percent);
								System.out.println("discount_amt="+discount_amt);
								serviceCodeKey=(String)serviceCodeKeyList.get(i);//cust_grp_code~~cust_code~~blng_class_code
								if(dbServiceCodeKeyList!=null && dbServiceCodeKeyList.size()>0 && dbServiceCodeKeyList.contains(serviceCodeKey)){
									//chk if update is needed
									System.out.println("before calling ispkgcustdtlsrecordchanged,serviceCodeKey="+serviceCodeKey);
									sqlcb  ="{ call   blpackage.ispkgcustdtlsrecordchanged(?,?,?,?,?,?,?,?,?,?,?)}";
									System.out.println("sqlcb :"+sqlcb);
									cstmt = con.prepareCall(sqlcb);
									cstmt.setString(1,facility_id);
									cstmt.setString(2,packageCode);
									cstmt.setString(3,cust_grp_code);
									cstmt.setString(4,cust_code);
									cstmt.setString(5,blng_class_code);
									cstmt.setString(6,discount_percent);
									cstmt.setString(7,discount_amt);
									cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
									cstmt.execute();

									recModified=cstmt.getString(8);
									str_error_level=cstmt.getString(9);
									str_sysmesage_id=cstmt.getString(10);
									str_error_text=cstmt.getString(11);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									System.out.println("recModified:"+recModified);
									System.out.println("str_error_level in process rate based insertion:"+str_error_level);
									System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
									System.out.println("str_error_text in process rate based insertion:"+str_error_text);
									cstmt.close();
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insertable=false;
										break;
									}
									else
									{
										insertable = true;
									}
									if(insertable && recModified.equals("Y")){
									System.out.println("calling :updatepackagecustdtls ,serviceCodeKey ="+serviceCodeKey);
										sqlcb  ="{ call   blpackage.updatepackagecustdtls(?,?,?,?,?,?,?,?,sysdate,?,?,?,?,?)}";
										System.out.println("sqlcb :"+sqlcb);
										cstmt = con.prepareCall(sqlcb);
										cstmt.setString(1,facility_id);
										cstmt.setString(2,packageCode);
										cstmt.setString(3,cust_grp_code);
										cstmt.setString(4,cust_code);
										cstmt.setString(5,blng_class_code);
										cstmt.setString(6,discount_percent);
										cstmt.setString(7,discount_amt);
										cstmt.setString(8,user_id);
										cstmt.setString(9,client_ip_address);
										cstmt.setString(10,facility_id);
										cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
										cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
										cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
										cstmt.execute();

										str_error_level=cstmt.getString(11);
										str_sysmesage_id=cstmt.getString(12);
										str_error_text=cstmt.getString(13);
										if(str_error_level==null) str_error_level="";
										if(str_sysmesage_id==null) str_sysmesage_id="";
										if(str_error_text==null) str_error_text="";
										System.out.println("str_error_level in process rate based insertion:"+str_error_level);
										System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
										System.out.println("str_error_text in process rate based insertion:"+str_error_text);
										cstmt.close();
										if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
										{
											insertable=false;
											break;
										}
										else
										{
											insertable = true;
										}
									}
								}
								else{//insert
									System.out.println("calling :insertpackagecustdtls,serviceCodeKey="+serviceCodeKey);
									sqlcb  ="{ call   blpackage.insertpackagecustdtls(?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?)}";
									System.out.println("sqlcb :"+sqlcb);
									cstmt = con.prepareCall(sqlcb);
									cstmt.setString(1,facility_id);
									cstmt.setString(2,packageCode);
									cstmt.setString(3,cust_grp_code);
									cstmt.setString(4,cust_code);
									cstmt.setString(5,blng_class_code);
									cstmt.setString(6,discount_percent);
									cstmt.setString(7,discount_amt);
									cstmt.setString(8,user_id);
									cstmt.setString(9,user_id);
									cstmt.setString(10,client_ip_address);
									cstmt.setString(11,facility_id);
									cstmt.setString(12,client_ip_address);
									cstmt.setString(13,facility_id);
									cstmt.registerOutParameter(14,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(15,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(16,java.sql.Types.VARCHAR);
									cstmt.execute();

									str_error_level=cstmt.getString(14);
									str_sysmesage_id=cstmt.getString(15);
									str_error_text=cstmt.getString(16);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									System.out.println("str_error_level in process customer insertion:"+str_error_level);
									System.out.println("str_sysmesage_id in process customer insertion:"+str_sysmesage_id);
									System.out.println("str_error_text in process customerinsertion:"+str_error_text);
									cstmt.close();
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insertable=false;
										break;
									}
									else
									{
										insertable = true;
									}
								}//insert
							}
						}
					}
			}

		}
		catch (Exception e)
		{
			System.out.println("Exception from rate based billing service :"+e);
			e.printStackTrace();
			insertable=false;
		}

	*/
	System.out.println(" 8550 applicalbleTo "+applicalbleTo);
	System.out.println(" 8550 insertable "+insertable);
	if(insertable && applicalbleTo!=null && !applicalbleTo.equals("A")){
		System.out.println(" before calling modifyCustomerDtls() ");
		return_mess_cust =modifyCustomerDtls(con,tabdata);
		if(return_mess_cust!=null && return_mess_cust.size()>0){
			insertable=	(((Boolean) return_mess_cust.get("status")).booleanValue());
			str_error_text=(String)return_mess_cust.get("error");
			sys_err=sys_err.append(return_mess_cust.get("sys_error"));
			str_sysmesage_id=(String)return_mess_cust.get("message");
		}
	}
	
	//Added By Shikha For GHL-CRF-0520.1
	if(insertable ){		
		return_mess_blng_grp =modifyBillingGroupDtls(con,tabdata);
		if(return_mess_blng_grp!=null && return_mess_blng_grp.size()>0){
			insertable=	(((Boolean) return_mess_blng_grp.get("status")).booleanValue());
			str_error_text=(String)return_mess_blng_grp.get("error");
			sys_err=sys_err.append(return_mess_blng_grp.get("sys_error"));
			str_sysmesage_id=(String)return_mess_blng_grp.get("message");
		}
	}
	//Ended By Shikha For GHL-CRF-0520.1
	if(insertable){
		return_mess_discount =modifyDiscountDtls(con,tabdata);
		if(return_mess_discount!=null && return_mess_discount.size()>0){
			insertable=	(((Boolean) return_mess_discount.get("status")).booleanValue());
			str_error_text=(String)return_mess_discount.get("error");
			sys_err=sys_err.append(return_mess_discount.get("sys_error"));
			str_sysmesage_id=(String)return_mess_discount.get("message");
		}
	}
	if(pstmt!=null) pstmt.close();
				if(pstmt1!=null) pstmt1.close();
				/***********Karthik added this code for adding Partial deposit Records MMS-CRF-0023 - Starts***********/
			    if (insertable) {
			        try
			        {
			          HashMap returnMessage = new HashMap();
			          boolean deletePartialDepositRecord = false;
			          boolean insertPartialDepositRecord = false;
			          HashMap inputParameters = new HashMap();

			          HashMap insertMap = new HashMap();
			          insertMap = (HashMap)tabdata.get("partial_deposit_list");
			          Set kSet = insertMap.keySet();
			          Iterator it = kSet.iterator();

			          while (it.hasNext())
			          {
			            String partialDepkey = (String)it.next();
			            ArrayList partialDepositList = (ArrayList)insertMap.get(partialDepkey);

			            inputParameters.put("poperatingfacilityid", facility_id);
			            inputParameters.put("ppackagecode", packageCode);
			            inputParameters.put("pefffromdate", effFromDate);
			            inputParameters.put("pblngclasscode", partialDepkey);
			            inputParameters.put("planguageid", locale);
			            inputParameters.put("paddedbyid", this.user_id);
			            inputParameters.put("paddedfacilityid", facility_id);
			            inputParameters.put("paddedatwsno", this.client_ip_address);

			            returnMessage = deleteAllPartialDepositDetails(this.con, inputParameters);
			            boolean allRecsDeleted = Boolean.parseBoolean((String)returnMessage.get("status"));
			            if (!allRecsDeleted) {
			              insertable = false;
			              this.str_error_text = ((String)returnMessage.get("error"));
			              this.sys_err = this.sys_err.append((String)returnMessage.get("sys_error"));
			              this.str_sysmesage_id = ((String)returnMessage.get("message"));
			              break;
			            }

			            for (int i = 0; i < partialDepositList.size(); i++)
			            {
			              StringTokenizer st = new StringTokenizer((String)partialDepositList.get(i), "~");
			              while (st.hasMoreTokens()) {
			                inputParameters.put("pencounterseqno", st.nextToken());
			                inputParameters.put("pminpartialdeposittype", st.nextToken());
			                inputParameters.put("pminpartialdeposit", st.nextToken());
			                inputParameters.put("pdepositmandatoryyn", st.nextToken());
			              }

			              returnMessage = insertPartialDepositDetails(this.con, inputParameters);
			              insertPartialDepositRecord = Boolean.parseBoolean((String)returnMessage.get("status"));
			              if (!insertPartialDepositRecord) {
			                insertable = false;
			                this.str_error_text = ((String)returnMessage.get("error"));
			                this.sys_err = this.sys_err.append((String)returnMessage.get("sys_error"));
			                this.str_sysmesage_id = ((String)returnMessage.get("message"));
			                break;
			              }
			            }
			          }
			        }
			        catch (Exception e)
			        {
			          System.err.println("Exception in adding Partial deposit Records :" + e);
			          e.printStackTrace();
			          insertable = false;
			        }

			      }
			    /***********Karthik added this code for adding Partial deposit Records MMS-CRF-0023 - Ends***********/
				//System.out.println("Karthikk insertable finally="+insertable);

				
				//Added By Vijay For MMS-DM-CRf-91

			try {
				Boolean siteSpec = false;
				try {

				
					siteSpec = eCommon.Common.CommonBean.isSiteSpecific(con,
							"BL", "INCL/EXCL_HOME_MEDICATION");
					//System.out.println("Pkg Def Manager SiteSpec"+ siteSpec);
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println("Exception in site specific " + e);
				}

				if (siteSpec) {
					if (insertable) {

						String sqlInclHomeMedValidate = "{ call  blpackage.bl_proc_reset_home_medication(?,?,?)}";

						if (!("Y".equalsIgnoreCase(IpYn) || "Y"
								.equalsIgnoreCase(DcYn))) {
							//System.out.println("in if");
							try {
								cstmt = con.prepareCall(sqlInclHomeMedValidate);
								cstmt.setString(1, facility_id);
								cstmt.setString(2, packageCode);
								cstmt.registerOutParameter(3,
										java.sql.Types.VARCHAR);
								cstmt.execute();
								str_sysmesage_id = cstmt.getString(3);
								
								if (str_sysmesage_id == null)
									str_sysmesage_id = "";
								
								cstmt.close();//V210413
								if (!str_sysmesage_id.equals("")) {
									insertable = false;
								} else {
									insertable = true;
								}

							} catch (Exception e) {
								e.printStackTrace();
								System.err.println("Exception in sqlInclHomeMedValidate"
												+ e);
							}
						}

					}

				}
			} catch (Exception e) {
				e.printStackTrace();

			}	
		if(insertable)
			{
			//System.out.println("before commit");
				con.commit();
			}
			else
			{
				con.rollback();
			}
		}catch (Exception e)
		 {
			insertable=false;
			sys_err.append("Main Exception:"+e);
			System.err.println("Main Exception modify:"+e);
			e.printStackTrace();
		 }
		finally
		{
			try{
				if(pstmt!=null) pstmt.close();
					if(pstmt1!=null) pstmt1.close();
				if (con != null)
				ConnectionManager.returnConnection(con, p);
			}catch(Exception r)
			{	r.printStackTrace();		}
		}

		return_mess.put("status",new Boolean(insertable));
		return_mess.put("error",str_error_text);
		return_mess.put("sys_error",sys_err.toString());
		return_mess.put("message",str_sysmesage_id);
		//System.out.println("Karthikk modify()" + return_mess.toString());
		return return_mess;
	}//modify()
	@SuppressWarnings({"rawtypes","unused", "unchecked"})
	public HashMap modifyCustomerDtls(Connection con,HashMap tabdata) //throws Exception{
	{
		System.out.println("in modifyCustomerDtls() tabdata="+tabdata.toString());
		HashMap return_mess = new HashMap();

		String amt_limit_ind = "";
		String roundTo = "";
		String roundInd= "";
	//	String auto_refund= ""; unused
	//	String closePakgStat= ""; unused
		String blgClsCode = "";
		String fromDate="";
		String toDate="";
		String indicator="";
		String price1="";
		String factorAppl="";
		String deposit		   ="";
		String partialDeposit 	   ="";
		String minDepAmtind   	   ="";
		String minDepAmt	 	   ="";		//String cbServiceCode =	""; unused
		//String cbAmtLmtInd	 =	"";  unused
		//String cbAmtLmt		 =	""; unused
		//String srvLmtFactorAppl		 =	""; unused

		//String factorRate	 =	"";
		String factorforServiceRate =""; //Added by muthu
		String qtyLimit		 =	"";
		String refundAmt	 =	"";
		String factor_appl	 =	"";
		String itemCode      =  "";
		String itemDesc      =  "";
		String inExcl        =  "";
		/*String servIndLmt    =  ""; unused
		//String srvLtSrvCode	 =  ""; unused
		//String exludeSrv	 =  "";  unused
		//String servInd	     =  ""; unused
		String rateChargInd  =  "";

		String ordCatlogCode =  "";
		String factorRateInd =  "";
		String replaceableYN =  "";
		String replServCode  =  "";
		String replOrder     =  "";
		String refundYN		 =  "";  */
			String 		recModified="";



		StringBuffer sb = new StringBuffer( "" ) ;
		Hashtable messageHashtable=new Hashtable();
		Set<String>	keySet;
		Iterator<String> custIt;
		String key="";
		String cust_grp_code="";
		String cust_grp_desc="";
		String cust_code="";
		String cust_desc="";
		String pkg_valid_days="";



		String pkgPriceClsCode="";
		String pkgPriceClsDesc="";
		String oPkgPriceClsCode="";
		String oPkgPriceClsDesc="";
		String glSmry="";
		String glSmryDesc="";
		String glSmryDisc="";
		String glSmryDiscDesc="";
		String VATapp="";
		String VATpercent="";

		String blgClsDesc        = "";
		String type="";
		String 		service_code			="";
		String 	    service_desc		="";
		String 		catalog_code			="";
		String 		catalog_desc		="";
		String 		ind			="";
		String 		factorOrRate		="";
		String 		qty_limit			="";
		String 		amt_limit		="";
		String 		replace		="N";
		String 		replaceSrv_code		="";
		String 		replaceSrv_desc		="";
		String 		replaceSrv_cat_code		="";
		String 		replaceSrv_cat_desc			="";
		String 		refund			="N";
		String		autoRefund		= "N";
		String      closePkg = "N";
		String		splitReqd	  = "Y";//Split reqd - Rajesh V
		String		includeHomeMedication	  = "Y";
		String cbType = "";//MuthuN against 28192
		String srvLmt = "";//MuthuN against 28192 on 8/27/2012
		String cbService = "";
		String cbServiceDesc = "";;
		String amountLimitInd = "";
		String amountLimit = "";
		String srvLimit_type		="";
		String 		srvLimit_service_code			="";
		String 	    srvLimit_service_desc		="";
		String 		exludeService			="N";
		String 		srvLimit_qty_limit		="";
		String 		srvLimit_amt_limit			="";
		String 		srvLimit_factor_appl			="";
		String 		srvLimit_amt_limit_ind	="";
		String 	    srvLimit_replace		="N";
		String 		srvLimit_replaceSrv_code="";
		String		srvLimit_replaceSrv_desc = "";
		String 		srvLimit_refund		="N";
		String 		srvLimit_refundAmt		="";
		String 		srvLimit_auto_refund			="N";
		String      srvLimit_roundTo = "";
		String      srvLimit_roundInd = "";
		String parent_service_code="";
		String dailyLmtChkBx = "";//Added V190320-Aravindh/MMS-DM-CRF-0129
		String dailyLmtAmt = "";//Added V190320-Aravindh/MMS-DM-CRF-0129
		String dailyLmtGrossNet = "";//Added V190320-Aravindh/MMS-DM-CRF-0129
		String dailyLmtIndicator = "";//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		String dailyLmtQty = "";//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		String serv_grp_limit_ind = "";//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
		StringTokenizer stKey;
		StringTokenizer	msgIds;
		String[] record;
		boolean existsInDB=false;
		boolean insert = true;
		CallableStatement isCustPeriodUpdated_cstmt = null;
			CallableStatement update_cust_period_cstmt = null;

try{
	String facility_id = (String) tabdata.get("FACILITY_ID");
		if(facility_id==null) facility_id="";

		String packageCode=(String)tabdata.get("packageCode");
		if(packageCode==null) packageCode="";

		String client_ip_address=(String)tabdata.get("client_ip_address");
		if(client_ip_address==null) client_ip_address="";

		String user_id=(String)tabdata.get("login_user");
		if(user_id==null) user_id="";

		String locale=(String)tabdata.get("locale");
		if(locale==null) locale="en";

		HashMap cust_dtls = (HashMap)tabdata.get("cust_dtls");
		HashMap cust_period = (HashMap)tabdata.get("cust_period");
		HashMap cust_base_price = (HashMap)tabdata.get("cust_base_price");
		HashMap cust_rate_srv = (HashMap)tabdata.get("cust_rate_srv");
		System.out.println("cust_rate_srv manager test=> "+cust_rate_srv);
		HashMap cust_rate_srv_excl = (HashMap)tabdata.get("cust_rate_srv_excl");
		HashMap cust_charge_srv = (HashMap)tabdata.get("cust_charge_srv");
		HashMap cust_charge_srv_excl = (HashMap)tabdata.get("cust_charge_srv_excl");

		HashMap db_cust_dtls = (HashMap)tabdata.get("db_cust_dtls");
		HashMap db_cust_period = (HashMap)tabdata.get("db_cust_period");
		HashMap db_cust_base_price = (HashMap)tabdata.get("db_cust_base_price");
		HashMap db_cust_rate_srv = (HashMap)tabdata.get("db_cust_rate_srv");
		HashMap db_cust_rate_srv_excl = (HashMap)tabdata.get("db_cust_rate_srv_excl");
		HashMap db_cust_charge_srv = (HashMap)tabdata.get("db_cust_charge_srv");
		HashMap db_cust_charge_srv_excl = (HashMap)tabdata.get("db_cust_charge_srv_excl");

		String modify_cust=(String)tabdata.get("modify_cust");
		String modify_cust_period=(String)tabdata.get("modify_cust_period");
		String modify_cust_base_price=(String)tabdata.get("modify_cust_base_price");
		String modify_cust_rate_srv=(String)tabdata.get("modify_cust_rate_srv");
		String modify_cust_rate_srv_excl=(String)tabdata.get("modify_cust_rate_srv_excl");
		String modify_cust_charge_srv=(String)tabdata.get("modify_cust_charge_srv");
		String modify_cust_charge_srv_excl=(String)tabdata.get("modify_cust_charge_srv_excl");
			System.out.println(" 8910 modify_cust_rate_srv "+modify_cust_rate_srv);
		/****************insert stmts*****start****/ 
		String sql   ="{ call   blpackage.insertpackagecustdtls (?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?)}";
		CallableStatement cust_cstmt = con.prepareCall(sql);
		String cust_period_sql   ="{ call   blpackage.insertpackagecustperiod (?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?)}";
		String cust_period_sql1   ="{ call   blpackage.insertpackagecustperiod (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?)}";
		CallableStatement cust_period_cstmt = null;
		sql="{ call   blpackage.insertpackagecustprice (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?)}";//Added by Muthu on 26-6-12
		//System.out.println("blpackage.insertpackagecustprice Entering  2");
		CallableStatement cust_price_cstmt = con.prepareCall(sql);
		//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - insertpackageserviceforcust
		//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - insertpackageserviceforcust
		sql="{ call   blpackage.insertpackageserviceforcust  (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";	 //Modified By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
		CallableStatement cust_rate_srv_cstmt = con.prepareCall(sql);
		//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - insertpackageexclforcust
		//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - insertpackageexclforcust
		sql="{ call   blpackage.insertpackageexclforcust  (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		CallableStatement cust_rate_srv_excl_cstmt = con.prepareCall(sql);
		//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - insertpackageserviceforcust
		//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - insertpackageserviceforcust
		sql="{ call   blpackage.insertpackageserviceforcust  (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";	 //Modified By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
		CallableStatement cust_charge_srv_cstmt = con.prepareCall(sql);
		//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - insertpackageexclforcust
		//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - insertpackageexclforcust
		sql="{ call   blpackage.insertpackageexclforcust  (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		CallableStatement cust_charge_srv_excl_cstmt = con.prepareCall(sql);
		/****************insert stmts*****end****/
		/****************update stmts*****start****/
		sql   ="{ call   blpackage.ispkgcustdtlsrecordchanged (?,?,?,?,?,?,?,?,?)}";
		CallableStatement isCustUpdated_cstmt = con.prepareCall(sql);
		sql   ="{ call   blpackage.updatepackagecustdtls (?,?,?,?,?,?,sysdate,?,?,?,?,?)}";
		CallableStatement update_cust_cstmt = con.prepareCall(sql);
		String isCustPeriodUpdated_sql   ="{ call   blpackage.ispkgcustperiodrecordchanged (?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?)}";
		String isCustPeriodUpdated_sql1   ="{ call   blpackage.ispkgcustperiodrecordchanged (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?)}";

		String update_cust_period_sql   ="{ call   blpackage.updatepackagecustperiod (?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?)}";
		String update_cust_period_sql1   ="{ call   blpackage.updatepackagecustperiod (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?)}";

		sql="{ call   blpackage.ispkgcustpricerecordchanged (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";//Added by muthu on 26-6-12
		CallableStatement isCustPriceUpdated_cstmt = con.prepareCall(sql);
		sql="{ call   blpackage.updatepackagecustprice (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?,?)}";//Added by muthu on 26-6-12
		CallableStatement update_cust_price_cstmt = con.prepareCall(sql);
		//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - ispkgservforcustrecordchanged
		//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - ispkgservforcustrecordchanged
		sql="{ call   blpackage.ispkgservforcustrecordchanged (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";	 
		CallableStatement isCustRateSrvUpdated_cstmt = con.prepareCall(sql);
		//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - updatepackageservforcust
		//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - updatepackageservforcust
		sql="{ call   blpackage.updatepackageservforcust  (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?)}";	 
		CallableStatement update_cust_rate_srv_cstmt = con.prepareCall(sql);
		//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - ispkgexclforcustrecordchanged
		//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - ispkgexclforcustrecordchanged
		sql="{ call   blpackage.ispkgexclforcustrecordchanged (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";	 
		CallableStatement isCustRateExclUpdated_cstmt = con.prepareCall(sql);
		//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - updatepackageexclforcust
		//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - updatepackageexclforcust
		sql="{ call   blpackage.updatepackageexclforcust  (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?)}";	 
		CallableStatement update_cust_rate_srv_excl_cstmt = con.prepareCall(sql);
		//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - ispkgservforcustrecordchanged
		//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - ispkgservforcustrecordchanged
		sql="{ call   blpackage.ispkgservforcustrecordchanged (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";	 
		CallableStatement isCustChargeSrvUpdated_cstmt = con.prepareCall(sql);
		//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - updatepackageservforcust
		//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - updatepackageservforcust
		sql="{ call   blpackage.updatepackageservforcust  (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?)}";	 
		CallableStatement update_cust_charge_srv_cstmt = con.prepareCall(sql);
		//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - ispkgexclforcustrecordchanged
		//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - ispkgexclforcustrecordchanged
		sql="{ call   blpackage.ispkgexclforcustrecordchanged (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";	 
		CallableStatement isCustChargeExclUpdated_cstmt = con.prepareCall(sql);
		//Added V190320-Aravindh/MMS-DM-CRF-0129/3 new parameters - updatepackageexclforcust
		//Added V190626-Aravindh/MMS-DM-CRF-0129.1/2 new parameters - updatepackageexclforcust
		sql="{ call   blpackage.updatepackageexclforcust  (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?)}";	 
		CallableStatement update_cust_charge_srv_excl_cstmt = con.prepareCall(sql);
	/****************update stmts*****end****/
		ArrayList cust_period_list=new ArrayList();
		ArrayList cust_price_list=new ArrayList();
		ArrayList cust_rate_srv_list=new ArrayList();
		ArrayList cust_rate_srv_excl_list=new ArrayList();
		ArrayList cust_charge_srv_list=new ArrayList();
		ArrayList cust_charge_srv_excl_list=new ArrayList();
		ArrayList inserted_cust_period_list=new ArrayList();
		ArrayList inserted_cust_rate_srv_list=new ArrayList();
		ArrayList inserted_cust_charge_srv_list=new ArrayList();
		ArrayList split_reqd_list=new ArrayList(); //Split reqd
		ArrayList includeHomeMedication_list=new ArrayList();
		try
		{
		System.out.println(" 9005 cust_dtls "+cust_dtls);	
		System.out.println(" 9005 modify_cust "+modify_cust);	
			if(insert && cust_dtls!=null && cust_dtls.size()>0 && modify_cust.equals("Y") )
			{
				keySet=(Set<String>)cust_dtls.keySet();
				custIt=keySet.iterator();
				while(insert && custIt.hasNext()){
					record=new String[5];
					key=(String)custIt.next();
					record=(String[])cust_dtls.get(key);
					cust_grp_code		= record[0];
					cust_grp_desc		= record[1];
					cust_code	=	record[2];
					cust_desc		=record[3];
					pkg_valid_days		=record[4];
					/*System.out.println("facility_id="+facility_id);
					System.out.println("packageCode="+packageCode);
					System.out.println("cust_grp_code="+cust_grp_code);
					System.out.println("cust_grp_desc="+cust_grp_desc);
					System.out.println("cust_code="+cust_code);
					System.out.println("cust_desc="+cust_desc);
					System.out.println("pkg_valid_days="+pkg_valid_days);*/
					System.out.println("9028,db_cust_dtls,manager="+db_cust_dtls);
					if(db_cust_dtls!=null && db_cust_dtls.size()>0 && db_cust_dtls.containsKey(key)){
						//chk if update is needed
						isCustUpdated_cstmt.setString(1,facility_id);
						isCustUpdated_cstmt.setString(2,packageCode);
						isCustUpdated_cstmt.setString(3,cust_grp_code);
						isCustUpdated_cstmt.setString(4,cust_code);
						isCustUpdated_cstmt.setString(5,pkg_valid_days);
						isCustUpdated_cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
						isCustUpdated_cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
						isCustUpdated_cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
						isCustUpdated_cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
						isCustUpdated_cstmt.execute();

						recModified=isCustUpdated_cstmt.getString(6);
						str_error_level=isCustUpdated_cstmt.getString(7);
						str_sysmesage_id=isCustUpdated_cstmt.getString(8);
						str_error_text=isCustUpdated_cstmt.getString(9);
						if(str_error_level==null) str_error_level="";
						if(str_sysmesage_id==null) str_sysmesage_id="";
						if(str_error_text==null) str_error_text="";
						if(recModified == null)		recModified="";
						System.out.println("recModified ,9094:"+recModified);
						System.out.println("str_error_level in process rate based insertion:"+str_error_level);
						System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
						System.out.println("str_error_text in process rate based insertion:"+str_error_text);
						if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
						{
							insert=false;
							sb.append("<br>"+str_error_text+"<br> ") ;
						}
						if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
						{
							insert=false;
							if((str_error_level.equals("10") && !str_error_text.equals("") ))
							{
								sb.append("<br>"+str_error_text+"<br> ") ;
								//System.out.println("sb mesage in Error is:"+sb);
							}
							else
							{
								if(str_sysmesage_id.indexOf("|") != (-1)){
									msgIds=new StringTokenizer(str_sysmesage_id,"|");
									while(msgIds.hasMoreTokens())
									{
										messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
										sb.append((String)messageHashtable.get("message")+"<br>");
									}
									//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
								}else{
									messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
									sb.append((String)messageHashtable.get("message"));
									//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
								}
							}
						}
						System.out.println("recModified ,9083:"+recModified);
						System.out.println("insert ,9083:"+insert);
						if(insert && "Y".equals(recModified)){		
							update_cust_cstmt.setString(1,facility_id);
							update_cust_cstmt.setString(2,packageCode);
							update_cust_cstmt.setString(3,cust_grp_code);
							update_cust_cstmt.setString(4,cust_code);
							update_cust_cstmt.setString(5,pkg_valid_days);
							update_cust_cstmt.setString(6,user_id);
							update_cust_cstmt.setString(7,client_ip_address );
							update_cust_cstmt.setString(8,facility_id);
							update_cust_cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
							update_cust_cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
							update_cust_cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
							update_cust_cstmt.execute();

							str_error_level=update_cust_cstmt.getString(9);
							str_sysmesage_id=update_cust_cstmt.getString(10);
							str_error_text=update_cust_cstmt.getString(11);
							if(str_error_level==null) str_error_level="";
							if(str_sysmesage_id==null) str_sysmesage_id="";
							if(str_error_text==null) str_error_text="";
							System.out.println("9106 str_error_level in process rate based insertion:"+str_error_level);
							System.out.println("9106 str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
							System.out.println("9106 str_error_text in process rate based insertion:"+str_error_text);
							if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
							{
								insert=false;
								sb.append("<br>"+str_error_text+"<br> ") ;
							}
							if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
							{
								insert=false;
								if((str_error_level.equals("10") && !str_error_text.equals("") ))
								{
									sb.append("<br>"+str_error_text+"<br> ") ;
									//System.out.println("sb mesage in Error is:"+sb);
								}
								else
								{
									if(str_sysmesage_id.indexOf("|") != (-1)){
										msgIds=new StringTokenizer(str_sysmesage_id,"|");
										while(msgIds.hasMoreTokens())
										{
											messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
											sb.append((String)messageHashtable.get("message")+"<br>");
										}
										//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
									}else{
										messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
										sb.append((String)messageHashtable.get("message"));
										//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
									}
								}
							}
						}
					}
					else{//insert
						cust_cstmt.setString(1,facility_id);
						cust_cstmt.setString(2,packageCode);
						cust_cstmt.setString(3,cust_grp_code);
						cust_cstmt.setString(4,cust_code);
						cust_cstmt.setString(5,pkg_valid_days);
						cust_cstmt.setString(6,user_id);
						cust_cstmt.setString(7,user_id);
						cust_cstmt.setString(8,client_ip_address);
						cust_cstmt.setString(9,facility_id);
						cust_cstmt.setString(10,client_ip_address);
						cust_cstmt.setString(11,facility_id);
						cust_cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
						cust_cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
						cust_cstmt.registerOutParameter(14,java.sql.Types.VARCHAR);
						cust_cstmt.execute();

						str_error_level=cust_cstmt.getString(12);
						str_sysmesage_id=cust_cstmt.getString(13);
						str_error_text=cust_cstmt.getString(14);
						if(str_error_level==null) str_error_level="";
						if(str_sysmesage_id==null) str_sysmesage_id="";
						if(str_error_text==null) str_error_text="";
						System.out.println("9166 ,str_sysmesage_id in process:"+str_sysmesage_id);
						System.out.println("str_error_text in process:"+str_error_text);
						System.out.println("str_error_text in process:"+str_error_text);
						if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
						{
							insert=false;
							sb.append("<br>"+str_error_text+"<br> ") ;
						}
						if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
						{
							insert=false;
							if((str_error_level.equals("10") && !str_error_text.equals("") ))
							{
								sb.append("<br>"+str_error_text+"<br> ") ;
								//System.out.println("sb mesage in Error is:"+sb);
							}
							else
							{
								if(str_sysmesage_id.indexOf("|") != (-1)){
									msgIds=new StringTokenizer(str_sysmesage_id,"|");
									while(msgIds.hasMoreTokens())
									{
										messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
										sb.append((String)messageHashtable.get("message")+"<br>");
									}
									//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
								}else{
									messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
									sb.append((String)messageHashtable.get("message"));
									//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
								}
							}
						}
					}//insert
				}//while
				if(isCustUpdated_cstmt!=null)
					isCustUpdated_cstmt.close();
				if(update_cust_cstmt!=null)
					update_cust_cstmt.close();
				if(cust_cstmt!=null)
					cust_cstmt.close();
			}// if
		}
		catch (Exception e)
		{
			System.err.println("Exception while updating customer details:"+e);
			e.printStackTrace();
			insert=false;
		}
	/*******Update customer details************end********************/
	/*******Update customer period details************start********************/
	try
		{
			System.out.println("insert ,9217:"+insert);
			System.out.println("cust_period ,9217:"+cust_period);
			System.out.println("modify_cust_period ,9219:"+modify_cust_period);
			if(insert && cust_period!=null && cust_period.size()>0 && modify_cust_period.equals("Y") )
			{
				//System.out.println("other operations");
				keySet=(Set<String>)cust_period.keySet();
				//System.out.println("keySet="+keySet.toString());
				custIt=keySet.iterator();
				/****************************/
				while(insert && custIt.hasNext()){
					key=(String)custIt.next();
					cust_period_list=(ArrayList)cust_period.get(key);
					if(cust_period_list!=null && cust_period_list.size()>0 ){
						stKey=new StringTokenizer(key,"~~");
						if(stKey.hasMoreTokens()){
							cust_grp_code=stKey.nextToken();
						}else{
							cust_grp_code="";
						}
						if(stKey.hasMoreTokens())
							cust_code=stKey.nextToken();
						else
							cust_code="";
						if(insert && !cust_grp_code.equals("") && !cust_code.equals("") && cust_dtls!=null && cust_dtls.size()>0 && cust_dtls.containsKey(cust_grp_code+"~~"+cust_code)){
							for(int i=0;i<cust_period_list.size();i++){

								record=(String[])cust_period_list.get(i);
								fromDate		= record[0];
								toDate		= record[1];
								pkgPriceClsCode	=	record[2];
								pkgPriceClsDesc		=record[3];
								oPkgPriceClsCode		=record[4];
								oPkgPriceClsDesc		=record[5];
								glSmry		=record[6];
								glSmryDesc		=record[7];
								glSmryDisc		=record[8];
								glSmryDiscDesc		=record[9];
								VATapp     =record[10];
								VATpercent  =record[11];
								String VATruleCoverage  =record[12];
								String flagVal_cust  =record[13];
								existsInDB=existsInDB(cust_grp_code+"~~"+cust_code,record,db_cust_period,"CUST_PERIOD");
								inserted_cust_period_list.add(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim());
								/*System.out.println("facility_id="+facility_id);
								System.out.println("packageCode="+packageCode);
								System.out.println("cust_grp_code="+cust_grp_code);
								System.out.println("cust_code="+cust_code);
								System.out.println("fromDate="+fromDate);
								System.out.println("toDate="+toDate);
								System.out.println("pkgPriceClsCode="+pkgPriceClsCode);
								System.out.println("pkgPriceClsDesc="+pkgPriceClsDesc);
								System.out.println("oPkgPriceClsCode="+oPkgPriceClsCode);
								System.out.println("oPkgPriceClsDesc="+oPkgPriceClsDesc);
								System.out.println("glSmry="+glSmry);
								System.out.println("glSmryDesc="+glSmryDesc);
								System.out.println("existsInDB="+existsInDB);*/
								if(existsInDB){
									//chk if update is needed
									if(toDate==null || toDate.equals("")){
										isCustPeriodUpdated_cstmt = con.prepareCall(isCustPeriodUpdated_sql1);
										toDate=null;
									}else{
										isCustPeriodUpdated_cstmt = con.prepareCall(isCustPeriodUpdated_sql);
									}

									isCustPeriodUpdated_cstmt.setString(1,facility_id);
									isCustPeriodUpdated_cstmt.setString(2,packageCode);
									isCustPeriodUpdated_cstmt.setString(3,cust_grp_code);
									isCustPeriodUpdated_cstmt.setString(4,cust_code);
									isCustPeriodUpdated_cstmt.setString(5,fromDate);
									isCustPeriodUpdated_cstmt.setString(6,toDate );
									isCustPeriodUpdated_cstmt.setString(7,pkgPriceClsCode );
									isCustPeriodUpdated_cstmt.setString(8,oPkgPriceClsCode );
									isCustPeriodUpdated_cstmt.setString(9,glSmry );
									isCustPeriodUpdated_cstmt.setString(10,glSmryDisc );
									isCustPeriodUpdated_cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
									isCustPeriodUpdated_cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
									isCustPeriodUpdated_cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
									isCustPeriodUpdated_cstmt.registerOutParameter(14,java.sql.Types.VARCHAR);
									isCustPeriodUpdated_cstmt.setString(15,VATapp);
									isCustPeriodUpdated_cstmt.setString(16,VATpercent);
									isCustPeriodUpdated_cstmt.setString(17,VATruleCoverage);
									isCustPeriodUpdated_cstmt.execute();

									recModified=isCustPeriodUpdated_cstmt.getString(11);
									str_error_level=isCustPeriodUpdated_cstmt.getString(12);
									str_sysmesage_id=isCustPeriodUpdated_cstmt.getString(13);
									str_error_text=isCustPeriodUpdated_cstmt.getString(14);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									if(recModified == null)		recModified="";
									/*System.out.println("recModified:"+recModified);
									System.out.println("str_error_level in process rate based insertion:"+str_error_level);
									System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
									System.out.println("str_error_text in process rate based insertion:"+str_error_text);*/
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insert=false;
										sb.append("<br>"+str_error_text+"<br> ") ;
									}
									if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
									{
										insert=false;
										if((str_error_level.equals("10") && !str_error_text.equals("") ))
										{
											sb.append("<br>"+str_error_text+"<br> ") ;
											//System.out.println("sb mesage in Error is:"+sb);
										}
										else
										{
											if(str_sysmesage_id.indexOf("|") != (-1)){
												msgIds=new StringTokenizer(str_sysmesage_id,"|");
												while(msgIds.hasMoreTokens())
												{
													messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
													sb.append((String)messageHashtable.get("message")+"<br>");
												}
												//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
											}else{
												messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
												sb.append((String)messageHashtable.get("message"));
												//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
											}
										}
									}
									if(insert && "Y".equals(recModified)){	
										if(toDate==null ||  toDate.equals("")){
											update_cust_period_cstmt = con.prepareCall(update_cust_period_sql1);
											toDate=null;
										}else{
											update_cust_period_cstmt = con.prepareCall(update_cust_period_sql);
										}

										update_cust_period_cstmt.setString(1,facility_id);
										update_cust_period_cstmt.setString(2,packageCode);
										update_cust_period_cstmt.setString(3,cust_grp_code);
										update_cust_period_cstmt.setString(4,cust_code);
										update_cust_period_cstmt.setString(5,fromDate);
										update_cust_period_cstmt.setString(6,toDate);
										update_cust_period_cstmt.setString(7,pkgPriceClsCode);
										update_cust_period_cstmt.setString(8,oPkgPriceClsCode);
										update_cust_period_cstmt.setString(9,glSmry);
										update_cust_period_cstmt.setString(10,glSmryDisc);
										update_cust_period_cstmt.setString(11,user_id);
										update_cust_period_cstmt.setString(12,client_ip_address );
										update_cust_period_cstmt.setString(13,facility_id);
										update_cust_period_cstmt.registerOutParameter(14,java.sql.Types.VARCHAR);
										update_cust_period_cstmt.registerOutParameter(15,java.sql.Types.VARCHAR);
										update_cust_period_cstmt.registerOutParameter(16,java.sql.Types.VARCHAR);
										update_cust_period_cstmt.setString(17,VATapp);
										update_cust_period_cstmt.setString(18,VATpercent);
										update_cust_period_cstmt.setString(19,VATruleCoverage);
										update_cust_period_cstmt.execute();

										str_error_level=update_cust_period_cstmt.getString(14);
										str_sysmesage_id=update_cust_period_cstmt.getString(15);
										str_error_text=update_cust_period_cstmt.getString(16);
										if(str_error_level==null) str_error_level="";
										if(str_sysmesage_id==null) str_sysmesage_id="";
										if(str_error_text==null) str_error_text="";
										/*System.out.println("str_error_level in process rate based insertion:"+str_error_level);
										System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
										System.out.println("str_error_text in process rate based insertion:"+str_error_text);*/
										if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
										{
											insert=false;
											sb.append("<br>"+str_error_text+"<br> ") ;
										}
										if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
										{
											insert=false;
											if((str_error_level.equals("10") && !str_error_text.equals("") ))
											{
												sb.append("<br>"+str_error_text+"<br> ") ;
												//System.out.println("sb mesage in Error is:"+sb);
											}
											else
											{
												if(str_sysmesage_id.indexOf("|") != (-1)){
													msgIds=new StringTokenizer(str_sysmesage_id,"|");
													while(msgIds.hasMoreTokens())
													{
														messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
														sb.append((String)messageHashtable.get("message")+"<br>");
													}
												//	System.out.println("sb mesages in str_sysmesage_id is:"+sb);
												}else{
													messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
													sb.append((String)messageHashtable.get("message"));
												//	System.out.println("sb mesage in str_sysmesage_id is:"+sb);
												}
											}
										}
										if(update_cust_period_cstmt!=null)
					update_cust_period_cstmt.close(); //ADDED BY RAM FOR CHK STYLE
									}

									if(isCustPeriodUpdated_cstmt!=null)
					isCustPeriodUpdated_cstmt.close(); //ADDED BY RAM FOR CHK STYLE
								}
								else{//insert
									if(toDate==null || toDate.equals("")){
										cust_period_cstmt = con.prepareCall(cust_period_sql1);
										toDate=null;
									}else{
										cust_period_cstmt = con.prepareCall(cust_period_sql);
									}
									cust_period_cstmt.setString(1,facility_id);
									cust_period_cstmt.setString(2,packageCode);
									cust_period_cstmt.setString(3,cust_grp_code);
									cust_period_cstmt.setString(4,cust_code);
									cust_period_cstmt.setString(5,fromDate);
									cust_period_cstmt.setString(6,toDate);
									cust_period_cstmt.setString(7,pkgPriceClsCode);
									cust_period_cstmt.setString(8,oPkgPriceClsCode);
									cust_period_cstmt.setString(9,glSmry);
									cust_period_cstmt.setString(10,glSmryDisc);
									cust_period_cstmt.setString(11,user_id);
									cust_period_cstmt.setString(12,user_id);
									cust_period_cstmt.setString(13,client_ip_address);
									cust_period_cstmt.setString(14,facility_id);
									cust_period_cstmt.setString(15,client_ip_address);
									cust_period_cstmt.setString(16,facility_id);
									cust_period_cstmt.registerOutParameter(17,java.sql.Types.VARCHAR);
									cust_period_cstmt.registerOutParameter(18,java.sql.Types.VARCHAR);
									cust_period_cstmt.registerOutParameter(19,java.sql.Types.VARCHAR);
									cust_period_cstmt.setString(20,VATapp);
									cust_period_cstmt.setString(21,VATpercent);
									cust_period_cstmt.setString(22,VATruleCoverage);
									cust_period_cstmt.execute();

									str_error_level=cust_period_cstmt.getString(17);
									str_sysmesage_id=cust_period_cstmt.getString(18);
									str_error_text=cust_period_cstmt.getString(19);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
								/*	System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
									System.out.println("str_error_text in process:"+str_error_text);
									System.out.println("str_error_text in process:"+str_error_text);*/
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insert=false;
										sb.append("<br>"+str_error_text+"<br> ") ;
									}
									if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
									{
										insert=false;
										if((str_error_level.equals("10") && !str_error_text.equals("") ))
										{
											sb.append("<br>"+str_error_text+"<br> ") ;
											//System.out.println("sb mesage in Error is:"+sb);
										}
										else
										{
											if(str_sysmesage_id.indexOf("|") != (-1)){
												msgIds=new StringTokenizer(str_sysmesage_id,"|");
												while(msgIds.hasMoreTokens())
												{
													messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
													sb.append((String)messageHashtable.get("message")+"<br>");
												}
											//	System.out.println("sb mesages in str_sysmesage_id is:"+sb);
											}else{
												messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
												sb.append((String)messageHashtable.get("message"));
											//	System.out.println("sb mesage in str_sysmesage_id is:"+sb);
											}
										}
									}
								}//insert
							}//for

						}	//if
					}	//if
				}//while
				if(isCustPeriodUpdated_cstmt!=null)
					isCustPeriodUpdated_cstmt.close();
				if(update_cust_period_cstmt!=null)
					update_cust_period_cstmt.close();
				if(cust_period_cstmt!=null)
					cust_period_cstmt.close();
			}//if
		}
		catch (Exception e)
		{
			System.err.println("Exception while updating customer period details:"+e);
			e.printStackTrace();
			insert=false;
		}
		finally{
			if(isCustPeriodUpdated_cstmt!=null)
					isCustPeriodUpdated_cstmt.close();
				if(update_cust_period_cstmt!=null)
					update_cust_period_cstmt.close();
				if(cust_period_cstmt!=null)
					cust_period_cstmt.close();

		}
	/*******Update customer Period details************end********************/
	/*******Update customer Base Price details************start********************/
	try
		{
			System.out.println("9522 cust_base_price="+cust_base_price);
			System.out.println("9523 insert="+insert);
			System.out.println("9524 modify_cust_base_price="+modify_cust_base_price);
			if(insert && cust_base_price!=null && cust_base_price.size()>0 && modify_cust_base_price.equals("Y") )
			{
				System.out.println("9527 Customer Base Price details" );
				keySet=(Set<String>)cust_base_price.keySet();
				//System.out.println("keySet="+keySet.toString());
				custIt=keySet.iterator();
				/****************************/
				while(insert && custIt.hasNext()){
					key=(String)custIt.next();
					cust_price_list=(ArrayList)cust_base_price.get(key);
					if(cust_price_list!=null && cust_price_list.size()>0 ){
						stKey=new StringTokenizer(key,"~~");
						if(stKey.hasMoreTokens()){
							cust_grp_code=stKey.nextToken();
						}else{
							cust_grp_code="";
						}
						if(stKey.hasMoreTokens())
							cust_code=stKey.nextToken();
						else
							cust_code="";
						if(stKey.hasMoreTokens())
							fromDate=stKey.nextToken();
						else
							fromDate="";
						
						if(insert && !cust_grp_code.equals("") && !cust_code.equals("") && !fromDate.equals("")  && cust_dtls!=null && cust_dtls.size()>0 && cust_dtls.containsKey(cust_grp_code+"~~"+cust_code) && inserted_cust_period_list!=null && inserted_cust_period_list.size()>0 && inserted_cust_period_list.contains(cust_grp_code+"~~"+cust_code+"~~"+fromDate) ){
							for(int i=0;i<cust_price_list.size();i++){
								System.out.println("9553");
								record=new String[12];
								record=(String[])cust_price_list.get(i);
								blgClsCode		= record[0];
								blgClsDesc		= record[1];
								indicator		=record[2];
								price1		=record[3];
								roundTo	=	record[4];
								roundInd		=record[5];
								factorAppl		=record[6];
								deposit		   =record[7];
								partialDeposit =record[8];
								minDepAmtind   =record[9];
								minDepAmt	  =record[10];
								factorforServiceRate = record[11];
								existsInDB=existsInDB(cust_grp_code+"~~"+cust_code+"~~"+fromDate,record,db_cust_base_price,"CUST_PRICE");
								//System.out.println("7682");
							/*	System.out.println("facility_id="+facility_id);
								System.out.println("packageCode="+packageCode);
								System.out.println("cust_grp_code="+cust_grp_code);
								System.out.println("cust_code="+cust_code);
								System.out.println("fromDate="+fromDate);
								System.out.println("blgClsCode="+blgClsCode);
								System.out.println("blgClsDesc="+blgClsDesc);
								System.out.println("indicator="+indicator);
								System.out.println("price1="+price1);
								System.out.println("roundTo="+roundTo);
								System.out.println("roundInd="+roundInd);
								System.out.println("factorAppl="+factorAppl);
								System.out.println("deposit="+deposit);
								System.out.println("partialDeposit="+partialDeposit);
								System.out.println("minDepAmtind="+minDepAmtind);
								System.out.println("minDepAmt="+minDepAmt);
								System.out.println("existsInDB="+existsInDB);*/
								System.out.println("9587,existsInDB="+existsInDB);
								if(existsInDB){
									//chk if update is needed
							//System.out.println("7703");
									isCustPriceUpdated_cstmt.setString(1,facility_id);
									isCustPriceUpdated_cstmt.setString(2,packageCode);
									isCustPriceUpdated_cstmt.setString(3,cust_grp_code);
									isCustPriceUpdated_cstmt.setString(4,cust_code);
									isCustPriceUpdated_cstmt.setString(5,fromDate);
									isCustPriceUpdated_cstmt.setString(6,blgClsCode );
									isCustPriceUpdated_cstmt.setString(7,indicator );
									isCustPriceUpdated_cstmt.setString(8,price1 );
									isCustPriceUpdated_cstmt.setString(9,roundTo );
									isCustPriceUpdated_cstmt.setString(10,roundInd );
									isCustPriceUpdated_cstmt.setString(11,deposit );
									isCustPriceUpdated_cstmt.setString(12,partialDeposit );
									isCustPriceUpdated_cstmt.setString(13,minDepAmtind );
									isCustPriceUpdated_cstmt.setString(14,minDepAmt );
									isCustPriceUpdated_cstmt.setString(15,factorAppl );
									isCustPriceUpdated_cstmt.setString(16,factorforServiceRate);	//Added by Muthu


									isCustPriceUpdated_cstmt.registerOutParameter(17,java.sql.Types.VARCHAR);
									isCustPriceUpdated_cstmt.registerOutParameter(18,java.sql.Types.VARCHAR);
									isCustPriceUpdated_cstmt.registerOutParameter(19,java.sql.Types.VARCHAR);
									isCustPriceUpdated_cstmt.registerOutParameter(20,java.sql.Types.VARCHAR);
									//System.out.println("7725");
									isCustPriceUpdated_cstmt.execute();
									//System.out.println("7728");
									recModified=isCustPriceUpdated_cstmt.getString(17);
									str_error_level=isCustPriceUpdated_cstmt.getString(18);
									str_sysmesage_id=isCustPriceUpdated_cstmt.getString(19);
									str_error_text=isCustPriceUpdated_cstmt.getString(20);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									if(recModified == null)		recModified="";
									System.out.println("9624 recModified:"+recModified);
									System.out.println("str_error_level in process rate based insertion:"+str_error_level);
									System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
									System.out.println("str_error_text in process rate based insertion:"+str_error_text);
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										//System.out.println("7742");
										insert=false;
										sb.append("<br>"+str_error_text+"<br> ") ;
									}
									if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
									{
										//System.out.println("7748");
										insert=false;
										if((str_error_level.equals("10") && !str_error_text.equals("") ))
										{
											sb.append("<br>"+str_error_text+"<br> ") ;
											//System.out.println("sb mesage in Error is:"+sb);
										}
										else
										{
											if(str_sysmesage_id.indexOf("|") != (-1)){
												msgIds=new StringTokenizer(str_sysmesage_id,"|");
												while(msgIds.hasMoreTokens())
												{
													messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
													sb.append((String)messageHashtable.get("message")+"<br>");
												}
												//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
											}else{
												messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
												sb.append((String)messageHashtable.get("message"));
												//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
											}
										}
									}
									System.out.println("9660,insert="+insert);
									System.out.println("9660,recModified="+recModified);
									if(insert && "Y".equals(recModified)){										
						//System.out.println("7772");
										update_cust_price_cstmt.setString(1,facility_id);
										update_cust_price_cstmt.setString(2,packageCode);
										update_cust_price_cstmt.setString(3,cust_grp_code);
										update_cust_price_cstmt.setString(4,cust_code);
										update_cust_price_cstmt.setString(5,fromDate);
										update_cust_price_cstmt.setString(6,blgClsCode);
										update_cust_price_cstmt.setString(7,indicator);
										update_cust_price_cstmt.setString(8,price1);
										update_cust_price_cstmt.setString(9,roundTo);
										update_cust_price_cstmt.setString(10,roundInd);
										update_cust_price_cstmt.setString(11,deposit );
										update_cust_price_cstmt.setString(12,partialDeposit );
										update_cust_price_cstmt.setString(13,minDepAmtind );
										update_cust_price_cstmt.setString(14,minDepAmt );
										update_cust_price_cstmt.setString(15,factorAppl );
										update_cust_price_cstmt.setString(16,factorforServiceRate );//Added by muthu

										update_cust_price_cstmt.setString(17,user_id);
										update_cust_price_cstmt.setString(18,client_ip_address );
										update_cust_price_cstmt.setString(19,facility_id);
										update_cust_price_cstmt.registerOutParameter(20,java.sql.Types.VARCHAR);
										update_cust_price_cstmt.registerOutParameter(21,java.sql.Types.VARCHAR);
										update_cust_price_cstmt.registerOutParameter(22,java.sql.Types.VARCHAR);
										//System.out.println("7796");
										update_cust_price_cstmt.execute();
										//System.out.println("7798");
										str_error_level=update_cust_price_cstmt.getString(20);
										str_sysmesage_id=update_cust_price_cstmt.getString(21);
										str_error_text=update_cust_price_cstmt.getString(22);
										if(str_error_level==null) str_error_level="";
										if(str_sysmesage_id==null) str_sysmesage_id="";
										if(str_error_text==null) str_error_text="";
										/*System.out.println("str_error_level in process rate based insertion:"+str_error_level);
										System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
										System.out.println("str_error_text in process rate based insertion:"+str_error_text);*/
										if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
										{
											//System.out.println("7812");
											insert=false;
											sb.append("<br>"+str_error_text+"<br> ") ;
										}
										if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
										{
											//System.out.println("7816");
											insert=false;
											if((str_error_level.equals("10") && !str_error_text.equals("") ))
											{
												sb.append("<br>"+str_error_text+"<br> ") ;
												//System.out.println("sb mesage in Error is:"+sb);
											}
											else
											{
												//System.out.println("7824");
												if(str_sysmesage_id.indexOf("|") != (-1)){
													msgIds=new StringTokenizer(str_sysmesage_id,"|");
													while(msgIds.hasMoreTokens())
													{
														messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
														sb.append((String)messageHashtable.get("message")+"<br>");
													}
													//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
												}else{
													//System.out.println("7835");													messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
													sb.append((String)messageHashtable.get("message"));
													//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
												}
											}
										}
									}
								}
								else{//insert
								System.out.println("blpackage.insertpackagecustprice Entering 3 ");
									cust_price_cstmt.setString(1,facility_id);
									cust_price_cstmt.setString(2,packageCode);
									cust_price_cstmt.setString(3,cust_grp_code);
									cust_price_cstmt.setString(4,cust_code);
									cust_price_cstmt.setString(5,fromDate);
									cust_price_cstmt.setString(6,blgClsCode);
									cust_price_cstmt.setString(7,indicator);
									cust_price_cstmt.setString(8,price1);
									cust_price_cstmt.setString(9,roundTo);
									cust_price_cstmt.setString(10,roundInd);
									cust_price_cstmt.setString(11,deposit );
									cust_price_cstmt.setString(12,partialDeposit );
									cust_price_cstmt.setString(13,minDepAmtind );
									cust_price_cstmt.setString(14,minDepAmt );
									cust_price_cstmt.setString(15,factorAppl );
									cust_price_cstmt.setString(16,factorforServiceRate);	//Added by muthu

									cust_price_cstmt.setString(17,user_id);
									cust_price_cstmt.setString(18,user_id);
									cust_price_cstmt.setString(19,client_ip_address);
									cust_price_cstmt.setString(20,facility_id);
									cust_price_cstmt.setString(21,client_ip_address);
									cust_price_cstmt.setString(22,facility_id);
									cust_price_cstmt.registerOutParameter(23,java.sql.Types.VARCHAR);
									cust_price_cstmt.registerOutParameter(24,java.sql.Types.VARCHAR);
									cust_price_cstmt.registerOutParameter(25,java.sql.Types.VARCHAR);
									//System.out.println("blpackage.insertpackagecustprice Entering 4 ");
									cust_price_cstmt.execute();
									//System.out.println("blpackage.insertpackagecustprice Entering 5 ");
									str_error_level=cust_price_cstmt.getString(23);
									str_sysmesage_id=cust_price_cstmt.getString(24);
									str_error_text=cust_price_cstmt.getString(25);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									/*System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
									System.out.println("str_error_text in process:"+str_error_text);
									System.out.println("str_error_text in process:"+str_error_text);*/
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insert=false;
										sb.append("<br>"+str_error_text+"<br> ") ;
									}
									if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
									{
										insert=false;
										if((str_error_level.equals("10") && !str_error_text.equals("") ))
										{
											sb.append("<br>"+str_error_text+"<br> ") ;
											//System.out.println("sb mesage in Error is:"+sb);
										}
										else
										{
											if(str_sysmesage_id.indexOf("|") != (-1)){
												msgIds=new StringTokenizer(str_sysmesage_id,"|");
												while(msgIds.hasMoreTokens())
												{
													messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
													sb.append((String)messageHashtable.get("message")+"<br>");
												}
												//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
											}else{
												messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
												sb.append((String)messageHashtable.get("message"));
												//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
											}
										}
									}
								}//insert
							}//for

						}	//if
					}	//if
				}//while
			}//if
			if(isCustPriceUpdated_cstmt!=null)
				isCustPriceUpdated_cstmt.close();
			if(update_cust_price_cstmt!=null)
				update_cust_price_cstmt.close();
			if(cust_price_cstmt!=null)
				cust_price_cstmt.close();
		}
		catch (Exception e)
		{
			System.err.println("Exception while updating customer price details:"+e);
			e.printStackTrace();
			insert=false;
		}
	/*******Update customer Base Price details************end********************/
	/*******Update customer Rate Based Services detail************start********************/
	try
		{
			System.out.println("9828 insert manager cust rate "+insert);
			System.out.println("modify_cust_rate_srv manager test "+modify_cust_rate_srv);
		if(insert && modify_cust_rate_srv.equals("Y")){
			insert=deleteAllDBRecs(con,db_cust_rate_srv,cust_rate_srv,facility_id,packageCode,"CUST_RATE_BASED");
			System.out.println("9833 insert manager CUST_RATE_BASED"+insert);
			System.out.println("9833 insert manager cust_rate_srv"+cust_rate_srv);
			if(insert && cust_rate_srv!=null && cust_rate_srv.size()>0 )
			{
				//System.out.println("Rate Based Services other operations");
				keySet=(Set<String>)cust_rate_srv.keySet();
				//System.out.println("keySet="+keySet.toString());
				custIt=keySet.iterator();
				/****************************/
				while(insert && custIt.hasNext()){
					key=(String)custIt.next();
					cust_rate_srv_list=(ArrayList)cust_rate_srv.get(key);
					if(cust_rate_srv_list!=null && cust_rate_srv_list.size()>0 ){
						stKey=new StringTokenizer(key,"~~");
						if(stKey.hasMoreTokens()){
							cust_grp_code=stKey.nextToken();
						}else{
							cust_grp_code="";
						}
						if(stKey.hasMoreTokens())
							cust_code=stKey.nextToken();
						else
							cust_code="";
						if(stKey.hasMoreTokens())
							fromDate=stKey.nextToken();
						else
							fromDate="";
						System.out.println("9859 cust_rate_srv_list data manager  "+cust_rate_srv_list);
						if(insert && !cust_grp_code.equals("") && !cust_code.equals("") && !fromDate.equals("")  && cust_dtls!=null && cust_dtls.size()>0 && cust_dtls.containsKey(cust_grp_code+"~~"+cust_code)  && inserted_cust_period_list!=null && inserted_cust_period_list.size()>0 && inserted_cust_period_list.contains(cust_grp_code+"~~"+cust_code+"~~"+fromDate) ){
							for(int i=0;i<cust_rate_srv_list.size();i++){
								record=new String[7];
								record=(String[])cust_rate_srv_list.get(i);
								type		= record[0];
								service_code		= record[1];
								service_desc	=record[2];
								System.out.println("service_desc 9867 data manager  "+service_desc);
								catalog_code		=record[3];
								catalog_desc			= record[4];
								System.out.println("catalog_desc 9868 data manager  "+catalog_desc);
								ind		= record[5];
								factorOrRate		= record[6];
								qty_limit		=record[7];
								amt_limit_ind	=record[8];
								amt_limit		= record[9];
								replace		= record[10];
								if(replace==null || replace.equals("") || replace.equals("null"))
									replace="N";
								replaceSrv_code= record[11];
								replaceSrv_desc		= record[12];
								replaceSrv_cat_code		=record[13];
								replaceSrv_cat_desc	= record[14];
								refund		=record[15];
								if(refund==null || refund.equals("") || refund.equals("null"))
									refund="N";
								refundAmt		= record[16];
								autoRefund		= record[17];
								factor_appl		= record[18];
								roundTo			= record[19];
								roundInd		= record[20];
								closePkg		=record[21];
								splitReqd	  =	record[22];//Split reqd
								includeHomeMedication=	record[23];
								dailyLmtChkBx = record[25];//Added V190320-Aravindh/MMS-DM-CRF-0129
								dailyLmtAmt = record[26];//Added V190320-Aravindh/MMS-DM-CRF-0129
								dailyLmtGrossNet = record[27];//Added V190320-Aravindh/MMS-DM-CRF-0129
								if(null == dailyLmtGrossNet || "".equals(dailyLmtGrossNet)) {
									dailyLmtGrossNet = "G";
								}//Added V190320-Aravindh/MMS-DM-CRF-0129
								dailyLmtIndicator = record[28];//Added V190626-Aravindh/MMS-DM-CRF-0129.1
								if("*".equals(dailyLmtIndicator)){
									dailyLmtIndicator = "";
								}//Added V190626-Aravindh/MMS-DM-CRF-0129.1
								dailyLmtQty = record[29];//Added V190626-Aravindh/MMS-DM-CRF-0129.1
								serv_grp_limit_ind = record[30]; //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
								existsInDB=existsInDB(cust_grp_code+"~~"+cust_code+"~~"+fromDate,record,db_cust_rate_srv,"CUST_RATE_BASED");
								inserted_cust_rate_srv_list.add(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim()+"~~"+service_code.trim());
								System.out.println("inserted_cust_rate_srv_list 9908 data manager  "+inserted_cust_rate_srv_list);
								/*System.out.println("facility_id="+facility_id);
								System.out.println("packageCode="+packageCode);
								System.out.println("cust_grp_code="+cust_grp_code);
								System.out.println("cust_code="+cust_code);
								System.out.println("type="+type);
								System.out.println("service_code="+service_code);
								System.out.println("service_desc="+service_desc);
								System.out.println("catalog_code="+catalog_code);
								System.out.println("catalog_desc="+catalog_desc);
								System.out.println("ind="+ind);
								System.out.println("factorOrRate="+factorOrRate);
								System.out.println("qty_limit="+qty_limit);
								System.out.println("amt_limit_ind="+amt_limit_ind);
								System.out.println("amt_limit="+amt_limit);
								System.out.println("replace="+replace);
								System.out.println("replaceSrv_code="+replaceSrv_code);
								System.out.println("replaceSrv_desc="+replaceSrv_desc);
								System.out.println("replaceSrv_cat_code="+replaceSrv_cat_code);
								System.out.println("replaceSrv_cat_desc="+replaceSrv_cat_desc);
								System.out.println("refund="+refund);
								System.out.println("refundAmt="+refundAmt);
								System.out.println("autoRefund="+autoRefund);
								System.out.println("factor_appl="+factor_appl);
								System.out.println("roundTo="+roundTo);
								System.out.println("roundInd="+roundInd);
								System.out.println("closePkg="+closePkg);
								System.out.println("existsInDB="+existsInDB);*/
								System.out.println("9936 existsInDB ="+existsInDB);
								if(existsInDB){
									//chk if update is needed
									System.out.println("service_code 9902 moana="+service_code);
									System.out.println("catalog_code 9902 moana="+catalog_code);
									isCustRateSrvUpdated_cstmt.setString(1,facility_id);
									isCustRateSrvUpdated_cstmt.setString(2,packageCode);
									isCustRateSrvUpdated_cstmt.setString(3,cust_grp_code);
									isCustRateSrvUpdated_cstmt.setString(4,cust_code);
									isCustRateSrvUpdated_cstmt.setString(5,fromDate);
									isCustRateSrvUpdated_cstmt.setString(6,service_code );
									isCustRateSrvUpdated_cstmt.setString(7,type );
									isCustRateSrvUpdated_cstmt.setString(8,"R" );
									isCustRateSrvUpdated_cstmt.setString(9,catalog_code );
									isCustRateSrvUpdated_cstmt.setString(10,ind );
									isCustRateSrvUpdated_cstmt.setString(11,factorOrRate );
									isCustRateSrvUpdated_cstmt.setString(12,qty_limit );
									isCustRateSrvUpdated_cstmt.setString(13,amt_limit );
									isCustRateSrvUpdated_cstmt.setString(14,amt_limit_ind );
									isCustRateSrvUpdated_cstmt.setString(15,replace );
									isCustRateSrvUpdated_cstmt.setString(16,replaceSrv_code );
									isCustRateSrvUpdated_cstmt.setString(17,replaceSrv_cat_code );
									isCustRateSrvUpdated_cstmt.setString(18,refund );
									isCustRateSrvUpdated_cstmt.setString(19,refundAmt );
									isCustRateSrvUpdated_cstmt.setString(20,autoRefund );
									isCustRateSrvUpdated_cstmt.setString(21,closePkg );
									isCustRateSrvUpdated_cstmt.setString(22,roundTo );
									isCustRateSrvUpdated_cstmt.setString(23,roundInd );
									isCustRateSrvUpdated_cstmt.setString(24,factor_appl );
									isCustRateSrvUpdated_cstmt.setString(25,splitReqd); //Split reqd - For Validation
									isCustRateSrvUpdated_cstmt.setString(26,includeHomeMedication); 
									isCustRateSrvUpdated_cstmt.registerOutParameter(27,java.sql.Types.VARCHAR);
									isCustRateSrvUpdated_cstmt.registerOutParameter(28,java.sql.Types.VARCHAR);
									isCustRateSrvUpdated_cstmt.registerOutParameter(29,java.sql.Types.VARCHAR);
									isCustRateSrvUpdated_cstmt.registerOutParameter(30,java.sql.Types.VARCHAR);
									isCustRateSrvUpdated_cstmt.setString(31,dailyLmtChkBx);//Added V190320-Aravindh/MMS-DM-CRF-0129
									isCustRateSrvUpdated_cstmt.setString(32,dailyLmtAmt);//Added V190320-Aravindh/MMS-DM-CRF-0129
									isCustRateSrvUpdated_cstmt.setString(33,dailyLmtGrossNet);//Added V190320-Aravindh/MMS-DM-CRF-0129
									isCustRateSrvUpdated_cstmt.setString(34,dailyLmtIndicator);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
									isCustRateSrvUpdated_cstmt.setString(35,dailyLmtQty);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
									isCustRateSrvUpdated_cstmt.execute();

									recModified=isCustRateSrvUpdated_cstmt.getString(27);
									str_error_level=isCustRateSrvUpdated_cstmt.getString(28);
									str_sysmesage_id=isCustRateSrvUpdated_cstmt.getString(29);					
									str_error_text=isCustRateSrvUpdated_cstmt.getString(30);
									System.out.println("recModified 9902 moana="+recModified);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									if(recModified == null)		recModified="";
									/*System.out.println("recModified:"+recModified);
									System.out.println("str_error_level in process rate based insertion:"+str_error_level);
									System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
									System.out.println("str_error_text in process rate based insertion:"+str_error_text);*/
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insert=false;
										sb.append("<br>"+str_error_text+"<br> ") ;
									}
									if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
									{
										insert=false;
										if((str_error_level.equals("10") && !str_error_text.equals("") ))
										{
											sb.append("<br>"+str_error_text+"<br> ") ;
											//System.out.println("sb mesage in Error is:"+sb);
										}
										else
										{
											if(str_sysmesage_id.indexOf("|") != (-1)){
												msgIds=new StringTokenizer(str_sysmesage_id,"|");
												while(msgIds.hasMoreTokens())
												{
													messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
													sb.append((String)messageHashtable.get("message")+"<br>");
												}
												//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
											}else{
												messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
												sb.append((String)messageHashtable.get("message"));
												//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
											}
										}
									}
									System.out.println("insert="+insert);
									System.out.println("recModified 9984 moana="+recModified);
									if(insert && "Y".equals(recModified)){				
										System.out.println("service_code 9986 moana="+service_code);
										update_cust_rate_srv_cstmt.setString(1,facility_id);
										update_cust_rate_srv_cstmt.setString(2,packageCode);
										update_cust_rate_srv_cstmt.setString(3,cust_grp_code);
										update_cust_rate_srv_cstmt.setString(4,cust_code);
										update_cust_rate_srv_cstmt.setString(5,fromDate);
										update_cust_rate_srv_cstmt.setString(6,service_code );
										update_cust_rate_srv_cstmt.setString(7,type );
										update_cust_rate_srv_cstmt.setString(8,"R" );
										update_cust_rate_srv_cstmt.setString(9,catalog_code );
										update_cust_rate_srv_cstmt.setString(10,ind );
										update_cust_rate_srv_cstmt.setString(11,factorOrRate );
										update_cust_rate_srv_cstmt.setString(12,qty_limit );
										update_cust_rate_srv_cstmt.setString(13,amt_limit );
										update_cust_rate_srv_cstmt.setString(14,amt_limit_ind );
										update_cust_rate_srv_cstmt.setString(15,replace );
										update_cust_rate_srv_cstmt.setString(16,replaceSrv_code );
										update_cust_rate_srv_cstmt.setString(17,replaceSrv_cat_code );
										update_cust_rate_srv_cstmt.setString(18,refund );
										update_cust_rate_srv_cstmt.setString(19,refundAmt );
										update_cust_rate_srv_cstmt.setString(20,autoRefund );
										update_cust_rate_srv_cstmt.setString(21,closePkg );
										update_cust_rate_srv_cstmt.setString(22,roundTo );
										update_cust_rate_srv_cstmt.setString(23,roundInd );
										update_cust_rate_srv_cstmt.setString(24,factor_appl );
										update_cust_rate_srv_cstmt.setString(25,user_id);
										update_cust_rate_srv_cstmt.setString(26,client_ip_address );
										update_cust_rate_srv_cstmt.setString(27,facility_id);
										update_cust_rate_srv_cstmt.setString(28,splitReqd);//RRRR	
										update_cust_rate_srv_cstmt.setString(29,includeHomeMedication);
										update_cust_rate_srv_cstmt.registerOutParameter(30,java.sql.Types.VARCHAR);
										update_cust_rate_srv_cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
										update_cust_rate_srv_cstmt.registerOutParameter(32,java.sql.Types.VARCHAR);
										update_cust_rate_srv_cstmt.setString(33,dailyLmtChkBx);//Added V190320-Aravindh/MMS-DM-CRF-0129
										update_cust_rate_srv_cstmt.setString(34,dailyLmtAmt);//Added V190320-Aravindh/MMS-DM-CRF-0129
										update_cust_rate_srv_cstmt.setString(35,dailyLmtGrossNet);//Added V190320-Aravindh/MMS-DM-CRF-0129
										update_cust_rate_srv_cstmt.setString(36,dailyLmtIndicator);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
										update_cust_rate_srv_cstmt.setString(37,dailyLmtQty);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
										update_cust_rate_srv_cstmt.execute();

										str_error_level=update_cust_rate_srv_cstmt.getString(30);
										str_sysmesage_id=update_cust_rate_srv_cstmt.getString(31);					
										str_error_text=update_cust_rate_srv_cstmt.getString(32);
										if(str_error_level==null) str_error_level="";
										if(str_sysmesage_id==null) str_sysmesage_id="";
										if(str_error_text==null) str_error_text="";
										/*System.out.println("str_error_level in process rate based insertion:"+str_error_level);
										System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
										System.out.println("str_error_text in process rate based insertion:"+str_error_text);*/
										if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
										{
											insert=false;
											sb.append("<br>"+str_error_text+"<br> ") ;
										}
										if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
										{
											insert=false;
											if((str_error_level.equals("10") && !str_error_text.equals("") ))
											{
												sb.append("<br>"+str_error_text+"<br> ") ;
												//System.out.println("sb mesage in Error is:"+sb);
											}
											else
											{
												if(str_sysmesage_id.indexOf("|") != (-1)){
													msgIds=new StringTokenizer(str_sysmesage_id,"|");
													while(msgIds.hasMoreTokens())
													{
														messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
														sb.append((String)messageHashtable.get("message")+"<br>");
													}
													//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
												}else{
													messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
													sb.append((String)messageHashtable.get("message"));
													//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
												}
											}
										}
									}
								}
								else{//insert
								System.out.println("insert condn 10069 moana=");
								System.out.println("service_code 10069 moana="+service_code);
									cust_rate_srv_cstmt.setString(1,facility_id);
									cust_rate_srv_cstmt.setString(2,packageCode);
									cust_rate_srv_cstmt.setString(3,cust_grp_code);
									cust_rate_srv_cstmt.setString(4,cust_code);
									cust_rate_srv_cstmt.setString(5,fromDate);
									cust_rate_srv_cstmt.setString(6,service_code);
									cust_rate_srv_cstmt.setString(7,type);
									cust_rate_srv_cstmt.setString(8,"R");
									cust_rate_srv_cstmt.setString(9,catalog_code);
									cust_rate_srv_cstmt.setString(10,ind);
									cust_rate_srv_cstmt.setString(11,factorOrRate);
									cust_rate_srv_cstmt.setString(12,qty_limit);
									cust_rate_srv_cstmt.setString(13,amt_limit);
									cust_rate_srv_cstmt.setString(14,amt_limit_ind);
									cust_rate_srv_cstmt.setString(15,replace);
									cust_rate_srv_cstmt.setString(16,replaceSrv_code);
									cust_rate_srv_cstmt.setString(17,replaceSrv_cat_code);
									cust_rate_srv_cstmt.setString(18,refund);
									cust_rate_srv_cstmt.setString(19,refundAmt);
									cust_rate_srv_cstmt.setString(20,autoRefund);
									cust_rate_srv_cstmt.setString(21,closePkg);
									cust_rate_srv_cstmt.setString(22,roundTo);
									cust_rate_srv_cstmt.setString(23,roundInd);
									cust_rate_srv_cstmt.setString(24,factor_appl);
									cust_rate_srv_cstmt.setString(25,user_id);
									cust_rate_srv_cstmt.setString(26,user_id);
									cust_rate_srv_cstmt.setString(27,client_ip_address);
									cust_rate_srv_cstmt.setString(28,facility_id);
									cust_rate_srv_cstmt.setString(29,client_ip_address);
									cust_rate_srv_cstmt.setString(30,facility_id);
									cust_rate_srv_cstmt.setString(31,splitReqd);//RRRR	
									cust_rate_srv_cstmt.setString(32,includeHomeMedication);
									cust_rate_srv_cstmt.registerOutParameter(33,java.sql.Types.VARCHAR);
									cust_rate_srv_cstmt.registerOutParameter(34,java.sql.Types.VARCHAR);
									cust_rate_srv_cstmt.registerOutParameter(35,java.sql.Types.VARCHAR);
									cust_rate_srv_cstmt.setString(36,dailyLmtChkBx);//Added V190320-Aravindh/MMS-DM-CRF-0129
									cust_rate_srv_cstmt.setString(37,dailyLmtAmt);//Added V190320-Aravindh/MMS-DM-CRF-0129	
									cust_rate_srv_cstmt.setString(38,dailyLmtGrossNet);//Added V190320-Aravindh/MMS-DM-CRF-0129
									cust_rate_srv_cstmt.setString(39,dailyLmtIndicator);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
									cust_rate_srv_cstmt.setString(40,dailyLmtQty);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
									cust_rate_srv_cstmt.setString(41,serv_grp_limit_ind);//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
									cust_rate_srv_cstmt.execute();

									str_error_level=cust_rate_srv_cstmt.getString(33);
									str_sysmesage_id=cust_rate_srv_cstmt.getString(34);					
									str_error_text=cust_rate_srv_cstmt.getString(35);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									/*System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
									System.out.println("str_error_level in process:"+str_error_level);
									System.out.println("str_error_text in process:"+str_error_text);*/
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insert=false;
										sb.append("<br>"+str_error_text+"<br> ") ;
									}
									if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
									{
										insert=false;
										if((str_error_level.equals("10") && !str_error_text.equals("") ))
										{
											sb.append("<br>"+str_error_text+"<br> ") ;
											//System.out.println("sb mesage in Error is:"+sb);
										}
										else
										{
											if(str_sysmesage_id.indexOf("|") != (-1)){
												msgIds=new StringTokenizer(str_sysmesage_id,"|");
												while(msgIds.hasMoreTokens())
												{
													messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
													sb.append((String)messageHashtable.get("message")+"<br>");
												}
												//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
											}else{
												messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
												sb.append((String)messageHashtable.get("message"));
												//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
											}
										}
									}
								}//insert
								if(insert==false) break;  // Karthikk added the below comment for Screen Hanging Issue MMS-DM-SCF-0296 61560
							}//for

						}	//if
					}	//if
				}//while
				if(isCustRateSrvUpdated_cstmt!=null){
					isCustRateSrvUpdated_cstmt.close();
				}if(update_cust_rate_srv_cstmt!=null){
					update_cust_rate_srv_cstmt.close();
				}if(cust_rate_srv_cstmt!=null){
					cust_rate_srv_cstmt.close();
					}
			}//if
			}
		}
		catch (Exception e)
		{
			System.err.println("Exception while updating customer rate based services details:"+e);
			e.printStackTrace();
			insert=false;
		}
	//System.out.println("Karthikk Update customer Rate Based Services details 1 modify_cust_rate_srv_excl=" + modify_cust_rate_srv_excl);
	/*******Update customer Rate Based Services details************end********************/
		/*******Update customer Rate Based Services Excl detail************start********************/
	try
		{
		if(insert && modify_cust_rate_srv_excl.equals("Y")){
			insert=deleteAllDBRecs(con,db_cust_rate_srv_excl,cust_rate_srv_excl,facility_id,packageCode,"CUST_SRVLIMIT_RATE_BASED");
			if(insert && cust_rate_srv_excl!=null && cust_rate_srv_excl.size()>0 )
			{
				//System.out.println("Rate Based Services Excl other operations");
				keySet=(Set<String>)cust_rate_srv_excl.keySet();
				//System.out.println("keySet="+keySet.toString());
				custIt=keySet.iterator();
				/****************************/
				while(insert && custIt.hasNext()){
					key=(String)custIt.next();
					cust_rate_srv_excl_list=(ArrayList)cust_rate_srv_excl.get(key);
					if(cust_rate_srv_excl_list!=null && cust_rate_srv_excl_list.size()>0 ){
						stKey=new StringTokenizer(key,"~~");
						if(stKey.hasMoreTokens()){
							cust_grp_code=stKey.nextToken();
						}else{
							cust_grp_code="";
						}
						if(stKey.hasMoreTokens())
							cust_code=stKey.nextToken();
						else
							cust_code="";
						if(stKey.hasMoreTokens())
							fromDate=stKey.nextToken();
						else
							fromDate="";
						if(stKey.hasMoreTokens())
							parent_service_code=stKey.nextToken();
						else
							parent_service_code="";
						if(insert && !cust_grp_code.equals("") && !cust_code.equals("") && !fromDate.equals("") && !parent_service_code.equals("")  && cust_dtls!=null && cust_dtls.size()>0 && cust_dtls.containsKey(cust_grp_code+"~~"+cust_code)  && inserted_cust_period_list!=null && inserted_cust_period_list.size()>0 && inserted_cust_period_list.contains(cust_grp_code+"~~"+cust_code+"~~"+fromDate) && inserted_cust_rate_srv_list!=null && inserted_cust_rate_srv_list.size()>0 && inserted_cust_rate_srv_list.contains(cust_grp_code+"~~"+cust_code+"~~"+fromDate+"~~"+parent_service_code) ){
							for(int i=0;i<cust_rate_srv_excl_list.size();i++){
								record=new String[16];
								record=(String[])cust_rate_srv_excl_list.get(i);
								srvLimit_type		= record[0];
								srvLimit_service_code		= record[1];
								srvLimit_service_desc	=record[2];
								exludeService		=record[3];
								if(exludeService==null || exludeService.equals("") || exludeService.equals("null"))
									exludeService="N";
								srvLimit_qty_limit			= record[4];
								srvLimit_amt_limit_ind	= record[5];
								srvLimit_amt_limit		= record[6];
								srvLimit_roundTo		= record[7];
								srvLimit_roundInd= record[8];
								srvLimit_replace		= record[9];
								srvLimit_replaceSrv_code		=record[10];
								srvLimit_replaceSrv_desc		=record[11];
								srvLimit_refund	= record[12];
								srvLimit_refundAmt		=record[13];
								srvLimit_auto_refund		=record[14];
								srvLimit_factor_appl		=record[15];
								splitReqd	  =	record[16];//Split reqd
								includeHomeMedication	  =	record[17];
								//Added V190320-Aravindh/MMS-DM-CRF-0129/Starts
								dailyLmtChkBx = record[19];
								dailyLmtAmt = record[20];
								dailyLmtGrossNet = record[21];
								if(null == dailyLmtChkBx || "".equals(dailyLmtChkBx)) {
									dailyLmtChkBx = "N";
								}
								if(null == dailyLmtGrossNet && "".equals(dailyLmtGrossNet)) {
									dailyLmtGrossNet = "G";
								}
								//Added V190320-Aravindh/MMS-DM-CRF-0129/Ends
								dailyLmtIndicator = record[22];//Added V190626-Aravindh/MMS-DM-CRF-0129.1
								if("*".equals(dailyLmtIndicator)){
									dailyLmtIndicator = "";
								}//Added V190626-Aravindh/MMS-DM-CRF-0129.1
								dailyLmtQty = record[23];//Added V190626-Aravindh/MMS-DM-CRF-0129.1
						/*System.out.println("facility_id="+facility_id);
						System.out.println("packageCode="+packageCode);
						System.out.println("cust_grp_code="+cust_grp_code);
						System.out.println("cust_code="+cust_code);
						System.out.println("fromDate="+fromDate);
						System.out.println("parent_service_code="+parent_service_code);
						System.out.println("srvLimit_service_code="+srvLimit_service_code);
						System.out.println("srvLimit_type="+srvLimit_type);
						System.out.println("exludeService="+exludeService);
						System.out.println("srvLimit_amt_limit_ind="+srvLimit_amt_limit_ind);
						System.out.println("srvLimit_qty_limit="+srvLimit_qty_limit);
						System.out.println("srvLimit_amt_limit="+srvLimit_amt_limit);
						System.out.println("srvLimit_replace="+srvLimit_replace);
						System.out.println("srvLimit_replaceSrv_code="+srvLimit_replaceSrv_code);
						System.out.println("srvLimit_refund="+srvLimit_refund);
						System.out.println("srvLimit_refundAmt="+srvLimit_refundAmt);
						System.out.println("srvLimit_auto_refund="+srvLimit_auto_refund);
						System.out.println("srvLimit_roundTo="+srvLimit_roundTo);
						System.out.println("srvLimit_roundInd="+srvLimit_roundInd);
						System.out.println("srvLimit_factor_appl="+srvLimit_factor_appl);
						System.out.println("user_id="+user_id);
						System.out.println("client_ip_address="+client_ip_address);*/

								existsInDB=existsInDB(cust_grp_code+"~~"+cust_code+"~~"+fromDate+"~~"+parent_service_code,record,db_cust_rate_srv_excl,"CUST_SRVLIMIT_RATE_BASED");

								//System.out.println("existsInDB="+existsInDB);
								if(existsInDB){
									//chk if update is needed
									isCustRateExclUpdated_cstmt.setString(1,facility_id);
									isCustRateExclUpdated_cstmt.setString(2,packageCode);
									isCustRateExclUpdated_cstmt.setString(3,cust_grp_code);
									isCustRateExclUpdated_cstmt.setString(4,cust_code);
									isCustRateExclUpdated_cstmt.setString(5,fromDate);
									isCustRateExclUpdated_cstmt.setString(6,parent_service_code );
									//Karthik added Service Type - 26/07/2016  MMS-DM-SCF-0248	
									//isCustRateExclUpdated_cstmt.setString(7,"" );
									String service_type=getType(cust_rate_srv,cust_rate_srv_list,parent_service_code);
									isCustRateExclUpdated_cstmt.setString(7,service_type);
									isCustRateExclUpdated_cstmt.setString(8,"R" );
									isCustRateExclUpdated_cstmt.setString(9,srvLimit_service_code );
									isCustRateExclUpdated_cstmt.setString(10,srvLimit_type );
									isCustRateExclUpdated_cstmt.setString(11,exludeService );
									isCustRateExclUpdated_cstmt.setString(12,srvLimit_amt_limit_ind );
									isCustRateExclUpdated_cstmt.setString(13,srvLimit_qty_limit );
									isCustRateExclUpdated_cstmt.setString(14,srvLimit_amt_limit );
									isCustRateExclUpdated_cstmt.setString(15,srvLimit_replace );
									isCustRateExclUpdated_cstmt.setString(16,srvLimit_replaceSrv_code );
									isCustRateExclUpdated_cstmt.setString(17,srvLimit_refund );
									isCustRateExclUpdated_cstmt.setString(18,srvLimit_refundAmt );
									isCustRateExclUpdated_cstmt.setString(19,srvLimit_auto_refund );
									isCustRateExclUpdated_cstmt.setString(20,srvLimit_roundTo );
									isCustRateExclUpdated_cstmt.setString(21,srvLimit_roundInd );
									isCustRateExclUpdated_cstmt.setString(22,srvLimit_factor_appl );
									isCustRateExclUpdated_cstmt.setString(23,splitReqd );//Split reqd - For validation	
									isCustRateExclUpdated_cstmt.setString(24,includeHomeMedication );	
									isCustRateExclUpdated_cstmt.registerOutParameter(25,java.sql.Types.VARCHAR);
									isCustRateExclUpdated_cstmt.registerOutParameter(26,java.sql.Types.VARCHAR);
									isCustRateExclUpdated_cstmt.registerOutParameter(27,java.sql.Types.VARCHAR);
									isCustRateExclUpdated_cstmt.registerOutParameter(28,java.sql.Types.VARCHAR);
									isCustRateExclUpdated_cstmt.setString(29,dailyLmtChkBx);//Added V190320-Aravindh/MMS-DM-CRF-0129
									isCustRateExclUpdated_cstmt.setString(30,dailyLmtAmt);//Added V190320-Aravindh/MMS-DM-CRF-0129	
									isCustRateExclUpdated_cstmt.setString(31,dailyLmtGrossNet);//Added V190320-Aravindh/MMS-DM-CRF-0129
									isCustRateExclUpdated_cstmt.setString(32,dailyLmtIndicator);//Added V190626-Aravindh/MMS-DM-CRF-0129.1	
									isCustRateExclUpdated_cstmt.setString(33,dailyLmtQty);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
									isCustRateExclUpdated_cstmt.execute();

									recModified=isCustRateExclUpdated_cstmt.getString(25);
									str_error_level=isCustRateExclUpdated_cstmt.getString(26);
									str_sysmesage_id=isCustRateExclUpdated_cstmt.getString(27);					
									str_error_text=isCustRateExclUpdated_cstmt.getString(28);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									if(recModified == null)		recModified="";
									/*System.out.println("recModified:"+recModified);
									System.out.println("str_error_level in process rate based insertion:"+str_error_level);
									System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
									System.out.println("str_error_text in process rate based insertion:"+str_error_text);*/
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insert=false;
										sb.append("<br>"+str_error_text+"<br> ") ;
									}
									if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
									{
										insert=false;
										if((str_error_level.equals("10") && !str_error_text.equals("") ))
										{
											sb.append("<br>"+str_error_text+"<br> ") ;
											//System.out.println("sb mesage in Error is:"+sb);
										}
										else
										{
											if(str_sysmesage_id.indexOf("|") != (-1)){
												msgIds=new StringTokenizer(str_sysmesage_id,"|");
												while(msgIds.hasMoreTokens())
												{
													messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
													sb.append((String)messageHashtable.get("message")+"<br>");
												}
												//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
											}else{
												messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
												sb.append((String)messageHashtable.get("message"));
												//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
											}
										}
									}
									//System.out.println("insert="+insert);
									if(insert && "Y".equals(recModified)){	

										update_cust_rate_srv_excl_cstmt.setString(1,facility_id);
										update_cust_rate_srv_excl_cstmt.setString(2,packageCode);
										update_cust_rate_srv_excl_cstmt.setString(3,cust_grp_code);
										update_cust_rate_srv_excl_cstmt.setString(4,cust_code);
										update_cust_rate_srv_excl_cstmt.setString(5,fromDate);
										update_cust_rate_srv_excl_cstmt.setString(6,parent_service_code );
										//Karthik added Service Type -26/07/2016  MMS-DM-SCF-0248	
         								String service_type_upd=getType(cust_rate_srv,cust_rate_srv_list,parent_service_code);
										update_cust_rate_srv_excl_cstmt.setString(7,service_type_upd);
										update_cust_rate_srv_excl_cstmt.setString(8,"R" );
										update_cust_rate_srv_excl_cstmt.setString(9,srvLimit_service_code );
										update_cust_rate_srv_excl_cstmt.setString(10,srvLimit_type );
										update_cust_rate_srv_excl_cstmt.setString(11,exludeService );
										update_cust_rate_srv_excl_cstmt.setString(12,srvLimit_amt_limit_ind );
										update_cust_rate_srv_excl_cstmt.setString(13,srvLimit_qty_limit );
										update_cust_rate_srv_excl_cstmt.setString(14,srvLimit_amt_limit );
										update_cust_rate_srv_excl_cstmt.setString(15,srvLimit_replace );
										update_cust_rate_srv_excl_cstmt.setString(16,srvLimit_replaceSrv_code );
										update_cust_rate_srv_excl_cstmt.setString(17,srvLimit_refund );
										update_cust_rate_srv_excl_cstmt.setString(18,srvLimit_refundAmt );
										update_cust_rate_srv_excl_cstmt.setString(19,srvLimit_auto_refund );
										update_cust_rate_srv_excl_cstmt.setString(20,srvLimit_roundTo );
										update_cust_rate_srv_excl_cstmt.setString(21,srvLimit_roundInd );
										update_cust_rate_srv_excl_cstmt.setString(22,srvLimit_factor_appl );
										update_cust_rate_srv_excl_cstmt.setString(23,user_id);
										update_cust_rate_srv_excl_cstmt.setString(24,client_ip_address );
										update_cust_rate_srv_excl_cstmt.setString(25,facility_id);
										update_cust_rate_srv_excl_cstmt.setString(26,splitReqd);//RRRR	
										update_cust_rate_srv_excl_cstmt.setString(27,includeHomeMedication);
										update_cust_rate_srv_excl_cstmt.registerOutParameter(28,java.sql.Types.VARCHAR);
										update_cust_rate_srv_excl_cstmt.registerOutParameter(29,java.sql.Types.VARCHAR);
										update_cust_rate_srv_excl_cstmt.registerOutParameter(30,java.sql.Types.VARCHAR);
										update_cust_rate_srv_excl_cstmt.setString(31,dailyLmtChkBx);//Added V190320-Aravindh/MMS-DM-CRF-0129
										update_cust_rate_srv_excl_cstmt.setString(32,dailyLmtAmt);//Added V190320-Aravindh/MMS-DM-CRF-0129	
										update_cust_rate_srv_excl_cstmt.setString(33,dailyLmtGrossNet);//Added V190320-Aravindh/MMS-DM-CRF-0129
										update_cust_rate_srv_excl_cstmt.setString(34,dailyLmtIndicator);//Added V190626-Aravindh/MMS-DM-CRF-0129.1	
										update_cust_rate_srv_excl_cstmt.setString(35,dailyLmtQty);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
										update_cust_rate_srv_excl_cstmt.execute();

										str_error_level=update_cust_rate_srv_excl_cstmt.getString(28);
										str_sysmesage_id=update_cust_rate_srv_excl_cstmt.getString(29);					
										str_error_text=update_cust_rate_srv_excl_cstmt.getString(30);
										if(str_error_level==null) str_error_level="";
										if(str_sysmesage_id==null) str_sysmesage_id="";
										if(str_error_text==null) str_error_text="";
										//System.out.println("str_error_level in process rate based insertion:"+str_error_level);
										//System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
										//System.out.println("str_error_text in process rate based insertion:"+str_error_text);
										if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
										{
											insert=false;
											sb.append("<br>"+str_error_text+"<br> ") ;
										}
										if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
										{
											insert=false;
											if((str_error_level.equals("10") && !str_error_text.equals("") ))
											{
												sb.append("<br>"+str_error_text+"<br> ") ;
												//System.out.println("sb mesage in Error is:"+sb);
											}
											else
											{
												if(str_sysmesage_id.indexOf("|") != (-1)){
													msgIds=new StringTokenizer(str_sysmesage_id,"|");
													while(msgIds.hasMoreTokens())
													{
														messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
														sb.append((String)messageHashtable.get("message")+"<br>");
													}
													//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
												}else{
													messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
													sb.append((String)messageHashtable.get("message"));
													//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
												}
											}
										}
									}
								}
								else{//insert
									cust_rate_srv_excl_cstmt.setString(1,facility_id);
									cust_rate_srv_excl_cstmt.setString(2,packageCode);
									cust_rate_srv_excl_cstmt.setString(3,cust_grp_code);
									cust_rate_srv_excl_cstmt.setString(4,cust_code);
									cust_rate_srv_excl_cstmt.setString(5,fromDate);
									cust_rate_srv_excl_cstmt.setString(6,parent_service_code);
									//Karthik added Service Type - 26/07/2016  MMS-DM-SCF-0248	
									String service_type=getType(cust_rate_srv,cust_rate_srv_list,parent_service_code);
									cust_rate_srv_excl_cstmt.setString(7,service_type);
									cust_rate_srv_excl_cstmt.setString(8,"R");
									cust_rate_srv_excl_cstmt.setString(9,srvLimit_service_code);
									cust_rate_srv_excl_cstmt.setString(10,srvLimit_type);
									cust_rate_srv_excl_cstmt.setString(11,exludeService);
									cust_rate_srv_excl_cstmt.setString(12,srvLimit_amt_limit_ind);
									cust_rate_srv_excl_cstmt.setString(13,srvLimit_qty_limit);
									cust_rate_srv_excl_cstmt.setString(14,srvLimit_amt_limit);
									cust_rate_srv_excl_cstmt.setString(15,srvLimit_replace);
									cust_rate_srv_excl_cstmt.setString(16,srvLimit_replaceSrv_code);
									cust_rate_srv_excl_cstmt.setString(17,srvLimit_refund);
									cust_rate_srv_excl_cstmt.setString(18,srvLimit_refundAmt);
									cust_rate_srv_excl_cstmt.setString(19,srvLimit_auto_refund);
									cust_rate_srv_excl_cstmt.setString(20,srvLimit_roundTo);
									cust_rate_srv_excl_cstmt.setString(21,srvLimit_roundInd);
									cust_rate_srv_excl_cstmt.setString(22,srvLimit_factor_appl);
									cust_rate_srv_excl_cstmt.setString(23,user_id);
									cust_rate_srv_excl_cstmt.setString(24,user_id);
									cust_rate_srv_excl_cstmt.setString(25,client_ip_address);
									cust_rate_srv_excl_cstmt.setString(26,facility_id);
									cust_rate_srv_excl_cstmt.setString(27,client_ip_address);
									cust_rate_srv_excl_cstmt.setString(28,facility_id);
									cust_rate_srv_excl_cstmt.setString(29,splitReqd);//RRRR	
									cust_rate_srv_excl_cstmt.setString(30,includeHomeMedication);
									cust_rate_srv_excl_cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
									cust_rate_srv_excl_cstmt.registerOutParameter(32,java.sql.Types.VARCHAR);
									cust_rate_srv_excl_cstmt.registerOutParameter(33,java.sql.Types.VARCHAR);
									cust_rate_srv_excl_cstmt.setString(34,dailyLmtChkBx);//Added V190320-Aravindh/MMS-DM-CRF-0129
									cust_rate_srv_excl_cstmt.setString(35,dailyLmtAmt);//Added V190320-Aravindh/MMS-DM-CRF-0129	
									cust_rate_srv_excl_cstmt.setString(36,dailyLmtGrossNet);//Added V190320-Aravindh/MMS-DM-CRF-0129
									cust_rate_srv_excl_cstmt.setString(37,dailyLmtIndicator);//Added V190626-Aravindh/MMS-DM-CRF-0129.1	
									cust_rate_srv_excl_cstmt.setString(38,dailyLmtQty);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
									cust_rate_srv_excl_cstmt.execute();

									str_error_level=cust_rate_srv_excl_cstmt.getString(31);
									str_sysmesage_id=cust_rate_srv_excl_cstmt.getString(32);					
									str_error_text=cust_rate_srv_excl_cstmt.getString(33);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									/*System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
									System.out.println("str_error_level in process:"+str_error_level);
									System.out.println("str_error_text in process:"+str_error_text);*/
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insert=false;
										sb.append("<br>"+str_error_text+"<br> ") ;
									}
									if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
									{
										insert=false;
										if((str_error_level.equals("10") && !str_error_text.equals("") ))
										{
											sb.append("<br>"+str_error_text+"<br> ") ;
											//System.out.println("sb mesage in Error is:"+sb);
										}
										else
										{
											if(str_sysmesage_id.indexOf("|") != (-1)){
												msgIds=new StringTokenizer(str_sysmesage_id,"|");
												while(msgIds.hasMoreTokens())
												{
													messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
													sb.append((String)messageHashtable.get("message")+"<br>");
												}
												//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
											}else{
												messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
												sb.append((String)messageHashtable.get("message"));
												//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
											}
										}
									}
								}//insert
							}//for

						}	//if
					}	//if
				}//while
				if(isCustRateExclUpdated_cstmt!=null)
					isCustRateExclUpdated_cstmt.close();
				if(update_cust_rate_srv_excl_cstmt!=null)
					update_cust_rate_srv_excl_cstmt.close();
				if(cust_rate_srv_excl_cstmt!=null)
					cust_rate_srv_excl_cstmt.close();
			}//if
			}
		}
		catch (Exception e)
		{
			System.err.println("Exception while updating customer rate based services details:"+e);
			e.printStackTrace();
			insert=false;
		}
	//System.out.println("Karthikk Before Update customer Rate Based Services Excl details 2" + insert);
	/*******Update customer Rate Based Services Excl details************end********************/
	/*******Update customer charge Based Services detail************start********************/
	try
		{
		if(insert && modify_cust_charge_srv.equals("Y")){

			insert=deleteAllDBRecs(con,db_cust_charge_srv,cust_charge_srv,facility_id,packageCode,"CUST_CHARGE_BASED");
			if(insert && cust_charge_srv!=null && cust_charge_srv.size()>0 )
			{
				//System.out.println("Charge Based Services ");
				keySet=(Set<String>)cust_charge_srv.keySet();
				//System.out.println("keySet="+keySet.toString());
				custIt=keySet.iterator();
				/****************************/
				while(insert && custIt.hasNext()){
					key=(String)custIt.next();
					cust_charge_srv_list=(ArrayList)cust_charge_srv.get(key);
					if(cust_charge_srv_list!=null && cust_charge_srv_list.size()>0 ){
						stKey=new StringTokenizer(key,"~~");
						if(stKey.hasMoreTokens()){
							cust_grp_code=stKey.nextToken();
						}else{
							cust_grp_code="";
						}
						if(stKey.hasMoreTokens())
							cust_code=stKey.nextToken();
						else
							cust_code="";
						if(stKey.hasMoreTokens())
							fromDate=stKey.nextToken();
						else
							fromDate="";
						
						System.out.println("10550 cust_charge_srv_list ====>  "+cust_charge_srv_list);
						if(insert && !cust_grp_code.equals("") && !cust_code.equals("") && !fromDate.equals("")  && cust_dtls!=null && cust_dtls.size()>0 && cust_dtls.containsKey(cust_grp_code+"~~"+cust_code)  && inserted_cust_period_list!=null && inserted_cust_period_list.size()>0 && inserted_cust_period_list.contains(cust_grp_code+"~~"+cust_code+"~~"+fromDate) ){
							for(int i=0;i<cust_charge_srv_list.size();i++){
								/*record=new String[10];
								record=(String[])cust_charge_srv_list.get(i);
								type			= record[0];//MuthuN against 28192
							cbService		= record[0];
								cbServiceDesc		= record[1];
								amountLimitInd	=record[2];
								amountLimit		=record[3];
								roundTo		= record[4];
								roundInd		= record[5];
								refund		=record[6];
								if(refund==null || refund.equals("") || refund.equals("null"))
									refund="N";
								refundAmt	=record[7];
								autoRefund		= record[8];
								factorAppl			= record[9];*/
								record			= new String[12];
								//record			= new String[11];
								record			= (String[])cust_charge_srv_list.get(i);
								type			= record[0];//MuthuN against 28192
								cbService		= record[1];
								cbServiceDesc	= record[2];
								amountLimitInd	= record[3];
								amountLimit		= record[4];
								roundTo			= record[5];
								roundInd		= record[6];
								refund			= record[7];
								if(refund==null || refund.equals("") || refund.equals("null"))
								refund="N";
								refundAmt		= record[8];
								autoRefund		= record[9];
								factorAppl		= record[10];
								srvLmt =record[11]; //muthu on 8/27/2012
								splitReqd	  =	record[12];//Split reqd 
								includeHomeMedication	  =	record[13];
								/* System.out.println("8763 type ====>  "+type);
								System.out.println("8763 cust_grp_code ====>  "+cust_grp_code);
								System.out.println("8763 cust_code ====>  "+cust_code);
								System.out.println("8763 fromDate ====>  "+fromDate);
								System.out.println("8763 db_cust_charge_srv ====>  "+db_cust_charge_srv);
 */
								existsInDB=existsInDB(cust_grp_code+"~~"+cust_code+"~~"+fromDate,record,db_cust_charge_srv,"CUST_CHARGE_BASED");


								//System.out.println("existsInDB 8765 type ====>  "+existsInDB);
								inserted_cust_charge_srv_list.add(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim()+"~~"+cbService.trim());
								/*System.out.println("facility_id="+facility_id);
								System.out.println("packageCode="+packageCode);
								System.out.println("cust_grp_code="+cust_grp_code);
								System.out.println("cust_code="+cust_code);
								System.out.println("cbService="+cbService);
								System.out.println("cbServiceDesc="+cbServiceDesc);
								System.out.println("amountLimitInd="+amountLimitInd);
								System.out.println("amountLimit="+amountLimit);
								System.out.println("roundTo="+roundTo);
								System.out.println("roundInd="+roundInd);
								System.out.println("refund="+refund);
								System.out.println("refundAmt="+refundAmt);
								System.out.println("autoRefund="+autoRefund);
								System.out.println("factorAppl="+factorAppl);*/
								System.out.println("8781 type ====>  "+type);
								System.out.println("8781 existsInDB ====>  "+existsInDB);
								if(existsInDB){
									//chk if update is needed
									isCustChargeSrvUpdated_cstmt.setString(1,facility_id);
									//System.out.println("facility_id in Update Customer 8681 ==> "+facility_id);
									isCustChargeSrvUpdated_cstmt.setString(2,packageCode);
									//System.out.println("packageCode in Update Customer 8681 ==> "+packageCode);
									isCustChargeSrvUpdated_cstmt.setString(3,cust_grp_code);
								//System.out.println("cust_grp_code in Update Customer 8681 ==> "+cust_grp_code);
									isCustChargeSrvUpdated_cstmt.setString(4,cust_code);
									//System.out.println("cust_code in Update Customer 8681 ==> "+cust_code);
									isCustChargeSrvUpdated_cstmt.setString(5,fromDate);
									//System.out.println("fromDate in Update Customer 8681 ==> "+fromDate);
									isCustChargeSrvUpdated_cstmt.setString(6,cbService );
									System.out.println("cbService in Update Customer 8681 ==> "+cbService);
									//isCustChargeSrvUpdated_cstmt.setString(7,"S" );
									isCustChargeSrvUpdated_cstmt.setString(7,type);//Muthu against 28192
									//System.out.println("cbType in Update Customer 8681 ==> "+type);
									isCustChargeSrvUpdated_cstmt.setString(8,"C" );
									//System.out.println("cbType in Update Customer 8681 ==> ");
									isCustChargeSrvUpdated_cstmt.setString(9,"" );
									//System.out.println("cbType in Update Customer 8681 ==> ");
									isCustChargeSrvUpdated_cstmt.setString(10,"" );
									//System.out.println("cbType in Update Customer 8681 ==> ");
									isCustChargeSrvUpdated_cstmt.setString(11,"" );
									//System.out.println("cbType in Update Customer 8681 ==> ");
									isCustChargeSrvUpdated_cstmt.setString(12,"" );								//System.out.println("cbType in Update Customer 8681 ==> ");
									isCustChargeSrvUpdated_cstmt.setString(13,amountLimit );
									//System.out.println("amountLimit in Update Customer 8681 ==> "+amountLimit);
									isCustChargeSrvUpdated_cstmt.setString(14,amountLimitInd );
									isCustChargeSrvUpdated_cstmt.setString(15,"" );								//System.out.println("cbType in Update Customer 8681 ==> ");
									isCustChargeSrvUpdated_cstmt.setString(16,"" );								//System.out.println("cbType in Update Customer 8681 ==> ");
									isCustChargeSrvUpdated_cstmt.setString(17,"" );								//System.out.println("cbType in Update Customer 8681 ==> ");
									isCustChargeSrvUpdated_cstmt.setString(18,refund );							//System.out.println("refund in Update Customer 8681 ==> "+refund);
									isCustChargeSrvUpdated_cstmt.setString(19,refundAmt );						//System.out.println("refundAmt in Update Customer 8681 ==> "+refundAmt);
									isCustChargeSrvUpdated_cstmt.setString(20,autoRefund );						//System.out.println("autoRefund in Update Customer 8681 ==> "+autoRefund);
									isCustChargeSrvUpdated_cstmt.setString(21,"" );								//System.out.println("cbType in Update Customer 8681 ==> ");
									isCustChargeSrvUpdated_cstmt.setString(22,roundTo );						//System.out.println("roundTo in Update Customer 8681 ==> "+roundTo);
									isCustChargeSrvUpdated_cstmt.setString(23,roundInd );
									isCustChargeSrvUpdated_cstmt.setString(24,factorAppl );						//System.out.println("factorAppl in Update Customer 8681 ==> "+factorAppl);
									isCustChargeSrvUpdated_cstmt.setString(25,splitReqd );	//Split reqd - For Validation 
									isCustChargeSrvUpdated_cstmt.setString(26,includeHomeMedication );	
									isCustChargeSrvUpdated_cstmt.registerOutParameter(27,java.sql.Types.VARCHAR);
									isCustChargeSrvUpdated_cstmt.registerOutParameter(28,java.sql.Types.VARCHAR);
									isCustChargeSrvUpdated_cstmt.registerOutParameter(29,java.sql.Types.VARCHAR);
									isCustChargeSrvUpdated_cstmt.registerOutParameter(30,java.sql.Types.VARCHAR);
									isCustChargeSrvUpdated_cstmt.setString(31,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
									isCustChargeSrvUpdated_cstmt.setString(32,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
									isCustChargeSrvUpdated_cstmt.setString(33,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
									isCustChargeSrvUpdated_cstmt.setString(34,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
									isCustChargeSrvUpdated_cstmt.setString(35,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
									isCustChargeSrvUpdated_cstmt.execute();

									recModified=isCustChargeSrvUpdated_cstmt.getString(27);
							System.out.println("recModified in Update Customer 8681 ==> "+recModified);
									str_error_level=isCustChargeSrvUpdated_cstmt.getString(28);
							//System.out.println("str_error_level in Update Customer 8681 ==> "+str_error_level);
									str_sysmesage_id=isCustChargeSrvUpdated_cstmt.getString(29);	
							//System.out.println("str_sysmesage_id in Update Customer 8681 ==> "+str_sysmesage_id);	
									str_error_text=isCustChargeSrvUpdated_cstmt.getString(30);
							//System.out.println("str_error_text in Update Customer 8681 ==> "+str_error_text);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									if(recModified == null)		recModified="";
									System.out.println("recModified:"+recModified);
									System.out.println("str_error_level in process rate based insertion:"+str_error_level);
									System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
									System.out.println("str_error_text in process rate based insertion:"+str_error_text);
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insert=false;
										sb.append("<br>"+str_error_text+"<br> ") ;
									}
									if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
									{
										insert=false;
										if((str_error_level.equals("10") && !str_error_text.equals("") ))
										{
											sb.append("<br>"+str_error_text+"<br> ") ;
											//System.out.println("sb mesage in Error is:"+sb);
										}
										else
										{
											if(str_sysmesage_id.indexOf("|") != (-1)){
												msgIds=new StringTokenizer(str_sysmesage_id,"|");
												while(msgIds.hasMoreTokens())
												{
													messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
													sb.append((String)messageHashtable.get("message")+"<br>");
												}
												//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
											}else{
												messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
												sb.append((String)messageHashtable.get("message"));
												//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
											}
										}
									}
									if(insert && "Y".equals(recModified)){				

										update_cust_charge_srv_cstmt.setString(1,facility_id);
										update_cust_charge_srv_cstmt.setString(2,packageCode);
										update_cust_charge_srv_cstmt.setString(3,cust_grp_code);
										update_cust_charge_srv_cstmt.setString(4,cust_code);
										update_cust_charge_srv_cstmt.setString(5,fromDate);
										update_cust_charge_srv_cstmt.setString(6,cbService );
										update_cust_charge_srv_cstmt.setString(7,type);//Muthu against 28192
										//update_cust_charge_srv_cstmt.setString(7,"S" );
										update_cust_charge_srv_cstmt.setString(8,"C" );
										update_cust_charge_srv_cstmt.setString(9,"" );
										update_cust_charge_srv_cstmt.setString(10,"" );
										update_cust_charge_srv_cstmt.setString(11,"" );
										update_cust_charge_srv_cstmt.setString(12,"" );
										update_cust_charge_srv_cstmt.setString(13,amountLimit );

								//System.out.println("8695 amountLimit:  "+amountLimit);
										update_cust_charge_srv_cstmt.setString(14,amountLimitInd );
										update_cust_charge_srv_cstmt.setString(15,"" );
										update_cust_charge_srv_cstmt.setString(16,"" );
										update_cust_charge_srv_cstmt.setString(17,"" );
										update_cust_charge_srv_cstmt.setString(18,refund );
										update_cust_charge_srv_cstmt.setString(19,refundAmt );
										update_cust_charge_srv_cstmt.setString(20,autoRefund );
										update_cust_charge_srv_cstmt.setString(21,"" );
										update_cust_charge_srv_cstmt.setString(22,roundTo );
										update_cust_charge_srv_cstmt.setString(23,roundInd );
										update_cust_charge_srv_cstmt.setString(24,factorAppl);
										update_cust_charge_srv_cstmt.setString(25,user_id);
										update_cust_charge_srv_cstmt.setString(26,client_ip_address );
										update_cust_charge_srv_cstmt.setString(27,facility_id);
										update_cust_charge_srv_cstmt.setString(28,splitReqd);//RRRR	
										update_cust_charge_srv_cstmt.setString(29,includeHomeMedication);
										update_cust_charge_srv_cstmt.registerOutParameter(30,java.sql.Types.VARCHAR);
										update_cust_charge_srv_cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
										update_cust_charge_srv_cstmt.registerOutParameter(32,java.sql.Types.VARCHAR);
										update_cust_charge_srv_cstmt.setString(33,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
										update_cust_charge_srv_cstmt.setString(34,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
										update_cust_charge_srv_cstmt.setString(35,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
										update_cust_charge_srv_cstmt.setString(36,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
										update_cust_charge_srv_cstmt.setString(37,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
										update_cust_charge_srv_cstmt.execute();

										str_error_level=update_cust_charge_srv_cstmt.getString(30);
										str_sysmesage_id=update_cust_charge_srv_cstmt.getString(31);					
										str_error_text=update_cust_charge_srv_cstmt.getString(32);
										if(str_error_level==null) str_error_level="";
										if(str_sysmesage_id==null) str_sysmesage_id="";
										if(str_error_text==null) str_error_text="";
										//System.out.println("str_error_level in process rate based insertion:"+str_error_level);
										//System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
										//System.out.println("str_error_text in process rate based insertion:"+str_error_text);
										if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
										{
											insert=false;
											sb.append("<br>"+str_error_text+"<br> ") ;
										}
										if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
										{
											insert=false;
											if((str_error_level.equals("10") && !str_error_text.equals("") ))
											{
												sb.append("<br>"+str_error_text+"<br> ") ;
												//System.out.println("sb mesage in Error is:"+sb);
											}
											else
											{
												if(str_sysmesage_id.indexOf("|") != (-1)){
													msgIds=new StringTokenizer(str_sysmesage_id,"|");
													while(msgIds.hasMoreTokens())
													{
														messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
														sb.append((String)messageHashtable.get("message")+"<br>");
													}
													//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
												}else{
													messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
													sb.append((String)messageHashtable.get("message"));
													//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
												}
											}
										}
									}
								}
								else{//insert
									cust_charge_srv_cstmt.setString(1,facility_id);
									cust_charge_srv_cstmt.setString(2,packageCode);
									cust_charge_srv_cstmt.setString(3,cust_grp_code);
									cust_charge_srv_cstmt.setString(4,cust_code);
									cust_charge_srv_cstmt.setString(5,fromDate);
									cust_charge_srv_cstmt.setString(6,cbService);
									cust_charge_srv_cstmt.setString(7,type);//Muthu against 28192
									//System.out.println("8939 cbType  "+type);
									//cust_charge_srv_cstmt.setString(7,"S");
									cust_charge_srv_cstmt.setString(8,"C");
									cust_charge_srv_cstmt.setString(9,"");
									cust_charge_srv_cstmt.setString(10,"");
									cust_charge_srv_cstmt.setString(11,"");
									cust_charge_srv_cstmt.setString(12,"");
									cust_charge_srv_cstmt.setString(13,amountLimit);
									cust_charge_srv_cstmt.setString(14,amountLimitInd);
									cust_charge_srv_cstmt.setString(15,"");
									cust_charge_srv_cstmt.setString(16,"");
									cust_charge_srv_cstmt.setString(17,"");
									cust_charge_srv_cstmt.setString(18,refund);
									cust_charge_srv_cstmt.setString(19,refundAmt);
									cust_charge_srv_cstmt.setString(20,autoRefund);
									cust_charge_srv_cstmt.setString(21,"");
									cust_charge_srv_cstmt.setString(22,roundTo);
									cust_charge_srv_cstmt.setString(23,roundInd);
									cust_charge_srv_cstmt.setString(24,factorAppl);
									cust_charge_srv_cstmt.setString(25,user_id);
									cust_charge_srv_cstmt.setString(26,user_id);
									cust_charge_srv_cstmt.setString(27,client_ip_address);
									cust_charge_srv_cstmt.setString(28,facility_id);
									cust_charge_srv_cstmt.setString(29,client_ip_address);
									cust_charge_srv_cstmt.setString(30,facility_id);
									cust_charge_srv_cstmt.setString(31,splitReqd);//RRRR	
									cust_charge_srv_cstmt.setString(32,includeHomeMedication);
									cust_charge_srv_cstmt.registerOutParameter(33,java.sql.Types.VARCHAR);
									cust_charge_srv_cstmt.registerOutParameter(34,java.sql.Types.VARCHAR);
									cust_charge_srv_cstmt.registerOutParameter(35,java.sql.Types.VARCHAR);
									cust_charge_srv_cstmt.setString(36,null);//Added V190320-Aravindh/MMS-DM-CRF-0129
									cust_charge_srv_cstmt.setString(37,null);//Added V190320-Aravindh/MMS-DM-CRF-0129
									cust_charge_srv_cstmt.setString(38,null);//Added V190320-Aravindh/MMS-DM-CRF-0129
									cust_charge_srv_cstmt.setString(39,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
									cust_charge_srv_cstmt.setString(40,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
									cust_charge_srv_cstmt.setString(41,null);//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020/Package Service Charge Based no need to pass any values
									cust_charge_srv_cstmt.execute();

									str_error_level=cust_charge_srv_cstmt.getString(33);
									str_sysmesage_id=cust_charge_srv_cstmt.getString(34);					
									str_error_text=cust_charge_srv_cstmt.getString(35);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									/* System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
									System.out.println("str_error_level in process:"+str_error_level);
									System.out.println("str_error_text in process:"+str_error_text); */
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insert=false;
										sb.append("<br>"+str_error_text+"<br> ") ;
									}
									if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
									{
										insert=false;
										if((str_error_level.equals("10") && !str_error_text.equals("") ))
										{
											sb.append("<br>"+str_error_text+"<br> ") ;
											//System.out.println("sb mesage in Error is:"+sb);
										}
										else
										{
											if(str_sysmesage_id.indexOf("|") != (-1)){
												msgIds=new StringTokenizer(str_sysmesage_id,"|");
												while(msgIds.hasMoreTokens())
												{
													messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
													sb.append((String)messageHashtable.get("message")+"<br>");
												}
												//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
											}else{
												messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
												sb.append((String)messageHashtable.get("message"));
												//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
											}
										}
									}
								}//insert
							}//for

						}	//if
					}	//if
				}//while
				if(isCustChargeSrvUpdated_cstmt!=null){

					isCustChargeSrvUpdated_cstmt.close();
				}if(update_cust_charge_srv_cstmt!=null){

					update_cust_charge_srv_cstmt.close();
				}if(cust_charge_srv_cstmt!=null){

					cust_charge_srv_cstmt.close();
					}
			}//if
			}
		}
		catch (Exception e)
		{
			System.err.println("Exception while updating customer rate based services details:"+e);
			e.printStackTrace();
			insert=false;
		}
	//System.out.println("Karthikk Before Update customer charge Based Services details 3 insert" + insert);
	/*******Update customer charge Based Services details************end********************/
	/*******Update customer charge Based Services Excl detail************start********************/
	try
		{
		if(insert && modify_cust_charge_srv_excl.equals("Y")){
			insert=deleteAllDBRecs(con,db_cust_charge_srv_excl,cust_charge_srv_excl,facility_id,packageCode,"CUST_CHARGE_BASED_ITEM");
			if(insert && cust_charge_srv_excl!=null && cust_charge_srv_excl.size()>0 )
			{
				//System.out.println("Rate Based Services Excl other operations");
				keySet=(Set<String>)cust_charge_srv_excl.keySet();
				//System.out.println("keySet="+keySet.toString());
				custIt=keySet.iterator();
				/****************************/
				while(insert && custIt.hasNext()){
					key=(String)custIt.next();
					cust_charge_srv_excl_list=(ArrayList)cust_charge_srv_excl.get(key);
					if(cust_charge_srv_excl_list!=null && cust_charge_srv_excl_list.size()>0 ){
						stKey=new StringTokenizer(key,"~~");
						if(stKey.hasMoreTokens()){
							cust_grp_code=stKey.nextToken();
						}else{
							cust_grp_code="";
						}
						if(stKey.hasMoreTokens())
							cust_code=stKey.nextToken();
						else
							cust_code="";
						if(stKey.hasMoreTokens())
							fromDate=stKey.nextToken();
						else
							fromDate="";
						if(stKey.hasMoreTokens())
							parent_service_code=stKey.nextToken();
						else
							parent_service_code="";
						if(insert && !cust_grp_code.equals("") && !cust_code.equals("") && !fromDate.equals("") && !parent_service_code.equals("")  && cust_dtls!=null && cust_dtls.size()>0 && cust_dtls.containsKey(cust_grp_code+"~~"+cust_code)  && inserted_cust_period_list!=null && inserted_cust_period_list.size()>0 && inserted_cust_period_list.contains(cust_grp_code+"~~"+cust_code+"~~"+fromDate) && inserted_cust_charge_srv_list!=null && inserted_cust_charge_srv_list.size()>0 && inserted_cust_charge_srv_list.contains(cust_grp_code+"~~"+cust_code+"~~"+fromDate+"~~"+parent_service_code) ){
							for(int i=0;i<cust_charge_srv_excl_list.size();i++){
								record=new String[5];
								record=(String[])cust_charge_srv_excl_list.get(i);
								itemCode		= record[0];
								itemDesc		= record[1];
								inExcl	=record[2];
								if(inExcl==null || inExcl.equals("") || inExcl.equals("null"))
									inExcl="N";
								qtyLimit		=record[3];
								amountLimit			= record[4];
								splitReqd	  =	record[5];//Split reqd
						/*System.out.println("facility_id="+facility_id);
						System.out.println("packageCode="+packageCode);
						System.out.println("cust_grp_code="+cust_grp_code);
						System.out.println("cust_code="+cust_code);
						System.out.println("fromDate="+fromDate);
						System.out.println("parent_service_code="+parent_service_code);
						System.out.println("itemCode="+itemCode);
						System.out.println("inExcl="+inExcl);
						System.out.println("qtyLimit="+qtyLimit);
						System.out.println("amountLimit="+amountLimit);*/
							existsInDB=existsInDB(cust_grp_code+"~~"+cust_code+"~~"+fromDate+"~~"+parent_service_code,record,db_cust_charge_srv_excl,"CUST_CHARGE_BASED_ITEM");

								//System.out.println("existsInDB="+existsInDB);
								if(existsInDB){
									//chk if update is needed
									isCustChargeExclUpdated_cstmt.setString(1,facility_id);
									isCustChargeExclUpdated_cstmt.setString(2,packageCode);
									isCustChargeExclUpdated_cstmt.setString(3,cust_grp_code);
									isCustChargeExclUpdated_cstmt.setString(4,cust_code);
									isCustChargeExclUpdated_cstmt.setString(5,fromDate);
									isCustChargeExclUpdated_cstmt.setString(6,parent_service_code );
									isCustChargeExclUpdated_cstmt.setString(7,"" );
									isCustChargeExclUpdated_cstmt.setString(8,"C" );
									isCustChargeExclUpdated_cstmt.setString(9,itemCode );
									isCustChargeExclUpdated_cstmt.setString(10,"" );
									isCustChargeExclUpdated_cstmt.setString(11,inExcl );
									isCustChargeExclUpdated_cstmt.setString(12,"" );
									isCustChargeExclUpdated_cstmt.setString(13,qtyLimit );
									isCustChargeExclUpdated_cstmt.setString(14,amountLimit );

						//System.out.println("existsInDB amountLimit ="+amountLimit);
									isCustChargeExclUpdated_cstmt.setString(15,"" );
									isCustChargeExclUpdated_cstmt.setString(16,"" );
									isCustChargeExclUpdated_cstmt.setString(17,"" );
									isCustChargeExclUpdated_cstmt.setString(18,"" );
									isCustChargeExclUpdated_cstmt.setString(19,"" );
									isCustChargeExclUpdated_cstmt.setString(20,"" );
									isCustChargeExclUpdated_cstmt.setString(21,"" );
									isCustChargeExclUpdated_cstmt.setString(22,"" );
									isCustChargeExclUpdated_cstmt.setString(23,splitReqd);//Split reqd - For validation
									isCustChargeExclUpdated_cstmt.setString(24,includeHomeMedication);
									isCustChargeExclUpdated_cstmt.registerOutParameter(25,java.sql.Types.VARCHAR);
									isCustChargeExclUpdated_cstmt.registerOutParameter(26,java.sql.Types.VARCHAR);
									isCustChargeExclUpdated_cstmt.registerOutParameter(27,java.sql.Types.VARCHAR);
									isCustChargeExclUpdated_cstmt.registerOutParameter(28,java.sql.Types.VARCHAR);
									isCustChargeExclUpdated_cstmt.setString(29,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
									isCustChargeExclUpdated_cstmt.setString(30,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
									isCustChargeExclUpdated_cstmt.setString(31,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
									isCustChargeExclUpdated_cstmt.setString(32,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
									isCustChargeExclUpdated_cstmt.setString(33,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
									isCustChargeExclUpdated_cstmt.execute();

									recModified=isCustChargeExclUpdated_cstmt.getString(25);
									str_error_level=isCustChargeExclUpdated_cstmt.getString(26);
									str_sysmesage_id=isCustChargeExclUpdated_cstmt.getString(27);					
									str_error_text=isCustChargeExclUpdated_cstmt.getString(28);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									if(recModified == null)		recModified="";
									/*System.out.println("recModified:"+recModified);
									System.out.println("str_error_level in process rate based insertion:"+str_error_level);
									System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
									System.out.println("str_error_text in process rate based insertion:"+str_error_text);*/
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insert=false;
										sb.append("<br>"+str_error_text+"<br> ") ;
									}
									if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
									{
										insert=false;
										if((str_error_level.equals("10") && !str_error_text.equals("") ))
										{
											sb.append("<br>"+str_error_text+"<br> ") ;
											//System.out.println("sb mesage in Error is:"+sb);
										}
										else
										{
											if(str_sysmesage_id.indexOf("|") != (-1)){
												msgIds=new StringTokenizer(str_sysmesage_id,"|");
												while(msgIds.hasMoreTokens())
												{
													messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
													sb.append((String)messageHashtable.get("message")+"<br>");
												}
												//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
											}else{
												messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
												sb.append((String)messageHashtable.get("message"));
												//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
											}
										}
									}
									//System.out.println("insert="+insert);
									if(insert && "Y".equals(recModified)){				

										update_cust_charge_srv_excl_cstmt.setString(1,facility_id);
										update_cust_charge_srv_excl_cstmt.setString(2,packageCode);
										update_cust_charge_srv_excl_cstmt.setString(3,cust_grp_code);
										update_cust_charge_srv_excl_cstmt.setString(4,cust_code);
										update_cust_charge_srv_excl_cstmt.setString(5,fromDate);
										update_cust_charge_srv_excl_cstmt.setString(6,parent_service_code );
										update_cust_charge_srv_excl_cstmt.setString(7,"S" );
										update_cust_charge_srv_excl_cstmt.setString(8,"C" );
										update_cust_charge_srv_excl_cstmt.setString(9,itemCode );
										update_cust_charge_srv_excl_cstmt.setString(10,"M" );
										update_cust_charge_srv_excl_cstmt.setString(11,inExcl );
										update_cust_charge_srv_excl_cstmt.setString(12,"" );
										update_cust_charge_srv_excl_cstmt.setString(13,qtyLimit );
										update_cust_charge_srv_excl_cstmt.setString(14,amountLimit );

								//System.out.println("9006 amountLimit ="+amountLimit);
										update_cust_charge_srv_excl_cstmt.setString(15,"" );
										update_cust_charge_srv_excl_cstmt.setString(16,"" );
										update_cust_charge_srv_excl_cstmt.setString(17,"" );
										update_cust_charge_srv_excl_cstmt.setString(18,"" );
										update_cust_charge_srv_excl_cstmt.setString(19,"" );
										update_cust_charge_srv_excl_cstmt.setString(20,"" );
										update_cust_charge_srv_excl_cstmt.setString(21,"" );
										update_cust_charge_srv_excl_cstmt.setString(22,"" );
										update_cust_charge_srv_excl_cstmt.setString(23,user_id);
										update_cust_charge_srv_excl_cstmt.setString(24,client_ip_address );
										update_cust_charge_srv_excl_cstmt.setString(25,facility_id);
										update_cust_charge_srv_excl_cstmt.setString(26,splitReqd);//RRRR	
										update_cust_charge_srv_excl_cstmt.setString(27,includeHomeMedication); //sarathkumar InclHmeMedi
										update_cust_charge_srv_excl_cstmt.registerOutParameter(28,java.sql.Types .VARCHAR);
										update_cust_charge_srv_excl_cstmt.registerOutParameter(29,java.sql.Types.VARCHAR);
										update_cust_charge_srv_excl_cstmt.registerOutParameter(30,java.sql.Types.VARCHAR);
										update_cust_charge_srv_excl_cstmt.setString(31,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
										update_cust_charge_srv_excl_cstmt.setString(32,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
										update_cust_charge_srv_excl_cstmt.setString(33,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
										update_cust_charge_srv_excl_cstmt.setString(34,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
										update_cust_charge_srv_excl_cstmt.setString(35,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
										update_cust_charge_srv_excl_cstmt.execute();

										str_error_level=update_cust_charge_srv_excl_cstmt.getString(28);
										str_sysmesage_id=update_cust_charge_srv_excl_cstmt.getString(29);					
										str_error_text=update_cust_charge_srv_excl_cstmt.getString(30);
										if(str_error_level==null) str_error_level="";
										if(str_sysmesage_id==null) str_sysmesage_id="";
										if(str_error_text==null) str_error_text="";
										//System.out.println("str_error_level in process rate based insertion:"+str_error_level);
										//System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
										//System.out.println("str_error_text in process rate based insertion:"+str_error_text);
										if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
										{
											insert=false;
											sb.append("<br>"+str_error_text+"<br> ") ;
										}
										if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
										{
											insert=false;
											if((str_error_level.equals("10") && !str_error_text.equals("") ))
											{
												sb.append("<br>"+str_error_text+"<br> ") ;
												//System.out.println("sb mesage in Error is:"+sb);
											}
											else
											{
												if(str_sysmesage_id.indexOf("|") != (-1)){
													msgIds=new StringTokenizer(str_sysmesage_id,"|");
													while(msgIds.hasMoreTokens())
													{
														messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
														sb.append((String)messageHashtable.get("message")+"<br>");
													}
													//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
												}else{
													messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
													sb.append((String)messageHashtable.get("message"));
													//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
												}
											}
										}
									}
								}
								else{//insert
									cust_charge_srv_excl_cstmt.setString(1,facility_id);
									cust_charge_srv_excl_cstmt.setString(2,packageCode);
									cust_charge_srv_excl_cstmt.setString(3,cust_grp_code);
									cust_charge_srv_excl_cstmt.setString(4,cust_code);
									cust_charge_srv_excl_cstmt.setString(5,fromDate);
									cust_charge_srv_excl_cstmt.setString(6,parent_service_code);
									cust_charge_srv_excl_cstmt.setString(7,"S");
									cust_charge_srv_excl_cstmt.setString(8,"C");
									cust_charge_srv_excl_cstmt.setString(9,itemCode);
									cust_charge_srv_excl_cstmt.setString(10,"M");
									cust_charge_srv_excl_cstmt.setString(11,inExcl);
									cust_charge_srv_excl_cstmt.setString(12,"");
									cust_charge_srv_excl_cstmt.setString(13,qtyLimit);
									cust_charge_srv_excl_cstmt.setString(14,amountLimit);

									//System.out.println("9080 amountLimit: "+amountLimit);

									cust_charge_srv_excl_cstmt.setString(15,"");
									cust_charge_srv_excl_cstmt.setString(16,"");
									cust_charge_srv_excl_cstmt.setString(17,"");
									cust_charge_srv_excl_cstmt.setString(18,"");
									cust_charge_srv_excl_cstmt.setString(19,"");
									cust_charge_srv_excl_cstmt.setString(20,"");
									cust_charge_srv_excl_cstmt.setString(21,"");
									cust_charge_srv_excl_cstmt.setString(22,"");
									cust_charge_srv_excl_cstmt.setString(23,user_id);
									cust_charge_srv_excl_cstmt.setString(24,user_id);
									cust_charge_srv_excl_cstmt.setString(25,client_ip_address);
									cust_charge_srv_excl_cstmt.setString(26,facility_id);
									cust_charge_srv_excl_cstmt.setString(27,client_ip_address);
									cust_charge_srv_excl_cstmt.setString(28,facility_id);
									cust_charge_srv_excl_cstmt.setString(29,splitReqd);//RRRR
									cust_charge_srv_excl_cstmt.setString(30,includeHomeMedication);
									cust_charge_srv_excl_cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
									cust_charge_srv_excl_cstmt.registerOutParameter(32,java.sql.Types.VARCHAR);
									cust_charge_srv_excl_cstmt.registerOutParameter(33,java.sql.Types.VARCHAR);
									cust_charge_srv_excl_cstmt.setString(31,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
									cust_charge_srv_excl_cstmt.setString(32,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
									cust_charge_srv_excl_cstmt.setString(33,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
									cust_charge_srv_excl_cstmt.setString(34,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
									cust_charge_srv_excl_cstmt.setString(35,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
									cust_charge_srv_excl_cstmt.execute();

									str_error_level=cust_charge_srv_excl_cstmt.getString(31);
									str_sysmesage_id=cust_charge_srv_excl_cstmt.getString(32);					
									str_error_text=cust_charge_srv_excl_cstmt.getString(33);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									/* System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
									System.out.println("str_error_level in process:"+str_error_level);
									System.out.println("str_error_text in process:"+str_error_text); */
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insert=false;
										sb.append("<br>"+str_error_text+"<br> ") ;
									}
									if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
									{
										insert=false;
										if((str_error_level.equals("10") && !str_error_text.equals("") ))
										{
											sb.append("<br>"+str_error_text+"<br> ") ;
											//System.out.println("sb mesage in Error is:"+sb);
										}
										else
										{
											if(str_sysmesage_id.indexOf("|") != (-1)){
												msgIds=new StringTokenizer(str_sysmesage_id,"|");
												while(msgIds.hasMoreTokens())
												{
													messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
													sb.append((String)messageHashtable.get("message")+"<br>");
												}
												//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
											}else{
												messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
												sb.append((String)messageHashtable.get("message"));
												//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
											}
										}
									}
								}//insert
								if(insert==false) break;  // Karthikk added the below comment for Screen Hanging Issue MMS-DM-SCF-0296 61560
							}//for

						}	//if
					}	//if
				}//while
				if(isCustChargeExclUpdated_cstmt!=null)
					isCustChargeExclUpdated_cstmt.close();
				if(update_cust_charge_srv_excl_cstmt!=null)
					update_cust_charge_srv_excl_cstmt.close();
				if(cust_charge_srv_excl_cstmt!=null)
					cust_charge_srv_excl_cstmt.close();
			}//if
			}
		}
		catch (Exception e)
		{
			System.err.println("Exception while updating customer rate based services details:"+e);
			e.printStackTrace();
			insert=false;
		}
	//System.out.println("Karthikk Update customer charge Based Services Excl details************end 4 insert" + insert);
	/*******Update customer charge Based Services Excl details************end********************/
	}catch(Exception e){
		System.err.println("Exception in modifyCustomerDtls() of PkgDef Ejb="+e);
		e.printStackTrace();
	}finally
		{
			try{
				if(isCustPeriodUpdated_cstmt!=null) isCustPeriodUpdated_cstmt.close();
				if(update_cust_period_cstmt!=null) update_cust_period_cstmt.close();
			}catch(Exception r)
			{r.printStackTrace();}

		}

		return_mess.put("status",new Boolean(insert));
		return_mess.put("error",str_error_text);
		return_mess.put("sys_error",sys_err.toString());
		return_mess.put("message",str_sysmesage_id);
	//	System.out.println("Karthikk modifyCustomerDtls return_mess="+return_mess.toString());
		return return_mess;
	}
	@SuppressWarnings({"rawtypes","unused", "unchecked"})
	public HashMap modifyDiscountDtls(Connection con,HashMap tabdata) //throws Exception{
	{
		//System.out.println("in modifyDiscountDtls() tabdata="+tabdata.toString());
		HashMap return_mess = new HashMap();

		StringBuffer sb = new StringBuffer( "" ) ;
		Hashtable messageHashtable=new Hashtable();
		Set<String>	keySet;
		Iterator<String> custIt;
		String key="";
		String recModified="";
		String cust_grp_code="";
		String cust_grp_desc="";
		String cust_code="";
		String cust_desc="";
		String blng_grp_code=""; 
		String blng_grp_desc="";
		String blng_class_code="";
		String blng_class_desc="";
		String eff_from_date="";
		String eff_to_date="";
		String discount_type="";
		String discount="";
		//GHL-CRF-0502 Starts
		String age_group_code ="";
		String specialty_code ="";
		String hdn_age_group ="";
		String specialty_desc ="";
		String poly_code ="";
		//GHL-CRF-0502 Ends

		//StringTokenizer stKey;
		StringTokenizer	msgIds;
		String[] record;
		//boolean existsInDB=false;
		boolean insert = true;
		CallableStatement isCustDiscountUpdated_cstmt = null;
		CallableStatement update_cust_discount_cstmt = null;
		CallableStatement isBlngGrpDiscountUpdated_cstmt = null;
		CallableStatement update_blng_grp_discount_cstmt = null;
		CallableStatement cust_discount_cstmt = null;
		CallableStatement blng_grp_discount_cstmt = null;
	try{
		String facility_id = (String) tabdata.get("FACILITY_ID");
		if(facility_id==null) facility_id="";

		String packageCode=(String)tabdata.get("packageCode");
		if(packageCode==null) packageCode="";

		String client_ip_address=(String)tabdata.get("client_ip_address");
		if(client_ip_address==null) client_ip_address="";

		String user_id=(String)tabdata.get("login_user");
		if(user_id==null) user_id="";

		String locale=(String)tabdata.get("locale");
		if(locale==null) locale="en";

		HashMap cust_discount_dtls = (HashMap)tabdata.get("cust_discount_dtls");
		HashMap db_cust_discount_dtls = (HashMap)tabdata.get("db_cust_discount_dtls");
		HashMap blng_grp_discount_dtls = (HashMap)tabdata.get("blng_grp_discount_dtls");
		HashMap db_blng_grp_discount_dtls = (HashMap)tabdata.get("db_blng_grp_discount_dtls");
		String modify_discount=(String)tabdata.get("modify_discount");
		/****************insert stmts*****start****/
		//Added one parameter MMS-QH-CRF-128.1-US-2 PALANINARAYANAN 20/7/2020  ICN:73475
		String cust_discount_sql="{ call   blpackage.insertpackagecustdiscount  (?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?)}";
		String cust_discount_sql1="{ call   blpackage.insertpackagecustdiscount  (?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?)}";//one param added 73475

		String blng_grp_discount_sql="{ call   blpackage.insertpackagediscount  (?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?)}";
		String blng_grp_discount_sql1="{ call   blpackage.insertpackagediscount  (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?)}";

		/****************insert stmts*****end****/
		/****************update stmts*****start****/
		//Added one parameter MMS-KH-SCF-0131 PALANINARAYANAN on V210226  for Both isCustDiscountUpdated_sql and isCustDiscountUpdated_sql1
		String isCustDiscountUpdated_sql   ="{ call   blpackage.ispkgcustDiscountrecordchanged (?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?)}";
		String isCustDiscountUpdated_sql1   ="{ call   blpackage.ispkgcustDiscountrecordchanged (?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?)}";
		//Added one parameter MMS-QH-CRF-128.1-US-2 PALANINARAYANAN 14/08/2020  ICN:73475
		String update_cust_discount_sql   ="{ call   blpackage.updatepackagecustdiscount (?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,sysdate,?,?,?,?,?,?,?,?)}";
		String update_cust_discount_sql1   ="{ call   blpackage.updatepackagecustdiscount (?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,sysdate,?,?,?,?,?,?,?,?)}";

		String isBlngGrpDiscountUpdated_sql   ="{ call   blpackage.ispkgDiscountrecordchanged (?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?)}";
		String isBlngGrpDiscountUpdated_sql1   ="{ call   blpackage.ispkgDiscountrecordchanged (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?)}";

		String update_blng_grp_discount_sql   ="{ call   blpackage.updatepackagediscount (?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,sysdate,?,?,?,?,?,?,?)}";
		String update_blng_grp_discount_sql1   ="{ call   blpackage.updatepackagediscount (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,sysdate,?,?,?,?,?,?,?)}";


	/****************update stmts*****end****/

		if(insert && cust_discount_dtls!=null && cust_discount_dtls.size()>0 && modify_discount.equals("Y") )
		{
			//System.out.println("cust_discount_dtls other operations");
			keySet=(Set<String>)cust_discount_dtls.keySet();
			custIt=keySet.iterator();
			while(insert && custIt.hasNext()){
				record=new String[14];
				key=(String)custIt.next();
				record=(String[])cust_discount_dtls.get(key);
				cust_grp_code	= record[0]==null?"":record[0];
				cust_grp_desc	= record[1]==null?"":record[1];
				cust_code		= record[2]==null?"":record[2];
				cust_desc		= record[3]==null?"":record[3];
				blng_class_code	= record[4]==null?"":record[4];
				blng_class_desc	= record[5]==null?"":record[5];
				eff_from_date	= record[6]==null?"":record[6];
				eff_to_date		= record[7]==null?"":record[7];
				discount_type	= record[8]==null?"":record[8];
				discount		= record[9]==null?"0":record[9];

				//GHL-CRF-0502 Starts
				age_group_code	= record[10]==null?"**":record[10];
				if(age_group_code.equals("") || age_group_code.equals(null)){
						age_group_code="**";
				}
				hdn_age_group	= record[11]==null?"":record[11];
				specialty_code	= record[12]==null?"**":record[12];
				if(specialty_code.equals("") || specialty_code.equals(null)){
						specialty_code="**";
				}
				specialty_desc	= record[13]==null?"":record[13];
				//GHL-CRF-0502 Ends
				poly_code	= record[14]==null?"":record[14];	//Added one parameter MMS-QH-CRF-128.1-US-2 PALANINARAYANAN 20/7/2020  ICN:73475
				
				//Added one parameter MMS-KH-SCF-0131 PALANINARAYANAN on V210226 
				if(poly_code.equals("") || poly_code.equals(null)){
					poly_code="**";
				}
				
				if(db_cust_discount_dtls!=null && db_cust_discount_dtls.size()>0 && db_cust_discount_dtls.containsKey(key)){
					//chk if update is needed
					if(eff_to_date.equals("")){
						isCustDiscountUpdated_cstmt = con.prepareCall(isCustDiscountUpdated_sql1);
						eff_to_date=null;
					}else{
						isCustDiscountUpdated_cstmt = con.prepareCall(isCustDiscountUpdated_sql);
					}
					isCustDiscountUpdated_cstmt.setString(1,facility_id);
					isCustDiscountUpdated_cstmt.setString(2,packageCode);
					isCustDiscountUpdated_cstmt.setString(3,cust_grp_code);
					isCustDiscountUpdated_cstmt.setString(4,cust_code);
					isCustDiscountUpdated_cstmt.setString(5,blng_class_code);
					isCustDiscountUpdated_cstmt.setString(6,eff_from_date );
					isCustDiscountUpdated_cstmt.setString(7,eff_to_date );
					isCustDiscountUpdated_cstmt.setString(8,discount );
					isCustDiscountUpdated_cstmt.setString(9,discount_type );
					isCustDiscountUpdated_cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
					isCustDiscountUpdated_cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
					isCustDiscountUpdated_cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
					isCustDiscountUpdated_cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
					//GHL-CRF-0502 Starts
					isCustDiscountUpdated_cstmt.setString(14,age_group_code );
					isCustDiscountUpdated_cstmt.setString(15,specialty_code );
					isCustDiscountUpdated_cstmt.setString(16,poly_code); //Added one parameter MMS-KH-SCF-0131 PALANINARAYANAN on V210226 
					//GHL-CRF-0502 Ends
					isCustDiscountUpdated_cstmt.execute();

					recModified=isCustDiscountUpdated_cstmt.getString(10);
					str_error_level=isCustDiscountUpdated_cstmt.getString(11);
					str_sysmesage_id=isCustDiscountUpdated_cstmt.getString(12);
					str_error_text=isCustDiscountUpdated_cstmt.getString(13);
					if(recModified==null) recModified="";
					if(str_error_level==null) str_error_level="";
					if(str_sysmesage_id==null) str_sysmesage_id="";
					if(str_error_text==null) str_error_text="";
					/*System.out.println("recModified:"+recModified);
					System.out.println("str_error_level in process rate based insertion:"+str_error_level);
					System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
					System.out.println("str_error_text in process rate based insertion:"+str_error_text);*/
					if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
					{
						insert=false;
						sb.append("<br>"+str_error_text+"<br> ") ;
					}
					if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
					{
						insert=false;
						if((str_error_level.equals("10") && !str_error_text.equals("") ))
						{
							sb.append("<br>"+str_error_text+"<br> ") ;
						//	System.out.println("sb mesage in Error is:"+sb);
						}
						else
						{
							if(str_sysmesage_id.indexOf("|") != (-1)){
								msgIds=new StringTokenizer(str_sysmesage_id,"|");
								while(msgIds.hasMoreTokens())
								{
									messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
									sb.append((String)messageHashtable.get("message")+"<br>");
								}
							//	System.out.println("sb mesages in str_sysmesage_id is:"+sb);
							}else{
								messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
								sb.append((String)messageHashtable.get("message"));
							//	System.out.println("sb mesage in str_sysmesage_id is:"+sb);
							}
						}
					}
					//System.out.println("@@ recModified="+recModified);
					//System.out.println("@@ insert="+insert);
				//	System.out.println("@@ eff_to_date="+eff_to_date);
					if(insert && "Y".equals(recModified)){
				//	System.out.println("1111111");
						if(eff_to_date==null || eff_to_date.equals("")){
							update_cust_discount_cstmt = con.prepareCall(update_cust_discount_sql1);
							eff_to_date=null;
						}else{
							update_cust_discount_cstmt = con.prepareCall(update_cust_discount_sql);
						}
		//System.out.println("444444");
						update_cust_discount_cstmt.setString(1,facility_id);
								//System.out.println("55555");
						update_cust_discount_cstmt.setString(2,packageCode);
							//	System.out.println("6");
						update_cust_discount_cstmt.setString(3,cust_grp_code);
		//System.out.println("7");
						update_cust_discount_cstmt.setString(4,cust_code);
								//System.out.println("8");
						update_cust_discount_cstmt.setString(5,blng_class_code);
								//System.out.println("9");
						update_cust_discount_cstmt.setString(6,eff_from_date);
								//System.out.println("10");
						update_cust_discount_cstmt.setString(7,eff_to_date);
							//	System.out.println("11");
						update_cust_discount_cstmt.setString(8,discount);
							//	System.out.println("12");
						update_cust_discount_cstmt.setString(9,discount_type);
						update_cust_discount_cstmt.setString(10,user_id);
						update_cust_discount_cstmt.setString(11,client_ip_address );
						update_cust_discount_cstmt.setString(12,facility_id);
						update_cust_discount_cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
						update_cust_discount_cstmt.registerOutParameter(14,java.sql.Types.VARCHAR);
						update_cust_discount_cstmt.registerOutParameter(15,java.sql.Types.VARCHAR);
						//GHL-CRF-0502 Starts
						update_cust_discount_cstmt.setString(16,age_group_code );
						update_cust_discount_cstmt.setString(17,specialty_code );
						//GHL-CRF-0502 Ends
						update_cust_discount_cstmt.setString(18,poly_code );	//Added for MMS-QH-CRF-128.1-US-2 PALANINARAYANAN 20/7/2020  ICN:73475
						update_cust_discount_cstmt.execute();
											//	System.out.println("555555");
						str_error_level=update_cust_discount_cstmt.getString(13);
						str_sysmesage_id=update_cust_discount_cstmt.getString(14);
						str_error_text=update_cust_discount_cstmt.getString(15);
						if(str_error_level==null) str_error_level="";
						if(str_sysmesage_id==null) str_sysmesage_id="";
						if(str_error_text==null) str_error_text="";
						/* System.out.println("str_error_level in process "+str_error_level);
						System.out.println("str_sysmesage_id in process "+str_sysmesage_id);
						System.out.println("str_error_text in process "+str_error_text); */
						if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
						{
							insert=false;
							sb.append("<br>"+str_error_text+"<br> ") ;
						}
						if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
						{
							insert=false;
							if((str_error_level.equals("10") && !str_error_text.equals("") ))
							{
								sb.append("<br>"+str_error_text+"<br> ") ;
								//System.out.println("sb mesage in Error is:"+sb);
							}
							else
							{
								if(str_sysmesage_id.indexOf("|") != (-1)){
									msgIds=new StringTokenizer(str_sysmesage_id,"|");
									while(msgIds.hasMoreTokens())
									{
										messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
										sb.append((String)messageHashtable.get("message")+"<br>");
									}
									//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
								}else{
									messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
									sb.append((String)messageHashtable.get("message"));
									//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
								}
							}
						}
						if(update_cust_discount_cstmt!=null)
				update_cust_discount_cstmt.close(); //ADDED BY RAM FOR CHK STYLE
					}

					if(isCustDiscountUpdated_cstmt!=null)
				isCustDiscountUpdated_cstmt.close();//ADDED BY RAM FOR CHK STYLE
				}
				else{//insert
					if(eff_to_date==null || eff_to_date.equals("")){
						cust_discount_cstmt = con.prepareCall(cust_discount_sql1);
						eff_to_date=null;
					}else{
						cust_discount_cstmt = con.prepareCall(cust_discount_sql);
					}
					cust_discount_cstmt.setString(1,facility_id);
					cust_discount_cstmt.setString(2,packageCode);
					cust_discount_cstmt.setString(3,cust_grp_code);
					cust_discount_cstmt.setString(4,cust_code);
					cust_discount_cstmt.setString(5,blng_class_code);
					cust_discount_cstmt.setString(6,eff_from_date);
					cust_discount_cstmt.setString(7,eff_to_date);
					cust_discount_cstmt.setString(8,discount);
					cust_discount_cstmt.setString(9,discount_type);
					cust_discount_cstmt.setString(10,user_id);
					cust_discount_cstmt.setString(11,user_id);
					cust_discount_cstmt.setString(12,client_ip_address);
					cust_discount_cstmt.setString(13,facility_id);
					cust_discount_cstmt.setString(14,client_ip_address);
					cust_discount_cstmt.setString(15,facility_id);
					cust_discount_cstmt.registerOutParameter(16,java.sql.Types.VARCHAR);
					cust_discount_cstmt.registerOutParameter(17,java.sql.Types.VARCHAR);
					cust_discount_cstmt.registerOutParameter(18,java.sql.Types.VARCHAR);
					//GHL-CRF-0502 Starts
					cust_discount_cstmt.setString(19,age_group_code );
					cust_discount_cstmt.setString(20,specialty_code );
					//GHL-CRF-0502 Ends
					cust_discount_cstmt.setString(21,poly_code );	//Added for MMS-QH-CRF-128.1-US-2 PALANINARAYANAN 20/7/2020  ICN:73475
					
					
					if(null != discount && !discount.equals("")) {
						cust_discount_cstmt.execute();
					}

					str_error_level=cust_discount_cstmt.getString(16);
					str_sysmesage_id=cust_discount_cstmt.getString(17);
					str_error_text=cust_discount_cstmt.getString(18);
					if(str_error_level==null) str_error_level="";
					if(str_sysmesage_id==null) str_sysmesage_id="";
					if(str_error_text==null) str_error_text="";
				//	System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
				//	System.out.println("str_error_text in process:"+str_error_text);
					//System.out.println("str_error_text in process:"+str_error_text);
					if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
					{
						insert=false;
						sb.append("<br>"+str_error_text+"<br> ") ;
					}
					if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
					{
						insert=false;
						if((str_error_level.equals("10") && !str_error_text.equals("") ))
						{
							sb.append("<br>"+str_error_text+"<br> ") ;
							//System.out.println("sb mesage in Error is:"+sb);
						}
						else
						{
							if(str_sysmesage_id.indexOf("|") != (-1)){
								msgIds=new StringTokenizer(str_sysmesage_id,"|");
								while(msgIds.hasMoreTokens())
								{
									messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
									sb.append((String)messageHashtable.get("message")+"<br>");
								}
							//	System.out.println("sb mesages in str_sysmesage_id is:"+sb);
							}else{
								messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
								sb.append((String)messageHashtable.get("message"));
							//	System.out.println("sb mesage in str_sysmesage_id is:"+sb);
							}
						}
					}
					if(cust_discount_cstmt!=null) cust_discount_cstmt.close();//ADDED BY RAM FOR CHK STYLE
				}//insert

			}//while
			if(isCustDiscountUpdated_cstmt!=null)
				isCustDiscountUpdated_cstmt.close();
			if(update_cust_discount_cstmt!=null)
				update_cust_discount_cstmt.close();
			if(cust_discount_cstmt!=null)
				cust_discount_cstmt.close();
		}// if
		if(insert && blng_grp_discount_dtls!=null && blng_grp_discount_dtls.size()>0 && modify_discount.equals("Y") )
		{
			//System.out.println("blng_grp_discount_dtls other operations");
			keySet=(Set<String>)blng_grp_discount_dtls.keySet();
			custIt=keySet.iterator();
			while(insert && custIt.hasNext()){
				record=new String[12];
				key=(String)custIt.next();
				record=(String[])blng_grp_discount_dtls.get(key);
				blng_grp_code	= record[0]==null?"":record[0];
				blng_grp_desc	= record[1]==null?"":record[1];
				blng_class_code	= record[2]==null?"":record[2];
				blng_class_desc	= record[3]==null?"":record[3];
				eff_from_date	= record[4]==null?"":record[4];
				eff_to_date		= record[5]==null?"":record[5];
				discount_type	= record[6]==null?"":record[6];
				discount		= record[7]==null?"":record[7];
				//GHL-CRF-0502 Starts
				age_group_code	= record[8]==null?"":record[8];
				if(age_group_code.equals("") || age_group_code.equals(null)){
						age_group_code="**";
				}
				hdn_age_group	= record[9]==null?"":record[9];
				specialty_code	= record[10]==null?"":record[10];
				if(specialty_code.equals("") || specialty_code.equals(null)){
						specialty_code="**";
				}
				specialty_desc	= record[11]==null?"":record[11];
				//GHL-CRF-0502 Ends
				
				if(db_blng_grp_discount_dtls!=null && db_blng_grp_discount_dtls.size()>0 && db_blng_grp_discount_dtls.containsKey(key)){
					//chk if update is needed
					if(eff_to_date==null || eff_to_date.equals("")){
						isBlngGrpDiscountUpdated_cstmt = con.prepareCall(isBlngGrpDiscountUpdated_sql1);
						eff_to_date=null;
					}else{
						isBlngGrpDiscountUpdated_cstmt = con.prepareCall(isBlngGrpDiscountUpdated_sql);
					}
					isBlngGrpDiscountUpdated_cstmt.setString(1,facility_id);
					isBlngGrpDiscountUpdated_cstmt.setString(2,packageCode);
					isBlngGrpDiscountUpdated_cstmt.setString(3,blng_grp_code);
					isBlngGrpDiscountUpdated_cstmt.setString(4,blng_class_code);
					isBlngGrpDiscountUpdated_cstmt.setString(5,eff_from_date);
					isBlngGrpDiscountUpdated_cstmt.setString(6,eff_to_date );
					isBlngGrpDiscountUpdated_cstmt.setString(7,discount );
					isBlngGrpDiscountUpdated_cstmt.setString(8,discount_type );
					isBlngGrpDiscountUpdated_cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
					isBlngGrpDiscountUpdated_cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
					isBlngGrpDiscountUpdated_cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
					isBlngGrpDiscountUpdated_cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
					//GHL-CRF-0502 Starts
					isBlngGrpDiscountUpdated_cstmt.setString(13,age_group_code);
					isBlngGrpDiscountUpdated_cstmt.setString(14,specialty_code);
					//GHL-CRF-0502 Ends
					isBlngGrpDiscountUpdated_cstmt.execute();

					recModified=isBlngGrpDiscountUpdated_cstmt.getString(9);
					str_error_level=isBlngGrpDiscountUpdated_cstmt.getString(10);
					str_sysmesage_id=isBlngGrpDiscountUpdated_cstmt.getString(11);
					str_error_text=isBlngGrpDiscountUpdated_cstmt.getString(12);
					if(recModified==null) recModified="";
					if(str_error_level==null) str_error_level="";
					if(str_sysmesage_id==null) str_sysmesage_id="";
					if(str_error_text==null) str_error_text="";
					if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
					{
						insert=false;
						sb.append("<br>"+str_error_text+"<br> ") ;
					}
					if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
					{
						insert=false;
						if((str_error_level.equals("10") && !str_error_text.equals("") ))
						{
							sb.append("<br>"+str_error_text+"<br> ") ;
							//System.out.println("sb mesage in Error is:"+sb);
						}
						else
						{
							if(str_sysmesage_id.indexOf("|") != (-1)){
								msgIds=new StringTokenizer(str_sysmesage_id,"|");
								while(msgIds.hasMoreTokens())
								{
									messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
									sb.append((String)messageHashtable.get("message")+"<br>");
								}
								//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
							}else{
								messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
								sb.append((String)messageHashtable.get("message"));
								//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
							}
						}
					}
					if(insert && "Y".equals(recModified)){
						if(eff_to_date==null || eff_to_date.equals("")){
							update_blng_grp_discount_cstmt = con.prepareCall(update_blng_grp_discount_sql1);
							eff_to_date=null;
						}else{
							update_blng_grp_discount_cstmt = con.prepareCall(update_blng_grp_discount_sql);
						}
						update_blng_grp_discount_cstmt.setString(1,facility_id);
						update_blng_grp_discount_cstmt.setString(2,packageCode);
						update_blng_grp_discount_cstmt.setString(3,blng_grp_code);
						update_blng_grp_discount_cstmt.setString(4,blng_class_code);
						update_blng_grp_discount_cstmt.setString(5,eff_from_date);
						update_blng_grp_discount_cstmt.setString(6,eff_to_date);
						update_blng_grp_discount_cstmt.setString(7,discount);
						update_blng_grp_discount_cstmt.setString(8,discount_type);
						update_blng_grp_discount_cstmt.setString(9,user_id);
						update_blng_grp_discount_cstmt.setString(10,client_ip_address );
						update_blng_grp_discount_cstmt.setString(11,facility_id);
						update_blng_grp_discount_cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
						update_blng_grp_discount_cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
						update_blng_grp_discount_cstmt.registerOutParameter(14,java.sql.Types.VARCHAR);
						//GHL-CRF-0502 Starts
						update_blng_grp_discount_cstmt.setString(15,age_group_code );
						update_blng_grp_discount_cstmt.setString(16,specialty_code );
						//GHL-CRF-0502 Ends
						update_blng_grp_discount_cstmt.execute();

						str_error_level=update_blng_grp_discount_cstmt.getString(12);
						str_sysmesage_id=update_blng_grp_discount_cstmt.getString(13);
						str_error_text=update_blng_grp_discount_cstmt.getString(14);
						if(str_error_level==null) str_error_level="";
						if(str_sysmesage_id==null) str_sysmesage_id="";
						if(str_error_text==null) str_error_text="";
						/*System.out.println("str_error_level in process rate based insertion:"+str_error_level);
						System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
						System.out.println("str_error_text in process rate based insertion:"+str_error_text);*/
						if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
						{
							insert=false;
							sb.append("<br>"+str_error_text+"<br> ") ;
						}
						if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
						{
							insert=false;
							if((str_error_level.equals("10") && !str_error_text.equals("") ))
							{
								sb.append("<br>"+str_error_text+"<br> ") ;
							//	System.out.println("sb mesage in Error is:"+sb);
							}
							else
							{
								if(str_sysmesage_id.indexOf("|") != (-1)){
									msgIds=new StringTokenizer(str_sysmesage_id,"|");
									while(msgIds.hasMoreTokens())
									{
										messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
										sb.append((String)messageHashtable.get("message")+"<br>");
									}
									//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
								}else{
									messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
									sb.append((String)messageHashtable.get("message"));
								//	System.out.println("sb mesage in str_sysmesage_id is:"+sb);
								}
							}
						}
						if(update_blng_grp_discount_cstmt!=null)
				update_blng_grp_discount_cstmt.close();//ADDED BY RAM FOR CHK STYLE
					}

					if(isBlngGrpDiscountUpdated_cstmt!=null)
				isBlngGrpDiscountUpdated_cstmt.close(); //ADDED BY RAM FOR CHK STYLE
				}
				else{//insert
					if(eff_to_date==null || eff_to_date.equals("")){
					blng_grp_discount_cstmt = con.prepareCall(blng_grp_discount_sql1);
					eff_to_date=null;
				}else{
					blng_grp_discount_cstmt = con.prepareCall(blng_grp_discount_sql);
				}
				blng_grp_discount_cstmt.setString(1,facility_id);
				blng_grp_discount_cstmt.setString(2,packageCode);
				blng_grp_discount_cstmt.setString(3,blng_grp_code);
				blng_grp_discount_cstmt.setString(4,blng_class_code);
				blng_grp_discount_cstmt.setString(5,eff_from_date);
				blng_grp_discount_cstmt.setString(6,eff_to_date);
				blng_grp_discount_cstmt.setString(7,discount);
				blng_grp_discount_cstmt.setString(8,discount_type);
				blng_grp_discount_cstmt.setString(9,user_id);
				blng_grp_discount_cstmt.setString(10,user_id);
				blng_grp_discount_cstmt.setString(11,client_ip_address);
				blng_grp_discount_cstmt.setString(12,facility_id);
				blng_grp_discount_cstmt.setString(13,client_ip_address);
				blng_grp_discount_cstmt.setString(14,facility_id);
				blng_grp_discount_cstmt.registerOutParameter(15,java.sql.Types.VARCHAR);
				blng_grp_discount_cstmt.registerOutParameter(16,java.sql.Types.VARCHAR);
				blng_grp_discount_cstmt.registerOutParameter(17,java.sql.Types.VARCHAR);
				//GHL-CRF-0502 Starts
				blng_grp_discount_cstmt.setString(18,age_group_code);
				blng_grp_discount_cstmt.setString(19,specialty_code);
				//GHL-CRF-0502 Ends
				if(null != discount && !discount.equals("")) {
					blng_grp_discount_cstmt.execute();
				}

				str_error_level=blng_grp_discount_cstmt.getString(15);
				str_sysmesage_id=blng_grp_discount_cstmt.getString(16);
				str_error_text=blng_grp_discount_cstmt.getString(17);
				if(str_error_level==null) str_error_level="";
				if(str_sysmesage_id==null) str_sysmesage_id="";
				if(str_error_text==null) str_error_text="";
				/*System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
				System.out.println("str_error_text in process:"+str_error_text);
				System.out.println("str_error_text in process:"+str_error_text);*/
				if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
				{
					insert=false;
					sb.append("<br>"+str_error_text+"<br> ") ;
				}
				if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
				{
					insert=false;
					if((str_error_level.equals("10") && !str_error_text.equals("") ))
					{
						sb.append("<br>"+str_error_text+"<br> ") ;
						//System.out.println("sb mesage in Error is:"+sb);
					}
					else
					{
						if(str_sysmesage_id.indexOf("|") != (-1)){
								msgIds=new StringTokenizer(str_sysmesage_id,"|");
								while(msgIds.hasMoreTokens())
								{
									messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
									sb.append((String)messageHashtable.get("message")+"<br>");
								}
								//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
							}else{
								messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
								sb.append((String)messageHashtable.get("message"));
							//	System.out.println("sb mesage in str_sysmesage_id is:"+sb);
							}
						}
					}
					if(blng_grp_discount_cstmt!=null)
				blng_grp_discount_cstmt.close(); //ADDED BY RAM CHK STYLE
				}//insert

			}//while
			if(isBlngGrpDiscountUpdated_cstmt!=null)
				isBlngGrpDiscountUpdated_cstmt.close();
			if(update_blng_grp_discount_cstmt!=null)
				update_blng_grp_discount_cstmt.close();
			if(blng_grp_discount_cstmt!=null)
				blng_grp_discount_cstmt.close();

			if(isCustDiscountUpdated_cstmt!=null)
				isCustDiscountUpdated_cstmt.close();
		}// if
	}catch(Exception e){
		System.err.println("Exception in modifyDiscountDtls() of PkgDef Ejb="+e);
		e.printStackTrace();
	}
	finally
		{
			try{
				if(isCustDiscountUpdated_cstmt!=null) isCustDiscountUpdated_cstmt.close();
				if(isCustDiscountUpdated_cstmt!=null) isCustDiscountUpdated_cstmt.close();
				if(isBlngGrpDiscountUpdated_cstmt!=null) isBlngGrpDiscountUpdated_cstmt.close();
				if(update_blng_grp_discount_cstmt!=null) update_blng_grp_discount_cstmt.close();
				if(cust_discount_cstmt!=null) cust_discount_cstmt.close();
				if(blng_grp_discount_cstmt!=null) blng_grp_discount_cstmt.close();
			}catch(Exception r)	{
				r.printStackTrace();
			}
		}

	return_mess.put("status",new Boolean(insert));
	return_mess.put("error",str_error_text);
	return_mess.put("sys_error",sys_err.toString());
	return_mess.put("message",str_sysmesage_id);
	return return_mess;
}
	@SuppressWarnings("rawtypes")
	public boolean existsInDB(String key,String[] record,HashMap db_collection,String func_mode) //throws Exception
	{

		boolean existsInDB=false;
		String db_record[];
		ArrayList list=new ArrayList();    
		try{
			if(db_collection!=null && db_collection.size()>0 && db_collection.containsKey(key)){
				list=(ArrayList)(db_collection.get(key));
				for(int i=0;i<list.size();i++){
				  db_record=(String[])list.get(i);
				//  if(func_mode.equals("CUSTOMER") || func_mode.equals("CUST_PERIOD") || func_mode.equals("CUST_PRICE")  || func_mode.equals("CUST_CHARGE_BASED") || func_mode.equals("CUST_CHARGE_BASED_ITEM")){
					 if(func_mode.equals("CUSTOMER") || func_mode.equals("CUST_PERIOD") || func_mode.equals("CUST_PRICE")){
						if(record[0].equals(db_record[0])){
							existsInDB=true;
						}
					}else if(func_mode.equals("CUST_RATE_BASED") || func_mode.equals("CUST_SRVLIMIT_RATE_BASED")||func_mode.equals("CUST_CHARGE_BASED") || func_mode.equals("CUST_CHARGE_BASED_ITEM")){
						if(record[1].equals(db_record[1])){
							existsInDB=true;
						}
					}
				  }
			}
		}catch(Exception e){
			System.err.println("Exception in existsInDB of PkgDefManager.java="+e);
			e.printStackTrace();
		}
		System.out.println("existsInDB="+existsInDB);
		return existsInDB;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	public boolean deleteAllDBRecs(Connection con,HashMap db_collection,HashMap bean_collection,String facility_id,String package_code,String func_mode) //throws Exception
	{

			boolean result=true;
			if(func_mode!=null && !func_mode.equals("")){
			PreparedStatement pstmt 	= null;
			PreparedStatement pstmt1 	= null;

			Set<String> keySet=(Set<String>)db_collection.keySet();
			Iterator<String> custIt=keySet.iterator();
			String key="";
			StringTokenizer stKey;
			String sqlDelete="";
			String sqlDelete1="";

			String code="";
			String record[];
			String db_record[];
			boolean delete=true;
			int count_del=0;
			ArrayList db_collection_list=new ArrayList();
			String cust_grp_code="";
			String cust_code="";
			String fromDate="";
			String pkg_serv_code="";
			ArrayList bean_list=new ArrayList();			
			try
			{
				//con = ConnectionManager.getConnection(p);
				while(custIt.hasNext()){
					key=(String)custIt.next();
					db_collection_list=(ArrayList)db_collection.get(key);
					if(db_collection_list!=null && db_collection_list.size()>0 )
					{
						stKey=new StringTokenizer(key,"~~");
						if(stKey.hasMoreTokens()){
							cust_grp_code=stKey.nextToken();
						}else{
							cust_grp_code="";
						}
						if(stKey.hasMoreTokens())
							cust_code=stKey.nextToken();
						else
							cust_code="";
						if(stKey.hasMoreTokens())
							fromDate=stKey.nextToken();
						else
							fromDate="";
						if(stKey.hasMoreTokens())
							pkg_serv_code=stKey.nextToken();
						else
							pkg_serv_code="";						
							if(key!=null && !key.equals("") && !key.startsWith("~~")){
						if(bean_collection!=null && bean_collection.size()>0 && bean_collection.containsKey(key)){
							bean_list=(ArrayList)bean_collection.get(key);
							if(func_mode.equals("CUST_RATE_BASED")){
								//if(pstmt!=null) pstmt=null;
								if(pstmt!=null) pstmt.close();
								//if(pstmt1!=null) pstmt1=null;
								if(pstmt1!=null) pstmt1.close();
								sqlDelete = "delete from BL_PACKAGE_COVERAGE_FOR_CUST where operating_Facility_id=? and package_code=? and cust_group_code=? and cust_code=? and eff_from_date=to_date(?,'dd/mm/yyyy') and rate_charge_ind='R' and pkg_serv_code=?";
								sqlDelete1 = "delete from BL_PACKAGE_EXCL_FOR_CUST where operating_Facility_id=? and package_code=? and cust_group_code=? and cust_code=? and eff_from_date=to_date(?,'dd/mm/yyyy')and rate_charge_ind='R' and pkg_serv_code=? ";
								pstmt=con.prepareStatement(sqlDelete);
								pstmt1=con.prepareStatement(sqlDelete1);
								for(int i=0; i<db_collection_list.size(); i++){//delete only the once deleted by the user
									db_record=(String[])db_collection_list.get(i);
									code=db_record[1];
									delete=true;
									for(int j=0;j<bean_list.size();j++){
										record=(String[]) bean_list.get(j);
										if(record[1].equals(code)){
											delete=false;
											break;
										}
									}
									System.out.println("delete data manager moana "+delete);
									if(delete){
										count_del++;
										pstmt.setString(1,facility_id);
										pstmt.setString(2,package_code);
										pstmt.setString(3,cust_grp_code);
										pstmt.setString(4,cust_code);
										pstmt.setString(5,fromDate);
										pstmt.setString(6,code);
										pstmt.addBatch();

										pstmt1.setString(1,facility_id);
										pstmt1.setString(2,package_code);
										pstmt1.setString(3,cust_grp_code);
										pstmt1.setString(4,cust_code);
										pstmt1.setString(5,fromDate);
										pstmt1.setString(6,code);
										pstmt1.addBatch();

									}
								}
								if(count_del>0){
									pstmt1.executeBatch();
									pstmt.executeBatch();
								}
							}
							else if(func_mode.equals("CUST_SRVLIMIT_RATE_BASED")){
							//	if(pstmt!=null) pstmt=null;
							if(pstmt!=null) pstmt.close();
								sqlDelete = "delete from BL_PACKAGE_EXCL_FOR_CUST where operating_Facility_id=? and package_code=? and cust_group_code=? and cust_code=? and eff_from_date=to_date(?,'dd/mm/yyyy') and rate_charge_ind='R' and pkg_serv_code=? and excl_serv_code=?";
								pstmt=con.prepareStatement(sqlDelete);
								for(int i=0; i<db_collection_list.size(); i++){//delete only the once deleted by the user
									db_record=(String[])db_collection_list.get(i);
									code=db_record[1];
									delete=true;
									//System.out.println("code="+code);

									for(int j=0;j<bean_list.size();j++){
										record=(String[]) bean_list.get(j);
										if(record[1].equals(code)){
											delete=false;
											break;
										}
									}
									if(delete){
										count_del++;
										pstmt.setString(1,facility_id);
										pstmt.setString(2,package_code);
										pstmt.setString(3,cust_grp_code);
										pstmt.setString(4,cust_code);
										pstmt.setString(5,fromDate);
										pstmt.setString(6,pkg_serv_code);
										pstmt.setString(7,code);
										pstmt.addBatch();
									}
								}
								//System.out.println("count_del="+count_del);
								if(count_del>0){
									pstmt.executeBatch();
								}
							}
							else if(func_mode.equals("CUST_CHARGE_BASED")){
								//if(pstmt!=null) pstmt=null;
								if(pstmt!=null) pstmt.close();
								//if(pstmt1!=null) pstmt1=null;
								if(pstmt1!=null) pstmt1.close();
								sqlDelete = "delete from BL_PACKAGE_COVERAGE_FOR_CUST where operating_Facility_id=? and package_code=? and cust_group_code=? and cust_code=? and eff_from_date=to_date(?,'dd/mm/yyyy') and rate_charge_ind='C' and pkg_serv_code=?";
								sqlDelete1 = "delete from BL_PACKAGE_EXCL_FOR_CUST where operating_Facility_id=? and package_code=? and cust_group_code=? and cust_code=? and eff_from_date=to_date(?,'dd/mm/yyyy') and rate_charge_ind='C' and pkg_serv_code=? ";
								pstmt=con.prepareStatement(sqlDelete);
								pstmt1=con.prepareStatement(sqlDelete1);
								for(int i=0; i<db_collection_list.size(); i++){//delete only the once deleted by the user
									db_record=(String[])db_collection_list.get(i);
									code=db_record[0];
									delete=true;
									//System.out.println("code="+code);
									for(int j=0;j<bean_list.size();j++){
										record=(String[]) bean_list.get(j);
										if(record[0].equals(code)){
											delete=false;
											break;
										}
									}
									//System.out.println("delete="+delete);
									if(delete){
										count_del++;
										pstmt.setString(1,facility_id);
										pstmt.setString(2,package_code);
										pstmt.setString(3,cust_grp_code);
										pstmt.setString(4,cust_code);
										pstmt.setString(5,fromDate);
										pstmt.setString(6,code);
										pstmt.addBatch();

										pstmt1.setString(1,facility_id);
										pstmt1.setString(2,package_code);
										pstmt1.setString(3,cust_grp_code);
										pstmt1.setString(4,cust_code);
										pstmt1.setString(5,fromDate);
										pstmt1.setString(6,code);
										pstmt1.addBatch();

									}
								}
								//System.out.println("count_del="+count_del);
								if(count_del>0){
									pstmt.executeBatch();
									pstmt1.executeBatch();
								}
							}
							else if(func_mode.equals("CUST_CHARGE_BASED_ITEM")){
								//if(pstmt!=null) pstmt=null;
								if(pstmt!=null) pstmt.close();
								sqlDelete = "delete from BL_PACKAGE_EXCL_FOR_CUST where operating_Facility_id=? and package_code=? and cust_group_code=? and cust_code=? and eff_from_date=to_date(?,'dd/mm/yyyy') and rate_charge_ind='C' and pkg_serv_code=? and excl_serv_code=?";
								pstmt=con.prepareStatement(sqlDelete);
								for(int i=0; i<db_collection_list.size(); i++){//delete only the once deleted by the user
									db_record=(String[])db_collection_list.get(i);
									code=db_record[0];
									delete=true;
									//System.out.println("code="+code);

									for(int j=0;j<bean_list.size();j++){
										record=(String[]) bean_list.get(j);
										if(record[0].equals(code)){
											delete=false;
											break;
										}
									}
									if(delete){
										count_del++;
										pstmt.setString(1,facility_id);
										pstmt.setString(2,package_code);
										pstmt.setString(3,cust_grp_code);
										pstmt.setString(4,cust_code);
										pstmt.setString(5,fromDate);
										pstmt.setString(6,pkg_serv_code);
										pstmt.setString(7,code);
										pstmt.addBatch();
									}
								}
								//System.out.println("count_del="+count_del);
								if(count_del>0){
									pstmt.executeBatch();
								}
							}
						}
						else {
							if(func_mode.equals("CUST_RATE_BASED")){
								//if(pstmt!=null) pstmt=null;
								if(pstmt!=null) pstmt.close();
								sqlDelete = "delete from BL_PACKAGE_COVERAGE_FOR_CUST where operating_Facility_id=? and package_code=? and cust_group_code=? and cust_code=? and eff_from_date=to_date(?,'dd/mm/yyyy') and rate_charge_ind='R'";
								pstmt=con.prepareStatement(sqlDelete);
								pstmt.setString(1,facility_id);
								pstmt.setString(2,package_code);
								pstmt.setString(3,cust_grp_code);
								pstmt.setString(4,cust_code);
								pstmt.setString(5,fromDate);
								pstmt.executeUpdate();
								//if(pstmt!=null) pstmt=null;
								if(pstmt!=null) pstmt.close();
								sqlDelete = "delete from BL_PACKAGE_EXCL_FOR_CUST where operating_Facility_id=? and package_code=? and cust_group_code=? and cust_code=? and eff_from_date=to_date(?,'dd/mm/yyyy') and rate_charge_ind='R'";
								pstmt=con.prepareStatement(sqlDelete);
								pstmt.setString(1,facility_id);
								pstmt.setString(2,package_code);
								pstmt.setString(3,cust_grp_code);
								pstmt.setString(4,cust_code);
								pstmt.setString(5,fromDate);
								pstmt.executeUpdate();
							}
							else if(func_mode.equals("CUST_SRVLIMIT_RATE_BASED")){
								//if(pstmt!=null) pstmt=null;
								if(pstmt!=null) pstmt.close();
								sqlDelete = "delete from BL_PACKAGE_EXCL_FOR_CUST where operating_Facility_id=? and package_code=? and cust_group_code=? and cust_code=? and eff_from_date=to_date(?,'dd/mm/yyyy')  and pkg_serv_code=? and rate_charge_ind='R'";
								pstmt=con.prepareStatement(sqlDelete);
								pstmt.setString(1,facility_id);
								pstmt.setString(2,package_code);
								pstmt.setString(3,cust_grp_code);
								pstmt.setString(4,cust_code);
								pstmt.setString(5,fromDate);
								pstmt.setString(6,pkg_serv_code);

								pstmt.executeUpdate();
							}
							else if(func_mode.equals("CUST_CHARGE_BASED")){
								//if(pstmt!=null) pstmt=null;
								if(pstmt!=null) pstmt.close();
								sqlDelete = "delete from BL_PACKAGE_COVERAGE_FOR_CUST where operating_Facility_id=? and package_code=? and cust_group_code=? and cust_code=? and eff_from_date=to_date(?,'dd/mm/yyyy') and rate_charge_ind='C'";
								pstmt=con.prepareStatement(sqlDelete);
								pstmt.setString(1,facility_id);
								pstmt.setString(2,package_code);
								pstmt.setString(3,cust_grp_code);
								pstmt.setString(4,cust_code);
								pstmt.setString(5,fromDate);

								pstmt.executeUpdate();
								//if(pstmt!=null) pstmt=null;
								if(pstmt!=null) pstmt.close();
								sqlDelete = "delete from BL_PACKAGE_EXCL_FOR_CUST where operating_Facility_id=? and package_code=? and cust_group_code=? and cust_code=? and eff_from_date=to_date(?,'dd/mm/yyyy')  and rate_charge_ind='C'";
								pstmt=con.prepareStatement(sqlDelete);
								pstmt.setString(1,facility_id);
								pstmt.setString(2,package_code);
								pstmt.setString(3,cust_grp_code);
								pstmt.setString(4,cust_code);
								pstmt.setString(5,fromDate);
								pstmt.executeUpdate();
							}
							else if(func_mode.equals("CUST_CHARGE_BASED_ITEM")){
								//if(pstmt!=null) pstmt=null;
								if(pstmt!=null) pstmt.close();
								sqlDelete = "delete from BL_PACKAGE_EXCL_FOR_CUST where operating_Facility_id=? and package_code=? and cust_group_code=? and cust_code=? and eff_from_date=to_date(?,'dd/mm/yyyy')  and pkg_serv_code=? and rate_charge_ind='C'";
								pstmt=con.prepareStatement(sqlDelete);
								pstmt.setString(1,facility_id);
								pstmt.setString(2,package_code);
								pstmt.setString(3,cust_grp_code);
								pstmt.setString(4,cust_code);
								pstmt.setString(5,fromDate);
								pstmt.setString(6,pkg_serv_code);
								pstmt.executeUpdate();
							}
						}
						}
					}
				}
				if(pstmt!=null) pstmt.close();
				if(pstmt1!=null) pstmt1.close();
			}catch(Exception e)
			{
				result=false;
				System.err.println("Exception on deletion Change based :"+e);
				e.printStackTrace();
			}
			finally
			{
				try{
				if(pstmt!=null) pstmt.close();
				if(pstmt1!=null) pstmt1.close();
				}catch(Exception r)
				{r.printStackTrace();}

			}
			}
				return result;
	}
/* Karthik added this code for adding Partial deposit Records MMS-CRF-0023 - Starts */
@SuppressWarnings({"rawtypes", "unchecked"})
public HashMap<String, String> deletePartialDepositDetails(Connection con, HashMap<String, String> inputParameters)
{
  //System.out.println(inputParameters);

  CallableStatement partial_deposit_cstmt = null;
  String procErrorCode = null;
  String procErrorText = null;
  String procErrorLevel = null;
  StringBuffer sysError = new StringBuffer();
  boolean insertable = false;
  HashMap returnMessage = new HashMap();
  try {
    partial_deposit_cstmt = con.prepareCall("begin blpackage.delete_bl_pkg_deposit_dtls(?,?,?,?,?,?,?,?); end;");
    partial_deposit_cstmt.setString(1, (String)inputParameters.get("poperatingfacilityid"));
    partial_deposit_cstmt.setString(2, (String)inputParameters.get("ppackagecode"));

    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date utilDate = format.parse((String)inputParameters.get("pefffromdate"));
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
    partial_deposit_cstmt.setDate(3, sqlDate);

    partial_deposit_cstmt.setString(4, (String)inputParameters.get("pblngclasscode"));
    partial_deposit_cstmt.setString(5, (String)inputParameters.get("pencounterseqno"));
    partial_deposit_cstmt.registerOutParameter(6, 12);
    partial_deposit_cstmt.registerOutParameter(7, 12);
    partial_deposit_cstmt.registerOutParameter(8, 12);
    partial_deposit_cstmt.executeUpdate();

    procErrorLevel = partial_deposit_cstmt.getString(6);
    procErrorCode = partial_deposit_cstmt.getString(7);
    procErrorText = partial_deposit_cstmt.getString(8);

    if (procErrorLevel == null) procErrorLevel = "";
    if (procErrorCode == null) procErrorCode = "";
    if (procErrorText == null) procErrorText = "";

    if ((!procErrorCode.equals("")) || (!procErrorText.equals("")))
      insertable = false;
    else {
      insertable = true;
    }

  }
  catch (SQLException e)
  {
    e.printStackTrace();
    insertable = false;
    sysError.append("Exception while calling  delete_bl_pkg_deposit_dtls:" + e);

    if (partial_deposit_cstmt != null)
      try {
        partial_deposit_cstmt.close();
      }
      catch (SQLException sqle) {
        sysError.append("Error while closing  delete_bl_pkg_deposit_dtls:" + sqle);
        	sqle.printStackTrace();
      }
  }
  catch (Exception e1)
  {
    sysError.append("Error in EJB delete_bl_pkg_deposit_dtls():" + e1);

    if (partial_deposit_cstmt != null)
      try {
        partial_deposit_cstmt.close();
      }
      catch (SQLException e) {
        sysError.append("Error while closing  delete_bl_pkg_deposit_dtls:" + e);
        e.printStackTrace();
      }
  }
  finally
  {
    if (partial_deposit_cstmt != null) {
      try {
        partial_deposit_cstmt.close();
      }
      catch (SQLException e) {
        sysError.append("Error while closing  delete_bl_pkg_deposit_dtls:" + e);
        e.printStackTrace();
      }
    }
  }
  returnMessage.put("status", new Boolean(insertable).toString());
  returnMessage.put("error", procErrorText);
  returnMessage.put("sys_error", sysError.toString());
  returnMessage.put("message", procErrorCode);
  return returnMessage;
}
@SuppressWarnings({"rawtypes", "unchecked"})
public HashMap<String, String> deleteAllPartialDepositDetails(Connection con, HashMap<String, String> inputParameters)
{
  CallableStatement partial_deposit_cstmt = null;
  StringBuffer sysError = new StringBuffer();
  boolean insertable = false;
  HashMap returnMessage = new HashMap();
  try {
    partial_deposit_cstmt = con.prepareCall("delete from bl_package_deposit_dtls where OPERATING_FACILITY_ID=? and PACKAGE_CODE=? and EFF_FROM_DATE=? and BLNG_CLASS_CODE=?");
    partial_deposit_cstmt.setString(1, (String)inputParameters.get("poperatingfacilityid"));
    partial_deposit_cstmt.setString(2, (String)inputParameters.get("ppackagecode"));

    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date utilDate = format.parse((String)inputParameters.get("pefffromdate"));
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
    partial_deposit_cstmt.setDate(3, sqlDate);
    partial_deposit_cstmt.setString(4, (String)inputParameters.get("pblngclasscode"));
    partial_deposit_cstmt.executeUpdate();
    insertable = true;
  }
  catch (SQLException e) {
    e.printStackTrace();
    sysError.append("Exception while delete from bl_package_deposit_dtls:" + e);

    if (partial_deposit_cstmt != null)
      try {
        partial_deposit_cstmt.close();
      }
      catch (SQLException sqle) {
        sysError.append("Error while closing  delete_bl_pkg_deposit_dtls:" + sqle);
      }
  }
  catch (Exception e1)
  {
    sysError.append("Error in delete from bl_package_deposit_dtls:" + e1);

    if (partial_deposit_cstmt != null)
      try {
        partial_deposit_cstmt.close();
      }
      catch (SQLException e) {
        sysError.append("Error while closing  delete_bl_pkg_deposit_dtls:" + e);
        e.printStackTrace();
      }
  }
  finally
  {
    if (partial_deposit_cstmt != null) {
      try {
        partial_deposit_cstmt.close();
      }
      catch (SQLException e) {
        sysError.append("Error while closing  delete_bl_pkg_deposit_dtls:" + e);
        e.printStackTrace();
      }
    }
  }
  returnMessage.put("status", new Boolean(insertable).toString());
  returnMessage.put("sys_error", sysError.toString());
  return returnMessage;
}
@SuppressWarnings({"rawtypes", "unchecked"})
public HashMap<String, String> insertPartialDepositDetails(Connection con, HashMap<String, String> inputParameters)
{
  CallableStatement partial_deposit_cstmt = null;
  String procErrorCode = null;
  String procErrorText = null;
  String procErrorLevel = null;
  StringBuffer sysError = new StringBuffer();
  boolean insertable = false;
  HashMap returnMessage = new HashMap();
  try
  {
    partial_deposit_cstmt = con.prepareCall("begin blpackage.insert_bl_pkg_deposit_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); end;");

    partial_deposit_cstmt.setString(1, (String)inputParameters.get("poperatingfacilityid"));
    partial_deposit_cstmt.setString(2, (String)inputParameters.get("ppackagecode"));

    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date utilDate = format.parse((String)inputParameters.get("pefffromdate"));
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

    partial_deposit_cstmt.setDate(3, sqlDate);
    partial_deposit_cstmt.setString(4, (String)inputParameters.get("pblngclasscode"));
    partial_deposit_cstmt.setString(5, (String)inputParameters.get("pencounterseqno"));
    partial_deposit_cstmt.setString(6, (String)inputParameters.get("pminpartialdeposittype"));
    partial_deposit_cstmt.setString(7, (String)inputParameters.get("pminpartialdeposit"));
    partial_deposit_cstmt.setString(8, (String)inputParameters.get("pdepositmandatoryyn"));
    partial_deposit_cstmt.setString(9, (String)inputParameters.get("planguageid"));
    partial_deposit_cstmt.setString(10, (String)inputParameters.get("paddedbyid"));
    partial_deposit_cstmt.setString(11, (String)inputParameters.get("paddedfacilityid"));
    partial_deposit_cstmt.setString(12, (String)inputParameters.get("paddedatwsno"));
    partial_deposit_cstmt.registerOutParameter(13, 12);
    partial_deposit_cstmt.registerOutParameter(14, 12);
    partial_deposit_cstmt.registerOutParameter(15, 12);
    partial_deposit_cstmt.executeUpdate();

    procErrorLevel = partial_deposit_cstmt.getString(13);
    procErrorCode = partial_deposit_cstmt.getString(14);
    procErrorText = partial_deposit_cstmt.getString(15);

    if (procErrorLevel == null) procErrorLevel = "";
    if (procErrorCode == null) procErrorCode = "";
    if (procErrorText == null) procErrorText = "";

    if ((!procErrorCode.equals("")) || (!procErrorText.equals("")))
      insertable = false;
    else {
      insertable = true;
    }

  }
  catch (SQLException e)
  {
    e.printStackTrace();
    insertable = false;
    sysError.append("Exception while calling  insert_bl_pkg_deposit_dtls:" + e);

    if (partial_deposit_cstmt != null)
      try {
        partial_deposit_cstmt.close();
      }
      catch (SQLException sqle) {
        sysError.append("Error while closing  insert_bl_pkg_deposit_dtls:" + sqle);
      }
  }
  catch (Exception e1)
  {
    sysError.append("Error in EJB insert_bl_pkg_deposit_dtls():" + e1);

    if (partial_deposit_cstmt != null)
      try {
        partial_deposit_cstmt.close();
      }
      catch (SQLException e) {
        sysError.append("Error while closing  insert_bl_pkg_deposit_dtls:" + e);
        e.printStackTrace();
      }
  }
  finally
  {
    if (partial_deposit_cstmt != null) {
      try {
        partial_deposit_cstmt.close();
      }
      catch (SQLException e) {
        sysError.append("Error while closing  insert_bl_pkg_deposit_dtls:" + e);
        e.printStackTrace();
      }
    }
  }
  returnMessage.put("status", new Boolean(insertable).toString());
  returnMessage.put("error", procErrorText);
  returnMessage.put("sys_error", sysError.toString());
  returnMessage.put("message", procErrorCode);
  return returnMessage;
}

/* Karthik added this code for adding Partial deposit Records MMS-CRF-0023 - Ends */

@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public String getType(HashMap cust_rate_srv,ArrayList cust_rate_srv_list,String parent_service_code){
	String service_type="";
	Set<String>	keySet;
	Iterator<String> custIt;
	if( cust_rate_srv!=null && cust_rate_srv.size()>0 )
	{
		keySet=(Set<String>)cust_rate_srv.keySet();
		custIt=keySet.iterator();
		String[] record=new String[22];
		for(int ii=0;ii<cust_rate_srv_list.size();ii++){
				record=(String[])cust_rate_srv_list.get(ii);
				String type		 = record[0];
				String service_code = record[1];
				if(service_code.equals(parent_service_code)){
					service_type=type;
					if(service_type==null) service_type="";
					break;
				}

			}
	}	
	return service_type;	
}
//Added By Shikha For GHL-CRF-0520.1
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public String getTypeBlngGrp(HashMap blng_grp_rate_srv,ArrayList blng_grp_rate_srv_list,String parent_service_code){
	String service_type="";
	Set<String>	keySet;
	Iterator<String> blngGrpIt;
	if( blng_grp_rate_srv!=null && blng_grp_rate_srv.size()>0 )
	{
		keySet=(Set<String>)blng_grp_rate_srv.keySet();
		blngGrpIt=keySet.iterator();
		String[] record=new String[22];
		for(int ii=0;ii<blng_grp_rate_srv_list.size();ii++){
				record=(String[])blng_grp_rate_srv_list.get(ii);
				String type		 = record[0];
				String service_code = record[1];
				if(service_code.equals(parent_service_code)){
					service_type=type;
					if(service_type==null) service_type="";
					break;
				}

			}
	}	
	return service_type;	
}

@SuppressWarnings({"rawtypes","unused", "unchecked"})
public HashMap modifyBillingGroupDtls(Connection con,HashMap tabdata) //throws Exception{
{
	//System.out.println("in modifyBillingGroupDtls() tabdata="+tabdata.toString());
	HashMap return_mess = new HashMap();
	String amt_limit_ind = "";
	String roundTo = "";
	String roundInd= "";
	String blgClsCode = "";
	String fromDate="";
	String toDate="";
	String indicator="";
	String price1="";
	String factorAppl="";
	String deposit		   ="";
	String partialDeposit 	   ="";
	String minDepAmtind   	   ="";
	String minDepAmt	 	   ="";
	String factorforServiceRate =""; //Added by muthu
	String qtyLimit		 =	"";
	String refundAmt	 =	"";
	String factor_appl	 =	"";
	String itemCode      =  "";
	String itemDesc      =  "";
	String inExcl        =  "";		
	String 		recModified="";
	StringBuffer sb = new StringBuffer( "" ) ;
	Hashtable messageHashtable=new Hashtable();
	Set<String>	keySet;
	Iterator<String> blngGrpIt;
	String key="";
	String blng_grp_code="";
	String blng_grp_desc="";		
	String pkg_valid_days="";
	String pkgPriceClsCode="";
	String pkgPriceClsDesc="";
	String oPkgPriceClsCode="";
	String oPkgPriceClsDesc="";
	String glSmry="";
	String glSmryDesc="";
	String glSmryDisc="";
	String glSmryDiscDesc="";
	String VATapp="";
	String VATpercent="";
	String blgClsDesc        = "";
	String type="";
	String 		service_code			="";
	String 	    service_desc		="";
	String 		catalog_code			="";
	String 		catalog_desc		="";
	String 		ind			="";
	String 		factorOrRate		="";
	String 		qty_limit			="";
	String 		amt_limit		="";
	String 		replace		="N";
	String 		replaceSrv_code		="";
	String 		replaceSrv_desc		="";
	String 		replaceSrv_cat_code		="";
	String 		replaceSrv_cat_desc			="";
	String 		refund			="N";
	String		autoRefund		= "N";
	String      closePkg = "N";
	String		splitReqd	  = "Y";//Split reqd - Rajesh V
	String		includeHomeMedication	  = "Y";
	String cbType = "";//MuthuN against 28192
	String srvLmt = "";//MuthuN against 28192 on 8/27/2012
	String cbService = "";
	String cbServiceDesc = "";;
	String amountLimitInd = "";
	String amountLimit = "";
	String srvLimit_type		="";
	String 		srvLimit_service_code			="";
	String 	    srvLimit_service_desc		="";
	String 		exludeService			="N";
	String 		srvLimit_qty_limit		="";
	String 		srvLimit_amt_limit			="";
	String 		srvLimit_factor_appl			="";
	String 		srvLimit_amt_limit_ind	="";
	String 	    srvLimit_replace		="N";
	String 		srvLimit_replaceSrv_code="";
	String		srvLimit_replaceSrv_desc = "";
	String 		srvLimit_refund		="N";
	String 		srvLimit_refundAmt		="";
	String 		srvLimit_auto_refund			="N";
	String      srvLimit_roundTo = "";
	String      srvLimit_roundInd = "";
	String parent_service_code="";
	String dailyLmtChkBx = "";//Added V190320-Aravindh/MMS-DM-CRF-0129
	String dailyLmtAmt = "";//Added V190320-Aravindh/MMS-DM-CRF-0129
	String dailyLmtGrossNet = "";//Added V190320-Aravindh/MMS-DM-CRF-0129
	String dailyLmtIndicator = "";//Added V190626-Aravindh/MMS-DM-CRF-0129.1
	String dailyLmtQty = "";//Added V190626-Aravindh/MMS-DM-CRF-0129.1
	StringTokenizer stKey;
	StringTokenizer	msgIds;
	String[] record;
	boolean existsInDB=false;
	boolean insert = true;
	CallableStatement isBlngGrpPeriodUpdated_cstmt = null;
		CallableStatement update_blng_grp_period_cstmt = null;

try{
	String facility_id = (String) tabdata.get("FACILITY_ID");
	if(facility_id==null) facility_id="";

	String packageCode=(String)tabdata.get("packageCode");
	if(packageCode==null) packageCode="";

	String client_ip_address=(String)tabdata.get("client_ip_address");
	if(client_ip_address==null) client_ip_address="";

	String user_id=(String)tabdata.get("login_user");
	if(user_id==null) user_id="";

	String locale=(String)tabdata.get("locale");
	if(locale==null) locale="en";

	HashMap blng_grp_dtls = (HashMap)tabdata.get("blng_grp_dtls");
	HashMap blng_grp_period = (HashMap)tabdata.get("blng_grp_period");
	HashMap blng_grp_base_price = (HashMap)tabdata.get("blng_grp_base_price");
	HashMap blng_grp_rate_srv = (HashMap)tabdata.get("blng_grp_rate_srv");
	HashMap blng_grp_rate_srv_excl = (HashMap)tabdata.get("blng_grp_rate_srv_excl");
	HashMap blng_grp_charge_srv = (HashMap)tabdata.get("blng_grp_charge_srv");
	HashMap blng_grp_charge_srv_excl = (HashMap)tabdata.get("blng_grp_charge_srv_excl");

	HashMap db_blng_grp_dtls = (HashMap)tabdata.get("db_blng_grp_dtls");
	HashMap db_blng_grp_period = (HashMap)tabdata.get("db_blng_grp_period");
	HashMap db_blng_grp_base_price = (HashMap)tabdata.get("db_blng_grp_base_price");
	HashMap db_blng_grp_rate_srv = (HashMap)tabdata.get("db_blng_grp_rate_srv");
	HashMap db_blng_grp_rate_srv_excl = (HashMap)tabdata.get("db_blng_grp_rate_srv_excl");
	HashMap db_blng_grp_charge_srv = (HashMap)tabdata.get("db_blng_grp_charge_srv");
	HashMap db_blng_grp_charge_srv_excl = (HashMap)tabdata.get("db_blng_grp_charge_srv_excl");

	String modify_blng_grp=(String)tabdata.get("modify_blng_grp");
	String modify_blng_grp_period=(String)tabdata.get("modify_blng_grp_period");
	String modify_blng_grp_base_price=(String)tabdata.get("modify_blng_grp_base_price");
	String modify_blng_grp_rate_srv=(String)tabdata.get("modify_blng_grp_rate_srv");
	String modify_blng_grp_rate_srv_excl=(String)tabdata.get("modify_blng_grp_rate_srv_excl");
	String modify_blng_grp_charge_srv=(String)tabdata.get("modify_blng_grp_charge_srv");
	String modify_blng_grp_charge_srv_excl=(String)tabdata.get("modify_blng_grp_charge_srv_excl");
	/****************insert stmts*****start****/
	String sql   ="{ call   blpackage.insertpackagebgdtls (?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?)}";
	CallableStatement blng_grp_cstmt = con.prepareCall(sql);
//	System.out.println("200525 1="+blng_grp_dtls+"/"+blng_grp_period);
	String blng_grp_period_sql   ="{ call   blpackage.insertpackagebgperiod (?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?)}";
	String blng_grp_period_sql1   ="{ call   blpackage.insertpackagebgperiod (?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?)}";
//	System.out.println("200525 1 blng_grp_period_sql="+blng_grp_period_sql);
//	System.out.println("200525 1 blng_grp_period_sql1="+blng_grp_period_sql1);
	CallableStatement blng_grp_period_cstmt = null;
	sql="{ call   blpackage.insertpackagebgprice (?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?)}";//Added by Muthu on 26-6-12
	System.out.println("blpackage.insertpackagebgprice Entering  2");
	CallableStatement blng_grp_price_cstmt = con.prepareCall(sql);		
	sql="{ call   blpackage.insertpackageserviceforbg  (?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";	 
	CallableStatement blng_grp_rate_srv_cstmt = con.prepareCall(sql);		
	sql="{ call   blpackage.insertpackageexclforbg  (?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	CallableStatement blng_grp_rate_srv_excl_cstmt = con.prepareCall(sql);	
	sql="{ call   blpackage.insertpackageserviceforbg  (?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";	 
	CallableStatement blng_grp_charge_srv_cstmt = con.prepareCall(sql);	
	sql="{ call   blpackage.insertpackageexclforbg  (?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	CallableStatement blng_grp_charge_srv_excl_cstmt = con.prepareCall(sql);
	/****************insert stmts*****end****/
	/****************update stmts*****start****/
	sql   ="{ call   blpackage.ispkgbgdtlsrecordchanged (?,?,?,?,?,?,?,?)}";
	CallableStatement isBlngGrpUpdated_cstmt = con.prepareCall(sql);
	sql   ="{ call   blpackage.updatepackagebgdtls (?,?,?,?,?,sysdate,?,?,?,?,?)}";
	CallableStatement update_blng_grp_cstmt = con.prepareCall(sql);
	String isBlngGrpPeriodUpdated_sql   ="{ call   blpackage.ispkgbgperiodrecordchanged (?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?)}";
	String isBlngGrpPeriodUpdated_sql1   ="{ call   blpackage.ispkgbgperiodrecordchanged (?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?)}";

	String update_blng_grp_period_sql   ="{ call   blpackage.updatepackagebgperiod (?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?)}";
	String update_blng_grp_period_sql1   ="{ call   blpackage.updatepackagebgperiod (?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?)}";
//System.out.println("200525 3 update_blng_grp_period_sql="+update_blng_grp_period_sql);
//System.out.println("200525 4 update_blng_grp_period_sql1="+update_blng_grp_period_sql1);
	sql="{ call   blpackage.ispkgbgpricerecordchanged (?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";//Added by muthu on 26-6-12
	CallableStatement isBlngGrpPriceUpdated_cstmt = con.prepareCall(sql);
	sql="{ call   blpackage.updatepackagebgprice (?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?,?)}";//Added by muthu on 26-6-12
	CallableStatement update_blng_grp_price_cstmt = con.prepareCall(sql);		
	sql="{ call   blpackage.ispkgservforbgrecordchanged (?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";	 
	CallableStatement isBlngGrpRateSrvUpdated_cstmt = con.prepareCall(sql);
	sql="{ call   blpackage.updatepackageservforbg  (?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?)}";	 
	CallableStatement update_blng_grp_rate_srv_cstmt = con.prepareCall(sql);		
	sql="{ call   blpackage.ispkgexclforbgrecordchanged (?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";	 
	CallableStatement isBlngGrpRateExclUpdated_cstmt = con.prepareCall(sql);		
	sql="{ call   blpackage.updatepackageexclforbg  (?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?)}";	 
	CallableStatement update_blng_grp_rate_srv_excl_cstmt = con.prepareCall(sql);		
	sql="{ call   blpackage.ispkgservforbgrecordchanged (?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";	 
	CallableStatement isBlngGrpChargeSrvUpdated_cstmt = con.prepareCall(sql);		
	sql="{ call   blpackage.updatepackageservforbg  (?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?)}";	 
	CallableStatement update_blng_grp_charge_srv_cstmt = con.prepareCall(sql);		
	sql="{ call   blpackage.ispkgexclforbgrecordchanged (?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";	 
	CallableStatement isBlngGrpChargeExclUpdated_cstmt = con.prepareCall(sql);		
	sql="{ call   blpackage.updatepackageexclforbg  (?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?)}";	 
	CallableStatement update_blng_grp_charge_srv_excl_cstmt = con.prepareCall(sql);
/****************update stmts*****end****/
	ArrayList blng_grp_period_list=new ArrayList();
	ArrayList blng_grp_price_list=new ArrayList();
	ArrayList blng_grp_rate_srv_list=new ArrayList();
	ArrayList blng_grp_rate_srv_excl_list=new ArrayList();
	ArrayList blng_grp_charge_srv_list=new ArrayList();
	ArrayList blng_grp_charge_srv_excl_list=new ArrayList();
	ArrayList inserted_blng_grp_period_list=new ArrayList();
	ArrayList inserted_blng_grp_rate_srv_list=new ArrayList();
	ArrayList inserted_blng_grp_charge_srv_list=new ArrayList();
	ArrayList split_reqd_list=new ArrayList(); //Split reqd
	ArrayList includeHomeMedication_list=new ArrayList();
	//System.out.println("blng_grp_dtls="+blng_grp_dtls.toString());
	//System.out.println("modify_blng_grp="+modify_blng_grp);
	try
	{
		if(insert && blng_grp_dtls!=null && blng_grp_dtls.size()>0 && modify_blng_grp.equals("Y") )
		{
			//System.out.println("blng_grp_dtls other operations");
			keySet=(Set<String>)blng_grp_dtls.keySet();
			//System.out.println("keySet="+keySet.toString());
			blngGrpIt=keySet.iterator();
			while(insert && blngGrpIt.hasNext()){
				record=new String[5];
				key=(String)blngGrpIt.next();
				//System.out.println("key="+key);
				record=(String[])blng_grp_dtls.get(key);
				blng_grp_code		= record[0];
				blng_grp_desc		= record[1];					
				pkg_valid_days		=record[2];
				/*System.out.println("facility_id="+facility_id);
				System.out.println("packageCode="+packageCode);
				System.out.println("blng_grp_code="+blng_grp_code);
				System.out.println("blng_grp_desc="+blng_grp_desc);					
				System.out.println("pkg_valid_days="+pkg_valid_days);*/
				if(db_blng_grp_dtls!=null && db_blng_grp_dtls.size()>0 && db_blng_grp_dtls.containsKey(key)){
					//chk if update is needed
					isBlngGrpUpdated_cstmt.setString(1,facility_id);
					isBlngGrpUpdated_cstmt.setString(2,packageCode);
					isBlngGrpUpdated_cstmt.setString(3,blng_grp_code);
					isBlngGrpUpdated_cstmt.setString(4,pkg_valid_days);
					isBlngGrpUpdated_cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
					isBlngGrpUpdated_cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
					isBlngGrpUpdated_cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
					isBlngGrpUpdated_cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
					isBlngGrpUpdated_cstmt.execute();

					recModified=isBlngGrpUpdated_cstmt.getString(5);
					str_error_level=isBlngGrpUpdated_cstmt.getString(6);
					str_sysmesage_id=isBlngGrpUpdated_cstmt.getString(7);
					str_error_text=isBlngGrpUpdated_cstmt.getString(8);
					if(str_error_level==null) str_error_level="";
					if(str_sysmesage_id==null) str_sysmesage_id="";
					if(str_error_text==null) str_error_text="";
					if(recModified == null)		recModified="";
					/*System.out.println("recModified:"+recModified);
					System.out.println("str_error_level in process rate based insertion:"+str_error_level);
					System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
					System.out.println("str_error_text in process rate based insertion:"+str_error_text);*/
					if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
					{
						insert=false;
						sb.append("<br>"+str_error_text+"<br> ") ;
					}
					if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
					{
						insert=false;
						if((str_error_level.equals("10") && !str_error_text.equals("") ))
						{
							sb.append("<br>"+str_error_text+"<br> ") ;
							//System.out.println("sb mesage in Error is:"+sb);
						}
						else
						{
							if(str_sysmesage_id.indexOf("|") != (-1)){
								msgIds=new StringTokenizer(str_sysmesage_id,"|");
								while(msgIds.hasMoreTokens())
								{
									messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
									sb.append((String)messageHashtable.get("message")+"<br>");
								}
								//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
							}else{
								messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
								sb.append((String)messageHashtable.get("message"));
								//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
							}
						}
					}
					if(insert && "Y".equals(recModified)){		
						update_blng_grp_cstmt.setString(1,facility_id);
						update_blng_grp_cstmt.setString(2,packageCode);
						update_blng_grp_cstmt.setString(3,blng_grp_code);							
						update_blng_grp_cstmt.setString(4,pkg_valid_days);
						update_blng_grp_cstmt.setString(5,user_id);
						update_blng_grp_cstmt.setString(6,client_ip_address );
						update_blng_grp_cstmt.setString(7,facility_id);
						update_blng_grp_cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
						update_blng_grp_cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
						update_blng_grp_cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
						update_blng_grp_cstmt.execute();

						str_error_level=update_blng_grp_cstmt.getString(8);
						str_sysmesage_id=update_blng_grp_cstmt.getString(9);
						str_error_text=update_blng_grp_cstmt.getString(10);
						if(str_error_level==null) str_error_level="";
						if(str_sysmesage_id==null) str_sysmesage_id="";
						if(str_error_text==null) str_error_text="";
						/*System.out.println("str_error_level in process rate based insertion:"+str_error_level);
						System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
						System.out.println("str_error_text in process rate based insertion:"+str_error_text);*/
						if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
						{
							insert=false;
							sb.append("<br>"+str_error_text+"<br> ") ;
						}
						if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
						{
							insert=false;
							if((str_error_level.equals("10") && !str_error_text.equals("") ))
							{
								sb.append("<br>"+str_error_text+"<br> ") ;
								//System.out.println("sb mesage in Error is:"+sb);
							}
							else
							{
								if(str_sysmesage_id.indexOf("|") != (-1)){
									msgIds=new StringTokenizer(str_sysmesage_id,"|");
									while(msgIds.hasMoreTokens())
									{
										messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
										sb.append((String)messageHashtable.get("message")+"<br>");
									}
									//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
								}else{
									messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
									sb.append((String)messageHashtable.get("message"));
									//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
								}
							}
						}
					}
				}
				else{//insert
					blng_grp_cstmt.setString(1,facility_id);
					blng_grp_cstmt.setString(2,packageCode);
					blng_grp_cstmt.setString(3,blng_grp_code);						
					blng_grp_cstmt.setString(4,pkg_valid_days);
					blng_grp_cstmt.setString(5,user_id);
					blng_grp_cstmt.setString(6,user_id);
					blng_grp_cstmt.setString(7,client_ip_address);
					blng_grp_cstmt.setString(8,facility_id);
					blng_grp_cstmt.setString(9,client_ip_address);
					blng_grp_cstmt.setString(10,facility_id);
					blng_grp_cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
					blng_grp_cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
					blng_grp_cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
					blng_grp_cstmt.execute();

					str_error_level=blng_grp_cstmt.getString(11);
					str_sysmesage_id=blng_grp_cstmt.getString(12);
					str_error_text=blng_grp_cstmt.getString(13);
					if(str_error_level==null) str_error_level="";
					if(str_sysmesage_id==null) str_sysmesage_id="";
					if(str_error_text==null) str_error_text="";
					/*System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
					System.out.println("str_error_text in process:"+str_error_text);
					System.out.println("str_error_text in process:"+str_error_text);*/
					if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
					{
						insert=false;
						sb.append("<br>"+str_error_text+"<br> ") ;
					}
					if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
					{
						insert=false;
						if((str_error_level.equals("10") && !str_error_text.equals("") ))
						{
							sb.append("<br>"+str_error_text+"<br> ") ;
							//System.out.println("sb mesage in Error is:"+sb);
						}
						else
						{
							if(str_sysmesage_id.indexOf("|") != (-1)){
								msgIds=new StringTokenizer(str_sysmesage_id,"|");
								while(msgIds.hasMoreTokens())
								{
									messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
									sb.append((String)messageHashtable.get("message")+"<br>");
								}
								//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
							}else{
								messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
								sb.append((String)messageHashtable.get("message"));
								//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
							}
						}
					}
				}//insert
			}//while
			if(isBlngGrpUpdated_cstmt!=null)
				isBlngGrpUpdated_cstmt.close();
			if(update_blng_grp_cstmt!=null)
				update_blng_grp_cstmt.close();
			if(blng_grp_cstmt!=null)
				blng_grp_cstmt.close();
		}// if
	}
	catch (Exception e)
	{
		System.err.println("Exception while updating Billing Group details:"+e);
		e.printStackTrace();
		insert=false;
	}
/*******Update Billing Group details************end********************/
/*******Update Billing Group period details************start********************/
try
	{
		if(insert && blng_grp_period!=null && blng_grp_period.size()>0 && modify_blng_grp_period.equals("Y") )
		{
			//System.out.println("other operations");
			keySet=(Set<String>)blng_grp_period.keySet();
			//System.out.println("keySet="+keySet.toString());
			blngGrpIt=keySet.iterator();
			/****************************/
			while(insert && blngGrpIt.hasNext()){
				key=(String)blngGrpIt.next();
				blng_grp_period_list=(ArrayList)blng_grp_period.get(key);
				if(blng_grp_period_list!=null && blng_grp_period_list.size()>0 ){
					stKey=new StringTokenizer(key,"~~");
//					System.out.println("13420 skey="+stKey);
					if(stKey.hasMoreTokens()){
						blng_grp_code=stKey.nextToken();
					}else{
						blng_grp_code="";
					}
//					System.out.println("13426 blng_grp_code="+blng_grp_code+"/"+insert+"/"+blng_grp_dtls.size()+"/"+blng_grp_period_list.size()+"/"+ blng_grp_dtls.containsKey(blng_grp_code)+"/"+blng_grp_dtls);
					if(insert && !blng_grp_code.equals("") && blng_grp_dtls!=null && blng_grp_dtls.size()>0 && blng_grp_dtls.containsKey(blng_grp_code)){		
//						System.out.println("13431");
						for(int i=0;i<blng_grp_period_list.size();i++){
//							System.out.println("13434");
							record=(String[])blng_grp_period_list.get(i);
							fromDate		= record[0];
							toDate		= record[1];
							pkgPriceClsCode	=	record[2];
							pkgPriceClsDesc		=record[3];
							oPkgPriceClsCode		=record[4];
							oPkgPriceClsDesc		=record[5];
							glSmry		=record[6];
							glSmryDesc		=record[7];
							glSmryDisc		=record[8];
							glSmryDiscDesc		=record[9];
							VATapp     =record[10];
							VATpercent  =record[11];
							String VATruleCoverage  =record[12];
							String flagVal_blng_grp  =record[13];
//							System.out.println("13450");
							existsInDB=existsInDBBlngGrp(blng_grp_code,record,db_blng_grp_period,"BLNG_GRP_PERIOD");
//							System.out.println("13452");
							inserted_blng_grp_period_list.add(blng_grp_code.trim()+"~~"+fromDate.trim());
							/*System.out.println("facility_id="+facility_id);
							System.out.println("packageCode="+packageCode);
							System.out.println("blng_grp_code="+blng_grp_code);
							System.out.println("fromDate="+fromDate);
							System.out.println("toDate="+toDate);
							System.out.println("pkgPriceClsCode="+pkgPriceClsCode);
							System.out.println("pkgPriceClsDesc="+pkgPriceClsDesc);
							System.out.println("oPkgPriceClsCode="+oPkgPriceClsCode);
							System.out.println("oPkgPriceClsDesc="+oPkgPriceClsDesc);
							System.out.println("glSmry="+glSmry);
							System.out.println("glSmryDesc="+glSmryDesc);
							System.out.println("existsInDB="+existsInDB);*/
							if(existsInDB){
								//chk if update is needed
								if(toDate==null || toDate.equals("")){
									isBlngGrpPeriodUpdated_cstmt = con.prepareCall(isBlngGrpPeriodUpdated_sql1);
									toDate=null;
								}else{
									isBlngGrpPeriodUpdated_cstmt = con.prepareCall(isBlngGrpPeriodUpdated_sql);
								}//System.out.println("13463");

								isBlngGrpPeriodUpdated_cstmt.setString(1,facility_id);
								isBlngGrpPeriodUpdated_cstmt.setString(2,packageCode);
								isBlngGrpPeriodUpdated_cstmt.setString(3,blng_grp_code);									
								isBlngGrpPeriodUpdated_cstmt.setString(4,fromDate);
								isBlngGrpPeriodUpdated_cstmt.setString(5,toDate );
								isBlngGrpPeriodUpdated_cstmt.setString(6,pkgPriceClsCode );
								isBlngGrpPeriodUpdated_cstmt.setString(7,oPkgPriceClsCode );
								isBlngGrpPeriodUpdated_cstmt.setString(8,glSmry );
								isBlngGrpPeriodUpdated_cstmt.setString(9,glSmryDisc );
								isBlngGrpPeriodUpdated_cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
								isBlngGrpPeriodUpdated_cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
								isBlngGrpPeriodUpdated_cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
								isBlngGrpPeriodUpdated_cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
								isBlngGrpPeriodUpdated_cstmt.setString(14,VATapp);
								isBlngGrpPeriodUpdated_cstmt.setString(15,VATpercent);
								isBlngGrpPeriodUpdated_cstmt.setString(16,VATruleCoverage);
								isBlngGrpPeriodUpdated_cstmt.execute();

								recModified=isBlngGrpPeriodUpdated_cstmt.getString(10);
								str_error_level=isBlngGrpPeriodUpdated_cstmt.getString(11);
								str_sysmesage_id=isBlngGrpPeriodUpdated_cstmt.getString(12);
								str_error_text=isBlngGrpPeriodUpdated_cstmt.getString(13);
								if(str_error_level==null) str_error_level="";
								if(str_sysmesage_id==null) str_sysmesage_id="";
								if(str_error_text==null) str_error_text="";
								if(recModified == null)		recModified="";
								/*System.out.println("recModified:"+recModified);
								System.out.println("str_error_level in process rate based insertion:"+str_error_level);
								System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
								System.out.println("str_error_text in process rate based insertion:"+str_error_text);*/
								if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
								{
									insert=false;
									sb.append("<br>"+str_error_text+"<br> ") ;
								}
								if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
								{
									insert=false;
									if((str_error_level.equals("10") && !str_error_text.equals("") ))
									{
										sb.append("<br>"+str_error_text+"<br> ") ;
										//System.out.println("sb mesage in Error is:"+sb);
									}
									else
									{
										if(str_sysmesage_id.indexOf("|") != (-1)){
											msgIds=new StringTokenizer(str_sysmesage_id,"|");
											while(msgIds.hasMoreTokens())
											{
												messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
												sb.append((String)messageHashtable.get("message")+"<br>");
											}
											//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
										}else{
											messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
											sb.append((String)messageHashtable.get("message"));
											//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
										}
									}
								}
//								System.out.println("recModified="+recModified+"/"+insert);
								if(insert && "Y".equals(recModified)){	
									if(toDate==null ||  toDate.equals("")){
										update_blng_grp_period_cstmt = con.prepareCall(update_blng_grp_period_sql1);
										toDate=null;
									}else{
										update_blng_grp_period_cstmt = con.prepareCall(update_blng_grp_period_sql);
									}

									update_blng_grp_period_cstmt.setString(1,facility_id);
									update_blng_grp_period_cstmt.setString(2,packageCode);
									update_blng_grp_period_cstmt.setString(3,blng_grp_code);										
									update_blng_grp_period_cstmt.setString(4,fromDate);
									update_blng_grp_period_cstmt.setString(5,toDate);
									update_blng_grp_period_cstmt.setString(6,pkgPriceClsCode);
									update_blng_grp_period_cstmt.setString(7,oPkgPriceClsCode);
									update_blng_grp_period_cstmt.setString(8,glSmry);
									update_blng_grp_period_cstmt.setString(9,glSmryDisc);
									update_blng_grp_period_cstmt.setString(10,user_id);
									update_blng_grp_period_cstmt.setString(11,client_ip_address );
									update_blng_grp_period_cstmt.setString(12,facility_id);
									update_blng_grp_period_cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
									update_blng_grp_period_cstmt.registerOutParameter(14,java.sql.Types.VARCHAR);
									update_blng_grp_period_cstmt.registerOutParameter(15,java.sql.Types.VARCHAR);
									update_blng_grp_period_cstmt.setString(16,VATapp);
									update_blng_grp_period_cstmt.setString(17,VATpercent);
									update_blng_grp_period_cstmt.setString(18,VATruleCoverage);
//									System.out.println("before update_blng_grp_period_cstmt");
									update_blng_grp_period_cstmt.execute();
//									System.out.println("after update_blng_grp_period_cstmt");
									str_error_level=update_blng_grp_period_cstmt.getString(13);
									str_sysmesage_id=update_blng_grp_period_cstmt.getString(14);
									str_error_text=update_blng_grp_period_cstmt.getString(15);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									/*System.out.println("str_error_level in process rate based insertion:"+str_error_level);
									System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
									System.out.println("str_error_text in process rate based insertion:"+str_error_text);*/
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insert=false;
										sb.append("<br>"+str_error_text+"<br> ") ;
									}
									if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
									{
										insert=false;
										if((str_error_level.equals("10") && !str_error_text.equals("") ))
										{
											sb.append("<br>"+str_error_text+"<br> ") ;
											//System.out.println("sb mesage in Error is:"+sb);
										}
										else
										{
											if(str_sysmesage_id.indexOf("|") != (-1)){
												msgIds=new StringTokenizer(str_sysmesage_id,"|");
												while(msgIds.hasMoreTokens())
												{
													messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
													sb.append((String)messageHashtable.get("message")+"<br>");
												}
											//	System.out.println("sb mesages in str_sysmesage_id is:"+sb);
											}else{
												messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
												sb.append((String)messageHashtable.get("message"));
											//	System.out.println("sb mesage in str_sysmesage_id is:"+sb);
											}
										}
									}
									if(update_blng_grp_period_cstmt!=null)
										update_blng_grp_period_cstmt.close(); //ADDED BY RAM FOR CHK STYLE
								}

								if(isBlngGrpPeriodUpdated_cstmt!=null)
									isBlngGrpPeriodUpdated_cstmt.close(); //ADDED BY RAM FOR CHK STYLE
							}
							else{//insert
								if(toDate==null || toDate.equals("")){
									blng_grp_period_cstmt = con.prepareCall(blng_grp_period_sql1);
									toDate=null;
								}else{
									blng_grp_period_cstmt = con.prepareCall(blng_grp_period_sql);
								}
								blng_grp_period_cstmt.setString(1,facility_id);
								blng_grp_period_cstmt.setString(2,packageCode);
								blng_grp_period_cstmt.setString(3,blng_grp_code);									
								blng_grp_period_cstmt.setString(4,fromDate);
								blng_grp_period_cstmt.setString(5,toDate);
								blng_grp_period_cstmt.setString(6,pkgPriceClsCode);
								blng_grp_period_cstmt.setString(7,oPkgPriceClsCode);
								blng_grp_period_cstmt.setString(8,glSmry);
								blng_grp_period_cstmt.setString(9,glSmryDisc);
								blng_grp_period_cstmt.setString(10,user_id);
								blng_grp_period_cstmt.setString(11,user_id);
								blng_grp_period_cstmt.setString(12,client_ip_address);
								blng_grp_period_cstmt.setString(13,facility_id);
								blng_grp_period_cstmt.setString(14,client_ip_address);
								blng_grp_period_cstmt.setString(15,facility_id);
								blng_grp_period_cstmt.registerOutParameter(16,java.sql.Types.VARCHAR);
								blng_grp_period_cstmt.registerOutParameter(17,java.sql.Types.VARCHAR);
								blng_grp_period_cstmt.registerOutParameter(18,java.sql.Types.VARCHAR);
								blng_grp_period_cstmt.setString(19,VATapp);
								blng_grp_period_cstmt.setString(20,VATpercent);
								blng_grp_period_cstmt.setString(21,VATruleCoverage);
//								System.out.println("200525 before blng_grp_period_cstmt");
								blng_grp_period_cstmt.execute();
//								System.out.println("200525 after blng_grp_period_cstmt");
								str_error_level=blng_grp_period_cstmt.getString(16);
								str_sysmesage_id=blng_grp_period_cstmt.getString(17);
								str_error_text=blng_grp_period_cstmt.getString(18);
								if(str_error_level==null) str_error_level="";
								if(str_sysmesage_id==null) str_sysmesage_id="";
								if(str_error_text==null) str_error_text="";
							/*	System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
								System.out.println("str_error_text in process:"+str_error_text);
								System.out.println("str_error_text in process:"+str_error_text);*/
								if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
								{
									insert=false;
									sb.append("<br>"+str_error_text+"<br> ") ;
								}
								if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
								{
									insert=false;
									if((str_error_level.equals("10") && !str_error_text.equals("") ))
									{
										sb.append("<br>"+str_error_text+"<br> ") ;
										//System.out.println("sb mesage in Error is:"+sb);
									}
									else
									{
										if(str_sysmesage_id.indexOf("|") != (-1)){
											msgIds=new StringTokenizer(str_sysmesage_id,"|");
											while(msgIds.hasMoreTokens())
											{
												messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
												sb.append((String)messageHashtable.get("message")+"<br>");
											}
										//	System.out.println("sb mesages in str_sysmesage_id is:"+sb);
										}else{
											messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
											sb.append((String)messageHashtable.get("message"));
										//	System.out.println("sb mesage in str_sysmesage_id is:"+sb);
										}
									}
								}
							}//insert
						}//for

					}	//if
				}	//if
			}//while
			if(isBlngGrpPeriodUpdated_cstmt!=null)
				isBlngGrpPeriodUpdated_cstmt.close();
			if(update_blng_grp_period_cstmt!=null)
				update_blng_grp_period_cstmt.close();
			if(blng_grp_period_cstmt!=null)
				blng_grp_period_cstmt.close();
		}//if
	}
	catch (Exception e)
	{
		System.err.println("Exception while updating Billing Group period details:"+e);
		e.printStackTrace();
		insert=false;
	}
	finally{
		if(isBlngGrpPeriodUpdated_cstmt!=null)
				isBlngGrpPeriodUpdated_cstmt.close();
			if(update_blng_grp_period_cstmt!=null)
				update_blng_grp_period_cstmt.close();
			if(blng_grp_period_cstmt!=null)
				blng_grp_period_cstmt.close();

	}
/*******Update Billing Group Period details************end********************/
/*******Update Billing Group Base Price details************start********************/
try
	{
		if(insert && blng_grp_base_price!=null && blng_grp_base_price.size()>0 && modify_blng_grp_base_price.equals("Y") )
		{
			//System.out.println("7641 Billing Group base");
			keySet=(Set<String>)blng_grp_base_price.keySet();
			//System.out.println("keySet="+keySet.toString());
			blngGrpIt=keySet.iterator();
			/****************************/
			while(insert && blngGrpIt.hasNext()){
				key=(String)blngGrpIt.next();
				blng_grp_price_list=(ArrayList)blng_grp_base_price.get(key);
				if(blng_grp_price_list!=null && blng_grp_price_list.size()>0 ){
					stKey=new StringTokenizer(key,"~~");
					if(stKey.hasMoreTokens()){
						blng_grp_code=stKey.nextToken();
					}else{
						blng_grp_code="";
					}
					if(stKey.hasMoreTokens())
						fromDate=stKey.nextToken();
					else
						fromDate="";
					if(insert && !blng_grp_code.equals("")  && !fromDate.equals("")  && blng_grp_dtls!=null && blng_grp_dtls.size()>0 && blng_grp_dtls.containsKey(blng_grp_code) && inserted_blng_grp_period_list!=null && inserted_blng_grp_period_list.size()>0 && inserted_blng_grp_period_list.contains(blng_grp_code+"~~"+fromDate) ){
						for(int i=0;i<blng_grp_price_list.size();i++){
							//System.out.println("7666");
							record=new String[12];
							record=(String[])blng_grp_price_list.get(i);
							blgClsCode		= record[0];
							blgClsDesc		= record[1];
							indicator		=record[2];
							price1		=record[3];
							roundTo	=	record[4];
							roundInd		=record[5];
							factorAppl		=record[6];
							deposit		   =record[7];
							partialDeposit =record[8];
							minDepAmtind   =record[9];
							minDepAmt	  =record[10];
							factorforServiceRate = record[11];
							existsInDB=existsInDBBlngGrp(blng_grp_code+"~~"+fromDate,record,db_blng_grp_base_price,"BLNG_GRP_PRICE");
							//System.out.println("7682");
						/*	System.out.println("facility_id="+facility_id);
							System.out.println("packageCode="+packageCode);
							System.out.println("blng_grp_code="+blng_grp_code);								
							System.out.println("fromDate="+fromDate);
							System.out.println("blgClsCode="+blgClsCode);
							System.out.println("blgClsDesc="+blgClsDesc);
							System.out.println("indicator="+indicator);
							System.out.println("price1="+price1);
							System.out.println("roundTo="+roundTo);
							System.out.println("roundInd="+roundInd);
							System.out.println("factorAppl="+factorAppl);
							System.out.println("deposit="+deposit);
							System.out.println("partialDeposit="+partialDeposit);
							System.out.println("minDepAmtind="+minDepAmtind);
							System.out.println("minDepAmt="+minDepAmt);
							System.out.println("existsInDB="+existsInDB);*/
							if(existsInDB){
								//chk if update is needed
						//System.out.println("7703");
								isBlngGrpPriceUpdated_cstmt.setString(1,facility_id);
								isBlngGrpPriceUpdated_cstmt.setString(2,packageCode);
								isBlngGrpPriceUpdated_cstmt.setString(3,blng_grp_code);									
								isBlngGrpPriceUpdated_cstmt.setString(4,fromDate);
								isBlngGrpPriceUpdated_cstmt.setString(5,blgClsCode );
								isBlngGrpPriceUpdated_cstmt.setString(6,indicator );
								isBlngGrpPriceUpdated_cstmt.setString(7,price1 );
								isBlngGrpPriceUpdated_cstmt.setString(8,roundTo );
								isBlngGrpPriceUpdated_cstmt.setString(9,roundInd );
								isBlngGrpPriceUpdated_cstmt.setString(10,deposit );
								isBlngGrpPriceUpdated_cstmt.setString(11,partialDeposit );
								isBlngGrpPriceUpdated_cstmt.setString(12,minDepAmtind );
								isBlngGrpPriceUpdated_cstmt.setString(13,minDepAmt );
								isBlngGrpPriceUpdated_cstmt.setString(14,factorAppl );
								isBlngGrpPriceUpdated_cstmt.setString(15,factorforServiceRate);	//Added by Muthu
								isBlngGrpPriceUpdated_cstmt.registerOutParameter(16,java.sql.Types.VARCHAR);
								isBlngGrpPriceUpdated_cstmt.registerOutParameter(17,java.sql.Types.VARCHAR);
								isBlngGrpPriceUpdated_cstmt.registerOutParameter(18,java.sql.Types.VARCHAR);
								isBlngGrpPriceUpdated_cstmt.registerOutParameter(19,java.sql.Types.VARCHAR);
								//System.out.println("7725");
								isBlngGrpPriceUpdated_cstmt.execute();
								//System.out.println("7728");
								recModified=isBlngGrpPriceUpdated_cstmt.getString(16);
								str_error_level=isBlngGrpPriceUpdated_cstmt.getString(17);
								str_sysmesage_id=isBlngGrpPriceUpdated_cstmt.getString(18);
								str_error_text=isBlngGrpPriceUpdated_cstmt.getString(19);
								if(str_error_level==null) str_error_level="";
								if(str_sysmesage_id==null) str_sysmesage_id="";
								if(str_error_text==null) str_error_text="";
								if(recModified == null)		recModified="";
							/*	System.out.println("recModified:"+recModified);
								System.out.println("str_error_level in process rate based insertion:"+str_error_level);
								System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
								System.out.println("str_error_text in process rate based insertion:"+str_error_text);*/
								if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
								{
									//System.out.println("7742");
									insert=false;
									sb.append("<br>"+str_error_text+"<br> ") ;
								}
								if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
								{
									//System.out.println("7748");
									insert=false;
									if((str_error_level.equals("10") && !str_error_text.equals("") ))
									{
										sb.append("<br>"+str_error_text+"<br> ") ;
										//System.out.println("sb mesage in Error is:"+sb);
									}
									else
									{
										if(str_sysmesage_id.indexOf("|") != (-1)){
											msgIds=new StringTokenizer(str_sysmesage_id,"|");
											while(msgIds.hasMoreTokens())
											{
												messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
												sb.append((String)messageHashtable.get("message")+"<br>");
											}
											//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
										}else{
											messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
											sb.append((String)messageHashtable.get("message"));
											//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
										}
									}
								}
								if(insert && "Y".equals(recModified)){										
									//System.out.println("7772");
									update_blng_grp_price_cstmt.setString(1,facility_id);
									update_blng_grp_price_cstmt.setString(2,packageCode);
									update_blng_grp_price_cstmt.setString(3,blng_grp_code);										
									update_blng_grp_price_cstmt.setString(4,fromDate);
									update_blng_grp_price_cstmt.setString(5,blgClsCode);
									update_blng_grp_price_cstmt.setString(6,indicator);
									update_blng_grp_price_cstmt.setString(7,price1);
									update_blng_grp_price_cstmt.setString(8,roundTo);
									update_blng_grp_price_cstmt.setString(9,roundInd);
									update_blng_grp_price_cstmt.setString(10,deposit );
									update_blng_grp_price_cstmt.setString(11,partialDeposit );
									update_blng_grp_price_cstmt.setString(12,minDepAmtind );
									update_blng_grp_price_cstmt.setString(13,minDepAmt );
									update_blng_grp_price_cstmt.setString(14,factorAppl );
									update_blng_grp_price_cstmt.setString(15,factorforServiceRate );//Added by muthu

									update_blng_grp_price_cstmt.setString(16,user_id);
									update_blng_grp_price_cstmt.setString(17,client_ip_address );
									update_blng_grp_price_cstmt.setString(18,facility_id);
									update_blng_grp_price_cstmt.registerOutParameter(19,java.sql.Types.VARCHAR);
									update_blng_grp_price_cstmt.registerOutParameter(20,java.sql.Types.VARCHAR);
									update_blng_grp_price_cstmt.registerOutParameter(21,java.sql.Types.VARCHAR);
									//System.out.println("7796");
									update_blng_grp_price_cstmt.execute();
									//System.out.println("7798");
									str_error_level=update_blng_grp_price_cstmt.getString(19);
									str_sysmesage_id=update_blng_grp_price_cstmt.getString(20);
									str_error_text=update_blng_grp_price_cstmt.getString(21);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									/*System.out.println("str_error_level in process rate based insertion:"+str_error_level);
									System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
									System.out.println("str_error_text in process rate based insertion:"+str_error_text);*/
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										//System.out.println("7812");
										insert=false;
										sb.append("<br>"+str_error_text+"<br> ") ;
									}
									if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
									{
										//System.out.println("7816");
										insert=false;
										if((str_error_level.equals("10") && !str_error_text.equals("") ))
										{
											sb.append("<br>"+str_error_text+"<br> ") ;
											//System.out.println("sb mesage in Error is:"+sb);
										}
										else
										{
											//System.out.println("7824");
											if(str_sysmesage_id.indexOf("|") != (-1)){
												msgIds=new StringTokenizer(str_sysmesage_id,"|");
												while(msgIds.hasMoreTokens())
												{
													messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
													sb.append((String)messageHashtable.get("message")+"<br>");
												}
												//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
											}else{
												//System.out.println("7835");													messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
												sb.append((String)messageHashtable.get("message"));
												//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
											}
										}
									}
								}
							}
							else{//insert
							//System.out.println("blpackage.insertpackagebgprice Entering 3 ");
								blng_grp_price_cstmt.setString(1,facility_id);
								blng_grp_price_cstmt.setString(2,packageCode);
								blng_grp_price_cstmt.setString(3,blng_grp_code);									
								blng_grp_price_cstmt.setString(4,fromDate);
								blng_grp_price_cstmt.setString(5,blgClsCode);
								blng_grp_price_cstmt.setString(6,indicator);
								blng_grp_price_cstmt.setString(7,price1);
								blng_grp_price_cstmt.setString(8,roundTo);
								blng_grp_price_cstmt.setString(9,roundInd);
								blng_grp_price_cstmt.setString(10,deposit );
								blng_grp_price_cstmt.setString(11,partialDeposit );
								blng_grp_price_cstmt.setString(12,minDepAmtind );
								blng_grp_price_cstmt.setString(13,minDepAmt );
								blng_grp_price_cstmt.setString(14,factorAppl );
								blng_grp_price_cstmt.setString(15,factorforServiceRate);	//Added by muthu

								blng_grp_price_cstmt.setString(16,user_id);
								blng_grp_price_cstmt.setString(17,user_id);
								blng_grp_price_cstmt.setString(18,client_ip_address);
								blng_grp_price_cstmt.setString(19,facility_id);
								blng_grp_price_cstmt.setString(20,client_ip_address);
								blng_grp_price_cstmt.setString(21,facility_id);
								blng_grp_price_cstmt.registerOutParameter(22,java.sql.Types.VARCHAR);
								blng_grp_price_cstmt.registerOutParameter(23,java.sql.Types.VARCHAR);
								blng_grp_price_cstmt.registerOutParameter(24,java.sql.Types.VARCHAR);
								//System.out.println("blpackage.insertpackagebgprice Entering 4 ");
								blng_grp_price_cstmt.execute();
								//System.out.println("blpackage.insertpackagebgprice Entering 5 ");
								str_error_level=blng_grp_price_cstmt.getString(22);
								str_sysmesage_id=blng_grp_price_cstmt.getString(23);
								str_error_text=blng_grp_price_cstmt.getString(24);
								if(str_error_level==null) str_error_level="";
								if(str_sysmesage_id==null) str_sysmesage_id="";
								if(str_error_text==null) str_error_text="";
								/*System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
								System.out.println("str_error_text in process:"+str_error_text);
								System.out.println("str_error_text in process:"+str_error_text);*/
								if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
								{
									insert=false;
									sb.append("<br>"+str_error_text+"<br> ") ;
								}
								if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
								{
									insert=false;
									if((str_error_level.equals("10") && !str_error_text.equals("") ))
									{
										sb.append("<br>"+str_error_text+"<br> ") ;
										//System.out.println("sb mesage in Error is:"+sb);
									}
									else
									{
										if(str_sysmesage_id.indexOf("|") != (-1)){
											msgIds=new StringTokenizer(str_sysmesage_id,"|");
											while(msgIds.hasMoreTokens())
											{
												messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
												sb.append((String)messageHashtable.get("message")+"<br>");
											}
											//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
										}else{
											messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
											sb.append((String)messageHashtable.get("message"));
											//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
										}
									}
								}
							}//insert
						}//for

					}	//if
				}	//if
			}//while
		}//if
		if(isBlngGrpPriceUpdated_cstmt!=null)
			isBlngGrpPriceUpdated_cstmt.close();
		if(update_blng_grp_price_cstmt!=null)
			update_blng_grp_price_cstmt.close();
		if(blng_grp_price_cstmt!=null)
			blng_grp_price_cstmt.close();
	}
	catch (Exception e)
	{
		System.err.println("Exception while updating Billing Group price details:"+e);
		e.printStackTrace();
		insert=false;
	}
/*******Update Billing Group Base Price details************end********************/
/*******Update Billing Group Rate Based Services detail************start********************/
try
	{
	if(insert && modify_blng_grp_rate_srv.equals("Y")){
		insert=deleteAllDBRecsBlngGrp(con,db_blng_grp_rate_srv,blng_grp_rate_srv,facility_id,packageCode,"BLNG_GRP_RATE_BASED");
		if(insert && blng_grp_rate_srv!=null && blng_grp_rate_srv.size()>0 )
		{
			//System.out.println("Rate Based Services other operations");
			keySet=(Set<String>)blng_grp_rate_srv.keySet();
			//System.out.println("keySet="+keySet.toString());
			blngGrpIt=keySet.iterator();
			/****************************/
			while(insert && blngGrpIt.hasNext()){
				key=(String)blngGrpIt.next();
				blng_grp_rate_srv_list=(ArrayList)blng_grp_rate_srv.get(key);
				if(blng_grp_rate_srv_list!=null && blng_grp_rate_srv_list.size()>0 ){
					stKey=new StringTokenizer(key,"~~");
					if(stKey.hasMoreTokens()){
						blng_grp_code=stKey.nextToken();
					}else{
						blng_grp_code="";
					}
					if(stKey.hasMoreTokens())
						fromDate=stKey.nextToken();
					else
						fromDate="";
					if(insert && !blng_grp_code.equals("")  && !fromDate.equals("")  && blng_grp_dtls!=null && blng_grp_dtls.size()>0 && blng_grp_dtls.containsKey(blng_grp_code)  && inserted_blng_grp_period_list!=null && inserted_blng_grp_period_list.size()>0 && inserted_blng_grp_period_list.contains(blng_grp_code+"~~"+fromDate) ){
						for(int i=0;i<blng_grp_rate_srv_list.size();i++){
							record=new String[7];
							record=(String[])blng_grp_rate_srv_list.get(i);
							type		= record[0];
							service_code		= record[1];
							service_desc	=record[2];
							catalog_code		=record[3];
							catalog_desc			= record[4];
							ind		= record[5];
							factorOrRate		= record[6];
							qty_limit		=record[7];
							amt_limit_ind	=record[8];
							amt_limit		= record[9];
							replace		= record[10];
							if(replace==null || replace.equals("") || replace.equals("null"))
								replace="N";
							replaceSrv_code= record[11];
							replaceSrv_desc		= record[12];
							replaceSrv_cat_code		=record[13];
							replaceSrv_cat_desc	= record[14];
							refund		=record[15];
							if(refund==null || refund.equals("") || refund.equals("null"))
								refund="N";
							refundAmt		= record[16];
							autoRefund		= record[17];
							factor_appl		= record[18];
							roundTo			= record[19];
							roundInd		= record[20];
							closePkg		=record[21];
							splitReqd	  =	record[22];//Split reqd
							includeHomeMedication=	record[23];
							dailyLmtChkBx = record[25];//Added V190320-Aravindh/MMS-DM-CRF-0129
							dailyLmtAmt = record[26];//Added V190320-Aravindh/MMS-DM-CRF-0129
							dailyLmtGrossNet = record[27];//Added V190320-Aravindh/MMS-DM-CRF-0129
							if(null == dailyLmtGrossNet || "".equals(dailyLmtGrossNet)) {
								dailyLmtGrossNet = "G";
							}//Added V190320-Aravindh/MMS-DM-CRF-0129
							dailyLmtIndicator = record[28];//Added V190626-Aravindh/MMS-DM-CRF-0129.1
							if("*".equals(dailyLmtIndicator)){
								dailyLmtIndicator = "";
							}//Added V190626-Aravindh/MMS-DM-CRF-0129.1
							dailyLmtQty = record[29];//Added V190626-Aravindh/MMS-DM-CRF-0129.1
							
							existsInDB=existsInDBBlngGrp(blng_grp_code+"~~"+fromDate,record,db_blng_grp_rate_srv,"BLNG_GRP_RATE_BASED");
							inserted_blng_grp_rate_srv_list.add(blng_grp_code.trim()+"~~"+fromDate.trim()+"~~"+service_code.trim());
							/*System.out.println("facility_id="+facility_id);
							System.out.println("packageCode="+packageCode);
							System.out.println("blng_grp_code="+blng_grp_code);
							System.out.println("type="+type);
							System.out.println("service_code="+service_code);
							System.out.println("service_desc="+service_desc);
							System.out.println("catalog_code="+catalog_code);
							System.out.println("catalog_desc="+catalog_desc);
							System.out.println("ind="+ind);
							System.out.println("factorOrRate="+factorOrRate);
							System.out.println("qty_limit="+qty_limit);
							System.out.println("amt_limit_ind="+amt_limit_ind);
							System.out.println("amt_limit="+amt_limit);
							System.out.println("replace="+replace);
							System.out.println("replaceSrv_code="+replaceSrv_code);
							System.out.println("replaceSrv_desc="+replaceSrv_desc);
							System.out.println("replaceSrv_cat_code="+replaceSrv_cat_code);
							System.out.println("replaceSrv_cat_desc="+replaceSrv_cat_desc);
							System.out.println("refund="+refund);
							System.out.println("refundAmt="+refundAmt);
							System.out.println("autoRefund="+autoRefund);
							System.out.println("factor_appl="+factor_appl);
							System.out.println("roundTo="+roundTo);
							System.out.println("roundInd="+roundInd);
							System.out.println("closePkg="+closePkg);
							System.out.println("existsInDB="+existsInDB);*/
							if(existsInDB){
								//chk if update is needed

								isBlngGrpRateSrvUpdated_cstmt.setString(1,facility_id);
								isBlngGrpRateSrvUpdated_cstmt.setString(2,packageCode);
								isBlngGrpRateSrvUpdated_cstmt.setString(3,blng_grp_code);
								isBlngGrpRateSrvUpdated_cstmt.setString(4,fromDate);
								isBlngGrpRateSrvUpdated_cstmt.setString(5,service_code );
								isBlngGrpRateSrvUpdated_cstmt.setString(6,type );
								isBlngGrpRateSrvUpdated_cstmt.setString(7,"R" );
								isBlngGrpRateSrvUpdated_cstmt.setString(8,catalog_code );
								isBlngGrpRateSrvUpdated_cstmt.setString(9,ind );
								isBlngGrpRateSrvUpdated_cstmt.setString(10,factorOrRate );
								isBlngGrpRateSrvUpdated_cstmt.setString(11,qty_limit );
								isBlngGrpRateSrvUpdated_cstmt.setString(12,amt_limit );
								isBlngGrpRateSrvUpdated_cstmt.setString(13,amt_limit_ind );
								isBlngGrpRateSrvUpdated_cstmt.setString(14,replace );
								isBlngGrpRateSrvUpdated_cstmt.setString(15,replaceSrv_code );
								isBlngGrpRateSrvUpdated_cstmt.setString(16,replaceSrv_cat_code );
								isBlngGrpRateSrvUpdated_cstmt.setString(17,refund );
								isBlngGrpRateSrvUpdated_cstmt.setString(18,refundAmt );
								isBlngGrpRateSrvUpdated_cstmt.setString(19,autoRefund );
								isBlngGrpRateSrvUpdated_cstmt.setString(20,closePkg );
								isBlngGrpRateSrvUpdated_cstmt.setString(21,roundTo );
								isBlngGrpRateSrvUpdated_cstmt.setString(22,roundInd );
								isBlngGrpRateSrvUpdated_cstmt.setString(23,factor_appl );
								isBlngGrpRateSrvUpdated_cstmt.setString(24,splitReqd); //Split reqd - For Validation
								isBlngGrpRateSrvUpdated_cstmt.setString(25,includeHomeMedication); 
								isBlngGrpRateSrvUpdated_cstmt.registerOutParameter(26,java.sql.Types.VARCHAR);
								isBlngGrpRateSrvUpdated_cstmt.registerOutParameter(27,java.sql.Types.VARCHAR);
								isBlngGrpRateSrvUpdated_cstmt.registerOutParameter(28,java.sql.Types.VARCHAR);
								isBlngGrpRateSrvUpdated_cstmt.registerOutParameter(29,java.sql.Types.VARCHAR);
								isBlngGrpRateSrvUpdated_cstmt.setString(30,dailyLmtChkBx);//Added V190320-Aravindh/MMS-DM-CRF-0129
								isBlngGrpRateSrvUpdated_cstmt.setString(31,dailyLmtAmt);//Added V190320-Aravindh/MMS-DM-CRF-0129
								isBlngGrpRateSrvUpdated_cstmt.setString(32,dailyLmtGrossNet);//Added V190320-Aravindh/MMS-DM-CRF-0129
								isBlngGrpRateSrvUpdated_cstmt.setString(33,dailyLmtIndicator);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
								isBlngGrpRateSrvUpdated_cstmt.setString(34,dailyLmtQty);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
								isBlngGrpRateSrvUpdated_cstmt.execute();

								recModified=isBlngGrpRateSrvUpdated_cstmt.getString(26);
								str_error_level=isBlngGrpRateSrvUpdated_cstmt.getString(27);
								str_sysmesage_id=isBlngGrpRateSrvUpdated_cstmt.getString(28);					
								str_error_text=isBlngGrpRateSrvUpdated_cstmt.getString(29);
								if(str_error_level==null) str_error_level="";
								if(str_sysmesage_id==null) str_sysmesage_id="";
								if(str_error_text==null) str_error_text="";
								if(recModified == null)		recModified="";
								/*System.out.println("recModified:"+recModified);
								System.out.println("str_error_level in process rate based insertion:"+str_error_level);
								System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
								System.out.println("str_error_text in process rate based insertion:"+str_error_text);*/
								if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
								{
									insert=false;
									sb.append("<br>"+str_error_text+"<br> ") ;
								}
								if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
								{
									insert=false;
									if((str_error_level.equals("10") && !str_error_text.equals("") ))
									{
										sb.append("<br>"+str_error_text+"<br> ") ;
										//System.out.println("sb mesage in Error is:"+sb);
									}
									else
									{
										if(str_sysmesage_id.indexOf("|") != (-1)){
											msgIds=new StringTokenizer(str_sysmesage_id,"|");
											while(msgIds.hasMoreTokens())
											{
												messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
												sb.append((String)messageHashtable.get("message")+"<br>");
											}
											//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
										}else{
											messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
											sb.append((String)messageHashtable.get("message"));
											//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
										}
									}
								}
								//System.out.println("insert="+insert);
								if(insert && "Y".equals(recModified)){				
									update_blng_grp_rate_srv_cstmt.setString(1,facility_id);
									update_blng_grp_rate_srv_cstmt.setString(2,packageCode);
									update_blng_grp_rate_srv_cstmt.setString(3,blng_grp_code);
									update_blng_grp_rate_srv_cstmt.setString(4,fromDate);
									update_blng_grp_rate_srv_cstmt.setString(5,service_code );
									update_blng_grp_rate_srv_cstmt.setString(6,type );
									update_blng_grp_rate_srv_cstmt.setString(7,"R" );
									update_blng_grp_rate_srv_cstmt.setString(8,catalog_code );
									update_blng_grp_rate_srv_cstmt.setString(9,ind );
									update_blng_grp_rate_srv_cstmt.setString(10,factorOrRate );
									update_blng_grp_rate_srv_cstmt.setString(11,qty_limit );
									update_blng_grp_rate_srv_cstmt.setString(12,amt_limit );
									update_blng_grp_rate_srv_cstmt.setString(13,amt_limit_ind );
									update_blng_grp_rate_srv_cstmt.setString(14,replace );
									update_blng_grp_rate_srv_cstmt.setString(15,replaceSrv_code );
									update_blng_grp_rate_srv_cstmt.setString(16,replaceSrv_cat_code );
									update_blng_grp_rate_srv_cstmt.setString(17,refund );
									update_blng_grp_rate_srv_cstmt.setString(18,refundAmt );
									update_blng_grp_rate_srv_cstmt.setString(19,autoRefund );
									update_blng_grp_rate_srv_cstmt.setString(20,closePkg );
									update_blng_grp_rate_srv_cstmt.setString(21,roundTo );
									update_blng_grp_rate_srv_cstmt.setString(22,roundInd );
									update_blng_grp_rate_srv_cstmt.setString(23,factor_appl );
									update_blng_grp_rate_srv_cstmt.setString(24,user_id);
									update_blng_grp_rate_srv_cstmt.setString(25,client_ip_address );
									update_blng_grp_rate_srv_cstmt.setString(26,facility_id);
									update_blng_grp_rate_srv_cstmt.setString(27,splitReqd);//RRRR	
									update_blng_grp_rate_srv_cstmt.setString(28,includeHomeMedication);
									update_blng_grp_rate_srv_cstmt.registerOutParameter(29,java.sql.Types.VARCHAR);
									update_blng_grp_rate_srv_cstmt.registerOutParameter(30,java.sql.Types.VARCHAR);
									update_blng_grp_rate_srv_cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
									update_blng_grp_rate_srv_cstmt.setString(32,dailyLmtChkBx);//Added V190320-Aravindh/MMS-DM-CRF-0129
									update_blng_grp_rate_srv_cstmt.setString(33,dailyLmtAmt);//Added V190320-Aravindh/MMS-DM-CRF-0129
									update_blng_grp_rate_srv_cstmt.setString(34,dailyLmtGrossNet);//Added V190320-Aravindh/MMS-DM-CRF-0129
									update_blng_grp_rate_srv_cstmt.setString(35,dailyLmtIndicator);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
									update_blng_grp_rate_srv_cstmt.setString(36,dailyLmtQty);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
									update_blng_grp_rate_srv_cstmt.execute();

									str_error_level=update_blng_grp_rate_srv_cstmt.getString(29);
									str_sysmesage_id=update_blng_grp_rate_srv_cstmt.getString(30);					
									str_error_text=update_blng_grp_rate_srv_cstmt.getString(31);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									/*System.out.println("str_error_level in process rate based insertion:"+str_error_level);
									System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
									System.out.println("str_error_text in process rate based insertion:"+str_error_text);*/
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insert=false;
										sb.append("<br>"+str_error_text+"<br> ") ;
									}
									if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
									{
										insert=false;
										if((str_error_level.equals("10") && !str_error_text.equals("") ))
										{
											sb.append("<br>"+str_error_text+"<br> ") ;
											//System.out.println("sb mesage in Error is:"+sb);
										}
										else
										{
											if(str_sysmesage_id.indexOf("|") != (-1)){
												msgIds=new StringTokenizer(str_sysmesage_id,"|");
												while(msgIds.hasMoreTokens())
												{
													messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
													sb.append((String)messageHashtable.get("message")+"<br>");
												}
												//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
											}else{
												messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
												sb.append((String)messageHashtable.get("message"));
												//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
											}
										}
									}
								}
							}
							else{//insert
								blng_grp_rate_srv_cstmt.setString(1,facility_id);
								blng_grp_rate_srv_cstmt.setString(2,packageCode);
								blng_grp_rate_srv_cstmt.setString(3,blng_grp_code);									
								blng_grp_rate_srv_cstmt.setString(4,fromDate);
								blng_grp_rate_srv_cstmt.setString(5,service_code);
								blng_grp_rate_srv_cstmt.setString(6,type);
								blng_grp_rate_srv_cstmt.setString(7,"R");
								blng_grp_rate_srv_cstmt.setString(8,catalog_code);
								blng_grp_rate_srv_cstmt.setString(9,ind);
								blng_grp_rate_srv_cstmt.setString(10,factorOrRate);
								blng_grp_rate_srv_cstmt.setString(11,qty_limit);
								blng_grp_rate_srv_cstmt.setString(12,amt_limit);
								blng_grp_rate_srv_cstmt.setString(13,amt_limit_ind);
								blng_grp_rate_srv_cstmt.setString(14,replace);
								blng_grp_rate_srv_cstmt.setString(15,replaceSrv_code);
								blng_grp_rate_srv_cstmt.setString(16,replaceSrv_cat_code);
								blng_grp_rate_srv_cstmt.setString(17,refund);
								blng_grp_rate_srv_cstmt.setString(18,refundAmt);
								blng_grp_rate_srv_cstmt.setString(19,autoRefund);
								blng_grp_rate_srv_cstmt.setString(20,closePkg);
								blng_grp_rate_srv_cstmt.setString(21,roundTo);
								blng_grp_rate_srv_cstmt.setString(22,roundInd);
								blng_grp_rate_srv_cstmt.setString(23,factor_appl);
								blng_grp_rate_srv_cstmt.setString(24,user_id);
								blng_grp_rate_srv_cstmt.setString(25,user_id);
								blng_grp_rate_srv_cstmt.setString(26,client_ip_address);
								blng_grp_rate_srv_cstmt.setString(27,facility_id);
								blng_grp_rate_srv_cstmt.setString(28,client_ip_address);
								blng_grp_rate_srv_cstmt.setString(29,facility_id);
								blng_grp_rate_srv_cstmt.setString(30,splitReqd);//RRRR	
								blng_grp_rate_srv_cstmt.setString(31,includeHomeMedication);
								blng_grp_rate_srv_cstmt.registerOutParameter(32,java.sql.Types.VARCHAR);
								blng_grp_rate_srv_cstmt.registerOutParameter(33,java.sql.Types.VARCHAR);
								blng_grp_rate_srv_cstmt.registerOutParameter(34,java.sql.Types.VARCHAR);
								blng_grp_rate_srv_cstmt.setString(35,dailyLmtChkBx);//Added V190320-Aravindh/MMS-DM-CRF-0129
								blng_grp_rate_srv_cstmt.setString(36,dailyLmtAmt);//Added V190320-Aravindh/MMS-DM-CRF-0129	
								blng_grp_rate_srv_cstmt.setString(37,dailyLmtGrossNet);//Added V190320-Aravindh/MMS-DM-CRF-0129
								blng_grp_rate_srv_cstmt.setString(38,dailyLmtIndicator);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
								blng_grp_rate_srv_cstmt.setString(39,dailyLmtQty);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
								
								blng_grp_rate_srv_cstmt.execute();

								str_error_level=blng_grp_rate_srv_cstmt.getString(32);
								str_sysmesage_id=blng_grp_rate_srv_cstmt.getString(33);					
								str_error_text=blng_grp_rate_srv_cstmt.getString(34);
								if(str_error_level==null) str_error_level="";
								if(str_sysmesage_id==null) str_sysmesage_id="";
								if(str_error_text==null) str_error_text="";
								/*System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
								System.out.println("str_error_level in process:"+str_error_level);
								System.out.println("str_error_text in process:"+str_error_text);*/
								if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
								{
									insert=false;
									sb.append("<br>"+str_error_text+"<br> ") ;
								}
								if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
								{
									insert=false;
									if((str_error_level.equals("10") && !str_error_text.equals("") ))
									{
										sb.append("<br>"+str_error_text+"<br> ") ;
										//System.out.println("sb mesage in Error is:"+sb);
									}
									else
									{
										if(str_sysmesage_id.indexOf("|") != (-1)){
											msgIds=new StringTokenizer(str_sysmesage_id,"|");
											while(msgIds.hasMoreTokens())
											{
												messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
												sb.append((String)messageHashtable.get("message")+"<br>");
											}
											//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
										}else{
											messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
											sb.append((String)messageHashtable.get("message"));
											//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
										}
									}
								}
							}//insert
							if(insert==false) break;  // Karthikk added the below comment for Screen Hanging Issue MMS-DM-SCF-0296 61560
						}//for

					}	//if
				}	//if
			}//while
			if(isBlngGrpRateSrvUpdated_cstmt!=null){
				isBlngGrpRateSrvUpdated_cstmt.close();
			}if(update_blng_grp_rate_srv_cstmt!=null){
				update_blng_grp_rate_srv_cstmt.close();
			}if(blng_grp_rate_srv_cstmt!=null){
				blng_grp_rate_srv_cstmt.close();
				}
		}//if
		}
	}
	catch (Exception e)
	{
		System.err.println("Exception while updating Billing Group rate based services details:"+e);
		e.printStackTrace();
		insert=false;
	}
//System.out.println("Karthikk Update Billing Group Rate Based Services details 1 modify_blng_grp_rate_srv_excl=" + modify_blng_grp_rate_srv_excl);
/*******Update Billing Group Rate Based Services details************end********************/
	/*******Update Billing Group Rate Based Services Excl detail************start********************/
try
	{
	if(insert && modify_blng_grp_rate_srv_excl.equals("Y")){
		insert=deleteAllDBRecsBlngGrp(con,db_blng_grp_rate_srv_excl,blng_grp_rate_srv_excl,facility_id,packageCode,"BLNG_GRP_SRVLIMIT_RATE_BASED");
		if(insert && blng_grp_rate_srv_excl!=null && blng_grp_rate_srv_excl.size()>0 )
		{
			//System.out.println("Rate Based Services Excl other operations");
			keySet=(Set<String>)blng_grp_rate_srv_excl.keySet();
			//System.out.println("keySet="+keySet.toString());
			blngGrpIt=keySet.iterator();
			/****************************/
			while(insert && blngGrpIt.hasNext()){
				key=(String)blngGrpIt.next();
				blng_grp_rate_srv_excl_list=(ArrayList)blng_grp_rate_srv_excl.get(key);
				if(blng_grp_rate_srv_excl_list!=null && blng_grp_rate_srv_excl_list.size()>0 ){
					stKey=new StringTokenizer(key,"~~");
					if(stKey.hasMoreTokens()){
						blng_grp_code=stKey.nextToken();
					}else{
						blng_grp_code="";
					}
					if(stKey.hasMoreTokens())
						fromDate=stKey.nextToken();
					else
						fromDate="";
					if(stKey.hasMoreTokens())
						parent_service_code=stKey.nextToken();
					else
						parent_service_code="";
					if(insert && !blng_grp_code.equals("") && !fromDate.equals("") && !parent_service_code.equals("")  && blng_grp_dtls!=null && blng_grp_dtls.size()>0 && blng_grp_dtls.containsKey(blng_grp_code)  && inserted_blng_grp_period_list!=null && inserted_blng_grp_period_list.size()>0 && inserted_blng_grp_period_list.contains(blng_grp_code+"~~"+fromDate) && inserted_blng_grp_rate_srv_list!=null && inserted_blng_grp_rate_srv_list.size()>0 && inserted_blng_grp_rate_srv_list.contains(blng_grp_code+"~~"+fromDate+"~~"+parent_service_code) ){
						for(int i=0;i<blng_grp_rate_srv_excl_list.size();i++){
							record=new String[16];
							record=(String[])blng_grp_rate_srv_excl_list.get(i);
							srvLimit_type		= record[0];
							srvLimit_service_code		= record[1];
							srvLimit_service_desc	=record[2];
							exludeService		=record[3];
							if(exludeService==null || exludeService.equals("") || exludeService.equals("null"))
								exludeService="N";
							srvLimit_qty_limit			= record[4];
							srvLimit_amt_limit_ind	= record[5];
							srvLimit_amt_limit		= record[6];
							srvLimit_roundTo		= record[7];
							srvLimit_roundInd= record[8];
							srvLimit_replace		= record[9];
							srvLimit_replaceSrv_code		=record[10];
							srvLimit_replaceSrv_desc		=record[11];
							srvLimit_refund	= record[12];
							srvLimit_refundAmt		=record[13];
							srvLimit_auto_refund		=record[14];
							srvLimit_factor_appl		=record[15];
							splitReqd	  =	record[16];//Split reqd
							includeHomeMedication	  =	record[17];
							//Added V190320-Aravindh/MMS-DM-CRF-0129/Starts
							dailyLmtChkBx = record[19];
							dailyLmtAmt = record[20];
							dailyLmtGrossNet = record[21];
							if(null == dailyLmtChkBx || "".equals(dailyLmtChkBx)) {
								dailyLmtChkBx = "N";
							}
							if(null == dailyLmtGrossNet && "".equals(dailyLmtGrossNet)) {
								dailyLmtGrossNet = "G";
							}
							//Added V190320-Aravindh/MMS-DM-CRF-0129/Ends
							dailyLmtIndicator = record[22];//Added V190626-Aravindh/MMS-DM-CRF-0129.1
							if("*".equals(dailyLmtIndicator)){
								dailyLmtIndicator = "";
							}//Added V190626-Aravindh/MMS-DM-CRF-0129.1
							dailyLmtQty = record[23];//Added V190626-Aravindh/MMS-DM-CRF-0129.1
					/*System.out.println("facility_id="+facility_id);
					System.out.println("packageCode="+packageCode);
					System.out.println("blng_grp_code="+blng_grp_code);
					System.out.println("fromDate="+fromDate);
					System.out.println("parent_service_code="+parent_service_code);
					System.out.println("srvLimit_service_code="+srvLimit_service_code);
					System.out.println("srvLimit_type="+srvLimit_type);
					System.out.println("exludeService="+exludeService);
					System.out.println("srvLimit_amt_limit_ind="+srvLimit_amt_limit_ind);
					System.out.println("srvLimit_qty_limit="+srvLimit_qty_limit);
					System.out.println("srvLimit_amt_limit="+srvLimit_amt_limit);
					System.out.println("srvLimit_replace="+srvLimit_replace);
					System.out.println("srvLimit_replaceSrv_code="+srvLimit_replaceSrv_code);
					System.out.println("srvLimit_refund="+srvLimit_refund);
					System.out.println("srvLimit_refundAmt="+srvLimit_refundAmt);
					System.out.println("srvLimit_auto_refund="+srvLimit_auto_refund);
					System.out.println("srvLimit_roundTo="+srvLimit_roundTo);
					System.out.println("srvLimit_roundInd="+srvLimit_roundInd);
					System.out.println("srvLimit_factor_appl="+srvLimit_factor_appl);
					System.out.println("user_id="+user_id);
					System.out.println("client_ip_address="+client_ip_address);*/

							existsInDB=existsInDBBlngGrp(blng_grp_code+"~~"+fromDate+"~~"+parent_service_code,record,db_blng_grp_rate_srv_excl,"BLNG_GRP_SRVLIMIT_RATE_BASED");

							//System.out.println("existsInDB="+existsInDB);
							if(existsInDB){
								//chk if update is needed
								isBlngGrpRateExclUpdated_cstmt.setString(1,facility_id);
								isBlngGrpRateExclUpdated_cstmt.setString(2,packageCode);
								isBlngGrpRateExclUpdated_cstmt.setString(3,blng_grp_code);
								isBlngGrpRateExclUpdated_cstmt.setString(4,fromDate);
								isBlngGrpRateExclUpdated_cstmt.setString(5,parent_service_code );
								//Karthik added Service Type - 26/07/2016  MMS-DM-SCF-0248	
								//isBlngGrpRateExclUpdated_cstmt.setString(7,"" );
								String service_type=getTypeBlngGrp(blng_grp_rate_srv,blng_grp_rate_srv_list,parent_service_code);
								isBlngGrpRateExclUpdated_cstmt.setString(6,service_type);
								isBlngGrpRateExclUpdated_cstmt.setString(7,"R" );
								isBlngGrpRateExclUpdated_cstmt.setString(8,srvLimit_service_code );
								isBlngGrpRateExclUpdated_cstmt.setString(9,srvLimit_type );
								isBlngGrpRateExclUpdated_cstmt.setString(10,exludeService );
								isBlngGrpRateExclUpdated_cstmt.setString(11,srvLimit_amt_limit_ind );
								isBlngGrpRateExclUpdated_cstmt.setString(12,srvLimit_qty_limit );
								isBlngGrpRateExclUpdated_cstmt.setString(13,srvLimit_amt_limit );
								isBlngGrpRateExclUpdated_cstmt.setString(14,srvLimit_replace );
								isBlngGrpRateExclUpdated_cstmt.setString(15,srvLimit_replaceSrv_code );
								isBlngGrpRateExclUpdated_cstmt.setString(16,srvLimit_refund );
								isBlngGrpRateExclUpdated_cstmt.setString(17,srvLimit_refundAmt );
								isBlngGrpRateExclUpdated_cstmt.setString(18,srvLimit_auto_refund );
								isBlngGrpRateExclUpdated_cstmt.setString(19,srvLimit_roundTo );
								isBlngGrpRateExclUpdated_cstmt.setString(20,srvLimit_roundInd );
								isBlngGrpRateExclUpdated_cstmt.setString(21,srvLimit_factor_appl );
								isBlngGrpRateExclUpdated_cstmt.setString(22,splitReqd );//Split reqd - For validation	
								isBlngGrpRateExclUpdated_cstmt.setString(23,includeHomeMedication );	
								isBlngGrpRateExclUpdated_cstmt.registerOutParameter(24,java.sql.Types.VARCHAR);
								isBlngGrpRateExclUpdated_cstmt.registerOutParameter(25,java.sql.Types.VARCHAR);
								isBlngGrpRateExclUpdated_cstmt.registerOutParameter(26,java.sql.Types.VARCHAR);
								isBlngGrpRateExclUpdated_cstmt.registerOutParameter(27,java.sql.Types.VARCHAR);
								isBlngGrpRateExclUpdated_cstmt.setString(28,dailyLmtChkBx);//Added V190320-Aravindh/MMS-DM-CRF-0129
								isBlngGrpRateExclUpdated_cstmt.setString(29,dailyLmtAmt);//Added V190320-Aravindh/MMS-DM-CRF-0129	
								isBlngGrpRateExclUpdated_cstmt.setString(30,dailyLmtGrossNet);//Added V190320-Aravindh/MMS-DM-CRF-0129
								isBlngGrpRateExclUpdated_cstmt.setString(31,dailyLmtIndicator);//Added V190626-Aravindh/MMS-DM-CRF-0129.1	
								isBlngGrpRateExclUpdated_cstmt.setString(32,dailyLmtQty);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
								isBlngGrpRateExclUpdated_cstmt.execute();

								recModified=isBlngGrpRateExclUpdated_cstmt.getString(24);
								str_error_level=isBlngGrpRateExclUpdated_cstmt.getString(25);
								str_sysmesage_id=isBlngGrpRateExclUpdated_cstmt.getString(26);					
								str_error_text=isBlngGrpRateExclUpdated_cstmt.getString(27);
								if(str_error_level==null) str_error_level="";
								if(str_sysmesage_id==null) str_sysmesage_id="";
								if(str_error_text==null) str_error_text="";
								if(recModified == null)		recModified="";
								/*System.out.println("recModified:"+recModified);
								System.out.println("str_error_level in process rate based insertion:"+str_error_level);
								System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
								System.out.println("str_error_text in process rate based insertion:"+str_error_text);*/
								if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
								{
									insert=false;
									sb.append("<br>"+str_error_text+"<br> ") ;
								}
								if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
								{
									insert=false;
									if((str_error_level.equals("10") && !str_error_text.equals("") ))
									{
										sb.append("<br>"+str_error_text+"<br> ") ;
										//System.out.println("sb mesage in Error is:"+sb);
									}
									else
									{
										if(str_sysmesage_id.indexOf("|") != (-1)){
											msgIds=new StringTokenizer(str_sysmesage_id,"|");
											while(msgIds.hasMoreTokens())
											{
												messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
												sb.append((String)messageHashtable.get("message")+"<br>");
											}
											//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
										}else{
											messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
											sb.append((String)messageHashtable.get("message"));
											//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
										}
									}
								}
								//System.out.println("insert="+insert);
								if(insert && "Y".equals(recModified)){	

									update_blng_grp_rate_srv_excl_cstmt.setString(1,facility_id);
									update_blng_grp_rate_srv_excl_cstmt.setString(2,packageCode);
									update_blng_grp_rate_srv_excl_cstmt.setString(3,blng_grp_code);
									update_blng_grp_rate_srv_excl_cstmt.setString(4,fromDate);
									update_blng_grp_rate_srv_excl_cstmt.setString(5,parent_service_code );
									//Karthik added Service Type -26/07/2016  MMS-DM-SCF-0248	
     								String service_type_upd=getTypeBlngGrp(blng_grp_rate_srv,blng_grp_rate_srv_list,parent_service_code);
									update_blng_grp_rate_srv_excl_cstmt.setString(6,service_type_upd);
									update_blng_grp_rate_srv_excl_cstmt.setString(7,"R" );
									update_blng_grp_rate_srv_excl_cstmt.setString(8,srvLimit_service_code );
									update_blng_grp_rate_srv_excl_cstmt.setString(9,srvLimit_type );
									update_blng_grp_rate_srv_excl_cstmt.setString(10,exludeService );
									update_blng_grp_rate_srv_excl_cstmt.setString(11,srvLimit_amt_limit_ind );
									update_blng_grp_rate_srv_excl_cstmt.setString(12,srvLimit_qty_limit );
									update_blng_grp_rate_srv_excl_cstmt.setString(13,srvLimit_amt_limit );
									update_blng_grp_rate_srv_excl_cstmt.setString(14,srvLimit_replace );
									update_blng_grp_rate_srv_excl_cstmt.setString(15,srvLimit_replaceSrv_code );
									update_blng_grp_rate_srv_excl_cstmt.setString(16,srvLimit_refund );
									update_blng_grp_rate_srv_excl_cstmt.setString(17,srvLimit_refundAmt );
									update_blng_grp_rate_srv_excl_cstmt.setString(18,srvLimit_auto_refund );
									update_blng_grp_rate_srv_excl_cstmt.setString(19,srvLimit_roundTo );
									update_blng_grp_rate_srv_excl_cstmt.setString(20,srvLimit_roundInd );
									update_blng_grp_rate_srv_excl_cstmt.setString(21,srvLimit_factor_appl );
									update_blng_grp_rate_srv_excl_cstmt.setString(22,user_id);
									update_blng_grp_rate_srv_excl_cstmt.setString(23,client_ip_address );
									update_blng_grp_rate_srv_excl_cstmt.setString(24,facility_id);
									update_blng_grp_rate_srv_excl_cstmt.setString(25,splitReqd);//RRRR	
									update_blng_grp_rate_srv_excl_cstmt.setString(26,includeHomeMedication);
									update_blng_grp_rate_srv_excl_cstmt.registerOutParameter(27,java.sql.Types.VARCHAR);
									update_blng_grp_rate_srv_excl_cstmt.registerOutParameter(28,java.sql.Types.VARCHAR);
									update_blng_grp_rate_srv_excl_cstmt.registerOutParameter(29,java.sql.Types.VARCHAR);
									update_blng_grp_rate_srv_excl_cstmt.setString(30,dailyLmtChkBx);//Added V190320-Aravindh/MMS-DM-CRF-0129
									update_blng_grp_rate_srv_excl_cstmt.setString(31,dailyLmtAmt);//Added V190320-Aravindh/MMS-DM-CRF-0129	
									update_blng_grp_rate_srv_excl_cstmt.setString(32,dailyLmtGrossNet);//Added V190320-Aravindh/MMS-DM-CRF-0129
									update_blng_grp_rate_srv_excl_cstmt.setString(33,dailyLmtIndicator);//Added V190626-Aravindh/MMS-DM-CRF-0129.1	
									update_blng_grp_rate_srv_excl_cstmt.setString(34,dailyLmtQty);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
									update_blng_grp_rate_srv_excl_cstmt.execute();

									str_error_level=update_blng_grp_rate_srv_excl_cstmt.getString(27);
									str_sysmesage_id=update_blng_grp_rate_srv_excl_cstmt.getString(28);					
									str_error_text=update_blng_grp_rate_srv_excl_cstmt.getString(29);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									//System.out.println("str_error_level in process rate based insertion:"+str_error_level);
									//System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
									//System.out.println("str_error_text in process rate based insertion:"+str_error_text);
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insert=false;
										sb.append("<br>"+str_error_text+"<br> ") ;
									}
									if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
									{
										insert=false;
										if((str_error_level.equals("10") && !str_error_text.equals("") ))
										{
											sb.append("<br>"+str_error_text+"<br> ") ;
											//System.out.println("sb mesage in Error is:"+sb);
										}
										else
										{
											if(str_sysmesage_id.indexOf("|") != (-1)){
												msgIds=new StringTokenizer(str_sysmesage_id,"|");
												while(msgIds.hasMoreTokens())
												{
													messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
													sb.append((String)messageHashtable.get("message")+"<br>");
												}
												//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
											}else{
												messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
												sb.append((String)messageHashtable.get("message"));
												//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
											}
										}
									}
								}
							}
							else{//insert
								blng_grp_rate_srv_excl_cstmt.setString(1,facility_id);
								blng_grp_rate_srv_excl_cstmt.setString(2,packageCode);
								blng_grp_rate_srv_excl_cstmt.setString(3,blng_grp_code);
								blng_grp_rate_srv_excl_cstmt.setString(4,fromDate);
								blng_grp_rate_srv_excl_cstmt.setString(5,parent_service_code);
								//Karthik added Service Type - 26/07/2016  MMS-DM-SCF-0248	
								String service_type=getTypeBlngGrp(blng_grp_rate_srv,blng_grp_rate_srv_list,parent_service_code);
								blng_grp_rate_srv_excl_cstmt.setString(6,service_type);
								blng_grp_rate_srv_excl_cstmt.setString(7,"R");
								blng_grp_rate_srv_excl_cstmt.setString(8,srvLimit_service_code);
								blng_grp_rate_srv_excl_cstmt.setString(9,srvLimit_type);
								blng_grp_rate_srv_excl_cstmt.setString(10,exludeService);
								blng_grp_rate_srv_excl_cstmt.setString(11,srvLimit_amt_limit_ind);
								blng_grp_rate_srv_excl_cstmt.setString(12,srvLimit_qty_limit);
								blng_grp_rate_srv_excl_cstmt.setString(13,srvLimit_amt_limit);
								blng_grp_rate_srv_excl_cstmt.setString(14,srvLimit_replace);
								blng_grp_rate_srv_excl_cstmt.setString(15,srvLimit_replaceSrv_code);
								blng_grp_rate_srv_excl_cstmt.setString(16,srvLimit_refund);
								blng_grp_rate_srv_excl_cstmt.setString(17,srvLimit_refundAmt);
								blng_grp_rate_srv_excl_cstmt.setString(18,srvLimit_auto_refund);
								blng_grp_rate_srv_excl_cstmt.setString(19,srvLimit_roundTo);
								blng_grp_rate_srv_excl_cstmt.setString(20,srvLimit_roundInd);
								blng_grp_rate_srv_excl_cstmt.setString(21,srvLimit_factor_appl);
								blng_grp_rate_srv_excl_cstmt.setString(22,user_id);
								blng_grp_rate_srv_excl_cstmt.setString(23,user_id);
								blng_grp_rate_srv_excl_cstmt.setString(24,client_ip_address);
								blng_grp_rate_srv_excl_cstmt.setString(25,facility_id);
								blng_grp_rate_srv_excl_cstmt.setString(26,client_ip_address);
								blng_grp_rate_srv_excl_cstmt.setString(27,facility_id);
								blng_grp_rate_srv_excl_cstmt.setString(28,splitReqd);//RRRR	
								blng_grp_rate_srv_excl_cstmt.setString(29,includeHomeMedication);
								blng_grp_rate_srv_excl_cstmt.registerOutParameter(30,java.sql.Types.VARCHAR);
								blng_grp_rate_srv_excl_cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
								blng_grp_rate_srv_excl_cstmt.registerOutParameter(32,java.sql.Types.VARCHAR);
								blng_grp_rate_srv_excl_cstmt.setString(33,dailyLmtChkBx);//Added V190320-Aravindh/MMS-DM-CRF-0129
								blng_grp_rate_srv_excl_cstmt.setString(34,dailyLmtAmt);//Added V190320-Aravindh/MMS-DM-CRF-0129	
								blng_grp_rate_srv_excl_cstmt.setString(35,dailyLmtGrossNet);//Added V190320-Aravindh/MMS-DM-CRF-0129
								blng_grp_rate_srv_excl_cstmt.setString(36,dailyLmtIndicator);//Added V190626-Aravindh/MMS-DM-CRF-0129.1	
								blng_grp_rate_srv_excl_cstmt.setString(37,dailyLmtQty);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
								blng_grp_rate_srv_excl_cstmt.execute();

								str_error_level=blng_grp_rate_srv_excl_cstmt.getString(30);
								str_sysmesage_id=blng_grp_rate_srv_excl_cstmt.getString(31);					
								str_error_text=blng_grp_rate_srv_excl_cstmt.getString(32);
								if(str_error_level==null) str_error_level="";
								if(str_sysmesage_id==null) str_sysmesage_id="";
								if(str_error_text==null) str_error_text="";
								/*System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
								System.out.println("str_error_level in process:"+str_error_level);
								System.out.println("str_error_text in process:"+str_error_text);*/
								if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
								{
									insert=false;
									sb.append("<br>"+str_error_text+"<br> ") ;
								}
								if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
								{
									insert=false;
									if((str_error_level.equals("10") && !str_error_text.equals("") ))
									{
										sb.append("<br>"+str_error_text+"<br> ") ;
										//System.out.println("sb mesage in Error is:"+sb);
									}
									else
									{
										if(str_sysmesage_id.indexOf("|") != (-1)){
											msgIds=new StringTokenizer(str_sysmesage_id,"|");
											while(msgIds.hasMoreTokens())
											{
												messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
												sb.append((String)messageHashtable.get("message")+"<br>");
											}
											//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
										}else{
											messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
											sb.append((String)messageHashtable.get("message"));
											//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
										}
									}
								}
							}//insert
						}//for

					}	//if
				}	//if
			}//while
			if(isBlngGrpRateExclUpdated_cstmt!=null)
				isBlngGrpRateExclUpdated_cstmt.close();
			if(update_blng_grp_rate_srv_excl_cstmt!=null)
				update_blng_grp_rate_srv_excl_cstmt.close();
			if(blng_grp_rate_srv_excl_cstmt!=null)
				blng_grp_rate_srv_excl_cstmt.close();
		}//if
		}
	}
	catch (Exception e)
	{
		System.err.println("Exception while updating Billing Group rate based services details:"+e);
		e.printStackTrace();
		insert=false;
	}
//System.out.println("Karthikk Before Update Billing Group Rate Based Services Excl details 2" + insert);
/*******Update Billing Group Rate Based Services Excl details************end********************/
/*******Update Billing Group charge Based Services detail************start********************/
try
	{
	if(insert && modify_blng_grp_charge_srv.equals("Y")){

		insert=deleteAllDBRecsBlngGrp(con,db_blng_grp_charge_srv,blng_grp_charge_srv,facility_id,packageCode,"BLNG_GRP_CHARGE_BASED");
		if(insert && blng_grp_charge_srv!=null && blng_grp_charge_srv.size()>0 )
		{
			//System.out.println("Charge Based Services ");
			keySet=(Set<String>)blng_grp_charge_srv.keySet();
			//System.out.println("keySet="+keySet.toString());
			blngGrpIt=keySet.iterator();
			/****************************/
			while(insert && blngGrpIt.hasNext()){
				key=(String)blngGrpIt.next();
				blng_grp_charge_srv_list=(ArrayList)blng_grp_charge_srv.get(key);
				if(blng_grp_charge_srv_list!=null && blng_grp_charge_srv_list.size()>0 ){
					stKey=new StringTokenizer(key,"~~");
					if(stKey.hasMoreTokens()){
						blng_grp_code=stKey.nextToken();
					}else{
						blng_grp_code="";
					}
					if(stKey.hasMoreTokens())
						fromDate=stKey.nextToken();
					else
						fromDate="";
					if(insert && !blng_grp_code.equals("") && !fromDate.equals("")  && blng_grp_dtls!=null && blng_grp_dtls.size()>0 && blng_grp_dtls.containsKey(blng_grp_code)  && inserted_blng_grp_period_list!=null && inserted_blng_grp_period_list.size()>0 && inserted_blng_grp_period_list.contains(blng_grp_code+"~~"+fromDate) ){
						for(int i=0;i<blng_grp_charge_srv_list.size();i++){								
							record			= new String[12];
							record			= (String[])blng_grp_charge_srv_list.get(i);
							type			= record[0];//MuthuN against 28192
							cbService		= record[1];
							cbServiceDesc	= record[2];
							amountLimitInd	= record[3];
							amountLimit		= record[4];
							roundTo			= record[5];
							roundInd		= record[6];
							refund			= record[7];
							if(refund==null || refund.equals("") || refund.equals("null"))
							refund="N";
							refundAmt		= record[8];
							autoRefund		= record[9];
							factorAppl		= record[10];
							srvLmt =record[11]; //muthu on 8/27/2012
							splitReqd	  =	record[12];//Split reqd 
							includeHomeMedication	  =	record[13];
							/* System.out.println("8763 type ====>  "+type);
							System.out.println("8763 blng_grp_code ====>  "+blng_grp_code);								
							System.out.println("8763 fromDate ====>  "+fromDate);
							System.out.println("8763 db_blng_grp_charge_srv ====>  "+db_blng_grp_charge_srv); */

							existsInDB=existsInDBBlngGrp(blng_grp_code+"~~"+fromDate,record,db_blng_grp_charge_srv,"BLNG_GRP_CHARGE_BASED");


							//System.out.println("existsInDB 8765 type ====>  "+existsInDB);
							inserted_blng_grp_charge_srv_list.add(blng_grp_code.trim()+"~~"+fromDate.trim()+"~~"+cbService.trim());
							/*System.out.println("facility_id="+facility_id);
							System.out.println("packageCode="+packageCode);
							System.out.println("blng_grp_code="+blng_grp_code);
							System.out.println("cbService="+cbService);
							System.out.println("cbServiceDesc="+cbServiceDesc);
							System.out.println("amountLimitInd="+amountLimitInd);
							System.out.println("amountLimit="+amountLimit);
							System.out.println("roundTo="+roundTo);
							System.out.println("roundInd="+roundInd);
							System.out.println("refund="+refund);
							System.out.println("refundAmt="+refundAmt);
							System.out.println("autoRefund="+autoRefund);
							System.out.println("factorAppl="+factorAppl);*/
							//System.out.println("8781 type ====>  "+type);
							if(existsInDB){
								//chk if update is needed
								isBlngGrpChargeSrvUpdated_cstmt.setString(1,facility_id);
								//System.out.println("facility_id in Update Billing Group 8681 ==> "+facility_id);
								isBlngGrpChargeSrvUpdated_cstmt.setString(2,packageCode);
								//System.out.println("packageCode in Update Billing Group 8681 ==> "+packageCode);
								isBlngGrpChargeSrvUpdated_cstmt.setString(3,blng_grp_code);
							//System.out.println("blng_grp_code in Update Billing Group 8681 ==> "+blng_grp_code);
								isBlngGrpChargeSrvUpdated_cstmt.setString(4,fromDate);
								//System.out.println("fromDate in Update Billing Group 8681 ==> "+fromDate);
								isBlngGrpChargeSrvUpdated_cstmt.setString(5,cbService );
								//System.out.println("cbService in Update Billing Group 8681 ==> "+cbService);									
								isBlngGrpChargeSrvUpdated_cstmt.setString(6,type);//Muthu against 28192
								//System.out.println("cbType in Update Billing Group 8681 ==> "+type);
								isBlngGrpChargeSrvUpdated_cstmt.setString(7,"C" );
								//System.out.println("cbType in Update Billing Group 8681 ==> ");
								isBlngGrpChargeSrvUpdated_cstmt.setString(8,"" );
								//System.out.println("cbType in Update Billing Group 8681 ==> ");
								isBlngGrpChargeSrvUpdated_cstmt.setString(9,"" );
								//System.out.println("cbType in Update Billing Group 8681 ==> ");
								isBlngGrpChargeSrvUpdated_cstmt.setString(10,"" );
								//System.out.println("cbType in Update Billing Group 8681 ==> ");
								isBlngGrpChargeSrvUpdated_cstmt.setString(11,"" );								
								//System.out.println("cbType in Update Billing Group 8681 ==> ");
								isBlngGrpChargeSrvUpdated_cstmt.setString(12,amountLimit );
								//System.out.println("amountLimit in Update Billing group 8681 ==> "+amountLimit);
								isBlngGrpChargeSrvUpdated_cstmt.setString(13,amountLimitInd );
								isBlngGrpChargeSrvUpdated_cstmt.setString(14,"" );								//System.out.println("cbType in Update Billing Group 8681 ==> ");
								isBlngGrpChargeSrvUpdated_cstmt.setString(15,"" );								//System.out.println("cbType in Update Billing Group 8681 ==> ");
								isBlngGrpChargeSrvUpdated_cstmt.setString(16,"" );								//System.out.println("cbType in Update Billing Group 8681 ==> ");
								isBlngGrpChargeSrvUpdated_cstmt.setString(17,refund );							//System.out.println("refund in Update Billing Group 8681 ==> "+refund);
								isBlngGrpChargeSrvUpdated_cstmt.setString(18,refundAmt );						//System.out.println("refundAmt in Update Billing Group 8681 ==> "+refundAmt);
								isBlngGrpChargeSrvUpdated_cstmt.setString(19,autoRefund );						//System.out.println("autoRefund in Update Billing Group 8681 ==> "+autoRefund);
								isBlngGrpChargeSrvUpdated_cstmt.setString(20,"" );								//System.out.println("cbType in Update Billing Group 8681 ==> ");
								isBlngGrpChargeSrvUpdated_cstmt.setString(21,roundTo );						//System.out.println("roundTo in Update Billing Group 8681 ==> "+roundTo);
								isBlngGrpChargeSrvUpdated_cstmt.setString(22,roundInd );
								isBlngGrpChargeSrvUpdated_cstmt.setString(23,factorAppl );						//System.out.println("factorAppl in Update Billing Group 8681 ==> "+factorAppl);
								isBlngGrpChargeSrvUpdated_cstmt.setString(24,splitReqd );	//Split reqd - For Validation 
								isBlngGrpChargeSrvUpdated_cstmt.setString(25,includeHomeMedication );	
								isBlngGrpChargeSrvUpdated_cstmt.registerOutParameter(26,java.sql.Types.VARCHAR);
								isBlngGrpChargeSrvUpdated_cstmt.registerOutParameter(27,java.sql.Types.VARCHAR);
								isBlngGrpChargeSrvUpdated_cstmt.registerOutParameter(28,java.sql.Types.VARCHAR);
								isBlngGrpChargeSrvUpdated_cstmt.registerOutParameter(29,java.sql.Types.VARCHAR);
								isBlngGrpChargeSrvUpdated_cstmt.setString(30,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
								isBlngGrpChargeSrvUpdated_cstmt.setString(31,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
								isBlngGrpChargeSrvUpdated_cstmt.setString(32,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
								isBlngGrpChargeSrvUpdated_cstmt.setString(33,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
								isBlngGrpChargeSrvUpdated_cstmt.setString(34,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
								isBlngGrpChargeSrvUpdated_cstmt.execute();

								recModified=isBlngGrpChargeSrvUpdated_cstmt.getString(26);
						//System.out.println("recModified in Update Billing Group 8681 ==> "+recModified);
								str_error_level=isBlngGrpChargeSrvUpdated_cstmt.getString(27);
						//System.out.println("str_error_level in Update Billing Group 8681 ==> "+str_error_level);
								str_sysmesage_id=isBlngGrpChargeSrvUpdated_cstmt.getString(28);	
						//System.out.println("str_sysmesage_id in Update Billing Group 8681 ==> "+str_sysmesage_id);	
								str_error_text=isBlngGrpChargeSrvUpdated_cstmt.getString(29);
						//System.out.println("str_error_text in Update Billing Group 8681 ==> "+str_error_text);
								if(str_error_level==null) str_error_level="";
								if(str_sysmesage_id==null) str_sysmesage_id="";
								if(str_error_text==null) str_error_text="";
								if(recModified == null)		recModified="";
								/*System.out.println("recModified:"+recModified);
								System.out.println("str_error_level in process rate based insertion:"+str_error_level);
								System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
								System.out.println("str_error_text in process rate based insertion:"+str_error_text);*/
								if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
								{
									insert=false;
									sb.append("<br>"+str_error_text+"<br> ") ;
								}
								if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
								{
									insert=false;
									if((str_error_level.equals("10") && !str_error_text.equals("") ))
									{
										sb.append("<br>"+str_error_text+"<br> ") ;
										//System.out.println("sb mesage in Error is:"+sb);
									}
									else
									{
										if(str_sysmesage_id.indexOf("|") != (-1)){
											msgIds=new StringTokenizer(str_sysmesage_id,"|");
											while(msgIds.hasMoreTokens())
											{
												messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
												sb.append((String)messageHashtable.get("message")+"<br>");
											}
											//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
										}else{
											messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
											sb.append((String)messageHashtable.get("message"));
											//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
										}
									}
								}
								if(insert && "Y".equals(recModified)){				

									update_blng_grp_charge_srv_cstmt.setString(1,facility_id);
									update_blng_grp_charge_srv_cstmt.setString(2,packageCode);
									update_blng_grp_charge_srv_cstmt.setString(3,blng_grp_code);										
									update_blng_grp_charge_srv_cstmt.setString(4,fromDate);
									update_blng_grp_charge_srv_cstmt.setString(5,cbService );
									update_blng_grp_charge_srv_cstmt.setString(6,type);//Muthu against 28192
									//update_blng_grp_charge_srv_cstmt.setString(7,"S" );
									update_blng_grp_charge_srv_cstmt.setString(7,"C" );
									update_blng_grp_charge_srv_cstmt.setString(8,"" );
									update_blng_grp_charge_srv_cstmt.setString(9,"" );
									update_blng_grp_charge_srv_cstmt.setString(10,"" );
									update_blng_grp_charge_srv_cstmt.setString(11,"" );
									update_blng_grp_charge_srv_cstmt.setString(12,amountLimit );

							//System.out.println("8695 amountLimit:  "+amountLimit);
									update_blng_grp_charge_srv_cstmt.setString(13,amountLimitInd );
									update_blng_grp_charge_srv_cstmt.setString(14,"" );
									update_blng_grp_charge_srv_cstmt.setString(15,"" );
									update_blng_grp_charge_srv_cstmt.setString(16,"" );
									update_blng_grp_charge_srv_cstmt.setString(17,refund );
									update_blng_grp_charge_srv_cstmt.setString(18,refundAmt );
									update_blng_grp_charge_srv_cstmt.setString(19,autoRefund );
									update_blng_grp_charge_srv_cstmt.setString(20,"" );
									update_blng_grp_charge_srv_cstmt.setString(21,roundTo );
									update_blng_grp_charge_srv_cstmt.setString(22,roundInd );
									update_blng_grp_charge_srv_cstmt.setString(23,factorAppl);
									update_blng_grp_charge_srv_cstmt.setString(24,user_id);
									update_blng_grp_charge_srv_cstmt.setString(25,client_ip_address );
									update_blng_grp_charge_srv_cstmt.setString(26,facility_id);
									update_blng_grp_charge_srv_cstmt.setString(27,splitReqd);//RRRR	
									update_blng_grp_charge_srv_cstmt.setString(28,includeHomeMedication);
									update_blng_grp_charge_srv_cstmt.registerOutParameter(29,java.sql.Types.VARCHAR);
									update_blng_grp_charge_srv_cstmt.registerOutParameter(30,java.sql.Types.VARCHAR);
									update_blng_grp_charge_srv_cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
									update_blng_grp_charge_srv_cstmt.setString(32,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
									update_blng_grp_charge_srv_cstmt.setString(33,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
									update_blng_grp_charge_srv_cstmt.setString(34,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
									update_blng_grp_charge_srv_cstmt.setString(35,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
									update_blng_grp_charge_srv_cstmt.setString(36,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
									update_blng_grp_charge_srv_cstmt.execute();

									str_error_level=update_blng_grp_charge_srv_cstmt.getString(29);
									str_sysmesage_id=update_blng_grp_charge_srv_cstmt.getString(30);					
									str_error_text=update_blng_grp_charge_srv_cstmt.getString(31);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									/* System.out.println("str_error_level in process rate based insertion:"+str_error_level);
									System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
									System.out.println("str_error_text in process rate based insertion:"+str_error_text); */
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insert=false;
										sb.append("<br>"+str_error_text+"<br> ") ;
									}
									if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
									{
										insert=false;
										if((str_error_level.equals("10") && !str_error_text.equals("") ))
										{
											sb.append("<br>"+str_error_text+"<br> ") ;
											//System.out.println("sb mesage in Error is:"+sb);
										}
										else
										{
											if(str_sysmesage_id.indexOf("|") != (-1)){
												msgIds=new StringTokenizer(str_sysmesage_id,"|");
												while(msgIds.hasMoreTokens())
												{
													messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
													sb.append((String)messageHashtable.get("message")+"<br>");
												}
												//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
											}else{
												messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
												sb.append((String)messageHashtable.get("message"));
												//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
											}
										}
									}
								}
							}
							else{//insert
								blng_grp_charge_srv_cstmt.setString(1,facility_id);
								blng_grp_charge_srv_cstmt.setString(2,packageCode);
								blng_grp_charge_srv_cstmt.setString(3,blng_grp_code);									
								blng_grp_charge_srv_cstmt.setString(4,fromDate);
								blng_grp_charge_srv_cstmt.setString(5,cbService);
								blng_grp_charge_srv_cstmt.setString(6,type);//Muthu against 28192
								//System.out.println("8939 cbType  "+type);									
								blng_grp_charge_srv_cstmt.setString(7,"C");
								blng_grp_charge_srv_cstmt.setString(8,"");
								blng_grp_charge_srv_cstmt.setString(9,"");
								blng_grp_charge_srv_cstmt.setString(10,"");
								blng_grp_charge_srv_cstmt.setString(11,"");
								blng_grp_charge_srv_cstmt.setString(12,amountLimit);
								blng_grp_charge_srv_cstmt.setString(13,amountLimitInd);
								blng_grp_charge_srv_cstmt.setString(14,"");
								blng_grp_charge_srv_cstmt.setString(15,"");
								blng_grp_charge_srv_cstmt.setString(16,"");
								blng_grp_charge_srv_cstmt.setString(17,refund);
								blng_grp_charge_srv_cstmt.setString(18,refundAmt);
								blng_grp_charge_srv_cstmt.setString(19,autoRefund);
								blng_grp_charge_srv_cstmt.setString(20,"");
								blng_grp_charge_srv_cstmt.setString(21,roundTo);
								blng_grp_charge_srv_cstmt.setString(22,roundInd);
								blng_grp_charge_srv_cstmt.setString(23,factorAppl);
								blng_grp_charge_srv_cstmt.setString(24,user_id);
								blng_grp_charge_srv_cstmt.setString(25,user_id);
								blng_grp_charge_srv_cstmt.setString(26,client_ip_address);
								blng_grp_charge_srv_cstmt.setString(27,facility_id);
								blng_grp_charge_srv_cstmt.setString(28,client_ip_address);
								blng_grp_charge_srv_cstmt.setString(29,facility_id);
								blng_grp_charge_srv_cstmt.setString(30,splitReqd);//RRRR	
								blng_grp_charge_srv_cstmt.setString(31,includeHomeMedication);
								blng_grp_charge_srv_cstmt.registerOutParameter(32,java.sql.Types.VARCHAR);
								blng_grp_charge_srv_cstmt.registerOutParameter(33,java.sql.Types.VARCHAR);
								blng_grp_charge_srv_cstmt.registerOutParameter(34,java.sql.Types.VARCHAR);
								blng_grp_charge_srv_cstmt.setString(35,null);//Added V190320-Aravindh/MMS-DM-CRF-0129
								blng_grp_charge_srv_cstmt.setString(36,null);//Added V190320-Aravindh/MMS-DM-CRF-0129
								blng_grp_charge_srv_cstmt.setString(37,null);//Added V190320-Aravindh/MMS-DM-CRF-0129
								blng_grp_charge_srv_cstmt.setString(38,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
								blng_grp_charge_srv_cstmt.setString(39,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
								blng_grp_charge_srv_cstmt.execute();

								str_error_level=blng_grp_charge_srv_cstmt.getString(32);
								str_sysmesage_id=blng_grp_charge_srv_cstmt.getString(33);					
								str_error_text=blng_grp_charge_srv_cstmt.getString(34);
								if(str_error_level==null) str_error_level="";
								if(str_sysmesage_id==null) str_sysmesage_id="";
								if(str_error_text==null) str_error_text="";
								/* System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
								System.out.println("str_error_level in process:"+str_error_level);
								System.out.println("str_error_text in process:"+str_error_text); */
								if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
								{
									insert=false;
									sb.append("<br>"+str_error_text+"<br> ") ;
								}
								if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
								{
									insert=false;
									if((str_error_level.equals("10") && !str_error_text.equals("") ))
									{
										sb.append("<br>"+str_error_text+"<br> ") ;
										//System.out.println("sb mesage in Error is:"+sb);
									}
									else
									{
										if(str_sysmesage_id.indexOf("|") != (-1)){
											msgIds=new StringTokenizer(str_sysmesage_id,"|");
											while(msgIds.hasMoreTokens())
											{
												messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
												sb.append((String)messageHashtable.get("message")+"<br>");
											}
											//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
										}else{
											messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
											sb.append((String)messageHashtable.get("message"));
											//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
										}
									}
								}
							}//insert
						}//for

					}	//if
				}	//if
			}//while
			if(isBlngGrpChargeSrvUpdated_cstmt!=null){

				isBlngGrpChargeSrvUpdated_cstmt.close();
			}if(update_blng_grp_charge_srv_cstmt!=null){

				update_blng_grp_charge_srv_cstmt.close();
			}if(blng_grp_charge_srv_cstmt!=null){

				blng_grp_charge_srv_cstmt.close();
				}
		}//if
		}
	}
	catch (Exception e)
	{
		System.err.println("Exception while updating Billing Group rate based services details:"+e);
		e.printStackTrace();
		insert=false;
	}
//System.out.println("Karthikk Before Update Billing Group charge Based Services details 3 insert" + insert);
/*******Update Billing Group charge Based Services details************end********************/
/*******Update Billing Group charge Based Services Excl detail************start********************/
try
	{
	if(insert && modify_blng_grp_charge_srv_excl.equals("Y")){
		insert=deleteAllDBRecsBlngGrp(con,db_blng_grp_charge_srv_excl,blng_grp_charge_srv_excl,facility_id,packageCode,"BLNG_GRP_CHARGE_BASED_ITEM");
		if(insert && blng_grp_charge_srv_excl!=null && blng_grp_charge_srv_excl.size()>0 )
		{
			//System.out.println("Rate Based Services Excl other operations");
			keySet=(Set<String>)blng_grp_charge_srv_excl.keySet();
			//System.out.println("keySet="+keySet.toString());
			blngGrpIt=keySet.iterator();
			/****************************/
			while(insert && blngGrpIt.hasNext()){
				key=(String)blngGrpIt.next();
				blng_grp_charge_srv_excl_list=(ArrayList)blng_grp_charge_srv_excl.get(key);
				if(blng_grp_charge_srv_excl_list!=null && blng_grp_charge_srv_excl_list.size()>0 ){
					stKey=new StringTokenizer(key,"~~");
					if(stKey.hasMoreTokens()){
						blng_grp_code=stKey.nextToken();
					}else{
						blng_grp_code="";
					}
					if(stKey.hasMoreTokens())
						fromDate=stKey.nextToken();
					else
						fromDate="";
					if(stKey.hasMoreTokens())
						parent_service_code=stKey.nextToken();
					else
						parent_service_code="";
					if(insert && !blng_grp_code.equals("")  && !fromDate.equals("") && !parent_service_code.equals("")  && blng_grp_dtls!=null && blng_grp_dtls.size()>0 && blng_grp_dtls.containsKey(blng_grp_code)  && inserted_blng_grp_period_list!=null && inserted_blng_grp_period_list.size()>0 && inserted_blng_grp_period_list.contains(blng_grp_code+"~~"+fromDate) && inserted_blng_grp_charge_srv_list!=null && inserted_blng_grp_charge_srv_list.size()>0 && inserted_blng_grp_charge_srv_list.contains(blng_grp_code+"~~"+fromDate+"~~"+parent_service_code) ){
						for(int i=0;i<blng_grp_charge_srv_excl_list.size();i++){
							record=new String[5];
							record=(String[])blng_grp_charge_srv_excl_list.get(i);
							itemCode		= record[0];
							itemDesc		= record[1];
							inExcl	=record[2];
							if(inExcl==null || inExcl.equals("") || inExcl.equals("null"))
								inExcl="N";
							qtyLimit		=record[3];
							amountLimit			= record[4];
							splitReqd	  =	record[5];//Split reqd
					/*System.out.println("facility_id="+facility_id);
					System.out.println("packageCode="+packageCode);
					System.out.println("blng_grp_code="+blng_grp_code);
					System.out.println("fromDate="+fromDate);
					System.out.println("parent_service_code="+parent_service_code);
					System.out.println("itemCode="+itemCode);
					System.out.println("inExcl="+inExcl);
					System.out.println("qtyLimit="+qtyLimit);
					System.out.println("amountLimit="+amountLimit);*/
						existsInDB=existsInDBBlngGrp(blng_grp_code+"~~"+fromDate+"~~"+parent_service_code,record,db_blng_grp_charge_srv_excl,"BLNG_GRP_CHARGE_BASED_ITEM");

							//System.out.println("existsInDB="+existsInDB);
							if(existsInDB){
								//chk if update is needed
								isBlngGrpChargeExclUpdated_cstmt.setString(1,facility_id);
								isBlngGrpChargeExclUpdated_cstmt.setString(2,packageCode);
								isBlngGrpChargeExclUpdated_cstmt.setString(3,blng_grp_code);
								isBlngGrpChargeExclUpdated_cstmt.setString(4,fromDate);
								isBlngGrpChargeExclUpdated_cstmt.setString(5,parent_service_code );
								isBlngGrpChargeExclUpdated_cstmt.setString(6,"" );
								isBlngGrpChargeExclUpdated_cstmt.setString(7,"C" );
								isBlngGrpChargeExclUpdated_cstmt.setString(8,itemCode );
								isBlngGrpChargeExclUpdated_cstmt.setString(9,"" );
								isBlngGrpChargeExclUpdated_cstmt.setString(10,inExcl );
								isBlngGrpChargeExclUpdated_cstmt.setString(11,"" );
								isBlngGrpChargeExclUpdated_cstmt.setString(12,qtyLimit );
								isBlngGrpChargeExclUpdated_cstmt.setString(13,amountLimit );

					//System.out.println("existsInDB amountLimit ="+amountLimit);
								isBlngGrpChargeExclUpdated_cstmt.setString(14,"" );
								isBlngGrpChargeExclUpdated_cstmt.setString(15,"" );
								isBlngGrpChargeExclUpdated_cstmt.setString(16,"" );
								isBlngGrpChargeExclUpdated_cstmt.setString(17,"" );
								isBlngGrpChargeExclUpdated_cstmt.setString(18,"" );
								isBlngGrpChargeExclUpdated_cstmt.setString(19,"" );
								isBlngGrpChargeExclUpdated_cstmt.setString(20,"" );
								isBlngGrpChargeExclUpdated_cstmt.setString(21,"" );
								isBlngGrpChargeExclUpdated_cstmt.setString(22,splitReqd);//Split reqd - For validation
								isBlngGrpChargeExclUpdated_cstmt.setString(23,includeHomeMedication);
								isBlngGrpChargeExclUpdated_cstmt.registerOutParameter(24,java.sql.Types.VARCHAR);
								isBlngGrpChargeExclUpdated_cstmt.registerOutParameter(25,java.sql.Types.VARCHAR);
								isBlngGrpChargeExclUpdated_cstmt.registerOutParameter(26,java.sql.Types.VARCHAR);
								isBlngGrpChargeExclUpdated_cstmt.registerOutParameter(27,java.sql.Types.VARCHAR);
								isBlngGrpChargeExclUpdated_cstmt.setString(28,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
								isBlngGrpChargeExclUpdated_cstmt.setString(29,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
								isBlngGrpChargeExclUpdated_cstmt.setString(30,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
								isBlngGrpChargeExclUpdated_cstmt.setString(31,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
								isBlngGrpChargeExclUpdated_cstmt.setString(32,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
								isBlngGrpChargeExclUpdated_cstmt.execute();

								recModified=isBlngGrpChargeExclUpdated_cstmt.getString(24);
								str_error_level=isBlngGrpChargeExclUpdated_cstmt.getString(25);
								str_sysmesage_id=isBlngGrpChargeExclUpdated_cstmt.getString(26);					
								str_error_text=isBlngGrpChargeExclUpdated_cstmt.getString(27);
								if(str_error_level==null) str_error_level="";
								if(str_sysmesage_id==null) str_sysmesage_id="";
								if(str_error_text==null) str_error_text="";
								if(recModified == null)		recModified="";
								/*System.out.println("recModified:"+recModified);
								System.out.println("str_error_level in process rate based insertion:"+str_error_level);
								System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
								System.out.println("str_error_text in process rate based insertion:"+str_error_text);*/
								if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
								{
									insert=false;
									sb.append("<br>"+str_error_text+"<br> ") ;
								}
								if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
								{
									insert=false;
									if((str_error_level.equals("10") && !str_error_text.equals("") ))
									{
										sb.append("<br>"+str_error_text+"<br> ") ;
										//System.out.println("sb mesage in Error is:"+sb);
									}
									else
									{
										if(str_sysmesage_id.indexOf("|") != (-1)){
											msgIds=new StringTokenizer(str_sysmesage_id,"|");
											while(msgIds.hasMoreTokens())
											{
												messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
												sb.append((String)messageHashtable.get("message")+"<br>");
											}
											//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
										}else{
											messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
											sb.append((String)messageHashtable.get("message"));
											//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
										}
									}
								}
								//System.out.println("insert="+insert);
								if(insert && "Y".equals(recModified)){				

									update_blng_grp_charge_srv_excl_cstmt.setString(1,facility_id);
									update_blng_grp_charge_srv_excl_cstmt.setString(2,packageCode);
									update_blng_grp_charge_srv_excl_cstmt.setString(3,blng_grp_code);										
									update_blng_grp_charge_srv_excl_cstmt.setString(4,fromDate);
									update_blng_grp_charge_srv_excl_cstmt.setString(5,parent_service_code );
									update_blng_grp_charge_srv_excl_cstmt.setString(6,"S" );
									update_blng_grp_charge_srv_excl_cstmt.setString(7,"C" );
									update_blng_grp_charge_srv_excl_cstmt.setString(8,itemCode );
									update_blng_grp_charge_srv_excl_cstmt.setString(9,"M" );
									update_blng_grp_charge_srv_excl_cstmt.setString(10,inExcl );
									update_blng_grp_charge_srv_excl_cstmt.setString(11,"" );
									update_blng_grp_charge_srv_excl_cstmt.setString(12,qtyLimit );
									update_blng_grp_charge_srv_excl_cstmt.setString(13,amountLimit );
									update_blng_grp_charge_srv_excl_cstmt.setString(14,"" );
									update_blng_grp_charge_srv_excl_cstmt.setString(15,"" );
									update_blng_grp_charge_srv_excl_cstmt.setString(16,"" );
									update_blng_grp_charge_srv_excl_cstmt.setString(17,"" );
									update_blng_grp_charge_srv_excl_cstmt.setString(18,"" );
									update_blng_grp_charge_srv_excl_cstmt.setString(19,"" );
									update_blng_grp_charge_srv_excl_cstmt.setString(20,"" );
									update_blng_grp_charge_srv_excl_cstmt.setString(21,"" );
									update_blng_grp_charge_srv_excl_cstmt.setString(22,user_id);
									update_blng_grp_charge_srv_excl_cstmt.setString(23,client_ip_address );
									update_blng_grp_charge_srv_excl_cstmt.setString(24,facility_id);
									update_blng_grp_charge_srv_excl_cstmt.setString(25,splitReqd);//RRRR	
									update_blng_grp_charge_srv_excl_cstmt.setString(26,includeHomeMedication); //sarathkumar InclHmeMedi
									update_blng_grp_charge_srv_excl_cstmt.registerOutParameter(27,java.sql.Types .VARCHAR);
									update_blng_grp_charge_srv_excl_cstmt.registerOutParameter(28,java.sql.Types.VARCHAR);
									update_blng_grp_charge_srv_excl_cstmt.registerOutParameter(29,java.sql.Types.VARCHAR);
									update_blng_grp_charge_srv_excl_cstmt.setString(30,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
									update_blng_grp_charge_srv_excl_cstmt.setString(31,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
									update_blng_grp_charge_srv_excl_cstmt.setString(32,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
									update_blng_grp_charge_srv_excl_cstmt.setString(33,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
									update_blng_grp_charge_srv_excl_cstmt.setString(34,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
									update_blng_grp_charge_srv_excl_cstmt.execute();

									str_error_level=update_blng_grp_charge_srv_excl_cstmt.getString(27);
									str_sysmesage_id=update_blng_grp_charge_srv_excl_cstmt.getString(28);					
									str_error_text=update_blng_grp_charge_srv_excl_cstmt.getString(29);
									if(str_error_level==null) str_error_level="";
									if(str_sysmesage_id==null) str_sysmesage_id="";
									if(str_error_text==null) str_error_text="";
									//System.out.println("str_error_level in process rate based insertion:"+str_error_level);
									//System.out.println("str_sysmesage_id in process rate based insertion:"+str_sysmesage_id);
									//System.out.println("str_error_text in process rate based insertion:"+str_error_text);
									if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
									{
										insert=false;
										sb.append("<br>"+str_error_text+"<br> ") ;
									}
									if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
									{
										insert=false;
										if((str_error_level.equals("10") && !str_error_text.equals("") ))
										{
											sb.append("<br>"+str_error_text+"<br> ") ;
											//System.out.println("sb mesage in Error is:"+sb);
										}
										else
										{
											if(str_sysmesage_id.indexOf("|") != (-1)){
												msgIds=new StringTokenizer(str_sysmesage_id,"|");
												while(msgIds.hasMoreTokens())
												{
													messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
													sb.append((String)messageHashtable.get("message")+"<br>");
												}
												//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
											}else{
												messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
												sb.append((String)messageHashtable.get("message"));
												//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
											}
										}
									}
								}
							}
							else{//insert
								blng_grp_charge_srv_excl_cstmt.setString(1,facility_id);
								blng_grp_charge_srv_excl_cstmt.setString(2,packageCode);
								blng_grp_charge_srv_excl_cstmt.setString(3,blng_grp_code);									
								blng_grp_charge_srv_excl_cstmt.setString(4,fromDate);
								blng_grp_charge_srv_excl_cstmt.setString(5,parent_service_code);
								blng_grp_charge_srv_excl_cstmt.setString(6,"S");
								blng_grp_charge_srv_excl_cstmt.setString(7,"C");
								blng_grp_charge_srv_excl_cstmt.setString(8,itemCode);
								blng_grp_charge_srv_excl_cstmt.setString(9,"M");
								blng_grp_charge_srv_excl_cstmt.setString(10,inExcl);
								blng_grp_charge_srv_excl_cstmt.setString(11,"");
								blng_grp_charge_srv_excl_cstmt.setString(12,qtyLimit);
								blng_grp_charge_srv_excl_cstmt.setString(13,amountLimit);
								blng_grp_charge_srv_excl_cstmt.setString(14,"");
								blng_grp_charge_srv_excl_cstmt.setString(15,"");
								blng_grp_charge_srv_excl_cstmt.setString(16,"");
								blng_grp_charge_srv_excl_cstmt.setString(17,"");
								blng_grp_charge_srv_excl_cstmt.setString(18,"");
								blng_grp_charge_srv_excl_cstmt.setString(19,"");
								blng_grp_charge_srv_excl_cstmt.setString(20,"");
								blng_grp_charge_srv_excl_cstmt.setString(21,"");
								blng_grp_charge_srv_excl_cstmt.setString(22,user_id);
								blng_grp_charge_srv_excl_cstmt.setString(23,user_id);
								blng_grp_charge_srv_excl_cstmt.setString(24,client_ip_address);
								blng_grp_charge_srv_excl_cstmt.setString(25,facility_id);
								blng_grp_charge_srv_excl_cstmt.setString(26,client_ip_address);
								blng_grp_charge_srv_excl_cstmt.setString(27,facility_id);
								blng_grp_charge_srv_excl_cstmt.setString(28,splitReqd);//RRRR
								blng_grp_charge_srv_excl_cstmt.setString(29,includeHomeMedication);
								blng_grp_charge_srv_excl_cstmt.registerOutParameter(30,java.sql.Types.VARCHAR);
								blng_grp_charge_srv_excl_cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
								blng_grp_charge_srv_excl_cstmt.registerOutParameter(32,java.sql.Types.VARCHAR);
								blng_grp_charge_srv_excl_cstmt.setString(33,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
								blng_grp_charge_srv_excl_cstmt.setString(34,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
								blng_grp_charge_srv_excl_cstmt.setString(35,null);//Added V190320-Aravindh/MMS-DM-CRF-0129/Package Service Charge Based no need to pass any values
								blng_grp_charge_srv_excl_cstmt.setString(36,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
								blng_grp_charge_srv_excl_cstmt.setString(37,null);//Added V190626-Aravindh/MMS-DM-CRF-0129.1/Package Service Charge Based no need to pass any values
								blng_grp_charge_srv_excl_cstmt.execute();

								str_error_level=blng_grp_charge_srv_excl_cstmt.getString(30);
								str_sysmesage_id=blng_grp_charge_srv_excl_cstmt.getString(31);					
								str_error_text=blng_grp_charge_srv_excl_cstmt.getString(32);
								if(str_error_level==null) str_error_level="";
								if(str_sysmesage_id==null) str_sysmesage_id="";
								if(str_error_text==null) str_error_text="";
								/* System.out.println("str_sysmesage_id in process:"+str_sysmesage_id);
								System.out.println("str_error_level in process:"+str_error_level);
								System.out.println("str_error_text in process:"+str_error_text); */
								if( !str_sysmesage_id.equals("")  ||  !str_error_text.equals("")  )
								{
									insert=false;
									sb.append("<br>"+str_error_text+"<br> ") ;
								}
								if(  (!str_sysmesage_id.equals(""))  || (str_error_level.equals("10") && !str_error_text.equals("") ) )
								{
									insert=false;
									if((str_error_level.equals("10") && !str_error_text.equals("") ))
									{
										sb.append("<br>"+str_error_text+"<br> ") ;
										//System.out.println("sb mesage in Error is:"+sb);
									}
									else
									{
										if(str_sysmesage_id.indexOf("|") != (-1)){
											msgIds=new StringTokenizer(str_sysmesage_id,"|");
											while(msgIds.hasMoreTokens())
											{
												messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
												sb.append((String)messageHashtable.get("message")+"<br>");
											}
											//System.out.println("sb mesages in str_sysmesage_id is:"+sb);
										}else{
											messageHashtable=MessageManager.getMessage(locale,str_sysmesage_id,"BL");
											sb.append((String)messageHashtable.get("message"));
											//System.out.println("sb mesage in str_sysmesage_id is:"+sb);
										}
									}
								}
							}//insert
							if(insert==false) break;  // Karthikk added the below comment for Screen Hanging Issue MMS-DM-SCF-0296 61560
						}//for

					}	//if
				}	//if
			}//while
			if(isBlngGrpChargeExclUpdated_cstmt!=null)
				isBlngGrpChargeExclUpdated_cstmt.close();
			if(update_blng_grp_charge_srv_excl_cstmt!=null)
				update_blng_grp_charge_srv_excl_cstmt.close();
			if(blng_grp_charge_srv_excl_cstmt!=null)
				blng_grp_charge_srv_excl_cstmt.close();
		}//if
		}
	}
	catch (Exception e)
	{
		System.err.println("Exception while updating Billing Group rate based services details:"+e);
		e.printStackTrace();
		insert=false;
	}
//System.out.println("Karthikk Update Billing Group charge Based Services Excl details************end 4 insert" + insert);
/*******Update Billing Group charge Based Services Excl details************end********************/
}catch(Exception e){
	System.err.println("Exception in modifyBilling GroupDtls() of PkgDef Ejb="+e);
	e.printStackTrace();
}finally
	{
		try{
			if(isBlngGrpPeriodUpdated_cstmt!=null) isBlngGrpPeriodUpdated_cstmt.close();
			if(update_blng_grp_period_cstmt!=null) update_blng_grp_period_cstmt.close();
		}catch(Exception r)
		{r.printStackTrace();}

	}

	return_mess.put("status",new Boolean(insert));
	return_mess.put("error",str_error_text);
	return_mess.put("sys_error",sys_err.toString());
	return_mess.put("message",str_sysmesage_id);
	//System.out.println("Karthikk modifyBilling GroupDtls return_mess="+return_mess.toString());
	return return_mess;
}

@SuppressWarnings({"rawtypes", "unchecked"})
public boolean deleteAllDBRecsBlngGrp(Connection con,HashMap db_collection,HashMap bean_collection,String facility_id,String package_code,String func_mode) //throws Exception
{
//System.out.println("in deleteAllDBRecsBlngGrp ");
	//System.out.println("@@ db_collection="+db_collection.toString());

		boolean result=true;
		if(func_mode!=null && !func_mode.equals("")){
		PreparedStatement pstmt 	= null;
		PreparedStatement pstmt1 	= null;

		Set<String> keySet=(Set<String>)db_collection.keySet();
	//	System.out.println("	="+keySet.toString());		
		Iterator<String> blngGrpIt=keySet.iterator(); 
		String key="";
		StringTokenizer stKey;
		String sqlDelete="";
		String sqlDelete1="";

		String code="";
		String record[];
		String db_record[];
		boolean delete=true;
		int count_del=0;
		ArrayList db_collection_list=new ArrayList();
		String blng_grp_code="";		
		String fromDate="";
		String pkg_serv_code="";
		ArrayList bean_list=new ArrayList();		
		try
		{
			//con = ConnectionManager.getConnection(p);
			while(blngGrpIt.hasNext()){
				key=(String)blngGrpIt.next();
//System.out.println("key="+key);
				db_collection_list=(ArrayList)db_collection.get(key);
				if(db_collection_list!=null && db_collection_list.size()>0 )
				{
					stKey=new StringTokenizer(key,"~~");
					if(stKey.hasMoreTokens()){
						blng_grp_code=stKey.nextToken();
					}else{
						blng_grp_code="";
					}					
					if(stKey.hasMoreTokens())
						fromDate=stKey.nextToken();
					else
						fromDate="";
					if(stKey.hasMoreTokens())
						pkg_serv_code=stKey.nextToken();
					else
						pkg_serv_code="";
					/*	System.out.println("blng_grp_code="+blng_grp_code);						
						System.out.println("fromDate="+fromDate);
						System.out.println("pkg_serv_code="+pkg_serv_code);*/
						if(key!=null && !key.equals("") && !key.startsWith("~~")){
					if(bean_collection!=null && bean_collection.size()>0 && bean_collection.containsKey(key)){
						bean_list=(ArrayList)bean_collection.get(key);
						if(func_mode.equals("BLNG_GRP_RATE_BASED")){
							//if(pstmt!=null) pstmt=null;
							if(pstmt!=null) pstmt.close();
							//if(pstmt1!=null) pstmt1=null;
							if(pstmt1!=null) pstmt1.close();
							//System.out.println("in billing group rate based ,delete a key");
							sqlDelete = "delete from BL_PACKAGE_COVERAGE_FOR_BG where operating_Facility_id=? and package_code=? and BLNG_GRP_ID=?  and eff_from_date=to_date(?,'dd/mm/yyyy') and rate_charge_ind='R' and pkg_serv_code=?";
							sqlDelete1 = "delete from BL_PACKAGE_EXCL_FOR_BG where operating_Facility_id=? and package_code=? and BLNG_GRP_ID=? and eff_from_date=to_date(?,'dd/mm/yyyy')and rate_charge_ind='R' and pkg_serv_code=? ";
							pstmt=con.prepareStatement(sqlDelete);
							pstmt1=con.prepareStatement(sqlDelete1);
							for(int i=0; i<db_collection_list.size(); i++){//delete only the once deleted by the user
								db_record=(String[])db_collection_list.get(i);
								code=db_record[1];
								delete=true;
							//	System.out.println("code="+code);
								for(int j=0;j<bean_list.size();j++){
									record=(String[]) bean_list.get(j);
									//System.out.println("record[1]="+record[1]);
									if(record[1].equals(code)){
										delete=false;
										break;
									}
								}
								//System.out.println("delete="+delete);
								if(delete){
								//System.out.println("@@@@@");
									count_del++;
									pstmt.setString(1,facility_id);
									pstmt.setString(2,package_code);
									pstmt.setString(3,blng_grp_code);									
									pstmt.setString(4,fromDate);
									pstmt.setString(5,code);
									pstmt.addBatch();

									pstmt1.setString(1,facility_id);
									pstmt1.setString(2,package_code);
									pstmt1.setString(3,blng_grp_code);									
									pstmt1.setString(4,fromDate);
									pstmt1.setString(5,code);
									pstmt1.addBatch();

								}
							}
							//System.out.println("count_del="+count_del);
							if(count_del>0){
							//System.out.println("before delete");
								pstmt1.executeBatch();
								pstmt.executeBatch();

							}
						}
						else if(func_mode.equals("BLNG_GRP_SRVLIMIT_RATE_BASED")){
						//System.out.println("");
						//	if(pstmt!=null) pstmt=null;
						if(pstmt!=null) pstmt.close();
							sqlDelete = "delete from BL_PACKAGE_EXCL_FOR_BG where operating_Facility_id=? and package_code=? and BLNG_GRP_ID=? and eff_from_date=to_date(?,'dd/mm/yyyy') and rate_charge_ind='R' and pkg_serv_code=? and excl_serv_code=?";
							pstmt=con.prepareStatement(sqlDelete);
							for(int i=0; i<db_collection_list.size(); i++){//delete only the once deleted by the user
								db_record=(String[])db_collection_list.get(i);
								code=db_record[1];
								delete=true;
								//System.out.println("code="+code);

								for(int j=0;j<bean_list.size();j++){
									record=(String[]) bean_list.get(j);
									if(record[1].equals(code)){
										delete=false;
										break;
									}
								}
								if(delete){
									count_del++;
									pstmt.setString(1,facility_id);
									pstmt.setString(2,package_code);
									pstmt.setString(3,blng_grp_code);									
									pstmt.setString(4,fromDate);
									pstmt.setString(5,pkg_serv_code);
									pstmt.setString(6,code);
									pstmt.addBatch();
								}
							}
							//System.out.println("count_del="+count_del);
							if(count_del>0){
								pstmt.executeBatch();
							}
						}
						else if(func_mode.equals("BLNG_GRP_CHARGE_BASED")){
							//if(pstmt!=null) pstmt=null;
							if(pstmt!=null) pstmt.close();
							//if(pstmt1!=null) pstmt1=null;
							if(pstmt1!=null) pstmt1.close();
							sqlDelete = "delete from BL_PACKAGE_COVERAGE_FOR_BG where operating_Facility_id=? and package_code=? and BLNG_GRP_ID=?  and eff_from_date=to_date(?,'dd/mm/yyyy') and rate_charge_ind='C' and pkg_serv_code=?";
							sqlDelete1 = "delete from BL_PACKAGE_EXCL_FOR_BG where operating_Facility_id=? and package_code=? and BLNG_GRP_ID=?  and eff_from_date=to_date(?,'dd/mm/yyyy') and rate_charge_ind='C' and pkg_serv_code=? ";
							pstmt=con.prepareStatement(sqlDelete);
							pstmt1=con.prepareStatement(sqlDelete1);
							for(int i=0; i<db_collection_list.size(); i++){//delete only the once deleted by the user
								db_record=(String[])db_collection_list.get(i);
								code=db_record[0];
								delete=true;
								//System.out.println("code="+code);
								for(int j=0;j<bean_list.size();j++){
									record=(String[]) bean_list.get(j);
									if(record[0].equals(code)){
										delete=false;
										break;
									}
								}
								//System.out.println("delete="+delete);
								if(delete){
									count_del++;
									pstmt.setString(1,facility_id);
									pstmt.setString(2,package_code);
									pstmt.setString(3,blng_grp_code);									
									pstmt.setString(4,fromDate);
									pstmt.setString(5,code);
									pstmt.addBatch();

									pstmt1.setString(1,facility_id);
									pstmt1.setString(2,package_code);
									pstmt1.setString(3,blng_grp_code);									
									pstmt1.setString(4,fromDate);
									pstmt1.setString(5,code);
									pstmt1.addBatch();

								}
							}
							//System.out.println("count_del="+count_del);
							if(count_del>0){
								pstmt.executeBatch();
								pstmt1.executeBatch();
							}
						}
						else if(func_mode.equals("BLNG_GRP_CHARGE_BASED_ITEM")){
							//if(pstmt!=null) pstmt=null;
							if(pstmt!=null) pstmt.close();
							sqlDelete = "delete from BL_PACKAGE_EXCL_FOR_BG where operating_Facility_id=? and package_code=? and BLNG_GRP_ID=? and eff_from_date=to_date(?,'dd/mm/yyyy') and rate_charge_ind='C' and pkg_serv_code=? and excl_serv_code=?";
							pstmt=con.prepareStatement(sqlDelete);
							for(int i=0; i<db_collection_list.size(); i++){//delete only the once deleted by the user
								db_record=(String[])db_collection_list.get(i);
								code=db_record[0];
								delete=true;
								//System.out.println("code="+code);

								for(int j=0;j<bean_list.size();j++){
									record=(String[]) bean_list.get(j);
									if(record[0].equals(code)){
										delete=false;
										break;
									}
								}
								if(delete){
									count_del++;
									pstmt.setString(1,facility_id);
									pstmt.setString(2,package_code);
									pstmt.setString(3,blng_grp_code);									
									pstmt.setString(4,fromDate);
									pstmt.setString(5,pkg_serv_code);
									pstmt.setString(6,code);
									pstmt.addBatch();
								}
							}
							//System.out.println("count_del="+count_del);
							if(count_del>0){
								pstmt.executeBatch();
							}
						}
					}
					else {
						if(func_mode.equals("BLNG_GRP_RATE_BASED")){
							//if(pstmt!=null) pstmt=null;
							if(pstmt!=null) pstmt.close();
							sqlDelete = "delete from BL_PACKAGE_COVERAGE_FOR_BG where operating_Facility_id=? and package_code=? and BLNG_GRP_ID=? and eff_from_date=to_date(?,'dd/mm/yyyy') and rate_charge_ind='R'";
							pstmt=con.prepareStatement(sqlDelete);
							pstmt.setString(1,facility_id);
							pstmt.setString(2,package_code);
							pstmt.setString(3,blng_grp_code);
							pstmt.setString(4,fromDate);
							pstmt.executeUpdate();
							//if(pstmt!=null) pstmt=null;
							if(pstmt!=null) pstmt.close();
							sqlDelete = "delete from BL_PACKAGE_EXCL_FOR_BG where operating_Facility_id=? and package_code=? and BLNG_GRP_ID=? and eff_from_date=to_date(?,'dd/mm/yyyy') and rate_charge_ind='R'";
							pstmt=con.prepareStatement(sqlDelete);
							pstmt.setString(1,facility_id);
							pstmt.setString(2,package_code);
							pstmt.setString(3,blng_grp_code);
							pstmt.setString(4,fromDate);
							pstmt.executeUpdate();
						}
						else if(func_mode.equals("BLNG_GRP_SRVLIMIT_RATE_BASED")){
							//if(pstmt!=null) pstmt=null;
							if(pstmt!=null) pstmt.close();
							sqlDelete = "delete from BL_PACKAGE_EXCL_FOR_BG where operating_Facility_id=? and package_code=? and BLNG_GRP_ID=? and eff_from_date=to_date(?,'dd/mm/yyyy')  and pkg_serv_code=? and rate_charge_ind='R'";
							pstmt=con.prepareStatement(sqlDelete);
							pstmt.setString(1,facility_id);
							pstmt.setString(2,package_code);
							pstmt.setString(3,blng_grp_code);
							pstmt.setString(4,fromDate);
							pstmt.setString(5,pkg_serv_code);

							pstmt.executeUpdate();
						}
						else if(func_mode.equals("BLNG_GRP_CHARGE_BASED")){
							//if(pstmt!=null) pstmt=null;
							if(pstmt!=null) pstmt.close();
							sqlDelete = "delete from BL_PACKAGE_COVERAGE_FOR_BG where operating_Facility_id=? and package_code=? and BLNG_GRP_ID=?  and eff_from_date=to_date(?,'dd/mm/yyyy') and rate_charge_ind='C'";
							pstmt=con.prepareStatement(sqlDelete);
							pstmt.setString(1,facility_id);
							pstmt.setString(2,package_code);
							pstmt.setString(3,blng_grp_code);							
							pstmt.setString(4,fromDate);

							pstmt.executeUpdate();
							//if(pstmt!=null) pstmt=null;
							if(pstmt!=null) pstmt.close();
							sqlDelete = "delete from BL_PACKAGE_EXCL_FOR_BG where operating_Facility_id=? and package_code=? and BLNG_GRP_ID=?  and eff_from_date=to_date(?,'dd/mm/yyyy')  and rate_charge_ind='C'";
							pstmt=con.prepareStatement(sqlDelete);
							pstmt.setString(1,facility_id);
							pstmt.setString(2,package_code);
							pstmt.setString(3,blng_grp_code);							
							pstmt.setString(4,fromDate);
							pstmt.executeUpdate();
						}
						else if(func_mode.equals("BLNG_GRP_CHARGE_BASED_ITEM")){
							//if(pstmt!=null) pstmt=null;
							if(pstmt!=null) pstmt.close();
							sqlDelete = "delete from BL_PACKAGE_EXCL_FOR_BG where operating_Facility_id=? and package_code=? and BLNG_GRP_ID=? and eff_from_date=to_date(?,'dd/mm/yyyy')  and pkg_serv_code=? and rate_charge_ind='C'";
							pstmt=con.prepareStatement(sqlDelete);
							pstmt.setString(1,facility_id);
							pstmt.setString(2,package_code);
							pstmt.setString(3,blng_grp_code);							
							pstmt.setString(4,fromDate);
							pstmt.setString(5,pkg_serv_code);
							pstmt.executeUpdate();
						}
					}
					}
				}
			}
			if(pstmt!=null) pstmt.close();
			if(pstmt1!=null) pstmt1.close();
		}catch(Exception e)
		{
			result=false;
			System.err.println("Exception on deletion Change based :"+e);
			e.printStackTrace();
		}
		finally
		{
			try{
			if(pstmt!=null) pstmt.close();
			if(pstmt1!=null) pstmt1.close();
			}catch(Exception r)
			{r.printStackTrace();}
			}
		}
		return result;
}

@SuppressWarnings("rawtypes")
public boolean existsInDBBlngGrp(String key,String[] record,HashMap db_collection,String func_mode) //throws Exception
{
	boolean existsInDB=false;
	String db_record[];
	ArrayList list=new ArrayList();    
	try{
		if(db_collection!=null && db_collection.size()>0 && db_collection.containsKey(key)){
			list=(ArrayList)(db_collection.get(key));
			for(int i=0;i<list.size();i++){
			  db_record=(String[])list.get(i);
			  if(func_mode.equals("BILLINGGROUP") || func_mode.equals("BLNG_GRP_PERIOD") || func_mode.equals("BLNG_GRP_PRICE")  || func_mode.equals("BLNG_GRP_CHARGE_BASED") || func_mode.equals("BLNG_GRP_CHARGE_BASED_ITEM")){
					if(record[0].equals(db_record[0])){
						existsInDB=true;
					}
				}else if(func_mode.equals("BLNG_GRP_RATE_BASED") || func_mode.equals("BLNG_GRP_SRVLIMIT_RATE_BASED")){
					if(record[1].equals(db_record[1])){
						existsInDB=true;
					}
				}
			  }
		}
	}catch(Exception e){
		System.err.println("Exception in existsInDBBlngGrp of PkgDefManager.java="+e);
		e.printStackTrace();
	}
	return existsInDB;
}
//Ended By Shikha For GHL-CRF-0520.1
}
