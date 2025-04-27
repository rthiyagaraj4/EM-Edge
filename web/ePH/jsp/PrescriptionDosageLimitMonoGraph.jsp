<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>

<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
/*

--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
26/07/2019      IN070451		    B Haribabu  26/07/2019       Manickam               ML-MMOH-CRF-1408
07/08/2019      IN:071108		    B Haribabu                                          ML-MMOH-CRF-1408
07/08/2019      IN:071119		    B Haribabu                                          ML-MMOH-CRF-1408
09/08/2019      IN070605		 prathyusha  MMS-KH-CRF-0028
--------------------------------------------------------------------------------------------------------------
*/

String drug_desc	=	request.getParameter("drug_desc"); 
String mono_graph	=	request.getParameter("mono_graph");
System.out.println("for monograph"+mono_graph);
mono_graph = java.net.URLDecoder.decode(mono_graph,"UTF-8");
String daily_dose	=	request.getParameter("daily_dose");
String unit_dose	=	request.getParameter("unit_dose");
String min_daily_dose=	request.getParameter("min_daily_dose");
String min_unit_dose=	request.getParameter("min_unit_dose");
String dosage_unit =	request.getParameter("dosage_unit");
String dosage_std  =	request.getParameter("dosage_std")==null?"":request.getParameter("dosage_std");
String dose_unit_desc = request.getParameter("dose_unit_desc")==null?"":request.getParameter("dose_unit_desc"); // Added for ML-MMOH-SCF-0633 [IN:063271]
 //Added for IN:070451 start
String max_daily_ceeling_dose=	request.getParameter("max_daily_ceeling_dose")==null?"":request.getParameter("max_daily_ceeling_dose");//Modified for IN:071108
String min_daily_ceeling_dose=	request.getParameter("min_daily_ceeling_dose")==null?"":request.getParameter("min_daily_ceeling_dose");//Modified for IN:071108
String max_unit_ceeling_dose=	request.getParameter("max_unit_ceeling_dose")==null?"":request.getParameter("max_unit_ceeling_dose");//Modified for IN:071108
String min_unit_ceeling_dose=	request.getParameter("min_unit_ceeling_dose")==null?"":request.getParameter("min_unit_ceeling_dose");//Modified for IN:071108
String dose_unit_desc1 =request.getParameter("dose_unit_desc1")==null?"":request.getParameter("dose_unit_desc1");//Modified for IN:071108
//Added for IN:070451 end
String order_id = request.getParameter("order_id")==null?"":request.getParameter("order_id");//added for IN070605
String order_line_no = request.getParameter("order_line_no")==null?"":request.getParameter("order_line_no");//added for IN070605
String allergy_cnt = request.getParameter("allergy_cnt")==null?"":request.getParameter("allergy_cnt");//added for IN070605
String disp_medication = request.getParameter("disp_medication")==null?"":request.getParameter("disp_medication");//added for IN070605

boolean flag       =     true;
if(mono_graph!=null && mono_graph.equals(".")) 
	mono_graph="";
if((daily_dose.equals("") && max_daily_ceeling_dose.equals("") )&&(unit_dose.equals("") && max_unit_ceeling_dose.equals("") )&&(min_daily_dose.equals("") && min_daily_ceeling_dose.equals("") )&&(min_unit_dose.equals("") && min_unit_ceeling_dose.equals("") )){//Modified for IN:071119
    flag=false;
}
%>
<html>
<head><title><fmt:message key="ePH.DrugDosageLimitDetails.label" bundle="${ph_labels}"/></title>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale = (String) session.getAttribute("LOCALE");
		

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/PrescriptionTest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="prescription_dosage_monograph" id="prescription_dosage_monograph"><!-- form added for IN070605 -->

<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0">
  <% if(flag){
  %>
				<tr><td class="label" colspan="4" width="100%"  ><b><%=drug_desc%></b><input type="hidden" name="dummy" id="dummy"></td></tr>
				<tr>
					<td class="label" width="18%"  nowrap><fmt:message key="ePH.StandardUnitDose.label" bundle="${ph_labels}"/>  :</td>
					<td class="label" width="15%"  nowrap><b><%=dosage_std%> <%=dose_unit_desc%></b></td> <!-- dosage_unit changed to dose_unit_desc for ML-MMOH-SCF-0633 [IN:063271] -->
					<td class="label" width="15%"  nowrap>&nbsp</td>
					<td class="label" width="15%"  nowrap><b>&nbsp</b></td>
				</tr>
				<tr>	
				<!-- Modified for IN:070451 start -->
					<td class="label" width="18%"  nowrap><fmt:message key="ePH.MinimumUnitDose.label" bundle="${ph_labels}"/>  :</td>
					<%if(!min_unit_dose.equals("")){ %>
					<td class="label" width="15%"  nowrap><b><%=min_unit_dose%> <%=dose_unit_desc%></b></td> <!-- dosage_unit changed to dose_unit_desc for ML-MMOH-SCF-0633 [IN:063271] -->
					<%} else{ %>
					<td class="label" width="15%"  nowrap><b><%=min_unit_dose%> </b></td>
					<%} %>
					<td class="label" width="15%"  nowrap><fmt:message key="ePH.MaximumUnitDose.label" bundle="${ph_labels}"/>  :</td>
					<%if(!unit_dose.equals("")){ %>
					<td class="label" width="15%"  nowrap><b><%=unit_dose%> <%=dose_unit_desc%></b></td> <!-- dosage_unit changed to dose_unit_desc for ML-MMOH-SCF-0633 [IN:063271] -->
				    <%} else{ %>
					<td class="label" width="15%"  nowrap><b><%=unit_dose%> </b></td>
					<%} %>
				    <!-- Modified for IN:070451 end -->
				</tr>
				<tr>	
				<!-- Added for IN:070451 start -->
					<td class="label" width="18%"  nowrap><fmt:message key="ePH.MinimumCellingUnitDose.label" bundle="${ph_labels}"/>  :</td>
					<%if(!min_unit_ceeling_dose.equals("")){ %>
					<td class="label" width="15%"  nowrap><b><%=min_unit_ceeling_dose%> <%=dose_unit_desc1%></b></td> <!-- Added for IN:070451 -->
					<%} else{ %>
					<td class="label" width="15%"  nowrap><b><%=min_unit_ceeling_dose%> </b></td>
					<%} %>
					<td class="label" width="15%"  nowrap><fmt:message key="ePH.MaximumCellingUnitDose.label" bundle="${ph_labels}"/>  :</td>
					<%if(!max_unit_ceeling_dose.equals("")){ %>
					<td class="label" width="15%"  nowrap><b><%=max_unit_ceeling_dose%> <%=dose_unit_desc1%></b></td>
					<%} else{ %>
					<td class="label" width="15%"  nowrap><b><%=max_unit_ceeling_dose%></b></td>
					<%} %> 
				
				</tr>
				<tr>
				<!-- Added for IN:070451 end -->
				<!-- Modified for IN:070451 start -->
					<td class="label" width="18%"   nowrap><fmt:message key="ePH.MinimumDailyDose.label" bundle="${ph_labels}"/> :</td>
					<%if(!min_daily_dose.equals("")){ %>
					<td class="label" width="15%"  nowrap><b><%=min_daily_dose%> <%=dose_unit_desc%></b></td> <!-- dosage_unit changed to dose_unit_desc for ML-MMOH-SCF-0633 [IN:063271] -->
					<%} else{ %>
					<td class="label" width="15%"  nowrap><b><%=min_daily_dose%></b></td>
					<%} %> 
					<td class="label" width="15%"  nowrap><fmt:message key="ePH.MaximumDailyDose.label" bundle="${ph_labels}"/> :</td>
					<%if(!daily_dose.equals("")){ %>
					<td class="label" width="15%"  nowrap><b><%=daily_dose%> <%=dose_unit_desc%></b></td> <!-- dosage_unit changed to dose_unit_desc for ML-MMOH-SCF-0633 [IN:063271] -->	
					<%} else{ %>
					<td class="label" width="15%"  nowrap><b><%=daily_dose%></b></td>
					<%} %> 
					<!-- Modified for IN:070451 end -->
					<!-- Added for IN:070451 start-->			
				</tr>
				<tr>
					<td class="label" width="18%"   nowrap><fmt:message key="ePH.MinimumCellingDailyDose.label" bundle="${ph_labels}"/> :</td>
					<%if(!min_daily_ceeling_dose.equals("")){ %>
					<td class="label" width="15%"  nowrap><b><%=min_daily_ceeling_dose%> <%=dose_unit_desc1%></b></td>
					<%} else{ %>
					<td class="label" width="15%"  nowrap><b><%=min_daily_ceeling_dose%></b></td>
					<%} %> 
					<td class="label" width="15%"  nowrap><fmt:message key="ePH.MaximumCellingDailyDose.label" bundle="${ph_labels}"/> :</td>
					<%if(!max_daily_ceeling_dose.equals("")){ %>
					<td class="label" width="15%"  nowrap><b><%=max_daily_ceeling_dose%> <%=dose_unit_desc1%></b></td>
					<%} else{ %>
					<td class="label" width="15%"  nowrap><b><%=max_daily_ceeling_dose%> </b></td>
					<%} %>
					
					<!-- Added for IN:070451 end -->				
				</tr>
				<tr><td   class="label" colspan="4"><textarea cols="70" rows="9" name="order_remarks" readonly><%=mono_graph%></textarea></td>		
				</tr>
				<tr>
				<%if(disp_medication.equals("disp_medication")){//added for IN070605 %>
				<td class="label" colspan="2" width="100%"  ><input type="button" class="button" value="Review/Approve" onclick="drugindication_remarks_disp('doselimit','<%=order_id%>','<%=order_line_no%>','<%=allergy_cnt%>')"></input></td>
				<%} %>
				<td class="label" colspan="2" width="100%"  ><input type="button" class="button" value="Close" onclick="savedrugIndicationRemarksClose(document.prescription_dosage_monograph.ReviewRemarks);parent.window.close()"></input></td>
				
				</tr>
		<%}else{%>
               <tr>
				  <td class="label" width="18%"  ><fmt:message key="ePH.EXT_DOSAGE_CHK_PERFORMED.label" bundle="${ph_labels}"/></td>
				</tr>
		<%}%>
</table>

<input type='hidden' name='ReviewRemarks' id='ReviewRemarks' value=''><!--added for IN070605 -->
</form>
</body>
</html>

