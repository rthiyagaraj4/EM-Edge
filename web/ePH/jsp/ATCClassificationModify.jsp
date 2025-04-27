<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"  import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>

<html>
<head>
<%	
	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");
	
        String level_num    =   request.getParameter("level");
        String title        =   "";
          if(level_num.equals("1"))   title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.AnatomicalClass.label","ph_labels");
          if(level_num.equals("2"))   title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TherapeuticClass.label","ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MainClass.label","ph_labels")+")";
          if(level_num.equals("3"))   title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TherapeuticClass.label","ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SubClass.label","common_labels")+")";
          if(level_num.equals("4"))   title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TherapeuticClass.label","ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SubClass.label","common_labels")+")";
          if(level_num.equals("5"))   title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ChemicalClass.label","ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MainClass.label","ph_labels")+")";
%>
<title><fmt:message key="Common.ATCClassification.label" bundle="${common_labels}"/> -<%=title%> </title>
<%
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script type="text/javascript">

</script>
</head>


<%
    /* Mandatory checks start */
    String mode = request.getParameter( "mode" ) ;
    String bean_id = "PhATCClassification" ;
    String bean_name = "ePH.ATCClassificationBean";

    if ( mode == null || mode.equals("") )
        return ;
    if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
        return ;
    /* Mandatory checks end */

    /* Initialize Function specific start */
    ATCClassificationBean bean = (ATCClassificationBean)
getBeanObject(bean_id,bean_name ,request);
bean.setLanguageId(locale);
    bean.setMode( mode ) ;

    bean.setInnerMode("");
    /* Initialize Function specific end */

    /* Variable Declarations Start*/
    String	title1						=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.AnatomicalClass.label","ph_labels");
	String	title2						=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TherapeuticClass.label","ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MainClass.label","ph_labels")+")";
	String	title3						=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TherapeuticClass.label","ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SubClass.label","common_labels")+")";
	String	title4						=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ChemicalClass.label","ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MainClass.label","ph_labels")+")";
    
    String  code_fld_name               =   "";
    String  desc_fld_name               =   "";
    String  code                        =   "";
    String  description                 =   "";
    String  display_seqno               =   "";
    String  anatomical_class_code       =   "";
    String  anatomical_class_desc       =   "";
    String  therapeutic_class_code      =   "";
    String  therapeutic_class_desc      =   "";
    String  therapeutic_class_subcode   =   "";
    String  therapeutic_class_subdesc   =   "";
    String  chemical_class_code         =   "";
    String  chemical_class_desc         =   "";
    String  chemical_class_subcode      =   "";
    String  chemical_class_subdesc      =   "";
    String  disable_prop                =   "";
    boolean delete_status				=   true;

    /* Variable Declarations End*/

    code            =   request.getParameter("code");
    description     =   request.getParameter("desc");
    display_seqno   =   request.getParameter("display_seqno");
    
	/* Check for child Records - Start*/
	delete_status	=	bean.getDeleteStatus(level_num,code);
	/* Check for child Records - End*/

    if(delete_status==true)
        disable_prop    =   "enabled";
    else
        disable_prop    =   "disabled";


    code_fld_name   =   "atc_class_lev"+level_num+"_code";
    desc_fld_name   =   "atc_class_lev"+level_num+"_desc";

    if(level_num.equals("1")) {
        anatomical_class_code   =   title;
        anatomical_class_desc   =   description;
    }
    if(level_num.equals("2")) {
        anatomical_class_code   =   title1;
        anatomical_class_desc   =   bean.getATCLev1Desc();
        therapeutic_class_code  =   title;
        therapeutic_class_desc  =   description;
    }
    if(level_num.equals("3")) {
        anatomical_class_code       =   title1;
        anatomical_class_desc       =   bean.getATCLev1Desc();
        therapeutic_class_code      =   title2;
        therapeutic_class_desc      =   bean.getATCLev2Desc();
        therapeutic_class_subcode   =   title;
        therapeutic_class_subdesc   =   description;
    }
    if(level_num.equals("4")) {
        anatomical_class_code       =   title1;
        anatomical_class_desc       =   bean.getATCLev1Desc();
        therapeutic_class_code      =   title2;
        therapeutic_class_desc      =   bean.getATCLev2Desc();
        therapeutic_class_subcode   =   title3;
        therapeutic_class_subdesc   =   bean.getATCLev3Desc();
        chemical_class_code         =   title;
        chemical_class_desc         =   description;
    }
    if(level_num.equals("5")) {
        anatomical_class_code       =   title1;
        anatomical_class_desc       =   bean.getATCLev1Desc();
        therapeutic_class_code      =   title2;
        therapeutic_class_desc      =   bean.getATCLev2Desc();
        therapeutic_class_subcode   =   title3;
        therapeutic_class_subdesc   =   bean.getATCLev3Desc();
        chemical_class_code         =   title4;
        chemical_class_desc         =   bean.getATCLev4Desc();
        chemical_class_subcode      =   title;
        chemical_class_subdesc      =   description;
    }


%>
<!-- <body topmargin="0" onLoad="parent.focusFirstItem('<%=mode%>','modify')"> -->
<body onMouseDown="" topmargin="0" onLoad="parent.focusFirstItem('<%=mode%>','modify')">
<form name="ATCClassification_Modify" id="ATCClassification_Modify">
<table border="0" cellpadding="0" cellspacing="0" width="99%"  align="center">
    <tr>
        <th align="left" class="th" width="22%"><fmt:message key="ePH.ATCClass.label" bundle="${ph_labels}"/></th>
        <th align="left" class="th" width="78%"><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
    </tr>
    <tr>
        <td align="left" class="td" width="22%">&nbsp;<%=anatomical_class_code%></td>
        <td align="left" class="td" width="78%">&nbsp;<%=anatomical_class_desc%></td>
    </tr>
    <tr>
        <td align="left" class="td" width="22%">&nbsp;<%=therapeutic_class_code%></td>
        <td align="left" class="td" width="78%" >&nbsp;<%=therapeutic_class_desc%></td>
    </tr>
        <tr>
        <td align="left" class="td" width="22%" >&nbsp;<%=therapeutic_class_subcode%></td>
        <td align="left" class="td" width="78%" >&nbsp;<%=therapeutic_class_subdesc%></td>
    </tr>
    <tr>
        <td align="left" class="td" width="22%" >&nbsp;<%=chemical_class_code%></td>
        <td align="left" class="td" width="78%" >&nbsp;<%=chemical_class_desc%></td>
    </tr>
    <tr>
        <td align="left" class="td" width="22%" >&nbsp;<%=chemical_class_subcode%></td>
        <td align="left" class="td" width="78%" >&nbsp;<%=chemical_class_subdesc%></td>
    </tr>
    <tr>
        <td colspan="2">&nbsp;</td>
    </tr>
    <tr>
        <td colspan="2">&nbsp;</td>
    </tr>
         <td colspan="2" class="white">&nbsp;</td>
    </tr>

</table>

<table border="0" cellpadding="0" cellspacing="0" width="99%"  align="center">
    <tr>
        <th align="left" colspan="2"><fmt:message key="ePH.Modify/Delete.label" bundle="${ph_labels}"/> <%=title%> Details </th>
    </tr>
    <tr>
        <td colspan="2">&nbsp;</td>
    </tr>
    <tr>
        <td class="label" align="right"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
        <td align="left">&nbsp;<input type="text" size="8"  value="<%=code%>" readOnly name="<%=code_fld_name%>"></td>
    </tr>
    <tr>
        <td colspan="2">&nbsp;</td>
    </tr>
    <tr>
        <td class="label" align="right"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
        <td align="left">&nbsp;<textarea rows="2" cols="70" name="<%=desc_fld_name%>" style="overflow-x:hidden;overflow-y:hidden" onKeyPress="return(parent.ChkMaxLen('Description',this,100));" onBlur="parent.makeValidString(this);"><%=description%></textarea></td>
    </tr>
    <tr>
        <td colspan="2">&nbsp;</td>
    </tr>
    <tr>
        <td class="label" align="right"><fmt:message key="ePH.DisplaySequenceNo.label" bundle="${ph_labels}"/></td>
        <td align="left">&nbsp;<input type="text" size="6" value="<%=display_seqno%>" name="display_seq_no" maxlength="6" onKeyPress="return(parent.ChkNumberInput(this,event,0))" onBlur="parent.validateDispNo(this,'','modify');parent.checkForZero(this)"></td>
    </tr>
    <tr>
        <td colspan="2">&nbsp;</td>
    </tr>
</table>

    <table border="0" cellpadding="0" cellspacing="0" width="99%" align="center">
    <tr>
        <td align="right" colspan="4"  class="white">
        <input type="button" class="BUTTON" name="record" id="record" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick="parent.repeatValidations('<%=mode%>')"><input type="reset" class="BUTTON" name="reset" id="reset"  value="Reset"><input type="button" class="BUTTON" name="delete" id="delete" value="Delete" <%=disable_prop%> onClick="parent.deleterecord()"><input type="button" class="BUTTON" name="cancel" id="cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="parent.callClose()">
        </td>
    </table>
    <input type="hidden" name="level_no" id="level_no" value="<%=level_num%>">
    <input type="hidden" name="mode" id="mode" value="<%=mode%>">
    <input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
    <input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
    </form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

