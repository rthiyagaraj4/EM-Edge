<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
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
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/Dispense.js"></script>
 	<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function hideToolTip()	{ 
	  document.getElementById("tooltiplayer").style.visibility = 'hidden'
	}

	   
	function callMouseOver(obj)	{
		currClass = obj.className ;
		obj.className = 'ORMENU'; 
			
	}

	function callOnMouseOut(obj){
		obj.className = currClass; 
	}
	</script>
       <STYLE TYPE="text/css">
       	A:link 
       	 {
       	     COLOR: blue;
       	 }
     	A:visited 
     	 {
             COLOR: blue ;
         }
        A:active 
         {
             COLOR: red;
         }
   	
		
  	</STYLE> 
</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
String DispenseDate="";
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
	String bean_id =   request.getParameter("bean_id");
	String bean_name = request.getParameter("bean_name");
	String order_category = request.getParameter("order_category");
	String encounter_id = request.getParameter("encounter_id");
	String priority = request.getParameter("priority");
	String location_type = request.getParameter("location_type");
	String location = request.getParameter("location");
	String order_id = request.getParameter("order_id");
	String function_id = request.getParameter( "function_id" ) ;
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String responsibility_id = (String)session.getValue("responsibility_id"); 
	String facility_id = (String)session.getValue("facility_id");
	String practitioner_type = (String)session.getValue("practitioner_type");
	String patient_id_found = request.getParameter("patient_id_found");
	String patient_class = request.getParameter("patient_class");
	String patient_id = request.getParameter("patient_id");
	String date_from = request.getParameter("date_from");
	String single_multi = request.getParameter("single_multi");
	String date_to = request.getParameter("date_to");
	String order_type = request.getParameter("order_type");
	String total_query_records  = "0";
	if(location_type == null)	location_type = "";
	if(patient_class == null)	patient_class = "";
	if(practitioner_id == null)	practitioner_id = "";
	if(responsibility_id == null)	responsibility_id = "";
	if(facility_id == null) facility_id = "";
	if(practitioner_id == null)practitioner_id = "";
	if(patient_id == null)patient_id = "";
	if(location == null)location = "";
	if(order_category == null)order_category = "";
	if(single_multi == null)single_multi = "";
	if(priority == null)priority = "";
	if(date_from == null)date_from = "";
	if(date_to == null)date_to = "";
	if(order_id == null)order_id = "";
	if(encounter_id == null)encounter_id = "";
	if(order_type == null)order_type = "";

	//Parameters.put("location_type", location_type);
	//Parameters.put("location", location);
	//Parameters.put("order_category", order_category);
	Parameters.put("practitioner_id", practitioner_id);
	Parameters.put("responsibility_id", responsibility_id);
	Parameters.put("facility_id", facility_id);
	Parameters.put("practitioner_type", practitioner_type);
	//Parameters.put("order_type", order_type);
	//Parameters.put("patient_class", patient_class);
	//Parameters.put("patient_id_found", patient_id_found);
	//Parameters.put("patient_id", patient_id);
	//Parameters.put("single_multi", single_multi);
	//Parameters.put("priority", priority);
	//Parameters.put("date_from", date_from);
	//Parameters.put("date_to", date_to);
	//Parameters.put("order_id", order_id);
	//Parameters.put("encounter_id", encounter_id);
	/* Mandatory checks end */
	
/* Initialize Function specific start */

	//DispenseBean bean = (DispenseBean)mh.getBeanObject( bean_id, request,  bean_name ) ; 
	DispenseBean bean = (DispenseBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	String from	 = bean.checkForNull(request.getParameter( "from" ),"1") ;
	String to	 = bean.checkForNull(request.getParameter( "to" ),"7") ;
 	int start	 = Integer.parseInt(from);
	int end		 = Integer.parseInt(to);
	bean.setFunctionId(bean.checkForNull(function_id));
	bean.clear() ;
	bean.setMode( mode ) ;

/* Initialize Function specific end */

	ArrayList allValues = new ArrayList();
	allValues = bean.getSearchDetails(Parameters,start,end);

%>
<form name='disp_query_result_dtl' id='disp_query_result_dtl' action="../../eOR/jsp/DispenseQueryResult.jsp" method="post">
<table cellpadding=3 cellspacing=0 border=1 width="100%" align='center' class="grid">
<%
	String slClassValue = "";
	String tmp_ord_cat = "";
	int k			= 0;
	for(int i=0; i<allValues.size(); i++)
	{
		String[] row_details = new String[14];
		row_details = (String[])allValues.get(i);
		
		slClassValue="gridData";
		if(i==0)
		{
			if(row_details[14] != null)
			total_query_records = bean.checkForNull((String)row_details[14],"0");
%>
			<jsp:include page="ResultScrolling.jsp" ><jsp:param name="flush" value="true" />
			<jsp:param name ="from" value= "<%=start%>" /> 
			<jsp:param name ="to" value= "<%=end%>" />	
			<jsp:param name ="total_size" value= "<%=total_query_records%>" />   
			<jsp:param name ="check_box_name" value= "chk" />					 
			<jsp:param name ="form_name" value= "disp_query_result_dtl" />  
			</jsp:include>				
<%
		}

		if(row_details[1].equals("R"))
		{
			row_details[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
		}
		else if(row_details[1].equals("U"))
		{
			row_details[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
		}
		else if(row_details[1].equals("S"))
		{
			row_details[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
		}

		if (row_details[3].indexOf(",")!=-1)
		{

			StringTokenizer fieldTokenizer = new StringTokenizer(row_details[3],",");
			row_details[3]="";
		
			while (fieldTokenizer.hasMoreTokens()) 
			{
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
		}
		
			
		if(!(tmp_ord_cat.equals(row_details[7])))
		{
			tmp_ord_cat = (String)row_details[7];
			//out.println("tmp_ord_cat-->"+tmp_ord_cat);
%>
			<tr align='left'>
				<th class="columnheader" colspan=7 > <font size=1><%=row_details[8]%></font></th>
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
		}
		else if(row_details[13].equals("S"))
		{
			fontValue = "<font size=1 color=brown><b>";  // this is to indicate the different color for Stat
			imageTag = "<img src=\"../images/StatOrders.gif\" width=\"26\" height=\"24\" border=0 alt=\"Stat\">";
		}
		else
		{
			fontValue = "<font size=1 color=black><b>";
		}

		if ( !localeName.equals("en") )
		{ 
			 DispenseDate 	=com.ehis.util.DateUtils.convertDate(row_details[0],"DMYHM","en",localeName);
		}
		else
		{
			DispenseDate=row_details[0];
		}

		if(row_details[2].indexOf("!~!")!=-1)
		{
			row_details[2] = row_details[2].replace("!~!",",");
		}

		if(patient_id_found.equals("yes"))
		{
		%>
			<td width='15%' class='<%=slClassValue%>'>  <font size=1><a class='gridLink' href='#' onClick="callMenuFunctions('Completion','<%=row_details[6]%>','<%=row_details[9]%>','<%=row_details[5]%>')"><%=DispenseDate%></a></font></td>
			<td width='15%' class='<%=slClassValue%>'> <%=fontValue%> <%=row_details[1]%> </font> <%=imageTag%> </td> 
			<td width='62%' class='<%=slClassValue%>'> <font size=1><a class='gridLink' href='#' onClick="callMenuFunctions('View','<%=row_details[6]%>','<%=row_details[9]%>','<%=row_details[5]%>')"> <%=row_details[2]%></a> </td> 
			<td width='8%' class='<%=slClassValue%>' align=center><font size=1><%=row_details[4]%></font> </td>
		<%
		}
		else
		{
		%>
			<td width='15%' class='<%=slClassValue%>'>  <font size=1><a class='gridLink' href='#' onClick="callMenuFunctions('Completion','<%=row_details[6]%>','<%=row_details[9]%>','<%=row_details[5]%>')"><%=DispenseDate%></a></font></td>
			<td width='15%' class='<%=slClassValue%>'> <%=fontValue%> <%=row_details[1]%> </font> <%=imageTag%> </td> 
			<td width='28%' class='<%=slClassValue%>'> <font size=1><a class='gridLink' href='#' onClick="callMenuFunctions('View','<%=row_details[6]%>','<%=row_details[9]%>','<%=row_details[5]%>')"> <%=row_details[2]%></a> </td> 
			<td width='34%' class='<%=slClassValue%>'> <font size=1><%=row_details[3]%> </font></td> 
			<td width='8%' class='<%=slClassValue%>' align=center><font size=1> <%=row_details[4]%></font> </td>
		<%}%>
		</tr>
	<%k++;
	}

	if(allValues.size() == 0)
	{
%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));</script>
<%
	} 
%>

</table>
<input type="hidden" name="from" id="from" value="<%=from%>" >
<input type="hidden" name="to" id="to" value="<%=to%>" >
<input type="hidden" name='total_recs' id='total_recs' value='<%=k%>'>
<!-- <input type="hidden" name="Parameters" id="Parameters" value="<%=Parameters%>"> -->
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>">
<input type="hidden" name="patient_id_found" id="patient_id_found" value="<%=patient_id_found%>">
<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
<input type="hidden" name="location_type" id="location_type" value="<%=location_type%>">
<input type="hidden" name="location" id="location" value="<%=location%>">
<input type="hidden" name="order_category" id="order_category" value="<%=order_category%>">
<input type="hidden" name="priority" id="priority" value="<%=priority%>">
<input type="hidden" name="single_multi" id="single_multi" value="<%=single_multi%>">
<input type="hidden" name="priority" id="priority" value="<%=priority%>">
<input type="hidden" name="date_from" id="date_from" value="<%=date_from%>">
<input type="hidden" name="date_to" id="date_to" value="<%=date_to%>">
<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
<input type="hidden" name="order_type" id="order_type" value="<%=order_type%>">
</form>
</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
%>

