<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");	
	String facility_id = "";
	String login_user = "";
	String episode_type="";
	String class_type = "", class_code = "", class_desc = "", remarks = "", social_pensioner_id = "";
	String inc_asset_ind = "", ind_inc = "", ind_inc_freq = "", spouse_inc = "", spouse_inc_freq = "", dependent_inc = "";
	String dependent_inc_freq = "", tot_inc_asset = "", no_of_dependants = "", blng_grp_id = "", blng_grp_desc = "";
	String valid_from = "", valid_to = "";
	String family_asset = "", family_inc="";

	int noofdecimal = 2;
	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rs3 = null;

	String locale	= (String)session.getAttribute("LOCALE");

	request.setCharacterEncoding("UTF-8");

	try
	{
		con = ConnectionManager.getConnection(request);
		facility_id = (String)httpSession.getValue("facility_id");
		login_user =  p.getProperty("login_user");
//System.err.println("Inside ClassDtlQry:"+request.getQueryString());

		episode_type = request.getParameter("episode_type");
		if(episode_type == null) episode_type="";

		blng_grp_id = request.getParameter("strBillGrpId");
		if(blng_grp_id == null) blng_grp_id="";

		class_type = request.getParameter("strClassType");
		if(class_type == null) class_type="";

		class_code = request.getParameter("strClassCode");
		if(class_code == null) class_code="";

		remarks = request.getParameter("strFinRemarks");
		if(remarks == null) remarks="";

		social_pensioner_id = request.getParameter("strSocialPensionerId");
		if(social_pensioner_id == null) social_pensioner_id="";

		inc_asset_ind = request.getParameter("strIncAssetInd");
		if(inc_asset_ind == null) inc_asset_ind="";

		ind_inc = request.getParameter("strIndInc");
		if(ind_inc == null) ind_inc="0";

		ind_inc_freq = request.getParameter("strIndIncFreq");
		if(ind_inc_freq == null) ind_inc_freq="";

		spouse_inc = request.getParameter("strSpouseInc");
		if(spouse_inc == null) spouse_inc="0";

		spouse_inc_freq = request.getParameter("strSpouseIncFreq");
		if(spouse_inc_freq == null) spouse_inc_freq="";

		dependent_inc = request.getParameter("strDepInc");
		if(dependent_inc == null) dependent_inc="0";

		dependent_inc_freq = request.getParameter("strDepIncFreq");
		if(dependent_inc_freq == null) dependent_inc_freq="";

		valid_from = request.getParameter("strClassStartDate");
		if(valid_from == null) valid_from="";

		valid_to = request.getParameter("strClassEndDate");
		if(valid_to == null) valid_to="";

		family_asset = request.getParameter("strClassFamAss");
		if(family_asset == null) family_asset="";
		
		family_inc = request.getParameter("strClassFamIn");
		if(family_inc == null) family_inc="";

		no_of_dependants = request.getParameter("strNoDep");
		if(no_of_dependants == null) no_of_dependants="";

		try
		{	
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rs3 = pstmt.executeQuery();	
			while(rs3.next())
			{
				noofdecimal  =  rs3.getInt(1);		
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in Currency Conversion="+e.toString());
		}
		rs3.close();
		pstmt.close();

		String sql = "SELECT SHORT_DESC CLASSIFICATION_DESC FROM BL_CLASSFCTN_CODE_LANG_VW WHERE CLASSIFICATION_CODE = ? AND LANGUAGE_ID = ?";
		try
		{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,class_code);
			pstmt.setString(2,locale);
			rs3 = pstmt.executeQuery();
			if(rs3.next())
			{
				class_desc = rs3.getString("CLASSIFICATION_DESC");
			}
		}
		catch(Exception e)
		{
			System.err.println("Exception from CLASSIFICATION_DESC:"+e );
		}
		finally
		{
			if (pstmt!=null) pstmt.close();
			if (rs3!=null)	 rs3.close();
		}
		if(class_desc == null) class_desc="";

		sql = "SELECT SHORT_DESC BILLING_DESC FROM BL_BLNG_GRP_LANG_VW WHERE BLNG_GRP_ID=? AND LANGUAGE_ID = ?";
		try
		{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,blng_grp_id);
			pstmt.setString(2,locale);
			rs3 = pstmt.executeQuery();
			if(rs3.next())
				blng_grp_desc = rs3.getString("BILLING_DESC");
		}
		catch(Exception e)
		{
			System.err.println("Exception from BILLING_DESC:"+e );
		}
		finally
		{
			if (pstmt!=null) pstmt.close();
			if (rs3!=null)	 rs3.close();
		}
		if(blng_grp_desc == null) blng_grp_desc="";

		if(!valid_from.equals(""))
		{
			valid_from=com.ehis.util.DateUtils.convertDate(valid_from,"DMY","en",locale);
		}

		if(!valid_to.equals(""))
		{
			valid_to=com.ehis.util.DateUtils.convertDate(valid_to,"DMY","en",locale);
		}

		CurrencyFormat cf = new CurrencyFormat();

		ind_inc = cf.formatCurrency(ind_inc, noofdecimal);
		spouse_inc = cf.formatCurrency(spouse_inc, noofdecimal);
		dependent_inc = cf.formatCurrency(dependent_inc, noofdecimal);

		if(inc_asset_ind.equals("I"))
		{
			tot_inc_asset = family_inc;
		}
		else if(inc_asset_ind.equals("A"))
		{
			tot_inc_asset = family_asset;
		}
		else
		{
			tot_inc_asset = "0";
		}
		tot_inc_asset = cf.formatCurrency(tot_inc_asset, noofdecimal);
%>

<html>
<head>
<script>
function assign_values(class_type,inc_asset_ind,ind_inc,ind_inc_freq,spouse_inc,spouse_inc_freq,dependent_inc,dependent_inc_freq)
{
	if(! class_type == "")
	{
		if(class_type == "SG")
		{
			document.getElementById("class_type_data").innerText = getLabel("eBL.SOCIAL_GRANT.label","BL");
		}
		else if(class_type == "PV")
		{
			document.getElementById("class_type_data").innerText = getLabel("Common.Provisional.label","common");
		}
		else if(class_type == "IA")
		{
			document.getElementById("class_type_data").innerText = getLabel("eBL.INCOME_ASSET_BASED.label","BL");
		}
		else if(class_type == "VS")
		{
			document.getElementById("class_type_data").innerText = getLabel("Common.Visitor.label","common");
		}
		else if(class_type == "CR")
		{
			document.getElementById("class_type_data").innerText = getLabel("eBL.CREDIT.label","BL");
		}
		else if(class_type == "SP")
		{
			document.getElementById("class_type_data").innerText = getLabel("eBL.SPONSORED.label","BL");
		}
		else if(class_type == "IN")
		{
			document.getElementById("class_type_data").innerText = getLabel("Common.Insurance.label","common");
		}
		else if(class_type == "EX")
		{
			document.getElementById("class_type_data").innerText = getLabel("eBL.EXEMPTED.label","BL");
		}
		else if(class_type == "SC")
		{
			document.getElementById("class_type_data").innerText = getLabel("eBL.SPECIAL_CASE.label","BL");
		}
	}
	
	if(inc_asset_ind!="")
	{
		if(inc_asset_ind == "I")
		{
			document.getElementById("inc_asset_ind_data").innerText = getLabel("eBL.INCOME.label","BL");
		}
		else if(inc_asset_ind == "A")
		{
			document.getElementById("inc_asset_ind_data").innerText = getLabel("eBL.ASSET.label","BL");
		}
		else
		{
			document.getElementById("inc_asset_ind_data").innerText = "";
		}
	}
	
	if(ind_inc != "" && ind_inc_freq != "")
	{
		if(ind_inc_freq == "W")
		{
			document.getElementById("ind_inc_freq_data").innerText = ind_inc +"("+getLabel("Common.weekly.label","common")+")";
		}
		else if(ind_inc_freq == "M")
		{
			document.getElementById("ind_inc_freq_data").innerText = ind_inc +"("+getLabel("Common.monthly.label","common")+")";
		}
		else if(ind_inc_freq == "Y")
		{
			document.getElementById("ind_inc_freq_data").innerText = ind_inc +"("+getLabel("Common.Yearly.label","common")+")";
		}
		else
		{
			document.getElementById("ind_inc_freq_data").innerText = "";
		}
	}

	if(spouse_inc != "" && spouse_inc_freq != "")
	{
		if(spouse_inc_freq == "W")
		{
			document.getElementById("spouse_inc_freq_data").innerText = spouse_inc +"("+getLabel("Common.weekly.label","common")+")";
		}
		else if(spouse_inc_freq == "M")
		{
			document.getElementById("spouse_inc_freq_data").innerText = spouse_inc +"("+getLabel("Common.monthly.label","common")+")";
		}
		else if(spouse_inc_freq == "Y")
		{
			document.getElementById("spouse_inc_freq_data").innerText = spouse_inc +"("+getLabel("Common.Yearly.label","common")+")";
		}
		else
		{
			document.getElementById("spouse_inc_freq_data").innerText = "";
		}
	}

	if(dependent_inc != "" && dependent_inc_freq != "")
	{
		if(dependent_inc_freq == "W")
		{
			document.getElementById("dependent_inc_freq_data").innerText = dependent_inc +"("+getLabel("Common.weekly.label","common")+")";
		}
		else if(dependent_inc_freq == "M")
		{
			document.getElementById("dependent_inc_freq_data").innerText = dependent_inc +"("+getLabel("Common.monthly.label","common")+")";
		}
		else if(dependent_inc_freq == "Y")
		{
			document.getElementById("dependent_inc_freq_data").innerText = dependent_inc +"("+getLabel("Common.Yearly.label","common")+")";
		}
		else
		{
			document.getElementById("dependent_inc_freq_data").innerText = "";
		}
	}
/*
	if(class_type == "IA" && inc_asset_ind == "I")
	{
		var tot_inc = 0;

		if(ind_inc != "" && ind_inc != 0)
		{
			if(ind_inc_freq == "M")
				tot_inc = tot_inc +  parseInt(ind_inc)*12;
			else if(ind_inc_freq == "W")
				tot_inc = tot_inc +  parseInt(ind_inc)*52;
			else if (ind_inc_freq == "Y")
				tot_inc = tot_inc +  parseInt(ind_inc);
			else
				tot_inc = "";
		}
		else
		{
			document.forms[0].ind_inc_freq.value="";
			document.forms[0].tot_inc_asset_hidden.value ="";
		}

		if(spouse_inc != "" && spouse_inc != 0)
		{
			if(spouse_inc_freq == "M")
				tot_inc = tot_inc +  parseInt(spouse_inc)*12;
			else if(spouse_inc_freq == "W")
				tot_inc = tot_inc +  parseInt(spouse_inc)*52;
			else if (spouse_inc_freq == "Y")
				tot_inc = tot_inc +  parseInt(spouse_inc);
			else
				tot_inc = "";
		}
		else
		{
			document.forms[0].spouse_inc_freq.value="";
			document.forms[0].tot_inc_asset_hidden.value ="";
		}

		if(dependent_inc != "" && dependent_inc != 0)
		{
			if(dependent_inc_freq == "M")
				tot_inc = tot_inc +  parseInt(dependent_inc)*12;
			else if(dependent_inc_freq == "W")
				tot_inc = tot_inc +  parseInt(dependent_inc)*52;
			else if (dependent_inc_freq == "Y")
				tot_inc = tot_inc +  parseInt(dependent_inc);
			else
				tot_inc = "";
		}
		else
		{
			document.forms[0].dependent_inc_freq.value="";
			document.forms[0].tot_inc_asset_hidden.value ="";
		}

		document.getElementById("tot_inc_asset").innerText = tot_inc;
		document.forms[0].tot_inc_asset_hidden.value = tot_inc;
		put_decimal(document.forms[0].tot_inc_asset_hidden,document.forms[0].noofdecimal.value);
		document.getElementById("tot_inc_asset").innerText = document.forms[0].tot_inc_asset_hidden.value;
	}
*/
}
</script>


	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src='../js/AddModifyPatFinDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="assign_values('<%=class_type%>','<%=inc_asset_ind%>','<%=ind_inc%>','<%=ind_inc_freq%>','<%=spouse_inc%>','<%=spouse_inc_freq%>','<%=dependent_inc%>','<%=dependent_inc_freq%>')">
	<form name='frmFinClsDetails' id='frmFinClsDetails'>
		<table border='0' cellpadding='6' cellspacing='3' align='center' width='100%'>

			<tr>
				<td class='label' width='25%'><fmt:message key="eBL.CLASS_TYPE.label" bundle="${bl_labels}"/></td>
				<td class='data' width='25%' id='class_type_data'></td>
				<td class='label' width='25%'><fmt:message key="eBL.CLASS_CODE.label" bundle="${bl_labels}"/></td>
				<td class='data' width='25%'><%=class_desc%></td>
			</tr>

			<tr>
				<td class='label' width='25%'><fmt:message key="eBL.SOCIAL_PENSIONER_ID.label" bundle="${bl_labels}"/></td>
				<td class='data' width='25%'><%=social_pensioner_id%></td>

				<td class='label' width='25%'><fmt:message key="eBL.INCOME_ASSET_BASED.label" bundle="${bl_labels}"/></td>
				<td class='data' width='25%' id='inc_asset_ind_data'></td>
			</tr>

			<tr>
				<td class='label' width='25%'><fmt:message key="eBL.INDVL_INC_FREQ.label" bundle="${bl_labels}"/></td>
				<td class='data' width='25%' id='ind_inc_freq_data'></td>

				<td class='label' width='25%'><fmt:message key="eBL.SPOUSE_INC_FREQ.label" bundle="${bl_labels}"/></td>
				<td class='data' width='25%' id='spouse_inc_freq_data'></td>
			</tr>

			<tr>
				<td class='label' width='25%'><fmt:message key="eBL.DEP_INC_FREQ.label" bundle="${bl_labels}"/></td>
				<td class='data' width='25%' id='dependent_inc_freq_data'></td>

				<td class='label' width='25%'><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eBL.INCOME_ASSET.label" bundle="${bl_labels}"/></td>
				<td class='data' width='25%' id='tot_inc_asset'><%=tot_inc_asset%></td>
			</tr>

			<tr>
				<td class='label' width='25%'><fmt:message key="eBL.NO_OF_DEPENDANTS.label" bundle="${bl_labels}"/></td>
				<td class='data' width='25%'><%=no_of_dependants%></td>
				<td class='label' width='25%'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
				<td class='data' width='25%'><%=blng_grp_desc%></td>
			</tr>

			<tr>
				<td class='label' width='25%'><fmt:message key="eBL.VALID_FROM.label" bundle="${bl_labels}"/></td>
				<td class='data' width='25%'><%=valid_from%></td>
				<td class='label' width='25%'><fmt:message key="eBL.VALID_TO.label" bundle="${bl_labels}"/></td>
				<td class='data' width='25%'><%=valid_to%></td>
			</tr>
<%
		if(episode_type.equals("R"))
		{
%>
			<tr>
				<td class='label' width='25%'><fmt:message key="eBL.FINANCIAL_REMARKS.label" bundle="${bl_labels}"/></td>
				<td class='data' width='25%'><%=remarks%></td>
			</tr>
<%
		}
%>
		</table>
		<input type='hidden' name='class_code' id='class_code' value='<%=class_code%>'>
		<input type='hidden' name='blng_grp_id' id='blng_grp_id' value= '<%=blng_grp_id%>'>
		<input type='hidden' name='noofdecimal' id='noofdecimal' value='<%=noofdecimal%>' \>
		<input type='hidden' name='tot_inc_asset_hidden' id='tot_inc_asset_hidden' value='<%=tot_inc_asset%>' \>
		
	</form>
</body>
<%
	}
	catch(Exception eX)
	{
		System.out.println("Error in Qry1.jsp= "+eX);
	}
	finally
	{
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}
%>
</html>

