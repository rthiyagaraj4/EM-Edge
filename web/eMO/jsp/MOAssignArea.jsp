<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,com.ehis.util.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");

%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<!--<script language='javascript' src='../../eCommon/js/dchk.js'></script>-->
<script language='javascript' src='../../eCommon/js/common.js'></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
<script language='javascript' src='../../eMO/js/MOManageDeceased.js'></script>
<Script src="../../eCommon/js/DateUtils.js" language="JavaScript"></Script>

<!--<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->

</head>
<body onKeyDown = 'lockKey()' onLoad='clearBed1()' >
<center>
<br>
<form name='MOMDAssgnTmtAreaForm' id='MOMDAssgnTmtAreaForm' method='POST' action="../../servlet/eMO.MOManageDeceasedAssignAreaServlet" target=messageFrame>
<table border='0' cellpadding='0' cellspacing='0' width='95%' align='center'>
	<%
	String locale = ((String)session.getAttribute("LOCALE"));
	String	 facilityId 			= (String) session.getValue( "facility_id" ) ;
	Connection			con		=	null;
	PreparedStatement	pstmt	=	null;
	ResultSet			rs		=	null;
	Statement			stmt	=	null;
	ResultSet			rset	=	null;
	String sqlstr				=	"";	
	String area_code			=	"";
	String short_desc			=	"";
	String select_registration	=	"";
	String select_name			=	"";
	String select_sex			=	"";
	String select_area_desc		=	"";
	String sysdate				=	"";
	String select_pmyn			=	"";
	String assign_area_code		=	"";
	String select_pmstatus		=	"";
	String facility_id			=	"";
	String sys_date				=	"";
	String sys_date_time		=	"";
	String sys_date_converted	=	"";
	String bed_no				=	"";
	String rfid_tag_num				=	"";
	String patient_id          =	"";
	String area_prop			=	"";
	String assignDtime          =   "";
	String area_type            ="";
	String CLAIMANT_TYPE		=""; //Added Aginst Bru-HIMS-CRF-366 [IN-039612]
	String RELEASE_TO_FACILITY  =""; //Added Aginst Bru-HIMS-CRF-366 [IN-039612]
	assign_area_code	=	request.getParameter("assign_area_code");	
	assign_area_code	=	((assign_area_code==null) || (assign_area_code.equals(""))) ? "" : assign_area_code;
	select_registration	=	(request.getParameter("select_registration")==null)? "" : request.getParameter("select_registration");
	select_name			=	(request.getParameter("select_name")==null)? "" : request.getParameter("select_name");
	select_sex			=	(request.getParameter("select_sex")==null)? "" : request.getParameter("select_sex");
	select_area_desc	=	(request.getParameter("select_area_desc")==null)? "" : request.getParameter("select_area_desc");
	select_area_desc	=	java.net.URLDecoder.decode(select_area_desc);
	select_pmyn			=	request.getParameter("select_pmyn");
	select_pmyn			=	((select_pmyn==null) || (select_pmyn.equals(""))) ? "" : select_pmyn;
	select_pmstatus		=	request.getParameter("select_pmstatus");
	select_pmstatus		=	((select_pmstatus==null) || (select_pmstatus.equals(""))) ? "" : select_pmstatus;
	bed_no				=	request.getParameter("bed_no");
	area_type           =(request.getParameter("area_type")==null)? "" : request.getParameter("area_type");
	bed_no				=	((bed_no==null) || (bed_no.equals(""))) ? "" : bed_no;
	patient_id			=	request.getParameter("patient_id");
	patient_id			=	((patient_id==null) || (patient_id.equals(""))) ? "" : patient_id;
	CLAIMANT_TYPE	=	request.getParameter("CLAIMANT_TYPE");	//Added Aginst Bru-HIMS-CRF-366 [IN-039612]
	CLAIMANT_TYPE	=	((CLAIMANT_TYPE==null) || (CLAIMANT_TYPE.equals(""))) ? "" : CLAIMANT_TYPE; //Added Aginst Bru-HIMS-CRF-366 [IN-039612]
	RELEASE_TO_FACILITY	=	request.getParameter("RELEASE_TO_FACILITY");//Added Aginst Bru-HIMS-CRF-366 [IN-039612]
	RELEASE_TO_FACILITY	=	((RELEASE_TO_FACILITY==null) || (RELEASE_TO_FACILITY.equals(""))) ? "" : RELEASE_TO_FACILITY;//Added Aginst Bru-HIMS-CRF-366 [IN-039612]
	try
	{
		con					=	(Connection)ConnectionManager.getConnection(request);
		facility_id			=	(String)session.getValue("facility_id");
		String sql2			=	"select to_char(sysdate,'dd/mm/yyyy hh24:mi')sys_date from dual";
		stmt				=	con.prepareStatement(sql2);
		rset				=	stmt.executeQuery(sql2);
		if(rset!=null && rset.next())
		{
			sys_date=rset.getString(1);
			if(sys_date!=null && !sys_date.equals(""))
				sys_date_converted = DateUtils.convertDate(sys_date,"DMYHM","en",localeName); 	
		}
		stmt.close();
		rset.close();
		StringBuffer sql1	= new StringBuffer();
		sql1.append("select  to_char(ASSIGN_DATE_TIME,'dd/mm/yyyy hh24:mi')ASSIGN_DATE_TIME  from MO_MORTUARY_REGN where REGISTRATION_NO=? and FACILITY_ID =?");
		pstmt				=	con.prepareStatement(sql1.toString());
		pstmt.setString(1,select_registration) ;
		pstmt.setString(2,facility_id) ;
		rs=pstmt.executeQuery();
		if(rs!=null && rs.next())
		sys_date_time	= rs.getString(1);
		sysdate 		= (sys_date_time == null)?"":sys_date_time;
		
		assignDtime=sysdate;

		if(assignDtime!=null && !assignDtime.equals(""))
			assignDtime = DateUtils.convertDate(assignDtime,"DMYHM","en",localeName); 	
		
		sql1.setLength(0);
		pstmt.close();
		rs.close();
		if (sysdate.equals(""))
		{
			sysdate=sys_date;
		}  
		String body_received_date="";
		String ser_desc="";
        
		//sql1.append("select body_received_date,service_desc from mo_mortuary_regn_vw where REGISTRATION_NO =? and FACILITY_ID =?");
		sql1.append("select body_received_date,RFID_TAG_NUM, AM_GET_DESC.AM_SERVICE(SERVICE_CODE,'"+localeName+"','2') service_desc from mo_mortuary_regn_vw where REGISTRATION_NO =? and FACILITY_ID =?");

		pstmt = con.prepareStatement(sql1.toString());
        pstmt.setString(1,select_registration) ;
		pstmt.setString(2,facility_id) ;
		rs=pstmt.executeQuery();
 	    while(rs.next())
		{
		   body_received_date = rs.getString(1);
		   rfid_tag_num			  = rs.getString(2)==null?"":rs.getString(2);
		   ser_desc			  = rs.getString(3);
		}
		sql1.setLength(0);
		pstmt.close();
		rs.close();
		JSONObject json = new JSONObject(); // added by mujafar for ML-MMOH-CRF-0996 start
		json			 = eMO.MOCommonBean.getMOParam(con, facility_id); 
		String enable_rfid_yn = (String)json.get("enable_rfid_yn"); // added by mujafar for ML-MMOH-CRF-0996 end
		%>
		<input type='hidden' name='system_date' id='system_date'        value='<%=sys_date%>'>
		<input type='hidden' name='body_received_date' id='body_received_date' value='<%=body_received_date%>'>
		<tr>
			<th  align="left"><fmt:message key="eMO.RegNo.label" bundle="${mo_labels}"/>:&nbsp;<%=select_registration%></th>
		</tr>
		<tr>
			<td class=label colspan='4'>&nbsp;</td>
		</tr>
		</table>
		<table border='0' cellpadding='0' cellspacing='0' width='95%' align='center'>
	<tr style='height:20px;'>
		<td class='LABEL'  width='25%'><fmt:message key="Common.name.label" bundle="${common_labels}"/> </td>

		<td class='QUERYDATA' width='25%'><%=select_name%></td>
	
		<td class='LABEL'  width='25%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>	
		
		<td class='QUERYDATA' width='25%'><%=select_sex%></td>	
	</tr>

	<tr>
			<td class='LABEL'  ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>

			<td class='QUERYDATA' ><%=ser_desc%></td>
			
			<td class='LABEL' >&nbsp;</td>	

			<td class='QUERYDATA' >&nbsp;</td>	
	</tr>
	
	<tr>
			<td class=label colspan='4'>&nbsp;</td>
	</tr>


	<tr>
			<th align='centert' width='25%' colspan='2'><fmt:message key="Common.current.label" bundle="${common_labels}"/></th>
			<th align='center' width='25%' colspan='2'><fmt:message key="eOP.AssignReAssign.label" bundle="${op_labels}"/></th>
	</tr>
	
	<tr>
			<td class=label colspan='4'>&nbsp;</td>
	</tr>

	<TR>
			<td class='LABEL' width='25%'><fmt:message key="Common.area.label" bundle="${common_labels}"/></td>

			<td class='QUERYDATA'width='25%'><%=select_area_desc%></td>
			<td class='fields' COLSPAN='2'>

				<select name='area_code' id='area_code'  onchange=clearBed();>
				<option value=''>---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----------</option>
		<%	
		if (assign_area_code.equalsIgnoreCase("Unassigned"))
		{
			//Condition Newly Added Against Bru-HIMS-CRF-366 [IN-039612]	
			if (select_pmyn.equalsIgnoreCase("Y") && CLAIMANT_TYPE.equalsIgnoreCase("F")){
				sqlstr	=	"select area_code, short_desc from MO_AREA_LANG_VW where eff_status='E' and facility_id = '"+facilityId+"' and language_id='"+locale+"' order by short_desc";
			}
		else if (select_pmyn.equalsIgnoreCase("Y")){
			sqlstr	=	"select area_code, short_desc from MO_AREA_LANG_VW where eff_status='E' and facility_id = '"+facilityId+"' and language_id='"+locale+"' and Area_Type not in ('R') order by short_desc";
		}
		else if (select_pmyn.equalsIgnoreCase("N"))
		{
		 	sqlstr	=	"select area_code, short_desc from MO_AREA_LANG_VW where eff_status='E' and facility_id = '"+facilityId+"' and language_id='"+locale+"' and Area_Type not in ('P') order by short_desc";
		}
		}else			
		{
			//Condition Newly Added Against Bru-HIMS-CRF-366 [IN-039612]	
			if (select_pmyn.equalsIgnoreCase("Y") && CLAIMANT_TYPE.equalsIgnoreCase("F")){
				sqlstr	=	"select area_code, short_desc from MO_AREA_LANG_VW where eff_status='E' and facility_id = '"+facilityId+"' and language_id='"+locale+"' order by short_desc";
			}
		
		else if (select_pmyn.equalsIgnoreCase("Y")){
			sqlstr	=	"select area_code, short_desc from MO_AREA_LANG_VW where eff_status='E' and facility_id = '"+facilityId+"' and language_id='"+locale+"' and Area_Type not in ('R') order by short_desc";
		}
			else if(select_pmyn.equalsIgnoreCase("N"))
			{
				sqlstr	=	"select area_code, short_desc from MO_AREA_LANG_VW where eff_status='E' and facility_id = '"+facilityId+"' and language_id='"+locale+"' and Area_Type not in ('P') order by short_desc";
			}
		}		
		if ((select_pmstatus.equalsIgnoreCase("E")) || (select_pmstatus.equalsIgnoreCase("C")))
		{
			sqlstr	=	"select area_code, short_desc from MO_AREA_LANG_VW where eff_status='E'  and facility_id = '"+facilityId+"' and language_id='"+locale+"' and Area_Type not in ('P') order by short_desc";
		}
		stmt	=	con.createStatement();
	    rset	=	stmt.executeQuery(sqlstr);
		
		
		while (rset!=null && rset.next())
		{
			area_code=rset.getString("area_code");
			short_desc=rset.getString("short_desc");
			if(assign_area_code.equals(area_code))	
				{
					area_prop	   	= "selected";
				}
				else
				{
					area_prop	    = "";
				}
		%>
		<option value='<%=area_code%>' <%=area_prop%>> <%=short_desc%> </option>
		<%}
			if(rset!=null) rset.close();
		    if(stmt!=null) stmt.close(); 
		%>
		</select>&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>	
		</td>
	</tr>
	
	<tr>
			<td class='LABEL' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>

			<td class='QUERYDATA' align='left'><%=bed_no%></td>

			<input type='hidden' name='old_bed_no' id='old_bed_no' value='<%=bed_no%>'>

		     <td class='fields' COLSPAN='2'>
			<input type='text' name='bed_no' id='bed_no' size='8' disabled maxlength='8'onKeyPress="return CheckForSpecChars(event)" value='<%=bed_no%>'  onBlur='BedCheck();' ><input type=button class=button value='?' name='bed_button' id='bed_button' disabled onClick='searchBed(this,bed_no);' ></td>
	</tr>		

	<tr> 
			<td class='LABEL'  ><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
			<td class='QUERYDATA' ><%=assignDtime%></td>
			<td class='fields' COLSPAN='2'>
		 	<input type='text' name='assign_tmt_area_time' id='assign_tmt_area_time' value='<%=sys_date_converted%>' size='16' maxlength='16' onblur='validateDate2(this);' ><img src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].assign_tmt_area_time.select();return showCalendar('assign_tmt_area_time', null, 'hh:mm' );"style="cursor='hand'">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
			
	</tr>	

<%
if(enable_rfid_yn.equals("Y")) //  added by mujafar for ML-MMOH-CRF-0996
{
%>	
	<tr>
			<td class='LABEL' ><fmt:message key="eMO.RFIDTag.label" bundle="${mo_labels}"/></td>
			<td class='QUERYDATA' id = 'rfidtag' align='left'><%=rfid_tag_num%></td>
			<input type='hidden' name='old_rfidtag' id='old_rfidtag' value='<%=rfid_tag_num%>'>
		     <td class='fields' COLSPAN='2'>
			<input type='text' name='RFID_Tag' id='RFID_Tag' size='20'  maxlength='20' onBlur='blurRFID(this);' value='<%=rfid_tag_num%>' ><input type=button class=button value='?' name='RFID_Tag_button' id='RFID_Tag_button'  onClick='searchRFID(this,RFID_Tag);' ></td>
	</tr>		
<%
}

%>
<!-- 	<tr>
			<td class='LABEL'  align='right' nowrap width='10%'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td align='left'>
			 <input type='checkbox'  name='printcommand' id='printcommand' value='Y' onClick=''  > 
			</td>
			<td align='left'>&nbsp;</td>
	</tr> -->
	<%	
		if(pstmt!=null) pstmt.close();
		if(stmt!=null)   stmt.close();
		if(rs!=null)     rs.close();
		if(rset!=null)   rset.close();
	}
	catch(Exception e)
	{
		out.println("Exception@1: " +e);
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	%>
	<tr><td colspan=8 class=label>&nbsp;</td></tr>
	</table>
	<p align='center'>
	<input type='button' class='BUTTON' name='ok' id='ok'	  value=' <fmt:message key="Common.ok.label" bundle="${common_labels}"/>'   onClick='return assignArea();'>&nbsp;
	<input type='button' class='BUTTON' name='cancel' id='cancel' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='cancelOperation()'>
	</p>
	<br>
		<input type="Hidden" name="registration_no" id="registration_no" value="<%=select_registration%>">
		<input type='hidden' name='sys_date_time' id='sys_date_time'	value='<%=sys_date%>'>
		<input type='hidden' name='facility_id' id='facility_id'		value='<%=facility_id%>'>
		<input type='hidden' name='area_desc' id='area_desc'		value='<%=select_area_desc%>'>
		<input type='hidden' name='patient_id' id='patient_id'		value='<%=patient_id%>'>
		<input type='hidden' name='assignDtime' id='assignDtime'		value='<%=assignDtime%>'>
		<input type='hidden' name='select_pmstatus' id='select_pmstatus'		value='<%=select_pmstatus%>'>
		<input type='hidden' name='area_type' id='area_type'		value='<%=area_type%>'>
		<input type='hidden' name='assign_area_code' id='assign_area_code'		value='<%=assign_area_code%>'>
		<%//Added Against Bru-HIMS-CRF-366 [IN-039612] %>
		<input type='hidden' name='CLAIMANT_TYPE' id='CLAIMANT_TYPE'		value='<%=CLAIMANT_TYPE%>'>
		<input type='hidden' name='RELEASE_TO_FACILITY' id='RELEASE_TO_FACILITY'		value='<%=RELEASE_TO_FACILITY%>'>
	</form>
	</center>
	</body>
	</html>

