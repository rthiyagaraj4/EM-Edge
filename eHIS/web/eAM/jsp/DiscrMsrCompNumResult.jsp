<!DOCTYPE html>
<%
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------
Date       Edit History     Name           Rev.Date		  Rev.Name		Description
-------------------------------------------------------------------------------------------------------
07/08/2019	IN070957		Ramya Maddena	07/08/2019   Ramesh G
-------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<%
	out.println("<head>		<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>  <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script></head><BODY OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'  class='CONTENT' >");
%>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src='../../eAM/js/DiscrMsrComp.js' language='javascript'></script>
	<script language="JavaScript">

		function showDetails(vals,rownum,from)
		{
			//added on 30-10-2003 by dhanasekaran
			document.forms[0].con_vals.value=vals;
			document.forms[0].row_num.value=rownum;
			//end addition
			
			if(from == 'A')
			{
				//parent.frames[1].location.href = "../../eAM/jsp/DiscrMeasureAlphaInfoAddModify.jsp?con_vals="+escape(vals)+"&row_num="+escape(rownum);
				
				document.forms[0].submit()
			}
			else
			{
				parent.frames[1].location.href = "../../eAM/jsp/DiscrMsrCompNumAddModify.jsp?con_vals="+escape(vals)+"&row_num="+escape(rownum)+"&max_min_dec="+document.getElementById("max_min_dec").value;
			}
		}
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<body onKeyDown = 'lockKey()'>
<form name='DiscrMeasureResult_form' id='DiscrMeasureResult_form' method="post" action="DiscrMsrCompNumInfoAddModify.jsp" target="f_query_add_mod">
<%
		request.setCharacterEncoding("UTF-8");
		String from = request.getParameter("from")==null?"":request.getParameter("from");
		String convals = request.getParameter("con_vals")==null?"":request.getParameter("con_vals");
//out.println("<script>alert('con_vals"+convals+"');</script>");
		if(from.equals("A"))
		{
%>
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<tr nowrap>
		<th width='40%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
		<th width='20%'><fmt:message key="Common.Result.label" bundle="${common_labels}"/></th>
        <th width='20%'><fmt:message key="eAM.NumericValue.label" bundle="${am_labels}"/></th> 
		<th width='15%'><fmt:message key="Common.SortOrder.label" bundle="${common_labels}"/></th>		
		<th width='10%'><fmt:message key="Common.Default.label" bundle="${common_labels}"/></th>
	</tr>

	<%
		String refrangeseq = "";
		String description = "";
		String result = "";
		String sortorder = "";
		String numericvalues = "";
		String defaultval = "";
		String classval = "";

		int i = 0;
		//out.println(convals);
		if(!convals.equals(""))
		{
			//added on 31-10-2003 by dhanasekaran ('+' character replaced as '¤' in JS)
			//convals = convals.replace('¤', '+');
			//end addition

			java.util.StringTokenizer stout = new java.util.StringTokenizer(convals,"`");
			
			while(stout.hasMoreTokens())
			{
				String temp = stout.nextToken();
				if(!temp.equals(""))
				{
					java.util.StringTokenizer st = new java.util.StringTokenizer(temp,"~");
					while(st.hasMoreTokens())
					{
						refrangeseq = st.nextToken();
						
						description = st.nextToken();
						
				       result = st.nextToken();
						numericvalues=st.nextToken();
						
								
						sortorder = st.nextToken();
					
						defaultval = st.nextToken();
						
					}
					if(i%2 == 0)
						classval = "QRYODD";
					else
						classval = "QRYEVEN";
					String currconvals = refrangeseq+"~"+description+"~"+result+"~"+numericvalues+"~"+sortorder+"~"+defaultval;
				%>
<!-- commented on 31-10-2003 by dhanasekaran
					<tr><td class='<%=classval%>' id='desc_<%=i %>'><a href='javascript:showDetails("<%=java.net.URLEncoder.encode(currconvals)%>","<%= i %>", "A")'><%=description%></a></td>
end comment-->
<!-- added on 31-10-2003 by dhanasekaran -->
					<tr><td class='<%=classval%>' id='desc_<%=i %>'><a href='javascript:showDetails("<%=currconvals%>","<%= i %>", "A")'><%=description%></a></td>
<!-- end addition -->
             
					<td  class='<%=classval%>' id='result_<%=i%>'><%=result%></td>
                      <td align='right' class='<%=classval%>' id='numericval_<%=i%>'><%=numericvalues%></td>
					
					<td  align='right' class='<%=classval%>' id='sorder_<%=i%>'><%=sortorder%></td>
					<td  class='<%=classval%>' id='def_<%=i%>'><%=defaultval%></td>
					</tr>
					<input type='hidden' id='ref_range_seq_<%=i%>' value="<%=refrangeseq%>">
				<%
					i++;
				}
			}
		}
	%>
	</table>
	<input type="hidden" name="prev_con_vals" id="prev_con_vals" value="<%=convals%>">
	<input type="hidden" name="total_rows" id="total_rows" value="<%=i%>">
<%
	}
	else
	{
	String maxmindec = request.getParameter("max_min_dec")==null?"":request.getParameter("max_min_dec");
%>
	<table border="1" width="100%" cellspacing='0' cellpadding='0' id='myTable'>
    <tr><th nowrap colspan=16><b><font size='2' ><fmt:message key="eAM.ExistingRange.label" bundle="${am_labels}"/></b></th></tr>
	<tr>
		<th rowspan=2>Sex</th>
		<th colspan=2><fmt:message key="Common.Start.label" bundle="${common_labels}"/></th>
		<th colspan=2>End</th>
		<th rowspan=2><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></th>
		<th colspan=2><fmt:message key="eMP.Reference.label" bundle="${mp_labels}"/></th>
		<th colspan=2><fmt:message key="Common.Critical.label" bundle="${common_labels}"/></th>
		<th rowspan=2><fmt:message key="Common.uom.label" bundle="${common_labels}"/></th>
		<th rowspan=2><fmt:message key="Common.Default.label" bundle="${common_labels}"/></th>
	</tr>
	<tr>
		<th><fmt:message key="Common.age.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.Units.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.age.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.Units.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.Low.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.High.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.Low.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.High.label" bundle="${common_labels}"/></th>
	</tr>

	<%
		String sex = "";
		String startage = "";
		String startunits = "";
		String endage = "";
		String endunits = "";
		String seqno = "";
		String reflow = "";
		String refhigh = "";
		String criticallow = "";
		String criticalhigh = "";
		String uom = "";
		String def = "";
		String insertyn = "N";
		String classval = "";
		int i = 0;
//out.println(convals);
		if(!convals.equals(""))
		{
			java.util.StringTokenizer stout = new java.util.StringTokenizer(convals,"`");
			while(stout.hasMoreTokens())
			{
				String temp = stout.nextToken();
				if(!temp.equals(""))
				{
					java.util.StringTokenizer st = new java.util.StringTokenizer(temp,"~");
					while(st.hasMoreTokens())
					{
						sex = st.nextToken();               
						startage = st.nextToken();      
						startunits = st.nextToken();    
						endage = st.nextToken();        
						endunits = st.nextToken();      
						seqno = st.nextToken();          
						reflow = st.nextToken();          
						refhigh = st.nextToken();         
						criticallow = st.nextToken();   
						criticalhigh = st.nextToken(); 
						uom = st.nextToken();             
						def = st.nextToken();                
						insertyn = st.nextToken();
					}
					String currconvals = sex+"~"+startage+"~"+startunits+"~"+endage+"~"+endunits+"~"+seqno+"~"+reflow+"~"+refhigh+"~"+criticallow+"~"+criticalhigh+"~"+uom+"~ "+def+"~"+insertyn;
					if(i%2 == 0)
						classval = "QRYODD";
					else
						classval = "QRYEVEN";
					out.println("<tr><td class='"+classval+"' id=\"sex_"+i+"\"><a href='javascript:showDetails(\""+currconvals+"\",\""+i+"\",\"N\")'>"+sex+"</a></td>");
					out.println("<td align='right' class='"+classval+"' id=\"startage_"+i+"\">"+startage+"</td>");
					String startUnitLabel = "";
					if("D".equals(startunits))
						startUnitLabel = "Days";
					else if("M".equals(startunits))
						startUnitLabel = "Months";
					else if("Y".equals(startunits))
						startUnitLabel = "Years";
					else
						startUnitLabel = startunits;
					String endUnitLabel ="";
					if("D".equals(endunits))
						endUnitLabel = "Days";
					else if("M".equals(endunits))
						endUnitLabel = "Months";
					else if("Y".equals(endunits))
						endUnitLabel = "Years";
					else 
						endUnitLabel = endunits;
					out.println("<td class='"+classval+"' id=\"startunits_"+i+"\">"+startUnitLabel+"</td>");
					out.println("<td align='right' class='"+classval+"' id=\"endage_"+i+"\">"+endage+"</td>");
					out.println("<td class='"+classval+"' id=\"endunits_"+i+"\">"+endUnitLabel+"</td>");
					out.println("<td align='right' class='"+classval+"' id=\"seqno_"+i+"\">"+seqno+"</td>");
					out.println("<td align='right' class='"+classval+"' id=\"reflow_"+i+"\">"+reflow+"</td>");
					out.println("<td align='right' class='"+classval+"' id=\"refhigh_"+i+"\">"+refhigh+"</td>");
					out.println("<td align='right' class='"+classval+"' id=\"criticallow_"+i+"\">"+criticallow+"</td>");
					out.println("<td align='right' class='"+classval+"' id=\"criticalhigh_"+i+"\">"+criticalhigh+"</td>");
					out.println("<td class='"+classval+"' id=\"uom_"+i+"\">"+uom+"</td>");
					//out.println("<td id=\"def_"+i+"\" align='right' class='"+classval+"' value='"+(def.equals("")?"0":def)+"'>"+(def.equals("0")?"&nbsp;":def)+"</td></tr>");//commented for IN070957
					out.println("<td id=\"def_"+i+"\" align='right' class='"+classval+"' value='"+def+"'>"+((def.trim()).equals("")?"&nbsp;":def)+"</td></tr>");//added for IN070957
					out.println("<input type='hidden' id=\"insertyn_"+i+"\" value='N'>");
					i++;
				}
			}
		}
	%>
	</table>
	<input type="hidden" name="prev_con_vals" id="prev_con_vals" value="<%=convals%>">
	<input type="hidden" name="total_rows" id="total_rows" value="<%=i%>">
	<input type="hidden" name="max_min_dec" id="max_min_dec" value="<%=maxmindec%>">
	
<%
	}
%>

	<!-- added on 30-10-2003 by dhanasekaran -->
	<input type="hidden" name="con_vals" id="con_vals" value="">
	<input type="hidden" name="row_num" id="row_num" value="">
	<!-- end addition -->

</form>
</BODY>
</HTML>

