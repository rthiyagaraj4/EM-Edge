<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<title><fmt:message key="eAE.CreateAttendanceDetails.label" bundle="${ae_labels}"/></title>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script src="../../eAE/js/DisasterPatient.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
 <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/dchk.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
		Connection con							= null;
		PreparedStatement pstmt					= null;
		ResultSet rset							= null ;
		try{
		request.setCharacterEncoding("UTF-8");

		con = ConnectionManager.getConnection(request);
	    String locale			= (String)session.getAttribute("LOCALE");
		String facilityId		= (String)session.getValue("facility_id");
		String loginUser	    = (String)session.getValue("login_user");
		String operstn          = "";

		try{
				String sql="select a.oper_stn_id oper_stn_id from am_oper_stn a, am_user_for_oper_stn b where a.facility_id=? and a.facility_id=b.facility_id and a.oper_stn_id = b.oper_stn_id and b.appl_user_id =? and trunc(sysdate) between b.eff_date_from and  nvl(b.eff_date_to,trunc(sysdate))";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,facilityId);
				pstmt.setString(2,loginUser);
				rset=pstmt.executeQuery();
				if(rset != null && rset.next())
				{
					operstn	 = (rset.getString("oper_stn_id") == null)?"":rset.getString("oper_stn_id");
				}
				if(pstmt != null) pstmt.close();
				if(rset != null) rset.close();


		}catch(Exception e)
		{
				e.printStackTrace();
		}

StringBuffer sqlArrival	 = new StringBuffer();
sqlArrival.append(" select ARRIVAL_CODE,SHORT_DESC from AM_ARRIVAL_LANG_VW ");
sqlArrival.append(" where language_id='"+locale+"'  and facility_id= ? and  eff_status='E' and nvl(eff_date_from,sysdate) >= sysdate ");
sqlArrival.append(" and nvl(eff_date_to,sysdate) <= sysdate order by SHORT_DESC ");

StringBuffer sqlLocation	  = new StringBuffer();
sqlLocation.append(" select a.CLINIC_CODE,a.long_desc SHORT_DESC ");
sqlLocation.append(",c.gender from op_clinic_lang_vw a, (select day_no from ");
sqlLocation.append("sm_day_of_week where day_of_week = ");
sqlLocation.append("rtrim(to_char(sysdate,'DAY'))) b, am_age_group c ");
sqlLocation.append(" where 	 decode(b.day_no,'1',working_day_1,'2',");
sqlLocation.append("	 working_day_2,'3',working_day_3,'4', ");
sqlLocation.append("working_day_4,'5',working_day_5,'6',working_day_6,'7',");
sqlLocation.append("working_day_7)='Y'   and a.facility_id = ? and a.clinic_type  in "+ "(select locn_type ");
sqlLocation.append(" from am_care_locn_type where care_locn_type_ind='C')  ");
sqlLocation.append(" and a.level_of_care_ind = 'Emergency'  ");
sqlLocation.append("and a.eff_status = 'Enabled' ");
sqlLocation.append(" and  (a.clinic_type, a.clinic_code) in ");
sqlLocation.append(" (select locn_type, locn_code from ");
sqlLocation.append(" am_os_user_locn_access_vw ");
sqlLocation.append(" where a.language_id='"+locale+"'  and facility_id = a.facility_id and ");
sqlLocation.append(" register_visit_yn = 'Y')  and ");
sqlLocation.append(" a.age_group_code = c.age_group_code(+)  and c.gender is null and (facility_id,clinic_code) in (select facility_id,locn_code from am_locn_for_oper_stn_vw where facility_id =a.facility_id and oper_stn_id =? )order by 2");  

								  
%>

<body onKeyDown = 'lockKey()'>

<form name='disasterareaform' id='disasterareaform'>
<center>
<br>
<table border='0' cellpadding='0' cellspacing='0' width='97%' class=label align='center'>
<tr><td class=label colspan=2>&nbsp;</td></tr>
<tr>
<td class='label' align='right'><fmt:message key="Common.Location.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
<td class='label' >
<select name='clinic_location' id='clinic_location' onchange="populateVisitType(this)"><option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
<%	
						try {
							
						   pstmt = con.prepareStatement(sqlLocation.toString());
						   pstmt.setString(1,facilityId);
							pstmt.setString(2,operstn);
				           rset = pstmt.executeQuery();						   
						   String code = "";
						   String desc = "";
						   int counter = 1; 
						   //boolean rec_exists=false;
						   while(rset!=null && rset.next())
						   {
							  
								code = rset.getString(1);
								desc = rset.getString(2);
  							if(counter==1){ counter=0;}

%>
								<option value='<%=code%>'><%=desc%></option>
<%
						   }
						}catch (Exception e){}
						finally
						{
							if(pstmt!=null) pstmt.close();
							if(rset!=null)rset.close();
						}
%>
</select>&nbsp;<img id='mandatory' src='../../eCommon/images/mandatory.gif'></img></td></tr>
<tr><td class=label colspan=2>&nbsp;</td></tr>
<tr>
<td class='label' align='right'><fmt:message key="Common.service.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
<td class='label' ><select name='service_code' id='service_code' ><option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option> </select>&nbsp;<img id='mandatory' src='../../eCommon/images/mandatory.gif'></img></select>
</td></tr>
<tr><td class=label colspan=2>&nbsp;</td></tr>
<tr>
<td class=label align='right'><fmt:message key="Common.visittype.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
<td class='label' >
<select name='visit_type' id='visit_type' ><option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option></select>&nbsp;<img id='mandatory' src='../../eCommon/images/mandatory.gif'></img>
</td>
</tr>
<tr>
<td class=label align='right' colspan=2>&nbsp</td></tr>
<tr>
<td class='label' align='right'><fmt:message key="Common.ModeofArrival.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
<td class='label'>
<select name='arrival_mode' id='arrival_mode'><option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
<%
					   try {							
						   
						   pstmt = con.prepareStatement(sqlArrival.toString());
	   					   pstmt.setString(1,facilityId);
					       rset = pstmt.executeQuery();
						   while(rset!=null && rset.next())
						   {
                              out.println("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+" ");
						   }
						  
						   sqlArrival.setLength(0);
						   sqlLocation.setLength(0);

						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
						  
						}
							catch (Exception e) {}
				   %>
</select>&nbsp;<img id='mandatory' src='../../eCommon/images/mandatory.gif'></img>
</td>
</tr>
<tr><td class=label align='right' colspan=2>&nbsp</td></tr>
<tr>
	<td class='LABEL' align='RIGHT' width='15%' nowrap><fmt:message key="Common.ReasonforVisit.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td class='LABEL' align='left' width='30%' colspan='4'>
	<input type='text' name="reasonForVisit_desc" id="reasonForVisit_desc"  value='' maxLength='60' size='60' tabindex='9' onblur="blurgetReasonval(document.forms[0].reasonForVisit,document.forms[0].reasonForVisit_desc);" ><input type=button class=button name='reasonForVisitBut' id='reasonForVisitBut' value='?' onclick="checkTxtVal(document.forms[0].reasonForVisit,document.forms[0].reasonForVisit_desc)" tabindex='10'><input type=hidden name="reasonForVisit" id="reasonForVisit"  >&nbsp;<input type=hidden name="reasonForVisit_desc_hid" id="reasonForVisit_desc_hid" value=''>
</td> 
</tr>
<tr><td class=label colspan=2>&nbsp;</td></tr>
<br>
<tr>
	<td class='white' width='95%'align='right'>&nbsp;</td>
	<td class='white' align='right'>
	<input type=button class=button name='submit_button' id='submit_button' value="OK" onclick="submitValues()">
	<input type=button class=button name='cancel_button' id='cancel_button' value="Cancel" onclick="cancelOperation()">
	</td>
</tr>
<%}
	catch (Exception e) {}
	finally{
		  if(con != null)      ConnectionManager.returnConnection(con,request);
			 
		}
   %>
</table>
</center>
</form>
</body>
</html>

