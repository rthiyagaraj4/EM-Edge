<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@page  import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String locale			= (String)session.getAttribute("LOCALE");
	 	 //This file is saved on 18/10/2005.
	String facility_id = (String)session.getAttribute("facility_id");
	String mode	   = request.getParameter("mode") ;
%>

<html>
<head>
<!-- <link rel='stylesheet' type='text/css' href ='../../eCommon/html/IeStyle.css'> </link> -->
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src="../js/AssessmentNote.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
  <form name="form_add_mod" id="form_add_mod" method='POST' action='../../servlet/eCP.AssessmentNoteServlet' target='messageFrame'>
	<br><br><br><br> <br><br><br><br> 
	<% if (mode.equals("1")){%>
	<table border="0" cellpadding="0" cellspacing="0" width="80%" align='center'>
		<tr><TD colspan="2">&nbsp;</TD>
		</tr>
		<tr><TD colspan="2">&nbsp;</TD>
		</tr>
		<tr>
	  		<td align='right' class='label'><fmt:message key="Common.note.label" bundle="${common_labels}"/></td>
			<td align='left' class=label id=td5 >&nbsp;&nbsp;<input type=text name="assess_note_desc" id="assess_note_desc" value=""  readonly size='4' maxlength='2' ><input class='button' type=button name="assess_note_button" id="assess_note_button" value="?"  onClick='viewAgeGroup(assess_note_desc);display(note_desc1,inpatient);' >&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
					<input type="hidden" name="assess_note_id" id="assess_note_id" value="" >	
					<input type="hidden" name="assess_desc" id="assess_desc" value="" >		
					<input type="hidden" name="note_desc" id="note_desc" value="" >	
					<input type="hidden" name="inpatient1" id="inpatient1" value="">
					<input type="hidden" name="outpatient1" id="outpatient1" value="" >	
					<input type="hidden" name="daycare1" id="daycare1" value="">
					<input type="hidden" name="emergency1" id="emergency1" value="" >
					<input type="hidden" name="locale" id="locale" value="<%=locale%>" >
		</tr>
		<tr>
		<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			 <td width="15%"  align=right class='label'><fmt:message key="Common.NoteDescription.label" bundle="${common_labels}"/></td>
			 <td id='note_desc1' align='left' class="DATA">&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr>
		<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td width="15%"  align=right class='label'><fmt:message key="eCP.PatientClassApplicable.label" bundle="${cp_labels}"/></td>
			<td id='inpatient' align='left'  class="DATA">&nbsp;</td>
		</tr>
		<tr>
		<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td width="15%" align="right" class="label">&nbsp;<fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td align='left'  >&nbsp;&nbsp;<input type=checkbox name="eff_status" id="eff_status" checked value='E' onclick="checkActive(this)"></td>
		</tr>
		<tr>
		<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
		<td colspan="2">&nbsp;</td>
		</tr>
	</table>
	
	<%}
	else{
		String assess_note_id=request.getParameter("assess_note_id")==null ? "":request.getParameter("assess_note_id");
		String assess_note_desc=request.getParameter("assess_note_desc")==null ? "":request.getParameter("assess_note_desc");
		//String reassess_intervention_code=request.getParameter("reassess_intervention_code")==null ? "":request.getParameter("reassess_intervention_code");
		String Enabled=request.getParameter("Enabled")==null ? "":request.getParameter("Enabled");
		//String reassess_intervention_desc=request.getParameter("short_desc")==null ? "":request.getParameter("short_desc");
		
		Connection conn = null;
		conn=ConnectionManager.getConnection(request);

		PreparedStatement pstmt1=null;
		ResultSet rs1=null;
		String[] record1=null;
		String assess_note_desc1="";
		String inpatient="";
		String outpatient="";
		String emergency = "";
		String external="";
		String pat_class_appl="";
		String pat_class_appl1="";
		String sql1 = "";

		try
			{
				sql1="select  note_type_desc,inpatient_yn,outpatient_yn,daycare_yn,emergency_yn from ca_note_type_lang_vw where note_type=? and language_id=?";
	
				pstmt1= conn.prepareStatement(sql1);
				pstmt1.setString(1,assess_note_id);
				pstmt1.setString(2,locale);
				rs1=pstmt1.executeQuery();
	
				while(rs1.next())
					{     
						record1 = new String[5];		
						assess_note_desc1 = rs1.getString("note_type_desc")==null ? "": rs1.getString("note_type_desc");	
						record1[0]=assess_note_desc1;
										
				
						inpatient = rs1.getString("inpatient_yn")==null ? "": rs1.getString("inpatient_yn");	
						  if (inpatient.equals("Y"))
						   {
							pat_class_appl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
 							record1[1]=pat_class_appl;
				    	   }
						  else
						   {
						    pat_class_appl="";
						    record1[1]=pat_class_appl;
						   }
				
						outpatient = rs1.getString("outpatient_yn")==null ? "": rs1.getString("outpatient_yn");	
						if(outpatient.equals("Y"))
							{
								pat_class_appl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
								record1[2]=pat_class_appl;
							
							}
						else
							{
								pat_class_appl="";
								record1[2]=pat_class_appl;
							
							}
					
			emergency = rs1.getString("daycare_yn")==null ? "": rs1.getString("daycare_yn");	
					if(emergency.equals("Y"))
						{
							pat_class_appl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
							record1[3]=pat_class_appl;
						}
					else
						{
							pat_class_appl="";
							record1[3]=pat_class_appl;
						}		
					
			external =rs1.getString("emergency_yn")==null ? "": rs1.getString("emergency_yn");	
					if(external.equals("Y"))
						{
							pat_class_appl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
							record1[4]=pat_class_appl;
						}
					else
						{
							pat_class_appl="";
							record1[4]=pat_class_appl;
						}

			}

		pat_class_appl1=record1[1]+" "+record1[2]+" "+record1[3]+" "+record1[4]+" ";

%>
<table border="0" cellpadding="0" cellspacing="0" width="80%" align='center'>
	
	<tr><TD colspan="3">&nbsp;</TD>
	</tr>
	<tr><TD colspan="3">&nbsp;</TD>
	</tr>
    <tr>
	  	<td align='right' class='label'><fmt:message key="Common.note.label" bundle="${common_labels}"/></td>
		<td align='left' class=label id=td5 colspan="2">&nbsp;&nbsp;
			<input type=text name="assess_note_desc" id="assess_note_desc" value="<%=assess_note_id%>"  readonly onBlur='' size='4' maxlength='4'><input class='button' type=button name="assess_note_button" id="assess_note_button"  disabled value="?">&nbsp; <img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
			<input type="hidden" name="assess_note_id" id="assess_note_id" value="<%=assess_note_id%>" >	
			<input type="hidden" name="assess_desc" id="assess_desc" value="<%= assess_note_desc%>" >		
			<input type="hidden" name="note_desc" id="note_desc" value="" >	
			<input type="hidden" name="inpatient1" id="inpatient1" value="">
					
	</tr>
	<tr>
		<td colspan="3">&nbsp;</td>
	</tr>
	<tr>
			 <td width="25%"  align=right class='label'><fmt:message key="Common.NoteDescription.label" bundle="${common_labels}"/></td>
			 <td id='note_desc1' align='left' colspan="2" class="DATA">&nbsp;&nbsp;&nbsp;<%=record1[0]%></td>
	</tr>
	<tr>
		<td colspan="3">&nbsp;</td>
	</tr>
	<tr>
		<td width="15%"  align=right class='label'><fmt:message key="eCP.PatientClassApplicable.label" bundle="${cp_labels}"/></td>
		<td id='inpatient' align='left' colspan='2'  class="DATA">&nbsp;&nbsp;&nbsp;<%=pat_class_appl1%></td>
	</tr>
		<tr>
		<td colspan="3">&nbsp;</td>
		</tr>
	    <%
	    if(Enabled.equals("E"))
		{
		%>
		<tr>
			<td width="15%" align="right" class="label">&nbsp;<fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td colspan='2'>&nbsp;<input type=checkbox name="eff_status" id="eff_status"  value='<%=Enabled%>' checked onclick="checkActive(this)"></td>
		</tr>
		<tr>
		<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
		<td colspan="3">&nbsp;</td>
		</tr>
		<%}
		else
		{%>
		<tr>
			<td width="15%" align="right" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td colspan='2'>&nbsp;<input type=checkbox name="eff_status" id="eff_status"  value='<%=Enabled%>'  onclick="checkActive(this)"></td>
			
		<%}%>
		</tr>
		</tr>
		<tr>
		<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
		<td colspan="3">&nbsp;</td>
		</tr>
		</table>
   <%
		}
		catch ( Exception e ){
			//out.println(e.toString());//common-icn-0181
			e.printStackTrace();//COMMON-ICN-0181
			}
		finally{
			if ( rs1 != null ) rs1.close() ;
			if ( pstmt1 != null ) pstmt1.close() ;
			ConnectionManager.returnConnection(conn,request);
	}%>
<%}%>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name='facility_id' id='facility_id' value='<%= facility_id%>'>
</form>
</body>
</html>

