<!DOCTYPE html>
<!-- Last Modified Date Time : 9/30/2005 11:41 AM -->

<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
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
	<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()' onLoad="calldis();FocusFirstElement();">
<%
	String patient_cat_code = request.getParameter("patient_cat_code");
	String eligibility="";
	Connection conn = null;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	java.sql.Statement	stmt	=null;
	ResultSet	rs		=null;
	ResultSet	rs1		=null;
	String eff_date_from="",eff_date_to="";
	String UnknownCategory="";
	String DBType="";
	String disabled_new="";
	String EXP_VAL_APPL_YN="";

	try{
		conn = ConnectionManager.getConnection(request);
	     stmt				= conn.createStatement();
		//String status = "" ;

		String select_g = "";String select_pn = "";	String select_p = "";String select_st = "";	
		String select_rd = "";	String select_pc = "";	String select_pr = "";
		String select_ew = "";	String select_e = "";	String select_f = "";
		String select_k = "";String select_sg = "";String select_d = "";String select_se="";
		String select_ve = "";
		
		StringBuffer sql = new StringBuffer("select pat_cat_code,long_desc,short_desc,govt_or_pvt_ind,EXP_VAL_APPL_YN, EXP_PERIOD_IN_DAYS,eff_date_from,eff_date_to,eff_status from mp_pat_category where pat_cat_code='");
		sql.append(patient_cat_code);
		sql.append("'");
		pstmt = conn.prepareStatement(sql.toString());
		rset = pstmt.executeQuery();

		if( rset != null ){
		  rset.next();
		   
		}
		String query="select ENTITLEMENT_BY_PAT_CAT_YN from mp_param";
        rs1 = stmt.executeQuery(query);
		 
		 if(rs1.next())
			{
             eligibility=rs1.getString("ENTITLEMENT_BY_PAT_CAT_YN");
		    }
     if(rs1!=null) rs1.close();
	 if(eligibility.equals("N"))
		 disabled_new="disabled";
%>
	<body  onLoad='hide()' onKeyDown='lockKey()'>
		<form name='patient_cat_form' id='patient_cat_form'  action='../../servlet/eMP.PatientCatServlet' method='post' target='messageFrame'>
			<BR><BR><BR><BR><BR><BR><BR>
			<div align='center'>
				<table border='0' cellpadding='3' cellspacing='0' width='75%' align='center'>
				<tr>
				  <td width='25%'>&nbsp;</td>
				  <td width='50%'>&nbsp;</td>
				                   
				</tr>
					<tr>
						<td class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
						<td class='fields'><input type='text' size='4' maxlength='4' name='patient_cat_code' id='patient_cat_code' readonly value='<%=checkForNull(rset.getString("pat_cat_code"))%>'><img src='../images/mandatory.gif'></img>
						</td>
								
					</tr>
		<input type='hidden' name='job_type' id='job_type' value=''>

<%		
		if ( checkForNull(rset.getString("eff_status")).equals("E") )
		{
%>
		<tr>
			<td class='label' ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/> </td>
			<td class='fields'><input type='text' name='long_desc' id='long_desc' size='33' maxlength='30' onBlur='makeValidString(this)' value="<%=checkForNull(rset.getString( "long_desc" ))%>"><img src='../images/mandatory.gif'></img>
			</td>
		</tr>
		<tr>
			<td class='label' ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/> </td>
			<td class='fields'><input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' onBlur='makeValidString(this)' value="<%=checkForNull( rset.getString( "short_desc" ))%>"><img src='../images/mandatory.gif'></img>
			</td>
		</tr>
		 <tr>
			<td class='label'><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
			<td class='fields'><select name='job_type1' id='job_type1' >
	<%  String t1 = checkForNull(rset.getString("govt_or_pvt_ind"));
		  {
			  if (t1.equals("G")) select_g = "selected";
			  if (t1.equals("S")) select_sg = "selected";
			  if (t1.equals("R")) select_pn = "selected";
			  if (t1.equals("P")) select_p = "selected";
			  if (t1.equals("T")) select_st = "selected";
			  if (t1.equals("B")) select_rd = "selected";
			  if (t1.equals("C")) select_pc = "selected";
			  if (t1.equals("I")) select_pr = "selected";
			  if (t1.equals("W")) select_ew = "selected";
			  if (t1.equals("U")) select_e = "selected";
			  if (t1.equals("F")) select_f = "selected";
			  if (t1.equals("K")) select_k = "selected";
			  if (t1.equals("D")) select_d = "selected";
			  if (t1.equals("E")) select_se = "selected";
			  if (t1.equals("V")) select_ve = "selected";

		  }
%>
				<option value="D" <%=select_d%>><fmt:message key="eMP.DesignatedRoyalties.label" bundle="${mp_labels}"/>
				<option value="W" <%=select_ew%>><fmt:message key="eMP.EstateWorkers.label" bundle="${mp_labels}"/>
				<option value="F" <%=select_f%>><fmt:message key="eMP.Foreigner.label" bundle="${mp_labels}"/>
				<option value="G" <%=select_g%>><fmt:message key="Common.Government.label" bundle="${common_labels}"/>
				<option value="R" <%=select_pn%>><fmt:message key="eMP.Pensioner.label" bundle="${mp_labels}"/>
				<option value="C" <%=select_pc%>><fmt:message key="eMP.PersonUnderPoliceCustody.label" bundle="${mp_labels}"/>
				<option value="P" <%=select_p%>><fmt:message key="Common.Private.label" bundle="${common_labels}"/>
				<option value="I" <%=select_pr%>><fmt:message key="eMP.Prisoners.label" bundle="${mp_labels}"/>
				<option value="B" <%=select_rd%>><fmt:message key="eMP.RegisteredDisabled.label" bundle="${mp_labels}"/>
				<option value="E" <%=select_se%>><fmt:message key="eMP.SelfEmployed.label" bundle="${mp_labels}"/>
				<option value="S" <%=select_sg%>><fmt:message key="eMP.Semigovernment.label" bundle="${mp_labels}"/>
				<option value="T" <%=select_st%>><fmt:message key="eMP.Student.label" bundle="${mp_labels}"/>
				<option value="U" <%=select_e%>><fmt:message key="eMP.Unemployed.label" bundle="${mp_labels}"/>
				<option value="V" <%=select_ve%>><fmt:message key="Common.VIP.label" bundle="${common_labels}"/></option>
				<option value="K" <%=select_k%>><fmt:message key="Common.others.label" bundle="${common_labels}"/>
	        </select><img src='../images/mandatory.gif'></img>
		</td>
				
	</tr>
	<% EXP_VAL_APPL_YN = rset.getString("EXP_VAL_APPL_YN");
	  if (checkForNull(rset.getString("EXP_VAL_APPL_YN")).equals("Y") )	{%>
		<tr>
		  <td class='label'><fmt:message key="eMP.ExpiryApplicable.label" bundle="${mp_labels}"/></td>
		  <td class='fields'><input type='checkbox' <%=disabled_new%> name='expiry_appl' value='Y' checked onClick='mandate(this)'></td>
			
		</tr>
		   <%} else {%>
			<tr>
		  <td class='label'><fmt:message key="eMP.ExpiryApplicable.label" bundle="${mp_labels}"/></td>
		  <td class='fields'><input type='checkbox' name='expiry_appl' id='expiry_appl' <%=disabled_new%> value='N'  onClick='mandate(this)'></td>
			
		</tr>

			<%}String EXP_PERIOD_IN_DAYS = rset.getString("EXP_PERIOD_IN_DAYS");
		   if(EXP_PERIOD_IN_DAYS==null) EXP_PERIOD_IN_DAYS="";
		   %>
			<tr>
		<td class='label' ><fmt:message key="Common.ExpiryPeriod.label" bundle="${common_labels}"/></td>
		<td>
				<!--  -->
			<table border='0' cellpadding='0' cellspacing='0' width='75%' align='left'>
		  <tr>
			<td class='fields' width='15%'><input type='text' <%=disabled_new%> name='expiry_period' size='3' <%if (checkForNull(rset.getString("EXP_VAL_APPL_YN")).equals("N") )	{%>disabled <%}%> maxLength='3' onblur="chkdays(this);" onkeypress="return allowPositiveNumber()"  value='<%=EXP_PERIOD_IN_DAYS%>'></td>
				<td class='label' width='20%'><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
				   <td>
				<%if (checkForNull(rset.getString("EXP_VAL_APPL_YN")).equals("Y") )	{%><img id='expiry' src='../images/mandatory.gif'></img><%}else{%>
			 <img id='expiry' src='../images/mandatory.gif' style="visibility:hidden"></img>
			 <%}%>
			</td>
		   </tr>
		</table>
	</td>
			<!--  -->
		 

    </tr>
<%		/*  if( rset.getString("govt_or_pvt_ind").equals("P") )
			 out.println("<input type='hidden' name='job_type' id='job_type' value='P'>");
		  else
	          	 out.println("<input type='hidden' name='job_type' id='job_type' value='G'>");

		*/

	     /* out.println("<tr><td width='40%' class='label'>Effective From</td><td width='13%' >&nbsp;&nbsp;");*/
%>
	<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10'  value='<%=eff_date_from%>'>

<%      if ( rset.getDate("eff_date_from") != null ) {
			 java.util.Date date = rset.getDate("eff_date_from");
			 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
			 eff_date_from = formatter.format(date);
			 date = null;
			 formatter = null;
		  }
		  
	      /*out.println("</td><td width='47%' class='label'>&nbsp;&nbsp;To&nbsp;&nbsp;");*/
%>
          <input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'   value='<%=eff_date_to%>'>
<%      
			if ( rset.getDate("eff_date_to") != null){
				 java.util.Date date1 = rset.getDate("eff_date_to");
				 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
				 eff_date_to = formatter.format(date1);
				 date1 = null;
				 formatter = null;
			}

         /* out.println("</td></tr><tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr>");*/
%>
		  <tr>
			<td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='checkbox' name='eff_status' id='eff_status' value='E' checked></td>
					
		</tr>
		<tr>
			<td colspan=2>&nbsp;</td>
			  
		</tr>
	</table>
	</div>
	<input type='hidden' name='function' id='function' value='modify'>
	<input type='hidden' name='eff_date_from' id='eff_date_from' value=''>
	<input type='hidden' name='eff_date_to' id='eff_date_to' value=''>
	<input type='hidden' name='function_name' id='function_name' value='modify'>    
<%	}

	else if(rset.getString("eff_status").equals("D"))
	{ %>
		<tr>
		<td class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/> </td><td class='fields'><input type='text' name='long_desc' id='long_desc' size='33' maxlength='30' readonly value="<%=checkForNull(rset.getString("long_desc" ))%>"><img src='../images/mandatory.gif'></img>
		</td>
		</tr>
	  <tr>
		<td class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/> </td>
		<td class='fields'><input type='text' name='short_desc' id='short_desc' size='15' readonly value="<%=checkForNull(rset.getString( "short_desc" ))%>"><img src='../images/mandatory.gif'></img>
		</td>
	</tr>
	 <tr>
			 <td class='label'><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
			 <td class='fields'>
				<!-- <input type=text name='job_type1' id='job_type1'>  -->
<%
		  if( checkForNull(rset.getString("govt_or_pvt_ind")).equals("P") )
		  {
		      out.println("<input type=text name='job_type1' id='job_type1' value='Private' size='15' readonly ><img src='../images/mandatory.gif'></img>");
		  }
		  else if( checkForNull(rset.getString("govt_or_pvt_ind")).equals("K") )
		  {
		      out.println("<input type=text name='job_type1' id='job_type1' value='Others' size='15' readonly ><img src='../images/mandatory.gif'></img>");
		  }
		  else if( checkForNull(rset.getString("govt_or_pvt_ind")).equals("U") )
		  {
		      out.println("<input type=text name='job_type1' id='job_type1' value='Un-employed' size='15' readonly ><img src='../images/mandatory.gif'></img>");
		  }
		  else if( checkForNull(rset.getString("govt_or_pvt_ind")).equals("S") )
		  {
		      out.println("<input type=text name='job_type1' id='job_type1' value='Semi-Government' size='16' readonly ><img src='../images/mandatory.gif'></img>");
		  }
		  
		  else if( checkForNull(rset.getString("govt_or_pvt_ind")).equals("D") )
		  {
		      out.println("<input type=text name='job_type1' id='job_type1' value='Designated Royalties' size='23' readonly ><img src='../images/mandatory.gif'></img>");
		  }
		  else if( checkForNull(rset.getString("govt_or_pvt_ind")).equals("W") )
		  {
		      out.println("<input type=text name='job_type1' id='job_type1' value='Estate Workers' size='15' readonly ><img src='../images/mandatory.gif'></img>");
		  }

		  else if( checkForNull(rset.getString("govt_or_pvt_ind")).equals("F") )
		  {
		      out.println("<input type=text name='job_type1' id='job_type1' value='Foreigner' size='15' readonly ><img src='../images/mandatory.gif'></img>");
		  }
		  else if( checkForNull(rset.getString("govt_or_pvt_ind")).equals("R") )
		  {
		      out.println("<input type=text name='job_type1' id='job_type1' value='Pensioner' size='15' readonly ><img src='../images/mandatory.gif'></img>");
		  }

		  else if( checkForNull(rset.getString("govt_or_pvt_ind")).equals("I") )
		  {
		      out.println("<input type=text name='job_type1' id='job_type1' value='Prisoners' size='15' readonly ><img src='../images/mandatory.gif'></img>");
		  }

		  else if( checkForNull(rset.getString("govt_or_pvt_ind")).equals("C") )
		  {
		      out.println("<input type=text name='job_type1' id='job_type1' value='Person Under Police Custody' size='30' readonly ><img src='../images/mandatory.gif'></img>");
		  }

		  else if( checkForNull(rset.getString("govt_or_pvt_ind")).equals("B") )
		  {
		      out.println("<input type=text name='job_type1' id='job_type1' value='Registered Disabled' size='20' readonly ><img src='../images/mandatory.gif'></img>");
		  }
		  else if( checkForNull(rset.getString("govt_or_pvt_ind")).equals("E") )
		  {
		      out.println("<input type=text name='job_type1' id='job_type1' value='Self-Employed' size='20' readonly >&nbsp;<img src='../images/mandatory.gif'></img>");
		  }
		 else if( checkForNull(rset.getString("govt_or_pvt_ind")).equals("T") )
		  {
		      out.println("<input type=text name='job_type1' id='job_type1' value='Student' size='15' readonly >&nbsp;<img src='../images/mandatory.gif'></img>");
		  }
		  else 
		  {
		      out.println("<input type=text name='job_type1' id='job_type1' value='Government' size='15' readonly >&nbsp;<img src='../images/mandatory.gif'></img>");
		  }
%>      
		  </td>
	
	</tr>
	<!-- //newly added -->
</tr> 
			<% EXP_VAL_APPL_YN = rset.getString("EXP_VAL_APPL_YN");
		   if (checkForNull(rset.getString("EXP_VAL_APPL_YN")).equals("Y") )	{%>
 		<tr>
		  <td class='label'><fmt:message key="eMP.ExpiryApplicable.label" bundle="${mp_labels}"/></td>
		  <td class='fields'><input type='checkbox' <%=disabled_new%> name='expiry_appl' disabled value='Y' checked onClick='mandate(this)'></td>
		</tr>

		   <%} else {%>
			<tr>
		  <td class='label'><fmt:message key="eMP.ExpiryApplicable.label" bundle="${mp_labels}"/></td>
		  <td class='fields'><input type='checkbox' <%=disabled_new%> name='expiry_appl' disabled value='N'  onClick='mandate(this)'></td>
			
		</tr>

			<%}String EXP_PERIOD_IN_DAYS = rset.getString("EXP_PERIOD_IN_DAYS");
		   if(EXP_PERIOD_IN_DAYS==null) EXP_PERIOD_IN_DAYS="";	 %>
			<tr>
		<td  class='label' ><fmt:message key="Common.ExpiryPeriod.label" bundle="${common_labels}"/> </td>
		<td>
				<!--  -->
			<table border='0' cellpadding='0' cellspacing='0' width='75%' align='left'>
		  <tr>
			<td class='fields' width='15%'><input type='text' onblur="chkdays(this);" name='expiry_period' id='expiry_period' disabled size='3' maxLength='3' onkeypress="return allowPositiveNumber()"  value='<%=EXP_PERIOD_IN_DAYS%>'></td>
				<td class='label' width='20%'><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
				   <td>
				<%if (checkForNull(rset.getString("EXP_VAL_APPL_YN")).equals("Y") )	{%><img id='expiry' src='../images/mandatory.gif'></img><%}else{%>
			 <img id='expiry' src='../images/mandatory.gif' style="visibility:hidden"></img>
			 <%}%>
			</td>
		   </tr>
		</table>
	</td>
			<!--  -->
		 
			


    </tr>
<!--  -->
	<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10' readonly value= '<%=eff_date_from%>'>
	<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'   readonly value='<%=eff_date_to%>'>




	 <tr>
		<td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan='1'><input type='checkbox' name='eff_status' id='eff_status' value='E'>
		 </td>
	</tr> 
	<tr>
		<td >&nbsp;</td>
		<td colspan='1'>&nbsp;</td>
	</tr> 
</table>
</div>
<input type='hidden' name='function' id='function' value='modify'>
<input type='hidden' name='eff_date_from' id='eff_date_from' value=''>
<input type='hidden' name='eff_date_to' id='eff_date_to' value=''>
<input type='hidden' name='function_name' id='function_name' value='modify'>
<%	}
		//stmt				= conn.createStatement();
		//String sql1  = "select count(*)  from mp_pat_category where  govt_or_pvt_ind='K'";
		String sql1  = "select pat_cat_code,govt_or_pvt_ind  from mp_pat_category where  govt_or_pvt_ind='K'";
		rs = stmt.executeQuery(sql1) ;
			
		while(rs.next())
		{
		 UnknownCategory=rs.getString(1);
		 DBType=rs.getString(2);
		}
	}catch ( Exception e ) {
		out.println(e.toString());
		e.printStackTrace();
	}finally{
	  	if ( rset != null ) rset.close() ;
		if (rs!=null) rs.close();
		if (stmt!=null) stmt.close();		
		if ( pstmt != null ) pstmt.close() ;
		if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}
%>
<input type='hidden' name='UnknownCategory' id='UnknownCategory' value='<%=UnknownCategory%>'>
<input type='hidden' name='DBType' id='DBType' value='<%=DBType%>'>
</form>
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

