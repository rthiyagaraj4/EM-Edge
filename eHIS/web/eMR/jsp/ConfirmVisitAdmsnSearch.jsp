<!DOCTYPE html>
<!--Created by Ashwini on 05-May-2017 for ML-MMOH-CRF-0698-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,com.ehis.util.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>

  <link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <Script language='javaScript' src="../../eCommon/js/CommonCalendar.js"></Script>  
  <script language='javascript' src='../../eCommon/js/common.js' ></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>  
  <script language='javascript' src='../../eCommon/js/dchk.js' ></script>
  <script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>  
  <script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
  <script language='javascript' src="../js/ConfirmVisitAdmsn.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<script>
function clearResult()
{	
	parent.frames[2].document.location.href="../../eCommon/html/blank.html";
}
</script>

<%
request.setCharacterEncoding("UTF-8");

Connection conn = null;
Statement stmt=null;
ResultSet rset=null;
Statement stmt1=null;
ResultSet rs=null;

try
{
	conn = ConnectionManager.getConnection(request);
	
	stmt1 = conn.createStatement();
	String pat_length="";

	rs=stmt1.executeQuery("select patient_id_length from mp_param");
	if (rs!=null && rs.next())
		pat_length = checkForNull(rs.getString(1));

	if(rs!=null)	rs.close();
	if(stmt1!=null)	stmt1.close();

	if(pat_length == null || pat_length.equals("null")) pat_length = "10";

%>
	<body onLoad="FocusFirstElement()"  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	   <form name = 'Confrm_visit_admsn_form'  target="messageFrame">	
			<table cellpadding='2' cellspacing='0' width='80%' align='center' > 
				<tr><td colspan='3'>&nbsp;</td></tr>
				<tr>
					<td width='10%' class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> </td>
					<td class="fields" width='10%'>
					<input type=text  name='PatientId' id='PatientId'  onBlur="makeValidString(this);ChangeUpperCase(this);validatePatientId(this);" onKeypress='return CheckForSpecChars(event);' align="center" size="" maxlength=<%=pat_length%>><input type='button' name='patient_id' id='patient_id' value='?' class='button' onclick='callSearchScreen()'></td>	

					<td width='10%' class="label"><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td>
					<td class="fields" width="35%">
					<select name='enc_type' id='enc_type'>
					<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/>
					<option value="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/>
					<option value="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/>
					<option value="EM"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/>
					<option value="DC"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/>
					</select>
					</td>
				</tr>
				
				<tr>
					<td class='label' width="30%">&nbsp;</td>
					<td class="querydata" width="35%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="35%">&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>

				<tr>
					<td   class='label'><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></td>
					<td class="fields"><input 'text' id='datefrom' name='frm_enc_date' id='frm_enc_date' value='' size='10' maxlength='10' onblur="ComparePeriodFromToTime(this,to_enc_date); validDateObj(this, 'DMY', localeName); year_check(this,to_enc_date);" onkeypress="return Valid_DT(event)"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('datefrom');"></img><img src="../../eCommon/images/mandatory.gif"></img> 
					</td>
					<td class="fields">&nbsp;<input 'text' id='dateto' name='to_enc_date' id='to_enc_date' value='' size='10' maxlength='10' onblur="ComparePeriodFromToTime(frm_enc_date,this); validDateObj(this, 'DMY', localeName); year_check(frm_enc_date,this);" onkeypress="return Valid_DT(event)" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dateto');"></img><img src="../../eCommon/images/mandatory.gif"></img>
					</td>
				</tr>

				<tr><td colspan='3'>&nbsp;</td></tr>
				<tr> 
					<td colspan='2' class='label'>&nbsp;</td>
					<td align="right" class='button'><input type='button' class='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick='searchResult();'>&nbsp;<input type='button' class='button' name='clear' id='clear'   value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clearResult();'></td>
				</tr>

		   </table>		
	  </form>
	</body>
</html>
<%
}catch(Exception e)
{
	//out.print(e.toString());
	e.printStackTrace();
}
finally   
{
	if(rset!=null)	rset.close();
	if(stmt!=null)	stmt.close();
	if(conn != null)
	ConnectionManager.returnConnection(conn,request);
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

