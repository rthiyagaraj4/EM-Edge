<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>

	
	<% 
	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale			= (String)session.getAttribute("LOCALE");
	
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>



<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>


	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../js/AltDispLocn.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<%	String bean_id					=   "AltDispLocnBean" ;
	String bean_name				=	"ePH.AltDispLocnBean";

	if ( bean_id == null || bean_id.equals( "" ) ) 	return ;
	 AltDispLocnBean bean=(AltDispLocnBean)getBeanObject( bean_id, bean_name, request);
	 bean.setLanguageId(locale);
	 bean.clear() ;
	 

	String url = "../../ePH/jsp/AltDispLocnHeader.jsp?" ;
	String function_id	= request.getParameter("function_id") ;
	String mode			= request.getParameter("mode") ;
	String source			="";
	if(mode.equals("2"))
	{
		


		String ord_fcy_id=request.getParameter("facility_id");
		String ord_src_type=request.getParameter("ord_src_type");
		String per_fcy_id=request.getParameter("per_fcy_id");
		String alt_disp_loc=request.getParameter("alt_disp_loc");
		String disp_loc_code=request.getParameter("disp_loc_code");
		String ord_src_code=request.getParameter("ord_src_code");
		String perform_fcy=request.getParameter("perform_fcy");
		String from=request.getParameter("from");
		String to=request.getParameter("to");
		String first_time=request.getParameter("first_time");


		 source		= "&function_id="+function_id+"&mode="+mode+"&ord_fcy_id="+ord_fcy_id+"&ord_src_type="+ord_src_type+"&per_fcy_id="+per_fcy_id+"&alt_disp_loc="+alt_disp_loc+"&disp_loc_code="+disp_loc_code+"&ord_src_code="+ord_src_code+"&perform_fcy="+perform_fcy+"&from="+from+"&to="+to+"&first_time="+first_time+"&order_fcy="+ord_fcy_id;

    
	}else{
	 source		= url+"function_id="+function_id+"&mode="+mode;
	
	}
%>

<%if( mode.equals("1")){%>
	<iframe name="alt_disp_locn_header" id="alt_disp_locn_header" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="<%= source %>" style="height:44vh;width:100vw"></iframe>
	
	  <iframe name="alt_disp_locn_detail" id="alt_disp_locn_detail" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../eCommon/html/blank.html" style="height:55vh;width:100vw"></iframe> 
		  <%}else{%>
		  <iframe name="alt_disp_locn_header" id="alt_disp_locn_header" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../ePH/jsp/AltDispLocnHeader.jsp?<%= source %>"style="height:40vh;width:100vw"></iframe> 
		 <iframe name="alt_disp_locn_detail" id="alt_disp_locn_detail" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../eCommon/html/blank.html"style="height:59vh;width:100vw"></iframe> 
 	 
	  <%}%>



<% putObjectInBean(bean_id,bean,request); %>
</HTML>

