<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.*,,java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>

<% 
request.setCharacterEncoding("UTF-8");
String locale=(String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<!-- <script language='javascript' src='../../eCommon/js/messages.js'></script> -->
<script language='javascript' src="../js/StaffForWorkplace.js"></script>
<script language='javascript' src= '../../eCommon/js/FieldFormatMethods.js'> </script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js' ></script>
<script language='javascript' src="../js/RSCommon.js"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/dchk.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</script>
<script>
function chkfrto(from,to)
{		var chkfrsys='';
		
		var chk =doDateCheckAlert(document.forms[0].sysdate,to);
		if(chk==false){
			alert(getMessage("TO_DATE_LESS_SYSDATE","RS"));
			chkfrsys ='Y';
			to.select();
			to.focus();
			return false;
		}
		else{
			chkfrsys = '';
		}
		if(chkfrsys==''){
		
			var chk1 =doDateCheckAlert(from,to);
			if(chk1==false){
				alert(getMessage("TO_DT_GR_EQ_FM_DT","RS"));
				to.select();
				to.focus();
				return false;
			}
		}
	}
	function chksys1(obj){
		var chk =doDateCheckAlert(document.forms[0].sysdate,obj);
		if(chk==false){
			alert(getMessage("FROM_DATE_LESS_SYSDATE","RS"));
			obj.select();
			obj.focus();
			return false;
		}
	}
	
	function oncheck(target,i){
			if(target.checked==true){
			eval("document.forms[0].eff_status"+i).value="E";
			target.value="Y";
		}
		else{
			eval("document.forms[0].eff_status"+i).value="D";
			target.value="N";
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
	  ResultSet rs2		      = null;
	  ResultSet rs		      = null;
	  ResultSet rs1		      = null;
	
	  String	facilityId 	  = (String) session.getValue( "facility_id" ) ;
	
	  String staff_type="";
	  String staff_type_desc="";
	  String eff_from="";
	  String eff_to="";
	  String eff_status="";
	  String staff_name="";
	  String classValue="";
	  String chkunchk="";
	  String dochkunchk="";
	  String dbaction="";
	  String staff_id="";
	  String role_type1="";
	  String sysdate="";
	  String dbcheck="";
	  java.util.Date date1 =null;
	  java.util.Date date2 =null;
	  int rowIndex =	1;
	  int i= 0;
	  int record_Count= 0;
	  int record_Count1= 0;
	  try{
		con = ConnectionManager.getConnection(request);
		String sel_Sysdate ="select to_char(sysdate,'dd/mm/yyyy'),sysdate from dual";
		pstmt2 = con.prepareStatement(sel_Sysdate);
		rs2 = pstmt2.executeQuery();
		while(rs2!=null  && rs2.next()){
			sysdate =rs2.getString(1);
			date2 =rs2.getDate(2);
		}
		if(pstmt2 != null)
			pstmt2.close();
		if(rs2 != null)
			rs2.close();
		String mode	   = request.getParameter("mode")==null?"":request.getParameter("mode");
		String workplace_code = request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");
		String role_type = request.getParameter("role_type")==null?"":request.getParameter("role_type");
		String staff = request.getParameter("staff")==null?"":request.getParameter("staff");
		
		
		
		String sqlCount="SELECT count(*)  FROM rs_staff_for_workplace a, am_other_staff_type b,am_pract_type c,am_other_staff d,am_practitioner e WHERE a.facility_id = ? AND a.workplace_code =?   AND (? IS NULL OR a.role_type = ?) AND (? IS NULL OR a.staff_id = ?)AND b.other_staff_type(+) = a.staff_type   AND c.pract_type(+) = a.staff_type AND d.other_staff_id(+) = a.staff_id AND e.practitioner_id(+) = a.staff_id UNION ALL (SELECT count(*) FROM am_pract_for_facility_vw a, am_pract_type b   WHERE a.operating_facility_id = ?AND (? IS NULL OR a.practitioner_id = ?)    AND a.eff_status = 'E' AND b.pract_type = a.pract_type AND a.practitioner_id NOT IN (SELECT staff_id FROM rs_staff_for_workplace WHERE facility_id = ? AND workplace_code = ? AND role_type = 'P')) UNION ALL SELECT count(*) FROM am_other_staff_for_facility c, am_other_staff a,am_other_staff_type b WHERE c.facility_id = ? AND (? IS NULL OR c.other_staff_id = ?) AND a.other_staff_id = c.facility_id AND a.eff_status = 'E'AND b.other_staff_type = a.other_staff_type AND a.other_staff_id NOT IN (SELECT staff_id FROM rs_staff_for_workplace WHERE facility_id =? AND workplace_code = ? AND role_type = 'O')";
		//out.println(sqlCount);
		pstmt1 = con.prepareStatement(sqlCount);
		pstmt1.setString(1,facilityId);
		pstmt1.setString(2,workplace_code);
		pstmt1.setString(3,role_type);
		pstmt1.setString(4,role_type);
		pstmt1.setString(5,staff);
		pstmt1.setString(6,staff);
		pstmt1.setString(7,facilityId);
		pstmt1.setString(8,staff);
		pstmt1.setString(9,staff);
		pstmt1.setString(10,facilityId);
		pstmt1.setString(11,workplace_code);
		pstmt1.setString(12,facilityId);
		pstmt1.setString(13,staff);
		pstmt1.setString(14,staff);
		pstmt1.setString(15,facilityId);
		pstmt1.setString(16,workplace_code);
		rs1 = pstmt1.executeQuery();
		/*System.err.println("facilityId in staffforworkplaceshowstaff.jsp 149--->" +facilityId);
		System.err.println("workplace_code in staffforworkplaceshowstaff.jsp 150--->" +workplace_code);
		System.err.println("role_type in staffforworkplaceshowstaff.jsp 151--->" +role_type);
		System.err.println("staff in staffforworkplaceshowstaff.jsp 152-->" +staff);
		System.err.println("staff in staffforworkplaceshowstaff.jsp 153--->" +staff);
		System.err.println("facilityId in staffforworkplaceshowstaff.jsp 154--->" +facilityId);
		System.err.println("staff in staffforworkplaceshowstaff.jsp 155--->" +staff);
		System.err.println("staff in staffforworkplaceshowstaff.jsp 156--->" +staff);
		System.err.println("facilityId in staffforworkplaceshowstaff.jsp 157--->" +facilityId);
		System.err.println("workplace_code in staffforworkplaceshowstaff.jsp 158--->" +workplace_code);
		System.err.println("facilityId in staffforworkplaceshowstaff.jsp 159--->" +facilityId);
		System.err.println("staff in staffforworkplaceshowstaff.jsp 160--->" +facilityId);
		System.err.println("staff in staffforworkplaceshowstaff.jsp 161--->" +facilityId);
		System.err.println("facilityId in staffforworkplaceshowstaff.jsp 162--->" +facilityId);
		System.err.println("workplace_code in staffforworkplaceshowstaff.jsp 163--->" +workplace_code);*/
		
		
		while(rs1!=null  && rs1.next()){
			
			record_Count1 =rs1.getInt(1);
			 record_Count = record_Count+record_Count1;

		}
		//out.println("record_Count1---in servlet---->" +record_Count1);
		//out.println("record_Count---in servlet---->" +record_Count);
		if(pstmt1 != null)
			pstmt1.close();
		if(rs1 != null)
			rs1.close();
	 if(record_Count>0)  {
		// out.println("record_Count--->" +record_Count);
%>
		<table border='1' cellpadding='0' cellspacing='0' align='center' width="90%">
			<tr>
				<th align='left' width='15%'><fmt:message key="Common.RoleType.label" bundle="${common_labels}"/></th>
				<th align='left' width='25%'><fmt:message key="Common.name.label" bundle="${common_labels}"/></th>
				<th align='left' width='20%'><fmt:message key="Common.type.label" bundle="${common_labels}"/></th>
				<th align='center' width='20%'><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/>* </th>
				<th align='center' width='20%'><fmt:message key="Common.EffectiveTo.label"  bundle="${common_labels}"/></th>
				<th align='center' width='10%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
			</tr>
<%
		String sql1 ="select a.facility_id, a.workplace_code,a.role_type role_type,a.staff_id, a.staff_type,nvl(b.short_desc,c.desc_userdef) staff_type_desc, nvl(d.other_staff_name,e.practitioner_name)staff_name, to_char(a.eff_date_from,'dd/mm/yyyy') eff_date_from, to_char(a.eff_date_to,'dd/mm/yyyy') eff_date_to, a.eff_status eff_status, 'U' db_action from rs_staff_for_workplace a, am_other_staff_type b, am_pract_type c, am_other_staff d, am_practitioner e where a.facility_id = ? and a.workplace_code = ? and (? is null or a.role_type = ?) and (? is null or a.staff_id = ?) and b.other_staff_type(+) = a.staff_type and c.pract_type(+) = a.staff_type and d.other_staff_id(+) = a.staff_id and e.practitioner_id(+) = a.staff_id union all (select ? facility_id,? workplace_code,'P' role_type,a.practitioner_id staff_id, a.pract_type staff_type, b.desc_userdef staff_type_desc,a.practitioner_name staff_name, null eff_date_from, null eff_date_to, 'E' eff_status, 'I' db_action from am_pract_for_facility_vw a, am_pract_type b where a.operating_facility_id =  ? and (? is null or a.practitioner_id = ?)and a.eff_status = 'E' and b.pract_type = a.pract_type and a.practitioner_id not in (select staff_id from  rs_staff_for_workplace where facility_id = ? and  workplace_code = ? and role_type = 'P') union all select ?  facility_id,? workplace_code,'O' role_type, a.other_staff_id staff_id, a.other_staff_type staff_type, b.short_desc staff_type_desc, a.other_staff_name staff_name, null eff_date_from, null eff_date_to, 'E' eff_status, 'I' db_action from am_other_staff_for_facility c, am_other_staff a, am_other_staff_type b where c.facility_id = ? and (?  is null or c.other_staff_id = ?) and a.other_staff_id = c.other_staff_id and a.eff_status = 'E' and b.other_staff_type = a.other_staff_type and a.other_staff_id not in  (select staff_id from rs_staff_for_workplace 	  where facility_id =? and workplace_code = ?  and role_type = 'O')) order by role_type,staff_name";
		pstmt = con.prepareStatement(sql1);
		pstmt.setString(1,facilityId);
		pstmt.setString(2,workplace_code);
		pstmt.setString(3,role_type);
		pstmt.setString(4,role_type);
		pstmt.setString(5,staff);
		pstmt.setString(6,staff);
		pstmt.setString(7,facilityId);
		pstmt.setString(8,workplace_code);
		pstmt.setString(9,facilityId);
		pstmt.setString(10,staff);
		pstmt.setString(11,staff);
		pstmt.setString(12,facilityId);
		pstmt.setString(13,workplace_code);
		pstmt.setString(14,facilityId);
		pstmt.setString(15,workplace_code);
		pstmt.setString(16,facilityId);
		pstmt.setString(17,staff);
		pstmt.setString(18,staff);
		pstmt.setString(19,facilityId);
		pstmt.setString(20,workplace_code);
		rs = pstmt.executeQuery();
		while(rs!=null  && rs.next()){
			classValue=	((rowIndex%2)==0)? "QRYEVEN" : "QRYODD";
			rowIndex++;
			
			staff_name =rs.getString("staff_name");
			
			role_type =rs.getString("role_type");
			staff_id =rs.getString("staff_id");
			dbaction =rs.getString("db_action");
			//out.println("dbaction--- in staffforworkplaceshowstaff.jsp--"+dbaction);
			if(staff_id==null)staff_id="";
			if(role_type==null)role_type="";
			if(role_type.equals("P"))
				role_type1 ="Practitioner";
			else
				role_type1 ="Other Staff";

			if(staff_name==null)staff_name="";
			if(dbaction==null)dbaction="";
			staff_type_desc =rs.getString("STAFF_TYPE_DESC");
			staff_type =rs.getString("staff_type");
			if(staff_type_desc==null)staff_type_desc="";
			if(staff_type==null)staff_type="";
			eff_from =rs.getString("eff_date_from");
			if(eff_from==null)eff_from="";
			if(!eff_from.equals("")){
				SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
				date1=formatter1.parse(eff_from);
				eff_from=com.ehis.util.DateUtils.convertDate(eff_from,"DMY","en",locale);
			 }
			eff_status =rs.getString("eff_status");
			if(eff_status==null)eff_status="";
			chkunchk =rs.getString("db_action");
			eff_to =rs.getString("eff_date_to");
			if(eff_to==null) eff_to=""; else eff_to=com.ehis.util.DateUtils.convertDate(eff_to,"DMY","en",locale);
			if(chkunchk==null)chkunchk="";
%>
		 <tr>	
		 <td class='<%=classValue%>'><%=role_type1%></td>
		 <td class='<%=classValue%>'><%=staff_name%></td>
		 <td class='<%=classValue%>'><%=staff_type_desc%></td>
<%
		if(eff_status.equals("E")){
			//System.err.println("if eff_status is E-->" +eff_status);
			if(!eff_from.equals("")&&!eff_to.equals("")) {

				 int cnt = date1.compareTo(date2);
				 if(cnt<0){
			
%>
				  <td class='<%=classValue%>'><input type=textbox name="text1<%=i%>" id="text1<%=i%>" value="<%=eff_from%>" size='10'  maxlength='10' readonly>
				  <img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('text1<%=i%>')"></td>
<%
				}
				else{
%>
					<td class='<%=classValue%>'><input type=textbox name="text1<%=i%>" id="text1<%=i%>" value="<%=eff_from%>" size='10'  maxlength='10'onblur='CheckDate(this);chksys1(this);'>
					<img' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('text1<%=i%>')"></td>
<%
				}
			}
			else{
%>
				<td class='<%=classValue%>'><input type=textbox name="text1<%=i%>" id="text1<%=i%>" value="<%=eff_from%>" size='10'  maxlength='10'onblur='CheckDate(this);chksys1(this);'>
				<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('text1<%=i%>')"></td>
<%
			 }
%>
			<td class='<%=classValue%>'><input type=textbox name="text2<%=i%>" id="text2<%=i%>"value="<%=eff_to%>" size='10' maxlength='10' onblur='CheckDate(this);chkfrto(text1<%=i%>,this);'>
			 <img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('text2<%=i%>')"></td>
<%
		}
		else{
%>
			 <td class='<%=classValue%>'><input type=textbox name="text1<%=i%>" id="text1<%=i%>" value="" size='10'  maxlength='10'onblur='CheckDate(this);chksys1(this);'>
			 <img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('text1<%=i%>')"></td>
			 <td class='<%=classValue%>'><input type=textbox name="text2<%=i%>" id="text2<%=i%>"value="" size='10' maxlength='10' onblur='CheckDate(this);chkfrto(text1<%=i%>,this);'>
			 <img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('text2<%=i%>')"></td><%
		 }
		 if(chkunchk.equals("U") && eff_status.equals("E")){
			dochkunchk ="checked";
		}
		else{
			 dochkunchk="";
		}
		if(eff_status.equals("E")){
%>
			 <input type='hidden' name='eff_status<%=i%>' id='eff_status<%=i%>' value='E'>
			 <td class='<%=classValue%>' align='center'><input type=checkbox name="select<%=i%>" id="select<%=i%>" value="" <%=dochkunchk%> onclick='return oncheck(this,<%=i%>);' <%=dbcheck%>> </td>
<%
		}
		else{
%>
			 <input type='hidden' name='eff_status<%=i%>' id='eff_status<%=i%>' value=''>
			 <td class='<%=classValue%>' align='center'><input type=checkbox name="select<%=i%>" id="select<%=i%>" value="" <%=dochkunchk%> onclick='return oncheck(this,<%=i%>);' <%=dbcheck%>> </td>
<%
		}
%>
	 </tr>
		 <input type='hidden' name='eff_fro<%=i%>' id='eff_fro<%=i%>' value=''>
		 <input type='hidden' name='eff_to<%=i%>' id='eff_to<%=i%>' value=''>
		 <input type='hidden' name='chkd<%=i%>' id='chkd<%=i%>' value=''> 
		 <input type='hidden' name='role_type<%=i%>' id='role_type<%=i%>' value='<%=role_type%>'>
		 <input type='hidden' name='staff_id<%=i%>' id='staff_id<%=i%>' value='<%=staff_id%>'>
		 <input type='hidden' name='staff_type<%=i%>' id='staff_type<%=i%>' value='<%=staff_type%>'>
		 <input type='hidden' name='db_action<%=i%>' id='db_action<%=i%>' value='<%=dbaction%>'>
		 
 <%
		  i++;
	}
	if(pstmt != null)
		pstmt.close();
	if(rs != null)
		rs.close();
	}
	else{
%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
		</script> 
<%
	}
%>
			
		<input type=hidden name ="record_Count" value='<%=record_Count%>'>
	
		<input type=hidden name ="workplace_code" value='<%=workplace_code%>'>
		<input type=hidden name ="sysdate" value='<%=sysdate%>'>
		<input type=hidden name ="mode" value='<%=mode%>'>
		<input type='hidden' name='facility' id='facility' value='<%=facilityId%>'>
<%
	}
	catch(Exception e){
		e.printStackTrace() ;
		throw e ;
  }
  finally{
	 if(pstmt != null)
		 pstmt.close();
	 if(rs != null)
		 rs.close();
	 if(pstmt1 != null)
		 pstmt1.close();
	 if(rs1 != null)
		 rs1.close();
	 if(pstmt2 != null)
		 pstmt2.close();
	 if(rs2 != null)
		 rs2.close();
	  ConnectionManager.returnConnection(con,request);
  }
%> 
	</table>
	</form>
</body>
</html>

