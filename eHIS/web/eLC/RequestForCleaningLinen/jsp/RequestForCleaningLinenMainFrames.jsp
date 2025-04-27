<!DOCTYPE html>
<html>
<script type="text/javascript">
  var cWidth = 700 ;
  var dw = 1 ;
  var timerRunning = false ;
  var timerID ;

  function slide()
  {
    if( timerRunning )
      clearTimeout(timerID) ;
    timerRunning = false ;
    dw = -dw ;
    timerRunning = true ;
    timerID = self.setTimeout( "ping()", 10 ) ;
  }

  function grow()
  {
    dw = 1 ;
    timerRunning = true ;
    timerID = self.setTimeout( "ping()", 10 ) ;
  }

  function ping()
  {
    if( !timerRunning ) return ;
    if( dw < 0 )
    {
      cWidth += 20 ;
      if( cWidth <= 0 )
      {
        cWidth = 0 ;
        if( timerRunning )
          clearTimeout(timerID) ;
        timerRunning = false ;
      }
      else
      {
        timerID = self.setTimeout( "ping()", 10 ) ;
      }
      document.getElementById( 'mainSet' ).cols =  '980, *' ;
    }
    else if( dw > 0 )
    {
      cWidth -= 20 ;
      if( cWidth >= 700 )
      {
        cWidth = 700 ;
        if( timerRunning )
          clearTimeout(timerID) ;
        timerRunning = false ;
      }
      else
      {
        timerID = self.setTimeout( "ping()", 10 ) ;
      }
	  document.getElementById( 'mainSet' ).cols = cWidth + ', *' ;
    }
    else
    {
      if( timerRunning )
        clearTimeout(timerID) ;
      timerRunning = false ;
    }
  }

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
String dirtyFlag=request.getParameter("dirtyFlag");
String flag=request.getParameter("flag");
String cutoffTime=request.getParameter("cutoffTime");
String requestDate=request.getParameter("requestDate");
String delParamDate=request.getParameter("delParamDate");
String userFlag=request.getParameter("userFlag");
String functionId=request.getParameter("functionId");
String moduleId=request.getParameter("moduleId");

%>
	

	<iframe name="WriteOffLinen" id="WriteOffLinen" noresize="noresize" src=" <%=request.getContextPath()%>/eLC/RequestForCleaningLinen/jsp/RequestForCleaningLinenTabsMain.jsp?flag=<%=flag%>&dirtyFlag=<%=dirtyFlag%>&cutoffTime=<%=cutoffTime%>&delParamDate=<%=delParamDate%>&userFlag=<%=userFlag%>&requestDate=<%=requestDate%>&vo.functionId=<%=functionId%>&vo.moduleId=<%=moduleId%>" /></iframe><iframe name="RHSFrame" id="RHSFrame" noresize="noresize" src=" <%=request.getContextPath()%>/eLC/core/jsp/RHSTabsMainWards.jsp"  /></iframe>
	
</html>

