<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.util.*,java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<title> <fmt:message key="eMR.SupportingDiagnosisCode.label" bundle="${mr_labels}"/></title>	
	<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../js/RecDiagnosis.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>	
<%
	Connection con = null;
	PreparedStatement stmt_supp = null;
	ResultSet rs_supp = null;
	
	StringBuffer strBuffer = new StringBuffer();
	String Patient_Id = request.getParameter("Patient_Id")==null?"":request.getParameter("Patient_Id");
	String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	String occur_srl_no = request.getParameter("occur_srl_no")==null?"":request.getParameter("occur_srl_no");
	String term_code = request.getParameter("term_code")==null?"":request.getParameter("term_code");
	
	String supp_term_code = "";
	String supp_term_desc = "";

%>
	<body onKeyDown='lockKey()'>
		<form>
		&nbsp;&nbsp;&nbsp;
		<table border='1' cellpadding='0' cellspacing='0' width="100%"  align=center>
		<tr>
		<th  align='center' width ="15%" ><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th  align='center'width ="85%" ><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></th>
		</tr>
		<%
			con = ConnectionManager.getConnection(request);

			String classval ="";
			int i= 0;
		try
		{
			if(strBuffer.length() > 0) strBuffer.delete(0,strBuffer.length());
/*
			strBuffer.append(" select a.supp_term_code ,b.short_desc from pr_support_diagnosis a , ");
			strBuffer.append(" mr_term_code b where b.term_code = a.supp_term_code and a.patient_id =? and ");
			strBuffer.append(" a.term_code = ? and b.term_set_id = ? and occur_srl_no=? and srl_no=");
			strBuffer.append("(select max(srl_no) from pr_support_diagnosis where patient_id=a.PATIENT_ID and "); 
			strBuffer.append("term_set_id=a.TERM_SET_ID and term_code=a.TERM_CODE and occur_srl_no=a.occur_srl_no) ");
*/

			/*
			strBuffer.append("  SELECT a.supp_term_code, b.short_desc FROM pr_support_diagnosis a, mr_term_code b WHERE b.term_code = a.supp_term_code AND a.patient_id = ? AND a.term_set_id = ? AND b.term_set_id = ? AND a.term_code = ? AND occur_srl_no = ? AND srl_no = (SELECT MAX (srl_no) FROM pr_support_diagnosis WHERE patient_id = a.patient_id AND term_set_id = a.term_set_id AND term_code = a.term_code AND occur_srl_no = a.occur_srl_no) ");

			*/
			/*Monday, February 22, 2010 , 19570 , CRF 303.2 coding UT since it is displaying only latest linked supporting diagnosis codes.*/
			strBuffer.append("  SELECT a.supp_term_code, b.short_desc FROM pr_support_diagnosis a, mr_term_code b WHERE b.term_code = a.supp_term_code AND a.patient_id = ? AND a.term_set_id = ? AND b.term_set_id = ? AND a.term_code = ? AND occur_srl_no = ? ");
				stmt_supp = con.prepareStatement(strBuffer.toString());
				stmt_supp.setString(1,Patient_Id);
				stmt_supp.setString(2,term_set_id);
				stmt_supp.setString(3,term_set_id);
				stmt_supp.setString(4,term_code);
				stmt_supp.setString(5,occur_srl_no);
				rs_supp = stmt_supp.executeQuery();

				while(rs_supp.next())
				{
					supp_term_code = rs_supp.getString(1);
					supp_term_desc = rs_supp.getString(2);
						
						if(i%2 == 0)
							classval = "QRYODD";
						else
							classval = "QRYEVEN";
						out.println("<tr>");
						out.println("<td class='"+classval+"' >"+supp_term_code+ "</td>");
						out.println("<td class='"+classval+"' >" +supp_term_desc+ "</td>");
						out.println("</tr>");
						i++;	
						
					
					}

					
			

				
				
				if(rs_supp!=null)		rs_supp.close();
				if(stmt_supp!=null)   	stmt_supp.close();

				
			

				}
				catch(Exception ex)
				{
					//out.println("Exception @ try block "+ex.toString());
					ex.printStackTrace();
				}
				finally
				{
					if(con != null)ConnectionManager.returnConnection(con,request);
				}
					%>	
		</table>	
		&nbsp;&nbsp;
		</form>
	</body>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

