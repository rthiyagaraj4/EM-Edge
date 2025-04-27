<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,oracle.jdbc.driver.*,java.net.*,java.text.*, webbeans.eCommon.*" %>

<HTML>
<HEAD>

<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
</HEAD>
<BODY onKeyDown='lockKey()'>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null;  
	PreparedStatement pstmt=null;
    PreparedStatement pstmt1=null;
	ResultSet rs = null;
	ResultSet rs1 = null;

try
{
	String diag_code = (request.getParameter("diag_code")==null?"":request.getParameter("diag_code"));
	String p_scheme = (request.getParameter("p_scheme")==null?"":request.getParameter("p_scheme"));
	String sex = (request.getParameter("Sex")==null?"":request.getParameter("Sex"));
	String dob = (request.getParameter("Dob")==null?"":request.getParameter("Dob"));
	String code_indicator = (request.getParameter("code_indicator")==null?"":request.getParameter("code_indicator"));
	String short_desc = "";
	String long_desc = "";

	StringBuffer sql = new StringBuffer();

	sql.append("select short_desc, diag_srl_no, record_type, cause_indicator, analysis_code, notifiable_yn, sensitive_yn, long_desc, code_indicator from mr_icd_code where diag_code=? and diag_code_scheme=?  ");

	if(code_indicator.equals(""))
		sql.append(" and code_indicator in ('C','D','') ");
	else if(code_indicator.equals("C"))
		sql.append("and code_indicator = 'E' ");
	else if(code_indicator.equals("D"))
		sql.append("and code_indicator = 'A' ");

	con = ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement(sql.toString());
	pstmt.setString(1, diag_code.toUpperCase());
	pstmt.setString(2, p_scheme);
	if(p_scheme.equals("2"))
		sql.append(" and record_type='D' "); 
	rs = pstmt.executeQuery();
	if(rs.next())
	{
		short_desc = rs.getString("short_desc");
		long_desc = rs.getString("long_desc");
		sql = new StringBuffer();
		sql.append("select count(*) from mr_icd_code where diag_code=? and diag_code_scheme=?  and (gender_spec_ind is null or gender_spec_ind = ? ) and ( age_spec_ind is null or age_spec_ind = (select case when sysdate-to_date(?,'dd-mm-yyyy') between          NVL(ADULT_MIN_AGE_VALUE,0)*decode(ADULT_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(ADULT_MAX_AGE_VALUE,0) *decode(ADULT_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'A'	WHEN  Sysdate-to_date(?,'dd-mm-yyyy') between NVL(PEAD_MIN_AGE_VALUE,0)*decode(PEAD_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(PEAD_MAX_AGE_VALUE,0) *decode(PEAD_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'P' WHEN Sysdate-to_date(?,'dd-mm-yyyy') between NVL(NB_MIN_AGE_VALUE ,0)*decode(NB_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(NB_MAX_AGE_VALUE,0) *decode(NB_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'N'  END FROM MR_PARAMETER ))  ");
		if(code_indicator.equals(""))
		sql.append(" and (code_indicator in ('C','D') or code_indicator is null)");
		else if(code_indicator.equals("C"))
			sql.append("and code_indicator = 'E' ");
		else if(code_indicator.equals("D"))
			sql.append("and code_indicator = 'A' ");

		if(p_scheme.equals("2"))
				sql.append(" and record_type='D' "); 
		pstmt1 = con.prepareStatement(sql.toString());
		pstmt1.setString(1, diag_code.toUpperCase());
		pstmt1.setString(2, p_scheme);
		pstmt1.setString(3, sex);
		pstmt1.setString(4, dob);
		pstmt1.setString(5, dob);
		pstmt1.setString(6, dob);
		rs1 = pstmt1.executeQuery();
		if(rs1.next())
		{
			if(rs1.getInt(1) != 0)
			{%>
				<SCRIPT LANGUAGE="JavaScript">
					parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_desc.value = '<%=short_desc%>';
					parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.long_desc.value = '<%=long_desc%>';
					parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.exclamation.disabled=false;
					if(parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.flag_to_add.value == 'Y')
						parent.AddAssociateCodeAddModifyFrame.doSelect('A');
					else
						parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.flag_to_add.value = 'Y'

				</SCRIPT>
			<%}
			else
			{%>
				<SCRIPT LANGUAGE="JavaScript">
					alert(parent.getMessage("MR_INVALID_DIAG_CODE_FOR_PATIENT","MR"));
					
					parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_code.value = '';
					parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_code.focus();
					parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_code.select();
					parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_desc.value = '';
					parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.long_desc.value = '';
					parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.exclamation.disabled=true;
					parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.flag_to_add.value = '';
				</SCRIPT>
			<%}
		}
		if(rs1 !=null) rs1.close();
		if(pstmt1 !=null)pstmt1.close();
	}
	else
	{
%>
	<SCRIPT LANGUAGE="JavaScript">
		alert(getMessage('INVALID_DIAGCODE'));
		
		parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_code.value = '';
		parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_code.focus();
		parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_code.select();
		parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_desc.value = '';
		parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.long_desc.value = '';
		parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.exclamation.disabled=true;
	</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();

	}
}
catch(Exception e)
{
	e.printStackTrace();
}
finally
{	
	if(con != null) ConnectionManager.returnConnection(con, request);
}
%>
</BODY>
</HTML>

