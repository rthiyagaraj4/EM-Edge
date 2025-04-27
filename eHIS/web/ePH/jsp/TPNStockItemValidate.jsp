 <%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, ePH.*"%>
<%@page contentType="text/html;charset=UTF-8"%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
%>

<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	String bean_id					= request.getParameter("bean_id");
	String bean_name				= request.getParameter("bean_name");
	String item_code				= request.getParameter("item_code");
	//String mode				= request.getParameter("mode");
	String func_mode	= request.getParameter("func_mode");

Hashtable hash		= (Hashtable)xmlObj.parseXMLString(request);
	hash			= (Hashtable)hash.get("SEARCH");
	TPNStockItemBean bean = (TPNStockItemBean)getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);

	if(func_mode!=null && func_mode.equals("item_uom_search")) {
		//ArrayList uomtpndisplay=new ArrayList();
		//bean.getItemDetails(item_code);

			//String item_code    =(String)uomtpndisplay.get(0);
			/*String short_desc   =bean.getItemDesc();
			String gen_uom_code =bean.getUomCode();
			String tpn_item_yn  =bean.getTPNItemYn();*/
			ArrayList ItemDet = null;
			item_code    = request.getParameter("item_code");
			String short_desc   ="";
			String gen_uom_code ="";
			String tpn_item_yn	="";
			ItemDet=(ArrayList)bean.getItemDetails(item_code);

			if(ItemDet!=null && ItemDet.size()>0){
				item_code=(String)ItemDet.get(0);
				short_desc=(String)ItemDet.get(1);
				gen_uom_code=(String)ItemDet.get(2);
				tpn_item_yn=(String)ItemDet.get(3);
			}

			out.println("document.TPNStockItemModifyQueryForm.tpn_item_yn.value ='"+tpn_item_yn+"';");
		if(tpn_item_yn.equals("Y"))
			{
				out.println("document.TPNStockItemModifyQueryForm.tpn_item_yn.checked = true;");

			}
			else
			{
		out.println("document.TPNStockItemModifyQueryForm.tpn_item_yn.checked = false;");
			}
			out.println("document.getElementById('td_gen_uom_code').innerHTML =\"<b>"+gen_uom_code+"</b>\";");
			out.println("document.getElementById('td_short_name').innerHTML =\"<b>"+short_desc+"</b>\";");
			//out.println("document.getElementById('td_item_code').innerHTML =\"<b>"+item_code+"</b>\";");
}
	putObjectInBean(bean_id,bean,request);
%>
