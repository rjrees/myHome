kind: Template
apiVersion: v1
metadata:
  name: java-template
  alias: java.local

#### OBJECTS ####
objects:
  ##BUILDCONFIG##
  - kind: "BuildConfig"
    apiVersion: "v1"
    metadata:
      name: "${ENV}-java-buildconfig"
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
          dockerfilePath: docker/java/Dockerfile
          env:
            - name: "ENV_NAME"
              value: "${ENV}"
      output:
        to:
          kind: "ImageStreamTag"
          name: "${ENV}-java:latest"

  ##IMAGE STREAM ##

  - kind: ImageStream
    apiVersion: v1
    metadata:
      name: "${ENV}-java"
    spec:
      lookupPolicy:
        local: false
      tags:
        - annotations: null
          from:
            kind: DockerImage
            name: "${docker-registry}:5000/${ENV}/${ENV}-java:latest"
          generation: null
          importPolicy: {}
          name: latest
          referencePolicy:
            type: ""
    status:
      dockerImageRepository: ""

  ##ROUTE##
  - kind: Route
    apiVersion: v1
    metadata:
      name: ${ROUTENAME}
      annotations:
        openshift.io/host.generated: "true"
    spec:
      port:
        targetPort: 443
      to:
        kind: Service
        name: ${ENV}-java
      tls:
        termination: edge

### PARAMETERS ###
parameters:
  - name: ENV
    description: Environment name

  - name: REPO
    description: Git Repository
    value: "'https://github.com/rjrees/myHome.git"

  - name: BRANCH
    description: Git Branch

  - name: ROUTENAME
    description: Route Name
    value: www