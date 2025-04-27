<!DOCTYPE html>
<%@page  language="java" import="java.sql.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<script language=javascript src='../js/CAMessages.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language=javascript>
function callfunction(){
var target=parent.frames[3].document.forms[0].panel_id.value;
var splval= parent.frames[3].document.forms[0].panel_id.value;
var service= parent.frames[1].document.forms[0].service.value;

var retVal=  new String();
var dialogTop	= "40";
var dialogHeight= "10" ;
var dialogWidth= "40" ;
var features= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
var arguments	= "" ;

var title="Panel ID";

//var sql="SELECT discr_msr_id code, short_desc description from am_discr_msr where eff_status='E' and upper(short_desc) like upper(?) and upper(discr_msr_id) like ? ";

var sql="SELECT discr_msr_id code, short_desc description from am_discr_msr where eff_status='E'";

sql=sql+"and upper(discr_msr_id) like upper(?) and upper(short_desc) like upper(?) ";
       

var argArray = new Array();
var namesArray = new Array();
var valuesArray = new Array();
var datatypesArray = new Array();
argArray[0] = sql;

argArray[1] = namesArray;
argArray[2] = valuesArray;
argArray[3] = datatypesArray;
argArray[4] = "1,2";
argArray[5] = target;
argArray[6] = DESC_LINK;
argArray[7] = DESC_CODE;

	
if(parent.frames[3].document.forms[0].panel_id.value!="" )
	{

retArray = CommonLookup(title,argArray);
if(retArray != null && retArray !=""){
	
parent.frames[3].document.forms[0].panel_id.value = retArray[0];
parent.frames[3].document.forms[0].desc.value=retArray[1];
parent.frames[3].document.forms[0].id.disabled=false;
}//if
else
{
	parent.frames[3].document.forms[0].panel_id.value= "";
	parent.frames[3].document.forms[0].desc.value="";
	parent.frames[3].document.forms[0].id.disabled=false;

}
}//if
parent.frames[4].location.href='../../eCommon/jsp/error.jsp';
}
//callfunction
</script>
</head>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		request.setCharacterEncoding("UTF-8");
		Connection con=null;
		
		String discrete=request.getParameter("discrete")==null?"":request.getParameter("discrete");	
		//out.println("Speci="+speci);

		String discreteId="";
		String discreteDesc="";
		int count=0;
		try
		{
				
				PreparedStatement pstmt=null;
				ResultSet rset=null;
				con=ConnectionManager.getConnection(request);
        if (!discrete.equals("")){
						discrete=discrete+"%";
						}
			StringBuffer sql= new StringBuffer();
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("select discr_msr_id,SHORT_DESC from "); sql.append("am_discr_msr where EFF_STATUS ='E' AND "); sql.append("upper(discr_msr_id) like upper(?)");  
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,discrete);
			rset=pstmt.executeQuery();
					while(rset.next())
					{	
							discreteId=rset.getString("discr_msr_id");
							discreteDesc=rset.getString("SHORT_DESC");
					  	    count=count+1;
					}   
      

  if (count==1)
		{
		      out.println("<script>");
			out.println("parent.frames[3].document.forms[0].panel_id.value='"+discreteId+"'");
			out.println("parent.frames[3].document.forms[0].desc.value='"+discreteDesc+"'");
			//out.println("parent.frames[1].document.forms[0].flagSpecialty.value='true' ");
			out.println("parent.frames[4].location.href='../../eCommon/jsp/error.jsp' ");

		out.println("</script>");
		 } 
    if(count>1 || count==0)
		{
			%>
		<script language=javascript>
			parent.frames[3].document.forms[0].id.disabled=true;
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
				out.println("Exception in DiscretePanelSearch.jsp"+ex.toString());
	}
	finally
	{
		if (con!=null) ConnectionManager.returnConnection(con,request);
	}

%>
</body>
</html>

