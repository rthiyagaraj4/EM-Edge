<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>

 <%@page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<%-- Mandatory declarations end --%>
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 		= request.getParameter("bean_id");
	String bean_name 	= request.getParameter("bean_name");
	/* Mandatory checks end */

	/* Initialize Function specific start */
		//OrderEntryBean bean = (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
		 OrderEntryBean bean = (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
			bean.setLanguageId(localeName);
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
	// If it is a new patient set it, other wise get the patient id
	//orderEntryRecordBean.getPatient(bean.getPatientId());
	/* Initialize Function specific end */
 	//String patient_id	 		= bean.checkForNull(request.getParameter("patient_id"),"");
//	Properties properties		= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
//  	String image_id 			= bean.checkForNull(request.getParameter("image_id"),"");
 	String entryValue			= "";
	String prev_group_title		= "";
	String checkedAttribute 	= "";
	String disabled				= "";
	String care_set_order		= "";
	String order_catalog_category = "";
	String key					= (bean.getPatientId()+bean.getEncounterId());
 	//if(!order_category.equals(""))	order_category = order_category.trim();
 	int i=0;int count = 0; // counters for loop
	String amend_key			= "";
	HashMap previousValues		= null;
	HashMap amendPreviousValues = null;
 	StringTokenizer stBillMsg	= null;
	Set setValues 				= null;
	Iterator iterator			= null;
	
	String bill_warn_message	= null;
	String bill_warn_err_message= null;
	String bill_error_message	= null;
	String measure_id			= "" , contr_msr_panel_id = "";
	String category				= "";
%>

<html>
<head><title><fmt:message key="eOR.OrderEntryDrawingToolItems.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>

the alert messages -->
	<script language="javascript" src="../../eOR/js/OrderEntry.js"></script>
	<script language="javascript" src="../../eOR/js/OrderEntrySearch.js"></script>	<!-- forthe setCatalogCode function -->
	<script language="javascript" src="../../eOR/js/DrawingTool.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name ="drawingToolResults">
<table class="BOX" border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
<tr>
<%
		// Since at the maximum there will be 100 or 150 records no need for next/previous
 		//ArrayList DrawingToolsItems =  beanQueryObj.getDrawingToolsItems(properties, image_id,  bean.getLoginFacilityId(), bean.getLocationType(), bean.getLocationCode(), bean.getPatientId(), bean.getEncounterId(), bean.getPatientClass(), bean.getEpisodeID(), bean.getEpisodeVisitNum(), bean.getLoginById(), bean.getResponsibilityId(), bean.getPractitionerType(), bean.getSex(), bean.getDob(), bean.getVisitAdmDate(), bean.getDischargeDateTime());
ArrayList DrawingToolsItems =  null;  //since no longer used tabs 
 	
		String[] records	= null;
		for(i=0; i<DrawingToolsItems.size(); i++)
		{
			checkedAttribute = "";disabled= "";
			records = (String[])DrawingToolsItems.get(i);
			if(!prev_group_title.equals(records[0]))
			{
				if( count%3 > 0)
				{
					 for (int u=0;u<3-count%3;u++)
						out.println("<td width=\"20%\"  colspan=\"3\"  align=\"left\">&nbsp;&nbsp;</td>");
					out.println("</tr>");
				}
				count =0 ;
				out.println("<tr>");
				out.println("<td colspan=\"12\" align=\"center\" class=\"CAGROUP\">"+records[0]+" </td>");
				out.println("</tr><tr>");
			}
			//Order Catalog Nature --> records[3]
			if(records[3].equals("P") || records[3].equals("S"))
			{
				contr_msr_panel_id 	= records[10];
				category     		= records[7];
				if(records[3].equals("P")) // Pass the discrete_measure_id & contr_msr_panel_id
				{
					measure_id 		= records[4]; // discrete_measure_id
				}
				else if(records[3].equals("S")) // Pass the catalog_code
				{
					measure_id 		= records[1]; // Catalog Code
				}
			} // End of If
			//if(!records[3].equals("") && (records[3].equalsIgnoreCase("P")) || records[3].equalsIgnoreCase("S"))
			//{  // for Panels
				%>
				<!--  <td class="LABEL" align="RIGHT" width="20%" onClick='displayToolTip(escape("<%=measure_id%>"),escape("<%=contr_msr_panel_id%>"),"<%=records[3]%>","<%=category%>","<%=bean_id%>","<%=bean_name%>","<%=i%>","drawingToolResults")'> <font size=1 color="BLUE"> -->
<%			//}
			//else
			//{
%>				  <td class="LABEL" align="RIGHT" width="20%"><font size=1>
<%			//}  %>

				<%=(String)records[2]%>
				<input type="hidden" name="catalog_desc<%=records[3]%><%=i%>" id="catalog_desc<%=records[3]%><%=i%>" value="<%=(String)records[2]%>">
				</font></td>
<%
				 previousValues = (HashMap)orderEntryRecordBean.getCheckedEntries(key);
				if(previousValues!=null)
				{
					setValues 		 = previousValues.keySet();
		   			iterator 		 = setValues.iterator();
		   			for(int prev_count=0;prev_count<previousValues.size();prev_count++)
		   			{
						entryValue = ((String)iterator.next()) ;
						if(!care_set_order.equalsIgnoreCase("Y")) // For the First Time, it will be "N"
						{
							// For the Care Sets, to set the Order Category, there will be only one record for Care Sets at a time
							care_set_order = (String)previousValues.get(entryValue) ;
							if(care_set_order.equalsIgnoreCase("CS")) // Only if it is CS
								care_set_order = "Y";
						}
						// For the checkboxes
						if(entryValue.equalsIgnoreCase("ck"+(String)records[1]))
						{
							checkedAttribute	= "CHECKED";
							break;
						}
						else
						   checkedAttribute 	= "";
					} // End of For
				}
				// From the Query enable_yn --> depending upon the privilege level.
				if(records[13]!=null && records[13].equals("Y"))
					disabled		 = "";
				else
					disabled		 = "DISABLED";
			// For Amend of Review Order
				if(bean.getAmendOrder().equalsIgnoreCase("existing_order"))
				{
					amend_key			= (bean.getPatientId()+bean.getEncounterId()+bean.getOrderId());  // Unique key (For Existing Orders) to keep the Value in the Bean
					amendPreviousValues	= (HashMap)orderEntryRecordBean.getCheckedEntries(amend_key);
					if(amendPreviousValues!=null)
					{
						setValues 	 = amendPreviousValues.keySet();
						iterator 	 = setValues.iterator();
						for(int prev_count=0;prev_count<amendPreviousValues.size();prev_count++)
						{
							 entryValue = ((String)iterator.next()) ;
							if(entryValue.equalsIgnoreCase("ck"+(String)records[1]))
							{
								checkedAttribute = "CHECKED";
								disabled		 = "DISABLED";
								break;
							}
						}
					}
				}
				/*if(records[3].equals("S")) // For Care Sets
				{
				   order_catalog_category 	= "CS";
				   order_category	  		= "CS";
				}
				else
				   order_catalog_category 	= ((String)records[7]);
				*/
				// Billing Informations Retrieved
				if(((String)records[12])!=null)
				{
					stBillMsg	= new StringTokenizer(((String)records[12]),"|");
					while(stBillMsg.hasMoreTokens())
					{
						  bill_warn_message		= stBillMsg.nextToken();
						  bill_warn_err_message	= stBillMsg.nextToken();
						  bill_error_message	= stBillMsg.nextToken();
						  if(bill_warn_message.equals("*")) bill_warn_message 	= "";
						  if(bill_warn_err_message.equals("*")) bill_warn_err_message = "";
						  if(bill_error_message.equals("*")) bill_error_message 	= "";
					}
				}
 %>
				<td class="LABEL" align="center" width="5%" >
	 
					<input type="checkbox"  name="ck<%=(String)records[1]%>" id="ck<%=(String)records[1]%>" value="Y" onClick='setCheckBoxVal(this,escape("<%=(String)records[5]%>"),escape("<%=(String)records[1]%>"),"drawingToolResults", "<%=order_catalog_category%>");' <%=checkedAttribute%> <%=disabled%>>
					<input type="hidden" name="h1<%=(String)records[1]%>" id="h1<%=(String)records[1]%>" value="<%=order_catalog_category%>">
					<input type="hidden" name="h2<%=(String)records[1]%>" id="h2<%=(String)records[1]%>" value="<%=(String)records[8]%>">
					<input type="hidden" name="prompt_desc<%=(String)records[1]%>" id="prompt_desc<%=(String)records[1]%>" value="<%=bean.checkForNull((String)records[6],"")%>"> <%-- Display the Message, kept with the catalog_code--%>
					<input type="hidden" name="bill_warn<%=(String)records[1]%>" id="bill_warn<%=(String)records[1]%>" value="<%=bill_warn_message%>"> <%-- Display the Warn Message for the billing, kept with the catalog_code--%>
					<input type="hidden" name="bill_warn_err<%=(String)records[1]%>" id="bill_warn_err<%=(String)records[1]%>" value="<%=bill_warn_err_message%>"> <%-- Display the Bill Warn Error Message for the billing, kept with the catalog_code--%>
					<input type="hidden" name="bill_error<%=(String)records[1]%>" id="bill_error<%=(String)records[1]%>" value="<%=bill_error_message%>"> <%-- Display the Bill Error Message for the billing, kept with the catalog_code--%>
				</td>
				<td class="LABEL" align="left" width="3%" nowrap>
<%				if(((String)records[9]).equalsIgnoreCase("Y")) // For Authorization Required
				{
%>					&nbsp;<img id='authorization"+i+"' src="../../eOR/images/Authorization.gif" align="center" title="Authorization"></img>
<%				}	%>
<% 				if(((String)records[11]).equalsIgnoreCase("Y")) // For Special Approval Required
				{
%>					<img id='special_approval"+i+"' src="../../eOR/images/SpecialApproval.gif" align="center" title="Special Approval"></img>
<%				}	%>
				</td>
<%
			count++;
 
			if( count%3 == 0)
			  out.println("</tr><tr>");
			prev_group_title = records[0];
		} // End of for
		if( count%3 > 0)
		{
			for (int u=0;u<3-count%3;u++)
		 		out.println("<td width=\"20%\" colspan=\"3\" align=\"left\">&nbsp;&nbsp;</td>");
			 	out.println("</tr>");
		}

		if(DrawingToolsItems.size()==0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script> ");
		}

		// Nullifying the objects
		previousValues					= null;			amendPreviousValues = null;
		stBillMsg						= null;
		setValues						= null;			iterator			= null;
		DrawingToolsItems				= null;			records				= null;
%>
	</table>
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="order_category" id="order_category" value=""> <!-- order_category-->
	<input type="hidden" name="check_box_val" id="check_box_val" value="N">	<!-- To identify that atleast one of the checkbox(catalog) is checked -->
	<input type="hidden" name="care_set_check_box_val" id="care_set_check_box_val" value="<%=care_set_order%>">

	<input type="hidden" name="query_string" id="query_string" value="<%=request.getQueryString()%>">
 </form>
 	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>
 		<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
 		   	<tr>
 		 		<td width='100%' id='t'></td>
 			</tr>
 		</table>
	</div>
</body>
</html>

<%
	 // set it back persistence
	//putObjectInBean(bean_id,bean,request);
%>

