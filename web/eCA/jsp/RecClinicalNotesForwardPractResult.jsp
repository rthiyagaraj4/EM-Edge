<!DOCTYPE html>
<%@ page import="java.util.*, java.sql.*,eCommon.Common.*,java.net.URLEncoder,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	 String callFrom        = request.getParameter( "callFrom" )==null?"": request.getParameter( "callFrom" );
if( !callFrom.equals("0") ) {%> 
<html>
    <head>
        <title></title>
<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
        <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>       
        <script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
    
</head>
<body onKeyDown = 'lockKey()'>
<%
    }
    eCA.RecClinicalNotesPractBean pracObj = new eCA.RecClinicalNotesPractBean();
    //Search Criteria's from Query Criteria page
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int maxRecord = 0;
	String sql = "",sqlCount="";
	
	String speciality_id = request.getParameter("speciality_id")==null?"":request.getParameter("speciality_id");
	String locale =		session.getAttribute("LOCALE")==null?"":(String)session.getAttribute("LOCALE");
	String facility_id =		session.getAttribute("facility_id")==null?"":(String)session.getAttribute("facility_id");
	String clinician_id = request.getParameter("clinician_id")==null?"":request.getParameter("clinician_id");
	String note_type = request.getParameter("note_type")==null?"":request.getParameter("note_type");
	String search_text = request.getParameter("search_text")==null?"":request.getParameter("search_text");
	String search_by = request.getParameter("search_by")==null?"D":request.getParameter("search_by");
	String search_criteria = request.getParameter("search_criteria")==null?"S":request.getParameter("search_criteria");
	String from = request.getParameter("from")==null?"1":request.getParameter("from");
	String to = request.getParameter("to")==null?"14":request.getParameter("to");
	
	int start = Integer.parseInt(from) ;
    int end = Integer.parseInt(to) ;    
/*	HashMap<String,String> sqlMap = new HashMap<String,String>();
	sqlMap.put("SPECIALITY_ID",speciality_id);
	sqlMap.put("LOCALE",locale);
	sqlMap.put("FACILITY_ID",facility_id);
	sqlMap.put("CLINICIAN_ID",clinician_id);
	sqlMap.put("NOTE_TYPE",note_type);
	sqlMap.put("SEARCH_TEXT",search_text);
	sqlMap.put("SEARCH_BY",search_by);
	sqlMap.put("SEARCH_CRITERIA",search_criteria);
	sqlMap.put("FROM",from);
	sqlMap.put("TO",to);	*/
	
	String code_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	String desc_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
      
  //  boolean searched    = request.getParameter( "searched" ) == null ? false : true  ;	
try{
	ArrayList result = (ArrayList) pracObj.getPractitionerResultPage(request);	
	if (result != null){
		maxRecord = result.get(0)==null?0:Integer.parseInt((String)result.get(0));		
		if(!callFrom.equals("0")){
		if(result.size() > 1 && maxRecord > 0 ) {			
			%>
				<table cellpadding=0 cellspacing=0 width="100%" align="center">
				<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;
			<%
				if (start != 1)
					out.println("<A class='gridLink'  href='../../eCA/jsp/RecClinicalNotesForwardPractResult.jsp?from="+(start-14)+"&to="+(end-14)+"&"+request.getQueryString()+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

				if (maxRecord > 14 )
					out.println("&nbsp;<A class='gridLink'  href='../../eCA/jsp/RecClinicalNotesForwardPractResult.jsp?from="+(start+14)+"&to="+(end+14)+"&"+request.getQueryString()+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			%>
				</td></tr>
				</table>
				<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" id="ResultTab">
					<th><%=code_desc%></th>
					<th><%=desc_desc%></th>	
			<%
				//Retriving the records from result arraylist
				ArrayList records=new ArrayList();
				for(int recCount=1; recCount<result.size(); recCount++) {				
			%>				  
					<tr>
			<%
					records=(ArrayList) result.get( recCount );
					//String retval="";
					//for(int colCount=0; colCount<records.size(); colCount++){												
			%>		
						<td class="gridData"><%=records.get(0)==null?"":records.get(0)%></td>
						<td class="gridData"><a href="#" onclick="javaScript:returnPractitioner('<%=records.get(0)%>','<%=records.get(1)%>');"><%=records.get(1)==null?"":records.get(1)%></a></td>		
					</tr>
			<%
				}
			%>
				</table>			
		<%}else{
			%>
				<script>
						if(!parent.lookup_head.chkBothCriteria )
						{

							if(parent.lookup_head.fromCalledPage)
							{
								parent.lookup_head.chkBothCriteria = true;
								parent.lookup_head.document. CriteriaForm .elements[1].click()
								parent.lookup_head.document. CriteriaForm .Search.click()
							}
							else
							{

								alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
							}
						}
						else
						{
							alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
						}            	                             
			   </script>
			<%
			}     
		}else if(maxRecord == 1){
			java.util.ArrayList records = (java.util.ArrayList) result.get( 1 ); %>
			firstCodeVal = "<%=((String)records.get(0)).trim()%>" ;
			firstDescVal = "<%=((String)records.get(1)).trim()%>" ;
<%		}  
   }else{%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script>
<%   }

} catch(Exception e) {
    //out.print("Exception @ Result JSP :"+e.toString());//COMMON-ICN-0181
	e.printStackTrace();
}
if( !callFrom.equals("0") ) {
%>   
<script>
	parent.lookup_head.document.CriteriaForm.Search.disabled=false;
</script>
</body>
</html>
<%}%>

