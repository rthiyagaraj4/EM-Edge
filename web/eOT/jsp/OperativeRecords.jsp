<!DOCTYPE html>
<%//@include file="../../eCommon/jsp/Common.jsp" %>
<%@page  contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@page  import ="eCommon.Common.CommonBean"  %>

<html>
<head>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<Script Language="JavaScript" src="../../eOT/js/SurgeryHistory.js"></Script>
<script language="javascript">
async function callOperativeNotes(facility_id,patient_id,episode_id,patient_class,encounter_id,slate_user_id,accession_num){
	//alert("U N D E R C O N S T R U C T I O N");
	//var title="Nursing Notes";
	var title=getlabel("eOT.NursingNotes.Label","OT");;
	//var called_from = "OPERATIVE_NOTES";//6
	var called_from = "OPERATIVE_NOTES";
	var speciality_code="";
	var locn_type = "";
	var params="facility_id="+facility_id+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&encounter_id="+encounter_id+"&called_from="+called_from+"&accession_num="+accession_num+"&speciality_code="+speciality_code+"&locn_type="+locn_type+"qurey_flag_yn=Y&slate_user_id="+slate_user_id;
	var url = "../../eOT/jsp/SelectNoteTypeFrames.jsp?"+params; 
	//document.location.href=url;
	
	var retVal;
	var dialogHeight = "5";
    var dialogWidth  = "20";
    var dialogTop    = "200";
    var dialogLeft   = "200";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	var arguments    = "" ;
	retVal 	   = await window.showModalDialog(url, arguments, features);
}
</script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='OperativeRecordsForm' id='OperativeRecordsForm'>
<% 
	String accession_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
	String patient_id = CommonBean.checkForNull(request.getParameter("patient_id"));
	String patient_class = CommonBean.checkForNull(request.getParameter("patient_class"));
	String encounter_id = CommonBean.checkForNull(request.getParameter("encounter_id"));
	String episode_id = CommonBean.checkForNull(request.getParameter("episode_id"));
	String slate_user_id = CommonBean.checkForNull(request.getParameter("slate_user_id"));
out.println("<script>callOperativeNotes('"+facility_id+"','"+patient_id+"','"+episode_id+"','"+patient_class+"','"+encounter_id+"','"+slate_user_id+"','"+accession_num+"')"+"</script>");
	
%>

