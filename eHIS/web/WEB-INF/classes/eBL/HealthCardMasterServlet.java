/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.MessageManager;

import com.ehis.eslp.ServiceLocator;
import com.ehis.persist.PersistenceHelper;

import  blHcard.HealthCardAgeDetailBean;
import  blHcard.HealthCardCashBillingGroupBean;
import  blHcard.HealthCardVisitRuleBean;

public class HealthCardMasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out;
	java.util.Properties p;

	/**
	 * Default constructor.
	 */
	public HealthCardMasterServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doHealthCardMasterAdd(request, response);
	}

	/*
	 * This method returns Empty String("") for null value, otherwise the
	 * original string will be returned
	 */
	private String nulltoStr(String inputString){
		if(inputString==null){
			return "";
		}
		else{
			return inputString;
		}
	}
	
	/*
	 * This method returns Empty String("") for null value, otherwise the
	 * original string will be returned
	 */
	private int stringToNumber(String inputString){
		if(inputString==null || inputString.equals("")){
			return 0;
		}
		else{
			return Integer.parseInt(inputString);
		}
	}
	

	/*
	 * This method invokes the EJB component and it updates or Inserts Records
	 * in the DB based on the passing Parameter.
	 */
	@SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	public void doHealthCardMasterAdd(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		try {
			System.out.println("Before Init: doHealthCardMasterAdd");

			HttpSession session=request.getSession(false);
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
			boolean local_ejbs = false;
			String locale = this.p.getProperty("LOCALE") ;

			System.out.println("Before Init: HealthCardMasterServlet.java");
			if ((getServletConfig().getServletContext().getInitParameter(
					"LOCAL_EJBS") != null)
					&& (getServletConfig().getServletContext()
							.getInitParameter("LOCAL_EJBS")
							.equalsIgnoreCase("TRUE"))) {
				local_ejbs = true;
			}
			System.out.println("Before Connection" + local_ejbs);

			Object home = ServiceLocator.getInstance().getHome(
					"java:comp/env/HealthCardMaster",
					eBL.HealthCardMaster.HealthCardMasterHome.class, local_ejbs);
			Object busObj = (home.getClass().getMethod("create")).invoke(home);
			
			String addedById =nulltoStr((String) session.getValue("login_user"));
			String modifiedById =nulltoStr((String) session.getValue("login_user"));      
			String addedFacilityId =nulltoStr((String) session.getValue("facility_id"));
			String modifiedFacilityid =nulltoStr((String) session.getValue("facility_id"));
			String addedAtWsno =nulltoStr(this.p.getProperty("client_ip_address")); 
			String modifiedAtWsno =nulltoStr(this.p.getProperty("client_ip_address"));  
			
					
			String cardTypeCode=nulltoStr(request.getParameter("cardTypeCode"));
			String longDescription=nulltoStr(request.getParameter("longDescription"));
			String shortDescription=nulltoStr(request.getParameter("shortDescription"));
			String validDays=nulltoStr(request.getParameter("validDays"));
			String noOfPat=nulltoStr(request.getParameter("noOfPat"));
			String effectiveFrom=nulltoStr(request.getParameter("effectiveFrom"));
			String effectiveTo=nulltoStr(request.getParameter("effectiveTo"));
			String cardStatus=Boolean.parseBoolean(request.getParameter("cardStatus")) ?"Y":"N";
			String noOfVisits=nulltoStr(request.getParameter("noOfVisits"));
			String dbOperation=nulltoStr(request.getParameter("dbOperation"));
	
			   HashMap<String, String> inputParameters = new HashMap<String, String>(); 			
			   inputParameters.put("poperatingfacilityid", addedFacilityId);
			   inputParameters.put("pcardtypecode", cardTypeCode);
			   inputParameters.put("plongdesc", longDescription);
			   inputParameters.put("pshortdesc", shortDescription);
			   inputParameters.put("pvaliddays", validDays);
			   inputParameters.put("pnoOfPat", noOfPat);
			   inputParameters.put("peffectivefrom", effectiveFrom);
			   inputParameters.put("peffectiveto", effectiveTo);
			   inputParameters.put("pstatus", cardStatus);
			   inputParameters.put("pnoofopvisits", noOfVisits);
			   inputParameters.put("pAddedById",addedById);
			   inputParameters.put("pModifiedById",modifiedById); 
			   inputParameters.put("pAddedFacilityId",addedFacilityId); 
			   inputParameters.put("pModifiedFacilityId",modifiedFacilityid); 
			   inputParameters.put("pAddedAtWsno",addedAtWsno); 
			   inputParameters.put("pModifiedAtWsno",modifiedAtWsno);  
			   inputParameters.put("headerModified","N"); 	

			/*Takes the count value of Records Added*/
			int ageGroupCount=stringToNumber(request.getParameter("ageGroupCount"));
			int clinicCount=stringToNumber(request.getParameter("clinicCount"));
			int billingGroupCount=stringToNumber(request.getParameter("billingGroupCount"));		
			System.out.println("ageGroupCount"+ageGroupCount+"clinicCount"+clinicCount+"billingGroupCount"+billingGroupCount);
			
			/*This set of ArrayList holds Current Records input Page*/
			ArrayList<blHcard.HealthCardAgeDetailBean> hcAgeDetailList = new 	ArrayList<blHcard.HealthCardAgeDetailBean>();
			ArrayList<blHcard.HealthCardVisitRuleBean> hcVisitDetailList = new 	ArrayList<blHcard.HealthCardVisitRuleBean>();
			ArrayList<blHcard.HealthCardCashBillingGroupBean> hcBlngGrpList = new 	ArrayList<blHcard.HealthCardCashBillingGroupBean>();
			
			/*This set of ArrayList holds Existing Records in DB*/
			ArrayList<blHcard.HealthCardAgeDetailBean> hcAgeExistingDetailList = new 	ArrayList<blHcard.HealthCardAgeDetailBean>();
			ArrayList<blHcard.HealthCardVisitRuleBean> hcVisitExistingDetailList = new 	ArrayList<blHcard.HealthCardVisitRuleBean>();
			ArrayList<blHcard.HealthCardCashBillingGroupBean> hcBlngExistingGrpList = new 	ArrayList<blHcard.HealthCardCashBillingGroupBean>();
			
			/*This set of ArrayList holds Records to be Updated*/
			ArrayList<blHcard.HealthCardAgeDetailBean> hcAgeUpdateDetailList = new 	ArrayList<blHcard.HealthCardAgeDetailBean>();
			ArrayList<blHcard.HealthCardVisitRuleBean> hcVisitUpdateDetailList = new ArrayList<blHcard.HealthCardVisitRuleBean>();
			ArrayList<blHcard.HealthCardCashBillingGroupBean> hcBlngUpdateGrpList = new ArrayList<blHcard.HealthCardCashBillingGroupBean>();
			ArrayList<blHcard.HealthCardAgeDetailBean> hcAgeUpdateInsDetailList = new 	ArrayList<blHcard.HealthCardAgeDetailBean>();
			ArrayList<blHcard.HealthCardVisitRuleBean> hcVisitUpdateInsDetailList = new ArrayList<blHcard.HealthCardVisitRuleBean>();

			HealthCareMasterBean bean =null;
			

			if(dbOperation.equals("update")){				
				
				String beanId = "HealthCareMasterBean";
				String beanName = "eBL.HealthCareMasterBean";
				bean =(HealthCareMasterBean) getBeanObject(beanId, beanName, request);
				
				
				hcAgeExistingDetailList=bean.getHcAgeDetailList();
				hcVisitExistingDetailList=bean.getHcVisitDetailList();
				hcBlngExistingGrpList=bean.getHcBlngGrpList();
				
				System.out.println(" hcAgeExistingDetailList="+hcAgeExistingDetailList.size()+" hcVisitExistingDetailList="+hcVisitExistingDetailList.size()+" hcBlngExistingGrpList="+hcBlngExistingGrpList.size());
				
				/* Takes the (count value of Records Added + Existing Count ) for Update Comparison */
				ageGroupCount+=hcAgeExistingDetailList.size();
				clinicCount+=hcVisitExistingDetailList.size();
				billingGroupCount+=hcBlngExistingGrpList.size();

			}
		

			for(int i=0;i<=ageGroupCount;i++){
				/* Null Validation made to skip empty Records */
				if(!(nulltoStr(request.getParameter("minAgeInYrs"+i)).equals("") && nulltoStr(request.getParameter("minAgeInMths"+i)).equals("") && nulltoStr(request.getParameter("minAgeInDays"+i)).equals(""))
					||!(nulltoStr(request.getParameter("maxAgeInYrs"+i)).equals("") && nulltoStr(request.getParameter("maxAgeInMths"+i)).equals("") && nulltoStr(request.getParameter("maxAgeInDays"+i)).equals("")) 
				  ){
				blHcard.HealthCardAgeDetailBean ageDetails =new blHcard.HealthCardAgeDetailBean();
				ageDetails.setMinAgeInYrs(stringToNumber(request.getParameter("minAgeInYrs"+i)));
				ageDetails.setMinAgeInMths(stringToNumber(request.getParameter("minAgeInMths"+i)));
				ageDetails.setMinAgeInDays(stringToNumber(request.getParameter("minAgeInDays"+i)));
				ageDetails.setMaxAgeInYrs(stringToNumber(request.getParameter("maxAgeInYrs"+i)));
				ageDetails.setMaxAgeInMths(stringToNumber(request.getParameter("maxAgeInMths"+i)));
				ageDetails.setMaxAgeInDays(stringToNumber(request.getParameter("maxAgeInDays"+i)));
				ageDetails.setPriceClassCode(nulltoStr(request.getParameter("priceClassCode"+i)));
				ageDetails.setMembershipFeesCode(nulltoStr(request.getParameter("membershipFeesCode"+i)));
				hcAgeDetailList.add(ageDetails);
				//System.out.println(" @ageDetails="+ageDetails);
				}
			}
			
			
			for(int i=0;i<=clinicCount;i++){
				if(!nulltoStr(request.getParameter("clinic"+i)).equals("") && !nulltoStr(request.getParameter("visitType"+i)).equals("") )
				{
				blHcard.HealthCardVisitRuleBean clinic =new blHcard.HealthCardVisitRuleBean();
				clinic.setClinicCode(nulltoStr(request.getParameter("clinic"+i)));
				clinic.setVisitTypeCode(nulltoStr(request.getParameter("visitType"+i)));
				clinic.setNoOfVisitsAllowed(nulltoStr(request.getParameter("visitCount"+i)));
				clinic.setClinicSelected(Boolean.parseBoolean(request.getParameter("clinicSelected"+i)) ?"Y":"N");
				hcVisitDetailList.add(clinic);
				//System.out.println(" @Visit="+clinic);
				}
			}
			
			for(int i=0;i<=billingGroupCount;i++){
				if(!nulltoStr(request.getParameter("billingGroupCode"+i)).equals("") )
				{
				blHcard.HealthCardCashBillingGroupBean bgCode = new blHcard.HealthCardCashBillingGroupBean();
				bgCode.setBlngGrpId(nulltoStr(request.getParameter("billingGroupCode"+i)));
				bgCode.setBlngGroupdescription(nulltoStr(request.getParameter("billingGroupDescription"+i)));	
				hcBlngGrpList.add(bgCode);
				//System.out.println(" @BillingGroup="+bgCode);
				}
			}
			
			System.out.println(" ageGroupCount="+hcAgeDetailList.size()+" clinicCount="+hcVisitDetailList.size()+" billingGroupCount="+hcBlngGrpList.size());
			
			if(dbOperation.equals("update")){			
			
				if( 
				   !(nulltoStr(bean.getCardTypeCode()).equals(cardTypeCode) &&
					nulltoStr(bean.getLongDescription()).equals(longDescription)	&&
					nulltoStr(bean.getShortDescription()).equals(shortDescription)&&
					nulltoStr(bean.getValidDays()).equals(validDays)&&
					nulltoStr(bean.getNoOfPat()).equals(noOfPat)&&
					nulltoStr(bean.getEffectiveFrom()).equals(effectiveFrom)&&
					nulltoStr(bean.getEffectiveTo()).equals(effectiveTo)&&
					nulltoStr(bean.getCardStatus()).equals(cardStatus)&&
					nulltoStr(bean.getNoOfVisits()).equals(noOfVisits))
				){					
					inputParameters.put("headerModified","Y"); 					
				}				
					
				for(int i=0;i<hcAgeExistingDetailList.size();i++){
					if(!hcAgeExistingDetailList.get(i).equals(hcAgeDetailList.get(i))){
						hcAgeUpdateDetailList.add(hcAgeDetailList.get(i));
						System.out.println("Record Modified:"+hcAgeDetailList.get(i));
					}
				}
				for(int i=hcAgeExistingDetailList.size();i<hcAgeDetailList.size();i++){
						hcAgeUpdateInsDetailList.add(hcAgeDetailList.get(i));
						System.out.println("Record Added:"+hcAgeDetailList.get(i));
				}	
				
				for(int i=0;i<hcVisitExistingDetailList.size();i++){
					if(!hcVisitExistingDetailList.get(i).equals(hcVisitDetailList.get(i))){
						hcVisitUpdateDetailList.add(hcVisitDetailList.get(i));
						System.out.println("Record Modified:"+hcVisitDetailList.get(i));
					}
				}
				for(int i=hcVisitExistingDetailList.size();i<hcVisitDetailList.size();i++){
					hcVisitUpdateInsDetailList.add(hcVisitDetailList.get(i));
					System.out.println("Record Added:"+hcVisitDetailList.get(i));
				}
				
				for(int i=0;i<hcBlngExistingGrpList.size();i++){
					if(!hcBlngExistingGrpList.get(i).equals(hcBlngGrpList.get(i))){
						hcBlngUpdateGrpList.add(hcBlngGrpList.get(i));
						System.out.println("Record Modified:"+hcBlngGrpList.get(i));
					}
				}
				for(int i=hcBlngExistingGrpList.size();i<hcBlngGrpList.size();i++){
					hcBlngUpdateGrpList.add(hcBlngGrpList.get(i));
					System.out.println("Record Added:"+hcBlngGrpList.get(i));
				}				
				
/*				System.out.println(hcAgeUpdateDetailList.size());
				System.out.println(hcVisitUpdateDetailList.size());
				System.out.println(hcBlngUpdateGrpList.size());
				System.out.println(hcAgeUpdateInsDetailList.size());
				System.out.println(hcVisitUpdateInsDetailList.size());	*/		
				
			}   


			System.out.println(inputParameters);
			
			if(dbOperation.equals("insert")){
			
			//Added newly to check if EJB Works
			HashMap listParam = new HashMap();
			listParam.put("ageList", hcAgeDetailList);
			listParam.put("visitList", hcVisitDetailList);
			listParam.put("bgList", hcBlngGrpList);
			//Added newly to check if EJB Works
			Object argArray[] = new Object[3]; //Changed from 5 to 3
			argArray[0] = p;
			argArray[1] = inputParameters;
			argArray[2] = listParam;
			/*argArray[2] = hcAgeDetailList;
			argArray[3] = hcVisitDetailList;
			argArray[4] = hcBlngGrpList;*/

			Class[] paramArray = new Class[3]; //Changed from 5 to 3
			paramArray[0] = p.getClass();
			paramArray[1] = inputParameters.getClass();	
			paramArray[2] = listParam.getClass();
			/*paramArray[2] = hcAgeDetailList.getClass();
			paramArray[3] = hcVisitDetailList.getClass();
			paramArray[4] = hcBlngGrpList.getClass();*/		

			
			HashMap<String,String> results = new HashMap<String,String>();
			results=(HashMap<String,String>) (busObj
					.getClass().getMethod("insertRecords",paramArray))
					.invoke(busObj, argArray);

			boolean inserted = Boolean.parseBoolean(results.get("status"));
			String errorId = nulltoStr(results.get("error"));
			String message = nulltoStr(results.get("message"));
			String sysError =nulltoStr(results.get("sys_error"));
			String errorValue="0";
			
			System.out.println("************ EJB call Successful *****************" + results);
			
			if(inserted)
			{
				errorValue = "1" ;		
				
				Hashtable messageHashtable=new Hashtable();
				messageHashtable=MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
				String successMsg=(String)messageHashtable.get("message");
				response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( successMsg,"UTF-8" ) +"&err_value="+errorValue);
			}
			else
			{				
				if(!sysError.equals(""))
				{
					response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( sysError.toString(),"UTF-8" ) +"&err_value="+errorValue);
				}
				else if(!message.equals(""))
				{
					
					Hashtable messageHashtable=new Hashtable();
					String msg="";
					
					if(message.indexOf("|") != (-1)){
						StringTokenizer	msgIds=new StringTokenizer(message,"|");
						while(msgIds.hasMoreTokens())
						{
							messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
							msg=msg+(String)messageHashtable.get("message")+"<br>";													
						}
						
					}else{								
						messageHashtable=MessageManager.getMessage(locale,message,"BL");
						msg=msg+(String)messageHashtable.get("message");
					
					}		

					response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ) +"&err_value="+errorValue);
				}
				else if(!errorId.equals(""))
				{						
					response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( errorId,"UTF-8" ) +"&err_value="+errorValue);
				}	 			
			} 
			
			}
			
			
			if(dbOperation.equals("update")){
				
				//Added newly to check if EJB Works
				HashMap listParam = new HashMap();
				listParam.put("ageUpdList", hcAgeUpdateDetailList);
				listParam.put("visitUpdList", hcVisitUpdateDetailList);
				listParam.put("bgUpdList", hcBlngUpdateGrpList);
				listParam.put("ageUpdInsList", hcAgeUpdateInsDetailList);
				listParam.put("visitUpdInsList", hcVisitUpdateInsDetailList);
				//Added newly to check if EJB Works
				Object argArray[] = new Object[3]; //Changed from 7 to 3
				argArray[0] = p;
				argArray[1] = inputParameters;
				argArray[2] = listParam;
				/*argArray[2] = hcAgeUpdateDetailList;
				argArray[3] = hcVisitUpdateDetailList;
				argArray[4] = hcBlngUpdateGrpList;
				argArray[5] = hcAgeUpdateInsDetailList;
				argArray[6] = hcVisitUpdateInsDetailList;*/
				Class[] paramArray = new Class[3]; //Changed from 7 to 3
				paramArray[0] = p.getClass();
				paramArray[1] = inputParameters.getClass();	
				paramArray[2] = listParam.getClass();
				/*paramArray[2] = hcAgeUpdateDetailList.getClass();
				paramArray[3] = hcVisitUpdateDetailList.getClass();
				paramArray[4] = hcBlngUpdateGrpList.getClass();
				paramArray[5] = hcAgeUpdateInsDetailList.getClass();
				paramArray[6] = hcVisitUpdateInsDetailList.getClass();	*/
							
				HashMap<String,String> results = new HashMap<String,String>();
				results=(HashMap<String,String>) (busObj
						.getClass().getMethod("updateRecords",paramArray))
						.invoke(busObj, argArray);

				boolean inserted = Boolean.parseBoolean(results.get("status"));
				String errorId = nulltoStr(results.get("error"));
				String message = nulltoStr(results.get("message"));
				String sysError =nulltoStr(results.get("sys_error"));
				String errorValue="0";
				
				System.out.println("************ EJB call Successful *****************" + results);
				
				if(inserted)
				{
					errorValue = "1" ;		
					
					Hashtable messageHashtable=new Hashtable();
					messageHashtable=MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
					String successMsg=(String)messageHashtable.get("message");
					response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( successMsg,"UTF-8" ) +"&err_value="+errorValue);
				}
				else
				{				
					if(!sysError.equals(""))
					{
						response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( sysError.toString(),"UTF-8" ) +"&err_value="+errorValue);
					}
					else if(!message.equals(""))
					{
						
						Hashtable messageHashtable=new Hashtable();
						String msg="";
						
						if(message.indexOf("|") != (-1)){
							StringTokenizer	msgIds=new StringTokenizer(message,"|");
							while(msgIds.hasMoreTokens())
							{
								messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
								msg=msg+(String)messageHashtable.get("message")+"<br>";													
							}
							
						}else{								
							messageHashtable=MessageManager.getMessage(locale,message,"BL");
							msg=msg+(String)messageHashtable.get("message");
						
						}		

						response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(msg,"UTF-8" ) +"&err_value="+errorValue);
					}
					else if(!errorId.equals(""))
					{						
						response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( errorId,"UTF-8" ) +"&err_value="+errorValue);
					}	 			
				} 
				
				
				
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		Object obj = PersistenceHelper.getBeanObject(id,ClassName,request);		
		return obj;
	}

}
