<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>

<head>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
</head>
<body CLASS='MESSAGE' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<script>
<%
Connection con = null;  
PreparedStatement stmt=null;
ResultSet rs = null;
try
{
	String diag_code = request.getParameter("diag_code");
	String diag_scheme = request.getParameter("diag_scheme");
	String p_code_indicator = request.getParameter("p_code_indicator");
	String sex = request.getParameter("Sex");
	String dob = request.getParameter("Dob");
	String sql = "select count(*) from mr_icd_code where diag_code=? and diag_code_scheme=?  and (gender_spec_ind is null or gender_spec_ind = ? ) and ( nvl(age_spec_ind,'O') NOT IN ('A','P','N') or age_spec_ind IN (select case when sysdate-to_date(?,'dd-mm-yyyy') between          NVL(ADULT_MIN_AGE_VALUE,0)*decode(ADULT_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(ADULT_MAX_AGE_VALUE,0) *decode(ADULT_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'A'	WHEN  Sysdate-to_date(?,'dd-mm-yyyy') between NVL(PEAD_MIN_AGE_VALUE,0)*decode(PEAD_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(PEAD_MAX_AGE_VALUE,0) *decode(PEAD_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'P' WHEN Sysdate-to_date(?,'dd-mm-yyyy') between NVL(NB_MIN_AGE_VALUE ,0)*decode(NB_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(NB_MAX_AGE_VALUE,0) *decode(NB_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'N'  END FROM MR_PARAMETER )) ";
	
	if (!p_code_indicator.equals(""))
		sql = sql+ " and code_indicator=? ";
	else
		sql = sql+ " and (code_indicator in ('D','C') OR code_indicator IS NULL )";
	con = ConnectionManager.getConnection(request);
	stmt=con.prepareStatement(sql);
	stmt.setString(1,diag_code);
	stmt.setString(2,diag_scheme);
	stmt.setString(3,sex);
	stmt.setString(4,dob);
	stmt.setString(5,dob);
	stmt.setString(6,dob);
	if (!p_code_indicator.equals(""))
		stmt.setString(7,p_code_indicator);
	rs = stmt.executeQuery();
	rs.next();
	if(rs.getInt(1) == 0)
	{
		out.println("alert(getCAMessage('INVALID_DIAG_CODE_FOR_PATIENT','CA'));");
	}
	else
	{
		out.println("window.parent.parent.returnValue='" + diag_code + "';");	
		out.println("window.parent.parent.close();");
	}

	if(rs != null) rs.close();
	if(stmt != null) stmt.close();

}
catch(Exception e)
{
	//out.println(e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	
	if(con!=null)ConnectionManager.returnConnection(con, request);
}
%>
</script>
</body>
<html>

