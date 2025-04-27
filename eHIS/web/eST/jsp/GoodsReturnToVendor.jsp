<!DOCTYPE html>
 <%@page  import=" eST.*,eST.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'>
	</link> -->
	<script language='javascript' src='../../eST/js/StCommon.js'></script>
	<script language='javascript' src='../../eST/js/GoodsReturnToVendor.js'></script>
 	<!-- <script language='javascript' src='../../eCommon/js/messages.js'></script>
 	<script language='javascript' src='../../eST/js/StMessages.js'></script> -->
	<script language='javascript' src='../../eST/js/StTransaction.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter( "function_id" ) %>"
		menu_id		= "<%= request.getParameter( "menu_id" ) %>"
		module_id	= "<%= request.getParameter( "module_id" ) %>"
    </script>
</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String facilityid=(String)session.getValue("facility_id");

	eST.GoodsReturnToVendorBean bean = (eST.GoodsReturnToVendorBean)getBeanObject( "goodsReturnToVendorBean","eST.GoodsReturnToVendorBean", request);
	bean.setLanguageId(locale);

	// Passing login_facility_id, material_group_code as arguments
	if(!(bean.recordExists(facilityid, "ALL"))) {
		out.println("<script>alert(getMessage('FACILITY_PARAM_NOT_SET','ST'));window.location.href ='../../eCommon/jsp/dmenu.jsp;'</script>");
	}	

	//Adding start for PMG2017-SS-CRF-0002
	HashMap	mm_parameter=(HashMap)bean.fetchRecord("SELECT COUNT(*) TOTAL FROM MM_PARAMETER");
	  if (mm_parameter.get("TOTAL").toString().equals("0")) {
	       out.println("<script>alert(getMessage('PARAMETER_SETUP','ST'));window.location.href ='../../eCommon/jsp/dmenu.jsp;'</script>");
	   }
	   //Adding end for PMG2017-SS-CRF-0002
	//Added for 29970	Bru-HIMS-CRF-095
	String homepage		= request.getParameter("homepage") == null?"N":request.getParameter("homepage");
	String count		= request.getParameter("count") == null?"0":request.getParameter("count");
	String store_code	= request.getParameter("store_code") == null?"":request.getParameter("store_code");

%>
<%
//putObjectInBean("goodsReturnToVendorBean",bean,request);
%>
<frameset rows="42,*,50" >
	<frame name='commontoolbarFrame'	src="<%= source %>" frameborder=0 scrolling='no' noresize>
	<frame name='f_query_add_mod' src="../../eCommon/html/blank.html" frameborder=0 scrolling='no'>
	<frame name='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'>
</frameset>
<%
if(homepage.equals("Y") && !count.equals("0")){
%>
		<script>
				parent.workAreaFrame.f_query_add_mod.document.location.href = "../../eST/jsp/GoodsReturnToVendorQueryFrame.jsp?mode=2&<%=params%>";
		</script>
<%
}
%>
</html>

