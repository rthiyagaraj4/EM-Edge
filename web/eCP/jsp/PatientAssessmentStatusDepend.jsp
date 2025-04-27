<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,java.util.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head> 
		<title><fmt:message key="eCP.IntermediateStatusDependency.label" bundle="${cp_labels}"/></title>
		<script src='../../eCP/js/PatientAssessment.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	</head>
	<body class='MESSAGE'>
		<form name='patAssessIntermediateForm' id='patAssessIntermediateForm' action=''>
		<%
			String accession_num = request.getParameter("accession_num") == null ? "" : request.getParameter("accession_num");
			out.println("accession_num = "+accession_num);
			String assess_ref_no = request.getParameter("assess_ref_no") == null ? "" : request.getParameter("assess_ref_no");
			String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
			String patient_class = request.getParameter("patient_class") == null ? "" : request.getParameter("patient_class");
			String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
			String note_type = request.getParameter("note_type") == null ? "" : request.getParameter("note_type");
			out.println("note_type = "+note_type);
			String note_desc = request.getParameter("note_desc") == null ? "" : request.getParameter("note_desc");
			String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
			out.println("mode = "+mode);
			String locn_type = request.getParameter("locn_type") == null ? "" : request.getParameter("locn_type");
			String locn_code = request.getParameter("locn_code") == null ? "" : request.getParameter("locn_code");
			String dob = request.getParameter("dob") == null ? "" : request.getParameter("dob");
			String age = request.getParameter("age") == null ? "" : request.getParameter("age");
			String sex = request.getParameter("sex") == null ? "" : request.getParameter("sex");
			String reln_id = request.getParameter("reln_id") == null ? "" : request.getParameter("reln_id");

			String facility_id = (String) session.getAttribute("facility_id");
			out.println("facility_id = "+facility_id);
			//out.println("facility_id+++"+facility_id);

			String assessStatus = "";
			String assessStatus_flag = "";
			String assessDependency = "";
			String abnormalCateg = "";
			String assessDepCode = "";
			String sqlStatus = "";
			
			Connection con = null;
			ResultSet resAssessCode = null;
			PreparedStatement pstAssessCode = null;
			CallableStatement cs = null;

			try
			{
				con = ConnectionManager.getConnection(request);
				
				sqlStatus = "select decode(event_status,'1','In Progress','2','Transcribed','3','Unauthorized','4','Authorized','5','Modified'),event_status from ca_encntr_note where FACILITY_ID=? and accession_num=? ";
				pstAssessCode = con.prepareStatement(sqlStatus);
				pstAssessCode.setString(1,facility_id);
				pstAssessCode.setString(2,accession_num);
			
				resAssessCode = pstAssessCode.executeQuery();
				while(resAssessCode.next())
				{
					assessStatus = resAssessCode.getString(1);
					assessStatus_flag = resAssessCode.getString(2);
				}

				if(resAssessCode != null) resAssessCode.close();
				if(pstAssessCode != null) pstAssessCode.close();

				resAssessCode = null;
				pstAssessCode = null;

				cs = con.prepareCall("{call CP_GET_ASSESS_OUTPUT(?,?,?,?,?)}" );
				
				cs.setString(1,accession_num);
				cs.setString(2,facility_id);
				cs.setString(3,note_type);
				cs.registerOutParameter(4,Types.VARCHAR);
				cs.registerOutParameter(5,Types.VARCHAR);
								
				cs.execute();				

				assessDepCode = cs.getString(4) == null ? "" : cs.getString(4);
				abnormalCateg = cs.getString(5) == null ? "" : cs.getString(5);	
				

			}//end of try
			catch(Exception e)
			{
				e.printStackTrace(System.err);
				System.out.println("Exception in try of PatientAssessmentStatusDepend.jsp "+e.toString());
			}
			finally
			{
				if(con!=null)
					ConnectionManager.returnConnection(con,request);
				if(resAssessCode != null) resAssessCode.close();
				if(pstAssessCode != null) pstAssessCode.close();
				if(cs != null) cs.close();
			}
			if(!mode.equals("modify"))
			{
		%>
			<script>												
				setTimeout("poulateStatus('<%=assessDepCode%>','<%=assessStatus%>','<%=assessDepCode%>','<%=assessDependency%>','<%=facility_id%>','<%=encounter_id%>','<%=abnormalCateg%>','<%=accession_num%>','<%=mode%>','<%=note_type%>','<%=assessStatus_flag%>')",600);
			</script>		
			<%
			}
			else if(mode.equals("modify"))
			{
				out.println("mode ="+mode);
				out.println("assessStatus ="+assessStatus+"=");
			%>
			<script>												
					
				setTimeout("poulateStatusForModify('<%=assessDepCode%>','<%=assessStatus%>','<%=encounter_id%>','<%=accession_num%>','<%=mode%>','<%=note_type%>','<%=patient_id%>','<%=note_desc%>','<%=locn_type%>','<%=locn_code%>','<%=dob%>','<%=age%>','<%=sex%>','<%=patient_class%>','<%=assess_ref_no%>','<%=reln_id%>','<%=note_type%>','<%=assessStatus_flag%>')",600);
			</script>		
			<%
			}
			%>
		</form>
	</body>
</html>

