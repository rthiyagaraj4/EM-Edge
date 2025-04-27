<!DOCTYPE html>
<%@ page import ="java.sql.Connection, java.util.ArrayList,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String description =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
String functionID =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FunctionID.Label","ot_labels");
String systemDefinedDescription =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.SystemDefinedDescription.Label","ot_labels");
String url =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.URL.label","common_labels");
String linkedStatus =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.LinkedStatus.Label","ot_labels");
String checkForChecklistCompleted =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.CheckForChecklistCompleted.Label","ot_labels");
String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String yes =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
String no =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
String verificationApplicable =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.VerificationApplicable.Label","ot_labels");
String allowBarcode =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AllowBarcode.Label","ot_labels");
String functionsForRole =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FunctionsForRole.Label","ot_labels");


StringBuffer strbuff;

Connection con=null ;
try {

   con  =  ConnectionManager.getConnection(request);
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
		
firstItem.add("Text");           //Type of item
firstItem.add(functionID);     // label
firstItem.add("function_id");   //name of field
firstItem.add("2"); // SIZE
firstItem.add("2"); //LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");          //Type of item
secondItem.add(systemDefinedDescription);    // label
secondItem.add("function_desc_sys");  //name of field
secondItem.add("40");   // SIZE
secondItem.add("40");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");          //Type of item
thirdItem.add(description);    // label
thirdItem.add("function_desc_user");  //name of field
thirdItem.add("40");   // SIZE
thirdItem.add("40");   //LENGTH
finAr.add(thirdItem);    //add to ArrayList obj finAr


ArrayList fourthItem = new ArrayList();

fourthItem.add("Text");   //Type of item
fourthItem.add(url);  // label
fourthItem.add("url_desc");//name
fourthItem.add("50");
fourthItem.add("50");//static values that need to be displayed as 
finAr.add(fourthItem);

ArrayList fifthItem = new ArrayList();

fifthItem.add("Text");          //Type of item
fifthItem.add(linkedStatus);    // label
fifthItem.add("linked_status_code");  //name of field
fifthItem.add("2");   // SIZE
fifthItem.add("2");   //LENGTH
finAr.add(fifthItem);    //add to ArrayList obj finAr


ArrayList sixthItem = new ArrayList();

sixthItem.add("List");          //Type of item
sixthItem.add(checkForChecklistCompleted);    // label
sixthItem.add("check_for_check_list_compl");  //name of field
sixthItem.add("B,"+both+",Y,"+yes+",N,"+no);   // SIZE
 //LENGTH
finAr.add(sixthItem);    //add to ArrayList obj finAr

ArrayList seventhItem = new ArrayList();
seventhItem.add("List");   //Type of item
seventhItem.add(allowBarcode);  // label
seventhItem.add("allow_barcode");//name
seventhItem.add("B,"+both+",Y,"+yes+",N,"+no);//static values that need to be displayed as 
finAr.add(seventhItem);

ArrayList eigthItem = new ArrayList();
eigthItem.add("List");   //Type of item
eigthItem.add(verificationApplicable);  // label
eigthItem.add("verification_applicable");//name
eigthItem.add("B,"+both+",Y,"+yes+",N,"+no);//static values that need to be displayed as 
finAr.add(eigthItem);



String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[8];
	orderByColVals = new String[8];

	orderByCols[0] = functionID;
	orderByCols[1] = systemDefinedDescription;
	orderByCols[2] = description;
    orderByCols[3] = url;
    orderByCols[4] = linkedStatus;
    orderByCols[5] =checkForChecklistCompleted;
    orderByCols[6] = allowBarcode;
    orderByCols[7] = verificationApplicable;
    

    //orderByCols[3] = "Enabled";

	orderByColVals[0] = "function_id";
	orderByColVals[1] = "function_desc_sys";
	orderByColVals[2] = "function_desc_user";
	orderByColVals[3] = "url_desc";
    orderByColVals[4] = "linked_status_code";
	orderByColVals[5] = "check_for_check_list_compl";
	orderByColVals[6] = "allow_barcode";
	orderByColVals[7] = "verification_applicable";
	
	

strbuff = qrypg.getQueryPage( con,finAr,functionsForRole,"../../eOT/jsp/FunctionsQueryResult.jsp",sortorder,queryCriteria,select,orderby,orderByCols, orderByColVals,executequery);
out.println(strbuff.toString());
} catch (Exception e) {e.printStackTrace();}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%><input type='hidden' name='locale' id='locale' value="<%=locale%>">

