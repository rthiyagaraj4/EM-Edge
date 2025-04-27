<!DOCTYPE html>
<%--
/**	
  *	Purpose				:	Displays the Search Criteria for AE Unknown Patients.
  * Added by			:	Sen 
  * Date				:   30/04/2004
  */
--%>
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	 String	facilityId 					= (String) session.getValue( "facility_id" ) ;
%>
<html>
<head>
<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

  <link rel='stylesheet' type='text/css'     href='../../eCommon/html/CommonCalendar.css'></link>
  <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function Valid_DT(event){
	var strCheck = '0123456789:/ ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
} 
function validateTime(obj){

	if(obj.value != '')	{
		
		if(!doDateTimeChk(obj)){
				
				var msg = self.getMessage("INVALID_DATE_TIME",'SM');
				alert(msg);				
				obj.focus();
				obj.value='';
				return
		}
	}
}

function checkDate(obj){	
		if(obj.value!="") {
			 if((!isBeforeNow(obj.value,'DMY',localeName))) 	{
				alert(getMessage("START_DATE_GREATER_SYSDATE","common"))
				obj.select();
				return false;
			 }
		}
}

</script>
</head>
 <%	
 request.setCharacterEncoding("UTF-8");
 try{
     Connection con 					= null;
	 PreparedStatement stmt				= null;
	 ResultSet rset					    = null;
	 String location_code				="";
	 String location_desc				="";
	 String curr_date					="";
	 String locale						= (String)session.getAttribute("LOCALE");


try
  {
    con	= ConnectionManager.getConnection(request);
	 stmt	= con.prepareStatement("select to_char(sysdate,'dd/mm/yyyy') from dual");
	 rset=stmt.executeQuery();
	 rset.next();
	 curr_date=rset.getString(1);

	if(rset!=null)  rset.close();
	if(stmt!=null)  stmt.close();
	 
	 %>
<body  onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<center>
<form name='AEUnknownPatientsForm' id='AEUnknownPatientsForm'>
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
 <tr><td colspan='4'>&nbsp;</td></tr> 
<tr>
	<td class='LABEL'  width='25%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
	<td class='field' width='25%'><select name='ae_unknown_location' id='ae_unknown_location'><option  value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option> 

<%	
	
	String sql_locn="select clinic_code, long_desc clinic_desc from op_clinic_lang_vw where facility_id = ? and care_locn_type_ind = 'C' and level_of_care_ind = 'E' and eff_status = 'E' and language_id = '"+locale+"' order by 2";

    stmt	= con.prepareStatement(sql_locn);
    stmt.setString(1,facilityId);

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
	<td  class='LABEL'  width='25%'> <fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
	<td  class='field'  width='25%'><select name="p_gender" id="p_gender"> <option value="" >----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option> 
			<option value="M"><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
			<option value="F"><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
			<option value="U"><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
			</select>
    </td>
</tr>
<tr>
		<td class='LABEL'  width='25%'>  <fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/> </td>
		<td class='field'  width='25%'><input type='text' id='patfrom'   name='ae_unknown_datefrom' id='ae_unknown_datefrom' size='15' maxlength=16  onblur="if(validDateObj(this,'DMY','<%=localeName%>')){checkDate(this);}"  value=''><input  type="image" id='image2' src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].ae_unknown_datefrom.select();return showCalendar('patfrom')"></img>&nbsp;<img  src='../../eCommon/images/mandatory.gif'></td>
		<td  class='LABEL'  width='25%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td class='field'  width='25%'><input type='text' id='patto' maxlength=16 size = '14' name='ae_unknown_dateto' id='ae_unknown_dateto' size='15'  onblur="if(validDateObj(this,'DMY','<%=localeName%>')){checkDate(this);}" value='' ><input  type="image" id='image2' src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].ae_unknown_dateto.select();return showCalendar('patto')"></img>&nbsp;<img  src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td class='button' >
	<input type='button' class='BUTTON' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' name='search' onClick='parent.callSearch(ae_unknown_datefrom,ae_unknown_dateto,ae_unknown_location,parent.messageFrame)'>
	<input type='button' class='BUTTON' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick="parent.clear()"></td>
</tr>
<tr><td colspan='4' class='label' height='5'></td></tr>
</table>
	<input type='hidden' name='ae_unknown_location_desc' id='ae_unknown_location_desc'>
</form>
</body>

	<% } catch(Exception e){e.printStackTrace();}
   finally
    {
    	if(con!=null)
		ConnectionManager.returnConnection(con,request);
    }
%>
<input type=hidden name='facilityId' id='facilityId' value='<%=facilityId%>'>
	
</html>
<%}
catch(Exception e1)
{
	e1.printStackTrace();
}
%>

