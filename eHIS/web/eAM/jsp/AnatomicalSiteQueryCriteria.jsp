<!DOCTYPE html>
<%--
	FileName	: AnatomicalSiteQueryCriteria.jsp
	Version	    : 3	
	Modified On	: 21-2-2005
--%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</html></head>
<%
	request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con		= null ;

try
{
	
ArrayList finAr 	= new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		//Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.AnatomicalSiteCode.label","am_labels"));		//label
firstItem.add("anatomical_site_code");		//name of field
firstItem.add("4");				// SIZE
firstItem.add("4");			    //LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem	= new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AnatomicalSite.label","common_labels")+""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));  // label
secondItem.add("long_desc");   //name of field
secondItem.add("30");	// SIZE
secondItem.add("30");	//LENGTH

finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList thirdItem	 = new ArrayList();

thirdItem.add("List");   //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ApplicabletoISS.label","am_labels"));  // label
thirdItem.add("applicable_to_iss_yn");//name
thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
finAr.add(thirdItem); //add to ArrayList obj finAr

ArrayList fourthItem	 = new ArrayList();

fourthItem.add("List");   //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.OralCavity.label","mr_labels"));  // label
fourthItem.add("oral_cavity_yn");//name
fourthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
finAr.add(fourthItem); //add to ArrayList obj finAr

ArrayList fifthItem	 = new ArrayList();

fifthItem.add("List");   //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
fifthItem.add("eff_status");//name
fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
finAr.add(fifthItem); //add to ArrayList obj finAr

String orderByCols[] 	= new String[4];
String orderByColVals[] = new String[4];


orderByCols[0] 		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.AnatomicalSiteCode.label","am_labels");
orderByCols[1]		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AnatomicalSite.label","common_labels")+""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
orderByCols[2]		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ApplicabletoISS.label","am_labels");
orderByCols[3]		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.OralCavity.label","mr_labels");


orderByColVals[0] 	 = "anatomical_site_code";
orderByColVals[1] 	 = "long_desc";
orderByColVals[2] 	 = "applicable_to_iss_yn";
orderByColVals[3] 	 = "oral_cavity_yn";


strbuff 		= qrypg.getQueryPage(con,finAr,"Find Site" ,"../../eAM/jsp/AnatomicalSiteQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());

		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		fourthItem.clear();
		fifthItem.clear();
		finAr.clear();
}catch (Exception e)  {}
finally
	{
		 ConnectionManager.returnConnection(con,request);
	}
%>

