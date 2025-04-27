package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.*;
import eBL.Common.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eBL.Common.BlRepository;

public final class __pkgdefbasepricepartialdeposit extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/PkgDefBasePricePartialDeposit.jsp", 1744006349576L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate     \t  Edit History      Name     \t\t\tDescription\n--------------------------------------------------------------------------------------------------------------\n16-Nov-2013      100           \tKarthikeyan.K          created for MMS-CRF-0023\n---------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">  \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/> \n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/CommonLookup.js\" language=\"javascript\"></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>   \n<script> \n/* MMS-SCF-0389- Karthik added the below function for to allow Zero in Parial Deposit , provided Partial Depository Mandatory flag is unchecked*/\nfunction partialDepositDataValidation(index){\n\tvar depositMandatoryYN=eval(\"document.PkgDefBasePriceDepositForm.depositMandatoryYN\"+index);\n\tvar partialDepositValue=eval(\"document.PkgDefBasePriceDepositForm.partialDeposit\"+index).value;\n\tif(parseInt(partialDepositValue)==0){\n\t\tdepositMandatoryYN.checked=false;\n\t\tdepositMandatoryYN.value=\'false\';\n\t}\n}\nfunction depositMandatoryChkBox(index){\n\tvar depositMandatoryYN=eval(\"document.PkgDefBasePriceDepositForm.depositMandatoryYN\"+index);\n\tvar partialDepositValue=eval(\"document.PkgDefBasePriceDepositForm.partialDeposit\"+index).value;\n\t\n\t\n\tif(depositMandatoryYN.checked){\n\t\t\tif(partialDepositValue==\'\' || parseInt(partialDepositValue)==0){ // MMS-SCF-0389- Karthik added the below logic for to allow Zero in Parial Deposit , provided Partial Depository Mandatory flag is unchecked\n\t\t\t\talert(\"Partial Deposit Value cannot be null or Zero\");\n\t\t\t\tdepositMandatoryYN.checked=false;\n\t\t\t\tdepositMandatoryYN.value=\'false\';\n\t\t\t}else{\n\t\t\t\tdepositMandatoryYN.value=\'true\';\n\t\t\t}\n\t}else{\n\t\tdepositMandatoryYN.value=\'false\';\n\t}\n}\n\nfunction pkgPriceDepositAdd(){\n\tif(doPartialDepositPageValidation()==true){\n\t\n\tvar form=document.PkgDefBasePriceDepositForm;\t\n\tvar errMsg=partialDepositValidation(form);\n\t\n\tif(errMsg==\'\'){\n\n\tvar table = document.getElementById(\'pkgPriceDepositTable\');\n\tdocument.PkgDefBasePriceDepositForm.recordCount.value=table.rows.length;\n\tvar index=table.rows.length-1;//-1 because iteration normally shud start with 0 on retreiving page.\n\n\t//alert(index);\n\tvar row=document.getElementById(\'pkgPriceDepositTable\').insertRow();\n\tvar cell1=row.insertCell(0);\n\tvar cell2=row.insertCell(1);\n\tvar cell3=row.insertCell(2);\n\tvar cell4=row.insertCell(3);\n\t\n\tvar seqNo=index+1;\n\tcell1.innerHTML=\"<input type=\'text\' size=\'5\' name=\'encSeqNo\"+index+\"\' id=\'encSeqNo\"+index+\"\' value=\'\"+seqNo+\"\'>\";\n\tcell2.innerHTML=\"<select id=\'partialDepositType\"+index+\"\' name=\'partialDepositType\"+index+\"\' id=\'partialDepositType\"+index+\"\' ><option value=\'P\'>Percentage</option><option value=\'A\'>Amount</option></select>\";\n\tcell3.innerHTML=\"<input type=\'text\' name=\'partialDeposit\"+index+\"\' id=\'partialDeposit\"+index+\"\' value=\'\' onblur=\'partialDepositDataValidation(\"+index+\")\'>\";//// MMS-SCF-0389- Karthik added onblur to allow Zero in Parial Deposit , provided Partial Depository Mandatory flag is unchecked\n\tcell4.innerHTML=\"&nbsp;&nbsp;<input type=\'checkbox\' checked value=\'true\' name=\'depositMandatoryYN\"+index+\"\' id=\'depositMandatoryYN\"+index+\"\' onclick=\'depositMandatoryChkBox(\"+index+\")\'>\";//48042\n\t\t\n\tvar objDiv = document.getElementById(\"pkgPriceDepositTableDiv\");\n\tobjDiv.scrollTop = objDiv.scrollHeight;\n\twindow.scrollTo(0, objDiv.scrollHeight);\n\t}\n\telse{\n\t\talert(errMsg);\n\t}\n\t}\n}\n\nfunction partialDepositValidation(previlageCardForm){\n\tfor(var i=0; i<previlageCardForm.elements.length; i++)\n\t{\n\tvar fieldName=previlageCardForm.elements[i].name;\n\tvar indexFound=fieldName.indexOf(\"partialDeposit\");\n\t\tif(indexFound!=-1){\n\t\t\tif(previlageCardForm.elements[i].value==\'\')\n\t\t\treturn \"Partial Deposit value should be Provided\";\n\t\t}\n\t}\n\treturn \"\";\n}\n\n/* Provide Input FormObject(POST requestXML) and JSP Page for that FormObject Processing  */\nfunction doPartialDepositValidationMain() {\n\nif(doPartialDepositPageValidation()==true){\n\tvar frmObj=document.PkgDefBasePriceDepositForm;\n\tvar temp_jsp=\"../../eBL/jsp/PkgDefBasePricePartialDepositValidation.jsp?action=submit\";\n\t\t\t\n\t\t\tif(frmObj!=\"\" && frmObj!=null && frmObj !=undefined )\n\t\t\t{\n\t\t\tvar xmlString=formXMLStringMain(frmObj);\n\t\t\tvar updation=formValidation(xmlString,temp_jsp);\n\t\t\t}\n\t\n\tvar recCount=frmObj.recordCount.value\n\tif(recCount>0){\n\twindow.returnValue=document.PkgDefBasePriceDepositForm.partialDepositType0.value+\"|\"+document.PkgDefBasePriceDepositForm.partialDeposit0.value;\n\t}else{//48042\n\twindow.returnValue=\"|\";\t\n\t}\n\twindow.close(); \n}\n}\n\nfunction doPartialDepositPageValidation()\n{\n\tvar frmObj=document.PkgDefBasePriceDepositForm;\n\tvar count=frmObj.recordCount.value;\n\tvar pkgPrice=frmObj.pkgPrice.value;\n\tvar manipulatedAmount=0;\n\tvar totalPercentage=0;\n\tfor(var i=0;i<count;i++){\n\t\tif(eval(\"document.PkgDefBasePriceDepositForm.partialDepositType\"+i).value ==\'P\'){\n\t\tmanipulatedAmount\t+= (parseFloat(eval(\"document.PkgDefBasePriceDepositForm.partialDeposit\"+i).value)  *  pkgPrice/100.0 );\n\t\ttotalPercentage\t\t+=  parseFloat(eval(\"document.PkgDefBasePriceDepositForm.partialDeposit\"+i).value);\n\t\t}else{\t\t\n\t\tmanipulatedAmount\t+=  parseFloat(eval(\"document.PkgDefBasePriceDepositForm.partialDeposit\"+i).value);\t\t\n\t\t}\n\t}\n\t\n\tif(totalPercentage>100){\n\talert(\'Total Partial Deposit Percentage must not exceed 100\');\n\treturn false;\n\t}\n\t\t\t\n\tif(manipulatedAmount>pkgPrice){\n\talert(\"The entered Amount \" +manipulatedAmount+ \" cannot be greater than Package Price \"+ pkgPrice);\n\treturn false;\n\t}\n\n return true;\n}\n\nfunction deleteFromSession() {\n\n\tvar frmObj=document.PkgDefBasePriceDepositForm;\n\tvar temp_jsp=\"../../eBL/jsp/PkgDefBasePricePartialDepositValidation.jsp?action=delete\";\n\t\t\t\n\t\t\tif(frmObj!=\"\" && frmObj!=null && frmObj !=undefined )\n\t\t\t{\n\t\t\tvar xmlString=formXMLStringMain(frmObj);\n\t\t\tvar updation=formValidation(xmlString,temp_jsp);\n\t\t\t}\t\n\twindow.location.href=window.location.href+\"&deleteCode=Y\";//47933 delete Issue\n\t}\n\n\n//XML String passing for validation\nfunction formValidation(xmlStr,temp_jsp)\n{\t\n/*var xmlDoc = new ActiveXObject( \"Microsoft.XMLDom\" ) ;\nvar xmlHttp = new ActiveXObject( \"Microsoft.XMLHTTP\" ) ;\nxmlDoc.loadXML(xmlStr);*/\n\nvar xmlHttp = new XMLHttpRequest();\nvar xmlDoc = \"\";\nnew DOMParser().parseFromString(getXMLString(xmlStr), \"text/xml\");\nxmlHttp.open(\"POST\",temp_jsp,false);\nxmlHttp.send(xmlDoc);\nvar responseText=xmlHttp.responseText ;\nreturn true;\n}\t\n\nfunction formXMLStringMain(frmObj)\n{\nif( frmObj!=null && frmObj != \"undefined\" && frmObj.length >0)\n{\t\n\tvar xmlStr =\"<root><SEARCH \";\n\tif(true)\n\t{\n\tvar arrObj = frmObj.elements;\n\tfor(var i=0;i<arrObj.length;i++)\n\t{\n\t\tvar val = \"\" ;\n\t\tif(arrObj[i].type == \"checkbox\")\n\t\t{\n\t\t\tval = arrObj[i].value;\n\t\t\tif(arrObj[i].name != null && arrObj[i].name != \"\")\n\t\t\t\txmlStr+= arrObj[i].name+\"=\\\"\" + checkSpl(val) + \"\\\" \" ;\n        }\n\t    else if(arrObj[i].type == \"radio\")\n\t\t{\n\t\t\tif(arrObj[i].checked)\n\t\t\t{\n\t\t\t\tval = arrObj[i].value;\n\t\t        if(arrObj[i].name != null && arrObj[i].name != \"\")\n\t\t\t\t\txmlStr+= arrObj[i].name+\"=\\\"\" + checkSpl(val) + \"\\\" \" ;\n            }\n\t    }\n\t\telse if(arrObj[i].type == \"select-multiple\" )\n\t\t{\n\t\t\tfor(var j=0; j<arrObj[i].options.length; j++)\n\t\t    {\n\t\t\t\tif(arrObj[i].options[j].selected)\n\t\t\t\t\tval+=arrObj[i].options[j].value +\"~\";\n            }\n\t        val= val.substring(0,val.lastIndexOf(\'~\'));\n\t\t    if(arrObj[i].name != null && arrObj[i].name != \"\")\n\t\t\t    xmlStr+= arrObj[i].name+\"=\\\"\" + checkSpl(val) + \"\\\" \" ;\n\t\t}\n\t    else\n\t\t{\n\t\t\tval = arrObj[i].value;\n\t        if(arrObj[i].name != null && arrObj[i].name != \"\")\n\t\t\t\txmlStr+= arrObj[i].name+\"=\\\"\" + checkSpl(val) + \"\\\" \" ;\n        }\n\t}\n}\nxmlStr +=\" /></root>\";\t\n}\nreturn xmlStr;\n}\n\nfunction checkSpl( val ) {\n    var result = \"\" ;\n    var ch = \"\" ;\n\n    var indVal = 0;\n    while ( (indVal = val.indexOf(\'\\n\',indVal)) != -1 )\n    {\n        val = val.replace(\"\\n\",\"\\\"\");\n    }\n\n    var spChars = new Array( \"<\", \">\", \"&\", \"\\\"\", \"\'\" ) ;\n    var chChars = new Array( \"&lt;\", \"&gt;\", \"&amp;\", \"&quot;\", \"&apos;\" ) ;\n    for(var i=0; i<val.length; i++) {\n        for(var j=0; j<spChars.length; j++) {\n            if ( val.substring(i,i+1) == spChars[j] ) {\n                ch = chChars[j] ;\n                j=spChars.length ;\n            } else {\n                ch = val.substring(i,i+1) ;\n            }\n        }\n        result += ch ;\n    }\n    return result ;\n}\n\n</script>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Insert title here</title>\n</head>\n<body>\n<BODY onKeyDown=\"lockKey();\" onMouseDown=\"CodeArrest();\"\n\tonSelect=\"codeArrestThruSelect();\">\n\n\t<FORM name=\"PkgDefBasePriceDepositForm\" id=\"PkgDefBasePriceDepositForm\" >\n\t<TABLE width=\'100%\' border=\'0\' cellpadding=\'3\' cellspacing=\'0\'>\n\t\t\t<tr>\n\t\t\t<td width=\'50%\' class=\'fields\'> </td>\t\t\t\n\t\t\t<td width=\'50%\' class=\'fields\'> <input type=\'button\' class=\'button\'  value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' size=\'20\'  onClick=\'pkgPriceDepositAdd();\' ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =">\n\t\t\t<input type=\'button\' class=\'button\'  value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' size=\'20\'  onClick=\'deleteFromSession();\' ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" >\n\t\t\t<input type=\'button\' class=\'button\'  value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' size=\'20\'  onClick=\'doPartialDepositValidationMain();\' ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =">\n\t\t\t</td>\n\t\t\t</tr>\n\t</TABLE>\n\t<div id=\"pkgPriceDepositTableDiv\" STYLE=\"width:100%; height:300; overflow: auto;\">\n\t<TABLE width=\"100%\" border=\'0\' cellpadding=\'3\' cellspacing=\'0\'>\n\n\t</TABLE>\n\n\t<TABLE  width=\"100%\"  id=\"pkgPriceDepositTable\" border=\'0\' cellpadding=\'3\' cellspacing=\'0\'>\n\t\t\t<tr>\n\t\t\t<th width=\"10%\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t\t\t<th width=\"15%\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n\t\t\t<th width=\"10%\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t\t\t<th width=\"*\"></th>\n\t\t\t</tr>\t\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t<tr>\n\t\t\t<td width=\"10%\"><input type=\"text\" size=\'5\' name=\'encSeqNo";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' id=\'encSeqNo";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="></td>\n\t\t\t<td width=\"15%\">\n\t\t\t\t<select id=\'partialDepositType";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' name=\'partialDepositType";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'  ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =">\n\t\t\t\t<option ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="selected";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" value=\'P\'>Percentage</option>\n\t\t\t\t<option ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" value=\'A\'>Amount</option>\t\t\t\t\n\t\t\t\t</select>\n\t\t\t</td>\n\t\t\t<!-- \t MMS-SCF-0389- Karthik added the below logic for to allow Zero in Parial Deposit , provided Partial Depository Mandatory flag is unchecked -->\n\t\t\t<td width=\"15%\"><input type=\"text\" name=\'partialDeposit";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'partialDeposit";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" onblur=\'partialDepositDataValidation(";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =")\'></td>\n\t\t\t<td width=\"15%\">&nbsp;&nbsp;<input type=\"checkbox\" name=\'depositMandatoryYN";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' id=\'depositMandatoryYN";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="checked value=\'true\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="value=\'false\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" onclick=\'depositMandatoryChkBox(";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =")\' ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =">\n\t\t\t<td width=\"10%\">&nbsp;&nbsp;<input type=\"radio\" name=\'deletePartialRecord\' id=\'deletePartialRecord\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="></td>\t\n\t\t\t<td width=\"*\"></td>\n\t\t\t</tr>\n\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t</TABLE> \n\t</div>\n\t\n\t<input type=\'hidden\' name=\'blgClsCode\' id=\'blgClsCode\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\t\n\t<input type=\'hidden\' name=\'pkgPrice\' id=\'pkgPrice\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\t\t\n\t<input type=\'hidden\' name=\'recordCount\' id=\'recordCount\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\t\n\t</FORM>\n\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/



public String QueryReplacer(String query,String locale){
	query=query.replace("@locale", "'"+locale+"'");
	return query;
}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block2Bytes, _wl_block2);
 

String locale=(String)session.getAttribute("LOCALE");
String facility_id=(String)session.getAttribute("facility_id");
String blgClsCode=request.getParameter("blgClsCode");
String packageCode=request.getParameter("packageCode");
String effFromDate=request.getParameter("effFromDate");
String pkgPrice=request.getParameter("pkgPrice");
String modifyStatus = request.getParameter("modifystatus");

String deleteCode="N";//47933 delete Issue
deleteCode=request.getParameter("deleteCode");
if(deleteCode==null)deleteCode="N";

System.out.println("PartialDepositPage Called, blgClsCode,deleteCode:"+blgClsCode + packageCode + effFromDate+deleteCode);

HashMap<String,ArrayList<String>> dataMap=new HashMap<String,ArrayList<String>>();
ArrayList<String> partialDepositList=null;

String beanId = "bl_PkgDefBean";
String beanName = "eBL.PkgDefBean";
PkgDefBean bean=(PkgDefBean) getBeanObject(beanId, beanName, request);

/* Checks whether data is already present in Session */
dataMap=bean.getPartialDepositList();
partialDepositList=dataMap.get(blgClsCode);
System.out.println("partialDepositList from sess :"+partialDepositList);

/* If it is not Present in Session fetch from DB */
if( (partialDepositList==null || partialDepositList.size()==0) && deleteCode.equals("N") && dataMap.containsKey(blgClsCode) == false ){//47933 delete Issue
	
	bean.fetchPartialDepositList(blgClsCode,facility_id,packageCode,effFromDate);
//bean.fetchPartialDepositList(blgClsCode,facility_id,effFromDate,packageCode);
dataMap=bean.getPartialDepositList();
partialDepositList=dataMap.get(blgClsCode);
System.out.println("partialDepositList from DB :"+partialDepositList);
}

if(partialDepositList==null) partialDepositList=new ArrayList<String>();

System.out.println("blgClsCode:"+blgClsCode);
System.out.println("dataMap:"+dataMap);
System.out.println("partialDepositList:"+partialDepositList);
int i=0;

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
 
	
	for(i=0;i<partialDepositList.size();i++) {	
		
		StringTokenizer st=new StringTokenizer(partialDepositList.get(i),"~");
		String partialDepositSeq="";
		String partialDepositType="";
		String partialDepositValue="";
		String partialDepositMandatory="";
		
		while(st.hasMoreTokens()){
			partialDepositSeq=st.nextToken();
			partialDepositType=st.nextToken();
			partialDepositValue=st.nextToken();
			partialDepositMandatory=st.nextToken();
		}				
	
	
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block26Bytes, _wl_block26);
if(partialDepositType.equals("P")){
            _bw.write(_wl_block27Bytes, _wl_block27);
}
            _bw.write(_wl_block28Bytes, _wl_block28);
if(partialDepositType.equals("A")){
            _bw.write(_wl_block27Bytes, _wl_block27);
}
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(partialDepositValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
if(partialDepositMandatory.equals("Y")){
            _bw.write(_wl_block34Bytes, _wl_block34);
}else{
            _bw.write(_wl_block35Bytes, _wl_block35);
}
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block39Bytes, _wl_block39);
 } 
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(blgClsCode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(pkgPrice));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(partialDepositList.size()));
            _bw.write(_wl_block43Bytes, _wl_block43);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Add.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.delete.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Submit.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EncounterSequenceNo.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PartialDepositType.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PartialDeposit.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PartialDepositMandatory.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.delete.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
