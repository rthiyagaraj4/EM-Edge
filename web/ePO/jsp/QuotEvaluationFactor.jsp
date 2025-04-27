<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePO.*, ePO.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="ePO.QuotationEvaluationFactor.label" bundle="${po_labels}"/></title>
<%
	    request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../ePO/js/Quotation.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function_id				=		 "<%= request.getParameter("function_id") %>"
		</script>
	
	</head>
<body> 
<%
//	String bean_id							=				request.getParameter("bean_id");
//	String bean_name						=				request.getParameter("bean_name");
//	String mode								=				request.getParameter("mode");
	String delivery_qty						=				request.getParameter("order_qty");
	String tot_qty							=				request.getParameter("order_qty");	
//	String item_desc						=				request.getParameter("item_desc");
//	String item_code						=				request.getParameter("item_code");
	String delivery_uom_desc				=				request.getParameter("temp_uom");
	String delivery_uom_code				=				request.getParameter("temp_uom_code");
	String free_qty							=				request.getParameter("free_qty");
	String do_free_qty						=				request.getParameter("free_qty");
	String sample_qty						=				request.getParameter("sample_qty");
	String do_sample_qty					=				request.getParameter("sample_qty");
	String delivery_price					=				request.getParameter("delivery_price");
	String do_delivery_price				=				request.getParameter("delivery_price");
	String function_id						=				request.getParameter("function_id");
	String facility_id = "";
	String store_code = "";
	String delv_uom = "";
	String delv_uom_desc = "";
	String batch_id = "";
	String expiry_date = "";
	String trade_id = "";
	String item_disabled = "";
	
	
	String bean_id							=				request.getParameter("bean_id");
	String bean_name						=				request.getParameter("bean_name");
	String mode								=				request.getParameter("mode");
	String supp_code						=				request.getParameter("supp_code");
	String po_mode							=				request.getParameter("po_mode");
	String item_desc						=				request.getParameter("item_desc");
	String quot_uom_desc				=				request.getParameter("temp_uom");
	String quot_uom_code				=				request.getParameter("temp_uom_code");
	String quot_qty						=				request.getParameter("quot_qty");
	String master_code = "";
	String selection_status = "";
	String master_code_desc = "";
	String weightage ="";
	String ranking = "";
	String eval_remarks = "";
	String recommended = "";
	String recommended_remarks = "";
	
	
	QuotationBean bean					=				(QuotationBean) getBeanObject( bean_id,bean_name,request);
	
	String item_code						=				bean.checkForNull(request.getParameter("item_code"));
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	
	
	String mode_modify = bean.checkForNull(request.getParameter("mode_modify"));
	String req_facility_id = bean.checkForNull(request.getParameter("facility_id"));
	
//	int max_rows = Integer.parseInt(eCommon.Common.CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
	int max_rows = 5;
//	String count =		bean.checkForNull((String)bean.fetchRecord("SELECT count(*) count FROM PO_MASTER_CODE_LANG where master_type='EVALFT' and language_id='en'").get("COUNT"),"");
//	int max_rows = Integer.parseInt(count);
	String item_code1 = "";
	ArrayList hmExpRecords		= new ArrayList();
	int y=0;
	ArrayList alDelvRecords		= new ArrayList();

		System.out.println("item_code in Batch details = "+item_code);
	//	System.out.println("getEvaluationFactorRecords in dBatch details = "+bean.getEvaluationFactorRecords());
		
		
	if(bean.getEvaluationFactorRecords(item_code) != null && bean.getEvaluationFactorRecords(item_code).size()>0){
		hmExpRecords = (ArrayList)bean.getEvaluationFactorRecords(item_code);
		max_rows  = hmExpRecords.size();		
	}
/*	else{
		alDelvRecords = bean.getEvalFactorData(bean.getDoc_no(),item_code);
		System.out.println("alDelvRecords = "+alDelvRecords);
		max_rows  = alDelvRecords.size();		
	}
*/	
	

	
//	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
		alDelvRecords = bean.getEvalFactorData(bean.getDoc_no(),item_code);
		if(alDelvRecords.size() > 0){
			System.out.println("alDelvRecords = "+alDelvRecords);
			max_rows  = alDelvRecords.size();		
		}
	
//	}	
	
	System.out.println("mode in do eval factor = "+mode);
		
%>
<form name="EvaluationFactorForm" id="EvaluationFactorForm">
	<table border='0' cellpadding='0' cellspacing='0' width='100%' align=center scrolling=yes >
	<tr>
			<td class="label" colspan=3><b><fmt:message key="ePO.Item.label"	bundle="${po_labels}"/></b>&nbsp;
				<%=item_code%>  &nbsp;&nbsp;  <%=item_desc%>
			</td>
			<td class="label" colspan=3><b>Total Quotation Quantity : </b><%=quot_qty%> &nbsp;&nbsp; <%=quot_uom_desc%>
			</td>
		</tr>
		
		<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
	</table>	
		<table border='0' cellpadding='0' cellspacing='0' width='100%' align=center scrolling=yes id='myTable'>
		<tr>
			<th width='20%' ><fmt:message key="ePO.EvaluationFactor.label" bundle="${po_labels}"/></th>
			<th width='8%' nowrap><fmt:message key="ePO.Weightage.label" bundle="${po_labels}"/>-%</th>
			<th width='4%' ><fmt:message key="ePO.Ranking.label" bundle="${po_labels}"/></th>
			<th width='15%' ><fmt:message key="ePO.EvalRemarks.label" bundle="${po_labels}"/></th>
			<th  width='10%' ><fmt:message key="ePO.Recommended.label" bundle="${po_labels}"/></th>
			<th  width='10%' ><fmt:message key="ePO.Remarks.label" bundle="${po_labels}"/></th>
			
		</tr>
		
		<%			
			int ct=0;
			for ( int cnt=0; cnt<max_rows; cnt++ ) {
				
			if(bean.getEvaluationFactorRecords(item_code) != null && bean.getEvaluationFactorRecords(item_code).size() > 0) {
					HashMap hm = (HashMap)hmExpRecords.get(cnt);
					System.out.println("hm = "+hm);
					master_code = bean.checkForNull((String)hm.get("MASTER_CODE"));
					weightage = bean.checkForNull((String)hm.get("WEIGHTAGE"));
					ranking = bean.checkForNull((String)hm.get("RANKING"));
					eval_remarks = bean.checkForNull((String)hm.get("EVALREMARKS"));
					recommended = bean.checkForNull((String)hm.get("RECOMMENDED"));
					recommended_remarks = bean.checkForNull((String)hm.get("RECOMMENDEDREMARKS"));
					
				}
				
				if(alDelvRecords != null && alDelvRecords.size() > 0  ){
				if(ct < max_rows){
					for(int i=0;i<alDelvRecords.size();i++){
						HashMap hm = (HashMap)alDelvRecords.get(i);
					
					master_code = bean.checkForNull((String)hm.get("PO_MASTER_CODE"));
					eval_remarks = bean.checkForNull((String)hm.get("EVAL_REMARKS"));
					recommended = bean.checkForNull((String)hm.get("RECOMMEND_YN"));
					recommended_remarks = bean.checkForNull((String)hm.get("RECOMMENDATION_RMKS"));
					weightage = bean.checkForNull((String)hm.get("WEIGHTAGE_PERC"));
					ranking = bean.checkForNull((String)hm.get("RANKING"));
					
					System.out.println("eval_remarks = "+eval_remarks);
					
					
									
				//	if(max_rows==5 && ct!=0){
					if(max_rows==5 && cnt!=0 && master_code == ""){
						master_code = "";
						weightage ="";
						ranking = "";
						eval_remarks = "";
						recommended = "";
						recommended_remarks = "";
						
					}
					
					
				
				String recommendedYesSelected = "";
				String recommendedNoSelected = "";
				
				if(recommended.equals("Y")){
					recommendedYesSelected = "selected";
				}else if(recommended.equals("N")){
					recommendedNoSelected = "selected";
				}
				
					
			 
		%>				
		<tr>
			
			<td align="left">
				<select name="master_code_<%=ct%>" id="master_code_<%=ct%>" onchange="" width="300" style="width: 300px">
					<%=bean.getEvalFactorList(master_code)%>
				</select>
			</td>
			<td  align="right"> 
				<input type="text" class=NUMBER name="weightage_<%=ct%>" id="weightage_<%=ct%>"  size="11" maxlength="3"  value="<%=bean.checkForNull(weightage)%>" onKeyPress="return isValidNumber(this,event,10,3);return isValidInteger(); " onBlur="maxWeightageLimit(this,<%=ct%>);"> 
			</td>
			<td  align="right"> 
				<input type="text" class=NUMBER name="ranking_<%=ct%>" id="ranking_<%=ct%>"  size="5" maxlength="5"  value="<%=bean.checkForNull(ranking)%>" onKeyPress="return isValidNumber(this,event,10,3);return isValidInteger(); "> 
			</td>
			
			<td  align="left">
				<label id="eval_remarks_<%=ct%>" name="eval_remarks_<%=ct%>" onMouseOver="changeCursor(this);"  class="label" onClick = "showReason(eval_remarks_<%=ct%>,<%=ct%>);"><font class='HYPERLINK'><fmt:message key="ePO.EvalRemarks.label" bundle="${po_labels}"/></font></label>
			</td> 
			
			<td align="left"><select name="recommended_<%=ct%>" id="recommended_<%=ct%>" >
				<option value="Y" <%=recommendedYesSelected%> >Yes</option>
				<option value="N" <%=recommendedNoSelected%> >No</option>
				
			</select></td>
			
			
			<td align="left">
				<label id="recommended_remarks_<%=ct%>" name="recommended_remarks_<%=ct%>" onMouseOver="changeCursor(this);"  class="label" onClick = "showReason1(recommended_remarks_<%=ct%>,<%=ct%>);"><font class='HYPERLINK'><fmt:message key="ePO.RecommendedRemarks.label" bundle="${po_labels}"/></font></label>
			</td> 
			
			<input type="hidden" name="eval_rmks_<%=ct%>" id="eval_rmks_<%=ct%>"               value="<%=eval_remarks%>">		
			<input type="hidden" name="recom_rmks_<%=ct%>" id="recom_rmks_<%=ct%>"               value="<%=recommended_remarks%>">		
			
		</tr>
				
		<%
			ct++;
					}
				}				
				} else {
					System.out.println("cnt = "+cnt);
				//	if(max_rows==5 && cnt!=0){
					if(max_rows==5 && cnt!=0 && master_code == ""){
						master_code = "";
						weightage ="";
						ranking = "";
						eval_remarks = "";
						recommended = "";
						recommended_remarks = "";
						
					}
					
					
				String recommendedYesSelected = "";
				String recommendedNoSelected = "";	
					
				if(recommended.equals("Y")){
					recommendedYesSelected = "selected";
				}else if(recommended.equals("N")){
					recommendedNoSelected = "selected";
				}
		%>				
		<tr>
			<td align="left">
			<select name="master_code_<%=cnt%>" id="master_code_<%=cnt%>" onchange="" width="300" style="width: 300px">
					<%=bean.getEvalFactorList(master_code)%>
			</select>
			</td>
			<td  align="right"> 
				<input type="text" class=NUMBER name="weightage_<%=cnt%>" id="weightage_<%=cnt%>"  size="11" maxlength="3"  value="<%=bean.checkForNull(weightage)%>" onKeyPress="return isValidNumber(this,event,10,3);return isValidInteger(); " onBlur="maxWeightageLimit(this,<%=cnt%>);"> 
			</td>
			<td  align="right"> 
				<input type="text" class=NUMBER name="ranking_<%=cnt%>" id="ranking_<%=cnt%>"  size="5" maxlength="5"  value="<%=bean.checkForNull(ranking)%>" onKeyPress="return isValidNumber(this,event,10,3);return isValidInteger(); " > 
			</td>
			<td  align="left"><label id="eval_remarks_<%=cnt%>" name="eval_remarks_<%=cnt%>" onMouseOver="changeCursor(this);"  class="label" onClick = "showReason(eval_remarks_<%=cnt%>,<%=cnt%>);"><font class='HYPERLINK'><fmt:message key="ePO.EvalRemarks.label" bundle="${po_labels}"/></font></label>
			</td> 
			<td align="left" ><select name="recommended_<%=cnt%>" id="recommended_<%=cnt%>" >
				<option value="Y" <%=recommendedYesSelected%> >Yes</option>
				<option value="N" <%=recommendedNoSelected%> >No</option>
				
			</select></td>
			<td align="left">
				<label id="recommended_remarks_<%=cnt%>" name="recommended_remarks_<%=cnt%>" onMouseOver="changeCursor(this);"  class="label" onClick = "showReason1(recommended_remarks_<%=cnt%>,<%=cnt%>);"><font class='HYPERLINK'><fmt:message key="ePO.RecommendedRemarks.label" bundle="${po_labels}"/></font></label>
			</td> 
			
			<input type="hidden" name="eval_rmks_<%=cnt%>" id="eval_rmks_<%=cnt%>"               value="<%=eval_remarks%>">
			<input type="hidden" name="recom_rmks_<%=cnt%>" id="recom_rmks_<%=cnt%>"               value="<%=recommended_remarks%>">
			
		</tr>
				
		<%
								
				}
					
				y =  cnt;
				%>
			
		 <%		
			}
			
				y++;
				System.out.println("max_rows = "+max_rows);
				for ( int j=y ; j<max_rows; j++ ) {

				//	if(j!=0){
					if(j!=0 && master_code == "" ){
					master_code = "";
					weightage ="";
					ranking = "";
					eval_remarks = "";
					recommended = "";
					recommended_remarks = "";
					
					}
					
				String recommendedYesSelected = "";
				String recommendedNoSelected = "";	
				
				if(recommended.equals("Y")){
					recommendedYesSelected = "selected";
				}else if(recommended.equals("N")){
					recommendedNoSelected = "selected";
				}	
		%>				
		<tr>
			<td align="left">
			<select name="master_code_<%=j%>" id="master_code_<%=j%>" onchange="" width="300" style="width: 300px">
					<%=bean.getEvalFactorList(master_code)%>
			</select>
			</td>
			<td  align="right"> 
				<input type="text" class=NUMBER name="weightage_<%=j%>" id="weightage_<%=j%>"  size="11" maxlength="3"  value="<%=bean.checkForNull(weightage)%>" onKeyPress=" return isValidNumber(this,event,10,3);return isValidInteger();" onBlur="maxWeightageLimit(this,<%=j%>);"> 
			</td>
			<td  align="right"> 
				<input type="text" class=NUMBER name="ranking_<%=j%>" id="ranking_<%=j%>"  size="5" maxlength="5"  value="<%=bean.checkForNull(ranking)%>" onKeyPress="return isValidNumber(this,event,10,3);return isValidInteger(); " > 
			</td>
			<td  align="left"><label id="eval_remarks_<%=j%>" name="eval_remarks_<%=j%>" onMouseOver="changeCursor(this);"  class="label" onClick = "showReason(eval_remarks_<%=j%>,<%=j%>);"><font class='HYPERLINK'><fmt:message key="ePO.EvalRemarks.label" bundle="${po_labels}"/></font></label>
			</td> 
					
			<td align="left"><select name="recommended_<%=j%>" id="recommended_<%=j%>" >
				<option value="Y" <%=recommendedYesSelected%> >Yes</option>
				<option value="N" <%=recommendedNoSelected%> >No</option>
				
			</select></td>
			<td align="left">
				<label id="recommended_remarks_<%=j%>" name="recommended_remarks_<%=j%>" onMouseOver="changeCursor(this);"  class="label" onClick = "showReason1(recommended_remarks_<%=j%>,<%=j%>);"><font class='HYPERLINK'><fmt:message key="ePO.RecommendedRemarks.label" bundle="${po_labels}"/></font></label>
			</td> 
			
			<input type="hidden" name="eval_rmks_<%=j%>" id="eval_rmks_<%=j%>"               value="<%=eval_remarks%>">
			<input type="hidden" name="recom_rmks_<%=j%>" id="recom_rmks_<%=j%>"               value="<%=recommended_remarks%>">
			
		</tr>
				
		<%
				}
		%>
		</table>
	<table border='0' cellpadding='0' cellspacing='0' width='100%' align=center scrolling=yes >
		<tr><td>&nbsp;</td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
		
			<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
			<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
			<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
			<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
			<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
			<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
			<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
			<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
			<td align="right"><input type="button" align="right" class="button" name="add" id="add" value="Add Row"  onClick="addRowEval('myTable');"></td>
			
			<td align="right">
				<input type="button" align="right" class="button" name="Ok" id="Ok" value="  Ok  "  onClick="exitEvaluationFactor();" <%=item_disabled%>>
				
			</td>
					
		</tr>
	</table>
	
	
	
	<input type="hidden" 	name="finalize_yn" id="finalize_yn"			value="No">
	<input type="hidden" 	name="mode" id="mode"					value="<%=mode%>">
	<input type="hidden" 	name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
	<input type="hidden" 	name="bean_id" id="bean_id"				value="<%=bean_id%>">
	<input type="hidden" 	name="bean_name" id="bean_name"			value="<%=bean_name %>">
	<input type="hidden" 	name="totalRecords" id="totalRecords"        	value="<%=max_rows%>">
	<input type="hidden" 	name="item_code" id="item_code"			value="<%=item_code%>">
	
	<input type="hidden" 	name="tot_qty" id="tot_qty"				value="<%=tot_qty%>">
	<input type="hidden" 	name="do_free_qty" id="do_free_qty"			value="<%=do_free_qty%>">
	<input type="hidden" 	name="do_sample_qty" id="do_sample_qty"		value="<%=do_sample_qty%>">
	<input type="hidden" 	name="do_delivery_price" id="do_delivery_price"	value="<%=do_delivery_price%>">
	<input type="hidden" 	name="delivery_qty" id="delivery_qty"			value="">
	<input type="hidden" 	name="free_qty" id="free_qty"				value="">
	<input type="hidden" 	name="sample_qty" id="sample_qty"			value="">
	
	<input type="hidden" 	name="req_facility_id" id="req_facility_id"			value="<%=req_facility_id%>">
	<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
	
	
	
	
	
	
	
</form>
<%
	putObjectInBean(bean_id,bean,request);
		
%>
</body>
</html>

