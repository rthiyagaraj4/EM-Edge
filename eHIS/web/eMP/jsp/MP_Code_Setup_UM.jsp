<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<html>
	<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String sql=	" Select pat_name_as_multipart_yn,ENTITLEMENT_BY_PAT_CAT_YN,FAMILY_ORG_ID_ACCEPT_YN,GEN_PID_USING_AID1_RULE_YN from mp_param";
	String pat_name_as_multipart_yn=""; 
	String ENTITLEMENT_BY_PAT_CAT_YN ="";
	String FAMILY_ORG_ID_ACCEPT_YN = "";
	String GEN_PID_USING_AID1_RULE_YN="";

	 Connection con	= null;
	 java.sql.Statement stmt	= null;
	 ResultSet rset	=null; 	
	try{
		con = ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

	 	rset = stmt.executeQuery(sql);	
 
		if(rset.next())
 		{
 		
		pat_name_as_multipart_yn=rset.getString("pat_name_as_multipart_yn");
		if(pat_name_as_multipart_yn == null || pat_name_as_multipart_yn.equals("null")) pat_name_as_multipart_yn="Y";
		
		ENTITLEMENT_BY_PAT_CAT_YN=rset.getString("ENTITLEMENT_BY_PAT_CAT_YN");
		if(ENTITLEMENT_BY_PAT_CAT_YN == null || ENTITLEMENT_BY_PAT_CAT_YN.equals("null")) ENTITLEMENT_BY_PAT_CAT_YN="N";

		FAMILY_ORG_ID_ACCEPT_YN=rset.getString("FAMILY_ORG_ID_ACCEPT_YN");
		if(FAMILY_ORG_ID_ACCEPT_YN == null || FAMILY_ORG_ID_ACCEPT_YN.equals("null")) FAMILY_ORG_ID_ACCEPT_YN="N";

		GEN_PID_USING_AID1_RULE_YN=rset.getString("GEN_PID_USING_AID1_RULE_YN");
		if(GEN_PID_USING_AID1_RULE_YN == null || GEN_PID_USING_AID1_RULE_YN.equals("null"))
		GEN_PID_USING_AID1_RULE_YN="N";
		
		}
	}catch(Exception e) {out.println(e.toString());}
	finally
	{
		if (rset != null) rset.close();
		if (stmt != null) stmt.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	%>

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
				document.getElementById('t').rows(prev).cells(0).className=prevcol;
				prevcol=ro.cells(0).className;
				ro.cells(0).className="MENUSELECTEDCOLOR";
				prev=ro.rowIndex;
		}

		function callJSPs(val)
		{
//			alert(encodeURIComponent(getLabel("Common.NamePrefix.label","common")));
			//alert(getLabel("Common.NamePrefix.label","common"));
			/*
					Access is in the order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess
			*/
			if(val == 'MaritalStatus')
				parent.frames[1].location.href = '../../servlet/eMP.MaritalStatusServlet?module_id=MP&function_id=MARITAL_STATUS&function_name='+encodeURIComponent(getLabel("eMP.maritalstatus.label","MP"))+'&function_type=F&access=YYYNN';
			if(val == 'Religion')
				parent.frames[1].location.href = '../../servlet/eMP.ReligionServlet?module_id=MP&function_id=RELIGION&function_name='+encodeURIComponent(getLabel("Common.religion.label","common"))+'&function_type=F&access=YYYNN';
			/*******************/
			if(val == 'EthnicGroup')
				parent.frames[1].location.href = '../../servlet/eMP.EthnicGroupServlet?module_id=MP&function_id=ETHNICGROUP&function_name='+encodeURIComponent(getLabel("Common.race.label","common"))+'&function_type=F&access=YYYNN';
			/****************/
			/*******************/
			if(val == 'EthnicSubGroup')
				parent.frames[1].location.href = '../../servlet/eMP.EthnicSubGroupServlet?module_id=MP&function_id=ETHNICSUBGROUP&function_name='+encodeURIComponent(getLabel("eMP.ethnicity.label","MP"))+'&function_type=F&access=YYYNN';
			/****************/

			if(val == 'OccupationClass')
				parent.frames[1].location.href = '../../servlet/eMP.OccupationClassServlet?module_id=MP&function_id=OCCUPATION_CLASS&function_name='+encodeURIComponent(getLabel("eMP.OccupationClass.label","MP"))+'&function_type=F&access=YYYNN';
			if(val == 'Occupation')
				parent.frames[1].location.href = '../../servlet/eMP.OccupationServlet?module_id=MP&function_id=OCCUPATION&function_name='+encodeURIComponent(getLabel("eMP.occupation.label","MP"))+'&function_type=F&access=YYYNN';
			if(val == 'Country')
				parent.frames[1].location.href = '../../servlet/eMP.CountryServlet?module_id=MP&function_id=COUNTRY&function_name='+encodeURIComponent(getLabel("Common.country.label","common"))+'&function_type=F&access=YYYNN';
			if(val == 'Region')
				parent.frames[1].location.href = '../../servlet/eMP.RegionServlet?module_id=MP&function_id=REGION&function_name='+encodeURIComponent(getLabel("eMP.region.label","MP"))+'&function_type=F&access=YYYNN';
			if(val == 'Area')
				parent.frames[1].location.href = '../../eMP/jsp/addResidenceArea.jsp?module_id=MP&function_id=AREA&function_name='+encodeURIComponent(getLabel("Common.area.label","common"))+'&function_type=F&access=YYYNN';
			if(val == 'Town')
				parent.frames[1].location.href = '../../eMP/jsp/addResidenceTown.jsp?module_id=MP&function_id=TOWN&function_name='+encodeURIComponent(getLabel("Common.Town.label","common"))+'&function_type=F&access=YYYNN';

			if(val == 'PostalCodes')
				parent.frames[1].location.href = '../../servlet/eMP.PostalServlet?module_id=MP&function_id=POSTALCODES&function_name='+encodeURIComponent(getLabel("eMP.postalcode.label","MP"))+'&function_type=F&access=YYYNN';

			if(val == 'Languages')
				parent.frames[1].location.href = '../../eMP/jsp/Language.jsp?module_id=MP&function_id=Language&function_name='+encodeURIComponent(getLabel("Common.patient.label","common"))+' '+encodeURIComponent(getLabel("Common.Language.label","Common"))+'&function_type=F&access=YYYNN';

			if(val == 'BirthPlace')
				parent.frames[1].location.href = '../../eMP/jsp/addBirthPlace.jsp?module_id=MP&function_id=Birth Place&function_name='+encodeURIComponent(getLabel("Common.birthPlace.label","common"))+'&function_type=F&access=YYYNN';

			if(val == 'NamePrefix')
				parent.frames[1].location.href = '../../servlet/eMP.NamePrefixServlet?module_id=MP&function_id=NAMEPREFIX&function_name='+encodeURIComponent(getLabel("Common.NamePrefix.label","common"))+'&function_type=F&access=YYYNN';
			if(val == 'NameSuffix')
				parent.frames[1].location.href = '../../servlet/eMP.NameSuffixServlet?module_id=MP&function_id=NAMESUFFIX&function_name='+encodeURIComponent(getLabel("Common.NameSuffix.label","common"))+'&function_type=F&access=YYYNN';
			if(val == 'AlternateIDType')
				parent.frames[1].location.href = '../../servlet/eMP.AlternateIDServlet?module_id=MP&function_id=ALTERNATEIDTYPE&function_name='+encodeURIComponent(getLabel("eMP.AlternateIDType.label","MP"))+'&function_type=F&access=YYYNN';
			if(val == 'DocumentType')
				parent.frames[1].location.href = '../../servlet/eMP.DocumentTypeServlet?module_id=MP&function_id=DOCUMENTTYPE&function_name='+encodeURIComponent(getLabel("Common.documenttype.label","common"))+'&function_type=F&access=YYYNN';
			if(val == 'PatientCategory')
				parent.frames[1].location.href = '../../servlet/eMP.PatientCatServlet?module_id=MP&function_id=PATCATEGORY&function_name='+encodeURIComponent(getLabel("Common.category.label","common"))+'&function_type=F&access=YYYNN';
			if(val == 'EntitlementPlan')
				parent.frames[1].location.href = '../../eMP/jsp/EntitlementPlanFrames.jsp?module_id=MP&function_id=ENTITLEMENT&function_name='+encodeURIComponent(getLabel("eMP.EntitlementPlan.label","MP"))+'&function_type=F&access=YYYNN';
			if(val == 'Relationship')
				parent.frames[1].location.href = '../../servlet/eMP.RelationshipServlet?module_id=MP&function_id=RELATIONSHIP&function_name='+encodeURIComponent(getLabel("Common.relationship.label","Common"))+'&function_type=F&access=YYYNN';

			if(val == 'RelationshipLevel')
			{
				var alertmessage=getMessage("FUNCTION_NOT_APPL","MP");
				var GEN_PID_USING_AID1_RULE_YN ="<%=GEN_PID_USING_AID1_RULE_YN%>";
				if(GEN_PID_USING_AID1_RULE_YN=="Y")
				{
				parent.frames[1].location.href = '../../eMP/jsp/RelationshipLevel.jsp?module_id=MP&function_id=RelationshipLevel&function_name='+encodeURIComponent(getLabel("eMP.RelationshipLevel.label","MP"))+'&function_type=F&access=YYNNN';
				}
				else
				{
					alert(alertmessage);
					parent.frames[1].location.href ='../../eCommon/html/blank.html'; 
				}
			}

			if(val == 'Organization')
				parent.frames[1].location.href = '../../eMP/jsp/OrganizationFrame1.jsp?module_id=MP&function_id=ORGANIZATION&function_name='+encodeURIComponent(getLabel("Common.Organization.label","Common"))+'&function_type=F&access=YYYNN';
			if(val == 'PatCatOrgMbsp')
				parent.frames[1].location.href = '../../eMP/jsp/PatCatOrgMbsp.jsp?module_id=MP&function_id=PatCatOrgMbsp&function_name='+encodeURIComponent(getLabel("eMP.PatCatbyOrg.Membership.label","MP"))+'&function_type=F&access=YYNNN';
			if(val == 'ReasonforSuspension')
				parent.frames[1].location.href = '../../servlet/eMP.PatientSuspensionServlet?module_id=MP&function_id=PATSUSPREASON&function_name='+encodeURIComponent(getLabel("eMP.ReasonforSuspension.label","MP"))+'&function_type=F&access=YYYNN';
			if(val == 'ReasonforActiveInactive')
				parent.frames[1].location.href = '../../servlet/eMP.ActiveInactiveServlet?module_id=MP&function_id=ACTINACTREASON&function_name='+encodeURIComponent(getLabel("eMP.ReasonforActiveInactive.label","MP"))+'&function_type=F&access=YYYNN';

			if(val == 'ContactModes')
				parent.frames[1].location.href = '../../servlet/eMP.ContactServlet?module_id=MP&function_id=CONTACTMODES&function_name='+encodeURIComponent(getLabel("eMP.ContactModes.label","MP"))+'&function_type=F&access=YYYNN';
			if(val == 'EducationLevel')
				parent.frames[1].location.href = '../../eMP/jsp/EducationLevel.jsp?module_id=MP&function_id=EDUCATION_LEVEL&function_name='+encodeURIComponent(getLabel("eMP.EducationLevel.label","MP"))+'&function_type=F&access=YYYNN';
			
			if(val == 'StandardFamilyName')
			{
				var alertmessage=getMessage("PAT_NAME_NOT_ALLOWED","MP");
				var pat_name_as_multipart_yn ="<%=pat_name_as_multipart_yn%>";
				if(pat_name_as_multipart_yn=="Y"){
				parent.frames[1].location.href = '../../eMP/jsp/StdFamilyName.jsp?module_id=MP&function_id=STD_FAMILY_NAME&function_name='+encodeURIComponent(getLabel("eMP.StandardFamilyName.label","MP"))+'&function_type=F&access=YYYNN';
				}
				else {
					alert(alertmessage);
					parent.frames[1].location.href ='../../eCommon/html/blank.html'; 
				}
			}
			if(val == 'StandardOtherName')
			{
				var alertmessage=getMessage("PAT_NAME_NOT_ALLOWED","MP");
				var pat_name_as_multipart_yn ="<%=pat_name_as_multipart_yn%>";
				if(pat_name_as_multipart_yn=="Y"){
				parent.frames[1].location.href = '../../eMP/jsp/StdOtherName.jsp?module_id=MP&function_id=STD_OTHER_NAME&function_name='+encodeURIComponent(getLabel("eMP.StandardOtherName.label","MP"))+'&function_type=F&access=YYYNN';
				}
				else{
					alert(alertmessage);
					parent.frames[1].location.href ='../../eCommon/html/blank.html'; 			
				}
			}

			if(val == 'CheckDigitScheme')
				parent.frames[1].location.href = '../../eMP/jsp/CheckDigitScheme.jsp?module_id=MP&function_id=CHECKDIGITSCHEME&function_name='+encodeURIComponent(getLabel("eMP.CheckDigitScheme.label","MP"))+'&function_type=F&access=YYYNN';
			if(val == 'ExternalReferralSource')
				parent.frames[1].location.href = '../../servlet/eAM.ReferralServlet?module_id=AM&function_id=REFERRAL&function_name='+encodeURIComponent(getLabel("eMP.ExternalReferralSource.label","MP"))+'&function_type=F&access=YYYNN';
			if(val == 'SummarizationRange')
				parent.frames[1].location.href = '../../servlet/eAM.AgeRangeServlet?module_id=AM&function_id=SUMM_RANGES&function_name='+encodeURIComponent(getLabel("eMP.SummarizationRange.label","MP"))+'&function_type=F&access=YYYNN';
				
		}

	</script>

	</head>

	<body style="background-color:dimgray;" onKeyDown = 'lockKey()'>
	<form name="MPMasterMenu_form" id="MPMasterMenu_form">
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>
		
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('MaritalStatus')"><fmt:message key="eMP.maritalstatus.label" bundle="${mp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Religion')"><fmt:message key="Common.religion.label" bundle="${common_labels}"/> </td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('EthnicGroup')"><fmt:message key="Common.race.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('EthnicSubGroup')"><fmt:message key="eMP.ethnicity.label" bundle="${mp_labels}"/> </td>
		</tr>
<!--		<tr></tr> -->
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('OccupationClass') "><fmt:message key="eMP.OccupationClass.label" bundle="${mp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Occupation') "><fmt:message key="eMP.occupation.label" bundle="${mp_labels}"/></td>
		</tr>
<!--		<tr></tr> -->
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Country') "><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Region')"><fmt:message key="eMP.region.label" bundle="${mp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Area')"><fmt:message key="Common.area.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Town')"><fmt:message key="Common.Town.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PostalCodes')"><fmt:message key="eMP.postalcode.label" bundle="${mp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('BirthPlace')"><fmt:message key="Common.birthPlace.label" bundle="${common_labels}"/></td>
		</tr>
		<!--<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Languages')"><fmt:message key="Common.patient.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Language.label" bundle="${common_labels}"/></td>
		</tr>
		<tr></tr> -->
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('NamePrefix') " ><fmt:message key="Common.NamePrefix.label" bundle="${common_labels}"/></td>
		</tr>
	<!--	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('StandardFamilyName')"><fmt:message key="eMP.StandardFamilyName.label" bundle="${mp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('StandardOtherName')"><fmt:message key="eMP.StandardOtherName.label" bundle="${mp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('NameSuffix')" ><fmt:message key="Common.NameSuffix.label" bundle="${common_labels}"/></td>
		</tr>
		<tr></tr> -->
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('AlternateIDType')"><fmt:message key="eMP.AlternateIDType.label" bundle="${mp_labels}"/></td>
		</tr>
		<!--<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DocumentType')"><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PatientCategory')"><fmt:message key="Common.category.label" bundle="${common_labels}"/></td>
		</tr>
<%if(ENTITLEMENT_BY_PAT_CAT_YN.equals("Y")){%>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('EntitlementPlan')"><fmt:message key="eMP.EntitlementPlan.label" bundle="${mp_labels}"/></td>
		</tr>
<%}%>  -->
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Relationship')" ><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
		</tr>
	<!--	<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('RelationshipLevel')"><fmt:message key="eMP.RelationshipLevel.label" bundle="${mp_labels}"/></td>
		</tr>
<%if(FAMILY_ORG_ID_ACCEPT_YN.equals("Y")){%>
		<tr></tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Organization')" ><fmt:message key="Common.Organization.label" bundle="${common_labels}"/></td>
		</tr>
<%if(ENTITLEMENT_BY_PAT_CAT_YN.equals("Y")){%>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PatCatOrgMbsp')" ><fmt:message key="eMP.PatCatbyOrg.Membership.label" bundle="${mp_labels}"/></td>
		</tr>
<%}
}%>
		<tr></tr> -->
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ContactModes')"><fmt:message key="eMP.ContactModes.label" bundle="${mp_labels}"/></td>
		</tr>
<!--		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="callJSPs('ReasonforSuspension')"><fmt:message key="eMP.ReasonforSuspension.label" bundle="${mp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ReasonforActiveInactive')"><fmt:message key="eMP.ReasonforActiveInactive.label" bundle="${mp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('CheckDigitScheme')"><fmt:message key="eMP.CheckDigitScheme.label" bundle="${mp_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('EducationLevel')"><fmt:message key="eMP.EducationLevel.label" bundle="${mp_labels}"/></td>
		</tr>
		<tr></tr> -->

		<tr onclick='chcol(this)'>
		<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ExternalReferralSource')"><fmt:message key="eMP.ExternalReferralSource.label" bundle="${mp_labels}"/></td>
		</tr>

<!--		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SummarizationRange')"><fmt:message key="eMP.SummarizationRange.label" bundle="${mp_labels}"/></td>
		</tr> -->
		<tr>
			<td class='ECMENUHIGHERLEVELCOLOR' ><a href=javascript:goHomePage() style='color:white;'><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td>
		</tr> 
</table>
</body>
</form>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

