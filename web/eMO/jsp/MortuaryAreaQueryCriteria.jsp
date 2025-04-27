<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");

%>

      <html><head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
	  </head><html>
<%
     ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

    StringBuffer strbuff;
    Connection con=null ;

    ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  		 //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AreaCode.label","common_labels"));	  // label
	firstItem.add("area_code");	//name of field
	firstItem.add("4");	// SIZE
	firstItem.add("4");	//LENGTH
	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem=new ArrayList();
	secondItem.add("Text");  //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AreaDesc.label","mp_labels"));  // label
	secondItem.add("long_desc");   //name of field
	secondItem.add("40");	// SIZE
	secondItem.add("40");	//LENGTH
	finAr.add(secondItem); //add to ArrayList obj finAr

	ArrayList seventhItem = new ArrayList();
	seventhItem.add("List");   //Type of item
	seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.AreaType.label","mo_labels"));  // label
	seventhItem.add("Area_Type");//name
	seventhItem.add("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.StorageArea.label","mo_labels")+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.PostmortemArea.label","mo_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.ReleaseArea.label","mo_labels")+",O,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels"));
	//static values that need to be displayed as option.Send it along with the value that is inserted.
	finAr.add(seventhItem); //add to ArrayList obj finAr

    ArrayList thirdItem=new ArrayList();
	thirdItem.add("List");  //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
	thirdItem.add("enabled");   //name of field
	thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));
    finAr.add(thirdItem); //add to ArrayList obj finAr

	String orderByCols[]	= new String[3];
	String orderByColVals[] = new String[3];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AreaCode.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AreaDesc.label","mp_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.AreaType.label","mo_labels");

	orderByColVals[0] = "area_code";
	orderByColVals[1] = "long_desc";
	orderByColVals[2] = "Area_Type";


    strbuff = qrypg.getQueryPage(con,finAr,"Find Site" ,"../../eMO/jsp/MortuaryAreaQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

    out.println(strbuff.toString());
	strbuff.setLength(0);
    firstItem.clear();
    secondItem.clear();
	thirdItem.clear();
    seventhItem.clear();
    finAr.clear();
	
%>

