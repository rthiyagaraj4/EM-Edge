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
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			=	(String)session.getAttribute("LOCALE");	
	String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eST/js/ManufacturingReceipts.js'></script>
	<script language='javascript' src='../../eST/js/StCommon.js'></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 
</head>
<%try{
	//HashMap defaultParameter		=		null;
	String bean_id					=		"ManufacturingReceiptsBean";
	String bean_name				=		"eST.ManufacturingReceiptsBean";
	String facility_id				=		(String) session.getValue( "facility_id" ) ;
	String user_name				=		(String) session.getValue( "login_user" ) ;
	String classvalue				=		"";

	ManufacturingReceiptsBean bean	=		(ManufacturingReceiptsBean) getBeanObject(bean_id, bean_name, request);
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	//String index					=		bean.checkForNull(request.getParameter("index"),"-1");
	String mode						=		request.getParameter( "mode" )==null?"":  request.getParameter( "mode" );
	//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
	String dflt_mfg_mode			=		request.getParameter( "dflt_mfg_mode" )==null?"R":  request.getParameter( "dflt_mfg_mode" );
	ArrayList recordSet				=		new ArrayList();
	recordSet						=		bean.getDataRecordList();
	HashMap hmRecord				=		new HashMap();
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
<%
		putObjectInBean(bean_id,bean,request);
%> 
	<body>
	<form name='ManufacturingResultForm' id='ManufacturingResultForm'>
		<div name='msg' id='msg' style="position:absolute;width: 0; height: 0; left: 201; top: 62">
		</div>
		<table border='1' cellpadding=0 cellspacing=0 width='100%' id='tb1'>
			<th><fmt:message key="Common.workstation.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.ReqByStore.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="eST.MFGItem.label" bundle="${st_labels}"/></th>
			<th><fmt:message key="eST.ReqNo.label" bundle="${st_labels}"/></th>
			<th><fmt:message key="Common.uom.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="eST.PreparationType.label" bundle="${st_labels}"/></th>
			<th><fmt:message key="eST.PreparationMode.label" bundle="${st_labels}"/></th>
			<th><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.RequestDate.label" bundle="${common_labels}"/></th>

	<%
		if(recordSet.size() > 0 ){
	int i=0;
	for	(i	=0;	i<recordSet.size();i++){
		hmRecord	=(HashMap)	recordSet.get(i);

		classvalue					=		((i%2)==0)?"QRYODD":"QRYEVEN";
		String preparation_type		=		bean.checkForNull((String)hmRecord.get("PREPARATION_TYPE"),"&nbsp;");
		String preparation_desc		=		"";
	//Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014 Starts
		if (preparation_type.equals("P"))
			//preparation_desc		=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.PrePacking.label","st_labels");
			preparation_desc = prep_prepack;
		else if (preparation_type.equals("S"))
			//preparation_desc		=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.StandardFormulary.label","st_labels");
			preparation_desc = prep_standard;
		else if(preparation_type.equals("E"))
			//preparation_desc		=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Extemporaneous.label","st_labels");
			preparation_desc =  prep_extemp;
		else
			//preparation_desc		=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
			preparation_desc = prep_others;
	

		String preparation_mode		=		bean.checkForNull((String)hmRecord.get("PREPARATION_MODE"),"&nbsp;");
		String preparationmode_desc	=		"";

		if (preparation_mode.equals("S"))
			preparationmode_desc	=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Sterile.label","st_labels");
		else if (preparation_mode.equals("N"))
			preparationmode_desc	=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.NonSterile.label","st_labels");
		else
			preparationmode_desc	=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
		
		String patinetName			=		bean.checkForNull((String)hmRecord.get("PATIENT_NAME"));
		String loc_desc				=		bean.checkForNull((String)hmRecord.get("LOC_DESC"));
		String store_desc			=		bean.checkForNull((String)hmRecord.get("STORE_DESC"));
		String request_qty			=		bean.checkForNull((String)hmRecord.get("REQUEST_QTY"));
		String allow_deci_yn            =   bean.checkForNull(bean.getAllowDecimalsYN((String)hmRecord.get("ITEM_CODE")),"N");
	    String no_deci =   bean.checkForNull(""+bean.getNoOfDecimals(),"0");
		if(allow_deci_yn.equals("N"))
                            no_deci ="0";

%>
		<tr>
			<td class="<%=classvalue%>"  align="center" title= "Print WorkSheet" onclick = "PrintWorkSheet('<%=bean.checkForNull((String)hmRecord.get("MFG_REQUEST_NO"),"&nbsp;")%>')"><img align='middle' src='../../eCommon/images/beprint.gif'></img></td>
			<td class="<%=classvalue%>"  align='left'> <font size=1> <%=bean.checkForNull((String)hmRecord.get("STORE_DESC"),"&nbsp;")%></font></td>
			<td class="<%=classvalue%>"  align='left'  nowrap><font size=1>
<%		if(((String)hmRecord.get("REQUEST_STATUS")).equals("E")){%>
			<a href="javascript:modifyData('','<%=i%>','<%=preparationmode_desc%>','','<%=loc_desc%>','<%=store_desc%>','<%=request_qty%>','<%=mode%>','','','','','','<%=dflt_mfg_mode%>','<%=preparation_type%>');">					
				<%=(String)hmRecord.get("MFG_ITEM_DESC")%></a>
<%
			}else{				
%>
				<%=(String)hmRecord.get("ITEM_CODE")%>
<%}%>
				</font>
					
			</td>
			<td class="<%=classvalue%>"  align='left'  nowrap><font size=1><%=bean.checkForNull((String)hmRecord.get("MFG_REQUEST_NO"),"&nbsp;")%></font></td> 
			<td class="<%=classvalue%>"  align='left'  nowrap><font size=1><%=bean.checkForNull((String)hmRecord.get("STOCK_UOM"),"&nbsp;")%></font></td>
			<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Quantity.				
					-->
			<td class="<%=classvalue%>"  align='left'  nowrap style="TEXT-ALIGN:right"><font size=1><%=bean.checkForNull(bean.setNumber((String)hmRecord.get("REQUEST_QTY"),Integer.parseInt(no_deci)),"&nbsp;")%></font>&nbsp;</td>
			<td class="<%=classvalue%>"  align='left'  nowrap><font size=1><%=bean.checkForNull(preparation_desc,"&nbsp;")%></font></td>
			<td class="<%=classvalue%>"  align='left'  nowrap><font size=1><%=preparationmode_desc%></font></td>
			<%
			if(!patinetName.equals("")){
					patinetName = patinetName.replaceAll(" ","%20");
					patinetName = java.net.URLEncoder.encode(patinetName,"UTF-8");
					patinetName = patinetName.replaceAll("%2520","%20");
				}
			%>
			<td class="<%=classvalue%>"  align='left'  nowrap onmouseover="onMMove(msg,event,'<%=patinetName%>');" onMouseout="onMOut(msg);"  ><font size=1><%=bean.checkForNull((String)hmRecord.get("PATIENT_ID"),"&nbsp;")%></font></td>

			<td class="<%=classvalue%>"  align='left'> <font size=1><%=bean.checkForNull(com.ehis.util.DateUtils.convertDate((String)hmRecord.get("REQ_DATE"),"DMY","en",locale),"&nbsp;")%></font></td> 
			<input type="hidden" name="REQUEST_STATUS" id="REQUEST_STATUS" value='<%=bean.checkForNull((String)hmRecord.get("REQUEST_STATUS"),"&nbsp;")%>'>
		</tr>
	<%
	}
	%>
	</table>
	<input type="hidden" name="totalRecords" id="totalRecords" value="<%=recordSet.size()%>">
	<input type="hidden" name="mode" id="mode"		 value="<%=mode%>">

	</form>
	<form name='ManufacturingResultReportForm' id='ManufacturingResultReportForm'  action="../../eCommon/jsp/report_options.jsp" target="messageFrame" >
			<input type="hidden" name="bean_id" id="bean_id"		 value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"	 value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id"  value="ST">
			<input type="hidden" name="p_report_id" id="p_report_id"  value="STBWRMFS">
			<input type="hidden" name="p_user_name" id="p_user_name"	 value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=facility_id%>">
			 <input type="hidden" name="p_request_no" id="p_request_no" value=""> 
			 <input type="hidden" name="dflt_mfg_mode" id="dflt_mfg_mode" value="<%=dflt_mfg_mode%>"> 
		</form>
		<!--
		* @Name - Priya
		* @Date - 21/12/2009
		* @Inc# - IN017084
		* @Desc - To avoid the duplication records display in Modify mode
		 -->
		<div  id='readOnlyDiv'  style="visibility:hidden;z-index:3;position:absolute;top:0px;width:1007px;height:500px;background-color:#CCCFFF;filter:alpha(opacity=80);" >
		<table border="0" align="center" width="100%" height="100%">
		<tr><td align="center">
			
			</td></tr>
		</table>
		</div>
	</center>

		<%			
		out.flush();
		} else{
		%>
			 <script>
					alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
					document.location.href="../../eCommon/html/blank.html";
			</script>
		<%
		}
		}
			catch (Exception exception) {
				exception.printStackTrace();
			}
			%>
	</body>
	</html>

