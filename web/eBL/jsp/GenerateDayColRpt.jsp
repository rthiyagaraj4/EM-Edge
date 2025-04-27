<!DOCTYPE html>
<%
/* <!-- 
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210112             11086          MOHE-CRF-0050                  Mohana Priya K
 -->  */
%>

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,  webbeans.eBL.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*,eBL.Common.*,com.ehis.util.*,eBL.*,eMR.*" %>
<%@page import="eBL.BLReportIdMapper"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%  System.err.println("13");
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%
Connection con = null;
CallableStatement cstmt = null;
CallableStatement cstmt1 = null;

try{
	con = ConnectionManager.getConnection(request);
	String operation = request.getParameter("func_mode") == null ? "" :request.getParameter("func_mode");
	String facility_id=request.getParameter("facility_id") == null ? "" :request.getParameter("facility_id");
	String detail=request.getParameter("detail") == null ? "N" :request.getParameter("detail");
	String delivery=request.getParameter("delivery") == null ? "N" :request.getParameter("delivery");
	String report_date=request.getParameter("report_date") == null ? "" :request.getParameter("report_date");
	String p_language_id=request.getParameter("p_language_id") == null ? "" :request.getParameter("p_language_id");
	String p_date_format=request.getParameter("p_date_format") == null ? "" :request.getParameter("p_date_format");
	String frm_cash=request.getParameter("fm_cash_counter1") == null ? "" :request.getParameter("fm_cash_counter1");
	String to_cash=request.getParameter("to_cash_counter1") == null ? "" :request.getParameter("to_cash_counter1");
	System.err.println("operation-"+operation+" facility_id-"+facility_id+" detail-"+detail+" delivery-"+delivery+" report_date-"+report_date+" p_language_id-"+p_language_id+" p_date_format-"+p_date_format);


if(operation.equals("generaterpt")){
  try{
		cstmt=con.prepareCall("{ call bl_daily_cash_delv_rep. proc_gen_report (?,?,?,to_date(?,'DD/MM/YYYY'),?,?,?,?,?,?,?)}");	
		cstmt.setString(1,facility_id);
		cstmt.setString(2,detail);
		cstmt.setString(3,delivery);
		cstmt.setString(4,report_date);
		cstmt.setString(5,frm_cash);
		cstmt.setString(6,to_cash);
		cstmt.setString(7,p_language_id);		
		cstmt.setString(8,p_date_format);
		cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
		cstmt.execute();
		String messageId=cstmt.getString(10);
		String messageText=cstmt.getString(11);
		
		System.err.println("messageText  "+messageText);
		
		String returnValue= "";
		if(messageId != null || messageText != null){
			if(messageId != null && messageText != null){
				returnValue = "::"+messageText+"~"+messageId+"~";
			}else if(messageId != null &&  messageText == null){
				returnValue = "~"+messageId+"~";
			}else{
				returnValue = "::"+messageText+"~";
			}
		}else{
			returnValue ="";
		}
		
		System.err.println("returnValue  "+returnValue);
		out.println(returnValue); 
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Err Msg from generaterpt.jsp "+e);
			con.rollback();
		}finally{
			cstmt=null;
		}
	}
	else if(operation.equals("cashcol")){
	  try{
			cstmt1=con.prepareCall("{ call bl_daily_cash_delv_rep.proc_valdt_report (?,to_date(?,'DD/MM/YYYY'),?,?,?,?,?,?,?) }");
			cstmt1.setString(1,facility_id);
			cstmt1.setString(2,report_date);
			cstmt1.setString(3,p_date_format);
			cstmt1.setString(4,frm_cash);
			cstmt1.setString(5,to_cash);
			cstmt1.setString(6,p_language_id);
			cstmt1.registerOutParameter(7,java.sql.Types.VARCHAR);
			cstmt1.registerOutParameter(8,java.sql.Types.VARCHAR);
			cstmt1.registerOutParameter(9,java.sql.Types.VARCHAR);
			cstmt1.execute();
			String messageId=cstmt1.getString(8);
			String messageText=cstmt1.getString(9);
			String returnValue= "";
			System.err.println("messageId  "+messageId);
			System.err.println("messageText  "+messageText);
			
			if(messageId != null || messageText != null){
				if(messageId != null && messageText != null){
					returnValue = "::"+messageText+"~"+messageId+"~";
				}else if(messageId != null &&  messageText == null){
					returnValue = "~"+messageId+"~";
				}else{
					returnValue = "::"+messageText+"~";
				}
			}else{
				returnValue ="";
			}
			
			System.err.println("returnValue  "+returnValue);
			out.println(returnValue); 
	}catch(Exception e){
		e.printStackTrace();
		System.err.println("Err Msg from cashcollection "+e);
		con.rollback();
	}finally{
		cstmt1=null;
	}
	}
	}catch(Exception e){
		e.printStackTrace();
		System.err.println("Err Msg from generatecolrpt.jsp "+e);
		con.rollback();
	}
	finally{
		ConnectionManager.returnConnection(con,request);
	}
%>
<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	
	<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eBL/js/dailycashTabFrame.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
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
<%
	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
	response.setHeader("Pragma","no-cache"); //HTTP 1.0   
	response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
	String locale			=	"";
	String facilityId		=	"";
	//String isUserCanAcess	=	"";

	try  
	{	 
		sStyle 				=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		locale 				= 	(String)session.getAttribute("LOCALE");
		facilityId			=   (String) session.getValue( "facility_id" ) ;
		//isUserCanAcess		= 	(String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));	
		HttpSession httpSession = request.getSession(false);
		
		Properties p = (Properties)httpSession.getValue("jdbc");
		String strLoggedUser = p.getProperty("login_user");
		if(strLoggedUser == null) strLoggedUser="";
		System.err.println("user-->"+strLoggedUser);
%>

<body onMouseDown="CodeArrest();" onKeyDown= "lockKey();" onSelect="codeArrestThruSelect();" onLoad="focus_val();">
<form id="genrpt" name="genrpt" id="genrpt">

<table cellpadding=3 cellspacing=0 width="100%" align="center" border=0>
	<tr>
		<td class="label" >
			<fmt:message key="eBL.reportdate.label" bundle="${common_labels}"/>
		</td>
		<td class='fields'>
			<input type="text" name="report_date" id="report_date" id="report_date" 	 size="10"	 maxlength="10"  onBlur='return DateChk(document.forms[0].report_date);return dateRegEx(this)' >
				&nbsp; <img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('report_date');" border="0"><img src='../../eCommon/images/mandatory.gif'>
		</td>
	</tr>
	<tr></tr>
	<tr>
		<td  class="label" width="20%"><fmt:message key="eBL.From.label" bundle="${bl_labels}"/> <fmt:message key="eBL.CASH_COUNTER.label" bundle="${bl_labels}"/></td>
		<td  class="fields" width="30%">
			<input type="text" name="fm_cash_counter1" id="fm_cash_counter1" id="fm_cash_counter1"  size="20"  maxlength="20" onClick="mand_fld();" onBlur="ChangeUpperCase( this );if(this.value!=''){ counterLookup_fm();validcashcount(); }else { fm_cash_counter.value =''; fm_cash_counter1.value='';}"  >	
			<input type='button' class='button' name="cashcounterbut" id="cashcounterbut" value='?' onClick="if(mand_fld()){counterLookup_fm();validcashcount();}"  '/>	
			<input type="hidden" name="fm_cash_counter" id="fm_cash_counter"	 		id="fm_cash_counter"		value=""> 					
		</td>
		
		<td  class="label" width="20%"><fmt:message key="eBL.To.label" bundle="${bl_labels}"/> <fmt:message key="eBL.CASH_COUNTER.label" bundle="${bl_labels}"/></td>
		<td  class="fields" width="30%">
			<input type="text" name="to_cash_counter1" id="to_cash_counter1" id="to_cash_counter1"  size="20"  maxlength="20" onClick="mand_fld();" onBlur="ChangeUpperCase( this );if(this.value!=''){ counterLookup();validcashcount();} else { to_cash_counter.value ='';to_cash_counter1.value ='';}"  >	
			<input type='button' class='button' name="cashcounterbut1" id="cashcounterbut1" value='?' onClick="if(mand_fld()){counterLookup();validcashcount();}" />	
			<input type="hidden" name="to_cash_counter" id="to_cash_counter"	 		id="to_cash_counter"		value=""> 						
		</td>
	</tr>
	<tr>
		<td class="label" >
			<input type="checkbox" name="detail" id="detail"  id="detail" onclick="if(mand_fld()){include_detail();}else{document.getElementById("detail").checked=false;}" value="" align="right" />&nbsp;&nbsp;&nbsp;
			<fmt:message key="eBL.detail.label" bundle="${bl_labels}"/>
		</td>
		
		<td class="label" id="delv" name="delv" style='visibility:hidden'>
			<input type="checkbox" name="delivery" id="delivery"  id="delivery" onclick="if(mand_fld()){break_delivery();}" value="" align="centre" style='visibility:hidden'/>&nbsp;&nbsp;&nbsp;
			<fmt:message key="eBL.Breakdelform.label" bundle="${bl_labels}"/>
		</td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td align='right' width='18%'>
			<input type='button' class='BUTTON' value='Generate Report' onclick='run()'>
		</td>
	</tr>	
</table>
		<input type='hidden' name='locale' id='locale' id='locale' value="<%=locale%>" >
		<input type='hidden' name='facilityId' id='facilityId' id='facilityId' value="<%=facilityId%>" >
		<input type='hidden' name='user' id='user' id='user' value="<%=strLoggedUser%>" >
	</form>
</body>
<%
	}
	catch(Exception e)  
	{
		e.printStackTrace();
		System.err.println("Exception in generatedaycolReport.jsp::"+e);
	}
%>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
		
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
</html>

