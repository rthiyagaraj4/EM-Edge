
<%@ page import ="eST.StockStatusByItemBean, eCommon.Common.*,java.util.Hashtable,java.text.NumberFormat , java.util.Locale,java.text.DecimalFormat" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<jsp:useBean id="obj123" scope="page" class="eST.StockStatusByItemBean"/>
<%
	request.setCharacterEncoding("UTF-8");
	String locale					=		(String)session.getAttribute("LOCALE");
	String bean_id					=		"StockStatusByItemBean";
	String bean_name				=		"eST.StockStatusByItemBean";
	StockStatusByItemBean bean		=		(StockStatusByItemBean) getBeanObject( bean_id, bean_name, request);
	bean.setLanguageId(locale);
	bean.clear();

	Hashtable hash					=		(Hashtable) XMLobj.parseXMLString(request);
    hash							=		(Hashtable) hash.get ("SEARCH");

	String item_code				=		CommonBean.checkForNull(request.getParameter("item_code"),"");
	String store_code				=		CommonBean.checkForNull(request.getParameter("store_code"),"");
	double size						=		Double.parseDouble(CommonBean.checkForNull(request.getParameter("unit_cost"),"0.0"));
	String id_minl					=		request.getParameter("id_minl");
	//Added by Rabbani #INC no : 39203 on  09/04/2013 
	String dflt_facility_id			=		CommonBean.checkForNull(request.getParameter("dflt_facility_id"),"%");
	bean.setLoginFacilityId(dflt_facility_id) ; 
	//ends
	bean.setItem_code(item_code) ;
	if(!store_code.equals(""))
	{
		bean.setStore_code(store_code) ;
	}
	bean.loadData();
	double baseItemUnitCost			=		bean.getBaseUnitCost(item_code);//Added by Sakti against TTM-SCF-0106 to get base uom 
	
	double qty						=		Double.parseDouble(CommonBean.checkForNull(bean.getStock_qty(),"0.0"));
	//double st_val_int				=		qty * size;
	double st_val_int				=		qty * baseItemUnitCost;//Added by Sakti against TTM-SCF-0106 to get base uom unit_cost
	String str_date					=		bean.checkForNull(bean.getLast_issue_date());
	str_date				=	com.ehis.util.DateUtils.convertDate(str_date,"DMY","en",locale);
	java.text.DecimalFormat		df	=		new java.text.DecimalFormat("0.00");
	java.text.DecimalFormat		dff	=		new java.text.DecimalFormat("0.000");
	String st_v						=		df.format(st_val_int);
	
	String baseItemUnitCostst		=		dff.format(baseItemUnitCost);

// Added By Rams 12/15/2009 For the Decimal CRF 537.1 Begins
	/* @Name - Rams
 * @Date - 12/15/2009
 * @Inc# - CRF 537.1
 * @Desc - For the Decimal related display
 */
  /** @Name - Priya
	* @Date - 01/02/2010
	* @Inc# - 15496 (SRR20056-CRF-0537.2)
	* @Desc - To use common method, the previous coding has been removed
	*/
		int no_of_decimals=bean.getNoOfDecimals(); 
	//END

	out.println("document.getElementById('id_stock').innerHTML=\""+(bean.setNumberFormat(bean.checkForNull(bean.getStock_qty(),"0"),no_of_decimals))+"\"");
	out.println("document.getElementById('id_class').innerHTML=\""+bean.checkForNull(bean.getClass_desc())+"\"");
	out.println("document.getElementById('id_recl').innerHTML=\""+NumberFormat.getInstance(new Locale(locale)).format(Double.parseDouble(bean.checkForNull(bean.getReorder_level(),"0")))+"\"");
	out.println("document.getElementById('id_store').innerHTML=\""+(bean.setNumberFormat(bean.checkForNull(bean.getReorder_store(),"0"),no_of_decimals))+"\"");
	out.println("document.getElementById('id_size').innerHTML=\""+NumberFormat.getInstance(new Locale(locale)).format(Double.parseDouble(bean.checkForNull(bean.getPack_size(),"0")))+"\"");
	out.println("document.getElementById('id_lestdate').innerHTML=\""+str_date+"\"");
	out.println("document.getElementById('id_leststore').innerHTML=\""+bean.checkForNull(bean.getLast_issue_store_desc())+"\"");
	out.println("document.getElementById('id_value').innerHTML=\""+NumberFormat.getInstance(new Locale(locale)).format(Double.parseDouble(st_v))+"\"");

	out.println("document.getElementById('id_cost').innerHTML=\""+(bean.setNumberFormat(baseItemUnitCostst,3))+"\""); //Added by Sakti against TTM-SCF-0106 to get base uom unit_cost
	out.println("document.getElementById('id_cost').title=\""+baseItemUnitCost+"\"");
	

	out.println("document.getElementById('id_pstock').innerHTML=\""+NumberFormat.getInstance(new Locale(locale)).format(Double.parseDouble(bean.checkForNull(bean.getQty_primary_store(),"0")))+"\"");
	out.println("document.getElementById('id_locfirst').innerHTML=\""+bean.checkForNull(bean.getBin_location())+"\"");
	out.println("document.getElementById('id_ytdIQty').innerHTML=\""+(bean.setNumberFormat(bean.checkForNull(bean.getYtd_issue_qty(),"0"),no_of_decimals))+"\"");
	out.println("document.getElementById('id_mtdIQty').innerHTML=\""+(bean.setNumberFormat(bean.checkForNull(bean.getMtd_iss_qty(),"0"),no_of_decimals))+"\"");
	out.println("document.getElementById('id_mtdRQty').innerHTML=\""+(bean.setNumberFormat(bean.checkForNull(bean.getMtd_rec_qty(),"0"),no_of_decimals))+"\"");
	out.println("document.getElementById('id_conQty').innerHTML=\""+(bean.setNumberFormat(bean.checkForNull(bean.getYtd_cons_qty(),"0"),no_of_decimals))+"\"");
	out.println("document.getElementById('id_MTDconQty').innerHTML=\""+(bean.setNumberFormat(bean.checkForNull(bean.getMtd_cons_qty(),"0"),no_of_decimals))+"\"");
      //Integer changed as Double for getReorder_store by Rabbani, Inc no :29544 on 16/11/11
	if ((Double.parseDouble(bean.checkForNull(bean.getReorder_store(),"0")) < Integer.parseInt(bean.checkForNull(id_minl,"0"))) || (Double.parseDouble(bean.checkForNull(bean.getReorder_store(),"0")) < Integer.parseInt(bean.checkForNull(bean.getReorder_level(),"0")))){
		if 
	(Double.parseDouble(bean.checkForNull(bean.getReorder_store(),"0")) < Integer.parseInt(bean.checkForNull(id_minl,"0"))) {
	 out.println("document.getElementById('id_Highlight').style.display=\"inline\"");
	 out.println("document.getElementById('id_Highlight').innerHTML=\""+"<img src='../../eST/images/MinStk.gif' >&nbsp;&nbsp;"+"\"");
	}
	if 
	(Double.parseDouble(bean.checkForNull(bean.getStock_qty(),"0")) < Integer.parseInt(bean.checkForNull(bean.getReorder_level(),"0")))
	{
		out.println("document.getElementById('id_Highlight').style.display=\"inline\"");
		out.println("document.getElementById('id_Highlight').innerHTML+=\""+"<img src='../../eST/images/ROL.gif'>"+"\"");
	}
	}else{
		out.println("document.getElementById('id_Highlight').style.display=\"none\"");
	}
	
	
	%>
<%
putObjectInBean(bean_id,bean,request);
%>
