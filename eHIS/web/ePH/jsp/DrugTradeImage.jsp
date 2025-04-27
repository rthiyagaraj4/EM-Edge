<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
	
<%
		request.setCharacterEncoding("UTF-8");
//Added  for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		//String locale			= (String)session.getAttribute("LOCALE");
	
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  
	</head>

	<!-- <body> -->
	<body onMouseDown="" onKeyDown="lockKey()">
<%
		String drug_code	= request.getParameter("drug_code")==null?"": request.getParameter("drug_code");
		String trade_code	= request.getParameter("trade_code")==null?"":request.getParameter("trade_code");
		String imageURL	= request.getParameter("imageURL")==null?"":request.getParameter("imageURL");
		String drugyesno = request.getParameter("drugyesno")==null?"":request.getParameter("drugyesno");		

		if(imageURL.equals("")){
			if(!drug_code.equals("")){
				String bean_id = "DrugTradeImageBean" ;
				String bean_name = "ePH.DrugTradeImageBean";
				DrugTradeImageBean bean = (DrugTradeImageBean)getBeanObject( bean_id, bean_name, request ) ;
				bean.setDrugyesno(drugyesno);	
				imageURL = bean.getImagePath(drug_code,trade_code);
			}
		}
		
%>	  
	
	<title>
	      <fmt:message key="Common.Drug/TradeImage.label" bundle="${common_labels}"/>
	</title>
		<form name="ViewImage" id="ViewImage">
		
			<table cellspacing='0' cellpadding='0' width='100%' height='100%' border='0'>
				<tr height='5'>

					<td class='label' align='center'><%=imageURL%>
					</td>

				
				</tr>
				<tr >
					<td class='WHITE' align='center' valign='middle'>
						<img src="<%=imageURL%>" border=0 align='center' >
					</td>
				</tr>
				<tr  height='5'>
					<td  align='right' style=" padding-top: 340px;">
						<input type="button" class="button" name="ok" id="ok" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'   onClick="parent.document.getElementById('dialog_tag').close()">				
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

