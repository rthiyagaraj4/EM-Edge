<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<head>
    	<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");
%>

      <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link> <title><fmt:message key="eMO.PoliceDetails.label" bundle="${mo_labels}"/></title>     	
    	<Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
     <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
 	  <script language='javascript' src='../../eCommon/js/dchk.js'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>	
		<script src='../../eMO/js/MORegisterAttn.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		
 </head>

<body OnMouseDown='CodeArrest()' onLoad="FocusFirstElement();checkUnckData()" onUnLoad='' onKeyDown = 'lockKey()'>
<%
	String police_details = "";
	String pol_rep_no     = "";
	String pol_stn_id     = "";
	String pol_id         = "";
	String patient_id     = "";
	String sys_date="";
	String body_received_date_time=""; 
    String police_approval_received_yn="";
    String police_approval_received_by="";
	 String police_approval_received_by_desc="";
    String police_approval_received_date="";
	String mode="";
	String facilityId	= (String)session.getValue("facility_id");
	String mode1="";
	/*Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689 Start*/
	String calledFrom			= "";
	String polOfficerName		= "";
	String polContactNo			= "";
	String externalBidBodyPartYn= "";
	String policeDtlsMandYn		= "";
	String makeMand				= "";
	JSONObject jsonObj			= new JSONObject();
	/*End*/
    //String death_status_remarks="";

	Connection con                 = null;
	java.sql.Statement stmt        = null;
	//PreparedStatement pstmt   = null;
	ResultSet rs				   = null;
try
{
	police_details = checkForNull(request.getParameter("police_details"));
    patient_id     = checkForNull(request.getParameter("patient_id"));
    pol_rep_no     = checkForNull(request.getParameter("pol_rep_no"));
	pol_stn_id     = checkForNull(request.getParameter("pol_stn_id"));
	pol_id     = checkForNull(request.getParameter("pol_id"));
    mode     = checkForNull(request.getParameter("mode"));
	if(mode.equals("viewdata"))mode1="disabled";
	police_approval_received_yn = checkForNull(request.getParameter("police_approval_received_yn"));
    police_approval_received_by     = checkForNull(request.getParameter("police_received_by"));
    police_approval_received_date = checkForNull(request.getParameter("police_received_date"));	
	police_approval_received_by_desc=checkForNull(request.getParameter("police_approval_received_by_desc"));
	/*Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689 Start*/
	calledFrom				= checkForNull(request.getParameter("calledFrom"));
	polOfficerName			= checkForNull(request.getParameter("pol_officer_name"));
	polContactNo			= checkForNull(request.getParameter("pol_contact_no"));
	externalBidBodyPartYn	= checkForNull(request.getParameter("externalBidBodyPartYn"));
	/*End*/
    //death_status_remarks= checkForNull(request.getParameter("death_status_remarks")); 
	sys_date = request.getParameter("sys_date")==null?"":request.getParameter("sys_date");
	body_received_date_time = request.getParameter("body_received_date_time")==null?"":request.getParameter("body_received_date_time");
	

	con  = ConnectionManager.getConnection(request);
	/*Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689 Start*/
	jsonObj = eMO.MOCommonBean.getMOParam(con, facilityId); 
	policeDtlsMandYn = (String)jsonObj.get("policeDtlsMandYn");
	/*End*/
	stmt = con.createStatement();
	rs   = stmt.executeQuery("select pol_rep_no,pol_stn_id,pol_id from mo_encounter_dtls_vw where patient_id='"+patient_id+"' ");
	if(rs!=null)
	{
	  while(rs.next())
	  {
	//	pol_rep_no = checkForNull(rs.getString("pol_rep_no"));
	//	pol_stn_id = checkForNull(rs.getString("pol_stn_id"));
	//	pol_id     = checkForNull(rs.getString("pol_id"));
	    
	  
	  }
  } if(rs!=null) rs.close();
    if(stmt!=null) stmt.close();



%>


<form name='service_form' id='service_form'  method='post' target='messageFrame'>
      	
      	<table border='0' cellpadding='3' cellspacing='0'  width='100%' align='center'>
			<!--Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689 Start-->
			<% if( calledFrom.equals("MO_EBP_REGN") || calledFrom.equals("MO_BID_REGN") || externalBidBodyPartYn.equals("Y") ){ 
					if(policeDtlsMandYn.equals("Y"))
						makeMand = "Y";
			%>
				<tr>
					<td class='label' width='50%'><fmt:message key="Common.PoliceReportNo.label" bundle="${common_labels}"/></td>
					<td class='fields' width='50%'><INPUT TYPE="text" <%=mode1%> NAME="pol_rep_no"   id="pol_rep_no" maxlength=30 value="<%=pol_rep_no%>">
					<% if(policeDtlsMandYn.equals("Y")){ %>
						<img src='../../eCommon/images/mandatory.gif'align='center' id=id3 ></img>
					<% } %>
					</td>
				</tr>
				<tr>
					<td class='label' width='50%'><fmt:message key="Common.InvestigationOfficer.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
					<td class='fields' width='50%'><INPUT TYPE="text" <%=mode1%> NAME="pol_officer_name" maxlength="60" value="<%=polOfficerName%>"></td>
				</tr>
				<tr>
					<td class='label' width='50%'><fmt:message key="Common.contactNo.label" bundle="${common_labels}"/></td>
					<td class='fields' width='50%'><INPUT TYPE="text" <%=mode1%> NAME="pol_contact_no" maxlength="20" value="<%=polContactNo%>"></td>
				</tr>
				<tr>
					<td class='label'><fmt:message key="Common.station.label" bundle="${common_labels}"/></td>
					<td class='fields'><INPUT TYPE="text" <%=mode1%> NAME="pol_stn_id"   id="pol_stn_id"  maxlength=30 value="<%=pol_stn_id%>">
					<% if(policeDtlsMandYn.equals("Y")){ %>
						<img src='../../eCommon/images/mandatory.gif'align='center' id=id3 ></img>
					<% } %>
					</td>
				</tr>
				<tr>
					<td class='label'><fmt:message key="eMO.PoliceID.label" bundle="${mo_labels}"/></td>
					<td class='fields'><INPUT TYPE="text"  <%=mode1%> NAME="pol_id" value='<%=pol_id%>' maxlength='30'>
					<% if(policeDtlsMandYn.equals("Y")){ %>
						<img src='../../eCommon/images/mandatory.gif'align='center' id=id3 ></img>
					<% } %>
					</td>
				</tr>
				<tr>
					<td class='label'><fmt:message key="eMO.PoliceDetails.label" bundle="${mo_labels}"/></td>
					<td class='fields'><TEXTAREA id=TEXTAREA1 <%=mode1%> cols=40 rows=10 name='police_details'><%=police_details%></TEXTAREA></td>
					<% if(policeDtlsMandYn.equals("Y")){ %>
						<td><img src='../../eCommon/images/mandatory.gif'align='center' id=id3 ></img></td>
					<% } %>
				</tr>		
				<tr>
					<td class='label'><fmt:message key="eMO.Police61Recvd.label" bundle="${mo_labels}"/></td>
					<td class='fields'>
					<%if(police_approval_received_yn.equals("Y")){%>
					<INPUT TYPE="checkbox" name="police_approval_received_yn" id="police_approval_received_yn" <%=mode1%> value="Y" checked onClick='checkUnckData()'></td>
					<%}else
					{%>
							<INPUT TYPE="checkbox" name="police_approval_received_yn" id="police_approval_received_yn"  <%=mode1%> onClick='checkUnckData()' ></td>
					<%}%>
		
				</tr>		
			<% }else{ makeMand = "Y"; %><!--End-->
				<tr>
					<td class='label' width='50%'><fmt:message key="Common.PoliceReportNo.label" bundle="${common_labels}"/></td>
					<td class='fields' width='50%'><INPUT TYPE="text" <%=mode1%> NAME="pol_rep_no"   id="pol_rep_no" maxlength=30 value="<%=pol_rep_no%>"><img src='../../eCommon/images/mandatory.gif'align='center' id=id3 ></img>
		
				</tr>
				<tr>
					<td class='label'><fmt:message key="Common.station.label" bundle="${common_labels}"/></td>
					<td class='fields'><INPUT TYPE="text" <%=mode1%> NAME="pol_stn_id" maxlength=30 value="<%=pol_stn_id%>"><img src='../../eCommon/images/mandatory.gif'align='center' id=id3 ></img>	
				</tr>
				<tr>
					<td class='label'><fmt:message key="eMO.PoliceID.label" bundle="${mo_labels}"/></td>
					<td class='fields'><INPUT TYPE="text"  <%=mode1%> NAME="pol_id" value='<%=pol_id%>' maxlength='30'><img src='../../eCommon/images/mandatory.gif'align='center' id=id3 ></img>	
				</tr>
				<tr>
					<td class='label'><fmt:message key="eMO.PoliceDetails.label" bundle="${mo_labels}"/></td>
					<td class='fields'><TEXTAREA id=TEXTAREA1 <%=mode1%> cols=40 rows=10 name='police_details'><%=police_details%></TEXTAREA><img src='../../eCommon/images/mandatory.gif'align='center' id=id3 ></img>			
				</tr>		
				<tr>
					<td class='label'><fmt:message key="eMO.Police61Recvd.label" bundle="${mo_labels}"/></td>
					<td class='fields'>
					<%if(police_approval_received_yn.equals("Y")){%>
					<INPUT TYPE="checkbox" name="police_approval_received_yn" id="police_approval_received_yn" <%=mode1%> value="Y" checked onClick='checkUnckData()'></td>
					<%}else
					{%>
							<INPUT TYPE="checkbox" name="police_approval_received_yn" id="police_approval_received_yn"  <%=mode1%> onClick='checkUnckData()' ></td>
					<%}%>
		
				</tr>		
			<% } %>
				<tr>
					<td class='label'><fmt:message key="eMO.Police61RecvdBy.label" bundle="${mo_labels}"/></td>
					<td class='fields'><input type="text" <%=mode1%> name="police_received_by_desc" id="police_received_by_desc"   value="<%=police_approval_received_by_desc%>" size="30" maxlength="30" onBlur='beforeGetPractitioner(document.forms[0].police_received_by_desc,this); '><input type='button' name='pract_id' id='pract_id'   <%=mode1%> value='?' class='button' onclick='searchCode(this, police_received_by_desc)'> <input type='hidden' name='police_received_by' id='police_received_by' value ='<%=police_approval_received_by%>'><img src='../../eCommon/images/mandatory.gif' style="visibility:hidden" align='center' id=idchk1 >
					</td>         
				</tr>
		
		
		
		<%				}catch(Exception e)
{
	out.println("Exception in PoliceDetails"+e.toString());
}
finally
{	
	ConnectionManager.returnConnection(con,request);
}%>
			
			
		
			
	
	     
			<tr>
				<td class='label'><fmt:message key="eMO.Police61RecvdDt.label" bundle="${mo_labels}"/></td>
      			<td class='fields'><input type=text name="police_received_date" id="police_received_date" value="<%=police_approval_received_date%>" onblur="if(validDateObj(this,'DMYHM',localeName)){chkWithSysDt(this);chkWithDates(this,'PRD');}" disabled size=16 maxlength=16 tabindex=21><img id='img1' <%=mode1%>  src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].police_received_date.select();return showCalendar('police_received_date', null, 'hh:mm' );" style="cursor='hand'"><img id='idchk2'src='../../eCommon/images/mandatory.gif' align='center'  style='visibility:hidden' ></td>
			</tr>		
			<tr>
			<td colspan='2' class='button' align='right'><input type=button value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class='BUTTON' onclick='closeme_polece()'>
		
   	</table>
	<input type='hidden' name='mode' id='mode' value ='<%=mode%>'>
	<input type='hidden' name='system_date' id='system_date' value ='<%=sys_date%>'>
	<input type='hidden' name='facilityId' id='facilityId' value ='<%=facilityId%>'>
	<!--Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689 Start-->
	<input type='hidden' name='polCalledFrom' id='polCalledFrom' value ='<%=calledFrom%>'>
	<input type='hidden' name='makeMand' id='makeMand' value ='<%=makeMand%>'>
	<input type='hidden' name='polExternalBidBodyPartYn' id='polExternalBidBodyPartYn' value ='<%=externalBidBodyPartYn%>'>
	<!--End-->
	<input type='hidden' name='body_received_date_time' id='body_received_date_time' value ='<%=body_received_date_time%>'>
   	</form>
   	</body>
   	</html>
	
<%!
public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}
%>

