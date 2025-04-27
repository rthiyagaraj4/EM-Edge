<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- InterventionParamAddModify.jsp -->
<%--
*	Copyright © Iba Health (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Suri
*	Created On		:	15/09/2006

--%>
<%@page import='java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.Common.*' contentType="text/html;charset=UTF-8"%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
//This file is saved on 18/10/2005.
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="JavaScript" src="../../eCP/js/IntervntionParameter.js"></script>
<Script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='interventionParamAddModifyForm' id='interventionParamAddModifyForm' method='post' action='../../servlet/eCP.InterventionParamServlet' target='messageFrame'>
<%
	Connection con = null;
	String accessYN = "";
	String beforeStartTimeText = "";
	String beforeStartTimeSelect = "";
	String afterStartTimeText = "";
	String afterStartTimeSelect = "";
	String endTimeText = "";
	String endTimeSelect = "";
	String backTimeText = "";
	String backTimeSelect = "";
	String selected ="";
	PreparedStatement ps = null;
	ResultSet rs = null;
	try
	{
		con = ConnectionManager.getConnection(request);
		ps = con.prepareStatement("select task_list_access_by_pin_yn, lmt_for_tsk_due_bf_st_tm, lmt_for_tsk_due_bf_st_tm_unit, lmt_for_tsk_odue_af_st_tm, lmt_for_tsk_odue_af_st_tm_unit, lmt_for_tsk_exp_af_end_tm, lmt_for_tsk_exp_af_end_tm_unit, bkdate_lmt_for_tsk_result, bkdate_lmt_for_tsk_result_unit from ca_intervention_param");
	    rs = ps.executeQuery();
		while(rs.next())
		{
			accessYN = rs.getString("task_list_access_by_pin_yn")==null ? "" :rs.getString("task_list_access_by_pin_yn");
			beforeStartTimeText = rs.getString("lmt_for_tsk_due_bf_st_tm")==null ? "" :rs.getString("lmt_for_tsk_due_bf_st_tm");
			beforeStartTimeSelect = rs.getString("lmt_for_tsk_due_bf_st_tm_unit")==null ? "" :rs.getString("lmt_for_tsk_due_bf_st_tm_unit");
			afterStartTimeText =  rs.getString("lmt_for_tsk_odue_af_st_tm")==null ? "" :rs.getString("lmt_for_tsk_odue_af_st_tm");
			afterStartTimeSelect = rs.getString("lmt_for_tsk_odue_af_st_tm_unit")==null ? "" :rs.getString("lmt_for_tsk_odue_af_st_tm_unit");
			endTimeText = 	rs.getString("lmt_for_tsk_exp_af_end_tm")==null ? "" :rs.getString("lmt_for_tsk_exp_af_end_tm"); 
			endTimeSelect = rs.getString("lmt_for_tsk_exp_af_end_tm_unit")==null ? "" :rs.getString("lmt_for_tsk_exp_af_end_tm_unit"); 
			backTimeText = 	rs.getString("bkdate_lmt_for_tsk_result")==null ? "" :rs.getString("bkdate_lmt_for_tsk_result"); 
			backTimeSelect = rs.getString("bkdate_lmt_for_tsk_result_unit")==null ? "" :rs.getString("bkdate_lmt_for_tsk_result_unit"); 
		}
	      if(rs != null)rs.close();
	      if(ps != null)ps.close();
%>
<br>
<br>
<br>
<br>
<br>
<br>
<table width='95%' align='center' border='0' cellpadding='0' cellspacing='0' >
<tr>
<td colspan='2'>&nbsp;</td>
</tr>
<!--<tr>
<td  align="center" class="label" width="60%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Access to task list based on PIN</td>
<td  align="left" ><input type="checkbox" name="accessTask" id="accessTask" value="Y" <%if(accessYN.equals("Y")) out.println("checked");%>></td>
</tr>
<tr>
<td colspan='2'>&nbsp;</td>
</tr>-->
<tr>
<td width='60%' class='label' align='left'><fmt:message key="eCP.DurationBeforeStartTimeWhenTaskConsideredDue.label" bundle="${cp_labels}"/></td>
<td  width='40%'  align='left'>
<input type ='text'name='before_start_time_text' value='<%=beforeStartTimeText%>' size='3' maxlength='2' onkeypress='return allowValidNumber( this, event,3,0)' OnBlur='checkSequence(this,"Duration before start time")'>&nbsp;
<Select name='duration_start_time' id='duration_start_time'>
<option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
     <%
	        //ps = con.prepareStatement("select durn_type, durn_desc from am_duration_type order by durn_desc ");
	        ps = con.prepareStatement("select durn_type, durn_desc FROM am_duration_type_lang_Vw where language_id = ? ORDER BY durn_desc");
			ps.setString(1,locale);
		    rs = ps.executeQuery();
			while(rs.next())
		      {
				if(beforeStartTimeSelect.equals(rs.getString(1)))
				{
					selected="selected";
				}
				else
				{
					selected="";
				}
			out.println("<option value='"+rs.getString(1)+"' "+selected+">"+rs.getString(2)+"</option>");
		      }
	
	         if(rs != null)rs.close();
	         if(ps != null)ps.close();
	       %>
    <select>&nbsp;<img src='../../eCommon/images/mandatory.gif'>
	</td>
	</tr>
<tr>
<td colspan='2'>&nbsp;</td>
</tr>
<tr>
    <td width='65%' class='label' align='left'><fmt:message key="eCP.DurationAfterStartTimeWhenTaskConsideredOverdue.label" bundle="${cp_labels}"/>&nbsp;&nbsp;</td>
	<td  width='40%'  align='left'>
	<input type ='text'name='after_start_time_text' value='<%=			afterStartTimeText%>' size='3' maxlength='2' onkeypress='return allowValidNumber( this, event,3,0)' OnBlur='checkSequence(this,"Duration after start time")'>&nbsp;
    <Select name='duration_after_time' id='duration_after_time'>
	<option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
	         
	       <%
			 //ps = con.prepareStatement("select durn_type, durn_desc from am_duration_type order by durn_desc ");
			 ps = con.prepareStatement("select durn_type, durn_desc FROM am_duration_type_lang_Vw where language_id = ? ORDER BY durn_desc");
			 ps.setString(1,locale);
		     rs = ps.executeQuery();
			 while(rs.next())
	          {
 				if(afterStartTimeSelect.equals(rs.getString(1)))
				{
					selected="selected";
				}
				else
				{
					selected="";
				}

		     out.println("<option value='"+rs.getString(1)+"'"+selected+">"+rs.getString(2)+"</option>");
	          } 
	
	          if(rs != null)rs.close();
	          if(ps != null)ps.close();
	%>
    <select>&nbsp;<img src='../../eCommon/images/mandatory.gif' >
	</td>
	</tr>


<tr>
<td colspan='2'>&nbsp;</td>
</tr>

   <tr>
   <td width='60%' class='label' align='left'><fmt:message key="eCP.DurationAfterEndTimeWhenTaskExpired.label" bundle="${cp_labels}"/></td>
	<td  width='40%'  align='left'>
	<input type ='text'name='end_time' value='<%=endTimeText%>' size='3' maxlength='2' onkeypress='return allowValidNumber( this, event,3,0)' OnBlur='checkSequence(this,"Duration after end time ")'>&nbsp;
    <Select name='end_time_select' id='end_time_select'>
	<option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
	       <%
			//ps = con.prepareStatement("select durn_type, durn_desc from am_duration_type order by durn_desc ");
			ps = con.prepareStatement("select durn_type, durn_desc FROM am_duration_type_lang_Vw where language_id = ? ORDER BY durn_desc");
			ps.setString(1,locale);
		    rs = ps.executeQuery();
			while(rs.next())
	         {
				if(endTimeSelect.equals(rs.getString(1)))
				{
					selected="selected";
				}
				else
				{
					selected="";
				}

		    out.println("<option value='"+rs.getString(1)+"' "+selected+">"+rs.getString(2)+"</option>");
	        }
	
	        if(rs != null)rs.close();
	        if(ps != null)ps.close();
	%>
    <select>&nbsp;<img src='../../eCommon/images/mandatory.gif'>
	</td>
	</tr>

<tr>
<td colspan='2'>&nbsp;</td>
</tr>

   <tr>
   <td width='60%' class='label' align='left'><fmt:message key="eCP.BackdatingLimitForTaskResulting.label" bundle="${cp_labels}"/></td>
   <td  width='40%'  align='left'>
   <input type ='text'name='Backdate_limit' value='<%=backTimeText%>' size='3' maxlength='2' onkeypress='return allowValidNumber( this, event,3,0)' OnBlur='checkSequence(this,"Backdating limit ")'>&nbsp;
   <Select name='backdate' id='backdate'>
   <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
	
   
          <%
			//ps = con.prepareStatement("select durn_type, durn_desc from am_duration_type order by durn_desc ");
			ps = con.prepareStatement("select durn_type, durn_desc FROM am_duration_type_lang_Vw where language_id = ? ORDER BY durn_desc");
			ps.setString(1,locale);
		    rs = ps.executeQuery();
			while(rs.next())
	             {
					if(backTimeSelect.equals(rs.getString(1)))
				    {
					selected="selected";
				    }
				else
				 {
					selected="";
				 }

		       out.println("<option value='"+rs.getString(1)+"' "+selected+">"+rs.getString(2)+"</option>");
	           }
	
	          if(rs != null)rs.close();
	          if(ps != null)ps.close();
	      %>
          <select>&nbsp;<img src='../../eCommon/images/mandatory.gif'>
	</td>
	</tr>

<tr>
<td colspan='2'>&nbsp;</td>
</tr>
</table>
</form>
</body>
<%
}

catch(Exception ee)
{
	out.println("Exception from InterventionParamAddModify.jsp :"+ee.toString());
}

finally 
{
	if(rs != null)rs.close();
    if(ps != null)ps.close();
	if(con != null) ConnectionManager.returnConnection(con);
}
%>
</html>

