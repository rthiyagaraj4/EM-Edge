<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

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

Connection con = null;

try {
	con = ConnectionManager.getConnection(request); 


ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FSLocationCode.label","fm_labels"));	   //label
firstItem.add("FS_LOCN_CODE");	//name of field
firstItem.add("8");	// SIZE
firstItem.add("8");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");  		// Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileStorageLocationDesc.label","fm_labels"));	   //label
secondItem.add("LONG_DESC");	//name of field
secondItem.add("30");	 //SIZE
secondItem.add("30");	//LENGTH

finAr.add(secondItem);//add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");  		// Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MRSectionCode.label","common_labels"));	   //label
thirdItem.add("MR_SECTION_CODE");	//name of field
thirdItem.add("2");	 //SIZE
thirdItem.add("2");	//LENGTH

finAr.add(thirdItem);//add to ArrayList obj finAr

ArrayList fourthItem=new ArrayList();

fourthItem.add("List");  //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FSLocation.label","fm_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.BelongstoMRD.label","fm_labels"));  /// label
fourthItem.add("MR_LOCN_YN");  // name of field
fourthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as 

finAr.add(fourthItem); //add to ArrayList obj finAr

ArrayList fifthItem=new ArrayList();

fifthItem.add("List");  //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.PermanentFSLocation.label","fm_labels"));  /// label
fifthItem.add("PERMANENT_FILE_AREA_YN");  // name of field
fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as 

finAr.add(fifthItem); //add to ArrayList obj finAr

ArrayList sixthItem=new ArrayList();

sixthItem.add("List");  //Type of item
sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FSLocationIdentity.label","fm_labels"));  /// label
sixthItem.add("LOCN_IDENTITY");  // name of field
sixthItem.add("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels")+",C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+",T,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"));//static values that need to be displayed as 

finAr.add(sixthItem); //add to ArrayList obj finAr

ArrayList seventhItem = new ArrayList();

seventhItem.add("Text");  		// Type of item
seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.HolderName.label","fm_labels"));	   //label
seventhItem.add("HOLDER_NAME");	//name of field
seventhItem.add("30");	 //SIZE
seventhItem.add("30");	//LENGTH

finAr.add(seventhItem);//add to ArrayList obj finAr


ArrayList eighthItem=new ArrayList();

eighthItem.add("List");  //Type of item
eighthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  /// label
eighthItem.add("EFF_STATUS");  // name of field
eighthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as 

finAr.add(eighthItem); //add to ArrayList obj finAr

String orderByCols[] = new String[6];
String orderByColVals[] = new String[6];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FSLocationCode.label","fm_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileStorageLocationDesc.label","fm_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MRSectionCode.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FSLocation.label","fm_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.BelongstoMRD.label","fm_labels");
orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.PermanentFSLocation.label","fm_labels");
orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FSLocationIdentity.label","fm_labels");

orderByColVals[0] = "FS_LOCN_CODE";
orderByColVals[1] = "LONG_DESC";
orderByColVals[2] = "MR_SECTION_CODE";
orderByColVals[3] = "MR_LOCN_YN";
orderByColVals[4] = "PERMANENT_FILE_AREA_YN";
orderByColVals[5] = "LOCN_IDENTITY";

strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.Narration.label","fm_labels"),"../../eFM/jsp/FMFileStorageLocnQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());

	finAr.clear(); 
	firstItem.clear(); 
	secondItem.clear(); 
	thirdItem.clear(); 
	fourthItem.clear(); 
	fifthItem.clear(); 
	sixthItem.clear(); 
	seventhItem.clear(); 
	eighthItem.clear();
}
catch (Exception e) 
{
	out.println("Exception e :"+e);
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
