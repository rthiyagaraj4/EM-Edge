package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import eCA.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __encsummconfiggroupaddedlist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/EncSummConfigGroupAddedList.jsp", 1709115842216L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../js/EncSummConfig.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body   class=\'CONTENT\' OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" OnScroll=\"scrollTitle()\" >\n\t <form name=\"GroupAddedfrm\" id=\"GroupAddedfrm\" method=\"post\"  action =\'EncSummConfigGroupAddedList.jsp\'>\n\t <div id=\'divDataTitle\' style=\'postion:relative\'>\n\t <table border=\'1\' width=\'100%\' id=\'dataTitleTable\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\'>\t\n\t\t<tr><td class=\'columnHeadercenter\' colspan=\'3\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td></tr>\n\t\t<tr>\n\t\t\t<td class=\'columnHeadercenter\' width=\'50%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t<td class=\'columnHeadercenter\'width=\'15%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t<td class=\'columnHeadercenter\' width=\'15%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t</tr>\t\n\t</table>\n\t </div>\n\t<table class=\'grid\' align=\'center\' border=\"1\" width=\"100%\" id=\'dataTable\' >\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<tr  id=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t\t\t\t \t<td width=\'50%\' class=\'gridData\'  >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td><!-- Displays the Description -->\n\t\t\t\t\t\t<td width=\'15%\' align=\"center\" class=\'gridData\'>\n\t\t\t\t\t\t\t<input type=\"text\" name=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" id=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" size=\"6\" maxlength=\"6\" onKeyPress=\'return allowValidNumber(this,event,6,0);\' \n\t\t\t\t\t\t\t\tOnBlur=\"checkSequence(this)\"><!--Text Field to display the Sequence Number -->\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=\'15%\' align=\"center\" class=\'gridData\'>\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"select_yn";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" id=\"select_yn";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" value=\'Y\' ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" OnClick =\"removeRow(";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =")\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\t\n\t\t\t\t\t<input type =\'hidden\' name=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' id=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\t<!-- Hidden Variable for Storing Code for the Corresponding Description -->\n\t\t\t\t\t<input type =\'hidden\' name=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t<tr id =\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t\t\t\t\t<td width=\'50%\' class=\'gridData\'  >";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td><!-- Displays the Description -->\n\t\t\t\t\t\t<td width=\'15%\' align =\"center\" class=\'gridData\'  >\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" size=\"6\" maxlength=\"6\" onKeyPress=\"return allowValidNumber(this,event,6,0)\" \n\t\t\t\t\t\t\t\t\tOnBlur=\"minOccur2(this);checkSequence(this);\"><!--Text Field to display the Sequence Number -->\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=\'15%\'  align =\"center\" class=\'gridData\'  >\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"select_yn";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =")\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\t\t\t\t\t\t\t\n\t\t\t\t\t<input type =\'hidden\' name=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t\t\t\t<input type =\'hidden\' name=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\t\n\t</table>\n\t<input type =\'hidden\' name=\'finalString\' id=\'finalString\' value=\'\'>     <!-- has the ConCatenated String to be Posted to Servlet File and also used for Posting ConCatenated String between JSP\'s -->\n\t<input type =\'hidden\' name=\'summaryCode\' id=\'summaryCode\' value=\'\'>  <!-- Section Code  Value of the Main Section  -->\n\t<input type =\'hidden\' name=\'array_length\' id=\'array_length\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'> <!-- has the value of  number of Dynamic Created Text Boxes -->\n\t<input type =\'hidden\' name=\'remove_value\' id=\'remove_value\' value=\'\'> <!-- Has the Code Value to remove Entry from the Selected List -->\n\t<input type =\'hidden\' name=\'operation\' id=\'operation\' value=\'\'> <!-- a flag  value used for performing default and posted Value  -->\n\t<input type =\'hidden\' name=\'add_value\' id=\'add_value\' value=\'\'><!-- Has the Code Value to adding Entry into the Selected List -->\n\t<input type =\'hidden\' name=\'select_value\' id=\'select_value\' value=\'\'> \n</form>\n</body>\n</html>\n\n\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

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

/* 
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
20/09/2013     		1   		Sethuraman      Created
-------------------------------------------------------------------------------------------------------------------------------------
*/

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
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
			
	String summaryCode = request.getParameter("summaryCode") == null ? "" : request.getParameter("summaryCode");		
	String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
	String operation = request.getParameter("operation") == null ? "" : request.getParameter("operation");
	

	List<EncSummConfigGroupBean> oSummGroupList = null;
	EncSummConfigGroupBean sConfigGroupBean = null;
	
	EncSummGroup summGrpDetails = new EncSummGroup();	
	
	int nGroupListSize = 0;
	String remove_value = "",add_value = "";
	String finalString = "",val = "", val1= "", val2= "",val3= "", val4="";	
	StringTokenizer tokenizeTilde = null;
	StringTokenizer tokenizePipe = null;
	String classValue="";

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
	
	int index = 0;
	String text_name="", tblrow_id="", tdrow_id="";
	String chkSelBox = "";
	String group_code = "", group_desc = "", group_type = "", hiddenGroupCode = "", hiddenGroupType = "";	
	int seqNo = 0;
	try
		{	
			if (!operation.equals("addRows"))
			{					
				oSummGroupList = new ArrayList<EncSummConfigGroupBean>();
				sConfigGroupBean = new EncSummConfigGroupBean();
				
				sConfigGroupBean.setRequest(request);			
				sConfigGroupBean.setsSummaryCode(summaryCode);
				
				oSummGroupList = summGrpDetails.getSummaryConfigAddedGroups(sConfigGroupBean);		
				
				sConfigGroupBean = new EncSummConfigGroupBean();
				
				nGroupListSize = oSummGroupList.size();	
				
				for (int i=0;i<nGroupListSize;i++){
					index++;
					sConfigGroupBean = oSummGroupList.get(i);
					group_code = sConfigGroupBean.getsGroupCode();
					group_type = sConfigGroupBean.getsGroupType();
					group_desc = sConfigGroupBean.getsGroupDesc();	
					seqNo = sConfigGroupBean.getiSequence();
					
					text_name= "seq_num"+ index;
					tdrow_id = "tdrow_id"  + index;
					hiddenGroupCode = "GroupCode"+index;
					hiddenGroupType = "GroupType"+index;
					
					
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(tdrow_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(group_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(text_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(text_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(seqNo));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(index));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(index));
            _bw.write(_wl_block20Bytes, _wl_block20);
out.println("checked");
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(index));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(hiddenGroupCode));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(hiddenGroupCode));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(group_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(hiddenGroupType));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(hiddenGroupType));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(group_type));
            _bw.write(_wl_block26Bytes, _wl_block26);
								
				}	
			}
			else
			{
				out.println("<script>parent.parent.HeaderFrame.document.HeaderForm.finalString.value=''</script>");
				finalString = request.getParameter("finalString");
				remove_value = request.getParameter("remove_value");
				add_value =  request.getParameter("add_value");
				
				if(summaryCode==null ||summaryCode.equals("")) summaryCode="";				
				if(remove_value==null ||remove_value.equals("")) remove_value="";				
				if(add_value==null ||add_value.equals("")) add_value="";
				
				if(finalString==null || finalString.equals(""))
				{
					finalString = "";
				}
				tokenizeTilde = new StringTokenizer(finalString,"~");
				index=0;
				while(tokenizeTilde.hasMoreTokens())
				{
					index++;
					classValue = ((index%2)==0 )? "QRYEVEN" : "QRYODD";
					val = tokenizeTilde.nextToken();
					tokenizePipe =  new StringTokenizer(val,"||");
					val1 =java.net.URLDecoder.decode(tokenizePipe.nextToken());
					val2 = tokenizePipe.nextToken();
					val3 = tokenizePipe.nextToken();
					val4 = tokenizePipe.nextToken();
					if(val2.equalsIgnoreCase("null"))
					{
						val2="";
					}
					text_name= "seq_num"+ index;
					tdrow_id = "tdrow_id"  + index;
					hiddenGroupCode = "GroupCode"+index;
					hiddenGroupType = "GroupType"+index;
					
					
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(tdrow_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(val1));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(text_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(text_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(val2));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(index));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(index));
            _bw.write(_wl_block20Bytes, _wl_block20);
out.println("checked");
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(index));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(hiddenGroupCode));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(hiddenGroupCode));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(val3));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(hiddenGroupType));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(hiddenGroupType));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(val4));
            _bw.write(_wl_block33Bytes, _wl_block33);
	
				}
					
			}
		}
		catch(Exception e)
		{
			//out.println("Exception in try of EncSummConfigGroupAddedList.jsp"+e.toString());//common-icn-0181
			e.printStackTrace();
		}
	
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(index));
            _bw.write(_wl_block35Bytes, _wl_block35);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SelectedGroups.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.groupdesc.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.OrderSequenceNumber.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
