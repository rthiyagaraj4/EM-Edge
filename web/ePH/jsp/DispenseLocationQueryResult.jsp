<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.* " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<%
	request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/CommonResult.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/DispenseLocation.js"></SCRIPT>
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" >

<%
	String disp_locn_code		= request.getParameter( "DISP_LOCN_CODE" ) ;
	String disp_locn_desc		= request.getParameter( "DISP_LOCN_DESC" ) ;
	String disp_type			= request.getParameter( "DISP_TYPE" ) ;
	String eff_status			= request.getParameter( "EFF_STATUS" ) ;

	boolean searched			= request.getParameter( "searched" ) == null ? false : true ;
	String ord[]				= request.getParameterValues("orderbycolumns");

	try {
		String classvalue	= "";

		disp_locn_code 	= CommonBean.checkForNull( disp_locn_code );
		disp_locn_desc 	= CommonBean.checkForNull( disp_locn_desc );
		disp_type		= CommonBean.checkForNull( disp_type );
		eff_status		= CommonBean.checkForNull( eff_status );

		//Common parameters.
		HashMap sqlMap = new HashMap();
		sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_DISP_LOCN_SELECT7" ) );

		//The fields are going to be display
		ArrayList displayFields = new ArrayList();
		displayFields.add( "DISP_LOCN_CODE" );
		displayFields.add( "SHORT_DESC" );
		displayFields.add( "DISP_LOCN_TYPE" );
		displayFields.add( "PRINTER_LOCN_NAME_STAT_ORD" );
		displayFields.add( "PRINTER_LOCN_NAME_RTN_ORD" );
		displayFields.add( "IP_PRINTER_LOCN_NAME_STAT_ORD" );
		displayFields.add( "IP_PRINTER_LOCN_NAME_RTN_ORD" );
		displayFields.add( "EFF_STATUS" );

		//The fields are going to be in where condition * should match with the query
		ArrayList chkFields = new ArrayList();
		chkFields.add(session.getValue( "facility_id" ));
		chkFields.add( disp_locn_code + "%" );
		chkFields.add( disp_locn_desc + "%" );
		chkFields.add( disp_type );
		chkFields.add( disp_type );
		chkFields.add( eff_status );
		chkFields.add( eff_status );
		chkFields.add( locale );

		// Adding function parameters related array list into the HashMap
		HashMap funcMap = new HashMap();
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

		//Calling the Result from Common Adaptor as a arraylist.
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);

		if( result.size() >= 3 && ( !( ( (String)result.get(0)).equals("0")) )) {
%>

		<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center">
		<TR>
			<TD WIDTH="80%" CLASS="white">&nbsp;</TD>
			<TD WIDTH="20%" CLASS="white">&nbsp;

<%
			// For display the previous/next link
			
			out.println( result.get(1) );
%>

			</TD>
		</TR>
		</TABLE>

		<TABLE BORDER="1" CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center">
		<TR>
			<TH WRAP ROWSPAN="2" WIDTH="8%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></TH>
			<TH WRAP ROWSPAN="2" WIDTH="35%"><fmt:message key="Common.description.label" bundle="${common_labels}"/></TH>
			<TH WRAP ROWSPAN="2" WIDTH="15%"><fmt:message key="ePH.DispenseLocationType.label" bundle="${ph_labels}"/></TH>
			<TH WRAP COLSPAN="2" WIDTH="16%"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></TH>
			<TH WRAP COLSPAN="2" WIDTH="16%"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></TH>
			<TH WRAP ROWSPAN="2" WIDTH="10%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></TH>
		</TR>
		<TR>
			<TH WRAP WIDTH="8%"><fmt:message key="ePH.StatOrder.label" bundle="${ph_labels}"/></TH>
			<TH WRAP WIDTH="8%"><fmt:message key="ePH.RoutineOrders.label" bundle="${ph_labels}"/></TH>
			<TH WRAP WIDTH="8%"><fmt:message key="ePH.StatOrder.label" bundle="${ph_labels}"/></TH>
			<TH WRAP WIDTH="8%"><fmt:message key="ePH.RoutineOrders.label" bundle="${ph_labels}"/></TH>
		</TR>

<%
			//Retriving the records from result arraylist
			ArrayList records = new ArrayList();
			for(int recCount=2; recCount<result.size(); recCount++) {
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
%>

			<TR onClick="Modify(this);" >

<%
				String link_columns = "1";

				records = (ArrayList) result.get( recCount );
				for(int colCount=0; colCount<records.size(); colCount++) {

					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ) {
%>
				
				<TD CLASS="<%=classvalue%>" onMouseover="changeCursor(this);" ><FONT CLASS='HYPERLINK'>  <%=(String)records.get( colCount )%> </FONT></TD>
				
<%
					}
					else {
						if( colCount % 7 == 0 ) {
%>

				<TD ALIGN="center" CLASS="<%=classvalue%>" onClick="disableClick(event);">

<%
							if( ((String)records.get( colCount )).equals("E"))
								out.println("<IMG SRC=\"../../eCommon/images/enabled.gif\"></IMG><INPUT TYPE='hidden' VALUE='E'>");
							else
								out.println("<IMG SRC=\"../../eCommon/images/disabled.gif\"></IMG><INPUT TYPE='hidden' VALUE='D'>");
						}
						else if(colCount==2){

%>
<TD CLASS="<%=classvalue%>" onClick="disableClick(event);">
<%
out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common."+(String)records.get( colCount)+".label","common_labels"));
%>
<%
}else{%>

				<TD CLASS="<%=classvalue%>" onClick="disableClick(event);">

<%							
							String disp_value = (String)records.get( colCount );
							if (disp_value == null ) disp_value = "&nbsp;";
							out.println(disp_value);
						}

%>

				</TD>

<%
					}
				}
%>

			</TR>

<%
			}
%>

		</TABLE>
<%
			out.flush();
		}
		else {
%>

		<SCRIPT>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</SCRIPT>

<%
		}
		out.println(CommonBean.setForm ( request ,"../../ePH/jsp/DispenseLocationQueryResult.jsp", searched ) );
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>

</BODY>
</HTML>

