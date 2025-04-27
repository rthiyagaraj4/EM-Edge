<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
<%
       request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	   String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/CommonResult.js"></SCRIPT>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhMessages.js"></SCRIPT>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PresRemark.js"></SCRIPT>
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
	<BODY onMouseDown="CodeArrest();" onKeyDown="lockKey();" >
<%
		String remark_code		= request.getParameter( "REMARK_CODE" ) ;
		String remark_desc		= request.getParameter( "REMARK_DESC" ) ;
		String form_code		= request.getParameter( "FORM_CODE" ) ;
		String form_desc		= request.getParameter( "FORM_DESC" ) ;
		String route_code		= request.getParameter( "ROUTE_CODE" ) ;
		String route_desc		= request.getParameter( "ROUTE_DESC" ) ;
		String appl_sliding_scale_yn		= request.getParameter( "APPL_SLIDING_SCALE_YN" ) ;
		String  fntColor="", backgrndColor="", route_color =""; // added for CRF RUT-CRF-0034.1[IN:037389]
		boolean searched			= request.getParameter( "searched" ) == null ? false : true ;
		String ord[]				= request.getParameterValues("orderbycolumns");
		try {
			String classvalue	= "";
			remark_code 	= CommonBean.checkForNull( remark_code );
			remark_desc 	= CommonBean.checkForNull( remark_desc );
			form_code		= CommonBean.checkForNull( form_code );
			form_desc		= CommonBean.checkForNull( form_desc );
			route_code		= CommonBean.checkForNull( route_code );
			route_desc		= CommonBean.checkForNull( route_desc );
			appl_sliding_scale_yn		= CommonBean.checkForNull( appl_sliding_scale_yn );
			//Common parameters.
			HashMap sqlMap = new HashMap();
			sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_PRES_REMARK_SELECT1" ) );

			//The fields are going to be display
			ArrayList displayFields = new ArrayList();
			displayFields.add( "REMARK_CODE" );
			displayFields.add( "REMARK_DESC" );
			displayFields.add( "FORM_CODE" );
			displayFields.add( "FORM_DESC" );
			displayFields.add( "ROUTE_CODE" );
			displayFields.add( "ROUTE_DESC" );
			displayFields.add( "APPL_SLIDING_SCALE_YN" );
			displayFields.add( "ROUTE_COLOR" );// added for CRF RUT-CRF-0034.1[IN:037389]

			//The fields are going to be in where condition * should match with the query
			ArrayList chkFields = new ArrayList();
			chkFields.add( remark_code + "%" );
			chkFields.add( remark_desc + "%" );
			chkFields.add( form_code + "%" );
			chkFields.add( form_desc + "%" );
			chkFields.add( route_code + "%" );
			chkFields.add( route_desc + "%" );
			chkFields.add( appl_sliding_scale_yn + "%" );
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
					<TH WIDTH="13%"><fmt:message key="ePH.RemarkCode.label" bundle="${ph_labels}"/></TH>
					<TH WIDTH="13%"><fmt:message key="ePH.RemarkDescription.label" bundle="${ph_labels}"/></TH>
					<TH WIDTH="13%"><fmt:message key="ePH.FormCode.label" bundle="${ph_labels}"/></TH>
					<TH WIDTH="13%"><fmt:message key="ePH.FormDescription.label" bundle="${ph_labels}"/></TH>
					<TH WIDTH="13%"><fmt:message key="ePH.RouteCode.label" bundle="${ph_labels}"/></TH>
					<TH WIDTH="13%"><fmt:message key="ePH.RouteDescription.label" bundle="${ph_labels}"/></TH>
					<TH WIDTH="13%"><fmt:message key="ePH.SlidingScaleRemarks.label" bundle="${ph_labels}"/></TH>
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
							String data = "";
							records = (ArrayList) result.get( recCount );
							route_color=((String)records.get(7)); // added for CRF RUT-CRF-0034.1[IN:037389]
							if(route_color!= null && !route_color.equals("")){
								if(route_color.length()==12){
									fntColor= route_color.substring(0, 6);
									backgrndColor= route_color.substring(6, 12);
								}
							}
							else{
								 fntColor= "";
								 backgrndColor= "";
							}// added for CRF RUT-CRF-0034.1[IN:037389]-end
							for(int colCount=0; colCount<records.size()-1; colCount++) {
								data="";
								data = (String)records.get( colCount );
								if (data==null || data.equals("") )
									data = "&nbsp;";
								if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ) {
%>
										<TD CLASS="<%=classvalue%>" onMouseover="changeCursor(this);" ><FONT CLASS='HYPERLINK'>  <%= data %> </FONT></TD>
<%
									}
									else {
										if(data.equals("Y")){
											data="<img src=\"../../eCommon/images/enabled.gif\"><input type='hidden' value='Y' name='scale' id='scale'>";
										}
										else if(data.equals("N")){
											data="<img src=\"../../eCommon/images/disabled.gif\"><input type='hidden' value='N' name='scale' id='scale'>";
										}
										if(colCount==5 ){// added for CRF RUT-CRF-0034.1[IN:037389]-start
%>
											<td class="<%=classvalue%>" style='color:<%=fntColor%>;background-color:<%=backgrndColor%>' value="<%=(String)records.get( colCount )%>" 
<%
											out.println(data);
										}// added for CRF RUT-CRF-0034.1[IN:037389]-end
										if( colCount % 7 == 0 ) {
%>
											<TD  CLASS="<%=classvalue%>" onClick="disableClick(event);">
<%
										}
										else {
%>
											<TD CLASS="<%=classvalue%>" onClick="disableClick(event);">
<%
										}
										out.println(data);
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
			out.println(CommonBean.setForm ( request ,"../../ePH/jsp/PresRemarkQueryResult.jsp", searched ) );
		}
		catch(Exception e) {
			out.print("Exception @ Result JSP :"+e.toString());
		}
%>
	</BODY>
</HTML>

