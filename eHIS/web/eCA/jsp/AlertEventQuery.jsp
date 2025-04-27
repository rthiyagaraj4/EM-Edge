<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
	<%  request.setCharacterEncoding("UTF-8");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language='javascript' src='../js/AlertEvent.js'></script>
</head>

<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;


Connection con=null ;

try
	{

		con  =  ConnectionManager.getConnection(request);


		ArrayList finAr = new ArrayList();

		ArrayList firstItem = new ArrayList();

		firstItem.add("Text");           //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AlertEventCode.label","ca_labels"));     // label
		firstItem.add("event_id");   //name of field  
		firstItem.add("10"); // SIZE
		firstItem.add("10"); //LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		//thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Graph.label","ca_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));

		ArrayList secondItem = new ArrayList();

		secondItem.add("Text");          //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AlertEventDescription.label","ca_labels"));    // label
		secondItem.add("event_desc");  //name of field
		secondItem.add("30");   // SIZE
		secondItem.add("30");   //LENGTH
		finAr.add(secondItem);    //add to ArrayList obj finAr


		ArrayList thirdItem = new ArrayList();

		thirdItem.add("Text");   //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AlertCategoryCode.label","ca_labels"));  // label
		thirdItem.add("txtCategoryCode");//name
		thirdItem.add("20");			  // SIZE
	    thirdItem.add("20");             // LENGTH
	    finAr.add(thirdItem);

		ArrayList fourthItem = new ArrayList();

fourthItem.add("List");   //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ActionEvent.label","ca_labels"));  // label
	fourthItem.add("ActionEvent");//name
	fourthItem.add("SELECT KEY_VAL, KEY_DESC  FROM CA_ALERT_CODE_LIST WHERE KEY_TYPE='AE' ORDER BY 2");	          
	 finAr.add(fourthItem);


ArrayList fifthItem = new ArrayList();

fifthItem.add("List");   //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DocumentName.label","ca_labels"));  // label
	fifthItem.add("DocumentName");//name
	fifthItem.add("SELECT NOTE_TYPE, NOTE_TYPE_DESC FROM CA_NOTE_TYPE WHERE EFF_STATUS='E' ORDER BY 2");			  // SIZE
	            // LENGTH
	 finAr.add(fifthItem);

	ArrayList sixthItem = new ArrayList();

sixthItem.add("List");   //Type of item
sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ActionBy.label","ca_labels"));  // label
	sixthItem.add("ActionBy");//name
	sixthItem.add("SELECT  KEY_VAL, KEY_DESC  FROM CA_ALERT_CODE_LIST WHERE KEY_TYPE='AB' ORDER BY 2");		           
	 finAr.add(sixthItem);

ArrayList seventhItem = new ArrayList();
seventhItem.add("List");   //Type of item
seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.TriggeringTime.label","ca_labels"));  // label
	seventhItem.add("TriggeringTime");//name			
	 seventhItem.add("SELECT  KEY_VAL, KEY_DESC  FROM CA_ALERT_CODE_LIST WHERE KEY_TYPE='TT' ORDER BY 2");        
	 finAr.add(seventhItem);




			String[] orderByCols = null;
			String[] orderByColVals = null;


			orderByCols = new String[7];
			orderByColVals = new String[7];


			orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AlertEventCode.label","ca_labels");
			orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AlertEventDescription.label","ca_labels");
			orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AlertCategoryCode.label","ca_labels");

			orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ActionEvent.label","ca_labels");

			orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DocumentName.label","ca_labels");

			orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ActionBy.label","ca_labels");

			orderByCols[6] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.TriggeringTime.label","_labels");
			

			orderByColVals[0] = "ALERT_EVENT_CODE";
			orderByColVals[1] = "ALERT_EVENT_DESC";
			orderByColVals[2] = "ALERT_CATEG_CODE"; 
			orderByColVals[3] = "ACTION_EVENT"; 
			orderByColVals[4] = "DOUMENT_REF"; 
			orderByColVals[5] = "ACTION_BY"; 
			orderByColVals[6] = "ACTION_TRIGGER_BY"; 


			//out.println("orderByColVals[0]"+orderByColVals[0]);
			//out.println("orderByColVals[1]"+orderByColVals[1]);
			//out.println("orderByColVals[2]"+orderByColVals[2]);
			

			strbuff = qrypg.getQueryPage(con,finAr,"AlertEvent","../../eCA/jsp/AlertEventResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

		out.println(strbuff.toString());
		finAr.clear();
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		
	
}catch (Exception e) 
{
	//out.println("Exception@1: "+e.toString());//COMMON-ICN-0181
	   e.printStackTrace();//COMMON-ICN-0181
}finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<SCRIPT LANGUAGE="JavaScript">
//parent.commontoolbarFrame.document.getElementById("apply").disabled = true;
</SCRIPT>

