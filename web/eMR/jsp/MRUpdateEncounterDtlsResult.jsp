<!DOCTYPE html>
<html>  
	<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*" contentType="text/html; charset=UTF-8"%>
	<%	request.setCharacterEncoding("UTF-8");	%>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<head>
		<%
		String sStyle	=
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
		<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
		<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
		<script src='../../eMR/js/MRUpdateEncounterDtls.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script language='javascript' src='../../eCommon/js/tableheaderscroll.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<style type="text/css">
			table.mt {border-width: 1px;border-spacing:0px ;border-collapse: collapse;}
			table.mt th {border-width: 1px;padding: 1px;;white-space: normal; text-align:left;}
			table.mt td {border-width: 1px;padding: 1px;text-align: left;vertical-align:middle;white-space:normal;}
			table.mt td.br {width:15%;word-wrap: break-word; word-break: break-all;}
		</style>
		<script>
			$("input[name='home']",parent.frames[0].document).click(function() {
		
			if($("input[name='encAll']").length == $("input[name='encAll']").filter(':checked').length) {
				$("input[name='selectAll']").attr("checked", true);
			} else {
				$("input[name='selectAll']").attr("checked", false);
			}
		
			});
		window.onload=function(){ 
			if($("#TableData").length > 0){
				fxheaderInit('TableData',450);	
			}	
		}
	
			function submitNext(){
				document.forms[0].recStart.value=document.forms[0].recEnd.value;
				document.EncDtlsResult.submit();
			}
			function submitPrev(){
				document.forms[0].recStart.value=(document.forms[0].recStart.value-14);
				document.forms[0].recEnd.value=document.forms[0].recStart.value;
				document.EncDtlsResult.submit();
			}
		</script>
	</head>
<%
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rSet=null;
		String	Patient_Id_Length="";
		int recCount=0;
		String facility_id=(String)session.getValue("facility_id");	
		String patientid		= (request.getParameter("patient_id")==null)?"":request.getParameter("patient_id");
		String encounterID		= (request.getParameter("encounterID")==null)?"":request.getParameter("encounterID") ;
		String patient_class		= (request.getParameter("patient_class")==null)?"":request.getParameter("patient_class") ;
		String encDateFrom		= (request.getParameter("encDateFrom")==null)?"":request.getParameter("encDateFrom") ;
		String encDateTo		= (request.getParameter("encDateTo")==null)?"":request.getParameter("encDateTo") ;
		String classValue		= "";
		int recStart=Integer.parseInt((request.getParameter("recStart")==null)?"0":request.getParameter("recStart"));
		int recEnd=Integer.parseInt((request.getParameter("recEnd")==null)?"0":request.getParameter("recEnd"));
		recEnd=recEnd+14;
		try{	
			StringBuffer sql=new StringBuffer("select a.facility_id,a.encounter_id,a.EPISODE_ID,a.OP_EPISODE_VISIT_NUM,a.patient_class,AM_GET_DESC.AM_PATIENT_CLASS(A.PATIENT_CLASS,'"+localeName+"','2')patient_class_desc, a.patient_id,to_char(a.visit_adm_date_time,'dd/mm/yyyy HH24:MI')visit_adm_date_time,b.patient_name,to_char(a.discharge_date_time,'dd/mm/yyyy HH24:MI')discharge_date_time,to_char(a.injury_date,'dd/mm/yyyy')injuryDate,to_char(a.trmt_start_date,'dd/mm/yyyy')trmtStrtDate,to_char(a.trmt_end_date,'dd/mm/yyyy')trmtEndDate,BL_GOSI_GET_POLICY_TYPE(a.facility_id,a.patient_id,a.patient_class,a.encounter_id ) policy_type_desc,bl_edit_gosi_patient_yn(a.facility_id,a.patient_id,a.patient_class, a.encounter_id) bl_edit_gosi_patient_yn from pr_encounter a, mp_patient b  where a.facility_id=? and a.patient_id like ? and a.encounter_id like ? and a.patient_class like ? and a.patient_id=b.patient_id and bl_gosi_patient_yn(a.facility_id,a.patient_id,a.patient_class, a.encounter_id)='Y' and bl_edit_gosi_patient_yn(a.facility_id,a.patient_id,a.patient_class, a.encounter_id) = 'Y' and ((a.patient_class in ('IP','DC') and a.ADT_STATUS!='09') or (a.patient_class in ('OP','EM') and a.VISIT_STATUS !=' 99'))");
			if(!encDateFrom.equals("")){
				sql.append(" and trunc(a.VISIT_ADM_DATE_TIME) >= trunc(to_date('"+encDateFrom+"','dd/mm/yyyy'))");
			}
			if(!encDateTo.equals("")){
				sql.append(" and trunc(a.VISIT_ADM_DATE_TIME) <= trunc(to_date('"+encDateTo+"','dd/mm/yyyy'))");
			}
			
			sql.append(" order by a.facility_id,a.encounter_id"); 
			
			System.err.println("MRUpdateEncounterDtlsResult.jsp sql.toString()===>"+sql.toString());
			System.err.println("MRUpdateEncounterDtlsResult.jsp facility_id===>"+facility_id);
			System.err.println("MRUpdateEncounterDtlsResult.jsp patientid===>"+patientid);
			System.err.println("MRUpdateEncounterDtlsResult.jsp encounterID===>"+encounterID);			
			System.err.println("MRUpdateEncounterDtlsResult.jsp patient_class===>"+patient_class);
			
			con=ConnectionManager.getConnection(request);
			pstmt	= con.prepareStatement(sql.toString());
			pstmt.setString(1,facility_id);
			pstmt.setString(2,"%"+patientid);
			pstmt.setString(3,"%"+encounterID);
			pstmt.setString(4,"%"+patient_class);
			rSet	= pstmt.executeQuery();
			
			String blEditGOSIPatYN="";
%>		
 <BODY onMouseDown="CodeArrest();"  onKeyDown='lockKey()'>
 <form name="EncDtlsResult" id="EncDtlsResult" action="../../eMR/jsp/MRUpdateEncounterDtlsResult.jsp" method="post">
	<%
	System.err.println("recStart-100->"+recStart);
	//while(recCount<recEnd && (rSet!=null && rSet.next())){
	while(rSet.next()){//Modified by Dharma on July 22nd 2015 against MMS-QH-CRF-0219 [IN:055276]
		//if((recStart<=recCount && recCount<recEnd)){ //Commented by Dharma on July 22nd 2015 against MMS-QH-CRF-0219 [IN:055276]
			blEditGOSIPatYN=(rSet.getString("BL_EDIT_GOSI_PATIENT_YN")==null)?"N":rSet.getString("BL_EDIT_GOSI_PATIENT_YN");
			System.err.println("blEditGOSIPatYN-105->"+blEditGOSIPatYN);
			if ( recCount % 2 == 0 )
				classValue = "QRYODD";
			else
				classValue = "QRYEVEN";
			System.err.println("recStart-->"+recStart);
			System.err.println("recCount-->"+recCount);
		if(recCount==recStart){%>		
		<!--Commented by Dharma on July 22nd 2015 against MMS-QH-CRF-0219 [IN:055276] Start-->
			<!--
			<table border="0" width="100%" cellspacing='0' cellpadding='0'>
				<tr>
					<td align='right' id='prev' style='display:none' width="100%"><A HREF="#" onClick='submitPrev();' text-decoration='none'><fmt:message key="Common.previous.label"  bundle="${common_labels}"/></A></td><td>&nbsp;</td>
					<td align='right' id='next' style='display:none' width="100%"><A HREF="#" onClick='submitNext();' text-decoration='none'><fmt:message key="Common.next.label"  bundle="${common_labels}"/></A></td>
				</tr>
			</table>-->		
			<!--Commented by Dharma on July 22nd 2015 against MMS-QH-CRF-0219 [IN:055276] End-->
			<table  border='1' style='border-spacing:0px ;border-collapse: collapse;'   width='98%' class='mt' id='TableData'> 
				<tr>
					<!-- Added by Dharma on July 21st 2015 against MMS-QH-CRF-0219 [IN:055276] Start-->
					<th   width='10%' nowrap><input type='checkbox'  name='selectAll' id='selectAll' /><fmt:message key="Common.selectall.label" bundle="${common_labels}"/></th>
					<!-- Added by Dharma on July 21st 2015 against MMS-QH-CRF-0219 [IN:055276] End-->
					<th   width='8%' nowrap><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></th>
					<th   width='9%' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
					<th   width='15%' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
					<th   width='9%' nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
					<th   width='8%' nowrap><fmt:message key="eMR.EpisodeNo.label" bundle="${mr_labels}"/></th>
					<th   width='8%' nowrap><fmt:message key="eOP.VisitNo.label" bundle="${op_labels}"/></th>
					<th   width='13%' nowrap><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></th>
					<th   width='13%' nowrap><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></th>
					<th   width='10%' nowrap><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/></th>
					<th   width='10%' nowrap><fmt:message key="eMR.Injury.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}"/></th>
					<th   width='10%' nowrap><fmt:message key="Common.Treatment.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></th>
					<th   width='10%' nowrap><fmt:message key="Common.Treatment.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.enddate.label" bundle="${common_labels}"/></th>
				</tr>
		<%}%>				
	
		<tr>
			<!-- Added by Dharma on July 21st 2015 against MMS-QH-CRF-0219 [IN:055276] Start-->
			<td  height="20"  class='<%=classValue%>'><input type='checkbox' id='enc_<%=recCount%>' name='encAll' value='<%=rSet.getString("patient_id")%>_<%=rSet.getString("encounter_id")%>' onclick='fnEnableDisableLink();' /></td>
			<!-- Added by Dharma on July 21st 2015 against MMS-QH-CRF-0219 [IN:055276] End-->
			<td  height="20"  class='<%=classValue%>'><font size=1><%=(rSet.getString("patient_class_desc")==null)?"":rSet.getString("patient_class_desc")%>&nbsp;</td>

			<td  height="20" class='<%=classValue%>'><font size=1><%=(rSet.getString("patient_id")==null)?"":rSet.getString("patient_id")%>&nbsp;</td>

					
			<td  height="20" class="br <%=classValue%> " nowrap><font size=1><%=(rSet.getString("patient_name")==null)?"":rSet.getString("patient_name")%>&nbsp;</td>
			<%if(blEditGOSIPatYN.equals("Y")){%>
			<td  height="20" class="<%=classValue%>"><font size=1>
			<!-- Modified by Dharma on July 21st 2015 against MMS-QH-CRF-0219 [IN:055276] Start-->
			<!--
			<a href="#" onClick="UpdateEncDtlsModal('<%=rSet.getString("patient_id")%>','<%=rSet.getString("encounter_id")%>')"><%=(rSet.getString("encounter_id")==null)?"":rSet.getString("encounter_id")%>&nbsp;</a>
			-->

			<a href="javascript:UpdateEncDtlsModal('<%=rSet.getString("patient_id")%>','<%=rSet.getString("encounter_id")%>','1','<%=rSet.getString("encounter_id")%>')" id='href_<%=rSet.getString("patient_id")%>_<%=rSet.getString("encounter_id")%>'> <%=(rSet.getString("encounter_id")==null)?"":rSet.getString("encounter_id")%>&nbsp;</a>

			<!-- Modified by Dharma on July 21st 2015 against MMS-QH-CRF-0219 [IN:055276] End-->
			
			</td>
			<%}else{%>
			<td  height="20" class="<%=classValue%>"><font size=1><%=(rSet.getString("encounter_id")==null)?"":rSet.getString("encounter_id")%>&nbsp;</td>
			<%}%>
			<td  height="20" class="<%=classValue%>"><font size=1><%=(rSet.getString("EPISODE_ID")==null)?"":rSet.getString("EPISODE_ID")%>&nbsp;</td>
			<td  height="20" class="<%=classValue%>"><font size=1><%=(rSet.getString("OP_EPISODE_VISIT_NUM")==null)?"":rSet.getString("OP_EPISODE_VISIT_NUM")%>&nbsp;</td>
 
			<td  height="20" class="<%=classValue%>" nowrap ><font size=1>
			<%=(rSet.getString("visit_adm_date_time")==null)?"":rSet.getString("visit_adm_date_time")%>&nbsp;
			</td>

			<td  height="20" class="<%=classValue%>" nowrap><font size=1>
			<%=(rSet.getString("discharge_date_time")==null)?"":rSet.getString("discharge_date_time")%>&nbsp;
			</td>

			<td  height="20" class="<%=classValue%>" nowrap><font size=1>
			<%=(rSet.getString("policy_type_desc")==null)?"":rSet.getString("policy_type_desc")%>&nbsp;		
			</td>
			<td  height="20" class="<%=classValue%>" nowrap ><font size=1>
			<%=(rSet.getString("injuryDate")==null)?"":rSet.getString("injuryDate")%>&nbsp;		
			</td>
 
 
			<td  height="20" class="<%=classValue%>" nowrap><font size=1>
			<%=(rSet.getString("trmtStrtDate")==null)?"":rSet.getString("trmtStrtDate")%>&nbsp;
			</td>

			<td  height="20" class="<%=classValue%>" nowrap><font size=1>
			<%=(rSet.getString("trmtEndDate")==null)?"":rSet.getString("trmtEndDate")%>&nbsp;
			</td>
		</tr>
	<%
		//}//Commented by Dharma on July 22nd 2015 against MMS-QH-CRF-0219 [IN:055276]
		recCount++;
	}
//Commented by Dharma on July 22nd 2015 against MMS-QH-CRF-0219 [IN:055276] Start
	/*if(rSet.next()){
		%>
		<script>
			document.getElementById("next").style.display= 'inline';
		</script>
	<%}
	if(recCount >14){%>
		<script>
			document.getElementById("prev").style.display= 'inline';
		</script>
	<%}*/
	//Commented by Dharma on July 22nd 2015 against MMS-QH-CRF-0219 [IN:055276] End
	
	%>
	</table>
	<input type='hidden' name='recStart' id='recStart' value='<%=recStart%>' >
	<input type='hidden' name='recEnd' id='recEnd' value='<%=recEnd%>' >
	<input type='hidden' name='patient_id' id='patient_id' value='<%=patientid%>' >
	<input type='hidden' name='encounterID' id='encounterID' value='<%=encounterID%>' >
	<input type='hidden' name='patient_class' id='patient_class' value='<%=patient_class%>' >
	<input type='hidden' name='encDateFrom' id='encDateFrom' value='<%=encDateFrom%>' >
	<input type='hidden' name='encDateTo' id='encDateTo' value='<%=encDateTo%>' >
 </form>
 </body>
<%	
			if(recCount ==0){
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			}
		}catch(Exception Ex){
			Ex.printStackTrace();
		}finally{
			if(con!=null){
				ConnectionManager.returnConnection(con,request);
			}
		}
	%>
 </html>
 


