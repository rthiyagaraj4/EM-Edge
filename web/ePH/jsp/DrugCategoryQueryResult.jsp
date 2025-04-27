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
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/DrugCategory.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	//Search Criteria's from Query Criteria page
	String drug_catg_code	= request.getParameter( "drug_catg_code" );
	String long_desc		= request.getParameter( "long_desc" ) ;
	//String short_desc		= request.getParameter( "short_desc" ) ;
	String pin_auth_reqd_yn		= request.getParameter( "pin_auth_reqd_yn" ) ;
	String eff_status     	= request.getParameter( "eff_status" ) ;
	String ord[]			= request.getParameterValues("orderbycolumns");
	boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;

try{
	String classvalue			= "";

	drug_catg_code = CommonBean.checkForNull( drug_catg_code.trim() );
	long_desc = CommonBean.checkForNull( long_desc.trim() );
	eff_status = CommonBean.checkForNull( eff_status.trim() );

	if (eff_status.equals("B"))
	{
		//out.println("if condition in eff status");
		eff_status="";
	}
	if (pin_auth_reqd_yn.equals("B"))
	{
		//out.println("if condition in eff status");
		pin_auth_reqd_yn="";
	}

	//Common parameters.
	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", "SELECT A.DRUG_CATG_CODE, A.LONG_DESC, A.SHORT_DESC,A.PIN_AUTH_REQD_YN,A.EFF_STATUS FROM PH_DRUG_CATG_LANG_VW A WHERE UPPER(DRUG_CATG_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(EFF_STATUS) LIKE UPPER(?) AND UPPER(PIN_AUTH_REQD_YN) LIKE UPPER(?) AND A.LANGUAGE_ID = ?");


	//sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_DRUG_CATG_SELECT1"));

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields that are going to be display
	ArrayList displayFields = new ArrayList();

	displayFields.add( "drug_catg_code" );
	displayFields.add( "long_desc" );
	displayFields.add( "short_desc" );
	displayFields.add( "pin_auth_reqd_yn" );
	displayFields.add( "eff_status" );

	ArrayList chkFields = new ArrayList();
	chkFields.add( drug_catg_code.trim() + "%" );
	chkFields.add( long_desc.trim() + "%" );
	chkFields.add( eff_status.trim() + "%" );
	chkFields.add( pin_auth_reqd_yn.trim() + "%" );
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
		<th  style="width:15%"><fmt:message key="ePH.DrugCategoryCode.label" bundle="${ph_labels}"/></th>
		<th style="width:50%"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
		<th style="width:25%"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		<th style="width:10%"><fmt:message key="ePH.AuthenticationforMARRequired?.label" bundle="${ph_labels}"/></th>
		<th style="width:10%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
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
	%>
					<td class="<%=classvalue%>" onclick="disableClick(event);"  value="<%=(String)records.get( colCount )%>"
	<%

				String dkVal = (String)records.get( colCount );
				//out.println("dkVal---->" +dkVal);
					if(dkVal == null)	dkVal = "&nbsp" ;
					if(dkVal.equals("")) dkVal = "&nbsp;";

					if((colCount==3)){
 						out.println("align=\"center\">");
						out.println(getImage2(dkVal));
						out.println("</td>");
					}
					else if((colCount==4)){
 						out.println("align=\"center\">");
						out.println(getImage(dkVal));
						out.println("</td>");
					}
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
	out.println(CommonBean.setForm ( request ,"../../ePH/jsp/DrugCategoryQueryResult.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>
<%!
public String getImage(String value){
	if(value.equalsIgnoreCase("E"))
		return "<img src=\"../../eCommon/images/enabled.gif\"><input type='hidden' value='E'>";
	else
		return "<img src=\"../../eCommon/images/disabled.gif\"><input type='hidden' value='D'>";
}
public String getImage2(String value){
	if(value.equalsIgnoreCase("Y"))
		return "<img src=\"../../eCommon/images/enabled.gif\"><input type='hidden' value='Y'>";
	else
		return "<img src=\"../../eCommon/images/disabled.gif\"><input type='hidden' value='N'>";
}
%>
</body>
</html>

