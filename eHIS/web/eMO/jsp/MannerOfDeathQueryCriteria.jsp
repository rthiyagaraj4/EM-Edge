<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");

%>

      <html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link><script src='../../eCommon/js/common.js' language='javascript'></script></head><html>

<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con=null ;
//Added By shanmukh on 7th-AUG-2018 for ML-MMOH-CRF-1096
Boolean isDeathCasesAppl;
Connection conn = ConnectionManager.getConnection(request);
isDeathCasesAppl = eCommon.Common.CommonBean.isSiteSpecific(conn,"MO","DEATH_CASES_APPL");
//END
try {
	con = (Connection) session.getValue( "connection" );
} catch (Exception e) {}
finally{
	 	 ConnectionManager.returnConnection(conn,request);
		 ConnectionManager.returnConnection(con,request);
	 }

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();
firstItem.add("Text");  	//Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.MannerOfDeathCode.label","mo_labels"));	// label
firstItem.add("DEATH_MANNER_CODE");	//name of field
firstItem.add("4");	// SIZE
firstItem.add("4");	//LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();
secondItem.add("Text");  		 //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.MannerOfDeathDesc.label","mo_labels"));	  // label
secondItem.add("long_desc");	//name of field
secondItem.add("40");	// SIZE
secondItem.add("40");	//LENGTH
finAr.add(secondItem);//add to ArrayList obj finAr

ArrayList fifthItem = new ArrayList();
fifthItem.add("List");   //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
fifthItem.add("EFF_STATUS");//name
fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
finAr.add(fifthItem); //add to ArrayList obj finAr

//Added By shanmukh on 7th-AUG-2018 for ML-MMOH-CRF-1096
ArrayList sixthItem = new ArrayList();
if(isDeathCasesAppl){
sixthItem.add("List");   //Type of item
sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Death.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.Cases.label","ae_labels"));  // label
sixthItem.add("QUERY_DEATH_CASE");//name
sixthItem.add(" ,"+"-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----"+",A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.Accident.label","ip_labels")+",M,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.murder.label","mo_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.suicide.label","mo_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.natural.label","mo_labels")+",UD,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.undetermined.label","mo_labels")+",UC,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.unclassified.label","mo_labels")+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.pending.label","mo_labels")+",O,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels"));
finAr.add(sixthItem); //add to ArrayList obj finAr
}
//END
String orderByCols[] = new String[2];
String orderByColVals[] = new String[2];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.MannerOfDeathCode.label","mo_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.MannerOfDeathDesc.label","mo_labels");

orderByColVals[0] = "DEATH_MANNER_CODE";
orderByColVals[1] = "long_desc";

strbuff = qrypg.getQueryPage(con,finAr,"Find Service","../jsp/MannerOfDeathQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());
strbuff.setLength(0);
secondItem.clear();
fifthItem.clear();
firstItem.clear();
sixthItem.clear();
finAr.clear();

%>

