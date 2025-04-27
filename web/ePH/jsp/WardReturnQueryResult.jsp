<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper " %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
 
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String facility_id   = (String)session.getValue( "facility_id" );
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../ePH/js/WardReturn.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/dchk.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="" onKeyDown="lockKey()">
		<form id="WardReturnQueryResultform" name="WardReturnQueryResultform" id="WardReturnQueryResultform">
<%
			java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
			String bean_id		= "WardReturnBean"+login_at_ws_no;
			String bean_name	= "ePH.WardReturnBean";
			String Accept       = "";
			String Reject       = "";

			WardReturnBean bean = (WardReturnBean)getBeanObject( bean_id,bean_name,request) ;
			bean.clear() ;
			 
			ArrayList wardResultList = new ArrayList(); 
			HashMap wardResultMap    = new HashMap();
			String patientid		 = request.getParameter( "patientid" );
			String StoreCode		 = request.getParameter( "StoreCode" );
			String QueryMode		 = request.getParameter( "querymode" );
			wardResultList           = bean.getWardResult(patientid,StoreCode,facility_id,locale);
			String return_uom		 =	"";
			if(wardResultList.size()>0){
%>
				<TABLE width="100%" cellspacing="0" cellpadding="0" border="1">	
					<tr>
						<td class='COLUMNHEADER' width=8%><fmt:message key="Common.date.label" bundle="${common_labels}"/></td >
						<td class='COLUMNHEADER'  width=26%><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td >
						<td class='COLUMNHEADER' width=8%><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td >
						<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></td >
						<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
						<td class='COLUMNHEADER' width=10%><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.Acknowledge.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.ReturnedQuantity.label" bundle="${ph_labels}"/></td>
						<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.QtyUOM.label" bundle="${ph_labels}"/></td>
					</tr>
<% 
					int rowCount=0;
					String classvalue="";
					for(int i=0; i<wardResultList.size(); i++){
						wardResultMap = (HashMap)wardResultList.get(i);
						if ( rowCount++ % 2 == 0 )
							classvalue = "QRYEVEN" ;
						else
							classvalue = "QRYODD" ;
						
%>	
						<TR > 
							<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" align="left">
								<%=com.ehis.util.DateUtils.convertDate((((String)wardResultMap.get("DISP_DATE_TIME")).trim()),"DMY","en",locale)%>
							</TD>
							<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" align="left">
								<%=(String)wardResultMap.get("DRUG_DESC")%>
							</TD>
							<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" align="left">
								<%=(String)wardResultMap.get("BATCH_ID")%>
							</TD>
							<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" align="left">
								<%=(String)wardResultMap.get("DISP_NO")%>
							</TD>
							<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" align="left">
								<%=(String)wardResultMap.get("SHORT_DESC")%>
							</TD>
<%
							if(CommonBean.checkForNull((String)wardResultMap.get("STORE_ACKNOWLEDGE_STATUS")).equals("A")){
								Accept=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accept.label","common_labels");
%>
								<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" align="left">
									&nbsp;&nbsp;<%=Accept%>
								</TD>
<%
							}
							else if(CommonBean.checkForNull((String)wardResultMap.get("STORE_ACKNOWLEDGE_STATUS")).equals("R")){
								Reject=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reject.label","common_labels");
%>
								<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" align="left">
								&nbsp;&nbsp;<%=Reject%>
								</TD>
<%
							}
							else{
%>
								<TD class="<%=classvalue%>">&nbsp;&nbsp;</TD>
<%
							}
							if(!(CommonBean.checkForNull((String)wardResultMap.get("ACKNOWLEDGE_REASON"))).equals(""))	{
%>
								<!-- Passed UTF-8 for Acknowledgment Reason Regarding incident num:25634=By Sandhya on 06-Jan-2011 -->
								<TD class="<%=classvalue%>"><font style="font-size:9;cursor:pointer" class="HYPERLINK"  >
								<label	onmouseover="changeCursor(this);" name="checkremark" onclick="WardRemarks('<%=java.net.URLEncoder.encode(CommonBean.checkForNull((String)wardResultMap.get("ACKNOWLEDGE_REASON")),"UTF-8")%>','<%=QueryMode%>');">
								<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></label></font>
								</TD>
<%
							}
							else{
%>
								<td class="<%=classvalue%>">&nbsp; </td>
<%
							}
%>
							<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" align="left">
							&nbsp;&nbsp;<%=CommonBean.checkForNull((String)wardResultMap.get("RETURNED_QTY"))%>
							</TD>
<%
							//Added code for converting UOM Display code/Description for the incident num 22687 on 15/july/2010 
							return_uom = wardResultMap.get("RETURN_UOM_CODE") == null ? "" : wardResultMap.get("RETURN_UOM_CODE").toString();
%>
							<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" align="left">
								<%=bean.getUomDisplay(facility_id,return_uom)%>
							</TD>
						</TR>
<%
				}  //END FOR LOOP
%>
					</table>
<%
			}
			else{
%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script>
<%
			}
%>
			<input type='hidden' name='login_at_ws_no' id='login_at_ws_no' value='<%=login_at_ws_no%>'>
		</form>
	</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>

