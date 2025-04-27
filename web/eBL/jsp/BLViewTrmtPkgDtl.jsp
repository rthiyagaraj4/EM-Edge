<!DOCTYPE html>
 <%@ page  import="java.sql.*,webbeans.eCommon.*,java.util.*,webbeans.op.CurrencyFormat" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<%
	Connection con = null;
	PreparedStatement pstmt= null, pstmt_serv=null;//pstmt_pack = null ;
	ResultSet rs=null,rs_serv= null;// rs_pack =null	

	String str_pack_seq_no="", str_price_class_code="", str_pack_short_desc=""; //str_eff_date_from="",str_eff_date_to="",str_package_amt="",str_deposit_amt="",str_blng_grp_short_desc = "",  str_availed_amt=""

	String str_serv_short_desc="", str_serv_limit_qty="", str_serv_availed_qty="", str_serv_limit_amt="", str_serv_availed_amt="";
	String classval="", str_cald_for_is="";
	int i=0, j=0, noofdecimal=2;
	
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

		String encounter_date = request.getParameter("encounter_date");
		if (encounter_date==null) encounter_date="";

		String str_episode_type = request.getParameter("episode_type");
		if (str_episode_type==null) str_episode_type="";

		String str_episode_id = request.getParameter("episode_id");
		if (str_episode_id==null) str_episode_id="";

		String str_visit_id = request.getParameter("visit_id");
		if (str_visit_id==null) str_visit_id="";

		str_pack_seq_no = request.getParameter("pack_seq_no");
		if (str_pack_seq_no==null) str_pack_seq_no="";

		str_price_class_code = request.getParameter("price_class_code");
		if (str_price_class_code==null) str_price_class_code="";

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

		try
		{		
			pstmt = con.prepareStatement( " select B.SHORT_DESC FROM bl_patient_package_hdr A, BL_PRICE_CLASS_LANG_VW B WHERE A.operating_facility_id = '"+str_facility_id+"' AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND B.LANGUAGE_ID = '"+locale+"' and A.PRICE_CLASS_CODE = B.PRICE_CLASS_CODE and A.PRICE_CLASS_CODE='"+str_price_class_code+"'");

			rs = pstmt.executeQuery();	
			while(rs.next())
			{
				str_pack_short_desc  =  rs.getString(1);		
			}		
			rs.close();
			pstmt.close();
			if(str_pack_short_desc == null) str_pack_short_desc="";
//			System.out.println("str_pack_short_desc:"+str_pack_short_desc);
		}
		catch(Exception e)
		{
			System.out.println("package desc="+e.toString());
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
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="package_dtls" id="package_dtls" method=post action="">

<table cellpadding=3 cellspacing=0  width="95%" align='right' border=1>
<thead>
	<tr>
		<td class='COLUMNHEADER' colspan='9' align='left'><fmt:message key="eBL.PKG_COMPONENT.label" bundle="${bl_labels}"/> - <%=str_pack_short_desc%></td>
	</tr>
	<tr>
		<td class='COLUMNHEADER' width='15%'><fmt:message key="Common.ServiceDescription.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.QTY_LMT.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.AVAILD_QTY.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.AMT_LMT.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.AVAILD_AMT.label" bundle="${bl_labels}"/></td>
	</tr>
</thead>

<tbody>
<%
		String sql_pkg_dtl_qry="SELECT  DECODE(LENGTH(A.BLNG_SERV_CODE),3,(SELECT SHORT_DESC FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE SERV_CLASSIFICATION_CODE = A.BLNG_SERV_CODE AND LANGUAGE_ID = '"+locale+"'),2,(SELECT SHORT_DESC FROM BL_BLNG_SERV_GRP_LANG_VW WHERE SERV_GRP_CODE = A.BLNG_SERV_CODE AND LANGUAGE_ID = '"+locale+"') ,  (SELECT SHORT_DESC FROM BL_BLNG_SERV_LANG_VW WHERE BLNG_SERV_CODE = A.BLNG_SERV_CODE AND LANGUAGE_ID = '"+locale+"')) SHORT_DESC ,SERV_LIMIT_QTY SERV_QTY_LIMIT, availed_qty AVAILED_QTY,SERV_LIMIT_AMT SERV_AMT_LIMIT,a.availed_amt AVAILED_AMT FROM bl_patient_package_dtl a, bl_patient_package_hdr b WHERE a.operating_facility_id = b.operating_facility_id AND a.patient_id = b.patient_id AND a.package_seq_no = b.package_seq_no AND a.blng_grp_id = b.blng_grp_id AND a.operating_facility_id = '"+str_facility_id+"' AND a.patient_id = '"+str_patient_id+"' AND A.PRICE_CLASS_CODE = '"+str_price_class_code+"' AND A.PACKAGE_SEQ_NO = '"+str_pack_seq_no+"' AND to_date('"+encounter_date+"','DD/MM/YYYY') BETWEEN eff_date_from AND nvl(eff_date_to, to_date('"+encounter_date+"','DD/MM/YYYY')) AND b.status = 'O'";	

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
		<td class=<%=classval%> width='32%'><div id="serv_short_desc_<%=i%>"><%=str_serv_short_desc%></div></td>
		
		<td class=<%=classval%> width='17%'><div id="serv_limit_qty_<%=i%>" style='text-align:right'><%=(str_serv_limit_qty==null || str_serv_limit_qty.equals(""))?"&nbsp;":cf.formatCurrency(str_serv_limit_qty, noofdecimal)%></div></td>
		
		<td class=<%=classval%> width='17%'><div id="serv_availed_qty_<%=i%>" style='text-align:right'><%=(str_serv_availed_qty==null || str_serv_availed_qty.equals(""))?"&nbsp;":cf.formatCurrency(str_serv_availed_qty, noofdecimal)%></div></td>
		
		<td class=<%=classval%> width='17%'><div id="serv_limit_amt_<%=i%>" style='text-align:right'><%=(str_serv_limit_amt==null || str_serv_limit_amt.equals(""))?"&nbsp;":cf.formatCurrency(str_serv_limit_amt, noofdecimal)%></div></td>
		
		<td class=<%=classval%> width='17%'><div id="serv_availed_amt_<%=i%>" style='text-align:right'><%=(str_serv_availed_amt==null || str_serv_availed_amt.equals(""))?"&nbsp;":cf.formatCurrency(str_serv_availed_amt, noofdecimal)%></div></td>
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

