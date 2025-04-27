<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*, java.sql.*, java.util.Properties, java.util.ArrayList,java.util.HashMap, ePO.Common.PoRepository, eCommon.Common.OptionValues,ePO.Common.*, ePO.* ,java.sql.*"
contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title><fmt:message key="Common.UserAccessforStoreListing.label" bundle="${common_labels}"/></title>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale					= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language='javascript' src='../../ePO/js/PoTransaction.js'></script>
		<script language="javascript" src="../../ePO/js/PoCommon.js"></script>
		<script language="JavaScript" src="../../ePO/js/FacilityForPurchaseUnit.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body>
<center>
<form name="FacilityForPurchaseUnitListForm" id="FacilityForPurchaseUnitListForm" >
   <%
 
	String mode									 =		"";
	String bean_id								 =		"";
	String bean_name							 =		"";
	String pur_unit_id							 =		"";
	String facility_id							 =      "";
	String facility_name						 =      "";

	boolean searched =false;
	int  i =	0;
	int recCount =	0;
	
	try{
 	bean_id										 =		"facilityForPurchaseUnitBean" ;
	bean_name									 =		"ePO.FacilityForPurchaseUnitBean";
	mode	= request.getParameter( "mode" );
	pur_unit_id										 =		 request.getParameter("pur_unit_id");
	

	if ( mode == null || mode.equals("") ) 
			return;
		if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
			return;			

	FacilityForPurchaseUnitBean bean					 =		(FacilityForPurchaseUnitBean)getBeanObject( bean_id, bean_name, request );
	bean.setLanguageId(locale);	
	
	String global_unit_yn =		bean.checkForNull((String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_PO_GLOBAL_YN"),pur_unit_id).get("GLOBAL_UNIT_YN"));
	ArrayList sqlParam = new ArrayList();		
		sqlParam.add(pur_unit_id);	
		sqlParam.add(bean.getLoginById());
		
	int count = Integer.parseInt(bean.checkForNull((String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_PUR_UNIT_FACILITY_COUNT"),sqlParam).get("COUNT"),"0"));	
	
	ServletContext context						=	getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
	bean.setLocalEJB(false);
	bean.setMode( mode ) ;
	bean.setPur_unit_id(pur_unit_id);
	bean.loadFacilityId();
	String user_id = CommonAdapter.checkForNull( request.getParameter("user_id") );
	searched = (request.getParameter("searched") == null) ?false:true;
	String classValue = "";
		String checked = "";
		HashMap sqlMap = new HashMap();
		sqlMap.put("sqlData", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_FACILITY_DATA_SELECT_LIST"));
		HashMap funcMap = new HashMap();
	  //The fields are going to be display
		ArrayList displayFields = new ArrayList();
		displayFields.add("FACILITY_ID");
		displayFields.add("FACILITY_NAME");
	  //The fields are going to be in where condition * should match with the query
		ArrayList chkFields = new ArrayList();
		chkFields.add(locale);
	 // Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );
		 
		ArrayList selectedFacilityId = bean.getSelectedFacilityId();
		
		ArrayList processedFacilityId = bean.getFacilityId();
	
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
	
		   
  	   if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
		    
	
		  
%>
		
	<table cellpadding="0" cellspacing="0" width="95%" align=center>
		<tr>
			<td colspan=2 class="white">&nbsp;</td>
		</tr>
		<tr>
			<td width="80%" class="white"></td>
			<td width="20%" class="white"><%=result.get(1)%></td>
		</tr>
	</table>
	<table border="1" cellpadding="0" cellspacing="0" width="95%" align=center>
			<tr>
				<th ><fmt:message key="ePO.Facility.label" bundle="${po_labels}"/></th>
				<th ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
			</tr>
			<%
				String noDisplay = "";
				String highlight = "";
				ArrayList records = new ArrayList();
				for(recCount=2,i=0; recCount<result.size(); recCount++,i++) {
					if ( recCount % 2 == 0 )
						classValue = "QRYEVEN";
					else
						classValue = "QRYODD";
			%>																		
			<tr>
			<%
				//String link_columns = "1";
				records=(ArrayList) result.get( recCount );
				facility_id = (String)records.get(0);
				facility_name =	(String)records.get(1);
				if (selectedFacilityId.contains(facility_id)) {
			
					checked = "checked";
				}
				else {
					checked = "";
				}
				if (processedFacilityId.contains(facility_id)) {
					noDisplay = "NODISPLAY";
					highlight = "DATAHIGHLIGHT";
				}
				else {
					noDisplay = "";
					highlight = "";
				}
			%>
				<td class="<%=classValue%>"><font class='<%=highlight%>'><%=facility_name%></font></td>
				<td class="<%=classValue%>" > <input type="checkbox" name="facility_id_<%=i%>" id="facility_id_<%=i%>" value="<%=facility_id%>" <%=checked%> onClick="checkPUGlobal('<%=global_unit_yn%>','<%=i%>',this,'<%=count%>')" class='<%=noDisplay%>'> </td>
			</tr>
				<input type="hidden" name="remove_facility_id_<%=i%>" id="remove_facility_id_<%=i%>" value="<%=facility_id%>">
			<%
				}
				out.flush();
				}
				else{
			%>
				<script>
					alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
					history.go(-1);
				</script>
			  <%}%>
					<%		putObjectInBean(bean_id,bean,request);
			%>
	</table>	
				<input type="hidden" name="user_id" id="user_id" value="<%=user_id%>"> 
				<input type="hidden" name="total_facility_id" id="total_facility_id" value="<%=i%>">
				<input type="hidden" name="mode" id="mode" value="<%=mode%>">
				<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
				<input type="hidden" name="canProcess" id="canProcess" value="<%=bean.hasRecords()%>">
				<input type="hidden" name="PreviousListValueExit" id="PreviousListValueExit" value="<%=selectedFacilityId.size()>0 ? "Y":"N"%>">
				</form>
			<%
			}
			catch(Exception e){
				e.printStackTrace();
			}

			 %>
</table>
	<%
		out.println(CommonBean.setForm (request ,"../../ePO/jsp/FacilityForPurchaseUnitDetails.jsp", searched) );

	%>
</center>
			
<script>
gettotalcheckBoxes(document.FacilityForPurchaseUnitListForm.total_facility_id);
</script>
</body>
</html>

		
		
		
		

