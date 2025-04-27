<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.util.* " %>
<%
		String sStyle	= 
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<%
request.setCharacterEncoding("UTF-8");

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con=null ;

String NursingUnitCode =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NursingUnitCode.label","common_labels");
String NursingUnitDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NursingUnitDescription.label","ip_labels");
String BedClassCode = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BedClassCode.label","ip_labels");
String BedClassDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"); 
String BedTypeCode = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedtype.label","common_labels") +" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"); 
String BedTypeDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedtype.label","common_labels") +" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"); 
String RoomCubicle = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RoomCubicle.label","common_labels");
String BedNo = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels");


try
{
	con	= ConnectionManager.getConnection(request);

	
ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  		 //Type of item
	firstItem.add(NursingUnitCode);	  // label
	firstItem.add("nursing_unit_code");	//name of field
	firstItem.add("4");	// SIZE
	firstItem.add("4");	//LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();
	secondItem.add("Text");  //Type of item
	secondItem.add(NursingUnitDesc);  // label
	secondItem.add("nursing_short_desc");   //name of field
	secondItem.add("15");	// SIZE
	secondItem.add("15");	//LENGTH
finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList thirdItem=new ArrayList();
	thirdItem.add("Text");  //Type of item
	thirdItem.add(BedClassCode);  // label
	thirdItem.add("bed_class_code");   //name of field
	thirdItem.add("2");	// SIZE
	thirdItem.add("2");	//LENGTH
finAr.add(thirdItem); //add to ArrayList obj finAr

ArrayList fourthItem=new ArrayList();
	fourthItem.add("Text");  //Type of item
	fourthItem.add(BedClassDesc);  // label
	fourthItem.add("bed_class_short_desc");   //name of field
	fourthItem.add("15");	// SIZE
	fourthItem.add("15");	//LENGTH
finAr.add(fourthItem); //add to ArrayList obj finAr


ArrayList fifthItem=new ArrayList();
	fifthItem.add("Text");  //Type of item
	fifthItem.add(BedTypeCode);  // label
	fifthItem.add("bed_type_code");   //name of field
	fifthItem.add("2");	// SIZE
	fifthItem.add("2");	//LENGTH
finAr.add(fifthItem); //add to ArrayList obj finAr

ArrayList fifthItem1=new ArrayList();
	fifthItem1.add("Text");  //Type of item
	fifthItem1.add(BedTypeDesc);  // label
	fifthItem1.add("bed_type_short_desc");   //name of field
	fifthItem1.add("15");	// SIZE
	fifthItem1.add("15");	//LENGTH
finAr.add(fifthItem1); //add to ArrayList obj finAr

ArrayList sixthItem=new ArrayList();
	sixthItem.add("Text");  //Type of item
	sixthItem.add(RoomCubicle);  // label
	sixthItem.add("room");   //name of field
	sixthItem.add("4");	// SIZE
	sixthItem.add("4");	//LENGTH
finAr.add(sixthItem); //add to ArrayList obj finAr

ArrayList seventhItem=new ArrayList();
	seventhItem.add("Text");  //Type of item
	seventhItem.add(BedNo);  // label
	seventhItem.add("bed_no");   //name of field
	seventhItem.add("8");	// SIZE
	seventhItem.add("8");	//LENGTH
finAr.add(seventhItem); //add to ArrayList obj finAr

ArrayList eigthItem=new ArrayList();
	eigthItem.add("List");  //Type of item
	eigthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
	eigthItem.add("eff_status");   //name of field
	eigthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));
finAr.add(eigthItem); //add to ArrayList obj finAr

String orderByCols[] = new String[8];
String orderByColVals[] = new String[8];

orderByCols[0] = NursingUnitCode;
orderByCols[1] = NursingUnitDesc;
orderByCols[2] = BedClassCode;
orderByCols[3] = BedClassDesc;
orderByCols[4] = BedTypeCode;
orderByCols[5] = BedTypeDesc;
orderByCols[6] = RoomCubicle;
orderByCols[7] = BedNo;


orderByColVals[0] = "nursing_unit_code";
orderByColVals[1] = "nursing_unit_short_desc";
orderByColVals[2] = "bed_class_code";
orderByColVals[3] = "bed_class_short_desc";
orderByColVals[4] = "bed_type_code";
orderByColVals[5] = "bed_type_short_desc";
orderByColVals[6] = "room_no";
orderByColVals[7] = "bed_no";

strbuff = qrypg.getMultiColumnQueryPage(con,finAr,"Pseudo Bed Creation","PseudoBedCreationQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));


out.println(strbuff.toString().replaceAll("nowrap",""));
}catch(Exception e) 
{ 
	//out.println(e.toString());
	e.printStackTrace();
}
finally 
{
	ConnectionManager.returnConnection(con,request);
}

%>

<%!
	// By Annadurai 2/23/2004 starts., to handle NullPointerException.
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>

