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
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 
<%-- Mandatory declarations end --%>
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<!-- 	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eST/js/ManufacturingRequest.js'></script>
	<script language='javascript' src='../../eST/js/StCommon.js'></script>
</head>
<%

	request.setCharacterEncoding("UTF-8");
	String locale						=		(String)session.getAttribute("LOCALE");
	int i								=		0;
	try{
//pmd 29/01/05	
//	java.util.HashMap defaultParameter	=		null;
	String bean_id						=		"ManufacturingRequestBean";
	String bean_name					=		"eST.ManufacturingRequestBean";
	String classvalue					=		"";
	ManufacturingRequestBean bean		=		(ManufacturingRequestBean) getBeanObject( bean_id,bean_name,request);  
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
//	String index						=		bean.checkForNull(request.getParameter("index"),"-1");
	String mode							=		request.getParameter( "mode" )==null?"":  request.getParameter( "mode" );
	ArrayList recordSet					=		new ArrayList();
	recordSet							=		bean.getDataRecordList();
	HashMap hmRecord					=		new HashMap();

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
	<body>
	<form name='ManufacturingResultForm' id='ManufacturingResultForm' method='post' >
		<div name='msg' id='msg' style="position:absolute;width: 0; height: 0; left: 201; top: 62">
		</div>
		<table border='1' cellpadding=0 cellspacing=0 width='100%' id='tb1' align=center>
			<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
			<th style="WORD-BREAK:BREAK-ALL;"><fmt:message key="eST.MFGItem.label" bundle="${st_labels}"/></th>
			<th>UOM</th>
			<th><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="eST.PreparationType.label" bundle="${st_labels}"/></th>
			<th>Prep.Mode</th>
			<th><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></th>
	<%
		if(recordSet.size() > 0 ){
		
		for	(i	=0;	i<recordSet.size();i++){
			hmRecord	=(HashMap)	recordSet.get(i);
			classvalue	=	((i%2)==0)?"QRYODD":"QRYEVEN";
			String preparation_type= bean.checkForNull((String)hmRecord.get("PREPARATION_TYPE"),"&nbsp;");
			String preparation_desc="";
		
			//Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014
			if (preparation_type.equals("P"))
				//preparation_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.PrePacking.label","st_labels");
				preparation_desc = prep_prepack;
			else if (preparation_type.equals("S"))
				//preparation_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.StandardFormulary.label","st_labels");
				preparation_desc = prep_standard;
			else if(preparation_type.equals("E"))
				//preparation_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Extemporaneous.label","st_labels");
				preparation_desc =  prep_extemp;
			else
				//preparation_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
				preparation_desc = prep_others;
		

			String preparation_mode= bean.checkForNull((String)hmRecord.get("PREPARATION_MODE"),"&nbsp;");
			String preparationmode_desc="";

			if (preparation_mode.equals("S"))
				preparationmode_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Sterile.label","st_labels");
			else if (preparation_mode.equals("N"))
				preparationmode_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.NonSterile.label","st_labels");
			else
				preparationmode_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
			
			String patinetName=bean.checkForNull((String)hmRecord.get("PATIENT_NAME"));
			
			String allow_deci_yn            =   bean.checkForNull(bean.getAllowDecimalsYN((String)hmRecord.get("ITEM_CODE")),"N");
	        String no_deci =   bean.checkForNull(""+bean.getNoOfDecimals(),"0");
		                    if(allow_deci_yn.equals("N"))
                            no_deci ="0";
	%>
		<tr  id="tr_<%=i%>">
			<td  class="<%=classvalue%>"><input type="checkbox" <%=((String)hmRecord.get("SELECTED")).equals("Y")?"checked":""%> name="del_<%=i%>" value=""  ></td>
			<td class="<%=classvalue%>"    style="WORD-BREAK:BREAK-ALL;"><a name="a_<%=i%>" href="javascript:modifyData('<%=i%>');"><font size=1><%=bean.checkForNull((String)hmRecord.get("MFG_ITEM_DESC"),(String)hmRecord.get("SHORT_DESC"))%></a></font></td>
			<td class="<%=classvalue%>"    nowrap><font size=1><%=bean.checkForNull((String)hmRecord.get("STOCK_UOM"),"&nbsp;")%></font></td>
			<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Quantity.				
					-->
			<td class="<%=classvalue%>"    nowrap  style="TEXT-ALIGN:right"><font size=1><%=bean.checkForNull(bean.setNumber((String)hmRecord.get("REQUEST_QTY"),Integer.parseInt(no_deci)),"&nbsp;")%></font>&nbsp;</td>
			<td class="<%=classvalue%>"    nowrap><font size=1><%=bean.checkForNull(preparation_desc,"&nbsp;")%></font></td>
			<td class="<%=classvalue%>"    nowrap><font size=1><%=preparationmode_desc%></font></td>
			<td class="<%=classvalue%>"    nowrap onmouseover="onMMove(msg,event,'<%=patinetName%>')" onMouseout="onMOut(msg);"  ><font size=1><%=bean.checkForNull((String)hmRecord.get("PATIENT_ID"),"&nbsp;")%></font></td>
			
		</tr>
	<%
	}
	%>
	</table>
	<input type=hidden name="totalRecords" id="totalRecords"  value="<%=recordSet.size()%>">
	<input type=hidden name="mode" id="mode"			value="<%=mode%>">
	</form>
	</center>
<%			
		out.flush();
		} else{
		%>
			 <script>
					alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
					document.location.href="../../eCommon/html/blank.html";
			 </script>
		<%
		}
putObjectInBean(bean_id,bean,request);
	}
	catch (Exception exception) {
		exception.printStackTrace();
		out.println(exception);
	}
%>
	</body>
	<%if (request.getParameter("index")!=null) {%>
<script language="JavaScript">
	document.getElementById('a_')<%=(request.getParameter("index")).equals("-1")?""+(i-1):request.getParameter("index")%>.scrollIntoView();
	changeRowColor(document.getElementById('tr_')<%=(request.getParameter("index")).equals("-1")?""+(i-1):request.getParameter("index")%>);	
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}%>
	</html>

