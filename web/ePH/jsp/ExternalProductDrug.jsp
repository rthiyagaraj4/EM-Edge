<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>


<HTML>
	<HEAD>
<%
 		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/PHReports.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/PHmessages.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/ExternalProductLink.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>

	<!--<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >-->
	<!-- <body> -->
	<body onMouseDown="" onKeyDown="lockKey()">
<%
		String mode	= request.getParameter( "mode" ) ;
		String bean_id = "ExternalProductLinkBean" ;
		String bean_name = "ePH.ExternalProductLinkBean";
		
		String generic_name	= request.getParameter( "generic_name" ) ;
		String sql	=	PhRepository.getPhKeyValue("SQL_PH_EXT_PROD_LINK_SELECT4");
		String extGeneric=request.getParameter( "ext_generic" ) ;

		if ( mode == null || mode.equals("") )
			return ;
		if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
			return ;


		/* Initialize Function specific start */
		ExternalProductLinkBean bean = (ExternalProductLinkBean)getBeanObject( bean_id, bean_name , request) ;
		bean.setLanguageId(locale);
		bean.clear();
		bean.setMode( mode ) ;
		
		ArrayList drugnames=bean.getDrugList(generic_name,extGeneric);

		String oldcompounddrug="";
		String oldroutecode="";
		String oldformcode="";
		String classname="";

		String compounddrug="";
		String routecode="";
		String formcode="";
		String routedesc="";
		String formdesc="";
		String drugdesc="";
		String drugcode="";
		String prodid="";
		String fromdb="";
		String groupname="";
		String exroutecode="";
		String exroutedesc="";
		String ext_drug_desc="";
		String finalgeneric="";

		int reccount=1;
		if (drugnames.size()==0)
		{
%>
			<SCRIPT>noDrugs();</SCRIPT>
<%
			return;
		}
%>
		<FORM name="FormExternalProductDrug" id="FormExternalProductDrug"  TARGET="messageFrame" >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" style="border:1px solid">
				<!--<tr>
				<th width="50%">Drug</th>
				<th width="50%">External Product</th>
				</tr>-->	
<%			
				int count=0;
				for (int i=0;i<drugnames.size();i+=13){
					compounddrug=(String)drugnames.get(i);
					routecode=(String)drugnames.get(i+1);
					formcode=(String)drugnames.get(i+2);
					routedesc=(String)drugnames.get(i+3);
					formdesc=(String)drugnames.get(i+4);
					drugdesc=(String)drugnames.get(i+5);
					drugcode=(String)drugnames.get(i+6);
					prodid=(String)drugnames.get(i+7);
					fromdb=(String)drugnames.get(i+8);
					exroutecode=(String)drugnames.get(i+9);
					exroutedesc=(String)drugnames.get(i+10);
					ext_drug_desc=(String)drugnames.get(i+11);
					finalgeneric=(String)drugnames.get(i+12);
					
					if (!finalgeneric.equals("")){
						extGeneric=finalgeneric;
					}

					String disabled="";
					if (exroutecode==null)
					{
						disabled="disabled";
					}
					if (prodid==null)
					{
						prodid="";
					}
					if (ext_drug_desc==null)
					{
						ext_drug_desc="";
					}
				
					//This row is for the group header if necessary
					if (!oldcompounddrug.equals(compounddrug))
					{
						if (compounddrug.equals("N"))
						{
							if (oldcompounddrug.equals(""))
							{
%>
								<script>parent.FrameActionheader.location.href="../../ePH/jsp/ExternalProductLinkHeader.jsp?DisplayType=Non-Compound Drugs"</script>
<%
							}
							else
							{
								out.println("<tr><td colspan=3  class=\"line\"></td></tr><TR><TH colspan=3 class='compound'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Non-CompoundDrugs.label","ph_labels")+"</TH><TH class='compound'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"</TH></TR>");
							}
						}
						else
						{
							if (oldcompounddrug.equals(""))
							{
%>
								<script>parent.FrameActionheader.location.href="../../ePH/jsp/ExternalProductLinkHeader.jsp?DisplayType=Compound Drugs"</script>
<%
							}
							else
							{
								out.println("<tr><td colspan=3  class=\"line\"></td></tr><TR><TH colspan=3 class='compound'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.CompoundDrugs.label","ph_labels")+"</TH><TH class='compound'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"</TH></TR>");
							}
						}

					}
					if  ( (!oldroutecode.equals(routecode)) ||  (!oldformcode.equals(formcode)))
					{
						count++;
						out.println("	<script>startpos["+count+"]="+reccount+"</script>");
						groupname="GROUP"+(count);
%>
						<tr>
							<td colspan=5  class="line"></td>
						</tr>
						<TR> 
							<TH width="27%" ><%=routedesc%></TH>
							<TH width="27%" ><%=formdesc%><input type="hidden" name="productGroup<%=count%>" id="productGroup<%=count%>" id="productGroup<%=count%>"></TH>
							<TH> &nbsp;<input type=text class="inputclass" readonly size="34" maxlength="125" name='<%=groupname%>' id='<%=groupname%>' id='<%=groupname%>' onBlur="changeGroupValues('<%=count%>',this)" ><input type="button" class="button" value="?" onClick='externalProductLookup("document.FormExternalProductDrug.GROUP<%=count%>","<%=exroutedesc%>",0,<%=count%>);'  <%=disabled%>></th>
							<th  style="text-align='right'"><input type=checkbox <%=disabled%> name='chk<%=groupname%>' id='chk<%=groupname%>'  onClick=selectGroup('<%=count%>',this); </TH>
						</TR>
						<tr>
								<td colspan=2  class="line"></td>
						</tr>
<%
					}
					String fontcolor="";
					if (fromdb.equals("Y") ) 
						  fontcolor="RED";
					 else
						  fontcolor="BLACK";
					if (reccount%2==0)
					{
						classname="QRYEVENNOBORDER";
					}
					else
					{
						classname="QRYODDNOBORDER";
					}
					 //This row is for the actual data
%>
 					<TR>
						<TD class="<%=classname%>"   style="color:<%=fontcolor%>;font-size:8pt" colspan=2><%=drugdesc%>
						 <!--Row Level Hidden Values start here -->
							<input type="hidden" name='<%="DRUGCODE"+reccount%>' id='<%="DRUGCODE"+reccount%>'  ID=name='<%="DRUGCODE"+reccount%>' value="<%=drugcode%>">	
							<input type="hidden" name='<%="FROMDB"+reccount%>' id='<%="FROMDB"+reccount%>'  id='<%="FROMDB"+reccount%>' value='<%=fromdb%>'	 >
							<input type="hidden" name='<%="EXTPRODUCTID"+reccount%>' id='<%="EXTPRODUCTID"+reccount%>'  ID='<%="EXTPRODUCTID"+reccount%>' value="<%=prodid%>" >	
						</TD>
						<TD class="<%=classname%>" style="font-size:8pt" >
							&nbsp;<input type=text <%=disabled%>  class="inputclass" style="color:<%=fontcolor%>" readonly size="34" maxlength="125" name='<%="RECORD"+reccount%>'  id='<%="RECORD"+reccount%>'  	value="<%=ext_drug_desc%>"><input type="button" class="button" value="?" onClick='externalProductLookup ("document.FormExternalProductDrug.RECORD<%=reccount%>","<%=exroutedesc%>",<%=reccount%>,0)'  <%=disabled%>>	</TD>
						<td class="<%=classname%>" align="right"><input type=checkbox <%=disabled%> name='chkRECORD<%=reccount%>'  name='chkRECORD<%=reccount++%>' onClick="deSelectGroup('<%=count%>',this)"> </Td>
					</TR>
<%
					oldcompounddrug=compounddrug;
					oldroutecode=routecode;
					oldformcode=formcode;
				}
%>
<!--form level hidden values start here -->
				<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%= mode %>">
				<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
				<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
				<INPUT TYPE="hidden" name="totalrows" id="totalrows"  value="<%=drugnames.size()/13%>">
				<INPUT TYPE="hidden" name="external_lookup_query" id="external_lookup_query"  value="<%=sql%>">
				<INPUT TYPE="hidden" name="GENERIC_ID" id="GENERIC_ID" value="<%=extGeneric%>">

			</table>
		</form>
	</BODY>
</HTML>
<%
putObjectInBean(bean_id,bean,request);
%>

