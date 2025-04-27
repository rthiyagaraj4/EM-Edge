<!DOCTYPE html>
	<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="eOR.*, java.sql.*, java.util.*,java.text.*,eOR.Common.*,eCommon.Common.*,eOH.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>
<%@ page import ="eOH.*, eOH.Common.*,java.util.ArrayList,java.util.Hashtable,java.util.Map "   %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language='javascript' src='../js/OrderSet.js'></script>
    <script language='javascript' src='../../eOH/js/MTasksLink.js'></script>
	<script language="javascript" src="../../eOH/js/Hashtable.js"></script>

	
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

</head>
 <jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
    Hashtable hash		= (Hashtable)xmlObj.parseXMLString( request ) ;
	hash				= (Hashtable)hash.get( "SEARCH" ) ;
	String bean_mt_id		= "@MTLinkBean";
	String bean_mt_name	= "eOH.MTLinkBean";
	MTLinkBean bean_mt= (MTLinkBean)mh.getBeanObject( bean_mt_id, request, bean_mt_name );
	HashMap checkedRow=(HashMap)bean_mt.getCheckedRow();
	HashMap checkedMap=(HashMap)bean_mt.getCheckedMap();
	
	String bean_id = "Or_CareSet" ;
	String bean_name = "eOR.CareSetBean";
	CareSetBean bean = (CareSetBean)getBeanObject( bean_id,  bean_name, request ) ;
	bean.setLanguageId(localeName);
	String classValue ="";
	String nextPrevFlag		= eOR.Common.ChkDef.defaultString(request.getParameter("nextPrevFlag"));
	String order_category	= request.getParameter("order_category");  	
	String selAlphabet	= request.getParameter("selAlphabet");  
    String from = checkForNull(request.getParameter( "from" )) ;
    String to =   checkForNull(request.getParameter( "to" ) ) ;
    String treatment_code=checkForNull(request.getParameter("treatment_code"));
    
    String multiple_yn=checkForNull(request.getParameter("multiple_yn"));
    String totalSelected=request.getParameter("totalSelected");
    String select_value="Y";
    String task_code = "";
    String task_desc = "";
    String seq_no = checkForNull(request.getParameter("seq_no"));
    String mode="";
    String sel="";
    String select_checked="";
    
	int start = ( from.equals("") )?1:Integer.parseInt(from);
    int end =  ( to.equals("") )?7:Integer.parseInt(to);
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rst=null;
	String strsql="";
	StringBuffer sqlBuffer = new StringBuffer();
	
	 if(!selAlphabet.equals("Others")){
		 //commented by parul on 02/08/2010 for 23013
	  //strsql="SELECT A.TASK_CODE, B.TASK_DESC,SEQ_NO, 'Y' SEL FROM OH_TREATMENT_TASKS A, OH_TASKS_LANG_VW B WHERE   A.TASK_CODE LIKE UPPER('"+selAlphabet+"%')AND A.TASK_CODE = B.TASK_CODE AND B.LANGUAGE_ID = ?   AND A.TRMT_CODE = ?  UNION SELECT TASK_CODE, TASK_DESC,NULL SEQ_NO, 'N' SEL FROM OH_TASKS_LANG_VW WHERE LANGUAGE_ID = ?  AND TASK_CODE LIKE UPPER('"+selAlphabet+"%') AND TASK_CODE NOT IN (SELECT TASK_CODE FROM OH_TREATMENT_TASKS WHERE TRMT_CODE = ?) ORDER BY 4 DESC, 3, 2";
	 strsql="SELECT   A.TASK_CODE, B.TASK_DESC, SEQ_NO, 'Y' SEL FROM OH_TREATMENT_TASKS A, OH_TASKS_LANG_VW B WHERE UPPER(B.TASK_DESC) LIKE  UPPER('"+selAlphabet+"%') AND A.TASK_CODE = B.TASK_CODE AND B.LANGUAGE_ID = ? AND A.TRMT_CODE = ? UNION SELECT   TASK_CODE, TASK_DESC, NULL SEQ_NO, 'N' SEL FROM OH_TASKS_LANG_VW WHERE LANGUAGE_ID = ? AND UPPER(TASK_DESC) LIKE  UPPER('"+selAlphabet+"%') AND TASK_CODE NOT IN (SELECT TASK_CODE FROM OH_TREATMENT_TASKS WHERE TRMT_CODE = ?) ORDER BY 4 DESC, 3, 2";


	 }
	 else if(selAlphabet.equals("Others")){    

		  //sqlBuffer.append("SELECT A.TASK_CODE, B.TASK_DESC,SEQ_NO, 'Y' SEL FROM OH_TREATMENT_TASKS A, OH_TASKS_LANG_VW B WHERE   A.TASK_CODE NOT BETWEEN UPPER('A%') AND UPPER('_Z%') AND A.TASK_CODE = B.TASK_CODE AND B.LANGUAGE_ID = ?   AND A.TRMT_CODE = ?  UNION SELECT TASK_CODE, TASK_DESC,NULL SEQ_NO, 'N' SEL FROM OH_TASKS_LANG_VW WHERE LANGUAGE_ID = ?  AND TASK_CODE NOT BETWEEN UPPER('A%') AND UPPER('_Z%') AND TASK_CODE NOT IN (SELECT TASK_CODE FROM OH_TREATMENT_TASKS WHERE TRMT_CODE = ?) ORDER BY 4 DESC, 3, 2");

		   //Added by Anitha J on 9/09/2010 for IN023771
		   strsql="SELECT A.TASK_CODE, B.TASK_DESC,SEQ_NO, 'Y' SEL FROM OH_TREATMENT_TASKS A, OH_TASKS_LANG_VW B WHERE   A.TASK_CODE NOT BETWEEN UPPER('A%') AND UPPER('_Z%') AND A.TASK_CODE = B.TASK_CODE AND B.LANGUAGE_ID = ?   AND A.TRMT_CODE = ?  UNION SELECT TASK_CODE, TASK_DESC,NULL SEQ_NO, 'N' SEL FROM OH_TASKS_LANG_VW WHERE LANGUAGE_ID = ?  AND TASK_CODE NOT BETWEEN UPPER('A%') AND UPPER('_Z%') AND TASK_CODE NOT IN (SELECT TASK_CODE FROM OH_TREATMENT_TASKS WHERE TRMT_CODE = ?) ORDER BY 4 DESC, 3, 2";


	 }

			int maxRecord = 0;
			int i=1;
			try{
		   		conn  =  ConnectionManager.getConnection(request);
				
				pstmt = conn.prepareStatement(strsql);
					

				pstmt.setString(1,locale);
				pstmt.setString(2,treatment_code);
				pstmt.setString(3,locale);
				pstmt.setString(4,treatment_code);
				rst = pstmt.executeQuery();
				int total=0;
				while(rst.next()){
					total++;
				}
				maxRecord = total;
				

				if(maxRecord == 0){
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				}
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				pstmt=conn.prepareStatement(strsql);
				pstmt.setString(1,locale);
				pstmt.setString(2,treatment_code);
				pstmt.setString(3,locale);
				pstmt.setString(4,treatment_code);
				rst = pstmt.executeQuery();
		%>	
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="detailLowerForm" id="detailLowerForm" >
<input type="hidden" name="selAlphabet" id="selAlphabet" value="<%=selAlphabet%>" >

<table align='right' border=0>
			<tr>
				<td>
				<%
					if ( !(start <= 1) )
					out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='previous();'>" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</font>");
					if ( !( (start+7) > maxRecord ) )
					out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='next();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</font>");
				%>
				</td>
			</tr>
		</table>
		<br><br>
		<table border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
			<tr>
				<td class='columnHeader'  width="30%" align="center">
					<fmt:message key="eOH.TaskCode.Label" bundle="${oh_labels}"/>
				</td>
				<td class="columnHeader" width='30%' align="center">
					<fmt:message key="eOH.TaskDescription.Label" bundle="${oh_labels}"/>
				</td>
				<td class="columnHeader" width='30%' align="center">
					<fmt:message key="eOR.SeqNo.label" bundle="${or_labels}"/>
				</td>
				<td class="columnHeader" width='30%' align="center">
					<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
				</td>
			</tr>
			<% //if(maxRecord != 0){
				if ( start != 1 )
				for( int j=1; j<start; i++,j++ )
				rst.next() ;
				//String classValue= " ";
				int k=0;
				while ( rst.next() && i<=end  ){
                
			
				if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;
					task_code = checkForNull(rst.getString(1));
					task_desc= checkForNull(rst.getString(2));
					seq_no= checkForNull(rst.getString(3));
					
					
					if(!(seq_no.equals("") && seq_no.equals("null") && seq_no.equals(null))){
						mode = "update";
					}
					else{
						mode = "";
					}
					
					sel=checkForNull(rst.getString(4));
					if (sel.equals("Y")){
						   select_checked="checked";
						   select_value="Y";
							k++;
					}else{
						select_checked="";
						select_value="N";
					}
					
					for(int l=0;l<checkedRow.size();l++)
					{
					if(checkedRow.containsKey(selAlphabet)==true)
						{
						 if(checkedMap.containsKey(task_code)==true)
							{
							seq_no=(String)checkedMap.get(task_code);
							select_checked="checked";
						    select_value="Y";
							}
						 else
							{
							 select_checked="";
						     select_value="N";
							}
						}
					}
					out.println("<tr>");
					out.println("<td class='" + classValue+"' width='30%'>"+task_code+"</td>");
				    out.println("<td class='" + classValue+"' width='30%'>"+task_desc+"</td>");
					out.println("<td class='" + classValue+"' width='20%'><input type='text' name='seq_no"+i+"' id='seq_no"+i+"' size='3' maxlength='3' value='"+seq_no+"' task_code='"+task_code+"'task_desc='"+task_desc+"' seq_no='"+seq_no+"'selAlphabet='"+selAlphabet+"' select_yn='"+select_value+"' db_change_seq_yn='N' value_yn='"+seq_no+"' mode='"+mode+"' onBlur=\"return validateSeqNo(this,'"+i+"')\"; onKeyPress='return allowNumOnly(event);'></td>");
			
			
					out.println("<td class='" + classValue+"' width='30%'><input type=checkbox name=chk_select"+i+" value="+select_value+" "+select_checked+" task_code='"+task_code+"'task_desc='"+task_desc+"'sel='"+sel+"'selAlphabet='"+selAlphabet+"' db_change='N' seq_no='"+seq_no+"' select_yn='"+select_value+"' mode='"+mode+"' onclick=\" setCheckedRow(this);removeCheckedRow(this);\">");
				    
			
					out.println("</td>");
					out.println("</tr>");
					if(totalSelected!=null && !totalSelected.equals(null) && totalSelected.length()>0){
						//out.println("totalSelected:=="+totalSelected);
						//out.println("<script>clearListItemValue("+i+");</script>");
						String tokens[] = totalSelected.split(",");
						for(int p = 0;p<tokens.length;p++){
							if(Integer.parseInt(tokens[p])==i){
								// out.println(request.getParameter("chk_select"+i));
								out.println("<script>assingListItemValue("+tokens[p]+");</script>");
							}
						}
					}
				 
                 	i++;
				}

				//}
			%>
		</table>
		</center>
		<br><center>
		<% 
		   }catch(Exception e){
				out.println("MTasksLinkDetailForm============= : "+e);
				e.printStackTrace();
			}finally{
				try{
					if(rst!=null)	rst.close();
					if(pstmt!=null)	pstmt.close();
					ConnectionManager.returnConnection(conn,request);
				}catch(Exception e){}
			}
		%>
		<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>">
		<input type="hidden" name="totalSelected" id="totalSelected" value="<%=totalSelected%>" >
		<input type="hidden" name="modified_flag" id="modified_flag" value="false" >
		<input type="hidden" name="execute_flag" id="execute_flag" value="YES" >
		<input type="hidden" name="start" id="start" value="<%=start%>" >
		<input type="hidden" name="end" id="end" value="<%=end%>" >
		<input type="hidden" name="sel" id="sel" value="<%=select_checked%>" >
		<input type="hidden" name="treatment_code" id="treatment_code" value="<%=treatment_code%>" >
		
		<input type="hidden" name="task_desc" id="task_desc" value="<%=task_desc%>" >
		<input type="hidden" name="task_code" id="task_code" value="<%=task_code%>" >
		<input type="hidden" name="seq_no1" id="seq_no1" value="<%=seq_no%>" >
		<input type="hidden" name="mode" id="mode" value="<%=mode%>" >
		<input type="hidden" name="multiple_yn" id="multiple_yn" value="<%=multiple_yn%>" >
		<input type="hidden" name="maxRecord" id="maxRecord" value="<%=maxRecord%>">
		
		<input type="hidden" name="mode" id="mode" value="1">
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type="hidden" name="bean_mt_id" id="bean_mt_id" value="<%=bean_mt_id%>">
		<input type="hidden" name="bean_mt_name" id="bean_mt_name" value="<%=bean_mt_name%>">
		<input type='hidden' name='tabType' id='tabType' value="C" >
		<input type='hidden' name='nextPrevFlag' id='nextPrevFlag' value='<%=nextPrevFlag%>' >
		<input type='hidden' name='order_category' id='order_category' value='<%=order_category%>' >
		<input type='hidden' name='detailPageMode' id='detailPageMode' value='<%=bean.getDetailPageMode()%>' >
		<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
		<input type='hidden' name='locale' id='locale' value="<%=locale%>">

     </center>
		



<%

		//putObjectInBean(bean_id,bean,request);
 
%>
</form>
</body>
<!-- <script>
	showIncluded('<%=order_category%>');
</script> -->
</html>


