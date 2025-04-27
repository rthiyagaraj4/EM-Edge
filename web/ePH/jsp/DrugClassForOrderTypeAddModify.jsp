<!DOCTYPE html>
 <!--
Fine Tuning
-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
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

	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/DrugClassForOrderType.js"></SCRIPT>
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<SCRIPT>
		var function_id = "<%= request.getParameter( "function_id" ) %>"
	</SCRIPT>
</HEAD>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String jsp_hdn_flg		= request.getParameter( "hdn_flg" );
	HashMap records			= null;
	int numrecs				= 14 ;
	int from				= 0 ;
	int totrecs 			= 0 ;
	int orgcnt				= 0 ;
%>

<FORM name="formDrugClassForOrderType" id="formDrugClassForOrderType" >
<INPUT TYPE="hidden" name="hdn_flag" id="hdn_flag" VALUE="<%= jsp_hdn_flg %>">
<%
	String bean_id 		= "DrugClassForOrderTypeBean" ;
	String bean_name	= "ePH.DrugClassForOrderTypeBean" ;
	DrugClassForOrderTypeBean bean = (DrugClassForOrderTypeBean)getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	String select_colclass			= "normal" ;
	String association_colclass		= "normal" ;

	if ( jsp_hdn_flg.equals("1") )
		select_colclass			= "clicked" ;
	if ( jsp_hdn_flg.equals("2") )
		association_colclass	= "clicked" ;

	if ( jsp_hdn_flg.equals("0") ) {
%>
	<INPUT TYPE="hidden" name="apllystatus" id="apllystatus" VALUE="false">
	<TABLE BORDER="1" WIDTH="35%" CELLSPACING="0" CELLPADDING="0">
	<TR>
		<TD CLASS="<%= select_colclass %>"  WIDTH="50%" HEIGHT="20"><A CLASS="TABLINK" HREF="javascript:onSelect(1)"><B><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></B></A></TD>
		<TD CLASS="<%= association_colclass %>" ALIGN="center" WIDTH="50%" HEIGHT="20"><A CLASS="TABLINK" HREF="javascript:onAssoc(2)"><B><fmt:message key="Common.Association.label" bundle="${common_labels}"/></B></A></TD>
	</TR>
	</TABLE>
<%
	}

	if (jsp_hdn_flg.equals("1") || jsp_hdn_flg.equals("2")) {
		String firsttime	= "" ;
		int rstflag			= 0 ;

		if (request.getParameter( "from" ) != null )
			from	= Integer.parseInt(request.getParameter( "from" ) ) ;

		if (request.getParameter( "orgcnt" ) != null )
			orgcnt	= Integer.parseInt(request.getParameter( "orgcnt" ) ) ;

		if (request.getParameter( "firsttime" ) != null )
			firsttime	= request.getParameter( "firsttime" ) ;

		if (request.getParameter( "rstflag" ) != null )
			rstflag	= Integer.parseInt(request.getParameter( "rstflag" ) ) ;

		if ( firsttime.equals("true") )
			records	= bean.getOrderType();
		else {
			if ( rstflag == 1 )
				records	= bean.getOriginalData(from, numrecs);
			else
				records	= bean.getHashData();
		}

		if (jsp_hdn_flg.equals("1") ) {
			totrecs 	= records.size() ;
		}

		if (jsp_hdn_flg.equals("2") ) {
			for ( int datacnt = 0; datacnt < records.size(); datacnt++ ) {
				StringTokenizer st = new StringTokenizer(records.get(datacnt+"").toString(), ",");
				st.nextToken();
				st.nextToken();
				String selopt = st.nextToken();
				String avlblindb	= st.nextToken();

				if ( (!(selopt.equals("~"))) || (avlblindb.equalsIgnoreCase("Y") && selopt.equals("~")))
					totrecs++;
			}
		}

		if (totrecs > 0) {
%>

	<INPUT TYPE="hidden" name="apllystatus" id="apllystatus" VALUE="true">
	<INPUT TYPE="hidden" name="totrecs" id="totrecs" VALUE="<%= records.size() %>">
	<INPUT TYPE="hidden" name="begin" id="begin" VALUE="<%= from %>">
	<TABLE BORDER="1" WIDTH="35%" CELLSPACING="0" CELLPADDING="0">
	<TR>
		<TD CLASS="<%= select_colclass %>"  WIDTH="50%" HEIGHT="20">
			<A CLASS="TABLINK" HREF="javascript:onSelect(1, <%= from %>, <%= numrecs %>, <%= records.size() %>)"><B><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></B></A>
		</TD>
		<TD CLASS="<%= association_colclass %>"  WIDTH="50%" HEIGHT="20">
			<A CLASS="TABLINK" HREF="javascript:onAssoc(2, <%= from %>, <%= numrecs %>, <%= records.size() %>)"><B><fmt:message key="Common.Association.label" bundle="${common_labels}"/></B></A>
		</TD>
	</TR>
	</TABLE>

	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="85%" ALIGN="center" BORDER="0">
	<TR>
		<TD WIDTH="80%" CLASS="white">&nbsp;</TD>

<%
		if (jsp_hdn_flg.equals("1") ) {
			if ( !(from < 1) ) {
%>

		<TD CLASS="WHITE"><A HREF onMouseover="changeCursor(this)" style="background:#E2E3F0" onClick="makeChanges('prev', <%= from %>, <%= numrecs %>, <%= totrecs %>);"><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>&nbsp;&nbsp;</td>

<%
			}
			if ( totrecs > from + numrecs ) {
%>

		<TD CLASS="WHITE" ALIGN="right"><A HREF onMouseover="changeCursor(this)" onClick="makeChanges('next', <%= from %>, <%= numrecs %>, <%= totrecs %>);" style="background:#E2E3F0"><fmt:message key="Common.next.label" bundle="${common_labels}"/></A></TD>

<%
			}
		}
		if (jsp_hdn_flg.equals("2") ) {
			if ( !(from < 1) ) {
%>

		<TD CLASS="WHITE" ALIGN="right"><A HREF onMouseover="changeCursor(this)" onClick="makeChanges('prev', <%= from %>, <%= numrecs %>, <%= totrecs %>);" style="background:#E2E3F0" ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>&nbsp;&nbsp;</td>

<%
			}
			if ( totrecs > orgcnt + numrecs ) {
%>
		<TD CLASS="WHITE" ALIGN="right"><A HREF onMouseover="changeCursor(this)" onClick="makeChanges('next', <%= from %>, <%= numrecs %>, <%= totrecs %>);" style="background:#E2E3F0"><fmt:message key="Common.next.label" bundle="${common_labels}"/></A></TD>

<%
			}
		}
%>

	</TR>
	</TABLE>

	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="85%" ALIGN="center" BORDER="1">
	<TR>
		<TH WIDTH="2%" ALIGN="center">&nbsp;</TH>
		<TH WIDTH="75%" ALIGN="center"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></TH>
		<TH WIDTH="23%" ALIGN="center"><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/></TH>
	</TR>

<%
		int rowcnt			= 0 ;
		int actualcnt		= orgcnt ;

		for ( int datacnt = from; datacnt < records.size(); datacnt++ ) {
			String disabled		= "";
			StringTokenizer st	= new StringTokenizer(records.get(datacnt+"").toString(), ",");
			String code 		= st.nextToken();
			String desc 		= st.nextToken();
			String selopt 		= st.nextToken();
			String avlblindb	= st.nextToken();
			String dbmode		= st.nextToken();

			if ( (!(jsp_hdn_flg.equals("2") && selopt.equals("~") )) || (avlblindb.equalsIgnoreCase("Y") && jsp_hdn_flg.equals("2")) ) {
				String bgcolor			= "";
				rowcnt++;
				if (rowcnt > numrecs) {
					from = datacnt;
					break;
				}
				else {
					actualcnt++;
					if (rowcnt % 2 == 0)
						bgcolor = "QRYEVEN" ;
					else
						bgcolor = "QRYODD" ;
%>

	<TR>
		<INPUT TYPE="hidden" name="ORDER_TYPE_<%= datacnt %>" id="ORDER_TYPE_<%= datacnt %>" VALUE="<%= code %>">
		<INPUT TYPE="hidden" name="ORDER_TYPE_NAME_<%= datacnt %>" id="ORDER_TYPE_NAME_<%= datacnt %>" VALUE="<%= desc %>">
		<INPUT TYPE="hidden" name="ORIGINAL_VAL_<%= datacnt %>" id="ORIGINAL_VAL_<%= datacnt %>" VALUE="<%= selopt %>">
		<INPUT TYPE="hidden" name="AVLINDB_<%= datacnt %>" id="AVLINDB_<%= datacnt %>" VALUE="<%= avlblindb %>">
		<INPUT TYPE="hidden" name="DB_MODE_<%= datacnt %>" id="DB_MODE_<%= datacnt %>" VALUE="<%= dbmode %>">
		<TD CLASS="<%= bgcolor %>" WIDTH="2%"><A HREF CLASS="label" onMouseover="changeCursor(this)" onClick="callOrderType('<%= code %>')">+</A></TD>
		<TD CLASS="<%= bgcolor %>" WIDTH="75%" ALIGN="left">&nbsp;

<%
					if (avlblindb.equalsIgnoreCase("Y")) {
%>

			<FONT CLASS="DATAHIGHLIGHT"><%= desc %></FONT>

<%
					}
					else {
%>

			<%= desc %>

<%
					}
%>

		</TD>
		<TD CLASS="<%= bgcolor %>" WIDTH="23%">&nbsp;
			<SELECT name="DRUG_CLASS_<%= datacnt %>" id="DRUG_CLASS_<%= datacnt %>" onChange="setIMDmode(this.value, <%= datacnt %>)" <%= disabled %>>
				<OPTION VALUE="~">&nbsp;&nbsp;-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --&nbsp;&nbsp;</OPTION>
				<OPTION VALUE="G"><fmt:message key="Common.general.label" bundle="${common_labels}"/></OPTION>
				<OPTION VALUE="N"><fmt:message key="ePH.Narcotics.label" bundle="${ph_labels}"/></OPTION>
				<OPTION VALUE="C"><fmt:message key="ePH.Controlled.label" bundle="${ph_labels}"/></OPTION>
			</SELECT>
			<SCRIPT>
				comboset('parent.f_query_add_mod.document.formDrugClassForOrderType.', 'DRUG_CLASS_<%= datacnt %>', '<%= selopt %>');
			</SCRIPT>
		</TD>
	</TR>

<%
				}
			}
		}
%>

		<INPUT TYPE="hidden" name="numrows" id="numrows" VALUE="<%= rowcnt %>">
		<INPUT TYPE="hidden" name="from" id="from" VALUE="<%= from %>">
		<INPUT TYPE="hidden" name="actualcnt" id="actualcnt" VALUE="<%= actualcnt %>">

<%
		}
		else {
%>

	<SCRIPT>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA"));history.go(-1);</SCRIPT>

<%
		}
%>
	</TABLE>
	<INPUT TYPE="hidden" name="mode" id="mode" VALUE="1">
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
	<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%=bean.getFunctionId()%>">
	<TABLE>

<%
	}
	if (jsp_hdn_flg.equals("3") ) {
%>

	<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
		int start = Integer.parseInt(request.getParameter( "start" ) ) ;
		int numofrecs = Integer.parseInt(request.getParameter( "numrecs" ) ) ;
		Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;

		StringBuffer paramstring	= new StringBuffer();

		for (int itemnum=start; itemnum<numofrecs; itemnum++ ) {
			if(hash.containsKey("ORDER_TYPE_"+itemnum))
				paramstring=paramstring.append(itemnum).append(",").append(hash.get( "ORDER_TYPE_"+itemnum ).toString()).append(",");
				//paramstring += itemnum + "," + hash.get( "ORDER_TYPE_"+itemnum ).toString() + ",";

			if(hash.containsKey("ORDER_TYPE_NAME_"+itemnum))
				paramstring=paramstring.append(hash.get( "ORDER_TYPE_NAME_"+itemnum ).toString()).append(",");
               //paramstring += hash.get( "ORDER_TYPE_NAME_"+itemnum ).toString() + ",";

			if(hash.containsKey("DRUG_CLASS_"+itemnum))
    			paramstring=paramstring.append(hash.get( "DRUG_CLASS_"+itemnum ).toString()).append(",");
				//paramstring += hash.get( "DRUG_CLASS_"+itemnum ).toString() + ",";

			if(hash.containsKey("AVLINDB_"+itemnum))
            	paramstring=paramstring.append(hash.get( "AVLINDB_"+itemnum ).toString()).append(",");
			   //paramstring += hash.get( "AVLINDB_"+itemnum ).toString() + ",";

			if(hash.containsKey("DB_MODE_"+itemnum))
				paramstring=paramstring.append(hash.get( "DB_MODE_"+itemnum ).toString()).append(",");
				//paramstring += hash.get( "DB_MODE_"+itemnum ).toString() + ",";

		}
		out.println(paramstring);
		bean.setHashData(paramstring.toString());
	}
%>
</FORM>
</BODY>
</HTML>

<%
putObjectInBean(bean_id,bean,request);
%>

