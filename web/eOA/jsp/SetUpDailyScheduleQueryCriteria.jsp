<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.text.*, java.net.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<head>

 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"> </script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="javascript" src="../../eOA/js/SetUpDailySchedule.js"></script>
<script language="javascript" src="../../eOA/js/Scheduling.js"></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>





<%
			
			Connection con=null ;
		//	ResultSet rssql1=null;
		//	ResultSet rssql2=null;
			ResultSet rsLoc=null;
	//		ResultSet rs=null;
			ResultSet rs1=null;
			

try {
			request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
			String fmode = request.getParameter("mode") ;
			if( fmode == null) fmode="";
			String ftype = request.getParameter("type") ;
			if( ftype == null) ftype="";
			con = ConnectionManager.getConnection(request); 
		//	Statement stsql1=con.createStatement();
	//		Statement stsql2=con.createStatement();
			Statement stmtn=con.createStatement();
	//		Statement stmt=con.createStatement();
			Statement stmt1=con.createStatement();
			String short_desc="";
			String clinic_type="";
			String sysdate="";
			String D_no="";
			String day_week="";
			 String locale=(String)session.getAttribute("LOCALE");
			sysdate = request.getParameter("sysdate");
			if(sysdate == null) sysdate = "" ;
			

		rsLoc = stmtn.executeQuery("Select Locn_Type, Short_Desc, care_locn_type_ind from am_care_locn_type_lang_vw where sys_user_def_ind = 'S' and locn_type in ('C','E','Y') and language_id = '"+locale+"' order by 2");
	
		/*
			Commented this query for PE by Suresh M on 24/06/2010
			This query is merged in SetUpDailySchedule.jsp

			rs=stmt.executeQuery("select to_char(sysdate,'dd/mm/yyyy')dat_val1 from dual");
			rs.next();
			sysdate=rs.getString("dat_val1");  
		*/
	
%>
<script>




function DateCheck(obj,obj1)
{
	if(obj1.value!="")
	{
	if(!validDateObj(obj1,"DMY",localeName))
		{
			obj1.value="";
			return ;
		}

		var obj2=convertDate(obj1.value,"DMY",localeName,"en");
		if(isBefore(obj,obj2,'DMY','en')==false)/*localeName is changed to en by Rameswar on 20-Nov-15 for Leap Year issue*/
				{
				alert(getMessage("SCH_GR_TODAY","OA"));
				obj1.value="";
				obj1.select();	
				return false;
			}
			
	}
}
	
		
</script>
</head>
	<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()';>
	<form name='Set_daily_sch_criteria' id='Set_daily_sch_criteria'  target='messageFrame'>

<table border=0 align='center' width="80%" cellpadding=0 cellspacing=0>

	<tr><th colspan='4' align=left><fmt:message key="Common.QueryCriteria.label" bundle="${common_labels}"/></th></tr>
	<tr>
				<TD colspan='4' align=left>&nbsp;</TD>
	</tr>
	<TR>
				<TD class="label" width='25%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'>
						<SELECT name='care_locn_type_ind' id='care_locn_type_ind' width='10'>
						<option>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------
						<%
						while (rsLoc.next()) 
						{
							short_desc=rsLoc.getString("short_desc");
							clinic_type=rsLoc.getString("care_locn_type_ind");
						%>
							<option value='<%=clinic_type%>'><%=short_desc%>
						<%}%>		
						</select></TD>
				
				<TD class="label" width='25%' ><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'>
						<input type='text' name='clinic_code' id='clinic_code' size=4 maxLength=4></TD>
	</TR>
				
				<tr><TD colspan='4' class='fields'></TD></tr>

	<TR>
			
				<TD class="label"  ><fmt:message key="Common.Location.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'>
						<input type='text' name='clinic_desc' id='clinic_desc' size=15 maxLength=15></TD>
				
				<TD class="label" ><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'>
						<SELECT name='resourceType' id='resourceType'  >
							<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
							<option value='P' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/> </option>
							<option value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/></option>
							<option value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/> </option>
							<option value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/> </option>
							</SELECT></TD>
	</TR>

			<tr><TD colspan='4' class='label'></TD></tr>

	<TR>
			
				<TD class="label"  ><fmt:message key="Common.resourceid.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'>
							<input type='text' name='practitioner_id' id='practitioner_id' size=15 maxLength=15></TD>
				
				<TD class="label" ><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'>
							<input type='text' name='practitioner_name' id='practitioner_name' size=30 maxLength=30></TD>
	</TR>

			<tr><TD colspan='4' class='label'></TD></tr>

			<TR>
			
					<%if(ftype.equals("")) { %>
				
				<TD class="label"  ><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'>
							<input type='text'  name='clinic_date' id='clinic_date' size='10' maxLength='10' Onblur="DateCheck('<%=sysdate%>',this)"><input type="image" src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].clinic_date.select();return showCalendar('clinic_date',null); "><img src="../../eCommon/images/mandatory.gif" align='center'></img></TD>
				<%}else{%>
				<TD class ="label" ><fmt:message key="Common.day.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></TD>
				<td class='fields'>
							<SELECT name='day_code' id='day_code'   >	
							<OPTION value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
							<%
								rs1=stmt1.executeQuery("select day_no,day_of_week from sm_day_of_week order by 1");
								
								while (rs1.next()) 
						{
							D_no=rs1.getString("day_no");
							day_week=rs1.getString("day_of_week");

							if(day_week.equals("MONDAY"))
								{
									day_week=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(day_week.equals("TUESDAY"))
								{
									day_week=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(day_week.equals("WEDNESDAY"))
								{
									day_week=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(day_week.equals("THURSDAY"))
								{
									day_week=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(day_week.equals("FRIDAY"))
								{
									day_week=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(day_week.equals("SATURDAY"))
								{
									day_week=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(day_week.equals("SUNDAY"))
								{
									day_week=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}
						%>
							<option value='<%=D_no%>'><%=day_week%>
						<%}%>		
						</select></TD>
							
							
							
				<%}%> 
				<TD class="label" ><fmt:message key="eOA.TimeTableType.label" bundle="${oa_labels}"/></td>
				<td class='fields' width='25%'>
							<SELECT name='time_table_type' id='time_table_type'   >
							<OPTION value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
							<OPTION value='1'><fmt:message key="Common.Slot.label" bundle="${common_labels}"/></option>
							<OPTION value='2'><fmt:message key="eOA.slab.label" bundle="${oa_labels}"/></option>
							<OPTION value='3'><fmt:message key="Common.FreeFormat.label" bundle="${common_labels}"/></option>
							</SELECT></TD>

	</TR>

			<%if(!ftype.equals("")) { %>

			<tr><TD colspan='4' class='label'></TD></tr>
	<tr>
				<TD class="label"  ><fmt:message key="eOA.RosterRequired.label" bundle="${oa_labels}"/></TD>
				<td class='fields' width='25%'>
							<SELECT name='phys_roster_reqd_yn' id='phys_roster_reqd_yn'   >
							<OPTION value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
							<OPTION value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
							<OPTION value='N'><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
						
							</SELECT></TD>

				<td class='label' colspan='2'>&nbsp;</td>
			
	</tr>
			<%}%> 
</table>
		</p>
			
	<table width='80%' align='center'>
		<th width='20%' align='left'><fmt:message key="Common.SortOrder.label" bundle="${common_labels}"/></td>
		<tr><td  width='60%' >
		<p  title='Sort Order'>
				<table width='100%'>
							<td nowrap align='center'><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
							<td>&nbsp;</td>
							<td nowrap align='center'><b><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
					<tr>	<td nowrap width='45%'  align='center'>
									<select name='orderbycols' id='orderbycols' size='5' >
										<option value='resource_class'><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/></option><
										option value='clinic_code'><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></option>
										<option value='clinic_name'><fmt:message key="Common.LocationDescription.label" bundle="${common_labels}"/></option>
										<option value='practitioner_id'><fmt:message key="Common.resourceid.label" bundle="${common_labels}"/></option>
										<option value='practitioner_name'><fmt:message key="Common.resourcename.label" bundle="${common_labels}"/></option>
										<option value='day_no'><fmt:message key="eOA.DayCode.label" bundle="${oa_labels}"/></option>
										<option value='time_table_type'><fmt:message key="eOA.TimeTableType.label" bundle="${oa_labels}"/></option>
										</select>
										</td>
							<td align='center' width='3%' >
								<input type='button' name='add' id='add' class='button' onclick='addOrderByCol()' value='---->'> <input type='button' name='add' id='add' class='button'  value='<----' onclick='removeOrderByCol()'></img></td>
								<td nowrap width='45%' align='center'>
								<select name='orderbycolumns' id='orderbycolumns' size='5' multiple='true'>
								<option value='care_locn_type_ind'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></option>
								</select>
								</td>
					</tr>
			 </table>
				</p>
				</td>
		</tr>
</table>
					<br>
					<table border='0' width='100%' align='center'>
						<tr><td nowrap width='100%' align='center' class='white'>
						<input type='button' name='ExecuteQuery' id='ExecuteQuery' class='Button' onclick='execQuery()' Value='<fmt:message key="Common.Execute.label" bundle="${common_labels}"/>'>
						</td></tr>
					</table>
			<input type="hidden" name="function_mode" id="function_mode" value="modify">
			<input type='hidden' name='cur_dt' id='cur_dt' value="<%=sysdate%>">
			<input type='hidden' name='f_type' id='f_type' value="<%=ftype%>">
	</form>
</body>		
	<% 
	//	if(rssql1 !=null) rssql1.close();
	//	if(rssql2 !=null) rssql2.close();
		if(rsLoc !=null)rsLoc.close();
	//	if(rs !=null) rs.close();
		if(rs1 !=null) rs1.close();
	//	if(stsql1 !=null) stsql1.close();
	//	if(stsql2 !=null) stsql2.close();
		if(stmtn !=null) stmtn.close();
	//	if(stmt !=null) stmt.close();
		if(stmt1 !=null) stmt1.close();
	} catch (Exception e) {e.printStackTrace();}
	finally
		{
			ConnectionManager.returnConnection(con,request);
		}

%>
</html>

