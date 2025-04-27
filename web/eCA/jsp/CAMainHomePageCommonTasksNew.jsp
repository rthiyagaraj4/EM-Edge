<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
<TITLE><fmt:message key="Common.NewDocument.label" bundle="${common_labels}"/> </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='styleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src="../../eCA/js/CAMainCommonTasks.js"></script>
	<script language=javascript src='../../eCA/js/CAMainMyTasks.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
</HEAD>

<BODY  OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<!--<script language=javascript>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->
<form>
<!-- <b><font color='red'>Common Tasks List</font></b> -->
<!--<table border='0' width='100%' id='dataTitleTable' cellpadding='3' cellspacing='0' align='center' >
<tr><td  colspan='5' class='COMMONTOOLBARFUNCTION' style='border:0'><b><fmt:message key="Common.Orders.label" bundle="${common_labels}"/></b>
</td></tr>
</table> -->
<table cellspacing='0' border=1 cellpadding=3 width='100%' align='center'>
<% 
	Connection con = null;
	PreparedStatement pstmtComp = null,pstmtDesc = null,pstmtDesc1 = null;
	ResultSet rsComp = null, rsDesc = null;
	
	int totCount=0;
	String classValue = "";
	StringBuffer sql=null,sql1=null; // new StringBuffer();
	String compId="";
	String comp_desc="";
	//String applicable_yn="";
	int i = 0;
	StringBuffer toolTipStr = new StringBuffer();

	String pract_type =(String) session.getValue("practitioner_type") == null ? "" :(String) session.getValue("practitioner_type");
	String practitioner_id=(String)request.getParameter("practitioner_id") == null ? "" : (String)request.getParameter("practitioner_id");

	String facility_id=(String) session.getValue("facility_id");
	String Clin_id=(String)session.getValue("ca_practitioner_id");
	String responsibility_id		= (String)session.getValue("responsibility_id");
	if(responsibility_id==null) responsibility_id = "";
	
	try
	{
		con=ConnectionManager.getConnection(request);
		//pstmtComp = con.prepareStatement("SELECT COMP_ID, NVL((SELECT 'Y' FROM ca_personalized_home_page WHERE PRACT_TYPE =? AND PRACTITIONER_ID = ? AND COMP_ID=CA_HOME_PAGE_COMP.COMP_ID AND ROWNUM=1), 'N') applicable_yn FROM CA_HOME_PAGE_COMP where  COMP_ID in ('PEND_AUTH'	,'PEN_COSIGN','PRES_MEDI','PEND_CONST','PEND_APPT') ");
		pstmtComp = con.prepareStatement("SELECT COMP_ID, (select COMP_DESC FROM CA_HOME_PAGE_COMP where COMP_ID = A.COMP_ID) COMP_DESC FROM ca_personalized_home_page A WHERE PRACT_TYPE =? AND PRACTITIONER_ID = ? AND COMP_ID in ('PEND_AUTH'	,'PEN_COSIGN','PRES_MEDI','PEND_CONST','PEND_APPT') ");
		pstmtComp.setString(1,pract_type);
		pstmtComp.setString(2,practitioner_id);
		rsComp = pstmtComp.executeQuery();

	    sql= new StringBuffer();
		sql.append("SELECT COUNT (*) tot_cnt   FROM OR_ORDER_PEND_STATUS_LOG a  WHERE a.PEND_STATUS_IND=? and ORDERING_FACILITY_ID=? and a.ORDER_DATE BETWEEN TRUNC (SYSDATE - 7) AND SYSDATE   and ( SOURCE_TYPE='R' or (a.source_type, a.source_code) IN (                      SELECT DECODE (locn_type, 'W', 'N', locn_type),                             locn_code                        FROM ca_pract_by_locn_view                       WHERE facility_id = ? AND practitioner_id = ?))  AND ORDER_CATEGORY IN  (select order_Category from or_review_user_categories  where (practitioner_id =?  or resp_id = ?)  and DECODE(?,'CS',COSIGN_YN,'PO',AUTH_YN ,'PS', SPL_APPR_YN )= 'Y')   ");
		pstmtDesc=con.prepareStatement(sql.toString());
		
		while(rsComp.next())
		{
			i = i+1;
			//if ( i % 2 == 0 )
				classValue = "WHITEROW" ;
			//else
				//classValue = "CAQUERYODD" ;
		//pending Authorization
		compId=rsComp.getString("COMP_ID");
		comp_desc=rsComp.getString("COMP_DESC");
		toolTipStr = new StringBuffer();
	    if(compId.equals("PEND_AUTH"))
		{
			//classValue = "CAQUERYEVEN";
			
			 	//	     sql= new StringBuffer();

			//sql.append("SELECT COUNT (*) tot_cnt   FROM or_order a  WHERE a.ord_date_time BETWEEN TRUNC (SYSDATE - 7) AND SYSDATE  AND ordering_facility_id = ?  AND a.order_status = (SELECT order_status_code                            FROM or_order_status_code                           WHERE order_status_type = '03')     AND NVL (cont_order_ind, 'DO') IN ('CO', 'DO', 'CR', 'DR')    AND ord_auth_reqd_yn = 'Y'    and (a.source_type, a.source_code) IN (                      SELECT DECODE (locn_type, 'W', 'N', locn_type),                             locn_code                        FROM ca_pract_by_locn_view                       WHERE facility_id = ? AND practitioner_id = ?) ");
			
		
			//pstmtDesc=con.prepareStatement(sql.toString());
			pstmtDesc.setString(1,"PO");
			pstmtDesc.setString(2,facility_id);
			pstmtDesc.setString(3,facility_id);
			pstmtDesc.setString(4,Clin_id);
			pstmtDesc.setString(5,Clin_id);
			pstmtDesc.setString(6,responsibility_id);
			pstmtDesc.setString(7,"PO");
			rsDesc=pstmtDesc.executeQuery();
			totCount = 0;
			
			while (rsDesc.next())
			{
				totCount =rsDesc.getInt(1);
			}
			if(rsDesc!=null)rsDesc.close();
			//if(pstmtDesc!=null)pstmtDesc.close();
			//sql=null;
		
			%>
			<tr>
				<td class='<%=classValue%>' nowrap>
				<% if (totCount!=0) 
					{ %>
					<a class='gridLink' href='javascript:pendingAuth();'><%=comp_desc%>(<%=totCount%>)</a>
				<% }
					else
					{%>
					<%=comp_desc%>(0) 
				<% } %>
				</td>
			</tr>
			
		 
   	    <%}
			else if(compId.equals("PEN_COSIGN")){ //classValue = "CAQUERYEVEN";%>
			<%
			
			//Pending Cosign
			toolTipStr = new StringBuffer();
			
 		    //sql= new StringBuffer();
			totCount=0;
			//sql.append(" SELECT count(*) tot_cnt     FROM or_order a     WHERE  	      a.ord_date_time BETWEEN trunc(SYSDATE - 7) AND SYSDATE      AND  a.ordering_facility_id = ?      AND  ord_cosign_reqd_yn = 'Y' 	 AND (a.source_type, a.source_code) IN (SELECT decode(locn_type, 'W', 'N',                                                     locn_type), locn_code                FROM ca_pract_by_locn_view                WHERE facility_id = ?                  AND practitioner_id = ?)  	 AND  ord_cosign_by_pract_id IS NULL       AND ord_cosign_date_time IS NULL   ");

			//pstmtDesc=con.prepareStatement(sql.toString());
			pstmtDesc.setString(1,"CS");
			pstmtDesc.setString(2,facility_id);
			pstmtDesc.setString(3,facility_id);
			pstmtDesc.setString(4,Clin_id);
			pstmtDesc.setString(5,Clin_id);
			pstmtDesc.setString(6,responsibility_id);
			pstmtDesc.setString(7,"CS");
			rsDesc=pstmtDesc.executeQuery();
			totCount=0;
			while (rsDesc.next())
			{
				totCount=rsDesc.getInt(1);
			}

		if(rsDesc!=null)rsDesc.close();
		//if(pstmtDesc!=null)pstmtDesc.close();
			//sql=null;
			%>
			<tr>
				<td class='<%=classValue%>' nowrap>
				<% if (totCount!=0)
					{ %>
					<a class='gridLink' href='javascript:pendingCosign();'><%=comp_desc%>(<%=totCount%>)</a>
				<% }
				else
				{ %>
					<%=comp_desc%>(0)
			<% } %>
				</td>
			</tr>
	<%
			
			}else if(compId.equals("PRES_MEDI")		){
				//classValue = "CAQUERYODD";
		
		//Expire/Expired
		
 		 sql1= new StringBuffer();
		toolTipStr = new StringBuffer();
		totCount=0;
		sql1.append("select count(*) count from  or_ordeR_line a , or_order c where C.ORD_DATE_TIME BETWEEN TRUNC(SYSDATE-30) AND SYSDATE   and a.CONT_ORDER_IND in ('CO','CR') and  a.order_Category ='PH' and c.order_id=a.order_id and (NVL(END_DATE_TIME,SYSDATE) >= sysdate  and          ABS(round(TO_NUMBER(TO_CHAR(NVL(END_DATE_TIME,SYSDATE)- SYSDATE)) * 24,2))   <  (select SINGLE_CONT_RENEW_HRS_BEHIND from   or_param_by_facility   where operating_facility_id = ?) and order_line_Status  not in (select order_status_Code from or_order_Status_Code where      order_STatus_type in ('92','96','99')) and end_date_time is not null or NVL(END_DATE_TIME,SYSDATE) < sysdate  and ABS(round(TO_NUMBER(TO_CHAR(SYSDATE -NVL(end_date_time,SYSDATE))) * 24,2))  <   (select SINGLE_CONT_RENEW_HRS_AHEAD from or_param_by_facility where operating_facility_id = ?) and order_line_Status  not in (select order_status_Code from or_order_Status_Code where order_STatus_type in ('92','96','99')) ) and end_date_time is not null and (c.source_type,c.source_Code) in (select DECODE(LOCN_TYPE,'W','N',LOCN_TYPE),locn_code from CA_PRACT_BY_LOCN_VIEW where  FACILITY_ID=? AND practitioner_id= ? ) and c.ord_pract_id =? ");

		pstmtDesc1 = con.prepareStatement(sql1.toString());
		pstmtDesc1.setString(1,facility_id);	
		pstmtDesc1.setString(2,facility_id);	
		pstmtDesc1.setString(3,facility_id);	
		pstmtDesc1.setString(4,Clin_id);	
		pstmtDesc1.setString(5,Clin_id);	
		rsDesc = pstmtDesc1.executeQuery();

		while(rsDesc.next()){
			totCount=rsDesc.getInt(1);
		}
			if(rsDesc!=null)rsDesc.close();
			if(pstmtDesc1!=null)pstmtDesc1.close();
			sql1=null;
		
		%>
		<tr>
			<td class='<%=classValue%>' nowrap>
			<%if(totCount != 0){%>
				<a class='gridLink' href="javascript:;" onClick="return funMedicationsDue()">
				<%=comp_desc%>(<%=totCount%>)</a>
			<%}else{%>
				<%=comp_desc%>(0)
			<%}%>
			</td>
		</tr>

		<%

		}else if(compId.equals("PEND_CONST")){
			//classValue = "CAQUERYODD";
				

	//Pending Consent
		
 		sql1= new StringBuffer();
		toolTipStr = new StringBuffer();
		totCount=0;
		sql1.append("SELECT COUNT (*) tot_cnt   FROM OR_ORDER_PEND_STATUS_LOG a  WHERE a.PEND_STATUS_IND=? and ORDERING_FACILITY_ID=? and a.ORDER_DATE BETWEEN TRUNC(SYSDATE - 7) AND TRUNC(SYSDATE)+.9999   and ( a.SOURCE_TYPE='R' or (a.source_type, a.source_code) IN (                      SELECT DECODE (locn_type, 'W', 'N', locn_type),                             locn_code                        FROM ca_pract_by_locn_view                       WHERE facility_id = ? AND practitioner_id = ?)) ");

		//sql1.append("select  count(*) totalCount from or_order A WHERE a.ordering_facility_id = ? and a.ORD_CONSENT_REQD_YN = 'Y' AND (a.ORDER_STATUS =  (select order_status_code from  or_order_status_code where ORDER_STATUS_Type ='00') OR exists (select 'Y' from or_order_line b,or_order_Status_code c  where b.order_id = a.order_id and b.order_line_Status = c.order_Status_code and c.order_Status_type not in ('99','97','94')   and ORD_CONSENT_STATUS = 'P' and rownum <=1)) And ( a.source_type !='R'  and (a.source_type,a.source_CODE) IN (SELECT DECODE(LOCN_TYPE,'W','N',LOCN_TYPE),locn_code FROM ca_pract_by_locn_view WHERE practitioner_id=?) or  a.source_type ='R' ) and a.ORD_DATE_TIME  between TRUNC (SYSDATE - 7) AND SYSDATE "); 


		pstmtDesc1 = con.prepareStatement(sql1.toString());
        pstmtDesc1.setString(1,"PC");	
        pstmtDesc1.setString(2,facility_id);	
        pstmtDesc1.setString(3,facility_id);	
		pstmtDesc1.setString(4,Clin_id);	
		rsDesc = pstmtDesc1.executeQuery();
		while(rsDesc.next())
		{
			totCount=rsDesc.getInt(1);
		}

		if(rsDesc!=null) rsDesc.close();
		if(pstmtDesc1!=null) pstmtDesc1.close();
		sql1=null;
	
		%>
		<tr>
			<td class='<%=classValue%>' nowrap>
			<%if(totCount != 0){%>
				<a class='gridLink' href="javascript:;" onClick="pendingConsent('<%=comp_desc%>')">
				<%=comp_desc%>(<%=totCount%>)</a>
			<%}else{%>
				<%=comp_desc%>(0)
			<%}%>
			</td>
		</tr>
		<%
			
			}else if(compId.equals("PEND_APPT")){
			//classValue = "CAQUERYODD";
				

	//Pending Consent
		
 		sql1= new StringBuffer();
		toolTipStr = new StringBuffer();
		totCount=0;
		sql1.append("SELECT COUNT (*) tot_cnt   FROM OR_ORDER_PEND_STATUS_LOG a  WHERE a.PEND_STATUS_IND=? and ORDERING_FACILITY_ID=? and a.ORDER_DATE BETWEEN TRUNC (SYSDATE - 7) AND SYSDATE   and (a.source_type='R' OR (a.source_type, a.source_code) IN (                      SELECT DECODE (locn_type, 'W', 'N', locn_type),                             locn_code                        FROM ca_pract_by_locn_view                       WHERE facility_id = ? AND practitioner_id = ?)) ");

		//sql1.append("select  count(*) totalCount from or_order A WHERE a.ordering_facility_id = ? and a.ORD_CONSENT_REQD_YN = 'Y' AND (a.ORDER_STATUS =  (select order_status_code from  or_order_status_code where ORDER_STATUS_Type ='00') OR exists (select 'Y' from or_order_line b,or_order_Status_code c  where b.order_id = a.order_id and b.order_line_Status = c.order_Status_code and c.order_Status_type not in ('99','97','94')   and ORD_CONSENT_STATUS = 'P' and rownum <=1)) And ( a.source_type !='R'  and (a.source_type,a.source_CODE) IN (SELECT DECODE(LOCN_TYPE,'W','N',LOCN_TYPE),locn_code FROM ca_pract_by_locn_view WHERE practitioner_id=?) or  a.source_type ='R' ) and a.ORD_DATE_TIME  between TRUNC (SYSDATE - 7) AND SYSDATE "); 


		pstmtDesc1 = con.prepareStatement(sql1.toString());
        pstmtDesc1.setString(1,"PA");	
        pstmtDesc1.setString(2,facility_id);	
        pstmtDesc1.setString(3,facility_id);	
		pstmtDesc1.setString(4,Clin_id);	
		rsDesc = pstmtDesc1.executeQuery();
		while(rsDesc.next())
		{
			totCount=rsDesc.getInt(1);
		}

		if(rsDesc!=null) rsDesc.close();
		if(pstmtDesc1!=null) pstmtDesc1.close();
		sql1=null;
	
		%>
		<tr>
			<td class='<%=classValue%>' nowrap>
			<%if(totCount != 0){%>
				<a class='gridLink' href="javascript:;" onClick="pendingAppointment()">
				<%=comp_desc%>(<%=totCount%>)</a>
			<%}else{%>
				<%=comp_desc%>(0)
			<%}%>
			</td>
		</tr>
		<%
			
			}
		}
		for(int j=i+1;j<=6;j++)
		{
			//if ( j % 2 == 0 )
				classValue = "WHITEROW" ;
			//else
				//classValue = "CAQUERYODD" ;
		%>
			<tr>
				<td class='<%=classValue%>' >&nbsp;</td>
			</tr>
		<%
		}
		sql=null;
		if(pstmtDesc!=null) pstmtDesc.close();
		if(rsComp!=null) rsComp.close();
		if(pstmtComp!=null) pstmtComp.close();

		
	}
	catch(Exception e)
	{
		//out.println("Exception: "+e);//COMMON-ICN-0181
		e.printStackTrace();
	}
 
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con,request);
	}
%>
</table>
<input type='hidden' name="queryString" id="queryString" value="<%=request.getQueryString()%>"></input>
</form>
</BODY>
</HTML>

