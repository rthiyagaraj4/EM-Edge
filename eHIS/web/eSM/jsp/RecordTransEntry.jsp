<!DOCTYPE html>
<html>
<%@ page  contentType="text/html;charset=UTF-8" 
  import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*" %>
<title>
	<fmt:message key="eSM.TranslationManager.label" bundle="${sm_labels}"/>
</title>
<script>
function validate()
{
	var leng =	document.forms[0].elements.length;
	var submit = "Y";
	var msg = "";
	for(i=0;i<leng;i++)
		{
			
		  if (document.forms[0].elements(i).type=="text" || document.forms[0].elements(i).type=="textarea")
		  {
			
		    if (document.forms[0].elements(i).value=="")
		    {
			
			msg= getMessage('CAN_NOT_BE_BLANK','Common');
			
			msg = msg.replace('$',document.forms[0].elements(i).name);
			
			msg=msg+"\n";
			
			submit = "N";
			}
		  }
		}
	if (submit=="Y")
    {
		document.forms[0].submit();
		window.close();
	}
	else
	{	
		alert(msg);
		return false;
	}
}
function checkMaxLength(Obj,length)
	{	
		var msg = "";
		if(eval(Obj).value.length > parseInt(length))
			{
			msg = getMessage('OBJ_CANNOT_EXCEED','Common');
			msg = msg.replace('$',length);
			alert(msg);
			Obj.focus();
			}
	}
</script>
<head>
<%
          request.setCharacterEncoding("UTF-8");
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<object id="locale" classid="clsid:C0276E18-D808-4F12-829E-BC186831D396" CODEBASE="../../eCommon/js/Locale.CAB#version=1,0,0,0"></object>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script src="../../eCommon/js/locale.js" language="JavaScript"></Script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eSM/js/RecordTrans.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	Connection con = null;
	Statement stmt=null;
	Statement stmt1=null;
	try{
	con = ConnectionManager.getConnection(request);
	
	ResultSet rs=null ;
	ResultSet rs1=null ;
    String tableid = request.getParameter("tableid");

	if (tableid ==null) tableid ="";
    String module_id = request.getParameter("module_id");
	if (module_id ==null) module_id="";
	String code = request.getParameter("code");
	if (code==null) code ="";
	
	String code_name = request.getParameter("code_name");
	if(code_name == null) code_name = "";
	String sql="";
	String sql1="";
	String column_id="";
	String column_width="";
	String column_prompt="";
	String column_display="";
	String column_pk_yn="";
	String lang_id="";
//	String all_column_id="";
//	String column_pk_id="";
	String col_value="";
	//String whereClause="";
	String mode="I";
	int total_columns = 0;
	stmt=con.createStatement();
	stmt1=con.createStatement();
		%>
 	<body  onUnload='loadEnglish()' onLoad="FocusFirstElement()";onKeyDown = 'lockKey()';  OnMouseDown="CodeArrest()";> 
		<form name='RecordTransForm4' id='RecordTransForm4' action='../../servlet/eSM.RecordTransServlet' method='post' target='messageFrame'>
<table align = 'center' width='95%' cellspacing=0 cellpadding=0 border=0>

		<th align = 'left' colspan=2>
		<%
				     try{
				     	sql="select module_id  from sm_record_trans_hdr where table_id= '"+tableid+"'";

						rs=stmt.executeQuery(sql) ;
						if(rs!=null)
					    {
					      while(rs.next())
					  	   {
							 module_id = rs.getString("module_id");
    				       }
						   
    				     }if(rs!=null)rs.close();
    				   }
    				   catch(Exception e){out.println(e.toString());}

					try{
						sql="select language_id, short_name  from sm_language where usage_type= 'O' and rownum<=1";
						
						rs=stmt.executeQuery(sql) ;
						if(rs!=null)
					    {
					      while(rs.next())
					  	   {
							 out.println("Other Language : "+rs.getString("short_name")+"</th>");
							 lang_id = rs.getString("language_id");
    				       }
						   
    				     }if(rs!=null)rs.close();
    				   }
    				    	catch(Exception e){out.println(e.toString());}
                    %>
                    <tr><td>&nbsp;</td><td>&nbsp;</td></tr>
					<%
					try{
				     	sql="select column_id,column_width,column_prompt,column_display,column_pk_yn from sm_record_trans_dtl where table_id= '"+tableid+"'";
						
						rs=stmt.executeQuery(sql) ;
						sql1="select " + column_id + " from " + tableid + " where " + code_name  +"='"+code+"'";
						
                       	rs1=stmt1.executeQuery(sql1) ;
				        if(rs!=null)
					    {
					      while(rs.next())
					  	   {
                             total_columns  ++;
							 column_id		= rs.getString("column_id");
							 column_width   = rs.getString("column_width");
						     column_prompt  = rs.getString("column_prompt");
						     column_display = rs.getString("column_display");
						     column_pk_yn   = rs.getString("column_pk_yn");
							/*if (column_pk_yn.equalsIgnoreCase("Y"))
							    column_pk_id   = rs.getString("column_id");*/
						  col_value="";
						  if (column_display.equalsIgnoreCase("Y"))
							{
							try{
								
						        if(rs1!=null)
							    {
								  while(rs1.next())
					  				{
							        col_value = rs1.getString(1);
									}
									
    							}if(rs1!=null)rs1.close();
    				      	}
							catch(Exception e){out.println(e.toString());}
						   out.println("<tr><td class='label' >"+column_prompt+"</td>");
                           out.println("<td class = 'querydata'>&nbsp; "+col_value+"<input type='hidden' name='"+column_id+"' id='"+column_id+"' size = '"+column_width+"' maxlength = '"+column_width+"' value =\""+col_value+"\" readonly></td><tr><td class='DEFAULTBLANKROW2PT' colspan=6>&nbsp;</td></tr></tr>");
						   }
                         else
							   {
							try{
								
                               
							   sql1="select column_value from sm_record_trans_data where module_id = '"+module_id+"' and table_id = '"+tableid+"' and column_id = '"+column_id+"' and pk_value = '"+code+"' and language_id ='"+lang_id+"'"; 
								
								
								rs1=stmt1.executeQuery(sql1) ;
								if(rs1!=null)
							    {
								  while(rs1.next())
					  				{
							        col_value = rs1.getString(1);
									mode = "U";
									}
									
    							}if(rs1!=null)rs1.close();
    				      	}
							catch(Exception e){out.println(e.toString());}
						   out.println("<tr><td class='label' >"+column_prompt+"</td>");
									out.println("<td >&nbsp;<input type='hidden' name='"+column_id+"1' id='"+column_id+"1' value =\""+column_prompt+"\">");
									if(Integer.parseInt(column_width)<=60)
									out.println("<input id=\""+column_id+"\"  type='text' style='text-align:right' onFocus='loadArabic()' onBlur='loadEnglish()' class='OTHLANGTEXT'  name=\""+column_id+"\"  size = 	'"+column_width+"' maxlength = '"+column_width+"' value =\""+col_value+"\">&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>");
									else
									out.println("<table border=0><tr><td><textarea  name=\""+column_id+"\" style='text-align:right' cols='50' onFocus='loadArabic()' onBlur='loadEnglish();checkMaxLength(this,"+column_width+")' onkeypress='checkMaxLimit(this, "+column_width+")' rows='4'>"+col_value+"</textarea></td><td valign='center'><img src='../../eCommon/images/mandatory.gif'></img></td></tr></table>&nbsp;");
									out.println("</td><tr><td class='DEFAULTBLANKROW2PT' colspan=6>&nbsp;</td></tr></tr>");
							   }
						 }
						 
    				   }if(rs!=null)rs.close();
					   if(rs1!=null)rs1.close();
					}
							catch(Exception e){out.println(e.toString());}
						%>
<tr><td>&nbsp;</td><td >&nbsp;&nbsp;&nbsp;&nbsp;
<input type='hidden' name='tableid' id='tableid' value='<%=tableid%>'>
<input type='hidden' name='module_id' id='module_id' value='<%=module_id%>'>
<input type='hidden' name='lang_id' id='lang_id' value='<%=lang_id%>'>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>

<input type='hidden' name='code' id='code' value='<%=code%>'>

</td>
</tr>
<tr><td colspan='2' align='right'><input type='button' class='button' name='btnOK' id='btnOK' value='Record' onClick="validate()" >&nbsp;<input type='button' class='button' name='btnCancel' id='btnCancel' value='Cancel' onClick="javascript:window.close()" ></td></tr>
</table>

</form>
</body>
</html>
 <%
	}catch(Exception e){}
finally{
	if(stmt!=null) stmt.close();
	if(stmt1!=null) stmt1.close();
if(con!=null) ConnectionManager.returnConnection(con,request);
}

%>

