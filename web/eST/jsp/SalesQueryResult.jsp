<!DOCTYPE html>
<%@page import="java.util.HashMap,java.util.ArrayList,java.util.Properties,eST.*,java.lang.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
	 
 request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
		<script language="javascript" src="../../eST/js/Sales.js"></script>
        <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body>
	<%
		String doc_type_code = request.getParameter("doc_type_code");
		String doc_no = request.getParameter("doc_no");
		String doc_date = com.ehis.util.DateUtils.convertDate(request.getParameter("doc_date"),"DMY",locale,"en");//MODIFIED TO VIEW RECORDS IN TAHI LAG BY CHANDRASHEKAR A
        String to_doc_date = com.ehis.util.DateUtils.convertDate(request.getParameter("to_doc_date"),"DMY",locale,"en") == null ? "" : com.ehis.util.DateUtils.convertDate(request.getParameter("to_doc_date"),"DMY",locale,"en") ; 
		String store_code= request.getParameter("store_code");
		String patient_id= request.getParameter("patient_id");
		String language_id= request.getParameter("language_id");
		String item_class_code = request.getParameter("item_class_code");
		String sales_priority_type = request.getParameter("sales_priority_type");
		String nursing_unit_code = request.getParameter("nursing_unit_code");
		eST.SalesBean bean = (eST.SalesBean)getBeanObject( "salesBean",  "eST.SalesBean" ,request);
		bean.setLanguageId(locale);
        

		boolean searched = (request.getParameter("searched") == null) ?false:true;
		String classvalue = "";
		HashMap sqlMap				=		new HashMap();
		HashMap funcMap				=		new HashMap();
		ArrayList displayFields		=		new ArrayList();
		ArrayList chkFields			=		new ArrayList();
		ArrayList result			=		new ArrayList();
		ArrayList records			=		new ArrayList();
		try{
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			doc_type_code = CommonBean.checkForNull(doc_type_code,"%");
			doc_no = CommonBean.checkForNull(doc_no,"%");
			doc_date = CommonBean.checkForNull(doc_date,"%");
		//	to_doc_date = CommonBean.checkForNull(to_doc_date,"%");
			store_code = CommonBean.checkForNull(store_code,"%");
			patient_id = CommonBean.checkForNull(patient_id,"%");
			item_class_code = CommonBean.checkForNull(item_class_code,"%");
			sales_priority_type = CommonBean.checkForNull(sales_priority_type,"%");
			nursing_unit_code = CommonBean.checkForNull(nursing_unit_code,"%");

	      //sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_SAL_HDR_QUERY_RESULT"));
		  //sqlMap.put("sqlData", "SELECT hdr.doc_type_code, sy.short_desc doc_type_desc,hdr.doc_no, TO_CHAR(hdr.doc_date,'dd/mm/yyyy')	doc_date, hdr.store_code,  fms.short_desc fm_store_desc, hdr.patient_id	FROM st_sal_hdr hdr, mm_store_lang_vw fms, sy_doc_type_master_lang_vw	sy,	st_user_access_for_store uaca  /*, st_acc_entity_param pa*/ WHERE hdr.doc_type_code = sy.doc_type_code	AND	hdr.store_code=	fms.store_code	AND	uaca.store_code	= hdr.store_code	AND hdr.finalized_yn='N' AND	uaca.sal_allowed_yn	= 'Y'  AND hdr.module_id=? AND hdr.doc_type_code LIKE ?	AND	TO_CHAR(hdr.doc_no)	LIKE  ?	AND	TO_CHAR(hdr.doc_date,'dd/mm/yyyy') LIKE ?	AND	hdr.store_code LIKE ? AND  NVL(hdr.item_class_code,'X')	LIKE ? AND uaca.user_id	= ? AND hdr.facility_id=? AND sy.language_id = fms.language_id AND sy.language_id = ? and nvl(hdr.ref_no,'%') like ? and hdr.patient_id like ? and NVL(hdr.priority,'%') like(?) and NVL(hdr.locn_code,'%') like(?)");
           
			//sqlMap.put("sqlData", "SELECT hdr.doc_type_code, sy.short_desc doc_type_desc,hdr.doc_no, TO_CHAR(hdr.doc_date,'dd/mm/yyyy')	doc_date, hdr.store_code,  fms.short_desc fm_store_desc, hdr.patient_id	FROM st_sal_hdr hdr, mm_store_lang_vw fms, sy_doc_type_master_lang_vw	sy,	st_user_access_for_store uaca  /*, st_acc_entity_param pa*/ WHERE hdr.doc_type_code = sy.doc_type_code	AND	hdr.store_code=	fms.store_code	AND	uaca.store_code	= hdr.store_code	AND hdr.finalized_yn='N' AND	uaca.sal_allowed_yn	= 'Y'  AND hdr.module_id=? AND hdr.doc_type_code LIKE ?	AND	TO_CHAR(hdr.doc_no)	LIKE  ?	AND	hdr.doc_date BETWEEN  TO_DATE (?, 'dd/mm/yyyy')  AND NVL (TO_DATE (?, 'dd/mm/yyyy'), SYSDATE)	AND	hdr.store_code LIKE ? AND  NVL(hdr.item_class_code,'X')	LIKE ? AND uaca.user_id	= ? AND hdr.facility_id=? AND sy.language_id = fms.language_id AND sy.language_id = ? and nvl(hdr.ref_no,'%') like ? and hdr.patient_id like ? and NVL(hdr.priority,'%') like(?) and NVL(hdr.locn_code,'%') like(?)");
			
			String sql = "SELECT hdr.doc_type_code, sy.short_desc doc_type_desc,hdr.doc_no, TO_CHAR(hdr.doc_date,'dd/mm/yyyy')	doc_date, hdr.store_code,  fms.short_desc fm_store_desc, hdr.patient_id	FROM st_sal_hdr hdr, mm_store_lang_vw fms, sy_doc_type_master_lang_vw	sy,	st_user_access_for_store uaca  /*, st_acc_entity_param pa*/ WHERE hdr.doc_type_code = sy.doc_type_code	AND	hdr.store_code=	fms.store_code	AND	uaca.store_code	= hdr.store_code	AND hdr.finalized_yn='N' AND	uaca.sal_allowed_yn	= 'Y'  AND hdr.module_id=? 	AND	hdr.doc_date BETWEEN  TO_DATE (?, 'dd/mm/yyyy')  AND NVL (TO_DATE (?, 'dd/mm/yyyy'), SYSDATE)	AND	 uaca.user_id= ?  AND hdr.facility_id=? AND sy.language_id = fms.language_id AND sy.language_id = ? ";
			
			
				if(!(doc_type_code.equals("%"))){				
				sql = sql + " and hdr.doc_type_code =  " + " '"+doc_type_code+"' " ;					
				} 
				if(!(doc_no.equals("%"))){				
				sql = sql + " and to_char(hdr.doc_no) like  " + " '"+doc_no+"' " ;					
				} 
				if(!(store_code.equals("%"))){				
				sql = sql + " and hdr.store_code =  " + " '"+store_code+"' " ;					
				} 
				if(!(item_class_code.equals("%"))){				
				sql = sql + " and hdr.item_class_code =  " + " '"+item_class_code+"' " ;					
				} 
				if(!(nursing_unit_code.equals("%"))){				
				sql = sql + " and hdr.locn_code =  " + " '"+nursing_unit_code+"' " ;				
				} 
				if(!(patient_id.equals("%"))){				
				sql = sql + " and hdr.patient_id =  " + " '"+patient_id+"' " ;					
				} 
				if(!(sales_priority_type.equals("%"))){				
				sql = sql + " and hdr.priority =  " + " '"+sales_priority_type+"' " ;					
				} 
				if(!(bean.getRefNo()).equals("")){				
				sql = sql + " and hdr.ref_no =  " + " '"+bean.getRefNo()+"' " ;					
				} 

 
			displayFields.add("DOC_TYPE_DESC");
			displayFields.add("DOC_NO");
			displayFields.add("DOC_DATE");
			displayFields.add("FM_STORE_DESC");
//			displayFields.add("ITEM_CLASS_DESC");
			displayFields.add("DOC_TYPE_CODE");
			displayFields.add("STORE_CODE");

			chkFields.add(bean.getModuleId());
			chkFields.add(doc_date);
			chkFields.add(to_doc_date); //added by ganga
			
			// Changed by Shaiju on 08/02/2011 Starts
			if((bean.getModuleId()).equals("OT")){
				chkFields.add(bean.getSlateUserId());
			}else{
			chkFields.add(CommonBean.getLoginById());
			}
			// // Changed by Shaiju on 08/02/2011 Ends
			//chkFields.add(CommonBean.getLoginById());

			chkFields.add(CommonBean.getLoginFacilityId());
			chkFields.add(language_id);					



			sqlMap.put("sqlData", sql);
			// Adding function related array list into the HashMap
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			
			result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
	%>
			<table cellpadding=0 cellspacing=0 width="100%" align="center" >
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;
				<%
					out.println(result.get(1));
				%>
				</td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" >
				<tr>
					<th><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.Store.label" bundle="${common_labels}"/></th>
				</tr>		
		<%
			for(int recCount=2; recCount<result.size(); recCount++) {
				if (recCount % 2 == 0)
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
		%>
				<tr onClick="Modify(this);" >
		<%
				
				records=(ArrayList) result.get(recCount);
		%>
				<td class="<%=classvalue%>" onmouseover="this.style.cursor='pointer';" ><font class='HYPERLINK'><%=(String)records.get(0)%></font></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" ><%=records.get(1)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" ><%=com.ehis.util.DateUtils.convertDate((String)records.get(2),"DMY","en",locale)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(3)%></td>
				<td class='NODISPLAY'><%=records.get(4)%></td>
			</tr>
		<%
			}//
		%>
		</table>
		<!--
		* @Name - Priya
		* @Date - 21/12/2009
		* @Inc# - IN017084
		* @Desc - To avoid the duplication records display in Modify mode
		 -->
		<div  id='readOnlyDiv'  style="visibility:hidden;z-index:3;position:absolute;top:0px;width:1007px;height:500px;background-color:#CCCFFF;filter:alpha(opacity=80);" >
		<table border="0" align="center" width="100%" height="100%">
		<tr><td align="center">
			
			</td></tr>
		</table>
		</div>
		<%
			out.flush();
		} 
		else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				document.location.href="../../eCommon/html/blank.html";
				//history.go(-1);
			</script>
		<%
		}
		out.println(CommonBean.setForm (request ,"../../eST/jsp/SalesQueryResult.jsp", searched));
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

