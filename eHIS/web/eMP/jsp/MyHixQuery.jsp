<!DOCTYPE html>
<!-- Last Modified Date Time : 9/27/2005 11:49 AM -->

<%@ page import ="java.sql.*,java.net.*,webbeans.eCommon.*,java.text.*, eXH.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title> MyHix Search</title>
<HEAD>
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	String alt_id1_type = "";
	String alt_id2_type = "";
	String alt_id3_type = "";
	String alt_id4_type = "";
	String nat_id_prompt  = "";
	String pat_id = request.getParameter("Patient_ID") ;
	String enc_id = request.getParameter("enc_id") ;

	System.out.println(" ::: MyHixQuery :::");

	boolean isDebugYN = false; 

	isDebugYN = (eXH.XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

	System.out.println("MyHixQuery isDebugYN--> "+isDebugYN);
	
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 

	Properties p = (Properties) session.getValue("jdbc"); 
	String loggedUser = p.getProperty("login_user");
%>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language='javascript' src='../../eMP/js/MyHixSearch.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'> </script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eXH/js/ExternalApplication.js' language='javascript'></script>
<script src='../../eXH/js/jquery-1.7.min.js' language='javascript'></script>
<Script src='../../eCommon/js/CommonCalendar.js' language="JavaScript"></Script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>


</HEAD>

<BODY onLoad="focusField()" onKeyDown = 'lockKey()'>
<form name="PatientHistorySearchForm" id="PatientHistorySearchForm" target="messageFrame">
<table border='0' width='100%' align='center' valign='top'>
	<th align='left'> <fmt:message key="Common.QueryCriteria.label" bundle="${common_labels}"/></th>
	<tr>
		<td width="100%" class="Border" align='left'>
			<table width='100%'  border=0 cellPadding="2" cellSpacing="0"  align='left'>
				
				<% 
					try{
					con = ConnectionManager.getConnection(request);
					String locale=(String)session.getAttribute("LOCALE");

				%>
					
				<%
					int patlen = 0;
					String Start_date="";
					String End_date="";
					String my_hix_data="";
					String my_hix_pat_id="";
					String my_hix_consent="N";
					String facilityid=(String)session.getValue( "facility_id" ) ;
					int pos=0;
					
					//Changes made for ML-MMOH-CRF-1130.3

					int date_period = 12;

					pstmt = con.prepareStatement(" SELECT default_value FROM xh_standard_control_seg WHERE standard_code = 'XMLSTD' AND	segment_id = 'DISREGC' AND	element_id = 'DATE_PERIOD'");
					
					if (isDebugYN)
						System.out.println("pstmt ::: "+pstmt.toString());

					rs = pstmt.executeQuery();
					if(rs != null){
						while(rs.next()) {
							date_period = rs.getInt("default_value");							
						}
					}
					else
						date_period = 12;					

					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
					
					//Changes made for ML-MMOH-CRF-1130.3

					//pstmt = con.prepareStatement(" select patient_id_length,(select to_char(sysdate -10,'dd/mm/yyyy') from dual) from_date,(select to_char(sysdate,'dd/mm/yyyy') from dual) end_date, (select MYHIX_ID||'@@@@@'||MYHIX_CONSENT  from mp_patient where patient_id='"+pat_id+"') my_hix_pat_id      from mp_param   ");
					// Query changes made for ML-MMOH-CRF-1130.3
					pstmt = con.prepareStatement(" select to_char(sysdate -"+date_period+",'dd/mm/yyyy') from_date, to_char(sysdate,'dd/mm/yyyy') end_date, MYHIX_ID, MYHIX_CONSENT from mp_patient where patient_id=?");
					
					if (isDebugYN)
						System.out.println("pstmt ::: "+pstmt.toString()+" ::: pat_id ::: "+pat_id);

					pstmt.setString(1, pat_id);
					rs = pstmt.executeQuery();
					if(rs != null){
						while(rs.next()) {
							//patlen = rs.getInt("patient_id_length");
							Start_date = rs.getString("from_date");
							End_date = rs.getString("end_date");
							my_hix_pat_id= rs.getString("MYHIX_ID");
							my_hix_consent= rs.getString("MYHIX_CONSENT");
							/*
							my_hix_data = checkForNull(rs.getString("my_hix_pat_id"));
							my_hix_data=my_hix_data.replaceAll("&amp;", "&amp;amp;");
							pos=my_hix_data.indexOf("@@@@@");
							if(pos>=0){
								my_hix_pat_id= my_hix_data.substring(0,pos);
								my_hix_consent= my_hix_data.substring(pos+5,my_hix_data.length());
							}else{
								my_hix_pat_id="";
							}
							*/
						}
					}
					
					if (isDebugYN)
						System.out.println("my_hix_pat_id ::: "+my_hix_pat_id+" ::: my_hix_consent ::: "+my_hix_consent);

				%>
					
				<tr>
					<td align='left' class="label" width='13%'><fmt:message key="eMP.MyHIXGlobalID.label" bundle="${mp_labels}"/>:</td>
					<td align='left' class="label" colspan=5 width='87%'><%=my_hix_pat_id%><input type="hidden" name='my_hix_pat_id' id='my_hix_pat_id' size="75" value = '<%=my_hix_pat_id%>'></td>
				</tr>
				<tr>
					<td align='left' class="label" width='13%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>:<td>
					<td align='left' class="label" width='10%'><%=pat_id%>
					<input type=hidden name='Patient_ID' id='Patient_ID' size="10" value = '<%=pat_id%>'>
					<input type=hidden name='encounter_id' id='encounter_id' size="20" value = '<%=enc_id%>' >
					<input type=hidden name='my_hix_consent' id='my_hix_consent' size="20" value = '<%=my_hix_consent%>' >
					<input type=hidden name='facilityid' id='facilityid' size="20" value = '<%=facilityid%>' >
					<input type=hidden name='header_html' id='header_html' size="20" value = '' >
					<input type=hidden name='logged_User' id='logged_User' size="20" value = '<%=loggedUser%>' ></td>	
					<td  class="label" id='pref_per' width='15%'><fmt:message key="Common.preferredperiod.label" bundle="${common_labels}"/></td>
					<td class="fields" width='32%'><input id="date_from" tabindex=0 type=text name='date_from' id='date_from' size='10' maxlength='10'  value="<%=Start_date%>" Onblur="date_check(this)"><img id='frm_img'  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" tabindex=0   onClick="return showCalendar('date_from',null);">&nbsp;<img src='../images/mandatory.gif'></img>&nbsp;-&nbsp;<input id="date_to" tabindex=0 type=text name='date_to' id='date_to' size='10' maxlength='10'  value="<%=End_date%>"  Onblur="date_check(this)"><img id='to_img' style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" tabindex=0 onClick="return showCalendar('date_to',null);" >&nbsp;<img src='../images/mandatory.gif'></img><input type="hidden" name="prefdate_curr" id="prefdate_curr" value="<%=End_date%>">
					</td>
					<td align='left' class="label" width='30%'><input type='button' name='GetDishcargeSummary' id='GetDishcargeSummary' value='Discharge Summary' class='button' onclick='search(GetDishcargeSummary)' style="width=140px">
					<input type='button' name='GetReferralSummary' id='GetReferralSummary' value='Referral Summary' class='button' onclick='search(GetReferralSummary)' style="width=140px">
					</td>
					
				</tr>
				
			</table>
		</td>
	</tr>
<%
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();
}catch(Exception e) { out.println(e.toString());}
finally{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</table>
</form>
</BODY>
</HTML>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

