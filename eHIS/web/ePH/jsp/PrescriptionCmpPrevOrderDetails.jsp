<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
06/01/2021		TFS-7345           Prabha      06/01/2020	  Manickavasagam J         MMS-DM-CRF-0177
--------------------------------------------------------------------------------------------------------------
*/
%> 

 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>	
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086 
		String locale = (String) session.getAttribute("LOCALE");
		
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/common.js" ></script>
	<script language="JavaScript" src="../js/PrescriptionComp.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><fmt:message key="ePH.ViewOrder.label" bundle="${ph_labels}"/></title>
</head>
<%
	String patient_name ="";
	String age ="";
	String sex ="";	
	String patient_id		=	request.getParameter("patient_id");
	String encounter_id		=	request.getParameter("encounter_id");
	String pract_name		=	request.getParameter("pract_name");
	String locn_code		=	request.getParameter("locn_code");
	String date				=	request.getParameter("ord_date");
	String patient_class	=	request.getParameter("patient_class");		
	String pres_by1			=	request.getParameter("pres_by");	
	String freq_code		=	request.getParameter("freq_code");	
	String dosage			=	request.getParameter("dosage");	
	String duration			=	request.getParameter("duration");	
	String start_date		=	request.getParameter("start_date");	
	String end_date			=	request.getParameter("end_date");	
	String freq_desc		=	request.getParameter("freq_desc");	
	String dosage_unit		=	request.getParameter("dosage_unit");	
	String durn_unit		=	request.getParameter("durn_unit");	
	String pres_by			=	"Strength";	
	String forValue			=   "for";
	String drugindication_remarks	=   "";//added for MMS Adhoc Testing

	if(dosage.equals("")||dosage.equals("0"))
	{
		dosage="";
		dosage_unit="";			
	}
	if(freq_code.equals(""))
	{
		freq_desc="";
		forValue ="";
		duration="";
		durn_unit="";	
	}

	if(pres_by1.equals("P"))
		pres_by="Percentage";
	else if(pres_by1.equals("R"))
		pres_by="Ratio";
	else
		pres_by="Strength";

	ArrayList local_list=new ArrayList();
	for(int i=1;i<=10;i++)
	{
		if(request.getParameter("drug_code"+i)!=null)
		{
			HashMap localDetails=new HashMap();
			localDetails.put("L_DRUG_CODE",request.getParameter("drug_code"+i));
			localDetails.put("L_ABS_QTY",request.getParameter("absol_qty"+i));
			localDetails.put("L_PER_RAT",request.getParameter("percent_ratio"+i)==null?"":request.getParameter("percent_ratio"+i));
			localDetails.put("DrugIndicationRemarks",request.getParameter("DrugIndicationRemarks"+i)==null?"":request.getParameter("DrugIndicationRemarks"+i));//DrugIndicationRemarks added for MMS Adhoc Testing
			local_list.add(localDetails);
		}
	}	
	String bean_id			= "IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id, bean_name, request);
	String locn_desc	   = bean.getLocationDesc(patient_class,locn_code);
	ArrayList pat_details	= bean.getPatientDetails(patient_id);

	if (pat_details.size() != 0) {
		patient_name	= (String)pat_details.get(0);
		sex				= (String)pat_details.get(1);
		age				= (String)pat_details.get(2);
	}
	ArrayList drugList=(ArrayList)bean.getDrugDetails();
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name="frmPrescriptionPrevOrder" id="frmPrescriptionPrevOrder">
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<tr><td class="COLUMNHEADER" colspan=4><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td></tr>
	<tr>
		<td  class="label" width="20%"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>:</td>
		<td class="data"   width="30%">&nbsp;&nbsp;<%=patient_name%></td>
		<td  class="label" width="20%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>:</td>
		<td class="data"   width="30%">&nbsp;&nbsp;<%=patient_id%></td>
	</tr>
	<tr>
		<td  class="label" width="20%"><fmt:message key="Common.age.label" bundle="${common_labels}"/>:</td>
		<td class="data"   width="30%">&nbsp;&nbsp;<%=age%></td>
		<td  class="label" width="20%"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>:</td>
		<td class="data"   width="30%">&nbsp;&nbsp;<%=encounter_id%></td>
	</tr>
	<tr>
		<td  class="label" width="20%"><fmt:message key="Common.gender.label" bundle="${common_labels}"/>:</td>
		 <td  class="data"   width="30%">&nbsp;&nbsp;<%=sex%></td>
		<td  class="label" width="20%"><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/>:</td>
		<td  class="data"   width="30%">&nbsp;&nbsp;<%=date%></td>
	</tr>
	<tr>
		<td  class="label" width="20%"><fmt:message key="Common.Location.label" bundle="${common_labels}"/>:</td>
		<td  class="data"   width="30%">&nbsp;&nbsp;<%=locn_desc%></td>
		<td  class="label" width="20%"><fmt:message key="Common.PrescribedBy.label" bundle="${common_labels}"/>:</td>
<%
		if(pract_name!=null && !(pract_name.equals("")))
		{
			pract_name  =java.net.URLDecoder.decode(pract_name,"UTF-8");
		}

%>
		<td  class="data"   width="30%">&nbsp;&nbsp;<%=pract_name %></td>
	</tr>
	</table>
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">	
	<br>
	<table  cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<tr><td class="COLUMNHEADER" colspan=4><fmt:message key="Common.OrderDetails.label" bundle="${common_labels}"/></td></tr>
	<tr>
	<td class="label" colspan=2><fmt:message key="ePH.PrescribingBy.label" bundle="${ph_labels}"/>:&nbsp;<b><%=pres_by%></b><br>&nbsp;</td>
	<td class="label" colspan=2><fmt:message key="Common.from.label" bundle="${common_labels}"/> &nbsp;<b><%=start_date%></b>&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<b><%=end_date%><br>&nbsp;</b></td>
	</tr>
	<tr>
	<td class="data">&nbsp;&nbsp;<fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>
	<td class="data"><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></td>
	<td class="data">Percentage/Ratio</td>
	<td class="data"><fmt:message key="Common.OrderQty.label" bundle="${common_labels}"/></td>	
	</tr>
	<%
			HashMap record=null;
			String strength_value="";
			String strength_uom="";
			String pres_base_uom="";
			String orig_drug_code="";
			String freq_str="";
			String facility_id = (String)session.getValue("facility_id");
			boolean first=true;
			ArrayList schedule=null;
			
			//Added for MMS-DM-CRF-0177
			String new_generic_name = "";
			String drug_search = "";
			String pre_alloc_appl = "";
			pre_alloc_appl = bean.getPreAllocApplYN();
			//Added for MMS-DM-CRF-0177
			
			for(int count=0;count<drugList.size();count++)
			{
				record=(HashMap)drugList.get(count);
				orig_drug_code  =(String)record.get("DRUG_CODE");	
				if(first)
				{
					schedule	=	(ArrayList)bean.getScheduleFrequencyStr(orig_drug_code,"0");
					freq_str = (String)bean.getTooltipStringFrFreq(schedule,"prvwString"+bean.getUomDisplay((String)session.getValue("facility_id"),dosage_unit));
					first=false;
				}
				HashMap local_record=null;
				String percent_ratio="";
				for(int j=0;j<local_list.size();j++)
				{
					local_record=(HashMap)local_list.get(j);
					String abs_qty="";
					if(((String)local_record.get("L_DRUG_CODE")).equals(orig_drug_code))
					{	
						strength_value  =((String)record.get("STRENGTH_VALUE")).equals("0")?"":(String)record.get("STRENGTH_VALUE");
						strength_uom="";
						if(!strength_value.equals(""))
							strength_uom    =(String)record.get("STRENGTH_UOM");
						abs_qty			=(String)local_record.get("L_ABS_QTY")==null?"":(String)local_record.get("L_ABS_QTY");
						drugindication_remarks=	(String)local_record.get("DrugIndicationRemarks")==null?"":(String)local_record.get("DrugIndicationRemarks");//added for MMS Adhoc Testing
						if(pres_by1.equals("P"))
						{
							if(((String)local_record.get("L_PER_RAT")).equals(""))
							{
								percent_ratio="Base";
							}
							else
							{
								percent_ratio	=(String)local_record.get("L_PER_RAT")+"%";
							}
						}
						else if(pres_by1.equals("R"))
						{
							percent_ratio	=(String)local_record.get("L_PER_RAT");
						}
						else
						{
							percent_ratio	="";
						}
						pres_base_uom   =(String)record.get("PRES_BASE_UOM");
						if(strength_uom == null) strength_uom="";
						
						
						//Added for MMS-DM-CRF-0177
						drug_search = (String) record.get("DRUG_SEARCH_BY")==null?"":(String)record.get("DRUG_SEARCH_BY");
						if(pre_alloc_appl.equals("Y") && drug_search.equals("G"))
						{
							new_generic_name= (String)record.get("DRUG_DESC_NEW")==null?"":(String)record.get("DRUG_DESC_NEW");
						}
						else
						{
							new_generic_name= (String) record.get("DRUG_DESC")==null?"":(String)record.get("DRUG_DESC");
						}
						//Added for MMS-DM-CRF-0177
						
	%>					</tr>
						<td class="label"><%=new_generic_name%><br>&nbsp;</td> <!-- Modified for MMS-DM-CRF-0177 -->
						<td class="label"><%=strength_value%>&nbsp;<%=bean.getUomDisplay(facility_id,strength_uom)%></td>
						<td class="label">&nbsp;<%=percent_ratio%></td>
						<td class="label"><%=abs_qty%>&nbsp;<%=bean.getUomDisplay(facility_id,pres_base_uom)%></td>
						</tr>
	<%
			  //added for MMS Adhoc Testing-Start
			  if(!drugindication_remarks.equals("")) {
	%>
			<tr>
				<td class="label" colspan=2><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/>:&nbsp;<b><%=drugindication_remarks%></b><br>&nbsp;</td>
			</tr>
	<%
						}//added for MMS Adhoc Testing-End
					}
				}
	 
   %>
			
   <%
			}
	%>
	</table>
	<br>
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<tr><td class="COLUMNHEADER" colspan=3><fmt:message key="ePH.AdminDetails.label" bundle="${ph_labels}"/></td></tr>
	<tr>
	<td class="label"><fmt:message key="Common.Dosage.label" bundle="${common_labels}"/></td>
	<td class="Data"><%=dosage%>&nbsp;<%=dosage_unit%>&nbsp;&nbsp;</td>
	<td class="Data"><%=freq_desc%>&nbsp;<%=forValue%>&nbsp;<%=duration%>&nbsp;<%=durn_unit%></td></tr>
	<tr>
	<td class="label" colspan=3><br>&nbsp;<%=freq_str%>&nbsp;</td>
	</tr>
	<tr>
	
	
	<td colspan=3 align="right">
	<input type="button"   class="button" value='<fmt:message key="ePH.ReleaseRx.label" bundle="${ph_labels}"/>' name="release_rx" onclick="toCloseTopShowModal('R');"></input> 
	<!--added for ML-MMOH-CRF-0341 [IN:058111] -->
	<INPUT TYPE="button" CLASS="button" name="RELEASE" id="RELEASE" VALUE='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="toCloseTopShowModal();"></td></tr>
	</table>
		
</form>
</body>
</html>

