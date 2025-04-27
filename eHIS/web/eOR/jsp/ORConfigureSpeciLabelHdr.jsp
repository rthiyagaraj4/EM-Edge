<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="java.sql.*, java.util.*, java.io.*,eOR.*,eCA.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<html>
<head>
	<%
	
	 
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<!--<link rel='StyleSheet' href='../../eCommon/html/grid.css' type='text/css' />-->
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>	
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>	
	<script language='javascript' src='../../eOR/js/ORConfigureSpeciLabelFmt.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="ORConfigSpecLabelFrm" id="ORConfigSpecLabelFrm" target='messageFrame'>

<%	
	String mode  ="";	
	String display_specimen_no  ="display:inline";
	String display_specimen_label  ="display:none";
	String config_ref_no  ="";
	String spec_frmt_type = "NF";
	String facility_id ="";
	String ext_appl ="";
	String appl_ord_type ="A";
	String spec_format ="";
	CommonCollectionUtils<String, String> specimenNoFrmtMap = null;
	CommonCollectionUtils<String, String> extApplicationsMap = null;
	CommonCollectionUtils<String, String> facilityMap = null;
	HashMap<String, String> dataMap = null;	
try{
	java.util.Properties props = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) props.getProperty("LOCALE");
	String bean_id = "Or_ConfigSpecimenLabel" ;
	String bean_name = "eOR.ORConfigSpeciLabelFrmtBean";
	mode         = request.getParameter( "mode" )==null?"1":request.getParameter( "mode" );
	appl_ord_type         = request.getParameter( "appl_ord_type" )==null?"A":request.getParameter( "appl_ord_type" );
//	specimen_type         = request.getParameter( "specimen_type" )==null?"NF":request.getParameter( "specimen_type" );
	config_ref_no         = request.getParameter( "config_ref_no" )==null?"":request.getParameter( "config_ref_no" );
	
	ORConfigSpeciLabelFrmtBean configSpecimenLabel = (ORConfigSpeciLabelFrmtBean)getObjectFromBean(bean_id,bean_name,session);	
	configSpecimenLabel.setLanguageId(localeName);
	configSpecimenLabel.clearObject();	
	configSpecimenLabel.setMode( mode ) ;
	specimenNoFrmtMap = configSpecimenLabel.getSpecimenNoFormats();		
	extApplicationsMap = configSpecimenLabel.getExtApplications();		
	facilityMap = configSpecimenLabel.getFacilities();		
	
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY") ) )
	{
		dataMap = configSpecimenLabel.loadData(config_ref_no.trim()) ;	
		
		if(dataMap != null  && dataMap.size() > 0)
		{			
			facility_id =dataMap.get("FACILITY_ID")==null?"":dataMap.get("FACILITY_ID");
			ext_appl =dataMap.get("EXT_APPL")==null?"":dataMap.get("EXT_APPL");
			spec_format =dataMap.get("SPEC_NUM_FORMAT")==null?"":dataMap.get("SPEC_NUM_FORMAT");
			appl_ord_type =dataMap.get("APPL_ORDER_TYPE")==null?"A":dataMap.get("APPL_ORDER_TYPE");
			
		}
	}
	
	%>
			<table cellpadding='2' cellspacing='2'  name='OROrderentryreport' id='OROrderentryreport'  width='80%' align='center'>			 
       <tr>	
				    <td class="Label" width="30%"><fmt:message  key="Common.facility.label" bundle="${common_labels}"/></td>
				    <td  class="fields" ><select name='facility_id' id='facility_id' onchange="loadOrderTypes(this)" <%if(mode.equals("2")){%>disabled<%}%>>
				        <option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<%					if(facilityMap != null && facilityMap.size() > 0)
							{								
								List<String> facilityLst = facilityMap.keyList();
								for (int i = 0; i<facilityLst.size();i++)
								{ %>
									<option value="<%=facilityLst.get(i)%>" <%if(facility_id.equals(facilityLst.get(i))){%>selected<%}%>><%=facilityMap.get(facilityLst.get(i))%></option>
	<%							}
							}
						
	%>
				        </select><img src="../../eCommon/images/mandatory.gif"></td>
		</tr>						
						<tr  id="Specimen_No_fmt" >
		            <td class="Label" width="30%"><fmt:message  key="eOR.SpecimenNoFormat.label" bundle="${or_labels}"/></td>
				    <td  class="fields" ><select name='spec_num_format' id='spec_num_format' onchange="loadOrderTypes(this)" <%if(mode.equals("2")){%>disabled<%}%>>
				        <option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option>

	<%					if(specimenNoFrmtMap != null && specimenNoFrmtMap.size() > 0)
							{								
								List<String> specimenNoFrmtLst = specimenNoFrmtMap.keyList();
								for (int i = 0; i<specimenNoFrmtLst.size();i++)
								{%>
									<option value="<%=specimenNoFrmtLst.get(i)%>" <%if(spec_format.equals(specimenNoFrmtLst.get(i))){%>selected<%}%>><%=specimenNoFrmtMap.get(specimenNoFrmtLst.get(i))%></option>
	<%							}
							}
						
	%>
						  </select><img src="../../eCommon/images/mandatory.gif"></td>
						</tr>
						 <tr> 
		           <td class="Label"><fmt:message  key="eOR.ApplicableOrderType.label" bundle="${or_labels}"/></td>
				   <td><input type="radio" name='appl_order_type' id='appl_order_type' value='A' <%if(appl_ord_type.equals("A")){%> checked<%}%> onclick='getordertype(this)'><fmt:message key="Common.all.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;<input type="radio" name="appl_order_type" id="appl_order_type" <%if(appl_ord_type.equals("S")){%> checked<%}%> value="S"  onclick='getordertype(this)'><fmt:message key="Common.specific.label" bundle="${common_labels}" /></td></tr>     
	  
</table>
    <input type="hidden" name="mode" id="mode" value="<%=mode%>">
    <input type="hidden" name="ext_appl" id="ext_appl" value="IBAOR">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="config_ref_no" id="config_ref_no" value="<%=config_ref_no%>">
	<input type="hidden" name="spec_frmt_exists_yn" id="spec_frmt_exists_yn" value="">
	</form>

<%	
putObjectInBean(bean_id,configSpecimenLabel,session);

		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY") ) &&  appl_ord_type.equals("S"))
		{
		%>
			<script>					
				//parent.configSpecimenFormat.rows = "9%,25%,*,10%";
		parent.document.getElementById("commontoolbarFrame").style.height="8vh";
		parent.document.getElementById("frameCofigSpecimenFrmt").style.height="25vh";
		parent.document.getElementById("frameCofigSpecimenFrmtDtl").style.height="55vh";
		parent.document.getElementById("messageFrame").style.height="14vh";		
				
				parent.frameCofigSpecimenFrmtDtl.location.href='../../eOR/jsp/ORConfigureSpeciLabelForOrderType.jsp?config_ref_no=<%=config_ref_no%>&mode=<%=mode%>&facility_id=<%=facility_id%>';
    		</script>
	<%	
		}			
	
}catch(Exception e){	
	e.printStackTrace();
}%>	
</body>
</html>


