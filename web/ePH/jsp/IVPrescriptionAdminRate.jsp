<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.* ,java.text.DecimalFormat" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%!
	public double roundToDecimals(double d, int c) {
		int temp=(int)((d*Math.pow(10,c)));
		return (((double)temp)/Math.pow(10,c));
}
%>
<%
	String patient_id			= request.getParameter("patient_id");
	String encounter_id			= request.getParameter("encounter_id");
	String weight				= request.getParameter("weight");
	String infuse_over			= request.getParameter("infuse_over");
	String infustion_uom		= request.getParameter("infustion_uom")==null?"":request.getParameter("infustion_uom");
	String dosage				= request.getParameter("dosage")==null?"":request.getParameter("dosage");
	String dosage_type			= request.getParameter("dosage_type")==null?"":request.getParameter("dosage_type");
	String strength				=""; 
	String uom_id				="";

	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id, bean_name, request);

	ArrayList uom_details		= null;
	double admin_rate			=0.0;
	double tmp_admin_rate		=0.0;
	String admin_rate_uom		="";
%>

<HTML>
	<HEAD>
		<TITLE><fmt:message key="ePH.AdminRate.label" bundle="${ph_labels}"/></TITLE>
	<%
			request.setCharacterEncoding("UTF-8");
			String locale			= (String)session.getAttribute("LOCALE");
			
			String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
			<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
			<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
			<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/IVPrescriptionWithAdditives.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</HEAD>

		<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
			<FORM name="formIVPrescriptionPreviewDetails" id="formIVPrescriptionPreviewDetails">
				<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
<%
					if(weight != null && !weight.equals("0.00") && !weight.equals("") && infuse_over != null && !infuse_over.equals("")){
%>
						<TR>
							<th  WIDTH="2%">&nbsp;</th>
							<th  WIDTH="58%" style="font-size:10"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/> &nbsp; <fmt:message key="Common.name.label" bundle="${common_labels}"/></th>
							<th  WIDTH="20%" style="font-size:10"></th>
							<th  WIDTH="2%">&nbsp;</th>
						</TR>
<%
						ArrayList drugList = bean.getDrugDetails();
						StringBuffer strBuffer = new StringBuffer("");
						Float dosage_strenth=null;//Added for ARYU-SCF-0074
					     int cunt=1;//Added for ARYU-SCF-0074
						 String strength_per_value_pres_uom = "";//Added for ARYU-SCF-0074
						if (drugList.size() != 0) {
							for (int i=0; i<drugList.size(); i++) {
								HashMap drugDetails	= (HashMap)drugList.get(i);
								if(drugDetails.size()>0){ //If 'condition alone' added for SRR20056-SCF-7650  Incident No. 27732
									if(dosage_type.equals(""))
										dosage_type = (String)drugDetails.get("DOSAGE_TYPE");
									if(dosage_type.equals("S") ){
										uom_id			= (String)drugDetails.get("STRENGTH_UOM");
										admin_rate_uom  = (String)drugDetails.get("STRENGTH_UOM");
										uom_details		= bean.getExistingUom(uom_id);
										strength		= (String)drugDetails.get("QTY_VALUE");
										if(dosage==null || dosage.equals("")) //If block added for SRR20056-SCF-7650  Incident No. 27732
											dosage = (String)drugDetails.get("STRENGTH");
									}
									if(dosage_type.equals("Q") ){		//Adding start for ARYU-SCF-0074				
										uom_id			= (String)drugDetails.get("STRENGTH_UOM");
										admin_rate_uom  = (String)drugDetails.get("STRENGTH_UOM");
									 strength_per_value_pres_uom = (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");//added for SCF-10230
										
										uom_details		= bean.getExistingUom(uom_id);
										 if((dosage!="" || dosage!=null))
											{
														dosage_strenth = new Float((Float.parseFloat((String)drugDetails.get("STRENGTH_VALUE"))/Float.parseFloat(strength_per_value_pres_uom))*Float.parseFloat((String)drugDetails.get("QTY_VALUE")));
																
												dosage=dosage_strenth.toString();

											}
											else{
												dosage_strenth=new Float((Float.parseFloat((String)drugDetails.get("STRENGTH_VALUE"))/Float.parseFloat(strength_per_value_pres_uom))*Float.parseFloat(dosage));
												dosage=dosage_strenth.toString();
												
											}
										
									}//Adding end for ARYU-SCF-0074

										if(infustion_uom.equals("H") || infustion_uom.equals("M")){
											strength = dosage;
										}// this line was  commented before, but opened it for issue : 26189
										DecimalFormat formatter = new DecimalFormat("##0.0####");
										if(infustion_uom.equals("M")){
											admin_rate	= Float.parseFloat(strength)/(Float.parseFloat(infuse_over)* Float.parseFloat(weight));

										}else {
										    try {
										        admin_rate = Float.parseFloat(strength) / (Float.parseFloat(infuse_over) * Float.parseFloat(weight) * 60);
										    } catch (NumberFormatException e) {
										        // Handle the exception, maybe print an error message or set a default value
										        System.out.println("Invalid input: please ensure all inputs are valid numbers.");
										        admin_rate = 0.0f; // You can set a default value or handle it differently
										    } catch (Exception e) {
										        // General exception handling (optional)
										        System.out.println("An error occurred: " + e.getMessage());
										        admin_rate = 0.0f; // You can set a default value or handle it differently
										    }
										}

										String temFormated = formatter.format(admin_rate);
										tmp_admin_rate     = roundToDecimals(admin_rate,5)	;

										if(admin_rate < 1){
											for(int j=0; j<uom_details.size(); j++){
												HashMap uom_values = null;
												uom_values     = (HashMap)uom_details.get(j);
												tmp_admin_rate = admin_rate * Float.parseFloat((String)uom_values.get("EQVL_VALUE"));											
												admin_rate_uom = (String)uom_values.get("UOM_CODE");//changed EQVL_UOM_CODE to UOM_CODE for ARYU-SCF-0074
												if(tmp_admin_rate >=1) 
													break;
											}
										}
										
								/*		if(tmp_admin_rate!=0) {	

											String rate		=	tmp_admin_rate+"";	
											int index		=	rate.indexOf(".");
											int tot_len		=	rate.length();
											if(tot_len>=index+3) {
												tmp_admin_rate	=	Double.parseDouble(rate.substring(0,index+3));
											}
										}*/

										if(tmp_admin_rate<1) {
											
									%><TR><td  WIDTH="2%">&nbsp;</td>
									   <td CLASS="data"><%= drugDetails.get("GENERIC_NAME") %>
										<FONT COLOR="RED"><B><fmt:message key="ePH.NoAdminRateiscalculatedwithpositiveunit.label" bundle="${ph_labels}"/></B></FONT>
										</td>
										<td  WIDTH="2%">&nbsp;</td>
										<td  WIDTH="2%">&nbsp;</td>
										</TR>
									<%
										continue; 
										}
										else {
											String adm_rate_strng = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.AdminRate.label","ph_labels");   
											if(strBuffer.length()!=0) 
												strBuffer.append(" , ");
											else {strBuffer.append(adm_rate_strng);
												 strBuffer.append(" : ");
											}
											strBuffer.append(drugDetails.get("GENERIC_NAME"));
											strBuffer.append(" ");
											strBuffer.append(tmp_admin_rate);
											strBuffer.append(" ");
											strBuffer.append(admin_rate_uom);
											strBuffer.append("/");
											strBuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.kg.label","common_labels"));
											strBuffer.append("/");
											strBuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MIN.label","common_labels"));
						//					strBuffer.append("/kg/min");
											admin_rate_uom = bean.getUomDisplay((String)session.getValue("facility_id"),admin_rate_uom);
										}
	%>
										<TR>
											<TD CLASS="label">&nbsp;</TD>
											<TD CLASS="data" style="font-size:10"><%= drugDetails.get("GENERIC_NAME") %></TD>
											<TD CLASS="data" style="font-size:10"><%=tmp_admin_rate%></TD>
											<TD CLASS="data" style="font-size:10"><%=admin_rate_uom%>/<fmt:message key="Common.kg.label" bundle="${common_labels}"/>/<fmt:message key="Common.MIN.label" bundle="${common_labels}"/></TD>
										</TR>
	<% 
									
								}
							}
						}
						bean.setAdminRate(strBuffer.toString());
					}
					else{
%>
						<br>
						<br>
						<br>
						<TR align='center'>	&nbsp;&nbsp;&nbsp;<FONT SIZE="2" face='verdana' COLOR="Red"><B><fmt:message key="ePH.WeightisMandatoryforCalculatingAdminRate..label" bundle="${ph_labels}"/></B></FONT>
		
					</TR>
<%
				}
%>
			</TABLE> 
		</FORM>
	</BODY>
</HTML>
<%
	putObjectInBean(bean_id,bean,request);
%>

