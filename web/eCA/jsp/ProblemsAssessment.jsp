<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*, java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
 <%
	request.setCharacterEncoding("UTF-8");
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src='../../eCA/js/PatProblem.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	Connection conn= null;
	PreparedStatement stmt		=null;
	PreparedStatement stmt_1		=null;
	ResultSet rs		=null;
	ResultSet rs_1		=null;
	PreparedStatement pstmt = null;
	ResultSet rs1 	= null;
	HashMap hmap = new HashMap();
	int remarksCount = 0;
	try
	{
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		conn = ConnectionManager.getConnection(request);
		StringBuffer strBuff_pr_problem_assessment = new StringBuffer();
		String srl_no       = request.getParameter("srl_no");
		String onset_date="";
		String onset_practitioner_name="";
		String onset_facility_name="";
		String onset_locn_desc="";
		String onset_recorded_date="";
		String close_date="";
		String close_practitioner_name="";
		String close_facility_name="";
		String close_locn_desc="";
		String close_recorded_date="";
		//String pr_problem_assessment="";
		String pr_problem_assessment_remarks="";
		String onset_facility_id = "";
		String onset_encounter_id = "";
		String close_facility_id = "";
		String close_encounter_id = "";
		String onset_service = "";
		String close_service = "";
		String recorded_by  = "";
		String closed_by   = "";
		String patientid=request.getParameter("Patient_Id");

		if (!(srl_no ==null))
		{
			try
			{
				StringBuffer strBuff_sql = new StringBuffer();
				//strBuff_sql.append("Select to_char(onset_date,'dd/mm/yyyy') onset_date,onset_practitioner_name,onset_facility_name, onset_locn_desc,to_char(onset_recorded_date,'dd/mm/yyyy') onset_recorded_date,to_char(close_date,'dd/mm/yyyy') close_date,close_practitioner_name,close_facility_name,close_locn_desc,to_char(close_recorded_date ,'dd/mm/yyyy') close_recorded_date,onset_facility_id, onset_encounter_id,close_facility_id, close_encounter_id,recorded_by,closed_by from pr_problem_vw where patient_id=? and srl_no=?");

				
				strBuff_sql.append("Select to_char(onset_date,'dd/mm/yyyy') onset_date,AM_GET_DESC.AM_PRACTITIONER(onset_practitioner_id,?,'1')  onset_practitioner_name,SM_GET_DESC.SM_FACILITY_PARAM(onset_facility_id,?,'1')onset_facility_name,nvl(OP_GET_DESC.OP_CLINIC(ONSET_FACILITY_ID,ONSET_LOCN_CODE,?,'1'),IP_GET_DESC.IP_NURSING_UNIT(ONSET_FACILITY_ID,ONSET_LOCN_CODE,?,'1') ) onset_locn_desc,to_char(onset_recorded_date,'dd/mm/yyyy') onset_recorded_date,to_char(close_date,'dd/mm/yyyy') close_date,AM_GET_DESC.AM_PRACTITIONER(CLOSE_PRACTITIONER_ID,?,'1') close_practitioner_name,SM_GET_DESC.SM_FACILITY_PARAM(close_facility_id,?,'1')close_facility_name,nvl(OP_GET_DESC.OP_CLINIC(CLOSE_FACILITY_ID,CLOSE_LOCN_CODE,?,'1'),IP_GET_DESC.IP_NURSING_UNIT(CLOSE_FACILITY_ID,CLOSE_LOCN_CODE,?,'1') ) close_locn_desc,to_char(close_recorded_date ,'dd/mm/yyyy') close_recorded_date,onset_facility_id,onset_encounter_id,close_facility_id,close_encounter_id,recorded_by,closed_by from pr_problem_vw where patient_id=? and srl_no=?");

				

				String StrSql1="Select log_text log_text , problem_remarks from pr_problem_assessment where patient_id=? and srl_no=?";

				stmt = conn.prepareStatement(strBuff_sql.toString());
				//stmt = conn.prepareStatement(StrSql);
				stmt.setString(1,locale);
				stmt.setString(2,locale);
				stmt.setString(3,locale);
				stmt.setString(4,locale);
				stmt.setString(5,locale);
				stmt.setString(6,locale);
				stmt.setString(7,locale);
				stmt.setString(8,locale);
				stmt.setString(9,patientid);
				stmt.setString(10,srl_no);
				rs = stmt.executeQuery();

				while(rs.next())
				{
					onset_date=rs.getString("onset_date");
					onset_practitioner_name= rs.getString("onset_practitioner_name");
					onset_facility_name=rs.getString("onset_facility_name");
					onset_locn_desc=rs.getString("onset_locn_desc");
					onset_recorded_date=rs.getString("onset_recorded_date");
					close_date=rs.getString("close_date");
					close_practitioner_name=rs.getString("close_practitioner_name");
					close_facility_name=rs.getString("close_facility_name");
					close_locn_desc=rs.getString("close_locn_desc");
					close_recorded_date=rs.getString("close_recorded_date");
					onset_facility_id = rs.getString("onset_facility_id");
					onset_encounter_id = rs.getString("onset_encounter_id");
					close_facility_id = rs.getString("close_facility_id");
					close_encounter_id = rs.getString("close_encounter_id");
					recorded_by = rs.getString("recorded_by");
					closed_by = rs.getString("closed_By") ;

				}
					
					if(rs!=null) rs.close();
					
					//out.println(onset_date);
				stmt_1 = conn.prepareStatement(StrSql1);
				stmt_1.setString(1,patientid);
				stmt_1.setString(2,srl_no);
				rs_1 = stmt_1.executeQuery();
				while(rs_1.next())
				{
					strBuff_pr_problem_assessment.append(rs_1.getString("log_text"));
					strBuff_pr_problem_assessment.append("<br>");
					pr_problem_assessment_remarks   = rs_1.getString("problem_remarks");

					if(pr_problem_assessment_remarks == null)pr_problem_assessment_remarks ="";
					if(!pr_problem_assessment_remarks.equals("")){

						hmap.put("rmk"+remarksCount++, pr_problem_assessment_remarks);
					}
				}
					if(rs_1!=null) rs_1.close();
					if(stmt_1!=null) stmt_1.close();
				//Added newly
				//pstmt = conn.prepareStatement("select b.short_desc from pr_encounter a, am_service b where a.facility_id = ? and a.encounter_id = ? and b.service_code = a.service_code");

				pstmt = conn.prepareStatement("select AM_GET_DESC.AM_SERVICE(a.service_code,?,'2') short_desc from pr_encounter a where a.facility_id = ? and a.encounter_id = ? ");
				pstmt.setString(1,locale);
				pstmt.setString(2,onset_facility_id);
				pstmt.setString(3,onset_encounter_id);
				rs1 = pstmt.executeQuery();
				while(rs1!=null && rs1.next())
				{
				  onset_service = rs1.getString(1);
				}

				if(rs1!=null) rs1.close();
				pstmt.setString(1,close_facility_id);
				pstmt.setString(2,close_encounter_id);
				rs1 = pstmt.executeQuery();
				while(rs1!=null && rs1.next())
				{
				  close_service = rs1.getString(1);
				}
			}
			catch (Exception e)
			{
				//out.println("HERE AFTER :"+e);//common-icn-0181
				e.printStackTrace();//COMMON-ICN-0181		
			}			
			if	(onset_date== null)
					onset_date="&nbsp";
			if	(onset_practitioner_name== null)
					onset_practitioner_name ="&nbsp";
			if 	(onset_facility_name== null)
					onset_facility_name="&nbsp";
			if 	(onset_locn_desc== null)
					onset_locn_desc="&nbsp";
			if 	(onset_recorded_date== null)
					onset_recorded_date="&nbsp";
			if 	(close_date== null)
					close_date="&nbsp";
			if 	(close_practitioner_name== null)
					close_practitioner_name="&nbsp";
			if 	(close_facility_name== null)
					close_facility_name="&nbsp";
			if	(close_locn_desc== null)
					close_locn_desc="&nbsp";
			if 	(close_recorded_date== null)
					close_recorded_date="&nbsp";
			/*if 	(pr_problem_assessment== null)
					pr_problem_assessment="&nbsp";*/
			if(strBuff_pr_problem_assessment.length() == 0)
			{
				strBuff_pr_problem_assessment.append("&nbsp");
			}

			if(pr_problem_assessment_remarks == null)
				pr_problem_assessment_remarks = "&nbsp";

			if(onset_service ==null)
				   onset_service="&nbsp;";
			if(close_service ==null)
				   close_service="&nbsp;";
			if(recorded_by ==null)
				   recorded_by="&nbsp;";
			if(closed_by ==null)
				   closed_by="&nbsp;";
/*
			if(!onset_date.equals("&nbsp;"))
				onset_date			= com.ehis.util.DateUtils.convertDate(onset_date,"DMY","en",locale);
		
			if(!onset_recorded_date.equals("&nbsp;"))
				onset_recorded_date	= com.ehis.util.DateUtils.convertDate(onset_recorded_date,"DMY","en",locale);
			
			if(!close_date.equals("&nbsp;"))
				close_date			= com.ehis.util.DateUtils.convertDate(close_date,"DMY","en",locale);
			
			if(!close_recorded_date.equals("&nbsp;"))
				close_recorded_date	= com.ehis.util.DateUtils.convertDate(close_recorded_date,"DMY","en",locale);

				

*/		}%>
			<table width='100%' height='100%' align=center cellpadding='3' cellspacing='0' border='0'>
				<!-- <th colspan=2 align=left height=10%>Close Details</th> -->
			
			<td class='columnHeader' align=left height="7%" ><fmt:message key="Common.Assessment.label" bundle="${common_labels}"/></td>
			<td class='columnHeader' align='left' height='7%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<tr>
			<td>
				<table width='100%' cellpadding=3 height='100%' border='0'>
				&nbsp;&nbsp;
				<tr>
				<td width='100%' valign="top"><font size='1' color="BLACK"><%=strBuff_pr_problem_assessment.toString()%></font></td>
				</tr>
				</table>
			</td>
			<td>
			<table width='100%' height='100%' border='0'>
			&nbsp;&nbsp;
			<tr>
			<td width='100%' valign="top"><font size='1' color="BLACK">
			<%
			//=pr_problem_assessment_remarks
			String disp_rmks = "", prev_disp_rmks="";
			StringBuffer concatRmks = new StringBuffer();
			for(int i=0; i<hmap.size(); i++)
			{
				disp_rmks = (String)hmap.get("rmk"+i);

				if(!prev_disp_rmks.equalsIgnoreCase(disp_rmks))
				{
					if(!disp_rmks.equals(""))
					{
						if(disp_rmks.length() > 20)
						{
							concatRmks.append(disp_rmks.substring(0,15));
							concatRmks.append("...<br>");
							disp_rmks = disp_rmks.replace('\n','`');
							disp_rmks = disp_rmks.replace('\'','~');
							out.println("<a href=\"javascript:showLongDesc('"+disp_rmks+"')\">"+concatRmks.toString()+"</a>");

						}
						else
						{
							out.println(disp_rmks+"<br>");
						}
					}
				}
				else
				{
					out.println("&nbsp;"+"<br>");
				}
				prev_disp_rmks = disp_rmks;
			}%>
			</font></td>
			</tr>
			<!-- <tr><td>&nbsp;</td><tr><tr><td>&nbsp;</td><tr><tr><td>&nbsp;</td><tr> -->
			</table>
			</td>

			</tr>
			</table>

			<!-- Assessments ends -->
			</td>
			</tr>
			</table>

			</body>
			</html>
		<%
			
			if(stmt!=null) stmt.close();
			
			
			if(rs1!=null) rs1.close();
			if(pstmt!=null) pstmt.close();	
			}
		catch(Exception e)
		{
			//out.println(e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally 
		{
			hmap.clear();
			if(conn!=null) ConnectionManager.returnConnection(conn,request);
		}%>

