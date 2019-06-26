#!/usr/bin/env groovy

pipeline {
    agent any
    stages {
        stage('Checkout source') {
            steps {
                git url: "${repo}", branch: "${branch}",  credentialsId: "${credentialsId}"
            }
        }
        stage('Build API') {
            steps {
                sh '''
                    gradlew build
                '''
            }
        }
        stage('Test API') {
            steps {
                sh '''

                '''
            }
        }
        stage('Deploy API') {
            steps {
                sh '''

                '''
            }
        }
    }
}
