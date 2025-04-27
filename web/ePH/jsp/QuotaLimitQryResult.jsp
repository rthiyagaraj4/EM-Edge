
<%
/*

Date        Edit History    Name                Rev.Date    Rev.Name        Description
------------------------------------------------------------------------------------------------------------------------------
03/05/2023		TFS-43531  Raja Hanumanthu		04/05/2023	Ramesh Goli   ML-MMOH-CRF-1823
------------------------------------------------------------------------------------------------------------------------------
*/
%>



<%@ page import ="ePH.*,eCommon.Common.*,java.util.HashMap.*,java.util.ArrayList,java.lang.*,webbeans.eCommon.*,java.text.NumberFormat,java.text.DecimalFormat" contentType="text/html;charset=UTF-8"%>
 
 <%-- <%@ page import="java.sql.*,webbeans.eCommon.*,ePH.*,java.text.*,com.ehis.util.*" contentType="text/html;charset=UTF-8"%> 
  --%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
    <head>
		<title></title>
 <%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle			= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<link rel="stylesheet" type ="text/css" href="../../eST/html/IeStyle.css"></link>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/rowcolor.js"></script>
		<script language="Javascript" src="../../eST/js/StCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/QueryDrugPrice.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    </head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"> 
<%
	String slClassValue ="";
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
    String PatientDetails = request.getParameter("PatientDetails")==null?"":request.getParameter("PatientDetails");
   	String drug_name = request.getParameter("drug_name")==null?"":request.getParameter("drug_name");
   	String drug_code = request.getParameter("drug_code")==null?"":request.getParameter("drug_code");
    String OrderStatus = request.getParameter("OrderStatus")==null?"":request.getParameter("OrderStatus");
    String Prescription = request.getParameter("Prescription")==null?"":request.getParameter("Prescription");
    String OrderDateTime = request.getParameter("OrderDateTime")==null?"":request.getParameter("OrderDateTime");
    String splCode = request.getParameter("splCode")==null?"":request.getParameter("splCode");
    String p_ord_fm_date = request.getParameter("dt_from")==null?"":request.getParameter("dt_from");
	String p_ord_to_date = request.getParameter("dt_to")==null?"":request.getParameter("dt_to");
	String bean_id 						= "PH_QuotaLimitQryBean";
	String bean_name 					= "ePH.QuotaLimitQryBean";
	QuotaLimitQryBean bean				= (QuotaLimitQryBean)getBeanObject( bean_id,bean_name, request );
	bean.setLanguageId(locale);
	String ord[]		= request.getParameterValues("orderbycolumns");
	boolean searched	= request.getParameter( "searched" ) == null ? false : true  ;
	ArrayList finalResult=(ArrayList)bean.getDrugName(locale,patient_id,drug_code,splCode,p_ord_fm_date,p_ord_to_date);
	ArrayList displayFields = new ArrayList();
	displayFields.add("PATIENT_ID");
	displayFields.add("PATIENT_NAME");
	displayFields.add("DRUG_CODE");
	displayFields.add("order_status");
	displayFields.add("prescription_no");
	displayFields.add("ORDER_DATE_TIME");
	displayFields.add("SPECIALTY");		
try { 
        if(finalResult.size()>0){%>

	<form name="fromQuotaLimitQryResult" id="fromQuotaLimitQryResult">
					<table cellpadding=0 cellspacing=0 width="95%" align='center' border='0'>
						<tr>
							<td  class='label' style='text-align:right;'>
							<label id='lblPrev' style='display:none;'>
							<a href='javascript:goPrev();'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></label>&nbsp;
							<label id='lblNext' style='display:none;'><a href='javascript:goNext();' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></label>
							</td>
						</tr>
					</table>
					<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
						<tr>		 
							<td class="COLUMNHEADER" width="20%" style="text-align: center"><fmt:message key="Common.patientId.label"bundle="${common_labels}"/></td>
							<td class="COLUMNHEADER" width="20%" style="text-align: center"><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
							<td class="COLUMNHEADER" width="20%" style="text-align: center"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>
							<td class="COLUMNHEADER" width="10%" style="text-align: center"><fmt:message key="Common.OrderStatus.label" bundle="${common_labels}"/></td>
							<td class='columnheadercenter' nowrap width="20%" style="text-align: center"> <fmt:message key="Common.Prescription.label" bundle="${common_labels}"/> <fmt:message key="Common.no.label" bundle="${common_labels}"/></td>
							<td class="COLUMNHEADER" width="20%" style="text-align: center"><fmt:message key="Common.OrderDateTime.label" bundle="${common_labels}"/></td>
							<td class="COLUMNHEADER" width="20%" style="text-align: center"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>					
						</tr>
    <%    	for(int i=0;i<finalResult.size();i++){
        		ArrayList result =(ArrayList)finalResult.get(i);
			//String date	=	com.ehis.util.DateUtils.convertDate((String)result.get(5),"DMY","en",locale);
				
				%>
			<tr>
			<td style="text-align: left" class='<%=slClassValue %>'><%=result.get(0)%></td>
			<td style="text-align: left" class='<%=slClassValue %>'><%=result.get(1)%></td>
			<td style="text-align: left" class='<%=slClassValue %>'><%=result.get(2)%></td>
			<td style="text-align: left" class='<%=slClassValue %>'><%=result.get(3)%></td>
			<td style="text-align: left" class='<%=slClassValue %>'><%=result.get(4)%></td>
			<td style="text-align: left" class='<%=slClassValue %>'><%=result.get(5)%></td>
			<td style="text-align: left" class='<%=slClassValue %>'><%=result.get(6)%></td>
        	</tr>
        	<%
				}
				
			}	
			else {
%>
		<SCRIPT>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
			parent.f_price_detail.location.href="../../eCommon/html/blank.html";
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
		</SCRIPT>

<%
			 }	 
		} catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
		}
		%>
	</table>
   </form>
  
			<%putObjectInBean( bean_id,bean, request ); %>
</body>
</html>

