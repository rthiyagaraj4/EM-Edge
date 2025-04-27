<!DOCTYPE html>
<!-- This file created against MMS-QH-CRF-0079 [IN:038156] for September 2016 Release -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder,java.util.ArrayList,eDS.Common.JSONObject"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<jsp:useBean id="DSCommonBeanObj" class="eDS.DSCommonBean"/> 
<jsp:setProperty name="DSCommonBeanObj" property="FacilityId" value='<%=session.getAttribute("facility_id").toString()%>'/>
<jsp:setProperty name="DSCommonBeanObj" property="Locale" value='<%=session.getAttribute("LOCALE").toString()%>'/>
<%  
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends 
	String locale 			= (String)session.getAttribute("LOCALE");
	String sStyle 			= ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
	HttpSession httpSession = request.getSession(false);
	Properties p 			= (Properties)httpSession.getValue("jdbc");

	//String strloggeduser	= (String) httpSession.getValue("login_user");
	String strclientip		= "";
	strclientip				= p.getProperty("client_ip_address");
	String facility_id		= (String)session.getAttribute("facility_id");
	if(sStyle==null) sStyle	= "IeStyle.css";
	ArrayList<JSONObject> DS_Param_List = new ArrayList<JSONObject>();
	String Grace_Period="";
	DS_Param_List=DSCommonBeanObj.getDSParameterValue();
	JSONObject paramObj=new JSONObject();
	Iterator<JSONObject> itr=DS_Param_List.iterator();
	while(itr.hasNext()){
		paramObj=itr.next();
		Grace_Period=paramObj.get("Grace_Period").toString();
		
	}
	if(Grace_Period.equals("-")){
		Grace_Period="";
	}
	System.err.println("Grace_Period-----> jsp"+Grace_Period);
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>		
		<script language="JavaScript" src="../../framework/js/PopupWindow.js" type="text/javascript"></script>
		<script type="text/javascript" src="../../eDS/js/navbar.js"></script>
		<script type="text/javascript" src="../../eDS/js/simpletreemenu.js"></script>
		<script type="text/javascript" src="../../framework/js/hashtable.js"></script>
		<script language="Javascript" src="../../eDS/js/DSCommon.js"></script>
		<!--script type="text/javascript" src="../../eDS/js/PlaceDietOrder.js"></script-->
		<script language="Javascript" src="../../eDS/js/json.js"></script>		
		<script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
		<script language="Javascript" src="../../eDS/js/Moment.js"></script>
		<script language="Javascript" src="../../eDS/js/MomentRange.js"></script>
		<script language="Javascript" src="../../eDS/js/DSPlaceSupplementaryOrder.js"></script>
		<link rel="stylesheet" type="text/css" href="../../eDS/css/jquery-ui.css"/>
		 
		<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
		<script>
  		$(document).ready(function() {
	  	loadIPNursingUnit();
	  	setPatientIdLength();
		});
		</script>
<style>
	   	th, td { white-space: nowrap; }
		div.dataTables_wrapper {
        	width:95%;
	        margin: 0 auto;
		}
		.thwrap{
			position: relative;
            		top: expression(this.offsetParent.scrollTop);
			/*white-space:nowrap;*/
			/*color:#ff0000;*/
			font-size:12px;
			width:auto;		
			background: url("../images/headerSeparator.jpg") repeat-y;
			background-position:left;
			COLOR: white ;
			background-color:#83AAB4;
			border:0px;
			padding-left:3px;
			font-family: Verdana;
			font-size: 8pt;
			/*font-weight:bold;*/
			border-collapse:collapse; 
			/*position:absolute;*/
			left:0;
			top:auto;
			
			}
			.datawrap{
			/*align:center;*/
	}
</style>
	</head>
	<body  OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form action="" style="width:100%;height:100%;">
		<div id="search" style="width:100%;height:20%;border: 0px outset #9999FF;" align="center">
		<table border="0" cellpadding="2" cellspacing="0" width="100%" align="center" >
				<tr>
					<td class="label" align="left">
						<fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
					</td>
					<td>
						<select name="nursing_Unit" id="nursing_Unit" id="nursing_Unit" onChange="">							
						</select>
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
					
					<td class="label" align="left">
						<fmt:message key="eOT.admDate.Label" bundle="${ot_labels}"/>
					</td>
					<td class="label">
						<fmt:message key="Common.from.label" bundle="${common_labels}"/>
						<Input type="text"  name="dateFrom" id="dateFrom" id="dateFrom" size="10" maxlength="10" onkeypress="return checkForSpecCharsforID(event);"  onblur="isValidDate(this);"/>
						<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dateFrom');">
						<fmt:message key="Common.to.label" bundle="${common_labels}"/>
						<Input type="text"  name="dateTo" id="dateTo" id="dateTo" size="10" maxlength="10" onkeypress="return checkForSpecCharsforID(event);" onblur="isValidDate(this);"/>
						<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dateTo');">
					</td>
				</tr>
				<tr>
					<td class="label" width="10%">
						<fmt:message key="Common.patientId.label"   bundle="${common_labels}"/>
					</td>
					<td>
						<input type="text" name="patient_id" id="patient_id" id="patient_id" onKeypress='return CheckForSpecChars(event);' onBlur="makeValidString(this);ChangeUpperCase(this);">
						<input type='button' class='button' name=search value='?' class=button tabIndex="4" onClick="callPatientSearch()">
					</td>
					<td align="left" class="label">
						<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>
					</td>
					<td>
						<input type="text" name="encounter_id" id="encounter_id" id="encounter_id" value="" size='12' maxlength='12' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNumVal(this)"  >
					</td>
				</tr>
				<tr>
					<td class="label" align="left">
						<fmt:message key="eOT.practitioner.Label" bundle="${ot_labels}" />
					</td>
					<td>
						<input type="text" name="practitioner_name" id="practitioner_name" id="practitioner_name"  onblur="callPractSearch(this,practitioner_name)">
						<input type="button" name="click" id="click" value="?" onClick="callPractSearch(this,practitioner_name);" class="button"/>
						<input type="hidden" name="practitioner_id" id="practitioner_id" id="practitioner_id" value=""><!--59404-->
					</td>
					<td class="label" align="left">
						<fmt:message key="Common.gender.label" bundle="${common_labels}" />
					</td>
					<td>
						<select name="gender" id="gender" id="gender" onChange="">
						<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" /></option>
						<option value="M"><fmt:message key="Common.male.label" bundle="${common_labels}" /></option>
						<option value="F"><fmt:message key="Common.female.label" bundle="${common_labels}" /></option>
						<option value="U"><fmt:message key="Common.unknown.label" bundle="${common_labels}" /></option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="label" align="left">
						<fmt:message key="Common.status.label" bundle="${common_labels}" />
					</td>
					<td>
						<select name="status" id="status" id="status" onChange="">
							<option value="" selected><fmt:message key="Common.all.label" bundle="${common_labels}" /></option>
							<option value="O"><fmt:message key="eOT.OrderPlaced.Label" bundle="${ot_labels}" /></option>
						</select>
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr align="right">
				<td colspan="4">
					
					<input type="button" name="button1" id="button1" value="<fmt:message key="Common.search.label" bundle="${common_labels}" />" class="button" onClick="searchResult('search')"/>
					
					
				</td>
				</tr>
			
			</table>
		</div>
		<div id="nextprev" style="width:100%;height:5%;border: 0px outset #9999FF;visibility:visible" align="center">
		<table  align='right' id="nextprevtable">		
		</table>
		</div>
		<div id="result" style=" scroll;width:100%;height:75vh;border: 0px outset #9999FF;overflow-y:scroll;overflow-x:scroll" align="center">
		<table border="1" cellpadding="1" cellspacing="0" width='100%' align='center' id="supplementaryplacesearchtable" style="overflow-y: scroll;width:100%;">
		<!--tbody></tbody-->
		</table>
		</div>
		<div id="footer" style="width:100%;height:5%;border: 0px outset #9999FF;visibility:hidden" align="center">
		<table width="100%" height="100%" >
		<tr>
			<td align='right' width='3%' style="border-top-width: 0px;border-bottom-width: 0px;border-right-width: 0px;border-left-width: 0px;" class='ORANGE'> </td>
			<td align='left' width='13%' colspan='3' class='label'><fmt:message key="eOT.OrderPlaced.Label" bundle="${ot_labels}"/></td>

			<td ></td>
			<td align='left' width='13%' colspan='3' class='label'></td>

			<td ></td>
			<td align='left' width='13%' colspan='3' class='label'></td>

			<td > </td>
			<td align='left' width='13%' colspan='3' class='label'></td>
	
			<td align='left' width='3%'>
			</td>
			<td align='left' width='13%' colspan='3' class='label'></td>	
		</tr>
		</table>
		</div>
		<input type="hidden" id="locale" name="locale" id="locale" value=<%=locale%>>
		<input type="hidden" id="facility_id" name="facility_id" id="facility_id" value=<%=facility_id%>>	
		<input type="hidden" id="Start_Num" name="Start_Num" id="Start_Num" value="1">	
		<input type="hidden" id="End_Num" name="End_Num" id="End_Num" value="14">	
		<input type="hidden" id="Total_Record" name="Total_Record" id="Total_Record" value="">		
		<input type="hidden" id="nursing_Unit_hidden" name="nursing_Unit_hidden" id="nursing_Unit_hidden" value="1">	
		<input type="hidden" id="dateFrom_hidden" name="dateFrom_hidden" id="dateFrom_hidden" value="14">	
		<input type="hidden" id="dateTo_hidden" name="dateTo_hidden" id="dateTo_hidden" value="1">	
		<input type="hidden" id="patient_id_hidden" name="patient_id_hidden" id="patient_id_hidden" value="14">	
		<input type="hidden" id="encounter_id_hidden" name="encounter_id_hidden" id="encounter_id_hidden" value="1">	
		<input type="hidden" id="practitioner_id_hidden" name="practitioner_id_hidden" id="practitioner_id_hidden" value="14">	
		<input type="hidden" id="gender_hidden" name="gender_hidden" id="gender_hidden" value="1">	
		<input type="hidden" id="status_hidden" name="status_hidden" id="status_hidden" value="">	
		<input type="hidden" id="Grace_Period" name="Grace_Period" id="Grace_Period" value="<%=Grace_Period%>">		
		<input type="hidden" id="wardsForKitchenSetUp" name="wardsForKitchenSetUp" id="wardsForKitchenSetUp" value="">		
		<input type="hidden" id="requestContextPath" name="requestContextPath" id="requestContextPath" value=<%=request.getContextPath()%>>	
		</form>
	</body>
</html>

