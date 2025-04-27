<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Suchilagna Panigrahi.
*	Created On		:	6th may 2005
--%>
<html>
<head>
<title>
Variance
</title>
<%@ page import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCP/js/common.js" language="JavaScript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCP/js/EvaluateCarePlan.js" language="JavaScript"></script>
</head>
<%
	String schedule_date = "",task_desc = "" , status="" , type = "";
	String prevschedule_date = "",prevtask_desc = "" , prev_type ="" , prev_status = "" ;
	String cp_start_date ="" , classValue = "";	
	String facilty_id = request.getParameter("facilty_id");
	String p_patient_id = request.getParameter("p_patient_id")==null?"":request.getParameter("p_patient_id");
	Connection con = null;
	PreparedStatement pstmt_variance = null;
	ResultSet rs_variance = null;
	PreparedStatement pstmt_start_date = null;
	ResultSet rs_start_date = null;
%>
<body OnMouseDown='CodeArrest()'>
<form name='eval_cp_variance' id='eval_cp_variance'>
<table border="1" cellpadding="0" cellspacing="0" width="102%" align='center'>
<tr>
	<td class="ADHOC" align="center" width='20%'><fmt:message key="eCP.AdhocIntervention.label" bundle="${cp_labels}"/></td>
	<td class="PLANNED" align="center" width='20%'><fmt:message key="eCP.PlannedIntervention.label" bundle="${cp_labels}"/></td>
	<td class="PERFORMED" align="center" width='20%'><fmt:message key="Common.Performed.label" bundle="${common_labels}"/></td>
	<td class="NOTPERFORMED" align="center" width='20%'><fmt:message key="Common.NotPerformed.label" bundle="${common_labels}"/></td>
	<td class="PENDING" align="center" width='20%'><fmt:message key="Common.Pending.label" bundle="${common_labels}"/></td>
</tr>
</table>
<table border="1" cellpadding="0" cellspacing="0" width="102%" align='center'>
<%
try
{
con = ConnectionManager.getConnection(request);

String sql_start_date="select to_char(min(care_plan_start_date),'dd/mm/yyyy') care_plan_start_date from cp_pat_care_plan where patient_id = ? and current_status in ('O','F') ";

pstmt_start_date = con.prepareStatement(sql_start_date);

pstmt_start_date.setString(1,p_patient_id);

rs_start_date = pstmt_start_date.executeQuery();

while((rs_start_date!=null)&&(rs_start_date.next()))
	{
	cp_start_date = rs_start_date.getString("care_plan_start_date");
	}
		
String sql_variance = "";	
// Queries
sql_variance = "select to_char(a.schedule_datetime,'dd/mm/yyyy') sch_date,to_char(a.schedule_datetime,'hh24:mi') sch_time, a.task_code task_code,b.short_desc task_desc,a.performed_by_id,to_char(a.performed_date,'dd/mm/yyyy hh24:mi') perf_date_time,a.status status,decode(a.care_plan_id,null,'A','P') type from ca_pat_task_list a,ca_intervention b where a.task_code = b.intervention_code and patient_id = ? and  ((care_plan_id is not null and  (md_care_plan_id,care_plan_id) in ( select md_care_plan_id,care_plan_id from cp_pat_care_plan where patient_id = ? and current_status in ('O','F'))) or (care_plan_id is null and schedule_datetime >= to_date(?,'dd/mm/yyyy'))) and status in ('O','P','N') and facility_id = ? order by trunc(schedule_datetime), task_code, schedule_Datetime";

	
	// End of Queries.
	pstmt_variance=con.prepareStatement(sql_variance);
	
	pstmt_variance.setString(1,p_patient_id);
	pstmt_variance.setString(2,p_patient_id);
	pstmt_variance.setString(3,cp_start_date);
	pstmt_variance.setString(4,facilty_id);

	rs_variance=pstmt_variance.executeQuery();

	int hh = 0;		
	int cell1 =0;
	String a[]=new String[20];
	//String borderc = "";

if((rs_variance!=null)&&(rs_variance.next()))
	{
		String flag = "1";

			schedule_date = rs_variance.getString("sch_date");
			task_desc = rs_variance.getString("task_desc");
			type = rs_variance.getString("type");
			status = rs_variance.getString("status");
			

				prevschedule_date = schedule_date;
				prevtask_desc = task_desc;
				prev_type = type ;
				prev_status = status ;
	

while(flag.equals("1"))
{
		%>
		<tr>
			
		<th width='8%' align = "left"><b><fmt:message key="eCP.Interventions.label" bundle="${cp_labels}"/></b></th>
		<th  width='8%' colspan = 20 align = left><fmt:message key="Common.ScheduleDate.label" bundle="${common_labels}"/> : <%=prevschedule_date%></th> 
			<% 
			
			while (prevschedule_date.equals(schedule_date) && flag.equals("1"))
			{ 
				 cell1 = 0; 
				
			while (prevschedule_date.equals(schedule_date) && prevtask_desc.equals(task_desc) && flag.equals("1"))
				{ 
				

					
					a[cell1] = rs_variance.getString("sch_time");

				if (rs_variance.next())
					{
						schedule_date = rs_variance.getString("sch_date");
						task_desc = rs_variance.getString("task_desc");
						type = rs_variance.getString("type");
						status = rs_variance.getString("status");

						//System.out.println("type suchi: "+type);
					}
					else
					{
						flag = "0";		
					}

					cell1++;
				if(prev_type.equals("A"))
				classValue = "ADHOCA";
				else if(prev_type.equals("P"))
				classValue = "PLANNEDA";
				}
%>
				<tr >
					<td class=<%=classValue%> width='3%'  nowrap>&nbsp;<%=prevtask_desc%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<%
	prev_type = type;
prevtask_desc = task_desc;	

	for(int kkk=0;kkk<20;kkk++){
		if(a[kkk]!=null){
				if(prev_status.equals("P"))
				classValue = "PERFORMED";
				else if(prev_status.equals("N"))
				classValue = "NOTPERFORMED";
				else if(prev_status.equals("O"))
				classValue = "PENDING";
	%>
		<td class=<%=classValue%> width='3%' nowrap>&nbsp;<%=a[kkk]%>&nbsp;</td>
<%				a[kkk] =null;

	}else{%>
 <td width='3%' nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<%
	}
		
			}
	prev_status = status;
	}//schedule_date loop
	prevschedule_date = schedule_date;%>	
	</tr> <%
		
		hh++;	
		
}
}
}catch(Exception e)
{
	//out.println(e);//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}finally
{
	if(rs_variance!=null){rs_variance.close();}
	if(rs_start_date!=null){rs_start_date.close();}
	if(pstmt_variance!=null){pstmt_variance.close();}
	if(pstmt_start_date!=null){pstmt_start_date.close();}
	if(con != null)	ConnectionManager.returnConnection(con,request);
}%>
		</table>
	</form>
</body>
</head>

