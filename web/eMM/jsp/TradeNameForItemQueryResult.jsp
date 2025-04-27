<!DOCTYPE html>
<%@ page import="java.util.*, eMM.Common.*, eMM.* ,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- 	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
 --><%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		//locale ="en";
//		String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script>
	<script language="javascript" src="../../eMM/js/MmMessages.js"></script> -->
	<script language="javascript" src="../../eMM/js/MmCommon.js"></script>
	<script language="javascript" src="../../eMM/js/TradeNameForItem.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  SCROLL = "auto" >
<%
	String item_code	=	request.getParameter("item_code");
	String long_desc	=	request.getParameter("long_desc");
	String trade_id		=	request.getParameter("trade_id");
	String long_name	=	request.getParameter("long_name");


	//String orderBy[] = request.getParameterValues("orderbycolumns");
	boolean searched = (request.getParameter("searched") == null) ?false:true;
	String classvalue = "";

	try{

		item_code	=CommonBean.checkForNull(item_code)+"%";;
		long_desc	=CommonBean.checkForNull(long_desc)+"%";;
		trade_id	=CommonBean.checkForNull(trade_id	)+"%";;
		long_name	=CommonBean.checkForNull(long_name)+"%";;

		HashMap sqlMap = new HashMap();
		sqlMap.put("sqlData", eMM.Common.MmRepository.getMmKeyValue("SQL_MM_TRADE_NAME_FOR_ITEM_QUERY_RESULT"));

		//SQL_SS_SURGERYTYPE_SQLDATA);
		//SQL_SS_SURGERYTYPE_QUERYCRIT);
		HashMap funcMap = new HashMap();

		//The fields are going to be display
		ArrayList displayFields = new ArrayList();

		displayFields.add("item_code");
		displayFields.add("long_desc");
		displayFields.add("trade_id");
		displayFields.add("long_name");
		displayFields.add("manufacturer_name");

		//The fields are going to be in where condition * should match with the query
		ArrayList chkFields = new ArrayList();
		chkFields.add( item_code);
		chkFields.add( long_desc);
		chkFields.add( trade_id	);
		chkFields.add( long_name);
		chkFields.add( locale);


		// Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );


		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		//out.println(result + " result ");
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
		%>
			<table cellpadding=0 cellspacing=0 width="100%" align=center>
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;
				<%
					out.println(result.get(1));
				%>
				</td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align=center>
				<th colspan=2><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
				<th colspan=2><fmt:message key="Common.ManufacturerName.label" bundle="${common_labels}"/></th>
		<%
			ArrayList records=new ArrayList();
			String previous = "";
			String item_code_value= "";
			for(int recCount=2; recCount<result.size(); recCount++) {
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;

//				String link_columns = "1";
				records=(ArrayList) result.get( recCount );
				item_code_value = (String)records.get( 0 );
				if(! (item_code_value.equals(previous)) ) {
		%>
				<tr>
					<td class = "ITEMSELECT" colspan=4>
						<b><fmt:message key="Common.item.label" bundle="${common_labels}"/>:</b>
						<b>  <%=(String)records.get( 0 )%></b>    
						&nbsp;-&nbsp;
						<b>  <%=(String)records.get( 1 )%></b>    
					</td>
				</tr>
				<tr>
		<%
				}
				else {
		%>
				<tr>				
		<%
				}
		%>
				<td class="<%=classvalue%>" onclick="disableClick(event);"  colspan=2><%=(String)records.get( 3 )%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"  colspan=2><%=(String)records.get( 4 )%></td>


		</tr>
		<%
			previous = item_code_value;
			}
		%>
		</table>
		<%
			out.flush();
		} 
		else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				history.go(-1);
			</script>
		<%
		}
		out.println(CommonBean.setForm ( request ,"../../eMM/jsp/TradeNameForItemQueryResult.jsp", searched) );
	}
	catch(Exception e) {
		//out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace(); // COMMON-ICN-0184
	}
%>
</body>
</html>

