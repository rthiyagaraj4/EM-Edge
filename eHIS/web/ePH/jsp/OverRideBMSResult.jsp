<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ page import="java.text.*,webbeans.eCommon.*" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
		<%
  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>		
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="javascript" src="../js/OverRideBMS.js"></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="formOverRideBMSResult" id="formOverRideBMSResult" >
<%
	//Search Criteria's from Query Criteria page
	//String prescribed="";
	//String first="";
	String dt_from		= request.getParameter("dt_from");
	String dt_to		= request.getParameter("dt_to");
	String disp_locn	= request.getParameter("disp_locn");    
	String disp_code	= request.getParameter("disp_code");    

	String from			= CommonBean.checkForNull(request.getParameter("from"));
	String to			= CommonBean.checkForNull(request.getParameter("to"));
	String called_frm	= request.getParameter("called_from");
	String bean_id				= "OverRideBMSBean";
	String bean_name			= "ePH.OverRideBMSBean";
	OverRideBMSBean bean		= (OverRideBMSBean)getBeanObject( bean_id, bean_name, request );
     bean.setLanguageId(localeName);

	 String facility_id			= (String) session.getValue("facility_id");
	ArrayList disp_dtls			= null;
	/*if(called_frm!=null && called_frm.equals("search")) {
		out.println("sandhya");
		bean.clear();
	}*/

	bean.setMode(CommonRepository.getCommonKeyValue("MODE_MODIFY"));

	ArrayList result			=	bean.getBMSRecords(dt_from,dt_to,disp_locn,from,to,disp_code);
	
	String classValue			=	"";
	String check_status			=	"";
	String chk_value			=	"";	
	HashMap record_status		=	bean.getRecordStatus();
	ArrayList record			=	bean.getReasonCode();	
	HashMap reas_values			=	 new HashMap();	
	String code					=	 "";
    String desc					=	 "";

	 int no_decimals =bean.getNoOfDecimals() ;
		String decimalStringFormat = "#.";
	// if Condition added for IN18681 to avoid displaying decimal point after the number  --01/02/2010--   shyampriya
		if(no_decimals == 0)
			decimalStringFormat = "#";
		for (int i=0;i<no_decimals;i++)
			{
				decimalStringFormat += "#";
			}

		 DecimalFormat dfToInteger = new DecimalFormat(decimalStringFormat);	
	
%>
<% 

if(result.size()<=1) {%>
	<script language="javascript">
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%
		return;
	}
%>

<!-- Display the Previous Next link -->
<% if( (result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) ) && ( !( ((String) result.get(0)).equals("")) )){
%>
	<table cellpadding=0 cellspacing=0 align="center" id="nav_table">
	<tr>
	<td width="80%" class="white">&nbsp;</td>
	<td width="20%" class="white">&nbsp;
<%
	// For display the previous/next link
	out.println(result.get(0));
	
%>
	</td></tr>
	</table>
<% } %>


<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
	<th width="10%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
	<th width="25%"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
	<th width="25%"><fmt:message key="ePH.PrescribedDrug.label" bundle="${ph_labels}"/></th>
	<th width="8%" colspan="2"><fmt:message key="ePH.PrescribedQuantity.label" bundle="${ph_labels}"/></th>
	<th width="8%" colspan="2"><fmt:message key="ePH.DispenseQuantity.label" bundle="${ph_labels}"/></th>
	<th width="8%" colspan="2"><fmt:message key="ePH.BalanceQuantity.label" bundle="${ph_labels}"/></th>
	<th width="11%"><fmt:message key="ePH.DeliveredDate/By.label" bundle="${ph_labels}"/></th>
	<th><fmt:message key="Common.reason.label" bundle="${common_labels}"/></th>
	<% int rec_count	=	1;
	 
		for(int i=0; i<result.size(); i+=15) {
		

		if(rec_count%2==0)
			classValue = "QRYEVENSMALL";
		else
			classValue = "QRYODDSMALL";

		if(i==0) ++i;

		check_status		=	"";
		chk_value			=	"N";
		String order_id		=(String)result.get(i);
	    String ord_line_no	=(String)result.get(i+1);
	
		if(record_status.containsKey((String)result.get(i)+(String)result.get(i+1)) && ((String)record_status.get((String)result.get(i)+(String)result.get(i+1))).equals("Y") ) {
			check_status	=	"checked";
			chk_value		=	"Y";
		} 
		if( ((String)result.get(i+14)).equals("N") )
			classValue		= "FORMULARY";


	%>
	<tr>
		<td class="<%=classValue%>"><%=(String)result.get(i+2)%>&nbsp;</td>
		<td class="<%=classValue%>"><%=(String)result.get(i+3)%>&nbsp;</td>
		<td class="<%=classValue%>"><%=(String)result.get(i+4)%>
			<%
			if( result.get(i+8)!=null && !((String)result.get(i+8)).equals("")){
				 disp_dtls			= (ArrayList)bean.getDispDetails(order_id,ord_line_no);
					for(int j=0; j<disp_dtls.size(); j+=3){
				
				%>					
				<br><label style="color:red">&nbsp;&nbsp;<%=(String)disp_dtls.get(j)%></label>

				<% }
			} %>
		</td>
<%

			String pres_qty = (String)result.get(i+5);
			if(pres_qty!=null && !pres_qty.equals(""))
				pres_qty = dfToInteger.format(Double.parseDouble(pres_qty));
			

			String disp_qty = (String)result.get(i+7);
			if(disp_qty!=null && !disp_qty.equals(""))
				disp_qty = dfToInteger.format(Double.parseDouble(disp_qty));
		
				
%>
		<td class="<%=classValue%>"><%=pres_qty%>&nbsp;</td>
		
		<td class="<%=classValue%>"nowrap><%=bean.getUomDisplay(facility_id,result.get(i+6).toString())%>&nbsp;</td>
		<td class="<%=classValue%>"><%=disp_qty%>
		
		<%
				
			if( result.get(i+8)!=null && !((String)result.get(i+8)).equals("")){
		
					for(int k=0; k<disp_dtls.size(); k+=3){
				%>	

			<br>
			<label style="color:red"><%=(String)disp_dtls.get(k+1)%></label>
		

				<% }
			}
			else if((String)result.get(i+7) == null || (String)result.get(i+7) == "")
			{
	%>
	&nbsp;
	<%
			}
			
			%>
		&nbsp;</td>		

		<td class="<%=classValue%>"nowrap><%=bean.getUomDisplay(facility_id,result.get(i+10).toString())%> <!-- changed CRF-749-->

		
<%
			if( result.get(i+8)!=null && !((String)result.get(i+8)).equals("")){
					for(int k=0; k<disp_dtls.size(); k+=3){
				%>	

			<br>
		<!-- Calling Bean.get UOM display for alternate drugs dispensing unit regarding incident num:25317 on 3/DEC/2010==By Sandhya -->	
		<!-- <label style="color:red"><%=(String)disp_dtls.get(k+2)%></label> -->
		<label style="color:red"><%=bean.getUomDisplay(facility_id,disp_dtls.get(k+2).toString())%></label>

				<% }
			} disp_dtls			= new ArrayList();%>
		&nbsp;</td>
<%
			String bal_qty = (String)result.get(i+9);
			if(bal_qty!=null && !bal_qty.equals(""))
				bal_qty = dfToInteger.format(Double.parseDouble(bal_qty));
		
%>
		<td class="<%=classValue%>"><%=bal_qty%>&nbsp;</td>
		<td class="<%=classValue%>"nowrap><%=bean.getUomDisplay(facility_id,result.get(i+6).toString())%>&nbsp;</td>
		<td class="<%=classValue%>"><%=(String)result.get(i+11)%>&nbsp;</td>	
		<td class="<%=classValue%>" align="center">
			
		<select name="chk_<%=(String)result.get(i)+(String)result.get(i+1)%>" id="chk_<%=(String)result.get(i)+(String)result.get(i+1)%>">	
			<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
			<%  
				for(int j=0; j<record.size(); j++)			
				{
					reas_values  = (HashMap)record.get(j);
					code = (String)reas_values.get("code");
                    desc = (String)reas_values.get("desc");
   			%>
            <OPTION value="<%=code%>"><%=desc%></OPTION><%
			}
			%>
			</select>

		</td>



	</tr>
    <%	rec_count++;
			} 
	%>
</table>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="mode" id="mode" value="<%=bean.getMode()%>">
<input type="hidden" name="from" id="from" value="<%=from%>">
<input type="hidden" name="to" id="to" value="<%=to%>">
<input type="hidden" name="dt_from" id="dt_from" value="<%=dt_from%>">
<input type="hidden" name="dt_to" id="dt_to" value="<%=dt_to%>">
<input type="hidden" name="disp_locn" id="disp_locn" value="<%=disp_locn%>">
<input type="hidden" name="chk_" id="chk_" value="<%=rec_count%>">
<input type="hidden" name="disp_code" id="disp_code" value="<%=disp_code%>">
</form>
</body>
</html>

<%
putObjectInBean(bean_id,bean,request);
%>

