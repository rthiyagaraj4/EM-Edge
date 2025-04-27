<!DOCTYPE html>
<%@page  import ="java.util.ArrayList,java.util.HashMap,eCommon.Common.CommonBean,eOT.*, eOT.Common.*"  contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
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
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<!-- <script>
	var operationsProcedures_value=getLabel("eOT.OperationsProcedures.Label","OT");
	var reason_value=getLabel("Common.reason.label","common");
</script> -->
	<style>
		 TD.OTMENULAYER
		  {
	 	  FONT-FAMILY: VERDANA ;
	 	  FONT-SIZE: 10PT ;
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
	String bean_id	 = "SlateBean";
	String bean_name = "eOT.SlateBean";
	SlateBean bean	 = (SlateBean)mh.getBeanObject( bean_id, request, bean_name );
	HashMap all_waitlist_details = bean.getWaitlistDetails();
	ArrayList arr_list_theatres = null;
	String theatre_temp   = "";
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="SlateSchSearchResultForm" id="SlateSchSearchResultForm">
	<table border="1" cellpadding=3  cellspacing="0" width="100%" align="center" name="resultTable" id="resultTable" id="resultTable">
	<%
	String classValue = "";
	String surgeon_code = "";
	String speciality_code = "";
	String waitlist_num = "";
	StringBuffer sb_oper_desc = new StringBuffer();
	String multiple_opers_yn = "N";

	ArrayList multiple_oper_desc = new ArrayList();
	HashMap waitlist_details=new HashMap();
	int size = all_waitlist_details.size();
	int mult_oper_size = 0;
	for (int i=1;i<=size;i++){
		waitlist_details=(HashMap)all_waitlist_details.get(i+"");
		if ( i % 2 == 0 )
			classValue = "QRYODD" ;
		else
			classValue = "QRYEVEN" ;
		surgeon_code	= (String)waitlist_details.get("surgeon_code");
		speciality_code = (String)waitlist_details.get("speciality_code");
		waitlist_num	= (String)waitlist_details.get("waitlist_num");
		multiple_opers_yn = (String)waitlist_details.get("multiple_opers_yn");
		if(multiple_opers_yn.equals("Y")){
			String operationsProcedures_value=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels");
			sb_oper_desc.append(operationsProcedures_value);

			multiple_oper_desc = bean.getWaitListMultipleOperations(waitlist_num);
			mult_oper_size = multiple_oper_desc.size();
			for(int m=0;m<mult_oper_size;m++){
				if(m!=0)
					sb_oper_desc.append(",");
				sb_oper_desc.append((String)multiple_oper_desc.get(m));
			}
		}
	%>
		<tr >		
			<td class="<%=classValue%>" onClick="displayToolTip('<%=i%>',this,'WAITLIST');" onMouseOver='hideToolTip();'>
				<font class='HYPERLINK' style="font-size:7pt;color:blue;cursor:pointer;font-weight:normal" width="18%"  > <%=(String)waitlist_details.get("patient_id")%></font>					
			</td>

			<td class="<%=classValue%>" style="font-size:7pt;font-weight:normal" width="20%" wrap>
				<%=(String)waitlist_details.get("patient_name")%>
			</td>
			<td class="<%=classValue%>" style="font-size:7pt;font-weight:normal" width="14%">
				<%=CommonBean.checkForNull((String)waitlist_details.get("surgeon_name"))%>
			</td>
			<td class="<%=classValue%>" style="font-size:7pt;font-weight:normal" width="13%">
				<%=CommonBean.checkForNull((String)waitlist_details.get("speciality_desc"))%>
			</td>
			<%
				if(multiple_opers_yn.equals("Y")){
			%>
					<td class="<%=classValue%>" style="font-size:7pt;color=blue;font-weight:normal" width="14%" onMouseOver="reasonToolTip('<%=sb_oper_desc%>')"  onMouseOut='hideToolTip1();'>
						<%=CommonBean.checkForNull((String)waitlist_details.get("oper_desc"))%>	
					</td>
			<%
				}else{
			%>
					<td class="<%=classValue%>" style="font-size:7pt;font-weight:normal" width="14%">
						<%=CommonBean.checkForNull((String)waitlist_details.get("oper_desc"))%>	
					</td>
			<%
				}
			%>


			<td width="19%" style="font-size:7pt;font-weight:normal" class="<%=classValue%>" ><select name="theatre_<%=i%>" id="theatre_<%=i%>">
				<option value="" selected>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
					<%
							theatre_temp   = "";
							arr_list_theatres = bean.getAllTheatres(surgeon_code,speciality_code);
							if(arr_list_theatres!=null){
								for (int t=0;t<arr_list_theatres.size();t=t+2){
									theatre_temp   = (String)arr_list_theatres.get(t);
					%>
								<option value="<%=theatre_temp%>" > 
									<%=arr_list_theatres.get(t+1)%>	
								</option>
					<%
								}
							}
					%>
				</select><img src="../../eCommon/images/mandatory.gif" id="mand_id_" ></img>
			</td>

			<input type="hidden" name="patient_id_<%=i%>" id="patient_id_<%=i%>" value="<%=(String)waitlist_details.get("patient_id")%>">
			<input type="hidden" name="order_id_<%=i%>" id="order_id_<%=i%>" value="<%=(String)waitlist_details.get("order_id")%>">
			<input type="hidden" name="speciality_code_<%=i%>" id="speciality_code_<%=i%>" value="<%=speciality_code%>">
			<input type="hidden" name="surgeon_code_<%=i%>" id="surgeon_code_<%=i%>" value="<%=surgeon_code%>">
			<input type="hidden" name="surgery_type_<%=i%>" id="surgery_type_<%=i%>" value="<%=(String)waitlist_details.get("surgery_type")%>">
			<input type="hidden" name="preferred_date_<%=i%>" id="preferred_date_<%=i%>" value="<%=(String)waitlist_details.get("preferred_date")%>">
			<input type="hidden" name="oper_status_<%=i%>" id="oper_status_<%=i%>" value="">
			<input type="hidden" name="oper_num_<%=i%>" id="oper_num_<%=i%>" value="">
			<input type="hidden" name="appt_ref_num_<%=i%>" id="appt_ref_num_<%=i%>" value="">
			<input type="hidden" name="waitlist_num_<%=i%>" id="waitlist_num_<%=i%>" value="<%=waitlist_num%>">

		</tr>
	<%
			sb_oper_desc.setLength(0);
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
	<input type="hidden" name="user_role" id="user_role" value="">
		
</form>
 	<div name='tooltiplayer1' id='tooltiplayer1' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'>	
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
%>

