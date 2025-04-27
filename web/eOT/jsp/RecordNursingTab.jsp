<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.ResultSet,java.sql.Types,java.sql.CallableStatement,java.sql.PreparedStatement,java.sql.ResultSet,eOT.Common.*,eCommon.Common.CommonBean,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<%@ page contentType=" text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%! 
	String encode(String data){	  
	byte byteData[] = data.getBytes();
	String outDat = "";
	for (int i=0; i<byteData.length; i++)
	{
		outDat = outDat +"%"+Integer.toHexString((int)byteData[i]);
	}
		return(outDat);
	}
%>
<html>
<head>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/Tabs.css"></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
</head>
<script language="javascript">
async function callOperativeNotes(){
	var formObj =  parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	var formObjDtl = document.RecordNursingTabForm;
	var slate_user_id = formObjDtl.slate_user_id.value;
	var title=getLabel("eOT.NursingNotes.Label","OT");
	var facility_id = formObj.facility_id.value;//1
	var patient_id = formObj.patient_id.value;//2
	var episode_id = formObj.episode_id.value;//3
	var patient_class = formObj.patient_class.value;//4
	var encounter_id = formObj.encounter_id.value;//5
	var called_from = "OPERATIVE_NOTES";//6
	var accession_num=formObj.oper_num.value;//7
	var speciality_code=formObj.oper_speciality_code.value;//8
	//if(speciality_code=="*ALL") speciality_code="ALL";
	var locn_type = "";//from OPERATIVE_NOTES Locn type=NULL;
	var url = "../../eOT/jsp/SelectNoteTypeFrames.jsp?"+ "facility_id="+facility_id+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&encounter_id="+encounter_id+"&called_from="+called_from+"&accession_num="+accession_num+"&speciality_code="+speciality_code+"&locn_type="+locn_type+"&slate_user_id="+slate_user_id;
	var retVal;
	var dialogHeight = "5";
    var dialogWidth  = "20";
    var dialogTop    = "200";
    var dialogLeft   = "200";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	var arguments    = "" ;
	retVal 	   = await window.showModalDialog(url, arguments, features);
}

function changeTab(objStr){
	selectTab(objStr);
	var frmObj=document.forms[0];
	var param=frmObj.param.value;
	if(objStr=='OperationDetails' && parent.RecordFrame!=null ){
		parent.RecordFrame.location.href='../../eOT/jsp/ProcedureFrames.jsp?'+param;
		//parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	}else if(objStr=='PersonnelDetails' && parent.RecordFrame!=null ){
		//parent.RecordFrame.location.href='../../eOT/jsp/PersonnelFrames.jsp?'+param;
		parent.RecordFrame.location.href='../../eOT/jsp/PersonnelCommonFrames.jsp?'+param;
		//parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	}else if(objStr=='TimeAndDetails' && parent.RecordFrame!=null ){
		parent.RecordFrame.location.href='../../eOT/jsp/TimeDtlsFrames.jsp?'+param+"&tab_id=TimeAndDetailsTab";
		//parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	}/*else if(objStr=='Operative Records'){
	   alert("U N D E R C O N S T R U C T I O N");
	}*/else if(objStr=='SpecimenDetails' && parent.RecordFrame!=null){
	  parent.RecordFrame.location.href='../../eOT/jsp/SpecimenFrames.jsp?'+param;
	  //parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	}else if(objStr=='DisposalDetails' && parent.RecordFrame!=null){
	   parent.RecordFrame.location.href='../../eOT/jsp/NursingDisposalFrames.jsp?'+param;
	   //parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	}
	if(parent.parent.messageFrame!=null)
		parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
}

function Class_personnelrow()
{
	 this.speciality_code="";
	 this.speciality_desc="";
	 this.role_id ="";
	 this.role_desc ="";
	 this.role_type="";
	 this.practitioner_id="";
	 this.practitioner_name="";
	 this.position_desc="";
	 this.db_mode="";
	 this.recId ="";
}
function loadRoleDBRows(speciality_code,speciality_desc,role_id,role_desc,practitioner_id,practitioner_desc,recId,role_type,position_desc,mode){ 
	  var objrow = newRow();
	  var rows=parent.parent.parent.ObjectCollect.personnelrows;
	  var rowLength=parent.parent.parent.ObjectCollect.personnelrowLength;
	   if(rowLength==0){
		  objrow.speciality_code = speciality_code;
		  objrow.speciality_desc= speciality_desc;
		  objrow.role_id= role_id;
		  role_desc = role_desc; //Added Against SKR-SCF-1584
		  objrow.role_desc= unescape(role_desc);
		  objrow.practitioner_id= practitioner_id;
		  objrow.practitioner_name=unescape(practitioner_desc);
		  objrow.role_type=role_type;
		  objrow.position_desc=unescape(position_desc);
		  objrow.db_mode=mode;
		  objrow.recId=recId;
		  rows.push(objrow);
		}
}
function newRow()
{
	var objrow = new Class_personnelrow();
	//	if(typeof(parent.parent.parent.ObjectCollect) != "undefined" || parent.parent.parent.ObjectCollect != '' || parent.parent.parent.ObjectCollect != null)
	if(typeof(parent.parent.parent.ObjectCollect) != "undefined" && parent.parent.parent.ObjectCollect != '' && parent.parent.parent.ObjectCollect != null) //Modified Against SKR-SCF-1584
	{
		if(typeof(parent.parent.parent.ObjectCollect.personnelrows) != "undefined" && parent.parent.parent.ObjectCollect.personnelrows != '' && parent.parent.parent.ObjectCollect.personnelrows != null)
			objrow.recId = parent.parent.parent.ObjectCollect.personnelrows.length+1;
		else
			setTimeout('newRow()',500);
	}
	else
	{
		setTimeout('newRow()',500);
	}
	return(objrow);
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
		String facility_id = checkForNull(request.getParameter("facility_id"));
		String oper_num = checkForNull(request.getParameter("oper_num"));
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rst = null;
		ResultSet rst1 = null;
		//Added for CHL-CRF-0020.1 [IN:043132]
		PreparedStatement pstmt_hosp = null;
		ResultSet rst_hosp = null;
		String disp_hosp ="";
		//Added for CHL-CRF-0020.1 [IN:043132]
		Connection con = null;
		try
		{
			con = ConnectionManager.getConnection();
			//Added for CHL-CRF-0020.1 [IN:043132]
			String disp_hosp_sql = "select DISPLAY_HOSPITAL_YN from OT_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID =?";
				pstmt_hosp = con.prepareStatement(disp_hosp_sql);
				pstmt_hosp.setString(1, facility_id);
				rst_hosp = pstmt_hosp.executeQuery();
				while(rst_hosp.next()){
					disp_hosp=rst_hosp.getString(1);
				}
				if(rst_hosp!=null)rst_hosp.close();
				if(pstmt_hosp!=null)pstmt_hosp.close();
				//Added for CHL-CRF-0020.1 [IN:043132]
				pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_PERSONNEL_SELECT2"));
				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,locale);
				pstmt.setString(4,facility_id);
				pstmt.setString(5,oper_num);
				rst = pstmt.executeQuery();
				int index = 0;
				while(rst.next())
				{
					index++;
					Thread.sleep(1000);	 //Added against SKR-SCF-1596
					out.println("<script>loadRoleDBRows('"+rst.getString("SPECIALITY_CODE")+"','"+rst.getString("SPECIALITY_DESC")+"','"+rst.getString("ROLE_ID") +"','"+(rst.getString("ROLE_DESC"))+"','"+rst.getString("PRACTITIONER_ID")+"','"+rst.getString("PRACTITIONER_NAME")+"','"+index+"','"+rst.getString("ROLE_TYPE")+"','"+encode(CommonBean.checkForNull(rst.getString("POS_DESC")))+"','L'); </script>");
				}
				if(rst!=null)
					rst.close();
				if(pstmt!=null)
					pstmt.close();
				if(index == 0 && disp_hosp.equals("Y"))
				{
					String SQL2 = "SELECT SURGEON_CODE, GET_DESC(?,'AM_PRACTITIONER_LANG_VW','PRACTITIONER_NAME','PRACTITIONER_ID',SURGEON_CODE) " +  
						"PRACTITIONER_NAME, ANESTHETIST_CODE, GET_DESC(?,'AM_PRACTITIONER_LANG_VW','PRACTITIONER_NAME','PRACTITIONER_ID',ANESTHETIST_CODE) " + 
						"ANAESTHETIST_NAME, SPECIALITY_CODE, GET_DESC(?,'AM_SPECIALITY_LANG_VW','LONG_DESC','SPECIALITY_CODE',SPECIALITY_CODE) SPECIALITY_DESC, " + 
						"ASST_SURGEON_CODE,  GET_DESC(?,'AM_PRACTITIONER_LANG_VW','PRACTITIONER_NAME','PRACTITIONER_ID',ASST_SURGEON_CODE) " + 
						" ASST_SURGEON_NAME, ASST_SURGEON_CODE_2, GET_DESC(?,'AM_PRACTITIONER_LANG_VW','PRACTITIONER_NAME','PRACTITIONER_ID',ASST_SURGEON_CODE_2) " + 
						"ASST_SURGEON_NAME_2  FROM OT_POST_OPER_HDR HDR WHERE OPERATING_FACILITY_ID = ? AND OPER_NUM =  ?";

					String ROLE_SQL = "SELECT ROLE_DESC, ROLE_ID, ROLE_TYPE FROM OT_ROLES_LANG_VW WHERE LANGUAGE_ID= ? AND ROLE_TYPE IN ('OS', 'MA', 'AS')"
							+ "AND NVL(APPL_TO_OT_SLATE,'N') = 'N' AND NVL(STATUS,'E') = 'E'";
					pstmt1 = con.prepareStatement(ROLE_SQL);
					pstmt1.setString(1, locale);
					rst1 = pstmt1.executeQuery();
					if(pstmt!=null)
						pstmt.close();
					pstmt = con.prepareStatement(SQL2);
					pstmt.setString(1,locale);
					pstmt.setString(2,locale);
					pstmt.setString(3,locale);
					pstmt.setString(4,locale);
					pstmt.setString(5,locale);
					pstmt.setString(6,facility_id);
					pstmt.setString(7,oper_num);
					rst = pstmt.executeQuery();
					index = 0;
					//count of 
					int surgCount = 0;
					int anasCount = 0;
					int assSurgCount = 0;
					if(rst.next())
					{
						while(rst1.next() )
						{
							String roleId = rst1.getString("ROLE_TYPE");
							String specCode = rst.getString("SPECIALITY_CODE");
							String specDesc = rst.getString("SPECIALITY_DESC");
							String surgCode = rst.getString("SURGEON_CODE");
							//if( disp_hosp.equals("Y")){//Added for CHL-CRF-0020.1 [IN:043132]
							if("OS".equals(roleId) && surgCode != null && (surgCount == 0))
							{
								index++;
								surgCount++;
								Thread.sleep(1000);	 //Added against SKR-SCF-1744
								out.println("<script>loadRoleDBRows('"+ specCode +"','"+ specDesc +"','"+rst1.getString("ROLE_ID") 
										+"','"+rst1.getString("ROLE_DESC")+"','" + surgCode +"','" 
										+rst.getString("PRACTITIONER_NAME")+"','"+index+"','"+rst1.getString("ROLE_TYPE")+"', '', 'I'"
										+ "); </script>");
							}
							//}//Added for CHL-CRF-0020.1 [IN:043132]
							String asstSurgCode = rst.getString("ASST_SURGEON_CODE"); 
							if("AS".equals(roleId) && asstSurgCode != null && assSurgCount <= 1)
							{
								index++;
								assSurgCount++;
								Thread.sleep(1000);	 //Added against SKR-SCF-1744
								out.println("<script>loadRoleDBRows('"+ specCode +"','"+ specDesc +"','"+rst1.getString("ROLE_ID") 
								+"','"+(rst1.getString("ROLE_DESC"))+"','"+ asstSurgCode +"','" 
								+encode(rst.getString("ASST_SURGEON_NAME"))+"','"+index+"','"+rst1.getString("ROLE_TYPE")+"', '', 'I'"
								+ "); </script>");
							}
							asstSurgCode = rst.getString("ASST_SURGEON_CODE_2"); 
							if("AS".equals(roleId) && asstSurgCode != null && assSurgCount <= 1)
							{
								index++;
								assSurgCount++;
								Thread.sleep(1000);	 //Added against SKR-SCF-1744
								out.println("<script>loadRoleDBRows('"+ specCode +"','"+ specDesc +"','"+rst1.getString("ROLE_ID") 
								+"','"+(rst1.getString("ROLE_DESC"))+"','"+ asstSurgCode +"','" 
								+ encode(rst.getString("ASST_SURGEON_NAME_2"))+"','"+index+"','"+rst1.getString("ROLE_TYPE")+"', '', 'I'"
								+ "); </script>");
							}
							String anansCode = rst.getString("ANESTHETIST_CODE");
							if("MA".equals(roleId) && anansCode != null && anasCount == 0)
							{
								index++;
								anasCount++;
								Thread.sleep(1000);	 //Added against SKR-SCF-1744
								out.println("<script>loadRoleDBRows('"+ specCode +"','"+ specDesc +"','"+rst1.getString("ROLE_ID") 
								+"','"+(rst1.getString("ROLE_DESC"))+"','"+ anansCode +"','" 
								+ encode(rst.getString("ANAESTHETIST_NAME"))+"','"+index+"','"+rst1.getString("ROLE_TYPE")+"','', 'I'"
								+ "); </script>");
							}
						//	}//Added for CHL-CRF-0020.1 [IN:043132]
						}
					}
			}			
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Err Msg from RecordSurgeonTab.jsp "+e);
		}finally{
			if(rst!=null)rst.close();
			if(rst1!=null)rst1.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)con.close();
		}
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onload='loadOthrFrames();'> <!-- Onload Function Added Against SKR-SCF-1584-->
<form name="RecordNursingTabForm" id="RecordNursingTabForm">
	<table id="tab" cellspacing=0 cellpadding=3 border="0" width='100%' align='center'>
	<tr>
		<td width="100%" class="white">
			<ul id='tablist' class='tablist'>
				<li class='tablistitem' title='<fmt:message key="eOT.OperationDetails.Label" bundle="${ot_labels}"/>'>
					<a onclick="changeTab('OperationDetails')" class="tabclicked" id="OperationDetails">
						<span class="tabSpanclicked" id="OperationDetailsspan">
							<fmt:message key="eOT.OperationDetails.Label" bundle="${ot_labels}"/></span></a>
				</li>
				<li class="tablistitem" title='<fmt:message key="eOT.PersonnelDetails.Label" bundle="${ot_labels}"/>'>
					<a onclick="changeTab('PersonnelDetails')" class="tabA" id="PersonnelDetails">
						<span class="tabAspan" id="PersonnelDetailsspan">
							<fmt:message key="eOT.PersonnelDetails.Label" bundle="${ot_labels}"/></span></a>
				</li>
				<li class="tablistitem" title='<fmt:message key="eOT.TimeandDetails.Label" bundle="${ot_labels}"/>'>
					<a onclick="changeTab('TimeAndDetails')" class="tabA" id="TimeAndDetails">
						<span class="tabAspan" id="TimeAndDetailsspan">
						<fmt:message key="eOT.TimeandDetails.Label" bundle="${ot_labels}"/></span></a>
				</li>
				<li class="tablistitem" title='<fmt:message key="Common.SpecimenDetails.label" bundle="${common_labels}"/>'>
					<a onclick="changeTab('SpecimenDetails')" class="tabA" id="SpecimenDetails">
						<span class="tabAspan" id="SpecimenDetailsspan">
							<fmt:message key="Common.SpecimenDetails.label" bundle="${common_labels}"/></span></a>
				</li>
				<li class="tablistitem" title='<fmt:message key="eOT.DisposalDetails.Label" bundle="${ot_labels}"/>'>
					<a onclick="changeTab('DisposalDetails')" class="tabA" id="DisposalDetails">
						<span class="tabAspan" id="DisposalDetailsspan">
							<fmt:message key="eOT.DisposalDetails.Label" bundle="${ot_labels}"/></span></a>
				</li>
			</ul>
		</td>
		<!--<td align="right" cellspacing="0" cellpadding=3="0">
			<input type="button" class="button" value="Nursing Notes" name="nursing_notes" id="nursing_notes" onclick="callOperativeNotes();">
		</td>-->
		<!-- <td class="fields" cellspacing="0" cellpadding=3>
			<input type="button" class="button" value='<fmt:message key="eOT.OperativeRecords.Label" bundle="${ot_labels}"/>' name="operative_records" onclick="callOperativeNotes();">
		</td> Commented by Sathish.K on 13-03-2009 for Amazonchanges this button is transferred to CommonOperDtlsHdr.jsp as a hyperlink showing  there-->
	</tr>
</table>
<input type='hidden' name='param' id='param' value='<%=request.getQueryString()%>'>
<input type='hidden' name='slate_user_id' id='slate_user_id' value='<%=request.getParameter("slate_user_id")%>'>
<input type='hidden' name='doc_oper_line_sent' id='doc_oper_line_sent' value=''>
<input type='hidden' name='Speciality_code_val' id='Speciality_code_val' value=''>
<!-- Added for CHL-CRF-0020.1 [IN:043132] -->
<input type='hidden' name='disp_hosp' id='disp_hosp' value="<%=disp_hosp%>">
<!-- The below line is required to change the select state of Initial tab selected -->
<script>prevTabObj='OperationDetails'</script>
<script>
function loadOthrFrames()//Added Against SKR-SCF-1584
{
	var params = document.forms[0].param.value;
	parent.RecordFrame.location.href="../../eOT/jsp/ProcedureFrames.jsp?"+params;
	parent.doc_status_frame.location.href="../../eOT/jsp/SurgeonDocStatus.jsp?"+params;
}
</script>
</form>
</body>
</html>

