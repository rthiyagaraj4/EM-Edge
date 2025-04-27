<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


 <%
 	request.setCharacterEncoding("UTF-8");
	Connection con = null;	
	//String locale	= (String)session.getAttribute("LOCALE");
	//HttpSession httpSession = request.getSession(false);
//	Properties p = (Properties)httpSession.getValue("jdbc");			
//	String strclientip ="";

	try{
		
		con	=	ConnectionManager.getConnection(request);

		String str_facility_id	=  (String) session.getValue("facility_id");

		String patient_id = request.getParameter("patient_id");	
		if(patient_id==null) patient_id="";	

		
		String episode_type = request.getParameter("episode_type");	
		if(episode_type==null) episode_type="";	
	
		String episode_id = request.getParameter("episode_id");	
		if(episode_id==null) episode_id="";	

		String visit_id = request.getParameter("visit_id");	
		if(visit_id==null) visit_id="";	
//		System.out.println("visit_id 1 "+visit_id); 
	
		String encounter_id = request.getParameter("encounter_id");	
		if(encounter_id==null) encounter_id="";	

		String currdate="",str_slmt_mode_wise_rcpt_yn="",hand_without_counter_chk_out="";
	/************ADDED FOR PACKAGE BILLING **********************/
		String function_id = request.getParameter("function_id");	
		if(function_id==null) function_id="";	
		String packseqno = request.getParameter("packseqno");	
		if(packseqno==null) packseqno="";	
	/******************ends package billing*********************/
	String ignoreMandValidation = "N";
	//Added for MMS-DM-SCF-0013
	double totMinDeposit = 0.0;
	 try{
		
		String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from dual";
		PreparedStatement pst2=con.prepareStatement(query_date);
		ResultSet rst2 = pst2.executeQuery();
		if (rst2!=null)
		{
		   if (rst2.next())
		   {
				 currdate = rst2.getString(1);
		   }
		}

		if (rst2 != null)   rst2.close();
		if (pst2 != null)   pst2.close();
	

	}catch(Exception e)
	{
		System.out.println("error in date"+e);
		e.printStackTrace();
	}
//	System.out.println("currdate :" +currdate); 
 try{
//fetchiing HAND_WITHOUT_COUNTER_CHK_OUT for CRF-13
		String sqlst2="select SLMT_MODE_WISE_RCPT_YN,HAND_WITHOUT_COUNTER_CHK_OUT from BL_PARAMETERS where OPERATING_FACILITY_ID = '"+str_facility_id+"'";
		PreparedStatement pst=con.prepareStatement(sqlst2);
		ResultSet rst3 = pst.executeQuery();
		if (rst3!=null)
		{
		   if (rst3.next())
		   {
				 str_slmt_mode_wise_rcpt_yn = rst3.getString(1);
				 hand_without_counter_chk_out = rst3.getString(2);
		   }
		}

		if (rst3 != null)   rst3.close();
		if (pst != null)   pst.close();

//	System.out.println("str_slmt_mode_wise_rcpt_yn dep :"+str_slmt_mode_wise_rcpt_yn);



	}catch(Exception e)
	{
		System.out.println("error in date");
		e.printStackTrace();
	}


 %>
 <script>

function trimString(sInString)
{
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}

function cancel()
	{		
		var function_id=parent.frames[1].document.forms[0].function_id.value;
		var deposit_man_yn=parent.frames[1].document.forms[0].deposit_man_yn.value;
		var packseqno=parent.frames[1].document.forms[0].packseqno.value;		
		var pkgCode=parent.frames[1].document.forms[0].pkgCode.value;			
		var min_dep_amt_man   = parent.frames[1].document.forms[0].min_dep_amt_man.value;	
		 var stlmt_amount   = parent.frames[1].document.forms[0].stlmt_amount.value;		 
		 var tot_package_amt   = parent.frames[1].document.forms[0].d_tot_package_amt.value;	
		 var called_from_mode    = parent.frames[1].document.forms[0].funct_mode.value;
		 var total_settled_amt    = parent.frames[3].document.forms[0].total_settled_amt.value;		 	
		 var total_records    = parent.frames[2].document.forms[0].total_records.value;				
		var confirm_check = false;				
		if(function_id=="PKG_BILLING" )//&& deposit_man_yn=="Y")
		{	

			//confirm_check = confirm("Deposit is mandatory, Do you want to Cancel the Subscription");
			//Added Logic for MMS-DM-SCF-0013

			var ignoreMandValidationDtl = parent.frames[1].document.forms[0].ignoreMandValidationDtl.value;
			//This variable is from this page
			var ignoreMandValidation = document.forms[0].ignoreMandValidation.value;
			var minMandAmtFinal = document.forms[0].totMinDeposit.value;
			var minMandAmtDtl = parent.frames[1].document.forms[0].totMinDepositDtl.value;
			var derivedFromDtl = parent.frames[1].document.forms[0].derivedFromDtl.value;
			//In Details page if value is Y then override this page value
			if(derivedFromDtl == 'Y'){
				minMandAmtFinal = minMandAmtDtl;
			}
			
			min_dep_amt_man = parseFloat(min_dep_amt_man) - parseFloat(minMandAmtFinal);
			//Added Logic for MMS-DM-SCF-0013

		if(parseFloat(total_settled_amt)  < parseFloat(min_dep_amt_man)){						
			confirm_check = confirm(getMessage("BL8659","BL"));
			//confirm_check = confirm("Minimum Deposit Collection is mandatory, Do you want to Cancel the Subscription");
			if(confirm_check){				
					var xmlStr ="<root><SEARCH ";
					xmlStr+= "packseqno=\"" + packseqno + "\" " ;					
					xmlStr+= "pkgCode=\"" + pkgCode + "\" " ;					
					xmlStr+= "called_from_mode=\"" + called_from_mode + "\" " ;					
					xmlStr +=" /></root>";
					var temp_jsp="PkgSubscriptionValidation.jsp?func_mode=REM_PKG_SUBS&function_id="+function_id;					
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST",temp_jsp,false);
					xmlHttp.send(xmlDoc);
					var responseText=trimString(xmlHttp.responseText) ;
					//eval(responseText);
					//Added Logic for MMS-DM-SCF-0013
					if(responseText == ""){
						//window.parent.returnValue="C";
						//parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = "C"; 
						//parent.parent.document.getElementById('dialog_tag').close();
						toCloseTopShowModal("C");
					}
					else{
						//window.parent.returnValue="N";
						//parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = 'N'; 
						//parent.parent.document.getElementById('dialog_tag').close();
						toCloseTopShowModal("N");
						
					}
					//Added Logic for MMS-DM-SCF-0013
					
					/* parent.window.close();	
					parent.document.getElementById('dialog-body').contentWindow.returnValue = 'CANCEL';  */
					//parent.parent.document.getElementById('dialog_tag').close();
					toCloseTopShowModal("CANCEL");
					
			}else{		
				return false;
			}
		}else{				
			/* window.parent.returnValue="Y";
			parent.window.close();	 */
			//parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = 'Y'; 
			//parent.parent.document.getElementById('dialog_tag').close();
			toCloseTopShowModal("Y");
		}
		}else{	
			if(function_id=="PKG_BILLING" )//&& deposit_man_yn=="N")
			{					
				/* window.parent.returnValue="Y"; */
				//parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = 'Y'; 
				//parent.parent.document.getElementById('dialog_tag').close();
				toCloseTopShowModal("Y");
			}
			//parent.window.close();
			//parent.parent.document.getElementById('dialog_tag').close();
			toCloseTopShowModal();
		}
		
	}
	function funSubmit()
	{
		//alert("3");
		var v_ext_acc_interface_yn=parent.frames[1].document.forms[0].ext_acc_int_YN.value;

		if(parent.frames[1].document.forms[0].receipt_type.value=="") 
		{
			alert(getMessage("BL9524","BL"));
			return;
		}

		if(parent.frames[1].document.forms[0].dep_type.value=="")
		{
			alert(getMessage("BL7290","BL"));
			return;
		}

		if(v_ext_acc_interface_yn == "Y")
		{
			v_external_acc=parent.frames[1].document.forms[0].ext_acc_code.value;
			v_dept_code=parent.frames[1].document.forms[0].ext_acc_dept_code.value;	
			if ( v_external_acc == "")
			{
				alert(getMessage("BL9525","BL"));
				return false;
			}

			if ( v_dept_code == "")
			{
				alert(getMessage("BL9526","BL"));
				return false;
			}
		}

		if(parent.frames[1].document.forms[0].stlmt_amount.value=="")
		{
			alert(getMessage("BL9523","BL"));
			return;
		}
		if(parent.frames[2].document.forms[0].total_records.value==0)
		{
			alert(getMessage("BL6288","BL"));
			return;
		}
		var stlmt_amount = parent.frames[1].document.forms[0].stlmt_amount.value;
		var total_settled_amt = parent.frames[3].document.forms[0].total_settled_amt.value;

		if(parseFloat(stlmt_amount)!= parseFloat(total_settled_amt))
		{
			alert(getMessage("BL9782","BL"));
			return;
		}
		/***** added for package billing******/
		var function_id    = parent.frames[1].document.forms[0].function_id.value;
		var funct_mode    = parent.frames[1].document.forms[0].funct_mode.value;
		var deposit_man_yn = parent.frames[1].document.forms[0].deposit_man_yn.value;
        var stlmt_amount   = parent.frames[1].document.forms[0].stlmt_amount.value;
        var min_dep_amt   = parent.frames[1].document.forms[0].min_dep_amt.value;			
        var min_dep_amt_man   = parent.frames[1].document.forms[0].min_dep_amt_man.value;
		if(function_id=="PKG_BILLING" )// && deposit_man_yn=="Y")
		{
			//Added Logic for MMS-DM-SCF-0013
			var minMandAmtFinal = document.forms[0].totMinDeposit.value;
			var minMandAmtDtl = parent.frames[1].document.forms[0].totMinDepositDtl.value;
			var derivedFromDtl = parent.frames[1].document.forms[0].derivedFromDtl.value;
			//In Details page if value is Y then override this page value
			if(derivedFromDtl == 'Y'){
				minMandAmtFinal = minMandAmtDtl;
			}
			min_dep_amt_man = parseFloat(min_dep_amt_man) - parseFloat(minMandAmtFinal);
			//Added Logic for MMS-DM-SCF-0013
			//if(parseInt(stlmt_amount)  < parseInt(min_dep_amt)){
			if(parseFloat(stlmt_amount)  < parseFloat(min_dep_amt_man)){
			//alert("Package Deposit Must be equal to Minimum Deposit Amount"+":"+min_dep_amt);
			alert(getMessage("BL8658","BL")+':'+min_dep_amt_man);
			return false;
		}
		}
/*********************END********************************/
		parent.frames[2].document.forms[0].rcpt_rfnd_ind.value=parent.frames[1].document.forms[0].recpt_refund_ind.value;
		parent.frames[2].document.forms[0].rcpt_nature_code.value=parent.frames[1].document.forms[0].receipt_nature_code.value;
	//	alert(parent.frames[1].document.forms[0].receipt_code.value);	
		parent.frames[2].document.forms[0].rcpt_type_code.value=parent.frames[1].document.forms[0].receipt_code.value;	
		parent.frames[2].document.forms[0].shift_id.value=parent.frames[1].document.forms[0].shift_id.value;		
		parent.frames[2].document.forms[0].cash_counter_code.value=parent.frames[1].document.forms[0].cash_counter_code.value;
		parent.frames[2].document.forms[0].doc_amt.value =parent.frames[1].document.forms[0].stlmt_amount.value;	
		parent.frames[2].document.forms[0].narration.value =parent.frames[1].document.forms[0].remarks.value;	//BL-35237 changed by karthik 
		parent.frames[2].document.forms[0].ip_adm_trf_dep_ind.value=parent.frames[1].document.forms[0].dep_type.value;	
		parent.frames[2].document.forms[0].rec_ref_format_ind.value ="";	
		parent.frames[2].document.forms[0].rfnd_dep_in_use_yn.value	="";
		var t_mail=eval("parent.frames[1].document.forms[0].thru_mail");
		if(t_mail.checked)
		{
			parent.frames[2].document.forms[0].pmnt_thru_mail.value	="Y";
		}
		else{
			parent.frames[2].document.forms[0].pmnt_thru_mail.value	="N";					
		}
		
		if(v_ext_acc_interface_yn == 'Y')
		{
			parent.frames[2].document.forms[0].ext_acc_facility_id.value =parent.frames[1].document.forms[0].ext_acc_facility_id.value;	
	//		parent.frames[2].document.forms[0].ext_acc_code.value =parent.frames[1].document.forms[0].ext_acc_code.value;	
	//		parent.frames[2].document.forms[0].ext_acc_dept_code.value=parent.frames[1].document.forms[0].ext_acc_dept_code.value;	
			parent.frames[2].document.forms[0].ext_acc_code.value =parent.frames[1].document.forms[0].ext_acc_code.value;	
			parent.frames[2].document.forms[0].ext_acc_dept_code.value=parent.frames[1].document.forms[0].ext_acc_dept_code.value;	
		}
		else
		{
			parent.frames[2].document.forms[0].ext_acc_facility_id.value = "";	
			parent.frames[2].document.forms[0].ext_acc_code.value = "";	
			parent.frames[2].document.forms[0].ext_acc_dept_code.value = "";	
		}
		parent.frames[2].document.forms[0].mult_slmt_yn.value="" ;
		parent.frames[2].document.forms[0].downtime_entry_yn.value="";
		parent.frames[2].document.forms[0].downtime_doc_type_code.value="";
		parent.frames[2].document.forms[0].downtime_doc_num.value="";
		parent.frames[2].document.forms[0].downtime_doc_date.value="";
		parent.frames[2].document.forms[0].cc_machine_id.value="";
		parent.frames[2].document.forms[0].payers_add1.value="";
		parent.frames[2].document.forms[0].payers_add2.value=""	;
		parent.frames[2].document.forms[0].payers_add3.value="";
		parent.frames[2].document.forms[0].currdate.value="<%=currdate%>";
		parent.frames[2].document.forms[0].str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd.value="<%=str_slmt_mode_wise_rcpt_yn%>";
		parent.frames[2].document.forms[0].hand_without_counter_chk_out.value="<%=hand_without_counter_chk_out%>";
	/*************ADDED FOR PAKAGE BILLING**************************/
		/*if(function_id=="PKG_BILLING"){
		var pkgSeqNo=parent.frames[1].document.forms[0].pkgSeqNo.value			
		parent.frames[2].document.forms[0].pkgSeqNo.value=parent.frames[1].document.forms[0].pkgSeqNo.value;
	}*/
	/*************ENDS**************************/

		parent.frames[2].document.forms[0].payers_tel_num.value	="";
		parent.frames[2].document.forms[0].consolidated_receipt_yn.value="";

		parent.frames[2].document.forms[0].patient_id.value='<%=patient_id%>';
/*************ADDED FOR PAKAGE BILLING**************************/
	if(function_id=="PKG_BILLING"){
		parent.frames[2].document.forms[0].episode_type.value='R';
		parent.frames[2].document.forms[0].episode_id.value='';
		parent.frames[2].document.forms[0].visit_id.value='';
		parent.frames[2].document.forms[0].encounter_id.value='';
	}else{
		parent.frames[2].document.forms[0].episode_type.value='<%=episode_type%>';
		parent.frames[2].document.forms[0].episode_id.value='<%=episode_id%>';
		parent.frames[2].document.forms[0].visit_id.value='<%=visit_id%>';
		parent.frames[2].document.forms[0].encounter_id.value='<%=encounter_id%>';
	}	
	if(funct_mode!="" && funct_mode=="VISIT_REGISTRATION"){	
		/* Modified by Karthik on 19/04/2013, to disable button to avoid double submission */
		document.forms[0].record_button.disabled = true;
		parent.frames[2].document.forms[0].target='submit_frame';
		parent.frames[2].document.forms[0].action="../../eBL/jsp/PkgEnterReceiptRefundSubmit.jsp";
		parent.frames[2].document.forms[0].submit();
	}else{
		/* Modified by Karthik on 19/04/2013, to disable button to avoid double submission */
		//Added for MMS SCF 501.1
		parent.frames[2].document.forms[0].pkgSequenceNumber.value=parent.frames[1].document.forms[0].packseqno.value;
		/*var packagenumber=parent.frames[2].document.forms[0].pkgSequenceNumber.value
		 packagenumber=packagenumber.slice(0,4);
		parent.frames[2].document.forms[0].pkgSequenceNumber.value=packagenumber;*/
		if(parent.frames[1].document.forms[0].pkgSeqAmtForSub.value != ''){
			parent.frames[2].document.forms[0].pkgSequenceAmount.value=parent.frames[1].document.forms[0].pkgSeqAmtForSub.value;
		}
		else{
			parent.frames[2].document.forms[0].pkgSequenceAmount.value=parent.frames[1].document.forms[0].pkgAmount.value;
		}
		//Added for MMS SCF 501.1
		document.forms[0].record_button.disabled = true;
		parent.frames[2].document.forms[0].target='submit_frame';
		parent.frames[2].document.forms[0].action="../../servlet/eBL.BLEnterRecRefundServlet";
		parent.frames[2].document.forms[0].submit();
	}
	
/*		parent.frames[2].document.forms[0].target='submit_frame';
		parent.frames[2].document.forms[0].action="../../eBL/jsp/BLEnterReceiptrefundSubmit_temp.jsp";
		parent.frames[2].document.forms[0].submit();*/

	}

 </script>

<HTML>
<HEAD>

		<TITLE> <fmt:message key="eBL.BILL_SLMT_DTL.label" bundle="${bl_labels}"/> </TITLE>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		//Added Logic for MMS-DM-SCF-0013
		try{
			PreparedStatement pstmt = null;
			ResultSet rst = null;
			String packageCode = request.getParameter("pkgCode");
			if(packageCode == null){
				packageCode = "";
			}
			
			if(!"".equals(packseqno)){
				StringTokenizer stPackSeqNo = new StringTokenizer(packseqno,"^");
				
				String stPkg = "";
				String stSeq = "";
				String rsCustGroup = "";
				String rsCustCode = "";
				String rsBlngClass = "";
				String depositReqYn = "";
				String custSpecificYn = "";

				
				StringTokenizer stPackCode = new StringTokenizer(packageCode,"^");
				while(stPackSeqNo.hasMoreTokens()){					
					pstmt = null;
					rst = null;
					stSeq = stPackSeqNo.nextToken();
					stPkg = stPackCode.nextToken();
					pstmt = con.prepareStatement("Select nvl(cust_group_code,'N') cust_group_code, nvl(cust_code,'N') cust_code, blng_class_code,nvl(cust_specific_yn,'N')  cust_specific_yn, nvl(deposit_req_yn,'N') deposit_req_yn from bl_package_sub_hdr where operating_facility_id = ? and patient_id = ? and package_code = ? and package_seq_no = ?");
					pstmt.setString(1, str_facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,stPkg);
					pstmt.setString(4,stSeq);
					rst = pstmt.executeQuery();
					if(rst != null && rst.next()){
						rsCustGroup = rst.getString("cust_group_code");
						rsCustCode = rst.getString("cust_code");
						rsBlngClass = rst.getString("blng_class_code");
						custSpecificYn = rst.getString("cust_specific_yn"); 
						depositReqYn = rst.getString("deposit_req_yn"); 
						if(!"N".equals(rsCustGroup) && !"N".equals(rsCustCode)){
							
							
							if("Y".equals(custSpecificYn)){
								/*
								Code Flow comes here when the given customer definition is
								available in the Package
								*/
								if(!"Y".equals(depositReqYn)){
									ignoreMandValidation = "Y";
								}
							}
							else{
								/*
								Code Flow comes here when the given customer definition is
								unavailable and derived from cash
								*/
								CallableStatement call12 = con.prepareCall("{ call  blpackage.getpackageMinDeposit(?,?,?,?,?,sysdate,?,?,?,?,?)}");		
								call12.setString(1,str_facility_id);				
								call12.setString(2,stPkg);				
								call12.setString(3,rsBlngClass);				
								call12.setString(4,rsCustGroup);	
								call12.setString(5,rsCustCode);	
								call12.registerOutParameter(6,java.sql.Types.VARCHAR);      		
								call12.registerOutParameter(7,java.sql.Types.VARCHAR); 		
								call12.registerOutParameter(8,java.sql.Types.VARCHAR); 		
								call12.registerOutParameter(9,java.sql.Types.VARCHAR); 		
								call12.registerOutParameter(10,java.sql.Types.VARCHAR); 
							
								call12.execute();				

								String str_min_dep_amt	 = call12.getString(7);	
								
								if ( str_min_dep_amt == null ){
									str_min_dep_amt = "";
								}
								
								if("".equals(str_min_dep_amt)){
									str_min_dep_amt = "0.0";
								}
								
								
								totMinDeposit = totMinDeposit + Double.parseDouble(str_min_dep_amt);
			
								call12.close();	
								ignoreMandValidation = "Y";
							}
						}
					}
				}
			}

			
			if(pstmt != null){
				pstmt.close();
			}
			if(rst != null){
				rst.close();
			}
		}
		catch(Exception e){
			System.err.println("Exception in getting ignoreMandValidation ->"+e);
			ignoreMandValidation = "N";
		}
		//Added Logic for MMS-DM-SCF-0013
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>

		<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



		<BODY onLoad="" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 					      					  	onSelect="codeArrestThruSelect();">
		<FORM name='' id='' action="" method=''>	

		
		<table border='0' cellpadding='0' cellspacing='0'  id='tbl' width='100%'>	
	 <tr>
	  <td class="label" width="25%"><b><fmt:message key="eBL.CASH_COUNTER.label" bundle="${bl_labels}"/>/<fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/></b>
	  <td width='25%' class="fields"><input type='text' name='cash_ctr' id='cash_ctr' size='10' maxlength='30	'  value=''  onBlur=""><input type='text' name='shift' id='shift' size='10' maxlength='30	'  value=''  onBlur=""></td>

		 <td class="label" width="25%"><b><fmt:message key="Common.documentno.label" bundle="${common_labels}"/></b><td width='25%' class="fields">&nbsp;<input type='text' name='doc_type_code' id='doc_type_code' size='10' maxlength='30	'  value=''  onBlur=""><input type='text' name='doc_type_no' id='doc_type_no' size='10' maxlength='30'  value=''  onBlur=""></td>
		  </tr>
		  <br>
		  <br>
		<tr>		  	
		  <td class="label" width="25%"><b><fmt:message key="Common.date.label" bundle="${common_labels}"/></b>
			<td width='25%' class="fields"><input type='text' name='doc_date' id='doc_date' size='10' maxlength='30	'  value=''  onBlur="" style="margin-top:4px"></td>
			<td width="25%"  class='labels'>

			<td width="25%"  class='labels'><INPUT TYPE="button" name='record_button' id='record_button'  class="BUTTON" VALUE="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>" onClick='funSubmit()' ><input type='button'  name="cancel_button" id="cancel_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" class='button' onClick='cancel()'></td>
		  	
	  </tr>
	</table>	
	<input type="hidden" name='ignoreMandValidation' id='ignoreMandValidation' id='ignoreMandValidation' value="<%=ignoreMandValidation%>" >
	<input type='hidden' name='totMinDeposit' id='totMinDeposit' id='totMinDeposit' value="<%=totMinDeposit%>" >
</FORM>	

</BODY>
</HTML>
<%
		}
	catch(Exception e )
	{ 
		System.out.println("BLEnterServiceSerachResult:"+e);
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) {
					ConnectionManager.returnConnection(con, request);
								  }
	}
%>

