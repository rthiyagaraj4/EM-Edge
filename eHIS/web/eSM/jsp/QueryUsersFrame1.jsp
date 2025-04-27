<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
		<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		 request.setCharacterEncoding("UTF-8");
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		<script>
		function populate_frame2(obj)
		{
			var user_id = obj;
			parent.frames[1].location.href='../../eSM/jsp/QueryUsersFrame2.jsp?user_id='+user_id;
		}

		function GetLookupBlur(target)
			{
			
				if(target.value != "")
				{
					GetLookup(target);
				}
				/*else
				{
					target_id.value="";
				}*/
			}

		async	function GetLookup(target){
	
			var sql="";
			
			var retVal			= new String();
			var argumentArray	= new Array() ;
			var dataNameArray	= new Array() ;
			var dataValueArray	= new Array() ;
			var dataTypeArray	= new Array() ;			
			var tit				= getLabel("Common.user.label",'Common');

			sql="select Appl_User_Id code,Appl_User_Name description from Sm_Appl_User where  eff_status='E' and upper(Appl_User_Id) like upper(?) and upper(Appl_User_Name)  like upper(?) order by upper(Appl_User_Name)";
			

			argumentArray[0]	= sql;
			argumentArray[1]	= dataNameArray ;
			argumentArray[2]	= dataValueArray ;
			argumentArray[3]	= dataTypeArray ;
			argumentArray[4]	= "1,2";
			argumentArray[5]	=target.value;
			argumentArray[6]	= DESC_LINK;
			argumentArray[7]	= DESC_CODE;

			retVal = await CommonLookup( tit, argumentArray );

			if(retVal != null && retVal != "" )
			{
				var ret1=unescape(retVal);
				arr=ret1.split(",");
				target.value=arr[1];
				//target_id.value=arr[0];
				populate_frame2(arr[0])
				
			}
			else
			{
				target.value="";
				//target_id.value="";
			}
	
}

		</script>
		<%
			Connection con=null;
			try{
			con = ConnectionManager.getConnection(request);
		%>
	</head>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'; onload='FocusFirstElement()'>
	<form name='form1' id='form1'>
		<table border=0 cellspacing=0 cellpadding=0 align=center width='102%'>
			<tr>
				<td class=label width='40%' ><fmt:message key="Common.user.label" bundle="${common_labels}"/></td>
				<td class='fields'  width='50%'>
				<input type='text' name='user_id' id='user_id' size=25 onblur='GetLookupBlur(user_id)'>
				<input type=button class=button name='user_lookup' id='user_lookup' value='?' onClick='GetLookup(user_id)'>

					</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>
		</table>
	</form>
</body>
<%
}catch(Exception e){out.println(e);}
			finally { 
		ConnectionManager.returnConnection(con,request);
}
							
%>
</html>

