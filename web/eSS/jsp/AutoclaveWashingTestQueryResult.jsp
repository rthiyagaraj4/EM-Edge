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
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.util.*, eSS.*, eSS.Common.*,eCommon.Common.*"%><%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%
		request.setCharacterEncoding("UTF-8");
		String locale		=	(String)session.getAttribute("LOCALE");
		String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="javascript" src="../../eSS/js/AutoclaveWashingTest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown='CodeArrest();'>
<%
	String test_code			=		request.getParameter("test_code");
	String long_desc			=		request.getParameter("long_desc");
	String unit_type			=		request.getParameter("unit_type");
	String eff_status			=		request.getParameter("eff_status");

	boolean searched			=		(request.getParameter("searched") == null) ?false:true;
	String classvalue			=		"";

	try{

		test_code = CommonBean.checkForNull(test_code)+"%";
		long_desc = CommonBean.checkForNull(long_desc)+"%";
		eff_status = CommonBean.checkForNull(eff_status);

		HashMap sqlMap			=		new HashMap();
		sqlMap.put("sqlData", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_AUTOCLAVE_WASH_TEST_QUERY_RESULT") );
		
			
		HashMap funcMap			=		new HashMap();

		//The fields are going to be display
		ArrayList displayFields =		new ArrayList();

		displayFields.add("test_code");
		displayFields.add("long_desc");
		displayFields.add("short_desc");
		displayFields.add("unit_type");
		displayFields.add("biological_indicator"); //Added by Sakti against  AAKH_CRF_0057  inc#52312
		displayFields.add("bms_applicable"); //Added by Sakti against  AAKH_CRF_0057  inc#52312
		displayFields.add("eff_status");

		//The fields are going to be in where condition * should match with the query
		ArrayList chkFields		=		new ArrayList();
		chkFields.add( test_code);
		chkFields.add( long_desc);
		chkFields.add( unit_type);
		chkFields.add( eff_status);
		chkFields.add( locale);
		chkFields.add((String)session.getValue("facility_id"));  //Added by Rabbani #Bru-HIMS-CRF-390(42494) on 17-apr-2014


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
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
				<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
				<th width=150><fmt:message key="eSS.BiologicalIndicator.label" bundle="${ss_labels}"/></th>	
				<th width=150><fmt:message key="eSS.BMSPassFail.label" bundle="${ss_labels}"/></th>	
				<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
		<%
			ArrayList records=new ArrayList();
			String prev_unit_type	=	"";
			for(int recCount=2; recCount<result.size(); recCount++) {
				if (!prev_unit_type.equals((String)((ArrayList)result.get(recCount)).get(3))){
					out.println("<tr><td class='ITEMSELECT' colspan='6'><b>"+(String)((ArrayList)result.get(recCount)).get(3)+"</b></td></tr>");
				}
				prev_unit_type	=(String)((ArrayList)result.get(recCount)).get(3);
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
		%>
				<tr onClick="Modify(this);" >
		<%

				String link_columns = "1";
				records=(ArrayList) result.get( recCount );
				for(int colCount=0; colCount<records.size(); colCount++){
					if(colCount == 3) continue;

					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
		%>
						<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'>  <%=(String)records.get( colCount )%>    </font></td>
		<%
					}else{
		%>
						<td class="<%=classvalue%>" onclick="disableClick(event);"
						<%
						 //if gif has to be provided
							if(colCount == 6) {
								out.println(" align=\'center\'>");
								if( ((String)records.get( colCount )).equals("E"))
									out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
								else
									out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
							}
							else {
								out.println(">"+(String)records.get( colCount ));
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
		out.println(CommonBean.setForm ( request ,"../../eSS/jsp/AutoclaveWashingTestQueryResult.jsp", searched) );
	}
	catch(Exception e) {
// 		out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace(); // COMMON-ICN-0185
	}
%>
</body>
</html>

