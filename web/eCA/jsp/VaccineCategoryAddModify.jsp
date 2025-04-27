<%
/*
------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name        	Rev.Date 		Rev.by 					Description
------------------------------------------------------------------------------------------------------------------
23/02/2023     41650               Twinkle Shah    	               Ramesh Goli            MMS-JU-CRF-0015.1
12/04/2023     43370               Twinkle Shah    	14/04/2023     Ramesh Goli    CA-Immunization Code Setup-Vaccine Category
-------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/VaccineCategory.js'></script>
<%
    Connection con=null;
    PreparedStatement stmt=null;
    ResultSet rs=null;
    String mode="";
	String sql="";
	String status="";
	String vaccine_Category_id="";
	String vaccine_long_desc=""; 
	String vaccine_short_desc="";
	String allow_multiple_yn="N";
	String adhoc_yn="N";
	String ageSpecificYN = "N";
	String ageSpecificDisable = "";
	String isAdhocAgeSpecific = "";
	String adhoc_checked ="";
	String adhoc_disabled ="";
	String multiple_checked ="";
	String eff_status="";
	String age_group_code1="";
	String enabled_checked1="checked";
	
	mode		=(request.getParameter("mode")==null)?"":request.getParameter("mode");
	vaccine_Category_id		=(request.getParameter("vaccine_Category_id")==null)?"":request.getParameter("vaccine_Category_id");

	try
		{
		 con =	ConnectionManager.getConnection(request);
		if(mode.trim().equalsIgnoreCase("update"))
			{

			//sql ="select * from CA_IM_VAC_CATEG where VACC_CATEG_ID ='"+ vaccine_Category_id+ "'" ;//common-icn-0180
			sql ="select * from CA_IM_VAC_CATEG where VACC_CATEG_ID = ?" ;//common-icn-0180
			//String sql1 ="select count(*) from CA_IM_VAC_SCH_FOR_CATEG where VACC_CATEG_ID ='"+ vaccine_Category_id+ "'" ;//common-icn-0180
			String sql1 ="select count(*) from CA_IM_VAC_SCH_FOR_CATEG where VACC_CATEG_ID = ?" ;//common-icn-0180

			PreparedStatement pst = con.prepareStatement(sql1);
			pst.setString(1, vaccine_Category_id);//common-icn-0180
			ResultSet  rs1 = pst.executeQuery();

			

			stmt=con.prepareStatement(sql);
			stmt.setString(1, vaccine_Category_id);//common-icn-0180
			rs = stmt.executeQuery();
			if(rs.next())
				{
				 vaccine_Category_id		=(rs.getString("VACC_CATEG_ID")==null)?"":rs.getString("VACC_CATEG_ID");
				 vaccine_long_desc		=(rs.getString("LONG_DESC")==null)?"":rs.getString("LONG_DESC");
				
				 vaccine_short_desc		=(rs.getString("SHORT_DESC")==null)?"":rs.getString("SHORT_DESC");
				 
				 age_group_code1=(rs.getString("AGE_GROUP_CODE")== null)? "":rs.getString("AGE_GROUP_CODE");

				allow_multiple_yn=(rs.getString("ALLOW_MULTIPLE_YN")== null)? "":rs.getString("ALLOW_MULTIPLE_YN");

				adhoc_yn=(rs.getString("ADHOC_YN")== null)? "":rs.getString("ADHOC_YN");

				eff_status		=(rs.getString("EFF_STATUS")==null)?"":rs.getString("EFF_STATUS");

				ageSpecificYN		=(rs.getString("AGE_SPECIFIC_YN")==null)?"N":rs.getString("AGE_SPECIFIC_YN");

				if(ageSpecificYN.equals("Y")){
						isAdhocAgeSpecific = "checked";
				}
				else{
					isAdhocAgeSpecific = "";
				}



				if(eff_status.equals("E"))
						enabled_checked1="checked";
					else
					{
						enabled_checked1="";
						//dis1="disabled";
					}

                if(allow_multiple_yn.equals("Y"))
					multiple_checked="checked";
				else
				{
					multiple_checked="";
				
				}

				if(adhoc_yn.equals("Y"))
				{
					adhoc_checked="checked";
					ageSpecificDisable = "disabled";
				}
				else
				{
					adhoc_checked="";
					 ageSpecificDisable = "";				
				}
				
				 // start 43370 
			    if(ageSpecificYN.equals("Y") || adhoc_yn.equals("Y")){
				ageSpecificDisable = "disabled";
			    }
			    else{
				ageSpecificDisable = "";
			    }
				// end 43370 
			}

			if(rs!=null) { rs.close(); rs=null; }
			if(stmt!=null) { stmt.close(); stmt=null; }

			if (rs1.next())
			{
				if (rs1.getInt(1) > 0)
				{
					//ageSpecificYN = "Y";                  Commented for 43370
					//ageSpecificDisable = "disabled";    Commented for 43370  
					adhoc_disabled = "disabled";
					//adhoc_yn="N";                       Commented for 43370
					//multiple_checked = "N";     Commented for  43370
				}
			}
			if(rs1!=null) { rs1.close(); }
			if(pst!=null) { pst.close(); }

	}
		
}
catch(Exception e)
	{
		
		e.printStackTrace();
	}	
%>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()">
<form name="vaccine_category_form" id="vaccine_category_form" action="../../servlet/eCA.VaccineCategoryServlet" method="post" target="messageFrame">
<table border=0 cellspacing=0 cellpadding='3' width='75%' align=center>
<tr>
	<td class=label ><fmt:message key="eCA.CategoryId.label" bundle="${ca_labels}"/></td>
	<%if(mode.trim().equalsIgnoreCase("update")) {status="disabled" ;}else{status="";}%>
	<td colspan="2" class='fields' ><input type="text" name="vaccine_Category_id" id="vaccine_Category_id" value="<%=vaccine_Category_id%>" <%=status%>
	size=10 maxlength=10 onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" ><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
	<td class=label><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
	<td colspan="2" class='fields'><input type="text" name="vaccine_long_desc" id="vaccine_long_desc" value="<%=vaccine_long_desc%>"   size=60 maxlength=60 onBlur="makeValidString(this)" onkeypress='return CheckForSpecCharsNoCaps(event)'><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
	<td class=label><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
	<td colspan="2" class='fields'><input type="text" name="vaccine_short_desc" id="vaccine_short_desc" value="<%=vaccine_short_desc%>"   size=40 maxlength=40 onBlur="makeValidString(this)" onkeypress='return CheckForSpecCharsNoCaps(event)'><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
<td class=label ><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></td>
<td class='fields' colspan="2"><select name="age_group" id="age_group" onchange="fnModifyAgegroup(this,'<%=age_group_code1%>')">
<option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
	
	<%
	try
{
	
	String sqlpop1 = "select AGE_GROUP_CODE,SHORT_DESC from AM_AGE_GROUP where eff_status = 'E' order by 2";
    String age_group_code="";
	stmt= con.prepareStatement(sqlpop1);
	rs = stmt.executeQuery();
	while(rs!=null && rs.next())
	{
		age_group_code=rs.getString("AGE_GROUP_CODE");
		String select="";
		if(age_group_code1.equals(age_group_code)){
			select="selected";
		}

	
		out.println("<option value='"+age_group_code+"'"+select+">"+rs.getString("SHORT_DESC")+"</option>");
		
	}
	
	if(rs!=null)  rs.close(); 
	if(stmt!=null)  stmt.close();

}//try 

catch(Exception eg)
{
   eg.printStackTrace();
}
finally
	{
		if (con!= null)
		ConnectionManager.returnConnection(con,request);
	}
 
%>
</select></td>
</tr>
<tr>
	<td class=label ><fmt:message key="eCA.AllowMultiple.label" bundle="${ca_labels}"/></td>
	<td colspan="2" class='fields'><input type="checkbox" name="allow_multiple_yn" id="allow_multiple_yn" value="" <%=multiple_checked%> onclick='OnMultipleChange(this)' <%=ageSpecificDisable%>></td>
</tr>
<tr>
	<td class=label ><fmt:message key="Common.adhoc.label" bundle="${common_labels}"/></td>
	<td colspan="2" class='fields'><input  <%=adhoc_disabled%> type="checkbox" name="adhoc_yn" value="" <%=adhoc_checked%> onclick='OnAdhocChange(this)'>&nbsp;&nbsp;&nbsp;
	<fmt:message key="Common.age.label" bundle="${common_labels}"/>&nbsp;&nbsp;<fmt:message key="Common.specific.label" bundle="${common_labels}"/>
	&nbsp;&nbsp;&nbsp;
	<input type='checkbox' name='chkAdhocAgeSpecific' id='chkAdhocAgeSpecific' onclick='setAdhocAgeSpec(this)'  <%=isAdhocAgeSpecific%> <%=ageSpecificDisable%>></td>
</tr>
<tr>
	<td class=label ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td colspan="2" class='fields'><input type="checkbox" name="eff_status" id="eff_status" value='E' <%=enabled_checked1%>></td>
</tr>
<td class=label ></td>
</table>
<input type=hidden name="mode" id="mode" value="<%=mode%>">
<input type=hidden name="eff_status1" id="eff_status1" value="<%=eff_status%>">
<input type=hidden name='adh_yn' id='adh_yn' value=<%=adhoc_yn%>>
<input type=hidden name='ageSpecificYN' id='ageSpecificYN' value=<%=ageSpecificYN%>>
<input type=hidden name='multiple_yn' id='multiple_yn' value=<%=allow_multiple_yn%>>
<input type=hidden name="vaccine_Category_id_update" id="vaccine_Category_id_update" value="<%=vaccine_Category_id%>">
<input type=hidden name="beforeUpdateEff_status" id="beforeUpdateEff_status" value="<%=enabled_checked1%>">
</form>

<!-- start 41650 -->
<script type="text/javascript">
validateAgeSpecific();
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<!--end  41650 -->

</body>
</html>

