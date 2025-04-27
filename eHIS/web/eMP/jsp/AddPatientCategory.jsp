<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	Connection con		=null;
	Statement	stmt	=null;
	ResultSet	rs		=null;
	ResultSet	rs1		=null;

	try
	{
		con = ConnectionManager.getConnection(request);
		stmt	=con.createStatement();
		String sql  = "select pat_cat_code,govt_or_pvt_ind from mp_pat_category where  govt_or_pvt_ind='K'";
		rs = stmt.executeQuery(sql) ;
		String UnknownCategory="";
		String DBType ="";
		while(rs.next()){
			 UnknownCategory=rs.getString(1);	
			 DBType=rs.getString(2);	
		}

		String query="select ENTITLEMENT_BY_PAT_CAT_YN from mp_param";
        rs1 = stmt.executeQuery(query);
		 String eligibility="";
		 while(rs1.next())
			{
             eligibility=rs1.getString("ENTITLEMENT_BY_PAT_CAT_YN");
		    }
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eMP/js/PatientCategory.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

				<script>
function calldis()
{
	parent.frames[0].document.getElementById("apply").disabled= false;
}
</script>
	</head>
	<body OnMouseDown="CodeArrest()" onKeyDown='lockKey();' onLoad="Focusing('patient_cat_code'); hide();calldis();">
		<form name='patient_cat_form' id='patient_cat_form' action='../../servlet/eMP.PatientCatServlet' method='post' target='messageFrame'>
		<BR><BR><BR><BR><BR><BR><BR>
		<table border='0' cellpadding='3' cellspacing='0' width='75%' align='center'>
			 <tr>
				  <td width='25%'>&nbsp;</td>
				  <td width='50%'>&nbsp;</td>
			 </tr>

			<tr>
			  <td class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			  <td class='fields'><input type='text' name='patient_cat_code' id='patient_cat_code' size='4'maxlength='4' onBlur=ChangeUpperCase(this); onKeyPress="return CheckForSpecChars(event)"><img src='../images/mandatory.gif'></img>
			  </td>
					
			</tr>
		<tr>
			<td class='label' ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='text' name='long_desc' id='long_desc' size='33' maxlength='30' onBlur='makeValidString(this)' style='{ font-size: ;}'><img src='../images/mandatory.gif'></img>
			</td>
					
		</tr>
		<tr>
			<td class='label' ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' onBlur='makeValidString(this)' ><img src='../images/mandatory.gif'></img>
			</td>
		</tr>
		<tr>
			<td class='label'><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
		    <td class='fields'><select name='job_type1' id='job_type1'>	     
					<option value="D"><fmt:message key="eMP.DesignatedRoyalties.label" bundle="${mp_labels}"/></option>
					<option value="W"><fmt:message key="eMP.EstateWorkers.label" bundle="${mp_labels}"/></option>
					<option value="F"><fmt:message key="eMP.Foreigner.label" bundle="${mp_labels}"/></option>
					<option value="G" selected><fmt:message key="Common.Government.label" bundle="${common_labels}"/></option>
					<option value="R"><fmt:message key="eMP.Pensioner.label" bundle="${mp_labels}"/></option>
					<option value="C"><fmt:message key="eMP.PersonUnderPoliceCustody.label" bundle="${mp_labels}"/></option>
					<option value="P"><fmt:message key="Common.Private.label" bundle="${common_labels}"/></option>		
					<option value="I"><fmt:message key="eMP.Prisoners.label" bundle="${mp_labels}"/></option>
					<option value="B"><fmt:message key="eMP.RegisteredDisabled.label" bundle="${mp_labels}"/></option>
					<option value="E"><fmt:message key="eMP.SelfEmployed.label" bundle="${mp_labels}"/></option>
					<option value="S"><fmt:message key="eMP.Semigovernment.label" bundle="${mp_labels}"/></option>		
					<option value="T"><fmt:message key="eMP.Student.label" bundle="${mp_labels}"/></option>	    
					<option value="U"><fmt:message key="eMP.Unemployed.label" bundle="${mp_labels}"/></option>
					<option value="V"><fmt:message key="Common.VIP.label" bundle="${common_labels}"/></option>
					<option value="K"><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
				</select><img src='../images/mandatory.gif'></img>
		  </td>
				  
		 </tr>
		 <%if(eligibility.equals("Y")){%>
		  <tr>
		  <td  class='label'><fmt:message key="eMP.ExpiryApplicable.label" bundle="${mp_labels}"/></td>
		  <td  class='fields'><input type='checkbox' name='expiry_appl' id='expiry_appl' value='N'  onClick='mandate(this)'></td>
			
		</tr>
		<tr>
		<td class='label' ><fmt:message key="Common.ExpiryPeriod.label" bundle="${common_labels}"/> </td>
		<td >
		<table border='0' cellpadding='0' cellspacing='0' width='75%' align='left'>
		  <tr>
			<td width='15%' class='fields'><input type='text' name='expiry_period' id='expiry_period' size='3' maxLength='3' disabled onkeypress="return allowPositiveNumber()" onblur="chkdays(this);"></td>
				<td class='label' width='20%'><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
				   <td>
				<img id='expiry' src='../../eMP/images/mandatory.gif' style="visibility:hidden">
				</img>
			</td>
		   </tr>
		</table>
	</td>
    </tr>

<%}else{%> 
		<tr>
		  <td  class='label'><fmt:message key="eMP.ExpiryApplicable.label" bundle="${mp_labels}"/></td>
		  <td  class='fields'><input type='checkbox' name='expiry_appl' id='expiry_appl' disabled value='N'  onClick='mandate(this)'></td>
		</tr>

			
		<tr>
		<td  class='label' ><fmt:message key="Common.ExpiryPeriod.label" bundle="${common_labels}"/> </td>
		<td  >
		<table border='0' cellpadding='0' cellspacing='0' width='75%' align='left'>
		  <tr>
			<td width='15%' class='fields'><input type='text' name='expiry_period' id='expiry_period' size='3'  maxLength='3' disabled onkeypress="return allowPositiveNumber()" onblur="chkdays(this);"></td>
				<td class='label' width='20%'><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
				   <td>
				 <img id='expiry' src='../../eMP/images/mandatory.gif' style="visibility:hidden">
				</img>
			</td>
		   </tr>
		</table>
</td>
			
    </tr>
		<%}%>
    <!--tr>
      <td width='40%' class='label' >Effective From</td>
      <td width='13%' >&nbsp;&nbsp;&nbsp;--><input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10'   maxlength='10'>
      <!--td width="47%" class="label"> &nbsp;&nbsp;To&nbsp;&nbsp;--> <input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10'  maxlength='10'><!--/td-->
	<tr>
		<td  class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td  class='fields'><input type='checkbox' name='eff_status' id='eff_status' value='E' checked></td>
			
    </tr>

    <tr>
  	  <td >&nbsp;</td>
  	  <td  >&nbsp;</td>
	
   </tr>
  </table>
<input type='hidden' name='job_type' id='job_type' value=''>
<input type='hidden' name='function' id='function' value='insert'>
<input type='hidden' name='eff_date_from' id='eff_date_from' >
<input type='hidden' name='eff_date_to' id='eff_date_to' >
<input type='hidden' name='function_name' id='function_name' value='insert'>
<input type='hidden' name='UnknownCategory' id='UnknownCategory' value='<%=UnknownCategory%>'>
<input type='hidden' name='DBType' id='DBType' value='<%=DBType%>'>
</form>
<%
}finally{
	if(rs !=null) rs.close();
	if(rs1 !=null) rs1.close();
	if(stmt !=null) stmt.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

