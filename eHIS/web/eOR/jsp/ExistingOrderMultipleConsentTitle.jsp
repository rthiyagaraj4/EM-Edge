<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,eOR.*,eOR.Common.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<style>
TD.QRYEVEN1{
    BACKGROUND-COLOR: #F0F0F2;  
	BORDER-STYLE: none;
	border-left-color: #B2B6D7;
	border-right-color: #B2B6D7;
	border-top-color: #E2E3F0;
	border-bottom-color: #E2E3F0;
	height:18px;	
	font-family: Verdana, Arial, Helvetica, sans-serif;	
	font-size: 8pt;	font-weight:normal;text-align:left;padding-left:10px;padding-right:10px;vertical-align:middle;border-bottom:1px;border-top:0px;border-left:0px;border-right:0px;border-style:solid;
       }

TD.QRYODD1{
    BACKGROUND-COLOR: #E2E3F0;  
	BORDER-STYLE: none;
	border-left-color: #B2B6D7;
	border-right-color: #B2B6D7;
	border-top-color: #E2E3F0;
	border-bottom-color: #E2E3F0;
	height:18px;	font-family: Verdana, Arial, Helvetica, sans-serif;	font-size: 8pt;	font-weight:normal;text-align:left;padding-left:10px;padding-right:10px;vertical-align:middle;border-bottom:1px;border-top:0px;border-left:0px;border-right:0px;border-style:solid;
    }
</style>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../js/ConsentOrder.js"></script>
	<script language="JavaScript" src="../../eOR/js/ExistingOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
try{
	String order_catalog_code = request.getParameter("order_catalog_code");
	order_catalog_code		  = (order_catalog_code == null) ? "":order_catalog_code;
	String order_id			  = request.getParameter("order_id");
	order_id				  = (order_id == null) ? "":order_id;
	String order_line_num	  = request.getParameter("order_line_num");
	order_line_num			  = (order_line_num == null) ? "1":order_line_num;
	String viewBy	  = request.getParameter("viewBy");
	viewBy			  = (viewBy == null) ? "":viewBy;
	String[] allValues = new String[39];
	String perform_loc_desc = "";
	Properties properties			= (Properties) session.getValue( "jdbc" );
	String facility_id = (String)session.getAttribute("facility_id")==null?"":(String)session.getAttribute("facility_id");
	String ca_pract_name		= "";
	String max_action_seq_num="";
	//System.out.println("practitioner_name=="+practitioner_name);
	/*Enumeration paramNames = session.getAttributeNames();
	while(paramNames.hasMoreElements())
	{
		String pName = (String)paramNames.nextElement();
		//String paramValue = (String)session.getAttribute(pName);
		System.out.println("pName=="+pName);
	}*/
	String bean_id	 = "Or_ConsentOrders" ;
	String bean_name = "eOR.ConsentOrders";
	String beanobj_id = "Or_ExistingOrder" ;
	String beanobj_name = "eOR.ExistingOrder";
	String location="";
	String patient_details="";

	ExistingOrder beanobj = (ExistingOrder)getBeanObject( beanobj_id, beanobj_name, request ) ;
	//if(viewBy.equals("header"))
	//{
	beanobj.setLanguageId(localeName);
	allValues		= beanobj.viewMainDetails(properties, order_id);

	if(allValues[2] == null  || allValues[2].equals("null") || allValues[2].equals("") )
	{
		allValues[2]="R";
	}
		 
	  if(allValues[2].compareTo("R")==0){
					allValues[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
										
				}
					else if(allValues[2].compareTo("U")==0)
				{
					
					allValues[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
									

				}
					else if(allValues[2].compareTo("S")==0)
				{
				
				allValues[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
					
				}	

	String sex1="";
				
				if (allValues[3].equalsIgnoreCase("M"))
				  sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			  else if(allValues[3].equalsIgnoreCase("F"))
			sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");

			if(allValues[36].equalsIgnoreCase("C"))
	{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
	}
	else if(allValues[36].equalsIgnoreCase("N"))
	{
		location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
	}else if(allValues[36].equalsIgnoreCase("R"))
	{
		location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
	}

			patient_details=allValues[6]+","+sex1+"/"+allValues[34]+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+allValues[35];

	if (allValues.length > 19) {
	   //out.println("<script>alert('"+bean.checkForNull(allValues[18],"").trim()+"')</script>");
	   if (allValues[15] == null) allValues[15] = "";
	   if (allValues[18] == null) allValues[18] = "";
	   if(!allValues[18].equals(""))
		{
	   perform_loc_desc = beanobj.checkForNull(beanobj.getPerformLocnDesc(properties, allValues[18].trim(),allValues[15].trim(),facility_id),"");
		}
		
	}
	String view_bean_id = "Or_ViewOrder" ;
	String view_bean_name = "eOR.ViewOrder";
	//ViewOrder view_bean = (ViewOrder)mh.getBeanObject( view_bean_id, request,  view_bean_name ) ; 
	ViewOrder view_bean		= (ViewOrder)getBeanObject( view_bean_id, view_bean_name, request ) ;
	view_bean.setLanguageId(localeName);
	// From the View Order get the clinical comments if it is there
	//max_action_seq_num	= beanobj.checkForNull(view_bean.getMaxCount(order_id),"");
	max_action_seq_num	= allValues[29];

 	
 	//out.println(allValues.length);
	if(allValues!=null && order_id!=null) {
		//ca_pract_name		= beanobj.checkForNull(view_bean.getOrderPractitioner(order_id),"");
		ca_pract_name		= allValues[30];
	}
	if(ca_pract_name==null)	ca_pract_name = "";
	//}
	ConsentOrders bean		= (ConsentOrders)getBeanObject( bean_id, bean_name, request ) ;
	bean.clearHasp();
	bean.setLanguageId(localeName);
	%>
<form method="post" name="multiple_consent_form_title" id="multiple_consent_form_title">
<table cellpadding=0 cellspacing=0 border=0 width="100%" height="100%" align=center>
	<tr>
		<td  class='label'><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=order_id%></B></td>
		<td  class='label'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=allValues[0]%></B></td>
		
	</tr>
	<tr>
		<td  class='label'><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/> </td>
		<td class='data'><B><%=allValues[1]%></B></td>
		<td  class='label'><fmt:message key="Common.priority.label" bundle="${common_labels}"/> </td>
		<td class='data'><B><%=allValues[2]%></B></td>
	</tr>
	<tr>
		<td  class='label'><fmt:message key="Common.patient.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=patient_details%></B></td>
		<td  class='label'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=(allValues[4] == null) ? "" : allValues[4]%></B></td>
	</tr>
	<tr>
		<td  class='label'><fmt:message key="Common.OrderDateTime.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=com.ehis.util.DateUtils.convertDate(allValues[12],"DMYHM","en",localeName)%></B></td> 
		<td  class='label'><fmt:message key="Common.OrderStatus.label" bundle="${common_labels}"/> </td>
		<td class='data'><B><%=allValues[5]%></B></td>
	</tr>
	<tr>
		<td  class='label'><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=location%>/<%=allValues[38]%></B></td>
		<td  class='label'><fmt:message key="Common.OrderingPractitioner.label" bundle="${common_labels}"/></td>
		<%if (allValues[7]==null) allValues[7]="";%>	
		<td class='data'><B><%=allValues[7]%></B></td>
		</tr>
		<tr>
		<td  class='label'><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=allValues[8]%></B></td>
		<td  class='label'><fmt:message key="Common.PerformingFacility.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=allValues[9]%></B></td>
	</tr>
	<%
	if(allValues[10]==null) allValues[10] = "";
					
					String	date1="";	 
					String	date="";	
              int temp=allValues[10].indexOf("/");
				
				if(temp!=-1)
				{
				 date=allValues[10].substring(temp-2,temp+8);
				
				//System.err.println("temp"+temp+"date"+date);
				
				 if(date.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}"))
				 {
					     if(date.indexOf(":")!=-1)
						{
						 date1 = com.ehis.util.DateUtils.convertDate(date,"DMYHM","en",localeName);
						} 
						else
						{
							 date1 = com.ehis.util.DateUtils.convertDate(date,"DMY","en",localeName);
						}
				}
                    allValues[10]=allValues[10].replace(date,date1);
				}
	 
	%>
	<tr>
		<td  class='label'><fmt:message key="eOR.OrderFormat.label" bundle="${or_labels}"/></td>
		<td class='data'> <a class="gridLink" href="javascript:viewOrderFormat('<%=order_id%>')"><B><%=allValues[10]%></B></a> </td>
		<td  class='label'><% if(!max_action_seq_num.equals("") && !max_action_seq_num.equals("0")){ %>
		<a class="gridLink" href="javascript:viewHeaderComments('<%=order_id%>')"><fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/></a>
		<%} else { out.println(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicalComments.label","common_labels")+"");
		 } %></td><td>
		<%if(allValues[16]!=null) { %><a class="gridLink" href="javascript:viewInstructionMode('<%=allValues[16]%>')"><fmt:message key="eOR.InstructionMode.label" bundle="${or_labels}"/></a><%  }%></td>
		</tr>
 	<% if(ca_pract_name!=null && !ca_pract_name.equals("")) { %>
	<tr>
		<td  class='label'><fmt:message key="eOR.OrderPlacedBy.label" bundle="${or_labels}"/></td>
		<td class='data'><b><%=ca_pract_name%></b> </td>
		<td colspan=2></td>
	</tr>
	<% } %>
	<%if (((perform_loc_desc != null) && (!perform_loc_desc.equals(""))) || (!allValues[20].equals(""))) {%>
	<tr>
		<%
		//int flag = 0;
		if ((perform_loc_desc != null) && (!perform_loc_desc.equals(""))) {
			//flag = 1;
		%>
		   <td class='label'><fmt:message key="Common.PerformingLocation.label" bundle="${common_labels}"/></td>
		   <td class='data'><B><%=perform_loc_desc%></B></td>
	   <%} else {%>
		<%}
	   if (!allValues[20].equals("")) {%>
	   <td class='label' ><a class='gridLink' href='javascript:viewExternalDetails("<%=beanobj.getFacilityName(properties, allValues[20])%>","<%=allValues[21]%>","<%=beanobj.getPractitionerName(properties, allValues[22])%>","<%=allValues[24]%>","<%=allValues[25]%>","<%=allValues[26]%>","<%=beanobj.getPractitionerName(properties,allValues[27])%>","<%=order_id%>","<%=beanobj_id%>","<%=beanobj_name%>")'><fmt:message key="eOR.ExternalDtls.label" bundle="${or_labels}"/></a></td>
	   <%} else {%>
	   
	   <%}%>
	   <td colspan='3'></td>
	</tr>
	<%}%>
<%if(viewBy.equals("line")){%>
	   <script>
				parent.multi_detail.location.href = "../../eOR/jsp/ExistingOrderMultipleConsentForms.jsp?<%=request.getQueryString()%>";
		</script>
			<%}else{%>
		 <script>
				parent.multi_detail.location.href = "../../eOR/jsp/ExistingOrderMultipleConsentHdrForms.jsp?<%=request.getQueryString()%>";
		</script>
			<%}%>
</table>
</form>
</body>

</html>
	
<%
	putObjectInBean(bean_id,bean,request);

}catch(Exception e){
	//out.println(e.toString());//COMMON-ICN-0181
	out.println(e.getMessage());
	e.printStackTrace();
}
	
	
%>

