<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<%
	String cliniccode="";

	String strd="";
	String sysdate="";
	int dayno=1;
	String f_code_label ="";
	String t_code_label ="";
	String facility_id = (String)session.getValue("facility_id");
	


	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String SQL = "SELECT FACILITY_ID, FACILITY_NAME FROM SM_FACILITY_PARAM ORDER BY 2";
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(SQL);
%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String from_title  =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.from.label","common_labels")+",";
	String to_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.to.label","common_labels")+",";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src="../../eOT/js/OtReports.js" ></script>
<script src="../../eOT/js/repOtCodeCheck.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language="javascript">
	function assignReportId(obj){
		var formObj = document.forms[0];
		var facility_id = formObj.facility_id.value;
		var type=obj.value;
		var fromoperationtype	= getLabel("eOT.OperationType.Label","OT");
		var tooperationtype		= getLabel("eOT.ToOperationType.Label","OT");
		
		if(code=="1"){
			formObj.param1.value="";
			formObj.param1_desc.value="";
			formObj.param2.value="";
			formObj.param2_desc.value="";
			test.innerHTML=""+fromoperationtype+" &nbsp;";
			test1.innerHTML=""+tooperationtype+" &nbsp;";
			//formObj.qry_sql.value="SELECT OPER_ROOM_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM WHERE OPERATING_FACILITY_ID ='"+facility_id+"' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2";
			formObj.qry_sql.value="SELECT OPER_ROOM_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID ='"+facility_id+"' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2";
	}
	}
	
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement()"; onKeyDown = 'lockKey()';  >
<%
	String code=request.getParameter("code");
%>

<form name="menu_form" id="menu_form"  method="post" target="messageFrame">
<div>
  <table border="0" cellpadding=3  cellspacing="0" width="auto" align='center'>
  
	<tr> 
	<td class='label' width="25%"  id="test" nowrap>
		<fmt:message key="eOT.Theatrefrom.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields' width="25%" >
		<input type='hidden' name='param1' id='param1'>
		<input type='text' name='param1_desc' id='param1_desc' size='15'  >
		<input type='button' class='button' value='?' name='CommonLookUp1' id='CommonLookUp1' onClick="searchCode(param1,param1_desc,from_title,document.forms[0].qry_sql.value);" >
	</td>


	<td class='label' width="25%"  id="test1" nowrap>
		<fmt:message key="eOT.ToTheatre.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields' width="25%" >
		<input type='hidden' name='param2' id='param2'>
		<input type='text' name='param2_desc' id='param2_desc' size='15'  >
		<input type='button' class='button' value='?' name='CommonLookUp2' id='CommonLookUp2' onClick="searchCode(param2,param2_desc, to_title,document.forms[0].qry_sql.value);" >
	</td>


</tr>

<tr> 
	<td class='label' width="25%"  nowrap>
		<fmt:message key="eOT.FacilityIDFrom.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields' width="25%" >
	<select name="param5" id="param5" >  
		<option value="">
			<fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<% while(rst.next()){ %>
			<option value='<%=rst.getString(1)%>'> <%=rst.getString(2)%> </option>
		<%   
		}//end of while-loop
		%>
	 </select>
	 </td>
	<td class='label' width="25%" nowrap>
		<fmt:message key="eOT.FacilityIDTo.Label" bundle="${common_labels}"/>
		</option>
	</td>
	<td class='fields' width="25%">
	 <select name="param6" id="param6" >  
		 <option value="">
			<fmt:message key="Common.all.label" bundle="${common_labels}"/>
		 </option>
		<% 
			rst = pstmt.executeQuery();
			while(rst.next()){ 
		%>
			  <option value='<%=rst.getString(1)%>'> <%=rst.getString(2)%> </option>
		<%   
			}//end of while-loop
		%>
	 </select>
	 </td> 
</tr>

<tr> 
	<td class='label' width ="25%" nowrap>
		<fmt:message key="eOT.PrintOption.Label" bundle="${ot_labels}"/> 
	</td>
	<td class="label" width="25%" >
		 <select name="param4" id="param4" >  
		 <option value="A">
			<fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		 <option value="E">
			<fmt:message key="Common.active.label" bundle="${common_labels}"/></option>
		 <option value="D">
			<fmt:message key="Common.Suspend.label" bundle="${common_labels}"/></option>
		 </select>
	 </td>
   <td colspan='2'></td>
</tr>
</table>
</div>

<!-- <input type="hidden" name="qry_sql" id="qry_sql" value="SELECT OPER_ROOM_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM WHERE OPERATING_FACILITY_ID ='<%=facility_id%>' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2" disabled> -->
<input type="hidden" name="qry_sql" id="qry_sql" value="SELECT OPER_ROOM_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID='<%=locale%>' AND OPERATING_FACILITY_ID ='<%=facility_id%>' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2" disabled>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>
<%
}catch(Exception e){
	System.err.println("Err Msg CallReportDetail.jsp "+e.getMessage());
}finally{
	if(rst!=null)rst.close();
	if(pstmt!=null)pstmt.close();
	if(con!=null)
	ConnectionManager.returnConnection(con,request); 
}
%>

