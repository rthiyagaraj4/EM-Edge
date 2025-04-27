<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*, java.util.* ,com.ehis.util.*,java.text.*,java.net.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<%
	request.setCharacterEncoding("UTF-8");
	java.util.Properties p			= (java.util.Properties) session.getValue( "jdbc" ) ;

	String facility_id				= (String) session.getValue("facility_id");
	String qrystr			= request.getQueryString();
	String callFunction     = request.getParameter("callFunction");
	String short_desc       = request.getParameter("short_desc");
	String encounter_id       = request.getParameter("encounter_id");
	String term_code       = request.getParameter("term_code");
	String occur_srl_no       = request.getParameter("occur_srl_no");
	String term_set_id       = request.getParameter("term_set_id");
	String Title			="";
	Connection con					= null;
	Statement		stmt			= null;
	ResultSet rs					= null;
	StringBuffer sdesc				= new StringBuffer();

	con	= ConnectionManager.getConnection(request);

	String diag_desc = "";
	try
	{
		if(sdesc.length() > 0) sdesc.delete(0,sdesc.length());

		 sdesc.append("select term_code_short_desc from pr_diagnosis_compl_enc_dtl a where a.facility_id='"+facility_id+"' and a.encounter_id='"+encounter_id+"' and a.term_set_id='"+term_set_id+"'  "); 
		
		//if(!term_code.equals("*OTH"))
			sdesc.append("and a.term_code = '"+term_code+"' ");
		//else
			sdesc.append("and a.occur_srl_no = '"+occur_srl_no+"' ");
			stmt   = con.createStatement();
			rs	   = stmt.executeQuery(sdesc.toString());
		while(rs.next()){
				diag_desc=rs.getString("term_code_short_desc");
		}
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();

	}
	catch(Exception e){
	}finally{
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(con!=null){
			ConnectionManager.returnConnection(con,request);
		}
 }

	if(callFunction.equals("showProblem"))
		Title				= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ChiefComplaint.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.for.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.diagnosis.label","common_labels")+" "+diag_desc;
	else
		Title				= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Select.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Problem.label","common_labels");
%>
<title><%=Title%></title>
<head>

<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<iframe name="selectProblemFrame" id="selectProblemFrame" src='../../eMR/jsp/selectProblem.jsp?<%=qrystr%>' frameborder=0 <%if(!callFunction.equals("showProblem")){%>scrolling="Yes" <%}%> noresize style='height:82vh;width:95vw'></iframe>
<iframe name="selectProblemButton" id="selectProblemButton" src='../../eMR/jsp/selectProblemButton.jsp?<%=qrystr%>' frameborder=0 scrolling="no" noresize style='height:8vh;width:95vw'></iframe>

</html>

