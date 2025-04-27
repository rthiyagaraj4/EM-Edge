<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes end --%>


<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>

<%-- Mandatory declarations end --%>
<%
        request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<html>
	<head>
		<title></title>
		
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	//Search Criteria's from Query Criteria page
	String form_code		= request.getParameter( "form_code" );
	String form_desc		= request.getParameter( "form_desc" ) ;
	String uom_code     	= request.getParameter( "uom_code" ) ;
	String short_desc     	= request.getParameter( "short_desc" ) ;
	//String ord[]			= request.getParameterValues("orderbycolumns");
	boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;

try{
	String classvalue			= "";

	form_code = CommonBean.checkForNull( form_code.trim() );
	form_desc = CommonBean.checkForNull( form_desc.trim() );
	uom_code = CommonBean.checkForNull( uom_code.trim() );
	short_desc = CommonBean.checkForNull( short_desc.trim() );

	//Common parameters.
	HashMap sqlMap = new HashMap();
	//include all the common parameters.
	sqlMap.put( "sqlData", PhRepository.getPhKeyValue("SQL_PH_UOM_FOR_FORM_SELECT3"));

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();

	displayFields.add( "form_code" );
	displayFields.add( "form_desc" );
	displayFields.add( "uom_code" );
	displayFields.add( "short_desc" );
	displayFields.add( "dflt_uom_yn" );

	ArrayList chkFields = new ArrayList();
	chkFields.add( form_code.trim() + "%");
	chkFields.add( form_desc.trim() + "%");
	chkFields.add( uom_code.trim()  + "%");
	chkFields.add( short_desc.trim()  + "%");
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
		<th width="10%"><fmt:message key="ePH.FormofDrugCode.label" bundle="${ph_labels}"/></th>
		<th width="40%"><fmt:message key="ePH.FormofDrugDescription.label" bundle="${ph_labels}"/></th>
		<th width="10%">Applicable UOM Code</th>
		<th width="40%"><fmt:message key="ePH.ApplicableUOMDescription.label" bundle="${ph_labels}"/></th>
		<th width="40%"><fmt:message key="ePH.DefaultUOM.label" bundle="${ph_labels}"/></th>
		<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYODD" ;
			else
				classvalue = "QRYEVEN" ;
	%>
			<tr>
	<%


			records=(ArrayList) result.get( recCount );
			for(int colCount=0; colCount<records.size(); colCount++){

	%>
					<td class="<%=classvalue%>" value="<%=(String)records.get( colCount )%>"
	<%
				String dkVal = (String)records.get( colCount );
					if(dkVal == null)	dkVal = "&nbsp" ;
					if(dkVal.equals("")) dkVal = "&nbsp;";

					if((colCount==4)){
						out.println("align=\"center\">");
							out.println(getImage(dkVal));
						out.println("</td>");
					}//if
					else{
						out.println("align=\"left\">");
						out.println(dkVal);
						out.println("</td>");
						}
					dkVal = "";

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
	out.println(CommonBean.setForm ( request ,"../../ePH/jsp/UomForFormQueryResult.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>
<%!
public String getImage(String value){
	if(value.equalsIgnoreCase("Y"))
		return "<img src=\"../../eCommon/images/enabled.gif\"><input type='hidden' value='E'>";
	else

	return "&nbsp;";
}
%>
</body>
</html>

