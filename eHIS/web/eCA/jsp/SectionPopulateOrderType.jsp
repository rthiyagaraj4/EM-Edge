<!DOCTYPE html>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
 <%
	request.setCharacterEncoding("UTF-8");
	String sStyle =

	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale			= (String) p.getProperty("LOCALE");

%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
</head>
<%
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs   = null;
	String sql_query = "", order_type = "", short_desc = "";
	String order_category = request.getParameter("order_category")==null?"":request.getParameter("order_category");
	try
	{


		con = ConnectionManager.getConnection(request);
		
		if(order_category.equals("ALGY"))
		{
		%>
			<script> 
			parent.MultiOrdSelAdd.document.getElementById("ord_type_label1").innerText ='Adverse Event Type';
			parent.MultiOrdSelAdd.document.getElementById("ord_catlog_label").innerText =' ';
			</script>
		<%
			sql_query="select adv_event_type_code order_type,short_desc short_desc from mr_adv_event_type where eff_status='E' ORDER BY 2";
		}
		else if(order_category.equals("BLTF"))//
		{
			order_type="ALL";
			short_desc ="ALL";
			%><script> 
			parent.MultiOrdSelAdd.document.getElementById("ord_type_label").innerText =getLabel("Common.OrderType.label","COMMON");
			parent.MultiOrdSelAdd.document.getElementById("ord_catlog_label").innerText =' ';
			</script>
			<%

		}
		else if(order_category.equals("CLNT"))//
		{
			//sql_query="select a.NOTE_TYPE order_type,a.NOTE_TYPE_DESC short_desc from CA_NOTE_TYPE a where eff_status='E' ORDER BY 2";
			sql_query="select a.NOTE_GROUP order_type,a.NOTE_GROUP_DESC short_desc from CA_NOTE_GROUP a where eff_status='E' ORDER BY 2";
		%>
		<script> 
			parent.MultiOrdSelAdd.document.getElementById("ord_type_label1").innerText =getLabel("eCA.NoteGroup.label","CA");
			parent.MultiOrdSelAdd.document.getElementById("ord_catlog_label").innerText =getLabel("Common.NoteType.label","COMMON");
		</script>
		<%
		}
		else if(order_category.equals("RXIN"))//
		{
			sql_query="select od.ORDER_TYPE_CODE order_type ,od.SHORT_DESC short_desc from OR_ORDER_TYPE_LANG_VW od where od.ORDER_CATEGORY= 'RX' and od.LANGUAGE_ID= ?";
		%>
		<script> 
			parent.MultiOrdSelAdd.document.getElementById("ord_type_label1").innerText =getLabel("Common.OrderType.label","COMMON");
			parent.MultiOrdSelAdd.document.getElementById("ord_catlog_label").innerText =getLabel("Common.ordercatalog.label","COMMON");
		</script>
		<%
		}
		else if(order_category.equals("DIET"))//
		{
			sql_query="select od.ORDER_TYPE_CODE order_type ,od.SHORT_DESC short_desc from OR_ORDER_TYPE_LANG_VW od where od.ORDER_CATEGORY= 'DS' and od.LANGUAGE_ID= ?";

			%>
		<script> 
			parent.MultiOrdSelAdd.document.getElementById("ord_type_label1").innerText =getLabel("Common.OrderType.label","COMMON");
			parent.MultiOrdSelAdd.document.getElementById("ord_catlog_label").innerText =getLabel("Common.ordercatalog.label","COMMON");
		</script>
		<%
		}
		else if(order_category.equals("FEVT"))//
		{
			order_type="APPOINTMENT";
			short_desc ="APPOINTMENT";

		%>
		<script> 
			parent.MultiOrdSelAdd.document.getElementById("ord_type_label").innerText =getLabel("Common.Future.label","COMMON")+" "+getLabel("Common.EventType.label","COMMON");
			//parent.MultiOrdSelAdd.document.getElementById("ord_catlog_label").innerText =getLabel("Common.Section.label","CA");
		</script>
		<%
			
		}
		else if(order_category.equals("LBIN"))//
		{
			sql_query="select od.ORDER_TYPE_CODE order_type ,od.SHORT_DESC short_desc from OR_ORDER_TYPE_LANG_VW od where od.ORDER_CATEGORY= 'LB' and od.LANGUAGE_ID= ?";
			%>
		<script> 
			parent.MultiOrdSelAdd.document.getElementById("ord_type_label1").innerText =getLabel("Common.OrderType.label","COMMON");
			parent.MultiOrdSelAdd.document.getElementById("ord_catlog_label").innerText =getLabel("Common.ordercatalog.label","COMMON");
		</script>
		<%
		}
		else if(order_category.equals("MEDN"))//
		{
			sql_query="select od.ORDER_TYPE_CODE order_type ,od.SHORT_DESC short_desc from OR_ORDER_TYPE_LANG_VW od where od.ORDER_CATEGORY= 'PH' and od.LANGUAGE_ID= ?";
			%>
		<script> 
			parent.MultiOrdSelAdd.document.getElementById("ord_type_label1").innerText =getLabel("Common.OrderType.label","COMMON");
			parent.MultiOrdSelAdd.document.getElementById("ord_catlog_label").innerText =getLabel("Common.ordercatalog.label","COMMON");
		</script>
		<%
		}
		else if(order_category.equals("RDIN"))//
		{
			sql_query="select od.ORDER_TYPE_CODE order_type ,od.SHORT_DESC short_desc from OR_ORDER_TYPE_LANG_VW od where od.ORDER_CATEGORY= 'RD' and od.LANGUAGE_ID= ?";
			%>
		<script> 
			parent.MultiOrdSelAdd.document.getElementById("ord_type_label1").innerText =getLabel("Common.OrderType.label","COMMON");
			parent.MultiOrdSelAdd.document.getElementById("ord_catlog_label").innerText =getLabel("Common.ordercatalog.label","COMMON");
		</script>
		<%
		}
		else if(order_category.equals("NBDT"))//
		{
			order_type="ALL";
			short_desc ="ALL";
		%>
		<script> 
			parent.MultiOrdSelAdd.document.getElementById("ord_type_label").innerText =getLabel("Common.OrderType.label","COMMON");
			parent.MultiOrdSelAdd.document.getElementById("ord_catlog_label").innerText =getLabel("Common.ordercatalog.label","COMMON");
		</script>
		<%
		}
		else if(order_category.equals("PTCR"))//
		{
			sql_query="select od.ORDER_TYPE_CODE order_type ,od.SHORT_DESC short_desc from OR_ORDER_TYPE_LANG_VW od where od.ORDER_CATEGORY= 'PC' and od.LANGUAGE_ID= ?";
			%>
		<script> 
			parent.MultiOrdSelAdd.document.getElementById("ord_type_label1").innerText =getLabel("Common.OrderType.label","COMMON");
			parent.MultiOrdSelAdd.document.getElementById("ord_catlog_label").innerText =getLabel("Common.ordercatalog.label","COMMON");
		</script>
		<%
		}
		else if(order_category.equals("DIAG"))//
		{
			sql_query="select TERM_SET_ID order_type ,TERM_SET_DESC short_desc from MR_TERM_SET  where EFF_STATUS='E'  ORDER BY 2";
			%>
		<script> 
			parent.MultiOrdSelAdd.document.getElementById("ord_type_label").innerText =getLabel("Common.diagnosis.label","COMMON")+" "+getLabel("Common.Set.label","COMMON");
			//parent.MultiOrdSelAdd.document.getElementById("ord_catlog_label1").innerText =getLabel("Common.encounter.label","COMMON")+" "+getLabel("Common.Stage.label","COMMON");
		</script>
		<%
		}
		else if(order_category.equals("SUNT"))//
		{
			sql_query="select od.ORDER_TYPE_CODE order_type ,od.SHORT_DESC short_desc from OR_ORDER_TYPE_LANG_VW od where od.ORDER_CATEGORY= 'OT' and od.LANGUAGE_ID= ?";
			%>
		<script> 
			parent.MultiOrdSelAdd.document.getElementById("ord_type_label1").innerText =getLabel("Common.OrderType.label","COMMON");
			parent.MultiOrdSelAdd.document.getElementById("ord_catlog_label").innerText =getLabel("Common.ordercatalog.label","COMMON");
		</script>
		<%
		}
		else if(order_category.equals("TRET"))//
		{
			sql_query="select od.ORDER_TYPE_CODE order_type ,od.SHORT_DESC short_desc from OR_ORDER_TYPE_LANG_VW od where od.ORDER_CATEGORY= 'TR' and od.LANGUAGE_ID= ?";
			%>
		<script> 
			parent.MultiOrdSelAdd.document.getElementById("ord_type_label1").innerText =getLabel("Common.OrderType.label","COMMON");
			parent.MultiOrdSelAdd.document.getElementById("ord_catlog_label").innerText =getLabel("Common.ordercatalog.label","COMMON");
		</script>
		<%
		}

		//sql_query="select od.ORDER_TYPE_CODE ,od.SHORT_DESC from OR_ORDER_TYPE_LANG_VW od where od.ORDER_CATEGORY= ? and od.LANGUAGE_ID= ? ";
		
		//if(!(order_category.equals("BLTF")||order_category.equals("FEVT")||order_category.equals("NBDT")))
		if((order_category.equals("RXIN")||order_category.equals("DIET")||order_category.equals("LBIN")||order_category.equals("MEDN")||order_category.equals("RDIN")||order_category.equals("PTCR")||order_category.equals("SUNT")||order_category.equals("TRET")||order_category.equals("ALGY")||order_category.equals("CLNT")||order_category.equals("DIAG") ))
		{
			stmt = con.prepareStatement(sql_query);
		}
		//if(!(order_category.equals("ALGY")||order_category.equals("CLNT")||order_category.equals("BLTF")|| order_category.equals("FEVT") || order_category.equals("NBDT")  || order_category.equals("DIAG")|| order_category.equals("DIAG")  ))
		if((order_category.equals("RXIN")||order_category.equals("DIET")||order_category.equals("LBIN")||order_category.equals("MEDN")||order_category.equals("RDIN")||order_category.equals("PTCR")||order_category.equals("SUNT")||order_category.equals("TRET")))
		{
			stmt.setString(1,locale);
		}
		if((order_category.equals("RXIN")||order_category.equals("DIET")||order_category.equals("LBIN")||order_category.equals("MEDN")||order_category.equals("RDIN")||order_category.equals("PTCR")||order_category.equals("SUNT")||order_category.equals("TRET")||order_category.equals("ALGY")||order_category.equals("CLNT")||order_category.equals("DIAG") ))
		{
			
			rs = stmt.executeQuery();

		while(rs.next())
		{
			order_type	= rs.getString("order_type");
			short_desc		= rs.getString("short_desc");
			if((order_type == null) || order_type.equals("null"))order_type="";
			if((short_desc == null) || short_desc.equals("null"))short_desc="";
			%>
			<script>
			var element = parent.MultiOrdSelAdd.document.createElement('OPTION');
			element.text = "<%=short_desc%>";
			element.value= "<%=order_type%>";
			parent.MultiOrdSelAdd.document.forms[0].ord_type_comp.add(element);
			</script>
			<%
		}
		
		if(rs != null) rs.close();
		if(stmt != null)stmt.close();
		}
		if(order_category.equals("BLTF")||order_category.equals("NBDT")){
		%>
		<script>
			var element = parent.MultiOrdSelAdd.document.createElement('OPTION');
			element.text = "<%=short_desc%>";
			element.value= "<%=order_type%>";
			parent.MultiOrdSelAdd.document.forms[0].ord_type_comp.add(element);
		</script>

		<%}
		if(order_category.equals("FEVT")){
		%>
		<script>
			var element = parent.MultiOrdSelAdd.document.createElement('OPTION');
			element.text = getLabel("eCA.FutureAppointments.label","CA");
			element.value= "FA";
			parent.MultiOrdSelAdd.document.forms[0].ord_type_comp.add(element);
			parent.MultiOrdSelAdd.document.forms[0].ord_type.value='FA';

			element = parent.MultiOrdSelAdd.document.createElement('OPTION');
			element.text = getLabel("Common.FutureOrders.label","CA");
			element.value= "FO";
			parent.MultiOrdSelAdd.document.forms[0].ord_type_comp.add(element);
			parent.MultiOrdSelAdd.document.forms[0].ord_type.value='FO';

			element = parent.MultiOrdSelAdd.document.createElement('OPTION');
			element.text = getLabel("eCA.FutureReferrals.label","CA");
			element.value= "FR";
			parent.MultiOrdSelAdd.document.forms[0].ord_type_comp.add(element);
			parent.MultiOrdSelAdd.document.forms[0].ord_type.value='FR';

		</script>

		<%}
		if(order_category.equals("DIAG")){
		%>
		<script>
			parent.MultiOrdSelAdd.document.getElementById("ord_catlog_label1").innerText =getLabel("Common.encounter.label","COMMON")+" "+getLabel("Common.Stage.label","COMMON");
		</script>

		<%}

	}
	catch(Exception e)
	{
		//out.println("Exception in main try"+e);//COMMON-ICN-0181
	    e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		
		if(con!=null)
			ConnectionManager.returnConnection(con, request);
	}
	
%>
	<script>
</script>
<body class=message  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
</body>

