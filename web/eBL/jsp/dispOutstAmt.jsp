<!DOCTYPE html>
<%@  page  contentType="text/html;charset=UTF-8" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 <!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
 <!-- Author - kumar: this jsp included as part of dispCreditAuth.jsp-->
<%@ page import="java.sql.*,webbeans.op.CurrencyFormat, webbeans.eCommon.*"%> <!--,op.CurrencyFormat-->
<%
	Connection con = null;
	PreparedStatement pstmt =null;
	ResultSet rs =null;	
	request.setCharacterEncoding("UTF-8");

	String ind_bal_available_YN = "";

	String Patient_id = request.getParameter("patient_id");
	if(Patient_id == null) Patient_id="";

	String v_episode_type = request.getParameter("v_episode_type");
	if(v_episode_type == null) v_episode_type="";

	String outst_amt	= request.getParameter("outst_amt");	
	if(outst_amt == null) outst_amt="0";
	
	String str_module_id = request.getParameter("calling_module_id");
	if(str_module_id == null) str_module_id="";
	if(str_module_id.equals("OP")) v_episode_type="O";
	if(str_module_id.equals("IP")) v_episode_type="I";
	if(str_module_id.equals("AE")) v_episode_type="E";
	if(str_module_id.equals("DC")) v_episode_type="D";
	
	//double	patient_outst_amt = Double.parseDouble(outst_amt);
//	double outst_amount_limit = 0;
//	double op_outst_amount_limit = 0, ae_outst_amount_limit = 0, ip_outst_amount_limit = 0, dc_outst_amount_limit = 0;
	int noofdecimal=0;
	CurrencyFormat cf = new CurrencyFormat();
	
	String patient_remarks ="";
	String facility_id  =  (String) session.getValue("facility_id");
//	String credit_auth_req_yn = "" ;
//	String op_credit_auth_req_yn = "", ae_credit_auth_req_yn = "", ip_credit_auth_req_yn = "", dc_credit_auth_req_yn = "";
	double tot_unbilled_amt=0, tot_installment_due=0, tot_outstanding_amt =0,tot_written_off_amt=0;//unbilled_amt=0,outstdg_amt=0,instl_due_amt=0,wo_amt=0;
	String credit_auth_reqd_yn="",unbld_disp_yn="", outst_disp_yn="",instl_disp_yn="",wo_disp_yn="";
//	outst_oper="",instl_oper="",wo_oper="",;
	String p_credit_auth_check_result_yn="";//str_tot_outstanding_amt="",str_tot_written_off_amt="",str_tot_unbilled_amt="",str_tot_installment_due="",
	//String str_unbilled_amt="",str_outstdg_amt="",str_instl_due_amt="",	str_wo_amt="";
//	String x_str="",str_temp="";		
	String p_unbilled_amt="",p_outstdg_amt="",p_instl_due_amt="",p_wo_amt="",p_error_level="",p_error_text="",p_sys_msg_id="";
	//boolean rec_found=false;
	String P_dep_amt="", dep_disp_yn="";//V231010-ML-MMOH-CRF-1614
	double tot_deposit_amt=0;//V231010
	try
	{				
		con	=	ConnectionManager.getConnection(request);	
		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			ResultSet rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);		
			}	
			if(rscurr!=null) rscurr.close();
			pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in No of Decimal Query="+e.toString());
		}
		//V231010 Starts
		boolean  depositShow= false;
		String depositShowYN = "N";	
		try {
			depositShow = eCommon.Common.CommonBean.isSiteSpecific(con,"BL", "DEPOSITAMT_IN_CREDIT_AUTH");
			if (depositShow)
				depositShowYN = "Y";
			else
				depositShowYN = "N";
		  } catch (Exception ex) {
			ex.printStackTrace();
			System.err.println("Exception in depositBalanceAmt ::" + ex);
		}
		//V231010 Ends -SA00003375
		try
		{			
			pstmt = con.prepareStatement("select patient_remarks from mp_patient_remarks where patient_id=?");		
			pstmt.setString(1, Patient_id);
			rs = pstmt.executeQuery();	
			if (rs!=null)
			{
				while (rs.next())
				{
					patient_remarks = rs.getString("patient_remarks");		  
					if (patient_remarks == null) patient_remarks = "";
				}
			}
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
		finally 
		{
			if (pstmt != null) pstmt.close();
			if (rs != null)   rs.close();
			//ConnectionManager.returnConnection(con, request);
		}
	
	  	/* commented on 31-03-09
		try
	    {		
			//con	=	ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement("select nvl(credit_auth_reqd_yn,'N'), nvl(AE_CREDIT_AUTH_REQD_YN,'N'), nvl(IP_CREDIT_AUTH_REQD_YN,'N'), nvl(DC_CREDIT_AUTH_REQD_YN,'N'), nvl(outst_amt_limit,0), nvl(ae_outst_amt_limit,0), nvl(ip_outst_amt_limit,0), nvl(dc_outst_amt_limit,0) from bl_parameters where operating_facility_id='"+facility_id+"'");		
	
			rs = pstmt.executeQuery();	
		
			if (rs!=null)
			{
				while (rs.next())
				{
					op_credit_auth_req_yn = rs.getString(1);
					ae_credit_auth_req_yn = rs.getString(2);
					ip_credit_auth_req_yn = rs.getString(3);
					dc_credit_auth_req_yn = rs.getString(4);
//					outst_amount_limit = rs.getDouble(2);
					op_outst_amount_limit = rs.getDouble(5);
					ae_outst_amount_limit = rs.getDouble(6);
					ip_outst_amount_limit = rs.getDouble(7);
					dc_outst_amount_limit = rs.getDouble(8);
				}
		  	}
			if(op_credit_auth_req_yn == null) op_credit_auth_req_yn="N";
			if(ae_credit_auth_req_yn == null) ae_credit_auth_req_yn="N";
			if(ip_credit_auth_req_yn == null) ip_credit_auth_req_yn="N";
			if(dc_credit_auth_req_yn == null) dc_credit_auth_req_yn="N";
		}
		catch(Exception e)
		{ 
			out.println("Error while executing bl_parameters query:"+ e.toString());
		}
		finally 
		{
			 if (pstmt != null) pstmt.close();
			 if (rs != null)   rs.close();
		//ConnectionManager.returnConnection(con, request);
		}*/
		//comment end
		try
	    {
			String chk_enc_crdt_auth="{ call BLCOMMON.CHECK_ENC_CREDIT_AUTH('"+facility_id+"','"+Patient_id+"','"+v_episode_type+"',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; //Added 2 params -V231010
//			System.out.println("chk_enc_crdt_auth"+chk_enc_crdt_auth);
			CallableStatement call = con.prepareCall(chk_enc_crdt_auth);

			call.registerOutParameter(1,java.sql.Types.VARCHAR);
			call.registerOutParameter(2,java.sql.Types.VARCHAR);
			call.registerOutParameter(3,java.sql.Types.VARCHAR);
			call.registerOutParameter(4,java.sql.Types.VARCHAR);
			call.registerOutParameter(5,java.sql.Types.VARCHAR);
			call.registerOutParameter(6,java.sql.Types.VARCHAR);
			call.registerOutParameter(7,java.sql.Types.VARCHAR);
			call.registerOutParameter(8,java.sql.Types.VARCHAR);
			call.registerOutParameter(9,java.sql.Types.VARCHAR);
			call.registerOutParameter(10,java.sql.Types.VARCHAR);
			call.registerOutParameter(11,java.sql.Types.VARCHAR);
			call.registerOutParameter(12,java.sql.Types.VARCHAR);
			call.registerOutParameter(13,java.sql.Types.VARCHAR);
			call.registerOutParameter(14,java.sql.Types.VARCHAR);
			call.registerOutParameter(15,java.sql.Types.VARCHAR);
			call.execute();
			credit_auth_reqd_yn=call.getString(1);
			p_credit_auth_check_result_yn=call.getString(2);
			p_unbilled_amt=call.getString(3);
			unbld_disp_yn=call.getString(4);
			p_outstdg_amt=call.getString(5);
			outst_disp_yn=call.getString(6);
			p_instl_due_amt=call.getString(7);
			instl_disp_yn=call.getString(8);
			p_wo_amt=call.getString(9);
			wo_disp_yn=call.getString(10);
			P_dep_amt=call.getString(11);//V231010
			dep_disp_yn=call.getString(12);//V231010
			
			p_error_level=call.getString(13);
			p_sys_msg_id=call.getString(14);
			p_error_text=call.getString(15);

			if(credit_auth_reqd_yn==null) credit_auth_reqd_yn="";
			if(p_credit_auth_check_result_yn==null) p_credit_auth_check_result_yn="";
			if(p_unbilled_amt==null) p_unbilled_amt="0";
			if(unbld_disp_yn==null) unbld_disp_yn="";
			if(p_outstdg_amt==null) p_outstdg_amt="0";
			if(outst_disp_yn==null) outst_disp_yn="";
			if(p_instl_due_amt==null) p_instl_due_amt="0";
			if(instl_disp_yn==null) instl_disp_yn="";
			if(p_wo_amt==null) p_wo_amt="0";
			if(wo_disp_yn==null) wo_disp_yn="";
			if(P_dep_amt==null) P_dep_amt="0";//V231010
			if(dep_disp_yn==null) dep_disp_yn="";//V231010
			if(p_error_level==null) p_error_level="";
			if(p_sys_msg_id==null) p_sys_msg_id="";
			if(p_error_text==null) p_error_text="";	
			System.err.println("credit_auth_reqd_yn "+credit_auth_reqd_yn +"p_credit_auth_check_result_yn "+p_credit_auth_check_result_yn);

			tot_outstanding_amt = Double.parseDouble(p_outstdg_amt);
			tot_written_off_amt = Double.parseDouble(p_wo_amt);
			tot_unbilled_amt = Double.parseDouble(p_unbilled_amt);
			tot_installment_due = Double.parseDouble(p_instl_due_amt);
			tot_deposit_amt = Double.parseDouble(P_dep_amt);//V231010

			p_outstdg_amt= cf.formatCurrency(p_outstdg_amt, noofdecimal);
			p_wo_amt= cf.formatCurrency(p_wo_amt, noofdecimal);
			p_unbilled_amt= cf.formatCurrency(p_unbilled_amt, noofdecimal);
			p_instl_due_amt= cf.formatCurrency(p_instl_due_amt, noofdecimal);
			P_dep_amt=cf.formatCurrency(P_dep_amt, noofdecimal);//V231010
			System.err.println("tot_deposit_amt "+tot_deposit_amt);
			call.close();
		}
		catch(Exception e)
		{ 
			out.println("Error while executing bl_parameters query:"+ e.toString());
		}
		finally 
		{
			 if (pstmt != null) pstmt.close();
			 if (rs != null)   rs.close();		
		}
		
		if((p_error_level.equals("10") && !p_error_level.equals("")) || !p_sys_msg_id.equals(""))
		{
			if (p_error_level.equals("10") && !p_error_level.equals(""))
			{
%>
				<script>
					var strErrorMessage = '<%=p_error_text%>';
					alert(strErrorMessage);
					//window.close();
					let dialogBody = parent.parent.document.getElementById('dialog-body');
					dialogBody.contentWindow.returnValue = returnArray;
					const dialogTag = parent.parent.document.getElementById('dialog_tag');    
					dialogTag.close();
				</script>
<%
			}
			if(!p_sys_msg_id.equals(""))
			{
%>
			   <script>
					alert(getMessage('<%=p_sys_msg_id%>','BL'));
					//window.close();
				let dialogBody = parent.parent.document.getElementById('dialog-body');
				dialogBody.contentWindow.returnValue = returnArray;
				const dialogTag = parent.parent.document.getElementById('dialog_tag');    
				dialogTag.close();					
			   </script>
<%			
			}	
		}
%>
<html>
<head>
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script>	
	function confirmPasswd(obj)
	{	
		var usr_id=document.forms[0].user_id;
		var pass_wd=document.forms[0].passwd;
		var rmks=document.forms[0].remarks;
		if(usr_id.value=="")
		{
			alert(getMessage("BL9112","BL"));
			usr_id.focus();
			return false;
		}
		if(pass_wd.value=="")
		{
			alert(getMessage("BL9541","BL"));
			pass_wd.focus();
			return false;
		}
	
		var HTMLVal="<html><body><form name='BLConfirmPassWdForm' id='BLConfirmPassWdForm' method='post' action='BLConfirmPassWd.jsp'>"+
		"<input type='hidden' name='usr_id' id='usr_id' value='"+usr_id.value+"'>"+
		"<input type='hidden' name='pass_wd' id='pass_wd' value='"+pass_wd.value+"'>"+
			"<input type='hidden' name='remarks' id='remarks' value='"+rmks.value+"'>"+
		"</form></body></html>";
		parent.frames[1].document.body.insertAdjacentHTML('afterbegin', HTMLVal);
		parent.frames[1].document.BLConfirmPassWdForm.submit();
		return true;	
	}

	function confirmOK(obj)
	{				
		var HTMLVal="<html><body><form name='BLConfirmPassWdForm' id='BLConfirmPassWdForm' method='post' action='BLConfirmPassWd.jsp'>"+				
		"</form></body></html>";
		parent.frames[1].document.body.insertAdjacentHTML('afterbegin', HTMLVal);
		parent.frames[1].document.BLConfirmPassWdForm.submit();
		return true;	
	}

	function retModal(obj)
	{

		var returnArray = new Array ("N");
		//parent.window.returnValue = returnArray;
		var dialogBody = parent.parent.document.getElementById('dialog-body');
		dialogBody.contentWindow.returnValue = returnArray;
	}

	function retArray(obj)
	{ 
		var returnArray = new Array("1");
		parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = returnArray;
		parent.parent.document.getElementById('dialog_tag').close();  
	}

	function chkbox(obj)
	{
		if(obj.checked)
		{
			obj.checked = false;
		}
		else
		{
			obj.checked = true;
		}
	}
</script>
</head>
<style>
		textarea 	{
		 overflow-y: scroll;
		resize: none;
		}
	</style>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<center>
	<form name="pat_outst_amt" id="pat_outst_amt" method=post action="">
	<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>		
<%
		if(tot_unbilled_amt > 0 || tot_outstanding_amt > 0 || tot_written_off_amt > 0  || tot_installment_due > 0 || !patient_remarks.equals("") ||  tot_deposit_amt>0)
		{
			ind_bal_available_YN = ""; // To make the individual amount checkbox checked/not

			if(tot_unbilled_amt > 0)
			{
				ind_bal_available_YN = "CHECKED";
			}
			else
			{
				ind_bal_available_YN = "";
			}
%>			<tr>
				<td class='label' width="30%"><fmt:message key="eBL.UNBILLED_AMT.label" bundle="${bl_labels}"/></td>
				<td width="70%" class="fields">
					<input type="checkbox"  name="unbill_cb" id="unbill_cb" value="" <%=ind_bal_available_YN%> onclick ="chkbox(this)">
<%
				if(unbld_disp_yn.equals("Y") && !ind_bal_available_YN.equals(""))
				{
%>
					<input type="text" size='12' name="unbilled_amt" id="unbilled_amt" value="<%=p_unbilled_amt%>" readonly>
				</td>
<%	
				}
				else if(unbld_disp_yn.equals("Y") && ind_bal_available_YN.equals(""))
				{
%>
					<input type="text" size='12'  name="unbilled_amt" id="unbilled_amt" value="" readonly>
				</td>
<%	
				}

			if(tot_outstanding_amt > 0)
			{
				ind_bal_available_YN = "CHECKED";
			}
			else
			{
				ind_bal_available_YN = "";
			}
%>			</tr>
			<tr>
				<td class='label' width="30%"><fmt:message key="Common.outstandingamount.label" bundle="${common_labels}"/></td> 	
				<td width="70%" class="fields" >
					<input type="checkbox" name="tot_outstanding_cb" id="tot_outstanding_cb" value="" <%=ind_bal_available_YN%> onclick ="chkbox(this)">
<%
				
				if(outst_disp_yn.equals("Y") && !ind_bal_available_YN.equals(""))
				{
%>
					<input type="text" size='12'  name="outstanding_amt" id="outstanding_amt" 	value="<%=p_outstdg_amt%>" readonly>
				</td>
<%	
				}
				else if(outst_disp_yn.equals("Y") && ind_bal_available_YN.equals(""))
				{
%>
					<input type="text" size='12'  name="outstanding_amt" id="outstanding_amt" 	value="" readonly>
				</td>
<%	
				} 

			if(tot_written_off_amt > 0)
			{
				ind_bal_available_YN = "CHECKED";
			}
			else
			{
				ind_bal_available_YN = "";
			}
%>			
			</tr>
			<tr>
				<td class='label' width="30%"><fmt:message key="eBL.WRITOFF_AMT.label" bundle="${bl_labels}"/></td> 	
				<td width="70%" class="fields" >
					<input type="checkbox"  name="write_off_cb" id="write_off_cb" value="" <%=ind_bal_available_YN%> onclick ="chkbox(this)">
<%
				if(wo_disp_yn.equals("Y") && !ind_bal_available_YN.equals(""))
				{
%>
					<input type="text" size='12' name="write_off_amt" id="write_off_amt" 	value="<%=p_wo_amt%>" readonly>
				</td>
<%	
				}
				else if(wo_disp_yn.equals("Y")&& ind_bal_available_YN.equals(""))
				{
%>
					<input type="text" size='12' name="write_off_amt" id="write_off_amt" 	value="" readonly>
				</td>
<%	
				}

			if(tot_installment_due > 0)
			{
				ind_bal_available_YN = "CHECKED";
			}
			else
			{
				ind_bal_available_YN = "";
			}
%>			</tr>
			<tr>
				<td class='label' width="30%"><fmt:message key="eBL.INSTLMT_DUE_AMT.label" bundle="${bl_labels}"/></td> 	
				<td width="70%" class="fields" >
					<input type="checkbox"  name="instL_due_cb" id="instL_due_cb" value="" <%=ind_bal_available_YN%> onclick ="chkbox(this)">
<%
				if(instl_disp_yn.equals("Y") && !ind_bal_available_YN.equals(""))
				{
%>
				<input type="text" size='12'  name="instL_due_amt" id="instL_due_amt" 	value="<%=p_instl_due_amt%>" readonly>
				</td>
<%	
				}
				else if(instl_disp_yn.equals("Y") && ind_bal_available_YN.equals(""))
				{
%>
				<input type="text" size='12'  name="instL_due_amt" id="instL_due_amt" 	value="" readonly>
				</td>
<%	
				}
%>		
			</tr>
			<%
			//V231010
			if(depositShowYN.equals("Y")){
				if(tot_deposit_amt > 0)
				{
					ind_bal_available_YN = "CHECKED";
				}
				else
				{
					ind_bal_available_YN = "";
				}
				%>
				<tr>
				<td class='label' width="30%">Deposit Balance Amount</td> 	
				<td width="70%" class="fields" >
					<input type="checkbox"  name="dep_amt_cb" id="dep_amt_cb" value="" <%=ind_bal_available_YN%> onclick ="chkbox(this)">
<%
				if(dep_disp_yn.equals("Y") && !ind_bal_available_YN.equals(""))
				{
%>
				<input type="text" size='12'  name="dep_amount" id="dep_amount" 	value="<%=P_dep_amt%>" readonly>
				</td>
<%	
				}
				else if(dep_disp_yn.equals("Y") && ind_bal_available_YN.equals(""))
				{
%>
				<input type="text" size='12'  name="dep_amount" id="dep_amount" 	value="" readonly>
				</td>
<%	
				}
%>		
			</tr>
			<%} %>
			
	</table>

	<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>	
			<tr>
				<td class='label' width="30%" ><fmt:message key="Common.generalRemarks.label" bundle="${common_labels}"/></td> 
				<td class="fields" width="70%"><textarea name="" rows="2" cols="40" readonly><%=patient_remarks%></textarea></td>	
			</tr>
<!--	<tr>
<!--		<td align='right' class='label'>Outstanding Amount&nbsp;</td> 
			<td class='label' width="50%"><fmt:message key="Common.outstandingamount.label" bundle="${common_labels}"/></td>
			<td class="fields" width="50%"><input type="text" size='12' style='text-align:right' name="outst_amt" id="outst_amt" value="<%=outst_amt%>" readonly></td>
		</tr>-->
<%
			if(!str_module_id.equals("MR")){
			if(p_credit_auth_check_result_yn.equals("Y") && credit_auth_reqd_yn.equals("Y"))
			{
/*			out.println("<tr> " +
			"<td align='right' class='label'>User ID&nbsp;</td> "+
			"<td align='left'><input type='text' size = '20' maxlength = '20' name='user_id' id='user_id' " +
			" onKeyPress='return makeUpperCase()'>&nbsp;" +
			"<img src='../../eCommon/images/mandatory.gif'></td>"+
			"</tr>" +
			"<tr>" +
			"<td align='right' class='label'>Pin No&nbsp;</td>"+
			"<td align='left'><input type='password' size = '20' maxlength = '64' name='passwd' id='passwd'>&nbsp;"+
			"<img src='../../eCommon/images/mandatory.gif'></td>"+
			"</tr>"+
			"<tr>"+
			"<td align='right' class='label'>Remarks&nbsp;</td>"+
			"<td align='left'><input type='text' size = '20' maxlength = '50' name='remarks' id='remarks'> </td>"+
			"</tr> ");	
			*/
			/*
			out.println("<td width='' "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"</td>");
			*/
			
				out.println("<tr> " +
							"<td  class='label' width='30%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.userid.label","common_labels")+"</td> "+
							"<td class='fields' width='70%' ><input type='text' size = '20' maxlength = '20' name='user_id' id='user_id' " +
							" onKeyPress='return makeUpperCase()'>" +
							"<img src='../../eCommon/images/mandatory.gif'></td>"+
							"</tr>" +
							"<tr>" +
							"<td class='label' width='30%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PIN.label","common_labels")+"</td>"+
							"<td class='fields' width='70%'><input type='password' size = '20' maxlength = '64' name='passwd' id='passwd'>"+
							"<img src='../../eCommon/images/mandatory.gif'></td>"+
							"</tr>"+
							"<tr>"+
							"<td class='label' width='30%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+"</td>"+
							"<td class='fields' width='70%'><input type='text' size = '20' maxlength = '50' name='remarks' id='remarks'> </td>"+
							"</tr> ");	
			
			}
			}
		if(!str_module_id.equals("MR")){
			if(p_credit_auth_check_result_yn.equals("Y") && credit_auth_reqd_yn.equals("Y")  )	 
			{
				out.println("<tr><td width='50%'></td><td width='50%'><input type='button' class='button' name='auth_ok' id='auth_ok' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")+"' "+
				"onClick ='return confirmPasswd(this);'>&nbsp;<input type='button'  " +
				"class='button' name='auth_cancel' id='auth_cancel'  value='Cancel' "+
				"onClick='parent.window.close(); return retModal(this);'></td><tr>");
				
			}
			else
			{
				out.println("<tr><td width='50%'></td><td width='50%'><input type='button' class='button' name='auth_ok' id='auth_ok' 	value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")+"' " +
				//"onClick='return retArray(this);'></td><tr>");
				"onClick='return retArray(this);'></td><tr>");
				
			}
		}
		}
		else
		{
%>
			<script>
				var returnArray = new Array ("1");
				//parent.window.returnValue = returnArray;
				//parent.window.close();
				let dialogBody = parent.parent.parent.document.getElementById('dialog-body');
				dialogBody.contentWindow.returnValue = returnArray;
				const dialogTag = parent.parent.parent.document.getElementById('dialog_tag');    
				dialogTag.close();
			</script>
<%
		}
%>
	</table>
	<table>
	<%
if(("MR").equalsIgnoreCase(str_module_id)){
		%><tr><td width="100%"  style='text-align:left'>*Authorisation Required,Outstanding Amount exists</td></tr> 
		</table>
		<table>
		<tr><td>
		<span style='padding-left: 20px;'>
		<input type='button' class='button' value='Cancel' id='close' onClick='parent.window.close()'>
</span>
</td>
</tr><%			
		 }
%>
</table>
</form>
<center>
</body>
</html>

<%	}
	catch(Exception ex)
	{ 
		out.println("ghfghf: "+ex.toString());
	}
	finally 
	{
		ConnectionManager.returnConnection(con, request);
	}
%>

