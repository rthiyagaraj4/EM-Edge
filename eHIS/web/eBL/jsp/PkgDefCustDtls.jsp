<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.sql.*,java.util.*, eBL.* ,eBL.Common.*,eCommon.Common.*, eBL.PkgDefBean" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>


<html>
<head>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<%
	request.setCharacterEncoding("UTF-8"); 
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src='../../eBL/js/PkgDefCust.js'></script> 
	<script language="javascript" src='../../eBL/js/PkgDef.js'></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		var headTop = -1;
		var FloatHead1;
		function processScroll()
			{
				if (headTop < 0)
				{
					saveHeadPos();
					
				}
				if (headTop>0)
				{
					if (document.documentElement && document.documentElement.scrollTop)
						theTop = document.documentElement.scrollTop;
					else if (document.body)
						theTop = document.body.scrollTop;

					if (theTop>headTop)
						FloatHead1.style.top = (theTop-headTop) + 'px';
					else
						FloatHead1.style.top = '0px';
				}
			}

			function saveHeadPos()
			{
				parTable = document.getElementById("divHeadSep");
				if (parTable != null)
				{
					headTop = parTable.offsetTop + 3;
					FloatHead1 = document.getElementById("heading");
					FloatHead1.style.position = "relative";
				}
			}
		</script>

</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onScroll="processScroll()">
<%
	
	String mode				= request.getParameter("mode") == null ? "" : request.getParameter("mode");
	String locale			= (String)session.getAttribute("LOCALE");

	int totalRecords=1;
	
	String packageCode		=	"" ;
	packageCode		=	request.getParameter("packageCode") == null ? "" :request.getParameter("packageCode") ;
	//String copyFrm_pkgCode		=	request.getParameter("copyFrm_pkgCode") == null ? "" :request.getParameter("copyFrm_pkgCode") ;
	String bean_id		= "bl_PkgDefCustBean" ;
	String bean_name	= "eBL.PkgDefCustBean";
	PkgDefCustBean bean			= (PkgDefCustBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setModifyCust("Y");	

	String no_of_decimals=bean.getNoOfDecimal();
	String 		cust_grp_code			="";
	String 	    cust_grp_desc		="";
	String 	    cust_code		="";
	String 	    cust_desc		="";
	String 	    pkg_valid_days		="";
	//Added V190325 Gayathri/KDAH-CRF-0503/Starts
	String isMasterPackYN	= request.getParameter("isMasterPackageYN");
	String allow_masterChild_package= request.getParameter("allow_masterChild_package");
	if(isMasterPackYN == null || isMasterPackYN == "") isMasterPackYN="N";
	String[] record;
	String 	    key		="";
	HashMap cust_dtls    = new HashMap();
	cust_dtls    = (HashMap)bean.getCustDtls();
	Set<String> custDtlsSet=(Set<String>)cust_dtls.keySet();
	//System.out.println("custDtlsSet="+custDtlsSet.toString());
	Iterator<String> custIt=custDtlsSet.iterator();
	if(cust_dtls.size()>0){
			totalRecords=cust_dtls.size();		
	}

	String authorized =request.getParameter("authorized")== null ? "N" : request.getParameter("authorized");
	String modifyStatus = "";
	String pkgApprovedYN =request.getParameter("pkgApprovedYN")== null ? "N" : request.getParameter("pkgApprovedYN");
	if(mode.equals("modify") && authorized.equals("N")&& pkgApprovedYN.equals("Y"))
		 modifyStatus = " disabled ";
%>

<form name='cust_dtls' id='cust_dtls'  target='messageFrame' >	
<div id="divHeadSep" style="position: absolute; width:100%">
<table class='grid' width='100%' id="cust_tbl">
<tr id="heading">	
<td class='COLUMNHEADER' ><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/></td> 
<td class='COLUMNHEADER' ><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></td> 
<td class='COLUMNHEADER' ><fmt:message key="eBL.VALID_DAYS.label" bundle="${bl_labels}"/></td> 
<td class='COLUMNHEADER' >&nbsp;</td>
</tr>

<%
int i=0;
if(cust_dtls!=null && cust_dtls.size()>0){
	while(custIt.hasNext()){
		record=new String[5];						
		key=(String)custIt.next();
		record=(String[])cust_dtls.get(key);
		cust_grp_code		= record[0];
		cust_grp_desc		= record[1];
	    cust_code	=	record[2];
		cust_desc		=record[3];
		pkg_valid_days		=record[4];
%>
<tr>
<td>
<input type='text' name='cust_grp_code<%=i%>' id='cust_grp_code<%=i%>' value='<%=cust_grp_code%>' <%=modifyStatus%> size='10' onBlur="custGrpCodeLookUp(cust_grp_desc<%=i%>,this,'<%=i%>')"><input type='text' name = 'cust_grp_desc<%=i%>' size='10' maxlength='10'	<%=modifyStatus%> onBlur="custGrpDescLookUp(this,cust_grp_code<%=i%>,'<%=i%>')" value="<%=cust_grp_desc%>"><INPUT type='hidden' name='cust_grp_code_temp<%=i%>' id='cust_grp_code_temp<%=i%>' value=''><INPUT type='hidden' name='cust_grp_desc_temp<%=i%>' id='cust_grp_desc_temp<%=i%>' value=''><input type='button' name='cust_grp_button<%=i%>' id='cust_grp_button<%=i%>' class='button' value='?' <%=modifyStatus%> onclick="custGrpLookUp(cust_grp_desc<%=i%>,cust_grp_code<%=i%>,'<%=i%>')">
</td><td>		
<input type='text' name='cust_code<%=i%>' id='cust_code<%=i%>' value='<%=cust_code%>' size='10'  <%=modifyStatus%> onBlur="custCodeLookUp(cust_desc<%=i%>,this,cust_grp_code<%=i%>,'<%=i%>')"><input type='text' name = 'cust_desc<%=i%>' size='10' maxlength='10'	 <%=modifyStatus%> onBlur="custDescLookUp(this,cust_code<%=i%>,cust_grp_code<%=i%>,'<%=i%>')" value="<%=cust_desc%>"><INPUT type='hidden' name='cust_code_temp<%=i%>' id='cust_code_temp<%=i%>' value=''><INPUT type='hidden' name='cust_desc_temp<%=i%>' id='cust_desc_temp<%=i%>' value=''><input type='button' name='cust_button<%=i%>' id='cust_button<%=i%>' class='button' value='?' onclick="custLookUp(cust_desc<%=i%>,cust_code<%=i%>,cust_grp_code<%=i%>,'<%=i%>')"><input type='hidden' name='oldKey<%=i%>' id='oldKey<%=i%>' value='<%=(cust_grp_code+"~~"+cust_code)%>'>
</td>
<td align="left" nowrap><input type='text'  name='pkg_valid_days<%=i%>' id='pkg_valid_days<%=i%>' <%=modifyStatus%> size='4' maxlength='4'   onBlur="return chkCustValidDays(this);" onKeyPress='return(ChkNumberInput(this,event,"<%=no_of_decimals%>"))' value="<%=pkg_valid_days%>" /><img src='../../eCommon/images/mandatory.gif'></td>

<td align="left" nowrap>
<!--<input type='checkbox'  name='del_cust<%=i%>' id='del_cust<%=i%>' onClick='chkDeleteCust(this,"<%=i%>");' value="N"/>-->
<a name='select<%=i%>' href='#' onClick='showCustPeriod(this,"<%=i%>");' ><fmt:message key="eBL.Dtls.label" bundle="${bl_labels}"/></a>
</td>

</tr>
<%		
	i++;
}
	}else{%>
	<tr>
<td>
<input type='text' name='cust_grp_code0' id='cust_grp_code0' value='' size='10'	<%=modifyStatus%> onBlur="custGrpCodeLookUp(cust_grp_desc0,this,'0')"><input type='text' name = 'cust_grp_desc0' size='10' maxlength='10'	 <%=modifyStatus%> onBlur="custGrpDescLookUp(this,cust_grp_code0,'0')" value=""><INPUT type='hidden' name='cust_grp_code_temp0' id='cust_grp_code_temp0' value=''><INPUT type='hidden' name='cust_grp_desc_temp0' id='cust_grp_desc_temp0' value=''><input type='button' name='cust_grp_button0' id='cust_grp_button0' class='button' value='?'	<%=modifyStatus%> onclick="custGrpLookUp(cust_grp_desc0,cust_grp_code0,'0')">
</td><td>		
<input type='text' name='cust_code0' id='cust_code0' value='' size='10'	 <%=modifyStatus%> onBlur="custCodeLookUp(cust_desc0,this,cust_grp_code0,'0')"><input type='text' name = 'cust_desc0' size='10' maxlength='10'	<%=modifyStatus%> onBlur="custDescLookUp(this,cust_code0,cust_grp_code0,'0')" value=""><INPUT type='hidden' name='cust_code_temp0' id='cust_code_temp0' value=''><INPUT type='hidden' name='cust_desc_temp0' id='cust_desc_temp0' value=''><input type='button' name='cust_button0' id='cust_button0' class='button' value='?'	 <%=modifyStatus%> onclick="custLookUp(cust_desc0,cust_code0,cust_grp_code0,'0')"><input type='hidden' name='oldKey0' id='oldKey0' value=''>
</td>
<td align="left" nowrap><input type='text'  name='pkg_valid_days0' id='pkg_valid_days0' size='4'  <%=modifyStatus%> maxlength='4'  onBlur="return chkCustValidDays(this);" onKeyPress='return(ChkNumberInput(this,event,"<%=no_of_decimals%>"))' value="" /><img src='../../eCommon/images/mandatory.gif'></td>


<td align="left" nowrap>
<!--<input type='checkbox'  name='del_cust0' id='del_cust0' onClick='chkDeleteCust(this,"0");' value="N"/>-->
<a name='select0' href='#' onClick='showCustPeriod(this,"0")'><fmt:message key="eBL.Dtls.label" bundle="${bl_labels}"/></a>
</td>

</tr>
	<%}%>
 </table>
 </DIV>
 <INPUT TYPE="hidden" name='mode' id='mode' value="<%=mode%>">
<input type="hidden" name="locale" id="locale" value="<%=locale%>">
<input type="hidden" name="totalRecords" id="totalRecords" value="<%=totalRecords%>">
<input type="hidden" name="noofdecimal" id="noofdecimal" value="<%=no_of_decimals%>">
<input type="hidden" name="packageCode" id="packageCode" value="<%=packageCode%>">
<input type='hidden' name='isMasterPackYN' id='isMasterPackYN' value="<%=isMasterPackYN%>" />
<input type='hidden' name='allow_masterChild_package' id='allow_masterChild_package' value="<%=allow_masterChild_package%>" />
	 </form>
 </body>
  
</html>

<%putObjectInBean(bean_id,bean,request);%>

