

 <%@ page contentType="text/html;charset=UTF-8"  import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eST.ModifyDocumentDetails.label" bundle="${st_labels}"/></title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../eST/js/StDuoHeader.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
			<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		 <script>
        function_id				=		 "<%= request.getParameter("function_id") %>"
		
		
    </script>
	</head>
<body >
<%
	String codeDisabled						=				"";
	String docNoDisabled					=				"";
	String disabled							=				"";
	String sys_date							=				"";

	String doc_dateDisabled					=				"";
	String item_classDisabled				=				"";
	String item_classDisable				=				"";
	String from_Store_1						=				"";
	String documenttype						=				"";
	String documdate						=				"";

	String isAutoNo							=				 "No";
	String bean_id							=				request.getParameter("bean_id");
	String bean_name						=				request.getParameter("bean_name");
	String fromstorecode					=				request.getParameter("fromstorecode");
	String doctypecode						=				request.getParameter("doctypecode");
	String documentdate						=				request.getParameter("documentdate");
	String mode								=				request.getParameter("mode");
	String from_store_disabled              = "";
	String sales_req_yn					= "N";
	
	//String function_id					=				request.getParameter("function_id");
	
	String default_value					=				"<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---	"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
	StDuoHeaderBean bean					=				(StDuoHeaderBean) getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);
	String sql_from_store					=				bean.getSql_from_store();

	if((sql_from_store.equals("")||(sql_from_store==null)))
	{	
		sql_from_store						=				"SQL_ST_STOCK_TFR_FROM_STORE";
			bean.setSql_from_store(sql_from_store);
			bean.setFrom_store_code(fromstorecode);
		
	}
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	
	
	String sql_to_store						 =				bean.getSql_to_store();
	if((sql_to_store.equals("")||(sql_to_store==null)))
	{	sql_to_store						=				"SQL_ST_STOCK_TO_STORE";
		
			bean.setSql_to_store(sql_to_store);
			
	}

	
	String from_store_legend				=			 request.getParameter("from_store_legend");
	String storeCodeDisabled				=			 request.getParameter("store_code_disabled");
	String issue_flag						=			 request.getParameter("issue_flag");
	String requestFromStore					=	"";

	if (from_store_legend == null) {
		from_store_legend					=			"From Store";
	}
	String to_store_legend					=			request.getParameter("to_store_legend");
	if (to_store_legend == null) {
		to_store_legend						=			"To Store";
	}
	documenttype							=			bean.checkForNull(bean.getDoc_type_code());
	if(documenttype.equals(""))
	{
		bean.setDoc_type_code(doctypecode);
	}
    documdate								=			bean.checkForNull(bean.getDoc_date());
String trn_type=bean.getTrn_type();
if(documdate.equals(""))
{
	
		bean.setDoc_date(documentdate);
}
	bean.setSql_from_store(sql_from_store);
	bean.setSql_to_store(sql_to_store);
	if (bean.getMode().equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
		// code added for Item class Modify on 15/11/2003 
			 bean.getDoc_Date_Details();
			 from_Store_1					=			bean.checkForNull(bean.getFrom_store_code());
			
			 if(from_Store_1.equals(""))
			bean.setFrom_store_code(fromstorecode);
			 
			 if(bean.getDoc_DateModify().equals("N"))
			doc_dateDisabled				=		 "disabled";
			if(bean.getItem_ClassModify().equals("Y"))
			item_classDisable				 = "Y";
			// ended
			//Added by Rabbani#AMS-CRF-0068(49822) on 12-AUG-2014  Starts
			  sales_req_yn					=			bean.checkForNull(request.getParameter("sales_req_yn"),"N");
		 
		      if(sales_req_yn.equals("Y"))
		       from_store_disabled = "disabled"; 
	   }


	if (bean.getMode().equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {		
		codeDisabled					=		"disabled";
		docNoDisabled					=		"disabled";

		// Code added to check Doc Date Modify added on 15/11/2003
		 bean.getDoc_Date_Details();
		
		if(bean.getDoc_DateModify().equals("N"))
			doc_dateDisabled			=			"disabled";
			item_classDisabled			=			 "disabled";
		 if(bean.getItem_ClassModify().equals("Y"))
			item_classDisable			=			"Y";
		 // Ended
	}
	else{
		try { 
			
			boolean 	autono			 =			 bean.isDocNoAutoGenYN(bean.getDoc_type_code());
			if (autono) {
				isAutoNo  ="Yes";
			}
			docNoDisabled = autono?"disabled":"";
		}
		catch (Exception exception) {
			
			exception.printStackTrace();
		}
	}
	sys_date							=			bean.getSystemDate();
	String doc_date						=			bean.getDoc_date();

 if(!locale.equals("en")){
	 doc_date							=			com.ehis.util.DateUtils.convertDate(doc_date,"DMY","en",locale);
  }

	String def_doc_yn = (String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_DEF_DOC_GEN_YN_SELECT"),bean.getDoc_type_code()).get("DOC_NUM_GEN_FLAG");
  
  if(sql_from_store.equals("SQL_ST_REQUEST_FROM_STORE_SELECT_FOR_AUTH_AT_ISS")){
	  ArrayList sqlParam = new ArrayList();

		sqlParam.add(bean.getLoginFacilityId());
		sqlParam.add(bean.getLoginById());
		sqlParam.add(bean.getLanguageId());
	String sql="SELECT   x.parent_store_code, y.short_desc FROM (SELECT DISTINCT stp.parent_store_code FROM st_store_parent_store stp, mm_store mm, st_user_access_for_store st, st_store ststr WHERE st.store_code = mm.store_code AND st.store_code = ststr.store_code AND (    st.iss_allowed_yn = 'Y' AND ststr.iss_allowed_yn = 'Y' ) AND mm.eff_status = 'E' AND stp.parent_store_code = mm.store_code AND mm.facility_id = ? AND st.user_id = ?) x, mm_store_lang_vw y WHERE x.parent_store_code = y.store_code AND language_id = ? ORDER BY 2, 1";
	//System.out.println("sql_from_store=at bean==>"+sql);
	requestFromStore			=		bean.getListValues(sql, sqlParam,bean.getFrom_store_code());
	}else{
	requestFromStore				=	bean.getRequestFromStore();	
	}
	
%>
<form name="formStGeneralHeaderForMultiStore" id="formStGeneralHeaderForMultiStore">
	<table border='0' cellpadding='2' cellspacing='0' width='100%' height='100%' align=center>
				<tr>
					<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<%	if((mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))&&(bean.getTo_store_code()==null)) {
						
%> 
					<td class="fields">&nbsp;
					<select name="doc_type_code" id="doc_type_code" <%=codeDisabled%> onChange="checkDoc_type_code()">
					<%=bean.getDoc_type_code_List()%></select>
					<%=bean.getImage("M")%>
					<%}%>
</td>
		<%	if(((mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))||(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))))&&(bean.getTo_store_code()!=null)) {
						if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){ // ML-BRU-SCF-1681
					
			%> 
					<td class="fields">&nbsp;
					<select name="doc_type_code" id="doc_type_code" <%=codeDisabled%> onChange="checkDoc_type_code()" onFocus="loadItemClasses(from_store_code,to_store_code);setItem_class('<%=bean.getItem_class_code()%>');"  >
					<%=bean.getDoc_type_code_List()%></select>
					<%=bean.getImage("M")%>
					<!-- ML-BRU-SCF-1681 starts  -->
<%
					}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
%>
                    <td class="fields">&nbsp;
					<select name="doc_type_code" id="doc_type_code" <%=codeDisabled%> onChange="checkDoc_type_code()" onFocus="loadItemClasses(from_store_code,to_store_code);setItem_class('<%=bean.getItem_class_code()%>');"  >
					<option VALUE="<%=bean.getDoc_type_code()%>"><%=bean.getDoc_type_desc()%></option></select>
					<%=bean.getImage("M")%>
					<%}
					//ML-BRU-SCF-1681 ends 
					}%>
					</td>
					<td  class="label"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
					<td class="fields">&nbsp;
					<input type="text" class="NUMBER" value="<%=bean.getDoc_no()%>" name="doc_no" maxLength="8" size="8" onKeyPress="return isValidInteger();" <%=codeDisabled%> <%=docNoDisabled%> onBlur="checkIntegerFormat(this);">
					<%if(bean.checkForNull(def_doc_yn).equals("N")){%>
						<%=bean.getImage("M")%>
					<%}%>
					</td>
					<td  class="label">
					<fmt:message key="Common.DocDate.label" bundle="${common_labels}"/>
					</td>
					<td class="fields">	&nbsp;
						<input type="text" value="<%=doc_date%>" name="doc_date" id="doc_date" maxLength="10" size="10" <%=doc_dateDisabled%> onBlur="CheckDateLeap(this,'DMY','<%=locale%>');"><!-- CheckDate(this); removed for Leap year issue, added CheckDateLeap(this,'DMY','<%=locale%>') in doc_date by Badmavathi for SRR20056-SCF-9539 -->
						<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date');"  <%=doc_dateDisabled%> ></img>
						<%=bean.getImage("M")%>
					</td>
				</tr>			
				<tr>
					<td  class="label"><fmt:message key="Common.DocRef.label"   bundle="${common_labels}"/></td>
					<td class="fields">&nbsp
					
					<input type="text" value="<%=bean.getDoc_ref()%>" name="doc_ref"  maxLength="20" size="20"  <%=disabled%>></td>

					<td  class="label"><fmt:message key="Common.FromStore.label" bundle="${common_labels}"/></td>
					
					<td class="fields">&nbsp;
					<select name="from_store_code" id="from_store_code"  onChange = "loadParentStore('<%=issue_flag%>', this); loadItemClasses(from_store_code,to_store_code);" <%=from_store_disabled%> <%=codeDisabled%> <%=storeCodeDisabled%>>
					<%=requestFromStore%></select><%=bean.getImage("M")%>
					</td>
					<%if(trn_type.equals("PRQ")){%>
					<td  class="label"><fmt:message key="eST.ToDepartment.label" bundle="${st_labels}"/></td>
					<%}else{%>
					<td  class="label"><fmt:message key="Common.ToStore.label" bundle="${common_labels}"/></td>
					<%	
					}
if((!mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")))&&(bean.getTo_store_code()==null))  {
%> 
					<td class="fields">&nbsp;

					<select name="to_store_code" id="to_store_code" onChange="loadItemClasses(from_store_code,to_store_code);" <%=codeDisabled%> <%=storeCodeDisabled%>>
					<%=bean.getRequestToStore1()%></select>
					<%=bean.getImage("M")%></td>
					<%}%>
					<%	if((mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))&&(bean.getTo_store_code()!=null)) {
%> 
					<td class="fields">&nbsp;

					<select name="to_store_code" id="to_store_code" onChange="loadItemClasses(from_store_code,to_store_code);"   <%=codeDisabled%> <%=storeCodeDisabled%>>
					<%=bean.getRequestToStore1()%></select>
					<%=bean.getImage("M")%></td>
					<%}%>
		<%	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			%> 
			<td class="fields">&nbsp;

					<select name="to_store_code" id="to_store_code" onChange="loadItemClasses(from_store_code,to_store_code);"   <%=codeDisabled%> <%=storeCodeDisabled%>><%=bean.getRequestToStore1()%></option></select>
					<%=bean.getImage("M")%>
					<%}%>
					</td>
				</tr>			
				<tr>
					<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>	
					<td class="fields">&nbsp;
					
			<%	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
			%> 
						<select name="item_class_code" id="item_class_code" <%=item_classDisabled%> <%=storeCodeDisabled%>   >
							<%=default_value%>
						</select>
						
<%}%>
						
		<%if((mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")))) {
			%> 
						<select name="item_class_code" id="item_class_code"  <%=item_classDisabled%> <%=storeCodeDisabled%> >
							<%=bean.getItemClass()%>
						</select>
						<%}%>
						<%
							if(item_classDisable.equals("Y"))
							{
						%>
							<%=bean.getImage("M")%>
							<%
							}
							%>
							
					</td>
					<td  class="label">&nbsp;</td>
					<td  class="label">&nbsp</td>
					<td  class="label">&nbsp;</td>
					<td  class="label" >&nbsp</td>
				</tr>			
				<tr>
					<td  colspan='6'  align="right"><input type="button" name="record" id="record" value= '<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  class="button" onClick="setItemDesc(item_class_code);saveAndExit(); setToStore(to_store_code);">
					<input type=reset name="reset" id="reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>'   class="button">
					&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td  colspan='6'></td>
				</tr>
	</table>
	<input type="hidden" name=sys_date				value="<%=sys_date%>">
	<input type="hidden" name="finalize_yn" id="finalize_yn"			value="No">
	<input type="hidden" name="autono_yn" id="autono_yn"			value="<%=isAutoNo%>">
	<input type="hidden" name="mode" id="mode"				value="<%=mode%>">
	<input type="hidden" name="item_classDisable" id="item_classDisable"   value="<%=item_classDisable%>" >
	<input type="hidden" name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">


	
</form>
<%
		putObjectInBean(bean_id,bean,request);
		
%>
</body>
</html>

