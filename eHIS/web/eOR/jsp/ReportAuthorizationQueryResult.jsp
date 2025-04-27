<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!--  -->
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script><!-- used for date validation-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/ReportAuthorization.js"></script>
 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<!--  	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 --></head>

<body onscroll='processScroll()'  onMouseDown="CodeArrest()"  onKeyDown="lockKey()" >
<%
	
	HashMap Parameters = new HashMap();
	Enumeration paramNames = request.getParameterNames();
	while(paramNames.hasMoreElements())
	{
		String pName = (String)paramNames.nextElement();
		String paramValue = request.getParameter(pName);
		if(paramValue == null)	paramValue = "";
		else paramValue = paramValue.trim();
		Parameters.put(pName, paramValue);
	}

	/* Mandatory checks start */
	String mode	   = "1";//request.getParameter( "mode" ) ;
	String function_id = request.getParameter( "function_id" ) ;
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String responsibility_id = (String)session.getValue("responsibility_id");
	String facility_id = (String)session.getValue("facility_id");
	String practitioner_type = (String)session.getValue("practitioner_type");
	String patient_id_found = request.getParameter("patient_id_found");
	String header_values = request.getParameter("header_values");
	//String header_values = request.getQueryString();
	/*Added by Uma on 2/17/2010 for CRF 804 to get the Filter parameter IN016226*/
	String filter = request.getParameter("filter")==null?"":request.getParameter("filter");
	String AuthorizationDate="";
	String total_query_records = "0";
		
	if(practitioner_id == null)	practitioner_id = "";
	if(responsibility_id == null)	responsibility_id = "";
	if(facility_id == null) facility_id = "";
	if(practitioner_id == null)practitioner_id = "";

	String bean_id = "Or_ReportAuthorization";//request.getParameter("bean_id");
	String bean_name = "eOR.ReportAuthorizationBean";//request.getParameter("bean_name");

/* Mandatory checks end */

/* Initialize Function specific start */

	//ReportAuthorizationBean bean = (ReportAuthorizationBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	ReportAuthorizationBean bean = (ReportAuthorizationBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(localeName);	bean.setFunctionId(bean.checkForNull(function_id));
	bean.clear() ;
	bean.setMode( mode ) ;

/* Initialize Function specific end */

	String from	 = bean.checkForNull(request.getParameter( "from" ),"1") ;
	String to	 = bean.checkForNull(request.getParameter( "to" ),"7") ;
 	int start = Integer.parseInt(from);
	int end   = Integer.parseInt(to); 	 

	Parameters.put("start", String.valueOf(start));
	Parameters.put("end",String.valueOf(end));
	Parameters.put("practitioner_id", practitioner_id);
	Parameters.put("responsibility_id", responsibility_id);
	Parameters.put("facility_id", facility_id);
	Parameters.put("practitioner_type", practitioner_type);
	/*Added by Uma on 2/17/2010 for CRF 804 to get the Filter parameter IN016226*/
	Parameters.put("filter", filter);

	ArrayList allValues = new ArrayList();	

	try
	{
 		allValues =(ArrayList)bean.getSearchDetails(Parameters);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
 %>

<form name='report_authorization_dtl' id='report_authorization_dtl'  action="../../eOR/jsp/ReportAuthorizationQueryResult.jsp" method="post">
<%
	if( allValues.size() == 0)
	{ 
%>
		<script>
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
		clearValuesfor();//added by prasad
		</script>
 <%	
	}
	else
	{
	%>
		<div id="divHeadSep" style="position: absolute; width: 100vw">
		<table cellpadding=3 cellspacing=0 border=1 width="100%" height="" id="tableresult" class="grid">
		<tr id="heading">
		<%
		if(patient_id_found.equals("yes"))
		{
		%>
			<td class='columnheader' width='' nowrap><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/></td>
			<td class='columnheader' width='' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
			<td class='columnheader' width='' nowrap><fmt:message key="Common.OrderDetails.label" bundle="${common_labels}"/></td>
			<td class='columnheader' width='' nowrap><fmt:message key="Common.Authorized.label" bundle="${common_labels}"/><input type=checkbox name='select_all' id='select_all' onClick='clickAll()' disabled></td>
		<%
		}
		else
		{
		%>
			<td class='columnheader' width='' nowrap><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/></td>
			<td class='columnheader' width='' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
			<td class='columnheader' width='' nowrap><fmt:message key="Common.OrderDetails.label" bundle="${common_labels}"/></td>
			<td class='columnheader' width='' nowrap><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
			<td class='columnheader' width='' nowrap><fmt:message key="Common.Authorize.label" bundle="${common_labels}"/><input type=checkbox name='select_all' id='select_all' onClick='clickAll()' disabled></td>
			
		<%
		}
		%>
		</tr>

<script>focusOnResult();</script>
<%

	String[] row_details = new String[30];
	String slClassValue = "";
	String tmp_ord_cat = "";
	String order_set_id ="";
	String bill_yn			 ="N";
	String order_line_num			 ="";
	String dob			 ="";
	for(int i=0; i<allValues.size(); i++)
	{

		row_details = (String[])allValues.get(i);
		order_set_id = row_details[25]==null?"":row_details[25];
		bill_yn = row_details[26]==null?"":row_details[26];
		order_line_num = row_details[27]==null?"":row_details[27];
		dob = row_details[28]==null?"":row_details[28];
		slClassValue="gridData";
		if(i==0) 
		{ 
		if(row_details[29] != null)
					total_query_records = bean.checkForNull((String)row_details[29],"0");
		if((Integer.parseInt(total_query_records)>0) || (start>1))
		{
			String colscroll="";
			if(patient_id_found.equals("yes"))
			{
				colscroll="4";
			}
			else
			{
				colscroll="5";
			}
		%>
			<tr  align="right">
				<td colspan=<%=colscroll%>>
					<jsp:include page="ResultScrolling.jsp" ><jsp:param name="flush" value="true" />
					  <jsp:param name ="from" value= "<%=start%>" /> 
					  <jsp:param name ="to" value= "<%=end%>" />	
					  <jsp:param name ="total_size" value= "<%=total_query_records%>" />   
					  <jsp:param name ="check_box_name" value= "chk" />					 
					  <jsp:param name ="form_name" value= "report_authorization_dtl" />  
					</jsp:include>
				</td>
				</tr>
		<%}%>
<%		} 
		if(!(tmp_ord_cat.equals(row_details[7])))
		{
			tmp_ord_cat = (String)row_details[7];
		%>
			<tr>
				<td class='columnheader' colspan=7 align=left> <font size=1><%=row_details[8]%></font></td>
			</tr>
		<%
		}
		%>
		<tr>
		<%
			String fontValue = "";
			String imageTag = "";
			if(row_details[13].equals("U"))
			{
				fontValue = "<font size=1 color=red><b>";  // this is to indicate the different color for urgency
				row_details[13]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
			}
			else if(row_details[13].equals("S"))
			{
				fontValue = "<font size=1 color=brown><b>";  // this is to indicate the different color for Stat
				row_details[13]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
				imageTag = "<img src=\"../images/StatOrders.gif\" width=\"26\" height=\"24\" border=0 alt=\"Stat\">";
			}
			else if(row_details[13].equals("R"))
			{
				fontValue = "<font size=1 color=black><b>";
				row_details[13]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
			}
			if(row_details[1].equals("U"))
			{
				fontValue = "<font size=1 color=red><b>";  // this is to indicate the different color for urgency
				row_details[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
			}
			else if(row_details[1].equals("S"))
			{
				fontValue = "<font size=1 color=brown><b>";  // this is to indicate the different color for Stat
				row_details[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
				imageTag = "<img src=\"../images/StatOrders.gif\" width=\"26\" height=\"24\" border=0 alt=\"Stat\">";
			}
			else if(row_details[1].equals("R"))
			{
				fontValue = "<font size=1 color=black><b>";
				row_details[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
			}

			if ( !localeName.equals("en") )
			{ 
				 AuthorizationDate 	=com.ehis.util.DateUtils.convertDate(row_details[0],"DMYHM","en",localeName);
			}
			else
			{
				  AuthorizationDate=row_details[0];
			}

			if(row_details[2].indexOf("$$RD##")!=-1)
			{
				String[] str = (String[])row_details[2].split("!~!");
				String order_detail ="";
				String[] strtitle = null;
				for(int s=0;s<str.length;s++)
				{
					if(str[s].indexOf("$$RD##")!=-1)
					{
						String line_order = (String)str[s];
						strtitle  =line_order.split("::");
						String titleText = "";
						if(strtitle[1].length()>0)
						{
							titleText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedFromRadiology.label","or_labels")+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Reason.label","or_labels")+":"+ strtitle[1];
						}
						else
						{
							titleText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedFromRadiology.label","or_labels");
						}
						strtitle[0] = "<img src='../../eOR/images/IN_RD_ADD_TEST.gif' title='"+titleText+"'>";
						order_detail = order_detail+strtitle[0]+strtitle[2]+", ";
					}
					else
					{
						order_detail = order_detail+str[s]+", ";
					}
				}
				row_details[2]  = order_detail;
				if(row_details[2].lastIndexOf(",") ==((row_details[2].length())-2))
				{
					row_details[2] = row_details[2] .substring(0,((row_details[2].length())-2));
				}
			}

			if(row_details[2].indexOf("!~!")!=-1)
			{
				row_details[2] = row_details[2].replace("!~!",",");
			}
			
			if(patient_id_found.equals("yes"))
			{
			%>
				<td width='' nowrap class='<%=slClassValue%>'>  <font size=1> <a class="gridLink"  href='javascript:callResultEntry("<%=i%>")'> <%=AuthorizationDate%> </a> </font> </td>
				<td width='' nowrap class='<%=slClassValue%>'> <%=fontValue%> <%=row_details[1]%> </font> <%=imageTag%> </td>
				<td width='' nowrap class='<%=slClassValue%>'> <font size=1><a class="gridLink"  href='#' onClick="callMenuFunctions('View','<%=row_details[6]%>','<%=row_details[9]%>','<%=row_details[17]%>','<%=row_details[11]%>')"> <%=row_details[2]%></a> </td>
				<td width='' nowrap class='<%=slClassValue%>' align=center><font size=1> <input type=checkbox name='chk<%=i%>' id='chk<%=i%>' value='Y'> </font> </td>
		<%	}
			else
			{
			%>
				<td width='' nowrap class='<%=slClassValue%>'>  <font size=1> <a class="gridLink"  href='javascript:callResultEntry(<%=i%>)'> <%=AuthorizationDate%> </a> </font> </td>
				<td width='' nowrap class='<%=slClassValue%>'> <%=fontValue%> <%=row_details[1]%> </font> <%=imageTag%> </td>
				<td width='' wrap class='<%=slClassValue%>'> <font size=1><a class="gridLink" href='#' onClick="callMenuFunctions('View','<%=row_details[6]%>','<%=row_details[9]%>','<%=row_details[17]%>','<%=row_details[11]%>')"> <%=row_details[2]%></a> </td>
				<%
				String sex;
				sex="";
				if (row_details[17].equalsIgnoreCase("M"))
					sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				else if(row_details[17].equalsIgnoreCase("F"))
					sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				row_details[3]=row_details[22]+","+sex+"/"+row_details[23]+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+row_details[11]+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Encounter Dtls:.label","or_labels")+row_details[3]+","+row_details[19]+"/"+row_details[24]+",";
			/*if (row_details[3].indexOf(",")!=-1){

			StringTokenizer fieldTokenizer = new StringTokenizer(row_details[3],",");
			row_details[3]="";
		
		while (fieldTokenizer.hasMoreTokens()) {
		  String tempToken = fieldTokenizer.nextToken();
		 
		   if ((tempToken.indexOf('/'))==1)
			{
			  String tempstr=tempToken.substring(1);
			  if (tempToken.charAt(0)=='M')
				  tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")).concat(tempstr);
			  else if(tempToken.charAt(0)=='F')
				  tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")).concat(tempstr);
			}
			row_details[3]=row_details[3].concat(tempToken).concat(",");
			  
         

		}
					 }*/
			%>
			<td width='' wrap class='<%=slClassValue%>'> <font size=1><%=row_details[3]%> </font></td>
			<td width='' nowrap class='<%=slClassValue%>' id='status<%=i%>' align=center><font size=1> <input type=checkbox name='chk<%=i%>' id='chk<%=i%>' value='Y'> </font> </td>
		<%
		}
		%>
		</tr>
		<input type='hidden' name='order_id<%=i%>' id='order_id<%=i%>' value="<%=row_details[9]%>">
		<input type='hidden' name='order_line_num<%=i%>' id='order_line_num<%=i%>' value="<%=row_details[27]%>">
		<input type="hidden" name="result_type<%=i%>" id="result_type<%=i%>" value="<%=bean.checkForNull(row_details[14],"1")%>">
		<input type="hidden" name="result_status<%=i%>" id="result_status<%=i%>" value="<%= row_details[15]%>">
		<input type="hidden" name="report_srl_no<%=i%>" id="report_srl_no<%=i%>" value="<%=row_details[16]%>">
		<input type="hidden" name="patient_id<%=i%>" id="patient_id<%=i%>" value="<%=row_details[11]%>">
		<input type="hidden" name="patient_class<%=i%>" id="patient_class<%=i%>" value="<%=row_details[18]%>">
		<input type="hidden" name="source_type<%=i%>" id="source_type<%=i%>" value="<%=row_details[19]%>">
		<input type="hidden" name="source_code<%=i%>" id="source_code<%=i%>" value="<%=row_details[20]%>">
		<input type="hidden" name="priority<%=i%>" id="priority<%=i%>" value="<%=row_details[13]%>">
		<input type="hidden" name="order_type_code<%=i%>" id="order_type_code<%=i%>" value="<%=row_details[7]%>">
		<input type="hidden" name="order_set_id<%=i%>" id="order_set_id<%=i%>" value="<%=order_set_id%>">
		<input type="hidden" name="bill_yn<%=i%>" id="bill_yn<%=i%>" value="<%=bill_yn%>">
		<input type="hidden" name="sex<%=i%>" id="sex<%=i%>" value="<%=row_details[17]%>">
		<input type="hidden" name="dob<%=i%>" id="dob<%=i%>" value="<%=dob%>">
		<%--<Script>alert('order_type_code='+document.getElementById("order_type_code")<%=i%>.value)</Script>--%>
	<%}//End of Loop
	} %>
	</table>
	</div>

	<input type="hidden" name="from" id="from" value="<%=from%>">
	<input type="hidden" name="to" id="to" value="<%=to%>">
	<input type=hidden name='total_recs' id='total_recs' value='<%=allValues.size()%>'>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>">
	<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>">
	<input type="hidden" name="practitioner_type" id="practitioner_type" value="<%=practitioner_type%>">
	<Input type="hidden" name="header_values" id="header_values" value="<%=header_values%>">
	<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">
	<Input type="hidden" name="order_category" id="order_category" value="<%=request.getParameter("order_category")%>">
	<Input type="hidden" name="patient_id_found" id="patient_id_found" value="<%=patient_id_found%>">
	<Input type="hidden" name="patient_id" id="patient_id" value="<%=request.getParameter("patient_id")%>">
	<Input type="hidden" name="encounter_id" id="encounter_id" value="<%=request.getParameter("encounter_id")%>">
	<Input type="hidden" name="order_id" id="order_id" value="<%=request.getParameter("order_id")%>">
	<Input type="hidden" name="order_line_num" id="order_line_num" value="<%=request.getParameter("order_line_num")%>">
	<Input type="hidden" name="date_from" id="date_from" value="<%=request.getParameter("date_from")%>">
	<Input type="hidden" name="date_to" id="date_to" value="<%=request.getParameter("date_to")%>">
	<Input type="hidden" name="priority" id="priority" value="<%=request.getParameter("priority")%>">
	<Input type="hidden" name="order_type" id="order_type" value="<%=request.getParameter("order_type")%>">
	<Input type="hidden" name="activity_type" id="activity_type" value="<%=request.getParameter("activity_type")%>">
	<Input type="hidden" name="performing_location_code" id="performing_location_code" value="<%=request.getParameter("performing_location_code")%>">
<script>
			//if(parent.ReportAuthorizationHeader.document.getElementById("tableheader")==null)
			//{
				//setTimeout("alignHeading();",300);
			//}
			//else 
				//alignHeading();
</script>
</form>
</body>
<script> parent.ReportAuthorizationSearch.document.report_authorization_search.search_btn.disabled=false;</script>
</html>
<%
	putObjectInBean(bean_id,bean,request);
%>

