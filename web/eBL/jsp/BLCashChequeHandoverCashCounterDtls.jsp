<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eCommon.Common.*, webbeans.eCommon.* ,eBL.BLCashChequeHandOverBean" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%	
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");	
	String facility_id = "";
	String loginUser = "";
	//String strCashCounterCode = "";
	String strCashCounterArray = "";
	String strLogoutTime  = "";//,strLoginTime="";
	Connection con = null;
	String locale	= (String)session.getAttribute("LOCALE");
	try
	{
		facility_id = (String)httpSession.getValue("facility_id");
		loginUser =  p.getProperty("login_user");		
		con = ConnectionManager.getConnection(request);
		PreparedStatement pstmt = null;
		//ResultSet rs = null;
		ResultSet rscurr = null;
		int noofdecimal=2;
		String mode				= request.getParameter("mode") == null ? "" : request.getParameter("mode");
		String strCashCountrCode				= request.getParameter("cashCountrCode") == null ? "" : request.getParameter("cashCountrCode");
		String strInUseBy				= "";//request.getParameter("inUseBy") == null ? "" : request.getParameter("inUseBy");
		String strLongDesc				= "";//request.getParameter("longDesc") == null ? "" : request.getParameter("longDesc");
	//	String strLoginDate		= "";//request.getParameter("loginDate") == null ? "" : request.getParameter("loginDate");
		//String strReqDateTime="",strCashHandedOver="",strcheqHandedOver="";

		String bean_id = "BLCashChequeHandOverBean" ;
		String bean_name = "eBL.BLCashChequeHandOverBean";
		 BLCashChequeHandOverBean bean			= (BLCashChequeHandOverBean)getBeanObject( bean_id, bean_name, request ) ;
	/*	if(mode.equals("modify") ) {
			try{

				String sql1 = "	SELECT CASH_COUNTER_CODE,LOGGEDIN_USER_ID,LOGIN_DATE_TIME,REQUESTED_DATE_TIME,CASH_HANDED_OVER,CHEQUE_HANDED_OVER FROM bl_handed_reqt WHERE LOGIN_DATE_TIME=(SELECT LOGIN_DATE_TIME FROM   BL_CASH_COUNTER_SLMT_HDR WHERE  OPERATING_FACILITY_ID = '"+facility_id+"'	AND    CASH_COUNTER_USER_ID  = '"+loginUser+"' AND    LOGOUT_DATE_TIME     IS NULL) AND STATUS='R' ";
				pstmt = con.prepareStatement(sql1);
				//pstmt.setString(1, facility_id);
				//pstmt.setString(2, loginUser);
										
					rs = pstmt.executeQuery() ;
					while(rs.next())
					{
						strCashCountrCode = rs.getString(1);						
						strInUseBy = rs.getString(2);						
						strLoginDate = rs.getString(3);						
						strReqDateTime = rs.getString(4);						
						strCashHandedOver = rs.getString(5);						
						strcheqHandedOver = rs.getString(6);						
					}

					
					if(strCashCountrCode==null) strCashCountrCode="";
					if(strInUseBy==null) strInUseBy="";
					if(strLoginDate==null) strLoginDate="";
					if(strReqDateTime==null) strReqDateTime="";
					if(strCashHandedOver==null) strCashHandedOver="";
					if(strcheqHandedOver==null) strcheqHandedOver="";

					
					rs.close();
					pstmt.close();
				}catch(Exception e)
				{
					out.println("Error cash ctr = "+e);
				}		

		
		//bean.setDBValues(strCashCountrCode,strInUseBy,strReqDateTime,locale,facility_id);//set database values to bean.
	}*/
		
	try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rscurr = pstmt.executeQuery();	
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


%>

<html>
<head>
<script>
  
</script>
<%

				
				
			
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
			<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language="javascript" src='../../eBL/js/BLCashChequeHandover.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>





	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect = "codeArrestThruSelect();" onLoad=''>
	<form name='cashCounterForm' id='cashCounterForm'>
	<!--<form name='logout_forms' id='logout_forms' action='BLLogoutSlmtTitle.jsp' target='detail_frame' method='post'>-->

		<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
		<tr>
		<td class='columnheader' ><b><fmt:message key="eBL.CASH_COUNTER.label" bundle="${bl_labels}"/></b></td>			
		<td class='columnheader' > <b><fmt:message key="eBL.IN_USE_BY.label" bundle="${bl_labels}"/></b></td>
		<td class='columnheader' > <b><fmt:message key="eBL.LOGIN_DATE_TIME.label" bundle="${bl_labels}"/></b> </td>
		<td class='columnheader' > <b><fmt:message key="eBL.REQ_DATE_TIME.label" bundle="${bl_labels}"/></b> </td>

		
		</tr>	
		
		<tr>		
		<td width="25%" class="fields"><input type='text' name='cashCounterDesc' id='cashCounterDesc' value='<%=strLongDesc%>' onBlur="cashCounterLookup(this,'B','<%=mode%>');"  ><input type='button' class='button' name='cashCounterLookupBtn' id='cashCounterLookupBtn' value='?'  onClick="cashCounterLookup(document.forms[0].cashCounterDesc,'C','<%=mode%>');" ></td>
			<input type='hidden' name='cashCounterCode' id='cashCounterCode' value='<%=strCashCountrCode%>'>
		<td width="25%" class="fields"><input type='text' name='inUseBy' id='inUseBy' value='<%=strInUseBy%>' readonly ></td> 
		<td width="25%" class="fields"><input type='text' name='loginDateTime' id='loginDateTime' size='30' maxlength='30' value='' readonly></td>
		<td width="25%" class="fields"> <input type='text' name='reqDateTime' id='reqDateTime' size='30' maxlength='30' value='' readonly></td>

		</tr>
	</table>
		<input type='hidden' name='cashcounter_array' id='cashcounter_array' value='<%=strCashCounterArray%>'>
		<input type='hidden' name='v_logout_time' id='v_logout_time' value='<%=com.ehis.util.DateUtils.convertDate(strLogoutTime,"DMYHMS","en",locale)%>'>
		<input type='hidden' name="locale" id="locale"  value='<%=locale%>'>		
		<input type='hidden' name="userId" id="userId"  value='<%=loginUser%>'>		
		<input type='hidden' name="facility_id" id="facility_id"  value='<%=facility_id%>'>		
		<input type='hidden' name="cashInHand" id="cashInHand"  value=''>		
		<input type='hidden' name="chequeInHand" id="chequeInHand"  value=''>		
		<input type='hidden' name="noofdecimal" id="noofdecimal"  value='<%=noofdecimal%>'>		
		<input type='hidden' name="mode" id="mode"  value='<%=mode%>'>		
		<input type='hidden' name="handoverrequestamt" id="handoverrequestamt"  value=''>		
			
		
</form>
</body>
<%putObjectInBean(bean_id,bean,request);%>
<%
}
	catch(Exception eX)
	{
			out.println("Handover Cash Counter "+eX);
	}
	finally 
	{
		ConnectionManager.returnConnection(con, request);
	}
%>
</html>

