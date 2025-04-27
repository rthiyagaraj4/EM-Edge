<!DOCTYPE html>
<%@ page  import=" eST.AdjustStockBean, eST.Common.StHeaderBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<%
	//System.out.println("in stheader....1...."+CommonBean.checkForNull(request.getQueryString()));
	
	String mode;
	String trn_type;
	String codeDisabled				=			"";
	request.setCharacterEncoding("UTF-8");
	String locale					=			(String)session.getAttribute("LOCALE");
	
	String bean_id					=			 CommonBean.checkForNull(request.getParameter( "bean_id" ),"stHeaderBean") ;
	String bean_name				=			 CommonBean.checkForNull(request.getParameter( "bean_name" ),"eST.Common.StHeaderBean") ;	
	
	//Added on 6/19/2005 by Sabari
	StHeaderBean bean				=			null;
	AdjustStockBean adjStBean		=			null;
	if(bean_id.equals("adjustStockBean")){
		adjStBean					=			(AdjustStockBean)getBeanObject( bean_id, bean_name,request);
		bean						=			(StHeaderBean) adjStBean.getStHeaderBean();
	}else
	{
		bean						=			(StHeaderBean)getBeanObject( bean_id, bean_name,request);
		
	}
	//System.out.println("in stheader....2....");
	//---
	String doc_type_code			=			bean.checkForNull(request.getParameter( "doc_type_code" )) ;
	String doc_no					=			bean.checkForNull(request.getParameter( "doc_no" )) ;
	String doc_date					=			bean.checkForNull(request.getParameter( "doc_date" )) ;
	String doc_ref					=			bean.checkForNull(request.getParameter( "doc_ref" )) ;
	String store_code				=			bean.checkForNull(request.getParameter( "store_code" )) ;
	String storeSQLID				=			bean.checkForNull(request.getParameter( "storeSQLID" )) ;
	String item_class_code			=			bean.checkForNull(request.getParameter("item_class_code"));	
	String module_id				=			bean.checkForNull(request.getParameter("module_id"));	
	String param1					=			request.getParameter( "param1" );
    String mfg_req_yn	= bean.checkForNull(request.getParameter( "mfg_req_yn" ), "N");//Added by suresh.r on 11-12-2014 against BRU-HIMS-CRF-080 beg
	//System.out.println("in stheader....3....");
	//if(doc_date.equals("")){
	//	doc_date = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	//}
	
	//bean.setLanguageId(locale);
	//	bean.initDoc_type_code_List1(locale);
	//String docNoDisabled			=			"";
	
	mode							=			request.getParameter( "mode" ) ;
	trn_type						=			bean.checkForNull(request.getParameter( "trn_type" )) ;
	
	if ((bean_id.equals("stHeaderBean"))&&( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT")))) {
		bean.clear() ;
	}
	bean.setLanguageId(locale);
	//adjStBean.setLanguageId(locale);

	bean.setTrn_type(trn_type);
	bean.setDefault_doc(bean.checkForNull(request.getParameter("default_doc"),trn_type));
	bean.initDoc_type_code_List();
	//bean.initDoc_type_code_List1(locale);

	//Added By Sakti Sankar on 01/11/2012 against Inc#35941
	if(trn_type.equals("CON")){
		trn_type = "SAL";
	}
	//Added ends

	ServletContext context			=			getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode(mode);
	bean.initStore_code_List(storeSQLID);

	//System.out.println("in stheader....5....");
	
	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )){
		bean.initialize(trn_type);
	}
	else{
		bean.initialize(trn_type, doc_type_code, doc_no, doc_date, doc_ref, store_code , item_class_code);
	}
	//	bean.initialize(trn_type, doc_type_code, doc_no, doc_date, doc_ref, store_code );
	if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		codeDisabled	=	"disabled";
	}
	if(module_id.equals("OT")&&( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT")))){
		String ot_doc_type =		bean.checkForNull((String)bean.fetchRecord("SELECT ST_DOC_TYPE_SLI FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID = ?",bean.getLoginFacilityId()).get("ST_DOC_TYPE_SLI"),"");
		bean.setDoc_type_code(ot_doc_type);
	}
	
if (!((doc_date == null) ||(doc_date.equals(""))))
	{ 
//doc_date=	com.ehis.util.DateUtils.convertDate(doc_date,"DMY",locale,"en");
	bean.setDoc_date(doc_date);
	}
 if (!((store_code == null) ||(store_code.equals(""))))
 {
	 bean.setStore_code(store_code);
 }
  if (!((item_class_code == null) ||(item_class_code.equals("")))){
	 bean.setItem_class_code(item_class_code);
  }
  if(!locale.equals("en")){
		doc_date	=	com.ehis.util.DateUtils.convertDate(doc_date,"DMY","en",locale);
  }
/*  Commented by Mahesh for PE
else{
		doc_date=doc_date;
  }*/
 System.out.println("in stheader....5...store_code...."+store_code+"..doc_date...."+doc_date+"....doc_type_code..."+doc_type_code+"....doc_no...."+doc_no);
 //System.out.println("in stheader....6...store_code...."+bean.getStore_code()+"..doc_date...."+doc_date+"....Doc_ref..."+bean.getDoc_ref()+"....doc_no...."+bean.getDoc_no()+"..param1..."+param1+"...doc type.."+bean.getDoc_type_code());
 
 %>
<table border=0 cellpadding=1 cellspacing=0  width='100%' height=20 align="center">
	<td class=ITEMSELECT width="9%" ><span onClick="ModifyDocDetails(<%if(mfg_req_yn.equals("Y")){%>'disabled'<%}else{%>document.forms[0].store_code_disabled.value<%}%>)" style="cursor:pointer;color:#FFFF99"><b><u><fmt:message key="Common.Document.label" bundle="${common_labels}"/></u></b></span></td>
	<td class=ITEMSELECT width='30%' nowrap>:&nbsp;<b><span id="doc_type_desc"><%=bean.getDoc_type_desc()%></span><span id="doc_no"><%=(bean.getDoc_no().equals(""))?"":"/"+bean.getDoc_no()%></span></b></td>
	<td class=ITEMSELECT width='6%' ><b><fmt:message key="Common.Store.label" bundle="${common_labels}"/>:&nbsp;</b></td>
	<td class=ITEMSELECT width='15%' nowrap><b><span id="store_desc"><%=bean.getStore_desc()%></span></b></td>
	<td class=ITEMSELECT width='10%' ><b><fmt:message key="Common.date.label" bundle="${common_labels}"/>:&nbsp;</b></td>
	<td class=ITEMSELECT width='8%'><b><span id="doc_date"><%=doc_date%></span></b></td>
<!--	<td class=ITEMSELECT width='10%' ><b id="doc_ref_legend"><%=(bean.getDoc_ref().equals(""))?"":"Doc Ref:&nbsp;"%></b></td> Changed against ML-MMOH-CRF-0448-->
	<td class=ITEMSELECT width='10%' ><b id="doc_ref_legend">Doc Ref:&nbsp;</b></td>
	<td class=ITEMSELECT width='12%'><b><span id="doc_ref"><%=bean.getDoc_ref()%></span></b></td>
</table>
	<input type="hidden"	name="doc_type_code" id="doc_type_code"			value="<%=bean.getDoc_type_code()%>">
	<input type="hidden"	name="store_code" id="store_code"				value="<%=bean.getStore_code()%>">
	<input type="hidden"	name="store_code_disabled" id="store_code_disabled"		value="false">
	<input type="hidden"	name="bean_id" id="bean_id"					value="<%=bean_id%>">
	<input type="hidden"	name="bean_name" id="bean_name"				value="<%=bean_name%>">
	<input type="hidden"	name="param1" id="param1"					value="<%=param1%>">
	<input type="hidden"	name="item_class_code" id="item_class_code"			value="<%=bean.getItem_class_code()%>">
	<input type="hidden"	name="module_id" id="module_id"				value="<%=module_id%>">
	 
	
	<%
if (!bean.hasAllMandatoryValue()) {
%>
	<script language="JavaScript">
		ModifyDocDetails();
	</script>	
<%
}
//Added on 6/19/2005 by Sabari
if(bean_id.equals("adjustStockBean"))
  putObjectInBean(bean_id,adjStBean,request);
else
  putObjectInBean(bean_id,bean,request);

%>

