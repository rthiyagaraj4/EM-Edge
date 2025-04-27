<!DOCTYPE html>
<%-- JSP Page specific attributes st art --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
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
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/QueryPatientDrugProfile.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="QueryForm" id="QueryForm">
<%
			boolean searched	= request.getParameter( "searched" ) == null ? false : true  ;
			String patient_id	= request.getParameter("patient_id");	
			ArrayList result1  =  null;
			String dt_from	    = CommonBean.checkForNull(request.getParameter("dt_from"));
			String dt_to	    = CommonBean.checkForNull(request.getParameter("dt_to"));
			String item_code	    = CommonBean.checkForNull(request.getParameter("item_code"));
			String	bean_id			=	"QueryPatientDrugProfileBean" ;
			String	bean_name		=	"ePH.QueryPatientDrugProfileBean";
			String from = CommonBean.checkForNull(request.getParameter("from"));
			String to = CommonBean.checkForNull(request.getParameter("to"));
		    String ReqDb	    =	request.getParameter("ReqDb")==null?"":request.getParameter("ReqDb");//Added for MMS-DM-CRF-115.4
			if(ReqDb.equals("undefined"))
		    ReqDb="";
		    String enc_id1	    =	request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");//Added for MMS-DM-CRF-115.4
		    String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");//Added for MMS-DM-CRF-115.4
			QueryPatientDrugProfileBean bean = (QueryPatientDrugProfileBean)getBeanObject( bean_id,bean_name, request) ;
			bean.setLanguageId(locale);
			String disabled     = ""; // Added for MMS-DM-CRF-0115.4
			if(called_from.equals("CDR"))
			   disabled ="disabled";
			try{
				result1=(ArrayList)bean.getMedicalItem(patient_id,item_code, dt_from,dt_to, from,to,ReqDb,enc_id1);//Added ReqDb,enc_id1 for MMS-DM-CRF-115.4
				String classvalue="QRYEVENSMALL";
				String item_name, order_quantity, order_quantity_uom, Status, ordered_By, ordered_details, dispense_Qty, patient_class, disp_date, order_id, order_line_num, disp_locn_desc, ordered_date;
				if( (result1.size()>=2) && ( !( ((String) result1.get(0)).equals("0")) )){
%>
					<table cellpadding=0 cellspacing=0 align="center">
						<tr>
							<td width="80%" class="white">&nbsp;</td>
							<td width="20%" class="white">&nbsp;
<%
								// For display the previous/next link
								out.println(result1.get(0));
%>
							</td>
						</tr>
					</table>
					<div id='patinsID' style='height:358;overflow-y:auto;overflow-x:no'>
						<table id="ExternalId" border="1" cellpadding="0" cellspacing="0" width="100%"  >
							<tr style='height:40px;' style='position:relative' style='top:expression(this.offsetParent.scrollTop-2)'>
								<th width ="20%" class='COLUMNHEADER'><fmt:message key="Common.ItemName.label" bundle="${common_labels}"/></th>
								<th width ="10%" class='COLUMNHEADER'><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
								<th width ="8%" class='COLUMNHEADER'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></th>
								<th width ="10%" class='COLUMNHEADER'><fmt:message key="ePH.OrderedDate.label" bundle="${ph_labels}"/></th>
								<th width ="8%" class='COLUMNHEADER'><fmt:message key="Common.OrderQty.label" bundle="${common_labels}"/></th>
								<th width ="8%" class='COLUMNHEADER'><fmt:message key="ePH.DispenseQty.label" bundle="${ph_labels}"/></th>
								<th width ="10%" class='COLUMNHEADER'><fmt:message key="Common.OrderedBy.label" bundle="${common_labels}"/></th>
								<th width ="28%" class='COLUMNHEADER'><fmt:message key="ePH.OrderedDetails.label" bundle="${ph_labels}"/></th>
							</tr>
<%
							for(int recCount=1; recCount<result1.size(); recCount=recCount+14){
								ordered_date		= (String)result1.get(recCount);
								item_name		= (String)result1.get(recCount+2);
								order_quantity		= (String)result1.get(recCount+3);
								order_quantity_uom		= (String)result1.get(recCount+4);
								Status 			= (String)result1.get(recCount+5);
								ordered_By		=(String)result1.get(recCount+6);
								ordered_details 		= (String)result1.get(recCount+7);
								dispense_Qty		= (String)result1.get(recCount+8);
								patient_class	=(String)result1.get(recCount+9);
								order_id	= (String)result1.get(recCount+10);
								order_line_num	=(String)result1.get(recCount+11);
								disp_date	=(String)result1.get(recCount+12);
								disp_locn_desc	= java.net.URLEncoder.encode((String)result1.get(recCount+13),"UTF-8");
%>
								<tr>
									<td class="<%=classvalue%>" id="item_name" ><%=item_name%></td>
									<td class="<%=classvalue%>" id="Status" ><%=Status%></td>
									<td class="<%=classvalue%>" id="patient_plass" ><%=patient_class%></td>
									<td class="<%=classvalue%>" id="ordered_date" ><%=DateUtils.convertDate(ordered_date,"DMYHM","en",locale)%>&nbsp;</td>
									<td class="<%=classvalue%>" id="order_quantity" ><%=order_quantity+" "+order_quantity_uom%></td>
 <%
									if(dispense_Qty!=null && dispense_Qty.trim().length()>0){
%>
										<td class="<%=classvalue%>"  id="disp_Qty"  <%=disabled%>>
											<a HREF="#" onClick="showDispDetails('<%=java.net.URLEncoder.encode(item_name,"UTF-8")%>','<%=dispense_Qty%>','<%=ordered_By%>','<%=Status%>','<%=order_quantity_uom%>','<%=order_id%>','<%=order_line_num%>','<%=disp_date%>','<%=disp_locn_desc%>');" id='dispqtylink'><%=dispense_Qty+" "+order_quantity_uom%></a>
										</td> <!-- <%=disabled%> added for MMS-DM-CRF-115.4 -->
 <%
									} 
									else {
%>
										<td class="<%=classvalue%>"  id="disp_Qty" >&nbsp;</td>
<%
									}
%>
									 <td class="<%=classvalue%>" id="ordered_by" ><%=ordered_By%></td>
									 <td class="<%=classvalue%>" id="ordered_details"><%=ordered_details%></td>
								 </tr>
 <%
							}
						}
						else{
%>
							<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script>
<% 
						}
%>				
						<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
						<input type="hidden" name="from" id="from" value="">
						<input type="hidden" name="to" id="to" value="">

					</table>
				</div> 
				<script language="javascript">
					parent.parent.f_query_status.location.href="../../eCommon/html/blank.html";
				</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%	
			}
			catch(Exception e){
				e.printStackTrace();
			}  
%>	
		</form>
	</body>
</html>

