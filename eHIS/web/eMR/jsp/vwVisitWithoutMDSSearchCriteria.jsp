<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,com.ehis.util.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
	<script language="javascript" src="../../eCommon/js/common.js" ></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
	<script language='javascript' src='../../eCommon/js/dchk.js' ></script>
	<script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
	<script language='javascript' src="../../eMR/js/VisitsWithoutMDS.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	request.setCharacterEncoding("UTF-8");
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String locale           = (String) session.getAttribute("LOCALE");
	Connection con = null;
	Statement stmt=null;
	ResultSet rset=null;
	try{
	con =  ConnectionManager.getConnection(request);
	 stmt	= con.createStatement();
%>			
<body onLoad="//FocusFirstElement()"  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
  <form name = 'VisitMDSQuery' action="" target="messageFrame">
    <table border='0' cellpadding='2' cellspacing='0' width="100%">
	
	 <tr>

	 	<td   class='label' width="22%"><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></td>
		<td class="fields" width="37%"><input type = 'text' name = 'frm_encounter_date' id = 'frm_encounter' size = '10' maxlength = '10' onblur='validDateObj(this,"DMY","<%=locale%>");'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('frm_encounter');"/> - <input type = 'text' name = 'to_encounter_date' id = 'to_encounter' size = '10' maxlength = '10' onblur='ComparePeriodFromToTime(frm_encounter_date,this);validDateObj(this,"DMY","<%=locale%>")'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_encounter');"/><img src="../../eCommon/images/mandatory.gif"></img></td>

		<td class='label'  width="20%"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
		<td class="fields" width="22%">
				<select name='enc_type' id='enc_type' onChange='selLocation(this);'>
				<option value=''>-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --</option>
				<%	rset = stmt.executeQuery(" select PATIENT_CLASS, short_desc from am_patient_class where PATIENT_CLASS <> 'XT' order by 1")  ;
				if(rset != null)
				{									
				while (rset.next())
				{	%>
					<option value='<%=rset.getString("PATIENT_CLASS")%>'><%=rset.getString("short_desc")%></option>
				<%	
				}
				}
				if(rset != null) rset.close();
				%>
				</select>
				
		</td>
		<td  class="label"></td>
		<td  class='fields'></td>
		
	
		
	 </tr>
	 <tr>
	 <td  class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td class="fields">
					<select name="location_sel" id="location_sel"><option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
					
					</select>
			</td>

			<td  class="label"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
			<td  class='fields'><input type=text  name='encounter_id' id='encounter_id' size="12" maxlength="12" onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNumVal(this);" align="center"></td>
			<td  class="label"></td>
			<td  class='fields'></td>
			

			
	</tr>

	<tr>
	<td  class="label"><fmt:message key="eMR.MDS.label" bundle="${mr_labels}"/></td>
			<td  class='fields'>
				<select name="min_dataset_type" id="min_dataset_type"><option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>

				<%	rset = stmt.executeQuery("select mds_code,short_desc from mr_mds where eff_status = 'E' order by short_desc")  ;
				if(rset != null)
				{									
				while (rset.next())
				{	%>
					<option value='<%=rset.getString("MDS_CODE")%>'><%=rset.getString("SHORT_DESC")%></option>
				<%	
				}
				}
				if(rset != null) rset.close();
				if(stmt != null) stmt.close();
				%>

				</select>
			
			</td>
			<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td width="25%" class="fields" ><input type=text name='PatientId' id='PatientId' size=""  onBlur="makeValidString(this);ChangeUpperCase(this);" onKeypress='return CheckForSpecChars(event);' align="center"><input type='button' name='patient_id' id='patient_id' value='?' class='button' onclick='callSearchScreen()'>
			</td>

			<td>&nbsp;</td>
			<td>&nbsp;</td>
			
		</tr>
		<tr>
			<td class='label' >&nbsp;</td>
			<td class='fields' >&nbsp;</td>

			<td>&nbsp;&nbsp;&nbsp;</td>
			<td class="button"><input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage()'><input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick='clearScreen()'></td>

	</tr>

	<input type='hidden' name='facility_id' id='facility_id' value = "<%=p_facility_id%>">


    <table>
  </form>
</body>
</html>
<%}
	catch(Exception ex){
		ex.printStackTrace();
	}
	finally{

		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	
	%>


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

