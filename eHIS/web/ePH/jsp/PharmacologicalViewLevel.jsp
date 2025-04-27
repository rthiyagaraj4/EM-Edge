<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	

		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>


</head>
<%
	String bean_id		       = "@ATCClassificationBean" ;
	String bean_name		   = "ePH.ATCClassificationBean";
	String level_num	=	request.getParameter("level");
	String level_code	 = request.getParameter("code");
	String level_desc	=	request.getParameter("desc");

	if(level_num==null) level_num ="1";
	if(level_code==null) level_code ="";
	if(level_desc==null) level_desc ="";
	ATCClassificationBean bean = (ATCClassificationBean)getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);
	bean.setPharmaLevelCodes(level_num,level_code,level_desc);
	HashMap level_codes        = bean.getPharmaLevelCodes();
	if(level_codes==null) level_codes = new HashMap();
	String level_code_1="", level_desc_1 = "";
	String level_code_2="", level_desc_2 = "";
	String level_code_3="", level_desc_3 = "";
	if(level_codes.size()==2){
		level_code_1 = (String) level_codes.get("level_code_1");
		level_desc_1 = (String) level_codes.get("level_desc_1");
	}else if(level_codes.size()==4){
		level_code_1 = (String) level_codes.get("level_code_1");
		level_desc_1 = (String) level_codes.get("level_desc_1");
		level_code_2 = (String) level_codes.get("level_code_2");
		level_desc_2 = (String) level_codes.get("level_desc_2");
	}if(level_codes.size()==6){
		level_code_1 = (String) level_codes.get("level_code_1");
		level_desc_1 = (String) level_codes.get("level_desc_1");
		level_code_2 = (String) level_codes.get("level_code_2");
		level_desc_2 = (String) level_codes.get("level_desc_2");
		level_code_3 = (String) level_codes.get("level_code_3");
		level_desc_3 = (String) level_codes.get("level_desc_3");
	}
%>
<!-- <body bgcolor="navy" style="overflow-x:hidden;overflow-y:scroll"> -->
<body bgcolor="navy" style="overflow-x:hidden;overflow-y:scroll" onMouseDown="" onKeyDown="lockKey()">
<form name="PharmaViewLevel" id="PharmaViewLevel">
<table border='0' align=center width='100%' cellpadding='0' cellspacing='0'>
<tr>	<td class="tdvl"><fmt:message key="ePH.PharmacologicalClassification.label" bundle="${ph_labels}"/></td>		</tr>
<tr>	<td id='L1' class="dtdvl">&nbsp;<%=level_desc_1%></td>	</tr>
<tr>	<td>&nbsp;</td>											</tr> 
<tr>	<td class="tdvl"><fmt:message key="ePH.GroupClassification[LevelI].label" bundle="${ph_labels}"/></td>		</tr>
<tr>	<td id='L2' class="dtdvl">&nbsp;<%=level_desc_2%></td>	</tr>
<tr>	<td>&nbsp;</td>											</tr> 
<tr>	<td class="tdvl"><fmt:message key="ePH.SubGroupClassification[LevelII].label" bundle="${ph_labels}"/></td>	</tr>
<tr>	<td id='L3' class="dtdvl">&nbsp;<%=level_desc_3%></td>	</tr>
<tr>	<td>&nbsp;</td>											</tr> 
</table>
	<input type="hidden" name="level_code_1" id="level_code_1" value="<%=level_code_1%>">
	<input type="hidden" name="level_code_2" id="level_code_2" value="<%=level_code_2%>">
	<input type="hidden" name="level_code_3" id="level_code_3" value="<%=level_code_3%>">
	<input type="hidden" name="level_desc_1" id="level_desc_1" value="<%=level_desc_1%>">
	<input type="hidden" name="level_desc_2" id="level_desc_2" value="<%=level_desc_2%>">
	<input type="hidden" name="level_desc_3" id="level_desc_3" value="<%=level_desc_3%>">
</form>
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

