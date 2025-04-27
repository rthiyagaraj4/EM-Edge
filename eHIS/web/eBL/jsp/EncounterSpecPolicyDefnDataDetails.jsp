<!DOCTYPE html>
<!--
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
23/10/12      100         Rajesh Varadharajan  created
Acts as create and Modify screen for Receipt Nature
called on click of create button from common tool bar
on submission (apply) request will be submitte dto ReceiptNatureServlet
-----------------------------------------------------------------------------------------------
-->

<%/*
Sr No        Version           Incident        SCF/CRF             Developer Name
----------------------------------------------------------------------------------
 1           V230315						MMS-DM-CRF-0209.5		Namrata Charate
*/ %>

<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*, eBL.Common.*,  eCommon.Common.*" contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

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
<script language="JavaScript" src="../../eBL/js/EncounterSpecPolicyDefnSrch.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

var ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL	=	"<%="ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL"%>";
var PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL	=	"<%="PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL"%>";	
var PAYER_LOOKUP_RECORD_PREAPPROVAL			=	"<%="PAYER_LOOKUP_RECORD_PREAPPROVAL"%>";	
var POLICY_LOOKUP_RECORD_PREAPPROVAL		=	"<%="POLICY_LOOKUP_RECORD_PREAPPROVAL"%>";	
var headTop = -1;
var FloatHead1;
function processScroll()
	{
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

	function saveHeadPos()
	{
		parTable = document.getElementById("divHeadSep");
		if (parTable != null)
		{
			headTop = parTable.offsetTop + 3;
			FloatHead1 = document.getElementById("heading");
			FloatHead1.style.position = "relative";
		}
	}
	
	function lockKey()
	  {
		 	 
		if(event.keyCode == 93)
			alert("Welcome to eHIS");
	  }

	  function lockbackSpace()
	  {
		// alert(document.order_type_form.mode.value);
		   var mode = document.mode.value;
      // alert(window.event.keyCode);
		 if(mode=='modify' && window.event.keyCode==8)
		  {
           //return false;
		  }
	  }	 
	
</script>
</head>
<style>
		thead td, thead td.locked	{ 
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

		TD.YELLOW 
		{
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			border-style: dashed;
			border-left-color: #D5E2E5;
			border-right-color: #D5E2E5;
			border-top-color: #D5E2E5;
			border-bottom-color: #D5E2E5; 
		}
		</style>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
response.setHeader("Pragma","no-cache"); //HTTP 1.0   
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
String applyMode																			=	new String();
String locale																				=	"";
String facilityId																			=	"";
String loggedInUser																			=	"";
String mode																					=	"";
String isUserCanAcess																		=	"";
String bean_id																				=	"";
String bean_name																			=	"";
String modifyStatus     																	=	"";
String patinetId																			=	"";
String episodeType																			=	"";
String episodeId = "";
String encounterDate = "";
String auth = "";
String apprvl = "";
String reload	= checkForNull(request.getParameter("reload"));
String clickedRow	= request.getParameter("rowClicked");
if(clickedRow == null || "null".equals(clickedRow)){
	clickedRow = "";
}
Connection con	= null;
PreparedStatement pstmt = null;
ResultSet rst = null;


try  
{
	 
	sStyle 																					=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 																					= 	(String)session.getAttribute("LOCALE");
	facilityId																				=   (String) session.getValue( "facility_id" ) ;
	patinetId																				=	checkForNull(request.getParameter("patinetId"));
	episodeType																				=	checkForNull(request.getParameter("episodeType"));
	episodeId = checkForNull(request.getParameter("episodeId"));
	auth = checkForNull(request.getParameter("auth"));
	apprvl = checkForNull(request.getParameter("apprvl"));
	encounterDate = checkForNull(request.getParameter("encounter_date"));
	System.out.println("patinetId IN EncounterSpecPolicyDefnDataDetails.jsp:::: "+patinetId);
	System.out.println("episodeType IN EncounterSpecPolicyDefnDataDetails.jsp:::: "+episodeType);
	System.out.println("episodeId IN EncounterSpecPolicyDefnDataDetails.jsp:::: "+episodeId);
	
	con = ConnectionManager.getConnection(request);
	String patientList =  "";
	
	if(("O".equals(episodeType)) ||  ("E".equals(episodeType))){
		patientList = 	BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_DATA_DETAILS_OE");
	}
	else if(("I".equals(episodeType)) || ("D".equals(episodeType))){
		patientList = 	BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_DATA_DETAILS_ID");
	}
	else if(("R".equals(episodeType))){
		patientList = 	BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_DATA_DETAILS_R");
	}

	System.err.println("The Sql is->"+patientList);
	if(!("R").equals(episodeType)){
		if(!(("".equals(patinetId)) || ("".equals(episodeType)) || ("".equals(episodeId)))){
			pstmt = con.prepareStatement(patientList);
			pstmt.setString(1, patinetId);
			pstmt.setString(2, episodeType);
			pstmt.setString(3, facilityId);
			pstmt.setString(4, patinetId);
			pstmt.setInt(5, Integer.parseInt(episodeId));
			pstmt.setInt(6, Integer.parseInt(episodeId));
			pstmt.setString(7, facilityId);			
			pstmt.setInt(8, Integer.parseInt(episodeId));
			pstmt.setString(9, patinetId);
			pstmt.setString(10, encounterDate);
			
			rst = pstmt.executeQuery();
		}
	}
	else{
		if(!(("".equals(patinetId)) || ("".equals(episodeType)))){
			pstmt = con.prepareStatement(patientList);
			pstmt.setString(1, patinetId);
			pstmt.setString(2, episodeType);
			pstmt.setString(3, facilityId);
			pstmt.setString(4, patinetId);
			pstmt.setString(5, encounterDate);
			rst = pstmt.executeQuery();
			}
	}
	

%>
<body onScroll="processScroll()" onKeyDown= "lockKey();" onMouseDown="CodeArrest();"    ; onSelect="codeArrestThruSelect();">
	<form id="recordApprovalPatientData" name="recordApprovalPatientData" id="recordApprovalPatientData">	


	
		
		<TABLE width="100%" CELLSPACING=0 cellpadding=3 align='center'>
			<tr >
			
			
					<th  class="columnheader"  align="left">Patient Data</th></tr>		
</TABLE>
<br>

 <table align='center' cellpadding=3 cellspacing=0 border=0 width='100%'  id="panel_categories_table_header"  name="panel_categories_table_header" id="panel_categories_table_header" scrolling='auto' >			
		<tr>
			
			
			<th class='CAFLOWSHEETLEVEL1'	align="left"	width="4%">Sr.No</th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	width="7%">Billing Group</th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	width="7%" >Payer Grp.</th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	width="7%" ><fmt:message key="Common.Payer.label" 					bundle="${common_labels}"	/></th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	width="7%" ><fmt:message key="eBL.POLICY.label" 					bundle="${bl_labels}"		/></th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	width="8%">Policy No</th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	width="7%">Visit Id</th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	width="7%">Encounter Id</th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	width="6%">Effective From</th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	width="8%">Effective To</th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	width="7%">Policy Expiry Date</th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	width="8%">CR Auth No</th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	width="10%" >CR Auth Date</th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	width="10%" ><fmt:message key="eBL.APPROVED_AMT.label" 				bundle="${bl_labels}"		/></th>
		</tr>

</table>
<div id="card_type_div" name="card_type_div" style="width:100%; height:200px; overflow: auto; " >		 
	<table align='center'  cellpadding=3 cellspacing=0  width='100%' id="panel_categories_table" name="panel_categories_table" id="panel_categories_table" border="1">	 
	<%
	if(rst!=null){
		int index = 1;
	while(rst.next())
	{ 
%>
			<tr id='tr_<%=index %>' onClick = "loadPolicyDetails('tr_<%=index %>','<%=checkForNull(rst.getString("CUST_CODE")) %>','<%=checkForNull(rst.getString("CUST_GROUP_CODE")) %>',
					'<%=checkForNull(rst.getString("POLICY_TYPE_CODE")) %>','<%=patinetId %>','<%=checkForNull(rst.getString("EFFECTIVE_FROM")) %>','<%=checkForNull(rst.getString("EFFECTIVE_TO")) %>',
					'<%=checkForNull(rst.getString("VISIT_ID")) %>','<%=checkForNull(rst.getString("ACCT_SEQ_NO")) %>','<%=checkForNull(rst.getString("PRIORITY")) %>',
					'<%=checkForNull(rst.getString("POLICY_NUMBER")) %>','<%=episodeType %>','<%=episodeId %>','<%=index %>','<%=auth %>','<%=apprvl %>','<%=checkForNull(rst.getString("ENCOUNTER_ID")) %>')" >   <!-- V230228  -->
				<td  class='fields' id='td_<%=index%>_1' width="4%">	<%=index %></td> 
				<td	 class='fields' id='td_<%=index%>_2' width="7%">	<%=checkForNull(rst.getString("BLNG_GRP_ID")) %></td> 
				<td  class='fields'	id='td_<%=index%>_3' width="7%">	<%=checkForNull(rst.getString("CUST_GROUP_CODE")) %></td> 
				<td  class='fields'	id='td_<%=index%>_4' width="7%"> <%=checkForNull(rst.getString("CUST_CODE")) %></td> 
				<td  class='fields'	id='td_<%=index%>_5' width="7%"> <%=checkForNull(rst.getString("POLICY_TYPE_CODE")) %></td>
				<td  class='fields'	id='td_<%=index%>_6' width="8%"> <%=checkForNull(rst.getString("POLICY_NUMBER")) %></td> 
				<td  class='fields'	id='td_<%=index%>_13' width="7%"> <%=checkForNull(rst.getString("VISIT_ID")) %></td> 
				<td  class='fields'	id='td_<%=index%>_14' width="7%"> <%=checkForNull(rst.getString("ENCOUNTER_ID")) %></td> 
				<td  class='fields'	id='td_<%=index%>_7' width="6%">	<%=checkForNull(rst.getString("EFFECTIVE_FROM")) %></td> 
				<td  class='fields'	id='td_<%=index%>_8' width="8%">  <%=checkForNull(rst.getString("EFFECTIVE_TO")) %></td>
				<td  class='fields'	id='td_<%=index%>_9' width="7%"> <%=checkForNull(rst.getString("POLICY_EXPIRY_DATE")) %></td>
				<td  class='fields'	id='td_<%=index%>_10' width="8%"> <%=checkForNull(rst.getString("CREDIT_AUTH_REF")) %></td> 
				<td  class='fields'	id='td_<%=index%>_11' width="10%">  <%=checkForNull(rst.getString("CREDIT_AUTH_DATE")) %></td> 
				<td  class='fields'	id='td_<%=index%>_12' width="10%"> <%=checkForNull(rst.getString("APPROVED_AMT")) %></td>
				<input type="hidden" 	id="visit_id<%=index%>" 			name="visit_id<%=index%>" 	 	 value="<%=checkForNull(rst.getString("VISIT_ID")) %>" />
				<input type="hidden" 	id="episode_type<%=index%>" 		name="episode_type<%=index%>" 	 value="<%=checkForNull(rst.getString("episode_type")) %>" />
				<input type="hidden" 	id="priority<%=index%>" 			name="priority<%=index%>" 	 	 value="<%=checkForNull(rst.getString("PRIORITY")) %>" />
				<input type="hidden" 	id="acct_seq_no<%=index%>" 			name="acct_seq_no<%=index%>" 	 value="<%=checkForNull(rst.getString("ACCT_SEQ_NO")) %>" />
				
			</tr>
			<%
		index++;
	}
	}
			%>
	</table>
</div>		

<br>
		<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
		<input type='hidden' name='facilityId' id='facilityId' value="<%=facilityId%>" >
		<input type='hidden' name='mode' id='mode' value="<%=mode%>" >
		<input type='hidden' name='prevClicked' id='prevClicked' value='N'>
		<input type='hidden' name='rowClicked' id='rowClicked' value = ''>
		<input type='hidden' name='haveAccess' id='haveAccess' value= ''>

<%if("Y".equals(reload) && !"".equals(clickedRow)){ %>
	<script>
		fnReloadPrevSelected(<%=clickedRow%>);
	</script>	
<%} %>
</body>
<%
}
catch(Exception e)
{
	System.out.println("Exception in EncounterSpecPolicyDefnDataDetails.jsp::"+e);
}
finally{
	ConnectionManager.returnConnection(con);
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
</html>

