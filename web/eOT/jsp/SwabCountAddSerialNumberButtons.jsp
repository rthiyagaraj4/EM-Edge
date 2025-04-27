<!DOCTYPE html>

<%@page  import="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement, eOT.Common.*, eOT.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>

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
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eOT/js/SwabCount.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<%
	String params = request.getQueryString() ;
	String oper_num		= request.getParameter("oper_num");
	String facility_id	= (String) session.getValue("facility_id");
	String login_user	= request.getParameter("slate_user_id");
	String add_new_serial_yn	= request.getParameter("add_new_serial_yn");
	add_new_serial_yn = add_new_serial_yn==null?"N":add_new_serial_yn;
	add_new_serial_yn = add_new_serial_yn.equalsIgnoreCase("null")?"N":add_new_serial_yn;
	int max_serial_number = 1;
	Connection connection  = null;
	PreparedStatement pstmt=null;
	ResultSet resultset =null;
	String result = "",color = "";
	try{
		if(oper_num==null) oper_num="";
		if(oper_num.equalsIgnoreCase("null")) oper_num="";
		String sql = "SELECT MAX(NVL(SWAB_SERIAL_NUMBER,1)) SWAB_SERIAL_NUMBER FROM OT_OPER_SWAB_INSTR_CNT_HDR WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=?";
		connection = ConnectionManager.getConnection(request);
		pstmt=connection.prepareStatement(sql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		resultset=pstmt.executeQuery();
		while(resultset.next()){
			result = resultset.getString("SWAB_SERIAL_NUMBER");
			result=result==null?"":result;
			result=result.equalsIgnoreCase("null")?"":result;
			if(result.equals(""))
				max_serial_number=1;
			else
				max_serial_number=Integer.parseInt(result);
		}
		if(add_new_serial_yn.equals("Y"))
			max_serial_number++;
	}catch(Exception e){
		System.err.println("57: Caught Exception in SwabCountAddSerialNumberButtons Form"+e);
	}finally{
		if(resultset!=null) resultset.close();
		if(pstmt!=null) pstmt.close();	
		try{
			ConnectionManager.returnConnection(connection,request);
		}catch(Exception e1){}
	}
%>
<body  onKeyDown="lockKey()">
<form name="SwabCountAddSerialNumberButtonsForm" id="SwabCountAddSerialNumberButtonsForm" >
	<table border='1' cellpadding=3  cellspacing='0' align='center'  width='100%' >
	<tr>
		<td class="label" width="100%">
			<fmt:message key="eOT.SwabSerialNumbers.Label" bundle="${ot_labels}"/>
		<%
			if(max_serial_number>1){
				for(int i=1;i<=max_serial_number;i++){
					if(i==1)
						color="#BC8F8F";
					else
						color="DARKBLUE";
		%>
					<label style="color:<%=color%>;cursor:pointer;font:bold"  id="serial_<%=i%>"onClick="getSwabCountDetails('<%=i%>')"><%=i%></label>
		<%
				}
			}else{
		%>
				<label class="label"><%=max_serial_number%></label>
		<%
			}
		%>
		</td>
	</tr>		
	</table>
	<input type="hidden" name="params" id="params" value="<%=params%>" >
	<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>" >	
	<input type="hidden" name="max_serial_number" id="max_serial_number" value="<%=max_serial_number%>" >
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">

</form>
</body>
</html>

