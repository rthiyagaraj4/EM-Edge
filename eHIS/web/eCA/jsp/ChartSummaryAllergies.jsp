<!DOCTYPE html>
<% 
/* 
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History 		   Name        	 	   rev date		rev Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
21/11/2012		IN035950		Nijitha			CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
												more appealing. Keeping the display of information more clear and visible.
07/01/2014      	07012014		Nijitha			Changes suggested by sunil.		
24/07/2014		IN050271		Chowminya		generic name issue - PAS related changes 							
13/02/2018		IN066665		Kamalakannan G		13/02/2018		Ramesh G		other allergen column added  
-------------------------------------------------------------------------------------------------
Date      	 Edit History      Name        	Rev.Date	Rev.Name	Description
-------------------------------------------------------------------------------------------------
28/06/2018	IN065341	Prakash C	29/06/2018	Ramesh G	MMS-DM-CRF-0115
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//[IN035950] Starts
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<%
String prefStyleSheet = request.getParameter("prefStyle");//Nijitha
String content_ID = request.getParameter("content_ID");
String title = request.getParameter("title");
String sessionStyle = "";
if(!"".equals(prefStyleSheet)){
 sessionStyle=prefStyleSheet;
}
/*else{
	sStyle=prefStyleSheet;
}*/
//[IN035950] Ends
%>
		<title><%=title%></title><!--[IN035950]-->
		<link rel='StyleSheet' href='../../eCommon/html/<%=sessionStyle%>' type='text/css'></link>
		
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%

	//String allergicitem="";
	String PatientId=request.getParameter("patient_id");
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
    String locale = (String) p.getProperty("LOCALE");
	//String facility_id	= (String)session.getAttribute("facility_id");//IN050271//commented for IN065341
	
	%>
<script>
function display_records(obj,PatientId,causative_code,adv_event_type_ind_code,adv_event_type_code,reaction_date1,status,error_status,onset_date)
{
	eval("document.forms[0].detail"+obj).innerHTML="<a href=\"javascript:display_records1('"+obj+"','"+PatientId+"','"+causative_code+"','"+adv_event_type_ind_code+"','"+adv_event_type_code+"','"+reaction_date1+"','"+status+"','"+error_status+"','"+onset_date+"')\"><font color='black' bgcolor='#FF9933'>-</font></a>";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH PatientId=\""+PatientId+"\"  adv_event_type_ind_code=\""+adv_event_type_ind_code+"\" adv_event_type_code=\""+adv_event_type_code+"\" causative_code=\""+causative_code+"\"	reaction_date1=\""+reaction_date1+"\"  cnt=\""+obj+"\" status=\""+status+"\" error_status=\""+error_status+"\" onset_date=\""+onset_date+"\" det='add' steps='5'/></root>"
	
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eCA/jsp/AdverseEventType.jsp",false)		   
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
		//alert(responseText);
	eval(responseText)
	scrollTitle();
}

function display_records1(obj,PatientId,causative_code,adv_event_type_ind_code,adv_event_type_code,reaction_date1,status,error_status,onset_date)
{
	//alert(obj+"....."+PatientIdcausative_code,adv_event_type_ind_code,adv_event_type_code,reaction_date1,status,error_status);
	document.getElementById("detail"+obj).innerHTML="<a href=\"javascript:display_records('"+obj+"','"+PatientId+"','"+causative_code+"','"+adv_event_type_ind_code+"','"+adv_event_type_code+"','"+reaction_date1+"','"+status+"','"+error_status+"','"+onset_date+"')\"><font color='black'>+</font></a>";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH PatientId=\""+PatientId+"\"  adv_event_type_ind_code=\""+adv_event_type_ind_code+"\" adv_event_type_code=\""+adv_event_type_code+"\" causative_code=\""+causative_code+"\"	reaction_date1=\""+reaction_date1+"\"  cnt=\""+obj+"\" det='sub' status=\""+status+"\" error_status=\""+error_status+"\" onset_date=\""+onset_date+"\" steps='5'/></root>"
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eCA/jsp/AdverseEventType.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)	
	eval(responseText)
	scrollTitle();
}
function callonload()
{
	var tot_allr=document.forms[0].rowcolor.value; 
//parent.frames[0].document.forms[0].all.third1.style.display='inline';
//	parent.frames[0].document.forms[0].all.third1.style.display='visible';

}	

function scrollTitle()	//function to make the heading of the table static
{
	var scrollXY = document.body.scrollTop;
	
	if(scrollXY == 0)
	{
		document.getElementById("divTitleTable").style.position = 'static';
		document.getElementById("divTitleTable").style.posTop  = 0;
	}
	else
	{
		document.getElementById("divTitleTable").style.position = 'relative';
		document.getElementById("divTitleTable").style.posTop  = scrollXY-2;
	}
}


function alignHeading()
{
	if(parent.parent.frmTest.document.getElementById("AllergyHeader")!=null)
	{
		parent.parent.frmTest.document.getElementById("AllergyHeader").width =	eval(document.getElementById("record").offsetWidth);
		for (j=0; j < document.getElementById("record").rows(0).cells.length; j++) 
		{
			var wid=eval(document.getElementById("record").rows(0).cells(j).offsetWidth);
			
			if(parent.parent.frmTest.document.getElementById("AllergyHeader").rows(0).cells(j) != null)
			{
				parent.parent.frmTest.document.getElementById("AllergyHeader").rows(0).cells(j).width=wid;
			}
		}
	}
		
}
</script>  
</head>

<%
		//String locale = (String)session.getAttribute("LOCALE");
		Connection con = ConnectionManager.getConnection(request);
		ResultSet rs = null;
		PreparedStatement stmt = null;
		String allergen1="",allergen="",adv_event_type="",Certainity="",onset_date="",status="",causative_code="",adv_event_type_ind_code="",adv_event_type_code="",severity_main="",classValue="",classValue1="",adv_event_dtl_srl_no="",reaction_date_prev="",reaction_date1="",causative_substance="",route_of_exposure="",severity_two="",adv_reac_code="",reac_desc="",diagnosis_code="",severity_code="",active_date="",cnt_recurring="",final_reac_code_val="",reaction_site="",onset_date_disply="",reaction_date1_disply="",others_reaction="",adv_event_type_code1="",error_status="",status1="" ,adv_event_type_ind_code1="",onset_date_disply1="",onset_date1="",status_pass="",causative_code1="";
		//IN065341 starts
		String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");
		String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
		String Encounter_Id="";
		String facility_id="";
		if(called_from.equals("CDR")){
		 Encounter_Id = request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");
		 facility_id = request.getParameter("facility_id1")==null?"":request.getParameter("facility_id1");
		}else{//IN065341 ends
		 Encounter_Id=request.getParameter("Encounter_Id");
		 facility_id= (String) session.getValue("facility_id");
		}//IN065341

		String calculated_onset_date_yn="";
		String img_disp_yn="";

		//String duration="",reac_desc_final="",adv_event_type_ind="";
	try 
	{
		//String PatientId=request.getParameter("PatientId");
		//if(PatientId ==null) PatientId="";
		//String Encounter_Id=request.getParameter("Encounter_Id");IN065341
		if(Encounter_Id==null) Encounter_Id="";
	%>
		<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onScroll='scrollTitle()'>
	 <form name = 'chk_val'>
	
	<table class='grid' width='100%'  ><!--id='record'-->
	<tr id="divTitleTable">
		<!-- <th width='3%'><div  id='head1'  class='columnHeadercenter' nowrap width='3%'>&nbsp;&nbsp;</div></th>
		<th width='15%'><div  id='head2' class='columnHeadercenter' nowrap width='24%'><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></div></th>
		<th width='15%'><div  id='head3' class='columnHeadercenter' nowrap width='25%'><fmt:message key="eMR.Allergen.label" bundle="${mr_labels}"/></div></th>
		<th width='15%'><div  id='head4' class='columnHeadercenter' nowrap width='25%'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></div></th>
		<th width='15%'><div  id='head5' class='columnHeadercenter' nowrap width='23%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></div></th> [IN035950] -->
		<!-- [IN035950] Starts -->
		<%if(sStyle.equals(prefStyleSheet) )
		{%>
		<th width='3%'><div  id='head1'  class='columnHeadercenter' nowrap width='3%'>&nbsp;&nbsp;</div></th>
		<th width='15%'><div  id='head2' class='columnHeadercenter' nowrap width='24%'><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></div></th>
		<th width='15%'><div  id='head3' class='columnHeadercenter' nowrap width='25%'><fmt:message key="eMR.Allergen.label" bundle="${mr_labels}"/></div></th>
		<th width='15%'><div  id='head4' class='columnHeadercenter' nowrap width='25%'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></div></th>
		<th width='15%'><div  id='head5' class='columnHeadercenter' nowrap width='23%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></div></th>
		<%}else{ %>	
		<td width='3%' class='columnHeadercentericons<%=content_ID%>'><div  id='head1'   nowrap width='3%'>&nbsp;&nbsp;</div></th>
		<td width='15%' class='columnHeadercentericons<%=content_ID%>'><div  id='head2' nowrap width='24%'><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></div></th>
		<td width='15%' class='columnHeadercentericons<%=content_ID%>'><div  id='head3' nowrap width='25%'><fmt:message key="eMR.Allergen.label" bundle="${mr_labels}"/></div></th>
		<td width='15%' class='columnHeadercentericons<%=content_ID%>'><div  id='head4' nowrap width='25%'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></div></th>
		<td width='15%' class='columnHeadercentericons<%=content_ID%>'><div  id='head5' nowrap width='23%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></div></th>
		<%}%>
		<!-- [IN035950] Ends -->
	</tr>

	<%
		//stmt=con.createStatement();
		int rowcolor=0,m=0;
		//IN050271  - Start 
		//the below sql is modified to get the generic desc from mr_allergen_lang_vw/ph_generic_name_lang_vw based on the PH installation 
		String sPhInstalled_YN = "N";
		//String sql_chk = "SELECT operational_yn FROM sm_modules_facility WHERE module_id= 'PH'  AND facility_id = ?";
		String sql_chk = "SELECT operational_yn FROM sm_modules_facility ##REPDB## WHERE module_id= 'PH'  AND facility_id = ?";//IN065341
		sql_chk=sql_chk.replaceAll("##REPDB##", RepDb);//IN065341
		stmt=con.prepareStatement(sql_chk);
		stmt.setString(1,facility_id);
		rs = stmt.executeQuery();
		if(rs !=null)
		{
			while(rs.next())
			{
				if(!(rs.getString( "operational_yn" ) == null || "null".equals(rs.getString( "operational_yn" )) || "".equals(rs.getString( "operational_yn" ))))
					sPhInstalled_YN = rs.getString( "operational_yn" )  ;
			}
		}	
		String sAllergen ="";
		if("Y".equals(sPhInstalled_YN))
			//sAllergen = "(DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id='"+locale+"'),(SELECT long_desc FROM mr_allergen_lang_vw  WHERE allergen_code = a.allergen_code AND language_id='"+locale+"'))) ";
			sAllergen = "(DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw ##REPDB## WHERE generic_id = a.allergen_code AND language_id='"+locale+"'),(SELECT long_desc FROM mr_allergen_lang_vw ##REPDB## WHERE allergen_code = a.allergen_code AND language_id='"+locale+"'))) ";//IN065341
		else
			//sAllergen = "(SELECT long_desc FROM mr_allergen_lang_vw  WHERE allergen_code = a.allergen_code AND language_id='"+locale+"') ";
			sAllergen = "(SELECT long_desc FROM mr_allergen_lang_vw ##REPDB## WHERE allergen_code = a.allergen_code AND language_id='"+locale+"') ";//IN065341
						  
		//String sql="SELECT (SELECT count(*) from pr_allergy_sensitivity  where patient_id=a.patient_id  AND ADV_EVENT_TYPE_IND=a.adv_event_type_ind AND ADV_EVENT_TYPE=a.adv_event_type  AND ALLERGEN_CODE=a.allergen_code  and status NOT LIKE 'A' )COUNT, f.adv_reac_code, f.adv_event_srl_no, f.adv_event_dtl_srl_no, f.adv_event_rxn_srl_no, g.long_desc reac_desc,TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,a.patient_id, a.severity severity1,a.severity severity_code, a.adv_event_type_ind, a.adv_event_type,a.allergen_code,   NVL((SELECT long_desc FROM mr_allergen_lang_vw  WHERE allergen_code = a.allergen_code and language_id=? ),(SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code and language_id=? ))  allergen,c.adv_event_type_ind_desc, d.long_desc adv_event_type_desc,a.certainty certainty,a.status status,TO_CHAR (a.onset_date, 'dd/mm/yyyy hh24:mi:ss') onset_date, DECODE (e.adv_event_type,'DA', (SELECT drug_desc FROM ph_drug WHERE drug_code = e.drug_code),   e.causative_substance) causative_substance, e.route_of_exposure route_of_exposure,f.severity severity_two,e.adv_event_dtl_srl_no, a.diagnosis_code ,TO_CHAR (a.ACTIVE_DATE ,'dd/mm/yyyy') active_date ,a.REACTION_CODE_VALUES,f.REACTION_SITE , f.OTHERS_REACTION ,CALCULATED_ONSET_DATE_YN,f.status error_status FROM pr_allergy_sensitivity a,mr_adv_event_type_ind_lang_vw c,mr_adv_event_type_lang_vw d,pr_adverse_event e,   pr_adverse_event_reaction f,am_reaction_lang_vw g WHERE a.patient_id = ? AND  a.status='A'   AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND c.language_id=? and a.adv_event_type = d.adv_event_type_code AND d.language_id=?  AND f.adv_reac_code = g.reaction_code (+) and g.language_id(+)=? ORDER BY a.onset_date, a.ADV_EVENT_TYPE_IND, a.allergen_code,  f.reaction_date";	
		//String sql="SELECT (SELECT count(*) from pr_allergy_sensitivity  where patient_id=a.patient_id  AND ADV_EVENT_TYPE_IND=a.adv_event_type_ind AND ADV_EVENT_TYPE=a.adv_event_type  AND ALLERGEN_CODE=a.allergen_code  and status NOT LIKE 'A' )COUNT, f.adv_reac_code, f.adv_event_srl_no, f.adv_event_dtl_srl_no, f.adv_event_rxn_srl_no, g.long_desc reac_desc,TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,a.patient_id, a.severity severity1,a.severity severity_code, a.adv_event_type_ind, a.adv_event_type,a.allergen_code,CASE WHEN a.allergen_code IS NOT NULL THEN "+sAllergen+"  END  allergen,a.OTHER_ALLERGEN,c.adv_event_type_ind_desc, d.long_desc adv_event_type_desc,a.certainty certainty,a.status status,TO_CHAR (a.onset_date, 'dd/mm/yyyy hh24:mi:ss') onset_date, DECODE (e.adv_event_type,'DA', (SELECT drug_desc FROM ph_drug WHERE drug_code = e.drug_code),   e.causative_substance) causative_substance, e.route_of_exposure route_of_exposure,f.severity severity_two,e.adv_event_dtl_srl_no, a.diagnosis_code ,TO_CHAR (a.ACTIVE_DATE ,'dd/mm/yyyy') active_date ,a.REACTION_CODE_VALUES,f.REACTION_SITE , f.OTHERS_REACTION ,CALCULATED_ONSET_DATE_YN,f.status error_status FROM pr_allergy_sensitivity a,mr_adv_event_type_ind_lang_vw c,mr_adv_event_type_lang_vw d,pr_adverse_event e,   pr_adverse_event_reaction f,am_reaction_lang_vw g WHERE a.patient_id = ? AND  a.status='A'   AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND c.language_id=? and a.adv_event_type = d.adv_event_type_code AND d.language_id=?  AND f.adv_reac_code = g.reaction_code (+) and g.language_id(+)=? ORDER BY a.onset_date, a.ADV_EVENT_TYPE_IND, a.allergen_code,  f.reaction_date";//IN66665 a.OTHER_ALLERGEN added
		String sql="SELECT (SELECT count(*) from pr_allergy_sensitivity ##REPDB## where patient_id=a.patient_id  AND ADV_EVENT_TYPE_IND=a.adv_event_type_ind AND ADV_EVENT_TYPE=a.adv_event_type  AND ALLERGEN_CODE=a.allergen_code  and status NOT LIKE 'A' )COUNT, f.adv_reac_code, f.adv_event_srl_no, f.adv_event_dtl_srl_no, f.adv_event_rxn_srl_no, g.long_desc reac_desc,TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,a.patient_id, a.severity severity1,a.severity severity_code, a.adv_event_type_ind, a.adv_event_type,a.allergen_code,CASE WHEN a.allergen_code IS NOT NULL THEN "+sAllergen+"  END  allergen,a.OTHER_ALLERGEN,c.adv_event_type_ind_desc, d.long_desc adv_event_type_desc,a.certainty certainty,a.status status,TO_CHAR (a.onset_date, 'dd/mm/yyyy hh24:mi:ss') onset_date, DECODE (e.adv_event_type,'DA', (SELECT drug_desc FROM ph_drug ##REPDB## WHERE drug_code = e.drug_code),   e.causative_substance) causative_substance, e.route_of_exposure route_of_exposure,f.severity severity_two,e.adv_event_dtl_srl_no, a.diagnosis_code ,TO_CHAR (a.ACTIVE_DATE ,'dd/mm/yyyy') active_date ,a.REACTION_CODE_VALUES,f.REACTION_SITE , f.OTHERS_REACTION ,CALCULATED_ONSET_DATE_YN,f.status error_status FROM pr_allergy_sensitivity ##REPDB## a,mr_adv_event_type_ind_lang_vw ##REPDB## c,mr_adv_event_type_lang_vw ##REPDB## d,pr_adverse_event ##REPDB## e,   pr_adverse_event_reaction ##REPDB## f,am_reaction_lang_vw ##REPDB## g WHERE a.patient_id = ? AND  a.status='A'   AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND c.language_id=? and a.adv_event_type = d.adv_event_type_code AND d.language_id=?  AND f.adv_reac_code = g.reaction_code (+) and g.language_id(+)=? ORDER BY a.onset_date, a.ADV_EVENT_TYPE_IND, a.allergen_code, a.other_allergen,  f.reaction_date";//IN065341
		
		//IN050271 - End
		sql=sql.replaceAll("##REPDB##", RepDb);//IN065341
		stmt=con.prepareStatement(sql);
		/*stmt.setString(1,locale);
		stmt.setString(2,locale);*/ //IN050271 commented
		stmt.setString(1,PatientId);
		stmt.setString(2,locale);
		stmt.setString(3,locale);
		stmt.setString(4,locale);
		rs = stmt.executeQuery();

		if(rs !=null)
		{%>
			<%while(rs.next())
			  {

					causative_code=rs.getString("allergen_code");
					adv_event_type_ind_code=rs.getString("ADV_EVENT_TYPE_IND");

					adv_event_type_code=rs.getString("ADV_EVENT_TYPE");
					//allergen=rs.getString("allergen");//commented for IN066665
					allergen = (rs.getString("allergen")==""||rs.getString("allergen")==null)?rs.getString("OTHER_ALLERGEN"):rs.getString("allergen");////added for IN066665
					if(allergen==null) allergen=""; //IN050271
					adv_event_type=rs.getString("adv_event_type_desc");
					Certainity=rs.getString("CERTAINTY");
					onset_date=rs.getString("ONSET_DATE");
					if(onset_date ==null) onset_date="";
					status=rs.getString("STATUS");
					severity_main=rs.getString("severity1");
					if(severity_main==null) severity_main="";
					adv_event_dtl_srl_no=rs.getString("adv_event_dtl_srl_no");
					if(adv_event_dtl_srl_no ==null) adv_event_dtl_srl_no="";
					causative_substance=rs.getString("causative_substance");
					if(causative_substance ==null) causative_substance="";
					route_of_exposure=rs.getString("route_of_exposure");
					if(route_of_exposure ==null) route_of_exposure="";
					severity_two=rs.getString("severity_two");
					if(severity_two ==null) severity_two="&nbsp;";
					adv_reac_code=rs.getString("adv_reac_code");
					if(adv_reac_code ==null) adv_reac_code="";
					reaction_date1 =rs.getString("reaction_date");
					if(reaction_date1 ==null) reaction_date1="";
					reac_desc=rs.getString("reac_desc");

					if(reac_desc ==null) reac_desc="&nbsp;";
					severity_code=rs.getString("severity_code");
					if(severity_code ==null)severity_code="";
					diagnosis_code=rs.getString("diagnosis_code");
					if(diagnosis_code==null)diagnosis_code="";
					active_date=rs.getString("active_date");
					if(active_date ==null) active_date="";
					final_reac_code_val=rs.getString("REACTION_CODE_VALUES");
					if(final_reac_code_val ==null || final_reac_code_val.equals("THR")) final_reac_code_val="";
					reaction_site=rs.getString("reaction_site");
					if(reaction_site ==null) reaction_site="&nbsp;";
					
					others_reaction=rs.getString("OTHERS_REACTION");
					if(others_reaction ==null) others_reaction="&nbsp;";

					calculated_onset_date_yn = rs.getString("CALCULATED_ONSET_DATE_YN");
					if(calculated_onset_date_yn ==null) calculated_onset_date_yn="&nbsp;";
					
					error_status = rs.getString("error_status") == null ?"A":rs.getString("error_status");

					if(calculated_onset_date_yn.equals("Y"))
					{
						img_disp_yn = "display:visible";
					}
					else
					{
						img_disp_yn = "display:none";
					}

					cnt_recurring=rs.getString("COUNT");
					if(adv_event_type_ind_code.equals("01"))
					{
						classValue1="MRALLERGY";
					}else if(adv_event_type_ind_code.equals("02"))
					{
						classValue1="MRHYPERII";
					}else if(adv_event_type_ind_code.equals("03"))
					{
						classValue1="MRHEADER";
					}else if(adv_event_type_ind_code.equals("04"))
					{
						classValue1="ORBROWN";
					}


					
					if(severity_main.equals("U"))
					{
					severity_main =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
					}else if(severity_main.equals("M"))
					{
					severity_main =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mild.label","common_labels");
					}else if(severity_main.equals("O"))
					{
					severity_main =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Moderate.label","common_labels");
					}else if(severity_main.equals("S"))
					{
					severity_main =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severe.label","common_labels");
					}


					if(Certainity.equals("D"))
					{
					Certainity =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Definitive.label","common_labels");
					}else if(Certainity.equals("P"))
					{
					Certainity =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Probable.label","common_labels");
					}

					status_pass = status;

					if(status.equals("A"))
					{
					status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
					}
						
				
					if(route_of_exposure.equals("1"))
					{
					route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Probable.label","common_labels");
					}else if(route_of_exposure.equals("2"))
					{
					route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Inhalation.label","mr_labels");
					}else if(route_of_exposure.equals("3"))
					{
					route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Injection.label","mr_labels");
					}else if(route_of_exposure.equals("4"))
					{
					route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Tropical.label","mr_labels");
					}
					

					if(severity_two.equals("U"))
					{
					severity_two =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
					}else if(severity_two.equals("M"))
					{
					severity_two =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mild.label","common_labels");
					}else if(severity_two.equals("O"))
					{
					severity_two =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Moderate.label","common_labels");
					}else if(severity_two.equals("S"))
					{
					severity_two =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severe.label","common_labels");
					}

					onset_date_disply=DateUtils.convertDate(onset_date,"DMYHMS","en",locale);
					reaction_date1_disply=DateUtils.convertDate(reaction_date1,"DMYHM","en",locale);

				if((!adv_event_type_code.equals(adv_event_type_code1) || !allergen.equals(allergen1)|| !causative_code.equals(causative_code1)|| !status.equals(status1)|| !adv_event_type_ind_code.equals(adv_event_type_ind_code1)|| !onset_date_disply.equals(onset_date_disply1)))
				{
					if (classValue.equals("QRYODDSMALL"))
						classValue = "QRYEVENSMALL";
					else
						classValue = "QRYODDSMALL";
					
		%>
			<tr id='first' >

			<td  class='<%=classValue1%>' nowrap id='detail<%=m%>'><a href="javascript:onclick=display_records1('<%=m%>','<%=PatientId%>','<%=causative_code%>','<%=adv_event_type_ind_code%>','<%=adv_event_type_code%>','<%=reaction_date1%>','<%=status_pass%>','<%=error_status%>','<%=onset_date%>')">&nbsp;-&nbsp;</a>
			</td>
			<td  class='gridData' nowrap ><%=adv_event_type%></td>
			<td   class='gridData' nowrap id='header'>
			<%=allergen%>
			</td>
			<td  class='gridData' nowrap ><%=onset_date_disply%><img src='../../eCA/images/mc_history.gif' BORDER='0' style='<%=img_disp_yn%>'> </td>
			  
		
			<%if(cnt_recurring.equals("0")||causative_code.equals("Oth")){//IN66665%>
			<td  class='gridData' nowrap ><%=status%></td>
				<%}else {%>
				<td  class='gridData' nowrap ><%=status%>(<%=cnt_recurring%>)<img src='../../eCommon/images/mandatory.gif' ></img></td>
				<%}%>
				</tr>
			<tr id='third<%=m%>' Style="display;visibility:visible">
			<td  class='gridData' nowrap >&nbsp;</td>
			<td class='gridData'  nowrap><b><fmt:message key="Common.ReactionDate.label" bundle="${common_labels}"/></b></th>
			<td class='gridData'  nowrap><b><fmt:message key="eMR.reactiondesc.label" bundle="${mr_labels}"/></b></th>
			<td class='gridData'  nowrap><b><fmt:message key="Common.Severity.label" bundle="${common_labels}"/></b></th>
			<td class='gridData'  nowrap><b><fmt:message key="eMR.SiteOfReaction.label" bundle="${mr_labels}"/></b></th>
	
			
			
			</tr>
			<%if(!error_status.equals("E")){%>
			<tr id='second<%=m%>' Style="display;visibility:visible" >
			<td  class='gridData' nowrap >&nbsp;</td>
			<td  class='gridData' nowrap ><%=reaction_date1_disply%></td>
			

			<% if(adv_reac_code.equals("Oth")) 
			{ %>
			<td  class='gridData' nowrap ><%=others_reaction%></td>
			<%} else { %>
			<td  class='gridData' nowrap ><%=reac_desc%></td>
			<%}%>
			<td  class='gridData' nowrap ><%=severity_two%></td>
			<td  class='gridData' nowrap ><%=reaction_site%></td>
			
			
			</tr>			
			<%}
			}else{if(!error_status.equals("E")){%>
			<tr id='third<%=m%>' Style="display:none;visibility:hidden" >
			<td  class='gridData' nowrap >&nbsp;</td>
			<td class='gridData' align=center nowrap><fmt:message key="Common.ReactionDate.label" bundle="${common_labels}"/></td>
			<td class='gridData' align=center nowrap ><fmt:message key="eMR.reactiondesc.label" bundle="${mr_labels}"/></td>
			<td class='gridData' align=center nowrap ><fmt:message key="Common.Severity.label" bundle="${common_labels}"/></td>
			<td class='gridData' align=center nowrap><fmt:message key="eMR.SiteOfReaction.label" bundle="${mr_labels}"/></td>
			
			
			</tr>
		<tr id='second<%=m%>' Style="display;visibility:visible" >
			<td  class='gridData' nowrap >&nbsp;</td>
			<td  class='gridData' nowrap ><%=reaction_date1_disply%></td>
			
			<% if(adv_reac_code.equals("Oth")) 
			{ %>
			<td  class='gridData' nowrap ><%=others_reaction%></td>
			<%} else { %>
			<td  class='gridData' nowrap ><%=reac_desc%></td>
			<%}%>
			<td  class='gridData' nowrap ><%=severity_two%></td>
			<td  class='gridData' nowrap ><%=reaction_site%></td>
			
			
			</tr>
							
				<%
			}
				}
				%>
					
				<%	
				allergen1= (rs.getString("allergen")==""||rs.getString("allergen")==null)?rs.getString("OTHER_ALLERGEN"):rs.getString("allergen");
				causative_code1=rs.getString("allergen_code");
				reaction_date_prev =rs.getString("reaction_date");
				adv_event_type_code1=rs.getString("ADV_EVENT_TYPE");

				adv_event_type_ind_code1 = rs.getString("adv_event_type_ind");
					onset_date1 = rs.getString("onset_date");
					onset_date_disply1=DateUtils.convertDate(onset_date1,"DMYHMS","en",locale);
					status1 = rs.getString("status");
					
					if(status1.equals("A")){
						status1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
					}
					else if(status1.equals("R")){
						status1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Resolved.label","common_labels");
					}else if(status1.equals("E")){
						status1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");
					}
				
				
				rowcolor ++;
				m++;
			
			}
			//Changes suggested by sunil Starts [07012014]
			if(m==0)
			{
				//out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NODATAFOUND.label","ca_labels")+"</td></tr>");
		
				String known_allergy_yn = "";
				//sql = "select KNOWN_ALLERGY_YN from mp_patient where patient_id = ?";
				
				sql = "select KNOWN_ALLERGY_YN from mp_patient ##REPDB## where patient_id = ?";//IN065341
				sql=sql.replaceAll("##REPDB##", RepDb);//IN065341
				stmt=con.prepareStatement(sql);
				stmt.setString(1,PatientId);
				rs = stmt.executeQuery();
				while(rs.next())
				{
					known_allergy_yn = rs.getString("KNOWN_ALLERGY_YN")==null?"U":rs.getString("KNOWN_ALLERGY_YN");
				}
				
				if("N".equals(known_allergy_yn))
				{
					out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NOKNOWNALLERGY.label","ca_labels")+"</td></tr>");
				}
				else if("U".equals(known_allergy_yn))
				{
					out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NODATAFOUND.label","ca_labels")+"</td></tr>");
				}			
			}
			//Changes suggested by sunil Ends [07012014]	
			%>
			<!--<tr style='visibility:hidden'>
		<td width=''>&nbsp;&nbsp;</td>
		<td width=''><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td>
		<td width=''><fmt:message key="eMR.Allergen.label" bundle="${mr_labels}"/></td>
		<td width=''><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></td>
		<td width=''><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
	</tr>-->
			</table>
					<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>
		<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center'>
			<tr><td width='100%' id='t'></td></tr>
		</table>
	</div><%
		}
	

	%>

	<input type="hidden" name="detail" id="detail" value="" >
	<input type="hidden" name="rowcolor" id="rowcolor" value="<%=rowcolor%>" >
	<input type="hidden" name="cnt" id="cnt" value="" >
	<input type="hidden" name="flag1" id="flag1" VALUE="">

	<input type="hidden" name="PatientId" id="PatientId" value="<%=PatientId%>" >
	<input type="hidden" name="Encounter_Id" id="Encounter_Id" value="<%=Encounter_Id%>" >
<!--<script>
	if(parent.parent.frmTest.document.getElementById("AllergyHeader")==null)
	{
		setTimeout("alignHeading();",300);
	}
	else 
		alignHeading();
</script>-->
  </form>
</body>
	 <%
     } catch(Exception e) {
         if (rs != null) rs.close();
         if (stmt != null) stmt.close();
		 e.printStackTrace();
    }
     finally {
         if (rs != null) rs.close();
         if (stmt != null) stmt.close();
		 ConnectionManager.returnConnection(con,request);
     }
%>
	<script>
	function 	display_header(patient_id,adv_event_type_ind_code,adv_event_type_code,causative_code,adv_event_dtl_srl_no)
	 {
	 	 
		 /*alert("patient_id==="+patient_id)
		 alert("adv_event_type_ind_code==="+adv_event_type_ind_code)
		 alert("adv_event_type_code==="+adv_event_type_code)
		 alert("causative_code==="+causative_code)
		 alert("adv_event_dtl_srl_no==="+adv_event_dtl_srl_no)*/
	
                     
	parent.PatAlertQueryResult.location.href='PatAlertQueryResult.jsp?patient_id='+patient_id+'&call_from=allergy&ADV_EVENT_TYPE_IND='+adv_event_type_ind_code+'&ADV_EVENT_TYPE='+adv_event_type_code+'&ALLERGEN_CODE='+causative_code+'&ADV_EVENT_SRL_NO='+adv_event_dtl_srl_no; 
							
	
							
							
	 }
	</script>
</html>
	 


