<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
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
	  
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css"; 
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/DrugCategoryRuleByPatcl.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	//Search Criteria's from Query Criteria page
	String drug_catg_desc	= request.getParameter( "drug_catg_desc" ) ;
	String patient_class	= request.getParameter( "PATIENT_CLASS" ) ;
	String max_durn_value   = request.getParameter( "max_durn_value" ) ;
	String max_durn_type	= request.getParameter( "max_durn_type" ) ;
	String action			= request.getParameter( "action_abbr" ) ;
	String ord_auth_level   = request.getParameter( "ord_auth_level" ) ;

	//String ord[]			= request.getParameterValues("orderbycolumns");
	boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;

	if (action.equals("S"))
		action = "";

try{
	String classvalue	= "";
	if (patient_class==null)
		patient_class="";
	if (drug_catg_desc==null)
		drug_catg_desc="";
	if (max_durn_value==null)
		max_durn_value="";
	if (max_durn_type==null)
		max_durn_type="";
	if (action==null)
		action="";
	if (ord_auth_level==null)
		ord_auth_level="";

	drug_catg_desc = CommonBean.checkForNull( drug_catg_desc.trim() );
	patient_class  = CommonBean.checkForNull( patient_class.trim() );
	max_durn_value = CommonBean.checkForNull( max_durn_value.trim() );
	max_durn_type  = CommonBean.checkForNull( max_durn_type.trim() );
	action		   = CommonBean.checkForNull( action.trim() );
	ord_auth_level = CommonBean.checkForNull( ord_auth_level.trim() ) ;

	//Common parameters.
	HashMap sqlMap = new HashMap();
	//include all the common parameters.
	sqlMap.put( "sqlData", PhRepository.getPhKeyValue("SQL_PH_RULE_BY_PATCL_SELECT3"));
	
	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();

	displayFields.add( "DRUG_CATG_CODE" );
	displayFields.add( "DRUG_CATG_DESC" );
	displayFields.add( "PATIENT_CLASS" );
	displayFields.add( "PATIENT_CLASS_DESC" );
	displayFields.add( "MAX_DURN_VALUE" );
	displayFields.add( "MAX_DURN_TYPE_ABBR" );
	displayFields.add( "ACTION_LEVEL_ABBR" );
	//displayFields.add( "ORD_AUTH_LEVEL" );
	ArrayList chkFields = new ArrayList();
	chkFields.add( drug_catg_desc.trim() + "%" );
	chkFields.add( patient_class.trim() + "%" );
	chkFields.add( max_durn_value.trim() + "%" );
	chkFields.add( max_durn_type.trim() + "%" );
	chkFields.add( action.trim() + "%" );
	chkFields.add( ord_auth_level.trim() + "%" );
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
		<th><fmt:message key="ePH.DrugCategoryCode.label" bundle="${ph_labels}"/></th><th><fmt:message key="ePH.DrugCategoryDescription.label" bundle="${ph_labels}"/></th><th><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.PatientClassDescription.label" bundle="${common_labels}"/></th><th><fmt:message key="ePH.MaxDurnValue.label" bundle="${ph_labels}"/></th><th><fmt:message key="ePH.MaxDurnType.label" bundle="${ph_labels}"/></th><th><fmt:message key="Common.action.label" bundle="${common_labels}"/></th><!-- <th>Order Authorization Level</th> -->
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
				}else{		
					String fieldValue=((String)records.get( colCount ));
					if (fieldValue==null) fieldValue = "";
					if (fieldValue.equals("*A")){
						fieldValue="*All";
					}	
					String dkVal =fieldValue ;
					if(dkVal == null)	dkVal = "&nbsp" ;
					if(dkVal.equals("")) dkVal = "&nbsp;";				
	%>
	<td class="<%=classvalue%>" onclick="disableClick(event); " > <%=dkVal%></td>
	<%
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
	out.println(CommonBean.setForm ( request ,"../../ePH/jsp/DrugCategoryRuleByPatclQueryResult.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>
</body>
</html>

	

