<!DOCTYPE html>
<%@ page import= "java.text.*,java.sql.Types,java.sql.PreparedStatement,java.sql.CallableStatement,java.sql.Connection,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");	%>

<html>
<head>

<% String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language=JavaScript src="../../eCommon/js/menu.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script>

		var temparr = new Array();
		var count = 0;
		var prev=1;
		var prevcol='MENUSUBLEVELCOLOR';
		//var prevcol='ECMENUHIGHERLEVELCOLOR';
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
			var ChartDefinition_function_name = encodeURIComponent(getLabel("eOH.ChartDefinition.Label","OH"));
			var ToothApplicabilityForChart_function_name = encodeURIComponent(getLabel("eOH.ToothApplicabilityForChart.Label","OH"));
			var TreatmentCategories_function_name = encodeURIComponent(getLabel("eOH.TreatmentCategories.Label","OH"));
			var SpltyConditions_function_name = encodeURIComponent(getLabel("eOH.SpltyConditions.Label","OH"));
			var SpecialityLink_function_name = encodeURIComponent(getLabel("eOH.SpecialityLink.Label","OH"));
			var NoteTypeLink_function_name = encodeURIComponent(getLabel("eOH.NoteTypeLink.Label","OH"));
			var SpltyTreatmentProc_function_name = encodeURIComponent(getLabel("eOH.SpltyTreatmentProc.Label","OH"));
			var ClinicalGroup_function_name = encodeURIComponent(getLabel("eOH.ClinicalGroup.Label","OH"));
			var Complications_function_name = encodeURIComponent(getLabel("Common.Complications.label","Common"));
			var TreatmentCatTypesForComplications_function_name = encodeURIComponent(getLabel("eOH.TreatmentCatTypesForComplications.Label","OH"));
			var TreatmentCatTypesForCompositionClass_function_name = encodeURIComponent(getLabel("eOH.TreatmentCatTypesForCompositionClass.Label","OH"));
			var CompositionClass_function_name = encodeURIComponent(getLabel("eOH.CompositionClass.Label","OH"));
			var Composition_function_name = encodeURIComponent(getLabel("Common.Composition.label","Common"));
			var TasksLink_function_name = encodeURIComponent(getLabel("eOH.TreatmentsTasksLink.Label","OH"));
			var Tasks_function_name = encodeURIComponent(getLabel("Common.Tasks.label","Common"));
			
			var formObj = document.forms[0];
			var ca_module_yn = formObj.ca_module_yn.value;			

		    if(val == 'PeriodontalChartSetup'){
				parent.frames[1].location.href = '../../eOH/jsp/PeriodontalChartSetup.jsp?module_id=OH&function_id=PeriodontalChart&function_name='+ChartDefinition_function_name+'&function_type=F&mode=insert&access=YYYNN';
			}
			if(val == 'PeriodontalChartSetup1'){
				parent.frames[1].location.href = '../../eOH/jsp/PerioToothApplicability.jsp?module_id=OH&function_id=PerioToothApplicability&function_name='+ToothApplicabilityForChart_function_name+'&function_type=F&mode=insert&access=YYYNN';
			}
		    if(val == 'TreatmentCategories'){
				parent.frames[1].location.href = '../../eOH/jsp/MTreatmentCategories.jsp?module_id=OH&function_id=TreatmentCategories&function_name='+TreatmentCategories_function_name+'&function_type=F&mode=insert&access=YYYNN';
			}
			if(val == 'SpltyConditions'){
				parent.frames[1].location.href = '../../eOH/jsp/MSpltyConditions.jsp?module_id=OH&function_id=SpltyConditions&function_name='+SpltyConditions_function_name+'&function_type=F&mode=insert&access=YYYNN';
			}
			if(val == 'SpecialityLink'){
				parent.frames[1].location.href = '../../eOH/jsp/MSpecialityLink.jsp?module_id=OH&function_id=SpecialityLink&function_name='+SpecialityLink_function_name+'&function_type=F&mode=insert&access=YYYNN';
			}
			if(val == 'NoteTypeLink'){
				parent.frames[1].location.href = '../../eOH/jsp/MNoteTypeLink.jsp?module_id=OH&function_id=NoteTypeLink&function_name='+NoteTypeLink_function_name+'&function_type=F&mode=insert&access=YYYNN';
			}
			if(val == 'SpltyTreatmentProc'){
				// Old calling parent.frames[1].location.href = '../../eOH/jsp/MSpltyTreatmentProc.jsp?module_id=OH&function_id=SpltyTreatmentProc&function_name='+SpltyTreatmentProc_function_name+'&function_type=F&mode=insert&access=YYYNN';
				parent.frames[1].location.href = '../../eOH/jsp/MTreatments.jsp?module_id=OH&function_id=SpltyTreatmentProc&function_name='+SpltyTreatmentProc_function_name+'&function_type=F&mode=insert&access=YYYNN';
			}
			if(val == 'ClinicalGroup'){
				parent.frames[1].location.href = '../../eOH/jsp/MClinicalGroup.jsp?module_id=OH&function_id=ClinicalGroup&function_name='+ClinicalGroup_function_name+'&function_type=F&mode=insert&access=YYYNN';
			}
			if(val == 'Complications'){
				parent.frames[1].location.href = '../../eOH/jsp/MComplications.jsp?module_id=OH&function_id=Complications&function_name='+Complications_function_name+'&function_type=F&mode=insert&access=YYYNN';
			}
			if(val == 'TreatmentCatTypesForComplications'){
				parent.frames[1].location.href = '../../eOH/jsp/MTrmtCatTypeForComplications.jsp?module_id=OH&function_id=TreatmentCatTypesForComplications&function_name='+TreatmentCatTypesForComplications_function_name+'&function_type=F&mode=insert&access=YYYNN';
			}			
			if(val == 'ProcCompositionClass'){
				parent.frames[1].location.href = '../../eOH/jsp/MProcCompositionClass.jsp?module_id=OH&function_id=ProcCompositionClass&function_name='+CompositionClass_function_name+'&function_type=F&mode=insert&access=YYYNN';
			}
			if(val == 'TreatmentCatTypesForCompositionClass'){
				parent.frames[1].location.href = '../../eOH/jsp/MTrmtCatTypeForCompositionClass.jsp?module_id=OH&function_id=TreatmentCatTypesForCompositionClass&function_name='+TreatmentCatTypesForCompositionClass_function_name+'&function_type=F&mode=insert&access=YYYNN';
			}			
			if(val == 'ProcComposition'){
				parent.frames[1].location.href = '../../eOH/jsp/MProcComposition.jsp?module_id=OH&function_id=ProcComposition&function_name='+Composition_function_name+'&function_type=F&mode=insert&access=YYYNN';
			}
			if(val == 'Tasks'){
				parent.frames[1].location.href = '../../eOH/jsp/MTasks.jsp?module_id=OH&function_id=Tasks&function_name='+Tasks_function_name+'&function_type=F&mode=insert&access=YYYNN';
			}
			if(val == 'TasksLink'){
				parent.frames[1].location.href = '../../eOH/jsp/MTasksLink.jsp?module_id=OH&function_id=TasksLink&function_name='+TasksLink_function_name+'&function_type=F&mode=insert&access=YYYNN';
			}
			
	}

	</script>

	</head>
<% 
	String expand=request.getParameter("expand");
	if( expand == null) 
		expand="CCCCCCCC";
	
	String facility_id  = (String) session.getValue("facility_id");
	String responsibility_id= (String) session.getValue("responsibility_id");
	String Log_user= (String)session.getValue("login_user");
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement pstmt=null;
	CallableStatement cstmt = null;
	String modules_list = "";
	String ca_module_yn="";
	String trace="0";
	int count_record_role=0;
	int count_record_admin=0;
	try{
		trace="1";
		con = ConnectionManager.getConnection(request);
		pstmt=con.prepareStatement("SELECT COUNT(1) FROM SM_RESP  WHERE ORA_ROLE_ID='MEDADMIN' AND RESP_ID=? ");
		pstmt.setString(1,responsibility_id);
		rs=pstmt.executeQuery();
		while (rs.next()){
			count_record_role=rs.getInt(1);					
		}

		trace="2";
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		pstmt=con.prepareStatement("SELECT COUNT(1) FROM SM_MENU_ADMIN WHERE MENU_ADMIN_ID=? AND TO_CHAR(SYSDATE,'DD/MM/YYYY')>= NVL(TO_CHAR(EFF_DATE_FROM,'DD/MM/YYYY'),SYSDATE-1) and TO_CHAR(SYSDATE,'DD/MM/YYYY')<=NVL(TO_CHAR(EFF_DATE_TO,'DD/MM/YYYY'),SYSDATE+1) ");
		pstmt.setString(1,Log_user);
		rs=pstmt.executeQuery();
		while (rs.next()){
				count_record_admin=rs.getInt(1);	
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

	// Check for CA Module Existence
		trace="3";
		cstmt=con.prepareCall("{call GET_OPERATIONAL_MODULES(?,?)}");
		cstmt.setString(1,facility_id);
		cstmt.registerOutParameter(2,Types.VARCHAR);
		cstmt.execute();
		modules_list=cstmt.getString(2);
		if(modules_list.indexOf("OR|")>=0)
			ca_module_yn="Y";	// When CA is  Operational
		else
			ca_module_yn="N";	// When CA is not Operational
	}catch(Exception e){
		out.println(e);
		out.println("trace==="+trace);
	}finally { 
		if(rs !=null) rs.close();
		if(pstmt !=null) pstmt.close();
		if(cstmt !=null) cstmt.close();
		ConnectionManager.returnConnection(con,request);
	}

%>

<body style="background-color:dimgray;"  OnMouseDown='CodeArrest()' onKeyDown="lockKey()" >
<form name="OHCodeMasterMenu_form" id="OHCodeMasterMenu_form">
	<input type="hidden" name='menu_values' id='menu_values'>
	<input type="hidden" name='ca_module_yn' id='ca_module_yn' value="<%=ca_module_yn%>">

<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>	
	<tr>
		<td class='CAGROUP' ><b><fmt:message key="eOH.ConditionsTreatments.Label" bundle="${oh_labels}"/></b></td>
	</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SpltyConditions')">
				<fmt:message key="eOH.SpltyConditions.Label" bundle="${oh_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TreatmentCategories')">
				<fmt:message key="eOH.TreatmentCategories.Label" bundle="${oh_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SpltyTreatmentProc')">
				<fmt:message key="eOH.SpltyTreatmentProc.Label" bundle="${oh_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Tasks')">
				<fmt:message key="Common.Tasks.label" bundle="${common_labels}"/>
			</td>
		</tr>	
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TasksLink')">
				<fmt:message key="eOH.TreatmentsTasksLink.Label" bundle="${oh_labels}"/>
			</td>
		</tr>	
	<tr>
		<td class='CAGROUP' ><b><fmt:message key="eOH.Compositions.Label" bundle="${oh_labels}"/></b></td>
	</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ProcCompositionClass')">
				<fmt:message key="eOH.CompositionClass.Label" bundle="${oh_labels}"/>
			</td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TreatmentCatTypesForCompositionClass')">
				<fmt:message key="eOH.TreatmentCatTypesForCompositionClass.Label" bundle="${oh_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ProcComposition')">
				<fmt:message key="Common.Composition.label" bundle="${common_labels}"/>
			</td>
		</tr>
	<tr>
		<td class='CAGROUP' ><b><fmt:message key="Common.Complications.label" bundle="${common_labels}"/></b></td>
	</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Complications')">
				<fmt:message key="Common.Complications.label" bundle="${common_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TreatmentCatTypesForComplications')">
				<fmt:message key="eOH.TreatmentCatTypesForComplications.Label" bundle="${oh_labels}"/>
			</td>
		</tr>
	<tr>
		<td class='CAGROUP' ><b><fmt:message key="eOH.PeriodontalChartSetup.Label" bundle="${oh_labels}"/></b></td>
	</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PeriodontalChartSetup')">
				<fmt:message key="eOH.ChartDefinition.Label" bundle="${oh_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PeriodontalChartSetup1')">
				<fmt:message key="eOH.ToothApplicabilityForChart.Label" bundle="${oh_labels}"/>
			</td>
		</tr>
	<tr>
		<td class='CAGROUP' ><b><fmt:message key="Common.others.label" bundle="${common_labels}"/></b></td>
	</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ClinicalGroup')">
				<fmt:message key="eOH.ClinicalGroup.Label" bundle="${oh_labels}"/>
			</td>
		</tr>

	<tr onclick='chcol(this)'>
	<tr>
		<td class='ECMENUHIGHERLEVELCOLOR' ><a href=javascript:goHomePage() style='color:white;'><b>
			<fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a>
		</td>
	</tr>
	
</table>
</body>
</form>
</html>

