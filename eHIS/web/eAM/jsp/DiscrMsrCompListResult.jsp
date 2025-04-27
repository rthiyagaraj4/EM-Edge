<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*,java.util.*,java.sql.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<jsp:useBean id="associateDiagBean1" class="webbeans.eCommon.RecordSet" scope="session"/>

<html>
<style>
TD.FIRSTSELECTED
{
	BACKGROUND-COLOR: RED;  
	FONT-SIZE: 9pt ;
	BORDER-STYLE: SOLID;
	border-left-color: #B2B6D7;
	border-right-color: #B2B6D7;
	border-top-color: #E2E3F0;
	border-bottom-color: #E2E3F0;
	height:18;	
}
</style>
<%
	out.println("<head>	<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script></head><BODY OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'  class='CONTENT' >");
%>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src='../../eAM/js/DiscrMsrComp.js' language='javascript'></script>
	<script language="JavaScript">
      /*************************************************/

var firstElementSelected = false, secondElementSelected = false;
var firstElementIndex = 0, secondElementIndex = 0;

function positionComponents(firstElementIndex, secondElementIndex)
{
    if(eval(firstElementIndex)<eval(secondElementIndex))
		secondElementIndex=eval(secondElementIndex+1)
//	secondElementIndex=eval(secondElementIndex+1)
	var listComponentDefinition = document.DiscrMeasureResult_form.prev_con_vals.value.split("`");	
	
	var temp = document.DiscrMeasureResult_form.prev_con_vals.value.split("`");
    
	var firstElementDefinition = listComponentDefinition[firstElementIndex];
	
	var secondElementDefinition = listComponentDefinition[secondElementIndex]; 
	

	if(firstElementIndex < secondElementIndex)
	{
		for(i=0;i<temp.length;i++)
		{
			if(i < firstElementIndex || i >= secondElementIndex)
				temp[i] = listComponentDefinition[i];			
			else if(i >= firstElementIndex && i < (secondElementIndex-1))
				temp[i] = listComponentDefinition[i+1];
			else if(i == (secondElementIndex-1))
				temp[i] = firstElementDefinition;
		}
	}
	else if(firstElementIndex > secondElementIndex)
	{
		for(i=0;i<temp.length;i++)
		{
			if(i > firstElementIndex || i < secondElementIndex)
				temp[i] = listComponentDefinition[i];
			else if(i == secondElementIndex)
				temp[i] = firstElementDefinition;
			else if(i <= firstElementIndex && i > secondElementIndex)
				temp[i] = listComponentDefinition[i-1];
		}
	}
	
	return temp;
	
}


function positionGridComponents(details,srlno)
{
	
	var temp = details.split("~");
	//var srlno = "";
	var refrangeseq = "";
	var description = "";
	var result = "";
	var numericvalues = "";
	var defaultval = "";
	var componentColPos = "";
	var componentColSpan = "";
	var textRows = "";

	if(temp != null && temp.length == 7)
	{
		srlno = escape(temp[0]);
		
		refrangeseq = escape(temp[1]);
		description = escape(temp[2]);
		
		result = escape(temp[3]);
		
		numericvalues = escape(temp[5]);
	    
		defaultval = escape(temp[4]);
		
		textRows = temp[6];
	}
 
    if(!firstElementSelected)
	{

		firstElementSelected = true;
		firstElementIndex = srlno;
		
		secondElementIndex = 0;
		secondElementSelected = false;
		var rowId_obj = document.getElementById('rowId');
		
		for(i=0;i<rowId_obj.length;i++)
		{
			for(j=0;j<rowId_obj[i].cells.length;j++)
			{
				
				if(i == (firstElementIndex-1))
				{	
					
					rowId_obj[i].cells[j].className = "FIRSTSELECTED";	
				}					
						
			}
		}
		
	}
	else 
	{
		
		
		firstElementSelected = false;
		secondElementSelected = true;
		secondElementIndex = srlno;
		
		var defntemp = positionComponents(firstElementIndex-1, secondElementIndex-1);
		
		var newdefn='';
		
		for(i=0;i<defntemp.length;i++)
        newdefn  = newdefn + defntemp[i] + "`"
		
		if(!secondElementSelected)
		{
			//parent.templateGridDefFrame.document.location = action_url;
		}	
		else
		{ 
		
			var status=document.forms[0].status.value;
	    	document.forms[0].action="DiscrMsrCompListResult.jsp?from=A&status="+status;
	        document.forms[0].target="result";
			document.forms[0].con_vals.value=escape(newdefn);
			document.forms[0].SrlNo.value="Y";
	        document.forms[0].submit();
	 		//parent.result.document.location.href = "../../eAM/jsp/DiscrMsrCompListResult.jsp?from=A&status="+status+" &con_vals="+escape(newdefn);
			
			firstElementSelected = false;
			secondElementSelected = false;
			firstElementIndex = 0;
			secondElementIndex = 0;
		} 
	}
}
 
		function showDetails(vals,rownum,from)
		{
			//added on 30-10-2003 by dhanasekaran
			document.forms[0].con_vals.value=vals;
			document.forms[0].row_num.value=rownum;
			//end addition
			
			if(from == 'A')
			{
				//parent.frames[1].location.href = "../../eAM/jsp/DiscrMeasureAlphaInfoAddModify.jsp?con_vals="+escape(vals)+"&row_num="+escape(rownum);
				document.forms[0].target="f_query_add_mod1";
				document.forms[0].submit();
			}
/*			else
			{
				parent.frames[1].location.href = "../../eAM/jsp/DiscrMeasureNumericAddModify.jsp?con_vals="+escape(vals)+"&row_num="+escape(rownum)+"&max_min_dec="+document.getElementById("max_min_dec").value;
			} */
		}
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<body onKeyDown = 'lockKey()'>
<% 

request.setCharacterEncoding("UTF-8");

Connection con = null;
PreparedStatement stmt1=null;
ResultSet rset1=null ;

con = ConnectionManager.getConnection(request);

String SrlNo = request.getParameter("SrlNo")==null?"":request.getParameter("SrlNo");
String status = request.getParameter("status")==null?"":request.getParameter("status");
%>
<form name='DiscrMeasureResult_form' id='DiscrMeasureResult_form' method="post" action="DiscrMsrCompListAddModify.jsp?status=<%=status%>" target="f_query_add_mod">
<%

		StringBuffer convals1 =new StringBuffer();
		String convals="";
		String sqlalpha="";

		String from = request.getParameter("from")==null?"":request.getParameter("from");
		//String convals = request.getParameter("con_vals")==null?"":request.getParameter("con_vals");
		String from_modal = request.getParameter("mode")==null?"":request.getParameter("mode");
		
		String comp_id = request.getParameter("discr_measure")==null?"":request.getParameter("discr_measure");

		if(!from_modal.equals("insert"))
		{
		 	sqlalpha="select REF_RANGE_SEQ,REF_RNG_DESC,RESULT_VALUE,NUMERIC_VALUE,SORT_ORDER,DFLT_YN from AM_DISCR_MSR_REF_RNG_LIST where discr_msr_id ='"+comp_id+"' order by REF_RANGE_SEQ";

			stmt1=con.prepareStatement(sqlalpha);
			rset1 = stmt1.executeQuery();
			while(rset1.next())
			{
				convals1.append(rset1.getString("REF_RANGE_SEQ")+"~"+rset1.getString("REF_RNG_DESC")+"~"+rset1.getString("RESULT_VALUE")+"~"+rset1.getString("DFLT_YN")+"~"+(rset1.getString("NUMERIC_VALUE")==null?"":rset1.getString("NUMERIC_VALUE"))+"`");
			}

			convals=convals1.toString();

			if(rset1!=null) 	rset1.close();
			if(stmt1!=null) 	stmt1.close(); 

		}
		if(con!=null)ConnectionManager.returnConnection(con,request);

	//	out.println("from_modal :"+from_modal);

		if(from_modal.equals("frommodal"))
		{
			/*ArrayList b= new ArrayList();
			b= associateDiagBean1.getRecordSetHandle();
			convals =b.get(0).toString();*/
			convals=request.getParameter("con_vals")==null?"":request.getParameter("con_vals");
		}
		else
		{
			if(from_modal.equals(""))
			{
				convals=convals1.toString();
				convals=request.getParameter("con_vals")==null?"":request.getParameter("con_vals");
			}
			else
			{	
				convals=request.getParameter("con_vals")==null?"":request.getParameter("con_vals");
			}
				
			if(SrlNo.equals("Y"))
			{
				if(!convals.equals(""))
					convals=java.net.URLDecoder.decode(convals);
			}
		}

         //int aa= b.getSize();
         
		if(from.equals("A"))
		{
%>		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<tr nowrap>
				<th width='5%'><fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/></th>	
				<th width='20%'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></th>		
				<th width='40%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
				<!--<th id='score1' style='display:none' width='20%'><fmt:message key="Common.Score.label" bundle="${common_labels}"/></th> -->
				<th width='10%'><fmt:message key="Common.Default.label" bundle="${common_labels}"/></th>
			</tr>
	<%	String refrangeseq = "";
		String description = "";
		String result = "";
		String numericvalues = "";
		String defaultval = "";
		String classval = "";

		int i = 0;
		int j=1;
		//ArrayList b=
		//temp_description=b.get(m+1).toString();
		if(!convals.equals(""))
		{
			//convals = convals.replace('�', '+');
	
			while(convals.indexOf('!')!=-1)
			{
				convals = convals.replace('!','+');
			}  
			java.util.StringTokenizer stout = new java.util.StringTokenizer(convals,"`");			

			while(stout.hasMoreTokens())
			{
				String temp = stout.nextToken();
				if(!temp.equals(""))
				{
					java.util.StringTokenizer st = new java.util.StringTokenizer(temp,"~");
					while(st.hasMoreTokens())
					{
				        defaultval="";
					    numericvalues="";
						refrangeseq = st.nextToken();
	                    description = st.nextToken();
						result = st.nextToken();
						defaultval = st.nextToken();
	
						if(st.hasMoreElements()) 
						numericvalues = st.nextToken();			
					
					}
					if(i%2 == 0)
						classval = "QRYODD";
					else
						classval = "QRYEVEN";
					
					String currconvals = refrangeseq+"~"+description+"~"+result+"~"+defaultval+"~"+numericvalues;
				%>
<!-- commented on 31-10-2003 by dhanasekaran
					<tr><td class='<%=classval%>' id='desc_<%=i %>'><a href='javascript:showDetails("<%=java.net.URLEncoder.encode(currconvals)%>","<%= i %>", "A")'><%=description%></a></td>
end comment-->
<!-- added on 31-10-2003 by dhanasekaran -->
					<tr id='rowId'>
					
					<td class='<%=classval%>' id='srlno_<%=j %>'><a href='javascript:positionGridComponents("<%=currconvals%>","<%=j%>")'><%=j%></a></td>

					<td  class='<%=classval%>' id='result_<%=i%>'><%=result%></td>

                    <td class='<%=classval%>' id='desc_<%=i %>'><a href='javascript:showDetails("<%=currconvals%>","<%= i %>", "A")'><%=description%></a></td>

                     <td  style='display:none' align='right' class='<%=classval%>' id='numericval_<%=i%>'><%=numericvalues%></td>
					
<!-- end addition -->
					
					<td  class='<%=classval%>' id='def_<%=i%>'><%=defaultval%></td>
					</tr>
					<input type='hidden' id='ref_range_seq_<%=i%>' value="<%=refrangeseq%>">
				<%
					i++;
					j++;
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
	<tr>
		<th rowspan=2><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
		<th colspan=2><fmt:message key="Common.Start.label" bundle="${common_labels}"/></th>
		<th colspan=2><fmt:message key="Common.End.label" bundle="${common_labels}"/></th>
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
					String currconvals = sex+"~"+startage+"~"+startunits+"~"+endage+"~"+endunits+"~"+seqno+"~"+reflow+"~"+refhigh+"~"+criticallow+"~"+criticalhigh+"~"+uom+"~"+def+"~"+insertyn;
					if(i%2 == 0)
						classval = "QRYODD";
					else
						classval = "QRYEVEN";
					out.println("<tr><td class='"+classval+"' id=\"sex_"+i+"\"><a href='javascript:showDetails(\""+currconvals+"\",\""+i+"\",\"N\")'>"+sex+"</a></td>");
					out.println("<td align='right' class='"+classval+"' id=\"startage_"+i+"\">"+startage+"</td>");
					out.println("<td class='"+classval+"' id=\"startunits_"+i+"\">"+startunits+"</td>");
					out.println("<td align='right' class='"+classval+"' id=\"endage_"+i+"\">"+endage+"</td>");
					out.println("<td class='"+classval+"' id=\"endunits_"+i+"\">"+endunits+"</td>");
					out.println("<td align='right' class='"+classval+"' id=\"seqno_"+i+"\">"+seqno+"</td>");
					out.println("<td align='right' class='"+classval+"' id=\"reflow_"+i+"\">"+reflow+"</td>");
					out.println("<td align='right' class='"+classval+"' id=\"refhigh_"+i+"\">"+refhigh+"</td>");
					out.println("<td align='right' class='"+classval+"' id=\"criticallow_"+i+"\">"+criticallow+"</td>");
					out.println("<td align='right' class='"+classval+"' id=\"criticalhigh_"+i+"\">"+criticalhigh+"</td>");
					out.println("<td class='"+classval+"' id=\"uom_"+i+"\">"+uom+"</td>");
					out.println("<td align='right' class='"+classval+"'>"+(def.equals("0")?"&nbsp;":def)+"<input type='hidden' id=\"def_"+i+"\" value='"+(def.equals("")?"0":def)+"'></td></tr>");
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
	<input type="hidden" name="SrlNo" id="SrlNo" value="N">
	<input type="hidden" name="con_vals" id="con_vals" value="">
	<input type="hidden" name="row_num" id="row_num" value="">
	<input type="hidden" name="status" id="status" value="<%=status%>">
	<input type="hidden" name="con_sp_val" id="con_sp_val" value="">
	<!-- end addition -->

</form>

<%
	if(status.trim().equalsIgnoreCase("Y"))
  	{
	 	// out.println("<script>invis();</script>");
		// disab = "disabled";
%>
	<script>
		//document.getElementById('score1').style.display='block';
		//var p= document.getElementById('total_rows').value;
	
		/*for(j=0;j<p;j++) 
		{
			obj = eval(document.getElementById('numericval_'+j));
		   	obj.style.display='block';
		}*/
	</script>
 
<%	}%>
</BODY>
</HTML>

