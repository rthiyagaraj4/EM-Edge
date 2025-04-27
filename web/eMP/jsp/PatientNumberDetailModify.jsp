<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.* ,javax.servlet.*,javax.servlet.http.*,webbeans.eCommon.* , eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<%
	String pat_ser_grp_code=request.getParameter("pat_ser_grp_code");

	

	String site_or_facility_id=(request.getParameter("site_or_facility_id")==null?"":request.getParameter("site_or_facility_id"));
	String record_srl_no=(request.getParameter("record_srl_no")==null?"":request.getParameter("record_srl_no"));
	if(record_srl_no == null) record_srl_no="";
	//String record_srl_no=(request.getParameter("record_srl_no")==null?"":request.getParameter("record_srl_no"));
	String site_or_facility=null;
	String create_file = "";
	String create_file_chk = "";
	Connection con=null ;
	con = ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null ;
	PreparedStatement pstmt1=null ;

	String pat_ser_grp_code1=pat_ser_grp_code;
	
	ResultSet rs = null;
	ResultSet rset=null ;
	ResultSet rset1=null ;
	ResultSet rs2=null ;
	String facdesc="";
	String pat_id_len = "";
	String max_srl_no = "";
	String start_srl_no = "";


	String patdesc="";
	String patctrl="";
    String gen_pid_using_alt_id1_rule_yn="";
	try{
	String des="select short_desc,pat_no_ctrl,gen_pid_using_alt_id1_rule_yn from mp_pat_ser_grp where pat_ser_grp_code=?";
	pstmt = con.prepareStatement(des);
	pstmt.setString(1, pat_ser_grp_code);
	rs=pstmt.executeQuery();
	if(rs!=null)
	{
	rs.next();
	patdesc=rs.getString("short_desc");
	patctrl=rs.getString("pat_no_ctrl");
	gen_pid_using_alt_id1_rule_yn=rs.getString("gen_pid_using_alt_id1_rule_yn");
/*	}catch(Exception e) { out.println(e.toString());}
	finally
	{
		if (pstmt != null) pstmt.close();
		if (rs != null) rs.close();
	}*/

	String faclab="";
		
	if(patctrl.trim().equals("U")||patctrl.trim().equals("C"))
	{

//		try{
			faclab="Facility";
			des="select facility_name from sm_facility_param where facility_id =?";
			if (pstmt != null) pstmt.close();
			if (rs != null) rs.close();
			pstmt=con.prepareStatement(des);
			pstmt.setString(1, site_or_facility_id);
			rs=pstmt.executeQuery();
			if(rs!=null && rs.next())
				facdesc=rs.getString("facility_name");
/*		}catch(Exception e) { out.println(e.toString());}
		finally
		{
			if (pstmt != null) pstmt.close();
			if (rs != null) rs.close();
		}*/

	}
	else if(patctrl.trim().equals("Z"))
	{
//		try{
			faclab="Site";
			des="select site_name from sm_site_param where site_id =?";
			if (pstmt != null) pstmt.close();
			if (rs != null) rs.close();
			pstmt = con.prepareStatement(des);
			pstmt.setString(1, site_or_facility_id);
			rs=pstmt.executeQuery();
			if(rs!=null && rs.next())
			  facdesc=rs.getString("site_name");
/*		}catch(Exception e) { out.println(e.toString());}
		finally
		{
			if (pstmt != null) pstmt.close();
			if (rs != null) rs.close();
		}*/

	}
	else
		{
		facdesc="";
		record_srl_no="";
		//site_or_facility_id="";
		}

	
//try{
	
	
	String mrsection="";
	String sql="select * from mp_pat_ser_facility where pat_ser_grp_code=? and site_or_facility_id=? and record_srl_no=? ";
	if (pstmt != null) pstmt.close();
	if (rs != null) rs.close();
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1, pat_ser_grp_code);
	pstmt.setString(2, site_or_facility_id);
	pstmt.setString(3, record_srl_no);
	rset = pstmt.executeQuery();
	
	if(rset !=null && rset.next())
	{
	mrsection=(rset.getString("mr_section_code")==null?"":rset.getString("mr_section_code"));
	site_or_facility=(rset.getString("site_or_facility")==null?"":rset.getString("site_or_facility"));
	//if(site_or_facility==null)site_or_facility="";
	create_file = rset.getString("create_file_at_regn_yn");
	if (create_file==null) create_file = "";
	if (create_file != null && create_file.equals("Y")) create_file_chk = "checked";
	else create_file_chk = "";

	start_srl_no = rset.getString("start_srl_no")==null?"":rset.getString("start_srl_no");
	max_srl_no = rset.getString("max_srl_no")==null?"":rset.getString("max_srl_no");
	}
	
	
	//added by sen on 2/07/2004
	try
	{
	String strsql = "Select PATIENT_ID_LENGTH from mp_param";
	if(pstmt1!=null)pstmt1.close();
	if(rset1!=null)rset1.close();
	pstmt1 = con.prepareStatement(strsql);
	rset1 = pstmt1.executeQuery();
	if(rset1!=null && rset1.next())
		{
			pat_id_len = rset1.getString("PATIENT_ID_LENGTH")==null?"":rset1.getString("PATIENT_ID_LENGTH");
		}
	}
	catch(Exception e)
	{
	}
	//addition ends
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eMP/js/PatientNumberingDetail.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<script>

	function checkval(val,val2)
	{
		var nam=parseInt(val,10);
		var nam1=parseInt(val2,10);

		if (nam>=nam1)
		{
			var msg = getMessage('CANNOT_GREATER','MP');
			msg = msg.replace('#',getLabel('Common.maxserialno.label','common') );
			msg = msg.replace('$',getLabel('Common.nextsrlno.label','common') );
			alert(msg);
			document.patientnumbering_form.max_srl_no1.focus();
		}

	}
function CheckMrn(){

			if(document.patnumdetail_form.mr_section_code.value != null)
			{

				document.patnumdetail_form.create_file_at_regn_yn.disabled= false;

			}
			if(document.patnumdetail_form.mr_section_code.value == "")
			{

				document.patnumdetail_form.create_file_at_regn_yn.disabled= true;

			}
}
</script>
</head>
<body  onload='loadpage()' OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="patnumdetail_form" id="patnumdetail_form" action="../../servlet/eMP.PatientNumberingDetailServlet" method="post" target="messageFrame">
<br><br><br>
<table border="0" cellpadding="0" cellspacing="0" width="90%" align='center'><!--98%-->
   <tr>
	<td class="NONE" width="100%">
		<table border='0' cellpadding='5' cellspacing='0' width='100%'>

			<tr>
				<td>&nbsp; </td>
				<td>&nbsp; </td>
				<td width='10%'>&nbsp; </td>
			</tr>

			<tr>

				<td class="label" width="40%"><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/></td>

				<td width="60%" class='fields' colspan="2" nowrap><select name='pat_ser_grp_code1' id='pat_ser_grp_code1' disabled>

				<OPTION VALUE='<%= pat_ser_grp_code %>' ><%= patdesc %>

				<%
				out.println("<input type='hidden' name='pat_ser_grp_code' id='pat_ser_grp_code' value='"+pat_ser_grp_code+"'>");

				%>

				</select>
				</td>
				<td>&nbsp; </td>

			</tr>
			<tr>
				<%
				
				if(!(site_or_facility_id.equals("")))
				{



				out.println("<td class='label' width='40%'>"+faclab+"</td>");
				%>
				<td width="60%" class='fields'  colspan="2" nowrap>
				<select name='site_or_facility_id1' id='site_or_facility_id1' disabled>

				<OPTION VALUE='<%= site_or_facility_id %>' ><%= facdesc %>

				</select>
				<%
					out.println("<input type='hidden' name='site_or_facility_id' id='site_or_facility_id' value='"+site_or_facility_id+"'>");

				%>

			
				</td>
			<td>&nbsp; </td>
			</tr>
			<!-- <tr>
				<td width="40%" class="label">Serial Number</td>
		       	<td width="60%" class="label" colspan="2">&nbsp;</td>
	      	    <td>&nbsp; </td>
			</tr>
			 -->
			<tr>
			      	<td width="40%" class="label" nowrap><fmt:message key="eMP.SerialNumberStart.label" bundle="${mp_labels}"/></td>
			
					<td class='fields' width='20%'><input type='text' name='start_srl_no' id='start_srl_no' size='<%=pat_id_len%>' maxlength='<%=pat_id_len%>' value='<%=start_srl_no%>' readonly></td>

			
			<!--/tr>

			<tr-->
			      	<td width="5%"  class="label"><fmt:message key="Common.Max.label" bundle="${common_labels}"/></td>
			
					<td class='fields' width='40%'><input type='text' name='max_srl_no' id='max_srl_no' size='<%=pat_id_len%>' maxlength='<%=pat_id_len%>' value='<%=max_srl_no%>' readonly></td>
			
				<td>&nbsp; </td>

			</tr>
			<%
		if(patctrl.trim().equals("U"))
		{
		%>
		<tr>
				<td width="40%"  class="label"><fmt:message key="Common.MRSection.label" bundle="${common_labels}"/></td>
				<td width="60%" class='fields'  colspan="2" nowrap><select name="mr_section_code" id="mr_section_code" >
				<OPTION VALUE=''> ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- </Option>

			<%
				
		
//			try{
				String sql1="select mr_section_code,short_name from mr_section where facility_id=? and mr_section_type ='C' and  eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by short_name ";
				
				String sectioncode="";
				String shortname ="";
				//String sql1="select mr_section_code,short_name from mr_section where facility_id='"+site_or_facility_id+"' and mr_section_type='C'";

				//String sql1="select mr_section_code,short_name from mr_section where facility_id='"+facilityId +"'and mr_section_type='C'";
				if (pstmt != null) pstmt.close();
				if (rs != null) rs.close();
				pstmt = con.prepareStatement(sql1);
				pstmt.setString(1, site_or_facility_id);
				rs = pstmt.executeQuery();

				//if( rs != null )
				
					 while( rs.next() )
				    {
					 sectioncode = rs.getString( "mr_section_code" ) ;
					 shortname = rs.getString( "short_name" ) ;

					if ( sectioncode.equals( mrsection ) )
						out.println( "<option selected value='" + sectioncode + "' >" + shortname );
					else
						out.println( "<option  value='" + sectioncode + "' >" + shortname );

				    }
				 
	/*	}catch(Exception e) { out.println(e.toString());}
		finally
		{
			if (pstmt != null) pstmt.close();
			if (rs != null) rs.close();
		} */

		}else
		{ %>
			<input type='hidden' name='mr_section_code' id='mr_section_code' value=''>
		<%
		}
		}
		else
			out.println("<input type='hidden' name='site_or_facility_id' id='site_or_facility_id' value='"+site_or_facility_id+"'>");
		

		%>
		<!--	<tr>
					<td width= "40%" class="label">Create MRN at Regn</td>

					<td width ='60%' class='label' colspan='2'>&nbsp;&nbsp;<input type='checkbox' name='create_file_at_regn_yn' id='create_file_at_regn_yn' value=""<%=create_file_chk%>></td>
			<td>&nbsp; </td>
			</tr>
               -->
			<tr>
				<td>&nbsp; </td>
				<td>&nbsp; </td>
				<td>&nbsp; </td>
			</tr>

		</table>
	</td>
    </tr>
</table>	
<input type='hidden' name='pat_no_ctrl' id='pat_no_ctrl' value='<%=patctrl%>'>
<input type='hidden' name='pat_ser_grp_code_hid' id='pat_ser_grp_code_hid' value='<%=pat_ser_grp_code1%>'>


<%
}
	}catch(Exception e) { 
		//out.println(e.toString());
		e.printStackTrace(); // Added by lakshmanan for security issue ID 174181075 on 22-08-2023	
	}
			finally
			{	
				if(rs!=null) rs.close();
				if(rs2!=null) rs2.close();
				if (pstmt != null) pstmt.close();
				if (pstmt1 != null) pstmt1.close();
				if (rset != null) rset.close();
				if (rset1 != null) rset1.close();
				if(con!=null) ConnectionManager.returnConnection(con,request);
			}
%>


<input type="hidden" name="record_srl_no" id="record_srl_no" value="<%=record_srl_no%>">
<input type="hidden" name="function" id="function" value="modify">
<input type="hidden" name="separate_file_no_yn" id="separate_file_no_yn" value="N">
<input type="hidden" name="site_or_facility" id="site_or_facility" value="<%=site_or_facility%>">
<input type="hidden" name="eff_date_from" id="eff_date_from" value=''>
<input type="hidden" name="eff_date_to" id="eff_date_to" value=''>
<input type='hidden' name='function_name' id='function_name' value='modify'>
<input type='hidden' name='used_status' id='used_status' value=''>


<input type='hidden' name='result_value' id='result_value' value=''>
<input type='hidden' name='result_value_del' id='result_value_del' value=''>
<input type='hidden' name='readonly_flag' id='readonly_flag' value=''>
<input type='hidden' name='gen_pid_using_alt_id1_rule_yn' id='gen_pid_using_alt_id1_rule_yn' value='<%=gen_pid_using_alt_id1_rule_yn%>'>


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


