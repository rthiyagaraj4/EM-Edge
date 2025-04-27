<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.* ,javax.servlet.*,javax.servlet.http.*,webbeans.eCommon.*,org.json.simple.parser.JSONParser,org.json.simple.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 

%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<Script language='javascript' src='../js/PatDispArchConfig.js'></Script> 
	<script language="JavaScript" src="../../eCommon/js/tableheaderscroll.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<script>
		window.onload=function(){
			if(document.getElementById("specialityList")!=null)			
				fxheaderInit('specialityList',480);
		};


	</script>
	<style>
		
    </style>
	</style>
</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="test_form" id="test_form" action="../../servlet/eMR.PatDispArchConfigServlet" method="post" target="messageFrame"  >

<%
	Connection con = null;
	
	try	{
		con = ConnectionManager.getConnection(request);
		String locale			= (String)session.getAttribute("LOCALE");
		String arch_disp		= checkForNull(request.getParameter("arch_disp"),"0");
		JSONArray specialityJsonArr	= new JSONArray();
		specialityJsonArr  = eMR.MRPatDisposalArchivalBean.getSpecailtyList(con,locale,arch_disp);
		String classValue = "" ;


		
%>

		
			<table  border='1' cellpadding='0' cellspacing='0'   width="98%" id="specialityList" style="margin-left:3px;" >
				<tr>
					<th class="COLUMNHEADER"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.name.label" bundle="${common_labels}"/></th>
					<th class="COLUMNHEADER" ><fmt:message key="Common.duration.label" bundle="${common_labels}"/> (<fmt:message key="Common.year.label" bundle="${common_labels}"/>)</th>
				</tr>
				<%for(int i = 0 ; i < specialityJsonArr.size() ; i++) {
					JSONObject specialityJson		= (JSONObject)specialityJsonArr.get(i);
					String specialityCode		= (String) specialityJson.get("specialityCode");
					String specialityShortDesc	= (String) specialityJson.get("specialityShortDesc");
					String cutOffPeriod	= (String) specialityJson.get("cutOffPeriod");
					int j= i+1;
					if (j%2 == 0)
						classValue = "QRYEVEN" ;
					else
						classValue = "QRYODD" ;	
				%>
				<tr>
				<td  class="<%=classValue%>"><%=specialityShortDesc%></td>
				<td  class="<%=classValue%>"><input type="text" maxlength="2" name="<%=specialityCode%>" id="<%=specialityCode%>" value="<%=cutOffPeriod%>" onKeyPress='return(ChkNumberInput(this,event,0))' onblur="SPCheckPositiveNumber(this);checkZero(this)"/></td>
				</tr>
				<%}%>
			</table>

			<input type="hidden" name="selectedSpecialityLists" id="selectedSpecialityLists"  />
			<input type="hidden" name="arch_disp" id="arch_disp" value="<%=arch_disp%>" />
	
</form>

</body>
</html>

<%

	} catch(Exception e) {/* out.println(e.getMessage()); */e.printStackTrace();}
	
	finally {
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>

<%!	
	private String checkForNull(String inputString)	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

