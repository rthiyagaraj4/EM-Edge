/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V201125             8504        KDAH-SCF-0681          Ram Kumar S/MuthuN
2            V201125             8942        AMS-SCF-0924           Ram Kumar S/MuthuN
3			 V211130			26231		KDAH-SCF-0744-TF		Mohanapriya K
---------------------------------------------------------------------------------------
*/

package eBL;
import java.io.*;
import java.util.*;
import java.sql.*;
import eBL.Common.*;
import webbeans.eCommon.*;
import eCommon.Common.CommonAdapter;
import java.text.*;

public class PkgDefBean extends BlAdapter implements Serializable
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
	protected String deletedStatusRB		= "N";
	protected String deletedStatusCB		= "N";
	protected String deletedStatusRBLt  	= "N";
	protected String deletedStatusCBLt		= "N";
	protected String newDate="";                    //Newly Added By Vijay For GHL-SCF-1086
	protected String newDateAddedFlag="";			//Newly Added By Vijay For GHL-SCF	
	protected String isMasterPkgYn="";	//Added V190325 Gayathri/KDAH-CRF-0503/Starts
			
	/*
	protected ArrayList blgClsCode		    = new ArrayList();
	protected ArrayList blgClsDesc	        = new ArrayList();
	protected ArrayList priceFromDate	    = new ArrayList();
	protected ArrayList priceToDate			= new ArrayList();
	protected ArrayList indicator			= new ArrayList();
	protected ArrayList price				= new ArrayList();
	protected ArrayList factorAppl			= new ArrayList();
	protected ArrayList flag				= new ArrayList();
	protected ArrayList statusToModify		= new ArrayList();
	 */

	public String getNewDateAddedFlag() {
		return newDateAddedFlag;
	}

	public void setNewDateAddedFlag(String newDateAddedFlag) {
		this.newDateAddedFlag = newDateAddedFlag;
	}

	public String getNewDate() {
		return newDate;
	}

	public void setNewDate(String newDate) {
		this.newDate = newDate;
	}

	/******* Customer spefic ******* start ******/
	protected HashMap custSpecific	= new HashMap();
	/******* Customer spefic******* end ******/
	
	/******* base Dates&Price******* start ******/
	protected HashMap baseDates		= new HashMap();
	protected HashMap basePrice		= new HashMap();
	/******* base Dates&Price******* end ******/
	
	protected HashMap existingPkgBaseDates		= new HashMap();
	//Added V190325 Gayathri/KDAH-CRF-0503/Starts
	protected HashMap childPackages		= new HashMap();
	protected HashMap childPackdtl		= new HashMap();
		
	public HashMap getChildPackdtl() {
		return childPackdtl;
	}

	public void setChildPackdtl(HashMap childPackdtl) {
		this.childPackdtl = childPackdtl;
	}

	public HashMap getChildPackages() {
		return childPackages;
	}

	public void setChildPackages(HashMap childPackages) {
		this.childPackages = childPackages;
	}	

	public HashMap getExistingPkgBaseDates() {
		return existingPkgBaseDates;
	}

	public void setExistingPkgBaseDates(HashMap existingPkgBaseDates) {
		this.existingPkgBaseDates = existingPkgBaseDates;
	}	

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
	protected String modifyChargeBased		= "N";
	protected String modifyChargeItems		= "N";
	protected String modifyCustomer			= "N";
	protected String modifyBillingGroup		= "N"; //Added By Shikha For GHL-CRF-0520.1
	/****these flags are to  check if the user clicked a perticular tab**end***/
	/****key values in the database,used later for delete option**start***/
	protected HashMap dbIncludedItems_CB		= new HashMap();
	protected HashMap dbExcludedItems_CB	= new HashMap();
	protected HashMap dbIncludedItems_RB		= new HashMap();
	protected HashMap dbExcludedItems_RB		= new HashMap();
	protected HashMap dbIncludedItems_cust	= new HashMap();
	protected HashMap dbIncludedItems_blngGrp	= new HashMap(); //Added By Shikha For GHL-CRF-0520.1
/****key values in the database,used later for delete option**end***/
	
	/******* BillingGroup values******* start ******/
	protected HashMap includedItems_blngGrp		= new HashMap();	//Added By Shikha For GHL-CRF-0520.1
	/******* BillingGroup values******* end ******/
	
	public PkgDefBean()
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
	
	public void  setDeletedStatusRB(String  deletedStatusRB)
	{ 
		this.deletedStatusRB = checkForNull(deletedStatusRB,"N");
	}
	public void  setDeletedStatusCB(String  deletedStatusCB)
	{ 
		this.deletedStatusCB = checkForNull(deletedStatusCB,"N");
	}
	public String  getDeletedStatusRB()
	{ 
		return this.deletedStatusRB;
	}
	public String  getDeletedStatusCB()
	{ 
		return this.deletedStatusCB;
	}

	public void  setDeletedStatusRBLt(String  deletedStatusRBLt)
	{ 
		this.deletedStatusRBLt = checkForNull(deletedStatusRBLt,"N");
	}
	public void  setDeletedStatusCBLt(String  deletedStatusCBLt)
	{ 
		this.deletedStatusCBLt = checkForNull(deletedStatusCBLt,"N");
	}
	public String  getDeletedStatusRBLt()
	{ 
		return this.deletedStatusRBLt;
	}
	public String  getDeletedStatusCBLt()
	{ 
		return this.deletedStatusCBLt;
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
	//Added V190325 Gayathri/KDAH-CRF-0503/Starts
	public void  setIsMasterPkgYn(String  isMasterPkgYn)
	{ 
		this.isMasterPkgYn = checkForNull(isMasterPkgYn,"");
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

	/* Methods for base dates*/
	public void  setBaseDates(HashMap  baseDates)
	{ 
		this.baseDates = baseDates;
	}

	public HashMap getBaseDates(){
		return this.baseDates;
	}
	 /* Methods for base dates -- end */

	/* Methods for base Price -- start*/
	public void  setBasePrice(HashMap  basePrice)
	{ 
		this.basePrice = basePrice;
	}

	public HashMap getBasePrice(){
		return this.basePrice;
	}

	/* Methods for base Price -- end */

	/*  Methods for Customer Specific ---start */

	public void  setCustSpecific(HashMap  custSpecific)
	{ 
		this.custSpecific = custSpecific;
	}

	public HashMap getCustSpecific(){
		return this.custSpecific;
	}
	/* Methods for Customer Specific -- end */
	
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
	//Added By Shikha For GHL-CRF-0520.1
	public void setModifyBillingGroup(String flag){
		this.modifyBillingGroup=flag;
	}
	public String getModifyBillingGroup(){
		return this.modifyBillingGroup;
	}
	//Added By Shikha For GHL-CRF-0520.1
	public void  setDbIncludedItems_CB(HashMap  dbIncludedItems_CB)
	{ 
		this.dbIncludedItems_CB = dbIncludedItems_CB;
	}
	public HashMap  getDbIncludedItems_CB()
	{ 
		return this.dbIncludedItems_CB;
	}
	public void  setDbExcludedItems_CB(HashMap dbExcludedItems_CB)
	{ 
		this.dbExcludedItems_CB=dbExcludedItems_CB;
	}
	public HashMap  getDbExcludedItems_CB()
	{ 
		return this.dbExcludedItems_CB;
	}
	public void  setDbIncludedItems_RB(HashMap  dbIncludedItems_RB)
	{ 
		this.dbIncludedItems_RB = dbIncludedItems_RB;
	}
	public HashMap  getDbIncludedItems_RB()
	{ 
		return this.dbIncludedItems_RB;
	}
	public void  setDbExcludedItems_RB(HashMap  dbExcludedItems_RB)
	{ 
		this.dbExcludedItems_RB = dbExcludedItems_RB;
	}
	public HashMap  getDbExcludedItems_RB()
	{ 
		return this.dbExcludedItems_RB;
	}
	public void  setDbIncludedItems_cust(HashMap  dbIncludedItems_cust)
	{ 
		this.dbIncludedItems_cust = dbIncludedItems_cust;
	}
	public HashMap  getDbIncludedItems_cust()
	{ 
		return this.dbIncludedItems_cust;
	}
	//Added By Shikha For GHL-CRF-0520.1
	public void  setDbIncludedItems_blngGrp(HashMap  dbIncludedItems_blngGrp)
	{ 
		this.dbIncludedItems_blngGrp = dbIncludedItems_blngGrp;
	}
	public HashMap  getDbIncludedItems_blngGrp()
	{ 
		return this.dbIncludedItems_blngGrp;
	}
	//Ended By Shikha For GHL-CRF-0520.1
	/*Set Methods for Base Price 
	public void  setBlgClsCode(ArrayList  blgClsCode)
	{ 
		this.blgClsCode = blgClsCode;
	}
	
	public void  setBlgClsDesc(ArrayList  blgClsDesc)
	{ 
		this.blgClsDesc = blgClsDesc;
	}

	public void  setPriceFromDate(ArrayList  priceFromDate)
	{ 
		this.priceFromDate = priceFromDate;
	}
	
	public void  setPriceToDate(ArrayList  priceToDate)
	{ 
		this.priceToDate = priceToDate;
	}

	public void  setIndicator(ArrayList  indicator)
	{ 
		this.indicator = indicator;
	}

	public void  setPrice(ArrayList  price)
	{ 
		this.price = price;
	}

	public void  setFactorAppl(ArrayList  factorAppl)
	{ 
		this.factorAppl = factorAppl;
	}

	public void  setFlag(ArrayList  flag)
	{ 
		this.flag = flag;
	}

	public void  setStatusToModify(ArrayList  statusToModify)
	{ 
		this.statusToModify = statusToModify;
	}
	public void  setLatestDate(HashMap  latestDate)
	{ 
		this.latestDate = latestDate;
	}

	End Set Methods for Base Price */

	public void  setExcludedItems_CB(HashMap  excludedItems_CB)
	{ 
		this.excludedItems_CB = excludedItems_CB;
	}
	public void  setIncludedItems_CB(HashMap  includedItems_CB)
	{ 
		this.includedItems_CB = includedItems_CB;
	}

	/*
	public void  setIncludSrvicesDB_CB(HashMap includSrvicesDB_CB)
	{ 
		this.includSrvicesDB_CB = includSrvicesDB_CB;
	}
	
	public void  setExcludSrvicesDB_CB(HashMap excludSrvicesDB_CB)
	{ 
		this.excludSrvicesDB_CB = excludSrvicesDB_CB;
	}
	*/
	public void  setmodifiedExclns_CB(HashMap  excludedItems_CB)
	{ 
		//this.includedItems_CB = includedItems_CB;
	}

	public String getPackageCode()
	{ 
		return this.packageCode ; 
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

	public String getApprovedYN()
	{
		return this.approvedYN;
	}
	
	public String getApprovedBy(){
		return this.approvedBy;
	}
	public String getApprovedDate(){
		return this.approvedDate;
	}

	/*get Methods for Base Price 
		
	public ArrayList getBlgClsCode()
	{ 
		return this.blgClsCode ; 
	}
	public ArrayList getBlgClsDesc()
	{ 
		return this.blgClsDesc ; 
	}

	public ArrayList getPriceFromDate()
	{ 
		return this.priceFromDate ; 
	}
	public ArrayList getPriceToDate()
	{ 
		return this.priceToDate ; 
	}
	public ArrayList getIndicator()
	{ 
		return this.indicator ; 
	}
	public ArrayList getPrice()
	{ 
		return this.price ; 
	}
	public ArrayList getFactorAppl()
	{ 
		return this.factorAppl ; 
	}
	public ArrayList getFlag()
	{ 
		return this.flag ; 
	}
	public ArrayList getStatusToModify()
	{ 
		return this.statusToModify ; 
	}

	public HashMap getLatestDate()
	{ 
		return this.latestDate ; 
	}

	end get Methods for Base Price */


	public HashMap getExcludedItems_CB()
	{ 
		return this.excludedItems_CB ; 
	}
	public HashMap getIncludedItems_CB()
	{ 
		return this.includedItems_CB ; 
	}
	//Added V190325 Gayathri/KDAH-CRF-0503/Starts
	public String getIsMasterPkgYn()
	{ 
		return this.isMasterPkgYn ; 
	}
	/*
	public HashMap getIncludSrvicesDB_CB()
	{ 
		return this.includSrvicesDB_CB ; 
	}
	public HashMap getExcludSrvicesDB_CB()
	{ 
		return this.excludSrvicesDB_CB ; 
	}  */


	/*public void  setPackageCode(String packageCode)
		this.packageCode = packageCode; 	

	public void  setPriceFromDate(ArrayList priceFromDate)
		this.priceFromDate	=	priceFromDate  ;

	public void  setPriceToDate(ArrayList priceToDate)
		this. priceToDate	=	priceToDate; 

	public ArrayList getPriceFromDate() 
		return this.priceFromDate ;
	public ArrayList getPriceToDate()
		return this.priceToDate;  */ 

	public void clearBean()
	{
		packageCode		 =	"";
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
		deletedStatusRB	 = "N";
		deletedStatusCB	 = "N";
		deletedStatusRBLt= "N";
		deletedStatusCBLt= "N";
		isMasterPkgYn="N";//Added V190325 Gayathri/KDAH-CRF-0503

		if(baseDates != null)
			baseDates.clear();
		if(childPackages != null)
			childPackages.clear();
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
		
		if(includedItems_blngGrp != null)	 //Added By Shikha For GHL-CRF-0520.1
			includedItems_blngGrp.clear();
				
		if(dbIncludedItems_CB != null)	
			dbIncludedItems_CB.clear();
		if(dbExcludedItems_CB != null)	
			dbExcludedItems_CB.clear();

		if(dbExcludedItems_RB != null)	
			dbExcludedItems_RB.clear();

		if(dbIncludedItems_RB != null)	
			dbIncludedItems_RB.clear();
			
		if(dbIncludedItems_cust != null)	
		dbIncludedItems_cust.clear();	
		
		if(includedItems_blngGrp != null)	  //Added By Shikha For GHL-CRF-0520.1
			includedItems_blngGrp.clear();	
		
		if(existingPkgBaseDates != null){
			existingPkgBaseDates.clear();
		}
		 modifyRateBased			= "N";
		modifyRateSrvLimits		= "N";
		modifyChargeBased			= "N";
		modifyChargeItems			= "N";
		modifyCustomer			= "N";
		modifyBillingGroup			= "N"; //Added By Shikha For GHL-CRF-0520.1

	}
	/******** rate Based values*********start**** /
/*	public void setRbSrvLimit(HashMap rbSrvLimit){
		this.rbSrvLimit=rbSrvLimit;
	}
	
	public HashMap getRbSrvLimit(){
		return (HashMap)this.rbSrvLimit;
	}
	
	public void addRbSrvLimitVal(String service_code,ArrayList values){
		this.rbSrvLimit.put(service_code,values);
	}
	
	public ArrayList getRbSrvLimitVal(String service_code){
		return (ArrayList)this.rbSrvLimit.get(service_code);
	}
	
	public void clearRbSrvLimit(){
		this.rbSrvLimit.clear();
	}
	
	public void setRbService(HashMap rbService){
		this.rbService=rbService;
	}
	
	public HashMap getRbService(){
		return (HashMap)this.rbService;
	}
	
	public void addRbServiceVal(String service_code,HashMap values){
		this.rbService.put(service_code,values);
	}
	
	public HashMap getRbServiceVal(String service_code){
		return (HashMap)this.rbService.get(service_code);
	}
	
	public void clearRbService(){
		this.rbService.clear();
	}*/
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
	
	//Added By Shikha For GHL-CRF-0520.1
	public void  setIncludedItems_blngGrp(HashMap  includedItems_blngGrp)
	{ 
		this.includedItems_blngGrp = includedItems_blngGrp;
	}
	
	public HashMap getIncludedItems_blngGrp()
	{ 
		return this.includedItems_blngGrp; 
	}
	//Ended By Shikha For GHL-CRF-0520.1
	
public void setDBValues(String tab,String packageCode,String language_id,String operating_facility_id, String parent_service_code,String copyFrm_pkgCode,String fromDate) throws Exception {
		Connection connection 		= null;		
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;		
		String sqlStr="";
		String dateFormat = "dd/MM/yyyy HH:mm:ss";
	    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Calendar c = Calendar.getInstance(); {			
			connection = getConnection();
			if(tab.equals("PACKAGE_MAIN"))
			{
			//Added one parameter V190325 Gayathri/KDAH-CRF-0503
				sqlStr ="select SHORT_DESC, LONG_DESC, TO_CHAR(EFF_FROM_DATE,'DD/MM/YYYY') EFF_FROM_DATE, TO_CHAR(EFF_TO_DATE,'DD/MM/YYYY') EFF_TO_DATE, APPL_SEX_IND, MIN_AGE_IN_YRS, MIN_AGE_IN_MTHS, MIN_AGE_IN_DAYS, MAX_AGE_IN_YRS, MAX_AGE_IN_MTHS, MAX_AGE_IN_DAYS, OP_YN, EM_YN, IP_YN, DC_YN, STATUS, PKG_VALID_DAYS, ORDER_CATALOG_YN, ACROSS_ENCOUNTER_YN, FOR_CASH_OR_CREDIT,APPROVED_YN, APPROVED_BY,TO_CHAR(APPROVED_DATE,'DD/MM/YYYY') APPROVED_DATE,IS_MASTER_PKG_YN from BL_PACKAGE where PACKAGE_CODE=? and OPERATING_FACILITY_ID = ?";
				try
				{
					pstmt=connection.prepareStatement(sqlStr);	
					pstmt.setString(1,packageCode);
					pstmt.setString(2,operating_facility_id);
					rs = pstmt.executeQuery();
					while (rs.next())
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
			//System.out.println("ORDER_CATALOG_YN in DefBean.java ==> "+rs.getString("ORDER_CATALOG_YN"));
						setAcrossEncounters(checkForNull(rs.getString("ACROSS_ENCOUNTER_YN"),"N"));
			//System.out.println("ORDER_CATALOG_YN in DefBean.java ==> "+rs.getString("ACROSS_ENCOUNTER_YN"));
						setApplicalbleTo(checkForNull(rs.getString("FOR_CASH_OR_CREDIT")));
						setAuto(checkForNull(rs.getString("ORDER_CATALOG_YN"),"N"));
						setValidDays(checkForNull(rs.getString("PKG_VALID_DAYS")));
						setApprovedYN(checkForNull(rs.getString("APPROVED_YN"),"N"));
						setApprovedBy(checkForNull(rs.getString("APPROVED_BY"))); //sarathkumar Uncommented to display value in screen
						//setApprovedDate(checkForNull(rs.getString("APPROVED_DATE")));	
						setApprovedDate(checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("APPROVED_DATE"),"DMY","en",language_id)));  //Sarath SKR-SCF-0744 added to display thai date						System.out.println("APPROVED_DATE convert :"+(com.ehis.util.DateUtils.convertDate(rs.getString("APPROVED_DATE"),"DMY","en",language_id)));
						setIsMasterPkgYn(checkForNull(rs.getString("IS_MASTER_PKG_YN"))); //Added V190325 Gayathri/KDAH-CRF-0503
					}
				}
				catch(Exception e)
				{
					System.out.println("Exception from Package MAin :"+e);
					e.printStackTrace();
				}

			}
			else if(tab.equals("PACKAGE_DATE"))
			{
			
				//sqlStr ="select TO_CHAR(EFF_FROM_DATE,'DD/MM/YYYY') EFF_FROM_DATE, TO_CHAR(EFF_TO_DATE,'DD/MM/YYYY') EFF_TO_DATE, PKG_PRICE_CLASS_CODE, OUTSIDE_PKG_PRICE_CLASS_CODE,GL_POST_AC_FOR_PKG from BL_PACKAGE_PERIOD where PACKAGE_CODE=? and OPERATING_FACILITY_ID = ?";
				//sqlStr ="select TO_CHAR(A.EFF_FROM_DATE,'DD/MM/YYYY') EFF_FROM_DATE, TO_CHAR(A.EFF_TO_DATE,'DD/MM/YYYY') EFF_TO_DATE, A.PKG_PRICE_CLASS_CODE PKG_PRICE_CLASS_CODE, A.OUTSIDE_PKG_PRICE_CLASS_CODE OUTSIDE_PKG_PRICE_CLASS_CODE,A.GL_POST_AC_FOR_PKG GL_POST_AC_FOR_PKG,(select ACC_INT_DESC from BL_GL_ACCOUNT_LANG_VW where ACC_INT_CODE=A.GL_POST_AC_FOR_PKG and language_id=? and acc_entity_code=?) ACC_INT_DESC from BL_PACKAGE_PERIOD A where A.PACKAGE_CODE =? and A.OPERATING_FACILITY_ID = ?";
				//Modified Query V180122-Gayathri/MMS-DM-CRF-0118
				sqlStr ="SELECT TO_CHAR (a.eff_from_date, 'DD/MM/YYYY') eff_from_date,TO_CHAR (a.eff_to_date, 'DD/MM/YYYY') eff_to_date, a.pkg_price_class_code pkg_price_class_code,a.outside_pkg_price_class_code outside_pkg_price_class_code,a.gl_post_ac_for_pkg gl_post_ac_for_pkg,(SELECT acc_int_desc FROM bl_gl_account_lang_vw WHERE acc_int_code = a.gl_post_ac_for_pkg AND language_id = ?  AND acc_entity_code =  (SELECT acc_entity_code  FROM sy_acc_entity b  WHERE b.acc_entity_id =?)) ACC_INT_DESC,GL_POST_AC_FOR_DISC GL_POST_AC_FOR_DISC,(SELECT acc_int_desc FROM bl_gl_account_lang_vw WHERE acc_int_code = a.gl_post_ac_for_disc AND language_id = ?  AND acc_entity_code =  (SELECT acc_entity_code  FROM sy_acc_entity b  WHERE b.acc_entity_id =?)) ACC_INT_DISC_DESC, ADDL_CHG_APPLICABLE_YN ADDL_CHG_APPLICABLE_YN, ADDL_CHG_RULE_CODE ADDL_CHG_RULE_CODE FROM bl_package_period a WHERE a.package_code = ? AND a.operating_facility_id = ? ORDER BY a.eff_from_date ";
				System.out.println("priceClsDesc from func:"+sqlStr);
				try
				{
					if(rs!=null) rs=null;
					if(pstmt!=null) pstmt=null;
					//System.out.println("sqlStr:"+sqlStr);
					pstmt=connection.prepareStatement(sqlStr);	
					pstmt.setString(1,language_id);
					pstmt.setString(2,operating_facility_id);
					pstmt.setString(3,language_id);
					pstmt.setString(4,operating_facility_id);
					pstmt.setString(5,packageCode);
					pstmt.setString(6,operating_facility_id);
					rs = pstmt.executeQuery();
					String 	priceClsCode ="";
					String 	priceClsDesc ="";
					String 	outPriceClsCode ="";
					String 	outPriceClsDesc ="";
					String 	glSmry ="";
					String 	glSmryDesc ="";
					String 	glSmryDisc ="";
					String 	glSmryDiscDesc ="";		
				//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts
					String 	VATapplicable ="";	
					String 	VATapplicable_old ="";	
					String 	VATpercentage ="";		
				//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends
					ArrayList dtlsArray	     =	new ArrayList();
					ArrayList priceFromDate  =	new ArrayList();
					ArrayList priceToDate	 =	new ArrayList();
					ArrayList pkgPClsCode	 =	new ArrayList();
					ArrayList pkgPClsDesc	 =	new ArrayList();
					ArrayList oPkgPClsCode	 =	new ArrayList();
					ArrayList oPkgPClsDesc	 =	new ArrayList();
					ArrayList glSmryList	 =	new ArrayList();
					ArrayList glSmryDescList =	new ArrayList();
					ArrayList glSmryDiscList	 =	new ArrayList();
					ArrayList glSmryDiscDescList =	new ArrayList();
					ArrayList flag	         =	new ArrayList();
					//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts
					ArrayList VATappList	 =	new ArrayList();
					ArrayList VATappList_old	 =	new ArrayList();
					ArrayList VATpercentList	 =	new ArrayList();
					//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends
					//ArrayList statusToModify =  new ArrayList();
					while (rs.next())
					{ 
						priceFromDate.add((checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("EFF_FROM_DATE"),"DMY","en",language_id))));
						priceToDate.add((checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("EFF_TO_DATE"),"DMY","en",language_id))));
						priceClsCode = (checkForNull(rs.getString("PKG_PRICE_CLASS_CODE")));
						pkgPClsCode.add(priceClsCode);
						if(priceClsCode.equals(""))
						  priceClsDesc = "";
						else
							priceClsDesc = getPriceClsDesc(priceClsCode,packageCode,language_id,operating_facility_id);
						//System.out.println("priceClsDesc from func:"+priceClsDesc);

						pkgPClsDesc.add(priceClsDesc);
						outPriceClsCode = (checkForNull(rs.getString("OUTSIDE_PKG_PRICE_CLASS_CODE")));
						oPkgPClsCode.add(outPriceClsCode);
						if(outPriceClsCode.equals(""))
						  outPriceClsDesc = "";
						else
							outPriceClsDesc = getPriceClsDesc(outPriceClsCode,packageCode,language_id,operating_facility_id);
					//System.out.println("outPriceClsDesc from func:"+outPriceClsDesc);

						oPkgPClsDesc.add(outPriceClsDesc);
						glSmry = (checkForNull(rs.getString("GL_POST_AC_FOR_PKG")));
						glSmryList.add(glSmry);
						glSmryDesc = (checkForNull(rs.getString("ACC_INT_DESC")));
						glSmryDescList.add(glSmryDesc);

						glSmryDisc = (checkForNull(rs.getString("GL_POST_AC_FOR_DISC")));
						glSmryDiscList.add(glSmryDisc);
						glSmryDiscDesc = (checkForNull(rs.getString("ACC_INT_DISC_DESC")));
						glSmryDiscDescList.add(glSmryDiscDesc);
						//Added V180122-Gayathri/MMS-DM-CRF-0118/Strats
						VATapplicable = (checkForNull(rs.getString("ADDL_CHG_APPLICABLE_YN")));
						VATappList.add(VATapplicable);
						VATpercentage = (checkForNull(rs.getString("ADDL_CHG_RULE_CODE")));
						VATpercentList.add(VATpercentage);
						VATapplicable_old = (checkForNull(rs.getString("ADDL_CHG_APPLICABLE_YN")));
						VATappList_old.add(VATapplicable_old);
						//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends
						flag.add("modify");
					}
					if(priceFromDate!=null && priceFromDate.size()>0)
					{
						dtlsArray.add(priceFromDate);
						dtlsArray.add(priceToDate);
						dtlsArray.add(pkgPClsCode);
						dtlsArray.add(pkgPClsDesc);
						dtlsArray.add(oPkgPClsCode);
						dtlsArray.add(oPkgPClsDesc);
						dtlsArray.add(flag);
						dtlsArray.add(glSmryList);
						dtlsArray.add(glSmryDescList);
						dtlsArray.add(glSmryDiscList);
						dtlsArray.add(glSmryDiscDescList);
						//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts
						dtlsArray.add(VATappList);
						dtlsArray.add(VATpercentList);
						dtlsArray.add(VATappList_old);
						//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends
						baseDates.put(packageCode,dtlsArray);
						
						setBaseDates(baseDates);
					}
				}
				catch(Exception e)
				{
					System.out.println("Exception from Package MAin :"+e);
					e.printStackTrace();
				}

			}
			else if(tab.equals("RATE_BASED"))
			{	
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
			//	ArrayList	unlimited_list			=	new ArrayList();
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
				ArrayList 	split_reqd_list = new ArrayList();	//Rajesh V - Split reqd
				ArrayList 	includeHomeMedication_list =new ArrayList();	//sarathkumar InclHmeMedi
				ArrayList 	enableDisParam_list     =   new ArrayList();	//sarathkumar InclHmeMedi
				ArrayList 	dailyLmtChkBxList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
				ArrayList 	dailyLmtAmtList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
				ArrayList 	dailyLmtGrossNetList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
				ArrayList dailyLmtIndicatorList = new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				ArrayList dailyLmtQtyList = new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				ArrayList   includedItems_RBD		=	new ArrayList();
				ArrayList   dbIncludedItems_RBD		=	new ArrayList();
				HashMap		dbIncludedItem_RBD		=   new HashMap();		
				HashMap		includedItems_RB		=   new HashMap();		
				HashMap		dbIncludedItems_RB		=   new HashMap();	
				HashMap		includedItemsFD_RB		=   new HashMap();
				String flagInd = "";
				//includedItems_RB    =  getIncludedItems_RB();
				String prevDate = "";
				String curDate = "";
				ArrayList	serv_grp_limit_ind_list		=	new ArrayList(); //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
				if(!copyFrm_pkgCode.equals("")){
					//Modified below Query by Muthukumar against IN032059 on 3-4-12   //INCL_HOME_MEDICATION_YN
				//System.out.println(" **** 953 **** ");
				sqlStr ="SELECT to_date(a.EFF_FROM_DATE,'dd/mm/yyyy') EFF_FROM_DATE,to_char(a.EFF_FROM_DATE,'dd/mm/yyyy') EFF_FROM_DATE1, a.CLOSE_PACKAGE_YN,ROUNDING_BY_INTEGER, ROUNDING_OPTION, AUTO_REFUND_YN,pkg_serv_ind, pkg_serv_code, b.service_desc, a.order_catalog_code order_catalog_code, (select short_desc from or_order_catalog_lang_vw where LANGUAGE_ID=? AND order_catalog_code= a.order_catalog_code) order_catalog_desc,       rate_ind, factor_rate, qty_limit, AMT_LIMIT_IND, amt_limit,AMT_LIMIT_IND , replaceable_yn, replaceable_serv_code,        (select short_desc from BL_BLNG_SERV_lang_vw where LANGUAGE_ID=? AND blng_serv_code= a.replaceable_serv_code) replaceable_serv_desc, rep_serv_ord_cat_code,(select short_desc from or_order_catalog_lang_vw where LANGUAGE_ID=? AND order_catalog_code= a.rep_serv_ord_cat_code)  rep_serv_ord_cat_desc, refund_yn, REFUND_RATE,a.apply_fact_for_srv_lmt_yn factor_appl, a.split_allowed_yn, a.INCL_HOME_MEDICATION_YN, blcommonproc.bl_pharm_service_yn(?,a.PKG_SERV_IND,a.PKG_SERV_CODE )enableDisParam, (select 'Y' from bl_package_exclusions where operating_facility_id=a.operating_facility_id AND package_code=a.package_code AND pkg_serv_code=a.pkg_serv_code and rownum=1) service_limit, NVL(DAILY_AMT_LIMIT_YN,'N') DAILY_AMT_LIMIT_YN, DAILY_AMT_LIMIT, DAILY_AMT_LIMIT_GROSS_NET, NVL(DAILY_LIMIT_IND,'*') DAILY_LIMIT_IND, DAILY_QTY_LIMIT,group_service_ind FROM bl_package_dtls a,(select 'S' Serv_Ind, blng_serv_code code, short_desc service_desc,language_id,status from BL_BLNG_SERV_lang_vw  union all select 'C' serv_ind, serv_classification_code code, short_desc service_desc,language_id,status from BL_SERV_CLASSIFICATION_lang_vw union all select 'P' serv_ind,package_serv_group_code code,   short_desc description, 'en', null status from bl_package_serv_group_hdr WHERE operating_facility_id = ? union all select 'G' serv_ind, serv_grp_code code, short_desc service_desc,language_id,status from bl_blng_serv_grp_lang_vw) b WHERE a.operating_facility_id = ?  AND b.status is null AND a.package_code = ? AND a.rate_charge_ind = ? AND a.pkg_serv_code=b.code AND a.pkg_serv_ind=b.Serv_Ind AND b.language_id=? ANd a.eff_from_date = (select max(c.eff_from_Date) from BL_PACKAGE_PERIOD c WHERE c.operating_facility_id = a.operating_facility_id  AND c.package_code = a.package_code )  order by EFF_FROM_DATE"; //V211130
				System.err.println(" **** 953-if **** :"+sqlStr);
			}else{		
				//Modified below Query by Muthukumar against IN032059 on 3-4-12
				//System.out.println(" **** 956 **** ");
				sqlStr="SELECT to_date(a.EFF_FROM_DATE,'dd/mm/yyyy') EFF_FROM_DATE,to_char(a.EFF_FROM_DATE,'dd/mm/yyyy') EFF_FROM_DATE1, a.CLOSE_PACKAGE_YN,ROUNDING_BY_INTEGER, ROUNDING_OPTION, AUTO_REFUND_YN,pkg_serv_ind, pkg_serv_code, b.service_desc, a.order_catalog_code order_catalog_code, (select short_desc from or_order_catalog_lang_vw where LANGUAGE_ID=? AND order_catalog_code= a.order_catalog_code) order_catalog_desc, rate_ind, factor_rate, qty_limit, AMT_LIMIT_IND, amt_limit,AMT_LIMIT_IND , replaceable_yn, replaceable_serv_code, (select short_desc from BL_BLNG_SERV_lang_vw where LANGUAGE_ID=? AND blng_serv_code= a.replaceable_serv_code) replaceable_serv_desc, rep_serv_ord_cat_code,(select short_desc from or_order_catalog_lang_vw where LANGUAGE_ID=? AND order_catalog_code= a.rep_serv_ord_cat_code)  rep_serv_ord_cat_desc, refund_yn, REFUND_RATE,a.apply_fact_for_srv_lmt_yn factor_appl, a.split_allowed_yn, a.INCL_HOME_MEDICATION_YN, blcommonproc.bl_pharm_service_yn(?,a.PKG_SERV_IND,a.PKG_SERV_CODE )enableDisParam, (select 'Y' from bl_package_exclusions where operating_facility_id=a.operating_facility_id AND package_code=a.package_code AND pkg_serv_code=a.pkg_serv_code and rownum=1) service_limit, NVL(DAILY_AMT_LIMIT_YN,'N') DAILY_AMT_LIMIT_YN, DAILY_AMT_LIMIT, DAILY_AMT_LIMIT_GROSS_NET, NVL(DAILY_LIMIT_IND,'*') DAILY_LIMIT_IND, DAILY_QTY_LIMIT,group_service_ind FROM bl_package_dtls a,(select 'S' Serv_Ind, blng_serv_code code, short_desc service_desc,language_id,status from BL_BLNG_SERV_lang_vw  union all select 'C' serv_ind, serv_classification_code code, short_desc service_desc,language_id,status from BL_SERV_CLASSIFICATION_lang_vw union all select 'P' serv_ind,package_serv_group_code code,   short_desc description, 'en', null status from bl_package_serv_group_hdr WHERE operating_facility_id = ?  union all select 'G' serv_ind, serv_grp_code code, short_desc service_desc,language_id,status from bl_blng_serv_grp_lang_vw) b WHERE a.operating_facility_id = ? AND b.status is null AND a.package_code = ? AND a.rate_charge_ind = ? AND a.pkg_serv_code=b.code AND a.pkg_serv_ind=b.Serv_Ind AND b.language_id=? order by EFF_FROM_DATE";
				} //V211130
				System.err.println(" **** 953-else **** :"+sqlStr);
				if(rs!=null) rs=null;
				if(pstmt!=null) pstmt=null;
				pstmt=connection.prepareStatement(sqlStr);	
				pstmt.setString(1,language_id);
				pstmt.setString(2,language_id);
				pstmt.setString(3,language_id);
				pstmt.setString(4,language_id);
				pstmt.setString(5,operating_facility_id);
				pstmt.setString(6,operating_facility_id);
				if(!copyFrm_pkgCode.equals("")){//have value only in insert mode if user selects a pkg code to copy from
					pstmt.setString(7,copyFrm_pkgCode);
				}else
					pstmt.setString(7,packageCode);
				pstmt.setString(8,"R");
				pstmt.setString(9,language_id);
				//pstmt.setString(8,fromDate);
				rs	= pstmt.executeQuery();
				while (rs.next()){
					
					curDate = checkForNull(rs.getString("EFF_FROM_DATE1"));
					//System.out.println("prevDate="+prevDate);
					//System.out.println("curDate="+curDate);
					if(!prevDate.equals("") && !(curDate.equals(prevDate))  && copyFrm_pkgCode.equals("") ) {
					includedItems_RBD.add(type_list);
					includedItems_RBD.add(service_code_list);
					dbIncludedItems_RBD.add(service_code_list);					
					includedItems_RBD.add(service_desc_list)	;
					includedItems_RBD.add(catalog_code_list)	;
					includedItems_RBD.add(catalog_desc_list);
					includedItems_RBD.add(ind_list);
					includedItems_RBD.add(factorOrRate_list);
					includedItems_RBD.add(qty_limit_list);
					includedItems_RBD.add(amt_limit_ind_list);
					includedItems_RBD.add(amt_limit_list);
					//includedItems_RBD.add(unlimited_list);
					includedItems_RBD.add(replace_list);
					includedItems_RBD.add(replaceSrv_code_list);
					includedItems_RBD.add(replaceSrv_desc_list);
					includedItems_RBD.add(replaceSrv_cat_code_list);
					includedItems_RBD.add(replaceSrv_cat_desc_list);
					//System.out.println("111 refund_list="+refund_list.toString());
					
					includedItems_RBD.add(refund_list);
					includedItems_RBD.add(refundAmt_list);
					includedItems_RBD.add(factor_appl_list);
					includedItems_RBD.add(service_limit_list);
					includedItems_RBD.add(auto_refund_list);
					includedItems_RBD.add(roundTo_list);
					includedItems_RBD.add(roundInd_list);
					includedItems_RBD.add(closePkg_list);
					includedItems_RBD.add(split_reqd_list);//Split reqd
					includedItems_RBD.add(includeHomeMedication_list); //sarathkumar InclHmeMedi
					includedItems_RBD.add(enableDisParam_list); //sarathkumar InclHmeMedi
					includedItems_RBD.add(dailyLmtChkBxList);//Added V190320-Aravindh/MMS-DM-CRF-0129
					includedItems_RBD.add(dailyLmtAmtList);//Added V190320-Aravindh/MMS-DM-CRF-0129
					includedItems_RBD.add(dailyLmtGrossNetList);//Added V190320-Aravindh/MMS-DM-CRF-0129
					includedItems_RBD.add(dailyLmtIndicatorList);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
					includedItems_RBD.add(dailyLmtQtyList);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
					includedItems_RBD.add(serv_grp_limit_ind_list);//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
		//System.out.println("1012 in bean,includedItems_RBD="+includedItems_RBD.toString());
					dbIncludedItem_RBD.put(prevDate,dbIncludedItems_RBD);
					includedItemsFD_RB.put(prevDate,includedItems_RBD);
					
					type_list				=	new ArrayList();
					service_code_list		=	new ArrayList();
					service_desc_list	    =	new ArrayList();
					catalog_code_list		=	new ArrayList();
					catalog_desc_list		=	new ArrayList();
					ind_list				=	new ArrayList();
					factorOrRate_list		=	new ArrayList();
					qty_limit_list			=	new ArrayList();
					amt_limit_ind_list		=	new ArrayList();
					amt_limit_list			=	new ArrayList();
					replace_list			=	new ArrayList();
					replaceSrv_code_list    =	new ArrayList();
					replaceSrv_desc_list    =	new ArrayList();
					replaceSrv_cat_code_list=	new ArrayList();
					replaceSrv_cat_desc_list=	new ArrayList();
					refund_list				=	new ArrayList();
					refundAmt_list			=	new ArrayList();	
					factor_appl_list		=	new ArrayList();	
					service_limit_list		=	new ArrayList();
					auto_refund_list		=	new ArrayList();
					roundTo_list			=	new ArrayList();
					roundInd_list			=	new ArrayList();
					closePkg_list			=	new ArrayList();
					split_reqd_list			=	new ArrayList();//Split reqd
					includeHomeMedication_list = new ArrayList(); //sarathkumar InclHmeMedi
					enableDisParam_list = new ArrayList(); //sarathkumar InclHmeMedi
					dailyLmtChkBxList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
					dailyLmtAmtList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
					dailyLmtGrossNetList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
					dailyLmtIndicatorList = new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
					dailyLmtQtyList = new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
					serv_grp_limit_ind_list		=	new ArrayList();//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
					includedItems_RBD		=	new ArrayList();
					dbIncludedItems_RBD		=	new ArrayList();
					} 
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
					//unlimited_list.add(checkForNull(rs.getString("unlimited_yn")));
					replace_list.add(checkForNull(rs.getString("replaceable_yn")));
					replaceSrv_code_list.add(checkForNull(rs.getString("replaceable_serv_code")));
					replaceSrv_desc_list.add(checkForNull(rs.getString("replaceable_serv_desc")));
					replaceSrv_cat_code_list.add(checkForNull(rs.getString("rep_serv_ord_cat_code")));
					replaceSrv_cat_desc_list.add(checkForNull(rs.getString("rep_serv_ord_cat_desc")));
					refund_list.add(checkForNull(rs.getString("refund_yn")));
					//System.out.println("####"+rs.getString("refund_yn"));
					//System.out.println("refund_list="+refund_list.toString());
					refundAmt_list.add(checkForNull(rs.getString("REFUND_RATE")));
					factor_appl_list.add(checkForNull(rs.getString("factor_appl")));
					auto_refund_list.add(checkForNull(rs.getString("AUTO_REFUND_YN")));
					roundTo_list.add(checkForNull(rs.getString("ROUNDING_BY_INTEGER")));
					roundInd_list.add(checkForNull(rs.getString("ROUNDING_OPTION")));
					closePkg_list.add(checkForNull(rs.getString("CLOSE_PACKAGE_YN"),"N"));
					//System.out.println("CLOSE_PACKAGE_YN in DefBean.java ==> "+closePkg_list);
					split_reqd_list.add(checkForNull(rs.getString("split_allowed_yn"),"N"));//Split reqd
					includeHomeMedication_list.add(checkForNull(rs.getString("INCL_HOME_MEDICATION_YN"),"N"));//sarathkumar InclHmeMedi
					enableDisParam_list.add(checkForNull(rs.getString("enableDisParam"),"N"));//sarathkumar InclHmeMedi
					dailyLmtChkBxList.add(checkForNull(rs.getString("DAILY_AMT_LIMIT_YN"),"N"));//Added V190320-Aravindh/MMS-DM-CRF-0129
					dailyLmtAmtList.add(checkForNull(rs.getString("DAILY_AMT_LIMIT")));//Added V190320-Aravindh/MMS-DM-CRF-0129
					dailyLmtGrossNetList.add(checkForNull(rs.getString("DAILY_AMT_LIMIT_GROSS_NET")));//Added V190320-Aravindh/MMS-DM-CRF-0129
					dailyLmtIndicatorList.add(checkForNull(rs.getString("DAILY_LIMIT_IND")));//Added V190626-Aravindh/MMS-DM-CRF-0129.1
					dailyLmtQtyList.add(checkForNull(rs.getString("DAILY_QTY_LIMIT")));//Added V190626-Aravindh/MMS-DM-CRF-0129.1
					serv_grp_limit_ind_list.add(checkForNull(rs.getString("GROUP_SERVICE_IND")));//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
					if(!checkForNull(rs.getString("service_limit")).equals("Y")){
						service_limit_list.add("N");
					}else
						service_limit_list.add(checkForNull(rs.getString("service_limit")));
					prevDate = curDate;
					flagInd = "1";
				}
				if(service_code_list.size()>0)
				{					
					includedItems_RBD.add(type_list)	;
					includedItems_RBD.add(service_code_list);
					dbIncludedItems_RBD.add(service_code_list);					
					includedItems_RBD.add(service_desc_list)	;
					includedItems_RBD.add(catalog_code_list)	;
					includedItems_RBD.add(catalog_desc_list);
					includedItems_RBD.add(ind_list);
					includedItems_RBD.add(factorOrRate_list);
					includedItems_RBD.add(qty_limit_list);
					includedItems_RBD.add(amt_limit_ind_list);
					includedItems_RBD.add(amt_limit_list);
					//includedItems_RBD.add(unlimited_list);
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
					System.out.println("closePkg_list 1103 :"+closePkg_list);
					includedItems_RBD.add(split_reqd_list);//Split reqd
					includedItems_RBD.add(includeHomeMedication_list); //sarathkumar InclHmeMedi
					includedItems_RBD.add(enableDisParam_list); //sarathkumar InclHmeMedi
					includedItems_RBD.add(dailyLmtChkBxList);//Added V190320-Aravindh/MMS-DM-CRF-0129
					includedItems_RBD.add(dailyLmtAmtList);//Added V190320-Aravindh/MMS-DM-CRF-0129
					includedItems_RBD.add(dailyLmtGrossNetList);//Added V190320-Aravindh/MMS-DM-CRF-0129
					includedItems_RBD.add(dailyLmtIndicatorList);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
					includedItems_RBD.add(dailyLmtQtyList);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
					includedItems_RBD.add(serv_grp_limit_ind_list);//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
					//System.out.println("curDate:"+curDate);
//System.out.println("in bean,includedItems_RBD="+includedItems_RBD.toString());
					if(!copyFrm_pkgCode.equals(""))
					{
						dbIncludedItem_RBD.put(fromDate,dbIncludedItems_RBD);
						includedItemsFD_RB.put(fromDate,includedItems_RBD);
					}
					else
					{
						dbIncludedItem_RBD.put(curDate,dbIncludedItems_RBD);
						includedItemsFD_RB.put(curDate,includedItems_RBD);
					}

				}
			//	if(includedItems_RB.containsKey(packageCode))
				//	includedItems_RB.remove(packageCode);
				//System.out.println("in bean,includedItemsFD_RB="+includedItemsFD_RB.toString());
				if(flagInd.equals("1"))
				{
					includedItems_RB.put(packageCode,includedItemsFD_RB);
					dbIncludedItems_RB.put(packageCode,dbIncludedItem_RBD);
						//System.out.println("in bean,includedItems_RB="+includedItems_RB.toString());
					setIncludedItems_RB(includedItems_RB);	
					setDbIncludedItems_RB(dbIncludedItems_RB);		
				}
			}
			else if(tab.equals("SRVLIMIT_RATE_BASED"))
			{
				ArrayList	srvLimit_type_list			=	new ArrayList();
				ArrayList	srvLimit_service_code_list  =	new ArrayList();
				ArrayList	srvLimit_service_desc_list	=	new ArrayList();
				ArrayList	exludeService_list		    =	new ArrayList();
				ArrayList	srvLimit_qty_limit_list		=	new ArrayList();
				ArrayList	srvLimit_amt_limit_list		=	new ArrayList();
				ArrayList	srvLimit_factor_appl_list	=	new ArrayList();
				ArrayList   amt_limit_ind_list			=	new ArrayList();
				ArrayList	replace_list				=	new ArrayList();
				ArrayList	replaceSrv_code_list		=	new ArrayList();
				ArrayList	replaceSrv_desc_list		=	new ArrayList();
				ArrayList   refund_list					=	new ArrayList();
				ArrayList   refundAmt_list				=	new ArrayList();
				ArrayList   auto_refund_list			=	new ArrayList();
				ArrayList   roundTo_list				=	new ArrayList();
				ArrayList   roundInd_list				=	new ArrayList();
				ArrayList 	split_reqd_list = new ArrayList();	//Rajesh V - Split reqd
				ArrayList 	includeHomeMedication_list = new ArrayList();	//sarathkumar InclHmeMedi
				ArrayList 	enableDisParam_list = new ArrayList(); //sarathkumar InclHmeMedi
				ArrayList 	dailyLmtChkBxList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
				ArrayList 	dailyLmtAmtList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
				ArrayList 	dailyLmtGrossNetList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
				ArrayList dailyLmtIndicatorList = new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				ArrayList dailyLmtQtyList = new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				ArrayList excludedItems_RBD =	new ArrayList();
				ArrayList dbExcludedItems_RBD =	new ArrayList();
				HashMap excludedItems_RB    =   new HashMap();
				HashMap excludedItemsFD_RB    =   new HashMap();				
				HashMap dbExcludedItems_RB    =   new HashMap();
				HashMap dbExcludedItemsFD_RB   =   new HashMap();
				excludedItems_RB = getExcludedItems_RB();
				StringBuilder sqlSb=new StringBuilder();// Added By Vijay FOr GHL-SCF
				String newDateAddedFlag=getNewDateAddedFlag(); // Added By Vijay FOr GHL-SCF
				System.out.println("newDateAddedFlag Bean "+newDateAddedFlag);
				//ArrayList   group_service_ind_list			=	new ArrayList();//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 //V201125
				if(excludedItems_RB!=null && excludedItems_RB.containsKey(fromDate))
				  excludedItemsFD_RB = (HashMap) excludedItems_RB.get(fromDate);
				dbExcludedItems_RB = getDbExcludedItems_RB();
				if(dbExcludedItems_RB!=null && dbExcludedItems_RB.containsKey(fromDate))
				  dbExcludedItemsFD_RB = (HashMap) dbExcludedItems_RB.get(fromDate);
				String prevCode = "";
				String curCode = "";
				//int index = 3;		

			if(!copyFrm_pkgCode.equals("")){
			//Modified below Query by Muthukumar against IN032059 on 3-4-12 
			//- AND a.rate_charge_ind = ? - removed by Muthukumar against 31080 on 16-4-12
			//System.out.println(" **** 1170 **** ");
				/*Commented for testing
				sqlStr ="SELECT  a.pkg_serv_code,a.excl_serv_ind excl_serv_ind,a.excl_serv_code excl_serv_code, b.service_desc service_desc,a.exclude_yn exclude_yn, qty_limit, amt_limit,a.apply_fact_for_srv_lmt_yn factor_appl,AMT_LIMIT_IND, REPLACEABLE_YN, REPLACEABLE_SERV_CODE, (select short_desc from BL_BLNG_SERV_lang_vw where LANGUAGE_ID=? AND blng_serv_code= REPLACEABLE_SERV_CODE) replaceable_serv_desc, REFUND_YN, REFUND_RATE, ROUNDING_BY_INTEGER, ROUNDING_OPTION, AUTO_REFUND_YN FROM bl_package_exclusions a, (select 'S' Serv_Ind, blng_serv_code code, short_desc service_desc,language_id from BL_BLNG_SERV_lang_vw union all select 'P' serv_ind, package_serv_group_code code, short_desc service_desc, 'en' from bl_package_serv_group_hdr union all select 'T' serv_ind, sale_category_code code, short_desc service_desc, 'en' from bl_st_item_sale_catg_hdr union all select 'G' serv_ind, serv_grp_code code, short_desc description, language_id from bl_blng_serv_grp_lang_vw union all  select 'C' serv_ind, serv_classification_code code, short_desc service_desc,language_id from BL_SERV_CLASSIFICATION_lang_vw union all select 'M' serv_ind, item_code code, short_desc service_desc,language_id from MM_ITem_lang_vw) b WHERE a.operating_facility_id = ?    AND a.package_code = ? and  a.excl_serv_code=b.code  AND a.excl_serv_ind=b.Serv_Ind   AND b.language_id=? ANd a.eff_from_date = (select max(c.eff_from_Date) from BL_PACKAGE_PERIOD c WHERE c.operating_facility_id = a.operating_facility_id  AND c.package_code = a.package_code )";*/

				sqlStr ="SELECT  a.pkg_serv_code,a.excl_serv_ind excl_serv_ind,a.excl_serv_code excl_serv_code, b.service_desc service_desc,a.exclude_yn exclude_yn, qty_limit, amt_limit,a.apply_fact_for_srv_lmt_yn factor_appl,AMT_LIMIT_IND, REPLACEABLE_YN, REPLACEABLE_SERV_CODE, (select short_desc from BL_BLNG_SERV_lang_vw where LANGUAGE_ID=? AND blng_serv_code= REPLACEABLE_SERV_CODE) replaceable_serv_desc, REFUND_YN, REFUND_RATE, ROUNDING_BY_INTEGER, ROUNDING_OPTION, a.split_allowed_yn, a.INCL_HOME_MEDICATION_YN, blcommonproc.bl_pharm_service_yn(?,a.EXCL_SERV_IND,a.EXCL_SERV_CODE )enableDisParam, AUTO_REFUND_YN, NVL(DAILY_AMT_LIMIT_YN,'N') DAILY_AMT_LIMIT_YN, DAILY_AMT_LIMIT, DAILY_AMT_LIMIT_GROSS_NET, NVL(DAILY_LIMIT_IND,'*') DAILY_LIMIT_IND, DAILY_QTY_LIMIT FROM bl_package_exclusions a, (select 'S' Serv_Ind, blng_serv_code code, short_desc service_desc,language_id from BL_BLNG_SERV_lang_vw union all select 'P' Serv_Ind, package_serv_group_code code, short_desc service_desc, 'en' from bl_package_serv_group_hdr WHERE operating_facility_id = ? union all select 'T' Serv_Ind, sale_category_code code, short_desc service_desc, 'en' from bl_st_item_sale_catg_hdr union all select 'G' Serv_Ind, serv_grp_code code, short_desc description, language_id from bl_blng_serv_grp_lang_vw union all  select 'C' Serv_Ind, serv_classification_code code, short_desc service_desc,language_id from BL_SERV_CLASSIFICATION_lang_vw union all select 'M' Serv_Ind, item_code code, short_desc service_desc,language_id from MM_ITem_lang_vw) b WHERE a.operating_facility_id = ?    AND a.package_code = ? and  a.excl_serv_code=b.code  AND a.excl_serv_ind=b.Serv_Ind   AND b.language_id=? ANd a.eff_from_date = (select max(c.eff_from_Date) from BL_PACKAGE_PERIOD c WHERE c.operating_facility_id = a.operating_facility_id  AND c.package_code = a.package_code ) order by 1,2,4,3";	//V211130
				//Added by Rajesh V for GHL-ICN
				sqlSb.append(sqlStr);

			}else{
				//Modified by Muthu against 30025 on 13-12-11 - AND a.rate_charge_ind = ?
				//Modified below Query by Muthukumar against IN032059 on 3-4-12
				//System.out.println(" **** 1175 **** ");
				/*Commented for testing
				sqlStr="SELECT  a.excl_serv_ind excl_serv_ind,a.excl_serv_code excl_serv_code, b.service_desc service_desc,a.exclude_yn exclude_yn, qty_limit, amt_limit,a.apply_fact_for_srv_lmt_yn factor_appl,AMT_LIMIT_IND, REPLACEABLE_YN, REPLACEABLE_SERV_CODE, (select short_desc from BL_BLNG_SERV_lang_vw where LANGUAGE_ID=? AND blng_serv_code= REPLACEABLE_SERV_CODE) replaceable_serv_desc, REFUND_YN, REFUND_RATE, ROUNDING_BY_INTEGER, ROUNDING_OPTION, AUTO_REFUND_YN FROM bl_package_exclusions a, (select 'S' Serv_Ind, blng_serv_code code, short_desc service_desc,language_id from BL_BLNG_SERV_lang_vw union all select 'P' serv_ind, package_serv_group_code code, short_desc service_desc, 'en' from bl_package_serv_group_hdr union all select 'T' serv_ind, sale_category_code code, short_desc service_desc, 'en' from bl_st_item_sale_catg_hdr union all select 'G' serv_ind, serv_grp_code code, short_desc description, language_id from bl_blng_serv_grp_lang_vw union all select 'C' serv_ind, serv_classification_code code, short_desc service_desc,language_id from bl_serv_classification_lang_vw union all select 'M' serv_ind, item_code code, short_desc service_desc,language_id from MM_ITem_lang_vw) b where a.operating_facility_id = ? AND a.package_code = ? and EFF_FROM_DATE = to_date(?,'dd/mm/yyyy') and a.pkg_serv_code=? and  a.excl_serv_code=b.code  AND a.excl_serv_ind=b.Serv_Ind AND b.language_id=? ";*/
			//	sqlStr="SELECT  a.excl_serv_ind excl_serv_ind,a.excl_serv_code excl_serv_code, b.service_desc service_desc,a.exclude_yn exclude_yn, qty_limit, amt_limit,a.apply_fact_for_srv_lmt_yn factor_appl,AMT_LIMIT_IND, REPLACEABLE_YN, REPLACEABLE_SERV_CODE, (select short_desc from BL_BLNG_SERV_lang_vw where LANGUAGE_ID=? AND blng_serv_code= REPLACEABLE_SERV_CODE) replaceable_serv_desc, REFUND_YN, REFUND_RATE, ROUNDING_BY_INTEGER, ROUNDING_OPTION, a.split_allowed_yn, AUTO_REFUND_YN FROM bl_package_exclusions a, (select 'S' Serv_Ind, blng_serv_code code, short_desc service_desc,language_id from BL_BLNG_SERV_lang_vw union all select 'P' Serv_Ind, package_serv_group_code code, short_desc service_desc, 'en' from bl_package_serv_group_hdr union all select 'T' Serv_Ind, sale_category_code code, short_desc service_desc, 'en' from bl_st_item_sale_catg_hdr union all select 'G' Serv_Ind, serv_grp_code code, short_desc description, language_id from bl_blng_serv_grp_lang_vw union all select 'C' Serv_Ind, serv_classification_code code, short_desc service_desc,language_id from bl_serv_classification_lang_vw union all select 'M' Serv_Ind, item_code code, short_desc service_desc,language_id from MM_ITem_lang_vw) b where a.operating_facility_id = ? AND a.package_code = ? and EFF_FROM_DATE = to_date(?,'dd/mm/yyyy') and a.pkg_serv_code=? and  a.excl_serv_code=b.code  AND a.excl_serv_ind=b.Serv_Ind AND b.language_id=? order by 1,2,4,3 ";
			// Query  modified  by Vijay and Muthu Kumaran for GHL-SCF-1086
			
				
				sqlStr="SELECT distinct a.excl_serv_ind excl_serv_ind,a.excl_serv_code excl_serv_code, b.service_desc service_desc,a.exclude_yn exclude_yn, qty_limit, amt_limit,a.apply_fact_for_srv_lmt_yn factor_appl,AMT_LIMIT_IND, REPLACEABLE_YN, REPLACEABLE_SERV_CODE, (select short_desc from BL_BLNG_SERV_lang_vw where LANGUAGE_ID=? AND blng_serv_code= REPLACEABLE_SERV_CODE) replaceable_serv_desc, REFUND_YN, REFUND_RATE, ROUNDING_BY_INTEGER, ROUNDING_OPTION, a.split_allowed_yn, a.INCL_HOME_MEDICATION_YN, blcommonproc.bl_pharm_service_yn(?,a.EXCL_SERV_IND,a.EXCL_SERV_CODE )enableDisParam, AUTO_REFUND_YN, NVL(DAILY_AMT_LIMIT_YN,'N') DAILY_AMT_LIMIT_YN, DAILY_AMT_LIMIT, DAILY_AMT_LIMIT_GROSS_NET, NVL(DAILY_LIMIT_IND,'*') DAILY_LIMIT_IND, DAILY_QTY_LIMIT FROM bl_package_exclusions a, (select 'S' Serv_Ind, blng_serv_code code, short_desc service_desc,language_id from BL_BLNG_SERV_lang_vw union all select 'P' Serv_Ind, package_serv_group_code code, short_desc service_desc, 'en' from bl_package_serv_group_hdr WHERE operating_facility_id = ? union all select 'T' Serv_Ind, sale_category_code code, short_desc service_desc, 'en' from bl_st_item_sale_catg_hdr union all select 'G' Serv_Ind, serv_grp_code code, short_desc description, language_id from bl_blng_serv_grp_lang_vw union all select 'C' Serv_Ind, serv_classification_code code, short_desc service_desc,language_id from bl_serv_classification_lang_vw union all select 'M' Serv_Ind, item_code code, short_desc service_desc,language_id from MM_ITem_lang_vw) b where a.operating_facility_id = ? AND a.package_code = ?  and a.pkg_serv_code=? and  a.excl_serv_code=b.code  AND a.excl_serv_ind=b.Serv_Ind  "; //V211130
				
				/* Added  BY Vijay For GH-SCF */
				sqlSb.append(sqlStr);
				if(newDateAddedFlag.equals("Y"))
				{
					System.out.println("in if ");
					sqlSb.append(" and a.eff_from_date " 
                           +" =( select max(EFF_FROM_DATE) "
                           +" from bl_package_period c "
                           +" where C.OPERATING_FACILITY_ID = A.OPERATING_FACILITY_ID "
                           +" and C.PACKAGE_CODE = A.PACKAGE_CODE) AND b.language_id=? order by 1,2,4,3 ");   
					System.out.println("sqlsb "+sqlSb.toString());
				}
				else
				{
					System.out.println("else ");
					sqlSb.append(" and a.eff_from_date=to_date(?,'dd/mm/yyyy')  AND b.language_id=? order by 1,2,4,3");
					System.out.println("sql "+sqlSb.toString());
				}
				
				/* ends*/
					
				System.out.println("string builder  "+sqlSb);
				}
				if(rs!=null) rs=null;
				if(pstmt!=null) pstmt=null;
				pstmt=connection.prepareStatement(sqlSb.toString());
				pstmt.setString(1,language_id);
				pstmt.setString(2,language_id);
				pstmt.setString(3,operating_facility_id);
				pstmt.setString(4,operating_facility_id);
				if(!copyFrm_pkgCode.equals("")){//have value only in insert mode if user selects a pkg code to copy from
					pstmt.setString(5,copyFrm_pkgCode);
					pstmt.setString(6,language_id);
				}else
				{
					pstmt.setString(5,packageCode);
					pstmt.setString(6,parent_service_code);
					if(!newDateAddedFlag.equals("Y")) // 	 Added  BY Vijay For GH-SCF 	
					{
						pstmt.setString(7,fromDate);
						pstmt.setString(8,language_id);
					}else{
						pstmt.setString(7,language_id);
					}
					System.out.println("fromDate "+fromDate); // "Date" as a parameter removed by Vijay and muthukumaran for ghl-scf-1086
				
				}
				//pstmt.setString(++index,"R"); //Comment is removed for testing by Muthu on 09-04-12
				//pstmt.setString(++index,"R"); //Commented by Muthu against 30025 on 13-12-11
				
				
				rs = pstmt.executeQuery();
				while (rs.next())
				{
					if(!copyFrm_pkgCode.equals(""))
					{
						curCode = checkForNull(rs.getString("pkg_serv_code"));
						//System.out.println("in setDBValues,curCode="+curCode);
						//System.out.println("in setDBValues,prevCode="+prevCode);
						if(!prevCode.equals("") && !prevCode.equals(curCode))
						{
							excludedItems_RBD.add(srvLimit_type_list);
							excludedItems_RBD.add(srvLimit_service_code_list);
							//dbExcludedItems_RBD.add(srvLimit_service_code_list);
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
							excludedItems_RBD.add(replaceSrv_desc_list);
							excludedItems_RBD.add(split_reqd_list);//Split reqd
							excludedItems_RBD.add(includeHomeMedication_list);//sarathkumar InclHmeMedi
							excludedItems_RBD.add(enableDisParam_list); //sarathkumar InclHmeMedi
							excludedItems_RBD.add(dailyLmtChkBxList);//Added V190320-Aravindh/MMS-DM-CRF-0129
							excludedItems_RBD.add(dailyLmtAmtList);//Added V190320-Aravindh/MMS-DM-CRF-0129
							excludedItems_RBD.add(dailyLmtGrossNetList);//Added V190320-Aravindh/MMS-DM-CRF-0129
							excludedItems_RBD.add(dailyLmtIndicatorList);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
							excludedItems_RBD.add(dailyLmtQtyList);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
							//excludedItems_RBD.add(group_service_ind_list);//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 //V201125
							excludedItemsFD_RB.put(prevCode,excludedItems_RBD);
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
							excludedItems_RBD			=	new ArrayList();
							split_reqd_list				=	new ArrayList();//Split reqd
							includeHomeMedication_list	=	new ArrayList();//sarathkumar InclHmeMedi
							enableDisParam_list			=	new ArrayList();//sarathkumar InclHmeMedi
							dailyLmtChkBxList 			= 	new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
							dailyLmtAmtList 			= 	new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
							dailyLmtGrossNetList 		= 	new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
							dailyLmtIndicatorList 		= 	new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
							dailyLmtQtyList 			= 	new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
							//group_service_ind_list			=	new ArrayList();//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 //V201125
						}
						prevCode = curCode;
					}
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
				   refund_list.add(checkForNull(rs.getString("REFUND_YN")));
				   refundAmt_list.add(checkForNull(rs.getString("REFUND_RATE")));				   
				   auto_refund_list.add(checkForNull(rs.getString("AUTO_REFUND_YN")));				   
				   roundTo_list.add(checkForNull(rs.getString("ROUNDING_BY_INTEGER")));				   
				   roundInd_list.add(checkForNull(rs.getString("ROUNDING_OPTION")));				   
				   replaceSrv_desc_list.add(checkForNull(rs.getString("replaceable_serv_desc")));	
				   split_reqd_list.add(checkForNull(rs.getString("split_allowed_yn"),"N"));//Split reqd
				   includeHomeMedication_list.add(checkForNull(rs.getString("INCL_HOME_MEDICATION_YN"),"N"));//sarathkumar InclHmeMedi
				   enableDisParam_list.add(checkForNull(rs.getString("enableDisParam"),"N"));//sarathkumar InclHmeMedi
				   dailyLmtChkBxList.add(checkForNull(rs.getString("DAILY_AMT_LIMIT_YN"),"N"));//Added V190320-Aravindh/MMS-DM-CRF-0129
				   dailyLmtAmtList.add(checkForNull(rs.getString("DAILY_AMT_LIMIT")));//Added V190320-Aravindh/MMS-DM-CRF-0129
				   dailyLmtGrossNetList.add(checkForNull(rs.getString("DAILY_AMT_LIMIT_GROSS_NET")));//Added V190320-Aravindh/MMS-DM-CRF-0129
				   dailyLmtIndicatorList.add(checkForNull(rs.getString("DAILY_LIMIT_IND")));//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				   dailyLmtQtyList.add(checkForNull(rs.getString("DAILY_QTY_LIMIT")));//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				   //group_service_ind_list.add(checkForNull(rs.getString("GROUP_SERVICE_IND")));//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 //V201125
				}
				//System.out.println("in setDBValues,srvLimit_service_code_list="+srvLimit_service_code_list);
				if(srvLimit_service_code_list.size()>0)
				{
					excludedItems_RBD.add(srvLimit_type_list)	;
					excludedItems_RBD.add(srvLimit_service_code_list);
					dbExcludedItems_RBD.add(srvLimit_service_code_list);
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
					excludedItems_RBD.add(replaceSrv_desc_list);
					excludedItems_RBD.add(split_reqd_list);//Split reqd
					excludedItems_RBD.add(includeHomeMedication_list);//sarathkumar InclHmeMedi
					excludedItems_RBD.add(enableDisParam_list);//sarathkumar InclHmeMedi
					excludedItems_RBD.add(dailyLmtChkBxList);//Added V190320-Aravindh/MMS-DM-CRF-0129
					excludedItems_RBD.add(dailyLmtAmtList);//Added V190320-Aravindh/MMS-DM-CRF-0129
					excludedItems_RBD.add(dailyLmtGrossNetList);//Added V190320-Aravindh/MMS-DM-CRF-0129
					excludedItems_RBD.add(dailyLmtIndicatorList);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
					excludedItems_RBD.add(dailyLmtQtyList);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
					//excludedItems_RBD.add(group_service_ind_list);//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
					/*if(getExcludedItems_RB().size()>0)
					{
						excludedItems_RB = getExcludedItems_RB();
						if(excludedItems_RB.containsKey(fromDate))
						{
							excludedItemsFD_RB = (HashMap)excludedItems_RB.get(fromDate);
							if(excludedItemsFD_RB.containsKey(parent_service_code))
								excludedItemsFD_RB.remove(parent_service_code);
						}
						excludedItems_RB.remove(fromDate);
					}
					if(getDbExcludedItems_RB().size()>0)
					{
						dbExcludedItems_RB = getDbExcludedItems_RB();
						if(dbExcludedItems_RB.containsKey(fromDate))
						{
							dbExcludedItemsFD_RB = (HashMap)dbExcludedItems_RB.get(fromDate);
							if(dbExcludedItemsFD_RB.containsKey(parent_service_code))
								dbExcludedItemsFD_RB.remove(parent_service_code);
						}
						dbExcludedItems_RB.remove(fromDate);
					}	 */

					/*if(excludedItems_RB.containsKey(parent_service_code))
						excludedItems_RB.remove(parent_service_code);  */
					if(!copyFrm_pkgCode.equals(""))
						excludedItemsFD_RB.put(curCode,excludedItems_RBD);
					else
						excludedItemsFD_RB.put(parent_service_code,excludedItems_RBD);

					excludedItems_RB.put(fromDate,excludedItemsFD_RB);
					dbExcludedItemsFD_RB.put(parent_service_code,dbExcludedItems_RBD);
					dbExcludedItems_RB.put(fromDate,dbExcludedItemsFD_RB);
					setExcludedItems_RB(excludedItems_RB);
					setDbExcludedItems_RB(dbExcludedItems_RB);
				}					
			}
			else if(tab.equals("CHARGE_BASED"))
			{
				ArrayList	charge_type_list	 =	new ArrayList();//MuthuN against 28192
				ArrayList	service_code_list    =	new ArrayList();
				ArrayList	service_desc_list	 =	new ArrayList();					
				ArrayList	amt_limit_ind_list   =	new ArrayList();
				ArrayList	amt_limit_list		 =	new ArrayList();
				//ArrayList	unlimited_list		 =	new ArrayList();				
				ArrayList	service_limit_list   =	new ArrayList();
				ArrayList	factorApplGroup		 =	new ArrayList();
				ArrayList	flag				 =	new ArrayList();
				ArrayList   roundToGroup		 =	new ArrayList();
				ArrayList   roundIndGroup		 =	new ArrayList();
				ArrayList	refund_list			 =	new ArrayList();
				ArrayList	refundAmt_list		 =	new ArrayList();	
				ArrayList	auto_refund_list	 =	new ArrayList();
				ArrayList	split_reqd_list		 =	new ArrayList();//Rajesh V - Split reqd
				ArrayList	includeHomeMedication_list		 =	new ArrayList();//sarathkumar InclHmeMedi
				ArrayList	enableDisParam_list		 =	new ArrayList();//sarathkumar InclHmeMedi
				ArrayList includedItems_CBD		 =	new ArrayList();
				ArrayList dbIncludedItems_CBD	 =	new ArrayList();
				HashMap dbIncludedItem_CBD		 =	new HashMap();
				HashMap dbIncludedItems_CB		 =  new HashMap();
				HashMap includedItems_CB		 =  new HashMap();
				HashMap includedItemsFD_CB		 =  new HashMap();
				String prevDate = "";
				String curDate = "";
				String flagInd = "";
				//HashMap includSrvicesDB_CB		 =   new HashMap();
				//includedItems_CB				 =  getIncludedItems_CB();
			if(!copyFrm_pkgCode.equals("")){
				//System.out.println(" **** 1343 **** ");
				//sqlStr ="SELECT to_date(a.EFF_FROM_DATE,'dd/mm/yyyy') EFF_FROM_DATE,to_char(a.EFF_FROM_DATE,'dd/mm/yyyy') EFF_FROM_DATE1,REFUND_YN, REFUND_RATE, AUTO_REFUND_YN,ROUNDING_BY_INTEGER, ROUNDING_OPTION,pkg_serv_code, b.short_desc service_desc, AMT_LIMIT_IND, amt_limit,AMT_LIMIT_IND,APPLY_FACT_FOR_SRV_LMT_YN, (SELECT 'Y'  FROM bl_package_exclusions WHERE operating_facility_id = a.operating_facility_id AND package_code = a.package_code  AND pkg_serv_code = a.pkg_serv_code  AND ROWNUM = 1) service_limit FROM bl_package_dtls a, bl_blng_serv_lang_vw b WHERE a.operating_facility_id = ?  AND a.package_code = ?  AND a.rate_charge_ind = ?   AND a.pkg_serv_code =b.blng_serv_code AND b.language_id = ? ANd a.eff_from_date = (select max(c.eff_from_Date) from BL_PACKAGE_PERIOD c WHERE c.operating_facility_id = a.operating_facility_id  AND c.package_code = a.package_code )  order by EFF_FROM_DATE";
				//Above query is commented for testing on 30-7-12 by MuthuN
				
				//sqlStr ="SELECT   TO_DATE (a.eff_from_date, 'dd/mm/yyyy') eff_from_date, TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date1, refund_yn, refund_rate, auto_refund_yn, rounding_by_integer, rounding_option,pkg_serv_ind, pkg_serv_code, b.service_desc service_desc, amt_limit_ind, amt_limit,   amt_limit_ind, apply_fact_for_srv_lmt_yn,(SELECT 'Y' FROM bl_package_exclusions WHERE operating_facility_id = a.operating_facility_id AND package_code = a.package_code AND pkg_serv_code = a.pkg_serv_code ANd pkg_serv_ind = a.pkg_serv_ind AND ROWNUM = 1) service_limit FROM bl_package_dtls a, (SELECT blng_serv_code code, short_desc service_desc, language_id FROM bl_blng_serv_lang_vw UNION ALL SELECT item_code code, short_desc service_desc, language_id FROM mm_item_lang_vw) b WHERE a.operating_facility_id = ? AND a.package_code = ? AND a.rate_charge_ind = ? AND a.pkg_serv_code = b.code AND b.language_id = ? AND a.eff_from_date =(SELECT MAX (c.eff_from_date) FROM bl_package_period c WHERE c.operating_facility_id = a.operating_facility_id AND c.package_code = a.package_code) ORDER BY eff_from_date";
				sqlStr ="SELECT TO_DATE (a.eff_from_date, 'dd/mm/yyyy') eff_from_date, TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date1, refund_yn, refund_rate, auto_refund_yn, rounding_by_integer, rounding_option,pkg_serv_ind, pkg_serv_code, b.service_desc service_desc, amt_limit_ind, amt_limit, amt_limit_ind, apply_fact_for_srv_lmt_yn, a.split_allowed_yn, a.INCL_HOME_MEDICATION_YN, blcommonproc.bl_pharm_service_yn('"+language_id+"',a.PKG_SERV_IND,a.PKG_SERV_CODE )enableDisParam, (SELECT 'Y' FROM bl_package_exclusions WHERE operating_facility_id = a.operating_facility_id AND package_code = a.package_code AND pkg_serv_code = a.pkg_serv_code ANd pkg_serv_ind = a.pkg_serv_ind AND ROWNUM = 1) service_limit FROM bl_package_dtls a, (SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc, language_id, status FROM bl_blng_serv_lang_vw UNION ALL SELECT 'M' serv_ind, item_code code, short_desc service_desc, language_id, null status FROM mm_item_lang_vw) b WHERE a.operating_facility_id = ? AND b.status is null AND a.package_code = ? AND a.rate_charge_ind = ? AND a.pkg_serv_code = b.code and a.pkg_serv_ind = b.serv_ind AND b.language_id = ? AND a.eff_from_date =(SELECT MAX (c.eff_from_date) FROM bl_package_period c WHERE c.operating_facility_id = a.operating_facility_id AND c.package_code = a.package_code) ORDER BY eff_from_date";
			}else{
				//sqlStr="SELECT   TO_DATE (a.eff_from_date, 'dd/mm/yyyy') eff_from_date, TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date1, refund_yn, refund_rate, auto_refund_yn, rounding_by_integer, rounding_option,pkg_serv_ind, pkg_serv_code, b.service_desc service_desc, amt_limit_ind, amt_limit,   amt_limit_ind, apply_fact_for_srv_lmt_yn,(SELECT 'Y' FROM bl_package_exclusions WHERE operating_facility_id = a.operating_facility_id AND package_code = a.package_code AND pkg_serv_code = a.pkg_serv_code ANd pkg_serv_ind = a.pkg_serv_ind AND ROWNUM = 1) service_limit FROM bl_package_dtls a, (SELECT blng_serv_code code, short_desc service_desc, language_id FROM bl_blng_serv_lang_vw UNION ALL SELECT item_code code, short_desc service_desc, language_id FROM mm_item_lang_vw) b WHERE a.operating_facility_id = ? AND a.package_code = ? AND a.rate_charge_ind = ? AND a.pkg_serv_code = b.code and b.language_id = ? AND a.eff_from_date =(SELECT MAX (c.eff_from_date) FROM bl_package_period c WHERE c.operating_facility_id = a.operating_facility_id AND c.package_code = a.package_code) ORDER BY eff_from_date";

				//Below query is commented for testing on 30-7-12 by MuthuN
				//sqlStr="SELECT to_date(a.EFF_FROM_DATE,'dd/mm/yyyy') EFF_FROM_DATE,to_char(a.EFF_FROM_DATE,'dd/mm/yyyy') EFF_FROM_DATE1,REFUND_YN, REFUND_RATE, AUTO_REFUND_YN,ROUNDING_BY_INTEGER, ROUNDING_OPTION,pkg_serv_code, b.short_desc service_desc, AMT_LIMIT_IND, amt_limit,AMT_LIMIT_IND,APPLY_FACT_FOR_SRV_LMT_YN, (SELECT 'Y'  FROM bl_package_exclusions WHERE operating_facility_id = a.operating_facility_id AND package_code = a.package_code  AND pkg_serv_code = a.pkg_serv_code  AND ROWNUM = 1) service_limit FROM bl_package_dtls a, bl_blng_serv_lang_vw b WHERE a.operating_facility_id = ?  AND a.package_code = ?  AND a.rate_charge_ind = ?   AND a.pkg_serv_code =b.blng_serv_code AND b.language_id = ? order by a.EFF_FROM_DATE ";
				
				sqlStr="SELECT TO_DATE (a.eff_from_date, 'dd/mm/yyyy') eff_from_date, TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date1, refund_yn, refund_rate, auto_refund_yn, rounding_by_integer, rounding_option,pkg_serv_ind, a.pkg_serv_code, b.service_desc service_desc,  amt_limit_ind, amt_limit, amt_limit_ind, apply_fact_for_srv_lmt_yn, a.split_allowed_yn, a.INCL_HOME_MEDICATION_YN, blcommonproc.bl_pharm_service_yn('"+language_id+"',a.PKG_SERV_IND,a.PKG_SERV_CODE)enableDisParam, (SELECT 'Y' FROM bl_package_exclusions c WHERE c.operating_facility_id = a.operating_facility_id AND c.package_code = a.package_code AND c.pkg_serv_code = a.pkg_serv_code AND ROWNUM = 1) service_limit FROM bl_package_dtls a, (SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc, language_id, status FROM bl_blng_serv_lang_vw UNION ALL SELECT 'M' serv_ind, item_code code, short_desc service_desc, language_id, null status FROM mm_item_lang_vw) b WHERE a.operating_facility_id = ? AND b.status is null AND a.package_code = ? AND a.rate_charge_ind = ? AND a.pkg_serv_code = b.code and a.pkg_serv_ind = b.serv_ind AND b.language_id = ? ORDER BY eff_from_date";
			
				System.out.println("prevDate 1:"+sqlStr);
			}	
			if(rs!=null) rs=null;
				if(pstmt!=null) pstmt=null;
				pstmt=connection.prepareStatement(sqlStr);
				pstmt.setString(1,operating_facility_id);
				if(!copyFrm_pkgCode.equals("")){//have value only in insert mode if user selects a pkg code to copy from
					pstmt.setString(2,copyFrm_pkgCode);
				}else
					pstmt.setString(2,packageCode);
				pstmt.setString(3,"C");
				pstmt.setString(4,language_id);
				//pstmt.setString(5,fromDate);
				rs = pstmt.executeQuery();
				while (rs.next()){

					curDate = checkForNull(rs.getString("EFF_FROM_DATE1"));
					System.out.println("curDate :"+curDate);
					System.out.println("prevDate 1:"+prevDate);
					
					if(!prevDate.equals("") && !(curDate.equals(prevDate)) && copyFrm_pkgCode.equals("")) {
					includedItems_CBD.add(charge_type_list);//MuthuN against 28192
					includedItems_CBD.add(service_code_list);
					dbIncludedItems_CBD.add(service_code_list);
					includedItems_CBD.add(service_desc_list)	;					
					includedItems_CBD.add(amt_limit_ind_list);
					includedItems_CBD.add(amt_limit_list);
					//includedItems_CBD.add(unlimited_list);					
					includedItems_CBD.add(service_limit_list);
					includedItems_CBD.add(factorApplGroup);
					includedItems_CBD.add(roundToGroup);
					includedItems_CBD.add(roundIndGroup);
					includedItems_CBD.add(refund_list);
					includedItems_CBD.add(refundAmt_list);
					includedItems_CBD.add(auto_refund_list);
					includedItems_CBD.add(split_reqd_list);//Split reqd
					includedItems_CBD.add(includeHomeMedication_list);//sarathkumar InclHmeMedi
					includedItems_CBD.add(enableDisParam_list);//sarathkumar InclHmeMedi
					dbIncludedItem_CBD.put(prevDate,dbIncludedItems_CBD);
					includedItemsFD_CB.put(prevDate,includedItems_CBD);
					charge_type_list	=	new ArrayList();//MuthuN against 28192
					service_code_list    =	new ArrayList();
					service_desc_list	 =	new ArrayList();					
					amt_limit_ind_list  =	new ArrayList();
					amt_limit_list		 =	new ArrayList();
					//unlimited_list		 =	new ArrayList();				
					service_limit_list   =	new ArrayList();
					factorApplGroup		 =	new ArrayList();
					flag				 =	new ArrayList();
					roundToGroup		 =	new ArrayList();
					roundIndGroup		 =	new ArrayList();
					refund_list			 =	new ArrayList();
					refundAmt_list		 =	new ArrayList();	
					auto_refund_list	 =	new ArrayList();
					split_reqd_list 	 =	new ArrayList();//Split reqd
					includeHomeMedication_list 	 =	new ArrayList();//sarathkumar InclHmeMedi
					enableDisParam_list 	 =	new ArrayList();//sarathkumar InclHmeMedi
					includedItems_CBD		 =	new ArrayList();
					dbIncludedItems_CBD	 =	new ArrayList();

					}	
					charge_type_list.add(checkForNull(rs.getString("pkg_serv_ind")));//MuthuN against 28192
					System.out.println("pkg_serv_ind in DefBean.java "+rs.getString("pkg_serv_ind"));
					service_code_list.add(checkForNull(rs.getString("pkg_serv_code")));
					service_desc_list.add(checkForNull(rs.getString("service_desc")));
					amt_limit_ind_list.add(checkForNull(rs.getString("AMT_LIMIT_IND")));
					amt_limit_list.add(checkForNull(rs.getString("amt_limit")));
					//unlimited_list.add(checkForNull(rs.getString("unlimited_yn")));
					factorApplGroup.add(checkForNull(rs.getString("APPLY_FACT_FOR_SRV_LMT_YN"),"N"));
					roundToGroup.add(checkForNull(rs.getString("ROUNDING_BY_INTEGER")));
					roundIndGroup.add(checkForNull(rs.getString("ROUNDING_OPTION")));
					refund_list.add(checkForNull(rs.getString("REFUND_YN")));
					refundAmt_list.add(checkForNull(rs.getString("REFUND_RATE")));
					auto_refund_list.add(checkForNull(rs.getString("AUTO_REFUND_YN")));
					split_reqd_list.add(checkForNull(rs.getString("split_allowed_yn"),"N"));
					includeHomeMedication_list.add(checkForNull(rs.getString("INCL_HOME_MEDICATION_YN"),"N")); //sarathkumar InclHmeMedi
					enableDisParam_list.add(checkForNull(rs.getString("enableDisParam"),"N"));//sarathkumar InclHmeMedi
					if(!(checkForNull(rs.getString("service_limit")).equals("Y"))){
						service_limit_list.add("N");
					}else
						service_limit_list.add(checkForNull(rs.getString("service_limit")));
				  // includSrvicesDB_CB.put(checkForNull(rs.getString("pkg_serv_code")),"modify");
					prevDate = curDate;
					flagInd = "1";
				}
				if(service_code_list.size()>0)
				{
					includedItems_CBD.add(charge_type_list);//MuthuN against 28192
					includedItems_CBD.add(service_code_list);
					dbIncludedItems_CBD.add(service_code_list);
					includedItems_CBD.add(service_desc_list)	;					
					includedItems_CBD.add(amt_limit_ind_list);
					includedItems_CBD.add(amt_limit_list);
					//includedItems_CBD.add(unlimited_list);					
					includedItems_CBD.add(service_limit_list);
					includedItems_CBD.add(factorApplGroup);
					includedItems_CBD.add(roundToGroup);
					includedItems_CBD.add(roundIndGroup);
					includedItems_CBD.add(refund_list);
					includedItems_CBD.add(refundAmt_list);
					includedItems_CBD.add(auto_refund_list);
					includedItems_CBD.add(split_reqd_list);
					includedItems_CBD.add(includeHomeMedication_list); //sarathkumar InclHmeMedi
					includedItems_CBD.add(enableDisParam_list); //sarathkumar InclHmeMedi
					System.out.println("copyFrm_pkgCode:"+copyFrm_pkgCode);
					System.out.println("fromDate:"+fromDate);
					System.out.println("curDate:"+curDate);

					if(!copyFrm_pkgCode.equals(""))
					{
						dbIncludedItem_CBD.put(fromDate,dbIncludedItems_CBD);
						includedItemsFD_CB.put(fromDate,includedItems_CBD);
					}
					else
					{
						dbIncludedItem_CBD.put(curDate,dbIncludedItems_CBD);
						includedItemsFD_CB.put(curDate,includedItems_CBD);
					}
				}
				if(flagInd.equals("1"))
				{
					includedItems_CB.put(packageCode,includedItemsFD_CB);
					dbIncludedItems_CB.put(packageCode,dbIncludedItem_CBD);

					setIncludedItems_CB(includedItems_CB);
					setDbIncludedItems_CB(dbIncludedItems_CB);
				}
				System.out.println("getIncludedItems_CB:"+getIncludedItems_CB());
				//setIncludSrvicesDB_CB(includSrvicesDB_CB);				
				
			}
			else if(tab.equals("CHARGE_BASED_ITEM"))
			{					
				ArrayList	item_code_list    =	new ArrayList();
				ArrayList	item_desc_list	    =	new ArrayList();					
				ArrayList	qty_limit_list    =	new ArrayList();
				ArrayList	amt_limit_list    =	new ArrayList();
				ArrayList	inclExclFlag_list    =	new ArrayList();				
				ArrayList	flag				 =	new ArrayList();
				ArrayList	split_reqd_list		 =	new ArrayList();//Rajesh V - Split reqd
				ArrayList	includeHomeMedication_list		 =	new ArrayList();//sarathkumar InclHmeMedi
				ArrayList	enableDisParam_list		 =	new ArrayList();//sarathkumar InclHmeMedi
				ArrayList excludedItems_CBD =	new ArrayList();
				HashMap excludedItems_CB    =   new HashMap();	
				ArrayList dbExcludedItems_CBD =	new ArrayList();
				HashMap dbExcludedItems_CB    =   new HashMap();
				HashMap excludedItemsFD_CB   =   new HashMap();
				HashMap dbExcludedItemsFD_CB    =   new HashMap();
				String prevCode = "";
				String curCode = "";
				excludedItems_CB = 	getExcludedItems_CB();
				if(excludedItems_CB!=null && excludedItems_CB.containsKey(fromDate))
				  excludedItemsFD_CB = (HashMap) excludedItems_CB.get(fromDate);
				//System.out.println("in setDBValues,excludedItems_CB="+excludedItems_CB);
				//System.out.println("in setDBValues,excludedItemsFD_CB="+excludedItemsFD_CB);

				//HashMap excludSrvicesDB_CB  =   new HashMap();	
				//HashMap excludItemsDB_CB    =   new HashMap();	
				if(!copyFrm_pkgCode.equals("")){
				sqlStr ="SELECT a.pkg_serv_code,a.excl_serv_code excl_serv_code, b.short_desc service_desc,qty_limit, amt_limit, a.split_allowed_yn, a.INCL_HOME_MEDICATION_YN, blcommonproc.bl_pharm_service_yn('"+language_id+"',a.EXCL_SERV_IND,a.EXCL_SERV_CODE )enableDisParam, a.exclude_yn exclude_yn  FROM bl_package_exclusions a, mm_item_lang_vw b WHERE a.operating_facility_id = ? AND b.language_id = ?  AND a.package_code =?  AND a.rate_charge_ind ='C'  AND a.excl_serv_code = b.item_code  and a.eff_from_date = (select max(c.eff_from_Date) from BL_PACKAGE_PERIOD c WHERE c.operating_facility_id = a.operating_facility_id  AND c.package_code = a.package_code ) order by a.pkg_serv_code";
				}else{
				sqlStr="SELECT a.excl_serv_code excl_serv_code, b.short_desc service_desc,qty_limit, amt_limit, a.split_allowed_yn, a.INCL_HOME_MEDICATION_YN, blcommonproc.bl_pharm_service_yn('"+language_id+"',a.EXCL_SERV_IND,a.EXCL_SERV_CODE)enableDisParam, a.exclude_yn exclude_yn  FROM bl_package_exclusions a, mm_item_lang_vw b WHERE a.operating_facility_id = ? AND b.language_id = ?  AND a.package_code =? and a.pkg_serv_code= ? AND a.rate_charge_ind ='C' AND a.excl_serv_code = b.item_code  and EFF_FROM_DATE = to_date(?,'dd/mm/yyyy')";
				//sqlStr="SELECT a.excl_serv_code excl_serv_code, b.short_desc service_desc,qty_limit, amt_limit, a.exclude_yn exclude_yn  FROM bl_package_exclusions a, mm_item_lang_vw b WHERE a.operating_facility_id = ? AND b.language_id = ?  AND a.package_code =? and a.pkg_serv_code= ? AND  AND EFF_FROM_DATE = to_date(?,'dd/mm/yyyy')";
				}

				int index = 2;
				if(rs!=null) rs=null;
				if(pstmt!=null) pstmt=null;
				pstmt=connection.prepareStatement(sqlStr);				
				pstmt.setString(1,operating_facility_id);
				pstmt.setString(2,language_id);

				if(!copyFrm_pkgCode.equals("")){//have value only in insert mode if user selects a pkg code to copy from
					pstmt.setString(++index,copyFrm_pkgCode);

				}else
				{
					pstmt.setString(++index,packageCode);
					pstmt.setString(++index,parent_service_code);
					//System.out.println("in setDBValues,packageCode="+packageCode);
					pstmt.setString(++index,fromDate);
					//System.out.println("in setDBValues,fromDate="+fromDate);
				}
				rs= pstmt.executeQuery();
				while(rs.next()){
				   if(!copyFrm_pkgCode.equals(""))
				   {
					   curCode = checkForNull(rs.getString("pkg_serv_code"));
						if(!prevCode.equals("") && !prevCode.equals(curCode))
					    {
						 excludedItems_CBD.add(item_code_list);
						// dbExcludedItems_CBD.add(item_code_list);
  						 excludedItems_CBD.add(item_desc_list);					
						 excludedItems_CBD.add(qty_limit_list);
						 excludedItems_CBD.add(amt_limit_list);
						 excludedItems_CBD.add(inclExclFlag_list);
						 excludedItems_CBD.add(split_reqd_list);//Split reqd
						 	 excludedItems_CBD.add(includeHomeMedication_list);//sarathkumar InclHmeMedi
						 	excludedItems_CBD.add(enableDisParam_list);//sarathkumar InclHmeMedi
						 excludedItems_CBD.add(flag);
						 
						 excludedItemsFD_CB.put(prevCode,excludedItems_CBD);
					   //System.out.println("in setDBValues,excludedItemsFD_CB="+excludedItemsFD_CB);

						 item_code_list		=	new ArrayList();
						 item_desc_list	    =	new ArrayList();					
						 qty_limit_list		=	new ArrayList();
						 amt_limit_list		=	new ArrayList();
						 inclExclFlag_list   =	new ArrayList();				
						 flag				=	new ArrayList();
						 split_reqd_list	=	new ArrayList();//Split reqd
						  includeHomeMedication_list	=	new ArrayList();//sarathkumar InclHmeMedi
						  enableDisParam_list	=	new ArrayList();//sarathkumar InclHmeMedi
						 excludedItems_CBD	=	new ArrayList();
						}
						prevCode = curCode;
				   }

				   item_code_list.add(checkForNull(rs.getString("excl_serv_code")));
				   item_desc_list.add(checkForNull(rs.getString("service_desc")));				   
				   qty_limit_list.add(checkForNull(rs.getString("qty_limit")));
				   amt_limit_list.add(checkForNull(rs.getString("amt_limit")));	
				   inclExclFlag_list.add(checkForNull(rs.getString("exclude_yn")));				   
   				   flag.add("modify");				   
   				   split_reqd_list.add(checkForNull(rs.getString("split_allowed_yn"),"N"));//Split reqd
				   includeHomeMedication_list.add(checkForNull(rs.getString("INCL_HOME_MEDICATION_YN"),"N"));//sarathkumar InclHmeMedi
				   enableDisParam_list.add(checkForNull(rs.getString("enableDisParam"),"N"));//sarathkumar InclHmeMedi
				}
				if(item_code_list.size()>0)
				{
					excludedItems_CBD.add(item_code_list);
					dbExcludedItems_CBD.add(item_code_list);					
					excludedItems_CBD.add(item_desc_list);					
					excludedItems_CBD.add(qty_limit_list);
					excludedItems_CBD.add(amt_limit_list);
					excludedItems_CBD.add(inclExclFlag_list);					
					excludedItems_CBD.add(split_reqd_list);//Split reqd
						excludedItems_CBD.add(includeHomeMedication_list);//sarathkumar InclHmeMedi
						excludedItems_CBD.add(enableDisParam_list);//sarathkumar InclHmeMedi
					excludedItems_CBD.add(flag);
					//System.out.println("in setDBValues,excludedItems_CBD="+excludedItems_CBD);
					if(copyFrm_pkgCode.equals(""))
					{
						excludedItemsFD_CB.put(parent_service_code,excludedItems_CBD);
						dbExcludedItemsFD_CB.put(parent_service_code,dbExcludedItems_CBD);
						dbExcludedItems_CB.put(fromDate,dbExcludedItemsFD_CB);

					}
					else
					excludedItemsFD_CB.put(curCode,excludedItems_CBD);
					excludedItems_CB.put(fromDate,excludedItemsFD_CB);
					setExcludedItems_CB(excludedItems_CB);
					setDbExcludedItems_CB(dbExcludedItems_CB);
				}	
				//System.out.println("getExcludedItems_CB:"+getExcludedItems_CB());
				//System.out.println("getDbExcludedItems_CB():"+getDbExcludedItems_CB());

				//excludSrvicesDB_CB.put(parent_service_code,excludItemsDB_CB);
				//setExcludSrvicesDB_CB(excludSrvicesDB_CB);
			}
			else if(tab.equals("PACKAGE_PRICE"))
			{
				//String flagChk = "";//unused variable
				
			System.out.println("Entering PACKAGE_PRICE");

				HashMap basePrice		= new HashMap();
				HashMap basePriceDtls   = new HashMap();
				
				ArrayList dtlsArray	     =	new ArrayList();

				ArrayList blgClsCodeGrp	 =	new ArrayList();
				ArrayList blgClsDescGrp	 =	new ArrayList();
				ArrayList indicatorGrp	 =	new ArrayList();
				ArrayList price	         =	new ArrayList();
				ArrayList roundToGrp	 =	new ArrayList();
				ArrayList roundIndGrp	 =	new ArrayList();
				ArrayList factorApplGrp	 =	new ArrayList();
				ArrayList flag	         =	new ArrayList();
				ArrayList depositGrp	 =	new ArrayList();
				ArrayList partialDepGrp	 =	new ArrayList();
				ArrayList minDepAmtindGrp=	new ArrayList();
				ArrayList minDepAmtGrp	 =	new ArrayList();
				ArrayList factorforServiceRateGrp	 =	new ArrayList();//Added by muthu for Factor for service rate issue for KDAH 22-6-12

				//int index = 0;//unused variable
				//boolean flagDate = true;//unused variable
				//PreparedStatement pstmt1 	= null;
				//ResultSet rs1 		= null;	
				//Added by muthu for Factor for service rate issue for KDAH on 22-6-12 - FACTOR_FOR_SERVICE added
				sqlStr="select A.BLNG_CLASS_CODE, decode(A.BLNG_CLASS_CODE,'**','All Groups',B.LONG_DESC) LONG_DESC, A.FACTOR_RATE_IND, A.FACTOR_RATE, A.APPLY_FACT_FOR_SRV_LMT_YN, ROUNDING_BY_INTEGER, ROUNDING_OPTION,DEPOSIT_REQ_YN, ALLOW_PARTIAL_DEPOSIT_YN, MIN_PARTIAL_DEPOSIT_TYPE, MIN_PARTIAL_DEPOSIT,FACTOR_FOR_SERV_RATE from BL_PACKAGE_BASE_PRICE A,BL_BLNG_CLASS_LANG_VW B where  A.BLNG_CLASS_CODE=B.BLNG_CLASS_CODE(+) and B.LANGUAGE_ID(+)=? and A.PACKAGE_CODE=? and A.OPERATING_FACILITY_ID = ? and EFF_FROM_DATE = to_date(?,'dd/mm/yyyy')";

				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			
				pstmt=connection.prepareStatement(sqlStr);	
				pstmt.setString(1,language_id);
				pstmt.setString(2,packageCode);
				pstmt.setString(3,operating_facility_id);
				pstmt.setString(4,fromDate);
				if(rs!=null) rs.close();
				rs	= pstmt.executeQuery();
				while (rs.next())
				{
					blgClsCodeGrp.add(checkForNull(rs.getString("BLNG_CLASS_CODE")));
				    blgClsDescGrp.add(checkForNull(rs.getString("LONG_DESC")));
				    indicatorGrp.add(checkForNull(rs.getString("FACTOR_RATE_IND")));
				    price.add(checkForNull(rs.getString("FACTOR_RATE")));
				    roundToGrp.add(checkForNull(rs.getString("ROUNDING_BY_INTEGER")));
				    roundIndGrp.add(checkForNull(rs.getString("ROUNDING_OPTION")));
				    factorApplGrp.add(checkForNull(rs.getString("APPLY_FACT_FOR_SRV_LMT_YN")));
				    flag.add("modify");
					depositGrp.add(checkForNull(rs.getString("DEPOSIT_REQ_YN"),"N"));
					partialDepGrp.add(checkForNull(rs.getString("ALLOW_PARTIAL_DEPOSIT_YN"),"N"));
					minDepAmtindGrp.add(checkForNull(rs.getString("MIN_PARTIAL_DEPOSIT_TYPE")));
					minDepAmtGrp.add(checkForNull(rs.getString("MIN_PARTIAL_DEPOSIT")));					
					factorforServiceRateGrp.add(checkForNull(rs.getString("FACTOR_FOR_SERV_RATE")));
					
			 /*
					System.out.println("  blClsCode:"+blClsCode);
				   System.out.println("  blgClsDesc:"+blgClsDesc);
				   System.out.println("  priceFromDate:"+priceFromDate);
				   System.out.println("  toDate:"+toDate);
				   System.out.println("  priceToDate:"+priceToDate);
				   System.out.println("  price:"+price);
				   System.out.println("  factorAppl:"+factorAppl);
				   System.out.println("  flag:"+flag);
				   	*/
					//flagChk = "true";
				}
				if(blgClsCodeGrp.size()>0)
				{
					dtlsArray.add(blgClsCodeGrp);
					dtlsArray.add(blgClsDescGrp);
					dtlsArray.add(indicatorGrp);
					dtlsArray.add(price);
					dtlsArray.add(roundToGrp);
					dtlsArray.add(roundIndGrp);
					dtlsArray.add(factorApplGrp);
					dtlsArray.add(flag);

					dtlsArray.add(depositGrp);
					dtlsArray.add(partialDepGrp);
					dtlsArray.add(minDepAmtindGrp);
					dtlsArray.add(minDepAmtGrp);
					dtlsArray.add(factorforServiceRateGrp);//Added by muthu for Factor for service rate issue for KDAH on 22-6-12

					/*
					if(getBasePrice().size()>0)
					{
						basePrice = getBasePrice();
						if(basePrice.containsKey(packageCode))
						{
							basePriceDtls = (HashMap)basePrice.get(packageCode);
							if(basePriceDtls.containsKey(fromDate))
								basePriceDtls.remove(fromDate);
							basePrice.remove(packageCode);
						}
					}	   */
					basePriceDtls.put(fromDate,dtlsArray);
					basePrice.put(packageCode,basePriceDtls);
					setBasePrice(basePrice);
				}
				//if(!flagChk.equals(""))
				//{
					
				//}

			}
			//Started Child Packages details
			else if(tab.equals("CHILD_PACK")){			
			//	try{
				
			System.out.println("Entering CHILD_PACKAGE");

				HashMap childPackages		= new HashMap();
				ArrayList dtlsArray	     =	new ArrayList();
				HashMap childPackdtl		= new HashMap();

				ArrayList child_pkgcode	 	 =	new ArrayList();
				ArrayList child_pkgdesc	 	 =	new ArrayList();
				ArrayList child_effFromDate	 =	new ArrayList();
				ArrayList child_effToDate	 =	new ArrayList();
				ArrayList flag	         =	new ArrayList();
				sqlStr="SELECT d.operating_facility_id, d.package_code mst_pkg_code,m1.long_desc mast_package_desc, d.link_package_code child_pkg_code,m.short_desc, m.long_desc long_desc, TO_CHAR(d.eff_from_date,'DD/MM/YYYY') eff_from_date, TO_CHAR(d.eff_to_date,'DD/MM/YYYY') eff_to_date FROM bl_package_child_dtl d,bl_package m,bl_package_period p,bl_package m1 WHERE  d.operating_facility_id = m.operating_facility_id AND d.link_package_code = m.package_code AND d.operating_facility_id = p.operating_facility_id AND d.package_code = p.package_code AND d.mast_eff_from_date = p.eff_from_date AND d.operating_facility_id = m1.operating_facility_id AND d.package_code = m1.package_code AND p.operating_facility_id = ? AND p.package_code = ? AND p.eff_from_date =  TO_DATE(?,'dd/mm/yyyy')";


				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			
				pstmt=connection.prepareStatement(sqlStr);	
				pstmt.setString(1,operating_facility_id);
				pstmt.setString(2,packageCode);
				pstmt.setString(3,fromDate);
				System.out.println("PkgdefBean -after PACKAGE_PRICE sqlStr-->"+sqlStr);
				if(rs!=null) rs.close();
				System.out.println("PkgdefBean -Before PACKAGE_PRICE-->"+sdf.format(c.getTime()));
				rs	= pstmt.executeQuery();
				
				while (rs.next())
				{
					
					child_pkgcode.add(checkForNull(rs.getString("child_pkg_code")));
				    child_pkgdesc.add(checkForNull(rs.getString("LONG_DESC")));
					child_effFromDate.add((checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("eff_from_date"),"DMY","en",language_id))));
					child_effToDate.add((checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("eff_to_date"),"DMY","en",language_id))));
					flag.add("modify");
				 			
				}
				if(child_pkgcode.size()>0)
				{
					dtlsArray.add(child_pkgcode);
					dtlsArray.add(child_pkgdesc);
					dtlsArray.add(child_effFromDate);
					dtlsArray.add(child_effToDate);
					dtlsArray.add(flag);

					//basePriceDtls.put(fromDate,dtlsArray);
					//basePrice.put(packageCode,basePriceDtls);
					//childPackages.put(fromDate,dtlsArray);
					childPackdtl.put(fromDate,dtlsArray);
					childPackages.put(packageCode,childPackdtl);
					setChildPackages(childPackages);
				}
			}
		}
	}	
	/******** rate Based values*********end****/

	public String getPriceClsDesc(String priceClsCode,String packageCode,String language_id,String operating_facility_id) throws Exception
	{
		Connection connection 		= getConnection();	
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;	
		String priceClsDesc = "";
		try
		{
			String sql = "select SHORT_DESC from bl_price_class_lang_vw where PRICE_CLASS_CODE =? and OPERATING_FACILITY_ID = ? and LANGUAGE_ID = ?";
			pstmt=connection.prepareStatement(sql);	
			pstmt.setString(1,priceClsCode);
			pstmt.setString(2,operating_facility_id);
			pstmt.setString(3,language_id);
			rs = pstmt.executeQuery();
			if (rs.next())
				priceClsDesc = rs.getString("SHORT_DESC");		

		}
		catch(Exception e)
		{
			System.out.println("Exception from getPriceClsDesc :"+e);
				e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
		}
		return priceClsDesc;
	}

	public boolean packageApprovalStatus(String userId,String operating_facility_id) throws Exception
	{
		Connection connection 		= getConnection();	
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;	
		boolean status = false;
		try
		{
			String sql = "select nvl(package_approval,'N') status from bl_user where bl_user_id=? and operating_facility_id=?";
			pstmt=connection.prepareStatement(sql);	
			pstmt.setString(1,userId);
			pstmt.setString(2,operating_facility_id);
			rs = pstmt.executeQuery();
			if (rs.next())
				status = (boolean)(rs.getString("status").equals("N")? false : true);
		}
		catch(Exception e)
		{
			System.out.println("Exception from packageApprovalStatus :"+e);
				e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
		}
		return status ;
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
	
	public String getGLSmryYN(String facility_id) throws Exception
	{
		Connection connection 		= getConnection();	
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;	
		String glSmryYN = "";
		try
		{
			String sql = "select GL_POST_FOR_PKG_BY_SUMMARY_YN from  bl_parameters where operating_facility_id=?";
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1,facility_id);			
			rs = pstmt.executeQuery();
			if (rs.next())
				glSmryYN = rs.getString("GL_POST_FOR_PKG_BY_SUMMARY_YN");
		}
		catch(Exception e)
		{
			System.out.println("Exception from getGLSmryYN()= :"+e);
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
		}
		return glSmryYN ;
	}

	public boolean packageCreationRight(String userId,String operating_facility_id) throws Exception
	{
		Connection connection 		= getConnection();	
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;	
		boolean status = false;
		try
		{
			String sql = "select blpackage.can_user_create_pkg(?,?) status from dual";
			pstmt=connection.prepareStatement(sql);	
			pstmt.setString(1,operating_facility_id);
			pstmt.setString(2,userId);

			rs = pstmt.executeQuery();
			if (rs.next())
				status = (boolean)(rs.getString("status").equals("N")? false : true);
		}
		catch(Exception e)
		{
			System.out.println("Exception from packageCreationRight :"+e);
				e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
		}			
		return status ;
	}

	public String packageApprovedYN(String packageCode,String operating_facility_id) throws Exception
	{
		Connection connection 		= getConnection();	
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;	
		String pkgApprovedYN = "N";
		try
		{
			String sql = "select APPROVED_YN from bl_package where OPERATING_FACILITY_ID=? and  PACKAGE_CODE=?";
			pstmt=connection.prepareStatement(sql);	
			pstmt.setString(1,operating_facility_id);
			pstmt.setString(2,packageCode);

			rs = pstmt.executeQuery();
			if (rs.next())
				pkgApprovedYN =rs.getString("APPROVED_YN");
		}
		catch(Exception e)
		{
			System.out.println("Exception from packageApprovedYN :"+e);
				e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
		}			
		return pkgApprovedYN ;
	}
	/*Karthik added the code here MMS-CRF-0023*/
	
	HashMap<String,ArrayList<String>> partialDepositList=new HashMap<String,ArrayList<String>>();
	
	public HashMap<String,ArrayList<String>> getPartialDepositList() {
		return partialDepositList;
	}

	public void setPartialDepositList(HashMap<String,ArrayList<String>> partialDepositList) {
		this.partialDepositList = partialDepositList;
	}		
	
	public void fetchPartialDepositList(String billingClassCode,String operatingFacilityId,String packageCode,String effFromDate) throws Exception
	{
		Connection connection 		= getConnection();	
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;	
		ArrayList<String> records=new ArrayList<String>();
		try
		{
			String sql = "select ENCOUNTER_SEQ_NO,MIN_PARTIAL_DEPOSIT_TYPE,MIN_PARTIAL_DEPOSIT,DEPOSIT_MANDATORY_YN from bl_package_deposit_dtls where BLNG_CLASS_CODE=? and OPERATING_FACILITY_ID=? and PACKAGE_CODE=? and to_char(EFF_FROM_DATE,'dd/mm/yyyy')=? ";
			pstmt=connection.prepareStatement(sql);	
			pstmt.setString(1,billingClassCode);
			pstmt.setString(2,operatingFacilityId);
			pstmt.setString(3,packageCode);
			pstmt.setString(4,effFromDate);			
			rs = pstmt.executeQuery();
			if(rs!=null)
			while (rs.next()) {
				String data=rs.getString(1)+"~"+rs.getString(2)+"~"+rs.getString(3)+"~"+rs.getString(4);
				records.add(data);
			}
			if(records.size()>0)
			this.partialDepositList.put(billingClassCode, records);	
		}
		catch(Exception e)
		{
			System.out.println("Exception from packageCreationRight :"+e);
				e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
		}
	}
	
	/*Karthik added the code here MMS-CRF-0023*/
	
	public HashMap getExistingPackageDates(String packageCode,String operating_facility_id,String language_id) throws Exception{
		System.out.println("getExistingPackageDates ............."+packageCode+"/"+operating_facility_id+"/"+language_id);
		Connection connection 		= null;		
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;		
		connection 		= getConnection();	
		String sqlStr="";	
		//Modified Query V180122-Gayathri/MMS-DM-CRF-0118
		sqlStr ="SELECT TO_CHAR (a.eff_from_date, 'DD/MM/YYYY') eff_from_date,TO_CHAR (a.eff_to_date, 'DD/MM/YYYY') eff_to_date, a.pkg_price_class_code pkg_price_class_code,a.outside_pkg_price_class_code outside_pkg_price_class_code,a.gl_post_ac_for_pkg gl_post_ac_for_pkg,(SELECT acc_int_desc FROM bl_gl_account_lang_vw WHERE acc_int_code = a.gl_post_ac_for_pkg AND language_id = ?  AND acc_entity_code =  (SELECT acc_entity_code  FROM sy_acc_entity b  WHERE b.acc_entity_id =?)) ACC_INT_DESC,GL_POST_AC_FOR_DISC GL_POST_AC_FOR_DISC,(SELECT acc_int_desc FROM bl_gl_account_lang_vw WHERE acc_int_code = a.gl_post_ac_for_disc AND language_id = ?  AND acc_entity_code =  (SELECT acc_entity_code  FROM sy_acc_entity b  WHERE b.acc_entity_id =?)) ACC_INT_DISC_DESC , ADDL_CHG_APPLICABLE_YN ADDL_CHG_APPLICABLE_YN, ADDL_CHG_RULE_CODE ADDL_CHG_RULE_CODE FROM bl_package_period a WHERE a.package_code = ? AND a.operating_facility_id = ?";

		try
		{
			//System.out.println("sqlStr:"+sqlStr);
			pstmt=connection.prepareStatement(sqlStr);	
			pstmt.setString(1,language_id);
			pstmt.setString(2,operating_facility_id);
			pstmt.setString(3,language_id);
			pstmt.setString(4,operating_facility_id);
			pstmt.setString(5,packageCode);
			pstmt.setString(6,operating_facility_id);
			rs = pstmt.executeQuery();
			String 	priceClsCode ="";
			String 	priceClsDesc ="";
			String 	outPriceClsCode ="";
			String 	outPriceClsDesc ="";
			String 	glSmry ="";
			String 	glSmryDesc ="";
			String 	glSmryDisc ="";
			String 	glSmryDiscDesc ="";	
			//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts
			String 	VATapplicable ="";
			String 	VATapplicable_old ="";
			String 	VATpercentage ="";
			//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends
			ArrayList dtlsArray	     =	new ArrayList();
			ArrayList priceFromDate  =	new ArrayList();
			ArrayList priceToDate	 =	new ArrayList();
			ArrayList pkgPClsCode	 =	new ArrayList();
			ArrayList pkgPClsDesc	 =	new ArrayList();
			ArrayList oPkgPClsCode	 =	new ArrayList();
			ArrayList oPkgPClsDesc	 =	new ArrayList();
			ArrayList glSmryList	 =	new ArrayList();
			ArrayList glSmryDescList =	new ArrayList();
			ArrayList glSmryDiscList	 =	new ArrayList();
			ArrayList glSmryDiscDescList =	new ArrayList();
			ArrayList flag	         =	new ArrayList();
			//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts
			ArrayList VATappList	 =	new ArrayList();
			ArrayList VATappList_old	 =	new ArrayList();
			ArrayList VATpercentList	 =	new ArrayList();
			//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends
			//ArrayList statusToModify =  new ArrayList();
			while (rs.next())
			{ 
				priceFromDate.add((checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("EFF_FROM_DATE"),"DMY","en",language_id))));
				priceToDate.add((checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("EFF_TO_DATE"),"DMY","en",language_id))));
				priceClsCode = (checkForNull(rs.getString("PKG_PRICE_CLASS_CODE")));
				pkgPClsCode.add(priceClsCode);
				if(priceClsCode.equals(""))
				  priceClsDesc = "";
				else
					priceClsDesc = getPriceClsDesc(priceClsCode,packageCode,language_id,operating_facility_id);
				//System.out.println("priceClsDesc from func:"+priceClsDesc);

				pkgPClsDesc.add(priceClsDesc);
				outPriceClsCode = (checkForNull(rs.getString("OUTSIDE_PKG_PRICE_CLASS_CODE")));
				oPkgPClsCode.add(outPriceClsCode);
				if(outPriceClsCode.equals(""))
				  outPriceClsDesc = "";
				else
					outPriceClsDesc = getPriceClsDesc(outPriceClsCode,packageCode,language_id,operating_facility_id);
			//System.out.println("outPriceClsDesc from func:"+outPriceClsDesc);

				oPkgPClsDesc.add(outPriceClsDesc);
				glSmry = (checkForNull(rs.getString("GL_POST_AC_FOR_PKG")));
				glSmryList.add(glSmry);
				glSmryDesc = (checkForNull(rs.getString("ACC_INT_DESC")));
				glSmryDescList.add(glSmryDesc);

				glSmryDisc = (checkForNull(rs.getString("GL_POST_AC_FOR_DISC")));
				glSmryDiscList.add(glSmryDisc);
				glSmryDiscDesc = (checkForNull(rs.getString("ACC_INT_DISC_DESC")));
				glSmryDiscDescList.add(glSmryDiscDesc);
				//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts
				VATapplicable = (checkForNull(rs.getString("ADDL_CHG_APPLICABLE_YN")));
				VATappList.add(VATapplicable);
				VATpercentage = (checkForNull(rs.getString("ADDL_CHG_RULE_CODE")));
				VATpercentList.add(VATpercentage);
				VATapplicable_old = (checkForNull(rs.getString("ADDL_CHG_APPLICABLE_YN")));
				VATappList_old.add(VATapplicable_old);
				flag.add("modify");
				System.out.println("getExistingPackageDates ...... priceFromDate "+priceFromDate);
			}
			if(priceFromDate!=null && priceFromDate.size()>0)
			{				
				System.out.println("getExistingPackageDates ...... priceFromDate "+priceFromDate);
				dtlsArray.add(priceFromDate);
				dtlsArray.add(priceToDate);
				dtlsArray.add(pkgPClsCode);
				dtlsArray.add(pkgPClsDesc);
				dtlsArray.add(oPkgPClsCode);
				dtlsArray.add(oPkgPClsDesc);
				dtlsArray.add(flag);
				dtlsArray.add(glSmryList);
				dtlsArray.add(glSmryDescList);
				dtlsArray.add(glSmryDiscList);
				dtlsArray.add(glSmryDiscDescList);
				//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts
				dtlsArray.add(VATappList);
				dtlsArray.add(VATpercentList);
				dtlsArray.add(VATappList_old);
				//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends
				existingPkgBaseDates.put(packageCode,dtlsArray);
				setExistingPkgBaseDates(existingPkgBaseDates);				
			}		
		}
		catch(Exception e)
		{
			System.out.println("Exception in getExistingPackageDates :"+e);
				e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
		}
		return existingPkgBaseDates;
	}

	public String setPrevDateFromBean(String tab,String packageCode,String language_id,String operating_facility_id, String parent_service_code,String copyFrm_pkgCode,String newDate) throws Exception{
		System.out.println("setPrevDateFromBean ...... tab /packageCode /language_id /operating_facility_id /newDate "+tab+"/"+packageCode+"/"+language_id+"/"+operating_facility_id+"/"+newDate);;
		Connection connection 		= null;		
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;		
		String sqlStr="";	
		String dateFlag="N";
		try{			
			connection = getConnection();		
			
			if(tab.equals("RATE_BASED"))
			{	
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
				ArrayList 	split_reqd_list = new ArrayList();	//Rajesh V - Split reqd
				ArrayList 	includeHomeMedication_list = new ArrayList();	//sarathkumar InclHmeMedi
				ArrayList 	dummyList = new ArrayList();//Added V190416-Aravindh/MMS-DM-CRF-0129
				ArrayList 	dailyLmtChkBxList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
				ArrayList 	dailyLmtAmtList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
				ArrayList 	dailyLmtGrossNetList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
				ArrayList	dailyLmtIndicatorList = new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				ArrayList	dailyLmtQtyList = new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				ArrayList	group_service_ind_list		=	new ArrayList();	//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
				ArrayList   includedItems_RBD		=	new ArrayList();
//				ArrayList   dbIncludedItems_RBD		=	new ArrayList();
//				HashMap		dbIncludedItem_RBD		=   new HashMap();		
				HashMap		includedItems_RB		=   getIncludedItems_RB();//new HashMap();	
				HashMap		includedItemsFD_RB=null;
//				HashMap		dbIncludedItems_RB		=   new HashMap();
				if(includedItems_RB==null || includedItems_RB.isEmpty()){
					includedItemsFD_RB		= new HashMap();
				}
				else{
				includedItemsFD_RB		=   (HashMap) getIncludedItems_RB().get(packageCode) ; //new HashMap();//getIncludedItems_RB();
				}
				String flagInd = "";
				//includedItems_RB    =  getIncludedItems_RB();
				String prevDate = "";
				String curDate = "";
				sqlStr ="SELECT to_date(a.EFF_FROM_DATE,'dd/mm/yyyy') EFF_FROM_DATE,to_char(a.EFF_FROM_DATE,'dd/mm/yyyy') EFF_FROM_DATE1, a.CLOSE_PACKAGE_YN,ROUNDING_BY_INTEGER, ROUNDING_OPTION, AUTO_REFUND_YN,pkg_serv_ind, pkg_serv_code, b.service_desc, a.order_catalog_code order_catalog_code, (select short_desc from or_order_catalog_lang_vw where LANGUAGE_ID=? AND order_catalog_code= a.order_catalog_code) order_catalog_desc,rate_ind, factor_rate, qty_limit, AMT_LIMIT_IND, amt_limit,AMT_LIMIT_IND , replaceable_yn, replaceable_serv_code, (select short_desc from BL_BLNG_SERV_lang_vw where LANGUAGE_ID=? AND blng_serv_code= a.replaceable_serv_code) replaceable_serv_desc, rep_serv_ord_cat_code,(select short_desc from or_order_catalog_lang_vw where LANGUAGE_ID=? AND order_catalog_code= a.rep_serv_ord_cat_code)  rep_serv_ord_cat_desc, refund_yn, REFUND_RATE,a.apply_fact_for_srv_lmt_yn factor_appl, a.split_allowed_yn, a.INCL_HOME_MEDICATION_YN,  (select 'Y' from bl_package_exclusions where operating_facility_id=a.operating_facility_id AND package_code=a.package_code AND pkg_serv_code=a.pkg_serv_code and rownum=1) service_limit, NVL(DAILY_AMT_LIMIT_YN,'N') DAILY_AMT_LIMIT_YN, DAILY_AMT_LIMIT, DAILY_AMT_LIMIT_GROSS_NET, NVL(DAILY_LIMIT_IND,'*') DAILY_LIMIT_IND, DAILY_QTY_LIMIT,GROUP_SERVICE_IND FROM bl_package_dtls a,(select 'S' Serv_Ind, blng_serv_code code, short_desc service_desc,language_id,status from BL_BLNG_SERV_lang_vw  union all select 'C' serv_ind, serv_classification_code code, short_desc service_desc,language_id,status from BL_SERV_CLASSIFICATION_lang_vw union all select 'P' serv_ind,package_serv_group_code code,   short_desc description, 'en', null status from bl_package_serv_group_hdr WHERE operating_facility_id = '"+operating_facility_id+"'  union all select 'G' serv_ind, serv_grp_code code, short_desc service_desc,language_id,status from bl_blng_serv_grp_lang_vw) b WHERE a.operating_facility_id = ?  AND b.status is null AND a.package_code = ? AND a.rate_charge_ind = ? AND a.pkg_serv_code=b.code AND a.pkg_serv_ind=b.Serv_Ind AND b.language_id=? ANd a.eff_from_date = (select max(c.eff_from_Date) from BL_PACKAGE_PERIOD c WHERE c.operating_facility_id = a.operating_facility_id  AND c.package_code = a.package_code )  order by EFF_FROM_DATE"; //V211130
				if(rs!=null) rs=null;
				if(pstmt!=null) pstmt=null;
			
				pstmt=connection.prepareStatement(sqlStr);	
				pstmt.setString(1,language_id);
				pstmt.setString(2,language_id);
				pstmt.setString(3,language_id);
				pstmt.setString(4,operating_facility_id);
				if(!copyFrm_pkgCode.equals("")){//have value only in insert mode if user selects a pkg code to copy from
					pstmt.setString(5,copyFrm_pkgCode);
				}else
					pstmt.setString(5,packageCode);
				pstmt.setString(6,"R");
				pstmt.setString(7,language_id);
				//pstmt.setString(8,newDate);
				rs	= pstmt.executeQuery();
				while (rs.next()){
					
					curDate = newDate; //checkForNull(rs.getString("EFF_FROM_DATE1"));
					if(!prevDate.equals("") && !(curDate.equals(prevDate))  && copyFrm_pkgCode.equals("") ) {
					includedItems_RBD.add(type_list);
					includedItems_RBD.add(service_code_list);
//					dbIncludedItems_RBD.add(service_code_list);					
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
					includedItems_RBD.add(split_reqd_list);//Split reqd
					includedItems_RBD.add(includeHomeMedication_list);//sarathkumar InclHmeMedi
					includedItems_RBD.add(dummyList);//Added V190416-Aravindh/MMS-DM-CRF-0129
					includedItems_RBD.add(dailyLmtChkBxList);//Added V190320-Aravindh/MMS-DM-CRF-0129
					includedItems_RBD.add(dailyLmtAmtList);//Added V190320-Aravindh/MMS-DM-CRF-0129
					includedItems_RBD.add(dailyLmtGrossNetList);//Added V190320-Aravindh/MMS-DM-CRF-0129
					includedItems_RBD.add(dailyLmtIndicatorList);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
					includedItems_RBD.add(dailyLmtQtyList);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
					includedItems_RBD.add(group_service_ind_list);//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
		//System.out.println("1012 in bean,includedItems_RBD="+includedItems_RBD.toString());
//					dbIncludedItem_RBD.put(prevDate,dbIncludedItems_RBD);
					includedItemsFD_RB.put(prevDate,includedItems_RBD);
					dateFlag="Y";
					
					type_list				=	new ArrayList();
					service_code_list		=	new ArrayList();
					service_desc_list	    =	new ArrayList();
					catalog_code_list		=	new ArrayList();
					catalog_desc_list		=	new ArrayList();
					ind_list				=	new ArrayList();
					factorOrRate_list		=	new ArrayList();
					qty_limit_list			=	new ArrayList();
					amt_limit_ind_list		=	new ArrayList();
					amt_limit_list			=	new ArrayList();
					replace_list			=	new ArrayList();
					replaceSrv_code_list    =	new ArrayList();
					replaceSrv_desc_list    =	new ArrayList();
					replaceSrv_cat_code_list=	new ArrayList();
					replaceSrv_cat_desc_list=	new ArrayList();
					refund_list				=	new ArrayList();
					refundAmt_list			=	new ArrayList();	
					factor_appl_list		=	new ArrayList();	
					service_limit_list		=	new ArrayList();
					auto_refund_list		=	new ArrayList();
					roundTo_list			=	new ArrayList();
					roundInd_list			=	new ArrayList();
					closePkg_list			=	new ArrayList();
					split_reqd_list			=	new ArrayList();//Split reqd
					includeHomeMedication_list			=	new ArrayList();//sarathkumar InclHmeMedi
					dummyList = new ArrayList();//Added V190416-Aravindh/MMS-DM-CRF-0129
					dailyLmtChkBxList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
					dailyLmtAmtList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
					dailyLmtGrossNetList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
					dailyLmtIndicatorList = new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
					dailyLmtQtyList = new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
					group_service_ind_list		=	new ArrayList();//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
					includedItems_RBD		=	new ArrayList();
//					dbIncludedItems_RBD		=	new ArrayList();

					} 
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
					//System.out.println("CLOSE_PACKAGE_YN in DefBean.java ==> "+closePkg_list);
					split_reqd_list.add(checkForNull(rs.getString("split_allowed_yn"),"N"));//Split reqd
					includeHomeMedication_list.add(checkForNull(rs.getString("INCL_HOME_MEDICATION_YN"),"N"));//sarathkumar InclHmeMedi
					dummyList.add("");//Added V190416-Aravindh/MMS-DM-CRF-0129
					dailyLmtChkBxList.add(checkForNull(rs.getString("DAILY_AMT_LIMIT_YN"),"N"));//Added V190320-Aravindh/MMS-DM-CRF-0129
					dailyLmtAmtList.add(checkForNull(rs.getString("DAILY_AMT_LIMIT")));//Added V190320-Aravindh/MMS-DM-CRF-0129
					dailyLmtGrossNetList.add(checkForNull(rs.getString("DAILY_AMT_LIMIT_GROSS_NET")));//Added V190320-Aravindh/MMS-DM-CRF-0129
					dailyLmtIndicatorList.add(checkForNull(rs.getString("DAILY_LIMIT_IND")));//Added V190626-Aravindh/MMS-DM-CRF-0129.1
					dailyLmtQtyList.add(checkForNull(rs.getString("DAILY_QTY_LIMIT")));//Added V190626-Aravindh/MMS-DM-CRF-0129.1
					group_service_ind_list.add(checkForNull(rs.getString("GROUP_SERVICE_IND")));//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
					if(!checkForNull(rs.getString("service_limit")).equals("Y")){
						service_limit_list.add("N");
					}else
						service_limit_list.add(checkForNull(rs.getString("service_limit")));
					prevDate = curDate;
					flagInd = "1";
				}
				if(service_code_list.size()>0)
				{					
					includedItems_RBD.add(type_list)	;
					includedItems_RBD.add(service_code_list);
//					dbIncludedItems_RBD.add(service_code_list);					
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
					System.out.println("closePkg_list 1103 :"+closePkg_list);
					includedItems_RBD.add(split_reqd_list);//Split reqd
					includedItems_RBD.add(includeHomeMedication_list);//sarathkumar InclHmeMedi
					includedItems_RBD.add(dummyList);//Added V190416-Aravindh/MMS-DM-CRF-0129
					includedItems_RBD.add(dailyLmtChkBxList);//Added V190320-Aravindh/MMS-DM-CRF-0129
					includedItems_RBD.add(dailyLmtAmtList);//Added V190320-Aravindh/MMS-DM-CRF-0129
					includedItems_RBD.add(dailyLmtGrossNetList);//Added V190320-Aravindh/MMS-DM-CRF-0129
					includedItems_RBD.add(dailyLmtIndicatorList);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
					includedItems_RBD.add(dailyLmtQtyList);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
					includedItems_RBD.add(group_service_ind_list);//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
					if(!copyFrm_pkgCode.equals(""))
					{
//						dbIncludedItem_RBD.put(newDate,dbIncludedItems_RBD);
						includedItemsFD_RB.put(newDate,includedItems_RBD);
						dateFlag="Y";
					}
					else
					{
//						dbIncludedItem_RBD.put(curDate,dbIncludedItems_RBD);
						includedItemsFD_RB.put(curDate,includedItems_RBD);
						dateFlag="Y";
					}
				}
				if(flagInd.equals("1"))
				{
					includedItems_RB.put(packageCode,includedItemsFD_RB);
					dateFlag="Y";
//					dbIncludedItems_RB.put(packageCode,dbIncludedItem_RBD);
					setIncludedItems_RB(includedItems_RB);	
//					setDbIncludedItems_RB(dbIncludedItems_RB);		
				}
			}
			else if(tab.equals("SRVLIMIT_RATE_BASED"))
			{
				ArrayList	srvLimit_type_list			=	new ArrayList();
				ArrayList	srvLimit_service_code_list  =	new ArrayList();
				ArrayList	srvLimit_service_desc_list	=	new ArrayList();
				ArrayList	exludeService_list		    =	new ArrayList();
				ArrayList	srvLimit_qty_limit_list		=	new ArrayList();
				ArrayList	srvLimit_amt_limit_list		=	new ArrayList();
				ArrayList	srvLimit_factor_appl_list	=	new ArrayList();
				ArrayList   amt_limit_ind_list			=	new ArrayList();
				ArrayList	replace_list				=	new ArrayList();
				ArrayList	replaceSrv_code_list		=	new ArrayList();
				ArrayList	replaceSrv_desc_list		=	new ArrayList();
				ArrayList   refund_list					=	new ArrayList();
				ArrayList   refundAmt_list				=	new ArrayList();
				ArrayList   auto_refund_list			=	new ArrayList();
				ArrayList   roundTo_list				=	new ArrayList();
				ArrayList   roundInd_list				=	new ArrayList();
				ArrayList 	split_reqd_list = new ArrayList();	//Rajesh V - Split reqd
				ArrayList 	includeHomeMedication_list = new ArrayList();	//sarathkumar InclHmeMedi
				ArrayList 	dummyList = new ArrayList();//Added V190416-Aravindh/MMS-DM-CRF-0129
				ArrayList 	dailyLmtChkBxList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
				ArrayList 	dailyLmtAmtList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
				ArrayList 	dailyLmtGrossNetList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
				ArrayList 	dailyLmtIndicatorList = new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				ArrayList 	dailyLmtQtyList = new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				//ArrayList   group_service_ind_list			=	new ArrayList();//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 --> commented against checkStyle
					
				ArrayList excludedItems_RBD =	new ArrayList();
//				ArrayList dbExcludedItems_RBD =	new ArrayList();
				HashMap excludedItems_RB    =   getExcludedItems_RB();//new HashMap();
				HashMap excludedItemsFD_RB=null;
				if(excludedItems_RB==null || excludedItems_RB.isEmpty()){
					excludedItemsFD_RB=new HashMap();
				 	
				}
				else{
					excludedItemsFD_RB    = (HashMap) getExcludedItems_RB().get(newDate);// new HashMap();	
				}
//				HashMap dbExcludedItems_RB    =   new HashMap();
//				HashMap dbExcludedItemsFD_RB   =   new HashMap();
				excludedItems_RB = getExcludedItems_RB();
				if(excludedItems_RB!=null && excludedItems_RB.containsKey(newDate)){
				  excludedItemsFD_RB = (HashMap) getExcludedItems_RB().get(newDate);// new HashMap();
				}
				else{
					excludedItemsFD_RB = new HashMap();
				}
//				dbExcludedItems_RB = getDbExcludedItems_RB();
//				if(dbExcludedItems_RB!=null && dbExcludedItems_RB.containsKey(newDate))
//				  dbExcludedItemsFD_RB = (HashMap) dbExcludedItems_RB.get(newDate);
				String prevCode = "";
				String curCode = "";
				int index = 3;		

				sqlStr ="SELECT  a.pkg_serv_code,a.excl_serv_ind excl_serv_ind,a.excl_serv_code excl_serv_code, b.service_desc service_desc,a.exclude_yn exclude_yn, qty_limit, amt_limit,a.apply_fact_for_srv_lmt_yn factor_appl,AMT_LIMIT_IND, REPLACEABLE_YN, REPLACEABLE_SERV_CODE, (select short_desc from BL_BLNG_SERV_lang_vw where LANGUAGE_ID=? AND blng_serv_code= REPLACEABLE_SERV_CODE) replaceable_serv_desc, REFUND_YN, REFUND_RATE, ROUNDING_BY_INTEGER, ROUNDING_OPTION, a.split_allowed_yn, a.INCL_HOME_MEDICATION_YN, AUTO_REFUND_YN, NVL(DAILY_AMT_LIMIT_YN,'N') DAILY_AMT_LIMIT_YN, DAILY_AMT_LIMIT, DAILY_AMT_LIMIT_GROSS_NET, NVL(DAILY_LIMIT_IND,'*') DAILY_LIMIT_IND, DAILY_QTY_LIMIT FROM bl_package_exclusions a, (select 'S' Serv_Ind, blng_serv_code code, short_desc service_desc,language_id from BL_BLNG_SERV_lang_vw union all select 'P' Serv_Ind, package_serv_group_code code, short_desc service_desc, 'en' from bl_package_serv_group_hdr WHERE operating_facility_id = '"+operating_facility_id+"' union all select 'T' Serv_Ind, sale_category_code code, short_desc service_desc, 'en' from bl_st_item_sale_catg_hdr union all select 'G' Serv_Ind, serv_grp_code code, short_desc description, language_id from bl_blng_serv_grp_lang_vw union all  select 'C' Serv_Ind, serv_classification_code code, short_desc service_desc,language_id from BL_SERV_CLASSIFICATION_lang_vw union all select 'M' Serv_Ind, item_code code, short_desc service_desc,language_id from MM_ITem_lang_vw) b WHERE a.operating_facility_id = ?    AND a.package_code = ? and  a.excl_serv_code=b.code  AND a.excl_serv_ind=b.Serv_Ind   AND b.language_id=? ANd a.eff_from_date = (select max(c.eff_from_Date) from BL_PACKAGE_PERIOD c WHERE c.operating_facility_id = a.operating_facility_id  AND c.package_code = a.package_code ) order by 1,2,4,3"; //V211130

				if(rs!=null) rs=null;
				if(pstmt!=null) pstmt=null;
				pstmt=connection.prepareStatement(sqlStr);
				pstmt.setString(1,language_id);
				pstmt.setString(2,operating_facility_id);
				if(!copyFrm_pkgCode.equals("")){//have value only in insert mode if user selects a pkg code to copy from
					pstmt.setString(3,copyFrm_pkgCode);
				}else
				{
					pstmt.setString(3,packageCode);
				}
				pstmt.setString(++index,language_id);
				
				rs = pstmt.executeQuery();
				while (rs.next())
				{
					curCode = checkForNull(rs.getString("pkg_serv_code"));
						if(!prevCode.equals("") && !prevCode.equals(curCode))
						{
							excludedItems_RBD.add(srvLimit_type_list);
							excludedItems_RBD.add(srvLimit_service_code_list);
							//dbExcludedItems_RBD.add(srvLimit_service_code_list);
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
							excludedItems_RBD.add(replaceSrv_desc_list);
							excludedItems_RBD.add(split_reqd_list);//Split reqd
							excludedItems_RBD.add(includeHomeMedication_list);//sarathkumar InclHmeMedi
							excludedItems_RBD.add(dummyList);//Added V190416-Aravindh/MMS-DM-CRF-0129
							excludedItems_RBD.add(dailyLmtChkBxList);//Added V190320-Aravindh/MMS-DM-CRF-0129
							excludedItems_RBD.add(dailyLmtAmtList);//Added V190320-Aravindh/MMS-DM-CRF-0129
							excludedItems_RBD.add(dailyLmtGrossNetList);//Added V190320-Aravindh/MMS-DM-CRF-0129
							excludedItems_RBD.add(dailyLmtIndicatorList);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
							excludedItems_RBD.add(dailyLmtQtyList);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
								
							excludedItemsFD_RB.put(prevCode,excludedItems_RBD);
							dateFlag="Y";
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
							excludedItems_RBD			=	new ArrayList();
							split_reqd_list				=	new ArrayList();//Split reqd
							includeHomeMedication_list	=	new ArrayList();//sarathkumar InclHmeMedi
							dummyList					=	new ArrayList();//Added V190416-Aravindh/MMS-DM-CRF-0129
							dailyLmtChkBxList 			= 	new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
							dailyLmtAmtList 			= 	new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
							dailyLmtGrossNetList 		= 	new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
							dailyLmtIndicatorList 		= 	new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
							dailyLmtQtyList 			= 	new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
						}
						prevCode = curCode;

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
				   refund_list.add(checkForNull(rs.getString("REFUND_YN")));
				   refundAmt_list.add(checkForNull(rs.getString("REFUND_RATE")));				   
				   auto_refund_list.add(checkForNull(rs.getString("AUTO_REFUND_YN")));				   
				   roundTo_list.add(checkForNull(rs.getString("ROUNDING_BY_INTEGER")));				   
				   roundInd_list.add(checkForNull(rs.getString("ROUNDING_OPTION")));				   
				   replaceSrv_desc_list.add(checkForNull(rs.getString("replaceable_serv_desc")));	
				   split_reqd_list.add(checkForNull(rs.getString("split_allowed_yn"),"N"));//Split reqd
				   includeHomeMedication_list.add(checkForNull(rs.getString("INCL_HOME_MEDICATION_YN"),"N"));//sarathkumar InclHmeMedi
				   dummyList.add("");//Added V190416-Aravindh/MMS-DM-CRF-0129
				   dailyLmtChkBxList.add(checkForNull(rs.getString("DAILY_AMT_LIMIT_YN"),"N"));//Added V190320-Aravindh/MMS-DM-CRF-0129
				   dailyLmtAmtList.add(checkForNull(rs.getString("DAILY_AMT_LIMIT")));//Added V190320-Aravindh/MMS-DM-CRF-0129
				   dailyLmtGrossNetList.add(checkForNull(rs.getString("DAILY_AMT_LIMIT_GROSS_NET")));//Added V190320-Aravindh/MMS-DM-CRF-0129
				   dailyLmtIndicatorList.add(checkForNull(rs.getString("DAILY_LIMIT_IND")));//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				   dailyLmtQtyList.add(checkForNull(rs.getString("DAILY_QTY_LIMIT")));//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				    
				}
				//System.out.println("in setDBValues,srvLimit_service_code_list="+srvLimit_service_code_list);
				if(srvLimit_service_code_list.size()>0)
				{
					excludedItems_RBD.add(srvLimit_type_list)	;
					excludedItems_RBD.add(srvLimit_service_code_list);
//					dbExcludedItems_RBD.add(srvLimit_service_code_list);
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
					excludedItems_RBD.add(replaceSrv_desc_list);
					excludedItems_RBD.add(split_reqd_list);//Split reqd
					excludedItems_RBD.add(includeHomeMedication_list);//sarathkumar InclHmeMedi
					excludedItems_RBD.add(dummyList);//Added V190416-Aravindh/MMS-DM-CRF-0129
					excludedItems_RBD.add(dailyLmtChkBxList);//Added V190320-Aravindh/MMS-DM-CRF-0129
					excludedItems_RBD.add(dailyLmtAmtList);//Added V190320-Aravindh/MMS-DM-CRF-0129
					excludedItems_RBD.add(dailyLmtGrossNetList);//Added V190320-Aravindh/MMS-DM-CRF-0129
					excludedItems_RBD.add(dailyLmtIndicatorList);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
					excludedItems_RBD.add(dailyLmtQtyList);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
					
					excludedItemsFD_RB.put(curCode,excludedItems_RBD);
					dateFlag="Y";					

					excludedItems_RB.put(newDate,excludedItemsFD_RB);
					dateFlag="Y";
//					dbExcludedItemsFD_RB.put(parent_service_code,dbExcludedItems_RBD);
//					dbExcludedItems_RB.put(newDate,dbExcludedItemsFD_RB);
					//System.out.println("in setDBValues,excludedItems_RB="+excludedItems_RB);
					setExcludedItems_RB(excludedItems_RB);
//					setDbExcludedItems_RB(dbExcludedItems_RB);
				}					
			}
			else if(tab.equals("CHARGE_BASED"))
			{
				ArrayList	charge_type_list	 =	new ArrayList();//MuthuN against 28192
				ArrayList	service_code_list    =	new ArrayList();
				ArrayList	service_desc_list	 =	new ArrayList();					
				ArrayList	amt_limit_ind_list   =	new ArrayList();
				ArrayList	amt_limit_list		 =	new ArrayList();
				//ArrayList	unlimited_list		 =	new ArrayList();				
				ArrayList	service_limit_list   =	new ArrayList();
				ArrayList	factorApplGroup		 =	new ArrayList();
				ArrayList	flag				 =	new ArrayList();
				ArrayList   roundToGroup		 =	new ArrayList();
				ArrayList   roundIndGroup		 =	new ArrayList();
				ArrayList	refund_list			 =	new ArrayList();
				ArrayList	refundAmt_list		 =	new ArrayList();	
				ArrayList	auto_refund_list	 =	new ArrayList();
				ArrayList	split_reqd_list		 =	new ArrayList();//Rajesh V - Split reqd
				ArrayList	includeHomeMedication_list		 =	new ArrayList();//sarathkumar InclHmeMedi
					
				ArrayList includedItems_CBD		 =	new ArrayList();
//				ArrayList dbIncludedItems_CBD	 =	new ArrayList();
//				HashMap dbIncludedItem_CBD		 =	new HashMap();
//				HashMap dbIncludedItems_CB		 =  new HashMap();
				HashMap includedItems_CB		 =  getIncludedItems_CB(); //new HashMap();
				HashMap includedItemsFD_CB=null;
				if(includedItems_CB==null || includedItems_CB.isEmpty()){
					includedItemsFD_CB=new HashMap();
				}
				else{
					includedItemsFD_CB		 =  (HashMap) getIncludedItems_CB().get(packageCode); // new HashMap();					
				}
				String prevDate = "";
				String curDate = "";
				String flagInd = "";
				sqlStr ="SELECT TO_DATE (a.eff_from_date, 'dd/mm/yyyy') eff_from_date, TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date1, refund_yn, refund_rate, auto_refund_yn, rounding_by_integer, rounding_option,pkg_serv_ind, pkg_serv_code, b.service_desc service_desc, amt_limit_ind, amt_limit, amt_limit_ind, apply_fact_for_srv_lmt_yn, a.split_allowed_yn, a.INCL_HOME_MEDICATION_YN,   (SELECT 'Y' FROM bl_package_exclusions WHERE operating_facility_id = a.operating_facility_id AND package_code = a.package_code AND pkg_serv_code = a.pkg_serv_code ANd pkg_serv_ind = a.pkg_serv_ind AND ROWNUM = 1) service_limit,group_service_ind FROM bl_package_dtls a, (SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc, language_id, status FROM bl_blng_serv_lang_vw UNION ALL SELECT 'M' serv_ind, item_code code, short_desc service_desc, language_id, null status FROM mm_item_lang_vw) b WHERE a.operating_facility_id = ? AND b.status is null AND a.package_code = ? AND a.rate_charge_ind = ? AND a.pkg_serv_code = b.code and a.pkg_serv_ind = b.serv_ind AND b.language_id = ? AND a.eff_from_date =(SELECT MAX (c.eff_from_date) FROM bl_package_period c WHERE c.operating_facility_id = a.operating_facility_id AND c.package_code = a.package_code) ORDER BY eff_from_date";
			if(rs!=null) rs=null;
				if(pstmt!=null) pstmt=null;
				pstmt=connection.prepareStatement(sqlStr);
				pstmt.setString(1,operating_facility_id);
				if(!copyFrm_pkgCode.equals("")){//have value only in insert mode if user selects a pkg code to copy from
					pstmt.setString(2,copyFrm_pkgCode);
				}else
					pstmt.setString(2,packageCode);
				pstmt.setString(3,"C");
				pstmt.setString(4,language_id);
				//pstmt.setString(5,newDate);
				rs = pstmt.executeQuery();
				while (rs.next()){

					curDate = newDate; //checkForNull(rs.getString("EFF_FROM_DATE1"));
					
					if(!prevDate.equals("") && !(curDate.equals(prevDate)) && copyFrm_pkgCode.equals("")) {
					includedItems_CBD.add(charge_type_list);//MuthuN against 28192
					includedItems_CBD.add(service_code_list);
//					dbIncludedItems_CBD.add(service_code_list);
					includedItems_CBD.add(service_desc_list)	;					
					includedItems_CBD.add(amt_limit_ind_list);
					includedItems_CBD.add(amt_limit_list);
					//includedItems_CBD.add(unlimited_list);					
					includedItems_CBD.add(service_limit_list);
					includedItems_CBD.add(factorApplGroup);
					includedItems_CBD.add(roundToGroup);
					includedItems_CBD.add(roundIndGroup);
					includedItems_CBD.add(refund_list);
					includedItems_CBD.add(refundAmt_list);
					includedItems_CBD.add(auto_refund_list);
					includedItems_CBD.add(split_reqd_list);//Split reqd
					includedItems_CBD.add(includeHomeMedication_list);//sarathkumar InclHmeMedi
					
//					dbIncludedItem_CBD.put(prevDate,dbIncludedItems_CBD);
					includedItemsFD_CB.put(prevDate,includedItems_CBD);
					dateFlag="Y";
					charge_type_list	=	new ArrayList();//MuthuN against 28192
					service_code_list    =	new ArrayList();
					service_desc_list	 =	new ArrayList();					
					amt_limit_ind_list  =	new ArrayList();
					amt_limit_list		 =	new ArrayList();
					//unlimited_list		 =	new ArrayList();				
					service_limit_list   =	new ArrayList();
					factorApplGroup		 =	new ArrayList();
					flag				 =	new ArrayList();
					roundToGroup		 =	new ArrayList();
					roundIndGroup		 =	new ArrayList();
					refund_list			 =	new ArrayList();
					refundAmt_list		 =	new ArrayList();	
					auto_refund_list	 =	new ArrayList();
					split_reqd_list 	 =	new ArrayList();//Split reqd
					includeHomeMedication_list 	 =	new ArrayList();//sarathkumar InclHmeMedi
						
					includedItems_CBD		 =	new ArrayList();
//					dbIncludedItems_CBD	 =	new ArrayList();

					}	
					charge_type_list.add(checkForNull(rs.getString("pkg_serv_ind")));//MuthuN against 28192
					System.out.println("pkg_serv_ind in DefBean.java "+rs.getString("pkg_serv_ind"));
					service_code_list.add(checkForNull(rs.getString("pkg_serv_code")));
					service_desc_list.add(checkForNull(rs.getString("service_desc")));
					amt_limit_ind_list.add(checkForNull(rs.getString("AMT_LIMIT_IND")));
					amt_limit_list.add(checkForNull(rs.getString("amt_limit")));
					//unlimited_list.add(checkForNull(rs.getString("unlimited_yn")));
					factorApplGroup.add(checkForNull(rs.getString("APPLY_FACT_FOR_SRV_LMT_YN"),"N"));
					roundToGroup.add(checkForNull(rs.getString("ROUNDING_BY_INTEGER")));
					roundIndGroup.add(checkForNull(rs.getString("ROUNDING_OPTION")));
					refund_list.add(checkForNull(rs.getString("REFUND_YN")));
					refundAmt_list.add(checkForNull(rs.getString("REFUND_RATE")));
					auto_refund_list.add(checkForNull(rs.getString("AUTO_REFUND_YN")));
					split_reqd_list.add(checkForNull(rs.getString("split_allowed_yn"),"N"));
						includeHomeMedication_list.add(checkForNull(rs.getString("INCL_HOME_MEDICATION_YN"),"N"));
						
					if(!(checkForNull(rs.getString("service_limit")).equals("Y"))){
						service_limit_list.add("N");
					}else
						service_limit_list.add(checkForNull(rs.getString("service_limit")));
				  // includSrvicesDB_CB.put(checkForNull(rs.getString("pkg_serv_code")),"modify");
					prevDate = curDate;
					flagInd = "1";
				}
				if(service_code_list.size()>0)
				{
					includedItems_CBD.add(charge_type_list);//MuthuN against 28192
					includedItems_CBD.add(service_code_list);
//					dbIncludedItems_CBD.add(service_code_list);
					includedItems_CBD.add(service_desc_list)	;					
					includedItems_CBD.add(amt_limit_ind_list);
					includedItems_CBD.add(amt_limit_list);
					//includedItems_CBD.add(unlimited_list);					
					includedItems_CBD.add(service_limit_list);
					includedItems_CBD.add(factorApplGroup);
					includedItems_CBD.add(roundToGroup);
					includedItems_CBD.add(roundIndGroup);
					includedItems_CBD.add(refund_list);
					includedItems_CBD.add(refundAmt_list);
					includedItems_CBD.add(auto_refund_list);
					includedItems_CBD.add(split_reqd_list);
					includedItems_CBD.add(includeHomeMedication_list); //sarathkumar InclHmeMedi
					
					System.out.println("copyFrm_pkgCode:"+copyFrm_pkgCode);
					System.out.println("newDate:"+newDate);
					System.out.println("curDate:"+curDate); 

					if(!copyFrm_pkgCode.equals(""))
					{
//						dbIncludedItem_CBD.put(newDate,dbIncludedItems_CBD);
						includedItemsFD_CB.put(newDate,includedItems_CBD);
						dateFlag="Y";
					}
					else
					{
//						dbIncludedItem_CBD.put(curDate,dbIncludedItems_CBD);
						includedItemsFD_CB.put(curDate,includedItems_CBD);
						dateFlag="Y";
					}
				}
				if(flagInd.equals("1"))
				{
					includedItems_CB.put(packageCode,includedItemsFD_CB);
					dateFlag="Y";
//					dbIncludedItems_CB.put(packageCode,dbIncludedItem_CBD);

					setIncludedItems_CB(includedItems_CB);
//					setDbIncludedItems_CB(dbIncludedItems_CB);
				}
				System.out.println("getIncludedItems_CB:"+getIncludedItems_CB());
				//setIncludSrvicesDB_CB(includSrvicesDB_CB);			
			}
			else if(tab.equals("CHARGE_BASED_ITEM"))
			{					
				ArrayList	item_code_list    =	new ArrayList();
				ArrayList	item_desc_list	    =	new ArrayList();					
				ArrayList	qty_limit_list    =	new ArrayList();
				ArrayList	amt_limit_list    =	new ArrayList();
				ArrayList	inclExclFlag_list    =	new ArrayList();				
				ArrayList	flag				 =	new ArrayList();
				ArrayList	split_reqd_list		 =	new ArrayList();//Rajesh V - Split reqd
				ArrayList	includeHomeMedication_list		 =	new ArrayList();//sarathkumar InclHmeMedi
					
				ArrayList excludedItems_CBD =	new ArrayList();
				HashMap excludedItems_CB    =   getExcludedItems_CB(); //new HashMap();	
//				ArrayList dbExcludedItems_CBD =	new ArrayList();
//				HashMap dbExcludedItems_CB    =   new HashMap();
				HashMap excludedItemsFD_CB   = null;
				if(excludedItems_CB==null|| excludedItems_CB.isEmpty()){
					excludedItemsFD_CB=new HashMap();
				}
				else{
					excludedItemsFD_CB=(HashMap) getExcludedItems_CB().get(newDate); //new HashMap();
				}
						
//				HashMap dbExcludedItemsFD_CB    =   new HashMap();
				String prevCode = "";
				String curCode = "";
				excludedItems_CB = 	getExcludedItems_CB();
				if(excludedItems_CB!=null && excludedItems_CB.containsKey(newDate)){
				  excludedItemsFD_CB =  (HashMap) getExcludedItems_CB().get(newDate); //new HashMap();
				}
				else{
					excludedItemsFD_CB=new HashMap();;
				}
				
				sqlStr ="SELECT a.pkg_serv_code,a.excl_serv_code excl_serv_code, b.short_desc service_desc,qty_limit, amt_limit, a.split_allowed_yn, a.INCL_HOME_MEDICATION_YN, a.exclude_yn exclude_yn  FROM bl_package_exclusions a, mm_item_lang_vw b WHERE a.operating_facility_id = ? AND b.language_id = ?  AND a.package_code =?  AND a.rate_charge_ind ='C'  AND a.excl_serv_code = b.item_code  and a.eff_from_date = (select max(c.eff_from_Date) from BL_PACKAGE_PERIOD c WHERE c.operating_facility_id = a.operating_facility_id  AND c.package_code = a.package_code ) order by a.pkg_serv_code";
				
				int index = 2;
				if(rs!=null) rs=null;
				if(pstmt!=null) pstmt=null;
				pstmt=connection.prepareStatement(sqlStr);				
				pstmt.setString(1,operating_facility_id);
				pstmt.setString(2,language_id);

				if(!copyFrm_pkgCode.equals("")){//have value only in insert mode if user selects a pkg code to copy from
					pstmt.setString(++index,copyFrm_pkgCode);
				}else
				{
					pstmt.setString(++index,packageCode);					
				}
				rs= pstmt.executeQuery();
				while(rs.next()){				
					   curCode = checkForNull(rs.getString("pkg_serv_code"));
						if(!prevCode.equals("") && !prevCode.equals(curCode))
					    {
						 excludedItems_CBD.add(item_code_list);
						// dbExcludedItems_CBD.add(item_code_list);
  						 excludedItems_CBD.add(item_desc_list);					
						 excludedItems_CBD.add(qty_limit_list);
						 excludedItems_CBD.add(amt_limit_list);
						 excludedItems_CBD.add(inclExclFlag_list);
						 excludedItems_CBD.add(split_reqd_list);//Split reqd
						 excludedItems_CBD.add(includeHomeMedication_list);//sarathkumar InclHmeMedi
						 	 
						 excludedItems_CBD.add(flag);
						 
						 excludedItemsFD_CB.put(prevCode,excludedItems_CBD);
						 dateFlag="Y";

						 item_code_list		=	new ArrayList();
						 item_desc_list	    =	new ArrayList();					
						 qty_limit_list		=	new ArrayList();
						 amt_limit_list		=	new ArrayList();
						 inclExclFlag_list   =	new ArrayList();				
						 flag				=	new ArrayList();
						 split_reqd_list	=	new ArrayList();//Split reqd
						 includeHomeMedication_list	=	new ArrayList();//sarathkumar InclHmeMedi
						
						excludedItems_CBD	=	new ArrayList();
						}
						prevCode = curCode;

				   item_code_list.add(checkForNull(rs.getString("excl_serv_code")));
				   item_desc_list.add(checkForNull(rs.getString("service_desc")));				   
				   qty_limit_list.add(checkForNull(rs.getString("qty_limit")));
				   amt_limit_list.add(checkForNull(rs.getString("amt_limit")));	
				   inclExclFlag_list.add(checkForNull(rs.getString("exclude_yn")));				   
   				   flag.add("modify");				   
   				   split_reqd_list.add(checkForNull(rs.getString("split_allowed_yn"),"N"));//Split reqd
				   includeHomeMedication_list.add(checkForNull(rs.getString("INCL_HOME_MEDICATION_YN"),"N"));//sarathkumar InclHmeMedi				      
				}
				if(item_code_list.size()>0)
				{
					excludedItems_CBD.add(item_code_list);
//					dbExcludedItems_CBD.add(item_code_list);					
					excludedItems_CBD.add(item_desc_list);					
					excludedItems_CBD.add(qty_limit_list);
					excludedItems_CBD.add(amt_limit_list);
					excludedItems_CBD.add(inclExclFlag_list);					
					excludedItems_CBD.add(split_reqd_list);//Split reqd
					excludedItems_CBD.add(includeHomeMedication_list);//sarathkumar InclHmeMedi
					
					excludedItems_CBD.add(flag);
					//System.out.println("in setDBValues,excludedItems_CBD="+excludedItems_CBD);
					excludedItemsFD_CB.put(curCode,excludedItems_CBD);
					excludedItems_CB.put(newDate,excludedItemsFD_CB);
					dateFlag="Y";
					setExcludedItems_CB(excludedItems_CB);
//					setDbExcludedItems_CB(dbExcludedItems_CB);
				}
				//excludSrvicesDB_CB.put(parent_service_code,excludItemsDB_CB);
				//setExcludSrvicesDB_CB(excludSrvicesDB_CB);
			}			
	}
		catch(Exception e){
			System.out.println("Exception e= "+e);
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
			
		}
		return dateFlag;
	}
}
