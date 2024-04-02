FROM tomcat
COPY target/stsm-ci.war /usr/local/tomcat/webapps/
EXPOSE 8080
