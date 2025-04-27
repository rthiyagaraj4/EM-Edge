<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,java.util.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="diagBean" class="eCP.PatientAssessmentDiag" scope="session"/>
<html>
	<head>
		<title><fmt:message key="eCP.PatientAssessmentAddModify.label" bundle="${cp_labels}"/></title>
		<script src='../../eCP/js/PatientAssessment.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
//This file is saved on 19/11/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
</head>
	<body onmousedown = 'CodeArrest()'>
		<form name='patAssessmentAddModifyForm' id='patAssessmentAddModifyForm'>
	<%
		diagBean.clearDiagBean();	

//		String qry_string = request.getParameter("qry_string") == null ? "" : request.getParameter("qry_string");

//		System.out.println("QueryString = "+request.getQueryString());

		String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
		String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		String patient_class = request.getParameter("patient_class") == null ? "" : request.getParameter("patient_class");
		String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
//		System.out.println("encounter_id = "+encounter_id);
		String dob = request.getParameter("Dob") == null ? "" : request.getParameter("Dob");
		String age = request.getParameter("Age") == null ? "" : request.getParameter("Age");
		String sex = request.getParameter("Sex") == null ? "" : request.getParameter("Sex");
		String relationship_id = request.getParameter("relationship_id") == null ? "" : request.getParameter("relationship_id");
		String pract_id = (String) session.getAttribute("ca_practitioner_id");
		String note_signed = request.getParameter("note_signed") == null ? "" : request.getParameter("note_signed");
		String note_type = request.getParameter("note_type") == null? "" : request.getParameter("note_type");
		String acc_num = request.getParameter("acc_num") == null ? "" : request.getParameter("acc_num");
		String assess_ref_no=""; //= request.getParameter("assess_ref_no") == null ? "" : request.getParameter("assess_ref_no");
		String location_code = request.getParameter("location_code") == null ? "" : request.getParameter("location_code");
		String location_type = request.getParameter("location_type") == null ? "" : request.getParameter("location_type");
		String status = request.getParameter("status") == null ? "" : request.getParameter("status");
		String note_desc = request.getParameter("note_desc") == null ? "" : request.getParameter("note_desc");
		String assess_date = request.getParameter("assess_date") == null ? "" : request.getParameter("assess_date");
		String assess_time = request.getParameter("assess_time") == null ? "" : request.getParameter("assess_time");
		String flag = request.getParameter("flag") == null ? "" : request.getParameter("flag");
		String flag_on_mod = request.getParameter("flag_on_mod") == null ? "" : request.getParameter("flag_on_mod");
		String status_flag = request.getParameter("status_flag") == null ? "" : request.getParameter("status_flag");
		String function_from = request.getParameter("function_from") == null ? "" : request.getParameter("function_from");//IN030474
		String status_disp = "";

		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rset=null;

		try
		{
		conn = ConnectionManager.getConnection(request);		
		}
		catch(Exception e1)
		{
			System.out.println("Exception while creating connection"+e1);
		}

		/*out.println("locn_code="+location_code);
		out.println("location_type="+location_type);
		out.println("dob="+dob);
		out.println("age="+age);
		out.println("sex="+sex);*/

		if(status_flag.equals("4"))
		{
			status_disp = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.completed.label","common_labels");
		}
		else
		{
			status_disp = status;
		}

			String sql_assess="select CP_PAT_ASSESS_SEQ.nextval assess_ref_no from dual";

		if(mode.equals("modify"))
		{			
            assess_ref_no=request.getParameter("assess_ref_no") == null ? "" : request.getParameter("assess_ref_no");
			if(!status_flag.equals("4"))
			{
				if(!function_from.equals("VIEW_ASSESSMENT"))//IN030474
				{//IN030474
			%>
				<table width='100%' align='center' border=0 cellpadding='0' cellspacing=0>
					<tr>
						<td class='label' width='25%' align='right'><fmt:message key="eCP.AssessmentNote.label" bundle="${cp_labels}"/>&nbsp;</td>
						<td width='14%' align='left' class='data' id='noteDescAtMod' nowrap><%=note_desc%></td>
						<td width='25%' align='left'>&nbsp;&nbsp;<input type='button' class='button' Value='<fmt:message key="Common.Amend.label" bundle="${common_labels}"/>' name='assessbtn' onclick="showNotificationForm()" onfocus="hideAssessForModify('<%=status%>','<%=acc_num%>','<%=assess_ref_no%>','<%=note_type%>','<%=note_desc%>','<%=location_code%>','<%=location_type%>','<%=dob%>','<%=age%>','<%=sex%>','<%=status_flag%>')"></td>
						<td class='data' width='25%' align='right'><%=status_disp%></td>						
					</tr>
				</table>
			<%
				}
				else//IN030474 Starts
				{
				%>
					<table width='100%' align='center' border=0 cellpadding='10' cellspacing=0>
						<tr>
							<td class='label' width='25%' align='right'><fmt:message key="eCP.AssessmentNote.label" bundle="${cp_labels}"/></td>
							<td width='14%' align='left' id='noteDescAtMod' class='data'><%=note_desc%></td>
							<td width='25%' align='left'><input type='button' class='button' Value='<fmt:message key="Common.Amend.label" bundle="${common_labels}"/>' name='assessbtn' onclick="showNotificationForm()" onfocus="hideAssessForModify('<%=status%>','<%=acc_num%>','<%=assess_ref_no%>','<%=note_type%>','<%=note_desc%>','<%=status_flag%>')" style='display:none'></td>
							<td class='data' width='25%' align='right'><%=status_disp%></td>
						</tr>
					</table>
					<%
				}//IN030474 ends
			}
			else if(status_flag.equals("4"))
			{
				if(!flag.equals("modAuth"))
				{
					//con = ConnectionManager.getConnection(request);
					String sql_pract_name = "select PRACTITIONER_NAME from AM_PRACTITIONER_lang_vw where PRACTITIONER_ID = ? and language_id=?";
					String pract_name = "";
					PreparedStatement pstPractName = conn.prepareStatement(sql_pract_name);
					pstPractName.setString(1,pract_id);
					pstPractName.setString(2,locale);
					ResultSet resPractName = pstPractName.executeQuery();
					while(resPractName!=null && resPractName.next())
					{
						pract_name = resPractName.getString(1);
					}

					if(resPractName!=null) resPractName.close();
					if(pstPractName!=null) pstPractName.close();
					if(conn!=null) ConnectionManager.returnConnection(conn,request);

			%>
				<table width='100%' align='center' border=0 cellpadding='10' cellspacing=0>
					<!-- <tr>
						<td>&nbsp;</td>
					</tr> -->
					<tr>
						<td class='data' align='center'><fmt:message key="eCP.AssessmentDetailat.label" bundle="${cp_labels}"/> <%=com.ehis.util.DateUtils.convertDate(assess_date,"DMY","en",locale)%> <%=com.ehis.util.DateUtils.convertDate(assess_time,"HM","en",locale)%> By <%=pract_name%></td>
						<td class='data'><%=status_disp%></td>
					</tr>
					<!-- <tr>
						<td>&nbsp;</td>
					</tr> -->
				</table>
			<%
				}
				else if(flag.equals("modAuth"))
				{
				%>
					<table width='100%' align='center' border=0 cellpadding='10' cellspacing=0>
						<tr>
							<td class='label' width='25%' align='right'><fmt:message key="eCP.AssessmentNote.label" bundle="${cp_labels}"/></td>
							<td width='14%' align='left' id='noteDescAtMod' class='data'><%=note_desc%></td>
							<td width='25%' align='left'><input type='button' class='button' Value='<fmt:message key="Common.Amend.label" bundle="${common_labels}"/>' name='assessbtn' onclick="showNotificationForm()" onfocus="hideAssessForModify('<%=status%>','<%=acc_num%>','<%=assess_ref_no%>','<%=note_type%>','<%=note_desc%>','<%=status_flag%>')" style='display:none'></td>
							<td class='data' width='25%' align='right'><%=status_disp%></td>
						</tr>
					</table>
					<%
				}
			}
			%>
				<input type='hidden' name='status_at_mod' id='status_at_mod' value='<%=status%>'> 
				<input type='hidden' name='status_flag_at_mod' id='status_flag_at_mod' value='<%=status_flag%>'> 
				<input type='hidden' name='note_at_mod' id='note_at_mod' value='<%=note_type%>'> 
				<input type='hidden' name='note_desc_at_mod' id='note_desc_at_mod' value='<%=note_desc%>'> 
			<%
		}//end of mode modified..		
		else if(!mode.equals("modify"))
		{
			String assess_note = "";
			String assess_note_desc = "";
			String selectNote = "";

			try
			{
			pstmt=conn.prepareStatement(sql_assess);
			rset=pstmt.executeQuery();

			if(rset!=null)
			{
				while(rset.next())
				{
					assess_ref_no=rset.getString("assess_ref_no");
				}
			}
			if(rset!=null)
				rset.close();
			if(pstmt!=null)
				pstmt.close();
			}
			catch(Exception e1)
			{
				System.err.println("Exception while creating connection"+e1);
			}

			//Connection con = null;
			ResultSet resAssess = null;
			PreparedStatement pstAssess = null;	
		%>
			<table width='100%' align='center' border=0 cellpadding='10' cellspacing=0>
				<tr>
					<td class='label' width='25%' align='right'><fmt:message key="eCP.AssessmentNote.label" bundle="${cp_labels}"/></td>
					<td align='left' width='25%'>
						<select name='assessmentNote' id='assessmentNote' onchange='callNotificationForm(this);' onfocus='callPopStatus(this);'>
							<option value=''>------------------------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------------------------</option>
							<%
							try
							{
								String sql_assess_note =  "SELECT ASSESS_NOTE_ID,ASSESS_NOTE_DESC FROM cp_assess_note_lang_vw where EFF_STATUS = 'E' and language_id = ?";
								pstAssess = conn.prepareStatement(sql_assess_note);
								pstAssess.setString(1,locale);
								resAssess = pstAssess.executeQuery();
								while(resAssess.next())
								{
									assess_note = resAssess.getString(1);
									assess_note_desc = resAssess.getString(2);
									if(note_type.equals(assess_note))
									{
										selectNote = "selected";
									}
									else
									{
										selectNote = "";
									}
									if(flag_on_mod.equals("1"))
									{
										selectNote = "";
									}
									out.println("<option value="+assess_note+" "+selectNote+">");
									out.println(" "+assess_note_desc+" ");
									out.println("</option>");									
								}
							}
							catch(Exception e)
							{
								System.out.println("Exception in try of PatientAssessmentAddModify.jsp"+e.toString());
							}
							finally
							{
								if(conn!=null)
									ConnectionManager.returnConnection(conn,request);
								if(resAssess != null) resAssess.close();
								if(pstAssess != null) pstAssess.close();
							}
							%>
						</select><img src='../../eCommon/images/mandatory.gif'>
					</td>
					<td width='10%' align='right'><input type='button' class='button' Value='<fmt:message key="Common.Amend.label" bundle="${common_labels}"/>' name='assessbtn' style='display:none' onclick="callNotificationFormforframeSize()" onfocus='hideAssess()' id='btnID'></td>
					<td class='data' id='assessStatus' width='25%' align='center'></td>
					<td width='0%' id='assessStatus_flag' style='display:none'></td>
				</tr>
				</table>
		<%				
		}//end of mode insert
		%>
			<input type='hidden' name='pat_id' id='pat_id' value='<%=patient_id%>'>
			<input type='hidden' name='reln_id' id='reln_id' value='<%=relationship_id%>'>
			<input type='hidden' name='pat_class' id='pat_class' value='<%=patient_class%>'>
			<input type='hidden' name='enc_id' id='enc_id' value='<%=encounter_id%>'>
			<input type='hidden' name='dob' id='dob' value='<%=dob%>'>
			<input type='hidden' name='age' id='age' value='<%=age%>'>
			<input type='hidden' name='sex' id='sex' value='<%=sex%>'>
			<input type='hidden' name='accession_num' id='accession_num' value='<%=acc_num%>'>
			<input type='hidden' name='note_signed' id='note_signed' value='<%=note_signed%>'>
			<input type='hidden' name='code_set_hid' id='code_set_hid' value=''>
			<input type='hidden' name='chk_val_hid' id='chk_val_hid' value=''>
			<input type='hidden' name='count' id='count' value=''>
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
			<input type='hidden' name='status' id='status' value=''>
			<input type='hidden' name='status_flag' id='status_flag' value=''>
			<input type='hidden' name='abnormal_categ' id='abnormal_categ' value=''>
			<input type='hidden' name='practitioner_id' id='practitioner_id' value='<%=pract_id%>'>
			<input type='hidden' name='locn_type' id='locn_type' value='<%=location_type%>'>
			<input type='hidden' name='locn_code' id='locn_code' value='<%=location_code%>'>
			<input type='hidden' name='qry_string' id='qry_string' value='<%=request.getQueryString()%>'>
			<input type='hidden' name='assess_ref_no' id='assess_ref_no' value='<%=assess_ref_no%>'>
			<input type='hidden' name='assessDependency' id='assessDependency' value=''>
			<input type='hidden' name='dependency_ss' id='dependency_ss' value=''>
		</form>
	</body>
</html>

