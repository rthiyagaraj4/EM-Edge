<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*, java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.ExternalApplicationDetail.label" bundle="${ca_labels}"/></title>
		<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../js/CAExternalApplDtl.js'></script>
</head>
<%
	Connection con=null;
	PreparedStatement app_pstmt=null;
	ResultSet app_rs=null;
	
	PreparedStatement order_pstmt=null;
	ResultSet order_rs=null;
	
	String app_sql = "";
	String ext_image_appl_id = "";
	String ext_image_appl_name = "";
	String order_type_desc = "";

	String order_sql = "";
	String short_desc = "";
	String order_category = "";

	String mode = "";
	
	String ext_image_appl_id1 = "";
	String order_category1 = "";
	String order_type_code = "";
	String order_catalog_code = "";
	String order_catalog_desc = "";
	String eff_status = "";
	String eff_selected = "";
	String facility_name = "";
	String facility_id = "";

	String disable_mode = "";
	String readonly_mode = "";
	
	try
	{
		con = ConnectionManager.getConnection();

		mode = request.getParameter("mode")==null?"":request.getParameter("mode");
		

		if(mode.equals("modify"))
		{

			PreparedStatement pstmt=null;
			ResultSet rset=null;
			
			ext_image_appl_id1 = request.getParameter("ext_image_appl_id")==null?"":request.getParameter("ext_image_appl_id");
			 order_type_code = request.getParameter("order_type_code")==null?"*ALL":request.getParameter("order_type_code"); 
			 order_catalog_code = request.getParameter("order_catalog_code")==null?"":request.getParameter("order_catalog_code"); 
			 facility_id = request.getParameter("facility_id")==null?"*A":request.getParameter("facility_id");
			order_category1 = request.getParameter("order_category")==null?"":request.getParameter("order_category"); 


			String sql = "SELECT (SELECT ext_image_appl_name FROM ca_ext_image_appl  WHERE eff_status = 'E'and ext_image_appl_id = a.ext_image_appl_id	) ext_image_appl_name ,(select SHORT_DESC from OR_ORDER_CATEGORY where order_category = a.order_category ) or_order_category_desc, (select SHORT_DESC from OR_ORDER_TYPE where EFF_STATUS='E' and order_type_code = a.order_type_code ) order_type_desc, (select SHORT_DESC from or_order_catalog where order_catalog_code = a.order_catalog_code )order_catalog_desc, a.eff_status,(select facility_name from sm_facility_param where  status='E' and facility_id = a.facility_id) facility_name  FROM ca_ext_appl_detail a where a.ext_image_appl_id = ? and a.order_category = ? and a.order_type_code = ? and a.order_catalog_code = ? and a.facility_id = ? ";

			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,ext_image_appl_id1);
			pstmt.setString(2,order_category1);
			pstmt.setString(3,order_type_code);
			pstmt.setString(4,order_catalog_code);
			pstmt.setString(5,facility_id);

			rset = pstmt.executeQuery();

			while(rset.next())
			{
			
			order_type_desc = rset.getString("order_type_desc")==null?"":rset.getString("order_type_desc"); 
			order_catalog_desc = rset.getString("order_catalog_desc")==null?"*ALL":rset.getString("order_catalog_desc"); 
			eff_status = rset.getString("eff_status")==null?"":rset.getString("eff_status");
			facility_name = rset.getString("facility_name")==null? com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels"):rset.getString("facility_name");
			
			}
			if(eff_status.equals("E"))
				eff_selected = "Checked";
			else
				eff_selected = "";

			readonly_mode = "readonly";
			disable_mode = "disabled";
		
			if(rset!=null)
				rset.close();
			if(pstmt!=null)
				pstmt.close();
		}
		else
		{
			eff_selected = "Checked";
			order_catalog_code = "*ALL";
			order_catalog_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
			facility_id = "*A";
			facility_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
			 disable_mode = "";
			 eff_status = "E";

		}

	%>
	<body onKeyDown="lockKey()">
	<form name='CAExternalApplDtlMainForm' id='CAExternalApplDtlMainForm'  action='../../servlet/eCA.CAExternalApplDtlServlet' method='post' target='messageFrame' >  
	<br><br><br><br><br><br>
	<table border='0' cellspacing='0' cellpadding='3' width='75%' align='center'>

	<tr>	
		<td class='label'><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td>
		<td class="fields" > 
		<%
			
			app_sql = "select EXT_IMAGE_APPL_ID,EXT_IMAGE_APPL_NAME from CA_EXT_IMAGE_APPL where EFF_STATUS='E' order by EXT_IMAGE_APPL_NAME ";
		
			app_pstmt = con.prepareStatement(app_sql);
			app_rs = app_pstmt.executeQuery();

		%>
		<select name='application' id='application' <%=disable_mode%> onChange='clear_message()'>
			<option  value='' selected>-------------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----------------------</option>
		<%
			
		while(app_rs.next())
		{
			ext_image_appl_id = app_rs.getString("EXT_IMAGE_APPL_ID")==null?"":app_rs.getString("EXT_IMAGE_APPL_ID");
			ext_image_appl_name = app_rs.getString("EXT_IMAGE_APPL_NAME")==null?"":app_rs.getString("EXT_IMAGE_APPL_NAME");

			if(ext_image_appl_id.equals(ext_image_appl_id1))
			{
				out.println("<option value='"+ext_image_appl_id+"' selected >"+ext_image_appl_name+"</option>");
			}
			else
			{
				out.println("<option value='"+ext_image_appl_id+"'>"+ext_image_appl_name+"</option>");
			}

		}
		%>
		</select><img src='../../eCommon/images/mandatory.gif'>
		
		</td>
		</tr>
		<tr>	
		<td class='label'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
		<td class='fields'> 
		<%
			
			order_sql = "select SHORT_DESC,ORDER_CATEGORY from OR_ORDER_CATEGORY order by  SHORT_DESC ";
		
			order_pstmt = con.prepareStatement(order_sql);
			order_rs = order_pstmt.executeQuery();

		%>
		<select name='order_category' id='order_category' Onchange='View_OrderType(this)' <%=disable_mode%>>
			<option  value='' selected>--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------</option>
		<%
			
		while(order_rs.next())
		{
			short_desc = order_rs.getString("SHORT_DESC")==null?"":order_rs.getString("SHORT_DESC");
			order_category = order_rs.getString("ORDER_CATEGORY")==null?"":order_rs.getString("ORDER_CATEGORY");

			if(order_category.equals(order_category1))
			{
				out.println("<option value='"+order_category+"' selected >"+short_desc+"</option>");
			}
			else
			{
				out.println("<option value='"+order_category+"'>"+short_desc+"</option>");
			}
		}
		%>
		</select><img src='../../eCommon/images/mandatory.gif'>
		
		</td>
		</tr>
		<tr>	
			<td class='label'><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
			<td class='fields'> 
				<select name='order_type' id='order_type' <%=disable_mode%> onchange='enable_order_catalog(this)'>
			<%
				if(mode.equals("modify"))
				{
					if(order_type_desc.equals("")){
					%>
					<option  value='*ALL' selected ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<%
					}else{
					%>
					<option  value='<%=order_type_code%>' selected ><%=order_type_desc%></option>
					<%
					}
				}
			else
				{
			%>	
				<option  value='*ALL' selected >----<fmt:message key="Common.all.label" bundle="${common_labels}"/>----</option>
			<%
				}
			%>			
				</select></td>
		</tr>
		<tr>	
			<td class='label'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='text' name='order_catalog1' id='order_catalog1'  OnChange='resetValues();' value='<%=order_catalog_desc%>' size=15 maxlength='15' <%=readonly_mode%> onblur='get_order_catalog(this)' disabled ><input type='hidden' name='order_catalog' id='order_catalog' value='<%=order_catalog_code%>' ></input><input type='button' value='?' name='catalog_buttn' id='catalog_buttn' class='button' Onclick='resetValues();get_order_catalog(this)' disabled></td>
		</tr>	
		<tr>	
			<td class='label'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='text' name='facility_id1' id='facility_id1' value='<%=facility_name%>' size=30 maxlength='30' <%=readonly_mode%> onblur='get_facility(this)'    OnChange='resetValues();' ><input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>' ></input><input type='button' value='?' name='facility_buttn' id='facility_buttn' class='button' Onclick='resetValues();get_facility(this);'  <%=disable_mode%>></td>
		</tr>	
		<tr>	
			<td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='checkbox' value='<%=eff_status%>' name='enable'   Onclick='enable_Check(this)' <%=eff_selected%>><input type='hidden' value='<%=eff_status%>' name='eff_status'></input></td>
		</tr>

	<input type = 'hidden' name='mode' id='mode' value="<%=mode%>"></input>
	<input type = 'hidden' name='ext_image_appl_id' id='ext_image_appl_id' value="<%=ext_image_appl_id1%>"></input>
	<input type = 'hidden' name='order_category_code' id='order_category_code' value="<%=order_category1%>"></input>
	<input type = 'hidden' name='order_type_code' id='order_type_code' value="<%=order_type_code%>"></input>
	</form>
	</body>
	<html>
	<%
	}
	catch(Exception ex)	{
		//	out.println("Exception @ CAExternalApplDtlAddModify.jsp "+ex.toString());//COMMON-ICN-0181
                         ex.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		try
		{
			if(app_rs!=null)
				app_rs.close();
			if(app_pstmt!=null)
				app_pstmt.close();
		
			if(order_rs!=null)
				order_rs.close();
			if(order_pstmt!=null)
				order_pstmt.close();	

			if(con!=null)ConnectionManager.returnConnection(con,request);
		}
		catch(Exception e)
		{
				//out.println("Exception @ finally CAExternalApplDtlAddModify.jsp "+e.toString());//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
		}
	}

%>


