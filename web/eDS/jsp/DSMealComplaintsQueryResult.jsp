<!DOCTYPE html>
<!-- Created for ML-MMOH-CRF-0687 -->
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,eDS.Common.JSONObject,java.net.URLEncoder,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<jsp:useBean id="DSCommonBeanObj" class="eDS.DSCommonBean"/> 
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language='javascript' src='../../eDS/js/DSMealComplaint.js'></script>
<script language="Javascript" src="../../eDS/js/json.js"></script>
<html>
<head>
<!-- Heading Static - Scrolling -->
<style>
		 TD.OTMENULAYER
		  {
	 	  FONT-FAMILY: VERDANA ;
	 	  FONT-SIZE: 10PT ;
	 	  BACKGROUND-COLOR: #D8BFD8;
	 	  COLOR: WHITE;
		}
		TD.OTMENU
		  {
			BACKGROUND-COLOR: #C0C0C0 ;
			FONT-SIZE: 9PT ;
			BORDER-STYLE: DASHED;
			BORDER-LEFT-COLOR: #FFA500;
			BORDER-RIGHT-COLOR: #FFA500;
			BORDER-TOP-COLOR: #FFFACD;
			BORDER-BOTTOM-COLOR: #FFFACD;
		  }
		TD.OTCLASS{
			FONT-SIZE: 9pt ;
			BORDER-STYLE: SOLID;
			border-left-color: #B2B6D7;
			border-right-color: #B2B6D7;
			border-top-color: #E2E3F0;
			border-bottom-color: #E2E3F0;
			height:30;	
			   }
.menu {text-align:left;position:absolute;width:'1300px'}

    div.tableContainer {
		width: 100%;		/* table width will be 99% of this*/
		height: 400px; 	/* must be greater than tbody*/
		overflow: auto;
		margin: 0 auto;
	}

table {
	width: 100%;		/*100% of container produces horiz. scroll in Mozilla*/
	border: none;
	background-color: #f7f7f7;
	}
	
table>tbody	{  /* child selector syntax which IE6 and older do not support*/
	overflow: auto; 
	height: 250px;
	overflow-x: hidden;
	}
	
 thead tr	{
	position:relative; 
	top: expression(offsetParent.scrollTop); /*IE5+ only*/
	}
</style>
<!-- Heading Static - Scrolling -->
<%
	String locale 			= (String)session.getAttribute("LOCALE");
	String sStyle 			= ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
	HttpSession httpSession = request.getSession(false);
	Properties p 			= (Properties)httpSession.getValue("jdbc");

	String strloggeduser	= (String) httpSession.getValue("login_user");
	String strclientip		= "";
	strclientip				= p.getProperty("client_ip_address");
	String facility_id		= (String)session.getAttribute("facility_id");
	if(sStyle==null) sStyle	= "IeStyle.css";	
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<body class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()" scrolling="no">

<%
	String serving_date="";
	String serving_todate="";
	String onCall="";
	String servingDate="";
	String servingDateTo="";
	String Patient_Class="";
	String AcknowledgeStatus="";
	String patient_id="";
	String PatientStatus="";
	ArrayList<JSONObject> ComplaintList =new ArrayList<JSONObject>();
	int i=0;
	try{
		JSONObject ComplaintListobject=new JSONObject();
		onCall=request.getParameter("oncall");
		servingDate=request.getParameter("servingDate");
		servingDateTo=request.getParameter("servingDateTo");
		Patient_Class=request.getParameter("Patient_Class");
		AcknowledgeStatus=request.getParameter("AcknowledgeStatus");
		patient_id=request.getParameter("patient_id");
		PatientStatus=request.getParameter("PatientStatus");
		if(onCall.equalsIgnoreCase("onLoad"))
		ComplaintList=DSCommonBeanObj.getComplaintList(onCall,"","","","N","","",locale,facility_id);//065827
		else
		ComplaintList=DSCommonBeanObj.getComplaintList(onCall,servingDate,servingDateTo,Patient_Class,AcknowledgeStatus,patient_id,PatientStatus,locale,facility_id);
		session.setAttribute("ComplaintList",ComplaintList);
		Iterator<JSONObject> itr=ComplaintList.iterator();
%>

<form name='QueryResult' id='QueryResult'>

<fmt:setLocale value="<%=locale %>"/>
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<div scrolling="no">	
	<THEAD>
		<tr>
			<th align="center">
				<fmt:message key="eOT.ServingDate.Label" bundle="${ot_labels}" />
			</th>
			<th align="center">
				<fmt:message key="Common.patientId.label" bundle="${common_labels}" />
			</th>
			<th align="center">
				<fmt:message key="Common.PatientName.label" bundle="${common_labels}" />
			</th>
			<th align="center">
				<fmt:message key="Common.patientclass.label" bundle="${common_labels}" />
			</th>
			<th align="center">
				<fmt:message key="Common.Location.label" bundle="${common_labels}" />
			</th>
			<th align="center">
				<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}" />
			</th>
			<th align="center">
				<fmt:message key="eDS.MealStatus.Label" bundle="${ds_labels}" />
			</th>
			<th align="center">
				<fmt:message key="eOT.Complaints.Label" bundle="${ot_labels}" />
			</th>
			<th align="center">
				<fmt:message key="eDS.ComplaintDateAndTime.Label" bundle="${ds_labels}" />
			</th>
			<th align="center">
				<fmt:message key="eDS.AcknowledgedBy.Label" bundle="${ds_labels}" />
			</th>
			<th align="center">
				<fmt:message key="eDS.AcknowledgedDateAndTime.Label" bundle="${ds_labels}" />
			</th>
			<th align="center">
				<fmt:message key="eDS.Acknowledge.Label" bundle="${ds_labels}" />
			</th>
		</tr>
	</THEAD></div>

<%
		while(itr.hasNext())
			{		
				ComplaintListobject=itr.next();				
				String ACKNOWLEDGE_TEMP="";
				if(i==0)
				serving_date=(String) ComplaintListobject.get("serving_date");
				serving_todate=(String) ComplaintListobject.get("serving_date");				
		%>
			<tr>
			<td><%=ComplaintListobject.get("serving_date")%>&nbsp;</td>
			<td><%=ComplaintListobject.get("patient_id")%>&nbsp;</td>
			<td><%=ComplaintListobject.get("patient_name")%>&nbsp;</td>
			<td><%=ComplaintListobject.get("patient_class")%>&nbsp;</td>
			<td><%=ComplaintListobject.get("location")%>&nbsp;</td>
			<td><%=ComplaintListobject.get("meal_type")%>&nbsp;</td>
			<td><%=ComplaintListobject.get("meal_status")%>&nbsp;</td>
			<td><%=ComplaintListobject.get("complaints")%>&nbsp;</td>
			<td><%=ComplaintListobject.get("complaint_date_time")%>&nbsp;</td>
			<td><%=ComplaintListobject.get("acknowledged_by")%>&nbsp;</td>
			<td><%=ComplaintListobject.get("acknowledged_date_time")%>&nbsp;</td>
			<td>
						
<%
			ACKNOWLEDGE_TEMP=(String) ComplaintListobject.get("acknowledge");			
			if(ACKNOWLEDGE_TEMP.equalsIgnoreCase("NO"))
			{
%>

			<select id="acknowledge<%=i%>">
			<option value="<%=ACKNOWLEDGE_TEMP%>" selected>
			<%=ComplaintListobject.get("acknowledge")%>&nbsp;
			</option>
			<option  value="Yes">
			Yes
			</option>
			<select>

<%
			}
			else
			{
%>

			<input type="text" value="Yes" id="acknowledge<%=i%>" readonly disabled  size="4" />
<%
			}
%>
		</td>			
		</tr>
		<input type="hidden" value='<%=ComplaintListobject.get("serving_date")%>'  id="serving_date<%=i%>"/>
		<input type="hidden" value='<%=ComplaintListobject.get("app_no")%>' id="app_no<%=i%>"/>
		<input type="hidden" value='<%=ComplaintListobject.get("encounter_id")%>'  id="encounter_id<%=i%>"/>
		<input type="hidden" value='<%=ComplaintListobject.get("mealtype_code")%>'  id="mealtype_code<%=i%>"/>
		<input type="hidden" value='<%=ComplaintListobject.get("status")%>'  id="status<%=i%>"/>
		<input type="hidden" value='<%=ComplaintListobject.get("acknowledged_by")%>'  id="acknowledged_by<%=i%>"/>
		<input type="hidden" value='<%=ComplaintListobject.get("acknowledged_date_time")%>'  id="acknowledged_date_time<%=i%>"/>

<%
			i++;		
		}
	}catch(Exception e){
	   e.printStackTrace();		
	}
%>
	<input type="hidden" value="<%=i%>"  id="ComplaintListcount"/>
	<input type="hidden" value="<%=serving_date%>"  id="servingDate"/>
	<input type="hidden" value="<%=serving_todate%>"  id="servingDateTo"/>
	<input type="hidden" id="facility_id" name="facility_id" id="facility_id" value=<%=facility_id%>>
	<input type="hidden" id="strloggeduser" name="strloggeduser" id="strloggeduser" value=<%=strloggeduser%>>
	<input type="hidden" id="strclientip" name="strclientip" id="strclientip" value=<%=strclientip%>>	
</table> 
</center>
<br><center>
</center>
</form>
</body>
<script>
	DateChange();
</script>
</html>

