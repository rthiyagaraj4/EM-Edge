<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           created
29/11/2012  IN035950      Nijitha        CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
					 more appealing. Keeping the display of information more clear and visible.
07/12/2012  IN030460	  Nijitha	 BRU-HIMS-CRF-019		
24/01/2012	IN036001	  Chowminya G	 Record Diagnosis in Thai language screen.Data lang not changed			 
12/02/2013	IN030459	  Karthi L	 	To show diagnosis list with the encounter information in Chart Summary
07/06/2013  IN037737	  Nijitha S  ML-BRU-SCF-0682
15/10/2013	IN043924	  Vijayakumar K Alpha-CA>Patient Without Encounter>Chief Complaint recorded for the patient is not displayed
02/06/2014	IN037701	  Nijitha		SKR-CRF-0036
07/05/2015  IN055047 	  AAKH-SCF-0197
10/11/2017  IN061896	  kamalakannan G  System should show date/time in diagnosis widget
16/11/2017	IN65780   Kamalakannan G  Data/Time column color change 
--------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------
28/06/2018	IN065341		Prakash C	29/06/2018		Ramesh G 		MMS-DM-CRF-0115
21/08/2018	IN067855		Ramya       22/08/2018		Ramesh G 		ML-MMOH-CRF-1202
30/01/2019	IN069327		Prakash C   30/01/2019		Ramesh G 		ML-MMOH-CRF-1281.1
23/03/2023  38981        Krishna Pranay   23/03/2023     Ramesh G     ML-MMOH-CRF-1986
30/03/2023  42995        Krishna Pranay   30/03/2023     Ramesh G    CA-ML-MMOH-CRF-1986


---------------------------------------------------------------------------------------------------------
-------------->
<%@ page import="java.sql.*, java.text.*,eCommon.Common.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
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
String p_called_from = (request.getParameter("p_called_from") == null) ? "" : request.getParameter("p_called_from");//IN037701
%>
<!--IN037701 Start-->
<%if(!"CA_SPC".equals(p_called_from)){%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<%}%>
	<!--IN037701 Ends-->
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
<title><%=title%></title><!-- [IN035950] -->
<link rel='StyleSheet' href='../../eCommon/html/<%=sessionStyle%>' type='text/css' />

   	<script src='../../eCommon/js/common.js' language='javascript'></script>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src="../../eCA/js/ResearchPatient.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%String context_value=request.getParameter("PQ");if (context_value==null) context_value="Y";
		//String facility_id= (String) session.getValue("facility_id");//commented for IN065341
		String loginuser=(String) session.getValue( "login_user" ) ;  //IN037701
		java.util.Properties property = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) property.getProperty("LOCALE");
		%>
	<script>
	
			var detailArray = new Array();
			async function showProblem(Patient_Id,term_code,term_set_id,short_desc,Encounter_Id)
			{
			//alert('here');
			var dialogHeight=20;
			var dialogWidth=30;
			//var title			= getLabel("Common.ChiefComplaint.label","Common")+" "+(getLabel("Common.Problem.label","Common"));
			var features='dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=auto; status=no';
			retVal=await window.showModalDialog("../../eMR/jsp/selectProblemFrames.jsp?callFunction=showProblem&patient_id="+Patient_Id+"&encounter_id="+Encounter_Id+"&term_code="+term_code+"&term_set_id="+term_set_id+"&short_desc="+short_desc+" "	,arguments,features);
			}


			async function CallAuathorize(patientid,mode,authorize)
			{
				var p_called_from = document.getElementById("p_called_from").value;//IN037701
				if(authorize == 'Y')
				{
					var params='<%=request.getQueryString()%>';
					var ind= params.lastIndexOf("&authorize");
					if(ind!=-1)
						params=params.substring(0,ind);
					params+="&authorize=N";
					window.location.href='ChartSummaryActiveProblemsD.jsp?'+params;//IN037701
					
				}
				else
				{
					var val1 = 'V' ;
					var val2 = 'Ass' ;
					var val3='C'
					if('<%=context_value%>'=="PatientQueue")
						val3="O";
					var val = val1+'/'+val2+'/'+val3+'/';

					var retVal = 	new String();
					var dialogHeight= "30vh" ;
					var dialogWidth	= "30vw" ;
					var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
					var arguments	= "" ;
					
					retVal = await top.window.showModalDialog("AuthorizeMRAccess.jsp?constr="+val,arguments,features);

					if(retVal=="T"){
						
						var params='<%=request.getQueryString()%>';
						var ind= params.lastIndexOf("&authorize");
						if(ind!=-1)
							params=params.substring(0,ind);
						params+="&authorize=Y";
						window.location.href='ChartSummaryActiveProblemsD.jsp?'+params;//IN037701
					}
					else{
						var params='<%=request.getQueryString()%>';
						var ind= params.lastIndexOf("&authorize");
							if(ind!=-1)
						params=params.substring(0,ind);
						params+="&authorize=N";
						window.location.href='ChartSummaryActiveProblemsD.jsp?'+params;//IN037701
					}
				}
			
			}
	
	function callMouseOverDiag(obj,index)
	{
		
		var tabdata = '<table class="grid" cellpadding=0 cellspacing=0 border=1><tr><td class=columnHeadercenter nowrap><fmt:message key="Common.Complaint.label" bundle="${common_labels}"/>&nbsp;</td><td class=columnHeadercenter nowrap>&nbsp;<fmt:message key="Common.Complaint.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/>&nbsp;</td><td class=columnHeadercenter nowrap>&nbsp;<fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></td></tr>';

			tabdata +=detailArray[index]+"</table>";
			document.getElementById("details").innerHTML = tabdata;

				var wdth 	  = obj.offsetWidth;
				var hght1 	  = obj.offsetHeight;

				var wdth1 = getPos(obj).x - wdth;
				var hght = getPos(obj).y + hght1;
				
				document.getElementById("details").style.posTop  = hght;
				document.getElementById("details").style.posLeft  = wdth1;
				document.getElementById("details").style.visibility = 'visible' ;
					

	}
	function callOnMouseOutDiag(obj)
	{
		document.getElementById("details").style.visibility='hidden' ;
	}

	function getPos(inputElement)
	{
		var coords =  new Object();
		coords.x = 0;
		coords.y = 0;
		try
		{
			targetElement = inputElement;
			if(targetElement.x && targetElement.y)
			{
				coords.x = targetElement.x;
				coords.y = targetElement.y;
			}
			else
			{
				if(targetElement.offsetParent)
				{
					coords.x += targetElement.offsetLeft;
					coords.y += targetElement.offsetTop;
					while(targetElement = targetElement.offsetParent)
					{
						coords.x += targetElement.offsetLeft;
						coords.y += targetElement.offsetTop;
					}
				}
				else
				{
					//alert("Could not find any reference for coordinate positioning.");
				}
			}
			return coords;
		}
		catch(error)
		{
			return coords;
		}
	}	
		</script>
	<!--IN037737 Starts-->
	<style>
	.highlite
	{
	border-left:2px;
	border-right:2px;
	border-top:2px;
	border-bottom:2px;
	border-color:blue;
	border-style:solid;
	}
	</style>
	<!--IN037737 Ends-->
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">


<%

	Connection conn= null;

	PreparedStatement stmt =null, stmt1 = null,stmt2 = null,stmt3=null; // PreparedStatement stmt_11=null;
//	ResultSet rs	 =null, rs_11=null, rs1 = null,rs2 = null;
	ResultSet rs	 =null, rs1 = null,rs2 = null,rs3=null;
//	boolean rsval= true;
	String onset_date = "";//IN037701
	String diag_class_desc = "";//IN037701
	String onset_pract_name ="";//IN037701
	String curr_remarks="";//38981
	if (context_value ==null) context_value ="O";
	boolean isSiteSpecific=false;//IN069327

	String diagdesc ="";
	String patientid=request.getParameter("patient_id");
	//IN065341 starts
	String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
	String encounter_id="";
	String facility_id="";
	if(called_from.equals("CDR")){
		 encounter_id = request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");
		 facility_id = request.getParameter("facility_id1")==null?"":request.getParameter("facility_id1");
	}else{//IN065341 ends
		 encounter_id=request.getParameter("encounter_id");
		 facility_id= (String) session.getValue("facility_id");
	}//IN065341
	String mode=request.getParameter("mode");
	
	String authorize = (request.getParameter("authorize")==null)?"N":request.getParameter("authorize");

	String contentId = request.getParameter("content_ID"); // added for CRF-018
	String f_authorize_yn="N";
    String classValue="";
    String termSetDesc="";
    String termSetDesc_prev="";
    String complaint_id="";
    String complaint_desc="";
    String onset_datetime="";//IN061896
//    String prob_cnt_str="";
    String diag_code="";
    String term_set_id="";
    String short_desc="";
    String curr_enc_yn="";
    String oh_accession_num="";
    String support_exisist_yn="";//38981
//	String oh_chart_num ="";
	String curr_accuracy_ind ="";
	String term_code_short_desc ="";
    	String term_code_short_desc_1 ="";//IN067855
	String complaint_id_lyr ="";
	String complaint_desc_lyr ="";
	String onset_datetime_lyr ="";
	String diag_code_disp ="";
	String occur_srl_no ="";
	String linkviewcnt_sql = "";
	int view_cnt = 0;
	int prob_cnt=0;
	int index=0;
	String high_risk_code="";//IN030460
	StringBuffer layer = new StringBuffer();
	int recordCount =0;//IN035950
	if(mode==null)
	{
	
		f_authorize_yn="N";
	}

try
{

	conn = ConnectionManager.getConnection(request);
	//IN069327 starts	
	 isSiteSpecific = CommonBean.isSiteSpecific(conn, "MR","ALLOW_MULTI_DESC");
	//IN069327 ends
//	String scheme="";
	String sensitive_exist_yn="N";
	//String SqlFindSensitive ="Select 'Y' from PR_DIAGNOSIS A,MR_TERM_CODE D WHERE D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE=A.TERM_CODE and patient_id=? and  nvl(A.CURR_STATUS,'O') = 'A' and nvl(sensitive_yn,'N') ='Y' AND ROWNUM=1 ";
	String SqlFindSensitive ="Select 'Y' from PR_DIAGNOSIS ##REPDB## A,MR_TERM_CODE ##REPDB## D WHERE D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE=A.TERM_CODE and patient_id=? and  nvl(A.CURR_STATUS,'O') = 'A' and nvl(sensitive_yn,'N') ='Y' AND ROWNUM=1 ";//IN065341
	SqlFindSensitive=SqlFindSensitive.replaceAll("##REPDB##", RepDb);//IN065341

	stmt = conn.prepareStatement(SqlFindSensitive);
	stmt.setString(1,patientid);
	rs = stmt.executeQuery();
	while(rs.next())
		sensitive_exist_yn = rs.getString(1) == null ? "N" : rs.getString(1);

	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
// IN037701 Start.
	if("CA_SPC".equals(p_called_from)){
	//IN065341 starts
		//stmt = conn.prepareStatement("SELECT VW_SEN_DIAG_FOR_CONS_PAT_YN access_rights_yn FROM MR_USER_ACCESS_RIGHTS WHERE APPL_USER_ID=? AND FACILITY_ID=?");
		String sql1 = "SELECT VW_SEN_DIAG_FOR_CONS_PAT_YN access_rights_yn FROM MR_USER_ACCESS_RIGHTS ##REPDB## WHERE APPL_USER_ID=? AND FACILITY_ID=?";
		sql1=sql1.replaceAll("##REPDB##", RepDb);
		stmt = conn.prepareStatement(sql1);
	//IN065341 ends
		stmt.setString(1,loginuser);
		stmt.setString(2,facility_id);
		rs = stmt.executeQuery();
		while(rs.next())
			authorize = (String)rs.getString("access_rights_yn");
		sensitive_exist_yn = "N";
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
	}
//IN037701 End.	
	//String Sql="SELECT A.TERM_SET_ID,A.OCCUR_SRL_NO, to_char(A.ONSET_DATE,'dd/mm/yyyy') onset_date, D.sensitive_yn, D.SHORT_DESC||'('|| A.TERM_CODE||')'||NVL2(A.CURR_REMARKS,'<br><B>Remarks</B>:'||CURR_REMARKS,null)  diag_desc,a.TERM_CODE_SHORT_DESC, A.TERM_CODE diag_code, C.TERM_SET_DESC diag_scheme,C.TERM_SET_DESC diag_code_scheme_desc,(SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL g where g.TERM_SET_ID=A.TERM_SET_ID and (g.TERM_CODE=A.TERM_CODE OR g.TERM_CODE_SHORT_DESC=A.TERM_CODE_SHORT_DESC) AND  ENCOUNTER_ID=? AND  FACILITY_ID=? ) prob_cnt,NVL((select 'Y' from PR_DIAGNOSIS_STATUS where patient_id =a.patient_id and term_set_id=a.term_set_id and term_code  =a.term_code and occur_srl_no =a.occur_srl_no and facility_id=? and encounter_id=? and rownum=1),'N')	curr_enc_yn,a.accession_num,a.curr_accuracy_ind FROM PR_DIAGNOSIS A,MR_TERM_CODE D, MR_TERM_SET C where C.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE=A.TERM_CODE and patient_id=? and  nvl(A.CURR_STATUS,'O') = 'A' and nvl(sensitive_yn,'N')=decode(?,'N','N',NVL(sensitive_yn,'N')) /*and A.TERM_SET_ID=?  and nvl(A.ONSET_STATUS,'N')='N'  and close_date is null */ order by A.ONSET_DATE desc,diag_scheme";//IN030460
	//String Sql="SELECT A.TERM_SET_ID,A.OCCUR_SRL_NO, to_char(A.ONSET_DATE,'dd/mm/yyyy') onset_date, D.sensitive_yn, D.SHORT_DESC||'('|| A.TERM_CODE||')'||NVL2(A.CURR_REMARKS,'<br><B>Remarks</B>:'||CURR_REMARKS,null)  diag_desc,a.TERM_CODE_SHORT_DESC, A.TERM_CODE diag_code, C.TERM_SET_DESC diag_scheme,C.TERM_SET_DESC diag_code_scheme_desc,(SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL g where g.TERM_SET_ID=A.TERM_SET_ID and (g.TERM_CODE=A.TERM_CODE OR g.TERM_CODE_SHORT_DESC=A.TERM_CODE_SHORT_DESC) AND  ENCOUNTER_ID=? AND  FACILITY_ID=? ) prob_cnt,NVL((select 'Y' from PR_DIAGNOSIS_STATUS where patient_id =a.patient_id and term_set_id=a.term_set_id and term_code  =a.term_code and occur_srl_no =a.occur_srl_no and facility_id=? and encounter_id=? and rownum=1),'N')	curr_enc_yn,a.accession_num,a.curr_accuracy_ind,d.HIGH_RISK_CODE FROM PR_DIAGNOSIS A,MR_TERM_CODE D, MR_TERM_SET C where C.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE=A.TERM_CODE and patient_id=? and  nvl(A.CURR_STATUS,'O') = 'A' and nvl(sensitive_yn,'N')=decode(?,'N','N',NVL(sensitive_yn,'N')) /*and A.TERM_SET_ID=?  and nvl(A.ONSET_STATUS,'N')='N'  and close_date is null */ order by A.ONSET_DATE desc,diag_scheme";//IN030460
	//String Sql="SELECT A.TERM_SET_ID,A.OCCUR_SRL_NO, to_char(A.ONSET_DATE,'dd/mm/yyyy') onset_date, D.sensitive_yn, D.SHORT_DESC||'('|| A.TERM_CODE||')'||NVL2(A.CURR_REMARKS,'<br><B>Remarks</B>:'||CURR_REMARKS,null)  diag_desc,mr_get_desc.mr_term_code (a.term_set_id, a.term_code,'"+locale+"','2' ) TERM_CODE_SHORT_DESC, A.TERM_CODE diag_code, C.TERM_SET_DESC diag_scheme,C.TERM_SET_DESC diag_code_scheme_desc,(SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL g where g.TERM_SET_ID=A.TERM_SET_ID and (g.TERM_CODE=A.TERM_CODE OR g.TERM_CODE_SHORT_DESC=A.TERM_CODE_SHORT_DESC) AND  ENCOUNTER_ID=? AND  FACILITY_ID=? ) prob_cnt,NVL((select 'Y' from PR_DIAGNOSIS_STATUS where patient_id =a.patient_id and term_set_id=a.term_set_id and term_code  =a.term_code and occur_srl_no =a.occur_srl_no and facility_id=? and encounter_id=? and rownum=1),'N')	curr_enc_yn,a.accession_num,a.curr_accuracy_ind,d.HIGH_RISK_CODE FROM PR_DIAGNOSIS A,MR_TERM_CODE D, MR_TERM_SET C where C.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE=A.TERM_CODE and patient_id=? and  nvl(A.CURR_STATUS,'O') = 'A' and nvl(sensitive_yn,'N')=decode(?,'N','N',NVL(sensitive_yn,'N')) /*and A.TERM_SET_ID=?  and nvl(A.ONSET_STATUS,'N')='N'  and close_date is null */ order by A.ONSET_DATE desc,diag_scheme";//IN030460//IN036001 //Commented for IN030459 CRF -019
	
	//String Sql= "SELECT   A.TERM_SET_ID, A.OCCUR_SRL_NO, TO_CHAR (A.ONSET_DATE, 'dd/mm/yyyy') onset_date, D.sensitive_yn, ONSET_LOCN_CODE, ONSET_LOCN_TYPE, D.SHORT_DESC || '(' || A.TERM_CODE || ')'|| NVL2 (A.CURR_REMARKS, '<br><B>Remarks</B>:' || CURR_REMARKS, NULL) diag_desc, mr_get_desc.mr_term_code (a.term_set_id, a.term_code, '"+locale+"','2') TERM_CODE_SHORT_DESC,A.TERM_CODE diag_code, C.TERM_SET_DESC diag_scheme, C.TERM_SET_DESC diag_code_scheme_desc,(SELECT COUNT ( * ) FROM  PR_DIAGNOSIS_COMPL_ENC_DTL g WHERE g.TERM_SET_ID = A.TERM_SET_ID AND (g.TERM_CODE = A.TERM_CODE OR g.TERM_CODE_SHORT_DESC = A.TERM_CODE_SHORT_DESC) AND ENCOUNTER_ID = ? AND FACILITY_ID = ?) prob_cnt, NVL((SELECT 'Y' FROM PR_DIAGNOSIS_STATUS WHERE patient_id = a.patient_id AND term_set_id = a.term_set_id AND term_code = a.term_code AND occur_srl_no = a.occur_srl_no AND facility_id = ? AND encounter_id = ? AND ROWNUM = 1), 'N') curr_enc_yn, a.accession_num, a.curr_accuracy_ind, d.HIGH_RISK_CODE,(SELECT COUNT( * ) FROM PR_DIAGNOSIS_STATUS WHERE patient_id = a.patient_id AND term_set_id = a.term_set_id AND term_code = a.term_code AND occur_srl_no = a.occur_srl_no AND facility_id = ?) ENC_CNT FROM PR_DIAGNOSIS A, MR_TERM_CODE D, MR_TERM_SET C WHERE C.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_CODE = A.TERM_CODE AND A.patient_id = ? AND NVL (A.CURR_STATUS, 'O') = 'A' AND NVL (sensitive_yn, 'N') = DECODE (?, 'N', 'N', NVL (sensitive_yn, 'N')) /*and A.TERM_SET_ID=? and nvl(A.ONSET_STATUS,'N')='N' and close_date is null */ ORDER BY A.ONSET_DATE DESC, diag_scheme"; // modified for CRF - 019 IN030459
	//String Sql= "SELECT   A.TERM_SET_ID, A.OCCUR_SRL_NO, TO_CHAR (A.ONSET_DATE, 'dd/mm/yyyy hh24:mi') onset_date, D.sensitive_yn, ONSET_LOCN_CODE, ONSET_LOCN_TYPE, D.SHORT_DESC || '(' || A.TERM_CODE || ')'|| NVL2 (A.CURR_REMARKS, '<br><B>Remarks</B>:' || CURR_REMARKS, NULL) diag_desc, mr_get_desc.mr_term_code (a.term_set_id, a.term_code, '"+locale+"','2') TERM_CODE_SHORT_DESC,A.TERM_CODE diag_code, C.TERM_SET_DESC diag_scheme, C.TERM_SET_DESC diag_code_scheme_desc,(SELECT COUNT ( * ) FROM  PR_DIAGNOSIS_COMPL_ENC_DTL g WHERE g.TERM_SET_ID = A.TERM_SET_ID AND (g.TERM_CODE = A.TERM_CODE OR g.TERM_CODE_SHORT_DESC = A.TERM_CODE_SHORT_DESC) AND ENCOUNTER_ID = ? AND FACILITY_ID = ?) prob_cnt, NVL((SELECT 'Y' FROM PR_DIAGNOSIS_ENC_DTL WHERE patient_id = a.patient_id AND term_set_id = a.term_set_id AND term_code = a.term_code AND occur_srl_no = a.occur_srl_no AND facility_id = ? AND encounter_id = ? AND ROWNUM = 1 AND status in ('A','R')), 'N' ) curr_enc_yn, a.accession_num, a.curr_accuracy_ind, d.HIGH_RISK_CODE,(SELECT COUNT( * ) FROM PR_DIAGNOSIS_STATUS WHERE patient_id = a.patient_id AND term_set_id = a.term_set_id AND term_code = a.term_code AND occur_srl_no = a.occur_srl_no AND facility_id = ?) ENC_CNT,(select short_desc from MR_DIAG_CLASS_LANG_VW where diag_class_code = a.diag_class_code and language_id = ?) diag_class_desc,AM_GET_DESC.AM_PRACTITIONER(a.ONSET_PRACTITIONER_ID,?,1) onset_pract_name FROM PR_DIAGNOSIS A, MR_TERM_CODE D, MR_TERM_SET C WHERE C.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_CODE = A.TERM_CODE AND A.patient_id = ? AND NVL (A.CURR_STATUS, 'O') = 'A' AND NVL (sensitive_yn, 'N') = DECODE (?, 'N', 'N', NVL (sensitive_yn, 'N'))  ORDER BY A.ONSET_DATE DESC, diag_scheme"; //  // modified for CRF - 019 IN030459//Changed table name to retrieve curr_enc_yn//commented for IN065341
	//String Sql= "SELECT   A.TERM_SET_ID, A.OCCUR_SRL_NO, TO_CHAR (A.ONSET_DATE, 'dd/mm/yyyy hh24:mi') onset_date, D.sensitive_yn, ONSET_LOCN_CODE, ONSET_LOCN_TYPE, D.SHORT_DESC || '(' || A.TERM_CODE || ')'|| NVL2 (A.CURR_REMARKS, '<br><B>Remarks</B>:' || CURR_REMARKS, NULL) diag_desc, mr_get_desc.mr_term_code ##REPDB##(a.term_set_id, a.term_code, '"+locale+"','2') TERM_CODE_SHORT_DESC, A.TERM_CODE diag_code, C.TERM_SET_DESC diag_scheme, C.TERM_SET_DESC diag_code_scheme_desc,(SELECT COUNT ( * ) FROM  PR_DIAGNOSIS_COMPL_ENC_DTL ##REPDB## g WHERE g.TERM_SET_ID = A.TERM_SET_ID AND (g.TERM_CODE = A.TERM_CODE OR g.TERM_CODE_SHORT_DESC = A.TERM_CODE_SHORT_DESC) AND ENCOUNTER_ID = ? AND FACILITY_ID = ?) prob_cnt, NVL((SELECT 'Y' FROM PR_DIAGNOSIS_ENC_DTL ##REPDB## WHERE patient_id = a.patient_id AND term_set_id = a.term_set_id AND term_code = a.term_code AND occur_srl_no = a.occur_srl_no AND facility_id = ? AND encounter_id = ? AND ROWNUM = 1 AND status in ('A','R')), 'N' ) curr_enc_yn, a.accession_num, a.curr_accuracy_ind, d.HIGH_RISK_CODE,(SELECT COUNT( * ) FROM PR_DIAGNOSIS_STATUS ##REPDB## WHERE patient_id = a.patient_id AND term_set_id = a.term_set_id AND term_code = a.term_code AND occur_srl_no = a.occur_srl_no AND facility_id = ?) ENC_CNT,(select short_desc from MR_DIAG_CLASS_LANG_VW ##REPDB## where diag_class_code = a.diag_class_code and language_id = ?) diag_class_desc,AM_GET_DESC.AM_PRACTITIONER ##REPDB##(a.ONSET_PRACTITIONER_ID,?,1) onset_pract_name FROM PR_DIAGNOSIS ##REPDB## A, MR_TERM_CODE ##REPDB## D, MR_TERM_SET ##REPDB## C WHERE C.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_CODE = A.TERM_CODE AND A.patient_id = ? AND NVL (A.CURR_STATUS, 'O') = 'A' AND NVL (sensitive_yn, 'N') = DECODE (?, 'N', 'N', NVL (sensitive_yn, 'N'))  ORDER BY A.ONSET_DATE DESC, diag_scheme";//IN065341//commented for IN067855
	 // String Sql= "SELECT   A.TERM_SET_ID, A.OCCUR_SRL_NO, TO_CHAR (A.ONSET_DATE, 'dd/mm/yyyy hh24:mi') onset_date, D.sensitive_yn, ONSET_LOCN_CODE, ONSET_LOCN_TYPE, D.SHORT_DESC || '(' || A.TERM_CODE || ')'|| NVL2 (A.CURR_REMARKS, '<br><B>Remarks</B>:' || CURR_REMARKS, NULL) diag_desc,mr_get_desc.mr_term_code ##REPDB##(a.term_set_id, a.term_code, '"+locale+"','2') TERM_CODE_SHORT_DESC, A.TERM_CODE_SHORT_DESC TERM_CODE_SHORT_DESC_1,A.TERM_CODE diag_code, C.TERM_SET_DESC diag_scheme, C.TERM_SET_DESC diag_code_scheme_desc,(SELECT COUNT ( * ) FROM  PR_DIAGNOSIS_COMPL_ENC_DTL ##REPDB## g WHERE g.TERM_SET_ID = A.TERM_SET_ID AND (g.TERM_CODE = A.TERM_CODE OR g.TERM_CODE_SHORT_DESC = A.TERM_CODE_SHORT_DESC) AND ENCOUNTER_ID = ? AND FACILITY_ID = ?) prob_cnt, NVL((SELECT 'Y' FROM PR_DIAGNOSIS_ENC_DTL ##REPDB## WHERE patient_id = a.patient_id AND term_set_id = a.term_set_id AND term_code = a.term_code AND occur_srl_no = a.occur_srl_no AND facility_id = ? AND encounter_id = ? AND ROWNUM = 1 AND status in ('A','R')), 'N' ) curr_enc_yn, a.accession_num, a.curr_accuracy_ind, d.HIGH_RISK_CODE,(SELECT COUNT( * ) FROM PR_DIAGNOSIS_STATUS ##REPDB## WHERE patient_id = a.patient_id AND term_set_id = a.term_set_id AND term_code = a.term_code AND occur_srl_no = a.occur_srl_no AND facility_id = ?) ENC_CNT,(select short_desc from MR_DIAG_CLASS_LANG_VW ##REPDB## where diag_class_code = a.diag_class_code and language_id = ?) diag_class_desc,AM_GET_DESC.AM_PRACTITIONER ##REPDB##(a.ONSET_PRACTITIONER_ID,?,1) onset_pract_name FROM PR_DIAGNOSIS ##REPDB## A, MR_TERM_CODE ##REPDB## D, MR_TERM_SET ##REPDB## C WHERE C.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_CODE = A.TERM_CODE AND A.patient_id = ? AND NVL (A.CURR_STATUS, 'O') = 'A' AND NVL (sensitive_yn, 'N') = DECODE (?, 'N', 'N', NVL (sensitive_yn, 'N'))  ORDER BY A.ONSET_DATE DESC, diag_scheme";//IN067855
		//  String Sql= "SELECT   A.TERM_SET_ID, A.OCCUR_SRL_NO,A.CURR_REMARKS, TO_CHAR (A.ONSET_DATE, 'dd/mm/yyyy hh24:mi') onset_date, D.sensitive_yn, ONSET_LOCN_CODE, ONSET_LOCN_TYPE, D.SHORT_DESC || '(' || A.TERM_CODE || ')'|| NVL2 (A.CURR_REMARKS, '<br><B>Remarks</B>:' || CURR_REMARKS, NULL) diag_desc,mr_get_desc.mr_term_code ##REPDB##(a.term_set_id, a.term_code, '"+locale+"','2') TERM_CODE_SHORT_DESC, A.TERM_CODE_SHORT_DESC TERM_CODE_SHORT_DESC_1,A.TERM_CODE diag_code, C.TERM_SET_DESC diag_scheme, C.TERM_SET_DESC diag_code_scheme_desc,(SELECT COUNT ( * ) FROM  PR_DIAGNOSIS_COMPL_ENC_DTL ##REPDB## g WHERE g.TERM_SET_ID = A.TERM_SET_ID AND (g.TERM_CODE = A.TERM_CODE OR g.TERM_CODE_SHORT_DESC = A.TERM_CODE_SHORT_DESC) AND ENCOUNTER_ID = ? AND FACILITY_ID = ?) prob_cnt, NVL((SELECT 'Y' FROM PR_DIAGNOSIS_ENC_DTL ##REPDB## WHERE patient_id = a.patient_id AND term_set_id = a.term_set_id AND term_code = a.term_code AND occur_srl_no = a.occur_srl_no AND facility_id = ? AND encounter_id = ? AND ROWNUM = 1 AND status in ('A','R')), 'N' ) curr_enc_yn, a.accession_num, a.curr_accuracy_ind, d.HIGH_RISK_CODE,(SELECT COUNT( * ) FROM PR_DIAGNOSIS_STATUS ##REPDB## WHERE patient_id = a.patient_id AND term_set_id = a.term_set_id AND term_code = a.term_code AND occur_srl_no = a.occur_srl_no AND facility_id = ?) ENC_CNT,(select short_desc from MR_DIAG_CLASS_LANG_VW ##REPDB## where diag_class_code = a.diag_class_code and language_id = ?) diag_class_desc,AM_GET_DESC.AM_PRACTITIONER ##REPDB##(a.ONSET_PRACTITIONER_ID,?,1) onset_pract_name FROM PR_DIAGNOSIS ##REPDB## A, MR_TERM_CODE ##REPDB## D, MR_TERM_SET ##REPDB## C WHERE C.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_CODE = A.TERM_CODE AND A.patient_id = ? AND NVL (A.CURR_STATUS, 'O') = 'A' AND NVL (sensitive_yn, 'N') = DECODE (?, 'N', 'N', NVL (sensitive_yn, 'N'))  ORDER BY A.ONSET_DATE DESC, diag_scheme";//38981
          String Sql="SELECT   A.TERM_SET_ID, A.OCCUR_SRL_NO,A.CURR_REMARKS, TO_CHAR (A.ONSET_DATE, 'dd/mm/yyyy hh24:mi') onset_date, D.sensitive_yn, ONSET_LOCN_CODE, ONSET_LOCN_TYPE, D.SHORT_DESC || '(' || A.TERM_CODE || ')'|| NVL2 (A.CURR_REMARKS, '<br><B>Remarks</B>:' || CURR_REMARKS, NULL) diag_desc,mr_get_desc.mr_term_code ##REPDB##(a.term_set_id, a.term_code, '"+locale+"','2') TERM_CODE_SHORT_DESC, A.TERM_CODE_SHORT_DESC TERM_CODE_SHORT_DESC_1,A.TERM_CODE diag_code, C.TERM_SET_DESC diag_scheme, C.TERM_SET_DESC diag_code_scheme_desc,(SELECT COUNT ( * ) FROM  PR_DIAGNOSIS_COMPL_ENC_DTL ##REPDB## g WHERE g.TERM_SET_ID = A.TERM_SET_ID AND (g.TERM_CODE = A.TERM_CODE OR g.TERM_CODE_SHORT_DESC = A.TERM_CODE_SHORT_DESC) AND ENCOUNTER_ID = ? AND FACILITY_ID = ?) prob_cnt, NVL((SELECT 'Y' FROM PR_DIAGNOSIS_ENC_DTL ##REPDB## WHERE patient_id = a.patient_id AND term_set_id = a.term_set_id AND term_code = a.term_code AND occur_srl_no = a.occur_srl_no AND facility_id = ? AND encounter_id = ? AND ROWNUM = 1 AND status in ('A','R')), 'N' ) curr_enc_yn,NVL((select 'Y' from PR_SUPPORT_DIAGNOSIS where patient_id =a.patient_id  and term_set_id=a.term_set_id and term_code  =a.term_code and occur_srl_no =a.occur_srl_no  and rownum=1),'N') support_exisist_yn  , a.accession_num, a.curr_accuracy_ind, d.HIGH_RISK_CODE,(SELECT COUNT( * ) FROM PR_DIAGNOSIS_STATUS ##REPDB## WHERE patient_id = a.patient_id AND term_set_id = a.term_set_id AND term_code = a.term_code AND occur_srl_no = a.occur_srl_no AND facility_id = ?) ENC_CNT,(select short_desc from MR_DIAG_CLASS_LANG_VW ##REPDB## where diag_class_code = a.diag_class_code and language_id = ?) diag_class_desc,AM_GET_DESC.AM_PRACTITIONER ##REPDB##(a.ONSET_PRACTITIONER_ID,?,1) onset_pract_name FROM PR_DIAGNOSIS ##REPDB## A, MR_TERM_CODE ##REPDB## D, MR_TERM_SET ##REPDB## C WHERE C.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_CODE = A.TERM_CODE AND A.patient_id = ? AND NVL (A.CURR_STATUS, 'O') = 'A' AND NVL (sensitive_yn, 'N') = DECODE (?, 'N', 'N', NVL (sensitive_yn, 'N'))  ORDER BY A.ONSET_DATE DESC, diag_scheme";//38981 
	
     //IN043924 starts
	//String problem_qry="select a.complaint_id, complaint_desc, a.remarks,to_char(a.onset_datetime,'dd/mm/yyyy') onset_datetime_str,a.added_by_id,to_char(a.added_date,'dd/mm/yyyy hh24:mi') added_date from ca_encntr_chief_complaint a where a.facility_id= ? and a.encounter_id= ? and  not exists (select 1 from PR_DIAGNOSIS_COMPL_ENC_DTL b where b.ENCOUNTER_ID= ? AND  b.FACILITY_ID=? and b.complaint_id=a.complaint_id ) order by a.onset_datetime";
	String problem_qry ="";
	if(!encounter_id.equals(""))
		//problem_qry="select a.complaint_id, complaint_desc, a.remarks,to_char(a.onset_datetime,'dd/mm/yyyy hh24:mi') onset_datetime_str,a.added_by_id,to_char(a.added_date,'dd/mm/yyyy hh24:mi') added_date from ca_encntr_chief_complaint a where a.facility_id= ? and a.encounter_id= ? and  not exists (select 1 from PR_DIAGNOSIS_COMPL_ENC_DTL b where b.ENCOUNTER_ID= ? AND  b.FACILITY_ID=? and b.complaint_id=a.complaint_id ) order by a.onset_datetime";//IN061896 
		problem_qry="select a.complaint_id, complaint_desc, a.remarks,to_char(a.onset_datetime,'dd/mm/yyyy hh24:mi') onset_datetime_str,a.added_by_id,to_char(a.added_date,'dd/mm/yyyy hh24:mi') added_date from ca_encntr_chief_complaint ##REPDB## a where a.facility_id= ? and a.encounter_id= ? and  not exists (select 1 from PR_DIAGNOSIS_COMPL_ENC_DTL ##REPDB## b where b.ENCOUNTER_ID= ? AND  b.FACILITY_ID=? and b.complaint_id=a.complaint_id ) order by a.onset_datetime";//IN065341
	else
		//problem_qry="select a.complaint_id, complaint_desc, a.remarks,to_char(a.onset_datetime,'dd/mm/yyyy hh24:mi') onset_datetime_str,a.added_by_id,to_char(a.added_date,'dd/mm/yyyy hh24:mi') added_date from ca_encntr_chief_complaint a where a.facility_id= ? AND a.encounter_id IN (select ENCOUNTER_ID from pr_encounter where patient_id = ?) and  not exists (select 1 from PR_DIAGNOSIS_COMPL_ENC_DTL b where b.encounter_id IN (select ENCOUNTER_ID from pr_encounter where patient_id = ?) AND  b.FACILITY_ID=? and b.complaint_id=a.complaint_id ) order by a.onset_datetime ";//IN061896 
		problem_qry="select a.complaint_id, complaint_desc, a.remarks,to_char(a.onset_datetime,'dd/mm/yyyy hh24:mi') onset_datetime_str,a.added_by_id,to_char(a.added_date,'dd/mm/yyyy hh24:mi') added_date from ca_encntr_chief_complaint ##REPDB## a where a.facility_id= ? AND a.encounter_id IN (select ENCOUNTER_ID from pr_encounter ##REPDB## where patient_id = ?) and  not exists (select 1 from PR_DIAGNOSIS_COMPL_ENC_DTL ##REPDB## b where b.encounter_id IN (select ENCOUNTER_ID from pr_encounter ##REPDB## where patient_id = ?) AND  b.FACILITY_ID=? and b.complaint_id=a.complaint_id ) order by a.onset_datetime ";//IN065341
	//IN043924 ends
	
//IN065341 starts
	//String linkDiagQry="select a.complaint_id complaint_id, CA_GET_DESC.CA_CHIEF_COMPLAINT(a.complaint_id,?,'2') complaint_text,to_char(a.onset_date,'dd/mm/yyyy HH24:MI') onset_datetime_str from pr_diagnosis_compl_enc_dtl a where a.facility_id=? and a.encounter_id=? and a.term_set_id=? and ( a.term_code = ? or  a.term_code_short_desc = ?) AND OCCUR_SRL_NO =? order by a.onset_date desc";
	String linkDiagQry="select a.complaint_id complaint_id, CA_GET_DESC.CA_CHIEF_COMPLAINT ##REPDB##(a.complaint_id,?,'2') complaint_text,to_char(a.onset_date,'dd/mm/yyyy HH24:MI') onset_datetime_str from pr_diagnosis_compl_enc_dtl ##REPDB## a where a.facility_id=? and a.encounter_id=? and a.term_set_id=? and ( a.term_code = ? or  a.term_code_short_desc = ?) AND OCCUR_SRL_NO =? order by a.onset_date desc";
	linkDiagQry=linkDiagQry.replaceAll("##REPDB##",RepDb);
//IN065341 ends
	stmt2 = conn.prepareStatement(linkDiagQry);
	
	problem_qry=problem_qry.replaceAll("##REPDB##", RepDb);//IN065341
	stmt1 = conn.prepareStatement(problem_qry);
	stmt1.setString(1,facility_id);
	//IN043924 starts
	//stmt1.setString(2,encounter_id);
	//stmt1.setString(3,encounter_id);
	if(!encounter_id.equals(""))
	{
		stmt1.setString(2,encounter_id);
		stmt1.setString(3,encounter_id);
	 }
	 else
	 {
		stmt1.setString(2,patientid);
		stmt1.setString(3,patientid);
	 }
	 //IN043924 ends
	stmt1.setString(4,facility_id);
	rs1 = stmt1.executeQuery();
	Sql=Sql.replaceAll("##REPDB##", RepDb);//IN065341
	stmt = conn.prepareStatement(Sql);
	
	stmt.setString(1,encounter_id);
	stmt.setString(2,facility_id);
	stmt.setString(3,facility_id);
	stmt.setString(4,encounter_id);
	stmt.setString(5,facility_id);// added for CRF-018 - IN030459
	stmt.setString(6,locale);//IN037701
	stmt.setString(7,locale);//IN037701
	stmt.setString(8,patientid);  // modified for CRF-018 - IN030459	IN037701
	if(authorize.equals("N"))
		stmt.setString(9,f_authorize_yn);  // modified for CRF-018 - IN030459	
	else
		stmt.setString(9,"Y");  // modified for CRF-018 - IN030459	
	
	rs = stmt.executeQuery();
	if(!called_from.equals("CDR")){//IN065341
	if (sensitive_exist_yn.equals("Y") )
		{
//		System.out.println("Line:284:authorize"+authorize);
		%>
		<center>
			<a class='gridLink' href="javascript:CallAuathorize('<%=patientid%>','<%=mode%>','<%=authorize%>')" onMouseOver="showToolTip(this,'<%=authorize%>')" onMouseOut="javascript:hideToolTip()" ><font size='2' color='red'> [<fmt:message key="Common.Sensitive.label" bundle="${common_labels}"/>] </a></font></center>
			
			<table class='grid'  width='100%'><br>	

		<%
		}
	}//IN065341
%>
    <table class='grid' align='center' width='100%'>
	<!--<tr>
				<td align='center' nowrap class='COLUMNHEADERCENTER'><font size=1 >&nbsp;</font></td>
				<td align='center' nowrap class='COLUMNHEADERCENTER'><font size=1 >&nbsp;</font></td>
				<td align='center' nowrap class='COLUMNHEADERCENTER'><font size=1 ><fmt:message key="Common.Set.label" bundle="${common_labels}"/></font></td>
				<td align='center'  wrap class='COLUMNHEADERCENTER'><font size=1 align='top'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>/<fmt:message key="Common.Problem.label" bundle="${common_labels}"/></font></td>
				<td align='center'  nowrap class='COLUMNHEADERCENTER'><font size=1 align='top'><fmt:message key="Common.description.label" bundle="${common_labels}"/></font></td>
	</tr>[IN035950 Commented]-->
	<!--IN035950 Starts-->
	<%
	if(sStyle.equals(prefStyleSheet) || "CA_SPC".equals(p_called_from))//IN037701
	{%>
	<tr>
				<!--IN037701 Starts-->
				<%if("CA_SPC".equals(p_called_from)){%>
				<td align='center' nowrap class='COLUMNHEADERCENTER'><font size=1 >&nbsp;</font></td>
				<td align='center' nowrap class='COLUMNHEADERCENTER'><font size=1 >&nbsp;</font></td>
				<td align='center' nowrap class='COLUMNHEADERCENTER'><font size=1 ><fmt:message key="Common.Set.label" bundle="${common_labels}"/></font></td>
				<td align='center'  wrap class='COLUMNHEADERCENTER'><font size=1 align='top'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>/<fmt:message key="Common.Problem.label" bundle="${common_labels}"/></font></td>
				<td align='center'  nowrap class='COLUMNHEADERCENTER'><font size=1 align='top'><fmt:message key="Common.description.label" bundle="${common_labels}"/></font></td>
				<td align='center'  nowrap class='COLUMNHEADERCENTER'><font size=1 align='top'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/> Classification</font></td>
				<td align='center'  nowrap class='COLUMNHEADERCENTER' ><font align='top'>Practitioner</font></td> 
				<td align='center' nowrap class='COLUMNHEADERCENTER'><font align='top'><fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></font></td><!-- called label name from java for IN65780  -->
			    <td align='center' nowrap class='COLUMNHEADERCENTER'><font align='top'><fmt:message key="eCA.DiagnosisRemarks.label" bundle="${ca_labels}"/></font></td><!--38981-->
			    <td class='COLUMNHEADERCENTER'   width="6%"><fmt:message key="eCA.SupportingDiagCode.label" bundle="${ca_labels}"/></td> <!-- 38981 -->
			    
				<%}else{%>
				<td align='center' nowrap class='COLUMNHEADERCENTER'><font size=1 >&nbsp;</font></td>
				<td align='center' nowrap class='COLUMNHEADERCENTER'><font size=1 >&nbsp;</font></td>
				<td align='center'  wrap class='COLUMNHEADERCENTER'><font size=1 align='top'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>/<fmt:message key="Common.Problem.label" bundle="${common_labels}"/></font></td>
				<td align='center'  nowrap class='COLUMNHEADERCENTER'><font size=1 align='top'><fmt:message key="Common.description.label" bundle="${common_labels}"/></font></td>
				<td align='center' nowrap class='COLUMNHEADERCENTER'><font align='top'><fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></font></td><!-- called label name from java for IN65780  -->
			    <td align='center' nowrap class='COLUMNHEADERCENTER'><font align='top'><fmt:message key="eCA.DiagnosisRemarks.label" bundle="${ca_labels}"/></font></td><!--38981-->
			<%if(!called_from.equals("CDR")){%><!--IN065341-->
				<td align='center'  nowrap class='COLUMNHEADERCENTER' ><font align='top'>Linked Encounters</font></td>
			<%}%>
			<td class='COLUMNHEADERCENTER'   width="6%"><fmt:message key="eCA.SupportingDiagCode.label" bundle="${ca_labels}"/></td> <!-- 38981 -->
			
		<%}%>
				<!--IN037701 Ends-->
	</tr>
	<%
	}
	else
	{
	%>
	<tr>
				<td align='center' nowrap class='COLUMNHEADERCENTER<%=content_ID%>'><font size=1 >&nbsp;</font></td>
				<td align='center' nowrap class='COLUMNHEADERCENTER<%=content_ID%>'><font size=1 >&nbsp;</font></td>				
				<td align='center'  wrap class='COLUMNHEADERCENTER<%=content_ID%>'><font align='top'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>/<fmt:message key="Common.Problem.label" bundle="${common_labels}"/></font></td>
				<td align='center'  nowrap class='COLUMNHEADERCENTER<%=content_ID%>' ><font align='top'><fmt:message key="Common.description.label" bundle="${common_labels}"/></font></td>
				<td align='center' nowrap class='COLUMNHEADERCENTER<%=content_ID%>' ><font align='top'><fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></font></td><!-- called label name from java for IN65780  -->
			    <td align='center' nowrap class='COLUMNHEADERCENTER'><font align='top'><fmt:message key="eCA.DiagnosisRemarks.label" bundle="${ca_labels}"/></font></td><!--38981-->
			<%if(!called_from.equals("CDR")){%><!--IN065341-->
				<td align='center'  nowrap class='COLUMNHEADERCENTER<%=content_ID%>' ><font align='top'>Linked Encounters</font></td> <!-- added for IN030459 -->
			<%}%>
			<td class='COLUMNHEADERCENTER'  width="6%"><fmt:message key="eCA.SupportingDiagCode.label" bundle="${ca_labels}"/></td> <!-- 38981 -->
			
	</tr>
	<%}%>
	<!--IN035950 Ends-->
	<%
	while(rs1.next())
	{
		recordCount++;//IN035950
		complaint_id =rs1.getString("complaint_id")==null?"":rs1.getString("complaint_id");
		complaint_desc =rs1.getString("complaint_desc")==null?"":rs1.getString("complaint_desc");
		onset_datetime =rs1.getString("onset_datetime_str")==null?"":rs1.getString("onset_datetime_str"); //IN061896 
		onset_datetime = com.ehis.util.DateUtils.convertDate(onset_datetime,"DMYHM","en",locale);//IN061896
		classValue="gridData";
%>
	<!-- IN061896 starts --><tr><td class='<%=classValue%>' >&nbsp;</td><td class='<%=classValue%>' >&nbsp;</td><td class='<%=classValue%>'><img src='../../eCommon/images/Problems.gif'><%=complaint_id%></td><td class='<%=classValue%>'><%=complaint_desc%></td><td class='<%=classValue%>'><%=onset_datetime%></td></tr><!--Removed the Decoder from complaint desc for EMR fix--><!-- IN061896 ends -->
<%

	}

 	int row=1;
	String sensitive_yn="N";
	
    while(rs.next())
	{
			recordCount++;
			sensitive_yn=rs.getString("sensitive_yn")==null?"":rs.getString("sensitive_yn");
			
			if(sensitive_yn.equals("Y"))
				classValue="PATQRED";
			else
				classValue="gridData";
						

			diagdesc =rs.getString("diag_desc");
			diag_code =rs.getString("diag_code");
			term_set_id =rs.getString("term_set_id");
			termSetDesc =rs.getString("diag_code_scheme_desc")==null?"":rs.getString("diag_code_scheme_desc");
			term_code_short_desc =rs.getString("TERM_CODE_SHORT_DESC")==null?"":rs.getString("TERM_CODE_SHORT_DESC");
			term_code_short_desc_1 =rs.getString("TERM_CODE_SHORT_DESC_1")==null?"":rs.getString("TERM_CODE_SHORT_DESC_1");//IN067855
			occur_srl_no =rs.getString("OCCUR_SRL_NO")==null?"":rs.getString("OCCUR_SRL_NO");
			high_risk_code =rs.getString("HIGH_RISK_CODE")==null?"":rs.getString("HIGH_RISK_CODE");//IN030460
			curr_remarks = rs.getString("curr_remarks")==null?"":rs.getString("curr_remarks"); //38981
			support_exisist_yn = rs.getString("support_exisist_yn")==null?"":rs.getString("support_exisist_yn"); //38981


			//if(!diag_code.equals("*OTH"))
				diag_code_disp = diag_code;
			//else
			//	diag_code_disp = "";


			prob_cnt= rs.getInt("prob_cnt");
			curr_enc_yn= rs.getString("curr_enc_yn");
			oh_accession_num= rs.getString("accession_num")==null?"":rs.getString("accession_num");
			curr_accuracy_ind= rs.getString("curr_accuracy_ind")==null?"":rs.getString("curr_accuracy_ind");
			//IN037701 Starts
			onset_date = rs.getString("onset_date")==null?"":rs.getString("onset_date");
			onset_date			= com.ehis.util.DateUtils.convertDate(onset_date,"DMYHM","en",locale);//IN037701
			diag_class_desc = rs.getString("diag_class_desc")==null?"":rs.getString("diag_class_desc");
			onset_pract_name = rs.getString("onset_pract_name")==null?"":rs.getString("onset_pract_name");
			//IN037701 Ends
			if(!termSetDesc.equals(termSetDesc_prev))
			{
				//out.println("<tr><td class='columnHeadercenter' colspan='7'><font size=1>"+termSetDesc+"</font></td></tr>");
				//termSetDesc_prev=termSetDesc;
			}
			 %>
			

			<tr>
			<% if(!oh_accession_num.equals("")){ %>
			<td class='<%=classValue%>' ><font color='blue' ><b>C</font></td>
			<%}else{%>
			<td class='<%=classValue%>' >&nbsp;</td>
			<%}%>
			
			<%if(curr_enc_yn.equals("Y")){%>
			<td class='<%=classValue%>'><img src='../../eCommon/images/CurrentEncounter.gif'></td>
			<%}else{%>
			<td class='<%=classValue%>'>&nbsp;</td>
			<%}%>
			<!-- IN030460 Starts -->
			<!--<td class='<%=classValue%>'><%=termSetDesc%></td><td class='<%=classValue%>'>-->	
			<!--IN037701 Starts-->
			<%if("CA_SPC".equals(p_called_from)){%>
			<td class='<%=classValue%>'><%=termSetDesc%></td>
			<%}%>
			<!--IN037701 Ends-->
			<td class='<%=classValue%>' nowrap>
			<% if(!"".equals(high_risk_code)){
				%>
			
			<img class='highlite' src='../../eCommon/images/PI_HighRisk.gif' align='left'></img><!--IN037737-->
			<%}%>
			<!-- IN030460 Ends -->
			
			<% if(curr_accuracy_ind.equals("U")){
				%>
			<img src='../../eCommon/images/Differentials.gif'></img>
			<%}%>
			<%=diag_code_disp%>
			<%
			if(prob_cnt>0){
				
			
			stmt2.setString(1,locale);
			stmt2.setString(2,facility_id);
			stmt2.setString(3,encounter_id);
			stmt2.setString(4,term_set_id);
			stmt2.setString(5,diag_code);
			stmt2.setString(6,termSetDesc);
			stmt2.setString(7,occur_srl_no);

			rs2 = stmt2.executeQuery();
			layer.setLength(0);
			while(rs2.next())
			{
								
				complaint_id_lyr =rs2.getString("complaint_id")==null?"":rs2.getString("complaint_id");
				complaint_desc_lyr =rs2.getString("complaint_text")==null?"":rs2.getString("complaint_text");
				onset_datetime_lyr =rs2.getString("onset_datetime_str")==null?"":rs2.getString("onset_datetime_str");
				//Date Conversion is done by Archana Dhal on 10/7/2010 related to IN024213.
				onset_datetime_lyr = com.ehis.util.DateUtils.convertDate(onset_datetime_lyr,"DMYHM","en",locale);
				
				layer.append("<tr><td class=gridData nowrap>"+complaint_id_lyr+"</td>"+
							"<td class=gridData>"+complaint_desc_lyr+"</td>"+
							"<td class=gridData>"+onset_datetime_lyr+"</td></tr>");


			}
			if(rs2 != null) rs2.close();

			out.println("<script>detailArray["+index+"]='"+layer.toString()+"';</script>");
            //Below if condition is added by Archana Dhal on 10/14/2010 related to incident no. IN024424.
			if(!diag_code.equals("*OTH"))
			{
					//IN065341 starts	
						//linkviewcnt_sql="SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE   ENCOUNTER_ID='"+encounter_id+"' AND  FACILITY_ID='"+facility_id+"' AND  TERM_CODE = '"+diag_code+"' and OCCUR_SRL_NO='"+occur_srl_no+"'";
						//linkviewcnt_sql="SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL ##REPDB## WHERE   ENCOUNTER_ID='"+encounter_id+"' AND  FACILITY_ID='"+facility_id+"' AND  TERM_CODE = '"+diag_code+"' and OCCUR_SRL_NO='"+occur_srl_no+"'";//COMMON-ICN-0180
						linkviewcnt_sql="SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL ##REPDB## WHERE   ENCOUNTER_ID= ? AND  FACILITY_ID= ? AND  TERM_CODE = ? and OCCUR_SRL_NO= ?";//COMMON-ICN-0180
						
						linkviewcnt_sql=linkviewcnt_sql.replaceAll("##REPDB##", RepDb);
					//IN065341 ends
					  stmt3=conn.prepareStatement(linkviewcnt_sql);
					//COMMON-ICN-0180 STARTS
					  stmt3.setString(1,encounter_id);
					  stmt3.setString(2,facility_id);
					  stmt3.setString(3,diag_code);
					  stmt3.setString(4,occur_srl_no);
					//COMMON-ICN-0180 END
			}
           else
			{
			
	
				/*Below code added by Channaveer B For issue 22594(secod point)*/
				//IN065341 starts	
					//linkviewcnt_sql = "SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE   ENCOUNTER_ID='"+encounter_id+"' AND  FACILITY_ID='"+facility_id+"' AND TERM_CODE_SHORT_DESC = ? and OCCUR_SRL_NO='"+occur_srl_no+"'";
					//linkviewcnt_sql = "SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL ##REPDB## WHERE   ENCOUNTER_ID='"+encounter_id+"' AND  FACILITY_ID='"+facility_id+"' AND TERM_CODE_SHORT_DESC = ? and OCCUR_SRL_NO='"+occur_srl_no+"'";//COMMON-ICN-0180
					linkviewcnt_sql = "SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL ##REPDB## WHERE   ENCOUNTER_ID= ? AND  FACILITY_ID=? AND TERM_CODE_SHORT_DESC = ? and OCCUR_SRL_NO=?";//COMMON-ICN-0180
                    linkviewcnt_sql=linkviewcnt_sql.replaceAll("##REPDB##", RepDb);
				//IN065341 ends
					stmt3=conn.prepareStatement(linkviewcnt_sql);
					//stmt3.setString(1,term_code_short_desc);//Commented for IN067855
					//stmt3.setString(1,term_code_short_desc_1);//IN067855//COMMON-ICN-0180
					//COMMON-ICN-0180 STARTS
					  stmt3.setString(1,encounter_id);
					  stmt3.setString(2,facility_id);
					  stmt3.setString(3,term_code_short_desc_1);
					  stmt3.setString(4,occur_srl_no);
					//COMMON-ICN-0180 END
			}
				
				rs3=stmt3.executeQuery();
			   if(rs3 != null && rs3.next())
			    {
				view_cnt = rs3.getInt(1);
			    }
				if(rs2 != null) rs2.close();		//Checkstyle 4.0 Beta 6
				if(rs3 != null) rs3.close(); //Checkstyle
				if(stmt3 != null) stmt3.close();	//Checkstyle 4.0 Beta 6				
			if(view_cnt !=0 )
				{
				/*End here*/
			%>  
				<img src='../../eCommon/images/LinkView.gif' align='right' onMouseOver='callMouseOverDiag(this,"<%=index%>")' onMouseOut='callOnMouseOutDiag(this);'>
						
			<%
					}
			
			 index++;
		 }
			%>
		</td>
		<!--IN037701 Starts-->
		<%if("CA_SPC".equals(p_called_from)){
			if(!isSiteSpecific){%><!--IN069327-->
				<%if(!diag_code.equals("*OTH")){%>
				<td  class='<%=classValue%>'><%=term_code_short_desc%> </td> 
				<%}
				else{%>
				<td  class='<%=classValue%>'><%=term_code_short_desc_1%> </td>
				<%}
			}else{%>
				<td  class='<%=classValue%>'><%=term_code_short_desc_1%> </td>	<!--IN069327-->
			<%}%>
				<td  class='<%=classValue%>'><%=diag_class_desc%> </td> 
				<td  class='<%=classValue%>'><%=onset_pract_name%> </td> 
				<td  class='<%=classValue%>'><%=onset_date%> </td> 
		<%}else{
			if(!isSiteSpecific){%>
				<%if(!diag_code.equals("*OTH")){%>
				<td  class='<%=classValue%>'><%=term_code_short_desc%> </td> <%}
				else{%>
				<td  class='<%=classValue%>'><%=term_code_short_desc_1%> </td>
				<%}
			}else{%>
				<td  class='<%=classValue%>'><%=term_code_short_desc_1%> </td><!--IN069327-->
			<%}%>
				<td class='<%=classValue %>'><%=onset_date%> </td><!--IN061896--> 				
				<!-- 38981 start -->
           <%   if(curr_remarks!="")
			{
				out.println("<td class='"+classValue+"' width='8%'><font size=1>");
				//out.println("<a class='gridLink'  href=\"javascript: ShowRemarksDiag('" + curr_remarks+ "')\" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a>");
                  out.println("<a class='gridLink'  href=\"javascript: ShowRemarksDiag('"+patientid+"','"+diag_code+"','"+term_set_id+"','"+term_code_short_desc+"','"+occur_srl_no+"')\" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a>");//42995
				  out.println("</font></td>");
				
		    }
				
           else
				
           {
				out.print("<td class='"+classValue+"'> &nbsp;</td>");
				
           }
			%>			
			    <!-- 38981 end -->
				<%if(!called_from.equals("CDR")){%><!--IN065341-->
				<td class='<%=classValue%>'>&nbsp; <a class='gridLink' href="javascript:showLinkedEncounters('<%=patientid%>','<%=term_set_id%>','<%=diag_code%>','<%=contentId%>')"><img src='../../eCA/images/Encounters.png'></a></td> <!-- added for IN030459 -->
			<%}%>	<!--IN065341-->
			
			<!-- 38981 start -->
			 <%if(support_exisist_yn.equals("Y"))
			{
			out.println("<td class='"+classValue+"' nowrap><font size=1>");
			out.println("<a href=\"javascript: ShowSupportingDiag('" + diag_code+"','"+occur_srl_no+"','"+patientid+"','"+term_set_id+"','"+(java.net.URLEncoder.encode(term_code_short_desc))+"("+diag_code+")"+"')\" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a>");
			out.println("</font></td>");
			}
			else{
			out.println("<td class='"+classValue+"' nowrap>&nbsp<font size=1></font></td>");
			}	%>	
			<!-- 38981 end --> 
		<%}%>
		<!--IN037701 Ends-->
		</tr>
			<%
             row++;
	}
	
	//IN035950  Starts
		if(recordCount==0)
		{
		out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NODATAFOUND.label","ca_labels")+"</td></tr>");
		}
	//IN035950  Ends
	%>
    </table>
	<input type="hidden" id="p_called_from" name="p_called_from" id="p_called_from" value="<%=p_called_from%>"> <!--IN037701 Starts-->
	<div id='authorizeMode' style='position:absolute; visibility:hidden;overflow:overflow'></div>
<%


}
catch (Exception e){
		//out.println("Errors have occured"+e);//common-icn-0181
		e.printStackTrace();
}

finally
{
		if(rs!=null) rs.close();
		if(rs1!=null) rs1.close();
		if(stmt!=null) stmt.close();
		if(stmt1!=null) stmt1.close();
		if(stmt2!=null) stmt2.close();
		if (conn != null) ConnectionManager.returnConnection(conn,request);
}

%>
<div name='details' id='details' style='position:absolute; width:60%; visibility:hidden;' bgcolor='blue'>

</div>
</body>
</html>

