<!DOCTYPE html>
<%-- saved on 26/10/2005 --%>
<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../js/PhMessages.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/TpnUomConst.js"></SCRIPT>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<%
		String mode			= request.getParameter("mode") ;
%>
<iframe name="f_tpn_cons_uom_hdr" id="f_tpn_cons_uom_hdr" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../ePH/jsp/TpnUomConstUOMParameters.jsp?mode=<%=mode%>" style="height:25vh;width:99vw"></iframe>
<iframe name="f_tpn_cons_uom_dtl" id="f_tpn_cons_uom_dtl" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../ePH/jsp/TpnUomConstUOMQuantity.jsp" style="height:70vh;width:99vw"></iframe>
</HTML>

