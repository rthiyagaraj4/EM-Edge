Imports System
Imports System.Data
Imports System.Data.OleDb
Imports System.Data.OracleClient
Imports Scripting
Imports System.IO
Imports ORAOLEDBLib


Public Class DRGInterface
    Private Declare Function SendMessage Lib "user32.dll" Alias "SendMessageA" (ByVal hWnd As IntPtr, ByVal wMsg As Integer, ByVal wParam As Integer, ByVal lParam As Integer) As Integer

    Private Const PBM_SETBARCOLOR As Integer = &H409
    Private Const PBM_SETBKCOLOR As Integer = &H2001
    Private Const PBM_SETFRCOLOR As Integer = &H2001

    Dim p_msgout As String
    Dim GTmpStr As String
    Dim GLogFileName As String
    Dim GFolderpath As String
    Dim fso As New FileSystemObject
    Dim trc_flg As String
    Dim currentdt As Date
    Dim out_folder As String
    Dim p_out As String
    Dim type_msg As String
    Dim connectionString As String
    Dim length As Integer = 0
    Dim file_name_appl As String
    Dim GMinutesElapsed As Double
    Dim GSQLText As String
    'Dim conn_ora As OracleConnection
    Dim conn_ora As OleDbConnection


    'XH_INTERACTIVE_INTEGRATION Table Columns
    Dim GUserid As String
    Dim GMachinename As String
    Dim GPgmid As String
    Dim GModuleid As String
    Dim GSessionid As String
    Dim GFacilityid As String
    Dim GPatientid As String
    Dim GMergedpatientid As String
    Dim GEncounterid As String
    Dim GProfileid As String
    'Dim GRequestno As String
    Dim GRequestdate As DateTime
    Dim GRequesttext As String
    Dim GResponsetext As String
    Dim GAddedbyid As String
    Dim GAddeddate As DateTime
    Dim GModifiedbyid As String
    Dim GModifieddate As DateTime
    Dim GAddedatwsno As String
    Dim GAddedfacilityid As String
    Dim GModifiedatwsno As String
    Dim GModifiedfacilityid As String

    Dim GAccessionnum As String
    Dim GAckmessageid As String
    Dim GAcknowledgmentsyntax As String
    Dim GAcknowledgmenttext As String
    Dim GApplicationid As String
    Dim GEpisodetype As String
    Dim GErrortext As String
    Dim GEventtype As String
    Dim GExtaccessionnum As String
    Dim GMessagedate As Date
    Dim GMessageid As String
    Dim GProcessid As String
    Dim GProtocollinkid As String
    Dim GRejeactedreason As String
    Dim GReponsesyntax As String
    Dim GRequestsyntax As String
    Dim GTrxno As Integer
    Dim GWsno As String

    'Parameter passed
    Dim GDatabase As String
    Dim GUsername As String
    Dim GPassword As String
    Dim GPgmDate As String
    Dim GSession As String
    Dim GFacID As String
    Dim GPriority As String
    Dim GSvrRqst As String
    Dim Gtraceyn As String

    'ini extraction to variables
    Dim table_name As String
    Dim col_hdng As String
    Dim col_hdng1 As String
    Dim op_filenm As String
    Dim ip_filenm As String
    Dim op_folder As String
    Dim ip_folder As String
    Dim exe_name As String
    Dim col_dt As String
    Dim log_dir As String

    Dim mod_col As String

    Dim param_status As String
    Dim param_err_txt As String


    Dim filelinecnt As Integer
    Dim anyerr As String

    Dim p_runflag As String
    Dim p_noconn_flag As String
    Dim p_folderExists As String
    Dim p_folderCreation_err As String
    Dim p_drgclose As String

    Dim GSleepTime As Integer

    Dim p_conn_restart As String


    Private Sub DRGInterface_FormClosing(ByVal sender As Object, ByVal e As System.Windows.Forms.FormClosingEventArgs) Handles Me.FormClosing
        If p_noconn_flag <> "Y" Then
            If anyerr <> "Y" Then
                WriteLog("Calling RunStatusUpd to update Running Status to XB_PARAM...")
                p_runflag = "E"
                p_drgclose = "Y"
                RunStatusUpd()

                WriteLog("RunStatusUpd Over...")
                oraConnOpen(0)
            Else
                p_runflag = "X"
                p_drgclose = "Y"
                RunStatusUpd()
                oraConnOpen(0)
            End If
        End If
    End Sub


    Private Sub DRGInterface_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load

        Dim arr() As String = Command.Split(" ")
        Dim connstring As String

        Try

            Button1.Width = 17
            Button1.Height = 29
            Button1.Text = " "
            Button1.BackColor = Color.White
            Button1.ForeColor = Color.White

            'Gtraceyn = "Y"

            Dim IsFormHidden As Boolean
            currentdt = Now

            MsgText.Text = "Initialization of DRG Processor..."

            connstring = arr(0).ToString

            GUsername = Mid(connstring, 1, InStr(connstring, "/") - 1)

            GPassword = Mid(connstring, InStr(connstring, "/") + 1, InStr(Mid(connstring, InStr(connstring, "/") + 1), "@") - 1)

            GDatabase = Mid(connstring, InStr(connstring, "@") + 1)

            Gtraceyn = arr(1).ToString

            trc_flg = Gtraceyn

            MsgText.Text = "Establishing ODBC Connection..."

            connectionString = "Provider=OraOLEDB.Oracle.1;Password=" + GPassword + ";Persist Security Info=True;User ID=" + GUsername + ";Data Source=" + GDatabase
            'connectionString = "Data Source =" & GDatabase & ";Persist Security Info=true;Password=" & GPassword & ";User Id=" & GUsername

            ODBCConnTest()

            If p_noconn_flag <> "Y" Then

                oraConnOpen(1)

                InteractiveParamfetch()

                RequestTimer.Interval = GSleepTime * 1000

                CurrTimer.Interval = GSleepTime * 1000

                MsgText.Text = "Data Fetch from XB Parameter..."

                filelinecnt = 0

                Call FetchParam()

                If anyerr = "Y" Then
                    Exit Sub
                End If

                MsgText.Text = "DRG Processor Successfully started..."

                WriteLog("Calling RunStatusUpd to update Running Status to XB_PARAM...")
                p_runflag = "S"
                p_conn_restart = "N"
                RunStatusUpd()
                WriteLog("RunStatusUpd Over...")

                IsFormHidden = True

                If Not IsFormHidden Then
                    ' Position objects
                    Me.Left = 3500
                    Me.Top = 2000
                    Button1.Left = 20
                    Button1.BackColor = Color.White 'Idle
                    Button1.ForeColor = Color.White 'Idle

                    ' Display current time
                    Currtime.Text = FormatDateTime(Now, DateFormat.ShortDate) & " " & FormatDateTime(Now, DateFormat.ShortTime)
                End If
                Currtime.Text = FormatDateTime(Now, DateFormat.ShortDate) & " " & FormatDateTime(Now, DateFormat.ShortTime)

                RequestTimer.Enabled = True
                GMinutesElapsed = 0
                CurrTimer.Enabled = True
            Else
                Me.Close()
            End If

        Catch ex As Exception
            MsgBox("Error while Loading XBDRG.exe - " + Mid(ex.ToString, 1, InStr(ex.ToString, Chr(13))))
            'oraConnOpen(0) 'Closing Oracle Connection 'By Anil 30/11/09
            Me.Close()
        End Try

    End Sub

    Private Sub RequestTimer_Tick(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles RequestTimer.Tick

        Try
            ' Initialize
            Button1.BackColor = Color.White ' Idle
            Button1.ForeColor = Color.White ' Idle
            If RequestTimer.Interval <> (GSleepTime * 1000) Then
                RequestTimer.Interval = (GSleepTime * 1000)
            End If

            Call Process()

            Exit Sub
        Catch ex As Exception
            ' Reset progressbar attribute
            Button1.BackColor = Color.White ' Idle
            Button1.ForeColor = Color.White ' Idle

            ' Enable progressbar timer
            RequestTimer.Enabled = True
            WriteLog("Error at RequestTimer_Timer() : " & ex.ToString)
        End Try
    End Sub
    Private Sub RunStatusUpd()
        Dim cmd As New OleDbCommand()
        'Dim cmd As New OracleCommand()

        If p_runflag = "X" Then

            Try

                oraConnOpen(1) 'Opening Oracle Connection 'By Anil 30/11/09

                cmd.Connection = conn_ora

                cmd.CommandText = "UPDATE XB_PARAM SET addl_field1 = 'N' WHERE PROFILE_ID = 'SRRDRG1'"

                cmd.ExecuteNonQuery()

                cmd.CommandText = "COMMIT"

                cmd.ExecuteNonQuery()

                update_message_status("", "", param_err_txt)
                param_err_txt = ""

                'oraConnOpen(0) 'Closing Oracle Connection 'By Anil 30/11/09

            Catch ex As Exception
                MsgBox(ex.ToString)
                'oraConnOpen(0) 'Closing Oracle Connection 'By Anil 30/11/09
            End Try
        Else

            Try
                WriteLog("Inside RunStatusUpd Method ... ")

                oraConnOpen(1) 'Opening Oracle Connection 'By Anil 30/11/09

                cmd.Connection = conn_ora

                If p_runflag = "S" Then
                    cmd.CommandText = "UPDATE XB_PARAM SET addl_field1 = 'Y' WHERE PROFILE_ID = 'SRRDRG1'"
                Else
                    cmd.CommandText = "UPDATE XB_PARAM SET addl_field1 = 'N' WHERE PROFILE_ID = 'SRRDRG1'"
                End If

                GTmpStr = "Update Statement - " & cmd.CommandText
                WriteLog(GTmpStr)

                GTmpStr = "Update Statement Execution..."
                WriteLog(GTmpStr)

                cmd.ExecuteNonQuery()

                GTmpStr = "Update Statement Execution Over"
                WriteLog(GTmpStr)

                If param_err_txt = "" Then
                    update_message_status("", "", "DRG Processor Got Stopped...")
                Else
                    update_message_status("", "", "DRG Processor Got Stopped - " + param_err_txt)
                    param_err_txt = ""
                End If

                'oraConnOpen(0) 'Closing Oracle Connection 'By Anil 30/11/09

            Catch ex As Exception
                GTmpStr = "Error Occured while RunStatusUpd - " & ex.ToString
                WriteLog(GTmpStr)
                'oraConnOpen(0) 'Closing Oracle Connection 'By Anil 30/11/09
            End Try
        End If
    End Sub
    Private Sub WriteLog(ByVal PMsg As String)
        Dim tmpmsg As String

        Try

            filelinecnt = filelinecnt + 1

            If trc_flg = "Y" Then
                'GFolderpath = "c:\eHIS\Reports"

                If Not fso.FolderExists(GFolderpath) Then
                    MkDir(GFolderpath)
                End If

                GLogFileName = GFolderpath & "\DRG_" & Format(currentdt, "dd_MM_yyyy_hh_mm_ss_tt") & ".Log"

                If filelinecnt = 1 Then
                    tmpmsg = "IBAeHIS DRG Processor Log"
                    tmpmsg = tmpmsg + vbNewLine + "User Id: " + GUsername
                    tmpmsg = tmpmsg + vbNewLine + "Created On: " + Format(Now, "dd/MM/yyyy hh:mm:ss tt")
                    tmpmsg = tmpmsg + vbNewLine + "----------------------------------------------------"
                    tmpmsg = tmpmsg + vbNewLine + Format(Now, "dd/MM/yyyy hh:mm:ss tt") + "   " + PMsg
                Else
                    tmpmsg = Format(Now, "dd/MM/yyyy hh:mm:ss tt") + "   " + PMsg
                End If

                Dim fs As New FileStream(GLogFileName, FileMode.OpenOrCreate, FileAccess.Write)
                Dim Str As New StreamWriter(fs)
                Str.BaseStream.Seek(0, SeekOrigin.End)
                Str.WriteLine(tmpmsg)
                Str.Close()
            End If
        Catch ex As Exception
            MsgBox("Tracing Error!!!, Please Check the Log Directory Path...", MsgBoxStyle.Critical)
            anyerr = "Y"
            param_err_txt = ex.ToString
            'oraConnOpen(0) 'Closing Oracle Connection 'By Anil 30/11/09
            Me.Close()
        End Try
    End Sub

    Private Sub CurrTimer_Tick(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles CurrTimer.Tick
        On Error GoTo err

        Currtime.Text = FormatDateTime(Now, DateFormat.ShortDate) & " " & FormatDateTime(Now, DateFormat.ShortTime)
        Button1.Left = Button1.Left + 5
        If Button1.Right > 270 Then
            Button1.Left = 25
        End If

        Exit Sub
err:
        WriteLog("Error at CurrTimer_Timer() : " & Err.Description)
    End Sub

    Private Sub Process()
        'Dim p_out As String
        'Dim cmd As New OracleCommand()
        'Dim oracleDa As New OracleDataAdapter(cmd)

        Dim cmd As New OleDbCommand()
        'Dim cmd As New OracleCommand()
        Dim oracleDa As New OleDbDataAdapter(cmd)
        'Dim oracleDa As New OracleDataAdapter(cmd)
        Dim oracleDs As New DataSet
        Dim Oracledt As New DataTable
        Dim rec_cnt As Integer = 0
        Dim i As Integer = 0
        Dim p_status As String
        Dim p_err As String

        Try

            WriteLog("Searching for any new requests...")

            rec_cnt = AnyNewRequest()

            If rec_cnt = 0 Then
                GoTo Exit_sub
            ElseIf rec_cnt < 0 Then
                GoTo Close_sub
            End If

            WriteLog("AnyNewRequest - " & rec_cnt)

            'WriteLog("Calling FetchParam() method...")

            'Call FetchParam()

            'WriteLog("FetchParam() method Execution Over...")

            RequestTimer.Enabled = False
            Button1.BackColor = Color.DarkGreen
            Button1.ForeColor = Color.DarkGreen

            MsgText.Text = "Last request processed at " & Currtime.Text
            Me.Refresh()

            WriteLog("param_status - " + param_status)
            WriteLog("param_err_text - " + param_err_txt)

            If param_status = "S" Then

                GTmpStr = "Opening Oracle Database connection"
                WriteLog(GTmpStr)

                oraConnOpen(1) 'Opening Oracle Connection 'By Anil 30/11/09

                cmd.Connection = conn_ora

                GTmpStr = "Oracle Database connection Opened"
                WriteLog(GTmpStr)

                WriteLog("Query Creation...")

                GSQLText = "SELECT * FROM xh_interactive_integration "
                GSQLText = GSQLText & "WHERE pgm_id = 'XBDRG' "
                GSQLText = GSQLText & "AND STATUS = 'N' "

                'Index not getting utilised
                'GSQLText = GSQLText & "AND response_text IS NULL "
                'GSQLText = GSQLText & "AND error_text IS NULL "


                WriteLog("Query - " & GSQLText)

                cmd.CommandText = GSQLText

                WriteLog("Filling Dataset...")

                oracleDa.Fill(oracleDs)

                WriteLog("Attaching datatable to dataset...")
                Oracledt = oracleDs.Tables(0)

                With Oracledt
                    WriteLog("Fetching records from Recordset...")

                    For i = 0 To rec_cnt - 1
                        WriteLog("")
                        WriteLog("Record - " & (i + 1).ToString)
                        If Oracledt.Rows(i).Item(0).ToString Is Nothing Then
                            GUserid = ""
                        Else
                            Oracledt.Rows(i).Item(0).ToString()
                        End If
                        WriteLog("GUserid = " + GUserid)

                        If Oracledt.Rows(i).Item(1).ToString Is Nothing Then
                            GMachinename = ""
                        Else
                            GMachinename = Oracledt.Rows(i).Item(1).ToString
                        End If
                        WriteLog("GMachinename = " + GMachinename)

                        If Oracledt.Rows(i).Item(2).ToString Is Nothing Then
                            GWsno = ""
                        Else
                            GWsno = Oracledt.Rows(i).Item(2).ToString
                        End If
                        WriteLog("GWsno = " + GWsno)

                        If Oracledt.Rows(i).Item(3).ToString Is Nothing Then
                            GPgmid = ""
                        Else
                            GPgmid = Oracledt.Rows(i).Item(3).ToString
                        End If
                        WriteLog("GPgmid = " + GPgmid)

                        If Oracledt.Rows(i).Item(4).ToString Is Nothing Then
                            GModuleid = ""
                        Else
                            GModuleid = Oracledt.Rows(i).Item(4).ToString
                        End If
                        WriteLog("GModuleid = " + GModuleid)

                        If Oracledt.Rows(i).Item(5).ToString Is Nothing Then
                            GSessionid = ""
                        Else
                            GSessionid = Oracledt.Rows(i).Item(5).ToString
                        End If
                        WriteLog("GSessionid = " + GSessionid)

                        If Oracledt.Rows(i).Item(6).ToString Is Nothing Then
                            GRequestdate = ""
                        Else
                            GRequestdate = CDate(Oracledt.Rows(i).Item(6))
                        End If
                        WriteLog("GRequestdate = " + GRequestdate)

                        If Oracledt.Rows(i).Item(7).ToString Is Nothing Then
                            GRequesttext = ""
                        Else
                            GRequesttext = Oracledt.Rows(i).Item(7).ToString
                        End If
                        WriteLog("GRequesttext = " + GRequesttext)

                        If Oracledt.Rows(i).Item(8).ToString Is Nothing Then
                            GApplicationid = ""
                        Else
                            GApplicationid = Oracledt.Rows(i).Item(8).ToString
                        End If
                        WriteLog("GApplicationid = " + GApplicationid)

                        If Oracledt.Rows(i).Item(9).ToString Is Nothing Then
                            GMessageid = ""
                        Else
                            GMessageid = Oracledt.Rows(i).Item(9).ToString
                        End If
                        WriteLog("GMessageid = " + GMessageid)

                        If Oracledt.Rows(i).Item(10).ToString Is Nothing Then
                            GFacilityid = ""
                        Else
                            GFacilityid = Oracledt.Rows(i).Item(10).ToString
                        End If
                        WriteLog("GFacilityid = " + GFacilityid)

                        If Oracledt.Rows(i).Item(11).ToString Is Nothing Then
                            GMessagedate = ""
                        Else
                            GMessagedate = CDate(Oracledt.Rows(i).Item(11).ToString)
                        End If
                        WriteLog("GMessagedate = " + GMessagedate)

                        If Oracledt.Rows(i).Item(12).ToString Is Nothing Then
                            GEventtype = ""
                        Else
                            GEventtype = Oracledt.Rows(i).Item(12).ToString
                        End If
                        WriteLog("GEventtype = " + GEventtype)

                        If Oracledt.Rows(i).Item(13).ToString Is Nothing Then
                            GPatientid = ""
                        Else
                            GPatientid = Oracledt.Rows(i).Item(13).ToString
                        End If
                        WriteLog("GPatientid = " + GPatientid)

                        If Oracledt.Rows(i).Item(14).ToString Is Nothing Then
                            GMergedpatientid = ""
                        Else
                            GMergedpatientid = Oracledt.Rows(i).Item(14).ToString
                        End If
                        WriteLog("GMergedpatientid = " + GMergedpatientid)

                        If Oracledt.Rows(i).Item(15).ToString Is Nothing Then
                            GEpisodetype = ""
                        Else
                            GEpisodetype = Oracledt.Rows(i).Item(15).ToString
                        End If
                        WriteLog("GEpisodetype = " + GEpisodetype)

                        GEncounterid = Oracledt.Rows(i).Item(16).ToString
                        WriteLog("GEncounterid = " & GEncounterid.ToString)

                        If Oracledt.Rows(i).Item(17).ToString Is Nothing Then
                            GAccessionnum = ""
                        Else
                            GAccessionnum = Oracledt.Rows(i).Item(17).ToString
                        End If
                        WriteLog("GAccessionnum = " + GAccessionnum)

                        If Oracledt.Rows(i).Item(18).ToString Is Nothing Then
                            GExtaccessionnum = ""
                        Else
                            GExtaccessionnum = Oracledt.Rows(i).Item(18).ToString
                        End If
                        WriteLog("GExtaccessionnum = " + GExtaccessionnum)

                        If Oracledt.Rows(i).Item(19).ToString Is Nothing Then
                            GRequestsyntax = ""
                        Else
                            GRequestsyntax = Oracledt.Rows(i).Item(19).ToString
                        End If
                        WriteLog("GRequestsyntax = " + GRequestsyntax)

                        If Oracledt.Rows(i).Item(20).ToString Is Nothing Then
                            GAckmessageid = ""
                        Else
                            GAckmessageid = Oracledt.Rows(i).Item(20).ToString
                        End If
                        WriteLog("GAckmessageid = " + GAckmessageid)

                        If Oracledt.Rows(i).Item(21).ToString Is Nothing Then
                            GProtocollinkid = ""
                        Else
                            GProtocollinkid = Oracledt.Rows(i).Item(21).ToString
                        End If
                        WriteLog("GProtocollinkid = " + GProtocollinkid)

                        If Oracledt.Rows(i).Item(22).ToString Is Nothing Then
                            GProfileid = ""
                        Else
                            GProfileid = Oracledt.Rows(i).Item(22).ToString
                        End If
                        WriteLog("GProfileid = " + GProfileid)

                        If Oracledt.Rows(i).Item(23).ToString Is Nothing Then
                            GResponsetext = ""
                        Else
                            GResponsetext = Oracledt.Rows(i).Item(23).ToString
                        End If
                        WriteLog("GResponsetext = " + GResponsetext)

                        If Oracledt.Rows(i).Item(24).ToString Is Nothing Then
                            GReponsesyntax = ""
                        Else
                            GReponsesyntax = Oracledt.Rows(i).Item(24).ToString
                        End If
                        WriteLog("GReponsesyntax = " + GReponsesyntax)

                        If Oracledt.Rows(i).Item(25).ToString Is Nothing Then
                            GAddedbyid = ""
                        Else
                            GAddedbyid = Oracledt.Rows(i).Item(25).ToString
                        End If
                        WriteLog("GAddedbyid = " + GAddedbyid)

                        If Oracledt.Rows(i).Item(26).ToString Is Nothing Then
                            GAddeddate = ""
                        Else
                            GAddeddate = CDate(Oracledt.Rows(i).Item(26))
                        End If
                        WriteLog("GAddeddate = " + GAddeddate)

                        If Oracledt.Rows(i).Item(27).ToString Is Nothing Then
                            GModifiedbyid = ""
                        Else
                            GModifiedbyid = Oracledt.Rows(i).Item(27).ToString
                        End If
                        WriteLog("GModifiedbyid = " + GModifiedbyid)

                        If Oracledt.Rows(i).Item(28).ToString Is Nothing Then
                            GModifieddate = ""
                        Else
                            GModifieddate = CDate(Oracledt.Rows(i).Item(28))
                        End If
                        WriteLog("GModifieddate = " + GModifieddate)

                        If Oracledt.Rows(i).Item(29).ToString Is Nothing Then
                            GAddedatwsno = ""
                        Else
                            GAddedatwsno = Oracledt.Rows(i).Item(29).ToString
                        End If
                        WriteLog("GAddedatwsno = " + GAddedatwsno)

                        If Oracledt.Rows(i).Item(30).ToString Is Nothing Then
                            GAddedfacilityid = ""
                        Else
                            GAddedfacilityid = Oracledt.Rows(i).Item(30).ToString
                        End If
                        WriteLog("GAddedfacilityid = " + GAddedfacilityid)

                        If Oracledt.Rows(i).Item(31).ToString Is Nothing Then
                            GModifiedatwsno = ""
                        Else
                            GModifiedatwsno = Oracledt.Rows(i).Item(31).ToString
                        End If
                        WriteLog("GModifiedatwsno = " + GModifiedatwsno)

                        If Oracledt.Rows(i).Item(32).ToString Is Nothing Then
                            GModifiedfacilityid = ""
                        Else
                            GModifiedfacilityid = Oracledt.Rows(i).Item(32).ToString
                        End If
                        WriteLog("GModifiedfacilityid = " + GModifiedfacilityid)

                        If Oracledt.Rows(i).Item(33).ToString Is Nothing Then
                            GTrxno = ""
                        Else
                            GTrxno = CDbl(Oracledt.Rows(i).Item(33))
                        End If
                        WriteLog("GTrxno = " + GTrxno.ToString)

                        If Oracledt.Rows(i).Item(34).ToString Is Nothing Then
                            GRejeactedreason = ""
                        Else
                            GRejeactedreason = Oracledt.Rows(i).Item(34).ToString
                        End If
                        WriteLog("GRejeactedreason = " + GRejeactedreason)

                        If Oracledt.Rows(i).Item(35).ToString Is Nothing Then
                            GErrortext = ""
                        Else
                            GErrortext = Oracledt.Rows(i).Item(35).ToString
                        End If
                        WriteLog("GErrortext = " + GErrortext)

                        If Oracledt.Rows(i).Item(36).ToString Is Nothing Then
                            GAcknowledgmenttext = ""
                        Else
                            GAcknowledgmenttext = Oracledt.Rows(i).Item(36).ToString
                        End If
                        WriteLog("GAcknowledgmenttext = " + GAcknowledgmenttext)

                        If Oracledt.Rows(i).Item(37).ToString Is Nothing Then
                            GAcknowledgmentsyntax = ""
                        Else
                            GAcknowledgmentsyntax = Oracledt.Rows(i).Item(37).ToString
                        End If
                        WriteLog("GAcknowledgmentsyntax = " + GAcknowledgmentsyntax)

                        p_status = DRGBUILDER()

                        GTmpStr = "p_status - " & p_status & ", p_out - " & p_out
                        WriteLog(GTmpStr)

                        If p_status = "E" Then
                            WriteLog("Error Occured while executing DRGBUILDER() function")
                        End If

                        If p_status = "E" Then
                            p_err = Mid(p_out, 1, 3999)
                            p_out = ""
                        End If

                        update_message_status(GTrxno, p_msgout, p_err)
                        p_msgout = ""
                        p_err = ""

                    Next

                End With
            Else
                update_message_status(GTrxno, "", param_err_txt)
                param_err_txt = ""
            End If

            GTmpStr = "Closing Oracle Database connection"
            WriteLog(GTmpStr)

            'oraConnOpen(0) 'Closing Oracle Connection 'By Anil 30/11/09
            Oracledt.Clear()
            oracleDs.Clear()
            GoTo Terminate_Process
        Catch ex As Exception
            GTmpStr = "Error Occured while Processing requests - " & ex.ToString
            WriteLog(GTmpStr)
            MsgBox("Error Occured While Trying to Connect...")
            'oraConnOpen(0) 'Closing Oracle Connection 'By Anil 30/11/09
            p_runflag = "E"
            RunStatusUpd()
            Me.Close()

        End Try
Terminate_Process:
        ' Reset progressbar attribute
        Button1.BackColor = Color.White ' Idle
        Button1.ForeColor = Color.White ' Idle

        ' Enable process timer.
        RequestTimer.Enabled = True

        ' Close database connection
        'oraConnOpen(0) 'Closing Oracle Connection 'By Anil 30/11/09
Exit_sub:
        ' Reset progressbar attribute
        Button1.BackColor = Color.White ' Idle
        Button1.ForeColor = Color.White ' Idle

        ' Enable process timer.
        RequestTimer.Enabled = True
        Exit Sub
Close_sub:
        CurrTimer.Enabled = False
        RequestTimer.Enabled = False
        p_noconn_flag = "Y"
        oraConnOpen(1)
        'Me.Close()
    End Sub
    Private Function AnyNewRequest() As Integer

        'Dim cmd As New OracleCommand()
        'Dim oracleDa As New OracleDataAdapter(cmd)

        Dim cmd As New OleDbCommand()
        'Dim cmd As New OracleCommand()

        Dim oracleDa As New OleDbDataAdapter(cmd)
        'Dim oracleDa As New OracleDataAdapter(cmd)
        Dim oracleDs As New DataSet
        Dim Oracledt As New DataTable

        Try

            oraConnOpen(1) 'Opening Oracle Connection 'By Anil 30/11/09

            cmd.Connection = conn_ora

            WriteLog("Searching for new requests ... ")

            'cmd.CommandText = "SELECT COUNT(*) FROM XH_DRG_INTERFACE WHERE RESPONSE_TEXT IS NULL"
            'cmd.CommandText = "SELECT COUNT(*) FROM XH_INTERACTIVE_INTEGRATION WHERE RESPONSE_TEXT IS NULL AND ERROR_TEXT IS NULL AND PGM_ID = 'XBDRG'"
            cmd.CommandText = "SELECT COUNT(*) FROM XH_INTERACTIVE_INTEGRATION WHERE PGM_ID = 'XBDRG' AND STATUS = 'N'"

            ' AND RESPONSE_TEXT IS NULL AND ERROR_TEXT IS NULL" 'Index not getting utilised

            WriteLog("Count Query - " & cmd.CommandText)

            GTmpStr = "Executing Select Statement..."
            WriteLog(GTmpStr)

            oracleDa.Fill(oracleDs)

            Oracledt = oracleDs.Tables(0)

            AnyNewRequest = Oracledt.Rows(0).Item(0).ToString

            GTmpStr = "Count Statement Execution Over, Count of Request - " & AnyNewRequest.ToString
            WriteLog(GTmpStr)

            'oraConnOpen(0) 'Closing Oracle Connection 'By Anil 30/11/09

        Catch ex As Exception
            GTmpStr = "Error Occured while searching for requests - " & ex.ToString
            WriteLog(GTmpStr)
            CurrTimer.Enabled = False
            RequestTimer.Enabled = False
            WriteLog("Sleep Activation")
            System.Threading.Thread.Sleep(2000)
            WriteLog("Sleep Over")
            CurrTimer.Enabled = True
            RequestTimer.Enabled = True
            WriteLog("CurrTimer.Interval - " + CurrTimer.Interval.ToString)
            WriteLog("RequestTimer.Interval - " + RequestTimer.Interval.ToString)
            oraConnOpen(1)
            'Anl
            'MsgBox("Error Occured while searching for requests - " & ex.ToString, MsgBoxStyle.Critical)
            'AnyNewRequest = -1
            Exit Function
        End Try
    End Function
    Public Function DRGBUILDER() As String

        GTmpStr = "Inside DRGBUILDER Function"
        WriteLog(GTmpStr)

        Dim conn1 As New OleDbConnection
        Dim p_status As String

        Try
            Dim drg_data As String
            Dim rec As String
            Dim arr_record() As String
            Dim fld_sptr As String = "|"
            Dim i As Integer
            Dim j As Integer = 0
            Dim col As String = " "
            Dim dat As String = " "
            Dim outFieldCol As String

            out_folder = op_folder

            Try
                Dim p_seg_start_char As String = Chr(11)
                Dim p_seg_end_char As String = Chr(11)
                Dim p_msg_start_char As String = ""
                Dim p_msg_end_char As String = ""

                'For truncating the Message start + segment id + Field separator 
                GRequesttext = Mid(GRequesttext, 5)

                Dim reqtext As String = p_seg_start_char & GRequesttext & p_seg_end_char
                GTmpStr = "reqtext - " & reqtext
                WriteLog(GTmpStr)

                Dim lng As Integer = Len(reqtext)
                Dim msg1 As String = reqtext
                Dim msg2 As String = ""
                Dim msg3 As String = ""
                Dim msg4 As String = ""
                Dim tmp_lng As Integer = lng
                Dim field_locn As Integer = 0
                Dim seg_st_locn As Integer = 0
                Dim seg_end_locn As Integer = 0
                Dim p_ins_char As String = ""
                Dim cnt_col As Integer = 0

                GTmpStr = "Foxpro dbf Table Insert Statement Creation"
                WriteLog(GTmpStr)

                GTmpStr = "Splitting Messages"
                WriteLog(GTmpStr)

                GTmpStr = "Message Length - " & lng
                WriteLog(GTmpStr)

                While tmp_lng > 0

                    field_locn = InStr(msg1, fld_sptr, Microsoft.VisualBasic.CompareMethod.Text)
                    seg_st_locn = InStr(msg1, p_seg_start_char, Microsoft.VisualBasic.CompareMethod.Text)
                    seg_end_locn = InStr(msg1, p_seg_end_char, Microsoft.VisualBasic.CompareMethod.Text)

                    If field_locn < seg_st_locn Or seg_st_locn = 0 Then
                        If InStr(msg1, fld_sptr, Microsoft.VisualBasic.CompareMethod.Text) = 0 Then
                            If InStr(msg1, p_seg_end_char, Microsoft.VisualBasic.CompareMethod.Text) <> 0 Then
                                msg2 = Mid(msg1, 1, InStr(msg1, p_seg_end_char, Microsoft.VisualBasic.CompareMethod.Text) - 1)
                                msg4 = Mid(msg1, 1, InStr(msg1, p_seg_end_char, Microsoft.VisualBasic.CompareMethod.Text) + 1)
                                If Datatype_Convert(cnt_col + 1, msg2) = "Y" Then
                                    msg3 = msg3 & mod_col & ")"
                                Else
                                    msg3 = msg3 & "'" & mod_col & "'" & ")"
                                End If
                                cnt_col = cnt_col + 1
                                msg1 = Nothing
                                p_ins_char = "I"
                            Else
                                If InStr(msg1, p_msg_end_char, Microsoft.VisualBasic.CompareMethod.Text) <> 0 Then
                                    msg2 = Mid(msg1, 1, InStr(msg1, p_msg_end_char, Microsoft.VisualBasic.CompareMethod.Text) - 1)
                                    msg1 = Nothing
                                End If
                            End If
                        Else
                            msg2 = Mid(msg1, 1, InStr(msg1, fld_sptr, Microsoft.VisualBasic.CompareMethod.Text) - 1)
                            msg4 = Mid(msg1, 1, InStr(msg1, fld_sptr, Microsoft.VisualBasic.CompareMethod.Text) + 1)
                            If Datatype_Convert(cnt_col + 1, msg2) = "Y" Then
                                msg3 = msg3 & mod_col & ","
                            Else
                                msg3 = msg3 & "'" & mod_col & "'" & ","
                            End If
                            cnt_col = cnt_col + 1
                            msg1 = Mid(msg1, Len(msg4))
                        End If
                    Else
                        If seg_end_locn < seg_st_locn Then
                            msg2 = Mid(msg1, 1, InStr(msg1, p_seg_end_char, Microsoft.VisualBasic.CompareMethod.Text) - 1)
                            msg4 = Mid(msg1, 1, InStr(msg1, p_seg_end_char, Microsoft.VisualBasic.CompareMethod.Text) + 1)
                            If Datatype_Convert(cnt_col + 1, msg2) = "Y" Then
                                msg3 = msg3 & mod_col & ")"
                            Else
                                msg3 = msg3 & "'" & mod_col & "'" & ")"
                            End If
                            cnt_col = cnt_col + 1
                            msg1 = Mid(msg1, Len(msg4))
                            p_ins_char = "I"
                        Else
                            msg3 = "INSERT INTO " & table_name & col_hdng1 & " VALUES("
                            msg2 = Mid(msg1, 1, InStr(msg1, p_seg_start_char, Microsoft.VisualBasic.CompareMethod.Text) - 1)
                            msg4 = Mid(msg1, 1, InStr(msg1, p_seg_start_char, Microsoft.VisualBasic.CompareMethod.Text) + 1)
                            msg1 = Mid(msg1, Len(msg4))
                        End If
                    End If

                    If p_ins_char = "I" Then
                        GTmpStr = "Count Of Columns For Insertion - " & cnt_col
                        WriteLog(GTmpStr)
                        GTmpStr = "Insert Statement - " & msg3
                        WriteLog(GTmpStr)
                        drg_data = msg3
                        p_ins_char = ""
                        WriteLog(GTmpStr)
                    End If

                    tmp_lng = Len(msg1)

                End While

            Catch ex As Exception
                p_status = "E"
                GTmpStr = "Error While Trying to Split Message - " & ex.ToString()
                WriteLog(GTmpStr)
            End Try

            If p_status <> "E" Then

                GTmpStr = "drg_data-" & drg_data
                WriteLog(GTmpStr)

                GTmpStr = "Record splitting"
                WriteLog(GTmpStr)

                'inserting procedure retuned records into array 
                arr_record = Split(drg_data, Chr(13))

                GTmpStr = "Record splitting over"
                WriteLog(GTmpStr)

                i = 0

                Try
                    GTmpStr = "Opening OLEDB connection..."
                    WriteLog(GTmpStr)
                    conn1.Close()
                    conn1.ConnectionString = "Provider=VFPOLEDB.1;Data Source=" & op_folder & ";"
                    conn1.Open()

                    GTmpStr = "Connection Opened..."
                    WriteLog(GTmpStr)

                    GTmpStr = "Checking whether the DBF file exists or not..."
                    WriteLog(GTmpStr)

                    If fso.FileExists(ip_folder + "\" + table_name) Then
                        fso.DeleteFile(ip_folder + "\" + table_name)
                    End If

                    If Not fso.FileExists(ip_folder + "\" + table_name) Then
                        GTmpStr = "DBF file does no exist..."
                        WriteLog(GTmpStr)
                        'Table Creation stmt            
                        GTmpStr = "Foxpro dbf Table creation"
                        WriteLog(GTmpStr)

                        Dim createTableCmd As New OleDbCommand(col_hdng, conn1)
                        WriteLog(col_hdng)
                        createTableCmd.ExecuteNonQuery()
                        'MsgBox("Table Created")

                        GTmpStr = "Foxpro dbf Table creation Over"
                        WriteLog(GTmpStr)
                    End If

                    Dim insertCmd As OleDbCommand

                    'MsgBox(col_hdng)
                    'Record wise extraction of data
                    GTmpStr = "Foxpro dbf Table Insertion"
                    WriteLog(GTmpStr)

                    For i = 0 To UBound(arr_record)
                        rec = arr_record(i)
                        'Table Insert stmt     
                        If rec <> "" Then
                            insertCmd = New OleDbCommand(rec, conn1)
                            insertCmd.ExecuteNonQuery()
                        End If
                    Next

                    GTmpStr = "Foxpro dbf Table Insertion over"
                    WriteLog(GTmpStr)
                Catch ex As Exception
                    GTmpStr = "Error While Creating and Inserting Data into Foxpro dbf Table... " & ex.ToString
                    WriteLog(GTmpStr)
                    conn1.Close()
                    p_status = "E"
                    p_out = GTmpStr
                    DRGBUILDER = p_status
                    Exit Function
                End Try

                'MsgBox(ip_folder & "\" & ip_filenm)
                'MsgBox("Values Inserted")
                conn1.Close()
                GTmpStr = "Calling External Application"
                WriteLog(GTmpStr)

                'Stop ' To read the console and verify what happened
                'Execute the 3rd party application
                Dim objProcess As System.Diagnostics.Process
                Dim ProcessPath As String = ip_folder & "\" & exe_name
                Dim tbl_name As String = ip_folder & "\" & table_name
                GTmpStr = "App path - " & ProcessPath
                WriteLog(GTmpStr)
                GTmpStr = "tbl_name - " & tbl_name
                WriteLog(GTmpStr)

                Try
                    objProcess = New System.Diagnostics.Process()
                    objProcess.StartInfo.FileName = ProcessPath
                    objProcess.StartInfo.Arguments = tbl_name
                    objProcess.StartInfo.WindowStyle = ProcessWindowStyle.Normal

                    GTmpStr = "External application Starts"
                    WriteLog(GTmpStr)

                    objProcess.Start()
                    'Wait until the process passes back an exit code 

                    GTmpStr = "Waiting For exit of External application"
                    WriteLog(GTmpStr)

                    objProcess.WaitForExit()
                    'Free resources associated with this process 
                    objProcess.Close()

                    GTmpStr = "Extracting values from updated DBF"
                    WriteLog(GTmpStr)

                    'Extracting values from out DBF
                    conn1.Open()
                    Dim selectcmd As New OleDbCommand("SELECT * FROM " & table_name, conn1)
                    selectcmd.ExecuteNonQuery()

                    Dim outDa As New OleDbDataAdapter(selectcmd)
                    Dim outDs As New DataSet
                    Dim outDt As DataTable
                    outDa.Fill(outDs)
                    outDt = outDs.Tables(0)

                    i = 0
                    j = 0

                    'Creation of msg that is to be sent back to eHIS
                    GTmpStr = "Message Creation by extracting values from updated DBF"
                    WriteLog(GTmpStr)

                    GTmpStr = "Record count-" & outDt.Rows.Count - 1
                    WriteLog(GTmpStr)
                    p_msgout = ""

                    For i = 0 To outDt.Rows.Count - 1
                        If i <> 0 Then
                            p_msgout = p_msgout & Chr(13)
                        End If

                        For j = 0 To outDt.Columns.Count - 1
                            If j = 0 Then
                                p_msgout = Chr(11) + "DRG"
                                p_msgout = p_msgout & "|" & outDt.Rows(i).Item(j).ToString
                            Else
                                'If outDt.Columns.Item(j).ColumnName = "Callos" Then
                                'p_msgout = p_msgout & "|@#$" & outDt.Rows(i).Item(j).ToString
                                'Else

                                If outDt.Columns.Item(j).ColumnName = "drg" Then
                                    outFieldCol = "$$Drg$$"
                                ElseIf outDt.Columns.Item(j).ColumnName = "rw" Then
                                    outFieldCol = "$$Rw$$"
                                ElseIf outDt.Columns.Item(j).ColumnName = "ot" Then
                                    outFieldCol = "$$Ot$$"
                                ElseIf outDt.Columns.Item(j).ColumnName = "wtlos" Then
                                    outFieldCol = "$$Wtlos$$"
                                ElseIf outDt.Columns.Item(j).ColumnName = "mdc" Then
                                    outFieldCol = "$$Mdc$$"
                                ElseIf outDt.Columns.Item(j).ColumnName = "err" Then
                                    outFieldCol = "$$Err$$"
                                ElseIf outDt.Columns.Item(j).ColumnName = "warn" Then
                                    outFieldCol = "$$Warn$$"
                                ElseIf outDt.Columns.Item(j).ColumnName = "result" Then
                                    outFieldCol = "$$Result$$"
                                ElseIf outDt.Columns.Item(j).ColumnName = "callos" Then
                                    outFieldCol = "$$Callos$$"
                                ElseIf outDt.Columns.Item(j).ColumnName = "adjrw" Then
                                    outFieldCol = "$$Adjrw$$"
                                Else
                                    outFieldCol = ""
                                End If

                                p_msgout = p_msgout & "|" & outFieldCol & outDt.Rows(i).Item(j).ToString
                                'End If
                            End If
                        Next
                    Next

                    GTmpStr = "p_msgout-" & p_msgout
                    WriteLog(GTmpStr)

                    GTmpStr = "Message Creation by extracting values from updated DBF over"
                    WriteLog(GTmpStr)

                    GTmpStr = "Function DRGBUILDER Over"
                    WriteLog(GTmpStr)

                    p_status = "S"
                    p_out = p_msgout
                    GTmpStr = "p_status - " & p_status & ", p_out - " & p_out
                    WriteLog(GTmpStr)
                    DRGBUILDER = p_status
                    conn1.Close()
                Catch ex As Exception
                    'MsgBox("Could not start process " & ProcessPath)
                    p_status = "E"
                    p_out = "Could not start process" & ProcessPath
                    DRGBUILDER = p_status
                    'DRGBUILDER = "Could not start process" & ProcessPath
                    GTmpStr = "Could not start process  " & ProcessPath & " - " & ex.ToString
                    WriteLog(GTmpStr)
                    objProcess.Close()
                End Try
            Else
                DRGBUILDER = p_status
            End If
        Catch ex As Exception
            p_status = "E"
            p_out = ex.ToString()
            DRGBUILDER = p_status
            GTmpStr = "Error" & ex.ToString()
            WriteLog(GTmpStr)
            conn1.Close()
        End Try
    End Function
    Private Function convert(ByVal p_char As String) As String
        Dim tmpmsg As String = p_char
        Dim charlen As Integer = Len(p_char)
        Dim charleft As String = ""
        Dim actualchar As String = ""
        Dim ln As Integer = 0
        Dim ln1 As Integer = 0

        GTmpStr = "Inside Convert Function"
        WriteLog(GTmpStr)
        GTmpStr = "Arguments - p_char - " & p_char
        WriteLog(GTmpStr)

        Try
            While charlen > 0
                ln = InStr(tmpmsg, "|")

                If ln = Nothing Then
                    ln = 0
                    charleft = Mid(tmpmsg, 1)
                    ln1 = 0
                Else
                    ln = InStr(tmpmsg, "|") - 1
                    charleft = Mid(tmpmsg, 1, ln)
                End If

                If ln1 = Nothing And ln = 0 Then
                    tmpmsg = Nothing
                Else
                    tmpmsg = Mid(tmpmsg, ln + 2)
                End If

                charlen = Len(tmpmsg)
                actualchar = actualchar & Chr(charleft)
            End While

            GTmpStr = "Conversion Over Actual Character - " & actualchar
            WriteLog(GTmpStr)
            convert = actualchar
        Catch ex As Exception
            GTmpStr = "Error Occured while trying to Convert Special Character from Ascii to Actual - " & ex.ToString
            WriteLog(GTmpStr)
            convert = "ERROR"
        End Try
    End Function

    Private Function Table_create(ByVal p_path As String, ByVal p_filenm As String)

        GTmpStr = "Argument List --> p_path - " & p_path & ", p_filenm - " & p_filenm
        WriteLog(GTmpStr)

        Dim file = p_path & "\" & p_filenm & ".txt"

        GTmpStr = "file - " & file
        WriteLog(GTmpStr)

        Try
            GTmpStr = "Checking the existance of file "
            WriteLog(GTmpStr)
            If fso.FileExists(p_path) Then
                GTmpStr = "Foxpro Table Configuration File could Not be Found"
                WriteLog(GTmpStr)
                Table_create = "E"
            Else
                GTmpStr = "Reading the file - " & file
                WriteLog(GTmpStr)
                Dim fs As New FileStream(file, FileMode.OpenOrCreate, FileAccess.Read)
                Dim Str As New StreamReader(fs)
                Str.BaseStream.Seek(0, SeekOrigin.Begin)
                'Str.ReadLine()
                Table_create = Str.ReadLine()
                Str.Close()
            End If
        Catch ex As Exception
            GTmpStr = "Error Occured while trying to read Table Configuration File - " & ex.ToString
            WriteLog(GTmpStr)
            Table_create = "X"
        End Try
    End Function

    Private Sub update_message_status(ByVal p_msgid As String, ByVal p_resp_txt As String, ByVal p_err_txt As String)
        Dim cmd As New OleDbCommand()
        'Dim cmd As New OracleCommand()
        Dim oracleDa As New OleDbDataAdapter(cmd)
        Dim oracledt As New DataTable
        Dim oracleds As New DataSet

        Dim OfflinePurgeYn As String

        Dim InterStatus As String

        If p_msgid <> "" Then
            GTmpStr = "Inside Updating_Message_Status Procedure"
            WriteLog(GTmpStr)

            GTmpStr = "Argument List --> p_request_no - " & p_msgid & ", p_resp_txt - " & p_resp_txt & ", p_err_txt - " & p_err_txt
            WriteLog(GTmpStr)

            oraConnOpen(1) 'Opening Oracle Connection 'By Anil 30/11/09

            cmd.Connection = conn_ora

            cmd.CommandText = "SELECT OFFLINE_PURGE_YN FROM XH_PARAM"

            WriteLog("Offline Purge Flag fetch Query - " & cmd.CommandText)

            GTmpStr = "Executing Select Statement..."
            WriteLog(GTmpStr)

            oracleDa.Fill(oracleDs)

            Oracledt = oracleDs.Tables(0)

            OfflinePurgeYn = oracledt.Rows(0).Item(0).ToString

            GTmpStr = "Purge Yes/No - " & OfflinePurgeYn.ToString
            WriteLog(GTmpStr)

            Try
                'oraConnOpen(1) 'Opening Oracle Connection 'By Anil 30/11/09

                'cmd.Connection = conn_ora

                If p_err_txt <> "" Then

                    If InStr(p_err_txt, Chr(13)) > 0 Then
                        p_err_txt = Mid(p_err_txt, 1, InStr(p_err_txt, Chr(13)) - 1)
                    End If

                    If InStr(p_err_txt, Chr(11)) > 0 Then
                        p_err_txt = Mid(p_err_txt, 1, InStr(p_err_txt, Chr(11)) - 1)
                    End If

                    InterStatus = "E"
                Else
                    InterStatus = "S"
                End If

                cmd.CommandText = "UPDATE  XH_INTERACTIVE_INTEGRATION" & _
                                  " SET    RESPONSE_TEXT = '" & p_resp_txt & "'," & _
                                  " ERROR_TEXT = '" & p_err_txt & "'," & _
                                  " STATUS = '" & InterStatus & "' " & _
                                  " WHERE TRX_NO = '" & p_msgid & "'" & _
                                  " AND PGM_ID = 'XBDRG' "

                '" AND RESPONSE_TEXT is NULL " & _


                GTmpStr = "Update Statement - " & cmd.CommandText
                WriteLog(GTmpStr)

                cmd.ExecuteNonQuery()

                GTmpStr = "Update Statement Execution Over"
                WriteLog(GTmpStr)

                If OfflinePurgeYn = "Y" Then

                    GTmpStr = "Purging the Record from XH_INTERACTIVE_INTEGRATION..."
                    WriteLog(GTmpStr)

                    cmd.CommandText = "DELETE XH_INTERACTIVE_INTEGRATION" & _
                                      " WHERE TRX_NO = '" & p_msgid & "'" & _
                                      " AND PGM_ID = 'XBDRG' "

                    GTmpStr = "Purge Statement - " & cmd.CommandText
                    WriteLog(GTmpStr)

                    cmd.ExecuteNonQuery()

                    GTmpStr = "Purge Statement Execution Over"
                    WriteLog(GTmpStr)

                End If

                GTmpStr = "Commit Statement Execution..."
                WriteLog(GTmpStr)
                cmd.CommandText = "COMMIT"
                cmd.ExecuteNonQuery()

                GTmpStr = "Commit Statement Execution Over"
                WriteLog(GTmpStr)

                InterStatus = ""

                'oraConnOpen(0) 'Closing Oracle Connection 'By Anil 30/11/09

            Catch ex As Exception
                'oraConnOpen(0) 'Closing Oracle Connection 'By Anil 30/11/09
                GTmpStr = "Error While Trying to update Message Status - " & ex.ToString
                WriteLog(GTmpStr)
            End Try
        Else
            Try

                oraConnOpen(1) 'Opening Oracle Connection 'By Anil 30/11/09

                cmd.Connection = conn_ora

                cmd.CommandText = "SELECT OFFLINE_PURGE_YN FROM XH_PARAM"

                oracleDa.Fill(oracleds)

                oracledt = oracleds.Tables(0)

                OfflinePurgeYn = oracledt.Rows(0).Item(0).ToString

                'oraConnOpen(1) 'Opening Oracle Connection 'By Anil 30/11/09

                'cmd.Connection = conn_ora

                If p_err_txt <> "" Then
                    InterStatus = "E"
                Else
                    InterStatus = "S"
                End If

                cmd.CommandText = "UPDATE  XH_INTERACTIVE_INTEGRATION" & _
                                  " SET    RESPONSE_TEXT = '" & p_resp_txt & "'," & _
                                  " ERROR_TEXT = '" & p_err_txt & "'," & _
                                  " STATUS = '" & InterStatus & "' " & _
                                  " WHERE STATUS = 'N'" & _
                                  " AND PGM_ID = 'XBDRG' "

                cmd.ExecuteNonQuery()

                If OfflinePurgeYn = "Y" Then
                    cmd.CommandText = "DELETE XH_INTERACTIVE_INTEGRATION" & _
                                      " WHERE TRX_NO = '" & p_msgid & "'" & _
                                      " AND PGM_ID = 'XBDRG' "

                    cmd.ExecuteNonQuery()
                End If

                cmd.CommandText = "COMMIT"
                cmd.ExecuteNonQuery()

                'oraConnOpen(0) 'Closing Oracle Connection 'By Anil 30/11/09

            Catch ex As Exception
                'oraConnOpen(0) 'Closing Oracle Connection  'By Anil 30/11/09 
            End Try

        End If
    End Sub

    Private Function Datatype_Convert(ByVal col_cnt As Integer, ByVal col_val As String) As String
        Dim col_datatype As String
        Dim l_plc As Integer
        Dim l_val As String

        Try
            l_plc = InStr(col_dt, "@" & col_cnt & "#")

            If l_plc > 0 Then
                l_val = Mid(col_dt, l_plc)
                col_datatype = Mid(l_val, InStr(l_val, "#") + 1, 1)

                mod_col = Nothing
                If col_datatype = "D" Then
                    mod_col = Replace("{^" & col_val & "}", "'", "")
                    Datatype_Convert = "Y"
                ElseIf col_datatype = "N" Then
                    mod_col = Replace(col_val, "'", "")
                    If mod_col = Nothing Then
                        mod_col = 0
                    End If
                    Datatype_Convert = "Y"
                Else
                    Datatype_Convert = "N"
                    mod_col = col_val
                End If
            Else
                Datatype_Convert = "N"
                mod_col = col_val
            End If
        Catch ex As Exception
            Datatype_Convert = "N"
            GTmpStr = "Error While Trying to Convert based on Datatype - " & ex.ToString
            WriteLog(GTmpStr)
        End Try
    End Function
    Private Sub set_meduser_role()
        Dim OraroleId As String = "MEDUSERS"
        Dim Orarolepwd As String = Nothing

        'Dim cmd As New OracleCommand()
        'Dim oracleDa As New OracleDataAdapter(cmd)
        'Dim oracledr As OracleDataReader

        Dim cmd As New OleDbCommand()
        'Dim cmd As New OracleCommand()
        cmd.Connection = conn_ora
        Dim oracleDa As New OleDbDataAdapter(cmd)
        'Dim oracleDa As New OracleDataAdapter(cmd)
        Dim oracleDs As New DataSet
        Dim Oracledt As New DataTable
        Dim oracledr As OleDbDataReader
        'Dim oracledr As OracleDataReader

        Try

            'WriteLog("Inside Setting Medusers role Method ... ")

            cmd.CommandText = "SELECT ORA_ROLE_PASSWORD FROM SM_ORA_ROLE WHERE ORA_ROLE_ID = '" & OraroleId & "'"

            'GTmpStr = "Executing Select Statement..."
            'WriteLog(GTmpStr)

            oracleDa.Fill(oracleDs)

            Oracledt = oracleDs.Tables(0)

            Orarolepwd = Oracledt.Rows(0).Item(0).ToString

            Try

                'GTmpStr = "Calling Password Decrypt function..."
                'WriteLog(GTmpStr)

                cmd.CommandText = "SELECT APP_PASSWORD.DECRYPT('" & Orarolepwd & "') FROM DUAL"

                'GTmpStr = "Executing Password Decrypt function..."
                'WriteLog(GTmpStr)

                oracledr = cmd.ExecuteReader(CommandBehavior.SingleResult)
                oracledr.Read()


                'GTmpStr = "Function Executed..."
                'WriteLog(GTmpStr)

                Orarolepwd = oracledr(0)
                oracledr.Close()
            Catch ex As Exception
                GTmpStr = "Error Occured while Decrypting... - " & ex.ToString
                'WriteLog(GTmpStr)
            End Try

            Try
                'WriteLog("Setting Medusers role...")

                'WriteLog("Stement Creation...")
                cmd.CommandText = "SET ROLE " & OraroleId & " IDENTIFIED BY " & Orarolepwd & ""

                'WriteLog("Statement Execution...")
                cmd.ExecuteNonQuery()

                'WriteLog("Statement Executed...")
                'WriteLog("Medusers Role Successfully set...")
            Catch ex As Exception
                GTmpStr = "Error Occured while Setting Medusers role... - " & ex.ToString
                'WriteLog(GTmpStr)
            End Try

        Catch ex As Exception
            GTmpStr = "Error Occured - " & ex.ToString
            'WriteLog(GTmpStr)
        End Try
    End Sub

    Private Sub FetchInidata()
        Dim ininame As String = "DRG.ini"

        Try
            WriteLog("")
            WriteLog("Fetching Values from ini file...")
            WriteLog("")

            table_name = INIRead(ininame, "DRG", "TABLE_NAME", "Unknown")
            WriteLog("table_name = " & table_name)

            op_folder = INIRead(ininame, "DRG", "DBF_SOURCE_DIRECTORY", "Unknown")
            WriteLog("op_folder = " & op_folder)

            op_filenm = INIRead(ininame, "DRG", "OUTPUT_DBF_FILE_NAME", "Unknown")
            WriteLog("op_filenm = " & op_filenm)

            ip_folder = INIRead(ininame, "DRG", "DBF_DESTINATION_DIRECTORY", "Unknown")
            WriteLog("ip_folder = " & ip_folder)

            ip_filenm = INIRead(ininame, "DRG", "INPUT_DBF_FILE_NAME", "Unknown")
            WriteLog("ip_filenm = " & ip_filenm)

            exe_name = INIRead(ininame, "DRG", "EXTERNAL_EXE", "Unknown")
            WriteLog("exe_name = " & exe_name)

            col_hdng = INIRead(ininame, "DRG", "TABLE_CREATE", "Unknown")
            WriteLog("col_hdng = " & col_hdng)

            col_hdng1 = INIRead(ininame, "DRG", "COLUMN_HEADING", "Unknown")
            WriteLog("col_hdng1 = " & col_hdng1)

            col_dt = INIRead(ininame, "DRG", "COLUMN_DT", "Unknown")
            WriteLog("col_dt = " & col_dt)

            Gtraceyn = INIRead(ininame, "DRG", "TRACE_YN", "Unknown")
            WriteLog("Gtraceyn = " & Gtraceyn)

        Catch ex As Exception
            WriteLog("Error Occured while trying to fetch Data from " & ininame & " file - " & ex.ToString)
        End Try

    End Sub
    Private Sub FetchParam()

        Dim cmd As New OleDbCommand()
        'Dim cmd As New OracleCommand()
        Dim oracleDa As New OleDbDataAdapter(cmd)
        'Dim oracleDa As New OracleDataAdapter(cmd)
        Dim oracleDs As New DataSet
        Dim Oracledt As New DataTable
        Dim rec_cnt As Integer = 0

        Dim l_fetch_str As String

        Try

            oraConnOpen(1) 'Opening Oracle Connection 'By Anil 30/11/09

            cmd.Connection = conn_ora

            cmd.CommandText = "SELECT DBF_TABLE_NAME,DBF_SOURCE_DIRECTORY,DBF_DEST_DIRECTORY,EXTERNAL_EXE_NAME,DBF_TABLE_CREATE_STMT,DBF_COLUMN_HDNG,DBF_COLUMN_DT,DBF_TRACE_YN,LOG_DIR FROM XB_PARAM WHERE PROFILE_ID = 'SRRDRG1'"

            oracleDa.Fill(oracleDs)

            Oracledt = oracleDs.Tables(0)

            table_name = Oracledt.Rows(0).Item(0).ToString

            l_fetch_str = "Fetching Initialization Parameters..."

            l_fetch_str = l_fetch_str + vbNewLine + Format(Now, "dd/MM/yyyy hh:mm:ss tt") + "   " + "table_name - " + table_name

            If table_name = "" Then
                param_status = "E"
                param_err_txt = "DBF Table Name not specified in Param"
            End If

            l_fetch_str = "Fetching Initialization Parameters..."

            op_folder = Oracledt.Rows(0).Item(1).ToString
            l_fetch_str = l_fetch_str + vbNewLine + Format(Now, "dd/MM/yyyy hh:mm:ss tt") + "   " + "op_folder = " & op_folder

            If op_folder = "" Then
                param_status = "E"
                param_err_txt = param_err_txt + vbNewLine + "DBF Source Directory not specified in Param"
            End If

            ip_folder = Oracledt.Rows(0).Item(2).ToString
            l_fetch_str = l_fetch_str + vbNewLine + Format(Now, "dd/MM/yyyy hh:mm:ss tt") + "   " + "ip_folder = " & ip_folder

            If ip_folder = "" Then
                param_status = "E"
                param_err_txt = param_err_txt + vbNewLine + "DBF Destination Directory not specified in Param"
                MsgBox("External Application Directory Not Specified...", MsgBoxStyle.Critical)
                anyerr = "Y"
                'oraConnOpen(0) 'Closing Oracle Connection 'By Anil 30/11/09
                Me.Close()
                Exit Sub
            Else
                If FolderExists(ip_folder) = False Then
                    MsgBox("External Application Directory Not Found...", MsgBoxStyle.Critical)
                    anyerr = "Y"
                    'oraConnOpen(0) 'Closing Oracle Connection 'By Anil 30/11/09
                    Me.Close()
                    Exit Sub
                End If
            End If

            exe_name = Oracledt.Rows(0).Item(3).ToString
            l_fetch_str = l_fetch_str + vbNewLine + Format(Now, "dd/MM/yyyy hh:mm:ss tt") + "   " + "exe_name = " & exe_name

            If exe_name = "" Then
                param_status = "E"
                param_err_txt = param_err_txt + vbNewLine + "External Executable Name not specified in Param"
            End If

            col_hdng = Oracledt.Rows(0).Item(4).ToString
            l_fetch_str = l_fetch_str + vbNewLine + Format(Now, "dd/MM/yyyy hh:mm:ss tt") + "   " + "col_hdng = " & col_hdng

            If col_hdng = "" Then
                param_status = "E"
                param_err_txt = param_err_txt + vbNewLine + "DBF Table Create Statement not specified in Param"
            End If

            col_hdng1 = Oracledt.Rows(0).Item(5).ToString
            l_fetch_str = l_fetch_str + vbNewLine + Format(Now, "dd/MM/yyyy hh:mm:ss tt") + "   " + "col_hdng1 = " & col_hdng1

            If col_hdng1 = "" Then
                param_status = "E"
                param_err_txt = param_err_txt + vbNewLine + "DBF Table Column Heading not specified in Param"
            End If

            col_dt = Oracledt.Rows(0).Item(6).ToString
            l_fetch_str = l_fetch_str + vbNewLine + Format(Now, "dd/MM/yyyy hh:mm:ss tt") + "   " + "col_dt = " & col_dt

            If col_dt = "" Then
                param_status = "E"
                param_err_txt = param_err_txt + vbNewLine + "DBF Table Column Datatype not specified in Param"
            End If

            Gtraceyn = Oracledt.Rows(0).Item(7).ToString

            If Gtraceyn = "" Then
                Gtraceyn = "N"
            End If

            l_fetch_str = l_fetch_str + vbNewLine + Format(Now, "dd/MM/yyyy hh:mm:ss tt") + "   " + "Gtraceyn = " & Gtraceyn

            log_dir = Oracledt.Rows(0).Item(8).ToString

            l_fetch_str = l_fetch_str + vbNewLine + Format(Now, "dd/MM/yyyy hh:mm:ss tt") + "   " + "log_dir = " & log_dir

            If Gtraceyn = "Y" Then
                If log_dir = "" Then
                    'log_dir = "C:\eHIS\reports"
                    GFolderpath = log_dir
                    l_fetch_str = l_fetch_str + vbNewLine + Format(Now, "dd/MM/yyyy hh:mm:ss tt") + "   " + "Log Directory is Null, defaulting to C:\eHIS\reports"
                    l_fetch_str = l_fetch_str + vbNewLine + Format(Now, "dd/MM/yyyy hh:mm:ss tt") + "   " + "log_dir = " & log_dir

                    If FolderExists(GFolderpath) = False Then
                        If CreateFolder() = 1 Then
                            MsgBox("Exception While trying to create Log Directory - " + p_folderCreation_err, MsgBoxStyle.Critical)
                            anyerr = "Y"
                            'oraConnOpen(0) 'Closing Oracle Connection 'By Anil 30/11/09
                            Me.Close()
                            Exit Sub
                        End If
                    End If
                Else
                    GFolderpath = log_dir

                    If FolderExists(GFolderpath) = False Then
                        If CreateFolder() = 1 Then
                            MsgBox("Exception While trying to create Log Directory - " + p_folderCreation_err, MsgBoxStyle.Critical)
                            'oraConnOpen(0) 'Closing Oracle Connection 'By Anil 30/11/09
                            anyerr = "Y"
                            Me.Close()
                            Exit Sub
                        End If
                    End If
                End If
            End If

            WriteLog(l_fetch_str)

            If anyerr = "Y" Then
                Exit Sub
            End If

            If param_status = "" Then
                param_status = "S"
            End If

            'oraConnOpen(0) 'Closing Oracle Connection 'By Anil 30/11/09

        Catch ex As Exception
            param_status = "E"
            anyerr = "Y"
            MsgBox("Error while fetching Parameter... " + Mid(ex.ToString, 1, InStr(ex.ToString, Chr(13))), MsgBoxStyle.Critical)
            'oraConnOpen(0) 'Closing Oracle Connection 'By Anil 30/11/09
            Me.Close()
        End Try
    End Sub

    Public Sub ODBCConnTest()
        Try
            conn_ora = New OleDbConnection(connectionString)
            'conn_ora = New OracleConnection(connectionString)
            conn_ora.Open()
            conn_ora.Close()
        Catch ex As Exception
            MsgBox("Error while ODBC Connection..." + Mid(ex.ToString, 1, InStr(ex.ToString, Chr(13))), MsgBoxStyle.Critical)
            p_noconn_flag = "Y"
            Me.Close()
        End Try

    End Sub
    Public Function FolderExists(ByVal FolderPath As String) As Boolean

        Dim f As New IO.DirectoryInfo(FolderPath)
        Return f.Exists

    End Function

    Public Function CreateFolder() As Integer
        Try
            MkDir(GFolderpath)
            Return 0
        Catch ex As Exception
            p_folderCreation_err = ex.ToString
            Return 1

        End Try

    End Function
    Public Sub oraConnOpen(ByVal p_state As Integer)

        Dim cmd As New OleDbCommand
        'Dim cmd As New OracleCommand()

        Try

            If p_state = 1 Then
                If conn_ora.State = ConnectionState.Closed Then

                    conn_ora = New OleDbConnection(connectionString)
                    'conn_ora = New OracleConnection(connectionString)
                    conn_ora.Open()
                    
                    set_meduser_role()
                    cmd.Connection = conn_ora
                    cmd.CommandText = "SELECT 1 from dual"
                    cmd.ExecuteNonQuery()

                    If p_conn_restart = "Y" Then
                        p_runflag = "S"
                        RunStatusUpd()
                    End If

                End If
            ElseIf p_state = 0 Then
                If conn_ora.State = 1 Then
                    conn_ora.Close()
                End If
            End If

        Catch ex As Exception
            If p_state = 1 Then
                'MsgBox("Error While Opening ODBC Connection - " + ex.ToString, MsgBoxStyle.Critical)
                WriteLog(ex.ToString)
                System.Threading.Thread.Sleep(10000)
                p_conn_restart = "Y"
                oraConnOpen(1)
            Else
                MsgBox("Error While Closing ODBC Connection - " + ex.ToString, MsgBoxStyle.Critical)
            End If
            'Me.Close()
        End Try
    End Sub

    Public Sub InteractiveParamfetch()
        Dim cmd As New OleDbCommand
        'Dim cmd As New OracleCommand
        Dim oracleDa As New OleDbDataAdapter(cmd)
        'Dim oracleDa As New OracleDataAdapter(cmd)
        Dim oracleDs As New DataSet
        Dim Oracledt As New DataTable

        Try

            cmd.Connection = conn_ora

            cmd.CommandText = "SELECT sleepinterval FROM xh_interactive_connect_param WHERE plugin_type = 'XBDRG'"

            oracleDa.Fill(oracleDs)

            Oracledt = oracleDs.Tables(0)

            GSleepTime = Oracledt.Rows(0).Item(0).ToString

        Catch ex As Exception
            GSleepTime = 10
        End Try

    End Sub
End Class

