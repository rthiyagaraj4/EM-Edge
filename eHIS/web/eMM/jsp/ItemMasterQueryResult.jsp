<!DOCTYPE html>
<%@ page import ="eMM.*, eMM.Common.* , eCommon.Common.*,java.util.*,java.sql.*,java.lang.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
		<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
//String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- 	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/rowcolor.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="Javascript" src="../../eMM/js/MmCommon.js"></script>
	<!-- 	<script language="javascript" src="../../eMM/js/MmMessages.js"></script> -->
		<script language="Javascript" src="../../eMM/js/ItemMaster.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%
	String bean_id = "ItemMasterQueryBean";
	String bean_name = "eMM.ItemMasterQueryBean";
	ItemMasterQueryBean bean = (ItemMasterQueryBean) getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);
	

//	String category			=	bean.getCategory() ;                
//	String ps_item			=	bean.getPs_item_yn() ;                  
//	String sole_source		=	bean.getsole_source() ;          
//	String Cons_item		=	bean.getCons_item() ;              
//	String searchby			=	bean.getsearchby() ;                
//	String item_class		=	bean.getItem_class() ;            
	String short_desc		=	bean.getShort_desc() ;            
//	String item_remarks		=	bean.getItem_remarks() ;            
//	String trade_id			=	bean.getTrade_id() ;            
//	String trade_name		=	bean.getTrade_name() ;            
//	String item_analysis_1	=	bean.getItem_analysis_1() ;  
//	String item_analysis_2	=	bean.getItem_analysis_2() ;  
//	String item_analysis_3	=	bean.getItem_analysis_3() ;  
//	String manufacturer		=	bean.getManufacturer() ;        
//	String search_criteria	=	bean.getsearch_criteria() ;  
//	String pur_uom_code		=	bean.getUOM() ;  
//	String search_string	=	bean.getSearch_string() ;      
//	boolean search			=	bean.getSearch() ;      
	String classvalue		=	"" ;      
//	String consignment		=	"" ;      
//	String long_desc		=	"" ;      
	int maxRec				=	0;
	int displaySize			=	0;
	int start  = 0;
	int end  = 0;
	int count   = 0;
	String from			= request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
	String to			= request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
	String flag			= request.getParameter( "flag" )==null?"":request.getParameter( "flag" ) ;
	String radioval			= request.getParameter( "radioval" )==null?"IC":request.getParameter( "radioval" ) ;
	

	ArrayList result=new ArrayList();	
	HashMap dataList	= null;
	try{
	
result=bean.getDataList();//out.println(result);
		maxRec=  result.size();
		displaySize = Integer.parseInt( (String) CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE"));
		displaySize=Integer.parseInt("12");
		if ( from == null || from =="" )
			start = 0;
		else
			start = Integer.parseInt( from ) ;

		if ( to == null || to ==""){
			end = displaySize ;
		}
		else{
			end = Integer.parseInt( to ) ;	
		}

		if(result.size() > 0 ){
		%>
			<form name=ItemMasterCriteriaForm>
			<div name='msg' id='msg' style="position:absolute;width: 0; height: 0; left: 201; top: 62">
			</div>
			<table cellpadding=0 cellspacing=0 width="100%" align=center>
			<tr>
		
			<table border="1" cellpadding="0" cellspacing="0" width="100%"  id='tb1' align=center>
			    <th><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eMM.MaterialGroup.label" bundle="${mm_labels}"/></th>
				<th><fmt:message key="eMM.CategoryType.label" bundle="${mm_labels}"/></th>
				<th><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.uom.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></th>

		<%
			
			count	= start;
			int chkCount = 0;
				
			String link_yn = request.getParameter("flag");
			while ( count < maxRec && count < end)
			{
				
				dataList = (HashMap)result.get(count);
				if ( count % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;

//				long_desc=CommonBean.checkForNull((String)dataList.get("LONG_DESC"));
//				consignment=CommonBean.checkForNull((String)dataList.get("CONSIGNMENT_ITEM_YN"),"N");
				String code = CommonBean.checkForNull((String)dataList.get("ITEM_CODE"));
				short_desc = CommonBean.checkForNull((String)dataList.get("SHORT_DESC"));
							
				if(maxRec==1){
				
							
				%>
				<script>
					returnVals("<%=code%>","<%=short_desc%>");
				</script>
				<%}	%>	

			<tr >	
				<% 
							
			if(link_yn.equals("'N'"))
				
				{

					%> 
				<td class="<%=classvalue%>"  onclick="disableClick(event);"><%=CommonBean.checkForNull((String)dataList.get("ITEM_CODE"))%>&nbsp;</td>
 			  <%}
				else{
					%>
				 <td class="<%=classvalue%>"  onClick="returnVals('<%=code%>','<%=replaceNewLineChar(short_desc)%>');"   onmouseover="changeCursor(this);"><font class='HYPERLINK'><%=CommonBean.checkForNull((String)dataList.get("ITEM_CODE"))%>&nbsp;</td>
				<%}%>
				
				

					<td class="<%=classvalue%>"   ><%=(String)dataList.get("SHORT_DESC")%></td>
					<td class="<%=classvalue%>"   onclick="disableClick(event);" nowrap><%=CommonBean.checkForNull((String)dataList.get("ALPHA_CODE"))%>&nbsp;</td>
					<td class="<%=classvalue%>"   onclick="disableClick(event);" nowrap><%=CommonBean.checkForNull((String)dataList.get("MATERIAL_GROUP_CODE"))%>&nbsp;</td>
					<td class="<%=classvalue%>"   onclick="disableClick(event);" nowrap><%=CommonBean.checkForNull((String)dataList.get("CATEGORY_TYPE_CODE"))%>&nbsp;</td>
					<td class="<%=classvalue%>"   onclick="disableClick(event);" nowrap><%=CommonBean.checkForNull((String)dataList.get("ITEM_CLASS"))%>&nbsp;</td>
					<!-- <td class="<classvalue%>"   onclick="disableClick(event);" nowrap><bean.checkForNull((String)dataList.get("GEN_UOM_DESC")," ")%>&nbsp;</td> Modified for ML-MMOH-SCF-0382-->
					<td class="<%=classvalue%>"   onclick="disableClick(event);" nowrap><%=bean.checkForNull((String)dataList.get("GEN_UOM_DESC")," ")%>&nbsp;</td>
					<td class="<%=classvalue%>"   onclick="disableClick(event);" nowrap><%if (dataList.get("EFF_STATUS").equals("E"))
						{
						out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
						}
						else
						{
						out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
						}
							%></td>
						

				</tr> 
		<%
				count++;
			chkCount++;
			}
		%>
			</table>
			<input type="hidden" name="item_code" id="item_code" >
			<input type="hidden" name="short_desc" id="short_desc" >
			<input type="hidden" name="alpha_code" id="alpha_code" >
			<input type="hidden" name="start" id="start" value="<%=start%>">
			<input type="hidden" name="end" id="end" value="<%=end%>">
			<input type="hidden" name="flag" id="flag" value="<%=flag%>">
			<input type="hidden" name="totalRecords" id="totalRecords" value='<%=result.size()%>'>
			<input type="hidden" name="displaySize" id="displaySize" value="<%=displaySize%>">
			<input type="hidden" name="count" id="count" value="1">
			
		<%
			out.flush();
		} else{

		%>
			<script>
					if('<%=radioval%>'=="IC" && <%=true%>==true){
							changeRadVal();
					}
					else{
						alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
						document.location.href="../../eCommon/html/blank.html";
						parent.qryCriteria.document.ItemMasterCriteria_Form.next.disabled=true;						
						parent.qryCriteria.document.ItemMasterCriteria_Form.previous.disabled=true;
					}
			</script>
		<%
		}

	} catch(Exception e) {
		//out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace();
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
/* Modified on 5/9/2006  as per TSG request
   public String replaceNewLineChar(String message) {
	StringBuffer sb= new StringBuffer();
    try
	{
        String spChar[]={"\n","\"","'"};
        String chChar[]={"\\n/","\\\"","\\\'"};

        sb= new StringBuffer(message);
        upper:  for(int i=0;i<sb.length();i++)
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
	catch(Exception e)
	{
		sb.append("Exception@replaceNewLineChar : "+e.toString());
	}
        return sb.toString();
    } */

	public String replaceNewLineChar(String message) {
		
		String changed = "";

        changed = message.replaceAll("\n","\\n/");
		changed = changed.replaceAll("\"","\\\"");
		changed = changed.replaceAll("'","\\\\'");	
        return changed;
}


%>

