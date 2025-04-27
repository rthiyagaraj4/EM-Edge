<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*,java.net.*,java.text.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<HTML>
<HEAD>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eAM/js/DiscrMsrComp.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<TITLE><fmt:message key="Common.MatrixDefinition.label" bundle="${common_labels}"/></TITLE>
<script>
async function callDialogCol(obj,temp)
{
	var comp_id = document.matrixDefinitionForm.matrixID.value;
	var action_url='../../eCA/jsp/CASectionTemplateMessageFrame.jsp';
	var retVal	=	"";
	var dialogHeight= "85vh" ;
	var dialogWidth	= "70vw" ;
	var arguments	= "Message" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;scroll=auto"; 
	var title			= encodeURIComponent(getLabel("Common.DiscreteMeasure.label","common"));

	retVal = await window.showModalDialog("../../eCA/jsp/CASectionTemplateMessageFrame.jsp?label_type=P&comp_id="+comp_id+"&title="+title,arguments,features);	
	if(retVal!=null)
	{
		/* var matrixHeaderId = eval("document.matrixDefinitionForm.matrixColHeaderId_C_"+temp);
		var matrixHeaderVal = eval("document.matrixDefinitionForm.matrixColHeader_"+temp); */
		
		var matrixHeaderId = document.getElementById("matrixColHeaderId_C_"+temp);
		var matrixHeaderVal = document.getElementById("matrixColHeader_"+temp); 
		
		matrixHeaderId.value = retVal[0];
		matrixHeaderVal.value = retVal[1];

	}

}
async function callDialogRow(temp)
{
	var comp_id = document.matrixDefinitionForm.matrixID.value;
	var action_url='../../eCA/jsp/CASectionTemplateMessageFrame.jsp';
	var retVal	=	"";
	var dialogHeight= "85vh" ;
	var dialogWidth	= "70vw" ;
	var arguments	= "Message" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;scroll=auto"; 
	var title			= encodeURIComponent(getLabel("Common.DiscreteMeasure.label","common"));
	retVal = await window.showModalDialog("../../eCA/jsp/CASectionTemplateMessageFrame.jsp?label_type=P&comp_id="+comp_id+"&title="+title,arguments,features);	
	
	if(retVal!=null)
	{
		/* var matrixHeaderId = "document.matrixDefinitionForm.matrixRowHeaderId_R_"+temp;
		var matrixHeaderVal = "document.matrixDefinitionForm.matrixRowHeader_"+temp;
		 */
		var matrixHeaderId = document.getElementById("matrixRowHeaderId_R_"+temp);
		var matrixHeaderVal = document.getElementById("matrixRowHeader_"+temp);
		
		matrixHeaderId.value = retVal[0];
		matrixHeaderVal.value = retVal[1];
		
	}

}
function clearComponent(row, col)
{
	var memberComp = eval("document.matrixDefinitionForm.member_compID" + row + col);
	var member_compDesc = eval("document.matrixDefinitionForm.member_compDesc" + row + col);
	var member_compType = eval("document.matrixDefinitionForm.member_compType" + row + col);
	memberComp.value = "";
	member_compDesc.value = "";
	member_compType.value = "";		
}
async function callComponentLookUp(obj, row, col)
{	
	var retVal	=	"";
	var dialogHeight= "85vh" ;
	var dialogWidth	= "65vw" ;
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;scroll=auto"; 
	retVal = await window.showModalDialog("../../eAM/jsp/DiscrMsrCompLookupMain.jsp?calledFrom=MA",arguments,features);
	if(retVal != null)
	{
		var memberComp = eval("document.matrixDefinitionForm.member_compID" + row + col);
		var member_compDesc = eval("document.matrixDefinitionForm.member_compDesc" + row + col);
		var member_compType = eval("document.matrixDefinitionForm.member_compType" + row + col);
		memberComp.value = retVal[0];
		member_compDesc.value = retVal[1];
		member_compType.value = retVal[2];
	}	
}
function showPreview()
{
	var matrix_cols = parent.templateComponentRowColDefFrame.document.templateComponentRowColDefForm.matrix_cols.value;
	var matrix_rows = parent.templateComponentRowColDefFrame.document.templateComponentRowColDefForm.matrix_rows.value;
    if(matrix_cols == 0 || matrix_rows == 0)
	{
		//error = ('APP-CA1050 Please enter all the mandatory fields.... ');
		error = getMessage("AM0169","AM");

		messageFrameReference.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	

		return false;
	}

	var matrixComponentDefinition = parent.matrixToolbarFrame.checkMatrix();
	//alert("matrixComponentDefinition=="+matrixComponentDefinition);
	var matrixID = document.matrixDefinitionForm.matrixID.value;
	var matrixDesc = document.matrixDefinitionForm.matrixDesc.value;
	var matrix_max_columns_allowed = document.matrixDefinitionForm.matrix_max_columns_allowed.value;
//alert("matrixComponentDefinition1=="+matrixComponentDefinition);
	if(matrixComponentDefinition != "")
	{
		/*parent.templateComponentMatrixPreviewFrame.document.location.href = "../../eAM/jsp/DiscrMsrCompMatrixPreview.jsp?matrixComponentDefinition=" + escape(matrixComponentDefinition) + "&matrixID=" + matrixID + "&matrixDesc=" + matrixDesc + "&matrix_max_columns_allowed=" + matrix_max_columns_allowed;*/
      
		var action_url = "../../eAM/jsp/DiscrMsrCompMatrixPreview.jsp";
		var HTMLVal			=	"<html><body onKeyDown = 'lockKey()'><form name='dummy' id='dummy' method='POST' action='"+action_url+"' target='templateComponentMatrixPreviewFrame'>"+
							"<input type='hidden' name='matrixComponentDefinition' id='matrixComponentDefinition' value='"+escape(matrixComponentDefinition)+"'>"+
							"<input type='hidden' name='matrixID' id='matrixID' value='"+matrixID+"'>"+
							"<input type='hidden' name='matrixDesc' id='matrixDesc' value='"+matrixDesc+"'>"+
							"<input type='hidden' name='matrix_max_columns_allowed' id='matrix_max_columns_allowed' value='"+matrix_max_columns_allowed+"'>"+
							"</form></body></html>";
							//alert("HTMLVal="+HTMLVal);
	parent.messageframe.document.write(HTMLVal);
	parent.messageframe.document.forms[0].submit();
	}
}
function CheckForSpecCharsAndSpace(event)
{
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}
</script>
</HEAD>
<BODY onKeyDown = 'lockKey()'>
<script>
	document.body.style.scrollbarBaseColor='#E2E3F0';
	document.body.style.scrollbarArrowColor='#000080';
</script>
<form name="matrixDefinitionForm" id="matrixDefinitionForm">
<%
try
{
	request.setCharacterEncoding("UTF-8");
	int total_columns_occupied = 0;
	//int total_columns_not_occupied = 0;
	StringTokenizer rowHeaders = null	,	colHeaders	=	null;
	StringTokenizer componentDetails	=	null;
	StringTokenizer rowHeadersId = null;
	StringTokenizer colHeadersId = null;
	Connection con = null;
	PreparedStatement stmt1=null;
	ResultSet rset1=null;
	StringBuffer paragraphDefinition=new StringBuffer();
	String mode="";
    mode=(request.getParameter("mode")==null)?"":request.getParameter("mode");

	String matrixComponentDefinition = "";
	int colcount=0;

	String matrixID = request.getParameter("matrixID")==null?"0":request.getParameter("matrixID");
	String componentDefinition = ""; //request.getParameter("componentDefinition")==null?"":request.getParameter("componentDefinition");

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
	//out.println("<script>alert('matrixComponentDefinition ...."+matrixComponentDefinition+"')</script>");
	if(matrixComponentDefinition != "")
	{
	//String strs[] = beanval.split("\\|");	
	//out.println("matrixComponentDefinition"+ matrixComponentDefinition);
	StringTokenizer stCD = new StringTokenizer(matrixComponentDefinition, "$$$");
	//out.println("stCD===="+stCD);
	
	while(stCD.hasMoreTokens())
				{
					String dummy = stCD.nextToken();
					 dummy = stCD.nextToken();
					 dummy = stCD.nextToken();
					 dummy = stCD.nextToken();
					 componentDefinition= stCD.nextToken()+"$$$"+stCD.nextToken()+"$$$"+stCD.nextToken()+"$$$"+stCD.nextToken()+"$$$"+stCD.nextToken();
					componentDefinition= java.net.URLDecoder.decode(componentDefinition,"UTF-8");
					
				}
	//out.println("componentDefinition"+ componentDefinition);

	//String componentDefinition_temp[] = matrixComponentDefinition.split("$$$");
	//out.println("<script>alert('length ...."+componentDefinition_temp[0]+"')</script>");
	//componentDefinition = componentDefinition_temp[4]+"$$$"+componentDefinition_temp[5]+"$$$"+componentDefinition_temp[6]+"$$$"+componentDefinition_temp[7]+"$$$"+componentDefinition_temp[8];
	//componentDefinition = (matrixComponentDefinition.split("$$$")).[4] + "$$$" + (matrixComponentDefinition.split("$$$")).[5] + "$$$" + (matrixComponentDefinition.split("$$$")).[6]+ "$$$" + (matrixComponentDefinition.split("$$$")).[7]  + "$$$" + (matrixComponentDefinition.split("$$$")).[8] ;
	}
	//out.println("<script>alert('componentDefinition ...."+componentDefinition+"')</script>");
	// addition ends..

	
	if(!componentDefinition.equals(""))
	
	{
		StringTokenizer st = new StringTokenizer(componentDefinition, "$$$");
		componentDetails = new StringTokenizer(st.nextToken(), "|");
		colHeaders = new StringTokenizer(st.nextToken(), "~");
		rowHeaders = new StringTokenizer(st.nextToken(), "~");
		colHeadersId  = new StringTokenizer(st.nextToken(), "~");
		rowHeadersId =   new StringTokenizer(st.nextToken(), "~");

		 colcount=colHeadersId.countTokens();
		//out.println("colcount==="+colcount);
		//out.println("more tokens"+colHeadersId.hasMoreTokens());

	}	
}
	int row_count=0;
	if(mode.equals("update"))
	{
		 row_count=rowHeaders.countTokens();
	}
	//out.println("row_count" + row_count);
    
	String matrixDesc = request.getParameter("matrixDesc")==null?"0":request.getParameter("matrixDesc");
   
	int matrix_rows					= Integer.parseInt(request.getParameter("matrix_rows")==null?"0":request.getParameter("matrix_rows"));
	
	
	int matrix_cols					= Integer.parseInt(request.getParameter("matrix_cols")==null?"0":request.getParameter("matrix_cols"));
	
	String mat_colSpan				= request.getParameter("mat_colSpan")==null?"0":request.getParameter("mat_colSpan");	
	
	int matrix_starting_pos			= Integer.parseInt(request.getParameter("matrix_starting_pos")==null?"0":request.getParameter("matrix_starting_pos"));
	
	int matrix_max_columns_allowed	= Integer.parseInt(request.getParameter("matrix_max_columns_allowed")==null?"0":request.getParameter("matrix_max_columns_allowed"));
    String table_width="";
	String allignment="";
  
 
	StringTokenizer st = new StringTokenizer(mat_colSpan, "~");
	

	int colSpan_arr[] = new int[st.countTokens()];
	int count=0;
	int temp = 0;

	while(st.hasMoreTokens())
		colSpan_arr[count++] = Integer.parseInt(st.nextToken());

	for(int i=0;i<colSpan_arr.length;i++)
		total_columns_occupied += colSpan_arr[i];

	total_columns_occupied += 1;
	
	if(matrix_cols>0 && matrix_cols<=7)
	{
		table_width="99%";
	     allignment="center";
	}
	else if(matrix_cols==8)
	{
        table_width="110%";
		allignment="left";
	}
	else if(matrix_cols==9)
	{
        table_width="120%";
		allignment="left";
	}
	else
	{
	    table_width="140%";
		allignment="left";
	}
	//total_columns_not_occupied = (matrix_max_columns_allowed - total_columns_occupied  );	
	out.println("<table id = 'matrixDefinitionTable' name = 'matrixDefinitionTable' border=\"0\" width='" + table_width + "'  cellspacing=\"0\" cellpadding=\"0\">");
	out.println("<tr>");
	out.println("<th colspan='" + (matrix_max_columns_allowed+1) + "' align='left' title = 'Matrix Description...' >");
	out.println(matrixDesc);
	out.println("</th>");
	out.println("</tr>");	
	out.println("<tr>");
	out.println("<td width='10%' align='center' style='BACKGROUND-COLOR:#9499C7;color:black;font-size:10pt;font-weight:normal;' >");
    out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.RowColumnHeader.label","am_labels"));
	out.println("</td>");
	int columnHeaderCount	= 0 , columnHeaderCountValue = 0 ,	rowHeaderCount	= 0, rowHeaderCountValue = 0;
	int countX				= 0 ,	countY			= 0;
	/*for(int i=1;i<matrix_starting_pos;i++)
	{
		out.println("<th width='5%'>");
		out.println("</th>");	
	}*/
		
		//out.println("columnHeaderCount:::"+columnHeaderCount);

	if (!mode.equals("insert")){	// modify 	

			temp = 0;
		for(int i=0;i<matrix_cols;i++)	{
			
			columnHeaderCountValue = columnHeaderCount++;
			
			if(colHeadersId.hasMoreTokens()){
				float colWidth = ((new Integer(colSpan_arr[i]).floatValue())/matrix_max_columns_allowed)*100;
				out.println("<th colspan = '" + colSpan_arr[i] + "' width='" + colWidth + "%' align='"+allignment+"' style='BACKGROUND-COLOR:#9499C7;color:black;font-size:10pt;font-weight:normal;'>");
				out.println("<input type=\"text\" name=\"matrixColHeader_" + columnHeaderCountValue + "\" id=\"matrixColHeader_" + columnHeaderCountValue + "\" readonly size=\"30\" maxlength=\"30\" value=\"" + (componentDefinition.equals("")?"":colHeaders.nextToken()) + "\" onkeypress=\"return CheckForSpecCharsAndSpace(event)\" >");
				out.println("<input type=\"button\" name=\"matrixColHeaderBtn_C_"+temp+"\" id=\"matrixColHeaderBtn_C_"+temp+"\" value=\"?\"    class=\"button\" onclick=\"callDialogCol(this,"+temp+")\" >");
				out.println("<input type=\"hidden\" name=\"matrixColHeaderId_C_"+temp+"\" id=\"matrixColHeaderId_C_"+temp+"\" value=\"" + (componentDefinition.equals("")?"":colHeadersId.nextToken()) + "\">");
				out.println("</th>");
				temp++;
				
			}else{
				float colWidth = ((new Integer(colSpan_arr[i]).floatValue())/matrix_max_columns_allowed)*100;
				out.println("<th colspan = '" + colSpan_arr[i] + "' width='" + colWidth + "%' align='"+allignment+"' style='BACKGROUND-COLOR:#9499C7;color:black;font-size:10pt;font-weight:normal;'>");

				out.println("<input type=\"text\" name=\"matrixColHeader_" + columnHeaderCountValue + "\" id=\"matrixColHeader_" + columnHeaderCountValue + "\"  readonly size=\"30\" maxlength=\"30\"  onkeypress=\"return CheckForSpecCharsAndSpace(event)\" >");
				out.println("<input type=\"button\" name=\"matrixColHeaderBtn_C_"+temp+"\" id=\"matrixColHeaderBtn_C_"+temp+"\" value=\"?\"    class=\"button\" onclick=\"callDialogCol(this,"+temp+")\" >");

				out.println("<input type=\"hidden\" name=\"matrixColHeaderId_C_"+temp+"\" id=\"matrixColHeaderId_C_"+temp+"\" >");
				out.println("</th>");
				temp++;
			}
		}
	}else{ // insert


			temp = 0;
			for(int i=0;i<matrix_cols;i++) 			{
				
				columnHeaderCountValue = columnHeaderCount++;

				float colWidth = ((new Integer(colSpan_arr[i]).floatValue())/matrix_max_columns_allowed)*100;
				out.println("<th colspan = '" + colSpan_arr[i] + "' width='" + colWidth + "%' align='"+allignment+"' style='BACKGROUND-COLOR:#9499C7;color:black;font-size:10pt;font-weight:normal;'>");
				out.println("<input type=\"text\" name=\"matrixColHeader_" + columnHeaderCountValue + "\" id=\"matrixColHeader_" + columnHeaderCountValue + "\"  readonly size=\"30\" maxlength=\"30\" value=\"" + (componentDefinition.equals("")?"":colHeaders.nextToken()) + "\" onkeypress=\"return CheckForSpecCharsAndSpace(event)\" >");
				out.println("<input type=\"button\" name=\"matrixColHeaderBtn_C_"+temp+"\" id=\"matrixColHeaderBtn_C_"+temp+"\" value=\"?\"    class=\"button\" onclick=\"callDialogCol(this,"+temp+")\" >");
				out.println("<input type=\"hidden\" name=\"matrixColHeaderId_C_"+temp+"\" id=\"matrixColHeaderId_C_"+temp+"\" value=\"" + (componentDefinition.equals("")?"":colHeadersId.nextToken()) + "\">");
				out.println("</th>");
				temp++;
			}
	}


	//// after first mode check

	/*for(int i=0;i<total_columns_not_occupied;i++)
		out.println("<th width=\"5%\"style='BACKGROUND-COLOR:#9499C7;color:black;font-size:10pt;font-weight:normal;'></th>");*/
	out.println("</tr>");

if (!mode.equals("insert")){ // modify
		 if(rowHeadersId.hasMoreTokens()){
			temp = 0;
			
					for(int i=0;i<matrix_rows;i++){
						rowHeaderCountValue = rowHeaderCount++;
						out.println("<tr>");

						for(int x=1;x<matrix_starting_pos;x++){
							out.println("<td width='5%'>");
							out.println("</td>");	
						}
						
						if(i<row_count){
							if(rowHeadersId.hasMoreTokens()){

								out.println("<th width='10%' style='BACKGROUND-COLOR:#9499C7;color:black;font-size:10pt;font-weight:normal;'>");
								out.println("<input type=\"text\" name=\"matrixRowHeader_" + rowHeaderCountValue + "\" id=\"matrixRowHeader_" + rowHeaderCountValue + "\"   readonly size=\"30\" maxlength=\"30\"  value=\"" + (componentDefinition.equals("")?"":rowHeaders.nextToken()) + "\" onkeypress=\"return CheckForSpecCharsAndSpace(event)\">");
								out.println("<input type=\"button\" name=\"matrixRowHeaderBtn_R_" +temp+"\" id=\"matrixRowHeaderBtn_R_" +temp+"\" value=\"?\" class=\"button\" onclick=\"callDialogRow("+ temp+")\">");
								out.println("<input type=\"hidden\" name=\"matrixRowHeaderId_R_"+temp+"\" id=\"matrixRowHeaderId_R_"+temp+"\" value=\"" + (componentDefinition.equals("")?"":rowHeadersId.nextToken()) + "\">");
								out.println("</th>");	
							}
								

						}else{
							out.println("<th width='10%' style='BACKGROUND-COLOR:#9499C7;color:black;font-size:10pt;font-weight:normal;'>");
							out.println("<input type=\"text\" name=\"matrixRowHeader_" + rowHeaderCountValue + "\" id=\"matrixRowHeader_" + rowHeaderCountValue + "\"   readonly size=\"30\" maxlength=\"30\"  onkeypress=\"return CheckForSpecCharsAndSpace(event)\">");
							out.println("<input type=\"button\" name=\"matrixRowHeaderBtn_R_" +temp+"\" id=\"matrixRowHeaderBtn_R_" +temp+"\" value=\"?\" class=\"button\" onclick=\"callDialogRow("+ temp+")\">");
							out.println("<input type=\"hidden\" name=\"matrixRowHeaderId_R_"+temp+"\" id=\"matrixRowHeaderId_R_"+temp+"\" >");
							out.println("</th>");
						}
						temp++;
						countY=0;
						//out.println("matrix_cols1=="+matrix_cols);
						

						for(int j=0;j<matrix_cols;j++)	{
							StringTokenizer st_temp = null;
							String value1 = "";
							String value2 = "";
							String value3 = "";
							
							if(i>=row_count){
								float colWidth = ((new Integer(colSpan_arr[j]).floatValue())/matrix_max_columns_allowed)*100;
								out.println("<td align='center' colspan='" + colSpan_arr[j] + "' width='" + colWidth + "%'>");
								out.println("<input type=\"text\" name=\"member_compDesc" + countX + countY + "\" id=\"member_compDesc" + countX + countY + "\" readonly size=\"30\"><input type=\"hidden\" name=\"member_compID" + countX + countY + "\" id=\"member_compID" + countX + countY + "\" readonly ><input type=\"hidden\" name=\"member_compType" + countX + countY + "\" id=\"member_compType" + countX + countY + "\" readonly >&nbsp;<input type=\"button\" value=\"?\" class=\"button\" onclick=\"callComponentLookUp(this," + countX + "," + countY + " )\"><input type=\"button\" value=\"X\" class=\"button\" onclick=\"clearComponent(" + countX + "," + countY + ")\" title='Clear this component..'>&nbsp;");
								out.println("</td>");
							}else{

													
								if(j<colcount){
									if(!componentDefinition.equals("")) {
										String compDet = componentDetails.nextToken();
										//out.println("compDet=>" + compDet);
										st_temp = new StringTokenizer(compDet, "~");	
									}

									 if(st_temp.hasMoreTokens()){		

										value1 = st_temp.nextToken();//Component Description
										value2 = st_temp.nextToken();//Component ID
										value3 = st_temp.nextToken();//Component Type
										value1 = value1.equals("9999999999")?"":value1;
										value2 = value2.equals("9999999999")?"":value2;
										value3 = value3.equals("9999999999")?"":value3;

										float colWidth = ((new Integer(colSpan_arr[j]).floatValue())/matrix_max_columns_allowed)*100;
										out.println("<td align='center' colspan='" + colSpan_arr[j] + "' width='" + colWidth + "%'>");
										out.println("<input type=\"text\" name=\"member_compDesc" + countX + countY + "\" id=\"member_compDesc" + countX + countY + "\" readonly size=\"30\"  value=\"" + value2 + "\"><input type=\"hidden\" name=\"member_compID" + countX + countY + "\" id=\"member_compID" + countX + countY + "\" readonly value=\"" + value1 + "\"><input type=\"hidden\" name=\"member_compType" + countX + countY + "\" id=\"member_compType" + countX + countY + "\" readonly value=\"" + value3 + "\">&nbsp;<input type=\"button\" value=\"?\" class=\"button\" onclick=\"callComponentLookUp(this," + countX + "," + countY + " )\"><input type=\"button\" value=\"X\" class=\"button\" onclick=\"clearComponent(" + countX + "," + countY + ")\" title='Clear this component..'>&nbsp;");
										out.println("</td>");
									 }

								 }else{

										float colWidth = ((new Integer(colSpan_arr[j]).floatValue())/matrix_max_columns_allowed)*100;
										out.println("<td align='center' colspan='" + colSpan_arr[j] + "' width='" + colWidth + "%'>");
										out.println("<input type=\"text\" name=\"member_compDesc" + countX + countY + "\" id=\"member_compDesc" + countX + countY + "\" readonly size=\"30\"><input type=\"hidden\" name=\"member_compID" + countX + countY + "\" id=\"member_compID" + countX + countY + "\" readonly ><input type=\"hidden\" name=\"member_compType" + countX + countY + "\" id=\"member_compType" + countX + countY + "\" readonly >&nbsp;<input type=\"button\" value=\"?\" class=\"button\" onclick=\"callComponentLookUp(this," + countX + "," + countY + " )\"><input type=\"button\" value=\"X\" class=\"button\" onclick=\"clearComponent(" + countX + "," + countY + ")\" title='Clear this component..'>&nbsp;");
										out.println("</td>");
								}		
							}

							
							countY++;
							//out.println("391");
						}
					countX++;

					out.println("</tr>");
				}
		 }
}else{ // insert
	temp = 0;
		for(int i=0;i<matrix_rows;i++) {
			rowHeaderCountValue = rowHeaderCount++;
			out.println("<tr>");
			for(int x=1;x<matrix_starting_pos;x++) {
				out.println("<td width='5%'>");
				out.println("</td>");	
			}

			out.println("<th width='10%' style='BACKGROUND-COLOR:#9499C7;color:black;font-size:10pt;font-weight:normal;'>");
			out.println("<input type=\"text\" name=\"matrixRowHeader_" + rowHeaderCountValue + "\" id=\"matrixRowHeader_" + rowHeaderCountValue + "\"   readonly size=\"10\" maxlength=\"30\" width='10%'  onkeypress=\"return CheckForSpecCharsAndSpace(event)\">");
			out.println("<input type=\"button\" name=\"matrixRowHeaderBtn_R_" +temp+"\" id=\"matrixRowHeaderBtn_R_" +temp+"\" value=\"?\" class=\"button\" onclick=\"callDialogRow("+ temp+")\">");
			out.println("<input type=\"hidden\" name=\"matrixRowHeaderId_R_"+temp+"\" id=\"matrixRowHeaderId_R_"+temp+"\">");
			out.println("</th>");	
			//out.println("rowHeaderCount="+rowHeaderCount);
			//out.println("364");
			temp++;
			countY=0;
			 //out.println("matrix_cols1=="+matrix_cols);
			for(int j=0;j<matrix_cols;j++) 	{
				StringTokenizer st_temp = null;
				String value1 = "";
				String value2 = "";
				String value3 = "";

				if(!componentDefinition.equals("")) {
					String compDet = componentDetails.nextToken();
					st_temp = new StringTokenizer(compDet, "~");
					value1 = st_temp.nextToken();//Component Description
					value2 = st_temp.nextToken();//Component ID
					value3 = st_temp.nextToken();//Component Type
					value1 = value1.equals("9999999999")?"":value1;
					value2 = value2.equals("9999999999")?"":value2;
					value3 = value3.equals("9999999999")?"":value3;
				}

				float colWidth = ((new Integer(colSpan_arr[j]).floatValue())/matrix_max_columns_allowed)*100;
				out.println("<td align='center' colspan='" + colSpan_arr[j] + "' width='" + colWidth + "%'>");
				out.println("<input type=\"text\" name=\"member_compDesc" + countX + countY + "\" id=\"member_compDesc" + countX + countY + "\" readonly size=\"30\"  value=\"" + value2 + "\"><input type=\"hidden\" name=\"member_compID" + countX + countY + "\" id=\"member_compID" + countX + countY + "\" readonly value=\"" + value1 + "\"><input type=\"hidden\" name=\"member_compType" + countX + countY + "\" id=\"member_compType" + countX + countY + "\" readonly value=\"" + value3 + "\">&nbsp;<input type=\"button\" value=\"?\" class=\"button\" onclick=\"callComponentLookUp(this," + countX + "," + countY + " )\"><input type=\"button\" value=\"X\" class=\"button\" onclick=\"clearComponent(" + countX + "," + countY + ")\" title='Clear this component..'>&nbsp;");
				out.println("</td>");
				countY++;
				//out.println("391");
			}
			countX++;
			//out.println("<script>alert('total_columns_not_occupied=" + total_columns_not_occupied + "');</script>");
			/*for(int count_temp=0;count_temp<total_columns_not_occupied;count_temp++)
			out.println("<td width=\"5%\"></td>");	  */

			out.println("</tr>");
		}
}

 // after mode check

	out.println("</table>");
	out.println("<table width='" + table_width + "'>");
	out.println("<tr>");
	out.println("<td align='right' colspan='" + (matrix_cols + 1) + "'>");
	out.println("<input type=\"button\" value=\"Show Preview\" class='button' onclick='showPreview()'>");
	out.println("</td>");
	out.println("</tr>");
	out.println("</table>");%>
	<input type="hidden" name="matrixID" id="matrixID" value="<%=matrixID%>">
	<input type="hidden" name="matrixDesc" id="matrixDesc" value="<%=matrixDesc%>">
	<input type="hidden" name="matrix_max_columns_allowed" id="matrix_max_columns_allowed" value="<%=matrix_max_columns_allowed%>">
	
	<%
	if(!componentDefinition.equals(""))
	{
%>
		<SCRIPT LANGUAGE="JavaScript">showPreview();</SCRIPT><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>
	<%}
}
catch(Exception e)
{
	out.println(e);
	e.printStackTrace(System.err);
}
%>
</form>
</BODY>
</HTML>

