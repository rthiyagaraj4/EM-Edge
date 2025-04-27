<!DOCTYPE html>
<HTML> 
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.*,eXH.XHDBAdapter"%>
<%@ page import = "java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% // String locale = ((String)session.getAttribute("LOCALE"));	%>
<HEAD> 
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>

<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript">
  
 
//function validatecheckbox
function validatecheckbox(obj,whichelement,segment_type)
{
	/*if(segment_type=='OBR' || segment_type=='OBX' || segment_type=='ORC' || segment_type=='ERR')
	{
		document.getElementById(segment_type+"_inuse").checked=false;	
		var replace=getMessage('XH0070','XH').replace('$',segment_type); 
		alert(replace);


	obj.value="N";
	}*/
	
	if(obj.checked==true)
	{
		obj.value="Y";
		document.getElementById(whichelement+"_inuse1").value="Y";
		document.getElementById("_field"+whichelement).value="Y";
	}
	else
	{
		obj.value="N";
		document.getElementById(whichelement+"_inuse1").value="N";
		document.getElementById("_field"+whichelement).value="N";
	}
}

function funAction(typ){
	this.document.forms[0].target = 	"";
//	alert(parent.parent.frames[3].name);
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	this.document.forms[0].action_type.value = typ;
	this.document.forms[0].action = '../../eXH/jsp/EventTypeSegmentUsage.jsp';
	this.document.forms[0].submit();
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<BODY  leftmargin=0 topmargin=0  bgcolor='#F0F0F2' onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<%
Connection con=null;
Statement stmt=null;
ResultSet rs=null;
//int i=0;
String classValue="";
String segment_type="";
String segment_name="";
String optional_yn="";
String in_use_yn="";

String stnd_code="";
String stnd_desc="";
String msgctrl_yn="";
String reptn_appl_yn="";
String file_ctrl_type="";

//String mast_commn_type="";
//String event_type=""; 
//String commn_type="";

String standard_code = XHDBAdapter.checkNull(request.getParameter("standard_code"));
//System.out.println("standard_code : "+standard_code);

%>
<form name="MasterSegmentListForm" id="MasterSegmentListForm" target='messageFrame' method='post' action=''>
<%
try{
	ArrayList arrRow = null;
ArrayList arrCol = null;
String strPrevious = "";  
String strNext  = "";
HashMap resultsQry=null; 
//		con=ConnectionManager.getConnection();
		boolean boolToggle =  true;	
		//String qry_id = "EVENTTYPSEG"; 
		String whereClause = "WHERE  ";

		whereClause	=	whereClause+" A.SEGMENT_TYPE=B.SEGMENT_TYPE(+) AND B.STANDARD_CODE=C.STANDARD_CODE(+) AND DECODE(B.STANDARD_CODE,NULL,'XX',B.STANDARD_CODE) =NVL('"+standard_code+"',DECODE(B.STANDARD_CODE,NULL,'XX',B.STANDARD_CODE)) AND A.LANGUAGE_ID='en' ORDER BY SEGMENT_TYPE";

/*
		String sql="SELECT A.SEGMENT_TYPE,A.SEGMENT_NAME,A.OPTIONAL_YN,A.IN_USE_YN,C.STANDARD_DESC,B.REPETITION_APPLICABLE,B.CONTROL_YN,B.FILE_CONTROL_TYPE FROM XH_SEGMENT_LANG_VW A,XH_SEGMENT B,XH_STANDARD C WHERE A.SEGMENT_TYPE=B.SEGMENT_TYPE(+) AND B.STANDARD_CODE=C.STANDARD_CODE(+) AND A.LANGUAGE_ID='en' ORDER BY SEGMENT_TYPE";
*/
	
//		String sql="SELECT A.SEGMENT_TYPE,A.SEGMENT_NAME,A.OPTIONAL_YN,A.IN_USE_YN,C.STANDARD_DESC,B.REPETITION_APPLICABLE,B.CONTROL_YN,B.FILE_CONTROL_TYPE FROM XH_SEGMENT_LANG_VW A,XH_SEGMENT B,XH_STANDARD C WHERE A.SEGMENT_TYPE=B.SEGMENT_TYPE(+) AND B.STANDARD_CODE=C.STANDARD_CODE(+) AND DECODE(B.STANDARD_CODE,NULL,'XX',B.STANDARD_CODE) =NVL('"+standard_code+"',DECODE(B.STANDARD_CODE,NULL,'XX',B.STANDARD_CODE)) AND A.LANGUAGE_ID='en' ORDER BY SEGMENT_TYPE";


				
				// #MOD#04
				 request.setAttribute("standard_code",standard_code);
			
	 
	        con = ConnectionManager.getConnection(request);
			XHSegForApplicationElementsBean	xhBean = XHSegForApplicationElementsBean.getBean(XHSegForApplicationElementsBean.strBeanName,request,session);
			xhBean.action(request,con);
			resultsQry = xhBean.getResultSet();
			arrRow = (ArrayList)resultsQry.get("qry_result"); 
			boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
			boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
		strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
        strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
			if (boolPrevious == true)
			{ 
				strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
			}
			else
			{
				strPrevious = " ";
			}
			if (boolNext== true)
			{
				 strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
			}
			else
			{
				strNext  = " ";
			}


		%>

<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
<%
if(arrRow.size()==0)
{
	%>
		<script>
			alert(getMessage('XH1021','XH'));
	//		alert(getMessage('XH1014','XH'));
		</script> 
	
	<%
}
else { %>
	<tr>
	<td colspan="6" align="right" class="CAGROUP" > 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%=strNext %></A>
	</td>
	</tr> 

		<td class='COLUMNHEADER' width='10%'><fmt:message key="eXH.SegmentType.Label" bundle="${xh_labels}"/> </td>
		<td class='COLUMNHEADER'><fmt:message key="eXH.SegmentType.Label" bundle="${xh_labels}"/>  <fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
<!--		<td class='COLUMNHEADER'>  <fmt:message key="Common.Standard.label" bundle="${common_labels}"/></td> -->
		<td class='COLUMNHEADER' width='15%'><fmt:message key="eXH.StandardType.Label" bundle="${xh_labels}"/></td>
		<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.Optional.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='10%'><fmt:message key="eXH.Repetition_Appl.Label" bundle="${xh_labels}"/></td>
	<!-- cmmntd on jan6th 	<td class='COLUMNHEADER' width='10%'><fmt:message key="eXH.MessageControl.Label" bundle="${xh_labels}"/></td> -->
<!--		<td class='COLUMNHEADER' width='10%'>Nature</td>
		<td class='COLUMNHEADER' width='10%'>File Control Type</td> -->
<!--		<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td> -->
		<td class='COLUMNHEADER' width='7%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>

	<%
		/*while(rs.next())
		{
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ; */
			for (int j=0; j<arrRow.size();j++) 
			{
				arrCol = (ArrayList)arrRow.get(j);
				if (boolToggle == true)
				{
	//				strTDClass = "class='QRYEVEN'";
					classValue = "QRYEVEN" ;
					boolToggle =  false;
				}
				else
				{
	//				strTDClass = "class='QRYODD'";
					classValue = "QRYODD" ;
					boolToggle =  true;
				}
			
			segment_type=(String)arrCol.get(0);
			segment_name=(String)arrCol.get(1);
			optional_yn=(String)arrCol.get(2);
			in_use_yn=(String)arrCol.get(3);
			stnd_desc=XHDBAdapter.checkNull((String)arrCol.get(4));
			reptn_appl_yn=XHDBAdapter.checkNull((String)arrCol.get(5));
			msgctrl_yn =  XHDBAdapter.checkNull((String)arrCol.get(6));
			file_ctrl_type = XHDBAdapter.checkNull((String)arrCol.get(7));
			stnd_code=XHDBAdapter.checkNull((String)arrCol.get(8));

	/*			if(segment_type.equals("ALL")){
					System.out.println("reptn_appl_yn : "+reptn_appl_yn);
					System.out.println("msgctrl_yn : "+msgctrl_yn);
					System.out.println("file_ctrl_type : "+file_ctrl_type);
				} */
			
		if(segment_type.equals("ALL"))
		{
			if (boolToggle == true)
			{
			//	strTDClass = "class='QRYEVEN'";
				classValue = "QRYEVEN" ;
				boolToggle =  false;
			}
			else
			{
			//	strTDClass = "class='QRYODD'";
				classValue = "QRYODD" ;
				boolToggle =  true;
			}
		}
		else
		{
			%>
		<tr>
		<td class='<%=classValue%>' align=left ><%=segment_type%></td>
		<td class='<%=classValue%>' align=left ><%=segment_name%></td>
		<td class='<%=classValue%>' align=left ><%=stnd_code%></td>

		<td class='<%=classValue%>' align=center>
		<input type=checkbox name='<%=segment_type%>_optional_yn' id='<%=segment_type%>_optional_yn' <%=optional_yn.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=optional_yn.equals("Y")?"Y":"N"%>' disabled=true></td>	

<!-- Reptn Appl -->

		<td class='<%=classValue%>' align=center >
		<input type=checkbox name='<%=segment_type%>_rptn_yn' id='<%=segment_type%>_rptn_yn' <%=reptn_appl_yn.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=optional_yn.equals("Y")?"Y":"N"%>' disabled=true></td>	

<!-- Msg Ctrl --> 

<!--		<td class='<%=classValue%>' align=center >-->
	<!--	cmmntd on jan6th <input type=checkbox name='<%=segment_type%>_select_yn' id='<%=segment_type%>_select_yn' <%=msgctrl_yn.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=optional_yn.equals("Y")?"Y":"N"%>' disabled=true> -->
<!--			<select name='<%=segment_type%>_nature' id='<%=segment_type%>_nature' disabled>
				<option value='X'>Both.</option>
				<option  value='C' >Control</option>
				<option value='D' >Data.</option>
			</select>
		</td>	 -->

<!-- FileCtrlTyp -->
	<!--	<td class='<%=classValue%>' align=center >
				<select name='<%=segment_type%>_file_ctrl_type' id='<%=segment_type%>_file_ctrl_type' disabled>
				<option value=''>--Select--</option>
				<option  value='H' <%=file_ctrl_type.equals("H")?"selected":""%>>File Header</option>
				<option value='F' <%=file_ctrl_type.equals("F")?"selected":""%>>File Footer</option>
				</select>
			</td>
-->
		<td class='<%=classValue%>' align=center >  
		<input type=hidden name='<%=segment_type+"_field"%>' id='<%="_field"+j%>' value='<%=(String)arrCol.get(9)%>'> 
		<input type=checkbox name='<%=segment_type+"_inuse"%>' id='<%=segment_type+"_inuse"%>' <%=in_use_yn.equals("Y")?"checked":""%> onClick="validatecheckbox(this,<%=j%>,'<%=segment_type%>');" value='<%=in_use_yn.equals("Y")?"Y":"N"%>'  <%=optional_yn.equals("Y")?"":"disabled=true"%>></td>	
		<input type=hidden name='<%=segment_type+"_inuse1"%>' id='<%=j+"_inuse1"%>' value='<%=in_use_yn.equals("Y")?"Y":"N"%>'> 
   		</tr> 
		<%
		//		i++;
				}
			} // end of for 
		} // end of else
				if(arrRow!=null) arrRow.clear(); 
				if(arrCol!=null) arrCol.clear();
				if(resultsQry!=null) resultsQry.clear();

}catch(Exception e1)
{
		System.out.println("(EventTypeSegmentUsage.jsp:Exc)  : "+e1.toString());
}
finally{
			try{ 
			
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			ConnectionManager.returnConnection(con);
				}catch(Exception e) 
				{
				System.out.println("(EventTypeSegmentUsage.jsp:Exception-2) :"+e);
				} 
		
			}
		
%>
</table>
<input type='hidden' name='action_type' id='action_type' value=''>
<input type=hidden name=stnd_code value=<%=standard_code%>>
</form>
</body>
</html>

