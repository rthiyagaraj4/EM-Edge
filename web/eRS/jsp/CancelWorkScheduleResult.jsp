<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	CancelWorkSchedule.jsp
*	Purpose 			:
*	Created By		:	Sreenivasulu.Y
*	Created On		:	19 Nov 2004
*/
%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>


<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script> -->
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/CancelWorkSchedule.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	 //String sql_show_details="Select a.FACILITY_ID facility_id, a.WORKPLACE_CODE workplace_code, f.workplace_desc workplace_desc, a.ROLE_TYPE role_type, a.STAFF_ID staff_id, nvl(b.practitioner_name, c.other_staff_name) staff_name, to_char(a.SCHEDULE_DATE,'dd/mm/yyyy') sch_date, a.SHIFT_CODE shift_code, a.SHIFT_MNEMONIC shift_mnemonic, d.short_desc shift_desc, to_char(a.SHIFT_START_TIME,'hh24:mi') shift_start_time, to_char(a.SHIFT_END_TIME,'hh24:mi') shift_end_time, a.LOCN_TYPE locn_type, a.ACTIVITY_LOG_ID activity_log_id from rs_work_schedule a, am_practitioner b, am_other_staff c, am_shift d, am_care_locn_type e, rs_workplace f where  a.facility_id = ? and  a.schedule_date between       to_date(?,'dd/mm/yyyy') and (to_Date(?,'dd/mm/yyyy') +1) and a.workplace_code = nvl(?,a.workplace_code) and ((? is null) or (? is not null and a.locn_type = ?)) and a.position_code = nvl(?,a.position_code) and a.role_type = nvl(?,a.role_type) and a.staff_id = nvl(?,a.staff_id) and a.staff_type = nvl(?,a.staff_type) and b.practitioner_id(+) = a.staff_id and c.other_staff_id(+) = a.staff_id and d.shift_code = a.shift_code and e.locn_type(+) = a.locn_type and f.facility_id = a.facility_id and f.workplace_code = a.workplace_code order by f.workplace_desc, a.role_type, staff_name, a.schedule_date";
	 String sql_show_details="Select a.FACILITY_ID facility_id, a.WORKPLACE_CODE workplace_code, f.workplace_desc workplace_desc, a.ROLE_TYPE role_type, a.STAFF_ID staff_id, nvl(b.practitioner_name, c.other_staff_name) staff_name, to_char(a.SCHEDULE_DATE,'dd/mm/yyyy') sch_date, a.SHIFT_CODE shift_code, a.SHIFT_MNEMONIC shift_mnemonic, d.short_desc shift_desc, to_char(a.SHIFT_START_TIME,'hh24:mi') shift_start_time, to_char(a.SHIFT_END_TIME,'hh24:mi') shift_end_time, a.LOCN_TYPE locn_type, a.ACTIVITY_LOG_ID activity_log_id from rs_work_schedule a, am_practitioner_lang_vw b, am_other_staff_lang_vw c, am_shift_lang_vw d, am_care_locn_type e, rs_workplace_lang_vw f where  a.facility_id = ? and  a.schedule_date between       to_date(?,'dd/mm/yyyy') and (to_Date(?,'dd/mm/yyyy') +1) and a.workplace_code = nvl(?,a.workplace_code) and ((? is null) or (? is not null and a.locn_type = ?)) and a.position_code = nvl(?,a.position_code) and a.role_type = nvl(?,a.role_type) and a.staff_id = nvl(?,a.staff_id) and a.staff_type = nvl(?,a.staff_type) and b.practitioner_id(+) = a.staff_id and c.other_staff_id(+) = a.staff_id and d.shift_code = a.shift_code and e.locn_type(+) = a.locn_type and f.facility_id = a.facility_id and f.workplace_code = a.workplace_code and b.language_id(+) = ? and c.language_id(+) = ? and d.language_id = ? and f.language_id = ? order by f.workplace_desc, a.role_type, staff_name, a.schedule_date";

	 ArrayList WorkSchedule_List		= new ArrayList();
	 String[] record				= null;

	 Connection conn 		= null;
	 PreparedStatement pstmt 	= null;
	 ResultSet rs 		= null;
		
	String facility_id=request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	String frm_dt=request.getParameter("frm_dt")==null?"":request.getParameter("frm_dt");
	String to_dt=request.getParameter("to_dt")==null?"":request.getParameter("to_dt");
	String workplace_code=request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");
	String locn_type=request.getParameter("locn_type")==null?"":request.getParameter("locn_type");
	String position_code=request.getParameter("position_code")==null?"":request.getParameter("position_code");
	String role_type=request.getParameter("role_type")==null?"":request.getParameter("role_type");
	String staff_id=request.getParameter("staff_id")==null?"":request.getParameter("staff_id");
	String staff_type=request.getParameter("staff_type")==null?"":request.getParameter("staff_type");
    String reason_code=request.getParameter("reason_code")==null?"":request.getParameter("reason_code");
 	String slClassValue="";

	try{
		conn = ConnectionManager.getConnection(request);
		pstmt = conn.prepareStatement( sql_show_details );
		pstmt.setString(1,facility_id);
		pstmt.setString(2,frm_dt);
		pstmt.setString(3,to_dt);
		pstmt.setString(4,workplace_code);
		pstmt.setString(5,locn_type);
		pstmt.setString(6,locn_type);
		pstmt.setString(7,locn_type);
		pstmt.setString(8,position_code);
		pstmt.setString(9,role_type);
		pstmt.setString(10,staff_id);
		pstmt.setString(11,staff_type);
		pstmt.setString(12,locale);
		pstmt.setString(13,locale);
		pstmt.setString(14,locale);
		pstmt.setString(15,locale);
		rs = pstmt.executeQuery() ;
				
		while (rs != null && rs.next()) {

			record = new String[14];

			record[0] = rs.getString("facility_id");
			record[1] = rs.getString("workplace_code");
			record[2] = rs.getString("workplace_desc");
			record[3] = rs.getString("role_type");
			record[4] = rs.getString("staff_id");
			record[5] = rs.getString("staff_name");
			record[6] = rs.getString("sch_date");
			record[7] = rs.getString("shift_code");
			record[8] = rs.getString("shift_mnemonic");
			record[9] = rs.getString("shift_desc");
			record[10] = rs.getString("shift_start_time");
			record[11] = rs.getString("shift_end_time");
			record[12] = rs.getString("locn_type");
			record[13] = rs.getString("activity_log_id");

			WorkSchedule_List.add(record) ;
			
		}
		if(pstmt != null)
			pstmt.close();
		if(rs != null)
			rs.close();
	
		int totalRecords=WorkSchedule_List.size();
%>
			<form name='formCanWrkSchResult' id='formCanWrkSchResult' action='../../servlet/eRS.CancelWorkScheduleServlet' method='POST' target='messageFrame'>
			<table cellpadding=0 cellspacing=0 border=1 width="100%" id='detailTab'>
<%
			for( int i=0 ; i< WorkSchedule_List.size() ; i++ ) {

				if(i % 2 == 0)
					slClassValue = "QRYEVEN";
				else
					slClassValue = "QRYODD";
				
				record = (String[])WorkSchedule_List.get(i);
				String rol="";

				 if(record[3].equalsIgnoreCase("P"))
					  rol="Practitioner";
				 
				 else if(record[3].equalsIgnoreCase("O"))
					  rol="Other Staff";
%>
<tr>
	 <td colspan='8' width=12% Align='left' class ='<%=slClassValue%>'><font size=2><%=record[2]%>
	 <input type="hidden" name="work_code<%=i%>" id="work_code<%=i%>" value="<%=record[1]%>" ></td>  
	 
	 <td colspan='6' width=9% Align='left' class='<%=slClassValue%>' ><font size=2><%=rol%>
	 <input type="hidden" name="rol_type<%=i%>" id="rol_type<%=i%>" value="<%=record[3]%>" ></td> 
		 
	 <td colspan='8' width=20% Align='left' class ='<%=slClassValue%>'><font size=2><%=record[5]%>
	 <input type="hidden" name="staf_id<%=i%>" id="staf_id<%=i%>" value="<%=record[4]%>" ></td>  
	 
	 <td colspan='6' width=9% Align='left' class='<%=slClassValue%>' ><font size=2><%=com.ehis.util.DateUtils.convertDate(record[6],"DMY","en",locale)%>
	 <input type="hidden" name="sch_date<%=i%>" id="sch_date<%=i%>" value="<%=record[6]%>" ></td>  

	<td colspan='8' width=12% Align='left' class ='<%=slClassValue%>'><font size=2><%=record[9]%>
	<input type="hidden" name="shft_code<%=i%>" id="shft_code<%=i%>" value="<%=record[7]%>" ></td>
	 	 
	 <td colspan='6' width=4% Align='left' class='<%=slClassValue%>' ><font size=2><%=record[10]%>
	 <input type="hidden" name="start_time<%=i%>" id="start_time<%=i%>" value="<%=record[10]%>" ></td>  

	<td colspan='8' width=5% Align='left' class ='<%=slClassValue%>'><font size=2><%=record[11]%>
	 <input type="hidden" name="end_tyme<%=i%>" id="end_tyme<%=i%>" value="<%=record[11]%>" ></td>  
	 
	<td  colspan='8' width=6% Align='left' class='<%=slClassValue%>'>
	<input type=checkbox name='select_yn<%=i%>' id='select_yn<%=i%>' checked value='' ></td> 
    
</tr>  
<% 
		} 
%>
<input type='hidden' name='totalRecords' id='totalRecords'  value='<%=totalRecords%>'> 
<input type='hidden' name='facility_id' id='facility_id'  value='<%=facility_id%>'>
<input type='hidden' name='reason_code' id='reason_code'  value='<%=reason_code%>'>
<input type='hidden' name='frm_dt' id='frm_dt'  value='<%=frm_dt%>'>
<input type='hidden' name='to_dt' id='to_dt'  value='<%=to_dt%>'>
<input type='hidden' name='locn_type' id='locn_type'  value='<%=locn_type%>'>
<input type='hidden' name='workplace_code' id='workplace_code'  value='<%=workplace_code%>'>
<input type='hidden' name='role_type' id='role_type'  value='<%=role_type%>'>
<input type='hidden' name='staff_type' id='staff_type'  value='<%=staff_type%>'>
<input type='hidden' name='staff_id' id='staff_id'  value='<%=staff_id%>'>
<input type='hidden' name='position_code' id='position_code'  value='<%=position_code%>'>
</form>
</table>
<%
	}catch(Exception e){
		out.println(e.getMessage());
		e.printStackTrace();
	 } 
	 finally{
		if (pstmt != null) pstmt.close();
		if (rs != null)   rs.close();
		ConnectionManager.returnConnection(conn,request);
	 }
%>   
</body>
</html>

