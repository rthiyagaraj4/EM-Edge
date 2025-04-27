<!DOCTYPE html>
<%@  page import="java.sql.*,  webbeans.eBL.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*, eBL.BLPatRegChargesBean" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>


<%
	Connection con				= null;
try{	
	request.setCharacterEncoding("UTF-8");
	CurrencyFormat cf = new CurrencyFormat();
	PreparedStatement pstmt		= null ;
	ResultSet rscurr				= null;
	con	=	ConnectionManager.getConnection(request);
	//HttpSession httpSession = request.getSession(false);
	String pat_reg_chrg_amt = request.getParameter("pat_reg_chrg_amt") == null ? "" :request.getParameter("pat_reg_chrg_amt") ;
	String pat_reg_chrg_pat_amt = request.getParameter("pat_reg_chrg_pat_amt") == null ? "" :request.getParameter("pat_reg_chrg_pat_amt");
	String patregnchargeYN=request.getParameter("patregnchargeYN") == null ? "" :request.getParameter("patregnchargeYN") ;
	String patient_id=request.getParameter("patient_id") == null ? "" :request.getParameter("patient_id") ;
	String cur_acct_seq_no=request.getParameter("cur_acct_seq_no") == null ? "" :request.getParameter("cur_acct_seq_no") ;
	String serv_panel_ind=request.getParameter("serv_panel_ind") == null ? "" :request.getParameter("serv_panel_ind") ;
	String serv_panel_code=request.getParameter("serv_panel_code") == null ? "" :request.getParameter("serv_panel_code") ;
	String service_date=request.getParameter("service_date") == null ? "" :request.getParameter("service_date") ;
	String blng_grp_id=request.getParameter("blng_grp_id") == null ? "" :request.getParameter("blng_grp_id") ;	
	String function_id = request.getParameter("function_id") == null ? "" :request.getParameter("function_id") ;

	int noofdecimal=2;
	String bean_id = "BLPatRegChargesBean" ;
	String bean_name = "eBL.BLPatRegChargesBean";
	//BLPatRegChargesBean bean			= (BLPatRegChargesBean)getBeanObject( bean_id, bean_name, request ) ;
	try{	
		pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
		rscurr = pstmt.executeQuery();	
		while(rscurr.next())
		{
			noofdecimal  =  rscurr.getInt(1);		
		}
		rscurr.close();
		pstmt.close();
	}catch(Exception e)
	{
		System.out.println("3="+e.toString());
	}
	pat_reg_chrg_amt = cf.formatCurrency(pat_reg_chrg_amt, noofdecimal);
	pat_reg_chrg_pat_amt = cf.formatCurrency(pat_reg_chrg_pat_amt, noofdecimal);
	
%>
<html>
	<head>

	<title><fmt:message key="eBL.PAT_REG_CHRG.label" bundle="${bl_labels}"/></title>
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
			<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language='javascript' src='../../eBL/js/AddModifyPatFinDetails.js'></script>			
			<script language='javascript' src='../../eBL/js/BLMPPatRegCharges.js'></script>			
			<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
			<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	</head>
<script>
	function showregcharge()
	{	
		var patregnchargeYN=document.forms[0].patregnchargeYN.value;		
		if(patregnchargeYN == "Y")
		{				
			//document.getElementById("patregchrgamt").innerText=document.forms[0].pat_reg_chrg_amt.value;
			//document.getElementById("patregchrgpatamt").innerText=document.forms[0].pat_reg_chrg_pat_amt.value;
		}
	}

	
	
</script>

<body onLoad='showregcharge()' onUnload='' onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect = "codeArrestThruSelect();">
<form name='patRegChargeDet' id='patRegChargeDet' method='post' action=''>		
<table cellpadding='3' cellspacing='0' border='0' align='center' width='100%' height='100%'>	

	<tr>
<%
	
	if(patregnchargeYN.equals("Y"))
	{
		
%>
		<td width="25%" class="label" align='right'><a href="#" onClick="pat_reg_chrg();"><fmt:message key="eBL.PAT_REG_CHRG.label" bundle="${bl_labels}"/></a></td>
		<td width="25%" class="label" align='left'><b id="patregchrgamt"><%=pat_reg_chrg_amt%></b></td>
		<td width="25%" class="label" align='right'><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/></td>
		<td width="25%" class="label" align='left'><b id="patregchrgpatamt"><%=pat_reg_chrg_pat_amt%></b></td>		
	</tr>
	<tr>		 
		<td width="25%" class="label" align='left'>&nbsp;</td>
		<td width="25%" class="label" align='left'>&nbsp;</td>		
		<td width="25%" class="label" align='right'><input type=button class='button' name='continue' id='continue' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Continue.label","common_labels")%>" onClick='return callSlmtValidation("STEP_BL");'></td>
		<td width="25%" align='left'>		
		<input type=button class='button' name='close' id='close' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick='close_det();'></td>
	</tr>
<%
	}
	%>

</table>
<input type='hidden' name='pat_reg_chrg_amt' id='pat_reg_chrg_amt' value='<%=pat_reg_chrg_amt%>'>	
<input type='hidden' name='pat_reg_chrg_pat_amt' id='pat_reg_chrg_pat_amt' value='<%=pat_reg_chrg_pat_amt%>'>	
<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>	
<input type='hidden' name='cur_acct_seq_no' id='cur_acct_seq_no' value='<%=cur_acct_seq_no%>'>	
<input type='hidden' name='serv_panel_code' id='serv_panel_code' value='<%=serv_panel_code%>'>	
<input type='hidden' name='serv_panel_ind' id='serv_panel_ind' value='<%=serv_panel_ind%>'>	
<input type='hidden' name='service_date' id='service_date' value='<%=service_date%>'>	
<input type='hidden' name='patregnchargeYN' id='patregnchargeYN' value='<%=patregnchargeYN%>'>	
<input type='hidden' name='bean_id' id='bean_id' value='<%=bean_id%>'>	
<input type='hidden' name='bean_name' id='bean_name' value='<%=bean_name%>'>	
<input type='hidden' name='blng_grp_id' id='blng_grp_id' value='<%=blng_grp_id%>'>	
<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>	
	
	 
</form>
</body>

<%
	}
	catch(Exception e)
	{
		System.out.println("Main Exception:"+e);
	}
	finally
	{ 
		ConnectionManager.returnConnection(con, request);
	}
%>

</html>



