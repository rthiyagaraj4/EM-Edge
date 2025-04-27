<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="chiefcomplnt" class="eCA.ChiefComplaintSplty" scope='session'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<%
String sel_ass=request.getParameter("ass_sel");
if(sel_ass!=null && sel_ass.equals("A")){
	
	chiefcomplnt.updateassociatelist(request.getParameter("specialty_code"),request.getParameter("chck"));
}else{	chiefcomplnt.updatespclity(request.getParameter("specialty_code"),request.getParameter("chck"),request.getParameter("spec_desc"));
}
%>

