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
Connection con=null ;
StringBuffer strbuff;

try {
	con = ServiceLocator.getInstance().getConnection(request);
	String ass_note_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.AssessmentNoteId.label","cp_labels");
	String ass_note_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.AssessmentNoteDescription.label","cp_labels");
	String ass_cate_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.AssessmentCategoryCode.label","cp_labels");
	String ass_cate_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.AssessmentCategoryDescription.label","cp_labels");
	String find_service=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.FindService.label","cp_labels");
	String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();

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
thirdItem.add(ass_cate_code);        // label
thirdItem.add("assess_catg_code");   	 	 //name
thirdItem.add("10");			 // SIZE
thirdItem.add("10");			 //LENGTH
finAr.add(thirdItem); 			 //add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();

fourthItem.add("Text");  		 //Type of item
fourthItem.add(ass_cate_desc);  	 //label
fourthItem.add("long_desc");  	 //name
fourthItem.add("30");		         //SIZE 
fourthItem.add("30");  			 //LENGTH
finAr.add(fourthItem);			 //add to ArrayList obj finAr

String orderByCols[] 	= new String[4];
String orderByColVals[] = new String[4];

orderByCols[0] = ass_note_id;
orderByCols[1] = ass_note_desc;
orderByCols[2] = ass_cate_code;
orderByCols[3] = ass_cate_desc;

orderByColVals[0] = "assess_note_id";
orderByColVals[1] = "assess_note_desc";
orderByColVals[2] = "assess_catg_code";
orderByColVals[3] = "long_desc";

strbuff = qrypg.getQueryPage(con,finAr,find_service,"../jsp/AssessmentCategoryForAssessmentNoteQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);

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
