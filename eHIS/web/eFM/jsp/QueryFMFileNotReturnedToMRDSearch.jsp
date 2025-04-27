<!DOCTYPE html>
<!--  by Meghanath -->
<%@ page import="java.sql.*, java.util.*, webbeans.eCommon.* , java.text.* " contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<SCRIPT language='javascript' src='../../eCommon/js/common.js'></SCRIPT>
	<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js'></SCRIPT>
	<SCRIPT language='javascript' src='../../eFM/js/QueryFMFileNotReturnedToMRD.js'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<HEAD>
<BODY onMouseDown="CodeArrest();"  onKeyDown = 'lockKey();'>
	<form name="QuerySearch" id="QuerySearch" action="../../eFM/jsp/QueryFMFileNotReturnedToMRDSearchResult.jsp" method="post"  target="messageFrame">
<%
		Connection con				= ConnectionManager.getConnection(request);
		java.sql.Statement stmt		= null;
		ResultSet rset				= null ;
		java.sql.Statement stmt1	= null;
		ResultSet rset1				= null ;

		String doc_or_file			= "";
		String file_type_appl_yn	= "";
		
		stmt = con.createStatement();
		if(rset!=null)rset.close();
		rset = stmt.executeQuery("Select maintain_doc_or_file,file_type_appl_yn from MP_PARAM ");
		if(rset.next()) 
		{
			 doc_or_file		= rset.getString("maintain_doc_or_file")==null?"":rset.getString("maintain_doc_or_file");
			 file_type_appl_yn	= rset.getString("file_type_appl_yn")==null?"":rset.getString("file_type_appl_yn");		
		}
		
		if(stmt!=null)stmt.close();
		if(rset!=null)rset.close();

		String facility_id	 = (String)session.getValue("facility_id");	
	//	String params		 = request.getQueryString() ;
	//	String queryCriteria = request.getParameter("criteria")	  ;

		String sql ="SELECT fs_locn_code,short_desc FROM fm_storage_locn_lang_vw WHERE facility_id='"+ facility_id +"' AND mr_locn_yn='Y' AND permanent_file_area_yn='Y' AND eff_status='E' and language_id='"+localeName+"' ORDER BY 2 " ;
		
		String sql1 = "select facility_id,facility_name from sm_facility_param_lang_vw where language_id='"+localeName+"' order by 2";

		StringBuffer sb  = new StringBuffer();
		StringBuffer sb1 = new StringBuffer();

		String itemDescription = "" ;
		String itemCOde		= "" ;
	//	String OneRecordFlag	= "" ;
		String p_code			= "";
		String p_desc			= "";

		int     recordCount		= 0;	

		try
		{
			stmt = con.createStatement();		
			rset = stmt.executeQuery(sql);
			if(rset!=null)
			{		  
				while(rset.next())
				{
					 itemDescription =(rset.getString("short_desc")==null)?"":rset.getString("short_desc");
					 itemCOde	     =(rset.getString("fs_locn_code")==null)?"":rset.getString("fs_locn_code");
					 sb.append("<option value='"+itemCOde+"'>"+itemDescription+"</option>");
					 recordCount++;
				}
			//	if(recordCount == 1)
			//		OneRecordFlag="Yes";					
			}

			stmt1 = con.createStatement();		
			rset1 = stmt1.executeQuery(sql1);

			if(rset1!=null)
			{		  
				recordCount	= 0;
				while(rset1.next())
				{
					 p_desc =(rset1.getString("facility_name")==null)?"":rset1.getString("facility_name");
					 p_code =(rset1.getString("facility_id")==null)?"":rset1.getString("facility_id");
					 sb1.append("<option value='"+p_code+"'>"+p_desc+"</option>");
					 recordCount++;
				}
				
			}
		if(stmt!=null)	stmt.close();
		if(rset!=null)	rset.close();
		if(stmt1!=null) stmt1.close();
		if(rset1!=null) rset1.close();
	}
	catch(Exception e)
	{
		 out.println("Exception while fetching connection :" + e ) ;
	}
	finally
	{		 
		ConnectionManager.returnConnection(con, request);
	}
%>
<TABLE border="0" cellpadding="3" cellspacing="0" align='center' width='100%'>
	<TR>
		<TD class='label' width='25%'   maxlength="10" ><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></TD>
		<TD	width='25%' class='fields' ><select name='fs_locn_code' id='fs_locn_code' onChange='clearAllValues();' >
				<OPTION value='all' >------------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------</OPTION>
				<%=sb.toString()%>					
			</SELECT><IMG src='../../eCommon/images/mandatory.gif' align='center'></IMG>
		</TD>
		<TD class='label' width='25%' maxlength="10"><fmt:message key="eFM.OutstandingFrom.label" bundle="${fm_labels}"/></TD>
		<TD	width='25%' class='fields'>
			<select name='out_fcy' id='out_fcy' onChange='ClearResult();'>
				<OPTION value=''> --------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------------</OPTION>
				<%=sb1.toString()%>					
			</SELECT>
		</TD>
	</TR>
	<TR>
		<TD class= 'label'><fmt:message key="eFM.OutstandingFSLocation.label" bundle="${fm_labels}"/></TD>
		<TD class='fields' colspan='2'><SELECT name="fs_locn_id" id="fs_locn_id" onChange="PopulateFSLocn(this)">
				<OPTION value="">------------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------</OPTION>
				<OPTION value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></OPTION>
				<OPTION value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></OPTION>
				<OPTION value="E"><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></OPTION>
				<OPTION value="Y"><fmt:message key="Common.DaycareUnit.label" bundle="${common_labels}"/></OPTION>
				<OPTION value="T"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></OPTION>
				<OPTION value="D"><fmt:message key="Common.department.label" bundle="${common_labels}"/></OPTION>
			</SELECT>
			&nbsp;/&nbsp;
			<SELECT name='out_fs_locn' id='out_fs_locn'>
				<OPTION value='' >------------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------</OPTION>
			</SELECT>
		</TD>
		<TD class='button'>
			<INPUT type=button class=button name='search' id='search' value='Search' onClick="SearchGetResult()">
		</TD>
	</TR>
</TABLE>

	<INPUT type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
  	
  	<INPUT type='hidden' name='doc_or_file' id='doc_or_file' value='<%=doc_or_file%>'>
  	<INPUT type='hidden' name='file_type_appl_yn' id='file_type_appl_yn' value='<%=file_type_appl_yn%>'>
	</FORM>
	<script>
		if('<%=recordCount%>' == 1)
			document.forms[0].fs_locn_code.selectedIndex = 1;
    </script>
	</BODY>
</HTML>

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

