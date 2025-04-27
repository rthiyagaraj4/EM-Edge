<!DOCTYPE html>
 <%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
	<head>
		<title></title>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->		<%
			 request.setCharacterEncoding("UTF-8");
			String locale			= (String)session.getAttribute("LOCALE");
			
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
			<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
			<script language="javascript" src="../../eCommon/js/rowcolor.js"></script>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
		<!--<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
			<script language="Javascript" src="../../eST/js/StCommon.js"></script>
		<!--<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
			<script language="Javascript" src="../../eST/js/ItemSearch.js"> </script>
			<script language="Javascript" src="../../eST/js/Item.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%	
	String kit_template_code			=			"";
	String classvalue					=			"";
/*String curr_supp_code				=			"";
	String uom_desc						=			"";
	String manufacture_desc				=			"";
	String min_stk_qty					=			"";
	String max_stk_qty					=			"";
	String long_desc					=			"";
	String ps_item_yn					=			"";
	String sole_source_yn				=			"";
	String manufacturer_id				=			"";
	String gen_uom_code					=			"";
	String unit_cost					=			"";
	String mfg_item_yn					=			"";
	String medical_item_yn				=			"";
	String abc_class_code				=			"";
	String machine_code					=			"";
	String spare_part_id				=			"";
	String trade_id_applicable_yn		=			"";
	String batch_id_applicable_yn		=			"";
	String expiryyn						=			"";
	String item_code					=			"";
	String item_name					=			"";
	String item_class					=			"";
	String alpha_code					=			"";
	String consignment					=			"";
	String preparation_type				=			"";
	String preparation_mode				=			"";
	String str_uom_code					=			"";
	String gen_uom_desc					=			"";*/

	int maxRec							=			0; 
	int start							=			0;
	int end								=			0;
	int displaySize						=			0;
	int count							=			0;

	String from							=			request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
	String to							=			request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
	String radioval						=			request.getParameter( "radioval" )==null?"IC":request.getParameter( "radioval" ) ;
	String bean_id						=			 "ItemSearchBean";
	String bean_name					=			 "eST.ItemSearchBean";
	ItemSearchBean bean					=			(ItemSearchBean) getBeanObject( bean_id,bean_name,request);
	
	String store_desc					=			CommonBean.checkForNull(bean.getStore_desc(),"");

	String store_code					=			CommonBean.checkForNull(bean.getStore_code(),"");
	//String item_class_code				=			CommonBean.checkForNull(bean.getItem_class(),"");
	
	
	store_desc							=			store_desc.equals("%")?"":store_desc;
	store_code							=			store_code.equals("%")?"":store_code;
	bean.setLanguageId(locale);
//String search_string					=			bean.getSearch_string();
	boolean search						=			bean.getSearch() ;
	
	//if(radioval=="IC")search			=			true;
	ArrayList result					=			new ArrayList();	
	HashMap dataList					=			null;
	try{
		result							=			bean.getKitDataList();
		maxRec							=			result.size();
		displaySize						=			Integer.parseInt( (String) CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE"));
		displaySize						=			Integer.parseInt("12");
		if ( from == null || from =="" )
			start						=			0;
		else
			start						=			Integer.parseInt( from ) ;
		if ( to == null || to ==""){
			end							=			displaySize ;
		}
		else{
			end							=			 Integer.parseInt( to ) ;	
		}
		if(result.size() > 0 ){
		%>
			<form name=ItemsearchForm id=ItemsearchForm>
			<div name='msg' id='msg' style="position:absolute;width: 0; height: 0; left: 201; top: 62">
			</div>
			<table cellpadding=0 cellspacing=0 width="100%"  align=center>
			<tr>
			<table border="1" cellpadding="0" cellspacing="0" width="100%"  id='tb1'>
			<td width='3%'  class='CAGROUP_HEADING'><b><fmt:message key="eST.KitTemplateCode.label" bundle="${st_labels}"/></b></td>
			<td width='3%'  class='CAGROUP_HEADING'><b><fmt:message key="eST.KitTemplateDescription.label" bundle="${st_labels}"/></b></td>
		<%
			count	= start;
			int chkCount = 0;
			while ( count < maxRec && count < end)
			{
				dataList = (HashMap)result.get(count);
				if ( count % 2 == 0 )
					classvalue		=			"QRYEVEN" ;
				else
					classvalue		=			 "QRYODD" ;
	
				kit_template_code	=	CommonBean.checkForNull((String)dataList.get("KIT_TEMPLATE_CODE"),"");
				String kit = "kit";
				if(maxRec==1){
				%>
				<script>
					kitReturnVals("<%=kit%>","<%=kit_template_code%>");
				</script>
				<%
				}
		%>
				<tr onClick="kitReturnVals('<%=kit%>','<%=kit_template_code%>');" >
					<td class="<%=classvalue%>"   onmouseover="changeCursor(this);"   onMouseout="onMOut(msg);" nowrap><font class='HYPERLINK'><%=(String)dataList.get("KIT_TEMPLATE_CODE")%></font></td>
					<td class="<%=classvalue%>"   onclick="disableClick(event);" nowrap ><%=(String)dataList.get("KIT_TEMPLATE_DESC")%></td>
				</tr> 
		<%
				count++;
			chkCount++;
			}
		%>
			</table>
			<input type="hidden" name="item_code" id="item_code" >
			<input type="hidden" name="short_desc" id="short_desc" >
			<input type="hidden" name="store_desc" id="store_desc"			value="<%=bean.getStore_desc()%>">
			<input type="hidden" name="alpha_code" id="alpha_code" >
			<input type="hidden" name="machine_code" id="machine_code" >
			<input type="hidden" name="spare_part_id" id="spare_part_id" >
			<input type="hidden" name="start" id="start"				value="<%=start%>">
			<input type="hidden" name="end" id="end"					value="<%=end%>">
			<input type="hidden" name="totalRecords" id="totalRecords"		value='<%=result.size()%>'>
			<input type="hidden" name="displaySize" id="displaySize"			value="<%=displaySize%>">
			<input type="hidden" name="count" id="count"				 value="1">
		<%
			out.flush();
		} else{
		%>
			 <script>
					/*if('<%=radioval%>'=="IC" && <%=search%>==true){
							
							changeRadVal();
					}
					else{
					*/							
						alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
						document.location.href="../../eCommon/html/blank.html";
						parent.qryCriteria.document.ItemSearchCriteria_Form.next.disabled=true;						
						parent.qryCriteria.document.ItemSearchCriteria_Form.previous.disabled=true;
					//}
			</script>
		<%
		}
	} catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</form>
<script>activeLink();</script>
</html>
<%!

public String replaceNewLineChar(String message) {
		String changed			=		"";
        changed					=		 message.replaceAll("\n","\\n/");
		changed					=		 changed.replaceAll("\"","\\\"");
		changed					=		 changed.replaceAll("'","\\\\'");	
        return changed;
}
 /*/ Modified on 5/9/2006  as per TSG request
   public String replaceNewLineChar(String message) {
	StringBuffer sb= new StringBuffer();
    try
	{
        String spChar[]={"\n","\"","'"};
        String chChar[]={"\\n/","\\\"","\\\'"};
        sb= new StringBuffer(message);
        upper:  for(int i=0;i<sb.length();i++)
					{
                    for(int j=0;j<spChar.length;j++)
                    {
                        if(spChar[j].equals(String.valueOf(sb.charAt(i))))
                        {
                            sb.deleteCharAt(i);
                            sb.insert(i,chChar[j].toCharArray());
							i+=chChar[j].length();
                            continue upper;
                        }
                    }
					}
	}
	catch(Exception e)
	{
		sb.append("Exception@replaceNewLineChar : "+e.toString());
	}
        return sb.toString();
    } */
%>

