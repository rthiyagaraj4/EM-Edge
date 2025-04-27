<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ page import="webbeans.eCommon.*,eOR.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
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
 	<script language="JavaScript" src="../js/ResultReporting.js"></script>
 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<Script>
	function dummy(){}
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

<body onscroll='processScroll()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
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
	//out.println("<script>alert('Parameters:::"+Parameters+"')</script>");

	/* Mandatory checks start */
	String mode	   						= "1";//request.getParameter( "mode" ) ;
	String function_id 					= request.getParameter( "function_id" ) ;
	String practitioner_id 				= (String)session.getValue("ca_practitioner_id");
	String responsibility_id 			= (String)session.getValue("responsibility_id");
	String facility_id 					= (String)session.getValue("facility_id");
	String practitioner_type 			= (String)session.getValue("practitioner_type");
	//String patient_id_found 			= request.getParameter("patient_id_found");
	String order_category 				= request.getParameter("order_category");
 	String group_by						= request.getParameter("group_by");

	String from_ca						= request.getParameter("from_ca");

	String can_location_type			= request.getParameter("location_type");
	String can_location					= request.getParameter("location");
	String can_order_category			= request.getParameter("order_category");
	String can_single_multi				= request.getParameter("single_multi");
	String can_priority					= request.getParameter("priority");
	String can_date_from				= request.getParameter("date_from");
	String can_date_to					= request.getParameter("date_to");
	String can_patient_id				= request.getParameter("patient_id");
	String can_order_id					= request.getParameter("order_id");
	String can_encounter_id				= request.getParameter("encounter_id");
	String can_patient_id_found			= request.getParameter("patient_id_found");
	String can_order_type				= request.getParameter("order_type");
	String can_performing_location_code = request.getParameter("performing_location_code");
	String can_view_by 					= request.getParameter("view_by");
 	if(practitioner_id == null)	practitioner_id = "";
	if(responsibility_id == null)	responsibility_id = "";
	if(facility_id == null) facility_id = "";
	if(practitioner_id == null)practitioner_id = "";
	if(order_category == null) order_category = "";
	if (group_by == null) group_by = "";

	if (from_ca == null) from_ca = "";

	if(can_location_type == null) can_location_type = "";
	if(can_location == null) can_location = "";
	if(can_order_category == null) can_order_category = "";
	if(can_single_multi == null) can_single_multi = "";
	if(can_priority == null) can_priority = "";
	if(can_date_from == null) can_date_from = "";
	if(can_date_to == null) can_date_to = "";
	if(can_patient_id == null) can_patient_id = "";
	if(can_order_id == null) can_order_id = "";
	if(can_encounter_id == null) can_encounter_id = "";
	if(can_patient_id_found == null) can_patient_id_found = "";
	if(can_order_type == null) can_order_type = "";
	if(can_performing_location_code == null) can_performing_location_code = "";
	if(can_view_by == null) can_view_by = "";
 	Parameters.put("practitioner_id", practitioner_id);
	Parameters.put("responsibility_id", responsibility_id);
	Parameters.put("facility_id", facility_id);
	Parameters.put("practitioner_type", practitioner_type);
	Parameters.put("from_ca",from_ca);

	String total_query_records  = "0";

//out.println("<script>alert('Parameters:::"+Parameters+"')</script>");

	//out.println(Parameters);

	String bean_id = "Or_ResultReporting";//request.getParameter("bean_id");
	String bean_name = "eOR.ResultReportingBean";//request.getParameter("bean_name");

/* Mandatory checks end */

/* Initialize Function specific start */

	ResultReportingBean bean = (ResultReportingBean)getBeanObject( bean_id, bean_name ,request ) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(function_id));
	bean.clear() ;
	bean.setMode( mode ) ;
	String from	 = bean.checkForNull(request.getParameter( "from" ),"1") ;
	String to	 = bean.checkForNull(request.getParameter( "to" ),"7") ;
 	int start	 = Integer.parseInt(from);
	int end		 = Integer.parseInt(to);

	Parameters.put("start",String.valueOf(start));
	Parameters.put("end",String.valueOf(end));
 

/* Initialize Function specific end */
//    String encounter_id = bean.checkForNull((String)Parameters.get("encounter_id"),"");
	int i = 0;
	ArrayList allValues = new ArrayList();
	//if(from!=null && from.equals("1")) {
  		allValues		= bean.getCodingSearchDetails(Parameters);
 		// Setting as a persistence bean
	//	bean.setDetails(allValues);
 	//} else {
	//	allValues=bean.getDetails();
  	//}
 	String patient_id = "";
	String sex = "";
	//String resultType = "";//String discr_msr_id="";
if( allValues.size() == 0){ %>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"))
		clearValuesfor1(); //added by prasad	
</script>
 <%}else{%>
<form name='result_coding_dtl' id='result_coding_dtl'  action="../../eOR/jsp/ResultCodingQueryResult.jsp" method="post">
<div id="divHeadSep" style="position: absolute;">
<table cellpadding=3 cellspacing=0 border=1 width="100%"  id="tableresult" class="grid">
<tr id="heading">
		<td class=columnheader width='' nowrap><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/></td>
        <td class=columnheader width='' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.OrderDetails.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
</tr>
<%
	String slClassValue = "";
	String tmp_ord_cat = "";
	

	//if(allValues.size() < 7 || end > allValues.size()) {
	//		end = allValues.size();
	//}	
	//for(int i=0; i<allValues.size(); i++)
	for(int k=0; k<allValues.size(); k++)
	{
		String[] row_details = new String[26];
		//row_details = (String[])allValues.get(i);
		row_details = (String[])allValues.get(k);
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
			row_details[2] =row_details[2].replace("!~!",",");
		}

		if(row_details[1].compareTo("R")==0)
		{
			row_details[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
		}
		else if(row_details[1].compareTo("U")==0)
		{
			row_details[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
		}
		else if(row_details[1].compareTo("S")==0)
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
				if ((tempToken.indexOf('/'))==2)
				{
			  	  String tempstr=tempToken.substring(2);
				  if (tempToken.charAt(0)=='M')
					  tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")).concat(tempstr);
				  else if(tempToken.charAt(0)=='F')
					  tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")).concat(tempstr);
				}
				row_details[3]=row_details[3].concat(tempToken).concat(",");
			}
		}
		
        for (int index = 0;index < row_details.length;index++) 
		{
		  if (row_details[index] == null)  row_details[index] = "";
		}

		
		if(k==0) 
		{ 
 				total_query_records = bean.checkForNull((String)row_details[25],"0");
				if((Integer.parseInt(total_query_records)>0) || (start>1))
				{
					%>
					<tr align="right">
						<td colspan="5">
							  <jsp:include page="ResultScrolling.jsp" ><jsp:param name="flush" value="true" />
							  <jsp:param name ="from" value= "<%=start%>" /> 
							  <jsp:param name ="to" value= "<%=end%>" />	
							  <jsp:param name ="total_size" value= "<%=total_query_records%>" />   
							  <jsp:param name ="check_box_name" value= "" />					 
							  <jsp:param name ="form_name" value= "result_coding_dtl" />  
							</jsp:include>
						</td>
					</tr>
<%			}  
		}

		//out.println("<script>alert('before')</script>");

 		//out.println("<script>alert('"+facility_id+","+row_details[16]+","+visit_adm_date+"')</script>");
		//out.println("<script>alert('row_details[1]:"+row_details[1]+",row_details[2]:"+row_details[2]+"--row_details[3]::"+row_details[3]+"')</script>");
//out.println("<script>alert('row_details[7]:"+row_details[7]+",row_details[9]:"+row_details[9]+"--row_details[3]::"+row_details[3]+"')</script>");
		patient_id = row_details[11];

		if(row_details[5].trim().equalsIgnoreCase("PH") && !(row_details[7].equals("TDM")) && !(row_details[7].equals("PDC")))
		   row_details[12] = "C";
 		/*if(i % 2 == 0)
			slClassValue = "QRYEVEN";
		else
			slClassValue = "QRYODD";*/
			slClassValue="gridData";
 
		String grpCheckValue = "";
		if (group_by.equals("P")) {
		  grpCheckValue = (String)row_details[11];
		} else if (group_by.equals("") || group_by.equals("D")) {
		  grpCheckValue = (String)row_details[16];
		} else if (group_by.equals("C")) {
		  grpCheckValue = (String)row_details[5];
		}  else if (group_by.equals("T")) {
		  grpCheckValue = (String)row_details[7];
		}   else if (group_by.equals("L")) {
		  grpCheckValue = (String)row_details[17] + "/" + (String)row_details[18];
		}  else if (group_by.equals("U")) {
		  grpCheckValue = (String)row_details[12];
		}  else if (group_by.equals("O")) {
		  grpCheckValue = (String)row_details[2];
		}
 		if(!(tmp_ord_cat.equals(grpCheckValue)))
		{
 		%>
		<%--<Script>alert('<%=group_by%>')</Script>--%>
        <tr>
			<%if (group_by.equals("") || group_by.equals("D")) {
            if (can_view_by.equals("L")) {%>
			<td class=columnheader colspan=8> <font size=1><%=com.ehis.util.DateUtils.convertDate(row_details[16],"DMY","en",localeName)%></font></td>
			<%} else {%>
            <td class=columnheader colspan=7> <font size=1><%=com.ehis.util.DateUtils.convertDate(row_details[16],"DMY","en",localeName)%></font></td>
            <% }
                tmp_ord_cat = (String)row_details[16];
            }%>
            <%if (group_by.equals("P")) {
            if (can_view_by.equals("L")) {%>
			<td class=columnheader colspan=8> <font size=1><%=row_details[3]%></font></td>
			<%} else {%>
            <td class=columnheader colspan=7> <font size=1><%=row_details[3]%></font></td>
            <% }
                tmp_ord_cat = (String)row_details[11];
            }%>
            <%if (group_by.equals("C")) {
            if (can_view_by.equals("L")) {%>
			<td class=columnheader colspan=8> <font size=1><%=row_details[6]%></font></td>
			<%} else {%>
            <td class=columnheader colspan=7> <font size=1><%=row_details[6]%></font></td>
            <% }
                tmp_ord_cat = (String)row_details[5];
            }%>

            <%if (group_by.equals("T")) {
            if (can_view_by.equals("L")) {%>
			<td class=columnheader colspan=8> <font size=1><%=row_details[8]%></font></td>
			<%} else {%>
            <td class=columnheader colspan=7> <font size=1><%=row_details[8]%></font></td>
            <% }
                tmp_ord_cat = (String)row_details[7];
            }%>

            <%if (group_by.equals("L")) {
            if (can_view_by.equals("L")) {%>
			<td class=columnheader colspan=8> <font size=1><%=(((String)row_details[17]).equals("") && ((String)row_details[18]).equals(""))? "Others" : (String)row_details[17] + "/" + (String)row_details[18]%></font></td>
			<%} else {%>
            <td class=columnheader colspan=7> <font size=1><%=(((String)row_details[18]).equals("") && ((String)row_details[18]).equals(""))? "Others" : (String)row_details[18] + "/" + (String)row_details[18]%></font></td>
            <% }
                tmp_ord_cat = grpCheckValue = (String)row_details[17] + "/" + (String)row_details[18];
            }%>
             <%if (group_by.equals("U")) {
            if (can_view_by.equals("L")) {%>
			<td class=columnheader colspan=8> <font size=1><%=row_details[1]%></font></td>
			<%} else {%>
            <td class=columnheader colspan=7> <font size=1><%=row_details[1]%></font></td>
            <% }
                tmp_ord_cat = (String)row_details[12];
            }%>

            <%if (group_by.equals("O")) {%>

            <%if (can_view_by.equals("L")) {%>
			<td class=columnheader colspan=8> <font size=1><%=row_details[2]%></font></td>
			<%} else {%>
            <td class=columnheader colspan=7> <font size=1><%=row_details[2]%></font></td>
            <% }
                tmp_ord_cat = (String)row_details[2];
            }%>

		</tr>
		<%}%>
        <%--<script>alert('<%=row_details[9]%>')</script>--%>
		<tr>
		<%
			String fontValue 		= "";
			String imageTag 		= "";
			String procedure_code	="";
//			String result_type		="";
			sex = row_details[14];
			if(row_details[12].equals("U")){
				fontValue = "<font size=1 color=red><b>";  // this is to indicate the different color for urgency
			}else if(row_details[12].equals("S")){
				fontValue = "<font size=1 color=brown><b>";  // this is to indicate the different color for Stat
				imageTag = "<img src=\"../images/StatOrders.gif\" width=\"26\" height=\"24\" border=0 alt=\"Stat\">";
			}else{
				fontValue = "<font size=1 color=black><b>";
			}%>
 		</tr>
			<td width='' class='<%=slClassValue%>' nowrap>  <font size=1><a class='gridLink' href='javascript:dummy()' onClick="procedureLink('<%=row_details[9]%>','<%=row_details[7]%>','<%=row_details[11]%>','<%=row_details[14]%>','<%=row_details[15]%>','<%=row_details[24]%>')"><%=com.ehis.util.DateUtils.convertDate(row_details[0],"DMYHM","en",localeName)%></a></font></td>
		 	<td width='' class='<%=slClassValue%>'> <%=fontValue%> <%=row_details[1]%> </font> <%=imageTag%> </td>
			<td width='' class='<%=slClassValue%>'> <font size=1><a class='gridLink' href='#' onClick="callMenuFunctions('View','<%=row_details[6]%>','<%=row_details[9]%>','','<%=sex%>','<%=patient_id%>','<%=procedure_code%>','<%=row_details[15]%>','N')"><%=row_details[2]%></a></td>
			<td width='' class='<%=slClassValue%>'><font size=1><%=row_details[3]%> </font></td>
			<td width='' class='<%=slClassValue%>' align=center><font size=1> <%=row_details[4]%></font> </td>
		
	<%i++;
		}
		
    }%>
	</table>  
</div>
<Input type="hidden" name="total_recs" id="total_recs" value="<%=i%>">
<Input type="hidden" name="order_category" id="order_category" value="<%=order_category%>">
<input type='hidden' name='group_by' id='group_by' value="<%=group_by%>">
<Input type="hidden" name="from_ca" id="from_ca" value="<%=from_ca%>">
<Input type="hidden" name="can_location_type" id="can_location_type" value="<%=can_location_type%>">
<input type='hidden' name='location' id='location' value="<%=can_location%>">
<input type='hidden' name='single_multi' id='single_multi' value="<%=can_single_multi%>">
<input type='hidden' name='priority' id='priority' value="<%=can_priority%>">
<Input type="hidden" name="date_from" id="date_from" value="<%=can_date_from%>">
<Input type="hidden" name="date_to" id="date_to" value="<%=can_date_to%>">
<Input type="hidden" name="patient_id" id="patient_id" value="<%=can_patient_id%>">
<Input type="hidden" name="order_id" id="order_id" value="<%=can_order_id%>">
<Input type="hidden" name="encounter_id" id="encounter_id" value="<%=can_encounter_id%>">
<Input type="hidden" name="patient_id_found" id="patient_id_found" value="<%=can_patient_id_found%>">
<Input type="hidden" name="order_type" id="order_type" value="<%=can_order_type%>">
<Input type="hidden" name="performing_location_code" id="performing_location_code" value="<%=can_performing_location_code%>">
<Input type="hidden" name="view_by" id="view_by" value="<%=can_view_by%>">
<input type='hidden' name='catalog_desc' id='catalog_desc' value="<%=request.getParameter("catalog_desc")%>">
<input type='hidden' name='task_status' id='task_status' value="<%=request.getParameter("task_status")%>">
<input type='hidden' name='source_type' id='source_type' value="<%=request.getParameter("source_type")%>">
<input type='hidden' name='peforming_location_code' id='peforming_location_code' value="<%=request.getParameter("peforming_location_code")%>">
<input type='hidden' name='source_location' id='source_location' value="<%=request.getParameter("source_location")%>">
<input type='hidden' name='search_criteria' id='search_criteria' value="<%=request.getParameter("search_criteria")%>">
<input type='hidden' name='activity_type' id='activity_type' value="<%=request.getParameter("activity_type")%>">

 <!-- For Next & previous -->
<input type='hidden' name='from' id='from' value='<%=from%>'>
<input type='hidden' name='to' id='to' value='<%=to%>'>
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
	<script>
			//if(parent.ResultReportingHeader.document.getElementById("tableheader")==null)
			//{
				//setTimeout("alignHeading();",300);
			//}
			//else 
				//alignCodingHeading();
	</script>

	 <!-- For Next & previous -->
</form>
</body>
<script>
parent.ResultReportingSearch.document.result_reporting_search.search_btn.disabled= false;
</script>
</html>
<%
	putObjectInBean(bean_id,bean,request);
%>

