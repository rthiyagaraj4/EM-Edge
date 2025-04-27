<!DOCTYPE html>

<%@ page import ="java.sql.*,java.sql.PreparedStatement,java.sql.ResultSet,java.net.*,webbeans.eCommon.ConnectionManager,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>


<%  String role_id=CommonBean.checkForNull(request.getParameter("role_id"));%>
<HTML>
	<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='JavaScript' src='../../eOT/js/FunctionsForRole.js'></script>
	<script language="JavaScript">

function validateCheckBox(obj){
	var formObj = document.forms[0];//modified By yadav
	formObj.modified_flag.value="false";
	var name=obj.name;
	var ind=name.substring(10,12);
	if(obj.checked==true){   
			//obj.select_yn="Y";
			obj.setAttribute('select_yn','Y');
			document.getElementById("Srl_No"+ind).disabled=true;
			
	}else{
		   //obj.select_yn="N";
		   obj.setAttribute('select_yn','N');
		   document.getElementById("Srl_No"+ind).disabled=false;
		  }

	var arrobj1=document.forms[0].elements;
	
	for(var i=0;i<arrobj1.length-1;i++)
		{
			arrobj1[i+1].srl_no=arrobj1[i].value;
			i++;
		}

		for(var j=0;j<arrobj1.length-2;j=j+2)

                {

               
                if((arrobj1[j+1].checked==true)&&(arrobj1[j+1].srl_no=="0"))

                            {
								arrobj1[j+1].checked;

                            alert('The Serial No can not be inserted as 0 ');

                            arrobj1[j+1].checked=false
							arrobj1[j].disabled=false
                            arrobj1[j].focus();

                            return;
							}
							else
								continue;
				}

	
	var arrObj = document.forms[0].elements;
	
	for(var i=0;i<arrObj.length;i++){
		if(arrObj[i].type=="checkbox" ){
			if(arrObj[i].value==arrObj[i].getAttribute('select_yn')){
			  //arrObj[i].db_change="N";
			  arrObj[i].setAttribute('db_change','N');
			 
				  continue;
			}else{
				formObj.modified_flag.value="true";
				 //arrObj[i].db_change="Y";
				 arrObj[i].setAttribute('db_change','Y');
			}
		} 
		
	}

	
		
}

function previous(){
     var frm=window.parent.frames[0].document.forms[0];
	 var frm1=window.parent.frames[1];
	 //var frm2=window.parent.frames[1].frames[1];
	 //alert(frm.name);
	 //alert(frm1.name);
	 //alert(frm2.name);
	 var formObj = document.forms[0];

	 var modified_flag=formObj.modified_flag.value;
	 if(modified_flag=="true"){
		alert("Please apply Changes..!");
		return;
	}
	var role_id=frm.role_description.value;
	//var execute_flag=formObj.execute_flag.value
	var start = formObj.start.value;
	formObj.start.value=start-14;
	var end = formObj.end.value;
	formObj.end.value=end-14;
	start = formObj.start.value;
	end = formObj.end.value;
    //alert(window.parent.frames[1].name);
	//alert(window.parent.frames[1].frames[2].name);
	document.location.href="../../eOT/jsp/FunctionsForRoleDetailForm.jsp?from="+start+"&to="+end+"&role_id="+role_id;
	//window.parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		
}

  function next(){
	 var frm=window.parent.frames[0].document.forms[0];
	 var frm1=window.parent.frames[1];
	 //var frm2=window.parent.frames[1].frames[1];
	// alert(frm.name);
	 //alert(frm1.name);
	 //alert(frm2.name);
	 var formObj = document.forms[0];
	 var modified_flag=formObj.modified_flag.value;
	 if(modified_flag=="true"){
		alert("Please apply Changes..!");
		return;
	}
	 var role_id=frm.role_description.value;
	 //alert(role_id);
	 var start = formObj.start.value;
	 formObj.start.value=parseInt(start)+14;
	 start = formObj.start.value;
	 var end = formObj.end.value;
	 formObj.end.value=parseInt(end)+14;
	 end = formObj.end.value;
   //alert(window.parent.frames[1].name);//frames[1].frames[1].name);
// alert(window.parent.frames[1].frames[1].frames[1].name);	
   var frmobj=window.parent.frames[1];
document.location.href="../../eOT/jsp/FunctionsForRoleDetailForm.jsp?from="+start+"&to="+end+"&role_id="+role_id;
	//window.parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		
	 

	
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="StatusDetailForm" id="StatusDetailForm">
<%
  //OnMouseDown='CodeArrest()' onKeyDown="lockKey()"
   String from = CommonBean.checkForNull(request.getParameter( "from" )) ;
   String to =   CommonBean.checkForNull(request.getParameter( "to" ) ) ;
  
   
   String select_value="Y";
   String function_id="";
   String function_desc_user="";
   String sel="";
   String srl_no="";
   StringBuffer srl_no_from_DB=new StringBuffer();
   String select_checked="";
   int start = ( from.equals("") )?1:Integer.parseInt(from);
   int end =  ( to.equals("") )?14:Integer.parseInt(to);
   Connection conn = null;
   PreparedStatement pstmt = null;
   //PreparedStatement pstmt1= null;
   ResultSet rst=null;
   //ResultSet rst1=null;
    String strsql="SELECT A.FUNCTION_ID, A.FUNCTION_DESC_USER,nvl(B.SRL_NO,'0'),DECODE (B.FUNCTION_ID, A.FUNCTION_ID,'Y','N') SEL FROM OT_FUNCTIONS_LANG_VW A, OT_ROLES_FUNCTIONS B WHERE A.LANGUAGE_ID ='"+locale+"'  AND A.FUNCTION_ID = B.FUNCTION_ID(+) AND B.ROLE_ID(+)= ? ORDER BY 1";
   
   
   int maxRecord = 0;
   int i=1;
   try{
   
		conn  =  ConnectionManager.getConnection(request);
		pstmt = conn.prepareStatement(strsql);
		pstmt.setString(1,role_id);
		rst = pstmt.executeQuery();
		int total=0;
		while(rst.next()){
			total++;
		}
        maxRecord = total;
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
			//return;
			
		}
		pstmt=conn.prepareStatement(strsql);
		pstmt.setString(1,role_id);
		rst = pstmt.executeQuery();

%>
<P>
<table align='right'>
<tr>
<td>
<%
	if ( !(start <= 1) )
		out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='previous();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</font>");
	if ( !( (start+14) > maxRecord ) )
		out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='next();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</font>");
%>
</td>
</tr>
</table>
<br><br>
</p>
<table class='grid' border="1" width="100%" cellspacing='0' cellpadding=3  align='center'>
<th class='columnHeaderCenter' nowrap>
	<fmt:message key="eOT.FunctionID.Label" bundle="${ot_labels}"/>
</th>
<th class='columnHeaderCenter' nowrap>
	<fmt:message key="Common.description.label" bundle="${common_labels}"/>
</th>
<th class='columnHeaderCenter' nowrap>
	<fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/>
</th>
<th class='columnHeaderCenter' nowrap>
	<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
</th>
<%
		if ( start != 1 )
		for( int j=1; j<start; i++,j++ )
		rst.next() ;
		String classValue= " ";
		int k=0;
		while ( rst.next() && i<=end  ){
		if ( i % 2 == 0 )
            classValue = "gridData" ;
        else
		    classValue = "gridData" ;
 			function_id = rst.getString(1);
			function_desc_user= rst.getString(2);
			srl_no=rst.getString(3);
			if(!rst.getString(3).equals("0"))
			srl_no_from_DB=srl_no_from_DB.append(",").append(rst.getString(3));
			sel=rst.getString(4);
			if(srl_no.equals("null"))
			srl_no="&nbsp;";
 			out.println("<tr>");
		    out.println("<td class='" + classValue+"' nowrap>"+function_id+"</td>");
		    out.println("<td class='" + classValue+"' nowrap>"+function_desc_user+"</td>");
			out.println("<td class='" + classValue+"' nowrap><input type=text name=Srl_No"+i+" id=Srl_No"+i+" value="+srl_no+" size=2 maxlength=2  db_change1='N' onblur='CheckNum(this)' ></td>");
   			if (sel.equals("Y")){
				   select_checked="checked";
			       select_value="Y";
					k++;
			}else{
				select_checked="";
				select_value="N";
			}
			out.println("<td class='"+classValue+"' nowrap><input type=checkbox name=chk_select"+i+" id=chk_select"+i+" value="+select_value+" "+select_checked+"  func_id='"+function_id+"' db_change='N' srl_no='' select_yn='"+select_value+"' onclick='validateCheckBox(this);'>");
			out.println("</td>");
		    out.println("</tr>");
   			i++;
		} 
	%>
</table>
</center>
<br><center>
<% 
   }catch(Exception e){
		e.printStackTrace();
		//out.println("FunctionForRoleDetailForm : "+e);
	}finally{
		try{
			if(rst!=null)	rst.close();
			if(pstmt!=null)	pstmt.close();
			ConnectionManager.returnConnection(conn,request);
		}catch(Exception e){e.printStackTrace();}
	}
%>
<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>" >
<input type="hidden" name="modified_flag" id="modified_flag" value="false" >
<input type="hidden" name="execute_flag" id="execute_flag" value="YES" >
<input type="hidden" name="start" id="start" value="<%=start%>" >
<input type="hidden" name="end" id="end" value="<%=end%>" >
<input type="hidden" name="srl_number" id="srl_number" value="" >
<input type="hidden" name="sel" id="sel" value="<%=select_checked%>" >
<input type="hidden" name="chkval" id="chkval" value="<%=select_value%>">
<input type="hidden" name="role_id" id="role_id" value="<%=role_id%>" >
<input type="hidden" name="srl_no" id="srl_no" value="<%=srl_no%>">
<input type="hidden" name="srl_no_from_DB" id="srl_no_from_DB" value="<%=srl_no_from_DB%>">
</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='rowNo' id='rowNo' value="<%=i%>">
</form>
</BODY>
<script>
//Added By yadav for disabling SequenceNo
var st=document.getElementById("start").value;
var rowNo=document.getElementById("rowNo").value;

for(var i=st;i<=parseInt(rowNo-1);++i)
		{
		if(document.getElementById("chk_select"+i).checked==true )
			document.getElementById("Srl_No"+i).disabled=true;
		
		}
</script>
</HTML>

