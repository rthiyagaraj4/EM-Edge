<!DOCTYPE html>
<html>
<head><title><fmt:message key="eBL.RateBased.label" bundle="${bl_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String params = request.getQueryString();
	System.out.println("params--."+params);
	//String from	= request.getParameter("from")== null ? "PACKAGE": request.getParameter("from");//unused variable

%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	
</head>

<!--<iframe name='ass_child_pack_hdr' id='ass_child_pack_hdr' src="../../eBL/jsp/AssociateChildPackHdr.jsp" frameborder='0' noresize scrolling='no'>-- style='height:37%;width:100vw'></iframe>-->
<iframe name='ass_child_pack_dtl' id='ass_child_pack_dtl' src="../../eBL/jsp/AssociateChildPkgDtls.jsp?<%=params%>" frameborder='0' noresize scrolling='auto' style='height:8vh;width:100vw'></iframe>
<iframe name='ass_child_pack_btn' id='ass_child_pack_btn' src="../../eBL/jsp/AssociateChildPkgBtn.jsp?<%=params%>&table_name=ass_child_pack_tbl" frameborder='0' noresize scrolling='no' style='height:30vh;width:100vw'></iframe>
</html> 

