VERSION 5.00
Begin VB.UserControl IBAPhotoCap 
   BackColor       =   &H00EFEFEF&
   ClientHeight    =   5475
   ClientLeft      =   0
   ClientTop       =   0
   ClientWidth     =   11385
   ScaleHeight     =   365
   ScaleMode       =   3  'Pixel
   ScaleWidth      =   759
   Begin VB.ListBox List1 
      Height          =   2790
      ItemData        =   "IBAPhotoCap.ctx":0000
      Left            =   11280
      List            =   "IBAPhotoCap.ctx":0002
      TabIndex        =   22
      Top             =   840
      Visible         =   0   'False
      Width           =   2175
   End
   Begin VB.Frame Frame3 
      BackColor       =   &H00EFEFEF&
      Caption         =   "Capture New Image"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   8.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   4035
      Left            =   5760
      TabIndex        =   20
      Top             =   600
      Width           =   5295
      Begin VB.PictureBox Picture2 
         BackColor       =   &H00EFEFEF&
         Height          =   3495
         Left            =   240
         ScaleHeight     =   3435
         ScaleWidth      =   4755
         TabIndex        =   21
         Top             =   360
         Width           =   4815
      End
      Begin VB.Image Image1 
         Height          =   3465
         Left            =   240
         Top             =   360
         Width           =   4785
      End
   End
   Begin VB.CommandButton cmdStart 
      Caption         =   "Start"
      Height          =   435
      Left            =   8280
      TabIndex        =   19
      Top             =   4800
      Width           =   1095
   End
   Begin VB.CommandButton cmdSave 
      Caption         =   "Save"
      Enabled         =   0   'False
      Height          =   435
      Left            =   7065
      TabIndex        =   18
      Top             =   4800
      Width           =   1095
   End
   Begin VB.CommandButton cmdSize 
      Caption         =   "Size"
      Height          =   375
      Left            =   2160
      TabIndex        =   17
      Top             =   4680
      Width           =   855
   End
   Begin VB.CommandButton cmdOpt 
      Caption         =   "Option"
      Height          =   375
      Left            =   3120
      TabIndex        =   16
      Top             =   4680
      Width           =   855
   End
   Begin VB.FileListBox File1 
      Height          =   285
      Left            =   8505
      Pattern         =   "*.XYZ"
      TabIndex        =   12
      Top             =   180
      Visible         =   0   'False
      Width           =   465
   End
   Begin VB.TextBox patSeqNo 
      Enabled         =   0   'False
      Height          =   345
      Left            =   1515
      TabIndex        =   11
      Top             =   120
      Width           =   2535
   End
   Begin VB.CheckBox Check1 
      Height          =   195
      Left            =   195
      TabIndex        =   10
      Top             =   4800
      Width           =   195
   End
   Begin VB.Frame Frame1 
      BackColor       =   &H00EFEFEF&
      Caption         =   "Patient Photo"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   8.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   4035
      Left            =   240
      TabIndex        =   8
      Top             =   600
      Width           =   5295
      Begin VB.Label noImageLabel 
         BackColor       =   &H00EFEFEF&
         Caption         =   "Photo Not Available"
         BeginProperty Font 
            Name            =   "Arial Black"
            Size            =   9.75
            Charset         =   0
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   315
         Left            =   1395
         TabIndex        =   9
         Top             =   1710
         Visible         =   0   'False
         Width           =   2265
      End
      Begin VB.Image Image3 
         Height          =   3540
         Left            =   225
         Stretch         =   -1  'True
         Top             =   315
         Width           =   4785
      End
   End
   Begin VB.PictureBox Picture1 
      BackColor       =   &H00E0E0E0&
      Height          =   285
      Left            =   4680
      ScaleHeight     =   225
      ScaleMode       =   0  'User
      ScaleWidth      =   12.532
      TabIndex        =   7
      Top             =   4920
      Visible         =   0   'False
      Width           =   225
   End
   Begin VB.Timer Timer1 
      Enabled         =   0   'False
      Left            =   7155
      Top             =   120
   End
   Begin VB.Frame Frame2 
      BackColor       =   &H00EFEFEF&
      Caption         =   "Patient Details"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   8.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   285
      Left            =   10680
      TabIndex        =   0
      Top             =   120
      Visible         =   0   'False
      Width           =   375
      Begin VB.Label ageVal 
         BackColor       =   &H00E0E0E0&
         BackStyle       =   0  'Transparent
         BeginProperty Font 
            Name            =   "Arial"
            Size            =   8.25
            Charset         =   0
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   255
         Left            =   5265
         TabIndex        =   6
         Top             =   360
         Width           =   555
      End
      Begin VB.Label sexLabel 
         BackColor       =   &H00E0E0E0&
         BackStyle       =   0  'Transparent
         Caption         =   "Sex :"
         BeginProperty Font 
            Name            =   "Arial"
            Size            =   8.25
            Charset         =   0
            Weight          =   700
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   255
         Left            =   7245
         TabIndex        =   5
         Top             =   360
         Width           =   390
      End
      Begin VB.Label sexval 
         BackColor       =   &H00E0E0E0&
         BackStyle       =   0  'Transparent
         BeginProperty Font 
            Name            =   "Arial"
            Size            =   8.25
            Charset         =   0
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   255
         Left            =   7740
         TabIndex        =   4
         Top             =   360
         Width           =   750
      End
      Begin VB.Label patNameVal 
         BackColor       =   &H00E0E0E0&
         BackStyle       =   0  'Transparent
         BeginProperty Font 
            Name            =   "Arial"
            Size            =   8.25
            Charset         =   0
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   255
         Left            =   945
         TabIndex        =   3
         Top             =   360
         Width           =   2760
      End
      Begin VB.Label patNameLabel 
         BackColor       =   &H00E0E0E0&
         BackStyle       =   0  'Transparent
         Caption         =   "Name :"
         BeginProperty Font 
            Name            =   "Arial"
            Size            =   8.25
            Charset         =   0
            Weight          =   700
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   255
         Left            =   270
         TabIndex        =   2
         Top             =   360
         Width           =   675
      End
      Begin VB.Label ageLabel 
         BackColor       =   &H00E0E0E0&
         BackStyle       =   0  'Transparent
         Caption         =   "Age :"
         BeginProperty Font 
            Name            =   "Arial"
            Size            =   8.25
            Charset         =   0
            Weight          =   700
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   255
         Left            =   4770
         TabIndex        =   1
         Top             =   360
         Width           =   465
      End
   End
   Begin VB.Label lblSelectDriver 
      BackColor       =   &H00EFEFEF&
      Caption         =   "Select The Driver"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   222
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   375
      Left            =   11280
      TabIndex        =   23
      Top             =   480
      Visible         =   0   'False
      Width           =   2175
   End
   Begin VB.Label patID 
      BackColor       =   &H00E0E0E0&
      BackStyle       =   0  'Transparent
      Caption         =   "Patient ID"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   9
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   255
      Left            =   255
      TabIndex        =   15
      Top             =   180
      Width           =   975
   End
   Begin VB.Image Image2 
      Height          =   315
      Left            =   5040
      Top             =   4920
      Visible         =   0   'False
      Width           =   330
   End
   Begin VB.Label Label1 
      Alignment       =   1  'Right Justify
      BackColor       =   &H00E0E0E0&
      Height          =   315
      Left            =   9735
      TabIndex        =   14
      Top             =   120
      Width           =   705
   End
   Begin VB.Label Label2 
      BackColor       =   &H00E0E0E0&
      BackStyle       =   0  'Transparent
      Caption         =   "Cha&nge Settings"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   9
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   255
      Left            =   495
      TabIndex        =   13
      Top             =   4800
      Width           =   1455
   End
End
Attribute VB_Name = "IBAPhotoCap"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = True
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = True
Private m_TimeToCapture_milliseconds As Integer
Private m_Width As Long
Private m_Height As Long
Private mCapHwnd As Long
'Public bStopped As Boolean
Dim formatStrings() As String
Dim conn As ADODB.Connection
Dim rsPatInfo As ADODB.Recordset
Dim SQLPatInfo As String

Public Patient_ID As String

Private Sub Check1_Click()
If (Check1.Value = 1) Then
    cmdSize.Enabled = True
    cmdOpt.Enabled = True
Else
    cmdOpt.Enabled = False
    cmdSize.Enabled = False
End If
End Sub
Private Sub cmdCapture_Click()
DebugLog ("Inside cmdCapture_Click()")
    bStopped = True
DebugLog "bStopped=" & bStopped
    Timer1.Enabled = False
    ' disconnect from the video source
    DoEvents
    If mCapHwnd <> 0 Then Call SendMessage(mCapHwnd, WM_CAP_DISCONNECT, 0, 0)
    mCapHwnd = 0
    
    cmdOpt.Enabled = False
    cmdSize.Enabled = False
    cmdCapture.Enabled = False
    cmdStart.Enabled = True
    cmdSave.Enabled = True
    cmdSave.SetFocus
End Sub

Private Sub loadImage()
DebugLog ("Inside loadImage()")
On Error GoTo Err_blk
    
    Dim FormatFields() As String
    Dim SQLValidate As String
    Dim patID As String
    Set rsPatInfo = New ADODB.Recordset
    Set conn = New ADODB.Connection
    Dim count As Integer
    patSeqNo.Text = UCase(patSeqNo.Text)
    patID = UCase(patSeqNo.Text)
    conn.Open ConnectingString
    
    SQLPatInfo = "select count(*) cnt from " & patient_table & " where " & photo_table_pk & " = '" & patID & "'"
    DebugLog SQLPatInfo
    rsPatInfo.Open SQLPatInfo, conn
    PatCount = rsPatInfo!cnt

    If (PatCount = 0) Then
    DebugLog "1"
        MsgBox "Patient ID does not exist", vbOKOnly + vbCritical, "Photo Capture"
        cmdStart.SetFocus
        Exit Sub
   End If
    DebugLog "2"
    LoadFromDB UCase(patSeqNo.Text), Image3, noImageLabel
    DebugLog "3"
    cmdStart.Enabled = True
    patSeqNo.Enabled = False
proc_exit:
    Set rsPatInfo = Nothing
    Set conn = Nothing
    Exit Sub
Err_blk:
    Writelog ("On Load Image    :  " & err.Description)
    MsgBox "On Load Image   :" & err.Description
    Resume proc_exit
End Sub


Private Sub cmdOpt_Click()
On Error Resume Next
  If mCapHwnd <> 0 Then Call SendMessage(mCapHwnd, WM_CAP_DLG_VIDEOSOURCE, 0, 0)
  DoEvents
End Sub

Private Sub cmdSave_Click()

DebugLog ("Inside cmdSave_Click()")
On Error GoTo except_blk
    Dim file_name As String
    DoEvents
'
'    If Dir(App.Path & "\myPic", vbDirectory) = "" Then MkDir (App.Path & "\myPic")
'    File1.Path = App.Path & "\myPic"
    'File1.Pattern = "*.bmp"
    '    File1.Path = LocalPath
    '    File1.Pattern = "*.jpg"
    '    File1.Refresh
    '
    '
'    Dim Maxnum As Integer, ii As Integer
'    For ii = 0 To File1.ListCount - 1
'        If Left(File1.List(ii), 1) = "p" Then
'            If CInt(Mid(File1.List(ii), 2, Len(File1.List(ii)) - 4)) > Maxnum Then
'                Maxnum = CInt(Mid(File1.List(ii), 2, Len(File1.List(ii)) - 4))
'            End If
'        End If
'    Next
 
   'SavePicture Image1.Picture, App.Path & "\myPic\p" & Maxnum + 1 & ".bmp"
   
    If Dir(LocalPath, vbDirectory) = "" Then MkDir (LocalPath)
    Set Image2.Picture = hDCToPicture(GetDC(Picture2.hwnd), 0, 0, 320, 240)
    Picture1.Picture = Image2.Picture
 
    SAVEJPEG LocalPath & "\pic.jpg", 100, Picture1
 'MsgBox (LocalPath & "\pic.jpg")
    'SAVEJPEG App.Path & "\myPic\" & Format(Date, "dd_MM_yyyy") & " " & Format(Time, "hhmmss") & ".jpg", 100, Picture1
    ' Picture1.Picture = Image1.Picture
 '   SAVEJPEG App.Path & "\myPic\p" & Maxnum + 1 & ".jpg", 100, Me.Picture1
  '  SaveToDB App.Path & "\myPic\p" & Maxnum + 1 & ".jpg", 1
     'SAVEJPEG LocalPath & "\pic.jpg", 100, Picture1

DebugLog "cmdSave_Click:1"
     SaveToDB LocalPath & "\pic.jpg", patSeqNo.Text, Picture1, Image2
DebugLog "cmdSave_Click:2"
    'SaveToDB App.Path & "\myPic\p" & Maxnum + 1 & ".jpg", CInt(patSeqNo.Text)
    DoEvents
    cmdStart.Enabled = True
    'cmdCapture.Enabled = False
    'cmdSave.Enabled = False

DebugLog "cmdSave_Click:3"
    LoadFromDB patSeqNo.Text, Image3, noImageLabel
DebugLog "cmdSave_Click:4"
    bStopped = True
DebugLog "bStopped=" & bStopped
    Timer1.Enabled = False
    ' disconnect from the video source
    If mCapHwnd <> 0 Then Call SendMessage(mCapHwnd, WM_CAP_DISCONNECT, 0, 0)
    mCapHwnd = 0
DebugLog "cmdSave_Click:5"
    Image1.Picture = LoadPicture("")
DebugLog "cmdSave_Click:6"
    MsgBox "Photo captured", vbInformation, "Photo Capture"
    file_name = LocalPath & "\pic.jpg"
   
    DebugLog "cmdSave_Click:7"
    Kill file_name
DebugLog "cmdSave_Click:8"
    'Image3.Picture = LoadPicture(LocalPath & "\p.jpg")
    'Image3.Refresh
    
    'patSeqNo.SetFocus
    cmdStart.SetFocus

resume_blk:
cmdStart.Enabled = False
    Exit Sub

except_blk:
    MsgBox "cmdSave_Click:" & err.Description
    Resume resume_blk
     
End Sub

Private Sub cmdSave1_Click()
If Dir(App.Path & "\myPic", vbDirectory) = "" Then MkDir (App.Path & "\myPic")
    Set Image2.Picture = hDCToPicture(GetDC(Picture2.hwnd), 0, 0, 320, 240)
    Picture1.Picture = Image2.Picture
 
    SAVEJPEG App.Path & "\myPic\" & Format(Date, "dd_MM_yyyy") & " " & Format(Time, "hhmmss") & ".jpg", 100, Picture1
End Sub

Private Sub cmdSize_Click()
On Error Resume Next
    If mCapHwnd <> 0 Then Call SendMessage(mCapHwnd, WM_CAP_DLG_VIDEOFORMAT, 0, 0)
    DoEvents
End Sub

Private Sub cmdStart_Click()
'patSeqNo.Text = "A100001213"
If (patSeqNo.Text = "") Then
     MsgBox "Patient ID cannot be blank", vbOKOnly + vbInformation, "Photo Capture"
Exit Sub
End If
     
     
' If List1.ListCount = 1 Then
'    List1.ListIndex = 0
'
' Else
'    If List1.ListCount = 0 Then Exit Sub
'       If List1.ListCount > 1 Then
'         lblSelectDriver.Visible = True
'         List1.Visible = True
'            If List1.ListIndex = -1 Then
'            MsgBox "Please Select the Driver"
'            Exit Sub
'       End If
'   End If
'End If
    
    Dim lpszName As String * 100
    Dim lpszVer As String * 100
    Dim Caps As CAPDRIVERCAPS

    '//Create Capture Window
    capGetDriverDescriptionA 0, lpszName, 100, lpszVer, 100  '// Retrieves driver info
    hHwnd = capCreateCaptureWindowA(lpszName, WS_CHILD Or WS_VISIBLE, 0, 0, 500, 400, Picture2.hwnd, 0)

    '// Connect the capture window to the driver
    capDriverConnect hHwnd, 0

    '// Get the capabilities of the capture driver
    capDriverGetCaps hHwnd, VarPtr(Caps), Len(Caps)

    '// Set the video stream callback function
    capSetCallbackOnVideoStream hHwnd, AddressOf MyVideoStreamCallback
    capSetCallbackOnFrame hHwnd, AddressOf MyFrameCallback

    '// Set the preview rate in milliseconds
    capPreviewRate hHwnd, 66

    '// Start previewing the image from the camera
    capPreview hHwnd, True
        
'modWebCam.OpenPreviewWindow List1.ListIndex, Picture2
cmdSave.Enabled = True
End Sub

Private Sub patSeqNo_Change()
'DebugLog ("Inside PatSeqNo_Change")
Patient_ID = patSeqNo.Text
End Sub
Public Property Get hwnd() As Long
DebugLog ("Inside Get hwnd()")
' Makes the control's hWnd available at runtime

hwnd = Picture2.hwnd
End Property

Private Sub Timer1_Timer()
DebugLog ("Inside Timer1..")
On Error Resume Next
   ' pause the timer
    Timer1.Enabled = False
    
    
    ' get the next frame;
    If mCapHwnd <> 0 Then Call SendMessage(mCapHwnd, WM_CAP_GET_FRAME, 0, 0)
    ' copy the frame to the clipboard
    If mCapHwnd <> 0 Then Call SendMessage(mCapHwnd, WM_CAP_COPY, 0, 0)

    ' For some reason, the API is not resizing the video
    ' feed to the width and height provided when the video
    ' feed was started, so we must resize the image here
    ' Image1.Stretch = True
    ' get from the clipboard
    Image1.Picture = Clipboard.GetData
         
    ' restart the timer
    DoEvents
'DebugLog "In Timer..bStopped=" & bStopped
    If Not bStopped Then
        'DebugLog "Not Stopped"
        Timer1.Enabled = True
    End If
End Sub

Private Sub UserControl_Initialize()

Check1.Visible = False
Label2.Visible = False
cmdSize.Visible = False
cmdOpt.Visible = False
'modWebCam.LoadDeviceList List1

'cmdSave.Enabled = True
DebugLog ("Inside UserControl_Initialize()")
On Error Resume Next
Dim flag As Boolean

DebugLog "V3 Changes 1"

Label1.BackStyle = 0 ' CheckBox
Label4.BackStyle = 0 ' Form Caption
Label5.BackStyle = 0 ' Form Close
    m_TimeToCapture_milliseconds = 100
    m_Width = 352
    m_Height = 288
    bStopped = True
DebugLog "bStopped=" & bStopped
    mCapHwnd = 0
'Call LoadConfiguration
patSeqNo.MaxLength = Patient_ID_Len
cmdSize.Enabled = False
cmdOpt.Enabled = False
flag = LoadConfiguration

If (flag = False) Then
    patSeqNo.Enabled = False
    cmdLoad.Enabled = False
    cmdClear.Enabled = False
    Frame1.Enabled = False
    Frame3.Enabled = False
    cmdSave.Enabled = False
    cmdCapture.Enabled = False
    cmdStart.Enabled = False
    patID.Enabled = False
    Frame2.Enabled = False
    patNameLabel.Enabled = False
    ageLabel.Enabled = False
    sexLabel.Enabled = False
    Label2.Enabled = False
    
End If
'cmdStart.Enabled = False
End Sub

Private Sub UserControl_Terminate()
DebugLog ("Inside UserControl_Terminate()")
  Call StopWork
End Sub

Public Sub Initialize_Patient_ID(patID As String)
DebugLog ("Inside Initialize_Patient_ID(" & patID & ")")
    UserControl.patSeqNo.Text = patID
    Call loadImage
End Sub
Public Sub Terminate_Capture()
DebugLog ("Inside Terminate_Capture()")
Call StopWork
End Sub
