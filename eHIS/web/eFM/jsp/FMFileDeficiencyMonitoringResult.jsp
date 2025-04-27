<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import ="java.util.*,java.sql.*, java.text.*,java.net.*,webbeans.eCommon.*, webbeans.eFM.FileDeficiencyMonitoring,com.ehis.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="recordSetDeficiency" scope="session" class="webbeans.eFM.FileDeficiencyMonitoring"/>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eFM/js/FMFileDeficiencyMonitoring.js' language='javascript'></script>
		<script language="javascript" src="../../eCommon/js/rowcolor.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
function OnSelection(EncounterId,FileNo,PatientId,admndate,discdate,found,carelocn, file_type_code, volume_no,row_count)
{
	parent.frames[3].location.href = "../../eFM/jsp/FMFileDeficiencyMonitoringDetails.jsp?EncounterId="+EncounterId+"&FileNo="+FileNo+"&PatientId="+PatientId+"&Admndate="+admndate+"&Discdate="+discdate+"&Found="+found+"&Carelocn="+carelocn+"&file_type_code="+file_type_code+"&row_count="+row_count+"&volume_no="+volume_no;

    //var display_yn = parent.frames[2].document.forms[0].DisplyDetail.value;

	parent.frames[4].location.href = "../../eFM/jsp/FMFileDeficiencyMonitoringAdd.jsp?EncounterId="+EncounterId+"&FileNo="+FileNo+"&PatientId="+PatientId+"&Admndate="+admndate+"&Discdate="+discdate+"&Found="+found+"&Carelocn="+carelocn+"&file_type_code="+file_type_code+"&volume_no="+volume_no;
}
</script>
<%
	String PatientId		= request.getParameter("PatientID");	


	String FileNo			= request.getParameter("FileNo");	
	String enc_id = request.getParameter("EncounterID");	

	String file_type_code	= request.getParameter("file_type_code");	
	String volume_no		= request.getParameter("volume_no");	

	file_type_code			= ((file_type_code==null)||(file_type_code.equals("null"))) ? "" : file_type_code;
	volume_no				= ((volume_no==null)||(volume_no.equals("null"))) ? "" : volume_no;
	if(PatientId==null)PatientId="";
	if(FileNo==null) FileNo="";
	if(enc_id==null) enc_id="";
	String QuerySql = "";
    String file_type_appl_yn="Y";
	int row_count=0;
	file_type_appl_yn=request.getParameter("file_type_appl_yn");	
	if(file_type_appl_yn==null) file_type_appl_yn="Y";
	String curr_fs_locn_code=request.getParameter("curr_fs_locn_code");	
	if(curr_fs_locn_code==null) curr_fs_locn_code="";
	StringBuffer SelectSqlBuffer	= null;
	StringBuffer SelectSqlBuffer1	= null;
	SelectSqlBuffer					= new StringBuffer();
	SelectSqlBuffer1				= new StringBuffer();
%>
<body OnMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<form name='FileDeficiencyMonitoring_result' id='FileDeficiencyMonitoring_result'>
 <table id='tb1' border="0" cellpadding="0" cellspacing="0" width='100%'>
<%
	Connection conn				= ConnectionManager.getConnection(request);
	PreparedStatement pstmt		= null;
	PreparedStatement pstmt1	= null;
	PreparedStatement pstmt2	= null;
	PreparedStatement pstmt3	= null;
	ResultSet rs				= null;
	ResultSet rset				= null;


	PreparedStatement pstmt4		= null;
	ResultSet rs1				= null;



	String facility_id	= (String) session.getValue("facility_id");

	//String sql					= "";
	//String attbCheck			= "";
	String EncounterId			= "";
	String patline				= "";
	String admndate				= "";
	String discdate				= "";
	String carelocn				= "";
	String compstatus			= "";
	String name					= "",id="",en="",pr="";
	String discharge_type		= "", specialty_desc = "", practitioner_name = "";
	String patient_class		= "";
	String disply_detail		= "N";
	String curr_file_status="";
    //String curr_file_status		= "";
     boolean  flag=true;
	HashMap		htRecord		=	null;

	String 	sql1    ="";
	String   sql2    ="";
	int count       =0;
   int count1      =0;

	int found		= 0;
	//int reccount	= 0;
	int i			= 1;
	int rowid		= 1;

	try
	{

	recordSetDeficiency.clearAll();
			
   if(PatientId == null || PatientId.equals("null") || PatientId.equals(""))
		{
			PatientId = "";
			%>
			<script>
				var errors = getMessage("FSLOCN_FILE_NOT_EXIST","FM");	parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors;
				var file_no = parent.frames[1].document.forms[0].file_no;
				if ((file_no.type != 'hidden') && (!file_no.disabled))
					parent.frames[1].document.forms[0].file_no.focus();
				</script>
			<%
		}
		else
		{
      if(!file_type_code.equals("") && file_type_appl_yn.equals("Y"))
		{
		pstmt4 = conn.prepareStatement("SELECT curr_file_status FROM fm_curr_locn where facility_id ='"+facility_id+"' AND file_type_code ='"+file_type_code+"' AND volume_no='"+volume_no	+"' and patient_id ='"+PatientId+"'");
		}
		
		if(!FileNo.equals("") && file_type_appl_yn.equals("N"))
		{
		pstmt4 = conn.prepareStatement("SELECT curr_file_status FROM fm_curr_locn where facility_id ='"+facility_id+"' AND file_no ='"+FileNo+"' AND volume_no='"+volume_no	+"' and patient_id ='"+PatientId+"'");
		}
		rs1 = pstmt4.executeQuery();
		if(rs1 != null && rs1.next())
		{
			curr_file_status = rs1.getString(1);
		}
		if(curr_file_status==null) curr_file_status="";
		if(curr_file_status.equals("T") || curr_file_status.equals("L"))
		{
		flag=false;
		
		%>
		<script>
							//alert("File is in transit so cannot proceed");
			var msg="";
			var curr_file_status="<%=curr_file_status%>";
			 
			 if(curr_file_status=="T")
			{
			 msg = getMessage('FILE_IN_TRANSIT_CANNOT_PROCEED','FM'); 					
			}
			if(curr_file_status=="L")
			{
			 msg = getMessage('FILE_IS_LOST','FM'); 					
			}
			
			alert(msg);
	parent.frames[1].document.forms[0].search.disabled=false;
	parent.frames[1].document.forms[0].encounter_id.disabled=false;
	parent.frames[1].document.forms[0].pat_search.disabled=false;
	parent.frames[1].document.forms[0].encounter_id_search.disabled=false;
	parent.frames[1].document.forms[0].volume_no.disabled=false;
	parent.frames[1].document.forms[0].patient_id.disabled=false;
	if (parent.frames[1].document.forms[0].file_type_appl_yn.value == "N")
			{
	parent.frames[1].document.forms[0].file_no.disabled		=	false;
	parent.frames[1].document.forms[0].file_no.value="";		
			}
	else if (parent.frames[1].document.forms[0].file_type_appl_yn.value == "Y")
			{
	   parent.frames[1].document.forms[0].file_type_code.disabled	=	false;
		parent.frames[1].document.forms[0].file_type_code.value="";
			}	
		
		
		parent.frames[1].document.forms[0].cuurfslocn.disabled	=	false;
		parent.frames[1].document.forms[0].patient_id.value="";	
		parent.frames[1].document.forms[0].patient_id.onblur();
		//parent.frames[1].document.forms[0].volume_no.value="";
		parent.frames[1].document.forms[0].encounter_id.value="";
		parent.deficiency_result.location.href = '../../eCommon/html/blank.html';
		parent.deficiency_detail.location.href = '../../eCommon/html/blank.html';
		parent.deficiency_detail_add.location.href = '../../eCommon/html/blank.html';

			
			</script>		
		<%}
	    	if(rs1!=null)	rs1.close();
			if(pstmt4!=null) pstmt4.close();
		
			if(flag)
		    { 
			sql1="select encounter_id from pr_encounter where facility_id ='"+facility_id+"' and patient_id='"+PatientId+"' and encounter_id='"+enc_id+"'";

			pstmt4 = conn.prepareStatement(sql1);
			rs1 = pstmt4.executeQuery();

		if(rs1 != null && rs1.next())
		{
			count ++;
				}
		   if(rs1!=null)	rs1.close();
			if(pstmt4!=null) pstmt4.close();
		
		if(!curr_fs_locn_code.equals(""))
				{
		 if(!file_type_code.equals("") && file_type_appl_yn.equals("Y"))
		  {
		
		sql2="select curr_fs_locn_code  from fm_curr_locn where facility_id ='"+facility_id+"' and patient_id='"+PatientId+"' AND file_type_code ='"+file_type_code+"' AND volume_no='"+volume_no	+"' and curr_fs_locn_code='"+curr_fs_locn_code+"' ";
		}
			
		if(!FileNo.equals("") && file_type_appl_yn.equals("N"))
		{
	sql2="select curr_fs_locn_code  from fm_curr_locn where facility_id ='"+facility_id+"' and patient_id='"+PatientId+"' AND file_no ='"+FileNo+"' AND volume_no='"+volume_no	+"' and curr_fs_locn_code='"+curr_fs_locn_code+"'   ";
		
		}	
			
			
			pstmt4 = conn.prepareStatement(sql2);
				
			rs1 = pstmt4.executeQuery();

		if(rs1 != null && rs1.next())
		{
			count1 ++;
				}
			
			if(count1==0)
					{
              count=0;
					}else{

					}
							
				}
			
			if(count >0)
			{
				SelectSqlBuffer.append("SELECT" );
				SelectSqlBuffer.append("  A.ENCOUNTER_ID" );
				SelectSqlBuffer.append("  , Get_Patient.Get_line_detail('"+facility_id+"','"+enc_id+"','"+localeName+"') PLINE" );
				SelectSqlBuffer.append("  , TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') ADMN_DATE" );
				SelectSqlBuffer.append("  , A.ASSIGN_CARE_LOCN_CODE" );
				
				SelectSqlBuffer.append(" , A.DISPOSITION_TYPE,DECODE (A.PATIENT_CLASS,'IP', IP_GET_DESC.IP_DISCHARGE_TYPE(A.DISPOSITION_TYPE,'"+localeName+"','2') ,'DC', IP_GET_DESC.IP_DISCHARGE_TYPE(A.DISPOSITION_TYPE,'"+localeName+"','2') , AM_GET_DESC.AM_DISPOSITION_TYPE(A.DISPOSITION_TYPE,'"+localeName+"','2') ) DISPOSITION_TYPE_DESC "); // added for ML-MMOH-SCF-0715
				
				
				SelectSqlBuffer.append("  , TO_CHAR(A.DISCHARGE_DATE_TIME,'DD/MM/YYYY hh24:mi') DISC_DATE" );
				SelectSqlBuffer.append("  , am_get_desc.AM_SPECIALITY(A.SPECIALTY_CODE,'"+localeName+"',2 ) SPECIALTY_DESC" );
				SelectSqlBuffer.append("  , AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+localeName+"','1') PRACTITIONER_NAME" );
				SelectSqlBuffer.append("  , A.PATIENT_CLASS " );
				SelectSqlBuffer.append("FROM" );
				SelectSqlBuffer.append("  PR_ENCOUNTER A " );
				SelectSqlBuffer.append("WHERE A.FACILITY_ID = '"+facility_id+"' " );
				SelectSqlBuffer.append("  AND A.ENCOUNTER_ID = '"+enc_id+ "'" );
			    SelectSqlBuffer.append("  AND A.PATIENT_ID = '"+PatientId+"' " );
				SelectSqlBuffer.append("  AND A.DISCHARGE_DATE_TIME IS NOT NULL" );
				
				pstmt1 = conn.prepareStatement(SelectSqlBuffer.toString());
				rs = pstmt1.executeQuery();
				if(rs != null && rs.next())
				{
					EncounterId = rs.getString("ENCOUNTER_ID");
					patline = rs.getString("PLINE");
					String strToken = "|";
					StringTokenizer token=new StringTokenizer(patline,strToken);
					while(token.hasMoreTokens())
					{
						name=token.nextToken();
						id=token.nextToken();
						
						en=token.nextToken();
						pr=token.nextToken();
					}

					admndate = rs.getString("ADMN_DATE");
				if(admndate != null)
				{
					admndate=DateUtils.convertDate(admndate,"DMYHM","en",localeName);
				}
				else
					admndate="";

					discdate = rs.getString("DISC_DATE");

				if(discdate != null)
				{
					discdate=DateUtils.convertDate(discdate,"DMYHM","en",localeName);
				}
				else
					discdate="";

				
					carelocn = rs.getString("ASSIGN_CARE_LOCN_CODE");
					patient_class = rs.getString("patient_class");
					discharge_type = rs.getString("DISPOSITION_TYPE_DESC"); // added for ML-MMOH-SCF-0715
					if (discharge_type==null) discharge_type="";
					specialty_desc = rs.getString("specialty_desc");
					if (specialty_desc==null) specialty_desc="";
					practitioner_name = rs.getString("practitioner_name");
					if (practitioner_name==null) practitioner_name="";
					
					QuerySql = "Select COUNT(*) FROM FM_DEFICIENCY_HDR WHERE FACILITY_ID = ? AND ENCOUNTER_ID = "+EncounterId+" AND FILE_NO = ? AND  VOLUME_NO = ? ";
					pstmt2 = conn.prepareStatement(QuerySql);
					pstmt2.setString(1,facility_id);
					pstmt2.setString(2,FileNo);
					pstmt2.setString(3,volume_no);
					rset = pstmt2.executeQuery();
					if(rset != null && rset.next())
					{
						found = rset.getInt(1);
					}
					if(rset!=null)	rset.close();
					if(pstmt2!=null) pstmt2.close();

					if(found > 0)
					{
						//attbCheck = "CHECKED";
						compstatus = "&nbsp;";
					}
					else
					{
						compstatus = "&nbsp;";
						disply_detail = "Y";
					}
					%>
					<script>
						var eidar= "";
						var pidar= "";
						eidar='<%=pr%>'.split(":");
						pidar='<%=id%>'.split(":");						
						var elab=""
						var evalu=""
						var plab=""
						var pvalu=""
						
						if(eidar!=null)
							{elab=eidar[0];evalu=eidar[1];}
						plab=pidar[0];pvalu=":"+pidar[1];

						if(elab==null || evalu=="")
							elab=" "
							
						if(evalu!=null || evalu!="")
						{
							evalu=":"+evalu             
						}
						
					</script>
					<tr>
						<td colspan='4'>
						<jsp:include page="../../eCommon/jsp/pline.jsp" ><jsp:param name="flush" value="true" />
						<jsp:param name="Patient_ID" value="<%=PatientId%>"/>
						</jsp:include>
						</td>
					</tr>
					<%
					
					
					out.println("<tr><td class='label' width='25%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admissiondate.label","common_labels")+" :</td>");
					out.println("<td class='data' width='25%'><b>"+admndate+"</td>");
					out.println("<td class='label' width='25%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.dischargedate.label","common_labels")+" :</td>");
					out.println("<td class='data' width='25%'><b>"+discdate+"</td></tr>");
					out.println("<tr><td class='label' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+" :</td>");
					out.println("<td class='data'><b>"+practitioner_name+"</td>");
					out.println("<td class='label' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" :</td>");
					out.println("<td class='data'><b>"+specialty_desc+"</b></td></tr>");
					out.println("<tr><td class='label' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.dischargetype.label","common_labels")+" :</td>");
					out.println("<td class='data'><b>"+discharge_type+"</td>");
					out.println("<td class='label' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.EncounterDeficiencyStatus.label","fm_labels")+" :</td>");
					out.println("<td class='data' id='completed_status'><b>"+compstatus+"</b></td></tr>");
%>
	<script>
	parent.frames[1].document.forms[0].cuurfslocn.disabled = true;
	if (parent.frames[1].document.forms[0].file_no.type != 'hidden')
	parent.frames[1].document.forms[0].file_no.disabled = true;
	</script>
<%			i++;
			rowid++;

		 	




			/*SelectSqlBuffer1.append("Select A.FACILITY_ID, A.ENCOUNTER_ID, A.FILE_NO,");
			SelectSqlBuffer1.append("TO_CHAR(A.ADMISSION_DATE,'DD/MM/YYYY hh24:mi') ADMN_DATE,");
			SelectSqlBuffer1.append("TO_CHAR(A.DISCHARGE_DATE,'DD/MM/YYYY hh24:mi') DISC_DATE,");
			SelectSqlBuffer1.append("A.ASSIGN_CARE_LOCN_CODE,");
			SelectSqlBuffer1.append("A.DEFICIENCY_STATUS DEFICIENCY_COMPLETED_STATUS,B.DEFICIENCY_CODE,");
			SelectSqlBuffer1.append("B.RESP_PRACTITIONER_ID,");
			SelectSqlBuffer1.append("TO_CHAR(B.REPORTED_DATE,'DD/MM/YYYY hh24:mi') REP_DATE,");
			SelectSqlBuffer1.append("B.DEFICIENCY_STATUS,");
			SelectSqlBuffer1.append("TO_CHAR(B.RESOLVED_DATE,'DD/MM/YYYY hh24:mi') RES_DATE,");
			SelectSqlBuffer1.append("B.REMARKS, C.SHORT_DESC, D.PRACTITIONER_NAME SHORT_NAME,");
			SelectSqlBuffer1.append("A.FILE_TYPE, A.VOLUME_NO, A.PATIENT_CLASS, A.PATIENT_ID ");
			SelectSqlBuffer1.append("From FM_DEFICIENCY_HDR A, FM_DEFICIENCY_DTL B, FM_DEFICIENCY C,");
			SelectSqlBuffer1.append("AM_PRACTITIONER D Where A.FACILITY_ID = '"+facility_id+"' ");
			SelectSqlBuffer1.append("AND A.ENCOUNTER_ID = "+EncounterId+" ");
			
			if (!FileNo.equals(""))
				SelectSqlBuffer1.append(" AND A.FILE_NO = '"+FileNo+"' ");
			if (!file_type_code.equals(""))
				SelectSqlBuffer1.append(" AND A.FILE_TYPE = '"+file_type_code+"' ");
			if (!volume_no.equals(""))
				SelectSqlBuffer1.append("AND A.VOLUME_NO = '"+volume_no+"' ");
			
			SelectSqlBuffer1.append("AND A.FACILITY_ID = B.FACILITY_ID AND ");
			SelectSqlBuffer1.append("A.ENCOUNTER_ID = B.ENCOUNTER_ID AND A.FILE_NO = B.FILE_NO AND ");
			SelectSqlBuffer1.append("B.DEFICIENCY_CODE = C.DEFICIENCY_CODE AND ");
			SelectSqlBuffer1.append("B.RESP_PRACTITIONER_ID = D.PRACTITIONER_ID AND A.VOLUME_NO = B.VOLUME_NO ");*/
			
			SelectSqlBuffer1.append("SELECT" );
			SelectSqlBuffer1.append("  A.FACILITY_ID" );
			SelectSqlBuffer1.append("  , A.ENCOUNTER_ID" );
			SelectSqlBuffer1.append("  , A.FILE_NO" );
			SelectSqlBuffer1.append("  , TO_CHAR(A.ADMISSION_DATE,'DD/MM/YYYY hh24:mi') ADMN_DATE" );
			SelectSqlBuffer1.append("  , TO_CHAR(A.DISCHARGE_DATE,'DD/MM/YYYY hh24:mi') DISC_DATE" );
			SelectSqlBuffer1.append("  , A.ASSIGN_CARE_LOCN_CODE" );
			SelectSqlBuffer1.append("  , A.DEFICIENCY_STATUS DEFICIENCY_COMPLETED_STATUS" );
			SelectSqlBuffer1.append("  , B.DEFICIENCY_CODE" );
			SelectSqlBuffer1.append("  , B.RESP_PRACTITIONER_ID" );
			SelectSqlBuffer1.append("  , TO_CHAR(B.REPORTED_DATE,'DD/MM/YYYY hh24:mi') REP_DATE" );
			SelectSqlBuffer1.append("  , B.DEFICIENCY_STATUS" );
			SelectSqlBuffer1.append(" ,TO_CHAR(B.RESOLVED_DATE,'DD/MM/YYYY hh24:mi') RES_DATE ");
			SelectSqlBuffer1.append("  , B.REMARKS" );
			SelectSqlBuffer1.append("  , FM_GET_DESC.FM_DEFICIENCY(B.DEFICIENCY_CODE,'"+localeName+"','2') SHORT_DESC" );
			SelectSqlBuffer1.append("  , AM_GET_DESC.AM_PRACTITIONER(B.RESP_PRACTITIONER_ID,'"+localeName+"','1') SHORT_NAME" );
			SelectSqlBuffer1.append("  , A.FILE_TYPE" );
			SelectSqlBuffer1.append("  , A.VOLUME_NO" );
			SelectSqlBuffer1.append("  , A.PATIENT_CLASS" );
			SelectSqlBuffer1.append("  , A.PATIENT_ID " );
			SelectSqlBuffer1.append("FROM" );
			SelectSqlBuffer1.append("  FM_DEFICIENCY_HDR A" );
			SelectSqlBuffer1.append("  , FM_DEFICIENCY_DTL B " );
			SelectSqlBuffer1.append("WHERE A.FACILITY_ID = B.FACILITY_ID " );
			SelectSqlBuffer1.append("  AND A.ENCOUNTER_ID = B.ENCOUNTER_ID " );
			SelectSqlBuffer1.append("  AND A.FILE_NO = B.FILE_NO " );
			SelectSqlBuffer1.append("  AND A.VOLUME_NO = B.VOLUME_NO " );
			SelectSqlBuffer1.append("  AND A.FACILITY_ID = '"+facility_id+"' " );
			SelectSqlBuffer1.append("  AND A.ENCOUNTER_ID = "+EncounterId+" " );
			if (!FileNo.equals(""))
				SelectSqlBuffer1.append(" AND A.FILE_NO = '"+FileNo+"' ");
			if (!volume_no.equals(""))
				SelectSqlBuffer1.append("AND A.VOLUME_NO = '"+volume_no+"' ");

			pstmt3 = conn.prepareStatement(SelectSqlBuffer1.toString());
			rset = pstmt3.executeQuery();
			if(rset != null)
			{
				while(rset.next())
				{
					String resdate = rset.getString("RES_DATE");
					String rep_date = rset.getString("REP_DATE");
					String remarks = rset.getString("REMARKS");

					if(resdate != null )
					{
					resdate=DateUtils.convertDate(resdate,"DMYHM","en",localeName);
					}
					else
						resdate  = "";
					if(rep_date != null )
					{
					rep_date=DateUtils.convertDate(rep_date,"DMYHM","en",localeName);
					}
					else
						rep_date  = "";
					
					if(remarks == null || remarks.equals("null"))	remarks  = "";

					htRecord	=	new HashMap();

					htRecord.put (	"facility_id",rset.getString("FACILITY_ID")==null?"":rset.getString("FACILITY_ID"));
					htRecord.put (	"encounter_id",		rset.getString("ENCOUNTER_ID")==null?"":rset.getString("ENCOUNTER_ID")	);
					htRecord.put (	"file_no",			rset.getString("FILE_NO")==null?"":rset.getString("FILE_NO"));
					htRecord.put (	"file_type",		file_type_code);
					htRecord.put (	"volume_no",		volume_no	);
					htRecord.put (	"patient_class",	patient_class);
					htRecord.put (	"PatientId",	PatientId);
					htRecord.put (	"defi_code",		rset.getString("DEFICIENCY_CODE")==null?"":rset.getString("DEFICIENCY_CODE")	);
					htRecord.put (	"defi_desc",		rset.getString("SHORT_DESC")==null?"":rset.getString("SHORT_DESC")	);
					htRecord.put (	"admission_date",	rset.getString("ADMN_DATE")==null?"":rset.getString("ADMN_DATE")	);
					htRecord.put (	"discharge_date",	rset.getString("DISC_DATE")==null?"":rset.getString("DISC_DATE"));
					htRecord.put (	"care_locn_code",	rset.getString("ASSIGN_CARE_LOCN_CODE")==null?"":rset.getString("ASSIGN_CARE_LOCN_CODE"));
					htRecord.put (	"defi_completed_status",  rset.getString("DEFICIENCY_COMPLETED_STATUS")==null?"":rset.getString("DEFICIENCY_COMPLETED_STATUS"));
					htRecord.put (	"practitioner",			rset.getString("RESP_PRACTITIONER_ID")==null?"":rset.getString("RESP_PRACTITIONER_ID")	);
					htRecord.put (	"practitioner_name",	rset.getString("SHORT_NAME")==null?"":rset.getString("SHORT_NAME")	);
					htRecord.put (	"defi_reported_date",	rep_date);
					htRecord.put (	"defi_status",			rset.getString("DEFICIENCY_STATUS")==null?"":rset.getString("DEFICIENCY_STATUS")	);
					htRecord.put (	"defi_resolved_date",	resdate	);
					htRecord.put (	"defi_remarks",	remarks );
					htRecord.put (	"item_delete_yn",		"N"	);
					htRecord.put (	"header_exist",			"1" );
					htRecord.put (	"operation_mode",		"Modify" );
					htRecord.put (	"record_from",			"DATABASE" );

					recordSetDeficiency.putObject(htRecord);
	
					if(rset.getString("DEFICIENCY_STATUS").equals("O"))
						disply_detail = "Y";
					}
				row_count	=recordSetDeficiency.getSize();
				session.removeAttribute("row_count");
				session.setAttribute("row_count",row_count);
				}
			}  // end of rs.next()
			else
			{
				out.println("<script> var errors = getMessage('PATIENT_NOT_DISCHARGED','FM');	parent.frames[5].document.location.href='../../eCommon/jsp/error.jsp?err_num='+errors; </script>");
			}
			}else
			{
				if(curr_fs_locn_code.equals(""))
				{
				out.println("<script> var errors = getMessage('PATIENT_IS_NOT_INPATIENT','FM');	parent.frames[5].document.location.href='../../eCommon/jsp/error.jsp?err_num='+errors; </script>");
				}else{
		
		%>	
			<script>
							//alert("File is in transit so cannot proceed");
			var msg="";
			 msg = getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"); 					
			alert(msg);
	parent.frames[1].document.forms[0].search.disabled=false;
	parent.frames[1].document.forms[0].encounter_id.disabled=false;
	parent.frames[1].document.forms[0].pat_search.disabled=false;
	parent.frames[1].document.forms[0].encounter_id_search.disabled=false;
	parent.frames[1].document.forms[0].volume_no.disabled=false;
	parent.frames[1].document.forms[0].patient_id.disabled=false;
	if (parent.frames[1].document.forms[0].file_type_appl_yn.value == "N")
			{
	parent.frames[1].document.forms[0].file_no.disabled		=	false;
	parent.frames[1].document.forms[0].file_no.value="";		
			}
	else if (parent.frames[1].document.forms[0].file_type_appl_yn.value == "Y")
			{
	   parent.frames[1].document.forms[0].file_type_code.disabled	=	false;
		parent.frames[1].document.forms[0].file_type_code.value="";
			}	
		
		
		parent.frames[1].document.forms[0].cuurfslocn.disabled	=	false;
		parent.frames[1].document.forms[0].patient_id.value="";	
		parent.frames[1].document.forms[0].patient_id.onblur();
		//parent.frames[1].document.forms[0].volume_no.value="";
		parent.frames[1].document.forms[0].encounter_id.value="";
		parent.deficiency_result.location.href = '../../eCommon/html/blank.html';
		parent.deficiency_detail.location.href = '../../eCommon/html/blank.html';
		parent.deficiency_detail_add.location.href = '../../eCommon/html/blank.html';

			
			</script>		
			
		<%		
				}
		
		}


	//	}  // end of rowcount if
	}  // end of PatientId if
	
		
	if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0))
	{
		SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
	}
	if((SelectSqlBuffer1 != null) && (SelectSqlBuffer1.length() > 0))
	{
		SelectSqlBuffer1.delete(0,SelectSqlBuffer1.length());
	}
if(rs!=null)	 rs.close();
if(rset!=null)	 rset.close();
if(pstmt!=null)  pstmt.close();
if(pstmt1!=null) pstmt1.close();
if(pstmt2!=null) pstmt2.close();
if(pstmt3!=null) pstmt3.close();
if(rs1!=null)	rs1.close();
if(pstmt4!=null) pstmt4.close();

		}
	}
	
	catch(Exception e){
	out.println("Exception e1 :"+e);
	e.printStackTrace();
	}
finally
{	
	ConnectionManager.returnConnection(conn,request);
}
if(flag)
{
%>
<input type='hidden' name='DisplyDetail' id='DisplyDetail' value='<%=disply_detail%>'>
<input type='hidden' name='pateint_id' id='pateint_id' value='<%=PatientId%>'>
</table>
<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
<td class='columnheader'><fmt:message key="eFM.Deficiencies.label" bundle="${fm_labels}"/></td>
</table>
<%
	
	
	if (i > 1)
	{															out.println("<script>OnSelection('"+EncounterId+"','"+FileNo+"','"+PatientId+"','"+admndate+"','"+discdate+"','"+found+"','"+carelocn+"', '"+file_type_code+"', '"+volume_no+"','"+row_count+"');</script>");
	%>
	<script>
	parent.frames[1].document.forms[0].search.disabled=false;
	parent.frames[1].document.forms[0].encounter_id.disabled=false;
	parent.frames[1].document.forms[0].pat_search.disabled=false;
	parent.frames[1].document.forms[0].encounter_id_search.disabled=false;
	parent.frames[1].document.forms[0].volume_no.disabled=false;
	parent.frames[1].document.forms[0].patient_id.disabled=false;
	if (parent.frames[1].document.forms[0].file_type_appl_yn.value == "N")
		parent.frames[1].document.forms[0].file_no.disabled		=	false;
	else if (parent.frames[1].document.forms[0].file_type_appl_yn.value == "Y")
		parent.frames[1].document.forms[0].file_type_code.disabled	=	false;
	</script>
<%
	}
	else
	{
		out.println("<script>parent.frames[3].location.href = '../../eCommon/html/blank.html';");
		out.println("parent.frames[4].location.href = '../../eCommon/html/blank.html';</script>");
			%>
	<script>
	parent.frames[1].document.forms[0].search.disabled=false;
	parent.frames[1].document.forms[0].encounter_id.disabled=false;
	parent.frames[1].document.forms[0].pat_search.disabled=false;
	parent.frames[1].document.forms[0].encounter_id_search.disabled=false;
	parent.frames[1].document.forms[0].volume_no.disabled=false;
	parent.frames[1].document.forms[0].patient_id.disabled=false;
	if (parent.frames[1].document.forms[0].file_type_appl_yn.value == "N")
		parent.frames[1].document.forms[0].file_no.disabled		=	false;
	else if (parent.frames[1].document.forms[0].file_type_appl_yn.value == "Y")
		parent.frames[1].document.forms[0].file_type_code.disabled	=	false;
	</script>
<%
	}
}
%>
</form>

</body>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

