<!DOCTYPE html>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*,eCommon.Common.*,java.net.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<!-- /*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
04/07/2017	  	IN064425	     	Mukesh M 											GHL-CRF-0470 [IN064425] 
--------------------------------------------------------------------------------------------------------------
03/10/2023	  	50818  			    Himanshu 											GHL-SCF-1738 
--------------------------------------------------------------------------------------------------------------
*/
 -->
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
	<head>
<% 
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
		//String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");
		String bean_id = request.getParameter("bean_id")==null?"":request.getParameter("bean_id");
		String bean_name = request.getParameter("bean_name")==null?"":request.getParameter("bean_name");
		String calling_mode						=  request.getParameter("mode") ;// Added for GHL-CRF-0470
		String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");	//Added for GHL-CRF-0470
		String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");	//Added for GHL-CRF-0470
		ConsumableOrderBean bean			= (ConsumableOrderBean)getBeanObject( bean_id, bean_name, request );
		//GHL-CRF-0470 start
		String pres_bean_id					= "@PrescriptionBean_1"+patient_id+encounter_id;
		String pres_bean_name				= "ePH.PrescriptionBean_1";
		PrescriptionBean_1 pres_bean			= (PrescriptionBean_1)getBeanObject(pres_bean_id,pres_bean_name,request);
		bean.setPresRemarks(pres_bean.getPresRemarks());
		//GHL-CRF-0470 end
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="JavaScript" src="../../ePH/js/ConsumableOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="" onKeyDown="lockKey()">
		<form name="frm_consumableItemList" id="frm_consumableItemList">
			<input type='hidden' name='hdn_bean_id' id='hdn_bean_id' value='<%=bean_id%>'>
			<input type='hidden' name='hdn_bean_name' id='hdn_bean_name' value='<%=bean_name%>'>
<%
			ArrayList presItemList=(ArrayList)bean.getPresItemList();
				int defaultIndex=-1;

			if(presItemList!=null && presItemList.size()>0){
				HashMap itemDetail = new HashMap();
				String item_code = "";
				String item_desc = "";
				String trade_code = "";
				String trade_name = "";
				String qty_value = "";
				String qty_uom_code = "";
				String qty_uom_desc = "";
				String classValue = "";
				String confirmed_yn = "";
				String selected_yn = "";
				String select_checked = "";
				String MedicationRemarks="";	//Added for GHL-CRF-0470
				String available_stock=""; 	 	//Added By Himanshu for GHL-SCF-1738
%>
				<table border="1" width="100%" cellspacing="0" cellpadding="0">
					<tr> 
					<td class='COLUMNHEADER'colspan='6'><fmt:message key="ePH.ItemsSelected.label" bundle="${ph_labels}"/></td>
					</tr>
					<tr></tr>
					<tr></tr>
					<tr>
						<td width="5%" class='COLUMNHEADER'><fmt:message key="ePH.Select.label" bundle="${ph_labels}"/></td>
						<td width="60%" class='COLUMNHEADER' COLSPAN=2><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></td>
											
						<td class="COLUMNHEADER"  width="20%"><fmt:message key="Common.Trade.label" bundle="${common_labels}"/></td>
						<td class="COLUMNHEADER"  width="8%" ><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td> <!-- colspan removed for GHL-CRF-0470 -->
						<td class="COLUMNHEADER"  width="8%" ></td><!-- Added for GHL-CRF-0470 -->
					</tr>
<%
					for(int i=0; i<presItemList.size(); i++){

						itemDetail= (HashMap)presItemList.get(i);
						item_code = (String)itemDetail.get("ITEM_CODE")==null?"":(String)itemDetail.get("ITEM_CODE");   
						item_desc = (String)itemDetail.get("ITEM_DESC")==null?"":(String)itemDetail.get("ITEM_DESC");   
						trade_code = (String)itemDetail.get("TRADE_CODE")==null?"":(String)itemDetail.get("TRADE_CODE"); 
						
						trade_name =(String)itemDetail.get("TRADE_NAME")==null?"":(String)itemDetail.get("TRADE_NAME");
					
						//trade_name = java.net.URLDecoder.decode(trade_name,"UTF-8");
						qty_uom_desc = (String)itemDetail.get("UOM_DESC")==null?"":(String)itemDetail.get("UOM_DESC");   
						qty_uom_code = (String)itemDetail.get("UOM_CODE")==null?"":(String)itemDetail.get("UOM_CODE");
						qty_value = (String)itemDetail.get("QTY_VALUE")==null?"":(String)itemDetail.get("QTY_VALUE");
						confirmed_yn = (String)itemDetail.get("CONFIRMED_YN")==null?"":(String)itemDetail.get("CONFIRMED_YN");
						selected_yn = (String)itemDetail.get("SELECTED_YN")==null?"":(String)itemDetail.get("SELECTED_YN");
						MedicationRemarks	= (String)itemDetail.get("ITEM_REMARKS")==null?"":(String)itemDetail.get("ITEM_REMARKS");	//Added for GHL-CRF-0470
						if(!MedicationRemarks.equals(""))			//Added for GHL-CRF-0470
							MedicationRemarks = java.net.URLEncoder.encode(MedicationRemarks,"UTF-8"); 					
						//out.println("selected_yn== 80==>" +selected_yn);
						if(confirmed_yn.equals("Y"))
							classValue="AMENDEDDRUGS";
						else{
							classValue="SELECTEDRUGS";
							if(defaultIndex < 0)
								defaultIndex=i;
						}

						if(selected_yn.equals("Y"))
							select_checked="checked";
						else
							select_checked="";
%>
						<tr>
							<td width="5%" class='<%=classValue%>'>&nbsp;<input type='checkbox' name='chk_Select<%=i%>' id='chk_Select<%=i%>' value='selected_yn' <%=select_checked%> onclick="setSelected_yn('<%=i%>');"></td>
							<td width="60%" class='<%=classValue%>'  onmouseout="realCol(this,'<%=classValue%>');" onmouseover="changeCursor(this);changeCol(this);" onclick='defaultItem("<%=i%>");' id='<%=item_code%><%=i%>' ><font class="HYPERLINK" size='1'>&nbsp;<%=item_desc%></font></td>
<!-- ============================================================================================================= -->
<%
		String fileName = bean.checkImageExists(item_code);
		if(!(fileName == null || fileName == ""))
		{
%>
									<td  class='<%=classValue%>'>
									<img src='../../ePH/images/camera.gif' width='17' height='15' title="Image" onclick = "showImage('<%=item_code%>','<%=trade_code%>');" onmouseover="changeCursor(this);">
									</td>
<%
		}
	else{
%>
								<td  class='<%=classValue%>'>&nbsp;</td>
<%
			}
%>

									
<!-- ============================================================================================================= -->							
							
							<td class="<%=classValue%>"  width="20%">&nbsp;
							<%=trade_name%>&nbsp;</td>
							<td class="<%=classValue%>"  width="16%" >&nbsp;<%=qty_value%>&nbsp;<%=qty_uom_desc%></td><!--colspan removed for GHL-CRF-0470 -->
							<td class="<%=classValue%>"  width="16%" onmouseover="displayToolTipRemark(this,'<%=i%>')"><a href="javascript: callMedicationRemarks('<%=i%>');" name="medication_remarks_<%=i%>"   >&nbsp;<fmt:message key="ePH.Remarks.label" bundle="${ph_labels}"/></td><!-- Added for GHL-CRF-0470 --><!-- onmouseover added for GHL-CRF-0470 --><!-- IN073342 -->
							<input type="hidden" name="MedicationRemarks_<%=i%>" id="MedicationRemarks_<%=i%>" value="<%=MedicationRemarks%>">	<!-- Added for GHL-CRF-0470 -->					
							<input type='hidden' name='hdn_item_code<%=i%>' id='hdn_item_code<%=i%>' value='<%=item_code%>'>
							<input type='hidden' name='hdn_trade_code<%=i%>' id='hdn_trade_code<%=i%>' value='<%=trade_code%>'>
							<input type='hidden' name='hdn_index<%=i%>' id='hdn_index<%=i%>' value='<%=i%>'>
							<input type='hidden' name='hdn_remarks<%=i%>' id='hdn_remarks<%=i%>' ><!-- Added for GHL-CRF-0470 -->
							<input type="hidden" name="mode" id="mode" value="<%=calling_mode%>"><!-- Added for GHL-CRF-0470 -->
							<input type='hidden' name='hdn_available_stock<%=i%>' id='hdn_available_stock<%=i%>' value='<%=available_stock%>'> <!--//Added By Himanshu for GHL-SCF-1738-->
					     
						
						</tr>
<%
					}
%>
				</table>
<%
			}
%>
		</form>
	</body>
<%
	if( defaultIndex>=0){
%>
		<script>			
			defaultItem('<%=defaultIndex%>');
		</script>
<%
	}
%>
</html> 
<%
	putObjectInBean(bean_id,bean,request);
%>

