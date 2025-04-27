<!DOCTYPE html>
<%@page  import="java.util.HashMap,webbeans.eCommon.*,eCommon.XSSRequestWrapper,eOT.Common.*, eOT.*"  %>
<%@page  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eOT/js/CheckInOutRecoveryRoom.js"></script>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
	<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="javascript">
function funAssign(){
	//var frmObj=document.UntowardEvtDetailForm;
	//parent.parent.recovery_frame.document.CheckInToRecoveryRoomForm.size1.value=frmObj.size.value;
}

function sendParams(index){
  //var str = code+'::'+desc+'::'+rem1+'::'+rem2+'::'+rowid+'::'+mode;
  var formObj=document.forms[0];  
  var postop_done_yn = formObj.postop_done_yn.value;
  if(postop_done_yn=="Y") return;
 var str=eval("formObj.resultString"+index+".value");
 //alert(str)
  var frmObj = parent.untowards_evt_record_frame;
  frmObj.splitString(str);
 
}

//function openDialogWindow(strVal,obj){
function openDialogWindow(strVal,obj,remarks_size){
   var remarks = encodeURIComponent(obj.value);
   //window.showModalDialog('../../eOT/jsp/TextArea.jsp?heading='+encodeURIComponent(strVal)+'&remarks='+remarks,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
   window.showModalDialog('../../eOT/jsp/TextArea.jsp?heading='+encodeURIComponent(strVal)+'&remarks='+remarks+'&size='+remarks_size,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<form name='UntowardEvtDetailForm' id='UntowardEvtDetailForm'>
<%

	String postop_done_yn = checkForNull(request.getParameter("postop_done_yn"),"N");
	String bean_id = "ChkInOutRecoveryBean";
	String bean_name = "eOT.ChkInOutRecoveryBean";
	ChkInOutRecoveryBean bean = (ChkInOutRecoveryBean) mh.getBeanObject(bean_id, request, bean_name );
	String unusual_occur_code ="";
	String unusual_occur_desc ="";
	String general_remarks="";
	String action_remarks="";
	String code="";
	String queryValue ="";
	String result="";
	int size=0;
	
	HashMap untoward_evt = bean.getUntowardEventsDtls();
	
	
	%> 
<table border='1' cellpadding='3' cellspacing='0' width='100%'>
	<td class="columnHeaderCenter" ><fmt:message key="eOT.UntowardEvent.Label" bundle="${ot_labels}"/></td>
	<td class="columnHeaderCenter" ><fmt:message key="Common.ActionRemarks.label" bundle="${common_labels}"/></td>
	<td class="columnHeaderCenter" ><fmt:message key="Common.generalRemarks.label" bundle="${common_labels}"/></td>

<% 
	HashMap  hmap = new HashMap();
	size = untoward_evt.size();
	for (int i=1;i<=size;i++){
		hmap = (HashMap)untoward_evt.get(i+"");
		if(hmap!=null && hmap.size()>0){
			if(!"D".equals((String) hmap.get("db_mode")) ){
			unusual_occur_code=(String) hmap.get("unusual_occur_code");
			unusual_occur_desc=(String) hmap.get("unusual_occur_desc");
			action_remarks=(String) hmap.get("action_remarks");
			general_remarks=(String) hmap.get("general_remarks");
			result = unusual_occur_code+"::"+unusual_occur_desc+"::"+action_remarks+"::"+general_remarks+"::"+i+"::"+"U";
			code+=unusual_occur_code;
			if(i%2==0)  queryValue = "gridData";
			else queryValue = "gridData";
		
%>
	<tr>
		<input type='hidden'  name='resultString<%=i%>' id='resultString<%=i%>' value="<%=result%>" >
	<% if("Y".equals(postop_done_yn)){ %>
			<td class='gridData' width='25%' disabled><%=unusual_occur_desc%>  </td>	
	<%}else{%>
	<td class='gridData' width='25%'>
			<a class="gridLink" href="javascript:sendParams(<%=i%>)"  ><%=unusual_occur_desc%></a> 
	<%}%>
	</td>
	<td class='gridData' width='25%'>
		<input type="hidden" name="action_remarks<%=i%>" id="action_remarks<%=i%>" value="<%=action_remarks%>" >
		<!-- <a class="gridLink" href="javascript:openDialogWindow('<fmt:message key='Common.ActionRemarks.label' bundle='${common_labels}'/>',document.forms[0].action_remarks<%=i%>);" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/> -->
		<a class="gridLink" href="javascript:openDialogWindow('<fmt:message key='Common.ActionRemarks.label' bundle='${common_labels}'/>',document.forms[0].action_remarks<%=i%>,'30');" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>
		</a>
	<td class='gridData' width='25%'>
		<input type="hidden" name="general_remarks<%=i%>" id="general_remarks<%=i%>" value="<%=general_remarks%>" >
		<!-- <a class="gridLink" href="javascript:openDialogWindow('<fmt:message key='Common.ActionRemarks.label' bundle='${common_labels}'/>',document.forms[0].general_remarks<%=i%>);" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a> -->
		<a class="gridLink" href="javascript:openDialogWindow('<fmt:message key='Common.generalRemarks.label' bundle='${common_labels}'/>',document.forms[0].general_remarks<%=i%>,'30');" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a>
	</td>
</tr>
<%}}}%>		
</table>	
	<input type='hidden' name='code' id='code' value='<%=code%>' >
	<input type='hidden' name='size' id='size' value='<%=size%>' >
	<input type='hidden' name='postop_done_yn' id='postop_done_yn' value='<%=postop_done_yn%>' >
</form>
</body>
</html>

