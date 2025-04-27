<!DOCTYPE html>
<HTML>
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXI.XIDBAdapter"%>
<script language="javascript">

</script>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%  String locale = ((String)session.getAttribute("LOCALE"));	%>
<% 
Connection con=null;
Statement stmt = null;
ResultSet rs  = null;

String readOnly = "false";
%>
<HEAD>
<%											 
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXI/js/Validate.js" ></script>
<script language="javascript" src="../../eXI/js/QueryTransaction.js" ></script> 
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script> 

<script language="JavaScript">

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' >

<%

String finalized_by_id = "";
String finalized_by_desc = "";
String entered_by_id  = "";
String entered_by_desc  = "";
String from_date   = "";
String to_date		= "";
String doc_no		= "";
String item_code	= "";
String item_desc	= "";
String store_code	= "";
String store_desc	= "";
String doc_type	= "";
String status			= "";
String mode			= "";

mode				=	request.getParameter("mode");

	try{
		con=ConnectionManager.getConnection();
	}
	catch(Exception ex ){
		System.out.println("ERROR :"+ex.toString());
	}
	String Sysdate 				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);	
%>

<form name="transaction_status_form" id="transaction_status_form" target='messageFrame' method='post' >
<table cellspacing=0 cellpadding=3 width='100%' align=center border=0>
<tr>
	<td width='15%'></td>
	<td width='35%'></td>
	<td width='20%'></td>
	<td width='50%'></td>
</tr>

<tr>
	<td class=label ><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td> 
	<td class='fields'>
	<select name ='doc_type' <%=readOnly%> onChange='changeStatus(this);' >
<!--		<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option> -->
		<option value='RP' <%=doc_type.equals("RP")?"selected":""%>><fmt:message key="eXI.Requisitions.Label" bundle="${xi_labels}"/></option>
	<!--	<option value='RNP' <%=doc_type.equals("RNP")?"selected":""%>><fmt:message key="eXI.ReqNotProc.Label" bundle="${xi_labels}"/></option> -->
		<option value='GRO' <%=doc_type.equals("GRO")?"selected":""%>><fmt:message key="eXI.GoodsRecWOrg.Label" bundle="${xi_labels}"/></option>
		<option value='GR' <%=doc_type.equals("GR")?"selected":""%>><fmt:message key="eXI.GoodsRecWithoutOrg.Label" bundle="${xi_labels}"/></option>
		<option value='GRNR' <%=doc_type.equals("GRNR")?"selected":""%>><fmt:message key="eXI.GRNReturns.Label" bundle="${xi_labels}"/></option>
		<option value='NR' <%=doc_type.equals("NR")?"selected":""%>><fmt:message key="eXI.NormalReturns.Label" bundle="${xi_labels}"/></option>
	</select>

<!--	<img src='../../eCommon/images/mandatory.gif' align=middle> --> </td> 

	<td class=label ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td> 
	<td class='fields'>
	<select name ='status' <%=readOnly%>  >
		<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
		<option value='P' <%=status.equals("P")?"selected":""%>><fmt:message key="Common.Finalized.label" bundle="${common_labels}"/></option> 
<!--		<option value='E' <%=status.equals("U")?"selected":""%>><fmt:message key="Common.Entered.label" bundle="${common_labels}"/></option> -->
		<option value='NPE' <%=status.equals("NPE")?"selected":""%>><fmt:message key="eXI.NotProcByExtSys.Label" bundle="${xi_labels}"/></option>
		<option value='A' <%=status.equals("A")?"selected":""%>><fmt:message key="Common.Approved.label" bundle="${common_labels}"/></option>
		<option value='X' <%=status.equals("X")?"selected":""%>><fmt:message key="eXI.UnapprOrCancel.Label" bundle="${xi_labels}"/></option>
<!--		<option value='R' <%=status.equals("R")?"selected":""%>><fmt:message key="Common.received.label" bundle="${common_labels}"/></option>  -->
<!--		<option value='NPI' <%=status.equals("E")?"selected":""%>><fmt:message key="eXI.NotProcByIBA.Label" bundle="${xi_labels}"/></option> -->
	</select>
<!--	<img src='../../eCommon/images/mandatory.gif' align=middle> --> </td>
</tr>

<tr>
	<td class=label ><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
	<td align=left>
		<input type="text" name="store_code" id="store_code" size=10 onBlur=''  value="<%=XIDBAdapter.checkNull(store_code)%>">
		<input type=text id="store_desc"  name =store_desc size=20 value='<%=XIDBAdapter.checkNull(store_desc)%>'> <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=storeCodeSearch value='?'    onClick='searchStoreCode();'>
<!--		<img src='../../eCommon/images/mandatory.gif' align=middle> -->
	</td>
	<td class=label ><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
	<td align=left>
		<input type="text" name="item_code" id="item_code" size=10 onBlur=''  value="<%=XIDBAdapter.checkNull(item_code)%>">
		<input type=text id="item_desc"  name =item_desc size=20 value='<%=XIDBAdapter.checkNull(item_desc)%>'> <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=itemCodeSearch value='?'    onClick='searchItemCode();'>
<!--		<img src='../../eCommon/images/mandatory.gif' align=middle> -->
	</td>
</tr>

<tr>
	<td class=label align=left><fmt:message key="Common.Organization.label" bundle="${common_labels}"/></td>
	
	<td	align=left>
	<select name ='org_id'  >
		<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>

	<%
	
Statement stmt1=null;
ResultSet rs1=null;
try
{

		String sql1="SELECT distinct XI_ORGANIZATION_ID FROM XI_ITEM ";
		stmt1=con.createStatement();
		rs1=stmt1.executeQuery(sql1);

		while(rs1.next())
		{
//System.out.println("rs.getString(1)"+rs1.getString(1));

			%>



<option value='<%=rs1.getString(1)%>'><%=rs1.getString(1)%></option>
<%
		}
%>

</select></td>
<%
}
catch(Exception e)
{
	 
 System.out.println("Error in calling getconnection method of FilteringRuleApplicationsearch.jsp  :"+e.toString());
		e.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      }
finally{
			
			if(rs1!=null)rs1.close();
	        if(stmt1!=null)stmt1.close();			
			ConnectionManager.returnConnection(con);
}
	%>

	<td class=label width='10%'><fmt:message key="Common.DocumentNumber.label" bundle="${common_labels}"/></td>
	<td align=left><input type=text name=doc_no size=20 <%=readOnly%> value='<%=doc_no%>' >
<!--	<img src='../../eCommon/images/mandatory.gif' align=middle> --> </td> 
</tr>

<tr>
	<td class=label ><fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/></td>
	<td class='fields' ><input type=text size=12 maxlength="12"  value='<%=from_date%>' name=from_date id=from_date onBlur="DateCheck(sysdate,from_date);validate_date(this,'TO_DATE_LESS_FROM')"> <input type='image' name=showcalndr id="showcalndr" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('from_date','dd/mm/y');"  > <!-- <img src='../../eCommon/images/mandatory.gif' align=middle> --></td>
	<td class=label ><fmt:message key="Common.DateTo.label" bundle="${common_labels}"/></td>
	<td class='fields' ><input type=text size=12 maxlength="12"  value='<%=to_date%>' name=to_date id=to_date onBlur="DateCheck(sysdate,to_date);validate_date(this,'TO_DATE_LESS_FROM')"> <input type='image' name=showcalndr id="showcalndr" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('to_date','dd/mm/y');"  > <!-- <img src='../../eCommon/images/mandatory.gif' align=middle> --> </td>
</tr>

<tr>
	<td class=label ><fmt:message key="eXI.FinalizedBy.Label" bundle="${xi_labels}"/></td>
	<td align=left>
		<input type="text" name="finalized_by_id" id="finalized_by_id" size=10 onBlur=''  value="<%=XIDBAdapter.checkNull(finalized_by_id)%>">
		<input type=text id="finalized_by_desc"  name =finalized_by_desc size=20 value='<%=XIDBAdapter.checkNull(finalized_by_desc)%>'> <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=finalizedBySearch value='?'    onClick='searchFinalizedBy();'>

	<td class=label ><fmt:message key="Common.EnteredBy.label" bundle="${common_labels}"/></td>
	<td align=left>
		<input type="text" name="entered_by_id" id="entered_by_id" size=10 onBlur=''  value="<%=XIDBAdapter.checkNull(entered_by_id)%>">
		<input type=text id="entered_by_desc"  name ="entered_by_desc" size=20 value='<%=XIDBAdapter.checkNull(entered_by_desc)%>'> <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=enteredBySearch value='?'    onClick='searchEnteredBy();'>
   </td>

</tr>
<tr>
<td> </td> <td> </td> <td> </td>
	<td >
		<input class='button' type="button"  name='Search' id='Search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='funSearch()'>
	</td>
<tr>

<tr>
	<td width='15%'></td>
	<td width='35%'></td>
	<td width='20%'></td>
	<td width='50%'></td>
</tr>
</table>

<%
		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(con);
%>

<input type="hidden" name="act_mode" id="act_mode" value='<%=mode%>'>
<input type="hidden" name="sysdate" id="sysdate" value="<%=Sysdate%>">


</form>
</BODY>
</HTML> 

