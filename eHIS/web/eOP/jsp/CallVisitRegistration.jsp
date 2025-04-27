<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!--    Function Name VisitRegistration
    Created by M.Sathis Kumar on 13/12/2000 -->

<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language='javascript' src='../../eOP/js/VisitRegistration.js'></script>
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<%
    String callFromMenu_yn  = request.getParameter("callFromMenu_yn");   
    String oper_stn_id  = request.getParameter("oper_stn_id");    
    String patient_id = request.getParameter("patient_id") ;
    if(patient_id  == null) patient_id  = "" ;
    String from_reg = request.getParameter("from_reg") ;
    if(from_reg == null)    from_reg= "N";
	String function_id=(request.getParameter("function_id") == null)?"":request.getParameter("function_id");
	String func_source = (request.getParameter("func_source") == null)?"":request.getParameter("func_source");	
	String disable_pat_reg=(request.getParameter("disable_pat_reg") == null)?"":request.getParameter("disable_pat_reg");
	  String reg_vis_param=(request.getParameter("register_vis_param") == null)?"":request.getParameter("register_vis_param");
	  String register_visit_walkin=(request.getParameter("register_visit_walkin") == null)?"":request.getParameter("register_visit_walkin");
	  String register_visit_referral=(request.getParameter("register_visit_referral") == null)?"":request.getParameter("register_visit_referral");
	  String bl_interface_yn=(request.getParameter("bl_interface_yn") == null)?"":request.getParameter("bl_interface_yn");
	  String or_install_yn=(request.getParameter("or_install_yn") == null)?"":request.getParameter("or_install_yn");
%>

</head>
<body onKeyDown = 'lockKey();'>
    <form name="callvisitregistration" id="callvisitregistration">
        <input type="hidden" name="ct_patient_id" id="ct_patient_id" value="<%=patient_id %>">
        <input type="hidden" name="gen_file_yn" id="gen_file_yn" value="">		
        <input type="hidden" name="error" id="error" value="">
		<input type="hidden" name="disable_pat_reg" id="disable_pat_reg" value="<%=disable_pat_reg%>">
		<input type="hidden" name="reg_vis_param" id="reg_vis_param" value="<%=reg_vis_param%>">
		<input type="hidden" name="register_visit_walkin" id="register_visit_walkin" value="<%=register_visit_walkin%>">
		<input type="hidden" name="register_visit_referral" id="register_visit_referral" value="<%=register_visit_referral%>">
	<script>setTimeout("OpenModel('<%=callFromMenu_yn%>','<%=oper_stn_id%>','<%=patient_id %>','<%=from_reg%>','<%=function_id%>','<%=func_source%>','<%=bl_interface_yn%>','<%=or_install_yn%>')",500)</script>
    </form>	
</body>
</html>

