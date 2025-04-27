<!DOCTYPE html>
<!--/*
				Developed by		   :		Rajesh Kanna.S
				Developed on	 	   :	 	2/2/2005 
													*/-->

<%@ page import ="java.sql.*,oracle.jdbc.driver.*, java.util.*,webbeans.eCommon.*" %>
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

try {
	con =  ConnectionManager.getConnection(request);



ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		 //Type of item
firstItem.add("Discipline Code");	  // label
firstItem.add("qind_discipline_id");	//name of field
firstItem.add("4");	// SIZE
firstItem.add("4");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr 

ArrayList secondItem=new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add("Discipline Description");  // label
secondItem.add("qind_discipline_desc");   //name of field
secondItem.add("40");	// SIZE
secondItem.add("40");	//LENGTH

finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList thirdItem=new ArrayList();

thirdItem.add("List");  //Type of item
thirdItem.add("Nature");  // label
thirdItem.add("eff_status");   //name of field
thirdItem.add("B,Both,E,Enabled,D,Disabled");//static values that need to be displayed as option.Send it along with the value that is inserted.
thirdItem.add("2");
//LENGTH
finAr.add(thirdItem); //add to ArrayList obj finAr



String orderByCols[] = new String[2];
String orderByColVals[] = new String[2];


orderByCols[0]    = "Discipline Code";
orderByCols[1]    = "Discipline Description";
orderByColVals[0] = "qind_discipline_id";
orderByColVals[1] = "qind_discipline_desc";
strbuff = qrypg.getQueryPage(con,finAr,"Discipline","../../eQA/jsp/QADisciplineQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order by",orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());
firstItem.clear();
secondItem.clear();
thirdItem.clear();
finAr.clear();
} 
  catch (Exception e) 
  {
    out.println("Exception in QADisciplineQueryCriteria"+e.toString());
   }
   finally
   { 
		ConnectionManager.returnConnection(con, request);
   }

%>
