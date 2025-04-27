
<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
24/05/2017		IN063603			Badmavathi B						GHL-CRF-0456
---------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<jsp:useBean id="obj7" scope="page" class="eST.ItemSearchBean"/>
<%
	int functionType					    =		Integer.parseInt(request.getParameter("function_type"));
	request.setCharacterEncoding("UTF-8");
	String locale						    =		(String)session.getAttribute("LOCALE");
	
	String bean_id						    =		"ItemSearchBean";
	String bean_name					    =		"eST.ItemSearchBean";
	ItemSearchBean bean					    =		(ItemSearchBean) getBeanObject( bean_id,bean_name,request);  
	bean.clear();
	bean.setLanguageId(locale);
	Hashtable hash							=		 (Hashtable) XMLobj.parseXMLString(request);
    hash									=		(Hashtable) hash.get ("SEARCH");
	switch (functionType) {
	case 1:
		{
			//	String facility_id			=	(String) session.getAttribute("facility_id");
				String item_code			=	CommonBean.checkForNull(request.getParameter("item_code"),"%");
				String radioval				=	CommonBean.checkForNull(request.getParameter("radioval"),"IC");
				String short_desc			=	CommonBean.checkForNull(request.getParameter("short_desc"),"%");
				String alpha_code			=	CommonBean.checkForNull(request.getParameter("alpha_code"),"%");
				String machine_code			=	CommonBean.checkForNull(	request.getParameter("machine_code"),"%");
				String spare_part_id		=	CommonBean.checkForNull(request.getParameter("spare_part_id"),"%");
				String category				=	CommonBean.checkForNull(request.getParameter("category"),"%");
				String ps_item				=	CommonBean.checkForNull(request.getParameter("ps_item"),"%");
				String sole_source			=	CommonBean.checkForNull(request.getParameter("sole_source"),"%");
				String manufacturer			=	CommonBean.checkForNull(request.getParameter("manufacturer"),"%");
				String abc_analysis			=	CommonBean.checkForNull(request.getParameter("abc_analysis"),"%");
				String mfg_item				=	CommonBean.checkForNull(request.getParameter("mfg_item"),"%");
				String expiry				=	CommonBean.checkForNull(request.getParameter("expiry"),"%");
				String item_class			=	CommonBean.checkForNull(request.getParameter("item_class"),"%");
				String item_analysis_1		=	CommonBean.checkForNull(request.getParameter("item_analysis_1"),"%");
				String item_analysis_2		=	CommonBean.checkForNull(request.getParameter("item_analysis_2"),"%");
				String item_analysis_3		=	CommonBean.checkForNull(request.getParameter("item_analysis_3"),"%");
				String ordercolmns			=	CommonBean.checkForNull(request.getParameter("ordercolmns"),"1");
				String trade_id				=	CommonBean.checkForNull(request.getParameter("trade_id"),"%");
				String trade_name			=	CommonBean.checkForNull(request.getParameter("trade_name"),"%");
				String store_code			=	CommonBean.checkForNull(request.getParameter("store_code"),"%");
				String store_desc			=	CommonBean.checkForNull(request.getParameter("store_desc"),"%");
				String consignment			=	CommonBean.checkForNull(request.getParameter("consignment"),"%");
				String chk_itemstorecmb		=	CommonBean.checkForNull(request.getParameter("chk_itemstorecmb"),"N");
				//String from				=	request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
				//String to					=	request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;

				String trn_type				=	CommonBean.checkForNull(request.getParameter("trn_type"),"%");//Added for GHL-CRF-0456 
				bean.setItem_code(item_code) ;
				bean.setShort_desc(short_desc) ;
				bean.setAlpha_code(alpha_code) ;
				bean.setMachine_code(machine_code) ;
				bean.setSpare_part_id(spare_part_id) ;
				bean.setCategory(category) ;
				bean.setSole_source_yn(sole_source) ;
				bean.setPs_item_yn(ps_item) ;
				bean.setManufacturer(manufacturer) ;
				bean.setAbc_analysis(abc_analysis) ;
				bean.setMfg_item(mfg_item) ;
				bean.setExpiry(expiry) ;
				bean.setItem_class(item_class) ;
				bean.setItem_analysis_1(item_analysis_1) ;
				bean.setItem_analysis_2(item_analysis_2) ;
				bean.setItem_analysis_3(item_analysis_3) ;
				bean.setOrdercolmns(ordercolmns) ;
				bean.setTrade_id(trade_id) ;
				bean.setTrade_name(trade_name) ;
				bean.setConsignment(consignment) ;
				bean.setStore_code(store_code) ;
				bean.setStore_desc(store_desc) ;
				if(radioval.equals("IC"))
				{
					bean.setOrderBy("ORDER BY A.ITEM_CODE");
				}
				else 
					if(radioval.equals("IN"))
				{
					bean.setOrderBy("ORDER BY B.SHORT_DESC ");
				}
				
				bean.setChkItemStoreCombination(chk_itemstorecmb) ;
				bean.setTrn_type(trn_type);//Added for GHL-CRF-0456 
				bean.loadResultPage();
				
		}
		break;
	case 2:
		{
			String start			=	request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
			String end				=	request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
			String stColumnName		=	request.getParameter( "ordercolmns" )==null?"":request.getParameter( "ordercolmns" ) ;
			bean.toggleSort();
			if (bean.getSortDesc())
				bean.descSort(stColumnName,Integer.parseInt(start),Integer.parseInt(end));
			else
				bean.ascSort(stColumnName,Integer.parseInt(start),Integer.parseInt(end));
		}
		break;
		case 3:
		{
			String start			=	 request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
			String end				=	 request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
			String stColumnName		=	 request.getParameter( "ordercolmns" )==null?"":request.getParameter( "ordercolmns" ) ;
			bean.descSort(stColumnName,Integer.parseInt(start),Integer.parseInt(end));
			out.println("document.forms[0].count.value=1;");
		}
		break;
		//Added on 3/13/2006 for ItemSearchBean Cleanup after selecting the data
		case 4:
			if (bean.getDataList().size() > 0)
				bean.getDataList().clear();
			if (bean.getKitDataList().size()>0)
				bean.getKitDataList().clear();
			break;
		case 5:
		{
			String kit_code = (String)request.getParameter( "kit_code" )==null?"":(String)request.getParameter( "kit_code" ) ;
			bean.getKitTemplateDetails(kit_code);
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
