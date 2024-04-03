# Use a minimal base image
FROM ubuntu:20.04

# Set the Tomcat version
ENV TOMCAT_VERSION 10.1.20

# Install dependencies
RUN apt-get update && apt-get install -y openjdk-17-jdk wget dnsutils

# Download and extract Tomcat
RUN wget -O /tmp/tomcat.tar.gz https://dlcdn.apache.org/tomcat/tomcat-10/v${TOMCAT_VERSION}/bin/apache-tomcat-${TOMCAT_VERSION}.tar.gz && \
    tar xf /tmp/tomcat.tar.gz -C /opt && \
    rm /tmp/tomcat.tar.gz && \
    mv /opt/apache-tomcat-${TOMCAT_VERSION} /opt/tomcat

# Set environment variables
ENV CATALINA_HOME /opt/tomcat
ENV PATH $CATALINA_HOME/bin:$PATH

ENV SERVICE_KEY serviceA
ENV SERVICE_NAME iPhone
ENV MONGO_CONNSTR mongodb://xxx:xxx@ipaddress:port/${SERVICE_KEY}?authSource=admin

# Copy war to Tomcat
COPY target/stsm-ci.war /opt/tomcat/webapps/

# Expose Tomcat port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]