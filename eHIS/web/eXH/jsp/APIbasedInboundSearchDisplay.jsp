<!DOCTYPE html>
<HTML> 
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter,java.io.*"%>
<%@ page import = "java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%  String locale = ((String)session.getAttribute("LOCALE"));	%>
<HEAD>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language='javascript' src='../../eXH/js/APIBasedInbound.js'></script> 
<script language="JavaScript">
//function validatecheckbox
function validatecheckbox(obj)
{
if(obj.checked==true)
	obj.value="Y";
	else
	obj.value="N";
}

function dsblElmntVal()
{
//		alert("dsblElmntPos");
    var elmntVal = document.forms[0].element_val.value;
	if(elmntVal!=null && elmntVal!="" ){
		alert("dsblElmntVal");
		document.forms[0].element_val.disabled = "";
	}
	else{
		document.forms[0].element_val.disabled = true;
	}
}

function dsblElmntPos()
{
//	alert("dsblElmntPos");
    var elmntPos = document.forms[0].element_pos.value;
	if(elmntPos!=null && elmntPos!="" ){
		alert("dsblElmntPos");
		document.forms[0].element_pos.disabled = true;
	}
	else{
		document.forms[0].element_pos.disabled = "";
	}
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<BODY  leftmargin=0 topmargin=0  bgcolor='#F0F0F2' onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<%
Connection con=null;
Statement stmt=null;
ResultSet rs=null;
int i=0;
String classValue="";
String msg_type="";

String appl_id = "";
String fac_id = "";
String evnt_id = "";
String sgmnt_id = "";
String inb_api = "";

String s_no = "";
String arg_id = "";
String arg_name = "";
String elmnt_pos = "";
String elmnt_val = "";

String stnd_code = "";
String stnd_desc = "";


appl_id = request.getParameter("appl_id");
	//System.out.println("appl_id : "+appl_id);
fac_id  = request.getParameter("fac_id");
	//System.out.println("fac_id : "+fac_id);
evnt_id = request.getParameter("evnt_id");
	//System.out.println("evnt_id : "+evnt_id);
sgmnt_id  = request.getParameter("sgmnt_id");
	//System.out.println("sgmnt_id : "+sgmnt_id);
inb_api   = request.getParameter("inb_api");
	//System.out.println("inb_api : "+inb_api);

%>
<form name="APIbased_Inb_SearchDisplay" id="APIbased_Inb_SearchDisplay" target='messageFrame' method='post' action=''>
<%
try{
		con=ConnectionManager.getConnection();
		
		String sql="SELECT  A.SNO,A.ARGUMENT_ID,A.ARGUMENT_NAME,A.ELEMENT_POSITION,A.ELEMENT_VALUE,A.STANDARD_CODE,B.STANDARD_DESC  FROM xh_inbound_api_dtl A,XH_STANDARD B  WHERE A.APPLICATION_ID='"+appl_id+"' AND	A.FACILITY_ID='"+fac_id+"' AND A.EVENT_TYPE='"+evnt_id+"' AND A.SEGMENT_ID='"+sgmnt_id+"'  AND A.INBOUND_API='"+inb_api+"' AND A.STANDARD_CODE=B.STANDARD_CODE(+) ORDER BY A.SNO ";
		
		stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
	   	rs=stmt.executeQuery(sql);
        rs.last(); 
		if(rs.getRow()==0)
	    { %>
		<script>
		alert(getMessage('XH1021','XH'));
		</script>
		<%}
		else{
		
		rs.beforeFirst();
	%>	
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
<td class='COLUMNHEADER' width='10%'><fmt:message key="eXH.SerialNo.Label" bundle="${xh_labels}"/></td>
<td class='COLUMNHEADER' width='10%'> <fmt:message key="eXH.ArgID.Label" bundle="${xh_labels}"/></td>
<td class='COLUMNHEADER' width='10%'>  <fmt:message key="eXH.ArgName.Label" bundle="${xh_labels}"/></td>
<td class='COLUMNHEADER' width='10%'>  <fmt:message key="eXH.Standard.Label" bundle="${xh_labels}"/></td>
<td class='COLUMNHEADER' width='15%'><fmt:message key="eXH.ElementPos.Label" bundle="${xh_labels}"/></td>
<td class='COLUMNHEADER' width='10%'><fmt:message key="eXH.ElementVal.Label" bundle="${xh_labels}"/></td>

	<%
		while(rs.next())
		{
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;
			
			s_no=rs.getString(1);
			arg_id=rs.getString(2);
			arg_name=rs.getString(3);
			elmnt_pos=XHDBAdapter.checkNull(rs.getString(4));
			elmnt_val=XHDBAdapter.checkNull(rs.getString(5));
			stnd_code=XHDBAdapter.checkNull(rs.getString(6));
			stnd_desc=XHDBAdapter.checkNull(rs.getString(7));

		%>
			<tr>

			<td class='<%=classValue%>' align=left ><%=XHDBAdapter.checkNull(s_no)%></td>
			<td class='<%=classValue%>' align=left ><%=XHDBAdapter.checkNull(arg_id)%></td>
			<td class='<%=classValue%>' align=left ><%=XHDBAdapter.checkNull(arg_name)%></td>
			<td class='<%=classValue%>' align=left ><%=XHDBAdapter.checkNull(stnd_desc)%></td>
			<td class='<%=classValue%>' align=center ><input type=text name='<%=s_no%>_element_pos' id='<%=s_no%>_element_pos' value='<%=XHDBAdapter.checkNull(elmnt_pos)%>' >
			<input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=ElementSearch value='?'    onClick="searchElement();">
			<input type="hidden" name="element_id" id="element_id" value='<%=s_no%>_element_id' ></td>	
			<td class='<%=classValue%>' align=center ><input type=text name='<%=s_no%>_element_val' id='<%=s_no%>_element_val' value='<%=XHDBAdapter.checkNull(elmnt_val)%>'></td>	
			</tr>
			<%
				i++;

		}
		}
}catch(Exception e1)
{
		System.out.println("Err (APIbasedInboundSearchDisplay.jsp)  :"+e1.toString());
}
finally{
			try{
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			ConnectionManager.returnConnection(con);
				}catch(Exception e)
				{
				System.out.println("Err APIbasedInboundSearchDisplay.jsp : "+e);
				}
		
			}
%>
</table>

<input type=hidden name=mode value='U' >

<input type=hidden name=msg_text value=<%=msg_type%>>
<input type=hidden name=appl_id value=<%=appl_id%>>
<input type=hidden name=fac_id value=<%=fac_id%>>
<input type=hidden name=evnt_id value=<%=evnt_id%>>
<input type=hidden name=sgmnt_id value=<%=sgmnt_id%>>
<input type=hidden name=inb_api value=<%=inb_api%>>

<input type=hidden name=arg_serial_no value=<%=s_no%>>
<input type=hidden name=arg_id value=<%=arg_id%>>
<input type=hidden name=arg_name value=<%=arg_name%>>
<input type=hidden name=stnd_code value=<%=stnd_code%>>

<input  type=hidden name=locale value=<%=locale%> >

<input type=hidden name=option value='event'>
</form>
</body>
</html>

