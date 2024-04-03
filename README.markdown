
# Phone Service: Demo Project
----------------------------------------------------
 
 This is an example project using "Thymeleaf + Spring".
 
     
# Build
--------
 
 To build this project you will need Maven 3. You can get it at:
 
     http://maven.apache.org

 Clean compilation products:
 
     mvn clean
     
 Compile:
 
     mvn compile

# Package
---------

Build Docker image

     docker build -t mtech/phoneshop:debug .

Run Docker image

     docker run -itd -p 8080:8080 \
     -e SERVICE_KEY=serviceB \
     -e SERVICE_NAME=Samsung \
     -e MONGO_CONNSTR=mongodb://adminuser:password123@172.17.0.1:32000/serviceB?authSource=admin \
     --name serviceB mtech/phoneshop:debug

Push Docker image

     docker tag mtech/phoneshop:debug farhanejaz/mtechphoneshop:debug
     docker push farhanejaz/mtechphoneshop:debug

Pull Docker Image
     docker pull farhanejaz/mtechphoneshop:debug


# Install
---------

## Ingress Controller (Prerequisite)

## Mongo
     cd Kustomize/mongo
     Kubectl apply -k . -n mtech

## App
     cd Kustomize/apps
     Kubectl apply -k . -n mtech