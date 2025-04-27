package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __spltyhomepageeventdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/SpltyHomePageEventDetails.jsp", 1736157593245L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<HTML>\n<HEAD>\n<TITLE> ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" </TITLE>\n<META NAME=\"Generator\" CONTENT=\"EditPlus\">\n<META NAME=\"Author\" CONTENT=\"\">\n<META NAME=\"Keywords\" CONTENT=\"\">\n<META NAME=\"Description\" CONTENT=\"\">\n ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n<script src=\'../../eCA/js/SpltyHomePage.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\n<style>\n A:link\n{\n    COLOR: yellow\n}\nA:visited\n{\n    COLOR: yellow\n} \n</style>\n\n<script language=\"VBScript\">\n\tSub callAviDcm(extn)\n\t\tOn Error Resume Next\n\t\tdim x\n    \tSet objNet = CreateObject(\"WScript.Shell\")\n\t\tif lcase(extn) = \"avi\" then\n\t\t\tx = objNet.Run(\"Z:\\Avi\\invokeavi.bat\",0) \n\t\tELSEIF lcase(extn) = \"dcm\" then\n\t\t\tx = objNet.Run(\"Z:\\DCM\\ShowDCM.bat\",0) \n\t\tend if\n\tend sub\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n<BODY class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onScroll=\'scrollFrame()\' onResize=\'alignDivs()\'>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t<form name=\'dataForm\' id=\'dataForm\'>\n\t\t<div id=\'divDataTitle\' style=\'postion:relative\'>\n\t\t\t<table border=\'1\' width=\'100%\' id=\'dataTitleTable\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' >\n\t\t\t\t<TR>\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<TH nowrap id=\'visID";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'><img src=\'../../eCA/images/graph.gif\' style=\'visibility:hidden\' ></img><a href=\"javascript:collapseColumn(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\')\" title=\'Click here to collapse the column\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&nbsp;</a><br></TH>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t</TR>\n\t\t\t</table>\n\t\t</div>\n\t\t<table border=\'1\' width=\'100%\' id=\'dataTable\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' style=\"border-bottom:#ffffff\">\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\t\n\t\t\t\t<TR>\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t<TH nowrap style=\'visibility:hidden\' id=\'visIDup";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&nbsp;<!--<input type=\'image\' src=\'../../eCA/images/page_old.gif\' onclick=\'fnEnterQuickNotes()\'>--></TH>\n\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t</TR>\n\t\t\t</table>\n\t\t\t<input type=\'hidden\' name=\'txtFlagComments\' id=\'txtFlagComments\' value=\"N\">\n\t\t\t<input type=\'hidden\' name=\'txtFlagQuickText\' id=\'txtFlagQuickText\' value=\"N\">\n\t\t\t<input type=\'hidden\' name=\'totRows\' id=\'totRows\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t<input type=\'hidden\' name=\'totCols\' id=\'totCols\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t\t<input type=\'hidden\' name=\'finalTotCols\' id=\'finalTotCols\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t<input type=\'hidden\' name=\'hiddenColumns\' id=\'hiddenColumns\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'lastDateTime\' id=\'lastDateTime\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'firstDateTime\' id=\'firstDateTime\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'queryStringForComments\' id=\'queryStringForComments\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'graphorder\' id=\'graphorder\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'flowsheetCompId\' id=\'flowsheetCompId\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'errorEvent\' id=\'errorEvent\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'graphValuesOnChk\' id=\'graphValuesOnChk\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'viewConfRes\' id=\'viewConfRes\' value=\'\'>\n\t\t\t\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\n<script>\n\tsetTimeout(\"alignUnitsAndData()\",200);\n\tsetTimeout(\"alignHeight()\",300);\n\tvar curidx  = eval(parent.controlsFrame.document.forms[0].cur_idx_value.value);\n\tvar totidx  = eval(parent.controlsFrame.document.forms[0].idx_value.value);\n\n\tif(curidx == 0)\n\t\tparent.controlsFrame.document.forms[0].prev.disabled = true;\n\telse if(curidx > 0)\n\t\tparent.controlsFrame.document.forms[0].prev.disabled = false;\n\n\tif((curidx+1) >= totidx)\n\t\tparent.controlsFrame.document.forms[0].next.disabled = true;\n\telse \n\t\tparent.controlsFrame.document.forms[0].next.disabled = false;\n\t\n</script>\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

/*	String replaceSpecialChar(String resultStr)
	{
		//resultStr=resultStr.replace('\n','�');
		//resultStr=resultStr.replace('\r',' ');
		//resultStr=resultStr.replace('\'','�');
		while(resultStr.indexOf("\n")!=-1)
		{
			int a=resultStr.indexOf("\n");
			StringBuffer temp=new StringBuffer(resultStr);
			temp.replace(a,a+1,"~");
			resultStr=temp.toString();

		}
		while(resultStr.indexOf("\r")!=-1)
		{
			int a=resultStr.indexOf("\r");
			StringBuffer temp=new StringBuffer(resultStr);
			temp.replace(a,a+1,"");
			resultStr=temp.toString();

		}
		while(resultStr.indexOf("'")!=-1)
		{
			int a=resultStr.indexOf("'");
			StringBuffer temp=new StringBuffer(resultStr);
			temp.replace(a,a+1,"`");
			resultStr=temp.toString();

		}
		while(resultStr.indexOf("\"")!=-1)
		{
			int a=resultStr.indexOf("\"");
			StringBuffer temp=new StringBuffer(resultStr);
			temp.replace(a,a+1,"|");
			resultStr=temp.toString();

		}
		return resultStr;
	}*/

	String replaceSpecialChar(String resultStr){		

		if(resultStr.indexOf("\n")!=-1)
			resultStr = resultStr.replaceAll("\n","~");			
		if(resultStr.indexOf("\r")!=-1)
			resultStr = resultStr.replaceAll("\r","");
		if(resultStr.indexOf("'")!=-1)
			resultStr = resultStr.replaceAll("'","`");
		if(resultStr.indexOf("\"")!=-1)
			resultStr = resultStr.replaceAll("\"","|");
		return resultStr;
	}

	HashMap drawTD(String histDataType,String resultNum, String resultStr, String extApplID, int columnNumber, int rowNumber, String histRecType, String sysID, String accessionNum, String sysEventCode, String extImgID, String toolTip, String deltaFailInd, String tempAdditional, String tempValue, String eventDateTime, String quickTextCount, String strStatus, String textCount, String called_from, String strNormalcyInd, String colorCellInd, String normIndicator,String eventGroup,String eventClass,String eventCode,String tempDisplayEventCode,String tempDisplayEventClass, String tempDisplayEventGroup, String tempDisplayHistRecType, int prevK)
	{
		int i = prevK;
		int j = columnNumber;

		String tempToolTip = toolTip.replace('\'',' ');

		String tempString = "";
		String classValue = "";
		String tempStrValue = "";
		String tempOnMouseOver = "";
		//String prevHistRecType	 = "";
		//String prevEventClass = "";
		//String prevEventGroup = "";
		//String prevEventCode = "";
		//StringBuffer tempRowString = new StringBuffer();
		HashMap returnMap = new HashMap();
	
		if(i % 2 == 0)
			classValue = "CACHARTQRYEVEN";
		else
			classValue = "CACHARTQRYEVEN";

		if(histDataType.equals("NUM"))
		{
			tempValue =tempValue+"<input type='hidden' name='resultNum' id='resultNum' value='"+tempValue+"'>";
			if(!tempAdditional.equals("")) //if there is any STR
			{
				tempAdditional=replaceSpecialChar(tempAdditional);
				if(tempAdditional.length() > 10)
					tempValue =tempValue+ "&nbsp;" + "<a  href='javascript:ShowComments(\""+tempAdditional+"\")'><font size='1' color='black'><i>"+tempAdditional.substring(0,9)+"...</i></a>";
				else
					tempValue =tempValue+"&nbsp;<i>" +tempAdditional+"</i>";
			}
			if(!textCount.equals("0"))//if there is any TXT
			{ 
				tempValue =tempValue+"&nbsp;"+"<input id='imageFlowTextVis"+i+"ID"+j+"' type='image' style='display' src='../../eCA/images/flow_text.gif' style='display' onClick=\"return getText('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"')\">";
			}
		}
		else if(histDataType.equals("TXT") || histDataType.equals("HTM"))
		{
			if(!textCount.equals("0"))
			{
				tempValue = "<input id='imageFlowTextVis"+i+"ID"+j+"' type='image' style='display' style='display' src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"')\">";
			}

		}
		else if(histDataType.equals("STR"))
		{
			if(tempValue.length() > 15)
			{
				tempStrValue = tempValue.substring(0,14);
				tempValue = replaceSpecialChar(tempValue);
				tempValue = "<a  href=\"javaScript:ShowComments('"+tempValue+"')\"><font size='1' color='black'>"+tempStrValue+"...</a><br>";
			}
			if(!textCount.equals("0"))//in case of STR if any TXT is there
			{ 
				tempValue =tempValue+"&nbsp;"+"<input id='imageFlowTextVis"+i+"ID"+j+"' type='image' style='display' src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"')\">";
			}
		}



		if(!tempValue.equals(""))
		{
			if(!called_from.equals("OR"))
			{
				/*if(quickTextCount.equals("0"))
				{
					tempValue =tempValue+ "&nbsp;"+"<input type='image' style='display:none' name='imagevisibility"+i+"ID"+j+"' id='imagevisibility"+i+"ID"+j+"' src='../../eCA/images/page_old.gif' onClick=\"return enterQuickText('"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','S')\">";
				}
				else
				{
					tempValue =tempValue+ "&nbsp;"+"<input type='image' name='imagevisibility"+i+"ID"+j+"' id='imagevisibility"+i+"ID"+j+"' src='../../eCA/images/page_old.gif' onClick=\"return enterQuickText('"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','S')\">";
				}*/
			}
			if(!called_from.equals("OR"))
			{
				if(strStatus.equals("E"))
				{
					 tempString = tempString + "<TD class='TD_BROWN' style='cursor:pointer' align='center' id='visibility"+i+"ID"+j+"' onClick=\"return changeColor(this,'"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"')\"" ;
				}
				else if((strNormalcyInd.equals("C") || strNormalcyInd.equals("B")) && !strNormalcyInd.equals("") && !colorCellInd.equals("NONE"))
				{
					tempString = tempString + "<TD class='"+colorCellInd+"' id='visibility"+i+"ID"+j+"' style='cursor:pointer' align='center' onClick=\"return changeColor(this,'"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"')\"";					
				}
				else
				{
					tempString = tempString + "<TD class='"+classValue+"' style='cursor:pointer' align='center' id='visibility"+i+"ID"+j+"' onClick=\"return changeColor(this,'"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"')\"";
				}
			}
			else
			{
				if(strStatus.equals("E"))
				{
					tempString = tempString + "<TD class='TD_BROWN' style='cursor:pointer' align='center' id='visibility"+i+"ID"+j+"' ";
				}
				else if((strNormalcyInd.equals("C") || strNormalcyInd.equals("B")) && !strNormalcyInd.equals("") && !colorCellInd.equals("NONE"))
				{
					tempString = tempString + "<TD class='"+colorCellInd+"' style='cursor:pointer' align='center' id='visibility"+i+"ID"+j+"' onClick=\"return changeColor(this,'"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"')\"";
				}
				else
				{
					tempString = tempString + "<TD class='"+classValue+"' style='cursor:pointer' align='center' id='visibility"+i+"ID"+j+"' ";
				}
			}
		}
		else
		{
			if(strStatus.equals("E"))
			{
				tempString = tempString + "<TD align='center' class='TD_BROWN' id='visibility"+i+"ID"+j+"' ";
			}
			else
			{
				tempString = tempString + "<TD align='center' class='"+classValue+"' id='visibility"+i+"ID"+j+"' ";				
			}

		}

		if(!tempToolTip.equals(""))
		{

			tempOnMouseOver="onMouseOver='displayToolTip(\""+tempToolTip+"\")' onMouseOut =hideToolTip()";
			 tempString = tempString + tempOnMouseOver;
		}
		
		if(tempValue.equals("")) 
		{
			tempValue = "&nbsp;";
		}

		if(!extApplID.equals(""))
		{
			tempValue =tempValue+"&nbsp;"+"<img src='../../eCA/images/"+extApplID+".gif'  onClick=\"return getFile('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+extApplID+"')\">";

		}		
		if(!deltaFailInd.equals(""))
		{
			tempValue = tempValue+"<font color='red'>["+deltaFailInd+"]</font>";
		}
		if((strNormalcyInd.equals("I") || strNormalcyInd.equals("B") )&& !strNormalcyInd.equals("") && !colorCellInd.equals("NONE"))
		{
			tempValue = tempValue+ "<font color='black'><b>["+normIndicator+"]</b></font>";
		}



		tempString = tempString + ">"+tempValue+"</TD>";



		//tempString = tempRowString.toString() + tempString;

		try
		{
			returnMap.put("tempString"+i+"Map"+j,tempString);
			//returnMap.put("tempRowString"+i+"Map"+j,tempRowString);
			returnMap.put("histRecType"+i,histRecType);
			returnMap.put("eventClass"+i,eventClass);
			returnMap.put("eventGroup"+i,eventGroup);
			returnMap.put("eventCode"+i,eventCode);
			returnMap.put("eventDateTime"+i+"Map"+j,eventDateTime);
			returnMap.put("resultNum"+i+"Map"+j,resultNum);
		}
		catch(Exception ee)
		{

			ee.printStackTrace();
		}



		return returnMap;
	}// end of drawTD



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
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

  
Connection con = null;
try
{
		  con = ConnectionManager.getConnection(request);
		  String strFromDate  = "";
		  String strToDate = "";
		  String strPatientId = "";
		  String strmodule_id = "";
		  String strcycle_no = "";
		  String strHistRecType = "";
		  String strEventClass ="";
		  String strEventGroup = "";
		  String strEventCode  = "";
		  String strFacilityId ="";
		  String strEncounterId ="";
		  String strEpisodeType ="";
		  String strNormalcyInd ="";
		  String strAbnormal ="";
		  String strFlowSheetId ="";
		  String strViewConfRes ="";
		  String strGraphOrder ="";
		  String called_from ="";
		  String strErrorEvent ="";
		  String prevHistRecType = "";
		  String prevEventClass = "";
		  String prevEventGroup = "";
		  String prevEventCode = "";

		  int prevK = 0;	
		  int nIndex =1;

		  strGraphOrder		= request.getParameter("graphorder")==null?"":request.getParameter("graphorder");
		  strViewConfRes	= request.getParameter("viewConfRes")==null?"":request.getParameter("viewConfRes");
		  strFromDate		= request.getParameter("c_from_date")==null?"":request.getParameter("c_from_date");
		  strToDate			= request.getParameter("c_to_date")==null?"":request.getParameter("c_to_date");
		  strFlowSheetId	= request.getParameter("cboFlowSheetComp")==null?"":request.getParameter("cboFlowSheetComp");
		  strEventCode		= request.getParameter("eventitem")==null?"":request.getParameter("eventitem");
		  strErrorEvent		= request.getParameter("errorEvent")==null?"":request.getParameter("errorEvent");
		  strAbnormal		= request.getParameter("abnormal")==null?"N":request.getParameter("abnormal");
		  strPatientId		= request.getParameter("p_patient_id")==null?"":request.getParameter("p_patient_id");
		  strmodule_id		= request.getParameter("p_module_id")==null?"":request.getParameter("p_module_id");
		  strcycle_no		= request.getParameter("p_cycle_no")==null?"":request.getParameter("p_cycle_no");
		  strEventGroup		= request.getParameter("p_event_group")==null?"":request.getParameter("p_event_group");
		  strEventClass		= request.getParameter("p_event_class")==null?"":request.getParameter("p_event_class");
		  strHistRecType	= request.getParameter("p_hist_rec_type")==null?"":request.getParameter("p_hist_rec_type");
		  strFacilityId		= request.getParameter("c_facility_id")==null?"":request.getParameter("c_facility_id");
		  strEpisodeType	= request.getParameter("episode_type")==null?"":request.getParameter("episode_type");
		  strEncounterId	= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");

		  called_from		= request.getParameter("p_called_from")==null?"":request.getParameter("p_called_from");
			
		StringBuffer strBuffDates = new StringBuffer();
		StringBuffer sqlData	  = new StringBuffer();
		StringBuffer sbQryCriteria = new StringBuffer();
  
  ArrayList dateList = new ArrayList();
  //ArrayList tempDateList = new ArrayList();
  
  //String tempDateValue = "";
  String lastDateTime = "";
  String firstDateTime = "";

  HashMap tempSessionMap = null;
  HashMap tempTDMap = null;
  HashMap tempTRMap = null;

  PreparedStatement pstmt = null;
  ResultSet rs = null;

	  sbQryCriteria.append(" g.patient_id = ?  and g.MODULE_ID=? and g.CYLE_NO=? and a.HIST_REC_TYPE=g.HIST_REC_TYPE and a.CONTR_SYS_ID=g.CONTR_SYS_ID and a.ACCESSION_NUM =g.ACCESSION_NUM	 and a.CONTR_SYS_EVENT_CODE	=g.CONTR_SYS_EVENT_CODE ");

		if(!strHistRecType.equals(""))
			sbQryCriteria.append(" and a.hist_rec_type = ? ");

		if(!strEventClass.equals(""))
			sbQryCriteria.append(" and a.event_class = ? ");

		if(!strEventGroup.equals(""))
			sbQryCriteria.append(" and a.event_group = ? ");

		if(!strEventCode.equals(""))
			sbQryCriteria.append(" and a.event_code = ? ");

		if(!strFromDate.equals(""))
			sbQryCriteria.append(" and g.KEY_REF >= ?");

		if(!strToDate.equals(""))
			sbQryCriteria.append(" and g.KEY_REF <= ?"); 

		if(!strFacilityId.equals(""))
			sbQryCriteria.append(" and a.facility_id = ? ");

		if(!strEncounterId.equals(""))
			sbQryCriteria.append(" and a.encounter_id = ? ");

		if (!strEpisodeType.equals("") )
			sbQryCriteria.append(" and a.PATIENT_CLASS = ? ");

		if(strAbnormal.equals("Y"))
			sbQryCriteria.append(" and a.normalcy_ind is not null");

		if(strViewConfRes.equals("X"))
			sbQryCriteria.append("and nvl(PROTECTION_IND,'N')!='Z')");

	   

	try
	{
		strBuffDates.append("Select g.KEY_REF event_date	From 	cr_encounter_detail a,CA_PAT_SPLTY_HIST_REF g ");
		strBuffDates.append("where  "+sbQryCriteria.toString());

		if(!strFlowSheetId.equals(""))
			strBuffDates.append(" and exists (select 1 from ca_flow_sheet_item f where f.flow_sheet_id=? and f.hist_rec_type=a.hist_rec_type and f.event_code=a.event_code  and  f.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) ") ;
			
		strBuffDates.append(" Order by g.KEY_REF "+strGraphOrder);

		tempSessionMap = new HashMap();
		tempTDMap = new HashMap();
        

		pstmt = con.prepareStatement(strBuffDates.toString());

		pstmt.setString(nIndex++,strPatientId);
		pstmt.setString(nIndex++,strmodule_id);
		pstmt.setString(nIndex++,strcycle_no);

		if(!strHistRecType.equals(""))
			pstmt.setString(nIndex++,strHistRecType);

		if(!strEventClass.equals(""))
			pstmt.setString(nIndex++,strEventClass);

		if(!strEventGroup.equals(""))
			pstmt.setString(nIndex++,strEventGroup);

		if(!strEventCode.equals(""))
			pstmt.setString(nIndex++,strEventCode);

		if(!strFromDate.equals(""))
			pstmt.setString(nIndex++,strFromDate);

		if(!strToDate.equals(""))
			pstmt.setString(nIndex++,strToDate);
		
		if(!strFacilityId.equals(""))
			pstmt.setString(nIndex++,strFacilityId);

		if(!strEncounterId.equals(""))
			pstmt.setString(nIndex++,strEncounterId);
	
		if(!strEpisodeType.equals("") )
		{
			if(strEpisodeType.equals("I"))
				pstmt.setString(nIndex++,"IP");
			else if(strEpisodeType.equals("O"))
				pstmt.setString(nIndex++,"OP");
			else if(strEpisodeType.equals("D"))
				pstmt.setString(nIndex++,"DC");
			else if(strEpisodeType.equals("E"))
				pstmt.setString(nIndex++,"EM");
			else if(strEpisodeType.equals("X"))
				pstmt.setString(nIndex++,"XT");
		}

		if(!strFlowSheetId.equals(""))
			pstmt.setString(nIndex++,strFlowSheetId);
		
		rs = pstmt.executeQuery();

		String strTempDt = "";

        while(rs.next())
		{
			if(dateList.size() == 0)
			{
				firstDateTime = rs.getString(1);
			}
			if(dateList.size() < 10)
			{
				if(!dateList.contains(rs.getString(1)))
				{
				   strTempDt = rs.getString(1);

//				   strTempDt = com.ehis.util.DateUtils.convertDate(strTempDt,"DMYHM","en",locale);
				   dateList.add(strTempDt);
				}
			}
			else
			{
				lastDateTime = rs.getString(1);
			}
        }

		if(rs!= null) rs.close();
        if(pstmt!=null) pstmt.close();
	}//end of try-1
	catch(Exception e)
	{
		//out.println("Exception in try-1 of SpltyHomePageEventsDetails.jsp -"+e.toString());//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
	}
    finally
	{
		
    }
	
            _bw.write(_wl_block9Bytes, _wl_block9);

						String strConvDt = "";
						int dateListSize = dateList.size();
					for(int i=0;i<dateListSize;i++)
						{
								strConvDt = (String)dateList.get(i);
						
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(i));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strConvDt));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);


	sqlData.append( " Select a.event_date dummydate, g.KEY_REF event_date_time , a.hist_rec_type hist_rec_type, b.short_desc hist_rec_type_desc, a.event_class eve_class, c.long_desc event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl(e.long_desc,d.long_desc) event_group_desc ,a.event_code eve_code,d.long_desc  event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id,  CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id)||' , Normal Range  ('||a.normal_low||'-'||a.normal_high||')' GetTooltip,a.STATUS stat,replace(d.short_desc,'''','') sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,'HIGH',LOW_STR,'LOW',CRIT_STR,'CRITICAL',ABN_STR,'ABNORMAL',CRIT_HIGH_STR,'CRITICALHIGH',CRIT_LOW_STR  ,'CRITICALLOW','NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND From cr_encounter_detail a ,cr_hist_rec_type b, cr_event_class   c ,cr_clin_event_mast d ,cr_clin_event_group e,CA_PAT_SPLTY_HIST_REF g ");
  
	if (!strFlowSheetId.equals(""))
		sqlData.append(" ,ca_flow_sheet_item f ");

   sqlData.append(" where b.hist_rec_type=a.hist_rec_type and c.hist_rec_type=a.hist_rec_type and  c.event_class= a.event_class and   d.hist_rec_type=a.hist_rec_type and  d.event_code=a.event_code and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE ");

    if(!strFlowSheetId.equals(""))
		sqlData.append(" and  f.flow_sheet_id=? and f.hist_rec_type=a.hist_rec_type and f.event_code=a.event_code  and  f.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  ") ;

	sqlData.append( " AND " + sbQryCriteria.toString());

	if (!strFlowSheetId.equals(""))
		sqlData.append( " ORDER BY f.order_seq_no, a.hist_rec_type,c.long_desc  ,a.event_class, a.event_group,e.long_desc  ,nvl(a.request_num_seq,d.long_desc),a.event_code,event_date_time "+strGraphOrder+" " );
	else 
		sqlData.append( " ORDER BY  a.hist_rec_type,c.long_desc  ,a.event_class, a.event_group,e.long_desc  ,nvl(a.request_num_seq,d.long_desc),a.event_code , event_date_time "+strGraphOrder+" " );

int i = 0;
int tempCnt = 0;
String classValue = "CACHARTQRYEVEN";
String histRecType = "";
String histRecTypeDesc = "";
String eventClass = "";
String eventClassDesc = "";
String eventGroup = "";
String eventGroupDesc = "";
String eventCode = "";
String eventDesc = "";
String histDataType = "";
String resultNumUOM = "";
String dummyDate = "";
String eventDateTime = "";
String accessionNum = "";
String sysID = "";
String sysEventCode = "";
String resultNum = "";
String resultStr = "";
String normIndicator = "";
String normalLow = "";
String normalHigh = "";	
String criticalLow = "";
String criticalHigh = "";
String extImgID = "";
String extApplID = "";
String toolTip = "";
String splEventDesc = "";
String quickTextCount = "0";
String deltaFailInd = "";
String colorCellInd = "";
String tempValue = "";
//String tempToolTip = "";
//String tempOnMouseOver = "";
//String tempStrValue = "";
String tempAdditional = "";
String textCount = "";
//String tempEvent = "";
String strStatus = "";
//String tempEventDateTime = "";

//int id=0;

//HashMap mapDates = new HashMap();
//HashMap mapValues = null,mapTipAndValues = null;
//int counter =0;

//HashMap tempMap = null,tempMapValues= null;

//int tempCounter = 0;

try
{
	//int j=0;
	nIndex =1;
//	con = ConnectionManager.getConnection(request);


	pstmt = con.prepareStatement(sqlData.toString());

	if (!strFlowSheetId.equals(""))
		pstmt.setString(nIndex++,strFlowSheetId);

	pstmt.setString(nIndex++,strPatientId);
	pstmt.setString(nIndex++,strmodule_id);
	pstmt.setString(nIndex++,strcycle_no);

	if(!strHistRecType.equals(""))
		pstmt.setString(nIndex++,strHistRecType);

	if(!strEventClass.equals(""))
		pstmt.setString(nIndex++,strEventClass);

	if(!strEventGroup.equals(""))
		pstmt.setString(nIndex++,strEventGroup);

	if(!strEventCode.equals(""))
		pstmt.setString(nIndex++,strEventCode);

	if(!strFromDate.equals(""))
		pstmt.setString(nIndex++,strFromDate);

	if(!strToDate.equals(""))
		pstmt.setString(nIndex++,strToDate);

	if(!strFacilityId.equals(""))
		pstmt.setString(nIndex++,strFacilityId);

	if(!strEncounterId.equals(""))
		pstmt.setString(nIndex++,strEncounterId);

	if(!strEpisodeType.equals("") )
	{
		if(strEpisodeType.equals("I"))
			pstmt.setString(nIndex++,"IP");
		else if(strEpisodeType.equals("O"))
			pstmt.setString(nIndex++,"OP");
		else if(strEpisodeType.equals("D"))
			pstmt.setString(nIndex++,"DC");
		else if(strEpisodeType.equals("E"))
			pstmt.setString(nIndex++,"EM");
		else if(strEpisodeType.equals("X"))
			pstmt.setString(nIndex++,"XT");
	}


	rs = pstmt.executeQuery();

	while(rs.next())
	{
		dummyDate = rs.getString("dummydate") == null ? "" : rs.getString("dummydate");
		eventDateTime = rs.getString("event_date_time") == null ? "" : rs.getString("event_date_time");
		histRecType = rs.getString("hist_rec_type") == null ? "" : rs.getString("hist_rec_type");
		histRecTypeDesc = rs.getString("hist_rec_type_desc") == null ? "" : rs.getString("hist_rec_type_desc");
		eventClass = rs.getString("eve_class") == null ? "" : rs.getString("eve_class");
		eventClassDesc = rs.getString("event_class_desc") == null ? "" : rs.getString("event_class_desc");
		eventGroup = rs.getString("event_group") == null ? "" : rs.getString("event_group");
		eventGroupDesc = rs.getString("event_group_desc") == null ? "" : rs.getString("event_group_desc");
		eventCode = rs.getString("eve_code") == null ? "" : rs.getString("eve_code");
		eventDesc = rs.getString("event_desc") == null ? "" : rs.getString("event_desc");
		accessionNum = rs.getString("acc_num") == null ? "" : rs.getString("acc_num");
 		sysID = rs.getString("sys_id") == null ? "" : rs.getString("sys_id");
		sysEventCode = rs.getString("sys_eve_code") == null ? "" : rs.getString("sys_eve_code");
		histDataType = rs.getString("hist_data_type") == null ? "" : rs.getString("hist_data_type");
		resultNum = rs.getString("RESULT_NUM") == null ? "" : rs.getString("RESULT_NUM");
		resultNum = resultNum.trim();
		resultNumUOM = rs.getString("uom") == null ? "" : rs.getString("uom");
		resultStr = rs.getString("res_str") == null ? "" : rs.getString("res_str");
		normIndicator = rs.getString("norm_ind") == null ? "" : rs.getString("norm_ind");
		normalLow = rs.getString("normal_low") == null ? "" : rs.getString("normal_low");
		normalHigh = rs.getString("normal_high") == null ? "" : rs.getString("normal_high");
		criticalLow = rs.getString("critical_low") == null ?  "" : rs.getString("critical_low");
		criticalHigh = rs.getString("critical_high") == null ? "" : rs.getString("critical_high");
		extImgID = rs.getString("ext_img_id") == null ? "" : rs.getString("ext_img_id");
		extApplID = rs.getString("ext_appl_id") == null ? "" : rs.getString("ext_appl_id");
		toolTip = rs.getString("GetTooltip") == null ? "" : rs.getString("GetTooltip");
		splEventDesc = rs.getString("sp_event_desc") == null ? "" : rs.getString("sp_event_desc");
		quickTextCount = rs.getString("QUICK_TEXT_COUNT") == null ? "" : rs.getString("QUICK_TEXT_COUNT");
		deltaFailInd = rs.getString("delta_fail_ind") == null ? "" : rs.getString("delta_fail_ind");
		colorCellInd = rs.getString("COLOR_CELL_IND") == null ? "" : rs.getString("COLOR_CELL_IND");
		strStatus = rs.getString("stat") == null ? "" : rs.getString("stat");
		textCount = rs.getString("text_count") == null ? "" : rs.getString("text_count");

		if(dateList.contains(eventDateTime))
		{
			tempSessionMap.put("eventDateTime"+tempCnt,eventDateTime);
			tempSessionMap.put("dummyDate"+tempCnt,dummyDate);
			tempSessionMap.put("histRecType"+tempCnt,histRecType);
			tempSessionMap.put("histRecTypeDesc"+tempCnt,histRecTypeDesc);
			tempSessionMap.put("eventClass"+tempCnt,eventClass);
			tempSessionMap.put("eventClassDesc"+tempCnt,eventClassDesc);
			tempSessionMap.put("eventGroup"+tempCnt,eventGroup);
			tempSessionMap.put("eventGroupDesc"+tempCnt,eventGroupDesc);
			tempSessionMap.put("eventCode"+tempCnt,eventCode);
			tempSessionMap.put("eventDesc"+tempCnt,eventDesc);
			tempSessionMap.put("accessionNum"+tempCnt,accessionNum);
			tempSessionMap.put("sysID"+tempCnt,sysID);
			tempSessionMap.put("sysEventCode"+tempCnt,sysEventCode);
			tempSessionMap.put("histDataType"+tempCnt,histDataType);
			tempSessionMap.put("resultNum"+tempCnt,resultNum);
			tempSessionMap.put("resultNumUOM"+tempCnt,resultNumUOM);
			tempSessionMap.put("resultStr"+tempCnt,resultStr);
			tempSessionMap.put("normIndicator"+tempCnt,normIndicator);
			tempSessionMap.put("normalLow"+tempCnt,normalLow);
			tempSessionMap.put("normalHigh"+tempCnt,normalHigh);
			tempSessionMap.put("criticalLow"+tempCnt,criticalLow);
			tempSessionMap.put("criticalHigh"+tempCnt,criticalHigh);
			tempSessionMap.put("extImgID"+tempCnt,extImgID);
			tempSessionMap.put("extApplID"+tempCnt,extApplID);
			tempSessionMap.put("toolTip"+tempCnt,toolTip);
			tempSessionMap.put("splEventDesc"+tempCnt,splEventDesc);
			tempSessionMap.put("quickTextCount"+tempCnt,quickTextCount);
			tempSessionMap.put("deltaFailInd"+tempCnt,deltaFailInd);
			tempSessionMap.put("colorCellInd"+tempCnt,colorCellInd);
			tempSessionMap.put("strStatus"+tempCnt,strStatus);	
			tempSessionMap.put("textCount"+tempCnt,textCount);	
			tempCnt++;
		}
		//counter++;
	}//end of while

	int k=0;
	int numOfCols = 0;
	int tempK = 0;	
	String tempEventDate = "";
	//String resultValue = "";
	String tempReturnString = "";
	String tempHistRecType = "";
	String tempEventClass = "";
	String tempEventGroup = "";
	String tempEventCode = "";
	//String tempRowNumber = "";
	String tempDisplayEventCode = "";
	String tempDisplayEventClass = "";
	String tempDisplayEventGroup = "";
	String tempDisplayHistRecType = "";
	String tempResultNum = "";
	String tempEventDateTimeForGraf = "";
	StringBuffer dataBuffer = new StringBuffer();
	
	for(k=0;k<tempCnt;k++)
	{
		tempEventDate = (String) tempSessionMap.get("eventDateTime"+k);
		histRecTypeDesc = (String)tempSessionMap.get("histRecTypeDesc"+k);
		eventClassDesc = (String)tempSessionMap.get("eventClassDesc"+k);
		eventGroupDesc = (String)tempSessionMap.get("eventGroupDesc"+k);
		eventCode = (String)tempSessionMap.get("eventCode"+k);
//		out.println("eventCode ="+eventCode+"=");
		histRecType = (String)tempSessionMap.get("histRecType"+k);
		eventClass = (String)tempSessionMap.get("eventClass"+k);
		eventGroup = (String)tempSessionMap.get("eventGroup"+k);
		histDataType = (String)tempSessionMap.get("histDataType"+k);
		resultNumUOM = (String)tempSessionMap.get("resultNumUOM"+k);
		dummyDate = (String)tempSessionMap.get("dummyDate"+k);
		eventDateTime = (String)tempSessionMap.get("eventDateTime"+k);
		accessionNum = (String)tempSessionMap.get("accessionNum"+k);
		sysID = (String)tempSessionMap.get("sysID"+k);
		sysEventCode = (String)tempSessionMap.get("sysEventCode"+k);
		resultNum = (String)tempSessionMap.get("resultNum"+k);
		resultStr = (String)tempSessionMap.get("resultStr"+k);
		normIndicator = (String)tempSessionMap.get("normIndicator"+k);
		extImgID = (String)tempSessionMap.get("extImgID"+k);
		extApplID = (String)tempSessionMap.get("extApplID"+k);
		toolTip = (String)tempSessionMap.get("toolTip"+k);
		quickTextCount = (String)tempSessionMap.get("quickTextCount"+k);
		deltaFailInd = (String)tempSessionMap.get("deltaFailInd"+k);
		colorCellInd = (String)tempSessionMap.get("colorCellInd"+k);
		textCount = (String)tempSessionMap.get("textCount"+k);

		int tempNumOfCols = 0;	
		String tempDispString = "";

		if(tempEventDate.equals((String)dateList.get(numOfCols)))
		{
			tempNumOfCols = numOfCols;
		}
		else if(tempEventDate.equals((String)dateList.get(numOfCols+1)))
		{
			tempNumOfCols = numOfCols+1;
		}
		else if(tempEventDate.equals((String)dateList.get(numOfCols+2)))
		{
			tempNumOfCols = numOfCols+2;
		}
		else if(tempEventDate.equals((String)dateList.get(numOfCols+3)))
		{
			tempNumOfCols = numOfCols+3;
		}
		else if(tempEventDate.equals((String)dateList.get(numOfCols+4)))
		{
			tempNumOfCols = numOfCols+4;
		}
		else if(tempEventDate.equals((String)dateList.get(numOfCols+5)))
		{
			tempNumOfCols = numOfCols+5;
		}
		else if(tempEventDate.equals((String)dateList.get(numOfCols+6)))
		{
			tempNumOfCols = numOfCols+6;
		}
		else if(tempEventDate.equals((String)dateList.get(numOfCols+7)))
		{
			tempNumOfCols = numOfCols+7;
		}
		else if(tempEventDate.equals((String)dateList.get(numOfCols+8)))
		{
			tempNumOfCols = numOfCols+8;
		}
		else if(tempEventDate.equals((String)dateList.get(numOfCols+9)))
		{
			tempNumOfCols = numOfCols+9;
		}

		tempAdditional = resultStr;

		if(histDataType.equals("NUM")) tempValue = resultNum;
		else if(histDataType.equals("STR")) tempValue = resultStr;
		else if(histDataType.equals("TXT") || histDataType.equals("IMG") || histDataType.equals("HTM")) 
		tempValue = "";

		//tempReturnString = drawTD(histDataType, resultNum,resultStr, extApplID, numOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd,colorCellInd,normIndicator,eventGroup,eventClass,eventCode);

		if(k == 0)
		{
			prevK = k;
		}
		else
		{
			if(tempDisplayEventCode.equals(eventCode))
			{
				prevK = prevK;
			}
			else
			{
				prevK = prevK +1;
			}
		}

		tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd,colorCellInd,normIndicator,eventGroup,eventClass,eventCode,tempDisplayEventCode,tempDisplayEventClass,tempDisplayEventGroup,tempDisplayHistRecType,prevK);

		tempDisplayEventCode = eventCode;
		tempDisplayEventClass = eventClass;
		tempDisplayEventGroup = eventGroup;
		tempDisplayHistRecType = histRecType;

		tempK = prevK;

		tempReturnString = (String) tempTRMap.get("tempString"+tempK+"Map"+tempNumOfCols);
		tempHistRecType = (String) tempTRMap.get("histRecType"+tempK);
		tempEventClass = (String) tempTRMap.get("eventClass"+tempK);
		tempEventGroup = (String) tempTRMap.get("eventGroup"+tempK);
		tempEventCode = (String) tempTRMap.get("eventCode"+tempK);
		tempResultNum = (String) tempTRMap.get("resultNum"+tempK+"Map"+tempNumOfCols);
		tempEventDateTimeForGraf = (String) tempTRMap.get("eventDateTime"+tempK+"Map"+tempNumOfCols);
		tempDispString = "map"+tempK+"Key"+tempNumOfCols;
		
		tempTDMap.put(tempDispString,tempReturnString);
		tempTDMap.put("histRecType"+tempK,tempHistRecType);
		tempTDMap.put("eventClass"+tempK,tempEventClass);
		tempTDMap.put("eventGroup"+tempK,tempEventGroup);
		tempTDMap.put("eventCode"+tempK,tempEventCode);
		tempTDMap.put("tempResultNum"+tempDispString,tempResultNum);
		tempTDMap.put("tempEventDateTimeForGraf"+tempDispString,tempEventDateTimeForGraf);
		//dataBuffer.append(tempReturnString);
		//k++;
	}//end of for
	

	int m=0;
	int n=0;
	String tempRetString = "";
	String tempResNumberForGraf = "";
	String tempDateTimeForGraf = "";
	
	String displayStr = "";
	//String valuesForHiddenVars = "";
	dataBuffer = new StringBuffer();
	StringBuffer tempRowString = new StringBuffer();

	for(m=0;m<=prevK;m++)
	{
		if(m % 2 ==0)
			classValue = "CACHARTQRYEVEN";
		else
			classValue = "CACHARTQRYEVEN";

		tempRowString.setLength(0);

		tempHistRecType = (String) tempTDMap.get("histRecType"+m) == null ? "&nbsp;" : (String) tempTDMap.get("histRecType"+m);
		tempEventClass = (String) tempTDMap.get("eventClass"+m) == null ? "&nbsp;" : (String) tempTDMap.get("eventClass"+m);
		tempEventGroup = (String) tempTDMap.get("eventGroup"+m) == null ? "&nbsp;" : (String) tempTDMap.get("eventGroup"+m);
		tempEventCode = (String) tempTDMap.get("eventCode"+m) == null ? "&nbsp;" : (String) tempTDMap.get("eventCode"+m);
/*		tempResultNum = (String) tempTDMap.get("tempResultNum"+m) == null ? "&nbsp;" : (String) tempTDMap.get("tempResultNum"+m);
		tempEventDateTime = (String) tempTDMap.get("tempEventDateTime"+m) == null ? "&nbsp;" : (String) tempTDMap.get("tempEventDateTime"+m);*/


		if(!prevHistRecType.equals(tempHistRecType))
		{	
			tempRowString.append("<TR>");
			for(int z=0;z<dateList.size();z++)
			{
			tempRowString.append("<TD colspan='"+z+"'  id='sepID"+m+"' class='CAFLOWSHEETLEVEL1' align='center'><a href='javascript:callLinkresult(\""+tempHistRecType+"\",\""+strPatientId+"\",\""+strmodule_id+"\",\""+strcycle_no+"\",\""+strEncounterId+"\",\""+strFromDate+"\",\""+strToDate+"\",\""+strEpisodeType+"\",\""+dateList.get(z)+"\")'><B>+</B></a></TD>");
			}
			tempRowString.append("</TR>");
			tempRowString.append("<TR>");
			tempRowString.append("<TD colspan='"+dateList.size()+"' id='sepID"+m+"' class='CAFLOWSHEETLEVEL2'>&nbsp;</TD>");
			tempRowString.append("</TR>");
			if(!tempEventGroup.equals("*ALL"))	
			{
				tempRowString.append("<TR>");
				tempRowString.append("<TD colspan='"+dateList.size()+"' id='sepID"+m+"' class='CAFLOWSHEETLEVEL3'>&nbsp;</TD>");
				tempRowString.append("</TR>");
			}
			prevHistRecType = tempHistRecType;
			prevEventClass = tempEventClass;
			prevEventGroup = tempEventGroup;
			prevEventCode = tempEventCode;
			dataBuffer.append(tempRowString.toString());
		}
		if(!prevEventClass.equals(tempEventClass))
		{
			tempRowString.append("<TR>");
			tempRowString.append("<TD id='sepID"+m+"' colspan='"+dateList.size()+"' class='CAFLOWSHEETLEVEL2'>&nbsp;</TD>");
			tempRowString.append("</TR>");

			if(!tempEventGroup.equals("*ALL"))//event group is empty
			{
				tempRowString.append("<TR>");
				tempRowString.append("<TD colspan='"+dateList.size()+"' id='sepID"+m+"' class='CAFLOWSHEETLEVEL3'>&nbsp;</TD>");
				tempRowString.append("</TR>");
			}
			prevEventClass = tempEventClass;
			prevEventGroup = tempEventGroup;
			prevEventCode = tempEventCode;
			dataBuffer.append(tempRowString.toString());
		}
		

		if(!prevEventGroup.equals(tempEventGroup))
		{
			if(!tempEventGroup.equals("*ALL"))
			{
				tempRowString.append("<TR>");
				tempRowString.append("<TD colspan='"+dateList.size()+"' id='sepID"+m+"' class='CAFLOWSHEETLEVEL3'>&nbsp;</TD>");
				tempRowString.append("</TR>");
			}
			prevEventGroup = tempEventGroup;
			prevEventCode = tempEventCode;
			dataBuffer.append(tempRowString.toString());
		}
		dataBuffer.append("<tr id='trIDGraph"+m+"'>");

		for(n=0;n<dateList.size();n++)
		{
			displayStr = "map"+m+"Key"+n;
			tempRetString = (String) tempTDMap.get(displayStr);
			tempResNumberForGraf = (String) tempTDMap.get("tempResultNum"+displayStr);
			tempDateTimeForGraf = (String) tempTDMap.get("tempEventDateTimeForGraf"+displayStr);


			if(tempResNumberForGraf == null && tempDateTimeForGraf == null)
			{
				tempResNumberForGraf = " ";
				tempDateTimeForGraf = " ";
			}

			if(tempRetString == null)
			{
				dataBuffer.append("<td id='visibility"+m+"ID"+n+"' class = '"+classValue+"'>&nbsp;</td>");
			}
			else
			{
				dataBuffer.append(tempRetString);
			}
			dataBuffer.append("<td id='duplicate"+m+"ID"+n+"' style='display:none' width='10%'>&nbsp;</td><input type='hidden' name='hidden"+m+"Values"+n+"' id='hidden"+m+"Values"+n+"' value='"+tempDateTimeForGraf+"~"+tempResNumberForGraf+"'>");
		}
		dataBuffer.append("</tr>");
	}//end of for-display

	out.println(dataBuffer.toString());

}//end of try - 2
catch(Exception ee)
{
	//out.println("Exception in try - 2 of FlowSheetEventsData.jsp -"+ee.toString());//COMMON-ICN-0181
	ee.printStackTrace();
}



            _bw.write(_wl_block15Bytes, _wl_block15);

					for(i=0;i<dateListSize;i++){
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(dateList.get(i)));
            _bw.write(_wl_block18Bytes, _wl_block18);
}

					
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(prevK+1));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(dateList.size()));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(dateList.size()));
            _bw.write(_wl_block22Bytes, _wl_block22);
					}
catch(Exception ee1)
{
			
			ee1.printStackTrace();

}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block23Bytes, _wl_block23);
            _bw.write(_wl_block24Bytes, _wl_block24);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NewDocument.label", java.lang.String .class,"key"));
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
