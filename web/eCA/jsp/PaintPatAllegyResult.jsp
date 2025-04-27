<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
<title><fmt:message key="Common.Allergies.label" bundle="${common_labels}"/></title>
<head>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../js/rowcolor.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	 <script language='javascript' src='../../eCA/js/PatAllergy.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	 <script>	
	    function display_records(obj,PatientId,causative_code,adv_event_type_ind_code,adv_event_type_code,reaction_date1,status,error_status,onset_date)
	{
	
	eval("document.forms[0].detail"+obj).innerHTML="<a href='#'  onClick=\" display_records1('"+obj+"','"+PatientId+"','"+causative_code+"','"+adv_event_type_ind_code+"','"+adv_event_type_code+"','"+reaction_date1+"','"+status+"','"+error_status+"','"+onset_date+"')\"><font color='black' bgcolor='#FF9933'>-</font></a>";
	var xmlHttp = new XMLHttpRequest() 
	xmlStr ="<root><SEARCH PatientId=\""+PatientId+"\"  adv_event_type_ind_code=\""+adv_event_type_ind_code+"\" adv_event_type_code=\""+adv_event_type_code+"\" causative_code=\""+causative_code+"\"	reaction_date1=\""+reaction_date1+"\"  cnt=\""+obj+"\" status=\""+status+"\" error_status=\""+error_status+"\" onset_date=\""+onset_date+"\" det='add' steps='7' /></root>"
	
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eCA/jsp/AdverseEventType.jsp",false)		   
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
		//alert(responseText);
	eval(responseText)
}

function display_records1(obj,PatientId,causative_code,adv_event_type_ind_code,adv_event_type_code,reaction_date1,status,error_status,onset_date)
{
	//alert('obj..'+obj+'..causative_code..'+causative_code+'..adv_event_type_ind_code...'+adv_event_type_ind_code+'..adv_event_type_code...'+adv_event_type_code+'...status...'+status+'.error_status...'+error_status);
	eval("document.forms[0].detail"+obj).innerHTML="<a href='#' onClick=\"display_records('"+obj+"','"+PatientId+"','"+causative_code+"','"+adv_event_type_ind_code+"','"+adv_event_type_code+"','"+reaction_date1+"','"+status+"','"+error_status+"','"+onset_date+"')\"><font color='black'>+</font></a>";

	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH PatientId=\""+PatientId+"\"  adv_event_type_ind_code=\""+adv_event_type_ind_code+"\" adv_event_type_code=\""+adv_event_type_code+"\" causative_code=\""+causative_code+"\"	reaction_date1=\""+reaction_date1+"\"  cnt=\""+obj+"\" det='sub' status=\""+status+"\" error_status=\""+error_status+"\" onset_date=\""+onset_date+"\" steps='7'/></root>"
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eCA/jsp/AdverseEventType.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
		//alert(responseText);
	eval(responseText)
	
}

function callonload()
{
	var tot_allr=document.forms[0].rowcolor.value;
//parent.frames[0].document.forms[0].all.third1.style.display='inline';
//	parent.frames[0].document.forms[0].all.third1.style.display='visible';

}	



	 </script>
</head>

<%
		//String locale = (String)session.getAttribute("LOCALE");
		Connection con = ConnectionManager.getConnection(request);
		ResultSet rs = null;
		Statement stmt = null;
		//String allergen1="",allergen="",adv_event_type="",Certainity="",onset_date="",status="",causative_code="",adv_event_type_ind_code="",adv_event_type_code="",severity_main="",classValue="",classValue1="",adv_event_dtl_srl_no="",reaction_date_prev="",reaction_date1="",causative_substance="",route_of_exposure="",severity_two="",adv_reac_code="",reac_desc="",diagnosis_code="",severity_code="",active_date="",cnt_recurring="",final_reac_code_val="",reaction_site="",onset_date_disply="",reaction_date1_disply="",others_reaction="",adv_event_type_code1="",calculated_onset_date_yn="",error_status="" ,status1="",status11="",reaction_date2="",adv_event_type_ind_code1="",onset_date_disply1="",onset_date1="",status_pass="" ;
		String allergen1="",allergen="",adv_event_type="",Certainity="",onset_date="",status="",causative_code="",adv_event_type_ind_code="",adv_event_type_code="",severity_main="",classValue="",classValue1="",adv_event_dtl_srl_no="",reaction_date_prev="",reaction_date1="",causative_substance="",route_of_exposure="",severity_two="",adv_reac_code="",reac_desc="",diagnosis_code="",severity_code="",active_date="",cnt_recurring="",final_reac_code_val="",reaction_site="",onset_date_disply="",reaction_date1_disply="",others_reaction="",adv_event_type_code1="",calculated_onset_date_yn="",error_status="" ,status1="",adv_event_type_ind_code1="",onset_date_disply1="",onset_date1="",status_pass="" ;
		int cntRecords = 0;
		//String duration="",reac_desc_final="",adv_event_type_ind="";
	try 
	{
		 
    	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
        String locale = (String) p.getProperty("LOCALE");
		String PatientId = request.getParameter("patient_id");
		String Encounter_Id=request.getParameter("Encounter_Id");
		if(Encounter_Id==null) Encounter_Id="";
	%>
		<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' >
	 <form name = 'chk_val'>
	 <!-- Modified by kishore kumar N on 15/12/2008 for CRF 0387, applied grid css -->
	<table class='grid' width='100%'  id='record'>
	<tr>
		<th width='3%'><div  id='head1'  class='myClass' nowrap width='3%'>&nbsp;&nbsp;</div></th>
		<th width='15%'><div  id='head2' class='myClass' nowrap width='24%'><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></div></th>
		<th width='15%'><div  id='head3' class='myClass' nowrap width='25%'><fmt:message key="eMR.Allergen.label" bundle="${mr_labels}"/></div></th>
		<th width='15%'><div  id='head4' class='myClass' nowrap width='25%'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></div></th>
		<th width='15%'><div  id='head5' class='myClass' nowrap width='23%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></div></th>
	</tr>
	<%
		stmt=con.createStatement();
		int rowcolor=0,m=0;
		  
		String sql="SELECT (SELECT count(*) from pr_allergy_sensitivity  where patient_id=a.patient_id  AND ADV_EVENT_TYPE_IND=a.adv_event_type_ind AND ADV_EVENT_TYPE=a.adv_event_type  AND ALLERGEN_CODE=a.allergen_code  and status NOT LIKE 'A' )COUNT, f.adv_reac_code, f.adv_event_srl_no, f.adv_event_dtl_srl_no, f.adv_event_rxn_srl_no, g.long_desc reac_desc,TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,a.patient_id, a.severity severity1,a.severity severity_code, a.adv_event_type_ind, a.adv_event_type,a.allergen_code,   NVL((SELECT long_desc FROM mr_allergen  WHERE allergen_code = a.allergen_code),(SELECT generic_name FROM ph_generic_name WHERE generic_id = a.allergen_code)) allergen,c.adv_event_type_ind_desc, d.long_desc adv_event_type_desc,a.certainty certainty,a.status status,TO_CHAR (a.onset_date, 'dd/mm/yyyy hh24:mi:ss') onset_date, DECODE (e.adv_event_type,'DA', (SELECT drug_desc FROM ph_drug WHERE drug_code = e.drug_code),   e.causative_substance) causative_substance, e.route_of_exposure route_of_exposure,f.severity severity_two,e.adv_event_dtl_srl_no, a.diagnosis_code ,TO_CHAR (a.ACTIVE_DATE ,'dd/mm/yyyy') active_date ,a.REACTION_CODE_VALUES,f.REACTION_SITE , f.OTHERS_REACTION,a.calculated_onset_date_yn,f.status error_status FROM pr_allergy_sensitivity a,mr_adv_event_type_ind c,mr_adv_event_type d,pr_adverse_event e,   pr_adverse_event_reaction f,am_reaction g WHERE a.patient_id = '"+PatientId+"' AND  a.status='A' AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = d.adv_event_type_code AND f.adv_reac_code = g.reaction_code (+) ORDER BY a.onset_date, a.ADV_EVENT_TYPE_IND, a.allergen_code,  f.reaction_date";	

		
		rs=stmt.executeQuery(sql);
		if(rs !=null)
		{%>
			<%
				classValue = "gridData";
				while(rs.next())
				  {

					causative_code=rs.getString("allergen_code");
					adv_event_type_ind_code=rs.getString("ADV_EVENT_TYPE_IND");

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

					calculated_onset_date_yn = rs.getString("calculated_onset_date_yn") == null ?"&nbsp;":rs.getString("calculated_onset_date_yn");
					error_status = rs.getString("error_status") == null ?"A":rs.getString("error_status");

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

				if((!adv_event_type_code.equals(adv_event_type_code1) || !causative_code.equals(allergen1)|| !status.equals(status1) || !adv_event_type_ind_code.equals(adv_event_type_ind_code1) || !onset_date_disply.equals(onset_date_disply1)))
				{
					/*if (classValue.equals("QRYODDSMALL"))
						classValue = "QRYEVENSMALL";
					else
						classValue = "QRYODDSMALL";*/
					
		%>

			<tr id='first' >

			<td  class='<%=classValue1%>' nowrap id='detail<%=m%>'><a href="#" onclick="display_records1('<%=m%>','<%=PatientId%>','<%=causative_code%>','<%=adv_event_type_ind_code%>','<%=adv_event_type_code%>','<%=reaction_date1%>','<%=status_pass%>','<%=error_status%>','<%=onset_date%>')">&nbsp;-&nbsp;</a>
			</td>
			<td  class='<%=classValue%>' nowrap ><%=adv_event_type%></td>
			<td   class='<%=classValue%>' nowrap id='header'>
			<%=allergen%>
			</td>
			<td  class='<%=classValue%>' nowrap ><%=onset_date_disply%> 
				<%if(calculated_onset_date_yn.equals("Y")) {%>
					<img id="imgClock" src="../../eCA/images/mc_history.gif">				
				<%}%>
			</td>
			  
		
			<%if(cnt_recurring.equals("0")){%>
			<td  class='<%=classValue%>' nowrap ><%=status%></td>
				<%}else {%>
				<td  class='<%=classValue%>' nowrap ><%=status%>(<%=cnt_recurring%>)<img src='../../eCommon/images/mandatory.gif' ></img></td>
				<%}%>
				</tr>
			<tr id='third<%=m%>' Style="display;visibility:visible">
			<td  class='<%=classValue%>' nowrap >&nbsp;</td>
			<td class=<%=classValue%>  nowrap><b><fmt:message key="Common.ReactionDate.label" bundle="${common_labels}"/></b></th>
			<td class=<%=classValue%>  nowrap><b><fmt:message key="eMR.reactiondesc.label" bundle="${mr_labels}"/></b></th>
			<td class=<%=classValue%>  nowrap><b><fmt:message key="Common.Severity.label" bundle="${common_labels}"/></b></th>
			<td class=<%=classValue%>  nowrap><b><fmt:message key="eMR.SiteOfReaction.label" bundle="${mr_labels}"/></b></th>
	
			
			
			</tr>
		<%if(!error_status.equals("E")){%>	
			
			<tr id='second<%=m%>' Style="display;visibility:visible" >
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
		<%}%>
			<%}else{
						if(!error_status.equals("E")){				%>
						<tr id='third<%=m%>' Style="display:none;visibility:hidden" >
								<td  class='<%=classValue%>' nowrap >&nbsp;</td>
								<td class=<%=classValue%> align=center nowrap><fmt:message key="Common.ReactionDate.label" bundle="${common_labels}"/></td>
								<td class=<%=classValue%> align=center nowrap ><fmt:message key="eMR.reactiondesc.label" bundle="${mr_labels}"/></td>
								<td class=<%=classValue%> align=center nowrap ><fmt:message key="Common.Severity.label" bundle="${common_labels}"/></td>
								<td class=<%=classValue%> align=center nowrap><fmt:message key="eMR.SiteOfReaction.label" bundle="${mr_labels}"/></td>
						</tr>
		<tr id='second<%=m%>' Style="display;visibility:visible" >
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
				}
				%>
					
				<%	
				allergen1=rs.getString("allergen_code");
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
				cntRecords++;
			}				
			%></table>
					<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>
		<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center'>
			<tr><td width='100%' id='t'></td></tr>
		</table>
	</div><%
		}
		if(cntRecords == 0)
		{
			out.println("<script>alert(getMessage(\"NO_ALLERGY_REC_IN_CURR_SYS\",\"MR\"));");
			out.println("window.close();</script>");
		}		
	%>

	<input type="hidden" name="detail" id="detail" value="" >
	<input type="hidden" name="rowcolor" id="rowcolor" value="<%=rowcolor%>" >
	<input type="hidden" name="cnt" id="cnt" value="" >
	<input type="hidden" name="flag1" id="flag1" VALUE="">

	<input type="hidden" name="PatientId" id="PatientId" value="<%=PatientId%>" >
	<input type="hidden" name="Encounter_Id" id="Encounter_Id" value="<%=Encounter_Id%>" >
  </form>
</body>
	 <%
     } catch(Exception e) {
         if (rs != null) rs.close();
         if (stmt != null) stmt.close();
    }
     finally {
         if (rs != null) rs.close();
         if (stmt != null) stmt.close();
		 ConnectionManager.returnConnection(con,request);
     }
%>
	
</html>

