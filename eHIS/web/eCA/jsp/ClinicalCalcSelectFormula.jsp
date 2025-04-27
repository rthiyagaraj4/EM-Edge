<%@ page import ="java.sql.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	
	request.setCharacterEncoding("UTF-8");	
	Connection con=null;

	StringBuffer sql = new StringBuffer();
	String calc_id ="";
	String calc_desc ="";

%>

<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String imgUrl="";

		if(sStyle.equals("IeStyle.css"))
		{
		imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
		}

try
{
	PreparedStatement stmt=null;
	ResultSet rs=null;
	con=ConnectionManager.getConnection(request);

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
 <script src='../../eCA/js/ClinicalCalcParameter.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<form name='ClinicalCalcSelectForm' id='ClinicalCalcSelectForm'  method='post' target='messageFrame'  action='../../servlet/eCA.ClinicalCalcParamServlet'      >
<body  class='CONTENT' OnMouseDown="CodeArrest()"  onKeyDown="lockKey()"  >

<table border=0 cellspacing=0 cellpadding=3 width='100%' align=center>

<tr>
	<td class=label width='25%'><fmt:message key="eCA.ClinicalCalculations.label" bundle="${ca_labels}"/></td>
	<td class='fields' width='25%'><select name='clin_calc' id='clin_calc' onChange='loadFormulae(this);' >
		<option value="">---------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</option>

		<%
	    sql = new StringBuffer();	
		sql.append("select a.CALC_ID,a.CALC_DESC from CA_CLINICAL_CALC a where a.FORMULA_REF_ID is not null ");

		stmt = con.prepareStatement(sql.toString());
		rs = stmt.executeQuery();

		while(rs.next())
		{
			calc_id = rs.getString("CALC_ID");
			calc_desc = rs.getString("CALC_DESC");
		
		%>
			<option value='<%=calc_id%>'><%=calc_desc%></option>
		<%}
			
			//added new
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();

	%>



		</select><img src='../../eCommon/images/mandatory.gif'>
	</td>
	<td class=label width='25%'><fmt:message key="eCA.FormulaeToBeUsed.label" bundle="${ca_labels}"/></td>
	<td class='fields'><select name='clin_formula' id='clin_formula' onchange='loadSelFormulae(this)'>
		<option value="">-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------</option>
		</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
	</td>
</tr>
</table>
<%if(!imgUrl.equals("")){ %>
<br><br><br><br>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<br><br>
<%}%>
<!--
<br><br>
		<hr color=thickblue height=1>
		<br><br>
		-->
</form>

</body>
</html>

<%
	
}
catch(Exception e)
{
	//out.println("From ClinicalCalcSelectFormula.jsp" + e.toString());//COMMON-ICN-0181
	e.printStackTrace();
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

%>

