<!DOCTYPE html>
<!--/*
				Developed by		   :		Rajesh Kanna.S
				Developed on	 	   :	 	2/2/2005 
													*/-->

<%@ page import ="java.sql.*, java.util.*" %>
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

try {
	con = (Connection) session.getValue( "connection" );
} catch (Exception e) {}


ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		 //Type of item
firstItem.add("Indicator ID");	  // label
firstItem.add("qind_clind_id");	//name of field
firstItem.add("4");	// SIZE
firstItem.add("4");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr 

ArrayList secondItem=new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add("Indicator Description");  // label
secondItem.add("qind_clind_desc");   //name of field
secondItem.add("40");	// SIZE
secondItem.add("60");	//LENGTH

finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList forthItem=new ArrayList();

forthItem.add("List");  //Type of item
forthItem.add("Diag/Procedure");  // label
forthItem.add("diag_proc_ind");   //name of field
forthItem.add("A,All,D,Diagnosis,P,Procedure,O,Orderable");//static values that need to be displayed as option.Send it along with the value that is inserted.

//LENGTH
finAr.add(forthItem);

ArrayList fifthItem=new ArrayList();

fifthItem.add("Text");  //Type of item
fifthItem.add("Diag/Procedure Code");  // label
fifthItem.add("diag_proc_code");   //name of field
fifthItem.add("10");//static values that need to be displayed as option.Send it along with the value that is inserted.
fifthItem.add("10");
//LENGTH
finAr.add(fifthItem); //add to ArrayList obj finAr

String orderByCols[] = new String[4];
String orderByColVals[] = new String[4];

orderByCols[0] = "Indicator ID";
orderByCols[1] = "Indicator Description";
orderByCols[2] = "Diag/Procedure";
orderByCols[3] = "Diag/Procedure Code";

orderByColVals[0] = "qind_clind_id";
orderByColVals[1] = "qind_clind_desc";
orderByColVals[2] = "diag_proc_ind";
orderByColVals[3] = "diag_proc_code";

strbuff = qrypg.getQueryPage(con,finAr,"Discipline","../../eQA/jsp/QADiagProcIndQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order by",orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());

strbuff.setLength(0);
firstItem.clear();
secondItem.clear();
forthItem.clear();
fifthItem.clear();
finAr.clear();
%>
