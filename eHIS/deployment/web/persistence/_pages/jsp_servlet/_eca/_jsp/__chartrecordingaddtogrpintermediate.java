package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __chartrecordingaddtogrpintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartRecordingAddToGrpIntermediate.jsp", 1742378917071L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<html>\n\t<head>\n\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script><script language=\"javascript\" src=\"../../eCA/js/ChartRecording.js\"></script>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script>\n\t\t\tif(\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' == \"true\")\n\t\t\t{\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' != \'RecMat\' && parent.ChartRecordingDetailFrame != null)\n\t\t\t\t\tparent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.grpDetails.value = \'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\';\n\t\t\t}\n\t\t\t\n\t\t\t/*if(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' == \"true\" && parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.noOfChkdBoxes.value > 1)\n\t\t\t{\n\t\t\t\tvar noOfChkdBoxes = parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.noOfChkdBoxes.value;\n\t\t\t\tvar dialogTop\t\t=\t\"80\" ;\n\t\t\t\tvar dialogHeight= \"25\" ;\n\t\t\t\tvar dialogWidth = \"40\" ;\n\t\t\t\tvar status\t\t\t=\t\"no\";\n\t\t\t\tvar arguments\t\t=\t\"\" ;\n\t\t\t\tvar features\t\t=\t\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\" + dialogTop +\" ; scroll=no; status:\" + status;\n\t\t\t\tvar action_url\t\t=\t\'../../eCA/jsp/ChartRecordingGroupsFrame.jsp?desc=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&noOfChkdBoxes=\'+noOfChkdBoxes;\n\t\t\t\tvar retVal=window.showModalDialog(action_url,arguments,features);\t\t\n\t\t\t\tparent.window.returnValue=retVal\n\t\t\t}\t*/\t\t\n\t\t</script>\n\t</head>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<body onKeyDown=\"lockKey()\">\n\t\t<form name=\'chartRecAddToGrpFrom\' id=\'chartRecAddToGrpFrom\'>\t\t\t\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );
	
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

/*
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
16/02/2021   6030		 SIVABAGYAM M	RAMESH G      	16/02/2021			ML-MMOH-CRF-1542
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	String flowsheetGraph = request.getParameter("flowsheetGraph") == null ? "" : request.getParameter("flowsheetGraph");
	
	eCA.ChartRecordingAddGroupBean chartingBean = null; //(eCA.ChartRecordingAddGroupBean)getObjectFromBean("chartingBean","eCA.ChartRecordingAddGroupBean",session);

	if(flowsheetGraph.equals("Y"))
	{
		chartingBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("flowsheetBean"+patient_id+encounter_id,"eCA.ChartRecordingAddGroupBean",session);
	}
	else
	{
		chartingBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("chartingBean"+patient_id+encounter_id,"eCA.ChartRecordingAddGroupBean",session);
	}




            _bw.write(_wl_block4Bytes, _wl_block4);

			
			String chkBox = request.getParameter("ChkdBoxes") == null ? "" : request.getParameter("ChkdBoxes");
			String desc = request.getParameter("desc") == null ? "" : request.getParameter("desc");
			String code = request.getParameter("code") == null ? "" : request.getParameter("code");
			String uom = request.getParameter("uom") == null ? "" : request.getParameter("uom");
			String concTdObjValues = request.getParameter("concTdObjValues") == null ? "" : request.getParameter("concTdObjValues");
			String grpDetails = request.getParameter("grpDetails") == null ? "" : request.getParameter("grpDetails");
			String calledFrom = request.getParameter("calledFrom") == null ? "" : request.getParameter("calledFrom");
			//6030 STARTS
			HashMap records=new HashMap();
			records=chartingBean.getRecords();
			desc = java.net.URLDecoder.decode(desc);
			String mapdesc="",yorn="",contobjvalues="",tempuom="",groups="";
		String values="",valueForMap="";
		boolean sitespecific=false;
		sitespecific=chartingBean.isSiteSpecific("VIEWGRAPH_FOR_PANEL");
		sitespecific=true;
			//IN052210 Start.
			//String valueForMap = desc+ "~" + "Group 1" + "~" + "YorN" + "~" + concTdObjValues + "~" + uom;
			if(sitespecific){
			if(records.containsKey(code)){
				values=(String)records.get(code);
				StringTokenizer strToken1=new StringTokenizer(values,"~");
				while(strToken1.hasMoreTokens())
				{
					mapdesc=strToken1.nextToken();
					yorn=strToken1.nextToken();
					contobjvalues=strToken1.nextToken();
					tempuom=strToken1.nextToken();
					groups=strToken1.nextToken();
					concTdObjValues=concTdObjValues+contobjvalues+">";
				}
			} 
			}
			//6030 ENDS
				  valueForMap = desc + "~" + "YorN" + "~" + concTdObjValues + "~" + uom + " ~" + "Group 1";
			//IN052210 End.
			if(calledFrom.equals("RecMat"))
			{
				String noOfChkdBoxes = request.getParameter("noOfChkdBoxes") == null ? "" : request.getParameter("noOfChkdBoxes");
				int Chked = Integer.parseInt(noOfChkdBoxes);
				if(Chked == 1 && chkBox.equals("true"))
					chartingBean.clearBean();
			}
			
			chartingBean.addRecords(code,valueForMap);
			if(flowsheetGraph.equals("Y"))
				putObjectInBean("flowsheetBean"+patient_id+encounter_id,chartingBean,session);
			else
				putObjectInBean("chartingBean"+patient_id+encounter_id,chartingBean,session);
		
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(chkBox));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(calledFrom));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(grpDetails));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(chkBox));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block10Bytes, _wl_block10);

		if(chkBox.equals("false"))
		{
			chartingBean.removeRecord(code);
			if(flowsheetGraph.equals("Y"))
				putObjectInBean("flowsheetBean"+patient_id+encounter_id,chartingBean,session);
			else
				putObjectInBean("chartingBean"+patient_id+encounter_id,chartingBean,session);
		}
	
            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
