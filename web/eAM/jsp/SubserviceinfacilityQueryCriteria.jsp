<!DOCTYPE html>
<%--
	FileName	: SubserviceinfacilityQueryCriteria.jsp
	Version	    : 3	
	Modified On	: 18-2-2005
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


 <%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></html></head>
 <%! ArrayList  finAr;
	 ArrayList firstItem;
	 ArrayList secondItem;
	 ArrayList thirdItem;
	 ArrayList fourthItem;
	 ArrayList fifthItem;
	 ArrayList sixthItem;
	 ArrayList seventhItem ;
	 ArrayList eightItem;
	 ArrayList ninthItem;
	 ArrayList tenthItem;
	 ArrayList eleventhItem;

 %>
 <%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;

try 
{
	con = ConnectionManager.getConnection(request) ;
	finAr = new ArrayList();

	firstItem = new ArrayList();
		firstItem.add("Text");  		//Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels") );		// label
		firstItem.add("operating_facility_id");	//name of field
		firstItem.add("2");			// SIZE
		firstItem.add("2");			//LENGTH
		finAr.add(firstItem);			//add to ArrayList obj finAr

	secondItem = new ArrayList();
		secondItem.add("Text");  		 //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels"));	 // label
		secondItem.add("facility_name");	 //name of field
		secondItem.add("70");			 // SIZE
		secondItem.add("35");	 		 //LENGTH
		finAr.add(secondItem);			 //add to ArrayList obj finAr

	thirdItem = new ArrayList();
		thirdItem.add("Text");   		//Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));  		// label
		thirdItem.add("service_code");		//name
		thirdItem.add("4");			// SIZE
		thirdItem.add("4");			//LENGTH
		//thirdItem.add("B,Both,Y,Yes,N,No");	//static values that need to be displayed as amtion.Send it along with the value that is inserted.
		finAr.add(thirdItem); 			//add to ArrayList obj finAr

	fourthItem = new ArrayList();
		fourthItem.add("Text"); 		//Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels")); 	// label
		fourthItem.add("service_short_desc");	//name
		fourthItem.add("15");		 	// SIZE
		fourthItem.add("15");		 	//LENGTH

		//fourthItem.add("B,Both,Y,Yes,N,No");//static values that need to be displayed as amtion.Send it along with the value that is inserted.
		finAr.add(fourthItem); 			//add to ArrayList obj finAr

		fifthItem = new ArrayList();
			fifthItem.add("Text");  	   	//Type of item
			fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.SubServiceCode.label","am_labels"));  		// label
			fifthItem.add("subservice_code");  	//name
			fifthItem.add("4");		   	// SIZE
			fifthItem.add("4");		   	//LENGTH
			//fifthItem.add("B,Both,E,Enabled,D,Disabled");//static values that need to be displayed as amtion.Send it along with the value that is inserted.
			finAr.add(fifthItem); 			//add to ArrayList obj finAr


		sixthItem = new ArrayList();
			sixthItem.add("Text");  		//Type of item
			sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.subservice.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	// label
			sixthItem.add("subservice_short_desc");	//name of field
			sixthItem.add("15");			// SIZE
			sixthItem.add("15");			//LENGTH
			finAr.add(sixthItem);			//add to ArrayList obj finAr

		 seventhItem = new ArrayList();
			seventhItem.add("Text");  		//Type of item
			seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));		// label
			seventhItem.add("dept_code");		//name of field
			seventhItem.add("10");			// SIZE
			seventhItem.add("10");			//LENGTH
			finAr.add(seventhItem);			//add to ArrayList obj finAr

		eightItem = new ArrayList();
			eightItem.add("Text");  		//Type of item
			eightItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	// label
			eightItem.add("dept_short_desc");	//name of field
			eightItem.add("15");			// SIZE
			eightItem.add("15");			//LENGTH
			finAr.add(eightItem);			//add to ArrayList obj finAr


		 ninthItem = new ArrayList();
			ninthItem.add("Text");  		//Type of item
			ninthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionCode.label","common_labels"));	 	// label
			ninthItem.add("section_code");	 	//name of field
			ninthItem.add("6");			// SIZE
			ninthItem.add("6");			//LENGTH
			finAr.add(ninthItem);			//add to ArrayList obj finAr

		 tenthItem = new ArrayList();
			tenthItem.add("Text");  		 //Type of item
			tenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionDescription.label","common_labels"));	  	 // label
			tenthItem.add("section_short_desc");	 //name of field
			tenthItem.add("15");			 // SIZE
			tenthItem.add("15");			 //LENGTH
			finAr.add(tenthItem);			 //add to ArrayList obj finAr

		eleventhItem = new ArrayList();
			eleventhItem.add("List");   		//Type of item
			eleventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels")); 		// label
			eleventhItem.add("eff_status");		//name
			eleventhItem.add("B, " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as amtion.Send it along with the value that is inserted.
			eleventhItem.add("1");		  	//LENGTH
			finAr.add(eleventhItem); 		//add to ArrayList obj finAr

String orderByCols[] = new String[10];
String orderByColVals[] = new String[10];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels");
orderByCols[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels");
orderByCols[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[3]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
orderByCols[4] =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.SubServiceCode.label","am_labels");  	
orderByCols[5]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.subservice.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
orderByCols[6]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[7]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
orderByCols[8] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionCode.label","common_labels");
orderByCols[9] =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionDescription.label","common_labels");

orderByColVals[0] = "operating_facility_id";
orderByColVals[1] = "facility_name";
orderByColVals[2] = "service_code";
orderByColVals[3] = "service_short_desc";
orderByColVals[4] = "subservice_code";
orderByColVals[5] = "subservice_short_desc";
orderByColVals[6] = "dept_code";
orderByColVals[7] = "dept_short_desc";
orderByColVals[8] = "section_code";
orderByColVals[9] = "section_short_desc";

strbuff = qrypg.getMultiColumnQueryPage(con,finAr,"Find SubService","../../eAM/jsp/SubserviceinfacilityQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Execute.label","common_labels"));

out.println(strbuff.toString());

}
catch (Exception e)
{}
finally
{	
	 finAr.clear();
	 firstItem.clear();
	 secondItem.clear();
	 thirdItem.clear();
	 fourthItem.clear();
	 fifthItem.clear();
	 sixthItem.clear();
	 seventhItem.clear();
	 eightItem.clear();
	 ninthItem.clear();
	 tenthItem.clear();
	 eleventhItem.clear();

	ConnectionManager.returnConnection(con,request);

}
%>
