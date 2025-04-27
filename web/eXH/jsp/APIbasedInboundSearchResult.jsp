<!DOCTYPE html>
<html>
<%@ page import="java.sql.*,java.util.*,eXH.*,eXH.XHDBAdapter,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<head> 
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eXH/js/APIBasedInbound.js'></script>  
<script Language="JavaScript"  src="../../eCommon/js/common.js" ></script>
<script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

function dsbl_elment_Val(obj,srl_no){
	if(obj.value!=""){
//	    alert("elmnt Pos :   "+obj.value+", srl_no : "+srl_no);
		eval("document.forms[0].element_val_"+srl_no).disabled = true;
	}
	else{
		eval("document.forms[0].element_val_"+srl_no).disabled = false;
	}
}

function dsbl_elment_Pos(obj,srl_no){
	if(obj.value!=""){
//		alert("elmnt Val :   "+obj.value+", srl_no : "+srl_no);
		document.getElementById(srl_no+'_element_pos').disabled = true;
	}
	else{
		document.getElementById(srl_no+'_element_pos').disabled = false;
	}
}

</script>


</head>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="APIBasedSearchResult" id="APIBasedSearchResult" method="POST" action='' target="" >

	<%

			boolean boolToggle =  true;	
			String strTDClass = "";
			// #MOD#03
			String qry_id = "APIBASEDINBOUND";			
			Connection conn = null;
			String whereClause = "WHERE  ";

			String appl_id = "";
			String fac_id = "";
			String evnt_id = "";
			String sgmnt_id = "";
			String inb_api = "";

			String s_no  = "";

			String elmntPos = "";
			String elmntVal = "";
			String dsblPos  = "";
			String dsblVal  = "";

			String frmSrl_no = "";
			int i = 1;

	//		System.out.println("APIResult "+whereClause);
			try
			{

				appl_id = request.getParameter("appl_id");
					//System.out.println("appl_id : "+appl_id);
				fac_id  = request.getParameter("fac_id");
					//System.out.println("fac_id : "+fac_id);
				evnt_id = request.getParameter("evnt_id");
					//System.out.println("evnt_id : "+evnt_id);
				sgmnt_id  = request.getParameter("sgmnt_id");
					//System.out.println("sgmnt_id : "+sgmnt_id);
				inb_api   = request.getParameter("inb_api");
					//System.out.println("inb_api : "+inb_api);

				if(!(appl_id.equals(" "))){					
				  whereClause =whereClause + " A.APPLICATION_ID = NVL('#appl_id',A.APPLICATION_ID)";
 				} 

				if(!(fac_id.equals(" "))){					
				  whereClause =whereClause + " AND A.FACILITY_ID = NVL('#fac_id',A.FACILITY_ID)";
 				} 

				if(!(evnt_id.equals(" "))){					
				  whereClause =whereClause + " AND A.EVENT_TYPE = NVL('#evnt_id',A.EVENT_TYPE)";
 				} 
				
				if(!(sgmnt_id.equals(" "))){					
				  whereClause =whereClause + " AND A.SEGMENT_ID = NVL('#sgmnt_id',A.SEGMENT_ID)";
 				} 
				
				if(!(inb_api.equals(" "))){					
				  whereClause =whereClause + " AND A.INBOUND_API = NVL('#inb_api',A.INBOUND_API)";
 				} 

				whereClause = whereClause+" AND A.ELEMENT_POSITION=B.ELEMENT_ID(+)  ORDER BY a.sno";

				//System.out.println("APIbasedInboundQueryResult WhrCls : "+whereClause);

				request.setAttribute(XHQueryRender.strQueryId,qry_id);
				// #MOD#04
				//System.out.println("APIbasedInboundSearchResult qry id : "+qry_id);

				request.setAttribute(XHQueryRender.col,"6");
			    request.setAttribute(XHQueryRender.whereClause,whereClause);
				conn = ConnectionManager.getConnection(request);
				HashMap resultsQry = XHQueryRender.getResults(request,session,conn);
				ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
				ArrayList arrCol = null;
				boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
				boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
				String strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
				String strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
				if (boolPrevious == true)
				{
					strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
				}
				else
				{
					strPrevious = " ";
				}
				if (boolNext== true)
				{
						strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
				}
				else
				{
					strNext  = " ";
				}
		%>
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
<%
if(arrRow.size()==0)
{
%>

<script>
alert(getMessage('XH1021','XH'));
</script>

<% } else { %>
	<tr>
<!--	<td colspan="6" align="right" class="CAGROUP" >  -->
	<td colspan="5" align="right" class="CAGROUP" > 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%=strNext %></A>
	</td>
	</tr>

<tr>
	<td class='COLUMNHEADER'  width='10%'><fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='20%'><fmt:message key="eXH.ArgID.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  width='20%'><fmt:message key="eXH.ArgName.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  width='20%'><fmt:message key="eXH.ElementPos.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  width='50%'><fmt:message key="eXH.ElementVal.Label" bundle="${xh_labels}"/></td>
</tr>




	<%
	for (int j=0; j<arrRow.size();j++)
	{
		arrCol = (ArrayList)arrRow.get(j);
		if (boolToggle == true)
		{
			strTDClass = "class='QRYEVEN'";
			boolToggle =  false;
		}
		else
		{
			strTDClass = "class='QRYODD'";
			boolToggle =  true;
		}
			
			dsblPos = "";
			dsblVal = "";

			s_no = 	XHDBAdapter.checkNull((String)arrCol.get(0));
			if(i==1){
					frmSrl_no = s_no;
					i++;
			}
			elmntPos = XHDBAdapter.checkNull((String)arrCol.get(5));
			elmntVal = XHDBAdapter.checkNull((String)arrCol.get(4));

			if(!elmntPos.equals("")){
			     dsblVal = "disabled";
			}
			else if (!elmntVal.equals("")){
				dsblPos =  "disabled";
			}
	%>

	<tr>
	<td <%=strTDClass%>  align="left" >
	<%=s_no%>
	</b>
	</td>
	<td <%=strTDClass%> align="left"> 
	<%=""+XHDBAdapter.checkNull((String)arrCol.get(1))%>
	</td>
	<td <%=strTDClass%> align="left"> 
	<%=""+arrCol.get(2) %>
	</td>

	<td <%=strTDClass%> align=center ><input type="text" id="<%=s_no%>_element_pos" name="<%=s_no%>_element_pos" value="<%=elmntPos%>"  <%=dsblPos%> onchange="dsbl_elment_Val(this,'<%=s_no%>');">
			<input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=ElementSearch id=ElementSearch value='?'    onClick="searchElement('<%=s_no%>');">
			<input type="hidden" id="<%=s_no%>_element_id" name="<%=s_no%>_element_id" value='<%=XHDBAdapter.checkNull((String)arrCol.get(3))%>' ></td>	
	<td <%=strTDClass%> align=center ><input type="text" name='element_val_<%=s_no%>' id='element_val_<%=s_no%>' value="<%=elmntVal%>" <%=dsblVal%> onchange="dsbl_elment_Pos(this,'<%=s_no%>');"></td>	

	</tr>
	<%
	}
}
if(arrRow!=null) arrRow.clear();
if(arrCol!=null) arrCol.clear();
if(resultsQry!=null) resultsQry.clear();
}
	catch(Exception e1)
	{
		out.println("Error="+e1);
	}
	finally
	{
		ConnectionManager.returnConnection(conn);
	}
	%>
	</table>

	<input type='hidden' name='mode' id='mode' value='U' >
	<input type='hidden' name='action_type' id='action_type' value=''>


	<input type='hidden' name='application_id' id='application_id' value=''>
	<input type='hidden' name='facility_id' id='facility_id' value=''>
	<input type='hidden' name='event_type_id' id='event_type_id' value=''>
	<input type='hidden' name='segment_type_id' id='segment_type_id' value=''>
	<input type='hidden' name='inboundapi_id' id='inboundapi_id' value=''>
	<input type='hidden' name='application_name' id='application_name' value=''>
	<input type='hidden' name='facility_name' id='facility_name' value=''>
	<input type='hidden' name='event_type' id='event_type' value=''>
	<input type='hidden' name='segment_type' id='segment_type' value=''>
	<input type='hidden' name='inboundapi_name' id='inboundapi_name' value=''>

	<input type='hidden' name='arg_serial_no' id='arg_serial_no' value=''>
	<input type='hidden' name='arg_id' id='arg_id' value=''>
	<input type='hidden' name='arg_name' id='arg_name' value=''>
	<input type='hidden' name='element_pos' id='element_pos' value=''>
	<input type='hidden' name='element_val' id='element_val' value=''>

	<input type='hidden' name='appl_id' id='appl_id' value=<%=appl_id%>>
	<input type='hidden' name='fac_id' id='fac_id' value=<%=fac_id%>>
	<input type='hidden' name='evnt_id' id='evnt_id' value=<%=evnt_id%>>
	<input type='hidden' name='sgmnt_id' id='sgmnt_id' value=<%=sgmnt_id%>>
	<input type='hidden' name='inb_api' id='inb_api' value=<%=inb_api%>>

	<input type='hidden' name='frmSrl_no' id='frmSrl_no' value=<%=frmSrl_no%>>	

</form>
</html>


