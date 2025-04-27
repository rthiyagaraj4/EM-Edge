<!DOCTYPE html>
<%@ page import ="eOH.*, eOH.Common.*, java.util.ArrayList,java.util.HashMap,eCommon.Common.CommonBean,java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>

<%@ page  import="java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");

	String func_mode	= request.getParameter("func_mode");
	String tab_name = request.getParameter("tab_name");
	String site = request.getParameter("site");
	ArrayList menu_items = null;
	String bean_id	 = "MenuBean";
	String bean_name = "eOH.MenuBean";
	MenuBean bean	 = (MenuBean)getBeanObject( bean_id, bean_name, request );
		
	StringBuffer function_type_list		= new StringBuffer();
	StringBuffer function_type_desc_list		= new StringBuffer();
	StringBuffer function_cat_code_list		= new StringBuffer();

	if(func_mode!= null && func_mode.equals("clearBean")){
			bean.clear();
	}
	else if(func_mode!= null && func_mode.equals("getMenu")){
		//if(site.equals("ARCH") || site.equals("QUAD")){
			//menu_items = (ArrayList)bean.getMenuItems(site);
		//}
		//else{
		menu_items = (ArrayList)bean.getMenuItems(tab_name,site);
		//}
		if(tab_name.equals("DC")){
			for(int i=0;i<menu_items.size();i+=2){
				function_type_list.append((String)menu_items.get(i));
				function_type_list.append("##");

				function_type_desc_list.append((String)menu_items.get(i+1));
				function_type_desc_list.append("##");

				function_cat_code_list.append("");
				function_cat_code_list.append("##");

			}
			
			out.println("assignFunctionTypeList(\"" + function_type_list + "\");") ;
			out.println("assignFunctionTypeDescList(\"" + function_type_desc_list + "\");") ;
			out.println("assignFunctionCatCodeList(\"" + function_cat_code_list + "\");") ;

			function_type_list.setLength(0);
			function_type_desc_list.setLength(0);
			function_cat_code_list.setLength(0);
		}
		else if(tab_name.equals("ET") || tab_name.equals("T")){
			for(int i=0;i<menu_items.size();i+=2){
				
				function_type_list.append((String)menu_items.get(i));
				function_type_list.append("##");

				function_type_desc_list.append((String)menu_items.get(i+1));
				function_type_desc_list.append("##");

				function_cat_code_list.append("");
				function_cat_code_list.append("##");

			}
			
			out.println("assignFunctionTypeList(\"" + function_type_list + "\");") ;
			out.println("assignFunctionTypeDescList(\"" + function_type_desc_list + "\");") ;
			out.println("assignFunctionCatCodeList(\"" + function_cat_code_list + "\");") ;
			function_type_list.setLength(0);
			function_type_desc_list.setLength(0);
			function_cat_code_list.setLength(0);
		}
		//out.println(menu_items);
	}

%>
