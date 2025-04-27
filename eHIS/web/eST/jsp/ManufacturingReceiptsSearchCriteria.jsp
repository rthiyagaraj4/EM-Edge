<!--<!DOCTYPE html>-->
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
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eST/js/StCommon.js"></script>
<script language='javascript' src='../../eST/js/StTransaction.js'></script>
<script language='javascript' src="../../eST/js/ManufacturingReceipts.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	//java.util.HashMap defaultParameter = null;
	String bean_id = "ManufacturingReceiptsBean";
	String bean_name = "eST.ManufacturingReceiptsBean";
	//String disable ="";
	ManufacturingReceiptsBean bean = (ManufacturingReceiptsBean) getBeanObject(bean_id, bean_name, request);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
bean.setLanguageId(locale);
	//String index				=	bean.checkForNull(request.getParameter("index"),"-1");
	
	String mode	= request.getParameter( "mode" )==null?"":  request.getParameter( "mode" );
	//ArrayList dataList=new ArrayList();
	//ArrayList recordSet=new ArrayList();
	String  select1 = "";
	String select2  = "";
	String  disable_direct	=	""; 
    String  disable_req	    =	""; 
	String dflt_mfg_mode				=	bean.checkForNull(request.getParameter("dflt_mfg_mode"),"R");
	if(dflt_mfg_mode.equals("D")){
	select1 = "checked";
	 //Added by Rabbani for avoid doubleclick on radio button on 12-APR-2013
	     disable_direct				=	"disabled"; 
         disable_req			     =	""; 
	}else{
	select2           = "checked";
	disable_direct	  =	""; 
    disable_req		 =	"disabled"; 
	}

	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	
	//Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014 Starts
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
<div >
<table border="0" cellpadding="0" cellspacing="0" width='100%' align=center>

    <!--Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 Starts -->
<tr>
		<td align="right" class="label"><fmt:message key="eST.DirectManufacturing.label" bundle="${st_labels}"/>&nbsp;
		<input type='radio' name="mfg_mode" id="mfg_mode" value="D" <%=select1%>  <%=disable_direct%> onclick = "selectmode();">
		&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eST.ByRequest.label" bundle="${st_labels}"/>&nbsp;
		<input type='radio' name="mfg_mode" id="mfg_mode_r" value="R"  <%=select2%> <%=disable_req%> onclick= "selectmfgmode();">
	  </td> 
	</tr>
	<!-- ends --> 

<tr>
	<td   class="label" ><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
	<td  class='fields'>&nbsp;<select name='store_code' id='store_code' ><%=bean.getRequestStore()%></select></td>
	<td   class="label" ><fmt:message key="eST.PreparationType.label" bundle="${st_labels}"/></td>
	
	
	<td class='fields'>&nbsp;<select name='req_type' id='req_type' ><OPTION VALUE="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
	
	
	<!--  //Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014 Starts -->
	        <%if(!prep_prepack.equals("")){ %>
			<OPTION VALUE="P"><%=prep_prepack %></OPTION>
			<%}if(!prep_standard.equals("")){ %>
			<OPTION VALUE="S"><%=prep_standard %></OPTION>
			<%}if(!prep_extemp.equals("")){ %>
			<OPTION VALUE="E"><%=prep_extemp %></OPTION>
			<%}if(!prep_others.equals("")){ %>
			<OPTION VALUE="O"><%=prep_others %></OPTION>
			<%} %>
	
			<!--  <OPTION VALUE="P"><fmt:message key="eST.PrePacking.label" bundle="${st_labels}"/></OPTION>
			<OPTION VALUE="S"><fmt:message key="eST.StandardFormulary.label" bundle="${st_labels}"/></OPTION>
			<OPTION VALUE="E"><fmt:message key="eST.Extemporaneous.label" bundle="${st_labels}"/></OPTION>
			<OPTION VALUE="O"><fmt:message key="Common.others.label" bundle="${common_labels}"/></OPTION>-->
			
			</select></td>
</tr>

<!-- ("A,All;P,Pre packing;S,Standard Formulary ;E,Extemporaneous ;O,Others",getReq_type());
("A,All;S,Sterile;N,Non Sterile ;O,Others ;")-->
<tr>
	
	<td  class="label"  nowrap><fmt:message key="Common.PrepareLocation.label" bundle="${common_labels}"/></td>
	<td   class='fields'>&nbsp;<select name='prep_loc' id='prep_loc' ><%=bean.getPrepLoc()%></select></td>
	<td  class="label"><fmt:message key="eST.PreparationMode.label" bundle="${st_labels}"/></td>
	<td class='fields'>&nbsp;<select name='prep_mode' id='prep_mode' ><OPTION VALUE="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
			<OPTION VALUE="S"><fmt:message key="eST.Sterile.label" bundle="${st_labels}"/></OPTION>
			<OPTION VALUE="N"><fmt:message key="eST.NonSterile.label" bundle="${st_labels}"/></OPTION>
			<OPTION VALUE="O"><fmt:message key="Common.others.label" bundle="${common_labels}"/></OPTION>
			</select></td>
   </td>

</tr>
<tr>
	
	<td  class="label"  nowrap><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
	<td  class="fields"  >&nbsp;<input type=text name="dt_frm" id="dt_frm" onBlur="CheckDate(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dt_frm');"   ></img>&nbsp;To&nbsp;<input type=text name="dt_to" id="dt_to" onBlur="CheckDate(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dt_to');" ></img></td>
	<td  class="label"><fmt:message key="eST.ReqStatus.label" bundle="${st_labels}"/></td>
	<td  class='fields'>&nbsp;<select name="req_status" id="req_status">
	<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
	<option selected value="P"><fmt:message key="Common.Pending.label" bundle="${common_labels}"/></option>
	</select></td>
</tr>
<tr>
	<td  class="label"  nowrap><fmt:message key="eST.ReqNoFrom.label" bundle="${st_labels}"/></td>
	<td   class="fields" >&nbsp;<input type=text name="req_no_frm" id="req_no_frm">
	&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<input type=text name="req_no_to" id="req_no_to">
   <td  colspan=2><input type=button name='select' id='select'  value=' <fmt:message key="Common.search.label" bundle="${common_labels}"/> ' class='Button'  onClick="loadData();"></td>
   </tr>
<script>
	loadData();
</script>
</table>
</div>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name='checkBoxVals' id='checkBoxVals' >
<input type='hidden' name='bean_id' id='bean_id' value="<%=bean_id%>" >
<input type='hidden' name='bean_name' id='bean_name' value="<%=bean_name%>" >
<input type='hidden' name='item_code' id='item_code' value="<%=bean.getItem_code()%>" >
<input type='hidden' name='patient_name' id='patient_name' value="<%=bean.getPatient_name()%>" >
<input type='hidden' name='process_loss_percent' id='process_loss_percent'  >
<input type='hidden' name='unit_cost' id='unit_cost'  >
<input type='hidden' name='bin_location_code' id='bin_location_code'  >
<input type='hidden' name='baseqty' id='baseqty'  >
<input type='hidden' name='dflt_mfg_mode' id='dflt_mfg_mode' value="<%=dflt_mfg_mode%>" >
</form>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

