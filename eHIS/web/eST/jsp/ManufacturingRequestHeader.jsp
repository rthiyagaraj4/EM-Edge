<!DOCTYPE html>
 <%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
02/05/2014				48528			        Abdul Rabbani      08/05/2014        Abdul Rabbani           HSA-CRF-0168
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
 <%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<jsp:useBean id="obj1" scope="page" class="eST.ManufacturingRequestBean"/>
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language='javascript' src="../../eST/js/ManufacturingRequest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");



//pmd 29/01/05	
//	java.util.HashMap defaultParameter = null;
	String bean_id = "ManufacturingRequestBean";
	String bean_name = "eST.ManufacturingRequestBean";
//	String disable ="";
	ManufacturingRequestBean bean = (ManufacturingRequestBean) getBeanObject( bean_id,bean_name,request);  
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setLanguageId(locale);


//	String index				=	bean.checkForNull(request.getParameter("index"),"-1");
	String disablefield="";
	String mode	= request.getParameter( "mode" )==null?"":  request.getParameter( "mode" );
//	ArrayList dataList=new ArrayList();
//	ArrayList recordSet=new ArrayList();
	
	int seq_no=bean.getSeqNo();
	bean.setExtemp_item_seq(""+seq_no);
		if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	
	//Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014
    String ACC_ENTITY_ID = "ZZ";
    HashMap hmTemp	=	(HashMap)bean.fetchRecord(" SELECT PREP_PREPACK_LG,PREP_STDFORM_LG,PREP_EXTEMP_LG,PREP_OTHERS_LG FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID = ?",ACC_ENTITY_ID);
		 
     String prep_prepack  =   bean.checkForNull((String)hmTemp.get("PREP_PREPACK_LG"));
     String prep_standard =   bean.checkForNull((String)hmTemp.get("PREP_STDFORM_LG"));
     String prep_extemp   =   bean.checkForNull((String)hmTemp.get("PREP_EXTEMP_LG"));
     String prep_others   =   bean.checkForNull((String)hmTemp.get("PREP_OTHERS_LG"));
     
     if(prep_prepack.equals("") && prep_standard.equals("") && prep_extemp.equals("") && prep_others.equals("") ){
    	 
    	 prep_prepack  = "Pre Packing";
         prep_standard = "Standard Formulary";
         prep_extemp   = "Extemporaneous";
         prep_others   =  "Others";
     }
	//ends
	
	%>

<body onMouseDown="CodeArrest()">
<form name="manufacturing_form" id="manufacturing_form" >

<table border="0" cellpadding="0" cellspacing="0" width='100%' align=center>
<tr>
	<td colspan=6>&nbsp;</td>
</tr>
<tr>
	<td   class="label" ><fmt:message key="Common.ReqByStore.label" bundle="${common_labels}"/></td>
	<td  class='fields'>&nbsp;<select name='req_store' id='req_store' ><%=bean.getRequestStore()%></select></td>
	<td  class="label"  nowrap><fmt:message key="Common.PrepareLocation.label" bundle="${common_labels}"/></td>
	<td   class='fields' colspan=3>&nbsp;<select name='prep_loc' id='prep_loc' ><%=bean.getPrepLoc()%></select></td>
</tr>
<!-- ("A,All;P,Pre packing;S,Standard Formulary ;E,Extemporaneous ;O,Others",getReq_type()); -->
<tr>
	<td   class="label" ><fmt:message key="eST.PreparationType.label" bundle="${st_labels}"/></td>
	<td class='fields'>&nbsp;<select name='req_type' id='req_type' ><OPTION VALUE="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
	
			<!--  <OPTION VALUE="P"><fmt:message key="eST.PrePacking.label" bundle="${st_labels}"/></OPTION>
			<OPTION VALUE="S"><fmt:message key="eST.StandardFormulary.label" bundle="${st_labels}"/></OPTION>
			<OPTION VALUE="E"><fmt:message key="eST.Extemporaneous.label" bundle="${st_labels}"/></OPTION>
			<OPTION VALUE="O"><fmt:message key="Common.others.label" bundle="${common_labels}"/></OPTION>-->
			
			<!-- //Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014 -->
			 <%if(!prep_prepack.equals("")){ %>
			<OPTION VALUE="P"><%=prep_prepack %></OPTION>
			 <% } if(!prep_standard.equals("")){ %>
			<OPTION VALUE="S"><%=prep_standard %></OPTION>
			<% } if(!prep_extemp.equals("")) {%>
			<OPTION VALUE="E"><%=prep_extemp %></OPTION>
			<% } if(!prep_others.equals("")){ %>
			<OPTION VALUE="O"><%=prep_others %></OPTION>
			<%} %>
			<!-- ends -->
	</select></td>
	<td  class="label"><fmt:message key="eST.PreparationMode.label" bundle="${st_labels}"/></td>
	<td class='fields'>&nbsp;<select name='prep_mode' id='prep_mode' ><OPTION VALUE="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
			<OPTION VALUE="S"><fmt:message key="eST.Sterile.label" bundle="${st_labels}"/></OPTION>
			<OPTION VALUE="N"><fmt:message key="eST.NonSterile.label" bundle="${st_labels}"/></OPTION>
			<OPTION VALUE="O"><fmt:message key="Common.others.label" bundle="${common_labels}"/></OPTION></select></td>
	<td  class='fields'><input type=button name='add' id='add' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='Button'  onClick="loadData();"   <%=disablefield%>  >	</td>
   </tr>
 </table>
<script>
	loadPage();
</script>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name='checkBoxVals' id='checkBoxVals' >
<input type='hidden' name='bean_id' id='bean_id' value="<%=bean_id%>" >
<input type='hidden' name='bean_name' id='bean_name' value="<%=bean_name%>" >
<input type='hidden' name='item_code' id='item_code' value="<%=bean.getItem_code()%>" >
<input type='hidden' name='patient_name' id='patient_name' value="<%=bean.getPatient_name()%>" >
</form>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

