<!DOCTYPE html>

<%@ page import="java.sql.*, java.util.*, java.net.*, java.text.*, webbeans.eCommon.*,eDR.*"  contentType="text/html;charset=UTF-8" %>

<jsp:useBean id="obj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
	<%
	 
	request.setCharacterEncoding("UTF-8");
	String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/EnterDuplicatesPatientID.js'></script>
 	<script language='javascript' src='../../eCommon/js/common.js'></script> 
	<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onLoad="FocusFirstElement()" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='add_form' id='add_form' action='../../servlet/eDR.EnterDuplicatesServlet' method='post' target='messageFrame'>
<%
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet	rs			= null;
	PreparedStatement pstmt = null;
	
	String sql				= "";
	String p_patient_line	= "";
	String p_valid_check	= "";
	String p_dup_check		= "";
	String p_not_check		= "";
	String p_disable_add	= "";
	//String p_disable		= "";
	String p_disable1		= "";
     
	int pat_id_length	= 0;
	int pat_id_size		= 0;
	
	//Added by Ashwini on 24-Sep-2024 for ML-MMOH-CRF-1815
	Boolean isMergeDeceasedPatIdAppl = false; 
	
	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		isMergeDeceasedPatIdAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"DR","MERGE_DECEASED_PATIENTID");//Added by Ashwini on 24-Sep-2024 for ML-MMOH-CRF-1815

		//String p_facilityid = (String) session.getValue("facility_id");

		String p_function_name	= request.getParameter("function_name");
		String patient_id		= request.getParameter("patient_id");
		String p_dup_ind		= request.getParameter("p_dup_ind");
		String p_remarks		= request.getParameter("p_remarks");
		String p_string_value	= request.getParameter("p_string_val");	
		String p_flag_value	= request.getParameter("p_flag_value");	
		
		String p_string_val="";
		String flag=request.getParameter("flag");	
		if(flag==null) flag="";
		String p_old_val		= request.getParameter("p_old_val");
		String p_mode			= request.getParameter("p_mode");			
		String p_dupgroupid		= request.getParameter("p_dup_group_id");
       String pat_click              = request.getParameter("pat_click");
	
		if(pat_click ==null)pat_click="N";
		if(p_dup_ind == null) p_dup_ind = "";
		if(patient_id == null) patient_id = "";
		if(p_remarks==null) p_remarks="";
		if(p_string_value == null) p_string_value = "";
		if(!p_string_value.equals("") || flag.equals("create"))
		{	
		session.removeAttribute("p_string_value");  
			}
		if(!p_string_value.equals("") && ( p_function_name.equals("insert") || p_function_name.equals("modify") ) ) {
			if(!flag.equals("create")){
				session.setAttribute("p_string_value",p_string_value);
			}
		}
		p_string_val=(String)session.getAttribute("p_string_value");
		if(p_string_val==null)p_string_val="";
		if(p_old_val == null) p_old_val = "";
		if(p_dupgroupid == null) p_dupgroupid = "";
		if(p_mode == null) p_mode = "";

		sql = "SELECT patient_id_length FROM mp_param";
		rs  = stmt.executeQuery(sql);
		while(rs.next())
		{
		pat_id_length = rs.getInt("patient_id_length");
		} if(rs != null) rs.close();
 
		pat_id_size = pat_id_length + 2;

		if(p_mode.equals("mod"))
		{			
			p_disable1 = "readonly";			
		}
		if(p_function_name.equals("modify"))
		{		
			p_disable1 = "disabled";
		}
		if(p_dup_ind.equals("V"))
		{
			p_valid_check	= "selected";
			p_dup_check		= "";
			p_not_check		= "";
		}
		if(p_dup_ind.equals("D"))
		{
			p_valid_check	= "";
			p_dup_check		= "selected";
			p_not_check		= "";
		}
		if(p_dup_ind.equals("X"))
		{
			p_valid_check	= "";
			p_dup_check		= "";
			p_not_check		= "selected";
		}	
		%>
		<table width='100%' border='0' cellspacing='0'>
			<th class='columnheader' width='100%'  colspan='2'><fmt:message key="eDR.ManuallyEnteredDuplicates.label" bundle="${dr_labels}"/></th>
			<tr>
				<td width='50%' class='label' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td class='fields' width='50%'><input type='text' name='patient_id' id='patient_id' size=20 value="<%=patient_id%>" maxlength="<%=pat_id_length%>" <%=p_disable1%> onKeyPress="return CheckForSpecChars(event)" onBlur='callPatientLine(this,"<%=p_function_name%>");makeValidQueryCriteria(this);' ><input valign='top' type='button' name='patient_search1' id='patient_search1' value='?' <%=p_disable1%> class='button' onClick="callPatientSearch('<%=p_function_name%>');"><img align='center' src ='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>
			<%
			if(!patient_id.equals(""))
			{
				String str					= "";
				String p_deceased_yn		= "";
				//String p_patient_facility	= "";

				str = "SELECT regn_facility_id, nvl(deceased_yn,'N') deceased_yn FROM mp_patient WHERE patient_id = ? ";
				pstmt = con.prepareStatement(str);
				pstmt.setString(1, patient_id);
				rs = pstmt.executeQuery();
				//rs = stmt.executeQuery(str);
				if(rs.next())
				{
					//p_patient_facility	= rs.getString("regn_facility_id");
					p_deceased_yn		= rs.getString("deceased_yn");

			/*	if(!p_patient_facility.equals(p_facilityid))
					{
						p_disable_add = "disabled"; */
						%> 
				<!--		<script>
							parent.parent.frames[1].frames[0].document.forms[0].patient_id.select();
							parent.parent.frames[1].frames[0].document.forms[0].patient_id.focus();
							var ErrorText = getMessage('PATIENT_REGISTERED_FACILITY','DR');
							parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
						</script> -->
						<%
					//}   
					
					//Modified by Ashwini on 24-Sep-2024 for ML-MMOH-CRF-1815
					if(p_deceased_yn.equals("Y") && !isMergeDeceasedPatIdAppl)
					{
						%>
						<script>
							parent.parent.frames[1].frames[0].document.forms[0].patient_id.select();
							parent.parent.frames[1].frames[0].document.forms[0].patient_id.focus();
							var ErrorText = getMessage('DECEASED_PATIENT','DR');
							parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
						</script>
						<%
					}
				}
				else
				{
					patient_id = "";
					%>
					<script>	
						//parent.parent.frames[1].frames[0].document.forms[0].patient_id.value="";
						//parent.parent.frames[1].frames[0].document.forms[0].patient_id.select();
						//parent.parent.frames[1].frames[0].document.forms[0].patient_id.focus();
				var patient_id="";
				 patient_id=parent.parent.frames[1].frames[0].document.forms[0].patient_id.value;
					if(patient_id=='undefined') patient_id="";
					if(patient_id !="")
					 {
						var ErrorText = getMessage("INVALID_PAT","DR");
					 }else
					{
					 var ErrorText="";
					 }
						parent.parent.frames[1].frames[0].document.forms[0].patient_id.value="";
						parent.parent.frames[1].frames[0].document.forms[0].patient_id.select();
						parent.parent.frames[1].frames[0].document.forms[0].patient_id.focus();
						parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_num="+ErrorText;							
					</script>
					<%
				}
			}
			%>
			<tr>
				<td class='othlanglabel' colspan='1'></td>
				<td class='othlanglabel' id='pat_name' colspan='1' style='WORD-BREAK:BREAK-ALL;'><%=p_patient_line%></td>
			</tr>
			<tr>
				<td class='label' colspan='1'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
				<td class='fields' colspan='1'><select name='dup_ind' id='dup_ind'>
						<option value='V' <%=p_valid_check%>><fmt:message key="Common.main.label" bundle="${common_labels}"/></option>
						<option value='D' <%=p_dup_check%>><fmt:message key="eDR.Duplicate.label" bundle="${dr_labels}"/></option>
					</select>
				</td>
			</tr>
			<tr>
				<td class='label' colspan='1' ></td>
				<td class='label' colspan='1'></td>
			</tr>
			<tr>
				<td class='label'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
				<td class='fields' nowrap><textarea rows='3' cols='22' onkeypress="checkMaxLimit(this,50);return CheckForAlphaCharsRemarks(event)" onBlur="makeValidString(this);chkLength(this);" name='remarks' ><%=p_remarks%></textarea>
				<img align='center' src ='../../eCommon/images/mandatory.gif'></img>				</td>
			</tr>
			<tr><td  class='label' colspan='2'></td></tr>
			<tr>
				<% if(p_mode.equals("add") || p_mode.equals("")) { %>
					<td class='button' colspan='2' align='right'><input type='button' name='Add' id='Add' value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' class='button' <%=p_disable_add%> onClick="callDetails('<%=p_function_name%>')"><input type='button' name='cancel' id='cancel' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class='button' onClick="cancelDetails('<%=p_function_name%>','<%=p_dupgroupid%>')"></td>
				<% } else {%>
					<td class='button' colspan='2' align='right'><input type='button' name='Modify' id='Modify' value='<fmt:message key="Common.Modify.label" bundle="${common_labels}"/>' 	class='button' onClick="modifyDetails('<%=p_function_name%>','<%=p_dupgroupid%>')"><input type='button' name='cancel' id='cancel' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class='button' onClick="cancelDetails('<%=p_function_name%>','<%=p_dupgroupid%>')"></td>
				<% } %>
					
			</tr>
		</table>
		<input type='hidden' name="p_patient_id" id="p_patient_id" value="<%=patient_id%>">
		<input type='hidden' name='p_string_value' id='p_string_value' value="<%=p_string_val%>">
		<input type='hidden' name='p_flag_value' id='p_flag_value' value="<%=p_flag_value%>">
		
		<input type='hidden' name='p_string_old_value' id='p_string_old_value' value="<%=p_old_val%>">
		<input type='hidden' name='function_name' id='function_name' value="<%=p_function_name%>">
		<input type='hidden' name='p_patient_line' id='p_patient_line' value="<%=p_patient_line%>">
		<input type='hidden' name='mode' id='mode' value='insert'>
		<input type='hidden' name='delete_string' id='delete_string' value=''>
		<input type='hidden' name='p_pat_count' id='p_pat_count' value=''>
		<input type='hidden' name='dupgroupid' id='dupgroupid' value=''>
		<input type='hidden' name='patientid' id='patientid' value=''>
		<input type='hidden' name='dupind' id='dupind' value=''>	
		<input type='hidden' name='remark' id='remark' value=''>		
		
		<!--Added by Ashwini on 11-Jan-2024 for ML-MMOH-CRF-2102-->
		<input type='hidden' name='merge_reason' id='merge_reason' value=''>		
		<input type='hidden' name='requested_by' id='requested_by' value=''>		
		
		<!--Added by Ashwini on 24-Sep-2024 for ML-MMOH-CRF-1815-->
		<input type='hidden' name='isMergeDeceasedPatIdAppl' id='isMergeDeceasedPatIdAppl' value='<%=isMergeDeceasedPatIdAppl%>'>
			
		
			</form>
		<%
      
		
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(pstmt != null) pstmt.close();
	   
	   if(p_string_value.equals("") && pat_click.equals("N")){
	   session.removeAttribute("p_string_value");}
	
//	if(!p_string_value.equals("")){
	 //  session.removeAttribute("p_string_value");}
	
	
	}
	
	
	catch(Exception e)
	{
		//out.println("Exception e :"+e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html>

