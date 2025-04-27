<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<html>
<head>
	<script language='javascript' src='../../eCommon/js/common.js'></script>

    <%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eOT/js/SwabCount.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<%
	Connection connection	= null;
	PreparedStatement pstmt = null;
	ResultSet resultset		= null;
	String order_type_code	= request.getParameter("order_type_code");
	String check_list_code	= "";
	String sql				= "";
	try{
		connection = ConnectionManager.getConnection(request);
		
		sql="SELECT NVL(CHECK_LIST_CODE,'##') CHECK_LIST_CODE FROM RD_SECTION WHERE ORDER_TYPE_CODE=?";
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1,order_type_code);
		resultset = pstmt.executeQuery();
		while(resultset.next()){
			check_list_code = resultset.getString("CHECK_LIST_CODE");
		}	
	}catch(Exception e){
		System.err.println("Err Msg in ExamsCheckListResultsHeader.jsp"+e.getMessage());
	} finally{
		try{
			if(resultset!=null)resultset.close();
			if(pstmt!=null)pstmt.close();
			if(connection!=null)
				ConnectionManager.returnConnection(connection,request);
		}catch(Exception e){}
	}
%>
<body  onKeyDown="lockKey()">
	<form name="ResultsHeaderForm" id="ResultsHeaderForm" >
		<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>">
<%
	if(check_list_code.equals("##")){
%>
	<input type="hidden" name="check_list_code" id="check_list_code" value="">	

<script>
	//alert("CheckList is not associated with this order type."); 
	var msg = getMessage("APP-OT0091","OT");
	alert(msg);
</script>

<%
	}else{
%>
	<table width='98%' cellpadding=3 cellspacing='0' align="centre" border="1">
			<input type="hidden" name="check_list_code" id="check_list_code" value="<%=check_list_code%>">	
			<tr id="swab_count_results_table_row">
				<td class='columnHeaderCenter' width="80%" ><fmt:message key="Common.Items.label" bundle="${common_labels}"/></td>
				<td class='columnHeaderCenter' width="10%"></td>
				<td class='columnHeaderCenter' width="10%"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			</tr>		
	</table>
	</form>
</body>
</html>
<script>
	var formObj = document.ResultsHeaderForm;
	var params=formObj.params.value;
	params = params+"&check_list_code="+formObj.check_list_code.value;
	//alert(params);
	parent.f_query_add_mod.location.href="../../eOT/jsp/ExamsCheckListResults.jsp?"+params;
	parent.f_confirm.location.href="../../eOT/jsp/ExamsCheckListConfirm.jsp?"+params;	
</script>
<%
	}
%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

