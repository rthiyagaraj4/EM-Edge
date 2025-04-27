<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

      <html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head><html>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
request.setCharacterEncoding("UTF-8");
StringBuffer strbuff;
Connection con=null ;
//Statement stmt         =null;
//ResultSet rs		          = null;
//String setup_bl_dtls_in_ip_yn="";
//String facilityId = (String)session.getValue("facility_id");
ArrayList finAr = new ArrayList();
             String menu_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.MenuAdministrator.label","sm_labels");
			 menu_id=menu_id+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels");
	ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(menu_id);	  // label
		firstItem.add("menu_admin_id");	//name of field
		firstItem.add("30");	// SIZE
		firstItem.add("30");	//LENGTH
	finAr.add(firstItem);//add to ArrayList obj finAr
        String menu_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.MenuAdministrator.label","sm_labels");
		menu_name=menu_name+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels");

	ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(menu_name);  // label
		secondItem.add("menu_admin_name");   //name of field
		secondItem.add("30");	// SIZE
		secondItem.add("60");	//LENGTH
	finAr.add(secondItem); //add to ArrayList obj finAr
  String resp_grp_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.ResponsibilityGroupID.label","sm_labels");
	ArrayList thirdItem = new ArrayList();
		thirdItem.add("Text");  		 //Type of item
		thirdItem.add(resp_grp_id);	  // label
		thirdItem.add("resp_group_id");	//name of field
		thirdItem.add("4");	// SIZE
		thirdItem.add("4");	//LENGTH
	finAr.add(thirdItem);//add to ArrayList obj finAr
String resp_grp_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.ResponsibilityGroupName.label","sm_labels");
	ArrayList fourthItem=new ArrayList();
		fourthItem.add("Text");  //Type of item
		fourthItem.add(resp_grp_name);  // label
		fourthItem.add("resp_group_name");   //name of field
		fourthItem.add("30");	// SIZE
		fourthItem.add("30");	//LENGTH
	finAr.add(fourthItem); //add to ArrayList obj finAr

	ArrayList fifth_item=new ArrayList();
		fifth_item.add("List");  //Type of item
		fifth_item.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
		fifth_item.add("eff_status");   //name of field
		fifth_item.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));
	finAr.add(fifth_item); //add to ArrayList obj finAr


String orderByCols[] = new String[4];
String orderByColVals[] = new String[4];

orderByCols[0] = menu_id;
orderByCols[1] = menu_name;
orderByCols[2] = resp_grp_id;
orderByCols[3] = resp_grp_name;

orderByColVals[0] = "menu_admin_id";
orderByColVals[1] = "menu_admin_name";
orderByColVals[2] = "resp_group_id";
orderByColVals[3] = "resp_group_name";

strbuff = qrypg.getQueryPage(con,finAr,"Menu Admin","../jsp/MenuadminQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());

strbuff.setLength(0);
finAr.clear();
firstItem.clear();
secondItem.clear();
thirdItem.clear();
fourthItem.clear();
fifth_item.clear();
%>
