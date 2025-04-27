<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<form name="AltDisplocnDeatil" id="AltDisplocnDeatil">
<html>
<head>
<% 
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
<script language="Javascript" src="../../eCommon/js/common.js"></script>
<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
<script language="Javascript" src="../../ePH/js/AltDispLocn.js"></script>
<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">

 
<%
	String bean_id					=   "AltDispLocnBean" ;
	String bean_name				=	"ePH.AltDispLocnBean";
    String ord_src_code				=  request.getParameter("ord_src_code");	  
	String order_fcy				=	request.getParameter("order_fcy");
	String ord_src_type				=	request.getParameter("ORD_SRC_TYPE");
	//out.println("ord_src_type-->"+ord_src_type);
	String perform_fcy				=	request.getParameter("perform_fcy");
	String disp_loc				    =	request.getParameter("disp_loc");
	String disp_loc_code            =   request.getParameter("disp_loc_code");
	String eff_status               =   request.getParameter("eff_status");
	String mode                     =   request.getParameter("mode");
	String day_type                 =   request.getParameter("day_type");
	String rout_level               =   request.getParameter("rout_level");
	String rout_code                =   request.getParameter("rout_code");
	String prio                     =   request.getParameter("prio");
//String source    =   request.getQueryString();
	
	if(eff_status == null){
        eff_status="";
	}
	if(disp_loc_code == null){disp_loc_code=disp_loc;}
	
	String select_status	=	"";
    String select_flag	=	"";
	String flag				=	"";
	String frmtime          =   "";
	String totime           =   "";
	String repeat			=	"";
	String classvalue	    =   "";
	String prevCode="";
	String butnFlag="";
	int i=1;
	ArrayList altdisplocns			= null;
    if ( bean_id == null || bean_id.equals( "" ) ) 	return ;
  
	 AltDispLocnBean bean=(AltDispLocnBean)getBeanObject( bean_id, bean_name, request);
	 bean.setLanguageId(locale);

	 bean.clear() ;
	
	 altdisplocns=bean.getaltdisplocmodify22(ord_src_type,perform_fcy,order_fcy,ord_src_code,day_type,disp_loc_code,rout_level,rout_code,prio);
%>

<TABLE BORDER="2" CELLPADDING="0" CELLSPACING="0" WIDTH="92%" ALIGN="center" id="AltDspLoc">	
	<tr>
		<th> <fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></th>
		<th><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.totime.label" bundle="${common_labels}"/></th>
		<th>&nbsp;</th>
		<th><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
	</tr>
	<tr>
	<%
		HashMap record=new HashMap();
		String code="",desc="";
		for(int t=0;t<altdisplocns.size();t++){
			 select_status		=	"";
           select_flag		=	"N";
			 record	=(HashMap)altdisplocns.get((t));
			 code		=	(String)record.get("code");
			 desc		=	(String)record.get("desc");
			 flag		=	(String)record.get("flag");
			 eff_status =(String)record.get("eff_status");
			 if(mode.equals("2")){
			      eff_status    =	(String)record.get("eff_status");
			 }
			 frmtime	=   (String)record.get("frmtime");
			 totime		=   (String)record.get("totime");
			 repeat	=(String)record.get("repeat");
		    if(frmtime==null)
				frmtime="";
			if(totime==null)
				totime="";

 if(eff_status.equals("E")){
			 if(flag.equals("I")){
				select_status="checked";
				select_flag="Y";
			 
			 } }else if( eff_status.equals("D")){
               select_status="unchecked";
			   select_flag="Y";
			 
			 }
			 if (prevCode.equals("")) butnFlag="Y";
			 else if(prevCode.equals(code)) butnFlag="N";
			 else butnFlag="Y";
		     
			 if(!code.equals(disp_loc_code)){
				if ( i % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
		%>
		<td width="10%" class="<%=classvalue%>"><%=desc%>		</td>
		<td class="<%=classvalue%>" width="10%"><input type=text name="frmtime_<%=i%>" id="frmtime_<%=i%>" value="<%=frmtime%>"  maxlength='5' size='5' onkeypress="return allowPositiveNumber()" onblur="appedzero(this);validtime(this,totime_<%=i%>);altdisplocnselect(select_<%=i%>,<%=i%>);">
		</td>
		<td class="<%=classvalue%>" width="10%"><input type=text name="totime_<%=i%>" id="totime_<%=i%>" value="<%=totime%>"  maxlength='5' size='5' onkeypress="return allowPositiveNumber()" onblur="toggleCheckBox(this,'<%=i%>',true);appedzero(this);validtime(this,frmtime_<%=i%>);altdisplocnselect(select_<%=i%>,<%=i%>);">
		</td>


		<%if(select_status=="checked" && butnFlag=="Y"){%>
		<td class="<%=classvalue%>" align="center" width="2%" >
		 <input type='button' name="addRow_<%=i%>" id="addRow_<%=i%>" class='button' align="right" onclick="generateRow(this,<%=i%>,'<%=desc%>','<%=code%>')" value=' V '> 
		</td>
 <%}else if(select_status=="checked" && butnFlag=="N"){%>
      <td class="<%=classvalue%>" align="center" width="2%" >
		 <input type='button' name="rem_<%=i%>" id="rem_<%=i%>" class='button' align="right" onClick="setflag(<%=i%>);altdisplocnselect(select_<%=i%>,'<%=i%>');removeRow(this);" value=' X ' > 
	  </td>
 <%}else{%>
		<td class="<%=classvalue%>" align="center" width="2%" >
		 <input type='button' style="visibility:hidden" name="addRow_<%=i%>" id="addRow_<%=i%>" class='button' align="right" onclick="generateRow(this,<%=i%>,'<%=desc%>','<%=code%>')" value=' V '> 
		</td>
<%}%>


		<td class="<%=classvalue%>" width="6%"><input type=checkbox name="select_<%=i%>" id="select_<%=i%>"  <%=select_status%> onClick="assignValue(this,<%=i%>);clearValue(this,'<%=i%>');altdisplocnselect(this,<%=i%>);">
		</td>
			
		
		<input type=hidden name="code_<%=i%>" id="code_<%=i%>" value=<%=code%>>
		<input type=hidden name="flag_<%=i%>" id="flag_<%=i%>" value=<%=select_flag%>>
		<input type=hidden name="number_<%=i%>" id="number_<%=i%>" value=<%=i%>>
		<input type=hidden name="arrVal_<%=i%>" id="arrVal_<%=i%>" value="<%=frmtime%>">
		<input type=hidden name="dbVal_<%=i%>" id="dbVal_<%=i%>" value="<%=frmtime%>">
		<input type=hidden name="repeat_<%=i%>" id="repeat_<%=i%>" value="<%=repeat%>"> 
			</tr>
		<%
		    if(eff_status.equals("E") ){
		%>
		<input type=hidden name="enable_<%=i%>" id="enable_<%=i%>" value="<%=eff_status%>">
		<%
				}else{
		%>
		<input type=hidden name="enable_<%=i%>" id="enable_<%=i%>" value="<%=eff_status%>">
		<%
				}
		%>
		
		
		
		<%
			i++;
		   }
		   prevCode=code;

		}
		%>
</table>
<INPUT TYPE="hidden"	name="count" id="count"	VALUE="<%=i%>">
</form>
</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>		

