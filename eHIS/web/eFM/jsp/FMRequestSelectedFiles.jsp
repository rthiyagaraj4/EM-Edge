<!DOCTYPE html>
<!--
	Created On	: 6/15/2002
	Created By	: Nanda Kumar R.
	Module		: File Management (FM)
	Function	: Request of File
-->
<%@ page contentType="text/html; charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eFM/js/FMRequestFile.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<BODY onMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
<FORM name = 'fm_select_form' action='../../servlet/eFM.FMParameterServlet' method='get' target='messageFrame'>
<%
	Connection con				= null;
	java.sql.Statement stmt		= null;	
	ResultSet rs				= null;	
try
{
	con	= ConnectionManager.getConnection(request);
	stmt						= con.createStatement();
	StringBuffer SelectSqlBuffer = null;
	SelectSqlBuffer				 = new StringBuffer();
	String p_stored_val			= request.getParameter("p_select_files");
	String p_not_in_files		= request.getParameter("p_deselect_files");
	String p_include_in_select	= request.getParameter("p_include_in_select");
	String p_enter_fcy			= request.getParameter("p_enter_fcy");
	String p_req_fs_locn		= request.getParameter("p_req_fs_locn");
//	String conc_remarks		 	=request.getParameter("conc_remarks").trim();
    String perm_fs_locn_code="";
	//String facility_id 			= (String) session.getValue("facility_id");

	String conc_remarks		 	=(String)session.getAttribute("conc_remarks");
	session.removeAttribute("conc_remarks");
	String added_volumes	 	= request.getParameter("added_volumes");
	String file_type_appl_yn 	= request.getParameter("file_type_appl_yn");

	String fileno_name			= checkForNull(request.getParameter("fileno_name"));
	String filetype_name		= checkForNull(request.getParameter("filetype_name"));
	String file_no_function		= checkForNull(request.getParameter("file_no_function"));
	String file_type_function	= checkForNull(request.getParameter("file_type_function"));
	String frame_name			= checkForNull(request.getParameter("frame_name"));
	String form_name			= checkForNull(request.getParameter("form_name"));
	String volumeno_name		= checkForNull(request.getParameter("volumeno_name"));
	ArrayList arrList = new ArrayList();
	if(added_volumes==null)  added_volumes = "";
	if(file_type_appl_yn==null)  added_volumes = "N";
    String filenum="";
	String volumenum="";
	String fileno_volume="";
	String serverDateTime="";

	//conc_remarks = java.net.URLDecoder.decode(conc_remarks,"UTF-8");

	added_volumes = java.net.URLDecoder.decode(added_volumes);

	if (!(conc_remarks.equals(null) || conc_remarks==null || conc_remarks.equals("null")  )) {
		StringTokenizer st = new StringTokenizer(conc_remarks, "~");
		
		while(st.hasMoreTokens()) {
			StringTokenizer recSt = new StringTokenizer(st.nextToken(), "`");
			while(recSt.hasMoreTokens()) {
			arrList.add(recSt.nextToken());
		}
			}
	}

	String p_select_values		= "";
	String p_added_values		= "";
	//String p_concat_string		= "";
	String p_files_not_in		= "";
	int p_count = 0;	
    int count_tokens=0;
	if (p_not_in_files==null) p_not_in_files="";
	if (p_include_in_select==null) p_include_in_select="";
	if (p_req_fs_locn==null) p_req_fs_locn="";

	/*StringTokenizer token=new StringTokenizer(p_stored_val,"|");
	while(token.hasMoreTokens())
		{
				if (p_count ==0 )
				{
					p_concat_string     = "'" + token.nextToken() +"'";
				}
				else
				{
					p_concat_string     = p_concat_string + ",'" + token.nextToken() +"'";
				}
				p_count++;
		}		*/	
	//	p_count=0;

	if (!p_not_in_files.equals(""))
	{
		StringTokenizer token1=new StringTokenizer(p_not_in_files,"|");
		String getTokenValue="";

		while(token1.hasMoreTokens())
			{
				getTokenValue = token1.nextToken();

					if (p_count ==0 )
					{
						p_files_not_in     = "'" + getTokenValue +"'";
					}
					else
					{
						p_files_not_in     = p_files_not_in + ",'" + getTokenValue +"'";
					}
					p_count++;
			}
	}

		//SelectSqlBuffer.append(" select file_no,facility_id,patient_id,get_patient_line(patient_id)patient_line,fs_locn_short_desc, decode(curr_file_status,'I','Inside','O','Outside','L','Lost','T','In Transit','A','Archived','E','Other Facility', 'R', 'Returned')curr_file_status,(case when curr_fs_locn_code = '"+p_req_fs_locn+"' then 'X' else curr_file_status end)curr_file_status1, curr_fs_locn_short_desc, decode(curr_fs_locn_identity,'D','Department','T','Practitioner','C','Clinic','N','Nursing Unit','E','Procedure Unit','Y','Daycare Unit')curr_fs_locn_identity, (CASE WHEN curr_fs_locn_code = '"+p_req_fs_locn+"' THEN  6 ELSE  DECODE(curr_file_status,'I',1,'O',1,'L',4,'T',2,'A',5,'E',3) END)order_by_status,(case when curr_facility_id <> '"+p_enter_fcy+"' then '(' || curr_facility_name || ')' else '&nbsp;' end)other_facility_name, volume_no, file_type_code, file_type_desc, to_char(sysdate,'dd/mm/yyyy') serverDate from fm_curr_locn_vw where file_no in("+p_concat_string+") ");
		SelectSqlBuffer.append("SELECT" );
		SelectSqlBuffer.append("  File_No" );
		SelectSqlBuffer.append("  , Facility_Id" );
		SelectSqlBuffer.append("  , Patient_Id" );
		SelectSqlBuffer.append("  , Get_patient_line(Patient_Id,'"+localeName+"') Patient_Line" );
		SelectSqlBuffer.append("  , fm_Get_desc.Fm_storage_locn('"+p_enter_fcy+"',perm_fs_locn_code,'"+localeName+"',2) fs_Locn_Short_desc" );
		SelectSqlBuffer.append("  , Curr_File_Status Curr_File_Status,perm_fs_locn_code" );
		SelectSqlBuffer.append("  , (" );
		SelectSqlBuffer.append("  CASE " );
		SelectSqlBuffer.append("  WHEN Curr_fs_Locn_Code = '"+p_req_fs_locn+"' " );
		SelectSqlBuffer.append("  THEN" );
		SelectSqlBuffer.append("    'X' " );
		SelectSqlBuffer.append("  ELSE Curr_File_Status " );
		SelectSqlBuffer.append("  END) Curr_File_Status1" );
		SelectSqlBuffer.append("  , fm_Get_desc.Fm_storage_locn(Curr_Facility_Id,Curr_fs_Locn_Code,'"+localeName+"',2) Curr_fs_Locn_Short_desc" );
		SelectSqlBuffer.append("  , Curr_fs_Locn_Identity Curr_fs_Locn_Identity" );
		SelectSqlBuffer.append("  , (" );
		SelectSqlBuffer.append("  CASE " );
		SelectSqlBuffer.append("  WHEN Curr_fs_Locn_Code = '"+p_req_fs_locn+"' " );
		SelectSqlBuffer.append("  THEN" );
		SelectSqlBuffer.append("    6 " );
		SelectSqlBuffer.append("  ELSE Decode(Curr_File_Status,'I',1, 'O',1, 'L',4, 'T',2, 'A',5, 'E',3) " );
		SelectSqlBuffer.append("  END) Order_By_Status" );
		SelectSqlBuffer.append("  , (" );
		SelectSqlBuffer.append("  CASE " );
		SelectSqlBuffer.append("  WHEN Curr_Facility_Id <> '"+p_enter_fcy+"' " );
		SelectSqlBuffer.append("  THEN" );
		SelectSqlBuffer.append("    '(' ||(sm_Get_desc.SM_FACILITY_PARAM(Curr_FACILITY_ID,'"+localeName+"',1)) ||')' " );
		SelectSqlBuffer.append("  ELSE '&nbsp;' " );
		SelectSqlBuffer.append("  END) Other_Facility_Name" );
		SelectSqlBuffer.append("  , Volume_No" );
		SelectSqlBuffer.append("  , File_Type_Code" );
		SelectSqlBuffer.append("  , mr_get_desc.MR_FILE_TYPE('"+p_enter_fcy+"',File_Type_Code,'"+localeName+"',2) File_Type_desc " );
		SelectSqlBuffer.append("  , TO_CHAR(sysdate,'dd/mm/yyyy HH24:mi') serverDate,TO_CHAR(sysdate,'dd/mm/yyyy HH24:mi') serverDateTime " );
		SelectSqlBuffer.append("FROM" );
		SelectSqlBuffer.append("  fm_Curr_Locn " );
		SelectSqlBuffer.append("WHERE Facility_Id ='"+p_enter_fcy+"' AND ( " );
		//SelectSqlBuffer.append("  AND File_No IN ("+p_concat_string+")");
	 //if (!added_volumes.equals(""))
	// SelectSqlBuffer.append( " AND volume_no in ("+added_volumes+")");
	  StringTokenizer fileno=new StringTokenizer(p_stored_val,"|");  
	  count_tokens=fileno.countTokens();
	   int P_cnt=0;
	  while(fileno.hasMoreTokens())
		{
	    P_cnt++;
	   fileno_volume    =fileno.nextToken() ;
	StringTokenizer fileno1=new StringTokenizer(fileno_volume,"`");		
	while(fileno1.hasMoreTokens())
		{
	filenum     =fileno1.nextToken() ;	
	volumenum	=fileno1.nextToken() ;
	}
	 SelectSqlBuffer.append("   ( File_No ='"+filenum+"' ");
	 if (!volumenum.equals(""))
			{
		if(count_tokens >P_cnt){
    SelectSqlBuffer.append( " AND volume_no ='"+volumenum+"' ) OR ");
			} else{
                  SelectSqlBuffer.append( " AND volume_no ='"+volumenum+"' )  ");
			}
			
			}
		}		
	// SelectSqlBuffer.append( " ) and curr_facility_id='"+p_enter_fcy+"' order by order_by_status,file_no ");
	 SelectSqlBuffer.append( " )  order by order_by_status,file_no,volume_no ");
	 rs = stmt.executeQuery(SelectSqlBuffer.toString());

		
%>

<TABLE border='1' cellpadding='0' cellspacing='0' width='100%' align='left' id="srch_result">
<%
int i = 1;
int p_rec_cnt = 0;
String classValue="";
String bgcolor="";
String p_allow_select="";
String p_checked="";
String serverDate="";
int p_request_cnt=0;
int p_not_request_cnt=0;

%>
<script>parent.frames[3].document.getElementById("hdr_tab").style.visibility='Visible';</script>
<%
while ( rs.next() )
{
	if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;

	if ( i == 1 )
		serverDate =rs.getString("serverDate");
		serverDateTime =rs.getString("serverDateTime");
		serverDateTime=DateUtils.convertDate(serverDateTime,"DMYHM","en",localeName);
perm_fs_locn_code=rs.getString("perm_fs_locn_code");
	if(perm_fs_locn_code==null) perm_fs_locn_code="";
	if (rs.getString("curr_file_status1").equals("A"))
	{
		bgcolor			= "FFEECC";
		p_allow_select	= "disabled";
		p_checked		= "";
	}
	else if (rs.getString("curr_file_status1").equals("T"))
	{
		bgcolor = "CCEEDD";
		p_allow_select	= "";
		p_checked		= "checked";

	}
	else if (rs.getString("curr_file_status1").equals("L"))
	{
		bgcolor = "FFFFEE";
		p_allow_select	= "disabled";
		p_checked		= "";

	}
	else if (rs.getString("curr_file_status1").equals("X"))
	{
		bgcolor = "ADD8E6";
		p_allow_select	= "disabled";
		p_checked		= "";
	}
	else if (rs.getString("curr_file_status1").equals("E"))
	{
		bgcolor = "E0FFFF";
		p_allow_select	= "";
		p_checked		= "checked";
	}
	else if (rs.getString("curr_file_status1").equals("O"))
	{
		bgcolor = "#D1BBA7";
		p_allow_select	= "";
		p_checked		= "checked";
	}
	else if (rs.getString("curr_file_status1").equals("R"))
	{
		bgcolor = "#C0C0C0";
		p_allow_select	= "disabled";
		p_checked		= "";
	}
	else
	{
		bgcolor = "";
		p_allow_select	= "";
		p_checked		= "checked";
	}

	String curr_file_status = checkForNull(rs.getString("Curr_File_Status"));
		if(!curr_file_status.equals(""))
		{
			switch(curr_file_status.charAt(0))
			{
				case 'T' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileInTransit.label","fm_labels"); break;

				case 'I' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisInside.label","fm_labels"); break;

				case 'L' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisLost.label","fm_labels"); break;

				case 'A' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisArchived.label","fm_labels"); break;

				case 'O' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisOutside.label","fm_labels"); break;

				case 'E' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OtherFacility.label","common_labels"); break;

				case 'R' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.returned.label","common_labels"); break;
			}
		}

		String curr_fs_locn_ident_desc = checkForNull(rs.getString("Curr_fs_Locn_Identity"));
		if(!curr_fs_locn_ident_desc.equals(""))
		{
			switch(curr_fs_locn_ident_desc.charAt(0))
			{
				case 'D' : curr_fs_locn_ident_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); 
					break;
				case 'T' : curr_fs_locn_ident_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); 
					break;
				case 'C' : curr_fs_locn_ident_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;
				case 'N' : curr_fs_locn_ident_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;
				case 'X' : curr_fs_locn_ident_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;
				case 'E' : curr_fs_locn_ident_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;
				case 'Y' : curr_fs_locn_ident_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
				default : curr_fs_locn_ident_desc = "";
			}
		}

	if (rs.getString("curr_file_status1").equals("I") || rs.getString("curr_file_status1").equals("O") || rs.getString("curr_file_status1").equals("T"))
	{
		if (p_request_cnt==0)
		{
%>
	<TR>
			<Td colspan = '8' class='columnheader'><b><h5><font size=1><fmt:message key="eFM.RequestedFiles.label" bundle="${fm_labels}"/></font></Td>
		</TR>
<%		}
		p_request_cnt++;

	}

	if (rs.getString("curr_file_status1").equals("L") || rs.getString("curr_file_status1").equals("A"))
	{
		if (p_not_request_cnt==0)
		{
			if (p_request_cnt>0)
			{
%>
		<TR>
			<Td colspan = '8' class='COLUMNHEADER'><b><h5><font size=1><fmt:message key="eFM.Filescannotberequested.label" bundle="${fm_labels}"/></font></Td>
		</TR>
<%
			}
			else
			{
%>
		<TR>
			<Td colspan = '8' class='COLUMNHEADER'><b><h5><font size=1><fmt:message key="eFM.Filescannotberequested.label" bundle="${fm_labels}"/></font></Td>
		</TR>
<%
			}
		}

		p_not_request_cnt++;
	}

%>

	<tr>
<%
	if (file_type_appl_yn.equals("N"))
	{
%>
	<td width="25%" class="<%= classValue %>" ><font size=1><b>
	<%= rs.getString("file_no") %></b><br><input type=hidden name=p_file_no<%= i %> value=<%= rs.getString("file_no") %>`<%=rs.getString("facility_id") %>>&nbsp;&nbsp;<%= rs.getString("patient_line").substring(0,rs.getString("patient_line").length()-6) %>
	</font></td>
	<td width="12%" align="CENTER" class="<%= classValue %>"><font size=1><%= (rs.getString("volume_no")==null)?"&nbsp;":rs.getString("volume_no")%><input type='hidden' name="file_type<%=i%>" id="file_type<%=i%>" value="<%= rs.getString("file_type_code")%>"><input type='hidden' name="p_volume_no<%=i%>" id="p_volume_no<%=i%>" value="<%=rs.getString("volume_no")%>"><input type='hidden' name="p_patient_id<%=i%>" id="p_patient_id<%=i%>" value="<%=rs.getString("patient_id")%>"></font></td>
<%
	}else if (file_type_appl_yn.equals("Y"))
	{
%>
<td width="25%" class="<%= classValue %>" id="ParamID"><font size=1><input type=hidden name=p_file_no<%= i %> value=<%= rs.getString("file_no") %>`<%=rs.getString("facility_id") %>>&nbsp;&nbsp;<%= rs.getString("patient_line").substring(0,rs.getString("patient_line").length()-6) %>
	</font></td>
	<td width="12%" align="CENTER" class="<%= classValue %>"><font size=1><%= (rs.getString("file_type_desc")==null)?"&nbsp;":(rs.getString("file_type_desc")+" / ")%><%= (rs.getString("volume_no")==null)?"&nbsp;":rs.getString("volume_no")%><input type='hidden' name="file_type<%=i%>" id="file_type<%=i%>" value="<%= rs.getString("file_type_code")%>"><input type='hidden' name="p_volume_no<%=i%>" id="p_volume_no<%=i%>" value="<%=rs.getString("volume_no")%>"><input type='hidden' name="p_patient_id<%=i%>" id="p_patient_id<%=i%>" value="<%=rs.getString("patient_id")%>"></font></td>
<%
	}
	if (rs.getString("curr_file_status1").equals("I") || rs.getString("curr_file_status1").equals("T") ||rs.getString("curr_file_status1").equals("O")) {
		if (conc_remarks.equals(null) || conc_remarks==null || conc_remarks.equals("null") || conc_remarks.equals("") ) {
%>
	</font></td><td width='8%' align="CENTER" class="<%= classValue %>"><font size=1><a href="javascript:GetRemarks(<%=i%>)"><fmt:message key="Common.EnterRemarks.label" bundle="${common_labels}"/></a></font></td><td width="13%" align="left" class="<%= classValue %>"><font size=1><input type="hidden" name="rem_recnum_<%= i %>" id="rem_recnum_<%= i %>" value="">
<%
		}
		else {
			String tempstr  = "";
			int ind = arrList.indexOf(rs.getString("file_no")+rs.getString("volume_no"));
			if (ind != -1)
			tempstr = (String)arrList.get(ind+1);
			if (tempstr == null || tempstr.equals("#")) tempstr = "";
%>
			</font></td><td width='8%' align="CENTER" class="<%= classValue %>"><font size=1><a href="javascript:GetRemarks(<%= i %>)"><fmt:message key="Common.EnterRemarks.label" bundle="${common_labels}"/></a></font></td><td width="13%" align="left" class="<%= classValue %>"><font size=1><input type="hidden" name="rem_recnum_<%= i %>" id="rem_recnum_<%= i %>" value="<%=tempstr%>">
<%
		}
	}
	else {
%>
		</font></td><td width="8%"  class="<%= classValue %>"><font size=1>&nbsp;&nbsp;</font></td><td width="13%"  class="<%= classValue %>"><font size=1><input type="hidden" name="rem_recnum_<%=i%>" id="rem_recnum_<%=i%>" value="">
<%
	}

%>
	 
<%= rs.getString("fs_locn_short_desc") %></font></td><td width='13%'  class="<%= classValue %>"><font size=1>
	<%= rs.getString("curr_fs_locn_short_desc")==null?"":rs.getString("curr_fs_locn_short_desc") %> <br> &nbsp;&nbsp;(<%= curr_fs_locn_ident_desc %>)
	</font></td>
<%
if (conc_remarks.equals(null) || conc_remarks==null || conc_remarks.equals("null") || conc_remarks.equals("") ) {

%>
	<td align="left" class="<%= classValue %>"><input type='text' id='fileReqdOn<%= i %>' name='p_file_required_on<%= i %>' value='<%=serverDateTime%>' maxlength='16' size='12'  <%= p_allow_select %> onblur='checkDateAlert(document.forms[0].serverDate,this)'><img  <%= p_allow_select %> src='../../eCommon/images/CommonCalendar.gif' id='imgFileReqd<%= i %>' onClick="return showCalendar('fileReqdOn<%= i %>', 'DMYHM', null,true);"/></td>
<%
		}
	else {
		String tempstr  = "";
			int ind = arrList.indexOf(rs.getString("file_no")+rs.getString("volume_no"));
			if (ind != -1)
			{
					tempstr = (String)arrList.get(ind+2);
			 	
			}
			if (tempstr == null || tempstr.equals("#")) 
			{
				
				tempstr = "";
			}
if(tempstr.equals("") && ind == -1)
		{
        tempstr=serverDateTime;
		}

%>
	<td align="left" class="<%= classValue %>"><input type='text' id='fileReqdOn<%= i %>' name='p_file_required_on<%= i %>' value='<%=tempstr%>' maxlength='16' size='12'  <%= p_allow_select %> onblur='checkDateAlert(document.forms[0].serverDate,this)'><img  <%= p_allow_select %> src='../../eCommon/images/CommonCalendar.gif' id='imgFileReqd<%= i %>' onClick="return showCalendar('fileReqdOn<%= i %>','DMYHM', null,true);"/></td>
<%
	}
%>
	<td width='9%'  class="<%= classValue %>"><font size=1>
	<%= curr_file_status%> <br><%= rs.getString("other_facility_name") %>
	</font></td><td width='8%' align="center" style="background-color:<%= bgcolor %>" class="<%= classValue %>"><font size=1>
	<input type=checkbox name=req_select<%= i %> <%= p_checked %> <%= p_allow_select %> value="Y">
	</font></td></tr>

<%
	if (p_select_values=="")
	{
		p_select_values = rs.getString("file_no")+'`'+rs.getString("facility_id");
	}
	else
	{
		p_select_values = p_select_values + '|' + rs.getString("file_no")+'`'+rs.getString("facility_id");
	}
	if (p_added_values=="")
	{
		p_added_values = rs.getString("file_no")+"$$"+rs.getString("volume_no");
	}
	else
	{
		p_added_values = p_added_values + '|' + rs.getString("file_no")+"$$"+rs.getString("volume_no");
	}
	i++;
	p_rec_cnt++;
  } //endwhile


%>
</TABLE>
<script>
	
	//////////////////////////////////////////////////////////////////////////////////

	parent.frames[3].document.forms[0].p_patient_id.value = "";
parent.frames[3].document.forms[0].p_patient_id.focus();
	if("<%=file_type_appl_yn%>" == "N")
	{
		parent.frames[3].document.getElementById("FileNo").innerHTML = "<input type='Text' name='<%=fileno_name%>' id='<%=fileno_name%>' value='' onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this);getPatIDVolume(this.value);<%=file_no_function%>' maxLength='20' size='20'><img src='../../eCommon/images/mandatory.gif' align='center'></img>";
	}
	else if("<%=file_type_appl_yn%>" == "Y")
	{
		parent.frames[3].document.getElementById("FileType").innerHTML = "<input type='Text' name='<%=filetype_name%>' id='<%=filetype_name%>' value='' onBlur='<%=file_type_function%>' readonly><img src='../../eCommon/images/mandatory.gif' align='center'></img>";
	}
	
	var selectBox   =					
	eval(<%=frame_name%>.document.<%=form_name%>.<%=volumeno_name%>);
	var seletLen	=	Math.abs(selectBox.length);
	for (i=0; i<seletLen; i++)
	{
		selectBox.remove(0);
	}

	var selectOption	=  eval(<%=frame_name%>).document.createElement("OPTION");		
	selectOption.value	=	"";
	selectOption.text	=	"-"+getLabel('Common.defaultSelect.label','common')+"-";
	selectBox.add(selectOption);
			
	//////////////////////////////////////////////////////////////////////////////////
			
	parent.frames[3].document.forms[0].p_deselect_values.value = "<%=p_not_in_files%>";
	parent.frames[1].document.forms[0].perm_fs_locn_code.value= "<%=perm_fs_locn_code%>";
	var old_value = parent.frames[3].document.forms[0].added_values.value;
	if (old_value != "")
		old_value += "|"+"<%=p_added_values%>";
	else old_value = "<%=p_added_values%>";
	parent.frames[3].document.forms[0].added_values.value=old_value;
	parent.frames[3].document.forms[0].p_select_values.value = "<%=p_stored_val%>";
	parent.frames[3].document.forms[0].p_total_records.value = "<%=p_rec_cnt%>";

	var p_in_files		= parent.frames[3].document.forms[0].p_select_values.value;
	var p_not_files	= parent.frames[3].document.forms[0].p_deselect_values.value;

	HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form2' id='form2' method='post' action='../../eFM/jsp/FMRequestDeSelectedFiles.jsp'><input name='p_new_string' id='p_new_string' type='hidden' value="+p_in_files+"><input name='p_deselect_files' id='p_deselect_files' type='hidden' value="+p_not_files+"></form></BODY></HTML>";


	parent.frames[3].document.forms[0].p_total_select.value = '<%=p_rec_cnt%>';
	for (i=0;i<7;i++)
	{
		if ((document.getElementById("srch_result").rows[i+1] != null) && (document.getElementById("srch_result").rows[i+1].cells[i] != null))
		{
			parent.frames[3].document.getElementById("hdr_tab").rows[0].cells[i].width = document.getElementById("srch_result").rows[i+1].cells[i].width; 
		}
	}
	
</script>
<input type='hidden' name=p_select_values value='<%=p_select_values%>'>
<input type='hidden' name=p_total_select value='<%=p_rec_cnt%>'>
<input type='hidden' name=serverDate value='<%=serverDate%>'>

</FORM>
</BODY>
<%
	if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0))
	{
		SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
	}
if(stmt!=null) stmt.close();
if(rs!=null)	rs.close();
}
catch(Exception e)
{
	e.printStackTrace();
}
finally
{	
	ConnectionManager.returnConnection(con,request);
}
%>

<%!
public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}
%>
</HTML>

