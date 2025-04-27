<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/CommonCalendar.js' language='javascript'></script>
<script language='javascript' src='../../eMR/js/GenerateSMRP.js'></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%	
	request.setCharacterEncoding("UTF-8");
	Connection con =null;
	Statement stmt=null;
	ResultSet rs =null;      
	con =null;
	stmt=null;
	ResultSet rs1 =null;      
	String locale					= (String)session.getAttribute("LOCALE"); 
	String smrp_rep ="";	
	try{

	con = ConnectionManager.getConnection(request);
	stmt=con.createStatement();

	 String sql1="Select FACILITY_NAME ,FACILITY_ID ,(select value_3 from SM_FUNCTION_CONTROL where functionality_id='SMRP' and KEY_3='R' and SITE_ID=(select customer_id from sm_site_param)) SMRP_REP  from  SM_FACILITY_PARAM_lang_vw B Where language_id='"+locale+"' and status='E' and facility_id !='DF' ";
	
	rs = stmt.executeQuery(sql1);
	
	%>



<body  onLoad="FocusFirstElement();repop_Rep();"  onKeyDown = 'lockKey()'; OnMouseDown="CodeArrest()">
<form name='SMRPGenerateForm' id='SMRPGenerateForm' target='messageFrame' action="none" method=post>

<input type='hidden' name='filetype_flag' id='filetype_flag' value="">

	<br><br><br><br><br><br>
	<table border='0' cellpadding='5' cellspacing='0' width='auto' align='center' width="80%">
  
		
		<tr>
		<td class='label' width='30%'>
		<fmt:message key="Common.Hospital.label" bundle="${common_labels}"/></td>

		<td class='fields' width='70%'>
		<select name='hmis_hospital' id='hmis_hospital'>
		<option value=''>-----------------  <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>  -----------------</option>
		<%
		String facility_name ="";   
		String facility_id ="";	
		

		if( rs != null )
		{
			while( rs.next() )
			{
				facility_name = rs.getString( "facility_name" );
				facility_id = rs.getString( "facility_id" );
				smrp_rep=rs.getString( "smrp_rep" );
				
				%>
				<OPTION VALUE="<%= facility_id %>" ><%= facility_name %></option>
				<%
			}
		}
		
		if(rs	 != null)   rs.close();
		if(stmt	 != null)   stmt.close();
		%>
		</select><img align='center' src='../../eCommon/images/mandatory.gif'></img>
		</td>
		</tr> 
	    <tr>
			<td align='right' width='30%' class="label"><fmt:message key="eMR.ReportFor.label" bundle="${mr_labels}"/> &nbsp;</td>
			<td width='70%' class='fields'><input type='text' id='rep_date' name='rep_date' id='rep_date' size='10' onBlur="validdate_rep_date(this);" maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('rep_date');"/>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></td>
		
		</tr>
	<tr >
	<td class='label' width="30%">
	<fmt:message key="eMR.ExternalFile.label" bundle="${mr_labels}"/></td>

		<td class='fields' width='70%'>
			<select name='report_name' id='report_name' id='report_name' >
    	    <option value=''>-----------------  <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>  -----------------</option>
	    </select><img align='center' src='../../eCommon/images/mandatory.gif'></img>
		</td>
    </tr> 



<tr id="" ><td colspan='2' id="bar1" ></td></tr>
<tr>
		<td class='label' id='label2'></td>
		<td class='label' id='obj2'></td>
</tr>      

   </table>
    
	<input type ="hidden" name ="census_date" id ="census_date" value="">
	<input type ="hidden" name ="discharge_date" id ="discharge_date" value="">
	<input type ="hidden" name ="maternity_month" id ="maternity_month" value="">
	<input type ="hidden" name ="locale" id ="locale" value="<%=locale%>">
	<input type ="hidden" name ="smrp_rep" id ="smrp_rep" value="<%=smrp_rep%>">
		
	</form>
<%
	

}
catch(Exception e)
{
	//out.println(e);
	e.printStackTrace();
	
}

finally
{
ConnectionManager.returnConnection(con,request);
	try
	{
	  if (stmt!=null)  stmt.close();
	  if (rs!=null)  rs.close();
	  if (rs1!=null)  rs1.close();
	}
	catch(Exception closen){/* out.println(closen.toString()); */closen.printStackTrace();}
}

%>

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

