
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%	
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");	
	String facility_id = "";
	String login_user = "";
	String strCashCounterCode = "";
	String strCashCounterArray = "";
	String strLogoutTime  = "";
	String called_frm="", win_close_for_disc_call="N";
	Connection con = null;
	String locale	= (String)session.getAttribute("LOCALE");
//	System.out.println("cash counter");
	try
	{
		facility_id = (String)httpSession.getValue("facility_id");
		login_user =  p.getProperty("login_user");	
		
		called_frm = request.getParameter("called_frm");
		if(called_frm == null) called_frm="";

		win_close_for_disc_call = request.getParameter("win_close_for_disc_call");
		if(win_close_for_disc_call == null) win_close_for_disc_call="N";
	}
	catch(Exception eX)
	{
			out.println("Error= "+eX);
	}


%>

<html>
<head>
<script>
   //setInterval("datefun()",1000);
	function datefun()
	{
		/*var now = new Date();
		var date= now.getDate()+"/"+now.getMonth()+"/"+now.getYear();
		var time=now.getHours()+":"+now.getMinutes()+":"+now.getSeconds();
		var date_time=date+" "+time;
		//setInterval("datefun()",1000);
		//document.menu_form.current_time.value=date_time;*/

		alert(document.getElementById('locale').value);
		var locale=document.getElementById('locale').value;	
		alert("52"+locale)
		var dat1=getCurrentDate('DMYHMS',locale);		
		document.forms[0].logout_time.value=dat1;
		}
 
	 
	function funHeader()
	{
	//parent.detail_frame.document.forms[0].submit();			
		parent.header_frame.location.href ='../../eBL/jsp/BLLogoutSlmtHeader.jsp';
	}
	


function funCashcounter()
{
	//funHeader();

	var locale=document.forms[0].locale.value;		
		var arr = new Array();
		var codeArray = new Array();
		var cashcounter_array_value = document.forms[0].cashcounter_array.value;		
		var called_frm = document.forms[0].called_frm.value;
		var code = '';
		var time = '';
		var selected_cashcounter = document.forms[0].cashcounter.value;
		if ((selected_cashcounter == null) || (selected_cashcounter == '') ||(selected_cashcounter == ' '))
		{
			parent.detail_frame.location.href="../../eBL/jsp/BLLogoutSettlements.jsp?called_frm="+called_frm;
			return(false);
		}
		arr = cashcounter_array_value.split("|");
		var indx = arr.length;
		var val = document.forms[0].cashcounter.value;
		
		for (i=0;i<indx;i++)
		{			
			codeArray = arr[i].split('-');
			code = codeArray[0];
			if ( (code==null) || (code =='')||(code==' ')) break;
			time = codeArray[1];
			if (code == selected_cashcounter)
			{				
				//document.forms[0].login_time.value =  time;
				document.forms[0].login_time.value =  convertDate(time,"DMYHMS","en",locale);
			}
		}
		
		document.forms[0].logout_time.value = document.forms[0].v_logout_time.value;
		document.forms[0].submit();
		try
		{
			parent.report_frame.document.forms[0].close_button.disabled = false;
		}
		catch(e){}
}	


function win_cl_for_disc_fun_call()
{
	var win_close_for_disc_call = document.forms[0].win_close_for_disc_call.value;
	
	if(win_close_for_disc_call == "Y")
	{
		window.returnValue="SUCCESS";
		window.close();
	}
}


</script>


<!--
<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'>
-->
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




	<body  onLoad='win_cl_for_disc_fun_call()'>
		<form name='logout_forms' id='logout_forms' action='BLLogoutSettlements.jsp' target='detail_frame' method='post'>
	<!--<form name='logout_forms' id='logout_forms' action='BLLogoutSlmtTitle.jsp' target='detail_frame' method='post'>-->

		<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
		<td class="COLUMNHEADER" colspan="15"><fmt:message key="eBL.CASH_COUNTER_LOGOUT.label" bundle="${bl_labels}"/></td>
		<tr>
			<td  width='25%' class='label'><b><fmt:message key="eBL.CASH_COUNTER.label" bundle="${bl_labels}"/></b></td>
			
			<td  width='25%' class='label'><b><fmt:message key="eBL.IN_USE_BY.label" bundle="${bl_labels}"/></b></td>
			<td  width='25%' class='label'> <b><fmt:message key="eBL.LOGIN_DATE_TIME.label" bundle="${bl_labels}"/></b> </td>
			<td  width='25%' class='label'> <b><fmt:message key="eBL.CLOSING_DATE_TIME.label" bundle="${bl_labels}"/></b> </td>

		</tr>	
		
		<tr>
		<td width="25%" class='fields' >
			<select name='cashcounter' id='cashcounter' id='cashcounter' onchange='funCashcounter()' >
			<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<%
			try
			{
				//Connection 
				con = ConnectionManager.getConnection(request);
				try
				{
					String sql1 = "	SELECT  SHORT_DESC, CASH_COUNTER_CODE,to_char(LOGIN_DATE_TIME,'dd/mm/yyyy hh24:mi:ss'), "+
					" to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') "+
					" FROM    BL_CASH_COUNTER_LANG_VW "+
					" WHERE  CASH_CTR_IN_USE_BY = ? "+
					" AND    OPERATING_FACILITY_ID   = ? "+
					" AND language_id='"+locale+"' ORDER BY 1 ";


					PreparedStatement pstmt = con.prepareStatement(sql1);
					pstmt.setString(2, facility_id);
					pstmt.setString(1, login_user);
					ResultSet rs = pstmt.executeQuery() ;
					while(rs.next())
					{
						strCashCounterCode = rs.getString(2);
						strCashCounterArray = strCashCounterArray+strCashCounterCode+"-"+rs.getString(3)+"|";
						strLogoutTime = rs.getString(4);
						out.println("<option value='"+strCashCounterCode+"'>"+rs.getString(1));

					}
					rs.close();
					pstmt.close();
				}
				catch(Exception e)
				{
					//out.println("Error = "+e);
					e.printStackTrace();
				}
				// commented in Bangalore on 13/10/2005
				//ConnectionManager.returnConnection(con, request);
				
			}
			catch(Exception exp)
			{
				//out.println("Error = "+exp);
				exp.printStackTrace();
			}
		
			finally{ //Added in Bangalore on 13/10/2005
				if(con!=null) {
					ConnectionManager.returnConnection(con, request);
				}
			}
				
			%>
			</select>

			</td>
			<td width="25%" class="fields"><input type='text' name='In_Use_By' id='In_Use_By' id='In_Use_By'  value='<%=login_user%>' readonly ></td> 
		<td width="25%" class="fields"><input type='text' name='login_time' id='login_time' id='login_time' size='18' maxlength='30' value='' readonly></td>
		<td width="25%" class="fields"> <input type='text' name='logout_time' id='logout_time' id='logout_time' size='18' maxlength='30' value='' readonly></td>

		</tr>
	</table>
		<input type='hidden' name='cashcounter_array' id='cashcounter_array' value='<%=strCashCounterArray%>'>
		<input type='hidden' name='v_logout_time' id='v_logout_time' value='<%=com.ehis.util.DateUtils.convertDate(strLogoutTime,"DMYHMS","en",locale)%>'>
		<input type='hidden' name="locale" id="locale"  value='<%=locale%>'>
		<input type='hidden' name="called_frm" id="called_frm"  value='<%=called_frm%>'>
		<input type='hidden' name="win_close_for_disc_call" id="win_close_for_disc_call"  value='<%=win_close_for_disc_call%>'>
</form>
</body>

</html>

