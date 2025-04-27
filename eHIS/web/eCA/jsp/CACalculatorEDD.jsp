<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script src='../../eCA/js/CACalculator.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	Connection con =null ;
	PreparedStatement stmt1=null;
	ResultSet rs1=null;
	String edd = "";
	String lmpdate="";
	String cycle="";
	try {
		con = ConnectionManager.getConnection();
		
		 lmpdate = request.getParameter("lmp")==null?"":request.getParameter("Imp");
		 cycle = request.getParameter("cycle")==null?"":request.getParameter("cycle");

		if(!cycle.equals("") && !lmpdate.equals("") ){
			String sql = "select  calculate_edd(?,?) FROM DUAL";
			stmt1 = con.prepareStatement(sql);
			stmt1.setInt(1,Integer.parseInt(cycle));
			stmt1.setString(2,lmpdate);
			rs1=stmt1.executeQuery() ;
			rs1.next();
			edd = rs1.getString(1);
		}
	}catch(Exception e){
		//out.println("Exception in CACalculatorEDD.jsp"+e.toString());//COMMON-ICN-0181
		  e.printStackTrace();//COMMON-ICN-0181
	}finally{
			if (rs1!=null) rs1.close();
			if (stmt1!=null) stmt1.close();
			if (con!=null) ConnectionManager.returnConnection(con);
	}
%>

<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name ='CerebralEDD' action="CACalculatorEDD.jsp">
	<table width ='95%' height='40%' border=0 cellpadding=0 cellspacing=0 align=center RULES=NONE>

		<tr><th colspan='4' align='left'><fmt:message key="Common.EDD.label" bundle="${common_labels}"/></th></tr>
		
		<tr>
		<td class="label" colspan ='2' align ='right' width='50%'><fmt:message key="eCA.LMP.label" bundle="${ca_labels}"/></td>
		<td><input type='text' name ='lmp' size ='10' class="DATA" style="text-align: Right" maxLength ='10' value="<%=lmpdate%>"></td>
		</tr>

		<tr>
		<td colspan ='2'class="LABEL" align=right><fmt:message key="Common.CycleDays.label" bundle="${common_labels}"/></td>
		<td><input type='text' name='cycle' id='cycle' size='5' class="DATA" value="<%=cycle%>" style="text-align: Left"></td>
		</tr>

		<tr>
		<td colspan=3 align=center><input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Calculate.label","ca_labels")%>' onClick='javaScript:CalculateEDD()' class="BUTTON" ></td>
		</tr>

		<tr>
		<td colspan ='2'class="data" nowrap align=right><fmt:message key="Common.EDD.label" bundle="${common_labels}"/></td>
		<td><input type='text' name='edd' id='edd' size='10' class="DATA" style="text-align: Left" value="<%=edd%>"></td>
		</tr>

</table>
</form>

</body>
</html>

