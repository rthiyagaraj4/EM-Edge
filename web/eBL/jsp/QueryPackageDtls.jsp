<!DOCTYPE html>
 <!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
 <%@  page  contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!-- Author - kumar: Included as part of QueryPackageDetails-->
<%@ page import="java.sql.*, webbeans.eCommon.*"  %>
<html>
<%
		Connection con = null;
		Statement stmt = null;
		ResultSet rs =null;			

		String locale	= (String)session.getAttribute("LOCALE");

	try
	{
		con	=	ConnectionManager.getConnection(request);
		request.setCharacterEncoding("UTF-8");
		String class_val = "QRYEVEN";
		String package_desc = "";
		String package_code = "";
		String package_bill_doc_type = "";
		String package_bill_doc_num = "";
		String package_bill_date = "";
		String expiry_date = "";

		String patient_id = request.getParameter("patient_id");
		String mode = request.getParameter("mode");
		if (mode==null) mode="";		
		String qrystr = request.getQueryString();
		if (patient_id==null) patient_id="";
		//out.println("patient_id "+patient_id);
%>

<head>
	<title><fmt:message key="eBL.AVAILABLE_PACKAGE.label" bundle="${bl_labels}"/></title>
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



	<script>
			function showSelected(patient_id, package_code, pkg_bill_type,pkg_bill_no)
			{				
//				alert('The Package "'+package_code+ '" is selected');
				alert((getMessage('BL9543','BL'))+package_code);

				var returnString;
				returnString = ""+pkg_bill_type + ","+ pkg_bill_no;
				parent.frames[0].document.forms[0].qryStr.value = returnString;	
				parent.window.returnValue=parent.frames[0].document.forms[0].qryStr.value; 
				parent.window.close();
			}

			async function showModal(patient_id, pkg_bill_type,pkg_bill_no)
			{				
				var retVal = 	"";
				var jsp_name="dispPackageDetails.jsp";
				var dialogHeight= "30";
				var dialogWidth	= "50";
				var dialogTop = "75" ;
				var center = "1" ;														   
				var status="no";

				//var queryString = '<%=qrystr%>';
				//queryString += 	"&pkg_bill_type="+pkg_bill_type+"&pkg_bill_no="+pkg_bill_no;
				var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "" ;	
				retVal=await window.showModalDialog(""+jsp_name+"?patient_id="+patient_id+"&pkg_bill_type="+pkg_bill_type+"&pkg_bill_no="+pkg_bill_no,arguments,features);
				/*var returnString;
				returnString = pkg_bill_type + ","+ pkg_bill_no;
				parent.frames[0].document.forms[0].qryStr.value = returnString;	*/
			}
	</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="pkgdtls" id="pkgdtls">
<%
		String sql  = "select b.short_desc short_desc, a.package_code package_code, package_bill_doc_type, 												package_bill_doc_num, to_char(package_bill_date,'dd/mm/yyyy') package_bill_date, to_char(expiry_date,'dd/mm/yyyy') expiry_date from bl_package_trn_hdr a, bl_package_codes_lang_vw b where b.language_id='"+locale+"' and a.patient_id = '"+patient_id+"' and 	a.package_code = b.package_code and nvl(a.expiry_date, trunc(Sysdate)) >= trunc(sysdate)";

		if (mode.equals("OP")	)
			sql =sql + " and nvl(a.closed_yn, 'N') not 	in ('A','O') and nvl(b.apply_to,'N') in ('B','O')";
		else if (mode.equals("IP"))
			sql =sql+ " and nvl(a.closed_yn, 'N') not 	in ('A','I') and nvl(b.apply_to,'N') in ('B','I')";
		else
			sql =sql+ " and nvl(a.closed_yn, 'N') not 	in ('A','I','O') and nvl(b.apply_to,'N') in ('B','I','O')";
		
	
		out.println(" <table cellspacing=0 cellpadding=0 align='center' width='100%' border='1' cellpadding=0 cellspacing=0>");
			out.println("<tr>");
/*
				out.println("<th>&nbsp;&nbsp;</th>");
				out.println("<th>Description</th>");
				out.println("<th>Package Code</th>");
				out.println("<th>Bill Doc Type</th>");
				out.println("<th>Bill Doc No</th>");
				out.println("<th>Bill Date</th>");
				out.println("<th>Expiry Date</th>");
*/
				out.println("<th>&nbsp;&nbsp;</th>");
				out.println("<td class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label" ,"common_labels")+"</td>");
				out.println("<td class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PackageCode.label" ,"common_labels")+"</td>");
				out.println("<td class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.BILL_DOC_TYPE.label" ,"bl_labels")+"</td>");
				out.println("<td class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.BILL_DOC_NO.label" ,"bl_labels")+"</td>");
				out.println("<td class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.BILL_DATE.label" ,"bl_labels")+"</td>");
				out.println("<td class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label" ,"common_labels")+"</td>");
			out.println("</tr>"); 
			try 
			{
				stmt = con.createStatement();
				rs= stmt. executeQuery(sql);
				if(rs!=null)
				{
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

						if(class_val.equals("QRYEVEN"))
							class_val = "QRYODD";
						else
							class_val = "QRYEVEN";
								
						out.println("<tr>");
						out.println("<td class='"+class_val+"'> ");
						out.print("<a href=\"javascript:showModal('"+patient_id+"','"+package_bill_doc_type+"','"+package_bill_doc_num+"')\">");
						out.print("+</a></td>" );
						out.println("<td class='"+class_val+"'>");
						out.print("<a href=\"javascript:showSelected('"+patient_id+"','"+package_desc+"','"+package_bill_doc_type+"','"+package_bill_doc_num+"')\">");
						out.print(""+package_desc+"</a></td>" );
						//out.println("<td class='"+class_val+"'>"+package_desc+"</td>");
						out.println("<td class='"+class_val+"'>"+package_code+"</td>");
						out.println("<td class='"+class_val+"'>"+package_bill_doc_type+"</td>");
						out.println("<td class='"+class_val+"' align='right'>"+package_bill_doc_num+"</td>");
						out.println("<td class='"+class_val+"'>"+package_bill_date+"</td>");
						out.println("<td class='"+class_val+"'>"+expiry_date+"</td>");
						out.println("</tr>");
					}
				}
			}
			catch(Exception e) { out.println(e.toString());}
			out.println("</table>");			
%>
<input type='hidden' name='qryStr' id='qryStr' value=''>
<input type= hidden name="locale" id="locale"  value='<%=locale%>'>
</form>
</body>
</html>
<%
}catch(Exception ee) { out.println(ee.toString());}
finally 
{
	if (rs != null)   rs.close();
	if (stmt != null) stmt.close();
	ConnectionManager.returnConnection(con, request);
}
%>

