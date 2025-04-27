<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*,eOT.Common.*, eOT.*,eCommon.Common.*" contentType=" text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>

<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
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
	<script type='text/javascript' src='../../eOT/js/OTCommon.js'></script>

	<!-- <Script Language="JavaScript" src="../../eCommon/js/messages.js"></Script>
	<script src="../../eOT/js/OTMessages.js" language="javascript"></script> -->
<script language="javascript">
var actionRemarks_value =encodeURIComponent(getLabel("Common.ActionRemarks.label","Common"));
var generalRemarks_value =encodeURIComponent(getLabel("Common.generalRemarks.label","Common"));
function openDialogWindow(strVal,obj){
	
   var remarks =encodeURIComponent(obj.value);
   window.showModalDialog('../../eOT/jsp/TextArea.jsp?heading='+strVal+'&remarks='+remarks,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='SurgeryHistoryUntowardEvtDetailForm' id='SurgeryHistoryUntowardEvtDetailForm'>
<table border='1' cellpadding='3' cellspacing='0' width='100%'>
<th align='Center'><fmt:message key="eOT.UntowardEvent.Label" bundle="${ot_labels}"/></th>
<th align='Center'><fmt:message key="Common.ActionRemarks.label" bundle="${common_labels}"/></th>
<th align='Center'><fmt:message key="Common.generalRemarks.label" bundle="${common_labels}"/></th>

<% 

	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	//String SQL="SELECT B.SHORT_DESC,A.ACTION_REMARKS,A.GEN_REMARKS FROM OT_POST_OPER_UNTOWARD A,OT_UNUSUAL_OCCUR_CODE B WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND A.UNUSUAL_OCCUR_CODE = B.UNUSUAL_OCCUR_CODE";

	String SQL="SELECT B.SHORT_DESC,A.ACTION_REMARKS,A.GEN_REMARKS FROM OT_POST_OPER_UNTOWARD A,OT_UNUSUAL_OCCUR_CODE_LANG_VW B WHERE B.LANGUAGE_ID='"+locale+"' AND A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND A.UNUSUAL_OCCUR_CODE = B.UNUSUAL_OCCUR_CODE";
	String queryValue="";
	String unusual_occur_desc="";
	String general_remarks="";
	String action_remarks="";
	
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(SQL);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();
		int index=0;
		while(rst.next()){
			++index;
			unusual_occur_desc=rst.getString(1);
			action_remarks=rst.getString(2);
			general_remarks=rst.getString(3);
			queryValue=(index%2==0)?"QRYEVEN":"QRYODD";
		
%>
	<tr>
	<td class='<%=queryValue%>'><%=unusual_occur_desc%></td>
	<td class='<%=queryValue%>'>
	<input type="hidden" name="action_remarks<%=index%>" id="action_remarks<%=index%>" value="<%=action_remarks%>" >
	<a href="javascript:openDialogWindow(actionRemarks_value,document.forms[0].action_remarks<%=index%>);" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a>
	<td class='<%=queryValue%>' align='left' width='25%'>
	<input type="hidden" name="general_remarks<%=index%>" id="general_remarks<%=index%>" value="<%=general_remarks%>" >
	<a href="javascript:openDialogWindow(generalRemarks_value,document.forms[0].general_remarks<%=index%>);" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a>
	</tr>
<%	
		}
	}catch(Exception e){
		 System.err.println("Err Msg in SurgeryHistoryUnusualOccur.jsp "+e.getMessage());
	}finally{
		try{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
	
%>
</table>	
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

</form>
</body>
</html>

