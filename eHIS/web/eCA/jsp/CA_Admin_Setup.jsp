<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
    <head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <style>
        A:active { 
            COLOR: white; 
        }

    </style>
    
    <script>
        var temparr = new Array();
        var count = 0;
        var prev=1;
        var prevcol='MENUSUBLEVELCOLOR';
        var sec_hdg_cd=new Array();
        var logic_seq_no=new Array();

        function goHomePage(){
                parent.location.href='../../eCommon/jsp/dmenu.jsp';
        }
        
        function chcol(ro)
        {
                document.getElementById("t").rows(prev).cells(0).className=prevcol;
                prevcol=ro.cells(0).className;
                ro.cells(0).className="MENUSELECTEDCOLOR";
                prev=ro.rowIndex;
        }

        function callJSPs(val)
        {
            /*
                    Access is in the order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess
            */
            if(val == 'EncounterParameter')
                parent.frames[1].location.href = '../../eCA/jsp/EncounterParameter.jsp?module_id=CA&function_id=ENCOUNTER_PARAMETER&function_name='+encodeURIComponent(getLabel("eCA.AddEncounterparameter.label","CA"))+'&function_type=F&access=NYNNN';
            if(val == 'ApplicationTask')
                parent.frames[1].location.href = '../../eCA/jsp/ApplicationTask.jsp?module_id=CA&function_id=APPLICATION_TASK&function_name='+encodeURIComponent(getLabel("eCA.ApplicableTask.label","CA"))+'&function_type=F&access=NYNNN';

			if(val == 'PractRelation'){
				parent.frames[1].location.href = '../../eCA/jsp/PractRelation.jsp?module_id=CA&function_id=PRACT_RELATION&function_name='+encodeURIComponent(getLabel("Common.relationship.label","Common"))+'&function_type=F&access=YYYNN';
			}
		 if(val == 'PractRelnforResp'){
				parent.frames[1].location.href = '../../eCA/jsp/RelnforResp.jsp?module_id=CA&function_id=RELNFORRESP&function_name='+encodeURIComponent(getLabel("eCA.RelationshipforResponsibility.label","CA"))+'&function_type=F&access=YYYYN';
			}

		  if(val == 'TaskforRespReln'){
				parent.frames[1].location.href = '../../eCA/jsp/TaskForResp.jsp?module_id=CA&function_id=TASKFORRESP&function_name='+encodeURIComponent(getLabel("eCA.TaskForResponsibilityRelationship.label","CA"))+'&function_type=F&access=YNNNN';
			}

			if(val == 'NoteParameter')
                parent.frames[1].location.href = '../../eCA/jsp/NoteParameter.jsp?module_id=CA&function_id=NOTE_PARAMETER&function_name='+encodeURIComponent(getLabel("eCA.Noteparameter.label","CA"))+'&function_type=F&access=NYNNN';
            if(val == 'ClinicEventParameter')
                parent.frames[1].location.href = '../../eCA/jsp/ClinicEventParameter.jsp?module_id=CA&function_id=CLINIC_EVENT_PARAMETER&function_name='+encodeURIComponent(getLabel("eCA.ClinicEventParam.label","CA"))+'&function_type=F&access=NYNNN';

			if(val == 'ClinicEventMaster')
                parent.frames[1].location.href = '../../eCA/jsp/ClinicEventMaster.jsp?module_id=CA&function_id=CLINIC_EVENT_MASTER&function_name='+encodeURIComponent(getLabel("eCA.ClinicalEventMaster.label","CA"))+'&function_type=F&access=NYNNN';

			if(val == 'PractRelationSpeciality')
                parent.frames[1].location.href = '../../eCA/jsp/PractSpecialityRelation.jsp?module_id=CA&function_id=PRACT_SPECIALITY_RELATION&function_name='+encodeURIComponent(getLabel("eCA.SpecialtySpecificIndirectRelationship.label","CA"))+'&function_type=F&access=YNNNN';
		if(val == 'PersonalizedHomePage'){
				parent.frames[1].location.href = '../../eCA/jsp/CAPersonalizedMain.jsp?module_id=CA&function_id=CA_PERSONALIZED_HOME_PAGE&function_name='+encodeURIComponent(getLabel("eCA.DefinePersonalizedHomePage.label","CA"))+'&function_type=F&access=YYNNN';
		}
		if(val == 'PractHomePage'){
			parent.frames[1].location.href = '../../eCA/jsp/HomePageForPractMain.jsp?module_id=CA&function_id=PRACTHOMEPAGE&function_name='+encodeURIComponent(getLabel("eCA.PractitionerHomePage.label","CA"))+'&function_type=F&access=NYYNN';
		}

		if(val == 'ConstructCAMenu'){
			parent.frames[1].location.href = '../../eCA/jsp/ConstructCAMenuMain.jsp?module_id=CA&function_id=CONSTRUCTCAMENU&function_name='+encodeURIComponent(getLabel("eCA.ConstructCAMenu.label","CA"))+'&function_type=F&access=YNNNN';
		}
				if(val == 'AssignChartSumm'){
				parent.frames[1].location.href = '../../eCA/jsp/AssignChartSummMain.jsp?module_id=CA&function_id=ASSIGN_CHART_SUMM&function_name='+encodeURIComponent(getLabel("eCA.AssignChartSummary.label","CA"))+'&function_type=F&access=YYYYN';
			}
		if(val == 'CADefineMenu'){
				parent.frames[1].location.href = '../../eCA/jsp/CADefineMenuMain.jsp?module_id=CA&function_id=CA_DEFINE_MENU&function_name='+encodeURIComponent(getLabel("eCA.DefineMenu.label","CA"))+'&function_type=F&access=YYYNN';
			}
		if(val == 'CARedefineOption'){
				parent.frames[1].location.href = '../../eCA/jsp/CAOptionRedefineMain.jsp?module_id=CA&function_id=CA_REDEFINE_OPTION&function_name='+encodeURIComponent(getLabel("eCA.RedefineCAOption.label","CA"))+'&function_type=F&access=NYNNN';
		}
		//	 --------------------- 
		/*
		if(val == 'CustomCAMenu'){
				parent.frames[1].location.href = '../../eCA/jsp/IndexingCAMenuMain.jsp?module_id=CA&function_id=CUSTOM_CA_MENU&function_name=Customoized Indexing Menu&function_type=F&access=YNNNN';
		}
		*/
		//-----------------------

		if(val == 'AssignCAMenu'){
				parent.frames[1].location.href = '../../eCA/jsp/AssignCAMenuMain.jsp?module_id=CA&function_id=CA_ASSIGN_MENU&function_name='+encodeURIComponent(getLabel("eCA.AssignCAMenu.label","CA"))+'&function_type=F&access=YYYYN';
		}
			if(val == 'ChartHistoryTemplate'){
				parent.frames[1].location.href = '../../eCA/jsp/ChartHistoryTemplateMain.jsp?module_id=CA&function_id=CHART_HIST_TEMPLATE&function_name='+encodeURIComponent(getLabel("eCA.ChartSummaryTemplate.label","CA"))+'&function_type=F&access=YYNNN';
			}
			
		if(val == 'ChartSummContent'){
				parent.frames[1].location.href = '../../eCA/jsp/ChartSummContentMain.jsp?module_id=CA&function_id=CHART_SUMM_CONTENT&function_name='+encodeURIComponent(getLabel("eCA.ChartSummaryContent.label","CA"))+'&function_type=F&access=NYNNN';
			}
		if(val == 'AllowedDocTypes'){
				parent.frames[1].location.href = '../../eCA/jsp/AllowedDocTypes.jsp?module_id=CA&function_id=ALLOWED_DOC_TYPES&function_name='+encodeURIComponent(getLabel("eCA.AllowedDocTypes.label","CA"))+'&function_type=F&access=NYNNN';
			}
		if(val == 'EventSetup'){
				parent.frames[1].location.href = '../../eCA/jsp/ClinicalRepMast.jsp?module_id=CA&function_id=CLINICAL_REP_MAST&function_name='+encodeURIComponent(getLabel("eCA.EventSetup.label","CA"))+'&function_type=F&access=NYNNN';
		}
		
	/*	if(val == 'CL')
				parent.frames[1].location.href ='../../eCA/jsp/CommonLookupMain.jsp';
		
		if(val == 'ICD')
				parent.frames[1].location.href ='../../eCA/jsp/ICDMain.jsp'; */
		if(val == 'ExternalAppl'){
				parent.frames[1].location.href = '../../eCA/jsp/CAExternalApplMain.jsp?module_id=CA&function_id=CA_EXTERNAL_APPL&function_name='+encodeURIComponent(getLabel("eCA.ApplicationSetup.label","CA"))+'&function_type=F&access=NYYNN';
		}
		if(val == 'ExternalApplDtl'){
				parent.frames[1].location.href = '../../eCA/jsp/CAExternalApplDtlMain.jsp?module_id=CA&function_id=CA_EXT_APPL_DTL&function_name='+encodeURIComponent(getLabel("eCA.ExternalApplicationDetail.label","CA"))+'&function_type=F&access=YYYNN';
		}
		/*	if(val == 'PATSEARCH')
			{
			parent.frames[1].location.href = '../../eCA/jsp/NewPatientSearch.jsp?module_id=CA&function_id=PAT_SEARCH&function_name=SPat Search&function_type=F&access=YNNNN';
			}
		*/

		if(val == 'DocRefFormat')
		{
			parent.frames[1].location.href = '../../eCA/jsp/DocRefFmtMain.jsp?module_id=CA&function_id=DocRefFmt&function_name='+encodeURIComponent(getLabel("eCA.DocRefFormat.label","CA"))+'&function_type=F&access=NYNNN';

		//	parent.frames[1].location.href = '../../eCA/jsp/CADocRefFormatMain.jsp?module_id=CA&function_id=CA_DOC_REF_FORMAT&function_name='+encodeURIComponent(getLabel("eCA.DocRefFormat.label","CA"))+'&function_type=F&access=NYNNN';
		}

		if(val == 'PatEncBanner')
		{
			parent.frames[1].location.href = '../../eCA/jsp/PatEncBannerMain.jsp?module_id=CA&function_id=PatEncBanner&function_name='+encodeURIComponent(getLabel("eCA.PatEncBanner.label","CA"))+'&function_type=F&access=NYNNN';
		}
		if(val == 'PatEncBannerTrans')
		{
			parent.frames[1].location.href = '../../eCA/jsp/PatEncBannerTransMain.jsp?module_id=CA&function_id=PatEncBannerTrans&function_name=PatEncounterBannerTrans&function_type=F&access=NYNNN';
		}		
	}

    </script>

    </head>
	<%
		String license_rights = "";
		if( (eCA._ca_license_rights.getKey()).equals("CACLDC") )
		{
			license_rights= "FULL";
		}
		else if((eCA._ca_license_rights.getKey()).equals("CABASIC"))
		{
			license_rights= "BASIC";
		}
		else if((eCA._ca_license_rights.getKey()).equals("CAMINI"))
		{
			license_rights= "MINI";
		}
		%>
     <body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()" style="background-color:dimgray;"   > 
    <form name="CAAdminMenu_form" id="CAAdminMenu_form">
    <table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>        
		<tr>
            <td class='CAGROUP'><b><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></b></td>
        </tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PractRelation')"><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PractRelnforResp')"><fmt:message key="eCA.RelationshipforResponsibility.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PractRelationSpeciality')"><fmt:message key="eCA.SpecialtySpecificIndirectRelationship.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr>
            <td class='CAGROUP' ><b><fmt:message key="Common.Tasks.label" bundle="${common_labels}"/></b></td>
        </tr>
        <tr onclick='chcol(this)'>
            <td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ApplicationTask')"><fmt:message key="eCA.ApplicationTask.label" bundle="${ca_labels}"/></td>
        </tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TaskforRespReln')"><fmt:message key="eCA.TaskForResponsibilityRelationship.label" bundle="${ca_labels}"/></td>
		</tr>

		<tr>
            <td class='CAGROUP' ><b><fmt:message key="eCA.CHARTSUMMARY.label" bundle="${ca_labels}"/></b></td>
        </tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ChartSummContent')"><fmt:message key="eCA.ChartSummaryContent.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ChartHistoryTemplate')"><fmt:message key="eCA.ChartSummaryTemplate.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('AssignChartSumm')"><fmt:message key="eCA.AssignChartSummary.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr>
            <td class='CAGROUP' ><b><fmt:message key="eCA.CAMenu.label" bundle="${ca_labels}"/></b></td>
        </tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('CARedefineOption')"><fmt:message key="eCA.RedefineCAOption.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('CADefineMenu')"><fmt:message key="eCA.DefineMenu.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ConstructCAMenu')"><fmt:message key="eCA.ConstructCAMenu.label" bundle="${ca_labels}"/></td>
		</tr>

<!-- 		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('CustomCAMenu')">Customize Indexing Menu</td>
		</tr> -->


		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('AssignCAMenu')"><fmt:message key="eCA.AssignCAMenu.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr>
            <td class='CAGROUP' ><b><fmt:message key="eCA.HOMEPAGE.label" bundle="${ca_labels}"/></b></td>
        </tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PersonalizedHomePage')"><fmt:message key="eCA.PersonalizedHomePage.label" bundle="${ca_labels}"/></td>
		</tr>		
		<tr>
            <td class='CAGROUP' ><b><fmt:message key="eCA.PARAMETER.label" bundle="${ca_labels}"/> </b></td>
        </tr>
		<tr onclick='chcol(this)'>
            <td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('EncounterParameter')"><fmt:message key="eCA.EncounterParameter.label" bundle="${ca_labels}"/></td>
        </tr>
		<tr onclick='chcol(this)'>
            <td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('NoteParameter') "><fmt:message key="eCA.Noteparameter.label" bundle="${ca_labels}"/></td>
        </tr>
 		<tr onclick='chcol(this)'>
            <td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('AllowedDocTypes') "><fmt:message key="eCA.AllowedDocTypes.label" bundle="${ca_labels}"/></td>
        </tr> 
        <tr onclick='chcol(this)'>
            <td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ClinicEventParameter') "><fmt:message key="eCA.ClinicalEventParameter.label" bundle="${ca_labels}"/></td>
        </tr>
        <tr onclick='chcol(this)'>
            <td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ClinicEventMaster') "><fmt:message key="eCA.ClinicalEventMaster.label" bundle="${ca_labels}"/></td>
        </tr>
		<tr onclick='chcol(this)'>
            <td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('EventSetup')"><fmt:message key="eCA.EventSetup.label" bundle="${ca_labels}"/></td>
        </tr>
		<tr onclick='chcol(this)'>
            <td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DocRefFormat')"><fmt:message key="eCA.DocRefFormat.label" bundle="${ca_labels}"/></td>
        </tr>
<!-- 		<tr onclick='chcol(this)'>
            <td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PatEncBanner')"><fmt:message key="eCA.PatEncBanner.label" bundle="${ca_labels}"/></td>
        </tr>
		<tr onclick='chcol(this)'>
            <td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PatEncBannerTrans')"><fmt:message key="eCA.PatEncBannerTrans.label" bundle="${ca_labels}"/></td>
        </tr>	 -->	
        </tr>
		<% if (license_rights.equals("FULL") )
		{%> 
		<tr>
            <td class='CAGROUP' ><b><fmt:message key="eCA.EXTERNALAPPLICATION.label" bundle="${ca_labels}"/> </b></td>
        </tr>
		<tr onclick='chcol(this)'>
            <td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ExternalAppl')"><fmt:message key="eCA.ApplicationSetup.label" bundle="${ca_labels}"/></td>
        </tr>
		<tr onclick='chcol(this)'>
            <td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ExternalApplDtl')"><fmt:message key="eCA.ApplicationDetail.label" bundle="${ca_labels}"/></td>
        </tr>
	 	<%} %> 
<!--         <tr onclick='chcol(this)'>
            <td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PATSEARCH') ">PatSearch</td>
        </tr>
		<tr>
 -->            <td class='ECMENUHIGHERLEVELCOLOR' ><a href=javascript:goHomePage() style='color:white;'><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td>

    </table>

    </body>
    </form>
</html>

