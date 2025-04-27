<!DOCTYPE html>
<%--
	FileName	: addOperatorStationRstrn.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	 String oper_stn_id=request.getParameter("oper_stn_id");
	 Connection conn = null;
	 String fid=(String)session.getValue("facility_id");
%>
  <head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eAM/js/OperatorStationRstrn.js' language='javascript'></script>
	<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>
	<script>

function fetchVals(Obj)
{
	var sStyle='<%=sStyle%>';
	if(Obj.value != "")	
	{
		document.forms[0].location_button.disabled=true;
		document.forms[0].location_desc.disabled=true;
		document.forms[0].user_desc.disabled=false;
		document.forms[0].user_button.disabled=false;
		document.forms[0].user_desc.value = "";
		document.forms[0].location_desc.value = "";
		document.forms[0].user.value = "";

		var name=Obj.name;
		var value=Obj.value;
		val = value.split("::")
		value = val[0];
		val0 = val[1];
		val1 = val[2];
		var oid=Obj.value;
		var lt=document.forms[0].locationtype.value
		var fid=document.forms[0].facility.value;

		if(name == 'oprstnid')
		{
			var userlen = document.getElementById('user').length;
			for(var k=0;k<userlen;k++)
				document.getElementById('user').remove(1);

			var loctypelen = document.forms[0].locationtype.length;
			for(var h=0;h<loctypelen;h++)
				document.forms[0].locationtype.remove(1);

			var locidlen = document.getElementById("locationid").length;
			for(var h=0;h<locidlen;h++)
				document.getElementById("locationid").remove(1);

			parent.frames[1].location.href = '../../eCommon/html/blank.html'
			parent.frames[2].location.href = '../../eCommon/html/blank.html'
		}
		else if(name == 'locationtype')
		{
			var locidlen = document.getElementById("locationid").length;
			for(var h=0;h<locidlen;h++)
				document.getElementById("locationid").remove(1);
		}
   
		if(Obj.value !='' )
		{
			
			var HTMLVal = "<HTML><HEAD>		<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'>";
			HTMLVal = HTMLVal +"<form name='form1' id='form1' method='post' action='../../eAM/jsp/FetchValForOperatorStnRstrn.jsp'>";
			HTMLVal = HTMLVal +"<input name='name' id='name' type='hidden' value= '"+name + "'><input name='value' id='value' type='hidden' value='"+value +"'>";
			HTMLVal = HTMLVal +"<input name='fid' id='fid' type='hidden' value='"+fid+"'>";
			HTMLVal = HTMLVal +"<input name='oprstn' id='oprstn'  type='hidden' value='"+oid+"'>";
			HTMLVal = HTMLVal +"<input name='oper_stn_type' id='oper_stn_type'  type='hidden' value='"+val0+"'>";
			HTMLVal = HTMLVal +"<input name='locationtype' id='locationtype'  type='hidden' value='"+lt+"'>";
			HTMLVal = HTMLVal +"</form></BODY></HTML>";
			parent.parent.frames[1].frames[3].document.write(HTMLVal);
			parent.parent.frames[1].frames[3].document.form1.submit();
		}
	}		
	else
	{
		var obj1=document.forms[0].locationtype;
		var length1=obj1.length;

		var i;
		for(i=0;i<length1;i++) 
			obj1.remove(1);

		document.forms[0].user_desc.value = "";
		document.forms[0].user.value = "";
		document.forms[0].location_desc.value = "";
		document.forms[0].user_desc.disabled=true;		
		document.forms[0].user_button.disabled=true;
		document.forms[0].location_desc.disabled=true;
		document.forms[0].location_button.disabled=true;
        parent.frames[1].location.href = '../../eCommon/html/blank.html';
		parent.frames[2].location.href = '../../eCommon/html/blank.html';
	}
}

	function removeitems(obj)
	{
		var len=obj.length;
		var i=1;
		while(i<len)
		{
			len=obj.length
			obj.remove(i)
		}
	}
	
	 async function searchCode(obj,target,target_id)
		{
			
			
			
				var retVal =    new String();
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var tit=getLabel('Common.Location.label','Common');
				var facilityid =document.forms[0].facility.value;

				var temp=new Array();
				temp=document.forms[0].locationtype.value.split('#');
				
				
				sql = "Select locn_code code,locn_short_desc description from AM_LOCN_FOR_OPER_STN_VW where facility_id = '"+facilityid+"' and CARE_LOCN_TYPE='"+temp+"' and OPER_STN_ID = '"+document.forms[0].oprstnid.value+"'  and upper(locn_code) like upper(?) and upper(locn_short_desc) like upper(?) order by 2 ";


								
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = CODE_LINK ;
				argumentArray[7] = CODE_DESC ;
				retVal = await CommonLookup( tit, argumentArray );
				if (retVal !=null && retVal !="")
				{
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					target.value=arr[1];
					target_id.value=arr[0];
				}else
				{
				target.value="";
				target_id.value="";
				}
			
		
			
		} 
		
		async function searchCode1(obj,target,target_id)
		{
					
				var retVal =    new String();
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var tit=getLabel('Common.Location.label','Common');
				var facilityid =document.forms[0].facility.value;

				var temp=new Array();
				temp=document.forms[0].locationtype.value.split('#');
				
				if(obj.value !="")
				{
				
				sql = "Select locn_code code,locn_short_desc description from AM_LOCN_FOR_OPER_STN_VW where facility_id = '"+facilityid+"' and CARE_LOCN_TYPE='"+temp+"' and OPER_STN_ID = '"+document.forms[0].oprstnid.value+"'  and upper(locn_code) like upper(?) and upper(locn_short_desc) like upper(?) order by 2 ";


								
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = CODE_LINK ;
				argumentArray[7] = CODE_DESC ;
				retVal = await CommonLookup( tit, argumentArray );
				if (retVal !=null && retVal !="")
				{
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					target.value=arr[1];
					target_id.value=arr[0];
				}else
				{
				target.value="";
				target_id.value="";
				}
				}
				else
			{
					parent.frames[1].document.location.href='../../eCommon/html/blank.html';
					parent.frames[2].document.location.href='../../eCommon/html/blank.html';
					document.forms[0].location_desc.value='';
					document.forms[0].locationid.value='';
			}
		}

		async function displayUser1(obj,target,target_id)
				{


				var retVal =    new String();
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var tit=getLabel('Common.user.label','Common');

				if(obj.value !="")
					{
				
				
				//sql = "select appl_user_id  code,appl_user_name description  from sm_facility_for_user_vw where facility_id = '"+document.forms[0].facility.value+"' and appl_user_id like upper(?) and upper(appl_user_name) like upper(?) order by 2";
				sql = "select a.appl_user_id  code,a.appl_user_name description  from sm_facility_for_user_vw a, AM_USER_FOR_OPER_STN b where a.facility_id = '"+document.forms[0].facility.value+"' and a.appl_user_id like upper(?) and upper(a.appl_user_name) like upper(?) and a.facility_id=b.facility_id and a.appl_user_id=b.appl_user_id and b.oper_stn_id='"+document.forms[0].oprstnid.value+"' order by 2";


								
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = CODE_LINK ;
				argumentArray[7] = CODE_DESC ;
				retVal = await CommonLookup( tit, argumentArray );
				if (retVal !=null && retVal !="")
				{
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					target.value=arr[1];
					target_id.value=arr[0];
				}else
				{
				target.value="";
				target_id.value="";
				}
					}
					else
					{
					parent.frames[1].document.location.href='../../eCommon/html/blank.html';
					parent.frames[2].document.location.href='../../eCommon/html/blank.html';
					document.forms[0].user_desc.value='';
					document.forms[0].user.value='';
					}
				}


		async function displayUser(obj,target,target_id)
				{


				var retVal =    new String();
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var tit=getLabel('Common.user.label','Common');


				
				
				//sql = "select appl_user_id  code,appl_user_name description  from sm_facility_for_user_vw where facility_id = '"+document.forms[0].facility.value+"' and appl_user_id like upper(?) and upper(appl_user_name) like upper(?) order by 2";
				sql = "select a.appl_user_id  code,a.appl_user_name description  from sm_facility_for_user_vw a, AM_USER_FOR_OPER_STN b where a.facility_id = '"+document.forms[0].facility.value+"' and a.appl_user_id like upper(?) and upper(a.appl_user_name) like upper(?) and a.facility_id=b.facility_id and a.appl_user_id=b.appl_user_id and b.oper_stn_id='"+document.forms[0].oprstnid.value+"' order by 2";
				


								
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = CODE_LINK ;
				argumentArray[7] = CODE_DESC ;
				retVal = await CommonLookup( tit, argumentArray );
				if (retVal !=null && retVal !="")
				{
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					target.value=arr[1];
					target_id.value=arr[0];
				}else
				{
				target.value="";
				target_id.value="";
				}

				}
				

		function callResultFrame(Obj)
		{
			if(chkMandatory())
			{
				var locationtype=new Array();
				locationtype=document.forms[0].locationtype.value.split('#');
				var url='../../eAM/jsp/OperatorStationRstrntabs.jsp?mode=insert&locationtype='+document.forms[0].locationtype.value+'&oper_stn_type='+Obj.value+'&oper_stn_id='+document.forms[0].oprstnid.value+'&user='+document.forms[0].user.value+'&locationid='+document.forms[0].locationid.value+'&locncode1='+document.forms[0].locationid.value+'&facility_id='+document.forms[0].facility.value;

				parent.frames[1].location.href = '../../eAM/jsp/OperatorStationRstrntabs.jsp?mode=insert&locationtype='+document.forms[0].locationtype.value+'&oper_stn_type='+Obj.value+'&oper_stn_id='+document.forms[0].oprstnid.value+'&user='+document.forms[0].user.value+'&locationid='+document.forms[0].locationid.value+'&locncode1='+document.forms[0].locationid.value+'&facility_id='+document.forms[0].facility.value;
				parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_val='
			}
			else{
                parent.frames[1].location.href ='../../eCommon/html/blank.html';
                parent.frames[2].location.href ='../../eCommon/html/blank.html';
			}
		}
		
function clearValues(Obj)
{

	document.forms[0].location_desc.value='';
	document.forms[0].locationid.value='';
	if(Obj.value !=''){
		document.forms[0].location_button.disabled=false;
		document.forms[0].location_desc.disabled=false;
	}
	else{
		document.forms[0].location_desc.disabled=true;
		document.forms[0].location_button.disabled=true;
		}

	parent.frames[1].document.location.href='../../eCommon/html/blank.html';
	parent.frames[2].document.location.href='../../eCommon/html/blank.html';

}

function second1(Obj)
{
	parent.frames[1].document.location.href='../../eCommon/html/blank.html';
	parent.frames[2].document.location.href='../../eCommon/html/blank.html';
	var str1=Obj.value;
	document.forms[0].str1.value=str1;
	var obj1=document.forms[0].oprstnid;
	var obj2=document.forms[0].locationtype;
	var length1=obj1.length;
	var length2=obj2.length;
	var i;var j;
	for(i=0;i<length1;i++) 
		obj1.remove(1);
	for(j=0;j<length2;j++) 
		obj2.remove(1);	
	
	document.forms[0].user_desc.disabled=true;
	document.forms[0].user_button.disabled=true;
    document.forms[0].location_desc.disabled=true;
	document.forms[0].location_button.disabled=true;
	document.forms[0].user_desc.value='';
	document.forms[0].location_desc.value='';
		
	
	if(Obj.value !=''){	
		var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='practform12' id='practform12' method='post' action='../../eAM/jsp/FetchValForOperatorStnRstrn.jsp'> <input type='hidden' name='facid' id='facid' value='"+str1+"'>	</form></body></html>";	
		parent.parent.frames[1].frames[2].document.write(HTMLVal);
		parent.parent.frames[1].frames[2].document.practform12.submit();  
	}
	
	
}
   </script>
   </head>

 	<body OnMouseDown="CodeArrest()" onLoad="FocusFirstElement(); "  onKeyDown = 'lockKey()'>

      <%
		 String facName = request.getParameter("facName");
		 if(facName == null) facName="";

		 String facilityid=(String)session.getValue("facility_id");
		 String facility_id2 = request.getParameter("facility_id");

		String operstntype = request.getParameter("oper_stn_type")==null?"B":request.getParameter("oper_stn_type");

   	 	 String rule="";
		 String operationtype = "insert";
   	 	 
		 String operstnshortdesc ="";
		 String appluserid = "";
		 String applusername ="";
		 String locncode ="";
		 String locnshortdesc ="";
		 String locntype = "";
		 String locntypedesc = "";
		 
		 ResultSet rs= null;
		 ResultSet prs = null;

		 ResultSet rset=null;
		 Statement stmt = null;
		 PreparedStatement pstmt = null;

try{
	conn = ConnectionManager.getConnection(request);
	stmt=conn.createStatement();
	Properties p=(Properties)session.getValue("jdbc");
	String userId=p.getProperty( "login_user" ) ;
	
	operationtype = request.getParameter("operationtype");
	String facid="";
			 
	if(operationtype == null ) operationtype ="insert";
	if(oper_stn_id == null){
		oper_stn_id="";
		

		rs=stmt.executeQuery(" Select  OPER_STN_ACCESS_RULE from op_param where operating_facility_id = '"+fid+"'");
		if(rs.next())
			rule=rs.getString(1)==null?"":rs.getString(1);
		}else{
		operationtype = "modify";
		operstnshortdesc = request.getParameter("oper_stn_desc")==null?"":request.getParameter("oper_stn_desc");
		appluserid  = request.getParameter("user")==null?"":request.getParameter("user");
		applusername  = request.getParameter("applusername1")==null?"":request.getParameter("applusername1");
		locncode = request.getParameter("locncode1")==null?"":request.getParameter("locncode1");
		locnshortdesc = request.getParameter("locnshortdesc1")==null?"":request.getParameter("locnshortdesc1");
		locntype = request.getParameter("location_type")==null?"":request.getParameter("location_type");
		locntypedesc = request.getParameter("location_type_desc")==null?"":request.getParameter("location_type_desc");

		

		String facility_id1 = request.getParameter("facilityid");
			 if(facility_id1 == null )facility_id1 ="";	
			 
		
		
	}
	 
%>
<form name='opstnrstrn_form' id='opstnrstrn_form'  action='../../servlet/eAM.OperatorStationRstrnServlet'  method='post' target='messageFrame'>

<table border='0' cellpadding='0' cellspacing='0' width='95%' height='auto' align='center'>
		<tr>
		<td  nowrap class='label'><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></td>
		<td colspan=3 class='fields'>&nbsp;
		<% if(operationtype.equals("modify")) { %>
		<input type='text' name='facility_desc' id='facility_desc' size='70' value="<%=facName%>" maxlength='35' readOnly><input type='hidden' name='facility' id='facility' value="<%=facility_id2%>">		
		<% } else { %>		
		&nbsp;<select name='facility' id='facility' nowrap onChange="second1(this)" ><option >--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------</option>
	       <%
			String ID1="",dat1="",en1="";
		    if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();

			stmt=conn.createStatement();
			rset=stmt.executeQuery("Select Facility_id,Facility_name Operating_facility_id from SM_FACILITY_FOR_USER_VW where appl_user_id = '"+userId+"' and  NVL(access_eff_date_to,TO_DATE('31/12/9999','dd/mm/rrrr')) >= TRUNC(SYSDATE) order by facility_name ");
			if(rset!=null)
			{
			   while(rset.next())
			   {
				dat1=rset.getString("Operating_facility_id");
				ID1=rset.getString("facility_id");
				if(ID1.equals(facilityid))
				   {
					
				   }
					else
					   en1="";
				out.println("<option value=\""+ID1+ "\" "+en1+">"+dat1+"</option>");
			   }
			   } 
			   %>		
		</select>&nbsp;<img align=center src='../../eCommon/images/mandatory.gif' align='center'></img>
		<% } %></td>
		</tr>

		<tr>
		<td  nowrap class='label'><fmt:message key="Common.operatorstation.label" bundle="${common_labels}"/></td>
      	
<%
	if(operationtype.equals("modify"))
	{	%>
		<td class='fields' nowrap>&nbsp;
			<input type ='textbox' value="<%=operstnshortdesc%>" readonly maxsize='30' size ='30'>
			<input name='oprstnid' id='oprstnid' type ='hidden' value="<%=oper_stn_id%>" readonly maxsize='30' size ='30'>
		</td>
<%	}
	else
	{	
		facid= request.getParameter("str1");
		if(facid == null) facid="";
%>      <td nowrap class='fields'>&nbsp;&nbsp;
				<select name="oprstnid" id="oprstnid" onChange="fetchVals(this)">
				<option value="">---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------- </option>
 <%
                if(rset!=null)rset.close();
                if(stmt!=null)stmt.close(); 
			
                pstmt = conn.prepareStatement("SELECT oper_stn_id,short_desc  from  am_oper_stn where  facility_id = '' and eff_status= 'E' order by short_desc ");
				prs = pstmt.executeQuery();

				if(prs != null)
				{	
					while(prs.next())
					{
						out.println("<option value='"+prs.getString(1)+"'>"+prs.getString(2)+"</option>");

					}
				} 
%>
			</select>&nbsp<img align=center src='../../eCommon/images/mandatory.gif' align='center'></img> 
      		</td>
<%
	}
	 
	 if(operationtype.equals("modify"))
	{
%>

			<td nowrap  class='label'><fmt:message key="Common.user.label" bundle="${common_labels}"/></td>
			<td nowrap class='fields'>&nbsp;<input type ='textbox' value="<%=applusername%>" readonly maxsize='30' size ='30'><input name="user" id="user" type ='hidden' value="<%=appluserid%>" readonly maxsize='30' size ='30'></td>
<%	
	}
	else
	{	
%>
      		<td nowrap  class='label'><fmt:message key="Common.user.label" bundle="${common_labels}"/></td>
      		<td nowrap class='fields'>&nbsp;<input type=text  name='user_desc' id='user_desc' onblur='displayUser1(this, user_desc,user)' size="30" maxlength="30" disabled><input type='button' name='user_button' id='user_button' value='?'  disabled class='button' onclick='displayUser(this, user_desc,user)'>
		   <input type='hidden' name='user' id='user' value=''><img align=center src='../../eCommon/images/mandatory.gif' align='center'></img> </td>
      	</tr>
<%
	}
	if(operationtype.equals("modify"))
	{
%>
	<tr>
		<td  nowrap  class='label'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;
		<input type ='textbox' value="<%=locntypedesc%>" readonly maxsize='30' size ='30'>
		<input name='locationtype' id='locationtype' type ='hidden' value='<%=locntype%>' readonly maxsize='30' size ='30'>
		</td>
<%	}
	else
	{	%>	
	<tr>
		<td nowrap  class='label'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>
		</td>
		<td class='fields' >&nbsp;&nbsp;
			<select name='locationtype' id='locationtype' onChange='clearValues(this)'>
			<OPTION  value=''>---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------- </OPTION>	
		</SELECT>&nbsp;<img align=center src='../../eCommon/images/mandatory.gif' align='center'></img>
		</td>
<%	}
	
	if(operationtype.equals("modify"))
	{	%>
		<td nowrap  class='label'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td nowrap class='fields'>&nbsp;<input type ='textbox' value="<%=locnshortdesc%>" readonly maxsize='15' size ='15'><input name='locationid' id='locationid' type ='hidden' value="<%=locncode%>" readonly maxsize='30' size ='30'></td>
<%	}
	else
	{	%>      	
		<td nowrap  class='label'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td><td nowrap class='fields'>&nbsp;<input type=text  name='location_desc' id='location_desc' onblur='searchCode1(this, location_desc,locationid)' size="15" maxlength="15" disabled><input type='button' disabled name='location_button' id='location_button' value='?' class='button' onclick='searchCode(this, location_desc,locationid)'><input type='hidden' name='locationid' id='locationid' value=''>&nbsp;<img align=center src='../../eCommon/images/mandatory.gif' align='center'></img></td>
  	</tr>
 <%	}	%>
<%  if(!operationtype.equals("modify")) { %>
	<tr>
	<td colspan='4' align='right'><input type='button' class='button' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='callResultFrame(operation_stn_type)' ></td>
	</tr>
	<% } %>
	<%	if(rule.equals("W")) {
%>
		<tr>
      	    <td nowrap>&nbsp;</td>
      		<td nowrap  class='label'><fmt:message key="Common.WorkStation.label" bundle="${common_labels}"/>	</td>
      		<td nowrap class='fields'>&nbsp;&nbsp;&nbsp;<input type="text" name="ws_no" id="ws_no" size=10 maxlength=10>&nbsp;<img align=center src='../../eCommon/images/mandatory.gif' align='center'></img></td>
      		<td>&nbsp;</td>
      	</tr>
<%
		 }			
		
%>
	
<%		out.println("</table>	");
%>
		<input type='hidden' name='function_name' id='function_name' value="<%=operationtype%>">
		<input type="hidden" name="operation_type" id="operation_type" value="<%=operationtype%>">

		<input type='hidden' name='oprstn' id='oprstn' value=''>
		<input type='hidden' name='oper_stn_desc' id='oper_stn_desc' value=''>
		<input type='hidden' name='oper_stn_type' id='oper_stn_type' value=''>
		<input type='hidden' name='rule' id='rule' value="<%=rule%>">
		<input type='hidden' name='operation_stn_type' id='operation_stn_type' value=''>
		<input type="hidden" name="str1" id="str1" value=''>
		<input type='hidden' name='operstntype' id='operstntype' value='<%=operstntype%>'>
		
<%

		
	}//E.O.try
       catch(Exception e){
//		out.println(e);
		e.printStackTrace();
	}
	finally
	{
		try
		{
		if (rs != null)   rs.close();
		if (rset!= null)  rset.close();
		if (prs!= null)   prs.close();
		if (stmt != null) stmt.close();
		if (pstmt != null) pstmt.close();
		}
		catch(Exception e)
		{}
		ConnectionManager.returnConnection(conn,request);
	}
%>
</form>
</body>
</html>

