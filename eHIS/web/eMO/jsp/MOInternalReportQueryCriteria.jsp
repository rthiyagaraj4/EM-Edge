<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
String	facility_id =  (String) session.getValue( "facility_id" ) ;
String patient_id_length="";
String currdate="";
int embalmCount = 0;
Connection con=null;
PreparedStatement pstmt=null;
ResultSet vrs=null;
try
{
con = ConnectionManager.getConnection(request);

pstmt   = con.prepareStatement("select PATIENT_ID_LENGTH,(select count(*) from mo_embalm_service where facility_id = '"+facility_id+"') embalmCount,to_char(sysdate,'dd/mm/yyyy') currdate from MP_PARAM");

vrs = pstmt.executeQuery();
if(vrs!=null && vrs.next())
 	{   
   patient_id_length = vrs.getString(1)==null?"":vrs.getString(1);
   currdate = vrs.getString("currdate")==null?"":vrs.getString("currdate");
   embalmCount = vrs.getInt("embalmCount");
  if(currdate!=null && !currdate.equals(""))
	  currdate = DateUtils.convertDate(currdate,"DMY","en",localeName);
} 
	 
	if(vrs!=null) vrs.close();
	if(pstmt!=null) pstmt.close();


}catch(Exception e)
{
	e.printStackTrace();
}
finally{
 	ConnectionManager.returnConnection(con,request);
 }

%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<Script src="../../eMO/js/MOInternalReport.js" language="JavaScript"></Script>
<Script src="../../eMO/js/MOEmbalmRegistration.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

var specialtyForClinc= new Array();
var openToAllPractYN=new Array();
	specialtyForClinc[0]	=	'';
	openToAllPractYN[0]='';
</script>
</head>


<body onKeyDown = 'lockKey()'>

<form name="SearchVisit" id="SearchVisit" >
<br>
<table  border="0" width="100%" cellspacing='0' cellpadding='0' align="center">
<%if(embalmCount > 0){%>
<tr>
<td class='label' width='25%' ><fmt:message key="eMO.PrintEmbalmForm.label" bundle="${mo_labels}"/></td>
 <td class='fields'  width='15%'><INPUT TYPE="checkbox" name="print_embalm" id="print_embalm" onClick='diplayEmbalm(this)' value=""></td>
 <td colspan='4' class='label'></td>
			   
</tr>
<%}else{%>
<input type=hidden name='print_embalm' id='print_embalm' value=''>
<%}%>
<tr>
<td  class="label" width='8%'><fmt:message key="Common.registrationno.label" bundle="${common_labels}"/></td>
<td  class='fields' width='12%'><INPUT TYPE="text" name='registration_no' id='registration_no'><input type="button" value="?" name='RegBut' id='RegBut' class="button"  onClick="searchCode(this,registration_no)"></td>
<td  class='label' width='9%' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
<td  class='fields' width='20%'><input type="text"   name="patient_id" id="patient_id" align="left" size='16'  maxlength='<%=patient_id_length%>' onBlur="ChangeUpperCase(this);" onKeyPress="return(CheckForSpecChars(event))"><input type="button" value="?" class="button" name='pat_search' id='pat_search' onClick="searchCode(this,patient_id)">
</td>
<td  class='label' width='18%'><fmt:message key="eMO.BurialPermitNumber.label" bundle="${mo_labels}"/></td>
<td  class='fields' width='18%'><input type="text"  name="burial_permit_no" id="burial_permit_no" align="left" size='16' maxlength='16' ><input type="button" value="?" class="button" name='burial_search' id='burial_search' onClick="searchCode(this,burial_permit_no)">
</td>
</tr>
<tr>
<td  class="label" ><fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/></td>
<td  class='fields' ><INPUT TYPE="text"  value='<%=currdate%>'size=10 maxlength=10 name="startdate1" id ="startdate1" onblur="return validDateObj(this,'DMY',localeName);"><input type='image' src='../../eCommon/images/CommonCalendar.gif' id='decdate1'  name='OTDate1' id='OTDate1' onClick="document.forms[0].startdate1.select();return showCalendar('startdate1',null,null);"  tabindex=-1></td>
<td  class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
<td  class='fields' ><INPUT TYPE="text" onblur="return validDateObj(this,'DMY',localeName);" size=10 maxlength=10  name="startdate2" id="startdate2" value='<%=currdate%>'><input type='image' src='../../eCommon/images/CommonCalendar.gif' id='decdate2'  name='OTDate1' id='OTDate1' onClick="document.forms[0].startdate2.select();return showCalendar('startdate2',null,null);"  tabindex=-1></td>
 <td class="label"  ><fmt:message key="eMO.BodyPartType.label" bundle="${mo_labels}"/></td>
  <td class='fields' >
 <select name='obt_frm' id='obt_frm' >
 <option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
 <option value='A'><fmt:message key="eMO.AmputatedBodyPart.label" bundle="${mo_labels}"/></option>
 <option value='D'><fmt:message key="eMO.DeadFetus.label" bundle="${mo_labels}"/></option>
 <option value='U'><fmt:message key="eMO.UnidentifiedBodyPart.label" bundle="${mo_labels}"/></option>
 <option value='C'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
 </select>
 </td>	
</tr>
<tr>
<td colspan='5' class='label'></td>
<td class='button' ><input type="button" name="search" id="search" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick='showResultPage();' class='button'><input type="button" name="Clear" id="Clear" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'  class='button' onClick='ClearFrame()'></td>
</tr>
<input type=hidden name='facility_id' id='facility_id' value='<%=facility_id%>'>
</table>
</form>
</body>
</html>

