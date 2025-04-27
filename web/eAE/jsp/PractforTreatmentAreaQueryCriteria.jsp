<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");

%>
    <html><head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head></html>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con		= null ;
try
{  
String pract_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels");
String pract_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels");
String loc_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels");
String loc_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDesc.label","common_labels");
String trt_area_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.TreatmentAreaCode.label","ae_labels");
String trt_area_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.TreatmentAreaDesc.label","ae_labels");

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
thirdItem.add(trt_area_code);  // label
thirdItem.add("treatment_code");   //name of field
thirdItem.add("2");	// SIZE
thirdItem.add("2");	//LENGTH

finAr.add(thirdItem); //add to ArrayList obj finAr


ArrayList fourthItem	= new ArrayList();

fourthItem.add("Text");  //Type of item
fourthItem.add(trt_area_desc);  // label
fourthItem.add("treatment_area_desc");   //name of field
fourthItem.add("15");	// SIZE
fourthItem.add("15");	//LENGTH

finAr.add(fourthItem); //add to ArrayList obj finAr

ArrayList fifthItem	= new ArrayList();

fifthItem.add("Text");  //Type of item
fifthItem.add(pract_id);  // label
fifthItem.add("practitioner_id");   //name of field
fifthItem.add("15");	// SIZE
fifthItem.add("15");	//LENGTH

finAr.add(fifthItem); //add to ArrayList obj finAr

ArrayList sixthItem	= new ArrayList();

sixthItem.add("Text");  //Type of item
sixthItem.add(pract_name);  // label
sixthItem.add("practitioner_name"); //name  of field
sixthItem.add("15");	// SIZE
sixthItem.add("15");	//LENGTH

finAr.add(sixthItem); //add to ArrayList obj finAr

ArrayList seventhItem	 = new ArrayList();

seventhItem.add("List");   //Type of item
seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
seventhItem.add("eff_status");//name
seventhItem.add("B," +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
finAr.add(seventhItem); //add to ArrayList obj finAr

String orderByCols[] 	= new String[6];
String orderByColVals[] = new String[6];


orderByCols[0] 		 = loc_code;
orderByCols[1]		 = loc_desc;
orderByCols[2]		 = trt_area_code;
orderByCols[3]		 = trt_area_desc;
orderByCols[4]		 = pract_id;
orderByCols[5]		 = pract_name;


orderByColVals[0] 	 = "clinic_code";
orderByColVals[1] 	 = "clinic_desc";
orderByColVals[2] 	 = "treatment_area_code";
orderByColVals[3] 	 = "treatment_area_desc";
orderByColVals[4] 	 = "practitioner_id";
orderByColVals[5] 	 = "practitioner_name";


strbuff 		= qrypg.getQueryPage(con,finAr,"Find Site" ,"../../eAE/jsp/PractforTreatmentAreaQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());
strbuff.setLength(0);
	if(finAr!=null)finAr.clear();
	if(firstItem!=null)firstItem.clear();
	if(secondItem!=null)secondItem.clear();
	if(thirdItem!=null)thirdItem.clear();
	if(fourthItem!=null)fourthItem.clear();
	if(fifthItem!=null)fifthItem.clear();
	if(sixthItem!=null)sixthItem.clear();
	if(seventhItem!=null)seventhItem.clear();
}catch (Exception e)  {e.printStackTrace();}
finally
	{
		 if(con != null)
		 ConnectionManager.returnConnection(con,request);
	}
%>
