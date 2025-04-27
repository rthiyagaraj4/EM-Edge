<!DOCTYPE html>
 <!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
 <!-- Author - kumar: Included as part of dispPackageDetails.jsp-->
<%@ page import="java.sql.*,webbeans.op.CurrencyFormat, webbeans.eCommon.*"%> <!--,op.CurrencyFormat-->
<%@  page  contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<%
	Connection con = null;
	Statement stmt = null;
	ResultSet rs =null;	

	String locale	= (String)session.getAttribute("LOCALE");

	try
	{
		//con	=	ConnectionManager.getConnection(request);
		con	=	ConnectionManager.getConnection(request);
		int pkg_bill_num = 0;
		request.setCharacterEncoding("UTF-8");	
		String patient_id = request.getParameter("patient_id");
		if (patient_id==null) patient_id="";
		String pkg_bill_type = request.getParameter("pkg_bill_type") == null ? "" : request.getParameter("pkg_bill_type");
		String pkg_bill_no = request.getParameter("pkg_bill_no");
		if (pkg_bill_no == null) pkg_bill_no="0";
		if (pkg_bill_no.equals("")) pkg_bill_no="0";

		try
		{
			//out.println("pkg_bill_no : "+pkg_bill_no);
			pkg_bill_num=Integer.parseInt(pkg_bill_no);
		}
		catch(Exception e)
		{
			out.println("Exception Caught : "+e);
		}		
	%>
<head>
	<!--
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
	-->
		<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!--
		<script language="javascript" src="../../eCommon/js/messages.js"></script>
-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="package_dtls" id="package_dtls" method=post action="">
<%
	String class_val = "QRYEVEN";
	String blng_serv_code = "";
	String short_desc = "";
	String apply_to = "";
	String service_price = "";
	String qv_ind = "";
	String qv_val = "";
	String qv_availed = "";
	String addl_serv_price = "";
	String addl_qty = "";
	String apply_ref_yn = "";
	//String addl_qty_flag = "";

	String sql  = "select a.blng_serv_code, b.short_desc, apply_to, service_price, decode(qv_ind,'Q','Quantity','V','Value') qv_ind, qv_val, qv_availed, addl_serv_price, addl_qty, apply_ref_yn, addl_qty_flag from bl_package_trn_dtl a, bl_blng_serv_lang_vw b 	where b.language_id='"+locale+"' and a.patient_id = 	'"+patient_id+"' and 	a.package_bill_doc_type = '"+pkg_bill_type+"' and a.package_bill_doc_num = 									"+pkg_bill_num+" and a.blng_serv_code = b.blng_serv_code";
		
		
	out.println(" <table cellspacing=0 cellpadding=3 align='center' width='100%' border='1' cellpadding=0 cellspacing=0>");
	out.println("<tr>");
/*	
		out.println("<th>Blng<BR>Serv<br>Code</th>");
		out.println("<th>Description</th>");
		out.println("<th>IP/OP</th>");
		out.println("<th>Service<br>Price</th>");
		out.println("<th>Indicator</th>");
		out.println("<th>Pkg<br>Value/Qty</th>");
		out.println("<th>Apply<br>Refund</th>");
		out.println("<th>Availed</th>");
		out.println("<th>Addl<br>Service<br>Price</th>");
		out.println("<th>Addl<br>Serv<br>Qty</th>");

*/
		out.println("<td class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.BLNG_SERV_CODE.label" ,"bl_labels")+"</td>");
		out.println("<td class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label" ,"common_labels")+"</td>");
		out.println("<td class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.IPOP.label" ,"common_labels")+"</td>");
		out.println("<td class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.SERV_PRICE.label" ,"bl_labels")+"</td>");
		out.println("<td class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.INDICATOR.label" ,"common_labels")+"</td>");
		out.println("<td class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PKG_VAL_QTY.label" ,"bl_labels")+"</td>");
		out.println("<td class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.APPLY_REFUND.label" ,"bl_labels")+"</td>");
		out.println("<td class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.AVAILED.label" ,"bl_labels")+"</td>");
		out.println("<td class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.ADD_SERV_PRICE.label" ,"bl_labels")+"</td>");
		out.println("<td class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.ADD_SERV_QTY.label" ,"bl_labels")+"</td>");
	out.println("</tr>"); 
	
		stmt = con.createStatement();
		rs= stmt. executeQuery(sql);
		if(rs!=null)
		{
			CurrencyFormat cf = new CurrencyFormat();
			while(rs.next())
			{			
				blng_serv_code = rs.getString("blng_serv_code") == null ? "" : rs.getString("blng_serv_code");
				short_desc = rs.getString("short_desc") == null ? "" : rs.getString("short_desc");
				apply_to = rs.getString("apply_to") == null ? "" : rs.getString("apply_to");
				service_price = rs.getString("service_price");
				if ((service_price==null) || (service_price.equals(""))) service_price ="0";
				service_price = cf.formatCurrency(service_price, 2);
				qv_ind = rs.getString("qv_ind") == null ? "" : rs.getString("qv_ind");
				qv_val = rs.getString("qv_val");
				if ((qv_val==null) || (qv_val.equals(""))) qv_val ="0";
				qv_val = cf.formatCurrency(qv_val, 2);
				qv_availed = rs.getString("qv_availed");
				if ((qv_availed==null) || (qv_availed.equals(""))) qv_availed ="0";
				qv_availed = cf.formatCurrency(qv_availed, 2);
				addl_serv_price = rs.getString("addl_serv_price");
				if ((addl_serv_price==null) || (addl_serv_price.equals(""))) addl_serv_price ="0";
				addl_serv_price = cf.formatCurrency(addl_serv_price, 2);
				addl_qty = rs.getString("addl_qty");
				if ((addl_qty==null) || (addl_qty.equals(""))) addl_qty ="0";
				apply_ref_yn = rs.getString("apply_ref_yn") == null ? "" : rs.getString("apply_ref_yn");
				//addl_qty_flag = rs.getString("addl_qty_flag") == null ? "" : rs.getString("addl_qty_flag");			
				addl_qty = cf.formatCurrency(addl_qty, 2);
				if(class_val.equals("QRYEVEN"))
					class_val = "QRYODD";
				else
					class_val = "QRYEVEN";
						
				out.println("<tr>");
				//out.println("<td class='"+class_val+"'> ");
				out.println("<td class='"+class_val+"'>"+blng_serv_code+"</td>");
				out.println("<td class='"+class_val+"'>"+short_desc+"</td>");
				out.println("<td align='center' class='"+class_val+"'>"+apply_to+"</td>");
				out.println("<td align='right' class='"+class_val+"'>"+service_price+"</td>");
				out.println("<td class='"+class_val+"'>"+qv_ind+"</td>");
				out.println("<td align='right' class='"+class_val+"'>"+qv_val+"</td>");			
				//out.println("<td class='"+class_val+"'>"+apply_ref_yn+"</td>");
				out.println("</td><td align='center' class='" + class_val + "'>");
				if ( apply_ref_yn.equals("Y") )
					out.println("<img src='../../eCommon/images/enabled.gif'></img>");
				else
					out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
				out.println("</td>");
				out.println("<td align='right' class='"+class_val+"'>"+qv_availed+"</td>");
				out.println("<td align='right' class='"+class_val+"'>"+addl_serv_price+"</td>");
				out.println("<td align='right' class='"+class_val+"'>"+addl_qty+"</td>");
				out.println("</tr>");
			}
		}
	}
	catch(Exception e) { out.println(e.toString());}
	finally 
	{
		 if (rs != null)   rs.close();
		 if (stmt != null) stmt.close();
		ConnectionManager.returnConnection(con, request);
	}
	out.println("</table>");	
%>
</form>

</body>
</html>

