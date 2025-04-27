<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

      <html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head><html>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
Connection con	=null ;
request.setCharacterEncoding("UTF-8");
ArrayList finAr = new ArrayList();
String res_grp_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.ResourceGroupID.label","sm_labels");
	ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 	//Type of item
		firstItem.add(res_grp_id);		// label
		firstItem.add("ORA_RSRC_GROUP_ID");		//name of field
		firstItem.add("20");				// SIZE
		firstItem.add("20");				//LENGTH
	finAr.add(firstItem);					//add to ArrayList obj finAr

	ArrayList secondItem=new ArrayList();
	String res_grp_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.ResourceGroupName.label","sm_labels");
		secondItem.add("Text");  			//Type of item
		secondItem.add(res_grp_name);  	// label
		secondItem.add("ORA_RSRC_GROUP_NAME");  	//name of field
		secondItem.add("30");				// SIZE
		secondItem.add("30");				//LENGTH
	finAr.add(secondItem); 					//add to ArrayList obj finAr

String orderByCols[] = new String[2];
String orderByColVals[] = new String[2];

//out.println(finAr);
orderByCols[0] =res_grp_id;
orderByCols[1] =res_grp_name;

orderByColVals[0] = "ORA_RSRC_GROUP_ID";
orderByColVals[1] = "ORA_RSRC_GROUP_NAME";

strbuff = qrypg.getQueryPage(con,finAr,"Menu Admin","../jsp/DatabaseRsrcgrpQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");
out.println(strbuff.toString());

        strbuff.setLength(0);
		finAr.clear();
		secondItem.clear();
		firstItem.clear();
%>
