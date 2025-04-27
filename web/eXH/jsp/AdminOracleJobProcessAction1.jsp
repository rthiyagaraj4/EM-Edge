<!DOCTYPE html>
<HTML>		   
<HEAD>
<%@ page import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean,eXH.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src='../../eXH/js/AdministerReviewCommunicationProcess.js'></script>

</HEAD>
	  
<body onLoad="load();" onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<%
		String SQL="SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') FROM DUAL";
		String default_date="";
		String job="";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
       String SQL3="SELECT JOB FROM DBA_JOBS WHERE (UPPER(WHAT)) LIKE 'XHBUILDER.XHCREATOR%' ";

	try{
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(SQL);
			rst = pstmt.executeQuery();	 
			while(rst.next()){
				default_date = rst.getString(1);
			}

            if(rst!=null) rst.close();
		    if(pstmt!=null) pstmt.close();

			pstmt = con.prepareStatement(SQL3);
			rst = pstmt.executeQuery();	 
			while(rst.next()){
				job = rst.getString(1);
			}

           if(rst!=null) rst.close();
		   if(pstmt!=null) pstmt.close();     
	}catch(Exception e){
			System.err.println("Err Msg in AdminOracleJobProcessAction.jsp : "+e);
	}
   %>


<form name="AdminOracleJobProcessActionForm" id="AdminOracleJobProcessActionForm" id="frmid"  method="get" action="../../servlet/eXH.XHAdminOracleJobProcessServlet">

<table cellspacing=0 cellpadding=3 width='100%' align=center>
<td class='COLUMNHEADER' colspan=4 ><fmt:message key="eXH.ProcessDetails.Label" bundle="${xh_labels}"/></th>
<tr>
	<td colspan="4"></td>
</tr>

<tr>
	<td class=label ><fmt:message key="Common.Process.label" bundle="${common_labels}"/></td>
	<td class='fields'>
	<select name="process" id="process" onchange="checkProcessOption(this);"	>
		<option value="">--------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>------</option>

		<%
		String SQL1="SELECT proc_id, long_desc,proc_srt_cmd FROM sy_proc_id WHERE proc_id like 'X%' and proc_id not in('XHCREATOR','XHTCMMSG','XHTQUERY','XPINTER')";

		
		PreparedStatement pstmt1 = null;
		ResultSet rst1 = null;
	try{
			
			pstmt1 = con.prepareStatement(SQL1);
			rst1 = pstmt1.executeQuery();
			int i=0;
			while(rst1.next()){
   %>
   <option value='<%=rst1.getString(1)%>'><%=rst1.getString(2)%></option>
  <%!String[] proc_srt_cmd=new String[3];%>

   <%		
	        proc_srt_cmd[i++]=rst1.getString(3);
            }
	}catch(Exception e){
			System.err.println("Err Msg in AdminOracleJobProcessAction.jsp : "+e);
	}finally{
			if(rst1!=null)rst1.close();
			if(pstmt1!=null)pstmt1.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
	}
   %>

</select>
  </td>
	<td></td>
	<td >
		<input class="button" type="button"  name="create" id="create" value='<fmt:message key="Common.New.label" bundle="${common_labels}"/>' onClick="enableForNew();">
		<input class="button" type="button"  name="reset" id="reset" value='<fmt:message key="Common.Refresh.label" bundle="${common_labels}"/>' onClick="reloadJobQueueFrame();">
	</td>
	
</tr>

<tr>
	<td class=label ><fmt:message key="eXH.NextProcessDateTime.Label" bundle="${xh_labels}"/></td>
	<td class='fields' ><input type=text size=12 maxlength="12"  value='<%=default_date%>' name=proc_date> <input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('proc_date','dd/mm/y');"></td>

	<td  class=label>Interval(min)
		<input type=text size=3 onBlur="return checkPositiveNumber(this);" value="1" maxlength="3" name=interval>
	
	<td ></td>
</tr>
<tr>
	<td width='20%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
	<td width='20%'></td>
</tr>
</table>
<table cellspacing=0 cellpadding=3 width='100%' border=0 align=center>
<td class='COLUMNHEADER' colspan=4><fmt:message key="eXH.Options.Label" bundle="${xh_labels}"/></td>
<tr><td colspan="6"></td></tr>

<tr>
	<td ><input type=checkbox name="chkbox_1" id="chkbox_1" onClick="checkAndUncheckAllChkBox(this);"></td>
	<td class=label ><fmt:message key="eXH.PatientAdministration.Label" bundle="${xh_labels}"/></td> 
	<td class='fields'><input type=checkbox name="chkbox_2" id="chkbox_2" onClick="checkAndUncheckAllChkBox(this);"></td>
	<td class=label ><fmt:message key="eXH.GeneralOrderMessaging.Label" bundle="${xh_labels}"/></td> 
</tr>
<tr>
	<td ><input type=checkbox name="chkbox_3" id="chkbox_3" onClick="checkAndUncheckAllChkBox(this);"></td>
	<td class=label ><fmt:message key="eXH.ObservationReporting.Label" bundle="${xh_labels}"/></td> 
	<td class='fields'><input type=checkbox name="chkbox_4" id="chkbox_4" onClick="checkAndUncheckAllChkBox(this);"></td>
	<td class=label ><fmt:message key="eXH.Scheduling.Label" bundle="${xh_labels}"/></td> 
</tr>
<tr>
	<td ><input type=checkbox name="chkbox_5" id="chkbox_5" onClick="checkAndUncheckAllChkBox(this);"></td>
	<td class=label ><fmt:message key="eXH.MasterFileNotification.Label" bundle="${xh_labels}"/></td> 
	<td class='fields'><input type=checkbox name="chkbox_6" id="chkbox_6" onClick="checkAndUncheckAllChkBox(this);"></td>
	<td class=label ><fmt:message key="Common.all.label" bundle="${common_labels}"/></td> 
</tr>

<tr><td colspan="6"></td></tr>
</table>

<table cellspacing=0 cellpadding=3 width='100%' border=0 align=center>

<tr><td colspan="6"></td></tr>

<tr>
   <td  colspan=6>
	<input class="button" type="button"  name='submit' id='submit' value='<fmt:message key="eXH.Submit.Label" bundle="${xh_labels}"/>'  onClick="submitForm(this);">
	<input class="button" type="button"  name="change" id="change" value='<fmt:message key="Common.change.label" bundle="${common_labels}"/>'  onClick="submitForm(this);">
	<input class="button" type="button"  name="run" id="run" value='<fmt:message key="Common.run.label" bundle="${common_labels}"/>'		   onClick="submitForm(this);">
	<input class="button" type="button"  name="remove" id="remove" value='<fmt:message key="Common.Remove.label" bundle="${common_labels}"/>'  onClick="submitForm(this);">
	<input class="button" type="button"  name="cancel" id="cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  onClick="disableAll();">
	<input class="button" type="submit"  name="ove" id="ove" value='<fmt:message key="eXH.Move.Label" bundle="${xh_labels}"/>' >
	
   </td>
</tr>
</table>
<input TYPE="hidden"  name ="action" value="">
<input TYPE="hidden"  name ="internal_job" value="">	
<input TYPE="hidden"  name ="process_id" value="">
<input TYPE="hidden"  name ="what" value="">
<input TYPE="hidden"  name ="job" value="">
<input TYPE="hidden"  name ="job1" value='<%=job%>'>
<select name="hidden_proc_srt_cmd" id="hidden_proc_srt_cmd">
   <%for(int i=0;i<proc_srt_cmd.length;i++){%>
   <option value='<%=proc_srt_cmd[i]%>'>
   <%}%>
</select>
<script language=javascript>
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</form>
</body>
</html>

