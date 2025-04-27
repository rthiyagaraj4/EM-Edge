<%@ page import ="java.sql.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	
	request.setCharacterEncoding("UTF-8");	
	Connection con=null;

	//StringBuffer sql = new StringBuffer();
	String formula_ref_id ="";
	String formula_ref_desc ="";
	String formula_detail ="";

%>

<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

try
{
	PreparedStatement stmt=null;
	ResultSet rs=null;
	con=ConnectionManager.getConnection(request);
	//String sql ="select r.CALC_DESC,g.FORMULA_REF_DESC from  CA_CLINICAL_CALC r,CA_CLIN_CALC_DEF g where r.CALC_ID=g.CALC_ID and r.FORMULA_REF_ID=g.FORMULA_REF_ID";
	String sql ="SELECT h.FORMULA_REF_DESC,h.FORMULA_DETAIL FROM CA_CLIN_CALC_DEF h where h.FORMULA_REF_ID=?";

	formula_ref_id = request.getParameter("formula_ref_id")==null?"":request.getParameter("formula_ref_id");
	
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
 <script src='../../eCA/js/ClinicalCalcParameter.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<form name='ClinicalCalcSelectedForm' id='ClinicalCalcSelectedForm'  method='post' target='messageFrame'    >
<body  class='CONTENT' OnMouseDown="CodeArrest()"  onKeyDown="lockKey()"  >

<table border=0 cellspacing=0 cellpadding=3 width='100%' align=center>

<% 
	stmt = con.prepareStatement(sql);
	stmt.setString(1,formula_ref_id);
		rs = stmt.executeQuery();

		while(rs.next())
		{
			formula_ref_desc = rs.getString("FORMULA_REF_DESC");
			formula_detail = rs.getString("FORMULA_DETAIL"); 

%>

<tr>
	
	<td class=label width='25%'><b><%=formula_ref_desc%></b></td>
	<td class=label width='75%'><%=formula_detail%></td>
	<!--<td class=label width='25%'>&nbsp;</td>
	<td class=label width='25%'>&nbsp;</td>-->
</tr>
<% }

			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();

%>

</table>
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

