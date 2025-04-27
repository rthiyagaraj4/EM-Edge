<!DOCTYPE html>
<%@ page import="java.util.*, eST.Common.*, eST.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");

		
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script>
	<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/TrnDocType.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%
	String doc_type_code	=	request.getParameter("doc_type_code");
	String doc_type_desc	=	request.getParameter("doc_type_desc");
	String trn_type			=	request.getParameter("trn_type");
	String trn_type_desc	=	request.getParameter("trn_type_desc");


//	String orderBy[] = request.getParameterValues("orderbycolumns");
	boolean searched = (request.getParameter("searched") == null) ?false:true;
	String classvalue = "";
		HashMap sqlMap				=		new HashMap();
		HashMap funcMap				=		new HashMap();
		ArrayList displayFields		=		new ArrayList();
		ArrayList chkFields			=		new ArrayList();
		ArrayList result			=		new ArrayList();
		ArrayList records			=		new ArrayList();

	try{
		TrnDocTypeBean bean = (TrnDocTypeBean)getBeanObject( "trnDocTypeBean","eST.TrnDocTypeBean",request ) ;  

		doc_type_code	=CommonBean.checkForNull(doc_type_code)+"%";;
		doc_type_desc	=CommonBean.checkForNull(doc_type_desc)+"%";;
		trn_type		=CommonBean.checkForNull(trn_type	)+"%";;
		trn_type_desc	=CommonBean.checkForNull(trn_type_desc)+"%";;
		
		String interface_to_external_po_yn= CommonBean.checkForNull((String)bean.fetchRecord("SELECT NVL (INTERFACE_TO_EXTERNAL_PO_YN, 'N') INTERFACE_TO_EXTERNAL_PO_YN FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID = ?",(String)session.getAttribute("ACC_ENTITY_ID")).get("INTERFACE_TO_EXTERNAL_PO_YN"),"N");
		if(interface_to_external_po_yn.equals("Y")){
			//sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_DOC_TYPE_QUERY_RESULT"));
			sqlMap.put("sqlData","SELECT ss.doc_type_code doc_type_code, am.short_desc doc_type_desc, ss.trn_type trn_type, st.long_desc trn_type_desc, applicable_to_ph_yn FROM st_trn_doc_type ss,sy_doc_type_master_lang_vw am, st_trn_type_lang_vw st,st_acc_entity_param d WHERE ss.doc_type_code = am.doc_type_code AND ss.trn_type = st.trn_type AND ss.facility_id LIKE ? AND ss.doc_type_code LIKE UPPER (?) AND UPPER (am.short_desc) LIKE UPPER (?) AND ss.trn_type LIKE UPPER (?) AND UPPER (st.long_desc) LIKE UPPER (?) AND am.language_id = st.language_id AND am.language_id = ? AND (st.trn_type not in ('PRQ') OR st.trn_type = 'PRQ'  AND d.ACC_ENTITY_ID=? and d.INTERFACE_TO_EXTERNAL_PO_YN='Y')");
		}else{
			sqlMap.put("sqlData", "SELECT SS.DOC_TYPE_CODE DOC_TYPE_CODE, AM.SHORT_DESC DOC_TYPE_DESC, SS.TRN_TYPE TRN_TYPE, ST.LONG_DESC TRN_TYPE_DESC, APPLICABLE_TO_PH_YN FROM ST_TRN_DOC_TYPE SS,SY_DOC_TYPE_MASTER_LANG_VW AM, ST_TRN_TYPE_LANG_VW ST WHERE SS.DOC_TYPE_CODE = AM.DOC_TYPE_CODE AND SS.TRN_TYPE = ST.TRN_TYPE AND SS.FACILITY_ID LIKE ? AND SS.DOC_TYPE_CODE LIKE UPPER (?) AND UPPER (AM.SHORT_DESC) LIKE UPPER (?) AND SS.TRN_TYPE LIKE UPPER (?) AND UPPER (ST.LONG_DESC) LIKE UPPER (?) AND AM.LANGUAGE_ID = ST.LANGUAGE_ID AND AM.LANGUAGE_ID = ? AND SS.TRN_TYPE NOT IN ('PRQ')");
		}
		//sqlMap.put("sqlData","SELECT ss.doc_type_code doc_type_code, am.long_desc doc_type_desc, ss.trn_type trn_type, st.long_desc trn_type_desc, applicable_to_ph_yn FROM st_trn_doc_type ss,sy_doc_type_master_lang_vw am, st_trn_type_lang_vw st,st_acc_entity_param d WHERE ss.doc_type_code = am.doc_type_code AND ss.trn_type = st.trn_type AND ss.facility_id LIKE ? AND ss.doc_type_code LIKE UPPER (?) AND UPPER (am.long_desc) LIKE UPPER (?) AND ss.trn_type LIKE UPPER (?) AND UPPER (st.long_desc) LIKE UPPER (?) AND am.language_id = st.language_id AND am.language_id = ? AND (st.trn_type not in ('PRQ') OR st.trn_type = 'PRQ'  AND d.ACC_ENTITY_ID=? and d.INTERFACE_TO_EXTERNAL_PO_YN='Y')");
		
			//SQL_SS_SURGERYTYPE_SQLDATA);
			//SQL_SS_SURGERYTYPE_QUERYCRIT);

		//The fields are going to be display

		displayFields.add("doc_type_code");
		displayFields.add("doc_type_desc");
		displayFields.add("trn_type");
		displayFields.add("trn_type_desc");

		//The fields are going to be in where condition * should match with the query
		chkFields.add( (String)session.getAttribute("facility_id"));
		chkFields.add( doc_type_code);
		chkFields.add( doc_type_desc);
		chkFields.add( trn_type		);
		chkFields.add( trn_type_desc);
		chkFields.add( locale);
		if(interface_to_external_po_yn.equals("Y")){
			chkFields.add( (String)session.getAttribute("ACC_ENTITY_ID"));
		}


		// Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );



		result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
		%>
			<table cellpadding=0 cellspacing=0 width="100%" align="center">
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;
				<%
					out.println(result.get(1));
				%>
				</td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
				<th><fmt:message key="Common.DocTypeCode.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.DocTypeDescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.transactiontype.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.TRNTypeDescription.label" bundle="${common_labels}"/></th>
		<%
			for(int recCount=2; recCount<result.size(); recCount++) {
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
		%>
				<tr onClick="Modify(this);" >
		<%

				String link_columns = "1";
				records=(ArrayList) result.get( recCount );
				
				for(int colCount=0; colCount<records.size(); colCount++){


					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
		%>
						<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'>  <%=(String)records.get( colCount )%>    </font></td>
		<%
					}
					else{
		%>
						<td class="<%=classvalue%>" onclick="disableClick(event);"><%=(String)records.get( colCount )%></td>
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
		} 
		else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				history.go(-1);
				//alert("<%=chkFields%>");
				//alert("<%=result%>");//history.go(-1);
			</script>
		<%
		}
		out.println(CommonBean.setForm ( request ,"../../eST/jsp/TrnDocTypeQueryResult.jsp", searched) );
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}finally{
			sqlMap.clear();	
			funcMap.clear();
			displayFields.clear();
			chkFields.clear();		
			result.clear();		
			records.clear();		
		}
%>
</body>
</html>

