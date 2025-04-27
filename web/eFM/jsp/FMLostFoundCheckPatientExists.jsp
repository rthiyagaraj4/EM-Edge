<!DOCTYPE html>
<!--

	Created On	: 6/21/2002
	Created By	: Nanda Kumar R.
	Module		: File Management (FM)
	Function	: File Lost / Found 
	
-->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eFM/js/FMLostFound.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='message' onKeyDown = 'lockKey()'>
<form>
<%
	Connection con			= ConnectionManager.getConnection(request);
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

	try
	{
		String p_new_string			= "";		
		String sql					= "";
		String p_curr_file_status	= "" ;

		String facilityid 		 = (String) session.getValue("facility_id");

		String p_enter_fcy		 = request.getParameter("p_enter_fcy");	
		String p_curr_location	 = request.getParameter("p_curr_location");
		String p_patient_file_no = request.getParameter("p_patient_file_no");

		int p_count	= 0;
		
		if(p_enter_fcy == null ||p_enter_fcy.equals("null") || p_enter_fcy.equals("")) 
		{
			p_enter_fcy = facilityid ;
		}
			
		stmt = con.createStatement();

		sql = "select count(a.file_no) rec_cnt from fm_curr_locn a where a.patient_id = '"+p_patient_file_no+"' and a.facility_id = '"+p_enter_fcy+"' and a.mr_pat_fs_locn_code = '"+p_curr_location+"' ";

		rs = stmt.executeQuery(sql);

		while(rs.next())
		{
			p_count = rs.getInt("rec_cnt");
		}
		if(rs!=null) rs.close();

		if(p_count > 0)
		{
			sql = " select file_no, curr_file_status from fm_curr_locn where patient_id = '"+p_patient_file_no+"' and curr_facility_id = '"+p_enter_fcy+"' ";

			rs = stmt.executeQuery(sql);

			String p_first_file_no = "";
			int p_rec_count	= 0;

			while(rs.next())
			{
				if(p_rec_count==0)
				{
					p_first_file_no			=	rs.getString("file_no");
					p_curr_file_status		=	rs.getString("curr_file_status");
				}
				p_new_string = p_new_string + "|" + rs.getString("file_no");
				p_rec_count++;
			}
			%>
			<script>
				if('<%=p_curr_file_status%>'=='T')
				{
					var errors = getMessage('FILE_IN_TRANSIT_CANNOT_PROCEED','FM');
					parent.frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
				}
				else
				{
					parent.frames[2].document.location.href='../../eFM/jsp/FMLostFoundRecordFrame.jsp?p_patient_file_no=<%=p_new_string%>';
					parent.frames[3].document.location.href='../../eFM/jsp/FMLostFoundChangeStatus.jsp?p_patient_file_no=<%=p_first_file_no%>';

					parent.frames[1].document.forms[0].p_patient_id.value='';
				}			
			</script>
			<%	
		}
		else
		{
			if(!p_patient_file_no.equals("null"))
			{
				%>
				<script>
					var errors = getMessage('PATIENT_FILE_NOT_EXIST','FM');
					parent.frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;	
				</script>
				<%
			}
		}

		if(stmt!=null) stmt.close();
		if(rs!=null) rs.close();	
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e);
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	%>
	</form>
</body>
</html>

