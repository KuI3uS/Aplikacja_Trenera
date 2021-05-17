FROM jboss/wildfly:18.0.0.Final

ADD app/target/projekt.war /opt/jboss/wildfly/standalone/deployments/
ADD tracking/target/tracking.war /opt/jboss/wildfly/standalone/deployments/

#RUN /opt/jboss/wildfly/bin/add-user.sh user zaq123 --silent
CMD ["echo Waiting 5 seconds"]
CMD ["sleep", "5"]
CMD ["echo Starting Wildfly"]
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]