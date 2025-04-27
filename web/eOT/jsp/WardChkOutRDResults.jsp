<!DOCTYPE html>
<%@page  import="java.util.HashMap,java.util.ArrayList, eOT.*, eOT.Common.*, eCommon.Common.*" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");	%>



<html>
	<head>
		<title></title>
		<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eOT/js/WardChkOut.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
try{
	String slate_user_id = request.getParameter("slate_user_id");
	String called_from = request.getParameter("called_from");
	
	String bean_id	 = "WardChkOutBean";
	String bean_name = "eOT.WardChkOutBean";
	WardChkOutBean bean	 = (WardChkOutBean)mh.getBeanObject( bean_id, request, bean_name );
	String check_for_check_list_compl = bean.getCheckListReqdYNFlag("22");
	HashMap all_ward_chk_out_dtls = bean.getRDWardChkOutDetails();
	String bookings_type = request.getParameter("bookings_type");
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="WardChkOutResultsForm" id="WardChkOutResultsForm">
	<table border="1" cellpadding="3" cellspacing="0" width="100%" align="center" name="resultTable" id="resultTable" id="resultTable">
	<%
	String 	classvalue="";
	HashMap ward_chk_out_dtls=new HashMap();
	int size = all_ward_chk_out_dtls.size();
	String order_id = "";
	String appt_ref_num = "";
	for (int i=1;i<=size;i++){
		ward_chk_out_dtls=(HashMap)all_ward_chk_out_dtls.get(i+"");
		if ( i % 2 == 0 )
			classvalue = "QRYODD" ;
		else
			classvalue = "QRYEVEN" ;

		order_id = (String)ward_chk_out_dtls.get("order_id");
		appt_ref_num = (String)ward_chk_out_dtls.get("appt_ref_num");
	%>
		<tr>
			<td class="<%=classvalue%>" onClick="displayToolTip('<%=i%>',this);" onMouseOver='hideToolTip();'>
			<font class='HYPERLINK' style="font-size:8pt;color:blue;cursor:pointer;font-weight:normal" width="15%"  > <%=(String)ward_chk_out_dtls.get("patient_id")%>
			</font>					
			</td>

		<td class="<%=classvalue%>" style="font-size:8pt;font-weight:normal;" 		width="26%" wrap><%=(String)ward_chk_out_dtls.get("patient_name")%>
		</td>

		<td class="<%=classvalue%>" style="font-size:8pt;font-weight:normal;" width="15%"><%=CommonBean.checkForNull((String)ward_chk_out_dtls.get("exam_desc"))%>
		</td>

		<td class="<%=classvalue%>" style="font-size:8pt;font-weight:normal;" width="15%"><%=CommonBean.checkForNull((String)ward_chk_out_dtls.get("surgeon_name"))%>
		</td>

		<td class="<%=classvalue%>" style="font-size:8pt;font-weight:normal;" width="6%"><%=(String)ward_chk_out_dtls.get("appt_from_time")%>
		</td>
		<td class="<%=classvalue%>" style="font-size:8pt;font-weight:normal;" width="6%"><%=(String)ward_chk_out_dtls.get("appt_to_time")%>
		</td>
		<td class="<%=classvalue%>" style="font-size:8pt;font-weight:normal;" width="17%" wrap><%=CommonBean.checkForNull((String)ward_chk_out_dtls.get("status_desc"))%>
		</td>

		<input type="hidden" name="patient_id_<%=i%>" id="patient_id_<%=i%>" value="<%=(String)ward_chk_out_dtls.get("patient_id")%>">
		<input type="hidden" name="exam_code_<%=i%>" id="exam_code_<%=i%>" value="<%=(String)ward_chk_out_dtls.get("exam_code")%>">
		<input type="hidden" name="appt_ref_num_<%=i%>" id="appt_ref_num_<%=i%>" value="<%=appt_ref_num%>">
			<input type="hidden" name="order_id_<%=i%>" id="order_id_<%=i%>" value="<%=order_id%>">
			<input type="hidden" name="appt_yn_<%=i%>" id="appt_yn_<%=i%>" value="">

			<input type='hidden' name="checklist_completed_yn_<%=i%>" id="checklist_completed_yn_<%=i%>" value="">
		</tr>
	<%
		}
	%>

	</table>
	<input type="hidden" name="menu_id" id="menu_id" value="<%=request.getParameter("menu_id")%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="slate_user_id" id="slate_user_id" value="<%=slate_user_id%>">
	<input type="hidden" name="user_id" id="user_id" value="<%=session.getValue("login_user")%>">
	<input type="hidden" name="called_from" id="called_from" value="<%=called_from%>">
	<input type="hidden" name="function_id_list" id="function_id_list" value="">		
	<input type="hidden" name="function_name_list" id="function_name_list" value="">		
	<input type="hidden" name="url_desc_list" id="url_desc_list" value="">		
	<input type="hidden" name="facility_id" id="facility_id" value="<%=session.getValue("facility_id")%>">
	<input type='hidden' name="check_for_check_list_compl" id="check_for_check_list_compl" value='<%=check_for_check_list_compl%>' >
	<input type="hidden" name="bookings_type" id="bookings_type" value="<%=bookings_type%>">		
</form>
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>
		<table id='tooltiptable' cellpadding="3" cellspacing=0 border='0'  width='100%' height='100%' align='center'>
			<tr>
				<td width='100%' id='menu_table'></td>
				</td>
			</tr>
		</table>
	</div>

</body>
</html>
<script language="javascript">
// any script code
</script>
<%
		}catch(Exception e){
			out.println(e);
		}
%>

