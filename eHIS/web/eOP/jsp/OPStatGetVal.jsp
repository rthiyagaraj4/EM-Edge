<!DOCTYPE html>
<html>

<%@ page import ="webbeans.eCommon.ConnectionManager,java.sql.*,java.util.*,java.net.*,java.text.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
       request.setCharacterEncoding("UTF-8");
%>
<%
String Facility_Id  = (String) session.getValue("facility_id");
String locale=(String)session.getAttribute("LOCALE");
String sql1 = "";
//String sql2 = "";

Connection con = null;
PreparedStatement pstmt1=null;
ResultSet rset1=null;

try{
	con = ConnectionManager.getConnection(request);
    
	sql1 ="SELECT   service_code, short_desc service_short_desc FROM am_service_lang_vw WHERE language_id = '"+locale+"' AND  eff_status='E' order by 2";

	
	//sql2 = "select clinic_code,long_desc from op_clinic_lang_vw where facility_id = '"+Facility_Id+"' and level_of_care_ind='A' and eff_status='E' and care_locn_type_ind='C'  and language_id='"+locale+"' order by 2";

	
%>

<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<script Language="JavaScript" src='../../eOP/js/QueryOPStatistics.js'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body onload='FocusFirstElement()' onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<form name='qryget_form' id='qryget_form'>
    <BR>
    <table border='0' cellpadding='3' cellspacing='0' width='95%' align='center'>    
	<tr>
        <td class='LABEL' width='25%'><fmt:message key="Common.month.label" bundle="${common_labels}"/>/<fmt:message key="Common.year.label" bundle="${common_labels}"/></td>
        <td class='fields' width='25%'><input type='text' id='stat' name='txtmonyear' id='txtmonyear' onBlur='validDateObj(this,"MY",localeName);' size='7' maxlength='7' ><img  src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('stat', 'mm/y', null);"  style="cursor='hand'"></img><img  src='../../eCommon/images/mandatory.gif' align='center'></td>

		<td class='LABEL' width='25%'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
        <td class='fields' width='25%'><select name='opservice' id='opservice' onchange='enableSerChg();'> 
		<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
			bundle="${common_labels}"/> --------&nbsp;</option>		
        <% 
        String servcode="";
        String servsdesc="";
		
		pstmt1 = con.prepareStatement(sql1);  
		rset1 = pstmt1.executeQuery();
        
		if(rset1 != null)
		{
			while(rset1.next())
			{
            servcode = rset1.getString("service_code");
            servsdesc=rset1.getString("service_short_desc");
            out.println("<option value='"+servcode+"'>"+servsdesc);
			}
        }

		if(rset1 != null) rset1.close();
		if(pstmt1 != null) pstmt1.close();

		%>

        </select></td>
		</tr>
		<tr>
        <td class='LABEL'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
        <td class='fields'>
		<INPUT TYPE="text" name="opclinic1" id="opclinic1"  onBlur="onBlurgetLoc('<%=Facility_Id%>','<%=locale%>',document.forms[0].opservice.value,document.forms[0].opclinic1);"><input type="button" name="qloc_butt" id="qloc_butt" value="?" class="button" onClick="getLocn('<%=Facility_Id%>','<%=locale%>',document.forms[0].opservice.value,document.forms[0].opclinic1);" >
		<input type="hidden" name="opclinic" id="opclinic">
		<input type='hidden' name='serchg' id='serchg' value='N'>

		<!--
		<select name='opclinic' id='opclinic'> 
		<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
			bundle="${common_labels}"/> --------&nbsp;</option>
		-->
        <%
		/*
		pstmt1 = con.prepareStatement(sql2);  
		rset1 = pstmt1.executeQuery();
        
		String clncode="";
        String clnsdesc="";
		if(rset1 != null)
		{
			while(rset1.next())
			{
				clncode = rset1.getString("clinic_code");
				clnsdesc=rset1.getString("long_desc");
				out.println("<option value='"+clncode+"'>"+clnsdesc);
			}

		}
        
		 if(rset1 != null) rset1.close();
		 if(pstmt1 != null) pstmt1.close();*/
        %>
       <!-- </select></td> -->
	   </td>		
		<td class='LABEL'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
	<td class='fields' ><input type="text" name ="speciality_desc" maxlength="15" size="15" onBlur="getValues(spec_button,this,speciality_code)"><input type='button' class='button'  name='spec_button' id='spec_button' value='?' onclick="getValues(this,speciality_desc,speciality_code)"><input type='hidden' name='speciality_code' id='speciality_code' value=''></td>
    </tr>	

	<tr>
		 <td colspan='3'>&nbsp;</td>	
         <td class='fields'><input type="button" class='Button' name="speciality_button" id="speciality_button" title='Speciality' value='<fmt:message key="Common.by.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>' onclick="qrySpeciality()"><input type="button" class='Button' name="service_button" id="service_button" title='Services' value='<fmt:message key="eOP.ByServices.label" bundle="${op_labels}"/>' onclick="qryServices()"><input type="button" class='Button' name="clinic_button" id="clinic_button" title='Clinics' value='<fmt:message key="eOP.ByLocations.label" bundle="${op_labels}"/>' onclick="qryClinics()"><input type="button" class='Button' name="clear_button" id="clear_button" title='Clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>'  onclick="clearqry()"></td>
   </tr>
   </table>

   <input type='hidden' name='locale' id='locale' value='<%=locale%>'>
   <input type='hidden' name='facility_id' id='facility_id' value='<%=Facility_Id%>'>

</form>
</body>
</html>
<%

}
catch(Exception e){out.println("Excep:"+e);
}
finally
{
  if(con != null) ConnectionManager.returnConnection(con,request); 
}
%>

