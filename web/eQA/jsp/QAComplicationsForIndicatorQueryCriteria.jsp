
<!--/*
				Developed by		   :		Rajesh Kanna.S
				Developed on	 	   :	 	2/2/2005 
													*/-->

<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" %>
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

try {
	 con = ConnectionManager.getConnection(request);



ArrayList finAr = new ArrayList();

ArrayList thirdItem=new ArrayList();

thirdItem.add("Text");  //Type of item
thirdItem.add("Indicator ID");  // label
thirdItem.add("indicator_code");   //name of field
//thirdItem.add("B,Both,E,Enabled,D,Disabled");//static values that need to be displayed as option.Send it along with the value that is inserted.
thirdItem.add("4");
thirdItem.add("4");
//LENGTH
finAr.add(thirdItem); //add to ArrayList obj finAr

ArrayList fourthItem=new ArrayList();

fourthItem.add("Text");  //Type of item
fourthItem.add("Indicator Description");  // label
fourthItem.add("indicator_desc");   //name of field
//thirdItem.add("B,Both,E,Enabled,D,Disabled");//static values that need to be displayed as option.Send it along with the value that is inserted.
fourthItem.add("60");
fourthItem.add("60");
//LENGTH
finAr.add(fourthItem); //add to ArrayList obj finAr

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		 //Type of item
firstItem.add("Complication Code");	  // label
firstItem.add("complication_code");	//name of field
firstItem.add("4");	// SIZE
firstItem.add("4");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr 

ArrayList secondItem=new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add("Complication Description");  // label
secondItem.add("complication_desc");   //name of field
secondItem.add("40");	// SIZE
secondItem.add("40");	//LENGTH

finAr.add(secondItem); //add to ArrayList obj finAr

String orderByCols[] = new String[4];
String orderByColVals[] = new String[4];

orderByCols[0] = "Indicator ID";
orderByCols[1] = "Indicator Description";
orderByCols[2] = "Complication Code";
orderByCols[3] = "Description";
//orderByCols[2] = "Care Location Type Indicator";


orderByColVals[0] = "to_number(QIND_CLIND_ID)";
orderByColVals[1] = "COMPL_CODE";
orderByColVals[2] = "COMPL_DESCRIPTION";
//orderByColVals[2] = "care_locn_type_ind";

strbuff = qrypg.getQueryPage(con,finAr,"Discipline","../../eQA/jsp/QAComplicationsForIndicatorQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order by",orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());
strbuff.setLength(0);
thirdItem.clear();
fourthItem.clear();
firstItem.clear();
secondItem.clear();
finAr.clear();
 
 } 
  catch (Exception e)
   {
     out.println("Exception in QAComplicationsForIndicatorQueryCriteria"+e.toString());
   }
   finally
   { 
    ConnectionManager.returnConnection(con, request);
	
   }
%>
