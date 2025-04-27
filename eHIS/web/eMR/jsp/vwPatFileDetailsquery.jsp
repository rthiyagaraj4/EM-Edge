<!DOCTYPE html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE></TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">

<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ page import ="java.sql.*,java.util.*,java.util.ResourceBundle.*,com.ehis.util.*,java.net.*,java.text.*, webbeans.eCommon.MessageManager,webbeans.eCommon.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8" %>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<Script>
	function callModalVPF()
	{
		patid1=document.forms[0].Patient_Id.value
		parent.frames[2].location.href='../../eMR/jsp/patientblank.jsp?Patient_Id='+patid1;
	}
</Script>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY OnMouseDown='CodeArrest();'  onKeyDown = 'lockKey()' class='CONTENT'><form>");
	
	String patID=request.getParameter("Patient_Id");
	String function_id=request.getParameter("function_id");
	String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String responsibility_id=request.getParameter("responsibility_id")==null?"":request.getParameter("responsibility_id");
	String login_user=request.getParameter("login_user")==null?"":request.getParameter("login_user");
	String client_ip_address = "";
	client_ip_address = request.getRemoteAddr();
 
String jdbc_props = "";

	if ( function_id == null )
	function_id="";
	//	String whereClause = request.getParameter("whereclause");
	String file_type_appl_yn = "";
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	//String facility_id	=(String) session.getValue("facility_id");
	String facility_id	= request.getParameter("FacilityId") ;//added forBru-HIMS-CRF-380
	String locale       =(String) session.getAttribute("LOCALE"); 
    
	 if(facility_id==null || facility_id.equals(""))	
		facility_id = (String) session.getValue("facility_id");
	

	if(locale == null)
		locale = request.getParameter("locale") ;
	

	locale = (locale == null || locale.equals(""))?"en":locale;
	java.util.Locale loc = new java.util.Locale(locale);
	java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
	String endOfRes="1";
	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 15 ;
	else
		end = Integer.parseInt( to ) ;

Connection conn =null;
Statement stmt=null;
ResultSet rs=null;
String fm_install_yn = "";
String strsql2 = "";
PreparedStatement pstmt = null;
//int maxRecord = 0;

String single_or_multi_files_ind =	"";
String separate_file_no_yn =	"";
try
{
	conn = ConnectionManager.getConnection(request) ;

/*	stmt = conn.createStatement();
	String strsql1="select count(*) as total from mr_pat_file_index_vw";
	rs = stmt.executeQuery(strsql1);
	if(rs.next())
	{
		//maxRecord = rs.getInt("total");
	}
*/

	//String str_sql_MP = " select file_type_appl_yn, single_or_multi_files_ind, separate_file_no_yn from MP_PARAM ";
	String str_sql_MP =" select file_type_appl_yn, single_or_multi_files_ind, separate_file_no_yn from MP_PARAM where module_id='MP'";
	
	if(rs!=null)rs.close();
	if(pstmt!=null)pstmt.close();

	pstmt = conn.prepareStatement(str_sql_MP);
	rs = pstmt.executeQuery();

	while(rs.next())
	{
		file_type_appl_yn = rs.getString(1);
		
		single_or_multi_files_ind = rs.getString(2);
		separate_file_no_yn = rs.getString(3);
		//if file_type_appl_yn is N from mp_param then file type description should not be displayed.
	}
	
	try
	{
		String str_sql_FM = "select install_yn from sm_module where module_id='FM' ";
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		pstmt = conn.prepareStatement(str_sql_FM);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			fm_install_yn = rs.getString(1);//if fm is not installed volume number,remarks and current file location should not be displayed
		}

		if(fm_install_yn==null)
			fm_install_yn = "N";

	}catch(Exception e)
	{
		//out.print(e.toString());
		e.printStackTrace();
	}

		if(fm_install_yn.equals("Y"))
		{
				
			strsql2= "SELECT a.Facility_Id,SM_GET_DESC.SM_FACILITY_PARAM(a.FACILITY_ID,'"+locale+"','1') Facility_Name,a.File_No,		a.fs_Locn_Code,FM_GET_DESC.FM_STORAGE_LOCN(a.FACILITY_ID, a.FS_LOCN_CODE,'"+locale+"','2') File_Locn_desc,			c.Curr_fs_Locn_Code,FM_GET_DESC.FM_STORAGE_LOCN(a.FACILITY_ID, c.Curr_fs_Locn_Code,'"+locale+"','2') fs_Locn_desc,	decode(c.curr_file_status, 'I', 'Inside', 'O', 'Outside', 'T', 'Issued - In Transit', 'L', 'Lost', 'A', 'Archived', 'R', 'Returned - In Transit') Remarks ,c.Remarks,a.mr_Section_Code,MR_GET_DESC.MR_SECTION(a.FACILITY_ID, a.MR_SECTION_CODE,'"+locale+"','2') Section_Name,MR_GET_DESC.MR_FILE_TYPE(a.FACILITY_ID, a.FILE_TYPE_CODE,'"+locale+"','2') File_Type_desc,c.Volume_No,a.Added_By_Id,a.Archived_yn,To_char(a.Added_Date,'dd/mm/yyyy hh24:mi') Added_Date, a.old_file_no FROM   MR_PAT_FILE_INDEX a,  FM_CURR_LOCN c WHERE  a.Facility_Id = '"+facility_id+"' AND a.Patient_Id = '"+patID+"' AND a.Facility_Id = c.Facility_Id    AND a.File_No = c.File_No AND a.Patient_Id = c.Patient_Id AND( (c.volume_status = 'A' OR c.volume_status = 'L' OR c.volume_status = 'R' OR c.volume_status = 'F' OR c.volume_status = 'NA')) order by a.file_no desc";

	
		}
		else
		{
			//strsql2 = " SELECT a.facility_id, b.facility_name, a.file_no, a.fs_locn_code, a.mr_section_code, e.short_name section_name, g.short_desc file_type_desc FROM MR_PAT_FILE_INDEX a, SM_FACILITY_PARAM b, MR_SECTION e, MR_FILE_TYPE g WHERE a.facility_id = b.facility_id AND a.facility_id = e.facility_id(+) AND a.mr_section_code = e.mr_section_code(+) AND a.file_type_code = g.file_type_code(+) AND a.patient_id = '"+patID+"' ";
			//strsql2 = " SELECT a.facility_id, b.facility_name, a.file_no, a.fs_locn_code, a.mr_section_code, e.short_name section_name, g.short_desc file_type_desc FROM MR_PAT_FILE_INDEX a, sm_Facility_Param_lAng_vw b, mr_Section_lAng_vw e, mr_File_Type_lAng_vw g WHERE a.facility_id = b.facility_id AND a.facility_id = e.facility_id(+) AND g.Language_Id = b.Language_Id AND e.Language_Id = b.Language_Id AND a.mr_section_code = e.mr_section_code(+) AND a.file_type_code = g.file_type_code(+) AND a.patient_id = '"+patID+"' AND b.Language_Id = '"+locale+"'";
			strsql2 = " select facility_id, SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,'"+locale+"','1') facility_name,Archived_yn, file_no,fs_locn_code, mr_section_code, MR_GET_DESC.MR_SECTION(FACILITY_ID, MR_SECTION_CODE,'"+locale+"','2') section_name, MR_GET_DESC.MR_FILE_TYPE(FACILITY_ID, FILE_TYPE_CODE,'"+locale+"','2') file_type_desc ,added_by_id, To_char(Added_Date,'dd/mm/yyyy hh24:mi') Added_Date , old_file_no from MR_PAT_FILE_INDEX where patient_id = '"+patID+"' and	Facility_Id = '"+facility_id+"' order by file_no desc ";
		
		}

		if(rs!=null)rs.close();	
		if(pstmt!=null)pstmt.close();
		if(stmt!=null)stmt.close();	
		stmt = conn.createStatement();

		rs = stmt.executeQuery(strsql2);
		// variables for query retrieval

		String l_section_name 	= "";
		String l_file_no	= "";
		String l_added_by_id = "";
		String l_added_date = "";
		String old_file_no = "";
		String l_added_date_display = "";
		String file_type_desc = "";
		String volumeno = "";
 		String current_file_locn="",remarks="";
		String file_created_at="";
 	    String facility_Id="";
	    String facility_name="";
	    String archived_status="";
	
	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;

	  }
	    String classValue = "" ;
	
	int k=0;
	
	while ( rs.next() && i<=end )
	{ 
		if(k==0){		
			%>
		<table border="0" width="100%" cellspacing='0' cellpadding='0'>
		<tr>
	
	<%
			
	if(function_id.equals("CPD")){
	%>
   	<td class='button' width='5%'>
	<input type="hidden" name="Patient_Id" id="Patient_Id" value="<%=patID%>">
    <input type="button" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.create.label","common_labels")%>" onClick="callModalVPF();">
    </td>
	<td  class='label' width='90%' align='right'>&nbsp;</td>
	<%}%>
	
	<%
			
	if ( !(start <= 1) )
	{
		out.println("<td class='label' width='5%' align='right'><A HREF='../../eMR/jsp/vwPatFileDetailsquery.jsp?function_id=CPD&Patient_Id="+patID+"&from="+(start-15)+"&to="+(end-15)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
	}

	if (endOfRes.equals("1"))
	 {
		out.println("<td class='label' width='5%' align='right'><A  id='nextval' HREF='../../eMR/jsp/vwPatFileDetailsquery.jsp?function_id=CPD&Patient_Id="+patID+"&from="+(start+15)+"&to="+(end+15)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
		
		
	 }	
	%>
								
	</tr>
	</table>
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<tr>
<% 
	if(separate_file_no_yn.equals("N") && single_or_multi_files_ind.equals("M") && file_type_appl_yn.equals("Y"))  
	{ %>
		<td class="COLUMNHEADER"><%=common_labels.getString("Common.filetype.label")%></td>
<%	} %>
<%	if(separate_file_no_yn.equals("Y")  &&  file_type_appl_yn.equals("N"))
	{	%>
		<td class="COLUMNHEADER"><%=common_labels.getString("Common.fileno.label")%></td>
<%	}	%>
		
		
		<td class="COLUMNHEADER"><%=common_labels.getString("Common.FacilityID.label")%></td>	
			
		<td class="COLUMNHEADER"><%=common_labels.getString("Common.FacilityName.label")%></td>
			
		<td class="COLUMNHEADER"><%=common_labels.getString("Common.MRSection.label")%><%=common_labels.getString("Common.name.label")%> </td>
				
			
		<td class="COLUMNHEADER"><%=common_labels.getString("Common.ActiveVolumeNumber.label")%></td>
		<td class="COLUMNHEADER"><%=common_labels.getString("Common.FileCurrentLocation.label")%></td>
		<td class="COLUMNHEADER"><%=common_labels.getString("Common.CurrentFileStatus.label")%></td>
		<td class="COLUMNHEADER"><%=common_labels.getString("Common.FileCreatedAt.label")%></td>
		<td class="COLUMNHEADER"><%=common_labels.getString("Common.FileCreatedDateTime.label")%></td>
		<td class="COLUMNHEADER"><%=common_labels.getString("Common.FileCreatedBy.label")%></td>
		<td class="COLUMNHEADER"><%=common_labels.getString("Common.Archived.label")%></td>
		<td class="COLUMNHEADER"><%=common_labels.getString("Common.OldFileNo.label")%></td>
	
	</tr>
		<%}
		if(fm_install_yn.equals("Y"))
		{
			current_file_locn=rs.getString("fs_locn_desc");
			if(current_file_locn == null) 
				current_file_locn=rs.getString("file_locn_desc");

			if(rs.getString("file_locn_desc") == null)
				current_file_locn="&nbsp;";
			else
				current_file_locn=rs.getString("file_locn_desc");
		}	
		l_section_name 	= rs.getString("SECTION_NAME");
			if(l_section_name == null) l_section_name="&nbsp;";

		l_file_no	= rs.getString("file_no");
					if(l_file_no == null) l_file_no="&nbsp;";
		l_added_by_id	= rs.getString("added_by_id");
					if(l_added_by_id == null) l_added_by_id="&nbsp;";
		l_added_date	= rs.getString("added_date");

		old_file_no = rs.getString("old_file_no")==null?"&nbsp;":rs.getString("old_file_no");

			facility_id=rs.getString("Facility_Id");
			if(facility_id == null) facility_id="&nbsp;";
			facility_name=rs.getString("Facility_Name");
			if(facility_name == null) facility_name="&nbsp;";
			archived_status=rs.getString("Archived_yn");
			if(archived_status == null) archived_status="&nbsp;";
			
			if(l_added_date == null)
			{
				l_added_date = "&nbsp;";
				l_added_date_display = "&nbsp;";
			}
			else
				l_added_date_display = DateUtils.convertDate(l_added_date,"DMYHM","en",locale);

		file_type_desc = rs.getString("file_type_desc")==null?"&nbsp;":rs.getString("file_type_desc");
		//to display facility for the reference of FS102MR(270208)v1 0.doc
		file_created_at = rs.getString("Facility_Name");
		//file_created_at = rs.getString("facility_id");
		if(fm_install_yn.equals("Y"))
		{
			remarks	= rs.getString("remarks");

			if (remarks == null)
				remarks 	= "&nbsp;";
			/*
			if(remarks.equalsIgnoreCase("I"))
			{
				//remarks=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Inside.label","mr_labels");
			}
			else if(remarks.equalsIgnoreCase("O"))
			{
			//	remarks=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outside.label","common_labels");
				remarks=  common_labels.getString("Common.Outside.label") ;
			}
			else if(remarks.equalsIgnoreCase("T"))
			{
				//remarks=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.IssuedInTransit.label","mr_labels");
			}
			else if(remarks.equalsIgnoreCase("L"))
			{
				//remarks=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Lost.label","common_labels");
				remarks=  common_labels.getString("Common.Lost.label")  ;
			}
			else if(remarks.equalsIgnoreCase("A"))
			{
				//remarks=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Archived.label","common_labels");
				remarks=   common_labels.getString("Common.Archived.label");  
			}
			else if(remarks.equalsIgnoreCase("R"))
			{
				//remarks=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ReturnedInTransit.label","mr_labels");
			}
			*/
		}

		if (l_file_no== null)
			l_file_no= "&nbsp;";

		if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;

		
		if(separate_file_no_yn.equals("N") && single_or_multi_files_ind.equals("M") && file_type_appl_yn.equals("Y")) 
		{
			out.println("<td nowrap class='" + classValue + "'>");
			out.println(file_type_desc+"</td>");
		}
		
		if(separate_file_no_yn.equals("Y")  &&  file_type_appl_yn.equals("N"))
		{
			out.println("<td nowrap class='" + classValue + "'>");
			out.println(l_file_no+"</td>");
		}

		
		
		/*if(fm_install_yn.equals("Y"))
		{
			volumeno  = rs.getString("volume_no");
		    if(volumeno == null) volumeno = "&nbsp;";

			
			out.println("<td  nowrap class='" + classValue + "'>");
			out.println(facility_id);
			out.println("<td  nowrap class='" + classValue + "'>");
			out.println(facility_name);
			out.println("<td  nowrap class='" + classValue + "'>");
			out.println(l_section_name);
			
			out.println("<td  nowrap class='" + classValue + "'>");
			out.println(volumeno);
			
			out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(current_file_locn);

			out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(remarks+"</td>");

			out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(l_added_date_display+"</td>");

			out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(l_added_by_id+"</td>");
		}*/

		if(fm_install_yn.equals("Y"))
		{
			volumeno  = rs.getString("volume_no");
		    if(volumeno == null) volumeno = "&nbsp;";
		}

			if(volumeno != null && volumeno.equals("")) volumeno = "&nbsp;";
			if(current_file_locn != null && current_file_locn.equals("")) current_file_locn = "&nbsp;";
			if(remarks != null && remarks.equals("")) remarks = "&nbsp;";
			if(l_added_date_display != null && l_added_date_display.equals("")) l_added_date_display = "&nbsp;";
			if(l_added_by_id != null && l_added_by_id.equals("")) l_added_by_id = "&nbsp;";

		
			
			out.println("<td  nowrap class='" + classValue + "'>");
			out.println(facility_id);
			out.println("<td  nowrap class='" + classValue + "'>");
			out.println(facility_name);
			out.println("<td  nowrap class='" + classValue + "'>");
			out.println(l_section_name);
			out.println("<td  nowrap class='" + classValue + "'>");
			out.println(volumeno);
			
			out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(current_file_locn);
			
			out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(remarks+"</td>");

			out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(file_created_at);

			out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(l_added_date_display+"</td>");

			out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(l_added_by_id+"</td>");
		
		   out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(archived_status+"</td>");

		   out.println("</td><td nowrap class='" + classValue + "'>");
			out.println(old_file_no+"</td>");
			
		       i++;
		       k++;
	          %></tr><%
	        }//endwhile
	     if(i == 1)
	     {
		if(!function_id.equals("CPD"))
		{	%>
			<input type="hidden" name="Patient_Id" id="Patient_Id" value="<%=patID%>">
			<%
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				out.println("<script>parent.window.close();</script>");
		}
		else
		{	%>
			<input type="hidden" name="Patient_Id" id="Patient_Id" value="<%=patID%>">
		<%	out.println("<script>callModalVPF();</script>");
		}
	}
		if (!rs.next() && k!=0){	
			 endOfRes = "0";	
			 %><script>document.getElementById('nextval').innerHTML=" ";</script><% 
		 }
}catch(Exception e)
{
	//out.print(e.toString());
	e.printStackTrace();
}
finally   
{
	try
	{
	if(rs!=null)	rs.close();
	if(stmt!=null)	stmt.close();
	}
	catch(Exception e)
{
	e.printStackTrace();
}
	ConnectionManager.returnConnection(conn,request);
}
%>

</table>
</form>
</BODY>
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

