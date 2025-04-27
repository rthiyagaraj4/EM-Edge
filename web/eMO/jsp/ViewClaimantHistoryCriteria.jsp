<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,org.json.simple.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script><%
     String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
<%
	request.setCharacterEncoding("UTF-8");
    	 
    String sql					= "";
    Connection con 				= null;
    con=ConnectionManager.getConnection(request);
    PreparedStatement pstmt		= null;
    ResultSet rs				= null ;
    String facilityid  			= (String) session.getValue("facility_id");
    String locale 				= ((String)session.getAttribute("LOCALE"));
    String patient_id			=  request.getParameter("patient_id");
    String facilit_name			= "";
    String classValue			= "";
    int rowIndex				= 0;
    String registration_no		= "";
    String deceased_name		= "";
    String mo_regn_date_time	= "";
    String pm_yn				= "";
	String pm_yn_converted		= "";
	String postmortem_status	= "";
	String postmortem_status_desc = "";
	String encounter_id			= "";
    String location				= "";
    String rfid_tag_num			= "";
    String bur_per_no			= "";

				JSONObject json = new JSONObject(); // added by mujafar for ML-MMOH-CRF-0996 start
				json			 = eMO.MOCommonBean.getMOParam(con, facilityid); 
				String enable_rfid_yn = (String)json.get("enable_rfid_yn"); // added by mujafar for ML-MMOH-CRF-0996 end
%>
<body>
<form name="ClaimantHistoryCriteria" id="ClaimantHistoryCriteria" method="post">
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	
	<th><fmt:message key="Common.facility.label" bundle="${common_labels}"/></th> 
	<th><fmt:message key="Common.registrationno.label" bundle="${common_labels}"/></th> 
	<th nowrap><fmt:message key="Common.RegnDate/Time.label" bundle="${common_labels}"/></th>
  	<th nowrap><fmt:message key="Common.deceased.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.name.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="eMO.PMYN.label" bundle="${mo_labels}"/></th>
	<th><fmt:message key="eMO.PostmortemStatus.label" bundle="${mo_labels}"/></th>
	<th><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
	<%if(enable_rfid_yn.equals("Y")) // added by mujafar for ML-MMOH-CRF-0996
	{
	%>
	<th nowrap><fmt:message key="eMO.RFIDTag.label" bundle="${mo_labels}"/> </th>
	<%}%>
	<th nowrap><fmt:message key="eMO.BurialPermitNo.label" bundle="${mo_labels}"/></th>

<%
    try{
    	sql="SELECT a.FACILITY_ID,sm_get_desc.sm_facility_param(a.FACILITY_ID,'"+locale+"',1) facility_name, a. registration_no, a.body_received_date,a.patient_name, a.patient_id, a.age, a.sex, a.pm_yn, a.postmortem_status, a. postmortem_status_desc,  a.bed_no, a.encounter_id,  a.release_body_date, a.body_part_obtained_from_desc, a.burial_permit_no,   religion,    rfid_tag_num  FROM mo_manage_deceased_vw a,mo_claimant b where  a.REGISTRATION_NO=b.REGISTRATION_NO and a.patient_id=? and a.FACILITY_ID <> ? order by b.ADDED_DATE desc";
        pstmt=con.prepareStatement(sql);
        pstmt.setString(1,patient_id);
        pstmt.setString(2,facilityid);
        rs = pstmt.executeQuery();

        if(rs!=null){
	        while (rs.next())	{
	        	classValue				= ((rowIndex%2)==0)? "QRYEVEN" : "QRYODD";
	        	rowIndex++;
	        	facilit_name			= checkForNull(rs.getString("facility_name"));
	        	registration_no			= checkForNull(rs.getString("registration_no"));
	        	deceased_name			= checkForNull(rs.getString("patient_name"));	
	        	mo_regn_date_time		= checkForNull(rs.getString("body_received_date"));
	        	if(mo_regn_date_time!=null && !mo_regn_date_time.equals(""))
	        		mo_regn_date_time	=  DateUtils.convertDate(mo_regn_date_time,"DMYHM","en",localeName);
	        	pm_yn					= checkForNull(rs.getString("pm_yn"));
	        	if(pm_yn!=null && !pm_yn.equals("") && pm_yn.equals("N"))
	        		pm_yn_converted = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
	        	else if(pm_yn!=null && !pm_yn.equals("") && pm_yn.equals("Y"))
	        		pm_yn_converted = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");

	        	postmortem_status		= checkForNull(rs.getString("postmortem_status"));
	        	
	        	if(postmortem_status!=null && !postmortem_status.equals("") && postmortem_status.equals("N"))
	        		postmortem_status_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
	        	else if(postmortem_status!=null && !postmortem_status.equals("") && postmortem_status.equals("A"))
	        		postmortem_status_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.NotRequested.label","mo_labels");
	        	else if(postmortem_status!=null && !postmortem_status.equals("") && postmortem_status.equals("R"))
	        		postmortem_status_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Requested.label","common_labels");
	        	else if(postmortem_status!=null && !postmortem_status.equals("") && postmortem_status.equals("S"))
	        		postmortem_status_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProgress.label","common_labels");
	        	else if(postmortem_status!=null && !postmortem_status.equals("") && postmortem_status.equals("E"))
	        		postmortem_status_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.completed.label","common_labels");
	        	else if(postmortem_status!=null && !postmortem_status.equals("") && postmortem_status.equals("C"))
	        		postmortem_status_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
	        	
	        	
	        	encounter_id			= checkForNull(rs.getString("encounter_id"));
	        	location				= checkForNull(rs.getString("bed_no"));
	        	rfid_tag_num			= checkForNull(rs.getString("rfid_tag_num"));
	        	bur_per_no				= checkForNull(rs.getString("BURIAL_PERMIT_NO"));
	        	
	        	if(rowIndex==1){%>
	        		<input type="hidden" id="default_regn_no" value="<%=registration_no%>">
	           	<%}
	        	%>
	        	<tr id="facility_<%=rowIndex %>" style="background-color:#ff0000;">
		        	<td class='<%=classValue%>' ><a href="javascript:FnGetClaimantdetails('<%=registration_no%>','<%=rowIndex %>')"  ><%=facilit_name%></a></td>
		        	<td class='<%=classValue%>'><%=registration_no%></td>
		        	<td class='<%=classValue%>'><%=mo_regn_date_time%></td>
		        	<td class='<%=classValue%>'><%=deceased_name%></td>
		        	<td class='<%=classValue%>'><%=pm_yn_converted%></td>
		        	<td class='<%=classValue%>'><%=postmortem_status_desc%></td>
		        	<td class='<%=classValue%>'><%if(encounter_id.equals(""))%>&nbsp;<%else%><%=encounter_id%></td>
		        	<td class='<%=classValue%>'><%if(location.equals(""))%>&nbsp;<%else%><%=location%></td>
					<%
					if(enable_rfid_yn.equals("Y")) // added by mujafar for ML-MMOH-CRF-0996
						{
						%>
		        	<td class='<%=classValue%>'><%if(rfid_tag_num.equals(""))%>&nbsp;<%else%><%=rfid_tag_num%></td>
					<%}%>
		        	<td class='<%=classValue%>'><%if(bur_per_no.equals(""))%>&nbsp;<%else%><%=bur_per_no%></td>
	        	</tr>
	        <%}
        }
        
		 
	
%>
</table>

<input type="hidden" id="rowcount" value="<%=rowIndex%>">
	
<%		
		
    }
    catch (Exception e) { out.println(e) ; }
	finally{
	 if(con != null) ConnectionManager.returnConnection(con,request);
	 if(rs!=null) rs.close();
}
%>
</form>
</body>
</html>
<%!
public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}%>

<script>
	function FnGetClaimantdetails(regn_no,id){
		parent.frames[2].location.href="../../eMO/jsp/ViewClaimantHistoryDetails.jsp?regn_no="+regn_no;
		var totcount=document.getElementById("rowcount").value;
		var i=1;
	
		for(var j=1;j<=totcount;j++){
			var cells = document.getElementById("facility_"+j).getElementsByTagName("td");
			if(j==id){
				for (var i = 0; i < cells.length; i++) {
				     cells[i].style.backgroundColor = "#E0E0E0";
				}
			}else{
				for (var i = 0; i < cells.length; i++) {
				     cells[i].style.backgroundColor = "#FFFFFF";
				}
			}
		}
	}
	
	window.onload=function(){
		regn_no	= document.getElementById("default_regn_no").value;
		FnGetClaimantdetails(regn_no,1);
	}
</script>

