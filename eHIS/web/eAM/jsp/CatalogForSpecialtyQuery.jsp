<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

 <html>

	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js'></script>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<script src='../../eAM/js/CatalogForSpeciality.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		Connection con =ConnectionManager.getConnection(request);// (Connection) session.getValue( "connection" );
		PreparedStatement pstmt = null;
		ResultSet rs=null;		
		
		String stat_grp_desc1 ="";
		String unittypedesc1="";
		
		String orcat="";
		String dat1="";
		
		String ID1="";
		String visit_type_id= "";
		visit_type_id =request.getParameter("visit_type_id");
		if(visit_type_id == null) visit_type_id = "";
		
		String order_cat_id= "";
		order_cat_id = request.getParameter("order_cat_id");
		if(order_cat_id == null) order_cat_id = "";
	
	try{
	
		if( visit_type_id == null) visit_type_id="";

		
		if( visit_type_id.equals("")) {
	%>
	<body  onLoad="Focusing('speciality_loc');" onMouseDown ='CodeArrest();' onKeyDown = 'lockKey()'>
<% } else { %>
	<body onLoad="from_query('<%=visit_type_id%>','<%=order_cat_id%>');"  onMouseDown ='CodeArrest();' onKeyDown = 'lockKey()'>
<% } %>
	<form name='statgrpdtlquery' id='statgrpdtlquery'>
		<table border="0" width="100%" cellspacing='0' cellpadding='0'>
		<tr><td colspan='8'>&nbsp;</td></tr>
		<tr>
		<td class='label'  width='10%' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;</td>
		<td width='15%' >			
			<select name='speciality_loc' id='speciality_loc' onChange='assignVal5(this.value)'><option value=''> ---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---- 
			<%
			pstmt=con.prepareStatement("select speciality_code, short_desc from am_speciality where eff_status = 'E' order by 2");
			rs=pstmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					visit_type_id=rs.getString("speciality_code");
					unittypedesc1=rs.getString("short_desc");

					%>
						<option value='<%=visit_type_id%>'><%=unittypedesc1%>
					<%
				}
			}

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			%>
			
		
			</select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
			<td class='label'  width='10%' nowrap>&nbsp;&nbsp;<fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/>&nbsp;</td>
			<%if(order_cat_id.equals("")) {%>
			<td width='20%' >			
			<select name='stat_group1' id='stat_group1' onChange='assignVal1(this.value)'><option value=''>&nbsp;&nbsp;------- ------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------- --------&nbsp;&nbsp;
			<%

			 pstmt =con.prepareStatement("Select Short_Desc, Order_Category from OR_ORDER_CATEGORY where Order_Category <> 'PH' order by 1");
			 rs=pstmt.executeQuery();
			
				if(rs !=null)
				{
				 while(rs.next())
				 {
					dat1=rs.getString("Short_Desc");
					ID1=rs.getString("Order_Category");
					out.println("<option value='"+ID1+ "' >"+dat1+"</option>");
				 }
				}
			  if(rs != null )rs.close();
			  if(pstmt != null )pstmt.close();
			%>
		</select>&nbsp;<img align='center' src='../../eMP/images/mandatory.gif'></td>
		<td  align="center"><input type='button' class='button' name='Search' id='Search' value='Search' onClick='to_visible()'><input type='button' class='button' name='Cancel' value='Cancel'  id='Cancel'onClick='to_hide()'></td>
			<%} else if(!order_cat_id.equals("")){

				//pstmt = con.prepareStatement("select ORDER_CATEGORY from or_order_catalog  where ORDER_CATALOG_CODE='"+order_cat_id+"' order by ORDER_CATEGORY");
				String strStmt ="select ORDER_CATEGORY from or_order_catalog  where ORDER_CATALOG_CODE=? order by ORDER_CATEGORY";
				
				pstmt   = con.prepareStatement(strStmt);
				pstmt.setString	(	1,	order_cat_id);

				rs = pstmt.executeQuery();
				if(rs.next())
				{
				stat_grp_desc1 = rs.getString("ORDER_CATEGORY");
				}
				
				if(rs != null )rs.close();
				if(pstmt != null )pstmt.close();

                pstmt=con.prepareStatement("select short_desc from OR_ORDER_CATEGORY where Order_Category ='"+stat_grp_desc1+"'");
				rs = pstmt.executeQuery();
				if(rs != null)
				{
					while(rs.next())
					{
					orcat = rs.getString("short_desc");
					} 
				}
		
				if(rs != null ) rs.close();
				if(pstmt !=null )pstmt.close();
					%>
			<td><input type ='text' name = 'stat_group1' id = 'stat_group1' readOnly  size ='20' value ="<%=orcat%>"   >&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
			<%}%>
			<input type ='hidden' name ='visit_type_id'  id ='visit_type_id'value ='<%=visit_type_id%>'>		
			<input type ='hidden' name ='orcat'  id ='orcat'value ='<%=orcat%>'>		
			<input type ='hidden' name ='order_cat_id' id ='order_cat_id' value ='<%=order_cat_id%>'>
			<input type='hidden' name='statusval' id='statusval' value=''>
			</td>
		</tr>
			<tr><td colspan='8'>&nbsp;</td></tr>
			<input type ='hidden' name ='lcnselval'  id ='lcnselval'value =''>
		</TABLE>
		</form>

	<%}catch(Exception e){
		//out.println("Exception :"+e);
		e.printStackTrace();
		}
finally{

	try{
		if( rs != null) rs.close();
		if( pstmt != null) pstmt.close();
	}catch(Exception e){}

	if(con != null)  ConnectionManager.returnConnection(con,request);
} %>
	</body>
</html>

