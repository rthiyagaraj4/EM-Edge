<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name				Rev.Date	Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
05/11/2019	IN070606		Ramesh Goli											MMS-KH-CRF-0029							
23/08/2020		IN073641		Manickavasagam			MMS-KH-CRF-0034 
------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper " %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
 
<html>
	<head>
		<title></title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086

		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/dchk.js"></script>
		<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/DrugInteraction.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>
	<body onMouseDown="CodeArrest();" onKeyDown="lockKey()">
<%
		try{
			int     recordcount    =   0;
			String intr_option,intr_name1,intr_name2,intr_code1,intr_code2, severity_level, significant_level, probability, interaction_desc, restrict_transaction, form_code1, form_code2, form_desc1, form_desc2;

			HashMap hmDrugIntList=null;
			ArrayList DrugInteractionDtl=new ArrayList();

			java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
			String bean_id		= "DrugInteractionBean" ;
			String bean_name	= "ePH.DrugInteractionBean";
			String facility_id					= (String) session.getValue("facility_id");
			String mode			= request.getParameter("mode");

			DrugInteractionBean bean = (DrugInteractionBean)getBeanObject( bean_id,bean_name,request) ;
			bean.setLanguageId(locale);
			bean.setMode( mode ) ;

			hmDrugIntList = bean.getDrugIntrList();
			String  classvalue = "";
			String intrDescDisplay		= "" ;
			String intr_Type		= "";
			String intr_Type_Desc	= "";
			String intractionBy_Desc ="";
			String lab_ord_chk_upto = ""; //MMS-KH-CRF-0034
			if(hmDrugIntList!=null && hmDrugIntList.size()> 0){
				List intrKeyList = new ArrayList(hmDrugIntList.keySet());
%>
				<form name="FormDrugInteractionList" id="FormDrugInteractionList">
					<TABLE name="DrugInteractionList" id="DrugInteractionList" cellspacing="0" cellpadding="0" border="1" width = "100%">   
						<tr>
						<td class='COLUMNHEADER' nowrap width='10%'>&nbsp;Intr. Type</td >  <!--//IN070606 -->
						<td class='COLUMNHEADER' nowrap width='5%'>&nbsp;<fmt:message key="ePH.IntrBy.label" bundle="${ph_labels}"/>&nbsp;</td >
						<td class='COLUMNHEADER' nowrap width='25%'>&nbsp;<fmt:message key="Common.generic.label" bundle="${common_labels}"/>/<fmt:message key="Common.Drug.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.name.label" bundle="${common_labels}"/>1&nbsp;</td >
						<td class='COLUMNHEADER' nowrap width='10%'>&nbsp;<fmt:message key="ePH.DosageForm.label" bundle="${ph_labels}"/>1</td >
						<td class='COLUMNHEADER' nowrap width='25%'>&nbsp;<fmt:message key="Common.generic.label" bundle="${common_labels}"/>/<fmt:message key="Common.Drug.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.name.label" bundle="${common_labels}"/>2&nbsp;</td >
						<td class='COLUMNHEADER' nowrap width='10%'>&nbsp;<fmt:message key="ePH.DosageForm.label" bundle="${ph_labels}"/>2</td >
						<td class='COLUMNHEADER' nowrap width='25%'>&nbsp;<fmt:message key="ePH.FoodItemIngredients.label" bundle="${ph_labels}"/>&nbsp;</td > <!--//IN070606 -->
						<td class='COLUMNHEADER' nowrap width='25%'>&nbsp;<fmt:message key="ePH.LaboratoryTestCode.label" bundle="${ph_labels}"/>&nbsp;</td > <!--//IN070606 -->
						<td class='COLUMNHEADER' nowrap width='25%'>&nbsp;<fmt:message key="Common.TermCodeDescription.label" bundle="${ph_labels}"/>&nbsp;</td >
						<td class='COLUMNHEADER' nowrap width='25%'>&nbsp;<fmt:message key="Common.TermSet.label" bundle="${common_labels}"/>&nbsp;</td >
						<td class='COLUMNHEADER' width='5%'>&nbsp;<fmt:message key="Common.Severity.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;</td >
						<td class='COLUMNHEADER' nowrap width='5%'>&nbsp;<fmt:message key="Common.significant.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;</td >
						<td class='COLUMNHEADER' nowrap width='5%'>&nbsp;<fmt:message key="ePH.documentation.label" bundle="${ph_labels}"/>&nbsp;</td >  <!-- added for FD-RUT-CRF-0066.1 [IN036975] -->
						<td class='COLUMNHEADER' width='5%'>&nbsp;<fmt:message key="ePH.RestrictTransaction.label" bundle="${ph_labels}"/>&nbsp;</td >
						<td class='COLUMNHEADER' nowrap width='10%'>&nbsp;<fmt:message key="ePH.Interaction.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/>&nbsp;</td > 
						<td class='COLUMNHEADER' width='5%' nowrap><fmt:message key="ePH.UptoNoofDays.label" bundle="${ph_labels}"/></td> <!-- MMS-KH-CRF-0034-->
						<td class='COLUMNHEADER' nowrap width='5%'>&nbsp;<fmt:message key="Common.Select.label" bundle="${common_labels}"/>&nbsp;</td >
					<tr>
<%
					for(int count=0 ; count<intrKeyList.size() ; count++){
						DrugInteractionDtl =(ArrayList) hmDrugIntList.get((String)intrKeyList.get(count));
						if ( count % 2 == 0 )
							classvalue = "QRYEVEN" ;
						else
							classvalue = "QRYODD" ;  
						intrDescDisplay = (String)DrugInteractionDtl.get(9);
						severity_level = (String)DrugInteractionDtl.get(5);
						probability = (String)DrugInteractionDtl.get(7);
						restrict_transaction = (String)DrugInteractionDtl.get(8);
						if(intrDescDisplay.length() > 15 )
							intrDescDisplay = intrDescDisplay.substring(0,14)+"...";
 
						lab_ord_chk_upto = (String)DrugInteractionDtl.get(16);//MMS-KH-CRF-0034
						//IN070606 Start.	
						intr_Type  = (String)DrugInteractionDtl.get(15);
						if("D".equals(intr_Type))
							intr_Type_Desc	= "Drug-Drug";
						else if("F".equals(intr_Type))
							intr_Type_Desc	= "Drug-Food";
						else if("L".equals(intr_Type))
							intr_Type_Desc	= "Drug-Labaratory";
						else if("I".equals(intr_Type))
							intr_Type_Desc	= "Drug-Disease";
							
						if("D".equals(DrugInteractionDtl.get(0)))
							intractionBy_Desc="Drug Name";
						else if("G".equals(DrugInteractionDtl.get(0)))
							intractionBy_Desc="Generic Name";
%>
						<tr >
							<TD class="<%=classvalue%>" nowrap> <%=intr_Type_Desc%> </TD>
							<TD class="<%=classvalue%>" nowrap> <%=intractionBy_Desc%> </TD>
							<TD class="<%=classvalue%>" nowrap > <font class='HYPERLINK' onmouseover="changeCursor(this);" onClick="update('<%=(String)DrugInteractionDtl.get(0)%>','<%=(String)DrugInteractionDtl.get(1)%>','<%=(String)DrugInteractionDtl.get(2)%>','<%=(String)DrugInteractionDtl.get(11)%>','<%=(String)DrugInteractionDtl.get(12)%>')">  <%=(String)DrugInteractionDtl.get(3)%></font> </TD>
							<TD class="<%=classvalue%>" nowrap> <%=DrugInteractionDtl.get(13)%> </TD>
							<%if("D".equals(intr_Type)){%>
								<TD class="<%=classvalue%>" nowrap> <%=DrugInteractionDtl.get(4)%> </TD>
								<TD class="<%=classvalue%>" nowrap> <%=DrugInteractionDtl.get(14)%> </TD>
							<%}else{%>
								<TD class="<%=classvalue%>" nowrap> &nbsp; </TD>
								<TD class="<%=classvalue%>" nowrap> &nbsp; </TD>
							<%}%>
							<%if("F".equals(intr_Type)){%>
								<TD class="<%=classvalue%>" nowrap> <%=DrugInteractionDtl.get(4)%> </TD>
							<%}else{%>
								<TD class="<%=classvalue%>" nowrap> &nbsp; </TD>
							<%}%>
							<%if("L".equals(intr_Type)){%>
								<TD class="<%=classvalue%>" nowrap> <%=DrugInteractionDtl.get(4)%> </TD>
							<%}else{%>
								<TD class="<%=classvalue%>" nowrap> &nbsp; </TD>
							<%}%>
							<%if("I".equals(intr_Type)){%>
								<TD class="<%=classvalue%>" nowrap> <%=DrugInteractionDtl.get(4)%> </TD>
							<%}else{%>
								<TD class="<%=classvalue%>" nowrap> &nbsp; </TD>
							<%}
							%>
							<TD class="<%=classvalue%>" nowrap> <%=DrugInteractionDtl.get(17)%> </TD>
							<TD class="<%=classvalue%>" nowrap> 
<%
							if(severity_level.equals("H")){
%>		
								<fmt:message key="ePH.Major.label" bundle="${ph_labels}"/>
<%
							}
							else if(severity_level.equals("M")){
%>
								<fmt:message key="Common.Moderate.label" bundle="${common_labels}"/>
<%
							}
							else if(severity_level.equals("L")){
%>
								<fmt:message key="ePH.Minor.label" bundle="${ph_labels}"/>
<%
							}
%>
							</TD>
							<TD class="<%=classvalue%>" nowrap> <%=DrugInteractionDtl.get(6)%> </TD>
							<TD class="<%=classvalue%>" nowrap> 
<%
							//if(probability.equals("D")){   Commented and added for FD-RUT-CRF-0066.1 [IN036975] --begin
%>		
								<!--<fmt:message key="Common.Definitive.label" bundle="${common_labels}"/>-->
<%
							//}
							//else if(probability.equals("P")){
%>
							<!--	<fmt:message key="Common.Probable.label" bundle="${common_labels}"/>-->
<%
						//	}

							if(probability.equals("E")){
%>		
							<fmt:message key="ePH.established.label" bundle="${ph_labels}"/>
<%
}							else if(probability.equals("P")){
%>		
	<fmt:message key="Common.Probable.label" bundle="${common_labels}"/>
<%
}							else if(probability.equals("S")){
%>		
	<fmt:message key="ePH.suspected.label" bundle="${ph_labels}"/>
<%
}							else if(probability.equals("O")){
%>		
	<fmt:message key="ePH.Possible.label" bundle="${ph_labels}"/>
<%
}							else if(probability.equals("U")){
%>		
	<fmt:message key="ePH.Unlikely.label" bundle="${ph_labels}"/>
<%
} //FD-RUT-CRF-0066.1 [IN036975] --end
%>
							</TD>
							<TD class="<%=classvalue%>" nowrap style='text-align:center'> 
<%
							if(restrict_transaction.equals("Y")){
%>		
								<img src='../../eCommon/images/enabled.gif'>
<%
							}
							else if(restrict_transaction.equals("N")){
%>
								<img src='../../eCommon/images/disabled.gif'>
<%
							}
%>
							</TD>
							<TD class="<%=classvalue%>" nowrap id='intr_desc<%=count%>'><%=intrDescDisplay%></TD>
							<script>
								assignTitle('<%=count%>','<%=java.net.URLEncoder.encode((String)DrugInteractionDtl.get(9),"UTF-8")%>' );
							</script>
						   <td class='<%=classvalue%>'><%=lab_ord_chk_upto%></td><!-- MMS-KH-CRF-0034-->
						   <td class='<%=classvalue%>'><input type="checkbox" checked name='eff_status_<%=count%>' id='eff_status_<%=count%>' value="E" onclick="setValue(this,'ES')">  </td>
						   <input type='hidden' name ='InteractionBy_<%=count%>' value='<%=DrugInteractionDtl.get(0)%>'>
						   <input type='hidden' name ='intr_code1_<%=count%>' value='<%=DrugInteractionDtl.get(1)%>'>
						   <input type='hidden' name ='intr_code2_<%=count%>' value='<%=DrugInteractionDtl.get(2)%>'>
						   <input type='hidden' name ='intr_name1_<%=count%>' value='<%=DrugInteractionDtl.get(3)%>'>
						   <input type='hidden' name ='intr_name2_<%=count%>' value='<%=DrugInteractionDtl.get(4)%>'>
						   <input type='hidden' name ='Severity_Level_<%=count%>' value='<%=DrugInteractionDtl.get(5)%>'>
						   <input type='hidden' name ='Significant_level_<%=count%>' value='<%=DrugInteractionDtl.get(6)%>'>
						   <input type='hidden' name ='Probability_<%=count%>' value='<%=DrugInteractionDtl.get(7)%>'>
						   <input type='hidden' name ='restrict_transaction_<%=count%>' value='<%=DrugInteractionDtl.get(8)%>'>
						   <input type='hidden' name ='form_code1_<%=count%>' value='<%=DrugInteractionDtl.get(11)%>'>
						   <input type='hidden' name ='form_code2_<%=count%>' value='<%=DrugInteractionDtl.get(12)%>'>
						   <input type='hidden' name ='lab_ord_check_for_upto_<%=count%>' value='<%=lab_ord_chk_upto%>'> <!-- MMS-KH-CRF-0034-->
					   </tr >
<% 
					}
				}
%>
				</TABLE>
				<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
				<input type="hidden" name="mode" id="mode" value="<%=mode%>">
				<input type="hidden" name='recCount' id='recCount' value=<%=hmDrugIntList.size() %> >
			</form>
<%
			putObjectInBean(bean_id,bean,request);
		}
		catch(Exception e){
			e.printStackTrace();
		}
%>
		</body>
	</html>

