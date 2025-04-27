<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePO.*, ePO.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="ePO.QuotationSelectionCriteria.label" bundle="${po_labels}"/></title>
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
	String item_code						=				request.getParameter("item_code");
	String quot_uom_desc				=				request.getParameter("temp_uom");
	String quot_uom_code				=				request.getParameter("temp_uom_code");
	String quot_qty						=				request.getParameter("quot_qty");
	String master_code = "";
	String selection_status = "";
	String master_code_desc = "";
	String selStatus = "";
		
	QuotationBean bean					=				(QuotationBean) getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	
	
	String mode_modify = bean.checkForNull(request.getParameter("mode_modify"));
	String req_facility_id = bean.checkForNull(request.getParameter("facility_id"));
	
//	int max_rows = Integer.parseInt(eCommon.Common.CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
	int max_rows = 5;
//	String count =		bean.checkForNull((String)bean.fetchRecord("SELECT count(*) count FROM PO_MASTER_CODE_LANG where master_type='SELCRT' and language_id='en'").get("COUNT"),"");
//	int max_rows = Integer.parseInt(count);
	String item_code1 = "";
	ArrayList hmExpRecords		= new ArrayList();
	ArrayList alDelvRecords		= new ArrayList();
	int y=0;
	
		System.out.println("item_code in selection criteria = "+item_code);
	//	System.out.println("getSelectionCriteriaRecords in dBatch details = "+bean.getSelectionCriteriaRecords());
		
		
	if(bean.getSelectionCriteriaRecords(item_code) != null && bean.getSelectionCriteriaRecords(item_code).size()>0){
		hmExpRecords = (ArrayList)bean.getSelectionCriteriaRecords(item_code);
		System.out.println("hmExpRecords = "+hmExpRecords);
		max_rows  = hmExpRecords.size();		
	}
	/*else{
		alDelvRecords = bean.getSelecionCriteriaData(bean.getDoc_no(),item_code);
		System.out.println("alDelvRecords in sel cri = "+alDelvRecords);
		max_rows  = alDelvRecords.size();		
	}
	*/
	
	
//	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
		alDelvRecords = bean.getSelecionCriteriaData(bean.getDoc_no(),item_code);
		if(alDelvRecords.size() > 0){
			System.out.println("alDelvRecords in sel cri = "+alDelvRecords);
			max_rows  = alDelvRecords.size();		
		}
	
//	}	
	
	System.out.println("max_rows in selection criteria = "+max_rows);
		
%>
<form name="QuotationSelectionCriteriaForm" id="QuotationSelectionCriteriaForm">
	<table border='0' cellpadding='0' cellspacing='0' width='100%' align=center scrolling=yes>
	<tr>
			<td class="label" ><b><fmt:message key="ePO.Item.label"	bundle="${po_labels}"/></b>&nbsp;
				<%=item_code%>  &nbsp;&nbsp;  <%=item_desc%>
			</td>
			<td class="label" ><b>Total Quotation Quantity : </b><%=quot_qty%> &nbsp;&nbsp; <%=quot_uom_desc%>
			</td>
		</tr>
		<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><tr>
	</table>	
	<table border='0' cellpadding='0' cellspacing='0' width='100%' align=center scrolling=yes id='mySelTable'>
		<tr>
			<th ><fmt:message key="ePO.SelectionCriteria.label" bundle="${po_labels}"/></th>
			<th width=325><fmt:message key="ePO.defaultSelect.label" bundle="${po_labels}"/></th>
			
		</tr>
		
		<%			
			int ct=0;
			for ( int cnt=0; cnt<max_rows; cnt++ ) {
				
				if(bean.getSelectionCriteriaRecords(item_code) != null  && bean.getSelectionCriteriaRecords(item_code).size() > 0){
					HashMap hm = (HashMap)hmExpRecords.get(cnt);
					master_code = bean.checkForNull((String)hm.get("MASTER_CODE"));
					selection_status = bean.checkForNull((String)hm.get("SELECTION_STATUS"));
					
					
				}
				
				
				
				
					
				
				
				if(alDelvRecords != null && alDelvRecords.size() > 0  ){
				if(ct < max_rows){
					for(int i=0;i<alDelvRecords.size();i++){
						HashMap hm = (HashMap)alDelvRecords.get(i);
					
					master_code = bean.checkForNull((String)hm.get("PO_MASTER_CODE"));
					selection_status = bean.checkForNull((String)hm.get("SELECTED_YN"));
					
									
					if(max_rows==5 && cnt!=0 && master_code == ""){
						master_code = "";
						selection_status="";
						
						
					}
					
					
					
					if(selection_status.equals("Y"))
						selStatus = "checked";
					else
						selStatus = "";
			 
		%>				
		<tr>
			
			<td align="left">
				<select name="master_code_<%=ct%>" id="master_code_<%=ct%>" onchange="setStatus(this,'<%=ct%>');" width="300" style="width: 300px">
					<%=bean.getSelCriteriaList(master_code)%>
				</select>
			</td>
			
			<td  align="center"> 
				<input type="checkbox"  name="selection_status_<%=ct%>" id="selection_status_<%=ct%>"  size="10" maxlength="10"  value="<%=bean.checkForNull(selection_status)%>" <%=selStatus%> onKeyPress=" " onBlur=""> 
			</td>
					
			
		</tr>
				
		<%
			ct++;
					}
				}				
				} else {
					
					if(max_rows==5 && cnt!=0 && master_code == ""){
						master_code = "";
						selection_status = "";
						
					}
					
						if(selection_status.equals("Y"))
						selStatus = "checked";
					else
						selStatus = "";
				
		%>				
		<tr>
		<td align="left">
			<select name="master_code_<%=cnt%>" id="master_code_<%=cnt%>" onchange="setStatus(this,'<%=cnt%>');" width="300" style="width: 300px">
				<%=bean.getSelCriteriaList(master_code)%>
			</select>
		</td>	
			
			<td  align="center">
				<input type="checkbox"  name="selection_status_<%=cnt%>" id="selection_status_<%=cnt%>"  size="10" maxlength="10"  value="<%=bean.checkForNull(selection_status)%>" <%=selStatus%> onKeyPress=" " onBlur=""> 
			</td>
		</tr>
				
		<%
								
				}
					
				y =  cnt;
				%>
			
		 <%		
			}
			
				y++;
				
				for ( int j=y ; j<max_rows; j++ ) {

					if(j!=0 && master_code == ""){
						master_code = "";
						selection_status = "";		
					
					}
						if(selection_status.equals("Y"))
						selStatus = "checked";
					else
						selStatus = "";
					
		%>				
		<tr>
			<td align="left">
				<select name="master_code_<%=j%>" id="master_code_<%=j%>" onchange="setStatus(this,'<%=j%>');" width="300" style="width: 300px" >
					<%=bean.getSelCriteriaList(master_code)%>
				</select>
			</td>	
			
			<td align="center">
				<input type="checkbox"  name="selection_status_<%=j%>" id="selection_status_<%=j%>"  size="10" maxlength="10"  value="<%=bean.checkForNull(selection_status)%>" <%=selStatus%> onKeyPress=" " onBlur=""> 
			</td>
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
			<td align="right"><input type="button" align="right" class="button" name="add" id="add" value="Add Row"  onClick="addRowSel('myTable');"></td>
			
			<td align="right">
				<input type="button" align="right" class="button" name="Ok" id="Ok" value="  Ok  "  onClick="exitSelectionCriteria();" <%=item_disabled%>>
				
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

