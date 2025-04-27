<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String modal_yn=request.getParameter("modal_yn") == null ? "N" : request.getParameter("modal_yn");	
String called_mod=request.getParameter("called_mod") == null ? "N" : request.getParameter("called_mod");	
//out.println("called_mod :"+called_mod);
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script Language="JavaScript" src='../js/ProcedureList.js'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</head>
<!-- Modified by kishore kumar N on 15/12/2008 , size of the frameset -->
<% //String rowsValue="21%,7%,19%,*,0";
	String height1 = "20vh";
	String height2 = "8vh";
	String height3 = "19vh";
	String height4 = "48vh";
	String height5 = "0vh";

	if(called_mod.equals("BL")) {
			//rowsValue="0%,15%,19%,*,8%";
		 height1 = "0vh";
		 height2 = "15vh";
		 height3 = "19vh";
		 height4 = "58vh";
		 height5 = "8vh";
	}
	%>
	
<div class='<%=request.getParameter("cname")%>' >
	<iframe name ='procedurelistquery' id='procedurelistquery'  marginwidth=0 marginheight=0 frameborder=no style='height:<%=height1%>;width:98vw' scrolling='no' noresize  src="../../eCA/jsp/ProcedureListQuery.jsp?modal_yn=<%=modal_yn%>&called_mod=<%=called_mod%>&<%=request.getQueryString()%>" noresize ></iframe>

	<iframe name ='procedurelisttitle' id='procedurelisttitle'  marginwidth=0 marginheight=0 frameborder=no scrolling='no' 
	noresize style='height:<%=height2%>;width:98vw' src="../../eCommon/html/blank.html"></iframe>
	
	<iframe name ='procedurelistresult' id='procedurelistresult'  marginwidth=0 marginheight=0 style='height:<%=height3%>;width:98vw' frameborder=no scrolling='no' noresize src="../../eCommon/html/blank.html"></iframe>			

	<iframe name ='procedurelistresultdetail' id='procedurelistresultdetail'  marginwidth=0 marginheight=0 frameborder=no style='height:<%=height4%>;width:98vw'scrolling='auto' noresize src="../../eCommon/html/blank.html"></iframe>	

	<iframe name ='procedurelistControl' id='procedurelistControl' marginwidth=0 marginheight=0 frameborder=no scrolling='auto' noresize style='height:<%=height5%>;width:98vw' src="PatProblemControl.jsp?called_mod=<%=called_mod%>"></iframe>
</div>
<!-- </frameset>  -->
</html>

