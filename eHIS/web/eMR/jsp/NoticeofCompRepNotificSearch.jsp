<!DOCTYPE html>
<!--Created by Ashwini on 04-Oct-2017 for ML-MMOH-CRF-0763 and ML-MMOH-CRF-0764-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*,org.json.simple.parser.JSONParser,org.json.simple.*,eCommon.XSSRequestWrapper" %>
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
  <script language='javascript' src="../js/NoticeofCompRepNotific.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<script>
async function clearResult()
{	
	parent.frames[2].document.location.href="../../eCommon/html/blank.html";
	parent.frames[3].document.location.href="../../eCommon/jsp/error.jsp";
}
</script>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

Connection conn = null;
Statement stmt=null;
ResultSet rset=null;
Statement stmt1=null;
ResultSet rs=null;

String function_id			 = request.getParameter("function_id");
SimpleDateFormat dateFormat1 = new SimpleDateFormat( "dd/MM/yyyy" ) ;
String currentdate 			 = dateFormat1.format(new java.util.Date()) ;

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
	<body onLoad="FocusFirstElement();datechange();"  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	   <form name = 'notice_compltd_rep_notific_form'  target="messageFrame">	
			<table cellpadding='2' cellspacing='0' width='80%' align='center' > 

				<tr><td colspan='3'>&nbsp;</td></tr>

				<tr>
					<% if(function_id.equals("NOTICE_OF_COMPLTD_REP_NOTIFIC")){ %>
						<td align='left' width='30%' class="label"><fmt:message key="eMR.ReceivedAtMRD.label" bundle="${mr_labels}"/>&nbsp;</td>
					<% }else if(function_id.equals("CONFIRM_POST_RECEIPT_MED_REP")){ %>
						<td align='left' width='30%' class="label"><fmt:message key="eMR.DeliveredDate.label" bundle="${mr_labels}"/>&nbsp;</td>
					<!--Modified by Ashwini on 03-Jul-2018 for ML-MMOH-CRF-0722-->
					<% }else if(function_id.equals("MEDICAL_REPORT_APP") || function_id.equals("REFUND_LETTER")){ %>
						<td align='left' width='30%' class="label"><fmt:message key="Common.RequestDate.label" bundle="${common_labels}"/>&nbsp;</td>
					<% }else if(function_id.equals("PREPARE_MEDICAL_REPORT")){ %>
						<td align='left' width='30%' class="label"><fmt:message key="Common.PrepareDate.label" bundle="${common_labels}"/>&nbsp;</td>
					<% } %>
					<td width='30%' class="fields"  >
						 <SELECT name="recv_mrd" id="recv_mrd" onchange='datechange()'>
						 <option value="D"><fmt:message key="Common.daily.label" bundle="${common_labels}"/></option>
						 <option value="M"><fmt:message key="Common.monthly.label" bundle="${common_labels}"/></option>
						 <option value="Y"><fmt:message key="Common.Yearly.label" bundle="${common_labels}"/></option>
						 </SELECT>
					</td>
				</tr>

				<tr>
					<td align="center" width="30%">&nbsp;</td>
					<td class="querydata" width="30%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="30%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
                 
                <tr>
					<td align='left' id='date_label'class="label"> &nbsp; </td>
					<td align='left' id='from_date' > &nbsp; </td>
					<td align='left' id='to_date' > &nbsp; </td>
			    </tr>

				<tr>
					<td width='30%' class="label"><fmt:message key="eMR.RequestID.label" bundle="${mr_labels}"/> </td>
					<td class="fields" width='30%'> <input type='text' name="req_id" id="req_id" onkeypress="return ReqIdNumCheck(event)" size="15" maxlength="12"></td>
				</tr>

				<tr>
					<td width='30%' class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> </td>
					<td class="fields" width='30%'>
					<input type=text  name='PatientId' id='PatientId'  onBlur="makeValidString(this);ChangeUpperCase(this);validatePatientId(this);" onKeypress='return CheckForSpecChars(event);' align="center" size="" maxlength=<%=pat_length%>><input type='button' name='patient_id' id='patient_id' value='?' class='button' onclick='callSearchScreen()'></td>	
				</tr>

				<tr><td colspan='3'>&nbsp;</td></tr>

				<tr> 
					<td colspan='2' class='label'>&nbsp;</td>
					<td class='button' style="text-align: right;"><input type='button' class='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick='searchResult();'>&nbsp;<input type='button' class='button' name='clear' id='clear'   value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clearResult();'></td>
				</tr>

		   </table>		
		   <input type='hidden' name='current_date' id='current_date'	value= "<%=currentdate%>">
		   <input type='hidden' name='function_id' id='function_id' value= "<%=function_id%>">
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

