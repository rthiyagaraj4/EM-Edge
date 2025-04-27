<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
	<HEAD>
		<Title><fmt:message key="ePH.callQmsToken.label" bundle="${ph_labels}"/></Title>
<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</HEAD>
	<body>
		<form name="frmTokensToCallQMS" id="frmTokensToCallQMS">
			<div id='tokenNos' style='overflow:auto;width:250px;height:125px;position:relative;float:left;'>
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" >
					<tr><td colspan='2'>&nbsp;</tr>
<%
					try{
						String token_nos = request.getParameter("token_nos")==null?"":request.getParameter("token_nos");
						StringTokenizer stTokens = new StringTokenizer(token_nos,"~");
						String token_no ="", selectToken="Checked";
						int count=0;
						while (stTokens.hasMoreTokens()){
							token_no = stTokens.nextToken();
							if(count%2 ==0){
%>
								</tr>
								<tr><td width='10%'>&nbsp;</td>
<%
							}
%>
							<td class='label' width='50%'><input type='radio' name='callToken' id='callToken' value='<%=token_no%>' <%=selectToken%>>&nbsp;<%=token_no%></input>
<%
							selectToken="";
							count++;
						}
					}
					catch(Exception es){
						es.printStackTrace();
					}	
%>
					</tr>
				</table>
			</div>
			<div id='table_buttons' style='height:20px;width:250px;float:right;'>
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" >
					<tr>
						<td class='button' colspan='2'><input type='button' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' name='btnOk' onclick='selectToken();'>&nbsp;&nbsp;&nbsp;</td>
					</tr>
				</table>
			</div>
		</form>
	</body>
</html>

