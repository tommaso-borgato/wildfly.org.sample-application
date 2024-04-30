# podman build -t myapp:latest .
# podman tag myapp localhost:5000/myapp
# podman run -it --rm -p 5000:5000 --name registry registry:latest
# podman push --tls-verify=false localhost:5000/myapp
# minikube image load localhost:5000/myapp
ARG runtime_image=quay.io/wildfly/wildfly-runtime:latest
FROM ${runtime_image}
COPY --chown=jboss:root target/server $JBOSS_HOME
RUN chmod -R ug+rwX $JBOSS_HOME
