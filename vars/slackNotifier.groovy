#!/usr/bin/env groovy

def call(String buildResult) {
  if ( buildResult == "FAILURE" ) {
    slackSend color: "danger", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_DISPLAY_NAME} ${env.BUILD_URL} was failed"
  }
  else if( buildResult == "SUCCESS" ) { 
    slackSend color: "good", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_DISPLAY_NAME} ${env.BUILD_URL} was successful"    
  }
  else if( buildResult == "UNSTABLE" ) { 
    slackSend color: "warning", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_DISPLAY_NAME} ${env.BUILD_URL} was unstable"
  }
  else {
    slackSend color: "danger", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_DISPLAY_NAME} ${env.BUILD_URL} its result was unclear"	
  }
  echo env.COMMITTER
}
