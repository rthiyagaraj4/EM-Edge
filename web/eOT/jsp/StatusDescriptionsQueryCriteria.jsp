<!DOCTYPE html>
<%@ page import ="java.sql.Connection, java.util.ArrayList,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*"  %>
<%@ page contentType="text/html;charset=UTF-8"%>
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
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
String code =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.StatusCode.Label","ot_labels")  ;
String systemDefinedDescription =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.SystemDefinedDescription.Label","ot_labels")  ;
String backGroundColor =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.BackGroundColor.Label","ot_labels")  ;

String textColor =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.TextColor.Label","ot_labels")  ;
String description  =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels")  ;

String statusCode  =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.StatusCode.Label","ot_labels")  ;
String color =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.BackGroundColor.Label","ot_labels")  ;

String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels")  ;
String QueryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels")  ;
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

String all	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
String black	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Black.Label","ot_labels");
String white	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.White.Label","ot_labels");

String blue	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Blue.Label","ot_labels");
String lightblue =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.LightBlue.Label","ot_labels");
String darkblue	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DarkBlue.Label","ot_labels");
String green	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Green.label","common_labels");
String lightgreen =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.LightGreen.Label","ot_labels");
String darkgreen =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DarkGreen.Label","ot_labels");
String yellow	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Yellow.label","common_labels");
String red		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Red.label","common_labels");
String darkred	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DarkRed.Label","ot_labels");
String magenta	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Magenta.Label","ot_labels");
String brown	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Brown.Label","ot_labels");
String violet	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Violet.Label","ot_labels");
String indigo	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Indigo.Label","ot_labels");
String orange	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Orange.Label","ot_labels");
String pink		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Pink.Label","ot_labels");
String grey		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Gray.Label","ot_labels");
String cyan		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Cyan.Label","ot_labels");
String darkcyan	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DarkCyan.Label","ot_labels");
String purple	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Purple.Label","ot_labels");

Connection con=null ;
try {

 con  =  ConnectionManager.getConnection(request);
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
		
firstItem.add("Text");           //Type of item
firstItem.add(code);     // label
firstItem.add("status_code");   //name of field
firstItem.add("2"); // SIZE
firstItem.add("2"); //LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");          //Type of item
secondItem.add(systemDefinedDescription);    // label
secondItem.add("status_desc_sysdef");  //name of field
secondItem.add("40");   // SIZE
secondItem.add("40");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");          //Type of item
thirdItem.add(description);    // label
thirdItem.add("status_desc");  //name of field
thirdItem.add("40");   // SIZE
thirdItem.add("40");   //LENGTH
finAr.add(thirdItem);    //add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();

fourthItem.add("List");   //Type of item
fourthItem.add(backGroundColor);  // label
fourthItem.add("color_ind");//name
fourthItem.add("all,"+all+",BLUE,"+blue+",LIGHTBLUE,"+lightblue+",DARKBLUE,"+darkblue+",GREEN,"+green+",LIGHTGREEN,"+lightgreen+",DARKGREEN,"+darkgreen+",YELLOW,"+yellow+",RED,"+red+",DARKRED,"+darkred+",MAGANTA,"+magenta+",BROWN,"+brown+",VIOLET,"+violet+",INDIGO,"+indigo+",ORANGE,"+orange+",PINK,"+pink+",GREY,"+grey+",CYAN,"+cyan+",DARKCYAN,"+darkcyan+",PURPLE,"+purple+"");//static values that need to be displayed as 
finAr.add(fourthItem); //add to ArrayList obj finAr

ArrayList fifthItem = new ArrayList();

fifthItem.add("List");   //Type of item
fifthItem.add(textColor);  // label
fifthItem.add("text_color");//name
fifthItem.add("all,"+all+",BLACK,"+black+",WHITE,"+white+"");//static values that need to be displayed as 
finAr.add(fifthItem);

String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[5];
	orderByColVals = new String[5];

	orderByCols[0] =statusCode;
	orderByCols[1] = systemDefinedDescription;
	orderByCols[2] = description;
    orderByCols[3] = color;
    orderByCols[4] = textColor;

	orderByColVals[0] = "status_code";
	orderByColVals[1] = "status_desc_sysdef";
	orderByColVals[2] = "status_desc";
	orderByColVals[3] = "color_ind";
    orderByColVals[4] = "text_color";

strbuff = qrypg.getQueryPage( con,finAr,"StatusDescriptions ","../../eOT/jsp/StatusDescriptionsQueryResult.jsp",sortorder,QueryCriteria,select,orderby,orderByCols, orderByColVals,executequery);
out.println(strbuff.toString());
} catch (Exception e) {e.printStackTrace();}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

