<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%
	request.setCharacterEncoding("UTF-8");	
	Connection con				= null;
	PreparedStatement pstmt		= null;
	PreparedStatement pstmt1	= null;
	Statement stmt				= null;
	ResultSet rs				= null;	
	ResultSet rs1				= null;
	String classval="";
	try
	{
		con	=	ConnectionManager.getConnection(request);

//		HttpSession httpSession = request.getSession(false);
//		Properties p = (Properties)httpSession.getValue("jdbc");

		int i=0,noofdecimal=2;

		String locale="", str_facility_id="";
		
		String trx_doc_ref="",trx_doc_ref_line_num="",trx_doc_ref_seq_num="";

		String audit_no="",mod_by_id="",mod_date="",old_reimbursable_yn="",old_reimbursable_ind="",old_reimbursable_amt="",new_reimbursable_yn="",new_reimbursable_ind="",new_reimbursable_amt="",override_reason_code="",override_reason_desc="",old_checked_var="",new_checked_var="";

		double v_old_reimbursable_amt=0, v_new_reimbursable_amt=0;
		
		CurrencyFormat cf1 = new CurrencyFormat();

		String query_string=request.getQueryString();

		try
		{
			locale	= (String)session.getAttribute("LOCALE");	
			if(locale==null || locale.equals("")) locale="en";	

			str_facility_id = (String) session.getValue("facility_id");
			if (str_facility_id==null) str_facility_id = "";

			trx_doc_ref = request.getParameter("trx_doc_ref");
			if(trx_doc_ref == null) trx_doc_ref="";

			trx_doc_ref_line_num = request.getParameter("trx_doc_ref_line_num");
			if(trx_doc_ref_line_num == null) trx_doc_ref_line_num="";

			trx_doc_ref_seq_num = request.getParameter("trx_doc_ref_seq_num");
			if(trx_doc_ref_seq_num == null) trx_doc_ref_seq_num="";
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

thead td, thead td.locked	{
position:relative;
}

thead td {
top: expression(document.getElementById("tbl-container").scrollTop-4); 
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
		<script language='javascript' src='../../eBL/js/BLBillReimburseAmtDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<script>
function reimburse_check()
{
	var total_records = document.forms[0].total_records.value;

	for(var i=0;i<total_records;i++)
	{
		var old_reimb_type_hid = eval("document.forms[0].old_reimb_type_hid_"+i);
		old_reimb_type_hid = old_reimb_type_hid.value;

		var old_reimb_type = eval(document.getElementById('old_reimb_type_'+i));

		if(old_reimb_type_hid == "F")
		{
			old_reimb_type.innerText = getLabel("eBL.FULL.label","BL");
		}
		else if(old_reimb_type_hid == "P")
		{
			old_reimb_type.innerText = getLabel("eBL.PART.label","BL");
		}
		else if(old_reimb_type_hid == "N")
		{
			old_reimb_type.innerText = getLabel("eBL.NA.label","BL");
		}
		else
		{
			old_reimb_type.innerText = "";
		}

		var new_reimb_type_hid = eval("document.forms[0].new_reimb_type_hid_"+i);
		new_reimb_type_hid = new_reimb_type_hid.value;

		var new_reimb_type = eval(document.getElementById('new_reimb_type_'+i));

		if(new_reimb_type_hid == "F")
		{
			new_reimb_type.innerText = getLabel("eBL.FULL.label","BL");
		}
		else if(new_reimb_type_hid == "P")
		{
			new_reimb_type.innerText = getLabel("eBL.PART.label","BL");
		}
		else if(new_reimb_type_hid == "N")
		{
			new_reimb_type.innerText = getLabel("eBL.NA.label","BL");
		}
		else
		{
			new_reimb_type.innerText = "";
		}
	}
}
function on_key_press_reason_desc(event)
{
	return false ;
}

</script>

<BODY onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" onLoad="reimburse_check();">
<FORM name='BLBillReimbAmtBillServDtlsForm' id='BLBillReimbAmtBillServDtlsForm' onLoad="" action="" method=''>	
<div>

</div>
	<div id="tbl-container" STYLE="overflow: auto; width: 100%; height: 180px;   padding:3px; margin: 0px">
	<table border='1' cellpadding='3' cellspacing='0' width='100%'>	
	
	</table>
	<table border='1' cellpadding='3' cellspacing='0' width='100%' align='center'>	
	<thead>
		<tr>
			<td class='COLUMNHEADER' colspan='10' align='left'><fmt:message key="eBL.AUDIT_DTLS.label" bundle="${bl_labels}"/></td>
		</tr>
		<tr>
			<td></td>
		</tr>
		<tr>			
			<td class='COLUMNHEADER' width='20%'><fmt:message key="eBL.AUDIT_NO.label" bundle="${bl_labels}"/></td>
			<td class='COLUMNHEADER' width='20%'><fmt:message key="Common.modifiedby.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='30%'><fmt:message key="Common.modifieddatetime.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.OLD_REIMB.label" bundle="${bl_labels}"/></td>
			<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.OLD_REIMB_TYPE.label" bundle="${bl_labels}"/></td>
			<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.OLD_REIMB_AMT.label" bundle="${bl_labels}"/></td>
			<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.NEW_REIMB.label" bundle="${bl_labels}"/></td>
			<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.NEW_REIMB_TYPE.label" bundle="${bl_labels}"/></td>
			<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.NEW_REIMB_AMT.label" bundle="${bl_labels}"/></td>
			<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.OVERRIDING_REASON.label" bundle="${bl_labels}"/></td>
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

			String strsql="SELECT A.AUDIT_NO,A.MODIFIED_BY_ID,to_char(A.MODIFIED_DATE,'DD/MM/YYYY HH24:MI:SS') MODIFIED_DATE,A.OLD_REIMBURSABLE_YN,A.OLD_REIM_TYPE,A.OLD_REIMBURSABLE_AMT,A.NEW_REIMBURSABLE_YN,A.NEW_REIM_TYPE,A.NEW_REIMBURSABLE_AMT,A.REIM_REASON_CODE FROM BL_REIM_SERVICE_AUDIT A,BL_PATIENT_CHARGES_FOLIO B WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.Operating_Facility_Id='"+str_facility_id+"' and A.TRX_DOC_REF=B.TRX_DOC_REF AND A.TRX_DOC_REF_LINE_NUM=B.TRX_DOC_REF_LINE_NUM and A.TRX_DOC_REF_SEQ_NUM=B.TRX_DOC_REF_SEQ_NUM AND A.TRX_DOC_REF='"+trx_doc_ref+"' AND A.TRX_DOC_REF_LINE_NUM='"+trx_doc_ref_line_num+"' and A.TRX_DOC_REF_SEQ_NUM='"+trx_doc_ref_seq_num+"' ORDER BY MODIFIED_DATE DESC";

			stmt = con.createStatement();
			rs = stmt.executeQuery(strsql) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					audit_no = rs.getString(1);
					if(audit_no == null) audit_no="";

					mod_by_id = rs.getString(2);
					if(mod_by_id == null) mod_by_id="";

					mod_date = rs.getString(3);
					if(mod_date == null) mod_date="";

					old_reimbursable_yn = rs.getString(4);
					if(old_reimbursable_yn == null) old_reimbursable_yn="N";

					old_reimbursable_ind =rs.getString(5);
					if(old_reimbursable_ind == null) old_reimbursable_ind="";

					old_reimbursable_amt=rs.getString(6);
					if(old_reimbursable_amt == null) old_reimbursable_amt="0";
					old_reimbursable_amt = cf1.formatCurrency(old_reimbursable_amt, noofdecimal);
					v_old_reimbursable_amt = Double.parseDouble(old_reimbursable_amt);

					new_reimbursable_yn = rs.getString(7);
					if(new_reimbursable_yn == null) new_reimbursable_yn="N";

					new_reimbursable_ind =rs.getString(8);
					if(new_reimbursable_ind == null) new_reimbursable_ind="";

					new_reimbursable_amt=rs.getString(9);
					if(new_reimbursable_amt == null) new_reimbursable_amt="0";
					new_reimbursable_amt = cf1.formatCurrency(new_reimbursable_amt, noofdecimal);
					v_new_reimbursable_amt = Double.parseDouble(new_reimbursable_amt);

					override_reason_code=rs.getString(10);
					if(override_reason_code == null) override_reason_code="&nbsp;";

					if(old_reimbursable_yn.equals("Y"))
					{
						old_checked_var="CHECKED";
					}
					else
					{
						old_checked_var="";
					}

					if(new_reimbursable_yn.equals("Y"))
					{
						new_checked_var="CHECKED";
					}
					else
					{
						new_checked_var="";
					}

					try
					{		
						pstmt1 = con.prepareStatement( " SELECT distinct a.action_reason_desc actn_resn_desc FROM bl_action_reason_lang_vw a, bl_action_reason_by_type b WHERE a.action_reason_code = b.action_reason_code AND NVL(b.active_yn, 'N') = 'Y' AND NVL(a.status, 'X') <> 'S' and upper(a.language_id)=upper('"+locale+"') and a.action_reason_code='"+override_reason_code+"' AND ACTION_TYPE='OR'");
						rs1 = pstmt1.executeQuery();	
						while(rs1.next())
						{
							override_reason_desc  =  rs1.getString(1);		
						}		
						if(override_reason_desc == null) override_reason_desc="";
						rs1.close();
						pstmt1.close();
					}
					catch(Exception e)
					{
						System.err.println("override_reason_desc Fetching="+e.toString());
					}

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
				<td class=<%=classval%> width='20%'><div id='audit_no_<%=i%>'><%=audit_no%></div></td>
				<td class=<%=classval%> width='20%'><div id='mod_by_id_<%=i%>'><%=mod_by_id%></div></td>
				<td class=<%=classval%> width='20%'><div id='mod_date_<%=i%>'><%=com.ehis.util.DateUtils.convertDate(mod_date,"DMYHMS","en",locale)%></div></td>
				<td class=<%=classval%> width='20%'><div align='center'><input type="checkbox" name="old_reimb_YN_<%=i%>" id="old_reimb_YN_<%=i%>" <%=old_checked_var%> DISABLED></input></div></td>
				<td class=<%=classval%> width='20%'><div id="old_reimb_type_<%=i%>" align='center'></div>
<!--					<select name="old_reimb_type_<%=i%>" id="old_reimb_type_<%=i%>" DISABLED>
						<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<option value='F'><fmt:message key="eBL.FULL.label" bundle="${bl_labels}"/></option>
						<option value='P'><fmt:message key="eBL.PART.label" bundle="${bl_labels}"/></option>
						<option value='N'><fmt:message key="eBL.NA.label" bundle="${bl_labels}"/></option>
					</select>
-->
				</td>
				<td class=<%=classval%> width='20%'><div id='old_reimb_amt_<%=i%>' style='text-align:right'><%=old_reimbursable_amt%></div></td>
				<td class=<%=classval%> width='20%'><div align='center'><input type="checkbox" name="new_reimb_YN_<%=i%>" id="new_reimb_YN_<%=i%>" <%=new_checked_var%> DISABLED></input></div></td>
				<td class=<%=classval%> width='20%'><div id="new_reimb_type_<%=i%>" align='center'></div>
<!--
					<select name="new_reimb_type_<%=i%>" id="new_reimb_type_<%=i%>" DISABLED>
						<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<option value='F'><fmt:message key="eBL.FULL.label" bundle="${bl_labels}"/></option>
						<option value='P'><fmt:message key="eBL.PART.label" bundle="${bl_labels}"/></option>
						<option value='N'><fmt:message key="eBL.NA.label" bundle="${bl_labels}"/></option>
					</select>
-->
				</td>
				<td class=<%=classval%> width='20%'><div id='new_reimb_amt_<%=i%>' style='text-align:right'><%=new_reimbursable_amt%></div></td>
				<td class=<%=classval%> width='20%'><input type='text' name='ovride_reason_desc_<%=i%>' id='ovride_reason_desc_<%=i%>' value="<%=override_reason_desc%>" onKeyPress="return on_key_press_reason_desc(event);"></td>
			</tr>

			<input type='hidden' name='ovride_reason_code_<%=i%>' id='ovride_reason_code_<%=i%>' value="<%=override_reason_code%>">
			<input type='hidden' name='old_reimb_type_hid_<%=i%>' id='old_reimb_type_hid_<%=i%>' value="<%=old_reimbursable_ind%>">
			<input type='hidden' name='new_reimb_type_hid_<%=i%>' id='new_reimb_type_hid_<%=i%>' value="<%=new_reimbursable_ind%>">

<%			
					i++;
				}//while		
			}//rs 
			stmt.close();
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

</form>
</BODY>
<script>
	var total_records = document.forms[0].total_records.value;
//	alert(total_records);
	if(total_records == 0)
	{
//		alert(1);
//		parent.window.returnValue = "Y";
//		parent.window.close();
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

