<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	 String facilityId					= (String)session.getValue("facility_id");
%>
<html>
<head> 
<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String function_id	= request.getParameter("function_id");
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css'     href='../../eCommon/html/CommonCalendar.css'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js' ></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script language='javascript' src='../../eAE/js/AESecondaryTriageHistory.js'></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%	 
 try{ 
     Connection con 					= null;
	 PreparedStatement stmt				= null;
	 ResultSet rset					    = null;
	 String location_code				=" ";
	 String location_desc				=" ";
	 String pid_length					="";
	 String sys_date                    ="";
	 String locale						= (String)session.getAttribute("LOCALE");
try
  {
    con	= ConnectionManager.getConnection(request);
	stmt = con.prepareStatement("select patient_id_length,to_char(trunc(sysdate),'dd/mm/yyyy') sys_date from mp_param");
    rset = stmt.executeQuery();
    if(rset != null)
       if(rset.next()){
          pid_length = rset.getString("patient_id_length");
		  sys_date   = rset.getString("sys_date");
	}
    if(pid_length==null || pid_length.equals(""))
       pid_length = "20";
%>  
<body onLoad='callfocus()' onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name='AEQuerySecondaryTriHistoryForm' id='AEQuerySecondaryTriHistoryForm' >   
<table border='0' cellpadding='2' cellspacing='0' width='100%'>
<tr><td colspan='4' height='5'></td></tr>
<tr>
	<td class='LABEL'  width='25%' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td class='field'  width='25%'><input type='text' name='patient_id' id='patient_id' tabindex=1  value="" size='20' maxlength='<%=pid_length%>' onBlur='changeCase(this);' onKeyPress="return(CheckForSpecChars(event))"><input type='button' class='BUTTON' value='?' name='patient_search' id='patient_search' onClick = 'callPatientSearch();'></td>
	<td class='LABEL'  width='25%' ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
	<td class='field'  width='25%'><input type='text' name='encounter_id' id='encounter_id' value='' tabindex=2 size='13' maxlength='12' onKeyPress='return(CheckForSpecChars(event));return(ChkNumberInput(this,event,0))' onBlur='return(ChkNumber(this))'><input type='button' class='BUTTON' value='?' name='encounter_search' id='encounter_search' onClick ='patvisit();'></td>

</tr>
<tr>
	<td  class='LABEL'  width='25%' > <fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/> </td>
	<td class='field'  width='25%'><input type='text' id='patfrom' maxlength='10'  size=9 tabindex=4 name='patfrom'  size='15' onBlur="if(validDateObj(this,'DMY','<%=localeName%>')){doDate(this)}"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('patfrom');" style='cursor:pointer'></img></td>

	<td  class='LABEL' width='25%' > <fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
	<td class='field'  width='25%'><input type='text' id='patto' maxlength='10'  size=9 tabindex=5 name='patto'  size='15' onBlur="if(validDateObj(this,'DMY','<%=localeName%>')){doDate(this)}"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('patto');" style='cursor:pointer'></img></td>
</tr>

<tr>
	<td class='LABEL' width='25%' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
	<td class='field'  width='25%'><select name='ae_secondary_location' id='ae_secondary_location' tabindex=3>
	<option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
	<%	
	stmt = con.prepareStatement("select clinic_code, long_desc clinic_desc from op_clinic_lang_vw where facility_id = '"+facilityId+"' and language_id = '"+locale+"' and clinic_type  = 'C' and level_of_care_ind = 'E' and eff_status = 'E' order by 2");
	rset	= stmt.executeQuery();
		
			while(rset!=null  && rset.next())
			{
			 location_code=rset.getString(1);
			 location_desc=rset.getString(2);
			 out.println("<option value='"+location_code+"'>"+location_desc+"</option>");
			 }
			if(rset!=null)  rset.close();
			if(stmt!=null)  stmt.close();
	%>
  </select> 
  </td> 
	<td>&nbsp;</td><td class='button'  width='25%'><input type='button' class='BUTTON' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' tabindex=6 name='search' onClick='callSearch(patient_id,encounter_id,ae_secondary_datefrom,ae_secondary_dateto,ae_secondary_location,parent.messageFrame);'>
	<input type='button' class='BUTTON' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' tabindex=7 onClick="clear1();"></td>
</tr>  
<tr><td colspan=4 class=label height=5></td></tr>
<input type=hidden name=sys_date value='<%=sys_date%>'>
<input type=hidden name='function_id' id='function_id' value='<%=function_id%>'>

</table>
</form>
<script>
	//parent.frames[0].document.forms[0].reset.disabled=true;
</script>
</body>   
	<% } catch(Exception e){e.printStackTrace();}
   finally
    {
    	if(stmt!=null) stmt.close();
		if(rset!=null) rset.close();
		ConnectionManager.returnConnection(con,request);
    }
%>
<input type=hidden name=facilityId value='<%=facilityId%>'>
</html>
<%}
catch(Exception e1)
{
	e1.printStackTrace();
}
%>

