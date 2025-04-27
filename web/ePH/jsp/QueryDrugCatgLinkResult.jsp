<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
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
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/QueryDrugCatgLink.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>
 -->	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonResult.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	//Search Criteria's from Query Criteria page
	String drug_code	= request.getParameter( "drug_code" );
	String drug_class	= request.getParameter( "drug_class" ) ;
	String drug_name	= request.getParameter( "drug_name" );
	String linked		= request.getParameter( "linked" ) ;

	boolean searched	= request.getParameter( "searched" ) == null ? false : true  ;

	try {
		drug_code			= CommonBean.checkForNull( drug_code.trim() );
		drug_class			= CommonBean.checkForNull( drug_class.trim() );
		drug_name			= CommonBean.checkForNull( drug_name.trim() );
		linked				= CommonBean.checkForNull( linked.trim() );



		ArrayList displayFields = new ArrayList();
		displayFields.add( "DRUG_CODE");
		displayFields.add( "DRUG_DESC");
		displayFields.add( "STRENGTH_VALUE");
		displayFields.add( "STRENGTH_UOM_DESC" );
		displayFields.add( "FORM_DESC" );
		displayFields.add( "ROUTE_DESC" );
		displayFields.add( "PRES_BASE_UOM_DESC" );

		ArrayList chkFields = new ArrayList();


		chkFields.add( drug_code.trim());
		//chkFields.add( drug_name.trim()+"%");
		chkFields.add( "%");
		chkFields.add( drug_class.trim());
		chkFields.add(locale);





		HashMap funcMap = new HashMap();
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

		HashMap sqlMap = new HashMap();
		if (linked.equals("Y"))
			sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_DRUG_ORDER_CAT_NOT_LINK_SELECT2" ));
		else if (linked.equals("N"))
			sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_DRUG_ORDER_CAT_NOT_LINK_SELECT3" ));

		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);




		if( result.size() >= 3 && ( !( ( (String)result.get(0)).equals("0")) )) {
%>

		<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center">
		<TR>
			<TD WIDTH="80%" CLASS="white">&nbsp;</TD>
			<TD WIDTH="20%" CLASS="white">&nbsp;

<%
			// For display the previous/next link
			out.println( result.get(1) );
%>

			</TD>
		</TR>
		</TABLE>

		<TABLE BORDER="1" CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center">
		<TH WIDTH="2%">&nbsp</TH>
		<TH WIDTH="40%"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></TH>
		<TH WIDTH="15%"><fmt:message key="ePH.Strength/Value.label" bundle="${ph_labels}"/></TH>
		<TH WIDTH="15%"><fmt:message key="ePH.FormDescription.label" bundle="${ph_labels}"/></TH>
		<TH WIDTH="15%"><fmt:message key="ePH.RouteDescription.label" bundle="${ph_labels}"/></TH>
		<TH WIDTH="15%"><fmt:message key="ePH.PrescribingBaseUOM.label" bundle="${ph_labels}"/></TH>

<%
			//Retriving the records from result arraylist
			ArrayList records = new ArrayList();
			String classvalue	=	"";
			for(int recCount=2; recCount<result.size(); recCount++) {
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
%>

		<TR>

<%
				records = (ArrayList) result.get( recCount );
				String strength	= "";
				for(int colCount=0; colCount<records.size(); colCount++) {
					if(colCount==0)	{
%>

			<TD CLASS="<%= classvalue %>"><A href="javascript:parent.loadPage('<%= (String)records.get( colCount ) %>')" CLASS="label" onMouseover="changeCursor(this)" >+</A></TD>

<%
					}
					else if(colCount==2 || colCount==3) {
						if(colCount!=3)	{
							if(records.get( colCount ) != null)
							{
								if(Float.parseFloat((String)records.get( colCount )) <1 && Float.parseFloat((String)records.get( colCount )) >0.0)
									strength +=Float.parseFloat((String)records.get( colCount )) ;
								else
									strength +=(String)records.get( colCount ) ;
							}
							else
								strength += "" ;
							continue;
						}
						else {
							if(records.get( colCount ) !=null && !(records.get( colCount ).equals("")))
								strength += "/"+CommonBean.checkForNull( (String)records.get( colCount ) );
							else
								strength +="&nbsp";
						}
%>

				<TD CLASS="<%= classvalue %>"><%= strength %></TD>

<%
						strength = "";
					}
					else {
						String displayValue = (String)records.get( colCount ) ;
						if (displayValue == null || displayValue.equals("0"))
						displayValue = "&nbsp";
%>

				<TD CLASS="<%= classvalue %>"><%= displayValue %></TD>

<%
					}
				}
%>

		</TR>

<%
			}
%>

	</TABLE>

<%
			out.flush();
		}
		else {
%>

		<SCRIPT>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
			parent.f_query_result.location.href="../../eCommon/html/blank.html";
		</SCRIPT>

<%
		}
		out.println(CommonBean.setForm ( request, "../../ePH/jsp/QueryDrugCatgLinkResult.jsp", searched ) );
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>

</BODY>
</HTML>

