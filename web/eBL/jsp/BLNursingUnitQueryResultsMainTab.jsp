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

		nursing_unit_code = request.getParameter("nursing_unit_code");
		if(nursing_unit_code==null) nursing_unit_code="";	
//		System.err.println("nursing_unit_code in MainTab.jsp:"+nursing_unit_code);
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
//		System.err.println("request.getQueryString() in BLNursingUnitQueryResultsMainTab.jsp:"+query_string);
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

function tab_change(obj,cald_for,calling_mode)
{
	var nursing_unit_code = document.forms[0].nursing_unit_code.value;
	if(nursing_unit_code != "")
	{
		var query_string = document.forms[0].query_string.value;
		var params = "",params1="";

		document.getElementById('curr_inp_tab').className = "tabA";
		document.getElementById('CurrInpatients').className = "tabAspan";

		document.getElementById('tod_exp_dischrg_tab').className = "tabA";
		document.getElementById('TodExpDischarges').className = "tabAspan";

		document.getElementById('tod_dischrgd_pat_tab').className = "tabA";
		document.getElementById('TodDischargedPat').className = "tabAspan";

		if(obj.id == 'curr_inp_tab')
		{
			document.getElementById('curr_inp_tab').className = "tabClicked";
			document.getElementById('CurrInpatients').className = "tabSpanclicked";
		}
		else if(obj.id == 'tod_exp_dischrg_tab')
		{
			document.getElementById('tod_exp_dischrg_tab').className = "tabClicked";
			document.getElementById('TodExpDischarges').className = "tabSpanclicked";
		}
		else if(obj.id == 'tod_dischrgd_pat_tab')
		{
			document.getElementById('tod_dischrgd_pat_tab').className = "tabClicked";
			document.getElementById('TodDischargedPat').className = "tabSpanclicked";
		}
		
	// CIP - Current Inpatients
	// TED - Today's Expected Discharges
	// TDP - Today's Discharged Patients
		if(cald_for == 'CIP')
		{
//			alert("Current Inpatients");
			params = query_string+"&called_from=CIP&nursing_unit_code="+nursing_unit_code;
			parent.frames[1].location.href = "../../eBL/jsp/BLNursingUnitQueryResults.jsp?"+params;
			parent.frames[2].location.href = "../../eCommon/jsp/process.jsp";
			params1 = query_string+"&called_for=CIP&nursing_unit_code="+nursing_unit_code;
			if(calling_mode == 'C')
			{
				parent.parent.frames[1].frames[0].location.href = "../../eBL/jsp/BLNursingUnitQueryResultsFinSummaryFrame.jsp?"+params1;
			}
		}
		else if(cald_for == 'TED')
		{
			params = query_string+"&called_from=TED&nursing_unit_code="+nursing_unit_code;
//			alert("Today's Expected Discharges");
			parent.frames[1].location.href = "../../eBL/jsp/BLNursingUnitQueryResults.jsp?"+params;
			parent.frames[2].location.href = "../../eCommon/jsp/process.jsp";
			if(calling_mode == 'C')
			{
				params1 = query_string+"&called_for=TED&nursing_unit_code="+nursing_unit_code;
				parent.parent.frames[1].frames[0].location.href = "../../eBL/jsp/BLNursingUnitQueryResultsFinSummaryFrame.jsp?"+params1;
			}
		}
		else if(cald_for == 'TDP')
		{
			params = query_string+"&called_from=TDP&nursing_unit_code="+nursing_unit_code;
//			alert("Today's Discharged Patients");
			parent.frames[1].location.href = "../../eBL/jsp/BLNursingUnitQueryResults.jsp?"+params;
			parent.frames[2].location.href = "../../eCommon/jsp/process.jsp";
			if(calling_mode == 'C')
			{
				params1 = query_string+"&called_for=TDP&nursing_unit_code="+nursing_unit_code;
				parent.parent.frames[1].frames[0].location.href = "../../eBL/jsp/BLNursingUnitQueryResultsFinSummaryFrame.jsp?"+params1;
			}
		}
	}
}

function load_other_frames()
{
	var query_string = document.forms[0].query_string.value;
	query_string = query_string+"&called_for=CIP";
	parent.parent.frames[1].location.href = "../../eBL/jsp/BLNursingUnitQueryResultsSubFrame.jsp?"+query_string;
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body onLoad="load_other_frames();tab_change(document.getElementById('curr_inp_tab'),'CIP','L');" onMouseDown="CodeArrest()" onKeyDown="lockKey()"> 
<form name='BLNursingUnitQueryForm' id='BLNursingUnitQueryForm' action='' method='post' target=''>
	<TABLE border='0' cellpadding='3' cellspacing='0' align='center' width='100%' id='tab'>
		<tr>
			<td width= "100%" class="white"  id=''>
				<ul id="tablist" class="tablist" style="padding-left:0px">
					<li class="tablistitem" title='<fmt:message key="eBL.CURR_IP.label" bundle="${bl_labels}"/>'>
						<a onclick="tab_change(this,'CIP','C')" class="tabClicked" id="curr_inp_tab" >
							<span class="tabSpanclicked" id="CurrInpatients"><fmt:message key="eBL.CURR_IP.label" bundle="${bl_labels}"/></span>
						</a>
					</li>
					<li class="tablistitem" title='<fmt:message key="eBL.TOD_EXP_DISCHRG.label" bundle="${bl_labels}"/>'>
						<a onclick="tab_change(this,'TED','C')" class="tabA" id="tod_exp_dischrg_tab">
							<span class="tabAspan" id="TodExpDischarges"><fmt:message key="eBL.TOD_EXP_DISCHRG.label" bundle="${bl_labels}"/></span>
						</a>
					</li>
					<li class="tablistitem" title='<fmt:message key="eBL.TOD_DISCHRGD_PAT.label" bundle="${bl_labels}"/>'>
						<a onclick="tab_change(this,'TDP','C')" class="tabA" id="tod_dischrgd_pat_tab">
							<span class="tabAspan" id="TodDischargedPat"><fmt:message key="eBL.TOD_DISCHRGD_PAT.label" bundle="${bl_labels}"/></span>
						</a>
					</li>
				</ul>
			</td>
		</tr>
	</TABLE>
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
	<input type='hidden' name='nursing_unit_code' id='nursing_unit_code' value='<%=nursing_unit_code%>'>	
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

