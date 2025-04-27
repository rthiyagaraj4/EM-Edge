<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	String p_passing_local_date="";
	String p_module_id		= "AM" ;
	String p_report_id		= "AMBFCYRM" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id		= (String)session.getValue("responsibility_id");
	String locale = (String)session.getAttribute("LOCALE");
		
		if(locale.equals("th"))
		{
			p_passing_local_date="Y";
		}else 
		{
			p_passing_local_date="N";
		}


	Connection con =null;

	Statement stmt=null;
	ResultSet rset=null;
%>
<html>
<HEAD>
<TITLE></TITLE>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../js/SearchPopup.js" language="JavaScript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</HEAD>

<BODY onLoad="Focusing('p_facility'); checkVal('All');" onMouseDown="CodeArrest();" onKeyDown = "lockKey();">
<br>
<br>
<form name="repFacilityRoom" id="repFacilityRoom" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

				<table width='80%' cellPadding="0" cellSpacing="0"  align='center'>

		<tr>
			<td align="right" class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<td colspan='2'><select name='p_facility' id='p_facility' onChange="checkVal(this.value);">
			
				<%
					try
					{
						con = ConnectionManager.getConnection(request);
					stmt=con.createStatement();
					String fid;
					String fname;
					StringBuffer sql1 = new StringBuffer("select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='");
					sql1.append(p_user_name);
					sql1.append("' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '");
					sql1.append(p_resp_id);
					sql1.append("') order by 2 ");			

					rset=stmt.executeQuery(sql1.toString());
					sql1.setLength(0);
					if(rset!=null)
					{
					   while(rset.next())
					   {
						fid=rset.getString("facility_id");
						fname=rset.getString("facility_name");
						if(fid.equals("All"))
						out.println("<option value='"+fid+"'  selected>"+fname+"</option>");
						else
                        out.println("<option value='"+fid+"' >"+fname+"</option>");
					   }
					}
					if(rset!=null) rset.close();
					if(stmt!=null) stmt.close();
					}catch(Exception e) {// out.println(e);
						e.printStackTrace();
					}
					finally
					{
						ConnectionManager.returnConnection(con,request);
					} %>
				</select>
			</td>
			</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
					<tr>
						<td align="center" width="35%">&nbsp;</td>
						<td class="fields" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class="fields" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>

					<tr>
						<td align='right' width='30%' class="label"><fmt:message key="Common.building.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;</td>
						<td width='20%'  ><input type=text  name='p_fm_bldng_code' id='p_fm_bldng_code' size="6" maxlength="6" align="center" onblur='if(this.value !="") open_lookup(this,p_fm_bldng_code,p_fm_bldng)'><input type="hidden" name="p_fm_bldng" id="p_fm_bldng"><input type='button' name='building_fm' id='building_fm' value='?' class='button' onclick='open_lookup(this,p_fm_bldng_code,p_fm_bldng)'>
						</td>
						<td width='40%'> <input type=text  name='p_to_bldng_code' id='p_to_bldng_code' size="6" maxlength="6" align="center"  onblur='if(this.value !="") open_lookup(this,p_to_bldng_code,p_to_bldng)'><input type="hidden" name="p_to_bldng" id="p_to_bldng"><input type='button' name='building_to' id='building_to' value='?' class='button' onclick='open_lookup(this,p_to_bldng_code,p_to_bldng)'>
						</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				
					<tr>
					<td align='right' width='30%' class="label"><fmt:message key="Common.FloorCode.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='20%'  ><input type=text  name='p_fm_floor_code' id='p_fm_floor_code' size="6" maxlength="6" align="center" onblur='if(this.value !="") open_lookup(this,p_fm_floor_code,p_fm_floor)'><input type="hidden" name="p_fm_floor" id="p_fm_floor"><input type='button' name='floor_fm' id='floor_fm' value='?' class='button' onclick='open_lookup(this,p_fm_floor_code,p_fm_floor)'>
					</td>
					<td width='40%'> <input type=text  name='p_to_floor_code' id='p_to_floor_code' size="6" maxlength="6" align="center" onblur='if(this.value !="") open_lookup(this,p_to_floor_code,p_to_floor)'><input type="hidden" name="p_to_floor" id="p_to_floor"><input type='button' name='floor_to' id='floor_to' value='?' class='button' onclick='open_lookup(this,p_to_floor_code,p_to_floor)'>
					</td>
					</tr>
				
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				
							
				<tr>
					<td align='right' width='30%' class="label"><fmt:message key="Common.roomno.label" bundle="${common_labels}"/> &nbsp;</td>
					<td width='20%'  ><input type=text  name='p_fm_room_num' id='p_fm_room_num' size="10" maxlength="10" align="center" onblur='if(this.value !="") open_lookup(this,p_fm_room_num,p_fm_room_num_desc)'><input type="hidden" name="p_fm_room_num_desc" id="p_fm_room_num_desc"><input type='button' name='room_fm' id='room_fm' value='?' class='button' onclick='open_lookup(this,p_fm_room_num,p_fm_room_num_desc)'>
					</td>
					<td width='40%'> <input type=text  name='p_to_room_num' id='p_to_room_num' size="10" maxlength="10" align="center" onblur='if(this.value !="") open_lookup(this,p_to_room_num,p_to_room_num_desc)'><input type="hidden" name="p_to_room_num_desc" id="p_to_room_num_desc"><input type='button' name='room_to' id='room_to' value='?' class='button' onclick='open_lookup(this,p_to_room_num,p_to_room_num_desc)'>
					</td>
				</tr>

								<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				
							
				<tr>
					<td align='right' width='30%' class="label"><fmt:message key="Common.type.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='20%'  ><input type=text  name='p_fm_type' id='p_fm_type' size="1" maxlength="1" align="center" onblur='if(this.value !="") open_lookup(this,p_fm_type,p_fm_type_desc)'><input type="hidden" name="p_fm_type_desc" id="p_fm_type_desc"><input type='button' name='type_fm' id='type_fm' value='?' class='button' onclick='open_lookup(this,p_fm_type,p_fm_type_desc)'>
					</td>
					<td width='40%'> <input type=text  name='p_to_type' id='p_to_type' size="1" maxlength="1" align="center" onblur='if(this.value !="") open_lookup(this,p_to_type,p_to_type_desc)'><input type="hidden" name="p_to_type_desc" id="p_to_type_desc"><input type='button' name='type_to' id='type_to' value='?' class='button' onclick='open_lookup(this,p_to_type,p_to_type_desc)'>
					</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				
				<tr>
					<td align='right' width='30%' class="label"><fmt:message key="Common.Nature.label" bundle="${common_labels}"/>&nbsp;</td>
					<td  width='20%' align="left" colspan='2'>
						<select name='p_nature' id='p_nature'>
						<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
						<option value="E"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
						<option value="D"><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<tr>
					<td align='right' width='30%' class="label" > 
						<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/>&nbsp;
					</td>
					<td  width='20%' align="left" colspan='2'>
						<select name='p_order_by' id='p_order_by'>
						<option value='1,2,3'><fmt:message key="Common.roomno.label" bundle="${common_labels}"/>
						<option value='1,2,4'><fmt:message key="Common.room.label" bundle="${common_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
		</table>
	</td>
</tr>
</table>
<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 	value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
<input type="hidden" name="p_resp_id" id="p_resp_id"		value="<%= p_resp_id %>">
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
<!-- <input type='hidden' name='p_language_id' id='p_language_id' value='<%=locale%>'>
<input type='hidden' name='p_passing_local_date' id='p_passing_local_date' value='<%=p_passing_local_date%>'> -->

</form>
</form>
</BODY>
</HTML>

