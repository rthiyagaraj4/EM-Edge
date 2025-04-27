<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eDR.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/MergeDuplicates.js'></script>
	<Script language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function callError()
	{
		var patient_id=document.forms[0].p_patient_id_er.value;
		var ErrorText = '';
	parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;

	var title = getLabel("eDR.ReviewMergeProcessErrors.label","DR");
	var dialogHeight= "13" ;
	var dialogWidth	= "35" ;
	var dialogTop="225";
	var dialogLeft="225";
	var prev="prev";
	var display="display";
	var features= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	window.showModalDialog('../../eDR/jsp/ReviewMergeProcessErrorMessages.jsp?display='+display+'&patient_id='+patient_id+'&criteria='+prev,arguments,features);
	}
	</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;
	
	String str					= "";
	String p_dup_group_id		= "";
	String p_valid_duplicate	= "";
	String p_valid_check		= "";
	String p_dup_check			= "";
	String p_not_check			= "";
	String p_patient_line		= "";
	String p_line				= "";
	String p_dup_count			= "";
	String p_order_by			= "";
	String p_status_upd_date	= "";
String locale = (String)session.getAttribute("LOCALE");

	int i	= 0;
	String patient_id = "";
	String p_patient_id		= request.getParameter("patient_id");
	p_dup_count				= request.getParameter("p_pat_count");
	p_status_upd_date		= request.getParameter("p_status_upd_date");

	if(p_status_upd_date == null || p_status_upd_date.equals("null"))  p_status_upd_date = "";

	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		if(p_patient_id == null) p_patient_id = ""; 

		str  = "SELECT dup_group_id, pat_count,to_char(status_upd_date,'dd/mm/rrrr')status_upd_date FROM dr_dup_group_vw2 WHERE patient_id = '"+p_patient_id+"'  and dup_indicator = 'V' AND group_status = 'E'";

		rs	= stmt.executeQuery(str);
		if(rs != null)
		{
			if(rs.next())
			{
				p_dup_group_id		= rs.getString("dup_group_id");
				p_dup_count			= rs.getString("pat_count");
				p_status_upd_date	= rs.getString("status_upd_date");
				if(p_status_upd_date == null || p_status_upd_date.equals("null")) p_status_upd_date = "";		
				%>
				<script>
					parent.frames[1].document.getElementById("p_patcount").value = <%=p_dup_count%> ; 
				</script>
				<%			
			}
			else
			{
				%>
				<script>
					var ErrorText = getMessage('NO_RECORD','DR');
					parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
				</script>
				<%
			}
		} if(rs != null) rs.close();

		if(p_status_upd_date != "")
					p_status_upd_date = DateUtils.convertDate(p_status_upd_date,"DMY","en",locale);
	
		str = "SELECT decode(order_by_for_process_cycle,'P','PATIENT_ID','R','MP_PATIENT_ADDED_DATE','L','FILE_LOCATION','F','FILE_NO') order_by_for_process_cycle FROM dr_process_ctl " ;
		rs = stmt.executeQuery(str);
		if(rs.next())
		{
			p_order_by = rs.getString("order_by_for_process_cycle");
		} if (rs != null) rs.close();

		str = "SELECT dup_group_id,patient_id,mp_patient_added_date, dup_indicator valid_duplicate,SUBSTR(get_patient_line(patient_id,'"+locale+"'),1,LENGTH(get_patient_line(patient_id,'"+locale+"'))-6) patient_line FROM dr_dup_group_vw2 WHERE dup_group_id='"+p_dup_group_id+"' AND group_status = 'E' ORDER BY "+p_order_by+" ";
		rs	= stmt.executeQuery(str);
		%>
		
			<%
			int cnt=0;
			if(rs != null)
			{
				while (rs.next())
				{
					i++;

					patient_id		= rs.getString("patient_id") ;
					p_valid_duplicate	= rs.getString("valid_duplicate");
					p_patient_line		= rs.getString("patient_line") ;
					
					if(p_valid_duplicate.equals("V"))
					{
						p_valid_check = "checked";
						p_dup_check   = "unchecked";
						p_not_check   = "unchecked";
					}
					else if(p_valid_duplicate.equals("D"))
					{
						p_valid_check = "unchecked";
						p_dup_check   = "checked";
						p_not_check   = "unchecked";
					}
					else if (p_valid_duplicate.equals("X"))
					{
						p_valid_check = "unchecked";
						p_dup_check   = "unchecked";
						p_not_check   = "checked";
					}
					if(cnt==0){
					%>
					
					<form name='group_details_form' id='group_details_form' action='../../servlet/eDR.MergeDuplicateServlet' method='post' target='messageFrame'>
		<table border='0' width='100%' cellspacing='0' cellpadding='0'>
			<tr>
				<td colspan='4' class='label'><font color=navy><b>
				<fmt:message key="Common.LastProcessedDate.label" bundle="${common_labels}"/>&nbsp;<%=p_status_upd_date%></b></font>
				</td>
			
					
			<td >&nbsp;</td>
			<td><input type='button' class='button' value='<fmt:message key="Common.Error.label" bundle="${common_labels}"/> <fmt:message key="Common.details.label" bundle="${common_labels}"/>' onclick="callError();"></td>
			
					
					<% cnt=1;%>
			
			</tr>
			<tr><td colspan='6'> &nbsp;</td></tr>
				<%}%>	
					<tr>
						<td width='8%' align='center'> <input type=hidden name='selectpatient<%=i%>' id='selectpatient<%=i%>' onClick='javascript:checkDuplicatesDetails("<%=patient_id%>","<%=i%>")'></td>
						<td width='3%' class='label' align='center'><a href='javascript:viewPatientDetails("<%=patient_id%>")'>+</a></td>
						<td width='48%' class='label' colspan='1'><font size='1'><%=patient_id%></font></td>
						<td width='10%'class=label align='center'>
						<%
						if(p_valid_check.equals("checked"))
						{
							%>
								<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG></td>
							<%
						}
						%>
						<td width='10%' class='label' align='center' >
						<%
						if(p_dup_check.equals("checked"))
						{
							%>
								<IMG SRC="../../eCommon/images/enabled.gif" BORDER='0' ALT=""></IMG></td>
							<%
						}
						%>
						<td width='20%' class='label' align='center'>
						<%
						if(p_not_check.equals("checked"))
						{
							%>
								<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG></td>
							<%
						}
						%>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td class='label' colspan='5'><font size='1'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=p_patient_line%> </font></td>
					</tr>
				
			<%	}
			} if(rs != null) rs.close();
		%>
			
	 	</table>

		<input type=hidden name=patcount id=patcount value=0>
		<input type=hidden name=patient_id1 id=patient_id1 value=''>
		<input type=hidden name=patient_id2 id=patient_id2 value=''>
		<input type=hidden name=p_dup_group_id id=p_dup_group_id value=<%=p_dup_group_id%>>
		<input type=hidden name=p_patient_id_er id=p_patient_id_er value=<%=p_patient_id%>>
		<input type=hidden name=p_dup_count id=p_dup_count value=<%=p_dup_count%>>
		<input type=hidden name=p_line id=p_line value=<%=p_line%>>
		<input type=hidden name=count id=count value=<%=i%>>
		<input type=hidden name=final_chk_values id=final_chk_values value=''>
		<input type=hidden name=p_final_dup_group_id id=p_final_dup_group_id value=''>
		<input type=hidden name=process_start id=process_start value=''>
	</form>
	<%
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception e :"+ e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html>

