/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;
import java.io.*;
import java.util.*;
import java.sql.*;
import eBL.Common.*;
import webbeans.eCommon.*;
import eCommon.Common.CommonAdapter;

public class PkgEnqBean extends BlAdapter implements Serializable
{
	protected String packageCode			= "";
	protected String longDesc				= "";
	protected String shortDesc				= "";
	protected String effFromDate			= "";
	protected String effToDate				= "";
	protected String applSexInd				= "";
	protected String minAgeInYrs			= "";
	protected String minAgeInMths			= "";
	protected String minAgeInDays			= "";
	protected String maxAgeInYrs			= "";
	protected String maxAgeInMths			= "";
	protected String maxAgeInDays			= "";
	protected String opYn					= "";
	protected String emYn					= "";
	protected String ipYn					= "";
	protected String dcYn					= "";
	protected String allYn					= "";
	protected String orderAssociated		= "";
	protected String acrossEncounters		= "";
	protected String applicalbleTo			= "";
	protected String auto					= "";
	protected String validDays				= ""; 
	protected String approvedYN				= "";
	protected String approvedBy	            = "";
	protected String approvedDate	        = "";
	protected String deposit				= "";
	protected String partialDeposit			= "";
	protected String minDepAmt				= "";
	protected String fromDate				= "";
	protected String depositCtdAmt			= "";
	protected String billingClass			= "";
	protected String customerGrp			= "";
	protected String customerCode			= "";
	protected String pkgPrice				= "";
	protected String status					= "";

	/******* Customer spefic ******* start ******/
	protected HashMap custSpecific	= new HashMap();
	/******* Customer spefic******* end ******/

	
	/******* base Dates&Price******* start ******/
	protected HashMap baseDates		= new HashMap();
	protected HashMap basePrice		= new HashMap();
	/******* base Dates&Price******* end ******/

	/******* charge Based values******* start ******/
	protected HashMap excludedItems_CB		= new HashMap();
	protected HashMap includedItems_CB		= new HashMap();
	/******* charge Based values******* end ******/
	protected HashMap latestDate			= new HashMap();
	//protected HashMap includSrvicesDB_CB	= new HashMap();
	//protected HashMap excludSrvicesDB_CB    = new HashMap();

	HashMap hashPrice						= new HashMap();
	/******* rate Based values******* start ******/
	protected HashMap excludedItems_RB		= new HashMap();
	protected HashMap includedItems_RB		= new HashMap();
	/******* rate Based values******* end ******/
	/******* Customer values******* start ******/
	protected HashMap includedItems_cust		= new HashMap();	
	/******* Customer values******* end ******/
	/****these flags are to  check if the user clicked a perticular tab**start***/
	protected String modifyRateBased			= "N";
	protected String modifyRateSrvLimits		= "N";
	protected String modifyChargeBased			= "N";
	protected String modifyChargeItems			= "N";
	protected String modifyCustomer			= "N";
	public PkgEnqBean()
	{	
		//System.out.println("Bean Initialized");
	}

	public HashMap validate() throws Exception
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." );
		return map;
	}
	
	public void  setFromDate(String  fromDate)
	{ 
		this.fromDate = checkForNull(fromDate,"");
	}

	public void  setPackageCode(String  packageCode)
	{ 
		this.packageCode = checkForNull(packageCode,"");
	}
	
	public void  setLongDesc(String  longDesc)
	{ 
		this.longDesc = checkForNull(longDesc,"");
	}

	public void  setEffFromDate(String  effFromDate)
	{ 
		this.effFromDate = checkForNull(effFromDate,"");
	}

	public void  setEffToDate(String  effToDate)
	{ 
		this.effToDate = checkForNull(effToDate,"");
	}

	public void  setShortDesc(String  shortDesc)
	{ 
		this.shortDesc = checkForNull(shortDesc,"");
	}
	public void  setApplSexInd (String  applSexInd )
	{ 
		this.applSexInd  = checkForNull(applSexInd ,"");
	}
	public void  setMinAgeInYrs (String  minAgeInYrs )
	{ 
		this.minAgeInYrs  = checkForNull(minAgeInYrs ,"");
	}
	public void  setMinAgeInMths (String  minAgeInMths )
	{ 
		this.minAgeInMths  = checkForNull(minAgeInMths ,"");
	}
	public void  setMinAgeInDays (String  minAgeInDays )
	{ 
		this.minAgeInDays  = checkForNull(minAgeInDays ,"");
	}
	public void  setMaxAgeInYrs (String  maxAgeInYrs )
	{ 
		this.maxAgeInYrs  = checkForNull(maxAgeInYrs ,"");
	}
	public void  setMaxAgeInMths (String  maxAgeInMths )
	{ 
		this.maxAgeInMths  = checkForNull(maxAgeInMths ,"");
	}
	public void  setMaxAgeInDays (String  maxAgeInDays )
	{ 
		this.maxAgeInDays  = checkForNull(maxAgeInDays ,"");
	}
	public void  setOpYn(String  opYn)
	{ 
		this.opYn = checkForNull(opYn,"");
	}
	public void  setEmYn(String  emYn)
	{ 
		this.emYn = checkForNull(emYn,"");
	}
	public void  setIpYn(String  ipYn)
	{ 
		this.ipYn = checkForNull(ipYn,"");
	}
	public void  setDcYn(String  dcYn)
	{ 
		this.dcYn = checkForNull(dcYn,"");
	}
	public void  setAllYn(String  allYn)
	{ 
		this.allYn = checkForNull(allYn,"");
	}
	public void  setOrderAssociated(String  orderAssociated)
	{ 
		this.orderAssociated = checkForNull(orderAssociated,"");
	}
	public void  setAcrossEncounters(String  acrossEncounters)
	{ 
		this.acrossEncounters = checkForNull(acrossEncounters,"");
	}
	public void  setApplicalbleTo(String  applicalbleTo)
	{ 
		this.applicalbleTo = checkForNull(applicalbleTo,"");
	}
	public void  setAuto(String  auto)
	{ 
		this.auto = checkForNull(auto,"");
	}
	public void  setValidDays(String  validDays)
	{ 
		this.validDays = checkForNull(validDays,"");
	}

	
	public void  setApprovedYN(String  approvedYN)
	{ 
		this.approvedYN = checkForNull(approvedYN,"");
	}

	public void  setApprovedBy(String  approvedBy)
	{ 
		this.approvedBy = checkForNull(approvedBy,"");
	}

	public void  setApprovedDate(String  approvedDate)
	{ 
		this.approvedDate = checkForNull(approvedDate,"");
	}

	public void  setDepositCtdAmt(String  depositCtdAmt)
	{ 
		this.depositCtdAmt = checkForNull(depositCtdAmt,"");
	}	
	public void  setBillingClass(String  billingClass)
	{ 
		this.billingClass = checkForNull(billingClass,"");
	}	
	public void  setCustomerGrp(String  customerGrp)
	{ 
		this.customerGrp = checkForNull(customerGrp,"");
	}	
	public void  setCustomerCode(String  customerCode)
	{ 
		this.customerCode = checkForNull(customerCode,"");
	}	
	public void  setPkgPrice(String  pkgPrice)
	{ 
		this.pkgPrice = checkForNull(pkgPrice,"");
	}	
	public void  setStatus(String  status)
	{ 
		this.status = checkForNull(status,"");
	}	

	/* Methods for base Price -- start*/
	public void  setBasePrice(HashMap  basePrice)
	{ 
		this.basePrice = basePrice;
	}
	public HashMap getBasePrice(){
		return this.basePrice;
	}
	public void  setCustSpecific(HashMap  custSpecific)
	{ 
		this.custSpecific = custSpecific;
	}

	public HashMap getCustSpecific(){
		return this.custSpecific;
	}
	
	public void setModifyRateBased(String flag){
		this.modifyRateBased=flag;
	}
	public String getModifyRateBased(){
		return this.modifyRateBased;
	}
		public void setModifyRateSrvLimits(String flag){
		this.modifyRateSrvLimits=flag;
	}
	public String getModifyRateSrvLimits(){
		return this.modifyRateSrvLimits;
	}
	public void setModifyChargeBased(String flag){
		this.modifyChargeBased=flag;
	}
	public String getModifyChargeBased(){
		return this.modifyChargeBased;
	}	
	public void setModifyChargeItems(String flag){
		this.modifyChargeItems=flag;
	}
	public String getModifyChargeItems(){
		return this.modifyChargeItems;
	}
	public void setModifyCustomer(String flag){
		this.modifyCustomer=flag;
	}
	public String getModifyCustomer(){
		return this.modifyCustomer;
	}		


	public void  setExcludedItems_CB(HashMap  excludedItems_CB)
	{ 
		this.excludedItems_CB = excludedItems_CB;
	}
	public void  setIncludedItems_CB(HashMap  includedItems_CB)
	{ 
		this.includedItems_CB = includedItems_CB;
	}
	public String getPackageCode()
	{ 
		return this.packageCode ; 
	}
	public String getFromDate()
	{ 
		return this.fromDate ; 
	}
	public String getLongDesc()
	{ 
		return this.longDesc ; 
	}

	public String  getEffFromDate()
	{ 
		return this.effFromDate;
	}

	public String  getEffToDate()
	{ 
		return this.effToDate;
	}

	public String  getShortDesc()
	{ 
		return this.shortDesc;
	}
	public String  getApplSexInd ( )
	{ 
		return this.applSexInd;
	}
	public String  getMinAgeInYrs ( )
	{ 
		return this.minAgeInYrs; 
	}
	public String  getMinAgeInMths ( )
	{ 
		return this.minAgeInMths;
	}
	public String  getMinAgeInDays ( )
	{ 
		return this.minAgeInDays; 
	}
	public String  getMaxAgeInYrs ( )
	{ 
		return this.maxAgeInYrs;
	}
	public String  getMaxAgeInMths ( )
	{ 
		return this.maxAgeInMths;
	}
	public String  getMaxAgeInDays ( )
	{ 
		return this.maxAgeInDays;
	}
	public String  getOpYn()
	{ 
		return this.opYn;
	}
	public String  getEmYn()
	{ 
		return this.emYn;
	}
	public String  getIpYn()
	{ 
		return this.ipYn;
	}
	public String  getDcYn()
	{ 
		return this.dcYn;
	}
	public String  getAllYn()
	{ 
		return this.allYn; 
	}
	public String  getOrderAssociated()
	{ 
		return this.orderAssociated;
	}
	public String  getAcrossEncounters()
	{ 
		return this.acrossEncounters; 
	}
	public String  getApplicalbleTo()
	{ 
		return this.applicalbleTo;
	}
	public String  getAuto()
	{ 
		return this.auto;
	}
	public String  getValidDays()
	{ 
		return this.validDays;
	}

	public String getApprovedYN(){
	return this.approvedYN;
	}
	
	public String getApprovedBy(){
		return this.approvedBy;
	}
	public String getApprovedDate(){
		return this.approvedDate;
	}
	public String getDepositCtdAmt(){
		return this.depositCtdAmt;
	}
	
	public String  getBillingClass()
	{ 
		return this.billingClass;
	}	
	public String  getCustomerGrp()
	{ 
		return this.customerGrp;
	}	
	public String getCustomerCode()
	{ 
		return this.customerCode;
	}	
	public String  getPkgPrice()
	{ 
		return this.pkgPrice;
	}	
	public String  getStatus()
	{ 
		return this.status;
	}	
	public HashMap getExcludedItems_CB()
	{ 
		return this.excludedItems_CB ; 
	}
	public HashMap getIncludedItems_CB()
	{ 
		return this.includedItems_CB ; 
	}


	public void clearBean()
	{
		packageCode		 =	"";
		fromDate		 =	"";
		longDesc 		 =	"";
		shortDesc 		 =	"";
		effFromDate		 =	"";
		effToDate		 =	"";
		applSexInd 		 =	"";
		minAgeInYrs		 =	"";
		minAgeInMths	 =	"";
		minAgeInDays	 =	"";
		maxAgeInYrs		 =	"";
		maxAgeInMths	 =	"";
		maxAgeInDays	 =	"";
		opYn			 =	"N";
		emYn			 =	"N";
		ipYn			 =	"N";
		dcYn			 =	"N";
		allYn			 =   "N";
		orderAssociated  =   "N";
		acrossEncounters =   "N";
		applicalbleTo	 =   "";
		auto			 =   "N";
		validDays		 =   ""; 
		approvedYN	     =   "";
		approvedBy	     =   "";
		approvedDate	 =   "";
		deposit			 =   "";
		partialDeposit	 =   "";
		minDepAmt		 =   "";
		depositCtdAmt	 =   "";
		billingClass	 =   "";
		customerGrp		 =   "";
		customerCode	 =   "";
		pkgPrice		 =   "";
		status			 =   "";
		if(basePrice != null)
			basePrice.clear();
		if(includedItems_CB != null)	
			includedItems_CB.clear();
		if(excludedItems_CB != null)	
			excludedItems_CB.clear();

		if(excludedItems_RB != null)	
			excludedItems_RB.clear();

		if(includedItems_RB != null)	
			includedItems_RB.clear();
			
		if(includedItems_cust != null)	
			includedItems_cust.clear();
				

	}
	public void  setExcludedItems_RB(HashMap  excludedItems_RB)
	{ 
		this.excludedItems_RB = excludedItems_RB;
	}
	public void  setIncludedItems_RB(HashMap  includedItems_RB)
	{ 
		this.includedItems_RB = includedItems_RB;
	
	}
	public HashMap getExcludedItems_RB()
	{ 
		return this.excludedItems_RB ; 
	}
	public HashMap getIncludedItems_RB()
	{ 
		return this.includedItems_RB ; 
	}
	
	public void  setIncludedItems_cust(HashMap  includedItems_cust)
	{ 
		this.includedItems_cust = includedItems_cust;
	}
	
	public HashMap getIncludedItems_cust()
	{ 
		return this.includedItems_cust ; 
	}

	public void setDBValues(String packageCode,String packageSeqNo,String billingClass,String customerGrp,String customerCode,String language_id,String operating_facility_id,String sysDate) throws Exception
	{
		Connection connection 		= null;		
		PreparedStatement pstmt 	= null;
		CallableStatement cstmt = null;
		ResultSet rs 		= null;		
		String sqlStr="";	
		String customerDefYN	= "";
		String customerGrpFromP = "";
		String customerCodeFromP= "";
		String packagePrice		= "";
		String dateFromP		= "";
		String custGrpCode="";
		String custCode="";
		int totalRec = 0;
		int index = 0;
		customerGrp	 = customerGrp  == null ?"":customerGrp;
		customerCode = customerCode == null ?"":customerCode;
		connection = getConnection();

		/*Find out whether custome specific value is there for the package if customer related information is there  */
		try{
		if(packageSeqNo!=null && !packageSeqNo.equals("")){
				sqlStr ="SELECT b.short_desc, b.long_desc, TO_CHAR (a.eff_from_date, 'DD/MM/YYYY') eff_from_date, TO_CHAR (a.eff_to_date, 'DD/MM/YYYY') eff_to_date, a.appl_sex_ind, a.min_age_in_yrs, a.min_age_in_mths, a.min_age_in_days, a.max_age_in_yrs,  a.max_age_in_mths, a.max_age_in_days, a.op_yn, a.em_yn, a.ip_yn, a.dc_yn, a.status, a.pkg_valid_days, a.order_catalog_yn, a.across_encounter_yn, a.for_cash_or_credit, a.package_amt, a.deposit_amt,a.blng_class_code,a.cust_group_code,a.cust_code FROM bl_package_sub_hdr a, bl_package b WHERE a.package_code = ? AND a.operating_facility_id = ?	and a.operating_facility_id = b.operating_facility_id	 and   a.package_code=b.package_code and  a.PACKAGE_SEQ_NO = ?";
		}
			else{
			try
			{
//Below sqlStr is modified by Nmuthu on 12-4-12 against 31817 & updated for Factor for Service rate

				sqlStr  ="{ call   blpackage.getpackagepricedtls(?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				//Below sqlStr is modified by Nmuthu on 12-4-12 against 31817 & updated for Factor for Service rate
				cstmt = connection.prepareCall(sqlStr);							
				cstmt.setString(1,operating_facility_id);
				cstmt.setString(2,packageCode);
				if(billingClass.equals(""))
					cstmt.setString(3,null);
				else
					cstmt.setString(3,billingClass);
				cstmt.setString(4,customerGrp);
				cstmt.setString(5,customerCode);
				cstmt.setString(6,sysDate );	
				cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(14,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(15,java.sql.Types.DATE);
				cstmt.registerOutParameter(16,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(17,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(18,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(19,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(20,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(21,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(22,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(23,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(24,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(25,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(26,java.sql.Types.VARCHAR);
				//Added by Nmuthu on 26-6-12 against Factor for Service rate
				cstmt.registerOutParameter(27,java.sql.Types.VARCHAR);
				//Added by Nmuthu on 26-6-12 against Factor for Service rate
				cstmt.registerOutParameter(28,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(29,java.sql.Types.VARCHAR);
				//Added by Nmuthu on 12-4-12 against 31817
				cstmt.registerOutParameter(30,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
				//Added by Nmuthu on 12-4-12 against 31817
				cstmt.execute();	
				customerDefYN=cstmt.getString(10);
				customerGrpFromP=cstmt.getString(13);
				customerCodeFromP=cstmt.getString(14);
				customerCodeFromP=cstmt.getString(16);
				if(cstmt.getDate(15) !=null)
				{
					java.util.Date currentdate=cstmt.getDate(15);
					java.text.SimpleDateFormat sf=new java.text.SimpleDateFormat("dd/MM/yyyy");
					dateFromP =sf.format(currentdate);
				}
				packagePrice=cstmt.getString(16);
			}
			catch(Exception e)
			{
				System.out.println("Exception from blpackage.getpackagepricedtls :"+e);
					e.printStackTrace();
			}
			finally
			{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			}
			sqlStr ="select SHORT_DESC, LONG_DESC, TO_CHAR(EFF_FROM_DATE,'DD/MM/YYYY') EFF_FROM_DATE, TO_CHAR(EFF_TO_DATE,'DD/MM/YYYY') EFF_TO_DATE, APPL_SEX_IND, MIN_AGE_IN_YRS, MIN_AGE_IN_MTHS, MIN_AGE_IN_DAYS, MAX_AGE_IN_YRS, MAX_AGE_IN_MTHS, MAX_AGE_IN_DAYS, OP_YN, EM_YN, IP_YN, DC_YN, STATUS, PKG_VALID_DAYS, ORDER_CATALOG_YN, ACROSS_ENCOUNTER_YN, FOR_CASH_OR_CREDIT,APPROVED_YN, APPROVED_BY,TO_CHAR(APPROVED_DATE,'DD/MM/YYYY') APPROVED_DATE from BL_PACKAGE where PACKAGE_CODE=? and OPERATING_FACILITY_ID = ?";
		}
		
		try
		{  
			pstmt=connection.prepareStatement(sqlStr);	
			pstmt.setString(1,packageCode);
			pstmt.setString(2,operating_facility_id);
			if(packageSeqNo!=null && !packageSeqNo.equals(""))
				pstmt.setString(3,packageSeqNo);

			rs = pstmt.executeQuery();
			if(rs.next())
			{
				setPackageCode(packageCode);
				setLongDesc(checkForNull(rs.getString("LONG_DESC")));
				setShortDesc(checkForNull(rs.getString("SHORT_DESC")));
				setEffFromDate(checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("EFF_FROM_DATE"),"DMY","en",language_id)));
				setEffToDate(checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("EFF_TO_DATE"),"DMY","en",language_id)));
				setApplSexInd(checkForNull(rs.getString("APPL_SEX_IND")));
				setMinAgeInYrs(checkForNull(rs.getString("MIN_AGE_IN_YRS")));
				setMinAgeInMths(checkForNull(rs.getString("MIN_AGE_IN_MTHS")));
				setMinAgeInDays(checkForNull(rs.getString("MIN_AGE_IN_DAYS")));
				setMaxAgeInYrs(checkForNull(rs.getString("MAX_AGE_IN_YRS")));
				setMaxAgeInMths(checkForNull(rs.getString("MAX_AGE_IN_MTHS")));
				setMaxAgeInDays(checkForNull(rs.getString("MAX_AGE_IN_DAYS")));
				opYn	= checkForNull(rs.getString("OP_YN"),"N");
				emYn	= checkForNull(rs.getString("EM_YN"),"N");
				ipYn	= checkForNull(rs.getString("IP_YN"),"N");
				dcYn	= checkForNull(rs.getString("DC_YN"),"N");
				allYn	= (opYn.equals("Y")&&emYn.equals("Y")&&ipYn.equals("Y")&&dcYn.equals("Y"))?"Y" :"N";
				setOpYn(opYn);
				setEmYn(emYn);
				setIpYn(ipYn);
				setDcYn(dcYn);
				setAllYn(allYn);
				setOrderAssociated(checkForNull(rs.getString("ORDER_CATALOG_YN"),"N"));
				setAcrossEncounters(checkForNull(rs.getString("ACROSS_ENCOUNTER_YN"),"N"));
				setApplicalbleTo(checkForNull(rs.getString("FOR_CASH_OR_CREDIT")));
				setAuto(checkForNull(rs.getString("ORDER_CATALOG_YN"),"N"));
				setValidDays(checkForNull(rs.getString("PKG_VALID_DAYS")));
				if(packageSeqNo!=null && !packageSeqNo.equals(""))
				{
					setDepositCtdAmt(checkForNull(rs.getString("deposit_amt")));
					setBillingClass(checkForNull(rs.getString("blng_class_code")));
					setCustomerGrp(checkForNull(rs.getString("CUST_GROUP_CODE")));
					setCustomerCode(checkForNull(rs.getString("CUST_CODE")));
					setPkgPrice(checkForNull(rs.getString("package_amt")));					
					setStatus(checkForNull(rs.getString("status")));
				}
				else	
				{
					setDepositCtdAmt("");
					setBillingClass(checkForNull(billingClass));
					setCustomerGrp(checkForNull(customerGrp));
					setCustomerCode(checkForNull(customerCode));
					setPkgPrice(packagePrice);
					setStatus("");
					setApprovedYN(checkForNull(rs.getString("APPROVED_YN"),"N"));
					setApprovedBy(checkForNull(rs.getString("APPROVED_BY")));
					setApprovedDate(checkForNull(rs.getString("APPROVED_DATE")));

				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception from Package MAin :"+e);
				e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}

		if(customerDefYN.equals("Y"))
			fromDate = dateFromP;
		else
		{
			sqlStr ="SELECT TO_CHAR (eff_from_date, 'DD/MM/YYYY') eff_from_date  FROM bl_package_period WHERE operating_facility_id = ?   AND to_date(?,'dd/mm/yyyy') BETWEEN eff_from_date and nvl(eff_to_date,to_date('31/12/5555','dd/mm/yyyy'))   AND package_code = ? ";
			try
			{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				pstmt=connection.prepareStatement(sqlStr);	
				pstmt.setString(1,operating_facility_id);
				pstmt.setString(2,sysDate);
				pstmt.setString(3,packageCode);
				rs = pstmt.executeQuery();
				if (rs.next())
				{	
					fromDate = checkForNull(rs.getString("eff_from_date"));
				}
			}
			catch(Exception e)
			{
				System.out.println("Exception from Package date :"+e);
					e.printStackTrace();
			} 
			finally
			{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			}
			
		}
		setFromDate(fromDate);
		//Added V180902-Gayathri/MMS-DM-SCF-0290/Starts
		sqlStr ="SELECT cust_group_code, cust_code from(SELECT  a.cust_group_code,a.cust_code FROM bl_package_coverage_for_cust a WHERE NVL (a.cust_group_code, '**') IN (NVL (?, '**'), '**') AND NVL (a.cust_code, '**') IN (NVL (?, '**'), '**') AND a.operating_facility_id = ?  AND a.package_code =? AND a.eff_from_date = TO_DATE (?, 'dd/mm/yyyy') ORDER BY DECODE (NVL (a.cust_group_code, '**'), '**', 999, 1),DECODE (NVL (a.cust_code, '**'), '**', 999, 1))WHERE ROWNUM = 1";
		try
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			
			pstmt=connection.prepareStatement(sqlStr);	
			
			
			
			pstmt.setString(1,customerGrpFromP);
			pstmt.setString(2,customerCode);
			pstmt.setString(3,operating_facility_id);
			pstmt.setString(4,packageCode);
			pstmt.setString(5,fromDate);
			rs = pstmt.executeQuery();
			if (rs.next())
			{	
				
				custGrpCode= checkForNull(rs.getString("cust_group_code"));
				custCode= checkForNull(rs.getString("cust_code"));
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception from Package date :"+e);
				e.printStackTrace();
		} 
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
		//Added V180902-Gayathri/MMS-DM-SCF-0290/Ends
	
		/* Rate based */
		ArrayList	type_list				=	new ArrayList();
		ArrayList	service_code_list		=	new ArrayList();
		ArrayList	service_desc_list	    =	new ArrayList();
		ArrayList	catalog_code_list		=	new ArrayList();
		ArrayList	catalog_desc_list		=	new ArrayList();
		ArrayList	ind_list				=	new ArrayList();
		ArrayList	factorOrRate_list		=	new ArrayList();
		ArrayList	qty_limit_list			=	new ArrayList();
		ArrayList	amt_limit_ind_list		=	new ArrayList();
		ArrayList	amt_limit_list			=	new ArrayList();
		ArrayList	replace_list			=	new ArrayList();
		ArrayList	replaceSrv_code_list    =	new ArrayList();
		ArrayList	replaceSrv_desc_list    =	new ArrayList();
		ArrayList	replaceSrv_cat_code_list=	new ArrayList();
		ArrayList	replaceSrv_cat_desc_list=	new ArrayList();
		ArrayList	refund_list				=	new ArrayList();
		ArrayList	refundAmt_list			=	new ArrayList();	
		ArrayList	factor_appl_list		=	new ArrayList();	
		ArrayList	service_limit_list		=	new ArrayList();
		ArrayList	auto_refund_list		=	new ArrayList();
		ArrayList	roundTo_list			=	new ArrayList();
		ArrayList	roundInd_list			=	new ArrayList();
		ArrayList	closePkg_list			=	new ArrayList();
		ArrayList	utilizedAmt_list		=	new ArrayList();
		ArrayList	utilizedQty_list		=	new ArrayList();
		ArrayList	refundedYN_list			=	new ArrayList();
		ArrayList   includedItems_RBD		=	new ArrayList();
		//HashMap		dbIncludedItem_RBD		=   new HashMap();		//unused variable
		HashMap		includedItems_RB		=   new HashMap();	
		if(packageSeqNo!=null && !packageSeqNo.equals(""))
			sqlStr="SELECT a.close_package_yn, rounding_by_integer, rounding_option, auto_refund_yn, pkg_serv_ind, pkg_serv_code, b.service_desc,a.order_catalog_code order_catalog_code,(SELECT short_desc FROM or_order_catalog_lang_vw WHERE language_id = ?       AND order_catalog_code = a.order_catalog_code) order_catalog_desc,   rate_ind, factor_rate, qty_limit, amt_limit_ind, amt_limit, amt_limit_ind, replaceable_yn, replaceable_serv_code,(SELECT short_desc FROM bl_blng_serv_lang_vw WHERE language_id = ? AND blng_serv_code = replaceable_serv_code) replaceable_serv_desc,rep_serv_ord_cat_code,     (SELECT short_desc FROM or_order_catalog_lang_vw WHERE language_id = ?    AND order_catalog_code = a.rep_serv_ord_cat_code)                      rep_serv_ord_cat_desc,refund_yn, refund_rate, a.apply_fact_for_srv_lmt_yn factor_appl,utilized_serv_qty, utilized_serv_amt,refund_processed_yn,    (SELECT 'Y' FROM bl_package_sub_excl WHERE operating_facility_id = a.operating_facility_id AND package_code = a.package_code AND pkg_serv_code = a.pkg_serv_code AND ROWNUM = 1) service_limit FROM bl_package_sub_dtls a,(SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc, language_id FROM bl_blng_serv_lang_vw        UNION ALL SELECT 'C' serv_ind, serv_classification_code code,            short_desc service_desc, language_id FROM bl_serv_classification_lang_vw UNION ALL SELECT 'G' serv_ind, serv_grp_code code, short_desc service_desc, language_id FROM bl_blng_serv_grp_lang_vw) b WHERE a.operating_facility_id = ? AND a.package_code = ? AND a.rate_charge_ind = ?  AND a.pkg_serv_code = b.code AND a.pkg_serv_ind = b.serv_ind AND b.language_id = ? and a.PACKAGE_SEQ_NO = ?";
			else
			{
			//Updated Query V180902-Gayathri/MMS-DM-SCF-0290
				if(customerDefYN.equals("Y"))
				sqlStr = "SELECT a.close_package_yn, rounding_by_integer, rounding_option,APPLY_FACT_FOR_SRV_LMT_YN, auto_refund_yn, pkg_serv_ind, pkg_serv_code, b.service_desc, a.order_catalog_code order_catalog_code, (SELECT short_desc FROM or_order_catalog_lang_vw WHERE language_id = ?           AND order_catalog_code = a.order_catalog_code) order_catalog_desc,       rate_ind, factor_rate, qty_limit, amt_limit_ind, amt_limit,	      amt_limit_ind, replaceable_yn, replaceable_serv_code, (SELECT short_desc FROM bl_blng_serv_lang_vw WHERE language_id = ?	AND blng_serv_code = a.replaceable_serv_code) replaceable_serv_desc,	rep_serv_ord_cat_code,  (SELECT short_desc FROM or_order_catalog_lang_vw WHERE language_id = ?  AND order_catalog_code = a.rep_serv_ord_cat_code) rep_serv_ord_cat_desc, refund_yn, refund_rate, a.apply_fact_for_srv_lmt_yn factor_appl,	       (SELECT 'Y' FROM bl_package_excl_for_cust	WHERE operating_facility_id = a.operating_facility_id	AND package_code = a.package_code AND pkg_serv_code = a.pkg_serv_code	and cust_group_code =a.cust_group_code   and cust_code=a.cust_code AND ROWNUM = 1) service_limit	FROM bl_package_coverage_for_cust a,	(SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc, language_id FROM bl_blng_serv_lang_vw     UNION ALL SELECT 'C' serv_ind, serv_classification_code code,            short_desc service_desc, language_id FROM bl_serv_classification_lang_vw UNION ALL SELECT 'G' serv_ind, serv_grp_code code, short_desc service_desc, language_id FROM bl_blng_serv_grp_lang_vw) b WHERE a.operating_facility_id = ?	AND a.package_code = ? and A.CUST_GROUP_CODE=?	AND A.CUST_CODE=? AND a.rate_charge_ind = ?	AND a.pkg_serv_code = b.code AND a.pkg_serv_ind = b.serv_ind AND b.language_id = ? AND a.eff_from_date = TO_DATE (?, 'dd/mm/yyyy') ";
				
				else
				sqlStr="SELECT  a.CLOSE_PACKAGE_YN,ROUNDING_BY_INTEGER, ROUNDING_OPTION,APPLY_FACT_FOR_SRV_LMT_YN, AUTO_REFUND_YN,pkg_serv_ind, pkg_serv_code, b.service_desc, a.order_catalog_code order_catalog_code, (select short_desc from or_order_catalog_lang_vw where LANGUAGE_ID=? AND order_catalog_code= a.order_catalog_code) order_catalog_desc,       rate_ind, factor_rate, qty_limit, AMT_LIMIT_IND, amt_limit,AMT_LIMIT_IND , replaceable_yn, replaceable_serv_code,        (select short_desc from BL_BLNG_SERV_lang_vw where LANGUAGE_ID=? AND blng_serv_code= a.replaceable_serv_code) replaceable_serv_desc, rep_serv_ord_cat_code,(select short_desc from or_order_catalog_lang_vw where LANGUAGE_ID=? AND order_catalog_code= a.rep_serv_ord_cat_code)  rep_serv_ord_cat_desc, refund_yn, REFUND_RATE,a.apply_fact_for_srv_lmt_yn factor_appl, (select 'Y' from bl_package_exclusions where operating_facility_id=a.operating_facility_id AND package_code=a.package_code AND pkg_serv_code=a.pkg_serv_code and rownum=1) service_limit FROM bl_package_dtls a,(select 'S' Serv_Ind, blng_serv_code code, short_desc service_desc,language_id from BL_BLNG_SERV_lang_vw  union all select 'C' serv_ind, serv_classification_code code, short_desc service_desc,language_id from BL_SERV_CLASSIFICATION_lang_vw union all select 'G' serv_ind, serv_grp_code code, short_desc service_desc,language_id from bl_blng_serv_grp_lang_vw) b WHERE a.operating_facility_id = ?   AND a.package_code = ? AND a.rate_charge_ind = ? AND a.pkg_serv_code=b.code AND a.pkg_serv_ind=b.Serv_Ind AND b.language_id=? and a.EFF_FROM_DATE = to_date(?,'dd/mm/yyyy')";
			
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		try
		{
			index = 5;
			pstmt=connection.prepareStatement(sqlStr);	
			pstmt.setString(1,language_id);
			pstmt.setString(2,language_id);
			pstmt.setString(3,language_id);
			pstmt.setString(4,operating_facility_id);
			pstmt.setString(5,packageCode);
			if(customerDefYN.equals("Y"))
			{
				pstmt.setString(++index,custGrpCode);
				pstmt.setString(++index,custCode);
		
			}
			pstmt.setString(++index,"R");
			pstmt.setString(++index,language_id);
			
			if(packageSeqNo!=null && !packageSeqNo.equals(""))
				pstmt.setString(++index,packageSeqNo);
			else
				pstmt.setString(++index,fromDate);

			rs	= pstmt.executeQuery();
			while (rs.next())
			{
				type_list.add(checkForNull(rs.getString("pkg_serv_ind")));
				service_code_list.add(checkForNull(rs.getString("pkg_serv_code")));
				service_desc_list.add(checkForNull(rs.getString("service_desc")));
				catalog_code_list.add(checkForNull(rs.getString("order_catalog_code")));
				catalog_desc_list.add(checkForNull(rs.getString("order_catalog_desc")));
				ind_list.add(checkForNull(rs.getString("rate_ind")));
				factorOrRate_list.add(checkForNull(rs.getString("factor_rate")));
				qty_limit_list.add(checkForNull(rs.getString("qty_limit")));
				amt_limit_ind_list.add(checkForNull(rs.getString("AMT_LIMIT_IND")));
				amt_limit_list.add(checkForNull(rs.getString("amt_limit")));
				replace_list.add(checkForNull(rs.getString("replaceable_yn")));
				replaceSrv_code_list.add(checkForNull(rs.getString("replaceable_serv_code")));
				replaceSrv_desc_list.add(checkForNull(rs.getString("replaceable_serv_desc")));
				replaceSrv_cat_code_list.add(checkForNull(rs.getString("rep_serv_ord_cat_code")));
				replaceSrv_cat_desc_list.add(checkForNull(rs.getString("rep_serv_ord_cat_desc")));
				refund_list.add(checkForNull(rs.getString("refund_yn")));
				refundAmt_list.add(checkForNull(rs.getString("REFUND_RATE")));
				factor_appl_list.add(checkForNull(rs.getString("factor_appl")));
				auto_refund_list.add(checkForNull(rs.getString("AUTO_REFUND_YN")));
				roundTo_list.add(checkForNull(rs.getString("ROUNDING_BY_INTEGER")));
				roundInd_list.add(checkForNull(rs.getString("ROUNDING_OPTION")));
				closePkg_list.add(checkForNull(rs.getString("CLOSE_PACKAGE_YN"),"N"));
				if(packageSeqNo!=null && !packageSeqNo.equals(""))
				{
					utilizedAmt_list.add(checkForNull(rs.getString("utilized_serv_qty")));
				utilizedQty_list.add(checkForNull(rs.getString("utilized_serv_amt")));
				refundedYN_list.add(checkForNull(rs.getString("refund_processed_yn"),"N"));
				}
				else
				{
				  	utilizedAmt_list.add("");
					utilizedQty_list.add("");
					refundedYN_list.add("N");

						}
		//Updated Column Name  V180902-Gayathri/MMS-DM-SCF-0290
						if(!checkForNull(rs.getString("APPLY_FACT_FOR_SRV_LMT_YN")).equals("Y"))
						{
							service_limit_list.add("N");
						}else
							service_limit_list.add(checkForNull(rs.getString("APPLY_FACT_FOR_SRV_LMT_YN")));
							
					
				}
				if(service_code_list.size()>0)
				{
					includedItems_RBD.add(type_list)	;
					includedItems_RBD.add(service_code_list);
					includedItems_RBD.add(service_desc_list)	;
					includedItems_RBD.add(catalog_code_list)	;
					includedItems_RBD.add(catalog_desc_list);
					includedItems_RBD.add(ind_list);
					includedItems_RBD.add(factorOrRate_list);
					includedItems_RBD.add(qty_limit_list);
					includedItems_RBD.add(amt_limit_ind_list);
					includedItems_RBD.add(amt_limit_list);
					includedItems_RBD.add(replace_list);
					includedItems_RBD.add(replaceSrv_code_list);
					includedItems_RBD.add(replaceSrv_desc_list);
					includedItems_RBD.add(replaceSrv_cat_code_list);
					includedItems_RBD.add(replaceSrv_cat_desc_list);
					includedItems_RBD.add(refund_list);
					includedItems_RBD.add(refundAmt_list);
					includedItems_RBD.add(factor_appl_list);
					includedItems_RBD.add(service_limit_list);
					includedItems_RBD.add(auto_refund_list);
					includedItems_RBD.add(roundTo_list);
					includedItems_RBD.add(roundInd_list);
					includedItems_RBD.add(closePkg_list);
					includedItems_RBD.add(utilizedAmt_list);
					includedItems_RBD.add(utilizedQty_list);
					includedItems_RBD.add(refundedYN_list);
					totalRec =	service_code_list.size();

				}
				includedItems_RB.put(packageCode,includedItems_RBD);
				setIncludedItems_RB(includedItems_RB);	
		}
		catch(Exception e)
		{
			System.out.println("Exception from Rate based :"+e);
				e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
		/*  SRVLIMIT_RATE_BASED */	
		ArrayList	srvLimit_type_list			=	null;
		ArrayList	srvLimit_service_code_list  =	null;
		ArrayList	srvLimit_service_desc_list	=	null;
		ArrayList	exludeService_list		    =	null;
		ArrayList	srvLimit_qty_limit_list		=	null;
		ArrayList	srvLimit_amt_limit_list		=	null;
		ArrayList	srvLimit_factor_appl_list	=	null;
		ArrayList excludedItems_RBD =	null;
		HashMap excludedItems_RB    =   new HashMap();
		//HashMap dbExcludedItems_RB    =   new HashMap();//unused variable
		/* Change query for packageSeqNo */
		if(packageSeqNo!=null && !packageSeqNo.equals(""))
			sqlStr="SELECT a.excl_serv_ind excl_serv_ind, a.excl_serv_code excl_serv_code,	b.service_desc service_desc, a.exclude_yn exclude_yn, qty_limit, amt_limit, a.apply_fact_for_srv_lmt_yn factor_appl, amt_limit_ind, replaceable_yn, replaceable_serv_code, refund_yn, refund_rate, rounding_by_integer, rounding_option, auto_refund_yn, utilized_serv_qty, utilized_serv_amt, refund_processed_yn FROM bl_package_sub_excl a, (SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc, language_id FROM bl_blng_serv_lang_vw         UNION ALL SELECT 'C' serv_ind, serv_classification_code code,           short_desc service_desc, language_id FROM bl_serv_classification_lang_vw) b WHERE a.operating_facility_id = ?	AND a.package_code = ? AND a.rate_charge_ind = ? AND a.pkg_serv_code = ? AND a.excl_serv_code = b.code AND a.excl_serv_ind = b.serv_ind	AND b.language_id = ? and a.PACKAGE_SEQ_NO = ?";
		else
		{
			if(customerDefYN.equals("Y"))
			sqlStr="SELECT a.excl_serv_ind excl_serv_ind, a.excl_serv_code excl_serv_code,	b.service_desc service_desc, a.exclude_yn exclude_yn, qty_limit, amt_limit, a.apply_fact_for_srv_lmt_yn factor_appl, amt_limit_ind, replaceable_yn, replaceable_serv_code, (select short_desc from BL_BLNG_SERV_lang_vw where LANGUAGE_ID=? AND blng_serv_code= REPLACEABLE_SERV_CODE) replaceable_serv_desc, refund_yn, refund_rate, rounding_by_integer, rounding_option, auto_refund_yn FROM bl_package_excl_for_cust a, (SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc, language_id FROM bl_blng_serv_lang_vw        UNION ALL SELECT 'C' serv_ind, serv_classification_code code,            short_desc service_desc, language_id FROM bl_serv_classification_lang_vw) b WHERE a.operating_facility_id = ?	AND a.package_code = ? AND a.rate_charge_ind = ? AND a.pkg_serv_code = ? and a.cust_group_code=?    and a.cust_code=? AND a.excl_serv_code = b.code	AND a.excl_serv_ind = b.serv_ind AND b.language_id = ? AND eff_from_date = TO_DATE (?, 'dd/mm/yyyy')";
			else
			sqlStr="SELECT  a.excl_serv_ind excl_serv_ind,a.excl_serv_code excl_serv_code, b.service_desc service_desc,a.exclude_yn exclude_yn, qty_limit, amt_limit,a.apply_fact_for_srv_lmt_yn factor_appl,AMT_LIMIT_IND, REPLACEABLE_YN, REPLACEABLE_SERV_CODE, (select short_desc from BL_BLNG_SERV_lang_vw where LANGUAGE_ID=? AND blng_serv_code= REPLACEABLE_SERV_CODE) replaceable_serv_desc, REFUND_YN, REFUND_RATE, ROUNDING_BY_INTEGER, ROUNDING_OPTION, AUTO_REFUND_YN FROM bl_package_exclusions a, (select 'S' Serv_Ind, blng_serv_code code, short_desc service_desc,language_id from BL_BLNG_SERV_lang_vw  union all  select 'C' serv_ind, serv_classification_code code, short_desc service_desc,language_id from BL_SERV_CLASSIFICATION_lang_vw ) b WHERE a.operating_facility_id = ?    AND a.package_code = ? AND a.rate_charge_ind = ?  and a.pkg_serv_code=? and  a.excl_serv_code=b.code  AND a.excl_serv_ind=b.Serv_Ind   AND b.language_id=? and EFF_FROM_DATE = to_date(?,'dd/mm/yyyy')";
		}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			for(int i=0;i<totalRec; i++)
			{
				srvLimit_type_list			=	new ArrayList();
				srvLimit_service_code_list  =	new ArrayList();
				srvLimit_service_desc_list	=	new ArrayList();
				exludeService_list		    =	new ArrayList();
				srvLimit_qty_limit_list		=	new ArrayList();
				srvLimit_amt_limit_list		=	new ArrayList();
				srvLimit_factor_appl_list	=	new ArrayList();
				amt_limit_ind_list			=	new ArrayList();
				replace_list				=	new ArrayList();
				replaceSrv_code_list		=	new ArrayList();
				refund_list					=	new ArrayList();
				refundAmt_list				=	new ArrayList();
				auto_refund_list			=	new ArrayList();
				roundTo_list				=	new ArrayList();
				roundInd_list				=	new ArrayList();
				replaceSrv_desc_list		=	new ArrayList();
				utilizedAmt_list			=	new ArrayList();
				utilizedQty_list			=	new ArrayList();
				refundedYN_list				=	new ArrayList();
				excludedItems_RBD			=	new ArrayList();
				String	parent_service_code = (String)service_code_list.get(i);
			try
			{
				index = 5;
				pstmt=connection.prepareStatement(sqlStr);
				pstmt.setString(1,language_id);
				pstmt.setString(2,operating_facility_id);
				pstmt.setString(3,packageCode);
				pstmt.setString(4,"R");
				pstmt.setString(5,parent_service_code);
				if(customerDefYN.equals("Y"))
				{
					pstmt.setString(++index,customerGrpFromP);
					pstmt.setString(++index,customerCodeFromP);
				}
				pstmt.setString(++index,language_id);
				if(packageSeqNo!=null && !packageSeqNo.equals(""))
				{
					pstmt.setString(++index,packageSeqNo);
				}
				else
				{
					pstmt.setString(++index,fromDate);
				}

				rs							= pstmt.executeQuery();
				while (rs.next()){
					srvLimit_type_list.add(checkForNull(rs.getString("excl_serv_ind")));
					srvLimit_service_code_list.add(checkForNull(rs.getString("excl_serv_code")));
					srvLimit_service_desc_list.add(checkForNull(rs.getString("service_desc")));
					exludeService_list.add(checkForNull(rs.getString("exclude_yn")));
					srvLimit_qty_limit_list.add(checkForNull(rs.getString("qty_limit")));
					srvLimit_amt_limit_list.add(checkForNull(rs.getString("amt_limit")));				   
					srvLimit_factor_appl_list.add(checkForNull(rs.getString("factor_appl")));				   
					amt_limit_ind_list.add(checkForNull(rs.getString("AMT_LIMIT_IND")));
					replace_list.add(checkForNull(rs.getString("REPLACEABLE_YN")));
					replaceSrv_code_list.add(checkForNull(rs.getString("REPLACEABLE_SERV_CODE")));				   
					replaceSrv_desc_list.add(checkForNull(rs.getString("replaceable_serv_desc")));				   
					refund_list.add(checkForNull(rs.getString("REFUND_YN")));
					refundAmt_list.add(checkForNull(rs.getString("REFUND_RATE")));				   
					auto_refund_list.add(checkForNull(rs.getString("AUTO_REFUND_YN")));				   
					roundTo_list.add(checkForNull(rs.getString("REFUND_RATE")));				   
					roundInd_list.add(checkForNull(rs.getString("ROUNDING_OPTION")));	
					if(packageSeqNo!=null && !packageSeqNo.equals(""))
					{
						utilizedAmt_list.add(checkForNull(rs.getString("utilized_serv_qty")));
						utilizedQty_list.add(checkForNull(rs.getString("utilized_serv_amt")));
						refundedYN_list.add(checkForNull(rs.getString("refund_processed_yn"),"N"));
					}
					else
					{
				  		utilizedAmt_list.add("");
						utilizedQty_list.add("");
						refundedYN_list.add("N");

					}
				}
				if(srvLimit_service_code_list.size()>0)
				{
					excludedItems_RBD.add(srvLimit_type_list)	;
					excludedItems_RBD.add(srvLimit_service_code_list);
					excludedItems_RBD.add(srvLimit_service_desc_list);		
					excludedItems_RBD.add(exludeService_list);
					excludedItems_RBD.add(srvLimit_qty_limit_list);
					excludedItems_RBD.add(srvLimit_amt_limit_list);
					excludedItems_RBD.add(srvLimit_factor_appl_list);
					excludedItems_RBD.add(amt_limit_ind_list);
					excludedItems_RBD.add(replace_list);
					excludedItems_RBD.add(replaceSrv_code_list);
					excludedItems_RBD.add(refund_list);
					excludedItems_RBD.add(refundAmt_list);
					excludedItems_RBD.add(auto_refund_list);
					excludedItems_RBD.add(roundTo_list);
					excludedItems_RBD.add(roundInd_list);
					excludedItems_RBD.add(utilizedAmt_list);
					excludedItems_RBD.add(utilizedQty_list);
					excludedItems_RBD.add(refundedYN_list);
					excludedItems_RBD.add(replaceSrv_desc_list);
					excludedItems_RB.put(parent_service_code,excludedItems_RBD);
					setExcludedItems_RB(excludedItems_RB);
				}					
			}
			catch(Exception e)
			{
				System.out.println("Exception from Rate based service limits :"+e);
					e.printStackTrace();
			}
			finally
			{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			}
		}
		/*  Charge based*/
		try
		{		
				totalRec = 0;
				service_code_list			=	new ArrayList();
				service_desc_list			=	new ArrayList();					
				amt_limit_ind_list			=	new ArrayList();
				amt_limit_list				=	new ArrayList();
				service_limit_list			=	new ArrayList();
				ArrayList	factorApplGroup	=	new ArrayList();
				ArrayList   roundToGroup	=	new ArrayList();
				ArrayList   roundIndGroup	=	new ArrayList();
				refund_list					=	new ArrayList();
				refundAmt_list				=	new ArrayList();	
				auto_refund_list			=	new ArrayList();
				utilizedAmt_list			=	new ArrayList();
				utilizedQty_list			=	new ArrayList();
				refundedYN_list				=	new ArrayList();
				ArrayList includedItems_CBD	=	new ArrayList();
				//HashMap dbIncludedItem_CBD	=	new HashMap();//unused variable
				//HashMap dbIncludedItems_CB	=  new HashMap();//unused variable
				HashMap includedItems_CB	=  new HashMap();
			//	HashMap includedItemsFD_CB	=  new HashMap();//unused variable
				/* Change query for packageSeqNo */

				if(packageSeqNo!=null && !packageSeqNo.equals(""))
					sqlStr="SELECT refund_yn, refund_rate, auto_refund_yn, rounding_by_integer, rounding_option, pkg_serv_code, b.short_desc service_desc, amt_limit_ind, amt_limit, amt_limit_ind, apply_fact_for_srv_lmt_yn,utilized_serv_qty,utilized_serv_amt, refund_processed_yn, (SELECT 'Y' FROM bl_package_sub_excl        WHERE operating_facility_id = a.operating_facility_id            AND package_code = a.package_code AND pkg_serv_code = a.pkg_serv_code	AND ROWNUM = 1) service_limit FROM bl_package_sub_dtls a, bl_blng_serv_lang_vw b WHERE a.operating_facility_id = ?	AND a.package_code = ? AND a.rate_charge_ind = ? AND a.pkg_serv_code = b.blng_serv_code    AND b.language_id = ? AND a.PACKAGE_SEQ_NO = ?"
					+" union " +
					" SELECT refund_yn, refund_rate, auto_refund_yn, rounding_by_integer, rounding_option, pkg_serv_code, b.short_desc service_desc, amt_limit_ind, amt_limit, amt_limit_ind, apply_fact_for_srv_lmt_yn,utilized_serv_qty,utilized_serv_amt, refund_processed_yn, (SELECT 'Y' FROM bl_package_sub_excl        WHERE operating_facility_id = a.operating_facility_id            AND package_code = a.package_code AND pkg_serv_code = a.pkg_serv_code	AND ROWNUM = 1) service_limit FROM bl_package_sub_dtls a, MM_ITEM_LANG_VW b WHERE a.operating_facility_id = ?	AND a.package_code = ? AND a.rate_charge_ind = ? AND a.pkg_serv_code = b.item_code    AND b.language_id = ? AND a.PACKAGE_SEQ_NO = ? ";
							
				else
				{
					if(customerDefYN.equals("Y"))
					sqlStr="SELECT refund_yn, refund_rate, auto_refund_yn, rounding_by_integer, rounding_option, pkg_serv_code, b.short_desc service_desc, amt_limit_ind, amt_limit, amt_limit_ind, apply_fact_for_srv_lmt_yn, (SELECT 'Y' FROM bl_package_excl_for_cust WHERE operating_facility_id = a.operating_facility_id	AND package_code = a.package_code        AND pkg_serv_code = a.pkg_serv_code	and cust_group_code=a.cust_group_code and cust_code=a.cust_code	     AND ROWNUM = 1) service_limit FROM bl_package_coverage_for_cust a, bl_blng_serv_lang_vw b WHERE a.operating_facility_id = ?	   AND a.package_code = ? AND a.rate_charge_ind = ? and a.cust_group_code=?	and a.cust_code=? AND a.pkg_serv_code = b.blng_serv_code AND b.language_id = ? AND eff_from_date = TO_DATE (?, 'dd/mm/yyyy') ";
					else
					sqlStr="SELECT REFUND_YN, REFUND_RATE, AUTO_REFUND_YN,ROUNDING_BY_INTEGER, ROUNDING_OPTION,pkg_serv_code, b.short_desc service_desc, AMT_LIMIT_IND, amt_limit,AMT_LIMIT_IND,APPLY_FACT_FOR_SRV_LMT_YN, (SELECT 'Y'  FROM bl_package_exclusions WHERE operating_facility_id = a.operating_facility_id AND package_code = a.package_code  AND pkg_serv_code = a.pkg_serv_code  AND ROWNUM = 1) service_limit FROM bl_package_dtls a, bl_blng_serv_lang_vw b WHERE a.operating_facility_id = ?  AND a.package_code = ?  AND a.rate_charge_ind = ?   AND a.pkg_serv_code =b.blng_serv_code AND b.language_id = ? and EFF_FROM_DATE = to_date(?,'dd/mm/yyyy')";
				}
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				index = 3;
				pstmt=connection.prepareStatement(sqlStr);
				pstmt.setString(1,operating_facility_id);
				pstmt.setString(2,packageCode);
				pstmt.setString(3,"C");
				if(customerDefYN.equals("Y"))
				{
					pstmt.setString(++index,customerGrpFromP);
					pstmt.setString(++index,customerCodeFromP);
				}
				pstmt.setString(++index,language_id);
				if(packageSeqNo!=null && !packageSeqNo.equals(""))
					pstmt.setString(++index,packageSeqNo);
				else
					pstmt.setString(++index,fromDate);

				
				if(packageSeqNo!=null && !packageSeqNo.equals("")){
					pstmt.setString(6,operating_facility_id);
					pstmt.setString(7,packageCode);
					pstmt.setString(8,"C");
					pstmt.setString(9,language_id);
					pstmt.setString(10,packageSeqNo);
				}
				
				rs							= pstmt.executeQuery();
				while (rs.next()){

					service_code_list.add(checkForNull(rs.getString("pkg_serv_code")));
					service_desc_list.add(checkForNull(rs.getString("service_desc")));
					amt_limit_ind_list.add(checkForNull(rs.getString("AMT_LIMIT_IND")));
					amt_limit_list.add(checkForNull(rs.getString("amt_limit")));
					factorApplGroup.add(checkForNull(rs.getString("APPLY_FACT_FOR_SRV_LMT_YN"),"N"));
					roundToGroup.add(checkForNull(rs.getString("ROUNDING_BY_INTEGER")));
					roundIndGroup.add(checkForNull(rs.getString("ROUNDING_OPTION")));
					refund_list.add(checkForNull(rs.getString("REFUND_YN")));
					refundAmt_list.add(checkForNull(rs.getString("REFUND_RATE")));
					auto_refund_list.add(checkForNull(rs.getString("AUTO_REFUND_YN")));
					if(packageSeqNo!=null && !packageSeqNo.equals(""))
					{	
						utilizedAmt_list.add(checkForNull(rs.getString("utilized_serv_qty")));
						utilizedQty_list.add(checkForNull(rs.getString("utilized_serv_amt")));
						refundedYN_list.add(checkForNull(rs.getString("refund_processed_yn"),"N"));
					}
					else
					{
						utilizedAmt_list.add("");
						utilizedQty_list.add("");
						refundedYN_list.add("N");
					}

					if(!(checkForNull(rs.getString("service_limit")).equals("Y"))){
						service_limit_list.add("N");
					}else
						service_limit_list.add(checkForNull(rs.getString("service_limit")));
				}
				if(service_code_list.size()>0)
				{
					includedItems_CBD.add(service_code_list);
					includedItems_CBD.add(service_desc_list)	;					
					includedItems_CBD.add(amt_limit_ind_list);
					includedItems_CBD.add(amt_limit_list);
					includedItems_CBD.add(service_limit_list);
					includedItems_CBD.add(factorApplGroup);
					includedItems_CBD.add(roundToGroup);
					includedItems_CBD.add(roundIndGroup);
					includedItems_CBD.add(refund_list);
					includedItems_CBD.add(refundAmt_list);
					includedItems_CBD.add(auto_refund_list);
					includedItems_CBD.add(utilizedAmt_list);
					includedItems_CBD.add(utilizedQty_list);
					includedItems_CBD.add(refundedYN_list);
					includedItems_CB.put(packageCode,includedItems_CBD);
					setIncludedItems_CB(includedItems_CB);
					totalRec = service_code_list.size();
				}
			}
			catch(Exception  e)
			{
				System.out.println("Exception from charge based :"+e);
					e.printStackTrace();
			}
			finally
			{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			}
			/* ---------------Charge based exclusions---------- */	
			ArrayList item_code_list    =	null;
			ArrayList item_desc_list	=	null;					
			qty_limit_list				=	null;
			amt_limit_list				=	null;
			ArrayList inclExclFlag_list =	null;				
			ArrayList excludedItems_CBD =	null;
			HashMap excludedItems_CB    =   new HashMap();	
			for(int i=0;i<totalRec; i++)
			{
				String	parent_service_code = (String)service_code_list.get(i);
				try
				{
					item_code_list    =	new ArrayList();
					item_desc_list	  =	new ArrayList();
					qty_limit_list    =	new ArrayList();
					amt_limit_list    =	new ArrayList();
					inclExclFlag_list =	new ArrayList();
					excludedItems_CBD =	new ArrayList();
					if(packageSeqNo!=null && !packageSeqNo.equals(""))
						sqlStr="SELECT a.excl_serv_code excl_serv_code, b.short_desc service_desc, qty_limit, amt_limit, a.exclude_yn exclude_yn, utilized_serv_qty,utilized_serv_amt, refund_processed_yn   FROM bl_package_sub_excl a, mm_item_lang_vw b WHERE a.operating_facility_id = ?	AND a.package_code = ? AND a.rate_charge_ind = ? AND a.pkg_serv_code = ? AND a.excl_serv_code = b.item_code AND b.language_id = ? and 	a.PACKAGE_SEQ_NO =?";
					else
					{
						if(customerDefYN.equals("Y"))
						sqlStr="SELECT a.excl_serv_code excl_serv_code, b.short_desc service_desc, qty_limit, amt_limit, a.exclude_yn exclude_yn	FROM bl_package_excl_for_cust a, mm_item_lang_vw b WHERE a.operating_facility_id = ?	AND a.package_code = ? AND a.rate_charge_ind = ? AND a.pkg_serv_code = ? and a.cust_group_code=?	and a.cust_code=? AND a.excl_serv_code = b.item_code	AND b.language_id = ? AND eff_from_date = TO_DATE (?, 'dd/mm/yyyy') ";
						else
						sqlStr="SELECT a.excl_serv_code excl_serv_code, b.short_desc service_desc,qty_limit, amt_limit, a.exclude_yn exclude_yn  FROM bl_package_exclusions a, mm_item_lang_vw b WHERE a.operating_facility_id = ?   AND a.package_code =? AND a.rate_charge_ind =?  AND a.pkg_serv_code=? AND a.excl_serv_code = b.item_code AND b.language_id = ? and EFF_FROM_DATE = to_date(?,'dd/mm/yyyy')";
					}
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					index = 4;
					pstmt=connection.prepareStatement(sqlStr);				
					pstmt.setString(1,operating_facility_id);
					pstmt.setString(2,packageCode);
					pstmt.setString(3,"C");
					pstmt.setString(4,parent_service_code);
					if(customerDefYN.equals("Y"))
					{
						pstmt.setString(++index,customerGrpFromP);
						pstmt.setString(++index,customerCodeFromP);
				}
					pstmt.setString(++index,language_id);
					if(packageSeqNo!=null && !packageSeqNo.equals(""))
					{
						pstmt.setString(++index,packageSeqNo);
					}
					else
					{
						pstmt.setString(++index,fromDate);
					}


					rs							= pstmt.executeQuery();
					while (rs.next()){
						item_code_list.add(checkForNull(rs.getString("excl_serv_code")));
						item_desc_list.add(checkForNull(rs.getString("service_desc")));				   
						qty_limit_list.add(checkForNull(rs.getString("qty_limit")));
						amt_limit_list.add(checkForNull(rs.getString("amt_limit")));	
						inclExclFlag_list.add(checkForNull(rs.getString("exclude_yn")));				   
					}
					if(item_code_list.size()>0)
					{
						excludedItems_CBD.add(item_code_list);
						excludedItems_CBD.add(item_desc_list);					
						excludedItems_CBD.add(qty_limit_list);
						excludedItems_CBD.add(amt_limit_list);
						excludedItems_CBD.add(inclExclFlag_list);
						excludedItems_CB.put(parent_service_code,excludedItems_CBD);
						setExcludedItems_CB(excludedItems_CB);
					}	
				}
				catch(Exception    e)
				{	
					System.out.println("Exception from charge based limits :"+"i="+i+"   "+e);
						e.printStackTrace();
				}
				finally
				{
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
				}
			}
		}
		catch(Exception    e)
		{	
			System.out.println("Exception from Enquirey bean main :"+e);
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(cstmt!=null) closeStatement(cstmt);
			if(connection!=null) ConnectionManager.returnConnection(connection);
			
		}
	}
	public String getNoOfDecimal() throws Exception
	{
		Connection connection 		= getConnection();	
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;	
		String noofdecimal = "";
		try
		{
			String sql = "select nvl(no_of_decimal,2) noofdecimal from  sm_acc_entity_param";
			pstmt=connection.prepareStatement(sql);	
			rs = pstmt.executeQuery();
			if (rs.next())
				noofdecimal = rs.getString("noofdecimal");
		}
		catch(Exception e)
		{
			System.out.println("Exception from getNoOfDecimal :"+e);
				e.printStackTrace();
			
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
		}
		return noofdecimal ;

	}

	public String getSysDate() throws Exception
	{
		Connection connection 		= getConnection();	
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;	
		String sysDate = "";
		try
		{
			String sql = "select to_char(sysdate,'dd/mm/yyyy') syDate from dual";
			pstmt=connection.prepareStatement(sql);	
			rs = pstmt.executeQuery();
			if (rs.next())
				sysDate = rs.getString("syDate");
		}
		catch(Exception e)
		{
			System.out.println("Exception from getSysDate :"+e);
				e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
		}
		return sysDate ;

	}



}


