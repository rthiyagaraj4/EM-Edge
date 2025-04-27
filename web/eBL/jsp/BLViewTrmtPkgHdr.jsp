<!DOCTYPE html>
 <%@ page  import="java.sql.*,webbeans.eCommon.*,java.util.*,webbeans.op.CurrencyFormat" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<%
	Connection con = null;
	PreparedStatement pstmt= null, pstmt1= null, pstmt_pack = null, pstmt_serv=null ;
	ResultSet rs=null, rs1=null, rs_pack =null, rs_serv= null;	

	String str_pack_seq_no="", str_price_class_code="", str_pack_long_desc="", str_eff_date_from="", str_eff_date_to="", str_package_amt="", str_availed_amt="", str_deposit_amt="", str_blng_grp_short_desc = "", str_blng_grp_long_desc= "";
	String str_cust_grp_code="", str_cust_code="", str_cust_grp_desc="", str_cust_desc="";

	String str_serv_short_desc="", str_serv_limit_qty="", str_serv_availed_qty="", str_serv_limit_amt="", str_serv_availed_amt="";
	String classval="", str_cald_for_is="", str_cald_frm="", str_cald_with_bg_YN="N", str_ordr_by_blng_grp_id="";
	int i=0, j=0, noofdecimal=2, total_records=0;
	
	try
	{
		request.setCharacterEncoding("UTF-8");	
		con	=	ConnectionManager.getConnection(request);
		HttpSession httpSession = request.getSession(false);
		String locale	= (String)session.getAttribute("LOCALE");
		CurrencyFormat cf = new CurrencyFormat();
		String str_facility_id = (String)httpSession.getValue("facility_id");

//		System.out.println("Query String:"+request.getQueryString());

		String str_patient_id = request.getParameter("patient_id");
		if (str_patient_id==null) str_patient_id="";

		String str_blng_grp_id = request.getParameter("blng_grp_id");
		if (str_blng_grp_id==null) str_blng_grp_id="";

		str_cald_for_is = request.getParameter("cald_for_is");
		if (str_cald_for_is==null) str_cald_for_is="";

		str_cald_frm = request.getParameter("cald_frm");
		if (str_cald_frm==null) str_cald_frm="";

		str_cald_with_bg_YN = request.getParameter("cald_with_bg_YN");
		if (str_cald_with_bg_YN==null) str_cald_with_bg_YN="N";		

		String encounter_date = request.getParameter("encounter_date");
		if (encounter_date==null) encounter_date="";

		String str_episode_type = request.getParameter("episode_type");
		if (str_episode_type==null) str_episode_type="";

		String str_episode_id = request.getParameter("episode_id");
		if (str_episode_id==null) str_episode_id="";

		String str_visit_id = request.getParameter("visit_id");
		if (str_visit_id==null) str_visit_id="";

		String str_citizen_yn = request.getParameter("citizen_yn");
		if (str_citizen_yn==null) str_citizen_yn="";		

		String str_ext_billing_group = request.getParameter("ext_billing_group");
		if (str_ext_billing_group==null) str_ext_billing_group="";		

		String str_blnggrp = request.getParameter("blnggrp");
		if (str_blnggrp==null) str_blnggrp="";	

		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rs = pstmt.executeQuery();	
			while(rs.next())
			{
				noofdecimal  =  rs.getInt(1);		
			}		
			rs.close();
			pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("noofdecimal="+e.toString());
		}
%>
<head>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</head>
<script>
	function call_pkg_dtl(price_class_code, pack_seq_no,row_id)
	{
		var facility_id = document.forms[0].facility_id.value;
		var patient_id = document.forms[0].patient_id.value;
		var encounter_date = document.forms[0].encounter_date.value;
	
		var pkg_rw_disp = document.getElementById("pkg_rw_"+row_id);
//		var pkg_exp_comp_disp = eval("document.getElementById("pkg_exp_comp")"+row_id);		
		var pkg_exp_comp_disp = document.getElementById("pkg_exp_comp_"+row_id);		
	
		var pkg_dtl_show_hide = eval("document.forms[0].pkg_dtl_show_hide_"+row_id);

		if(pkg_dtl_show_hide.value == "H")
			pkg_dtl_show_hide.value = "S";
		else
			pkg_dtl_show_hide.value = "H";

		if(pkg_dtl_show_hide.value == "S")
		{
			pkg_rw_disp.style.display="inline";
			pkg_exp_comp_disp.src="../../eCommon/images/minusbottom.gif";
		}
		else
		{
			pkg_rw_disp.style.display="none";
			pkg_exp_comp_disp.src="../../eCommon/images/plusbottom.gif";
		}
		
//		parent.frames[1].location.href = "../../eBL/jsp/BLViewTrmtPkgDtl.jsp?facility_id="+facility_id+"&patient_id="+patient_id+"&encounter_date="+encounter_date+"&price_class_code="+price_class_code+"&pack_seq_no="+pack_seq_no;

	}

	function ret_blng_grp(row_id)
	{
		var cust_grp_code = "", cust_code = "";

		var total_records = document.forms[0].total_records.value;

		var blng_grp_id = eval("document.forms[0].blng_grp_id_"+row_id);
		blng_grp_id = blng_grp_id.value;

		var blng_grp_desc = document.getElementById("blng_grp_desc_"+row_id);
		blng_grp_desc = blng_grp_desc.innerText;

		var blng_grp_short_desc = eval("document.forms[0].blng_grp_short_desc_"+row_id);
		blng_grp_short_desc = blng_grp_short_desc.value;		

		for(var i=0;i<total_records;i++)
		{
			var blng_grp_id_temp = eval("document.forms[0].blng_grp_id_"+i);
			var cust_grp_code_temp = eval("document.forms[0].cust_grp_code_"+i);
			var cust_code_temp = eval("document.forms[0].cust_code_"+i);

			if(blng_grp_id_temp.value == blng_grp_id)
			{
				if(i != (total_records-1)) 
					cust_grp_code = cust_grp_code+cust_grp_code_temp.value+"@@";
				else
					cust_grp_code = cust_grp_code+cust_grp_code_temp.value;
				
				if(i != (total_records-1)) 
					cust_code = cust_code+cust_code_temp.value+"@@";
				else
					cust_code = cust_code+cust_code_temp.value;
			}
		}
			
		var retVal = blng_grp_id+"||"+blng_grp_short_desc+"||"+cust_grp_code+"||"+cust_code+"||";

		parent.window.returnValue = retVal;
		parent.window.close();
	}
/*
	function call_1st_pkg_dtl()
	{
		var total_records = document.forms[0].total_records.value;

		if(total_records >0)
		{
			var facility_id = document.forms[0].facility_id.value;
			var patient_id = document.forms[0].patient_id.value;
			var encounter_date = document.forms[0].encounter_date.value;

			var price_class_code = eval("document.forms[0].price_class_code_"+0);
			price_class_code = price_class_code.value;

			var pack_seq_no = eval("document.forms[0].pack_seq_no_"+0);
			pack_seq_no = pack_seq_no.value;

			parent.frames[1].location.href = "../../eBL/jsp/BLViewTrmtPkgDtl.jsp?facility_id="+facility_id+"&patient_id="+patient_id+"&encounter_date="+encounter_date+"&price_class_code="+price_class_code+"&pack_seq_no="+pack_seq_no;
		}

	}
*/
</script>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="package_dtls" id="package_dtls" method=post action="">
<DIV id='tbl-container' style='width: 1020px;height: 550px;overflow: auto;' >

<table cellpadding=3 cellspacing=0  width="100%" align='left' border=1>
<thead>
	<tr>
		<td class='COLUMNHEADER' colspan='8' align='left' style="position:relative;top: expression(document.getElementById('tbl-container').scrollTop-2);z-index: 20"><fmt:message key="eBL.SUBS_OPEN_PACKAGE_DTL.label" bundle="${bl_labels}"/></td>
	</tr>
	<tr>
		<td width='100%' colspan='8'></td>
	</tr>
	<tr>
		<td class='COLUMNHEADER' width='15%' style="position:relative;top: expression(document.getElementById('tbl-container').scrollTop-2);z-index: 20"><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>

		<td class='COLUMNHEADER' width='15%' style="position:relative;top: expression(document.getElementById('tbl-container').scrollTop-2);z-index: 20"><fmt:message key="eBL.PKG_DESC.label" bundle="${bl_labels}"/></td>

		<td class='COLUMNHEADER' width='15%' style="position:relative;top: expression(document.getElementById('tbl-container').scrollTop-2);z-index: 20"><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/> / <fmt:message key="Common.Customer.label" bundle="${common_labels}"/></td>

		<td class='COLUMNHEADER' width='8%' style="position:relative;top: expression(document.getElementById('tbl-container').scrollTop-2);z-index: 20"><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></td>

		<td class='COLUMNHEADER' width='8%' style="position:relative;top: expression(document.getElementById('tbl-container').scrollTop-2);z-index: 20"><fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}"/></td>

		<td class='COLUMNHEADER' width='13%' style="position:relative;top: expression(document.getElementById('tbl-container').scrollTop-2);z-index: 20"><fmt:message key="eBL.PKG_AMT.label" bundle="${bl_labels}"/></td>

		<td class='COLUMNHEADER' width='13%' style="position:relative;top: expression(document.getElementById('tbl-container').scrollTop-2);z-index: 20"><fmt:message key="eBL.DEPOSIT_AMT.label" bundle="${bl_labels}"/></td>

		<td class='COLUMNHEADER' width='13%' style="position:relative;top: expression(document.getElementById('tbl-container').scrollTop-2);z-index: 20"><fmt:message key="eBL.AVAILD_AMT.label" bundle="${bl_labels}"/></td>
	</tr>
</thead>
<tbody>
<%
		String sql_pkg_dtl_hdr_qry="SELECT A.BLNG_GRP_ID, A.PACKAGE_SEQ_NO, A.PRICE_CLASS_CODE, B.LONG_DESC, to_char(A.EFF_DATE_FROM,'DD/MM/YYYY'), to_char(A.EFF_DATE_TO,'DD/MM/YYYY'), A.PACKAGE_AMT, A.AVAILED_AMT, A.DEPOSIT_AMT, C.SHORT_DESC, C.LONG_DESC ,A.CUST_GROUP_CODE,A.CUST_CODE FROM bl_patient_package_hdr A, BL_PRICE_CLASS_LANG_VW B, BL_BLNG_GRP_LANG_VW C WHERE A.operating_facility_id = '"+str_facility_id+"' AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND B.LANGUAGE_ID = '"+locale+"' and B.LANGUAGE_ID = C.LANGUAGE_ID and  A.PRICE_CLASS_CODE = B.PRICE_CLASS_CODE AND A.BLNG_GRP_ID = C.BLNG_GRP_ID AND A.patient_id = '"+str_patient_id+"' AND to_date('"+encounter_date+"','DD/MM/YYYY') BETWEEN eff_date_from AND nvl(eff_date_to, to_date('"+encounter_date+"','DD/MM/YYYY')) AND A.status = 'O'";
		
		if(str_cald_frm.equals("REG"))
		{
			sql_pkg_dtl_hdr_qry = sql_pkg_dtl_hdr_qry +" and ( NVL(c.category,'UNRESTRICTED') IN ( DECODE('"+str_citizen_yn+"','Y','NATIONALS','N','OTHERS','UNRESTRICTED'), 'UNRESTRICTED')) ";	

			if(str_blnggrp.equals("1"))
			{
				sql_pkg_dtl_hdr_qry = sql_pkg_dtl_hdr_qry +" and nvl(c.ref_yn,'N')='Y' and nvl(c.hcare_only_yn,'N') = 'N' and nvl(c.status,'X' )!='S' ";
			}
			else if (str_blnggrp.equals("2")) 
			{
				sql_pkg_dtl_hdr_qry = sql_pkg_dtl_hdr_qry +" and nvl(c.ref_yn,'N')='Y' and nvl(c.ref_valid_for_regn_yn,'N')='Y' and nvl(c.status,'X' )!='S' and nvl(c.hcare_only_yn,'N') = 'N' " ;	
			}
			else if (str_blnggrp.equals("3")) 
			{
				sql_pkg_dtl_hdr_qry = sql_pkg_dtl_hdr_qry +" and nvl(c.op_yn,'N')='Y' and nvl(c.status,'X' )!='S' and  nvl(c.health_card_appl_yn,'N')='N' and nvl(c.hcare_only_yn,'N')='N' ";
			}
			else if (str_blnggrp.equals("4")) 
			{
				sql_pkg_dtl_hdr_qry = sql_pkg_dtl_hdr_qry +" and nvl(c.ip_yn,'N')='Y' and nvl(c.status,'X' )!='S' and nvl(c.health_card_appl_yn,'N')='N' and nvl(c.hcare_only_yn,'N')='N'";
			}
			else if (str_blnggrp.equals("5")) 
			{
				sql_pkg_dtl_hdr_qry = sql_pkg_dtl_hdr_qry +" and nvl(c.status,'X' ) != 'S' and nvl(c.health_card_appl_yn,'N')= 'N' and nvl(c.hcare_only_yn,'N')='N'";
			}
			else if (str_blnggrp.equals("6")) 
			{	
				sql_pkg_dtl_hdr_qry = sql_pkg_dtl_hdr_qry +" and nvl(c.status,'X' )!='S' and c.blng_grp_id = '" + str_ext_billing_group + "' ";
			}
			else if (str_blnggrp.equals("7")) 
			{
				sql_pkg_dtl_hdr_qry = sql_pkg_dtl_hdr_qry +" and nvl(c.ae_yn,'N')='Y' and nvl(c.status,'X' )!='S' and  nvl(c.health_card_appl_yn,'N')='N' and nvl(c.hcare_only_yn,'N')='N' ";
			}
			else if (str_blnggrp.equals("8"))  
			{
				sql_pkg_dtl_hdr_qry = sql_pkg_dtl_hdr_qry +" and nvl(c.dy_yn,'N')='Y' and nvl(c.status,'X' )!='S' and  nvl(c.health_card_appl_yn,'N')='N' and nvl(c.hcare_only_yn,'N')='N' ";
			}

			if(str_cald_with_bg_YN.equals("Y"))
			{
				sql_pkg_dtl_hdr_qry = sql_pkg_dtl_hdr_qry + " AND A.BLNG_GRP_ID='"+str_blng_grp_id+"'";
			}
		}

		if(str_cald_for_is.equals("E"))
		{
			 sql_pkg_dtl_hdr_qry = sql_pkg_dtl_hdr_qry + " and A.PACKAGE_SEQ_NO in ( select PACKAGE_SEQ_NO from bl_patient_charges_folio where operating_facility_id = '"+str_facility_id+"' and patient_id = '"+str_patient_id+"' and package_trx_yn = 'Y' and (('"+str_episode_type+"' in ('I','D') and episode_id = '"+str_episode_id+"')  or ('"+str_episode_type+"' in ('E','O') and episode_id = '"+str_episode_id+"' and visit_id = '"+str_visit_id+"')))";
		}
		 sql_pkg_dtl_hdr_qry = sql_pkg_dtl_hdr_qry + " ORDER BY A.blng_grp_id,A.package_seq_no";

		
//		System.out.println("sql_pkg_dtl_hdr_qry:"+sql_pkg_dtl_hdr_qry);

		pstmt_pack = con.prepareStatement(sql_pkg_dtl_hdr_qry);
		rs_pack = pstmt_pack.executeQuery() ;

		if( rs_pack != null) 
		{
			while( rs_pack.next() )
			{  
				str_blng_grp_id  = rs_pack.getString(1);
				if(str_blng_grp_id == null) str_blng_grp_id=""; 

				str_pack_seq_no = rs_pack.getString(2);
				if(str_pack_seq_no == null) str_pack_seq_no="";

				str_price_class_code = rs_pack.getString(3);
				if(str_price_class_code == null) str_price_class_code="";

				str_pack_long_desc = rs_pack.getString(4);
				if(str_pack_long_desc == null) str_pack_long_desc="";

				str_eff_date_from = rs_pack.getString(5);
				if(str_eff_date_from == null) str_eff_date_from="";
				if(!str_eff_date_from.equals(""))
				{
					str_eff_date_from=com.ehis.util.DateUtils.convertDate(str_eff_date_from,"DMY","en",locale);
				}

				str_eff_date_to = rs_pack.getString(6);
				if(str_eff_date_to == null) str_eff_date_to="";
				if(!str_eff_date_to.equals(""))
				{
					str_eff_date_to=com.ehis.util.DateUtils.convertDate(str_eff_date_to,"DMY","en",locale);
				}

				str_package_amt = rs_pack.getString(7);
				if(str_package_amt == null) str_package_amt="0";
				str_package_amt = cf.formatCurrency(str_package_amt, noofdecimal);

				str_availed_amt = rs_pack.getString(8);
				if(str_availed_amt == null) str_availed_amt="0";
				str_availed_amt = cf.formatCurrency(str_availed_amt, noofdecimal);

				str_deposit_amt = rs_pack.getString(9);
 				if(str_deposit_amt == null) str_deposit_amt="0";
				str_deposit_amt = cf.formatCurrency(str_deposit_amt, noofdecimal);

				str_blng_grp_short_desc = rs_pack.getString(10);
 				if(str_blng_grp_short_desc == null) str_blng_grp_short_desc="";

				str_blng_grp_long_desc = rs_pack.getString(11);
 				if(str_blng_grp_long_desc == null) str_blng_grp_long_desc="";

				str_cust_grp_code=rs_pack.getString(12);
 				if(str_cust_grp_code == null) str_cust_grp_code="";

				str_cust_code=rs_pack.getString(13);
 				if(str_cust_code == null) str_cust_code="";
				
				if(i % 2 == 0 )
				{
					classval	=	"QRYEVEN";
				}
				else
				{
					classval	=	"QRYODD";
				}
				
				str_cust_grp_desc = "";
				String sql_cust_grp_desc = "select long_desc from ar_cust_group_lang_vw where cust_group_code = '"+str_cust_grp_code+"' and language_id='"+locale+"'";
				pstmt1 = con.prepareStatement(sql_cust_grp_desc);
				rs1 = pstmt1.executeQuery() ;
				
				if( rs1 != null) 
				{
					while( rs1.next() )
					{  
						str_cust_grp_desc=rs1.getString(1);
						if(str_cust_grp_desc == null) str_cust_grp_desc="";
					}
				}
				if (rs1 != null)   rs1.close();
				if (pstmt1 != null) pstmt1.close();
	
				str_cust_desc = "";
				String sql_cust_desc = "select long_name from ar_customer_lang_vw where cust_code = '"+str_cust_code+"' and language_id='"+locale+"'";
				pstmt1 = con.prepareStatement(sql_cust_desc);
				rs1 = pstmt1.executeQuery() ;

				if( rs1 != null) 
				{
					while( rs1.next() )
					{  
						str_cust_desc=rs1.getString(1);
						if(str_cust_desc == null) str_cust_desc="";
					}
				}
				if (rs1 != null)   rs1.close();
				if (pstmt1 != null) pstmt1.close();
%>		
	<tr>
		<td class=<%=classval%> width='15%'>
<%		
		if(!str_blng_grp_id.equals(str_ordr_by_blng_grp_id))
		{
			if(str_cald_with_bg_YN.equals("N") && str_cald_frm.equals("REG"))
			{
%>
		<A href="javascript:ret_blng_grp('<%=i%>');"><B><div id="blng_grp_desc_<%=i%>"><%=str_blng_grp_long_desc%></div></B></A>
<%
			}
			else
			{
%>
		<B><div id="blng_grp_desc_<%=i%>"><%=str_blng_grp_long_desc%></div></B>
<%
			}
		}
%>
		</td>
		<td class=<%=classval%> width='15%'>
<%
		if(i==0)
		{
%>
		<A href="javascript:call_pkg_dtl('<%=str_price_class_code%>','<%=str_pack_seq_no%>','<%=i%>');"><img name='pkg_exp_comp_<%=i%>' src="../../eCommon/images/minusbottom.gif"></img></A>
<%
		}
		else
		{
%>
		<A href="javascript:call_pkg_dtl('<%=str_price_class_code%>','<%=str_pack_seq_no%>','<%=i%>');"><img name='pkg_exp_comp_<%=i%>' src="../../eCommon/images/plusbottom.gif"></img></A>
<%
		}
%>
		<div id="pkg_desc_<%=i%>"><%=str_pack_long_desc%></div></B>
		</td>
		<td class=<%=classval%> width='15%'><div id="cust_grp_<%=i%>">
<%
		if(!str_cust_grp_code.equals("") && !str_cust_code.equals(""))
		{
%>
		<%=(str_cust_grp_desc==null || str_cust_grp_desc.equals(""))?"&nbsp;":str_cust_grp_desc%> / <%=(str_cust_desc==null || str_cust_desc.equals(""))?"&nbsp;":str_cust_desc%>
<%
		}
		else
		{
%>
		&nbsp;
<%
		}
%>
		</div></td>
		
		<td class=<%=classval%> width='8%'><div id="eff_date_from_<%=i%>"><%=str_eff_date_from%></div></td>
		<td class=<%=classval%> width='8%'><div id="eff_date_to_<%=i%>"><%=str_eff_date_to%></div></td>
		<td class=<%=classval%> width='13%'><div id="package_amt_<%=i%>" style='text-align:right'><%=str_package_amt%></div></td>
		<td class=<%=classval%> width='13%'><div id="deposit_amt_<%=i%>" style='text-align:right'><%=str_deposit_amt%></div></td>
		<td class=<%=classval%> width='13%'><div id="availed_amt_<%=i%>" style='text-align:right'><%=str_availed_amt%></div></td>
		<input type="hidden" name="pack_seq_no_<%=i%>" id="pack_seq_no_<%=i%>" value="<%=str_pack_seq_no%>">
		<input type="hidden" name="price_class_code_<%=i%>" id="price_class_code_<%=i%>" value="<%=str_price_class_code%>">
		<input type="hidden" name="blng_grp_id_<%=i%>" id="blng_grp_id_<%=i%>" value="<%=str_blng_grp_id%>">
		<input type="hidden" name="blng_grp_short_desc_<%=i%>" id="blng_grp_short_desc_<%=i%>" value="<%=str_blng_grp_short_desc%>">
		<input type="hidden" name="cust_grp_code_<%=i%>" id="cust_grp_code_<%=i%>" value="<%=str_cust_grp_code%>">
		<input type="hidden" name="cust_code_<%=i%>" id="cust_code_<%=i%>" value="<%=str_cust_code%>">
		
<%
		if(i==0)
		{
%>
		<input type="hidden" name="pkg_dtl_show_hide_<%=i%>" id="pkg_dtl_show_hide_<%=i%>" value="S">
<%
		}
		else
		{
%>
		<input type="hidden" name="pkg_dtl_show_hide_<%=i%>" id="pkg_dtl_show_hide_<%=i%>" value="H">
<%
		}
%>
	</tr>
<tr>

<td colspan='8' >
<%
		if(i==0)
		{
%>
<div id='pkg_rw_<%=i%>' style='display:inline'>
<%
		}
		else
		{
%>
<div id='pkg_rw_<%=i%>' style='display:none'>
<%
		}
%>

<DIV id='tbl-comp-container_<%=i%>' style='width: 1000px;height: 100px;overflow: auto;' >
	<table cellpadding=3 cellspacing=0  width="95%" align='right' border=1>
<thead>
	<tr>
		<td class='COLUMNHEADER' colspan='9' align='left'  style="position:relative;top: expression(document.getElementById('tbl-comp-container_<%=i%>').scrollTop-2);z-index: 20"><fmt:message key="eBL.PKG_COMPONENT.label" bundle="${bl_labels}"/><%=str_pack_long_desc%></td>
	</tr>
	<tr>
		<td width='100%' colspan='7'></td>
	</tr>
	<tr>
		<td class='COLUMNHEADER' width='15%' style="position:relative;top: expression(document.getElementById('tbl-comp-container_<%=i%>').scrollTop-2);z-index: 20"><fmt:message key="Common.ServiceDescription.label" bundle="${common_labels}"/></td>

		<td class='COLUMNHEADER' width='15%' style="position:relative;top: expression(document.getElementById('tbl-comp-container_<%=i%>').scrollTop-2);z-index: 20"><fmt:message key="eBL.QTY_LMT.label" bundle="${bl_labels}"/></td>

		<td class='COLUMNHEADER' width='15%' style="position:relative;top: expression(document.getElementById('tbl-comp-container_<%=i%>').scrollTop-2);z-index: 20"><fmt:message key="eBL.AVAILD_QTY.label" bundle="${bl_labels}"/></td>

		<td class='COLUMNHEADER' width='15%' style="position:relative;top: expression(document.getElementById('tbl-comp-container_<%=i%>').scrollTop-2);z-index: 20"><fmt:message key="eBL.AMT_LMT.label" bundle="${bl_labels}"/></td>

		<td class='COLUMNHEADER' width='15%' style="position:relative;top: expression(document.getElementById('tbl-comp-container_<%=i%>').scrollTop-2);z-index: 20"><fmt:message key="eBL.AVAILD_AMT.label" bundle="${bl_labels}"/></td>
	</tr>
</thead>

<tbody>
<%
		String sql_pkg_dtl_qry="SELECT  DECODE(LENGTH(A.BLNG_SERV_CODE),3,(SELECT LONG_DESC FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE SERV_CLASSIFICATION_CODE = A.BLNG_SERV_CODE AND LANGUAGE_ID = '"+locale+"'),2,(SELECT LONG_DESC FROM BL_BLNG_SERV_GRP_LANG_VW WHERE SERV_GRP_CODE = A.BLNG_SERV_CODE AND LANGUAGE_ID = '"+locale+"') ,  (SELECT LONG_DESC FROM BL_BLNG_SERV_LANG_VW WHERE BLNG_SERV_CODE = A.BLNG_SERV_CODE AND LANGUAGE_ID = '"+locale+"')) SHORT_DESC ,SERV_LIMIT_QTY SERV_QTY_LIMIT, availed_qty AVAILED_QTY,SERV_LIMIT_AMT SERV_AMT_LIMIT,a.availed_amt AVAILED_AMT FROM bl_patient_package_dtl a, bl_patient_package_hdr b WHERE a.operating_facility_id = b.operating_facility_id AND a.patient_id = b.patient_id AND a.package_seq_no = b.package_seq_no AND a.blng_grp_id = b.blng_grp_id AND a.operating_facility_id = '"+str_facility_id+"' AND a.patient_id = '"+str_patient_id+"' AND A.PRICE_CLASS_CODE = '"+str_price_class_code+"' AND A.PACKAGE_SEQ_NO = '"+str_pack_seq_no+"' AND to_date('"+encounter_date+"','DD/MM/YYYY') BETWEEN eff_date_from AND nvl(eff_date_to, to_date('"+encounter_date+"','DD/MM/YYYY')) AND b.status = 'O'";	

		if(str_cald_for_is.equals("E"))
		{
			 sql_pkg_dtl_qry = sql_pkg_dtl_qry + " and (A.PACKAGE_SEQ_NO,A.BLNG_SERV_CODE) in ( select PACKAGE_SEQ_NO,BLNG_SERV_CODE from bl_patient_charges_folio where operating_facility_id = '"+str_facility_id+"' and patient_id = '"+str_patient_id+"' and package_trx_yn = 'Y' and (('"+str_episode_type+"' in ('I','D') and episode_id = '"+str_episode_id+"')  or ('"+str_episode_type+"' in ('E','O') and episode_id = '"+str_episode_id+"' and visit_id = '"+str_visit_id+"')))";
		}
		
//		System.out.println("sql_pkg_dtl_qry:"+sql_pkg_dtl_qry);

		pstmt_serv = con.prepareStatement(sql_pkg_dtl_qry);
		rs_serv = pstmt_serv.executeQuery() ;

		if( rs_serv != null) 
		{
			while( rs_serv.next() )
			{  
				str_serv_short_desc = rs_serv.getString(1);
				if(str_serv_short_desc == null) str_serv_short_desc="";

				str_serv_limit_qty = rs_serv.getString(2);
				if(str_serv_limit_qty == null) str_serv_limit_qty="";

				str_serv_availed_qty = rs_serv.getString(3);
				if(str_serv_availed_qty == null) str_serv_availed_qty="";

				str_serv_limit_amt = rs_serv.getString(4);
				if(str_serv_limit_amt == null) str_serv_limit_amt="";

				str_serv_availed_amt = rs_serv.getString(5);
				if(str_serv_availed_amt == null) str_serv_availed_amt="";

				if(j % 2 == 0 )
				{
					classval	=	"QRYEVEN";
				}
				else
				{
					classval	=	"QRYODD";
				}
%>
	<tr>
		<td class=<%=classval%> width='32%'><div id="serv_short_desc_<%=j%>"><%=str_serv_short_desc%></div></td>
		
		<td class=<%=classval%> width='17%'><div id="serv_limit_qty_<%=j%>" style='text-align:right'><%=(str_serv_limit_qty==null || str_serv_limit_qty.equals(""))?"&nbsp;":cf.formatCurrency(str_serv_limit_qty, noofdecimal)%></div></td>
		
		<td class=<%=classval%> width='17%'><div id="serv_availed_qty_<%=j%>" style='text-align:right'><%=(str_serv_availed_qty==null || str_serv_availed_qty.equals(""))?"&nbsp;":cf.formatCurrency(str_serv_availed_qty, noofdecimal)%></div></td>
		
		<td class=<%=classval%> width='17%'><div id="serv_limit_amt_<%=j%>" style='text-align:right'><%=(str_serv_limit_amt==null || str_serv_limit_amt.equals(""))?"&nbsp;":cf.formatCurrency(str_serv_limit_amt, noofdecimal)%></div></td>
		
		<td class=<%=classval%> width='17%'><div id="serv_availed_amt_<%=j%>" style='text-align:right'><%=(str_serv_availed_amt==null || str_serv_availed_amt.equals(""))?"&nbsp;":cf.formatCurrency(str_serv_availed_amt, noofdecimal)%></div></td>
	</tr>
			
<%			
				j++;		
			}
		}
				if (rs_serv != null)   rs_serv.close();
				if (pstmt_serv != null) pstmt_serv.close();
%>
</tbody>
</table>
</div>
</div>
</td>
</tr>

	<tr>
		<td width='100%' colspan='6'></td>
	</tr>
<%
				i++;
				str_ordr_by_blng_grp_id = str_blng_grp_id;
			}
		}
		if (rs_pack != null)   rs_pack.close();
		if (pstmt_pack != null) pstmt_pack.close();
		total_records = i;
%>
</tbody>
</table>
</div>
<input type='hidden' name='total_records' id='total_records' value="<%=total_records%>">
<input type='hidden' name='facility_id' id='facility_id' value="<%=str_facility_id%>">
<input type='hidden' name='patient_id' id='patient_id' value="<%=str_patient_id%>">
<input type='hidden' name='encounter_date' id='encounter_date' value="<%=encounter_date%>">

<%
	}
	catch(Exception e) 
	{ 
		System.out.println("Main Exception in BLViewTrmtPkgDtls.jsp"+e.toString());
	}
	finally 
	{
		ConnectionManager.returnConnection(con, request);
	}
%>
</form>
</body>
</html>

