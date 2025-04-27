<!DOCTYPE html>
<HTML>
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet, eCommon.XSSRequestWrapper, webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter,webbeans.eCommon.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<%
Connection con=null;
Statement stmt = null;
ResultSet rs  = null;
String mode="";
String rule="";
String params="";

params=(String)session.getAttribute("params");
params=params+"&expand="+"&home_required_yn=N";
session.setAttribute("params",params);
//String defaultval = "";
%> 
<HEAD> 
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="../../eXH/js/InterfaceStandards.js" ></script> 
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<BODY  leftmargin=0 topmargin=0  onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' >

<%


try{
String standard_code="";
String standard_desc="";
String standard_type="";
String msg_start="";
String msg_end="";
String seg_start="";
String seg_end="";
String fld_separator="";
String elmnt_separator="";
String application_name=""; 
String facility_name=""; 
String mesg_type=""; 
String event_type=""; 
String segment_type="";
String protocol_linkName="";


try
{
	 mode			=	request.getParameter("mode");

//System.out.println("mode"+mode);
rule=request.getParameter("rule");
if(mode.equals("U"))
{
standard_desc=(String)session.getAttribute("standard_desc");
standard_desc=request.getParameter("standard_desc");

standard_type=request.getParameter("standard_type");
msg_start=request.getParameter("msg_start");
msg_end=request.getParameter("msg_end");
seg_start=request.getParameter("seg_start");
seg_end=request.getParameter("seg_end");
fld_separator=request.getParameter("fld_separator");
elmnt_separator=request.getParameter("elmnt_separator");
standard_code=request.getParameter("standard_code");
//System.out.println(standard_desc);

application_name=request.getParameter("application_name");
	facility_name=request.getParameter("facility_name");
	mesg_type=request.getParameter("mesg_type");
	event_type=request.getParameter("event_type");
	segment_type=request.getParameter("segment_type");
	protocol_linkName=request.getParameter("protocol_linkName");
}



}
catch(Exception exp)
    {
       
	   exp.printStackTrace(System.err);
    }

%>

<form name="Interface_Stnd_form" id="Interface_Stnd_form"  method='post' action='../../servlet/eXH.InterfaceStandardAddModifyServlet'>
<table cellspacing=0 cellpadding=3 width='100%' height='50%'  align=center>
<tr>
	<td class=label ><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td align=left><input type=text name=standard_code id=standard_code size=25 value='<%=XHDBAdapter.checkNull(standard_code)%>'  title='Standard Code' <%=mode.equals("U")?"readonly":""%> ><img src='../../eCommon/images/mandatory.gif' align=middle> 
	</td>
	<td class=label ><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td align=left><input type=text name=standard_desc id=standard_desc size=25 value='<%=standard_desc%>' > <img src='../../eCommon/images/mandatory.gif' align=middle></td> <td class=label ><fmt:message key="eXH.StandardType.Label" bundle="${xh_labels}"/></td>
<td align=left>
<select class='select' name='standard_type' id='standard_type'  "+disabled+" >
            <option value=''>---------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
			<option value='H' <%=standard_type.equals("H")?"selected":""%>><fmt:message key="eXH.HL7Interface.Label" bundle="${xh_labels}"/></option>
			<option value='O' <%=standard_type.equals("O")?"selected":""%>><fmt:message key="eXH.OtherInterface.Label" bundle="${xh_labels}"/></option>
			<option value='P' <%=standard_type.equals("P")?"selected":""%>><fmt:message key="eXH.PABX.Label" bundle="${xh_labels}"/></option>
</select> &nbsp;<img src='../../eCommon/images/mandatory.gif' align=middle></td>
</tr>
<tr>
<td class=label ><fmt:message key="eXH.MsgStart.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="msg_start"  name =msg_start size=25 maxlength=30 onKeyPress='return CheckForSpecCharsforID(event,document.forms[0].msg_start);'value='<%=msg_start%>' ><img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td class=label ><fmt:message key="eXH.MsgEnd.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="msg_end"  name =msg_end size=25 maxlength=30 onKeyPress='return CheckForSpecCharsforID(event,document.forms[0].msg_end);' value='<%=msg_end%>' ><img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td class=label ><fmt:message key="eXH.FldSeparator.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="fld_separator"  name=fld_separator id=fld_separator size=25 maxlength=30 onKeyPress='return CheckForSpecCharsforID(event,document.forms[0].fld_separator);' value='<%=fld_separator%>' ><img src='../../eCommon/images/mandatory.gif' align=middle> </td>
</tr>
<tr>
<td class=label ><fmt:message key="eXH.SegStart.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="seg_start"  name =seg_start size=25 maxlength=30 onKeyPress='return CheckForSpecCharsforID(event,document.forms[0].seg_start);' value='<%=seg_start%>' > <!--<img src='../../eCommon/images/mandatory.gif' align=middle>---></td>
<td class=label ><fmt:message key="eXH.SegEnd.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="seg_end"  name =seg_end size=25  maxlength=30  onKeyPress='return CheckForSpecCharsforID(event,document.forms[0].seg_end);' value='<%=seg_end%>'  > <img src='../../eCommon/images/mandatory.gif' align=middle><!--<img src='../../eCommon/images/mandatory.gif' align=middle>---></td>
<td class=label ><fmt:message key="eXH.ElmntSeparator.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="elmnt_separator"  name =elmnt_separator size=25 maxlength=30 onKeyPress='return CheckForSpecCharsforID(event,document.forms[0].elmnt_separator);' value='<%=XHDBAdapter.checkNull(elmnt_separator)%>' > </td>
</tr>
</table>

<table width="100%">
        <tr><td>
		<ul id="tablist" class="tablist"  style="display:none; padding-left:5px;">
			<li class="tablistitem" title="<fmt:message key='eXH.ControlStructure.Label' bundle='${xh_labels}'/>">
				<a onclick="callJSPs('tab1','formtable1')" class="tabA" id='tab1' >
					<span class="tabAspan" id="tab1_tabspan"><fmt:message key="eXH.ControlStructure.Label" bundle="${xh_labels}"/></span>
				</a>
			 </li>
			 <li class="tablistitem" title="<fmt:message key='Common.Profile.label' bundle='${common_labels}'/>">
				<a onclick="callJSPs('tab2','formtable2')" class="tabA" id="tab2" >
					<span class="tabAspan" id="tab2_tabspan"><fmt:message key="Common.Profile.label" bundle="${common_labels}"/></span>
				</a> 
		   </li>
		   </ul>
	 </td>

   </tr>

</table>
 <table cellspacing=0 name='formtable1' id='formtable1' id='formtable1' cellpadding=3 width='100%' height='35%' align=center style='display:none' >
<tr>
<td class=label >
	<fmt:message key="eXH.SegmentName.Label" bundle="${xh_labels}"/>
</td>
<td align=left>
<input type=text id="segment_type"  name ='segment_type' size='25' onBlur="if(this.value!='')searchSegmentType();else segment_type_id.value='' "  value=''  > 
<input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name='SegmentTypeSearch' id='SegmentTypeSearch'
value='?'    onClick="searchSegmentType()">
<img src='../../eCommon/images/mandatory.gif' align='middle'>
<input type="hidden" name="segment_type_id" id="segment_type_id" value=""></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr> 
<tr>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td class="BUTTON"><input class='button' type='button'  name='Add' id='Add' value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' onClick="funAddcrl('I')">
<input class='button' type='button'  name='Search' id='Search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="funSearchcrl('D')"></td>
</tr>
</table>	 
<table cellspacing=0 border=1 cellpadding=4s name='formtable2' id='formtable2' id='formtable2' width='100%' height='15%' align=center style='display:none'>
<thead>
<tr>
<th><fmt:message key="eXH.ProfileId.Label" bundle="${xh_labels}"/></th>
<th><fmt:message key="eXH.Standardcode.Label" bundle="${xh_labels}"/></th> 
<th><fmt:message key="eXH.Short Description.Label" bundle="${xh_labels}"/></th>
<th><fmt:message key="eXH.Long Description.Label" bundle="${xh_labels}"/></th>
 


</tr>
</thead>

<%
Connection conn = null;
ResultSet rset = null;
PreparedStatement pstmt = null ;
String exceptions="";
String strstyle="";
int j=0;
 try
    {   
       if(conn==null) conn = ConnectionManager.getConnection();
      		
     }catch(Exception exp){
         System.out.println("Error in calling getconnection method of  Interfacestandardselectmaster.jsp:"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
	 try
     {
  String sql="select PROFILE_ID,STANDARD_CODE,SHORT_DESC,LONG_DESC,VERSION_SPECIFIC,VERSION_DESC,GEOGRAPHY_SPECIFIC,GEOGRAPHY_DESC,APPLICATION_SPECIFIC,APPLICATION_ID,SITE_SPECIFIC,SITE_ID from  xh_standard_profile where STANDARD_CODE='"+standard_code+"'  ";


 pstmt = conn.prepareStatement(sql);
 rset = pstmt.executeQuery();
      while(rset.next())
      {

if((j%2)==0)
		  {
	strstyle = "class='QRYEVEN'";
		  }
		  else
		  {
strstyle = "class='QRYODD'";

		  }

	%>

<td <%=strstyle%> nowrap >
<a  href=" javascript:func1('<%= rset.getString(1)%>','<%= rset.getString(2)%>',
  '<%= rset.getString(3)%>','<%= rset.getString(4)%>','<%= rset.getString(5)%>','<%= rset.getString(6)%>','<%= rset.getString(7)%>','<%= rset.getString(8)%>','<%= rset.getString(9)%>','<%= rset.getString(10)%>','<%= rset.getString(11)%>','<%= rset.getString(12)%>');">
  &nbsp;<%=rset.getString(1).equals("null")?"":rset.getString(1) %>
</td>
<td <%=strstyle%> >
<%=XHDBAdapter.checkNull(rset.getString(2))%>
	</td>
<td <%=strstyle%>><%=XHDBAdapter.checkNull(rset.getString(3))%>	</td>
	<td <%=strstyle%>><%=XHDBAdapter.checkNull(rset.getString(4))%>
</td>
</tr>		
	
	<%
		j++;
	  }


	pstmt.close();
	rset.close();
	 }
	 catch(Exception exp) 
      {
         System.out.println("Error in calling dbrealted statements in  Interfacestandardselectmaster.jsp :"+exp.toString());
	     exp.printStackTrace(System.err);
		
        
      }
      try{
      ConnectionManager.returnConnection(conn);
	  }catch(Exception e)
		 {
	      System.out.println("Error in closing dbconnection in Interfacestandardselectmaster.jsp :"+e.toString());
	      e.printStackTrace(System.err);
	  }
%>


<%} catch(Exception e)
		 {
	      System.out.println("Error in closing dbconnection in  Interfacestandardselectmaster.jsp :"+e.toString());
	      e.printStackTrace(System.err);
	  } %>

<input type='hidden' name='tab' id='tab' value=''/>
<input type='hidden' name='rule' id='rule' value='<%=rule%>'/>
<input type="hidden" name="act_mode" id="act_mode" value='<%=mode%>'>

</table>
<table cellspacing=0 cellpadding=4 width='100%' height='10%'  name='formtable3' id='formtable3' id='formtable3'align=center style='display:none'>
<tr>
<td class=label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td class=label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td class=label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td class=label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td class=label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td  ><input class='button' type='button'  name='Add' id='Add' value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' onClick="FunAdd()" align=right ><input class='button' type='button'  name='Refresh' id='Refresh' value='<fmt:message key="Common.Refresh.label" bundle="${common_labels}"/>' onClick="refresh1(this)"  align=right disabled></td>
</tr>
</table>

<%
		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(con);
%>

<script>hide(); </script>


</form>
</BODY>
</HTML> 

