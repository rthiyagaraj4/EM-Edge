<!DOCTYPE html>
<%@page   import="java.util.HashMap,eOT.Common.*, eOT.*" contentType="text/html;charset=UTF-8" %>

<%-- Mandatory declarations start --%>

<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
//var remarks_value=getLabel("Common.remarks.label","common");

function sendParams(index){
 var formObj=document.forms[0];  
 var str=eval("formObj.resultString"+index+".value");
 //alert(str);
 var frmObj = parent.disposal_record_frame;
 frmObj.splitString(str);
}


function funAssign(){
	//var frmObj=document.DisposalDetailForm;
	//parent.parent.recovery_frame.document.CheckInToRecoveryRoomForm.size.value=frmObj.size.value;
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='DisposalDetailForm' id='DisposalDetailForm' >
<%
	String bean_id = "ChkInOutRecoveryBean";
	String bean_name = "eOT.ChkInOutRecoveryBean";
	ChkInOutRecoveryBean bean = (ChkInOutRecoveryBean) mh.getBeanObject(bean_id, request, bean_name );
	String anatomical_site_code ="";
	String anatomical_site_desc ="";
	String disposal_code="";
	String disposal_desc="";
	String given_by = "";
	String received_by = "";
	String update_insert_flag="";
	String mode="U";
	String code="";
	String queryValue ="";
	String result = "";
	StringBuffer sbr = new StringBuffer();
	int size =0;
	
	HashMap disposal_dtls = bean.getDisposalDtls();

	
%> 
	<table border='1' cellpadding=3  cellspacing='0' width='100%' align='center'>
	<td class='columnHeaderCenter'><fmt:message key="eOT.DisposedItem.Label" bundle="${ot_labels}"/> </td>
	<td class='columnHeaderCenter'><fmt:message key="eOT.Disposal.Label" bundle="${ot_labels}"/> </td>
	<td class='columnHeaderCenter'><fmt:message key="Common.givenby.label" bundle="${common_labels}"/></td>
	<td class='columnHeaderCenter'><fmt:message key="Common.ReceivedBy.label" bundle="${common_labels}"/></td>

<% 
	
	HashMap  hmap = new HashMap();
	size = disposal_dtls.size();
	int actual_size = 0;
	for (int i=1;i<=size;i++){
		hmap = (HashMap)disposal_dtls.get(i+"");
		if(hmap!=null && hmap.size()>0){
			update_insert_flag = (String) hmap.get("update_insert_flag");	
			if(!update_insert_flag.equals("DELETE") && !update_insert_flag.equals("IGNORE")){
				actual_size++;
				anatomical_site_code=(String) hmap.get("anatomical_site_code");
				anatomical_site_desc=(String) hmap.get("anatomical_site_desc");
				disposal_code=(String) hmap.get("disposal_code");
				disposal_desc=(String) hmap.get("disposal_desc");
				given_by = (String) hmap.get("given_by");
				received_by = (String) hmap.get("received_by");
				result = anatomical_site_code+"::"+anatomical_site_desc+"::"+disposal_code+"::"+disposal_desc+"::"+given_by+"::"+received_by+"::"+i+"::"+"U";
				code = anatomical_site_code+disposal_code+",";
				sbr.append(code);
				if(i%2==0)  queryValue = "gridData";
				else queryValue = "gridData";		
	%>
				<tr>

					<td nowrap class='<%=queryValue%>' align='left' width='50%'>
				<input type='hidden'  name='resultString<%=i%>' id='resultString<%=i%>' value="<%=result%>" >
						<a class='gridLink' href="javascript:sendParams(<%=i%>)">
					  <%=anatomical_site_desc%></a></td>
					<td nowrap class='<%=queryValue%>' align='left' width='50%'> <%=disposal_desc%></td>
					<td nowrap class='<%=queryValue%>' align='left' width='50%'> <%=given_by%></td>
					<td nowrap class='<%=queryValue%>' align='left' width='50%'> <%=received_by%></td>
				</tr>			
	<%
			}
		}
	}	
	%>					
</table>	
<input type='hidden' name='code' id='code' value='<%=sbr.toString()%>' >
<input type='hidden' name='size' id='size' value='<%=actual_size%>' >
</form>
</body>
</html>

