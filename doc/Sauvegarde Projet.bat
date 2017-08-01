@echo off
REM @Author Aur�lien Harl�
REM @Version 1
REM @Since 06-06-2017
REM @Description Programme qui sauvegarde le projet en cour dans un dossier dater a la date du jour et creer un fichier Zip dater lui aussi.

REM Couleur officiel des batch d'Aur�lien Harl�
	color 02
	set /a jour = %date:~0,2%
	set /a mois = %date:~3,2%
	set /a annee = %date:~6,4%

REM V�rification de la presence du projet a sauvegard�
	if not exist "D:\Projet\Suivi Stagiaire" goto EOF
	
REM Creation d'une copie pour sauvegarde qui permet l'utilisation de la shadow copie integr� a robocopy
	robocopy "D:\Projet\Suivi Stagiaire" "E:\Save\Projet\%jour%-%mois%-%annee%" /MIR

REM Creation ou update dans un fichier zip dat�
	if exist E:\Save\Projet\%jour%-%mois%-%annee%\%jour%-%mois%-%annee%.zip (

		7z u -tzip "E:\Save\Projet\%jour%-%mois%-%annee%\%jour%-%mois%-%annee%.zip" "E:\Save\Projet\%jour%-%mois%-%annee%"
		
	) else (

		7z a -tzip "E:\Save\Projet\%jour%-%mois%-%annee%\%jour%-%mois%-%annee%.zip" "E:\Save\Projet\%jour%-%mois%-%annee%"
		
	)
	
REM Verifie la presence du support amovible
	if not exist H:\nul goto EOF

REM Creation ou update du fichier zip dat�
	:USB
	if exist H:\Projet.zip (
	
		7z u -tzip "H:\Projet.zip" "E:\Save\Projet\%jour%-%mois%-%annee%"
		
	) else ( 
	
		7z a -tzip "H:\Projet.zip" "E:\Save\Projet\%jour%-%mois%-%annee%"
	
	)
	
REM Fin de script
	:EOF
	echo 
	echo 
	echo 
	echo.
	echo ===========================
	echo #  Fin de la sauvegarde  #
	echo ===========================
	echo.
	pause







































REM setlocal enableDelayedExpansion 
REM Supprime les fichier vieux de plus d'une semaine (5 jour ouvr�s)
REM forfiles /p "E:\Save\Projet\" /S /D -5
REM rmdir /s /q "D:\Projet\Suivi stagiaire\Git\SuiviStagiaire\save\"
REM copy  /Y "E:\Save\Projet\%date:~0,2%-%date:~3,2%-%date:~6,4%\save\%heure%-%minute%\%date:~0,2%-%date:~3,2%-%date:~6,4%.zip.*" "D:\Projet\Suivi stagiaire\Git\SuiviStagiaire\save\"
REM git commit git push
REM Compression en zip de 25 mo
REM 7z u -tzip -v25m "E:\Save\Projet\%date:~0,2%-%date:~3,2%-%date:~6,4%\save\%heure%-%minute%\%date:~0,2%-%date:~3,2%-%date:~6,4%.zip" "E:\Save\Projet\%date:~0,2%-%date:~3,2%-%date:~6,4%"

