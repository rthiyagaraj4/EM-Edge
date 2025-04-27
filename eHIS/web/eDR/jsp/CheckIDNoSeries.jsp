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
	<script language='javascript' src='../../eDR/js/DuplicateRecord.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='message'  onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<%
	Connection con			= null; 
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;
	ResultSet rst			= null;

	String str								= "";
	
	String p_gen_pat_id_yn					= "";
	String nat_id_chk_len					= "";
	String alt_id_chk_len					= "";
	String nat_id_chk_digit_scheme			= "";
	String alt_id_chk_digit_scheme			= "";
	String alt_id1_accept_alphanumeric_yn	= "";
	String result = "TRUE";
	
	int alt_id_length = 0;
	int nat_id_length = 0;

	String p_patient_id				= request.getParameter("p_patient_id");
	String p_id_series1				= request.getParameter("p_id_series1");
	String p_id_series				= request.getParameter("p_id_series");
	String p_id_no					= request.getParameter("p_id_no");
	String alt_id1_unique_yn		= request.getParameter("alt_id1_unique_yn");
	nat_id_chk_len					= request.getParameter("nat_id_chk_len");
	nat_id_chk_digit_scheme			= request.getParameter("nat_id_chk_digit_scheme");
	alt_id_chk_digit_scheme			= request.getParameter("alt_id_chk_digit_scheme");
	alt_id_chk_len					= request.getParameter("alt_id_chk_len");
	alt_id1_accept_alphanumeric_yn	= request.getParameter("alt_id1_accept_alphnum_yn");
	String p_nat_length				= request.getParameter("nat_length");
	String p_alt_length				= request.getParameter("alt_length");

	if(p_nat_length == null) alt_id1_unique_yn = "0";		
	if(p_alt_length == null) alt_id1_unique_yn = "0";

	nat_id_length = Integer.parseInt(p_nat_length);
	alt_id_length = Integer.parseInt(p_alt_length);

	if(p_patient_id == null) p_patient_id = "";
	if(p_id_series1 == null) p_id_series1 = "";
	if(p_id_series == null) p_id_series = "";
	if(p_id_no == null) p_id_no = "";
	if(alt_id1_unique_yn == null) alt_id1_unique_yn = "";	

	if(alt_id_chk_digit_scheme == null) alt_id_chk_digit_scheme = "";
	if(nat_id_chk_len == null) nat_id_chk_len = "N";
	if(nat_id_chk_digit_scheme == null) nat_id_chk_digit_scheme = "";
	if(alt_id_chk_len == null) alt_id_chk_len = "N";
	if(nat_id_chk_digit_scheme == null) nat_id_chk_digit_scheme = "";
	if(alt_id1_accept_alphanumeric_yn == null) alt_id1_accept_alphanumeric_yn = "N";
	
	boolean continue_yn = true;

	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		if(p_id_series.equals("N"))
		{
			str = "SELECT count(1) total_records FROM mp_patient WHERE national_id_no = '"+p_id_no+"' " ;
		}
		else if(p_id_series.equals("A") && alt_id1_unique_yn.equals("Y"))
		{
			str = "SELECT count(1) total_records FROM mp_patient WHERE alt_id1_no = '"+p_id_no+"' " ;
		}

		int maxrecord = 0;

		if(p_id_series.equals("N") || (p_id_series.equals("A") && alt_id1_unique_yn.equals("Y")))
		{
			rs = stmt.executeQuery(str);
			while (rs.next())
			{
				maxrecord = rs.getInt("total_records");
			}
		}
		if(maxrecord > 0)
		{
			%>
			<script>
				var errors = getMessage("DUPLICATE_ID_NO","DR") ;
				parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+errors;	
				//parent.frames[1].document.forms[0].p_id_no.select();
				parent.frames[1].document.getElementById('p_id_no').select();
				parent.frames[1].document.getElementById('p_id_no').focus();
			</script>
			<%
		}
		else
		{
			/*str = "SELECT nat_id_length, nvl(nat_id_chk_len,'N') nat_id_chk_len, nat_id_chk_digit_scheme, alt_id1_length, alt_id1_len_validation_yn, alt_id1_chk_digit_scheme, alt_id1_accept_alphanumeric_yn FROM mp_param";
			rs = stmt.executeQuery(str);

			if(rs.next())
			{
				nat_id_length					= rs.getInt(1);
				nat_id_chk_len					= rs.getString(2);
				nat_id_chk_digit_scheme			= rs.getString(3);
				alt_id_length					= rs.getInt(4);
				alt_id_chk_len					= rs.getString(5);
				alt_id_chk_digit_scheme			= rs.getString(6);
				alt_id1_accept_alphanumeric_yn	= rs.getString(7);

				if(nat_id_chk_len == null) nat_id_chk_len = "N";
					
				if(nat_id_chk_digit_scheme == null) nat_id_chk_digit_scheme = "";
				if(alt_id_chk_len == null) alt_id_chk_len = "N";
				if(alt_id_chk_digit_scheme == null) alt_id_chk_digit_scheme = "";
				if(alt_id1_accept_alphanumeric_yn == null) alt_id1_accept_alphanumeric_yn = "N";
			} if(rs != null) rs.close();*/

			if(p_id_series.equals("N"))
			{
				if(nat_id_chk_len.equals("Y"))
				{
					if(p_id_no.length() != nat_id_length)
					{
						continue_yn = false;
						%>
						<script>
							var val = getMessage("NAT_ID_CHARS","MP");
			                val = val.replace("@","<%=nat_id_length%>")
							val = val.replace("#",getLabel("eDR.IDNo.label","DR"))								
							parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+val;	
							parent.frames[1].document.getElementById('p_id_no').select();
							parent.frames[1].document.getElementById('p_id_no').focus();
						</script>
						<%
					  }
					}
					if(nat_id_chk_digit_scheme != null)
					{
						str = "SELECT program_name FROM mp_check_digit_scheme WHERE scheme_id = '"+nat_id_chk_digit_scheme+"'" ;
						rs = stmt.executeQuery(str);
						if(rs.next())
						{
							nat_id_chk_digit_scheme = rs.getString(1);
							
							str = "SELECT "+nat_id_chk_digit_scheme+"('"+p_id_no+"') FROM dual";
							rst = stmt.executeQuery(str);
							if(rst.next())
							{
								result = rst.getString(1);
							} if(rst != null)  rst.close();

						} if(rs != null) rs.close();

						if(!result.equals("TRUE")) 
					    {
							continue_yn = false;
							%>
							<script>
								var val = getMessage("INVALID_NAT_ID","MP");
								val = val.replace("#",getLabel("eDR.IDNo.label","DR"))
								parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+val;	
								parent.frames[1].document.getElementById('p_id_no').select();
								parent.frames[1].document.getElementById('p_id_no').focus();
							</script>
							<%
						}
					}
				}
				else if(p_id_series.equals("A"))
				{
					if(alt_id_chk_len.equals("Y"))
					{
						if(p_id_no.length() != alt_id_length)
						{	
							continue_yn = false;
							%>
							<script>
								var val = getMessage("ALT_ID_CHARS","MP");
								val = val.replace("$",getLabel("Common.identification.label","Common"))
								val = val.replace("@","<%=alt_id_length%>");
								parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+val;	
								parent.frames[1].document.getElementById('p_id_no').select();
								parent.frames[1].document.getElementById('p_id_no').focus();
							</script>
							<%
						}
					}
					if(alt_id1_accept_alphanumeric_yn.equals("N"))
					{ 
						%>
						<script>
							if(isNaN(parent.frames[1].document.forms[0].p_id_no.value))
							{														
								var chk_dig_mes = getMessage("ALT_ID_NO","MP");
								chk_dig_mes		= chk_dig_mes.replace('$',getLabel("eDR.IDNo.label","DR"));
								parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+chk_dig_mes;	
								parent.frames[1].document.getElementById('p_id_no').select();
								parent.frames[1].document.getElementById('p_id_no').focus();
							}
						</script>
						<%
					}
					if(alt_id_chk_digit_scheme != null)
					{
						str = "SELECT program_name FROM mp_check_digit_scheme WHERE scheme_id = '"+alt_id_chk_digit_scheme+"'" ;
						rs = stmt.executeQuery(str);
						if(rs.next())
						{
							alt_id_chk_digit_scheme = rs.getString(1);
							
							str = "SELECT "+alt_id_chk_digit_scheme+"('"+p_id_no+"') FROM dual";
							rst = stmt.executeQuery(str);
							if(rst.next())
							{
								result = rst.getString(1);
							} 
						} if(rs != null) rs.close();

						if(!result.equals("TRUE")) 
					    {
							continue_yn = false;
							%>
							<script>
								var val = getMessage("INVALID_NAT_ID","MP");
								val = val.replace("#",getLabel("eDR.IDNo.label","DR"))
								parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+val;	
								parent.frames[1].document.getElementById('p_id_no').select();
								parent.frames[1].document.getElementById('p_id_no').focus();
						   </script>
							<%
						}
					}
				}
				if(continue_yn)
				{
					str = "SELECT pat_ser_grp_code,gen_pat_id_yn FROM mp_pat_ser_grp WHERE pat_ser_grp_code = '"+p_id_series1+"' " ;

					rs = stmt.executeQuery(str);
					while (rs.next())
					{
						p_gen_pat_id_yn = rs.getString("gen_pat_id_yn");
					} if(rs != null) rs.close();

					if (p_gen_pat_id_yn.equals("N"))
					{
						%>
						<script>
							parent.frames[1].document.getElementById('p_id_patient_id').disabled = false;
							parent.frames[1].document.getElementById('p_gen_pat_id_yn').value = '<%=p_gen_pat_id_yn%>' ;
						</script>
						<%
					}
					else
					{
						%>
						<script>
							parent.frames[1].document.getElementById('p_id_patient_id').disabled = true;
							parent.frames[1].document.getElementById('p_gen_pat_id_yn').value = '<%=p_gen_pat_id_yn%>';
						</script>
						<%
					}
				}
			}
			
			if(rs!=null) rs.close();
			if(rst!=null) rst.close();
			if(stmt!=null) stmt.close();
			
		}
		catch (Exception e)
		{
			out.println("Exception e :"+e.toString());
		}
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}
		%>
	</body>
</html>


