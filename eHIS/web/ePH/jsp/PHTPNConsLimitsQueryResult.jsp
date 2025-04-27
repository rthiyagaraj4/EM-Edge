<!DOCTYPE html>
<%-- saved on 26/10/2005 --%>

<!-- 
	This sample function explains how to develop the Query Result Page for Type 2.
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>



<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>




<html>
	<head>
		<title></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			=			(String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/RouteCode.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
//Search Criteria's from Query Criteria page
String regimen_code		= request.getParameter( "TPN_REGIMEN_CODE" ) ;
String age_group		= request.getParameter( "C.AGE_GROUP_CODE" ) ;
String cons_group		= request.getParameter( "B.CONST_GROUP_CODE" ) ;
//String infusion_line	= request.getParameter( "INFUSION_LINE" ) ;



String ord[]				= request.getParameterValues("orderbycolumns");
boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;

	try
	{
	String classvalue			= "";
    regimen_code		= CommonBean.checkForNull( regimen_code );
	age_group		= CommonBean.checkForNull( age_group );
	cons_group		= CommonBean.checkForNull(cons_group);
	//infusion_line	= CommonBean.checkForNull(infusion_line);
	//Common parameters.
	HashMap sqlMap = new HashMap();
	 	
	String sql="SELECT A.TPN_REGIMEN_CODE,A.AGE_GROUP_CODE, B.CONST_GROUP_CODE, C.SHORT_DESC,B.CONST_GENERIC_NAME,A.CONST_QTY_UNIT, A.CONST_MIN_VAL,A.CONST_MAX_VAL,A.CONST_STD_VAL ,A.CONST_CEIL_VAL,DECODE(A.CONST_USAGE_IND,'O','To be Ordered','N','Not to be Ordered',A.CONST_USAGE_IND)  CONST_USAGE_IND,A.CONST_REMARKS ,D.LONG_NAME LONG_NAME FROM	PH_TPN_CONSTITUENT_LIMIT A,AM_AGE_GROUP_LANG_VW C, PH_TPN_CONST_GEN_NAME_LANG_VW B , PH_TPN_REGIMEN_LANG_VW D WHERE A.TPN_REGIMEN_CODE = D.TPN_REGIMEN_CODE AND A.CONST_GENERIC_CODE = B.CONST_GENERIC_CODE AND C.AGE_GROUP_CODE = A.AGE_GROUP_CODE AND B.LANGUAGE_ID = ? AND C.LANGUAGE_ID = ?	AND D.LANGUAGE_ID = ? AND UPPER(B.CONST_GROUP_CODE) LIKE UPPER(?) AND UPPER(A.AGE_GROUP_CODE) LIKE UPPER(?) AND UPPER(A.TPN_REGIMEN_CODE) LIKE UPPER(?)";
	//sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_TPN_CONS_LIMIT_QUERY"));
								   
	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();

    displayFields.add( "LONG_NAME" );
	displayFields.add( "SHORT_DESC" );
	displayFields.add( "CONST_GENERIC_NAME" );
	displayFields.add( "CONST_QTY_UNIT" );
	//displayFields.add( "INFUSION_LINE" );
	displayFields.add( "CONST_MIN_VAL" );
	displayFields.add( "CONST_MAX_VAL" );
	displayFields.add( "CONST_STD_VAL" );
	displayFields.add( "CONST_CEIL_VAL" );
	displayFields.add( "CONST_USAGE_IND" );
	


	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	
    
	
	
	chkFields.add( locale.trim());
	chkFields.add( locale.trim());
	chkFields.add( locale.trim());
	chkFields.add(cons_group.trim()+ "%");
	chkFields.add( age_group.trim() + "%");
	chkFields.add( regimen_code.trim()+ "%");
  
	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	 
  sqlMap.put( "sqlData", sql);
	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request,false);

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<form name="queryResultForm" id="queryResultForm">
		<table cellpadding=0 cellspacing=0 width="100%" align="center">
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		// For display the previous/next link
	     out.println(result.get(1));

	%>
		</td></tr>
		</table>
		<table  border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
		<th style="width:20%"><fmt:message key="ePH.Non-StandardRegimen.label" bundle="${ph_labels}"/></th>
		<th style="width:15%"><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></th>
		<th style="width:12%"><fmt:message key="ePH.ConstituentGeneric.label" bundle="${ph_labels}"/></th>
		<th style="width:8%"><fmt:message key="Common.Unit.label" bundle="${common_labels}"/></th>
	<!-- 	<th style="width:20%">Infusion Line</th> -->
		<th style="width:5%"><fmt:message key="Common.Minimum.label" bundle="${common_labels}"/></th>
		<th style="width:5%"><fmt:message key="Common.maximum.label" bundle="${common_labels}"/></th>
		<th style="width:8%"><fmt:message key="Common.Standard.label" bundle="${common_labels}"/></th>
		<th style="width:7%"><fmt:message key="ePH.Ceil.label" bundle="${ph_labels}"/></th>
		<th style="width:8%"><fmt:message key="ePH.UsageIndicator.label" bundle="${ph_labels}"/></th> 
		
		<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYODD" ;
			else
				classvalue = "QRYEVEN" ;
	%>
			<tr  >
	<%
			records=(ArrayList) result.get( recCount );
	
			for(int colCount=0; colCount<records.size(); colCount++){
					String dkVal = (String)records.get( colCount );
					if (colCount>2)
					{	
						out.println("	<td class="+classvalue+" align='right'>"); 	
					}
					else
					{
						out.println("	<td class="+classvalue+" align='left'>"); 	
					}
					if(dkVal==null)
						dkVal="";
					 out.println(dkVal); 
					out.println("</td>"); 
				

				}//end of col count

				}//end of record count
	%>
			</tr>
	<%
		out.flush();
	}
	 else{
	%>
 <script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script> 
	<%
	}
%>
		</table>
	</form>
<%
	//it is important to close the form above cause we are opening another form here
out.println(CommonBean.setForm ( request ,"../../ePH/jsp/PHTPNConsLimitsQueryResult.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>

<%!
public String getImage(String value){
	if(value.equalsIgnoreCase("E"))
		return "<img src=\"../../eCommon/images/enabled.gif\">";
	else 
		return "<img src=\"../../eCommon/images/disabled.gif\">";
		

}
%>

</body>
</html>




