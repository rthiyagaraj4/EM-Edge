<!DOCTYPE html>
<%--
*	Copyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eHIS
*	Purpose 		:	To Display the Query Result
*	Created By		:	Dheeraj
*	Created On		:	
*   Modified by		:	
*   Modified on		:	
--%>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper "  contentType="text/html;charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>


<html>
	<head>
	<title></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrMessages.js"></script>
<script language="Javascript" src="../../eOR/js/OrCommon.js"></script>
<script language="Javascript" src="../../eOR/js/ReasonCode.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function Modify(obj){
		
		var code1=obj.cells[0].innerText;
		var code2=obj.cells[1].innerText;
		var code3=obj.cells[2].innerText;
		//var code4=obj.cells[3].children(0).value;
		var code4=obj.cells[3].innerText;
		var code5=obj.cells[4].innerText;
		var code6=obj.cells[5].innerText;
		var code7=obj.cells[6].innerText;
		 
		//var retVal = code1 + "\"" + code2 + "\"" + code3 + "\"" + code4 +"~";
		
		
		document.location.href = "../../eMR/jsp/NoteTerminologyCodeAddModify.jsp?mode=2&service_code="+escape(code1)+"&service_desc="+escape(code2)+"&note_type="+code3+"&note_type_desc="+escape(code4)+"&term_set="+escape(code5)+"&term_set_desc="+code6+"&level="+escape(code7)
	}
	</script>
	<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
 <%
   
	 request.setCharacterEncoding("UTF-8");
	 request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
     String sqlData         = "select a.service_code code,short_desc service_description, a.note_type note_type,note_type_desc, a.term_set_id term_set_id,term_set_desc,defn_levels code_level from mr_term_for_note_type_hdr a,am_service b,ca_note_type c,mr_term_set d where b.service_code = a.service_code and c.note_type = a.note_type and d.term_set_id = a.term_set_id and upper(a.service_code) like upper(?) and upper(short_Desc) like upper(?) and upper(a.note_type) like upper(?) and upper(note_type_desc) like upper(?) and a.term_set_id like upper(?) and term_set_desc like upper(?)";
   

    String service_code		= CommonBean.checkForNull( request.getParameter( "service_code" ) ) ;
    String service_desc		= CommonBean.checkForNull( request.getParameter( "service_description" ) ) ;
    String note_type		= CommonBean.checkForNull( request.getParameter( "note_type" ) ) ;
    String note_desc		= CommonBean.checkForNull( request.getParameter( "note_desc" ) ) ;
	
    String term_set			= CommonBean.checkForNull( request.getParameter( "term_set" ) ) ;
    String term_set_desc	= CommonBean.checkForNull( request.getParameter( "term_set_desc" ) ) ;
  	
	boolean searched		= request.getParameter( "searched" ) == null ? false : true  ;

	try{
	String classvalue			= "";

	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", sqlData);

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add( "code" );
    displayFields.add( "service_description" );
    displayFields.add( "note_type" );
    displayFields.add( "note_type_desc" );
    displayFields.add( "term_set_id" );
	displayFields.add( "term_set_desc" );
	displayFields.add( "code_level" );
	
   	
	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();


	chkFields.add(service_code+"%");
	chkFields.add(service_desc+"%");
	chkFields.add(note_type+"%");
	chkFields.add(note_desc+"%");
	chkFields.add(term_set+"%");
	chkFields.add(term_set_desc+"%");
			

	//Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=1 cellspacing=0 width="100%" align="center">
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		//For display the previous/next link
	     out.println(result.get(1));
	%>
		</td></tr>
		</table>

		<table border="2" cellpadding="0" cellspacing="0" width="100%" align="center" id='result_tbl'>
		<th width='10%'><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></th>
		<th width='20%'><fmt:message key="Common.ServiceDescription.label" bundle="${common_labels}"/></th>
		<th width='10%'><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></th>
		<th width='20%'><fmt:message key="Common.notetypedescription.label" bundle="${common_labels}"/></th>
		<th width='10%'><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/> </th>
		<th width='25%'><fmt:message key="Common.TermSetDescription.label" bundle="${common_labels}"/></th>
		<th width='5%'><fmt:message key="Common.Level.label" bundle="${common_labels}"/></th>
		
		<%
		
		  //Retriving the records from result arraylist
        ArrayList records=new ArrayList();
        for(int recCount=2; recCount<result.size(); recCount++) {
            if ( recCount % 2 == 0 )
                classvalue = "QRYEVEN" ;
            else
                classvalue = "QRYODD" ;
    %>
            <tr onClick="Modify(this);" >
    <%

           String link_columns = "1";
			            
			records=(ArrayList) result.get( recCount );

            for(int colCount=0; colCount<records.size(); colCount++){

	            if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
    %>
                    <td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><%=(String)records.get( colCount )%></font></td>
    <%          }else{%>
						<td class="<%=classvalue%>"  onclick="disableClick(event);"><%=(String)records.get( colCount )%></td>
					<%}
				}
            %>
           </tr>
    <%
        }
		if ( records != null)	records.clear();

    %>
		</table>
		<%out.flush();}else{%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'Common'));history.go(-1);</script> 
			<%}out.println(CommonBean.setForm(request ,"NoteTerminologyCodeQueryResult.jsp", searched));

	funcMap.clear();
	sqlMap.clear();
	displayFields.clear();
	chkFields.clear();
	result.clear();
	}
	catch(Exception e) {
		//out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace();
	}	
	%>
	</body>
	</html>

