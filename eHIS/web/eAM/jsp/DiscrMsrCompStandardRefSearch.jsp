<!DOCTYPE html>
<%@page  language="java" import="java.sql.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>
<script language=javascript src='../js/CAMessages.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language=javascript>
function callfunction(){
var target=parent.frames[1].document.forms[0].std_ref;
var splval= parent.frames[1].document.forms[0].std_ref.value;
var resulttype= parent.frames[1].document.forms[0].comp_type.value;

var retVal=  new String();
var dialogTop	= "40";
var dialogHeight= "10" ;
var dialogWidth= "40" ;
var features= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
var arguments	= "" ;
var search_desc	= "";
var title="StandardComp";



var sql="SELECT STD_COMP_ID code,STD_COMP_DESC description FROM AM_STANDARD_COMP where eff_status='E' and upper(STD_COMP_DESC) like upper(?) and upper(STD_COMP_ID) like upper(?) and STD_COMP_RESULT_TYPE = '"+resulttype+"' ";

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

if(parent.frames[1].document.forms[0].std_ref.value!="" ){
retArray = CommonLookup(title,argArray);
if(retArray != null && retArray !=""){
parent.frames[1].document.forms[0].std_ref.value = retArray[1];
//parent.frames[1].document.forms[0].desc.value=retArray[1];
//parent.frames[1].document.forms[0].id.disabled=false;
}//if
else
{
	parent.frames[1].document.forms[0].std_ref.value= "";
//	parent.frames[3].document.forms[0].desc.value="";
//	parent.frames[3].document.forms[0].id.disabled=false;

}
}//if
parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
}
//callfunction
</script>
</head>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		Connection con2=null;
		request.setCharacterEncoding("UTF-8");
		String stdref=request.getParameter("stdref")==null?"":request.getParameter("stdref");
		String restype=request.getParameter("restype")==null?"":request.getParameter("restype");
		
		String stdcompDesc="";
		int count=0;
		try
		{
				
				PreparedStatement pstmt2=null;
				ResultSet rset2=null;
				con2=ConnectionManager.getConnection(request);
        if (!stdref.equals("")){
						stdref=stdref+"%";
						}
			StringBuffer sql= new StringBuffer();

			sql.append("SELECT STD_COMP_ID,STD_COMP_DESC FROM  AM_STANDARD_COMP ");
			sql.append("WHERE EFF_STATUS ='E' AND "); 
            sql.append("STD_COMP_ID like UPPER(?) AND STD_COMP_RESULT_TYPE = ?");  
			

			pstmt2=con2.prepareStatement(sql.toString());
         	
            pstmt2.setString(1,stdref);
			pstmt2.setString(2,restype);
			
			
			rset2=pstmt2.executeQuery();
			
					while(rset2.next())
					{	
						
						
							//stdcompId=rset2.getString("STD_COMP_ID");
							stdcompDesc=rset2.getString("STD_COMP_DESC");
							count=count+1;
					}   
      

  if (count==1)
		{
		    out.println("<script>");
			out.println("parent.frames[1].document.forms[0].std_ref.value='"+stdcompDesc+"'");
			//out.println("parent.frames[1].document.forms[0].flagSpecialty.value='true' ");
			out.println("parent.frames[2].location.href='../../eCommon/jsp/error.jsp' ");
        	out.println("</script>");
		 } 
    if(count>1 || count==0)
		{
			%>
		<script language=javascript>
			//parent.frames[3].document.forms[0].id.disabled=true;
			callfunction();
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



        <% 

		}//if 
	if (rset2!=null) rset2.close();
	if(pstmt2!=null) pstmt2.close();
	}
	catch(Exception ex)
	{
				out.println("Exception in DiscreteStandardCompSearch.jsp"+ex.toString());
	}
	finally
	{
		if (con2!=null) ConnectionManager.returnConnection(con2,request);
	}

%>
</body>
</html>

