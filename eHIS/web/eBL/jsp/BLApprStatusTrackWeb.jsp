<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,eBL.*, eBL.Common.*, eCommon.Common.*,webbeans.eCommon.*,com.ehis.util.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<link rel="stylesheet" type="text/css"	href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eIP/js/IPQueryCommon.js' language='javascript'></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script language='javascript' src='../../eBL/js/BLApprStatusTrackSearch.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	String queryString=request.getQueryString();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs =null;
	int i=1;
	String classval = "label";
	String facility_id = request.getParameter("facility_id");
	String machine_id = request.getParameter("strclientip");
	String processid = request.getParameter("user");
	String title = request.getParameter("title");
	String tileValue = request.getParameter("tileValue");
	
%>
<title><%=title%></title>
<body onKeyDown="lockKey();" onMouseDown="CodeArrest();">
<div>
	<table width='100%' align="center" border = "1" style = "border-collapse: collapse;" cellspacing="0">
        <thead>
		  <tr>
            <th class='columnheadercenter'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
            <th class='columnheadercenter'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
            <th class='columnheadercenter'><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/></th>
            <th class='columnheadercenter'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
            <th class='columnheadercenter'><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></th>
          </tr>
		</thead>
<tbody>	
<% 
try
{
	con =  ConnectionManager.getConnection(request);
	String patientId = "";
	String patientName = "";
	String mobileNo = "";
	String encounterId = "";
	String epiType = "";
	String query_interface = "";
	if(tileValue.equals("CC"))
	{
	query_interface = "SELECT a.patient_id,b.patient_name,NVL(b.contact1_no, NVL (b.contact2_no,'') ) mobile_number,a.episode_id,a.episode_type FROM bl_front_desk_data_temp a, mp_patient b WHERE a.patient_id = b.patient_id AND a.processid = '"+processid+"' AND a.machine_id = '"+machine_id+"' AND a.operating_facility_id = '"+facility_id+"' AND encounter_status in ( 'CC', '**') ";
	}
	else if(tileValue.equals("IC"))
	{
	query_interface = "SELECT a.patient_id,b.patient_name,NVL(b.contact1_no, NVL (b.contact2_no,'') ) mobile_number,a.episode_id,a.episode_type FROM bl_front_desk_data_temp a, mp_patient b WHERE a.patient_id = b.patient_id AND a.processid = '"+processid+"' AND a.machine_id = '"+machine_id+"' AND a.operating_facility_id = '"+facility_id+"' AND encounter_status in ('IC', '**') ";
	}
	else if(tileValue.equals("DB"))
	{
	query_interface = "SELECT a.patient_id,b.patient_name,NVL(b.contact1_no, NVL (b.contact2_no,'') ) mobile_number,a.episode_id,a.episode_type FROM bl_front_desk_data_temp a, mp_patient b WHERE a.patient_id = b.patient_id AND a.processid = '"+processid+"' AND a.machine_id = '"+machine_id+"' AND a.operating_facility_id = '"+facility_id+"' AND encounter_status = 'DB' ";
	}
	else if(tileValue.equals("DC"))
	{
	query_interface = "SELECT a.patient_id,b.patient_name,NVL(b.contact1_no, NVL (b.contact2_no,'') ) mobile_number,a.episode_id,a.episode_type FROM bl_front_desk_data_temp a, mp_patient b WHERE a.patient_id = b.patient_id AND a.processid = '"+processid+"' AND a.machine_id = '"+machine_id+"' AND a.operating_facility_id = '"+facility_id+"' AND encounter_status = 'DC' ";
	}

	pstmt = con.prepareStatement(query_interface);		
	rs = pstmt.executeQuery();		
	if(rs != null)
	{
		while(rs.next()){
			patientId = rs.getString("patient_id");
			patientName = rs.getString("patient_name");
			mobileNo = rs.getString("mobile_number");
			encounterId = rs.getString("episode_id");
			epiType = rs.getString("episode_type");
			if(epiType.equals("I"))
			{
			epiType = "IP";
			}
			if(epiType.equals("D"))
			{
			epiType = "DC";
			}
			if(mobileNo == null)
			{
			mobileNo = "";
			}
%>
			
	<tr id=row<%=i%>>
				
				<td id='row<%=i%>_col0' class=<%=classval%> width="30%" class="fields" style="white-space: nowrap">
					<span class="LABEL" name='patientId<%=i%>' id='patientId<%=i%>'><%=patientId%></span> 
				</td>

				<td id='row<%=i%>_col1' class=<%=classval%> width="20%" class="fields"style="white-space: nowrap">
					<span class="LABEL" name='patientName<%=i%>' id='patientName<%=i%>'><%=patientName%></span> 
				</td>

				<td id='row<%=i%>_col2' class=<%=classval%> width="20%" class="fields"style="white-space: nowrap">
					<span class="LABEL" name='mobileNo<%=i%>' id='mobileNo<%=i%>'><%=mobileNo%></span> 
				</td>

				<td id='row<%=i%>_col3' class=<%=classval%> width="20%" class="fields"style="white-space: nowrap">
					<span class="LABEL" name='encounterId<%=i%>' id='encounterId<%=i%>'><%=encounterId%></span> 
				</td>

				<td id='row<%=i%>_col4' class=<%=classval%> width="20%" class="fields"style="white-space: nowrap">
					<span class="LABEL" name='epiType<%=i%>' id='epiType<%=i%>'><%=epiType%></span> 
				</td>
			</tr>
			
 <%
		i++;
		}
	}			
%>
	</tbody>	
<%				
		}
		catch(Exception eX)
		{		
			out.println("Error= "+eX);		
		}
		finally
		{
			if (rs != null)   rs.close();
			if (pstmt != null) pstmt.close();
			if(con!=null) 
			{
				ConnectionManager.returnConnection(con, request);
			}
		}
%>	
         
		</table>
	</div>
  </body>
</html>

