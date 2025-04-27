<!DOCTYPE html>
<%/*
Sr No        Version           Incident        SCF/CRF                     		Developer Name
-----------------------------------------------------------------------------------------------
 1											AAKH-CRF-0152.3				Monika Gupta
*/ %>
<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*,java.io.*,java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, eCommon.Common.*, webbeans.eCommon.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@page import="org.apache.poi.hssf.usermodel.*"%>
<%@page import="org.apache.poi.hssf.util.*"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>

<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	System.err.println("Persitence file called.deff. for future order");
	
	String params = request.getQueryString();
	String beanId = "bl_BLFutOrdInsApprTrackBean";
	String beanName = "eBL.BLFutOrdInsApprTrackBean";
	System.err.println("Future Order and Insurance Approval Tracking Persitence file called..");
		
	BLFutOrdInsApprTrackBean policyBean = (BLFutOrdInsApprTrackBean) getBeanObject(beanId, beanName, request);
	
	 if(policyBean.getPolicyMap() == null){
		policyBean.setPolicyMap(new HashMap<String, List<BLFutOrdInsApprTrackBean>>());
	} 
	System.err.println("Persitence file called..123");
	HashMap<String, List<BLFutOrdInsApprTrackBean> > policyMap = policyBean.getPolicyMap();
	
	String called_frm = request.getParameter("called_frm");
	
	if("onApply".equals(called_frm))
	{
		try 
		{
		
			request.setCharacterEncoding("UTF-8");
			
			String locale = (String)session.getAttribute("LOCALE");
		//	String func_mode = request.getParameter("func_mode");
			String event = (request.getParameter("event") == null ? "" : request.getParameter("event"));
		
			Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
				hash = (Hashtable)hash.get( "SEARCH" ) ;

			String facilityId = (String)session.getValue( "facility_id" ) ;
			String loggedInUser = (String)session.getValue("login_user");	
			List<BLFutOrdInsApprTrackBean> covList = new ArrayList<BLFutOrdInsApprTrackBean>();
			BLFutOrdInsApprTrackBean covBean = null;
			int rowCount = Integer.parseInt((String)hash.get("rowCount"));	
			
			for(int i=1; i<=rowCount; i++){	
				covBean = new BLFutOrdInsApprTrackBean();	
				System.err.println("covList is:");		
				covBean.setOperating_facility_id((String)hash.get("OPERATING_FACILITY_ID_" + i));
				covBean.setPrimary_key_module_id((String)hash.get("PRIMARY_KEY_MODULE_ID_" + i));
				covBean.setPrimary_key_main((String)hash.get("PRIMARY_KEY_MAIN_" + i));
				covBean.setPrimary_key_line_no((String)hash.get("PRIMARY_KEY_LINE_NO_"+i));
				covBean.setServ_item_code((String)hash.get("SERV_ITEM_CODE_"+i));
				covBean.setBlng_serv_code((String)hash.get("BLNG_SERV_CODE_"+i));
					
				covBean.setAppr_info_to_pat_yn((String)hash.get("APPR_INFO_TO_PAT_YN_" + i));	
				covBean.setAppr_info_by_id((String)hash.get("APPR_INFO_BY_ID_"+i));
				covBean.setAppr_info_date((String)hash.get("APPR_INFO_DATE_"+i));
				covBean.setAppr_start_date((String)hash.get("APPR_START_DATE_"+i));
				covBean.setAppr_expire_date((String)hash.get("APPR_EXPIRE_DATE_"+i));
				covBean.setService_perform_date((String)hash.get("SERVICE_PERFORM_DATE_" + i));
				covBean.setService_status((String)hash.get("SERVICE_STATUS_" + i));
				covBean.setService_remarks((String)hash.get("SERVICE_REMARKS_" + i));
				covBean.setFollow_up_visit_appt_yn((String)hash.get("FOLLOW_UP_VISIT_APPT_YN_" + i));
				covBean.setAppt_date_time((String)hash.get("APPT_DATE_TIME_" + i));
				covBean.setFollow_up_vist_adm((String)hash.get("FOLLOW_UP_VIST_ADM_" + i));

					
				if(!("".equals(covBean.getOperating_facility_id()) && "".equals(covBean.getPrimary_key_module_id()) && "".equals(covBean.getPrimary_key_main()) 
					&& "".equals(covBean.getPrimary_key_line_no()) && "".equals(covBean.getServ_item_code()) && "".equals(covBean.getBlng_serv_code()))){
						
						if(!"".equals(covBean.getAppr_info_to_pat_yn()) || !"".equals(covBean.getAppr_info_by_id()) || !"".equals(covBean.getAppr_info_date()) || !"".equals(covBean.getAppr_start_date()) || !"".equals(covBean.getAppr_expire_date()) || !"".equals(covBean.getService_perform_date()) || !"".equals(covBean.getService_status()) || !"".equals(covBean.getService_remarks()) || !"".equals(covBean.getFollow_up_visit_appt_yn()) || !"".equals(covBean.getAppt_date_time()) || !"".equals(covBean.getFollow_up_vist_adm())){
							covList.add(covBean); 
						}
				}  
			}  
			if(!(covList.isEmpty())){
				policyMap.put("BLFutOrdInsApprTrackInfo", covList); 
				System.err.println("Data is in CovList.."+covList.size());
			}
		}catch (Exception e) {	
			e.printStackTrace();
			System.err.println("Exception from BLFutOrdInsApprTrackPersistence :" + e);
		} 
		putObjectInBean("bl_BLFutOrdInsApprTrackBean",policyBean,request);	
	}
%>
