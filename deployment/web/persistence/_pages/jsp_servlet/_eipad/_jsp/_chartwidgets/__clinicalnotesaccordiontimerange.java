package jsp_servlet._eipad._jsp._chartwidgets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.ResourceBundle;
import java.util.*;
import eIPAD.chartsummary.clinicalnotes.response.*;
import eIPAD.chartsummary.clinicalnotes.healthobject.*;

public final class __clinicalnotesaccordiontimerange extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/ClinicalNotesAccordionTimeRange.jsp", 1709116943786L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t   \t\t <div data-role=\"none\" class=\"notesFullViewTable\" >\n\t\t   \t\t \t<div data-role=\"none\" class=\"notesFullViewRow\">\n\t\t   \t\t \t\t<div data-role=\"none\" class=\"notesFullViewCell\">\n\t\t   \t\t \t\t\t<!-- full view wrapper starts -->\n\t\t   \t\t \t\t\t\t<div data-role=\"none\" class=\"fullViewWrapper\" id = \"Fw";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\" data-fullViewWrapper = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\" >\n\t\t   \t\t \t\t\t\t    <!-- scroller starts --> \n\t\t   \t\t \t\t\t\t\t<div data-role=\"none\" class=\"fullViewScroller\" data-fullViewScroller = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\" > \n\t\t   \t\t \t\t\t\t\t ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t   \t\t \t\t\t\t\t\t<div data-role=\"none\" style=\" float: left;height: 100%; vertical-align: middle;\" data-child=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\n\t\t   \t\t \t\t\t\t\t\t\t<div data-role=\"none\" data-pageCount =  \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"data-pageId = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" data-pageNumber = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" data-bubbleNoteType = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" style=\"width: 100%; height: 100%;  text-align: left; vertical-align: middle; position: relative;\">\n\t\t   \t\t \t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t   \t\t \t\t\t\t\t\t\t \t\t\t\t <div data-role=\"none\" class=\"notesBubbleContainer\" data-accNumber = \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" onclick = \"showNoteContentClick(this,\'exapnd\')\">\n\t\t   \t\t \t\t\t\t\t\t\t \t\t\t\t   ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t   \t\t \t\t\t\t\t\t\t \t\t\t\t   \t\t\t\t\t<div data-role=\"none\" class = \"notesDivider1 notesDividerTheme\"></div>\n\t\t   \t\t \t\t\t\t\t\t\t \t\t\t\t   \t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"fullViewDataContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" style=\"display: table; width: 100%; height: 100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" style=\"display: table-row; width: 100%; height: 100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" style=\"display: table-cell; width: 1%; height: 100%; vertical-align: middle; text-align: center; border-radius: 30px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"iconContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t<img src=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="/eIPAD/images/";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"></img>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"display: table-cell; width: 99%; height: 100%; border-radius: 30px; vertical-align: middle\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"dateContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"notesDate\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t   \t\t \t\t\t\t\t\t\t \t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t   \t\t \t\t\t\t\t\t\t</div>\n\t\t   \t\t \t\t\t\t\t\t</div>\n\t\t   \t\t \t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t   \t\t \t\t\t\t\t</div>\n\t\t   \t\t \t\t\t\t\t<!-- scroller ends -->\n\t\t   \t\t \t\t\t\t</div>\n\t\t   \t\t \t\t\t<!-- full view wrapper ends -->\n\t\t   \t\t \t\t\t<div data-role=\"none\" style=\"display:inline-block;width: 100%; height: 30px; background-color: #ffffff;vertical-align:middle;text-align:center\">\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t\t    \t\t<div data-role = \"none\" data-pageIcon = \"T\" class = \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" data-pageIconNumber = \"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" data-pageIconNoteType = \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" onclick = \"scrollToPage(";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =",this,\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\')\"></div>\n\t\t\t\t\t\t\t\t\t    \t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\t   \t\t \t\t\t\n\t\t   \t\t \t\t\t</div>\n\t\t   \t\t \t\t</div>\n\t\t   \t\t \t</div>\n\t\t   \t\t </div>\n\t\t   \t\t ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

int nListSize = 0;
int nRecPerPage = 15;
ClinicalNotesResponse oCnRes = null;
List<ClinicalNoteGroup> listNoteGroup = null;
String noteStatus = "";
if(request.getAttribute("ClinicalNotesViewResponse") != null){
	oCnRes = (ClinicalNotesResponse)request.getAttribute("ClinicalNotesViewResponse");
	if(oCnRes != null)
	{
		listNoteGroup = oCnRes.getListNoteGroup();
	}
	if(listNoteGroup != null)
	{
		nListSize = listNoteGroup.size();
	}
}
int nLoopCount = 0;
if(nListSize > 0 )
{
		ClinicalNoteGroup oCnGrp = null;
		int nSubLoopCount = 0;
		int nSubLoopSize = 0;
		String dateValue = "";
		for(nLoopCount = 0; nLoopCount < nListSize; nLoopCount++)
		{
			oCnGrp = listNoteGroup.get(nLoopCount);
			if(oCnGrp != null)
			{
				 nSubLoopCount = 0;
		   		 nSubLoopSize = 0;
		   		 List<NoteDetailsTimeRange> oLstNoteDetails = null;
		   		 oLstNoteDetails = oCnGrp.getListNoteDetailsTimeRange();
		   		 if(oLstNoteDetails != null)
		   		 {
		   			nSubLoopSize = oLstNoteDetails.size();
		   		 }
		   		 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf( oCnGrp.getGroupDescription().getGroupByValue()));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf( oCnGrp.getGroupDescription().getGroupByValue()));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf( oCnGrp.getGroupDescription().getGroupByValue()));
            _bw.write(_wl_block5Bytes, _wl_block5);

		   		 					   int nPageNumber =0;
		   		 					   int PageCount = (int) Math.ceil((double)oCnGrp.getChildCount()/nRecPerPage);
		   		 					   for(nPageNumber = 0 ;nPageNumber < PageCount ;nPageNumber++)
		   		 					   {
		   		 						   
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( oCnGrp.getGroupDescription().getGroupByValue()));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(PageCount));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( oCnGrp.getGroupDescription().getGroupByValue()));
            out.print( String.valueOf(nPageNumber ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(nPageNumber ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( oCnGrp.getGroupDescription().getGroupByValue()));
            _bw.write(_wl_block11Bytes, _wl_block11);

		   		 							 	if(nSubLoopSize > 0 && nPageNumber == 0)//to show the record for first page alone
		   		 							 	{
		   		 							 		NoteDetailsTimeRange oNoteDetails = null;
		   		 							 		for(nSubLoopCount = 0 ; nSubLoopCount < nSubLoopSize && nSubLoopCount < nRecPerPage;nSubLoopCount++ )
		   		 							 		{
		   		 							 			oNoteDetails = oLstNoteDetails.get(nSubLoopCount);
		   		 							 			if(oNoteDetails != null)
		   		 							 			{
		   		 							 				
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(oNoteDetails.getAccessionNum() ));
            _bw.write(_wl_block13Bytes, _wl_block13);

		   		 							 				   		if(nSubLoopCount > 0)
		   		 							 				   		{
		   		 							 				   			if(!dateValue.equals(oNoteDetails.getDescription().getDescription())  )
		   		 							 				   			{
		   		 							 				   				
            _bw.write(_wl_block14Bytes, _wl_block14);
 
		   		 							 				   			}
		   		 							 				   		}
		   		 							 				      dateValue = oNoteDetails.getDescription().getDescription();
			   		 							 				  if(oNoteDetails.getStatus() != null)
		   		 							 				      {
		   		 							 				    	  if(oNoteDetails.getStatus().equals("1"))
		   		 							 				    	  {
		   		 							 				    		  noteStatus = "In_Progress24x24.png";
		   		 							 				    	  }
		   		 							 				    	  else if(oNoteDetails.getStatus().equals("2"))
		   		 							 				    	  {
		   		 							 				    		  noteStatus = "Transcribed24x24.png";
		   		 							 				    	  }
		   		 							 				    	  else if(oNoteDetails.getStatus().equals("3"))
		 		 							 				    	  {
		 		 							 				    		  noteStatus = "Unauthorized24x24.png";
		 		 							 				    	  }
		   		 							 				    	  else if(oNoteDetails.getStatus().equals("4"))
				 							 				    	  {
				 							 				    		  noteStatus = "Authorized24x24.png";
				 							 				    	  }
		   		 							 				    	  else if(oNoteDetails.getStatus().equals("5"))
				 							 				    	  {
				 							 				    		  noteStatus = "Modified.png";
				 							 				    	  }
		   		 							 				    	  else if(oNoteDetails.getStatus().equals("9"))
				 							 				    	  {
				 							 				    		  noteStatus = "InError24x24.png";
				 							 				    	  }
		   		 							 				    	  else
		   		 							 				    	  {
		   		 							 				    		  noteStatus = "";
		   		 							 				    	  }
		   		 							 				    	  
		   		 							 				      }
		   		 							 				      
		   		 							 				   
            _bw.write(_wl_block15Bytes, _wl_block15);

																					    	if(!noteStatus.equals(""))
																					    	{
																					    		
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(noteStatus));
            _bw.write(_wl_block18Bytes, _wl_block18);
 
																					    	}
																			             
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(oNoteDetails.getDescription().getDescription() ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oNoteDetails.getDescription().getEventTime() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
 
		   		 							 			}
		   		 							 		}
		   		 							 	}
		   		 							 
            _bw.write(_wl_block22Bytes, _wl_block22);
 
		   		 					   }
		   		 					 
            _bw.write(_wl_block23Bytes, _wl_block23);

										int nCount =0;
									    String className = "normalPageIcons";
									    
									    for(nCount =0;nCount < PageCount;nCount++)
									    {
									    	if(nCount == 0)
									    	{
									    		className = "selectedPageIcons";
									    	}
									    	else
									    	{
									    		className = "normalPageIcons";
									    	}
									    	
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(className ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(nCount));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( oCnGrp.getGroupDescription().getGroupByValue()));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(nCount));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( oCnGrp.getGroupDescription().getGroupByValue()));
            _bw.write(_wl_block29Bytes, _wl_block29);
 
									    }
									
            _bw.write(_wl_block30Bytes, _wl_block30);

			}
		}
}

            _bw.write(_wl_block1Bytes, _wl_block1);
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
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("path", java.lang.String .class,"var"));
        __tag0.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.Object.class,pageContext,_jspx_fnmap));
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
