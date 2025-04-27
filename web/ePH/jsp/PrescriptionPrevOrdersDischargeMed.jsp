<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.*, eCommon.Common.*, eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

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
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js" ></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../ePH/js/Prescription_1.js"></script>
		<script language="Javascript" src="../../ePH/js/PrescriptionTest.js"></script>
		<!-- <script language="Javascript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
	</head>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<form name="frmdischPrescriptionPrevOrdersResult" id="frmdischPrescriptionPrevOrdersResult">
<%
			try{
				String pat_class	=	request.getParameter("pat_class");
				String ord_status	=	request.getParameter("ord_status");
				String order_from	=	request.getParameter("order_from");
				String order_to		=	request.getParameter("order_to");
				String pract_id		=	request.getParameter("pract_id");
				String fromdisc		=	request.getParameter("fromdisc")==null?"N":request.getParameter("fromdisc");
				String start_date		=request.getParameter("start_date");
				String end_date		=	request.getParameter("end_date");
				String order_id		=	request.getParameter("order_id")==null?"":request.getParameter("order_id");
				String called_from 	= request.getParameter("called_from")==null?"":request.getParameter("called_from");
				String ord_date="";
				String pres_no		=	"";
				String rx_type		=	request.getParameter("rx_type")==null?"":request.getParameter("rx_type");
				String patient_id		=request.getParameter("pat_id");
				String encounter_id		=request.getParameter("enc_id");
				ArrayList reqChecks = new ArrayList();
				String bean_id		= "@PrescriptionBean_1"+patient_id+encounter_id;
				String bean_name	= "ePH.PrescriptionBean_1";
				boolean dupflag=false;
				String drug_db_duptherapy_flag="";
				String rx_legend=  com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.NormalRx.label", "ph_labels");
				PrescriptionBean_1 bean		= (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request );
				String ext_beanid = "@ExternalProductLinkBean";
				String ext_beanname = "ePH.ExternalProductLinkBean";
				HashMap drugDosageResult = null;
				ArrayList exProd				= new ArrayList();
				ArrayList drugDesc				= new ArrayList();
				String dup_drug_det			    = "";
				ExternalProductLinkBean ext_beanObj = (ExternalProductLinkBean)getBeanObject(ext_beanid,ext_beanname,request);
				bean.setLanguageId(locale);
				String params = request.getQueryString();
				String overrideflag="N";
				/*if(!locale.equals("en")){//Commented for IN048127--start
					order_from = DateUtils.convertDate(order_from, "DMYHM",locale,"en");
					order_to = DateUtils.convertDate(order_to, "DMYHM",locale,"en");
				}*///Commented for IN048127--end
				ArrayList extdbdetails = bean.checkdup();
				reqChecks.add("N"); //Dosage Check  
				reqChecks.add(extdbdetails.get(0)); //Duplicate Check
				reqChecks.add("N"); //DrugInteraction
				reqChecks.add("N"); //Contra Indication
				reqChecks.add("N"); //AllergyCheck
				HashMap drugDBCheckResult = new HashMap(); 
				int recCount		=	0;
				String classValue	=	"";
				String ducheck = "";
				//String expected_date = bean.getExcpectedDate(patient_id); //Commented for ML-BRU-SCF-1349 [IN:049402]
				String defDates[] = bean.getExcpectedDate(patient_id); //Added for ML-BRU-SCF-1349 [IN:049402]
				String expected_date = defDates[0]; //Added for ML-BRU-SCF-1349 [IN:049402]
				if(!locale.equals("en")){//Added for IN048127--start
					expected_date = DateUtils.convertDate(expected_date, "DMYHM","en",locale);
				}//Added for IN048127--end
				String commondatefrom="";
				String commondateto="";
				String qty ="";
				if(start_date!=null && start_date.trim().length()>0){//Added for IN048127--start
					if(!locale.equals("en")){
						start_date = DateUtils.convertDate(start_date, "DMYHM","en",locale);
						end_date = DateUtils.convertDate(end_date, "DMYHM","en",locale);
					}
				}//Added for IN048127--end
				if(called_from!=null && called_from.trim().length()>0 && called_from.equalsIgnoreCase("dateschange")){
					commondatefrom = start_date;
					commondateto  =  end_date;
				}
				else{
					commondatefrom = defDates[1];//changed from expected_date to defDates[1] for ML-BRU-SCF-1349 [IN:049402]
					commondateto   = defDates[2]; //changed from expected_date to defDates[2] for ML-BRU-SCF-1349 [IN:049402]
					if(!locale.equals("en")){ //if block Added for ML-BRU-SCF-1349 [IN:049402]
						commondatefrom = DateUtils.convertDate(commondatefrom, "DMYHM","en",locale);
						commondateto = DateUtils.convertDate(commondateto, "DMYHM","en",locale);
					}
				}
				ArrayList dischargepres	= bean.getPreviewOrders(pat_class,pract_id,patient_id,ord_status,order_from,order_to,order_id,rx_type,commondatefrom,commondateto);
				bean.setCurrentSelectedDrugs(dischargepres);
				for(int p=0; p<dischargepres.size(); p+=21) {
					exProd.add((String)dischargepres.get(p+19));
					drugDesc.add((String)dischargepres.get(p+4));
				}
				for(int k=0; k<dischargepres.size(); k+=21) {
					ducheck = (String)dischargepres.get(k+20);
					if(ducheck.equals("Y"))
						break;
			   }
%>
				<div id="HTab" name="HTab" style="width:100%;display: inline; overflow:hidden" align='left'>
					<table border="1" cellpadding="0" cellspacing="0" width="100%" align="left" name="resultTable" id="resultTable">
						<tr>  
							<th  nowrap width="3%" >&nbsp;</th>
							<th  nowrap width="7%"  colspan='2'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
							<th nowrap width="40%" ><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th>
							<th nowrap  width="50%"  ><fmt:message key="ePH.DosageDetail.label" bundle="${ph_labels}"/></th>
						</tr>
					</table>
				</div>
				<div id="DataTab"  name="DataTab"  style="height:310px; width:100%; display: inline; overflow:auto;" onScroll="scrollit();">
					<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" name="resultTable" id="resultTable" id="resultTable">
<%						ArrayList discorders =  bean.getdiscPrescriptions();//Added for IN048127--start
						String tempid="";
						ArrayList orddiscorders = new ArrayList();
						ArrayList orgcorders = new ArrayList();
						for(int i=0;i<discorders.size();i=i+2){
							tempid = (String)discorders.get(i);
							int tempindex = tempid.indexOf(",");
							String tempval = tempid.substring(0,tempindex);
							orddiscorders.add(tempval);
						}
						for(int i=1; i<dischargepres.size(); i+=21){
							String orgtempid = (String)dischargepres.get(i);
							orgcorders.add(orgtempid);
							
						}
						String linecheckedval = "";
						HashMap hm = new HashMap();
						HashMap hm1 = new HashMap();
						Set<String> uniqueSet1 = new HashSet<String>(orgcorders);
						for (String temp : uniqueSet1) {
							hm.put(temp,Collections.frequency(orgcorders, temp));
						}
						Set<String> uniqueSet2 = new HashSet<String>(orddiscorders);
						for (String temp1 : uniqueSet2) {
							hm1.put(temp1,Collections.frequency(orddiscorders, temp1));
						}
						String hdrcheckedval = "checked";//Added for IN048127--end
						for(int i=0, j=0; i<dischargepres.size(); j++,i+=21){
							if(hm1.containsKey((String)dischargepres.get(i+1))){//Added for IN048127--start
								int newcount = (Integer)hm1.get((String)dischargepres.get(i+1));
								int newcount1 = (Integer)hm.get((String)dischargepres.get(i+1));
								if(newcount==newcount1)
									hdrcheckedval = "checked";
								else
									hdrcheckedval = "";
							}
							else
								hdrcheckedval = "";//Added for IN048127--end
							
							if(recCount%2==0)
								classValue="QRYEVENSMALL";
							else
								classValue="QRYODDSMALL";
							if(discorders.contains(dischargepres.get(i+1)+","+dischargepres.get(i+2))){//Added for IN048127--start
								linecheckedval = "checked";
							}
							else{
								linecheckedval="";
							}//Added for IN048127--end
									
							ord_date = (String)dischargepres.get(i+17);
							qty = (String)dischargepres.get(i+5);
							qty = qty.trim();
							if((extdbdetails.get(0)).equals("Y")){//if condition added for ML-BRU-SCF-1561 [IN:053781]
								for(int q=0; q<dischargepres.size(); q+=21){
								drugDBCheckResult = ext_beanObj.getExternalDBChecks( reqChecks, (String)dischargepres.get(q+19), patient_id, "", exProd ,drugDesc, null, "Y",commondatefrom,commondateto); 
								if(drugDBCheckResult != null && drugDBCheckResult.size() > 0){
									 dup_drug_det			= (String)drugDBCheckResult.get("DUPCHECK");
									   if(dup_drug_det!=null && !dup_drug_det.equals("")){
											drug_db_duptherapy_flag="Y";
											break;
										}
									}
								}
							}
							ducheck = (String)dischargepres.get(i+20);
							if(ducheck!=null && ducheck.equals("Y")|| (drug_db_duptherapy_flag!=null && drug_db_duptherapy_flag.equalsIgnoreCase("Y"))){
								overrideflag = "Y";
							}
							if(!(pres_no.equals((String)dischargepres.get(i+1)))) {
								pres_no	=	(String)dischargepres.get(i+1);	

%>
									<tr>
										<td  width="3%" class="CURRTEXT">&nbsp;</td>
										<td  nowrap width="4%" class="CURRTEXT" id="ord_<%=(String)dischargepres.get(i+1)%>"><input type="checkbox" name="<%=(String)dischargepres.get(i+1)%>" id="<%=(String)dischargepres.get(i+1)%>" onClick=" checkLinesDisc(this);" <%=hdrcheckedval %>></td><!--Added hdrcheckedval for IN048127  -->
										<td  nowrap width="3%" class="CURRTEXT">&nbsp;</td>
										<td  nowrap  style="font-size:10;font-weight:bold" class="CURRTEXT"><fmt:message key="Common.OrderDateTime.label" bundle="${common_labels}"/>:&nbsp;&nbsp;<%=ord_date%>&nbsp;&nbsp;<%=rx_legend%></td>
										<td  class="CURRTEXT" nowrap style="font-size:10;font-weight:bold"> <fmt:message key="ePH.OrderedLocation.label" bundle="${ph_labels}"/>:&nbsp;&nbsp;<%=dischargepres.get(i+16)==null?"&nbsp;":dischargepres.get(i+16)%>&nbsp;&nbsp;&nbsp;</td>
									</tr>
<%
								}
%>
								 <tr>
									<td  width="3%" >&nbsp;</td>
									<td width="4%" class="<%=classValue%>"  id='drug_<%=(String)dischargepres.get(i+1)%>' nowrap><input type="checkbox" name="<%=dischargepres.get(i+1)+","+dischargepres.get(i+2)%>" value="<%=dischargepres.get(i+3)%>" onClick="checkheaderdisc(this); return storeCheckeddisc(this); " <%=linecheckedval %>></td> <!--Added linecheckedval for IN048127  -->
<%
								if(ducheck!=null && ducheck.equals("Y")){
%>
									<td width="3%" visibility="visible" id="image<%=j%>" class="CURRENTRX">&nbsp;</td>
									<td width="40%" style="font-size:10" class="<%=classValue%>" nowrap >
									<a href="javascript:showDisccancel('<%=patient_id%>','<%=encounter_id%>','<%=(String)dischargepres.get(i+18) %>','<%=commondatefrom %>','<%=commondateto %>','','','<%=j%>','','','buttons','N');"><%=dischargepres.get(i+4)%></a>
									</td>  
<%   
								}
								else{ 
%> 
									<td width="3%" visibility="visible" id="image<%=j%>" class="<%=classValue%>">&nbsp;</td>
									<td width="40%" style="font-size:10" class="<%=classValue%>" nowrap ><%=dischargepres.get(i+4)%></td>
<%
								}
%>
								<td width="50%" style="font-size:10" class="<%=classValue%>" nowrap><%=qty+"&nbsp;"+dischargepres.get(i+6)+"&nbsp;-&nbsp;"+dischargepres.get(i+8)+"&nbsp;for&nbsp;"+dischargepres.get(i+9)+" "+dischargepres.get(i+11)%></td>
							</tr>
<%
							recCount++;
						}
%>
						<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
						<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
						 <input type="hidden" value="<%= patient_id %>" name="patient_id">
						<input type="hidden" value="<%= encounter_id %>" name="encounter_id">
						<input type="hidden" value="<%= pat_class %>" name="pat_class">
						<input type="hidden" value="<%= ord_status %>" name="ord_status">
						<input type="hidden" value="<%= order_from %>" name="order_from">
						<input type="hidden" value="<%= pract_id %>" name="pract_id">
						<input type="hidden" value="<%= order_id %>" name="order_id">
						<input type="hidden" value="<%= order_to %>" name="order_to">
						<input type="hidden" value="<%= rx_type %>" name="rx_type">
						<input type="hidden" name="params" id="params" value="<%= params %>">
						<input type="hidden" name="fromdisc" id="fromdisc" value="<%=fromdisc%>">
						<input type="hidden" name="overrideflag" id="overrideflag" value="<%= overrideflag %>">
					</table>
				</div>
			</form>
			<script>
				function scrollit() {
				  eldata=document.getElementById("DataTab");
				  elheader=document.getElementById("HTab");
				  //x=eldata.scrollLeft;
				  elheader.scrollLeft=eldata.scrollLeft;
				} 
			</script>
		</body>
<%
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
</html>

