<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
-----------------------------------------------------------------------
Date			Edit History   Name        Description
-----------------------------------------------------------------------
?             	100         	?           created
13/08/2013	  IN042045		 Chowminya G	System should not allow to copy for the drugs for which Verbal Order Applicable is not selected		
-----------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
 <jsp:useBean id="bean" scope="page" class="eOR.OrderEntryQueryBean"/>
<%-- Mandatory declarations end --%>
<%
	
	//String encounter_id			= request.getParameter("encounter_id");
	//String bean_id 				= request.getParameter("bean_id");
	//String bean_name 			= request.getParameter("bean_name");
	//String disableOrderCategory = "";
	//String disableOrderType		= "";
	/* Mandatory checks end */
	/* Initialize Function specific start */
		//OrderEntryBean bean	 	= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	//	OrderEntryBean bean			= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	/* Initialize Function specific end */
	//String ammend_called_from	= bean.checkForNull(request.getParameter("ammend_called_from"),"");
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		bean.setLanguageId(localeName);

	Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
	String care_sets 			= bean.checkForNull(request.getParameter("care_sets"),"");
	if(!care_sets.equals("")) 	care_sets = care_sets.trim();

	String time_frame 			= bean.checkForNull(request.getParameter("time_frame"),"");
	String facility_id 			= bean.checkForNull(request.getParameter("facility_id"),"");
	String encounter_id 		= bean.checkForNull(request.getParameter("encounter_id"),"");
	String patient_class		= bean.checkForNull(request.getParameter("patient_class"),"");
	String admission_date		= bean.checkForNull(request.getParameter("admission_date"),"");
	String function_from		= bean.checkForNull(request.getParameter("function_from"),"");
	String discharge_date_time	= bean.checkForNull(request.getParameter("discharge_date_time"),"");
	String practitioner_type		= bean.checkForNull(request.getParameter("practitioner_type"),"");//IN042045

	
	ArrayList MatrixHeading		= null;
	ArrayList Matrix			= null;
	int count					= 0;
	String classValue			= "";
	String freq_durn			= "";
	String days_record[]		= null;
	if(time_frame.equals("M"))
		Matrix = bean.getCareSetMatrix(care_sets,"", properties, facility_id,encounter_id,patient_class,admission_date,discharge_date_time,practitioner_type); // For Matrix //IN042045 included practitioner_type
	else
		Matrix = bean.getCareSetMatrix(care_sets,time_frame,properties, facility_id,encounter_id,patient_class,admission_date,discharge_date_time,practitioner_type);//IN042045 included practitioner_type
	if(Matrix!=null && Matrix.size()>0)		
		days_record	  = new String[Matrix.size()]; // At the most there will be 4 values(Day1..Day4);
	String[] record 			= null;
%>
<html>
<head><title><fmt:message key="eOR.OrderEntryCriteriaHeader.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	</link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryTab.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name="careSetMatrixForm" id="careSetMatrixForm">
		<table cellpadding="3" cellspacing="0" border="1" width="100%" align="center" class="grid">
		<tr>
<%		if(time_frame.equals("T") || time_frame.equals("C"))
		{
%>
			<th width="10%"><fmt:message key="eOR.ReqdOpt.label" bundle="${or_labels}"/></th>
<%
			if(time_frame.equals("T"))   // For Time-Frame/Category
			{
%>				<th width="10%"><fmt:message key="eOR.TimeFrame.label" bundle="${or_labels}"/></th>
				<th width="20%"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></th>
<%			}
			else						 // For Category/Time-Frame
			{
%>
				<th width="20%"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></th>
				<th width="10%"><fmt:message key="eOR.TimeFrame.label" bundle="${or_labels}"/></th>
<%			}	%>

			<th width="40%"><fmt:message key="Common.Orderable.label" bundle="${common_labels}"/></th>
			<th width="20%"><fmt:message key="eOR.FreqDurn.label" bundle="${or_labels}"/></th>
<%		}  else { 	// For Matrix
%>
			<th width="10%"><fmt:message key="eOR.ReqdOpt.label" bundle="${or_labels}"/></th>
			<th width="20%"><fmt:message key="Common.category.label" bundle="${common_labels}"/></th>
<%		}  %>
<%
			
		if(Matrix.size()>0)
		{
		
			if(time_frame.equals("M"))
				MatrixHeading = bean.getCareSetHeading(care_sets, properties);// send the order_set_code
				try{

			if(MatrixHeading!=null && MatrixHeading.size()>0 && Matrix.size()>0)
			{
				for(int i=0; i<MatrixHeading.size() ; i++)
				{
					record 	= (String[])MatrixHeading.get(i);
					days_record[count] 	= bean.checkForNull(record[1]);					
					if((count+1) >= Matrix.size())
						i = MatrixHeading.size();
					count++;					
%>
					<th width="15%"><%=record[0]%></th>

<%				}
			}
				}catch(Exception e){
					e.printStackTrace();
				}
%>
		</tr>
		<tr>

<%
			if(Matrix!=null && Matrix.size()>0)
			{
				for(int i=0; i<Matrix.size(); i++)
				{
					record = (String[])Matrix.get(i);
					/*if ( i% 2 == 0 )
						classValue 			= "QRYEVEN" ;
					else
						classValue		 	= "QRYODD" ;*/
						classValue="gridData";
%>
					<tr>
					<td class=<%=classValue%> align="left">
<%
						if(record[4].equalsIgnoreCase("R"))
							out.println("Required");
						else if(record[4].equalsIgnoreCase("O"))
							out.println("Optional/Preselected");
						else
							out.println("Optional/Deselected");
%>
					</td>

<%					if(time_frame.equals("T") || time_frame.equals("C") )	 // For Category or Time Frame
					{
						freq_durn	= record[6];
						if(!record[8].equals(""))
							//freq_durn	+= "/"+record[8];
							freq_durn	=freq_durn+ "/"+record[8];
						if(time_frame.equals("T"))   // For Time Frame
						{
%>
							<td class="<%=classValue%>" align="right"><%if(!record[3].equals("")) { out.println(record[3]); out.println("&nbsp;Hrs"); }%></td>
							<td class="<%=classValue%>"><%=record[2]%></td>
<%						} else { 	 // For Category	%>
							<td class="<%=classValue%>"><%=record[2]%></td>
							<td class="<%=classValue%>"  align="right"><%if(!record[3].equals(""))  { out.println(record[3]); out.println("&nbsp;Hrs"); }%></td>
<%						} %>
						<td class="<%=classValue%>"><%=record[1]%></td>
						<td class="<%=classValue%>"><%if(!freq_durn.equals("")) out.println(freq_durn); else out.println("&nbsp;");%></td>
<%					} else { //For time_frame.equals("M") (Matrix")
%>
							<td class="<%=classValue%>"><%=record[2]%></td>
<%
							// For Matrix(dynamically)
							for(int j=0; j<count; j++)
							{
								if(days_record[j].equals(record[9])){ // check for the no_of_days, if matching print it
%>									<td class="<%=classValue%>" align="right"><%if(!record[1].equals(""))  { out.println(record[1]); out.println("&nbsp;"); }%></td>
<%								} else { %>
									<td class="<%=classValue%>">&nbsp;</td>
<%								}
							} %>

<%					}	%>
					</tr>
<%				}	// End of Matrix.size()
			} //End of matrix !null
		}
		else
		{%>
			
			<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
			if(parent.frames[2].document.forms[0].select)
				parent.frames[2].document.forms[0].select.disabled = true;
			
			//history.go(-1);
			</script>

		<%}

%>
		</tr>
		</table>
		<input type="hidden" name="bean_id" id="bean_id" value="<%//=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%//=bean_name%>">
		<input type="hidden" name="function_from" id="function_from" value="<%=function_from%>">
<%
		// Nullifying the objects
		if(MatrixHeading!=null)
			MatrixHeading.clear();		MatrixHeading		= null;
		if(Matrix!=null)
			Matrix.clear();					Matrix				= null;
		days_record			= null;

		// no need to set it back persistence
		// putObjectInBean(bean_id,bean,request);

%>
	</form>
</body>
</html>

