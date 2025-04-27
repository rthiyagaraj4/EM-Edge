<!DOCTYPE html>

<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

      <html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head><body onKeyDown = 'lockKey()'></body></html>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
request.setCharacterEncoding("UTF-8");
Connection con=null ;

try {

	con = ConnectionManager.getConnection(request);
ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();
String requestor_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RequestorCode.label","mr_labels");
firstItem.add("Text");  		 //Type of item
firstItem.add(requestor_code);	  // label
firstItem.add("requestor_code");	//name of field
firstItem.add("10");	// SIZE
firstItem.add("10");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();
String long_description=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Requestor.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels");
secondItem.add("Text");  		 //Type of item
secondItem.add(long_description);	  // label
secondItem.add("long_description");	//name of field
secondItem.add("30");	// SIZE
secondItem.add("30");	//LENGTH

finAr.add(secondItem);//add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();
String chk_list_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.CheckLists.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
thirdItem.add("Text");  		 //Type of item
thirdItem.add(chk_list_code);	  // label
thirdItem.add("chk_list_code");	//name of field
thirdItem.add("10");	// SIZE
thirdItem.add("10");	//LENGTH

finAr.add(thirdItem);//add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();
String chk_list_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.CheckLists.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels");
fourthItem.add("Text");  		 //Type of item
fourthItem.add(chk_list_desc);	  // label
fourthItem.add("chk_list_desc");	//name of field
fourthItem.add("30");	// SIZE
fourthItem.add("30");	//LENGTH

finAr.add(fourthItem);//add to ArrayList obj finAr





String orderByCols[] = new String[4];
String orderByColVals[] = new String[4];


orderByCols[0] = requestor_code;
orderByCols[1] = long_description;
orderByCols[2] = chk_list_code;
orderByCols[3] = chk_list_desc;

orderByColVals[0] = "C.REQUESTOR_ID";
orderByColVals[1] = "A.LONG_DESC";
orderByColVals[2] = "B.CHK_LIST_CODE";
orderByColVals[3] = "B.LONG_DESC";


strbuff = qrypg.getQueryPage(con,finAr,"Find Checklist For Requestor","../jsp/ChecklistForRequestorQuery.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");



out.println(strbuff.toString());
        finAr.clear();
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		fourthItem.clear();
		
}catch(Exception e){out.println(e);}
			finally { 
	ConnectionManager.returnConnection(con,request);
}

%>
