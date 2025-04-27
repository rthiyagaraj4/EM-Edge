<!DOCTYPE html>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="JavaScript" src="../js/TerminologyGroup.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function Modify(obj)
	{	
		var code1=obj.cells[0].innerText;
		var code2=escape(obj.cells[1].innerText);
		var code3=obj.cells[2].innerText;
		//var code4=obj.cells[3].value;
		
		document.location.href = "../../eMR/jsp/CustomListTerminologyGroupAddModify.jsp?mode=2&term_group_id="+code1+"&term_set_id="+code2+"&index_type="+code3+"&effect_status="+code4;
		
		parent.frames[2].location.href="../../eMR/jsp/CustomListTerminologyGroupAddModifyDetail.jsp?mode=2&term_set_id="+code2+"&term_grp_id="+code1+"&index_type="+code3+"&fromSearch=selectedrecord";
	}
	</script>
	</head>
	
	<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
 <%
   
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	 response.addHeader("X-XSS-Protection", "1; mode=block");
	 response.addHeader("X-Content-Type-Options", "nosniff");
	//String sqlData = "select * from MR_CUSTOM_LIST_TERM_GROUP_DTL where upper(term_group_id) like upper(?) and upper(term_set_id) like upper(?) and upper(index_type) like upper(?) and upper(eff_status) like upper(?)";
	
	//String sqlData = "select TERM_GROUP_ID,TERM_SET_ID,INDEX_TYPE,AM_GET_DESC.AM_SPECIALITY(SPECIALITY_CODE,'"+localeName+"','2') SPECIALITY_DESC ,AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+localeName+"','2') PRACTITIONER_DESC,  EFF_STATUS from MR_CUSTOM_LIST_TERM_GROUP_DTL where upper(term_group_id) like upper(?) and upper(term_set_id) like upper(?) and upper(index_type) like upper(?) and upper(eff_status) like upper(?)";

	

	String status = "";
	String term_group_id	= CommonBean.checkForNull(request.getParameter("term_group_id"));
//	String term_group_desc	= CommonBean.checkForNull(request.getParameter("TerminologyGroup_desc"));
	String term_set_id		= CommonBean.checkForNull(request.getParameter("term_set_id"));
	String index_type		= CommonBean.checkForNull(request.getParameter("index_type"));
	String spclt_code		= CommonBean.checkForNull(request.getParameter("spclt_code"));
	String pract_id			= CommonBean.checkForNull(request.getParameter("pract_id"));
	String spclt_desc		= CommonBean.checkForNull(request.getParameter("spclt_desc"));
	String pract_name		= CommonBean.checkForNull(request.getParameter("pract_name"));
	//String eff_status		= CommonBean.checkForNull(request.getParameter("eff_status"));
	String term_grp_desc	= CommonBean.checkForNull(request.getParameter("terminologygroup_desc"));

	
	boolean searched		= request.getParameter( "searched" ) == null ? false : true;

	try
	{
		String classvalue	= "";
		StringBuffer sqlData = new StringBuffer("");
		//sqlData.append("select TERM_GROUP_ID,TERM_SET_ID,INDEX_TYPE,AM_GET_DESC.AM_SPECIALITY(SPECIALITY_CODE,'"+localeName+"','2') SPECIALITY_DESC ,AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+localeName+"','2') PRACTITIONER_DESC,  EFF_STATUS from MR_CUSTOM_LIST_TERM_GROUP_DTL where upper(term_group_id) like upper(?) and upper(term_set_id) like upper(?) and upper(index_type) like upper(?) and upper(eff_status) like upper(?) ");
		
		//out.println("<script>alert('comes here');</script>");
		sqlData.append("select a.TERM_GROUP_ID,a.TERM_SET_ID,a.INDEX_TYPE,AM_GET_DESC.AM_SPECIALITY(a.SPECIALITY_CODE,'"+localeName+"','2') SPECIALITY_DESC ,AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+localeName+"','2') PRACTITIONER_DESC from MR_CUSTOM_LIST_TERM_GROUP_DTL a , AM_PRACTITIONER b, AM_SPECIALITY c , mr_term_group_hdr d");

		
		sqlData.append(" where upper(a.term_group_id) like upper(?) and upper(a.term_set_id) like upper(?) and upper(a.index_type) like upper(?)  ");

		sqlData.append(" AND d.TERM_GROUP_ID= a.term_group_id AND d.TERM_SET_ID =a.term_set_id  AND  c.SPECIALITY_CODE(+)= a.SPECIALITY_CODE  and  a.PRACTITIONER_ID  =    b.PRACTITIONER_ID(+) ");
		
		if(spclt_code!=null && !spclt_code.equals("") && (pract_id ==null || pract_id.equals("")))
			sqlData.append(" and upper(a.SPECIALITY_CODE) like upper(?) ");
		
		if(pract_id!=null && !pract_id.equals("") && (spclt_code ==null || spclt_code.equals("")))
			sqlData.append(" and upper(a.PRACTITIONER_ID) like upper(?) ");

		if(spclt_code!=null && !spclt_code.equals("") && pract_id!=null && !pract_id.equals(""))
			sqlData.append(" and upper(a.SPECIALITY_CODE) like upper(?) and  upper(a.PRACTITIONER_ID) like upper(?)");

		if(spclt_desc!=null && !spclt_desc.equals("") && (pract_name ==null || pract_name.equals("")))
			sqlData.append(" and upper(c.SHORT_DESC) like upper(?) and c.SPECIALITY_CODE=a.SPECIALITY_CODE ");

		if(pract_name!=null && !pract_name.equals("") && (spclt_desc ==null || spclt_desc.equals("")))
			sqlData.append(" and upper(b.PRACTITIONER_NAME) like upper(?) and  b.PRACTITIONER_ID=a.PRACTITIONER_ID");

		if(spclt_desc!=null && !spclt_desc.equals("") && pract_name!=null && !pract_name.equals(""))
			sqlData.append(" and upper(c.SHORT_DESC) like upper(?) and  upper(b.PRACTITIONER_NAME) like upper(?) and c.SPECIALITY_CODE=a.SPECIALITY_CODE  and b.PRACTITIONER_ID=a.PRACTITIONER_ID ");
			
		if(term_grp_desc!=null && !term_grp_desc.equals(""))
			sqlData.append(" and upper(d.TERM_GROUP_DESC) like upper(?) and d.TERM_GROUP_ID=a.TERM_GROUP_ID ");


	

		HashMap sqlMap = new HashMap();
		sqlMap.put( "sqlData", sqlData.toString());

		// Function Parameters
		HashMap funcMap = new HashMap();

		// The fields are going to be display
		ArrayList displayFields = new ArrayList();
		displayFields.add( "term_group_id");
	    displayFields.add( "term_set_id");
		displayFields.add( "index_type" );
		displayFields.add( "SPECIALITY_DESC");
		displayFields.add( "PRACTITIONER_DESC" );
		//displayFields.add( "eff_status" );
	
   		
		// The fields are going to be in where condition * should match with the query
		ArrayList chkFields = new ArrayList();
		chkFields.add(term_group_id+"%");
		chkFields.add(term_set_id+"%");
		chkFields.add(index_type+"%");
		//chkFields.add(eff_status+"%");
		if(spclt_code!=null && !spclt_code.equals("") && (pract_id ==null || pract_id.equals("")))
			chkFields.add(spclt_code+"%");
		if(pract_id!=null && !pract_id.equals("") && (spclt_code ==null || spclt_code.equals("")))	
			chkFields.add(pract_id+"%");
		if(spclt_code!=null && !spclt_code.equals("") && pract_id!=null && !pract_id.equals(""))
		{
			chkFields.add(spclt_code+"%");
			chkFields.add(pract_id+"%");
		}

		if(spclt_desc!=null && !spclt_desc.equals("") && (pract_name ==null || pract_name.equals("")))
			chkFields.add(spclt_desc+"%");

		if(pract_name!=null && !pract_name.equals("") && (spclt_desc ==null || spclt_desc.equals("")))
			chkFields.add(pract_name+"%");

		if(spclt_desc!=null && !spclt_desc.equals("") && pract_name!=null && !pract_name.equals(""))
		{
			chkFields.add(spclt_desc+"%");
			chkFields.add(pract_name+"%");
		}

		if(term_grp_desc!=null && !term_grp_desc.equals(""))
			chkFields.add(term_grp_desc+"%");	
	
	
			
	// Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

		// Calling the Result from Common Adaptor as a arraylist.
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		
		if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) ))
		{
		%>
			<table cellpadding=1 cellspacing=0 width="100%" align="center">
			<tr>
			<td width="80%" class="white">&nbsp;</td>
			<td width="20%" class="white">&nbsp;
		<%
	
			// For display the previous/next link
			 out.println(result.get(1));
		%>
			</td></tr>
			</table>

			<table border="2" cellpadding="0" cellspacing="0" width="100%" align="center" id='result_tbl'>
			<th width='12%'><fmt:message key="eMR.TerminologyID.label" bundle="${mr_labels}"/></th>
			<th width='12%'><fmt:message key="Common.TermSetID.label" bundle="${common_labels}"/></th>
			<th width='12%'><fmt:message key="Common.IndexType.label" bundle="${common_labels}"/></th>
			<th width='12%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
			<th width='12%'><fmt:message key="Common.practitionername.label" bundle="${mr_labels}"/></th>
			<!--<th width='6%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/> </th>-->		
			<%
		
			// Retriving the records from result arraylist

			ArrayList records=new ArrayList();
			String speclt_pract_desc = "";
			for(int recCount=2; recCount<result.size(); recCount++)
			{
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
		%>
           <!-- <tr onClick="Modify(this);" >-->
		   <tr>
	    <%
			String link_columns = "1";
			records = (ArrayList) result.get(recCount);
			for(int colCount = 0; colCount < records.size(); colCount++)
			{
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 )
				{    
				%>
					
                   <!-- <td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><%=checkForNull((String)records.get(colCount))%></font></td>-->
				   <td class="<%=classvalue%>" ><%=checkForNull((String)records.get(colCount))%></td>
		    <%	}
				else
				{
					if(checkForNull(((String)records.get(colCount))).equals("E")) 
					{	
						status = "E";	%>
						<td align="center" class="<%=classvalue%>" value=<%=status%> onclick="disableClick(event);"><img src='../../eCommon/images/enabled.gif'></img></td>
				<%	}
					else if(checkForNull(((String)records.get(colCount))).equals("D"))
					{
						status = "D";	%>
						<td align="center" class="<%=classvalue%>" value=<%=status%> onclick="disableClick(event);"><img src='../../eCommon/images/RRnwd.gif'></img></td>
				<%	}
					else
					{	
						speclt_pract_desc = checkForNull((String)records.get(colCount));
						if(speclt_pract_desc.equals("P"))
							speclt_pract_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
						else if(speclt_pract_desc.equals("S"))
							speclt_pract_desc =
							com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
						else if(speclt_pract_desc.equals(""))
							speclt_pract_desc = "&nbsp;";
						%>
						<td class="<%=classvalue%>" onclick="disableClick(event);"><%=speclt_pract_desc%></td>
				<%	}	
				}
			}	%>
			</tr>
    <%	if ( records != null ) records.clear();
        }
    %>
		</table>
	</form>
<%	out.flush();
	}
	else
	{	%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'Common'));history.go(-1);</script> 
<%	}
		out.println(CommonBean.setForm(request ,"CustomListTerminologyGroupQueryResult.jsp", searched));
		funcMap.clear();
		sqlMap.clear();
		displayFields.clear();
		chkFields.clear();
		result.clear();
	}
	catch(Exception e)
	{
		//out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace();
	}	
%>
	<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals(""))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals(""))) ? defaultValue : inputString);
	}
%>
	</body>
	</html>

