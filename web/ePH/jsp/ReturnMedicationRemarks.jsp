<!DOCTYPE html>
 <!-- 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
10/08/2020	    IN73611             Shazana		MMS-DM-CRF-0174.4
--------------------------------------------------------------------------------------------------------------
-->
  
 
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper " %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
			request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
			String locale			= (String)session.getAttribute("LOCALE");
			String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
				<script language="JavaScript" src="../../eCommon/js/common.js"></script>
				<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
				<script language="JavaScript" src="../js/PhCommon.js"></script>
			   <!--  <script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
				<!-- <script language="JavaScript" src="../js/PhMessages.js"></script> -->
				<script language="JavaScript" src="../js/ReturnMedication.js"></script>
				<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			</head>
			<!--<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">-->
			<!-- <body> -->
			<body onMouseDown="" onKeyDown="lockKey()">
<%
			//Search Criteria's from Query Criteria page
			java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
			String bean_id		= "ReturnMedicationBean"+login_at_ws_no ; ;
			String bean_name	= "ePH.ReturnMedicationBean";
			ArrayList remarks=new ArrayList();

			/* Initialize Function specific start */
			ReturnMedicationBean bean = (ReturnMedicationBean)getBeanObject( bean_id,bean_name,request) ;
			bean.setLanguageId(locale);
			remarks=bean.getReturnRemarks();
			String facility_id					= (String) session.getValue("facility_id");
			String displocn					= (String) bean.getLoginDispLocnCode();
			String barcode_applicable=bean.getBarCodeflag(facility_id, displocn);//"Y";//Added for GHL-CRF-0413.8
			
			
			// FD-Bru-HIMS-CRF-091 Changes -- Added Flag Based Functionality for MutiFacility
			String FacilityFlag=bean.getFacility_Flag();
			String btnDisable="";
			if(FacilityFlag.equals("")){
				FacilityFlag="N";	
			}
			if(FacilityFlag.equals("Y"))
				btnDisable = "disabled";
			// FD-Bru-HIMS-CRF-091 Changes -- Added Flag Based Functionality for MutiFacility
%>
			<FORM name="FormReturnMedicationRemarks" id="FormReturnMedicationRemarks" id="FormReturnMedicationRemarks">
				<TABLE width="100%" align="left" cellpadding="0" cellspacing="0" border="1" >
					<TR>
						<TH colspan=2 width=100% align="center"  valign="center"><fmt:message key="Common.reason.label" bundle="${common_labels}"/><input type=checkbox style="width:0px">
						</th>
					</tr>
					<TR >
						<td   style="font-family:verdana;font-size:8pt;COLOR:navy;" width="34%"  class="QRYODD"> <fmt:message key="ePH.ReasonforReturn.label" bundle="${ph_labels}"/>&nbsp;</td>
						<TD   align="left" class="QRYODD" >
						<select name="ReturnRemarks" id="ReturnRemarks" id="ReturnRemarks">
<%//Modified for GHL-CRF-0412 start
					if (remarks.size()>0){
						if(remarks.size() == 2){
							%>							
							<option value="<%=remarks.get(0)%>"><%=remarks.get(1)%> </option>
<%						}
						else{
							%>	
								<option value="">&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
							<%
							for (int i=0;i<remarks.size();i=i+2){
%>
							<option value="<%=remarks.get(i)%>"><%=remarks.get(i+1)%> </option>
<%
						}
					}
					}

					else{
						%>	
						<option value="">&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>				
	<%				} //Modified for GHL-CRF-0412  end
%>
						</select>&nbsp;<img name="PhysicalLocMandatory" src="../../eCommon/images/mandatory.gif">
					</td>
				</tr>
				<!-- Added for GHL-CRF-413.8 start -->
				<%if(barcode_applicable.equals("Y")){ %>
				<tr><td   style="font-family:verdana;font-size:8pt;COLOR:navy;" width="34%"  class="QRYODD"><fmt:message key="eST.BarCodeId.label" bundle="${st_labels}"/></td>
				<!-- disp_locn_value  is added in value for GHL-CRF-0412 -->
				<td align="left" class="QRYODD" ><input type="text" style="text-align:right;background-color:#fde6d0;" name="barCodeId" id="barCodeId"  onkeydown="if (event.keyCode==13) {callBarcodeflg_1('<%=request.getQueryString()%>','<%=FacilityFlag %>');}" maxlength="100" size=80 >
				</td></tr><!--Modified for IN073611 increased size and maxlength from 50 to 100 -->	
				<%}%>
				<!-- Added for GHL-CRF-413.8 end -->
				<tr >
					<td colspan=2  align="right" class="QRYODD" >
						<input type="button" name="proceed" id="proceed" value="Proceed"  <%=btnDisable%> class="BUTTON"  id='<fmt:message key="Common.Proceed.label" bundle="${common_labels}"/>' onClick='callBatchDetails("<%=request.getQueryString()%>","<%=FacilityFlag %>");' >
					</TD>
				</TR>
			</TABLE>
			<input type="hidden" value="<%=barcode_applicable %>" name="barcode_applicable"><!-- Added for GHL-CRF-0413.8[IN063028] -->
			
					</FORM>
	</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>

