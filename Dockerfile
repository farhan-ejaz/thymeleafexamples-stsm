#FROM tomcat
#EXPOSE 8080

# https://www.geeksforgeeks.org/how-to-write-dockerfile-for-tomcat/

# Use a minimal base image
FROM ubuntu:20.04

# Set the Tomcat version
ENV TOMCAT_VERSION 10.1.20

# Install dependencies
RUN apt-get update && apt-get install -y openjdk-17-jdk openjdk-17-jre wget dnsutils

RUN wget -O mongosh-2.2.2-linux-x64.tgz https://downloads.mongodb.com/compass/mongosh-2.2.2-linux-x64.tgz
RUN tar -zxvf mongosh-2.2.2-linux-x64.tgz
RUN chmod +x mongosh-2.2.2-linux-x64/bin/mongosh
RUN cp mongosh-2.2.2-linux-x64/bin/mongosh /usr/local/bin/
RUN cp mongosh-2.2.2-linux-x64/bin/mongosh_crypt_v1.so /usr/local/lib/

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
ENV MONGO_CONNSTR mongodb://adminuser:password123@host.docker.internal:32000/${SERVICE_KEY}

COPY target/stsm-ci.war /opt/tomcat/webapps/

# Expose Tomcat port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]