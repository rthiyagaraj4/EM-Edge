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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.MessageManager;

import  blHcard.BillingPrevilageCardMemberLocalBean;
import  blHcard.BillingPrevilageCardPatientLocalBean;


import com.ehis.eslp.ServiceLocator;
import com.ehis.persist.PersistenceHelper;

/**
 * Servlet implementation class for BillingMaintainPrevilageCardDetails
 */
public class MaintainPrevilageCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
	String mode												=	"";
	String tab 												=	null;
	String bean_id											= 	null;
	String bean_name										= 	null;
	String bean_id1											= 	null;
	String bean_name1										= 	null;
	String operation										=	"";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaintainPrevilageCardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		session = request.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = this.p.getProperty("client_ip_address"); 
		login_user = this.p.getProperty( "login_user" ) ;
		locale = this.p.getProperty("LOCALE") ;
		
		

		
		try
		{
			this.out = response.getWriter();
			System.out.println("rwoCount in TABDATA::: "+request.getParameter("rowCount"));
			tabdata = populateTabData(request,response);
			modifyData(request, response,tabdata);
		}
		catch(Exception e)
		{
			out.println("Exception in MaintainPrevilageCardServlet - DoPost:: "+e.toString());
			System.out.println("Exception in MaintainPrevilageCardServlet - DoPost:: "+e);
		}
	}
	/**
	 * @param request
	 * @param response
	 * @return HashMap - tabdata 
	 * purpose - Populate BillingGroupCategoriesHeader/Details view form values from BillingGroupCategoriesHeader/Details Bean object 
	 * carries the form values to EJB
	 */
	private HashMap populateTabData(HttpServletRequest request, HttpServletResponse response)
	{
		
		
		String 	primaryPatientId										= 	"";
		String 	primaryPatientPriceClassCode							= 	"";
		String 	primaryPatientMemberFess								= 	"";
		String 	primaryPatientToDate									= 	"";
		String 	oPVisitsAllowed											= 	"";
		String 	oPVisitsUtilized										= 	"";
		String 	additionalPatientId										= 	"";
		String 	effectiveFrom											=	"";
		String 	hCardSeqNo												=	"";
		String  cardTypeCode											=	"";
		String 	packageCode												=	"";
		String 	priceClassCode											=	"";
		String billingServiceCode										=	"";
		int 	rowCount												=	0;
		
		ArrayList 	previlageCardAdditionalPatientList					=	null;
		ArrayList 	previlageCardDeletePatientList						=	null;
		ArrayList 	previlageCardModifyPatientList						=	null;
		ArrayList 	previlageCardHeaderPatientList						=	null;
		
		
		
		
		
		

		
		try
		{
			this.out = response.getWriter();
			tabdata															=	new HashMap();
			rowCount														= 	Integer.parseInt(request.getParameter("rowCount"));	 
			bean_id															= 	"BillingPrevilageCardMemberLocalBean" ;
			bean_name														= 	"eBL.BillingPrevilageCardMemberLocalBean";
		/*	BillingPrevilageCardMemberLocalBean billingPrevilageCardMemberBean	= 	(BillingPrevilageCardMemberLocalBean)PersistenceHelper.getBeanObject( bean_id, bean_name, request ) ;
			bean_id1														= 	"BillingPrevilageCardPatientLocalBean" ;
			bean_name1														= 	"eBL.BillingPrevilageCardPatientLocalBean";
			BillingPrevilageCardPatientLocalBean billingPrevilageCardPatientBean	= 	(BillingPrevilageCardPatientLocalBean)PersistenceHelper.getBeanObject( bean_id1, bean_name1, request ) ;
			*/
			BillingPrevilageCardMemberLocalBean billingPrevilageCardMemberBean	=  new BillingPrevilageCardMemberLocalBean();

			BillingPrevilageCardPatientLocalBean billingPrevilageCardPatientBean	= 	new BillingPrevilageCardPatientLocalBean();


			System.out.println("rwoCount in AFTER ::: "+rowCount); 
			System.out.println("hiddenPatientId "+request.getParameter("hiddenPatientId"));
			previlageCardAdditionalPatientList								=	new ArrayList();
			previlageCardDeletePatientList									=	new ArrayList();
			previlageCardModifyPatientList									=	new ArrayList();
			previlageCardHeaderPatientList									=	new ArrayList();
			
			billingPrevilageCardPatientBean									=	new BillingPrevilageCardPatientLocalBean();
			hCardSeqNo														=	checkForNull(request.getParameter("hCardSeqnNo"));
			//primaryPatientId												=	checkForNull(request.getParameter("hiddenPatientId"));	
			primaryPatientId												=	checkForNull(request.getParameter("primaryPatientId"));	
			cardTypeCode													=	checkForNull(request.getParameter("hiddenCardTypeCode"));
			effectiveFrom													=	checkForNull(request.getParameter("from_date"));	
			primaryPatientToDate											=	checkForNull(request.getParameter("to_date"));	
			primaryPatientPriceClassCode									=	checkForNull(request.getParameter("hiddenPriceClasscode"));	
			packageCode														=	checkForNull(request.getParameter("hiddenhiddenPackageCode"));
			primaryPatientMemberFess										=	checkForNull(request.getParameter("member_fees"));	
			oPVisitsAllowed													=	checkForNull(request.getParameter("oPAllotement"));	
			oPVisitsUtilized												=	checkForNull(request.getParameter("oPAvailed"));	
			billingServiceCode												=	checkForNull(request.getParameter("billingServiceCode"));
			
			
			System.out.println("primaryPatientPriceClassCode in SERVELET:::: "+primaryPatientPriceClassCode);
			System.out.println("oPVisitsAllowed in SERVELET:::: "+oPVisitsAllowed);
			System.out.println("oPVisitsUtilized in SERVELET:::: "+oPVisitsUtilized);
			
			billingPrevilageCardPatientBean.setHcardSeqNo(hCardSeqNo);
			billingPrevilageCardPatientBean.setPatientId(primaryPatientId);
			billingPrevilageCardPatientBean.setPrimaryPatientId(primaryPatientId);
			billingPrevilageCardPatientBean.setPrevilageCardTypeCode(cardTypeCode);
			billingPrevilageCardPatientBean.setPrevilageCardFromDate(effectiveFrom);
			billingPrevilageCardPatientBean.setPrevilageCardToDate(primaryPatientToDate);
			billingPrevilageCardPatientBean.setPrevilageCardPriceClassCode(primaryPatientPriceClassCode);
			billingPrevilageCardPatientBean.setPackageCode(packageCode);
			billingPrevilageCardPatientBean.setPrevilageCardMemberFees(primaryPatientMemberFess);
			billingPrevilageCardPatientBean.setOpVistsAllowed(oPVisitsAllowed);
			billingPrevilageCardPatientBean.setOpVistsAvailed(oPVisitsUtilized);
			billingPrevilageCardPatientBean.setBillingServiceCode(billingServiceCode);
			
			
			previlageCardHeaderPatientList.add(billingPrevilageCardPatientBean);
			
			for(int i=0;i<rowCount;i++)
			{
					System.out.println("type["+i+"]:::: "+request.getParameter("type"+i));
					 if(request.getParameter("type"+i).equalsIgnoreCase("insert")) 
					 {
						 billingPrevilageCardMemberBean							=   new BillingPrevilageCardMemberLocalBean();
						 //primaryPatientId										= 	checkForNull(request.getParameter("hiddenPatientId"));		 
						 primaryPatientId										= 	checkForNull(request.getParameter("primaryPatientId"));		 
						 additionalPatientId									=	checkForNull(request.getParameter("patient_id"+i));
						 effectiveFrom											=	checkForNull(request.getParameter("from_date"));
						 hCardSeqNo												=	checkForNull(request.getParameter("hCardSeqnNo"));
						 cardTypeCode											=	checkForNull(request.getParameter("hiddenCardTypeCode"));
						 packageCode											=	checkForNull(request.getParameter("hiddenhiddenPackageCode"));
						 priceClassCode											=	checkForNull(request.getParameter("price_class_Code"+i));
						 
						 
						 
						 billingPrevilageCardMemberBean.setPrimaryPatientId(primaryPatientId);
						 billingPrevilageCardMemberBean.setAdditionalPatientId(additionalPatientId);
						 billingPrevilageCardMemberBean.setEffectiveFrom(effectiveFrom);
						 billingPrevilageCardMemberBean.setHcardSeqno(hCardSeqNo);
						 billingPrevilageCardMemberBean.setCardTypeCode(cardTypeCode);
						 billingPrevilageCardMemberBean.setPackageCode(packageCode);
						 previlageCardAdditionalPatientList.add(billingPrevilageCardMemberBean);
					 }
					 if(request.getParameter("type"+i).equalsIgnoreCase("modify"))
					 {
						 if(request.getParameter("chk"+i)!=null && request.getParameter("chk"+i).equalsIgnoreCase("y"))
						 {
							 billingPrevilageCardMemberBean						=   new BillingPrevilageCardMemberLocalBean();
							 //primaryPatientId									= 	checkForNull(request.getParameter("hiddenPatientId"));	
							 primaryPatientId									= 	checkForNull(request.getParameter("primaryPatientId"));		 
							 additionalPatientId								=	checkForNull(request.getParameter("patient_id"+i));				
							 effectiveFrom										=	checkForNull(request.getParameter("from_date"));	
							 hCardSeqNo											=	checkForNull(request.getParameter("hCardSeqnNo"));
							 cardTypeCode										=	checkForNull(request.getParameter("hiddenCardTypeCode"));
							 billingPrevilageCardMemberBean.setPrimaryPatientId(primaryPatientId);
							 billingPrevilageCardMemberBean.setAdditionalPatientId(additionalPatientId);
							 billingPrevilageCardMemberBean.setEffectiveFrom(effectiveFrom);
							 billingPrevilageCardMemberBean.setHcardSeqno(hCardSeqNo);
							 billingPrevilageCardMemberBean.setCardTypeCode(cardTypeCode);
							 billingPrevilageCardMemberBean.setPackageCode(packageCode);
							 previlageCardDeletePatientList.add(billingPrevilageCardMemberBean);

						 }
						 else
						 {
							 billingPrevilageCardMemberBean						=   new BillingPrevilageCardMemberLocalBean();
							 hCardSeqNo											=	checkForNull(request.getParameter("hCardSeqnNo"));
							 additionalPatientId								=	checkForNull(request.getParameter("patient_id"+i));
							 priceClassCode										=	checkForNull(request.getParameter("price_class_Code"+i));
							 packageCode										=	checkForNull(request.getParameter("hiddenhiddenPackageCode"));
							 billingPrevilageCardMemberBean.setHcardSeqno(hCardSeqNo);
							 billingPrevilageCardMemberBean.setAdditionalPatientId(additionalPatientId);
							 billingPrevilageCardMemberBean.setAdditionalPatientPriceClasscode(priceClassCode);
							 billingPrevilageCardMemberBean.setPackageCode(packageCode);
							 previlageCardModifyPatientList.add(billingPrevilageCardMemberBean);
						 }
 					 }
 
				  
			 }
			for(int i=0;i<previlageCardHeaderPatientList.size();i++) 
			 {
				billingPrevilageCardPatientBean = (BillingPrevilageCardPatientLocalBean)previlageCardHeaderPatientList.get(i);
				System.out.println("hCardSeqNo						Header 	:: "+billingPrevilageCardPatientBean.getHcardSeqNo());
				 System.out.println("primaryPatientId 				Header	:: "+billingPrevilageCardPatientBean.getPatientId());
				 System.out.println("cardTypeCode					Header	:: "+billingPrevilageCardPatientBean.getPrevilageCardTypeCode());
				 System.out.println("effectiveFrom 					Header	:: "+billingPrevilageCardPatientBean.getPrevilageCardFromDate()); 
				 System.out.println("primaryPatientToDate			Header 	:: "+billingPrevilageCardPatientBean.getPrevilageCardToDate());
				 System.out.println("primaryPatientPriceClassCode 	Header	:: "+billingPrevilageCardPatientBean.getPrevilageCardPriceClassCode());
				 System.out.println("packageCode					Header	:: "+billingPrevilageCardPatientBean.getPackageCode());
				 System.out.println("primaryPatientMemberFess 		Header	:: "+billingPrevilageCardPatientBean.getPrevilageCardMemberFees());
				 System.out.println("oPVisitsAllowed 				Header	:: "+billingPrevilageCardPatientBean.getOpVistsAllowed());
				 System.out.println("oPVisitsUtilized 				Header	:: "+billingPrevilageCardPatientBean.getOpVistsAvailed());
				 System.out.println("billingServiceCode 			Header	:: "+billingPrevilageCardPatientBean.getBillingServiceCode());
			 }
			for(int i=0;i<previlageCardModifyPatientList.size();i++) 
			 {
				billingPrevilageCardMemberBean = (BillingPrevilageCardMemberLocalBean)previlageCardModifyPatientList.get(i);
				 System.out.println("hCardSeqNo						Modify 	:: "+billingPrevilageCardMemberBean.getHcardSeqno());
				 System.out.println("additionalPatientId 			Modify	:: "+billingPrevilageCardMemberBean.getAdditionalPatientId());
				 System.out.println("priceClassCode					Modify	:: "+billingPrevilageCardMemberBean.getAdditionalPatientPriceClasscode());
				 System.out.println("packageCode 					Modify	:: "+billingPrevilageCardMemberBean.getPackageCode()); 
			 }
			for(int i=0;i<previlageCardAdditionalPatientList.size();i++) 
			 {
				billingPrevilageCardMemberBean = (BillingPrevilageCardMemberLocalBean)previlageCardAdditionalPatientList.get(i);
				 System.out.println("primaryPatientId				Insert 	:: "+billingPrevilageCardMemberBean.getPrimaryPatientId());
				 System.out.println("additionalPatientId 			Insert	:: "+billingPrevilageCardMemberBean.getAdditionalPatientId());
				 System.out.println("effectiveFrom 					Insert	:: "+billingPrevilageCardMemberBean.getEffectiveFrom());
				 System.out.println("hCardSeqNo 					Insert	:: "+billingPrevilageCardMemberBean.getHcardSeqno());
				 System.out.println("cardTypeCode 					Insert	:: "+billingPrevilageCardMemberBean.getCardTypeCode());
				 System.out.println("packageCode 					Insert	:: "+billingPrevilageCardMemberBean.getPackageCode());
				
			 }
			for(int i=0;i<previlageCardDeletePatientList.size();i++) 
			 {
				billingPrevilageCardMemberBean = (BillingPrevilageCardMemberLocalBean)previlageCardDeletePatientList.get(i);
				 System.out.println("primaryPatientId				Delete 	:: "+billingPrevilageCardMemberBean.getPrimaryPatientId());
				 System.out.println("additionalPatientId 			Delete	:: "+billingPrevilageCardMemberBean.getAdditionalPatientId());
				 System.out.println("effectiveFrom 					Delete	:: "+billingPrevilageCardMemberBean.getEffectiveFrom());
				 System.out.println("hCardSeqNo 					Delete	:: "+billingPrevilageCardMemberBean.getHcardSeqno());
				 System.out.println("cardTypeCode 					Delete	:: "+billingPrevilageCardMemberBean.getCardTypeCode());
				 System.out.println("packageCode 					Delete	:: "+billingPrevilageCardMemberBean.getPackageCode());
				
			 }
		/*	com.ehis.persist.PersistenceHelper.putObjectInBean(bean_id1, billingPrevilageCardPatientBean, request);
			com.ehis.persist.PersistenceHelper.putObjectInBean(bean_id, billingPrevilageCardMemberBean, request);
		*/	
			 tabdata.put("previlageCardHeaderPatientList", previlageCardHeaderPatientList);
			 tabdata.put("previlageCardAdditionalPatientList", previlageCardAdditionalPatientList);
			 tabdata.put("previlageCardDeletePatientList", previlageCardDeletePatientList);
			 tabdata.put("previlageCardModifyPatientList", previlageCardModifyPatientList);
			 tabdata.put("FACILITY_ID",facilityId);
			 tabdata.put("client_ip_address",client_ip_address);
			 tabdata.put("login_user",login_user);
			 tabdata.put("locale",locale);
			 System.out.println("Data in  TABDATA::: "+tabdata); 
			 
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION IN MaintainPrevilageCardServlet TABDATA::: "+e);
		}
		
			

		return tabdata;
	}
	
	/**
	 * @param request
	 * @param response
	 * calls insert method in EnterPriseServiceGroupManager EJB
	 * Based on the error message redirected to the error page
	 */
	private void modifyData(HttpServletRequest request,HttpServletResponse response, HashMap tabdata)
	{
		
		String error 		=   "";
		String message 		=   "";
		String sys_error 	=   "";
		String error_value  =   "";
		String inserted		=	"";
		try 
		{	
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;
			Object home =ServiceLocator.getInstance().getHome("java:comp/env/PkgCardSubscription",eBL.PkgCardSubscription.PkgCardSubscriptionLocalHome.class, local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home, null);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;
			Class[] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();	
			HashMap<String,String> results = (HashMap<String,String>) (busObj.getClass().getMethod("insert", paramArray)).invoke(busObj, argArray);	 
			System.out.println("INSIDE SERVLET MNAGER results RSPINSE::::: "+results);
			(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);
			inserted = (String) results.get("status");
			//error = (String) results.get("error");
			//message = (String) results.get("message");
			//sys_error = (String) results.get("sys_error");
			//error_value="0"; 

			//String error = "";
			String mapValue = "";
			int err_val = 1;
			for (Iterator iterator = results.keySet().iterator(); iterator.hasNext();) {
				String type = (String) iterator.next();
				System.out.println("type in servlet from results:::: "+type);
				if(!type.equalsIgnoreCase("status"))
				{
					mapValue = results.get(type);
				}
				System.out.println("mapValue in servlet from results:::: "+mapValue);
				if(mapValue != null){
					//if(mapValue.contains("Error")){
						error = error+mapValue+"<br/>";
						err_val = 2;
					//}				
				}
			}
			System.out.println("error aftrer servlet response from ejb:: "+error);
			if(inserted.equalsIgnoreCase("true"))
			{
				//error = "Operation Completed Sucessfully";
				error_value = "1" ;		
				Hashtable messageHashtable=new Hashtable();
				messageHashtable=MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
				String success_msg=(String)messageHashtable.get("message");
				response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( success_msg,"UTF-8" ) +"&err_value="+error_value);
			}
			else
			{
				//error = "Record not saved"+"<br/>"+error;
				//response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+err_val);3
				response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+err_val);
			}
/*
			if(inserted)
			{
				error_value = "1" ;		
				Hashtable messageHashtable=new Hashtable();
				messageHashtable=MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
				String success_msg=(String)messageHashtable.get("message");

			response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( success_msg,"UTF-8" ) +"&err_value="+error_value);
			} 
			else
			{
	
				
				if(!sys_error.equals(""))
				{
					response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( sys_error.toString(),"UTF-8" ) +"&err_value="+error_value);
				}
				else if(!message.equals(""))
				{
					
					Hashtable messageHashtable=new Hashtable();
					String msg="";
					StringTokenizer message_st = new StringTokenizer(message,"|");
					while(message_st.hasMoreTokens())
						{
							String sysMessageId = message_st.nextToken();
							messageHashtable=MessageManager.getMessage(locale,sysMessageId,"BL");
							msg=msg+(String)messageHashtable.get("message")+"<br>";
						}						
					response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ) +"&err_value="+error_value);
				}
				else if(!error.equals(""))
				{		
					response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
				}	 
			} */
		}  
		catch (Exception e) 
		{
			System.out.println("exception in insertData - BillingGroupCategoriesServlet-InsertData=" + e.toString());
			e.printStackTrace();
			out.println("<h3> Exception raise by BillingGroupCategoriesServlet-InsertData  ...So Record Not inserted </h3> Foll: Error Received : "
							+ e.toString() );
			out.println("Values sent are : <br>");
		} 

	}
	
	/**
	 * @param str
	 * @return
	 */
	private String checkForNull(String str){
		return (str!=null && str.intern()!="null")?str:"";
	}

	/**
	 * @param str
	 * @param defaultVal
	 * @return
	 */
	private String checkForNull(String str,String defaultVal){
		return (!checkForNull(str).equals(""))?str:defaultVal;
	}

	/**
	 * @return
	 */
	private boolean isLocalEJB(){
		ServletContext servletcontext = getServletConfig().getServletContext();
		if ((servletcontext.getInitParameter("LOCAL_EJBS")!=null) &&(servletcontext.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			return true;
			return false;
	}
	

}
