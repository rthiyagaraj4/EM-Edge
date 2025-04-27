<!DOCTYPE html>
<%@ page import ="java.sql.Connection, java.util.ArrayList,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*"  %>

<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String stageCode =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StageCode.label","common_labels");
String preStageDescription =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PreStageDescription.Label","ot_labels");
String postStageDescription =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PostStageDescription.Label","ot_labels");
String specificIndicator =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.SpecificIndicator.Label","ot_labels");
String preAnaesthesiaEvalStage =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PreAnaesthesiaEvalStage.Label","ot_labels");
String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String yes =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
String no =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
String swabandInstrumentCount =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.SwabandInstrumentCount.Label","ot_labels");

StringBuffer strbuff;

Connection con=null ;
try {

   con  =  ConnectionManager.getConnection(request);
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
		
firstItem.add("Text");           //Type of item
firstItem.add(stageCode);     // label
firstItem.add("stage_code");   //name of field
firstItem.add("2"); // SIZE
firstItem.add("2"); //LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");          //Type of item
secondItem.add(preStageDescription);    // label
secondItem.add("pre_stage_desc");  //name of field
secondItem.add("30");   // SIZE
secondItem.add("30");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem= new ArrayList();

thirdItem.add("Text");          //Type of item
thirdItem.add(postStageDescription);    // label
thirdItem.add("post_stage_desc");  //name of field
thirdItem.add("30");   // SIZE
thirdItem.add("30");   //LENGTH
finAr.add(thirdItem);    //add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();

fourthItem.add("Text");          //Type of item
fourthItem.add(specificIndicator);    // label
fourthItem.add("specific_ind");  //name of field
fourthItem.add("10");   // SIZE
fourthItem.add("10");

finAr.add(fourthItem);    //add to ArrayList obj finAr

ArrayList fifthItem = new ArrayList();

fifthItem.add("List");          //Type of item
fifthItem.add(preAnaesthesiaEvalStage);    // label
fifthItem.add("pac_stage_yn");  //name of field
fifthItem.add("B,"+both+",Y,"+yes+",N,"+no);   // SIZE

finAr.add(fifthItem);    //add to ArrayList obj finAr


String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[3];
	orderByColVals = new String[3];

	orderByCols[0] = stageCode;
	orderByCols[1] = preStageDescription;
    orderByCols[2] = postStageDescription;
       
	

	orderByColVals[0] = "stage_code";
	orderByColVals[1] = "pre_stage_desc";
	orderByColVals[2] = "post_stage_desc";

strbuff = qrypg.getQueryPage( con,finAr,swabandInstrumentCount,"../../eOT/jsp/BookingFinalisationStagesQueryResult.jsp",sortorder,queryCriteria,select,orderby,orderByCols, orderByColVals,executequery);
out.println(strbuff.toString());
} catch (Exception e) {e.printStackTrace();}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%><input type='hidden' name='locale' id='locale' value="<%=locale%>">

