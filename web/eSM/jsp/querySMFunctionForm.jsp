<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

      <html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head><html>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con=null;
		try{
		con = ConnectionManager.getConnection(request);
		ArrayList finAr = new ArrayList();
			
		ArrayList firstItem = new ArrayList();
		String module=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Module.label","common_labels");
		
		firstItem.add("List");  		 //Type of item
		firstItem.add(module);	  // label
		firstItem.add("module_id");	//name of field
		firstItem.add("Select module_name module_name, Module_Name module_id from Sm_Module where install_yn = 'Y' order by module_name ");	


		finAr.add(firstItem);//add to ArrayList obj finAr

		ArrayList secondItem = new ArrayList();
        String fun_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Function.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels");

		secondItem.add("Text");  		 //Type of item
		secondItem.add(fun_id);	  // label
		secondItem.add("function_id");	//name of field
		secondItem.add("30");	// SIZE
		secondItem.add("30");	//LENGTH

		finAr.add(secondItem);//add to ArrayList obj finAr

		ArrayList thirdItem = new ArrayList();
        String fun_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FunctionName.label","common_labels");
		thirdItem.add("Text");  		 //Type of item
		thirdItem.add(fun_name);	  // label
		thirdItem.add("function_name");	//name of field
		thirdItem.add("60");	// SIZE
		thirdItem.add("60");	//LENGTH

		finAr.add(thirdItem);//add to ArrayList obj finAr

		String orderByCols[] = new String[3];
		String orderByColVals[] = new String[3];


		orderByCols[0] = module;
		orderByCols[1] = fun_id;
		orderByCols[2] = fun_name;

		orderByColVals[0] = "module_name";
		orderByColVals[1] = "function_id";
		orderByColVals[2] = "function_name";


		strbuff = qrypg.getQueryPage(con,finAr,"Find Function ","../../eSM/jsp/querySmFunction.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

		out.println(strbuff.toString());
		 strbuff.setLength(0);
		finAr.clear();
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		}catch(Exception e){//out.println(e);
			e.printStackTrace();
		}
	finally { 
			ConnectionManager.returnConnection(con,request);
}
%>
