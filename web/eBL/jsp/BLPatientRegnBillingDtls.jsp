<!DOCTYPE html>
<%@  page import="java.sql.*,  webbeans.eBL.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	Connection con = null;
	PreparedStatement pstmt = null ;
	Statement stmt				= null;
	ResultSet rs = null;

	String locale = (String)session.getAttribute("LOCALE");
	int noofdecimal=2;
	String sys_date="";
	String sys_date_wht_sec=""; // System time without seconds
	String facility_desc="", mode="";

	String pat_ser_grp_code="", pat_ser_grp_desc="", blng_grp_id="", blng_grp_desc="", payer_grp_code="", payer_grp_desc="";
	String payer_code="", payer_desc="", serv_panel_ind="", serv_panel_code="", serv_panel_desc= "";
	String charge_YN="N", charge_at_enc_regn_YN="N", slmt_ind="";
	
	String charge_at_renwel="N";
	String renewal_desc ="",renewal_code="";//Added V190404-MuthuKN/AMRI-CRF-0357.1

	String enable_disable_flag = "";

	try
	{
		con = ConnectionManager.getConnection(request);

		request.setCharacterEncoding("UTF-8");
		HttpSession httpSession = request.getSession(false);
//		Properties p  = (Properties)httpSession.getValue("jdbc");	
		String facility_id = (String)httpSession.getValue("facility_id");
//		String strLoggedUser = p.getProperty("login_user");

//		java.util.Locale loc = new java.util.Locale(locale);

		mode = request.getParameter("mode");
		if(mode == null) mode="";
//		System.err.println("Mode:"+mode);

		if(mode.equals("modify"))
		{
			enable_disable_flag = "DISABLED";
		}
		try
		{
			String facility_desc_sql="select FACILITY_NAME from SM_FACILITY_PARAM_LANG_VW where FACILITY_ID='"+facility_id+"' and language_id='"+locale+"'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(facility_desc_sql) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					facility_desc = rs.getString(1);
				}
			}
			if(rs !=null) rs.close();
			stmt.close();
		}
		catch(Exception e)
		{
			//out.println("Exception @ sysdate"+e);
			e.printStackTrace();
		}
		if(facility_desc == null) facility_desc="";

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

		try
		{
			String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from dual";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query_date) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					sys_date = rs.getString(1);
				}
			}
			if(rs !=null) rs.close();
			stmt.close();

			query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI') from dual";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query_date) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					sys_date_wht_sec = rs.getString(1);
				}
			}
			if(rs !=null) rs.close();
			stmt.close();
		}
		catch(Exception e)
		{
			//out.println("Exception @ sysdate"+e);
			e.printStackTrace();
		}

		if(mode.equals("modify"))
		{
//			System.err.println("Inside UPDATE loop");
			String str_pat_ser_grp_code = request.getParameter("pat_ser_grp_code");
			if(str_pat_ser_grp_code == null) str_pat_ser_grp_code="";

			String str_blng_grp_id = request.getParameter("blng_grp_id");
			if(str_blng_grp_id == null) str_blng_grp_id="";

			String str_payer_grp_code = request.getParameter("payer_grp_code");
			if(str_payer_grp_code == null) str_payer_grp_code="";

			String str_payer_code = request.getParameter("payer_code");
			if(str_payer_code == null) str_payer_code="";

//			System.err.println("str_pat_ser_grp_code:"+str_pat_ser_grp_code);
//			System.err.println("str_blng_grp_id:"+str_blng_grp_id);
//			System.err.println("str_payer_grp_code:"+str_payer_grp_code);
//			System.err.println("str_payer_code:"+str_payer_code);
			
			try
			{
				String sql = "select SETTLEMENT_IND from BL_BLNG_GRP where BLNG_GRP_ID= ?";				
				pstmt   = con.prepareStatement(sql.toString());
				pstmt.setString(1,str_blng_grp_id) ;
		
				rs = pstmt.executeQuery();
		
				while(rs!=null && rs.next())
				{
					slmt_ind = rs.getString("SETTLEMENT_IND");
					if(slmt_ind == null) slmt_ind="";
				}
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
//				System.err.println("slmt_ind:"+slmt_ind);
				if(slmt_ind.equals("C"))
				{
					sql = "select * from BL_MP_PAT_REGN_DTLS_VW where OPERATING_FACILITY_ID= ?  and PAT_SER_GRP_CODE= ?  and BLNG_GRP_ID=? and language_id=?";

					pstmt   = con.prepareStatement(sql.toString());
					pstmt.setString(1,facility_id) ;
					pstmt.setString(2,str_pat_ser_grp_code) ;
					pstmt.setString(3,str_blng_grp_id) ;
					pstmt.setString(4,locale) ;
				}
				else
				{
					sql = "select * from BL_MP_PAT_REGN_DTLS_VW where OPERATING_FACILITY_ID= ?  and PAT_SER_GRP_CODE= ?  and BLNG_GRP_ID=? and PAYER_GRP_CODE=? and PAYER_CODE=? and language_id=?";
					pstmt   = con.prepareStatement(sql.toString());
					pstmt.setString(1,facility_id) ;
					pstmt.setString(2,str_pat_ser_grp_code) ;
					pstmt.setString(3,str_blng_grp_id) ;
					pstmt.setString(4,str_payer_grp_code) ;
					pstmt.setString(5,str_payer_code) ;
					pstmt.setString(6,locale) ;
				}

				rs = pstmt.executeQuery();
		
				while(rs!=null && rs.next())
				{
					pat_ser_grp_code = rs.getString("PAT_SER_GRP_CODE");
					if(pat_ser_grp_code == null) pat_ser_grp_code="";

					pat_ser_grp_desc = rs.getString("PAT_SER_GRP_DESC");
					if(pat_ser_grp_desc == null) pat_ser_grp_desc="";
//					System.err.println("pat_ser_grp_desc:"+pat_ser_grp_desc);
					blng_grp_id = rs.getString("BLNG_GRP_ID");
					if(blng_grp_id == null) blng_grp_id="";

					blng_grp_desc = rs.getString("BLNG_GRP_DESC");
					if(blng_grp_desc == null) blng_grp_desc="";

					payer_grp_code = rs.getString("PAYER_GRP_CODE");
					if(payer_grp_code == null) payer_grp_code="";

					payer_grp_desc = rs.getString("PAYER_GRP_DESC");
					if(payer_grp_desc == null) payer_grp_desc="";

					payer_code = rs.getString("PAYER_CODE");
					if(payer_code == null) payer_code="";

					payer_desc = rs.getString("PAYER_DESC");
					if(payer_desc == null) payer_desc="";

					serv_panel_ind = rs.getString("SERV_PANEL_IND");
					if(serv_panel_ind == null) serv_panel_ind="";

					serv_panel_code = rs.getString("SERV_PANEL_CODE");
					if(serv_panel_code == null) serv_panel_code="";

					serv_panel_desc = rs.getString("SERV_PANEL_DESC");
					if(serv_panel_desc == null) serv_panel_desc="";

					charge_YN = rs.getString("CHARGE_YN");
					if(charge_YN == null) charge_YN="N";

					charge_at_enc_regn_YN = rs.getString("CHARGE_AT_ENC_REGN");
					if(charge_at_enc_regn_YN == null) charge_at_enc_regn_YN="N";
					
					charge_at_renwel = rs.getString("CHARGE_PAT_RENEW_YN");
					if(charge_at_renwel == null) charge_at_renwel="N";
					
					//Added V190404-MuthuKN/AMRI-CRF-0357.1
					renewal_code = rs.getString("REN_SERV_PANEL_CODE");
					if(renewal_code == null) renewal_code="";
					System.err.println("renewal_code:"+renewal_code);

					renewal_desc = rs.getString("REN_SERV_PANEL_DESC");
					if(renewal_desc == null) renewal_desc="";
					System.err.println("renewal_desc:"+renewal_desc);

					//Added V190404-MuthuKN/AMRI-CRF-0357.1
				}
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
			}
			catch(Exception e)
			{
				//System.err.println("Execption in Update Loop:"+e);
				//out.println("Execption in Update Loop:"+e);
				e.printStackTrace();
			}
		}
	
		String query_string=request.getQueryString();
//		System.err.println("request.getQueryString() in BLPatientRegnBillingDtls.jsp:"+query_string);
%>
<html>	
<head>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eBL/js/AddModifyPatFinDetails.js'></script>
	<script language='javascript' src='../../eBL/js/BLPatRegBlngDtls.js'></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eBL/js/Hashtable.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>

<script language='javascript'>

function onFormLoad(serv_panel_ind,charge_YN,charge_at_enc_regn_YN,charge_at_renwel)
{
	parent.parent.commontoolbarFrame.document.forms[0].apply.disabled=false;
	parent.parent.commontoolbarFrame.document.forms[0].reset.disabled=false;
	if(serv_panel_ind != null && serv_panel_ind != "")
	{
		if(serv_panel_ind=='S')
		{
			document.forms[0].serv_panel_ind.value = 'S';
		}
		else if(serv_panel_ind=='L')
		{
			document.forms[0].serv_panel_ind.value = 'L';
		}
	}

	if(charge_YN != null && charge_YN != "")
	{
		if(charge_YN == "Y")
		{
			document.forms[0].chargeble_yn.checked= true;
			document.forms[0].charge_non_chargeable_yn.checked= false;
			document.forms[0].charge_non_chargeable_yn.disabled = true;
			//Commented V190401-MuthuKumarN/IN70056 & IN:070057
			//document.forms[0].chargeble_dur_renwel.checked= false;
			//document.forms[0].chargeble_dur_renwel.disabled = true;			
		}
	}

	if(charge_at_enc_regn_YN != null && charge_at_enc_regn_YN != "")
	{
		if(charge_at_enc_regn_YN == "Y")
		{
			document.forms[0].chargeble_yn.checked= false;
			document.forms[0].chargeble_yn.disabled = true;
			document.forms[0].charge_non_chargeable_yn.checked= true;
			//Commented V190401-MuthuKumarN/IN70056 & IN:070057
			//document.forms[0].chargeble_dur_renwel.checked= false;
			//document.forms[0].chargeble_dur_renwel.disabled = true;			
		}
	}
	
	if(charge_at_renwel != null && charge_at_renwel != "")
	{
		if(charge_at_renwel == "Y")
		{
			//Commented V190401-MuthuKumarN/IN70056 & IN:070057
			//document.forms[0].chargeble_yn.checked= false;
			//document.forms[0].charge_non_chargeable_yn.checked= false;
			document.forms[0].chargeble_dur_renwel.checked= true;
			//document.forms[0].chargeble_dur_renwel.disabled = true;//Commented V190401-MuthuKumarN/IN70056 & IN:070057
			//Added V190404-MuthuKumarN/AMRI-CRF-0357.1
			document.getElementById("renewDescLabel").style.visibility='visible';
			document.getElementById("renewDescText").style.visibility='visible';
			//Added V190404-MuthuKumarN/AMRI-CRF-0357.1
		}
	}
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




</head>

<body onLoad="onFormLoad('<%=serv_panel_ind%>','<%=charge_YN%>','<%=charge_at_enc_regn_YN%>','<%=charge_at_renwel%>')" onMouseDown="CodeArrest()" onKeyDown="lockKey()"> 

<form name='PatRegBlngDtlsForm' id='PatRegBlngDtlsForm' action="../../servlet/eBL.BLPatRegBlngDtlsServlet" method="post" target="messageFrame">
	<table border='0' cellpadding='3' cellspacing='3' align='center' width='100%'>
		<tr>
			<td width="25%" class="label"><B><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></B></td>
			<td width="25%" class="fields" colspan='3'><%=facility_desc%><input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">
<!--			<input type='text' name="facility_id" id="facility_id"><input type='button' class='button' name="facilitybut" id="facilitybut" value='?' onClick="">
-->
			</td>
		</tr>

		<tr>
			<td width="25%" class="label"><B><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/></B></td>
			<td width="25%" class="fields" colspan='3'><input type='text' size='40' maxlength='100' name="pat_ser_desc" id="pat_ser_desc" onBlur="pat_series_lkup('B');" tabindex='1' value="<%=pat_ser_grp_desc%>" <%=enable_disable_flag%>><input type='hidden' name='pat_ser_code' id='pat_ser_code' value="<%=pat_ser_grp_code%>"><input type='button' class='button' name="patseriesbut" id="patseriesbut" value='?' onClick="pat_series_lkup('C');" tabindex='2' <%=enable_disable_flag%>><img src='../../eCommon/images/mandatory.gif'></td>
		</tr>

		<tr>
			<td width="25%" class="label"><B><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></B></td>
			<td width="25%" class="fields" colspan='3'><input type='text' size='40' maxlength='40' name="blng_grp_desc" id="blng_grp_desc" onBlur="blng_grp_lkup('B');" tabindex='3' value="<%=blng_grp_desc%>" <%=enable_disable_flag%>><input type='hidden' name='blng_grp_code' id='blng_grp_code' value="<%=blng_grp_id%>"><input type='hidden' name='slmt_ind' id='slmt_ind' value="<%=slmt_ind%>"><input type='hidden' name='adm_rec_flag' id='adm_rec_flag' value=""><input type='button' class='button' name="blnggrpbut" id="blnggrpbut" value='?' onClick="blng_grp_lkup('C');" tabindex='4' <%=enable_disable_flag%>><img src='../../eCommon/images/mandatory.gif'></td>
		</tr>

		<tr>
			<td width="25%" class="label"><B><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></B></td>
			<td width="25%" class="fields"><input type='text' size='40' maxlength='100' name="pyr_grp_desc" id="pyr_grp_desc" onBlur="payer_grp_lkup('B');" tabindex='5' value="<%=payer_grp_desc%>" <%=enable_disable_flag%>><input type='hidden' name='payer_grp_code' id='payer_grp_code' value="<%=payer_grp_code%>"><input type='button' class='button' name="pyrgrpbut" id="pyrgrpbut" value='?' onClick="payer_grp_lkup('C');" tabindex='6' <%=enable_disable_flag%>><img src='../../eCommon/images/mandatory.gif' name='payer_grp_mand_yn' style='visibility:hidden'></td>

			<td width="25%" class="label"><B><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></B></td>
			<td width="25%" class="fields"><input type='text' size='40' maxlength='100' name="payer_desc" id="payer_desc" onBlur="payer_lkup('B');" tabindex='7' value="<%=payer_desc%>" <%=enable_disable_flag%>><input type='hidden' name='payer_code' id='payer_code' value="<%=payer_code%>"><input type='button' class='button' name="payerbut" id="payerbut" value='?' onClick="payer_lkup('C');" tabindex='8' <%=enable_disable_flag%>><img src='../../eCommon/images/mandatory.gif' name='payer_mand_yn' style='visibility:hidden'></td>
		</tr>

		<tr>
			<td width="15%" class="label"><B><fmt:message key="eBL.CHAR_AT_REG.label" bundle="${common_labels}"/></B></td>
			<td width="15%" class="fields"><INPUT TYPE="checkbox" name="chargeble_yn" id="chargeble_yn" tabindex='3' onClick="check_item();"><!--<img src='../../eCommon/images/mandatory.gif'>--></td>
			<td width="15%" class="label"><B><fmt:message key="eBL.CHRG_DUR_ENC.label" bundle="${bl_labels}"/></B></td>
			<td width="15%" class="fields"><INPUT TYPE="checkbox" name="charge_non_chargeable_yn" id="charge_non_chargeable_yn" tabindex='2' onClick="check_item();"></td>
		<!--Added V190305-Gayathri/AMRI-CRF-0357.1 -->	
			<td width="15%" class="label"><B><fmt:message key="eBL.CHRG_DUR_REW.label" bundle="${bl_labels}"/></B></td>
			<td width="15%" class="fields"><INPUT TYPE="checkbox" name="chargeble_dur_renwel" id="chargeble_dur_renwel" tabindex='2' onClick="check_item();"></td>
		</tr>

		<tr>
			<td width="10%" class="label">
			<B>
				<fmt:message key="eBL.BILLING_SERVICE_PANEL.label" bundle="${bl_labels}"/>
			</B>
			</td>
			<td width="10%" class="fields">
				<SELECT name="serv_panel_ind" id="serv_panel_ind" onChange='change_pnl_serv_leg()' tabindex='11'>
					<option value='S'><fmt:message key="Common.service.label" bundle="${common_labels}"/></option>
					<option value='L'><fmt:message key="Common.Panel.label" bundle="${common_labels}"/></option>
				</SELECT>
			</td>
			<td width="20%" class="label">
				<DIV id='serv_leg' style='display:inline'><B><fmt:message key="Common.ServiceDescription.label" bundle="${common_labels}"/></B></DIV>
				<DIV id='panel_leg' style='display:none'><B><fmt:message key="Common.PanelDescription.label" bundle="${common_labels}"/></B></DIV>
			</td>
			<td width="20%" class="fields">
				<input type='text' size='20' maxlength='100' name="serv_panel_desc" id="serv_panel_desc" tabindex='12' onBlur="serv_panel_lkup('B');" value="<%=serv_panel_desc%>">
				<input type='hidden' name='serv_panel_code' id='serv_panel_code' value="<%=serv_panel_code%>">
				<input type='button' class='button' name="servpnlbut" id="servpnlbut" value='?' onClick="serv_panel_lkup('C');" tabindex='13'>
			</td>
			<!--Added V190404-MuthuKN/AMRI-CRF-0357.1 -->			
			<td width="20%" class="label" id="renewDescLabel" name="renewDescLabel" style='visibility:hidden'>
			<B>
			<fmt:message key="eBL.RenewalDescription.label" bundle="${bl_labels}"/>
			</B>
			</td>
			<td width="20%" class="fields" id="renewDescText" name="renewDescText" style='visibility:hidden' nowrap>
				<input type='text' size='20' maxlength='100' name="renewal_desc" id="renewal_desc" tabindex='14' onBlur="renew_desc_lkup('B');" value="<%=renewal_desc%>">
				<input type='hidden' name='renewal_code' id='renewal_code' value="<%=renewal_code%>">
				<input type='button' class='button' name="renewdescbtn" id="renewdescbtn" value='?' onClick="renew_desc_lkup('C');" tabindex='15'>
			</td>			
			<!--Added V190404-MuthuKN/AMRI-CRF-0357.1 -->
		</tr>

	</table>
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
	<input type='hidden' name='facility_id1' id='facility_id1' value='<%=facility_id%>'>
	<input type='hidden' name='pat_ser_grp_code1' id='pat_ser_grp_code1' value='<%=pat_ser_grp_code%>'>
	<input type='hidden' name='blng_grp_id1' id='blng_grp_id1' value='<%=blng_grp_id%>'>
	<input type='hidden' name='cust_group_code1' id='cust_group_code1' value='<%=payer_grp_code%>'>
	<input type='hidden' name='cust_code1' id='cust_code1' value='<%=payer_code%>'>
</form>

</body>

</html>
<%
	}
	catch(Exception ee)
	{
		//out.println("Exception in Details.jsp"+ee);
		ee.printStackTrace();
	}
	finally
	{
		if(pstmt != null)pstmt.close();
		ConnectionManager.returnConnection(con, request);
	}
%>

