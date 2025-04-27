<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.util.ArrayList,java.util.HashMap,eOT.*,eOT.Common.*,eCommon.XSSRequestWrapper,eCommon.Common.*" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<html>
<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eOT/js/ExamsCheckList.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style type="text/css">
		.menu1 {text-align:left;position:relative;width:860px;}
	</style>
</head>
<%
	int rownum = 0;
	Connection connection	= null;
	PreparedStatement pstmt = null;
	ResultSet resultset		= null;
	String facility_id		= (String) session.getValue("facility_id");
	String user_id			= request.getParameter("slate_user_id");
	String mode				= (String)CommonRepository.getCommonKeyValue("MODE_INSERT") ;
	String params			= request.getQueryString() ;
	String order_id			= request.getParameter("order_id");
	String patient_id		= request.getParameter("patient_id");
	String data_exists		= request.getParameter("data_exists");
	String checklist_completed_yn = request.getParameter("checklist_completed_yn");
	String check_list_code	= request.getParameter("check_list_code");
	ArrayList checklist_details = new ArrayList();
	String sql				= "";
	String disabled= "";
	if(checklist_completed_yn.equals("Y"))
		disabled="disabled";
	HashMap existing_checklist_dtls = new HashMap();
	HashMap temp_checklist_dtls = null;
	String checklist_item_code = "";
	String checklist_remarks = "";
try{
%>
	<body  onKeyDown = 'lockKey()' >
	<form name="ExamsCheckListResultsForm" id="ExamsCheckListResultsForm" method="POST" action="../../servlet/eOT.ExamsCheckListServlet">
<table cellpadding="3" cellspacing="0" align="center" border="1" width="100%">
<%
	connection = ConnectionManager.getConnection(request);
	if(data_exists.equalsIgnoreCase("DATA_EXISTS")){
		sql="SELECT CHECK_LIST_ITEM_CODE, NVL(CHECK_LIST_ITEM_VALUE,'N') CHECK_LIST_ITEM_VALUE,CHECK_LIST_REMARKS FROM RD_REQUEST_CHECK_LSIT_DTL WHERE OPERATING_FACILITY_ID = ? AND CHECK_LIST_REF=? AND CHECK_LIST_SRL='1'";

		if(resultset!=null)resultset.close();
		if(pstmt!=null)pstmt.close();
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,order_id);
		resultset = pstmt.executeQuery();
		while(resultset.next()){
			temp_checklist_dtls = new HashMap();
			checklist_item_code = resultset.getString("CHECK_LIST_ITEM_CODE");
			temp_checklist_dtls.put("checklist_item_code",checklist_item_code);
			temp_checklist_dtls.put("check_list_item_value",resultset.getString("CHECK_LIST_ITEM_VALUE"));
			temp_checklist_dtls.put("check_list_remarks",resultset.getString("CHECK_LIST_REMARKS"));	existing_checklist_dtls.put(checklist_item_code,temp_checklist_dtls);		
		}

		if(resultset!=null)resultset.close();
		if(pstmt!=null)pstmt.close();
	}

	sql="SELECT D.CHECKLIST_CODE CHECKLIST_CODE, D.CHECKLIST_ITEM_CODE CHECKLIST_ITEM_CODE, D.CHECKLIST_ITEM_SRL_NO CHECKLIST_ITEM_SRL_NO, I.DESCRIPTION DESCRIPTION FROM RD_CHECKLIST_DTL D, RD_CHECKLIST_ITEMS I WHERE D.CHECKLIST_ITEM_CODE=I.CHECKLIST_ITEM_CODE AND NVL(STATUS,'E')='E' AND D.CHECKLIST_CODE = ? ORDER BY 2,3 ";
	pstmt = connection.prepareStatement(sql);
	pstmt.setString(1,check_list_code);
	resultset = pstmt.executeQuery();
	while(resultset.next()){
		checklist_details.add(resultset.getString("CHECKLIST_CODE"));
		checklist_details.add(resultset.getString("CHECKLIST_ITEM_CODE"));
		checklist_details.add(resultset.getString("CHECKLIST_ITEM_SRL_NO"));
		checklist_details.add(resultset.getString("DESCRIPTION"));			
	}
	if(resultset!=null)resultset.close();
		if(pstmt!=null)pstmt.close();
}catch(Exception e){
	e.printStackTrace();
	//System.err.println("59:Err Msg in ExamsCheckListResults.jsp"+e.getMessage());
} finally{
	try{
		temp_checklist_dtls = null;
		if(resultset!=null)resultset.close();
		if(pstmt!=null)pstmt.close();
		if(connection!=null)
		ConnectionManager.returnConnection(connection,request);
	}catch(Exception e){e.printStackTrace();}
}

	String classValue = "";
	String dtl_insert_update_flag = "";
	String checklist_value	= "";
	String chkbox_checked	= "";
	checklist_item_code = "";
	if(checklist_details.size()>0){
		for(int row_num=0;row_num<checklist_details.size();row_num+=4){
			rownum++;
			if ( rownum % 2 == 0 )
				classValue = "QRYODD" ;
			else
				classValue = "QRYEVEN" ;

			checklist_item_code = (String)checklist_details.get(row_num+1);
			if(existing_checklist_dtls.size()>0 && (HashMap)existing_checklist_dtls.get(checklist_item_code)!=null){
				checklist_value = (String)((HashMap)existing_checklist_dtls.get(checklist_item_code)). get("check_list_item_value");
				checklist_remarks = (String)((HashMap)existing_checklist_dtls.get(checklist_item_code)). get("check_list_remarks");
				if(checklist_value.equals("Y"))
					chkbox_checked = "checked";
				else
					chkbox_checked = "";
				dtl_insert_update_flag="U";
			}else{
				chkbox_checked = "";
				checklist_value="";
				checklist_remarks = "";
				dtl_insert_update_flag="I";
			}
%>
	<tr>	
			<input type="hidden" name="checklist_code_<%=rownum%>" id="checklist_code_<%=rownum%>" value="<%=(String)checklist_details.get(row_num)%>">
			<input type="hidden" name="checklist_item_code_<%=rownum%>" id="checklist_item_code_<%=rownum%>" value="<%=checklist_item_code%>">
			<input type="hidden" name="checklist_item_srl_no_<%=rownum%>" id="checklist_item_srl_no_<%=rownum%>" value="<%=(String)checklist_details.get(row_num+2)%>">
			<input type="hidden" name="old_remarks_<%=rownum%>" id="old_remarks_<%=rownum%>" value="<%=checklist_remarks%>">
			<input type="hidden" name="new_remarks_<%=rownum%>" id="new_remarks_<%=rownum%>" value="">
			<input type="hidden" name="insert_update_flag_<%=rownum%>" id="insert_update_flag_<%=rownum%>" value="<%=dtl_insert_update_flag%>">
			<input type="hidden" name="description_<%=rownum%>" id="description_<%=rownum%>" value="<%=(String)checklist_details.get(row_num+3)%>" disabled>

			<td class="<%=classValue%>" width="80%" style="font-weight:normal" wrap>
				<%=(String)checklist_details.get(row_num+3)%>
			</td>
			<td class="<%=classValue%>" width="10%">
				<input type="checkbox" name="checkbox_<%=rownum%>" id="checkbox_<%=rownum%>" value="<%=checklist_value%>" onClick="assignCheckBoxValue('<%=rownum%>');" <%=disabled%> <%=chkbox_checked%>>
			</td>
			<td class="<%=classValue%>" width="10%">
				<label style="color:blue;cursor:pointer" onClick="openCheckListRemarksWindow('<%=rownum%>')"> &nbsp;Remarks</label>
			</td>
<%
		}
	}
	existing_checklist_dtls = null;
	temp_checklist_dtls		= null;
%>
</table>
	<input type='hidden' name='params' id='params' value='<%=params%>' >
	<input type='hidden' name='mode' id='mode' value='<%=mode%>' >
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>' >	
	<input type="hidden" name="checklist_user_id" id="checklist_user_id" value="<%=user_id%>">
	<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
	<input type="hidden" name="size" id="size" value="<%=rownum%>">
	<input type="hidden" name="confirm_yn" id="confirm_yn" value="">
	<input type="hidden" name="check_list_code" id="check_list_code" value="<%=check_list_code%>">
	<input type="hidden" name="completed_by_id" id="completed_by_id" value="<%=user_id%>">	
	<input type="hidden" name="checklist_completed_yn" id="checklist_completed_yn" value="<%=checklist_completed_yn%>" disabled>	
<%
	// to check whether data exists or not
	String hdr_insert_update_flag = "";
	if(data_exists.equals("DATA_EXISTS"))
		hdr_insert_update_flag = "U";
	else
		hdr_insert_update_flag = "I";
%>
	<input type="hidden" name="hdr_insert_update_flag" id="hdr_insert_update_flag" value="<%=hdr_insert_update_flag%>">	
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

