<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
    request.setCharacterEncoding("UTF-8"); 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMConfirmReceiptFiles.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
<form name='ConfirmReceiptDtl_form' id='ConfirmReceiptDtl_form' action='../../servlet/eFM.FMConfirmReceiptFilesServlet' method='post' target='messageFrame'>
<script>
	parent.frames[2].document.getElementById("hdr_tab0").style.visibility = 'Visible';
	parent.frames[2].document.getElementById("hdr_tab").style.visibility = 'Visible';
</script>
<table border='1' cellpadding='0' cellspacing='0' width='100%' align='center' id='tb1'>
<%
		Connection con			= ConnectionManager.getConnection(request);
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;

		String facility_id		= (String) session.getValue("facility_id");
		

		String FSLocation		 = "";
		String flag				 = "";
		String file_num			 = "";
		String file_type		 = "";
		String volume			 = "";
		String patient_id		 = "";
		String file_type_appl_yn = "";
		
		String fs_curr_locn_id=""; // added for this CRF HSA-CRF-0306.1
		String patientid=""; // added for this CRF HSA-CRF-0306.1
		String fileno			= "";
		String pline			= "";
		String filetypecode		= "";
		String volumeno			= "";
		String senderfacility	= "";
		String senderlocn		= "";
		String senderlocndesc	= "";
		String senderlocnid		= "";
		String senderlocnid1		= "";
		String issuedate		= "";
		String p_req_remarks	= "";
		String p_iss_remarks	= "";
         String file_type_no="";
		String classValue		= "";
		String file_type_desc	= "";
		String p_concat_string	= "";
		String volumeCriteria	= "";
		String patientCriteria	= "";
       String loca_identity="";
		StringBuffer SelectSqlString = null;
		SelectSqlString				 = new StringBuffer();
        String hdrec_locn_iden="";
		int i = 1, p_rec_cnt = 0;
		int count_tokens=0;
		String p_stored_val="";
		String pat_id="";
		String vol_no="";
		String patientno_volume="";
		ArrayList list	= new ArrayList();
		
		try
		{
			FSLocation			= request.getParameter("FSLocation");
			flag				= request.getParameter("clearflag");
			file_num			= request.getParameter("fileno");
			file_type			= request.getParameter("file_type_code");
			volume				= request.getParameter("volumeno");
			patient_id			= request.getParameter("patient_id");
			file_type_appl_yn	= request.getParameter("file_type_appl_yn");
     		hdrec_locn_iden= request.getParameter("hdrec_locn_iden");
			p_stored_val=request.getParameter("p_stored_val");
			if(flag == null || flag.equals("null")) flag="";
			if(FSLocation == null || FSLocation.equals("null")) FSLocation="";
			if(file_num == null || file_num.equals("null")) file_num="";
			if(file_type == null || file_type.equals("null")) file_type="";
			if(volume == null || volume.equals("null")) volume="";
			if(patient_id == null || patient_id.equals("null")) patient_id="";
		    if(p_stored_val== null || p_stored_val.equals("null")) p_stored_val="";
			if(file_type_appl_yn == null || file_type_appl_yn.equals("null")) file_type_appl_yn="";
			
			if(file_type_appl_yn.equals("N"))
			{
				if( session.getAttribute("objKey")!=null)
				{
					list = (ArrayList)session.getAttribute("objKey");
					if(!file_num.equals("") && !list.contains("'"+file_num+"'"))
					list.add("'"+file_num+"'");
				}
				else
				{
					if(!file_num.equals("") && !list.contains("'"+file_num+"'"))	
					list.add("'"+file_num+"'");
				}

				/// Block for String maniputlation 
				if(list.size()>0)
				{
					for(int m=0;m<list.size();m++)
					{
						 if(list.size() ==1)
						 {
							 p_concat_string  = (String)list.get(m);
						 }
						 else
						 {
							p_concat_string = p_concat_string + (String)list.get(m)+",";
						 }
					 }
				}
				if(p_concat_string!=null && !p_concat_string.equals("") && list.size() >1)
				p_concat_string  = p_concat_string.substring(0,p_concat_string.length()-1);
			}
			else if(file_type_appl_yn.equals("Y"))
			{
				if( session.getAttribute("objKey")!=null)
				{
					list = (ArrayList)session.getAttribute("objKey");
					if(!file_type.equals("") && !list.contains("'"+file_type+"'"))
					list.add("'"+file_type+"'");
				}
				else
				{
					if(!file_type.equals("") && !list.contains("'"+file_type+"'"))	
					list.add("'"+file_type+"'");
				}

				/// Block for String maniputlation 
				if(list.size()>0)
				{
					for(int m=0;m<list.size();m++)
					{
						if(list.size() ==1)
						{
							 p_concat_string  = (String)list.get(m);
						}
						else
						{
							p_concat_string = p_concat_string + (String)list.get(m)+",";
						}
					}
				}
				if(p_concat_string!=null && !p_concat_string.equals("") && list.size() >1)
				p_concat_string  = p_concat_string.substring(0,p_concat_string.length()-1);
			}


			if(!volume.equals(""))
			{
				volumeCriteria = " AND a.volume_no IN ("+volume+") ";
			}
		
		patientCriteria = " AND a.patient_id in ("+patient_id+") "; 
	
		
		if(file_num == null || file_num.equals("null")) file_num = "";
		if(file_type == null || file_type.equals("null")) file_type = "";


		if(file_num.equals("") && file_type.equals(""))
		{

			if(file_type_appl_yn.equals("N"))
			{   
			    /*Below query modified foe this CRF HSA-CRF-0306.1*/
				
				SelectSqlString.append("SELECT" );
				SelectSqlString.append("  a.File_No" );
				SelectSqlString.append("  , Get_patient_line(a.Patient_Id,'"+localeName+"') PlIne" );
				SelectSqlString.append("  , a.File_Type_Code" );
				SelectSqlString.append("  , TO_CHAR(Sent_Date_Time,'dd/mm/yyyy hh24:mi') Sent_Date_Time" );
				SelectSqlString.append("  , src_Facility_Id" );
				SelectSqlString.append("  , src_fs_Locn_Code" );
				SelectSqlString.append("  , src_Locn_Identity src_Locn_Identity" );
				SelectSqlString.append("  , dest_Facility_Id" );
				SelectSqlString.append("  , dest_fs_Locn_Code" );
				SelectSqlString.append("  , dest_Locn_Identity" );
				SelectSqlString.append("  , FM_GET_DESC.FM_STORAGE_LOCN(A.src_Facility_Id, A.SRC_fs_Locn_Code,'"+localeName+"','2') src_fs_Locn_desc" );
				SelectSqlString.append("  , Ltrim(Rtrim(a.req_Remarks)) req_Remarks" );
				SelectSqlString.append("  ,Ltrim(Rtrim(a.Iss_Remarks)) Iss_Remarks" );
				SelectSqlString.append("  , a.Volume_No" );
				SelectSqlString.append("  , c.Curr_File_Status, curr_locn_id, c.patient_id patientid " );
				SelectSqlString.append("FROM" );
				SelectSqlString.append("  fm_Transit_File a" );
				SelectSqlString.append("  , fm_Curr_Locn C " );
				SelectSqlString.append("WHERE A.dest_Facility_Id = '"+facility_id+"' " );
				SelectSqlString.append("  AND A.dest_fs_Locn_Code = '"+FSLocation+"' " );
				SelectSqlString.append("  AND a.File_No = c.File_No " );
				SelectSqlString.append("  AND a.src_Facility_Id = c.Facility_Id " );
				SelectSqlString.append("  AND a.Volume_No = c.Volume_No " );
				SelectSqlString.append("  AND c.Curr_File_Status IN ('T','E') " );
				SelectSqlString.append("  AND c.Doc_Folder_Id IS" );
				SelectSqlString.append("  NULL " );
				SelectSqlString.append("ORDER BY" );
				SelectSqlString.append("  a.File_No,a.Volume_No" );
			}
			else if(file_type_appl_yn.equals("Y"))
			{
			   /*Below query modified foe this CRF HSA-CRF-0306.1*/
				SelectSqlString.append("SELECT" );
				SelectSqlString.append("  a.File_No" );
				SelectSqlString.append("  , Get_patient_line(a.Patient_Id,'"+localeName+"') PlIne" );
				SelectSqlString.append("  , a.File_Type_Code" );
				SelectSqlString.append("  , MR_GET_DESC.MR_FILE_TYPE(A.FACILITY_ID, A.FILE_TYPE_CODE,'"+localeName+"','2') File_Type_desc" );
				SelectSqlString.append("  , TO_CHAR(Sent_Date_Time,'dd/mm/yyyy hh24:mi') Sent_Date_Time" );
				SelectSqlString.append("  , src_Facility_Id" );
				SelectSqlString.append("  , src_fs_Locn_Code" );
				SelectSqlString.append("  , src_Locn_Identity src_Locn_Identity" );
				SelectSqlString.append("  , dest_Facility_Id" );
				SelectSqlString.append("  , dest_fs_Locn_Code" );
				SelectSqlString.append("  , dest_Locn_Identity" );
				SelectSqlString.append("  , FM_GET_DESC.FM_STORAGE_LOCN(A.src_Facility_Id, A.SRC_fs_Locn_Code,'"+localeName+"','2') src_fs_Locn_desc" );
					SelectSqlString.append("  , Ltrim(Rtrim(a.req_Remarks)) req_Remarks" );
				SelectSqlString.append("  ,Ltrim(Rtrim(a.Iss_Remarks)) Iss_Remarks" );
				SelectSqlString.append("  , a.Volume_No" );
				SelectSqlString.append("  , c.Curr_File_Status, curr_locn_id, c.patient_id patientid " );
				SelectSqlString.append("FROM" );
				SelectSqlString.append("  fm_Transit_File a" );
				SelectSqlString.append("  , fm_Curr_Locn C " );
				SelectSqlString.append("WHERE A.dest_Facility_Id = '"+facility_id+"' " );
				SelectSqlString.append("  AND A.dest_fs_Locn_Code = '"+FSLocation+"' " );
				SelectSqlString.append("  AND a.File_No = c.File_No " );
				SelectSqlString.append("  AND a.src_Facility_Id = c.Facility_Id " );
				SelectSqlString.append("  AND a.Volume_No = c.Volume_No " );
				SelectSqlString.append("  AND c.Curr_File_Status IN ('T','E') " );
				SelectSqlString.append("  AND c.Doc_Folder_Id IS" );
				SelectSqlString.append("  NULL " );
				SelectSqlString.append("ORDER BY" );
				SelectSqlString.append("  a.File_No,a.Volume_No " );
			}
		}
		else
		{
			if(file_type_appl_yn.equals("N"))
			{
			       /*Below query modified foe this CRF HSA-CRF-0306.1*/
			
					SelectSqlString.append("Select a.file_no, get_patient_line(a.patient_id,'"+localeName+"') pline,a.file_type_code, TO_CHAR(a.sent_date_time,'dd/mm/yyyy hh24:mi') sent_date_time, src_facility_id, src_fs_locn_code, DECODE(A.SRC_LOCN_IDENTITY,'C','Clinic','D','Department','N','Nursing Unit','T','Practitioner','X','External','E','Procedure Unit','Y','Daycare Unit') src_locn_identity,  dest_facility_id, dest_fs_locn_code, dest_locn_identity, long_desc src_fs_locn_desc,Ltrim(Rtrim(a.req_Remarks)) req_Remarks,Ltrim(Rtrim(a.iss_remarks)) iss_remarks, a.volume_no,c.curr_file_status,curr_locn_id, c.patient_id patientid FROM fm_transit_file a, fm_storage_locn b,fm_curr_locn c where dest_facility_id = '"+facility_id+"' and dest_fs_locn_code = '"+FSLocation+"' and a.src_facility_id = b.facility_id AND a.src_fs_locn_code = b.fs_locn_code AND ( ");
			StringTokenizer pat_volumeno=new StringTokenizer(p_stored_val,"/");  
	    count_tokens=pat_volumeno.countTokens();
	    int P_cnt=0;
	  while(pat_volumeno.hasMoreTokens())
		{
	    P_cnt++;
	   patientno_volume    =pat_volumeno.nextToken() ;
	StringTokenizer fileno1=new StringTokenizer(patientno_volume,"`");		
	while(fileno1.hasMoreTokens())
		{
	pat_id =fileno1.nextToken();	
	if(fileno1.hasMoreTokens())
	file_type_no	=fileno1.nextToken();
	if(fileno1.hasMoreTokens())
	vol_no	=fileno1.nextToken();
	}
	 SelectSqlString.append("  (a.patient_id ='"+pat_id+"' ");
	SelectSqlString.append(" and a.file_no ='"+file_type_no+"' ");
	
		if(count_tokens >P_cnt){
  	 SelectSqlString.append(" AND a.volume_no ='"+vol_no+"' ) OR ");	
			} else{
                    SelectSqlString.append("AND a.volume_no ='"+vol_no +"' )");	
			}
				
		}	
		SelectSqlString.append(") AND a.file_no = c.file_no AND a.dest_facility_id = c.curr_facility_id AND a.volume_no = c.volume_no AND c.curr_file_status IN('T','E') AND c.doc_folder_id IS NULL ORDER BY a.file_no,a.volume_no");
				
		}
			else if(file_type_appl_yn.equals("Y"))
			{
				SelectSqlString.append("select a.file_no, get_patient_line(a.patient_id,'"+localeName+"') pline,a.file_type_code,c.short_desc file_type_desc, TO_CHAR(a.sent_date_time,'dd/mm/yyyy hh24:mi') sent_date_time, a.src_facility_id, a.src_fs_locn_code, DECODE(A.SRC_LOCN_IDENTITY,'C','Clinic','D','Department','N','Nursing Unit','T','Practitioner','X','External','E','Procedure Unit','Y','Daycare Unit') src_locn_identity,  dest_facility_id, dest_fs_locn_code, dest_locn_identity, b.short_desc src_fs_locn_desc, Ltrim(Rtrim(a.req_Remarks)) req_Remarks,Ltrim(Rtrim(a.iss_remarks)) iss_remarks, a.volume_no,d.curr_file_status, curr_locn_id, d.patient_id patientid FROM fm_transit_file a, fm_storage_locn b,mr_file_type c,fm_curr_locn d WHERE a.src_facility_id = c.facility_id(+) AND a.file_type_code = c.file_type_code(+) AND dest_facility_id = '"+facility_id+"' AND dest_fs_locn_code = '"+FSLocation+"' AND a.src_facility_id = b.facility_id AND a.src_fs_locn_code = b.fs_locn_code  AND (");
		
	 StringTokenizer pat_volumeno=new StringTokenizer(p_stored_val,"/");  
	  count_tokens=pat_volumeno.countTokens();
	   int P_cnt=0;
	  while(pat_volumeno.hasMoreTokens())
		{
	    P_cnt++;
	   patientno_volume    =pat_volumeno.nextToken() ;
	StringTokenizer fileno1=new StringTokenizer(patientno_volume,"`");		
	while(fileno1.hasMoreTokens())
		{
	pat_id =fileno1.nextToken();	
	if(fileno1.hasMoreTokens())
	file_type_no	=fileno1.nextToken();
	if(fileno1.hasMoreTokens())
	vol_no	=fileno1.nextToken();
	}
	 SelectSqlString.append("  (a.patient_id ='"+pat_id+"' ");
	 SelectSqlString.append(" and a.file_no ='"+file_type_no+"' ");
	 
	
		if(count_tokens >P_cnt){
  		 SelectSqlString.append(" AND a.volume_no ='"+vol_no+"' ) OR ");	
			} else{
               	     SelectSqlString.append("AND a.volume_no ='"+vol_no +"' )");	
			}
						
		}	
		//SelectSqlString.append(") AND a.file_no = d.file_no AND a.dest_facility_id = d.curr_facility_id AND a.volume_no = d.volume_no AND d.curr_file_status IN('T','E') AND d.doc_folder_id IS NULL ORDER BY a.file_no,a.volume_no");
	
		SelectSqlString.append(") AND a.file_no = d.file_no AND a.volume_no = d.volume_no AND d.curr_file_status IN('T','E') AND d.doc_folder_id IS NULL ORDER BY a.file_no,a.volume_no");
		
		}
		}
		
		
			pstmt = con.prepareStatement(SelectSqlString.toString());
			rs = pstmt.executeQuery();

			while(rs != null && rs.next()) 
			{
				if(i % 2 == 0) classValue = "QRYODD" ;
				else classValue = "QRYEVEN" ;

				fileno			= rs.getString("file_no");
				pline			= rs.getString("pline").substring(0,rs.getString("pline").length()-6);
				filetypecode	= rs.getString("file_type_code");
				volumeno		= rs.getString("volume_no");
				senderfacility	= rs.getString("src_facility_id");
				senderlocn		= rs.getString("src_fs_locn_code");
				senderlocndesc	= rs.getString("src_fs_locn_desc");
				senderlocnid	= rs.getString("src_locn_identity");
				issuedate		= rs.getString("sent_date_time");
				p_req_remarks	= rs.getString("req_remarks")==null?"":rs.getString("req_remarks");
				//	p_req_remarks=java.net.URLDecoder.decode(p_req_remarks,"UTF-8");
				p_iss_remarks	= rs.getString("iss_remarks")==null?"":rs.getString("iss_remarks");
            //    p_iss_remarks	=java.net.URLDecoder.decode(p_iss_remarks,"UTF-8");
			    /*Below line added for this CRF HSA-CRF-0306.1*/
				fs_curr_locn_id	= rs.getString("curr_locn_id")==null?"":rs.getString("curr_locn_id");
				patientid = rs.getString("patientid")==null?"":rs.getString("patientid");
			  	if(!senderlocnid.equals("")){
				switch(senderlocnid.charAt(0))
					{
						case 'D' : senderlocnid = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels");
                        loca_identity="D";
						break;
						case 'C' : senderlocnid = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); 
                          loca_identity="C";
						break;
						case 'N' : senderlocnid = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); 
                        loca_identity="N";
						break;
						case 'T' : senderlocnid = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
                        loca_identity="T";
						break;
						case 'X' : senderlocnid1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); 
                        loca_identity="X";
						break;
						case 'E' : senderlocnid= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
                        loca_identity="E";
						break;
						case 'Y' : senderlocnid = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); 
				        loca_identity="Y";
					    break; 
					}
		}
				
				if(fileno == null || fileno.equals("null")) fileno = "";
				if(pline == null || pline.equals("null")) pline = "&nbsp;";
				if(issuedate != null)
				{
					issuedate=DateUtils.convertDate(issuedate,"DMYHM","en",localeName);
				}
				else
					issuedate = "";
				if(filetypecode == null || filetypecode.equals("null")) file_type_desc = "";
				if(volumeno == null || volumeno.equals("null")) volumeno = "";
				if(p_req_remarks == null || p_req_remarks.equals("null")) p_req_remarks = "";
				if(p_iss_remarks == null || p_iss_remarks.equals("null")) p_iss_remarks = "";
				
				if(senderlocnid == null || senderlocnid.equals("null"))  senderlocnid = "";
				if(senderlocn == null || senderlocn.equals("null"))  senderlocn = "";
				if(senderlocndesc == null || senderlocndesc.equals("null")) senderlocndesc = "";
				if(senderfacility == null || senderfacility.equals("null")) 
					senderfacility = "&nbsp;";
				if(file_type_appl_yn.equals("N"))
				{
					out.println("<tr><td class='"+classValue+"'  width='30%'>");
					out.println("<font size=1><b>"+fileno+"</b><br>&nbsp;&nbsp;"+pline+"</font></td>");
					
					out.println("<td class='"+classValue+"' width='12%'><font size=1><CENTER>");
				}
				else if(file_type_appl_yn.equals("Y"))
				{
					out.println("<tr><td class='"+classValue+"' width='30%'>");
					out.println("<font size=1>&nbsp;"+pline+"</font></td>");
					
					out.println("<td class='"+classValue+"' width='12%'><font size=1><CENTER>");
					file_type_desc = rs.getString("FILE_TYPE_DESC");
					if(file_type_desc == null || file_type_desc.equals("null")) 
						file_type_desc = "&nbsp;";
					out.println(file_type_desc);
					if(!file_type_desc.equals("&nbsp;"))
						out.println(" / ");
				}
				out.println(volumeno+"</CENTER></font></td>");
				out.println("<td class='"+classValue+"' width='8%'><font size=1 color='red'>");
				if(p_req_remarks.equals("") )
				{
					out.println("&nbsp;</font></td>");
				}
				else
				{
				%>
				<a href='javascript:GetShowRemarks("ReqComm<%=i%>","<%=p_req_remarks%>","R")'>  <fmt:message key="Common.view.label" bundle="${common_labels}"/>&nbsp; <fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></font></td>
				<%					
				}
				out.println("<td class='"+classValue+"' width='20%'>");

				if(senderlocndesc == null || senderlocndesc.equals("null"))
					out.println("&nbsp;</td>");
				else
				out.println("<font size=1>"+senderlocndesc+" - ("+senderlocnid+")</font></td>");
				out.println("<td  class='"+classValue+"' width='8%'><font size=1>");

				if(p_iss_remarks.equals(""))
				{
					out.println("&nbsp;</font></td>");
				}
				else
				{
				%>
					<a href='javascript:GetShowRemarks("txtComm<%=i%>","<%=p_iss_remarks%>","IR")'><fmt:message key="Common.view.label" bundle="${common_labels}"/>&nbsp; <fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></font></td>
				<%					
				}
				out.println("<td align='center' class='"+classValue+"'width='15%' >");
				out.println("<font size=1>"+issuedate+"</font></td>");
				out.println("<td  align='center' class='"+classValue+"' width='7%'>");
				out.println("<input type='checkbox' name='confirmbox"+i+"' id='confirmbox"+i+"' value='Y' Checked onClick='confirmSelection(this);'></td></tr>");
				out.println("<input type='hidden' name='file"+i+"' id='file"+i+"' value='"+fileno+"'>");
				out.println("<input type='hidden' name='filetype"+i+"' id='filetype"+i+"' value='"+filetypecode+"'>");
				out.println("<input type='hidden' name='volume"+i+"' id='volume"+i+"' value='"+volumeno+"'>");
				out.println("<input type='hidden' name='issuelocn"+i+"' id='issuelocn"+i+"' value='"+senderlocn+"'>");
				out.println("<input type='hidden' name='senderfacility"+i+"' id='senderfacility"+i+"' value='"+senderfacility+"'>");
				out.println("<input type='hidden' name='ReqComm"+i+"' id='ReqComm"+i+"' value='"+p_req_remarks+"'>");
				out.println("<input type='hidden' name='txtComm"+i+"' id='txtComm"+i+"' value='"+p_iss_remarks+"'>");				
				out.println("<input type='hidden' name='fs_curr_locn_id"+i+"' id='fs_curr_locn_id"+i+"' value='"+fs_curr_locn_id+"'>"); //Added for this CRF HSA-CRF-0306.1
				out.println("<input type='hidden' name='patientid"+i+"' id='patientid"+i+"' value='"+patientid+"'>"); //Added for this CRF HSA-CRF-0306.1 
				i++;
				p_rec_cnt++;
			}

			if((SelectSqlString != null) && (SelectSqlString.length() >0))
			{
				SelectSqlString.delete(0,SelectSqlString.length());
			}
			%>
			<script>
				var p_rec_cnt = '<%=p_rec_cnt %>'
				if (p_rec_cnt==0) 
				{
					parent.frames[2].document.getElementById("hdr_tab").style.visibility = 'hidden';
					parent.frames[2].document.getElementById("hdr_tab0").style.visibility = 'hidden';
					alert(getMessage('NO_RECORD_FOR_CONFIRM','FM'));
				  parent.frames[2].document.forms[0].show.disabled=false;
			     parent.frames[2].document.forms[0].add.disabled=false;
			     parent.frames[2].document.forms[0].clear.disabled=false;
					parent.frames[3].location.href='../../eCommon/html/blank.html';
				}
				parent.parent.frames[2].frames[4].location.href="../../eCommon/jsp/error.jsp?";
			</script>
			<%
	if(rs!=null)	rs.close();
	if(pstmt!=null) pstmt.close();
	}catch(Exception e){
		e.printStackTrace();
		}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}
%>
</table>
<script>
	for (i=0;i<7;i++)
	{
		//if ((document.getElementById("tb1").rows(i+1) != null) && (document.getElementById("tb1").rows(i+1).cells(i) != null))
		if ((document.getElementById("tb1").rows[i+1] != null) && (document.getElementById("tb1").rows[i+1].cells[i] != null))

		{
			parent.receipt_criteria.document.getElementById("hdr_tab").rows(0).cells(i).width = document.getElementById("tb1").rows(i+1).cells(i).width; 
		}
	}
	parent.frames[2].FMConfirmRcptCriteria_form.patient_id.value='';
	parent.frames[2].FMConfirmRcptCriteria_form.patient_id.focus();
	parent.frames[2].document.getElementById("patientid1").onblur();
	 //parent.frames[2].populateDynamicValues(parent.frames[2].FMConfirmRcptCriteria_form.patient_id);

           parent.frames[2].document.forms[0].show.disabled=false;
			parent.frames[2].document.forms[0].add.disabled=false;
			parent.frames[2].document.forms[0].clear.disabled=false;
</script>
	<input type='hidden' name='reccount' id='reccount' value='<%=i%>'>
	<input type='hidden' name='filenos' id='filenos' value=''>
	<input type='hidden' name='filetypecodes' id='filetypecodes' value=''>
	<input type='hidden' name='volumenos' id='volumenos' value=''>
	<input type='hidden' name='issue_locns' id='issue_locns' value=''>
	<input type='hidden' name='rec_locn_code' id='rec_locn_code' value=''>
	<input type='hidden' name='rec_locn_iden' id='rec_locn_iden' value='<%=hdrec_locn_iden%>'>
	<input type='hidden' name='rec_user_id' id='rec_user_id' value=''>
	<input type='hidden' name='file_type_appl_yn' id='file_type_appl_yn' value='<%=file_type_appl_yn%>'>
	<input type='hidden' name='senderfacility' id='senderfacility' value=''>
	<!--Added for this CRF HSA-CRF-0306.1-->
	<input type='hidden' name='fs_curr_locn_id' id='fs_curr_locn_id' value=''> 
	<input type='hidden' name='patientid' id='patientid' value=''> 
</form>
</body>
</html>
<%
if(flag.equals("C"))
{
	if(session.getAttribute("objKey") != null)
		session.removeAttribute("objKey");
}
session.setAttribute("objKey",list);
%>

