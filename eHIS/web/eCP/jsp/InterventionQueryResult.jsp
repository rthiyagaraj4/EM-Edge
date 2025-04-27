<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCP.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<html>
<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
function Modify(obj)
{
var intervention_code	= obj.cells[0].innerText;
document.location.href="../../eCP/jsp/InterventionAddModify.jsp?mode=2&intervention_code="+intervention_code;
}
</script>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
try
{
String classvalue = "";
/*----- Required while Selecting sql and Formatting display------*/
String enableGif ="<div align='center'><img align='center' src='../../eCommon/images/enabled.gif'></img></div>" ;
String disableGif ="<div align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>" ;


	  String intervention_code		= request.getParameter("intervention_code");
	  String intervention_desc		= request.getParameter("intervention_description");
	  String intervention_type		= request.getParameter("intervention_type");
	  String dependency				= request.getParameter("dependency");
	  String result_type			= request.getParameter("result_type");
	  String system_defined_yn		= request.getParameter("system_defined_yn")==null? "N":request.getParameter("system_defined_yn");
	  String enabled				= request.getParameter("eff_status");
	
	  boolean searched				= request.getParameter( "searched" ) == null? false : true  ;	

	if(intervention_code == null || intervention_code.equals("null")) intervention_code=" "; else intervention_code = intervention_code.trim();
	if(intervention_desc == null || intervention_desc.equals("null")) intervention_desc =" "; else intervention_desc = intervention_desc.trim();
	if(intervention_type == null || intervention_type.equals("null")) intervention_type =" "; else intervention_type = intervention_type.trim();
	if(dependency == null || dependency.equals("null")) dependency =""; else dependency = dependency.trim();
	if(result_type == null || result_type.equals("null")) result_type =""; else result_type = result_type.trim();
	if(enabled == null || enabled.equals("null")) enabled =""; else enabled = enabled.trim();
	String resultTypeSelection="";
	if(result_type.equals("%") || result_type.equals(""))
		resultTypeSelection="UPPER(a.result_type) IS NULL OR UPPER(a.result_type) LIKE NVL(UPPER(?),'%')";
	else
		resultTypeSelection="UPPER(a.result_type) LIKE NVL(UPPER(?),'%')";
	HashMap sqlMap = new HashMap();
		
//	String sql_intervention="select a.intervention_code ,a.short_desc,a.eff_status,a.appl_dependency_level,a.long_desc,a.intervention_type,a.result_type,a.result_id,a.intervention_durn,a.lmt_for_tsk_due_bf_st_tm,a.lmt_for_tsk_due_bf_st_tm_unit,a.lmt_for_tsk_odue_af_st_tm,a.lmt_for_tsk_odue_af_st_tm_unit,a.lmt_for_tsk_exp_af_end_tm,a.lmt_for_tsk_exp_af_end_tm_unit,a.intervention_guideline,a.bkdate_lmt_for_tsk_result,a.bkdate_lmt_for_tsk_result_unit,a.use_as_adhoc_intervention_yn,a.intervention_durn_unit,b.short_desc intervention_desc,c.result_type_desc from ca_intervention a,ca_intervention_type b,ca_result_type c where upper(a.intervention_code) like upper(?) and upper(a.short_desc) like upper(?) and upper(a.intervention_type) like upper(?) and (a.appl_dependency_level is null or a.appl_dependency_level like nvl(?,'%')) and ( upper(a.result_type) is null or upper(a.result_type) like nvl(upper(?),'%')) and upper(a.eff_status) like upper(?) and a.result_type = c.result_type(+) and b.intervention_type = a.intervention_type";

    String sql_intervention="SELECT a.intervention_code ,a.short_desc,a.eff_status,a.appl_dependency_level,a.long_desc,a.intervention_type,a.result_type,a.result_id,a.intervention_durn,a.lmt_for_tsk_due_bf_st_tm,a.lmt_for_tsk_due_bf_st_tm_unit,a.lmt_for_tsk_odue_af_st_tm,a.lmt_for_tsk_odue_af_st_tm_unit,a.lmt_for_tsk_exp_af_end_tm,a.lmt_for_tsk_exp_af_end_tm_unit,a.intervention_guideline,a.bkdate_lmt_for_tsk_result,a.bkdate_lmt_for_tsk_result_unit,a.use_as_adhoc_intervention_yn,a.intervention_durn_unit,b.short_desc intervention_desc,c.result_type_desc FROM ca_intervention_lang_vw a,ca_intervention_type_lang_vw b,ca_result_type_lang_vw c WHERE UPPER(a.intervention_code) LIKE UPPER(?) AND UPPER(a.short_desc) LIKE UPPER(?) AND UPPER(b.system_defined_yn) LIKE UPPER(?) AND UPPER(a.intervention_type) LIKE UPPER(?) AND (a.appl_dependency_level IS NULL OR a.appl_dependency_level LIKE NVL(?,'%')) AND ( "+resultTypeSelection+") AND UPPER(a.eff_status) LIKE UPPER(?) AND a.result_type = c.result_type(+) AND b.intervention_type = a.intervention_type AND a.language_id = ? AND b.language_id = a.language_id AND c.language_id(+) = a.language_id";
		
    sqlMap.put( "sqlData",sql_intervention);
	
	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	
	displayFields.add("intervention_code");
	displayFields.add("short_desc");
	displayFields.add("intervention_desc");
	displayFields.add("appl_dependency_level");
	displayFields.add("result_type_desc");
	displayFields.add("eff_status");
	
	//The fields are going to be in where condition * shld match with the qry//
	ArrayList chkFields = new ArrayList();

	chkFields.add(intervention_code+"%");
	chkFields.add(intervention_desc+"%");
	chkFields.add(system_defined_yn+"%");
	chkFields.add(intervention_type+"%");
	chkFields.add(dependency+"%");
	chkFields.add(result_type+"%");
	chkFields.add(enabled+"%");
	chkFields.add(locale);

	// Adding function related array list into the HashMap//
	HashMap funcMap = new HashMap();
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.//
	ArrayList result=new ArrayList();
	result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);
		
	if((result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){
%>
<table cellpadding=0 cellspacing=0 width="100%" align="center">
<tr>
	<td width="80%" class="white">&nbsp;</td>
	<td width="20%" class="white">&nbsp;
<%
	// For display the previous/next link
     out.println(result.get(1));
%>
	</td>
</tr>
</table>

<table cellpadding=0 cellspacing=0 border=1 width="100%" align=center>
<tr>
	<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.InterventionType.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="eCP.DepLvl.label" bundle="${cp_labels}"/></th>
	<th><fmt:message key="Common.ResultType.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
</tr>
	<%
	//Retriving the records from result arraylist

		String link_columns = "1";
		ArrayList records=new ArrayList();
		
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
			records=(ArrayList) result.get( recCount );
   	%>				
		<tr onClick="Modify(this);">   
		<%
			String str="";
		for(int colCount=0; colCount<6; colCount++){
			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
		%>
		<td class="<%=classvalue%>" onmouseover="changeCursor(this);"> 	<font class='HYPERLINK'><%=(String)records.get(colCount)%></font></td>
 		<%} else {
			if(colCount == 1)
				str=(String)records.get(colCount)==null?"":(String)records.get(colCount);

 			if(colCount == 2)
			  str = (String)records.get(colCount)==null?"":(String)records.get(colCount);

			if(colCount == 3)
				str=(String)records.get(colCount)==null?"":(String)records.get(colCount);

			if(colCount == 4)
				str=(String)records.get(colCount)==null?"":(String)records.get(colCount);

			if(colCount == 5)	
			{
				String eff=(String)records.get(colCount);
			     if(eff.equals("E"))
					 str=enableGif;
				  else
					 str=disableGif;		
			}

 			if(str.equals("")){   		
		 %>
		 <td class="<%=classvalue%>">&nbsp;</td>
		<%}else{%>
			<td class="<%=classvalue%>"><%=str%></td>
		<%}}//end of for loop
		}
		%>
</tr>
<%}//Loop for all records%>
</table>
	<%
	out.flush();
	}else{%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
	<%
		}
			out.println(CommonBean.setForm(request ,"../../eCP/jsp/InterventionQueryResult.jsp", searched));
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} 
	%>
</body>
</html>  
	

