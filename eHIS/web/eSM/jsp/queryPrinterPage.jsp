<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

      <html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head><html>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ; 

try {
	request.setCharacterEncoding("UTF-8");
//	con = (Connection) session.getValue( "connection" );
	con = ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();  

firstItem.add("Text");  	//Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.PrinterID.label","sm_labels"));	// label
firstItem.add("Printer_ID");	//name of field
firstItem.add("20");	// SIZE
firstItem.add("20");	//LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");  		 //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.PrinterName.label","sm_labels"));	// label
secondItem.add("Printer_Name");	//name of field
secondItem.add("60");	// SIZE
secondItem.add("60");	//LENGTH
finAr.add(secondItem);//add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("List");   //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.PrinterType.label","sm_labels"));  // label
thirdItem.add("Printer_Type");//name
thirdItem.add("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.Laser.label","sm_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.DMP.label","sm_labels")+",I,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.Inkjet.label","sm_labels")+",L,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Line.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.Printer.label","sm_labels")+",B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.LabelPrinter.label","sm_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
finAr.add(thirdItem); //add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();

fourthItem.add("List");   //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.ReportService.label","sm_labels"));  // label
fourthItem.add("report_service");//name
fourthItem.add("SELECT report_service_id, report_service_name from sm_report_service order by report_service_name");
finAr.add(fourthItem); //add to ArrayList obj finAr

ArrayList fifthItem = new ArrayList();

fifthItem.add("List");   //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
fifthItem.add("eff_status");//name
fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
finAr.add(fifthItem); //add to ArrayList obj finAr

String orderByCols[] = new String[3]; 
String orderByColVals[] = new String[3];  

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.PrinterID.label","sm_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.PrinterName.label","sm_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.PrinterType.label","sm_labels");


orderByColVals[0] = "printer_id";
orderByColVals[1] = "printer_name";
orderByColVals[2] = "printer_type";

strbuff = qrypg.getQueryPage(con,finAr,"Find Service","../jsp/queryPrinter.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());

        strbuff.setLength(0);
		finAr.clear();
        firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		fourthItem.clear();
		fifthItem.clear();

}catch(Exception e){//out.println(e);
	e.printStackTrace();
}
			finally { 
	ConnectionManager.returnConnection(con,request);
}
%>
