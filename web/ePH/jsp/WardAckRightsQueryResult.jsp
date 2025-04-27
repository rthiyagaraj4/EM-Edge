<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"import="java.util.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>


<HTML>
<HEAD>
	<TITLE></TITLE>
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

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonResult.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/WardAcknowledgeRights.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<!-- <BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()"> -->
<body onMouseDown="" onKeyDown="lockKey()">


<%
	String appl_user_id			= request.getParameter( "APPL_USER_ID" ) ;
	String appl_user_name		= request.getParameter( "APPL_USER_NAME" ) ;
	String short_desc			= request.getParameter( "NURSING_UNIT_NAME" ) ;
	
	String facility_id			= (String) session.getValue( "facility_id" ); 

	String bean_id		= "WardAcknowledgeRightsBean" ;
	String bean_name	= "ePH.WardAcknowledgeRightsBean";
	WardAcknowledgeRightsBean bean = (WardAcknowledgeRightsBean)getBeanObject( bean_id,bean_name, request ) ;
	bean.setLanguageId(locale);
	

	boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;
	//String ord[]				= request.getParameterValues("orderbycolumns");

	try {
		String classvalue			= "";

		appl_user_id		= CommonBean.checkForNull( appl_user_id );
		appl_user_name		= CommonBean.checkForNull( appl_user_name );
		short_desc			= CommonBean.checkForNull( short_desc );
		
		

		HashMap sqlMap = new HashMap();
		String sqlData= "SELECT a.USER_ID,a.NURSING_UNIT_CODE, b.appl_user_name,c.short_desc,c.long_desc, a.GENRAL_DRUG_YN,a.NARCOTIC_DRUG_YN,a.CONTROLLED_DRUG_YN  FROM PH_WARD_ACK_RIGHTS a, sm_appl_user_lang_vw b, ip_nursing_unit_lang_vw c WHERE a.USER_ID = b.APPL_USER_ID AND a.NURSING_UNIT_CODE = c.NURSING_UNIT_CODE AND a.added_facility_id = UPPER (?) AND UPPER (a.USER_ID) LIKE UPPER (?) AND UPPER (b.appl_user_name) LIKE UPPER (?)AND c.short_desc LIKE UPPER (?) AND b.language_id = c.language_id AND b.language_id = ?";
		sqlMap.put( "sqlData", sqlData);

		//The fields are going to be display
		ArrayList displayFields = new ArrayList();
		displayFields.add("USER_ID" );
		displayFields.add("APPL_USER_NAME" );
		displayFields.add("NURSING_UNIT_CODE" );
		displayFields.add("LONG_DESC" );
		displayFields.add("GENRAL_DRUG_YN" );
		displayFields.add("NARCOTIC_DRUG_YN" );		
        displayFields.add("CONTROLLED_DRUG_YN" );
	

		//The fields are going to be in where condition * should match with the query
		ArrayList chkFields = new ArrayList();
	    chkFields.add( facility_id.trim() );
		chkFields.add( appl_user_id.trim() + "%" );
		chkFields.add( appl_user_name.trim() + "%" );
		chkFields.add( short_desc.trim() + "%" );
		
		chkFields.add(locale);

		// Adding function parameters related array list into the HashMap
		HashMap funcMap = new HashMap();
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

		//Calling the Result from Common Adaptor as a arraylist.
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		

		if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )) {
%>

		<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center">
		<TR>
			<TD WIDTH="80%" CLASS="white">&nbsp;</TD>
			<TD WIDTH="20%" CLASS="white">&nbsp;

<%
		// For display the previous/next link
	     	out.println(result.get(1));

%>
		</TD></TR>
		</TABLE>

		<TABLE BORDER="1" CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center">
			<TH ROWSPAN="2"><fmt:message key="Common.userid.label" bundle="${common_labels}"/></TH>
			<TH ROWSPAN="2"><fmt:message key="Common.username.label" bundle="${common_labels}"/></TH>
			<TH ROWSPAN="2"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></TH>
			<TH ROWSPAN="2"><fmt:message key="Common.NursingUnitDetails.label" bundle="${common_labels}"/></TH>
			<TH COLSPAN="3"><fmt:message key="ePH.AuthorizedDrugs.label" bundle="${ph_labels}"/></TH>
			
		</TR>
		<TR>
			<TH><fmt:message key="Common.general.label" bundle="${common_labels}"/></TH>
			<TH><fmt:message key="ePH.Narcotics.label" bundle="${ph_labels}"/></TH>
			<TH><fmt:message key="ePH.Controlled.label" bundle="${ph_labels}"/></TH>
		</TR>

<%
		//Retriving the records from result arraylist
			ArrayList records=new ArrayList();
			for(int recCount=2; recCount<result.size(); recCount++) {
				if ( recCount % 2 == 0 )
					classvalue = "QRYODD" ;
				else
					classvalue = "QRYEVEN" ;
%>

		<TR onClick="modify(this);" >

<%
				String link_columns = "1";
				records=(ArrayList) result.get( recCount );

				for(int colCount=0; colCount<records.size(); colCount++) {
					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
%>

			<TD CLASS="<%=classvalue%>" onMouseOver="changeCursor(this);"><FONT CLASS="HYPERLINK"><%=(String)records.get( colCount )%></FONT></TD>

<%
					}
					else {
						String dispValue = (String)records.get( colCount );
						if (dispValue == null || dispValue.equals(""))
							dispValue = "&nbsp" ;

						if ( colCount==1 || colCount==2 || colCount==3) {
%>

			<TD CLASS="<%=classvalue%>" onClick="disableClick(event);" VALUE="<%=(String)records.get( colCount )%>"><%= dispValue %></TD>

<%
						}
						else {

%>

			<TD CLASS="<%=classvalue%>" onClick="disableClick(event);" VALUE="<%=(String)records.get( colCount )%>">

<%
							if( (dispValue.equalsIgnoreCase("E"))|| (dispValue.equalsIgnoreCase("Y")) ) {
%>

				<IMG SRC="../../eCommon/images/enabled.gif"></IMG>

<%
							}
							else {
%>

				          <IMG SRC="../../eCommon/images/disabled.gif"></IMG>

<%
							}
%>

			</TD>

<%
						}
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
		else{
%>

	<SCRIPT>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</SCRIPT>

<%
		}
		out.println(CommonBean.setForm ( request ,"../../ePH/jsp/WardAckRightsQueryResult.jsp", searched) );
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>

</BODY>
</HTML>
<%
putObjectInBean(bean_id,bean,request);
%>

