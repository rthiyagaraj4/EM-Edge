<!DOCTYPE html>
 <!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
 <!-- Author - kumar: Included as part of PackageDetails.jsp-->
 <%@  page  contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String patient_id = request.getParameter("patient_id");
	String pkg_bill_type = request.getParameter("pkg_bill_type") == null ? "" : request.getParameter("pkg_bill_type");
	String pkg_bill_no = request.getParameter("pkg_bill_no") == null ? "" : request.getParameter("pkg_bill_no");
%>
<html>
<head>
	<title><fmt:message key="eBL.PACKAGE_DTL.label" bundle="${bl_labels}"/></title>
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
	<script language="javascript">
		async function showSelPackage()
		{
			
			var retVal;
			var dialogHeight= "30";
			var dialogWidth	= "50";
			var dialogTop = "75" ;
			var center = "1" ;														   
			var status="no";
			var patient_id = "<%=patient_id%>";
			var pkg_bill_type = "<%=pkg_bill_type%>";
			var pkg_bill_no = "<%=pkg_bill_no%>";
			if (pkg_bill_type.lenth > 0) {
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "" ;
				var url = "dispPackageDetails.jsp?patient_id="+patient_id+"&pkg_bill_type="+pkg_bill_type+"&pkg_bill_no="+			pkg_bill_no;
				retVal =await window.showModalDialog(url,arguments,features);
				//retVal = window.showModalDialog("AddModifyPatFinDetailsMain.jsp",arguments,features);
				if(retVal==null) retVal="";
			}
			//return retVal;
		}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<FORM name = "pkgmain" METHOD=POST ACTION="">
<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
<!--
	<td class='label' colspan='10'>
		&nbsp;
	<td>
	</tr>
-->
<tr>
	<td class='label' width="25%" ><fmt:message key="eBL.PACKAGE_BILL_REF.label" bundle="${bl_labels}"/></td>
	<td width="25%" class="fields"><input type='text' name='package_bill_ref' id='package_bill_ref' size=15 maxlength=15 readonly value="<%=pkg_bill_type%>"><input type='text' name='package_bill_ref1' id='package_bill_ref1' size=15 maxlength=15 readonly value="<%=pkg_bill_no%>"></td>
	<td class="button" width="50%"><input type="button" name="pkg_det" id="pkg_det" value = "<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PACKAGE_DTL.label","bl_labels")%>" class="Button" onClick="showSelPackage();"></td>	
</tr>
<!--
	<tr>
	<td class='label' colspan='10'>
		&nbsp;
	<td>
	</tr>
-->
</table>
</FORM>
</body>
</html>

