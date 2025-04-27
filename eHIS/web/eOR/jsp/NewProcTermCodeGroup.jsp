<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page import="java.util.*, eCommon.Common.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=ISO-8859-1"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="TerminologyLookup" scope="session" class="webbeans.eCommon.RecordSet" />
<html>
<head>
<title></title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script>
 --><script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="Javascript" src="../../eOR/js/NewProcedureTermCode.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

function callLink(obj){
	
	var term_code="";
	var code_level="";
	var search_criteria="S";
	var multiple_yn="Y";
	var search_by="";
	var temp_term_code="";
	var term_code_associated="";
	var Db_term_code="";
	var qryStr =  document.getElementById("qryStr").value;
	var term_grp_id=obj.cells[0].innerText;
    var term_grp_desc=obj.cells[1].innerText;
    var term_set_id=obj.cells[0].children(1).value;
    //var term_set_id="ICD10";
	//obj.cells[2].children(0).checked = true ;
	
	if(qryStr.indexOf("term_set_id=")!=-1)
		qryStr = qryStr.replace("term_set_id=","");
	
	//parent.lookup_detail.location.href = "../../eOR/jsp/NewProcTermCodeQueryResult.jsp?term_set_id="+term_set_id+"&term_code="+term_code+"&code_level="+code_level+"&sc="+search_criteria+"&multiple_yn="+multiple_yn+"&search_by="+search_by+"&temp_term_code="+temp_term_code+"&term_code_associated="+term_code_associated+"&Db_term_code="+Db_term_code;
	//parent.lookup_detail.location.href = "../../eOR/jsp/NewProcTermCodeQueryResult.jsp?term_set_id="+term_set_id+"&term_code="+term_code+"&code_level="+code_level+"&sc="+search_criteria+"&multiple_yn="+multiple_yn+"&search_by="+search_by+"&temp_term_code="+temp_term_code+"&term_code_associated="+term_code_associated+"&Db_term_code="+Db_term_code+"&term_grp_id="+term_grp_id;
	parent.lookup_detail.location.href = "../../eOR/jsp/NewProcTermCodeQueryResult.jsp?"+qryStr+"&term_set_id="+term_set_id+"&term_grp_id="+term_grp_id+"&radioval=G&sc=S&multiple_yn=N";
	
	
}
</script>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%

String searchCriteria  = CommonBean.checkForNull( request.getParameter( "sc" ) ) ;
String term_set_id	   = CommonBean.checkForNull( request.getParameter( "term_set_id" ) ) ;
String term_code	   = CommonBean.checkForNull( request.getParameter( "term_code" ) ) ;
String search_by	   = CommonBean.checkForNull( request.getParameter( "search_by" ) ) ;
//  String search_text	   = CommonBean.checkForNull( request.getParameter( "search_text" ) ) ;
//  String term_code_desc  = CommonBean.checkForNull( request.getParameter( "term_code" ) ) ;
String code_level	   = CommonBean.checkForNull( request.getParameter( "code_level" ) ) ;
String temp_term_code  = CommonBean.checkForNull( request.getParameter( "temp_term_code" ) ) ;
String term_code_associated  = CommonBean.checkForNull( request.getParameter( "term_code_associated" ) ) ;
String Db_term_code  = CommonBean.checkForNull( request.getParameter( "Db_term_code" ) ) ;
StringBuffer sqlData	= new StringBuffer("");
sqlData.append("SELECT TERM_SET_ID,TERM_GROUP_ID,TERM_GROUP_DESC FROM MR_TERM_GROUP_HDR WHERE  EFF_STATUS = 'E' AND TERM_SET_ID LIKE NVL(?,TERM_SET_ID) AND TERM_GROUP_APPLICABLITY ='P' ORDER BY 1,2");

boolean searched	   = request.getParameter( "searched" ) == null ? false : true  ;

ArrayList Terminology		=	(ArrayList)TerminologyLookup.getRecordSetHandle();
HashMap Termcode= new HashMap();
String chk_val = "",tmp_grpid="",tmp_setid="";
//TerminologyLookup.clearAll();
if(Terminology.size()>0)
{
	//Termcode=(HashMap)Terminology.get(0);
	Terminology = (ArrayList)TerminologyLookup.getObject(0);
	Termcode = (HashMap)Terminology.get(0);
	//out.println("--Termcode--"+Termcode.size()+"====");
}
try{
	String classvalue			= "";
	String checked				= "";
	String disabled				= "";


	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", sqlData.toString());

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	
	displayFields.add( "TERM_GROUP_ID" );
	displayFields.add( "TERM_GROUP_DESC" );
	displayFields.add( "TERM_SET_ID" );

	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	chkFields.add(term_set_id.trim());
	
	//Adding function related array list into the HashMap
    funcMap.put( "displayFields", displayFields );
    funcMap.put( "chkFields", chkFields );
    funcMap.put( "searchCriteria", searchCriteria );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
	if ( sqlMap != null ) sqlMap.clear();
	if ( funcMap != null ) funcMap.clear();
	if ( chkFields != null ) chkFields.clear();
	if ( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
	<input type="hidden" name="qryStr" id="qryStr" value="<%=request.getQueryString()%>">	
	
		<table cellpadding=1 cellspacing=0 width="100%" align="center">
		<tr onclick="retainGrpChk()">
			<td width="80%" class="white">&nbsp;</td>
			<td width="20%" class="white">&nbsp;
	<%//For display the previous/next link
		 out.println(result.get(1));
	%>		</td>
		</tr>
		</table>

		<table border="2" cellpadding="0" cellspacing="0" width="100%" align="center" id='grp_tbl'>
		
		<th width='35%'><font size='1'>Term Group ID</font></th>
		<th width='55%'><font size='1'>Term Group Description</font></th>
		<th width='10%'><font size='1'>Select</font></th>
		<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		String link_columns = "1";
		String tmp_hdr = "";
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
			else
				 classvalue = "QRYODD" ;
			records=(ArrayList) result.get( recCount );
			
			tmp_grpid=(String)records.get( 0 );
			tmp_setid=(String)records.get( 2 );
			/*Set itr_set			=	Termcode.keySet();
			Iterator recordItr	=	itr_set.iterator();
			while(recordItr.hasNext() && recCount==2)
			{	
				String grpid=(String)recordItr.next();
				//out.println("==keys =="+grpid);
			}*/
			
			if(Termcode.containsKey(tmp_setid+tmp_grpid)){
				chk_val = (String)Termcode.get(tmp_setid+tmp_grpid);
				//out.println("==in=="+(String)Termcode.get(tmp_setid+tmp_grpid));
				
			if(chk_val != null && chk_val.equals("Y"))
				checked = "checked";
			else
				checked = "";
			}else
				checked = "";

			if(!tmp_hdr.equals((String)records.get( 2 ))){
		%>
			<tr>
				<td colspan='4' class='CAHIGHER'><%=(String)records.get( 2 )%> </td>
			</tr>
		<%  tmp_hdr = (String)records.get( 2 );
			}
		%>

		<tr onClick="callLink(this);" >
			
		<%
			
			for (int colCount=0; colCount<records.size(); colCount++)
			{
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){%>
					<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font size='1' class='HYPERLINK'><%=(String)records.get( colCount )%></font><input type='hidden' value='<%=tmp_hdr%>'></td>
		<%		}else if( colCount == 1){ %>
					<td class="<%=classvalue%>"  onclick="disableClick(event);"><font size='1'><%=(String)records.get( colCount )%></font></td>
		<%		}%>
					
		<%	}/* End of For column Count */
			if ( records != null ) records.clear();
		%>			<td class="<%=classvalue%>" align='center' onclick="disableClick(event);"><input type="checkbox" name="term_grp<%=recCount%>" id="term_grp<%=recCount%>" <%=checked%> <%=disabled%>></td> 	
		</tr>
		<%
		}/* End of For record Count */%>
			
		</table>
		<%
		out.flush();
	}else{%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script> 
	<%}
		
	out.println(CommonBean.setForm(request ,"NewProcTermCodeGroup.jsp", searched));
	if ( displayFields != null ) displayFields.clear();
	if ( result != null ) result.clear();
}
catch(Exception e) {
	//out.print("Exception @ Result JSP :"+e.toString());//COMMON-ICN-0181
	e.printStackTrace();
}	
%>
</body>
</html>

