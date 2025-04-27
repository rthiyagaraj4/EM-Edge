<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.* ,webbeans.op.CurrencyFormat" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%	
	
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");	
	String facility_id = "";
	String loginUser = "";
//	String strCashCounterCode = "";
	//String strCashCounterArray = "";
	//String strLogoutTime  = "",
	String strLoginTime="";
	Connection con = null;
	CurrencyFormat cf = new CurrencyFormat();
	String locale	= (String)session.getAttribute("LOCALE");
	//System.out.println("cash counter");
	String classval="";int noofdecimal=0;
	try
	{
		facility_id = (String)httpSession.getValue("facility_id");
		loginUser =  p.getProperty("login_user");		
		con = ConnectionManager.getConnection(request);
		String reqDateTime="",cashHandedOver="",cheqHandedOver="",status="",apprUserId="",apprDate="";
		strLoginTime = request.getParameter("strLoginTime") == null ? "" :request.getParameter("strLoginTime") ;
		//System.out.println("cash counter TRANS DETAILS strLoginTime : "+strLoginTime);
		String status_label="";
		try
		{		
			PreparedStatement pstmt1 = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			ResultSet rs1 = pstmt1.executeQuery();	
			while(rs1.next())
			{
				noofdecimal  =  rs1.getInt(1);		
			}		
			rs1.close();
			pstmt1.close();
		}catch(Exception e)
			{
				System.out.println("noofdecimal="+e.toString());
			}
%>
<html>
<head>
<script>  
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
	<script language="javascript" src='../../eBL/js/BLCashChequeHandover.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect = "codeArrestThruSelect();" >
	<form name='cashCollectionTransDtlsForm' id='cashCollectionTransDtlsForm' action='' target='' method=''>
		<table border='0' cellpadding='0' cellspacing='0' width='100%' align='' id="chqDtl_tabId">
		<thead>
			<td width='20%' class="COLUMNHEADER" colspan='6' align="left"><fmt:message key="eBL.TRANS_DTLS.label" bundle="${bl_labels}"/></td>	
			<tr>
				<td class='columnheader' width='20%' align="left"><fmt:message key="eBL.REQ_DATE_TIME.label" bundle="${bl_labels}"/></td> 
				<td class='columnheader' width='11%' align="left"><fmt:message key="eBL.CASH.label" bundle="${bl_labels}"/></td> 
				<td class='columnheader' width='11%' align="left"><fmt:message key="eBL.CHEQUE.label" bundle="${bl_labels}"/></td> 
				<td class='columnheader' width='11%' align="left"><fmt:message key="Common.status.label" bundle="${common_labels}"/></td> 
				<td class='columnheader' width='11%' align="left"><fmt:message key="Common.userid.label" bundle="${common_labels}"/></td> 
				<td class='columnheader' width='11%' align="left"><fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></td> 
			</tr>	
		</thead>
<%	int i=0;			
	try{
		String sql1 = "	SELECT   to_char(REQUESTED_DATE_TIME,'dd/mm/yyyy HH24:MI:SS'), CASH_REQUEST_AMT,CHQ_REQUEST_AMT , STATUS,APPROVED_USER_ID ,to_char(APPROVED_DATE,'dd/mm/yyyy HH24:MI:SS') from  bl_handed_reqt WHERE status <> 'R' and LOGGEDIN_USER_ID ='"+loginUser+"' AND LOGIN_DATE_TIME =TO_DATE('"+strLoginTime+"','dd/mm/yyyy HH24:MI:SS') order by REQUESTED_DATE_TIME desc";         
			PreparedStatement pstmt = con.prepareStatement(sql1);										
			ResultSet rs = pstmt.executeQuery() ;
			while(rs.next())
			{
				reqDateTime = rs.getString(1);						
				cashHandedOver = rs.getString(2);	
				cheqHandedOver = rs.getString(3);	
				status = rs.getString(4);	
				apprUserId = rs.getString(5);	
				apprDate = rs.getString(6);	
				if(reqDateTime==null) reqDateTime="";
				if(cashHandedOver==null) cashHandedOver="0.00";
				if(cheqHandedOver==null) cheqHandedOver="0.00";
				if(apprUserId==null) apprUserId="";
				if(apprDate==null) apprDate="";
				cashHandedOver = cf.formatCurrency(cashHandedOver, noofdecimal);
				cheqHandedOver = cf.formatCurrency(cheqHandedOver, noofdecimal);

			if(!(locale.equals("en"))){
				reqDateTime = com.ehis.util.DateUtils.convertDate(reqDateTime,"DMYHMS","en",locale);
				apprDate = com.ehis.util.DateUtils.convertDate(apprDate,"DMYHMS","en",locale);
			}
			if(status.equals("C")){
				status_label=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
			}else if(status.equals("A")){
				status_label=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Approved.label","common_labels");
			}else if(status.equals("X")){
				status_label=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels");
				}
		if(i % 2 == 0 )
					{
						classval	=	"QRYEVEN";
					}
					else
					{
						classval	=	"QRYODD";
					}
%>		<tbody>
		<!--	<td nowrap><input type='text' name='reqDateTime_<%=i%>' id='reqDateTime_<%=i%>' size='15'  onBlur='' onkeypress='' value="<%=reqDateTime%>" 			readonly/></td>			
				<td align="left" nowrap><input type='text' name='cash_<%=i%>' id='cash_<%=i%>' size='15'  onBlur='' onkeypress='' value="<%=cashHandedOver%>" readonly /></td>
				<td align="left" nowrap><input type='text' name='Cheque_<%=i%>' id='Cheque_<%=i%>' size='15'  onBlur='' onkeypress='' value="<%=cheqHandedOver%>"  readonly/></td>
				<td align="left" nowrap><input type='text' name='status_<%=i%>' id='status_<%=i%>' size='15'  onBlur='' onkeypress='' value="<%=status_label%>" readonly /></td>
				<td align="left" nowrap><input type='text' name='userId_<%=i%>' id='userId_<%=i%>' size='15'  onBlur='' onkeypress='' value="<%=apprUserId%>" readonly /></td>					
				<td align="left" nowrap><input type='text' name='dateTime<%=i%>' id='dateTime<%=i%>' size='15'  onBlur='' onkeypress='' value="<%=apprDate%>" readonly/></td>-->

				<td class=<%=classval%> width='20%'><%=reqDateTime%></td>
				<td class=<%=classval%>  width='11%' ><%=cashHandedOver%></td>
				<td class=<%=classval%>  width='11%' ><%=cheqHandedOver%></td>
				<td class=<%=classval%>  width='11%' ><%=status_label%></td>
				<td class=<%=classval%>  width='11%' ><%=apprUserId%></td>
				<td class=<%=classval%>  width='11%' ><%=apprDate%></td>

<%				i++;
			}
				rs.close();
				pstmt.close();
		}catch(Exception e)
				{
					out.println("Error trans det col = "+e);
				}				
%>		</tbody>
		</table>	
</form>
</body>
<%

	}catch(Exception eX)
		{
			out.println("Handover Cash collection "+eX);
		}
		finally
		{
		ConnectionManager.returnConnection(con, request);
		}
%>
</html>

