<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"import="java.util.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");
	
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/DispenseRules.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	//Search Criteria's from Query Criteria page
	String drug_catg_code	= request.getParameter( "drug_catg_code" ) ;
	String drug_catg_desc	= request.getParameter( "drug_catg_desc" ) ;
	String patient_class	= request.getParameter( "patient_class" ) ;
	String disp_group_code  = request.getParameter( "disp_group_code" ) ;
	String disp_group_desc  = request.getParameter( "disp_group_desc" ) ;
	String action			= request.getParameter( "action_abbr" ) ;

	if(action ==null ) action="";
	else if(action .equals("B") || action .equals("S") ) action="";

	String ord[]			= request.getParameterValues("orderbycolumns");
	boolean searched		= request.getParameter( "searched" ) == null ? false : true  ;


try{
	String classvalue			= "";
	if (drug_catg_code==null)   drug_catg_code="";
	if (drug_catg_desc==null)   drug_catg_desc="";
	if (patient_class==null)	patient_class="";
	if (disp_group_code==null)  disp_group_code="";
	if (disp_group_desc==null)	disp_group_desc="";
	if (action==null)			action="";

	disp_group_code = CommonBean.checkForNull( disp_group_code.trim() );
	drug_catg_desc  = CommonBean.checkForNull( drug_catg_desc.trim() );
	patient_class	= CommonBean.checkForNull( patient_class.trim() );
	disp_group_code = CommonBean.checkForNull( disp_group_code.trim() );
	disp_group_desc = CommonBean.checkForNull( disp_group_desc.trim() );
	action		    = CommonBean.checkForNull( action.trim() );

	//Common parameters.
	HashMap sqlMap = new HashMap();
	//include all the common parameters.
	sqlMap.put( "sqlData", PhRepository.getPhKeyValue("SQL_PH_DISP_RULE_SELECT4"));

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();


	displayFields.add( "DRUG_CATG_CODE" );
	displayFields.add( "DRUG_CATG_DESC" );
	displayFields.add( "PATIENT_CLASS" );
	displayFields.add( "STAT_GROUP_ID" );
	displayFields.add( "STAT_GRP_DESC" );
	displayFields.add( "ACTION" );

	ArrayList chkFields = new ArrayList();
	chkFields.add( drug_catg_code.trim() + "%" );
	chkFields.add( drug_catg_desc.trim() + "%" );
	chkFields.add( patient_class.trim() + "%" );
	chkFields.add( disp_group_code.trim() + "%" );
	chkFields.add( disp_group_desc.trim() + "%" );
	chkFields.add( action.trim() + "%" );
	chkFields.add(locale);
	chkFields.add(locale);

	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
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
		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
		<th><fmt:message key="ePH.DrugCategoryCode.label" bundle="${ph_labels}"/></th><th><fmt:message key="ePH.DrugCategoryDescription.label" bundle="${ph_labels}"/></th><th><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></th><th><fmt:message key="ePH.DispesningGroupCode.label" bundle="${ph_labels}"/></th><th><fmt:message key="ePH.DispensingGroupDesc.label" bundle="${ph_labels}"/></th><th><fmt:message key="Common.action.label" bundle="${common_labels}"/></th>
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

			String link_columns = "1";
			records=(ArrayList) result.get( recCount );
			for(int colCount=0; colCount<records.size(); colCount++){
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
	%>
			<td class="<%=classvalue%>" ><font class='HYPERLINK' onmouseover="changeCursor(this);">  <%=(String)records.get( colCount )%>    </font></td>
	<%
				}else if (colCount!=5)
				{
				String fieldValue=((String)records.get( colCount ));
					if (fieldValue==null) fieldValue = "";
					if (fieldValue.equals("*A")){
						fieldValue="*All";
					}

					String dkVal =fieldValue ;
					if(dkVal == null)	dkVal = "&nbsp" ;
					if(dkVal.equals("")) dkVal = "&nbsp;";
	%>

	<td class="<%=classvalue%>" onclick="disableClick(event); "><%=dkVal%></td>
	<%
				} 
				else if (colCount==5){
					%>
				<td class="<%=classvalue%>" onclick="disableClick(event);" >
				<% 
				out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH."+(String)records.get( colCount)+".label","ph_labels")); 

				out.println("</td>"); 
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
	out.println(CommonBean.setForm ( request ,"../../ePH/jsp/DispenseRulesQueryResult.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>
</body>
</html>


