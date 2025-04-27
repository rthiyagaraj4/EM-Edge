<!DOCTYPE html>
<%@page import="java.util.ArrayList,java.util.HashMap,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,   eOT.WardChkOutBean" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");	%>


<html>
	<head>
			<script language="Javascript" src="../../eCommon/js/common.js"></script>

		<title></title>
		<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eOT/js/WardChkOut.js"></script>
		<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
			var reason_title=getLabel("Common.reason.label","common");
</script>
</head>
<%			
// Newly Added for IN:41808
String customer_id1="";
String sql_sm_report="select customer_id from SM_SITE_PARAM where rownum = 1";
Connection conn=null;
PreparedStatement pstmt=null;
ResultSet rs=null;
conn = ConnectionManager.getConnection(request);
try{
	pstmt=conn.prepareStatement(sql_sm_report); 
	rs=pstmt.executeQuery();
	if(rs !=null && rs.next())
    {
    customer_id1=checkForNull(rs.getString("customer_id"));
    }	
	if(rs!=null)rs.close();
	if(pstmt!=null)pstmt.close();
	// End for IN:41808
	String slate_user_id = request.getParameter("slate_user_id");
	String called_from = request.getParameter("called_from");
	
	String bean_id	 = "WardChkOutBean";
	String bean_name = "eOT.WardChkOutBean";
	WardChkOutBean bean	 = (WardChkOutBean)mh.getBeanObject( bean_id, request, bean_name );
	String check_for_check_list_compl = bean.getCheckListReqdYNFlag("22");
	HashMap all_ward_chk_out_dtls = bean.getWardChkOutDetails();
	String bookings_type = request.getParameter("bookings_type");	
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="WardChkOutResultsForm" id="WardChkOutResultsForm">
	<table cellpadding=3  cellspacing="0" width="100%" align="center" border="1" id="slate_results_table_header" >
		<tr id="slate_results_table_row1">
			<td class="CAGROUPHEADING" align="left" nowrap>
				<fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/>
			</td>
		</tr>
	</table>
	<table class='grid' cellpadding=3  cellspacing="0" width="100%" align="center" border="1" id="slate_results_table">
		<tr id="slate_results_table_row1">
			<td class="COLUMNHEADER" width="11%" >
				<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
				</td>
				<td  class="COLUMNHEADER" nowrap>
				<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
				</td>
				<td  class="COLUMNHEADER" nowrap>
				<fmt:message key="Common.Procedure.label" bundle="${common_labels}"/>
				</td>
				<td  class="COLUMNHEADER" nowrap>
				<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
				</td>
				<td  class="COLUMNHEADER" nowrap>
				<fmt:message key="Common.from.label" bundle="${common_labels}"/>
				</td>
				<td class="COLUMNHEADER" nowrap>						
					<fmt:message key="Common.to.label" bundle="${common_labels}"/>
				</td>
				<td  class="COLUMNHEADER" nowrap>
					<fmt:message key="Common.status.label" bundle="${common_labels}"/>
				</td>
				<td  class="COLUMNHEADER" nowrap><fmt:message key="eOT.CheckOutTime.Label" 	bundle="${ot_labels}"/>
				</td> 
			</tr>
		<tr></tr>
	<%
	String 	classvalue="";
	HashMap ward_chk_out_dtls=new HashMap();
	int size = all_ward_chk_out_dtls.size();
	//String no_of_verifications = "1";
	/*String role_id_1 = "";
	String role_id_2 = "";
	String role_id_3 = "";
	String role_id_4 = "";*/
	//ArrayList verify_checklist_arr = new ArrayList();
	//ArrayList user_info_arr = new ArrayList();
	//String old_checklist_user_id = "";
	//String checklist_completed_yn = "N";
	String order_id = "";
	String appt_ref_num = "";
	//String verify_checklist_codes="";
	String speciality_code = "";
	String appt_yn = "";
	String oper_status="";
	String disable_flag="";
	String current_time=bean.getSysTime();
	String current_date=bean.getSysDateTime();
	String chk_out_time="";
	
	for (int i=1;i<=size;i++){
		ward_chk_out_dtls=(HashMap)all_ward_chk_out_dtls.get(i+"");
		if ( i % 2 == 0 )
			classvalue = "gridData" ;
		else
			classvalue = "gridData" ;
		oper_status=checkForNull((String)ward_chk_out_dtls.get("oper_status"));
		if(oper_status.equals("35"))
			disable_flag="disabled";
		else
			disable_flag="";

		// to compare the user who already entered the data with the current user
		order_id = (String)ward_chk_out_dtls.get("order_id");
		appt_ref_num = (String)ward_chk_out_dtls.get("appt_ref_num");
		appt_yn = (String)ward_chk_out_dtls.get("appt_yn");
		speciality_code = (String)ward_chk_out_dtls.get("speciality_code");
		//verify_checklist_arr = bean.getOperChecklists(appt_ref_num,"",speciality_code,order_id); 
		/*if(verify_checklist_arr.size()>0){
			verify_checklist_codes=(String)verify_checklist_arr.get(0);
			no_of_verifications = (String)verify_checklist_arr.get(1);
			role_id_1 = (String)verify_checklist_arr.get(2);
			role_id_2 = (String)verify_checklist_arr.get(3);
			role_id_3 = (String)verify_checklist_arr.get(4);
			role_id_4 = (String)verify_checklist_arr.get(5);
		}else{
			verify_checklist_codes="";
			no_of_verifications = "";
			role_id_1 = "";
			role_id_2 = "";
			role_id_3 = "";
			role_id_4 = "";
		}*/
		/*user_info_arr = (ArrayList)bean.getUserInfo(appt_ref_num,"","1",order_id,appt_yn);
		if(user_info_arr.size()>0){
			old_checklist_user_id	= (String)user_info_arr.get(0);
			checklist_completed_yn	= (String)user_info_arr.get(1);
		}else{
			old_checklist_user_id = "";
			checklist_completed_yn = "N";
		}*/
// till here

	%>
		<tr>
			<td width='' style="color: #0000EE;" nowrap id='orderctl<%=i%>' style='cursor:pointer' class='gridDataBlue' 
			onClick="displayToolTip('<%=i%>',this,this,'imgArrow<%=i%>');" onMouseOver='hidemenu();' nowrap>
			<%=(String)ward_chk_out_dtls.get("patient_id")%><img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow<%=i%>'>
			</td>

			<td class="<%=classvalue%>" style="font-size:8pt;font-weight:normal;" nowrap wrap><%=(String)ward_chk_out_dtls.get("patient_name")%>
			</td>

			<td class="<%=classvalue%>" style="font-size:8pt;font-weight:normal;" nowrap><%=checkForNull((String)ward_chk_out_dtls.get("oper_desc"))%>
			</td>

			<td class="<%=classvalue%>" style="font-size:8pt;font-weight:normal;" nowrap><%=checkForNull((String)ward_chk_out_dtls.get("surgeon_name"))%>
			</td>

			<td class="<%=classvalue%>" style="font-size:8pt;font-weight:normal;" nowrap><%=(String)ward_chk_out_dtls.get("appt_from_time")%>
			</td>
			<td class="<%=classvalue%>" style="font-size:8pt;font-weight:normal;" nowrap><%=(String)ward_chk_out_dtls.get("appt_to_time")%>
			</td>
			<!-- <td class="<%=classvalue%>" style="font-size:8pt;font-weight:normal;" width="14%" wrap><%=checkForNull((String)ward_chk_out_dtls.get("status_desc"))%>
			</td> -->
			<%
			out.println("<input type='hidden' name='reason"+i+"' id='reason"+i+"' value=\""+"Case Called Time: "+checkForNull((String)ward_chk_out_dtls.get("case_called_time"))+"\" >");
			%>
			
			<td class="<%=classvalue%>" nowrap>
				 <img src='../../eOT/images/drugInfo.gif' OnMouseOver="reasonToolTip3('reason',<%=i%>);" onMouseOut="hideToolTip();" style="font-size:8pt;font-weight:normal;" ><%=checkForNull((String)ward_chk_out_dtls.get("status_desc"))%>
			</td> 


			<!-- <td  class="<%=classvalue%>" style="font-size:8pt;font-weight:normal;" width="7%" wrap>
			</td> -->
		<%
			chk_out_time=checkForNull((String)ward_chk_out_dtls.get("check_out_from_ward_time"));
				//if(chk_out_time.equals(""))
				//chk_out_time=current_time;

		%>

			<td class='Label' >
				<input type='text'  size="9%" maxlength=5 name='check_out_time_<%=i%>' id='check_out_time_<%=i%>' value="<%=chk_out_time%>" <%=disable_flag%> onblur='chkTimeFormat(this)' onfocus="getSysTime(this);">
			</td>

			<input type="hidden" name="patient_id_<%=i%>" id="patient_id_<%=i%>" value="<%=(String)ward_chk_out_dtls.get("patient_id")%>">
			<input type="hidden" name="oper_code_<%=i%>" id="oper_code_<%=i%>" value="<%=(String)ward_chk_out_dtls.get("primary_oper_code")%>">
			<input type="hidden" name="oper_status_<%=i%>" id="oper_status_<%=i%>" value="<%=(String)ward_chk_out_dtls.get("oper_status")%>">
			<input type="hidden" name="appt_ref_num_<%=i%>" id="appt_ref_num_<%=i%>" value="<%=appt_ref_num%>">
			<input type="hidden" name="order_id_<%=i%>" id="order_id_<%=i%>" value="<%=order_id%>">
			<input type="hidden" name="speciality_code_<%=i%>" id="speciality_code_<%=i%>" value="<%=speciality_code%>">
			<input type="hidden" name="appt_yn_<%=i%>" id="appt_yn_<%=i%>" value="<%=appt_yn%>">
			<input type='hidden' name="case_called_time_<%=i%>" id="case_called_time_<%=i%>" value="<%=checkForNull((String)ward_chk_out_dtls.get("case_called_time"))%>">
				<%/*hidden fields of role id and related tags are removed if u nedd it pls add it.... */%>
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
	<input type="hidden" name="current_time" id="current_time" value="<%=current_time%>">	
	<input type="hidden" name="current_date" id="current_date" value="<%=current_date%>">	
	<input type="hidden" name="customer_id1" id="customer_id1" value="<%=customer_id1%>">	

	
</form>
	<div name='tooltiplayer3' id='tooltiplayer3' style='position:absolute; width:21%; visibility:hidden;' bgcolor='blue'> 
	</div>
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>
		<table id='tooltiptable' cellpadding=3 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
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
		finally{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null)ConnectionManager.returnConnection(conn,request);
	}
%>

