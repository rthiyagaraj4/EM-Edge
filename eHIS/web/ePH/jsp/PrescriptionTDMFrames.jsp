<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</HEAD>
<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends

	//String url				= "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params			= request.getQueryString() ;
%>
  <!-- <FRAMESET NAME="tdm_frames" id="tdm_frames" ROWS="30,300,*,*,5" FRAMESPACING="0"> -->
    <IFRAME NAME="f_tdm_radio_button" ID="f_tdm_radio_button" FRAMEBORDER="0" NORESIZE SRC="PrescriptionTDMRadioButtons.jsp?<%=params %>" SCROLLING="no" style='height:10vh;width:98vw'></IFRAME>
	<IFRAME NAME="f_tdm_drug_profile" ID="f_tdm_drug_profile" FRAMEBORDER="0" NORESIZE SRC="../../eCommon/html/blank.html" SCROLLING="auto" style='height:19vh;width:98vw'></IFRAME>
	<IFRAME NAME="f_tdm_request" ID="f_tdm_request" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../eCommon/html/blank.html" style='height:29vh;width:100vw'></IFRAME>
	<IFRAME NAME="f_tdm_add_mod" ID="f_tdm_add_mod" FRAMEBORDER="0"  NORESIZE SRC="../../eCommon/html/blank.html" SCROLLING="auto" style='height:29vh;width:100vw'></IFRAME>
	 <IFRAME NAME="f_tdm_buttons" ID="f_tdm_buttons" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="PrescriptionTDMButtons.jsp?<%=params%>" style='height:24vh;width:100vw'></IFRAME>
<!-- </FRAMESET> -->
</HTML>

