<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"
	import="webbeans.eCommon.*,java.sql.Connection,java.util.ArrayList"%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session	.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
%>

<html>
<head>
<link rel='stylesheet' type='text/css'	href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<%
try
{
		ecis.utils.CommonQueryPage querypage = new ecis.utils.CommonQueryPage();
		StringBuffer stringbuffer;
		Connection con = null;

		ArrayList finalArray = new ArrayList();
		ArrayList arrlist = new ArrayList();
		
		arrlist.add("Text");  		//Type of item
		arrlist.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UOMCode.label","common_labels"));	// label
		arrlist.add("txt_uomcode");	//name of field
		arrlist.add("4");			// size of field
		arrlist.add("4");			// length of field
		finalArray.add(arrlist);	// add ArrayList obj to finalArray
		
		arrlist = new ArrayList();
		arrlist.add("Text");  		 //Type of item
		arrlist.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.uom.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	 // label
		arrlist.add("txt_uomdesc");	 //name of field
		arrlist.add("15");			 // size of field
		arrlist.add("12");			 // length of field
		finalArray.add(arrlist);	 // add ArrayList obj to finalArray

		arrlist = new ArrayList();
		arrlist.add("Text");  		 //Type of item
		arrlist.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DecimalValue.label","ph_labels"));	 // label
		arrlist.add("txt_decimalvalue");	//name of field
		arrlist.add("4");			 // size of field
		arrlist.add("4");			 // length of field
		finalArray.add(arrlist);	// add ArrayList obj to finalArray
		
		arrlist = new ArrayList();
		arrlist.add("Text");  		 //Type of item
		arrlist.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FractionalValue.label","ph_labels"));	 // label
		arrlist.add("txt_fractionalvalue");	//name of field
		arrlist.add("15");			 // size of field
		arrlist.add("10");			 // length of field
		finalArray.add(arrlist);	// add ArrayList obj to finalArray
		
		arrlist = new ArrayList();
		arrlist.add("Text");  		 //Type of item
		arrlist.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FractionalDescription.label","ph_labels"));	 // label
		arrlist.add("txt_fractionaldesc");	//name of field
		arrlist.add("28");			 // size of field
		arrlist.add("25");			 // length of field
		finalArray.add(arrlist);	// add ArrayList obj to finalArray
		
		arrlist = new ArrayList();
		arrlist.add("Hidden"); //Type of item
		arrlist.add("mode"); //Name of field
		arrlist.add(mode);	//Value of field
		finalArray.add(arrlist);
		
		String orderByCols[] = new String[5];
		String orderByColVals[] = new String[5];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UOMCode.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.uom.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DecimalValue.label","ph_labels");
		orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FractionalValue.label","ph_labels");
		orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FractionalDescription.label","ph_labels");

		orderByColVals[0] = "A.UOM_CODE";
		orderByColVals[1] = "A.SHORT_DESC";
		orderByColVals[2] = "B.DECIMAL_VALUE";
		orderByColVals[3] = "B.FRACT_VALUE";
		orderByColVals[4] = "B.FRACT_DESC";

		stringbuffer = querypage.getQueryPage(con,finalArray,"Find Code","../jsp/PrescribingUomDecimalQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

		out.println(stringbuffer.toString());
	
		arrlist.clear();
		finalArray.clear();
}
catch(java.lang.Exception exception)
{
	out.println(exception.toString());
}
%>
