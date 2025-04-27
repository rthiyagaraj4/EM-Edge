<!DOCTYPE html>
<%@ page import= "java.util.*,java.sql.*,java.text.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
	<%request.setCharacterEncoding("UTF-8");
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	
	<script language="JavaScript">
		var expand = "";
		var temparr = new Array();
		var count = 0;
		var prev=0;
		var prevcol='ECMENUHIGHERLEVELCOLOR';
		var sec_hdg_cd=new Array();
		var logic_seq_no=new Array();
		function goHomePage(){
				parent.location.href='../../eCommon/jsp/dmenu.jsp';
		}
		function chcol(ro)
		{
				document.getElementById("t").rows(prev).cells(0).className=prevcol
				prevcol=ro.cells(0).className
				ro.cells(0).className="MENUSELECTEDCOLOR"
				prev=ro.rowIndex;
		}

		function callJSPs(val,count_record_role,count_record_admin)
		{
			/*
					Access is in the order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess
			*/
			
			if(val == 'SITE')
				{
				
				if(count_record_role>=1){
				
				
				
				parent.frames[1].location.href = '../../servlet/eSM.SiteParameterServlet?module_id=SM&function_id=SITE_PARAMETER&function_name='+encodeURIComponent(getLabel('Common.Site.label','Common'))+'&function_type=F&access=NYNNN';
				}
				else{
				var error=getMessage('INVALID_USER','SM');
				alert(error);
				}
				}
			if(val == 'FACILITY'){
				if(count_record_role>=1){
				parent.frames[1].location.href = '../../eSM/jsp/facility_param.jsp?module_id=SM&function_id=FACILITY_PARAMETER&function_name='+encodeURIComponent(getLabel('Common.facility.label','Common'))+'&function_type=F&access=YYYNN';
				}
				else{
				var error=getMessage('INVALID_USER','SM');
				alert(error);
				}
				}
			if(val == 'OPERATIONAL_STATUS'){
				if(count_record_role>=1){
				parent.frames[1].location.href = '../../eSM/jsp/OperationalStatus.jsp?module_id=SM&function_id=OPERATIONAL_STAT&function_name='+encodeURIComponent(getLabel("eSM.OperationalStatus.label",'SM'))+'&function_type=F&access=YYNNN';
				}
				else{
				var error=getMessage('INVALID_USER','SM');
				alert(error);
				}
			}
			if(val == 'DAY_OF_THE_WEEK'){
				if(count_record_role>=1){
				parent.frames[1].location.href = '../../eSM/jsp/DayoftheWeekMain.jsp?module_id=SM&function_id=DAY_OF_THE_WEEK&function_name='+encodeURIComponent(getLabel('Common.dayofweek.label','Common'))+'&function_type=F&access=NYNNY';
				}
				else{
				var error=getMessage('INVALID_USER','SM');
				alert(error);
				}
			}
			if(val == 'RESPONSIBILITY_GROUP'){
				if(count_record_role>=1){
				parent.frames[1].location.href = '../../eSM/jsp/Respgroup.jsp?module_id=SM&function_id=RESP_GROUP&function_name='+encodeURIComponent(getLabel('eSM.ResponsibilityGroup.label','SM'))+'&function_type=F&access=YYYNY';
				}
				else{
				var error=getMessage('INVALID_USER','SM');
				alert(error);

			}
			}
			if(val == 'MENU_ADMINISTRATOR'){
				if(count_record_role>=1){
				parent.frames[1].location.href = '../../eSM/jsp/MenuAdmin.jsp?module_id=SM&function_id=MENU_ADMIN&function_name='+encodeURIComponent(getLabel('eSM.MenuAdministrator.label','SM'))+'&function_type=F&access=YYYNY';
				}
				else{
				var error=getMessage('INVALID_USER','SM');
				alert(error);
				}
			}
			if(val == 'FUNCTION_BY_RESPONSIBILITY_GROUP'){
				if(count_record_role>=1){
				parent.frames[1].location.href = '../../eSM/jsp/FuncForRespGrp.jsp?module_id=SM&function_id=FUNC_BY_RESP_GROUP&function_name='+encodeURIComponent(getLabel('eSM.FunctionsbyResponsibilityGroup.label','SM'))+'&function_type=F&access=YYNNN';
				}
				else{
				var error=getMessage('INVALID_USER','SM');
				alert(error);
				}
			}
			if(val == 'DATABASE_RESOURCE_GROUP'){
				if(count_record_role>=1){
				parent.frames[1].location.href = '../../eSM/jsp/ResourceGrp.jsp?module_id=SM&function_id=RESOURCE_GROUP&function_name='+encodeURIComponent(getLabel('eSM.DatabaseResourceGroup.label','SM'))+'&function_type=F&access=YYYYY';
				}
				else{
				var error=getMessage('INVALID_USER','SM');
				alert(error);
				}
			}
			if(val == 'DATABASE_ROLES'){
				if(count_record_role>=1){
				parent.frames[1].location.href = '../../eSM/jsp/OraRole.jsp?module_id=SM&function_id=SM_ORA_ROLE&function_name='+encodeURIComponent(getLabel('eSM.DatabaseRoles.label','SM'))+'&function_type=F&access=NNNNY';
				}
				else{
				var error=getMessage('INVALID_USER','SM');
				alert(error);
				}
			}
			if(val == 'CREATE_MENU'){
				if(count_record_role>=1 || count_record_admin>=1){
				parent.frames[1].location.href = '../../eSM/jsp/MenuHeader.jsp?module_id=SM&function_id=MENU_HDR&function_name='+encodeURIComponent(getLabel('eSM.CreateMenu.label','SM'))+'&function_type=F&access=YYYNN';
				}
				else{
				var error=getMessage('MENU_ADMIN_ACCESS','SM');
				alert(error);
				}
			}

			if(val == 'CONSTRUCT_MENU'){
				if(count_record_role>=1 || count_record_admin>=1){
				parent.frames[1].location.href = '../../eSM/jsp/menuDetail.jsp?module_id=SM&function_id=CONSTRUCT_MENU&function_name='+encodeURIComponent(getLabel('eSM.ConstructMenu.label','SM'))+'&function_type=F&access=YYNNN';
				}
				else{
				var error=getMessage('MENU_ADMIN_ACCESS','SM');
				alert(error);
				}

			}

			if(val == 'ACCESS_RIGHTS_FOR_MENU_FUNCTIONS'){
				if(count_record_role>=1 || count_record_admin>=1){
				parent.frames[1].location.href = '../../eSM/jsp/AccessRightsMenuFunc.jsp?module_id=SM&function_id=ACCESS_RIGHTS_MENU_FUNC&function_name='+encodeURIComponent(getLabel('eSM.AccessRightsForMenuFunctions.label','SM'))+'&function_type=F&access=NYNNN';
				}
				else{
				var error=getMessage('MENU_ADMIN_ACCESS','SM');
				alert(error);
				}

			}

			if(val == 'RESPONSIBILITY'){
				if(count_record_role>=1 || count_record_admin>=1){			
				parent.frames[1].location.href = '../../eSM/jsp/Responsibility.jsp?module_id=SM&function_id=SM_RESP&function_name='+encodeURIComponent(getLabel("Common.responsibility.label",'Common'))+'&function_type=F&access=YYYNN';
				}
				else{
				var error=getMessage('MENU_ADMIN_ACCESS','SM');
				alert(error);
				}

			}
			if(val == 'RESPONSIBILITY_FOR_FACILITY'){ 
				if(count_record_role>=1){
				parent.frames[1].location.href = '../../eSM/jsp/FacilityforResponsibility.jsp?module_id=SM&function_id=SM_RESP_FCY&function_name='+encodeURIComponent(getLabel('eSM.ResponsibilityforFacility.label','SM'))+'&function_type=F&access=YYYNN';
				}
				else{
				var error=getMessage('INVALID_USER','SM');
				alert(error);
				}

			}
			if(val == 'MENU_RESTRICTION_FOR_RESPONSIBILITY'){
				if(count_record_role>=1 || count_record_admin>=1 ){
				parent.frames[1].location.href = '../../eSM/jsp/AddModifyMenuRstrnForResp.jsp?module_id=SM&function_id=MENU_RSTRN_FOR_RESP&function_name='+encodeURIComponent(getLabel('eSM.MenuRestrictionforResponsibility.label','SM'))+'&function_type=F&access=YYNNY';
				}
				else{
				var error=getMessage('MENU_ADMIN_ACCESS','SM');
				alert(error);
				}

			}
			if(val == 'USER'){
			if(count_record_role>=1){
				parent.frames[1].location.href = '../../eSM/jsp/User.jsp?module_id=SM&function_id=SM_USER&function_name='+encodeURIComponent(getLabel('Common.user.label','Common'))+'&function_type=F&access=YYYNN';
				}
				else{
				var error=getMessage('INVALID_USER','SM');
				alert(error);
				}

			}
			if(val == 'RESPONSIBILITY_FOR_USER'){
				if(count_record_role>=1){
				parent.frames[1].location.href = '../../eSM/jsp/ResponsibilityforUser.jsp?module_id=SM&function_id=SM_USER_RESP&function_name='+encodeURIComponent(getLabel('eSM.ResponsibilityforUser.label','SM'))+'&function_type=F&access=YYYNN';
				}
				else{
				var error=getMessage('INVALID_USER','SM');
				alert(error);
				}

			}
			if(val == 'FACILITY_FOR_USER'){
				if(count_record_role>=1){
				parent.frames[1].location.href = '../../eSM/jsp/FacilitiesforUser.jsp?module_id=SM&function_id=SM_USER_FCY&function_name='+encodeURIComponent(getLabel('eSM.FacilitiesforUser.label','SM'))+'&function_type=F&access=YYYNN';
				}
				else{
				var error=getMessage('INVALID_USER','SM');
				alert(error);
				}

			}
			if(val == 'PRINTER'){
				if(count_record_role>=1){
				parent.frames[1].location.href =  '../../servlet/eSM.PrinterServlet?module_id=SM&function_id=SM_PRINTER&function_name='+encodeURIComponent(getLabel('eSM.Printer.label','SM'))+'&function_type=F&access=YYYNN';
				}
				else{
				var error=getMessage('INVALID_USER','SM');
				alert(error);
				}

			}
			if(val == 'REPORT_SERVICE'){
				if(count_record_role>=1){
				parent.frames[1].location.href = '../../servlet/eSM.ReportServiceServlet?module_id=SM&function_id=SM_REPORT_SERVICE&function_name='+encodeURIComponent(getLabel('eSM.ReportService.label','SM'))+'&function_type=F&access=YYYNN';
				}
				else{
				var error=getMessage('INVALID_USER','SM');
				alert(error);
				}

			}
			if(val == 'REPORT_GROUP'){
				if(count_record_role>=1){
				parent.frames[1].location.href = '../../servlet/eSM.ReportGroupServlet?module_id=SM&function_id=SM_REPORT_GROUP&function_name='+encodeURIComponent(getLabel('eSM.ReportGroup.label','SM'))+'&function_type=F&access=YYYNN';
				}
				else{
				var error=getMessage('INVALID_USER','SM');
				alert(error);
				}

			}
			if(val == 'REPORT'){
				if(count_record_role>=1){
				parent.frames[1].location.href = '../../eSM/jsp/Report.jsp?module_id=SM&function_id=SM_REPORT&function_name='+encodeURIComponent(getLabel('Common.report.label','Common'))+'&function_type=F&access=NYYNN';
				}
				else{
				var error=getMessage('INVALID_USER','SM');
				alert(error);
				}

			}
			if(val == 'FACILITY_BASED_REPORT_PARAMETERS'){
				if(count_record_role>=1){
				parent.frames[1].location.href = '../../eSM/jsp/ReportForFacility.jsp?module_id=SM&function_id=SM_REPORT_FCY&function_name='+encodeURIComponent(getLabel('eSM.FacilitybasedReportParameters.label','SM'))+'&function_type=F&access=YYYYN';
				}
				else{
				var error=getMessage('INVALID_USER','SM');
				alert(error);
				}

			}
			if(val == 'PRINT_ROUTING'){
				if(count_record_role>=1){
				//parent.frames[1].location.href = '../../servlet/eSM.PrintRoutingServlet?module_id=SM&function_id=SM_PRINT_ROUTING&function_name=Print Routing&function_type=F&access=YYYYN';

				parent.frames[1].location.href = '../../eSM/jsp/PrintRoutingMain.jsp?module_id=SM&function_id=SM_PRINT_ROUTING&function_name='+encodeURIComponent(getLabel('eSM.PrintRouting.label','SM'))+'&function_type=F&access=YYYYN';
				
				}
				else{
				var error=getMessage('INVALID_USER','SM');
				alert(error);
				}

			}
			if(val == 'FREQUENTLY_ACCESSED_LIST'){
				if(count_record_role>=1){
				parent.frames[1].location.href = '../../eSM/jsp/FreqAccessFunc.jsp?module_id=SM&function_id=FREQ_ACCESS_FUNC&function_name='+encodeURIComponent(getLabel('Common.frequentlyAccessedFunctions.label','Common'))+'&function_type=F&access=NNNNN';
				}
				else{
				var error=getMessage('INVALID_USER','SM');
				alert(error);
				}

			}
			if(val == 'FUNCTION'){
				if(count_record_role>=1){
				parent.frames[1].location.href = '../../eSM/jsp/SMFunctionQuery.jsp?module_id=SM&function_id=FUNCTION&function_name='+encodeURIComponent(getLabel('Common.Function.label','Common'))+'&function_type=F&access=NNYNN';
				}
				else{
				var error=getMessage('INVALID_USER','SM');
				alert(error);
				}
			} 
	if(val == 'QUERY_ON_USERS'){
				if(count_record_role>=1){
				parent.frames[1].location.href = '../../eSM/jsp/QueryUsers.jsp?module_id=SM&function_id=QUERY_USERS&function_name='+encodeURIComponent(getLabel('eSM.QueryonUsers.label','SM'))+"("+encodeURIComponent(getLabel('Common.responsibility.label','Common'))+"/"+encodeURIComponent(getLabel('eSM.Facilities.label','SM'))+"/"+encodeURIComponent(getLabel('eSM.Menus.label','SM'))+')&function_type=F&access=NNYNN';
				}
				else{
				var error=getMessage('INVALID_USER','SM');
				alert(error);
				}
	}
	if(val == 'QUERY_ON_RESPONSIBILITY'){
				if(count_record_role>=1){
				parent.frames[1].location.href = '../../eSM/jsp/QueryResponsibility.jsp?module_id=SM&function_id=QUERY_ON_RESPONSIBILITY&function_name='+encodeURIComponent(getLabel('eSM.QueryonResponsibility.label','SM'))+"("+encodeURIComponent(getLabel('eSM.Users.label','SM'))+"/"+encodeURIComponent(getLabel('eSM.Facilities.label','SM'))+')&function_type=F&access=NNYNN';
				}
				else{
				var error=getMessage('INVALID_USER','SM');
				alert(error);
				}

			}
			if(val == 'SM_MASTER_CODE_LIST'){
				if(count_record_role>=1){
				parent.frames[1].location.href = '../../eSM/jsp/repSMMasterList.jsp?module_id=SM&function_id=SM_RPT_MAST_CODE&function_name='+encodeURIComponent(getLabel('eSM.SMMasterCodeList.label','SM'))+'&function_type=R&access=NNNNN';
				}
				else{
				var error=getMessage('INVALID_USER','SM');
				alert(error);
				}

			}
			if(val == 'RESPONSIBILITY_LIST'){
				if(count_record_role>=1){
				parent.frames[1].location.href = '../../eSM/jsp/repRespList.jsp?module_id=SM&function_id=SM_RPT_RESP&function_name='+encodeURIComponent(getLabel('eSM.ResponsibilityList.label','SM'))+'&function_type=R&access=NNNNN';
				}
				else{
				var error=getMessage('INVALID_USER','SM');
				alert(error);
				}

			}
		
			if(val == 'USER_LIST'){
				if(count_record_role>=1){
				parent.frames[1].location.href = '../../eSM/jsp/repUserList.jsp?module_id=SM&function_id=SM_RPT_USERS&function_name='+encodeURIComponent(getLabel('eSM.UserList.label','SM'))+'&function_type=R&access=NNNNN';
				}
				else{
				var error=getMessage('INVALID_USER','SM');
				alert(error);
				}
			}
			if(val == 'RESP_USER_LIST'){
				if(count_record_role>=1){
				parent.frames[1].location.href = '../../eSM/jsp/repRespUserList.jsp?module_id=SM&function_id=SM_RPT_USERS&function_name='+encodeURIComponent(getLabel('eSM.DatabaseRoles.label','SM'))+'User/Responsibility Access List&function_type=R&access=NNNNN';
				}
				else{
				var error=getMessage('INVALID_USER','SM');
				alert(error);
				}

			}
			
			
			if(val == 'HEALTHCARE_SETTING_TYPE')
			{
				if(count_record_role>=1)
				{
				parent.frames[1].location.href = '../../eAM/jsp/HealthCareSettingType.jsp?module_id=AM&function_id=HCARE_SET_TYPE&function_name='+encodeURIComponent(getLabel('Common.HealthcareSettingType.label','Common'))+'&function_type=F&access=YYYNN';
				}
				else{
				var error=getMessage('INVALID_USER','SM');
				alert(error);
				}

			}

			if(val == 'ACCT_PARAMETERS')
			{
				if(count_record_role>=1)
				{
					parent.frames[1].location.href = '../../eSM/jsp/AccountingParameters.jsp?module_id=SM&function_id=ACCT_PARAMETERS&function_name='+encodeURIComponent(getLabel('eSM.AccountingParameters.label','SM'))+'&function_type=F&access=NYNNN';
				}
				else
				{
					var error=getMessage('INVALID_USER','SM');
					alert(error);
				}
			}

			if(val == 'DOC_TYPES')
			{
				if(count_record_role>=1)
				{
					parent.frames[1].location.href = '../../eSM/jsp/DocumentType.jsp?module_id=SM&function_id=DOC_TYPES&function_name='+encodeURIComponent(getLabel('eSM.DocumentTypes.label','SM'))+'&function_type=F&access=YYYNN';
				}
				else
				{
					var error=getMessage('INVALID_USER','SM');
					alert(error);
				}
			}

			if(val == 'FOREIGN_CURRENCY')
			{
				if(count_record_role>=1)
				{
					parent.frames[1].location.href = '../../eSM/jsp/ForeignCurrency.jsp?module_id=SM&function_id=FOREIGN_CURRENCY&function_name='+encodeURIComponent(getLabel('eSM.ForeignCurrency.label','SM'))+'&function_type=F&access=YYYNN';
				}
				else
				{
					var error=getMessage('INVALID_USER','SM');
					alert(error);
				}
			}
			if(val == 'GENERATE_ACC_PERIOD')
			{
				if(count_record_role>=1)
				{
					parent.frames[1].location.href = '../../eSM/jsp/GenerateAccountingPeriod.jsp?module_id=SM&function_id=GENERATE_ACC_PERIOD&function_name='+encodeURIComponent(getLabel('eSM.GenActPeriod.label','SM'))+'&function_type=F&access=NYNNN';
				}
				else
				{
					var error=getMessage('INVALID_USER','SM');
					alert(error);
				}
			}
			if(val == 'MAINTAIN_ACC_PERIOD')
			{
				if(count_record_role>=1)
				{
					parent.frames[1].location.href = '../../eSM/jsp/MaintainAccountingPeriod.jsp?module_id=SM&function_id=MAINTAIN_ACC_PERIOD&function_name='+encodeURIComponent(getLabel('eSM.MaintainActPeriod.label','SM'))+'&function_type=F&access=YYYNN';
				}
				else
				{
					var error=getMessage('INVALID_USER','SM');
					alert(error);
				}
			}
			if(val == 'CANCELLED_DOCUMENTS')
			{
				if(count_record_role>=1)
				{
					parent.frames[1].location.href = '../../eSM/jsp/CancelledDocuments.jsp?module_id=SM&function_id=CANCELLED_DOCUMENTS&function_name='+encodeURIComponent(getLabel('eSM.CancelledDocuments.label','SM'))+'&function_type=F&access=NNYNN';
				}
				else
				{
					var error=getMessage('INVALID_USER','SM');
					alert(error);
				}
			}


		/*	if(val == 'BACK_PROCESS'){
				if(count_record_role>=1){
				parent.frames[1].location.href = '../../eSM/jsp/AdministerBackGroundProcesses.jsp?module_id=SM&function_id=ADMIN_BACKGROUND_PROCESSES&function_name=Administer Background Processes&function_type=F&access=NNNNN';
				}
				else{
				var error=getMessage('INVALID_USER');
				alert(error);
				}

			}
			if(val == 'BACK_PROCESS_ERR'){
				if(count_record_role>=1){
				parent.frames[1].location.href = '../../eSM/jsp/BackGroundProcessErrors.jsp?module_id=SM&function_id=BACKGROUND_PROCESS_ERRORS&function_name=Background Process Error Messages&function_type=F&access=NNYNN';
				}
				else{
				var error=getMessage('INVALID_USER');
				alert(error);
				}

			}*/
		}
		
		function refreshPage()
		{
			parent.frames[0].location.href='../../eSM/jsp/SM_Admin_Setup.jsp?expand='+expand
		}
		
		function chkRow( ro,val,exp )
		{
			var E =expand.charAt(0)
			var A =expand.charAt(1)
			var P =expand.charAt(2)			
			var F =expand.charAt(3)			
			var O =expand.charAt(4)
			var Q =expand.charAt(5)			
			var R =expand.charAt(6)
			var B =expand.charAt(7)
			if( val == "E" )
			{
				if( exp =="E")
					E = "C";
				else
					E = "E";
			}
			
			if( val == "A"  )
			{
				 if( exp =="E" )
					A= "C"
				else
					A = "E";
			}
			if( val == "P" )
			{
				if(exp =="E" )
					P="C";
				else
					P ="E"
			}
			if( val == "F" )
			{
				if(exp =="E" )
					F="C";
				else
					F ="E"
			}
			if( val == "O")
			{
				if(exp =="E" )
					O ="C"
				else
					O ="E"
			}
			if( val == "Q")
			{
				if(exp =="E" )
					Q ="C"
				else
					Q ="E"
			}
			if( val == "R")
			{
				if(exp =="E" )
					R ="C"
				else
					R ="E"
			}
			if( val == "B" )
			{
				if( exp =="E")
					B = "C";
				else
					B = "E";
			}
		
			expand = E + A + P + F + O + Q + R + B;
			parent.frames[1].location.href = '../../eCommon/html/blank.html'
		}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<% 
  request.setCharacterEncoding("UTF-8");
String expand=request.getParameter("expand");
if( expand == null) expand="CCCCCCCC";
/*String responsibility_id= (String) session.getValue("responsibility_id");
String Log_user= (String)session.getValue("login_user");
Connection con=null;
ResultSet rs=null;
Statement stmt=null;
int count_record_role=0;
int count_record_admin=0;*/
int count_record_role=1;
int count_record_admin=1;
/*try{
	con = ConnectionManager.getConnection(request);
	stmt=con.createStatement();
		String sqlRole ="select count(1) from sm_resp  where ora_role_id='MEDADMIN' and resp_id='"+responsibility_id+"' ";
		rs=stmt.executeQuery(sqlRole);
		if (rs !=null){
			while (rs.next()){
				count_record_role=rs.getInt(1);					
			}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		}	


		String sql_admin="select count(1) from sm_menu_admin where menu_admin_id='"+Log_user+"' AND SYSDATE BETWEEN NVL (eff_date_from, SYSDATE-1) AND NVL (eff_date_TO, SYSDATE+1)";  
		stmt = con.createStatement();
		rs=stmt.executeQuery(sql_admin);
			if (rs !=null){
				while (rs.next()){
					count_record_admin=rs.getInt(1);	
					}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
				}

	}
	catch(Exception e){out.println(e);}
	finally { 
    if(stmt !=null) stmt.close();
	if(rs !=null) rs.close();
	ConnectionManager.returnConnection(con,request);
	}
*/
%>
	<body onKeyDown = 'lockKey()'; OnMouseDown='CodeArrest()' style="background-color:dimgray;" >
	<form name="SMMasterMenu_form" id="SMMasterMenu_form">
	<table cellspacing=1 cellpadding=2 width='111%' border=0 id='t'>
		<tr onclick = "chkRow(this,'E','<%=expand.charAt(0) %>')">
			<% if(expand.charAt(0) == 'E') {%>
			<td  class='ECMENUHIGHERLEVELCOLOR'><a  href=javascript:refreshPage() style='color:white;' >-<fmt:message key="eSM.EnterpriseAdmin.label" bundle="${sm_labels}"/>  </td>
			<% } else { %>
			<td  class='ECMENUHIGHERLEVELCOLOR'><a  href=javascript:refreshPage() style='color:white;'  >+<fmt:message key="eSM.EnterpriseAdmin.label" bundle="${sm_labels}"/> </td>
			<% } %>
		</tr>
		
		<% if(expand.charAt(0) == 'E') {%>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('SITE',<%=count_record_role%>,<%=count_record_admin%>)"><fmt:message key="Common.Site.label" bundle="${common_labels}"/></td>
		</tr>
		
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('HEALTHCARE_SETTING_TYPE',<%=count_record_role%>,<%=count_record_admin%>)"><fmt:message key="Common.HealthcareSettingType.label" bundle="${common_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('FACILITY',<%=count_record_role%>,<%=count_record_admin%>)"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('OPERATIONAL_STATUS',<%=count_record_role%>,<%=count_record_admin%>)"><fmt:message key="eSM.OperationalStatus.label" bundle="${sm_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('DAY_OF_THE_WEEK',<%=count_record_role%>,<%=count_record_admin%>)"><fmt:message key="Common.dayofweek.label" bundle="${common_labels}"/></td>
		</tr>

		<% } %>
		<tr onclick = "chkRow(this,'A','<%=expand.charAt(1) %>')">
			<% if(expand.charAt(1) == 'E') {%>
			<td  class='ECMENUHIGHERLEVELCOLOR'><a  href=javascript:refreshPage() style='color:white;' >-<fmt:message key="eSM.ApplicationSecurity.label" bundle="${sm_labels}"/></a></td>
			<% } else { %>
			<td  class='ECMENUHIGHERLEVELCOLOR'><a  href=javascript:refreshPage() style='color:white;' >+<fmt:message key="eSM.ApplicationSecurity.label" bundle="${sm_labels}"/></a></td>
			<% } %>
			
		</tr>
		
		<% if(expand.charAt(1) == 'E') { %>
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('RESPONSIBILITY_GROUP',<%=count_record_role%>,<%=count_record_admin%>)" ><fmt:message key="eSM.ResponsibilityGroup.label" bundle="${sm_labels}"/>
</td>
		</tr>	
		
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR'onclick='javascript:callJSPs("MENU_ADMINISTRATOR",<%=count_record_role%>,<%=count_record_admin%>)' ><fmt:message key="eSM.MenuAdministrator.label" bundle="${sm_labels}"/>
</td>
		</tr>	

		
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR'onclick='javascript:callJSPs("FUNCTION_BY_RESPONSIBILITY_GROUP",<%=count_record_role%>,<%=count_record_admin%>)' ><fmt:message key="eSM.FunctionsbyResponsibilityGroup.label" bundle="${sm_labels}"/>
 </td>
		</tr>	
		
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick='javascript:callJSPs("DATABASE_RESOURCE_GROUP",<%=count_record_role%>,<%=count_record_admin%>)' ><fmt:message key="eSM.DatabaseResourceGroup.label" bundle="${sm_labels}"/>
</td>
		</tr>			
		
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick='javascript:callJSPs("DATABASE_ROLES",<%=count_record_role%>,<%=count_record_admin%>)' ><fmt:message key="eSM.DatabaseRoles.label" bundle="${sm_labels}"/>
 </td>
		</tr>	
		
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick='javascript:callJSPs("CREATE_MENU",<%=count_record_role%>,<%=count_record_admin%>)' ><fmt:message key="eSM.CreateMenu.label" bundle="${sm_labels}"/>
</td>
		</tr>	
		
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick='javascript:callJSPs("CONSTRUCT_MENU",<%=count_record_role%>,<%=count_record_admin%>)'><fmt:message key="eSM.ConstructMenu.label" bundle="${sm_labels}"/>
</td>
		</tr>	
		
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick='javascript:callJSPs("ACCESS_RIGHTS_FOR_MENU_FUNCTIONS",<%=count_record_role%>,<%=count_record_admin%>)' ><fmt:message key="eSM.AccessRightsForMenuFunctions.label" bundle="${sm_labels}"/>
</td>
		</tr>	
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick='javascript:callJSPs("RESPONSIBILITY",<%=count_record_role%>,<%=count_record_admin%>)' ><fmt:message key="Common.responsibility.label" bundle="${common_labels}"/></td>
		</tr>	
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick='javascript:callJSPs("RESPONSIBILITY_FOR_FACILITY",<%=count_record_role%>,<%=count_record_admin%>)' >	<fmt:message key="eSM.ResponsibilityforFacility.label" bundle="${sm_labels}"/></td>
		</tr>	
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick='javascript:callJSPs("MENU_RESTRICTION_FOR_RESPONSIBILITY",<%=count_record_role%>,<%=count_record_admin%>)' ><fmt:message key="eSM.MenuRestrictionforResponsibility.label" bundle="${sm_labels}"/></td>
		</tr>	
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick='javascript:callJSPs("USER",<%=count_record_role%>,<%=count_record_admin%>)'><fmt:message key="Common.user.label" bundle="${common_labels}"/>
</td>
		</tr>	
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick='javascript:callJSPs("RESPONSIBILITY_FOR_USER",<%=count_record_role%>,<%=count_record_admin%>)' ><fmt:message key="eSM.ResponsibilityforUser.label" bundle="${sm_labels}"/>
</td>
		</tr>	
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR'onclick='javascript:callJSPs("FACILITY_FOR_USER",<%=count_record_role%>,<%=count_record_admin%>)' ><fmt:message key="eSM.FacilitiesforUser.label" bundle="${sm_labels}"/></td>
		</tr>	
		
		<% } %>
		
		<tr onclick = "chkRow(this,'P','<%=expand.charAt(2) %>')">
			<% if(expand.charAt(2) == 'E') {%>
			<td  class='ECMENUHIGHERLEVELCOLOR'><a  href=javascript:refreshPage() style='color:white;' >-<fmt:message key="eSM.PrintRouting.label" bundle="${sm_labels}"/></a></td>
			<% } else { %>
			<td  class='ECMENUHIGHERLEVELCOLOR'><a  href=javascript:refreshPage() style='color:white;' >+<fmt:message key="eSM.PrintRouting.label" bundle="${sm_labels}"/></a></td>
			<% } %>
		</tr>
		
		<% if(expand.charAt(2) == 'E') { %>
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR'onclick='javascript:callJSPs("REPORT_SERVICE",<%=count_record_role%>,<%=count_record_admin%>)' ><fmt:message key="eSM.ReportService.label" bundle="${sm_labels}"/>
</td>
		</tr>	

		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick='javascript:callJSPs("PRINTER",<%=count_record_role%>,<%=count_record_admin%>)'><fmt:message key="eSM.Printer.label" bundle="${sm_labels}"/>
</td>
		</tr>		
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick='javascript:callJSPs("REPORT_GROUP",<%=count_record_role%>,<%=count_record_admin%>)' ><fmt:message key="eSM.ReportGroup.label" bundle="${sm_labels}"/>
</td>
		</tr>
		
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick='javascript:callJSPs("REPORT",<%=count_record_role%>,<%=count_record_admin%>)' ><fmt:message key="Common.report.label" bundle="${common_labels}"/></td>
		</tr>
		
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick='javascript:callJSPs("FACILITY_BASED_REPORT_PARAMETERS",<%=count_record_role%>,<%=count_record_admin%>)' ><fmt:message key="eSM.FacilitybasedReportParameters.label" bundle="${sm_labels}"/>&nbsp;</td>
		</tr>
		
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick='javascript:callJSPs("PRINT_ROUTING",<%=count_record_role%>,<%=count_record_admin%>)' ><fmt:message key="eSM.PrintRouting.label" bundle="${sm_labels}"/></td>
		</tr>
		
		<% } %>

<!-- Added by Seshu -->
		<tr onclick = "chkRow(this,'F','<%=expand.charAt(3) %>')">
			<% if(expand.charAt(3) == 'E') {%>
			<td  class='ECMENUHIGHERLEVELCOLOR'><a  href=javascript:refreshPage() style='color:white;' >-<fmt:message key="eSM.FinancialSetup.label" bundle="${sm_labels}"/> </td>
			<% } else { %>
			<td  class='ECMENUHIGHERLEVELCOLOR'><a  href=javascript:refreshPage() style='color:white;'  >+<fmt:message key="eSM.FinancialSetup.label" bundle="${sm_labels}"/> </td>
			<% } %>
		</tr>
		
		<% if(expand.charAt(3) == 'E') {%>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('ACCT_PARAMETERS',<%=count_record_role%>,<%=count_record_admin%>)"><fmt:message key="eSM.AccountingParameters.label" bundle="${sm_labels}"/>
</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('DOC_TYPES',<%=count_record_role%>,<%=count_record_admin%>)"><fmt:message key="eSM.DocumentTypes.label" bundle="${sm_labels}"/>
       </td>
		</tr>
		<tr onclick='chcol(this)'>
			 <td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('FOREIGN_CURRENCY',<%=count_record_role%>,<%=count_record_admin%>)"><fmt:message key="eSM.ForeignCurrency.label" bundle="${sm_labels}"/>
       </td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('GENERATE_ACC_PERIOD',<%=count_record_role%>,<%=count_record_admin%>)"><fmt:message key="eSM.GenActPeriod.label" bundle="${sm_labels}"/>
       </td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('MAINTAIN_ACC_PERIOD',<%=count_record_role%>,<%=count_record_admin%>)"><fmt:message key="eSM.MaintainActPeriod.label" bundle="${sm_labels}"/>
       </td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onclick="javascript:callJSPs('CANCELLED_DOCUMENTS',<%=count_record_role%>,<%=count_record_admin%>)"><fmt:message key="eSM.CancelledDocuments.label" bundle="${sm_labels}"/>
       </td>
		</tr>
		<% } %>
<!-- Added by Seshu Ends -->

		<% if(expand.charAt(4) == 'E') { %>

		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick='javascript:callJSPs("FREQUENTLY_ACCESSED_LIST",<%=count_record_role%>,<%=count_record_admin%>)' ><fmt:message key="eSM.FrequentlyAccessedList.label" bundle="${sm_labels}"/>
</td>
		</tr>
		<% } %>

		<tr onclick = "chkRow(this,'Q','<%=expand.charAt(5) %>')">
			<% if(expand.charAt(5) == 'E') {%>
			<td  class='ECMENUHIGHERLEVELCOLOR'><a href=javascript:refreshPage() style='color:white;'>-<fmt:message key="eSM.Queries.label" bundle="${sm_labels}"/></a></td>
			<% } else { %>
			<td  class='ECMENUHIGHERLEVELCOLOR'><a href=javascript:refreshPage() style='color:white;'>+<fmt:message key="eSM.Queries.label" bundle="${sm_labels}"/></a></td>
			<% } %>
		</tr>

		<% if(expand.charAt(5) == 'E') { %>

		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick='javascript:callJSPs("FUNCTION",<%=count_record_role%>,<%=count_record_admin%>)' ><fmt:message key="Common.Function.label" bundle="${common_labels}"/>
</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick='javascript:callJSPs("QUERY_ON_USERS",<%=count_record_role%>,<%=count_record_admin%>)' ><fmt:message key="eSM.QueryonUsers.label" bundle="${sm_labels}"/>
</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick='javascript:callJSPs("QUERY_ON_RESPONSIBILITY",<%=count_record_role%>,<%=count_record_admin%>)' ><fmt:message key="eSM.QueryonResponsibility.label" bundle="${sm_labels}"/>
 </td>
		</tr>

		<% } %>

		<tr onclick = "chkRow(this,'R','<%=expand.charAt(6) %>')">
			<% if(expand.charAt(6) == 'E') {%>
			<td  class='ECMENUHIGHERLEVELCOLOR'><a href=javascript:refreshPage() style='color:white;'>-<fmt:message key="eSM.Reports.label" bundle="${sm_labels}"/></a></td>
			<% } else { %>
			<td  class='ECMENUHIGHERLEVELCOLOR'><a href=javascript:refreshPage() style='color:white;'>+<fmt:message key="eSM.Reports.label" bundle="${sm_labels}"/></a></td>
			<% } %>
		</tr>
		
		<% if(expand.charAt(6) == 'E') { %>

		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick='javascript:callJSPs("SM_MASTER_CODE_LIST",<%=count_record_role%>,<%=count_record_admin%>)' ><fmt:message key="eSM.SMMasterCodeList.label" bundle="${sm_labels}"/>
</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick='javascript:callJSPs("RESPONSIBILITY_LIST",<%=count_record_role%>,<%=count_record_admin%>)' ><fmt:message key="eSM.ResponsibilityList.label" bundle="${sm_labels}"/>
</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick='javascript:callJSPs("USER_LIST",<%=count_record_role%>,<%=count_record_admin%>)' ><fmt:message key="eSM.UserList.label" bundle="${sm_labels}"/></td>
		</tr>
<!-- 		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick='javascript:callJSPs("RESP_USER_LIST",<%=count_record_role%>,<%=count_record_admin%>)' >&nbsp;&nbsp;User / Responsibility Access List</td>
		</tr>
 -->
			
		<% }
			out.println( "<script>expand='"+ expand +"'</script>" );
		%>
		
		
		<tr >
			<td class='ECMENUHIGHERLEVELCOLOR'><a href=javascript:goHomePage() style='color:white;'><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td>
		</tr>
		</table>

	</body>
	
	</form>
</html>

