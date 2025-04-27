 <%-- saved on 27/10/2005 --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<% 
        request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
	  
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff = new StringBuffer();

try 
{
	
    String Service_Code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceCode.label","common_labels");

	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  		 //Type of item
	firstItem.add(Service_Code);	  // label
	firstItem.add("service_code");	//name of field
	firstItem.add("6");	// SIZE
	firstItem.add("4");	//LENGTH
	finAr.add(firstItem);//add to ArrayList obj finAr


    String Service_Description = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceDescription.label","common_labels");
    
	ArrayList secondItem=new ArrayList();
	secondItem.add("Text");  //Type of item
	secondItem.add(Service_Description);  // label
	secondItem.add("short_desc");   //name of field
	secondItem.add("15");	// SIZE
	secondItem.add("15");	//LENGTH
	finAr.add(secondItem); //add to ArrayList obj finAr


   String Generic_Name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GenericName.label","common_labels");

	ArrayList thirdItem=new ArrayList();
	thirdItem.add("Text");  //Type of item
	thirdItem.add(Generic_Name);  // label
	thirdItem.add("generic_name");   //name of field
	thirdItem.add("40");	// SIZE
	thirdItem.add("40");	//LENGTH
	finAr.add(thirdItem); //add to ArrayList obj finAr

	
	
	ArrayList fourthItem=new ArrayList();
		
		String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		String tpn_item_list_values="B,"+Both_legend+",E,"+enabled_legend+",D,"+Disabled_legend;
 
  String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");

	fourthItem.add("List");  //Type of item
	fourthItem.add(Nature);  // label
	fourthItem.add("eff_status");   //name of field
	fourthItem.add(tpn_item_list_values); //static values that need to be 
	fourthItem.add("7");	//LENGTH
	finAr.add(fourthItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[3];
	String orderByColVals[] = new String[3];

	orderByCols[0] = Service_Code;
	orderByCols[1] = Service_Description;
	orderByCols[2] = Generic_Name;
	
	orderByColVals[0] = "service_code";
	orderByColVals[1] = "short_desc";
	orderByColVals[2] = "generic_name";


 String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String GenericNameForService=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.GenericNameForService.label","ph_labels");
strbuff = qrypg.getQueryPage(null,finAr,GenericNameForService,"GenericNameForServiceQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect,orderBy,orderByCols, orderByColVals,ExecuteQuery);
	out.println(strbuff.toString());
}
catch (Exception e) { 
	out.println("main"+e); 
}
%>

