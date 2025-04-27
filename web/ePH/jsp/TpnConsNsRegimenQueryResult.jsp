<!DOCTYPE html>
<%-- saved on 26/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper " %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
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
		
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="JavaScript" src="../../ePH/js/TpnConsNsRegimen.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	//Search Criteria's from Query Criteria page
	String const_generic_code	= request.getParameter( "const_generic_code" );
	String item_code			= request.getParameter( "item_code" );
	String const_short_name		= request.getParameter( "const_short_name" ) ;
	String const_long_name		= request.getParameter( "const_long_name" ) ;
	String physical_form		= request.getParameter( "physical_form" ) ;
	String eff_status     		= request.getParameter( "eff_status" ) ;
	String ord[]				= request.getParameterValues("orderbycolumns");
	boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;
	try{
		String classvalue			= "";

		const_generic_code = CommonBean.checkForNull( const_generic_code.trim() );
		item_code		   = CommonBean.checkForNull( item_code.trim() );
		const_short_name   = CommonBean.checkForNull( const_short_name.trim() );
		const_long_name    = CommonBean.checkForNull( const_long_name.trim() );
		physical_form      = CommonBean.checkForNull( physical_form.trim() );
		eff_status         = CommonBean.checkForNull( eff_status.trim() );
		if(physical_form.equals("B")){
			physical_form="";
		}
		if (eff_status.equals("B")){
			eff_status="";
		}
	
	//Common parameters.
	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_TPN_CONS_NS_REGIMEN_SELECT7"));

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields that are going to be display
	ArrayList displayFields = new ArrayList();

	displayFields.add( "const_generic_code" );
	displayFields.add( "item_code" );
	displayFields.add( "concentration_percent" );
	displayFields.add( "const_short_name" );
	displayFields.add( "const_long_name" );
	displayFields.add( "physical_form" );
	displayFields.add( "eff_status" );

	ArrayList chkFields = new ArrayList();
	chkFields.add( const_generic_code.trim() + "%" );
	chkFields.add( const_short_name.trim() + "%" );
	chkFields.add( const_long_name.trim() + "%" );
	chkFields.add( physical_form.trim() + "%" );
	chkFields.add( eff_status.trim() + "%" );
	chkFields.add( item_code.trim() + "%" );
	chkFields.add( locale);
	
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
	<th width="12%"><fmt:message key="ePH.ConstituentGenericCode.label" bundle="${ph_labels}"/></th><th width="22%"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></th><th width="22%"><fmt:message key="ePH.ConcentrationPercentage.label" bundle="${ph_labels}"/></th><th width="22%"><fmt:message key="Common.shortname.label" bundle="${common_labels}"/></th><th width="42%"><fmt:message key="Common.longname.label" bundle="${common_labels}"/></th><th width="10%"><fmt:message key="ePH.PhysicalForm.label" bundle="${ph_labels}"/></th><th width="10%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
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
					}else if((colCount==1)){
						out.println("align=\"left\">");
						out.println(dkVal);
						out.println("</td>");
					}else if((colCount==5)){
						if(dkVal.equals("L")){
							dkVal="Liquid";
						}else{
							dkVal="Solid";
						}
						out.println("align=\"left\">");
						out.println(dkVal);
						out.println("</td>");
					}else{
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
		}else{
	%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
	<%
	}
		out.println(CommonBean.setForm ( request ,"../../ePH/jsp/TpnConsNsRegimenQueryResult.jsp", searched) );
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

