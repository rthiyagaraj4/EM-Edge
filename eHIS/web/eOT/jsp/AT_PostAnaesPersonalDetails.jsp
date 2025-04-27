<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");	%>
<html>
<head>
<%

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eOT/js/AT_PostAnaesthesia.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>

	<script language="javascript">
	var code=new String();
	function sendparams(index)
	{
		var rows = parent.parent.parent.ObjectCollect.personnel_rows[index]; 
		var	pract_type=rows.pract_type;
		var	desc_userdef=rows.desc_userdef;
		var	practitioner_id=rows.practitioner_id;
		var	practitioner_name=rows.practitioner_name;
		var	recId = rows.recId;			   
		var mode = "U";
		var str =  pract_type+"::"+desc_userdef+"::"+practitioner_id+"::"+practitioner_name+'::'+recId+'::'+mode;
		var frmObj = parent.frames[0];
		frmObj.splitString(str);
	}

	function createTable()
	{    
		 var rows = parent.parent.parent.ObjectCollect.personnel_rows;
 		 var obj=document.getElementById("test");
		 var tab_data="";
		 var qryVal="";
		 var 	Role	=getLabel("Common.Role.label","Common");
		 var	Name	=getLabel("Common.name.label","Common");
		 var	Position =getLabel("Common.Position.label","Common");
		 tab_data="<table border='1' cellpadding=3='3' cellspacing='0' width='100%'>"
		 tab_data+="<td class='ColumnHeader'	>"+Role+"</td>";
		 tab_data+="<td class='ColumnHeader'	>"+Name+"</td>";
		 tab_data+="<td class='ColumnHeader'    >"+Position+"</td>";
		 if(rows!=null && rows.length>0 ){
			for(var jj=0;jj<rows.length ;jj++){
			 if(rows[jj]!=null && rows[jj].db_mode!='D'){
			    code+=rows[jj].practitioner_id+","; 
			    qryVal =(jj%2==0)?"griddata":"gridData";
			    tab_data+="<tr><td class="+qryVal+">";
			    <% if("Y".equals(request.getParameter("postop_done_yn"))) {%>
					tab_data+=rows[jj].desc_userdef+"</td>";
			    <%}else{%>
					tab_data+="<a href=\"javascript:sendparams("+jj+");\">"+rows[jj].desc_userdef+"</a></td>";
				<%}%>
				tab_data+="<td class="+qryVal+">"+rows[jj].practitioner_name+"</td>";
				tab_data+="<td class="+qryVal+">"+rows[jj].position_desc+"</td>";
				tab_data+="</tr>"; 
			  }
			 }//end of for Loop
		  }// end if 
			
			tab_data+="</table>";
		  document.getElementById("test").innerHTML = tab_data;
		  document.getElementById("test").style.visibility="visible";
		  parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num= ';//not req.
	}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onLoad="createTable();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<div id="test"></div>
<form name="PostAnaesPersonnelDetails" id="PostAnaesPersonnelDetails" >
</form>
</body>
</html>

