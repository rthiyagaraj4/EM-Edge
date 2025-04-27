<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper" %> 
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
 <%@include file="../../eCommon/jsp/CommonBean.jsp" %>
 <%-- Mandatory declarations end --%>


<html>
	<head>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
		<title></title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
		<script language="Javascript" src="../../eOR/js/SectionForTickSheet.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eOR/js/OrCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
</head>
<script language='Javascript'>

 function Modify(obj,rowIndex) {
	var	tick_sheet_id							=     obj.cells[0].innerText;
	
	var tick_sheet_desc                       =     obj.cells[1].innerText;
	
	var order_category_short_desc  =     obj.cells[2].innerText;
	
	var eff_status                                  =  obj.cells[5].children[1].getAttribute('value');
	
	var order_category_id                  =     obj.cells[2].children[0].getAttribute('value');
	
	var section_code                             =     obj.cells[3].innerText;
	
	var section_desc                             =     obj.cells[4].innerText;
	
	var seq_no	= document.getElementById('seq_no'+rowIndex).value;

	 parent.f_query_add_mod.location.href="../../eOR/jsp/SectionForTickSheetUpdateMultiple.jsp?order_category="+order_category_id+"&tick_sheet_id="+tick_sheet_id+"&section_code="+escape(section_code)+"&section_desc="+escape( section_desc)+"&eff_status="+eff_status  + "&tick_sheet_desc="+tick_sheet_desc+"&order_category_short_desc="+escape(order_category_short_desc)+"&mode=2&seq_no="+seq_no;

}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	request.setCharacterEncoding("UTF-8"); 
	//Search Criteria's from Query Criteria page
	String order_category	= request.getParameter( "order_category" ).trim() ;
	String tick_sheet_id	= request.getParameter( "tick_sheet_id" ) ;
	String tick_sheet_desc	= request.getParameter( "tick_sheet_desc" ) ;
	String section_code	= request.getParameter( "section_code" ) ;
	String section_desc	= request.getParameter( "section_desc" );
	String eff_status	= request.getParameter( "eff_status" ) ;
	//String ord[]				= request.getParameterValues("orderbycolumns");
		//	out.println("the value of non specific"+order_category);

	if( order_category.equals("''")||order_category.equals("")||order_category==null ){
							order_category="";	}

	if(tick_sheet_id==null|| tick_sheet_id.equals(""))  {
							tick_sheet_id="";	}

	if(tick_sheet_desc==null|| tick_sheet_desc.equals(""))  {
						tick_sheet_desc="";
						}

	if(section_code==null|| section_code.equals(""))   {
						section_code="";	}

	if(section_desc==null|| section_desc.equals("")) {
						section_desc="";	}

	if(eff_status.equals("E") )
						eff_status="E";
	else if(eff_status.equals("D"))
						eff_status="D";
	else
						eff_status="";

	boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;
//	out.println(searched);
try{
	String classvalue			= "";
//	String bean_id				= "Or_SectionForTickSheet" ;
	//String bean_name			= "eOR.SectionForTickSheet";


//	SectionForTickSheet  bean = (SectionForTickSheet)mh.getBeanObject( bean_id, request, bean_name ) ;


	//Common parameters.
	HashMap sqlMap = new HashMap();
//out.println(bean.toString());
	//include all the common parameters.
	sqlMap.put( "sqlData",OrRepository.getOrKeyValue(" SQL_OR_TICK_SHEETS_SECTION_SQLDATA_N"));
//	out.println(OrInterface.SQL_OR_TICK_SHEETS_SECTION_SQLDATA_N);

	//Function Parameters

	HashMap funcMap = new HashMap();

	//The fields are going to be display

	ArrayList displayFields = new ArrayList();

	displayFields.add( "tick_sheet_id" );
	displayFields.add( "tick_sheet_desc" );
	displayFields.add( "short_desc" );
	displayFields.add( "order_category" );
	displayFields.add( "section_code" );
	displayFields.add( "section_desc" );
	displayFields.add( "eff_status" );
	displayFields.add( "section_seq_num" );
/*
	public static String   SQL_OR_TICK_SHEETS_SECTION_QUERYCRIETERIA_SQLDATA=
"select a.tick_sheet_id tick_sheet_id, c.tick_sheet_desc tick_sheet_desc,b.short_desc  short_desc  ,a.order_category  order_category ,section_code ,section_desc , a.eff_status   eff_status
from or_tick_sheet_section a, or_order_category b, or_tick_sheet c
where
a.order_category =b.order_category and 	a.order_category =c.order_category and 	a.tick_sheet_id = c.tick_sheet_id
and a.order_category  like nvl(?, a.order_category)
and  a.tick_sheet_id like  upper(?)  and
c.tick_sheet_desc like ?
and a.section_code like upper(?)
and  a.section_desc  like ?
and a.eff_status like ?
union
select a.tick_sheet_id tick_sheet_id, c.tick_sheet_desc tick_sheet_desc,'Non Specific'  short_desc  ,'*A'  order_category ,section_code ,section_desc , a.eff_status   eff_status
from or_tick_sheet_section a, or_tick_sheet c
where
a.order_category ='*A' and 	a.order_category =c.order_category and 	a.tick_sheet_id = c.tick_sheet_id
and   a.tick_sheet_id like  upper(?)
and c.tick_sheet_desc like ?
and a.section_code like upper(?)
and  a.section_desc  like ?
and
a.eff_status like ?";
*/


	//The fields are going to be in where condition * should match with the query

	ArrayList chkFields = new ArrayList();
	chkFields.add( order_category+"%" );
	chkFields.add( tick_sheet_id +"%");
	chkFields.add( tick_sheet_desc +"%");
	chkFields.add( section_code +"%");
	chkFields.add( section_desc +"%");
	chkFields.add( eff_status +"%");
	chkFields.add( tick_sheet_id +"%");
	chkFields.add( tick_sheet_desc +"%");
	chkFields.add( section_code +"%");
	chkFields.add( section_desc +"%");
	chkFields.add( eff_status +"%");
	chkFields.add( order_category +"%");


	// Adding function related array list into the HashMap

	funcMap.put( "displayFields", displayFields );

	funcMap.put( "chkFields", chkFields );


	//Calling the Result from Common Adaptor as a arraylist.

//	ArrayList result=(ArrayList)bean.getQueryResultPage(sqlMap, funcMap, request);

//out.println("<script>alert(' Result got frm the bean:sqlMap="+ sqlMap+"');</script>");

//out.println("<script>alert(' Result got frm the bean:funcMap="+ funcMap+"');</script>");

//out.println("<script>alert(' Result got frm the bean:request="+ request+"');</script>");

ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);

	//out.println("<script>alert(' Result got frm the bean:"+ result+"');</script>");

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) ))	{
	%>
		<table border=0 cellpadding=3 cellspacing=0 width="100%" align="center">
		<tr>
		<td class=label></td>
		<td class=label>
	<%
		// For display the previous/next link
	     out.println(result.get(1));
	%>
	
	<style>
    td,th,tr
   {border-bottom: 1px solid #d5e2e5;
   }
    </style>
		</td></tr>
		</table>

		<table class='grid' width="100%"">

		<th class='columnheader' width='10%' style="text-align: left;"><fmt:message key="eOR.TickSheetID.label" bundle="${or_labels}"/></th> 
		<th class='columnheader' width='20%' style="text-align: left;"><fmt:message key="eOR.TickSheetDescription.label" bundle="${or_labels}"/></th> 
		<th class='columnheader' width='20%' style="text-align: left;"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></th> 
		<th class='columnheader' width='10%' style="text-align: left;"><fmt:message key="Common.SectionCode.label" bundle="${common_labels}"/></th>
		<th class='columnheader' width='30%'  style="text-align: left;"><fmt:message key="eOR.SectionDesc.label" bundle="${or_labels}"/></th> 
		<th class='columnheader' width='10%'  style="text-align: left;"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th> 

	<%
		//Retriving the records from result arraylist

		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++)
			{//start of outer for loop
			if ( recCount % 2 == 0 )
				classvalue = "gridData" ;
			else
				classvalue = "gridData" ;
	%>
			<tr   onClick='Modify(this,"<%=recCount%>");'  >
	<%

			String link_columns = "1";

			String seq_no = "";

			records=(ArrayList) result.get( recCount );
			int colCount=0;

	for(colCount=0; colCount<(records.size()-1); colCount++)
			{//start of for loop1
				//out.println(records.size());
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 )
						{  // if loop1
	%>
		<td class="<%=classvalue%>"     onmouseover="changeCursor(this);" >
				<a class='gridLink' href='#'>
				<%=(String)records.get(colCount)%>
				</a>
		</td>
	<%
					}// end if loop1
	else{// start  else 1
	%>
		<td class="<%=classvalue%>"  onclick="disableClick(event);">
		<%
			       if(colCount ==6)
						{//start of if 3
								if( ((String)records.get(colCount)).equals("E"))
										out.println("<img src='../../eCommon/images/enabled.gif'><input type='hidden' value='E'></img>");
					else
										out.println("<img src='../../eCommon/images/disabled.gif'><input type='hidden' value='D'></img>");
							}//end of if 3
					else if(colCount ==2)
								{//start of if 4
										out.println((String)records.get( colCount ));
										colCount=colCount+1;
		%>
							<label class='fields' type='hidden' value=<%=(String)records.get( colCount)%>>


		<%
				//end of if 4
				} else if (colCount == 7) {
					seq_no = (String)records.get(colCount);
				%>

				<%}
		else
			{
					out.println((String)records.get( colCount ));
			}

	%></td>
	<%
					}//end of else 1
			}//inner for loop
			if (colCount == 7) {
					seq_no = (String)records.get(colCount);
			}
	%>
			<input type='hidden' name='seq_no<%=recCount%>' id='seq_no<%=recCount%>' value='<%=seq_no%>'>
			</tr>
	<%
			} //upper for loop
	%>
		</table>
	<%
		out.flush();
	}  // first if end
	else{// start of else
	%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
	<%
	}//end of else
	out.println(CommonBean.setForm ( request ,"../../eOR/jsp/SectionForTickSheetQueryResult.jsp", searched) );
	} //end of try
catch(Exception e) {//start of catch
	System.out.print("Exception @ Result JSP :"+e.toString());
}//end of catch
%>
</body>
</html>

