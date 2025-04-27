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

ArrayList firstItem=new ArrayList();
firstItem.add("Text");  //Type of item
firstItem.add("Indicator ID");  // label
firstItem.add("qind_clind_id");   //name of field
//thirdItem.add("B,Both,E,Enabled,D,Disabled");//static values that need to be displayed as option.Send it along with the value that is inserted.
firstItem.add("3");
firstItem.add("3");
//LENGTH
finAr.add(firstItem); //add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();
secondItem.add("Text");  //Type of item
secondItem.add("Indicator Description");  // label
secondItem.add("qind_clind_desc");   //name of field
//thirdItem.add("B,Both,E,Enabled,D,Disabled");//static values that need to be displayed as option.Send it along with the value that is inserted.
secondItem.add("40");
secondItem.add("40");
//LENGTH
finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();
thirdItem.add("Text");  		 //Type of item
thirdItem.add("Group Code");	  // label
thirdItem.add("qind_group_id");	//name of field
thirdItem.add("4");	// SIZE
thirdItem.add("4");	//LENGTH
finAr.add(thirdItem);//add to ArrayList obj finAr 

ArrayList forthItem = new ArrayList();
forthItem.add("Text");  		 //Type of item
forthItem.add("Group Description");	  // label
forthItem.add("qind_group_desc");	//name of field
forthItem.add("40");	// SIZE
forthItem.add("40");	//LENGTH
finAr.add(forthItem);//add to ArrayList obj finAr 


ArrayList fifthItem=new ArrayList();

fifthItem.add("List");  //Type of item
fifthItem.add("Indicator Type");  // label
fifthItem.add("clind_type");
fifthItem.add("A,All,R,Rational Based,S,Sentinal Based");   //name of field
finAr.add(fifthItem); //add to ArrayList obj finAr

ArrayList sixthItem=new ArrayList();


sixthItem.add("List");  //Type of item
sixthItem.add("Classfication Criteria");  // label
sixthItem.add("clind_class");
sixthItem.add("A,All,D,Diagnosis-based ,P,Procedure-based,Z,Diagnosis/Procedure-based,O,Orderable-based,I,Incident-based,R,Direct Reporting,S,Source Based - RIS,M,Source Based - OTMS,A,Source Based - A&E,N,Source Based - IP");   //name of field
finAr.add(sixthItem); 
ArrayList seventhItem=new ArrayList();


seventhItem.add("List");  //Type of item
seventhItem.add("Nature");  // label
seventhItem.add("eff_status");
seventhItem.add("B,Both,E,Enabled,D,Disabled");   //name of field
finAr.add(seventhItem); 


String orderByCols[] = new String[6];
String orderByColVals[] = new String[6];

orderByCols[0] = "Indicator ID";
orderByCols[1] = "Indicator Description";
orderByCols[2] = "Group Code";
orderByCols[3] = "Group Description";
orderByCols[4] = "Indicator Type";
orderByCols[5] = "Clasification Criteria";

//orderByCols[2] = "Care Location Type Indicator";



orderByColVals[0] = "to_number(qind_clind_id)";        
orderByColVals[1] = "qind_clind_desc"; 
orderByColVals[2] = "qind_group_id";   
orderByColVals[3] = "qind_group_desc";
orderByColVals[4] = "clind_type";              
orderByColVals[5] = "clind_class";            



//orderByColVals[2] = "care_locn_type_ind";

strbuff = qrypg.getQueryPage(con,finAr,"Discipline","../../eQA/jsp/QAIndicatorQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order by",orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());
firstItem.clear();
finAr.clear();
secondItem.clear();
thirdItem.clear();
forthItem.clear();
fifthItem.clear();
sixthItem.clear();
seventhItem.clear();
%>
