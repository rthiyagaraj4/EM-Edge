<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class DRGInterface
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.components = New System.ComponentModel.Container
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(DRGInterface))
        Me.Label1 = New System.Windows.Forms.Label
        Me.CurrTimer = New System.Windows.Forms.Timer(Me.components)
        Me.RequestTimer = New System.Windows.Forms.Timer(Me.components)
        Me.Currtime = New System.Windows.Forms.Label
        Me.MsgText = New System.Windows.Forms.Label
        Me.Button1 = New System.Windows.Forms.Button
        Me.SuspendLayout()
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Font = New System.Drawing.Font("Book Antiqua", 14.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label1.ForeColor = System.Drawing.Color.FromArgb(CType(CType(192, Byte), Integer), CType(CType(255, Byte), Integer), CType(CType(255, Byte), Integer))
        Me.Label1.Location = New System.Drawing.Point(37, 31)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(217, 23)
        Me.Label1.TabIndex = 0
        Me.Label1.Text = "IBAeHIS DRG Processor"
        '
        'CurrTimer
        '
        '
        'RequestTimer
        '
        '
        'Currtime
        '
        Me.Currtime.AutoSize = True
        Me.Currtime.Location = New System.Drawing.Point(181, 15)
        Me.Currtime.Name = "Currtime"
        Me.Currtime.Size = New System.Drawing.Size(0, 13)
        Me.Currtime.TabIndex = 2
        '
        'MsgText
        '
        Me.MsgText.AutoSize = True
        Me.MsgText.Location = New System.Drawing.Point(21, 120)
        Me.MsgText.Name = "MsgText"
        Me.MsgText.Size = New System.Drawing.Size(0, 13)
        Me.MsgText.TabIndex = 3
        '
        'Button1
        '
        Me.Button1.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.Button1.ForeColor = System.Drawing.Color.Green
        Me.Button1.Location = New System.Drawing.Point(26, 75)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(17, 29)
        Me.Button1.TabIndex = 4
        Me.Button1.UseVisualStyleBackColor = True
        '
        'DRGInterface
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackColor = System.Drawing.Color.Navy
        Me.ClientSize = New System.Drawing.Size(281, 136)
        Me.Controls.Add(Me.Button1)
        Me.Controls.Add(Me.MsgText)
        Me.Controls.Add(Me.Currtime)
        Me.Controls.Add(Me.Label1)
        Me.ForeColor = System.Drawing.Color.White
        Me.Icon = CType(resources.GetObject("$this.Icon"), System.Drawing.Icon)
        Me.MaximizeBox = False
        Me.Name = "DRGInterface"
        Me.Text = "DRG Interface"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents CurrTimer As System.Windows.Forms.Timer
    Friend WithEvents RequestTimer As System.Windows.Forms.Timer
    Friend WithEvents Currtime As System.Windows.Forms.Label
    Friend WithEvents MsgText As System.Windows.Forms.Label
    Friend WithEvents Button1 As System.Windows.Forms.Button

End Class
