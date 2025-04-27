<!DOCTYPE html>
<!-- Created Against ML-MMOH-CRF-0687-->
<%@ page import="webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder,java.util.ArrayList,eDS.Common.JSONObject"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<jsp:useBean id="DSCommonBeanObj" class="eDS.DSCommonBean"/> 
<jsp:setProperty name="DSCommonBeanObj" property="FacilityId" value='<%=session.getAttribute("facility_id").toString()%>'/>
<jsp:setProperty name="DSCommonBeanObj" property="Locale" value='<%=session.getAttribute("LOCALE").toString()%>'/>

<%
	String locale	= (String)session.getAttribute("LOCALE");
	String sStyle 	= ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
	HttpSession httpSession = request.getSession(false);
	Properties p	= (Properties)httpSession.getValue("jdbc");

	//String strloggeduser	= (String) httpSession.getValue("login_user");
	String strclientip	= "";
	strclientip			= p.getProperty("client_ip_address");
	String facility_id	= (String)session.getAttribute("facility_id");
	if(sStyle==null) sStyle	= "IeStyle.css";	
%>
<html>
	<head>
<% 
	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>	
	<script language="JavaScript" src="../../framework/js/PopupWindow.js" type="text/javascript"></script>
	<script type="text/javascript" src="../../eDS/js/navbar.js"></script>
	<script type="text/javascript" src="../../eDS/js/simpletreemenu.js"></script>
	<script type="text/javascript" src="../../framework/js/hashtable.js"></script>
	<script language="Javascript" src="../../eDS/js/DSCommon.js"></script>		
	<script language="Javascript" src="../../eDS/js/json.js"></script>		
	<script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	<script language="Javascript" src="../../eDS/js/Moment.js"></script>
	<script language="Javascript" src="../../eDS/js/MomentRange.js"></script>
	<script language="Javascript" src="../../eDS/js/MealAcknowledgeReport.js"></script>	
	<script language="Javascript" src="../../eDS/js/DSPlaceSupplementaryOrder.js"></script>
	<script language="Javascript" src="../../eDS/js/DSProcessSupplementary.js"></script>
	<script language='javascript' src='../../eDS/js/DSMealComplaint.js'></script>
	<link rel="stylesheet" type="text/css" href="../../eDS/css/jquery-ui.css"/>
	 
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>	
	<script language="Javascript" src="../../eDS/js/json.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body  OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="getResult('onLoad');">
	<form action="" style="width:100%;height:100%;">
		<div id="search" style="width:100%;height:20%;border: 0px outset #9999FF;" align="center">
		<table border="0" cellpadding="2" cellspacing="0" width="90%" align="center" >
		<tr>
			<td class="label" align="right">
				<fmt:message key="eDS.ServingDateFrom.Label" bundle="${ds_labels}" />
			</td>
			<td>
				<input type="text" name="servingDate" id="servingDate" id="servingDate" size="10" maxlength="10" value="" onkeypress="return checkForSpecCharsforID(event);"   onblur="isValidDate(this);" >
				<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('servingDate');">				
			</td>
			
			<td class="label" align="right">
				<fmt:message key="eDS.ServingDateTo.Label" bundle="${ds_labels}" />
			</td>
			<td>
				<input type="text" name="servingDateTo" id="servingDateTo" id="servingDateTo" size="10" maxlength="10" value="" onkeypress="return checkForSpecCharsforID(event);"   onblur="isValidDate(this);" >
				<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('servingDateTo');">
				
			</td>
					
		</tr>
				
		<tr>
<% 
			try{
					String patient_type_code="";
					con = ConnectionManager.getConnection(request);
					String sql_patient_class="SELECT PATIENT_CLASS,SHORT_DESC FROM AM_PATIENT_CLASS_LANG_VW WHERE LANGUAGE_ID='"+locale+"' and patient_class != 'DC' ORDER BY 1";
					pstmt = con.prepareStatement(sql_patient_class);
					rst = pstmt.executeQuery();
%>
			<td class="label" align="right">
				<fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>
			</td>
			<td>
				<select name="Patient_Class" id="Patient_Class" id="Patient_Class" onChange="">
				<option value="" selected>All</option>	
					
<%
					while(rst.next()) {
					if(!rst.getString(1).equalsIgnoreCase("XT"))
					{
						patient_type_code=patient_type_code+rst.getString(1)+"$$";
%>
						<option value="<%=rst.getString(1)%>">
						<%=rst.getString(2) %>
						</option>
<%					}}
					  if(rst !=null) rst.close();
					  if(pstmt !=null) pstmt.close();
					  }
			catch(Exception e){
			System.err.println("Exception in DietOrderStatus:"+e);
			e.printStackTrace();
		}
		finally{
   			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				e.printStackTrace();
				System.err.println("Exception in Texture of Diet:"+e);
			}
   		}
%>						
		</select>
		</td>

			<td class="label" align="right">
				<fmt:message key="Common.patientId.label"   bundle="${common_labels}"/>
			</td>
		<td>					
				<input type="text" name="patient_id" id="patient_id" id="patient_id" onKeypress='return CheckForSpecChars(event);' onBlur="makeValidString(this);ChangeUpperCase(this);">
				<input type='button' class='button' name=search value='?' class=button tabIndex="4" onClick="callPatientSearch()">		
			</td>		
		</tr>			
				
		<tr>
			<td class="label" align="right">
				<fmt:message key="eDS.AcknowledgeStatus.Label" bundle="${ds_labels}"/>
			</td>
			<td>
				<select name="AcknowledgeStatus" id="AcknowledgeStatus" id="AcknowledgeStatus" onChange="">
					<option value="N" selected>No</option>							
					<option value="Y">Yes</option>							
					<option value="A">All</option>							
				</select>
			</td>	
			
			<td class="label" align="right">
				<fmt:message key="eDS.PatientStatus.Label"   bundle="${ds_labels}"/>
			</td>
			<td>
				<select name="PatientStatus" id="PatientStatus" id="PatientStatus" onChange="">
				<option value="" selected>All</option>	
				<option value="A" >Active</option>							
				<option value="D">Discharged</option>							
				</select>
			</td>
		</tr>				

		<tr>
			</td>
			<td class="label" align="right">
			
			</td>
			<td class="label" align="right">
			
			</td>
			<td class="label" align="right">
			
			</td>
			<td class="label" align="right">
			
			</td>
			<td class="label" align="right">

				<input type="button" value="Select"  class="BUTTON"/ onclick="getResult('onClick')">
			</td>
		</tr>			
		</table>			
		
		</div>
		<div id="nextprev" style="width:100%;height:5%;border: 0px outset #9999FF;visibility:visible" align="center">
		<table align='right' id="nextprevtable">		
		</table>
		</div>
		<div id="result" style=" scroll;width:100%;height:70%;border: 0px outset #9999FF;" align="center">
		<table border="1" cellpadding="1" cellspacing="0" width='100%' align='center' id="supplementaryplacesearchtable" style="overflow-y: scroll;width:100%;border: 1px outset #9999FF;">
		</table>
		</div>
		<div id="footer" style="width:100%;height:5%;border: 0px outset #9999FF;visibility:hidden" align="center">
		<table width="100%" height="100%" >
		<tr>
			<td align=='right' width='3%' class='ORANGE'> </td>
			<td align='left' width='13%' colspan='3' class='label'>
			<fmt:message key="eOT.OrderPlaced.Label" bundle="${ot_labels}"/>
			</td>

			<td ></td>
			<td align='left' width='13%' colspan='3' class='label'></td>

			<td ></td>
			<td align='left' width='13%' colspan='3' class='label'></td>

			<td > </td>
			<td align='left' width='13%' colspan='3' class='label'></td>
	
			<td align='right' width='3%'>
			</td>
			<td align='left' width='13%' colspan='3' class='label'></td>	
		</tr>
		</table>
		
		</div>
		<input type="hidden" id="locale" name="locale" id="locale" value=<%=locale%>>
		<input type="hidden" id="facility_id" name="facility_id" id="facility_id" value=<%=facility_id%>>		
		<input type="hidden" id="onCall" name="onCall" id="onCall" value="onLoad">
		<input type="hidden" value=""  id="ComplaintList"/>
		</form>		
	</body>
</html> 

