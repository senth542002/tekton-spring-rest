# tekton-spring-rest

contact: Tessler, Micah (M.B.) <mtessler@ford.com>
https://github.ford.com/RGUIMA21/spring-cloud-config-server

#GCP:
gcloud container clusters get-credentials tekton-cluster-1 --zone=us-east1
#google cloud console:
----------------------
gcloud container clusters get-credentials tekton-cluster-1 --zone us-east1

kubectl get nodes


https://github.com/tektoncd/pipeline/blob/main/docs/install.md

#Tekton Installation:
--------------------
1) Run the following command to install Tekton Pipelines and its dependencies:
kubectl apply --filename https://storage.googleapis.com/tekton-releases/pipeline/latest/release.yaml

2) Monitor the installation using the following command until all components show a Running status:
kubectl get pods --namespace tekton-pipelines --watch


#Tekton cli Installation
-----------------------

sudo apt update;sudo apt install -y gnupg
sudo apt-key adv --keyserver keyserver.ubuntu.com --recv-keys 3EFE0E0A2F2F60AA
echo "deb http://ppa.launchpad.net/tektoncd/cli/ubuntu focal main"|sudo tee /etc/apt/sources.list.d/tektoncd-ubuntu-cli.list
sudo apt update && sudo apt install -y tektoncd-cli


https://github.com/tektoncd/pipeline/blob/main/docs/tutorial.md

#Apply your Task YAML file as follows:
kubectl apply -f <name-of-task-file.yaml>

#To see details about your created Task, use the following command:
tkn task describe echo-hello-world <metadata name>

#To run this Task, instantiate it using a TaskRun:

#Apply your Task Run YAML file as follows:
kubectl apply -f <name-of-taskrun-file.yaml>

#To check whether running your TaskRun succeeded, use the following command:
tkn taskrun describe echo-hello-world-task-run <metadata name>

#To see more detail about the execution of your TaskRun, view its logs as follows:
tkn taskrun logs echo-hello-world-task-run

#expose the tekton-dashboard to external ip:
kubectl expose deployment tekton-dashboard --namespace=tekton-pipelines --type=LoadBalancer --name=tekton-dashboard-service --port=9097

kubectl get services --namespace=tekton-pipelines --watch



##Tekton Dashboard:
------------------
https://github.com/tektoncd/dashboard

#Install:
#Run the following command to install Tekton Dashboard and its dependencies:
kubectl apply --filename https://storage.googleapis.com/tekton-releases/dashboard/latest/tekton-dashboard-release.yaml

#Monitor the installation using the following command until all components show a Running status:
kubectl get pods --namespace tekton-pipelines --watch

#Accessing the Dashboard
------------------------
#By default, the Dashboard is not exposed outside the cluster.

Using kubectl proxy -> kubectl proxy
Browse http://localhost:8001/api/v1/namespaces/tekton-pipelines/services/tekton-dashboard:http/proxy/ to access your Dashboard.

Using kubectl port-forward -> kubectl --namespace tekton-pipelines port-forward svc/tekton-dashboard 9097:9097

kubectl expose --namespace=tekton-pipelines deployment tekton-dashboard --type=LoadBalancer --port=9097 --name=tekton-dashboard-service

Browse http://localhost:9097 to access your Dashboard.
http://35.231.172.237:9097/

#Google Container Registry:
--------------------------
#Build Docker Image:
docker build -t gcr.io/dropfire/tekton-spring-rest-service:v1 .

#Find Docker images
docker images

#Run Docker Image:
docker run --rm -p 8080:8080 gcr.io/dropfire/tekton-spring-rest-service:v1 .

https://cloud.google.com/kubernetes-engine/docs/tutorials/hello-app

#Pushing Docker Image to container registry:

gcloud auth login
gcloud config set project dropfire
gcloud services enable containerregistry.googleapis.com
gcloud auth configure-docker

docker push gcr.io/dropfire/tekton-spring-rest-service:v1

kubectl create secret docker-registry regcred --docker-server=gcr.io --docker-username=vsenth17@qad.ford.com --docker-password=Spookycat@123 --docker-email=vsenth17@ford.com


Tutorial: Hands-On Intro to Cloud-Native CI/CD with Tekton - Jan Kleinert & Joel Lord, Red Hat
https://github.com/joellord/handson-tekton

https://docs.openshift.com/container-platform/4.4/cli_reference/tkn_cli/op-tkn-reference.html#task-start
https://tekton.dev/vault/pipelines-v0.16.3/auth/
https://tekton.dev/docs/pipelines/taskruns/#example-taskrun-with-a-referenced-task
https://redhat-scholars.github.io/tekton-tutorial/tekton-tutorial/tasks.html

https://hub.tekton.dev/

Gradle build
--------------------

kubectl apply -f https://raw.githubusercontent.com/tektoncd/catalog/master/task/jib-gradle/0.2/jib-gradle.yaml
https://github.com/tektoncd/catalog/blob/main/task/git-clone/0.3/samples/git-clone-checking-out-a-branch.yaml
https://redhat-scholars.github.io/tekton-tutorial/tekton-tutorial/workspaces.html


