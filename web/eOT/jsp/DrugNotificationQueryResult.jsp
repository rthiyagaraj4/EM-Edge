<!DOCTYPE html>


<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8"  %>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = (String)session.getAttribute("LOCALE");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language='javascript' src='../../eOT/js/DrugNotification.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language='javascript' src='../../eOT/js/Hashtable.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	

</head>

<BODY  class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()" >
<form name="DrugNotificationQryResultForm" id="DrugNotificationQryResultForm" target="messageFrame">
<%
   String empty = "".intern();
   String whereClause = checkForNull(request.getParameter("whereclause"));
   String from = checkForNull(request.getParameter( "from" ) ) ;
   String to =   checkForNull(request.getParameter( "to" ) ) ;
   String def_type=request.getParameter("def_type") ;
   String drug_desc=checkForNull(request.getParameter("drug_desc"));
    String totalSelected= checkForNull(request.getParameter("totalSelected"));
 // String mode =checkForNull(request.getParameter("mode") );
   String disable="";
   int start = ( from.equals("") )?1:Integer.parseInt(from);
   int end =  ( to.equals("") )?14:Integer.parseInt(to);
   
   Connection conn = null;
   Connection con = null;
   PreparedStatement pstmt = null;
   PreparedStatement pstmt_exist = null;
   ResultSet rst=null;
   ResultSet rset=null;
	
   StringBuilder sbr = new StringBuilder();
   String SQL = empty;
   String rec_exist ="SELECT COUNT(1) FROM OT_DRUGS_FOR_NOTIFICATION WHERE DEFN_TYPE =? AND DRUG = ? and rownum =1";
   switch(def_type.charAt(0)){
	   case 'D': SQL = "SELECT A.DRUG_CODE, A.DRUG_DESC, DECODE(B.DRUG,NULL,'N',NVL(B.NOTIFY_PRE_ANESTHESIA_YN,'N')) FROM PH_DRUG_LANG_VW A, OT_DRUGS_FOR_NOTIFICATION B WHERE A.LANGUAGE_ID='"+locale+"' AND A.DRUG_CODE = B.DRUG(+) AND B.DEFN_TYPE(+)	= 'D'";
	   whereClause=whereClause+( (drug_desc.length()>0)?" AND UPPER(A.DRUG_DESC) LIKE  UPPER('"+drug_desc+"%')":"");
		SQL=SQL+whereClause;
	   break;
	  
	   case 'G': SQL = "SELECT A.GENERIC_ID, A. GENERIC_NAME, DECODE(B.DRUG,NULL,'N',NVL(B.NOTIFY_PRE_ANESTHESIA_YN,'N')) FROM  PH_GENERIC_NAME_LANG_VW A, OT_DRUGS_FOR_NOTIFICATION B WHERE A.LANGUAGE_ID='"+locale+"' AND A. GENERIC_ID = B.DRUG(+) AND B.DEFN_TYPE(+)	= 'G' AND NVL(EFF_STATUS,'E') = 'E' ";
	   whereClause=whereClause+( (drug_desc.length()>0)?" and UPPER(A.DRUG_DESC) LIKE UPPER('"+drug_desc+"%')":"");
		SQL=SQL+whereClause;
	   break;
   }

   String ord[] = request.getParameterValues("orderbycolumns");
		if ( !(ord == null || ord .equals("")) ){
			SQL=SQL+" order by ";
			for ( int i=0;i < ord.length;i++ ){
			 	if ( i == ord.length - 1 )
					SQL=SQL+ord[i];
				else
					SQL=SQL+ord[i]+",";
			}
		}else	
			SQL=SQL+" order by 2";
	
	//out.println(SQL);
   int maxRecord = 0;
   int i=1;
   try{
 		conn  =  ConnectionManager.getConnection(request);
		pstmt = conn.prepareStatement(SQL,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rst = pstmt.executeQuery();
		//getting maximum record
		rst.last();	maxRecord = rst.getRow();
		if(maxRecord == 0){
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}
		//again move the resultset pointer to initial position
		rst.beforeFirst();
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
<br>
</p>
<table border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
<th class="columnHeaderCenter">
	<fmt:message key="ePH.DrugDescription.label" bundle="${ph_labels}"/>
</th>
<th class="columnHeaderCenter">
	<fmt:message key="eOT.NotifyAtPreAnaesthesia.Label" bundle="${ot_labels}"/>
</th>
<!--
<td class="columnHeaderCenter">
	<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
</td>
-->
<%
		String notify_pre_anesthesia_checked = empty;
		String drug_code = empty;
		String drug_description = empty; 
		String notify_pre_anesthesia_yn = empty;
		String db_action = empty;
		if ( start != 1 ) rst.absolute(start-1);
		i=start;
		con = ConnectionManager.getConnection(request);
		pstmt_exist = con.prepareStatement(rec_exist);
		String classValue= "";
		while ( rst.next() && i<=end  ){
			classValue = ( i % 2 == 0 )?"QRYEVENSMALL":"QRYODDSMALL" ;
 			drug_code = rst.getString(1);
 			drug_description = rst.getString(2);
 			notify_pre_anesthesia_yn = rst.getString(3);
			pstmt_exist.setString(1,def_type);
			pstmt_exist.setString(2,drug_code);
			rset = pstmt_exist.executeQuery();
			while(rset.next()){
				db_action = (rset.getInt(1)==0)?"I":"U";
				disable = (rset.getInt(1)==0)?"disabled":"";
			}
			rset.close();
			sbr.append("<tr>");
			
			sbr.append("<input type='hidden' name=drug_code"+i ).append(" id=drug_code"+i).append(" value='"+drug_code).append("' >");
			
			sbr.append("<td class='"+classValue+"'>"+drug_description+"</td>");
			notify_pre_anesthesia_checked = (notify_pre_anesthesia_yn.equals("Y"))?"checked":"";
			
			sbr.append("<td class='").append(classValue).append("'><input type=checkbox name='notify_pre_anesthesia_yn"+i).append("' id='notify_pre_anesthesia_yn"+i).append("' ").append(notify_pre_anesthesia_checked).append(" db_action='"+db_action+"' row_id='"+i+"' onclick='registerInRecordQueue(this);'></td>");
			
			//sbr.append("<td class='"+classValue+"'><input type=hidden name=chk_select"+i+"  row_id='"+i+"' onclick='registerInRecordQueue(this);' "+disable+">");
			
			sbr.append("</td></tr>");
			//Added for CheckBox Selection
				if(totalSelected.length()>0){
			String tokens[] = totalSelected.split(",");

			for(int p = 0;p<tokens.length;p++){
				if(Integer.parseInt(tokens[p])==i)
					sbr.append("<script>assignListItemValue("+tokens[p]+");</script>");
			}
		}
   			i++;
		}
		out.println(sbr.toString());
	%>
</table>
</center>
<br><center>
<% 
   }catch(Exception e){
		e.printStackTrace();
		out.println("DrugNotificationQueryResult.jsp : "+e);
	}finally{
		try{
			if(rst!=null)	rst.close();
			if(rset!=null)  rset.close();
			if(pstmt!=null)	pstmt.close();
			if(pstmt_exist!=null)	pstmt_exist.close();
			ConnectionManager.returnConnection(conn,request);
			ConnectionManager.returnConnection(con,request);
			sbr.setLength(0);
		}catch(Exception e){}
	}
%>
<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>" >
<input type="hidden" name="start" id="start" value="<%=start%>" >
<input type="hidden" name="end" id="end" value="<%=end%>" >	
<input type="hidden" name="locale" id="locale" value="<%=locale%>" >	
<input type="hidden" name="def_type" id="def_type" value="<%=def_type%>" >
<input type="hidden" name="totalSelected" id="totalSelected" value="<%=totalSelected%>" >
	<input type='hidden' name='row_count' id='row_count' value="<%=i%>">

</form>
</BODY>
</HTML>



