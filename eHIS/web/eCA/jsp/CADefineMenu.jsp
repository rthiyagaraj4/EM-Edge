<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.CAMenu.label" bundle="${ca_labels}"/></title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../js/CADefineMenu.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	String menu_id="";
	String long_desc="";
	String short_desc="";
	String root_menu_yn="";
	String eff_status="";
	String desktop_yn="";
	String patient_chart_yn="";
	String mode="";
	String enabled_checked="";
	String enabled_checked_1="";
	String enabled_checked_2="";
	String enabled_checked_3="";
	String disl ="";
	String disl_1 ="";
	StringBuffer sql= new StringBuffer();
	String rt_mn_yn="";
	String des_top_yn ="";
	String pat_chart_yn="";
	String Style="";


	mode = (request.getParameter("mode")==null)?"":request.getParameter("mode");
	menu_id = (request.getParameter("menu_id")==null)?"":request.getParameter("menu_id");
	if(mode=="insert" || mode.equals("insert")) 
	{
		menu_id ="";
		mode="insert";
		enabled_checked="checked";
		enabled_checked_2="";
		enabled_checked_3="";
	
	}
	else
	{
		mode="modify";
	}	
	try
	{
		con=ConnectionManager.getConnection(request);
		if(mode.equals("insert"))
		{
			disl="enabled";
			Style = "display:none";
		}
		else 
		if(mode.equals("modify"))
		{	
			disl="disabled";
			disl_1 = "readonly";
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("Select root_menu_yn,short_desc,long_desc,");
			sql.append("eff_status,patient_chart_yn,desktop_yn ");
			sql.append("from ca_menu_header where menu_id=?");            
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,menu_id);
			rs=pstmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
						root_menu_yn = rs.getString("root_menu_yn");
						if(root_menu_yn==null || root_menu_yn.equals("null"))
							root_menu_yn="";
						if(root_menu_yn.equals("Y"))
						{
							enabled_checked_1="checked";
							rt_mn_yn="Y";
							Style = "display";
						}
						else
						{
							enabled_checked_1="";
							disl="disabled";
							disl_1="readonly";
							Style = "display:none";
							rt_mn_yn="N";
						}
						patient_chart_yn = rs.getString("patient_chart_yn");
						if(patient_chart_yn==null || patient_chart_yn.equals("null"))
							patient_chart_yn="";
						if(patient_chart_yn.equals("Y"))
						{
							enabled_checked_2="checked";
							pat_chart_yn="Y";
						}
						else
						{
							enabled_checked_2="";
							pat_chart_yn="N";
						}
						desktop_yn = rs.getString("desktop_yn");
						if(desktop_yn==null || desktop_yn.equals("null"))
							desktop_yn="";
						if(desktop_yn.equals("Y"))
						{
							enabled_checked_3="checked";
							des_top_yn="Y";
						}
						else
						{
							enabled_checked_3="";
							des_top_yn="N";
						}
						short_desc = rs.getString("short_desc");
						if (short_desc == null || short_desc.equals("null"))
							short_desc ="";
						long_desc = rs.getString("long_desc");
						if (long_desc == null || long_desc.equals("null"))
							long_desc ="";
						eff_status = rs.getString("eff_status");
						if(eff_status==null || eff_status.equals("null"))
								eff_status="";
						if(eff_status.equals("E"))
							enabled_checked="checked";
						else
						{
							enabled_checked="";
							disl="disabled";
							disl_1="readonly";
						}
				}
			}
		}
		
		if(rs!=null)
		{
			rs.close();
		}
		if(pstmt!=null)
		{
			pstmt.close();
		}
	}
	catch(Exception e)
	{ 
		//out.println("Exception in CADefineMenu.jsp"+e.toString());//COMMON-ICN-0181 
		 e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
	%>
		</script>
	</head>
	<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="formCADefineMenu" id="formCADefineMenu" action="../../servlet/eCA.CADefineMenuServlet" method="post" target="messageFrame">
			<br><br><br><br><br><br><br>
			<table border=0 cellpadding=3 cellspacing=0 width='75%' align=center >
				
				 <tr>
					<td class='label' ><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
					<td class='fields'>&nbsp;<input type="text" name="menu_id" id="menu_id" value="<%=menu_id%>" size=10 maxlength=10 onkeypress="return CheckForSpecChars(event)" <%=disl_1%>><img src='../../eCommon/images/mandatory.gif'></td>
				</tr>
				
				<tr>
					<td class='label' ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
					<td class='fields'>&nbsp;<input type="text" name="short_desc_hddn" id="short_desc_hddn" value="<%=short_desc%>" size=30 maxlength=30 onkeypress="return CheckSpecChar(event)" <%=((enabled_checked.equals("checked"))?"":disl_1)%>  onBlur='func_assign()'><img src='../../eCommon/images/mandatory.gif'></td>
				</tr>
				
				<tr>
					<td class='label' ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
					<td class='fields'>&nbsp;<input type="text" name="long_desc_hddn" id="long_desc_hddn" value="<%=long_desc%>" size=40 maxlength=40 onkeypress="return CheckSpecChar(event)" <%=((enabled_checked.equals("checked"))?"":disl_1)%>  onBlur='func_assign()'><img src='../../eCommon/images/mandatory.gif'></img></td>
				</tr>
				
				<tr>
					<td class='label'><fmt:message key="Common.RootMenu.label" bundle="${common_labels}"/></td>
					<td>
					<!-- <table border=0 width="80%">
					<tr>
					<td> --><input type="checkbox" name="root_menu_yn_hddn" id="root_menu_yn_hddn" value=" " onClick='fun_chk()' <%=disl%> <%=enabled_checked_1%> onBlur='func_assign()'></td>
					<td class='label' style="<%=Style%>" id="root"><fmt:message key="eCA.Desktop.label" bundle="${ca_labels}"/><input type="checkbox" name="desktop_yn_hdn" id="desktop_yn_hdn" value="" <%=enabled_checked_3%>  onClick="func_desktop_check()">&nbsp;&nbsp;<fmt:message key="Common.patientchart.label" bundle="${common_labels}"/><input type="checkbox" name="paitent_chart_hdn" id="paitent_chart_hdn" value="" <%=enabled_checked_2%>  onClick="func_patChart_check()"><img src='../../eCommon/images/mandatory.gif' ></img>
					<!-- </td></tr></table> -->
					</td>
				</tr>	
			
				<tr>
					<td class='label' ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type="checkbox" name="eff_status" id="eff_status" value="E" <%=enabled_checked%> onBlur='func_assign()'>
				</tr>	
			</table>
			<input type=hidden name="mode" id="mode" value="<%=mode%>"></input>
			<input type=hidden name="menu_id1" id="menu_id1" value="<%=menu_id%>"></input>
			<input type="hidden" name="short_desc" id="short_desc" value="<%=short_desc%>"></input>
			<input type="hidden" name="long_desc" id="long_desc" value="<%=long_desc%>"></input>
			<input type="hidden" name="root_menu_yn" id="root_menu_yn" value=<%=rt_mn_yn%>></input>
			<input type="hidden" name="desktop_yn" id="desktop_yn" value="<%=des_top_yn%>"></input>
			<input type="hidden" name="paitent_chart" id="paitent_chart" value="<%=pat_chart_yn%>"></input>
		 </form>
	 </body>
</html>

