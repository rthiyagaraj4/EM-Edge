<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, ePH.Common.*, ePH.* " %>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>

<head>
		<title></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%

	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/ReconstituentFluid.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	//Search Criteria's from Query Criteria page
	String Rf_Id		= request.getParameter( "RF_ID" );
	String Rf_Name		= request.getParameter( "RF_NAME" ) ;


	String ord[]			= request.getParameterValues("orderbycolumns");
	boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;

try{
	String classvalue			= "";

	Rf_Id = CommonBean.checkForNull( Rf_Id );
	Rf_Name = CommonBean.checkForNull( Rf_Name );

	//Common parameters.
	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_RECONSTITUENT_FLUID_SELECT2"));
		//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields that are going to be display
	ArrayList displayFields = new ArrayList();

	displayFields.add( "Rf_Id" );
	displayFields.add( "Rf_Name" );

	ArrayList chkFields = new ArrayList();
	chkFields.add( Rf_Name.trim() + "%" );
	chkFields.add( Rf_Id.trim() + "%" );
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
		<th  style="width:15%"><fmt:message key="ePH.FluidID.label" bundle="${ph_labels}"/></th><th style="width:50%"><fmt:message key="Common.FluidName.label" bundle="${common_labels}"/></th>
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

					if((colCount==3)){
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
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
	<%
	}
	out.println(CommonBean.setForm ( request ,"../../ePH/jsp/ReconstituentFluidQueryResult.jsp", searched) );
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
%>
</body>
</html>

