<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page  contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
<%
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/PhMessages.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/WsTokenSeries.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<SCRIPT>
			var function_id = "<%= request.getParameter( "function_id" ).trim() %>"
		</SCRIPT>
	</HEAD>
<%
	try{
		request.setCharacterEncoding("UTF-8");	
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
 		request= new XSSRequestWrapper(request); 
 		response.addHeader("X-XSS-Protection", "1; mode=block"); 
 		response.addHeader("X-Content-Type-Options", "nosniff"); 
 		//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale			= (String)session.getAttribute("LOCALE");

		
		/* Mandatory checks start */
		String mode			= request.getParameter( "mode" ).trim() ;
		String bean_id		= "WsTokenSeriesBean" ;
		String bean_name	= "ePH.WsTokenSeriesBean";
		String checkyn		="";
		String checktempyn="";
		String default_chk	=	"";//added for [IN:037465]
		String token_series_default		=	"N"; //added for [IN:037465]
		if ( mode == null || mode.equals("") )
			return ;

		if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
			return ;
		/* Mandatory checks end */

		/* Initialize Function specific start */
		WsTokenSeriesBean bean = (WsTokenSeriesBean)getBeanObject(bean_id,bean_name,request) ;
		bean.setLanguageId(locale);
		bean.clear() ;
		bean.setMode( mode ) ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		int numrecs				= 24;
		int start				= (request.getParameter( "from" ) == null) ? 0 : Integer.parseInt(request.getParameter( "from" ));
		HashMap records			= null;	
		int org_row_cnt			= 0;
		ArrayList tokenWs = new ArrayList();
		ArrayList chkd_token_series = new ArrayList(); ;
		/* Initialize Function specific end*/
		if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) {
			String jsp_flag			= request.getParameter( "jsp_flag" ).trim() ;
			String locn_code = request.getParameter( "locn_code" ).trim() ;
			String ws_st = request.getParameter( "ws_st" ).trim() ;
			if (jsp_flag.equals("1")) {
				String firstTime		= request.getParameter( "firstTime" ).trim() ;
				if (firstTime.equals("Y")) {
					bean.setDispLocn(locn_code);
					bean.setWSLocn(ws_st);
					records	= new HashMap();
					//	bean.getWorkStations(locn_code);
					 tokenWs = (ArrayList) bean.getTokenWs(locn_code,ws_st);
					bean.setDefaultTokenSeries(locn_code,ws_st);
				}
				else
					records = bean.getHashData()==null?new HashMap():bean.getHashData();
			}
			else if (jsp_flag.equals("2")) {
				records = bean.getHashData();
			}
			String defTokenSeries = bean.getDefaultTokenSeries(); //added for [IN:037465]
			if (jsp_flag.equals("1") || jsp_flag.equals("2") ) {
				ArrayList tokenSeries = bean.getTokenSeries();
				if (tokenSeries.size() != 0) {
%>
				<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()">
					<FORM name="formWsTokenSeriesDtls" id="formWsTokenSeriesDtls">
						<INPUT TYPE="hidden" name="jsp_flag" id="jsp_flag" VALUE="<%= jsp_flag %>">
						<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="80%" ALIGN="center" BORDER="0">
						<TR>
							<TD WIDTH="100%" >&nbsp;</TD>
<%
							if ( start>0 ) {
%>
								<TD class='HYPERLINK' ><A HREF onMouseover="changeCursor(this)" onClick="makeChanges('Prev', <%= start-numrecs %>)"><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A></TD>
<%
							}
							if ( (tokenSeries.size()) > (start+numrecs) ) {
%>
								<TD class='HYPERLINK'><A HREF onMouseover="changeCursor(this)" onClick="makeChanges('Next', <%= start+numrecs %>)">&nbsp;&nbsp;<fmt:message key="Common.next.label" bundle="${common_labels}"/></A></TD>
<%
							}
%>
							</TD>
						</TR>
					</TABLE>
					<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="1">
						<TH WIDTH="60%"><fmt:message key="ePH.TokenSeries.label" bundle="${ph_labels}"/></TH>
						<TH WIDTH="20%"><fmt:message key="ePH.DefaultTokenSeries.label" bundle="${ph_labels}"/></TH>
						<TH WIDTH="20%"><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></TH>
<%
						chkd_token_series = (ArrayList) bean.getTempAssoDatas();
						String bgcolor	= "";
						int end = start+numrecs;
						if(end>tokenSeries.size()) 
							end=tokenSeries.size();
						if (jsp_flag.equals("1")) {
							for (int j=start; j<end ; j+=2) {
								// chkd_token_series has codes of already associated token series from the db and checkboxes which are currently checked
								if(chkd_token_series != null)
									if(chkd_token_series.contains(tokenSeries.get(j)) ){//Checking if the temp array list contains the token series code
										checkyn="Y";
									}
									else{
										checkyn="N";
									}
									if(defTokenSeries.equals((String)tokenSeries.get(j))) // added for [IN:037465] -start
										token_series_default = "Y";
									else
										token_series_default = "N";
									if(token_series_default.equals("Y"))
										default_chk = "Checked";
									else if (!checkyn.equals("Y"))
										default_chk="disabled";
									else
										default_chk=""; //added for [IN:037465] -end
									for (int cnt=start; cnt<records.size(); cnt++) {
										org_row_cnt++;
										if (org_row_cnt > numrecs)
											break;
									}
									if (j % 4 == 0)
										bgcolor = "QRYEVEN" ;
									else
										bgcolor = "QRYODD" ;
%>
									<TR>
										<TD CLASS="<%= bgcolor %>" WIDTH="60%">
<%
										if (checkyn.equals("Y")) {
%>
			 								<FONT CLASS="DATAHIGHLIGHT"><%= tokenSeries.get(j+1) %></FONT>
<%
										}
										else {
%>
											<%= tokenSeries.get(j+1) %>
<%
										}
%>
										</TD>
										<TD CLASS="<%= bgcolor %>" WIDTH="20%"> <!-- added for [IN:037465] -start -->
										<input type="checkbox" name="default_<%=j%>" id="default_<%=j%>" <%=default_chk%>  onClick="unCheckOthers(document.formWsTokenSeriesDtls,'<%=start%>','<%=end%>','<%=j%>');"> 
										</TD> <!-- added for [IN:037465] - end -->
										<TD CLASS="<%= bgcolor %>" WIDTH="20%">&nbsp;
<%
										if (checkyn.equals("Y")) {
%>
			 								<input type="checkbox" name="asso_yn_<%= j %>" id="asso_yn_<%= j %>" value="<%=tokenSeries.get(j)%>" checked onClick="updateTempAssoDatas(document.formWsTokenSeriesDtls,this,'<%=j%>');"> 
<%
										}
										else {
%>
											<input type="checkbox" name="asso_yn_<%= j %>" id="asso_yn_<%= j %>" value="<%=tokenSeries.get(j)%>" onClick=" updateTempAssoDatas(document.formWsTokenSeriesDtls,this,'<%=j%>');">
<%              
										}
%>
										</TD>
									</TR>
									<INPUT TYPE="hidden" name="TS_CODE_<%= j %>" id="TS_CODE_<%= j %>" VALUE="<%= tokenSeries.get(j)%>">	
<%
								}
							}
%>
							</TABLE>
							<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%= mode %>">
							<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
							<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
							<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%= bean.getFunctionId() %>">
							<INPUT TYPE="hidden" name="totalrecs" id="totalrecs" VALUE="<%= tokenSeries.size() %>">
							<INPUT TYPE="hidden" name="locn_code" id="locn_code" VALUE="<%= locn_code %>">
							<INPUT TYPE="hidden" name="ws_st" id="ws_st" VALUE="<%= ws_st %>">
							<INPUT TYPE="hidden" name="db_mode" id="db_mode" VALUE="I">
						</FORM>
					</BODY>
<%
				}
				else {
%>
					<SCRIPT>
						alertmessage();
						//alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
						//history.go(-1);
						//parent.ws_ts_button.history.go(-1);
					</SCRIPT>
<%
				}
			}
			else if (jsp_flag.equals("3")) {
%>
				<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
				int totalrecs	= Integer.parseInt(request.getParameter( "totalrecs" ) ) ;
				Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
				hash = (Hashtable)hash.get( "SEARCH" ) ;
				StringBuffer paramstring	= new StringBuffer();
				for (int i=0; i<=totalrecs; i++ ) {
					if(hash.containsKey("TOKEN_SERIES_"+i)) {
						
						if(hash.containsKey("TOKEN_SERIES_"+i))
							 paramstring=paramstring.append(hash.get( "TOKEN_SERIES_"+i ).toString()).append("|");
							//paramstring += hash.get( "TOKEN_SERIES_"+i ).toString() + "|";		
						if(hash.containsKey("DB_MODE_"+i))
							  paramstring=paramstring.append(hash.get( "DB_MODE_"+i ).toString()).append("|");
							//paramstring += hash.get( "DB_MODE_"+i ).toString() + "|";
					}
				}
				out.println(paramstring);
				bean.setHashData(paramstring.toString());
			}
		}
		putObjectInBean(bean_id,bean,request);
	}
	catch (Exception e) {
		e.printStackTrace();
	}
%>
</HTML>

