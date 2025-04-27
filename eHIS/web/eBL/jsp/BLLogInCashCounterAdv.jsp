<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>


<%
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");	
	String facility_id = "";
	String login_user = "";
	String strCashCounterArray = "";
	String strCashCounterCode = "";
	String op_ip_rf_ctr = "N";
	String op_ctr  = "N";
	String ip_ctr  = "N";
	String rf_ctr   = "N";
	String date_time="";
	String refresh_flag="";
	String called_frm = "";
	Connection con = null;
	con = ConnectionManager.getConnection(request);
	Statement stmt=con.createStatement();
	
	
	String locale	= (String)session.getAttribute("LOCALE");

	try
	{
		facility_id = (String)httpSession.getValue("facility_id");
		login_user =  p.getProperty("login_user");

		refresh_flag=request.getParameter("refresh_flag");
		if(refresh_flag==null) refresh_flag="";

		called_frm = request.getParameter("called_frm");
		if(called_frm==null) called_frm="";

	
	String str=("select to_char(sysdate,'dd/mm/yyyy hh24:mi') from dual");
	ResultSet rs1=stmt.executeQuery(str);
	while(rs1.next())
		date_time=rs1.getString(1);

	if(rs1 != null) rs1.close();
	stmt.close();
	
%>


<% String sStyle =		    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript' src='../js/BLAmount.js'></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>



<script>
//setTimeOut('datefun()',30);
setInterval("datefun()",500);
function datefun()
{
	/*var now = new Date();	
	var date= now.getDate()+"/"+now.getMonth()+"/"+now.getYear();
	var time=now.getHours()+":"+now.getMinutes()+":"+now.getSeconds();
	var date_time=date+" "+time;
	//document.menu_form.current_time.value=date_time;*/	
	var locale=document.getElementById('locale').value;	
	var dat1=getCurrentDate('DMYHMS' ,locale);	
	document.menu_form.current_time.value=dat1;
	

	
}

function home()
{
	try
	{
		document.menu_form.Login.disabled = true;
	}
	catch(e){}
}
function view()
{
	var jsp_name = "../jsp/BLLogInCashCounterQuery.jsp";
	var dialogHeight= "36" ;//26
	var dialogWidth	= "30" ;//42
	var status = "no";
	
	var title = getLabel("eBL.CASH_COUNTER_IN_USAGE_LIST.label","BL");
	var arguments	= "title="+title ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	window.showModalDialog(jsp_name,arguments,features);

}
function login()
{
	var cashcounter = document.forms[0].cashcounter.value;
	var loin = getMessage('BL9326','BL');
	document.forms[0].loin.value=loin;	
	if ((cashcounter == null) || (cashcounter == '') ||(cashcounter == ' '))
	{
		return(false);
	}
		
	document.forms[0].submit();
	
	parent.frames[1].location.href ='../../eBL/jsp/BLLogInCashCounterAdv.jsp';
	parent.frames[2].location.href ='../../eBL/jsp/BLLogInCashCounterQuery.jsp';
}

function funCashcounter()
{

		var arr = new Array();
		var codeArray = new Array();
		var appArray = new Array();
		var cashcounter_array = document.forms[0].cashcounter_array.value;
		
		var code = '';
		arr = cashcounter_array.split("|");
		var indx = arr.length;
		var val = document.forms[0].cashcounter.value;

		for (i=0;i<indx;i++)
		{
			
			if (arr[i] != null)
			{

				codeArray = arr[i].split('-');
			}
			if (codeArray[1] != null)
			{
				appArray =  codeArray[1].split(';');
			}

			code = codeArray[0];
			op_ctr = appArray[0];
			ip_ctr = appArray[1];
			rf_ctr = appArray[2];

			if(!(document.menu_form.cashcounter.value==""))
			{		
				if(code == val)
				{
					if (op_ctr == 'Y')
						document.forms[0].op_ctr.checked = true;
					else
						document.forms[0].op_ctr.checked = false;
					if (ip_ctr == 'Y')
						document.forms[0].ip_ctr.checked = true;
					else
						document.forms[0].ip_ctr.checked = false;

					if (rf_ctr == 'Y')
						document.forms[0].rf_ctr.checked = true;
					else
						document.forms[0].rf_ctr.checked = false;
				}
			}
			else
			{
				document.forms[0].op_ctr.checked = false;
				document.forms[0].ip_ctr.checked = false;
				document.forms[0].rf_ctr.checked = false;
			}
		}
			

		var cccode=document.forms[0].cashcounter.value;
		
		if(cccode!="")
		{

			parent.frames[2].location.href ='../../eBL/jsp/BLLogInCashCounterValidation.jsp?facility_id=<%=facility_id%>&login_user=<%=login_user%>&strCashCounterCode='+cccode;
		}
		else
		{
			document.forms[0].shift_started_at.value="";
			document.forms[0].opening_balance.value="";
		}
	
}	
function funCheckNumber()
{
	if (isNaN(document.forms[0].opening_balance.value))
	{
		document.forms[0].opening_balance.focus();
		return false;
	}
	currencyFormat(document.forms[0].opening_balance);
	return(true);
}


</script>
<!--
<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'>
-->
	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eBL/js/AddModifyPatFinDetails.js"></script>
	<script language='javascript' src="../../eBL/js/BLCashCounterLogin.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect = "codeArrestThruSelect();" onLoad="datefun();">
		<form name='menu_form' id='menu_form'  method='post' target='dummyFrame' >
			<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
<!--			<tr>
					<td width='30%'></td>
					<td width='25%'></td>
					<td width='15%'></td>
					<td width='30%'></td>
				</tr>
-->
				<td class="COLUMNHEADER" colspan="15"><fmt:message key="eBL.CASH_COUNTER_LOGIN.label" bundle="${bl_labels}"/></td>
				 <tr>
    				     <td width="50%" class='label' ><fmt:message key="eBL.CASH_COUNTER.label" bundle="${bl_labels}"/></td>
    				     <td width="50%" class='fields' ><select name='cashcounter' id='cashcounter' onchange='funCashcounter();' >
							<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
			<%
			try
			{
				//Connection 

//				if(!refresh_flag.equals("Y"))
//				{
				try
				{
					CallableStatement call = con.prepareCall("{ call bl_cash_counter_check.get_cash_counter_details(?,?,?,?,?,?) }");	
					call.setString(1,login_user);
					call.setString(2,facility_id);
					call.registerOutParameter(3,java.sql.Types.VARCHAR); // _hcard_scheme_id out varchar2,
					call.registerOutParameter(4,java.sql.Types.VARCHAR); // _hcare_scheme_id out varchar2,
					call.registerOutParameter(5,java.sql.Types.VARCHAR); // _hcard_scheme_id out varchar2,
					call.registerOutParameter(6,java.sql.Types.VARCHAR); 
					call.execute();

					op_ip_rf_ctr = call.getString(3);    
					op_ctr = call.getString(4);          
					ip_ctr = call.getString(5);          
					rf_ctr = call.getString(6);   
					call.close();

					if(op_ip_rf_ctr==null) op_ip_rf_ctr="";
					if(op_ctr==null) op_ctr="";
					if(ip_ctr==null) ip_ctr="";
					if(rf_ctr==null) rf_ctr="";

//					System.out.println("op_ip_rf_ctr:"+op_ip_rf_ctr);
//					System.out.println("op_ctr:"+op_ctr);
//					System.out.println("ip_ctr:"+ip_ctr);
//					System.out.println("rf_ctr:"+rf_ctr);
					
				}
				catch(Exception exp)
				{
					//out.println("error="+exp);
					exp.printStackTrace();
				}

//				}

				try
				{
					String sql1 = "	select cash_counter_code,  "+
					" short_desc , " +
					" decode(nvl(op_applicable_ind,'N'),'N',nvl(op_refund_ind,'N'),nvl(op_applicable_ind,'N')), "+
					" decode(nvl(ip_applicable_ind,'N'),'N',nvl(ip_refund_ind,'N'),nvl(ip_applicable_ind,'N')), "+
					" decode(nvl(ref_applicable_ind,'N'),'N',nvl(ref_refund_ind,'N'),nvl(ref_applicable_ind,'N')), "+
					" nvl(status,'X'),	 "+
					" nvl(cash_ctr_in_use_yn, 'N') "+
					" from bl_cash_counter_lang_vw "+
					" where language_id='"+locale+"' and nvl(cash_ctr_in_use_yn,'N') = 'N'  "+
					" and operating_facility_id = ?"+
					" and NVL(status,'X') <> 'S' "+
					" and cash_counter_code in ( "+
					" SELECT cash_counter_code FROM bl_users_for_cash_counter "+
					" WHERE operating_facility_id = ?  AND cash_counter_user_id = ? "+
					" AND NVL(status,'X') <> 'S') "+
					" order by cash_counter_code";

					PreparedStatement pstmt = con.prepareStatement(sql1);
					pstmt.setString(1, facility_id);
					pstmt.setString(2, facility_id);
					pstmt.setString(3, login_user);
					ResultSet rs = pstmt.executeQuery() ;
					while(rs.next())
					{
						strCashCounterCode = rs.getString(1);
						strCashCounterArray = strCashCounterArray + strCashCounterCode + "-" + rs.getString(3)+";"+rs.getString(4)+";" +rs.getString(5)+";"+"|";
//						System.err.println("strCashCounterArray:"+strCashCounterArray);
						out.println("<option value='"+strCashCounterCode+"'>"+rs.getString(2));
					}
					rs.close();
					pstmt.close();
					
				}
				catch(Exception e)
				{
					//out.println("Error = "+e);
					e.printStackTrace();
				}
				// commented in Banglore on 13/10/2005
				//ConnectionManager.returnConnection(con, request);

				
				
			}
			catch(Exception exp)
			{
				//out.println("Error = "+exp);
				exp.printStackTrace();
			}
			
			%>
			</select></td>
	   </tr>

		<tr>
		    <td width="50%" class='label'><fmt:message key="eBL.IP_ALLOWED.label" bundle="${bl_labels}"/></td>
		    <td width="50%" class='label'><input type='checkbox' name='ip_ctr' id='ip_ctr' value='N'  Disabled ></td>
		</tr>

		<tr>
		    <td width="50%" class='label'><fmt:message key="eBL.OP_EMG_ALLOWED.label" bundle="${bl_labels}"/></td>
		    <td width="50%" class='label'><input type='checkbox' name='op_ctr' id='op_ctr' value='N'  Disabled></td>
		</tr>

		<tr>
		    <td width="50%" class='label'><fmt:message key="eBL.EXT_ALLOWED.label" bundle="${bl_labels}"/></td>
		    <td width="50%" class='label'><input type='checkbox' name='rf_ctr' id='rf_ctr' value='N'  Disabled></td>
    	</tr>

		<tr>
		    <td width="50%" class='label'><fmt:message key="eBL.SHIFT_STARTED_AT.label" bundle="${bl_labels}"/></td>
		    <td width="50%" class='label'><input type='text' name='shift_started_at' id='shift_started_at' size='30' maxlength='20' value='' Disabled></td>
    	</tr>

		<tr>
		    <td width="50%" class='label' ><fmt:message key="eBL.SHIFT_STARTED_BY.label" bundle="${bl_labels}"/></td>
		    <td width="50%" class='label'><input type='text' name='shift_started_by' id='shift_started_by' size='30' maxlength='20' value='<%=login_user%>' Disabled></td>
		</tr>

		<tr>
		    <td width="50%" class='label' ><fmt:message key="Common.CurrentDateTime.label" bundle="${common_labels}"/></td>
		    <td width="50%" class='label'><input type='text' name='current_time' id='current_time' size='30' maxlength='20' value='' Disabled></td>
		</tr>
		<tr>
		    <td width="50%" class='label' ><fmt:message key="Common.OpeningBalance.label" bundle="${common_labels}"/></td>
		    <td width="50%" class='label'><input type='text' name='opening_balance' id='opening_balance' size='20' style='text-align:right; font-weight:bold' maxlength='30' value="" onBlur='funCheckNumber()'></td>
		</tr>

		

			<%

					
	
				
				if ( (op_ip_rf_ctr.equalsIgnoreCase("Y") )||
				   (op_ctr.equalsIgnoreCase("Y") &&
				   ip_ctr.equalsIgnoreCase("Y") &&
				   rf_ctr.equalsIgnoreCase("Y")) )
				{
/*					
					out.println("<script> alert('Cash Counter is already Logged On'); 	parent.commontoolbarFrame.onHome();  </script> ");
					out.println("");
*/
%>
			 <tr>
			    <td width="50%" class='label'>&nbsp;</td>
				<td width="50%" class='label'>&nbsp;</td>
			</tr>
					<!--out.println("<script> alert(getMessage('BL9546','BL'));parent.commontoolbarFrame.onHome();  </script> ");-->
<%					if(!refresh_flag.equals("Y"))
					{
%>
						<script>
							alert(getMessage('BL8195','BL'));
//							parent.commontoolbarFrame.onHome(); //commented by manivel on 15th Feb'2007 because tht function is nt available in commontoolbar.jsp
						</script>
<%
					}

				}
				if(!refresh_flag.equals("Y") && ( (op_ip_rf_ctr.equalsIgnoreCase("N") ) || (op_ctr.equalsIgnoreCase("N") && ip_ctr.equalsIgnoreCase("N") && rf_ctr.equalsIgnoreCase("N")) ) )
				{
%>
			<tr>
					<td width="50%" class='label'>&nbsp;</td>
					<td width="50%" class='label'><input type='button' class='button' name='Login' id='Login' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.CONFIRM_LOGIN.label","bl_labels")%>" onClick='callapply()'> 
			</tr>
<%
				}
			%>	

			<tr>
				<td width="50%" class='label'>&nbsp;</td>
				<td width="50%" class='label'>&nbsp;</td>
			</tr>
			<tr>
				<td width="50%" class='label'>&nbsp;</td>
				<td width="50%" class='label'>&nbsp;</td>
			</tr>

</table>
		<input type='hidden' name='cashcounter_array' id='cashcounter_array' value='<%=strCashCounterArray%>'>
		<input type='hidden' name='strCashCounterCode' id='strCashCounterCode' value='<%=strCashCounterCode%>'>
		<input type= 'hidden' name="locale" id="locale"  value='<%=locale%>'>
		<input type='hidden' name='loin' id='loin' value=''>
		<input type='hidden' name='called_frm' id='called_frm' value="<%=called_frm%>">

	


	</form>
</body>

</html>

<%
	}
	catch(Exception eX)
	{
			//out.println("Error= "+eX);
			eX.printStackTrace();
	}
	finally
	{
		if(con!=null) 
		{
			ConnectionManager.returnConnection(con, request);
		}
	}

%>

