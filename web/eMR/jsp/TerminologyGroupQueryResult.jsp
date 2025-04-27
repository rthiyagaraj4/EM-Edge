<!DOCTYPE html>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<title></title>
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
		var code4=obj.cells[3].innerText;
		var codeIndex=obj.cells[4].innerText;
		//var code5=obj.cells[5].value;
		var code5 = document.getElementById("effstatus").getAttribute("data-value");

		document.location.href = "../../eMR/jsp/TerminologyGroupAddModifyHeader.jsp?mode=2&indexed="+codeIndex+"&term_group_id="+code1+"&term_group_desc="+code2+"&&term_set_id="+code3+"&term_set_desc="+code4+"&eff_status="+code5;
	}
	</script>
</head>
	
	<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
 <%
   
	 request.setCharacterEncoding("UTF-8");
	 request= new XSSRequestWrapper(request);
	 response.addHeader("X-XSS-Protection", "1; mode=block");
	 response.addHeader("X-Content-Type-Options", "nosniff");
     String sqlData = "select a.term_group_id, a.term_set_id, a.term_group_desc, a.eff_status, b.term_set_desc, a.index_type_yn  from MR_TERM_GROUP_HDR a, MR_TERM_SET b where a.term_set_id = b.term_set_id and upper(a.TERM_GROUP_ID) like upper(?) and upper(a.TERM_GROUP_DESC) like upper(?) and upper(a.TERM_SET_ID) like upper(?)  and upper(b.TERM_SET_DESC) like upper(?) and upper(a.eff_status) like upper(?)";

	 String status="";
   

    String term_group_id= CommonBean.checkForNull( request.getParameter( "TerminologyGroup_ID" ) ) ;
    String term_group_desc= CommonBean.checkForNull( request.getParameter( "TerminologyGroup_desc" ) ) ;
    String term_set_id	= CommonBean.checkForNull( request.getParameter( "term_set_id" ) ) ;
    String term_set_desc= CommonBean.checkForNull( request.getParameter( "TerminologySet_desc" ) ) ;
    String index_type_yn= CommonBean.checkForNull( request.getParameter( "index_type_yn" ) ) ;
	
    String eff_status	= CommonBean.checkForNull( request.getParameter( "eff_status_yn" ) ) ;

  	
	boolean searched	= request.getParameter( "searched" ) == null ? false : true  ;

	if(term_set_id=="E" || term_set_id.equals("E"))
		term_set_id="";
	

	try
	{
		String classvalue	= "";

		HashMap sqlMap = new HashMap();
		sqlMap.put( "sqlData", sqlData);

		// Function Parameters

		HashMap funcMap = new HashMap();

		// The fields are going to be display

		ArrayList displayFields = new ArrayList();
		displayFields.add( "term_group_id");
	    displayFields.add( "term_group_desc");
		displayFields.add( "term_set_id" );
	    displayFields.add( "term_set_desc" );
		displayFields.add( "index_type_yn" );
		displayFields.add( "eff_status" );

	
   	
		// The fields are going to be in where condition * should match with the query
	
		ArrayList chkFields = new ArrayList();


		chkFields.add(term_group_id+"%");
		chkFields.add(term_group_desc+"%");
		chkFields.add(term_set_id+"%");
		chkFields.add(term_set_desc+"%");
		chkFields.add(eff_status+"%");
			

		// Adding function related array list into the HashMap

		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

		// Calling the Result from Common Adaptor as a arraylist.
		ArrayList result = (ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
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
			<th width='20%'><fmt:message key="eMR.TerminologyDescription.label" bundle="${mr_labels}"/></th>
			<th width='12%'><fmt:message key="Common.TermSetID.label" bundle="${common_labels}"/></th>
			<th width='20%'><fmt:message key="Common.TermSetDescription.label" bundle="${common_labels}"/></th>
			<th width='20%'><fmt:message key="eMR.Indexed.label" bundle="${mr_labels}"/></th>
			<th width='6%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/> </th>		
			<%
		
			// Retriving the records from result arraylist
		
			ArrayList records=new ArrayList();
			for(int recCount=2; recCount<result.size(); recCount++)
			{
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
		%>
            <tr onClick="Modify(this);" >
	    <%

			String link_columns = "1";
			            
			records=(ArrayList) result.get( recCount );

            for(int colCount=0; colCount<records.size(); colCount++)
			{
	            if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 )
				{
	    %>
                    <td class="<%=classvalue%>" onmouseover="this.style.cursor='pointer'"  ><font class='HYPERLINK'><%=(String)records.get( colCount )%></font></td>
	    <%      }
				else
				{
					if(((String)records.get(colCount)).equals("E")) { status="E";%>
						<td align="center" class=<%=classvalue%> data-value=<%=status%> id="effstatus" onclick="disableClick(event);"><img src='../../eCommon/images/enabled.gif'></img></td>
						
						<%}else if(((String)records.get(colCount)).equals("D")){ status="D";
						%>
						<td align="center" class=<%=classvalue%> data-value=<%=status%> id="effstatus" onclick="disableClick(event);"><img src='../../eCommon/images/RRnwd.gif'></img></td>
							<%}else{%>

						<td class="<%=classvalue%>"  onclick="disableClick(event);"><%=(String)records.get( colCount )%></td>
				<%}}
				}
        %>
			</tr>
    <%
		if ( records != null ) records.clear();
        }
    %>
		</table>
		</form>
		<%out.flush();
	}
	else
	{
		%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'Common'));history.go(-1);</script> 
			<%}out.println(CommonBean.setForm(request ,"TerminologyGroupQueryResult.jsp", searched));
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
	</body>
	</html>

