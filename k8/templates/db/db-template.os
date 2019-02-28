kind: Template
apiVersion: v1
metadata:
  name: db-template
  alias: db.local

#### OBJECTS ####
objects:
  ##BUILDCONFIG##
  - kind: "BuildConfig"
    apiVersion: "v1"
    metadata:
      name: "${ENV}-db-buildconfig"
    spec:
      source:
        type: "Git"
        sourceSecret:
          name: openshift
          #name: ${SECRET}
          # This will be a parameter eventually
        git:
          uri: "'https://github.com/rjrees/myHome.git"
          ref: "${BRANCH}"
      strategy:
        type: "Docker"
        dockerStrategy:
          dockerfilePath: docker/db/Dockerfile
          env:
            - name: "ENV_NAME"
              value: "${ENV}"
      output:
        to:
          kind: "ImageStreamTag"
          name: "${ENV}-db:latest"

  ##IMAGE STREAM ##

  - kind: ImageStream
    apiVersion: v1
    metadata:
      name: "${ENV}-db"
    spec:
      lookupPolicy:
        local: false
      tags:
        - annotations: null
          from:
            kind: DockerImage
            name: "${docker-registry}:5000/${ENV}/${ENV}-db:latest"
          generation: null
          importPolicy: {}
          name: latest
          referencePolicy:
            type: ""
    status:
      dockerImageRepository: ""

  ##ROUTE##
 # - kind: Route
 #   apiVersion: v1
 #   metadata:
 #     name: ${ROUTENAME}
 #     annotations:
 #       openshift.io/host.generated: "true"
 #   spec:
 #     port:
 #       targetPort: 443
 #     to:
 #       kind: Service
 #       name: ${ENV}-db
 #     tls:
 #       termination: edge

### PARAMETERS ###
parameters:
  - name: ENV
    description: Environment name

  - name: SECRET
    description: Secret name
    value: openshift

  - name: REPO
    description: Git Repository
    value: "'https://github.com/rjrees/myHome.git"

  - name: BRANCH
    description: Git Branch
