pipeline {
    agent any
     environment {
        HEROKU_APP_NAME = "{YOUR HEROKU APPLICATION NAME"
        HEROKU_API_KEY = credentials('YOUR HEROKU API KEY')
        PORT = "8080"
        JAVA_OPTS = "-Xmx512m"
        PROFILE = "{YOUR APPLICATION BRANCH"
        HEROKU_DEBUG= "1"     
    }
    
    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM',
                          branches: [[name: 'dev']],
                          doGenerateSubmoduleConfigurations: false,
                          extensions: [[$class: 'CloneOption', noTags: true, reference: '', shallow: true],
                                       [$class: 'SubmoduleOption', disableSubmodules: false, parentCredentials: true, recursiveSubmodules: false, reference: '', trackingSubmodules: false]],
                          submoduleCfg: [],
                          userRemoteConfigs: [[credentialsId: '6b378d3b-3016-44bb-ae74-b5a1def99845', url: 'https://github.com/semicolon-delivery/enum-v2-backend.git']]])
            } 
        }
       
        stage('Build') {
            steps {
                sh 'mvn clean install'
                
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }
         
        stage ('newman run') {
            steps {
                sh 'newman run https://api.postman.com/collections/26096184-380b125a-a6a3-46f6-a617-f342637f9228?access_key=PMAT-01H00644DM66D8E6X53290YGRC'
            }
        }
         
        stage('Deploy') {
            steps {
                
                withCredentials([usernamePassword(credentialsId: '736e18c5-089c-4e20-9558-f234dfc0880a', usernameVariable: 'HEROKU_EMAIL', passwordVariable: 'HEROKU_API_KEY')]) {
                  
                    sh "heroku plugins:install heroku-cli-deploy"
                 
                    sh "heroku deploy:jar web/target/*.jar --app $HEROKU_APP_NAME"           
                }
            }
        }   
    }   
}
        
