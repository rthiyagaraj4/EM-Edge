package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __discrmsrcompgridlist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/DiscrMsrCompGridList.jsp", 1741171953918L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n<style>\nTD.FIRSTSELECTED\n{\n\tBACKGROUND-COLOR: #B1C5E9;  \n\tFONT-SIZE: 9pt ;\n\tBORDER-STYLE: SOLID;\n\tborder-left-color: #B2B6D7;\n\tborder-right-color: #B2B6D7;\n\tborder-top-color: #E2E3F0;\n\tborder-bottom-color: #E2E3F0;\n\theight:18;\t\n}\n</style>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HEAD>\n<SCRIPT LANGUAGE=\"JavaScript\">\nvar firstElementSelected = false, secondElementSelected = false;\nvar firstElementIndex = 0, secondElementIndex = 0;\nfunction populateDetails(details)\n{\t//alert(details);\n\tdetails = unescape(details);\n\tvar temp = details.split(\"~\");\n\t//alert(temp);\n\t//details = (srlno + \"~\" + member_comp_id + \"~\" + member_comp_desc + \"~\" + member_comp_type + \"~\" + componentColPos + \"~\" + componentColSpan + \"~\" + (textRows==\"\"?\"NA\":textRows));\n\tvar srlno = \"\";\n\tvar member_comp_id = \"\";\n\tvar member_comp_desc = \"\";\n\tvar member_comp_type = \"\";\n\tvar componentColPos = \"\";\n\tvar componentColSpan = \"\";\n\tvar textRows = \"\";\n\tif(temp != null && temp.length == 7)\n\t{\n\t\tsrlno = escape(temp[0]);\n\t\tmember_comp_id = escape(temp[1]);\n\t\tmember_comp_desc = escape(temp[2]);\n\t\tmember_comp_type = escape(temp[3]);\n\t\tcomponentColPos = escape(temp[4]);\n\t\tcomponentColSpan = escape(temp[5]);\n\t\ttextRows = temp[6];\n\t}\nvar action_url = \'../../eAM/jsp/DiscrMsrCompGridDef.jsp?gridID=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&grid_max_columns_allowed=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&gridComponentDefinition=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&mode=Update&srlno=\' + srlno + \'&member_comp_id=\' + member_comp_id + \'&member_comp_desc=\' + escape(member_comp_desc) + \"&member_comp_type=\" + member_comp_type + \"&componentColPos=\" + componentColPos + \"&componentColSpan=\" + componentColSpan + \"&textRows=\" + textRows;\n\t//alert(action_url);\n\tparent.templateGridDefFrame.document.location.href = action_url;\n\tvar rowId_obj = document.getElementById(\'rowId\');\n\tfor(i=0;i<rowId_obj.length;i++)\n\t\tfor(j=0;j<rowId_obj[i].cells.length;j++)\n\t\t\trowId_obj[i].cells[j].className = (i%2==0?\"QRYEVEN\":\"QRYODD\");\n\tfirstElementSelected = false;\t\n}\nfunction positionComponents(firstElementIndex, secondElementIndex)\n{\n\t//alert(\'firstElementIndex\'+firstElementIndex);\n   // alert(\'secondElementIndex\'+secondElementIndex);\n\tvar gridComponentDefinition = document.templateGridListForm.gridComponentDefinition.value.split(\"|\");\t\n\t//alert(\'gridComponentDefinition\'+gridComponentDefinition);\n\tvar temp = document.templateGridListForm.gridComponentDefinition.value.split(\"|\");\n\tvar firstElementDefinition = gridComponentDefinition[firstElementIndex];\n\tvar secondElementDefinition = gridComponentDefinition[secondElementIndex]; \n\t//alert(firstElementDefinition + \"=\" + secondElementDefinition);\n\tif(firstElementIndex < secondElementIndex)\n\t{\n\t\tfor(i=0;i<temp.length;i++)\n\t\t{\n\t\t\tif(i < firstElementIndex || i >= secondElementIndex)\n\t\t\t\ttemp[i] = gridComponentDefinition[i];\t\t\t\n\t\t\telse if(i >= firstElementIndex && i < (secondElementIndex-1))\n\t\t\t\ttemp[i] = gridComponentDefinition[i+1];\n\t\t\telse if(i == (secondElementIndex-1))\n\t\t\t\ttemp[i] = firstElementDefinition;\n\t\t}\n\n\t}\n\telse if(firstElementIndex > secondElementIndex)\n\t{\n\t\tfor(i=0;i<temp.length;i++)\n\t\t{\n\t\t\tif(i > firstElementIndex || i < secondElementIndex)\n\t\t\t\ttemp[i] = gridComponentDefinition[i];\n\t\t\telse if(i == secondElementIndex)\n\t\t\t\ttemp[i] = firstElementDefinition;\n\t\t\telse if(i <= firstElementIndex && i > secondElementIndex)\n\t\t\t\ttemp[i] = gridComponentDefinition[i-1];\n\t\t}\n\t}\n\treturn temp;\n\t\n}\nfunction positionGridComponents(details)\n{\n//\talert(\'details\'+details);\nvar table = parent.window[2].document.templateGridComponentDefinitionForm.querySelectorAll(\'#temporary_label\');\t\n\tvar temp = details.split(\"~\");\n  //  alert(\'temp\'+temp);\n\tvar srlno = \"\";\n\tvar member_comp_id = \"\";\n\tvar member_comp_desc = \"\";\n\tvar member_comp_type = \"\";\n\tvar componentColPos = \"\";\n\tvar componentColSpan = \"\";\n\tvar textRows = \"\";\n\tif(temp != null && temp.length == 7)\n\t{\n\t\tsrlno = escape(temp[0]);\n\t//\talert(\'srlno\'+srlno);\n\t\tmember_comp_id = escape(temp[1]);\n\t//\talert(\'member_comp_id\'+member_comp_id);\n\t\tmember_comp_desc = escape(temp[2]);\n\t\t//alert(\'member_comp_desc\'+member_comp_desc);\n\t\tmember_comp_type = escape(temp[3]);\n\t//\talert(\'member_comp_type\'+member_comp_type);\n\t\tcomponentColPos = escape(temp[4]);\n\t//\talert(\'componentColPos\'+componentColPos);\n\t\tcomponentColSpan = escape(temp[5]);\n\t//\talert(\'componentColSpan\'+componentColSpan);\n\t\ttextRows = temp[6];\n\t}\n\tvar action_url = \'../../eAM/jsp/DiscrMsrCompGridDef.jsp?gridID=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&mode=Update&srlno=\' + srlno + \'&member_comp_id=\' + member_comp_id + \'&member_comp_desc=\' + escape(member_comp_desc) + \"&member_comp_type=\" + member_comp_type + \"&componentColPos=\" + componentColPos + \"&componentColSpan=\" + componentColSpan + \"&textRows=\" + textRows;\n\n\tif(!firstElementSelected)\n\t{\n\t\tif (table.length > 0 ) {\n\t\t    table[0].style.display = \'block\';\n\t\t}\n\t\tfirstElementSelected = true;\n\t\tfirstElementIndex = srlno;\n\t\tsecondElementIndex = 0;\n\t\tsecondElementSelected = false;\n\t\tvar rowId_obj = document.getElementById(\'rowId\');\n\t\t//alert(rowId_obj.length);\n\t\tfor(i=0;i<rowId_obj.length;i++)\n\t\t{\n\t\t\tfor(j=0;j<rowId_obj[i].cells.length;j++)\n\t\t\t{\n\t\t\t\tif(i == (firstElementIndex-1))\n\t\t\t\t\trowId_obj[i].cells[j].className = \"FIRSTSELECTED\";\t\t\t\t\n\t\t\t\telse\n\t\t\t\t\trowId_obj[i].cells[j].className = (i%2==0?\"QRYEVEN\":\"QRYODD\");\n\t\t\t\t\n\t\t\t}\n\t\t}\n\t\t//alert(\'selected\');\n\t\tparent.templateGridDefFrame.document.getElementById(\'gridComponentDefinitionTable\').style.display = \"none\";\n\t\tparent.templateGridDefFrame.document.getElementById(\'gridToolbarTable\').style.display = \"none\";\n\t}\n\telse \n\t{\n\t//\talert(\'in else\');\n\tif (table.length > 0 ) {\n\t\t    table[0].style.display = \'none\';\n\t\t}\n\t\tfirstElementSelected = false;\n\t\tsecondElementSelected = true;\n\t\tsecondElementIndex = srlno;\n\t//\talert(\'srlno\'+srlno);\n\t\tnewGridComponentDefinition_temp = positionComponents(firstElementIndex-1, secondElementIndex-1);\n\t\tvar newGridComponentDefinition = \"\";\n\t\tvar prevColPos = 0;\n\t\tfor(i=0;i<newGridComponentDefinition_temp.length;i++)\n\t\t{\n\t\t\tvar srlno =(i+1);\n\t\t\tvar member_comp_id = newGridComponentDefinition_temp[i].split(\"~\")[1];\n\t\t\tvar member_comp_desc = newGridComponentDefinition_temp[i].split(\"~\")[2];\n\n\t\t\tvar member_comp_type = newGridComponentDefinition_temp[i].split(\"~\")[3];\n\t\t\tvar componentColPos = (prevColPos+1);\t\t\t\n\t\t\tif(i > 0)\n\t\t\t{\n\t\t\t\tif(newGridComponentDefinition_temp[i-1].split(\"~\")[5] > 1)\n\t\t\t\t{\t\t\t\n\t\t\t\t\tcomponentColPos = prevColPos + parseInt(newGridComponentDefinition_temp[i-1].split(\"~\")[5]);\n\t\t\t\t\t//alert(\'added for \' + member_comp_desc + \" value of=\" + newGridComponentDefinition_temp[i-1].split(\"~\")[5]);\n\t\t\t\t}\n\t\t\t}\n\t\t\tvar componentColSpan = newGridComponentDefinition_temp[i].split(\"~\")[5];\n\t\t\tvar textRows = newGridComponentDefinition_temp[i].split(\"~\")[6];\n\t\t\tif(newGridComponentDefinition == \"\")\n\t\t\t\tnewGridComponentDefinition += (srlno + \"~\" + member_comp_id + \"~\" + member_comp_desc + \"~\" + member_comp_type + \"~\" + componentColPos + \"~\" + componentColSpan + \"~\" + textRows);\n\t\t\telse\n\t\t\t\tnewGridComponentDefinition += (\"|\" + (srlno + \"~\" + member_comp_id + \"~\" + member_comp_desc + \"~\" + member_comp_type + \"~\" + componentColPos + \"~\" + componentColSpan + \"~\" + textRows));\n\t\t\tprevColPos = componentColPos;\n\t\t}\n\t\t//alert(newGridComponentDefinition);\n\t\tparent.templateGridDefFrame.document.getElementById(\'gridComponentDefinitionTable\').style=\"display\";\n\t\tparent.templateGridDefFrame.document.getElementById(\'gridToolbarTable\').style=\"display\";\n\t}\t\n\t//alert(firstElementSelected + \"=\" + secondElementSelected + \"=\" + firstElementIndex + \"=\" + secondElementIndex);\n\tif(!secondElementSelected)\n\t{\n\t\t//parent.templateGridDefFrame.document.location = action_url;\n\t}\n\telse\n\t{\n//\t\talert(newGridComponentDefinition);\n//\t\talert(escape(newGridComponentDefinition));\n\t\tparent.templateGridListFrame.document.location.href = \"../../eAM/jsp/DiscrMsrCompGridList.jsp?gridID=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&gridComponentDefinition=\" + escape(newGridComponentDefinition) + \"&grid_max_columns_allowed=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\tparent.templateGridDefFrame.document.templateGridComponentDefinitionForm.gridComponentDefinition.value = newGridComponentDefinition;\n\t\tparent.templateGridDefFrame.showGridPreview();\n\t\tparent.templateGridDefFrame.clearFields();\n\t\tfirstElementSelected = false;\n\t\tsecondElementSelected = false;\n\t\tfirstElementIndex = 0;\n\t\tsecondElementIndex = 0;\n\t}\n}\n</SCRIPT>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'></link>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n</HEAD>\n<BODY onKeyDown = \'lockKey()\'>\n<table width=\"100%\">\n\t<tr>\n\t\t<th align=\'left\' style=\'BACKGROUND-COLOR:#ffc5b5;color:black\'>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t</th>\n\t</tr>\n</table>\n<table width=\"100%\" id=\"list_of_components\" border=1 cellspacing=0 cellpadding=0>\n\t<tr>\n\t\t<th>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t</th>\n\t\t<th>\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t</th>\t\t\n\t\t<th>\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t</th>\n\t</tr>\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t<a href=\'javascript:positionGridComponents(\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\")\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t</a>\n        ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<a class=\"drag\" id= \"list_item_id_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"  \n\thref = \'javascript:populateDetails(\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\")\' >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t</a>\t\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n</table>\n<form name=\"templateGridListForm\" id=\"templateGridListForm\">\n\t<input type=\"hidden\" name=\"gridComponentDefinition\" id=\"gridComponentDefinition\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n</form>\n</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block5Bytes, _wl_block5);

try
{
	request.setCharacterEncoding("UTF-8");
	int component_srlno = 1;
	String gridComponentDefinition = request.getParameter("gridComponentDefinition")==null?"":request.getParameter("gridComponentDefinition");
	//gridComponentDefinition = java.net.URLDecoder.decode(gridComponentDefinition);
	java.util.StringTokenizer st = new java.util.StringTokenizer(gridComponentDefinition,"|");
	String gridID = request.getParameter("gridID")==null?"":request.getParameter("gridID");	
	String grid_max_columns_allowed = request.getParameter("grid_max_columns_allowed")==null?"":request.getParameter("grid_max_columns_allowed");	
	//out.println(gridComponentDefinition);

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(gridID));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(grid_max_columns_allowed));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(java.net.URLEncoder.encode(gridComponentDefinition)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(gridID));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(grid_max_columns_allowed));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(java.net.URLEncoder.encode(gridComponentDefinition)));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(gridID));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(grid_max_columns_allowed));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

	int i=0;

	while(st.hasMoreTokens())
	{
		String temp = st.nextToken();
		String member_comp_desc	= ""	,	member_comp_type	= "";
		String componentColPos	= ""	,	componentColSpan	= "";
		String 	textRows		= "";
		java.util.StringTokenizer st_comp = new java.util.StringTokenizer(temp, "~");
		out.println("<tr id=\"rowId\" >");
		
		String GridCompTemp = "";
		while(st_comp.hasMoreTokens())
		{
			String tem1 = 	st_comp.nextToken();//1
			String tem2 = st_comp.nextToken();//2
			member_comp_desc	= st_comp.nextToken();//3
			member_comp_type	= st_comp.nextToken();//4
			componentColPos		= st_comp.nextToken();//5
			componentColSpan	= st_comp.nextToken();//6
			textRows			= st_comp.nextToken();//7
			
			GridCompTemp = tem1.trim() + "~" + tem2.trim() + "~" + member_comp_desc.trim() + "~" + 
					member_comp_type.trim() + "~"+ componentColPos.trim() + "~"+ 
					componentColSpan.trim() + "~"+ textRows.trim();
		}
	//	String temp1 = temp.replaceAll("\n","");
			//out.println("<script>alert('"+GridCompTemp+"');</script>");

		out.println("<td class='" + (i%2==0?"QRYEVEN":"QRYODD") + "' align='center'>");
		
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(java.net.URLEncoder.encode(GridCompTemp)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(componentColPos));
            _bw.write(_wl_block20Bytes, _wl_block20);

		
		out.println("</td>");
		out.println("<td class='" + (i%2==0?"QRYEVEN":"QRYODD") + "' >");
		//out.println("<a class=\"drag\" id= 'list_item_id_" + component_srlno + "' href = \"javascript:populateDetails('" + temp + "')\" >" + member_comp_desc + "</a>");	
		
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(component_srlno ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(java.net.URLEncoder.encode(GridCompTemp)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(member_comp_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);

		out.println("</td>");
		out.println("<td class='" + (i%2==0?"QRYEVEN":"QRYODD") + "'>");
		out.println(member_comp_type);
		out.println("</td>");		
		out.println("<td class='" + (i%2==0?"QRYEVEN":"QRYODD") + "'>");
		out.println(componentColSpan);
		out.println("</td>");
		out.println("<td class='" + (i++%2==0?"QRYEVEN":"QRYODD") + "'>");
		out.println(textRows.trim().equals("NA")?"--":textRows);
		out.println("</td>");
		out.println("</tr>");
		component_srlno++;
	}
	
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(gridComponentDefinition.trim()));
            _bw.write(_wl_block26Bytes, _wl_block26);
	
	}
	catch(Exception e)
	{
		e.printStackTrace(System.err);
		out.println(e);
	}

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ListofGridComponents.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ColumnPosition.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ColumnHeader.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ComponentType.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ColumnSpan.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TextRows.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }
}
