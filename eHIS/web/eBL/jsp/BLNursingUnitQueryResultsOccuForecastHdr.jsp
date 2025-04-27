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

		String dflt_forecast_days = request.getParameter("dflt_forecast_days");
		if(dflt_forecast_days == null) dflt_forecast_days="15";

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
function forecast_search(no_of_days)
{
	if(no_of_days.value != "")
	{
		if(validate_entry(no_of_days))
		{
			var query_string =document.forms[0].query_string.value;
			var params = query_string+"&no_of_days="+no_of_days.value;
			parent.frames[1].location.href = '../../eBL/jsp/BLNursingUnitQueryResultsOccuForecastBody.jsp?'+params; 
			parent.frames[2].location.href = "../../eCommon/jsp/process.jsp";
		}
	}
	else
	{
		var mess = getMessage("CAN_NOT_BE_BLANK","common");
		mess = mess.replace("$","'"+getLabel("eBL.NO_OF_DAYS_OCCU_FORECAST.label","BL")+"'");
		alert(mess);
	}
}

function validate_entry(forecast_days)
{
	if(forecast_days.value != "")
	{
		if(CheckForChar_withoutMinusSign(forecast_days))
		{
			if(eval(forecast_days.value) > 365)
			{
				alert(getMessage("BL6432","BL"));
				forecast_days.select();
				parent.frames[1].location.href = '../../eCommon/html/blank.html';
				return false;
			}
			else if(eval(forecast_days.value) <= 0)
			{
				alert(getMessage("CANNOT_BE_ZERO","common"));
				forecast_days.select();
				return false;
			}
			return true;
		}
		else
		{
			return false;
		}
	}
	else
	{
		parent.frames[1].location.href = '../../eCommon/html/blank.html';
	}
}

function CheckForChar_withoutMinusSign(Obj)
{
	var check_var = Obj.value;

	numList = '1234567890';
	
	for (i=0;i<check_var.length;i++)
	{
		if (numList.indexOf(check_var.charAt(i)) == -1) 
		{
			alert(getMessage("CANNOT_BE_SPECIAL_CHAR",'Common'));
			Obj.select();
			return false;  
		}
	}
	return true;
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




</head>

<body onLoad="forecast_search(document.forms[0].forecast_days);" onMouseDown="CodeArrest()" onKeyDown="lockKey()"> 

<form name='BLNursingUnitBlngDtlsForm' id='BLNursingUnitBlngDtlsForm' action="" method="post" target="">
	<TABLE border='0' cellpadding='3' cellspacing='0' align='center' width='100%' id='tab'>
		<tr>
			<td width="80%" class="label"><B><fmt:message key="eBL.NO_OF_DAYS_OCCU_FORECAST.label" bundle="${bl_labels}"/></B></td>
			<td width="10%" class="fields" ><input type='text' size='4' maxlength='4' name="forecast_days" id="forecast_days" tabindex='1' value='<%=dflt_forecast_days%>' style='text-align:right' onKeyPress='return(ChkNumberInput(this,event,0));' onBlur='validate_entry(this);'></td>	
			<td width="10%" class="button"><div align='left'><input type='button' class='button' name='go_button' id='go_button'  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Go.label","common_labels")%>"  onClick='forecast_search(document.forms[0].forecast_days);' tabindex='2'></div>
			</td>			
		</tr>
	</TABLE>
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
	<input type='hidden' name='nursing_unit_code' id='nursing_unit_code' value="<%=nursing_unit_code%>">
	<input type='hidden' name='query_string' id='query_string' value='<%=query_string%>'>
	<input type='hidden' name='noofdecimal' id='noofdecimal' value='<%=noofdecimal%>'>
</form>

</body>

</html>
<%
	session.removeAttribute("curr_inp_cnt");
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

