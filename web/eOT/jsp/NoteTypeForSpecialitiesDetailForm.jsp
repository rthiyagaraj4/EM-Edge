<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,eCommon.Common.*,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>

<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eOT/js/NoteTypeForSpecialities.js"></script>
	<script language='javascript' src='../../eOT/js/Hashtable.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="NoteTypeForSpecialityDetailForm" id="NoteTypeForSpecialityDetailForm">
<%
  //OnMouseDown='CodeArrest()' onKeyDown="lockKey()"
   
   String from = checkForNull(request.getParameter( "from" )) ;
   String to =   checkForNull(request.getParameter( "to" ) ) ;
   String speciality_code=checkForNull(request.getParameter("speciality_code"));
   String totalSelected= checkForNull(request.getParameter("totalSelected"));
   String resp_id		=	(String)session.getValue("responsibility_id");//Changed against 43896
   //out.println("totalSelected"+totalSelected);
   //Cannonicalization of String 
   String empty = "".intern();
   String select_value="Y";
   String location_type_desc=empty;
   String note_type=empty;
   String note_type_desc=empty;
   String sel=empty;
   String select_checked=empty;
   String classValue= empty;
   String locn_type=empty;
   String select_flag1 = empty;
   String select_flag2 = empty;
   String select_flag3 = empty;
   String select_flag4 = empty;
   String disable_flag=empty;
   String deflt =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
  String holding_area =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.HoldingAreaNotes.Label","ot_labels");
  String surgeon_notes=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.SurgeonNotes.Label","ot_labels");
  String recovery_notes=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.RecoveryNotes.Label","ot_labels");
  int start = ( from.equals("") )?1:Integer.parseInt(from);
  int end =  ( to.equals("") )?14:Integer.parseInt(to);
  StringBuffer sbr = new StringBuffer();
  StringBuffer code = new StringBuffer();
  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rst=null;
/*
String strsql="SELECT DECODE(B.LOCN_TYPE, '10','Holding Area Notes', '30', 'Surgeon Notes', '40', 'Recovery Notes') LOCN_TYPE_DESC, A.NOTE_TYPE, A.NOTE_TYPE_DESC, DECODE (B.NOTE_TYPE, A.NOTE_TYPE,'Y','N') SEL, '1' SEQ FROM CA_NOTE_TYPE_LANG_VW A, OT_NOTE_TYPE_FOR_SPECIALTIES B WHERE A.NOTE_TYPE= B.NOTE_TYPE AND B.SPECIALTY_CODE = ? AND A.LANGUAGE_ID = '"+locale+"' UNION select null LOCN_TYPE_DESC, NOTE_TYPE, NOTE_TYPE_DESC,'N' SEL, '2' SEQ FROM CA_NOTE_TYPE_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND NVL(EFF_STATUS,'E') = 'E' ORDER BY 1,2";

*/
//Modified by DhanasekarV against 36651 on  17/12/2012

//String strsql="SELECT DECODE(B.LOCN_TYPE, '10','Holding Area Notes', '30', 'Surgeon Notes', '40', 'Recovery Notes') LOCN_TYPE_DESC, A.NOTE_TYPE, A.NOTE_TYPE_DESC, DECODE (B.NOTE_TYPE, A.NOTE_TYPE,'Y','N') SEL, '1' SEQ FROM CA_NOTE_TYPE_LANG_VW A, OT_NOTE_TYPE_FOR_SPECIALTIES B WHERE A.NOTE_TYPE= B.NOTE_TYPE AND B.SPECIALTY_CODE = ? AND A.LANGUAGE_ID = '"+locale+"' UNION select null LOCN_TYPE_DESC, A.NOTE_TYPE, A.NOTE_TYPE_DESC,'N' SEL, '2' SEQ   FROM CA_NOTE_TYPE_LANG_VW A, CA_NOTE_GROUP B WHERE LANGUAGE_ID =  '"+locale+"'AND NVL(A.EFF_STATUS,'E') = 'E'  AND  A.NOTE_GROUP_ID  = B.NOTE_GROUP  and  B.APPL_TASK_ID = 'OT_NOTES'  ORDER BY 1,2";  
String strsql="SELECT DECODE(B.LOCN_TYPE, '10','Holding Area Notes', '30', 'Surgeon Notes', '40', 'Recovery Notes') LOCN_TYPE_DESC, A.NOTE_TYPE, A.NOTE_TYPE_DESC, DECODE (B.NOTE_TYPE, A.NOTE_TYPE,'Y','N') SEL, '1' SEQ FROM CA_NOTE_TYPE_LANG_VW A, OT_NOTE_TYPE_FOR_SPECIALTIES B WHERE A.NOTE_TYPE= B.NOTE_TYPE AND B.SPECIALTY_CODE = ? AND A.LANGUAGE_ID = ? UNION  SELECT  null LOCN_TYPE_DESC, a.note_type, c.note_type_desc, 'N' SEL, '2' SEQ  FROM ca_note_type_for_resp a, ca_note_type_lang_vw c WHERE a.resp_id = ? AND a.note_type = c.note_type AND c.language_id = ?  AND a.privilege_type != '5' AND NVL(EFF_STATUS,'E') = 'E' AND c.note_group_id IN (SELECT note_group FROM ca_note_group WHERE appl_task_id = 'OT_NOTES')  ORDER BY 1,2";
  int maxRecord = 0;
  int i=1;
    try{
   		conn  =  ConnectionManager.getConnection(request);
		pstmt = conn.prepareStatement(strsql);
		pstmt.setString(1,speciality_code);
		pstmt.setString(2,locale);
		pstmt.setString(3,resp_id);//Changed against 43896
		pstmt.setString(4,locale);
		rst = pstmt.executeQuery();
		int total=0;
		while(rst.next()){
			total++;
		}
        maxRecord = total;
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		pstmt=conn.prepareStatement(strsql);
		pstmt.setString(1,speciality_code);
		pstmt.setString(2,locale);
		pstmt.setString(3,resp_id);//Changed against 43896
		pstmt.setString(4,locale);
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
<th class='columnheadercenter' nowrap > <!-- changed by yadav -->
	<fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
<th class='columnheadercenter'  nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
<%
		if ( start != 1 )
		for( int j=1; j<start; i++,j++ )
		rst.next() ;
		int k=0;
		while ( rst.next() && i<=end  ){

			classValue  = ( i % 2 == 0 )?"gridData":"gridData" ; // changed by yadav
			location_type_desc = checkForNull(rst.getString(1),"D").toUpperCase();
			note_type= checkForNull(rst.getString(2));
			note_type_desc=rst.getString(3);
			sel=rst.getString(4);
			disable_flag = ("Y".equals(sel))?"disabled":"";
			switch(location_type_desc.charAt(0)){
				case 'H' :  locn_type="10";   //Holding Area Notes
							select_flag1="";
							select_flag2="selected"; 
							select_flag3="";
							select_flag4="";
							break;  
				case 'R' :  locn_type="40" ; //Recovery Notes
							select_flag1="";
							select_flag2="";
							select_flag3=""; 
							select_flag4="selected";
							break;   
				case 'S' :  locn_type="30";  //Surgeon Notes
							select_flag1="";
							select_flag2="";
							select_flag3="selected"; 
						    select_flag4=""; 
						    break;   
								
			   default  :  locn_type="";  //default = blank;
						   select_flag1="selected"; 
						   select_flag2="";
						   select_flag3=""; 
						   select_flag4="";
						   break;   
				
			}
			sbr.append("<tr>");
			//constructing a List Item
			sbr.append("<td class='"+classValue+"'>");
			sbr.append("<select name=location_type_desc"+i+" id=location_type_desc"+i+" "+disable_flag+" onChange='valueChanged(this);' >");
			//default select
			sbr.append("<option value='' "+select_flag1+">");
			sbr.append("----------");
			sbr.append(deflt);
			sbr.append("----------");
			//holding Area 
			sbr.append("</option>");
			sbr.append("<option value='10' "+select_flag2+">");
			sbr.append(holding_area);
			sbr.append("</option>");
			//Surgeon Notes
			sbr.append("<option value='30' "+select_flag3+">");
			sbr.append(surgeon_notes);
			sbr.append("</option>");
			sbr.append("<option value='40' "+select_flag4+">");
			//Nursing Notes
			sbr.append(recovery_notes);
			sbr.append("</option>");
			sbr.append("</td>");	

			sbr.append("<td class='"+classValue+"'>"+note_type+"</td>");
		    sbr.append("<td class='"+classValue+"'>"+note_type_desc+"</td>");
   			if(sel.equals("Y")){
				   select_checked="checked";
			       select_value="Y";
				   code.append(locn_type).append("@@");
				   code.append(note_type).append("@@");
				   code.append(select_value);
				   sbr.append("<script>pushChkBox('"+i+"','"+code.toString()+"')</script>");
				   code.setLength(0);
				   k++;
			}else{
				select_checked="";
				select_value="N";
			}
			sbr.append("<td class='" + classValue+"'><input type=checkbox name=chk_select"+i+" id=chk_select"+i+" value="+select_value+" "+select_checked+" location_type_desc='"+locn_type+"' note_type="+note_type+" select_yn='"+select_value+"' onclick='validateCheckBox(this);' >");
//			sbr.append("<script>pushDBValues(chk_select"+i+");</script>");
//			out.println("I=== "+i);
			sbr.append("</td>");
		    sbr.append("</tr>");
			/*if("Y".equals(select_value))
			sbr.append("<script>pushDBValues(chk_select"+i+");</script>");*/

			if(totalSelected.length()>0){
			String tokens[] = totalSelected.split(",");
			
			for(int p = 0;p<tokens.length;p++){
				if(Integer.parseInt(tokens[p])==i)
					sbr.append("<script>assingListItemValue("+tokens[p]+");</script>");
			}
		}
		
   			i++;
		}

		sbr.append("<input type='hidden' name='check_code' id='check_code' value="+code.toString()+">");
		out.println(sbr.toString());

			
	%>
</table>
</center>
<br><center>
<% 
   }catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(rst!=null)	rst.close();
			if(pstmt!=null)	pstmt.close();
			if(sbr!=null)   sbr.setLength(0);
			if(code!=null)  code.setLength(0);
			ConnectionManager.returnConnection(conn,request);
		}catch(Exception e){}
	}
%>
<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>">
<input type="hidden" name="modified_flag" id="modified_flag" value="false" >
<input type="hidden" name="execute_flag" id="execute_flag" value="YES" >
<input type="hidden" name="start" id="start" value="<%=start%>" >
<input type="hidden" name="end" id="end" value="<%=end%>" >
<input type="hidden" name="sel" id="sel" value="<%=select_checked%>" >
<input type="hidden" name="totalSelected" id="totalSelected" value="<%=totalSelected%>" >
<input type="hidden" name="speciality_code" id="speciality_code" value="<%=speciality_code%>" >
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

