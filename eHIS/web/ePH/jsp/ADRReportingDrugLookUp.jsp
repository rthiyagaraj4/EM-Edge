<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%@ page import="java.text.*,webbeans.eCommon.*" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<title> <fmt:message key="ePH.DrugSearch.label" bundle="${ph_labels}"/></title>
	<head>
<% 
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language="javascript" src="../js/ADRReporting.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<!-- <body> -->
	<body onMouseDown="" onKeyDown="lockKey()">
  <%	
		String	bean_id			=	"ADRReportBean" ;
		String	bean_name		=	"ePH.ADRReportBean";

		ADRReportBean bean = (ADRReportBean)getBeanObject(bean_id,bean_name ,request);
		bean.setLanguageId(locale);
		String patient_id=request.getParameter("patient_id");
		String search_by=request.getParameter("search_by");
		String search_str=request.getParameter("search_str");
		ArrayList records	=new ArrayList();
       	records=(ArrayList)bean.getDrugNames(patient_id,search_by,search_str);
       	String classvalue="";
  %>	
		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
			<tr></tr>
			<tr>
				<th width="13%"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></th>
				<th ><fmt:message key="Common.Route.label" bundle="${common_labels}"/></th>
				<th ><fmt:message key="ePH.DosageDetail.label" bundle="${ph_labels}"/></th>
				<th ><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></th>
				<th ><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></th>
				<th ><fmt:message key="ePH.DispenseQuantity.label" bundle="${ph_labels}"/></th>
				<th ><fmt:message key="ePH.AdminQuantity.label" bundle="${ph_labels}"/></th>
				<th ><fmt:message key="ePH.PractionerName.label" bundle="${ph_labels}"/></th>
				<th ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
			</tr>
<%	 
			int no_decimals =bean.getNoOfDecimals() ;
			String decimalStringFormat = "#.";
			// if Condition added for IN18681 to avoid displaying decimal point after the number  --01/02/2010--   shyampriya
			if(no_decimals == 0)
				decimalStringFormat = "#"; 
			for (int i=0;i<no_decimals;i++){
				decimalStringFormat += "#";
			}

			DecimalFormat dfToInteger = new DecimalFormat(decimalStringFormat);	

			String order_id="";
			String order_line_no="";
			String drug_code="";
			String drug_name="";
			String route_color =  "", backgrndColor="", fntColor="" ;// added for CRF RUT-CRF-0034.1[IN:037389]
			String drug_name1 ="";
			int rowCount		=	0;
			if(records.size()!=0) { 
				for(int i=0; i<records.size(); i=i+13){ //changed from i+12 to i+13 for CRF RUT-CRF-0034.1[IN:037389]-start
					if ( rowCount % 2 == 0 )
						classvalue = "QRYODD" ;
					else
						classvalue = "QRYEVEN" ;

					order_id	=  (String)records.get(i);	
					order_line_no	=  (String)records.get(i+1);
					drug_code=(String)records.get(i+2);
					drug_name =	  (String)records.get(i+3);
					drug_name1 =	  (String)records.get(i+3);
					if(!drug_name.equals("")&&drug_name!=null){
						drug_name=drug_name.replaceAll(" ","%20");
						drug_name=	java.net.URLEncoder.encode(drug_name,"UTF-8");
						drug_name=drug_name.replaceAll("%2520","%20");
					}
					backgrndColor                =  "";
					fntColor                     =  "";
					route_color=(String)records.get(i+12); // added for CRF RUT-CRF-0034.1[IN:037389]-start
					if(route_color!= null && !route_color.equals("")){
						if(route_color.length()==12){
							fntColor= route_color.substring(0, 6);
							backgrndColor= route_color.substring(6, 12);
						}
					}	// added for CRF RUT-CRF-0034.1[IN:037389]-end
%>
					<tr> 
						 <td class="<%=classvalue%>"><label onClick="selectDrug('<%=order_id%>','<%=order_line_no%>','<%=drug_code%>','<%= drug_name%>')"style="color:blue;cursor:pointer">&nbsp<%=drug_name1%></label></td>
						 <td class="<%=classvalue%>" style='color:<%=fntColor%>;background-color:<%=backgrndColor%>;'>&nbsp<%=(String)records.get(i+4)%></td>
						 <td class="<%=classvalue%>">&nbsp<%=(String)records.get(i+5)%></td>
						 <td class="<%=classvalue%>">&nbsp<%=com.ehis.util.DateUtils.convertDate((String)records.get(i+6),"DMYHM","en",locale)%></td> 
						 <td class="<%=classvalue%>">&nbsp<%=com.ehis.util.DateUtils.convertDate((String)records.get(i+7),"DMYHM","en",locale)%></td>
<%
						//Code added for decimal crf 537.12   -- 21-Jan -2010 --   shyampriya
						String disp_qty = (String)records.get(i+8);
						if(disp_qty!=null && !disp_qty.equals(""))
							disp_qty = dfToInteger.format(Double.parseDouble(disp_qty));
					
						String admin_qty = (String)records.get(i+9);
						if(admin_qty!=null && !admin_qty.equals("") )
							admin_qty = dfToInteger.format(Double.parseDouble(admin_qty));
%>
						 <td class="<%=classvalue%>">&nbsp;<%=disp_qty%></td>
						 <td class="<%=classvalue%>">&nbsp;<%=admin_qty%></td>

						 <td class="<%=classvalue%>">&nbsp;<%=(String)records.get(i+10)%></td> 
						 <td class="<%=classvalue%>">&nbsp;<%=(String)records.get(i+11)%></td>
					 </tr>
<%	
					rowCount++;
				}
			}
			else {	
%>
				<script>
					alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA',"Common")); 
					//window.close();
				</script>
<%
			}
			putObjectInBean(bean_id,bean,request);
%>
		</table> 
	</body>
</html>

