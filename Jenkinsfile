pipeline {
    agent any
    stages {
        stage("Clone Git Repository") {
            steps {
                git(
                    url: "https://github.com/akshay09968/Project-Final-Pahse-5.git",
                    branch: "master",
                    changelog: true,
                    poll: true
                )
            }
        }
        
        stage('Build and run application') {
            steps {
                sh 'java -jar Project-Final-Phase-5-0.0.1-SNAPSHOT.jar & echo $! > ./pid.file &'
          
                }
            }
        stage('Buffer Time') {
            steps {
                sleep(time: 1, unit: 'MINUTES')
            }
        }

        stage('Stop application') {
              steps {
                script {
                  sh 'kill -9 $(cat ./pid.file)'
                }
          }
        }
        
        stage("Push to Git Repository") {
            steps {
                withCredentials([gitUsernamePassword(credentialsId: '171b3da2-feac-454c-8159-64e17860c1ae', gitToolName: 'Default')]) {
                    sh "git push -u origin master"
                }
            }
        }
    }
    post {
        always {
            deleteDir()
        }
    }
}
