<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.sql.*,webbeans.eCommon.*"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	    request.setCharacterEncoding("UTF-8");
		String locale					=		(String)session.getAttribute("LOCALE");
		
//		String sStyle					=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
<%
	try {
	String authorize					=		"No";
	String mode;	
	String trn_type;
	String codeDisabled					=		"";
//	String doc_dateDisabled				=		"";
//	String item_classDisabled			=		"";
	String fromstorecode				=		"";
	String doctypecode					=		"";
//	String doctypecode					=		"";
		
	String bean_id						=		request.getParameter("bean_id");
	System.err.println("bean_idbean_id" +bean_id);
	if (bean_id == null)	{
		bean_id							=		"stDuoHeaderBean";
	}
	String bean_name					=		request.getParameter("bean_name");
	if (bean_name == null)	{
		bean_name						=		"eST.Common.StDuoHeaderBean";
	}
	System.err.println("bean_name" +bean_name);
	StDuoHeaderBean bean				=		(StDuoHeaderBean) getBeanObject(bean_id, bean_name,request );
	String doc_type_code				=		bean.checkForNull(request.getParameter("doc_type_code")) ;
	String doc_no						=		bean.checkForNull(request.getParameter("doc_no")) ;
	String doc_date						=		bean.checkForNull(request.getParameter("doc_date")) ;
	String doc_ref						=		bean.checkForNull(request.getParameter("doc_ref")) ;
	String from_store_code				=		bean.checkForNull(request.getParameter("from_store_code")) ;
	String to_store_code				=		bean.checkForNull(request.getParameter("to_store_code")) ;

	String sql_from_store				=		bean.checkForNull(request.getParameter("sql_from_store")) ;
	String sql_to_store					=		bean.checkForNull(request.getParameter("sql_to_store")) ;
	String item_class_code				=		bean.checkForNull(request.getParameter("item_class_code")) ;
	String	item_class_desc				=		(request.getParameter( "item_class_desc" )!=null ? (request.getParameter("item_class_desc").trim()):"" );
	String	function_id				=		(request.getParameter( "function_id" )!=null ? (request.getParameter("function_id").trim()):"" );
	String sales_req_yn				=		bean.checkForNull(request.getParameter("sales_req_yn"),"N") ;
	String site_alna 				=		bean.checkForNull(request.getParameter("site_alna"),"false") ;   //Added for NMC-JD-CRF-0174 
	
	bean.setFunctionId(function_id);

	
	if(item_class_desc==null)
		{	item_class_desc				=		"";
		}

	//String docNoDisabled				=		"";


	String Modal_Window_Open			=		bean.checkForNull(request.getParameter("Modal_Window_Open")) ;
	String issue_flag					=		bean.checkForNull(request.getParameter("issue_flag"));
	mode								=		request.getParameter("mode");
	trn_type							=		bean.checkForNull(request.getParameter("trn_type")) ;
	codeDisabled						=		bean.checkForNull(request.getParameter("code_disabled"));

	// Changed for the purpose of displaying different legends for store codes

	String from_store_legend			= 	request.getParameter("from_store_legend");
	String to_store_legend				= 	request.getParameter("to_store_legend");  

			
	if(from_store_legend == null) {
		 from_store_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FromStore.label","common_labels");
		//from_store_legend = "From Store   ";
	}
	if(to_store_legend == null) {
		to_store_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ToStore.label","common_labels");
		//to_store_legend = "To Store   ";
	}
	if (bean_id.equals("stDuoHeaderBean")) {
	
		bean.clear();
		
	}
//System.out.println("beanbean.getStRepositoryValue(sql_from_store)eader===>"+bean.getStRepositoryValue(sql_from_store));
    bean.setSite_alna(site_alna);//Added for NMC-JD-CRF-0174 
	bean.setTrn_type(trn_type);
	bean.setSql_from_store(sql_from_store);
	bean.setLanguageId(locale);
	bean.setSql_to_store(sql_to_store);
	bean.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID"));

	String[] stParameters={bean.getLoginFacilityId(), bean.getLoginById(),bean.getLanguageId()};
	if (bean_id.equals("stDuoHeaderBean")) {
		if(sql_from_store.equals("SQL_ST_REQUEST_FROM_STORE_SELECT_FOR_AUTH_AT_ISS")){
	fromstorecode				=		(String)bean.fetchRecord("SELECT   x.parent_store_code, y.short_desc FROM (SELECT DISTINCT stp.parent_store_code FROM st_store_parent_store stp, mm_store mm, st_user_access_for_store st, st_store ststr WHERE st.store_code = mm.store_code AND st.store_code = ststr.store_code AND (    st.iss_allowed_yn = 'Y' AND ststr.iss_allowed_yn = 'Y' ) AND mm.eff_status = 'E' AND stp.parent_store_code = mm.store_code AND mm.facility_id = ? AND st.user_id = ?) x, mm_store_lang_vw y WHERE x.parent_store_code = y.store_code AND language_id = ? ORDER BY 2, 1",stParameters).get("STORE_CODE");
		}else{
		fromstorecode				=		(String)bean.fetchRecord(bean.getStRepositoryValue(sql_from_store),stParameters).get("STORE_CODE");
		 
		if(sales_req_yn.equals("Y")){ //Added by Rabbani#AMS-CRF-0068(49822) on 11-AUG-2014 
		fromstorecode = from_store_code;
		}

		}
	bean.setFrom_store_code(fromstorecode);
	if((bean.getFunctionId().equals("ST_AUTH_AT_ISSUE_STORE"))||((bean.getFunctionId().equals("ST_ISSUE_REQ_URG")))){
		
			if(sql_from_store.equals("SQL_ST_REQUEST_FROM_STORE_SELECT_FOR_AUTH_AT_ISS")){
			bean.setFrom_store_code((String)bean.fetchRecord("SELECT   x.parent_store_code, y.short_desc FROM (SELECT DISTINCT stp.parent_store_code FROM st_store_parent_store stp, mm_store mm, st_user_access_for_store st, st_store ststr WHERE st.store_code = mm.store_code AND st.store_code = ststr.store_code AND (    st.iss_allowed_yn = 'Y' AND ststr.iss_allowed_yn = 'Y' ) AND mm.eff_status = 'E' AND stp.parent_store_code = mm.store_code AND mm.facility_id = ? AND st.user_id = ?) x, mm_store_lang_vw y WHERE x.parent_store_code = y.store_code AND language_id = ? ORDER BY 2, 1",stParameters).get("PARENT_STORE_CODE"));

			}else{
			bean.setFrom_store_code((String)bean.fetchRecord(bean.getStRepositoryValue(sql_from_store),stParameters).get("PARENT_STORE_CODE"));


			}
	}
		
	}

	bean.initDoc_type_code_List();
	ServletContext context		=		getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode(mode);
	if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
		bean.initialize(trn_type);		
		bean.setItem_class_code(item_class_code);
		bean.setItem_class_desc(item_class_desc);
		
	}
	else {
		bean.initialize(trn_type, doc_type_code, doc_no, doc_date,  doc_ref,from_store_code,to_store_code,item_class_code);
		
	}

	if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		codeDisabled = "disabled";

		
	}
	authorize="Y";
//if (!((doc_type_code == null) ||(doc_type_code.equals(""))))
//	{ 
//	bean.setDoc_type_code(doc_type_code);
//	}

 doctypecode=bean.getDoc_type_code();

		


	try { 
	
		java.util.HashMap resultMap = bean.canAuthorize(bean.getFrom_store_code());

		
		if (trn_type.equals("REQ")) {
			authorize = (String)resultMap.get("REQ_AUTHORIZE_ALLOWED_YN");
		}
		else if (trn_type.equals("ISS")) {
			authorize = (String)resultMap.get("ISS_FINALIZE_ALLOWED_YN");
		}
		else if (trn_type.equals("URG")) {
			authorize = (String)resultMap.get("URG_FINALIZE_ALLOWED_YN");
		}
	
	}
	catch (Exception exception) {
		exception.printStackTrace();
	}
	if (authorize.equals("Y")) {
		authorize = "Yes";
	}
 if(!locale.equals("en")){
  doc_date=com.ehis.util.DateUtils.convertDate(doc_date,"DMY","en",locale);
  }
  else
	  {
  doc_date=doc_date;
	  }
	   
	  
	  %>
<%
putObjectInBean(bean_id,bean,request);
%>



	<table border=0 cellpadding=2 cellspacing=0  width='100%' height=20 align="center">
		<tr>
			<td class=ITEMSELECT width="12%"  >
				<span onClick="ModifyDocDetails('<%=issue_flag%>','<%=bean_id%>','<%=bean_name%>',<%=mode%>,'<%=from_store_legend%>','<%=to_store_legend%>','<%=fromstorecode%>','<%=doctypecode%>','<%=doc_date%>',document.forms[0].store_code_disabled.value)" style="cursor:pointer;color:#FFFF99">
					<b>
						<u>
							<fmt:message key="Common.Document.label" bundle="${common_labels}"/> :
						</u>
						
					</b>
				</span>
			</td>

			<td class=ITEMSELECT width='20%' nowrap>
				<span id="doc_type_desc">
					<b>

						<%=bean.checkForNull(bean.getDoc_type_desc())%>
						

					</b>
				</span>
				&nbsp;
				<span id="doc_no">
					<b>
						<%=(bean.getDoc_no().equals(""))?"":"/"+bean.getDoc_no()%>
					</b>
				</span>
			</td>
			<td class=ITEMSELECT  width='12%' >
				<b>
					<fmt:message key="Common.DocDate.label" bundle="${common_labels}"/> :
				</b>
			</td>
			<td class=ITEMSELECT  width='20%' id="td_doc_date">
							
				<b>
					<%=doc_date%> 
				</b>
			</td>
			<td class=ITEMSELECT  width='12%'  >
				<b>
					<fmt:message key="Common.DocRef.label"   bundle="${common_labels}"/>:
				</b>
				&nbsp;
			</td>
			<td class=ITEMSELECT  width='20%' id="doc_ref_id" nowrap>
				<b>
					<%=bean.getDoc_ref()%>
				</b>
			</td>
		</tr>
		<tr>
			<td class=ITEMSELECT width="12%" >
				<b>
				<fmt:message key="Common.FromStore.label" bundle="${common_labels}"/>:
					<!-- <%=from_store_legend%> : -->
				</b>
			</td>
			<td class=ITEMSELECT width='20%' id="td_from_store_code">
				<b>
					<%=bean.getFrom_store_desc()%>
				</b>
			</td>
			<td class=ITEMSELECT width='12%' >
				<b>
					<%if(trn_type.equals("PRQ")){%>
					<fmt:message key="eST.ToDepartment.label" bundle="${st_labels}"/>:
					<%}else{%>
					<fmt:message key="Common.ToStore.label" bundle="${common_labels}"/>:
					<%	
					}%>
					<!-- <%=to_store_legend%>  -->
				</b>
			</td>
			<%
				if(!(to_store_code==null || to_store_code.equals("") || to_store_code=="")){
						

			%>
			<td class=ITEMSELECT width='20%' id="td_to_store_code"><b><%=bean.checkForNull(bean.getTo_store_desc())%></b></td>
			<%
				}else{
					

			%>
			<td class=ITEMSELECT width='20%' id="td_to_store_code"><b></b></td>
			<%
				}
			%>
			<td class=ITEMSELECT width='12%' >
				<b>
				<fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/>:
				</b>
				&nbsp;
			</td>
			<td class=ITEMSELECT width='20%' id="item_class_legend">
			
				<b>
					<%  if (mode.equals("2")) { %>
				        	<!-- <%=bean.checkForNull(bean.getItem_class_desc())%>  -->
							<%=item_class_desc%>

				    <%  } else { %> 

				          <%=bean.checkForNull(bean.getItem_class_code())%> 

				    <%  }  %> 

				</b>
			</td>
		</tr>
	</table> 
	<input type="hidden"	 name="doc_no" id="doc_no"					 value="<%=bean.getDoc_no()%>">
	<input type="hidden"	 name="doc_ref" id="doc_ref"					 value="<%=bean.getDoc_ref()%>"> 
	<input type="hidden"	 name="doc_type_code" id="doc_type_code"			 value="<%=bean.getDoc_type_code()%>">
	<input type="hidden"	 name="doc_date" id="doc_date"				 value="<%=doc_date%>">
	<input type="hidden"	 name="to_store_code" id="to_store_code"			 value="<%=bean.checkForNull(bean.getTo_store_code())%>">
	<input type="hidden"	 name="from_store_code" id="from_store_code"			 value="<%=bean.getFrom_store_code()%>">
	<input type='hidden'	 name="item_class_desc" id="item_class_desc"			 value="">
	<input type='hidden'	 name="item_class_code" id="item_class_code"			 value="<%=bean.checkForNull(bean.getItem_class_code())%>">
	<input type='hidden'	 name="finalize_yn" id="finalize_yn"				 value="No">
	<input type='hidden'	 name="authorize_yn" id="authorize_yn"			 value="<%=authorize%>">
	<input type='hidden'	 name="autono_yn" id="autono_yn"				 value="No">
	<input type="hidden"	 name="to_store_code_disabled" id="to_store_code_disabled"   value="">
	<input type="hidden"	 name="from_store_code_disabled" id="from_store_code_disabled" value="">
	<input type='hidden'     name="item_class_code_disabled" id="item_class_code_disabled" value="">
	<input type="hidden"	 name="store_code_disabled" id="store_code_disabled"		 value="false">
	<input type='hidden'	 name="from_store_legend" id="from_store_legend"		 value="<%=from_store_legend%>">
	<input type='hidden'	 name="to_store_legend" id="to_store_legend"			 value="<%=to_store_legend%>">
	<input type='hidden'	 name="code_disabled" id="code_disabled"			 value="<%=codeDisabled%>">
	<input type="hidden"	name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
	<input type="hidden"	name="sales_req_fm_store" id="sales_req_fm_store"			value="<%=sales_req_yn%>">
	 

	<%
		if(Modal_Window_Open.equals("Yes")){
	%>
		<script> 			ModifyDocDetails("<%=issue_flag%>","<%=bean_id%>","<%=bean_name%>","<%=mode%>","<%=from_store_legend%>","<%=to_store_legend%>","<%=fromstorecode%>","<%=doctypecode%>","<%=bean.getDoc_date()%>",'document.forms[0].store_code_disabled.value');
		</script>
	<%
		}
}
catch (Exception ex) {
	ex.printStackTrace();
}
	%>

