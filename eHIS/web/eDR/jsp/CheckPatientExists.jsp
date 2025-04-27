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

	<script language='javascript' src='../../eDR/js/ChangeIDSeries.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
   <script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='message' onKeyDown='lockKey();'>
<%
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;
	
	String str		= "";
	String p_dis_id	= "";
 String locale=(String)session.getAttribute("LOCALE");  
	String p_patient_id	= request.getParameter("p_patient_id");
	if(p_patient_id == null) p_patient_id = "";

	demography d = new demography();
	String name	 = d.name_age_sex(session ,p_patient_id,con,locale);
	int strSplit = name.lastIndexOf(",");
	if(strSplit > 0)
	{
		name = name.substring(0,strSplit); 
	}

	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();
		
		int maxrecord = 0;

		str = "SELECT count(*) total_records FROM mp_patient WHERE patient_id= '"+p_patient_id+"' " ;
		rs  = stmt.executeQuery(str);
		while(rs.next())
		{
			maxrecord = rs.getInt("total_records");
		} if(rs != null) rs.close();

		if(maxrecord == 0)
		{
			%>
			<script>
				var errors = getMessage("NO_RECORD","DR") ;
				parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+errors;
				parent.parent.frames[2].frames[1].document.getElementById('patient_id').select();
			</script> 
			<%
		}
		else
		{
			String p_pat_ser_grp_code = "";

			str = "SELECT pat_ser_grp_code FROM mp_patient WHERE patient_id='"+p_patient_id+"' " ;
			rs  = stmt.executeQuery(str);
			while(rs.next())
			{
				p_pat_ser_grp_code = rs.getString("pat_ser_grp_code");
			} if(rs != null) rs.close();
			
			String p_id_type	= "";
			String p_short_desc = "";
			
			str = "SELECT short_desc,nvl(id_type,'X')id_type FROM mp_pat_ser_grp WHERE pat_ser_grp_code = '"+p_pat_ser_grp_code+"' " ;
			rs  = stmt.executeQuery(str);
			while(rs.next())
			{
				p_id_type = rs.getString("id_type");
				p_short_desc = rs.getString("short_desc");
			}

			if(p_id_type.equals("A") || (p_id_type.equals("N")))
			{
				p_dis_id = "disabled";
				%>
				<script>
					var errors = getMessage("CHANGE_ID_SERIES_NOT_ALLOWED","DR") ;
					parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+errors;	
					parent.parent.frames[2].frames[1].location.href = '../../eDR/jsp/ChangeIDSeries.jsp?patient_id=<%=p_patient_id%>&p_short_desc='+ '<%=p_short_desc%>&p_dis_id=<%=p_dis_id%>';
				</script>
				<%
			}
			else
			{
				%>
				<script>
					parent.parent.frames[2].frames[1].document.getElementById('id_series').disabled=false;
					parent.parent.frames[2].frames[1].document.getElementById('').id_series1.disabled=false;
				</script>
				<%
			}			
			%>
			<script>
				parent.parent.frames[2].frames[1].document.getElementById('p_existing_series_group').value = '<%=p_short_desc%>' ;
				parent.parent.frames[2].frames[1].document.getElementById("pat_ser_grp").innerHTML="<b>"+"<%=p_short_desc%>";
				parent.parent.frames[2].frames[1].document.getElementById("pat_name").innerText = "<%=name%>";
				
				var sel = parent.parent.frames[2].frames[1].document.forms[0].id_series1;

				while(sel.options.length>1)
				{
					sel.remove(1);
				}
				parent.parent.frames[2].frames[1].document.getElementById('id_series').value = "";
				parent.parent.frames[2].frames[1].document.getElementById('p_id_no').value = "";
				parent.parent.frames[2].frames[1].document.getElementById('p_id_no').disabled=true;				
			</script>
			<%
		}

		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
	}
	catch(Exception e)
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

