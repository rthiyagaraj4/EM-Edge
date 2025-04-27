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
-----------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
-----------------------------------------------------------------------------------------
?             100            ?           	?				?				created
17/02/2014	  IN024984		Karthi		21/02/2014		 Ramesh			Conditional reordering by clinician
24/03/2014	  IN047605		Karthi		24/03/2014		 Ramesh 		Alignment format of Duplicate Override reason text is differed		
25/03/2014	  IN048076		Karthi		25/03/2014		 Ramesh 		-Description of Duplicate check remarks window legend is differed.
------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,java.util.*,eOR.Common.*, eOR.*, java.net.URLDecoder, java.io.UnsupportedEncodingException,eCommon.XSSRequestWrapper " contentType="text/html;charset=ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
	<head>
		<%	
			String l_catalog_desc =  (request.getParameter("p_catalog_desc")==null)?"":request.getParameter("p_catalog_desc");
			l_catalog_desc = java.net.URLDecoder.decode(l_catalog_desc,"UTF-8"); //IN048076
		%>
		<title> Duplicate Remarks - <%= l_catalog_desc%></title>

		<%
			request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE1")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eOR/js/OrderEntry.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%
			String l_catalog_code =  (request.getParameter("p_catalog_code")==null)?"":request.getParameter("p_catalog_code");
			
			String l_bean_id 					= request.getParameter("bean_id"); 
			String l_bean_name 				= request.getParameter("bean_name");
			String l_dup_code_reason	=	"";
			HashMap l_hashMap			= null;
			
			try
			{
				OrderEntryBean beanObj 	= (OrderEntryBean)getBeanObject(l_bean_id, l_bean_name, request);
				l_hashMap				=  beanObj.getDupeReasonHashMap();
				
				if(l_hashMap != null) {
					if(l_hashMap.containsKey(l_catalog_code)){
						l_dup_code_reason = (String)l_hashMap.get(l_catalog_code);
					}	
				}	
		%>
		
	</head>
	<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
	
		<form name = 'DuplicateReamarksForm'>
			<br>
			<table border=0 cellpadding=3 cellspacing=0 align=center>
				<tr>
					<td>
						<!-- <textarea name="indi_dup_override_remarks"  value='<//%=l_dup_code_reason%>' rows="5" cols="60" maxlength='2000' onKeyPress='checkMaxLimit(this,2000);'    onBlur="makeValidString(this)" ></textarea></td> -->
						<textarea name="indi_dup_override_remarks"  value = '' rows="5" cols="60" maxlength='2000' onKeyPress='checkMaxLimit(this,2000);'   ></textarea></td>
					</td>
				</tr>
				<tr>
					<td align='right'>
						<input type='Button' class='Button' name='Ok' id='Ok' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onclick="doRemarksClose('<%=l_catalog_code%>','<%=l_bean_id%>','<%=l_bean_name%>')"></center>
					</td>
				</tr>	
			</table>
		<%		
			}
			catch(Exception e)
			{
			//	out.println("Exception in try of DuplicateOrderRemarksDialog.jsp:"+e);//COMMON-ICN-0181
                                 e.printStackTrace();//COMMON-ICN-0181
			}
		%>		
		</form>
		<script>
			//alert('line 59: <%=l_dup_code_reason%>');
			document.DuplicateReamarksForm.indi_dup_override_remarks.value = unescape('<%=l_dup_code_reason%>'); <!-- IN047605 -->
			//alert('line 61: ' + document.DuplicateReamarksForm.indi_dup_override_remarks.value);
		</script>
	</body>
</html>

