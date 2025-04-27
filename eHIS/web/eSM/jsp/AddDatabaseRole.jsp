<!DOCTYPE html>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
       String sStyle	=
      (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 %>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%@ page import= "java.util.*,java.sql.*,java.text.*,java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
    request.setCharacterEncoding("UTF-8");
	Connection con=null;
	PreparedStatement pstmt = null;
	try{
	con = ConnectionManager.getConnection(request);
	
	ResultSet rs=null;
	String ora_type = "";
	String ora_id	= "";
	StringBuffer totVal	= new StringBuffer();	
	String totVal1	= "";
	String ora_type1 = "";
	String ora_id1	= "";
	int i = 1;
%>

<HTML>
<HEAD>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/OraRole.js'></script>
<TITLE><fmt:message key="eSM.DatabaseRoles.label" bundle="${sm_labels}"/></TITLE>
<SCRIPT LANGUAGE="JavaScript">
	parent.frames[0].document.forms[0].reset.disabled=true;


var bol = 0;
var temp="";


function ValidPw(Obj1,Obj)
{	enable=Obj1.name

	 if(enable=="enab1")
	{
			if(document.forms[0].enab1.checked)
			{
			document.forms[0].enab2.disabled=true
			document.forms[0].enab3.disabled=true
			}else
			{
         
			document.forms[0].enab2.disabled=false
			document.forms[0].enab3.disabled=false

			}
	}

 if(enable=="enab2")
	{
	 if(document.forms[0].enab2.checked)
	{
	document.forms[0].enab1.disabled=true
	document.forms[0].enab3.disabled=true
	}else
	{
		 
		document.forms[0].enab1.disabled=false
		document.forms[0].enab3.disabled=false
	}
	}
	 if(enable=="enab3")
	{
	if(document.forms[0].enab3.checked)
	{
	document.forms[0].enab1.disabled=true
	document.forms[0].enab2.disabled=true
	}else
	{ 
		document.forms[0].enab1.disabled=false
		document.forms[0].enab2.disabled=false
	}
	}
	
	
	if((document.forms[0].enab1.checked)||(document.forms[0].enab2.checked)||(document.forms[0].enab3.checked))
	{
        document.forms[0].ObjVal.value=Obj.value;
	    parent.frames[1].document.forms[0].action="../../eSM/jsp/change_role_passwd.jsp";
		parent.frames[1].document.forms[0].target="result";
		parent.frames[1].document.forms[0].submit();
	}
else
	{

	parent.frames[2].location.href ="../../eCommon/html/blank.html";
	}
}


</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>

<BODY OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' >
<FORM name='AddDatabaseRole_form' id='AddDatabaseRole_form' METHOD=POST ACTION="../../servlet/eSM.DatabaseRoleServlet" target='messageFrame'>


<BR><BR><BR>

<TABLE border = '0' cellpadding='0' cellspacing='0' width='80%' ALIGN='CENTER'>
<TR><TD colspan='4' width="25%">&nbsp;<TD><td width="25%"></td><td width="25%"></td><td width="25%"></td></TR>
<TR><TD colspan='4'>&nbsp;<TD><td width="25%"></td><td width="25%"></td><td width="25%"></td></TR>
<TR>
	<TD width='25%' class='labelcenter' > <fmt:message key="Common.identification.label" bundle="${common_labels}"/> </TD>
	<TD width='25%' class='labelcenter' > <fmt:message key="eSM.RoleName.label" bundle="${sm_labels}"/> </TD>
	<TD  class='labelcenter' width='25%'> <fmt:message key="Common.changepassword.label" bundle="${common_labels}"/>&nbsp;&nbsp;</TD>
	<TD width='25%'></TD>
</TR>	
<TR >

	<TD width='25%' class='labelcenter'>
		<INPUT TYPE="text" name="role1" id="role1" readonly size='3' >
		<INPUT TYPE="hidden" name="roleH1" id="roleH1"'>	
	</TD>
	<TD width='25%' class='labelcenter'>
		<INPUT TYPE="text" name="id1" id="id1" readonly maxlength='20'>
		<INPUT TYPE="hidden" name="idH1" id="idH1"'>
	</TD>	
 	<TD width='25%' class='labelcenter'><INPUT TYPE="checkbox" name="enab1" id="enab1" onClick='ValidPw(this,document.forms[0].idH1)'></TD>
	<TD width='25%'></TD>

</TR>
<TR >
	<TD width='25%' class='labelcenter'>
		<INPUT TYPE="text" name="role2" id="role2"  size='3' readonly >
		<INPUT TYPE="hidden" name="roleH2" id="roleH2"'>	
	</TD>
	<TD width='25%' class='labelcenter'>
		<INPUT TYPE="text" name="id2" id="id2" readonly >
		<INPUT TYPE="hidden" name="idH2" id="idH2"'>	
	</TD>
 	<TD width='25%' class='labelcenter'><INPUT TYPE="checkbox" name="enab2" id="enab2" onClick='ValidPw(this,document.forms[0].idH2)'></TD>
	<TD width='25%'>&nbsp;</TD>

</TR>
<TR >
	<TD width='25%' class='labelcenter'>
		<INPUT TYPE="text" name="role3" id="role3" readonly size='3'  >
		<INPUT TYPE="hidden" name="roleH3" id="roleH3"'>	
	</TD>
	<TD width='25%' class='labelcenter'>
		<INPUT TYPE="text" name="id3" id="id3" readonly >
		<INPUT TYPE="hidden" name="idH3" id="idH3"'>	
	</TD>
 	<TD width='25%' class='labelcenter'>
		<INPUT TYPE="checkbox" name="enab3" id="enab3" onClick='ValidPw(this,document.forms[0].idH3)'>
	</TD>
	<TD width='25%'></TD>
</TR>
<TR><TD colspan='4' width="25%">&nbsp;<TD><TD width='25%'></TD><TD width='25%'></TD><TD width='25%'></TD></TR>
	 </table>
	 <table border=0 cellspacing=0 cellpadding=0 border=0 align=center width='80%'>
<TR >
	<TD >
		
	</TD>	
</TR>
<%
	try{
		String Sql1= "SELECT ora_role_type,ora_role_id,app_password.decrypt(ora_role_password), ora_privilege from sm_ora_role order by ora_role_type";

		pstmt = con.prepareStatement( Sql1 );
		rs    = pstmt.executeQuery();

		if(rs!=null)
		{
			while(rs.next())
			{	
				ora_type = rs.getString(1);			
				ora_id	 = rs.getString(2);
			
				totVal.append(ora_type+"@"+ora_id+"#");				
                


%>

<%	
			}
		StringTokenizer token = new StringTokenizer(totVal.toString(), "#");

	    while (token.hasMoreTokens())
		 {
			totVal1 = token.nextToken();
			StringTokenizer token1 = new StringTokenizer(totVal1, "@");
				while(token1.hasMoreTokens())
				{					
					ora_type1 = token1.nextToken();
					ora_id1	  = token1.nextToken();
                    
%>
	<SCRIPT>
			document.forms[0].role<%=i%>.value='<%=ora_type1%>';
			document.forms[0].roleH<%=i%>.value='<%=ora_type1%>';
			document.forms[0].id<%=i%>.value='<%=ora_id1%>';
			document.forms[0].idH<%=i%>.value='<%=ora_id1%>';
			
	</SCRIPT>	

			
<%			
					i++;
				 }
		 }
		}
		if(rs!=null)rs.close();
	}catch(Exception e ){out.println("Errors Encountered " + e);}
%>
<TR><TD >&nbsp;<TD></TR>
	<INPUT TYPE="hidden" name='ObjVal' id='ObjVal'>
</TABLE>
		<input type='hidden' name="CompVal" id="CompVal" value="C">
</FORM>
</BODY>
<%if(pstmt != null) pstmt.close();
}catch(Exception e){out.println(e);}
finally {
				
	ConnectionManager.returnConnection(con,request);
}	
%>
</HTML>

