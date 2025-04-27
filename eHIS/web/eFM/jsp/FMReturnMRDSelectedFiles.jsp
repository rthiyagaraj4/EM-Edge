<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<head> 
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
	<script language='javascript' src='../../eFM/js/FMReturnMRDFile.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY onMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
<FORM name = 'fm_select_form' action='../../servlet/eFM.FMReceiveFileAtMRDServlet' method='post' target='messageFrame'>
<%
	Connection con			= ConnectionManager.getConnection(request);
	PreparedStatement pstmt	= null;
	ResultSet rs			= null;
	PreparedStatement pstmt2	= null;
	ResultSet rs2			= null;
	
	StringBuffer SelectSqlBuffer	= null;

	String p_select_values			= "";
	String p_concat_string			= "";
	String p_files_not_in			= "";
	String return_date_time			= "";
	String patientno_volume="";
	String pat_id1="";
	String vol_no="";
	String buttonVal ="";           
	String curr_fac_id="";
	String curfista="";
	String outfacid="";
	String patientid="";
	String filenum="";
	String facid="";
	String duration_type="";
	String return_criteria="";
	String no_of_dh_to_return_op="0";
	String discharge_date_time="";
	int p_count = 0;
	int count_tokens=0;
    int rec_count=0;
    int P_cnt=0;
   int parameter_hours=0;

   boolean isModifyLongShortDescAppl = false;//Added by Kamatchi S on 12/09/2019 for ML-MMOH-CRF-1417

try
{	
	
	SelectSqlBuffer = new StringBuffer();
	String facilityid 			= (String) session.getValue("facility_id");
	String curr_fs_locn_identity = "";
	String PatFile_string		= "";
	String p_stored_val			= request.getParameter("p_select_files");
	String p_not_in_files		= request.getParameter("p_deselect_files");
	String added_volumes		= request.getParameter("added_volumes");
	String p_include_in_select	= request.getParameter("p_include_in_select");
	String curr_fstat			= request.getParameter("curr_fstat");
	String p_outst_fcy			= request.getParameter("p_outst_fcy");
	String p_fs_locn_id			= request.getParameter("p_fs_locn_id");
	String p_out_fsloc			= request.getParameter("p_out_fsloc");
	String file_type_appl_yn	= request.getParameter("file_type_appl_yn");
	String p_stored_val1		= request.getParameter("p_stored_val");
	String file_num    = request.getParameter("p_patient_file_no");
	String volume_no1= request.getParameter("volume_no");
	String patient_id=request.getParameter("patient_id");
	String p_receiving_fs_locn=request.getParameter("p_receiving_fs_locn");
   String curr_file_status="";
	buttonVal					= request.getParameter("buttonVal");

	isModifyLongShortDescAppl =  eCommon.Common.CommonBean.isSiteSpecific(con,"FM","RECEIVE_FILE_MRD_MSG"); //Added by Kamatchi S on 12/09/2019 for ML-MMOH-CRF-1417
			
	if(buttonVal == null) buttonVal = "";

	if(patient_id==null) patient_id="";
	if(volume_no1==null) volume_no1="";
	if(file_num==null) file_num="";
   if(p_receiving_fs_locn==null) p_receiving_fs_locn="";
	String p_fs_location = request.getParameter("p_fs_location")==null?"":request.getParameter("p_fs_location");
	
	String accept_out_intransit_yn	= (String) session.getValue("accept_out_intransit_yn");

	if(accept_out_intransit_yn==null)
		accept_out_intransit_yn="N";

//	if(accept_out_intransit_yn.equals("Y"))
	//{
   pstmt	= con.prepareStatement("select curr_facility_id,curr_file_status from  fm_curr_locn where facility_id = '"+facilityid+"' and patient_id='"+patient_id+"' and file_no='"+file_num+"' and volume_no='"+volume_no1+"' ");
	rs		= pstmt.executeQuery();
 while(rs != null && rs.next()){
  curr_fac_id =rs.getString("curr_facility_id");
 curr_file_status=rs.getString("curr_file_status");
 }
//  }

	if(rs!=null)	rs.close();
  if(pstmt!=null) pstmt.close();
  
    
	
	
	
	if(curr_fac_id == null) curr_fac_id = "";
	if(file_type_appl_yn == null) file_type_appl_yn = "N";
	if(p_not_in_files == null) p_not_in_files = "";
    if(p_stored_val1 == null) p_stored_val1 = "";
	if(p_include_in_select == null) p_include_in_select = "";
	if(added_volumes == null) added_volumes="";
	if(curr_fstat == null || curr_fstat.equals("null")) curr_fstat = "";
    
	if(buttonVal.equals("A"))
	{
	if(!p_outst_fcy.equals("") && curr_fstat.equals("T")){
   
   if(!facilityid.equals(p_outst_fcy) && curr_fstat.equals("T"))
	{
       curr_fstat="E";
	}

	if(facilityid.equals(p_outst_fcy) && curr_fstat.equals("T") && curr_file_status.equals("E"))
	{
       curr_fstat="E";
	}
    
 }else if(curr_fstat.equals("T") && curr_file_status.equals("E") ){
curr_fstat=curr_file_status;
   }
	}
	
	 pstmt	= con.prepareStatement("select count(*) cnt from  fm_curr_locn where facility_id = '"+facilityid+"' and patient_id='"+patient_id+"' and file_no='"+file_num+"' and volume_no='"+volume_no1+"' and curr_file_status!='I' and  curr_file_status=nvl('"+curr_fstat+"',curr_file_status) and curr_fs_locn_code=nvl('"+p_fs_location+"',curr_fs_locn_code) and curr_facility_id=nvl('"+p_outst_fcy+"',curr_facility_id) ");
	
	  rs		= pstmt.executeQuery();
	while(rs != null && rs.next()) {
		rec_count =rs.getInt("cnt");
	}
	
	
	
	added_volumes = java.net.URLDecoder.decode(added_volumes);

	StringTokenizer token = new StringTokenizer(p_stored_val,"|");

	while(token.hasMoreTokens()) {
		if(p_count ==0) {
			p_concat_string     = "'" + token.nextToken() +"'";
		}
		else {
			p_concat_string     = p_concat_string + ",'" + token.nextToken() +"'";
		}
		p_count++;
	}

	if(p_concat_string.length() == 0) p_concat_string = "''";
	
	p_count = 0;

	if (!p_not_in_files.equals("")) {
		StringTokenizer token1 = new StringTokenizer(p_not_in_files,"|");
		String getTokenValue="";

		while(token1.hasMoreTokens()) {
			getTokenValue = token1.nextToken();

			if(p_count == 0) {
				p_files_not_in     = "'" + getTokenValue +"'";
			}
			else {
				p_files_not_in     = p_files_not_in + ",'" + getTokenValue +"'";
			}
			p_count++;
		}
	}
	
	SelectSqlBuffer.append("SELECT" );
	SelectSqlBuffer.append("  a.file_no " );
	SelectSqlBuffer.append("  ,a.facility_id " );
	SelectSqlBuffer.append("  ,a.patient_id " );
	SelectSqlBuffer.append("  ,get_patient_line(a.patient_id,'"+localeName+"')patient_line " );
	SelectSqlBuffer.append("  ,a.curr_file_status curr_file_status1 " );
	SelectSqlBuffer.append("  ,a.curr_fs_locn_code " );
	SelectSqlBuffer.append("  ,fm_Get_desc.Fm_storage_locn(a.CURR_FACILITY_ID,a.curr_fs_locn_code,'"+localeName+"',2) curr_fs_locn_short_desc " );
	SelectSqlBuffer.append("  ,a.curr_fs_locn_identity curr_fs_locn_identity " );
	SelectSqlBuffer.append("  ,nvl(TO_CHAR(a.return_date_time,'dd/mm/rrrr hh24:mi') ,'&nbsp;')return_date_time " );
	SelectSqlBuffer.append("  ,DECODE(a.curr_file_status,'I',1,'O',1,'L',3,'T',2,'A',4,'E',2,'R',1)order_by_status " );
	SelectSqlBuffer.append("  ,( " );
	SelectSqlBuffer.append("  CASE " );
	SelectSqlBuffer.append("  WHEN a.curr_facility_id<> a.facility_id " );
	SelectSqlBuffer.append("  THEN" );
	SelectSqlBuffer.append("    '('|| (SM_GET_DESC.SM_FACILITY_PARAM(a.CURR_FACILITY_ID,'"+localeName+"','1'))||')' " );
	SelectSqlBuffer.append("  ELSE '&nbsp;' " );
	SelectSqlBuffer.append("  END )curr_facility_name,a.CURR_FACILITY_ID " );
	SelectSqlBuffer.append("  ,ltrim(rtrim(a.req_remarks))req_remarks " );
	SelectSqlBuffer.append("  ,ltrim(rtrim(a.remarks))remarks " );
	SelectSqlBuffer.append("  ,MR_GET_DESC.MR_FILE_TYPE(a.FACILITY_ID, a.FILE_TYPE_CODE,'"+localeName+"','2') file_type_desc " );
	SelectSqlBuffer.append("  ,a.file_type_code " );
	SelectSqlBuffer.append("  ,a.volume_no " );
	SelectSqlBuffer.append("  ,b.return_criteria " );
	SelectSqlBuffer.append("  ,b.no_of_dh_to_return_op " );
	SelectSqlBuffer.append("  ,b.duration_type " );
	SelectSqlBuffer.append("FROM" );
	SelectSqlBuffer.append("  fm_curr_locn a, fm_storage_locn b " );
   SelectSqlBuffer.append(" WHERE  a.perm_fs_locn_code = '"+p_receiving_fs_locn+"' " );
	
	SelectSqlBuffer.append(" AND a.facility_id='"+facilityid+"' " );
	

	if(!p_stored_val1.equals(""))
	{
	
	StringTokenizer pat_volumeno=new StringTokenizer(p_stored_val1,"/");  
	    count_tokens=pat_volumeno.countTokens();
	 
	   SelectSqlBuffer.append( "AND ( ");
	  while(pat_volumeno.hasMoreTokens())
	  {
	    P_cnt++;
	    patientno_volume    =pat_volumeno.nextToken() ;
		StringTokenizer fileno1=new StringTokenizer(patientno_volume,"`");		
		 int cnt=fileno1.countTokens();
		while(fileno1.hasMoreTokens())
		{
			patientid=fileno1.nextToken();	
			pat_id1 =fileno1.nextToken();	
						
			if(cnt==5)
			{
			curfista=fileno1.nextToken();	
			outfacid=fileno1.nextToken();
			if(curfista.equals("curfista"))
				{
                  curfista="";
				}
			 if(outfacid.equals("p_out_fcy"))
				{
                  outfacid="";
				}
			
			}
			
			
			vol_no	=fileno1.nextToken();
			int indxx=PatFile_string.indexOf(pat_id1 +"-"+vol_no+"-"+facilityid,0);
			if(indxx<0){
	            PatFile_string =  pat_id1 +"-"+vol_no+"-"+facilityid+","+PatFile_string ;
			}
		}

	    SelectSqlBuffer.append( " ( a.file_no ='"+pat_id1+"' ");
       SelectSqlBuffer.append("  AND a.patient_id ='"+patientid+"' ");
	  
	  if(!outfacid.equals(""))
		  SelectSqlBuffer.append("  AND a.curr_facility_id =nvl( '"+outfacid+"',a.curr_facility_id) ");
	 outfacid="";	 
	
	if(!curr_fstat.equals("S"))
	{
	
			
			if(curfista.equals("T"))
			{
			SelectSqlBuffer.append(" AND a.CURR_FILE_STATUS IN('T','E') ");
			curfista="";
			}else{
			SelectSqlBuffer.append(" AND a.CURR_FILE_STATUS=nvl('"+curfista+"',a.CURR_FILE_STATUS) ");
		   curfista="";
		
		}
	   SelectSqlBuffer.append("AND a.CURR_FILE_STATUS!='I'");
		}
		 
		 if (!vol_no.equals(""))
		 {
				if(count_tokens >P_cnt)
				{
					SelectSqlBuffer.append(" AND a.volume_no ='"+vol_no+"' ) OR ");	
				
				}
				else
				{
					SelectSqlBuffer.append(" AND a.volume_no ='"+vol_no +"' ))");	
				}
			}
		}	
	
	  }

	if(buttonVal.equals("S"))
	{
		
		 if(curr_fstat.equals("T")){
        SelectSqlBuffer.append(" AND a.CURR_FILE_STATUS IN ('T','E')");
		 }else if(!curr_fstat.equals("")){
		SelectSqlBuffer.append(" AND a.CURR_FILE_STATUS='"+curr_fstat+"' ");
		
		// SelectSqlBuffer.append(" WHERE a.CURR_FILE_STATUS=nvl('"+curr_fstat+"',a.CURR_FILE_STATUS)");
		 }
		// SelectSqlBuffer.append(" AND a. perm_fs_locn_code = '"+p_receiving_fs_locn+"' " );
	 	 if(!p_outst_fcy.equals("")){
		SelectSqlBuffer.append("  AND a.curr_facility_id = '"+p_outst_fcy+"' ");
		}	
	    	
	   } 
	
 SelectSqlBuffer.append(" AND a.curr_facility_id = b.facility_id " );
	SelectSqlBuffer.append(" AND a.curr_fs_locn_code = b.fs_locn_code " );
	
	if(!p_fs_locn_id.equals(""))
	{
	SelectSqlBuffer.append("  AND a.curr_fs_locn_identity = decode('"+p_fs_locn_id+"','',a.curr_fs_locn_identity,'"+p_fs_locn_id+"') " );
	}
	if(!p_out_fsloc.equals(""))
	{
	SelectSqlBuffer.append("  AND a.curr_fs_locn_code =decode('"+p_out_fsloc+"','',a.curr_fs_locn_code,'"+p_out_fsloc+"') " );
	}
	SelectSqlBuffer.append("  AND a.doc_folder_id IS" );
	SelectSqlBuffer.append("  null " );
	SelectSqlBuffer.append("ORDER BY" );
	SelectSqlBuffer.append("  a.return_date_time  desc" );
	SelectSqlBuffer.append("  ,a.curr_fs_locn_code " );
	SelectSqlBuffer.append("  ,a.file_no" );

   //pstmt	= con.prepareStatement(SelectSqlBuffer.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	pstmt	= con.prepareStatement(SelectSqlBuffer.toString());
		
		rs		= pstmt.executeQuery();
		%>
	<script>parent.frames[2].document.getElementById("hdr_tab").style.visibility='Visible';</script>
	<TABLE border='1' cellpadding='2' cellspacing='0' width='100%'  id="srch_result">
	<%
	
	String classValue					= "";
	String bgcolor						= "";
	String p_allow_select				= "";
	String p_checked					= "";
	String file_type_desc				= "";
	String file_type_code				= "";
	String volume_no					= "";
	String p_first_curr_fs_locn_code	= "";
     String cur_facility_id=""; 
	int i					= 0;
	int p_rec_cnt			= 0;
	int p_return_cnt		= 0;
	int p_not_return_cnt	= 0;
	int counter				= 0;
 
 if(buttonVal.equals("S")){ // handle show all part


	while(rs != null && rs.next()) {
		if(i % 2 == 0) classValue = "QRYEVEN" ;
		  else classValue = "QRYODD" ;

	cur_facility_id=rs.getString("CURR_FACILITY_ID");
	if(rs.getString("curr_file_status1").equals("A")) {
		bgcolor			= "gold";
		p_allow_select	= "disabled";
		p_checked		= "";
	}
	else if (rs.getString("curr_file_status1").equals("T")) {
		/*bgcolor			= "darkseagreen";
		p_allow_select	= "disabled";
		p_checked		= "";*/
		if(accept_out_intransit_yn.equals("N"))
		{
		bgcolor			= "darkseagreen";
		p_allow_select	= "disabled";
		p_checked		= "";
		}
		else
		{
		bgcolor			= "darkseagreen";
		p_allow_select	= "";
		p_checked		= "checked";
		}
		
	}
	else if (rs.getString("curr_file_status1").equals("L")) {
		bgcolor			= "mediumvioletred";
		p_allow_select	= "disabled";
		p_checked		= "";
	}
	else if (rs.getString("curr_file_status1").equals("I")) {
		bgcolor			= "E0FFFF";
		p_allow_select	= "";
		p_checked		= "";
	}
	else if (rs.getString("curr_file_status1").equals("O")) {
		if(accept_out_intransit_yn.equals("N"))
		{
		bgcolor			= "sandybrown";
		p_allow_select	= "disabled";
		p_checked		= "";
		}
		else
		{
		bgcolor			= "sandybrown";
		p_allow_select	= "";
		p_checked		= "checked";
		}
	}
	else if (rs.getString("curr_file_status1").equals("E")) {
		if(accept_out_intransit_yn.equals("N"))
		{
        bgcolor			= "cyan";
		p_allow_select	="disabled";
		p_checked		= "";
		}else{
		bgcolor			= "cyan";
		p_allow_select	= "";
		p_checked		= "checked";
		}
	}
	else if (rs.getString("curr_file_status1").equals("R")) {
		bgcolor			= "#C0C0C0";
		p_allow_select	= "";
		p_checked		= "checked";
	}
	else {
		bgcolor			= "";
		p_allow_select	= "";
		p_checked		= "";
	}
	if (rs.getString("curr_file_status1").equals("I") || rs.getString("curr_file_status1").equals("O")) {
		if(p_return_cnt == 0) {
			%>
			<TR><td class='columnheader' colspan ='7' ><b><h5><font size=1><fmt:message key="eFM.FilestobeReturned.label" bundle="${fm_labels}"/></font></td></TR>
			<%
		}
		p_return_cnt++;
	}
	if(rs.getString("curr_file_status1").equals("L") || rs.getString("curr_file_status1").equals("A") || rs.getString("curr_file_status1").equals("T")) {

		if(p_not_return_cnt == 0) {
			if(p_return_cnt > 0) {
				%>
				<TR id='file_trans'><td class='columnheader' colspan = '7' ><b><h5><font size=1><fmt:message key="eFM.FilescannotbeReturned.label" bundle="${fm_labels}"/></font></td></TR>
				<%
			}
			else {
				%>
				<TR id='file_trans'><td class='columnheader' colspan = '7' ><b><h5><font size=1><fmt:message key="eFM.FilescannotbeReturned.label" bundle="${fm_labels}"/></font></td></TR>
				<%
			}
		}
		p_not_return_cnt++;
	
	
	}

curr_fs_locn_identity=rs.getString("curr_fs_locn_identity");
if(!curr_fs_locn_identity.equals("")){
	switch(curr_fs_locn_identity.charAt(0))
			{
				case 'D' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); break;

				case 'C' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;

				case 'N' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;

				case 'T' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); break;

				case 'X' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;

				case 'E' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;

				case 'Y' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
		
			}
}
		%>
     	<%
		   counter++ ;
        if(counter % 2 == 0) classValue = "QRYODD" ;
        else classValue = "QRYEVEN" ;

		String tempstr = rs.getString("patient_line").substring(0,rs.getString("patient_line").length()-6);
		StringTokenizer st = new StringTokenizer(tempstr, ",");

		st.nextToken();
		st.nextToken();
		st.nextToken();
		st.nextToken();

		//String patient_id	= st.nextToken();

		String pat_id		= rs.getString("patient_id");
		file_type_desc		= rs.getString("file_type_desc");
		file_type_code		= rs.getString("file_type_code");
		volume_no			= rs.getString("volume_no");
        filenum              = rs.getString("file_no");
		facid              = rs.getString("facility_id");
		p_first_curr_fs_locn_code = rs.getString("curr_fs_locn_code");
		 return_criteria =rs.getString("return_criteria");
      no_of_dh_to_return_op=rs.getString("no_of_dh_to_return_op");
      duration_type=rs.getString("duration_type");
		
	/*	pstmt1	= con.prepareStatement("select return_criteria  ,no_of_dh_to_return_op  , duration_type from  fm_storage_locn where fs_locn_code='"+p_first_curr_fs_locn_code+"' and facility_id='"+facid+"'");
	  rs1		= pstmt1.executeQuery();
   while(rs1 != null && rs1.next()){
    return_criteria =rs1.getString("return_criteria");
    no_of_dh_to_return_op=rs1.getString("no_of_dh_to_return_op");
    duration_type=rs1.getString("duration_type");
    }
     if(rs1!=null)	rs1.close();
     if(pstmt1!=null) pstmt1.close(); */
		
	   if(no_of_dh_to_return_op==null) no_of_dh_to_return_op="0";
	    	if(return_criteria==null) return_criteria="";
			if(duration_type==null) duration_type="";
		
		if ((file_type_desc == null)||(file_type_desc.equals(""))) file_type_desc = "&nbsp;";
		else file_type_desc = file_type_desc + " / ";
		if (file_type_code == null) file_type_desc = "";
		if (volume_no == null) volume_no = "";
		if (filenum == null) filenum = "";
		if (facid == null) facid = "";
		
		        if(duration_type.equals("D"))
					{
						parameter_hours = Integer.parseInt(no_of_dh_to_return_op) * 24;
					}
					else
					{
						parameter_hours = Integer.parseInt(no_of_dh_to_return_op);	
					}
					
				
		
		%>
		
		<tr>
		<% if(file_type_appl_yn.equals("N")) {%>
			<td width="30%"  class="<%= classValue %>" >
			<A HREF CLASS="label" onMouseover="changeCursor(this)" onClick="callPatDetails('<%= pat_id %>')">&nbsp;+&nbsp;</A><font size=1><b><%= rs.getString("file_no") %></b>
			<br><input type=hidden name=file_no<%=i%> value="<%= rs.getString("file_no") %>">&nbsp;&nbsp;&nbsp;&nbsp;<%=rs.getString("patient_line").substring(0,rs.getString("patient_line").length()-6)%>
			<input type=hidden name=patient_id<%=i%> value="<%=pat_id %>">
			</td>
			<td width="12%" align="CENTER" class="<%=classValue%>" ><font size=1><%=volume_no%></font><input type="Hidden" name="file_type_code<%=i%>" id="file_type_code<%=i%>" value="<%=file_type_code%>"><input type="Hidden" name="volume_no<%=i%>" id="volume_no<%=i%>" value="<%=volume_no%>"></td>	
		<% }
			else if (file_type_appl_yn.equals("Y")) {%>
			<td width="30%"  class="<%= classValue %>" >
			<A HREF CLASS="label" onMouseover="changeCursor(this)" onClick="callPatDetails('<%= pat_id %>')">&nbsp;+&nbsp;</A><font size=1><input type=hidden name=file_no<%=i%> value="<%= rs.getString("file_no") %>">&nbsp;<%=rs.getString("patient_line").substring(0,rs.getString("patient_line").length()-6)%>
			<input type=hidden name=patient_id<%=i%> value="<%=pat_id %>">
			</td>
			<td width="12%" align="CENTER" class="<%=classValue%>" ><font size=1><%=file_type_desc%><%=volume_no%></font><input type="Hidden" name="file_type_code<%=i%>" id="file_type_code<%=i%>" value="<%=file_type_code%>"><input type="Hidden" name="volume_no<%=i%>" id="volume_no<%=i%>" value="<%=volume_no%>"></td>
		<%}

			String p_iss_remarks = rs.getString("remarks")==null?"":rs.getString("remarks");
		//	p_iss_remarks=java.net.URLDecoder.decode(p_iss_remarks,"UTF-8");
			out.println("<td align='CENTER' class='"+classValue+"' width='8%'><font size=1>");
			if(p_iss_remarks.equals("")) {
				out.println("&nbsp;</font></td>");
			} 
			else {
				%>
				<a href='javascript:GetShowRemarks("txtComm<%=i%>","<%=p_iss_remarks%>","IR")'><fmt:message key="Common.view.label" bundle="${common_labels}"/>&nbsp; <fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></font></td>
			<%}%>
			<%String curr_fac=rs.getString("curr_facility_name");%>
			<td width=17%  class="<%= classValue %>" ><font size=1>
			<%= rs.getString("curr_fs_locn_short_desc") %>			
			<%if(!curr_fac.equals("&nbsp;")){%> 
			<br>&nbsp;&nbsp;(<%= curr_fs_locn_identity%>)  / <%=curr_fac%>
			<%}else{%>
              <br>&nbsp;&nbsp;(<%= curr_fs_locn_identity%>)   
			  <%}%>
			</font></td>
			<%
				return_date_time=rs.getString("return_date_time");

				if(!return_date_time.equals("&nbsp;"))
				{
		return_date_time=DateUtils.convertDate(return_date_time,"DMYHM","en",localeName);
				}
		
		 if(return_criteria.equals("D"))
			{
		 pstmt2	= con.prepareStatement("SELECT to_char(discharge_date_time+ "+(parameter_hours)+" / 24, 'dd/mm/yyyy hh24:mi') discharge_date_time  FROM pr_encounter WHERE discharge_date_time is not null AND facility_id ='"+facid+"' AND patient_id in (SELECT patient_id FROM fm_movement_log WHERE file_no ='"+filenum+"' AND facility_id ='"+facid+"' AND sent_date_time IS NOT null)");
	      
		   rs2		= pstmt2.executeQuery();
         while(rs2 != null && rs2.next()){
        discharge_date_time =rs2.getString("discharge_date_time");
           }
       if(rs2!=null)	rs2.close();
       if(pstmt2!=null) pstmt2.close();
	       if(discharge_date_time==null) discharge_date_time="";
		  
		  if(!discharge_date_time.equals("") || discharge_date_time!=null)
				{
					discharge_date_time=DateUtils.convertDate(discharge_date_time,"DMYHM","en",localeName);
				}		
			
			if(return_date_time.equals("&nbsp;") || return_date_time!=null)
				{
				 return_date_time=discharge_date_time;
				}
			
			 if(parameter_hours<=0)
							{
             return_date_time="";
							}
			if(return_date_time.equals(""))  return_date_time="&nbsp;";
			}
				
			%>
			<td width="15%" align="CENTER" class="<%= classValue %>" ><font size=1>
			<%=return_date_time%>
			</font></td>
			


			<td width=8% align="CENTER" class="<%= classValue %>" ><font size=1>
			<a href="javascript:GetRemarks(<%= i %>)"><fmt:message key="Common.EnterRemarks.label" bundle="${common_labels}"/></a>
			<input type="hidden" name="rem_recnum_<%=i%>" id="rem_recnum_<%=i%>" value="">
			</font></td>	
			<td width="10%" align='center' style='background-color:<%=bgcolor%>' class='<%=classValue %>'><font size=1>
			<input type=checkbox name="req_select<%=i%>" id="req_select<%=i%>" <%=p_checked%> <%=p_allow_select%> value='Y'>
			<input type=hidden name="cur_facility_id<%=i%>" id="cur_facility_id<%=i%>"  value="<%=cur_facility_id%>">
			
			</font></td>
		</tr>
		<%
		if(p_select_values=="") {
			p_select_values = rs.getString("file_no")+'`'+rs.getString("facility_id");
		}
		else {
			p_select_values = p_select_values + '|' + rs.getString("file_no")+'`'+rs.getString("facility_id");
		}
		i++;
		p_rec_cnt++;

		//p_first_curr_fs_locn_code = rs.getString("curr_fs_locn_code");
	} //endwhile



}else{ // to handle the add part
		
	
	  ArrayList arr_list_out=new ArrayList();
	HashMap h_map=new HashMap();
	String collection_key="";
		
		   while(rs != null && rs.next()) {
			 
			 filenum              = rs.getString("file_no");
		     facid              = rs.getString("facility_id");
		     p_first_curr_fs_locn_code = rs.getString("curr_fs_locn_code");
		   String returndate  =rs.getString("RETURN_DATE_TIME");
		   return_criteria =rs.getString("return_criteria");
           no_of_dh_to_return_op=rs.getString("no_of_dh_to_return_op");
          duration_type=rs.getString("duration_type");
	
	/*	pstmt1	= con.prepareStatement("select return_criteria  ,no_of_dh_to_return_op  , duration_type from  fm_storage_locn where fs_locn_code='"+p_first_curr_fs_locn_code+"' and facility_id='"+facid+"'");
	  rs1		= pstmt1.executeQuery();
   while(rs1 != null && rs1.next()){
    return_criteria =rs1.getString("return_criteria");
    no_of_dh_to_return_op=rs1.getString("no_of_dh_to_return_op");
    duration_type=rs1.getString("duration_type");
    }
     if(rs1!=null)	rs1.close();
     if(pstmt1!=null) pstmt1.close(); */
		
	         if(no_of_dh_to_return_op==null) no_of_dh_to_return_op="0";
	    	if(return_criteria==null) return_criteria="";
			if(duration_type==null) duration_type="";
				
		if (filenum == null) filenum = "";
		if (facid == null) facid = "";
		
		        if(duration_type.equals("D"))
					{
						parameter_hours = Integer.parseInt(no_of_dh_to_return_op) * 24;
					}
					else
					{
						parameter_hours = Integer.parseInt(no_of_dh_to_return_op);	
					}
		 if(return_criteria.equals("D"))
			{
		 pstmt2	= con.prepareStatement("SELECT to_char(discharge_date_time+ "+(parameter_hours)+" / 24, 'dd/mm/yyyy hh24:mi') discharge_date_time  FROM pr_encounter WHERE discharge_date_time is not null AND facility_id ='"+facid+"' AND patient_id in (SELECT patient_id FROM fm_movement_log WHERE file_no ='"+filenum+"' AND facility_id ='"+facid+"' AND sent_date_time IS NOT null)");
	      
		   rs2		= pstmt2.executeQuery();
         while(rs2 != null && rs2.next()){
        discharge_date_time =rs2.getString("discharge_date_time");
           }
       if(rs2!=null)	rs2.close();
       if(pstmt2!=null) pstmt2.close();
		

          if(discharge_date_time==null) discharge_date_time="";
		  
		  if(!discharge_date_time.equals("") || discharge_date_time!=null)
				{
					discharge_date_time=DateUtils.convertDate(discharge_date_time,"DMYHM","en",localeName);
				}		
			
			if(returndate.equals("&nbsp;") || returndate!=null)
				{
				 returndate=discharge_date_time;
				}
			   if(parameter_hours<=0)
							{
						returndate="";
						}
			
			
			if(returndate.equals(""))  returndate="&nbsp;";
			}
	
	
	
	
	//ArrayList arr_list_out=new ArrayList();
	//HashMap h_map=new HashMap();
	//String collection_key="";
	//while(rs != null && rs.next()) {  // building the collection;

      ArrayList arr_list_in=new ArrayList();

		arr_list_in.add(checkForNull(rs.getString("FILE_NO")));
		arr_list_in.add(checkForNull(rs.getString("FACILITY_ID")));
		arr_list_in.add(checkForNull(rs.getString("PATIENT_ID")));
		arr_list_in.add(checkForNull(rs.getString("PATIENT_LINE")));
		arr_list_in.add(checkForNull(rs.getString("CURR_FILE_STATUS1")));
		arr_list_in.add(checkForNull(rs.getString("CURR_FS_LOCN_CODE")));
		arr_list_in.add(checkForNull(rs.getString("CURR_FS_LOCN_SHORT_DESC")));
		arr_list_in.add(checkForNull(rs.getString("CURR_FS_LOCN_IDENTITY")));
		if(return_criteria.equals("D")){
		arr_list_in.add(returndate);
		}else{
         arr_list_in.add(checkForNull(rs.getString("RETURN_DATE_TIME")));
		}
		arr_list_in.add(checkForNull(rs.getString("ORDER_BY_STATUS")));
		arr_list_in.add(checkForNull(rs.getString("CURR_FACILITY_NAME")));
		arr_list_in.add(checkForNull(rs.getString("CURR_FACILITY_ID")));
		arr_list_in.add(checkForNull(rs.getString("REQ_REMARKS")));
		arr_list_in.add(checkForNull(rs.getString("REMARKS")));
		arr_list_in.add(checkForNull(rs.getString("FILE_TYPE_DESC")));
		arr_list_in.add(checkForNull(rs.getString("FILE_TYPE_CODE")));
		arr_list_in.add(checkForNull(rs.getString("VOLUME_NO")));
		collection_key=arr_list_in.get(0)+"-"+arr_list_in.get(16)+"-"+arr_list_in.get(1);
		h_map.put(collection_key,arr_list_in);
	
		arr_list_in=null;
	}
	
	StringTokenizer str_token=new StringTokenizer(PatFile_string,",");
		String key_val="";
	while(str_token.hasMoreTokens()){
		key_val=str_token.nextToken();
			arr_list_out=(ArrayList) h_map.get(key_val);
			if(arr_list_out!=null && arr_list_out.size()>0){
			
			if(i % 2 == 0) classValue = "QRYEVEN" ;
				  else classValue = "QRYODD" ;			
	
			//cur_facility_id=rs.getString("curr_faclility_id");
			cur_facility_id=(String)arr_list_out.get(11);
           	String arr_cur_file_status=(String) arr_list_out.get(4);
			//if(rs.getString("curr_file_status1").equals("A")) {
			if(arr_cur_file_status.equals("A")) {
				bgcolor			= "gold";
				p_allow_select	= "disabled";
				p_checked		= "";
			}
			//else if (rs.getString("curr_file_status1").equals("T")) {
			else if (arr_cur_file_status.equals("T")) {
				/*bgcolor			= "darkseagreen";
				p_allow_select	= "disabled";
				p_checked		= "";*/
				if(accept_out_intransit_yn.equals("N"))
				{
					bgcolor			= "darkseagreen";
					p_allow_select	= "disabled";
					p_checked		= "";
				}
				else
				{
					bgcolor			= "darkseagreen";
					p_allow_select	= "";
					p_checked		= "checked";
				}
			
			}
			//else if (rs.getString("curr_file_status1").equals("L")) {
			else if (arr_cur_file_status.equals("L")) {
				bgcolor			= "mediumvioletred";
				p_allow_select	= "disabled";
				p_checked		= "";
			}
			//else if (rs.getString("curr_file_status1").equals("I")) {
			else if (arr_cur_file_status.equals("I")) {
				bgcolor			= "E0FFFF";
				p_allow_select	= "";
				p_checked		= "";
			}
			//else if (rs.getString("curr_file_status1").equals("O")) {
			else if (arr_cur_file_status.equals("O")) {
				if(accept_out_intransit_yn.equals("N"))
				{
				bgcolor			= "sandybrown";
				p_allow_select	= "disabled";
				p_checked		= "";
				}
				else
				{
				bgcolor			= "sandybrown";
				p_allow_select	= "";
				p_checked		= "checked";
				}
			}
			//else if (rs.getString("curr_file_status1").equals("E")) {
			else if (arr_cur_file_status.equals("E")) {
				if(accept_out_intransit_yn.equals("N"))
				{
				bgcolor			= "cyan";
				p_allow_select	= "disabled";
				p_checked		= "";
				}else{
              bgcolor			= "cyan";
				p_allow_select	= "";
				p_checked		= "checked";


				}
			
			}
			//else if (rs.getString("curr_file_status1").equals("R")) {
			else if (arr_cur_file_status.equals("R")) {
				bgcolor			= "#C0C0C0";
				p_allow_select	= "";
				p_checked		= "checked";
			}
			else {
				bgcolor			= "";
				p_allow_select	= "";
				p_checked		= "";
			}
	//if (rs.getString("curr_file_status1").equals("I") || rs.getString("curr_file_status1").equals("O")) {
	/*if (arr_cur_file_status.equals("I") || arr_cur_file_status.equals("O")) {
		if(p_return_cnt == 0) {
	<TR><td class='columnheader' colspan ='7' ><b><h5><font size=1><fmt:message key="eFM.FilestobeReturned.label" bundle="${fm_labels}"/></font></td></TR> -->
			
		/*}
		p_return_cnt++;
	}*/
	//if(rs.getString("curr_file_status1").equals("L") || rs.getString("curr_file_status1").equals("A") || rs.getString("curr_file_status1").equals("T")) {
	/*if(arr_cur_file_status.equals("L") ||arr_cur_file_status.equals("A") || arr_cur_file_status.equals("T")) {

		if(p_not_return_cnt == 0) {
			if(p_return_cnt > 0) {
				
				<TR id='file_trans'><td class='columnheader' colspan = '7' ><b><h5><font size=1><fmt:message key="eFM.FilescannotbeReturned.label" bundle="${fm_labels}"/></font></td></TR>
				
			}
			else {
				
				<TR id='file_trans'><td class='columnheader' colspan = '7' ><b><h5><font size=1><fmt:message key="eFM.FilescannotbeReturned.label" bundle="${fm_labels}"/></font></td></TR>
				
			}
		}
		p_not_return_cnt++;
	
	
	}*/

//curr_fs_locn_identity=rs.getString("curr_fs_locn_identity");
curr_fs_locn_identity=(String)arr_list_out.get(7);
if(!curr_fs_locn_identity.equals("")){
	switch(curr_fs_locn_identity.charAt(0))
			{
				case 'D' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); break;

				case 'C' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;

				case 'N' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;

				case 'T' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); break;

				case 'X' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;

				case 'E' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;

				case 'Y' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
		
			}
}
        counter++ ;
        if(counter % 2 == 0) classValue = "QRYODD" ;
        else classValue = "QRYEVEN" ;

		//String tempstr = rs.getString("patient_line").substring(0,rs.getString("patient_line").length()-6);
		String tempstr = (String)arr_list_out.get(3);
		tempstr=tempstr.substring(0,tempstr.length()-6);
		StringTokenizer st = new StringTokenizer(tempstr, ",");

		st.nextToken();
		st.nextToken();
		st.nextToken();
		st.nextToken();

		//String patient_id	= st.nextToken();

		//String pat_id		= rs.getString("patient_id");
		//file_type_desc		= rs.getString("file_type_desc");
		//file_type_code		= rs.getString("file_type_code");
		//volume_no			= rs.getString("volume_no");

		String pat_id		= (String)arr_list_out.get(2);
		file_type_desc		= (String)arr_list_out.get(14);
		file_type_code		= (String)arr_list_out.get(15);
		volume_no			= (String)arr_list_out.get(16);

		if ((file_type_desc == null)||(file_type_desc.equals(""))) file_type_desc = "&nbsp;";
		else file_type_desc = file_type_desc + " / ";
		if (file_type_code == null) file_type_desc = "";
		if (volume_no == null) volume_no = "";
		
		%>
		<tr>
		<% if(file_type_appl_yn.equals("N")) 
			{
			%>
			<td width="30%"  class="<%= classValue %>" >
			<A HREF CLASS="label" onMouseover="changeCursor(this)" onClick="callPatDetails('<%= pat_id %>')">&nbsp;+&nbsp;</A><font size=1><b><%=arr_list_out.get(0)  %></b><!-- //rs.getString("file_no") -->
			<%String tmp1=(String)arr_list_out.get(3);
			tmp1=tmp1.substring(0,tmp1.length()-6);%>
			<br><input type=hidden name=file_no<%=i%> value="<%=(String)arr_list_out.get(0)%>">&nbsp;&nbsp;&nbsp;&nbsp;<%=tmp1 %>
			<!--  //rs.getString("file_no")
			//rs.getString("patient_line").substring(0,rs.getString("patient_line").length()-6) -->
			<input type=hidden name=patient_id<%=i%> value="<%=pat_id %>">
			</td>
			<td width="12%" align="CENTER" class="<%=classValue%>" ><font size=1><%=volume_no%></font><input type="Hidden" name="file_type_code<%=i%>" id="file_type_code<%=i%>" value="<%=file_type_code%>"><input type="Hidden" name="volume_no<%=i%>" id="volume_no<%=i%>" value="<%=volume_no%>"></td>	
		<% }
			else if (file_type_appl_yn.equals("Y")) {%>
			<td width="30%"  class="<%= classValue %>" >
			<%String tmp2=(String)arr_list_out.get(3);
			tmp2=tmp2.substring(0,tmp2.length()-6);%>
			<A HREF CLASS="label" onMouseover="changeCursor(this)" onClick="callPatDetails('<%= pat_id %>')">&nbsp;+&nbsp;</A><font size=1><input type=hidden name=file_no<%=i%> value="<%=(String) arr_list_out.get(0) %>">&nbsp;<%=tmp2 %>
			<!-- //rs.getString("file_no")
			// rs.getString("patient_line").substring(0,rs.getString("patient_line").length()-6) -->
			<input type=hidden name=patient_id<%=i%> value="<%=pat_id %>">
			</td>
			<td width="12%" align="CENTER" class="<%=classValue%>" ><font size=1><%=file_type_desc%><%=volume_no%></font><input type="Hidden" name="file_type_code<%=i%>" id="file_type_code<%=i%>" value="<%=file_type_code%>"><input type="Hidden" name="volume_no<%=i%>" id="volume_no<%=i%>" value="<%=volume_no%>"></td>
		<%}

			//String p_iss_remarks = rs.getString("remarks")==null?"":rs.getString("remarks");
			String p_iss_remarks = (String)arr_list_out.get(13)==null?"":(String)arr_list_out.get(13);
		//	p_iss_remarks=java.net.URLDecoder.decode(p_iss_remarks,"UTF-8");
			out.println("<td align='CENTER' class='"+classValue+"' width='8%'><font size=1>");
			if(p_iss_remarks.equals("")) {
				out.println("&nbsp;</font></td>");
			} 
				
			else {
				%>
				<a href='javascript:GetShowRemarks("txtComm<%=i%>","<%=p_iss_remarks%>","IR")'><fmt:message key="Common.view.label" bundle="${common_labels}"/>&nbsp; <fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></font></td>
			<%}%>
			<%//String curr_fac=rs.getString("curr_facility_name");
				String curr_fac=(String)arr_list_out.get(10);%>
			<td width=17%  class="<%= classValue %>" ><font size=1>
			<%= arr_list_out.get(6) %>			<!-- //rs.getString("curr_fs_locn_short_desc") -->
			<%if(!curr_fac.equals("&nbsp;")){%> 
			<br>&nbsp;&nbsp;(<%= curr_fs_locn_identity%>)  / <%=curr_fac%>
			<%}else{%>
              <br>&nbsp;&nbsp;(<%= curr_fs_locn_identity%>)   
			  <%}%>
			</font></td>
			<%
				//return_date_time=rs.getString("return_date_time");
				return_date_time=(String)arr_list_out.get(8);

				if(!return_date_time.equals("&nbsp;"))
				{
					return_date_time=DateUtils.convertDate(return_date_time,"DMYHM","en",localeName);
				}
			
			%>
			<td width="15%" align="CENTER" class="<%= classValue %>" ><font size=1>
			<%=return_date_time%>
			</font></td>
			<td width=8% align="CENTER" class="<%= classValue %>" ><font size=1>
			<a href="javascript:GetRemarks(<%= i %>)"><fmt:message key="Common.EnterRemarks.label" bundle="${common_labels}"/></a>
			<input type="hidden" name="rem_recnum_<%=i%>" id="rem_recnum_<%=i%>" value="">
			
			</font></td>	
			<td width="10%" align='center' style='background-color:<%=bgcolor%>' class='<%=classValue %>'><font size=1>
			<input type=checkbox name="req_select<%=i%>" id="req_select<%=i%>" <%=p_checked%> <%=p_allow_select%> value='Y'>
			<input type=hidden name="cur_facility_id<%=i%>" id="cur_facility_id<%=i%>"  value="<%=cur_facility_id%>">
			<input type=hidden name="txtComm<%=i%>" id="txtComm<%=i%>"  value="<%=p_iss_remarks%>">
			</font></td>
		</tr>
		<%
		if(p_select_values=="") {
			//p_select_values = rs.getString("file_no")+'`'+rs.getString("facility_id");
			p_select_values = (String)arr_list_out.get(0)+'`'+(String)arr_list_out.get(1);
		}
		else {
			//p_select_values = p_select_values + '|' + rs.getString("file_no")+'`'+rs.getString("facility_id");
			p_select_values = p_select_values + '|' + (String)arr_list_out.get(0)+'`'+(String)arr_list_out.get(1);
		}
		i++;
		p_rec_cnt++;
		//p_first_curr_fs_locn_code = rs.getString("curr_fs_locn_code");
		p_first_curr_fs_locn_code = (String)arr_list_out.get(5);


		}  // checking arraluist empty /size
	}// looping logic

		h_map=null;
		arr_list_out=null;


} // condition for add part

	if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0))
	{
		SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
	}

	%>
	<script>
		parent.frames[1].document.forms[0].p_curr_fs_loc.disabled	= false;
		parent.frames[1].document.forms[0].FILE_STAT.disabled		= false;
		if (parent.frames[2].document.forms[0].file_no != null)
		parent.frames[2].document.forms[0].file_no.readOnly = false;
		parent.frames[2].document.forms[0].p_out_fcy.disabled		= false;
		parent.frames[2].document.forms[0].FS_LOCN_ID.disabled		= false;
		parent.frames[2].document.forms[0].p_out_fsloc.disabled		= false;
		parent.frames[2].document.forms[0].Add.disabled				= false;
        if (parent.frames[1].document.forms[0].FILE_STAT.value !=''){
		  if("<%=accept_out_intransit_yn%>" == "N" ){
			parent.frames[2].document.forms[0].show_files.disabled		= false;
			}
		}
		else
		{
		parent.frames[2].document.forms[0].show_files.disabled		= true;
		}
		parent.frames[2].document.forms[0].Clear.disabled			= false; 
		
	</script>
</TABLE>
<script>
	for(i=0;i<7;i++) {
		if ((document.getElementById("srch_result").rows[i+1] != null) && (document.getElementById("srch_result").rows[i+1].cells[i] != null)) {
		parent.frames[2].document.getElementById("hdr_tab").rows[0].cells[i].width = document.getElementById("srch_result").rows[i+1].cells[i].width; 
		}
	}

	    
	   var p_counter = '<%=counter%>';
	  var rec_count   ='<%=rec_count%>';
	 var curr_fstat   ='<%=curr_fstat%>';
	  var P_cnt   ='<%=P_cnt%>';
      var buttonVal='<%=buttonVal%>';
	  var isModifyLongShortDescAppl = '<%=isModifyLongShortDescAppl%>'; //Added by Kamatchi S on 12/09/2019 for ML-MMOH-CRF-1417
	//	if (parseInt(p_counter) == 0 || (parseInt(rec_count)==0 && curr_fstat!="")) {
			if ((parseInt(rec_count)==0 && buttonVal=="A") || (parseInt(p_counter)==0 && buttonVal=="S")   ) {
			// Modified by Kamatchi S on 12/09/2019 for ML-MMOH-CRF-1417 
			if(isModifyLongShortDescAppl == 'true')
			{
				alert(getMessage('FILE_ALREADY_IN_MRD','FM'));
			}else
			{
				alert(getMessage('NO_FILES_TO_RETURN','FM'));
			}
			 parent.frames[2].document.forms[0].flag.value="";
			parent.frames[2].document.forms[0].un_defcny.value="";
			parent.frames[2].document.forms[0].patientid.value="";
			 parent.frames[2].document.forms[0].fileno.value="";
		 parent.frames[2].document.forms[0].volno.value="";
			
			parent.frames[1].document.forms[0].p_curr_fs_loc.disabled	= false;
			parent.frames[1].document.forms[0].FILE_STAT.disabled		= false;
			if (parent.frames[2].document.forms[0].file_no != null)
				parent.frames[2].document.forms[0].file_no.readOnly = false;
			parent.frames[2].document.forms[0].p_out_fcy.disabled		= false;
			parent.frames[2].document.forms[0].FS_LOCN_ID.disabled		= false;
			parent.frames[2].document.forms[0].p_out_fsloc.disabled		= false;
			parent.frames[2].document.forms[0].Add.disabled				= false;
			if (parent.frames[1].document.forms[0].FILE_STAT.value !=''){
			if("<%=accept_out_intransit_yn%>" == "N" ){
			parent.frames[2].document.forms[0].show_files.disabled	= false;
			}
			}
			else
			{
				parent.frames[2].document.forms[0].show_files.disabled	= true;
			}
			parent.frames[2].document.forms[0].Clear.disabled			= false; 

			parent.frames[2].document.forms[0].patient_id.value = '';
			parent.frames[2].document.forms[0].patient_id.focus() ;
			if(p_counter==0){
			parent.frames[2].document.getElementById("hdr_tab").style.visibility = 'Hidden';
			}
			if(parent.frames[2].document.forms[0].file_no)
			parent.frames[2].document.forms[0].file_no.value='';
			parent.frames[2].document.forms[0].remove_volume.value = "ALL";
			parent.frames[1].document.forms[0].p_select_values.value = "";
			if(p_counter==0){
			parent.frames[3].location.href = "../../eCommon/html/blank.html";
			}
	}
	else
	{ 
		/*Below field namesare being sent dynamically to "FMFileSearchComponentValues.jsp"  in "FMReceiveFileMRDSearch.jsp"*/
		 parent.frames[2].document.forms[0].patient_id.value = '';
		 parent.frames[2].document.forms[0].patient_id.focus();
		 
		 
		 if (parent.frames[2].document.forms[0].file_type)
		 parent.frames[2].document.forms[0].file_type.value = '';
		 if (parent.frames[2].document.forms[0].volume_n)
		 parent.frames[2].document.forms[0].volume_no.value ='';
	}

	parent.frames[1].document.forms[0].p_deselect_values.value	= "<%=p_not_in_files%>";
	parent.frames[1].document.forms[0].p_select_values.value	= "<%=p_stored_val%>";
	parent.frames[1].document.forms[0].p_total_records.value	= "<%=p_rec_cnt%>";
	parent.frames[1].document.forms[0].p_outst_facility.value	= "<%=cur_facility_id%>";
	var p_in_files		= parent.frames[1].document.forms[0].p_select_values.value;
	var p_not_files	= parent.frames[1].document.forms[0].p_deselect_values.value;
	parent.frames[2].document.forms[0].p_total_select.value = "<%=p_rec_cnt%>";
	//parent.frames[2].document.forms[0].patient_id.value		= "";
	//parent.frames[2].populateDynamicValues(parent.frames[2].document.forms[0].patient_id.value);
		parent.frames[2].document.getElementById("patient_id").onblur();

	if("<%=accept_out_intransit_yn%>" == "Y" && "<%=curr_fstat%>" == "T")
	{
		if(document.getElementById("file_trans"))
		document.getElementById("file_trans").style.display= "none";
	}
</script>
	<input type='hidden' name='p_select_values' id='p_select_values' value='<%=p_select_values%>'>
	<input type='hidden' name='p_total_select' id='p_total_select' value='<%=p_rec_cnt%>'>
</FORM>
</BODY>
<%
if(rs!=null)	rs.close();
if(pstmt!=null) pstmt.close();
}catch(Exception e){
	out.println("Exception in ReturnMRDSelectedFiles.jsp :"+e);
	}
finally
{	
	ConnectionManager.returnConnection(con,request);
}
%>
</HTML>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

