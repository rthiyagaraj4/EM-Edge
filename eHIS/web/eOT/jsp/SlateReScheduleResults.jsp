<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%//@page contentType="text/html;charset=" import="java.util.*, eOT.*, eOT.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%@page  import ="eOT.*, eOT.Common.*, eCommon.Common.CommonBean,java.util.HashMap" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title></title>
			<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eOT/js/Slate.js"></script>
		<script language="Javascript" src="../../eOT/js/SlateReSchedule.js"></script>

		<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<!--<script language="Javascript" src="../../eOT/js/OTMessages.js"></script>-->
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<style>
		 TD.OTMENULAYER
		  {
	 	  FONT-FAMILY: VERDANA ;
	 	  FONT-SIZE: 8PT ;
	 	  BACKGROUND-COLOR: #D8BFD8;
	 	  COLOR: WHITE;
		}
		TD.OTMENU
		  {
			BACKGROUND-COLOR: #C0C0C0 ;
			FONT-SIZE: 9PT ;
			BORDER-STYLE: DASHED;
			BORDER-LEFT-COLOR: #FFA500;
			BORDER-RIGHT-COLOR: #FFA500;
			BORDER-TOP-COLOR: #FFFACD;
			BORDER-BOTTOM-COLOR: #FFFACD;
		  }
		TD.OTCLASS{
			FONT-SIZE: 9pt ;
			BORDER-STYLE: SOLID;
			border-left-color: #B2B6D7;
			border-right-color: #B2B6D7;
			border-top-color: #E2E3F0;
			border-bottom-color: #E2E3F0;
			height:18;	
			   }
		</style>

</head>
<%
try{
	String facility_id	= (String) session.getValue("facility_id");
	String bean_id	 = "SlateBean";
	String bean_name = "eOT.SlateBean";
	SlateBean bean	 = (SlateBean)mh.getBeanObject( bean_id, request, bean_name );
	HashMap all_reschedule_details = bean.getReScheduleDetails();
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="SlateSchSearchResultForm" id="SlateSchSearchResultForm">
	<table border="1" cellpadding="3" cellspacing="0" width="100%" align="center" name="resultTable" id="resultTable" id="resultTable">
	<%
	String classValue = "";
	HashMap reschedule_details=new HashMap();
	int size = all_reschedule_details.size();
	for (int i=1;i<=size;i++){
		reschedule_details=(HashMap)all_reschedule_details.get(i+"");
		if ( i % 2 == 0 )
			classValue = "QRYODD" ;
		else
			classValue = "QRYEVEN" ;
	%>
		<tr >	
			<td class='<%=classValue%>' 														onClick="displayToolTipReshedule('<%=facility_id%>','<%=reschedule_details.get("patient_id")%>','<%=reschedule_details.get("patient_name")%>','<%=reschedule_details.get("sex")%>','<%=reschedule_details.get("date_of_birth")%>','<%=reschedule_details.get("appt_ref_num")%>','<%=reschedule_details.get("surgeon_code")%>','<%=reschedule_details.get("surgeon_name")%>','<%=reschedule_details.get("speciality_code")%>','<%=reschedule_details.get("speciality_desc")%>');"  width='20%' onMouseOver='hideToolTip();'>
			<font class='HYPERLINK' style="font-size:8pt;color:blue;cursor:pointer;font-weight:normal" > &nbsp;<%=reschedule_details.get("patient_id")%></font>				
			</td>
			<!-- <td class="<%=classValue%>" onClick="displayToolTip('<%=i%>',this,'RESCHEDULE');" onMouseOver='hideToolTip();'>
				<font class='HYPERLINK' style="font-size:7pt;color:blue;cursor:pointer;font-weight:normal" width="20%"  > <%=(String)reschedule_details.get("patient_id")%></font>					
			</td> -->

			<td class="<%=classValue%>" style="font-size:7pt;font-weight:normal" width="26%" wrap>
				<%=(String)reschedule_details.get("patient_name")%>
			</td>
			<td class="<%=classValue%>" style="font-size:7pt;font-weight:normal" width="10%">
				<%=CommonBean.checkForNull((String)reschedule_details.get("oper_room_desc"))%>
			</td>
			<td class="<%=classValue%>" style="font-size:7pt;font-weight:normal" width="12%">
				<%=CommonBean.checkForNull((String)reschedule_details.get("surgeon_name"))%>
			</td>
			<td class="<%=classValue%>" style="font-size:7pt;font-weight:normal" width="12%">
				<%=CommonBean.checkForNull((String)reschedule_details.get("speciality_desc"))%>
			</td>
			<td class="<%=classValue%>" style="font-size:7pt;font-weight:normal" width="15%">
			<%=CommonBean.checkForNull((String)reschedule_details.get("oper_desc"))%>
			
			</td>
			<td class="<%=classValue%>" width="3%">
				<input type="checkbox" name = "select_checkbox_<%=i%>" value=""
			>
			</td>

			<input type="hidden" name="patient_id_<%=i%>" id="patient_id_<%=i%>" value="<%=(String)reschedule_details.get("patient_id")%>">
			<input type="hidden" name="order_id_<%=i%>" id="order_id_<%=i%>" value="<%=(String)reschedule_details.get("order_id")%>">
			<input type="hidden" name="speciality_code_<%=i%>" id="speciality_code_<%=i%>" value="<%=(String)reschedule_details.get("speciality_code")%>">
			<input type="hidden" name="surgeon_code_<%=i%>" id="surgeon_code_<%=i%>" value="<%=(String)reschedule_details.get("surgeon_code")%>">
			<input type="hidden" name="surgery_type_<%=i%>" id="surgery_type_<%=i%>" value="<%=(String)reschedule_details.get("surgery_type")%>">
			
			<input type="hidden" name="appt_ref_num<%=i%>" id="appt_ref_num<%=i%>" value="<%=(String)reschedule_details.get("appt_ref_num")%>">

			<input type="hidden" name="oper_room_code<%=i%>" id="oper_room_code<%=i%>" value="<%=(String)reschedule_details.get("oper_room_code")%>">

			<input type="hidden" name="oper_status_<%=i%>" id="oper_status_<%=i%>" value="">
			<input type="hidden" name="user_role_<%=i%>" id="user_role_<%=i%>" value="">
		</tr>
	<%
		}
	%>

	</table>
	<input type="hidden" name="facility_id" id="facility_id" value="<%=(String)session.getValue("facility_id")%>">
	<input type="hidden" name="menu_id" id="menu_id" value="<%=request.getParameter("menu_id")%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="function_id_list" id="function_id_list" value="">		
	<input type="hidden" name="function_name_list" id="function_name_list" value="">		
	<input type="hidden" name="url_desc_list" id="url_desc_list" value="">	
	<input type="hidden" name="rec_size" id="rec_size" value="<%=size%>">		

		
</form>
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>	
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

