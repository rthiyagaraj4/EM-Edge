<!DOCTYPE html>
<%@page  language="java" import="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script language=javascript>
	
async function callfunction(){
			
			var target=parent.frames[1].document.forms[0].facility_id1;
			var retVal=  new String();
			var dialogTop	= "40";
			var dialogHeight= "10" ;
			var dialogWidth= "40" ;
			var features= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
			var arguments	= "" ;
			var search_desc	= "";
			//var title="Facility";
			var title= getLabel("Common.facility.label","Common");
			var sql="select facility_id code,facility_name description from sm_facility_param where  status='E' and upper(facility_name) like upper(?) and upper(facility_id) like upper(?)  ";
			var argArray = new Array();
			var namesArray = new Array();
			var valuesArray = new Array();
			var datatypesArray = new Array();
			argArray[0] = sql;
			argArray[1] = namesArray;
			argArray[2] = valuesArray;
			argArray[3] = datatypesArray;
			argArray[4] = "2,1";
			argArray[5] = target.value; 
			argArray[6] = DESC_LINK;
			argArray[7] = DESC_CODE;
			
			if(parent.frames[1].document.forms[0].facility_id1.value!="ALL" && parent.frames[1].document.forms[0].facility_id.value!=""){
				
				retArray =await  CommonLookup(title,argArray);
				
				var ret1=unescape(retArray);
				var arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
					arr[0]="";	
					arr[1]="";	
				}
				if(retArray != null && retArray !=""){
						parent.frames[1].document.forms[0].facility_id1.value = arr[1];
						parent.frames[1].document.forms[0].facility_id.value=arr[0];
						parent.frames[1].document.forms[0].facility_buttn.disabled=false;
					}else {
						parent.frames[1].document.forms[0].facility_id1.value="All";
						parent.frames[1].document.forms[0].facility_id.value="*A";
						parent.frames[1].document.forms[0].facility_buttn.disabled=false;
			}
		}
		
		parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
}


</script>
</head>
<body onKeyDown="lockKey()">
<%
		request.setCharacterEncoding("UTF-8");	
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		
		String search_value=request.getParameter("search_value")==null?"":request.getParameter("search_value");	
	
		 String facility_id = "";
		 String facility_name = "";
		 String sql = "";
		 int count=0;
		
		try
		{
			con=ConnectionManager.getConnection();
			if (!search_value.equals("")){
					search_value=search_value+"%";
				}
				
				sql = "select facility_id ,facility_name from sm_facility_param where  status='E' and upper(facility_name) like upper(?) ";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,search_value);
				rset=pstmt.executeQuery();

				while(rset.next())
				{	
					   facility_id=rset.getString("facility_id");
                       facility_name=rset.getString("facility_name");
					   count=count+1;
				}
		if (count==1)
		{ 
			out.println("<script>");
			out.println("parent.frames[1].document.forms[0].facility_id1.value='"+facility_name+"'");
			out.println("parent.frames[1].document.forms[0].facility_id.value='"+facility_id+"'");
			out.println("parent.frames[2].location.href='../../eCommon/jsp/error.jsp' ");
			out.println("</script>");
		}

		if(count>1 || count==0){	%>
				<script language=javascript>
				parent.frames[1].document.forms[0].facility_buttn.disabled=true;
				callfunction();
				</script>
<Script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></Script>



  <% 
		}
}
catch(Exception ex){
		//out.println("Exception in try of CAExternalApplDtlGetFacilityCode.jsp"+ex.toString());//COMMON-ICN-0181
				ex.printStackTrace();//COMMON-ICN-0181
}
finally{
		if (rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
		if (con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</body>
</html>

