<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>

<head>

<%
	request.setCharacterEncoding("UTF-8");	
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
</head>
<body CLASS='MESSAGE' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>

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
	String term_set_id = (request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id"));
	String sql = "";
	String isValid = "";
	con = ConnectionManager.getConnection(request);

	/*if(term_set_id.equals("ICD10"))
	{	
			sql = "select count(*) from mr_icd_code where diag_code=? and diag_code_scheme=?  and (gender_spec_ind is null or gender_spec_ind = ? ) and ( nvl(age_spec_ind,'O') NOT IN ('A','P','N') or age_spec_ind IN (select case when sysdate-to_date(?,'dd-mm-yyyy') between          NVL(ADULT_MIN_AGE_VALUE,0)*decode(ADULT_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(ADULT_MAX_AGE_VALUE,0) *decode(ADULT_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'A'	WHEN  Sysdate-to_date(?,'dd-mm-yyyy') between NVL(PEAD_MIN_AGE_VALUE,0)*decode(PEAD_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(PEAD_MAX_AGE_VALUE,0) *decode(PEAD_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'P' WHEN Sysdate-to_date(?,'dd-mm-yyyy') between NVL(NB_MIN_AGE_VALUE ,0)*decode(NB_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(NB_MAX_AGE_VALUE,0) *decode(NB_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'N'  END FROM MR_PARAMETER )) ";
			
			if (!p_code_indicator.equals(""))
				sql = sql+ " and code_indicator=? ";
			else
				sql = sql+ " and (code_indicator in ('D','C') OR code_indicator IS NULL )";
			
			stmt=con.prepareStatement(sql);
			stmt.setString(1,diag_code);
			stmt.setString(2,diag_scheme);
			stmt.setString(3,sex);
			stmt.setString(4,dob);
			stmt.setString(5,dob);
			stmt.setString(6,dob);
			if (!p_code_indicator.equals(""))
				stmt.setString(7,p_code_indicator);
	}
	else
	{*/
		/*sql = "select count(*) from mr_d_"+term_set_id+"_vw a where a.term_set_id='"+term_set_id+"' and a.TERM_CODE='"+diag_code+"' and (a.gender_spec_ind is null or a.gender_spec_ind = '"+sex+"' ) and ( nvl(a.age_spec_ind,'O') NOT IN ('A','P','N') or a.age_spec_ind IN (SELECT CASE WHEN SYSDATE - TO_DATE ('"+dob+"', 'dd-mm-yyyy') BETWEEN   NVL (MIN_AGE, 0) * DECODE (AGE_UNIT, 'Y', 365,'M', 30, 'D', 1, 1 ) AND   NVL (MAX_AGE, 0) * DECODE (AGE_UNIT, 'Y', 365, 'M', 30, 'D', 1, 1 ) THEN 'Y' ELSE 'N'        END YYY FROM AM_AGE_GROUP A, MR_AGE_GRP_FOR_TERM_CODE B WHERE A.AGE_GROUP_CODE = B.AGE_GROUP_CODE AND B.TERM_SET_ID = '"+term_set_id+"' AND B.TERM_CODE =  '"+diag_code+"' ))";

		if (!p_code_indicator.equals(""))
			sql = sql+ " and a.code_indicator='"+p_code_indicator+"' ";
		else
			sql = sql+ " and (a.code_indicator in ('D','C') OR a.code_indicator IS NULL )";	*/
			

		sql = "SELECT CASE WHEN SYSDATE - TO_DATE ('"+dob+"', 'dd-mm-yyyy') BETWEEN   NVL (A.MIN_AGE, 0) * DECODE (A.AGE_UNIT, 'Y', 365,'M', 30, 'D', 1, 1 ) AND   NVL (A.MAX_AGE, 0) * DECODE (A.AGE_UNIT, 'Y', 365, 'M', 30, 'D', 1, 1 ) AND A.GENDER = '"+sex+"' THEN 'Y' ELSE 'N'   END ISVALID FROM AM_AGE_GROUP A, MR_AGE_GRP_FOR_TERM_CODE B WHERE  A.AGE_GROUP_CODE = B.AGE_GROUP_CODE AND B.TERM_SET_ID = '"+term_set_id+"' AND B.TERM_CODE =  '"+diag_code+"'";


		stmt=con.prepareStatement(sql);
	//}

	//out.println("<script>alert(\""+sql+"\");</script>");
	
	rs = stmt.executeQuery();
	//rs.next();

	if(rs!=null && rs.next())
	{	
		isValid = rs.getString("ISVALID");
	}

	//if(rs.getInt(1) == 0)
	if(isValid!=null && isValid.equals("Y"))
	{
		//out.println("alert(getCAMessage('INVALID_DIAG_CODE_FOR_PATIENT','CA'));");
		out.println("<script>alert(getMessage('MR_INVALID_DIAG_CODE_FOR_PATIENT','MR'));</script>");
	}
	else
	{
		out.println("<script>window.parent.parent.returnValue='" + diag_code + "';");	
		out.println("window.parent.parent.close();</script>");
	}

	if(rs != null) rs.close();
	if(stmt != null) stmt.close();

}
catch(Exception e)
{
e.printStackTrace();
}
finally
{
	
	if(con!=null)ConnectionManager.returnConnection(con, request);
}
%>
</script>
</body>
<html>

