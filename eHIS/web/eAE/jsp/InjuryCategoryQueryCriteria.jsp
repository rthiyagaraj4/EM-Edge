<!DOCTYPE html>
 <%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
    <html><head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head></html>
<%
request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con		= null ;
try
{
	String inj_cat_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.InjuryCategoryCode.label","ae_labels");
    String inj_cat_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.InjuryCategoryDesc.label","ae_labels");
	con				= ConnectionManager.getConnection(request);
ArrayList finAr 	= new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		//Type of item
firstItem.add(inj_cat_code);		//label
firstItem.add("inj_category_code");		//name of field
firstItem.add("10");				// SIZE
firstItem.add("10");			    //LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem	= new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add(inj_cat_desc);  // label
secondItem.add("long_desc");   //name of field
secondItem.add("30");	// SIZE
secondItem.add("30");	//LENGTH

finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList thirdItem	 = new ArrayList();

thirdItem.add("List");   //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.oscc.label","common_labels"));  // label
thirdItem.add("oscc_yn");//name
thirdItem.add("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));
thirdItem.add("1");	//LENGTH//static values that need to be displayed as amtion.Send it along with the value that is inserted.
finAr.add(thirdItem); //add to ArrayList obj finAr

ArrayList fourthItem	 = new ArrayList();

fourthItem.add("List");   //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
fourthItem.add("eff_status");//name
fourthItem.add("B," +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
finAr.add(fourthItem); //add to ArrayList obj finAr


String orderByCols[] 	= new String[2];
String orderByColVals[] = new String[2];


orderByCols[0] 		 = inj_cat_code;
orderByCols[1]		 = inj_cat_desc;

orderByColVals[0] 	 = "inj_category_code";
orderByColVals[1] 	 = "long_desc";

strbuff 		= qrypg.getQueryPage(con,finAr,"Find Site" ,"../../eAE/jsp/InjuryCategoryQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());
strbuff.setLength(0);
	if(finAr!=null)finAr.clear();
	if(firstItem!=null)firstItem.clear();
	if(secondItem!=null)secondItem.clear();
	if(thirdItem!=null)thirdItem.clear();
	if(fourthItem!=null)fourthItem.clear();
	
}catch (Exception e)  {e.printStackTrace();}
finally
	{
		 if(con!=null)
		 ConnectionManager.returnConnection(con,request);
	}
%>
