
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

     docker build -t mtech/phoneshop .

Push Docker image

     - docker tag mtech/phoneshop farhanejaz/mtechphoneshop
     - docker login -u <your-user-name>
     - docker push farhanejaz/mtechphoneshop

Fig: Docker image pushed 

![Alt text](screenshots/dockerhub.PNG "image pushed")

Pull Docker Image

      docker pull farhanejaz/mtechphoneshop


# Install
---------

## Create Namespace (Prerequisite)
      kubectl create ns 230928005

Fig: describe namespace

![Alt text](screenshots/namespace.PNG "describe namespace")


## Ingress Controller (Prerequisite)
Installed in default namespace 'ingress-nginx'

       - kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v1.10.0/deploy/static/provider/cloud/deploy.yaml
       - kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v1.10.0/deploy/static/provider/baremetal/deploy.yaml

Fig: Ingress controller

![Alt text](screenshots/ingress-controller.PNG "ingress controller")

## Mongo (Kustomize)
     - cd Kustomize/mongo
     - Kubectl apply -k . -n 230928005

## App Services

### Using Docker

Three environment variables are required
- SERVICE_KEY can have values ('serviceA','serviceB','serviceC')
- SERVICE_NAME can have values ('iPhone','Samsung','OPPO')
- MONGO_CONNSTR As per your instance. If you have installed using the steps defined below in this document, the value mentioned here should work.

Example to deploy as ServiceA

      docker run -itd -p 8080:8080 \
      -e SERVICE_KEY=serviceA \
      -e SERVICE_NAME=iPhone \
      -e MONGO_CONNSTR=mongodb://adminuser:password123@172.17.0.1:32000/serviceA?authSource=admin \
      --name serviceA mtech/phoneshop

### Using Kubernetes (Kustomize)

      - cd Kustomize/apps
      - Kubectl apply -k . -n 230928005

Fig: Mongo and Applications deployed to 230928005 namespace

![Alt text](screenshots/apps.PNG "apps deployed")

Fig: Screenshot Service A

![Alt text](screenshots/service-a.PNG "service A")

Fig: Screenshot Service B

![Alt text](screenshots/service-b.PNG "service B")

Fig: Screenshot Service B

![Alt text](screenshots/service-c.PNG "service C")