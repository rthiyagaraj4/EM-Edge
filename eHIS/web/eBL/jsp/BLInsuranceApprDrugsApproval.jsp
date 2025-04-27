<!DOCTYPE html>
<%@page import="java.util.*,eBL.* , eOR.* ,eOR.Common.*,eCommon.Common.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../../eBL/js/BLInsuranceApprDrugsList.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	
</head>

<%
	try {
	request.setCharacterEncoding("UTF-8");
	String mode	     = request.getParameter( "mode" ) ;	
	String login_user	= (String)session.getValue("login_user");
	String bean_id   = "@BLInsuranceApprDrugsBean" ;
	String bean_name = "eBL.BLInsuranceApprDrugsBean";
	String sel_drug_code = request.getParameter("sel_drug_code");
	if(sel_drug_code == null) sel_drug_code = "";
	String sel_drug_code_apprvd_YN = request.getParameter("sel_drug_code_apprvd_YN");
	if(sel_drug_code_apprvd_YN == null) sel_drug_code_apprvd_YN = "N";	
	String selectAllYN = request.getParameter("selectAllYN");
	if(selectAllYN == null) selectAllYN = "N";	
	
	String billingGrp = request.getParameter("billingGrp");
	if(billingGrp == null) billingGrp = "N";	
	
	String payerGroup = request.getParameter("payerGroup");
	if(payerGroup == null) payerGroup = "N";	
	
	String payer = request.getParameter("payer");
	if(payer == null) payer = "N";	
	
	String policyType = request.getParameter("policyType");
	if(policyType == null) policyType = "N";	
	
	String calledFrm = request.getParameter("calledFrm");
	if(calledFrm == null) calledFrm = "";	
		
	String facility_id = (String)session.getValue("facility_id");
	BLInsuranceApprDrugsBean bean = (BLInsuranceApprDrugsBean)getBeanObject( bean_id,  bean_name, request ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setMode( mode ) ;
	bean.setLanguageId(localeName);
	ArrayList Pending_Order_Status = new ArrayList();
	String from	 = bean.checkForNull(request.getParameter( "from" ),"0") ;
	String to	 = bean.checkForNull(request.getParameter( "to" ),"16") ;
	
 	int start	 = Integer.parseInt(from);
	int end		= Integer.parseInt(to);
	int j=0;
	String slClassValue = "";
	String checked1 = "";
	String checked2 = "";
	String chkStr = request.getParameter("str")==null?"":request.getParameter("str");
	String clickedTab = request.getParameter("clickedTab")==null?"":request.getParameter("clickedTab");
	
	System.err.println("mode:"+mode);
	System.err.println("chkStr:"+chkStr);
	System.err.println("clickedTab:"+clickedTab);
	System.err.println("sel_drug_code:"+sel_drug_code);
	if(chkStr.equals("") && clickedTab.equals("SEARCH")){
		bean.clear();
		Pending_Order_Status = bean.getNewOrderStatus(sel_drug_code, facility_id, mode,billingGrp,payerGroup,payer,policyType);
	}else{
		System.err.println("Get data from getOrderSatList");
 	    Pending_Order_Status = bean.getOrderSatList();
	}
	int maxRecord = (Pending_Order_Status.size() / 8);
	System.err.println("maxRecord-"+maxRecord);
	if(maxRecord <= end)
		end = maxRecord-1;
	
	int index=(start*8);
	int l=start;
	
	if("Q".equals(calledFrm)){
	
%>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad = "loadSelRowsToSession();" >

<% 
	}else{
		
%>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad = "" >
<%		
	}
%>	
	<form name="indirect_order_status" id="indirect_order_status">
	
		<table  width='100%' border=0 >
				<tr>
					<td class='NONURGENT' align="right">
						<input type='hidden' name='from' id='from' value='<%=start%>'>
						<input type='hidden' name='to' id='to' value='<%=end%>'>

<%
						if( start > 0 ) {
%>
							<a href='javascript:submitPrevNext(<%=(start-16)%>,<%=(start-1)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
							<input type='hidden' name='prevPage' id='prevPage' value='prev'>
<%
						}
						
						if(!((start+16) >= maxRecord )){
%>
							<a href='javascript:submitPrevNext(<%=(start+16)%>,<%=(start+32)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
							<input type='hidden' name='nextPage' id='nextPage' value='next'>
<%
						}
%>
					</td>
				</tr>
		</table>
		<table  class='grid' width="85%" align="center">
			<tr>
				<td class="COLUMNHEADER" width='' style="text-align:center;">
					<fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/>
				</td>
				<td class='COLUMNHEADER' width='' style="text-align:center;" nowrap>
					<fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/>
				</td>
<!--				
				<td class='COLUMNHEADER' width='' style="text-align:center;" nowrap>
					<input type='checkbox' name='apprAll' id='apprAll' id='apprAll' value='<%=selectAllYN%>' onclick="chkApprAndPatClass(this,'X','ApprAllDrugs','X',0);" <%=("Y".equals(selectAllYN) ? "checked" : "")%>>					
					<fmt:message key="Common.Approved.label" bundle="${common_labels}"/>

				</td>
-->				
				<td class='COLUMNHEADER' width='' style="text-align:center;" nowrap>
					<fmt:message key="Common.IP.label" bundle="${common_labels}"/>
				</td>
				<td class='COLUMNHEADER' width='' style="text-align:center;" nowrap>
					<fmt:message key="Common.DC.label" bundle="${common_labels}"/>
				</td>
				<td class='COLUMNHEADER' width='' style="text-align:center;" nowrap>
					<fmt:message key="Common.OP.label" bundle="${common_labels}"/>
				</td>
				<td class='COLUMNHEADER' width='' style="text-align:center;" nowrap>
					<fmt:message key="Common.EM.label" bundle="${common_labels}"/>
				</td>
				<td class='COLUMNHEADER' width='' style="text-align:center;" nowrap>
					<fmt:message key="Common.all.label" bundle="${common_labels}"/>
				</td>
			</tr>
			
<%
		if("".equals(sel_drug_code)){
			while(l <= end){
					//System.err.println(index);
					if( (l+1)%2 == 0)  
						slClassValue="gridData";
					else
						slClassValue="gridData";
					
					String drugCode = (String)Pending_Order_Status.get(index);
					String drugDesc = (String)Pending_Order_Status.get(index+1);
					String approvalYN = (String)Pending_Order_Status.get(index+2);
					String IPYN = (String)Pending_Order_Status.get(index+3);
					String DCYN = (String)Pending_Order_Status.get(index+4);
					String OPYN = (String)Pending_Order_Status.get(index+5);
					String EMYN = (String)Pending_Order_Status.get(index+6);
					String ALLYN = (String)Pending_Order_Status.get(index+7);
%>
			<tr>
				<td class='gridData' style="text-align:center;">
					<%=Pending_Order_Status.get(index)%>
					<input type='hidden' name='order_status_code<%=l%>' id='order_status_code<%=l%>' value=<%=drugCode%>>	
				</td>
				<td class='gridData' style="text-align:center;">
					<%=drugDesc%>
					<input type='hidden' name='long_desc<%=l%>' id='long_desc<%=l%>' value="<%=drugDesc%>">	
					<input type='hidden' name='apprChk_<%=l%>'  id='apprChk_<%=l%>'  value='<%=Pending_Order_Status.get(index+2)%>' >
				</td>				
<%
					if(approvalYN.equals("Y") || approvalYN.equals("A")){
						checked1="checked";
					}
					else{
						checked1="";
					}
%>                   
<!--    
				<td class='<%=slClassValue%>' width='10%' style="text-align:center;">
					<input type='checkbox' name='apprChk_<%=l%>' id='apprChk_<%=l%>' id='apprChk_<%=l%>'  value='<%=Pending_Order_Status.get(index+2)%>'  
					onclick="chkApprAndPatClass(this, order_status_code<%=l%>,'apprChk', long_desc<%=l%>,<%=l%>);" <%=checked1%>>
				</td>
-->				
				<td class='<%=slClassValue%>' width='10%' style="text-align:center;">
					<input type='checkbox' name='chkIPPatClass_<%=l%>' id='chkIPPatClass_<%=l%>'  value='<%=IPYN%>' 
					onclick="chkApprAndPatClass(this, order_status_code<%=l%>,'IP',long_desc<%=l%>, <%=l%>);" <%="Y".equals(IPYN)?"checked":""%> >
				</td>
				<td class='<%=slClassValue%>' width='10%' style="text-align:center;">
					<input type='checkbox' name='chkDCPatClass_<%=l%>' id='chkDCPatClass_<%=l%>'  value='<%=DCYN%>' 
					onclick="chkApprAndPatClass(this, order_status_code<%=l%>,'DC',long_desc<%=l%>,<%=l%>);" <%="Y".equals(DCYN)?"checked":""%> >
				</td>
				<td class='<%=slClassValue%>' width='10%' style="text-align:center;">
					<input type='checkbox' name='chkOPPatClass_<%=l%>' id='chkOPPatClass_<%=l%>' value='<%=OPYN%>' 
					onclick="chkApprAndPatClass(this, order_status_code<%=l%>,'OP',long_desc<%=l%>,<%=l%>);" <%="Y".equals(OPYN)?"checked":""%> >
				</td>				
				<td class='<%=slClassValue%>' width='10%' style="text-align:center;">
					<input type='checkbox' name='chkEMPatClass_<%=l%>' id='chkEMPatClass_<%=l%>'  value='<%=EMYN%>' 
					onclick="chkApprAndPatClass(this, order_status_code<%=l%>,'EM',long_desc<%=l%>,<%=l%>);" <%="Y".equals(EMYN)?"checked":""%> >
				</td>
				<td class='<%=slClassValue%>' width='10%' style="text-align:center;">
					<input type='checkbox' name='chkAllPatClass_<%=l%>' id='chkAllPatClass_<%=l%>'  value='<%=ALLYN%>' 
					onclick="chkApprAndPatClass(this, order_status_code<%=l%>,'ALL', long_desc<%=l%>,<%=l%>);" <%="Y".equals(ALLYN)?"checked":""%> >
				</td>				
			</tr>
<%
					index+=8; 
					l++;
			}
		} else {
			System.err.println("In specific drug loop");
			while(l <= end){
					//System.err.println(index);
					if( (l+1)%2 == 0)  
						slClassValue="gridData";
					else
						slClassValue="gridData";
					String lcl_drug_code = (String)Pending_Order_Status.get(index);
					
				if(sel_drug_code.equals(lcl_drug_code)){
					
%>

			<tr>
				<td class='gridData' style="text-align:center;">
					<%=Pending_Order_Status.get(index)%>
					<input type='hidden' name='order_status_code<%=l%>' id='order_status_code<%=l%>' value=<%=Pending_Order_Status.get(index)%>>	
				</td>
				<td class='gridData' style="text-align:center;">
					<%=Pending_Order_Status.get(index+1)%>
					<input type='hidden' name='long_desc<%=l%>' id='long_desc<%=l%>' value=<%=Pending_Order_Status.get(index+1)%>>	
				</td>				
<%
				}
					index = index+2;
					if(((String)Pending_Order_Status.get(index)).equals("Y")||((String)Pending_Order_Status.get(index)).equals("A")){
						checked1="checked";
					}
					else{
						checked1="";
					}
				if(sel_drug_code.equals(lcl_drug_code)){
%>                       
				<td class='<%=slClassValue%>' width='20%' style="text-align:center;">
					<input type='checkbox' name='chk1_<%=l%>' id='chk1_<%=l%>' id='chk1_<%=l%>'  value=''  onclick='checkChk1Value(this, order_status_code<%=l%>,"chk1");' <%=checked1%>>
				</td>
				
				<td class='<%=slClassValue%>' width='10%' style="text-align:center;">
					<input type='checkbox' name='chk1_<%=l%>' id='chk1_<%=l%>' id='chk1_<%=l%>'  value=''  onclick="checkChk1Value(this, order_status_code<%=l%>,'chk1', long_desc<%=l%>);" <%=checked1%>>
				</td>
				<td class='<%=slClassValue%>' width='10%' style="text-align:center;">
					<input type='checkbox' name='chkIPPatClass_<%=l%>' id='chkIPPatClass_<%=l%>'  value='' onclick="checkPatClass('IP','<%=mode%>',this,<%=l%>);" >
				</td>
				<td class='<%=slClassValue%>' width='10%' style="text-align:center;">
					<input type='checkbox' name='chkDCPatClass_<%=l%>' id='chkDCPatClass_<%=l%>'  value='' onclick="checkPatClass('DC','<%=mode%>',this,<%=l%>);" >
				</td>
				<td class='<%=slClassValue%>' width='10%' style="text-align:center;">
					<input type='checkbox' name='chkOPPatClass_<%=l%>' id='chkOPPatClass_<%=l%>'  value='' onclick="checkPatClass('OP','<%=mode%>',this,<%=l%>);" >
				</td>				
				<td class='<%=slClassValue%>' width='10%' style="text-align:center;">
					<input type='checkbox' name='chkEMPatClass_<%=l%>' id='chkEMPatClass_<%=l%>'  value='' onclick="checkPatClass('EM','<%=mode%>',this,<%=l%>);" >
				</td>
				<td class='<%=slClassValue%>' width='10%' style="text-align:center;">
					<input type='checkbox' name='chkAllPatClass_<%=l%>' id='chkAllPatClass_<%=l%>'  value='' onclick="checkPatClass('ALL','<%=mode%>',this,<%=l%>);" >
				</td>
				
			</tr>	
<%
				}
					index+=1; 
					l++;	
				}
			}
%>		
		</table>	
		<input type="hidden"  name="totalRecords" id="totalRecords" value="<%=Pending_Order_Status.size()%>">
		<input type="hidden" name="mode" id="mode" value="<%=mode%>">
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
		<input type="hidden" name="function_id" id="function_id" value="EBL_REST_CANC_SERVICE">
		<input type="hidden" name='total_recs' id='total_recs' value='<%=j%>'>
		<input type='hidden' name='sel_drug_code' id='sel_drug_code' value='<%=sel_drug_code%>'>
		<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
		<input type='hidden' name='login_user' id='login_user' value='<%=login_user%>'>
		<input type='hidden' name='selectAllYN' id='selectAllYN' value='<%=selectAllYN%>'>
		<input type='hidden' name='apprAll' id='apprAll' id='apprAll' value='N'>	
		
		<%
		Pending_Order_Status=null;
		%>
	</form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);

} catch(Exception e) {
	System.err.println("Exception in IndirectServCancel.jsp:"+e);
}
%>

