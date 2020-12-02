pipeline {
  agent any
  stages {
    stage('Stage 1') {
      steps {
        withGradle() {
          build 'gradle-site-plugin'
        }

      }
    }

    stage('Stage 2') {
      steps {
        echo 'Complete?'
      }
    }

  }
}