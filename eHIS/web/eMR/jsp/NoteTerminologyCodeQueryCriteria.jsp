<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*, eMR.*,eCommon.Common.*,com.ehis.eslp.* " %><!--oracle.jdbc.driver.*,-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<%	String sStyle	=
   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
try{
	Connection conn=null ;
	conn = (Connection) session.getValue( "connection" );
//    HttpSession sess = request.getSession(false);
ArrayList NoteGroupvalues = new ArrayList();
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  		 //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceCode.label","common_labels"));	  // label
	firstItem.add("service_code");	//name of field
	firstItem.add("10"); //size
	firstItem.add("10"); //maxlength
	NoteGroupvalues.add(firstItem); //add to ArrayList obj finAr
	
	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");   //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceDescription.label","common_labels")); //label
	secondItem.add("service_description");//name
	secondItem.add("30"); //size
	secondItem.add("30");  //maxlength
	NoteGroupvalues.add(secondItem); //add to ArrayList obj finAr


	ArrayList thirdItem = new ArrayList();
	thirdItem.add("Text");   //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NoteType.label","common_labels")); //label
	thirdItem.add("note_type");//name
	thirdItem.add("10"); //size
	thirdItem.add("10");  //maxlength
	NoteGroupvalues.add(thirdItem); //add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();
	fourthItem.add("Text");  		 //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.note.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	  // label
	fourthItem.add("note_desc");	//name of field
	fourthItem.add("30"); //size
	fourthItem.add("30"); //maxlength
	NoteGroupvalues.add(fourthItem); 

	ArrayList fifthItem = new ArrayList();
	fifthItem.add("Text");  		 //Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TerminologySet.label","common_labels"));	  // label
	fifthItem.add("term_set");	//name of field
	fifthItem.add("10"); //size
	fifthItem.add("10"); //maxlength
	NoteGroupvalues.add(fifthItem); //add to ArrayList obj finAr
	
	ArrayList sixthItem = new ArrayList();
	sixthItem.add("Text");   //Type of item
	sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologySetDescription.label","mr_labels")); //label
	sixthItem.add("term_set_desc");//name
	sixthItem.add("30"); //size
	sixthItem.add("30");  //maxlength
	NoteGroupvalues.add(sixthItem); //add to ArrayList obj finAr
/**/
	
	String orderByCols[] = new String[6];
	String orderByColVals[] = new String[6];
	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceCode.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceDescription.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NoteType.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.note.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TerminologySet.label","common_labels");
	orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologySetDescription.label","mr_labels");
	orderByColVals[0] = "a.service_code";
	orderByColVals[1] = "short_desc";
	orderByColVals[2] = "a.note_type";
	orderByColVals[3] = "note_type_desc";
	orderByColVals[4] = "a.term_set_id";
	orderByColVals[5] = "term_set_desc";
	

	strbuff = qrypg.getQueryPage(conn,NoteGroupvalues,"Note Group Terminology","../jsp/NoteTerminologyCodeQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
	out.println(strbuff.toString());
	
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();
	fifthItem.clear();
	sixthItem.clear();
	NoteGroupvalues.clear();
	
	} 
	catch (Exception e) 
	{
		//out.println(e.toString());
		e.printStackTrace();
	}
	finally{

	}
%>


