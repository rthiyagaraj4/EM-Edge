<!DOCTYPE html>

<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCP.*,eCommon.Common.*,com.ehis.eslp.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
request.setCharacterEncoding("UTF-8");
String sStyle =checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css"); 
%>
<link rel='stylesheet' type='text/css'href='../../eCommon/html/<%=sStyle%>'></link>

<%
 //This file is saved on 18/10/2005.
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;
try
{
ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();
String ass_note_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.AssessmentNoteId.label","cp_labels");
String ass_note_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.AssessmentNoteDescription.label","cp_labels");
String dep_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.DependencyCode.label","cp_labels");
String dep_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.DependencyDescription.label","cp_labels");
String dep_level=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DependencyLevel.label","common_labels");
String all=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
String AssessBasedDepClassification=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.AssessBasedDepClassification.label","cp_labels");
String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String dep_level_list="%,"+all+",1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9";
firstItem.add("Text");  		//Type of item
firstItem.add(ass_note_id);	// label
firstItem.add("assess_note_id");	//name of field
firstItem.add("4");			// SIZE
firstItem.add("4");			//LENGTH
finAr.add(firstItem);			//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");  		 //Type of item
secondItem.add(ass_note_desc);	 // label
secondItem.add("assess_note_desc");	 //name of field
secondItem.add("30");			 // SIZE
secondItem.add("30");			 //LENGTH
finAr.add(secondItem);			 //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");   		 //Type of item
thirdItem.add(dep_code);        // label
thirdItem.add("dependency_code");   	 	 //name
thirdItem.add("4");			 // SIZE
thirdItem.add("4");			 //LENGTH
finAr.add(thirdItem); 			 //add to ArrayList obj finAr


ArrayList fourthItem = new ArrayList();

fourthItem.add("Text");  		 //Type of item
fourthItem.add(dep_desc);  	 //label
fourthItem.add("short_desc");  	 //name
fourthItem.add("15");		         //SIZE 
fourthItem.add("15");  			 //LENGTH
finAr.add(fourthItem);			 //add to ArrayList obj finAr

ArrayList fifthItem = new ArrayList();

fifthItem.add("List");  		 //Type of item
fifthItem.add(dep_level);  	 //label
fifthItem.add("dependency_level");  	 //name
fifthItem.add(dep_level_list);  			 //values
finAr.add(fifthItem);			 //add to ArrayList obj finAr



String orderByCols[] 	= new String[5];
String orderByColVals[] = new String[5];


orderByCols[0] = ass_note_id;
orderByCols[1] = ass_note_desc;
orderByCols[2] = dep_code;
orderByCols[3] = dep_desc;
orderByCols[4] = dep_level;

orderByColVals[0] = "a.assess_note_id";
orderByColVals[1] = "b.assess_note_desc";
orderByColVals[2] = "a.dependency_code";
orderByColVals[3] = "c.short_desc";
orderByColVals[4] = "c.dependency_level";



strbuff = qrypg.getQueryPage(con,finAr,AssessBasedDepClassification,"../jsp/AssessBasedDepClassficationQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);

out.println(strbuff.toString());
} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally {
		ServiceLocator.getInstance().returnConnection(con,request);
	}
%>
<%!
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>
