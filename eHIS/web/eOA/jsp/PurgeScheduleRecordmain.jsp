<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>        
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script language='javascript' src='../../eOA/js/Purgeschedulerecords.js'></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
	String facilityId = (String) session.getValue( "facility_id" ) ;
%> 

<%
	Connection con = null;
	Statement stmt=null;
	Statement stsql1=null;
	Statement stsql2=null;
	ResultSet rset=null ;
	ResultSet rssql1=null ;
	ResultSet rssql2=null ;
	String datval1 ="";
	//String from_date ="";
	//String to_date ="";
	//String practitioner ="";
	String sysdate="";
    String locale=(String)session.getAttribute("LOCALE");
   // String default_select=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
request.setCharacterEncoding("UTF-8");	


	try
	{
		con=ConnectionManager.getConnection(request);

		
		 
%>
	</head>

	<body onLoad="chgbuttonclr();" OnMouseDown='CodeArrest();' onKeyDown = 'lockKey()'>
		<form name='Purge_schedules' id='Purge_schedules' action='../../servlet/eOA.PurgeScheduleRecordServet' method='post' target='messageFrame'>

		  <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<div>
			<table border='0' cellpadding='0' cellspacing='0' align='center' width='70%'>

			<tr><td colspan='4'>&nbsp;</td></tr>
			<tr>
				<td class='label' width='20%' ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
				<td class='fields' width='30%'>
							<SELECT name='location_type' id='location_type' onChange="javascript:populateLocations(this)" style="width:130">
							<option value=''>-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
								<%
								stmt=con.createStatement();
								rset=stmt.executeQuery( "select locn_type,short_desc,CARE_LOCN_TYPE_IND ,to_char(sysdate,'ddmmyyyyhh24miss') date1,to_char(sysdate,'dd/mm/yyyy') d from am_care_locn_type_lang_vw where SYS_USER_DEF_IND='S' and locn_type in ('C','E','Y') and language_id = '"+locale+"'  order by short_desc ");
									if(rset!=null){
									   while(rset.next()) { %>
											<option value='<%=rset.getString("CARE_LOCN_TYPE_IND")%>'><%=rset.getString("short_desc")%></option>
									<%	datval1 =rset.getString("date1");
										sysdate =rset.getString("d");
										
				
										   
									   }
									}
								%>
							</select>
				<td class='label' width='20%' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
				<td class='fields' width='50%'>
								<!--<select name='location' id='location' onChange="clearDetail();PopPract(this);" >
								<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>			
								</select>-->

								<input type='text' size='25' maxlength='25' name='b_loc_val' id='b_loc_val' value='' onblur="ena_loc_lookup(this);"><input type="hidden" name="location" id="location" ><input type='button' name="b_loc_search" id="b_loc_search" value="?" onClick="open_loc_lookup();" class='button'><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
		</tr>

		<tr><td colspan='4'>&nbsp;</td></tr>

		<tr>							
				
				<td class='label' width='15%' nowrap><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
				<td class='fields' width="30%">	
							<SELECT name='resourceType' id='resourceType' disabled onchange="enable_dsiable_res(this)">
							<option value=''> ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- </option>
							<option value='P' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/> </option>
							<option value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/></option>
							<option value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/> </option>
							<option value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/> </option>
							
						</SELECT><img  src='../../eCommon/images/mandatory.gif' align='center'></img>
				

				<jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name ="from_page" value= "block_lift_cancel" />
				<jsp:param name ="pract_value" value= "" />
				</jsp:include>
				
				<!-- <td class='label' width='15%' nowrap><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
				<td class='fields' width="30%">		
						<input type=text size='25' maxlength='30' name='practitioner_name' id='practitioner_name' onblur="onblurcheck(this,practitioner_name)" disabled><input type='button' name='pract_search' id='pract_search'  disabled value='?' class='button' onClick="callPractSearch(this,practitioner_name);"><input type='hidden' name='practitioner' id='practitioner' value=''><img id='imgpract' src='../../eCommon/images/mandatory.gif' align='center'></img></td>    -->
		</tr>

		<tr><td colspan='4'>&nbsp;</td></tr>

		<tr>
				<td class='label' nowrap ><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
				<td width="30%" class='fields' valign='top'>
				<input type='text'  name='eff_from' id='eff_from' size='10' maxlength='10'  onChange="clearDetail('X')" Onblur='validate_date_from(this,eff_to);'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].eff_from.select();return showCalendar('eff_from');"><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
				
				<td class='label' width='15%' nowrap><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>	
				<td class='fields' width="30%">	
				<input type='text'   name='eff_to' id='eff_to' size='10' maxlength='10'  onChange="clearDetail('X')" Onblur='validate_date_to(this,eff_from);'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].eff_to.select();return showCalendar('eff_to');"><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
		</tr>

		<tr><td colspan='4'>&nbsp;</td></tr>
	
		<tr>
				<TD class="label"  nowrap><fmt:message key="eOA.TimeTableType.label" bundle="${oa_labels}"/></TD>
				<TD class="fields" nowrap >
					<SELECT name='time_table_type' id='time_table_type' >
					<OPTION value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----
					<OPTION value='1'><fmt:message key="Common.Slot.label" bundle="${common_labels}"/></option>
					<OPTION value='2'><fmt:message key="eOA.slab.label" bundle="${oa_labels}"/></option>
					<OPTION value='3'><fmt:message key="Common.FreeFormat.label" bundle="${common_labels}"/></option>
					</SELECT><img  src="../../eCommon/images/mandatory.gif" align='center'></img>
				</td>
				<td colspan='2'></td>
		</tr>

		<tr><td colspan='4'>&nbsp;</td></tr>
		
	</table>

 </div>
	
	<%
				
			

				if(rset  !=null)	rset.close();
				if(rssql1!=null)	rssql1.close();
				if(rssql2!=null)	rssql2.close();
				if(stmt  !=null)	stmt.close();
				if(stsql1!=null)	stsql1.close();
				if(stsql2!=null)	stsql2.close();

			}
				catch(Exception e){
				//out.print(e);
				e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
				}

				finally
				{
					  ConnectionManager.returnConnection(con,request);
		
	}%>

			<input type="hidden" name="P_Facility_id" id="P_Facility_id" value='<%=facilityId%>'></input>
			<input type='hidden' name='locale' id='locale' value='<%=locale%>'></input>   
			<input type='hidden' name='location_code' id='location_code' value=''></input> 
			<input type='hidden' name='function_name' id='function_name' value='delete'></input>
			<input type='hidden' name='sys_date1' id='sys_date1' value='<%=sysdate%>'></input>
			
     </form>
</body><script>document.forms[0].location_type.focus();
document.getElementById("imgpract").style.visibility='hidden'
			</script></script>
</html>

