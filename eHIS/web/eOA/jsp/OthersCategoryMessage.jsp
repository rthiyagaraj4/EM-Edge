<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*,java.util.*,com.ehis.util.* ,eCommon.XSSRequestWrapper" %> 
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eOA/js/ClinicAllocation.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String step=request.getParameter("step");
String otherCount=request.getParameter("otherCount");
String otherCountval=request.getParameter("otherCountval")==null?"0":request.getParameter("otherCountval");
String finalValue=request.getParameter("finalValue");
String alcn_criteria=request.getParameter("alcn_criteria");
String time_table_type=request.getParameter("time_table_type");
String max_patients_per_day=request.getParameter("max_patients_per_day");
int others=0;
int count=0;
StringTokenizer valueToken=null;
StringTokenizer groupToken=null;
int groupVisits=0;
int grpVisitsCnt=0;
try{
if(finalValue!=null && !finalValue.equals("")){
	StringTokenizer str=new StringTokenizer(finalValue,"$");
	count=str.countTokens();
	if(count !=2){
		groupToken=new StringTokenizer(finalValue,"|");
		while(groupToken.hasMoreTokens()){
			String s=groupToken.nextToken();
			valueToken=new StringTokenizer(s,"$");
			valueToken.nextToken();
			groupVisits=Integer.parseInt(valueToken.nextToken());
			grpVisitsCnt=grpVisitsCnt+groupVisits;
		}
	}else{
		str.nextToken();
		groupVisits=Integer.parseInt(str.nextToken());
		grpVisitsCnt=grpVisitsCnt+groupVisits;
	}
}
if(step.equals("1")){
	if(otherCountval!=null && !otherCountval.equals("")){
		others=Integer.parseInt(otherCountval);
	}else{
		others=Integer.parseInt(max_patients_per_day);
	}
}else{
	if(otherCountval!=null && !otherCountval.equals("")){
		others=Integer.parseInt(otherCount);
	}
}
%>
<body onKeyDown = 'lockKey()'>
<form name='other_alcn_form' id='other_alcn_form'>
<table border=0 cellpadding=0 cellspacing=0 width='100%' align='center'>
<tr><td width='25%' colspan='4'></td></tr>
<tr>
<td width='25%'></td>
<td width='25%'></td>
<td width='25%'></td>
<td width='25%' class='LABEL'><fmt:message key="Common.others.label" bundle="${common_labels}"/></td><td class='LABEL'><%=others%></td>
</tr>
<tr>
<td width='25%'></td>
<td width='25%'></td>
<td width='25%'></td>
<td width='25%' class='BUTTON'><input type='BUTTON' name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick='closealcnwindow()'></td>
</tr>
</table>
<input type="hidden" name="oth_alcn_criteria" id="oth_alcn_criteria" value="<%=alcn_criteria%>">
<input type="hidden" name="oth_time_table_type" id="oth_time_table_type" value="<%=time_table_type%>">
<input type="hidden" name="oth_max_patients_per_day" id="oth_max_patients_per_day" value="<%=max_patients_per_day%>">
<input type="hidden" name="otherCount" id="otherCount" value="<%=others%>">
<form>
<%}catch(Exception ex){
	ex.printStackTrace();
}%>
</body>
</html>

