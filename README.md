- Tutorial from https://cloud.google.com/sql/docs/postgres/connect-kubernetes-engine#service-account-key
  - Connected using cloud sql proxy with service acount
- Building the docker image
  - docker build -t us-east1-docker.pkg.dev/${PROJECT_ID}/todos-repo/todos:<version> .
- Running the image
  - docker run --rm -p 8080:8080 us-east1-docker.pkg.dev/${PROJECT_ID}/todos-repo/todos:<version>
- Pushing docker container to remote
  - docker push us-east1-docker.pkg.dev/${PROJECT_ID}/todos-repo/todos:v5
  