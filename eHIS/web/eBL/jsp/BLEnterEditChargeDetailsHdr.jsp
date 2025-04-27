<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eOR.*,eOR.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rs1 = null; ResultSet rs2 = null; 	
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");	
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");	
	con	=	ConnectionManager.getConnection(request);
	String locale	= (String)session.getAttribute("LOCALE");
	String p_facility_id = ""; 	String p_login_user = ""; 		String sql_ord_cat=""; 
	String sql_pan_desc=""; String p_service_date="";
	String p_service_panel_ind="";	String p_service_panel_code="";	String p_serv_panel_qty="";
	String p_pract_staff_ind="";	String p_pract_staff_id="";	String p_serv_panel_str="";
	String p_order_catalog_code="";	String strorder_short_desc ="";	String strpanel_short_desc="";
	String stradd_services_during_entry_yn="";	
	try
	{
		p_facility_id = (String)httpSession.getValue("facility_id");
		p_login_user =  p.getProperty("login_user");
		p_service_date = request.getParameter("service_date");		
		p_service_panel_ind = request.getParameter("service_panel_ind");
		p_service_panel_code = request.getParameter("service_panel_code");
		p_serv_panel_qty = request.getParameter("serv_panel_qty");
		p_pract_staff_ind = request.getParameter("pract_staff_ind");
		p_pract_staff_id = request.getParameter("pract_staff_id");
		p_serv_panel_str = request.getParameter("serv_panel_str");
		p_order_catalog_code = request.getParameter("order_catalog_code");
		if(p_service_date==null) p_service_date="";
		if(p_service_panel_ind==null) p_service_panel_ind="";
		if(p_serv_panel_qty==null) p_serv_panel_qty="";
		if(p_pract_staff_ind==null) p_pract_staff_ind="";
		if(p_pract_staff_id==null) p_pract_staff_id="";
		if(p_serv_panel_str==null) p_serv_panel_str="";
		if(p_order_catalog_code==null) p_order_catalog_code="";		
	}
	catch(Exception eX)
	{	
		out.println("Error= "+eX);			
	}
%>
<head>
<script>
</script>
<title>
</title>
<%  
try{	
	if(!p_order_catalog_code.equals(""))
	{
		sql_ord_cat = "SELECT long_desc FROM or_order_catalog_lang_vw WHERE order_catalog_code = '"+p_order_catalog_code+"' and language_id='"+locale+"' ";
		pstmt = con.prepareStatement(sql_ord_cat);
		rs1 = pstmt.executeQuery() ;
		if( rs1 != null ) 
		{
			while( rs1.next() )
			{  
				strorder_short_desc = rs1.getString(1);
			}//while
		}	//if
		rs1.close();
		pstmt.close();
	}//first if	
	
		sql_pan_desc= "SELECT long_desc,nvl(add_services_during_entry,'N') FROM bl_panel_hdr_lang_vw WHERE OPERATING_FACILITY_ID  ='"+p_facility_id+"'AND  panel_code = '"+p_service_panel_code+"' AND language_id='"+locale+"' ";//"+	"	AND NVL('"+p_service_panel_code+"',?L?) = ?L? ";
		pstmt = con.prepareStatement(sql_pan_desc);
		rs2 = pstmt.executeQuery() ;
		if( rs2 != null ) 
		{
			while( rs2.next() )
			{  
				strpanel_short_desc = rs2.getString(1);
				stradd_services_during_entry_yn =  rs2.getString(2);
			 }//while
		}//if
		rs2.close();
		pstmt.close();
	
	}catch(Exception e )
		{ 
			out.println(e);
		}
		finally
		{	
			if(pstmt != null)		pstmt.close();
			ConnectionManager.returnConnection(con, request);
		}
%>
<!--
<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'>
-->
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>	
		<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	</head>
	<form>
		<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
			<tr>
			<td   class='label'><b><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></b></td>
			<td  class="fields"><input type='text' name='order_catalog_desc' id='order_catalog_desc' size='40' readonly maxlength='30'  value='<%=strorder_short_desc%>'></td>						
			<td  class='label'><b><fmt:message key="Common.Panel.label" bundle="${common_labels}"/></b></td>
			<td  class="fields"><input type='text' name='panel_desc' id='panel_desc' size='40' readonly maxlength='30'  value='<%=strpanel_short_desc%>'></td>			
			</tr>
			<tr>
			<td width='25%' class="fields"colspan='20'>&nbsp;</td>
			</tr>
			<tr>
			<td width='25%' class="fields"colspan='20'>&nbsp;</td>
			</tr>
			<tr>
			<td width='25%' class="fields"colspan='20'>&nbsp;</td>
			</tr>
			<tr>
			<td width='25%' class="fields"colspan='20'>&nbsp;</td>
			</tr>
		</table>
	<input type= hidden name="add_services_yn" id="add_services_yn"  value='<%=stradd_services_during_entry_yn%>'>	
	<input type= hidden name="order_catalog_code" id="order_catalog_code"  value='<%=p_order_catalog_code%>'>
	<input type= hidden name="service_panel_code" id="service_panel_code"  value='<%=p_service_panel_code%>'>
	</form>
	</html>

