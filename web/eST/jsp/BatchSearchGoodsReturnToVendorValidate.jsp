
 <%@page import=" eST.*,eST.Common.*, eCommon.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*,java.lang.*" contentType="text/html;charset=UTF-8"%>  

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<jsp:useBean id="XMLobj" scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<jsp:useBean id="obj39"   scope="page"  class="eST.BatchSearchGoodsReturnToVendorBean"/>

<%
request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
	int functionType = Integer.parseInt(request.getParameter("function_type"));

	String bean_id = "BatchSearchGoodsReturnToVendorBean";
	String bean_name = "eST.BatchSearchGoodsReturnToVendorBean";
	BatchSearchGoodsReturnToVendorBean bean = (BatchSearchGoodsReturnToVendorBean)getBeanObject( bean_id,bean_name,request);  
	bean.setLanguageId(locale);
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");
	switch (functionType) {

	case 1:
		{
				String item_code			=   CommonBean.checkForNull(request.getParameter("item_code"),"");
				String store_code			=	CommonBean.checkForNull(request.getParameter("store_code"),"");
				String supp_code			=	CommonBean.checkForNull(request.getParameter("supp_code"),"");
				String po_no			=	CommonBean.checkForNull(request.getParameter("po_no"),"%");
				String grn_doc_type_code			=	CommonBean.checkForNull(request.getParameter("grn_doc_type_code"),"%");
				String grn_doc_no			=	CommonBean.checkForNull(request.getParameter("grn_doc_no"),"%");
				String doc_type_code	=	CommonBean.checkForNull(request.getParameter("doc_type_code"),"");
				String doc_no			=	CommonBean.checkForNull(request.getParameter("doc_no"),"");
				String trn_type			=	CommonBean.checkForNull(request.getParameter("trn_type"),"");
				bean.setItem_code(item_code) ;
				bean.setStore_code(store_code) ;
				bean.setSupp_code(supp_code) ;
				bean.setPo_no(po_no) ;
				bean.setGrn_doc_type_code(grn_doc_type_code) ;
				bean.setGrn_doc_no(grn_doc_no) ;
				bean.loadResultPage(doc_type_code,doc_no,trn_type);
		}
		break;
		case 2:
		{
		}
		break;
		case 3:
		{
			out.println("document.forms[0].count.value=1;");
		}
		break;
		case 4:
		{
			String index= request.getParameter( "index" )==null?"":request.getParameter( "index" ) ;
			String noOfCheckedRecords= request.getParameter( "noOfCheckedRecords" )==null?"":request.getParameter( "noOfCheckedRecords" ) ;
			bean.selectedBatches(index,noOfCheckedRecords);
		}
		break;
		default :
		out.println("alert(\'Invalid Function\');");
		return;
	}
%>	
<%
putObjectInBean(bean_id,bean,request);
%>
