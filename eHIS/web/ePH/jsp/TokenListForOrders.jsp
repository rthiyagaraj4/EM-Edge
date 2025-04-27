<!DOCTYPE html>
	<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
	<title><fmt:message key="ePH.TokenList.label" bundle="${ph_labels}"/>
	</title>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script>
	function printToken( printToken_yn){
		var source="onLinePrinting";
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		var xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","TokenListForOrdersValidate.jsp?validate="+source,true);
		xmlHttp.send(xmlDoc);
		window.close();
	}
</script>
	</head>
	<!-- <body> -->
	<body onMouseDown="" onKeyDown="">
<%
		String trn_group_ref	= request.getParameter("trn_group_ref")==null?"": request.getParameter("trn_group_ref");		
		String bean_id = "TokenListForOrdersBean" ;
		String bean_name = "ePH.TokenListForOrdersBean";
		TokenListForOrdersBean bean = (TokenListForOrdersBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);
		ArrayList alist= bean.getPopupScreenValues(trn_group_ref.trim());
/* alist data Structure
0 - DISP_LOCN_CODE
1 - disp_locn_desc
2 - TOKEN_SERIES_CODE
3 - token_series_desc
4 - token_serial_no
5 - patient_id
6 - FACILITY_ID
*/
		String classvalue="";
%>
		<form name="TokenList" id="TokenList">
			<table cellspacing='0' cellpadding='0' width='100%' height='100%' border='1'>
			<%
				int count=0;
				if(alist!=null && alist.size()>0){
%>
					<tr>
						<td class='COLUMNHEADER' height='1'><fmt:message key="ePH.DispenseLocation.label"  bundle="${ph_labels}"/></td>
						<td class='COLUMNHEADER' height='1'><fmt:message key="ePH.TokenSeries.label"  bundle="${ph_labels}"/></td>
						<td class='COLUMNHEADER' height='1'><fmt:message key="ePH.TokenNo.label"  bundle="${ph_labels}"/></td>
					</tr>
<%
					for(int i=0; i<alist.size(); i+=7){
						if(count%2 == 0)
							classvalue	 =	 "QRYEVEN" ;
						else
							classvalue	 =	 "QRYODD" ;
				%>
						<tr>
						<td class='<%=classvalue%>' align='center'><%=alist.get(i+1)%>
						</td>
						<td class='<%=classvalue%>' align='center'><%=alist.get(i+3)%>
						</td>
						<td class='<%=classvalue%>' align='center'><%=alist.get(i+4)%>
						</td>
					</tr>
				<%
						count++;
					}
				}
				else{
%>
					<tr>
						<td>
							<script>
								getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common");
							</script>
						</td>
					</tr>
<%				}
			%>
				<tr >
					<td  class='white' colspan='3' align='right' >
						<input type="button" class="button" name="ok" id="ok" value='<fmt:message key="Common.print.label" bundle="${common_labels}"/>' onClick="printToken('Y');">				
						<input type="button" class="button" name="ok" id="ok" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'   onClick="window.close();">				
					</td>
				</tr>
			</table>
		</form>
	</body>
<% 
	putObjectInBean(bean_id,bean,request);
%>
</html>

