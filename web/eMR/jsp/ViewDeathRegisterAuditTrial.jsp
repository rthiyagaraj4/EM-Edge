<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@	page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.TreeMap,webbeans.eCommon.ConnectionManager" %>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
	<title><fmt:message key="Common.AuditTrail.label" bundle="${common_labels}"/></title>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<style type="text/css">
	
	TD.gridData1
	{


		background-color: #FFFFFF;
		height:18px;
		font-family: Verdana, Arial, Helvetica, sans-serif;
		font-size: 8pt;
		color: #000000;
		font-weight:normal;
		padding-left:10px;
		padding-right:10px;
		vertical-align:left;
		border-bottom:1px;
		border-top:0px;
		border-left:0px;
		border-right:0px;
		border-style:solid;
		border-color:#EEEEEE;
	}

	</style>

</head>


<%
Connection conn=null;
PreparedStatement pstmt=null;
ResultSet rs=null;
ResultSet rs1=null;
Properties p						= (java.util.Properties) session.getValue( "jdbc" );
String login_user				= p.getProperty( "login_user" ) ;
String locale					= ((String)session.getAttribute("LOCALE"));
String patient_id				=	checkForNull(request.getParameter("patient_id"));
String encounter_id			=	checkForNull(request.getParameter("encounter_id"));
String facilityId			=	checkForNull(request.getParameter("facilityId"));
String field_name			=	"";
String old_value			=	"";
String new_value			=	"";
String modified_user			=	"";
String modified_date			=	"";
String created_user			=	"";
String created_date			=	"";
String sql	= "";
String units = "";
String periods = "";
String units1 = "";
String periods1 = "";
String    old_diagnosis   = "";
String 	old_seq_no		= "";
String 	old_onset_date	= "";
String 	new_diagnosis		= "";
String 	new_seq_no		= "";
String 	new_onset_date	= "";

String 	modified_user1    = "";
String 	modified_date1    = "";
String 	field_desc1    = "";

String login_user_id		        =	"";
String print_date_time		    =	"";
String no_of_copies			    =	"";
String work_station_no		    =	"";
String initial_print_yn		    =	"";

String initial_print_user		    =	"";
String print_date_time1		    =	"";
String print_details_hist_yn		    =	"";
		

try{

	conn = ConnectionManager.getConnection(request);

	sql = "select sm_get_desc.sm_appl_user(added_by_id,'"+locale+"','1') added_by_id, TO_CHAR(added_date,'dd/mm/yyyy hh24:mi') added_date from mr_death_register_hdr where facility_id = '"+facilityId+"' and encounter_id = '"+encounter_id+"'  ";

	pstmt=conn.prepareStatement(sql);
	rs=pstmt.executeQuery();
	while(rs.next()){
		
		created_user		=	checkForNull(rs.getString("added_by_id"));
		created_date	=	checkForNull(rs.getString("added_date"));
		created_date	=	DateUtils.convertDate(created_date,"DMYHM","en",locale);

	}
	if(pstmt!=null)pstmt.close();
	if(rs!=null)rs.close();


%>

<body >

<form name="ViewAuditTrailForm" id="ViewAuditTrailForm">

<table>
<tr>
<jsp:include page="../../eCommon/jsp/pline.jsp" flush="true" >
				<jsp:param name='Facility_Id' value='<%=facilityId%>'/>
				<jsp:param name='EncounterId' value='<%=encounter_id%>'/>
				<jsp:param name='patient_Id' value='<%=patient_id%>'/>
</jsp:include>
</tr>
</table>
<table border='0' cellspacing="0"  width='100%'>
<tr>

<td class='PANELTOOLBAR' align='center' width='100%' colspan='4'><fmt:message key="eMR.Modification.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
</tr>
<tr>
<td  class='PANELTOOLBAR' width='9%' ><fmt:message key="eMR.CreatedUser.label" bundle="${mr_labels}"/></td>
<td  class='PANELTOOLBAR' width='41%'>:&nbsp;<%=created_user%></td>
<td  class='PANELTOOLBAR' width='35%' align='right'><fmt:message key="eMR.createddatetime.label" bundle="${mr_labels}"/></td>
<td  class='PANELTOOLBAR' width='15%'>:&nbsp;<%=created_date%></td>
</tr>
</table>

<table border='0' cellspacing="0" width='100%'>
<tr>
<th  width='15%' align='left'><fmt:message key="Common.Field.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.name.label" bundle="${common_labels}"/></th>
<th  width='30%' align='left'><fmt:message key="Common.Old.label" bundle="${common_labels}"/></th>
<th width='30%' align='left'><fmt:message key="Common.New.label" bundle="${common_labels}"/></th>
<th width='10%' align='left'><fmt:message key="Common.Modified.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.user.label" bundle="${common_labels}"/></th>
<th width='15%' align='left'><fmt:message key="Common.Modified.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.time.label" bundle="${common_labels}"/></th>
</tr>
<tr>
</table>
<table border='0' cellspacing="0"  width='100%'>
<td align='left' class='TABON'><fmt:message key="Common.general.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eMR.Modifications.label" bundle="${mr_labels}"/></td>
</tr>
</table>
<div style="height: 125px;overflow-y:auto;">
<table border='0' cellspacing="0"  width='100%' >
<%
	
	String sql1="select field_name,field_value_before, field_value_after, sm_get_desc.sm_appl_user(modified_by_id,'"+locale+"','1') modified_by_id ,TO_CHAR(modified_date,'dd/mm/yyyy hh24:mi') modified_date from mr_death_register_audit where facility_id = '"+facilityId+"' and encounter_id = '"+encounter_id+"' and detail_record_yn = 'N' order by audit_srl_no desc";

	pstmt=conn.prepareStatement(sql1);
	rs=pstmt.executeQuery();
	while(rs.next()){
		field_name		=	checkForNull(rs.getString("field_name"));
		old_value			=	checkForNull(rs.getString("field_value_before"));
		new_value		=	checkForNull(rs.getString("field_value_after"));
		modified_user	=	checkForNull(rs.getString("modified_by_id"));
		modified_date	=	checkForNull(rs.getString("modified_date"));	
		modified_date	=	DateUtils.convertDate(modified_date,"DMYHM","en",locale);
		
		%>
		
		<tr>		
			<td class='griddata1' width='15%'><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR." + field_name +".label"
		    ,"mr_labels")%>&nbsp;</td>
		<%				
		  if(field_name.equals("FEMALE_PATIENT_DETAILS")) {

					if(!old_value.equals("")) { %>
						<td class='griddata1' width='30%' ><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR." + old_value +".label"
						,"mr_labels")%>&nbsp;</td> <%
					} else { %>
						  <td class='griddata1' width='30%'  >&nbsp;</td> <% }

					if(!new_value.equals("")) { %>
						<td class='griddata1' width='30%' ><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR." + new_value +".label","mr_labels")%>&nbsp;</td><%
					} else { %>
						<td class='griddata1' width='30%'  >&nbsp;</td><% } %>
						<td class='griddata1' width='10%'  align='center'><%=modified_user%>&nbsp;</td>
						<td class='griddata1' width='15%' align='center'><%=modified_date%>&nbsp;</td> <%

		   }
		   else if(field_name.equals("AUTH_PRACTITIONER") || field_name.equals("ATTENDING_PRACTITIONER")) 	{

					String sql8="select am_get_desc.am_practitioner('"+old_value+"','"+locale+"','1') FIELD_VALUE_BEFORE,am_get_desc.am_practitioner('"+new_value+"','"+locale+"','1') FIELD_VALUE_AFTER from dual";					
					pstmt=conn.prepareStatement(sql8);
					rs1=pstmt.executeQuery();
					while(rs1.next()) {						
						old_value	=	checkForNull(rs1.getString("FIELD_VALUE_BEFORE"));		
						new_value		=	checkForNull(rs1.getString("FIELD_VALUE_AFTER"));	
					} 					
					if(old_value.equals(""))  {	%>
					<td class='griddata1' width='30%'  >&nbsp;</td>
					<%} else {%>
					<td class='griddata1' width='30%'  ><%=old_value%>&nbsp;</td>
					<% } %>
					<td class='griddata1' width='30%'  ><%=new_value%>&nbsp;</td>
					<td class='griddata1' width='10%' align='center'  ><%=modified_user%>&nbsp;</td>
					<td class='griddata1' width='15%' align='center'  ><%=modified_date%>&nbsp;</td> 	<%		
						
		    }
			else if(field_name.equals("GESTATIONAL_PERIOD") ) {

						if(!old_value.equals(""))  {							
							StringTokenizer st = new StringTokenizer(old_value," ");
							periods = st.nextToken();
							units = st.nextToken();		%>
							<td class='griddata1' width='30%'  ><%=periods%> <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common."+units+".label","common_labels")%>&nbsp;</td> 	<%
					      } else { %>
						   <td class='griddata1' width='10%'  >&nbsp;</td> <%
						  }			
					
						if(!new_value.equals("")) {							
							StringTokenizer st = new StringTokenizer(new_value," ");
							periods1 = st.nextToken();
							units1 = st.nextToken();	%>
							<td class='griddata1' width='30%'  ><%=periods1%> <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common."+units1+".label","common_labels")%>&nbsp;</td>	<%
						} else { %>
						<td class='griddata1' width='10%'  >&nbsp;</td> <%
							}	%>				
						<td class='griddata1' width='10%' align='center'  ><%=modified_user%>&nbsp;</td>
						<td class='griddata1' width='15%' align='center'  ><%=modified_date%>&nbsp;</td>	<%									
			} 	
			else if(field_name.equals("CAUSE_OF_DEATH_REMARKS") ) {

				if(old_value.equals("")) {	%>				
						<td class='griddata1' width='30%'>&nbsp;</td>	 <%
					 } else { %>
						<td class='griddata1' width='30%' style='WORD-BREAK:BREAK-ALL;'><%=old_value%>&nbsp;</td> <% 
						} 
					if(new_value.equals("")) {	%>				
						<td class='griddata1' width='30%'>&nbsp;</td>	 <%
					 } else { %>
						<td class='griddata1' width='30%' style='WORD-BREAK:BREAK-ALL;'> <%=new_value%>&nbsp;</td> <% 
						} %>
					
					<td class='griddata1' width='10%'  align='center' ><%=modified_user%>&nbsp;</td>
					<td class='griddata1' width='15%'  align='center' ><%=modified_date%>&nbsp;</td>
         <%}
			else { 
					if(old_value.equals("")) {	%>				
						<td class='griddata1' width='30%'  >&nbsp;</td>	 <%
					 } else { %>
						<td class='griddata1' width='30%'  ><%=old_value%>&nbsp;</td> <% 
						} 
					if(new_value.equals("")) {	%>				
						<td class='griddata1' width='30%'  >&nbsp;</td>	 <%
					 } else { %>
						<td class='griddata1' width='30%'  ><%=new_value%>&nbsp;</td> <% 
						} %>
					
					<td class='griddata1' width='10%' align='center'  ><%=modified_user%>&nbsp;</td>
					<td class='griddata1' width='15%'  align='center' ><%=modified_date%>&nbsp;</td>
						
					</tr>	<%    
		     } 
	}	
	if(pstmt!=null)pstmt.close();
	if(rs!=null)rs.close();
	%>

</table>
</div>
<table border='1' cellspacing="0"  width='100%'>
<tr>
<th width='13%' align='left'><fmt:message key="Common.Field.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.name.label" bundle="${common_labels}"/></th>
<th width='10%'  align='left'><fmt:message key="Common.Old.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></th>
<th width='8%' align='left'><fmt:message key="Common.Old.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eMR.SeqNo.label" bundle="${mr_labels}"/></th>
<th width='14%'  align='center'><fmt:message key="Common.Old.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.OnsetDateTime.label" bundle="${common_labels}"/></th>
<th width='10%'  align='left'><fmt:message key="Common.New.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></th>
<th width='8%' align='left' ><fmt:message key="Common.New.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eMR.SeqNo.label" bundle="${mr_labels}"/></th>
<th width='14%'  align='center'><fmt:message key="Common.New.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.OnsetDateTime.label" bundle="${common_labels}"/></th>
<th width='10%' align='left'><fmt:message key="Common.Modified.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.user.label" bundle="${common_labels}"/></th>
<th width='11%' align='left'><fmt:message key="Common.Modified.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.time.label" bundle="${common_labels}"/></th>
</tr>
</table>
<table border='1' cellspacing="0"  width='100%'>
<tr>
<td align='left' class='TABON' ><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eMR.Modifications.label" bundle="${mr_labels}"/></td>
</tr>
</table>
<%

	String sql2 = "  select field_name,substr(field_value_before,1,instr(field_value_before,'|',1,1)-1) old_diagnosis_set,	substr(field_value_before,instr(field_value_before,'|',1,1)+1,instr(field_value_before,'|',1,2) - instr(field_value_before,'|',1,1) - 1) old_diagnosis,	substr(field_value_before,instr(field_value_before,'|',1,2)+1,instr(field_value_before,'|',1,3) - instr(field_value_before,'|',1,2) - 1) old_seq_no,substr(field_value_before,instr(field_value_before,'|',1,3)+1) old_onset_date,	substr(field_value_after,1,instr(field_value_after,'|',1,1)-1) new_diagnosis_set,	substr(field_value_after,instr(field_value_after,'|',1,1)+1,instr(field_value_after,'|',1,2) - instr(field_value_after,'|',1,1) - 1) new_diagnosis,	substr(field_value_after,instr(field_value_after,'|',1,2)+1,instr(field_value_after,'|',1,3) - instr(field_value_after,'|',1,2) - 1) new_seq_no,substr(field_value_after,instr(field_value_after,'|',1,3)+1) new_onset_date,	sm_get_desc.sm_appl_user(modified_by_id,'"+locale+"','1') modified_by_id , TO_CHAR(modified_date,'dd/mm/yyyy hh24:mi') modified_date from mr_death_register_audit where facility_id = '"+facilityId+"' and encounter_id = '"+encounter_id+"' and detail_record_yn = 'Y' order by audit_srl_no desc ";

	pstmt=conn.prepareStatement(sql2);
	rs=pstmt.executeQuery();
	
		%>
<div style="height: 125px;overflow-y:auto; " align='left'>
<table border='1' cellspacing="0"  width='100%'  >
<%
			while(rs.next()){
		field_desc1			=	checkForNull(rs.getString("field_name"));
		old_diagnosis   		=	checkForNull(rs.getString("old_diagnosis"));
		old_seq_no			=	checkForNull(rs.getString("old_seq_no"));
		old_onset_date	 	=	checkForNull(rs.getString("old_onset_date"));
		old_onset_date		=	DateUtils.convertDate(old_onset_date,"DMYHM","en",locale);
		new_diagnosis		=	checkForNull(rs.getString("new_diagnosis"));		
		new_seq_no			=	checkForNull(rs.getString("new_seq_no"));		
		new_onset_date	=	checkForNull(rs.getString("new_onset_date"));
		new_onset_date	=	DateUtils.convertDate(new_onset_date,"DMYHM","en",locale);
		modified_user1 	=	checkForNull(rs.getString("modified_by_id"));		
		modified_date1	=	checkForNull(rs.getString("modified_date"));		
		modified_date1	=	DateUtils.convertDate(modified_date1,"DMYHM","en",locale);
		%>
		<tr>
			<td class='griddata1' width='13%' align='left'><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR."+ field_desc1 +".label"
		    ,"mr_labels")%></td>	

			<%if(old_diagnosis.equals("")) {%>
			<td class='griddata1' width='10%' align='left' >&nbsp;</td>
			<% } else {%>
			<td class='griddata1' width='10%' align='left'><%=old_diagnosis%></td>
			<%} 
			
			if(old_seq_no.equals("")) {%>
			<td class='griddata1' width='8%' align='left'>&nbsp;</td>
			<% } else {%>
			<td class='griddata1' width='8%'  align='center'><%=old_seq_no%></td>
			<%} 
			
			if(old_onset_date.equals("")) {%>
			<td class='griddata1' width='14%'  align='left'>&nbsp;</td>
			<% } else {%>
			<td class='griddata1' width='14%' align='left'><%=old_onset_date%>&nbsp;</td>
			<%} 
			
			if(new_diagnosis.equals("")) {%>
			<td class='griddata1' width='10%'  align='left'>&nbsp;</td>
			<% } else {%>
			<td class='griddata1' width='10%'   align='left'><%=new_diagnosis%></td>
			<%} 
			
			if(new_seq_no.equals("")) {%>
			<td class='griddata1' width='8%'  align='left'>&nbsp;</td>
			<% } else {%>
			<td class='griddata1' width='8%'  align='center'><%=new_seq_no%></td>
			<%} 
			
			if(new_onset_date.equals("")) {%>
			<td class='griddata1' width='14%'  align='left'>&nbsp;</td>
			<% } else {%>
			<td class='griddata1' width='14%'  align='left'><%=new_onset_date%>&nbsp;</td>
			<%}
			
			%>			
			<td class='griddata1' width='10%'  align='left'><%=modified_user1%></td>
			<td class='griddata1' width='11%' align='left'><%=modified_date1%></td>
		</tr>	
		<%
		
	}
	if(pstmt!=null)pstmt.close();
	if(rs!=null)rs.close();
%>
</table>
</div>
<%
	String sql3 = "select print_details_hist_yn from mr_death_reg_audit_trial_param ";

	pstmt=conn.prepareStatement(sql3);
	rs=pstmt.executeQuery();
	while(rs.next()){		
		print_details_hist_yn		=	checkForNull(rs.getString("print_details_hist_yn"));		
	}
	if(pstmt!=null)pstmt.close();
	if(rs!=null)rs.close();

if(print_details_hist_yn.equals("Y")) {
%>

<table border='0' cellspacing="0"  width='100%'>
<tr>

<td class='PANELTOOLBAR' align='center' width='100%' colspan='4'><fmt:message key="Common.print.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
</tr>

<%
	String sql4 = "select sm_get_desc.sm_appl_user(added_by_id,'"+locale+"','1') initial_print_user, TO_CHAR(added_date,'dd/mm/yyyy hh24:mi') print_date_time from sm_print_routing_audit where enc_facility_id ='"+facilityId+"' and encounter_id = '"+encounter_id+"' and module_id = 'MR' and report_id = 'MRDTHCER' and initial_print_yn = 'Y' ";

	pstmt=conn.prepareStatement(sql4);
	rs=pstmt.executeQuery();
	while(rs.next()){		
		initial_print_user		=	checkForNull(rs.getString("initial_print_user"));
		print_date_time1		=	checkForNull(rs.getString("print_date_time"));
		print_date_time1		=	DateUtils.convertDate(print_date_time1,"DMYHM","en",locale);

	}
	if(pstmt!=null)pstmt.close();
	if(rs!=null)rs.close();
%>
<tr>
<td  class='PANELTOOLBAR' width='8%' ><fmt:message key="Common.InitialPrint.label" bundle="${mr_labels}"/></td>
<td  class='PANELTOOLBAR' width='42%'>:&nbsp;<%=initial_print_user%></td>
<td  class='PANELTOOLBAR' width='35%' align='right'><fmt:message key="Common.InitialPrintDt.label" bundle="${common_labels}"/></td>
<td  class='PANELTOOLBAR' width='15%'>:&nbsp;<%=print_date_time1%></td>
</tr>
</table>

<table border='0' cellspacing="0" cellpadding="1" width='100%'>
<tr>
<th width='20%' align='left'><fmt:message key="Common.PrintedBy.label" bundle="${common_labels}"/></th>
<th width='20%' align='left'><fmt:message key="Common.DateAndTimePrinting.label" bundle="${common_labels}"/></th>
<th width='20%' align='left'><fmt:message key="Common.NumberOfCopies.label" bundle="${common_labels}"/></th>
<th width='20%' align='left'><fmt:message key="Common.WorkstationNo.label" bundle="${common_labels}"/></th>
<th width='20%' align='left'><fmt:message key="eMR.initialprintYN.label" bundle="${mr_labels}"/></th>
</tr>
</table>
<div style="height:100px; overflow-y:auto;">
<table border='0' cellspacing="0" cellpadding="1"  width='100%' >
<%

	String sql5="select added_by_id login_user_id, TO_CHAR(added_date,'dd/mm/yyyy hh24:mi') print_date_time, no_of_copies,added_at_ws_no work_station_no, initial_print_yn from sm_print_routing_audit where enc_facility_id ='"+facilityId+"' and encounter_id = '"+encounter_id+"' and module_id = 'MR' and report_id = 'MRDTHCER' order by audit_srl_no desc ";
	
	pstmt=conn.prepareStatement(sql5);
	rs=pstmt.executeQuery();
	while(rs.next()){
		login_user_id		    =	checkForNull(rs.getString("login_user_id"));
		print_date_time   		=	checkForNull(rs.getString("print_date_time"));
		print_date_time		=	DateUtils.convertDate(print_date_time,"DMYHM","en",locale);
		no_of_copies			=	checkForNull(rs.getString("no_of_copies"));
		work_station_no		=	checkForNull(rs.getString("work_station_no"));		
		initial_print_yn			=	checkForNull(rs.getString("initial_print_yn"));		
		
		%>
		<tr>
			<td class='griddata1' width='20%' ><%=login_user_id%></td>
			<td class='griddata1' width='20%' ><%=print_date_time%></td>
			<td class='griddata1' width='20%' align='center' ><%=no_of_copies%></td>
			<td class='griddata1' width='20%' ><%=work_station_no%></td>
			<td class='griddata1' width='20%' align='center'><%=initial_print_yn%></td>			
		</tr>	
		<%
		
	}
	if(pstmt!=null)pstmt.close();
	if(rs!=null)rs.close();
}
%>
</table>
</div>
<table border='0' width='100%'>
<tr>
<td class='PANELTOOLBAR'>&nbsp;</td>
</tr>
<tr>
<td  class="button" ><input type="button" name="closeWindow" id="closeWindow" value = '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onclick="closeWindow()"/></td>
</tr>

</table>
</form>
</body>
<%
	}catch(Exception ex){
		//out.println(ex);
		ex.printStackTrace();
	}finally{
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(conn,request);
	}%>
</html>

<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
<script>
function closeWindow(){
	 const dialogTag = parent.document.getElementById('dialog_tag');    
	    dialogTag.close();   
}
</script>
<!--

//-->
</script>
