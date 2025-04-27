<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"
	import="java.sql.*,java.util.Hashtable,java.util.ArrayList,java.util.HashMap,java.util.Enumeration,eBL.Common.*,eBL.*,eBL.PreApprovalRequestDetailsBean,eCommon.Common.*,webbeans.eCommon.*"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page"
	class="webbeans.eCommon.XMLStringParser" />
<%
String beanId = "PreApprovalRequestDetailsBean";
String beanName = "eBL.PreApprovalRequestDetailsBean";
ArrayList<String[]> modalList = null;
PreApprovalRequestDetailsBean preApprovalRequestDetailsBean 	=  (PreApprovalRequestDetailsBean)getBeanObject(beanId, beanName, request);
	try 
	{
		request.setCharacterEncoding("UTF-8");
		modalList	= new ArrayList();
		String locale = (String) session.getAttribute("LOCALE");
		Hashtable hash = (Hashtable) xmlObj.parseXMLString(request);
		hash = (Hashtable) hash.get("SEARCH");
		System.out.println(" hash .... Inside BillingRecordApprovalModalValidations.jsp:::: "+hash);
		 for (int i = 0; i < hash.size(); i++) 
		{
			if(hash.get("billing_service_code"+i)!=null && hash.get("billing_service_code"+i)!="")
			{
				String[] tempString = new String[23];
				tempString[0]											=	(String) hash.get("patinetId");
				tempString[1]											=	(String) hash.get("episodeType");
				tempString[2]											=	(String) hash.get("episodeId");
				tempString[3]											=	(String) hash.get("visitId");
				tempString[4]											=	(String) hash.get("encounterId");
				tempString[5]											=	(String) hash.get("policyTypeCode");
				tempString[6]											=	(String) hash.get("custGroupCode");
				tempString[7]											=	(String) hash.get("custCode");
				tempString[8]											=	(String) hash.get("acctSeqNo");
				tempString[9]											=	(String) hash.get("priority");
				tempString[10]											=	(String) hash.get("policyNumber");
				tempString[11]											=	(String) hash.get("billing_grp_id");

				tempString[12]											=	(String) hash.get("billing_service_code"+i);
				tempString[13]											=	(String) hash.get("included_excluded"+i);
				tempString[14]											=	(String) hash.get("approval_number"+i);
				tempString[15]											=	(String) hash.get("app_req_date");
				tempString[16]											=	(String) hash.get("approved_date"+i);
				tempString[17]											=	(String) hash.get("approval_status"+i);
				tempString[18]											=	(String) hash.get("approval_remarks"+i);

				tempString[19]											=	(String) hash.get("status");
				tempString[20]											=	(String) hash.get("effective_from");
				tempString[21]											=	(String) hash.get("available_service_amount"+i);
				tempString[22]											=	(String) hash.get("reason"+i);
				
				if(preApprovalRequestDetailsBean.getPreApprovalRequestModalDetailsList()!=null && preApprovalRequestDetailsBean.getPreApprovalRequestModalDetailsList().size()>0)
				{
					ArrayList<String[]> tempModalList = preApprovalRequestDetailsBean.getPreApprovalRequestModalDetailsList();
					tempModalList.add(tempString);
					preApprovalRequestDetailsBean.setPreApprovalRequestModalDetailsList(tempModalList);
				}
				else
				{
					modalList.add(tempString);
					preApprovalRequestDetailsBean.setPreApprovalRequestModalDetailsList(modalList);
				}
			}
			
		}
		 putObjectInBean(beanId, preApprovalRequestDetailsBean, request);
		
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Exception from BillingRecordApprovalModalValidations.jsp :"+ e);
	}

	 

	
	%>

