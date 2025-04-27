<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePO.*, ePO.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.util.ArrayList" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="ePO.CommitmentCodeAdditionalDetails.label" bundle="${po_labels}"/></title>
<%
	    request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE"); 
		
		String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../ePO/js/PoDuoHeader.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../ePO/js/MasterType.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		 <script>
        function_id				=		 "<%= request.getParameter("function_id") %>"
		
    </script>
	
	</head>
<body>
<%
	String	mode							=				request.getParameter( "mode" ) ;
	String bean_id							=				request.getParameter("bean_id");
	String bean_name						=				request.getParameter("bean_name");
	String master_code						=				request.getParameter( "master_code" ) ;
	String long_desc						=				request.getParameter( "long_desc" ) ;
	String short_desc						=				request.getParameter( "short_desc" ) ;
	String eff_status						=				request.getParameter( "eff_status" ) ;
	String index							=				request.getParameter( "index" ) ;
	String disabled = "";
	String dept_code = "";
	String acc_no = "";
	String acc_no_desc = "";
	String all_bdgt = "";
	String addnl_bdgt = "";
	String blocked_bdgt = "";
	String total_bdgt = "";
	String eff_dt_frm = "";
	String eff_dt_to = "";
	String override_budget = "";
//	String error_selected = "";
//	String warning_selected = "";
//	String notApplicable_selected = "";
	int y=0;

	ArrayList alResult =  new ArrayList();
	HashMap	  hmResult =  new HashMap();
	ArrayList alResult1 =  new ArrayList();
	HashMap	  hmResult1 =  new HashMap();
	String total_bdgt1 = "";
	String addnl_bdgt1 = "";
	ArrayList alParam = new ArrayList();
	alParam.add(master_code);

	
	MultipleInsertMasterTypeBean bean					=				(MultipleInsertMasterTypeBean) getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);	

		ServletContext context = getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
		bean.setMode( mode ) ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	

		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
			try{
				
				alResult	=	(ArrayList)bean.fetchRecords("SELECT DEPT_CODE,ACCOUNT_NO,ACCOUNT_NAME,INITIAL_BDGT_AMT,ADDL_BDGT_AMT,BLOCKED_BDGT_AMT,BALANCE_BDGT_AMT,TO_CHAR (eff_date_from, 'dd/mm/yyyy') EFF_DATE_FROM, TO_CHAR(eff_date_to,'DD/MM/YYYY') eff_date_to , OVERRIDE_BUDGET from PO_COMMTTMENT_ACCOUNT a, PO_MASTER_CODE b where a.MASTER_TYPE = b.MASTER_TYPE and a.MASTER_CODE =b.MASTER_CODE  AND A.MASTER_CODE= ? ", alParam);
			
			}catch(Exception e){
				System.err.println("Error in Master Type Transaction Details");
				e.printStackTrace();
			}
		}

		if(bean.getExpRecords()!= null && (bean.getExpRecords()).size() > 0){
		alResult  = bean.getExpRecords(Integer.parseInt(index));
		}
				
	//	java.util.Collections.reverse(alResult);
		
		
	//sys_date							=			bean.getSystemDate();
		int size = 10;

		if(alResult!= null && alResult.size()!= 0){
				size = alResult.size();
			}
			
		

	//	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
	//	disabled = "disabled";
	//	}
		

%>
<form name="formcomcodedtls" id="formcomcodedtls">
	<table border='0' cellpadding='2' cellspacing='0' width='100%' height='100%' align=center>

		<tr>
		<td width='100%'   class="WHITE">	
		<table cellpadding="0" cellspacing="0" width='100%' border=1 align=center  id="myTable" >
		<tr>
		<th ><fmt:message key="ePO.Department.label" bundle="${po_labels}"/></th>
		<th ><fmt:message key="ePO.AccountNumber.label" bundle="${po_labels}"/></th>
		<th ><fmt:message key="ePO.AccountNumberDescription.label" bundle="${po_labels}"/></th>
		<th ><fmt:message key="ePO.AllocatedBudget.label" bundle="${po_labels}"/></th>
		<th ><fmt:message key="ePO.AdditionalBudget.label" bundle="${po_labels}"/></th>
		<th ><fmt:message key="ePO.BalanceBudget.label" bundle="${po_labels}"/></th>
		<th ><fmt:message key="ePO.BlockedBudget.label" bundle="${po_labels}"/></th>
		<th ><fmt:message key="ePO.EffectiveFrom.label" bundle="${po_labels}"/></th>
		<th ><fmt:message key="ePO.EffectiveTo.label" bundle="${po_labels}"/></th>
		<th ><fmt:message key="ePO.OverrideBudgetControl.label" bundle="${po_labels}"/></th>
		</tr>
		
		<%
			String classValue = null;
			int max_rows = Integer.parseInt(eCommon.Common.CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
			for ( int cnt=0; cnt<size; cnt++ ) {
				String error_selected = "";
				String warning_selected = "";
				String notApplicable_selected = "";
			
				if(cnt%2 ==0)
					classValue="QRYEVEN";
				else
					classValue="QRYODD";
					
				if(alResult!= null)	{
					if (cnt<alResult.size())
					hmResult = (HashMap)alResult.get(cnt);
					alResult1	=	(ArrayList)bean.fetchRecords("SELECT DEPT_CODE,ACCOUNT_NO,ACCOUNT_NAME,INITIAL_BDGT_AMT,ADDL_BDGT_AMT,BLOCKED_BDGT_AMT,BALANCE_BDGT_AMT,TO_CHAR (eff_date_from, 'dd/mm/yyyy') EFF_DATE_FROM, TO_CHAR(eff_date_to,'DD/MM/YYYY') eff_date_to , OVERRIDE_BUDGET from PO_COMMTTMENT_ACCOUNT a, PO_MASTER_CODE b where a.MASTER_TYPE = b.MASTER_TYPE and a.MASTER_CODE =b.MASTER_CODE  AND A.MASTER_CODE= ? ", alParam);
					if(alResult1.size() > 0){
					hmResult1 = (HashMap)alResult1.get(cnt);
					total_bdgt1 = bean.checkForNull((String)hmResult1.get("BALANCE_BDGT_AMT"));
					addnl_bdgt1 = bean.checkForNull((String)hmResult.get("ADDL_BDGT_AMT"));
					disabled = "disabled";
					}else{
					disabled = "";
					}	
					
						dept_code = bean.checkForNull((String)hmResult.get("DEPT_CODE"));
						acc_no =  bean.checkForNull((String)hmResult.get("ACCOUNT_NO"));
						acc_no_desc = bean.checkForNull((String)hmResult.get("ACCOUNT_NAME"));
						all_bdgt = bean.checkForNull((String)hmResult.get("INITIAL_BDGT_AMT"));
						addnl_bdgt = bean.checkForNull((String)hmResult.get("ADDL_BDGT_AMT"));
						blocked_bdgt = bean.checkForNull((String)hmResult.get("BLOCKED_BDGT_AMT"));
						total_bdgt = bean.checkForNull((String)hmResult.get("BALANCE_BDGT_AMT"));
						eff_dt_frm = com.ehis.util.DateUtils.convertDate(bean.checkForNull((String)hmResult.get("EFF_DATE_FROM")),"DMY","en",locale);
						eff_dt_to = com.ehis.util.DateUtils.convertDate(bean.checkForNull((String)hmResult.get("EFF_DATE_TO")),"DMY","en",locale);
						override_budget = bean.checkForNull((String)hmResult.get("OVERRIDE_BUDGET"));
						if(blocked_bdgt.equals("") || blocked_bdgt == null){
						blocked_bdgt = "0";
						}
						
						System.out.println("Over ride Budget = "+override_budget);
						
						if(override_budget.equals("E"))
							error_selected = "selected";
						else if(override_budget.equals("W")) 
							warning_selected = "selected";
						else if(override_budget.equals("N")) 	
							notApplicable_selected = "selected";
						else if(override_budget.equals("")) 	
							warning_selected = "selected";
			}
		%>
				<tr>
				<td  class="fields" >	&nbsp;
					<select name="dept_no_<%=cnt%>" id="dept_no_<%=cnt%>" <%=disabled%> >	
					<%=bean.getDept(dept_code)%>
					</select>
				</td>
				<td  class="<%=classValue %>" >
					<input type="text" name="acc_no_<%=cnt%>" id="acc_no_<%=cnt%>" value = "<%=acc_no%>" size="20" maxlength="20"  onKeyPress="return CheckForSpecChars(event)" onBlur="checkSpecialChars(this);">
				</td>
				<td  class="<%=classValue %>" >
					<input type="text" name="acc_no_desc_<%=cnt%>" id="acc_no_desc_<%=cnt%>" value = "<%=acc_no_desc%>" size="30" maxlength="30" >
				</td>
				
				
				<%
				
					if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) ){
				%>	
				
				<td  class="<%=classValue %>" >
					<input type="text" class="NUMBER" name="all_budget_<%=cnt%>" id="all_budget_<%=cnt%>" value = "<%=all_bdgt%>" size="8" maxlength="8" onkeypress="return isValidNumber(this,event,8,3);" onChange="displaytotalbudget_insert('<%=cnt%>');" >
				</td>
				<td  class="<%=classValue %>" >
					<input type="text" class="NUMBER" name="addnl_budget_<%=cnt%>" id="addnl_budget_<%=cnt%>" value = "<%=addnl_bdgt%>" size="8" maxlength="8" onkeypress="return isValidNumber(this,event,8,3);" onChange="displaytotalbudget_insert('<%=cnt%>');" >
				</td>
								
				<%
				  }
					if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
				%>	
				<td  class="<%=classValue %>" >
					<input type="text" class="NUMBER" name="all_budget_<%=cnt%>" id="all_budget_<%=cnt%>" value = "<%=all_bdgt%>" size="8" maxlength="8" onkeypress="return isValidNumber(this,event,8,3);"  onChange="displaytotalbudget_insert('<%=cnt%>');" onBlur="" <%=disabled%> >
				</td>
				<td  class="<%=classValue %>" >
					<input type="text" class="NUMBER" name="addnl_budget_<%=cnt%>" id="addnl_budget_<%=cnt%>" value = "<%=addnl_bdgt%>" size="8" maxlength="8" onkeypress="return isValidNumber(this,event,8,3);" onChange="displaytotalbudget_modify('<%=cnt%>','<%=total_bdgt1%>','<%=addnl_bdgt1%>');" >
				</td>
				
				
				<% } %>
				
				<td  class="<%=classValue %>" >
					<input type="text" class="NUMBER" name="total_budget_<%=cnt%>" id="total_budget_<%=cnt%>" value = "<%=total_bdgt%>" size="10" maxlength="10" onkeypress="return isValidNumber(this,event,10,3);" disabled>
				</td>
				<td  class="<%=classValue %>" >
					<input type="text" class="NUMBER" name="blocked_budget_<%=cnt%>" id="blocked_budget_<%=cnt%>" value = "<%=blocked_bdgt%>" size="10" maxlength="10" onkeypress="return isValidNumber(this,event,10,3);" disabled>
				</td>
				
				<td  class="<%=classValue %>" >
					<input type="text" name="from_date_<%=cnt%>" id="from_date_<%=cnt%>" size="10" class='DATE'value="<%=eff_dt_frm%>" <%=disabled%> maxlength="10" onBlur="CheckDate(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_date_<%=cnt%>');" <%=disabled%> ></img>
				</td>
				<td  class="<%=classValue %>" >
					<input type="text" name="to_date_<%=cnt%>" id="to_date_<%=cnt%>" size="10" class='DATE' value="<%=eff_dt_to%>" maxlength="10" onBlur="CheckDate(this);checkValidate(this);addRowToTable();" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_date_<%=cnt%>');" ></img>
				</td>
				<td  class="<%=classValue %>" >
					<select name="override_budget_<%=cnt%>" id="override_budget_<%=cnt%>" >
					<!--	<option value="" >&nbsp;---Select---&nbsp;</option>  -->
						<option value="E" <%=error_selected%> >Error</option>
						<option value="W" <%=warning_selected%>>Warning</option>
						<option value="N" <%=notApplicable_selected%>>Not Applicable</option>
				</td>

				
			</tr>

				<%
					y=cnt;
		}
		y++;

				for ( int j=y; j<10; j++ ) {
				if(j%2 ==0)
					classValue="QRYEVEN";
				else
					classValue="QRYODD";
	%>			

			<tr>
			<td  class="fields" >	&nbsp;
					<select name="dept_no_<%=j%>" id="dept_no_<%=j%>">	
					<%=bean.getDept("")%>
					</select>
				</td>
				<td  class="<%=classValue %>" >
					<input type="text" name="acc_no_<%=j%>" id="acc_no_<%=j%>" value = "" size="20" maxlength="20" onKeyPress="return CheckForSpecChars(event)" onBlur="checkSpecialChars(this);" >
				</td>
				<td  class="<%=classValue %>" >
					<input type="text" name="acc_no_desc_<%=j%>" id="acc_no_desc_<%=j%>" value = "" size="30" maxlength="30" >
				</td>
				<td  class="<%=classValue %>" >
					<input type="text" class="NUMBER" name="all_budget_<%=j%>" id="all_budget_<%=j%>" value = "" size="8" maxlength="8" onkeypress="return isValidNumber(this,event,8,3);" onChange="displaytotalbudget_insert('<%=j%>');">
				</td>
				<td  class="<%=classValue %>" >
					<input type="text" class="NUMBER" name="addnl_budget_<%=j%>" id="addnl_budget_<%=j%>" value = "" size="8" maxlength="8" onkeypress="return isValidNumber(this,event,8,3);" onChange="displaytotalbudget_insert('<%=j%>');" >
				</td>
				<td  class="<%=classValue %>" >
					<input type="text" class="NUMBER" name="total_budget_<%=j%>" id="total_budget_<%=j%>" value = "" size="10" maxlength="10" onkeypress="return isValidNumber(this,event,10,3);" disabled>
				</td>
				<td  class="<%=classValue %>" >
					<input type="text" class="NUMBER" name="blocked_budget_<%=j%>" id="blocked_budget_<%=j%>" value = "" size="10" maxlength="10" onkeypress="return isValidNumber(this,event,10,3);" disabled>
				</td>
				<td  class="<%=classValue %>" >
					<input type="text" name="from_date_<%=j%>" id="from_date_<%=j%>" size="10" class='DATE'value=""  maxlength="10" onBlur="CheckDate(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_date_<%=j%>');"  ></img>
				</td>
				<td  class="<%=classValue %>" >
					<input type="text" name="to_date_<%=j%>" id="to_date_<%=j%>" size="10" class='DATE' value="" maxlength="10" onBlur="CheckDate(this);checkValidate(this);addRowToTable();" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_date_<%=j%>');" ></img>
				</td>

				<td  class="<%=classValue %>" >
					<select name="override_budget_<%=j%>" id="override_budget_<%=j%>" >
					<!--	<option value="" >&nbsp;---Select---&nbsp;</option>  -->
						<option value="E" >Error</option>
						<option value="W" selected>Warning</option>
						<option value="N" >Not Applicable</option>
				</td>
				
			</tr>

		<%}
	
		size = 10;
		%>		
	</table>

	<tr>
	<td  colspan='7'  align="right"><input type="button" name="close" id="close" value= '  OK  '  class="button" onClick="returnVals(<%=index%>);">
	</tr>

	</td>
	</tr>
	</table>
	
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="finalize_yn" id="finalize_yn"			value="No">
	<input type="hidden" name="totalRecords" id="totalRecords" value="<%=size%>">
	<input type="hidden" name="dept_no" id="dept_no" value="">
	<input type="hidden" name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
	
<input type="hidden" name="acc_no" id="acc_no" value="">
<input type="hidden" name="acc_no_desc" id="acc_no_desc" value="">
<input type="hidden" name="all_budget" id="all_budget" value="">
<input type="hidden" name="addnl_budget" id="addnl_budget" value="">
<input type="hidden" name="total_budget" id="total_budget" value="">
<input type="hidden" name="from_date" id="from_date" value="">
<input type="hidden" name="to_date" id="to_date" value="">
<input type="hidden" name="master_code" id="master_code" value="<%=master_code%>">
<input type="hidden" name="long_desc" id="long_desc" value="<%=long_desc%>">
<input type="hidden" name="short_desc" id="short_desc" value="<%=short_desc%>">
<input type="hidden" name="eff_status" id="eff_status" value="<%=eff_status%>">
<input type="hidden" name="comm_rec" id="comm_rec"   value="<%=alResult1.size()%>">	



	
</form>
<%
		putObjectInBean(bean_id,bean,request);
		
%>
</body>
</html>

