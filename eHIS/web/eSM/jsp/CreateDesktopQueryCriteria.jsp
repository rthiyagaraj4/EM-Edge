<!DOCTYPE html>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></html></head>
<%! ArrayList finAr;
	ArrayList firstItem;
	ArrayList secondItem;
	ArrayList thirdItem;
	ArrayList fourthItem;
	ArrayList fifthItem;
	ArrayList sixthItem;
	StringBuffer strbuff;
	%>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

Connection con=null ;

try
{
	 con=   ConnectionManager.getConnection(request);

	finAr = new ArrayList();

  String desktopcode=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.Desktop.label","sm_labels");
desktopcode=desktopcode+"     "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	firstItem = new ArrayList();
	firstItem.add("Text");  		 		//Type of item
	firstItem.add(desktopcode);  		// label
	firstItem.add("desktop_code");			//name of field
	firstItem.add("10");						// SIZE
	firstItem.add("10");						//LENGTH
	finAr.add(firstItem);					//add to ArrayList obj finAr

   String desktopname=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.Desktop.label","sm_labels");
desktopname=desktopname+"     "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels");

    secondItem=new ArrayList();
	secondItem.add("Text");  				//Type of item
	secondItem.add(desktopname);  		// label
	secondItem.add("desktop_name");    //name of field
	secondItem.add("60");					// SIZE
	secondItem.add("60");					//LENGTH
	finAr.add(secondItem); 					//add to ArrayList obj finAr


	thirdItem = new ArrayList();
	thirdItem.add("List");   				//Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.user.label","common_labels")+"  "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.Type.label","sm_labels"));  	// label
	thirdItem.add("user_type");		//name
	thirdItem.add("A, " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Clinician.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.Non.label","sm_labels")+"  "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Clinician.label","common_labels"));						// SIZE
//	thirdItem.add("10");						//LENGTH
	finAr.add(thirdItem); 
    

	fourthItem = new ArrayList();
	fourthItem.add("List");   				//Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Module.label","common_labels"));  	// label
	fourthItem.add("module_id");		//name
	fourthItem.add("Select  module_id,module_name from sm_module   where install_yn='Y'  order by 2");						// SIZE
//	thirdItem.add("10");						//LENGTH
	finAr.add(fourthItem); 					//add to ArrayList obj finAr

	fifthItem = new ArrayList();
	fifthItem.add("Text");   				//Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Function.label","common_labels"));  	// label
	fifthItem.add("function_id");	//name
	fifthItem.add("30");					// SIZE
	fifthItem.add("30");					//LENGTH
	finAr.add(fifthItem); 					//add to ArrayList obj finAr

	sixthItem=new ArrayList();
	sixthItem.add("List");  				//Type of item
	sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  				// label
	sixthItem.add("eff_status");   			//name of field
	sixthItem.add("B, " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
	sixthItem.add("1");						//LENGTH
	finAr.add(sixthItem); 					//add to ArrayList obj finAr



	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];


	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.Desktop.label","sm_labels")+" " + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.Desktop.label","sm_labels")+" " + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Module.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Function.label","common_labels");

	orderByColVals[0] = "DESKTOP_SUMMARY_ID";
	orderByColVals[1] = "DESKTOP_SUMMARY_NAME";
	orderByColVals[2] = "DFLT_MODULE_ID";
	orderByColVals[3] = "DFLT_FUNCTION_ID";
	



	strbuff = qrypg.getQueryPage(con,finAr,"Find Desktop ","../../eSM/jsp/CreateDesktopQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Execute.label","common_labels"));

	out.println(strbuff.toString());
} 
catch(Exception e)
{
	e.printStackTrace();
}
finally
{
	//StringBuffer values are nullified.
	strbuff.setLength(0);

	//ArrayList is cleared. 
	finAr.clear();
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();
	fifthItem.clear();
	sixthItem.clear();

	//Connection is returned
	ConnectionManager.returnConnection(con,request);	
}
%>
