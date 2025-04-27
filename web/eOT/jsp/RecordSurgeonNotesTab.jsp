<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='StyleSheet' href='../../eCommon/html/Tabs.css' type='text/css'/>
</head>
<script language="javascript">
function refresh1(){
	var params = document.forms[0].param.value;
	parent.parent.common_patient_hdr_frame.location.href='../../eOT/jsp/CommonOperDtlsHdr.jsp?'+params;
}
async function callSurgeonNotes(){

	 var formObj = parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	var title=getLabel("eOT.SurgeonNotes.Label","OT");
	var slate_user_id = document.forms[0].slate_user_id.value;
	var facility_id = formObj.facility_id.value;//1
	var patient_id = formObj.patient_id.value;//2
	var episode_id = formObj.episode_id.value;//3
	var patient_class = formObj.patient_class.value;//4
	var encounter_id = formObj.encounter_id.value;//5
	var called_from = "SURGEON_NOTES";//6
	var accession_num=formObj.oper_num.value;//7
	speciality_code=formObj.oper_speciality_code.value;
	var doc_level = formObj.doc_level.value;
	var document_level = formObj.document_level.value;
	var locn_type = "30";//from SURGEON_NOTES Locn type=30;
	var ret="";
	if(document_level=='')
	{
    if(doc_level=='IS')
	{
	ret=confirm(getMessage("APP-OT0132","OT"));
	}
	else if(doc_level=='AS')
	{
		ret=confirm(getMessage("APP-OT0131","OT"));
    }
	}else
	{
		ret=true;
	}
	 if(ret==true)
    {
	formObj.doc_level.disabled=true;
	if(document_level=='')
	{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=updatedoclevel&facility_id="+facility_id+"&oper_num="+accession_num+"&doc_level="+doc_level+"&document_level="+document_level,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText); 
	refresh1();
	}
	var url = "../../eOT/jsp/SelectNoteTypeFrames.jsp?"+ "facility_id="+facility_id+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&encounter_id="+encounter_id+"&called_from="+called_from+"&accession_num="+accession_num+"&speciality_code="+speciality_code+"&locn_type="+locn_type+"&slate_user_id="+slate_user_id;
	var retVal="";
	var dialogHeight = "5" ;
    var dialogWidth  = "20" ;
    var dialogTop    = "200";
    var dialogLeft   = "200";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	var arguments    = "" ;
	retVal 	   = await window.showModalDialog(url, arguments, features);
	}
}
function changeTab(objStr){
	selectTab(objStr);
	var frmObj=document.forms[0];
	var formObjHdr = parent.parent.frames[2].CommonOperDtlsHdrForm;
	var doc_level = formObjHdr.doc_level.value;
	var param=frmObj.param.value+"&tab_id="+objStr;
	if(parent.ChildBaseFrame!=null){
		if(objStr=="notes_tab" && doc_level=="AS"){
			parent.ChildBaseFrame.location.href	='../../eOT/jsp/SurgeonWoundNotesFrames.jsp?'+param
			//callSurgeonNotes();
		}else{
			parent.ChildBaseFrame.location.href	='../../eOT/jsp/SurgeonWoundNotesFrames.jsp?'+param
			parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
		}
	} 	
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="RecordSurgeonNotesTabForm" id="RecordSurgeonNotesTabForm">
<input type='hidden' name='slate_user_id' id='slate_user_id' value='<%=request.getParameter("slate_user_id")%>'>
<table id="tab" cellspacing=0 cellpadding=3  border="0" width='100%'>
<tr>
		
	<td width= "100%" class="white">
	<ul id="tablist" class="tablist" >
		<li class="tablistitem" title='<fmt:message key="Common.notes.label" bundle="${common_labels}"/>' >
			<a class="tabClicked"  onclick="changeTab('notes_tab');" id="notes_tab"> 
				<span class="tabSpanclicked" id="notes_tabspan">
				<fmt:message key="Common.notes.label" bundle="${common_labels}"/>
				</span>
			</a>
		</li>
		<li class="tablistitem" title='<fmt:message key="eOT.WoundDetails.Label" bundle="${ot_labels}"/>' >
			<a class="tabA"  onclick="changeTab('wound_tab');" id="wound_tab"> 
				<span class="tabAspan" id="wound_tabspan">
				<fmt:message key="eOT.WoundDetails.Label" bundle="${ot_labels}"/>
				</span>
			</a>
		</li>
	</ul>
</td>			
</tr>
</table>
<input type='hidden' name='param' id='param' value='<%=request.getQueryString()%>'>
<script>
	changeTab('notes_tab');
</script> 	
</form>
</body>
</html>

