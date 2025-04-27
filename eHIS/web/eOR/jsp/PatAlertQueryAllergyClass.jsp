<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="java.sql.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

 <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

      	<%
      	String patient_id= request.getParameter("patient_id");
      	String called_from_ip= request.getParameter("called_from_ip");
      	String radio_par= request.getParameter("radio_par");
			if(radio_par==null || radio_par.equals(""))
			  radio_par="A";
		//System.out.println("radio_par=============="+radio_par);
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
    	String locale = (String) p.getProperty("LOCALE");
			

      	%>
      	<script>
		var srl_no_array = new Array();
      	var prev1=0;
		var prev=1
      	var i=0;
      	function rfresh()
      	{
			alert();
		var remarks=document.forms[0].remarks.value;
		parent.PatAlertQueryResult.location.href="PatAlertQueryResult.jsp?&remarks="+remarks+"&call_from=allergy&srl_no="+srl_no_array[prev1]+"&patient_id=<%=patient_id%>";
      	
		}


      	function refer(ro,numofcols )
      	{	  alert();
				prev1	=ro.rowIndex
			for (var i=0;i<numofcols;i++)
			{
				document.getElementById("tb1").rows(prev).cells(i).style.backgroundColor=ro.bgColor
			}

			for (var i=0;i<numofcols;i++)
				ro.cells(i).style.backgroundColor="#B2B6D7"

			prev	=ro.rowIndex
      	}

		/*function changeWidth()  patient_id
		{
		parent.frames[0].document.getElementById("cw").width=document.getElementById("id1").width
		parent.frames[0].document.getElementById("h").width=document.getElementById("id3").width
		}*/
      	 function display_records(obj,PatientId,causative_code,adv_event_type_ind_code,adv_event_type_code,reaction_date1)
{
	eval("parent.frames[1].document.forms[0].detail"+obj).innerHTML="<a href=\"javascript:display_records1('"+obj+"','"+PatientId+"','"+causative_code+"','"+adv_event_type_ind_code+"','"+adv_event_type_code+"','"+reaction_date1+"')\"><font color='black' bgcolor='#FF9933'>-</font></a>";
	//var xmlDoc=new ActiveXObject("Microsoft.XMLDom")
	var xmlHttp = new XMLHttpRequest() 
	xmlStr ="<root><SEARCH PatientId=\""+PatientId+"\"  adv_event_type_ind_code=\""+adv_event_type_ind_code+"\" adv_event_type_code=\""+adv_event_type_code+"\" causative_code=\""+causative_code+"\"	reaction_date1=\""+reaction_date1+"\"  cnt=\""+obj+"\" det='add' steps='6'/></root>"
	
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eCA/jsp/AdverseEventType.jsp",false)		   
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
}

function display_records1(obj,PatientId,causative_code,adv_event_type_ind_code,adv_event_type_code,reaction_date1)
{
	eval("parent.frames[1].document.forms[0].detail"+obj).innerHTML="<a href=\"javascript:display_records('"+obj+"','"+PatientId+"','"+causative_code+"','"+adv_event_type_ind_code+"','"+adv_event_type_code+"','"+reaction_date1+"')\"><font color='black'>+</font></a>";

	var xmlDoc=new ActiveXObject("Microsoft.XMLDom")
	var xmlHttp = new XMLHttpRequest() 
	xmlStr ="<root><SEARCH PatientId=\""+PatientId+"\"  adv_event_type_ind_code=\""+adv_event_type_ind_code+"\" adv_event_type_code=\""+adv_event_type_code+"\" causative_code=\""+causative_code+"\"	reaction_date1=\""+reaction_date1+"\"  cnt=\""+obj+"\" det='sub' steps='6'/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eCA/jsp/AdverseEventType.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
	
}
function callonload()
{
	var tot_allr=document.forms[0].rowcolor.value;
//parent.frames[0].document.forms[0].third1.style.display='inline';
//	parent.frames[0].document.forms[0].third1.style.display='visible';

}	
	
</script>  
</head>

<%
		//String locale = (String)session.getAttribute("LOCALE");
		Connection con = ConnectionManager.getConnection(request);
		ResultSet rs = null;
		PreparedStatement stmt	= null;
		//Statement stmt = null;
		String allergen1="",allergen="",adv_event_type="",Certainity="",onset_date="",status="",causative_code="",adv_event_type_ind_code="",adv_event_type_code="",severity_main="",classValue="",classValue1="",adv_event_dtl_srl_no="",reaction_date_prev="",reaction_date1="",causative_substance="",route_of_exposure="",severity_two="",adv_reac_code="",reac_desc="",diagnosis_code="",severity_code="",active_date="",cnt_recurring="",final_reac_code_val="",reaction_site="",onset_date_disply="",reaction_date1_disply="",others_reaction="",adv_event_type_code1="",StrSql1="";

		String calculated_onset_date_yn="";
		String img_disp_yn="";

		//String duration="",reac_desc_final="",adv_event_type_ind="";
	try 
	{
		//String PatientId=request.getParameter("PatientId");
		//if(PatientId ==null) PatientId="";
		String Encounter_Id=request.getParameter("Encounter_Id");
		if(Encounter_Id==null) Encounter_Id="";
	%>
		<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' >
	 <form name = 'chk_val'>
	<table cellpadding='0'  border='0' cellspacing='0' width='100%' align='center' >
	<th align='left' nowrap><fmt:message key="eMR.AdeverseEventsAllgSens.label" bundle="${mr_labels}"/></th></th>
	</table>
	<table cellpadding='0'  border='1' cellspacing='0' width='100%'  id='record'>
	<tr>
		<th width='3%'><div  id='head1'  class='myClass' nowrap width='3%'>&nbsp;&nbsp;</div></th>
		<th width='15%'><div  id='head2' class='myClass' nowrap width='24%'><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></div></th>
		<th width='15%'><div  id='head3' class='myClass' nowrap width='25%'><fmt:message key="eMR.Allergen.label" bundle="${mr_labels}"/></div></th>
		<th width='15%'><div  id='head4' class='myClass' nowrap width='25%'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></div></th>
		<th width='15%'><div  id='head5' class='myClass' nowrap width='23%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></div></th>
	</tr>
	<%
		//stmt=con.createStatement();
		int rowcolor=0,m=0;
		 	  if(radio_par.equals("A"))
				  StrSql1="a.status='A'";
				else if(radio_par.equals("O"))
				   StrSql1="a.status!='E'";
		/*	String sql="SELECT (SELECT count(*) from pr_allergy_sensitivity  where patient_id=a.patient_id  AND ADV_EVENT_TYPE_IND=a.adv_event_type_ind AND ADV_EVENT_TYPE=a.adv_event_type  AND ALLERGEN_CODE=a.allergen_code  and status NOT LIKE 'A' )COUNT, f.adv_reac_code, f.adv_event_srl_no, f.adv_event_dtl_srl_no, f.adv_event_rxn_srl_no, g.long_desc reac_desc,TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,a.patient_id, a.severity severity1,a.severity severity_code, a.adv_event_type_ind, a.adv_event_type,a.allergen_code,   NVL((SELECT long_desc FROM mr_allergen  WHERE allergen_code = a.allergen_code),(SELECT generic_name FROM ph_generic_name WHERE generic_id = a.allergen_code)) allergen,c.adv_event_type_ind_desc, d.long_desc adv_event_type_desc,a.certainty certainty,a.status status,TO_CHAR (a.onset_date, 'dd/mm/yyyy') onset_date, DECODE (e.adv_event_type,'DA', (SELECT drug_desc FROM ph_drug WHERE drug_code = e.drug_code),   e.causative_substance) causative_substance, e.route_of_exposure route_of_exposure,f.severity severity_two,e.adv_event_dtl_srl_no, a.diagnosis_code ,TO_CHAR (a.ACTIVE_DATE ,'dd/mm/yyyy') active_date ,a.REACTION_CODE_VALUES,f.REACTION_SITE , f.OTHERS_REACTION FROM pr_allergy_sensitivity a,mr_adv_event_type_ind c,mr_adv_event_type d,pr_adverse_event e,   pr_adverse_event_reaction f,am_reaction g WHERE a.patient_id = '"+patient_id+"' AND "+StrSql1+"   AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = d.adv_event_type_code AND f.adv_reac_code = g.reaction_code (+) ORDER BY a.allergen_code, a.onset_date, f.reaction_date"; */
			
		String sql="SELECT   (SELECT COUNT (*) FROM pr_allergy_sensitivity WHERE patient_id = a.patient_id AND adv_event_type_ind = a.adv_event_type_ind AND adv_event_type = a.adv_event_type AND allergen_code = a.allergen_code AND status NOT LIKE 'A') COUNT, f.adv_reac_code, f.adv_event_srl_no, f.adv_event_dtl_srl_no, f.adv_event_rxn_srl_no, am_get_desc.AM_REACTION(f.adv_reac_code,?,'1') reac_desc, TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date, a.patient_id, a.severity severity1, a.severity severity_code, a.adv_event_type_ind, a.adv_event_type, a.allergen_code, NVL(mr_get_desc.MR_ALLERGEN(a.allergen_code,?,'1'),(SELECT GENERIC_NAME FROM ph_generic_name_lang_vw WHERE GENERIC_ID=a.allergen_code AND LANGUAGE_ID=?) )allergen, mr_get_desc. MR_ADV_EVENT_TYPE_IND(a.adv_event_type_ind ,?,'1') adv_event_type_ind_desc , mr_get_desc.MR_ADV_EVENT_TYPE(a.adv_event_type,?,1) adv_event_type_desc, a.certainty certainty, a.status status, TO_CHAR (a.onset_date, 'dd/mm/yyyy') onset_date, DECODE (e.adv_event_type, 'DA', (SELECT drug_desc FROM ph_drug_lang_vw WHERE drug_code = e.drug_code  AND LANGUAGE_ID= ? ), e.causative_substance ) causative_substance, e.route_of_exposure route_of_exposure, f.severity severity_two, e.adv_event_dtl_srl_no, a.diagnosis_code, TO_CHAR (a.active_date, 'dd/mm/yyyy') active_date, a.reaction_code_values, f.reaction_site, f.others_reaction,CALCULATED_ONSET_DATE_YN FROM pr_allergy_sensitivity a,pr_adverse_event e, pr_adverse_event_reaction f WHERE a.patient_id = ? AND "+StrSql1+" AND a.patient_id = e.patient_id  AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind  AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code  AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no   ORDER BY a.allergen_code, a.onset_date, f.reaction_date";

		//System.out.println(sql);
		
		stmt = con.prepareStatement(sql);

		stmt.setString(1, locale);
		stmt.setString(2, locale);
		stmt.setString(3, locale);
		stmt.setString(4, locale);
		stmt.setString(5, locale);
		stmt.setString(6, locale);
		stmt.setString(7, patient_id);

				
		rs=stmt.executeQuery();
		if(rs !=null)
		{%>
			<%while(rs.next())
			  {

					causative_code=rs.getString("allergen_code");
					adv_event_type_ind_code=rs.getString("ADV_EVENT_TYPE_IND");
					//System.out.println("adv_event_type_ind_code##########"+adv_event_type_ind_code);
					adv_event_type_code=rs.getString("ADV_EVENT_TYPE");
					allergen=rs.getString("allergen");
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

					if(status.equals("A"))
					{
					status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
					}
						
				
					if(route_of_exposure.equals("1"))
					{
					route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Ingestion.label","mr_labels");
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

					onset_date_disply=DateUtils.convertDate(onset_date,"DMY","en",locale);
					reaction_date1_disply=DateUtils.convertDate(reaction_date1,"DMYHM","en",locale);

				if((!adv_event_type_code.equals(adv_event_type_code1) || !causative_code.equals(allergen1)))
				{
					if (classValue.equals("QRYODDSMALL"))
						classValue = "QRYEVENSMALL";
					else
						classValue = "QRYODDSMALL";
					
		%>

			<tr id='first' >

			<td  class='<%=classValue1%>' nowrap id='detail<%=m%>'><a href="javascript:onclick=display_records1('<%=m%>','<%=patient_id%>','<%=causative_code%>','<%=adv_event_type_ind_code%>','<%=adv_event_type_code%>','<%=reaction_date1%>')">&nbsp;-&nbsp;</a>
			</td>
			<td  class='<%=classValue%>' nowrap ><%=adv_event_type%></td>
			<td   class='<%=classValue%>' nowrap id='header'><a href="javascript:onclick=display_header('<%=patient_id%>','<%=adv_event_type_ind_code%>','<%=adv_event_type_code%>','<%=causative_code%>','<%=adv_event_dtl_srl_no%>')">
			<%=allergen%>
			</td>
			<td  class='<%=classValue%>' nowrap ><%=onset_date_disply%><img src='../../eCA/images/mc_history.gif' BORDER='0' style='<%=img_disp_yn%>'> </td>
			  
		
			<%if(cnt_recurring.equals("0")){%>
			<td  class='<%=classValue%>' nowrap ><%=status%></td>
				<%}else {%>
				<td  class='<%=classValue%>' nowrap ><%=status%>(<%=cnt_recurring%>)<img src='../../eCommon/images/mandatory.gif' ></img></td>
				<%}%>
				</tr>
			<tr id='third<%=m%>' Style="display:inline;visibility:visible">
			<td  class='<%=classValue%>' nowrap >&nbsp;</td>
			<td class=<%=classValue%>  nowrap><b><fmt:message key="Common.ReactionDate.label" bundle="${common_labels}"/></b></th>
			<td class=<%=classValue%>  nowrap><b><fmt:message key="eMR.reactiondesc.label" bundle="${mr_labels}"/></b></th>
			<td class=<%=classValue%>  nowrap><b><fmt:message key="Common.Severity.label" bundle="${common_labels}"/></b></th>
			<td class=<%=classValue%>  nowrap><b><fmt:message key="eMR.SiteOfReaction.label" bundle="${mr_labels}"/></b></th>
	
			
			
			</tr>
			
			<tr id='second<%=m%>' Style="display:inline;visibility:visible" >
			<td  class='<%=classValue%>' nowrap >&nbsp;</td>
			<td  class='<%=classValue%>' nowrap ><%=reaction_date1_disply%></td>
			

			<% if(adv_reac_code.equals("Oth")) 
			{ %>
			<td  class='<%=classValue%>' nowrap ><%=others_reaction%></td>
			<%} else { %>
			<td  class='<%=classValue%>' nowrap ><%=reac_desc%></td>
			<%}%>
			<td  class='<%=classValue%>' nowrap ><%=severity_two%></td>
			<td  class='<%=classValue%>' nowrap ><%=reaction_site%></td>
			
			
			</tr>
			<%}else{%>
			<tr id='third<%=m%>' Style="display:none;visibility:hidden" >
			<td  class='<%=classValue%>' nowrap >&nbsp;</td>
			<td class=<%=classValue%> align=center nowrap><fmt:message key="Common.ReactionDate.label" bundle="${common_labels}"/></td>
			<td class=<%=classValue%> align=center nowrap ><fmt:message key="eMR.reactiondesc.label" bundle="${mr_labels}"/></td>
			<td class=<%=classValue%> align=center nowrap ><fmt:message key="Common.Severity.label" bundle="${common_labels}"/></td>
			<td class=<%=classValue%> align=center nowrap><fmt:message key="eMR.SiteOfReaction.label" bundle="${mr_labels}"/></td>
			
			
			</tr>
		<tr id='second<%=m%>' Style="display:inline;visibility:visible" >
			<td  class='<%=classValue%>' nowrap >&nbsp;</td>
			<td  class='<%=classValue%>' nowrap ><%=reaction_date1_disply%></td>
			
			<% if(adv_reac_code.equals("Oth")) 
			{ %>
			<td  class='<%=classValue%>' nowrap ><%=others_reaction%></td>  
			<%} else { %>
			<td  class='<%=classValue%>' nowrap ><%=reac_desc%></td>
			<%}%>
			<td  class='<%=classValue%>' nowrap ><%=severity_two%></td>
			<td  class='<%=classValue%>' nowrap ><%=reaction_site%></td>
			
			
			</tr>
							
				<%
				}
				%>
					
				<%	
				allergen1=rs.getString("allergen_code");
				reaction_date_prev =rs.getString("reaction_date");
				adv_event_type_code1=rs.getString("ADV_EVENT_TYPE");
				rowcolor ++;
				m++;
			
			}
			%></table>
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

	<input type="hidden" name="PatientId" id="PatientId" value="<%=patient_id%>" >
	<input type="hidden" name="Encounter_Id" id="Encounter_Id" value="<%=Encounter_Id%>" >
  </form>
</body>
	 <%
     } catch(Exception e) {

		System.out.println("Exception @ try"+e.toString());
		e.printStackTrace(System.err);

         if (rs != null) rs.close();
         if (stmt != null) stmt.close();
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
	
	if("<%=called_from_ip%>" == "Y")	{
                     
	parent.PatAlertQueryResult.location.href='PatAlertQueryResult.jsp?patient_id='+patient_id+'&call_from=allergy&ADV_EVENT_TYPE_IND='+adv_event_type_ind_code+'&ADV_EVENT_TYPE='+adv_event_type_code+'&ALLERGEN_CODE='+causative_code+'&ADV_EVENT_SRL_NO='+adv_event_dtl_srl_no; 
							
	}
	else
		 {
		  parent.PatAlertQueryResult.location.href='PatAlertQueryResult.jsp?patient_id='+patient_id+'&call_from=allergy&ADV_EVENT_TYPE_IND='+adv_event_type_ind_code+'&ADV_EVENT_TYPE='+adv_event_type_code+'&ALLERGEN_CODE='+causative_code+'&ADV_EVENT_SRL_NO='+adv_event_dtl_srl_no;

		 }

}
	</script>
</html>

