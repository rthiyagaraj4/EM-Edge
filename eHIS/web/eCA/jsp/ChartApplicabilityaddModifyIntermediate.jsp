<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
    String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="JavaScript" src ="../../eCA/js/ChartApplicability.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
		<SCRIPT LANGUAGE="JavaScript">
			var returnArray;
		</SCRIPT>
	</head>
	<%@page import="java.sql.*,java.io.*, webbeans.eCommon.ConnectionManager"%>
	<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
	<form name="chartApplicabilityIntermediateForm" id="chartApplicabilityIntermediateForm">
<%

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String description = "";
	String sql = "";
	int count = 0;
	try
	{
		String textName = "";
		con = ConnectionManager.getConnection(request);
		textName = request.getParameter("textName") == null ? "" : request.getParameter("textName");
		if(textName.equals("specialty"))
		{
			description = request.getParameter("specialty") == null ? "" : request.getParameter("specialty");
			sql = "SELECT  speciality_code code, short_desc description from am_speciality where eff_status='E' and upper(short_desc) like upper(?) order by 2";
			description = description + "%";
			ps = con.prepareStatement(sql);
			ps.setString(1,description);
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				while(rs.next())
				{	
				
				out.println("parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.specialtyDesc.value='"+rs.getString(2)+"' ");
				out.println("parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.specialtyCode.value='"+rs.getString(1)+"' ");
				}
			out.println("</script>");
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			}
			if(count == 0 || count > 1)
			{
				sql = "SELECT  speciality_code code, short_desc description from am_speciality where eff_status='E' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
		%>
				<script>
					retArray = callFunction("<%=(sql)%>","Specialty",parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.specialtyDesc)
					if(retArray != null && retArray !="")	
						{
							parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.specialtyDesc.value = retArray[1];
							parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.specialtyCode.value = retArray[0];
							
						}
						else
						{
							parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.specialtyDesc.value = 'ALL';
							parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.specialtyCode.value = '*ALL';
							
						}
				</script>
				
			<%	if(rs != null) rs.close();
				if(ps != null) ps.close();}
		}
		if(textName.equals("practType"))
		{
			description = request.getParameter("practType") == null ? "" : request.getParameter("practType");
			sql = "SELECT PRACT_TYPE,DESC_SYSDEF  FROM am_pract_type where eff_status='E' and upper(DESC_SYSDEF) like upper(?) order by 2";
			description = description + "%";
			ps = con.prepareStatement(sql);
			ps.setString(1,description);
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				while(rs.next())
				{	
				
				out.println("parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.practTypeDesc.value='"+rs.getString(2)+"' ");
				out.println("parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.practTypeCode.value='"+rs.getString(1)+"' ");
				}
			out.println("</script>");
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			}
			if(count == 0 || count > 1)
			{
				sql = "SELECT PRACT_TYPE code,  DESC_SYSDEF description FROM am_pract_type where eff_status='E'  and upper(PRACT_TYPE) like upper(?) and upper(DESC_SYSDEF) like upper(?) order by 2 ";
			
%>
	<script>
		 retArray = callFunction("<%=sql%>","Practitioner Type",parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.practTypeDesc)
			if(retArray != null && retArray !="")	
			{
					parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.practTypeDesc.value = retArray[1];
					parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.practTypeCode.value = retArray[0];
					
			}
			else
			{
				parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.practTypeDesc.value = 'ALL';
				parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.practTypeCode.value = '*A';
				
			}
	</script>
<%		if(rs != null) rs.close();
		if(ps != null) ps.close();
			}
		}	
		if(textName.equals("location"))
		{
			description = request.getParameter("location") == null ? "" : request.getParameter("location");
			String tableName = request.getParameter("tableName") == null ? "" : request.getParameter("tableName");
			if(tableName.equals("OP_CLINIC"))
			{
				sql = "select CLINIC_CODE, SHORT_DESC from op_clinic where EFF_STATUS='E' and upper(SHORT_DESC) like upper(?) order by 2";
			}
			if(tableName.equals("IP_NURSING_UNIT"))
			{
				sql = "select NURSING_UNIT_CODE, SHORT_DESC from IP_NURSING_UNIT where EFF_STATUS='E' and upper(SHORT_DESC) like upper(?) order by 2";
			}
			description = description + "%";
			ps = con.prepareStatement(sql);
			ps.setString(1,description);
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				while(rs.next())
				{	
				
				out.println("parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.locationDesc.value='"+rs.getString(2)+"' ");
				out.println("parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.locationCode.value='"+rs.getString(1)+"' ");
				}
			out.println("</script>");
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			}
			if(count == 0 || count > 1)
			{
				
			if(tableName.equals("OP_CLINIC"))
				{
					sql = "select CLINIC_CODE code, SHORT_DESC description from op_clinic where EFF_STATUS='E' and upper(CLINIC_CODE) like upper(?)  and upper(SHORT_DESC) like (?) order by 2";
				}
				else
				{
					sql = "select NURSING_UNIT_CODE code, SHORT_DESC description from ip_nursing_unit where EFF_STATUS='E' and upper(NURSING_UNIT_CODE) like upper(?)  and upper(SHORT_DESC) like (?) order by 2";
				}
%>
	<script>
		 retArray = callFunction("<%=sql%>","Location",parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.locationDesc)
			if(retArray != null && retArray !="")	
			{
					parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.locationDesc.value = retArray[1];
					parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.locationCode.value = retArray[0];
					
			}
			else
			{
				parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.locationDesc.value = 'ALL';
				parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.locationCode.value = '*ALL';
				
			}
	</script>
<%				if(rs != null) rs.close();
				if(ps != null) ps.close();
			}
			
		}
		if(textName.equals("ageGrp"))
			{
			description = request.getParameter("ageGrpCode") == null ? "" : request.getParameter("ageGrpCode");
			sql = "Select AGE_GROUP_CODE, SHORT_DESC from am_age_group where eff_status='E' and upper(SHORT_DESC) like upper(?) order by 2";
			description = description + "%";
			ps = con.prepareStatement(sql);
			ps.setString(1,description);
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}

			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				while(rs.next())
				{	
				
				out.println("parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.ageGrpDesc.value='"+rs.getString(2)+"' ");
				out.println("parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.ageGrpCode.value='"+rs.getString(1)+"' ");
				}
			out.println("</script>");
			if(rs != null) rs.close();
		if(ps != null) ps.close();
			}
			if(count == 0 || count > 1)
			{
				sql = "Select AGE_GROUP_CODE code, SHORT_DESC description from am_age_group where eff_status='E' and upper(AGE_GROUP_CODE) like upper(?)  and upper(SHORT_DESC) like upper(?) order by 2";
			
%>
	<script>
		 retArray = callFunction("<%=sql%>","Age  Group",parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.ageGrpDesc)
			if(retArray != null && retArray !="")	
			{
					parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.ageGrpDesc.value = retArray[1];
					parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.ageGrpCode.value = retArray[0];
					
			}
			else
			{
				parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.ageGrpDesc.value = 'ALL';
				parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.ageGrpCode.value = '*ALL';
				
			}
	</script>
<%				if(rs != null) rs.close();
				if(ps != null) ps.close();
			}
			
		}
		if(textName.equals("chart"))
			{
			description = request.getParameter("chartCode") == null ? "" : request.getParameter("chartCode");
			sql = "Select CHART_ID, SHORT_DESC from ca_chart where eff_status='E' and upper(SHORT_DESC) like upper(?) order by 2";
			description = description + "%";
			ps = con.prepareStatement(sql);
			ps.setString(1,description);
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}	
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				while(rs.next())
				{	
				
				out.println("parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.chartDesc.value='"+rs.getString(2)+"' ");
				out.println("parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.chartCode.value='"+rs.getString(1)+"' ");
				}
			out.println("</script>");
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			}
			if(count == 0 || count > 1)
			{
				sql = "Select CHART_ID code, SHORT_DESC description from ca_chart where eff_status='E'  and upper(CHART_ID) like upper(?) and  upper(SHORT_DESC) like upper(?) order by 2";
			
%>
	<script>
		 retArray = callFunction("<%=sql%>","Chart",parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.chartDesc)
			if(retArray != null && retArray !="")	
			{
					parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.chartDesc.value = retArray[1];
					parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.chartCode.value = retArray[0];
					
			}
			else
			{
				parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.chartDesc.value = '';
				parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.chartCode.value = '';
				
			}
	</script>
<%				if(rs != null) rs.close();
				if(ps != null) ps.close();
			}
			
		}
		
%>
<%
	}
	catch(Exception ee)
	{
		//out.println("Exception in ChartAddModify Intermediate Module "+ee.toString());//common-icn-0181
                 ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con);
	}

%>
	</form>
	</body>

