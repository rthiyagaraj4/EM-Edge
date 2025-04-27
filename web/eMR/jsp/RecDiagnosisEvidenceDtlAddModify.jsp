<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*" %>
<%@ include file="RecDiagnosisGetValidation.jsp"%>
<html>
<head>
    <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale						= checkForNull((String)session.getAttribute("LOCALE"));
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCA/html/CAStyle.css"></link>
<script src='../../eMR/js/RecDiagnosisMain.js' language='javascript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con		= null;
	PreparedStatement pstmt = null;
	ResultSet rs		= null;
	String factorcode="",factordesc="",flag_yn="";
	String slClassValue = "";
	String checked = "";
	int ilCount = 0;
	int srl_num	=0;
	String p_factor_type="";
	String as_evidenced_by_fact		= checkForNull(request.getParameter("as_evidenced_by_fact"));

	StringTokenizer st_as_evidenced_by_fact = new StringTokenizer(as_evidenced_by_fact,"~");
	String Patient_Id				= checkForNull(request.getParameter("Patient_Id"));
	String term_set_id				= checkForNull(request.getParameter("term_set_id"));
	String term_code				= checkForNull(request.getParameter("term_code"));
	String occur_srl_no_hid			=request.getParameter("occur_srl_no_hid");
	String factor_type="";
	String header = "";
	int flag = 0;
	String nature= request.getParameter("nature")==null?"":request.getParameter("nature");
	//nature="";
	if(nature.equals("A")){
		p_factor_type="related";
		factor_type="RL";
		header = "Related factors";
	}
	else if(nature.equals("P")){
		p_factor_type="risk";
		factor_type="RS";
		header = "Risk factors";
	}

%>
	<table cellpadding='0' cellspacing='0' border='1' width='100%'  align=center>
	<form name='recDiagnosisEvidenceForm' id='recDiagnosisEvidenceForm' >
	<TH><%=header%></th> 
<%
	con = ConnectionManager.getConnection(request);
	StringBuffer sql = new StringBuffer();

try
{
	if(!nature.equals("W")&& !nature.equals(""))
	{
		if( occur_srl_no_hid != null)
		{
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("select max(STATUS_SRL_NO) srl_num from PR_DIAGNOSIS_EVIDENCE ");
			sql.append("where patient_id=? and term_set_id=? and term_code=? and occur_srl_no=?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1,Patient_Id);
			pstmt.setString(2,term_set_id);
			pstmt.setString(3,term_code);
			pstmt.setString(4,occur_srl_no_hid);
			rs= pstmt.executeQuery();
			if(rs.next())
			srl_num=rs.getInt("srl_num");
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append(" select decode(a.FACTOR_CODE,'','N','Y') flag_YN,b.FACTOR_CODE,b.SHORT_DESC	from "); 
		sql.append("PR_DIAGNOSIS_EVIDENCE a,mr_factor_lang_vw b where b.factor_code =a.FACTOR_CODE(+) and "); 
		sql.append(" a.PATIENT_ID(+) =? and a.term_set_id(+) =? and a.term_code(+) =? ");
		sql.append(" and b.EFF_STATUS='E' and a.status_srl_no(+) =? and language_id=? and (exists (select 1 from mr_factor_for_term_code where TERM_SET_ID=? and TERM_CODE=? and FACTOR_CODE=b.FACTOR_CODE ) or NOT EXISTS (SELECT 1 FROM MR_FACTOR_FOR_TERM_CODE WHERE TERM_SET_ID=? AND TERM_CODE =?)) ");
		
		
		if(p_factor_type.equals("related"))
		{
			sql.append("and related_factor_yn='Y' order by 2,3");
		}
		else if(p_factor_type.equals("risk"))
		{
			sql.append(" and risk_factor_yn='Y' order by 2,3");
		}
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1,Patient_Id);
		pstmt.setString(2,term_set_id);
		pstmt.setString(3,term_code);
		pstmt.setInt(4,srl_num);
		pstmt.setString(5,locale);
		pstmt.setString(6,term_set_id);
		pstmt.setString(7,term_code);
		pstmt.setString(8,term_set_id);
		pstmt.setString(9,term_code);
		rs= pstmt.executeQuery();
		while(rs.next())
		{
			flag = 1;
			st_as_evidenced_by_fact = new StringTokenizer(as_evidenced_by_fact, "~");
			factorcode	= rs.getString("FACTOR_CODE");
			factordesc		= rs.getString("SHORT_DESC");
			flag_yn		= rs.getString("FLAG_YN");
			if(flag_yn.equals("Y"))
			{
				checked="checked";
			}
			else
			{
				checked="";
			}
			while(st_as_evidenced_by_fact.hasMoreTokens())
			{
				String fact_code = (String) st_as_evidenced_by_fact.nextToken();
				if(factorcode.equals(fact_code))
				{
					checked = "checked";
				}
			}
			out.println("<tr>");
			slClassValue= ((ilCount % 2) == 0) ? "QRYEVEN" : "QRYODD";
			
			out.println("<td class='"+slClassValue+"'><input type='checkbox' name= 'evidence"+ilCount+"' value='"+factorcode+"' "+checked +" onclick='checkforOK(this);'> &nbsp;&nbsp;"+factordesc+"</td>");
			ilCount++;
			out.println("</tr>");
		}
		if(flag == 0)
		{
			//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));");
			out.println("<script>parent.rec_evidence_cols.cols='0%,*';</script>");
		}
		out.println("<input type='hidden' name='ilCount' id='ilCount' value='"+ilCount+"'>");
		out.println("<input type='hidden' name='Eve_factor_type' id='Eve_factor_type' value='"+factor_type+"'>");
	
	}
		out.println("<input type='hidden' name='flag' id='flag' value='"+flag+"'>");
		if(flag ==0)
		{
			out.println("<script>parent.rec_evidence_cols.cols='0%,*';</script>");
		}
}
catch(Exception e)
{
	//out.println("Exception in RecDiagnosisEvidenceDtlAddModify.jsp :"+e.toString());
	e.printStackTrace();
}
finally
{
	
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	if(con != null)ConnectionManager.returnConnection(con,request);
}
%>
</form>
</table>


