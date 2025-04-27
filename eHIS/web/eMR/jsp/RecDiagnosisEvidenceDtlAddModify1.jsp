<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file = "RecDiagnosisGetValidation.jsp"%>

    <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale						= checkForNull((String)session.getAttribute("LOCALE"));

	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCA/html/CAStyle.css"></link>
<script src='../../eMR/js/RecDiagnosisMain.js' language='javascript'></script>


<%
	request.setCharacterEncoding("UTF-8");
	Connection con						= null;
	PreparedStatement pstmtSql = null;
	ResultSet rset						= null;

	String definecode="",definedesc="",checked="";
	int ilRow = 0;
	int ilCount = 0;
	int srl_num	=0;
	String slClassValue = "",flag_yn="";
	String as_evidenced_by_defn =checkForNull(request.getParameter("as_evidenced_by_defn"));
	String Patient_Id			=checkForNull(request.getParameter("Patient_Id"));
	String term_set_id			=checkForNull(request.getParameter("term_set_id"));
	String term_code			=checkForNull(request.getParameter("term_code"));
	String occur_srl_no_hid=checkForNull(request.getParameter("occur_srl_no_hid")); 
	
	//StringTokenizer st_as_evidenced_by_defn = new StringTokenizer(as_evidenced_by_defn, "#");
	

	%>

<form name='recDiagnosisEvidenceForm' id='recDiagnosisEvidenceForm' >
	<table cellpadding='0' cellspacing='0' border='1' width='100%'  align=center>
	<TH><fmt:message key="eMR.DefiningCharacteristics.label" bundle="${mr_labels}"/></TH>			
<%
con = ConnectionManager.getConnection(request);
StringBuffer sqlQuery = new StringBuffer();
try
{
	if(sqlQuery.length() > 0) sqlQuery.delete(0,sqlQuery.length());
	sqlQuery.append("select max(STATUS_SRL_NO) srl_num from PR_DIAGNOSIS_EVIDENCE ");
	sqlQuery.append("where patient_id=? and term_set_id=? and term_code=? and occur_srl_no=?");
	pstmtSql = con.prepareStatement(sqlQuery.toString());
	pstmtSql.setString(1,Patient_Id);
	pstmtSql.setString(2,term_set_id);
	pstmtSql.setString(3,term_code);
	pstmtSql.setString(4,occur_srl_no_hid);
	rset= pstmtSql.executeQuery();
		
		if(rset.next())
			srl_num=rset.getInt("srl_num");
			
	if(rset != null) rset.close();
	if(pstmtSql != null) pstmtSql.close();

	if(sqlQuery.length() > 0) sqlQuery.delete(0,sqlQuery.length());
	sqlQuery.append("select decode(a.FACTOR_CODE,'','N','Y') flag_YN,b.FACTOR_CODE,b.SHORT_DESC	");
	sqlQuery.append("from PR_DIAGNOSIS_EVIDENCE a,mr_factor_lang_vw b where ");
	sqlQuery.append(" b.factor_code =a.FACTOR_CODE(+) and a.PATIENT_ID(+) =? ");
	sqlQuery.append(" and a.term_set_id(+) =? and a.term_code(+) =? and a.OCCUR_SRL_NO(+) =?");
	sqlQuery.append(" and b.DEFN_CHARACTERISTIC_YN='Y' and  ");
	sqlQuery.append(" b.EFF_STATUS='E' and a.status_srl_no(+)=? and b.language_id=? and (exists (select 1 from mr_factor_for_term_code where TERM_SET_ID=? and TERM_CODE=? and FACTOR_CODE=b.FACTOR_CODE ) or NOT EXISTS (SELECT 1 FROM MR_FACTOR_FOR_TERM_CODE WHERE TERM_SET_ID=? AND TERM_CODE =?)) order by 2,3");
	pstmtSql = con.prepareStatement(sqlQuery.toString());
	pstmtSql.setString(1,Patient_Id);
	pstmtSql.setString(2,term_set_id);
	pstmtSql.setString(3,term_code);
	pstmtSql.setString(4,occur_srl_no_hid);
	pstmtSql.setInt(5,srl_num);
	pstmtSql.setString(6,locale);
	pstmtSql.setString(7,term_set_id);
	pstmtSql.setString(8,term_code);
	pstmtSql.setString(9,term_set_id);
	pstmtSql.setString(10,term_code);
	rset= pstmtSql.executeQuery();
	int flag = 0;
	while(rset.next())
	{
		flag = 1;
		definecode	= rset.getString("FACTOR_CODE");
		definedesc	= rset.getString("SHORT_DESC");
		flag_yn		= rset.getString("FLAG_YN");
		if(flag_yn.equals("Y"))
		{
			checked="checked";
		}
		else
		{
			checked="";
		}
		
		StringTokenizer st_as_evidenced_by_defn = new StringTokenizer(as_evidenced_by_defn, "#");
		
		while(st_as_evidenced_by_defn.hasMoreTokens())
		{
			String define_code = (String) st_as_evidenced_by_defn.nextToken();
			StringTokenizer define_code1 = new StringTokenizer(define_code,"~");
			while(define_code1.hasMoreTokens())
			{
				String code = (String) define_code1.nextToken();	
				if(definecode.equals(code))
				{
				checked = "checked";
							//out.println("<script>alert('define_code"+define_code+"')</script>");
				}
			}
		}
	out.println("<tr>");
	slClassValue= ((ilCount % 2) == 0) ? "QRYEVEN" : "QRYODD";
	out.println("<td class='"+slClassValue+"'><input type='checkbox' name= 'evidence"+ilRow+"' value='"+definecode+"'  "+ checked+ " onclick='checkforOK(this)' > &nbsp;&nbsp;"+definedesc+"</td>");
	ilCount++;
	ilRow++;	
	out.println("</tr>");
	}

	if(flag == 0)
	{
		//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));");
		out.println("<script>parent.rec_evidence_cols.cols='*,0%';</script>");
	}

		out.println("<input type='hidden' name='ilRow' id='ilRow' value='"+ilRow+"'>");
		out.println("<input type='hidden' name='define_factor_type' id='define_factor_type' value='DC'>");
		out.println("<input type='hidden' name='flag' id='flag' value='"+flag+"'>");

}
catch(Exception e)
{
	//out.println("Exception in RecDiagnosisEvidenceDtlAddModify1.jsp :"+e.toString());
	e.printStackTrace();
}
finally
{
	if(rset!=null) rset.close();
	if(pstmtSql!=null) pstmtSql.close();
	if(con != null)ConnectionManager.returnConnection(con,request);
}
%>
</form>
</table>

