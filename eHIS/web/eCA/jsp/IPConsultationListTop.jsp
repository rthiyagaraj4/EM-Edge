<!DOCTYPE html>
<!--
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             100         ?           created
18/11/2011    IN29413    Dinesh T     ARTEMIS - Added the new method
29/12/2011    IN30250    Dinesh T     ARTEMIS - Changed for the ipconsultation function in patient chart										  also
-----------------------------------------------------------------------------------------------
-->
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />

<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<!-- <script Language="JavaScript" src="../../eCommon/js/DateValidation.js"></script> -->
<script Language="JavaScript" src="../../eCA/js/DateValidation.js"></script>
<script Language="JavaScript" src='../../eCA/js/IPConsultationList.js'></script>
<script Language="JavaScript" src='../../eCommon/js/dchk.js'> </script>
<script language='javascript' src='../../eCA/js/DateCheck.js' ></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script> 
function validateTime(obj) 
{
	if(obj.value != '')
	{
		if(!chkTime(obj.value))
		{
			alert(getMessage("INVALID_TIME_FMT","CA"));
			obj.select();
			obj.focus();
		}
	}
}
</script>
</head>
<%
String queryString = request.getQueryString();//IN30250
java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
String locale			= (String) p.getProperty("LOCALE");
//String userId=((String) session.getValue("login_user")).trim();
String userId=((String) session.getValue("ca_practitioner_id")).trim();
String practitioner_name=((String) session.getValue("practitioner_name")).trim();
String facilityid=((String) session.getValue("facility_id")).trim();

	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;

String cons_date_time ="";
String cons_date ="";
String cons_time ="";
String cons_back_date ="";
cons_date_time		=	com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);

String cons_date_arr[] = cons_date_time.split(" ");

cons_date = cons_date_arr[0];
cons_time = cons_date_arr[1];


	try
	{

		con =  ConnectionManager.getConnection(request);

		String cons_bd_qry="select CONS_BACK_DATE from CA_CONS_PARAM" ;

		stmt = con.prepareStatement(cons_bd_qry);
		
		rs = stmt.executeQuery();

		while(rs.next())
		{
			cons_back_date = rs.getString("CONS_BACK_DATE")==null?"":rs.getString("CONS_BACK_DATE");	
		}

		if(rs!=null) rs.close();
		if(stmt!=null)stmt.close();	
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception caught in IPConsultationListTop.jsp " + e);//COMMON-ICN-0181

	}
	finally 
	{
			
		ConnectionManager.returnConnection(con,request);
	}


%>
<body  class='CONTENT'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='IPConsultationListTopForm' id='IPConsultationListTopForm'>
<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>

 <tr>
 <td class='label' width='25%'><fmt:message key="eCA.ConsultationListBy.label" bundle="${ca_labels}"/></td>
 <td class='fields' width='25%'><input type="radio" name="pract_rad"  id='pract_self' class="label" value="P" checked onclick='practRadClick(this);' >&nbsp;<fmt:message key="Common.self.label" bundle="${common_labels}"/><input type="radio" name="pract_rad"  id='pract_behalf' class="label" value="O" onclick='practRadClick(this);'>&nbsp;<fmt:message key="eCA.OnBehalfOf.label" bundle="${ca_labels}"/> <input type="radio" name="pract_rad"  id='Speciality' class="label" value="S"  onclick='practRadClick(this);' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp; </td>
 <td class='label' width='25%' id='Practioner_lab' ><fmt:message key="eCA.ConsultingPractitioner.label" bundle="${ca_labels}"/></td><!--IN29413-->
 <td class='fields' width='25%'>
 <input type='text' name='practitioner' id='practitioner' size=30 maxlength='30' value='<%=practitioner_name%>' readOnly onchange ="getPract1(this);" ><input type='button' class='button' value='?' id='src_butn'  name='search_pract' id='search_pract' onClick="getPract(this);" disabled><img src='../../eCommon/images/mandatory.gif'></img></td>
 </tr>
 </tr>
 <td class ='label' width='25%'><fmt:message key="eCA.ConsultDate.label" bundle="${ca_labels}"/> </td>
 <td class ='fields' width='25%'><input type='text' size=10 maxlength='10' name='cons_date' id='cons_date' value='<%=cons_date%>'onblur='CheckDate(this);checkValidConsDate(this);'><input type='image' id='cons_cal' src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('cons_date');"><img src='../../eCommon/images/mandatory.gif'></img>&nbsp;<input type='text' size='5' maxlength='5' name='cons_time' id='cons_time' value='<%=cons_time%>'onblur='validateTime(this)'><img src='../../eCommon/images/mandatory.gif'></img> </td>
 <td class="button" colspan='2' align='right'><INPUT TYPE="button" name='reset_btn' id='reset_btn' value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' class='button' onClick='resetPage();'></td>
 </tr>
 </table>

	<input type="hidden" name="userId" id="userId" value="<%=userId%>">
	<input type="hidden" name="facilityid" id="facilityid" value="<%=facilityid%>">
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	<input type="hidden" name="practitionerId" id="practitionerId" value="<%=userId%>">
	<input type="hidden" name="practitioner_name" id="practitioner_name" value="<%=practitioner_name%>">
	<input type="hidden" name="create_type" id="create_type" value="">
	<input type="hidden" name="cons_back_date" id="cons_back_date" value="<%=cons_back_date%>">
	<input type="hidden" name="current_date" id="current_date" value="<%=cons_date%>">
 </form>
<!--IN30250,starts-->
<script>
parent.IPConsultationListTabsFrame.location.href="IPConsultationListTabs.jsp?"+"<%=queryString%>";
parent.IPConsultationListCriteriaFrame.location.href="IPConsultationListCriteria.jsp?"+"<%=queryString%>";
</script>
<!--IN30250,ends-->
</body>
</html>

