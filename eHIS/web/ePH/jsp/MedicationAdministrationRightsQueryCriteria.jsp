<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.util.ArrayList,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
<script language='javascript' src='../../ePH/js/MedicationAdministrationRights.js'></script>
<%
	try {
		ecis.utils.CommonQueryPage queryPage = new ecis.utils.CommonQueryPage();
		StringBuffer htmlTag = new StringBuffer();
		String function_id = request.getParameter( "function_id" );
		String defaultSelect1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String cancelAdmin=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.CancelAdmin.label","ph_labels");
		
		String disp_type_list="A,&nbsp;&nbsp;--"+defaultSelect1+"--&nbsp;&nbsp;,Y,"+cancelAdmin;
		ArrayList components = new ArrayList();
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.UserID.label","ss_labels"));
		firstItem.add("user_id");
		firstItem.add("30");
		firstItem.add("30");
		components.add(firstItem);

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.UserName.label","ss_labels"));
		secondItem.add("appl_user_name");
		secondItem.add("60");
		secondItem.add("60");
		components.add(secondItem);

		ArrayList thirdItem=new ArrayList();
		thirdItem.add("List");									//	Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MedicationAdminstrationRightsType.label","ph_labels"));							//	Label
		thirdItem.add("right_type");								//	Name of field
		thirdItem.add(disp_type_list);	//	static values that need to be displayed as option.Send it along with the value that is inserted.
		
		components.add(thirdItem); 


		ArrayList items=new ArrayList();
		items.add("Hidden");
		items.add("function_id");
		items.add(function_id);
		components.add(items);

		String[] headers = new String[2];
		headers[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.UserID.label","ss_labels");
		headers[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.UserName.label","ss_labels");
		//headers[2] = "Medication Adminstration Right Type";
		

		String[] values = new String[3];
		values[0]="user_id";
		values[1]="appl_user_name";
		values[2]="right_type";
		
		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
		String useraccess=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.UserAccessforStore.label","ss_labels");
		htmlTag = queryPage.getQueryPage(null,components,useraccess ,"MedicationAdministrationRightsQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,headers, values,ExecuteQuery);
		out.println(htmlTag);

	}
	catch (java.lang.Exception exception) 	{
		out.println(exception.toString());
	}
%>
