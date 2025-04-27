<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<HEAD>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
</HEAD>
<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()'>
<%
Connection con = null; 
try
{
    request.setCharacterEncoding("UTF-8");
	PreparedStatement stmt=null;
	ResultSet rs = null;
	String diag_code = (request.getParameter("diag_code")==null?"":request.getParameter("diag_code"));
	String p_scheme = (request.getParameter("p_scheme")==null?"":request.getParameter("p_scheme"));
	String sex = (request.getParameter("Sex")==null?"":request.getParameter("Sex"));
	String dob = (request.getParameter("Dob")==null?"":request.getParameter("Dob"));
	String code_indicator = (request.getParameter("code_indicator")==null?"":request.getParameter("code_indicator"));
	String short_desc = "";
	String long_desc = "";
	//out.println("<script>alert('code_indicator: (IN ADD ASSS VAL " + code_indicator  + "')</script>");	
	StringBuffer sql = new StringBuffer();

	sql.append("select short_desc, diag_srl_no, record_type, cause_indicator, analysis_code, notifiable_yn, sensitive_yn, long_desc, code_indicator from mr_icd_code where diag_code=? and diag_code_scheme=?  AND code_indicator =? ");

	/*if(code_indicator.equals(""))
		sql.append(" and code_indicator in ('C','D','') ");
	else if(code_indicator.equals("C"))
		sql.append("and code_indicator = 'E' ");
	else if(code_indicator.equals("D"))
		sql.append("and code_indicator = 'A' ");*/

	con = ConnectionManager.getConnection(request);
	stmt = con.prepareStatement(sql.toString());
	stmt.setString(1, diag_code.toUpperCase());
	stmt.setString(2, p_scheme);
	stmt.setString(3, code_indicator);
	if(p_scheme.equals("2"))
		sql.append(" and record_type='D' "); 
	rs = stmt.executeQuery();
	if(rs.next())
	{
		short_desc = rs.getString("short_desc");
		long_desc = rs.getString("long_desc");
		sql = new StringBuffer();
		sql.append("select count(*) from mr_icd_code where diag_code=? and diag_code_scheme=?  and (gender_spec_ind is null or gender_spec_ind = ? ) and ( nvl(age_spec_ind,'O') NOT IN ('A','P','N') or age_spec_ind IN (select case when sysdate-to_date(?,'dd-mm-yyyy') between          NVL(ADULT_MIN_AGE_VALUE,0)*decode(ADULT_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(ADULT_MAX_AGE_VALUE,0) *decode(ADULT_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'A'	WHEN  Sysdate-to_date(?,'dd-mm-yyyy') between NVL(PEAD_MIN_AGE_VALUE,0)*decode(PEAD_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(PEAD_MAX_AGE_VALUE,0) *decode(PEAD_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'P' WHEN Sysdate-to_date(?,'dd-mm-yyyy') between NVL(NB_MIN_AGE_VALUE ,0)*decode(NB_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(NB_MAX_AGE_VALUE,0) *decode(NB_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'N'  END FROM MR_PARAMETER ))  ");
		/*if(code_indicator.equals(""))
		sql.append(" and (code_indicator in ('C','D') or code_indicator is null)");
		else if(code_indicator.equals("C"))
			sql.append("and code_indicator = 'E' ");
		else if(code_indicator.equals("D"))
			sql.append("and code_indicator = 'A' ");*/

		if(p_scheme.equals("2"))
				sql.append(" and record_type='D' "); 
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();

		stmt = con.prepareStatement(sql.toString());
		stmt.setString(1, diag_code.toUpperCase());
		stmt.setString(2, p_scheme);
		stmt.setString(3, sex);
		stmt.setString(4, dob);
		stmt.setString(5, dob);
		stmt.setString(6, dob);
		rs = stmt.executeQuery();
		if(rs.next())
		{
			if(rs.getInt(1) != 0)
			{%>
				<SCRIPT LANGUAGE="JavaScript">
					parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_desc.value = '<%=short_desc%>';
					parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.long_desc.value = "<%=long_desc%>";
					parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.exclamation.disabled=false;
					if(parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.flag_to_add.value == 'Y')
						parent.AddAssociateCodeAddModifyFrame.doSelect('A');
					else
						parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.flag_to_add.value = 'Y'

				</SCRIPT>
			<%
					
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				}
			else
			{%>
				<SCRIPT LANGUAGE="JavaScript">
					alert(parent.getMessage("INVALID_DIAG_CODE_FOR_PATIENT",'CA'));
					
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
	}
	else
	{
%>
	<SCRIPT LANGUAGE="JavaScript">
		alert(getMessage('INVALID_DIAGCODE','CA'));
		
		parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_code.value = '';
		parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_code.focus();
		parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_code.select();
		parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_desc.value = '';
		parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.long_desc.value = '';
		parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.exclamation.disabled=true;
	</SCRIPT>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%
	}

	
}
catch(Exception e)
{
	e.printStackTrace();
	//out.println("Exception from AddAssociateCodeGetDiagVal.jsp " + e.toString());//common-icn-0181
}
finally
{
	
	if(con != null) ConnectionManager.returnConnection(con, request);
}
%>
</BODY>
</HTML>

