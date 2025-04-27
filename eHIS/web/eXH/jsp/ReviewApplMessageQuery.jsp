<!DOCTYPE html>
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<HTML>
<HEAD>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript"src="../../eXH/js/ApplicationMessages.js"></script>
<script language="JavaScript">
//function setValues
function setValues()
{    
	var select_boxf=document.getElementById("facility_name");
	var select_boxa=document.getElementById("appl_name");
	var select_boxm=document.getElementById("msg_type");
	var select_boxe=document.getElementById("event_type");
	var select_boxs=document.getElementById("msg_status");
<%
	String appl_name=request.getParameter("appl_name");
	String facility_name=request.getParameter("facility_name");
	String msg_type=request.getParameter("msg_type");
	String msg_date=request.getParameter("msg_date");
	String msg_status=request.getParameter("msg_status");
	String msg_id=request.getParameter("msg_id");
	String patient_id=request.getParameter("patient_id");
	
    if(appl_name==null) appl_name=""; 
	
	%>  
	for( var j=0;j<select_boxa.options.length;j++)
	{
	   if(select_boxa.options[j].value =='<%=appl_name%>')
       select_boxa.options[j].selected=true;
	}
	
    <%if(facility_name==null) facility_name="";
    %>  
	for( var j=0;j<select_boxf.options.length;j++)
	{
	 if(select_boxf.options[j].value =='<%=facility_name%>')
     select_boxf.options[j].selected=true;
	}
	
	<%if(msg_type==null) msg_type="";
	%>  
	for( var j=0;j<select_boxm.options.length;j++)
	{
	  if(select_boxm.options[j].value =='<%=msg_type%>')
      select_boxm.options[j].selected=true;
	}
	

	<%if(patient_id==null) patient_id="";
	if(msg_date==null) msg_date="";
	if(msg_status==null) msg_status="";
	if(msg_id==null) msg_id="";
	%>
	
	for( var j=0;j<select_boxs.options.length;j++)
	{
	 if(select_boxs.options[j].value =='<%=msg_status%>')
     select_boxs.options[j].selected=true;
	}
	
	this.document.forms[0].msg_date.value='<%=msg_date%>';
	this.document.forms[0].patient_id.value='<%=patient_id%>';
	this.document.forms[0].msg_id.value='<%=msg_id%>';
	
	}
//function removeAllOptions
function removeAllOptions(selectbox)
{
var i;
for(i=selectbox.options.length-1;i>=1;i--)
{
selectbox.remove(i);
}
}
//function onChangeMsgType
function onChangeMsgType()
{
   
	this.document.forms[0].action='../../eXH/jsp/ReviewApplMessageQuery.jsp';
	this.document.forms[0].target='f_query_add_mod';
	this.document.forms[0].submit();
	
}
//function load_tree
function load_tree()
{
	parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
	var index=this.document.forms[0].appl_name.options.selectedIndex;
	var index1=this.document.forms[0].facility_name.options.selectedIndex;
	var index2=this.document.forms[0].msg_type.options.selectedIndex;
	var index3=this.document.forms[0].event_type.options.selectedIndex;
  	this.document.forms[0].appdes.value=this.document.forms[0].appl_name.options[index].text;
	this.document.forms[0].facdes.value=this.document.forms[0].facility_name.options[index1].text;
	this.document.forms[0].messagedes.value=this.document.forms[0].msg_type.options[index2].text;
	this.document.forms[0].eventdes.value=this.document.forms[0].event_type.options[index3].text;
	var fields = new Array ( this.document.forms[0].appl_name,this.document.forms[0].facility_name) ;
	
	var names = new Array ( getLabel("eXH.Application.Label","XH"),
						    getLabel("eXH.Facility.Label","XH"));
	var messageFrame=parent.messageFrame;
	if(!checkFields( fields, names, messageFrame))
    {
  
    }
    else{
		
	this.document.forms[0].action='../../eXH/jsp/ReviewApplMessageMenu.jsp';
	parent.result.location.href='../../eCommon/html/blank.html';
    this.document.forms[0].mode.value='F';
	this.document.forms[0].target='header';
	this.document.forms[0].submit();
    }

}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad="setValues();" >
 <%
		 Connection con=null;
		try
			{
				con=ConnectionManager.getConnection();
			}  catch(Exception e1)
			{ 
				System.out.println("(ReviewApplMessageQuery.jsp:Exception--1) :"+e1.toString());
			 }


			/*String queryApplication="SELECT DISTINCT(A.APPLICATION_NAME) ,A.APPLICATION_ID FROM XH_APPLICATION_MESSAGE  M , XH_APPLICATION_LANG_VW A WHERE A.LANGUAGE_ID='"+locale+"' AND M.APPLICATION_ID=A.APPLICATION_ID";	*/

			String queryApplication="SELECT DISTINCT(A.APPLICATION_NAME) ,A.APPLICATION_ID FROM  XH_APPLICATION_LANG_VW A WHERE A.LANGUAGE_ID='"+locale+"'";


			String queryEvent="SELECT DISTINCT(ET.EVENT_TYPE),ET.EVENT_NAME  FROM XH_EVENT E ,XH_EVENT_TYPE_LANG_VW ET WHERE ET.LANGUAGE_ID='"+locale+"' AND E.EVENT_TYPE =ET.EVENT_TYPE and ET.MESSAGE_TYPE='"+msg_type+"'";
			
			String queryFacility="SELECT DISTINCT A.FACILITY_ID, s.facility_name  FROM 	xh_appl_for_facility a, sm_facility_param_lang_vw s  WHERE s.language_id='"+locale+"' and	a.facility_id = s.facility_id";	
			
			/*String queryFacility="SELECT DISTINCT s.FACILITY_ID, s.facility_name  FROM 	sm_facility_param_lang_vw s  WHERE s.language_id='"+locale+"'";	 */
			
			String qryMsgType = "SELECT MESSAGE_TYPE,DESCRIPTION FROM XH_MESSAGE_TYPE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' ORDER BY 2";

			String pateint_query="select patient_id_length from mp_param";
			String pat_id_length="";
			
	        ResultSet result=null;
			Statement stmt=null;
			stmt =con.createStatement();
			result=stmt.executeQuery(pateint_query);
			if (result.next() && result != null)
			{
				pat_id_length = result.getString(1);
			
			}
			if(result!=null) result.close();
 %>
<form name="application_review_msg_query_form" id="application_review_msg_query_form">
<input type='hidden' name='fmode' id='fmode' value='F'>
<input type='hidden' name='appdes' id='appdes'>
<input type='hidden' name='facdes' id='facdes'>
<input type='hidden' name='messagedes' id='messagedes'>
<input type='hidden' name='eventdes' id='eventdes'>
<input type='hidden' name='mode' id='mode' >

<table cellspacing=0 cellpadding=0 width='100%' border=0 align=center>
<tr>
	<td width='10%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
	<td width='30%'></td>
</tr>
<tr><td class=label ><fmt:message key="eXH.Application.Label" bundle="${xh_labels}"/></td>
<td align=left><select name=appl_name id=appl_name >
<option value=''>---------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>------------</option>

<%
	try
	{
		result=stmt.executeQuery(queryApplication);
		while(result.next())
		{
%>
    <option value ='<%=result.getString(2)%>'
		><%=result.getString(1)%></option>
			
<%
		}
if(result!=null)
	result.close();
%>
<select> <img src='../../eCommon/images/mandatory.gif' align=middle></td>
<%
	}catch(Exception e1)
	    {
			System.out.println("(ReviewApplMessageQuery.jsp:Exception-0) :"+e1.toString());
		}
%>
<td class=label ><fmt:message key="eXH.MessageTypeOffset.Label" bundle="${xh_labels}"/></td>
<td align=left><select name=msg_type id=msg_type onChange="onChangeMsgType();" >
<option value=''>------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>------------</option>
<%
try
{
	 result=stmt.executeQuery(qryMsgType);
	 while(result.next())
	{
%>
<option value ='<%= result.getString(1) %>'><%= result.getString(2) %></option>
   <%
			}
			       if(result!=null)result.close();
                    }
				      catch(Exception e1)
				   {
						System.out.println("(ReviewApplMessageQuery.jsp:Exception-3) :"+e1.toString());
				   }
  %>
</select>
</td></tr>

<tr><td class=label ><fmt:message key="eXH.EventType.Label" bundle="${xh_labels}"/></td>
<td align=left><select name=event_type id=event_type>
<option value=''>---------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>--------------</option>
<%
try
{
	 result=stmt.executeQuery(queryEvent);
	 while(result.next())
	{
%>
<option value ='<%= result.getString(1) %>'><%= result.getString(2) %></option>
   <%
			}
			       if(result!=null)result.close();
                    }
				      catch(Exception e1)
				   {
						System.out.println("(ReviewApplMessageQuery.jsp:Exception-1) :"+e1.toString());
				   }
  %>
 </select></td>

 
<td class=label ><fmt:message key="eXH.Facility.Label" bundle="${xh_labels}"/></td>
			<td align=left><select name ="facility_name" id="facility_name">
<option value=''>---------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>---------</option>
				<%
					  try
					{
					   result=stmt.executeQuery(queryFacility);
					   while(result.next())
					  {
				%>
					<option value='<%=result.getString(1)%>' ><%=result.getString(2)%></option>
				<%
					  }
					    if(result!=null)result.close();
				 
					 }catch(Exception e1)
							{
								System.out.println("(ReviewApplMessageQuery.jsp:Exception-2) :"+e1.toString());
							}
					finally{

		try{ 
			 if(stmt!=null)stmt.close();
	 ConnectionManager.returnConnection(con);
   }catch(Exception e)
   {
	out.println("Exception is "+e);
	}
		
		}
				%>

				<select> <img src='../../eCommon/images/mandatory.gif' align=middle></td>
	</tr>
	
<tr>
<td class=label ><fmt:message key="eXH.MessageDate.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text name =msg_date size=11> <input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('msg_date','dd/mm/y');" Onblur="javascript:checkDate()"></td>
<td class=label ><fmt:message key="eXH.MessageID.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text name =msg_id size=10></td>
</tr>
<tr>
<td class=label ><fmt:message key="eXH.Patient.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="p_patient_id1"  name =patient_id size=25 maxlength="<%=pat_id_length%>" onBlur="makeValidString(this);ChangeUpperCase(this);document.forms[0].clear.onclick();" onKeypress='return CheckForSpecChars(event);'> <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=reset id=reset value='?'    onClick="callSearchScreen2()"></td>

<td class=label ><fmt:message key="eXH.MessageStatus.Label" bundle="${xh_labels}"/></td>
<td align=left><select name=msg_status id=msg_status >
<option value=''>------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>-------</option>
<option value='A'><fmt:message key="eXH.All.Label" bundle="${xh_labels}"/></option>
<option value='P' ><fmt:message key="eXH.Pending.Label" bundle="${xh_labels}"/></option>
<option value='S'><fmt:message key="eXH.Sucessfull.Label" bundle="${xh_labels}"/></option>
<option value='C'><fmt:message key="eXH.Accepted.Label" bundle="${xh_labels}"/></option>
<option value='R'><fmt:message key="eXH.Rejected.Label" bundle="${xh_labels}"/></option></select> </td>
</tr>
<tr >
<td colspan=4 class= 'BUTTON'><input class='BUTTON' type="button"  name=search id=search value='<fmt:message key="eXH.Search.Label" bundle="${xh_labels}"/>' onClick="load_tree();"></td>
</tr>
</table>
</form>	
</BODY>
</HTML>

