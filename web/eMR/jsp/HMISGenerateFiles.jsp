<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%	
	request.setCharacterEncoding("UTF-8");
	Connection con =null;
	Statement stmt=null;
	ResultSet rs =null;      
	con =null;
	stmt=null;
	ResultSet rs1 =null;      
	try{

	con = ConnectionManager.getConnection(request);
	stmt=con.createStatement();

	 String sql1="Select B.FACILITY_NAME FACILITY_NAME , A.MEDICOM_CODE1 MEDICOM_CODE1, A.HMIS_CODE1 HMIS_CODE1 from XT_HMIS_LINK A, SM_FACILITY_PARAM B Where A.TABLE_ID = 'SM_FACILITY_PARAM'and A.MEDICOM_CODE1 = B.FACILITY_ID";
	
	rs = stmt.executeQuery(sql1);
	int flag2=0;
		
	%>


<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/CommonCalendar.js' language='javascript'></script>
<script language='javascript' src='../../eMR/js/HMISGenerateFile.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body  onLoad="FocusFirstElement();"  onKeyDown = 'lockKey()'; OnMouseDown="CodeArrest()">
<form name='HMISGenerateForm' id='HMISGenerateForm' target='messageFrame' action="../../servlet/eMR.HMISGenerateFilesServlet" method=post>

<input type='hidden' name='filetype_flag' id='filetype_flag' value="">

	<br><br><br><br><br><br>
	<table border='0' cellpadding='5' cellspacing='0' width='auto' align='center'>

	
	  
		
		<tr>
		<td class='label' width='50%'>
		<fmt:message key="Common.Hospital.label" bundle="${common_labels}"/></td>

		<td class='fields' width='50%'>
		<select name='hmis_hospital' id='hmis_hospital'>
		<option value=''>-----------------  <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>  -----------------</option>
		<%
		String facility_name ="";   
		String medicom_code ="";	
		String hmis_code ="";  
		String combcode =""; 

		if( rs != null )
		{
			while( rs.next() )
			{
				facility_name = rs.getString( "facility_name" );
				medicom_code = rs.getString( "MEDICOM_CODE1" );
				hmis_code = rs.getString( "HMIS_CODE1" );
				combcode = medicom_code+"|"+hmis_code;
				flag2++;
				%>
				<OPTION VALUE="<%= combcode %>" ><%= facility_name %></option>
				<%
			}
		}
	//	if(stmt	 != null)   stmt.close();
		if(rs	 != null)   rs.close();
		%>
		</select><img align='center' src='../../eCommon/images/mandatory.gif'></img>
		</td>
		</tr> 

		<%
		if(flag2==1)
		{
		%>
		<script>
		var obj=document.getElementById("hmis_hospital")
		obj.remove(0);
		</script>
		<%
		}
		%> 



<%	
	 //String sql1="Select B.FACILITY_NAME FACILITY_NAME , A.MEDICOM_CODE1 MEDICOM_CODE1, A.HMIS_CODE1 HMIS_CODE1 from XT_HMIS_LINK A, SM_FACILITY_PARAM B Where A.TABLE_ID = 'SM_FACILITY_PARAM'and A.MEDICOM_CODE1 = B.FACILITY_ID";

	 sql1="Select B.LONG_DESC LONG_DESC, A.HMIS_CODE1 HMIS_CODE1 from XT_HMIS_LINK A, MP_REGION B Where A.TABLE_ID ='MP_REGION' and A.MEDICOM_CODE1 = B.REGION_CODE and A.INDICATOR = 'Y'";
	
	rs1 = stmt.executeQuery(sql1);
	//int number_of_records2 = rs1.getFetchSize();
	int flag1=0;
		
	%>


<tr>
	<td class='label' >
	<fmt:message key="Common.State.label" bundle="${common_labels}"/></td>

		<td class='fields'>
			<select name='hmis_state' id='hmis_state'>
    	    <option value=''>-----------------  <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>  -----------------</option>
		<%
	String long_desc ="";   
    String  hmis_code2 ="";	

	       if( rs1 != null )
	      {
	        while( rs1.next() )
	        {
     		long_desc = rs1.getString( "LONG_DESC" );
			hmis_code2 = rs1.getString( "HMIS_CODE1" );
			flag1++;
			
			
%>
		<OPTION VALUE="<%= hmis_code2 %>" ><%= long_desc %></option>
	<%
		  }
	      }
		  if(stmt	 != null)   stmt.close();
		  if(rs1	 != null)   rs1.close();
%>
			</select><img align='center' src='../../eCommon/images/mandatory.gif'></img>
						</td>
    </tr> 
				 <%
				if(flag1==1)
				{
				%>
				<script>
					var obj=document.getElementById("hmis_state")
					//document.getElementById("hmis_state").options[0].selected=true;
					obj.remove(0);
					</script>
						<%
				}
						%> 

	<tr >
	<td class='label' >
	<fmt:message key="eMR.ExternalFile.label" bundle="${mr_labels}"/></td>

		<td class='fields'>
			<select name='hmis_file_type' id='hmis_file_type' onChange="chooseobj();">
    	    <option value=''>-----------------  <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>  -----------------</option>
    	    <option value='PD301'>Daily Discharges (PD301)</option>
    	    <option value='PD103'>Daily Inpatient Census (PD103)</option>
    	    <option value='PD205'>Monthly Maternity Census (PD205)</option>
	    </select><img align='center' src='../../eCommon/images/mandatory.gif'></img>
		</td>
    </tr> 



<tr id="" ><td colspan='2' id="bar1" ></td></tr>
<tr>
		<td class='label' id='label2'></td>
		<td class='label' id='obj2'></td>
</tr>      

   </table>
    
	<input type ="hidden" name ="census_date" value="">
	<input type ="hidden" name ="discharge_date" value="">
	<input type ="hidden" name ="maternity_month" value="">
		
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
	catch(Exception closen){/* out.println(closen.toString()); */closen.printStackTrace(); }
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

