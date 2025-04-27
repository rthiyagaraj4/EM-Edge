<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<%
	String locale = (String)session.getAttribute("LOCALE");
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>

<%! 
	String encode(String data){	  
	String outDat = "";
	byte byteData[] = data.getBytes();
	for (int i=0; i<byteData.length; i++){
		outDat = outDat +"%"+Integer.toHexString((int)byteData[i]);
	}
	return(outDat);
	}
%>

<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script Language="JavaScript"  src="../../eCommon/js/CommonLookup.js"></Script>
<script language='javascript' src='../../eOT/js/Checklistsmodified.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!--body onLoad="parent.parent.commontoolbarFrame.document.forms[0].apply.disabled=false" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'-->
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'> <!--Modified Against GHL-SCF-1519-->
<%
	String source=request.getParameter("source");
	String mode=request.getParameter("update_mode_yn");
	if (mode.equals("modify")){
		mode="U";
	}else {
		mode="I";
	}
	String checklist_item_srl_no =""; 
	String disable_flag="";
	String checklist_code = checkForNull(request.getParameter("checklist_code"));
	String mesg =checkForNull(request.getParameter("mesg"));
	String description="";
	String checklist_item_code="";
	String sql="";
	//Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 23/02/2013
	sql="SELECT A.CHECKLIST_ITEM_CODE, B.DESCRIPTION, A.CHECKLIST_ITEM_SRL_NO ,A.APPL_FOR_INTRA_OPER FROM OT_CHECKLIST_DTL A, OT_CHECKLIST_ITEMS B WHERE A.CHECKLIST_ITEM_CODE = B.CHECKLIST_ITEM_CODE AND A.CHECKLIST_CODE 	= ? ORDER BY 3";
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
try
{
	con=ConnectionManager.getConnection(request);
	stmt=con.prepareStatement(sql);
	stmt.setString(1,checklist_code);
	rs=stmt.executeQuery();
	int index=0;
	while(rs.next())
	{
		index++;
		checklist_item_code=rs.getString(1);
		checklist_item_srl_no=rs.getString(3);
		description=java.net.URLEncoder.encode(checkForNull(rs.getString(2)));//ML-MMOH-SCF-1017
		//Maheshwaran K added for the CHL-CRF-0043 [IN:035927] as on 23/02/2013
		//Start
		String intra_operative_sel=rs.getString(4);
		out.println("<script>loadDBRows('"+checklist_item_srl_no+"','"+checklist_item_code+"','"+java.net.URLDecoder.decode(description)+"','"+index+"','L','"+intra_operative_sel+"');</script>");//ML-MMOH-SCF-1017
		//End
	}
	out.println("<script>refresh()</script>");	
	}catch(Exception e)
	{
		e.printStackTrace();
		System.err.println("Error in Checklist records.jsp"+e.getMessage());
	}finally{
	try{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(con!=null) 
		ConnectionManager.returnConnection(con,request);
	}catch(Exception e){e.printStackTrace();}
	}
%>

<form name="ChecklistRecordForm" id="ChecklistRecordForm"  onload='FocusFirstElement()'  action="" method="" target=""> 
<input type='hidden' name='mesg' id='mesg' value='<%=mesg%>'>
<table border=0 cellspacing=0 cellpadding=0 width='100%'  align=center>
<tr>
	<td class=label width='25%'>
		<fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%'>
		<input type="text" name="checklist_item_srl_no" id="checklist_item_srl_no" value="" size=4 maxlength=3  onblur="ChkNumber(this);"><!--//Maheshwaran K modified the maxlength-->
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
	<td class=label width='25%'>
		<fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%'>
		<input type="text" name="description" id="description" value=""  size='20'  onBlur="if(this.value!='')callChecklistcode(checklist_item_code,description);else checklist_item_code.value=''">
		<input type="button" class="button" name="generic_search" id="generic_search" value="?"  onClick='callChecklistcode(checklist_item_code,description);'>
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>

<tr>
	<td class=label width='25%'>
		<fmt:message key="eOT.ChecklistItemCode.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields' width='25%'>
		<input type="text" name="checklist_item_code" id="checklist_item_code" value="" size='4' maxlength='4'readonly >
	</td>
	<td width='25%'></td>
 </tr>
<!--Maheshwaran K added for the CHL-CRF-0043 [IN:035927] as on 22/02/2013-->
<!--Start-->
<tr>
	<td class=label width='15%'>
		<fmt:message key="eOT.IntraOperative.Label" bundle="${ot_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="checkbox" name="intra_operative_chk" id="intra_operative_chk" value="" onclick=" if(this.checked==true){ 	document.getElementById('intra_operative_sel_id').style.visibility = ''; document.getElementById('intra_operative_sel').disabled = false; var selectobject=document.getElementById('intra_operative_sel'); for (var i=0; i<selectobject.length; i++){ if (selectobject.options[i].value == 'N' ) selectobject.remove(i);	}}else{  document.getElementById('intra_operative_sel').options[2] = new Option('Select', 'N',true,true); document.getElementById('intra_operative_sel').options[2].selected;document.getElementById('intra_operative_sel_id').style.visibility = 'hidden';}">
	</td>
	<td class='fields' width='25%' id='intra_operative_sel_id' style='visibility:hidden'>
		<select name="intra_operative_sel" id="intra_operative_sel"  >
		<option value="N">Select</option>
		<option value="B">Both</option>
		<option value="I">Intra Operative</option>
		</select>
	</td>
	<td width='25%'></td>
	<td class=label align='left' nowrap width='20%'>
	    <input type='button' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='addRow();'<%=disable_flag%> >
		<input type='button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow();'<%=disable_flag%> >
	</td> 
</tr>
<!--End-->
</table>
<!-- added by Yadav for Amazon Changes-->
	<%if(!imgUrl.equals("")){ %>
		 <img src='<%=imgUrl%>' width='100%' height='15'/> 
	<%}%>
<!-- end -->
<input type='hidden' name='recId' id='recId' value=''>
<input type='hidden' name='params' id='params' value='<%=source%>'>
<input type='hidden' name='mode' id='mode' value='I'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='checklist_code' id='checklist_code' value="<%=checklist_code%>">
</form>
</body>
</html>

