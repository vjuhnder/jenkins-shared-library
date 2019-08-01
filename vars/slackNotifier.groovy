#!/usr/bin/env groovy

def call(String slackData) {
  if ( slackData.result == "FAILURE" ) {
    slackSend color: "danger", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_DISPLAY_NAME} ${env.BUILD_URL} was failed. Committer: ${slackData.user } "
  }
  else if( slackData.result  == "SUCCESS" ) { 
    slackSend color: "good", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_DISPLAY_NAME} ${env.BUILD_URL} was successful. Committer: ${slackData.user } "    
  }
  else if( slackData.result == "UNSTABLE" ) { 
    slackSend color: "warning", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_DISPLAY_NAME} ${env.BUILD_URL} was unstable. Committer: ${slackData.user } "
  }
  else {
    slackSend color: "danger", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_DISPLAY_NAME} ${env.BUILD_URL} its result was unclear. Committer: ${slackData.user } "	
  }
  
}
