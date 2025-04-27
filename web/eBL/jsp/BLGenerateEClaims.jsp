<!DOCTYPE html>
<!-- 
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V210401                      MOHE-CRF-0063-TF-US001    Shikha Seth
2			 V210517			16591	  MOHE-CRF-0055.1			Nandhini M
3			 V210615			20139	  MOHE-CRF-0055.2			Mohana Priya K
-->

<%@page import="java.sql.Date"%>
<%@ page import ="eBL.*,eBL.Common.*,java.sql.*,java.math.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<html>	
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eBL/js/BLGenerateEClaims.js"></script> 
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>

<script type="text/javascript">
$(document).ready(function(){   
     $('#facilityid').val($('#facility_id').val()) ;         
     getFacility('',$('#facilityid').val(),1);        
 });
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
/*function setDefault(){
	var date = new Date();
	var mon= date.getMonth()+1; //added against 9861
	var yr=date.getYear();
	document.getElementById("Month").value=mon;
	document.getElementById("Year").value=yr;
}*/

function processScroll(){
	if (headTop < 0)
	{
		saveHeadPos();
	}
	if (headTop>0)
	{
		if (document.documentElement && document.documentElement.scrollTop)
			theTop = document.documentElement.scrollTop;
		else if (document.body)
			theTop = document.body.scrollTop;

		if (theTop>headTop)
			FloatHead1.style.top = (theTop-headTop) + 'px';
		else
			FloatHead1.style.top = '0px';
	}
}

function saveHeadPos(){
	parTable = document.getElementById("divHeadSep");
	if (parTable != null)
	{
		headTop = parTable.offsetTop + 3;
		FloatHead1 = document.getElementById("heading");
		FloatHead1.style.position = "relative";
	}
}

function lockbackSpace(){
	var mode = document.mode.value;
	if(mode=='modify' && window.event.keyCode==8)
	{
		//return false;
	}
}
</script>

</head>
<style>
		thead td, thead td.locked { 
		background-color: navy;
		color: white;
		position:relative;}	
		thead td {
		top: expression(document.getElementById("tbl-container").scrollTop-4); 
		z-index: 20;}
		thead td.locked {z-index: 30;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative;
		z-index: 10;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative; 
		z-index: 10;}
		</style>
<%
	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
	response.setHeader("Pragma","no-cache"); //HTTP 1.0   
	response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
	//String applyMode	=	new String();
	String locale		=	"";
	String p_user_name	= (String) session.getValue( "login_user" );
	//String mode			=	"";
	String isUserCanAcess	=	"";
	/*Connection con = null;
	ResultSet rst = null;
	ResultSet rst2 = null;
	ResultSet rst3 = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt3 = null;*/
	String facility_id = (String)session.getAttribute("facility_id");	
	String fetchoption=request.getParameter("fetchoption"); //V210615
	if(fetchoption==null) fetchoption=""; //V210615
	System.err.println("fetchoption="+fetchoption);
	try  
	{		 
		locale  = 	(String)session.getAttribute("LOCALE");
		isUserCanAcess = (String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));	
%>

<BODY onScroll="processScroll()" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" style="padding-left:10px;padding-right:10px;padding-top:5px;">
 <form name="BLGenerateEClaims" id="BLGenerateEClaims" id="BLGenerateEClaims"  action="../../eCommon/jsp/report_options.jsp" target="messageFrame" > 

<TABLE width="100%" CELLSPACING='0' cellpadding='3' align="center" >
	<tr>
		<td  class="columnheader" ><fmt:message key="eBL.ReportCriteria.label" bundle="${bl_labels}"/> </td>
	</tr>	
</TABLE>
<br>
<TABLE width="100%" CELLSPACING='0' cellpadding='3' align="center" >	
	<tr>	<td width='10%' class='label'><fmt:message key="eBL.Facility.label" bundle="${bl_labels}" /></td>			
			<td class='fields'>
				<input type='text' name='facilityidName' id='facilityidName' id='facilityidName' size='20' maxlength='40' value=''  onblur='if(this.value!=""){ getFacility(facilityidName,facilityid,2) } else{ clearCode(facilityid); } '/>
				<input type='hidden' name='facilityid' id='facilityid' id='facilityid' value=''>
				<input type='button' class='button' name="facilityid_btn" id="facilityid_btn" value='?' onClick="getFacility(facilityidName,facilityid,2)" tabindex='2'>				
			&nbsp;<img src='../../eCommon/images/mandatory.gif'>
			</td>
			<td  width='10%' class='label'><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}" /></td>
			<td class='fields'>
					<select id="episode_type" name='episode_type' id='episode_type'>
						<!-- V210518 -->
						<option value='OP'>
						<fmt:message key="Common.Outpatient.label"
						bundle="${common_labels}" />
						</option>							
						<option value='IP'>
						<fmt:message key="Common.inpatient.label"
						bundle="${common_labels}" />
						</option>
						<option value='**'>							
						<fmt:message key="eBL.BOTH.label" bundle="${bl_labels}" />			
						</option>
						<!-- V210518 -->						
					</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'>
			</td>
			<td  width='5%' class='label'><fmt:message key="eBL.EClaim.label" bundle="${bl_labels}" /></td>
				<td class='fields'>
				<select id="eclaim_report_option" name='eclaim_report_option' id='eclaim_report_option'>
						<option value='R'>
						<fmt:message key="Common.Review.label" bundle="${common_labels}" />
						</option>
						<option value='C'>Claim
						</option>
				</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'>
			</td>
	</tr>			
	<tr><!-- V210615 Starts-->
		<td  width='13%' class='label'><fmt:message key="eBL.Fetchdataby.label" bundle="${bl_labels}" /></td>
		<td class='fields'>
			<select id='fetch_option' name='fetch_option' id='fetch_option' onchange="fetchDataBy();">
					<option value='B' <%=fetchoption.equals("B")?"selected":""%>>
					<fmt:message key="eBL.BILL_DATE.label" bundle="${bl_labels}" />
					</option>
					<option value='E' <%=fetchoption.equals("E")?"selected":""%>>
					<fmt:message key="Common.encounterdate.label" bundle="${common_labels}" />
					</option>
			</select>&nbsp;
		</td>
		
		<%if(fetchoption.equals("E")){ %>
			<!-- V210615 Encounter date -->
			<td  class="label" width="15%" id="enc_date_frm">
				<fmt:message key="eBL.Encounterdatefrom.label" bundle="${bl_labels}"/>
			</td>
			<td  class='fields'>
				<input type="text" name="fm_enc_date" id="fm_enc_date" id="fm_enc_date" size="10" maxlength='10' value='' onBlur='return checkEncDateBL(document.forms[0].fm_enc_date);return dateRegEx(this)' >&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('fm_enc_date');"> <img src='../../eCommon/images/mandatory.gif'> 
			</td>
			<td  class="label" width="15%" id="enc_date_to">
				<fmt:message key="eBL.Encounterdateto.label" bundle="${bl_labels}"/>
			</td>
			<td class='fields'>
				<input type="text"  name="to_enc_date" id="to_enc_date"  id="to_enc_date"   size="10" maxlength='10' value='' onBlur='return toFromEncDateChk(document.forms[0].to_enc_date);return dateRegEx(this)' >&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_enc_date');"><img src='../../eCommon/images/mandatory.gif'>
			</td> 
		<%}else{ %>
			<!-- V210615 bill date -->
			<td  class="label" width="12%" id="bill_date_frm">
				<fmt:message key="eBL.FromBillDate.label" bundle="${bl_labels}"/>
			</td>
			<td  class='fields'>
				<input type="text" name="fm_bill_date" id="fm_bill_date" id="fm_bill_date" size="10" maxlength='10' value='' onBlur='return checkDateBL(document.forms[0].fm_bill_date);return dateRegEx(this)' >&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('fm_bill_date');"> <img  src='../../eCommon/images/mandatory.gif'> 
			</td>
			<td  class="label" width="10%" id="bill_date_to">
				<fmt:message key="eBL.ToBillDate.label" bundle="${bl_labels}"/>
			</td>
			<td class='fields'>
				<input type="text"  name="to_bill_date" id="to_bill_date"  id="to_bill_date"   size="10" maxlength='10' value='' onBlur='return toFromDateChk(document.forms[0].to_bill_date);return dateRegEx(this)' >&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_bill_date');"><img  src='../../eCommon/images/mandatory.gif'>
			</td>
		<%}%>
		<!-- V210615 Ends-->
		
		<!-- <td class='fields' width="18%" > 
			<input type='button' class='button' id="exportbut" name="exportbut" id="exportbut" value='Export Excel' onClick="callExcelDisplay();" width="15" height="15" title='<fmt:message key="eOT.ReportinExcelFormat.Label" bundle="${ot_labels}"/>'  >
		</td> -->
	</tr>	
	</table>		
	<input type='hidden' name='locale' id='locale' 		id='locale'			value="<%=locale%>" >
	<input type="hidden" name="p_module_id" id="p_module_id" id="p_module_id" 	value="BL"	>	
	<input type="hidden" name="p_C_report_id" id="p_C_report_id" value='BLRINVDC'>
	<input type="hidden" name="p_R_report_id" id="p_R_report_id" value='BLRINVDC'>
	<input type="hidden" name="pgm_id" id="pgm_id" 		id="pgm_id"			value=""	> 		
	<input type="hidden" name="facility_id" id="facility_id"		id="facility_id" value="<%=facility_id%>"	>
	<input type="hidden" name="p_user_name" id="p_user_name" 	value="<%=p_user_name%>">	
	<input type="hidden" name="p_session_id" id="p_session_id" 	value="">	
	<input type='hidden' name='noOfCols' id='noOfCols' value=''>	
	<input type='hidden' name='fetchoption' id='fetchoption' id='fetchoption' value='<%=fetchoption%>'>
</form>
</BODY>
<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.err.println("Exception in BLGenerateEClaims.jsp::"+e);
	}
%>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
		
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
</HTML>

