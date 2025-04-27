<!DOCTYPE html>
 <!--
Fine Tuning
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper " %>
<%-- JSP Page specific attributes end --%>
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
	     String locale			    = (String)session.getAttribute("LOCALE");
	
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/DiscontinueDrug.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	//Search Criteria's from Query Criteria page
	String drug_code	= request.getParameter( "drug_code" );
	String drug_desc	= request.getParameter( "drug_desc" ) ;
	String generic_name	= request.getParameter( "generic_name" ) ;
	String form_desc   	= request.getParameter( "form_desc" ) ;
	String compound_drug_yn 	= request.getParameter( "compound_drug_yn" ) ;

	boolean searched	= request.getParameter( "searched" ) == null ? false : true  ;

try{
	String classvalue			= "";

	drug_code			= CommonBean.checkForNull( drug_code.trim() );
	drug_desc			= CommonBean.checkForNull( drug_desc.trim() );
	generic_name		= CommonBean.checkForNull( generic_name.trim() );
	form_desc			= CommonBean.checkForNull( form_desc.trim() );
	compound_drug_yn	= CommonBean.checkForNull( compound_drug_yn.trim() );


	if (compound_drug_yn.equals("B"))
	{
			compound_drug_yn="";
	}

	//Common parameters.
	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_DISC_DRUG_SELECT2"));

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields that are going to be display
	ArrayList displayFields = new ArrayList();

	displayFields.add( "drug_code" );
	displayFields.add( "drug_desc" );
	displayFields.add( "generic_name");
	displayFields.add( "strength_value" );
	displayFields.add( "form_desc" );
//	displayFields.add( "pres_base_desc" );
	displayFields.add( "pres_base_desc" );
	displayFields.add( "compound_drug_yn" );

	//displayFields.add( "compound_drug_yn" );
	ArrayList chkFields = new ArrayList();
	chkFields.add( drug_code.trim() + "%" );
	chkFields.add( drug_desc.trim() + "%" );
	chkFields.add( generic_name.trim() + "%" );
	chkFields.add( form_desc.trim() + "%" );
	chkFields.add( compound_drug_yn.trim() + "%" );
	chkFields.add( compound_drug_yn.trim() + "%" );

	// Adding function related array list into the HashMap
	funcMap.put("displayFields", displayFields );
	funcMap.put("chkFields", chkFields );

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
		<th ><fmt:message key="Common.DrugCode.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th>
		<th><fmt:message  key="Common.GenericName.label" bundle="${common_labels}"/></th>
		<th><fmt:message  key="Common.Strength.label" bundle="${common_labels}"/></th>
		<th><fmt:message  key="ePH.FormofDrug.label" bundle="${ph_labels}"/></th>
		<th><fmt:message  key="ePH.BaseUnit.label"   bundle="${ph_labels}"/></th>
		<th ><fmt:message key="ePH.Compound.label"   bundle="${ph_labels}"/></th>

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
					if(dkVal == null)	dkVal = "&nbsp" ;
					if(dkVal.equals("")) dkVal = "&nbsp;";

					if((colCount==6)){
						out.println("align=\"center\">");
						out.println(getImage(dkVal));
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
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA"));history.go(-1);</script>
	<%
	}
out.println(CommonBean.setForm ( request ,"../../ePH/jsp/DiscontinueDrugQueryResult.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>
<%!
public String getImage(String value){
	if( (value.equalsIgnoreCase("E"))|| (value.equalsIgnoreCase("Y")) )
		return "<img src=\"../../eCommon/images/enabled.gif\"><input type='hidden' value='E'>";
	else
		return "<img src=\"../../eCommon/images/disabled.gif\"><input type='hidden' value='D'>";
}
%>
</body>
</html>

