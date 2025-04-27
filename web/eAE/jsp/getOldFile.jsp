<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript'>
	function doInit()
	{
		document.getElementById("gen_file_no").value = window.dialogArguments;
		document.getElementById("old_file_no").focus();
	}
	function doClose()	
	{
		window.returnValue = document.getElementById("old_file_no").value+"|"+document.getElementById("fs_locn_code").value;
		window.close();
	}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title> <fmt:message key="eMP.MedicalRecordNumber.label" bundle="${mp_labels}"/></title>
<%
		request.setCharacterEncoding("UTF-8");
		Connection con						= null;
    	PreparedStatement pstmt				= null;
        ResultSet rset						= null ;
    	PreparedStatement fmStrLocnPstmt	= null;
        ResultSet fmStrLocnRset				= null ;
		Statement stmt						= null;
		boolean one_record = false;
		String dflt_fs_locn_code= "";
		String fs_locn_code		= "";
		String op_fs_locn_code	= "";
		String facilityId		= (String)session.getValue("facility_id");
		String location_code	= request.getParameter("location_code");
		String central_dept		= request.getParameter("central_dept");

		String sqlfm_param = "select dflt_fs_locn_code from fm_parameter where facility_id =?";

		try{
			con = ConnectionManager.getConnection(request);
		    pstmt = con.prepareStatement(sqlfm_param);
			pstmt.setString(1,facilityId);
			rset = pstmt.executeQuery();
		   while(rset!=null && rset.next())
		   {
				dflt_fs_locn_code = rset.getString(1);
		   }
		   if(pstmt!=null) pstmt.close();
		   if(rset!=null) rset.close();

		    pstmt = con.prepareStatement("select count(*) cnt from fm_storage_locn where locn_identity = 'D' and facility_id = ?");
			pstmt.setString(1,facilityId);
			rset = pstmt.executeQuery();
		   while(rset!=null && rset.next())
		   {
				if( rset.getInt(1) == 1) one_record = true;
		   }
		   if(pstmt!=null) pstmt.close();
		   if(rset!=null) rset.close();

			fmStrLocnPstmt = con.prepareStatement("select fs_locn_code,short_desc from fm_storage_locn where locn_identity = 'D' and facility_id = ?");
			fmStrLocnPstmt.setString(1,facilityId);
			fmStrLocnRset = fmStrLocnPstmt.executeQuery();
%>
</head>
	<body onload='doInit()' style='background-color:#E2E3F0;' onKeyDown = 'lockKey()'>
		<table width='100%' border='0' cellspacing='0' cellpadding='0' align=center>
		<tr>
			<td width='50%'>&nbsp;</td>
			<td width='50%'>&nbsp;</td>
		</tr>
		<tr>
			<td align='right' class='label' width='50%'><fmt:message key="eMP.GeneratedFileNo.label" bundle="${mp_labels}"/></td>
			<td align='left' width='50%'>&nbsp;&nbsp;<input type='text' name='gen_file_no' id='gen_file_no' size='15' maxlength='15' readOnly></input></td>
		</tr>
		<tr>
			<td align='right' class='label' width='50%'><fmt:message key="eMP.OldFileNo.label" bundle="${mp_labels}"/></td>
			<td align='left' width='50%'>&nbsp;&nbsp;<input type='text' name='old_file_no' id='old_file_no' size='15' value=''  maxlength='15'></input></td>
		</tr>
<%
			boolean once = true;
			boolean proceed_for_dept = false;
			if(central_dept.equals("D")){
				pstmt = con.prepareStatement("select mr_location_code from op_clinic where clinic_code=? and FACILITY_ID=?");
				pstmt.setString(1,location_code);
				pstmt.setString(2,facilityId);
				rset = pstmt.executeQuery();
				while(rset!=null && rset.next())
				{
					op_fs_locn_code = rset.getString("mr_location_code");
					if(op_fs_locn_code == null || op_fs_locn_code.equals("")) op_fs_locn_code="";
				}
				if(pstmt!=null) pstmt.close();
				if(rset!=null) rset.close();
				if(!op_fs_locn_code.equals(""))
					out.println("<input type='hidden' name='fs_locn_code' id='fs_locn_code' value='"+fs_locn_code+"'>");
				else {
					proceed_for_dept = true;
				}
			}
			if(central_dept.equals("C") || proceed_for_dept){
				while(fmStrLocnRset!=null && fmStrLocnRset.next()) {
					if(one_record) {
						fs_locn_code = fmStrLocnRset.getString("fs_locn_code");
						out.println("<input type='hidden' name='fs_locn_code' id='fs_locn_code' value='"+fs_locn_code+"'>");
						break;
					}
					else{
						if(once) { 
							once=false;
%>
							<tr>
								<td align='right' class='label' width='50%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/> </td>
								<td align='left' width='50%'>&nbsp;
									<select name='fs_locn_code' id='fs_locn_code' >
										<option value='' > ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----</option>
<%
						}
						String l_fs_locn_code = fmStrLocnRset.getString("fs_locn_code");
						String l_fs_locn_desc = fmStrLocnRset.getString("short_desc");
						if(l_fs_locn_code.equals(dflt_fs_locn_code))
							out.println("<option value='"+l_fs_locn_code+"' SELECTED> "+l_fs_locn_desc+" </option>");
						else
							out.println("<option value='"+l_fs_locn_code+"'> "+l_fs_locn_desc+" </option>");
					}
			   }
			   if(!one_record) out.println("</select>");
		   }

%>
		</tr>
	  </table>
	 <br><br>
	<center><input type='Button' class='Button' name='Ok' id='Ok' value='    OK    ' onclick='doClose()'></center>
	<%
		 }
	    catch(Exception e)
		{
			e.printStackTrace();
	    }
		finally
		{
			if(pstmt!=null)  pstmt.close();
			if(rset!=null)  rset.close();
			if(stmt != null) stmt.close();
			if(fmStrLocnPstmt != null) fmStrLocnPstmt.close();
			if(fmStrLocnRset != null) fmStrLocnRset.close();
			ConnectionManager.returnConnection(con,request);
		}	
	%>
</body>
</html>

