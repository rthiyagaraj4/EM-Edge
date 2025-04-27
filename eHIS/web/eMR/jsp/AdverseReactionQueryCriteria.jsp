<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" %>
   <%String sStyle	=
   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

try {
	con=ConnectionManager.getConnection(request);


ArrayList finAr = new ArrayList();

ArrayList FirstItem=new ArrayList();

FirstItem.add("Text");  //Type of item
FirstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AdverseReaction Code.label","mr_labels"));  // label
//FirstItem.add("Adverse Reaction Code");  // label
FirstItem.add("REACTION_CODE");   //name of field
FirstItem.add("4");	// SIZE
FirstItem.add("4");	//LENGTH

finAr.add(FirstItem); //add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AdverseReaction Desc.label","mr_labels"));  // label
//secondItem.add("Adverse Reaction Desc");  // label
secondItem.add("a.long_desc");   //name of field
secondItem.add("30");	// SIZE
secondItem.add("30");	//LENGTH

finAr.add(secondItem); //add to ArrayList obj finAr


ArrayList ThirdItem=new ArrayList();

ThirdItem.add("Text");  //Type of item
ThirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AllergenCode.label","mr_labels"));  // label
//ThirdItem.add("Allergen Code");  // label
ThirdItem.add("b.allergen_code");   //name of field
ThirdItem.add("4");	// SIZE
ThirdItem.add("4");	//LENGTH

finAr.add(ThirdItem); //add to ArrayList obj finAr

ArrayList fourthItem=new ArrayList();

fourthItem.add("Text");  //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Allergendesc.label","mr_labels"));  // label
//fourthItem.add("Allergen Desc");  // label
fourthItem.add("c.short_desc");   //name of field
fourthItem.add("30");	// SIZE
fourthItem.add("30");	//LENGTH

finAr.add(fourthItem); //add to ArrayList obj finAr


ArrayList fifthItem=new ArrayList();

fifthItem.add("List");  //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AdverseEventTypeIndicator.label","mr_labels"));  // label
//fifthItem.add("Adverse Event Type Ind");  // label
fifthItem.add("ADV_EVENT_TYPE_IND_DESC");   //name of field
fifthItem.add("Select ADV_EVENT_TYPE_IND,ADV_EVENT_TYPE_IND_DESC from MR_ADV_EVENT_TYPE_IND order by ADV_EVENT_TYPE_IND_DESC");//static 
finAr.add(fifthItem); //add to ArrayList obj finAr

/*Friday, February 11, 2011 , Added for SRR20056-SCF-6860 [IN:026456]*/
ArrayList sixthItem=new ArrayList();

sixthItem.add("List");  //Type of item
sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AdverseEventType.label","mr_labels"));  // label
sixthItem.add("ADV_EVENT_TYPE_CODE");   //name of field
sixthItem.add("O,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels")+",DA,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PHGeneric.label","mr_labels"));//static 
finAr.add(sixthItem);
/**/

String orderByCols[] = new String[5];
String orderByColVals[] = new String[5];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AdverseReaction Code.label","mr_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AdverseReaction Desc.label","mr_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AllergenCode.label","mr_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Allergendesc.label","mr_labels");
orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AdverseEventTypeIndicator.label","mr_labels");


orderByColVals[0] = "REACTION_CODE";
orderByColVals[1] = "upper(long_desc)";
orderByColVals[2] = "ALLERGEN_CODE";
//orderByColVals[3] = "long_desc";
orderByColVals[3] = "upper(causitive_desc)";
orderByColVals[4] = "ADV_EVENT_TYPE_IND_DESC";

/*strbuff = qrypg.getQueryPage(con,finAr,"Find HighRisk","../jsp/AdverseReactionQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order by",orderByCols, orderByColVals,"Execute Query");*/
strbuff = qrypg.getQueryPage(con,finAr,"Find HighRisk","../jsp/AdverseReactionQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());

finAr.clear();
FirstItem.clear();
secondItem.clear();
ThirdItem.clear();
fourthItem.clear();
fifthItem.clear();

} catch (Exception e) {
		out.println("Exception "+e.toString());
		e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}

%>
