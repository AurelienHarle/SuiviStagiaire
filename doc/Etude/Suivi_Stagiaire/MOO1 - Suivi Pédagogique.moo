<?xml version="1.0" encoding="UTF-8"?>
<?PowerDesigner AppLocale="UTF16" ID="{7264583F-3B14-4DD8-845D-25B00667F6E7}" Label="" LastModificationDate="1497870921" Name="MOO1 - Suivi Pédagogique" Objects="126" Symbols="12" Target="Java" TargetLink="Reference" Type="{18112060-1A4B-11D1-83D9-444553540000}" signature="CLD_OBJECT_MODEL" version="15.2.0.3042"?>
<!-- Veuillez ne pas modifier ce fichier -->

<Model xmlns:a="attribute" xmlns:c="collection" xmlns:o="object">

<o:RootObject Id="o1">
<c:Children>
<o:Model Id="o2">
<a:ObjectID>7264583F-3B14-4DD8-845D-25B00667F6E7</a:ObjectID>
<a:Name>MOO1 - Suivi Pédagogique</a:Name>
<a:Code>MOO1___SUIVI_PEDAGOGIQUE</a:Code>
<a:CreationDate>1497870906</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870918</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {850354A3-94EE-475F-A039-998E8DDF4F80}
DAT 1497870918
ATT </a:History>
<a:PackageOptionsText>[FolderOptions]

[FolderOptions\Class Diagram Objects]
GenerationCheckModel=Yes
GenerationPath=C:\Users\Afpa\Desktop\Nouveau dossier\
GenerationOptions=
GenerationTasks=
GenerationTargets=
GenerationSelections=</a:PackageOptionsText>
<a:ModelOptionsText>[ModelOptions]

[ModelOptions\Cld]
CaseSensitive=Yes
DisplayName=Yes
EnableTrans=Yes
EnableRequirements=No
ShowClss=No
DeftAttr=int
DeftMthd=int
DeftParm=int
DeftCont=java.util.Collection
DomnDttp=Yes
DomnChck=No
DomnRule=No
SupportDelay=No
PreviewEditable=Yes
AutoRealize=No
DttpFullName=Yes
DeftClssAttrVisi=private
VBNetPreprocessingSymbols=
CSharpPreprocessingSymbols=

[ModelOptions\Cld\NamingOptionsTemplates]

[ModelOptions\Cld\ClssNamingOptions]

[ModelOptions\Cld\ClssNamingOptions\CLDPCKG]

[ModelOptions\Cld\ClssNamingOptions\CLDPCKG\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,,,firstLowerWord)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDPCKG\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDDOMN]

[ModelOptions\Cld\ClssNamingOptions\CLDDOMN\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDDOMN\Code]
Template=
MaxLen=254
Case=U
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDCLASS]

[ModelOptions\Cld\ClssNamingOptions\CLDCLASS\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,,,FirstUpperChar)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDCLASS\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDINTF]

[ModelOptions\Cld\ClssNamingOptions\CLDINTF\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,,,FirstUpperChar)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDINTF\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\UCDACTR]

[ModelOptions\Cld\ClssNamingOptions\UCDACTR\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\UCDACTR\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\UCDUCAS]

[ModelOptions\Cld\ClssNamingOptions\UCDUCAS\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\UCDUCAS\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\SQDOBJT]

[ModelOptions\Cld\ClssNamingOptions\SQDOBJT\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\SQDOBJT\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\SQDMSSG]

[ModelOptions\Cld\ClssNamingOptions\SQDMSSG\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\SQDMSSG\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CPDCOMP]

[ModelOptions\Cld\ClssNamingOptions\CPDCOMP\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,,,FirstUpperChar)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CPDCOMP\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDATTR]

[ModelOptions\Cld\ClssNamingOptions\CLDATTR\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,,,firstLowerWord)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDATTR\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDMETHOD]

[ModelOptions\Cld\ClssNamingOptions\CLDMETHOD\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,,,firstLowerWord)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDMETHOD\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDPARM]

[ModelOptions\Cld\ClssNamingOptions\CLDPARM\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,,,firstLowerWord)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDPARM\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\OOMPORT]

[ModelOptions\Cld\ClssNamingOptions\OOMPORT\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\OOMPORT\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\OOMPART]

[ModelOptions\Cld\ClssNamingOptions\OOMPART\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\OOMPART\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDASSC]

[ModelOptions\Cld\ClssNamingOptions\CLDASSC\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,,,firstLowerWord)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDASSC\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\UCDASSC]

[ModelOptions\Cld\ClssNamingOptions\UCDASSC\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\UCDASSC\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\GNRLLINK]

[ModelOptions\Cld\ClssNamingOptions\GNRLLINK\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\GNRLLINK\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\RQLINK]

[ModelOptions\Cld\ClssNamingOptions\RQLINK\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\RQLINK\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\RLZSLINK]

[ModelOptions\Cld\ClssNamingOptions\RLZSLINK\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\RLZSLINK\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DEPDLINK]

[ModelOptions\Cld\ClssNamingOptions\DEPDLINK\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DEPDLINK\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\OOMACTV]

[ModelOptions\Cld\ClssNamingOptions\OOMACTV\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\OOMACTV\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\ACDOBST]

[ModelOptions\Cld\ClssNamingOptions\ACDOBST\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\ACDOBST\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\STAT]

[ModelOptions\Cld\ClssNamingOptions\STAT\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\STAT\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DPDNODE]

[ModelOptions\Cld\ClssNamingOptions\DPDNODE\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DPDNODE\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DPDCMPI]

[ModelOptions\Cld\ClssNamingOptions\DPDCMPI\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DPDCMPI\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DPDASSC]

[ModelOptions\Cld\ClssNamingOptions\DPDASSC\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DPDASSC\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\OOMVAR]

[ModelOptions\Cld\ClssNamingOptions\OOMVAR\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\OOMVAR\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\FILO]

[ModelOptions\Cld\ClssNamingOptions\FILO\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=&quot;\/:*?&lt;&gt;|&quot;
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\FILO\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_. &quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\FRMEOBJ]

[ModelOptions\Cld\ClssNamingOptions\FRMEOBJ\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\FRMEOBJ\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\FRMELNK]

[ModelOptions\Cld\ClssNamingOptions\FRMELNK\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\FRMELNK\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DefaultClass]

[ModelOptions\Cld\ClssNamingOptions\DefaultClass\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DefaultClass\Code]
Template=
MaxLen=254
Case=U
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Generate]

[ModelOptions\Generate\Cdm]
CheckModel=Yes
SaveLinks=Yes
NameToCode=No
Notation=2

[ModelOptions\Generate\Pdm]
CheckModel=Yes
SaveLinks=Yes
ORMapping=No
NameToCode=No
BuildTrgr=No
TablePrefix=
IndxPKName=%TABLE%_PK
IndxAKName=%TABLE%_AK
IndxFKName=%REFR%_FK
IndxThreshold=
ColnFKName=%.3:PARENT%_%COLUMN%
ColnFKNameUse=No

[ModelOptions\Generate\Xsm]
CheckModel=Yes
SaveLinks=Yes
ORMapping=No
NameToCode=No</a:ModelOptionsText>
<a:Author>Aurélien Harlé</a:Author>
<a:Version>1</a:Version>
<c:GenerationOrigins>
<o:Shortcut Id="o3">
<a:ObjectID>A3424C4D-F0B4-4EF1-9905-AF4DDD9106F6</a:ObjectID>
<a:Name>MPD1 - Suivi Pédagogique</a:Name>
<a:Code>MPD1___SUIVI_PEDAGOGIQUE</a:Code>
<a:CreationDate>1497870921</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870921</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:TargetStereotype/>
<a:TargetID>850354A3-94EE-475F-A039-998E8DDF4F80</a:TargetID>
<a:TargetClassID>CDE44E21-9669-11D1-9914-006097355D9B</a:TargetClassID>
</o:Shortcut>
</c:GenerationOrigins>
<c:ObjectLanguage>
<o:Shortcut Id="o4">
<a:ObjectID>C885FEF6-BD1C-4C87-8412-1AF75E2947C1</a:ObjectID>
<a:Name>Java</a:Name>
<a:Code>Java</a:Code>
<a:CreationDate>1497870906</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870906</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:TargetStereotype/>
<a:TargetID>0DEDDB90-46E2-45A0-886E-411709DA0DC9</a:TargetID>
<a:TargetClassID>1811206C-1A4B-11D1-83D9-444553540000</a:TargetClassID>
</o:Shortcut>
</c:ObjectLanguage>
<c:ExtendedModelDefinitions>
<o:Shortcut Id="o5">
<a:ObjectID>392B5D0B-F125-42A2-886C-6899076A39A8</a:ObjectID>
<a:Name>WSDL for Java</a:Name>
<a:Code>WSDLJava</a:Code>
<a:CreationDate>1497870916</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870916</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:TargetStereotype/>
<a:TargetID>C8F5F7B2-CF9D-4E98-8301-959BB6E86C8A</a:TargetID>
<a:TargetClassID>186C8AC3-D3DC-11D3-881C-00508B03C75C</a:TargetClassID>
</o:Shortcut>
</c:ExtendedModelDefinitions>
<c:ClassDiagrams>
<o:ClassDiagram Id="o6">
<a:ObjectID>B45BEE81-AE01-4673-9351-FF231AA574B3</a:ObjectID>
<a:Name>MPD1.3 - AutoEval</a:Name>
<a:Code>MPD1_3___AUTOEVAL</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {976F8468-5430-4C92-8A08-0D860FD456F0}
DAT 1497870918
ORG {0C445857-D29B-44E7-A47A-E69B3EBC4CFF}
DAT 1497516127
ORG {A0A1F6AF-D6A2-4849-895A-E3A2C5B86989}
DAT 1497516062
ATT DIAGNAME
ATT DISPNAME
ATT CODE</a:History>
<a:DisplayPreferences>[DisplayPreferences]

[DisplayPreferences\CLD]

[DisplayPreferences\General]
Adjust to text=Yes
Snap Grid=No
Constrain Labels=Yes
Display Grid=No
Show Page Delimiter=Yes
Grid size=0
Graphic unit=2
Window color=255, 255, 255
Background image=
Background mode=8
Watermark image=
Watermark mode=8
Show watermark on screen=No
Gradient mode=0
Gradient end color=255, 255, 255
Show Swimlane=No
SwimlaneVert=Yes
TreeVert=No
CompDark=0

[DisplayPreferences\Object]
Show Icon=No
Mode=2
Trunc Length=40
Word Length=40
Word Text=!&quot;#$%&amp;&#39;)*+,-./:;=&gt;?@\]^_`|}~
Shortcut IntIcon=Yes
Shortcut IntLoct=Yes
Shortcut IntFullPath=No
Shortcut IntLastPackage=Yes
Shortcut ExtIcon=Yes
Shortcut ExtLoct=No
Shortcut ExtFullPath=No
Shortcut ExtLastPackage=Yes
Shortcut ExtIncludeModl=Yes
EObjShowStrn=Yes
ExtendedObject.Comment=No
ExtendedObject.IconPicture=No
ExtendedObject_SymbolLayout=&lt;Form&gt;[CRLF] &lt;StandardAttribute Name=&quot;Stéréotype&quot; Attribute=&quot;Stereotype&quot; Prefix=&quot;&amp;lt;&amp;lt;&quot; Suffix=&quot;&amp;gt;&amp;gt;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardAttribute Name=&quot;Nom de l&amp;#39;objet&quot; Attribute=&quot;DisplayName&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;Yes&quot; /&gt;[CRLF] &lt;Separator Name=&quot;Séparateur&quot; /&gt;[CRLF] &lt;StandardAttribute Name=&quot;Commentaire&quot; Attribute=&quot;Comment&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;LEFT&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardAttribute Name=&quot;Icône&quot; Attribute=&quot;IconPicture&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;Yes&quot; /&gt;[CRLF]&lt;/Form&gt;
ELnkShowStrn=Yes
ELnkShowName=Yes
ExtendedLink_SymbolLayout=&lt;Form&gt;[CRLF] &lt;Form Name=&quot;Centre&quot; &gt;[CRLF]  &lt;StandardAttribute Name=&quot;Stéréotype&quot; Attribute=&quot;Stereotype&quot; Prefix=&quot;&amp;lt;&amp;lt;&quot; Suffix=&quot;&amp;gt;&amp;gt;&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF]  &lt;StandardAttribute Name=&quot;Nom&quot; Attribute=&quot;DisplayName&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;/Form&gt;[CRLF] &lt;Form Name=&quot;Source&quot; &gt;[CRLF] &lt;/Form&gt;[CRLF] &lt;Form Name=&quot;Destination&quot; &gt;[CRLF] &lt;/Form&gt;[CRLF]&lt;/Form&gt;
FileObject.Stereotype=No
FileObject.DisplayName=Yes
FileObject.LocationOrName=No
FileObject.IconPicture=No
FileObject.IconMode=Yes
FileObject_SymbolLayout=&lt;Form&gt;[CRLF] &lt;StandardAttribute Name=&quot;Stéréotype&quot; Attribute=&quot;Stereotype&quot; Prefix=&quot;&amp;lt;&amp;lt;&quot; Suffix=&quot;&amp;gt;&amp;gt;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;ExclusiveChoice Name=&quot;Choix exclusif&quot; Mandatory=&quot;Yes&quot; Display=&quot;HorizontalRadios&quot; &gt;[CRLF]  &lt;StandardAttribute Name=&quot;Nom&quot; Attribute=&quot;DisplayName&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF]  &lt;StandardAttribute Name=&quot;Emplacement&quot; Attribute=&quot;LocationOrName&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;/ExclusiveChoice&gt;[CRLF] &lt;StandardAttribute Name=&quot;Icône&quot; Attribute=&quot;IconPicture&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;Yes&quot; /&gt;[CRLF]&lt;/Form&gt;
Package.Stereotype=Yes
Package.Comment=No
Package.IconPicture=No
Package_SymbolLayout=&lt;Form&gt;[CRLF] &lt;StandardAttribute Name=&quot;Stéréotype&quot; Attribute=&quot;Stereotype&quot; Prefix=&quot;&amp;lt;&amp;lt;&quot; Suffix=&quot;&amp;gt;&amp;gt;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardAttribute Name=&quot;Nom&quot; Attribute=&quot;DisplayName&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;Yes&quot; /&gt;[CRLF] &lt;Separator Name=&quot;Séparateur&quot; /&gt;[CRLF] &lt;StandardAttribute Name=&quot;Commentaire&quot; Attribute=&quot;Comment&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;LEFT&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardAttribute Name=&quot;Icône&quot; Attribute=&quot;IconPicture&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;Yes&quot; /&gt;[CRLF]&lt;/Form&gt;
Display Model Version=Yes
Generalization.DisplayedStereotype=Yes
Generalization.DisplayName=No
Generalization.DisplayedRules=Yes
Generalization_SymbolLayout=&lt;Form&gt;[CRLF] &lt;Form Name=&quot;Centre&quot; &gt;[CRLF]  &lt;StandardAttribute Name=&quot;Stéréotype&quot; Attribute=&quot;DisplayedStereotype&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF]  &lt;StandardAttribute Name=&quot;Nom&quot; Attribute=&quot;DisplayName&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF]  &lt;StandardAttribute Name=&quot;Contrainte&quot; Attribute=&quot;DisplayedRules&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;/Form&gt;[CRLF] &lt;Form Name=&quot;Source&quot; &gt;[CRLF] &lt;/Form&gt;[CRLF] &lt;Form Name=&quot;Destination&quot; &gt;[CRLF] &lt;/Form&gt;[CRLF]&lt;/Form&gt;
Realization.DisplayedStereotype=Yes
Realization.DisplayName=No
Realization.DisplayedRules=Yes
Realization_SymbolLayout=
Dependency.DisplayedStereotype=Yes
Dependency.DisplayName=No
Dependency.DisplayedRules=Yes
Dependency_SymbolLayout=&lt;Form&gt;[CRLF] &lt;Form Name=&quot;Centre&quot; &gt;[CRLF]  &lt;StandardAttribute Name=&quot;Stéréotype&quot; Attribute=&quot;DisplayedStereotype&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF]  &lt;StandardAttribute Name=&quot;Nom&quot; Attribute=&quot;DisplayName&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF]  &lt;StandardAttribute Name=&quot;Contrainte&quot; Attribute=&quot;DisplayedRules&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;/Form&gt;[CRLF] &lt;Form Name=&quot;Source&quot; &gt;[CRLF] &lt;/Form&gt;[CRLF] &lt;Form Name=&quot;Destination&quot; &gt;[CRLF] &lt;/Form&gt;[CRLF]&lt;/Form&gt;
Class.Stereotype=Yes
Class.Constraint=Yes
Class.Attributes=Yes
Class.Attributes._Columns=DisplayVisibilityMarker Stereotype DataType InitialValue
Class.Attributes._Limit=-3
Class.Operations=Yes
Class.Operations._Columns=DisplayVisibilityMarker Stereotype SignatureWithParameters ReturnType
Class.Operations._Limit=-3
Class.InnerClassifiers=Yes
Class.Comment=No
Class.IconPicture=No
Class_SymbolLayout=&lt;Form&gt;[CRLF] &lt;StandardAttribute Name=&quot;Stéréotype&quot; Attribute=&quot;Stereotype&quot; Prefix=&quot;&amp;lt;&amp;lt;&quot; Suffix=&quot;&amp;gt;&amp;gt;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardAttribute Name=&quot;Nom de classe&quot; Attribute=&quot;DisplayedQualifiedName&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;Yes&quot; /&gt;[CRLF] &lt;StandardAttribute Name=&quot;Contrainte&quot; Attribute=&quot;Constraint&quot; Prefix=&quot;{&quot; Suffix=&quot;}&quot; Alignment=&quot;RGHT&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;Separator Name=&quot;Séparateur&quot; /&gt;[CRLF] &lt;StandardCollection Name=&quot;Attributs&quot; Collection=&quot;Attributes&quot; Columns=&quot;DisplayVisibilityMarker No\r\nDisplayVisibilityKeyword No\r\nDisplayVisibilityIcon No\r\nStereotype No\r\nDisplayName Yes\r\nDataType No\r\nDomain No\r\nInitialValue No&quot; HasLimit=&quot;Yes&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardCollection Name=&quot;Opérations&quot; Collection=&quot;Operations&quot; Columns=&quot;DisplayVisibilityMarker No\r\nDisplayVisibilityKeyword No\r\nDisplayVisibilityIcon No\r\nStereotype No\r\nSignatureWithoutParameters No\r\nSignatureWithParameters No\r\nReturnType No&quot; HasLimit=&quot;Yes&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardCollection Name=&quot;Classificateurs internes&quot; Collection=&quot;InnerClassifiers&quot; Columns=&quot;DisplayInnerIcon Yes\r\nDisplayNameGeneric Yes&quot; HasLimit=&quot;No&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardAttribute Name=&quot;Commentaire&quot; Attribute=&quot;Comment&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;LEFT&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardAttribute Name=&quot;Icône&quot; Attribute=&quot;IconPicture&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;Yes&quot; /&gt;[CRLF]&lt;/Form&gt;
Interface.Stereotype=Yes
Interface.Constraint=Yes
Interface.Attributes=Yes
Interface.Attributes._Columns=DisplayVisibilityMarker Stereotype DataType InitialValue
Interface.Attributes._Limit=-3
Interface.Operations=Yes
Interface.Operations._Columns=DisplayVisibilityMarker Stereotype SignatureWithParameters ReturnType
Interface.Operations._Limit=-3
Interface.InnerClassifiers=Yes
Interface.Comment=No
Interface.IconPicture=No
Interface_SymbolLayout=&lt;Form&gt;[CRLF] &lt;StandardAttribute Name=&quot;Stéréotype&quot; Attribute=&quot;Stereotype&quot; Prefix=&quot;&amp;lt;&amp;lt;&quot; Suffix=&quot;&amp;gt;&amp;gt;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardAttribute Name=&quot;Nom d&amp;#39;interface&quot; Attribute=&quot;DisplayedQualifiedName&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;Yes&quot; /&gt;[CRLF] &lt;StandardAttribute Name=&quot;Contrainte&quot; Attribute=&quot;Constraint&quot; Prefix=&quot;{&quot; Suffix=&quot;}&quot; Alignment=&quot;RGHT&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;Separator Name=&quot;Séparateur&quot; /&gt;[CRLF] &lt;StandardCollection Name=&quot;Attributs&quot; Collection=&quot;Attributes&quot; Columns=&quot;DisplayVisibilityMarker No\r\nDisplayVisibilityKeyword No\r\nDisplayVisibilityIcon No\r\nStereotype No\r\nDisplayName Yes\r\nDataType No\r\nDomain No\r\nInitialValue No&quot; HasLimit=&quot;Yes&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardCollection Name=&quot;Opérations&quot; Collection=&quot;Operations&quot; Columns=&quot;DisplayVisibilityMarker No\r\nDisplayVisibilityKeyword No\r\nDisplayVisibilityIcon No\r\nStereotype No\r\nSignatureWithoutParameters No\r\nSignatureWithParameters No\r\nReturnType No&quot; HasLimit=&quot;Yes&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardCollection Name=&quot;Classificateurs internes&quot; Collection=&quot;InnerClassifiers&quot; Columns=&quot;DisplayInnerIcon Yes\r\nDisplayNameGeneric Yes&quot; HasLimit=&quot;No&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardAttribute Name=&quot;Commentaire&quot; Attribute=&quot;Comment&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;LEFT&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardAttribute Name=&quot;Icône&quot; Attribute=&quot;IconPicture&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;Yes&quot; /&gt;[CRLF]&lt;/Form&gt;
Port.IconPicture=No
Port_SymbolLayout=
Association.RoleAMultiplicity=Yes
Association.RoleAName=Yes
Association.RoleAOrdering=Yes
Association.DisplayedStereotype=No
Association.DisplayName=No
Association.DisplayedRules=Yes
Association.RoleBMultiplicity=Yes
Association.RoleBName=Yes
Association.RoleBOrdering=Yes
Association.RoleMultiplicitySymbol=No
Association_SymbolLayout=&lt;Form&gt;[CRLF] &lt;StandardAttribute Name=&quot;Stéréotype&quot; Attribute=&quot;Stereotype&quot; Prefix=&quot;&amp;lt;&amp;lt;&quot; Suffix=&quot;&amp;gt;&amp;gt;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardAttribute Name=&quot;Nom&quot; Attribute=&quot;DisplayName&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;Yes&quot; /&gt;[CRLF] &lt;Separator Name=&quot;Séparateur&quot; /&gt;[CRLF] &lt;StandardAttribute Name=&quot;Commentaire&quot; Attribute=&quot;Comment&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;LEFT&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardCollection Name=&quot;Attributs&quot; Collection=&quot;Attributes&quot; Columns=&quot;Stereotype No\r\nDisplayName Yes\r\nDataType No\r\nDomainOrDataType No &amp;quot;Domaine ou type de données&amp;quot;\r\nDomain No\r\nNullIndicator No Obligatoire&quot; HasLimit=&quot;Yes&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardAttribute Name=&quot;Icône&quot; Attribute=&quot;IconPicture&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;Yes&quot; /&gt;[CRLF]&lt;/Form&gt;
RequireLink.DisplayedStereotype=Yes
RequireLink.DisplayName=No
RequireLink.DisplayedRules=Yes
RequireLink_SymbolLayout=&lt;Form&gt;[CRLF] &lt;Form Name=&quot;Centre&quot; &gt;[CRLF]  &lt;StandardAttribute Name=&quot;Stéréotype&quot; Attribute=&quot;DisplayedStereotype&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF]  &lt;StandardAttribute Name=&quot;Nom&quot; Attribute=&quot;DisplayName&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF]  &lt;StandardAttribute Name=&quot;Contrainte&quot; Attribute=&quot;DisplayedRules&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;/Form&gt;[CRLF] &lt;Form Name=&quot;Source&quot; &gt;[CRLF] &lt;/Form&gt;[CRLF] &lt;Form Name=&quot;Destination&quot; &gt;[CRLF] &lt;/Form&gt;[CRLF]&lt;/Form&gt;
PortShowName=Yes
PortShowType=No
PortShowMult=No
Table.Stereotype=Yes
Table.DisplayName=Yes
Table.OwnerDisplayName=No
Table.Columns=Yes
Table.Columns._Filter=&quot;Tous les colonnes&quot; PDMCOLNALL
Table.Columns._Columns=Stereotype DataType KeyIndicator
Table.Columns._Limit=-5
Table.Keys=No
Table.Keys._Columns=Stereotype Indicator
Table.Indexes=No
Table.Indexes._Columns=Stereotype
Table.Triggers=No
Table.Triggers._Columns=Stereotype
Table.Comment=No
Table.IconPicture=No
Table_SymbolLayout=&lt;Form&gt;[CRLF] &lt;StandardAttribute Name=&quot;Stéréotype&quot; Attribute=&quot;Stereotype&quot; Prefix=&quot;&amp;lt;&amp;lt;&quot; Suffix=&quot;&amp;gt;&amp;gt;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;ExclusiveChoice Name=&quot;Choix exclusif&quot; Mandatory=&quot;Yes&quot; Display=&quot;HorizontalRadios&quot; &gt;[CRLF]  &lt;StandardAttribute Name=&quot;Nom&quot; Attribute=&quot;DisplayName&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF]  &lt;StandardAttribute Name=&quot;Propriétaire et nom&quot; Attribute=&quot;OwnerDisplayName&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;/ExclusiveChoice&gt;[CRLF] &lt;Separator Name=&quot;Séparateur&quot; /&gt;[CRLF] &lt;StandardCollection Name=&quot;Colonnes&quot; Collection=&quot;Columns&quot; Columns=&quot;Stereotype No\r\nDisplayName Yes\r\nDataType No\r\nSymbolDataType No &amp;quot;Domaine ou type de données&amp;quot;\r\nDomain No\r\nKeyIndicator No\r\nIndexIndicator No\r\nNullStatus No&quot; Filters=&quot;&amp;quot;Tous les colonnes&amp;quot;  PDMCOLNALL &amp;quot;&amp;quot;\r\n&amp;quot;Colonnes de clé primaire&amp;quot;  PDMCOLNPK &amp;quot;PRIM \&amp;quot;TRUE\&amp;quot; TRUE&amp;quot;\r\n&amp;quot;Colonnes de clé&amp;quot;  PDMCOLNKEY &amp;quot;KEYS \&amp;quot;TRUE\&amp;quot; TRUE&amp;quot;&quot; HasLimit=&quot;Yes&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardCollection Name=&quot;Clés&quot; Collection=&quot;Keys&quot; Columns=&quot;Stereotype No\r\nDisplayName Yes\r\nIndicator No&quot; HasLimit=&quot;No&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardCollection Name=&quot;Index&quot; Collection=&quot;Indexes&quot; Columns=&quot;Stereotype No\r\nDisplayName Yes\r\nIndicator No&quot; HasLimit=&quot;No&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardCollection Name=&quot;Triggers&quot; Collection=&quot;Triggers&quot; Columns=&quot;Stereotype No\r\nDisplayName Yes&quot; HasLimit=&quot;No&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardAttribute Name=&quot;Commentaire&quot; Attribute=&quot;Comment&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;LEFT&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardAttribute Name=&quot;Icône&quot; Attribute=&quot;IconPicture&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;Yes&quot; /&gt;[CRLF]&lt;/Form&gt;
View.Stereotype=Yes
View.DisplayName=Yes
View.OwnerDisplayName=No
View.Columns=Yes
View.Columns._Columns=DisplayName
View.Columns._Limit=-5
View.TemporaryVTables=Yes
View.Indexes=No
View.Comment=No
View.IconPicture=No
View_SymbolLayout=&lt;Form&gt;[CRLF] &lt;StandardAttribute Name=&quot;Stéréotype&quot; Attribute=&quot;Stereotype&quot; Prefix=&quot;&amp;lt;&amp;lt;&quot; Suffix=&quot;&amp;gt;&amp;gt;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;ExclusiveChoice Name=&quot;Choix exclusif&quot; Mandatory=&quot;Yes&quot; Display=&quot;HorizontalRadios&quot; &gt;[CRLF]  &lt;StandardAttribute Name=&quot;Nom&quot; Attribute=&quot;DisplayName&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF]  &lt;StandardAttribute Name=&quot;Propriétaire et nom&quot; Attribute=&quot;OwnerDisplayName&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;/ExclusiveChoice&gt;[CRLF] &lt;Separator Name=&quot;Séparateur&quot; /&gt;[CRLF] &lt;StandardCollection Name=&quot;Colonnes&quot; Collection=&quot;Columns&quot; Columns=&quot;DisplayName No\r\nExpression No\r\nDataType No\r\nSymbolDataType No &amp;quot;Domaine ou type de données&amp;quot;\r\nIndexIndicator No&quot; HasLimit=&quot;Yes&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardCollection Name=&quot;Tables&quot; Collection=&quot;TemporaryVTables&quot; Columns=&quot;Name Yes&quot; HasLimit=&quot;No&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardCollection Name=&quot;Index&quot; Collection=&quot;Indexes&quot; Columns=&quot;DisplayName Yes&quot; HasLimit=&quot;No&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardAttribute Name=&quot;Commentaire&quot; Attribute=&quot;Comment&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;LEFT&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardAttribute Name=&quot;Icône&quot; Attribute=&quot;IconPicture&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;Yes&quot; /&gt;[CRLF]&lt;/Form&gt;
Procedure.Stereotype=No
Procedure.DisplayName=Yes
Procedure.OwnerDisplayName=No
Procedure.Comment=No
Procedure.IconPicture=No
Procedure_SymbolLayout=&lt;Form&gt;[CRLF] &lt;StandardAttribute Name=&quot;Stéréotype&quot; Attribute=&quot;Stereotype&quot; Prefix=&quot;&amp;lt;&amp;lt;&quot; Suffix=&quot;&amp;gt;&amp;gt;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;ExclusiveChoice Name=&quot;Choix exclusif&quot; Mandatory=&quot;Yes&quot; Display=&quot;HorizontalRadios&quot; &gt;[CRLF]  &lt;StandardAttribute Name=&quot;Nom&quot; Attribute=&quot;DisplayName&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF]  &lt;StandardAttribute Name=&quot;Propriétaire et nom&quot; Attribute=&quot;OwnerDisplayName&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;/ExclusiveChoice&gt;[CRLF] &lt;Separator Name=&quot;Séparateur&quot; /&gt;[CRLF] &lt;StandardAttribute Name=&quot;Commentaire&quot; Attribute=&quot;Comment&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;LEFT&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardAttribute Name=&quot;Icône&quot; Attribute=&quot;IconPicture&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;Yes&quot; /&gt;[CRLF]&lt;/Form&gt;
Reference.Cardinality=No
Reference.ImplementationType=No
Reference.ChildRole=Yes
Reference.Stereotype=Yes
Reference.DisplayName=No
Reference.ForeignKeyConstraintName=No
Reference.JoinExpression=No
Reference.Integrity=No
Reference.ParentRole=Yes
Reference_SymbolLayout=&lt;Form&gt;[CRLF] &lt;Form Name=&quot;Source&quot; &gt;[CRLF]  &lt;StandardAttribute Name=&quot;Cardinalité&quot; Attribute=&quot;Cardinality&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF]  &lt;StandardAttribute Name=&quot;Mise en oeuvre&quot; Attribute=&quot;ImplementationType&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF]  &lt;StandardAttribute Name=&quot;Rôle enfant&quot; Attribute=&quot;ChildRole&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;/Form&gt;[CRLF] &lt;Form Name=&quot;Centre&quot; &gt;[CRLF]  &lt;StandardAttribute Name=&quot;Stéréotype&quot; Attribute=&quot;Stereotype&quot; Prefix=&quot;&amp;lt;&amp;lt;&quot; Suffix=&quot;&amp;gt;&amp;gt;&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF]  &lt;ExclusiveChoice Name=&quot;Choix exclusif&quot; Mandatory=&quot;No&quot; Display=&quot;HorizontalRadios&quot; &gt;[CRLF]   &lt;StandardAttribute Name=&quot;Nom&quot; Attribute=&quot;DisplayName&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF]   &lt;StandardAttribute Name=&quot;Nom de con&amp;amp;trainte&quot; Attribute=&quot;ForeignKeyConstraintName&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;Nom de con&amp;amp;trainte&quot; Mandatory=&quot;No&quot; /&gt;[CRLF]   &lt;StandardAttribute Name=&quot;Jointure&quot; Attribute=&quot;JoinExpression&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;Jointure&quot; Mandatory=&quot;No&quot; /&gt;[CRLF]  &lt;/ExclusiveChoice&gt;[CRLF]  &lt;StandardAttribute Name=&quot;Intégrité référentielle&quot; Attribute=&quot;Integrity&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;Intégrité référentielle&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;/Form&gt;[CRLF] &lt;Form Name=&quot;Destination&quot; &gt;[CRLF]  &lt;StandardAttribute Name=&quot;Rôle parent&quot; Attribute=&quot;ParentRole&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;/Form&gt;[CRLF]&lt;/Form&gt;
ViewReference.ChildRole=Yes
ViewReference.Stereotype=Yes
ViewReference.DisplayName=No
ViewReference.JoinExpression=No
ViewReference.ParentRole=Yes
ViewReference_SymbolLayout=&lt;Form&gt;[CRLF] &lt;Form Name=&quot;Source&quot; &gt;[CRLF]  &lt;StandardAttribute Name=&quot;Rôle enfant&quot; Attribute=&quot;ChildRole&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;/Form&gt;[CRLF] &lt;Form Name=&quot;Centre&quot; &gt;[CRLF]  &lt;StandardAttribute Name=&quot;Stéréotype&quot; Attribute=&quot;Stereotype&quot; Prefix=&quot;&amp;lt;&amp;lt;&quot; Suffix=&quot;&amp;gt;&amp;gt;&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF]  &lt;ExclusiveChoice Name=&quot;Choix exclusif&quot; Mandatory=&quot;No&quot; Display=&quot;HorizontalRadios&quot; &gt;[CRLF]   &lt;StandardAttribute Name=&quot;Nom&quot; Attribute=&quot;DisplayName&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF]   &lt;StandardAttribute Name=&quot;Expression de jointure&quot; Attribute=&quot;JoinExpression&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF]  &lt;/ExclusiveChoice&gt;[CRLF] &lt;/Form&gt;[CRLF] &lt;Form Name=&quot;Destination&quot; &gt;[CRLF]  &lt;StandardAttribute Name=&quot;Rôle parent&quot; Attribute=&quot;ParentRole&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;/Form&gt;[CRLF]&lt;/Form&gt;
Entity.Stereotype=Yes
Entity.Attributes=Yes
Entity.Attributes._Filter=&quot;Tous les attributs&quot; CDMPENTALL
Entity.Attributes._Columns=Stereotype IdentifierIndicator DomainOrDataType NullIndicator
Entity.Attributes._Limit=-5
Entity.Identifiers=Yes
Entity.Identifiers._Columns=Stereotype IdentifierIndicator
Entity.Comment=No
Entity.IconPicture=No
Entity_SymbolLayout=&lt;Form&gt;[CRLF] &lt;StandardAttribute Name=&quot;Stéréotype&quot; Attribute=&quot;Stereotype&quot; Prefix=&quot;&amp;lt;&amp;lt;&quot; Suffix=&quot;&amp;gt;&amp;gt;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardAttribute Name=&quot;Nom&quot; Attribute=&quot;DisplayName&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;Yes&quot; /&gt;[CRLF] &lt;Separator Name=&quot;Séparateur&quot; /&gt;[CRLF] &lt;StandardCollection Name=&quot;Attributs&quot; Collection=&quot;Attributes&quot; Columns=&quot;Stereotype No\r\nDisplayName Yes\r\nIdentifierIndicator No &amp;quot;Indicateurs d&amp;#39;identifiant&amp;quot;\r\nDataType No\r\nDomainOrDataType No &amp;quot;Domaine ou type de données&amp;quot;\r\nDomain No\r\nNullIndicator No Obligatoire&quot; Filters=&quot;&amp;quot;Tous les attributs&amp;quot;  CDMPENTALL &amp;quot;&amp;quot;\r\n&amp;quot;Attributs primaires&amp;quot;  CDMPENTPK &amp;quot;PIDTF \&amp;quot;TRUE\&amp;quot; TRUE&amp;quot;\r\n&amp;quot;Attributs identifiants&amp;quot;  CDMPENTIDTF &amp;quot;AIDF \&amp;quot;TRUE\&amp;quot; TRUE&amp;quot;&quot; HasLimit=&quot;Yes&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardCollection Name=&quot;Identifiants&quot; Collection=&quot;Identifiers&quot; Columns=&quot;Stereotype No\r\nDisplayName Yes\r\nIdentifierIndicator No &amp;quot;Indicateurs d&amp;#39;identifiant&amp;quot;&quot; HasLimit=&quot;No&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardAttribute Name=&quot;Commentaire&quot; Attribute=&quot;Comment&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;LEFT&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardAttribute Name=&quot;Icône&quot; Attribute=&quot;IconPicture&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;Yes&quot; /&gt;[CRLF]&lt;/Form&gt;
Relationship.Entity1ToEntity2Role=Yes
Relationship.Entity2ToEntity1RoleCardinality=No
Relationship.Entity1ToEntity2RoleDominant=Yes
Relationship.Stereotype=Yes
Relationship.DisplayName=Yes
Relationship.Entity2ToEntity1Role=Yes
Relationship.Entity1ToEntity2RoleCardinality=No
Relationship.Entity2ToEntity1RoleDominant=Yes
Relationship_SymbolLayout=&lt;Form&gt;[CRLF] &lt;Form Name=&quot;Source&quot; &gt;[CRLF]  &lt;StandardAttribute Name=&quot;Rôle&quot; Attribute=&quot;Entity1ToEntity2Role&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;Rôle&quot; Mandatory=&quot;No&quot; /&gt;[CRLF]  &lt;StandardAttribute Name=&quot;Cardinalité&quot; Attribute=&quot;Entity2ToEntity1RoleCardinality&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;Cardinalité&quot; Mandatory=&quot;No&quot; /&gt;[CRLF]  &lt;StandardAttribute Name=&quot;Dominance&quot; Attribute=&quot;Entity1ToEntity2RoleDominant&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;Dominance&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;/Form&gt;[CRLF] &lt;Form Name=&quot;Centre&quot; &gt;[CRLF]  &lt;StandardAttribute Name=&quot;Stéréotype&quot; Attribute=&quot;Stereotype&quot; Prefix=&quot;&amp;lt;&amp;lt;&quot; Suffix=&quot;&amp;gt;&amp;gt;&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF]  &lt;StandardAttribute Name=&quot;Nom&quot; Attribute=&quot;DisplayName&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;/Form&gt;[CRLF] &lt;Form Name=&quot;Destination&quot; &gt;[CRLF]  &lt;StandardAttribute Name=&quot;Rôle&quot; Attribute=&quot;Entity2ToEntity1Role&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;Rôle&quot; Mandatory=&quot;No&quot; /&gt;[CRLF]  &lt;StandardAttribute Name=&quot;Cardinalité&quot; Attribute=&quot;Entity1ToEntity2RoleCardinality&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;Cardinalité&quot; Mandatory=&quot;No&quot; /&gt;[CRLF]  &lt;StandardAttribute Name=&quot;Dominance&quot; Attribute=&quot;Entity2ToEntity1RoleDominant&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;Dominance&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;/Form&gt;[CRLF]&lt;/Form&gt;
Inheritance.Stereotype=Yes
Inheritance.DisplayName=Yes
Inheritance.IconPicture=No
Inheritance_SymbolLayout=&lt;Form&gt;[CRLF] &lt;StandardAttribute Name=&quot;Stéréotype&quot; Attribute=&quot;Stereotype&quot; Prefix=&quot;&amp;lt;&amp;lt;&quot; Suffix=&quot;&amp;gt;&amp;gt;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;StandardAttribute Name=&quot;Nom&quot; Attribute=&quot;DisplayName&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;Separator Name=&quot;Séparateur&quot; /&gt;[CRLF] &lt;StandardAttribute Name=&quot;Icône&quot; Attribute=&quot;IconPicture&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Alignment=&quot;CNTR&quot; Caption=&quot;&quot; Mandatory=&quot;Yes&quot; /&gt;[CRLF]&lt;/Form&gt;
Association.Stereotype=Yes
Association.Comment=No
Association.Attributes=Yes
Association.Attributes._Columns=Stereotype DataType NullIndicator
Association.Attributes._Limit=-5
Association.IconPicture=No
AssociationLink.SymbolCardinality=Yes
AssociationLink.Stereotype=Yes
AssociationLink.Role=Yes
AssociationLink_SymbolLayout=&lt;Form&gt;[CRLF] &lt;Form Name=&quot;Source&quot; &gt;[CRLF]  &lt;StandardAttribute Name=&quot;Cardinalité&quot; Attribute=&quot;SymbolCardinality&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;Cardinalité&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;/Form&gt;[CRLF] &lt;Form Name=&quot;Centre&quot; &gt;[CRLF]  &lt;StandardAttribute Name=&quot;Stéréotype&quot; Attribute=&quot;Stereotype&quot; Prefix=&quot;&amp;lt;&amp;lt;&quot; Suffix=&quot;&amp;gt;&amp;gt;&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF]  &lt;StandardAttribute Name=&quot;Rôle&quot; Attribute=&quot;Role&quot; Prefix=&quot;&quot; Suffix=&quot;&quot; Caption=&quot;&quot; Mandatory=&quot;No&quot; /&gt;[CRLF] &lt;/Form&gt;[CRLF] &lt;Form Name=&quot;Destination&quot; &gt;[CRLF] &lt;/Form&gt;[CRLF]&lt;/Form&gt;

[DisplayPreferences\Symbol]

[DisplayPreferences\Symbol\FRMEOBJ]
STRNFont=Arial,8,N
STRNFont color=0, 0, 0
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0, 0, 0
LABLFont=Arial,8,N
LABLFont color=0, 0, 0
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Width=6000
Height=2000
Brush color=255 255 255
Fill Color=Yes
Brush style=6
Brush bitmap mode=12
Brush gradient mode=64
Brush gradient color=192 192 192
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 255 128 128
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\FRMELNK]
CENTERFont=Arial,8,N
CENTERFont color=0, 0, 0
Line style=1
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Brush color=255 255 255
Fill Color=Yes
Brush style=1
Brush bitmap mode=12
Brush gradient mode=0
Brush gradient color=118 118 118
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 128 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\FILO]
OBJSTRNFont=Arial,8,N
OBJSTRNFont color=0, 0, 0
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0, 0, 0
LCNMFont=Arial,8,N
LCNMFont color=0, 0, 0
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Width=4800
Height=3600
Brush color=255 255 255
Fill Color=Yes
Brush style=1
Brush bitmap mode=12
Brush gradient mode=0
Brush gradient color=118 118 118
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 0 0 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\CLDPCKG]
STRNFont=Arial,8,N
STRNFont color=0, 0, 0
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0, 0, 0
LABLFont=Arial,8,N
LABLFont color=0, 0, 0
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Width=4800
Height=4000
Brush color=255 255 192
Fill Color=Yes
Brush style=6
Brush bitmap mode=12
Brush gradient mode=65
Brush gradient color=255 255 255
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 178 178 178
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\GNRLLINK]
CENTERFont=Arial,8,N
CENTERFont color=0, 0, 0
Line style=1
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Brush color=255 255 255
Fill Color=Yes
Brush style=1
Brush bitmap mode=12
Brush gradient mode=0
Brush gradient color=118 118 118
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 128 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\RLZSLINK]
CENTERFont=Arial,8,N
CENTERFont color=0, 0, 0
Line style=1
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Brush color=255 255 255
Fill Color=Yes
Brush style=1
Brush bitmap mode=12
Brush gradient mode=0
Brush gradient color=118 118 118
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 128 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\DEPDLINK]
CENTERFont=Arial,8,N
CENTERFont color=0, 0, 0
Line style=1
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Brush color=255 255 255
Fill Color=Yes
Brush style=1
Brush bitmap mode=12
Brush gradient mode=0
Brush gradient color=118 118 118
Brush background image=
Custom shape=
Custom text mode=0
Pen=2 0 128 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\CLDCLASS]
STRNFont=Arial,8,N
STRNFont color=0, 0, 0
QDNMFont=Arial,8,N
QDNMFont color=0, 0, 0
CNTRFont=Arial,8,N
CNTRFont color=0, 0, 0
AttributesFont=Arial,8,N
AttributesFont color=0, 0, 0
ClassPrimaryAttributeFont=Arial,8,U
ClassPrimaryAttributeFont color=0, 0, 0
OperationsFont=Arial,8,N
OperationsFont color=0, 0, 0
InnerClassifiersFont=Arial,8,N
InnerClassifiersFont color=0, 0, 0
LABLFont=Arial,8,N
LABLFont color=0, 0, 0
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Width=4800
Height=3600
Brush color=174 228 255
Fill Color=Yes
Brush style=6
Brush bitmap mode=12
Brush gradient mode=65
Brush gradient color=255 255 255
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 0 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\CLDINTF]
STRNFont=Arial,8,N
STRNFont color=0, 0, 0
QDNMFont=Arial,8,N
QDNMFont color=0, 0, 0
CNTRFont=Arial,8,N
CNTRFont color=0, 0, 0
AttributesFont=Arial,8,N
AttributesFont color=0, 0, 0
OperationsFont=Arial,8,N
OperationsFont color=0, 0, 0
InnerClassifiersFont=Arial,8,N
InnerClassifiersFont color=0, 0, 0
LABLFont=Arial,8,N
LABLFont color=0, 0, 0
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Width=4800
Height=3600
Brush color=208 208 255
Fill Color=Yes
Brush style=6
Brush bitmap mode=12
Brush gradient mode=65
Brush gradient color=255 255 255
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 128 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\OOMPORT]
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0, 0, 0
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Width=800
Height=800
Brush color=174 228 255
Fill Color=Yes
Brush style=6
Brush bitmap mode=12
Brush gradient mode=65
Brush gradient color=255 255 255
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 0 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\CLDASSC]
SOURCEFont=Arial,8,N
SOURCEFont color=0, 0, 0
CENTERFont=Arial,8,N
CENTERFont color=0, 0, 0
DESTINATIONFont=Arial,8,N
DESTINATIONFont color=0, 0, 0
Line style=1
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Brush color=255 255 255
Fill Color=Yes
Brush style=1
Brush bitmap mode=12
Brush gradient mode=0
Brush gradient color=118 118 118
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 0 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\INNERLINK]
Line style=1
Pen=1 0 0 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\CLDACLK]
Line style=1
Pen=2 0 0 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\RQLINK]
CENTERFont=Arial,8,N
CENTERFont color=0, 0, 0
Line style=1
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Brush color=255 255 255
Fill Color=Yes
Brush style=1
Brush bitmap mode=12
Brush gradient mode=0
Brush gradient color=118 118 118
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 128 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\USRDEPD]
OBJXSTRFont=Arial,8,N
OBJXSTRFont color=0, 0, 0
Line style=1
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Brush color=255 255 255
Fill Color=Yes
Brush style=1
Brush bitmap mode=12
Brush gradient mode=0
Brush gradient color=118 118 118
Brush background image=
Custom shape=
Custom text mode=0
Pen=2 0 128 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\Free Symbol]
Free TextFont=Arial,8,N
Free TextFont color=0, 0, 0
Line style=0
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Brush color=255 255 255
Fill Color=Yes
Brush style=1
Brush bitmap mode=12
Brush gradient mode=0
Brush gradient color=118 118 118
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 0 0 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\PDMPCKG]
STRNFont=Arial,8,N
STRNFont color=0, 0, 0
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0, 0, 0
LABLFont=Arial,8,N
LABLFont color=0, 0, 0
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Width=4800
Height=4000
Brush color=255 255 192
Fill Color=Yes
Brush style=6
Brush bitmap mode=12
Brush gradient mode=65
Brush gradient color=255 255 255
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 178 178 178
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\TABL]
STRNFont=Arial,8,N
STRNFont color=0, 0, 0
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0, 0, 0
OWNRDISPNAMEFont=Arial,8,N
OWNRDISPNAMEFont color=0, 0, 0
ColumnsFont=Arial,8,N
ColumnsFont color=0, 0, 0
TablePkColumnsFont=Arial,8,U
TablePkColumnsFont color=0, 0, 0
TableFkColumnsFont=Arial,8,N
TableFkColumnsFont color=0, 0, 0
KeysFont=Arial,8,N
KeysFont color=0, 0, 0
IndexesFont=Arial,8,N
IndexesFont color=0, 0, 0
TriggersFont=Arial,8,N
TriggersFont color=0, 0, 0
LABLFont=Arial,8,N
LABLFont color=0, 0, 0
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Width=4800
Height=4000
Brush color=178 214 252
Fill Color=Yes
Brush style=6
Brush bitmap mode=12
Brush gradient mode=65
Brush gradient color=255 255 255
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 0 128 192
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\VIEW]
STRNFont=Arial,8,N
STRNFont color=0, 0, 0
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0, 0, 0
OWNRDISPNAMEFont=Arial,8,N
OWNRDISPNAMEFont color=0, 0, 0
ColumnsFont=Arial,8,N
ColumnsFont color=0, 0, 0
TablePkColumnsFont=Arial,8,U
TablePkColumnsFont color=0, 0, 0
TableFkColumnsFont=Arial,8,N
TableFkColumnsFont color=0, 0, 0
TemporaryVTablesFont=Arial,8,N
TemporaryVTablesFont color=0, 0, 0
IndexesFont=Arial,8,N
IndexesFont color=0, 0, 0
LABLFont=Arial,8,N
LABLFont color=0, 0, 0
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Width=4800
Height=4000
Brush color=208 208 255
Fill Color=Yes
Brush style=6
Brush bitmap mode=12
Brush gradient mode=65
Brush gradient color=255 255 255
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 128 128 192
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\PROC]
STRNFont=Arial,8,N
STRNFont color=0, 0, 0
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0, 0, 0
OWNRDISPNAMEFont=Arial,8,N
OWNRDISPNAMEFont color=0, 0, 0
LABLFont=Arial,8,N
LABLFont color=0, 0, 0
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Width=4000
Height=1000
Brush color=255 255 192
Fill Color=Yes
Brush style=6
Brush bitmap mode=12
Brush gradient mode=65
Brush gradient color=255 255 255
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 128 108 0
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\REFR]
SOURCEFont=Arial,8,N
SOURCEFont color=0, 0, 0
CENTERFont=Arial,8,N
CENTERFont color=0, 0, 0
DESTINATIONFont=Arial,8,N
DESTINATIONFont color=0, 0, 0
Line style=1
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Brush color=255 255 255
Fill Color=Yes
Brush style=1
Brush bitmap mode=12
Brush gradient mode=0
Brush gradient color=118 118 118
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 0 128 192
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\VREF]
SOURCEFont=Arial,8,N
SOURCEFont color=0, 0, 0
CENTERFont=Arial,8,N
CENTERFont color=0, 0, 0
DESTINATIONFont=Arial,8,N
DESTINATIONFont color=0, 0, 0
Line style=1
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Brush color=255 255 255
Fill Color=Yes
Brush style=1
Brush bitmap mode=12
Brush gradient mode=0
Brush gradient color=118 118 118
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 128 128 192
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\LDMPCKG]
STRNFont=Arial,8,N
STRNFont color=0, 0, 0
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0, 0, 0
LABLFont=Arial,8,N
LABLFont color=0, 0, 0
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Width=4800
Height=4000
Brush color=255 255 192
Fill Color=Yes
Brush style=6
Brush bitmap mode=12
Brush gradient mode=65
Brush gradient color=255 255 255
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 178 178 178
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\LDMENTT]
STRNFont=Arial,8,N
STRNFont color=0 0 0
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0 0 0
AttributesFont=Arial,8,N
AttributesFont color=0 0 0
EntityPrimaryAttributeFont=Arial,8,U
EntityPrimaryAttributeFont color=0, 0, 0
EntityForeignAttributeFont=Arial,8,N
EntityForeignAttributeFont color=0, 0, 0
IdentifiersFont=Arial,8,N
IdentifiersFont color=0 0 0
LABLFont=Arial,8,N
LABLFont color=0 0 0
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Width=4800
Height=4000
Brush color=176 186 255
Fill Color=Yes
Brush style=6
Brush bitmap mode=12
Brush gradient mode=65
Brush gradient color=255 255 255
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 88 74 181
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\LDMRLSH]
SOURCEFont=Arial,8,N
SOURCEFont color=0, 0, 0
CENTERFont=Arial,8,N
CENTERFont color=0, 0, 0
DESTINATIONFont=Arial,8,N
DESTINATIONFont color=0, 0, 0
Line style=1
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Brush color=255 255 255
Fill Color=Yes
Brush style=1
Brush bitmap mode=12
Brush gradient mode=0
Brush gradient color=118 118 118
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 88 74 181
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\LDMINHR]
STRNFont=Arial,8,N
STRNFont color=0, 0, 0
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0, 0, 0
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=Yes
Width=1600
Height=1000
Brush color=176 186 255
Fill Color=Yes
Brush style=6
Brush bitmap mode=12
Brush gradient mode=65
Brush gradient color=255 255 255
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 128 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\LDMLINH]
CENTERFont=Arial,8,N
CENTERFont color=0, 0, 0
Line style=1
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Brush color=255 255 255
Fill Color=Yes
Brush style=1
Brush bitmap mode=12
Brush gradient mode=0
Brush gradient color=118 118 118
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 128 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\CDMPCKG]
STRNFont=Arial,8,N
STRNFont color=0, 0, 0
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0, 0, 0
LABLFont=Arial,8,N
LABLFont color=0, 0, 0
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Width=4800
Height=4000
Brush color=255 255 192
Fill Color=Yes
Brush style=6
Brush bitmap mode=12
Brush gradient mode=65
Brush gradient color=255 255 255
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 178 178 178
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\ENTT]
STRNFont=Arial,8,N
STRNFont color=0, 0, 0
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0, 0, 0
AttributesFont=Arial,8,N
AttributesFont color=0, 0, 0
EntityPrimaryAttributeFont=Arial,8,U
EntityPrimaryAttributeFont color=0, 0, 0
IdentifiersFont=Arial,8,N
IdentifiersFont color=0, 0, 0
LABLFont=Arial,8,N
LABLFont color=0, 0, 0
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Width=4800
Height=4000
Brush color=176 255 255
Fill Color=Yes
Brush style=6
Brush bitmap mode=12
Brush gradient mode=65
Brush gradient color=255 255 255
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 0 170 170
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\RLSH]
SOURCEFont=Arial,8,N
SOURCEFont color=0, 0, 0
CENTERFont=Arial,8,N
CENTERFont color=0, 0, 0
DESTINATIONFont=Arial,8,N
DESTINATIONFont color=0, 0, 0
Line style=1
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Brush color=255 255 255
Fill Color=Yes
Brush style=1
Brush bitmap mode=12
Brush gradient mode=0
Brush gradient color=118 118 118
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 0 170 170
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\ASSC]
STRNFont=Arial,8,N
STRNFont color=0, 0, 0
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0, 0, 0
LABLFont=Arial,8,N
LABLFont color=0, 0, 0
AttributesFont=Arial,8,N
AttributesFont color=0, 0, 0
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Width=4800
Height=3000
Brush color=208 208 255
Fill Color=Yes
Brush style=6
Brush bitmap mode=12
Brush gradient mode=65
Brush gradient color=255 255 255
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 128 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\LINK]
SOURCEFont=Arial,8,N
SOURCEFont color=0, 0, 0
CENTERFont=Arial,8,N
CENTERFont color=0, 0, 0
Line style=1
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Brush color=255 255 255
Fill Color=Yes
Brush style=1
Brush bitmap mode=12
Brush gradient mode=0
Brush gradient color=118 118 118
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 128 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\CDMINHR]
STRNFont=Arial,8,N
STRNFont color=0, 0, 0
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0, 0, 0
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=Yes
Width=1600
Height=1000
Brush color=176 255 255
Fill Color=Yes
Brush style=6
Brush bitmap mode=12
Brush gradient mode=65
Brush gradient color=255 255 255
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 128 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\LINH]
CENTERFont=Arial,8,N
CENTERFont color=0, 0, 0
Line style=1
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Brush color=255 255 255
Fill Color=Yes
Brush style=1
Brush bitmap mode=12
Brush gradient mode=0
Brush gradient color=118 118 118
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 128 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\PDM]

[DisplayPreferences\LDM]

[DisplayPreferences\CDM]</a:DisplayPreferences>
<a:PaperSize>(8268, 11693)</a:PaperSize>
<a:PageMargins>((315,354), (433,354))</a:PageMargins>
<a:Scale>52</a:Scale>
<a:PageOrientation>1</a:PageOrientation>
<a:PaperSource>15</a:PaperSource>
<c:Symbols>
<o:TitleSymbol Id="o7">
<a:Text>Version: 1</a:Text>
<a:CreationDate>1497870917</a:CreationDate>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Rect>((33160,34388), (48459,41131))</a:Rect>
<a:TextStyle>4130</a:TextStyle>
<a:LineColor>16711680</a:LineColor>
<a:FillColor>16777215</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontName>Arial,8,N</a:FontName>
</o:TitleSymbol>
<o:AssociationSymbol Id="o8">
<a:Rect>((-44961,-38733), (-44261,-23096))</a:Rect>
<a:ListOfPoints>((-44611,-23096),(-44611,-38733))</a:ListOfPoints>
<a:CornerStyle>1</a:CornerStyle>
<a:ArrowStyle>3584</a:ArrowStyle>
<a:LineColor>16744576</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>CENTER 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o9"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o10"/>
</c:DestinationSymbol>
<c:Object>
<o:Association Ref="o11"/>
</c:Object>
</o:AssociationSymbol>
<o:AssociationSymbol Id="o12">
<a:Rect>((-44409,-39002), (-15067,-38302))</a:Rect>
<a:ListOfPoints>((-44409,-38652),(-15067,-38652))</a:ListOfPoints>
<a:CornerStyle>1</a:CornerStyle>
<a:ArrowStyle>3584</a:ArrowStyle>
<a:LineColor>16744576</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>CENTER 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o10"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o13"/>
</c:DestinationSymbol>
<c:Object>
<o:Association Ref="o14"/>
</c:Object>
</o:AssociationSymbol>
<o:AssociationSymbol Id="o15">
<a:Rect>((-15067,-38733), (15405,-38633))</a:Rect>
<a:ListOfPoints>((-15067,-38733),(15405,-38733))</a:ListOfPoints>
<a:CornerStyle>1</a:CornerStyle>
<a:ArrowStyle>0</a:ArrowStyle>
<a:LineColor>16744576</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>CENTER 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o13"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o16"/>
</c:DestinationSymbol>
<c:Object>
<o:Association Ref="o17"/>
</c:Object>
</o:AssociationSymbol>
<o:AssociationSymbol Id="o18">
<a:Rect>((15283,-38733), (15383,-19544))</a:Rect>
<a:ListOfPoints>((15283,-19544),(15283,-38733))</a:ListOfPoints>
<a:CornerStyle>1</a:CornerStyle>
<a:ArrowStyle>0</a:ArrowStyle>
<a:LineColor>16744576</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>CENTER 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o19"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o16"/>
</c:DestinationSymbol>
<c:Object>
<o:Association Ref="o20"/>
</c:Object>
</o:AssociationSymbol>
<o:AssociationSymbol Id="o21">
<a:Rect>((15614,-38649), (44237,-38549))</a:Rect>
<a:ListOfPoints>((44237,-38649),(15614,-38649))</a:ListOfPoints>
<a:CornerStyle>1</a:CornerStyle>
<a:ArrowStyle>0</a:ArrowStyle>
<a:LineColor>16744576</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>CENTER 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o22"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o16"/>
</c:DestinationSymbol>
<c:Object>
<o:Association Ref="o23"/>
</c:Object>
</o:AssociationSymbol>
<o:ClassSymbol Id="o16">
<a:IconMode>-1</a:IconMode>
<a:Rect>((8968,-42254), (21842,-35212))</a:Rect>
<a:LineColor>11184640</a:LineColor>
<a:FillColor>8454016</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
QDNM 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o24"/>
</c:Object>
</o:ClassSymbol>
<o:ClassSymbol Id="o13">
<a:IconMode>-1</a:IconMode>
<a:Rect>((-22624,-42254), (-7510,-35212))</a:Rect>
<a:LineColor>11184640</a:LineColor>
<a:FillColor>8454016</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
QDNM 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o25"/>
</c:Object>
</o:ClassSymbol>
<o:ClassSymbol Id="o22">
<a:IconMode>-1</a:IconMode>
<a:Rect>((38612,-41765), (49862,-35697))</a:Rect>
<a:LineColor>11184640</a:LineColor>
<a:FillColor>8454016</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
QDNM 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o26"/>
</c:Object>
</o:ClassSymbol>
<o:ClassSymbol Id="o10">
<a:IconMode>-1</a:IconMode>
<a:Rect>((-51781,-42254), (-37441,-35212))</a:Rect>
<a:LineColor>11184640</a:LineColor>
<a:FillColor>8454016</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
QDNM 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o27"/>
</c:Object>
</o:ClassSymbol>
<o:ClassSymbol Id="o19">
<a:IconMode>-1</a:IconMode>
<a:Rect>((7045,-26474), (23317,-12614))</a:Rect>
<a:LineColor>11184640</a:LineColor>
<a:FillColor>8454016</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
QDNM 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o28"/>
</c:Object>
</o:ClassSymbol>
<o:ClassSymbol Id="o9">
<a:IconMode>-1</a:IconMode>
<a:Rect>((-51975,-26617), (-37247,-19575))</a:Rect>
<a:LineColor>11184640</a:LineColor>
<a:FillColor>8454016</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
QDNM 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o29"/>
</c:Object>
</o:ClassSymbol>
</c:Symbols>
</o:ClassDiagram>
</c:ClassDiagrams>
<c:DefaultDiagram>
<o:ClassDiagram Ref="o6"/>
</c:DefaultDiagram>
<c:Classes>
<o:Class Id="o24">
<a:ObjectID>28C8F7F1-5EF1-4CB2-80B9-69E53867A174</a:ObjectID>
<a:Name>auto_eval</a:Name>
<a:Code>AutoEval</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {66A3FAB0-DA6C-4941-B267-DCE13870E04D}
DAT 1497870918
ORG {44C712AA-549E-4B6E-BF9A-B63A6C70D2E2}
DAT 1497516127
ORG {DD64F489-E702-47DA-9782-7EC2227D3D55}
DAT 1497516062
ATT NAME
ATT CODE</a:History>
<a:UseParentNamespace>0</a:UseParentNamespace>
<a:PersistentCode>AUTO_EVAL</a:PersistentCode>
<c:Attributes>
<o:Attribute Id="o30">
<a:ObjectID>E57E8D76-81B7-4CA1-AD78-920B8229FACA</a:ObjectID>
<a:Name>ae_id</a:Name>
<a:Code>aeId</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {D2E5E1FB-649B-48D1-9324-392D1124F518}
DAT 1497870918
ORG {6F42FF7A-3801-4F72-892B-362DBC362FCB}
DAT 1497516127
ORG {C6CA6A31-A306-4476-BA88-D74E771C3B32}
DAT 1497516062
ATT DTTP
ATT MLEN</a:History>
<a:DataType>java.lang.String</a:DataType>
<a:PersistentDataType>VA4</a:PersistentDataType>
<a:PersistentLength>4</a:PersistentLength>
<a:PersistentCode>AE_ID</a:PersistentCode>
<a:Multiplicity>1..1</a:Multiplicity>
</o:Attribute>
<o:Attribute Id="o31">
<a:ObjectID>C870488C-3E07-4EF8-ABD3-2AF3AD0EB3ED</a:ObjectID>
<a:Name>ae_date</a:Name>
<a:Code>aeDate</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {B0FC4B0B-5502-456C-8281-1A99571CEB56}
DAT 1497870918
ORG {B2981BED-1D67-451D-946E-05349547D6CE}
DAT 1497516127
ORG {A9047E46-B0E6-4B9F-94A6-E9D2EF03FD98}
DAT 1497516062
ATT DTTP</a:History>
<a:DataType>java.util.Date</a:DataType>
<a:PersistentDataType>DT</a:PersistentDataType>
<a:PersistentCode>AE_DATE</a:PersistentCode>
<a:Multiplicity>1..1</a:Multiplicity>
</o:Attribute>
<o:Attribute Id="o32">
<a:ObjectID>4F10B2D8-87B5-4BD1-9C9F-E4B9B1C19831</a:ObjectID>
<a:Name>ae_ressenti</a:Name>
<a:Code>aeRessenti</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {361494FE-496C-45E7-A1E6-627FB15AD772}
DAT 1497870918
ORG {94AB25D6-37DE-4CF4-9312-B46413A037E5}
DAT 1497516127
ORG {1F009083-7D43-49F8-8F75-A37646AEEE01}
DAT 1497516062
ATT DTTP
ATT MLEN</a:History>
<a:DataType>java.lang.String</a:DataType>
<a:PersistentDataType>VA4000</a:PersistentDataType>
<a:PersistentLength>4000</a:PersistentLength>
<a:PersistentCode>AE_RESSENTI</a:PersistentCode>
</o:Attribute>
</c:Attributes>
<c:Identifiers>
<o:Identifier Id="o33">
<a:ObjectID>B1853E20-577B-4EE1-8B77-671907215F50</a:ObjectID>
<a:Name>ae_id</a:Name>
<a:Code>AE_ID</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {9CE13FA9-7DFB-487E-884A-55A48CEC7F50}
DAT 1497870918
ORG {A251B13D-1195-4AF1-AD10-828B5496B5DE}
DAT 1497516127
ORG {D69A5094-2748-4FAC-B2AA-73EF57FD8BD7}
DAT 1497516062</a:History>
<c:Identifier.Attributes>
<o:Attribute Ref="o30"/>
</c:Identifier.Attributes>
</o:Identifier>
</c:Identifiers>
<c:PrimaryIdentifier>
<o:Identifier Ref="o33"/>
</c:PrimaryIdentifier>
</o:Class>
<o:Class Id="o25">
<a:ObjectID>43FAF108-1D99-4B4A-8CD1-D6139D2ED860</a:ObjectID>
<a:Name>comp</a:Name>
<a:Code>Comp</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {F8ABBE30-26B6-4358-B904-D0315898EE16}
DAT 1497870918
ORG {5A943414-704A-4C6C-8D14-00868E020E26}
DAT 1497516127
ORG {F47289A8-D798-485E-9A86-012663A9C3F5}
DAT 1497516062
ATT NAME
ATT CODE</a:History>
<a:UseParentNamespace>0</a:UseParentNamespace>
<a:PersistentCode>COMP</a:PersistentCode>
<c:Attributes>
<o:Attribute Id="o34">
<a:ObjectID>A3C70FF8-555B-4BDC-AAF2-7E373AA91FA4</a:ObjectID>
<a:Name>comp_id</a:Name>
<a:Code>compId</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {6B3549F3-0515-40CD-A3FD-FE726891B3BE}
DAT 1497870918
ORG {1BBD7259-48AD-4BA4-B8AB-4C73B213FDAB}
DAT 1497516127
ORG {330B5CF7-C231-497C-B025-B94D2AF5DBAE}
DAT 1497516062
ATT DTTP
ATT MLEN</a:History>
<a:DataType>java.lang.String</a:DataType>
<a:PersistentDataType>VA3</a:PersistentDataType>
<a:PersistentLength>3</a:PersistentLength>
<a:PersistentCode>COMP_ID</a:PersistentCode>
<a:Multiplicity>1..1</a:Multiplicity>
</o:Attribute>
<o:Attribute Id="o35">
<a:ObjectID>8113157C-AAD4-4389-9642-3016E8A7E0BF</a:ObjectID>
<a:Name>comp_nom_long</a:Name>
<a:Code>compNomLong</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {31BE791C-727C-4AF1-A1C7-AC159DD3E642}
DAT 1497870918
ORG {DA9E9C37-5714-4308-A22B-3599222A2731}
DAT 1497516127
ORG {B7ECC4EF-70B7-43C0-952B-1030F346EF2F}
DAT 1497516062
ATT DTTP
ATT MLEN</a:History>
<a:DataType>java.lang.String</a:DataType>
<a:PersistentDataType>VA200</a:PersistentDataType>
<a:PersistentLength>200</a:PersistentLength>
<a:PersistentCode>COMP_NOM_LONG</a:PersistentCode>
<a:Multiplicity>1..1</a:Multiplicity>
</o:Attribute>
<o:Attribute Id="o36">
<a:ObjectID>A85DA820-3810-479D-B7E2-8BE2DBBEFE9A</a:ObjectID>
<a:Name>comp_nom_court</a:Name>
<a:Code>compNomCourt</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {F5B6486D-9B9B-4B50-A02B-B25F65EF16D6}
DAT 1497870918
ORG {FA96739D-0375-466E-9425-32D918B27B14}
DAT 1497516127
ORG {3BD37F3A-894F-4156-AED4-938E8BFEB300}
DAT 1497516062
ATT DTTP
ATT MLEN</a:History>
<a:DataType>java.lang.String</a:DataType>
<a:PersistentDataType>VA200</a:PersistentDataType>
<a:PersistentLength>200</a:PersistentLength>
<a:PersistentCode>COMP_NOM_COURT</a:PersistentCode>
<a:Multiplicity>1..1</a:Multiplicity>
</o:Attribute>
</c:Attributes>
<c:Identifiers>
<o:Identifier Id="o37">
<a:ObjectID>BB70243C-8E2E-4FA8-9CC7-110B6B3BF7CD</a:ObjectID>
<a:Name>comp_id</a:Name>
<a:Code>COMP_ID</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {37C80774-A192-476D-9990-FC7D8B19B02E}
DAT 1497870918
ORG {1FCA4A3F-7626-4C55-BD12-BA8679F635E1}
DAT 1497516127
ORG {B2050488-EFB9-4C11-BE8E-0997A71B7415}
DAT 1497516062</a:History>
<c:Identifier.Attributes>
<o:Attribute Ref="o34"/>
</c:Identifier.Attributes>
</o:Identifier>
</c:Identifiers>
<c:PrimaryIdentifier>
<o:Identifier Ref="o37"/>
</c:PrimaryIdentifier>
</o:Class>
<o:Class Id="o26">
<a:ObjectID>BA99ADE2-19A1-4C61-9115-3A69FAB774E2</a:ObjectID>
<a:Name>niv_acqui</a:Name>
<a:Code>NivAcqui</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {BCB1CF9D-8E16-4BEB-A0BC-66231429AF7C}
DAT 1497870918
ORG {C98AD3C9-8418-4EFD-B20E-735923E5D452}
DAT 1497516127
ORG {14AE3163-5D32-453C-A3B2-2BCC23495971}
DAT 1497516062
ATT NAME
ATT CODE</a:History>
<a:UseParentNamespace>0</a:UseParentNamespace>
<a:PersistentCode>NIV_ACQUI</a:PersistentCode>
<c:Attributes>
<o:Attribute Id="o38">
<a:ObjectID>2DB74868-49A0-45B2-8B89-7FA3D0246046</a:ObjectID>
<a:Name>na_id</a:Name>
<a:Code>naId</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {9E29794A-4F65-4284-AC7D-B4416FCD6836}
DAT 1497870918
ORG {0A510F44-E9AC-4DF2-A5BF-C232C372F3F6}
DAT 1497516127
ORG {CB3E6F80-0DCD-499E-B8FE-59F66823CD42}
DAT 1497516062
ATT DTTP
ATT MLEN</a:History>
<a:DataType>java.lang.String</a:DataType>
<a:PersistentDataType>VA2</a:PersistentDataType>
<a:PersistentLength>2</a:PersistentLength>
<a:PersistentCode>NA_ID</a:PersistentCode>
<a:Multiplicity>1..1</a:Multiplicity>
</o:Attribute>
<o:Attribute Id="o39">
<a:ObjectID>B08FC61B-5645-4604-AFF5-EB2B22B3DC93</a:ObjectID>
<a:Name>na_niv</a:Name>
<a:Code>naNiv</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {BD0FD155-2583-4748-891D-8A0406530C8E}
DAT 1497870918
ORG {679BF22E-DE6D-4FB7-92B5-95DC4A5D2218}
DAT 1497516127
ORG {6C8431A2-7950-46F5-BD7F-19B0FC305ABD}
DAT 1497516062
ATT DTTP
ATT MLEN</a:History>
<a:DataType>java.lang.String</a:DataType>
<a:PersistentDataType>VA2</a:PersistentDataType>
<a:PersistentLength>2</a:PersistentLength>
<a:PersistentCode>NA_NIV</a:PersistentCode>
<a:Multiplicity>1..1</a:Multiplicity>
</o:Attribute>
</c:Attributes>
<c:Identifiers>
<o:Identifier Id="o40">
<a:ObjectID>6A4CFD40-903A-46EF-BAF0-364C458B2458</a:ObjectID>
<a:Name>na_id</a:Name>
<a:Code>NA_ID</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {7CFA2211-8123-47CB-8EE7-BB7A8EA393DA}
DAT 1497870918
ORG {AFF46F8F-0021-4F23-9799-A90A51EB14D1}
DAT 1497516127
ORG {6B6A65FC-5B58-451D-B3EB-6A620D38E3A2}
DAT 1497516062</a:History>
<c:Identifier.Attributes>
<o:Attribute Ref="o38"/>
</c:Identifier.Attributes>
</o:Identifier>
</c:Identifiers>
<c:PrimaryIdentifier>
<o:Identifier Ref="o40"/>
</c:PrimaryIdentifier>
</o:Class>
<o:Class Id="o27">
<a:ObjectID>E078FFF5-6811-420A-A102-EA1CE20AA128</a:ObjectID>
<a:Name>sequence</a:Name>
<a:Code>Sequence</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {3A72AE22-0A38-463E-A217-DE6AC96A2F5C}
DAT 1497870918
ORG {6F01FAC7-4AB7-4E30-909B-DC5E7D68ABA5}
DAT 1497516127
ORG {C947C521-ADCC-4C3C-9DA5-BFDAEC587CD0}
DAT 1497516062
ATT NAME</a:History>
<a:UseParentNamespace>0</a:UseParentNamespace>
<a:PersistentCode>SEQUENCE</a:PersistentCode>
<c:Attributes>
<o:Attribute Id="o41">
<a:ObjectID>8B9CB262-DA70-47ED-9F15-72F84800AE6C</a:ObjectID>
<a:Name>seq_id</a:Name>
<a:Code>seqId</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {A6C4D85B-FCC4-418C-8902-25E5C71C88F6}
DAT 1497870918
ORG {0549250A-9D61-4B03-BE6A-B23260C502A8}
DAT 1497516127
ORG {0E96745E-7882-4C17-9EE6-451F699A516B}
DAT 1497516062
ATT DTTP
ATT MLEN</a:History>
<a:DataType>java.lang.String</a:DataType>
<a:PersistentDataType>VA3</a:PersistentDataType>
<a:PersistentLength>3</a:PersistentLength>
<a:PersistentCode>SEQ_ID</a:PersistentCode>
<a:Multiplicity>1..1</a:Multiplicity>
</o:Attribute>
<o:Attribute Id="o42">
<a:ObjectID>EBC64F79-92E5-4399-8DCD-1D9F56DC9DA7</a:ObjectID>
<a:Name>seq_nom_long</a:Name>
<a:Code>seqNomLong</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {B9E35197-0ACB-4CA6-995D-9452700FE64B}
DAT 1497870918
ORG {BA0B419F-7CDF-4BA7-A69C-37045D123A58}
DAT 1497516127
ORG {E0EBE29C-CC02-4424-8955-883164A5A5DF}
DAT 1497516062
ATT DTTP
ATT MLEN</a:History>
<a:DataType>java.lang.String</a:DataType>
<a:PersistentDataType>VA200</a:PersistentDataType>
<a:PersistentLength>200</a:PersistentLength>
<a:PersistentCode>SEQ_NOM_LONG</a:PersistentCode>
<a:Multiplicity>1..1</a:Multiplicity>
</o:Attribute>
<o:Attribute Id="o43">
<a:ObjectID>1A324E37-1549-4097-8D74-5F08677F6AEE</a:ObjectID>
<a:Name>seq_nom_court</a:Name>
<a:Code>seqNomCourt</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {FAEDD83D-A006-4C6E-B736-9C308CDADBB3}
DAT 1497870918
ORG {3478A7AA-5411-4A67-8ACD-FA08420C6D35}
DAT 1497516127
ORG {1023E671-6FB8-4750-ABA1-40AD487F6EC9}
DAT 1497516062
ATT DTTP
ATT MLEN</a:History>
<a:DataType>java.lang.String</a:DataType>
<a:PersistentDataType>VA200</a:PersistentDataType>
<a:PersistentLength>200</a:PersistentLength>
<a:PersistentCode>SEQ_NOM_COURT</a:PersistentCode>
<a:Multiplicity>1..1</a:Multiplicity>
</o:Attribute>
</c:Attributes>
<c:Identifiers>
<o:Identifier Id="o44">
<a:ObjectID>BF1998FD-CF17-48CE-B15A-115B28B01FD6</a:ObjectID>
<a:Name>seq_id</a:Name>
<a:Code>SEQ_ID</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {42DA82DD-D894-4658-AD57-DAE674EF4158}
DAT 1497870918
ORG {005E16BB-FB18-499E-8D7A-1AF9F6BFEC3C}
DAT 1497516127
ORG {A7233C6C-6815-42FB-BB3F-145E2AEB74E8}
DAT 1497516062</a:History>
<c:Identifier.Attributes>
<o:Attribute Ref="o41"/>
</c:Identifier.Attributes>
</o:Identifier>
</c:Identifiers>
<c:PrimaryIdentifier>
<o:Identifier Ref="o44"/>
</c:PrimaryIdentifier>
</o:Class>
<o:Class Id="o28">
<a:ObjectID>BD9DEF8C-460D-4439-8649-118540769BEB</a:ObjectID>
<a:Name>stag</a:Name>
<a:Code>Stag</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {0B735A8A-7192-4F3E-8374-192E92EEB50F}
DAT 1497870918
ORG {66779856-9512-4CDA-915D-42152391B422}
DAT 1497516127
ORG {C699E7CC-49E7-4E8B-9A3C-C60703A0787C}
DAT 1497516062
ATT NAME
ATT CODE</a:History>
<a:UseParentNamespace>0</a:UseParentNamespace>
<a:PersistentCode>STAG</a:PersistentCode>
<c:Attributes>
<o:Attribute Id="o45">
<a:ObjectID>0D921999-9EA8-49B8-80EF-45229F72B404</a:ObjectID>
<a:Name>stag_login</a:Name>
<a:Code>stagLogin</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {CBD2BC34-3954-4EF7-9D05-C264EF21D662}
DAT 1497870918
ORG {81F6FC8C-E31B-49F5-9580-688428C35D81}
DAT 1497516127
ORG {910BE35E-2C50-47BE-B699-4FC1A72F2BF0}
DAT 1497516062
ATT DTTP
ATT MLEN</a:History>
<a:DataType>java.lang.String</a:DataType>
<a:PersistentDataType>VA8</a:PersistentDataType>
<a:PersistentLength>8</a:PersistentLength>
<a:PersistentCode>STAG_LOGIN</a:PersistentCode>
<a:Multiplicity>1..1</a:Multiplicity>
</o:Attribute>
<o:Attribute Id="o46">
<a:ObjectID>F2B09057-2CF2-4C75-9213-972015E349AC</a:ObjectID>
<a:Name>stag_mdp</a:Name>
<a:Code>stagMdp</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {2901EA8E-018D-4C81-B9A8-24B84D98F168}
DAT 1497870918
ORG {797A09DF-1395-46CF-8DF5-BE1F183BE381}
DAT 1497516127
ORG {BDE3CF70-7FF1-49BF-AB31-E5F2D8846DDF}
DAT 1497516062
ATT DTTP
ATT MLEN</a:History>
<a:DataType>java.lang.String</a:DataType>
<a:PersistentDataType>VA30</a:PersistentDataType>
<a:PersistentLength>30</a:PersistentLength>
<a:PersistentCode>STAG_MDP</a:PersistentCode>
<a:Multiplicity>1..1</a:Multiplicity>
</o:Attribute>
<o:Attribute Id="o47">
<a:ObjectID>E1E6C0EE-0B5A-4BD2-9615-015341105AD7</a:ObjectID>
<a:Name>stag_nom</a:Name>
<a:Code>stagNom</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {4C54C38D-60E8-4A4F-A00B-C9C701794E3D}
DAT 1497870918
ORG {C2AB1CD5-734C-4011-AD5B-740512215221}
DAT 1497516127
ORG {E6EE4837-61B7-4DFE-B53C-C35E19263375}
DAT 1497516062
ATT DTTP
ATT MLEN</a:History>
<a:DataType>java.lang.String</a:DataType>
<a:PersistentDataType>VA60</a:PersistentDataType>
<a:PersistentLength>60</a:PersistentLength>
<a:PersistentCode>STAG_NOM</a:PersistentCode>
<a:Multiplicity>1..1</a:Multiplicity>
</o:Attribute>
<o:Attribute Id="o48">
<a:ObjectID>558B7AC7-9359-4AF8-AF41-2D313CCD9C3A</a:ObjectID>
<a:Name>stag_prenom</a:Name>
<a:Code>stagPrenom</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {97870889-1B3B-4D9D-A047-193A76779D8F}
DAT 1497870918
ORG {3D508B6A-A271-4F97-B462-0346076CE017}
DAT 1497516127
ORG {640A20CC-0842-426C-A7B2-98ADEA7305EB}
DAT 1497516062
ATT DTTP
ATT MLEN</a:History>
<a:DataType>java.lang.String</a:DataType>
<a:PersistentDataType>VA60</a:PersistentDataType>
<a:PersistentLength>60</a:PersistentLength>
<a:PersistentCode>STAG_PRENOM</a:PersistentCode>
<a:Multiplicity>1..1</a:Multiplicity>
</o:Attribute>
<o:Attribute Id="o49">
<a:ObjectID>D527FBDC-4C23-46C8-9EDA-45D0A03FB0F2</a:ObjectID>
<a:Name>stag_num_tel_admi</a:Name>
<a:Code>stagNumTelAdmi</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {64924B28-630B-4215-9F69-C8FA7C5AAB73}
DAT 1497870918
ORG {1EAA2B82-C5D0-4057-B077-16891DC67D23}
DAT 1497516127
ORG {C48B0B03-A9DB-4A6F-B54C-472968B061DA}
DAT 1497516062
ATT DTTP
ATT MLEN</a:History>
<a:DataType>java.lang.String</a:DataType>
<a:PersistentDataType>VA10</a:PersistentDataType>
<a:PersistentLength>10</a:PersistentLength>
<a:PersistentCode>STAG_NUM_TEL_ADMI</a:PersistentCode>
</o:Attribute>
<o:Attribute Id="o50">
<a:ObjectID>FCBFDEF9-7378-4C8C-B451-C13E3868FFB7</a:ObjectID>
<a:Name>stag_num_tel_forma</a:Name>
<a:Code>stagNumTelForma</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {EF9A0C68-3BC9-40D2-A08C-C4A3573DD5E5}
DAT 1497870918
ORG {E85D8374-38D5-4BEA-9B7D-BA48925C2A60}
DAT 1497516127
ORG {DD9F3B03-C688-4F72-868F-B621F8DB428E}
DAT 1497516062
ATT DTTP
ATT MLEN</a:History>
<a:DataType>java.lang.String</a:DataType>
<a:PersistentDataType>VA10</a:PersistentDataType>
<a:PersistentLength>10</a:PersistentLength>
<a:PersistentCode>STAG_NUM_TEL_FORMA</a:PersistentCode>
</o:Attribute>
<o:Attribute Id="o51">
<a:ObjectID>7C14082C-7844-4627-A26F-D3120C0F08EB</a:ObjectID>
<a:Name>stag_adresse</a:Name>
<a:Code>stagAdresse</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {AB995452-187B-40DD-B9D2-F30A15F8A3B0}
DAT 1497870918
ORG {499C40AE-8FD3-4249-AADB-5CDCD9C0D754}
DAT 1497516127
ORG {83E14B2C-6A20-4472-AABA-45B7ECB8EFFB}
DAT 1497516062
ATT DTTP
ATT MLEN</a:History>
<a:DataType>java.lang.String</a:DataType>
<a:PersistentDataType>VA200</a:PersistentDataType>
<a:PersistentLength>200</a:PersistentLength>
<a:PersistentCode>STAG_ADRESSE</a:PersistentCode>
</o:Attribute>
<o:Attribute Id="o52">
<a:ObjectID>8BD27E0B-AEF9-40A8-889D-8F733D5F74DF</a:ObjectID>
<a:Name>stag_mail</a:Name>
<a:Code>stagMail</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {AA1C68E2-5419-4086-A2EE-3BAC60B2E837}
DAT 1497870918
ORG {176EE876-264D-4736-B324-295D61D3E6A8}
DAT 1497516127
ORG {FEE08933-16D1-480B-8693-8A272151649C}
DAT 1497516062
ATT DTTP
ATT MLEN</a:History>
<a:DataType>java.lang.String</a:DataType>
<a:PersistentDataType>VA50</a:PersistentDataType>
<a:PersistentLength>50</a:PersistentLength>
<a:PersistentCode>STAG_MAIL</a:PersistentCode>
</o:Attribute>
<o:Attribute Id="o53">
<a:ObjectID>D8967FF6-1F97-4493-8D32-51BF8A6F45DB</a:ObjectID>
<a:Name>stag_mail_forma</a:Name>
<a:Code>stagMailForma</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {DF9AFBDB-604D-479E-BF32-F7FC910DA096}
DAT 1497870918
ORG {75B95B42-1C9B-4B97-94AB-73E3B404AAC4}
DAT 1497516127
ORG {E6DDA32B-1FA8-4392-B47C-41186C853EC2}
DAT 1497516062
ATT DTTP
ATT MLEN</a:History>
<a:DataType>java.lang.String</a:DataType>
<a:PersistentDataType>VA50</a:PersistentDataType>
<a:PersistentLength>50</a:PersistentLength>
<a:PersistentCode>STAG_MAIL_FORMA</a:PersistentCode>
</o:Attribute>
<o:Attribute Id="o54">
<a:ObjectID>603E4218-B828-4053-9E50-4D7C13796992</a:ObjectID>
<a:Name>stag_humeur</a:Name>
<a:Code>stagHumeur</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {18887203-E59A-4671-89EB-974E13E7F73A}
DAT 1497870918
ORG {C1FCEA63-89F6-4EFD-9DD0-5BD96BE317DB}
DAT 1497516127
ORG {365AD6B3-DA38-4684-93D1-D22627594527}
DAT 1497516062
ATT DTTP
ATT MLEN</a:History>
<a:DataType>java.lang.String</a:DataType>
<a:PersistentDataType>VA20</a:PersistentDataType>
<a:PersistentLength>20</a:PersistentLength>
<a:PersistentCode>STAG_HUMEUR</a:PersistentCode>
</o:Attribute>
</c:Attributes>
<c:Identifiers>
<o:Identifier Id="o55">
<a:ObjectID>386B0434-0E37-45EC-A628-56F067A6DC55</a:ObjectID>
<a:Name>stag_login</a:Name>
<a:Code>STAG_LOGIN</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {28EA4375-A2BE-4D8B-81AB-DCBCC6AEF383}
DAT 1497870918
ORG {725EBB49-2DAB-43D6-B8E1-2120405685E8}
DAT 1497516127
ORG {EF983898-694E-431C-B00E-B77CA3D5E46A}
DAT 1497516062</a:History>
<c:Identifier.Attributes>
<o:Attribute Ref="o45"/>
</c:Identifier.Attributes>
</o:Identifier>
</c:Identifiers>
<c:PrimaryIdentifier>
<o:Identifier Ref="o55"/>
</c:PrimaryIdentifier>
</o:Class>
<o:Class Id="o29">
<a:ObjectID>A39439C4-72D4-4A7D-B4F2-5EF85396C951</a:ObjectID>
<a:Name>module</a:Name>
<a:Code>Module</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {6635F80C-66E8-4DD5-956C-0DC7E61A9EBA}
DAT 1497870918
ORG {B8513352-28AF-4EE8-ADEB-27385A2B32CF}
DAT 1497516127
ORG {ADB4983B-5DEA-4E45-8E33-AFBED7E2DCD4}
DAT 1497516062
ATT NAME</a:History>
<a:UseParentNamespace>0</a:UseParentNamespace>
<a:PersistentCode>MODULE</a:PersistentCode>
<c:Attributes>
<o:Attribute Id="o56">
<a:ObjectID>1FE8B419-D19C-4D27-AF77-03BF600C08F4</a:ObjectID>
<a:Name>mod_id</a:Name>
<a:Code>modId</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {075D764B-484D-4755-A5E2-8AA654C4478D}
DAT 1497870918
ORG {09B693D3-A79D-4D81-964F-5813DA9C9067}
DAT 1497516127
ORG {B00BFD9A-431D-458D-92B0-234D151FC332}
DAT 1497516062
ATT DTTP
ATT MLEN</a:History>
<a:DataType>java.lang.String</a:DataType>
<a:PersistentDataType>VA3</a:PersistentDataType>
<a:PersistentLength>3</a:PersistentLength>
<a:PersistentCode>MOD_ID</a:PersistentCode>
<a:Multiplicity>1..1</a:Multiplicity>
</o:Attribute>
<o:Attribute Id="o57">
<a:ObjectID>44D01A35-3608-40BA-A94A-1D296E76F13E</a:ObjectID>
<a:Name>mod_nom_long</a:Name>
<a:Code>modNomLong</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {8FEABB67-127C-4CCF-B351-1CB486D8FC65}
DAT 1497870918
ORG {0DB4C93F-9F9D-46A7-B614-6569A30649E7}
DAT 1497516127
ORG {8D7FD427-B0E4-49CC-BC5E-15641622867C}
DAT 1497516062
ATT DTTP
ATT MLEN</a:History>
<a:DataType>java.lang.String</a:DataType>
<a:PersistentDataType>VA200</a:PersistentDataType>
<a:PersistentLength>200</a:PersistentLength>
<a:PersistentCode>MOD_NOM_LONG</a:PersistentCode>
<a:Multiplicity>1..1</a:Multiplicity>
</o:Attribute>
<o:Attribute Id="o58">
<a:ObjectID>553C64C5-6C5B-473B-B0C1-2788BCD3A4BA</a:ObjectID>
<a:Name>mod_nom_court</a:Name>
<a:Code>modNomCourt</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {4AFC48BB-CE7B-47AD-A3FA-4C13F035C83A}
DAT 1497870918
ORG {87A2FA29-B59F-4F10-981A-75737C97CFC7}
DAT 1497516127
ORG {54EAE9E4-9536-4962-B7B0-ABAB826B8328}
DAT 1497516062
ATT DTTP
ATT MLEN</a:History>
<a:DataType>java.lang.String</a:DataType>
<a:PersistentDataType>VA200</a:PersistentDataType>
<a:PersistentLength>200</a:PersistentLength>
<a:PersistentCode>MOD_NOM_COURT</a:PersistentCode>
<a:Multiplicity>1..1</a:Multiplicity>
</o:Attribute>
</c:Attributes>
<c:Identifiers>
<o:Identifier Id="o59">
<a:ObjectID>268482FC-0687-4499-9A31-8BEAE2180519</a:ObjectID>
<a:Name>mod_id</a:Name>
<a:Code>MOD_ID</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {ADD6510F-BCE8-4D13-94F4-A18EE0A52B68}
DAT 1497870918
ORG {41C60ECB-1FDF-4C77-903F-73F716EAA96F}
DAT 1497516127
ORG {3A3864AD-9B53-442D-8C18-E04839B80B1A}
DAT 1497516062</a:History>
<c:Identifier.Attributes>
<o:Attribute Ref="o56"/>
</c:Identifier.Attributes>
</o:Identifier>
</c:Identifiers>
<c:PrimaryIdentifier>
<o:Identifier Ref="o59"/>
</c:PrimaryIdentifier>
</o:Class>
</c:Classes>
<c:Associations>
<o:Association Id="o11">
<a:ObjectID>F088810F-949D-4F91-8E23-9DCB5D70ABD9</a:ObjectID>
<a:Name>Categoriser</a:Name>
<a:Code>categoriser</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {5DB85849-D79C-43DE-ADED-4665ABDA79E4}
DAT 1497870918
ORG {D5B72C7D-0431-4641-AD7C-C6E08E883529}
DAT 1497516127
ORG {7DB28A37-BE49-4A1F-90A4-4DFAECD25714}
DAT 1497516062</a:History>
<a:RoleAIndicator>C</a:RoleAIndicator>
<a:RoleAMultiplicity>1..1</a:RoleAMultiplicity>
<a:RoleBMultiplicity>0..*</a:RoleBMultiplicity>
<a:RoleANavigability>1</a:RoleANavigability>
<a:ExtendedAttributesText>{0DEDDB90-46E2-45A0-886E-411709DA0DC9},Java,224={72FA5C48-5524-4DF7-8187-ABB19AB5AF9E},roleAContainer,6=&lt;None&gt;
{F6FFC71C-C472-4261-A710-B0BCC0BF4D58},roleAImplementationClass,6=&lt;None&gt;
{C11C9F66-6453-43A2-8824-6654518CF65A},roleBImplementationClass,17=java.util.HashSet

</a:ExtendedAttributesText>
<c:Object1>
<o:Class Ref="o27"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o29"/>
</c:Object2>
</o:Association>
<o:Association Id="o14">
<a:ObjectID>B24B3B85-802B-44DD-B261-FA3F606B412A</a:ObjectID>
<a:Name>Composer</a:Name>
<a:Code>composer</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {A723C949-A317-44F4-828B-4CD5AB4125C4}
DAT 1497870918
ORG {A15C3AE2-A38A-4D7F-A870-BE565F40B3FA}
DAT 1497516127
ORG {0548383E-53D2-4E0B-96A6-685C647F5608}
DAT 1497516062
ATT CRDB
ATT CMNB
ATT MNDB</a:History>
<a:RoleAIndicator>C</a:RoleAIndicator>
<a:RoleAMultiplicity>1..1</a:RoleAMultiplicity>
<a:RoleBMultiplicity>0..*</a:RoleBMultiplicity>
<a:RoleANavigability>1</a:RoleANavigability>
<a:ExtendedAttributesText>{0DEDDB90-46E2-45A0-886E-411709DA0DC9},Java,224={72FA5C48-5524-4DF7-8187-ABB19AB5AF9E},roleAContainer,6=&lt;None&gt;
{F6FFC71C-C472-4261-A710-B0BCC0BF4D58},roleAImplementationClass,6=&lt;None&gt;
{C11C9F66-6453-43A2-8824-6654518CF65A},roleBImplementationClass,17=java.util.HashSet

</a:ExtendedAttributesText>
<c:Object1>
<o:Class Ref="o25"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o27"/>
</c:Object2>
</o:Association>
<o:Association Id="o17">
<a:ObjectID>F9CBC746-A9AE-42FA-8133-B716CB63DDAF</a:ObjectID>
<a:Name>Evaluer</a:Name>
<a:Code>evaluer</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {F4269C43-7A7B-40B9-9F6D-233AB356588F}
DAT 1497870918
ORG {4FABDF50-F8F9-4CC2-BCBD-DE3853BE59E5}
DAT 1497516127
ORG {6E98A050-3186-4CC3-9A6F-300AA61535F1}
DAT 1497516062
ATT CRDB
ATT CMNB
ATT MNDB</a:History>
<a:RoleAMultiplicity>1..1</a:RoleAMultiplicity>
<a:RoleBMultiplicity>0..*</a:RoleBMultiplicity>
<a:RoleANavigability>1</a:RoleANavigability>
<a:ExtendedAttributesText>{0DEDDB90-46E2-45A0-886E-411709DA0DC9},Java,224={72FA5C48-5524-4DF7-8187-ABB19AB5AF9E},roleAContainer,6=&lt;None&gt;
{F6FFC71C-C472-4261-A710-B0BCC0BF4D58},roleAImplementationClass,6=&lt;None&gt;
{C11C9F66-6453-43A2-8824-6654518CF65A},roleBImplementationClass,17=java.util.HashSet

</a:ExtendedAttributesText>
<c:Object1>
<o:Class Ref="o24"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o25"/>
</c:Object2>
</o:Association>
<o:Association Id="o20">
<a:ObjectID>2D4E21E8-4656-455F-AC20-E6536CDC7CC7</a:ObjectID>
<a:Name>Realiser</a:Name>
<a:Code>realiser</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {56F649C4-0C86-44F9-8830-4CEB2BB77F4C}
DAT 1497870918
ORG {9D3A6CC8-5B17-4B5C-AC4E-61A03F23FF52}
DAT 1497516127
ORG {6D4FF7B8-A386-4928-BA4A-635632EE07C8}
DAT 1497516062</a:History>
<a:RoleAMultiplicity>1..1</a:RoleAMultiplicity>
<a:RoleBMultiplicity>0..*</a:RoleBMultiplicity>
<a:RoleANavigability>1</a:RoleANavigability>
<a:ExtendedAttributesText>{0DEDDB90-46E2-45A0-886E-411709DA0DC9},Java,224={72FA5C48-5524-4DF7-8187-ABB19AB5AF9E},roleAContainer,6=&lt;None&gt;
{F6FFC71C-C472-4261-A710-B0BCC0BF4D58},roleAImplementationClass,6=&lt;None&gt;
{C11C9F66-6453-43A2-8824-6654518CF65A},roleBImplementationClass,17=java.util.HashSet

</a:ExtendedAttributesText>
<c:Object1>
<o:Class Ref="o24"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o28"/>
</c:Object2>
</o:Association>
<o:Association Id="o23">
<a:ObjectID>C7E8BCEE-8CA6-4A44-B7A7-C80A3526DDA8</a:ObjectID>
<a:Name>Definir</a:Name>
<a:Code>definir</a:Code>
<a:CreationDate>1497870917</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870917</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:History>ORG {782799E4-540C-4604-9BF4-4BB4CC1C9382}
DAT 1497870918
ORG {DC27D4E2-B0BB-4F04-922D-5E455DEB0132}
DAT 1497516127
ORG {F21CECA8-7332-4FF1-AF17-78D6E3467B67}
DAT 1497516062</a:History>
<a:RoleAMultiplicity>1..1</a:RoleAMultiplicity>
<a:RoleBMultiplicity>0..*</a:RoleBMultiplicity>
<a:RoleANavigability>1</a:RoleANavigability>
<a:ExtendedAttributesText>{0DEDDB90-46E2-45A0-886E-411709DA0DC9},Java,224={72FA5C48-5524-4DF7-8187-ABB19AB5AF9E},roleAContainer,6=&lt;None&gt;
{F6FFC71C-C472-4261-A710-B0BCC0BF4D58},roleAImplementationClass,6=&lt;None&gt;
{C11C9F66-6453-43A2-8824-6654518CF65A},roleBImplementationClass,17=java.util.HashSet

</a:ExtendedAttributesText>
<c:Object1>
<o:Class Ref="o24"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o26"/>
</c:Object2>
</o:Association>
</c:Associations>
<c:TargetModels>
<o:TargetModel Id="o60">
<a:ObjectID>65D7A0BE-D010-441B-9B4F-449427E9E3AB</a:ObjectID>
<a:Name>Java</a:Name>
<a:Code>Java</a:Code>
<a:CreationDate>1497870906</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870906</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:TargetModelURL>file:///%_OBJLANG%/java5-j2ee14.xol</a:TargetModelURL>
<a:TargetModelID>0DEDDB90-46E2-45A0-886E-411709DA0DC9</a:TargetModelID>
<a:TargetModelClassID>1811206C-1A4B-11D1-83D9-444553540000</a:TargetModelClassID>
<c:SessionShortcuts>
<o:Shortcut Ref="o4"/>
</c:SessionShortcuts>
</o:TargetModel>
<o:TargetModel Id="o61">
<a:ObjectID>A2433CCF-766E-4F64-983D-942C851E1DB0</a:ObjectID>
<a:Name>WSDL for Java</a:Name>
<a:Code>WSDLJava</a:Code>
<a:CreationDate>1497870916</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870916</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:TargetModelURL>file:///%_XEM%/WSDLJ2EE.xem</a:TargetModelURL>
<a:TargetModelID>C8F5F7B2-CF9D-4E98-8301-959BB6E86C8A</a:TargetModelID>
<a:TargetModelClassID>186C8AC3-D3DC-11D3-881C-00508B03C75C</a:TargetModelClassID>
<c:SessionShortcuts>
<o:Shortcut Ref="o5"/>
</c:SessionShortcuts>
</o:TargetModel>
<o:TargetModel Id="o62">
<a:ObjectID>0203B2C2-FA28-4222-86F2-E49C9575791B</a:ObjectID>
<a:Name>MPD1 - Suivi Pédagogique</a:Name>
<a:Code>MPD1___SUIVI_PEDAGOGIQUE</a:Code>
<a:CreationDate>1497870918</a:CreationDate>
<a:Creator>Afpa</a:Creator>
<a:ModificationDate>1497870918</a:ModificationDate>
<a:Modifier>Afpa</a:Modifier>
<a:TargetModelURL>file:///%[PRJ_ROOT_DIR]%/MPD1 - Suivi Pédagogique.mpd</a:TargetModelURL>
<a:TargetModelID>850354A3-94EE-475F-A039-998E8DDF4F80</a:TargetModelID>
<a:TargetModelClassID>CDE44E21-9669-11D1-9914-006097355D9B</a:TargetModelClassID>
<c:SessionShortcuts>
<o:Shortcut Ref="o3"/>
</c:SessionShortcuts>
</o:TargetModel>
</c:TargetModels>
</o:Model>
</c:Children>
</o:RootObject>

</Model>