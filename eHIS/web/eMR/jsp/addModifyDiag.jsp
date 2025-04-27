<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<!--
	Developed by 	:	Kumar
	Created on 	:	29/11/2001
	Module		:	mr
-->
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page contentType="text/html;charset=UTF-8" import= "java.util.*,java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eMR/js/CreatePatientFile.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	
</head>
<body onKeyDown = 'lockKey()'>
	<center>
		<form name='DiagDtl_form' id='DiagDtl_form'>
<%! 
	ArrayList arrDiagCode		=	new ArrayList();
	ArrayList arrDiagType		=	new ArrayList();
	ArrayList arrDiagDesc		=	new ArrayList();
	ArrayList arrRecordType		=	new ArrayList();
	ArrayList arrCauseIndicator	=	new ArrayList();
	ArrayList arrRemarks		=	new ArrayList();
	ArrayList arrAddItem		=	new ArrayList();
	ArrayList arrChkItem		=	new ArrayList();
	ArrayList arrUpdProb		=	new ArrayList();
%>

	<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		Connection con=null;
		Statement stmt	= null;

		try{
		con=ConnectionManager.getConnection(request);
		ResultSet rset		= null;
		String facilityId		= (String)session.getValue("facility_id");


		String sql		= "";
		String diag_code_scheme = "";

		String eid = request.getParameter("encounter_id");
		String call_from = request.getParameter("call_from");
		if (call_from==null) call_from="";
		long encounterid = Long.parseLong(eid);
		String class_val = "QRYEVENSMALL";
		String record_type ="";
		String diag_code ="";
		String diag_type ="";
		String diag_desc ="";
		String add_item = "",rowCount = "";
		String cause_indicator ="", mode = "";
		String remarks	= "";
		String check_item ="";
		String cur_death_date_time = "death_date_time";
		String cur_practid ="practid";
		String cur_remarks ="remarks";
		String cur_death_by_pregnancy_yn ="death_by_pregnancy_yn";
		String cur_autopsy_yn ="autopsy_yn";		
		String cur_medical_legal_case_yn ="medical_legal_case_yn";
		String cur_finalize_yn ="N";
		String update_problem = "";
		String checkBoxProp = "";
		String dfltChkProp = "";
		

		int cnt =0,i=0,row_count = 0, totalRecords=0;
		boolean error_flag = false;
		
			mode = request.getParameter("mode");
			if(mode==null) mode = "";
			rowCount = request.getParameter("row_count");
			if(rowCount==null) rowCount = "0";
			row_count = Integer.parseInt(rowCount);
			
			/*out.println(" <table cellspacing=0 cellpadding=0 align='center' width='100%' border='1' cellpadding=0 cellspacing=0>");
			out.println("<tr><td colspan=2 class="COLUMNHEADER"><fmt:message key='Common.DiagnosisDetails.label' bundle='${common_labels}'/></td>");
			out.println("<td class="COLUMNHEADER">Cause of Death</td>");		
			out.println("<td class="COLUMNHEADER">Add to Problem List</td></tr>");
			*/
			%>
			<table cellspacing=0 cellpadding=0 align='center' width='100%' border='1' cellpadding=0 cellspacing=0>
			<tr><td colspan=2 class="COLUMNHEADER"><fmt:message key='Common.DiagnosisDetails.label' bundle='${common_labels}'/></td>
			<td class="COLUMNHEADER"><fmt:message key="Common.CauseofDeath.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER"><fmt:message key="eMR.AddtoProblemList.label" bundle="${mr_labels}"/></td></tr>
			
			<%
			if(rset!=null) 	rset.close();
			if(stmt!=null) 	stmt.close();

			stmt = con.createStatement();
			rset = stmt.executeQuery("select diag_code_scheme from mr_parameter");
			if(rset != null)
			{
				rset.next();
				diag_code_scheme = rset.getString(1);
			}
			if (diag_code_scheme==null) diag_code_scheme="";


			if(rset!=null) 	rset.close();
			if(stmt!=null) 	stmt.close();

			if(mode.equals(""))
			{
				sql = "select count(*) from mr_death_Register_diag_dtl where encounter_id = "+encounterid+" and facility_id = '"+facilityId+"'";

				stmt = con.createStatement();
				rset	 =	 stmt.executeQuery(sql);		
				int dtlcnt = 0;
				if(rset != null)
				{
				rset.next();
				dtlcnt = rset.getInt(1);
				}
	
			if(rset!=null) 	rset.close();
			if(stmt!=null) 	stmt.close();

			stmt = con.createStatement();

				if (dtlcnt==0) 					
					sql = "select b.diag_code_scheme, srl_no, '1' num1, b.diag_code, b.record_type, nvl2(b.cause_indicator,'/' || b.cause_indicator,null) cause_indicator,a.short_desc diag_desc, update_problem_yn, 'Y' chkitem, problem_remarks, diag_type from mr_death_register_diag_dtl b, mr_icd_code a where a.diag_code= b.diag_code and  b.encounter_id = "+encounterid+" and b.facility_id = '"+facilityId+"' and (b.diag_code_scheme='1' or (b.diag_code_scheme = '2' and a.record_type = 'D' and	nvl(a.cause_indicator,'E') = 'E')) union select a.diag_code_scheme, 0 srlno, '2' num1, a.diag_code, a.record_type, nvl2(a.cause_indicator,'/' || a.cause_indicator,null) cause_indicator,diag_desc, 'X' update_problem_yn, 'N' chkitem, problem_remarks, diag_type  from pr_problem a where 	a.onset_encounter_id = "+encounterid+" and	a.onset_facility_id = '"+facilityId+"' order by num1, srl_no";
				else
					sql = "select b.diag_code_scheme, srl_no, '1' num1, b.diag_code, b.record_type, nvl2(b.cause_indicator,'/' || b.cause_indicator,null) cause_indicator,a.short_desc diag_desc, update_problem_yn, 'Y' chkitem, problem_remarks, diag_type from mr_death_register_diag_dtl b, mr_icd_code a where a.diag_code= b.diag_code and  b.encounter_id = "+encounterid+" and b.facility_id = '"+facilityId+"' and (b.diag_code_scheme='1' or (b.diag_code_scheme = '2' and a.record_type = 'D' and	nvl(a.cause_indicator,'E') = 'E')) union select a.diag_code_scheme, 0 srl_no, '2' num1, a.diag_code, a.record_type, nvl2(a.cause_indicator,'/' || a.cause_indicator,null) cause_indicator,diag_desc, 'X' update_problem_yn, 'N' chkitem, problem_remarks, diag_type from pr_problem a where 	a.onset_encounter_id = "+encounterid+" and	a.onset_facility_id = '"+facilityId+"' and a.diag_code not in (select diag_code from mr_death_register_diag_dtl where encounter_id = "+encounterid+" and facility_id = '"+facilityId+"') order by num1, srl_no";
			if(rset!=null) 	rset.close();
			if(stmt!=null) 	stmt.close();

				stmt = con.createStatement();
				rset	 =	 stmt.executeQuery(sql);				
				arrAddItem.clear();
				arrDiagCode.clear();
				arrDiagType.clear();
				arrDiagDesc.clear();
				arrRecordType.clear();
				arrCauseIndicator.clear();
				arrRemarks.clear();
				arrChkItem.clear();
				arrUpdProb.clear();
				if(rset != null)
				{
					while(rset.next())
					{									
					diag_code = "";
					diag_type = "";
					diag_desc = "";
					record_type = "";
					cause_indicator = "";
					check_item = "";
					remarks = "";

					diag_code = rset.getString("diag_code") == null ? "" : rset.getString("diag_code");
					diag_type = rset.getString("diag_type") == null ? "" : rset.getString("diag_type");
					record_type = rset.getString("record_type") == null ? "" : rset.getString("record_type");
					cause_indicator	= rset.getString("cause_indicator") == null ? "" : 	rset.getString("cause_indicator"); 
					remarks	= rset.getString("problem_remarks") == null ? "" : 	rset.getString("problem_remarks"); 
					diag_desc = rset.getString("diag_desc") == null ? "" : rset.getString("diag_desc"); 
					check_item = rset.getString("chkitem") == null ? "" : rset.getString("chkitem");
					update_problem = rset.getString("update_problem_yn") == null ? "" : rset.getString("update_problem_yn");
					

					add_item = "N";
					arrAddItem.add(add_item);
					arrDiagCode.add(diag_code);
					arrDiagType.add(diag_type);
					arrDiagDesc.add(diag_desc);
					arrRecordType.add(record_type);
					arrCauseIndicator.add(cause_indicator);
					arrRemarks.add(remarks);
					arrChkItem.add(check_item);
					arrUpdProb.add(update_problem);
					cnt++;
					} // end of while
				}
			if(rset!=null) 	rset.close();
			if(stmt!=null) 	stmt.close();

				sql = "select count(*) from mr_death_register_diag_dtl b where encounter_id = "+encounterid+" and b.facility_id = '"+facilityId+"'";
				stmt = con.createStatement();
				rset	 =	 stmt.executeQuery(sql);
				if(rset != null)
				{
					rset.next();
					totalRecords = rset.getInt(1);
				}
				if(rset!=null) 	rset.close();
				if(stmt!=null) 	stmt.close();

				//totalRecords = arrAddItem.size();
			} // end of mode empty - modify

			
			if(mode.equals("Add")||mode.equals("Modify"))
			{
				arrAddItem.clear();
				arrDiagCode.clear();
				arrDiagType.clear();
				arrDiagDesc.clear();
				arrRecordType.clear();
				arrCauseIndicator.clear();
				arrRemarks.clear();
				arrChkItem.clear();
				arrUpdProb.clear();

				cur_death_date_time = request.getParameter(cur_death_date_time);
				cur_practid = request.getParameter(cur_practid);
				cur_remarks = request.getParameter(cur_remarks);
				cur_death_by_pregnancy_yn = request.getParameter(cur_death_by_pregnancy_yn);
				cur_autopsy_yn = request.getParameter(cur_autopsy_yn);
				cur_medical_legal_case_yn = request.getParameter(cur_medical_legal_case_yn);

				String curr_diag_code = "diag_code"+(row_count-1);
				String totalRec = request.getParameter("totalRecords");
				if(totalRec==null) totalRec = "0";
				totalRecords = Integer.parseInt(totalRec);

				curr_diag_code = request.getParameter(curr_diag_code);
				for(i=0;i<row_count;i++)
				{
					add_item = "add_item"+i;
					diag_code = "diag_code"+i;
					diag_type = "diag_type"+i;
					diag_desc = "diag_desc"+i;
					record_type = "record_type"+i;
					cause_indicator = "cause_indicator"+i;
					remarks = "remarks"+i;
					check_item = "check_item"+i;
					update_problem = "update_problem"+i;
				
					add_item = request.getParameter(add_item);					
					diag_code = request.getParameter(diag_code);
					diag_type = request.getParameter(diag_type);
					diag_desc = request.getParameter(diag_desc);
					record_type = request.getParameter(record_type);
					cause_indicator = request.getParameter(cause_indicator);
					remarks = request.getParameter(remarks);
					check_item = request.getParameter(check_item);
					update_problem = request.getParameter(update_problem);

					if(add_item==null) add_item = "N";
					if(diag_code==null) diag_code = "";
					if(diag_type==null) diag_type = "";	
					if(diag_desc==null) diag_desc = "";
					if(record_type==null) record_type = "";
					if(cause_indicator==null) cause_indicator = "";
					if(remarks==null) remarks = "";
					if(check_item==null) check_item = "";
					if(update_problem==null) update_problem = "N";
					
					boolean valid_data = true;
					if (mode.equals("Add")) 
					{
						if(i!=(row_count-1))
						{
							if(diag_code.equals(curr_diag_code))
							{
								valid_data = false;
								error_flag = true;
							}
						}
					}
					if(valid_data)
					{
						arrAddItem.add(add_item);
						arrDiagCode.add(diag_code);
						arrDiagType.add(diag_type);
						arrDiagDesc.add(diag_desc);
						arrRecordType.add(record_type);
						arrCauseIndicator.add(cause_indicator);
						arrRemarks.add(remarks);
						arrChkItem.add(check_item);
						arrUpdProb.add(update_problem);
					}
				} // end of row_count
			} // end of mode

			if(error_flag)
			{
				out.println("<script>alert('RECORD_EXISTS','SM');parent.frames[0].document.forms[0].diag_code.select();parent.frames[0].document.forms[0].diag_code.focus();</script>");
			}
			else
			{
				if(!(mode.equals("")))
					out.println("<script>parent.frames[0].document.forms[0].reset();</script>");			
			}
			for(i=0;i<arrAddItem.size();i++)
			{
				add_item		= (String) arrAddItem.get(i);
				diag_code		= (String) arrDiagCode.get(i);
				diag_type		= (String) arrDiagType.get(i);
				diag_desc		= (String) arrDiagDesc.get(i);
				record_type		= (String) arrRecordType.get(i);
				cause_indicator = (String) arrCauseIndicator.get(i);
				remarks			= (String) arrRemarks.get(i);
				check_item		= (String) arrChkItem.get(i);
				update_problem  = (String) arrUpdProb.get(i);
				
				if(class_val.equals("QRYEVENSMALL"))
					class_val = "QRYODDSMALL";
				else
					class_val = "QRYEVENSMALL";


				if (update_problem.equals("N")||update_problem.equals("Y"))
				{
					out.print("<tr><td class='"+class_val+"' ><a href=\"javascript:showDetail("+i+")\">"+diag_code+cause_indicator+"</a></td>");
				}
				else
				{
					out.print("<tr><td class='"+class_val+"' >"+diag_code+""+cause_indicator+"</td>");
				}

				out.print("<td class='"+class_val+"' >"+diag_desc+"</td>");
				out.println("<td class='"+class_val+"' align='center'>");				

				
				dfltChkProp = "";

				if (check_item.equals("Y") ||
				   (check_item.equals("") && (mode.equals("Add")||mode.equals("Modify"))))
					dfltChkProp = " checked ";
				
				if (check_item.equals("N")) 
					out.println("<INPUT TYPE='checkbox' value='Y' "+dfltChkProp+" name='add_item"+i+"' id='add_item"+i+"'>");
				else					
					out.println("<INPUT TYPE='checkbox' "+dfltChkProp+" value='Y' name='add_item"+i+"' id='add_item"+i+"'>");

				out.println("</td>");				

				checkBoxProp = "";

				if (update_problem.equals("N")||update_problem.equals("Y"))
				{
					if (update_problem.equals("Y")) {  checkBoxProp = "checked"; } 

					out.println("<td class='"+class_val+"' align='center'>");
					out.println("<INPUT TYPE='checkbox' value='Y' "+checkBoxProp+" name='update_problem"+i+"' id='update_problem"+i+"'>");					
				}
				else 
				{
					out.println("<td class='"+class_val+"' align='center'><input type='hidden' name = 'update_problem"+i+"' checked value = '"+update_problem+"'>");
				}
				
				out.println("<input type='hidden' name = 'diag_code"+i+"' value = '"+diag_code+"'>");
				out.println("<input type='hidden' name = 'diag_type"+i+"' value = '"+diag_type+"'>");
				out.println("<input type='hidden' name = 'diag_desc"+i+"' value = '"+diag_desc+"'>");
				out.println("<input type='hidden' name = 'record_type"+i+"' value = '"+record_type+"'>");
				out.println("<input type='hidden' name = 'check_item"+i+"' value = '"+check_item+"'>");
				out.println("<input type='hidden' name = 'cause_indicator"+i+"' value = '"+cause_indicator+"'>");
				out.println("<input type='hidden' name = 'remarks"+i+"' value = '"+remarks+"'>");
				out.println("</td>");
			} // end of for

			out.println("</table>");
			
			out.println("<input type='hidden' name = 'diag_code"+i+"' value = '"+diag_code+"'>");
			out.println("<input type='hidden' name = 'diag_type"+i+"' value = '"+diag_type+"'>");
			out.println("<input type='hidden' name = 'diag_desc"+i+"' value = '"+diag_desc+"'>");
			out.println("<input type='hidden' name = 'record_type"+i+"' value = '"+record_type+"'>");
			out.println("<input type='hidden' name = 'cause_indicator"+i+"' value = '"+cause_indicator+"'>");
			out.println("<input type='hidden' name = 'remarks"+i+"' value = '"+remarks+"'>");
			out.println("<input type='hidden' name='update_problem"+i+"' id='update_problem"+i+"' value='"+update_problem+"'>");
			out.println("<input type='hidden' name = 'row_count' value = '"+(i+1)+"'>");
			out.println("<input type='hidden' name = 'mode' value = 'Add'>");
			out.println("<input type='hidden' name = 'totalRecords' value = '"+totalRecords+"'>");			
		
	%>
		<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounterid%>">
		<input type='hidden' name='death_date_time' id='death_date_time' value= "<%=cur_death_date_time%>">
		<input type='hidden' name='practid' id='practid' value="<%=cur_practid%>">
		<input type='hidden' name='remarks' id='remarks' value="<%=cur_remarks%>">
		<input type='hidden' name='death_by_pregnancy_yn' id='death_by_pregnancy_yn' value = "<%=cur_death_by_pregnancy_yn%>">
		<input type='hidden' name='autopsy_yn' id='autopsy_yn' value="<%=cur_autopsy_yn%>">		
		<input type='hidden' name='medical_legal_case_yn' id='medical_legal_case_yn' value="<%=cur_medical_legal_case_yn%>">		
		<input type='hidden' name='finalize_yn' id='finalize_yn' value="<%=cur_finalize_yn%>">		
		<input type='hidden' name='diag_code_scheme' id='diag_code_scheme' value="<%=diag_code_scheme%>">
		<input type='hidden' name='call_from' id='call_from' value="<%=call_from%>">
		</form>
	</center>
	</body>
<%
} //end of try
		catch(Exception e) {
			//out.println(e);
			e.printStackTrace();
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
%>
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

