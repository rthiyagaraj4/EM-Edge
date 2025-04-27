<!DOCTYPE html>
<%@page  language="java" import="java.sql.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
request.setCharacterEncoding("UTF-8");
String facility_id ="";
facility_id = (String)session.getValue("facility_id");
%>
<html>
<head>
<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
<script language=javascript src='../../eCommon/js/ValidateControl.js'></script>
<script language=javascript>
function callfunction(){
	var target=parent.frames[1].frames[0].document.forms[0].pctr;
	var practval= parent.frames[1].frames[0].document.forms[0].pctr.value;
	var speciality= parent.frames[1].frames[0].document.forms[0].spl.value;
	var p_facility_id="<%=facility_id%>";
	var dialogTop	= "40";
	var dialogHeight= "10" ;
	var dialogWidth= "40" ;
	var features= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments	= "" ;
	var search_desc	= "";
	var sql="";
	var title=getLabel("Common.practitioner.label","COMMON");

	if(parent.frames[1].frames[0].document.forms[0].spl.value!=""){
		sql ="select b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where b.practitioner_id= a.func_role_id and b.operating_facility_id ='"+p_facility_id+"' and b.primary_speciality_code='"+speciality+"' and upper(b.practitioner_name) like upper(?) and b.practitioner_id like ? ";
	}
	if(!(parent.frames[1].frames[0].document.forms[0].spl.value))
		{
		  sql ="select b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where b.practitioner_id= a.func_role_id and b.operating_facility_id ='"+p_facility_id+"' and upper(b.practitioner_name) like upper(?) and b.practitioner_id like ? ";  
		}
		
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = DESC_CODE;

if(parent.frames[1].frames[0].document.forms[0].pctr.value !=""){
		var retArray = CommonLookup(title,argArray);
		if(retArray != null && retArray !=""){
			parent.frames[1].frames[0].document.forms[0].pctr.value = retArray[1];
			parent.frames[1].frames[0].document.forms[0].practitioner_id.value=retArray[0];
			parent.frames[1].frames[0].document.forms[0].searchpctr.disabled=false;
			PopulateName(retArray[0]);
		}
		else
		{
               parent.frames[1].frames[0].document.forms[0].pctr.value="";
			   parent.frames[1].frames[0].document.forms[0].practitioner_id.value="";
			   parent.frames[1].frames[0].document.forms[0].searchpctr.disabled=false;
			   parent.frames[1].frames[1].location.href="../../eCA/jsp/LocationForPractList.jsp";
		}
	}
	
parent.frames[2].location.href='../../eCommon/jsp/error.jsp';

}// callfunction
function PopulateName(obj)
{
	var speciality = parent.frames[1].frames[0].document.forms[0].spl.value;
var practitioner_id=obj;


parent.frames[1].frames[1].location.href="../../eCA/jsp/LocationForPractList.jsp?practitioner_id="+practitioner_id.toUpperCase()+"&speciality_id="+speciality;

parent.frames[1].frames[2].location.href="../../eCA/jsp/LocationForPractDetail.jsp?practitioner_id="+practitioner_id.toUpperCase()+"&speciality_id="+speciality;
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String pract=request.getParameter("pract")==null?"":request.getParameter("pract");	
		String practId="";
		String practDesc="";
		
		int count=0;
		try
		{
				con=ConnectionManager.getConnection(request);
					if (!pract.equals("")){
						pract=pract+"%";
						}
        String sql="select  PRACTITIONER_ID,PRACTITIONER_NAME from AM_PRACTITIONER where EFF_STATUS ='E'  AND upper(PRACTITIONER_NAME) like upper(?)";  
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,pract);
					rset=pstmt.executeQuery();
					while(rset.next())
					{	
					   
					  practId=""; practId=rset.getString("PRACTITIONER_ID");
                       practDesc="";
                       practDesc=rset.getString("PRACTITIONER_NAME");
					   count=count+1;
					}
				 
        if (count==1)
			{
				out.println("<script>");
			    
				out.println("parent.frames[1].Header.document.forms[0].pctr.value='"+practDesc+"'");
				out.println("parent.frames[1].Header.document.forms[0].practitioner_id.value='"+practId+"'");
				
				out.println("parent.frames[1].frames[2].document.forms[0].practitioner_id.value='"+practId+"'");
				out.println("</script>");
				%>
<script>
var speciality = parent.frames[1].frames[0].document.forms[0].spl.value;
var practitioner_id=parent.frames[1].frames[0].document.forms[0].practitioner_id.value;
parent.frames[1].frames[1].location.href="../../eCA/jsp/LocationForPractList.jsp?practitioner_id="+practitioner_id.toUpperCase()+"&speciality_id="+speciality;
parent.frames[1].frames[2].location.href="../../eCA/jsp/LocationForPractDetail.jsp?practitioner_id="+practitioner_id.toUpperCase()+"&speciality_id="+speciality;
</script>
<%
out.println("<script>");   
out.println("parent.frames[2].location.href='../../eCommon/jsp/error.jsp' ");
out.println("</script>");
	}
		if(count > 1 || count ==0){
	
	out.println("<script>");
	out.println("parent.frames[1].frames[2].document.forms[0].practitioner_id.value='"+practId+"'");
	out.println("</script>");
			%>
		<script>
			parent.frames[1].frames[0].document.forms[0].searchpctr.disabled=true;
			callfunction();
		</script>
        <% 
			
     	}//if
			if (rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
		}catch(Exception ex)
			{
				//out.println("Exception="+ex.getMessage());//COMMON-ICN-0181
				ex.printStackTrace();//COMMON-ICN-0181
			}
		finally{
					
					if (con!=null) ConnectionManager.returnConnection(con,request);
			   }
%>
</body>
</html>

