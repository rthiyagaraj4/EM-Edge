<!DOCTYPE html>
<!-- /*  Developed By Prabhu.M
		 Date -- 06/07/2004
		 Functionality -- OP/Catalog for Clinic
*/ -->
 
 <%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 <html>

	<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String fac_id=(String)session.getValue("facility_id");
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js'></script>
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	<script src='../../eOP/js/CatalogForClinic.js' language='javascript'></script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
  	var careArray=new Array();
	var i=1;
</script>

	<%
	
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;		
		String stat_grp_desc ="";
		String stat_grp_desc1 ="";
		String unittypecode="";
		String unittypedesc1="";
		String careind="";

		
		String orcat="";
		String dat1="";
		
		String ID1="";
		String visit_type_id= "";
		String stat_grp_cd= "";
		visit_type_id =request.getParameter("visit_type_id");
		if(visit_type_id == null) visit_type_id = "";
		
		String order_cat_id= "";
		order_cat_id = request.getParameter("order_cat_id");
		if(order_cat_id == null) order_cat_id = "";
	
	try{
		con =ConnectionManager.getConnection(request);
		if( visit_type_id == null) visit_type_id="";
		if( visit_type_id.equals("")) {
	%>
	<body  onLoad="Focusing('lcnsel');" onMouseDown ='CodeArrest();' onKeyDown = 'lockKey();'>
<% } else { %>
	<body onLoad="from_query('<%=visit_type_id%>','<%=order_cat_id%>');"  onMouseDown ='CodeArrest();' onKeyDown = 'lockKey()'>
<% } %>
	<form name='statgrpdtlquery' id='statgrpdtlquery'>
		<table border="0" width="100%" cellspacing='0' cellpadding='1'>
		<tr><td colspan='4'>&nbsp;</td></tr>
		<tr>
		<td class='label' width='25%'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'>			
			<select name='lcnsel' id='lcnsel' onChange='assignval2(this);'><option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;
			<%
			pstmt=con.prepareStatement("select locn_type,short_desc,care_locn_type_ind from am_care_locn_type where care_locn_type_ind in ('C','E','D') and locn_type in('C','E','Y') and sys_user_def_ind='S' order by 2");
			rs=pstmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					unittypecode=rs.getString("locn_type");
					unittypedesc1=rs.getString("short_desc");
					careind=rs.getString("care_locn_type_ind");

					%>
						<option value='<%=unittypecode%>'><%=unittypedesc1%>
						            <script>
										careArray[i]="<%=careind%>";
									      i++;
									</script>
					<%
				}
			}

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			%>		
			</select>
			</td>
			<td class='label' width='25%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>			
			<%if(visit_type_id.equals("")) {%>

			<td class='fields' width='25%'>	
			<INPUT TYPE="text" name="stat_group2" id="stat_group2"  onBlur="onBlurgetLoc('<%=fac_id%>',document.forms[0].lcnsel.value,document.forms[0].stat_group2);assignVal(document.forms[0].stat_group.value);"><input type="button" name="qloc_butt" id="qloc_butt" value="?" class="button" onClick="getLocn('<%=fac_id%>',document.forms[0].lcnsel.value,document.forms[0].stat_group2);assignVal(document.forms[0].stat_group.value);" ><img align='center' src='../../eMP/images/mandatory.gif'>
			<input type="hidden" name="stat_group" id="stat_group">
			<!-- 
			<select name='stat_group' id='stat_group' onChange='assignVal(this.value)'><option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</select>
			-->			
			</td>
			<%} else if(!visit_type_id.equals("")){

				pstmt = con.prepareStatement("select clinic_code,long_desc from op_clinic where clinic_code='"+visit_type_id+"'");
				rs = pstmt.executeQuery();
				if(rs != null)
				{
				if(rs.next())
				{
				stat_grp_desc = rs.getString("long_desc");
				stat_grp_cd = rs.getString("clinic_code");
				}
				}
			
				if(rs != null )rs.close();
				if(pstmt !=null )pstmt.close();

			%>
			<td class='fields' width='25%'><input type ='text' name = 'stat_group' readOnly  size ='20' value ="<%=stat_grp_desc%>"><input type ='hidden' name = 'stat_grp_cd'  value ="<%=stat_grp_cd%>"    ><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
			<%}%>
			<input type ='hidden' name ='visit_type_id' value ='<%=visit_type_id%>'>
			</tr>
			<tr>					
			<td class='label'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
			<%if(order_cat_id.equals("")) {%>
			<td class='fields'>			
			<select name='stat_group1' id='stat_group1' onChange='assignVal1(this.value)'><option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;
			<%

			 pstmt =con.prepareStatement("Select Short_Desc, Order_Category from OR_ORDER_CATEGORY where Order_Category not in ('PH') order by 1");
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
		</select><img align='center' src='../../eMP/images/mandatory.gif'></td>
		<td>&nbsp;</td>
		<td class='fields'><input type='button' class='button' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='to_visible()'><input type='button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='to_hide()'></td>
			<%} else if(!order_cat_id.equals("")){

				pstmt = con.prepareStatement("select ORDER_CATEGORY from or_order_catalog  where ORDER_CATALOG_CODE='"+order_cat_id+"' order by ORDER_CATEGORY");
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
			<td class='fields'><input type ='text' name = 'stat_group1' readOnly  size ='20' value ="<%=orcat%>"   ><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			<%}%>
			<input type ='hidden' name ='visit_type_id' value ='<%=visit_type_id%>'>		
			<input type ='hidden' name ='orcat' value ='<%=orcat%>'>		
			<input type ='hidden' name ='order_cat_id' value ='<%=order_cat_id%>'>
			<input type='hidden' name='statusval' id='statusval' value=''>
			</td>
			</tr>
			<tr><td colspan='4'>&nbsp;</td></tr>
			<input type ='hidden' name ='lcnselval' value =''>
		</TABLE>
		</form>

	<%}catch(Exception e){out.println("Exception :"+e);}
finally{

	try{
		if( rs != null) rs.close();
		if( pstmt != null) pstmt.close();
	}catch(Exception e){}

	if(con != null)  ConnectionManager.returnConnection(con,request);
} %>
	</body>
</html>

