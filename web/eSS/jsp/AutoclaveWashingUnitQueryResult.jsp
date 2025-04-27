<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name			INC Number       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------------------------

12/11/2014				AAKH_CRF_0057			Sakti Sankar		52312											Autoclaving function, option to select
																													Biological indicator , BMS Pass / Fail 
																													Both in Master as wel as Transaction function.
--------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eSS.Common.*, eSS.* " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
String locale = (String)session.getAttribute("LOCALE");
%>
<html>
<head>
	<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="javascript" src="../../eSS/js/AutoclaveWashingUnit.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown='CodeArrest();'>
<%
	String autoclave_wash_unit_code = request.getParameter("autoclave_wash_unit_code");
	String long_desc = request.getParameter("long_desc");
	String unit_type				= request.getParameter("unit_type");
	String service_location_code	= request.getParameter("service_location_code");
	String eff_status = request.getParameter("eff_status");
	String auto_wash_unit = "";
	boolean searched = (request.getParameter("searched") == null) ?false:true;
	String classvalue = "";	
	try{

		autoclave_wash_unit_code = CommonBean.checkForNull(autoclave_wash_unit_code)+"%";
		long_desc                = CommonBean.checkForNull(long_desc)+"%";
		unit_type				 = CommonBean.checkForNull(unit_type)+"%";
		service_location_code	 = CommonBean.checkForNull(service_location_code)+"%";
		eff_status               = CommonBean.checkForNull(eff_status);

		HashMap sqlMap = new HashMap();
		sqlMap.put("sqlData",eSS.Common.SsRepository.getSsKeyValue("SQL_SS_AUTOCLAVE_WASH_UNIT_QUERY_RESULT"));
		
		
		HashMap funcMap = new HashMap();

		//The fields are going to be display
		ArrayList displayFields = new ArrayList();

		displayFields.add("autoclave_wash_unit_code");
		displayFields.add("aut_long_desc");
		displayFields.add("aut_short_desc");
        displayFields.add("service_location_desc");  
		displayFields.add("sterile_desc");  
        displayFields.add("unit_condition");
		displayFields.add("biological_indicator"); //Added by Sakti against  AAKH_CRF_0057  inc#52312
		displayFields.add("bms_applicable"); //Added by Sakti against  AAKH_CRF_0057  inc#52312
		displayFields.add("eff_status");
		displayFields.add("unit_type");
		
		

		//The fields are going to be in where condition * should match with the query
		ArrayList chkFields = new ArrayList();
		chkFields.add( autoclave_wash_unit_code);
		chkFields.add( long_desc);
		chkFields.add( eff_status);
		chkFields.add( unit_type);
		chkFields.add( service_location_code);
		chkFields.add( locale);
		chkFields.add((String)session.getValue("facility_id"));   //Added by Rabbani #Bru-HIMS-CRF-390(42494) on 17-apr-2014
		//out.println(chkFields);

		// Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

		
					
	
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
		
		%>
			<table cellpadding=0 cellspacing=0 width="100%" align="center">
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;
				<%
					out.println(result.get(1));		
				%>
				</td>
			</tr>
			</table>

			<table border="1" cellpadding="0" cellspacing="0" width="130%" align="center">
				<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eSS.ServiceLocation.label" bundle="${ss_labels}"/></th>
                <th><fmt:message key="eSS.SterilizationType.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="eSS.UnitCondition.label" bundle="${ss_labels}"/></th>	
				<th width=150><fmt:message key="eSS.BiologicalIndicator.label" bundle="${ss_labels}"/></th>	
				<th width=150><fmt:message key="eSS.BMSPassFail.label" bundle="${ss_labels}"/></th>	
				<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
				
				
		<%
			ArrayList records=new ArrayList();
			for(int recCount=2; recCount<result.size(); recCount++) {
		
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
		%>
		<%

				String link_columns = "1";
				records=(ArrayList) result.get( recCount);
					for(int colCount=0; colCount<records.size()-1; colCount++){
						if( !auto_wash_unit.equals((String)records.get(9)) ) {
							auto_wash_unit = (String)records.get(9);
							out.println("<tr><td class='ITEMSELECT' align='left' colspan='9'><b>"+auto_wash_unit+"</b></td></tr>");
						}

					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
		%>
				<tr onClick="Modify(this);" >
						<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'>  <%=(String)records.get( colCount )%>    </font></td>
		<%
					}else{
		%>
						<td class="<%=classvalue%>" onclick="disableClick(event);"
						<%
						 //if gif has to be provided
							if(colCount == 8) {
								out.println(" align=\'center\'>");
								if( ((String)records.get( colCount )).equals("E"))
									out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
								else
									out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
							}
							else {
								out.println(">"+CommonBean.checkForNull((String)records.get( colCount ),"&nbsp;"));
							}
						%></td>
		<%
						}
					}
		%>
			</tr>
		<%
			}
		%>
		</table>
		<%
			out.flush();
		} 
		else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				history.go(-1);
			</script>
		<%
		}
		out.println(CommonBean.setForm ( request ,"../../eSS/jsp/AutoclaveWashingUnitQueryResult.jsp", searched) );
	}
	catch(Exception e) {
		// out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace(); // COMMON-ICN-0185
	}
%>
</body>
</html>

