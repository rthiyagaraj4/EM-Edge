<!DOCTYPE html>
 <!--
Fine Tuning
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
	<HEAD>
<%
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<script language="JavaScript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="JavaScript" SRC="../js/PhCommon.js"></SCRIPT>
	 	<SCRIPT LANGUAGE="JavaScript" SRC="../js/DrugDetailsDisplay.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</HEAD>

	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%

		String	bean_id			=	"DrugDetailsBean" ;
		String	bean_name		=	"ePH.DrugDetailsBean";

		DrugDetailsBean bean = (DrugDetailsBean)getBeanObject( bean_id,bean_name, request ) ;
		String drug_information = bean.getDRUG_INFORMATION()==null?"":bean.getDRUG_INFORMATION();
		String patient_education = bean.getPATIENT_EDUCATION()==null?"":bean.getPATIENT_EDUCATION();
		String drug_code = bean.getDRUG_CODE();
		String imageURL="";
		
		String category_group_code ="";
		String category_code1 ="";
		String category_code2 ="";
		String category_code3 ="";
		String category_group_desc= "";
		String b1= "";
		String b2 ="";

		if(!drug_code.equals("")){
			String img_bean_id = "DrugTradeImageBean" ;
			String img_bean_name = "ePH.DrugTradeImageBean";
			DrugTradeImageBean img_bean = (DrugTradeImageBean)getBeanObject( img_bean_id, img_bean_name, request ) ;
			imageURL = img_bean.getImagePath(drug_code,"");
		}
//bean.getDrugDetails();


%>


		<form name="DiscontinueDrugForm" id="DiscontinueDrugForm" >
			<BR>

			<table cellpadding="1" cellspacing="0" width="99%"  align="center" border="0">

				<tr>
					<th  align="left" colspan="4"><fmt:message key="Common.Characteristics.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td  class="label"  nowrap width='30%'><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/>&nbsp;</td>
					<td  class="label" align="left" nowrap width='30%'>&nbsp;<B><%=bean.getGenericName()%></B></TD>
					<td  class="label"  nowrap width='30%'><fmt:message key="ePH.AffectsLabResults.label" bundle="${ph_labels}"/>&nbsp;</td>
					<TD ALIGN="LEFT" CLASS="label" width='10%'>&nbsp;<B><%=getImage(bean.getAFFECTS_LAB_RESULTS_YN())%></B></TD>
				</tr>
				<tr>
					<td  class="label"  nowrap width='30%'><fmt:message key="ePH.DrugType.label" bundle="${ph_labels}"/>&nbsp;</td><td  class="label" align="left" nowrap width='30%'>&nbsp;<B><%=bean.getDRUG_TYPE()%></B></TD>
					<td  class="label" nowrap width='30%'><fmt:message key="ePH.StabilityApplicable.label" bundle="${ph_labels}"/>&nbsp;</td><TD ALIGN="LEFT" CLASS="label" width='10%'>&nbsp;<B><%=getImage(bean.getSTABILITY_REQD_YN())%></B></TD>
				</tr>

				<tr>
					<td  class="label" nowrap width='30%'><fmt:message key="ePH.Poisonous/Scheduled.label" bundle="${ph_labels}"/>&nbsp;</td>
					<TD ALIGN="LEFT" CLASS="label" width='30%'>&nbsp;<B><%=getImage(bean.getSCHEDULED_DRUG_YN())%></B></TD>
					<td  class="label"  nowrap width='30%'><fmt:message key="ePH.Stability.label" bundle="${ph_labels}"/>&nbsp;</td>
					<TD ALIGN="LEFT" CLASS="label" width='10%'>&nbsp;<B><%=bean.getSTABILITY_HRS()%></B></TD>
				</tr>
				<tr>
					<td  class="label" width='30%'><fmt:message key="Common.Schedule.label" bundle="${common_labels}"/>&nbsp;</td>
					<TD ALIGN="LEFT" CLASS="label" width='30%'>&nbsp;<B><%=bean.getSCHEDULE_DESC()%></B></TD>
					<td  class="label"  nowrap width='30%'><fmt:message key="ePH.PatientCounsellingRequired.label" bundle="${ph_labels}"/>&nbsp;</td>
					<TD ALIGN="LEFT" CLASS="label" width='10%'>&nbsp;<B><%=getImage(bean.getPATIENT_COUNSELING_REQD())%></B></TD>
				</tr>
				<tr>
					<td  class="label" nowrap width='30%'><fmt:message key="ePH.Non-EssentialRestrictedDrug.label" bundle="${ph_labels}"/>&nbsp;</td>
					<TD ALIGN="LEFT" CLASS="label" width='30%'>&nbsp;<B><%=getImage(bean.getRESTRICTED_DRUG_YN())%></B></TD>
					<td  class="label"  nowrap width='30%'><fmt:message key="ePH.TDMApplicable.label" bundle="${ph_labels}"/>&nbsp;</td>
					<TD ALIGN="LEFT" CLASS="label" width='10%'>&nbsp;<B><%=getImage(bean.getTDM_APPLICABLE())%></B></TD>
				</tr>
				<tr>
					<td  class="label"  nowrap width='30%'><fmt:message key="ePH.AffectsPregnancy.label" bundle="${ph_labels}"/>&nbsp;</td>
					<TD ALIGN="LEFT" CLASS="label" width='30%'>&nbsp;<B><%=getImage(bean.getAFFECTS_PREGNANCY_YN())%></B></TD><TD ALIGN="LEFT" CLASS="label" colspan=2></td></tr>
				
				<!-- code added for Pregnancy Category Codes on 8/8/09 -->	
				   <% 
				    category_group_code=bean.getPREG_CATEGORY_GROUP_CODE();
					//out.println("category_group_code-->"+category_group_code+"-->bean.getAFFECTS_PREGNANCY_YN()-->"+bean.getAFFECTS_PREGNANCY_YN());
					if (bean.getAFFECTS_PREGNANCY_YN().equals("Y")){
					if (category_group_code != ""){
					category_group_desc = bean.getFDACategoryGroupDesc(category_group_code);
					category_code1 = bean.getPREG_CATEGORY_CODE1();
					category_code2 = bean.getPREG_CATEGORY_CODE2();
					category_code3 = bean.getPREG_CATEGORY_CODE3();	
					
				%>
				    
					 <tr><td  class="label"  nowrap ><fmt:message key="ePH.PregnancyCategory.label" bundle="${ph_labels}"/> </td>
					<TD ALIGN="LEFT" CLASS="label" nowrap colspan=2><b>&nbsp;<%=category_group_desc%></b></TD> </tr>	<%if (!(category_code1.equals(""))){
						   b1= "(";
						   b2 =")";
					 %>	
					<tr><td  class="label"nowrap ><fmt:message key="ePH.FirstTrimester.label" bundle="${ph_labels}"/> </td>
					<TD ALIGN="LEFT" CLASS="label" nowrap colspan=3>
					<textarea  rows="2" cols="80"   readOnly ><%=b1%><%=category_code1%><%=b2%>&nbsp;&nbsp;<%=bean.getFDACategoryDesc(category_group_code,category_code1)%> </textarea></TD></tr>
					
					<%}
					b1="";b2="";
					if (!(category_code2.equals(""))){
					     b1= "(";b2 =")";
				    %>
					<tr><td  class="label"  nowrap ><fmt:message key="ePH.SecondTrimester.label" bundle="${ph_labels}"/> &nbsp;</td>
					<TD ALIGN="LEFT" CLASS="label" colspan=3><textarea  rows="2" cols="80"   readOnly ><%=b1%><%=category_code2%><%=b2%>&nbsp;&nbsp;<%=bean.getFDACategoryDesc(category_group_code,category_code2)%></textarea></TD></tr>
					<%}
					b1="";b2="";
					if (!(category_code3.equals(""))){
					     b1= "(";b2 =")";
				   
					%>
					<tr><td  class="label"  nowrap ><fmt:message key="ePH.ThirdTrimester.label" bundle="${ph_labels}"/>&nbsp;</td>
					<TD ALIGN="LEFT" CLASS="label" colspan=3><textarea  rows="2" cols="80"   readOnly ><%=b1%><%=category_code3%><%=b2%>&nbsp;&nbsp;<%=bean.getFDACategoryDesc(category_group_code,category_code3)%></textarea></TD></tr>
					<%}
					b1="";b2="";
					}}%>
					
				<!-- code ended for pregnancy Category Codes  -->
					<tr><td  class="label" nowrap width='30%'><fmt:message key="ePH.VerbalOrderApplicableduringMAR.label" bundle="${ph_labels}"/>&nbsp;</td>
					<TD ALIGN="LEFT" CLASS="label" width='10%'>&nbsp;<B><%=getImage(bean.getVERBAL_ORDER_APPL_DRNG_MAR())%></B></TD><TD ALIGN="LEFT" CLASS="label" colspan=2></td>
				</tr>
				
				<tr>
					<td  class="label"  nowrap width='30%'><fmt:message key="ePH.AffectsBreastFeeding.label" bundle="${ph_labels}"/>&nbsp;</td>
					<TD ALIGN="LEFT" CLASS="label" width='30%'>&nbsp;<B><%=getImage(bean.getAFFECTS_BREAST_FEEDING_YN ())%></B></TD>
					<td  class="label"  nowrap width='30%'><fmt:message key="ePH.UsedforExtemporaneouspreparation.label" bundle="${ph_labels}"/>&nbsp;</td>
					<TD ALIGN="LEFT" CLASS="label" width='10%'>&nbsp;<B><%=getImage(bean.getAPPL_FOR_COMPOUNDING_RX())%></B></TD>
				</tr>
<%
				if(!patient_education.equals("")){
%>
					<tr>
						<td class="label"   colspan='4'><fmt:message key="ePH.DrugInformation.label" bundle="${ph_labels}"/></td>
					</tr>
					<tr>
						<td width='15%'>&nbsp;</td>
						<td class="label"  colspan='4'><%=drug_information%></td>
					</tr>
<%
				}
				if(!patient_education.equals("")){
%>
					<tr>
						<td class="label"  colspan='4'><fmt:message key="ePH.PatientEducation.label" bundle="${ph_labels}"/></td>
					</tr>
					<tr>
						<td width='15%'>&nbsp;</td>
						<td class="label" colspan='4'><%=patient_education%></td>
					</tr>
<%
				}
%>
				<tr>
					<td colspan="6" class='label'>
<%

						if(!imageURL.equals("")){
%>
							<img src='../../ePH/images/camera.gif' width='20' height='17' onclick = "showImage('<%=drug_code%>');" onmouseover="changeCursor(this);"  style='backgroundColor:white;'>
<%
						}
%>
					</td>
				</tr>
				<tr>
					<td colspan="6">&nbsp;</td>
				</tr>

			</table>
		</FORM>
<%!
		public String getImage(String value){
			if(value.equalsIgnoreCase("Y"))
				return "<img src=\"../../eCommon/images/enabled.gif\">";
			else
				return "<img src=\"../../eCommon/images/disabled.gif\">";
		}
%>
	</BODY>
</HTML>

<%
	putObjectInBean(bean_id,bean,request);
%>

