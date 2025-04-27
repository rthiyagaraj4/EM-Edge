
<%@  page import="java.sql.*,  webbeans.eBL.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	Connection con = null;
	PreparedStatement pstmt = null ;
	Statement stmt				= null;
	ResultSet rs = null;

	String locale = (String)session.getAttribute("LOCALE");
	int noofdecimal=2;
	String dflt_nursing_unit_code="", dflt_nursing_unit_desc="", dflt_forecast_days="";
	String sys_date="";
	String sys_date_wht_sec=""; // System time without seconds

	String nursing_unit_code="", nursing_unit_desc="";

	try
	{
		con = ConnectionManager.getConnection(request);

		request.setCharacterEncoding("UTF-8");
		HttpSession httpSession = request.getSession(false);
//		Properties p  = (Properties)httpSession.getValue("jdbc");	
		String facility_id = (String)httpSession.getValue("facility_id");
		
		String	logged_user	=  (String) session.getValue("login_user");	
		if (logged_user==null) logged_user = "";
//		System.err.println("logged_user in query.jsp:" +logged_user);

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
		
		try
		{	
			String dflt_nusr_qry ="SELECT nursing_unit_code Code , short_desc Description,NVL(DFLT_FORECAST_DAYS,'15')  DFLT_FORECAST_DAYS from BL_VW_FIN_NURS_UNIT_BY_USER_VW where LANGUAGE_ID='"+locale+"' and facility_id='"+facility_id+"' and user_id='"+logged_user+"' and DEFAULT_YN='Y'";

//			System.err.println("dflt_nusr_qry:"+dflt_nusr_qry);
			pstmt = con.prepareStatement(dflt_nusr_qry);
			rs = pstmt.executeQuery();	
			while(rs.next())
			{
				dflt_nursing_unit_code =  rs.getString(1);	
				dflt_nursing_unit_desc =  rs.getString(2);	 
				dflt_forecast_days	   =  rs.getString(3);	 
			}	
			if(rs!=null) rs.close();
			pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in dflt nursing fetch Query="+e.toString());
		}
		if(dflt_nursing_unit_code == null) dflt_nursing_unit_code="";
		if(dflt_nursing_unit_desc == null) dflt_nursing_unit_desc="";
		if(dflt_forecast_days == null) dflt_forecast_days="";
		
//		System.err.println("dflt_nursing_unit_code:"+dflt_nursing_unit_code);
//		System.err.println("dflt_nursing_unit_desc:"+dflt_nursing_unit_desc);
//		System.err.println("dflt_forecast_days:"+dflt_forecast_days);

		if(!dflt_nursing_unit_code.equals(""))
		{
			nursing_unit_code=dflt_nursing_unit_code;
			nursing_unit_desc=dflt_nursing_unit_desc;
		}

		String query_string=request.getQueryString();
//		System.err.println("request.getQueryString() in BLNursingUnitQuery.jsp:"+query_string);
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

function load_nurs_unit_dtls()
{
	var nursing_unit_code = document.forms[0].nursing_unit_code.value;
	var dflt_forecast_days = document.forms[0].dflt_forecast_days.value;

	if(nursing_unit_code != "")
	{
		bed_occupancy(nursing_unit_code);

		parent.frames[1].location.href = '../../eBL/jsp/BLNursingUnitQueryResultsFrame.jsp?nursing_unit_code='+nursing_unit_code+"&exp_dischrg="+document.forms[0].expect_discharge.value+"&dflt_forecast_days="+dflt_forecast_days;
	}
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




</head>

<%
	if(!dflt_nursing_unit_code.equals(""))
	{
%>
<body onLoad="load_nurs_unit_dtls();" onMouseDown="CodeArrest()" onKeyDown="lockKey()"> 
<%
	}
	else
	{
%>
<body onLoad="" onMouseDown="CodeArrest()" onKeyDown="lockKey()"> 
<%
	}
%>
<body onLoad="" onMouseDown="CodeArrest()" onKeyDown="lockKey()"> 

<form name='BLNursingUnitQueryForm' id='BLNursingUnitQueryForm' action="" method="post" target="">
	<table border='0' cellpadding='3' cellspacing='3' align='center' width='100%'>
		<tr>
			<td width="25%" class="label" nowrap>&nbsp;</td>
			<td width="25%" class="label" nowrap><B><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></B></td>
			<td width="25%" class="fields" nowrap><input type='text' size='40' maxlength='30' name="nursing_unit_desc" id="nursing_unit_desc" onBlur="nursing_unit_lkup('B');" tabindex='1' value="<%=nursing_unit_desc%>"><input type='hidden' name='nursing_unit_code' id='nursing_unit_code' value="<%=nursing_unit_code%>"><input type='button' class='button' name="nursingunitbtn" id="nursingunitbtn" value='?' onClick="nursing_unit_lkup('C');" tabindex='2'><img src='../../eCommon/images/mandatory.gif'></td>
			<td width="25%" class="label" nowrap>&nbsp;</td>
		</tr>
	</table>
	<table border='0' cellpadding='3' cellspacing='3' align='center' width='100%'>
		<tr>
			<td width="12.5%" class="label" nowrap><B><fmt:message key="Common.available.label" bundle="${common_labels}"/> <fmt:message key="Common.Bed.label" bundle="${common_labels}"/></B></td>
			<td width="12.5%" class="fields" nowrap><input type='text' size='8' maxlength='100' name="available_beds" id="available_beds" tabindex='2' value="" READONLY style='text-align:right'></td>
			<td width="12.5%" class="label" nowrap><B><fmt:message key="eIP.BedsOccupied.label" bundle="${ip_labels}"/></B></td>
			<td width="12.5%" class="fields" nowrap><input type='text' size='8' maxlength='100' name="occupied_beds" id="occupied_beds" tabindex='3' value="" READONLY style='text-align:right'></td>
			<td width="12.5%" class="label" nowrap><B><fmt:message key="eIP.ExpectedDischarge.label" bundle="${ip_labels}"/></B></td>
			<td width="12.5%" class="fields" nowrap><input type='text' size='8' maxlength='100' name="expect_discharge" id="expect_discharge" tabindex='4' value="" READONLY style='text-align:right'></td>
			<td width="12.5%" class="label" nowrap><B><fmt:message key="Common.discharged.label" bundle="${common_labels}"/></B></td>
			<td width="12.5%" class="fields" nowrap><input type='text' size='8' maxlength='100' name="discharged_pat" id="discharged_pat" tabindex='5' value="" READONLY style='text-align:right'></td>
		</tr>
	</table>

	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
	<input type='hidden' name='logged_user' id='logged_user' value='<%=logged_user%>'>
	<input type='hidden' name='dflt_forecast_days' id='dflt_forecast_days' value='<%=dflt_forecast_days%>'>
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

