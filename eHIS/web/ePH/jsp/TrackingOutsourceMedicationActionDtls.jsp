<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<HTML>
	<HEAD>
<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String callFrom = request.getParameter("callFrom")==null?"":request.getParameter("callFrom");
		String sentBy="", sentDate="", sentRemarks="", receivedBy="", receivedDate="", receivedRemarks="", deliveredBy="", deliveredDate="", deliveredSource="", deliveredTo="", deliveredToInd="", deliveredSourceType="";
		String	bean_id			=	"TrackingOutsourceMedicationBean" ;
		String	bean_name		=	"ePH.TrackingOutsourceMedicationBean";
		TrackingOutsourceMedicationBean bean = (TrackingOutsourceMedicationBean)getBeanObject(bean_id,bean_name ,request);
		bean.setLanguageId(locale);
		String displayStyle="inline";
		HashMap hmTrackingDetails = null;
		ArrayList alPatTackingDtls = null;
		HashMap hmTrackingDetail = null;
		ArrayList ingredients = null;
		String outsourceId="", productId="", productName="", batchId="", expiryDate="", quantity="", remarks="", ingredient="", displayAdd="", displayDel="", display="", quantityUOM="", key="";
		if(callFrom.equals("SENTDTL") || callFrom.equals("VIEWOUTSOURCEDTL") ){
%>
			<title><fmt:message key="ePH.Outsource.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></title>
<%
		}
		else{
%>
			<title><fmt:message key="ePH.ReceivedProductDetails.label" bundle="${ph_labels}"/></title>
<%
		}
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="JavaScript" SRC="../js/PhCommon.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<SCRIPT LANGUAGE="JavaScript" SRC="../js/TrackingOutsourceMedication.js"></SCRIPT>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
	<body onKeyDown="lockKey();">
		<form name="frmTrackingOutsourceMedicationActionDtls" id="frmTrackingOutsourceMedicationActionDtls" >
			<table cellpadding='0' cellspacing='0' width="99%" align="center" border='0' id='OutsourceMedicationActionDtls'>
<%
				if(callFrom.equals("SENTDTL")){
					sentBy		=	request.getParameter("outsourced_pract_name")==null?"":request.getParameter("outsourced_pract_name");
					sentDate	=	request.getParameter("outsourced_date")==null?"":request.getParameter("outsourced_date");
					sentRemarks	=	request.getParameter("remarks")==null?"":request.getParameter("remarks");//java.net.URLDecoder.decode(sentRemarks,"UTF-8")
%>
					<tr> <td colspan='2'>&nbsp;</td></tr>
					<tr> <td colspan='2' class="COLUMNHEADER"><fmt:message key="ePH.Sent.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></td></tr>
					<tr> <td colspan='2'>&nbsp;</td></tr>
					<tr>
						<td class='label' width='30%'><fmt:message key="ePH.SentBy.label" bundle="${ph_labels}"/></td>
						<td class='label' width='70%'><%=sentBy%></td>
					</tr>
					<tr>
						<td class='label' ><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
						<td class='label' ><input type='text' name='sentDate' id='sentDate' readOnly value='<%=com.ehis.util.DateUtils.convertDate(sentDate,"DMYHM","en",locale)%>'></td>
					</tr>
					<tr>
						<td class='label' style='vertical-align:top;'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
						<td class='label' ><textarea  rows='6' cols='60' name="remarks" readOnly><%=sentRemarks%></textarea></td>
					</tr>
					<tr> <td colspan='2'>&nbsp;</td></tr>
<%
				}
				if(callFrom.equals("EDITRECEIVEDDTL") ){
					try{
						int ingredientCount=1, productCount=1, maxIngredientCount=5, maxProductCount=5;
						outsourceId = request.getParameter("outsourceId");
						String orderId = request.getParameter("orderId")==null?"":request.getParameter("orderId");
						String orderLineNum = request.getParameter("orderLineNum")==null?"":request.getParameter("orderLineNum");
						key = outsourceId+"~"+orderId+"~"+orderLineNum;
						hmTrackingDetails = bean.getTrackingDetails();
						if(hmTrackingDetails.containsKey(key)){
							alPatTackingDtls = (ArrayList)hmTrackingDetails.get(key);
						}
						if(alPatTackingDtls!=null && alPatTackingDtls.size()>0)
							productCount =alPatTackingDtls.size();
						for(int i=0;i<productCount;i++){
							productId="";
							productName="";
							batchId="";
							expiryDate="";
							quantity="";
							remarks="";
							ingredients=null;
							ingredientCount=1;
							if(alPatTackingDtls!=null && alPatTackingDtls.size()>0){
								hmTrackingDetail = (HashMap)alPatTackingDtls.get(i);
								if(hmTrackingDetail!=null){
									productId=(String)hmTrackingDetail.get("productId");
									productName=(String)hmTrackingDetail.get("productName");
									batchId=(String)hmTrackingDetail.get("batchId");
									expiryDate=(String)hmTrackingDetail.get("expiryDate");
									quantity=(String)hmTrackingDetail.get("quantity");
									quantityUOM=(String)hmTrackingDetail.get("quantityUOM");
									remarks=(String)hmTrackingDetail.get("remarks");
									ingredients=(ArrayList)hmTrackingDetail.get("ingredients");
									if(ingredients!=null && ingredients.size()>0)
										ingredientCount = ingredients.size();
								}
								//productName = java.net.URLEncoder.encode(productName,"UTF-8");
								//quantityUOM = java.net.URLEncoder.encode(quantityUOM,"UTF-8");
								if(productName!=null && !productName.equals("")){
									productName=productName.replaceAll(" ","%20");
									productName = java.net.URLEncoder.encode(productName,"UTF-8");
									productName=productName.replaceAll("%2520","%20");
								}
								if(quantityUOM!=null && !quantityUOM.equals("")){
									quantityUOM=quantityUOM.replaceAll(" ","%20");
									quantityUOM = java.net.URLEncoder.encode(quantityUOM,"UTF-8");
									quantityUOM=quantityUOM.replaceAll("%2520","%20");
								}
							}
%>
							<tr>
								<td width='100%' colspan='2'>
									<table cellpadding='0' cellspacing='0' width="100%" align="center" border='0' id='productDtls<%=i%>'>
										<tr > <td colspan='2'>&nbsp;</td></tr>
										<tr>
											<td class='label' width='30%'><fmt:message key="ePH.ProductID.label" bundle="${ph_labels}"/>&nbsp;<%=i+1%></td>
											<td class='label' width='70%'><input type='text' name='productId<%=i%>' id='productId<%=i%>' value="<%=productId%>"  maxlength='20' size='30' onBlur="toUpper(this);checkForSplChars(this);" onKeyPress = "return CheckForSpecChars(event);">&nbsp;<img src="../../eCommon/images/mandatory.gif" ></img></td>
										</tr>
										<tr>
											<td class='label'><fmt:message key="Common.ProductName.label" bundle="${common_labels}"/></td>
											<td class='label'><input type='text' name='productName<%=i%>' id='productName<%=i%>' value="" maxlength='60' size='62' >&nbsp;<img  src="../../eCommon/images/mandatory.gif" ></img></td>
										</tr>
										<tr>
											<td class='label'><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>
											<td class='label'><input type='text' name='batchId<%=i%>' id='batchId<%=i%>' value="<%=batchId%>" maxlength='60' size='62' onBlur = "toUpper(this);checkForSplChars(this);" onKeyPress = "return CheckForSpecChars(event);" >&nbsp;<img  src="../../eCommon/images/mandatory.gif" ></img></td>
										</tr>
										<tr>
											<td class='label' ><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
											<td class='label' ><input type='text' name='expiryDate<%=i%>' id='expiryDate<%=i%>' size='12' maxlength='10' value='<%=com.ehis.util.DateUtils.convertDate(expiryDate,"DMY","en",locale)%>' onblur="checkForExpiryDate(this,'<%=locale%>');" ><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='CalExpiryDate<%=i%>' onclick="showCalendar('expiryDate<%=i%>');document.frmTrackingOutsourceMedicationActionDtls.expiryDate<%=i%>.focus();return false;" >&nbsp;<img  src="../../eCommon/images/mandatory.gif" ></img></td>
										</tr>
										<tr>
											<td class='label'><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
											<td class='label'><input type='text' class="NUMBER"  onKeyPress="return allowValidNumber(this,event,8,2);" onblur="checkForPositiveNumber(this);" name='quantity<%=i%>' id='quantity<%=i%>' value="<%=quantity%>" maxlength='5' size='5' >&nbsp;<input type='text' name='quantityUOM<%=i%>' id='quantityUOM<%=i%>' value="" maxlength='20' size='50' >&nbsp;<img  src="../../eCommon/images/mandatory.gif" ></img></td>
										</tr>
										<tr>
											<td colspan='2'>
												<table cellpadding='0' cellspacing='0' width="99%" align="center" border='0' id='IngredientDtls<%=i%>'>
													<tr>
														<td class='label' width='30%'><fmt:message key="ePH.Ingredients.label" bundle="${ph_labels}"/></td>
<%
														for(int j=0;j<ingredientCount; j++){
															if(ingredients!=null && ingredients.size()>0){
																ingredient = (String)ingredients.get(j);
																//ingredient = java.net.URLEncoder.encode(ingredient,"UTF-8");
																if(ingredient!=null && !ingredient.equals("")){
																	ingredient=ingredient.replaceAll(" ","%20");
																	ingredient = java.net.URLEncoder.encode(ingredient,"UTF-8");
																	ingredient=ingredient.replaceAll("%2520","%20");
																}
															}
															else{
																ingredient="";
															}
															if(j!=0){
%>
																</tr>
																<tr>
																	<td class='label' >&nbsp;</td>
<%
															}
%>
															<td class='label'><input type='text' name='ingredient<%=i%>_<%=j%>' id='ingredient<%=i%>_<%=j%>' value="" maxlength='60' size='62'>
<%
															displayAdd = "none";
															displayDel = "none";
															if(j==(ingredientCount-1)){
																if(j==(maxIngredientCount-1))
																	displayAdd = "none";
																else
																	displayAdd = "inline";

																if(j==0)
																	displayDel = "none";
																else
																	displayDel = "inline";
															}
%>
															<img src="../../eCommon/images/nolines_plus.gif" style='display:<%=displayAdd%>;' onMouseOver="changeCursor(this)" onclick="addIngredient('<%=i%>','<%=j%>')" id='addIngredient<%=i%>_<%=j%>' >&nbsp;
															<img src="../../eCommon/images/disabled.gif" style='display:<%=displayDel%>;' onMouseOver="changeCursor(this)" onclick="deleteIngredient('<%=i%>','<%=j%>')" id='deleteIngredient<%=i%>_<%=j%>' >
														</td>
														<script>
															var ingredient = decodeURIComponent('<%=ingredient%>');
															eval("frmTrackingOutsourceMedicationActionDtls.ingredient<%=i%>_<%=j%>").value = ingredient;
														</script>
<%
													}
%>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td class='label' style='vertical-align:top;'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
										<td class='label' ><textarea  rows='6' cols='60' name="remarks<%=i%>" onKeyPress="return checkMaxLimit(this,2000,'');" onBlur="callCheckMaxLen(this,2000,'blr');" ><%=remarks%></textarea>
<%
										displayAdd = "none";
										displayDel = "none";
										if(i==(productCount-1)){
											if(i==(maxProductCount-1))
												displayAdd = "none";
											else
												displayAdd = "inline";

											if(i==0)
												displayDel = "none";
											else
												displayDel = "inline";
										}
%>
										<img src="../../eCommon/images/nolines_plus.gif" style='display:<%=displayAdd%>;' onMouseOver="changeCursor(this)" onclick="addProduct('<%=i%>')" id='addProduct<%=i%>' >
										<img src="../../eCommon/images/disabled.gif" style='display:<%=displayDel%>;' onMouseOver="changeCursor(this)" onclick="deleteProduct('<%=i%>')" id='deleteProduct<%=i%>'>
										</td>
										<input type='hidden' name='noOfIngnts<%=i%>' id='noOfIngnts<%=i%>' value='<%=ingredientCount%>'>

									</tr>
								</table>
								<script>
									var productName = decodeURIComponent('<%=productName%>');
									eval("frmTrackingOutsourceMedicationActionDtls.productName<%=i%>").value = productName;
									var quantityUOM = decodeURIComponent('<%=quantityUOM%>');
									eval("frmTrackingOutsourceMedicationActionDtls.quantityUOM<%=i%>").value = quantityUOM;
								</script>
<%
							}
%>
						<input type='hidden' name='noOfProducts' id='noOfProducts' value='<%=productCount%>'>
						<input type='hidden' name='orderId' id='orderId' value='<%=orderId%>'>
						<input type='hidden' name='orderLineNum' id='orderLineNum' value='<%=orderLineNum%>'>
						<input type='hidden' name='maxProductCount' id='maxProductCount' value='<%=maxProductCount%>'>
						<input type='hidden' name='maxIngredientCount' id='maxIngredientCount' value='<%=maxIngredientCount%>'>
						<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
						<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
						<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
						<input type="hidden" name="sys_date" id="sys_date" value="<%=bean.getTodayDate()%>">
<%
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				if(callFrom.equals("VIEWOUTSOURCEDTL")){
					outsourceId = request.getParameter("outsourceId")==null?"":request.getParameter("outsourceId");
					String orderId = request.getParameter("orderId")==null?"":request.getParameter("orderId");
					String orderLineNum = request.getParameter("orderLineNum")==null?"":request.getParameter("orderLineNum");
					String sentById, receivedById, deliveredById ="";
					if(outsourceId.equals("")){
						outsourceId = bean.getOutSourceId(orderId, orderLineNum);
					}
					int ingredientCount=0, productCount=0;
					hmTrackingDetails = bean.getOutsourceProductDetails();
					if(hmTrackingDetails==null || hmTrackingDetails.size()==0)
						hmTrackingDetails = bean.queryOutsourceProductDetails(outsourceId);
					if(hmTrackingDetails.containsKey(outsourceId)){
						alPatTackingDtls = (ArrayList)hmTrackingDetails.get(outsourceId);
					}
					if(alPatTackingDtls!=null && alPatTackingDtls.size()>0){
						productCount =alPatTackingDtls.size();
						for(int i=0;i<productCount;i++){
							productId="";
							productName="";
							batchId="";
							expiryDate="";
							quantity="";
							remarks="";
							sentById="";
							receivedById="";
							deliveredById ="";
							ingredients=null;
							ingredientCount=1;
							hmTrackingDetail = (HashMap)alPatTackingDtls.get(i);
							if(hmTrackingDetail!=null){
								if(i==0){
									sentById=hmTrackingDetail.get("OUTSOURCED_BY")==null?"":(String)hmTrackingDetail.get("OUTSOURCED_BY");
									sentBy=hmTrackingDetail.get("OUTSOURCED_PRACT_NAME")==null?"":(String)hmTrackingDetail.get("OUTSOURCED_PRACT_NAME");
									sentDate=hmTrackingDetail.get("OUTSOURCED_DATE")==null?"":(String)hmTrackingDetail.get("OUTSOURCED_DATE");
									sentRemarks=hmTrackingDetail.get("OUTSOURCED_REMARKS")==null?"":(String)hmTrackingDetail.get("OUTSOURCED_REMARKS");
									receivedById=hmTrackingDetail.get("RECEIVED_BY")==null?"":(String)hmTrackingDetail.get("RECEIVED_BY");
									receivedBy=hmTrackingDetail.get("RECEIVED_PRACT_NAME")==null?"":(String)hmTrackingDetail.get("RECEIVED_PRACT_NAME");
									receivedDate=hmTrackingDetail.get("RECEIVED_DATE")==null?"":(String)hmTrackingDetail.get("RECEIVED_DATE");
									receivedRemarks=hmTrackingDetail.get("RECEIVED_REMARKS")==null?"":(String)hmTrackingDetail.get("RECEIVED_REMARKS");
									deliveredById=hmTrackingDetail.get("DELIVERED_BY")==null?"":(String)hmTrackingDetail.get("DELIVERED_BY");
									deliveredBy=hmTrackingDetail.get("DELIVERED_PRACT_NAME")==null?"":(String)hmTrackingDetail.get("DELIVERED_PRACT_NAME");
									deliveredDate=hmTrackingDetail.get("DELIVERED_DATE")==null?"":(String)hmTrackingDetail.get("DELIVERED_DATE");
									deliveredSource=hmTrackingDetail.get("SOURCE_DESC")==null?"":(String)hmTrackingDetail.get("SOURCE_DESC");
									deliveredSourceType=hmTrackingDetail.get("SOURCE_TYPE")==null?"":(String)hmTrackingDetail.get("SOURCE_TYPE");
									deliveredTo=hmTrackingDetail.get("DELIVERED_TO")==null?"":(String)hmTrackingDetail.get("DELIVERED_TO");
									deliveredToInd=hmTrackingDetail.get("DELIVERED_TO_IND")==null?"":(String)hmTrackingDetail.get("DELIVERED_TO_IND");
									if(!sentById.equals("")){
	%>
										<tr> <td colspan='2'>&nbsp;</td></tr>
										<tr> <td colspan='2' class="COLUMNHEADER"><fmt:message key="ePH.Sent.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></td></tr>
										<tr> <td colspan='2'>&nbsp;</td></tr>
										<tr>
											<td class='label' width='30%'><fmt:message key="ePH.SentBy.label" bundle="${ph_labels}"/></td>
											<td class='label' width='70%'><%=sentBy%></td>
										</tr>
										<tr>
											<td class='label' ><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
											<td class='label' ><%=com.ehis.util.DateUtils.convertDate(sentDate,"DMYHM","en",locale)%></td>
										</tr>
										<tr>
											<td class='label' style='vertical-align:top;'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
											<td class='label' ><textarea  rows='6' cols='60' name="remarks" readOnly><%=sentRemarks%></textarea></td>
										</tr>
										<tr> <td colspan='2'>&nbsp;</td></tr>
<%
									}
									if(!receivedById.equals("")){
%>
										<tr> <td colspan='2'>&nbsp;</td></tr>
										<tr> <td colspan='2' class="COLUMNHEADER"><fmt:message key="Common.received.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></td></tr>
										<tr> <td colspan='2'>&nbsp;</td></tr>
										<tr>
											<td class='label' width='30%'><fmt:message key="Common.ReceivedBy.label" bundle="${common_labels}"/></td>
											<td class='label' width='70%'><%=receivedBy%></td>
										</tr>
										<tr>
											<td class='label' ><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
											<td class='label' ><%=com.ehis.util.DateUtils.convertDate(receivedDate,"DMYHM","en",locale)%></td>
										</tr>
										<tr>
											<td class='label' style='vertical-align:top;'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
											<td class='label' ><textarea  rows='6' cols='60' name="remarks" readOnly><%=receivedRemarks%></textarea></td>
										</tr>
										<tr> <td colspan='2'>&nbsp;</td></tr>
<%
									}
									if(!deliveredById.equals("")){
%>
										<tr> <td colspan='2'>&nbsp;</td></tr>
										<tr> <td colspan='2' class="COLUMNHEADER"><fmt:message key="ePH.Delivered.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></td></tr>
										<tr> <td colspan='2'>&nbsp;</td></tr>
										<tr>
											<td class='label' width='30%'><fmt:message key="ePH.DeliveredBy.label" bundle="${ph_labels}"/></td>
											<td class='label' width='70%'><%=deliveredBy%></td>
										</tr>
										<tr>
											<td class='label' ><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
											<td class='label' ><%=com.ehis.util.DateUtils.convertDate(deliveredDate,"DMYHM","en",locale)%></td>
										</tr>
										<tr>
											<td class='label' ><fmt:message key="ePH.Delivered.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
											<td class='label' ><%=deliveredSource%></td>
										</tr>
										<tr>
											<td class='label' ><fmt:message key="ePH.Delivered.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
											<td class='label' >
<%
											if(deliveredToInd.equals("L")){
%>
												<%=deliveredTo%>&nbsp;(<fmt:message key="Common.Location.label" bundle="${common_labels}"/>)
<%
											}
											if(deliveredToInd.equals("P")){
%>
												<%=deliveredTo%>&nbsp;(<fmt:message key="Common.patient.label" bundle="${common_labels}"/>)
<%
											}
											if(deliveredToInd.equals("O")){
%>
												<%=deliveredTo%>&nbsp;(<fmt:message key="Common.others.label" bundle="${common_labels}"/>)
<%
											}
%>
											</td>
										</tr>
										<tr> <td colspan='2'>&nbsp;</td></tr>
<%
									}
									continue;
								}
								else{
									productId=(String)hmTrackingDetail.get("productId");
									productName=(String)hmTrackingDetail.get("productName");
									batchId=(String)hmTrackingDetail.get("batchId");
									expiryDate=(String)hmTrackingDetail.get("expiryDate");
									quantity=(String)hmTrackingDetail.get("quantity");
									quantityUOM=(String)hmTrackingDetail.get("quantityUOM");
									remarks=(String)hmTrackingDetail.get("remarks");
									ingredients=(ArrayList)hmTrackingDetail.get("ingredients");
									if(ingredients!=null && ingredients.size()>0)
										ingredientCount = ingredients.size();
									//productName = java.net.URLEncoder.encode(productName,"UTF-8");
									//quantityUOM = java.net.URLEncoder.encode(quantityUOM,"UTF-8");
									if(productName!=null && !productName.equals("")){
										productName=productName.replaceAll(" ","%20");
										productName = java.net.URLEncoder.encode(productName,"UTF-8");
										productName=productName.replaceAll("%2520","%20");
									}
									if(quantityUOM!=null && !quantityUOM.equals("")){
										quantityUOM=quantityUOM.replaceAll(" ","%20");
										quantityUOM = java.net.URLEncoder.encode(quantityUOM,"UTF-8");
										quantityUOM=quantityUOM.replaceAll("%2520","%20");
									}
								}
								if(i==1){
%>
									<tr> <td colspan='2' class="COLUMNHEADER"><fmt:message key="ePH.ReceivedProductDetails.label" bundle="${ph_labels}"/></td></tr>
<%
								}
%>
							<tr>
								<td width='100%' colspan='2'>
									<table cellpadding='0' cellspacing='0' width="100%" align="center" border='0' id='productDtls<%=i%>'>
										<tr > <td colspan='2'>&nbsp;</td></tr>
										<tr>
											<td class='label' width='30%'><fmt:message key="ePH.ProductID.label" bundle="${ph_labels}"/>&nbsp;<%=i%></td>
											<td class='label' width='70%'><input type='text' name='productId<%=i%>' id='productId<%=i%>' value="<%=productId%>"  size='20' readOnly></td>
										</tr>
										<tr>
											<td class='label'><fmt:message key="Common.ProductName.label" bundle="${common_labels}"/></td>
											<td class='label'><input type='text' name='productName<%=i%>' id='productName<%=i%>' value="<%=productName%>" size='62' readOnly ></img></td>
										</tr>
										<tr>
											<td class='label'><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>
											<td class='label'><input type='text' name='batchId<%=i%>' id='batchId<%=i%>' value="<%=batchId%>" size='62' readOnly ></td>
										</tr>
										<tr>
											<td class='label' ><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
											<td class='label' ><input type='text' name='expiryDate<%=i%>' id='expiryDate<%=i%>' size='12'  value='<%=com.ehis.util.DateUtils.convertDate(expiryDate,"DMY","en",locale)%>' readOnly ></td>
										</tr>
										<tr>
											<td class='label'><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
											<td class='label'><input type='text' class="NUMBER"  name='quantity<%=i%>' id='quantity<%=i%>' value="<%=quantity%>" size='5'readOnly >&nbsp;<input type='text' name='quantityUOM<%=i%>' id='quantityUOM<%=i%>' value="<%=quantityUOM%>" readOnly size='50' ></td>
										</tr>
										<tr>
											<td colspan='2'>
												<table cellpadding='0' cellspacing='0' width="99%" align="center" border='0' id='IngredientDtls<%=i%>'>
													<tr>
														<td class='label' width='30%'><fmt:message key="ePH.Ingredients.label" bundle="${ph_labels}"/></td>
<%
														for(int j=0;j<ingredientCount; j++){
															if(ingredients!=null && ingredients.size()>0){
																ingredient = (String)ingredients.get(j);
																//ingredient = java.net.URLEncoder.encode(ingredient,"UTF-8");
																if(ingredient!=null && !ingredient.equals("")){
																	ingredient=ingredient.replaceAll(" ","%20");
																	ingredient = java.net.URLEncoder.encode(ingredient,"UTF-8");
																	ingredient=ingredient.replaceAll("%2520","%20");
																}
															}
															else{
																ingredient="";
															}
															if(j!=0){
%>
																</tr>
																<tr>
																	<td class='label' >&nbsp;</td>
<%
															}
%>
															<td class='label'><input type='text' name='ingredient<%=i%>_<%=j%>' id='ingredient<%=i%>_<%=j%>' value="<%=ingredient%>" readOnly size='62'>
														</td>
														<script>
															var ingredient = decodeURIComponent('<%=ingredient%>');
															eval("frmTrackingOutsourceMedicationActionDtls.ingredient<%=i%>_<%=j%>").value = ingredient;
														</script>
<%
													}
%>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td class='label' style='vertical-align:top;'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
										<td class='label' ><textarea  rows='6' cols='60' name="remarks<%=i%>"  readOnly><%=remarks%></textarea>
										</td>
									</tr>
								</table>				
								<script>
									var productName = decodeURIComponent('<%=productName%>');
									eval("frmTrackingOutsourceMedicationActionDtls.productName<%=i%>").value = productName;
									var quantityUOM = decodeURIComponent('<%=quantityUOM%>');
									eval("frmTrackingOutsourceMedicationActionDtls.quantityUOM<%=i%>").value = quantityUOM;
								</script>
<%
							}
						}
					}
				}
%>
			</table>
		</form>
	</BODY>
</HTML>

