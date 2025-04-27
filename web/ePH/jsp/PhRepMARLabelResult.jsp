<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../js/PhRepMARLabel.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
		<form name="frmphREPMARLabelResult" id="frmphREPMARLabelResult" >
<%
			try {
				String bean_id = "PhRepMARLabelBean" ;
				String bean_name = "ePH.PhRepMARLabelBean";
				PhRepMARLabelBean bean = (PhRepMARLabelBean)getBeanObject( bean_id,bean_name, request) ;
				bean.setLanguageId(locale);

				String patient_id = CommonBean.checkForNull(request.getParameter("patient_id"));
				String order_date = CommonBean.checkForNull(request.getParameter("order_date"));
				String locn_type = CommonBean.checkForNull(request.getParameter("locn_type"));
				String p_fm_locn_code = CommonBean.checkForNull(request.getParameter("p_fm_locn_code"));
				String p_to_locn_code = CommonBean.checkForNull(request.getParameter("p_to_locn_code"));
				String order_type = CommonBean.checkForNull(request.getParameter("order_type"));
				String called_from = CommonBean.checkForNull(request.getParameter("called_from"));
				if(called_from.equals("search"))
					bean.clear();
				String from = CommonBean.checkForNull(request.getParameter("from"));
				String to = CommonBean.checkForNull(request.getParameter("to"));
				String prev_pat_id="", prev_pat_name="", prev_ord_id="", curr_pat_id, curr_pat_name,  curr_ord_id;
				String cur_source_desc = "",prev_source_desc = "";
				int recCount	= 0;
				ArrayList result = bean.getResult(patient_id,order_date,locn_type,p_fm_locn_code,p_to_locn_code,order_type,from,to);
				HashMap hmRecord = bean.getOrderTypePHParam();
				String iv_with_additives = CommonBean.checkForNull((String)hmRecord.get("IV_DRUG_FLUID_CONTINUOUS_LG"),"IV With Additives");
				String iv_without_additives = CommonBean.checkForNull((String)hmRecord.get("IV_WITHOUT_ADDITIVES_LG"),"IV Fluids");
				String iv_intermittent = CommonBean.checkForNull((String)hmRecord.get("IV_DRUG_FLUID_INTERMITTENT_LG"),"IV Intermitent");
				if(result.size()<2){
%>
					<script>
						alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
						parent.f_query_add_mod.document.frmphREPMARLabelCriteria.btnPrint.disabled = true;
					</script>
<%
				}
				else{
%>
					<script>
							parent.f_query_add_mod.document.frmphREPMARLabelCriteria.btnPrint.disabled = false;
					</script>
					<table cellpadding=0 cellspacing=0 width="100%" align="center">
						<tr>
							<td width="78%" class="white">&nbsp;</td>
							<td width="20%" class="white">&nbsp;
<%
							if( (result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) ) && ( !( ((String) result.get(0)).equals("")) )) {
								out.println(result.get(0));// For display the previous/next link
							}
%>
							</td>
							<td width="2%" class="white">&nbsp;
						</tr>
					</table>
					<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" >
						<tr>
							<th>&nbsp;<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;</th>
							<th>&nbsp;<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>&nbsp;</th>
							<th>&nbsp;<fmt:message key="Common.OrderID.label" bundle="${common_labels}"/>&nbsp;</th>
							<th>&nbsp;<fmt:message key="Common.DrugName.label" bundle="${common_labels}"/>&nbsp;</th>
							<th>&nbsp;<fmt:message key="ePH.OrderedDate.label" bundle="${ph_labels}"/>&nbsp;</th>
							<th>&nbsp;<fmt:message key="Common.OrderType.label" bundle="${common_labels}"/>&nbsp;</th>
						
							<th>&nbsp;<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/> &nbsp;<input type="checkbox" name="chkSelectAll" id="chkSelectAll" value=""  onClick="selectAll(this)">&nbsp;</th>
						</tr>
<%
						String iv_prep_yn="", order_line_num="", key="", sChecked="", select_yn="", iv_fluid_display="";
						HashMap hmPrintList = bean.getPrintList();
						for( int i = 1; i < result.size(); i=i+10){
							curr_pat_id = (String)result.get(i);
							curr_ord_id=(String)result.get(i+2);
							order_line_num=(String)result.get(i+3);
							key = curr_ord_id+"~"+order_line_num;
							sChecked = "";
							select_yn="N";
							if(hmPrintList != null && hmPrintList.containsKey(key)){
								sChecked = "checked";
								select_yn = "Y";
							}
							cur_source_desc=(String)result.get(i+7);
							curr_pat_name=(String)result.get(i+1);
							if(!curr_pat_id.equals(prev_pat_id)){
								prev_pat_id=curr_pat_id;
								prev_pat_name=curr_pat_name;
							}
							else {
								curr_pat_id = "";
								curr_pat_name = "";
							}
							
							if(!curr_ord_id.equals(prev_ord_id))
								prev_ord_id=curr_ord_id;
							else 
								curr_ord_id = "";

							if(!cur_source_desc.equals(prev_source_desc))
								prev_source_desc=cur_source_desc;
							else 
								cur_source_desc = "";
							iv_prep_yn = (String)result.get(i+9);
							if(!iv_prep_yn.equals("") && !order_line_num.equals("1"))
								iv_fluid_display = "visibility:hidden";
							else
								iv_fluid_display = "visibility:visible";
							if(!cur_source_desc.equals("")){
%>
								<tr>
								<td colspan=7 class='ITEMSELECT'><%=cur_source_desc%></td>
								</tr>
<%
							}
%>
							<tr id = "row_'<%=i%>'">
								<td style="font-size=9" nowrap>&nbsp;<%=curr_pat_id%>&nbsp;</td>
								<td  style="font-size=9" nowrap>&nbsp;<%=curr_pat_name%>&nbsp;
									<input type = 'hidden' id='order_id_<%=recCount%>' value='<%=(String)result.get(i+2)%>'>
									<input type = 'hidden' id='order_line_num_<%=recCount%>' value='<%=(String)result.get(i+3)%>'>
									<input type = 'hidden' id='order_type_<%=recCount%>' value='<%=(String)result.get(i+9)%>'>
								</td>
								<td  style="font-size=9" nowrap >&nbsp;<%=curr_ord_id%>&nbsp;</td>			
								<td  style="font-size=9" nowrap >&nbsp;<%=(String)result.get(i+4)%>&nbsp;</td>	
								<td  style="font-size=9" nowrap >&nbsp;<%=(String)result.get(i+5)%>&nbsp;</td>	
								<td  style="font-size=9" nowrap >&nbsp;
<%
								if(iv_prep_yn.equals("5")){
%>
									<%=iv_without_additives%>
<%
								}
								else if(iv_prep_yn.equals("3")){
%>
									<%=iv_intermittent%>
<%
								}
								else if(iv_prep_yn.equals("1")){
%>
									<%=iv_with_additives%>
<%
								}
								else{
%>
									<fmt:message key="ePH.RxOrder.label" bundle="${ph_labels}"/></font>
<%
								}
%>
								</td>	
								<td>
								<input type="checkbox" name="select_<%=recCount%>" id="select_<%=recCount%>" value="<%=select_yn%>" onClick="updateSelection('<%=(String)result.get(i+2)%>', '<%=order_line_num%>','<%=iv_prep_yn%>',this)" <%=sChecked%> style='<%=iv_fluid_display%>;'>
								</td>
							</tr>
<%
							recCount++;
						}
					}
%>
					<input type="hidden" name="recCount" id="recCount" value="<%=recCount%>">
					<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
					<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
					<input type="hidden" name="from" id="from" value="<%=from%>">
					<input type="hidden" name="to" id="to" value="<%=to%>">
					<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
					
					<input type="hidden" name="locn_type" id="locn_type" value="<%=locn_type%>">
					<input type="hidden" name="order_date" id="order_date" value="<%=order_date%>">
					<input type="hidden" name="p_fm_locn_code" id="p_fm_locn_code" value="<%=p_fm_locn_code%>">
					<input type="hidden" name="p_to_locn_code" id="p_to_locn_code" value="<%=p_to_locn_code%>">
					<input type="hidden" name="order_type" id="order_type" value="<%=order_type%>">
				</table>
<% 
				putObjectInBean(bean_id,bean,request);	
			}
			catch (Exception e) {
				e.printStackTrace() ;
			}
%>
		</form>
	</body>
</html>

