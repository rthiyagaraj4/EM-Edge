<!DOCTYPE html>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- Author - kumar: Included as part of dispPackageDetails.jsp-->
<%@ page import="java.sql.*,webbeans.op.CurrencyFormat, webbeans.eCommon.* "%><!--,op.CurrencyFormat-->
<%@  page  contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
Connection con = null;
PreparedStatement pstmt =null;
ResultSet rs =null;

String locale	= (String)session.getAttribute("LOCALE");

try
{
	//con = (Connection) session.getValue("connection" );
	con	=	ConnectionManager.getConnection(request);
	request.setCharacterEncoding("UTF-8");
	int pkg_bill_num = 0;
	String patient_id = request.getParameter("patient_id");
	if (patient_id == null) patient_id = "";
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

	String Pat_Details  ="";
	String Pat_Details1 ="";
	try
	{
		pstmt  = con.prepareStatement("select get_patient_line('"+patient_id+"') patient_menu from dual");		
		rs =  pstmt.executeQuery();
		if (rs!=null)
		{
			while(rs.next())
			{
			  Pat_Details = rs.getString("patient_menu");
			  if (Pat_Details==null) Pat_Details="";
			  if (Pat_Details.length()>0)
					Pat_Details1= Pat_Details.substring(0,Pat_Details.length()-7);
			  if (Pat_Details1==null) Pat_Details1="";
			}
		}
	}
	catch(Exception e) { out.println(e.toString());}
	finally 
	{
		 if (pstmt != null) pstmt.close();
		 if (rs != null)   rs.close();
	}
%>
<html>
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="package_details" id="package_details" method=post action="">
<%
	String ar_install_yn = "";
	try
	{
		pstmt  = con.prepareStatement("select install_yn from sm_module where module_id='AR'");
		rs =  pstmt.executeQuery();
		if (rs!=null)
		{
			while (rs.next())
			{
				ar_install_yn = rs.getString("install_yn");
			}
		}		
	}
	catch(Exception e) { out.println(e.toString());}
	finally 
	{
		 if (pstmt != null) pstmt.close();
		 if (rs != null)   rs.close();
	}
	if (ar_install_yn==null) ar_install_yn="N";
	

	String package_desc = "";
	String package_code = "";
	String package_bill_doc_type = "";
	String package_bill_doc_num = "";
	String package_bill_date = "";
	String expiry_date = "";
	String cust_pc_ind = "";
	String cust_code = "";
	String valid_from = "";
	String valid_to = "";
	String package_price = "";
	String availed_price = "";
	String valid_days = "";
	String disc_perc_prop_price = "";
	String disc_perc_curr_price = "";
	String closed_yn = "";
	String cust_name = "";
	String chkProp = "";
	String chkProp1 = "";
	
	if (ar_install_yn.equals("Y"))
	{
		pstmt  = con.prepareStatement("select a.package_code, package_bill_doc_type,	package_bill_doc_num, to_char(package_bill_date,'dd/mm/yyyy') package_bill_date, to_char(expiry_date,'dd/mm/yyyy') expiry_date, a.cust_pc_ind, a.cust_code, to_char(valid_from,'dd/mm/yyyy') valid_from, to_char(valid_to,'dd/mm/yyyy') valid_to, package_price, availed_price, valid_days, disc_perc_prop_price, disc_perc_curr_price, closed_yn, d.short_desc, c.short_name from bl_package_trn_hdr a, bl_package_hdr b, ar_customer_lang_vw c, bl_package_codes_lang_vw d  where c.language_id='"+locale+"' and d.language_id='"+locale+"' and a.patient_id='"+patient_id+"'  and a.package_bill_doc_type = '"+pkg_bill_type+"' and package_bill_doc_num= 	"+pkg_bill_num+" and a.package_code = b.package_code(+) and a.cust_code =c.cust_code(+) and 		a.package_code = d.package_code(+)");
	}
	else
	{
		pstmt  = con.prepareStatement("select a.package_code, package_bill_doc_type,	package_bill_doc_num, to_char(package_bill_date,'dd/mm/yyyy') package_bill_date, to_char(expiry_date,'dd/mm/yyyy') expiry_date,  a.cust_pc_ind, a.cust_code, to_char(valid_from,'dd/mm/yyyy') valid_from, to_char(valid_to,'dd/mm/yyyy') valid_to, package_price, availed_price, valid_days, disc_perc_prop_price, 	disc_perc_curr_price, closed_yn, d.short_desc, c.short_name from bl_package_trn_hdr a, bl_package_hdr b, bl_emp_ins_mst_lang_vw c, bl_package_codes_lang_vw d  where c.language_id='"+locale+"' and d.language_id='"+locale+"' and a.patient_id='"+patient_id+"' and a.package_bill_doc_type = '"+pkg_bill_type+"' and 			package_bill_doc_num="+pkg_bill_num+" and a.package_code = b.package_code(+) and a.cust_code =c.cust_code(+) and a.package_code = d.package_code(+)");
	}
	try
	{
		rs =  pstmt.executeQuery();
		if (rs!=null)
		{
			CurrencyFormat cf = new CurrencyFormat();
			while(rs.next())
			{
				package_desc =rs.getString("short_desc");
				if(package_desc == null) package_desc ="";
				package_code =rs.getString("package_code");
				if(package_code == null) package_code ="";	
				package_bill_doc_type =rs.getString("package_bill_doc_type");
				if(package_bill_doc_type == null) package_bill_doc_type ="";
				package_bill_doc_num =rs.getString("package_bill_doc_num");
				if(package_bill_doc_num == null) package_bill_doc_num ="";
				package_bill_date =rs.getString("package_bill_date");
				if(package_bill_date == null) package_bill_date ="";
				expiry_date =rs.getString("expiry_date");
				if(expiry_date == null) expiry_date ="";		
				cust_pc_ind = rs.getString("cust_pc_ind") == null ? "" : rs.getString("cust_pc_ind");
				cust_code = rs.getString("cust_code") == null ? "" : rs.getString("cust_code");
				valid_from = rs.getString("valid_from") == null ? "" : rs.getString("valid_from");
				valid_to = rs.getString("valid_to") == null ? "" : rs.getString("valid_to");
				package_price = rs.getString("package_price") == null ? "0" : rs.getString("package_price");
				package_price = cf.formatCurrency(package_price, 2);
				availed_price = rs.getString("availed_price") == null ? "0" : rs.getString("availed_price");
				availed_price = cf.formatCurrency(availed_price, 2);
				valid_days = rs.getString("valid_days") == null ? "0" : rs.getString("valid_days");
				disc_perc_prop_price = rs.getString("disc_perc_prop_price") == null ? "0" : rs.getString("disc_perc_prop_price");
				disc_perc_prop_price = cf.formatCurrency(disc_perc_prop_price, 2);
				disc_perc_curr_price = rs.getString("disc_perc_curr_price") == null ? "0" : rs.getString("disc_perc_curr_price");
				disc_perc_curr_price = cf.formatCurrency(disc_perc_curr_price, 2);
				closed_yn = rs.getString("closed_yn") == null ? "N" : rs.getString("closed_yn");
				cust_name = rs.getString("short_name") == null ? "" : rs.getString("short_name");
				if (!(closed_yn=="N")) chkProp = " checked ";
				if (!(cust_pc_ind=="N")) chkProp1 = " checked ";
			}
		}
	}
	catch(Exception e) { out.println(e.toString());}
	finally 
	{
		 if (pstmt != null) pstmt.close();
		 if (rs != null)   rs.close();
	}	
%>
<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
	<tr>
        <td  class='PATIENTLINECOLOR' width='75%' id='patdetails' style='position:relative;'><%=Pat_Details1%></td>
		<td class='PATIENTLINECOLOR' width='25%' ><img name='nam' src='../../eCommon/images/Status.gif'></img><img name='nam1' src='../../eCommon/images/Status.gif'></img></td>
	</tr>
<table>
<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
<!--
	<tr>
		<td class='label' ></td>
	</tr>
-->
	<tr>
		<td width="25%" class='label' ><fmt:message key="Common.Package.label" bundle="${common_labels}"/></td>
		<td width="25%" class="fields"><input type='text' name='pkg_code' id='pkg_code' size='6' maxlength='6' readonly value="<%=package_code%>"><input type='text' name='pkg_desc' id='pkg_desc' size='15' maxlength='15' readonly value="<%=package_desc%>"></td>
		<td width="25%" ></td>
		<td width="25%" ></td>
	</tr>
	<tr>
		<td width="25%" class='label' ><fmt:message key="eBL.VALID_FROM.label" bundle="${bl_labels}"/></td>
		<td width="25%" class="fields"><input type='text' name='valid_from' id='valid_from' size='10' maxlength='10' readonly value="<%=valid_from%>"></td>
		<td width="25%" class='label' ><fmt:message key="eBL.VALID_TO.label" bundle="${bl_labels}"/></td>
		<td width="25%" class="fields"><input type='text' name='valid_to' id='valid_to' size='10' maxlength='10' readonly value="<%=valid_to%>"></td>
	</tr>
	<tr>
		<td width="25%" class='label' ><fmt:message key="eBL.PKG_BILL_TYPE.label" bundle="${bl_labels}"/></td>
		<td width="25%" class="fields"><input type='text' name='pkg_bill_type' id='pkg_bill_type' size='6' maxlength='6' readonly value="<%=package_bill_doc_type%>"></td>
		<td width="25%" ></td>
		<td width="25%" ></td>
	</tr>
	<tr>
		<td width="25%" class='label' ><fmt:message key="eBL.PKG_PRICE.label" bundle="${bl_labels}"/></td>
		<td width="25%" class="fields"><input type='text' name='pkg_price' id='pkg_price' style='text-align:right' size='12' maxlength='12' readonly value="<%=package_price%>"></td>
		<td width="25%"class='label' ><fmt:message key="eBL.AVAILED_PRICE.label" bundle="${bl_labels}"/></td>
		<td width="25%" class="fields"><input type='text' style='text-align:right' name='availed_price' id='availed_price' size='12' maxlength='12' readonly value="<%=availed_price%>"></td>
	</tr>	
	<tr>
		<td width="25%" class='label' ><fmt:message key="eBL.PKG_BILL_NUM_DATE.label" bundle="${bl_labels}"/></td>
		<td width="25%" class="fields"><input type='text' name='pkg_bill_num' id='pkg_bill_num' style='text-align:right' size='8' maxlength='8' readonly value="<%=package_bill_doc_num%>">&nbsp<input type='text' name='pkg_bill_date' id='pkg_bill_date' size='10' maxlength='10' readonly value="<%=package_bill_date%>"></td>
		<td width="25%" ></td>
		<td width="25%" ></td>
	</tr>
	<tr>
		<td width="25%" class='label' ><fmt:message key="eBL.VALID_DAYS.label" bundle="${bl_labels}"/></td>
		<td width="25%" class="fields"><input type='text' name='valid_days' id='valid_days' style='text-align:right' size='3' maxlength='3' readonly value="<%=valid_days%>"></td>
		<td width="25%" class='label' ><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
		<td width="25%" class="fields"><input type='text' name='expiry_date' id='expiry_date' size='10' maxlength='10' readonly value="<%=expiry_date%>"></td>
	</tr>	
	<tr>
		<td width="25%" class='label' ><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></td>
		<td width="25%" class="fields"><input type='text' name='cust_code' id='cust_code' size='8' maxlength='8' readonly value="<%=cust_code%>"><input type='text' name='cust_name' id='cust_name' size='15' maxlength='15' readonly value="<%=cust_name%>"></td>
		<td width="25%"class='label' ><fmt:message key="eBL.PRICE_CLASS_CUST_SPECIFIC.label" bundle="${bl_labels}"/></td>
		<td width="25%" class="fields" ><input type="checkbox" style='text-align:right' name="cust_pc_ind" id="cust_pc_ind" readonly disabled value="<%=cust_pc_ind%>" <%=chkProp%>></td>		
	</tr>	
	<tr>
		<td width="25%" class='label' ><fmt:message key="eBL.DISC_PERC_ON_PROP_PRICE.label" bundle="${bl_labels}"/></td>
		<td width="25%" class="fields"><input type='text' style='text-align:right' name='disc_perc_prop_price' id='disc_perc_prop_price' size='5' maxlength='5' readonly value="<%=disc_perc_prop_price%>"></td>
		<td width="25%"class='label' ><fmt:message key="eBL.DISC_PERC_ON_CURR_PRICE.label" bundle="${bl_labels}"/></td>
		<td width="25%" class="fields"><input type='text' style='text-align:right' name='disc_perc_curr_price' id='disc_perc_curr_price' size='5' maxlength='5' readonly value="<%=disc_perc_curr_price%>"></td>
	</tr>
	<tr>
		<td width="25%" class='label' ><fmt:message key="eBL.CLOSED_YN.label" bundle="${bl_labels}"/>)</td>
		<td width="25%" class="fields"><input type='checkbox' name='closed_yn' id='closed_yn' readonly disabled value="<%=closed_yn%>" <%=chkProp1%>></td>
		<td width="25%" ></td>
		<td width="25%" ></td>
	</tr>
<!--
	<tr>
		<td width="25%"class='label' ></td>
	</tr>	
-->
</table>
</form>
	<input type= hidden name="locale" id="locale"  value='<%=locale%>'>
</body>
</html>
<%
}
catch(Exception ee)
{
	out.println("Exception in main try"+ee);
}
finally
{
	if(pstmt != null)pstmt.close();
	ConnectionManager.returnConnection(con, request);
}
%>

