<%@ page import ="eMM.*, eMM.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*,java.sql.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<jsp:useBean id="obj7" scope="page" class="eMM.ItemMasterQueryBean"/>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
//String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");


	int functionType = Integer.parseInt(request.getParameter("function_type"));
	String bean_id = "ItemMasterQueryBean";
	String bean_name = "eMM.ItemMasterQueryBean";
	ItemMasterQueryBean bean = (ItemMasterQueryBean) getBeanObject( bean_id,bean_name,request);  
	bean.clear();
	bean.setLanguageId(locale);
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH"); 
	switch (functionType) {
	case 1:
		{
//				String facility_id = (String) session.getAttribute("facility_id");
				String category=CommonBean.checkForNull(request.getParameter("category"),"%");
				String ps_item=CommonBean.checkForNull(request.getParameter("ps_item"),"%");
				String eff_status=CommonBean.checkForNull(request.getParameter("eff_status"),"%");
				String spl_item=CommonBean.checkForNull(request.getParameter("spl_item"),"%");
				String sole_source=CommonBean.checkForNull(request.getParameter("sole_source"),"%");
				String Cons_item=CommonBean.checkForNull(request.getParameter("Cons_item"),"%");
				String searchby=CommonBean.checkForNull(request.getParameter("searchby"),"%");
				String item_class=CommonBean.checkForNull(request.getParameter("item_class"),"%");
				String item_code=CommonBean.checkForNull(request.getParameter("item_code"),"%");
				String search_str=CommonBean.checkForNull(request.getParameter("search"),"true");
				String pur_uom_code=CommonBean.checkForNull(request.getParameter("pur_uom_code"),"true");
				boolean	search = true;
				if (search_str.equals("true")) {
					search = true;
				}
				else
					search = false;

				String short_desc=CommonBean.checkForNull(request.getParameter("short_desc"),"%");
				String alpha_code=CommonBean.checkForNull(request.getParameter("alpha_code"),"%");
				String trade_id=CommonBean.checkForNull(request.getParameter("trade_id"),"%");
				String trade_name=CommonBean.checkForNull(request.getParameter("trade_name"),"%");
				String item_remarks=CommonBean.checkForNull(request.getParameter("item_remarks"),"%");
				String item_analysis_1=CommonBean.checkForNull(request.getParameter("item_analysis_1"),"%");
				String item_analysis_2=CommonBean.checkForNull(request.getParameter("item_analysis_2"),"%");
				String item_analysis_3=CommonBean.checkForNull(request.getParameter("item_analysis_3"),"%");
				String manufacturer=CommonBean.checkForNull(request.getParameter("manufacturer"),"%");
				String search_criteria=CommonBean.checkForNull(request.getParameter("search_criteria"),"%");
				String search_string=CommonBean.checkForNull(request.getParameter("search_string"),"%");
//				String from			= request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
//				String to			= request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
				bean.setCategory(category) ;
				bean.setPs_item(ps_item) ;
				bean.setEff_status(eff_status) ;
				bean.setSpl_item(spl_item) ;
				bean.setsole_source(sole_source) ;
				bean.setCons_item(Cons_item) ;
				bean.setsearchby(searchby) ;
				bean.setItem_code(item_code) ;
				bean.setItem_class(item_class) ;
				bean.setAlpha_code(alpha_code) ;
				bean.setItem_remarks(item_remarks) ;
				bean.setTrade_id(trade_id) ;
				bean.setTrade_name(trade_name) ;
				bean.setShort_desc(short_desc);
				bean.setItem_analysis_1(item_analysis_1) ;
				bean.setItem_analysis_2(item_analysis_2) ;
				bean.setItem_analysis_3(item_analysis_3) ;
				bean.setManufacturer(manufacturer) ;
				bean.setsearch_criteria(search_criteria) ;
				bean.setSearch_string(search_string) ;
				bean.setSearch(search) ;
				bean.setUOM(pur_uom_code) ;
				bean.loadResultPage();
	

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
