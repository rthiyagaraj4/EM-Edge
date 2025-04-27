<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%	
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");	
	String facility_id = "";
	String loginUser = "";
	//String strCashCounterCode = "";
//	String strCashCounterArray = "";
//	String strLogoutTime  = "",
	String strLoginTime="",strsysdate="";
	Connection con = null;
	String locale	= (String)session.getAttribute("LOCALE");
	//System.out.println("****Cash Details JSP****");
	CurrencyFormat cf = new CurrencyFormat();
	String curr_deno="",curr_num="",curr_amt="",str_tot_amount="";	
	try
	{
		facility_id = (String)httpSession.getValue("facility_id");
		loginUser =  p.getProperty("login_user");		
		con = ConnectionManager.getConnection(request);
		int totalRecordsCash=8;double tot_amount=0.00;
		//String cashCounterCode = request.getParameter("cashCounterCode") == null ? "" :request.getParameter("cashCounterCode") ;
		strLoginTime = request.getParameter("strLoginTime") == null ? "" :request.getParameter("strLoginTime") ;
		strsysdate = request.getParameter("strsysdate") == null ? "" :request.getParameter("strsysdate") ;
		//System.out.println("strLoginTime cash dtls:"+strLoginTime);
		//System.out.println("strsysdate cash dtls:"+strsysdate);
		String mode				= request.getParameter("mode") == null ? "" : request.getParameter("mode");
		//System.out.println("mode cash dtls:"+mode); 
		int noofdecimal=2;
		String DenoMandReadonly="",strDenoMandYN="";String hand0verAmt="";
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
	<style>
		thead td, thead td.locked	{
		background-color: navy;
		color: white;
		position:relative;}	
		thead td {
		top: expression(document.getElementById("tbl-container").scrollTop-4); 
		z-index: 20;}
		thead td.locked {z-index: 30;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative;
		z-index: 10;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative;
		z-index: 10;}
		</style>
<script>  
</script>
<%
				try
				{
					String sql1 = "	SELECT  DENOMINATION_MAND_YN FROM bl_parameters WHERE OPERATING_FACILITY_ID='"+facility_id+"' ";
					PreparedStatement pstmt = con.prepareStatement(sql1);							
					ResultSet rs = pstmt.executeQuery() ;
					while(rs.next())
					{
						strDenoMandYN= rs.getString(1);						
							
					}
					rs.close();
					pstmt.close();
					if (strDenoMandYN.equals("Y"))
					{	
						DenoMandReadonly = "readonly";
					}
					DenoMandReadonly="";
				}catch(Exception e)
					{
						out.println("Error cash col = "+e);
					}				

					/*String sql1 = "	SELECT  SHORT_DESC, CASH_COUNTER_CODE,to_char(LOGIN_DATE_TIME,'dd/mm/yyyy hh24:mi:ss'), "+
					" to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') "+
					" FROM    BL_CASH_COUNTER_LANG_VW "+
					" WHERE  CASH_CTR_IN_USE_BY = ? "+
					" AND    OPERATING_FACILITY_ID   = ? "+
					" AND language_id='"+locale+"' ORDER BY 1 ";


					PreparedStatement pstmt = con.prepareStatement(sql1);
					pstmt.setString(1, loginUser);
					pstmt.setString(2, facility_id);					
					ResultSet rs = pstmt.executeQuery() ;
					while(rs.next())
					{
						strCashCounterCode = rs.getString(2);						
						strLoginTime = rs.getString(3);						
					}
					rs.close();
					pstmt.close();
				}*/
				
					if(!(locale.equals("en"))){
						strsysdate = com.ehis.util.DateUtils.convertDate(strsysdate,"DMYHMS",locale,"en");						
					}
		if(mode.equals("modify"))
		{	
			try{
				String sql1 = "	SELECT  CASH_REQUEST_AMT FROM bl_handed_reqt where OPERATING_FACILITY_ID=? and LOGGEDIN_USER_ID=? and REQUESTED_DATE_TIME=TO_DATE(?,'DD/MM/YYYY  hh24:mi:ss') ";		
				PreparedStatement pstmt = con.prepareStatement(sql1);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,loginUser);
				pstmt.setString(3,strsysdate);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()){
					
						hand0verAmt = rs.getString(1);						
					}
					if(hand0verAmt==null) hand0verAmt="0.00";
					hand0verAmt = cf.formatCurrency(hand0verAmt, noofdecimal);	
					rs.close();
					pstmt.close();
				}catch(Exception e)
				{
					out.println("Error cash hand = "+e);
				}				
	}			
%>
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
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect = "codeArrestThruSelect();" >
<form name='cashCollectionForm' id='cashCollectionForm' action='' target='' method=''>
	<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center' id="">			
			<tr>
				<td width="25%"  class='labels' nowrap><fmt:message key="eBL.HAND_OVER_REQ_AMT.label" bundle="${bl_labels}"/></td>
				<td width="25%" class="fields"><input type='text' name='cashHandedOver' id='cashHandedOver' size='10' style='text-align:right'  onBlur='callTotAmt(this,<%=totalRecordsCash%>);' onkeypress='return allowValidNumber1_temp(this,event,"<%=noofdecimal%>");' value="<%=hand0verAmt%>" <%=DenoMandReadonly%>/></td>					
			</tr>	
	</table>
		<div id="tbl-container" STYLE="overflow: auto; width: 350px; height: 300px;   padding:3px; margin: 0px">		
			<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center' id="cashDtl_tabId" name="cashDtl_tabId">
			<thead>
			<tr><!--<td class="COLUMNHEADER" colspan="15"><b><fmt:message key="eBL.CASH_DTLS.label" bundle="${bl_labels}"/></b></td>--></tr>
			<tr>
<%			if(mode.equals("modify")){%>
				<td class='columnheader' ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td> <%}%>
				<td class='columnheader' ><fmt:message key="eBL.DENO.label" bundle="${bl_labels}"/></td> 
				<td class='columnheader' ><fmt:message key="eBL.NOS.label" bundle="${bl_labels}"/></td> 
				<td class='columnheader' ><fmt:message key="Common.amount.label" bundle="${common_labels}"/></td> 
			</tr>	
			</thead>
			<tbody>


<%		if(mode.equals("modify")){	
		//System.out.println("in setDBValues,strsysdate bef="+strsysdate);
		int i=0;
			String sqlStr="SELECT DEN_AMT,DEN_QTY ,DEN_AMT*DEN_QTY TOT_AMT FROM bl_handed_cash_amt_den WHERE requested_date_time = TO_DATE(?,'DD/MM/YYYY  hh24:mi:ss') AND loggedin_user_id = ?";				
		//	System.out.println("in setDBValues,sqlStr="+sqlStr);
		//	System.out.println("in setDBValues,connection==null?="+(connection==null));	//	if(rs!=null) rs=null;				//if(pstmt!=null) pstmt=null;
					//System.out.println("in setDBValues,strsysdate="+strsysdate);
					//System.out.println("in setDBValues,loginUser="+loginUser);
					PreparedStatement	pstmt=con.prepareStatement(sqlStr);	
					pstmt.setString(1,strsysdate);
					pstmt.setString(2,loginUser);
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()){
						curr_deno = rs.getString("DEN_AMT");
						curr_num = rs.getString("DEN_QTY");
						curr_amt = rs.getString("TOT_AMT");
					//	System.out.println("in setDBValues,curr_deno="+curr_deno);
					//	System.out.println("in setDBValues,curr_num="+curr_num);
					//	System.out.println("in setDBValues,curr_amt="+curr_amt);
						if(curr_deno==null) curr_deno="0.00";
						curr_deno = cf.formatCurrency(curr_deno, noofdecimal);
						if(curr_amt==null) curr_amt="0.00";
							curr_amt = cf.formatCurrency(curr_amt, noofdecimal);				
						if(!(curr_deno.equals("0.00"))){%>
				<script>document.forms[0].cashHandedOver.value="";</script><%}%>
				<tr>
					<td align="left" nowrap><input type='checkbox'  name='cashSelect_<%=i%>' id='cashSelect_<%=i%>' onClick='selectCash(<%=i%>);' value="Y" checked/></td>
					<td width="20%" class="fields"><input type='text' name='currDeno_<%=i%>' id='currDeno_<%=i%>' size='10'    style='text-align:right'onkeypress='return allowValidNumber1_temp(this,event,"2");' value="<%=curr_deno%>" onblur='checkForDuplicate(this,<%=i%>);'/></td>		
					<td width="25%" class="fields"><input type='text' name='currNumber_<%=i%>' id='currNumber_<%=i%>' size='10' style='text-align:right' onBlur='calctotAmt(this,<%=i%>);' onkeypress='return ChkNumberInput(this,event,"0");' value="<%=curr_num%>" /></td>
					<td width="25%" class="fields"><input type='text' name='currAmt_<%=i%>' id='currAmt_<%=i%>' size='15' style='text-align:right' onBlur='putdeci_temp(this,"<%=noofdecimal%>");' onkeypress='return allowValidNumber1_temp(this,event,"<%=noofdecimal%>");' value="<%=curr_amt%>" readonly/></td>
				</tr>
	<%				i++;			
					tot_amount = tot_amount + Double.parseDouble(curr_amt);
					str_tot_amount = cf.formatCurrency(String.valueOf(tot_amount),noofdecimal);
				}
					//System.out.println("i @@@@@"+i);
					totalRecordsCash=i;
				//System.out.println("totalRecordsCash mod @@@@@"+totalRecordsCash);
				
				rs.close();
				pstmt.close();

	}else{
	for(int i=0; i<totalRecordsCash; i++)
	{	
%>			<tr>
				<td width="25%" class="fields"><input type='text' name='currDeno_<%=i%>' id='currDeno_<%=i%>' size='10' style='text-align:right'  onkeypress='return allowValidNumber1_temp(this,event,"2");' value="" onblur='checkForDuplicate(this,"<%=i%>");'/></td>			
				<td width="25%" class="fields"><input type='text' name='currNumber_<%=i%>' id='currNumber_<%=i%>' size='10' style='text-align:right' onBlur='calctotAmt(this,"<%=i%>");' onkeypress='return ChkNumberInput(this,event,"0");' value="" /></td>
				<td width="25%" class="fields"><input type='text' name='currAmt_<%=i%>' id='currAmt_<%=i%>' size='15' style='text-align:right' onBlur='putdeci_temp(this,"<%=noofdecimal%>");' onkeypress='' value="" readonly/></td>
		  </tr>
<%	}//for loop
	}//else
%>	</tbody>
		 </table>
		</div>
		
		<TABLE border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
			<tr>
				<td width="25%"  class='labels'>	</td>
				<td width="25%"  class='labels'>	</td>
				<td width="25%"  class='labels'>			
				<INPUT type="button" class='button' name='addBtn' id='addBtn' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>" onclick="addRow('cashDtl_tabId','CASH_DTL','<%=mode%>')" /> </td>
				<td width="25%"  class='labels'><fmt:message key="Common.total.label" bundle="${bl_labels}"/></td>
				<td width="25%" class="fields"><input type='text' name='cash_total' id='cash_total' size='15' style='text-align:right' onBlur=''  value="<%=str_tot_amount%>" readonly/></td>						
			</tr>
		</table>
	<input type='hidden' name="totalRecordsCash" id="totalRecordsCash" value="<%=totalRecordsCash%>">
	<input type='hidden' name="mode" id="mode" value="<%=mode%>">
	<input type='hidden' name="noofdecimal" id="noofdecimal" value="<%=noofdecimal%>">
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

