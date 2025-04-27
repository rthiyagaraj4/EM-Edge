<!DOCTYPE html>
<%--
	FileName	: CircumstanceofInjuryAddModify.jsp
	Version	    : 3	
	Modified On	: 19-2-2005
--%>

<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src='../../eAM/js/CircumstanceofInjury.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 
 



<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Statement stmt=null;
	PreparedStatement pstmt = null;
	ResultSet rset=null ;
	String circumstanceofInjuryCode="";
	String longdesc="";
	String shortdesc="";
	String injuryReimbursementType="";
	String effstatus="";
	String fnval="insert";
	String rdonly="";
	String sql="";
	String checkBoxAttribute="";
	String eventFunctionForCase="";
	String reind="";
	String reind1="";
	String reind2="";
	String reind3="";
	String reind4="";
	//String val1="";
	String val2="";
	String val3="";
	String val4="";
	String val5="";
	//String id1="";
	String disabled="";

	eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
	//SimpleDateFormat formatter=null;
	//java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
	circumstanceofInjuryCode=request.getParameter("circumstance_of_injury_code");
	String str="";

/* if function is insert*/
//out.println("asdkf " +circumstanceofInjuryCode);

if (circumstanceofInjuryCode == null)
{
	fnval="insert";
	circumstanceofInjuryCode="";
	longdesc="";
	shortdesc="";
	effstatus="E";
	rdonly="";
	checkBoxAttribute="CHECKED";
	eventFunctionForCase="Onblur='ChangeUpperCase(this)'";
}
else
/* if function is update*/

{
	fnval="modify";
	Connection conn = ConnectionManager.getConnection(request);
	
	try
	{
		stmt = conn.createStatement();
		//sql = "select circumstance_of_injury_code, long_desc, short_desc,injury_reimbursement_type,eff_status  from am_circumstance_of_injury  where circumstance_of_injury_code='"+circumstanceofInjuryCode+"'";
		//rset = stmt.executeQuery(sql);
		
		sql = "select circumstance_of_injury_code, long_desc, short_desc,injury_reimbursement_type,eff_status  from am_circumstance_of_injury  where circumstance_of_injury_code=?";
		pstmt   = conn.prepareStatement(sql);
		pstmt.setString	(	1,	circumstanceofInjuryCode );
		rset		 = pstmt.executeQuery();

		rset.next();
		circumstanceofInjuryCode=rset.getString("circumstance_of_injury_code");
		longdesc=rset.getString("long_desc");
		shortdesc=rset.getString("short_desc");
		injuryReimbursementType=rset.getString("injury_reimbursement_type");

		if(injuryReimbursementType==null)
		injuryReimbursementType="";

	    if (injuryReimbursementType.equals("MV"))
	    {
	    reind3=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.GovernmentEmployees.label","am_labels");
		reind=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.MotorVehicleAccidentFund.label","am_labels");
	    reind2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
	    reind4=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
		reind1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.WorkmenCompensationFund.label","am_labels");
	 	//val1="MV";
	 	val2="WC";
//		val3="";
		val3="NA";
		val4="GE";
		val5="OT";
		str="<option value='"+val4+"'>"+reind3+"<option value='"+injuryReimbursementType+"' selected>"+reind+"<option value='"+val3+"'>"+reind2+"<option value='"+val5+"'>"+reind4+"<option value='"+val2+"'>"+reind1+"</select>";
		}
		else if(injuryReimbursementType.equals("WC"))
		{
		reind3=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.GovernmentEmployees.label","am_labels");
		reind2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.MotorVehicleAccidentFund.label","am_labels");
		reind1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
	    reind4=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
		reind=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.WorkmenCompensationFund.label","am_labels");
		//val1="WC";
//		val2="";
		val2="NA";
		val3="MV";
		val4="GE";
		val5="OT";
		str="<option value='"+val4+"'>"+reind3+"<option value='"+val3+"'>"+reind2+"<option value='"+val2+"'>"+reind1+"<option value='"+val5+"'>"+reind4+"<option value='"+injuryReimbursementType+"' selected>"+reind+"</select>";
		}
		else if(injuryReimbursementType.equals("GE"))
		{
		reind=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.GovernmentEmployees.label","am_labels");
		reind2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.MotorVehicleAccidentFund.label","am_labels");
		reind1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
	    reind4=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
		reind3=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.WorkmenCompensationFund.label","am_labels");
		//val1="GE";
//		val2="";
		val2="NA";
		val3="MV";
		val4="WC";
		val5="OT";
		str="<option value='"+injuryReimbursementType+"' selected>"+reind+"<option value='"+val3+"'>"+reind2+"<option value='"+val2+"'>"+reind1+"<option value='"+val5+"'>"+reind4+"<option value='"+val4+"'>"+reind3+"</select>";
		}
		else if(injuryReimbursementType.equals("OT"))
		{
		reind3=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.GovernmentEmployees.label","am_labels");
		reind2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.MotorVehicleAccidentFund.label","am_labels");
		reind1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
		reind=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
	    reind4=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.WorkmenCompensationFund.label","am_labels");
		//val1="OT";
//		val2="";
		val2="NA";
		val3="MV";
		val4="GE";
		val5="WC";
		str="<option value='"+val4+"'>"+reind3+"<option value='"+val3+"'>"+reind2+"<option value='"+val2+"'>"+reind1+"<option value='"+injuryReimbursementType+"' selected>"+reind+"<option value='"+val5+"'>"+reind4+"</select>";
		}
		else if(injuryReimbursementType.equals("NA"))
		{
		reind3=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.GovernmentEmployees.label","am_labels");
		reind1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.MotorVehicleAccidentFund.label","am_labels");
		reind=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
		reind4=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
		reind2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.WorkmenCompensationFund.label","am_labels");
		//val1="";
		val2="MV";
		val3="WC";
		val4="GE";
		val5="OT";
		str="<option value ='"+val4+"'>"+reind3+"<option value='"+val2+"'>"+reind1+"<option value='"+injuryReimbursementType+"' selected>"+reind+"<option value='"+val5+"'>"+reind4+"<option value='"+val3+"'>"+reind2+" </select>";
		}
		effstatus=rset.getString("eff_status");
		if (effstatus.equals("D"))

		{
				checkBoxAttribute="";
		}
		else
		{
				checkBoxAttribute="CHECKED";
			}
			if(rset!=null)	rset.close();
			if(stmt!=null)	stmt.close();
		}
	catch(Exception e)
	{
		e.toString();
	}
	finally
	{
		
		ConnectionManager.returnConnection(conn,request);
	}
}
		%>



<body  OnMouseDown='CodeArrest()' onLoad='FocusFirstElement()' onKeyDown = 'lockKey()'> 
  	<form name='CircumstanceofInjury_form' id='CircumstanceofInjury_form' action='../../servlet/eAM.CircumstanceofInjuryServlet' method='post' target='messageFrame'>
		 <br><br><br><br><br><br><br><br><br>
		   <table border='0' cellpadding='0' cellspacing='0' width='auto' align='center'>
		      	<%
		      		if (fnval == "modify" && effstatus.equals("D")) 
		      		{
		      		  rdonly = "readonly" ;
		      		  disabled="disabled";
		      		}
		      	  else
		      		  	rdonly = "" ;
		      	%>
		<tr>
		     <td width='10%'>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td width='10%'>&nbsp;</td>
		</tr>

   		<tr>
   		    <td>&nbsp;</td>
   		    <td class='label'><!--width='40%'--> <fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
   		    <td class='fields'><!-- width='60%' colspan='2'-->&nbsp;&nbsp;
   		    <%if (fnval .equals("modify")) rdonly="readonly"; %>
		      <input type='text' onKeyPress="return CheckForSpecChars(event)"   onBlur="makeValidString(this);changeCase(this)" name='circumstance_of_injury_code' id='circumstance_of_injury_code' value="<%=circumstanceofInjuryCode%>" size='4' maxlength='4' <%=rdonly%> <%=eventFunctionForCase%>>
		       <img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
		       <td>&nbsp;</td>
		  </tr>

		  <tr>
		   	 <td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>

   		<tr>
   		    <td>&nbsp;</td>
   		    <td class=label><!--width='40%'--><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
   		    <td class='fields'><!--width='60%' colspan='2'-->&nbsp;&nbsp;
   		    <input type='text' onBlur="makeValidString(this)" name='long_desc' id='long_desc' size='30' maxlength='30' <%=disabled%> value="<%=longdesc%>"  >
     		    <img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
   		    <td>&nbsp;</td>
   		</tr>

   		<tr>
   			<td>&nbsp;</td>
    		<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>

		   <tr>
		     <td>&nbsp;</td>
		      <td class=label><!-- width='40%'--><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td class='fields'><!--width='60%' colspan='2'-->&nbsp;&nbsp;
				<input type='text' onBlur="makeValidString(this)" name='short_desc' id='short_desc' size='15' maxlength='15' <%=disabled%> value="<%=shortdesc%>"  >
			  <img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
				<td>&nbsp;</td>
		   </tr>

		<tr>
		   	<td>&nbsp;</td>
		    <td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>

		   <tr>
		      <td>&nbsp;</td>
		      <td  class=label> <fmt:message key="eAM.ReimbursementType.label" bundle="${am_labels}"/></td>
			  <td class='fields'>&nbsp;&nbsp;

				<%
				
				if (fnval.equals( "modify") && !str.equals(""))
				{
				        str="<select name='injury_reimbursement_type' id='injury_reimbursement_type' "+disabled+" >"+str;
				%>
					<%=str%>
				<%
				}
				else
				{

				%>
					<select name='injury_reimbursement_type' id='injury_reimbursement_type' >
						<option value="GE"><fmt:message key="eAM.GovernmentEmployees.label" bundle="${am_labels}"/>
						<option value="MV"><fmt:message key="eAM.MotorVehicleAccidentFund.label" bundle="${am_labels}"/>
		      		 	<option value="NA"><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/>
						<option value="OT"><fmt:message key="Common.others.label" bundle="${common_labels}"/>	
		      		 	<option value="WC"><fmt:message key="eAM.WorkmenCompensationFund.label" bundle="${am_labels}"/>
					 	
		      		 	</option>
		      		</select>

					<!--select name='injury_reimbursement_type' >
		      		 	<option value="NA">Not Applicable
		      		 	<option value="GE">Government Employees
		      		 	<option value="MV">Motor Vehicle Accident Fund
		      		 	<option value="WC">Workmen's Compensation Fund
					 	<option value="OT">Others	
		      		 	</option>
		      		</select-->
		      		<%
		      		}

		      		%>

		      </td>
		    <td>&nbsp;</td>
		 </tr>

		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>

		<tr>
      		     <td>&nbsp;</td>
      		     <td   class='label'> <fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
      		     <td  class='fields' > &nbsp;&nbsp;
      		     <input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="checkboxvalue()"></td>
      		     <td>&nbsp;</td>
   </tr>

	<tr>
      				<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
	</tr>
<%
	//			} //end if
%>

<%
    //   	} //end try

%>

	</table>
		       	<input type='hidden' name='function' id='function' value='<%=fnval%>'>
		      	<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>

    	</form>
</body>
</html>

