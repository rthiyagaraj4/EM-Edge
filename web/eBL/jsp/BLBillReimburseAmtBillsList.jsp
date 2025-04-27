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

		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");

		int i=0,noofdecimal=2;

		String str_blng_grp_id="",str_blng_grp_desc="",doc_type_code="",doc_num="", doc_date="";

		String locale="", str_facility_id="", strloggeduser="", strclientip="", str_patient_id="", str_episode_type="", str_episode_id="", str_visit_id="", str_encounter_id="", str_module_id="", called_frm="", alw_co_wit_bl_slmt_yn="";

		String tot_bill_amt="", str_bill_tot_outst_amt="";

		double v_tot_bill_amt=0, v_bill_tot_outst_amt=0;
		
		CurrencyFormat cf1 = new CurrencyFormat();

		String query_string=request.getQueryString();

		try
		{
			locale	= (String)session.getAttribute("LOCALE");	
			if(locale==null || locale.equals("")) locale="en";	

			str_facility_id = (String) session.getValue("facility_id");
			if (str_facility_id==null) str_facility_id = "";

			strloggeduser	=  (String) session.getValue("login_user");	
			if (strloggeduser==null) strloggeduser = "";

			strclientip = p.getProperty("client_ip_address");
			if (strclientip==null) strclientip = "";

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
		<script language='javascript' src='../../eBL/js/BLBillReimburseAmtDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
	function check_load_slmt()
	{
		var tot_rec = document.forms[0].total_records.value;
		var rec_to_load;

		for(var i=0;i<tot_rec;i++)
		{
			var outst_amt_id = "outst_amt_"+i;
			var outst_amt = eval(document.getElementById("outst_amt_id"));
			outst_amt = outst_amt.innerText;

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
		var patient_id = document.forms[0].patient_id.value;
		var episode_type = document.forms[0].episode_type.value;
		var query_string = document.forms[0].query_string.value;

		var doc_type_code = eval("document.forms[0].doc_type_code_"+sel_rec);
		doc_type_code = doc_type_code.value;

		var doc_num = eval("document.forms[0].doc_num_"+sel_rec);
		doc_num = doc_num.value;

		parent.frames[1].location.href = "../../eBL/jsp/BLBillReimburseAmtBillServDetails.jsp?billdoctypecode="+doc_type_code+"&billdocnum="+doc_num+"&patient_id="+patient_id+"&episode_type="+episode_type+"&"+query_string;
	}	
</script>

<BODY onLoad="check_load_slmt();" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 					      					  onSelect="codeArrestThruSelect();">
<FORM name='AdhocDicountsbyServiceForm' id='AdhocDicountsbyServiceForm' onLoad="" action="" method=''>	
<div>
	<table border='1' cellpadding='3' cellspacing='0' width='100%'>	
	<tr><td class='COLUMNHEADER' colspan='9' align='left'><fmt:message key="eBL.OUTST_PAT_BILLS.label" bundle="${bl_labels}"/></td></tr>
	</table>
</div>
	<div id="tbl-container" STYLE="overflow: auto; width: 100%; height: 105px;   padding:3px; margin: 0px">
	<table border='1' cellpadding='3' cellspacing='0' width='90%' align='center'>	
	<thead>
			<tr><td></td></tr>
		<tr>			
<!--
			<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
-->
			<td class='COLUMNHEADER' width='20%'><fmt:message key="Common.documentno.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='20%'><fmt:message key="Common.DocumentDate.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='30%'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='15%'>Bill Amount</td>
			<td class='COLUMNHEADER' width='15%'><fmt:message key="Common.outstandingamount.label" bundle="${common_labels}"/></td>
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

			String strsql="Select DOC_TYPE_CODE,DOC_NUM,to_char(DOC_DATE,'DD/MM/YYYY HH24:MI:SS'),BLNG_GRP_ID,BILL_AMT,nvl(bill_tot_outst_amt,0) From BL_BILL_HDR" 
			+" where operating_facility_id = '"+str_facility_id+"'" 
			+" and patient_id = '"+str_patient_id+"'"
			+" and episode_type = '"+str_episode_type+"'"
			+" and episode_id = '"+str_episode_id+"'"
			+" and (('"+str_episode_type+"' IN ('O','E') and visit_id = '"+str_visit_id+"') OR ('"+str_episode_type+"' IN ('I','D')) OR ('"+str_episode_type+"'='R'))"
			+" and NVL(BILL_TOT_OUTST_AMT,0) > 0"
			+" and NVL(BILL_STATUS,'X') != 'C'"
			+" And Nvl(BILL_PAID_AMT,0)=0"
			+" and BILL_NATURE_CODE='C' ORDER BY DOC_DATE DESC,DOC_TYPE_CODE,DOC_NUM";

			stmt = con.createStatement();
			rs = stmt.executeQuery(strsql) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					doc_type_code = rs.getString(1);
					if(doc_type_code == null) doc_type_code="";

					doc_num = rs.getString(2);
					if(doc_num == null) doc_num="";

					doc_date = rs.getString(3);
					if(doc_date == null) doc_date="";

					str_blng_grp_id=rs.getString(4);
					if(str_blng_grp_id == null) str_blng_grp_id="";

					tot_bill_amt = rs.getString(5);
					if(tot_bill_amt == null) tot_bill_amt="0";
					tot_bill_amt = cf1.formatCurrency(tot_bill_amt, noofdecimal);
					v_tot_bill_amt = Double.parseDouble(tot_bill_amt);

					str_bill_tot_outst_amt =rs.getString(6);
					if(str_bill_tot_outst_amt == null) str_bill_tot_outst_amt="0";
					str_bill_tot_outst_amt = cf1.formatCurrency(str_bill_tot_outst_amt, noofdecimal);
					v_bill_tot_outst_amt = Double.parseDouble(str_bill_tot_outst_amt);

					try
					{		
						pstmt1 = con.prepareStatement( " select SHORT_DESC from bl_blng_grp_lang_vw where blng_grp_id='"+str_blng_grp_id+"'");
						rs1 = pstmt1.executeQuery();	
						while(rs1.next())
						{
							str_blng_grp_desc  =  rs1.getString(1);		
						}		
						if(str_blng_grp_desc == null) str_blng_grp_desc="";
						rs1.close();
						pstmt1.close();
					}
					catch(Exception e)
					{
						System.err.println("Billing Grp Desc Fetching="+e.toString());
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
				<td class=<%=classval%> width='20%'><div id='doc_num_<%=i%>'><a href="javascript:load_slmt_page('<%=i%>','C');"><%=doc_type_code%>/<%=doc_num%></a></div></td>
				<td class=<%=classval%> width='20%'><div id='doc_date<%=i%>'><%=com.ehis.util.DateUtils.convertDate(doc_date,"DMYHMS","en",locale)%></div></td>
				<td class=<%=classval%> width='25%'><div id='str_blng_grp_desc_<%=i%>'><%=str_blng_grp_desc%></div></td>
				<td class=<%=classval%> width='15%'><div id='tot_bill_amt<%=i%>'><%=v_tot_bill_amt%></div></td>
				<td class=<%=classval%> width='15%'><div id='outst_amt_<%=i%>'><%=str_bill_tot_outst_amt%></div></td>
				
			</tr>
			<input type='hidden' name='doc_type_code_<%=i%>' id='doc_type_code_<%=i%>' value="<%=doc_type_code%>">
			<input type='hidden' name='doc_num_<%=i%>' id='doc_num_<%=i%>' value="<%=doc_num%>">
			<input type='hidden' name='blng_grp_id_<%=i%>' id='blng_grp_id_<%=i%>' value="<%=str_blng_grp_id%>">
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
	<input type="hidden" name="query_string" id="query_string"	value="<%=query_string%>" >
	<input type="hidden" name="total_records" id="total_records"	value="<%=i%>" >
	<input type="hidden" name="noofdecimal" id="noofdecimal"	value="<%=noofdecimal%>" >
	<input type="hidden" name="called_frm" id="called_frm"	value="<%=called_frm%>" >
	<input type="hidden" name="patient_id" id="patient_id"	value="<%=str_patient_id%>" >
	<input type="hidden" name="episode_type" id="episode_type"	value="<%=str_episode_type%>" >	
	<input type="hidden" name="alw_co_wit_bl_slmt_yn" id="alw_co_wit_bl_slmt_yn"	value="<%=alw_co_wit_bl_slmt_yn%>" >		

</form>
</BODY>
<script>
	var total_records = document.forms[0].total_records.value;
//	alert(total_records);
	if(total_records == 0)
	{
		parent.window.returnValue = "Y";
		parent.window.close();
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

