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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");
	
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonResult.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/DispenseRights.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<!-- <BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()"> -->
<body onMouseDown="" onKeyDown="lockKey()">


<%
	String appl_user_id			= request.getParameter( "APPL_USER_ID" ) ;
	String appl_user_name		= request.getParameter( "APPL_USER_NAME" ) ;
	String short_desc			= request.getParameter( "SHORT_DESC" ) ;
	String disp_locn_code		= request.getParameter( "DISP_LOCN_CODE" ) ;
	String ack_yn				= request.getParameter( "ACK_YN" ) ;
	String verify_yn			= request.getParameter( "VERIFY_YN" ) ;
	String fill_yn				= request.getParameter( "FILL_YN" ) ;
	String deliver_yn			= request.getParameter( "DELIVER_YN" ) ;
	String accept_medn_rtn_yn	= request.getParameter( "ACCEPT_MEDN_RTN_YN");
	String bill_receipt_yn		= request.getParameter( "BILL_RECEIPT_YN" ) ;
	String allocate_yn			= request.getParameter( "ALLOCATE_YN" ) ;
	String facility_id			= (String) session.getValue( "facility_id" );

	String bean_id		= "DispenseRightsBean" ;
	String bean_name	= "ePH.DispenseRightsBean";
	DispenseRightsBean bean = (DispenseRightsBean)getBeanObject( bean_id,bean_name, request ) ;
	bean.setLanguageId(locale);
	Hashtable param_legends = bean.getLegendsFromParam();



	boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;
	//String ord[]				= request.getParameterValues("orderbycolumns");

	try {
		String classvalue			= "";

		appl_user_id		= CommonBean.checkForNull( appl_user_id );
		appl_user_name		= CommonBean.checkForNull( appl_user_name );
		short_desc			= CommonBean.checkForNull( short_desc );
		disp_locn_code	    = CommonBean.checkForNull( disp_locn_code );
		ack_yn				= CommonBean.checkForNull( ack_yn );
		verify_yn			= CommonBean.checkForNull( verify_yn );
		fill_yn			    = CommonBean.checkForNull( fill_yn );
		deliver_yn     		= CommonBean.checkForNull( deliver_yn );
		//reissue_medication_yn    = CommonBean.checkForNull( reissue_medication_yn );
		accept_medn_rtn_yn	= CommonBean.checkForNull( accept_medn_rtn_yn );
		bill_receipt_yn     = CommonBean.checkForNull( bill_receipt_yn );
		allocate_yn     	= CommonBean.checkForNull( allocate_yn );

        //String SQL_PH_DISP_RIGHTS_SELECT5="SELECT A.APPL_USER_ID, B.APPL_USER_NAME, A.DISP_LOCN_CODE, C.SHORT_DESC, A.DISP_AUTH_REQD_DRUG_YN, A.DISP_NARCOTIC_YN, A.DISP_CONTROLLED_DRUG_YN, A.ACK_YN, A.VERIFY_YN, A.FILL_YN, A.ALLOCATE_YN, A.BILL_RECEIPT_YN, A.DELIVER_YN, A.ALLOW_REPRINT_YN, A.NO_OF_REPRINTS, A.ACCEPT_MEDN_RTN_YN, A.IP_VERIFY_YN, A.IP_ALLOCATE_YN, A.IP_DELIVER_YN,A.TRADE_CHANGE_ALLOWED_YN,MULTI_TRADE_ALLOWED_YN,A.REROUTE_ORDER_YN ,A.OP_REISSUE_MED_YN,A.IP_REISSUE_MED_YN FROM PH_DISP_RIGHTS A, SM_APPL_USER_LANG_VW B, PH_DISP_LOCN_LANG_VW C WHERE A.APPL_USER_ID=B.APPL_USER_ID AND A.DISP_LOCN_CODE=C.DISP_LOCN_CODE AND A.FACILITY_ID=C.FACILITY_ID AND A.FACILITY_ID=UPPER(?) AND UPPER(A.APPL_USER_ID) LIKE UPPER(?) AND UPPER(B.APPL_USER_NAME) LIKE UPPER(?) AND C.SHORT_DESC LIKE UPPER(?) AND UPPER(A.DISP_LOCN_CODE) LIKE UPPER(?) AND A.ACK_YN LIKE UPPER(DECODE(?,'B',A.ACK_YN,?)) AND A.VERIFY_YN LIKE UPPER(DECODE(?,'B',A.VERIFY_YN,?)) AND A.FILL_YN LIKE UPPER(DECODE(?,'B',A.FILL_YN,?)) AND A.DELIVER_YN LIKE UPPER(DECODE(?,'B',A.DELIVER_YN,?)) AND A.ACCEPT_MEDN_RTN_YN LIKE UPPER(DECODE(?,'B',A.ACCEPT_MEDN_RTN_YN,?)) AND A.BILL_RECEIPT_YN LIKE UPPER(DECODE(?,'B',A.BILL_RECEIPT_YN,?)) AND A.ALLOCATE_YN LIKE UPPER(DECODE(?,'B',A.ALLOCATE_YN,?)) AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = ?";

		HashMap sqlMap = new HashMap();
		sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_DISP_RIGHTS_SELECT5"));
		
		//sqlMap.put( "sqlData", SQL_PH_DISP_RIGHTS_SELECT5);

		//The fields are going to be display
		ArrayList displayFields = new ArrayList();
		displayFields.add("APPL_USER_ID" );
		displayFields.add("APPL_USER_NAME" );
		displayFields.add("DISP_LOCN_CODE" );
		displayFields.add("SHORT_DESC" );
		displayFields.add("DISP_AUTH_REQD_DRUG_YN" );
		displayFields.add("DISP_NARCOTIC_YN" );
		displayFields.add("DISP_CONTROLLED_DRUG_YN" );		
        displayFields.add("TRADE_CHANGE_ALLOWED_YN" );
		displayFields.add("MULTI_TRADE_ALLOWED_YN" );
        displayFields.add("REROUTE_ORDER_YN" );

		displayFields.add("ACK_YN" );
		displayFields.add("VERIFY_YN" );
		displayFields.add("FILL_YN" );
		displayFields.add("ALLOCATE_YN" );
		//displayFields.add("BILL_RECEIPT_YN" );
		displayFields.add("DELIVER_YN" );
		displayFields.add("ALLOW_REPRINT_YN" );
		displayFields.add("NO_OF_REPRINTS" );
		displayFields.add("ACCEPT_MEDN_RTN_YN" );
		displayFields.add("IP_VERIFY_YN" );
		displayFields.add("IP_ALLOCATE_YN" );
		displayFields.add("IP_DELIVER_YN" );
		displayFields.add("OP_REISSUE_MED_YN" );
		displayFields.add("IP_REISSUE_MED_YN" );

		//The fields are going to be in where condition * should match with the query
		ArrayList chkFields = new ArrayList();
		chkFields.add( facility_id.trim() );
		chkFields.add( appl_user_id.trim() + "%" );
		chkFields.add( appl_user_name.trim() + "%" );
		chkFields.add( short_desc.trim() + "%" );
		chkFields.add( disp_locn_code.trim() + "%" );
		chkFields.add( ack_yn.trim() + "%" );
		chkFields.add( ack_yn.trim() + "%" );
		chkFields.add( verify_yn.trim() + "%" );
		chkFields.add( verify_yn.trim() + "%" );
		chkFields.add( fill_yn.trim() + "%" );
		chkFields.add( fill_yn.trim() + "%" );
		chkFields.add( deliver_yn.trim() + "%" );
		chkFields.add( deliver_yn.trim() + "%" );
		//chkFields.add( reissue_medication_yn.trim() + "%" );
		//chkFields.add( reissue_medication_yn.trim() + "%" );
		chkFields.add( accept_medn_rtn_yn.trim() + "%" );
		chkFields.add( accept_medn_rtn_yn.trim() + "%" );
		chkFields.add( bill_receipt_yn.trim() + "%" );
		chkFields.add( bill_receipt_yn.trim() + "%" );
		chkFields.add( allocate_yn.trim() + "%" );
		chkFields.add( allocate_yn.trim() + "%" );
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
			<TH ROWSPAN="2"><fmt:message key="ePH.DispenseLocationCode.label" bundle="${ph_labels}"/></TH>
			<TH ROWSPAN="2"><fmt:message key="ePH.DispenseDescription.label" bundle="${ph_labels}"/></TH>
			<TH COLSPAN="3"><fmt:message key="ePH.AuthorizedDrugs.label" bundle="${ph_labels}"/></TH>
			<TH ROWSPAN="2"><fmt:message key="ePH.ChangeTradeName.label" bundle="${ph_labels}"/></TH>
			<TH ROWSPAN="2"><fmt:message key="ePH.AllowMultiTrade.label" bundle="${ph_labels}"/></TH>
			<TH ROWSPAN="2"><fmt:message key="ePH.RerouteOrder.label" bundle="${ph_labels}"/></TH>

			<TH ROWSPAN="2"><%=param_legends.get("R")%></TH>
			<TH ROWSPAN="2"><%=param_legends.get("V")%></TH>
			<TH ROWSPAN="2"><%=param_legends.get("F")%></TH>
			<TH ROWSPAN="2"><%=param_legends.get("A")%></TH>
			<!-- <TH ROWSPAN="2"><%=param_legends.get("B")%></TH> -->
			<TH ROWSPAN="2"><%=param_legends.get("D")%></TH>
			<TH ROWSPAN="2"><fmt:message key="ePH.AllowReprinting.label" bundle="${ph_labels}"/></TH>
			<TH ROWSPAN="2"><fmt:message key="ePH.No.OfReprints.label" bundle="${ph_labels}"/></TH>
			<TH ROWSPAN="2"><fmt:message key="ePH.MedicationReturn.label" bundle="${ph_labels}"/></TH>
			<TH ROWSPAN="2"><fmt:message key="Common.IP.label" bundle="${common_labels}"/> <%=param_legends.get("V")%></TH>
			<TH ROWSPAN="2"><fmt:message key="Common.IP.label" bundle="${common_labels}"/><%=param_legends.get("A")%></TH>
			<TH ROWSPAN="2"><fmt:message key="Common.IP.label" bundle="${common_labels}"/> <%=param_legends.get("D")%></TH>
			<TH ROWSPAN="2"><fmt:message key="ePH.OPReissueMedication.label" bundle="${ph_labels}"/></TH>
			<TH ROWSPAN="2"><fmt:message key="ePH.IPReissueMedication.label" bundle="${ph_labels}"/></TH>
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
		out.println(CommonBean.setForm ( request ,"../../ePH/jsp/DispenseRightsQueryResult.jsp", searched) );
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

