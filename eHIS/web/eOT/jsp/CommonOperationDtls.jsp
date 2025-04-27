<!DOCTYPE html>
<%@page  import ="eCommon.Common.CommonBean,java.util.HashMap,eOT.*,eOT.Common.*" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script language="javascript">

function sendParams(obj){
	var str = obj.value;
	var frmObj = parent.RecordFrame;
	frmObj.splitString(str);
}
function openDialogWindow(oper_num,index,strVal,obj,obj2,obj3,remarks_size){
	var remarks = encodeURIComponent(obj.value,"UTF-8");
	var chk_status = encodeURIComponent(obj2.value,"UTF-8");
	var cancel_remarks = encodeURIComponent(obj3.value,"UTF-8");
//	var title="Remarks";
	var title = getLabel("eOT.PreOperativeComments.Label","ot");

	window.showModalDialog('../../eOT/jsp/TextArea.jsp?index='+index+'&oper_num='+oper_num+'&cancel_remarks='+cancel_remarks+'&chk_status='+chk_status+'&size='+remarks_size+'&heading='+title,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<form name='OperationDetail' id='OperationDetail'>
<%	
	//String remarks_d =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+",";
	// Modified by DhanasekarV against remarks issue
	//<fmt:message key="eOT.PreOperativeComments.Label" bundle="${ot_labels}"/> 
	String remarks_d =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PreOperativeComments.Label","ot_labels")+",";
	String editable_yn =CommonBean.checkForNull(request.getParameter("editable_yn"));
	String oper_num =CommonBean.checkForNull(request.getParameter("oper_num"));	
	System.err.println("44,CommonOperationDtls.jsp,oper_num===="+oper_num);
	String booking_oper_flag =CommonBean.checkForNull(request.getParameter("booking_oper_flag"));	
	String operation_code ="";
	String operation_desc ="";
	String side_applicable="";
	String remarks="";
	String code="";
	String result="";
	String chk_status="";
	String cancel_remarks="";
	String classValue = "";
	String bean_id = "OTCommonBean";
	String bean_name = "eOT.OTCommonBean";
	OTCommonBean bean = (OTCommonBean)mh.getBeanObject( bean_id, request, bean_name );
	HashMap operation_map = null;
	if(editable_yn.equals("N") && booking_oper_flag.equals("BOOK")){
		//bean.loadBookingDtls(booking_num);
		//operation_map = bean.getBookingDtls();
	}else if(editable_yn.equals("N") && booking_oper_flag.equals("OPER")){
		bean.loadOperationDtls(oper_num);
		operation_map =  bean.getOperationDtls();
	}
%>
<table border='1' cellpadding=3 cellspacing='0' width='100%'>
<tr>
<% 
	//= CommonBean.checkForNull(request.getParameter("title")) 
	// remove this line if the title is paramterised.
%>
	<td class='CAGROUPHEADING'  colspan='6'> 	
		<B>
 		<fmt:message key="eOT.OperationsProcedures.Label" bundle="${ot_labels}"/> 
		</B> 
	</td>
</tr>
<td  class="columnHeader" > 
	<fmt:message key="eOT.OperationCode.Label" bundle="${ot_labels}"/> 
</td>

<td class="columnHeader" > 
	<fmt:message key="Common.description.label" bundle="${common_labels}"/>
</td>
<td class="columnHeader" >
	<fmt:message key="eOT.SideApplicable.Label" bundle="${ot_labels}"/>
</td>

<td class="columnHeader" >
<!-- modified by DhanasekarV against remarks issue 
	<fmt:message key="Common.remarks.label" bundle="${common_labels}"/>
	-->
	<fmt:message key="eOT.PreOperativeComments.Label" bundle="${ot_labels}"/> 
</td>

<td class="columnHeader" >
	<fmt:message key="Common.status.label" bundle="${common_labels}"/>
</td>
<%		
	HashMap  oper_dtls_map = new HashMap();
	int size = operation_map.size();
	int line_num=0;
	for (int i=1;i<=size;i++){
		oper_dtls_map = (HashMap)operation_map.get(i+"");
		if(oper_dtls_map!=null && oper_dtls_map.size()>0){
			operation_code=CommonBean.checkForNull((String) oper_dtls_map.get("operation_code"));
			operation_desc=CommonBean.checkForNull((String) oper_dtls_map.get("operation_desc"));
			side_applicable = CommonBean.checkForNull((String) oper_dtls_map.get("side_applicable"));
			remarks=CommonBean.checkForNull((String) oper_dtls_map.get("remarks"));
			chk_status=CommonBean.checkForNull((String) oper_dtls_map.get("oper_line_status"));
			cancel_remarks=CommonBean.checkForNull((String) oper_dtls_map.get("cancel_remarks"));
			//Dhanasekar Modified on 24/11/2010 against issue  IN025227 
			line_num = Integer.parseInt(CommonBean.checkForNull((String) oper_dtls_map.get("oper_line_num")));
			result=operation_code+"::"+operation_desc+"::"+side_applicable+"::"+remarks+"::"+i+"::"+"U";
			code+=operation_code;

		if(i%2==0)
			classValue = "gridData";
		else
			classValue = "gridData"; 
%>
		<tr>
		<%
			if(editable_yn.equals("Y")){
		%>
			<td class='<%=classValue%>' nowrap >
			<input type="hidden" name="oper_code<%=i%>" id="oper_code<%=i%>" value="<%=result%>">
			<a class='gridLink' href="javascript:sendParams(document.forms[0].oper_code<%=i%>)" >
			<%=operation_code%></a></td>
		<%
			}else if(editable_yn.equals("N")){
		%>
			<td class='<%=classValue%>' nowrap><%=operation_code%>
			</td>
		<%
			}
		%>
		<td class='<%=classValue%>'  nowrap><%=operation_desc%>
		</td>
			<td class='<%=classValue%>' nowrap><%=side_applicable%>
			</td>
			<td class='<%=classValue%>' nowrap>
				<input type="hidden" name="remarks<%=i%>" id="remarks<%=i%>" value="<%=remarks%>" >	
				<input type="hidden" name="chk_status<%=i%>" id="chk_status<%=i%>" value="<%=chk_status%>" >	
				<input type="hidden" name="cancel_remarks<%=i%>" id="cancel_remarks<%=i%>" value="<%=cancel_remarks%>" >	
					<!-- <a class='gridLink' href="javascript:openDialogWindow('<%=remarks_d%>',document.forms[0].remarks<%=i%>,document.forms[0].chk_status<%=i%>,document.forms[0].cancel_remarks<%=i%>);" > -->
					<!--Dhanasekar Modified on 24/11/2010 against issue  IN025227	 -->
					<a class='gridLink' href="javascript:openDialogWindow('<%=oper_num%>','<%=line_num%>','<%=remarks_d%>',document.forms[0].remarks<%=i%>,document.forms[0].chk_status<%=i%>,document.forms[0].cancel_remarks<%=i%>,'2000');" >
						<!-- modified by DhanasekarV against remarks issue 
					<fmt:message key="Common.remarks.label" bundle="${common_labels}"/> -->
					<fmt:message key="eOT.PreOperativeComments.Label" bundle="${ot_labels}"/> 	
					</a>
			</td>
<%if(chk_status.equals("99")) {%>
				<td class='<%=classValue%>' nowrap><img src='../../eCommon/images/RRnwd.gif'></img></td>
				<%}else {%>
				<td class='<%=classValue%>' nowrap>&nbsp;</td>
				<%}%>
		</tr>
		<% } 
		}%>
			
</table>	
<input type='hidden' name='code' id='code' value='<%=code%>' >
<input type='hidden' name='size' id='size' value='<%=size%>' >
<input type='hidden' name='oper_num' id='oper_num' value='<%=oper_num%>' >
</form>
</body>
</html>

