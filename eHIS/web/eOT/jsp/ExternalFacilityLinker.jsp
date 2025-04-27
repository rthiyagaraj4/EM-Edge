<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,eCommon.Common.*" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<head>

	
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	if(sStyle.equals("IeStyle.css"))
	 {
			String imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	String param = request.getQueryString();	
%>

	<title>	
		<fmt:message key="eOT.ExternalFacilityBooking.Label" bundle="${ot_labels}"/>
	</title>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script>	
		async function openCalenderSlot(params)
		{
			var retVal 				= ""
			var dialogHeight 		= "38" ;
			var dialogWidth  		= "50" ;
			var dialogTop    		= "200";
			var dialogLeft			= "100" 
			var center				= "1" ;
			var status 				= "no";
			var arguments			= "";
			
			var features			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; dialogLeft:"+dialogLeft+"; scroll=auto; status:no";
			
			var key = document.forms[0].facility.value;
			if(key == '')
			{
				alert("Please select a facility");
				return;
			}
			var arr = key.split("~");
			
			var URL =	arr[1] 
						+ "/eOT/jsp/CalendarModalFrame.jsp?alternateBooking=Y"
						+ "&menu_id=OT_JAVA_DFLT&module_id=OT&function_id=OT_BOOKING&function_name=Booking&function_type=F&access=NNNNY&desktopFlag=N"
						+ "&facility_id=" + arr[0] 
						+ "&" + params;
			
			// change the file name for the OT Appointment.
			retVal					= await window.showModalDialog(URL,arguments,features);
			
		 
			parent.window.close();  //close the existing o
			
			
		}
		
		function closeWindow()
		{
			parent.window.close();  //close the existing o
		}
	</script>

</HEAD>

<%
		//retrieving Session Attributes
		
		String locale = (String)session.getAttribute("LOCALE");
		String bl_operational = (String)session.getAttribute("bl_operational");
		String facilityid=(String)session.getValue("facility_id");
		String resp_id = (String)session.getValue("responsibility_id"); 
		Properties p=(Properties)session.getValue("jdbc");
		
		String client_ip_address = p.getProperty("client_ip_address");
		String login_user= p.getProperty("login_user");
		//login_user="NAREN";
		
		//Build Param String
		String params = param + "&login_user=" + login_user + "&locale=" + locale + "&sStyle=" + sStyle + "&client_ip_address=" + client_ip_address 
			+ "&bl_operational=" + bl_operational + "&ordering_facility_id=" + facilityid + "&resp_id=" + resp_id; 
		
		HashMap<String,String> facilityMap = new HashMap<String,String>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			//CRF 298 Fetch Site Param and Facility Set up Param
			String alternateFacilityURL  = "select sm_facility_for_user.facility_id, sm_facility_param.facility_name, FACILITY_LOOKUP_URL from sm_facility_for_user, sm_facility_param_lang_vw sm_facility_param "  
			+ "where appl_user_id = ? and language_id = ? and sm_facility_for_user.facility_id = sm_facility_param.facility_id and  NVL(sm_facility_param.FACILITY_LOOKUP_URL,'N') != 'N' " 
			+ "and ( (sm_facility_for_user.ACCESS_EFF_DATE_FROM <= trunc(sysdate)  and sm_facility_for_user.ACCESS_EFF_DATE_TO >= trunc(sysdate) )  or " 
			+ "(sm_facility_for_user.ACCESS_EFF_DATE_FROM <= trunc(sysdate)  and sm_facility_for_user.ACCESS_EFF_DATE_TO is null )  or (sm_facility_for_user.ACCESS_EFF_DATE_TO " 
			+ ">= trunc(sysdate)  and sm_facility_for_user.ACCESS_EFF_DATE_FROM is null)  or (sm_facility_for_user.ACCESS_EFF_DATE_FROM is null   " 
			+ "and sm_facility_for_user.ACCESS_EFF_DATE_TO is null ) ) and  UPPER(sm_facility_param.CURR_DB) != (select UPPER(SUBSTR(CONNECT_STRING,LENGTH(CONNECT_STRING)-" 
			+ "LENGTH(sm_facility_param.CURR_DB)+1,  LENGTH(sm_facility_param.CURR_DB))) from sm_db_info)  intersect " 
			+ "select sm_facility_for_resp.facility_id, facility_name, FACILITY_LOOKUP_URL  from sm_facility_for_resp, sm_facility_param_lang_vw sm_facility_param "   
			+ "where resp_id = 'OT_JAVA_MANAGER'  and sm_facility_for_resp.facility_id = sm_facility_param.facility_id and language_id = ? and " 
			+ "  NVL(sm_facility_param.FACILITY_LOOKUP_URL,'N') != 'N' and   UPPER(sm_facility_param.CURR_DB) != (select UPPER(SUBSTR(CONNECT_STRING,LENGTH(CONNECT_STRING)- " 
			+ "LENGTH(sm_facility_param.CURR_DB)+1, LENGTH(sm_facility_param.CURR_DB))) from sm_db_info) order by 2 ";
			
			String key = null;
			conn = ConnectionManager.getConnection(request);
			pstmt = conn.prepareCall(alternateFacilityURL);
						
			pstmt.setString(1, login_user);
			pstmt.setString(2, locale);
			pstmt.setString(3, locale);
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				key = rs.getString("FACILITY_ID") + "~" + rs.getString("FACILITY_LOOKUP_URL");
				facilityMap.put(key,rs.getString("FACILITY_NAME"));
			}
			
			if(rs!=null)	 
			rs.close();
			if(pstmt!=null)  
			pstmt.close();
		}
		catch(Exception e)
		{
			System.err.println("Err Msg From DiarySheduleSearch.jsp"+e.getMessage());
		}
		finally
		{
			try{
				if(rs!=null)		rs.close();
				if(pstmt !=null)  pstmt.close();
				ConnectionManager.returnConnection(conn,request);
			}catch(Exception e){}
		}	
%>
	<form id='submitForm' target="new">
		<br/>
		<br/>
		
		<table cellpadding=3 cellspacing="0" border="0" width="50%" align="center">
  			 <tr>
				<td class="label" width='30%' nowrap >
					<fmt:message key="eOT.Facility.Label" bundle="${ot_labels}"/>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<select name='facility' id='facility' >
						<option value=''>Select</option>
<%
	for(String key : facilityMap.keySet())
	{
%>						
						<option value='<%=key%>'><%= facilityMap.get(key)  %></option>
<%	
	}
%>
						
					</select>
				</td>
			</tr>
		</table>
		<br/>
		<table cellpadding=3 cellspacing="0" border="0" width="50%" align="center">	
			<tr>
				
				<td class='fields' width='30%' align="center">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type='button' name='OK' id='OK' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick="openCalenderSlot('<%=params%>')"/>
					&nbsp;&nbsp;&nbsp;
					<input type='button' name='Cancel' id='Cancel' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick='javascript:closeWindow()'/>
				</td>
			</tr>
		</table>	
	</form>

</HTML>

