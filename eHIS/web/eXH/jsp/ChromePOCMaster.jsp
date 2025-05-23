<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="../../eXH/Kendo/styles/kendo.common.min.css" />
    <link rel="stylesheet" href="../../eXH/Kendo/styles/kendo.default.min.css" />
    <link rel="stylesheet" href="../../eXH/Kendo/styles/kendo.default.mobile.min.css" />

    <Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
    <script src="../../eXH/Kendo/js/kendo.all.min.js" type="text/javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    

</head>
<body>

        <div id="example">
            <div id="window">
							<!--

                <h4>Armchair 402</h4>
                <div class="armchair"><img src="../content/web/window/armchair-402.png" alt="Armchair 402" /> Artek Alvar Aalto - Armchair 402</div>
                <p>Alvar Aalto is one of the greatest names in modern architecture and design. Glassblowers at the iittala factory still meticulously handcraft the legendary vases that are variations on one theme, fluid organic shapes that let the end user decide the use. Interpretations of the shape in new colors and materials add to the growing Alvar Aalto Collection that remains true to his original design.</p>

                <p>Born Hugo Alvar Henrik Aalto (February 3, 1898 - May 11, 1976) in Kuortane, Finland, was noted for his humanistic approach to modernism. He studied architecture at the Helsinki University of Technology from 1916 to 1921. In 1924 he married architect Aino Marsio.</p>

                <p>Alvar Aalto was one of the first and most influential architects of the Scandinavian modern movement, and a member of the Congres Internationaux d'Architecture Moderne. Major architectural works include the Finlandia Hall in Helsinki, Finland, and the campus of Helsinki University of Technology.</p>

                <p>Source: <a href="https://www.aalto.com/about-alvar-aalto.html" title="About Alvar Aalto">www.aalto.com</a></p>
				-->
            </div>

            <span id="undo" style="display:none" class="k-button hide-on-narrow">Click here to open the window.</span>

            <div class="responsive-message"></div>

            <script>
                $(document).ready(function() {
					parent.document.getElementsByTagName("frameset").item(0).rows = '7%,90%,3%';
                    var myWindow = $("#window"),
                        undo = $("#undo");
						undo.fadeIn();

                    undo.click(function() {
						parent.document.getElementsByTagName("frameset").item(0).rows = '7%,90%,3%';
                        myWindow.data("kendoWindow").open();
                        undo.fadeOut();
                    });

                    function onClose() {
						parent.document.getElementsByTagName("frameset").item(0).rows = '7%,40%,53%';
                        undo.fadeIn();
                    }
					/*
                    myWindow.kendoWindow({
                        width: "750px",
                        title: "About Alvar Aalto",
                        visible: false,
                        actions: [
                            "Pin",
                            "Minimize",
                            "Maximize",
                            "Close"
                        ],
                        close: onClose
                    }).data("kendoWindow").center().open();
					*/
					
					
					 myWindow.kendoWindow({
                        width: "600px",
                        height: "300px",
                        title: "About Alvar Aalto",
						content: "../../eCommon/jsp/CommonLookup.jsp?title=DataGroup",
						iframe: true,
                        visible: false,
                        actions: [
                            "Pin",
                            "Minimize",
                            "Maximize",
                            "Close"
                        ],
                        close: onClose
                    }).data("kendoWindow").center().close();
                });
            </script>

            <style>

                #example {
                    min-height:500px;
                }
                #undo {
                    text-align: center;
                    position: absolute;
                    white-space: nowrap;
                    padding: 1em;
                    cursor: pointer;
                }
                .armchair {
                	float: left;
                	margin: 30px 30px 120px 30px;
                	text-align: center;
                }
                .armchair img {
                    display: block;
                    margin-bottom: 10px;
                }
                .k-window-content a {
                    color: #BBB;
                }
                .k-window-content p {
                    margin-bottom: 1em;
                }

                @media screen and (max-width: 1023px) {
                    div.k-window {
                        display: none !important;
                    }
                }
            </style>
        </div>


</body>
</html>

