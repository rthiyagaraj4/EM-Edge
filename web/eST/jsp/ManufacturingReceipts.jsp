<!--<!DOCTYPE html>-->
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<script language='javascript' src="../../eCommon/js/common.js"></script>
<script language='javascript' src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src="../../eST/js/ManufacturingReceipts.js"></script>
<script language='javascript' src="../../eST/js/StCommon.js"></script>
<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");


String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
String params = request.getQueryString() ;
String source = url + params ;
String facilityid=(String)session.getValue("facility_id");

ManufacturingReceiptsBean bean = (ManufacturingReceiptsBean)getBeanObject( "ManufacturingReceiptsBean", "eST.ManufacturingReceiptsBean", request );
bean.setLanguageId(locale);
if(!(bean.recordExists(facilityid, "ALL"))) {
		out.println("<script>alert(getMessage('FACILITY_PARAM_NOT_SET','ST'));window.location.href ='../../eCommon/jsp/dmenu.jsp;'</script>");
	}

//Added for 29970	Bru-HIMS-CRF-095
String homepage		= request.getParameter("homepage") == null?"N":request.getParameter("homepage");
String count		= request.getParameter("count") == null?"0":request.getParameter("count");
String mfg_req_yn	= bean.checkForNull(request.getParameter( "mfg_req_yn" ), "N");//Added by Sakti IN029946 -BRU-HIMS-CRF-080 on 27-NOV-2014 
%>
<!--Added by suresh.r on 11-12-2014 against  BRU-HIMS-CRF-080 beg -->
<%if(mfg_req_yn.equals("Y")) {%>
<title>Manufacturing</title>
<%}%>
<!--Added by suresh.r on 11-12-2014 against  BRU-HIMS-CRF-080 end  -->
<frameset rows='42,*,50'>

<frame name='commontoolbarFrame' id='commontoolbarFrame'	src="<%= source%>"  frameborder=0 scrolling='no' noresize>
<!-- Added by Sakti IN029946 -BRU-HIMS-CRF-080 on 27-NOV-2014 -->
<%if(mfg_req_yn.equals("Y")) {%>
<frame name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../eST/jsp/ManufacturingReceiptsFrame.jsp?<%=params%>">
<%}else{%>
<frame name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0>
<%}%> 
<frame name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'>

<%
putObjectInBean("ManufacturingReceiptsBean",bean,request);
%>
</frameset>
<%
if(homepage.equals("Y") && !count.equals("0")){
%>
		<script>
			parent.workAreaFrame.f_query_add_mod.document.location.href = "../../eST/jsp/ManufacturingReceiptsQueryCriteriaFrame.jsp?mode=2&<%=params%>";
		</script>
<%
}
%>
</html>

