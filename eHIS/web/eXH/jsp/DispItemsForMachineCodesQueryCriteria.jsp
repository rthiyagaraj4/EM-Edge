<!DOCTYPE html>
<HTML>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet, java.util.ArrayList,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));
locale = "en"; %>
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
sStyle = "IeStyle.css";
%>
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
</HEAD>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con=null ;
try {
 
con  =  ConnectionManager.getConnection(request);
ArrayList finAr = new ArrayList();
							    
ArrayList firstItem = new ArrayList();

firstItem.add("Text");          //Type of item {"eXH.MachineCode.label", "Machine Codes"},
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.DispLocnCode.label","common_labels"));
firstItem.add("disp_locn_code");  //name of field
firstItem.add("10");   // SIZE
firstItem.add("10");   //LENGTH
finAr.add(firstItem);    //add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");          //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.DispLocnDesc.label","common_labels"));
secondItem.add("disp_locn_desc");  //name of field
secondItem.add("40");   // SIZE
secondItem.add("40");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr


ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");   //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Machine.label","common_labels"));
thirdItem.add("machine_code");//name
thirdItem.add("2");//static values that need to be displayed as 
thirdItem.add("2");
finAr.add(thirdItem);

ArrayList fourthItem = new ArrayList();

fourthItem.add("Text");   //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.MachineDesc.label","common_labels"));
fourthItem.add("machine_desc");//name
fourthItem.add("60");//static values that need to be displayed as 
fourthItem.add("60");
finAr.add(fourthItem);

ArrayList fifthItem = new ArrayList();

fifthItem.add("Text");   //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.item.label","common_labels"));
fifthItem.add("item_code");//name
fifthItem.add("20");//static values that need to be displayed as 
fifthItem.add("20");
finAr.add(fifthItem);

ArrayList sixthItem = new ArrayList();

sixthItem.add("Text");   //Type of item
sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.itemDesc.label","common_labels"));
sixthItem.add("item_desc");//name
sixthItem.add("60");//static values that need to be displayed as 
sixthItem.add("60");
finAr.add(sixthItem);




String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[6];
	orderByColVals = new String[6]; 

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.DispLocnCode.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.DispLocnDesc.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.MachineCode.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.MachineDesc.label","common_labels");
	orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.item.label","common_labels");
	orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.itemDesc.label","common_labels");
	

	/*orderByColVals[0] = "1";
	orderByColVals[1] = "2";
	orderByColVals[2] = "3";
	orderByColVals[3] = "4";
	orderByColVals[4] = "5";
	orderByColVals[5] = "6";*/
	orderByColVals[0] = "DISP_LOCN_CODE";
	orderByColVals[1] = "disp_locn_name";
	orderByColVals[2] = "MACHINE_CODE";
	orderByColVals[3] = "machine_name";
	orderByColVals[4] = "ITEM_CODE";
	orderByColVals[5] = "item_name";
strbuff = qrypg.getQueryPage(  con,finAr,"InterfaceAPI","../../eXH/jsp/DispItemsForMachineCodesQueryResult.jsp",""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","xh_labels")+"",""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","xh_labels")+"",""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","xh_labels")+"" ,""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","xh_labels")+"",orderByCols, orderByColVals,""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","xh_labels")+"");	

out.println(strbuff.toString());

firstItem.clear();
secondItem.clear();
thirdItem.clear();

finAr.clear();
} catch (Exception e) {
	System.out.println("DispItemForMachineCodesQueryCriteria.jsp Exception :: "+e.getMessage());
	e.printStackTrace();
}

finally
{
   if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</HTML>
