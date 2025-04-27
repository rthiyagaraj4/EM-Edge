<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page import="java.sql.*,webbeans.eCommon.*,eBL.Common.*,eBL.*,eCommon.Common.*,java.net.*,webbeans.op.CurrencyFormat,java.io.*,com.ehis.util.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 
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
	Connection con				= null;
	PreparedStatement pstmt		= null ;
	ResultSet rs				= null;	
	String user = checkForNull(request.getParameter("user"));
	String strclientip = checkForNull(request.getParameter("strclientip"));
	String cusName = checkForNull(request.getParameter("cusName")); //44856
	String customerCode = checkForNull(request.getParameter("customerCode"));
	String encounterFromDate = checkForNull(request.getParameter("encounterFromDate"));
	String encounterToDate = checkForNull(request.getParameter("encounterToDate"));
	String episodeType = checkForNull(request.getParameter("episodeType")); 
	String apprvSts_AAKHYN = checkForNull(request.getParameter("apprvSts_AAKHYN"));//V230425 PreAuthEclaimYN
	String PreAuthEclaimYN = checkForNull(request.getParameter("PreAuthEclaimYN"));//V230822 
	String userId = (String) session.getAttribute("login_user");
	String responsibility_id=(String)session.getAttribute("responsibility_id");	
	String facility_id  =  (String) session.getValue("facility_id") ;
	String locale = (String)session.getAttribute("LOCALE");
	String funct_name = request.getParameter("funct_name");
	String val = request.getParameter("val");
	String disableField="";//102.2
	String validRecUserView = "";
	String validFrontUserView = "";
	String p_privilege_val = "";
	String p_allowed_yn = "";
	String functionID	= 	"APPR_STATUS_DASHBOARD";
	String recUserView	= 	"APPR_STATUS_REC_USER";
	String frontUserView	= 	"APPR_STATUS_FRONT_USER";
	try
	{
	con	=	ConnectionManager.getConnection(request);
	if(!PreAuthEclaimYN.equals("Y")){
	CallableStatement cstmt1 = con.prepareCall("{ call BLPOLICYUSERACCESSDTLS.get_bl_privlege_yn(?,?,?,?,?,sysdate,?,?)}");
	cstmt1.setString(1, facility_id);			
	cstmt1.setString(2, userId);			
	cstmt1.setString(3, responsibility_id);			
	cstmt1.setString(4, functionID);			
	cstmt1.setString(5, recUserView);	
	cstmt1.registerOutParameter(6, java.sql.Types.VARCHAR);
	cstmt1.registerOutParameter(7, java.sql.Types.VARCHAR);
	cstmt1.execute();	
	p_privilege_val = cstmt1.getString(6);
	p_allowed_yn = cstmt1.getString(7);
	if(p_privilege_val.equals("Y") && p_allowed_yn.equals("Y")){
		validRecUserView = "Y";
	}
	else
	{			
		validRecUserView="N";
	} 
	cstmt1 = con.prepareCall("{ call BLPOLICYUSERACCESSDTLS.get_bl_privlege_yn(?,?,?,?,?,sysdate,?,?)}");
	cstmt1.setString(1, facility_id);			
	cstmt1.setString(2, userId);			
	cstmt1.setString(3, responsibility_id);			
	cstmt1.setString(4, functionID);			
	cstmt1.setString(5, frontUserView);	
	cstmt1.registerOutParameter(6, java.sql.Types.VARCHAR);
	cstmt1.registerOutParameter(7, java.sql.Types.VARCHAR);
	cstmt1.execute();	
	p_privilege_val = cstmt1.getString(6);
	p_allowed_yn = cstmt1.getString(7);
	if(p_privilege_val.equals("Y") && p_allowed_yn.equals("Y"))
	{
		validFrontUserView = "Y";
	}
	else
	{			
		validFrontUserView="N";
	} 
	System.err.println("validRecUserView BLApprStatusTrackInsWebSearch.jsp "+validRecUserView);
	System.err.println("validFrontUserView "+validFrontUserView);
	}else{
		disableField="disabled";
	}//102.2
	String sql="";
	int pat_id_len= 0;

	sql ="select patient_id_length from mp_param";

	pstmt = con.prepareStatement(sql);
	rs = pstmt.executeQuery();

	if (rs != null && rs.next() )
	{
		pat_id_len = rs.getInt("patient_id_length") ;
	}
	
	
%>
<script>


</script>

<BODY onload = "<%if( validFrontUserView =="Y" || validRecUserView == "Y" || PreAuthEclaimYN.equals("Y")){ 
%>onClickResult();<%}%>" onKeyDown="lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" >
	<FORM method='post' name="webSearch" id="webSearch" id="web_Search" action="" onsubmit="return onSearch()" >
		<table cellpadding='3' cellspacing=0 width="100%" align="center">
		<tr>
		<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	    <td>
	    	<input type="text" name="patient_id" id="patient_id" id="patient_id" maxlength="<%=pat_id_len %>" onBlur="ChangeUpperCase(this) ,primaryPatValidation(this);if(this.value != ''){return patLookup(); }"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
			<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return patLookup()" tabindex='2' />
		</td>
		<td class="label"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td>
			<input type="text" name="encounter_id" id="encounter_id" id="encounter_id"   maxlength="100"  onBlur="ChangeUpperCase( this );if(this.value!=''){encLookup();}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >	
			<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return encLookup()"  tabindex='2'>
		</td>
		<td nowrap id = 'servicelbl' class="label" width="16%"><fmt:message key="eBL.BillingService.Label" bundle="${bl_labels}"/></td>
			<td nowrap class="fields" colspan="2" width="16%">
				<input type="text" <%=disableField %> name="service_description" id="service_description" maxlength="100"  onblur="if(this.value!=''){serviceCodeLookUpCode();}" onKeyPress="return CheckForSpecChars(event);lockbackSpace();"  >	
				<input type='button' class='button' name="servicecodebut" id="servicecodebut" id="servicecodebut" value='?'  <%=disableField%> onClick="return serviceCodeLookUp()"/>
				<!-- <img src='../../eCommon/images/mandatory.gif'> -->	
			</td>
		</tr>
		<tr>
		
		<% if(!PreAuthEclaimYN.equals("Y")){ %>
		<td colspan="2"></td>
		
		<td class="label">
		<input type="radio" name="view" id="view" id = "view" <%if(!validFrontUserView.equals("Y") && validRecUserView.equals("Y")){%>checked<%}%>  class="label" value="R" onclick='storeVal(this);'><fmt:message key="eBL.RecApprView.label" bundle="${bl_labels}"/>
		</td>
		<td class="label">
		<input type="radio" name="view" id="view" id = "view" <%if(validFrontUserView.equals("Y") && !validRecUserView.equals("Y")){%>checked<%}%> class="label" value="F" onclick='storeVal(this);'><fmt:message key="eBL.FrontOffView.label" bundle="${bl_labels}"/>
		</td>
		<%}else{ %>
		<td colspan="4"></td>
		<%} %>
		<td class='button'>
		<input type='button' name="search_button" id="search_button" id='search_button'						 value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.search.label", "common_labels")%>" onClick='onClickResult();'>
		<input type='button' name="reset_button" id="reset_button" id='reset_button'	value="Reset" onClick='onWebReset();'>
		</td>
		</tr>
			
		</table>

		<input type='hidden' name='user' id='user' id='user' value='<%=user%>'>
		<input type='hidden' name='strclientip' id='strclientip' id='strclientip' value='<%=strclientip%>'>
		<input type='hidden' name='cusName' id='cusName' id='cusName' value='<%=cusName%>'> 
		<input type='hidden' name='customerCode' id='customerCode' id='customerCode' value='<%=customerCode%>'> 
		<input type='hidden' name='validFrontUserView' id='validFrontUserView' id='validFrontUserView' value='<%=validFrontUserView%>'>
		<input type='hidden' name='validRecUserView' id='validRecUserView' id='validRecUserView' value='<%=validRecUserView%>'>
		<input type='hidden' name='encounterFromDate' id='encounterFromDate' id='encounterFromDate' value='<%=encounterFromDate%>'>
		<input type='hidden' name='encounterToDate' id='encounterToDate' id='encounterToDate' value='<%=encounterToDate%>'>
		<input type='hidden' name='facility_id' id='facility_id' id='facility_id' value='<%=facility_id%>'>
		<input type='hidden' name='episodeType' id='episodeType' id='episodeType' value='<%=episodeType%>'>
		<input type='hidden' name='locale' id='locale' id='locale' value='<%=locale%>'>
		<input type='hidden' name='apprvSts_AAKHYN' id='apprvSts_AAKHYN' id='apprvSts_AAKHYN' value='<%=apprvSts_AAKHYN%>'><!--V230425-->
		<input type='hidden' name='val' id='val' id='val' value='<%=val%>'>
		<input type='hidden' name='PreAuthEclaimYN' id='PreAuthEclaimYN' id='PreAuthEclaimYN' value='<%=PreAuthEclaimYN%>'> 
		<input type='hidden' name='service_code' id='service_code' id='service_code' value=''>
<% } catch(Exception e) {
		out.println(e.toString());
		e.printStackTrace();
}
finally 
{
	try {
		if(pstmt != null) {
			pstmt.close();
		}
		if(rs != null) {
			rs.close();
		}
	} catch(Exception ex) {
		ex.printStackTrace();
	}
}%>
	</form>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>



