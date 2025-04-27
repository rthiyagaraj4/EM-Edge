<!DOCTYPE html>
   <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
	
<% 
		request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonResult.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<!--<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>-->
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
		<!--<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhMessages.js"></SCRIPT>-->
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/WsTokenSeries.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		String disp_locn_code	= request.getParameter( "DISP_LOCN_CODE" ) ;
		String disp_locn_desc	= request.getParameter( "DISP_LOCN_DESC" ) ;
		String ts_code			= request.getParameter( "TS_CODE" ) ;
		String ts_desc			= request.getParameter( "TS_DESC" ) ;
		String ws_no			= request.getParameter( "WS_NO" ) ;
		boolean searched		= request.getParameter( "searched" ) == null ? false : true ;
		String ord[]			= request.getParameterValues("orderbycolumns");
		try {
			String classvalue	= "";

			disp_locn_code 	= CommonBean.checkForNull( disp_locn_code );
			disp_locn_desc	= CommonBean.checkForNull( disp_locn_desc );
			ts_code			= CommonBean.checkForNull( ts_code );
			ts_desc			= CommonBean.checkForNull( ts_desc );
			ws_no			= CommonBean.checkForNull( ws_no );

			//Common parameters.
			HashMap sqlMap = new HashMap();
			sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_WS_TS_SELECT" ) ) ;

			//The fields are going to be display
			ArrayList displayFields = new ArrayList();
			displayFields.add( "DISP_LOCN_CODE" );
			displayFields.add( "SHORT_DESC" );
			displayFields.add( "TOKEN_SERIES_CODE" );
			displayFields.add( "DESCRIPTION" );
			displayFields.add( "DEFAULT_TOKEN_YN" );
			displayFields.add( "WS_NO" );

			//The fields are going to be in where condition * should match with the query
			ArrayList chkFields = new ArrayList();
			chkFields.add( disp_locn_code + "%" );
			chkFields.add( disp_locn_desc + "%" );
			chkFields.add( ts_code + "%" );
			chkFields.add( ts_desc + "%" );
			chkFields.add( ws_no + "%" );
			chkFields.add(locale);

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
					<TH WIDTH="10%"><fmt:message key="ePH.DispenseLocationCode.label" bundle="${ph_labels}"/></TH>
					<TH WIDTH="25%"><fmt:message key="ePH.DispenseLocationDescription.label" bundle="${ph_labels}"/></TH>	
					<TH WIDTH="10%"><fmt:message key="ePH.TokenSeriesCode.label" bundle="${ph_labels}"/></TH>
					<TH WIDTH="25%"><fmt:message key="ePH.TokenSeriesDescription.label" bundle="${ph_labels}"/></TH>		
					<TH WIDTH="5%"><fmt:message key="ePH.DefaultTokenSeries.label" bundle="${ph_labels}"/></TH>		<!-- added for [IN:037465]-->
					<TH WIDTH="25%"><fmt:message key="ePH.WorkStationNumber.label" bundle="${ph_labels}"/>
					</TH>

<%
					//Retriving the records from result arraylist
					ArrayList records = new ArrayList();
					for(int recCount=2; recCount<result.size(); recCount++) {
						if ( recCount % 2 == 0 )
							classvalue = "QRYEVEN" ;
						else
							classvalue = "QRYODD" ;
%>
						<TR>
<%
						records = (ArrayList) result.get( recCount );
						for(int colCount=0; colCount<records.size(); colCount++) {
							if(colCount==4){//if block and else condition added for [IN:037465]
								if(records.get(colCount) == null || !(((String)records.get( colCount )).equals("Y"))){
%>
									<TD CLASS="<%=classvalue%>" onClick="disableClick(event);" style='text-align:center'><img src='../../eCommon/images/disabled.gif'></img></img></TD>
<%
								}
								else{
%>
									<TD CLASS="<%=classvalue%>" onClick="disableClick(event);" style='text-align:center'><img src='../../eCommon/images/enabled.gif'></img></TD>
<%
								}
							}
							else{
%>
								<TD CLASS="<%=classvalue%>" onClick="disableClick(event);"><%=(String)records.get( colCount )%></TD>
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
			out.println(CommonBean.setForm ( request ,"../../ePH/jsp/WsTokenSeriesQueryResult.jsp", searched ) );
		}
		catch(Exception e) {
			out.print("Exception @ Result JSP :"+e.toString());
		}
%>
	</BODY>
</HTML>

