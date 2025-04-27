<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*,java.text.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement stmt1=null;
	ResultSet rset1=null;
	String mode=(request.getParameter("mode")==null)?"":request.getParameter("mode");
    StringBuffer paragraphDefinition=new StringBuffer();
    String matrix_cols	= "",	matrix_rows	=	"";
	String matrix_starting_pos	= "1",	matrix_colSpans	=	"";
	String matrixID = request.getParameter("matrixID")==null?"":request.getParameter("matrixID");
	String matrixDesc = request.getParameter("matrixDesc")==null?"":request.getParameter("matrixDesc");
	String matrix_max_columns_allowed = request.getParameter("matrix_max_columns_allowed")==null?"":request.getParameter("matrix_max_columns_allowed");
	String matrixComponentDefinition="";	//= request.getParameter("matrixComponentDefinition")==null?"":request.getParameter("matrixComponentDefinition");
	//String componentDefinition = "";
	//added by Shaiju

	if (!mode.equals("insert")){	
		
		try
			{
		con = ConnectionManager.getConnection(request);
		String sqlalpha = " SELECT DISCR_MSR_DEF FROM AM_DISCR_COMP_DEFINITION WHERE DISCR_MSR_ID = ? " ;
				stmt1= con.prepareStatement(sqlalpha);
				stmt1.setString(1,matrixID);
				rset1 = stmt1.executeQuery();
				while(rset1.next())
				{
					Clob clb = rset1.getClob(1);
				

					if(clb!=null)
					{
						java.io.BufferedReader r = new java.io.BufferedReader(clb.getCharacterStream());
						String line = null;
						while((line=r.readLine()) != null) {
							paragraphDefinition.append(line);
						}
					}
				}

				
				if(rset1!=null) 	rset1.close();
				if(stmt1!=null) 	stmt1.close();
				
		matrixComponentDefinition =	paragraphDefinition.toString();
		
		}
		catch (Exception e)
		{
			out.println(e.toString());
			e.printStackTrace(System.err);
		}
		finally
			{
	
			if(con!=null)ConnectionManager.returnConnection(con,request);
			}
	// addition ends..

	StringTokenizer stk = null;
	if(!matrixComponentDefinition.equals(""))
	{
		stk = new StringTokenizer(matrixComponentDefinition, "$$$");
		//out.println(matrixComponentDefinition);
		matrix_cols			= stk.nextToken();
		matrix_rows			= stk.nextToken();
		matrix_starting_pos = stk.nextToken();
		matrix_colSpans		= stk.nextToken();

	}
}
%>
<HTML>
<HEAD>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eAM/js/DiscrMsrComp.js' language='javascript'></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<SCRIPT LANGUAGE="JavaScript">
function showMat(flag)
{
	if(document.templateComponentRowColDefForm.matrix_cols.value == "" || document.templateComponentRowColDefForm.matrix_rows.value=="")
	{
		error = getMessage("AM0169","AM");
        //messageFrameReference.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;
        parent.messageframe.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;
		return false;
		
	}else{
		messageFrameReference.location.href ="../../eCommon/jsp/MstCodeError.jsp";
	}
	var matrix_max_columns_allowed = parseInt((document.templateComponentRowColDefForm.matrix_max_columns_allowed.value==""?"0":document.templateComponentRowColDefForm.matrix_max_columns_allowed.value));
	var error = "";
	var matrix_cols =		parseInt((document.templateComponentRowColDefForm.matrix_cols.value==""?"0":document.templateComponentRowColDefForm.matrix_cols.value));
	var matrix_rows = parseInt((document.templateComponentRowColDefForm.matrix_rows.value==""?"0":document.templateComponentRowColDefForm.matrix_rows.value));	
	var matrix_starting_pos = parseInt(document.templateComponentRowColDefForm.matrix_starting_pos.value);
	if(matrix_starting_pos == "")
		document.templateComponentRowColDefForm.matrix_starting_pos.value = "1";

	var matrixComponentDefinition = document.templateComponentRowColDefForm.matrixComponentDefinition.value;
	var componentDefinition = "";
	//alert("matrixComponentDefinition...."+matrixComponentDefinition);
	//if(matrixComponentDefinition != "")
	//	componentDefinition = matrixComponentDefinition.split("$$$")[4] + "$$$" + matrixComponentDefinition.split("$$$")[5] + "$$$" + matrixComponentDefinition.split("$$$")[6]+ "$$$" + matrixComponentDefinition.split("$$$")[7]  + "$$$" + matrixComponentDefinition.split("$$$")[8] ;

/*alert(matrix_cols);
	if(matrix_cols == "" && matrix_rows == "")
	{alert("135");

		//error = ('APP-CA1050 Please enter all the mandatory fields.... ');
		error = getMessage("AM0169","AM");

		messageFrameReference.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
		return false;
	}else{
		messageFrameReference.location.href ="../../eCommon/jsp/MstCodeError.jsp";
	}*/


	/* if(matrix_cols == 0)
	{
		
		error = getMessage("AM0170","AM");
		error = error.replace("$",'Matrix Columns');
		messageFrameReference.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
		return false;
	}else{
		messageFrameReference.location.href ="../../eCommon/jsp/MstCodeError.jsp";
	}
	if(matrix_rows == 0)
	{
		
		error = getMessage("AM0170","AM");
		error = error.replace("$",'Matrix Rows');
		messageFrameReference.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
		return false;
	}
    else{
		messageFrameReference.location.href ="../../eCommon/jsp/MstCodeError.jsp";
	}*/

	
	var totalColspan = 0;
	var mat_colSpan = "";
	for(var i=0;i<parseInt(matrix_cols);i++)
	{
		var matcolspan_value = parseInt(eval("document.templateComponentRowColDefForm.matrixColSpan" + i + ".value"));
		if(isNaN(matcolspan_value))
		{
			//alert('APP-AM1050 The colspan for columns position ' + (i+1) + ' has not been entered... ');
			err = getMessage("AM0145","AM");
			err = err.replace("$",(i+1));
			alert(err);
			//messageFrameReference.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0";
			parent.messageframe.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;
			return false;
		}
		totalColspan += parseInt(matcolspan_value);
	
		if(mat_colSpan == "")
			mat_colSpan += matcolspan_value;
		else
			mat_colSpan += "~" + matcolspan_value;
	}
	document.templateComponentRowColDefForm.matrix_colSpans.value = mat_colSpan;
	//alert((totalColspan + matrix_starting_pos - 1 )+ ">" + (matrix_max_columns_allowed ));
	if((totalColspan + matrix_starting_pos - 1) > (matrix_max_columns_allowed ))
	{
		//alert('APP-AM1050 The total colspan should be less than or equal to ' + matrix_max_columns_allowed + '.... ');
		err1=getMessage("AM0146","AM");
		err1 = err1.replace("$",matrix_max_columns_allowed);
		alert(err1);

		return false;
	}
	var action_url = "../../eAM/jsp/DiscrMsrCompMatrixAddModify.jsp?mode=<%=mode%>&matrixID=<%=matrixID%>&matrixDesc=<%=matrixDesc%>&matrix_rows=" + matrix_rows + "&matrix_cols=" + matrix_cols + "&mat_colSpan=" + mat_colSpan + "&matrix_max_columns_allowed=" + matrix_max_columns_allowed + "&matrix_starting_pos=" + matrix_starting_pos+ "&flag=" + flag;	
	//if(flag != 'new')	
		//action_url += "&componentDefinition=" + escape(componentDefinition);
	
	parent.templateComponentMatrixAddModifyFrame.document.location.href =action_url;
	parent.templateComponentMatrixPreviewFrame.document.location.href = "../../eCommon/html/blank.html";
}
</SCRIPT>



</HEAD>
<BODY onKeyDown = 'lockKey()' onload='myfocus()'>
<form name = "templateComponentRowColDefForm" id ="templateComponentRowColDefForm" >
	<table width="99%" align="center" border='0' cellspacing='0' cellpadding='1'>
		<tr>
			<th colspan="5">
				<fmt:message key="Common.MatrixAttributes.label" bundle="${common_labels}"/>
			</th>
		</tr>
		<tr id="matrix_row_col_def">
			<td  class='label' width="17%">
				<fmt:message key="Common.MatrixColumns.label" bundle="${common_labels}"/> 
			<!-- </td>
			<td   class='fields' width="6%"> -->
				<input type="text" name="matrix_cols" id="matrix_cols" value="<%=matrix_cols%>" size="2" maxlength="2" onKeyPress='return ChkNumberInput(this,event,0)' onblur = "checkValue(this, <%=matrix_max_columns_allowed%>, 'Matrix Columns');" tabindex='1'><img src='../../eCommon/images/mandatory.gif'></img>
			</td>
			<td  class='label' width="15%" id='tdid'>
				<fmt:message key="Common.MatrixRows.label" bundle="${common_labels}"/>  
			<!-- </td>
			<td   class='fields' width="6%"> -->
				<input type="text" name="matrix_rows" id="matrix_rows" value="<%=matrix_rows%>" size="2" maxlength="2" onKeyPress='return ChkNumberInput(this,event,0)' onblur="checkValRow(this);"><img src='../../eCommon/images/mandatory.gif'></img>
			</td>
			<input type="hidden" size="2" name="matrix_starting_pos" id="matrix_starting_pos" value="<%=matrix_starting_pos%>">
		<!--/tr-->
		<td>
		<table width="99%" align="left" border='0' cellspacing='0' cellpadding='0'>
		<tr id="matrix_colSpan_def" style=<%=matrixComponentDefinition.equals("")?"display:none":""%>>				
			<td class='label' id = "matrix_colSpan_row_mat" align='right' width="30%"><fmt:message key="Common.MatrixColumnSpan.label" bundle="${common_labels}"/></td>
			<td class='fields' width="70%" id = "matrix_colSpan_row_def" align='left'>
				<%
					if(!matrixComponentDefinition.equals(""))
					{
						StringTokenizer stk_temp = new StringTokenizer(matrix_colSpans, "~");
						int i = 0;
						while(stk_temp.hasMoreTokens())
						{
							out.println("<input type='text' size='1' maxlength='1' onKeyPress='return(ChkNumberInput(this,event,0))' name='matrixColSpan" + i++ + "' id='matrixColSpan" + i++ + "' value=\"" + stk_temp.nextToken() + "\" >");
						}
					}

				%>
			</td>
			</tr>
			</table>
			</td>
		<!-- </tr>
		<tr> -->
			<td colspan="2" ><!-- colspan="6" align='center'> -->
				<input type="button" name="showMatrix" id="showMatrix" size="50" value="Show Matrix" onclick="showMat('new')" class="button" >
			</td>
		</tr>
	</table>
	<input type="hidden" name="matrix_max_columns_allowed" id="matrix_max_columns_allowed" value="<%=matrix_max_columns_allowed%>">
	<input type="hidden" name="matrixComponentDefinition" id="matrixComponentDefinition" value="<%=matrixComponentDefinition%>">
	<input type="hidden" name="matrix_colSpans" id="matrix_colSpans" value="">
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
</form>
</BODY>
</HTML>
<%
if(!matrixComponentDefinition.equals(""))
{%>
	<script>
		showMat();		
	</script>
<%}
%>

