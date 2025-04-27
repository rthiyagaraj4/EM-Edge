<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eDR.*" %>
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

	<script language='javascript' src='../../eDR/js/ChangeIDSeries.js' ></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='message' onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>

<%
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

	String str					= "";
	String p_national_id_no		= "";
	String p_pat_ser_grp_code	= "";
	String p_regn_facility_id	= "";
	String p_gen_pat_id_yn		= "";
	String p_prefix_reqd_yn		= "";

	String p_patient_id	= request.getParameter("p_patient_id");
	String p_id_series  = request.getParameter("p_id_series");
	String p_id_series1	= request.getParameter("p_id_series1");
	String p_id_type    = request.getParameter("p_id_type");

	if(p_patient_id == null) p_patient_id = "";
	if(p_id_series == null) p_id_series = "";
	if(p_id_series1 == null) p_id_series1 = "";
	if(p_id_type == null) p_id_type = "";

	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		if(p_id_series.equals("N"))
		{
			str = "SELECT national_id_no,regn_facility_id FROM mp_patient WHERE patient_id= '"+p_patient_id+"' " ;
		}
		else if(p_id_series.equals("A"))
		{
			str = "SELECT alt_id1_no national_id_no,regn_facility_id FROM mp_patient WHERE patient_id= '"+p_patient_id+"' " ;
		}

		rs = stmt.executeQuery(str);
		while (rs.next())
		{
			p_national_id_no = rs.getString("national_id_no");
			p_regn_facility_id = rs.getString("regn_facility_id");
		} if(rs != null) rs.close();
		
		if(p_national_id_no == null) p_national_id_no = "";
		if(p_regn_facility_id == null) p_regn_facility_id = "";

		%>
		<script>
			var p_nat_id_no = '<%=p_national_id_no%>';

			if(p_nat_id_no.length == 0)
			{	
				parent.parent.frames[2].frames[1].document.getElementById('p_id_no').disabled = false;
			}
			else
			{
				parent.parent.frames[2].frames[1].document.getElementById('p_id_no').disabled = true;
				parent.parent.frames[2].frames[1].document.getElementById('p_id_no').value = '<%=p_national_id_no%>' ;
			}
		</script>
		<%

		str = "SELECT pat_ser_grp_code,gen_pat_id_yn,prefix_reqd_yn FROM mp_pat_ser_grp WHERE pat_ser_grp_code = '"+p_id_series1+"' " ;
		rs = stmt.executeQuery(str);
		while (rs.next())
		{
			p_pat_ser_grp_code = rs.getString("pat_ser_grp_code");
			p_gen_pat_id_yn    = rs.getString("gen_pat_id_yn");
			p_prefix_reqd_yn	= rs.getString("prefix_reqd_yn");
		}
	
		if(p_gen_pat_id_yn.equals("Y"))
		{
			%>
			<script>
			
				parent.parent.frames[2].frames[1].document.getElementById('p_id_no').value = '<%=p_national_id_no%>' ;
				parent.frames[1].document.getElementById('p_id_patient_id').vadocument.getElementById('')lue	= "";
				parent.frames[1].document.getElementById('p_id_patient_id')p_id_patient_id.disabled = true;
				parent.parent.frames[2].frames[1].document.getElementById('p_gen_pat_id_yn').value = '<%=p_gen_pat_id_yn%>' ;
			</script>
			<%
		}
		else
		{
			%>
			<script>
				parent.parent.frames[2].frames[1].document.getElementById('p_gen_pat_id_yn').value = '<%=p_gen_pat_id_yn%>' ;
				if("<%=p_prefix_reqd_yn%>"=='Y')
				{
					parent.frames[1].document.getElementById('p_id_patient_id').value =  "<%=p_pat_ser_grp_code%>";
				}
				else
				{
					parent.frames[1].document.forms[0].p_id_patient_id.value = "";
				}
				
				parent.frames[1].document.getElementById('p_pat_ser_grp_code').value = "<%=p_pat_ser_grp_code%>";
				parent.parent.frames[2].frames[1].document.getElementById('prefix_reqd_yn').value = "<%=p_prefix_reqd_yn%>";
				parent.frames[1].document.getElementById('p_id_patient_id').disabled = false;
				parent.frames[1].document.getElementById('p_id_patient_id').readonly = true;
				var errors = '' ;
			</script>
			<%
		}

		if(p_gen_pat_id_yn.equals("Y"))
		{
			%>
			<script>
				parent.parent.frames[2].frames[1].document.getElementById('p_gen_pat_id_yn').value = '<%=p_gen_pat_id_yn%>' ;
				parent.frames[1].document.getElementById('p_id_patient_id').value	= "";
				parent.frames[1].document.getElementById('p_id_patient_id').readonly = false;
				var errors = '';
			</script>
			<%
		}

		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
	}
	catch (Exception e)
	{
		out.println("Excveptuion e :"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html>

