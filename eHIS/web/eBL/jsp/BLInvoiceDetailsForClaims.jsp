<!DOCTYPE html>
<!-- 
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V201125            8073        MOHE-CRF-0055           Nandhini M
2			 V211020											Mohanapriya K
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
<script language="JavaScript" src="../../eBL/js/BLInvoiceDetailsForClaims.js"></script> 
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function setDefault(){
	var date = new Date();
	var mon= date.getMonth()+1; //added against 9861
	var yr=date.getYear();
	document.getElementById("Month").value=mon;
	document.getElementById("Year").value=yr;
}

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
	String applyMode	=	new String();
	String locale		=	"";
	String p_user_name	= (String) session.getValue( "login_user" );
	String mode			=	"";
	String isUserCanAcess	=	"";
	Connection con = null;
	ResultSet rst = null;
	ResultSet rst2 = null;
	ResultSet rst3 = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt3 = null;
	String facility_id = (String)session.getAttribute("facility_id");	

	try  
	{		 
		locale  = 	(String)session.getAttribute("LOCALE");
		isUserCanAcess = (String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));	
%>

<BODY onScroll="processScroll()" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onLoad="setDefault()" onSelect="codeArrestThruSelect();" style="padding-left:10px;padding-right:10px;padding-top:5px;">
 <form name="BLCollectionSummaryForm" id="BLCollectionSummaryForm" id="BLCollectionSummaryForm"  action="../../eCommon/jsp/report_options.jsp" target="messageFrame" > 

<TABLE width="100%" CELLSPACING='0' cellpadding='3' align="center" >
	<tr>
		<td  class="columnheader" ><fmt:message key="eBL.ReportCriteria.label" bundle="${bl_labels}"/> </td>
	</tr>	
</TABLE>
<br>
<table cellpadding='10' cellspacing='0' width="100%" align="center" border='0'>	
	<tr>
		<td class="label" style="width:10%"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		<td class='fields' style="width:10%">
			<Select name='facility' id='facility' id="facility" style="width: 100px;">

		<%				
			try{
					String sqlFacility = "select facility_id, facility_name from Sm_Facility_Param where status = 'E'";
					con = ConnectionManager.getConnection();
					pstmt = con.prepareStatement(sqlFacility);
					rst = pstmt.executeQuery();
					if(rst != null){
						while(rst.next()){
							if(rst.getString("facility_id").equals(facility_id)){					
		%>
						<option selected value='<%=rst.getString("facility_id") %>'><%=rst.getString("facility_name") %></option>
		<%			
					}else{			
		%>
								<option value='<%=rst.getString("facility_id") %>'><%=rst.getString("facility_name") %></option>
		<%				}
						}
						rst.close();
					}
					pstmt.close();
				}
				catch(Exception e){
					System.err.println("Exception in Info Frame Load - "+e);
					e.printStackTrace();
				}
		%>
				</Select>&nbsp;<img src='../../eCommon/images/mandatory.gif'>
				</td>
	</tr>

	<tr>
		<td  class="label" width="10%">
			<fmt:message key="eBL.Invoices_month_yr.label" bundle="${bl_labels}"/>
		</td>
		<td  class="fields" style="width:20%">
			
			<select name="Month" id="Month" id="Month"  style="width: 100px;">       
		<%
			try{
				List<String> monthsList = new ArrayList<String>();
				String[] months = new DateFormatSymbols().getMonths();
				int length=months.length-1;
				for (int i = 0; i < length; i++) {
				String month = months[i];
				int j=i+1; //added against 9861
		%>
			<option value="<%=j%>">  <%=month%></option>
		<% 
				monthsList .add(months[i]);
				}
				}catch(Exception e){
					try{
						if(pstmt2!=null) pstmt2.close();
						if(rst2!=null) rst2.close();
						//ConnectionManager.returnConnection(con); //V211020
					}catch(Exception exp)
					{
						System.err.println("Exception in month Load - "+exp);
						exp.printStackTrace();
					}
			}	
		%>
			 </select>	
			 <select name="Year" id="Year" id="Year" style="width: 100px;">  
		<% 		 
			try{
					String sql3="select to_char(sysdate,'yyyy') from dual";
				//	con = ConnectionManager.getConnection(); //V211020
					pstmt3 = con.prepareStatement(sql3);
					rst3 = pstmt3.executeQuery();
					if(rst3 != null){
						while(rst3.next()){
						String strYr = rst3.getString(1);
					if(strYr!=null){
						int currentYear=Integer.parseInt(strYr);
					for(int i=currentYear;i>=2000;i--) {
		%>
					<option value="<%=i%>" ><%=i%></option>
		<%			}
					}
				}
				}
				}
			catch(Exception e){
				try{
					if(pstmt3!=null) pstmt3.close();
					if(rst3!=null) rst3.close();
					ConnectionManager.returnConnection(con);
				}catch(Exception ex){
					System.err.println("Exception in Info Frame Load - "+ex);
					ex.printStackTrace();
				}
			}
		%>
		</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'>
		</td>
	</tr>	
	</table>		
		
	<input type='hidden' name='locale' id='locale' 		id='locale'			value="<%=locale%>" >
	<input type="hidden" name="p_module_id" id="p_module_id" id="p_module_id" 	value="BL"	>
	<input type="hidden" name="p_report_id" id="p_report_id" id="p_report_id"	value="BLRINVDC" >
	<input type="hidden" name="pgm_id" id="pgm_id" 		id="pgm_id"			value=""	> 		
	<input type="hidden" name="p_facility_id" id="p_facility_id" 	id="p_facility_id" value="<%=facility_id%>"	>
	<input type="hidden" name="p_user_name" id="p_user_name" 	value="<%=p_user_name%>">
	<input type="hidden" name="p_episode_id" id="p_episode_id" 	value="">
	<input type="hidden" name="p_visit_id" id="p_visit_id" 	id="p_visit_id"		value="" >
	<input type="hidden" name="p_patient_id" id="p_patient_id"	id="p_patient_id" value=""	>
	<input type="hidden" name="p_session_id" id="p_session_id" 	value="">	
</form>
</BODY>
	 <%
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception in BLCollectSumryReport.jsp::"+e);
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

