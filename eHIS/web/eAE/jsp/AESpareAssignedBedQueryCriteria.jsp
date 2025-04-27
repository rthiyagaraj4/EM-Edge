<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
    <html><head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head></html>
<% 
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con		= null ;
try 
{ 
	con				= ConnectionManager.getConnection(request);
ArrayList finAr 	= new ArrayList();

ArrayList firstItem = new ArrayList();
String loc_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels");
String loc_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDesc.label","common_labels");
String trt_area_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.TreatmentAreaCode.label","ae_labels");
String trt_area_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.TreatmentAreaDesc.label","ae_labels");

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
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.BedBayNo.label","ae_labels"));  // label
fifthItem.add("bed_no");   //name of field
fifthItem.add("8");	// SIZE
fifthItem.add("8");	//LENGTH

finAr.add(fifthItem); //add to ArrayList obj finAr


ArrayList sixthItem	= new ArrayList();

sixthItem.add("List");  //Type of item
sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.PseudoBedBay.label","ae_labels"));  // label
sixthItem.add("pseudo_bed_yn"); //name  of field
sixthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
finAr.add(sixthItem); //add to ArrayList obj finAr




ArrayList seventhItem	 = new ArrayList();

seventhItem.add("List");   //Type of item
seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
seventhItem.add("eff_status");//name
seventhItem.add("B," +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
finAr.add(seventhItem); //add to ArrayList obj finAr*/



String orderByCols[] 	= new String[4];
String orderByColVals[] = new String[4];


orderByCols[0] 		 = loc_code;
orderByCols[1]		 = loc_desc;
orderByCols[2]		 = trt_area_code;
orderByCols[3]		 = trt_area_desc;
//orderByCols[4]		 = "Bed No";
//orderByCols[5]		 = "Nature";


orderByColVals[0] 	 = "clinic_code";
orderByColVals[1] 	 = "clinic_desc";
orderByColVals[2] 	 = "treatment_area_code";
orderByColVals[3] 	 = "treatment_area_desc";
//orderByColVals[4] 	 = "bed_no";
//orderByColVals[5] 	 = "eff_status";


strbuff 		= qrypg.getQueryPage(con,finAr,"Find Site" ,"../../eAE/jsp/AESpareAssignedBedQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());
strbuff.setLength(0);
finAr.clear();
firstItem.clear();
secondItem.clear();
thirdItem.clear();
fourthItem.clear();
fifthItem.clear(); 
sixthItem.clear();
seventhItem.clear();
}catch (Exception e)  {e.printStackTrace();}
finally
	{       
		 if(con != null)
		 ConnectionManager.returnConnection(con,request);
	}
%>
