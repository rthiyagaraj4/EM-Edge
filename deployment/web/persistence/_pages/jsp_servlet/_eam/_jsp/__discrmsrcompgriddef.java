package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __discrmsrcompgriddef extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/DiscrMsrCompGridDef.jsp", 1741171804824L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HEAD>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<SCRIPT LANGUAGE=\"JavaScript\">\n/*\nfunction callDialogPrompt()\n{\n\t\t\n\n\tvar comp_id = document.forms[0].member_compDesc.value;\n\tvar action_url=\'../../eCA/jsp/CASectionTemplateMessageFrame.jsp\';\n\tvar retVal\t=\t\"\";\n\tvar dialogHeight= \"20\" ;\n\tvar dialogWidth\t= \"40\" ;\n\tvar arguments\t= \"Message\" ;\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no;scroll=auto\"; \n\tretVal = window.showModalDialog(\"../../eCA/jsp/CASectionTemplateMessageFrame.jsp?label_type=P&comp_id=\"+comp_id,arguments,features);\t\n\n\tif(retVal!=null)\n\t{\n\t\tdocument.templateGridComponentDefinitionForm.prompt_id.value=retVal[0];\n\t\tdocument.templateGridComponentDefinitionForm.prompt_desc.value=retVal[1];\n\t\t\n\t}\n\n}\n*/\nfunction checkForUniqueID(srlno)\n{\n\tvar no_of_rows = parent.templateGridListFrame.document.getElementById(\'list_of_components\').rows.length - 1;\n\t//alert(no_of_rows);\n\tvar i=0;\n\tfor(i=0;i<no_of_rows;i++)\n\t{\n\t\tvar obj = eval(parent.templateGridListFrame.document.getElementById(\'list_item_id_\'+ (i+1)));\n\t\tif(srlno == obj.innerText)\n\t\t\treturn false;\n\t}\n\treturn true;\n}\nfunction addToGrid()\n{\n\tvar error = \"\";\n\n\tvar mode\t\t\t\t\t= document.templateGridComponentDefinitionForm.mode.value;\t\n\tvar srlno\t\t\t\t\t= document.templateGridComponentDefinitionForm.srlno.value;\t\n\tvar member_comp_id\t\t\t= document.templateGridComponentDefinitionForm.member_compId.value;\n\tvar member_comp_type\t\t= document.templateGridComponentDefinitionForm.member_comp_type.value;\n\tvar member_comp_desc\t\t= document.templateGridComponentDefinitionForm.member_compDesc.value;\n\tvar componentColPos\t\t\t= document.templateGridComponentDefinitionForm.componentColPos.value;\t\n\tvar componentColSpan\t\t= document.templateGridComponentDefinitionForm.componentColSpan.value;\n\tvar textRows\t\t\t\t= document.templateGridComponentDefinitionForm.textRows.value;\n\n\n\tvar gridComponentDefinition = document.templateGridComponentDefinitionForm.gridComponentDefinition.value;\n\n\tif(mode != \"Update\")\n\t{\n\t\tif(gridComponentDefinition == \"\")\n\t\t{\t\t\t\n\t\t\tcomponentColPos = srlno;\n\t\t}\n\t\telse\n\t\t{\t\t\t\n\t\t\tvar x = gridComponentDefinition.split(\"|\");\n\t\t\tvar cur_col_pos = x[x.length-1].split(\"~\")[4];\n\t\t\tvar cur_col_span = x[x.length-1].split(\"~\")[5];\n\t\t\tcomponentColPos = parseInt(cur_col_pos) + parseInt(cur_col_span);\n\t\t}\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t}\n\n\n\tvar gridComponentDefinition1 = gridComponentDefinition;\t\n\tvar new_def = (srlno + \"~\" + member_comp_id + \"~\" + member_comp_desc + \"~\" + member_comp_type + \"~\" + componentColPos + \"~\" + componentColSpan + \"~\" + (member_comp_type != \"Short Text\"?\"NA\":(textRows == \"\"?\"1\":textRows)));\n\n\tif(!checkValue(document.getElementById(\"textRows\"), 2, \"Text Rows\"))\n\t{\n\t\treturn false;\n\t}\n\tif(mode == \"Update\")\n\t{\n\t\tgridComponentDefinition = constructValues(gridComponentDefinition, new_def);\n\t}\n\telse\n\t{\n\t\tif(gridComponentDefinition != \"\")\n\t\t\tgridComponentDefinition += (\"|\"+ new_def);\n\t\telse\n\t\t\tgridComponentDefinition = new_def;\t\n\t}\n\tvar no_of_components = gridComponentDefinition.split(\"|\").length;\n\t\n\tif(no_of_components > ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" )\n\t{\n\t\t//error = (\'APP-CA1050 Only ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" components can be a part of the grid.... \');\n\t\terror = getMessage(\"AM0139\",\"AM\");\n\t\terror=error.replace(\"$\",grid_max_columns_allowed);\n\t\t\n\t\tparent.messageframe.location.href =\"../../eCommon/jsp/MstCodeError.jsp?err_num=\" + error + \"&err_value=0\" ;\t\n\t\treturn false;\n\t}\n\t//alert(\"srlno=\" + srlno + \" member_comp_id=\" + member_comp_id + \" componentColPos=\" + componentColPos + \" componentColSpan=\" + componentColSpan );\n\tif(srlno == \"\" || member_comp_id == \"\" || componentColPos == \"\" || componentColSpan == \"\")\n\t{\n\t\t//error = (\'APP-CA1051 All the fields other than Text-Rows are mandatory...\');\n\t\terror = getMessage(\"AM0138\",\"AM\");\n\t\tparent.messageframe.location.href =\"../../eCommon/jsp/MstCodeError.jsp?err_num=\" + error + \"&err_value=0\" ;\t\n\t\treturn false;\n\t}\t\n\tif(mode != \"Update\")\n\t{\n\t\tif(!checkForUniqueID(srlno))\n\t\t{\n\t\t\t//error = (\'APP-CA1052 Please enter a unique ID...\');\n\t\t\terror = getMessage(\"AM0141\",\"AM\");\n\t\t\tparent.messageframe.location.href =\"../../eCommon/jsp/MstCodeError.jsp?err_num=\" + error + \"&err_value=0\" ;\t\n\t\t\treturn false;\n\t\t}\t\t\n\t}\n\tif(!validateNewComponent(gridComponentDefinition1, componentColPos, componentColSpan, mode, srlno))\n\t{\n\t\treturn false;\n\t}\n\tdocument.templateGridComponentDefinitionForm.gridComponentDefinition.value = gridComponentDefinition;\t\n\tparent.templateGridListFrame.document.location.href = \"../../eAM/jsp/DiscrMsrCompGridList.jsp?gridID=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&gridComponentDefinition=\" + escape(gridComponentDefinition) + \"&grid_max_columns_allowed=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\tclearFields();\n\tparent.messageframe.location.href =\"../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0\" ;\t\n\tshowGridPreview();\n\tpopulatesrlNo();\n\tdocument.templateGridComponentDefinitionForm.componentColSpan.value = \"1\";\n}\nfunction validateNewComponent(gridComponentDefinition, componentColPos, componentColSpan, mode, srlno)\n{\n\tvar grid_max_columns_allowed = document.templateGridComponentDefinitionForm.grid_max_columns_allowed.value;\t\t\n\tvar currComponentOccupiedCols = new Array();\n\tvar allowedcols = new Array();\n\tvar temp = gridComponentDefinition.split(\"|\");\n\tvar error = \"\";\n\tvar i = 0;\t\n\tfor(i=0;i<componentColSpan;i++)\n\t\tcurrComponentOccupiedCols[currComponentOccupiedCols.length] =  (parseInt(componentColPos) + i);\n\t//alert(currComponentOccupiedCols);\n\tvar totalcolspan = 0;\t\n\tfor(i=0;i<temp.length;i++)\n\t{\n\t\tif(!(mode == \"Update\" && parseInt(temp[i].split(\"~\")[0]) == srlno))\n\t\t\ttotalcolspan += parseInt(temp[i].split(\"~\")[5]);\n\t\tfor(k=0;k<parseInt(temp[i].split(\"~\")[5]);k++)\n\t\t{\n\t\t\tif(!(mode == \"Update\" && parseInt(temp[i].split(\"~\")[0]) == srlno))\n\t\t\t\tallowedcols[allowedcols.length] = (parseInt(temp[i].split(\"~\")[4]) + k);\n\t\t}\n\t}\t\n\t/*for(i=0;i<allowedcols.length;i++)\n\t{\n\t\tif(componentColPos == allowedcols[i] && mode != \"Update\")\n\t\t{\n\t\t\terror = (\'APP-CA1053 Overlaps existing component....\');\n\t\t\tparent.messageframe.location.href =\"../../eCommon/jsp/MstCodeError.jsp?err_num=\" + error + \"&err_value=0\" ;\t\n\t\t\treturn false;\n\t\t}\n\t\telse if(mode == \"Update\")\n\t\t{\n\t\t\tfor(j=0;j<currComponentOccupiedCols.length;j++)\n\t\t\t{\t\t\t\t\n\t\t\t\tif(allowedcols[i] == currComponentOccupiedCols[j])\n\t\t\t\t{\n\t\t\t\t\terror = (\'APP-CA1054 Overlaps existing component....\');\n\t\t\t\t\tparent.messageframe.location.href =\"../../eCommon/jsp/MstCodeError.jsp?err_num=\" + error + \"&err_value=0\" ;\t\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}*/\n\t/*for(i=0;i<temp.length;i++)\n\t{\n\t\tif(componentColPos < parseInt(temp[i].split(\"~\")[4]) && mode != \"Update\")\n\t\t{\n\t\t\terror = (\'APP-CA1055 Invalid Entry!<br>Please enter components in ascending order of column position....\');\n\t\t\tparent.messageframe.location.href =\"../../eCommon/jsp/MstCodeError.jsp?err_num=\" + error + \"&err_value=0\" ;\t\n\t\t\treturn false;\n\t\t}\n\t}*/\n\t//alert(\"totalcolspan=\" + totalcolspan + \" componentColSpan=\" + componentColSpan + \" total=\" + (parseInt(totalcolspan) + parseInt(componentColSpan)) );\n\tif(parseInt(totalcolspan) == ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =")\n\t{\n\t\t//error = (\'APP-CA1056 There is no room for anymore components in this Grid....\');\n\t\terror = getMessage(\"AM0140\",\"AM\");\n\t\tparent.messageframe.location.href =\"../../eCommon/jsp/MstCodeError.jsp?err_num=\" + error + \"&err_value=0\" ;\t\n\t\treturn false;\n\t}\n\n\tif(((parseInt(totalcolspan) + parseInt(componentColSpan)) > grid_max_columns_allowed) || ((parseInt(componentColPos) + parseInt(componentColSpan)) > (grid_max_columns_allowed + 1))) \n\t{\n\t\t//error = (\'APP-CA1057 This component, with others, occupy more than six columns.<br> Please alter the colspan if this component is required....\');\n\t\terror = getMessage(\"AM0142\",\"AM\");\n\t\tparent.messageframe.location.href =\"../../eCommon/jsp/MstCodeError.jsp?err_num=\" + error + \"&err_value=0\" ;\t\n\t\treturn false;\n\t}\n\tfor(i=0;i<temp.length;i++)\n\t{\n\t\tcolpos = parseInt(temp[i].split(\"~\")[4]);\n\t\tif(!(mode == \"Update\" && parseInt(temp[i].split(\"~\")[0]) == srlno))\n\t\t{\n\t\t\t//alert(temp[i] + \" ->colpos=\" + colpos + \" componentColPos=\" + componentColPos);\n\t\t\tif(componentColPos == colpos)\n\t\t\t{\n\t\t\t\t//error = (\'APP-CA1058 Overlaps existing component....\');\n\t\t\t\terror = getMessage(\"AM0143\",\"AM\");\n\t\t\t\tparent.messageframe.location.href =\"../../eCommon/jsp/MstCodeError.jsp?err_num=\" + error + \"&err_value=0\" ;\t\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t}\n\treturn true;\n}\nfunction constructValues(gridComponentDefinition, new_def)\n{\t\n\tvar returnValue = \"\";\n\tvar temp = gridComponentDefinition.split(\"|\");\n\tvar new_srlno = new_def.split(\"~\")[0];\n\tvar i = 0;\n\tfor(i=0;i<temp.length;i++)\n\t{\n\t\tvar comp_details = temp[i];\n\t\tvar srlno = comp_details.split(\"~\")[0];\t\t\n\t\tif(srlno == new_srlno)\n\t\t{\n\t\t\tif(returnValue == \"\")\n\t\t\t\treturnValue += new_def;\n\t\t\telse\n\t\t\t\treturnValue += (\"|\" + new_def);\n\t\t}\n\t\telse\n\t\t{\n\t\t\tif(returnValue == \"\")\n\t\t\t\treturnValue += comp_details;\n\t\t\telse\n\t\t\t\treturnValue += (\"|\" + comp_details);\n\t\t}\n\t}\n\n\ttemp = returnValue.split(\"|\");\n\treturnValue = \"\";\n\tvar prevColPos = 0;\n\n\tfor(i=0;i<temp.length;i++)\n\t{\n\t\tvar srlno = temp[i].split(\"~\")[0];\n\t\tvar member_comp_id = temp[i].split(\"~\")[1];\n\t\tvar member_comp_desc = temp[i].split(\"~\")[2];\n\t\tvar member_comp_type = temp[i].split(\"~\")[3];\n\t\tvar componentColPos = (prevColPos+1);\t\t\t\n\t\tvar componentColSpan = temp[i].split(\"~\")[5];\n\t\tvar textRows = temp[i].split(\"~\")[6];\n//\t\tvar prompt_id = temp[i].split(\"~\")[7];\n//\t\tvar prompt_desc = temp[i].split(\"~\")[8];\n\t\tif(i > 0)\n\t\t{\n\t\t\tif(temp[i-1].split(\"~\")[5] > 1)\n\t\t\t{\t\t\t\n\t\t\t\tcomponentColPos = prevColPos + parseInt(temp[i-1].split(\"~\")[5]);\t\t\t\t\n\t\t\t}\n\t\t}\n\t\tif(returnValue == \"\")\n\t\t{\n\t\t\treturnValue += (srlno + \"~\" + member_comp_id + \"~\" + member_comp_desc + \"~\" + member_comp_type + \"~\" + componentColPos + \"~\" + componentColSpan + \"~\" + textRows);\t\t\n\t\t}\n\t\telse\n\t\t\treturnValue += (\"|\" + (srlno + \"~\" + member_comp_id + \"~\" + member_comp_desc + \"~\" + member_comp_type + \"~\" + componentColPos + \"~\" + componentColSpan + \"~\" + textRows));\t\t\n\t\tprevColPos = componentColPos;\n\t}\n\treturn returnValue;\n\n}\nasync function callComponentLookUp()\n{\t\n\tvar retVal\t=\t\"\";\n\tvar dialogHeight= \"400px\" ;\n\tvar dialogWidth\t= \"700px\" ;\n\tvar arguments\t= \"\" ;\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no;scroll=auto\"; \n\tretVal = await window.showModalDialog(\"../../eAM/jsp/DiscrMsrCompLookupMain.jsp?calledFrom=GD\",arguments,features);\n\tif(retVal != null)\n\t{\n\t\tdocument.templateGridComponentDefinitionForm.member_compId.value = retVal[0];\n\t\tdocument.templateGridComponentDefinitionForm.member_compDesc.value = retVal[1];\n\t\tdocument.templateGridComponentDefinitionForm.member_comp_type.value = retVal[2];\n\t\tif(retVal[2] == \'Short Text\')\n\t\t{\n\t\t\tdocument.templateGridComponentDefinitionForm.textRows.disabled = false;\n\t\t\tdocument.templateGridComponentDefinitionForm.textRows.value = \"1\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.templateGridComponentDefinitionForm.textRows.disabled = true;\n\t\t\tdocument.templateGridComponentDefinitionForm.textRows.value = \"\";\n\t\t}\n\t}\t\n\n}\nfunction onCancel()\n{\t\n\t//window.returnValue = document.templateGridComponentDefinitionForm.gridComponentDefinition_temp.value;\n\t//window.close();\n\tlet dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n    dialogBody.contentWindow.returnValue =  document.templateGridComponentDefinitionForm.gridComponentDefinition_temp.value;\n    const dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n    dialogTag.close();\n}\nfunction closeWin()\n{\n\tlet dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n    dialogBody.contentWindow.returnValue =  document.templateGridComponentDefinitionForm.gridComponentDefinition.value;\n    const dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n    dialogTag.close();\n}\nfunction clearFields()\n{\n\tdocument.templateGridComponentDefinitionForm.member_compId.value = \"\";\n\tdocument.templateGridComponentDefinitionForm.member_compDesc.value = \"\";\n\tdocument.templateGridComponentDefinitionForm.componentColPos.value = \"\";\n\tdocument.templateGridComponentDefinitionForm.componentColSpan.value = \"\";\n\tdocument.templateGridComponentDefinitionForm.textRows.value = \"\";\n\tdocument.templateGridComponentDefinitionForm.srlno.value = \"\";\n\tdocument.templateGridComponentDefinitionForm.srlno.disabled = false;\n\tdocument.templateGridComponentDefinitionForm.delete_button.disabled = true;\n\tdocument.templateGridComponentDefinitionForm.addButton.value = \"Add To Grid\";\n\t//document.templateGridComponentDefinitionForm.addButton.value = getLabel(\"Common.Add.label\",\'Common\')+\"\"+getLabel(\"Common.to.label\",\'Common\')+\"\"+getLabel(\"Common.all.label\",\'Common\');\n\tdocument.templateGridComponentDefinitionForm.mode.value = \"\";\n\tpopulatesrlNo();\n}\nfunction checkValue(obj, val, prompt)\n{\n\tif(obj.value > val)\n\t{\n\t\t//error = (\'APP-CA1059 \' + prompt + \' cannot be more than \' + val + \'...\');\n\t\terror = getMessage(\"AM0168\",\"AM\");\n\t\terror = error.replace(\"$\",prompt);\n\t\terror = error.replace(\"#\",val);\n\t\tparent.messageframe.location.href =\"../../eCommon/jsp/MstCodeError.jsp?err_num=\" + error + \"&err_value=0\";\t\n\t\tobj.select();\n\t\tobj.focus();\n\t\treturn false;\n\t}\t\n\telse \n\t\treturn true;\n}\nfunction showGridPreview()\n{\t\n//\talert(\"397\");\n\tdocument.templateGridComponentDefinitionForm.target = \"templateGridPreviewFrame\";\n\tdocument.templateGridComponentDefinitionForm.action = \'../../eAM/jsp/DiscrMsrCompGridPreview.jsp\';\n\tdocument.templateGridComponentDefinitionForm.submit();\n//\talert(\"401\");\n}\nfunction deleteComponent(obj)\n{\n\tvar gridComponentDefinition = document.templateGridComponentDefinitionForm.gridComponentDefinition.value;\n\tvar srlno = document.templateGridComponentDefinitionForm.srlno.value;\n\t\n\t\n\tvar temp_string = \"\";\n\tvar grid_temp = gridComponentDefinition.split(\"|\");\n\t\n\n\tfor(var i=0;i<grid_temp.length;i++)\n\t{\n\t\tvar srlNo_temp = grid_temp[i].split(\"~\")[0];\t\t\n\t\tif(!(parseInt(srlNo_temp) == parseInt(srlno)))\n\t\t{\n\t\t\tif(temp_string == \"\")\n\t\t\t\ttemp_string += grid_temp[i];\n\t\t\telse\n\t\t\t\ttemp_string += (\"|\" + grid_temp[i]);\n\t\t}\n\t}\n\n\n\tvar temp = temp_string.split(\"|\");\n\ttemp_string = \"\";\n\treturnValue = \"\";\n\tvar prevColPos = 0;\n\n\tfor(i=0;i<temp.length;i++)\n\t{\n\n                   \n\t\tvar srlno = (i+1);\n\t\tvar member_comp_id = temp[i].split(\"~\")[1];\n\t\tvar member_comp_desc = temp[i].split(\"~\")[2];\n\t\tvar member_comp_type = temp[i].split(\"~\")[3];\n\t\tvar componentColPos = (prevColPos+1);\t\t\t\n\t\tvar componentColSpan = temp[i].split(\"~\")[5];\n\t\tvar textRows = temp[i].split(\"~\")[6];\n\n\t\t\n\t\tif(i > 0)\n\t\t{\n\t\t\tif(temp[i-1].split(\"~\")[5] > 1)\n\t\t\t{\t\t\t\n\t\t\t\tcomponentColPos = prevColPos + parseInt(temp[i-1].split(\"~\")[5]);\t\t\t\t\n\t\t\t}\n\t\t}\n\t\tif(temp_string == \"\")\n\t\t{\n\t\t\t\n\t\t\ttemp_string += (srlno + \"~\" + member_comp_id + \"~\" + member_comp_desc + \"~\" + member_comp_type + \"~\" + componentColPos + \"~\" + componentColSpan + \"~\" + textRows);\n\t\t}\n\t\telse\n\t\t\ttemp_string += (\"|\" + (srlno + \"~\" + member_comp_id + \"~\" + member_comp_desc + \"~\" + member_comp_type + \"~\" + componentColPos + \"~\" + componentColSpan + \"~\" + textRows));\t\t\n\t\tprevColPos = componentColPos;\n\n\t\t\n\t}\n\n \n\n    if(grid_temp.length == 1)\n    {\n\t\ttemp_string = \"\";\n\t}\n\n\tdocument.templateGridComponentDefinitionForm.gridComponentDefinition.value = temp_string;\n\tparent.templateGridListFrame.document.location.href = \"../../eAM/jsp/DiscrMsrCompGridList.jsp?gridID=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&gridComponentDefinition=\" + escape(temp_string) + \"&grid_max_columns_allowed=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\tclearFields();\n\tparent.messageframe.location.href =\"../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0\" ;\t\n\tshowGridPreview();\n\t//alert(\"temp_string=\" + temp_string);\n\tobj.disabled = true;\n}\nfunction populatesrlNo()\n{\n\tvar gridComponentDefinition = document.templateGridComponentDefinitionForm.gridComponentDefinition.value;\n\tvar grid_temp = gridComponentDefinition.split(\"|\");\n\tvar srlNo = 0;\n\tfor(var i=0;i<grid_temp.length;i++)\n\t\tsrlNo = (isNaN(parseInt(grid_temp[i].split(\"~\")[0]))?0:parseInt(grid_temp[i].split(\"~\")[0]));\t\n\tdocument.templateGridComponentDefinitionForm.srlno.value = (srlNo+1);\n}\nfunction promptcall(obj)\n{\n\t//alert(obj.value);\n\tif(obj.value == null)\n\t\tdocument.templateGridComponentDefinitionForm.prompt_desc.disabled == true;\n\telse\n\t\tdocument.templateGridComponentDefinitionForm.prompt_desc.disabled == false;\n}\n//-->\n</SCRIPT>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n</HEAD>\n<BODY onKeyDown = \'lockKey()\'>\n<form name=\"templateGridComponentDefinitionForm\" id=\"templateGridComponentDefinitionForm\">\n<table align=\"center\" width=\"100%\"  border=\'0\' cellpadding=\'1\' cellspacing=\'0\' id=\"gridComponentDefinitionTable\">\n\t<tr>\n\t\t<th colspan=\"6\">\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t</th>\n\t</tr>\t\n\t<tr>\t\t\t\n\t\t<td class=\'labels\' width=\'25%\'>\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&nbsp;\n\t\t</td>\n\t\t<td  class=\'fields\' width=\'25%\'>\n\t\t\t<input type=\"text\" name=\"member_compDesc\" id=\"member_compDesc\" readonly value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" >\t\t\t\n\t\t\t<input type=\"button\" value=\"?\" class=\"button\" onclick=\"callComponentLookUp();\">\n\t\t\t<img src=\"../../eCommon/images/mandatory.gif\">\n\t\t\t<input type=\"hidden\" name=\"member_comp_type\" id=\"member_comp_type\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t\t<input type=\"hidden\" name=\"member_compId\" id=\"member_compId\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" >\n\t\t</td>\n\t\t\n<!--\t\t\t\t\n\t\t<td class=\'labels\' width=\'25%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t</td>\n\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t<input type=\'text\' name=\'prompt_desc\' id=\'prompt_desc\' value=\"\">\n\t\t\t<input type=\'button\' value=\'?\' name=\'prompt_btn\' id=\'prompt_btn\'  disabled class=\'button\' onclick=\"callDialogPrompt()\">\n\t\t\t\n\t\t</td>\n\t\t-->\n\n\t\t<td class=\'labels\' width=\'10%\'>\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&nbsp;\t\t\n\t\t</td>\n\n\t\t<td  class=\'fields\' width=\'20%\'>\n\t\t\t<input type=\"text\" name=\"textRows\" id=\"textRows\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" size=\"2\" maxlength=\"2\" ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" onKeyPress=\'return(ChkNumberInput(this,event,0))\' onblur = \"return checkValue(this, 2, \'Text Rows\')\"> \n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'Labels\' width=\'10%\' colspan=\"1\">\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&nbsp;\t\t\t\n\t\t</td>\n\t\t<td  class=\'fields\' width=\'20%\' colspan=\"3\">\n\t\t\t<input type=\"text\" name=\"componentColSpan\" id=\"componentColSpan\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" size=\"2\" maxlength=\"2\" onKeyPress=\'return(ChkNumberInput(this,event,0))\' onblur = \"checkValue(this, ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =", \'Column Span\')\"> <img src=\"../../eCommon/images/mandatory.gif\">\n\t\t</td>\n\t</tr>\n</table>\n<table width=\"100%\"  border=\'0\' cellpadding=\'15\' cellspacing=\'0\' align=\"center\" id=\"gridToolbarTable\">\n\t<tr>\n\t\t<td  class=\'fields\'>\n\t\t\t<!-- <input type=\"button\" value=\"Show Preview\" class=\"button\" onclick=\"showGridPreview()\" >  -->\n\t\t\t<input type=\"button\" name=\"addButton\" id=\"addButton\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" class=\"button\" onclick=\"return addToGrid()\">\n\t\t\t<input type=\"button\" value=\"Delete from Grid\" name=\"delete_button\" id=\"delete_button\" class=\"button\" onclick=\"deleteComponent(this)\" ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =">&nbsp;&nbsp;\n\t\t</td>\n\t\t<td align=\"right\" width=\'45%\'>&nbsp;&nbsp;\t\n\t\t\t<input type=\"button\" value=\"Save\" class=\"button\" onclick=\"closeWin()\">\n\t\t\t<input type=\"button\" value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' class=\"button\" onclick=\"clearFields()\">\n\t\t\t<input type=\"button\" value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' class=\"button\" onClick=\"onCancel()\">\n\t\t</td>\n\t</tr>\n</table>\n\n\n\n<table width=\"100%\"  border=\'0\' cellpadding=\'12\' cellspacing=\'0\' align=\"center\" id=\"temporary_label\"  style=\"display:none;\">\n\t<tr>\n\t\t<td class=\"label\" style=\"font-size:9pt;\" align=\'center\'>\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n<!-- \t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td class=\"label\" style=\"color:red;font-size:9pt;\" align =\'center\'> -->\n\t\t<br><br><i style=\"color:red;font-size:9pt;\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</i>\n\t\t</td>\n\t</tr>\n\n</table>\n\n\n<input type=\"hidden\" name=\"srlno\" id=\"srlno\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =">\t\n<input type=\"hidden\" name=\"componentColPos\" id=\"componentColPos\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n<input type=\"hidden\" name=\"gridComponentDefinition\" id=\"gridComponentDefinition\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n<input type=\"hidden\" name=\"gridComponentDefinition_temp\" id=\"gridComponentDefinition_temp\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n<input type=\"hidden\" name=\"gridID\" id=\"gridID\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n<input type=\"hidden\" name=\"grid_desc\" id=\"grid_desc\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n<input type=\"hidden\" name=\"grid_max_columns_allowed\" id=\"grid_max_columns_allowed\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n<!--input type=\'hidden\' name=\'prompt_id\'  value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'> -->\n</form>\n</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t<script>\n\t\tshowGridPreview();\n\t\tpopulatesrlNo();\n\t</script>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

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

request.setCharacterEncoding("UTF-8");
//out.println(request.getQueryString());
String gridID = request.getParameter("gridID")==null?"":request.getParameter("gridID");
String grid_desc = request.getParameter("grid_desc")==null?"":request.getParameter("grid_desc");
String gridComponentDefinition = request.getParameter("gridComponentDefinition")==null?"":request.getParameter("gridComponentDefinition");
String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
String grid_max_columns_allowed = request.getParameter("grid_max_columns_allowed")==null?"":request.getParameter("grid_max_columns_allowed"); 
String member_comp_desc = ""		,	member_comp_type = "";
String componentColPos = ""		,	componentColSpan = "";
String textRows = "";
String member_comp_id = "";
String srlno = "";
String dis = "";
String prompt_id = "";
//String prompt_desc = "";
//String prompt_dis = "disabled";
if(mode.equals("Update"))
{
	srlno = request.getParameter("srlno")==null?"":request.getParameter("srlno");
	member_comp_id = request.getParameter("member_comp_id")==null?"":request.getParameter("member_comp_id");
	member_comp_desc = request.getParameter("member_comp_desc")==null?"":java.net.URLDecoder.decode(request.getParameter("member_comp_desc"));
	member_comp_type = request.getParameter("member_comp_type")==null?"":request.getParameter("member_comp_type");
	componentColPos = request.getParameter("componentColPos")==null?"":request.getParameter("componentColPos");
	componentColSpan = request.getParameter("componentColSpan")==null?"":request.getParameter("componentColSpan");
	textRows = request.getParameter("textRows")==null?"":request.getParameter("textRows");
	dis = "disabled";	
}
if(componentColSpan.equals(""))
{
	componentColSpan = "1";
}


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(grid_max_columns_allowed));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(grid_max_columns_allowed));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(gridID));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(grid_max_columns_allowed));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(grid_max_columns_allowed));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(gridID));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(grid_max_columns_allowed));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(member_comp_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(member_comp_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(member_comp_id));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((textRows.equals("NA")?"":textRows)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(((mode.equals("Update") && !textRows.equals("NA"))?"":"disabled")));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(componentColSpan));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(grid_max_columns_allowed));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((mode.equals("Update")?"Modify":"Add To Grid")));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(mode.equals("Update")?"":"disabled"));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(srlno));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(componentColPos));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(gridComponentDefinition));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(gridComponentDefinition));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(gridID));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(grid_desc));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(grid_max_columns_allowed));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(prompt_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
if(mode.equals("")){
            _bw.write(_wl_block42Bytes, _wl_block42);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ComponentDefinition.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Component.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Prompt.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TextRows.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clear.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.CurrentlySelectedComponentismarkforrepositioning.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.ClickonanyotherColumnnumbertoreposition.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }
}
