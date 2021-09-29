# M223: Punchclock Backend
Dies ist der backend für den Punchclock Client. Mit dem Punchclock Backend kann man sich mit einen Benutzer Authentifizieren und man kann drei Enititäten(Entry, Place und Category) verwalten.

## Loslegen
Folgende Schritte befolgen um loszulegen:
1. Sicherstellen, dass JDK 12 installiert und in der Umgebungsvariable `path` definiert ist.
1. Ins Verzeichnis der Applikation wechseln und über die Kommandozeile mit `./gradlew bootRun` oder `./gradlew.bat bootRun` starten
1. Unittest mit `./gradlew test` oder `./gradlew.bat test` ausführen.
1. Ein ausführbares JAR kann mit `./gradlew bootJar` oder `./gradlew.bat bootJar` erstellt werden.

### Loslegen
Beim dem start werden die alten Daten gelöscht und mit neuen ersetzt. Mit einem SQL Script den man in der Datei data.sql unter resources findet.

Folgende Dienste stehen während der Ausführung im Profil `dev` zur Verfügung:
- Login-Schnittstelle der Applikation: http://localhost:8081/login
- SignOut-Schnittstelle der Applikation: http://localhost:8081/sign-out
- REST-Schnittstelle der Applikation: http://localhost:8081/(categories/places/entries)
- Dashboard der H2 Datenbank: http://localhost:8081/h2-console