<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%
	request.setCharacterEncoding("UTF-8");	
	Connection con				= null;
	PreparedStatement pstmt		= null;
	//Statement stmt				= null;
	ResultSet rs				= null;	
	String classval="";
	try
	{
		con	=	ConnectionManager.getConnection(request);

		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");

		int i=0,noofdecimal=2;

		String str_blng_grp_id="",doc_type_code="",doc_num="";

		String locale="", str_facility_id="", strloggeduser="", strclientip="", str_patient_id="", str_episode_type="", str_episode_id="", str_visit_id="", str_encounter_id="", str_module_id="", called_frm="", alw_co_wit_bl_slmt_yn="";

		String tot_bill_amt="",tot_bill_settld_amt ="",str_bill_tot_outst_amt="";

		double v_tot_bill_amt=0, v_tot_bill_settld_amt=0, v_tot_pending_bill_slmt_amt=0,v_bill_tot_outst_amt=0;
		
		CurrencyFormat cf1 = new CurrencyFormat();

		String query_string=request.getQueryString();
//		System.err.println("query_string in BillListDtls.jsp:"+query_string);
		try
		{
			locale	= (String)session.getAttribute("LOCALE");	
			if(locale==null || locale.equals("")) locale="en";	

			str_facility_id = (String) session.getValue("facility_id");
			if (str_facility_id==null) str_facility_id = "";

			strloggeduser	=  (String) session.getValue("login_user");	
			if (strloggeduser==null) strloggeduser = "";
//			System.err.println("strloggeduser" +strloggeduser);

			strclientip = p.getProperty("client_ip_address");
			if (strclientip==null) strclientip = "";
//			System.err.println("strclientip "+strclientip);

			str_patient_id = request.getParameter("patient_id");	
			if(str_patient_id==null) str_patient_id="";	
			
			str_episode_type = request.getParameter("episode_type");	
			if(str_episode_type==null) str_episode_type="";	
		
			str_episode_id = request.getParameter("episode_id");	
			if(str_episode_id==null) str_episode_id="";	

			str_visit_id = request.getParameter("visit_id");	
			if(str_visit_id==null) str_visit_id="";	
		
			str_encounter_id = request.getParameter("encounter_id");	
			if(str_encounter_id==null) str_encounter_id="";	

			str_module_id     =  request.getParameter("module_id");	
			if(str_module_id == null) str_module_id="";

			called_frm     =  request.getParameter("function_id");
			if(called_frm == null) called_frm="";

			alw_co_wit_bl_slmt_yn = request.getParameter("alw_co_wit_bl_slmt_yn");
			if(alw_co_wit_bl_slmt_yn == null) alw_co_wit_bl_slmt_yn="N";
		}
		catch(Exception e)
		{
			System.err.println("Error in BLBillListDtls.jsp - fetching values:"+e);
		}
%>
	<html>
	<head>
<%	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<STYLE TYPE="text/CSS">

/* This style is used for locking the table's heading  */

div#tbl-container {
width: 1020px;
height: 245px;
overflow: auto;
}

thead td, thead td.locked	{
position:relative;
}

thead td {
top: expression(document.getElementById("tbl-container").scrollTop-3); 
z-index: 20;
}

</STYLE>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>	
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>		
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>	
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<script>
	function check_load_slmt()
	{
		var tot_rec = document.forms[0].total_records.value;
		var rec_to_load;

		for(var i=0;i<tot_rec;i++)
		{
			var outst_amt = eval(document.getElementById('outst_amt_'+i));
			outst_amt = outst_amt.innerText

			if(eval(outst_amt) > 0)
			{
				rec_to_load=i;
				break;
			}
		}
		if(rec_to_load != undefined && rec_to_load !="undefined")
		{
			load_slmt_page(rec_to_load);
		}
	}

	function load_slmt_page(sel_rec)
	{
		var called_frm =document.forms[0].called_frm.value;

		var episode_type = document.forms[0].episode_type.value;
		var alw_co_wit_bl_slmt_yn = document.forms[0].alw_co_wit_bl_slmt_yn.value;

		var blng_grp_id = eval("document.forms[0].blng_grp_id_"+sel_rec);
		blng_grp_id = blng_grp_id.value;

		var doc_type_code = eval("document.forms[0].doc_type_code_"+sel_rec);
		doc_type_code = doc_type_code.value;

		var doc_num = eval("document.forms[0].doc_num_"+sel_rec);
		doc_num = doc_num.value;

		parent.frames[1].location.href = "../../eBL/jsp/BLBillSlmtMain.jsp?billdoctypecode="+doc_type_code+"&billdocnum="+doc_num+"&blnggrp="+blng_grp_id+"&function_id="+called_frm+"&episode_type="+episode_type+"&alw_co_wit_bl_slmt_yn="+alw_co_wit_bl_slmt_yn+"&cal_frm_multi_bil_slmt=Y";
	}
</script>

<BODY onLoad="check_load_slmt();" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 					      					  onSelect="codeArrestThruSelect();">
<FORM name='AdhocDicountsbyServiceForm' id='AdhocDicountsbyServiceForm' onLoad="" action="" method=''>	
<div>
	<table border='1' cellpadding='3' cellspacing='0' width='100%'>	
	<tr><td class='COLUMNHEADER' colspan='9' align='left'><fmt:message key="eBL.OUTST_PAT_BILLS.label" bundle="${bl_labels}"/></td></tr>
	</table>
</div>
	<div id="tbl-container" STYLE="overflow: auto; width: 100%; height: 90px;   padding:3px; margin: 0px">
	<table border='1' cellpadding='3' cellspacing='0' width='50%' align='center'>	
	<thead>
			<tr><td></td></tr>
		<tr>			
			<td class='COLUMNHEADER' width='50%'><fmt:message key="eBL.BILL_NO.label" bundle="${bl_labels}"/></td>
			<td class='COLUMNHEADER' width='50%'><fmt:message key="eBL.OUTSTANDING_BILLED_AMT.label" bundle="${bl_labels}"/></td>
		</tr>
	</thead>
	<tbody>
<%
		try
		{
			try
			{		
				pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
				ResultSet rscurr = pstmt.executeQuery();	
				while(rscurr.next())
				{
					noofdecimal  =  rscurr.getInt(1);		
				}		
				rscurr.close();
				pstmt.close();
			}
			catch(Exception e)
			{
				System.err.println("3="+e.toString());
			}

			String strsql="Select DOC_TYPE_CODE,DOC_NUM,BILL_AMT, BILL_PAID_AMT,BLNG_GRP_ID,nvl(bill_tot_outst_amt,0) From BL_BILL_HDR" 
			+" where operating_facility_id = ? " 
			+" and patient_id = ? "
			+" and episode_type = ? "
			+" and episode_id = ? "
			+" and visit_id   = ? "
			+" and BILL_TOT_OUTST_AMT > 0"
			+" and BILL_STATUS is NULL"
			+" and BILL_NATURE_CODE='C' ORDER BY DOC_TYPE_CODE,DOC_NUM";

			pstmt = con.prepareStatement(strsql);
			
			pstmt.setString(1,str_facility_id);
			pstmt.setString(2,str_patient_id);
			pstmt.setString(3,str_episode_type);
			pstmt.setString(4,str_episode_id);
			pstmt.setString(5,str_visit_id);
			rs = pstmt.executeQuery();
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					doc_type_code = rs.getString(1);
					if(doc_type_code == null) doc_type_code="";

					doc_num = rs.getString(2);
					if(doc_num == null) doc_num="";

					tot_bill_amt = rs.getString(3);
					if(tot_bill_amt == null) tot_bill_amt="0";
					tot_bill_amt = cf1.formatCurrency(tot_bill_amt, noofdecimal);
					v_tot_bill_amt = Double.parseDouble(tot_bill_amt);

					tot_bill_settld_amt = rs.getString(4);
					if(tot_bill_settld_amt == null) tot_bill_settld_amt="0";
					tot_bill_settld_amt = cf1.formatCurrency(tot_bill_settld_amt, noofdecimal);
					v_tot_bill_settld_amt = Double.parseDouble(tot_bill_settld_amt);

					v_tot_pending_bill_slmt_amt = v_tot_bill_amt - v_tot_bill_settld_amt;

					str_blng_grp_id=rs.getString(5);
					if(str_blng_grp_id == null) str_blng_grp_id="";

					str_bill_tot_outst_amt =rs.getString(6);
					if(str_bill_tot_outst_amt == null) str_bill_tot_outst_amt="0";
					str_bill_tot_outst_amt = cf1.formatCurrency(str_bill_tot_outst_amt, noofdecimal);
					v_bill_tot_outst_amt = Double.parseDouble(str_bill_tot_outst_amt);

//					System.err.println("doc_type_code @@" +doc_type_code);
//					System.err.println("doc_num @@" +doc_num);
//					System.err.println("v_tot_bill_amt @@" +v_tot_bill_amt);

//					System.err.println("v_tot_bill_settld_amt @@" +v_tot_bill_settld_amt);
//					System.err.println("v_tot_pending_bill_slmt_amt @@" +v_tot_pending_bill_slmt_amt);

//					System.err.println("str_blng_grp_id @@" +str_blng_grp_id);
//					System.err.println("v_bill_tot_outst_amt @@" +v_bill_tot_outst_amt);

					if(i % 2 == 0 )
					{
						classval	=	"QRYEVEN";
					}
					else
					{
						classval	=	"QRYODD";
					}
%>
			<tr>
<%
				if(v_bill_tot_outst_amt > 0)
				{
%>
				<td class=<%=classval%> width='40%'><div id='doc_num_<%=i%>'><a href="javascript:load_slmt_page('<%=i%>');"><%=doc_type_code%>/<%=doc_num%></a></div></td>
<%
				}

%>
				<td class=<%=classval%> width='40%'><div id='outst_amt_<%=i%>'><%=str_bill_tot_outst_amt%></div></td>
				
			</tr>
			<input type='hidden' name='doc_type_code_<%=i%>' id='doc_type_code_<%=i%>' value="<%=doc_type_code%>">
			<input type='hidden' name='doc_num_<%=i%>' id='doc_num_<%=i%>' value="<%=doc_num%>">
			<input type='hidden' name='blng_grp_id_<%=i%>' id='blng_grp_id_<%=i%>' value="<%=str_blng_grp_id%>">
<%			
					i++;
				}//while		
			}//rs 
			pstmt.close();
			rs.close();
		}
		catch(Exception e)
		{
			System.err.println("Exception in main qry :"+e);
		}
%>  
	</tbody>
	</table>
	</div>
	<input type="hidden" name="total_records" id="total_records"	value="<%=i%>" >
	<input type="hidden" name="noofdecimal" id="noofdecimal"	value="<%=noofdecimal%>" >
	<input type="hidden" name="called_frm" id="called_frm"	value="<%=called_frm%>" >
	<input type="hidden" name="episode_type" id="episode_type"	value="<%=str_episode_type%>" >	
	<input type="hidden" name="alw_co_wit_bl_slmt_yn" id="alw_co_wit_bl_slmt_yn"	value="<%=alw_co_wit_bl_slmt_yn%>" >		

</form>
</BODY>
<script>
	var total_records = document.forms[0].total_records.value;
//	alert(total_records);
	if(total_records == 0)
	{
//		 alert(1);
		/*parent.window.returnValue = "Y";
		parent.window.close(); */
		if(parent.document.getElementById('dialog-body'))
		{
			console.log("line 314 BLBilllistDtls.jsp")
			
			var dialogBody =  parent.document.getElementById('dialog-body');
		
			dialogBody.contentWindow.returnValue ="Y";
			var dialogTag = parent.document.getElementById('dialog_tag')
			dialogTag.close();
			
		}
		else if(parent.parent.document.getElementById('dialog-body'))
		{
			console.log("line 325 BLBilllistDtls.jsp")
			//console.log("line 349 BLBillSlmtMain.jsp")
			var dialogBody = parent.parent.document.getElementById('dialog-body');
			dialogBody.contentWindow.returnValue ="Y";
			//console.log(dialogBody)
			var dialogTag = parent.parent.document.getElementById('dialog_tag');
			dialogTag.close();
			
		}
	}
</script>
</HTML>
<%
	}
	catch(Exception ee)
	{
	  System.err.println("Error in main Adhoc disc " +ee);
	}
	finally 
	{
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}
%>

