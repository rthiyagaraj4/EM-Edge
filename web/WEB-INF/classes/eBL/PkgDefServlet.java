/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1			 V220325			 27973			MMS-ME-SCF-0046-TF			  Mohana Priya K
2			V220824				 31032	Package Definition - Query PK details 	Mohana Priya K
-----------------------------------------------------------------------------------------------
 */
package eBL;

import java.lang.reflect.Method;
import java.net.*;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import eBL.PkgDef.*;
import eBL.*;	 
import com.ehis.persist.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.ArrayList ;
import eCommon.Common.*;
import com.ehis.eslp.ServiceLocator;
import eCommon.XSSRequestWrapper; //V220325

public class PkgDefServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	HashMap results;
	String facilityId="";
	String client_ip_address="";
	String login_user="";
	String slmt_ind="",adm_rec_flag="";
	String locale = "";
	HashMap tabdata=null;
	HttpSession session;
	String mode="";
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{	
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		//V220325 Starts
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		//V220325 ends
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = this.p.getProperty("client_ip_address");
		login_user = this.p.getProperty( "login_user" ) ;
		locale = this.p.getProperty("LOCALE") ;
		
		try
		{
			this.out = res.getWriter();
			String operation = req.getParameter("mode");
			System.out.println("operation servlet "+operation);
			if ( operation.equals("insert"))
			{
				insertData(req, res);
			}
			else if ( operation.equals("modify"))
			{
				modifyData(req, res);
			}
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		doPost(req,res);
	}


	private HashMap populateTabData(HttpServletRequest req, HttpServletResponse res){
		mode = checkForNull(req.getParameter("mode"));
		String packageCode = checkForNull(req.getParameter("packageCode"));
		String bean_id		= "bl_PkgDefBean" ;
		String bean_name	= "eBL.PkgDefBean";
		PkgDefBean bean			= (PkgDefBean)PersistenceHelper.getBeanObject( bean_id, bean_name, req ) ;
		
		String bean_id1		= "bl_PkgDefCustBean" ;
		String bean_name1	= "eBL.PkgDefCustBean";
		PkgDefCustBean bean1			= (PkgDefCustBean)PersistenceHelper.getBeanObject( bean_id1, bean_name1, req ) ;
		
		String bean_id2		= "bl_PkgDefDiscountBean" ;
		String bean_name2	= "eBL.PkgDefDiscountBean";
		PkgDefDiscountBean bean2			= (PkgDefDiscountBean)PersistenceHelper.getBeanObject( bean_id2, bean_name2, req ) ;
		//Added By Shikha For GHL-CRF-0520.1
		String bean_id3 	= "bl_PkgDefBlngGrpBean" ;
		String bean_name3	= "eBL.PkgDefBlngGrpBean";
		PkgDefBlngGrpBean bean3			= (PkgDefBlngGrpBean)PersistenceHelper.getBeanObject( bean_id3, bean_name3, req ) ;
		//Ended By Shikha For GHL-CRF-0520.1
		HashMap includedItems_CB   = bean.getIncludedItems_CB();
		HashMap excludedItems_CB   = bean.getExcludedItems_CB();
		HashMap includedItems_RB   = bean.getIncludedItems_RB();
		HashMap excludedItems_RB   = bean.getExcludedItems_RB();
		HashMap includedItems_cust   = bean.getIncludedItems_cust();
		HashMap includedItems_blngGrp   = bean.getIncludedItems_blngGrp(); //Added By Shikha For GHL-CRF-0520.1
		packageCode		=	checkForNull(bean.getPackageCode());
		String longDesc 		=	checkForNull(bean.getLongDesc());
		System.err.println("longDesc bef in populate tab data"+longDesc);
		try {
			longDesc = java.net.URLDecoder.decode(longDesc,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //V220824
		
		System.err.println("longDesc in populate tab data"+longDesc);
		String shortDesc 		=	checkForNull(bean.getShortDesc());
		try {
			shortDesc = java.net.URLDecoder.decode(shortDesc,"UTF-8");
			System.err.println("shortDesc in populate tab data"+shortDesc);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //V220824
		
		
		String effFromDate		=	checkForNull(bean.getEffFromDate());
		String effToDate		=	checkForNull(bean.getEffToDate());
		String applSexInd 		=	checkForNull(bean.getApplSexInd());
		String minAgeInYrs		=	checkForNull(bean.getMinAgeInYrs());
		String minAgeInMths		=	checkForNull(bean.getMinAgeInMths());
		String minAgeInDays		=	checkForNull(bean.getMinAgeInDays());
		String maxAgeInYrs		=	checkForNull(bean.getMaxAgeInYrs());
		String maxAgeInMths		=	checkForNull(bean.getMaxAgeInMths());
		String maxAgeInDays		=	checkForNull(bean.getMaxAgeInDays());
		String OpYn				=	checkForNull(bean.getOpYn(),"N");
		String EmYn				=	checkForNull(bean.getEmYn(),"N");
		String IpYn				=	checkForNull(bean.getIpYn(),"N");
		String DcYn				=	checkForNull(bean.getDcYn(),"N");
		String AllYn			=   checkForNull(bean.getAllYn(),"N");
		String orderAssociated  =   checkForNull(bean.getOrderAssociated(),"N");
		String acrossEncounters =   checkForNull(bean.getAcrossEncounters(),"N");
		String applicalbleTo	=   checkForNull(bean.getApplicalbleTo());
		//String auto				=   checkForNull(bean.getAuto(),"N");//unused variable
		String validDays		=	checkForNull(bean.getValidDays());
		String approvedYN	    =   checkForNull(bean.getApprovedYN());
		String approvedBy	    =   checkForNull(bean.getApprovedBy());
		String approvedDate	    =   checkForNull(bean.getApprovedDate());
		String isMasterPkgYn	=   checkForNull(bean.getIsMasterPkgYn());//Added V190325 Gayathri/KDAH-CRF-0503
		
		
		HashMap baseDates	    =	bean.getBaseDates();
		HashMap	basePrice	    =	bean.getBasePrice();
		HashMap existingPkgBaseDatesMap	    =	bean.getExistingPkgBaseDates();
		HashMap childPackages	=	bean.getChildPackages(); //Added V190325 Gayathri/KDAH-CRF-0503
		HashMap childPackdtl	=	bean.getChildPackdtl();
				
		String newDate=checkForNull(bean.getNewDate());
		if("modify".equals(mode)){
			
		/*For Package Changes by Pradeepa*/
			String baseDatesPkgCode=null;
			String existingDatesPkgCode =null;
			ArrayList baseDateValues=new ArrayList();
			ArrayList existingPkgBaseDatesVal=new ArrayList();
			
			Iterator baseDatesValuesItr=baseDates.entrySet().iterator();
			if(baseDatesValuesItr.hasNext()){
				//Object baseDatesValuesList =baseDatesValuesItr.next();
				Map.Entry baseDatesValuesEntry = (Map.Entry) baseDatesValuesItr.next();
				 baseDatesPkgCode = (String)baseDatesValuesEntry.getKey();
			    baseDateValues = (ArrayList)baseDatesValuesEntry.getValue();
			    System.out.println("baseDateValues "+baseDateValues);
			}
			 
			if(baseDateValues!=null && !baseDateValues.isEmpty()){
			ArrayList<String> baseDatesList=(ArrayList) baseDateValues.get(0);
			Iterator existingPkgBaseDatesItr=existingPkgBaseDatesMap.entrySet().iterator();		
			if(existingPkgBaseDatesItr.hasNext()){			
				Map.Entry existingPkgBaseDatesEntry = (Map.Entry) existingPkgBaseDatesItr.next();
				existingDatesPkgCode = (String)existingPkgBaseDatesEntry.getKey();
				existingPkgBaseDatesVal = (ArrayList)existingPkgBaseDatesEntry.getValue();
			    System.out.println("existingPkgBaseDatesValues "+existingPkgBaseDatesVal);
			}
			
			if(existingPkgBaseDatesVal!=null && !existingPkgBaseDatesVal.isEmpty()){
			ArrayList<String> existingPkgBaseDates=(ArrayList<String>) existingPkgBaseDatesVal.get(0);		
			ArrayList<String> newDatesList=new ArrayList<String>();
			for (String pkgBaseDate : baseDatesList) {
			    if (!existingPkgBaseDates.contains(pkgBaseDate)) {
			    	  	newDatesList.add(pkgBaseDate);
			    }
			}
			
			String uniqueDate="";
			String dateFlag="";
			for(int i=0;i<newDatesList.size();i++){		
				
				uniqueDate=(String) newDatesList.get(i);
				/*For package Rate Based*/
				HashMap includedItemsFD_RB=null;
				if(includedItems_RB!=null ||!includedItems_RB.isEmpty()){
				includedItemsFD_RB=(HashMap) includedItems_RB.get(packageCode);
				
				}
				else{
					includedItemsFD_RB=new HashMap();
				}				
				
				if(includedItems_RB.isEmpty() || !includedItemsFD_RB.containsKey(uniqueDate)){
					try {
						dateFlag=bean.setPrevDateFromBean("RATE_BASED",packageCode,locale,facilityId,"","",uniqueDate);
						
							if(("Y").equals(dateFlag)) {
							bean.setModifyRateBased("Y");
							 includedItems_RB   = bean.getIncludedItems_RB();
						}
						dateFlag=bean.setPrevDateFromBean("SRVLIMIT_RATE_BASED",packageCode,locale,facilityId,"","",uniqueDate);
						if(("Y").equals(dateFlag)) {
							bean.setModifyRateSrvLimits("Y");
							 excludedItems_RB   = bean.getExcludedItems_RB();	
						}								
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else{
					boolean exclExists = false;
					Set<String> exclKeySet = excludedItems_RB.keySet();
					for(String s:exclKeySet){
						if(s.contains(uniqueDate)){
							exclExists = true;
						}
					}
					if(excludedItems_RB.isEmpty() || !exclExists){
						try {
							dateFlag=bean.setPrevDateFromBean("SRVLIMIT_RATE_BASED",packageCode,locale,facilityId,"","",uniqueDate);
							if(("Y").equals(dateFlag)) {
								bean.setModifyRateSrvLimits("Y");
								excludedItems_RB   = bean.getExcludedItems_RB();
							}							
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				
				//	
				
				/*For Customer Charge Based*/
				
				HashMap includedItemsFD_CB=null;
				if(includedItems_CB!=null ||!includedItems_CB.isEmpty()){
					includedItemsFD_CB=(HashMap) includedItems_CB.get(packageCode);
				
				}
				else{
					includedItemsFD_CB=new HashMap();
				}
				if(includedItems_CB.isEmpty() || !includedItemsFD_CB.containsKey(uniqueDate)){
					try {
						dateFlag=bean.setPrevDateFromBean("CHARGE_BASED",packageCode,locale,facilityId,"","",uniqueDate);
						if(("Y").equals(dateFlag)) {
							
							bean.setModifyChargeBased("Y");
							 includedItems_CB   = bean.getIncludedItems_CB();
							}
						dateFlag=bean.setPrevDateFromBean("CHARGE_BASED_ITEM",packageCode,locale,facilityId,"","",uniqueDate);
						if(("Y").equals(dateFlag)) {
							bean.setModifyChargeItems("Y");
							excludedItems_CB   = bean.getExcludedItems_CB();
						}
						 
						 
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else{
					boolean exclExists = false;
					Set<String> exclKeySet = excludedItems_CB.keySet();
					for(String s:exclKeySet){
						if(s.contains(uniqueDate)){
							exclExists = true;
						}
					}
					
					if(excludedItems_CB.isEmpty() || !exclExists){
						try {
							dateFlag=bean.setPrevDateFromBean("CHARGE_BASED_ITEM",packageCode,locale,facilityId,"","",uniqueDate);
							if(("Y").equals(dateFlag)) {
								bean.setModifyChargeItems("Y");
							 excludedItems_CB   = bean.getExcludedItems_CB();
							}
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}						
				}				
			}
			}				
			}
			/*For Customer Changes by Rajesh V*/
		Set<String> newPeriods = new HashSet<String>();
		Set<String> custPeriodDB = bean1.getPackageCustPeriod(facilityId, packageCode);
		Set<String> custPeriodPersisted = bean1.getCustBasePrice().keySet();
		if(custPeriodDB != null && !custPeriodDB.isEmpty()){
			if(custPeriodPersisted != null && !custPeriodPersisted.isEmpty()){
				for(String custDateKey : custPeriodPersisted){
					if(!custPeriodDB.contains(custDateKey)){
						newPeriods.add(custDateKey);
					}
				}
			}
		}
		
		HashMap mapCustRateBased = (HashMap)bean1.getCustRateSrv();
		if(mapCustRateBased == null){
			mapCustRateBased = new HashMap();
		}
		
		HashMap mapCustRateBasedExcl = (HashMap)bean1.getCustRateSrvExcl();
		if(mapCustRateBasedExcl == null){
			mapCustRateBasedExcl = new HashMap();
		}
		
		HashMap mapCustChargeBased = (HashMap)bean1.getCustChargeSrv();
		if(mapCustChargeBased == null){
			mapCustChargeBased = new HashMap();
		}
		
		HashMap mapCustChargeBasedExcl = (HashMap)bean1.getCustChargeSrvExcl();
		if(mapCustChargeBasedExcl == null){
			mapCustChargeBasedExcl = new HashMap();
		}
		
		String tknCustGroup = "";
		String tknCust = "";
		String tknFromDate = "";
		String retArr = "N";
		for(String period:newPeriods){
			StringTokenizer strTokens = new StringTokenizer(period,"~~");
			
			try{
				if(strTokens.hasMoreTokens()){
					tknCustGroup = strTokens.nextToken();
					tknCust = strTokens.nextToken();
					tknFromDate = strTokens.nextToken();
				}				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			/*For Customer Rate Based*/
			if(mapCustRateBased.isEmpty() || !mapCustRateBased.containsKey(period)){
				System.out.println("mapCustRateBased "+mapCustRateBased);
				try {
					retArr = bean1.setPrevDateFromBean("CUST_RATE_BASED",packageCode, locale, facilityId, tknCustGroup, tknCust, tknFromDate);
					System.out.println("mapCustRateBased retArr "+retArr);
					if("Y".equals(retArr)){
						bean1.setModifyCustRateSrv("Y");
					}
					retArr = "N";
					retArr = bean1.setPrevDateFromBean("CUST_RATE_BASED_SERV_LIMIT",packageCode, locale, facilityId, tknCustGroup, tknCust, tknFromDate);
					System.out.println("CUST_RATE_BASED_SERV_LIMIT retArr "+retArr);
					if("Y".equals(retArr)){
						bean1.setModifyCustRateSrvExcl("Y");
					}					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else{
				boolean exclEsists = false;
				Set<String> exclKeySet = mapCustRateBasedExcl.keySet();
				for(String s:exclKeySet){
					if(s.contains(period)){
						exclEsists = true;
					}
				}
				if(mapCustRateBasedExcl.isEmpty() || !exclEsists){
					try {
						retArr = "N";
						retArr = bean1.setPrevDateFromBean("CUST_RATE_BASED_SERV_LIMIT",packageCode, locale, facilityId, tknCustGroup, tknCust, tknFromDate);
						if("Y".equals(retArr)){
							bean1.setModifyCustRateSrvExcl("Y");
						}
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
			
			/*For Customer Charge Based*/
			if(mapCustChargeBased.isEmpty() || !mapCustChargeBased.containsKey(period)){
				try {
					retArr = bean1.setPrevDateFromBean("CUST_CHARGE_BASED",packageCode, locale, facilityId, tknCustGroup, tknCust, tknFromDate);
					if("Y".equals(retArr)){
						bean1.setModifyCustChargeSrv("Y");
					}
					retArr = bean1.setPrevDateFromBean("CUST_CHARGE_BASED_SERV_LIMIT",packageCode, locale, facilityId, tknCustGroup, tknCust, tknFromDate);
					if("Y".equals(retArr)){
						bean1.setModifyCustChargeSrvExcl("Y");
					}					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else{
				boolean exclEsists = false;
				Set<String> exclKeySet = mapCustChargeBasedExcl.keySet();
				for(String s:exclKeySet){
					if(s.contains(period)){
						exclEsists = true;
					}
				}
				
				if(mapCustChargeBasedExcl.isEmpty() || !exclEsists){
					try {
						retArr = "N";
						retArr = bean1.setPrevDateFromBean("CUST_CHARGE_BASED_SERV_LIMIT",packageCode, locale, facilityId, tknCustGroup, tknCust, tknFromDate);
						if("Y".equals(retArr)){
							bean1.setModifyCustChargeSrvExcl("Y");
						}
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}					
			}
		}
		
		//Added By Shikha For GHL-CRF-0520.1
		/*For Billing Group Changes by Shikha Seth*/
		Set<String> newPeriodsBlngGrp = new HashSet<String>();
		Set<String> blngGrpPeriodDB = bean3.getPackageBlngGrpPeriod(facilityId, packageCode);
		Set<String> blngGrpPeriodPersisted = bean3.getBlngGrpBasePrice().keySet();
		if(blngGrpPeriodDB != null && !blngGrpPeriodDB.isEmpty()){
			if(blngGrpPeriodPersisted != null && !blngGrpPeriodPersisted.isEmpty()){
				for(String blngGrpDateKey : blngGrpPeriodPersisted){
					if(!blngGrpPeriodDB.contains(blngGrpDateKey)){
						newPeriodsBlngGrp.add(blngGrpDateKey);
					}
				}
			}
		}
		
		HashMap mapBlngGrpRateBased = (HashMap)bean3.getBlngGrpRateSrv();
		if(mapBlngGrpRateBased == null){
			mapBlngGrpRateBased = new HashMap();
		}
		
		HashMap mapBlngGrpRateBasedExcl = (HashMap)bean3.getBlngGrpRateSrvExcl();
		if(mapBlngGrpRateBasedExcl == null){
			mapBlngGrpRateBasedExcl = new HashMap();
		}
		
		HashMap mapBlngGrpChargeBased = (HashMap)bean3.getBlngGrpChargeSrv();
		if(mapBlngGrpChargeBased == null){
			mapBlngGrpChargeBased = new HashMap();
		}
		
		HashMap mapBlngGrpChargeBasedExcl = (HashMap)bean3.getBlngGrpChargeSrvExcl();
		if(mapBlngGrpChargeBasedExcl == null){
			mapBlngGrpChargeBasedExcl = new HashMap();
		}
		
		String tknBlngGrpGroup = "";
		String tknBlngGrp = "";
		String tknFromDateBlngGrp = "";
		String retArrBlngGrp = "N";
		for(String period:newPeriods){
			StringTokenizer strTokens = new StringTokenizer(period,"~~");
			
			try{
				if(strTokens.hasMoreTokens()){
					tknBlngGrpGroup = strTokens.nextToken();
					tknFromDateBlngGrp = strTokens.nextToken();
				}				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			/*For Billing Group Rate Based*/
			if(mapBlngGrpRateBased.isEmpty() || !mapBlngGrpRateBased.containsKey(period)){
				try {
					retArrBlngGrp = bean3.setPrevDateFromBean("BLNG_GRP_RATE_BASED",packageCode, locale, facilityId, tknBlngGrpGroup, tknFromDateBlngGrp);
					if("Y".equals(retArrBlngGrp)){
						bean3.setModifyBlngGrpRateSrv("Y");
					}
					retArrBlngGrp = "N";
					retArrBlngGrp = bean3.setPrevDateFromBean("BLNG_GRP_RATE_BASED_SERV_LIMIT",packageCode, locale, facilityId, tknBlngGrpGroup, tknFromDateBlngGrp);
					if("Y".equals(retArrBlngGrp)){
						bean3.setModifyBlngGrpRateSrvExcl("Y");
					}					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else{
				boolean exclEsists = false;
				Set<String> exclKeySet = mapBlngGrpRateBasedExcl.keySet();
				for(String s:exclKeySet){
					if(s.contains(period)){
						exclEsists = true;
					}
				}
				if(mapBlngGrpRateBasedExcl.isEmpty() || !exclEsists){
					try {
						retArrBlngGrp = "N";
						retArrBlngGrp = bean3.setPrevDateFromBean("BLNG_GRP_RATE_BASED_SERV_LIMIT",packageCode, locale, facilityId, tknBlngGrpGroup, tknFromDateBlngGrp);
						if("Y".equals(retArrBlngGrp)){
							bean3.setModifyBlngGrpRateSrvExcl("Y");
						}
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			}			
			
			/*For Billing Group Charge Based*/
			if(mapBlngGrpChargeBased.isEmpty() || !mapBlngGrpChargeBased.containsKey(period)){
				try {
					retArrBlngGrp = bean3.setPrevDateFromBean("BLNG_GRP_CHARGE_BASED",packageCode, locale, facilityId, tknBlngGrpGroup, tknFromDateBlngGrp);
					if("Y".equals(retArrBlngGrp)){
						bean3.setModifyBlngGrpChargeSrv("Y");
					}
					retArrBlngGrp = bean3.setPrevDateFromBean("BLNG_GRP_CHARGE_BASED_SERV_LIMIT",packageCode, locale, facilityId, tknBlngGrpGroup, tknFromDateBlngGrp);
					if("Y".equals(retArrBlngGrp)){
						bean3.setModifyBlngGrpChargeSrvExcl("Y");
					}					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else{
				boolean exclEsists = false;
				Set<String> exclKeySet = mapBlngGrpChargeBasedExcl.keySet();
				for(String s:exclKeySet){
					if(s.contains(period)){
						exclEsists = true;
					}
				}
				
				if(mapBlngGrpChargeBasedExcl.isEmpty() || !exclEsists){
					try {
						retArrBlngGrp = "N";
						retArrBlngGrp = bean3.setPrevDateFromBean("BLNG_GRP_CHARGE_BASED_SERV_LIMIT",packageCode, locale, facilityId, tknBlngGrpGroup, tknFromDateBlngGrp);
						if("Y".equals(retArrBlngGrp)){
							bean3.setModifyBlngGrpChargeSrvExcl("Y");
						}
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}					
			}
		}
		//Ended By Shikha For GHL-CRF-0520.1
		}
		
		tabdata.put("FACILITY_ID",facilityId);
		tabdata.put("packageCode",packageCode);
		tabdata.put("longDesc",longDesc);
		tabdata.put("shortDesc",shortDesc);
		tabdata.put("applSexInd",applSexInd);
		tabdata.put("effFromDate",effFromDate);
		tabdata.put("effToDate",effToDate);
		tabdata.put("minAgeInYrs",minAgeInYrs);
		tabdata.put("minAgeInMths",minAgeInMths);
		tabdata.put("minAgeInDays",minAgeInDays);
		tabdata.put("maxAgeInYrs",maxAgeInYrs);
		tabdata.put("maxAgeInMths",maxAgeInMths);
		tabdata.put("maxAgeInDays",maxAgeInDays);
		tabdata.put("AllYn",AllYn);
		tabdata.put("IpYn",IpYn);
		tabdata.put("DcYn",DcYn);
		tabdata.put("OpYn",OpYn);
		tabdata.put("EmYn",EmYn);
		tabdata.put("orderAssociated",orderAssociated);
		tabdata.put("acrossEncounters",acrossEncounters);
		tabdata.put("validDays",validDays);
		tabdata.put("applicalbleTo",applicalbleTo);
		tabdata.put("approvedYN",approvedYN);
		tabdata.put("approvedBy",approvedBy);
		tabdata.put("approvedDate",approvedDate);
		tabdata.put("baseDates",baseDates);
		tabdata.put("basePrice",basePrice);
		tabdata.put("isMasterPkgYn",isMasterPkgYn);//Added V190325 Gayathri/KDAH-CRF-0503
		//tabdata.put("ExYn",ExYn);
		tabdata.put("client_ip_address",client_ip_address);
		tabdata.put("login_user",login_user);
		tabdata.put("locale",locale);
		tabdata.put("childPackages",childPackages);//Added V190325 Gayathri/KDAH-CRF-0503
		tabdata.put("childPackdtl",childPackdtl); 		//KDAH-CRF-503
		/*For base price  
		tabdata.put("blgClsCodeGrp",blgClsCodeGrp);
		tabdata.put("priceFromDate",priceFromDate);
		tabdata.put("priceToDate",priceToDate);
		tabdata.put("indicatorGrp",indicatorGrp);
		tabdata.put("price",price);
		tabdata.put("factorApplGrp",factorApplGrp);
		tabdata.put("flag",flag);	*/

		/*For chrge based inclusions and exclusions  */
		tabdata.put("includedItems_CB",includedItems_CB);
		tabdata.put("excludedItems_CB",excludedItems_CB);		
		//tabdata.put("includSrvicesDB_CB",includSrvicesDB_CB);
		//tabdata.put("excludSrvicesDB_CB",excludSrvicesDB_CB);
		
		/*For rate based inclusions and exclusions  */
		tabdata.put("includedItems_RB",includedItems_RB);
		tabdata.put("excludedItems_RB",excludedItems_RB);
		tabdata.put("includedItems_cust",includedItems_cust);
		tabdata.put("includedItems_blngGrp",includedItems_blngGrp); //Added By Shikha For GHL-CRF-0520.1
		tabdata.put("modifyRateBased",bean.getModifyRateBased());
		tabdata.put("modifyRateSrvLimits",bean.getModifyRateSrvLimits());
		tabdata.put("modifyChargeBased",bean.getModifyChargeBased());
		tabdata.put("modifyChargeItems",bean.getModifyChargeItems());
		//tabdata.put("modifyCustomer",bean.getModifyCustomer());
		tabdata.put("dbIncludedItems_CB",bean.getDbIncludedItems_CB());
		tabdata.put("dbExcludedItems_CB",bean.getDbExcludedItems_CB());
		tabdata.put("dbIncludedItems_RB",bean.getDbIncludedItems_RB());
		tabdata.put("dbExcludedItems_RB",bean.getDbExcludedItems_RB());
		tabdata.put("dbIncludedItems_cust",bean.getDbIncludedItems_cust());
		tabdata.put("dbIncludedItems_blngGrp",bean.getDbIncludedItems_blngGrp()); //Added By Shikha For GHL-CRF-0520.1
		
		
		tabdata.put("cust_dtls",(HashMap)bean1.getCustDtls());
		tabdata.put("cust_period",(HashMap)bean1.getCustPeriod());
		tabdata.put("cust_base_price",(HashMap)bean1.getCustBasePrice());
		tabdata.put("cust_rate_srv",(HashMap)bean1.getCustRateSrv());
		tabdata.put("cust_rate_srv_excl",(HashMap)bean1.getCustRateSrvExcl());
		tabdata.put("cust_charge_srv",(HashMap)bean1.getCustChargeSrv());
		tabdata.put("cust_charge_srv_excl",(HashMap)bean1.getCustChargeSrvExcl());
		
		tabdata.put("db_cust_dtls",(HashMap)bean1.getCustDBDtls());
		tabdata.put("db_cust_period",(HashMap)bean1.getCustDBPeriod());
		tabdata.put("db_cust_base_price",(HashMap)bean1.getCustDBBasePrice());
		tabdata.put("db_cust_rate_srv",(HashMap)bean1.getCustDBRateSrv());
		tabdata.put("db_cust_rate_srv_excl",(HashMap)bean1.getCustDBRateSrvExcl());
		tabdata.put("db_cust_charge_srv",(HashMap)bean1.getCustDBChargeSrv());
		tabdata.put("db_cust_charge_srv_excl",(HashMap)bean1.getCustDBChargeSrvExcl());
		tabdata.put("modify_cust",bean1.getModifyCust());
		tabdata.put("modify_cust_period",bean1.getModifyCustPeriod());
		tabdata.put("modify_cust_base_price",bean1.getModifyCustBasePrice());
		System.out.println("bean1.getModifyCustRateSrv() "+bean1.getModifyCustRateSrv());
		tabdata.put("modify_cust_rate_srv",bean1.getModifyCustRateSrv());
		tabdata.put("modify_cust_rate_srv_excl",bean1.getModifyCustRateSrvExcl());
		tabdata.put("modify_cust_charge_srv",bean1.getModifyCustChargeSrv());
		tabdata.put("modify_cust_charge_srv_excl",bean1.getModifyCustChargeSrvExcl());
		tabdata.put("cust_discount_dtls",(HashMap)bean2.getCustDiscountDtls());
		tabdata.put("db_cust_discount_dtls",(HashMap)bean2.getDBCustDiscountDtls());
		tabdata.put("blng_grp_discount_dtls",(HashMap)bean2.getBlngGrpDiscountDtls());
		tabdata.put("db_blng_grp_discount_dtls",(HashMap)bean2.getDBBlngGrpDiscountDtls());
		tabdata.put("modify_discount",(String)bean2.getModifyDiscount());
		tabdata.put("partial_deposit_list",	(HashMap<String,ArrayList<String>>)bean.getPartialDepositList()); // Karthik added for adding Partial deposit Records MMS-CRF-0023
		tabdata.put("newDate",newDate);		
		
		//Added By Shikha For GHL-CRF-0520.1
		tabdata.put("blng_grp_dtls",(HashMap)bean3.getBlngGrpDtls());
		tabdata.put("blng_grp_period",(HashMap)bean3.getBlngGrpPeriod());
		tabdata.put("blng_grp_base_price",(HashMap)bean3.getBlngGrpBasePrice());
		tabdata.put("blng_grp_rate_srv",(HashMap)bean3.getBlngGrpRateSrv());
		tabdata.put("blng_grp_rate_srv_excl",(HashMap)bean3.getBlngGrpRateSrvExcl());
		tabdata.put("blng_grp_charge_srv",(HashMap)bean3.getBlngGrpChargeSrv());
		tabdata.put("blng_grp_charge_srv_excl",(HashMap)bean3.getBlngGrpChargeSrvExcl());		
		tabdata.put("db_blng_grp_dtls",(HashMap)bean3.getBlnggrpDBDtls());
		tabdata.put("db_blng_grp_period",(HashMap)bean3.getBlngGrpDBPeriod());
		tabdata.put("db_blng_grp_base_price",(HashMap)bean3.getBlngGrpDBBasePrice());
		tabdata.put("db_blng_grp_rate_srv",(HashMap)bean3.getBlngGrpDBRateSrv());
		tabdata.put("db_blng_grp_rate_srv_excl",(HashMap)bean3.getBlngGrpDBRateSrvExcl());
		tabdata.put("db_blng_grp_charge_srv",(HashMap)bean3.getBlngGrpDBChargeSrv());
		tabdata.put("db_blng_grp_charge_srv_excl",(HashMap)bean3.getBlngGrpDBChargeSrvExcl());
		tabdata.put("modify_blng_grp",bean3.getModifyBlngGrp());
		tabdata.put("modify_blng_grp_period",bean3.getModifyBlngGrpPeriod());
		tabdata.put("modify_blng_grp_base_price",bean3.getModifyBlngGrpBasePrice());
		tabdata.put("modify_blng_grp_rate_srv",bean3.getModifyBlngGrpRateSrv());
		tabdata.put("modify_blng_grp_rate_srv_excl",bean3.getModifyBlngGrpRateSrvExcl());
		tabdata.put("modify_blng_grp_charge_srv",bean3.getModifyBlngGrpChargeSrv());
		tabdata.put("modify_blng_grp_charge_srv_excl",bean3.getModifyBlngGrpChargeSrvExcl());
		//Ended By Shikha For GHL-CRF-0520.1
		System.err.println("676,tabdata in servlet::" +tabdata);	
		//}
		return tabdata;
	}

	private void insertData(HttpServletRequest req,HttpServletResponse res)
	{
		try 
		{	
			tabdata=new HashMap();
			//java.util.Locale loc = new java.util.Locale(locale);//unused variable
		//	java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
		//	String gen_receipt = (String)bl_labels.getString("eBL.DOC_GEN.label");	
			tabdata = populateTabData(req,res);

			//populateTabData(req,res);
			
			System.out.println("tabdata in PkgDefServlet.java,insertdata=" + tabdata);
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;
			Object home =ServiceLocator.getInstance().getHome("java:comp/env/PkgDef",eBL.PkgDef.PkgDefLocalHome.class, local_ejbs);

		//Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PkgDef",eBL.PkgDef.PkgDefHome.class, local_ejbs);
//		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PkgDef",eBL.PkgDef.PkgDefHome.class, local_ejbs);
//		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PkgDef",eBL.PkgDef.PkgDefHome.class, local_ejbs);
			
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home, null);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;
			Class[] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();	
			java.util.HashMap results = (java.util.HashMap) (busObj.getClass().getMethod("insert", paramArray)).invoke(busObj, argArray);	
			(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);
			boolean inserted = (((Boolean) results.get("status")).booleanValue());
			String error = (String) results.get("error");
			String message = (String) results.get("message");
			String sys_error = (String) results.get("sys_error");
			String error_value="0";
			if(inserted)
			{
				//out.println("<script>alert('success')</script>");				
				//out.println("<script>window.close();</script>");				
				error_value = "1" ;		
				
				Hashtable messageHashtable=new Hashtable();
				messageHashtable=MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
				String success_msg=(String)messageHashtable.get("message");

			res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( success_msg,"UTF-8" ) +"&err_value="+error_value);
			}
			else
			{			
				if(!sys_error.equals(""))
				{
				
					//out.println("<script>messageFrame.dummyFrame.location.href='../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( sys_error.toString(), "UTF-8" )+ "<br>'</script>");

					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( sys_error.toString(),"UTF-8" ) +"&err_value="+error_value);
				}
				else if(!message.equals(""))
				{
					
					Hashtable messageHashtable=new Hashtable();
					String msg="";
					StringTokenizer message_st = new StringTokenizer(message,"|");
					while(message_st.hasMoreTokens())
						{
							String sysMessageId = message_st.nextToken();
							//java.util.ResourceBundle bl_messages = java.util.ResourceBundle.getBundle("eBL.resources.Messages",loc);
							messageHashtable=MessageManager.getMessage(locale,sysMessageId,"BL");
							msg=msg+(String)messageHashtable.get("message")+"<br>";
//							
						}						
					//out.println("<script>parent.parent.frames(2).document.location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode( msg, "UTF-8" )+ "<br>'</script>");

					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ) +"&err_value="+error_value);
		
				}
				else if(!error.equals(""))
				{		
					//out.println("<script>parent.parent.frames(2).location.href='../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8" )+ "<br>'</script>");
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
				}
				else{
					error = "Record Not Saved";
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
				}
			//con.rollback();
			} 
			//out.println("<script>parent.parent.frames(2).document.location.href='../eCommon/jsp/error.jsp?err_num="+ java.net.URLEncoder.encode( 	error,"UTF-8" ) +"&err_value="+error_value+"'");
		 
		} 
		catch (Exception e) 
		{
			//con.rollback();
			System.out.println("exception in main=" + e.toString());
			e.printStackTrace();
			out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "
							+ e.toString() );
			out.println("Values sent are : <br>");
		} 
	}
	
private void modifyData(HttpServletRequest req,HttpServletResponse res)
{
		try 
		{	
			tabdata=new HashMap();
			//java.util.Locale loc = new java.util.Locale(locale);//unused variable
		//	java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
		//	String gen_receipt = (String)bl_labels.getString("eBL.DOC_GEN.label");	
			tabdata = populateTabData(req,res);

			//populateTabData(req,res);
			
			System.out.println("tabdata in PkgDefServlet.java,modifyData=" + tabdata);
			
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;
			Object home =ServiceLocator.getInstance().getHome("java:comp/env/PkgDef",eBL.PkgDef.PkgDefHome.class, local_ejbs);
			//Object home =com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PkgDef",eBL.PkgDef.PkgDefHome.class, local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home, null);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;
			Class[] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();		
			java.util.HashMap results = (java.util.HashMap) (busObj.getClass().getMethod("modify", paramArray)).invoke(busObj, argArray);	
			(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);
			
			boolean inserted = (((Boolean) results.get("status")).booleanValue());
			String error = (String) results.get("error");
			String message = (String) results.get("message");
			String sys_error = (String) results.get("sys_error");
			String error_value="0";
			System.out.println("inserted PkgDefServlet-modify=>"+inserted);
			System.out.println("message "+message);
			System.out.println("error "+error);
			System.out.println("sys_error "+sys_error);
			
			if(inserted)
			{
				//out.println("<script>alert('success')</script>");				
				//out.println("<script>window.close();</script>");				
				error_value = "1" ;		
				
				Hashtable messageHashtable=new Hashtable();
				messageHashtable=MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
				String success_msg=(String)messageHashtable.get("message");

			res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( success_msg,"UTF-8" ) +"&err_value="+error_value);
			}
			else
			{				
				if(!sys_error.equals(""))
				{
				
					//out.println("<script>messageFrame.dummyFrame.location.href='../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( sys_error.toString(), "UTF-8" )+ "<br>'</script>");

					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( sys_error.toString(),"UTF-8" ) +"&err_value="+error_value);
				}
				else if(!message.equals(""))
				{
					
					Hashtable messageHashtable=new Hashtable();
					String msg="";
					StringTokenizer message_st = new StringTokenizer(message,"|");
					while(message_st.hasMoreTokens())
						{
							String sysMessageId = message_st.nextToken();
							//java.util.ResourceBundle bl_messages = java.util.ResourceBundle.getBundle("eBL.resources.Messages",loc);
							messageHashtable=MessageManager.getMessage(locale,sysMessageId,"BL");
							msg=msg+(String)messageHashtable.get("message")+"<br>";
//							
						}						
					//out.println("<script>parent.parent.frames(2).document.location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode( msg, "UTF-8" )+ "<br>'</script>");

					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ) +"&err_value="+error_value);
			
				}
				else if(!error.equals(""))
				{		
					//out.println("<script>parent.parent.frames(2).location.href='../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8" )+ "<br>'</script>");
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
				}	 
			//con.rollback();
			} 
			//out.println("<script>parent.parent.frames(2).document.location.href='../eCommon/jsp/error.jsp?err_num="+ java.net.URLEncoder.encode( 	error,"UTF-8" ) +"&err_value="+error_value+"'");
		 
		} 
		catch (Exception e) 
		{
			//con.rollback();
			System.err.println("exception in main pkgdefservlet=" + e.toString());
			e.printStackTrace();
			out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "
							+ e.toString() );
			out.println("Values sent are : <br>");
		} 
	}

		private String checkForNull(String str){
		return (str!=null && str.intern()!="null")?str:"";
	}

	private String checkForNull(String str,String defaultVal){
		return (!checkForNull(str).equals(""))?str:defaultVal;
	}

	private boolean isLocalEJB(){
		ServletContext servletcontext = getServletConfig().getServletContext();
		if ((servletcontext.getInitParameter("LOCAL_EJBS")!=null) &&(servletcontext.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			return true;
			return false;
	}
}
