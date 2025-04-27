<%@ page contentType="text/html;charset=UTF-8"  import="eST.AdjustStockBean,eST.Common.StHeaderBean,eST.SalesBean" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<title><fmt:message key="eST.ModifyDocumentDetails.label" bundle="${st_labels}"/></title>
<%
		 request.setCharacterEncoding("UTF-8");
		 String locale						=			(String)session.getAttribute("LOCALE");
		
		String sStyle						=			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/StMessages.js"></script>
		<script language="JavaScript" src="../../eST/js/StHeader.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
        <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
<body onLoad="FocusFirstElement()">
<%


	String codeDisabled			=	"";
	String docNoDisabled		=	"";
	String disabled				=	"";
	String sys_date				=	"";
	String doc_dateDisabled		=	"";
	String item_classDisabled	=	"";
	String item_classDisable	=	"";
	String bean_id				=	CommonBean.checkForNull(request.getParameter( "bean_id" ),"stHeaderBean") ;
	String bean_name			=	CommonBean.checkForNull(request.getParameter( "bean_name" ),"eST.Common.StHeaderBean") ;
	String store_code_disabled	=	CommonBean.checkForNull(request.getParameter( "store_code_disabled" ),"") ;
	String param1				=	request.getParameter("param1"); 
	

	//Added on 6/19/2005 by Sabari	

	StHeaderBean bean			=	null;
	if(bean_id.equals("adjustStockBean")){
		bean					=	(StHeaderBean) ((AdjustStockBean)getBeanObject( bean_id,bean_name,request )).getStHeaderBean();
	}else{
		bean					=	(StHeaderBean) getBeanObject( bean_id,bean_name,request );
	} 
	if(param1.equals("null")&&(bean.getMode().equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))){
		bean.setItem_class_code("");
	}
	
	bean.setLanguageId(locale);
	SalesBean bean1				=	(SalesBean)getBeanObject( "salesBean", "eST.SalesBean", request );
	bean1.setLanguageId(locale);
	/*Variable added for PE by Mahesh on 4/22/2010*/
	boolean doc_no_gen_yn = bean.isDocNoAutoGenYN(bean.getDoc_type_code());
	String store_list = bean.getStore_code_List();
	/*PE 4/22/2010*/
	if (bean.getMode().equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
		bean.getDoc_Date_Details();
		if(bean.getDoc_DateModify().equals("N")){
			doc_dateDisabled					=				"disabled";
		}
		if(bean.getItem_ClassModify().equals("Y")){
			item_classDisable					=				"Y";
		}
	}
	if (bean.getMode().equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		codeDisabled							=				"disabled";
		docNoDisabled							=				"disabled";
        bean.getDoc_Date_Details();
		
		if(bean.getDoc_DateModify().equals("N")){
			doc_dateDisabled					=				"disabled";
		}

		if(bean.getItem_ClassModify().equals("Y")){
			item_classDisable					=				"Y";
		}
	}else{
		try { 
			docNoDisabled						=				doc_no_gen_yn?"disabled":"";
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	sys_date									=				bean.getSystemDate();
	String doc_date_conv						=				bean.getDoc_date();

	if(!locale.equals("en")){
		doc_date_conv	=	com.ehis.util.DateUtils.convertDate(doc_date_conv,"DMY","en",locale);
	}else{
		doc_date_conv	=	doc_date_conv;
	}
	/* PE on 4/22/2010 Mahesh
	String def_doc_yn = (String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_DEF_DOC_GEN_YN_SELECT"),bean.getDoc_type_code()).get("DOC_NUM_GEN_FLAG");
	*/
%>
<form name="formStGeneralHeaderForSingleStore" id="formStGeneralHeaderForSingleStore">
	<table border='0' cellpadding='0' cellspacing='0' width='98%' height='90%' >
				<tr>
					<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class="fields">&nbsp;<select name="doc_type_code" id="doc_type_code" <%=codeDisabled%> onChange="checkDoc_type_code()"  onblur="chk_doc_type();" >
						<%=bean.getDoc_type_code_List()%>
					</select><%=bean.getImage("M")%></td>
					<td  class="label"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
					<td class="fields">&nbsp;<input type="text" class="NUMBER" value="<%=bean.getDoc_no()%>" name="doc_no" id="doc_no" maxLength="8" size="8" onKeyPress="return isValidInteger();" <%=codeDisabled%> <%=docNoDisabled%> onBlur="checkIntegerFormat(this);">
					<%// PE on 4/22/2010if((bean.checkForNull(def_doc_yn)).equals("N")){%>
					 <%-- <%if(doc_no_gen_yn){%>
						<%=bean.getImage("M")%>
					<%}%> --%> 
					</td>
					<td  class="label"><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></td>
					<td class="fields">
						&nbsp;
						<input type="text" value="<%=doc_date_conv%>" name="doc_date" id="doc_date"  maxLength="10" size="10" <%=doc_dateDisabled%> onBlur="CheckDateLeap(this,'DMY','<%=locale%>');"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date');"  <%=doc_dateDisabled%> ></img><%=bean.getImage("M")%><!-- CheckDate(this); removed for Leap year issue, added CheckDateLeap(this,'DMY','<%=locale%>') by Badmavathi for SRR20056-SCF-14071 -->
					</td>
					
				</tr>			
				<tr>
					<td  class="label"><fmt:message key="Common.DocRef.label"   bundle="${common_labels}"/></td>
					<td class="fields">&nbsp<input type="text" value="<%=bean.getDoc_ref()%>" name="doc_ref" id="doc_ref"  maxLength="20" size="20"  <%=disabled%>></td>
					<td  class=label><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
					<td  colspan='3' class='fields'>&nbsp;<select name=store_code id=store_code 
					onBlur = "loadItemClasses(this,this);" <%=codeDisabled%> <%=store_code_disabled%> value = '<%=store_list%>'>
					<%=store_list%>
					</select><%=bean.getImage("M")%></td>
				</tr>			
	<tr>
					<!-- code added to displat Item class 15/11/2003 -->
					<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>	
					<td  class="fields">&nbsp;
						<select name="item_class_code" id="item_class_code" onBlur=" setItemClass(this);"    <%=item_classDisabled%> <%=codeDisabled%> <%=store_code_disabled%> >
							<%=bean.getItemClass()%>
						</select>
						<%
							if(item_classDisable.equals("Y"))
							{
						%>
							<%=bean.getImage("M")%>
							<%
							}
							%>
						</td>
						<td>
						&nbsp;
					</td>
					<!-- code Ended -->
		<td  colspan='5'  align='right'><input type="button" name="record" id="record" value=  '<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'   class="button" onClick="setItemClass(item_class_code);saveAndExit();">
		<input type=reset name="reset" id="reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' class="button">
		&nbsp;&nbsp;</td>
	</tr>
	</table>
	<input type= hidden		name=sys_date				value="<%=sys_date%>">
	<input type="hidden"	name="bean_id" id="bean_id"				value="<%=bean_id%>">
	<input type="hidden"	name="bean_name" id="bean_name"			value="<%=bean_name%>">
	<input type="hidden"	name="mode" id="mode"					value="<%=bean.getMode()%>">
	
	<input type="hidden"	name="item_classDisable" id="item_classDisable"	value="<%=item_classDisable%>" >
	<input type="hidden"	name="site_id" id="site_id"	value="<%=bean1.getCustomerID()%>" >
    <input type="hidden"	name="function_id" id="function_id"	value="<%=bean.getfunction_id()%>" >
</form>
<%
		//putObjectInBean(bean_id,bean,request);
%>
</body>

</html>


