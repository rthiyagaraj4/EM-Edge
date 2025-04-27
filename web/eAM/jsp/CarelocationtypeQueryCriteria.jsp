<!DOCTYPE html>
<!--/*
				Developed by		   :		Geetha C R
				Developed on	 	   :	 	02/02/2001
				Modified Date	       :		23/02/2005							*/-->

<%@ page import ="java.sql.*, java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link><Script Language="JavaScript" src="../../eCommon/js/common.js"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></html></head>
<%
request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

try 
{
	con = ConnectionManager.getConnection(request);



ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.CareLocationType.label","am_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	  // label
firstItem.add("locn_type");	//name of field
firstItem.add("1");	// SIZE
firstItem.add("1");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr 

ArrayList secondItem=new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.CareLocationType.label","am_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));  // label
secondItem.add("long_desc");   //name of field
secondItem.add("30");	// SIZE
secondItem.add("30");	//LENGTH

finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList thirdItem=new ArrayList();

thirdItem.add("List");  //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.CareLocationType.label","am_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.INDICATOR.label","common_labels"));  // label
thirdItem.add("LocnTypeList");   //name of field
//thirdItem.add("a,All,R,Room,C,Clinic,N,Nursing Unit,E,Exam/Procedure Unit,B,Bed,W,Radiology Wing,S,Study Location,T,Operation Theatre(All),O,Operation Theatre(Spec),D,Daycare Unit");//static values that need to be displayed as option.Send it along with the value that is inserted.
thirdItem.add("a,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Bed.label","common_labels")+",C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ExamProcedureUnit.label","am_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+",T,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.OperationTheatreAll.label","am_labels")+",O,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.OperationTheatrespec.label","am_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels")+",W,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RadiologyWing.label","common_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.StudyLocation.label","am_labels"));
thirdItem.add("3");	//LENGTH

finAr.add(thirdItem); //add to ArrayList obj finAr

ArrayList fourthItem=new ArrayList();

fourthItem.add("List");  //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UserDefined.label","common_labels"));  // label
fourthItem.add("user_defined");   //name of field
fourthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",U,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
fourthItem.add("3");	//LENGTH

finAr.add(fourthItem); //add to ArrayList obj finAr


String orderByCols[] = new String[2];
String orderByColVals[] = new String[2];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.CareLocationType.label","am_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.CareLocationType.label","am_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
//orderByCols[2] = "Care Location Type Indicator";


orderByColVals[0] = "locn_type";
orderByColVals[1] = "long_desc";
//orderByColVals[2] = "care_locn_type_ind";

strbuff = qrypg.getQueryPage(con,finAr,"Find Speciality For Practitioner","../../eAM/jsp/CarelocationtypeQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());
firstItem.clear();
	fourthItem.clear();
	secondItem.clear();
	thirdItem.clear();
	finAr.clear();
} catch (Exception e) {}
finally
{
	
	ConnectionManager.returnConnection(con,request);
}
%>

