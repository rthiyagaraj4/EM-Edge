<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
	
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?	(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language="javascript" src="../js/ADRReporting.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>	
<%
	try{
		String	bean_id			=	"ADRReportBean" ;
		String	bean_name		=	"ePH.ADRReportBean";
		
   		ADRReportBean bean = (ADRReportBean)getBeanObject(bean_id,bean_name ,request) ;
		bean.setLanguageId(locale);
		String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String adr_no = request.getParameter("adr_no")==null?"":request.getParameter("adr_no");
		String adr_reported_date = request.getParameter("adr_reported_date")==null?"01/01/1900":request.getParameter("adr_reported_date");
		String adr_reported_date1 = request.getParameter("adr_reported_date1")==null?(String) DateUtils.getCurrentDate("DMY","en"):request.getParameter("adr_reported_date1");
		String ReportedBy = request.getParameter("ReportedBy")==null?"":request.getParameter("ReportedBy");
		String SignedBy = request.getParameter("SignedBy")==null?"":request.getParameter("SignedBy");
		String drug_code = request.getParameter("drug_code")==null?"":request.getParameter("drug_code");
		String type = request.getParameter("type")==null?"":request.getParameter("type");
		String status = request.getParameter("status")==null?"":request.getParameter("status");
		ArrayList records = bean.getAdrDetails(patient_id,adr_no,adr_reported_date,adr_reported_date1,ReportedBy,SignedBy,drug_code,status);

		String  classValue   = "";
		String ptntId = "";
		String adrNo  = "";
		String reprtdDate = "";
		String reprtdBy	  = "";
		String sgndBy	 = "";
		String suspctdDrug = "";
		String adrDesc	   = "";
		String weight      = "";
		String drugDisc	   = "";
		String orderId	   = "";
		String orderLineNum = "";
		String ethnic_grp = "";
		String patient_name = "";
		String facility_id= "";
		String facilityName ="";
		String adrStatus ="";// code added for HSA-CRF-0005[40601]--Start	
		String tempadrStatus ="";
		String sign_by_id ="";
		String status_label = ""; // code added for HSA-CRF-0005[40601]--End
	%>
		<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
			<form name="formAdrReportingQueryResult" id="formAdrReportingQueryResult">
				<table cellpadding="0" cellspacing="0"  border="1" width="99%" align="center">				

<%	

				if(records!=null && records.size() > 0){
				%>
				<tr>
					<th ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
					<th ><fmt:message key="ePH.ADRNo.label" bundle="${ph_labels}"/></th>
					<th ><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>					
					<th ><fmt:message key="Common.ReportedDate.label" bundle="${common_labels}"/></th>
					<th ><fmt:message key="Common.ReportedBy.label" bundle="${common_labels}"/></th>
					<th ><fmt:message key="ePH.SignedBy.label" bundle="${ph_labels}"/></th>
					<th ><fmt:message key="ePH.SuspectedDrug.label" bundle="${ph_labels}"/></th>
					<th ><fmt:message key="ePH.AdrType.label" bundle="${ph_labels}"/></th>
					<th ><fmt:message key="Common.status.label" bundle="${common_labels}"/></th><!--code added fro HSA-CRF-0005[40601] -->					
					<th ><fmt:message key="ePH.Remarks.label" bundle="${ph_labels}"/></th><!--code added fro HSA-CRF-0005[40601] -->					
				</tr>
				<%
					int	j	=0;
					for(int i=0; i<records.size(); i+=18){	//loop count increased from i+=14 to i+=16 added for 33963 and loop count increased from i+=16 to i+=18 for HSA-CRF-0005[40601] 
						if(j%2==0)
							classValue	=	"QRYEVEN";
						else
							classValue	=	"QRYODD";
							
						
						ptntId		=	(String)records.get(i);
						adrNo		=	(String)records.get(i+1);
						reprtdDate  =   (String)records.get(i+2);
						reprtdBy	=	(String)records.get(i+3);
						sgndBy		=	(String)records.get(i+4);
						suspctdDrug =	(String)records.get(i+5);
						weight		=   (String)records.get(i+7);
						if(weight == null) weight="";
						drugDisc		=   java.net.URLEncoder.encode((String)records.get(i+8),"UTF-8");
						orderId			=   (String)records.get(i+9);
						orderLineNum	=   (String)records.get(i+10);
						adrDesc			=   (String)records.get(i+11);
						ethnic_grp		=	(String)records.get(i+12);
						patient_name	=	(String)records.get(i+13);
						facility_id		=	(String)records.get(i+14); //code added for 33963
						facilityName	=	(String)records.get(i+15); //code added for 33963
						tempadrStatus	=	(String)records.get(i+16);// code added for HSA-CRF-0005[40601] --Start
						sign_by_id		=	(String)records.get(i+17);
																		
						if(tempadrStatus.equals("U") )
						     status_label=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Un-Verified.label","ph_labels");
						else if(tempadrStatus.equals("S"))
						     status_label=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Verified.label","ph_labels");						  
						else if(tempadrStatus.equals("C") )
						    status_label=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");						   
						else if(tempadrStatus.equals("E") )
							status_label=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.InError.label","ph_labels"); 
						else if(tempadrStatus.equals("") && !sign_by_id.equals("")  ){						
							status_label=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Verified.label","ph_labels");
							tempadrStatus ="S";
						}	
						else if(tempadrStatus.equals("") ){
							status_label=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Un-Verified.label","ph_labels");
							tempadrStatus ="U";
						} //code added for HSA-CRF-0005[40601] --End	
%>
						<tr>
<%
							if(type.equals("report")){
%>
								<td class="<%=classValue%>"><label style="cursor:pointer;color:blue" onClick="showReport('<%=adrNo%>','<%=ptntId%>');">&nbsp;<%=ptntId%>&nbsp;</label></td>
								<td class="<%=classValue%>"><label style="cursor:pointer;color:blue" onClick="showReport('<%=adrNo%>','<%=ptntId%>'); ">&nbsp;<%=adrNo%>&nbsp;</label></td>
<%
							}
							else{
%>
								<td class="<%=classValue%>"><label style="cursor:pointer;color:blue" onClick="showADR('<%=adrNo%>','<%=ptntId%>','<%=drugDisc%>','<%=sgndBy%>','<%=weight%>','<%=orderId%>','<%=orderLineNum%>','<%=suspctdDrug%>','<%=ethnic_grp%>','<%=patient_name%>','<%=facility_id%>','<%=tempadrStatus%>','<%=sign_by_id%>' );">&nbsp;<%=ptntId%>&nbsp;</label></td><!--facility_id added for 33963 and tempadrStatus,sign_by_id code added for HSA-CRF-0005[40601] -->	  							
																
								<td class="<%=classValue%>"><label style="cursor:pointer;color:blue" onClick="showADR('<%=adrNo%>','<%=ptntId%>','<%=drugDisc%>','<%=sgndBy%>','<%=weight%>','<%=orderId%>','<%=orderLineNum%>','<%=suspctdDrug%>','<%=ethnic_grp%>','<%=patient_name%>','<%=facility_id%>','<%=tempadrStatus%>','<%=sign_by_id%>'); ">&nbsp;<%=adrNo%>&nbsp;</label></td><!--facility_id added for 33963 and tempadrStatus,sign_by_id code added for HSA-CRF-0005[40601] -->
<%
							}
%>
							<td class="<%=classValue%>" nowrap>&nbsp;<%=facilityName%>&nbsp;</td> <!--facilityName added for 33963 -->
							<td class="<%=classValue%>" nowrap>&nbsp;<%=com.ehis.util.DateUtils.convertDate(reprtdDate,"DMYHM","en",locale)%>&nbsp;</td>
							<td class="<%=classValue%>" nowrap>&nbsp;<%=reprtdBy%>&nbsp;</td>
							<td class="<%=classValue%>" nowrap>&nbsp;<%=sgndBy%>&nbsp;</td>
							<td class="<%=classValue%>" nowrap>&nbsp;<%=java.net.URLDecoder.decode(drugDisc,"UTF-8")%>&nbsp;</td>
							<td class="<%=classValue%>">&nbsp;<%=adrDesc%></td>
							<td class="<%=classValue%>">&nbsp;<%=status_label%></td><!--code added fro HSA-CRF-0005[40601] -- Start -->
							<%
							   if(tempadrStatus.equals("C") || tempadrStatus.equals("E") ){//code added fro HSA-CRF-0005[40601]
							 %> <td>
								<a href="javascript:showQueryRemarks('<%=adrNo%>','<%=ptntId%>','<%=tempadrStatus%>','<%=facility_id%>')" class="label" id="drug_remarks" style="visibility:visible" title='Remarks'> <fmt:message key="ePH.Remarks.label" bundle="${ph_labels}"/> </a>							 
								</td>					 
							 <% } else{ %>								
								<td>&nbsp; </td>								
							 <% } %>		
							</td><!--code added fro HSA-CRF-0005[40601] -- End -->
						</tr>
<%	
						j++;
					}
					bean.setcanErrorIDTemp("");  
					bean.setcanErrorDate("");
					bean.setcanRemarks("");						
					bean.setcanReason("");
				}
				else {	
%>
					<script>
					alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA',"Common")); 
					window.close();
					</script>

				</table>
			</form>
		</body>
<%
		}
		putObjectInBean(bean_id,bean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
</html>

