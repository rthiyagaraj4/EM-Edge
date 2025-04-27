<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title>
		</title>
<%
		request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
		String locale			= (String)session.getAttribute("LOCALE");
		String facilityId			= (String)session.getValue("facility_id");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
			<script language="JavaScript" src="../../eCommon/js/common.js"></script>
			<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language="JavaScript" src="../js/PhCommon.js"></script>
			 <script language="JavaScript" src="../js/WardReturn.js"></script>
			<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
			<script language='javascript' src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<script>

		async function getToStore(){
			var argumentArray  = new Array() ;
			var ToStore = document.FormWardReturnRemarks.ToStore.value;
			var afacility_id = document.FormWardReturnRemarks.facility_id.value;
			var alocale = document.FormWardReturnRemarks.locale.value;
			var retVal			= new String();

			var argumentArray	= new Array() ;
			var dataNameArray	= new Array() ;
			var dataValueArray	= new Array() ;
			var dataTypeArray	= new Array() ;

			var title = getLabel("Common.authorizedby.label","Common");
			//var sql = "select  DISP_LOCN_CODE code, SHORT_DESC description from ph_disp_locn_lang_vw where upper(disp_locn_code) like upper(?) and upper(short_desc) like upper(?) and IP_ALLOW_DRUG_RETURN_YN='Y' and FACILITY_ID='"+afacility_id+ "' and language_id= '"+alocale+"' order by short_desc"; //commented and added below sql for KDAH-SCF-0241 [IN:049299]
			var sql = "SELECT  distinct( a.disp_locn_code ) code,a.short_desc description FROM ph_disp_locn_lang_vw a, ph_disp_rights b WHERE UPPER (a.disp_locn_code) LIKE UPPER (?)  AND UPPER (a.short_desc) LIKE UPPER (?)  AND a.ip_allow_drug_return_yn = 'Y' AND a. FACILITY_ID='"+afacility_id+ "' and a.language_id= '"+alocale+"' and a.disp_locn_code = b.disp_locn_code and B.IP_ACCEPT_MEDN_RTN_YN = 'Y' and a.eff_status='E'ORDER BY short_desc";	 //ph_disp_rights & IP_ACCEPT_MEDN_RTN_YN added for KDAH-SCF-0241 [IN:049299]
		
			argumentArray[0]	= sql;
			argumentArray[1]	= dataNameArray ;
			argumentArray[2]	= dataValueArray ;
			argumentArray[3]	= dataTypeArray ;
			argumentArray[4]	= "1,2" ;
			argumentArray[5]	= ToStore ;
			argumentArray[6]	= DESC_LINK;
			argumentArray[7]	= DESC_CODE;
			
			var tit=getLabel('Common.ToStore.label','common');
			retVal = await CommonLookup( tit, argumentArray );

			if(retVal != null && retVal != "" ){
				var ret1=unescape(retVal);
				arr=ret1.split(",");
				document.forms[0].ToStoreCode.value=arr[0];
				document.forms[0].ToStore.value=arr[1];
			}
			else{
				document.forms[0].ToStoreCode.value="";
				document.forms[0].ToStore.value="";
			} 
		}
	</script>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
		//Search Criteria's from Query Criteria page
		java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
		String bean_id		= "WardReturnBean"+login_at_ws_no;
		String bean_name	= "ePH.WardReturnBean";
		ArrayList remarks=new ArrayList();

		/* Initialize Function specific start */
		WardReturnBean bean = (WardReturnBean)getBeanObject( bean_id,bean_name,request) ;
		bean.setLanguageId(locale);
		remarks=bean.getReturnRemarks();
		 
		String disp_locn_value =bean.getDisp_locn_value(); //Added in value for GHL-CRF-0412
		String disp_locn =bean.getDisp_locn(); //Added in value for GHL-CRF-0412
		bean.getScannedBatchDetails().clear(); // Added for GHL-CRF-0413.8
		bean.getscannedDetails().clear(); // Added for GHL-CRF-0413.8
%>
		<form name="FormWardReturnRemarks" id="FormWardReturnRemarks" id="FormWardReturnRemarks">
			<table width="100%" align="left" cellpadding="0" cellspacing="0" border="1" >
				<tr>
					<th colspan=2 width=100% align="center"  valign="center"><fmt:message key="Common.reason.label" bundle="${common_labels}"/><input type=checkbox style="width:0px">
					</th>
				</tr>
				<tr >
					<td   style="font-family:verdana;font-size:8pt;COLOR:navy;" width="34%"  class="QRYODD"> <fmt:message key="ePH.ReasonforReturn.label" bundle="${ph_labels}"/>&nbsp;
					</td>
					<td   align="left" class="QRYODD" >
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
	<%				} //Modified for GHL-CRF-0412 end
%>
				</select>&nbsp;<img name="PhysicalLocMandatory" src="../../eCommon/images/mandatory.gif">
				</td>
			</tr>
			<tr>	
				<td   style="font-family:verdana;font-size:8pt;COLOR:navy;" width="34%"  class="QRYODD"><fmt:message key="Common.ToStore.label" bundle="${common_labels}"/></td>
				<!-- disp_locn_value  is added in value for GHL-CRF-0412 -->
				<td align="left" class="QRYODD" ><input type="text" name="ToStore" id="ToStore"  size="20" onChange="getToStore()" value="<%=disp_locn_value%>"
				><input type=hidden name="ToStoreCode" id="ToStoreCode" value="<%=disp_locn%>"  ><INPUT TYPE="button" name="ToStore_Button" id="ToStore_Button" VALUE="?" CLASS="button"  onClick="getToStore()" >
				&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img>
				</td>
			</tr>
			<%if(bean.isSiteSpecific("PH", "WARD_ACK")){%>
			<tr>  <!--  Added for GHL-CRF-0413.8[IN063028] - Start -->
			<td   style="font-family:verdana;font-size:8pt;COLOR:navy;" width="34%"  class="QRYODD"><fmt:message key="ePH.BarCode.label" bundle="${ph_labels}"/></td>
			<td><input type="text" class='fields' name="barcode_id" id="barcode_id" style="text-align:right;background-color:#fde6d0" onkeydown="if (event.keyCode==13) {callBarcodeflg(this,'<%=request.getQueryString()%>');}" maxlength="120" size ='80'></td> <!-- increased size and maxlength for MOHE-CRF-0167 -->
			</tr> <!--  Added for GHL-CRF-0413.8[IN063028] - End -->
			<%}%>
			<tr >
				<td colspan=2  align="right" class="QRYODD" >
					<input type="button" name="proceed" id="proceed" value="Proceed"  class="BUTTON"  id='<fmt:message key="Common.Proceed.label" bundle="${common_labels}"/>' disabled onClick=callBatchDetails("<%=request.getQueryString()%>") >
				</td>
			</tr>
		</TABLE>
		<input type="hidden" name="facility_id" id="facility_id" value="<%=facilityId%>">
		<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	</FORM>
</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>

