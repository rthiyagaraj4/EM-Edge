<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

    <html><head>
   <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");

%>
 
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<% 
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con		= null ;
String loc_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels");
String loc_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDesc.label","common_labels");
try 
{ 
	con				= ConnectionManager.getConnection(request);
	ArrayList finAr 	= new ArrayList();
	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  		//Type of item
	firstItem.add(loc_code);		//label
	firstItem.add("clinic_code");		//name of field
	firstItem.add("4");				// SIZE
	firstItem.add("4");			    //LENGTH
	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem	= new ArrayList();
	secondItem.add("Text");  //Type of item
	secondItem.add(loc_desc);  // label
	secondItem.add("clinic_desc");   //name of field
	secondItem.add("15");	// SIZE
	secondItem.add("15");	//LENGTH

	finAr.add(secondItem); //add to ArrayList obj finAr

	ArrayList thirdItem	= new ArrayList();

	thirdItem.add("Text");  //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.BedBayNo.label","ae_labels"));  // label
	thirdItem.add("bay_no");   //name of field
	thirdItem.add("8");	// SIZE
	thirdItem.add("8");	//LENGTH

	finAr.add(thirdItem); //add to ArrayList obj finAr

	ArrayList forthItem	= new ArrayList();

	forthItem.add("Text");  //Type of item
	forthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.BedBayType.label","ae_labels"));  // label
	forthItem.add("BAY_TYPE_DESC");   //name of field
	forthItem.add("15");	// SIZE
	forthItem.add("15");	//LENGTH

	finAr.add(forthItem); //add to ArrayList obj finAr

    ArrayList fifthItem	= new ArrayList();

	fifthItem.add("List");  //Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.PseudoBedBay.label","ae_labels"));  // label
	fifthItem.add("SPARE_BAY_YN");   //name of field
	fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));	// SIZE
	fifthItem.add("1");	//LENGTH

	finAr.add(fifthItem); //add to ArrayList obj finAr
	
	ArrayList sixthItem	 = new ArrayList();
	sixthItem.add("List");   //Type of item
	sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
	sixthItem.add("eff_status");//name
	sixthItem.add("B," +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
	finAr.add(sixthItem); //add to ArrayList obj finAr*/

	String orderByCols[] 	= new String[2];
	String orderByColVals[] = new String[3];

	orderByCols[0] 		 = loc_code;
	orderByCols[1]		 = loc_desc;
	orderByColVals[0] 	 = "clinic_code";
	orderByColVals[1] 	 = "clinic_desc";

	strbuff = qrypg.getQueryPage(con,finAr,"Find Site" ,"../../eAE/jsp/SpareBaysQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());
	strbuff.setLength(0);
	if(finAr!=null)finAr.clear();
	if(firstItem!=null)firstItem.clear();
	if(secondItem!=null)secondItem.clear();
	if(thirdItem!=null)thirdItem.clear();
	if(forthItem!=null)forthItem.clear();
	if(fifthItem!=null)fifthItem.clear();
	if(sixthItem!=null)sixthItem.clear();
	
}catch (Exception e)  {
	e.printStackTrace();
 }
finally
	{
		 if(con != null)
		 ConnectionManager.returnConnection(con,request);
	}
%>
