<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
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

Connection con=null ;

try {
	String inj_cat_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.InjuryCategoryCode.label","ae_labels");
    String inj_cat_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.InjuryCategoryDesc.label","ae_labels");
	String injsub_cat_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.InjurySubcategoryCode.label","ae_labels");
    String injsub_cat_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.InjurySubcategoryDesc.label","ae_labels");
	con				= ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		 	//Type of item
firstItem.add(inj_cat_code);  	// label
firstItem.add("inj_category_code");	//name of field
firstItem.add("10");				// SIZE
firstItem.add("10");				//LENGTH

finAr.add(firstItem);				//add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();

secondItem.add("Text");  			//Type of item
secondItem.add(inj_cat_desc);  	// label
secondItem.add("inj_category_long_desc");   //name of field
secondItem.add("30");				// SIZE
secondItem.add("30");				//LENGTH

finAr.add(secondItem); 				//add to ArrayList obj finAr


ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");   				//Type of item
thirdItem.add(injsub_cat_code);  	// label
thirdItem.add("inj_subcategory_code");		//name
thirdItem.add("10");					// SIZE
thirdItem.add("10");					//LENGTH

finAr.add(thirdItem); 				//add to ArrayList obj finAr


ArrayList fourthItem = new ArrayList();

fourthItem.add("Text");   					//Type of item
fourthItem.add(injsub_cat_desc);  	// label
fourthItem.add("inj_subcategory_long_desc");	//name
fourthItem.add("30");					// SIZE
fourthItem.add("30");					//LENGTH

finAr.add(fourthItem); 				//add to ArrayList obj finAr


ArrayList fifthItem=new ArrayList();

fifthItem.add("List");  				//Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
	fifthItem.add("eff_status");//name
	fifthItem.add("B," +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));

finAr.add(fifthItem); 				//add to ArrayList obj finAr


String orderByCols[] = new String[4];
String orderByColVals[] = new String[4];


orderByCols[0] = inj_cat_code;
orderByCols[1] = inj_cat_desc;
orderByCols[2] = injsub_cat_code;
orderByCols[3] = injsub_cat_desc;

orderByColVals[0] = "inj_category_code";
orderByColVals[1] = "inj_category_short_desc";
orderByColVals[2] = "inj_subcategory_code";
orderByColVals[3] = "inj_subcategory_long_desc";

strbuff = qrypg.getQueryPage(con,finAr,"Find Speciality For Practitioner","../../eAE/jsp/InjurySubCategoryQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());
strbuff.setLength(0);
	if(finAr!=null)finAr.clear();
	if(firstItem!=null)firstItem.clear();
	if(secondItem!=null)secondItem.clear();
	if(thirdItem!=null)thirdItem.clear();
	if(fourthItem!=null)fourthItem.clear();
	if(fifthItem!=null)fifthItem.clear();
	}catch (Exception e)  {e.printStackTrace();}
finally
	{
		 ConnectionManager.returnConnection(con,request);
	}
%>
