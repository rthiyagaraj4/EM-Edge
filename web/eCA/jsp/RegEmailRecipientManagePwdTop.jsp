<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.net.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<html>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>
<%
try{

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String title=request.getParameter("title")==null?"":request.getParameter("title");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
 <script language="JavaScript" src="../js/RegEmailRecipient.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<title><%=title%></title>

</head>
<%	
java.util.Properties p = (java.util.Properties) session.getValue("jdbc");
String locale = (String) p.getProperty("LOCALE") == null ? "" : (String) p.getProperty("LOCALE");
String classVal	=	"";
String srl_no=(request.getParameter("srl_no")==null)?"":request.getParameter("srl_no");
String mailer_id=(request.getParameter("mailer_id")==null)?"":request.getParameter("mailer_id");
String mode=(request.getParameter("mode")==null)?"":request.getParameter("mode");
ArrayList searchResults =new ArrayList();		
searchResults=getValues(mailer_id,session,locale);

if(searchResults.size() <= 0){	
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));window.close();</script>");
}else{
%>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="RegEmailRecipientManagePwdTop" id="RegEmailRecipientManagePwdTop" method="post" action="">
<table cellpadding="0" cellspacing="0" border="1" align="center" width="100%">
<tr>
	<td class=' COLUMNHEADER'><fmt:message key="Common.SrlNo.label" bundle="${common_labels}"/></td>
	<td class=' COLUMNHEADER'><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></td>
	<td class=' COLUMNHEADER'><fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}"/></td>
	<td class=' COLUMNHEADER'><fmt:message key="Common.password.label" bundle="${common_labels}"/></td>
</tr>
<%
String db_srl_no="";
String db_from_date="";
String db_to_date="";
String db_password="";
String from_date="";
String to_date="";
String password="";
for(int i=0;i<searchResults.size();i++)
{
	if((i%2) == 0)
		classVal="QRYODD";
	else
		classVal="QRYEVEN";

	String[] searchDetails=(String[])searchResults.get(i);
	db_srl_no=searchDetails[0]==null?"":searchDetails[0];
	db_from_date=searchDetails[1]==null?"":searchDetails[1];
	db_to_date=searchDetails[2]==null?"":searchDetails[2];
	db_password=searchDetails[3]==null?"":searchDetails[3];
	
%>

	<tr>
	
	<td class='<%=classVal%>' align='left'><%if(db_srl_no.equals("")){%>&nbsp;<%}else{%><%=db_srl_no%><%}%></td>
	<td class='<%=classVal%>' align='left'><%if(db_from_date.equals("")){%>&nbsp;<%}else{%><%=db_from_date%><%}%></td>
	<td class='<%=classVal%>' align='left'><%if(db_to_date.equals("")){%>&nbsp;<%}else{%><%=db_to_date%><%}%></td>
	<td class='<%=classVal%>' align='left'><%if(db_password.equals("")){%>&nbsp;<%}else{%><%=db_password%><%}%></td>

	<input type="hidden" name="db_srl_no<%=i%>" id="db_srl_no<%=i%>" value="<%=db_srl_no%>">
	<input type="hidden" name="from_date<%=i%>" id="from_date<%=i%>" value="<%=db_from_date%>">
	<input type="hidden" name="to_date<%=i%>" id="to_date<%=i%>" value="<%=db_to_date%>">
	<input type="hidden" name="password<%=i%>" id="password<%=i%>" value="<%=db_password%>">
	<%if(srl_no.equals(db_srl_no)){
		from_date=db_from_date;
		to_date=db_to_date;
		password=db_password;
	}%>
	</tr>
	
<%	

	searchDetails=null;
	}
	classVal = "QRYEVEN";
%>
	<tr>
	<td class='label' align='left'><input type='button' class='button' name='ok' id='ok' value='<fmt:message key="Common.changepassword.label" bundle="${common_labels}"/>' onclick="changePwd()"></td>
	<td class='label' colspan='2'>&nbsp;</td>
	<td class='fields' align='right' width='8%'><input type='button' class='button' name='ok' id='ok' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick="window.close();"><input type='button' class='button' name='cancel' id='cancel' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="clearBeanValues()"></td>
	</tr>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="mailer_id" id="mailer_id" value="<%=mailer_id%>">
	<input type="hidden" name="srl_no" id="srl_no" value="<%=srl_no%>">
	<input type="hidden" name="from_date" id="from_date" value="<%=from_date%>">
	<input type="hidden" name="to_date" id="to_date" value="<%=to_date%>">
	<input type="hidden" name="password" id="password" value="<%=password%>">
</table>
</form>
</body>
<%}	

%>

<%!
/************* null check*****start**********/
String checkForNull(String arg){

	if( (arg==null) || arg.equals(""))
		arg="";

	return arg;
}
String checkForNull(String arg,String defaultValue){

	if( (arg==null) || arg.equals(""))
		arg=defaultValue;

	return arg;
}
/******************get password history from database*********start**************/
public ArrayList getValues(String mailer_id,HttpSession session,String locale) throws Exception
{
	
	Connection	con			= null;
	PreparedStatement pstmt	= null;
	ResultSet rs=null;
	ArrayList searchResults=new ArrayList();
	ArrayList beanResults=new ArrayList();
	try{
		/**************get values from bean if any********************/

		eCA.RegEmailRecipientBean CA_RegEmailRecipientBean = (eCA.RegEmailRecipientBean)getObjectFromBean("CA_RegEmailRecipientBean","eCA.RegEmailRecipientBean",session);
		beanResults=CA_RegEmailRecipientBean.getPassword();
		if(beanResults ==null || beanResults.isEmpty() || beanResults.size()==0){
			/**************get values from database********************/
			con=ConnectionManager.getConnection();
			con.setAutoCommit(false);
			pstmt=con.prepareStatement("select srl_no,to_char(from_date,'DD/MM/YYYY HH24:MI') from_date,DECODE(TO_DATE,NULL,NULL,to_char(to_date,'DD/MM/YYYY HH24:MI')) to_date,app_password.decrypt(password) password from sm_regd_mail_user_pwd where mailer_id=?");
			pstmt.setString(1,mailer_id);
			rs=pstmt.executeQuery();	
			while(rs !=null && rs.next())
			{
				String[] searchDetails=new String[4];
				searchDetails[0]=rs.getString("srl_no");
				searchDetails[1]=rs.getString("from_date");
				searchDetails[2]=rs.getString("to_date");
				searchDetails[3]=rs.getString("password");
				/*Thai date validations 17/02/2007 start */
				if(searchDetails[1]==null|| searchDetails[1].equals("null") || (searchDetails[1].equals(""))) searchDetails[1]="";
				if(searchDetails[2]==null || searchDetails[2].equals("null") || (searchDetails[2].equals(""))) searchDetails[2]="";
				if(!locale.equals("en")){
				searchDetails[1] = com.ehis.util.DateUtils.convertDate(searchDetails[1],"DMYHM","en",locale);
				searchDetails[2]=com.ehis.util.DateUtils.convertDate(searchDetails[2],"DMYHM","en",locale);
				}
		/*Thai date validations 17/02/2007 end */
				searchResults.add(searchDetails);
				CA_RegEmailRecipientBean.setPassword(searchDetails);
			} 
		}else{
			for(int i=0;i<beanResults.size();i++){
				String[] beanDetails=(String[])beanResults.get(i);
				searchResults.add(beanDetails);				
			}
		}
		putObjectInBean("CA_RegEmailRecipientBean",CA_RegEmailRecipientBean,session);	
	
	}catch(Exception e){
		
		e.printStackTrace();
	}finally{
		try{
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
			if(con !=null) con.close();
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}	
	return searchResults;
}
/******************get password history from database*********end**************/

%>

<%}catch(Exception e){

e.printStackTrace();
}
%>
</html>

