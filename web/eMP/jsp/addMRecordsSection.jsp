<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
    String facilityid = (String) session.getValue( "facility_id" ) ;
	Connection con    = null;
    PreparedStatement pstmt   = null;
	PreparedStatement pstmt1  = null;
    ResultSet rs3             = null;
    ResultSet rs              = null;
    ResultSet rs1             = null;
    
    String single_or_multi_file_ind = "";
   	String id_len                   = "";
	String tm_req                   = "";
	int pat_id_max_length = 0; //To set the size of "Serial Number Next" & "Max" by Meghanath.
	try {
		con = ConnectionManager.getConnection(request);
		pstmt1 = con.prepareStatement("Select terminal_digit_reqd_yn, to_char(patient_id_length) as patient_id_length from mp_param");
		rs3= pstmt1.executeQuery();
		if(rs3.next())
		{
			tm_req = rs3.getString(1);
			if(tm_req == null)tm_req = "N";
			id_len = rs3.getString(2);
		}
        if(!id_len.equals("")){
		pat_id_max_length  = Integer.parseInt(id_len);
		}
		pstmt              = con.prepareStatement("select single_or_multi_files_ind,separate_file_no_yn from mp_param_for_facility where facility_id='" + facilityid + "'");
	    rs = pstmt.executeQuery();
	    if(rs.next()) {
		    single_or_multi_file_ind = rs.getString("single_or_multi_files_ind")==null ? "S" : rs.getString("single_or_multi_files_ind");
	    }
	    else {
			try{
				if(pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement("select single_or_multi_files_ind,separate_file_no_yn from mp_param");
			    rs1 = pstmt.executeQuery();
			    if(rs1.next()) single_or_multi_file_ind = rs1.getString("single_or_multi_files_ind")==null ? "S" : rs1.getString("single_or_multi_files_ind");
			}catch(Exception e) { 
				e.printStackTrace();
				//out.println(e.toString());
				}
			finally
			{
				if (rs3 != null) rs3.close();
				if (rs1!=null) rs1.close();
				if(rs!=null) rs.close();
				if (pstmt != null) pstmt.close();
				if (pstmt1 != null) pstmt1.close();
			}
	    }
	}catch(Exception e) { 
		e.printStackTrace();
		//out.println(e.toString());
		}
	
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>

<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eMP/js/MRecordsSection.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</script>
</head>
<body  OnMouseDown="CodeArrest()" onKeyDown='lockKey();' onLoad="Focusing('section_code');javascript:setMaxLength('<%=pat_id_max_length%>')">
<form name="mr_section_form" id="mr_section_form" action="../../servlet/eMP.MRecordsSectionServlet" method="post" target="messageFrame">
<center>
<BR><BR>
	<table border="0" cellpadding="3" cellspacing="0" width="90%" align='center'>
	<tr>		
		<td></td>
		<td></td>
		<td width='10%' colspan='2'></td>
	</tr>
	<tr>
	 <td class="label" width="40%"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
	 <td width="60%" colspan="2" class="fields"><select name='facility' id='facility'>
	 <option value='' selected>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
	 <%
	   pstmt = con.prepareStatement("select facility_id,facility_name from sm_facility_param order by 2");
	  try
	  {
	  rs1 = pstmt.executeQuery();
	  if(rs1!=null)
	  {
		  while(rs1.next())
		  {
			String id=rs1.getString(1);
			String name = rs1.getString(2);
			if(id.equals(facilityid))
			  {
			%>
				<option value=<%=id%> selected><%=name%></option>
		  <%
			  }
			  else
			  {%>
				<option value=<%=id%> ><%=name%> </option> 
			<%	}
				}
			if(rs1!=null) rs1.close();
			if(pstmt!=null) pstmt.close();
	  }
	  }catch(Exception e){
		  e.printStackTrace();
		  // out.println(e);
		  }
	 finally
	 {
		if(con!=null) ConnectionManager.returnConnection(con,request); 
	 }
	  %>
	 </select><img src="../images/mandatory.gif"></img></td>
	 <td colspan='2'></td>
	</tr>
	<tr><td colspan='4'></td></tr>
	 <!-- </tr> -->
		<tr>			
		    <td class="label" width="40%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		    <td width="60%" colspan="2" class="fields"><input type="text" name="section_code" id="section_code" size="2" maxlength="2" onBlur="ChangeUpperCase(this);CodeLen(this)" onKeyPress="return CheckForSpecChars(event)"><img src="../images/mandatory.gif"></img></td>
			<td></td>
		</tr>
		<tr>
		<td colspan='4'>
		</td>
		</tr>
		<tr>			
			<td class="label" width="40%"><fmt:message key="Common.longname.label" bundle="${common_labels}"/></td>
			<td width="60%" colspan="2" class="fields"><input type="text" name="long_name" id="long_name" size="30" maxlength="30" onBlur="makeValidString(this);"><img src="../images/mandatory.gif"></img></td>
			<td></td>
		</tr>
		<tr >
		<td colspan='4'>
		</td>
		</tr>
		<tr>
			<!--td></td-->
			<td class="label" width="40%"><fmt:message key="Common.shortname.label" bundle="${common_labels}"/></td>
			<td width="60%" colspan="2" class="fields" ><input type="text" name="short_name" id="short_name" size="15" maxlength="15" onBlur="makeValidString(this);"><img src="../images/mandatory.gif"></img></td>
			<td></td>
		</tr>
		<tr >
		<td colspan='4'>
		</td>
		</tr>
		<tr>				
			<td class="label" width="40%"><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
			<td width="60%" colspan="2" class="fields"><select name="section_type1" id="section_type1">
			<%
				if(single_or_multi_file_ind.equals("S")) {
					out.println("<option value='C' Selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Central.label","common_labels")+"</option>");
				}
				else {
					out.println("<option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Central.label","common_labels")+"<option value='D' Selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Departmental.label","common_labels")+"</option>");
				}
			%>
			</select><img src="../images/mandatory.gif"></img></td>
		<td></td>
		</tr>
		<tr>
		<td colspan='4'>
		</td>
		</tr>
		<tr>
				<!--td></td-->
		    <td class="label" width="40%"><fmt:message key="eMP.PrefixRequired.label" bundle="${mp_labels}"/></td>
		    <td width="60%" colspan="2" class="fields"><input type="checkbox" name="prefix_req1" id="prefix_req1" value="Y" checked onClick="setMaxLength('<%=pat_id_max_length%>')"></td>
			<td></td>
		</tr>
	<!--tr>
		    <td class="label"  width="40%">Next Serial No</td>
		    <td width="60%" colspan="2"><input type="text" name="next_srl" id="next_srl" size="15" maxlength="15" onBlur="checkval('Max Serial No','Next Serial No',next_srl,max_srl);CheckNum(this)"><img src="/eCIS/mp/images/mandatory.gif"></img></td>
		</tr>
		<tr>
		    <td class="label"  width="40%">Max Serial No</td>
		    <td width="60%" colspan="2"><input type="text" name="max_srl" id="max_srl" size="15" maxlength="15" onBlur="checkval('Max Serial No','Next Serial No',next_srl,max_srl);CheckNum(this)"><img src="/eCIS/mp/images/mandatory.gif"></img></td>
		</tr-->


		
<tr >
		<td colspan='4'>
		</td>
		</tr>

<!--		<tr>
			<td width="40%"  class="label">Serial Number</td>
		      	<td width="60%" class="label" colspan="2"></td>
			<td></td>
	      	</tr> -->
			
		<tr>
		<td class="label" width="40%"><fmt:message key="eMP.SerialNumberNext.label" bundle="${mp_labels}"/></td>
		    <td  width="60%"  class="fields" colspan="2"><input type="text" name="next_srl" id="next_srl" size="15" maxlength="<%=pat_id_max_length%>" onkeypress="return allowValidNumber(this,event,15, 0);" onBlur="CheckNum(this)"><img src="../images/mandatory.gif"></img>&nbsp;<fmt:message key="Common.Max.label" bundle="${common_labels}"/>&nbsp;<input type="text" name="max_srl" id="max_srl" size="15" maxlength="<%=pat_id_max_length%>" onkeypress="return allowValidNumber(this,event,15, 0);"  onBlur="CheckNum(this)"><img src="../images/mandatory.gif"></img></td>
			 <!--onBlur= checkval('Max Serial No','Next Serial No',next_srl,max_srl);-->
			<td></td>
		</tr>

<tr >
		<td colspan='4'>
		</td>
		</tr>

		<!--tr><td> </td></tr-->

		<tr>
		    <!--td></td-->
		    <td class="label" width="41%"><fmt:message key="eMP.PromptforoldMRN.label" bundle="${mp_labels}"/></td>
		    <td width="59%" colspan="2" class="fields"><input type="checkbox" name="old_mrn1" id="old_mrn1" value="Y" checked></td>
			<td></td>
		</tr>
	<!--tr-->
			<!--td></td-->
		    <!--td class="label"  width="40%">Effective From</td>
		    <td  width="12%">--><input type="hidden" name="eff_date_from1" id="eff_date_from1" size="10"  maxlength="10"><!--/td-->
		    <!--td class="label" width="48%">To--><input type="hidden" name="eff_date_to1" id="eff_date_to1" size="10" maxlength="10"><!--/td-->
			<!--td></td-->
		<!--/tr-->

		<tr >
		<td colspan='4'>
		</td>
		</tr>
		<tr>
				<!--td></td-->
		    <td class="label" width="41%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		    <td width="59%" colspan="2" class="fields"><input type="checkbox" name="eff_status1" id="eff_status1" value="E" checked></td>
			<td></td>
		</tr>

				<tr >
		<td colspan='4'>
		</td>
		</tr>		
	</table>
</center>
<input type="hidden" name="function" id="function" value="insert">
<input type="hidden" name="eff_date_from" id="eff_date_from">
<input type="hidden" name="eff_date_to" id="eff_date_to">
<input type="hidden" name="single_or_multi_file_ind" id="single_or_multi_file_ind" value="<%=single_or_multi_file_ind%>">
<input type="hidden" name="prefix_req" id="prefix_req" value="N">
<input type="hidden" name="section_type" id="section_type" value="D">
<input type="hidden" name="old_mrn" id="old_mrn" value="N">
<input type="hidden" name="eff_status" id="eff_status" value="D">
<input type="hidden" name="patient_id_length" id="patient_id_length" value="<%=id_len%>">
<input type="hidden" name="terminal_reqd" id="terminal_reqd" value="<%=tm_req%>">
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

