<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
	<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");

%>

    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		var temparr = new Array();
		var count = 0;
		var prev=0;
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
	
				if(val == 'MO_AREA')
					parent.frames[1].location.href = '../../eMO/jsp/MOArea.jsp?module_id=MO&function_id=MO_AREA&function_name='+getLabel("Common.area.label","Common")+'&function_type=F&access=YYYNN';

				if(val == 'MO_BED_AREA')
					parent.frames[1].location.href = '../../eMO/jsp/MOBedForArea.jsp?module_id=MO&function_id=MO_BED_AREA&function_name='+getLabel("eMO.LocationforArea.label","MO")+'&function_type=F&access=YYYNN';

				if(val == 'MO_BODY_CONDITION')
					parent.frames[1].location.href = '../../eMO/jsp/MOBodyCondition.jsp?module_id=MO&function_id=MO_BODY_CONDITION&function_name='+getLabel("eMO.BodyCondition.label","MO")+'&function_type=F&access=YYYNN';

				
				if(val == 'MO_MANNER_OF_DEATH')
					parent.frames[1].location.href = '../../eMO/jsp/MOMannerOfDeath.jsp?module_id=MO&function_id=MO_MANNER_OF_DEATH&function_name='+getLabel("eMO.MannerofDeath.label","MO")+'&function_type=F&access=YYYNN';

				if(val == 'MO_CLAIMANTS')
					parent.frames[1].location.href = '../../eMO/jsp/MOClaimants.jsp?module_id=MO&function_id=MO_CLAIMANTS&function_name='+getLabel("eMO.ClaimantType.label","MO")+'&function_type=F&access=YYYNN';

				if(val == 'MO_CONSENT_FORMS')
					parent.frames[1].location.href = '../../eMO/jsp/MOConsentForms.jsp?module_id=MO&function_id=MO_CONSENT_FORMS&function_name='+getLabel("eMO.ConsentFormType.label","MO")+'&function_type=F&access=YYYNN';
				
				if(val == 'MO_BODY_PART')
					parent.frames[1].location.href = '../../eMO/jsp/MOBodyPart.jsp?module_id=MO&function_id=MO_BODY_PART&function_name='+getLabel("Common.BodyPart.label","Common")+'&function_type=F&access=YYYNN';
                
				if(val == 'MO_ORGN_FOR_DONAT')
					parent.frames[1].location.href = '../../eMO/jsp/MOOrganForDonation.jsp?module_id=MO&function_id=MO_ORGN_FOR_DONAT&function_name='+getLabel("eMO.OrganforDonation.label","MO")+'&function_type=F&access=YYYNN';



	 	 }
 
	</script>

	</head>

	<body OnMouseDown='CodeArrest()' style="background-color:dimgray;" onKeyDown = 'lockKey()' >
	<form name="MPMasterMenu_form" id="MPMasterMenu_form">
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>
		
		<tr onclick='chcol(this)'>
		    <td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('MO_AREA');"><fmt:message key="Common.area.label" bundle="${common_labels}"/></td>
		</tr>
        <tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR'  onClick="javascript:callJSPs('MO_BED_AREA');"><fmt:message key="eMO.LocationforArea.label" bundle="${mo_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('MO_BODY_CONDITION');"><fmt:message key="eMO.BodyCondition.label" bundle="${mo_labels}"/></td>
		</tr>
		
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('MO_MANNER_OF_DEATH');"><fmt:message key="eMO.MannerofDeath.label" bundle="${mo_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('MO_CLAIMANTS');"><fmt:message key="eMO.ClaimantType.label" bundle="${mo_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('MO_CONSENT_FORMS');"><fmt:message key="eMO.ConsentFormType.label" bundle="${mo_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('MO_BODY_PART');"><fmt:message key="Common.BodyPart.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('MO_ORGN_FOR_DONAT');"><fmt:message key="eMO.OrganforDonation.label" bundle="${mo_labels}"/></td>
		</tr>
		
		<tr >
			<td class='ECMENUHIGHERLEVELCOLOR'><a href=javascript:goHomePage() style='color:white;'><fmt:message key="Common.menu.label" bundle="${common_labels}"/></a></td>
		</tr>
	</table>

	</body>
	</form>
</html>

