<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>

<%
//	String str=request.getParameter("function");
	Connection con =null;
//	String prefix_reqd="";
	String patcode="";
	String shortdesc="";
	PreparedStatement pstmt=null ;
	ResultSet reset=null;
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eMP/js/PatientNumberingDetail.js' language='javascript'>
	
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onKeyDown='lockKey();' OnLoad="Focusing('pat_ser_grp_code')">
<form name="patnumdetail_form" id="patnumdetail_form" action="../../servlet/eMP.PatientNumberingDetailServlet" method="post" target="messageFrame">

<BR><BR><BR>
<table border="0" cellpadding="0" cellspacing="0" width="90%" align='center'>
   <tr>
	<td class="NONE" width="100%">
		<table border='0' cellpadding='5' cellspacing='0' width='100%'>
		<tr><td colspan='3' class='label'>&nbsp;</td></tr>
			<tr>
			<!--td> </td-->
				<td class="label" width="40%" ><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/></td>
				<td width="60%" colspan="2" class="fields"  nowrap><select name='pat_ser_grp_code' id='pat_ser_grp_code' onChange="Pass2MsgFrm('forpatnum');" >
				<OPTION VALUE=''>---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
				<%
				try{
					con = ConnectionManager.getConnection(request);
					pstmt = con.prepareStatement("select pat_ser_grp_code,short_desc,scheme_id from mp_pat_ser_grp where ((gen_pat_id_yn='Y' and pat_no_ctrl in('Z','U')) or GEN_PID_USING_ALT_ID1_RULE_YN='Y') and associated_pat_ser_grp_code is null order by short_desc ");
						reset=pstmt.executeQuery();
						if( reset != null )
						{
						   while( reset.next() )
							{
								 patcode = reset.getString( "pat_ser_grp_code" ) ;
								 shortdesc=reset.getString("short_desc");
								
								%><OPTION VALUE='<%= patcode%>' ><%= shortdesc%></option>
								<%
							}
							
						}
													
						if (reset != null) reset.close();
						if (pstmt != null) pstmt.close();
					}catch(Exception e) { 
						//out.println(e.toString());
						e.printStackTrace(); // Added by lakshmanan for security issue ID 174185458 on 22-08-2023
						}
					finally
					{
						if(con!=null) ConnectionManager.returnConnection(con,request);
					}
			%>
				</select>
				<img src='../images/mandatory.gif'></img></td>
			<!--td> </td-->
			</tr>
				<!--td> </td-->
				<td class="label" width="40%" id='siteorfac' style='position:relative;' ><fmt:message key="eMP.SiteFacility.label" bundle="${mp_labels}"/></td>
				<td width="60%" colspan="2" class="fields" nowrap>
				<select name='site_or_facility_id' id='site_or_facility_id' onChange="Pass2MsgFrm('formrsect')"  >
				<OPTION VALUE=''>---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
				</select>
				<img src='../images/mandatory.gif' id='st'></img></td>
				<td> </td>
			</tr>
			<tr>
			      	<td width="40%" class="label" id='sno'><fmt:message key="eMP.SerialNumberStart.label" bundle="${mp_labels}"/></td>
			       <td  width="20%" class="fields" ><input type="text" name="start_srl_no" id="start_srl_no" size="15" maxlength="15" onBlur="CheckNum(this);chkgroup(this);" onKeyPress='return allowValidNumber(this,event,15,0)' readOnly><img src="../images/mandatory.gif"  id='st1'></img></td>
					<td width="10%" align="right" class="label" id="maxlabel"><fmt:message key="Common.Max.label" bundle="${common_labels}"/></td>
					<td width='40%' class="fields" ><input type="text" name="max_srl_no" id="max_srl_no" size="15" maxlength="15" onBlur="CheckNum(this);chkgroup(this);"  onKeyPress='return allowValidNumber(this,event,15,0)'  readOnly><img src="../images/mandatory.gif"  id='st2'></img></td>
			</tr>
			<tr id="mr_section_code_tr" >
				<td width="40%" class="label" ><fmt:message key="Common.MRSection.label" bundle="${common_labels}"  /></td>
				<td width="60%" colspan="2" class="fields" ><select name='mr_section_code' id='mr_section_code' nowrap >
				<OPTION VALUE=''>---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
				</select></td>
				<td> </td>
			</tr>

			<tr><td colspan='3' class='label'>&nbsp;</td></tr>
		</table>
	</td>
    </tr>
</table>

<input type="hidden" name="sStyle" id="sStyle" value="<%=sStyle%>">
<input type="hidden" name="site_or_facility" id="site_or_facility" value="">
<input type='hidden' name='separate_file_no_yn' id='separate_file_no_yn' value='N'>
<input type='hidden' name='used_status' id='used_status' value=''>
<input type="hidden" name="function" id="function" value="insert">
<input type="hidden" name="eff_date_from" id="eff_date_from" value=''>
<input type="hidden" name="eff_date_to" id="eff_date_to" value=''>
<input type='hidden' name='function_name' id='function_name' value='insert'>
<input type='hidden' name='pref_val' id='pref_val' value=''>

<input type='hidden' name='pat_no_ctrl' id='pat_no_ctrl' value=''>
<input type='hidden' name='result_value' id='result_value' value=''>
<input type='hidden' name='result_value_del' id='result_value_del' value=''>
<input type='hidden' name='readonly_flag' id='readonly_flag' value=''>

<input type='hidden' name='gen_pid_using_alt_id1_rule_yn' id='gen_pid_using_alt_id1_rule_yn' value=''>

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

