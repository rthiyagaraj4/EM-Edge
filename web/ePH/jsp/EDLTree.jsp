<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*,eCommon.Common.*, java.util.HashMap, java.util.ArrayList" %>
<%-- JSP Page specific attributes end --%>
	
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%
    String locale			= (String)session.getAttribute("LOCALE");
	String bean_id = "EDLBean" ;
    String bean_name = "ePH.EDLBean";
	String strQuery = PhRepository.getPhKeyValue("SQL_PH_DISP_STAT_AGE_GROUP_SELECT3");
	strQuery       =  PhRepository.getPhKeyValue("SQL_PH_EDL_TREE");
	//String strQuery = " SELECT * FROM  (SELECT * FROM PH_EDL_CLASSIFICATIONS_LANG_VW WHERE LANGUAGE_ID=?)  ";
	String inValues[] = {locale};

	EDLBean bean = (EDLBean)getBeanObject( bean_id,bean_name,request) ;

	HashMap hmTree = bean.fetchValues(inValues,strQuery); 

	ArrayList alEDLCode = null;
	ArrayList alEDLDescription = null;
	ArrayList alEDLParentCode = null;
	ArrayList alEDLStatus = null;

	if(hmTree!=null && hmTree.size() != 0)
	{
		 alEDLCode = (ArrayList) hmTree.get("EDL_CODE");
		 alEDLDescription = (ArrayList) hmTree.get("DESCRIPTION");
		 alEDLParentCode = (ArrayList) hmTree.get("PARENT_CODE");
		 alEDLStatus = (ArrayList) hmTree.get("EFF_STATUS");
	}
%>
<HTML>
	<head>
	

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
	<script type='text/javascript' src='../../ePH/js/EDLTree.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script type='text/javascript'  src="../../eCommon/js/ValidateControl.js"></script>  <!-- added on 23/1/09 -->

	<STYLE TYPE="text/CSS">
		/* This style is used for locking the table's heading  */

		div#tree_tbl {
			height: 95%;
			width: 100%;
			overflow: auto;
			position: absolute;
		}

	</STYLE>

</head>

<body onMouseDown="" onKeyDown="lockKey()">   <!-- added on 23/1/09 -->
	<div class='dtree'>
	<script type='text/javascript'>
		d = new dTree('d');
		d.config.useStatusText=true;
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<body onMouseDown="" onKeyDown="lockKey()" class='TREEBODY'>   <!-- added on 23/1/09 -->
	<TABLE width="100%" CELLSPACING=0 class="COMMON_TOOLBAR" cellpadding="0">

	<TR>
		<td align=right><IMG SRC="../../eCommon/images/expand-all.gif" style="cursor:pointer"	 BORDER=1 ALT='Open All' onClick="javascript:d.openAll()">
		<IMG style="cursor:pointer" SRC="../../eCommon/images/close-all.gif"  BORDER=1 ALT='Close All' onClick="javascript:d.closeAll()"></a> </td>
	</TR>
	<TR>
		<TD></TD>
	</TR>
	<TR>
		<TD >

			<script>

				d.add(0,-1,'<B><fmt:message key="ePH.EDLCLASSIFICATION.label" bundle="${common_labels}"/><B>');
				<% if(alEDLCode != null)
					{ 
						for(int i=0; i<alEDLCode.size();i++)
						{
							if(alEDLStatus.get(i).toString().equals("E"))
								out.println("d.add('"+alEDLCode.get(i)+"','"+alEDLParentCode.get(i)+"','"+alEDLDescription.get(i).toString()+"',\"javascript:selectLink('"+alEDLCode.get(i)+"')\",'"+alEDLDescription.get(i).toString()+"','');");
							else
								out.println("d.add('"+alEDLCode.get(i)+"','"+alEDLParentCode.get(i)+"','<I>"+alEDLDescription.get(i).toString()+"</I>','','"+alEDLDescription.get(i).toString()+"');");
								
						}
					}
				%>
			
			document.write(d);

			d.openAll();


			</script>	
		</TD>
	</TR>
	</Table>
</body>
	</div>
</HTML>

