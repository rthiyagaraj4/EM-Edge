<!DOCTYPE html>
<%@page  language="java" import="java.sql.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language=javascript>
async function callfunction(){
var target=parent.frames[1].document.forms[0].speciality;
var splval= parent.frames[1].document.forms[0].speciality.value;
var retVal=  new String();
var dialogTop	= "40";
var dialogHeight= "10" ;
var dialogWidth= "40" ;
var features= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
var arguments	= "" ;
var search_desc	= "";
var title="Speciality";

var sql="SELECT speciality_code code, short_desc description from am_speciality where eff_status='E' and upper(short_desc) like upper(?) and upper(speciality_code) like ?";

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
if(parent.frames[1].document.forms[0].speciality.value!="ALL" && parent.frames[1].document.forms[0].speciality.value!="All"){
retArray = await CommonLookup(title,argArray);
//alert('37 in AssignChartSummSearchCriteria.jsp retArray='+retArray);
var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
if(retArray != null && retArray !=""){
parent.frames[1].document.forms[0].speciality.value = arr[1];
parent.frames[1].document.forms[0].spl.value=arr[0];
parent.frames[1].document.forms[0].searchspl.disabled=false;
}//if
else
{
	parent.frames[1].document.forms[0].speciality.value= "All";
	parent.frames[1].document.forms[0].spl.value="*ALL";
	parent.frames[1].document.forms[0].searchspl.disabled=false;

}
}//if
parent.frames[3].location.href='../../eCommon/jsp/error.jsp';
}//callfunction
</script>
</head>
<% 	request.setCharacterEncoding("UTF-8");	%>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		Connection con=null;
		
		String speci=request.getParameter("speci")==null?"":request.getParameter("speci");	
		//out.println("Speci="+speci);
		String splId="";
		String splDesc="";
		int count=0;
		try
		{
				
				PreparedStatement pstmt=null;
				ResultSet rset=null;
				con=ConnectionManager.getConnection(request);
        if (!speci.equals("")){
						speci=speci+"%";
						}
			StringBuffer sql= new StringBuffer();
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("select SPECIALITY_CODE,SHORT_DESC from "); sql.append("AM_SPECIALITY where EFF_STATUS ='E' AND "); sql.append("upper(SHORT_DESC) like upper(?)");  
      pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,speci);
			rset=pstmt.executeQuery();
					while(rset.next())
					{	
							splId=rset.getString("SPECIALITY_CODE");
							splDesc=rset.getString("SHORT_DESC");
							   count=count+1;
					}   
      
//out.println("Tab Count="+count);
  if (count==1)
		{
		      out.println("<script>");
			out.println("parent.frames[1].document.forms[0].speciality.value='"+splDesc+"'");
			out.println("parent.frames[1].document.forms[0].spl.value='"+splId+"'");
			out.println("parent.frames[1].document.forms[0].flagSpecialty.value='true' ");
			out.println("parent.frames[3].location.href='../../eCommon/jsp/error.jsp' ");

		out.println("</script>");
		 } 
    if(count>1 || count==0)
		{
			%>
		<script language=javascript>
			//parent.frames[1].document.forms[0].searchspl.disabled=true;
			parent.frames[1].document.forms[0].flagSpecialty.value='true';
			callfunction();
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



        <% 

		}//if 
	if (rset!=null) rset.close();
	if(pstmt!=null) pstmt.close();
	}
	catch(Exception ex)
	{
				//out.println("Exception in AssignChartSummSearchCriteria.jsp"+ex.toString());//COMMON-ICN-0181
				ex.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if (con!=null) ConnectionManager.returnConnection(con,request);
	}

%>
</body>
</html>

