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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rSet=null;
		String	Patient_Id_Length="";
		String facility_id=(String)session.getValue("facility_id");	
		String patientid		= (request.getParameter("patient_id")==null)?"":request.getParameter("patient_id");
		String encounterID		= request.getParameter("encounterID")==null?"":request.getParameter("encounterID") ;

		//Added by Senthil
		String injury_date=request.getParameter("injury_date")==null?"":request.getParameter("injury_date");  
		String trmt_strt_date=request.getParameter("trmt_strt_date")==null?"":request.getParameter("trmt_strt_date");
		String trmt_end_date=request.getParameter("trmt_end_date")==null?"":request.getParameter("trmt_end_date"); 

		/* Added by Dharma on July 22nd 2015 against MMS-QH-CRF-0219 [IN:055276] Start*/
		int checkedEncCount	= 0;
		if(request.getParameter("checkedEncCount")!=null)
			checkedEncCount	=  Integer.parseInt(request.getParameter("checkedEncCount")); 			
		String checkedEncIds=request.getParameter("checkedEncIds")==null?"":request.getParameter("checkedEncIds"); 
		String encounter_id=""; 
		String enc_date1="";
		String injuryDate1="";
		String trmtStrtDate1="";
		String trmtEndDate1="";
		String checkedEncIdsQry	= checkedEncIds;
	
		StringBuffer allEncDetails = new StringBuffer();
		/* Added by Dharma on July 22nd 2015 against MMS-QH-CRF-0219 [IN:055276] End*/

		String enc_date="";
		String injuryDate="";
		String trmtStrtDate="";
		String trmtEndDate="";
		try{	
		
			/* Commented by Dharma on July 22nd 2015 against MMS-QH-CRF-0219 [IN:055276] Start*/
			
			/*String sql="select patient_id,to_char(VISIT_ADM_DATE_TIME,'dd/mm/yyyy')enc_date,to_char(INJURY_DATE,'dd/mm/yyyy')injuryDate,to_char(TRMT_START_DATE,'dd/mm/yyyy')trmtStrtDate,to_char(TRMT_END_DATE,'dd/mm/yyyy')trmtEndDate from pr_encounter where facility_id=? and encounter_id=?";
			con=ConnectionManager.getConnection(request);
			pstmt	= con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,encounterID);
			rSet	= pstmt.executeQuery();
			if(rSet!=null && rSet.next()){
				enc_date=rSet.getString("enc_date")==null?"":rSet.getString("enc_date");
				injuryDate=rSet.getString("injuryDate")==null?"":rSet.getString("injuryDate");
				trmtStrtDate=rSet.getString("trmtStrtDate")==null?"":rSet.getString("trmtStrtDate");
				trmtEndDate=rSet.getString("trmtEndDate")==null?"":rSet.getString("trmtEndDate");
			}*/
			/* Commented by Dharma on July 22nd 2015 against MMS-QH-CRF-0219 [IN:055276] End*/
			
			/* Added by Dharma on July 22nd 2015 against MMS-QH-CRF-0219 [IN:055276] Start*/
			if(checkedEncCount > 1){
				checkedEncIdsQry	= checkedEncIds.replaceAll(",","','");
			}

			String sql="select encounter_id, patient_id,to_char(VISIT_ADM_DATE_TIME,'dd/mm/yyyy')enc_date,to_char(INJURY_DATE,'dd/mm/yyyy')injuryDate,to_char(TRMT_START_DATE,'dd/mm/yyyy')trmtStrtDate,to_char(TRMT_END_DATE,'dd/mm/yyyy')trmtEndDate from pr_encounter where facility_id=? and encounter_id in ('"+checkedEncIdsQry+"')";
			con=ConnectionManager.getConnection(request);
			pstmt	= con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			rSet	= pstmt.executeQuery();
			if(rSet!=null){
				while(rSet.next()){
						encounter_id=rSet.getString("encounter_id")==null?"":rSet.getString("encounter_id");
						
						if(encounter_id.equals(encounterID)){
							enc_date=rSet.getString("enc_date")==null?"":rSet.getString("enc_date");
							injuryDate=rSet.getString("injuryDate")==null?"":rSet.getString("injuryDate");
							trmtStrtDate=rSet.getString("trmtStrtDate")==null?"":rSet.getString("trmtStrtDate");
							trmtEndDate=rSet.getString("trmtEndDate")==null?"":rSet.getString("trmtEndDate");
						}
							enc_date1=rSet.getString("enc_date")==null?"":rSet.getString("enc_date");
							injuryDate1=rSet.getString("injuryDate")==null?"":rSet.getString("injuryDate");
							trmtStrtDate1=rSet.getString("trmtStrtDate")==null?"":rSet.getString("trmtStrtDate");
							trmtEndDate1=rSet.getString("trmtEndDate")==null?"":rSet.getString("trmtEndDate");

						allEncDetails.append(encounter_id+"||"+enc_date1+"||"+injuryDate1+"||"+trmtStrtDate1+"||"+trmtEndDate1+"##");
				}
			}
			if(pstmt !=null) pstmt.close();
			if(rSet !=null) rSet.close();

			/* Commented by Dharma on July 22nd 2015 against MMS-QH-CRF-0219 [IN:055276] End*/

	%>
	<body onMouseDown="CodeArrest();" onKeyDown ='lockKey();'>
		<form name="updateEncDtlsForm" id="updateEncDtlsForm" method='post' action='../../servlet/eMR.EncDetailsServlet'>
			<table border="0" width="40%" align=center cellspacing='0' cellpadding='0'>
				<tr>
					<td  height="20" class='label' ><fmt:message key="eMR.Injury.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
					<td nowrap class='fields'><input type='text' id='inj_date_id' name='injury_date' id='injury_date' value='<%=injuryDate%>' size='10' maxlength='10' onblur="validDateObjLoc(this);"><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].inj_date_id.select();return showCalendar('inj_date_id'/*,null,'hh:mm'*/);"></img>
					<img src='../../eCommon/images/mandatory.gif'></img></td>
				</tr>
				<tr>					
					<td  height="20" class='label' ><fmt:message key="Common.Treatment.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
					<td nowrap class='fields'><input type='text' id='trmt_st_date_id' name='trmt_strt_date' id='trmt_strt_date' value='<%=
					trmtStrtDate%>' size='10' maxlength='10' onblur="validDateObjLoc(this);"><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].trmt_st_date_id.select();return showCalendar('trmt_st_date_id'/*,null,'hh:mm'*/);"></img>
					<img src='../../eCommon/images/mandatory.gif'></img></td>
				</tr>
				<tr>
					<td  height="20" class='label' ><fmt:message key="Common.Treatment.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td>
					<td nowrap class='fields'><input type='text' id='trmt_end_date_id' name='trmt_end_date' id='trmt_end_date' value='<%=trmtEndDate%>' size='10' maxlength='10' onblur="validDateObjLoc(this);"><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].trmt_end_date_id.select();return showCalendar('trmt_end_date_id'/*,null,'hh:mm'*/);"></img>
					</td>
				</tr>
					<br/>
					<tr>&nbsp;</tr>
					<tr>&nbsp;</tr>
				<tr>
						
					<td>&nbsp;</td><td  colspan=2 ><input type="button" name="Search" id="Search" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick='updateEncDtls()' class='button'><input type="button" name="Clear" id="Clear" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  class='button' onClick='closeWindow()'></td>
				</tr>
			</table>
			<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'/>
			<input type='hidden' name='encounterID' id='encounterID' id='encounterID' value='<%=encounterID%>'/>
			<input type='hidden' name='enc_date' id='enc_date' value='<%=enc_date%>'/>
			<input type='hidden' name='patientid' id='patientid' value='<%=patientid%>'/> <!-- Added Senthil-->
			<input type='hidden' name='status_flag' id='status_flag' value=''/>

			<!-- Added by Dharma on July 23rd 2015 against MMS-QH-CRF-0219 [IN:055276] Start-->
			<input type='hidden' name='allEncDetails' id='allEncDetails' id='allEncDetails' value='<%=allEncDetails%>'/>
			<input type='hidden' name='checkedEncCount' id='checkedEncCount' id='checkedEncCount' value='<%=checkedEncCount%>'/>
			<input type='hidden' name='checkedEncIds' id='checkedEncIds' id='checkedEncIds' value='<%=checkedEncIds%>'/>
			<!-- Added by Dharma on July 23rd 2015 against MMS-QH-CRF-0219 [IN:055276] End>



		</form>
	</body>
	<%		
		}catch(Exception Ex){
			Ex.printStackTrace();
		}finally{
			if(con!=null){
				ConnectionManager.returnConnection(con,request);
			}
		}
	%>
</html>

