<!DOCTYPE html>
<%
/// MODULE			:	InPatient Management..(IP)
/// Function Name	:	Nursing Unit Type
/// Funtion			:	Used to create & Modify a Nursing Unit Type... 
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../js/NursingUnitType.js' language='javascript'></script>

<script>

</script>

</head>
<body onLoad = 'FocusFirstElement();' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
 <%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	Connection conn			= null;
	Statement stmt			= null;
	ResultSet rs		    = null;
	ResultSet rset			= null;
	ResultSet rs_bl_charge	= null;
	Statement stmt_bl_charge= null;
	 
    String facilityId = (String)session.getValue("facility_id");

	StringBuffer sql_charge			= new StringBuffer();
	String NursUnitType				= "";
	String longdesc					= "";
	String shortdesc				= "";
	String deposit_appl_yn			= "";
	String addl_dep_yn				= "";
	String effstatus				= "";
	String codeTextAttribute		= "";
	String otherTextAttribute		= "";
	String checkBoxAttribute		= "";
	String eventFunctionForCase		= "";
	String CheckValue				= "";
	String CheckValue1				= "";
	String setup_bl_dtls_in_ip_yn	= "";
	boolean newSpeciality			= false;
 %>
<%
	NursUnitType=request.getParameter("nursing_unit_type_code");
try{
	 conn = ConnectionManager.getConnection(request);
	 stmt_bl_charge	=conn.createStatement();
	 stmt = conn.createStatement();
	 try
		{
			StringBuffer sql_bl = new StringBuffer();
			sql_bl.append("select setup_bl_dtls_in_ip_yn from ip_param where facility_id='"+facilityId+"' ");
			rs = stmt.executeQuery(sql_bl.toString());
			if(rs!=null )
			{
				while(rs.next())
				 {
						setup_bl_dtls_in_ip_yn=rs.getString("setup_bl_dtls_in_ip_yn");
				 }
			}
	  }catch(Exception e)
	  {
		//out.print("Exception here1 :"+e);
		e.printStackTrace();
	  }

	if(NursUnitType==null)
	 {
		NursUnitType		= "";
		longdesc			= "";
		shortdesc			= "";
		deposit_appl_yn		= "";
		addl_dep_yn			= "";
		effstatus			= "E";
		codeTextAttribute	= "";
		otherTextAttribute	= "";
		checkBoxAttribute	= "CHECKED";
		newSpeciality		= true;
		eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
	 }
	 else
	 {
  	 try{
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT nursing_unit_type_code,long_desc,short_desc,eff_status from IP_NURSING_UNIT_TYPE  where nursing_unit_type_code='"+NursUnitType+"'");

		rset = stmt.executeQuery(sql.toString());
		rset.next();
		NursUnitType	=	rset.getString("nursing_unit_type_code");
		longdesc		=	rset.getString("long_desc");
		shortdesc		=	rset.getString("short_desc");
		effstatus		=	rset.getString("eff_status");

		if(effstatus.equals("D"))
		{
			otherTextAttribute="READONLY";
			checkBoxAttribute="";
		}
		else
		{
			otherTextAttribute="";
			checkBoxAttribute="CHECKED";
		}

		if(setup_bl_dtls_in_ip_yn.equals("Y"))
		{
			sql_charge.append("select * from bl_ip_nursing_unit_type where NURSING_UNIT_TYPE_CODE='"+NursUnitType+"' ");
			rs_bl_charge = stmt_bl_charge.executeQuery(sql_charge.toString());

			if(rs_bl_charge!=null)
			 {
				 while(rs_bl_charge.next())
					{
						deposit_appl_yn	=	rs_bl_charge.getString("DEPOSIT_APPL_YN");
				   		addl_dep_yn		=	rs_bl_charge.getString("ADDL_DEP_YN");
				   	 }
			  }

			effstatus = rset.getString("eff_status");
		
			if(effstatus.equals("D"))
			{
				if (deposit_appl_yn.equals("Y"))
			     		CheckValue="CHECKED";			     
		     		else
		     			CheckValue="";

				if (addl_dep_yn.equals("Y")) 
		             		CheckValue1="CHECKED";
		     		else
		     	     		CheckValue1="";
			}
			else
			{
				if (deposit_appl_yn.equals("Y"))
				{
				     	CheckValue="CHECKED";
	      		}
				else
				{
			     		CheckValue="";			    
	      		}
				
				if (addl_dep_yn.equals("Y"))
				{
					 CheckValue1="CHECKED";
		    	}
				else
				{
			      		CheckValue1="";
				}
		   	}
	   }
	   
     }catch(Exception e){
		 //out.println(e.toString());
		 e.printStackTrace();
		 }

	codeTextAttribute="READONLY";
	newSpeciality=false;
	eventFunctionForCase="";
  }
  	if(rset!=null)    			rset.close();
	if(rs!=null)    			rs.close();
	if(rs_bl_charge!=null)    	rs_bl_charge.close();
   	if(stmt!=null)  			stmt.close();
	if(stmt_bl_charge!=null)  	stmt_bl_charge.close();
}catch(Exception e) {//out.println(e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(conn,request);
}
%>

<form name='NursingUnitType_form' id='NursingUnitType_form' action='../../servlet/eIP.NursingUnitTypeServlet' method='post' target='messageFrame'>
<div>
<% if(setup_bl_dtls_in_ip_yn.equals("Y")) { %>
<br><br><br><br><br><br><br>
<% } else { %>
<br><br><br><br><br><br><br>
<%} %>
<table border='0' cellpadding='0' cellspacing='0' width='auto' align='center'>
<tr>
		<td  class='label' width='10%'>&nbsp;</td>
		<td class='label'>&nbsp;</td>
		<td class='label'>&nbsp;</td>
		<td class='label' width='10%'>&nbsp;</td>
</tr>
<tr>
		<td class='label'>&nbsp;</td>
		<td  class='label'><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
		<td class='field'><input type='text' name='Type' id='Type' value="<%=NursUnitType%>" size='4' maxlength='4' <%=codeTextAttribute%> <%=eventFunctionForCase%> onKeyPress="return CheckForSpecChars(event)"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>

		<td class='label'>&nbsp;</td>
</tr>
<tr>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
</tr>
<tr>
		 <td class='label'>&nbsp;</td>
		<td    class=label><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' value="<%=longdesc%>" <%=otherTextAttribute%> onblur="return makeValidString(this);"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>

		<td class='label'>&nbsp;</td>
</tr>
<tr>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
</tr>
<tr>
			<td class='label'>&nbsp;</td>
			<td    class=label><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' value="<%=shortdesc%>" <%=otherTextAttribute%> onblur="return makeValidString(this);" ><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>

			<td class='label'>&nbsp;</td>
			</tr>
			<tr>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
</tr>
<tr>
				<td class='label'>&nbsp;</td>
				<td   class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				<td  align='left' class='fields'><input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="Change1()"></td>
				<td class='label'>&nbsp;</td>
				</tr>
				<tr>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
</tr>
<tr>
			<td  class='label' colspan='4' class='bodycolorfilled' >&nbsp;</td>
</tr>
<th align='left' colspan='4'  id ='bl_field'  style=visibility:hidden;  ><fmt:message key="Common.BillingDetails.label" bundle="${common_labels}"/></th>
<tr  id ='bl_field1'  style=visibility:hidden; >
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
</tr>
<tr  id ='bl_field2'  style=visibility:hidden; >
			<td class='label'>&nbsp;</td>
			<td   class='label'><fmt:message key="eIP.DepositApplicable.label" bundle="${ip_labels}"/></td>
			<td  align='left' class='fields' ><input type='checkbox' name='deposit_appl_yn1' id='deposit_appl_yn1' value="<%=deposit_appl_yn%>"   <%=CheckValue%> onClick="change()"></td>
			<input type='hidden' name='deposit_appl_yn' id='deposit_appl_yn' value="<%=deposit_appl_yn%>" ></td>
			<td class='label'>&nbsp;</td>
</tr>
<tr id ='bl_field3'  style=visibility:hidden; >
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
</tr>

<tr  id ='bl_field4'  style=visibility:hidden; >
				<td class='label'>&nbsp;</td>
				<td   class='label'> <fmt:message key="eIP.AdditionalDepositRequired.label" bundle="${ip_labels}"/></td>
				<td  align='left' class='fields' ><input type='checkbox' name='addl_dep_yn1' id='addl_dep_yn1' value="<%=addl_dep_yn%>"  <%=CheckValue1%> onClick="change()"></td>
				<input type='hidden' name='addl_dep_yn' id='addl_dep_yn' value="<%=addl_dep_yn%>" ></td>
				<td class='label'>&nbsp;</td>
</tr>
<tr id ='bl_field5'  style=visibility:hidden; >
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
</tr>
<input type="hidden" name="setup_bl_dtls_in_ip_yn" id="setup_bl_dtls_in_ip_yn" value="<%=setup_bl_dtls_in_ip_yn%>">
	 <script>
		 <%
			if(setup_bl_dtls_in_ip_yn.equals("Y"))
			{
				out.println("document.getElementById('bl_field').style.visibility='visible';	");
				out.println("document.getElementById('bl_field1').style.visibility='visible';	");
				out.println("document.getElementById('bl_field2').style.visibility='visible';	");
				out.println("document.getElementById('bl_field3').style.visibility='visible';	");
				out.println("document.getElementById('bl_field4').style.visibility='visible';	");
				out.println("document.getElementById('bl_field5').style.visibility='visible';	");
			}
		%>
	</script>
</table>
</div>

<%	if(newSpeciality)
	{ %>
		<input type='hidden' name='function' id='function' value='insert'>
		<input type='hidden' name='function_name' id='function_name' value='insert'>
<%  }
	else
	{ %>
		<input type='hidden' name='function' id='function' value='modify'>
		<input type='hidden' name='function_name' id='function_name' value='modify'>
<%	} %>

</form>
</body>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

