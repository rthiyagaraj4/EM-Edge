<!DOCTYPE html>
 
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.sql.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	 <link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
    <script language="JavaScript" src="../../ePH/js/PhDrugInfo.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>
<%
	
	ArrayList Enq_Dtl = null;
	String replied_by="";
	String dis="";
	ArrayList res_dtl=null;
	String info_code ="";
	String check="";
	String Enq_num	= request.getParameter("Enq_num") ;
	if(Enq_num==null) Enq_num="";
	
	
	String bean_id			= "PhDrugInfoEnqBean" ;
	String bean_name		= "ePH.PhDrugInfoEnqBean";
	HashMap InfoDtl		= new HashMap();
	ArrayList InfoSource		= new ArrayList();
	ArrayList InfoSourceDtl		= new ArrayList();
	
	
	PhDrugInfoEnqBean bean = (PhDrugInfoEnqBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	InfoDtl			= bean.getInfoSource();
	InfoSource		= (ArrayList)InfoDtl.get("INFO_CAT_CODE");
	InfoSourceDtl	= (ArrayList)InfoDtl.get("INFO_CODE");
int no_of_rec=0;
	if(!Enq_num.equals("")){
		
		res_dtl =bean.getInfoSrcDetails();
	
		Enq_Dtl =bean.getEnquirerDetails();
		replied_by=(String)Enq_Dtl.get(39);
		if(replied_by==null) replied_by="";
		if(!replied_by.equals("")){
			dis="disabled";
			
		}


no_of_rec=res_dtl.size();
	}
	
	String info_src_code1="";
	String infoCadCode	="";
%>

<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<form name='PhDrugInfoResInfoDtlsForm' id='PhDrugInfoResInfoDtlsForm'>

<TABLE cellpadding=0 cellspacing=0 width="100%"  align="center" border="0" >
		
		<%
		int ss=0;
		int ss1=0;
		int no_of_td=0;
		int count=0;
		String info_cad_code="";
		String info_cad_code1="";
			ss=InfoSource.size();
			ss1=InfoSourceDtl.size();
	 	
			for(int i=0;i<ss;i+=2){
				info_cad_code=(String)InfoSource.get(i);
				%>
				<TR><TD class='label' colspan='8' ><b>&nbsp;&nbsp;<%=(String)InfoSource.get(i+1)%></b></TD>
				<input type='hidden' value='<%=info_cad_code%>'>
				</TR>
				<TR>
				<%
				int rec=1;
				int rec1=3;
				int j=0;
				no_of_td=0;
				for(j=0;j<ss1;j+=3){
					 info_cad_code1=(String)InfoSourceDtl.get(j);
					 info_src_code1=(String)InfoSourceDtl.get(j+1);
						check="";
						if(info_cad_code.equals(info_cad_code1)){
							if(no_of_rec > 0){
								check="";
								for(int f=0; f<no_of_rec; f+=2){
								infoCadCode=(String) res_dtl.get(f);
								info_code=(String) res_dtl.get(f+1);
								
								if(info_code.equals(info_src_code1) && infoCadCode.equals(info_cad_code1)){
									check="checked";
								}
							}
						}
							
							%>
							<TD class='label' width='15%' colspan='1'>&nbsp;&nbsp;<%=InfoSourceDtl.get(j+2)%>&nbsp;&nbsp;
							<TD class='label' colspan='1' width='5%'><input type=checkbox name='info_chk<%=count%>' id='info_chk<%=count%>' <%=check%> <%=dis%> value='<%=info_cad_code%>**<%=(String)InfoSourceDtl.get(j+1)%>'></TD>
				<%			count++;
							check="";
							no_of_td++;
							rec++;
						
							if(rec > rec1){//To get the result in the 2nd line 
								rec1=3; 
								rec=1;
								check="";
								no_of_td=0; %>
								</TR><TR>
							<% }
						}
					}
					if(no_of_td<3){ 
						for(int k=no_of_td;k<3;k++){%>
					<TD class='label' colspan='1' >&nbsp;&nbsp;</TD>
					<TD class='label' colspan='1'>&nbsp;&nbsp;</TD>
						<%
						}
					} %>
				</TR>
				<tr><TD class='label' colspan='8' >&nbsp;&nbsp;</TD>
				</tr>
		<% } %>
					
			
</TABLE>
<input type='hidden' name='no_of_info_chk' id='no_of_info_chk' value='<%=count%>'>
</form>
</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>

