<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

      <html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head><html><%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
Connection con=null ;
request.setCharacterEncoding("UTF-8");
ArrayList finAr = new ArrayList();
String resp_grp_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.ResponsibilityGroupID.label","sm_labels");
	ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(resp_grp_id);	  // label
		firstItem.add("resp_group_id");	//name of field
		firstItem.add("4");	// SIZE
		firstItem.add("4");	//LENGTH
	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem=new ArrayList();
	String resp_grp_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.ResponsibilityGroupName.label","sm_labels");
		secondItem.add("Text");  //Type of item
		secondItem.add(resp_grp_name);  // label
		secondItem.add("resp_group_name");   //name of field
		secondItem.add("30");	// SIZE
		secondItem.add("30");	//LENGTH
	finAr.add(secondItem); //add to ArrayList obj finAr

	ArrayList third_item=new ArrayList();
		third_item.add("List");  //Type of item
		third_item.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
		third_item.add("eff_status");   //name of field
		third_item.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));
	finAr.add(third_item); //add to ArrayList obj finAr


String orderByCols[] = new String[2];
String orderByColVals[] = new String[2];

orderByCols[0] =resp_grp_id;
orderByCols[1] =resp_grp_name;

orderByColVals[0] = "resp_group_id";
orderByColVals[1] = "resp_group_name";

strbuff = qrypg.getQueryPage(con,finAr,"Menu Admin","../jsp/RespgroupQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());
        finAr.clear();
		firstItem.clear();
		secondItem.clear();
		third_item.clear();
		
		
%>
