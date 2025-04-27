package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __discrmsrcompmatrixaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/eam/jsp/DiscrMsrCompMatrixAddModify.jsp", 1732594736823L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n<HEAD>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eAM/js/DiscrMsrComp.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<TITLE>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</TITLE>\n<script>\nasync function callDialogCol(obj,temp)\n{\n\tvar comp_id = document.matrixDefinitionForm.matrixID.value;\n\tvar action_url=\'../../eCA/jsp/CASectionTemplateMessageFrame.jsp\';\n\tvar retVal\t=\t\"\";\n\tvar dialogHeight= \"85vh\" ;\n\tvar dialogWidth\t= \"70vw\" ;\n\tvar arguments\t= \"Message\" ;\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no;scroll=auto\"; \n\tvar title\t\t\t= encodeURIComponent(getLabel(\"Common.DiscreteMeasure.label\",\"common\"));\n\n\tretVal = await window.showModalDialog(\"../../eCA/jsp/CASectionTemplateMessageFrame.jsp?label_type=P&comp_id=\"+comp_id+\"&title=\"+title,arguments,features);\t\n\tif(retVal!=null)\n\t{\n\t\t/* var matrixHeaderId = eval(\"document.matrixDefinitionForm.matrixColHeaderId_C_\"+temp);\n\t\tvar matrixHeaderVal = eval(\"document.matrixDefinitionForm.matrixColHeader_\"+temp); */\n\t\t\n\t\tvar matrixHeaderId = document.getElementById(\"matrixColHeaderId_C_\"+temp);\n\t\tvar matrixHeaderVal = document.getElementById(\"matrixColHeader_\"+temp); \n\t\t\n\t\tmatrixHeaderId.value = retVal[0];\n\t\tmatrixHeaderVal.value = retVal[1];\n\n\t}\n\n}\nasync function callDialogRow(temp)\n{\n\tvar comp_id = document.matrixDefinitionForm.matrixID.value;\n\tvar action_url=\'../../eCA/jsp/CASectionTemplateMessageFrame.jsp\';\n\tvar retVal\t=\t\"\";\n\tvar dialogHeight= \"85vh\" ;\n\tvar dialogWidth\t= \"70vw\" ;\n\tvar arguments\t= \"Message\" ;\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no;scroll=auto\"; \n\tvar title\t\t\t= encodeURIComponent(getLabel(\"Common.DiscreteMeasure.label\",\"common\"));\n\tretVal = await window.showModalDialog(\"../../eCA/jsp/CASectionTemplateMessageFrame.jsp?label_type=P&comp_id=\"+comp_id+\"&title=\"+title,arguments,features);\t\n\t\n\tif(retVal!=null)\n\t{\n\t\t/* var matrixHeaderId = \"document.matrixDefinitionForm.matrixRowHeaderId_R_\"+temp;\n\t\tvar matrixHeaderVal = \"document.matrixDefinitionForm.matrixRowHeader_\"+temp;\n\t\t */\n\t\tvar matrixHeaderId = document.getElementById(\"matrixRowHeaderId_R_\"+temp);\n\t\tvar matrixHeaderVal = document.getElementById(\"matrixRowHeader_\"+temp);\n\t\t\n\t\tmatrixHeaderId.value = retVal[0];\n\t\tmatrixHeaderVal.value = retVal[1];\n\t\t\n\t}\n\n}\nfunction clearComponent(row, col)\n{\n\tvar memberComp = eval(\"document.matrixDefinitionForm.member_compID\" + row + col);\n\tvar member_compDesc = eval(\"document.matrixDefinitionForm.member_compDesc\" + row + col);\n\tvar member_compType = eval(\"document.matrixDefinitionForm.member_compType\" + row + col);\n\tmemberComp.value = \"\";\n\tmember_compDesc.value = \"\";\n\tmember_compType.value = \"\";\t\t\n}\nasync function callComponentLookUp(obj, row, col)\n{\t\n\tvar retVal\t=\t\"\";\n\tvar dialogHeight= \"85vh\" ;\n\tvar dialogWidth\t= \"65vw\" ;\n\tvar arguments\t= \"\" ;\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no;scroll=auto\"; \n\tretVal = await window.showModalDialog(\"../../eAM/jsp/DiscrMsrCompLookupMain.jsp?calledFrom=MA\",arguments,features);\n\tif(retVal != null)\n\t{\n\t\tvar memberComp = eval(\"document.matrixDefinitionForm.member_compID\" + row + col);\n\t\tvar member_compDesc = eval(\"document.matrixDefinitionForm.member_compDesc\" + row + col);\n\t\tvar member_compType = eval(\"document.matrixDefinitionForm.member_compType\" + row + col);\n\t\tmemberComp.value = retVal[0];\n\t\tmember_compDesc.value = retVal[1];\n\t\tmember_compType.value = retVal[2];\n\t}\t\n}\nfunction showPreview()\n{\n\tvar matrix_cols = parent.templateComponentRowColDefFrame.document.templateComponentRowColDefForm.matrix_cols.value;\n\tvar matrix_rows = parent.templateComponentRowColDefFrame.document.templateComponentRowColDefForm.matrix_rows.value;\n    if(matrix_cols == 0 || matrix_rows == 0)\n\t{\n\t\t//error = (\'APP-CA1050 Please enter all the mandatory fields.... \');\n\t\terror = getMessage(\"AM0169\",\"AM\");\n\n\t\tmessageFrameReference.location.href =\"../../eCommon/jsp/MstCodeError.jsp?err_num=\" + error + \"&err_value=0\" ;\t\n\n\t\treturn false;\n\t}\n\n\tvar matrixComponentDefinition = parent.matrixToolbarFrame.checkMatrix();\n\t//alert(\"matrixComponentDefinition==\"+matrixComponentDefinition);\n\tvar matrixID = document.matrixDefinitionForm.matrixID.value;\n\tvar matrixDesc = document.matrixDefinitionForm.matrixDesc.value;\n\tvar matrix_max_columns_allowed = document.matrixDefinitionForm.matrix_max_columns_allowed.value;\n//alert(\"matrixComponentDefinition1==\"+matrixComponentDefinition);\n\tif(matrixComponentDefinition != \"\")\n\t{\n\t\t/*parent.templateComponentMatrixPreviewFrame.document.location.href = \"../../eAM/jsp/DiscrMsrCompMatrixPreview.jsp?matrixComponentDefinition=\" + escape(matrixComponentDefinition) + \"&matrixID=\" + matrixID + \"&matrixDesc=\" + matrixDesc + \"&matrix_max_columns_allowed=\" + matrix_max_columns_allowed;*/\n      \n\t\tvar action_url = \"../../eAM/jsp/DiscrMsrCompMatrixPreview.jsp\";\n\t\tvar HTMLVal\t\t\t=\t\"<html><body onKeyDown = \'lockKey()\'><form name=\'dummy\' id=\'dummy\' method=\'POST\' action=\'\"+action_url+\"\' target=\'templateComponentMatrixPreviewFrame\'>\"+\n\t\t\t\t\t\t\t\"<input type=\'hidden\' name=\'matrixComponentDefinition\' id=\'matrixComponentDefinition\' value=\'\"+escape(matrixComponentDefinition)+\"\'>\"+\n\t\t\t\t\t\t\t\"<input type=\'hidden\' name=\'matrixID\' id=\'matrixID\' value=\'\"+matrixID+\"\'>\"+\n\t\t\t\t\t\t\t\"<input type=\'hidden\' name=\'matrixDesc\' id=\'matrixDesc\' value=\'\"+matrixDesc+\"\'>\"+\n\t\t\t\t\t\t\t\"<input type=\'hidden\' name=\'matrix_max_columns_allowed\' id=\'matrix_max_columns_allowed\' value=\'\"+matrix_max_columns_allowed+\"\'>\"+\n\t\t\t\t\t\t\t\"</form></body></html>\";\n\t\t\t\t\t\t\t//alert(\"HTMLVal=\"+HTMLVal);\n\tparent.messageframe.document.write(HTMLVal);\n\tparent.messageframe.document.forms[0].submit();\n\t}\n}\nfunction CheckForSpecCharsAndSpace(event)\n{\n    var strCheck = \'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ \';\n    var whichCode = (window.Event) ? event.which : event.keyCode;\n    key = String.fromCharCode(whichCode);  // Get key value from key code\n    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\treturn true ;\n}\n</script>\n</HEAD>\n<BODY onKeyDown = \'lockKey()\'>\n<script>\n\tdocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarArrowColor=\'#000080\';\n</script>\n<form name=\"matrixDefinitionForm\" id=\"matrixDefinitionForm\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<input type=\"hidden\" name=\"matrixID\" id=\"matrixID\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t<input type=\"hidden\" name=\"matrixDesc\" id=\"matrixDesc\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t<input type=\"hidden\" name=\"matrix_max_columns_allowed\" id=\"matrix_max_columns_allowed\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<SCRIPT LANGUAGE=\"JavaScript\">showPreview();</SCRIPT><Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

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
	out.println("</table>");
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(matrixID));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(matrixDesc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(matrix_max_columns_allowed));
            _bw.write(_wl_block11Bytes, _wl_block11);

	if(!componentDefinition.equals(""))
	{

            _bw.write(_wl_block12Bytes, _wl_block12);
}
}
catch(Exception e)
{
	out.println(e);
	e.printStackTrace(System.err);
}

            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MatrixDefinition.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }
}
