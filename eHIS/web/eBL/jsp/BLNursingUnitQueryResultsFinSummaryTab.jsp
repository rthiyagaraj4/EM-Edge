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

	String nursing_unit_code="";

	try
	{
		con = ConnectionManager.getConnection(request);

		request.setCharacterEncoding("UTF-8");
		HttpSession httpSession = request.getSession(false);
//		Properties p  = (Properties)httpSession.getValue("jdbc");	
		String facility_id = (String)httpSession.getValue("facility_id");
//		String strLoggedUser = p.getProperty("login_user");

//		java.util.Locale loc = new java.util.Locale(locale);

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
			out.println("Exception @ sysdate"+e);
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
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eBL/js/BLNursingUnitBillingDetails.js"></script>

<script language='javascript'>

function tab_change(obj,cald_for)
{
	var nursing_unit_code = document.forms[0].nursing_unit_code.value;
	var query_string = document.forms[0].query_string.value;
	var params = "";

	document.getElementById('fin_summ_bg_tab').className = "tabA";
	document.getElementById('FinSumBG').className = "tabAspan";

	document.getElementById('fin_summ_pyr_tab').className = "tabA";
	document.getElementById('FinSumPayer').className = "tabAspan";

	if(obj.id == 'fin_summ_bg_tab')
	{
		document.getElementById('fin_summ_bg_tab').className = "tabClicked";
		document.getElementById('FinSumBG').className = "tabSpanclicked";
	}
	else if(obj.id == 'fin_summ_pyr_tab')
	{
		document.getElementById('fin_summ_pyr_tab').className = "tabClicked";
		document.getElementById('FinSumPayer').className = "tabSpanclicked";
	}
	
// FSB - Financial Summary by Billing Group
// FSP - Financial Summary by Payer

	if(cald_for == 'FSB')
	{
//		alert("Financial Summary by Billing Group");
		params = query_string+"&called_from=FSB&nursing_unit_code="+nursing_unit_code;
		parent.BLNursingUnitQueryResultsFinSummaryBody.location.href = "../../eBL/jsp/BLNursingUnitQueryResultsFinSummaryBody.jsp?"+params;
		parent.frames[2].location.href = "../../eCommon/jsp/process.jsp";
	}
	else if(cald_for == 'FSP')
	{
//		alert("Financial Summary by Payer");
		params = query_string+"&called_from=FSP&nursing_unit_code="+nursing_unit_code;
		parent.BLNursingUnitQueryResultsFinSummaryBody.location.href = "../../eBL/jsp/BLNursingUnitQueryResultsFinSummaryBody.jsp?"+params;
		parent.frames[2].location.href = "../../eCommon/jsp/process.jsp";
	}
}

function onload_click()
{
	tab_change(document.getElementById('fin_summ_bg_tab'),'FSB');
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




</head>

<body onLoad="onload_click();" onMouseDown="CodeArrest()" onKeyDown="lockKey()"> 

<form name='BLNursingUnitBlngDtlsForm' id='BLNursingUnitBlngDtlsForm' action="" method="post" target="">
	<TABLE border='0' cellpadding='3' cellspacing='0' align='center' width='100%' id='tab'>
		<tr>
			<td width= "100%" class="white">
				<ul id="tablist" class="tablist" >
					<li class="tablistitem" title='<fmt:message key="eBL.FIN_SUMM_BY_BG.label" bundle="${bl_labels}"/>'>
						<a onclick="tab_change(this,'FSB')" class="tabClicked" id="fin_summ_bg_tab" >
							<span class="tabSpanclicked" id="FinSumBG"><fmt:message key="eBL.FIN_SUMM_BY_BG.label" bundle="${bl_labels}"/></span>
						</a>
					</li>
					<li class="tablistitem" title='<fmt:message key="eBL.FIN_SUMM_BY_PYR.label" bundle="${bl_labels}"/>'>
						<a onclick="tab_change(this,'FSP')" class="tabA" id="fin_summ_pyr_tab">
							<span class="tabAspan" id="FinSumPayer"><fmt:message key="eBL.FIN_SUMM_BY_PYR.label" bundle="${bl_labels}"/></span>
						</a>
					</li>
				</ul>
			</td>
		</tr>
	</TABLE>
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
	<input type='hidden' name='nursing_unit_code' id='nursing_unit_code' value="<%=nursing_unit_code%>">
	<input type='hidden' name='query_string' id='query_string' value='<%=query_string%>'>
</form>

</body>

</html>
<%
	}
	catch(Exception ee)
	{
		out.println("Exception in Details.jsp"+ee);
	}
	finally
	{
		if(pstmt != null)pstmt.close();
		ConnectionManager.returnConnection(con, request);
	}
%>

