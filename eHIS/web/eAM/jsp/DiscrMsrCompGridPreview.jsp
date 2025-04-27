<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="../../eCA/html/RecClinicalNotesTemplateRecordingView.xsl"?>

<DOCUMENT FORM-NAME="RecClinicalNotesTemplateForm">

<%@ page contentType="application/xml" import="java.sql.*, webbeans.eCommon.*, java.util.*" %>
<% 
    String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) ? 
                    (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
<CSS sStyle="<%=sStyle%>"/>

<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="../../eCA/js/RecClinicalNotesPart1.js"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="../../eCA/js/RecClinicalNotesPart2.js"></SCRIPT>

<% 
    // Set request encoding to UTF-8
    request.setCharacterEncoding("UTF-8");

    // Retrieve JDBC connection properties and locale
    java.util.Properties p = (java.util.Properties) session.getValue("jdbc");
    String locale = (String) p.getProperty("LOCALE");

    Connection con = null;
    String gridComponentDefinition = request.getParameter("gridComponentDefinition") == null ? "" : request.getParameter("gridComponentDefinition");
    String gridID = request.getParameter("gridID") == null ? "" : request.getParameter("gridID");
    String grid_desc = request.getParameter("grid_desc") == null ? "" : request.getParameter("grid_desc");    
    StringBuffer gridComponentXML = new StringBuffer();

    try {
        // Establish database connection
        con = ConnectionManager.getConnection(request);

        // Create grid component bean and process the grid definition
        eAM.DiscrMsrCompGridComponentBean gridCompBean = new eAM.DiscrMsrCompGridComponentBean();
        if (!gridComponentDefinition.equals("")) {
            // Retrieve the grid component XML
            gridComponentXML = gridCompBean.changeDefinitionToXML(con, gridComponentDefinition, gridID, grid_desc, locale);
        }
    } catch (Exception e) {
        out.println(e);
        e.printStackTrace(System.err);
    } finally {
        // Return the database connection to the pool
        ConnectionManager.returnConnection(con);
    }

    // Ensure any "±" symbols are replaced with "+"
    String gridComponentXMLString = gridComponentXML.toString().replace("<style>", "<style>textarea {resize: none;}</style>");
%>

<USER-TEMPLATE>
    <ROW>
        <COL>
            <%= gridComponentXMLString %>  <!-- Display the cleaned grid component XML -->
        </COL>
    </ROW>
</USER-TEMPLATE>

</DOCUMENT>
