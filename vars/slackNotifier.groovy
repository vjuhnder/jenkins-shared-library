#!/usr/bin/env groovy

def call(String slackData) {
  if ( slackData.currentResult == "FAILURE" ) {
    slackSend color: "danger", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_DISPLAY_NAME} ${env.BUILD_URL} was failed. Committer: ${slackData.committer} "
  }
  else if( slackData.currentResult == "SUCCESS" ) { 
    slackSend color: "good", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_DISPLAY_NAME} ${env.BUILD_URL} was successful. Committer: ${slackData.committer} "    
  }
  else if( slackData.currentResult == "UNSTABLE" ) { 
    slackSend color: "warning", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_DISPLAY_NAME} ${env.BUILD_URL} was unstable. Committer: ${slackData.committer} "
  }
  else {
    slackSend color: "danger", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_DISPLAY_NAME} ${env.BUILD_URL} its result was unclear. Committer: ${slackData.committer} "	
  }
  
}
