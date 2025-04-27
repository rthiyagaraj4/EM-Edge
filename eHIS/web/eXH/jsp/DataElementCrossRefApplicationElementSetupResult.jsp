<!DOCTYPE html>
<html> 
<%@ page import="java.sql.*,java.util.*,java.io.*,java.util.regex.*,java.lang.*,java.lang.String,eXH.*,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<head>

<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script> 
<script Language="JavaScript"  src="../../eXH/js/DataElementCrossReferenceapplelement.js" ></script> 
 <script language='JavaScript' src='../../eXH/js/DataElementCrossRefLayer.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script> 
function checkcombo(cou)  
{   

	document.getElementById("_field"+cou).value="Y";
}
</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad='formload()'> 
<form name="DATAELEMENTCROSSREF" id="DATAELEMENTCROSSREF" method="post" action=''   > 
<%
int count=0;
boolean boolToggle =  true;	
String strTDClass = ""; 
String strBeanName = XHApplicationElementControllerBean.strBeanName;
Connection conn = null;
ArrayList arrRow = null;
ArrayList arrCol = null;
HashMap resultsQry=null;
String strPrevious = "";  
String strNext  = "";
Statement stmt=null;
ResultSet rs=null; 
String selectQuery="";
Statement stmt1=null; 
ResultSet rs1=null;
String selectQuery1="";
Statement stmt2=null;
ResultSet rs2=null;
String selectQuery2="";
String segment_type=request.getParameter("segment_type_id");
String standard_code=request.getParameter("standard_code");
 String element_code=request.getParameter("element_id");
 
String element_desc=request.getParameter("element_desc");   

Pattern Regex = null;
try
{
	request.setAttribute("Sement_type",segment_type);
    request.setAttribute("standard_code",standard_code);  
	request.setAttribute("element_id",element_code);
    request.setAttribute("element_desc",element_desc); 
    request.setAttribute(XHApplicationElementControllerBean.element_code,element_code);
    request.setAttribute(XHApplicationElementControllerBean.element_desc,element_desc); 

	conn = ConnectionManager.getConnection(request);
	XHApplicationElementControllerBean	xhBean = XHApplicationElementControllerBean.getBean(strBeanName,request,session);
	xhBean.action(request,conn);
	resultsQry = xhBean.getResultSet();
	arrRow = (ArrayList)resultsQry.get("qry_result"); 
	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	 strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
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
		strNext  =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels"); 
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
alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"))
</script>
<% } else { %>

	<tr>
	
	<td colspan="8" align="right" class="CAGROUP" > 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%= strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%= strNext %></A>
	</td>
	</tr>

<tr>


<td class='COLUMNHEADER' width='40%'><fmt:message key="eXH.ElementDesc.Label" bundle="${xh_labels}"/></td>
<td class='COLUMNHEADER' width='25%'><fmt:message key="eXH.ehisentity.Label" bundle="${xh_labels}"/></td>
	<!--<td class='COLUMNHEADER' width='30%'>Translate Entity</td>--->
	
<!---<td class='COLUMNHEADER'width='20%'>Attributes1</td>---->
<td class='COLUMNHEADER'width='40%'><fmt:message key="Common.secondary.label" bundle="${common_labels}"/> <fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
<!--<td class='COLUMNHEADER'width='20%'>Translation Query</td> --->
<td class='COLUMNHEADER'width='30%'><fmt:message key="eXH.FormatType.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>

     
</tr>
	<%
boolean flag_rec_enbld = false; 
	String[] element=new String[2];
String translate_entity="";
	
	stmt= conn.createStatement();
	stmt2= conn.createStatement();
stmt1= conn.createStatement();
	for (int j=0; j<arrRow.size();j++)
	{
		String elementat1="",elementat2="";
		String elementid2="";
		String ehis_entitydesc="";
        String element_id="";
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
//
String medicom_master=XHDBAdapter.checkNull((String)arrCol.get(10));

if(medicom_master.equals(""))
	{
	medicom_master=(String)arrCol.get(7);
	}
	


           selectQuery="select distinct MASTER_TABLE_ID,TABLE_DESC,TRANS_TABLE_ID from XH_mapping where MASTER_TABLE_ID='"+medicom_master+"'";
   String ehisid="";
				
		rs = stmt.executeQuery(selectQuery) ;
        while(rs.next())
		{
           ehisid=rs.getString(1);
         ehis_entitydesc=rs.getString(2);
        translate_entity=rs.getString(3);

		}




String pk_element_ref=(String)arrCol.get(8);
if(pk_element_ref.indexOf("|")==-1)
		{

         element_id="";
			 //pk_element_ref;
        
		 selectQuery1="select ELEMENT_NAME from xh_element_crossref where ELEMENT_ID='"+element_id+"'";
                   rs1 = stmt1.executeQuery(selectQuery1) ;
                  while(rs1.next())
		        {
                elementat1="";
				

		        }
				
		}
else
		{

if(pk_element_ref.equals("")||pk_element_ref==null) 
		{

		}
else
		{

         Regex = Pattern.compile("\\|");
        element=Regex.split(pk_element_ref);




       for(int k=0;k<element.length;k++)
			{
		
	             if(k==1)
				{
                  elementid2=element[1].toString().trim();
                   selectQuery2="select  ELEMENT_NAME from xh_element_crossref where ELEMENT_ID='"+element[1].toString().trim()+"'";

				
		         rs2 = stmt2.executeQuery(selectQuery2) ;
                while(rs2.next())
			     {
                   elementat2=rs2.getString(1);
			     }

			  }
			else
			{
                  element_id=element[0].toString().trim();
                  selectQuery1="select ELEMENT_NAME from xh_element_crossref where ELEMENT_ID='"+element_id+"'";
                   rs1 = stmt1.executeQuery(selectQuery1) ;
                  while(rs1.next())
		        {
                elementat1=rs1.getString(1);
				

		        }
			 }


				
	}


				if(	rs!=null)
					{
						rs.close();
					}

		}


	}
		if(	rs1!=null)
					{
						rs1.close();
					}


				if(	rs2!=null)
					{
					rs2.close();
					}
if(((String)arrCol.get(5)).equals("C"))
{
	flag_rec_enbld=true;
}

				
	%>
	<tr>
	<td <%=strTDClass%> align="left" nowrap >
    <% if ((arrCol.get(5)).equals("C")){ %>
    <font color=green> <% }%>
	<%=arrCol.get(1)+""%>
	</td>
<td <%=strTDClass%> align="left" nowrap >

<input type="hidden" name='<%=arrCol.get(0)+"medicom_master"%>' id='<%=arrCol.get(0)+"medicom_master"%>' id=<%="medicom_master"+j%> value='<%=XHDBAdapter.checkNull((String)arrCol.get(10))%>' >
<input type='text' name='<%=arrCol.get(0)+"ehis_entity"%>' id='<%=arrCol.get(0)+"ehis_entity"%>' onBlur="if(this.value!='')myClick(event,'<%=j%>');else document.getElementById('ehisentity_id<%=j%>').value='';checkValid('<%="ehis_entityname"+j%>','<%=j%>');" id =<%="ehis_entityname"+j%> size=30  value='<%=ehis_entitydesc%>' >
<input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name='elementIDSearch' id='elementIDSearch' value='?'    onClick="myClick(event,<%=j%>)">
<input type="hidden" name='<%=arrCol.get(0)+"ehis_id"%>' id='<%=arrCol.get(0)+"ehis_id"%>' id=<%="ehisentity_id"+j%> value='<%=ehisid%>' >
<input type="hidden" name='<%=arrCol.get(0)+"element_id"%>' id='<%=arrCol.get(0)+"element_id"%>' id='<%="element_id"+j%>' value='<%=(arrCol.get(0)+"")%>'>

</td> 
<%---<td <%=strTDClass%> align="left" nowrap > <input type='text'   id =<%="Translate_entitya2"+j%> value='<%=(String)arrCol.get(6)%>'  size=15 readonly > ---%>

<input type="hidden" id='<%="Translate_entity"+j%>' name='<%=arrCol.get(0)+"_entity"%>' value='<%=translate_entity%>'>

</td>
<td <%=strTDClass%> align="left" id='<%="attr"+j%>' nowrap >
<input type='text' name='<%=arrCol.get(0)+"element_namea2"%>' id='<%=arrCol.get(0)+"element_namea2"%>' id =<%="element_namea2"+j%> size=30  value='<%=elementat1%>' >
<input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name='<%="elementIDSearcha2"+j%>' id='<%="elementIDSearcha2"+j%>' value='?'    onClick="searchElementID1(event,<%=j%>)">

<%---<input type='text' name =<%=arrCol.get(0)+"element_namea2"%> id='<%="element_namea2"+j%>' value='<%=elementat1%>' size=20><input style="background:navy; color:white ;font-size:8pt;font-Weight:600 ;border-style: ridge;" type="button"  name='<%="elementIDSearcha2"+j%>' id='<%="elementIDSearcha2"+j%>' value='?' onClick="searchElementID1(event,<%=j%>)" >----%>
<input type=hidden name='<%=arrCol.get(0)+"Translation_query"%>' id='<%=arrCol.get(0)+"Translation_query"%>'   value='<%=((String)arrCol.get(9)).equals("null")?"":(java.net.URLEncoder.encode((String)arrCol.get(9)))%>'>
<input type="hidden" id=<%="element_ida2"+j%> name='<%=arrCol.get(0)+"element_ida2"%>' value='<%=element_id%>'>
</td>
<td <%=strTDClass%> align="left" nowrap>

<input type="hidden" id='<%="formate_type1"+j%>' name='<%=arrCol.get(0)+"_format1"%>' value='<%=XHDBAdapter.checkNull(arrCol.get(2)+"")%>'>
	<select name='<%=arrCol.get(0)+"_format"%>' id='<%=arrCol.get(0)+"_format"%>'  style="width:150" onchange='checkcombo(<%=j%>);'>
<%
	if(translate_entity.equals("XH_OTH_APPL_DATA_SKEY")||translate_entity.equals("XH_OTH_APPL_DATA_DKEY")||translate_entity.equals(""))
	{
	
         if((arrCol.get(2).toString().trim()).equals("H")||XHDBAdapter.checkNull(arrCol.get(2).toString().trim()).equals(""))
        {
	%>
<option value="H" selected><fmt:message key="Common.code.label" bundle="${common_labels}"/> & <fmt:message key="Common.description.label" bundle="${common_labels}"/></option>
    <option value="S"><fmt:message key="Common.code.label" bundle="${common_labels}"/> </option>
	<%}
	else
	{  
	%>
	<option value="H" ><fmt:message key="Common.code.label" bundle="${common_labels}"/> & <fmt:message key="Common.description.label" bundle="${common_labels}"/></option>
    <option value="S" selected><fmt:message key="Common.code.label" bundle="${common_labels}"/> </option>
	<%
		}
	}
	else if(translate_entity.equals("") || translate_entity==null )
		{
		%>
		<option value="H" ><fmt:message key="Common.code.label" bundle="${common_labels}"/> & <fmt:message key="Common.description.label" bundle="${common_labels}"/></option>
    <option value="S" selected><fmt:message key="Common.code.label" bundle="${common_labels}"/> </option>
<%}
	else 
		{
	%>
		<option value="U"><fmt:message key="Common.UserDefined.label" bundle="${common_labels}"/></option>
	<%}%>

     </select> 
	</td>
	<%---<td <%=strTDClass%> align="left" nowrap ><textarea name='<%=arrCol.get(0)+"Translation_query"%>' id='<%="Translation_query"+j%>' onClick="openwindow('<%="Translation_query"+j%>')" rows=1 cols=15   readonly><%=((String)arrCol.get(9)).equals("null")?"":((String)arrCol.get(9))%> </textarea> </td>---%>
	<td <%=strTDClass%> align="center" nowrap>
    <% if ((arrCol.get(5)).equals("C")){ %>
    <font color=green> <% }else {%>
	<%}%>

	<input type="checkbox" size="10" id='<%=arrCol.get(0)+"_check"%>' name='<%=arrCol.get(0)+"_check"%>' value='<%=(String)arrCol.get(3)%>' <%=((String)arrCol.get(3)).equals("N")? "":"checked"%> onClick="funCheck(this,'<%=j%>')">
	<input type="hidden" name='<%=arrCol.get(0)+"_value"%>' id='<%=arrCol.get(0)+"_value"%>' value='<%=arrCol.get(4)+""%>'>
	<input type=hidden name='<%=arrCol.get(0)+"_field"%>' id='<%=arrCol.get(0)+"_field"%>'  value='<%=(String)arrCol.get(11)%>'> 
	</td>
	</tr>
    
	<% 
count++;
	}
	
	
	
	
	%>
<tr>
<% if (flag_rec_enbld == true)
 { %>
		<td colspan=8 class=label><img src='../../eXH/images/green_square.jpg' width=40 height=15 > Recently Enabled Elements </td> 
<%}%>


		</tr>

<%

if(arrRow!=null) arrRow.clear();
if(arrCol!=null) arrCol.clear();
if(resultsQry!=null) resultsQry.clear();

if(stmt!=null)
	{
	stmt.close();
		
	}
	if(stmt1!=null)
	{
	stmt1.close();
		
	}
	if(stmt2!=null)
	{
	stmt2.close();
	
	}
	
	/*if(	rs1!=null)
	{
		rs1.close();
	}


if(	rs2!=null)
	{
	rs2.close();
	}*/
}
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
<input type='hidden' name='action_type' id='action_type' value='' >
<input type='hidden' name='count_field' id='count_field' value='<%=count%>' >

</form>
</html>


