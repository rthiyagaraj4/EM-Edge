<!DOCTYPE html>
<%@page  import="java.sql.*, java.util.*, java.io.*, webbeans.eCommon.*" contentType="text/html;charset=ISO-8859-1" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");%>

<HTML>

<%
	Connection con=null ;
	//Statement stmt=null;
	//ResultSet rs=null;
	CallableStatement call = null;
	con = ConnectionManager.getConnection(request);
	
	String billslmtamt="",mess_const_for_cc_mc="",cc_trx_approved_YN="N";
	String port_nt_open="N",err_in_port_conn="N";
	String mesg_frm_cc_mc="";
	String caldFormanualcc="",slmt_type_code="",credit_card_num="",sale_draft_reqd_yn="",payer_name_reqd_yn="",payer_ref_reqd_yn="",error_level="",sys_message_id="",error_text="";
//	String locale			= (String)session.getAttribute("LOCALE");


	String batch_no_reqd_yn="",slmt_doc_ref_date_reqd_yn="";

		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	try
	{
		billslmtamt=request.getParameter("billslmtamt");
		if(billslmtamt == null) billslmtamt="";

		mess_const_for_cc_mc=request.getParameter("mess_const_for_cc_mc");
		if(mess_const_for_cc_mc == null) mess_const_for_cc_mc="";
//		System.out.println("mess_const_for_cc_mc:"+mess_const_for_cc_mc);

		caldFormanualcc=request.getParameter("caldFormanualcc");
		if(caldFormanualcc == null) caldFormanualcc="";
		slmt_type_code=request.getParameter("slmt_type_code");
		if(slmt_type_code == null) slmt_type_code="";
		credit_card_num=request.getParameter("credit_card_num");
		if(credit_card_num == null) credit_card_num="";
		
		try{
			String strqry = "{ call BLCORE.VALIDATE_CREDIT_CARD_DTLS(?,?,?,?,?,?,?,?,?,?) }";
//			System.out.println("strqry @@"+strqry);
			  call = con.prepareCall(strqry);
		//	CallableStatement  call = con.prepareCall("{ call BLCORE.VALIDATE_CREDIT_CARD_DTLS(?,?,?,?,?,?,?,?) }");	
			call.setString(1,slmt_type_code);
			call.setString(2,credit_card_num);
			call.registerOutParameter(3,java.sql.Types.VARCHAR);
			call.registerOutParameter(4,java.sql.Types.VARCHAR);
			call.registerOutParameter(5,java.sql.Types.VARCHAR);
			call.registerOutParameter(6,java.sql.Types.VARCHAR);
			call.registerOutParameter(7,java.sql.Types.VARCHAR);
			call.registerOutParameter(8,java.sql.Types.VARCHAR);
			call.registerOutParameter(9,java.sql.Types.VARCHAR);
			call.registerOutParameter(10,java.sql.Types.VARCHAR);

			call.execute();
			sale_draft_reqd_yn=call.getString(3);
			if(sale_draft_reqd_yn == null) sale_draft_reqd_yn="";
			payer_name_reqd_yn=call.getString(4);
			if(payer_name_reqd_yn == null) payer_name_reqd_yn="";
			payer_ref_reqd_yn=call.getString(5);
			if(payer_ref_reqd_yn == null) payer_ref_reqd_yn="";			
/***  Added against CRF  AAKH-CRF-0014   37864				*/
			batch_no_reqd_yn=call.getString(6);	
			if(batch_no_reqd_yn == null) batch_no_reqd_yn="";			
  
			slmt_doc_ref_date_reqd_yn=call.getString(7);
			if(slmt_doc_ref_date_reqd_yn == null) slmt_doc_ref_date_reqd_yn="";			

/***  end  AAKH-CRF-0014   37864				*/
			error_level=call.getString(8);
			if(error_level == null) error_level="";
			sys_message_id=call.getString(9);
			if(sys_message_id == null) sys_message_id="";
			error_text=call.getString(10);
			if(error_text == null) error_text="";		
			 call.close();	
			if ((error_level.equals("10") && (!error_text.equals(""))) ||!sys_message_id.equals(""))
			{
				if (error_level.equals("10") ||(!error_text.equals("")))
				{
//					System.out.println("2 val");				
%>					<script>					
						var v_error = '<%=error_text%>';												
						alert(v_error);				 						
					</script>
<%				}					
				if(!sys_message_id.equals(""))
				{
%>					 <script>
						alert(getMessage('<%=sys_message_id%>','BL'));
					//	alert("Invalid Credit Card Number");						
						parent.frames[1].document.forms[0].instref.select();
					</script>
<%				}
					%><script>
						parent.frames[1].document.forms[0].sale_draft_reqd_yn.value="";
						parent.frames[1].document.forms[0].payer_name_reqd_yn.value="";
						parent.frames[1].document.forms[0].payer_ref_reqd_yn.value="";
						parent.frames[1].document.forms[0].batch_no_reqd_yn.value="";
						parent.frames[1].document.forms[0].slmt_doc_ref_date_reqd_yn.value="";
					</script>
						<%
			}else{
%>					<script>
						parent.frames[1].document.forms[0].sale_draft_reqd_yn.value="<%=sale_draft_reqd_yn%>";
						parent.frames[1].document.forms[0].payer_name_reqd_yn.value="<%=payer_name_reqd_yn%>";
						parent.frames[1].document.forms[0].payer_ref_reqd_yn.value="<%=payer_ref_reqd_yn%>";
						parent.frames[1].document.forms[0].batch_no_reqd_yn.value="<%=batch_no_reqd_yn%>";
						parent.frames[1].document.forms[0].slmt_doc_ref_date_reqd_yn.value="<%=slmt_doc_ref_date_reqd_yn%>";

					</script>
<%			}


		}catch(Exception e)
		{
			System.out.println("Proc Exception:"+e);
		}
%>

<script>
	function validate()
	{
	parent.frames[5].location.href='../../eCommon/jsp/error.jsp';
		var mess_const_for_cc_mc=document.forms[0].mess_const_for_cc_mc.value;
		//alert("Message Constructed for CC Machine:"+mess_const_for_cc_mc);
		var v_cc_trx_approved_YN=CreditCardInterface.writeData(mess_const_for_cc_mc,'Y');		
		alert(getMessage("BL1008","BL"));

		if(v_cc_trx_approved_YN == 0 || v_cc_trx_approved_YN == 2)
		{
			document.forms[0].cc_trx_approved_YN.value="Y";
		}
		else if(v_cc_trx_approved_YN == 1)
		{
			document.forms[0].port_nt_open.value="Y";
		}
		/*else if(v_cc_trx_approved_YN == 2)
		{
			document.forms[0].err_in_port_conn.value="Y";
		}*/
		
		if(document.forms[0].port_nt_open.value == "Y")
		{
			//alert("Port Not Opened");
			alert(getMessage("BL9872","BL"));
			return false;
		}

		if(document.forms[0].err_in_port_conn.value == "Y")
		{
			//alert("Error in Port Connection");
			alert(getMessage("BL9873","BL"));
			return false;
		}

		if(document.forms[0].port_nt_open.value == "N" && document.forms[0].err_in_port_conn.value == "N" && document.forms[0].cc_trx_approved_YN.value == "Y")
		{
			var mesg_frm_cc_mc=CreditCardInterface.readData();
			//var mesg_frm_cc_mc="APPROVAL|00|12345|GET WELL|TIN001|MC001|VISA|1234567821345768|15/07|BT001|20070725|011000|RR001|VISA|ALLEN";
			//alert("Message from CC Machine"+mesg_frm_cc_mc);
			if(mesg_frm_cc_mc == null) mesg_frm_cc_mc="";
			if(mesg_frm_cc_mc=="")				
			{
				//alert("No Data from CC Machine");
				alert(getMessage("NO_RECORD_FOUND","common"));
				return false;
			}

			document.forms[0].mesg_frm_cc_mc.value=mesg_frm_cc_mc;
			parent.frames[0].document.forms[0].cc_trx_approved_YN.value=document.forms[0].cc_trx_approved_YN.value;
			parent.frames[0].document.forms[0].mesg_frm_cc_mc.value=mesg_frm_cc_mc;
			parent.frames[0].document.forms[0].submit();


		}
	}
</script>
<%
	if(caldFormanualcc.equals("MANUALCC"))
	{
%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	}else
		{
%>
	<OBJECT classid = "clsid:A453F6AF-CCF8-490A-905E-A5963B743D2C" name="CreditCardInterface"></OBJECT>
	<BODY onLoad='validate()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%		}
%>
<form>
	<input type='hidden' name='billslmtamt' id='billslmtamt' value='<%=billslmtamt%>'>
	<input type='hidden' name='mess_const_for_cc_mc' id='mess_const_for_cc_mc' value='<%=mess_const_for_cc_mc%>'>
	<input type='hidden' name='cc_trx_approved_YN' id='cc_trx_approved_YN' value='<%=cc_trx_approved_YN%>'>
	<input type='hidden' name='port_nt_open' id='port_nt_open' value='<%=port_nt_open%>'>
	<input type='hidden' name='err_in_port_conn' id='err_in_port_conn' value='<%=err_in_port_conn%>'>
	<input type='hidden' name='mesg_frm_cc_mc' id='mesg_frm_cc_mc' value='<%=mesg_frm_cc_mc%>'>	
</form>
</BODY>

<%
	}
	catch(Exception e)
	{
		System.out.println("Main Exception in CC Interface Test Page:"+e);
	}
	finally{					
					if(con!=null) {
					ConnectionManager.returnConnection(con, request);
								  }
			}
%>
</HTML>

