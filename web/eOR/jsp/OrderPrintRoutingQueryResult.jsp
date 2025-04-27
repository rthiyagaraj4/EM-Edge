
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper "%>
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
	
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eOR/js/OrderPrintRouting.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>

		<script language="Javascript" src="../../eOR/js/OrCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<!--<script language="javascript" src="../../eCommon/js/messages.js"></script>-->
</head>
<script language='Javascript'>

function Modify(obj)
	{
	var	order_type_code					=     obj.cells[0].innerText;

	var short_desc                       =     obj.cells[1].innerText;

	var patient_class  =     obj.cells[2].innerText;

//	var order_category=obj.cells[2].innerText;

//alert(patient_class);	/*alert("order_category="+order_category_id+"&tick_sheet_id="+tick_sheet_id+"&section_code="+section_code+"&section_desc="+ section_desc+"&eff_status="+eff_status  + "&tick_sheet_desc="+tick_sheet_desc+"&order_category_short_desc="+order_category_short_desc+"&mode=2");*/

document.location.href="../../eOR/jsp/OrderPrintRoutingAddModify.jsp?order_type_code="+order_type_code+"&short_desc="+short_desc+"&patient_class="+patient_class+"&mode=2";


		}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>






<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	request.setCharacterEncoding("UTF-8");
	//Search Criteria's from Query Criteria page
	String order_type_code					= request.getParameter( "order_type_code" ) ;
	String short_desc						= request.getParameter( "short_desc" ) ;
	String patient_class					= request.getParameter( "patient_class" ) ;
	String performing_deptloc_code			= request.getParameter("performing_deptloc_code");
	String performing_deptloc_short_desc 	= request.getParameter("performing_deptloc_short_desc");
//	String ord[]							= request.getParameterValues("orderbycolumns");

	order_type_code = (order_type_code == null) ? "" : order_type_code.toUpperCase();
	short_desc		= (short_desc == null) ? "" : short_desc;

	patient_class	= (patient_class == null) ? "" : patient_class;

	if(patient_class.equals("''")||patient_class.equals("")||patient_class==null )  {
		patient_class="";
	}

	performing_deptloc_code 		= (performing_deptloc_code == null) ? "" : performing_deptloc_code;
	performing_deptloc_short_desc 	= (performing_deptloc_short_desc == null) ? "" : performing_deptloc_short_desc;

	boolean searched				= request.getParameter( "searched" ) == null ? false : true  ;

try{
	String classvalue			= "";

	String facilty_id=request.getParameter("Facility_id");





	HashMap sqlMap = new HashMap();


	sqlMap.put( "sqlData",OrRepository.getOrKeyValue("SQL_OR_PRINT_QUERY_CRITERIA"));

/*
select a.order_type_code		order_type_code,b.short_desc    order_type_desc  ,a.patient_class 			 	patient_class,c.short_desc  patient_class_desc  from or_order_type_routing a,or_order_type b,am_patient_class c where a.order_type_code=b.order_type_code and a.patient_class=c.patient_class and order_category <>'CS' and a.order_type_code like ? and a.patient_class like ? and  b.short_desc like ? and  OPERATING_FACILITY_ID   =? union select a.order_type_code order_type_code ,b.short_desc order_type_desc  ,'*A'  patient_class  ,'ALL'  patient_class_desc   from   or_order_type_routing a  ,or_order_type b   where a.order_type_code=b.order_type_code and  a.patient_class='*A'   and order_category <>'CS'  and  a.order_type_code like ? and a.patient_class like ? and b.short_desc like ? and  OPERATING_FACILITY_ID  =?*/

	//Function Parameters

	HashMap funcMap = new HashMap();

	//The fields are going to be display

	ArrayList displayFields = new ArrayList();

	displayFields.add( "order_type_code" );
	displayFields.add( "order_type_desc" );
// 	displayFields.add( "order_category" );
	displayFields.add( "patient_class" );
	displayFields.add( "patient_class_desc" );
	displayFields.add( "performing_deptloc_code" );
	displayFields.add( "performing_deptloc_short_desc" );

	ArrayList chkFields = new ArrayList();
		chkFields.add( order_type_code+"%" );
		chkFields.add( patient_class+"%" );
		chkFields.add( short_desc+"%" );
		chkFields.add( facilty_id );
		chkFields.add( performing_deptloc_code+"%" );
		chkFields.add( performing_deptloc_short_desc+"%" );
		chkFields.add( order_type_code+"%" );
		chkFields.add( patient_class+"%" );
		chkFields.add( short_desc+"%" );
		chkFields.add( facilty_id );
		chkFields.add( performing_deptloc_code+"%" );
		chkFields.add( performing_deptloc_short_desc+"%" );


	// Adding function related array list into the HashMap

	funcMap.put( "displayFields", displayFields );

	funcMap.put( "chkFields", chkFields );


	//Calling the Result from Common Adaptor as a arraylist.

	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);

//	out.println("<script>alert(' Result got frm the bean:"+ result.size()+"');</script>");

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) ))
		{
	%>
		<table border="0" cellpadding=3 cellspacing=0 width="100%" align="center">
		<tr>
		<td class=label></td>
		<td class=label>
	<%
		// For display the previous/next link
	     out.println(result.get(1));
	%>
		</td></tr>
		</table>

		<table class='grid' width="100%">

		<td class=columnheader width="15%"><fmt:message key="Common.OrderTypeCode.label" bundle="${common_labels}"/></td>
		<td class=columnheader width="20%"><fmt:message key="eOR.OrderTypeDesc.label" bundle="${or_labels}"/></td>
		<td class=columnheader width="15%"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
		<td class=columnheader width="10%"><fmt:message key="Common.PatientClassDescription.label" bundle="${common_labels}"/></td>
		<td class=columnheader width="10%"><fmt:message key="eOR.PerformingLocationCode.label" bundle="${or_labels}"/></td>
		<td class=columnheader width="30%"><fmt:message key="eOR.PerformingLocationDescription.label" bundle="${or_labels}"/></td>

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
			<tr   onClick='Modify(this);'  >
	<%

			String link_columns = "1";

			records=(ArrayList) result.get( recCount );

	for(int colCount=0; colCount<records.size(); colCount++)
			{//start of for loop1
				//out.println(records.size());
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 )
						{  // if loop1
	%>
		<td class="<%=classvalue%>"     onmouseover="changeCursor(this);" nowrap >
				<a class='gridLink' href='#'>
				<%=(String)records.get(colCount)%>
				</a>
		</td>
	<%
					}// end if loop1
	else{// start  else 1
	%>
		<td class="<%=classvalue%>"  onclick="disableClick(event);" nowrap>

		<%
				out.println((String)((records.get( colCount ) == null) ? "&nbsp;" : records.get(colCount)));
			}

	%></td>

	<%
					//}//end of else 1
			}//inner for loop
	%>
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
	out.println(CommonBean.setForm ( request ,"../../eOR/jsp/OrderPrintRoutingQueryResult.jsp", searched) );
	} //end of try
catch(Exception e) {//start of catch
	//out.print("Exception @ Result JSP :"+e.toString());//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
}//end of catch
%>
</body>
</html>

