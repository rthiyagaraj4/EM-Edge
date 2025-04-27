<!DOCTYPE html>
 <!--
Fine Tuning
-->

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>

<html>
<head>
	<title></title>
<%
	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale			= (String)session.getAttribute("LOCALE");
	
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="Javascript" src="../../eCommon/js/common.js"></script>

	<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
	<SCRIPT LANGUAGE="JavaScript" SRC="../js/DrugDetailsDisplay.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../js/DiscontinueDrug.js"></SCRIPT>
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
//Search Criteria's from Query Criteria page
/////////////////////////////////////////////////////////////////
String drug_code			= "" ;

String ord[]				= request.getParameterValues("orderbycolumns");
boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;


	String classvalue			= "";
	String bean_id				= "DrugDetailsBean" ;
	String bean_name			= "ePH.DrugDetailsBean";

DrugDetailsBean bean = (DrugDetailsBean)getBeanObject( bean_id, bean_name, request ) ;
bean.setLanguageId(locale);
try{
	drug_code = CommonBean.checkForNull( bean.getDRUG_CODE() );

	//Common parameters.
	HashMap sqlMap = new HashMap();

	sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_DRUG_DETAILS_SELECT2"));
	//sqlMap.put( "sqlData","SELECT A.GENERIC_ID,B.GENERIC_NAME, A.DISPLAY_SEQ_NO FROM PH_GENERIC_NAME_FOR_DRUG A, PH_GENERIC_NAME B WHERE A.GENERIC_ID=B.GENERIC_ID AND A.DRUG_CODE = 'FEN001' ORDER BY 3");

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add( "GENERIC_ID" );
	displayFields.add( "GENERIC_NAME" );
	displayFields.add( "DISPLAY_SEQ_NO" );

	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	chkFields.add( drug_code+"" );
	chkFields.add(locale);

	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
	//out.println("drug code="+drug_code);

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

		<table  border="1" cellpadding="0" cellspacing="0" width="90%" align="center">
		<th width="25%"><fmt:message key="ePH.GenericID.label" bundle="${ph_labels}"/></th>
		<th width="50%"><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></th>
		<th width="25%"><fmt:message key="ePH.DisplaySequenceNo.label" bundle="${ph_labels}"/></th>


		<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYODD" ;
			else
				classvalue = "QRYEVEN" ;
	%>
			<tr onClick="Modify(this);" >
	<%

			String link_columns = "";

			records=(ArrayList) result.get( recCount );
			for(int colCount=0; colCount<records.size(); colCount++){
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
	%>
			<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'>  <%=(String)records.get( colCount )%>    </font></td>
	<%
				}else{


	%>
					<td class="<%=classvalue%>" onclick="disableClick(event);"  value="<%=(String)records.get( colCount )%>"

	<%
				String dkVal = (String)records.get( colCount );
					if(dkVal == null)	dkVal = "&nbsp" ;
					if(dkVal.equals("")) dkVal = "&nbsp;";

					if((colCount==2)){
						out.println("align=\"right\">");
						out.println(dkVal);
						out.println("</td>");
					}//if
					else
					{
						out.println("align=\"left\">");
						out.println(dkVal);
						out.println("</td>");
					}
					dkVal = "";
					}

				}
	%>
			</tr>
	<%
		}
	%>
		</table>
	<%
		out.flush();
	} else{
	%>
 <script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
	<%
	}
%>
	</form>
<%
	//it is important to close the form above cause we are opening another form here
out.println(CommonBean.setForm ( request ,"../../ePH/jsp/DrugDetailsGeneric.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>
</body>
</html>



<%
putObjectInBean(bean_id,bean,request);
%>

