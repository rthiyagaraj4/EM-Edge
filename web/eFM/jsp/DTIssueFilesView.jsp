<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="FMIssueFilesCart" scope="session" class="webbeans.eFM.FMFilesIssueCart"/> 

<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eFM/js/FMIssueFiles.js'></script>
	<script language='javascript' src='../../eFM/js/checkSystemDate.js'></script>
	<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eFM/js/FMIssueFilesDoc.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
	function GetRemarks(recnum) {	
		var dialogHeight	= "12" ;
		var dialogWidth		= "20" ;
		var dialogTop		= "185" ;
		var dialogLeft		= "250" ;
		var center			= "0" ;
		var status			= "no";
		var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + ";dialogLeft:" + dialogLeft;
		var arguments		= "" ;
		
		var transmode1 = "document.forms[0].file_transport_mode"+recnum;
		var obj1 = eval(transmode1);
		
		var carriedbyname1 = "document.forms[0].carried_by_name"+recnum;
		var obj2 = eval(carriedbyname1);
		

		retVal				= window.showModalDialog( "../../eFM/jsp/FMIssueFileModelWindow.jsp?from=detail&file_transport_mode="+obj1.value+"&carried_by_name="+obj2.value, arguments, features );
		var arr=new Array();

	if (!(retVal == null)) {
		var retVal=unescape(retVal);
		arr=retVal.split("::");

		var transmode = "document.forms[0].file_transport_mode"+recnum;
		var obj1 = eval(transmode);
		obj1.value = arr[0];
		var carriedbyname = "document.forms[0].carried_by_name"+recnum;
		var obj2 = eval(carriedbyname);
		obj2.value = arr[1];
		
		}
}	

</script>
<%
	Connection conn = null;
	String curr_facility_id = (String) session.getValue("facility_id");
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	ResultSet rset3 = null;
	Statement stmt          = null;
	ResultSet rs            = null;

	String classValue = "";
	String otherValue = "";
	String sql = "";
	String sql1 = "";
	String sql3 = "";
	String daystoreturn = "";
	String reqlocndesc = "";
	int Other_rec_count = 0;
	String p_locncode = "";
	String file_type_appl_yn = "N";
	String DOC_TYPE_CODE = "";
	String DOC_TYPE_NAME = "";
	String DOC_FOLDER_ID = "";
	String DOC_FOLDER_NAME = "";
	String DOC_TYPE = "";
	String return_criteria	 = "";
	String returndays	 = "";

	String sys_date_query    = "";
	String sys_date          = "";

	try
	{
		conn = ConnectionManager.getConnection(request);
		pstmt = conn.prepareStatement("SELECT file_type_appl_yn FROM mp_param ");
		rset = pstmt.executeQuery();
		if ((rset!=null) && (rset.next()))
		{
			file_type_appl_yn = rset.getString("file_type_appl_yn");
		}
		if(rset!=null)	rset.close();
		if ((file_type_appl_yn==null) || (file_type_appl_yn.equals("null")))
			file_type_appl_yn = "N";
		sys_date_query="select to_char(sysdate,'dd/mm/yyyy hh24:mi')from dual";
		stmt = conn.createStatement();
		rs   = stmt.executeQuery(sys_date_query);
		if(rs !=null && rs.next())
		{
			sys_date = rs.getString(1);
		}
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
<form name='IssueFileView_form' id='IssueFileView_form'>
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
 	<th width='14%'><fmt:message key="Common.requesteddate.label" bundle="${common_labels}"/></th> 	
	<%
		if (file_type_appl_yn.equals("N"))
		{
	%>
	<th><fmt:message key="Common.documentdetails.label" bundle="${common_labels}"/></th>	
	<th width="5%"<fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></th>	
	<%
		}
		else if (file_type_appl_yn.equals("Y"))
		{
	%>
	<th><fmt:message key="Common.documentdetails.label" bundle="${common_labels}"/></th>	
	<th width="5%"<fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></th>	
	<%
		}
	%>
	<th><fmt:message key="Common.RequestNo.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.RequestedBy.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="eFM.ReturnDate.label" bundle="${fm_labels}"/></th>
	<th><fmt:message key="Common.TransportMode.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.Issue.label" bundle="${common_labels}"/>?</th>
<%	
	sortFMFilesIssueCart(FMIssueFilesCart);
	ArrayList ArrFileCart =(ArrayList) FMIssueFilesCart.getPresCart();
	int countRec = ArrFileCart.size();
	if (countRec >0)
	{
		out.println("<script>parent.parent.frames[2].document.getElementById('tab1').style.visibility='visible';parent.parent.frames[2].document.getElementById('tab1').style.display='inline';</script>");
	}	
	String locn_identity = "";
	String number = "";
	String duration_type = "";
	int ind = 0;
	for(ind=0;ind < ArrFileCart.size();ind++)
	{
		if ( ind % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;

		webbeans.eFM.FMFilesIssueDetail fissuebean = new webbeans.eFM.FMFilesIssueDetail();
		fissuebean = FMIssueFilesCart.getIssuesfromCart(ind);		
		
	//	String indval = fissuebean.getIndex_Value();
		String fileno = fissuebean.getFile_No();
		String reqno = fissuebean.getReq_No();
		String file_type = fissuebean.getFile_Type();
		if ((file_type == null) || (file_type.equals("")))  file_type = "";
		String volume_no = fissuebean.getVolume_No();
		if (volume_no == null)  volume_no = "&nbsp;";
		String reqby = fissuebean.getRec_Name_Desc();
		String locncode = fissuebean.getRec_Locn_Code();
		String fac_id = fissuebean.getReq_Facility_Id();
	//	String from	= fissuebean.getRequest_From();	
		String reqfrom = fissuebean.getRequest_From();
		String reqdatetime = fissuebean.getRequest_Date_Time();	
		
		int hrs = 0;
		sql = "select locn_identity from fm_storage_locn where FACILITY_ID = ? and FS_LOCN_CODE = ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,fac_id);
		pstmt.setString(2,locncode);
		rset = pstmt.executeQuery();

		while(rset.next())
		{
			locn_identity = rset.getString(1);
		}
		if(rset!=null)	rset.close();
		if(pstmt!=null)	pstmt.close();
		
		if(locn_identity.equals("C") || locn_identity.equals("N"))
		{
			sql = "SELECT (CASE WHEN  LOCN_IDENTITY in('C','E') THEN NO_OF_DH_TO_RETURN_OP ELSE (CASE WHEN LOCN_IDENTITY = 'N' THEN NO_OF_DH_TO_RETURN_IP ELSE (CASE WHEN LOCN_IDENTITY = 'Y' THEN NO_OF_DH_TO_RETURN_DC END) END) END),duration_type FROM fm_storage_locn WHERE FS_LOCN_CODE = ? AND FACILITY_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,locncode);
		pstmt.setString(2,fac_id);
			rset = pstmt.executeQuery();
			while(rset.next())
			{
				number = rset.getString(1);
				duration_type = rset.getString(2);
			}			
			if(rset!=null)	rset.close();
			if(pstmt!=null)	pstmt.close();

			if(number==null || number.equals(""))
				number = "0";
			if(duration_type == null || duration_type.equals("null"))	  duration_type = "";

			if(duration_type.equals("D"))
				hrs = Integer.parseInt(number)*24;
			else if(duration_type.equals("H"))
				hrs = Integer.parseInt(number);
		}
////
sql3 = "select a.DOC_TYPE_CODE, a.DOC_TYPE_NAME, a.DOC_FOLDER_ID, a.DOC_FOLDER_NAME, (CASE WHEN f.PATIENT_PERIOD_SPECIFIC='D' THEN ' ,' || TO_CHAR(f.from_period,'dd/mm/rrrr ') || ' - ' || TO_CHAR(f.to_period,'dd/mm/rrrr ')  ELSE ' ' || get_patient_line(f.patient_id,'"+localeName+"') END)doc_type from fm_curr_locn_vw a, fm_doc_folder f  Where a.DOC_FOLDER_ID=f.doc_folder_id and a.FACILITY_ID = ? and a.FILE_NO = ? ";

		pstmt = conn.prepareStatement(sql3);
		pstmt.setString(1,curr_facility_id);
		pstmt.setString(2,fileno);
		rset3 = pstmt.executeQuery();

		if(rset3.next())
		{
			DOC_TYPE_CODE = rset3.getString(1);
			DOC_TYPE_NAME = rset3.getString(2);
			DOC_FOLDER_ID = rset3.getString(3);
			DOC_FOLDER_NAME = rset3.getString(4);
			DOC_TYPE = rset3.getString(5);
		}
		if(pstmt!=null)	pstmt.close();

		if ((DOC_TYPE_CODE==null) || (DOC_TYPE_CODE.equals(""))) DOC_TYPE_CODE = "&nbsp;";
		if ((DOC_TYPE_NAME==null) || (DOC_TYPE_NAME.equals(""))) DOC_TYPE_NAME = "&nbsp;";
		if ((DOC_FOLDER_ID==null) || (DOC_FOLDER_ID.equals(""))) DOC_FOLDER_ID = "&nbsp;";
		if ((DOC_FOLDER_NAME==null) || (DOC_FOLDER_NAME.equals(""))) DOC_FOLDER_NAME = "&nbsp;";
		if ((DOC_TYPE==null) || (DOC_TYPE.equals(""))) DOC_TYPE = "&nbsp;";

////

		sql = "Select to_char(SYSDATE+"+(hrs)+"/24,'DD/MM/YYYY HH24:MI') RET, SHORT_DESC,RETURN_CRITERIA from FM_STORAGE_LOCN Where FACILITY_ID = ? and FS_LOCN_CODE = ? ";

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,fac_id);
		pstmt.setString(2,locncode);
		rset = pstmt.executeQuery();

		if(rset.next())
		{
			returndays = rset.getString(1);
			reqlocndesc = rset.getString(2);
			return_criteria = rset.getString(3);
		}
		if(pstmt!=null)	pstmt.close();
		if(rset!=null)	rset.close();
		
		if(returndays == null || returndays.equals("null"))	  returndays = "&nbsp;";
		if(return_criteria == null || return_criteria.equals("null"))	  return_criteria = "";
		if (return_criteria.equals("I"))
		{
			daystoreturn = returndays;
		}else
		{
			daystoreturn = "";
		}
		if(reqno.equals(""))	  reqno = "&nbsp;";

		if(reqfrom.equals("S") || reqfrom.equals("MS"))
			otherValue = "lightgreen";  //"CCEEDD";
		else if(reqfrom.equals("D") || reqfrom.equals("MD"))
			otherValue = "lightpink";	//"FFEECC";

		sql1 = "select count(*) from fm_encounter_VOLUME_LINK a,pr_encounter b where a.facility_id = ? and a.file_no = ? and b.facility_id=a.facility_id and  b.encounter_id=a.encounter_id and volume_no= ? and closed_date is null and b.mlc_yn='Y'";
						
					pstmt = conn.prepareStatement(sql1);
					pstmt.setString(1,curr_facility_id);
					pstmt.setString(2,fileno);
					pstmt.setString(3,volume_no);
					rset  = pstmt.executeQuery();
		if ((rset != null) && (rset.next()))
			{					
					Other_rec_count = rset.getInt(1);					
			}
			if(rset!=null)	rset.close();
			if(pstmt!=null)	pstmt.close();

      if (ind==0)
           {
                p_locncode = locncode;
%>
        <tr>
            <td  width="90%" height="20" colspan=8  class='CAGROUPHEADING' ><b><%=reqlocndesc%></b></td>
        </tr>
<%
            }
        else if (!p_locncode.equals(locncode))
            {
                p_locncode = locncode;
%>
        <tr>
            <td  width="90%" height="20" colspan=8 class='CAGROUPHEADING' ><b><%=reqlocndesc%></b></td>
        </tr>
<%
            }
 
		out.println("<tr><td class='"+classValue+"' nowrap><font size='1'>");
		out.println(reqdatetime);		
		out.println("</font></td><td class='"+classValue+"'><font size='1'><b>");			out.println(DOC_FOLDER_ID+"</b><br>&nbsp;"+DOC_FOLDER_NAME+"&nbsp;"+DOC_TYPE);
		out.println("</font></td><td class='"+classValue+"' align='CENTER'><font size='1'>");
		out.println(DOC_TYPE_NAME);			
		out.println("</font></td><td class='"+classValue+"'><font size='1'>");
		out.println(reqno);
		out.println("</font></td><td class='"+classValue+"'><font size='1'>");
		out.println(reqby);
		out.println("</font></td>");
%>
		<td class='"+classValue+"'>
		<input type='text' name='retdate<%=ind %>' id='retdate<%=ind %>' id='datetd<%=ind %>' size='16' maxlength='16' tabIndex='3' value='' onBlur='ValidateDateTime(this,sys_date);'><img name='im<%=ind %>' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('retdate<%=ind %>', null, 'hh:mm');" onMouseover="changeCursor(this)"></img>
		</td>
<%		
		if(locn_identity.equals("C") || locn_identity.equals("N"))
		{
%>			
			<SCRIPT>
				document.forms[0].retdate<%=ind %>.value    = "<%=daystoreturn%>"; 
				document.forms[0].retdate<%=ind %>.disabled = true; 
				document.forms[0].im<%=ind %>.disabled      = true; 
			</SCRIPT> 
<%
		}
		else if(locn_identity.equals("T") || locn_identity.equals("D"))
		{
%>			
			<SCRIPT>
				if(document.forms[0].retdate<%=ind %>.disabled  == true)
					document.forms[0].retdate<%=ind %>.disabled = false;
				if(document.forms[0].im<%=ind %>.disabled  == true)
					document.forms[0].im<%=ind %>.disabled = false;
			</SCRIPT> 
<%
		}		
		out.println("<td class='"+classValue+"'><font size='1'>");
%>
		 <a href='javascript:GetRemarks(<%=ind %>)'><fmt:message key="Common.ModeOfTransport.label" bundle="${common_labels}"/></a></font></td>
	<input type="hidden" name="rem_recnum_<%= ind %>" id="rem_recnum_<%= ind %>" value="">
	
	<input type="hidden" name="file_transport_mode<%= ind %>" id="file_transport_mode<%= ind %>" value="">
	<input type="hidden" name="carried_by_name<%= ind %>" id="carried_by_name<%= ind %>" value="">
<%
		out.println("</font></td><td style='background-color:"+otherValue+";' align='CENTER'>");
		if (Other_rec_count > 0)
		{
		if(reqfrom.equals("MS") || reqfrom.equals("MD"))
			out.println("<font size='1'>&nbsp;<input type='checkbox' name='issue"+ind+"' id='issue"+ind+"' checked onClick='RemoveIssueFileView("+ind+");'><img src='../../eFM/images/stop.gif' align='center'></img>#");
		else
			out.println("<font size='1'>&nbsp;<input type='checkbox' name='issue"+ind+"' id='issue"+ind+"' checked onClick='RemoveIssueFileView("+ind+");'>&nbsp;<img src='../../eFM/images/stop.gif' align='center'></img>");
		}else
		{
			if(reqfrom.equals("MS") || reqfrom.equals("MD"))
			out.println("<font size='1'>&nbsp;<input type='checkbox' name='issue"+ind+"' id='issue"+ind+"' checked onClick='RemoveIssueFileView("+ind+");'>&nbsp;#");
		else
			out.println("<font size='1'>&nbsp;<input type='checkbox' name='issue"+ind+"' id='issue"+ind+"' checked onClick='RemoveIssueFileView("+ind+");'>&nbsp;");
		};
		out.println("</font></td></tr>");

	}

	out.println("<input type='hidden' name='fileCount' id='fileCount' value=\""+ind+"\">");

	if(rset!=null)	rset.close();
	if(pstmt!=null)	pstmt.close();
	if(rset3!=null)	rset3.close();
	if(stmt  !=null) stmt.close();
	if(rs    !=null) rs.close();
	}
	catch(Exception e)
	{
		out.println(e);
	}
	finally
	{		
		ConnectionManager.returnConnection(conn,request);
	}
%>
	<input type="hidden" name="comm_file_transport_mode" id="comm_file_transport_mode" value="">
	<input type="hidden" name="comm_carried_by_name" id="comm_carried_by_name" value="">
	<input type='hidden' name='sys_date' id='sys_date' value='<%=sys_date%>'>
</form>
</body>
</html>
<%!
	public boolean sortFMFilesIssueCart(webbeans.eFM.FMFilesIssueCart FMIssueFilesCart) throws Exception
	{
		String	Rec_Locn_Code	=	"",		next_Rec_Locn_Code		=	"";
		boolean	isSorted		=	true;
		ArrayList ArrFileCart	=	(ArrayList) FMIssueFilesCart.getPresCart();
		webbeans.eFM.FMFilesIssueDetail fissuebean = new webbeans.eFM.FMFilesIssueDetail();
		webbeans.eFM.FMFilesIssueDetail fissuebean2 = new 	
		webbeans.eFM.FMFilesIssueDetail();		
		
		try
		{
			for( int i=0; i<ArrFileCart.size(); i++ )
			{
				for(int j=0; j<ArrFileCart.size()-1-i;j++)
				{
					fissuebean	=	FMIssueFilesCart.getIssuesfromCart(j);
					Rec_Locn_Code	=	(String)			
					fissuebean.getRec_Locn_Code();
					fissuebean2	=	FMIssueFilesCart.getIssuesfromCart(j+1);
					next_Rec_Locn_Code	=	(String)				fissuebean2.getRec_Locn_Code();
					if(Rec_Locn_Code.compareToIgnoreCase(next_Rec_Locn_Code)<0)
					{
						FMIssueFilesCart.updIssuestoCart(fissuebean2.cloneFMFilesIssueDetail(), j);
						FMIssueFilesCart.updIssuestoCart(fissuebean.cloneFMFilesIssueDetail(), j+1);
					}
				}
			}
		}
		catch(Exception e)
		{
			isSorted = false;
		}
		return isSorted;
	}
%>

