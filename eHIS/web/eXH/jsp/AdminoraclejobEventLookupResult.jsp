<!DOCTYPE html>
<html>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%request.setCharacterEncoding("UTF-8"); %> 
<head>
  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="DATAELEMENTCROSSREF" id="DATAELEMENTCROSSREF" method="POST" action='../../eXH/jsp/' >
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
																												 

<tr>
 
	<td class='COLUMNHEADER' width='35%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='45%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<!---<td class='COLUMNHEADER' width='45%'>Enabled</td>---->
</tr>
<%
	boolean boolToggle =  true;	
	String strTDClass = "";
	String strBeanName = XHEventControllerBean.strBeanName;

  
	//String from			= request.getParameter("from") ;
	//String to			= request.getParameter("to") ;  
	//String checkedOnes	= "";
	//String  req_start   =   "", req_end     =   "";
	String commode= XHDBAdapter.checkNull(request.getParameter("commmode"));
	String called_from = request.getParameter("called_from");
	if(called_from==null) called_from = "";
		//String sql_query=request.getParameter("sql_query");
 	String search_by=request.getParameter("search_by");
	if(search_by==null || search_by=="null") search_by = "C";
 	String description_code=(request.getParameter("description_code")==null||request.getParameter("description_code").equals("null"))?"":request.getParameter("description_code");
	String long_desc=request.getParameter("search_text");
	if(long_desc==null || long_desc=="null") long_desc = "";
 		  
 	//String facility_id = (String)session.getValue("facility_id");
	


 

	
 
  String protocol_link_id=XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));
//System.out.println("protocol_link_id :"+protocol_link_id+"commode :"+commode); 
String event_id="";
String whereCaluse=" AND f.COMMUNICATION_TYPE in ('"+commode+"','*')"; 


if(long_desc.indexOf(",")!=-1)
{
	String[] splitstr=long_desc.split(",");
	String addComma="";
	for(int i=0;i<splitstr.length;i++)
	{
		if(i==(splitstr.length-1))
		{
		addComma=new String("'"+splitstr[i]+"'");
		}
		else
		{
		addComma=new String("'"+splitstr[i]+"',");
		}

	event_id=event_id+addComma;
    }
    whereCaluse=whereCaluse+"AND A.EVENT_TYPE in ("+event_id+") ORDER BY 1 ";
}
else
{




if(search_by.equals("C"))
{
	if(description_code.equals("S"))
	{
		whereCaluse=whereCaluse+" AND UPPER(a.EVENT_TYPE) LIKE UPPER('"+long_desc+"%') AND UPPER(f.event_name) LIKE UPPER('%') ORDER BY  a.event_type";
	}  
   else if(description_code.equals("E"))
	{
         whereCaluse=whereCaluse+" AND UPPER(a.EVENT_TYPE) LIKE UPPER('%"+long_desc+"') AND UPPER(f.event_name) LIKE UPPER('%') ORDER BY  a.event_type";
	}
	else
	{
	 whereCaluse=whereCaluse+" AND UPPER(a.EVENT_TYPE) LIKE UPPER('%"+long_desc+"%') AND UPPER(f.event_name) LIKE UPPER('%') ORDER BY  a.event_type";
	}
 }
 else
 {
   if(description_code.equals("S"))
	{
		whereCaluse=whereCaluse+" AND UPPER(a.EVENT_TYPE) LIKE UPPER('%') AND UPPER(f.event_name) LIKE UPPER('"+long_desc+"%') ORDER BY  a.event_type";
	} 
   else if(description_code.equals("E"))
	{
         whereCaluse=whereCaluse+" AND UPPER(a.EVENT_TYPE) LIKE UPPER('%') AND UPPER(f.event_name) LIKE UPPER('%"+long_desc+"') ORDER BY  a.event_type";
	}
	else
	{
	 whereCaluse=whereCaluse+" AND UPPER(a.EVENT_TYPE) LIKE UPPER('%') AND UPPER(f.event_name) LIKE UPPER('%"+long_desc+"%') ORDER BY  a.event_type";
	}
 }
}
Connection conn = null;


try 
{
		    
	conn = ConnectionManager.getConnection(request);

    request.setAttribute("whereCaluse",whereCaluse);
	request.setAttribute("protocol_link",protocol_link_id);
	XHEventControllerBean	xhBean = XHEventControllerBean.getBean(strBeanName,request,session);
	//XHDervationControllerBean xhBean = XHDervationControllerBean.getBean(strBeanName,request,session,response);
	xhBean.action(request,conn);
	HashMap resultsQry = xhBean.getResultSet();
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



if(arrRow.size()==0)
{
	%>
	<script>
alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
</script>
<%
}
else																							 
{
	%>
<tr>
	<td colspan="10" align="right" class="CAGROUP" > 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%= strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%= strNext %></A>     
	</td>
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
	
	

%>
<tr>

<td <%=strTDClass%> align="left" ><%=arrCol.get(0)+""%></td>
<td <%=strTDClass%> align="left" ><%=arrCol.get(1)+""%></td>
 </td>


<%---<td <%=strTDClass%> align="left" >
<input type="checkbox" size="2" name='<%=arrCol.get(0)+"_check"%>' id='<%=arrCol.get(0)+"_check"%>' id='<%=j+"_enable"%>' value='<%=arrCol.get(2)+""%>' onClick="getDescription(this,'<%=j%>')" <%=((String)arrCol.get(2)).equals("Y")?"checked":""%>>----%>
	
</td> 

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
out.println("Error ings thana="+e1);
}
finally
{
	ConnectionManager.returnConnection(conn);
}
%>
</table>
<table border='0' width='100%'>
	 <tr>
	 	<td  align='right'><input type='button' class='button' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' width='25%' onclick='funok()'></td>
	 </tr>
</table>
	<input type='hidden' name='action_type' id='action_type' value='U' >
</form>

<script>
function funSubmit()
{
	var act = '../../eXH/jsp/AdminoraclejobEventLookupResult.jsp?';
	this.document.forms[0].action = act;
	this.document.forms[0].submit();
}
function funAction(typ)
{
	document.forms[0].action_type.value = typ;
	this.document.forms[0].target=''
	funSubmit();
}
function getDescription(obj,cou)
{
	if(document.getElementById(cou+"_enable").checked)
	{
		document.getElementById(cou+"_enable").value="Y";
	}
	else
	{
		document.getElementById(cou+"_enable").value="N";
	}
	funAction("R");
}
function funok() 
{
	/*var dialogHeight= "250" ;
	var dialogWidth	= "250" ;
	var dialogTop = "250" ;
	var center = "250" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments="";
	var str=window.showModalDialog("../../eXH/jsp/EventTypeValidate.jsp?action_type=R",arguments,features);*/



//window.returnValue=str;

	window.close();
}

</script>
</body>
</html>


