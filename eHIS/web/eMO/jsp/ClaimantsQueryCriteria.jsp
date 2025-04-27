<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

 <%String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

      <html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head><html>
<%
request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;
//String facilityId = (String)session.getValue("facility_id");

/*Added by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
try {
	con = ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();
firstItem.add("Text");  		//Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.Claimant.label","mo_labels") +" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	// label
firstItem.add("claimant_type_code");			//name of field
firstItem.add("4");			// SIZE
firstItem.add("4");			//LENGTH
finAr.add(firstItem);			//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();
secondItem.add("Text");  		 //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.Claimant.label","mo_labels") +" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	 // label
secondItem.add("long_desc");		 //name of field
secondItem.add("44");			 // SIZE
secondItem.add("40");			 //LENGTH
finAr.add(secondItem);			 //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();
thirdItem.add("List");  		 //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.ClaimantTypeRelat.label","mo_labels"));	 // label
thirdItem.add("Claimant_type");		 //name of field
/*Added by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
thirdItem.add("SELECT claimant_type_mstr_code, short_desc FROM mo_claimant_type_mstr WHERE eff_status = 'E' AND claimant_type_mstr_code NOT IN ('K', 'E', 'F') order by short_desc asc");

/*thirdItem.add("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",M,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.EmbassyCountry.label","mo_labels")+",O,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.ReligiousOrgn.label","mo_labels")+",U,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.UnderTaker.label","mo_labels")+",W,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.WelfareAssociations.label","mo_labels"));  // SIZE*/

/*End ML-MMOH-CRF-1095*/

finAr.add(thirdItem);			 //add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();
fourthItem.add("List");   		 //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));     // label
fourthItem.add("eff_status");   	 //name
//fourthItem.add("B,Both,E,Enabled,D,Disabled");	 //static values that need to be displayed as amtion.Send it along with the value that is inserted.
fourthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));

finAr.add(fourthItem); 			 //add to ArrayList obj finAr
      
String orderByCols[] = new String[3];
String orderByColVals[] = new String[3];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.Claimant.label","mo_labels") +" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.Claimant.label","mo_labels") +" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.ClaimantTypeRelat.label","mo_labels");


orderByColVals[0] = "claimant_type_code";
orderByColVals[1] = "long_desc";
orderByColVals[2] = "Claimant_type";



strbuff = qrypg.getQueryPage(con,finAr,"FIND CLAIMANT","../jsp/ClaimantsQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
strbuff.setLength(0);
firstItem.clear();
secondItem.clear();
thirdItem.clear();
fourthItem.clear();
finAr.clear();

} catch (Exception e) 
{
	out.println(e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
