package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __chartrecordinglist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartRecordingList.jsp", 1743758410973L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t<html>\n\t<head>\n\t\t<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCA/html/IeStyle.css\"></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<script>\n\t\t\t//displayListForAE();\t\n\t\t</script>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\' />\n\n\n\t\t<script language=\"javascript\" src=\"../../eCA/js/ChartRecording.js\"></script>\n\t\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<style>\n\t\tA:link\n\t\t{\n\t\t\tCOLOR: yellow\n\t\t}\n\t\tA:visited\n\t\t{\n\t\t\tCOLOR: yellow\n\t\t}\n/*TH {\n  FONT-FAMILY: VERDANA ;\n  FONT-SIZE: 7PT ;\n  COLOR:WHITE;\n  BACKGROUND-COLOR: #808080;\n\n}\nTD.QRYEVEN {\n\tFONT-SIZE: 9PT ;\n    BACKGROUND-COLOR: #F0F0F2;  \n\tBORDER-STYLE: THIN;\n\tBORDER-LEFT-COLOR: #E2E3F0;\n\tBORDER-RIGHT-COLOR: white;\n\tBORDER-TOP-COLOR: #E2E3F0;\n\tBORDER-BOTTOM-COLOR: white;\n}\n\nTD.QRYODD {\n    BACKGROUND-COLOR:#F0F0F2;  \n\tFONT-SIZE: 9PT ;\n\tBORDER-STYLE: THIN;\n\tBORDER-COLOR:\t#E2E3F0;\n\tBORDER-LEFT-COLOR: #E2E3F0;\n\tBORDER-RIGHT-COLOR: white;\n\tBORDER-TOP-COLOR: #E2E3F0;\n\tBORDER-BOTTOM-COLOR: white;\n\n}*/\n/*TD.QRYODD{\n\tBACKGROUND-COLOR: #F0F0F2;  \n\tFONT-SIZE: 7pt ;\n\tBORDER-STYLE: THIN;\n\tborder-left-color: #B2B6D7;\n\tborder-right-color: #B2B6D7;\n\tborder-top-color: #E2E3F0;\n\tborder-bottom-color: #E2E3F0;\n\n\n    }\n\nTD.QRYEVEN{\n    FONT-SIZE: 7pt ;\n    BACKGROUND-COLOR: #c3dfa8;  \n\tBORDER-STYLE: THIN;\n\tborder-left-color: #E2E3F0;\n\tborder-right-color: white;\n\tborder-top-color: #E2E3F0;\n\tborder-bottom-color: white;*/\n\t/*height: 25px;*/\n\t/*height: 26;*/\n\n\t\n     /*}*/\n/*TD.CAFOURTHLEVELCOLOR \n{\n\tBACKGROUND-COLOR: #637BBD ;\n\tCOLOR:WHITE;\n\tBORDER-STYLE: SOLID;\n\tBORDER-COLOR:\tWHITE;\n    BORDER-RIGHT-COLOR: #637BBD;\n\tBORDER-TOP-COLOR: WHITE;\n\tBORDER-BOTTOM-COLOR: #637BBD;\n\tFONT-WEIGHT: BOLD ;\n\n}\nTD.CASUMMARY  \n{\n   \tBACKGROUND-COLOR: #ADD8E6;\n   \tFONT-SIZE: 7pt ;\n\tCOLOR: BLACK;\n\tBORDER-STYLE: SOLID;\n\tBORDER-COLOR:\tWHITE;\n\tBORDER-LEFT-COLOR: WHITE;\n\tBORDER-RIGHT-COLOR: #ADD8E6;\n\tBORDER-TOP-COLOR: WHITE;\n\tBORDER-BOTTOM-COLOR: #ADD8E6;\n\n}*/\n\nTD.CACHARTQRYEVEN {\n\tFONT-SIZE: 7PT ;\n    BORDER-STYLE: THIN;\n}\n\nTD.CACHARTFOURTHLEVELCOLOR \n{\n\theight: 12;\n}\n\nTD.CRITICAL{\n\tFONT-SIZE: 7PT ;\n\tBORDER-STYLE: THIN;\n\tbackground-color:#D2B48C;\n\n}\nTD.ABNORMAL{\n\tFONT-SIZE: 7PT ;\n\tBORDER-STYLE: THIN;\n\tbackground-color:#FFF8DC;\n}\nTD.HIGH{\n\tFONT-SIZE: 7PT ;\n\tBORDER-STYLE: THIN;\n\tbackground-color:#FFDAB9\n}\nTD.LOW{\n\tFONT-SIZE: 7PT ;\n\tBORDER-STYLE: THIN;\n\tbackground-color:#F0FFFF;\n}\nTD.CRITICALLOW{\n\tFONT-SIZE: 7PT ;\n\tBORDER-STYLE: THIN;\n\tbackground-color:#D8BFD8;\n}\nTD.CRITICALHIGH{\n\tFONT-SIZE: 7PT ;\n\tBORDER-STYLE: THIN;\n\tbackground-color:#F4A460;\n}\nTD.DELTAFAIL{\n\tFONT-SIZE: 7PT ;\n\tBORDER-STYLE: THIN;\n\tbackground-color:#FFE4E1;\n}\n</style>\n\t</head>\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onScroll=\'scrollListFrame()\'>\n\t<script language=javascript>\n\tdocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarArrowColor=\'#000080\';\n\tdocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarHighlightColor=\'white\';\n\tdocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t<form name =\"ChartLayoutListForm\">\n\n\t\t<table cellspacing=0 cellpadding=3 border=1 id=\'titleTable\' width=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t\t<tr id=\'divTitleTable\'>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<script>\n\t\t\tvar rowValue = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"\n\t\t\t\tvar thRowId = document.getElementById(\'rowId\'+rowValue)\n\t\t\tthRowId.colSpan += 1\n\t\t\t\t\t//alert(\"thRowId.colSpan = \"+thRowId.colSpan);\n\t\t\t\t\t//alert(\"thRowId.colSpan = \"+thRowId.colSpan);\n\t\t\t\n\t\t</script>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t</tr>\n\n\t\t<INPUT TYPE=\"hidden\" name=\"idCount\" id=\"idCount\" value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t<INPUT TYPE=\"hidden\" name=\"summaryYN\" id=\"summaryYN\" value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t<INPUT TYPE=\"hidden\" name=\"detailYN\" id=\"detailYN\" value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t<INPUT TYPE=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t\t<INPUT TYPE=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t<INPUT TYPE=\"hidden\" name=\"defaultYN\" id=\"defaultYN\" value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t<INPUT TYPE=\"hidden\" name=\"patientId\" id=\"patientId\" value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n<!-- \t\t</table>\n -->\t\t\n\n<!-- \t\t<table border=\'1\' width=\'100%\' id=\'tb1\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' style=\"border-bottom:#ffffff\">\n -->\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\n\t\t</table>\n\t\n\t\t</form>\n\t</body>\n\t<script>\n\tif(parent.ChartRecordingDetailFrame != null)\n\t{\n\t\tparent.ChartRecordingDetailFrame.document.body.scroll=\"no\";\n\t\tparent.ChartRecordingDetailFrame.document.body.onscroll= \"\";\n\t}\n\t</script>\n\t<script>//showButton();</script>\n \t<script>alignHeight();</script> \n\t<script>alignUnitsAndData();</script>\n\t\n\t</html>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

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

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	try{
		String encounterId = request.getParameter("encounterId")==null?"":request.getParameter("encounterId");
		
		if(encounterId.equals("")) encounterId = "0";

		String facility_id = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
		String defaultYN = request.getParameter("defaultYN")==null?"":request.getParameter("defaultYN");
		HashMap finalHash = (HashMap)session.getValue("finalHash"+encounterId);
		ArrayList dates = (ArrayList)session.getValue("dates"+encounterId);
		HashMap hashData = (HashMap)session.getValue("chartEvents"+encounterId);
		ArrayList arrayChartGrp = (ArrayList)session.getValue("chartGrp"+encounterId);
		ArrayList arrayResultType = (ArrayList)session.getValue("resultType"+encounterId);
		String summaryYN = request.getParameter("summaryYN")==null?"":request.getParameter("summaryYN");
		String detailYN = request.getParameter("detailYN")==null?"":request.getParameter("detailYN");
		String errorAuth = request.getParameter("errorAuth")==null?"":request.getParameter("errorAuth");
		String function_from = request.getParameter("function_from")==null?"":request.getParameter("function_from");
		String patientId = request.getParameter("patientId")==null?"":request.getParameter("patientId");


            _bw.write(_wl_block1Bytes, _wl_block1);
if(dates.size()>0)
{
            _bw.write(_wl_block5Bytes, _wl_block5);

		if(function_from.equals("SECONDARY_TRIAGE"))
		{
	
            _bw.write(_wl_block6Bytes, _wl_block6);

		}
	
            _bw.write(_wl_block7Bytes, _wl_block7);


			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			
			int tabWidth = 0;
			int widPc = 0;
			if(dates.size() <= 5)
			{
				tabWidth = dates.size() * 100;//only for GUI purpose...no specific reason to set it to 100...
			}
			else
			{
				tabWidth = dates.size() * 80;
			}
			widPc = tabWidth/dates.size();
		//out.println("widPc"+widPc);
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(tabWidth));
            _bw.write(_wl_block10Bytes, _wl_block10);

				StringTokenizer tokenizeSpace = null;
				String dt = "";
				String currDate="";
				String prevDate = "";
				String firstToken = "";
				String dummyDateString = "";
				StringTokenizer tokenizeColon = null;	
				int ii=0;
				int index=0;
				boolean flag = true;;
				int actualIndex = 0;
				//int wid =100;
				//int widPc = wid/dates.size();
				//int widPc = 100;
				if(dates!=null)
				{
					for(ii=0;ii<dates.size();ii++)
					{
						dt = (String)dates.get(ii);
						tokenizeSpace = new StringTokenizer(dt," ");
						currDate = tokenizeSpace.nextToken();
						if(!currDate.equals(prevDate)){
							
							out.println("<td class='columnHeader' width='"+widPc+"px' id='rowId"+index+"'>"+currDate+"</td>");
							prevDate =currDate;
							actualIndex = index;
							index++;
						}
						else
						{
							
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(actualIndex));
            _bw.write(_wl_block12Bytes, _wl_block12);
				}
					}
					out.println("<input type='hidden' name='noOfHrRows' id='noOfHrRows' value='"+index+"'>");
				}
				String dummyString="";
				String currDate1="";
				String anchorObj = "";
				String anchorObjEnd = "";
				//int wid =100;
				//int widPc = wid/dates.size();
				//out.println("<script>alert('"+widPc+"');</script>");
				//int widPc = Integer.parseInt(width);
			out.println("</tr>");
			out.println("<tr id='divTitleTable1'>");
				if(dates!=null)
				{
					//out.println("<script>alert('"+dates.size()+"');</script>");
					for( ii=0;ii<dates.size();ii++)
					{
						dt = (String)dates.get(ii);
						dummyString=(String)arrayResultType.get(ii);
						//out.println("dummyString = "+dummyString);
						tokenizeSpace = new StringTokenizer(dt," ");
						currDate1 = tokenizeSpace.nextToken();
						currDate = tokenizeSpace.nextToken();
						if(!currDate.equals(prevDate)){
							dummyDateString = currDate1;
							currDate1= currDate1.replace('/','_');
							if(dummyString.equals("S"))currDate="Day Summary";
							if(currDate.equals("Day Summary"))
							{
								anchorObj = "";
								anchorObjEnd = "";								
							}
							else if(!currDate.equals("Day Summary") && errorAuth.equals("A"))
							{
								anchorObj = "<a href='javascript:callAmend(\""+dt+"\")'  title = 'Click here for Amend/Mark as error' >";
								anchorObjEnd = "</a>";
							}
							else
							{
								anchorObj = "";
								anchorObjEnd = "";							
							}
							out.println("<td class='columnHeader'  nowrap width='"+120+"px' id='thId"+currDate1+ii+"'> "+anchorObj+" "+currDate+" "+anchorObjEnd+" </td>");
							prevDate =currDate;							
						}
						else
						{
							if(dummyString.equals("S"))currDate="DAY/SUM";
							out.println("<td class='columnHeader'  width='"+widPc+"px' id='thId"+currDate1+ii+"'>"+currDate+"</td>");
						}
					}
				}
			
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(ii));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(summaryYN));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(detailYN));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(defaultYN));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block20Bytes, _wl_block20);

				ArrayList cols = new ArrayList();
				ArrayList discrArray = new ArrayList();
				HashMap setOfValues = new HashMap();
				String printVal = "";
				String classValue ="CACHARTQRYEVEN";
				StringBuffer tempStringBuffer = null;
				String result_type = "";
				String discrMsrId = "";
				String tempString = "";
				String tempString1 = "";
				int indexJ = 0;
				String normalStr="",normalRangeColor = "",criticalStr = "";
				String currGroupId ="";
				 String eventDate = "";
				 String tooltip = "";
				String currEventDate="";
				int z =0 ;int indexK = 0;int k=0;

				for( indexJ= 0 ; indexJ < arrayChartGrp.size();indexJ++){
						flag = true;
						index = 0;
						currGroupId = (String)arrayChartGrp.get(indexJ)==null ? "" : (String)arrayChartGrp.get(indexJ) ;
						discrArray	= (ArrayList)hashData.get(currGroupId); 
						out.println("<tr>");
						for(k=0;k<dates.size();k++)
						{
							out.println("<td width='"+widPc+"px' class='CACHARTFOURTHLEVELCOLOR' >&nbsp;</td>");
						}
						out.println("</tr>");
						for(indexK =0 ;indexK <discrArray.size();indexK++)
						{
							discrMsrId = (String)discrArray.get(indexK);
							out.println("<tr id='tdrowId"+indexJ+indexK+"'>");

							cols = (ArrayList)finalHash.get(currGroupId+"~"+discrMsrId);
							for(k=0,z=0;k<dates.size();k++)
							{
								if(cols != null){
								if(cols.size() > z)
									{
									setOfValues = (HashMap)cols.get(z);
									 eventDate = (String)dates.get(k);
								 	
									 currEventDate = (String)(setOfValues.get("VALUE_DATE"))==null ? "" : (String)(setOfValues.get("VALUE_DATE"));
									if(currEventDate.equals(eventDate))
									{
										printVal = (String)setOfValues.get("VALUE")== null ? "" :(String)setOfValues.get("VALUE") ;
										//out.println("printVal : " + printVal);
										normalStr = (String)(setOfValues.get("NORMALSTR")==null?"":setOfValues.get("NORMALSTR"));
										normalRangeColor = (String)(setOfValues.get("COLOR")==null?"":setOfValues.get("COLOR"));

										//out.println("normalRangeColor = "+normalRangeColor);
										//out.println("normalStr = "+normalStr);

										criticalStr = (String)(setOfValues.get("CRITICALSTR")==null?"":setOfValues.get("CRITICALSTR"));
										//out.println("criticalStr = "+criticalStr);
										if(!(normalStr.equals("")) || ! (criticalStr.equals("")))
										{

											tokenizeColon = new StringTokenizer(normalStr,":");
											firstToken = tokenizeColon.nextToken();
											firstToken = tokenizeColon.nextToken().trim();
											tokenizeSpace = new StringTokenizer(firstToken,"~");
										/*	if(tokenizeSpace.nextToken().trim().equals("0") && tokenizeSpace.nextToken().trim().equals("0") )
											{
												flag = false;
											}*/

										}
										result_type = (String)(setOfValues.get("RESULT_TYPE")==null?"":setOfValues.get("RESULT_TYPE"));
										if(result_type.equals("L")){
											if(!printVal.equals("")){
												if(printVal.indexOf("||") !=-1){
														tokenizeSpace =  new StringTokenizer(printVal,"||");
														tempString1 = tokenizeSpace.nextToken();

														tempString = tokenizeSpace.nextToken();
														
														if(tempString.length() > 9)
														{
															tempStringBuffer = new StringBuffer(tempString);
															index=0;
															
																tempStringBuffer = tempStringBuffer.replace(index,index+tempString.length()," <label title='"+tempString+"' class='LABELFORDISCRETE'>"+tempString.substring(0,5) +"..."+" </label> ");
																printVal = tempStringBuffer.toString();
																


														}
														 else
														{
															/*
															done by rajan on 17/01/2006
															index =0;
															tempStringBuffer = new StringBuffer(printVal);
															tempStringBuffer = tempStringBuffer.replace(index,index+"||".length(),"  ");
																printVal = tempStringBuffer.toString();*/
															/*if (tempString.equals ("X"))
																printVal="";
															else*/
																printVal=tempString;

														}	
														/*while((index = tempStringBuffer.toString().indexOf("|"))!=-1)
															{
																tempStringBuffer = tempStringBuffer.replace(index,index+"|".length(),"");
																
															}
														while((index = tempStringBuffer.toString().indexOf("X"))!=-1)
															{
																tempStringBuffer = tempStringBuffer.replace(index,index+"X".length(),"");
																
															}
															printVal = tempStringBuffer.toString();
															*/
														
												}

												printVal = tempString1 + " " + printVal;

											}		
										}
										if(flag==true){
											if(!printVal.equals(""))
											{
												if(!normalStr.equals("") || !criticalStr.equals(""))
												tooltip = normalStr+", "+criticalStr;
												else
												tooltip="";
											}
											else
											{
												tooltip="";
											}
										}
										if(!result_type.equals("S")){
										if(!normalRangeColor.equals(""))
										{
											classValue = normalRangeColor;
											//out.println("<script>alert('normalRangeColor :"+normalRangeColor+"')</script>");
										}
										else
										{
												if((indexK%2)==0)
													classValue	=	"CACHARTQRYEVEN";
												else
													classValue	=	"CACHARTQRYEVEN";
											}
										}
										else if(result_type.equals("S"))
										{

											classValue = "CASUMMARY";

										}

										out.println("<td width='"+widPc+"px' class='"+classValue+"' title='"+tooltip+"' >"+printVal+"</td>");
										
										z++;
										printVal="";
									}
									else
									{
										if((indexK%2)==0)
											classValue	=	"CACHARTQRYEVEN";
										else
											classValue	=	"CACHARTQRYEVEN";	
										out.println("<td width='"+widPc+"px' class='"+classValue+"' >&nbsp;</td>");
									}
								}
								else
								{
									if((indexK%2)==0)
											classValue	=	"CACHARTQRYEVEN";
										else
											classValue	=	"CACHARTQRYEVEN";
									out.println("<td width='"+widPc+"px' class='"+classValue+"' >&nbsp;</td>");
								}
							}
							else
							{
										if((indexK%2)==0)
											classValue	=	"CACHARTQRYEVEN";
										else
											classValue	=	"CACHARTQRYEVEN";
								out.println("<td width='"+widPc+"px' class='"+classValue+"' >&nbsp;</td>");
							}
						}
						
						out.println("</tr>");
					}

			}
			
            _bw.write(_wl_block21Bytes, _wl_block21);
}
	//finalHash.clear();
   // dates.clear();
	//hashData.clear();
    //arrayChartGrp.clear();
   // arrayResultType.clear();
	}
catch(Exception ee)
	{
	//out.println("Exception Here :"+ee.toString());//COMMON-ICN-0181
	ee.printStackTrace();
	}
            _bw.write(_wl_block22Bytes, _wl_block22);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
