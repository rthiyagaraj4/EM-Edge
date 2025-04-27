<!DOCTYPE html>
<%
/*
Added by Niveditha For MOHE-CRF-0026.3
*/
%>

<%@page import ="java.util.*,java.sql.*,eXH.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%request.setCharacterEncoding("UTF-8");	%>

<html>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<head>
<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script  language="javascript" src="../../eXH/js/InsAuthStatus.js"></script>


<script language="javascript">
	function checkSTDate(objSt,objIS,objRE,objSYS,objEn,objEX){

			var locale= document.forms[0].locale.value;
			
			if(objSt==null||objSt.value=='') {return;}
			
			var obj1=changeDate1(objSt.value);
			var obj2=changeDate1(objIS.value);
			var obj3=changeDate1(objRE.value);
			var obj4=changeDate1(objSYS.value);
			var obj6=changeDate1(objEX.value);	

			if(objEn != null||objEn.value !='')
			{
				var obj5=changeDate1(objEn.value);
			if(obj1 > obj5)
			{
				alert(getBTMessage("BT0527","BT"));
				objSt.value='';
				return;
			}
			}

			if(!(isBeforeNow(objSt.value,"DMY",locale) ))
			{
				alert(getBTMessage("BT0414","BT"));
				objSt.value='';
				return;
			}

			if(obj1 < obj2 )
			{ 	
				alert(getBTMessage("BT0114","BT"));
				objSt.value='';
				return;
			}

			if(obj1 > obj3)       
			{ 
				alert(getBTMessage("BT0115","BT"));
				objSt.value='';
				return;
			}

			if(obj1 > obj6)      
			{
				alert(getBTMessage("BT0551","BT"));
				objSt.value='';
				return;
			}
	}

	function checkEnDate(objEt,objTR,objRE,objSYS,objEX){
		
		var locale		= document.forms[0].locale.value;

		if(objEt==null||objEt.value==''){return ;}

		var obj1=changeDate1(objEt.value);
		var obj2=changeDate1(objTR.value);
		var obj3=changeDate1(objRE.value);
		var obj4=changeDate1(objSYS.value);
		var obj5=changeDate1(objEX.value);

			if(!(isBeforeNow(objEt.value,"DMY",locale) ))
			{
				alert(getBTMessage("BT0117","BT"));
				objEt.value='';
				return;
			}

			if(obj1 < obj2)    
			{ 
				alert(getBTMessage("BT0118","BT"));
				objEt.value='';
				return;
			}

			if(obj1 > obj3)     
			{  
				alert(getBTMessage("BT0119","LT"));
				objEt.value='';
				return;
			}	
			if(obj1 > obj5)       
			{ 
				alert(getBTMessage("BT0550","BT"));
				objEt.value='';
				return;
			}
	}


	function changeDate1(objEt){
		
		var objStr=new Array();
		objStr=objEt.split("/");
		var datVal='';

			if(objStr != null && objStr.length>0)
			{
				datVal+=objStr[1]+"/";
				datVal+=objStr[0]+"/";
				datVal+=objStr[2];
			}
			else	 
			{
				datVal=objEt;
			}
			var dat=new Date(datVal);
			return dat;
	 }

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>


 <body onLoad="callStorageLocation()" onKeyDown="lockKey()">
    <form name='InsuranceAuthorizationStatusCriteriaFrame' id='InsuranceAuthorizationStatusCriteriaFrame' method='post'   action='' target='messageFrame'> 

   	 	 <%
		String login_user;
		String strFid = "";
		Connection con = null;
		Properties p = null;
		HttpSession httpSession = request.getSession(false);
		p = (Properties)httpSession.getValue("jdbc"); 
		strFid = ""+httpSession.getAttribute("facility_id");
		login_user = p.getProperty("login_user");
		String locale = (String)session.getAttribute("LOCALE");
		locale = (locale == null || locale.equals(""))?"en":locale;
		java.util.Locale loc = new java.util.Locale(locale);
		java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
	
		Statement stmt = null; 
		ResultSet rs   = null;
		
		String settingHeader = null;
		String strFacilityId;
	    String strPatientId;

	    String strSysDate;
		String facilityId = (String)session.getValue("facility_id");

		String bean_id					= "InsuranceAuthStatusBean" ;
		String bean_name				= "eXH.InsuranceAuthStatusBean";
	
		strFacilityId = request.getParameter("OPERATING_FACILITY_ID");
		strPatientId = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	
		strSysDate = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);	
	
try
{
	con = ConnectionManager.getConnection(request);

	InsuranceAuthStatusBean bean = new InsuranceAuthStatusBean();
	String PatientName=bean.getPatientName(strPatientId);	
	String EncounterId=bean.getEncounterId(strPatientId);	
%>
		
<div style="overflow:auto;width:100%;height:auto;">

<table width="100%" cellspacing='0' cellpadding='0'>
	<tr class="COMMONTOOLBARFUNCTION">
		<td align="left" class="COMMONTOOLBARFUNCTION" id="cmnToolBarFuncName">
			Search Criteria
		</td>
	</tr>
</table>	

<table width='100%' cellpadding='0' cellspacing='0' border='0'>
		<tr>	
			<td class=label nowrap align="left"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class='fields' align="left">
				<input type="text" name="Patient_Id" id="Patient_Id" size="30" maxlength="30" value='<%=strPatientId%>' onKeyPress='return CheckForSpecChars(event)' onfocusout="patname()">
				<input type="button" name="patient_button" id="patient_button" value="?" class="button" onClick="callPatientSearch(document.InsuranceAuthorizationStatusCriteriaFrame.Patient_Id)" />	
			</td>			
			<td class=label nowrap align="left"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
			<td class='fields' align="left">
				<input type="text" name="patient_name" id="patient_name" value="<%=PatientName%>" size="30" maxlength="30" />
			</td>			
			<td class=label nowrap align="left"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
			<td class='fields' align="left"><select name="" style="width:150;" name="encounter_id" id="encounter_id" id="encounter_id" >
			<option value="">---------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
			<% 
				String encounter_id="";
				try															    
				{  
					String queryApplication = "SELECT distinct encounter_id FROM or_order where patient_id = '"+strPatientId+"' ";
					stmt = con.createStatement();
					rs	 =	stmt.executeQuery(queryApplication);			
					while(rs.next())
					{
						if(encounter_id.equals(rs.getString(1).toString().trim()))
							{%>				 
								<option value='<%=rs.getString(1).toString().trim()%>' selected><%=rs.getString(1)%></option> 
								<%
							}
						else
							{
							%><option value='<%=rs.getString(1).toString().trim()%>' ><%=rs.getString(1)%></option> <%
							}
					}
				}
				catch(Exception e1)
				{System.out.println("(InsuranceAuthorizationStatusCriteria.jsp:Exception-1) "+e1.toString());}
			%>
			</SELECT>
			</td>
		</tr>
		
		<tr>
			<td class=label nowrap><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>
			<td class='fields'><select name="EpisodeType" id="EpisodeType">
				<option value="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
				<option value="EM"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
				</select>
			</td>
			
						
			<td class=label nowrap><fmt:message key="eXH.EncounterDateFrom.label" bundle="${xh_labels}"/></td>
		    <td class='fields'>
				<input type='text' name='TRANSFUSE_ST_DATE_TIME' id='TRANSFUSE_ST_DATE_TIME' maxlength='30' size='15' value= "<%=strSysDate%>" RECORD_TYPE='S' Onblur='checkSTDate(this,document.forms[0].ISSUED_DATE,document.forms[0].RESERVED_DATE,document.forms[0].SYDATE,document.forms[0].TRANSFUSE_EN_DATE_TIME,document.forms[0].EXPIRY_DATE);' >      
				<input type='image' src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('TRANSFUSE_ST_DATE_TIME','dd/mm/y');">
				<img align="center" src="../../eCommon/images/mandatory.gif"></img>
			</td>
					
			<td class=label  nowrap><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			<td class='fields'>
				<input type='text' name='TRANSFUSE_EN_DATE_TIME' id='TRANSFUSE_EN_DATE_TIME' maxlength='30' size='15' value= "<%=strSysDate%>" RECORD_TYPE='S' Onblur='checkEnDate(this,document.forms[0].TRANSFUSE_ST_DATE_TIME,document.forms[0].RESERVED_DATE,document.forms[0].SYDATE,document.forms[0].EXPIRY_DATE);' >
				<input type='image' src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('TRANSFUSE_EN_DATE_TIME','dd/mm/y');">
				<img align="center" src="../../eCommon/images/mandatory.gif"></img>
			</td>
		</tr>	
		
		<tr>
			<td class=label  nowrap><fmt:message key="eXH.DispenseLocation.label" bundle="${xh_labels}"/></td>
			<td class='fields'><select name="" style="width:200;" name="disp_location" id="disp_location" id="disp_location" >
			<option value="">---------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
			<% 
				String disp_location="";
				try															    
				{  
					String queryApplication = "SELECT DISP_LOCN_CODE, LONG_DESC FROM PH_DISP_LOCN order by DISP_LOCN_CODE";
					stmt = con.createStatement();
					rs	 =	stmt.executeQuery(queryApplication);			
					while(rs.next())
					{
						if(disp_location.equals(rs.getString(1).toString().trim()))
							{%>				 
								<option value='<%=rs.getString(1).toString().trim()%>' selected><%=rs.getString(2)%></option> 
								<%
							}
						else
							{
							%><option value='<%=rs.getString(1).toString().trim()%>' ><%=rs.getString(2)%></option> <%
							}
					}
				}
				catch(Exception e1)
				{System.out.println("(InsuranceAuthorizationStatusCriteria.jsp:Exception-1) "+e1.toString());}
			%>
			</SELECT>
			</td>

			<td class=label nowrap><fmt:message key="eXH.AuthorizationStatus.label" bundle="${xh_labels}"/></td>
			<td class='fields'><select style="width:200;" class='select' name='auth_status' id='auth_status' id='auth_status'>
		<option value=''>---------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
	<% 
		try															    
		{  
		String auth_status= "";
		
			String queryApplication = "SELECT list_elmt_value, list_elmt_label FROM sm_list_item WHERE module_id='XH' AND list_ref='XH_AUTH_STATUS'";
			stmt = con.createStatement();
			rs	 =	stmt.executeQuery(queryApplication);			
			
			while(rs.next())
			{
				if(auth_status.equals(rs.getString(1).toString().trim()) && auth_status.equalsIgnoreCase(rs.getString(1).toString().trim()))
				{
					settingHeader = rs.getString(2);
	%>				 
				<option value='<%=rs.getString(1).toString().trim()%>' selected><%=rs.getString(2)%></option> 
	<%
				}
				else
				{
	%>
				<option value='<%=rs.getString(1).toString().trim()%>' ><%=rs.getString(2)%></option> 
	<%
				}
			}
		}
		catch(Exception e1)
		{
			System.out.println("(CommProtocolIdQueryCriteria.jsp:Exception-1) "+e1.toString());
		}
	%>
	</select>
			</td>

			<td align="right" class="label">
				<input type='button' name='Search' id='Search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class=button onClick="SearchChart('jsp')"/>
			</td>
		</tr> 
		<tr>
			<td class="label"></td>			
			<td class="label"></td>
			<td class="label"></td>	
			<td class="fields" colspan="3">
				<input type='button' name='Search' id='Search' width="30" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.AuthorizationCheck.label","xh_labels")%>' class=button onClick="insertRecords()"/>
				
				<!--<input type='button' name='Search' id='Search' width="30" value='' class=button onClick="insertRecords('insert')"/>-->
				
				&nbsp;&nbsp;
				<input type='button' name='Search' id='Search' width="30" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.AuthorizationStatus.label","xh_labels")%>' class=button onClick="statusRecords()"/>
			</td>
		</tr>

</table>
</div>  
<%
}
catch(Exception ee)
{
	ee.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}%>

<input type='hidden' name='locale' id='locale' value ='<%=locale%>'/>

</form>
<jsp:include page="../../eXH/jsp/InsuranceAuthorizationStatusResult.jsp"></jsp:include>

</body>
</html>

