<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		  Edit History	   Name				   Rev.Date		Rev.Name		       Description
-------------------------------------------------------------------------------------------------------------------------------------
10/04/2024  50627    Twinkle Shah    10/04/2024		Ramesh Goli        ML-MMOH-CRF-2106
-------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@page  import="java.util.*, eCA.* "  contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/CAAllowPractConsultTag.js"></script>
	<script language="JavaScript"></script>
</head>
 <body onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
 
<% 	request.setCharacterEncoding("UTF-8");	
	Properties p;
	session = request.getSession(false);
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String mode	   = request.getParameter( "mode" ) ;
	String or_bean_id 						= "@CAAllowPractConsultTagBean";
	String or_bean_name 					= "eCA.CAAllowPractConsultTagBean";
	CAAllowPractConsultTagBean bean		= (CAAllowPractConsultTagBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	bean.clear() ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setMode( mode ) ;
	ArrayList practConsultTag = new ArrayList();

%>

<form name="allowPractConslTag" id="allowPractConslTag" method="post" target="messageFrame">
<table cellpadding=3 cellspacing=0 width="50%" align='center' class='grid' >
<tr>
	<td colspan=2 >
		<tr>		
			<td class=' columnheadercenter' NOWRAP width='2%'><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></td>
			<td class=' columnheadercenter' NOWRAP width='1%'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/>			
			<input type="checkbox" id="allChecked"  onClick="checkAll(this);"/>
			</td>
		</tr>
	<%  
		String totalRecord="";
	    int practConsultTagChk=0;
		
	    practConsultTag = bean.getallowPractConsultTag(locale) ;
		if(practConsultTag.size()>0){
			for(int i=0;i<practConsultTag.size();i++){
				String[] record = (String [])practConsultTag.get(i);
				if("Y".equals(record[2]))
				{
					practConsultTagChk++;
				} 
				%>
	            <tr>
					<td  class='gridData'><%=record[1]%> 
							<input type=hidden name=pract_type<%=i% id=pract_type<%=i%> value=<%=record[0]%>>	
							<input type=hidden name=exist_pract_tag_yn<%=i% id=exist_pract_tag_yn<%=i%> value=<%=record[3]%>>					
										
					</td>	
			        <td  class='gridData' ><input type=checkbox id="pract_consult_tag_yn" name="pract_consult_tag_yn<%=i%>"   value="<%=record[2]%>" <%=(record[2].equals("Y"))?"checked":""%> onClick="practConsutTag(this);"></td>
				</tr>
					
			<%	
			}
		}
				%>
	</td>
</tr>
</table>

<input type=hidden name='totalRecord' id='totalRecord' value='<%=practConsultTag.size()%>'/>	
<input type=hidden name='totalpractConsultTagChk' id='totalpractConsultTagChk' value='<%=practConsultTagChk%>'/>
<%
System.out.println("-practConsultTagChk---"+practConsultTagChk+"--practConsultTag.size()---"+practConsultTag.size());
%>
</form>

<script>
if(document.forms[0].totalRecord.value == document.forms[0].totalpractConsultTagChk.value)
document.forms[0].allChecked.checked=true; 
</script>
</body>

</html>
<%
putObjectInBean(or_bean_id, bean , request) ;  
%>

