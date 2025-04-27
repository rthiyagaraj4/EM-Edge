<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* ,java.io.*,java.text.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src="../js/StaffForWorkplace.js" language="javascript"></script>
<script language='javascript' src= '../../eCommon/js/FieldFormatMethods.js'> </script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js' ></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/dchk.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</script>
<script>
	function chkfrto(from,to)
	{
		var chk2 ='';
		var chk =doDateCheckAlert(document.forms[0].sysdate,to);
		if(chk==false){
			alert(getMessage("TO_DATE_LESS_SYSDATE","RS"));
			chkfrsys ='Y';
			to.select();
			to.focus();
			chk2 ='Y';
		}
		if(chk2=='')
		{
		var chk1 =doDateCheckAlert(from,to);
		if(chk1==false){
			alert(getMessage("TO_DT_GR_EQ_FM_DT","RS"));
			to.select();
			to.focus();
			//return false;
		}
		}
	}
	function chksys1(obj)
	{
		var chk =doDateCheckAlert(document.forms[0].sysdate,obj);
		if(chk==false){
			alert(getMessage("FROM_DATE_LESS_SYSDATE","RS"));
			obj.select();
			obj.focus();
			//return false;
		}
	}
	
	function oncheck(target){
	if(target.checked==true)
		{
		target.value="Y";
		//eval("document.forms[0].eff_status"+i).value="E";
	/*alert(eval("document.forms[0].eff_status"+i).value);
	alert(i);*/
		}
	else if(target.checked==false)
		{
		target.value="N";
		//eval("document.forms[0].eff_status"+i).value="D";
		/*alert(eval("document.forms[0].eff_status"+i).value);
			alert(i);*/
		}
	return;
}
	</script>
 <body onMouseDown="" onKeyDown="lockKey()">
 <form name="workplace_frm_list" id="workplace_frm_list" action='../../servlet/eRS.StaffForWorkplaceServlet' method='POST' target='messageFrame'>
 <%
	  Connection con 	      = null;
	  PreparedStatement pstmt	      = null;
	  PreparedStatement pstmt1	      = null;
	  PreparedStatement pstmt2	      = null;
	  ResultSet rs		      = null;
	  ResultSet rs1		      = null;
	  ResultSet rs2		      = null;
	  PreparedStatement pstmt4	      = null;
	  ResultSet rs4		      = null;
	  String	facilityId 	  = (String) session.getValue( "facility_id" ) ;
	
	  String staff_type="";
	  String locn_type_desc="";
	  String eff_from="";
	  String eff_to="";
	  String eff_status="";
	  String work_place_desc="";
	  String workplace_code="";
	  String classValue="";
	  String chkunchk="";
	  String dochkunchk="";
	  String dbaction="";
	  String sysdate="";
	  String disp_locn="";
	  String disp_wrk="";
	  java.util.Date date1 =null;
	  java.util.Date date2 =null;	
	  String dbcheck="";
	  int rowIndex =	1;
	  int i= 0;
	  int record_Count= 0;
	  int record_Count1= 0;
	  try
  {
		con = ConnectionManager.getConnection(request);
		String sel_Sysdate ="select to_char(sysdate,'dd/mm/yyyy'),sysdate from dual";
		pstmt4 = con.prepareStatement(sel_Sysdate);
		rs4 = pstmt4.executeQuery();
		while(rs4!=null && rs4.next())
		{
			sysdate =rs4.getString(1);
			date2 =rs4.getDate(2);
		 }
		 if(pstmt4 != null)
			 pstmt4.close();
		 if(rs4 != null)
			 rs4.close();

		String mode	   = request.getParameter("mode") ;
		 if( mode==null) mode="";
		String locn_type = request.getParameter("locn_type");
		String role_type = request.getParameter("role_type");
		if(locn_type==null) locn_type = "";
		if(role_type==null) role_type = "";

		String staff = request.getParameter("staff");
		if(staff==null) staff = "";
	

	String sqlCount="SELECT COUNT (*)   FROM rs_staff_for_workplace a, am_care_locn_type b, rs_workplace c  WHERE a.facility_id = ? AND a.role_type = ? AND a.staff_id = ? AND c.facility_id = a.facility_id AND c.workplace_code = a.workplace_code AND b.locn_type(+) = c.locn_type AND (?  IS NULL OR c.locn_type = ?) UNION ALL SELECT COUNT (*) b FROM rs_workplace a, am_care_locn_type b WHERE a.facility_id = ? AND (?  IS NULL OR a.locn_type = ? ) AND a.eff_status = 'E' AND b.locn_type(+) = a.locn_type AND (a.facility_id, workplace_code) NOT IN (SELECT facility_id, workplace_code FROM rs_staff_for_workplace WHERE facility_id = ? AND role_type = ? AND staff_id = ? )";
		//out.println(sqlCount);
		pstmt1 = con.prepareStatement(sqlCount);
		pstmt1.setString(1,facilityId);
		pstmt1.setString(2,role_type);
		pstmt1.setString(3,staff);
		pstmt1.setString(4,locn_type);
		pstmt1.setString(5,locn_type);
		pstmt1.setString(6,facilityId);
		pstmt1.setString(7,locn_type);
		pstmt1.setString(8,locn_type);
		pstmt1.setString(9,facilityId);
		pstmt1.setString(10,role_type);
		pstmt1.setString(11,staff);
		rs1 = pstmt1.executeQuery();
		while(rs1!=null  && rs1.next()){
			record_Count1 =rs1.getInt(1);
			 record_Count = record_Count+record_Count1;
		}
		 if(pstmt1 != null)
			 pstmt1.close();
		 if(rs1 != null)
			 rs1.close();
	 
	 if(record_Count>0)
	  {
	%>
		<table border='1' cellpadding='0' cellspacing='0' align='center' width="90%">
			<tr>
				<th align='left' width='20%'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
				<th align='left' width='30%'>
				<fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/></th>
				<th align='center' width='15%'><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/> *</th>
				<th align='center' width='15%'><fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}"/></th>
				<th align='center' width='10%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
			</tr>
		<%
		//String sql1 ="select b.short_desc locn_type_desc, a.workplace_code, c.workplace_desc workplace_desc,to_char(a.eff_date_from,'dd/mm/yyyy') eff_date_from,to_char(a.eff_date_to,'dd/mm/yyyy') eff_date_to,a.eff_status eff_status, 'U' db_action from rs_staff_for_workplace a, am_care_locn_type b, rs_workplace c where a.facility_id =? and a.role_type =? and a.staff_id = ? and c.facility_id = a.facility_id and  c.workplace_code = a.workplace_code and b.locn_type(+) = c.locn_type and ( ? is null or c.locn_type = ?) union all select b.short_desc locn_type_desc, a.workplace_code, a.workplace_desc workplace_desc,	null eff_date_from, null eff_date_to, 'E' eff_status, 'I' db_action from rs_workplace a, am_care_locn_type b where a.facility_id =? and (? is null or a.locn_type = ?) and  a.eff_status = 'E' and b.locn_type(+) = a.locn_type and (a.facility_id,workplace_code) not in (select facility_id,workplace_code from rs_staff_for_workplace where facility_id =? and role_type = ? and staff_id =?)order by locn_type_desc, workplace_desc";
		String sql1 ="select b.short_desc locn_type_desc, a.workplace_code, c.workplace_desc workplace_desc,to_char(a.eff_date_from,'dd/mm/yyyy') eff_date_from,to_char(a.eff_date_to,'dd/mm/yyyy') eff_date_to,a.eff_status eff_status, 'U' db_action from rs_staff_for_workplace a, am_care_locn_type_lang_vw b, rs_workplace_lang_vw c where a.facility_id =? and a.role_type =? and a.staff_id = ? and c.facility_id = a.facility_id and  c.workplace_code = a.workplace_code and c.language_id = ? and b.locn_type(+) = c.locn_type and b.language_id(+) = ? and ( ? is null or c.locn_type = ?) union all select b.short_desc locn_type_desc, a.workplace_code, a.workplace_desc workplace_desc,null eff_date_from, null eff_date_to, 'E' eff_status, 'I' db_action from rs_workplace a, am_care_locn_type b where a.facility_id =? and (? is null or a.locn_type = ?) and  a.eff_status = 'E' and b.locn_type(+) = a.locn_type and (a.facility_id,workplace_code) not in (select facility_id,workplace_code from rs_staff_for_workplace where facility_id =? and role_type = ? and staff_id =?)order by locn_type_desc, workplace_desc";
		//out.println(sql1);
		pstmt = con.prepareStatement(sql1);
		pstmt.setString(1,facilityId);
		pstmt.setString(2,role_type);
		pstmt.setString(3,staff);
		pstmt.setString(4,locale);
		pstmt.setString(5,locale);
		pstmt.setString(6,locn_type);
		pstmt.setString(7,locn_type);
		pstmt.setString(8,facilityId);
		pstmt.setString(9,locn_type);
		pstmt.setString(10,locn_type);
		pstmt.setString(11,facilityId);
		pstmt.setString(12,role_type);
		pstmt.setString(13,staff);
		rs = pstmt.executeQuery();
		while(rs!=null  && rs.next()){
			classValue				=	((rowIndex%2)==0)? "QRYEVEN" : "QRYODD";
			rowIndex++;						
			work_place_desc  =rs.getString("workplace_desc")==null?"":rs.getString("workplace_desc");
			
			workplace_code =rs.getString("workplace_code")==null?"":rs.getString("workplace_code");
			dbaction =rs.getString("db_action")==null?"":rs.getString("db_action");
			locn_type_desc =rs.getString("locn_type_desc")==null?"":rs.getString("locn_type_desc");
			eff_from =rs.getString("eff_date_from")==null?"":rs.getString("eff_date_from");
			if(!eff_from.equals("")){
				SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
				date1=formatter1.parse(eff_from);
				eff_from=com.ehis.util.DateUtils.convertDate(eff_from,"DMY","en",locale);
			 }
			chkunchk =rs.getString("db_action")==null?"":rs.getString("db_action");
			eff_to =rs.getString("eff_date_to")==null?"":com.ehis.util.DateUtils.convertDate(rs.getString("eff_date_to"),"DMY","en",locale);
			eff_status =rs.getString("eff_status")==null?"":rs.getString("eff_status");
			//out.println(date1);
			if(locn_type_desc.equals(""))
				disp_locn="&nbsp;";
			else
	 				disp_locn=locn_type_desc;
			if(work_place_desc.equals(""))
				disp_wrk="&nbsp;";
			else
	 				disp_wrk=work_place_desc;
%>
		 <tr>	
		 <td class='<%=classValue%>'><%=disp_locn%></td>
		 <td class='<%=classValue%>'><%=disp_wrk%></td>
		  <%if(eff_status.equals("E")){
		if(!eff_from.equals("")&&!eff_to.equals(""))
		  {
		 int cnt = date1.compareTo(date2);
		 if(cnt<0)
		 {
		 %>
    	  <td class='<%=classValue%>'><input type=textbox name="text1<%=i%>" id="text1<%=i%>" value="<%=eff_from%>" size='10'  maxlength='10' readonly>
		  <img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('text1<%=i%>')"></td>
		  <td class='<%=classValue%>'><input type=textbox name="text2<%=i%>" id="text2<%=i%>" value="<%=eff_to%>" size='10'  maxlength='10' readonly>
		  <img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('text2<%=i%>')"></td>
			  <%}else
			  {%>
			  <td class='<%=classValue%>'><input type=textbox name="text1<%=i%>" id="text1<%=i%>" value="<%=eff_from%>" size='10'  maxlength='10'onblur='CheckDate(this);chksys1(this);'>
			  <img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('text1<%=i%>')"></td>
			  <td class='<%=classValue%>'><input type=textbox name="text2<%=i%>" id="text2<%=i%>" value="<%=eff_to%>" size='10'  maxlength='10' onblur='CheckDate(this);chksys1(this);'>
			  <img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('text2<%=i%>')"></td>
			 <%
			  }}else{%>
		 <td class='<%=classValue%>'><input type=textbox name="text1<%=i%>" id="text1<%=i%>" value="<%=eff_from%>" size='10'  maxlength='10'onblur='CheckDate(this);chksys1(this);'>
		 <img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('text1<%=i%>')"></td>
		  <td class='<%=classValue%>'><input type=textbox name="text2<%=i%>" id="text2<%=i%>"value="<%=eff_to%>" size='10' maxlength='10' onblur='CheckDate(this);chkfrto(text1<%=i%>,this);'>
		  <img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('text2<%=i%>')"></td>
			 <%}}else{%>
			<td class='<%=classValue%>'><input type=textbox name="text1<%=i%>" id="text1<%=i%>" value="" size='10'  maxlength='10'onblur='CheckDate(this);chksys1(this);'>
			<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('text1<%=i%>')"></td>
			<td class='<%=classValue%>'><input type=textbox name="text2<%=i%>" id="text2<%=i%>"value="" size='10' maxlength='10' onblur='CheckDate(this);chkfrto(text1<%=i%>,this);'>
			<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('text2<%=i%>')"></td>

			 <%}
			 if(chkunchk.equals("U") && eff_status.equals("E"))
			 {
			  dochkunchk ="checked";
			 }
		 else 
			 {
			 dochkunchk="";
			 }if(eff_status.equals("E"))
		 {%>
		
		 <td class='<%=classValue%>' align='center'><input type=checkbox name="select<%=i%>" id="select<%=i%>" value="" <%=dochkunchk%> onclick='return oncheck(this);' <%=dbcheck%>> </td>
			 <%}else{%>
		 
		 <td class='<%=classValue%>' align='center'><input type=checkbox name="select<%=i%>" id="select<%=i%>" value="" <%=dochkunchk%> onclick='return oncheck(this);' <%=dbcheck%>> </td>
			 <%}%>
		 </tr>
			 
			 <input type='hidden' name='eff_fro<%=i%>' id='eff_fro<%=i%>' value=''>
			 <input type='hidden' name='eff_to<%=i%>' id='eff_to<%=i%>' value=''>
			 <input type='hidden' name='chkd<%=i%>' id='chkd<%=i%>' value=''> 
			 <input type='hidden' name='workplace_code<%=i%>' id='workplace_code<%=i%>' value='<%=workplace_code%>'>
			 <input type='hidden' name='db_action<%=i%>' id='db_action<%=i%>' value='<%=dbaction%>'>
			 <input type='hidden' name='eff_status<%=i%>' id='eff_status<%=i%>' value=''>
			
		 <%
			 i++;
		 }
		 if(pstmt != null)
			 pstmt.close();
		 if(rs != null)
			 rs.close();

	  }
	else
		  {%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script> 
		<%}
		
	  String sel_SType = "";
	  if(role_type.equals("P"))
	   sel_SType = "SELECT pract_type FROM AM_PRACTITIONER WHERE  PRACTITIONER_ID = ?";
	   else
	    sel_SType = "SELECT other_staff_type FROM AM_OTHER_STAFF WHERE  OTHER_STAFF_ID = ?";

	  pstmt2 = con.prepareStatement(sel_SType);
	  pstmt2.setString(1,staff);
		rs2 = pstmt2.executeQuery();
		while((rs2!=null)&&(rs2.next())) {
		staff_type  =rs2.getString(1);
	  }
		 if(pstmt2 != null)
			 pstmt2.close();
		 if(rs2 != null)
			 rs2.close();
		%>
			 <input type='hidden' name='staff_type' id='staff_type' value='<%=staff_type%>'>
			<input type=hidden name ="record_Count" value='<%=record_Count%>'>
			<input type=hidden name ="staff" value='<%=staff%>'>
			<input type=hidden name ="role_type" value='<%=role_type%>'>
			<input type=hidden name ="sysdate" value='<%=sysdate%>'>
			<input type=hidden name ="mode" value='2'>
		<%
  }catch(Exception e){
	  out.println("Error is--->"+e);
  }
  finally {
  		 if(pstmt4 != null)
			 pstmt4.close();
		 if(rs4 != null)
			 rs4.close();
		 if(pstmt2 != null)
			 pstmt2.close();
		 if(rs2 != null)
			 rs2.close();
		 if(pstmt1 != null)
			 pstmt1.close();
		 if(rs1 != null)
			 rs1.close();
		 if(pstmt != null)
			 pstmt.close();
		 if(rs != null)
			 rs.close();
	  ConnectionManager.returnConnection(con,request);
}

%> 

	</table>
	</form>
</body>
</html>

