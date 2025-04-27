<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
    <html><head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head></html>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;

try {
	String bedbay_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.BedBayTypeCode.label","ae_labels");
	String bedbay_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.BedBayTypeDesc.label","ae_labels");
	con = ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  	//Type of item
firstItem.add(bedbay_type);	// label
firstItem.add("Bay_Type_Code");	//name of field
firstItem.add("2");	// SIZE
firstItem.add("2");	//LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");  		 //Type of item
secondItem.add(bedbay_type_desc);	  // label
secondItem.add("long_desc");	//name of field
secondItem.add("30");	// SIZE
secondItem.add("30");	//LENGTH
finAr.add(secondItem);//add to ArrayList obj finAr

ArrayList fifthItem = new ArrayList();

fifthItem.add("List");   //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
fifthItem.add("EFF_STATUS");//name
fifthItem.add("B," +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
finAr.add(fifthItem); //add to ArrayList obj finAr


String orderByCols[] = new String[2];
String orderByColVals[] = new String[2];


orderByCols[0] = bedbay_type;
orderByCols[1] = bedbay_type_desc;


orderByColVals[0] = "Bay_Type_Code";
orderByColVals[1] = "long_desc";



strbuff = qrypg.getQueryPage(con,finAr,"Find Service","../jsp/BayTypeQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());
strbuff.setLength(0);
finAr.clear();
firstItem.clear();
secondItem.clear();
fifthItem.clear();
}catch (Exception e)  {e.printStackTrace();}
finally
	{
		 ConnectionManager.returnConnection(con,request);
	}
%>
