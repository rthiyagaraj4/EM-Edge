<!DOCTYPE html>
<html>
<%@page import="java.sql.*, java.io.*,java.text.*, webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="GCPGenerateBean"   scope="session"  class="eCP.GCPGeneratePlanBean"/>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eCP/js/GCPGenerateCarePlan.js"></script>

 </head>

<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<script language='javascript'>
	document.body.style.scrollbarBaseColor='#E2E3F0';
	document.body.style.scrollbarArrowColor='#000080';
	document.body.style.scrollbarDarkShadowColor='#E2E3F0';
	document.body.style.scrollbarFaceColor='#E2E3F0';
	document.body.style.scrollbarHighlightColor='white';
	document.body.style.scrollbarShadowColor='#E2E3F0';
	document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<form name='care_planmanager' id='care_planmanager' target='' >
<%
	 Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";
	try
	{

	String ca_practitioner_id=(String) session.getAttribute("ca_practitioner_id") == null?"" :(String)session.getAttribute("ca_practitioner_id");
	//String std_cp= request.getParameter("std_cp")==null ?"":(String)request.getParameter("std_cp");
	
	eCP.GCPGeneratePlanBean bean	= (eCP.GCPGeneratePlanBean)session.getAttribute("GCPGenerateBean");	
	
	String pract_desc="";
	String tmp_start_dt="",tmp_targ_dt="";
	
	if(!ca_practitioner_id.equals("")){
	
		try
		{    
			
			con = ConnectionManager.getConnection(request);
			//sql = "SELECT practitioner_id code,practitioner_name description,to_char(sysdate,'dd/mm/yyyy hh24:mi') FROM am_practitioner where upper(practitioner_id) like upper(?) ";
			  sql = "SELECT practitioner_id code,practitioner_name description,TO_CHAR(SYSDATE,'dd/mm/yyyy hh24:mi') FROM am_practitioner_lang_vw WHERE UPPER(practitioner_id) LIKE UPPER(?) AND language_id = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ca_practitioner_id.trim());
			pstmt.setString(2, locale);
					
			rs = pstmt.executeQuery();
		
			while(rs.next())
			{	
				pract_desc=rs.getString(2);
				//sysdate=rs.getString(3).trim();
			}
			bean.setCareManagerDesc(pract_desc);
			rs.close();
			pstmt.close();
		}
		catch(Exception ee)
		{
			out.println("Exception in care manager Profile "+ee.toString());
		}
	}
	
 
	pract_desc = bean.getCareManagerDesc();
	SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy k:mm");
	java.util.Date date_time	 	= new java.util.Date();
	String dateString 				= com.ehis.util.DateUtils.convertDate(dtSystemFormat.format(date_time),"DMYHM","en",locale);
	tmp_start_dt= bean.getPlanStart();
	tmp_targ_dt= bean.getPlanEnd();
%>
<table cellpadding=0 cellspacing=0 border=0 width="100%" align=center id='tb_scplan'>
	<tr>
		<th colspan='5' class='PLANHEAD' align=left id='summ_head' style='display:none'><font size="1"><fmt:message key="eCP.DefinePlanScope.label" bundle="${cp_labels}"/><font></th>
		<th colspan='5' class='PLANHEAD' align=left id='intvn_head' style='display:none'><font size="1"><fmt:message key="eCP.Interventions.label" bundle="${cp_labels}"/><font></th>
		
	</tr><input type ='hidden' name='pract_desc' id='pract_desc' value='<%=pract_desc%>'>
	<tr>
		<td  class='GRPEVEN' width='' ><FONT SIZE="1"><B><fmt:message key="eCP.CareManager.label" bundle="${cp_labels}"/></B></FONT></td>
		<td class='GRPEVEN'  width=''>&nbsp;</td>
		<td class="GRPEVEN" align='left' >
		<input type=text name="gpcaremanager_desc" id="gpcaremanager_desc" value='<%=pract_desc%>' size=30 maxlength=15 onblur="show_caremanager_window(this);">&nbsp;
		<label ><input type=button class=button value="?" onclick="show_caremanager_window(gpcaremanager_desc)">&nbsp;&nbsp;</label>
		<input type='hidden' name='gpcaremanager' id='gpcaremanager' value='<%=ca_practitioner_id%>'>
		</td>
		<td class='GRPEVEN' colspan='2' ><FONT SIZE="1"><B><fmt:message key="eCP.CarePlanStage.label" bundle="${cp_labels}"/></B></FONT>&nbsp;
		<select name="cp_stage" id="cp_stage" onblur='setPlanDate()' style='font-size:7pt' onChange='chkStage("care_planmanager")'><option value='*A'>----- <fmt:message key="Common.all.label" bundle="${common_labels}"/> -----</option>
		<%
//		con = ConnectionManager.getConnection(request);
		//sql = "select stage_code,short_desc Care_Plan_Stage from cp_stage ";
		sql = "SELECT stage_code,short_desc Care_Plan_Stage FROM cp_stage_lang_vw WHERE language_id = ? ";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, locale);
		rs = pstmt.executeQuery();
		while(rs.next())
		{%>
			<option value='<%=rs.getString(1)%>'><%=rs.getString(2)%></option>
		<%   		
		}

		rs.close();
		pstmt.close();
//		if(con != null) ConnectionManager.returnConnection(con);

		%>
		</select>
		</td>
	</tr>
	<tr>
		<td class='GRPEVEN'><FONT SIZE="1" ><B><fmt:message key="eCP.StartOn.label" bundle="${cp_labels}"/></B></FONT></td>
		<td class='GRPEVEN' width=''>&nbsp;</td>
		<td class='GRPEVEN' width=''><input type="textbox" name='start_date' id='start_date' value='<%=dateString%>' size='15'onBlur='checkValidDateTime(this,"<%=locale%>");checkStartDate(this);setPlanDate()'>&nbsp;<img id='st_cal' src="../../eCommon/images/CommonCalendar.gif" onclick='return showCalendar("start_date",null,"hh:mm",true);' onBlur='callFocus("start_date","")'>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<B><FONT SIZE="1"><fmt:message key="Common.for.label" bundle="${common_labels}"/></FONT>&nbsp;<input type="textbox" name="target_pd" id="target_pd" value='0' size='1'  maxlength='2' onBlur='CheckNum(this);calToDate(this,"","care_planmanager")'>&nbsp;<FONT SIZE="1"><fmt:message key="Common.days.label" bundle="${common_labels}"/></FONT></B> </td>
		<td class='GRPEVEN' align='left'><FONT SIZE="1" ><B><fmt:message key="eCP.EndOn.label" bundle="${cp_labels}"/></B></FONT>&nbsp;<input type="textbox" name='target_date' id='target_date' value='<%=dateString%>' size='15' onBlur='checkValidDateTime(this);checkDiagTargetDate(this,"care_planmanager","");setPlanDate()'>&nbsp;<img id='end_cal' src="../../eCommon/images/CommonCalendar.gif" onclick='return showCalendar("target_date",null,"hh:mm",true);' onBlur='callFocus("target_date","")'></td>
	</tr>
	<tr>
		<td class='GRPEVEN' ><FONT SIZE="1"><B><fmt:message key="eCP.GoalStatement.label" bundle="${cp_labels}"/></B></FONT></td>
		<td class='GRPEVEN'  width=''>&nbsp;</td>
		<td class='GRPEVEN' colspan='3' align='left'><textarea name="goal_statement" rows="3" cols="90" style='font-size:10pt'></textarea></td>
	</tr>
<%
		String careManagerSql="SELECT practitioner_id code,practitioner_name description FROM am_practitioner_lang_vw WHERE UPPER(practitioner_id) LIKE UPPER(?) AND UPPER(practitioner_name) LIKE  UPPER(?) AND language_id =\'"+locale+"\'";
%>
		
	<!--input type="hidden" name="caremanager_sql" value="select practitioner_id code,practitioner_name description from am_practitioner where upper(practitioner_id) like upper(?) and upper(practitioner_name) like  upper(?)"-->
	<input type="hidden" name="caremanager_sql" id="caremanager_sql" value="<%=careManagerSql%>">	

	<%if(!tmp_start_dt.equals("") && !tmp_targ_dt.equals("")){%>
	<script>
	    
		var fromarray,toarray,fromtime,totime;
		var fromDt,fromDt1;
		plan_start_date = document.care_planmanager.start_date.value;
		plan_tar_date = document.care_planmanager.target_date.value; 
		if(plan_start_date.length > 0 && plan_tar_date.length > 0 )
		{
			fromDt = plan_start_date.split(" ");
			fromarray = fromDt[0].split("/");
			fromtime = fromDt[1].split(":");
			
			fromDt1= plan_tar_date.split(" ");		
			toarray = fromDt1[0].split("/");
			totime = fromDt1[1].split(":"); 

			plan_start_date = fromarray[2]+"/"+fromarray[1]+"/"+fromarray[0]+" "+fromtime[0]+":"+fromtime[1];
			plan_tar_date = toarray[2]+"/"+toarray[1]+"/"+toarray[0]+" "+totime[0]+":"+totime[1];
			alert(plan_start_date);
			
		}
	</script>
		
	<%}%>
	
</table>
</form>
</body>
<%
}
catch(Exception exp)
{
	out.println(exp.toString());
}
finally
		{
			try{
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) ConnectionManager.returnConnection(con);
			}
			catch(Exception e){out.println(e);}
		}
%>
</html>

