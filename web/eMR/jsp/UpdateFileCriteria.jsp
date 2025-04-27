<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,com.ehis.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/common.js" ></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
	<script language='javascript' src='../../eCommon/js/dchk.js' ></script>
	<script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language='javascript' src="../js/UpdatefileCriteria.js"></script>
<script>
function allowAlphaNumeric(event){
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) == -1) return false;  
	return true ;
}

function changeCase(Obj)
{
	Obj.value =Obj.value.toUpperCase();
}


</script>
</head>
<%  request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String p_user_name		= (String) session.getValue( "login_user" );
	String locale           = (String) session.getAttribute("LOCALE");
	Connection con = ConnectionManager.getConnection(request);
	ResultSet rs   = null;
	ResultSet rs1   = null;
	Statement stmt = null;
	Statement stmt1 = null;
	String pat_id_length = "";
	String call_function=request.getParameter("call_function");
	if(call_function == null) call_function="";	
		try
		{
			stmt = con.createStatement();
			rs	=	stmt.executeQuery("select patient_id_length from mp_param");
			if (rs.next() && rs != null)
			{
				pat_id_length = rs.getString(1);
				
			}
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if (stmt != null) stmt.close();
			  ConnectionManager.returnConnection(con,request);
		}		
	
%>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
   <form name = 'search_form' >
  
	<table cellpadding='2'  border='0' cellspacing='0' width='100%'  >
		<tr><td width="25%" class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td width="25%" class="fields" ><input type=text name='PatientId' id='PatientId' size="" maxlength="<%=pat_id_length%>" onBlur="makeValidString(this);ChangeUpperCase(this);PatValidations(document.forms[0].PatientId);" onKeypress='return CheckForSpecChars(event);' align="center"><input type='button' name='patient_id' id='patient_id' value='?' class='button' onclick='callSearchScreen()'> 
		<td width="25%"></td>
		<td width="25%"></td>
	<!--  <img src='../../eCommon/images/mandatory.gif' align='center' id='patID_img' </img>--></td>
</tr>
	<tr>
		<td class="label" width="25%"><fmt:message key="Common.fileno.label" bundle="${common_labels}"/></td>
		<td class="fields" width="25%"><input type=text  name='file_no' id='file_no' size="12" maxlength="12" onKeyPress='return allowAlphaNumeric(event)' align="center"></td>		
		<td class="label" width="25%"><fmt:message key="Common.OldFileNo.label" bundle="${common_labels}"/></td>
		<td class="fields" width="25%"><input type=text  name='old_file_no' id='old_file_no' size="20" maxlength="20" onKeyPress='return allowAlphaNumeric(event)'   onBlur='changeCase(this)'  align="center"></td>		
		</tr>
		<tr>
 		<td class="label" width="20%"></td>
		<td class="fields" width="20%"></td>
		<td class='label' >&nbsp;</td> 
		<td class="button" width="100%" style="text-align: right;">
		<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage()'>
		<input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick='clearAll()'>
		</td>
		</tr>
		</table>
	
	 <input type='hidden' name='call_function' id='call_function' value="<%=call_function%>" >
	 
  </form>
</body>

</html>
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

