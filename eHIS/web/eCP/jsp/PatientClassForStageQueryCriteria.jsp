<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.util.*" contentType="text/html; charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<%
//This file is saved on 18/10/2005.
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;
try
{
	con = ConnectionManager.getConnection(request);	
	ArrayList StageValues = new ArrayList();
	ArrayList firstItem = new ArrayList();
	String stg_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StageCode.label","common_labels");
	String stg_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.StageDescription.label","cp_labels");
	String pt_cls_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientClassCode.label","common_labels");
	String pt_cls_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientClassDescription.label","common_labels");
	String fnd_tlgy_set_fr_fecility=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.FindTerminologySetForFacility.label","cp_labels");
	String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

firstItem.add("Text");  		//Type of item
firstItem.add(stg_code);	// label
firstItem.add("stage_code");	//name of field
firstItem.add("4");			// SIZE
firstItem.add("4");			//LENGTH
StageValues.add(firstItem);			//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");  		 //Type of item
secondItem.add(stg_desc);	 // label
secondItem.add("long_desc");	 //name of field
secondItem.add("30");			 // SIZE
secondItem.add("30");			 //LENGTH
StageValues.add(secondItem);			 //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");   		 //Type of item
thirdItem.add(pt_cls_code);        // label
thirdItem.add("patient_class");   	 	 //name
thirdItem.add("2");			 // SIZE
thirdItem.add("2");			 //LENGTH
StageValues.add(thirdItem); 			 //add to ArrayList obj finAr


ArrayList fourthItem = new ArrayList();

fourthItem.add("Text");  		 //Type of item
fourthItem.add(pt_cls_desc);  	 //label
fourthItem.add("patient_class_desc");  	 //name
fourthItem.add("30");		         //SIZE 
fourthItem.add("30");  			 //LENGTH
StageValues.add(fourthItem);			 //add to ArrayList obj finAr


String orderByCols[] 	= new String[4];
String orderByColVals[] = new String[4];


orderByCols[0] = stg_code;
orderByCols[1] = stg_desc;
orderByCols[2] = pt_cls_code;
orderByCols[3] = pt_cls_desc;

orderByColVals[0] = "stage_code";
orderByColVals[1] = "long_desc";
orderByColVals[2] = "patient_class";
orderByColVals[3] = "patient_class_desc";

strbuff = qrypg.getQueryPage(con,StageValues,fnd_tlgy_set_fr_fecility,"../jsp/PatientClassForStageQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect  ,orderBy,orderByCols, orderByColVals,ExecuteQuery);

out.println(strbuff.toString());
}
	catch (Exception e) 
	{
		out.println(e.toString());
	}
	finally
	{
		try
		{
			if(con != null)
				ConnectionManager.returnConnection(con,request);					
		}
		catch (Exception ee)
		{
			ee.printStackTrace();
		}
	}

%>
