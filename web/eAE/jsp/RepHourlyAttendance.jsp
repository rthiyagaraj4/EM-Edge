<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
    request.setCharacterEncoding("UTF-8");
	String p_module_id		= "AE" ;
	String p_report_id		= "AEBHRATT" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale						= (String)session.getAttribute("LOCALE");
    Connection con			= null;
	PreparedStatement pstmt = null;
	PreparedStatement stmt	= null;
	ResultSet rs			= null ;
	ResultSet rset			= null ;
	String currdate			= "";
	
	//Added by Ashwini on 28-Jun-2018 for ML-MMOH-CRF-0893
	Boolean isLocTrmtAreaPriorityZoneAppl = false; 

	try{
		con = ConnectionManager.getConnection(request);

		/*Added by Ashwini on 28-Jun-2018 for ML-MMOH-CRF-0893*/
	    isLocTrmtAreaPriorityZoneAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","HOURLY_ATTDNC_CRITERIA");

		JSONArray PriorityZoneJsonArr = new JSONArray();
		PriorityZoneJsonArr  = eAE.AECommonBean.getPriorityZoneList(con,locale,p_facility_id);
		/*End ML-MMOH-CRF-0893*/

try {
		String sql = "Select  to_char(sysdate,'dd/mm/yyyy') sys_date from dual";
		  pstmt = con.prepareStatement(sql);
	      rs    = pstmt.executeQuery();
	      if( rs != null )
	      {
	          while( rs.next())
	          {
	        	currdate = rs.getString("sys_date") ;
			  }
		  }			
   if (rs    != null)    rs.close();
   if (pstmt != null) pstmt.close();

	} catch(Exception e) {  e.printStackTrace();}

%>
<html>
<HEAD>
<TITLE></TITLE>
<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eAE/js/AERepHourlyAttendance.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<!--Added by Ashwini on 28-Jun-2018 for ML-MMOH-CRF-0893-->
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<BODY onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>

<form name="RepHourlyAttendance" id="RepHourlyAttendance" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="80%" class="Border" align='center'>

				<table width='80%' cellPadding="0" cellSpacing="0" align='center' border=0>

					
					<tr>
					<td  class="label" width="25%"> <fmt:message key="Common.facility.label" bundle="${common_labels}"/> </td>
					<td width="25%"> 
							<select name='p_all_facility_id' id='p_all_facility_id' >
							<option value='ALL' selected><fmt:message key="Common.AllAccessFacilities.label" bundle="${common_labels}"/></option>
						<%
							try
							{
																			

							String sql_facility="select facility_id, SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID, '"+locale+"', 1) facility_name  from sm_facility_for_user where appl_user_id=?";				

							stmt=con.prepareStatement(sql_facility);
							stmt.setString(1,p_user_name);
							rset=stmt.executeQuery();

							if(rset!=null)
							{
							   while(rset.next())
							   {
								String fid= rset.getString("facility_id");;
								String fname=rset.getString("facility_name");;
								if(fid == null) fid	=	"";
								if(fname == null) fname = "";

								out.println("<option value='"+fid+ "' >"+fname+"</option>");
							   }
							}
							
							if(rset!=null)rset.close();
							if(stmt != null)stmt.close();

							}catch(Exception e)
							{
								//out.println(e);
								e.printStackTrace();
							}
						%>	
						</select>
					</td>
					<td width="25%"></td><td width="25%"></td>
				</tr>
				<tr>
						<td  class='label' width="25%"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
						</td>
						<td width="25%">
							<select name='p_report_flag' id='p_report_flag' onChange="flagChange(this.value)">
							<option value='1'><fmt:message key="Common.daily.label" bundle="${common_labels}"/>
							<option value='2'><fmt:message key="Common.monthly.label" bundle="${common_labels}"/>
							<option value='3'><fmt:message key="Common.Yearly.label" bundle="${common_labels}"/>
							</select>
						</td>
						<td width="25%"></td>
						<td width="25%"></td>
					</tr>
					<tr>
						<td width="25%" ></td>
						<td  width="25%" class='querydata' ><b><fmt:message key="Common.from.label" bundle="${common_labels}"/></b></td>
						<td class='querydata' width="25%" ><b><fmt:message key="Common.to.label" bundle="${common_labels}"/></b></td>
						<td width="25%"></td>
					</tr>
					<tr>
						<td  class='label' id = 'labelid' width="25%"><fmt:message key="Common.date.label" bundle="${common_labels}"/> </td>
						<td width="25%"  id = 'fromid'><input type=text id='hlyattnfrom'  name='p_fm_queue_date' id='p_fm_queue_date' size="10" maxlength="10" onBlur="checkdate(this)" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('hlyattnfrom');" style='cursor:pointer'></img><img src='../../eCommon/images/mandatory.gif'></img> </td>

						<td width="25%"  id = 'toid'><input type=text id='hlyattnto'  name='p_to_queue_date' id='p_to_queue_date' size="10" maxlength="10" onBlur="checkdate(this)" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('hlyattnto');" style='cursor:pointer'></img><img src='../../eCommon/images/mandatory.gif'></img> </td>
						<td width="25%"></td>

				</tr>

				<!--Added by Ashwini on 28-Jun-2018 for ML-MMOH-CRF-0893-->
				<%if(isLocTrmtAreaPriorityZoneAppl){%>

				<tr>
					<td class="label" width="25%"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>

					<td width="25%"><input type="text" name="p_fr_locn_code" id="p_fr_locn_code" size="4" maxlength="4" onBlur='if(this.value != "") searchLocCode(fromlocn,this);clearLocDetail(this);'><input type='button' name='fromlocn' id='fromlocn' value='?' class='button' onclick='searchLocCode(this,p_fr_locn_code);clearLocDetail(this);'>
					</td>

					<td width="25%"></td>
					<td width="25%"></td>
				</tr>

				<tr>
					<td class="label" width="25%"><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>

					<td width="25%"><input type="text" name="p_fr_tmt_area_code" id="p_fr_tmt_area_code" size="4" maxlength="4" onBlur='if(this.value != "") nursCode(fromlocn1,this)'><input type='button' name='fromlocn1' id='fromlocn1' value='?' class='button' onclick='nursCode(this, p_fr_tmt_area_code)'>
					</td>
				
					<td width="25%">
					<input type="text" name="p_to_tmt_area_code" id="p_to_tmt_area_code" size="4" maxlength="4" onBlur='if(this.value != "") nursCode(tolocn1,this)'><input type='button' name='tolocn1' id='tolocn1' value='?' class='button' onclick='nursCode(this, p_to_tmt_area_code)'>
					</td>

					<td width="25%"></td>
				</tr>

				<tr>
					<td class='label' width="25%"><fmt:message key="Common.PriorityZone.label" bundle="${common_labels}"/></td>
						
					<td width="25%">
						<select name='p_priority_zone' id='p_priority_zone'>
							<option value='ALL'><fmt:message key="Common.all.label" bundle="${common_labels}"/>
							<%
								for(int i = 0 ; i < PriorityZoneJsonArr.size() ; i++) 
									{
									JSONObject json	= (JSONObject)PriorityZoneJsonArr.get(i);
									String priority_zone  = (String) json.get("PRIORITY_ZONE");;
									String priority_zone_desc  = (String) json.get("PRIORITY_ZONE_DESC");;
									out.println("<option value='"+priority_zone+ "'>"+priority_zone_desc+"</option>");	
									}		
							%>
						</select>
					</td>
					
					<td width="25%"></td>
					<td width="25%"></td>
				</tr>

				<%}%>
				<!--End ML-MMOH-CRF-0893-->

				<tr>
                <td class='label' height='5'></td>
                <td></td>
				</tr>				
		</table>
	</td>
</tr>
</table>

<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
<input type="hidden" name="p_curr_date" id="p_curr_date"			value="<%= currdate%>">
<input type="hidden" name="locale" id="locale"				value="<%=locale%>">
<input type="hidden" name="p_dflt_fm_date" id="p_dflt_fm_date"		value="01/01/1472">
<input type="hidden" name="p_dflt_to_date" id="p_dflt_to_date"		value="31/12/5000">
<input type="hidden" name="p_date_format" id="p_date_format"		value="dd/mm/yyyy">

<!--Added by Ashwini on 28-Jun-2018 for ML-MMOH-CRF-0893-->
<input type="hidden" name="isLocTrmtAreaPriorityZoneAppl" id="isLocTrmtAreaPriorityZoneAppl" value="<%= isLocTrmtAreaPriorityZoneAppl %>">

</form>
<%
	}catch(Exception e){e.printStackTrace();}
	finally 
	{ 
		if(con!=null)	ConnectionManager.returnConnection(con,request);
	}
%>
<script>document.forms[0].p_all_facility_id.focus();</script>
</body>
</html>

