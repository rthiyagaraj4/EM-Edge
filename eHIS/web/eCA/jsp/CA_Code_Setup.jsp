<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
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

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language=JavaScript src="../../eCommon/js/menu.js"></script>
	<script language='javascript' src='../../eCommon/js/common.js'> </script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<style>
		A:active{ 
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
	
			  if(val == 'NoteType'){
				parent.frames[1].location.href = '../../eCA/jsp/NoteType.jsp?module_id=CA&function_id=NoteType&function_name='+encodeURIComponent(getLabel("Common.NoteType.label","Common"))+'&function_type=F&access=YYYNN';
			}
	/*		if(val == 'DefineHeader'){
				parent.frames[1].location.href = '../../eCA/jsp/DocRefFmtMain.jsp?module_id=CA&function_id=DocRefFmt&function_name='+encodeURIComponent(getLabel("eCA.DefineHeader.label","CA"))+'&function_type=F&access=NYNNN';
			}  */
		  if(val == 'PrintHeaderImageList'){
				parent.frames[1].location.href = '../../eCA/jsp/PrintHeaderImageList.jsp?module_id=CA&function_id=PrintHeaderImageList&function_name='+encodeURIComponent(getLabel("eCA.PrintHeaderImageList.label","CA"))+'&function_type=F&access=YYYNN';
			}
			
			if(val == 'NoteGroup'){
				parent.frames[1].location.href = '../../eCA/jsp/NoteGroup.jsp?module_id=CA&function_id=NoteGroup&function_name='+encodeURIComponent(getLabel("eCA.NoteGroup.label","CA"))+'&function_type=F&access=YYYNN';
			}

			if(val == 'NoteDisclaimer'){
				parent.frames[1].location.href = '../../eCA/jsp/NoteDisclaimer.jsp?module_id=CA&function_id=NoteDisclaimer&function_name='+encodeURIComponent(getLabel("eCA.NoteDisclaimer.label","CA"))+'&function_type=F&access=YYYNN';
			}

			if(val == 'SubSection'){
				parent.frames[1].location.href = '../../eCA/jsp/SubSection.jsp?module_id=CA&function_id=SUB_SECTION&function_name='+encodeURIComponent(getLabel("eCA.SubSectionforMainSection.label","CA"))+'&function_type=F&access=YYYNN';
			}			
			if(val == 'Section'){
				parent.frames[1].location.href = '../../eCA/jsp/Section.jsp?module_id=CA&function_id=SECTION&function_name='+encodeURIComponent(getLabel("Common.Section.label","COMMON"))+'&function_type=F&access=YYYNN';
			}

		   if (val == 'SectionforNoteType'){
			 parent.frames[1].location.href = 	parent.frames[1].location.href = '../../eCA/jsp/SectionForNoteType.jsp?module_id=CA&function_id=SectionforNoteType&function_name='+encodeURIComponent(getLabel("eCA.SectionforNoteType.label","CA"))+'&function_type=F&access=YYYNN';
				//NoteTypeSection.jsp,SectionForNoteType.jsp (access=YYYYN)
			}

		 /* if (val == 'SectionforNoteType'){
			 parent.frames[1].location.href = 	parent.frames[1].location.href = '../../eCA/jsp/NoteTypeSection.jsp?module_id=CA&function_id=SectionforNoteType&function_name=Section for Note Type&function_type=F&access=YYYYN';
				//NoteTypeSection.jsp,SectionForNoteType.jsp (access=YYYYN)
			}*/

			//This file links are created for better user interface
			/*	if(val == 'SectionforNoteType'){
				parent.frames[1].location.href = '../../eCA/jsp/SectionforNoteType.jsp?module_id=CA&function_id=SectionforNoteType&function_name=Section for Note Type&function_type=F&access=YYNNN';
				//NoteTypeSection.jsp,SectionForNoteType.jsp
			}*/

		  if(val == 'NoteTypebyService'){
				parent.frames[1].location.href = '../../eCA/jsp/NoteTypeByService.jsp?module_id=CA&function_id=NOTETYPEBYSERVICE&function_name='+encodeURIComponent(getLabel("eCA.NoteTypebyService.label","CA"))+'&function_type=F&access=YYNNN';
			}	
		  if(val == 'NoteTypeAccessRights'){
			  // This file is created for better user interface.
			//	parent.frames[1].location.href = '../../eCA/jsp/RespNoteType.jsp?module_id=CA&function_id=NOTETYPEFORRESP&function_name=Note Type For Responsibility&function_type=F&access=YYNNN';
			parent.frames[1].location.href = '../../eCA/jsp/NoteTypeForResp.jsp?module_id=CA&function_id=NOTETYPEFORRESP&function_name='+encodeURIComponent(getLabel("eCA.NoteTypeAccessRights.label","CA"))+'&function_type=F&access=YYNNN';

			
			}

		if(val == 'LocationforPract'){
				parent.frames[1].location.href = '../../eCA/jsp/LocationforPract.jsp?module_id=CA&function_id=LOCATIONFORPRACT&function_name='+encodeURIComponent(getLabel("eCA.LocationforPractitioner.label","CA"))+'&function_type=F&access=YNYYN';
		}
		if(val == 'TextBlock'){
				parent.frames[1].location.href = '../../eCA/jsp/TextBlock.jsp?module_id=CA&function_id=TEXTBLOCK&function_name='+encodeURIComponent(getLabel("Common.TextBlock.label","COMMON"))+'&function_type=F&access=YYYNN';
			}			

			
		if(val == 'SectionTemplate'){
				parent.frames[1].location.href = '../../eCA/jsp/SectionTemplateMain.jsp?module_id=CA&function_id=TEXTBLOCK&function_name='+encodeURIComponent(getLabel("eCA.SectionTemplate.label","CA"))+'&function_type=F&access=NNNNN';
			}
		if(val == 'SectionTemplateOutputForm'){
				parent.frames[1].location.href = '../../eCA/jsp/SecTempOutputFormMain.jsp?module_id=CA&function_id=TEXTBLOCK&function_name='+encodeURIComponent(getLabel("eCA.SectionTemplateOutputForm.label","CA"))+'&function_type=F&access=YYNNN';
			}			
		if(val == 'ParsingTemplate'){
				parent.frames[1].location.href = '../../eCA/jsp/CASectionTemplateParsingMain.jsp?module_id=CA&function_id=TEXTBLOCK&function_name='+encodeURIComponent(getLabel("eCA.RebuildSectionTemplate.label","CA"))+'&function_type=F&access=YNNNN';
			}
				
		if(val == 'SpecificDisSummary'){
			parent.frames[1].location.href = '../../eCA/jsp/SpecificDisSummary.jsp?module_id=CA&function_id=SPECIFIC_DIS_SUMMARY&function_name=Specific Discharge Summary&function_type=F&access=YYYNN';
		}

	//added on 15th May 2004

		if(val == 'PatProfileContent'){
				parent.frames[1].location.href = '../../eCA/jsp/PatProfileContentMain.jsp?module_id=CA&function_id=PAT_PROFILE_CONTENT&function_name='+encodeURIComponent(getLabel("eCA.PatientProfileContent.label","CA"))+'&function_type=F&access=NYNNN';
		}

		if(val == 'FlowSheetComp'){
				parent.frames[1].location.href = '../../eCA/jsp/FlowSheetComponentMain.jsp?module_id=CA&function_id=FLOW_SHEET_COMP&function_name='+encodeURIComponent(getLabel("eCA.FlowSheetComponent.label","CA"))+'&function_type=F&access=YYYNN';
		}
		if(val == 'FlowSheetCompDetail'){
				parent.frames[1].location.href = '../../eCA/jsp/FlowSheetCompDetailMain.jsp?module_id=CA&function_id=FLOW_SHEET_COMP_DETAIL&function_name='+encodeURIComponent(getLabel("eCA.EventsFlowSheet.label","CA"))+'&function_type=F&access=YYNNN';
		}
		if(val == 'FlowSheetApplicability'){
				parent.frames[1].location.href = '../../eCA/jsp/FlowSheetApplicability.jsp?module_id=CA&function_id=FLOWSHEET_APPLICABILITY&function_name='+encodeURIComponent(getLabel("eCA.FlowSheetApplicability.label","CA"))+'&function_type=F&access=YYYYN';
		}
		
		if(val == 'ChartSetup'){
				parent.frames[1].location.href = '../../eCA/jsp/ChartSetup.jsp?module_id=CA&function_id=CHARTSETUP&function_name='+encodeURIComponent(getLabel("eCA.ChartSetup.label","CA"))+'&function_type=F&access=YYYNN';
		}
		if(val == 'ChartApplicability'){
				parent.frames[1].location.href = '../../eCA/jsp/ChartApplicability.jsp?module_id=CA&function_id=CHART_APPLICABILITY&function_name='+encodeURIComponent(getLabel("eCA.ChartApplicability.label","CA"))+'&function_type=F&access=YYYYN';
		}
		if(val == 'SectionsForChart'){
			parent.frames[1].location.href='../../eCA/jsp/SectionChart.jsp?module_id=CA&function_id=CHART_SECTION&function_name='+encodeURIComponent(getLabel("eCA.SectionsForChart.label","CA"))+'&function_type=F&access=YYNNN';
		}
		if(val == 'ChartComponents'){
			parent.frames[1].location.href='../../eCA/jsp/ChartComponent.jsp?module_id=CA&function_id=CHART_COMPONENTS&function_name='+encodeURIComponent(getLabel("eCA.ChartComponents.label","CA"))+'&function_type=F&access=YYNNN';
		}
		if(val == 'ChiefComplaint'){
				parent.frames[1].location.href = '../../eCA/jsp/ChiefComplaintMasterMain.jsp?module_id=CA&function_id=CA_CHIEF_COMPLAINT_MASTER&function_name='+encodeURIComponent(getLabel("Common.ChiefComplaint.label","COMMON"))+'&function_type=F&access=YYYNN';
		}
		if(val == 'ChiefComplaintSplty'){
				parent.frames[1].location.href = '../../eCA/jsp/ChiefComplaintSpltyMain.jsp?module_id=CA&function_id=CA_CHIEF_COMPLAINT_SPLTY&function_name='+encodeURIComponent(getLabel("eCA.DefineChiefComplaint.label","CA")+" "+getLabel("Common.speciality.label","Common"))+'&function_type=F&access=YYYNN';
		}

		if(val == 'ChiefComplaintDiag'){
				parent.frames[1].location.href = '../../eCA/jsp/ChiefComplaintDiagMain.jsp?module_id=CA&function_id=CA_CHIEF_COMPLAINT_DIAG&function_name='+encodeURIComponent(getLabel("eCA.DiagnosisforChiefComplaint.label","CA"))+'&function_type=F&access=YYNNN';
		}		

		if(val == 'ResearchPatientCategory'){
				parent.frames[1].location.href = '../../eCA/jsp/ResearchPatientMasterMain.jsp?module_id=CA&function_id=CA_RESEARCH_MASTER&function_name='+encodeURIComponent(getLabel("eCA.ResearchPatientCategory.label","CA"))+'&function_type=F&access=YYYNN';
		}				
		
		if(val == 'SplChartKey')
		{
			parent.frames[1].location.href = '../../eCA/jsp/SplChartKey.jsp?module_id=CA&function_id=SPLCHARTKEY&function_name='+encodeURIComponent(getLabel("eCA.SpecialChartKey.label","CA"))+'&function_type=F&access=YNNNN';
		}
		if(val == 'SplChartGraph'){
			parent.frames[1].location.href = '../../eCA/jsp/SplChartGraph.jsp?module_id=CA&function_id=SPLCHARTGRAPH&function_name='+encodeURIComponent(getLabel("eCA.SpecialChartGraph.label","CA"))+'&function_type=F&access=YYYNN';
		}

		if(val == 'SplChartRef'){
			parent.frames[1].location.href = '../../eCA/jsp/SplChartRef.jsp?module_id=CA&function_id=SPLCHARTREF&function_name='+encodeURIComponent(getLabel("eCA.SpecialChartRef.label","CA"))+'&function_type=F&access=YNNNN';
		}
/*	 if(val == 'SkillSet'){
			parent.frames[1].location.href = '../../eCA/jsp/NMSkillSetMain.jsp?module_id=CA&function_id=SKILLSET&function_name=Skill Set&function_type=F&access=YYYYN';
		}
		if(val == 'IncidentType'){
			parent.frames[1].location.href = '../../eCA/jsp/IncidentTypeMain.jsp?module_id=CA&function_id=INCIDENTTYPE&function_name=Incident Type&function_type=F&access=YYYYN';
		}
		if(val == 'Incident'){
			parent.frames[1].location.href = '../../eCA/jsp/IncidentMain.jsp?module_id=CA&function_id=INCIDENT&function_name=Incident&function_type=F&access=YYYYN';
		}*/
		if(val == 'ImageForSection'){
			parent.frames[1].location.href = '../../eCA/jsp/ImageForSection.jsp?module_id=CA&function_id=IMAGEFORSECTION&function_name='+encodeURIComponent(getLabel("eCA.ImageForSection.label","CA"))+'&function_type=F&access=YYYYN';
		}
		if(val == 'NoteImageList'){
			parent.frames[1].location.href = '../../eCA/jsp/NoteImageList.jsp?module_id=CA&function_id=NOTEIMAGELIST&function_name='+encodeURIComponent(getLabel("eCA.NoteImageList.label","CA"))+'&function_type=F&access=YYYNN';
		}
		if(val == 'ConfigDispCrit')
		{
			parent.frames[1].location.href = '../../eCA/jsp/ConfigDispCritMain.jsp?module_id=CA&function_id=CONFIGDISPCRIT&function_name='+encodeURIComponent(getLabel("eCA.ConfigDispCrit.label","CA"))+'&function_type=F&access=YYNNN';
		}

	}
	
	
		/**/

/*

function openwinnowin(mID,funName,fileName,str)
{
	var W = 400 ;
	var H = 100 ;	

	r = ",resizable=1"
	s = ",width="+W+",height="+H;

	var windowW = W;
	var windowH = H;
	var windowX = Math.ceil( (window.screen.width  - windowW) / 2 );
	var windowY = Math.ceil( (window.screen.height - windowH) / 2 );
	
	splashWin = window.open('','HelpWindow','fullscreen=1,toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=no'+r+s)

	splashWin.resizeTo( Math.ceil( W )       , Math.ceil( H ) )
	splashWin.moveTo  ( Math.ceil( windowX ) , Math.ceil( windowY ) )

	splashWin.document.open("text/html", "replace");
	splashWin.document.write(str);
	splashWin.document.help_form.submit();
	splashWin.document.close();
	splashWin.focus();
	eval("HelpWindow"+"=splashWin")
}

*/

	function showFunctionality(){
		var retVal = new Array(); 

		var features	= 'dialogHeight:33; dialogWidth:15;dialogLeft:2;dialogTop:60;status=no;scroll=no;title=no;fullscreen=1';  
		var arguments	= '' ;  
		
		var vals = parent.parent.header.document.header_form.menu_values.value;
		MPMasterMenu_form.menu_values.value = vals;
 		
		arguments = vals

		//retVal = window.showModalDialog('change_functionality.jsp',arguments,features);
		
		retVal	= window.showModalDialog('change_functionality.jsp',arguments,features);


		if(retVal != null)
		{
			//alert(retVal)
			retVal = retVal.replace("location","parent.parent.frames[1].location")
			eval(retVal)
		}
	}

	</script>

	</head>

	<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()" style="background-color:dimgray;">
	<form name="MPMasterMenu_form" id="MPMasterMenu_form">
	<input type=hidden name='menu_values' id='menu_values'>
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>
		<tr>
            <td class='CAGROUP' ><b><fmt:message key="eCA.LOCATIONACCESS.label" bundle="${ca_labels}"/></b></td>
        </tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('LocationforPract')">
			<fmt:message key="eCA.LocationforPractitioner.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr>
            <td class='CAGROUP' ><b><fmt:message key="Common.ClinicalNote.label" bundle="${common_labels}"/></b></td>
        </tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('NoteGroup')"><fmt:message key="eCA.NoteGroup.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('NoteDisclaimer')"><fmt:message key="eCA.NoteDisclaimer.label" bundle="${ca_labels}"/></td>
		</tr>
		<!-- <tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DefineHeader')"><fmt:message key="eCA.DefineHeader.label" bundle="${ca_labels}"/></td>
		</tr> -->
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('NoteType')"><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Section')"><fmt:message key="Common.Section.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SubSection')"><fmt:message key="eCA.SubSectionforMainSection.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SectionforNoteType')"><fmt:message key="eCA.SectionforNoteType.label" bundle="${ca_labels}"/></td>
		</tr>
		<!-- <tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SectionforNoteTypeNEW')">Section for Note Type New</td>
		</tr> -->
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('NoteTypebyService')"><fmt:message key="eCA.NoteTypebyService.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('NoteTypeAccessRights')"><fmt:message key="eCA.NoteTypeAccessRights.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TextBlock')"><fmt:message key="Common.TextBlock.label" bundle="${common_labels}"/></td>
		</tr>
<!-- 		<tr onclick='chcol(this)'>			
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TemplateComponent')">Template Component</td>
		</tr>
 -->
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SectionTemplate')"><fmt:message key="eCA.SectionTemplate.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SectionTemplateOutputForm')"><fmt:message key="eCA.SectionTemplateOutputForm.label" bundle="${ca_labels}"/></td>
		</tr>
		
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ParsingTemplate')"><fmt:message key="eCA.RebuildSectionTemplate.label" bundle="${ca_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ChiefComplaint')"><fmt:message key="eCA.DefineChiefComplaint.label" bundle="${ca_labels}"/></td>
		</tr>
		<!-- <tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ChiefComplaintSplty')"><fmt:message key="eCA.DefineChiefComplaint.label" bundle="${ca_labels}"/> <fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td> 
		</tr> -->	
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ChiefComplaintDiag')"> <fmt:message key="eCA.DiagnosisforChiefComplaint.label" bundle="${ca_labels}"/></td>
		</tr>		
		<%
		if (license_rights.equals("FULL") )
		{%>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('NoteImageList')"><fmt:message key="eCA.NoteImageList.label" bundle="${ca_labels}"/></td>
		</tr>		
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ImageForSection')"><fmt:message key="eCA.ImageForSection.label" bundle="${ca_labels}"/> </td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ConfigDispCrit')"><fmt:message key="eCA.ConfigDispCrit.label" bundle="${ca_labels}"/> </td>
		</tr>	
		<%}%>
		<!-- <tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PrintHeaderImageList')"><fmt:message key="eCA.PrintHeaderImageList.label" bundle="${ca_labels}"/></td>
		</tr> -->	
		<tr>
            <td class='CAGROUP' ><b><fmt:message key="eCA.FlowSheet.label" bundle="${ca_labels}"/></b></td>
        </tr>
		<tr onclick='chcol(this)'>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('FlowSheetComp')"><fmt:message key="eCA.FlowSheetComponent.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('FlowSheetCompDetail')"><fmt:message key="eCA.EventsFlowSheet.label" bundle="${ca_labels}"/></td>
		</tr>	
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('FlowSheetApplicability')"><fmt:message key="eCA.FlowSheetApplicability.label" bundle="${ca_labels}"/></td>
		</tr>
		
		<tr>
            <td class='CAGROUP' ><b><fmt:message key="Common.CHARTING.label" bundle="${common_labels}"/></b></td>
        </tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ChartSetup')"><fmt:message key="eCA.ChartSetup.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ChartApplicability')"><fmt:message key="eCA.ChartApplicability.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SectionsForChart')"><fmt:message key="eCA.SectionsForChart.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ChartComponents')"><fmt:message key="eCA.ChartComponents.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SplChartKey')"><fmt:message key="eCA.SpecialChartKey.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SplChartGraph')"><fmt:message key="eCA.SpecialChartGraph.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SplChartRef')"><fmt:message key="eCA.SpecialChartRef.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr>
            <td class='CAGROUP' ><b><fmt:message key="Common.others.label" bundle="${common_labels}"/></b></td>
        </tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PatProfileContent')"><fmt:message key="eCA.PatientProfileContent.label" bundle="${ca_labels}"/></td>
		</tr>	
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ResearchPatientCategory')"><fmt:message key="eCA.ResearchPatientCategory.label" bundle="${ca_labels}"/></td>
		</tr>
<!-- 		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ICD10-PCS')">ICD10-PCS</td>
		</tr> -->
		
		<tr onclick='chcol(this)'>
		<tr>
			<td class='ECMENUHIGHERLEVELCOLOR' ><a href=javascript:goHomePage() style='color:white;'><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td>
		</tr>

		<!-- <tr>
			<td class='ECMENUHIGHERLEVELCOLOR' onClick="showFunctionality()"><b>Functions</b></td>
		</tr>
 -->

	</table>

	</body>
	</form>
</html>

